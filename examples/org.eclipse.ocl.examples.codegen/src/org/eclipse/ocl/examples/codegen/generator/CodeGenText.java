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
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;

public interface CodeGenText extends CodeGenNode
{ 
	void append(@NonNull String string);
	void appendBoxedReferenceTo(@NonNull Class<?> requiredClass, @NonNull Element element, boolean asPrimary);
	void appendClassReference(@NonNull Class<?> javaClass);
	void appendCommentWithOCL(@Nullable String title, @NonNull Element element);
	void appendDeclaration(@NonNull CodeGenSnippet snippet);
	void appendEvaluatorReference();
	void appendReferenceTo(@NonNull CodeGenSnippet snippet);
	void appendReferenceTo(@NonNull Object element);
	void appendReferenceTo(@NonNull OCLExpression element, @NonNull Type requiredType);
	void appendUnboxedReferenceTo(@NonNull OCLExpression source, @NonNull Class<?> requiredClass);
	void appendUnboxedReferenceTo(@NonNull OCLExpression source, @NonNull Type requiredType);
	void close();
	@NonNull CodeGenSnippet getSnippet();
}