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
package org.eclipse.ocl.examples.codegen.expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.AbstractOCLCodeGenerator;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CommonSubExpression;
import org.eclipse.ocl.examples.codegen.analyzer.EssentialOCL2ExpressionVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.EssentialOCL2StatementVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.Id2JavaVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.common.CodeGenHelper;
import org.eclipse.ocl.examples.codegen.common.PivotQueries;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;

public class ExpressionInOCL2Class extends AbstractOCLCodeGenerator
{
	private final @NonNull ExpressionInOCL expInOcl;
	private final @NonNull CodeGenAnalyzer cgAnalyzer = new CodeGenAnalyzer();
	private final @NonNull EssentialOCL2ExpressionVisitor expressionVisitor;
	private final @NonNull Id2JavaVisitor idVisitor;
	private final @NonNull EssentialOCL2StatementVisitor statementVisitor;

	public ExpressionInOCL2Class(@NonNull MetaModelManager metaModelManager, @NonNull ExpressionInOCL expInOcl) {
		super(metaModelManager);
		this.expInOcl = expInOcl;
		cgAnalyzer.initialize(new CodeGenAnalysisVisitor(cgAnalyzer), expInOcl);
		expressionVisitor = new EssentialOCL2ExpressionVisitor(this);
		idVisitor = new Id2JavaVisitor(this);
		statementVisitor = new EssentialOCL2StatementVisitor(this);
		cgAnalyzer.optimize();
	}
	
	public @NonNull String generateClass(@NonNull CodeGenHelper codeGenHelper, @NonNull String packageName, @NonNull String className) {
		List<Variable> parameterVariable = DomainUtil.nonNullEMF(expInOcl.getParameterVariable());
		String baseClassName = getImportedName(getAbstractOperationClass(parameterVariable));
		append("/**\n");
		pushIndentation(" *");
			append(" «codeGenHelper.getCopyright(' * ')»\n");
			append("************************************************************************\n");
			append(" This code is 100% auto-generated\n");
			append(" using: " + getClass().getName() + "\n");
			append("\n");
			append(" Do not edit it.\n");
			append("/\n");
		popIndentation();
		append("package " + packageName + ";\n");
		append("\n");
		String body = generateBody(className, baseClassName);
		List<String> allImports = new ArrayList<String>(getAllImports());
		Collections.sort(allImports);
		for (String anImport : allImports) {
			append("import " + anImport + ";\n");
		}
		append("\n");
		append(body);
		return getString();
	}

	protected @NonNull String generateBody(@NonNull String className, @NonNull String baseClassName) {
		try {
			pushStream();
			append("/**\n");
			pushIndentation(" *");
				append(" " + className + " provides the Java implementation for\n");
				append("\n");
				pushIndentation(" ");
					PrettyPrintOptions.Global createOptions = PivotQueries.createOptions(expInOcl);
					append(PrettyPrinter.print(expInOcl, createOptions));
				popIndentation();
				append("\n");
				append("/\n");
			popIndentation();
			append("@SuppressWarnings(\"nls\")\n");
			append("public class " + className + " extends " + getImportedName(baseClassName) + "\n");
			append("{\n");
			pushIndentation();
			if (expInOcl.getContextVariable() != null) {
				generateClassBody(className);
			}
			else {
				generateClassBodyBad(className);
			}
			popIndentation();
			append("}\n");
			return getString();
		}
		finally {
			popStream();
		}
	}

	public void generateClassBody(@NonNull String className) {
		getNameManager().reserveName("INSTANCE", null);
		getNameManager().reserveName("evaluator", null);
		getNameManager().reserveName("returnTypeId", null);
		getNameManager().reserveName("self", null);
		append("public static " + atNonNull() + " " + className + " INSTANCE = new " + className + "();\n");
//		Type pType = expInOcl.getContextVariable().getType();
		CodeGenAnalysis analysis = cgAnalyzer.getCurrentAnalysis();
		generateStaticCodeGenAnalysis(analysis);
//	[let genPackage : GenPackage = codeGenHelper.getGenPackage(pType)]
//	[let constants : String = ast.gatherConstants(genPackage, expInOcl)]
//	'''
//	[let pType : Type = expInOcl.contextVariable.type]
//	[let genPackage : GenPackage = codeGenHelper.getGenPackage(pType)]
//	[let constants : String = ast.gatherConstants(genPackage, expInOcl)]
//		[expInOcl.emitStatics(constants)/]
//		@Override
		append("\n");
		append("@Override\n");
		append("public " + atNullable() + " Object evaluate");
		append("(");
		append(atNonNull() + " " + getImportedName("DomainEvaluator") + " evaluator");
		append(", " + atNonNull() + " " + getImportedName("TypeId") + " returnTypeId");
		append(", final " + atNullable() + " Object " + /*[defineSymbolName(expInOcl.contextVariable, 'self')/]*/"self");
		for (Variable parameter : expInOcl.getParameterVariable()) {
			append(", final " + atNullable() + " Object " + /*[defineSymbolName(parameter, parameter.name)/]*/parameter.getName());
		}
		append(") throws Exception {\n");
		pushIndentation();
		generateLocalCodeGenAnalysis(analysis);
//			[expInOcl.emitNonStatics(constants)/]
//			[ast.emitExpression(pType, genPackage, expInOcl)/]
		OCLExpression bodyExpression = DomainUtil.nonNullModel(expInOcl.getBodyExpression());
		append("return " + getNameManager().getSymbolName(bodyExpression) + ";\n");
		popIndentation();
		append("}\n");
	}
	
	public void generateClassBodyBad(@NonNull String className) {
		append("/*\n");
		append("«IF expInOcl.messageExpression != null»«(expInOcl.messageExpression as StringLiteralExp).stringSymbol»«ENDIF»\n");
		append("*/\n");
	}
	
	public void generateStaticCodeGenAnalysis(@NonNull CodeGenAnalysis analysis) {
		List<CommonSubExpression> commonSubExpressions = analysis.getCommonSubExpressions();
		if (commonSubExpressions != null) {
			append("\n");
			for (CommonSubExpression cse : commonSubExpressions) {
				assert cse != null;
				generateCommonSubExpression(cse);
			}
		}
			
	}
	
	public void generateLocalCodeGenAnalysis(@NonNull CodeGenAnalysis analysis) {
		CommonSubExpression referredCommonSubExpression = analysis.getReferredCommonSubExpression();
		if (referredCommonSubExpression != null) {
			
		}
		else {
			append(analysis.getExpression().accept(statementVisitor));
/*			CodeGenAnalysis[] children = analysis.getChildren();
			if (children != null) {
				for (CodeGenAnalysis child : children) {
					assert child != null;
					generateLocalCodeGenAnalysis(child);
				}
			} */
		}
	}
	
	public void generateCommonSubExpression(@NonNull CommonSubExpression commonSubExpression) {
		CodeGenAnalysis analysis = commonSubExpression.getAnalysis();
		Variable variable = commonSubExpression.getVariable();
		append("private ");
		if (analysis.isStaticConstant()) {
			append("static ");
		}
		append("final ");
//		append(getTypeName(variable.getType()));
		append("Object");
		append(" ");
		append(variable.getName());
		append(" = ");
		append(analysis.getExpression().accept(expressionVisitor));
		append(";\n");
	}
	
	public @NonNull EssentialOCL2ExpressionVisitor getExpressionVisitor() {
		return expressionVisitor;
	}

	public @NonNull Id2JavaVisitor getIdVisitor() {
		return idVisitor;
	}

	public @NonNull NameManager getNameManager() {
		return cgAnalyzer.getNameManager();
	}

	public @NonNull CodeGenAnalysis getNode(@NonNull TypedElement element) {
		CodeGenAnalysis node = cgAnalyzer.getNode(element);
		if (node == null) {
			throw new IllegalArgumentException("No analysis of " + element.toString());
		}
		return node;
	}

	public @NonNull String getTypeName(@NonNull Type type) {
		String displayName = type.getTypeId().getDisplayName();
		return getImportedName(displayName);
	}
}
