/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.generator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.inliner.Inliner;
//import org.eclipse.ocl.examples.codegen.inliner.Inliner;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public interface CodeGenerator
{
	void addInliner(@NonNull Class<?> javaClass, @NonNull Inliner inliner);
	void addProblem(@NonNull Exception e);
	@NonNull BoxingAnalyzer createBoxingAnalyzer(@NonNull CodeGenAnalyzer analyzer);
	@NonNull FieldingAnalyzer createFieldingAnalyzer(@NonNull CodeGenAnalyzer analyzer);
	@NonNull CodeGenAnalyzer getAnalyzer();
	@NonNull Class<?> getBoxedClass(@NonNull ElementId elementId);
	@Nullable String getConstantsClass();
	@NonNull String getDefaultIndent();
	@NonNull GenModelHelper getGenModelHelper();
	@NonNull IdVisitor<Class<?>> getId2BoxedClassVisitor();
	@NonNull IdVisitor<Class<?>> getId2UnboxedClassVisitor();
	@NonNull GlobalContext getGlobalContext();
	@Nullable Inliner getInliner(@NonNull Class<?> javaClass);
	@NonNull MetaModelManager getMetaModelManager();
	@NonNull NameManager getNameManager();
	@NonNull CodeGenOptions getOptions();
//	@NonNull Class<?> getUnboxedClass(@NonNull Type type);
	@NonNull Class<?> getUnboxedClass(@NonNull ElementId elementId);
	@Nullable DomainOperation isFinal(@NonNull Operation anOperation, @NonNull Type staticType);
}
