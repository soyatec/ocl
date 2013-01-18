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
import org.eclipse.ocl.examples.codegen.inliner.Inliner;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public interface CodeGenerator
{
	public static final @NonNull String GLOBAL_ROOT = "GLOBAL_ROOT";		// Where global constants may be added
	public static final @NonNull String LOCAL_ROOT = "LOCAL_ROOT";			// Where local constants may be added
	public static final @NonNull String SCOPE_ROOT = "SCOPE_ROOT";			// Where scoped constants may be added
	
	void addDependency(@NonNull String onLabel, @NonNull CodeGenSnippet snippet);
	void addGlobalSnippet(@NonNull CodeGenSnippet snippet);
	void addProblem(@NonNull Exception e);
	@NonNull String atNonNull();
	@NonNull String atNullable();
	@NonNull CodeGenSnippet createCodeGenSnippet(@Nullable String indentation, int flags);
	@Nullable CodeGenAnalysis findAnalysis(@NonNull Element element);
	@NonNull CodeGenAnalysis getAnalysis(@NonNull Element element);
	@NonNull Class<?> getBoxedClass(@NonNull TypeId typeId);
	@NonNull ConstantHelper getConstantHelper();
	@Nullable String getConstantsClass();
	@NonNull String getDefaultIndent();
	@NonNull String getEvaluatorName();
	@NonNull CodeGenSnippet getEvaluatorSnippet(@NonNull CodeGenSnippet referringSnippet);
	@NonNull GenModelHelper getGenModelHelper();
	@NonNull IdVisitor<Class<?>> getId2BoxedClassVisitor();
	@NonNull IdVisitor<Class<?>> getId2UnboxedClassVisitor();
	@NonNull CodeGenSnippet getIdResolver();
	@NonNull IdVisitor<CodeGenSnippet> getIdVisitor();
	@NonNull ImportManager getImportManager();
	@NonNull String getImportedName2(@NonNull Class<?> javaClass);
	@Nullable Inliner getInliner(@NonNull Class<?> javaClass);
	@NonNull MetaModelManager getMetaModelManager();
	@NonNull NameManager getNameManager();
	@NonNull CodeGenOptions getOptions();
	@NonNull String getSelfName();
	@NonNull CodeGenSnippet getSelfSnippet(@NonNull CodeGenSnippet referringSnippet);
	@NonNull CodeGenSnippet getSnippet(@Nullable Object object);
	@NonNull CodeGenSnippet getSnippet(@Nullable Object object, boolean asCaught, boolean asBoxed);
	@NonNull CodeGenLabel getSnippetLabel(@NonNull String label);
	@NonNull CodeGenSnippet getStandardLibrary(@NonNull CodeGenSnippet referringSnippet);
	@NonNull Class<?> getUnboxedClass(@NonNull Type type);
	@NonNull Class<?> getUnboxedClass(@NonNull TypeId typeId);
	@Nullable DomainOperation isFinal(@NonNull Operation anOperation, @NonNull Type staticType);
//	boolean mayEvaluateForInvalid(@NonNull Operation anOperation);
	void setSnippet(@Nullable Object element, @NonNull CodeGenSnippet snippet);
}
