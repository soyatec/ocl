/**
 * <copyright>
 *
 * Copyright (c) 2011,2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 **/
package org.eclipse.ocl.examples.codegen.analyzer;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public interface OCLCodeGenerator
{
	void append(@Nullable String string);
	@NonNull String atNonNull();
	@NonNull String atNullable();
	@NonNull String getBodiesClassSuffix();
	@NonNull String getBodiesPackageName();
	@NonNull EssentialOCL2ExpressionVisitor getExpressionVisitor();
	@NonNull IdVisitor<String> getIdVisitor();
	@NonNull String getImportedName(@NonNull Class<?> className);
	@NonNull String getImportedName(@NonNull String qualifiedClassName);
	@NonNull MetaModelManager getMetaModelManager();
	@NonNull NameManager getNameManager();
	@NonNull CodeGenAnalysis getNode(@NonNull TypedElement element);
	@NonNull Class<?> getOperationInterface(@NonNull List<? extends TypedElement> parameters);
	void popIndentation();
	void pushIndentation();
	void pushIndentation(@NonNull String moreIndentation);
}
