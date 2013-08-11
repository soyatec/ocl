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
package org.eclipse.ocl.examples.codegen.oclinjunit;

import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * OCL2JavaClass supports generation of the content of a JavaClassFile with a ststic INSTANCE to provide the polymorphic implementation
 * of an ExpressionInOCL.
 */
public class JUnitCodeGenerator extends JavaCodeGenerator
{
	protected final @NonNull CodeGenAnalyzer cgAnalyzer;
	protected final @NonNull ExpressionInOCL expInOcl;

	public JUnitCodeGenerator(@NonNull MetaModelManager metaModelManager, @NonNull ExpressionInOCL expInOcl, boolean useNullAnnotations) {
		super(metaModelManager);
		getOptions().setUseNullAnnotations(useNullAnnotations);
		cgAnalyzer = new CodeGenAnalyzer(this);
		this.expInOcl = expInOcl;
	}

	public @NonNull String generateClassFile(String packageName, String className) {
		JUnitCG2JavaClassVisitor generator = JUnitCG2JavaClassVisitor.generate(this, expInOcl, packageName, className);
		Set<String> allImports = generator.getAllImports();
		Map<String, String> long2ShortImportNames = ImportUtils.getLong2ShortImportNames(allImports);
		return ImportUtils.resolveImports(generator.toString(), long2ShortImportNames);
	}

	public @NonNull CodeGenAnalyzer getAnalyzer() {
		return cgAnalyzer;
	}
}
