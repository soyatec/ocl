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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.pivot.Element;

public interface CodeGenText extends CodeGenNode
{ 
	void append(@NonNull String string);
	void appendAtomicReferenceTo(@Nullable Class<?> requiredClass, @NonNull CodeGenSnippet referredSnippet);
	void appendClassReference(@NonNull Class<?> javaClass);
	void appendClassReference(@NonNull String javaClass);
	void appendCommentWithOCL(@Nullable String title, @NonNull Element element);
	void appendDeclaration(@NonNull CodeGenSnippet snippet);
	void appendEvaluatorReference();
	void appendReferenceTo(@NonNull ElementId typeId);
	void appendReferenceTo(@Nullable Class<?> requiredClass, @NonNull CodeGenSnippet referredSnippet);
	void appendResultCast(Class<?> actualClass, @NonNull Class<?> requiredClass, String className);
	void appendString(@NonNull String name);
	@NonNull CodeGenSnippet getSnippet();
}