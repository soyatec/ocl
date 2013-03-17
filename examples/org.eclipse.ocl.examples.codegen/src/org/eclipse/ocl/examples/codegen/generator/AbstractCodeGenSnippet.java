/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.DomainMessage;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.VariableExp;

/**
 * A CodeGenSnippet captures the textual contribution of one or more elements to the generated output.
 */
public abstract class AbstractCodeGenSnippet extends AbstractCodeGenNode implements CodeGenSnippet
{
	private static int snippetCounter = 0;

	/*
	 * Replace the too-specific Pivot classes available during ciode gen by the Domain classes available during execution.
	 */
	public static @NonNull Class<? extends Object> reClass(@NonNull Class<?> javaClass) {
		if (javaClass == Type.class) return DomainType.class;		// FIXME Eliminate Pivot/Domain gap
		return javaClass;
	}

	protected final @NonNull String name;										// Symbol name allocated to this content
	protected final @Nullable TypeId typeId;									// TypeId of this content
	protected @NonNull Class<?> javaClass;										// Java class of the source of this content
	protected @Nullable Object constantValue;									// javaClass instance if CONSTANT
	protected @Nullable CodeGenAnalysis analysis = null;						// Analysis of the primary contributing element
	protected @NonNull Set<Object> elements = new HashSet<Object>();			// Elements for which this snippet defines name and content
	private final @NonNull List<CodeGenNode> contents = new ArrayList<CodeGenNode>();	// Text/nested Snippet contributing to result
	private final int flags;
	private boolean isInvalid = false;
	private boolean isLive = false;
	protected final @NonNull String indentation;
//	private /*@LazyNonNull*/ Set<CodeGenSnippet> dependsOn = null;				// Snippets that must be emitted before this one.
//	private /*@LazyNonNull*/ Set<CodeGenSnippet> dependants = null;				// That require this Snippet to be emitted before them.
	private /*@LazyNonNull*/ List<CodeGenSnippet> dependsOn = null;				// Snippets that must be emitted before this one.
	private /*@LazyNonNull*/ List<CodeGenSnippet> dependants = null;				// That require this Snippet to be emitted before them.
	private /*@LazyNonNull*/ CodeGenSnippet boxedSnippet = null;				// Boxed variant of this snippet, which may be this snippet itself
	private /*@LazyNonNull*/ CodeGenSnippet finalSnippet = null;				// Final variant of this snippet, which may be this snippet itself
	private /*@LazyNonNull*/ CodeGenSnippet unboxedSnippet = null;				// Unboxed variant of this snippet, which may be this snippet itself
	private @Nullable CodeGenSnippet parentSnippet = null;						// Non-null for a nested snippet
	private /*@LazyNonNull*/ CodeGenSnippet caughtSnippet = null;				// Non-null for a caught version of the snippet
	private /*@LazyNonNull*/ CodeGenSnippet thrownSnippet = null;				// Non-null for a thrown version of the snippet
	private /*@LazyNonNull*/ CodeGenSnippet nonNullSnippet = null;				// Non-null for a non-null version of the snippet
	private /*@LazyNonNull*/ Set<String> referencedClasses = null;				// Non-null once a class is referenced

	protected AbstractCodeGenSnippet(@NonNull String indentation, @NonNull CodeGenAnalysis analysis, @NonNull Class<?> javaClass, int flags) {
		super(analysis.getCodeGenerator());
		this.analysis = analysis;
		this.indentation = indentation;
		TypedElement expression = (TypedElement) analysis.getExpression();
		this.typeId = expression.getTypeId();
		this.javaClass = reClass(javaClass);
		CodeGenAnalysis delegatesTo = analysis.getDelegatesTo();
		if (delegatesTo != null) {
			this.name = codeGenerator.getSnippet(delegatesTo.getExpression()).getName();
		}
		else {
			this.name = codeGenerator.getNameManager().getSymbolName(expression);
		}
		this.flags = init(flags);
/*		if (elements.length > 0) {
			Object firstObject = elements[0];
			if (firstObject instanceof Element) {
				@NonNull CodeGenAnalysis analysis = codeGenerator.getAnalysis((Element)firstObject);
				CodeGenAnalysis delegatesTo = analysis.getDelegatesTo();
				if (delegatesTo != null) {
					this.name = codeGenerator.getSnippet(delegatesTo.getExpression()).getName();
				}
				else {
					this.name = codeGenerator.getNameManager().getSymbolName(firstObject);
				}
			}
			else {
				this.name = codeGenerator.getNameManager().getSymbolName(firstObject);
			}
		}
		else {
			this.name = "<<" + snippetCounter++ + ">>";
		}
		for (Object element : elements) {
			this.elements.add(element);
		} */
		elements.add(expression);
		assert analysis.isCatching() == isCaught();
//		assert analysis.isThrowing() && !analysis.isCatching() == isThrown();
	}

	protected AbstractCodeGenSnippet(@NonNull String indentation, @NonNull CodeGenerator codeGenerator, int flags) {
		super(codeGenerator);
		this.indentation = indentation;
		this.typeId = TypeId.OCL_ANY;
		this.javaClass = Object.class;
		this.name = "<<" + snippetCounter++ + ">>";
		this.flags = init(flags);
	}

	/**
	 * Create a clone of a snippet with a given name prefix.
	 */
	protected AbstractCodeGenSnippet(@NonNull AbstractCodeGenSnippet snippet, @NonNull String prefix, @NonNull Class<?> javaClass, int setFlags, int resetFlags) {
		super(snippet.codeGenerator);
//		assert !snippet.isInline();
		this.indentation = snippet.indentation;
		this.analysis = snippet.analysis;
		this.typeId = snippet.typeId;
		this.elements = snippet.elements;
		this.javaClass = javaClass;
		this.name = prefix + snippet.name;			// FIXME make unique
		this.flags = init((snippet.flags | setFlags) & ~resetFlags);
		assert !isInline();
		addDependsOn(snippet);
	}

	protected AbstractCodeGenSnippet(@NonNull String indentation, @NonNull CodeGenerator codeGenerator, @NonNull TypeId typeId, @NonNull Class<?> javaClass, @Nullable Object constantValue, int flags) {
		super(codeGenerator);
		this.indentation = indentation;
		this.typeId = typeId;
		this.javaClass = javaClass;
		this.constantValue = constantValue;
//		assert !(element instanceof Element);
		this.name = codeGenerator.getNameManager().getSymbolName(constantValue);
		this.elements.add(constantValue);
		this.flags = init(flags);
	}

	protected AbstractCodeGenSnippet(@NonNull String name, @Nullable TypeId typeId, @NonNull Class<?> javaClass, @Nullable Object constantValue, @NonNull CodeGenerator codeGenerator, @NonNull String indentation, int flags) {
		super(codeGenerator);
		this.indentation = indentation;
		this.name = name;
		this.typeId = typeId;
		this.javaClass = javaClass;
		this.constantValue = constantValue;
		this.flags = init(flags);
	}

	public void addClassReference(@NonNull String javaClass) {
		if (referencedClasses == null) {
			referencedClasses = new HashSet<String>();
		}
		referencedClasses.add(javaClass);
	}

	public void addClassReference(@NonNull Class<?> javaClass) {
		@SuppressWarnings("null")@NonNull String className = javaClass.getName();//.replace('$', '.');
		addClassReference(className);
	}

	public void addDependsOn(@NonNull CodeGenSnippet cgNode) {
//		assert !isStatic || aSnippet.isStatic();
		assert cgNode != parentSnippet;
//		assert ((AbstractCodeGenSnippet)cgNode).parentSnippet != this;
		if (dependsOn == null) {
			dependsOn = new ArrayList<CodeGenSnippet>();
		}
		if (!dependsOn.contains(cgNode)) {
			dependsOn.add(cgNode);
			cgNode.internalAddDependant(this);
		}
	}

	public void addElement(@NonNull Element element) {
		if (elements.add(element)) {
			codeGenerator.setSnippet(element, this);
		}
	}

	public @NonNull CodeGenText append(@NonNull String string) {
		CodeGenText nestedText = appendIndentedText("");
		nestedText.append(string);
		return nestedText;
	}

	public void appendContentsOf(@NonNull CodeGenSnippet nestedSnippet) {
		assert nestedSnippet.getParent() == null;
//		assert ((AbstractCodeGenSnippet)nestedSnippet).dependsOn == null;
		contents.add(nestedSnippet);
//		nestedSnippet.addDependsOn(this);
		((AbstractCodeGenSnippet)nestedSnippet).parentSnippet = this;
	}

	@Override
	public void appendException(@NonNull Exception e) {
		super.appendException(e);
		append("<<" + e.getClass().getSimpleName() + ">>");
	}
	
	public @Nullable CodeGenSnippet appendBoxedGuardedChild(@NonNull OCLExpression expression, @Nullable DomainMessage nullMessage, @Nullable DomainMessage invalidMessage) {
		CodeGenSnippet childSnippet = codeGenerator.getSnippet(expression);
		if (childSnippet.isContentable(expression)) {
			appendContentsOf(childSnippet);
		}
		if (invalidMessage != null) {
			if (!appendInvalidGuard(childSnippet, invalidMessage)) {
				return null;
			}
		}
		if (nullMessage != null) {
			if (!appendNullGuard(childSnippet, nullMessage)) {
				return null;
			}
		}
		CodeGenSnippet boxedChildSnippet = childSnippet.getBoxedSnippet();
		if ((boxedChildSnippet != childSnippet) && boxedChildSnippet.isContentable(expression)) {
			appendContentsOf(boxedChildSnippet);
		}
		return boxedChildSnippet;
	}

	public @NonNull CodeGenSnippet appendIndentedNodes(@Nullable String indentation, int flags) {
		CodeGenSnippet snippet = codeGenerator.createCodeGenSnippet(indentation, flags);
		appendContentsOf(snippet);
		return snippet;
	}

	public @NonNull CodeGenText appendIndentedText(@Nullable String indentation) {
		CodeGenText text = createCodeGenText(indentation != null ? indentation : codeGenerator.getDefaultIndent());
		contents.add(text);
		return text;
	}

	public void appendReferenceTo(@NonNull Object element) {
		CodeGenSnippet s = codeGenerator.getSnippet(element);
		addDependsOn(s);
		append(s.getName());
	}
	
	public @Nullable CodeGenSnippet appendUnboxedGuardedChild(@NonNull OCLExpression expression, @Nullable DomainMessage nullMessage, @Nullable DomainMessage invalidMessage) {
		CodeGenSnippet childSnippet = codeGenerator.getSnippet(expression);
		CodeGenSnippet unboxedChildSnippet = childSnippet.getUnboxedSnippet();
		if (childSnippet.isContentable(expression)) {
			appendContentsOf(childSnippet);
		}
		if (invalidMessage != null) {
			if (!appendInvalidGuard(childSnippet, invalidMessage)) {
				return null;
			}
		}
		if (nullMessage != null) {
			if (!appendNullGuard(childSnippet, nullMessage)) {
				return null;
			}
		}
		if ((unboxedChildSnippet != childSnippet) && unboxedChildSnippet.isContentable(expression)) {
			appendContentsOf(unboxedChildSnippet);
		}
		return unboxedChildSnippet;
	}

	public @NonNull String atNonNull(boolean suppressWarnings) {
		addClassReference(AbstractCodeGenerator.ORG_ECLIPSE_JDT_ANNOTATION_NON_NULL);
		return codeGenerator.atNonNull(suppressWarnings);
	}

	public @NonNull String atNullable() {
		addClassReference(AbstractCodeGenerator.ORG_ECLIPSE_JDT_ANNOTATION_NULLABLE);
		return codeGenerator.atNullable();
	}

	public boolean checkDependencies(@NonNull LinkedHashMap<CodeGenText, String> emittedTexts, @NonNull Set<CodeGenSnippet> emittedSnippets, @NonNull Set<CodeGenSnippet> startedSnippets, @NonNull HashSet<CodeGenSnippet> knownDependencies) {
		if (knownDependencies.add(this)) {
			CodeGenSnippet parentSnippet2 = parentSnippet;
			if (parentSnippet2 != null) {
				return false;
//				if (!startedSnippets.contains(parentSnippet2)) {
//					return false;
//				}
//				CodeGenNode predecessor = getPredecessor();
//				if (predecessor != null) {
//					CodeGenText lastText = predecessor.getLastText();
//					if ((lastText != null) && !emittedTexts.containsKey(lastText)) {
//						return false;
//					}
//				}
			}
			if (dependsOn != null) {
				for (CodeGenSnippet cgNode : dependsOn) {
					if (!cgNode.isInline() && (!cgNode.isGlobal() || isGlobal())) {
//						if (!emittedSnippets.contains(cgNode)) {
//							return false;
//						}
						CodeGenText lastText = cgNode.getLastText();
						if ((lastText != null) && !emittedTexts.containsKey(lastText)) {
							return false;
						}
//						if (!cgNode.checkDependencies(emittedTexts, emittedSnippets, startedSnippets, knownDependencies)) {
//							return false;
//						}
					}
				}
			}
		}
		return true;
	}

	protected abstract @NonNull CodeGenSnippet createBoxedSnippet();

	protected abstract @NonNull CodeGenText createCodeGenText(@NonNull String indentation);

	protected abstract @NonNull CodeGenSnippet createFinalSnippet();

	protected abstract @NonNull CodeGenSnippet createNonNullSnippet();

	protected abstract @NonNull CodeGenSnippet createUnboxedSnippet();

	public void dispose() {
		for (CodeGenNode content : contents) {
			if (content instanceof AbstractCodeGenSnippet) {
				((AbstractCodeGenSnippet)content).parentSnippet = null;
			}
		}
		contents.clear();
	}

	/**
	 * Return all used code snippets in dependency order (this last).
	 * @return
	 */
	public @NonNull LinkedHashMap<CodeGenText, String> flatten() {
		LinkedHashMap<CodeGenText, String> allContents = new LinkedHashMap<CodeGenText, String>();
		HashSet<CodeGenSnippet> emittedSnippets = new HashSet<CodeGenSnippet>();
		HashSet<CodeGenSnippet> startedSnippets = new HashSet<CodeGenSnippet>();
		flatten(allContents, emittedSnippets, startedSnippets, "");
		return allContents;
	}
	public boolean flatten(@NonNull LinkedHashMap<CodeGenText, String> emittedTexts, @NonNull Set<CodeGenSnippet> emittedSnippets, @NonNull Set<CodeGenSnippet> startedSnippets, @NonNull String outerIndentation) {
//		if (getTypeId() == TypeId.OCL_VOID) {
//			System.out.println("OCL_VOID:" + this);
//			if (dependsOn != null) {
//				for (CodeGenSnippet cgNode : dependsOn) {
//					System.out.println("dependsOn:" + cgNode);
//				}
//			}
//		}		
		String innerIndentation = outerIndentation + indentation;
		boolean addedOne = startedSnippets.add(this);
		if (addedOne) {
			if (dependsOn != null) {
			  int oldSize;
			  do {
				oldSize = emittedTexts.size();
				for (CodeGenSnippet cgNode : dependsOn) {
//					for (CodeGenSnippet parent = cgNode.getParent(); (parent != null) && (parent != this); parent = cgNode.getParent()) {
//						cgNode = parent;
//					}
					if (cgNode.getParent() == null) {
//						cgNode.flatten(emittedTexts, emittedSnippets, startedSnippets, innerIndentation);
//						if (cgNode.checkDependencies(emittedTexts, emittedSnippets, startedSnippets, new HashSet<CodeGenSnippet>())) {
							if (!cgNode.isLive()) {
//								System.out.println("Dead " + cgNode);
							}
							else {
								cgNode.flatten(emittedTexts, emittedSnippets, startedSnippets, innerIndentation);
							}
						}
//					}
				}
			  } while (emittedTexts.size() > oldSize);
			}
			CodeGenAnalysis analysis2 = analysis;
			if (analysis2 != null) {
				Set<CodeGenAnalysis> invalidGuards = analysis2.getInvalidGuards();
				if (invalidGuards != null) {
					for (/*@NonNull*/ CodeGenAnalysis invalidGuard : invalidGuards) {
						if (invalidGuard != null) {
							CodeGenSnippet referredSnippet = codeGenerator.getSnippet(invalidGuard.getExpression());
							appendInvalidGuard(referredSnippet, DomainMessage.INVALID);
						}
					}
				}
				Set<CodeGenAnalysis> nullGuards = analysis2.getNullGuards();
				if (nullGuards != null) {
					for (/*@NonNull*/ CodeGenAnalysis nullGuard : nullGuards) {
						if (nullGuard != null) {
							CodeGenSnippet referredSnippet = codeGenerator.getSnippet(nullGuard.getExpression());
							appendNullGuard(referredSnippet, DomainMessage.NULL);
						}
					}
				}
			}
			for (CodeGenNode aContent : contents) {
				aContent.flatten(emittedTexts, emittedSnippets, startedSnippets, innerIndentation);
			}
			emittedSnippets.add(this);
			if (dependants != null) {
			  int oldSize;
			  do {
				oldSize = emittedTexts.size();
				for (CodeGenSnippet cgNode : new ArrayList<CodeGenSnippet>(dependants)) {		// FIXME Avoid CME hazard from try{} transfer
//					for (CodeGenSnippet parent = cgNode.getParent(); (parent != null) && (parent != this); parent = cgNode.getParent()) {
//						cgNode = parent;
//					}
					if (cgNode.checkDependencies(emittedTexts, emittedSnippets, startedSnippets, new HashSet<CodeGenSnippet>())) {
						if (!cgNode.isLive()) {
//							System.out.println("Dead " + cgNode);
						}
						else if (!isGlobal() || (isGlobal() && cgNode.isGlobal())) {
							cgNode.flatten(emittedTexts, emittedSnippets, startedSnippets, innerIndentation);
						}
					}
				}
			  } while (emittedTexts.size() > oldSize);
			}
		}
		return addedOne;
	}

	public void gatherLiveSnippets(@NonNull Set<CodeGenSnippet> liveSnippets, @NonNull Set<String> referencedClasses) {
		if (liveSnippets.add(this)) {
			setIsLive();
			if (this.referencedClasses != null) {
				referencedClasses.addAll(this.referencedClasses);
			}
			if (parentSnippet != null) {
				parentSnippet.gatherLiveSnippets(liveSnippets, referencedClasses);
			}
			for (CodeGenNode content : contents) {
				if (content instanceof CodeGenSnippet) {
					((CodeGenSnippet)content).gatherLiveSnippets(liveSnippets, referencedClasses);
				}
			}
			if (dependants != null) {
				for (CodeGenSnippet dependent : new ArrayList<CodeGenSnippet>(dependants)) {
					for (CodeGenSnippet ancestor = this; ancestor != null; ancestor = ancestor.getParent()) {
//						assert dependent != ancestor;		// Too hard to avoid so just clean up instead
						if (dependent == ancestor) {
							dependants.remove(dependent);
							((AbstractCodeGenSnippet)dependent).dependsOn.remove(this);
						}
					}
				}
			}
			if (dependsOn != null) {
				for (CodeGenSnippet dependency : new ArrayList<CodeGenSnippet>(dependsOn)) {		// FIXME Eliminate need fopr CME guard
					for (CodeGenSnippet ancestor = this; ancestor != null; ancestor = ancestor.getParent()) {
//						assert dependency != ancestor;
					}
					dependency.gatherLiveSnippets(liveSnippets, referencedClasses);
				}
			}
			CodeGenAnalysis analysis2 = analysis;
			if (analysis2 != null) {
				Set<CodeGenAnalysis> invalidGuards = analysis2.getInvalidGuards();
				if (invalidGuards != null) {
					referencedClasses.add(InvalidValueException.class.getName());
				}
				Set<CodeGenAnalysis> nullGuards = analysis2.getNullGuards();
				if (nullGuards != null) {
					referencedClasses.add(InvalidValueException.class.getName());
				}
			}
		}
	}

//	public @Nullable CodeGenAnalysis getAnalysis() {
//		return analysis;
//	}

	protected @NonNull Class<?> getBoxedClass() {
		return typeId != null ? codeGenerator.getBoxedClass(typeId) : javaClass;
	}

	public @NonNull CodeGenSnippet getBoxedSnippet() {
		CodeGenSnippet boxedSnippet2 = boxedSnippet;
		if (boxedSnippet2 == null) {
			boxedSnippet = boxedSnippet2 = createBoxedSnippet();
			((AbstractCodeGenSnippet)boxedSnippet2).unboxedSnippet = this;
		}
		return boxedSnippet2;
	}
	
	public @Nullable Object getConstantValue() {
		assert isConstant();
		return constantValue;
	}

	public @NonNull List<CodeGenNode> getContents() {
		return contents;
	}

	public @Nullable Iterable<CodeGenSnippet> getDependsOn() {
		return dependsOn;
	}

	public @NonNull CodeGenSnippet getFinalSnippet() {
		CodeGenSnippet finalSnippet2 = finalSnippet;
		if (finalSnippet2 == null) {
			finalSnippet = finalSnippet2 = createFinalSnippet();
		}
		return finalSnippet2;
	}

	public int getFlags() {
		return flags;
	}

	public @NonNull String getImportedName(@NonNull Class<?> javaClass) {
		addClassReference(javaClass);
		return codeGenerator.getImportedName2(javaClass);
	}

	public @NonNull String getImportedName(@NonNull String javaClass) {
		addClassReference(javaClass);
		return codeGenerator.getImportManager().getImportedName(javaClass);
	}

	public @NonNull String getIndentation() {
		return indentation;
	}

	public @NonNull Class<?> getJavaClass() {
		return javaClass;
	}

	public @NonNull String getJavaClassName() {
		return getImportedName(javaClass);
	}

	public @Nullable CodeGenText getLastText() {
		for (int i = contents.size(); --i >= 0; ) {
			CodeGenNode codeGenNode = contents.get(i);
			CodeGenText finalText = codeGenNode.getLastText();
			if (finalText != null) {
				return finalText;
			}
		}
		CodeGenSnippet parentSnippet2 = parentSnippet;
		if (parentSnippet2 == null) {
			return null;
		}
		for (CodeGenNode predecessor = getPredecessor(); predecessor != null; predecessor = ((CodeGenSnippet)predecessor).getPredecessor()) {
			CodeGenText finalText = predecessor.getLastText();
			if (finalText != null) {
				return finalText;
			}
		}
		return null;
	}

	public @NonNull String getName() {
		return name;
	}

	public @NonNull CodeGenSnippet getNonNullSnippet() {
		CodeGenSnippet nonNullSnippet2 = nonNullSnippet;
		if (nonNullSnippet2 == null) {
			nonNullSnippet = nonNullSnippet2 = createNonNullSnippet();
		}
		return nonNullSnippet2;
	}

	public @Nullable CodeGenSnippet getParent() {
		return parentSnippet;
	}

	public @Nullable CodeGenNode getPredecessor() {
		CodeGenSnippet parentSnippet2 = parentSnippet;
		if (parentSnippet2 == null) {
			return null;
		}
		List<CodeGenNode> contents2 = parentSnippet2.getContents();
		int indexOf = contents2.indexOf(this);
		if (indexOf <= 0) {
			return parentSnippet2.getPredecessor();
		}
		else {
			return contents2.get(indexOf-1);
		}
	}

	public @NonNull CodeGenSnippet getSnippet(@Nullable Object anObject) {
		CodeGenSnippet constant = codeGenerator.getSnippet(anObject);
		if (!constant.isInline()) {
			addDependsOn(constant);
		}
		return constant;
	}

	public @Nullable TypeId getTypeId() {
		return typeId;
	}

	protected @NonNull Class<?> getUnboxedClass() {
		return typeId != null ? codeGenerator.getUnboxedClass(typeId) : javaClass;
	}

	public @NonNull CodeGenSnippet getUnboxedSnippet() {
		CodeGenSnippet unboxedSnippet2 = unboxedSnippet;
		if (unboxedSnippet2 == null) {
			unboxedSnippet = unboxedSnippet2 = createUnboxedSnippet();
			((AbstractCodeGenSnippet)unboxedSnippet2).boxedSnippet = this;
		}
		return unboxedSnippet2;
	}
	
	private int init(int flags) {
		Class<?> boxedClass;
		Class<?> unboxedClass;
		if (EnumerationLiteralId.class.isAssignableFrom(javaClass)) {
			boxedClass = EnumerationLiteralId.class;
			unboxedClass = EEnumLiteral.class;
		}
		else if (ElementId.class.isAssignableFrom(javaClass)) {
			boxedClass = javaClass;
			unboxedClass = javaClass;
		}
		else {
			boxedClass = getBoxedClass();
			unboxedClass = getUnboxedClass();
		}
		if ((flags & BOXED) != 0) {
			if (((flags & ERASED) == 0) && !boxedClass.isAssignableFrom(javaClass)) {
//			if (((flags & ERASED) == 0) && !javaClass.isAssignableFrom(boxedClass)) {
//				System.out.println(javaClass.getName() + " is not assignable to boxed: " + boxedClass.getName());
			}
			boxedSnippet = this;
		}
		else if (boxedClass.isAssignableFrom(javaClass)) {
			flags |= BOXED;
			boxedSnippet = this;
		}
		if ((flags & UNBOXED) != 0) {
//			assert unboxedClass.isAssignableFrom(javaClass);
			if (((flags & ERASED) == 0) && !unboxedClass.isAssignableFrom(javaClass)) {
//			if (((flags & ERASED) == 0) && !javaClass.isAssignableFrom(unboxedClass)) {
//				System.out.println(javaClass.getName() + " is not assignable to unboxed: " + unboxedClass.getName());
			}
			unboxedSnippet = this;
		}
		else if (unboxedClass.isAssignableFrom(javaClass)) {
			flags |= UNBOXED;
			unboxedSnippet = this;
		}
		else if (unboxedClass == boxedClass) {
			flags |= UNBOXED;
			unboxedSnippet = this;
		}
		assert ((flags & MUTABLE) == 0) || ((flags & UNASSIGNED) == 0);
		if ((flags & (MUTABLE|UNASSIGNED)) != 0) {
			finalSnippet = this;
		}
		if ((flags & CAUGHT) == 0) {
			thrownSnippet = this;
		}
		if ((flags & THROWN) == 0) {
			caughtSnippet = this;
		}
		if ((flags & NON_NULL) != 0) {
			nonNullSnippet = this;
		}
		assert (boxedSnippet != null) || (unboxedSnippet != null);
		assert (caughtSnippet != null) || (thrownSnippet != null);
		CodeGenAnalysis analysis2 = analysis;
		if (analysis2 != null) {
			if (analysis2.mayBeException() || analysis2.mayBeInvalidValue()) {
				assert ((flags & THROWN) != 0) || ((flags & CAUGHT) != 0);
			}
		}
		isLive = (flags & LIVE) != 0;
		isInvalid = (flags & INVALID) != 0;
//		if (DomainType.class.isAssignableFrom(javaClass)) {
//			assert (flags & BOXED) == 0;
//		}
		return flags & ~(INVALID|LIVE);
	}

	public void internalAddDependant(@NonNull CodeGenSnippet cgNode) {
		if (dependants == null) {
			dependants = new ArrayList<CodeGenSnippet>();
		}
		if (!dependants.contains(cgNode)) {
			dependants.add(cgNode);
		}
	}

	public boolean isBoxed() {
		return (flags & BOXED) != 0;
	}

	public boolean isCaught() {
		return (flags & CAUGHT) != 0;
	}

	public boolean isConstant() {
		return (flags & CONSTANT) != 0;
	}

	public boolean isContentable(@NonNull OCLExpression sourceExpression) {
		if (isInline()) {				// Inline snippets replicated per usage
			return false;
		}
		if (isGlobal()) {				// Global snippets shared at root-global scope
			return false;
		}
		if (isSynthesized()) {			// Synthesized snippets shared where dependencies direct
			return false;
		}
		return !(sourceExpression instanceof VariableExp);
	}

	public boolean isErased() {
		return (flags & ERASED) != 0;
	}

	public boolean isFinal() {
		return (flags & (MUTABLE|UNASSIGNED)) == 0;
	}

	public boolean isGlobal() {
		return (flags & GLOBAL) != 0;
	}

	public boolean isInline() {
		return (flags & INLINE) != 0;
	}

	public boolean isInvalid() {
		return isInvalid;
	}

	public boolean isLive() {
		return isLive;
	}

	public boolean isMutable() {
		return (flags & MUTABLE) != 0;
	}

	public boolean isNonInvalid() {
		return (!isCaught() && !isInvalid() && !isThrown()) || (isConstant() && !isInvalid());
	}

	public boolean isNonNull() {
		return (flags & NON_NULL) != 0;
	}

	public boolean isNull() {
		if (analysis != null) {
			return analysis.isNull();
		}
		else {
			return (typeId == null) && "null".equals(name);		// FIXME matches JavaConstantHelper.createNullValue
		}
	}
	
	public boolean isSuppressNonNullWarnings() {
		return (flags & SUPPRESS_NON_NULL_WARNINGS) != 0;
	}

	public boolean isSynthesized() {
		return (flags & SYNTHESIZED) != 0;
	}

	public boolean isThrown() {
		return (flags & THROWN) != 0;
	}

	public boolean isUnassigned() {
		return (flags & UNASSIGNED) != 0;
	}

	public boolean isUnboxed() {
		return (flags & UNBOXED) != 0;
	}

	protected void setInvalid() {
		isInvalid = true;
	}

	private void setIsLive() {
		isLive = true;
	}

	@Override
	public String toString() {
		return toString("\n");
	}

	public void toString(@NonNull StringBuilder s, @NonNull String indentation) {
		s.append("<<" +getName() + ">>");
	}

	public String toString(@NonNull String indent) {
		StringBuilder s = new StringBuilder();
		s.append(name);
		if (flags != 0) {
			s.append(" { ");
		}
		if (isBoxed()) {
			s.append("Boxed ");
		}
		if (isCaught()) {
			s.append("Caught ");
		}
		if (isConstant()) {
			s.append("Constant ");
		}
		if (isErased()) {
			s.append("Erased ");
		}
		if (isFinal()) {
			s.append("Final ");
		}
		if (isGlobal()) {
			s.append("Global ");
		}
		if (isInline()) {
			s.append("Inline ");
		}
		if (isInvalid()) {
			s.append("Invalid ");
		}
		if (isLive()) {
			s.append("Live ");
		}
		if (isNonNull()) {
			s.append("NonNull ");
		}
		if (isSynthesized()) {
			s.append("Synthesized ");
		}
		if (isThrown()) {
			s.append("Thrown ");
		}
		if (isUnboxed()) {
			s.append("Unboxed ");
		}
		if (flags != 0) {
			s.append("}");
		}
		String joiner = ": ";
		for (CodeGenNode content : contents) {
			s.append(joiner);
			content.toString(s, "");
			joiner = "+";
		}
		return s.toString();
	}
}
