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
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.xtext.util.Strings;

/**
 * A CodeGenSnippet captures the textual contribution of one or more elements to the generated output. Multiple elements may be
 * serviced in the case of common sub-expressions. THe elements may be model elements (Element), element identifiers (ElementId)
 * or values (Object) including null.
 * <p>
 * A non-inlined snippet has a symbol name to be used in referring contexts, and contents to be emitted to define the symbol name.
 * The contents may be a concatenation of strings and nested snippets.
 * <p>
 * An inlined snippet has no contents, just a 'symbol name' to be re-used in referring contexts.
 * <p>
 * A stsic snippet has no meta-model dpeendencies and so may be emitted as a static Java constant.
 * <p>
 * Snippets may have a Java class type to be used when defining the symbol name and which may be used to eliminate casts
 * in referring contexts.
 * <p>
 * Snippets may depend on other snippets thereby ensuring that the dependencies are emitted to define symbols before
 * they are referenced by this snippet. Nested snippets may also have dependencies.
 * <p>
 * CodeGenSnippet extends IndentingBuilder allowing a line prefix indentation to be pushed and popped. When nested snippets
 * are emitted the indentation of this snippet prefixes each line of the nested snippet.
 */
public class CodeGenSnippet extends IndentingBuilder
{
	protected final @NonNull OCLCodeGenerator codeGenerator;
	protected final @NonNull String name;										// Symbol name allocated to this content
	protected @Nullable Class<?> javaClass = null;								// Java class of this content
	protected @NonNull Set<Object> elements = new HashSet<Object>();			// Elements for which this snippet defines name and content
	private final @NonNull List<Object> contents = new ArrayList<Object>();		// String/Snippet contributing to result
	protected /*@LazyNonNull*/ Set<CodeGenSnippet> dependsOn = null;			// Snippets that must be emitted before this one.
	private boolean isLocal = false;
	private boolean isStatic = false;
	private boolean isInlined = false;
	
	public CodeGenSnippet(@NonNull OCLCodeGenerator codeGenerator, @NonNull Object... elements) {
		super(codeGenerator.getDefaultIndent());
		this.codeGenerator = codeGenerator;
		this.name = codeGenerator.getNameManager().getSymbolName(elements[0]);
		for (Object element : elements) {
			this.elements.add(element);
		}
	}

	public CodeGenSnippet(@NonNull String name, @Nullable Class<?> javaClass, @NonNull OCLCodeGenerator codeGenerator) {
		super(codeGenerator.getDefaultIndent());
		this.codeGenerator = codeGenerator;
		this.name = name;
		this.javaClass = javaClass;
	}

	public void addDependsOn(@NonNull CodeGenSnippet aSnippet) {
		assert !isStatic || aSnippet.isStatic;
		if (dependsOn == null) {
			dependsOn = new HashSet<CodeGenSnippet>();
		}
		dependsOn.add(aSnippet);
	}

	public void addElement(@NonNull Element element) {
		if (elements.add(element)) {
			codeGenerator.setSnippet(element, this);
		}
	}

	public void append(@NonNull CodeGenSnippet nestedSnippet) {
		flush();
		contents.add(nestedSnippet);
	}

	public void appendReference(@NonNull Object element) {
		CodeGenSnippet termSnippet = codeGenerator.getConstant(element);
		addDependsOn(termSnippet);
		s.append(termSnippet.getName());
	}

	public void flush() {
		if (s.length() > 0) {
			contents.add(s.toString());
			s.setLength(0);
		}
	}

	/**
	 * Return all used code snippets in dependency order (this last).
	 * @return
	 */
	public @NonNull List<CodeGenSnippet> getAllSnippets() {
		List<CodeGenSnippet> allSnippets = new ArrayList<CodeGenSnippet>();
		HashSet<CodeGenSnippet> knownSnippets = new HashSet<CodeGenSnippet>();
		getAllSnippets(knownSnippets, allSnippets);
		allSnippets.add(this);
		return allSnippets;
	}
	private boolean getAllSnippets(@NonNull Set<CodeGenSnippet> knownSnippets, @NonNull List<CodeGenSnippet> allSnippets) {
		if (!knownSnippets.add(this)) {
			return false;
		}
		if (dependsOn != null) {
			for (CodeGenSnippet aSnippet : dependsOn) {
				if (aSnippet.getAllSnippets(knownSnippets, allSnippets)) {
					allSnippets.add(aSnippet);
				}
			}
		}
		for (Object aContent : contents) {
			if (aContent instanceof CodeGenSnippet) {
				((CodeGenSnippet)aContent).getAllSnippets(knownSnippets, allSnippets);
			}
		}
		return true;
	}

	public @NonNull CodeGenSnippet getConstant(@Nullable Object anObject) {
		CodeGenSnippet constant = codeGenerator.getConstant(anObject);
		if (!constant.isInlined()) {
			addDependsOn(constant);
		}
		return constant;
	}

	public @NonNull String getConstantName(@Nullable Object anObject) {
		return getConstant(anObject).getName();
	}

	public @NonNull List<Object> getContents() {
		flush();
		return contents;
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

	public boolean isInlined() {
		return isInlined;
	}

	public boolean isStatic() {
		return isStatic ;
	}

	public void setJavaClass(@NonNull Class<?> javaClass) {
		assert this.javaClass == null;
		this.javaClass = javaClass;
	}

	public void setIsInlined() {
		isInlined = true;
	}

	public void setIsLocal() {
		isLocal = true;
	}

	public void setIsStatic() {
		isStatic = true;
	}

	@Override
	public String toString() {
		return toString("\n");
	}

	public String toString(@NonNull String indent) {
		StringBuilder s = new StringBuilder();
		s.append(name);
		if (isStatic) {
			s.append("{Static} ");
		}
		if (isLocal) {
			s.append("{Local} ");
		}
		if (isInlined) {
			s.append("{Inlined} ");
		}
		String joiner = "=";
		for (Object content : contents) {
			s.append(joiner);
			if (content instanceof String) {
				s.append('"' + Strings.convertToJavaString((String)content) + '"');
			}
			else {
				s.append("<<" + ((CodeGenSnippet)content).getName() + ">>");
			}
			joiner = "+";
		}
		String string = this.s.toString();
		if (string.length() > 0) {
			s.append(joiner + '"' + Strings.convertToJavaString(string) + '"');
		}
		return s.toString();
	}
}
