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
package org.eclipse.ocl.examples.codegen.generator;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public interface OCLCodeGenerator
{
	void append(@Nullable String string);
	@NonNull String atNonNull();
	@NonNull String atNullable();
	@Nullable CodeGenAnalysis findAnalysis(@NonNull Element element);
	@NonNull Class<?> getAbstractOperationClass(@NonNull List<? extends TypedElement> parameters);
	@NonNull CodeGenAnalysis getAnalysis(@NonNull Element element);
	@NonNull CodeGenSnippet getConstant(@Nullable Object anObject);
	@NonNull ConstantHelper getConstantHelper();
	@NonNull String getDefaultIndent();
	@NonNull String getDefiningText(@NonNull TypedElement element);
	@NonNull String getEvaluatorName();
	@NonNull OCL2JavaExpressionVisitor getExpressionVisitor();
	@NonNull Id2JavaVisitor getIdVisitor();
	@NonNull String getImportedName(@NonNull Class<?> className);
	@NonNull String getImportedName(@NonNull String qualifiedClassName);
	@NonNull MetaModelManager getMetaModelManager();
	@NonNull NameManager getNameManager();
	@NonNull Class<?> getOperationInterface(@NonNull List<? extends TypedElement> parameters);
	@Nullable String getQualifiedOperationImplementationName(@NonNull Operation anOperation, @NonNull String stereotype);
	@Nullable String getQualifiedPropertyImplementationName(@NonNull Property aProperty, @NonNull String stereotype);
	@Nullable String getQualifiedLiteralName(@NonNull Operation anOperation);
	@Nullable String getQualifiedLiteralName(@NonNull Property aProperty);
	@NonNull String getReferringText(@NonNull CodeGenSnippet referringSnippet, @NonNull TypedElement element);
	@NonNull CodeGenSnippet getSnippet(@NonNull Object object);
	@NonNull CodeGenSnippet getStandardLibrary(@NonNull CodeGenSnippet referringSnippet);
	void popIndentation();
	void pushIndentation();
	void pushIndentation(@NonNull String moreIndentation);
	void setSnippet(@NonNull Element element, @NonNull CodeGenSnippet snippet);
}
