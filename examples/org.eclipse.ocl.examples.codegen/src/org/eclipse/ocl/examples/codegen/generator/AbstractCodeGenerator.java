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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.FinalAnalysis;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public abstract class AbstractCodeGenerator implements CodeGenerator
{
	public static final @NonNull String ORG_ECLIPSE_JDT_ANNOTATION_NON_NULL = "org.eclipse.jdt.annotation.NonNull";
	public static final @NonNull String ORG_ECLIPSE_JDT_ANNOTATION_NULLABLE = "org.eclipse.jdt.annotation.Nullable";

	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull NameManager nameManager;
	protected final @NonNull GenModelHelper genModelHelper;
	private /*@LazyNonNull*/ CodeGenOptions options = null;
	//
	private /*@LazyNonNull*/ List<Exception> problems = null;
	private @NonNull String defaultIndent = "    ";

	protected AbstractCodeGenerator(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
		this.nameManager = createNameManager();
		this.genModelHelper = createGenModelHelper();
	}

	protected AbstractCodeGenerator(@NonNull MetaModelManager metaModelManager, @NonNull NameManager nameManager,
			@NonNull GenModelHelper genModelHelper) {
		this.metaModelManager = metaModelManager;
		this.nameManager = nameManager;
		this.genModelHelper = genModelHelper;
	}
	
	@Override
	public void addProblem(@NonNull Exception problem) {
		List<Exception> problems2 = problems;
		if (problems2 == null) {
			problems = problems2 = new ArrayList<Exception>();
		}
		problems2.add(problem);
	}

	@Override
	public @NonNull AnalysisVisitor createAnalysisVisitor() {
		return new AnalysisVisitor(getAnalyzer());
	}

	protected abstract @NonNull GenModelHelper createGenModelHelper();

	protected abstract @NonNull NameManager createNameManager();

	protected @NonNull CodeGenOptions createOptions() {
		return new CodeGenOptions();
	}

	@Override
	public @NonNull String getDefaultIndent() {
		return defaultIndent;
	}

	@Override
	public @NonNull GenModelHelper getGenModelHelper() {
		return genModelHelper;
	}

	@Override
	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	@Override
	public @NonNull NameManager getNameManager() {
		return nameManager;
	}

	@Override
	public @NonNull CodeGenOptions getOptions() {
		CodeGenOptions options2 = options;
		if (options2 == null) {
			options = options2 = createOptions();
		}
		return options2;
	}

	@Override
	public @Nullable DomainOperation isFinal(@NonNull Operation anOperation, @NonNull Type staticType) {
		FinalAnalysis finalAnalysis = metaModelManager.getPackageManager().getFinalAnalysis();
		return finalAnalysis.isFinal(anOperation, metaModelManager.getInheritance(staticType));
	}

	/**
	 * Return true if anOperation has an overload for invalid values.
	 *
	public boolean mayEvaluateForInvalid(@NonNull Operation anOperation) {
		Type targetType = metaModelManager.getOclInvalidType();
		String name = anOperation.getName();
		if (name == null) {
			return false;
		}
		DomainInheritance inheritance = targetType.getInheritance(metaModelManager);
		DomainInheritance[] arguments;
		List<Parameter> parameters = anOperation.getOwnedParameter();
		int iSize = parameters.size();
		if (iSize > 0) {
			arguments = new DomainInheritance[iSize];
			for (int i = 0; i < iSize; i++) {
				Parameter parameter = parameters.get(i);
				Type type = parameter.getType();
				if (type == null) {
					return false;
				}
				if (type.getOwningTemplateParameter() != null) {
					return false;					// FIX ME invalid not supported for templated operations
				}
				arguments[i] = type.getInheritance(metaModelManager);
			}
		}
		else {
			arguments = DomainInheritance.EMPTY_ARRAY;
		}
		DomainOperation localOperation = inheritance.lookupLocalOperation(metaModelManager, name, arguments);
		return localOperation != null;
	} */
	
//	protected abstract void resetLocals();
}
