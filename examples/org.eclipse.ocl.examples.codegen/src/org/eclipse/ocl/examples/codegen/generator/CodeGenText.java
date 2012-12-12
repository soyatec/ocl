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
import org.eclipse.ocl.examples.pivot.Element;

public interface CodeGenText extends CodeGenNode
{ 
	void append(@NonNull String string);
	@NonNull CodeGenSnippet appendBoxedReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element);
//	void appendCaughtBoxedReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element);
//	void appendCaughtUnboxedReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element);
	void appendClassReference(@NonNull Class<?> javaClass);
	void appendCommentWithOCL(@Nullable String title, @NonNull Element element);
	void appendDeclaration(@NonNull CodeGenSnippet snippet);
	void appendEvaluatorReference();
//	@Deprecated
	void appendReferenceTo(@NonNull Object element);
	void appendReferenceTo(@NonNull CodeGenSnippet snippet);
	void appendReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element);
	void appendReferenceTo(@NonNull Class<?> requiredClass, @NonNull CodeGenSnippet referredSnippet);
	void appendReferenceTo(@NonNull Class<?> requiredClass, @NonNull CodeGenSnippet referredSnippet, boolean asPrimary);
	void appendResultCast(Class<?> actualClass, @NonNull Class<?> requiredClass, String className);
	void appendString(@NonNull String name);
//	void appendThrownBoxedReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element);
//	void appendThrownReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element);
//	void appendThrownUnboxedReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element);
	void appendUnboxedReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element);
	@Deprecated
	void close();
	@NonNull CodeGenSnippet getSnippet();
}