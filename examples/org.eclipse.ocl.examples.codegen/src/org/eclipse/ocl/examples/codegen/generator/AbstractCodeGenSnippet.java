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
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * A CodeGenSnippet captures the textual contribution of one or more elements to the generated output.
 */
public abstract class AbstractCodeGenSnippet extends AbstractCodeGenNode implements CodeGenSnippet
{
	private static int snippetCounter = 0;

	protected final @NonNull String name;										// Symbol name allocated to this content
	protected final @NonNull TypeId typeId;										// TypeId of this content
	protected @Nullable Class<?> javaClass = null;								// Java class of this content
	protected @NonNull Set<Object> elements = new HashSet<Object>();			// Elements for which this snippet defines name and content
	private final @NonNull List<CodeGenNode> contents = new ArrayList<CodeGenNode>();	// Text/nested Snippet contributing to result
//	private boolean isLocal = false;
//	private boolean isStatic = false;
	private boolean isInlined = false;
	protected final @NonNull String indentation;
	private /*@LazyNonNull*/ Set<CodeGenSnippet> dependsOn = null;				// Snippets that must be emitted before this one.
	private /*@LazyNonNull*/ Set<CodeGenSnippet> dependants = null;				// That require this Snippet to be emitted before them.
	private /*@LazyNonNull*/ CodeGenSnippet boxedSnippet = null;				// Boxed variant of this snippet, which may be this snippet itself
	private /*@LazyNonNull*/ CodeGenSnippet finalSnippet = null;				// Final variant of this snippet, which may be this snippet itself
	private /*@LazyNonNull*/ CodeGenSnippet unboxedSnippet = null;				// Unboxed variant of this snippet, which may be this snippet itself
	
	public AbstractCodeGenSnippet(@NonNull CodeGenerator codeGenerator, @NonNull String indentation, @NonNull TypeId typeId, @NonNull Object... elements) {
		super(codeGenerator);
		this.indentation = indentation;
		this.typeId = typeId;
		if (elements.length > 0) {
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
		}
	}

	public AbstractCodeGenSnippet(@NonNull String name, @NonNull TypeId typeId, @Nullable Class<?> javaClass, @NonNull CodeGenerator codeGenerator, @NonNull String indentation) {
		super(codeGenerator);
		this.indentation = indentation;
		this.name = name;
		this.typeId = typeId;
		this.javaClass = javaClass;
	}

	public void addDependsOn(@NonNull CodeGenSnippet cgNode) {
//		assert !isStatic || aSnippet.isStatic();
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

	public @NonNull CodeGenText appendIndentedText(@Nullable String indentation) {
		CodeGenText text = createCodeGenText(indentation != null ? indentation : codeGenerator.getDefaultIndent());
		contents.add(text);
		return text;
	}

	public void appendContentsOf(@NonNull CodeGenSnippet nestedSnippet) {
		contents.add(nestedSnippet);
		nestedSnippet.addDependsOn(this);
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
	
	public @NonNull CodeGenSnippet appendNestedContents() {
		CodeGenSnippet snippet = codeGenerator.createCodeGenSnippet("");
		appendContentsOf(snippet);
		return snippet;
	}

	public void appendReferenceTo(@NonNull Object element) {
		CodeGenSnippet s = codeGenerator.getSnippet(element);
		addDependsOn(s);
		append(s.getName());
	}

	public void appendReferenceTo(@NonNull OCLExpression element, @NonNull Type requiredType) {
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
	}

	public boolean checkDependencies(@NonNull Set<CodeGenSnippet> knownSnippets) {
		for (CodeGenSnippet cgNode : dependsOn) {
			if (!knownSnippets.contains(cgNode)) {
				return false;
			}
		}
		return true;
	}

	protected abstract @NonNull CodeGenSnippet createBoxedSnippet();

	protected abstract @NonNull AbstractCodeGenText createCodeGenText(@NonNull String indentation);

	protected abstract @NonNull CodeGenSnippet createFinalSnippet();

	protected abstract @NonNull CodeGenSnippet createUnboxedSnippet();

	/**
	 * Return all used code snippets in dependency order (this last).
	 * @return
	 */
	public @NonNull LinkedHashMap<CodeGenText, String> flatten() {
		LinkedHashMap<CodeGenText, String> allContents = new LinkedHashMap<CodeGenText, String>();
		HashSet<CodeGenSnippet> knownSnippets = new HashSet<CodeGenSnippet>();
		flatten(knownSnippets, allContents, "");
		return allContents;
	}
	public boolean flatten(@NonNull Set<CodeGenSnippet> knownSnippets, @NonNull LinkedHashMap<CodeGenText, String> allContents, @NonNull String outerIndentation) {
		String innerIndentation = outerIndentation + indentation;
		boolean addedOne = knownSnippets.add(this);
		if (addedOne) {
			if (dependsOn != null) {
				for (CodeGenSnippet cgNode : dependsOn) {
					cgNode.flatten(knownSnippets, allContents, innerIndentation);
				}
			}
			for (CodeGenNode aContent : contents) {
				aContent.flatten(knownSnippets, allContents, innerIndentation);
			}
			if (dependants != null) {
				for (CodeGenSnippet cgNode : dependants) {
					if (cgNode.checkDependencies(knownSnippets)) {
						cgNode.flatten(knownSnippets, allContents, innerIndentation);
					}
				}
			}
		}
		return addedOne;
	}

	public @NonNull CodeGenSnippet getBoxedSnippet() {
		CodeGenSnippet boxedSnippet2 = boxedSnippet;
		if (boxedSnippet2 == null) {
			boxedSnippet = boxedSnippet2 = createBoxedSnippet();
			((AbstractCodeGenSnippet)boxedSnippet).unboxedSnippet = this;
		}
		return boxedSnippet2;
	}

	public @NonNull CodeGenSnippet getFinalSnippet() {
		CodeGenSnippet finalSnippet2 = finalSnippet;
		if (finalSnippet2 == null) {
			finalSnippet = finalSnippet2 = createFinalSnippet();
		}
		return finalSnippet2;
	}

	public @NonNull CodeGenSnippet getUnboxedSnippet() {
		CodeGenSnippet unboxedSnippet2 = unboxedSnippet;
		if (unboxedSnippet2 == null) {
			unboxedSnippet = unboxedSnippet2 = createUnboxedSnippet();
			((AbstractCodeGenSnippet)unboxedSnippet).boxedSnippet = this;
		}
		return unboxedSnippet2;
	}

	public @NonNull List<CodeGenNode> getContents() {
		return contents;
	}

	public @NonNull String getIndentation() {
		return indentation;
	}

	public @NonNull Class<?> getJavaClass() {
		return javaClass != null ? javaClass : Object.class;
	}

	public @NonNull String getJavaClassName() {
		return codeGenerator.getImportedName(javaClass != null ? javaClass : Object.class);
	}

	public @NonNull String getName() {
		return name;
	}

	public @NonNull CodeGenSnippet getSnippet(@Nullable Object anObject) {
		CodeGenSnippet constant = codeGenerator.getSnippet(anObject);
		if (!constant.isInlined()) {
			addDependsOn(constant);
		}
		return constant;
	}

	public @NonNull String getSnippetName(@Nullable Object anObject) {
		return getSnippet(anObject).getName();
	}

	public @NonNull TypeId getTypeId() {
		return typeId;
	}

	public void internalAddDependant(@NonNull CodeGenSnippet cgNode) {
		if (dependants == null) {
			dependants = new HashSet<CodeGenSnippet>();
		}
		dependants.add(cgNode);
	}

	public boolean isBoxed() {
		return boxedSnippet == this;
	}

	public boolean isFinal() {
		return finalSnippet == this;
	}

	public boolean isInlined() {
		return isInlined;
	}

	public boolean isUnboxed() {
		return unboxedSnippet == this;
	}

	public void setBoxed(@NonNull Class<?> boxedClass) {
		assert this.javaClass == null;
		assert boxedSnippet == null;
		boxedSnippet = this;
		this.javaClass = boxedClass;
	}

	public void setIsFinal() {
		assert finalSnippet == null;
		finalSnippet = this;
	}

	public void setIsInlined() {
		isInlined = true;
	}

	public void setJavaClass(@NonNull Class<?> javaClass) {
		assert this.javaClass == null;
		this.javaClass = javaClass;
		boxedSnippet = this;
		unboxedSnippet = this;
	}

	public void setUnboxed(@NonNull Class<?> unboxedClass) {
		assert this.javaClass == null;
		assert unboxedSnippet == null;
		unboxedSnippet = this;
		this.javaClass = unboxedClass;
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
//		if (isStatic) {
//			s.append("{Static} ");
//		}
//		if (isLocal) {
//			s.append("{Local} ");
//		}
		if (isInlined) {
			s.append("{Inlined} ");
		}
		String joiner = "=";
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
