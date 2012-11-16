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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.pivot.Element;

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
public interface CodeGenSnippet extends CodeGenNode
{	
	void addDependsOn(@NonNull CodeGenSnippet cgNode);
	void addElement(@NonNull Element element);
	@NonNull CodeGenText append(@NonNull String string);
	void appendContentsOf(@NonNull CodeGenSnippet nestedSnippet);
	@NonNull CodeGenSnippet appendIndentedNodes(@Nullable String indentation);
	boolean checkDependencies(@NonNull Set<CodeGenSnippet> knownSnippets);
	@NonNull CodeGenText appendIndentedText(@Nullable String indentation);
	@NonNull LinkedHashMap<CodeGenText, String> flatten();
	@NonNull List<CodeGenNode> getContents();
	@NonNull String getName();
	@NonNull Class<?> getJavaClass();
	@NonNull String getJavaClassName();
	@NonNull CodeGenSnippet getBoxedSnippet();
	@NonNull CodeGenSnippet getFinalSnippet();
	@NonNull CodeGenSnippet getSnippet(@Nullable Object anObject);
	@NonNull String getSnippetName(@Nullable Object anObject);
	@NonNull TypeId getTypeId();
	@NonNull CodeGenSnippet getUnboxedSnippet();
	void internalAddDependant(@NonNull CodeGenSnippet cgNode);
	boolean isBoxed();
	boolean isFinal();
	boolean isInlined();
	boolean isUnboxed();
	void setIsBoxed();
	void setIsFinal();
	void setIsInlined();
	void setIsUnboxed();
	void setJavaClass(@NonNull Class<?> javaClass);
}
