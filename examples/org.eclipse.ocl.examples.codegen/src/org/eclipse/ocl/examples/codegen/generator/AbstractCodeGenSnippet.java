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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.TypedElement;

/**
 * A CodeGenSnippet captures the textual contribution of one or more elements to the generated output.
 */
public abstract class AbstractCodeGenSnippet extends AbstractCodeGenNode implements CodeGenSnippet
{
	private static int snippetCounter = 0;

	protected final @NonNull String name;										// Symbol name allocated to this content
	protected final @NonNull TypeId typeId;										// TypeId of this content
	protected @NonNull Class<?> javaClass;										// Java class of the source of this content
	protected @Nullable CodeGenAnalysis analysis = null;						// Analysis of the primary contributing element
	protected @NonNull Set<Object> elements = new HashSet<Object>();			// Elements for which this snippet defines name and content
	private final @NonNull List<CodeGenNode> contents = new ArrayList<CodeGenNode>();	// Text/nested Snippet contributing to result
	private final int flags;
//	private boolean isLocal = false;
//	private boolean isStatic = false;
//	protected /*final*/ boolean isInlined;
	protected final @NonNull String indentation;
	private /*@LazyNonNull*/ Set<CodeGenSnippet> dependsOn = null;				// Snippets that must be emitted before this one.
	private /*@LazyNonNull*/ Set<CodeGenSnippet> dependants = null;				// That require this Snippet to be emitted before them.
	private /*@LazyNonNull*/ CodeGenSnippet boxedSnippet = null;				// Boxed variant of this snippet, which may be this snippet itself
	private /*@LazyNonNull*/ CodeGenSnippet finalSnippet = null;				// Final variant of this snippet, which may be this snippet itself
	private /*@LazyNonNull*/ CodeGenSnippet unboxedSnippet = null;				// Unboxed variant of this snippet, which may be this snippet itself
	private @Nullable CodeGenSnippet parentSnippet = null;						// Non-null for a nested snippet
	private /*@LazyNonNull*/ CodeGenSnippet caughtSnippet = null;						// Non-null for a caught version of the snippet
	private /*@LazyNonNull*/ CodeGenSnippet thrownSnippet = null;						// Non-null for a thrown version of the snippet

	protected AbstractCodeGenSnippet(@NonNull String indentation, @NonNull CodeGenAnalysis analysis, @NonNull Class<?> javaClass, int flags) {
		super(analysis.getCodeGenerator());
		this.analysis = analysis;
		this.indentation = indentation;
		TypedElement expression = (TypedElement) analysis.getExpression();
		this.typeId = expression.getTypeId();
		this.javaClass = javaClass;
		CodeGenAnalysis delegatesTo = analysis.getDelegatesTo();
		if (delegatesTo != null) {
			this.name = codeGenerator.getSnippet(delegatesTo.getExpression()).getName();
		}
		else {
			this.name = codeGenerator.getNameManager().getSymbolName(expression);
		}
		this.flags = initBoxing(flags);
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
	}

	protected AbstractCodeGenSnippet(@NonNull String indentation, @NonNull CodeGenerator codeGenerator) {
		super(codeGenerator);
		this.indentation = indentation;
		this.typeId = TypeId.OCL_ANY;
		this.javaClass = Object.class;
		this.name = "<<" + snippetCounter++ + ">>";
		this.flags = initBoxing(0);
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
		this.flags = initBoxing((snippet.flags | setFlags) & ~resetFlags);
		assert !isInline();
		addDependsOn(snippet);
	}

	protected AbstractCodeGenSnippet(@NonNull String indentation, @NonNull CodeGenerator codeGenerator, @NonNull TypeId typeId, @NonNull Class<?> javaClass, @NonNull Object element, int flags) {
		super(codeGenerator);
		this.indentation = indentation;
		this.typeId = typeId;
		this.javaClass = javaClass;
		assert !(element instanceof Element);
		if (element instanceof Element) {
			analysis = codeGenerator.getAnalysis((Element)element);
			CodeGenAnalysis delegatesTo = analysis.getDelegatesTo();
			if (delegatesTo != null) {
				this.name = codeGenerator.getSnippet(delegatesTo.getExpression()).getName();
			}
			else {
				this.name = codeGenerator.getNameManager().getSymbolName(element);
			}
		}
		else {
			this.name = codeGenerator.getNameManager().getSymbolName(element);
		}
		this.elements.add(element);
		this.flags = initBoxing(flags);
	}

	protected AbstractCodeGenSnippet(@NonNull String name, @NonNull TypeId typeId, @NonNull Class<?> javaClass, @NonNull CodeGenerator codeGenerator, @NonNull String indentation, int flags) {
		super(codeGenerator);
		this.indentation = indentation;
		this.name = name;
		this.typeId = typeId;
		this.javaClass = javaClass;
		this.flags = initBoxing(flags);
	}

	public void addDependsOn(@NonNull CodeGenSnippet cgNode) {
//		assert !isStatic || aSnippet.isStatic();
		assert cgNode != parentSnippet;
//		assert ((AbstractCodeGenSnippet)cgNode).parentSnippet != this;
		if (dependsOn == null) {
			dependsOn = new HashSet<CodeGenSnippet>();
		}
		dependsOn.add(cgNode);
		cgNode.internalAddDependant(this);
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
		assert ((AbstractCodeGenSnippet)nestedSnippet).parentSnippet == null;
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

	public @NonNull CodeGenSnippet appendIndentedNodes(@Nullable String indentation) {
		CodeGenSnippet snippet = codeGenerator.createCodeGenSnippet(indentation);
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

/*	public void appendReferenceTo(@NonNull OCLExpression element, @NonNull Type requiredType) {
		try {
			Class<?> requiredClass = codeGenerator.getGenModelHelper().getEcoreInterfaceClass(requiredType);
			CodeGenSnippet s = codeGenerator.getSnippet(element);
			addDependsOn(s);
			Class<?> actualClass = s.getJavaClass();
			if (!requiredClass.isAssignableFrom(actualClass)) {
				append("((" + codeGenerator.getImportedName(requiredClass) + ')' + s.getName() + ')');
			}
			else {
				append(s.getName());
			}
		} catch (GenModelException e) {
			appendException(e);
		}
	} */

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
					if (!cgNode.isInline()) {
//						if (!emittedSnippets.contains(cgNode)) {
//							return false;
//						}
						CodeGenText lastText = cgNode.getLastText();
						if (!emittedTexts.containsKey(lastText)) {
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

/*	private @Nullable CodeGenText getPrecedingText() {
		CodeGenSnippet parentSnippet2 = parentSnippet;
		if (parentSnippet2 == null) {
			return null;
		}
		List<CodeGenNode> contents2 = parentSnippet2.getContents();
		int indexOf = contents2.indexOf(this);
		if (indexOf > 0) {
			CodeGenNode predecessor = contents2.get(indexOf-1);
			if (predecessor instanceof CodeGenText) {
				if (!emittedTexts.containsKey(predecessor)) {
					return false;
				}
			}
			else if (predecessor instanceof CodeGenSnippet) {
				if (!emittedSnippets.contains(predecessor)) {
					return false;
				}
			}
		}
		return null;
	} */

	protected abstract @NonNull CodeGenSnippet createBoxedSnippet();

	protected abstract @NonNull CodeGenSnippet createCaughtSnippet();

	protected abstract @NonNull CodeGenText createCodeGenText(@NonNull String indentation);

	protected abstract @NonNull CodeGenSnippet createFinalSnippet();

	protected abstract @NonNull CodeGenSnippet createThrownSnippet();

	protected abstract @NonNull CodeGenSnippet createUnboxedSnippet();

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
		String innerIndentation = outerIndentation + indentation;
		boolean addedOne = startedSnippets.add(this);
		if (addedOne) {
			if (dependsOn != null) {
				for (CodeGenSnippet cgNode : dependsOn) {
					if (((AbstractCodeGenSnippet)cgNode).parentSnippet == null) {
						cgNode.flatten(emittedTexts, emittedSnippets, startedSnippets, innerIndentation);
					}
				}
			}
			for (CodeGenNode aContent : contents) {
				aContent.flatten(emittedTexts, emittedSnippets, startedSnippets, innerIndentation);
			}
			emittedSnippets.add(this);
			if (dependants != null) {
				for (CodeGenSnippet cgNode : dependants) {
					if (cgNode.checkDependencies(emittedTexts, emittedSnippets, startedSnippets, new HashSet<CodeGenSnippet>())) {
						cgNode.flatten(emittedTexts, emittedSnippets, startedSnippets, innerIndentation);
					}
				}
			}
		}
		return addedOne;
	}

	public @NonNull CodeGenSnippet getBoxedSnippet() {
		assert (boxedSnippet != null) || (unboxedSnippet != null);
		CodeGenSnippet boxedSnippet2 = boxedSnippet;
		if (boxedSnippet2 == null) {
			boxedSnippet = boxedSnippet2 = createBoxedSnippet();
			((AbstractCodeGenSnippet)boxedSnippet).unboxedSnippet = this;
		}
		return boxedSnippet2;
	}

	public @NonNull CodeGenSnippet getCaughtSnippet() {
		assert (boxedSnippet != null) || (unboxedSnippet != null);
		CodeGenSnippet caughtSnippet2 = caughtSnippet;
		if (caughtSnippet2 == null) {
			caughtSnippet = caughtSnippet2 = createCaughtSnippet();
		}
		return caughtSnippet2;
	}

	public @NonNull List<CodeGenNode> getContents() {
		return contents;
	}

	public @NonNull CodeGenSnippet getFinalSnippet() {
		assert (boxedSnippet != null) || (unboxedSnippet != null);
		CodeGenSnippet finalSnippet2 = finalSnippet;
		if (finalSnippet2 == null) {
			finalSnippet = finalSnippet2 = createFinalSnippet();
		}
		return finalSnippet2;
	}

	public @NonNull String getIndentation() {
		return indentation;
	}

	public @NonNull Class<?> getJavaClass() {
		return javaClass;
	}

	public @NonNull String getJavaClassName() {
		return codeGenerator.getImportedName(javaClass);
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

	public @NonNull String getSnippetName(@Nullable Object anObject) {
		return getSnippet(anObject).getName();
	}

	public @NonNull CodeGenSnippet getThrownSnippet() {
		assert (boxedSnippet != null) || (unboxedSnippet != null);
		CodeGenSnippet thrownSnippet2 = thrownSnippet;
		if (thrownSnippet2 == null) {
			thrownSnippet = thrownSnippet2 = createThrownSnippet();
		}
		return thrownSnippet2;
	}

	public @NonNull TypeId getTypeId() {
		return typeId;
	}

	public @NonNull CodeGenSnippet getUnboxedSnippet() {
		assert (boxedSnippet != null) || (unboxedSnippet != null);
		CodeGenSnippet unboxedSnippet2 = unboxedSnippet;
		if (unboxedSnippet2 == null) {
			unboxedSnippet = unboxedSnippet2 = createUnboxedSnippet();
			((AbstractCodeGenSnippet)unboxedSnippet).boxedSnippet = this;
		}
		return unboxedSnippet2;
	}

	private int initBoxing(int flags) {
		boolean isId = ElementId.class.isAssignableFrom(javaClass);
		Class<?> boxedClass = isId ? javaClass : codeGenerator.getBoxedClass(typeId);
		Class<?> unboxedClass = isId ? javaClass : codeGenerator.getUnboxedClass(typeId);
		if ((flags & BOXED) != 0) {
			if (((flags & ERASED) == 0) && !boxedClass.isAssignableFrom(javaClass)) {
//			if (((flags & ERASED) == 0) && !javaClass.isAssignableFrom(boxedClass)) {
				System.out.println(javaClass.getName() + " is not assignable to boxed: " + boxedClass.getName());
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
				System.out.println(javaClass.getName() + " is not assignable to unboxed: " + unboxedClass.getName());
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
		if ((flags & FINAL) != 0) {
			finalSnippet = this;
		}
		if ((flags & CAUGHT) == 0) {
			thrownSnippet = this;
		}
		if ((flags & THROWN) == 0) {
			caughtSnippet = this;
		}
		assert (boxedSnippet != null) || (unboxedSnippet != null);
		assert (caughtSnippet != null) || (thrownSnippet != null);
		CodeGenAnalysis analysis2 = analysis;
		if (analysis2 != null) {
			if (analysis2.mayBeException() || analysis2.mayBeInvalidValue()) {
				assert ((flags & THROWN) != 0) || ((flags & CAUGHT) != 0);
			}
		}
		return flags;
	}

	public void internalAddDependant(@NonNull CodeGenSnippet cgNode) {
		if (dependants == null) {
			dependants = new HashSet<CodeGenSnippet>();
		}
		dependants.add(cgNode);
	}

	public boolean isBoxed() {
		return (flags & BOXED) != 0;
	}

	public boolean isCaught() {
		return (flags & CAUGHT) != 0;
	}

	public boolean isErased() {
		return (flags & ERASED) != 0;
	}

	public boolean isFinal() {
		return (flags & FINAL) != 0;
	}

	public boolean isInline() {
		return (flags & INLINE) != 0;
	}

	public boolean isLocal() {
		return (flags & LOCAL) != 0;
	}

	public boolean isNonNull() {
		return (flags & NON_NULL) != 0;
	}

	public boolean isNull() {
		return (analysis != null) && analysis.isNull();
	}

	public boolean isThrown() {
		return (flags & THROWN) != 0;
	}

	public boolean isUnboxed() {
		return (flags & UNBOXED) != 0;
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
		if (isErased()) {
			s.append("Erased ");
		}
		if (isFinal()) {
			s.append("Final ");
		}
		if (isInline()) {
			s.append("Inline ");
		}
		if (isLocal()) {
			s.append("Local ");
		}
		if (isNonNull()) {
			s.append("NonNull ");
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
//		String string = this.s.toString();
//		if (string.length() > 0) {
//			s.append(joiner + '"' + Strings.convertToJavaString(string) + '"');
//		}
		return s.toString();
	}
}
