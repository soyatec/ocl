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
package org.eclipse.ocl.examples.codegen.oclinecore;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cse.CommonSubexpressionEliminator;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * OCLinEcoreCodeGenerator supports generation of the inline OCL-defined content of a Ecore *Impl file.
 */
public class OCLinEcoreCodeGenerator extends JavaCodeGenerator
{
	public static class EcoreBoxingAnalyzer extends BoxingAnalyzer
	{
		private EcoreBoxingAnalyzer(@NonNull CodeGenAnalyzer analyzer) {
			super(analyzer);
		}

		@Override
		public @Nullable Object visitCGOperation(@NonNull CGOperation cgOperation) {
			super.visitCGOperation(cgOperation);
			rewriteAsUnboxed(cgOperation.getBody());
			return null;
		}

		@Override
		public @Nullable Object visitCGProperty(@NonNull CGProperty cgProperty) {
			super.visitCGProperty(cgProperty);
			rewriteAsUnboxed(cgProperty.getBody());
			return null;
		}
	}

	public static class EcoreFieldingAnalyzer extends FieldingAnalyzer
	{
		private EcoreFieldingAnalyzer(@NonNull CodeGenAnalyzer analyzer) {
			super(analyzer);
		}

		@Override
		protected @NonNull RewriteVisitor createRewriteVisitor(@NonNull Set<CGVariable> caughtVariables) {
			return new EcoreRewriteVisitor(analyzer, caughtVariables);
		}
	}

	public static class EcoreRewriteVisitor extends FieldingAnalyzer.RewriteVisitor
	{
		EcoreRewriteVisitor(@NonNull CodeGenAnalyzer context, @NonNull Set<CGVariable> caughtVariables) {
			super(context, caughtVariables);
		}
		
		@Override
		public @NonNull Boolean visitCGConstraint(@NonNull CGConstraint cgConstraint) {
			rewriteAsCaught(cgConstraint.getBody());
			return true;
		}
	}	

	protected final @NonNull CodeGenAnalyzer cgAnalyzer;
	protected final @NonNull GenPackage genPackage;
	protected final @NonNull OCLinEcoreCG2JavaVisitor generator;
	protected final @NonNull CGPackage cgPackage;
	
	public OCLinEcoreCodeGenerator(@NonNull MetaModelManager metaModelManager, @NonNull GenPackage genPackage) {
		super(metaModelManager);
		GenModel genModel = DomainUtil.nonNullModel(genPackage.getGenModel());
		metaModelManager.addGenModel(genModel);
		getOptions().setUseNullAnnotations(OCLinEcoreGenModelGeneratorAdapter.useNullAnnotations(genModel));
		cgAnalyzer = new CodeGenAnalyzer(this);
		this.genPackage = genPackage;
		this.generator = new OCLinEcoreCG2JavaVisitor(this, genPackage);
		this.cgPackage = generator.generate();
		CommonSubexpressionEliminator cseEliminator = createCommonSubexpressionEliminator();
		cseEliminator.optimize(cgPackage);
//		DependencyVisitor dependencyVisitor = createDependencyVisitor(globalPlace);
//		dependencyVisitor.visitAll(getGlobalContext().getGlobals());
//		sortedGlobals = globalPlace.getSortedGlobals(dependencyVisitor);
	}

	@Override
	public @NonNull BoxingAnalyzer createBoxingAnalyzer() {
		return new EcoreBoxingAnalyzer(cgAnalyzer);
	}

	@Override
	public @NonNull FieldingAnalyzer createFieldingAnalyzer() {
		return new EcoreFieldingAnalyzer(cgAnalyzer);
	}

	@Override
	protected @NonNull JavaGlobalContext createGlobalContext() {
		return new OCLinEcoreGlobalContext(this, genPackage);
	}

	public @NonNull Map<String, String> generateBodies() {
		return generator.generateBodies();
	}

	public @NonNull String generateConstants() {
		return generator.generateConstants(getGlobalPlace());
	}

	public @NonNull CodeGenAnalyzer getAnalyzer() {
		return cgAnalyzer;
	}
}
