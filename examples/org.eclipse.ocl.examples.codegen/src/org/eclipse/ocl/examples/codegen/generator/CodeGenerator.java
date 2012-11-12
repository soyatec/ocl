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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public interface CodeGenerator
{
	public static final @NonNull String GLOBAL_ROOT = "GLOBAL_ROOT";
	public static final @NonNull String LOCAL_ROOT = "LOCAL_ROOT";
	
	void addProblem(@NonNull Exception e);
	void addDependency(@NonNull String onLabel, @NonNull CodeGenSnippet snippet);
	@NonNull String atNonNull();
	@NonNull String atNullable();
	@NonNull CodeGenSnippet createCodeGenSnippet(@Nullable String indentation);
	@Nullable CodeGenAnalysis findAnalysis(@NonNull Element element);
	@NonNull CodeGenAnalysis getAnalysis(@NonNull Element element);
	@NonNull ConstantHelper getConstantHelper();
	@NonNull String getDefaultIndent();
	@NonNull String getEvaluatorName();
	@NonNull GenModelHelper getGenModelHelper();
	@NonNull IdVisitor<CodeGenSnippet> getIdVisitor();
	@NonNull ImportManager getImportManager();
	@NonNull String getImportedName(@NonNull Class<?> className);
	@NonNull MetaModelManager getMetaModelManager();
	@NonNull NameManager getNameManager();
	@NonNull CodeGenSnippet getSnippet(@Nullable Object object);
	@NonNull CodeGenLabel getSnippetLabel(@NonNull String label);
	@NonNull CodeGenSnippet getStandardLibrary(@NonNull CodeGenSnippet referringSnippet);
	boolean isFinal(@NonNull Operation anOperation);
	boolean mayEvaluateForInvalid(@NonNull Operation anOperation);
	void setSnippet(@NonNull Element element, @NonNull CodeGenSnippet snippet);
}
