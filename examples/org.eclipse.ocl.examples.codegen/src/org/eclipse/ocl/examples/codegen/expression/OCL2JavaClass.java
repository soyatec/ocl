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
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AbstractOCLCodeGenerator;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CommonSubExpression;
import org.eclipse.ocl.examples.codegen.analyzer.OCL2JavaExpressionVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.OCL2JavaStatementVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.Id2JavaVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.common.CodeGenHelper;
import org.eclipse.ocl.examples.codegen.common.PivotQueries;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;

public class OCL2JavaClass extends AbstractOCLCodeGenerator
{
	protected final @NonNull ExpressionInOCL expInOcl;
	protected final @NonNull CodeGenAnalyzer cgAnalyzer = new CodeGenAnalyzer();
	protected final @NonNull NameManager nameManager;
	protected final @NonNull OCL2JavaExpressionVisitor expressionVisitor;
	protected final @NonNull Id2JavaVisitor idVisitor;
	protected final @NonNull OCL2JavaStatementVisitor statementVisitor;
	private String evaluatorName = null;
	private String standardLibraryName = null;
	private @Nullable LinkedHashSet<TypedElement> staticObjects = null;

	public OCL2JavaClass(@NonNull MetaModelManager metaModelManager, @NonNull ExpressionInOCL expInOcl) {
		super(metaModelManager);
		this.expInOcl = expInOcl;
		cgAnalyzer.initialize(new CodeGenAnalysisVisitor(cgAnalyzer), expInOcl);
		nameManager = cgAnalyzer.getNameManager();
		expressionVisitor = new OCL2JavaExpressionVisitor(this);
		idVisitor = new Id2JavaVisitor(this);
		statementVisitor = new OCL2JavaStatementVisitor(this);
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
		CodeGenAnalysis analysis = cgAnalyzer.getCurrentAnalysis();
		//
		//	Class statics
		//
		String instanceName = nameManager.reserveName("INSTANCE", null);
		append("public static " + atNonNull() + " " + className + " " + instanceName + " = new " + className + "();\n");
		generateStaticConstants(analysis);
		String functionString = generateEvaluateFunction();
		if (staticObjects != null) {
			for (TypedElement staticObject : staticObjects) {
				staticObject.accept(statementVisitor);
			}
		}
		append("\n");
		append(functionString);
	}

	public @NonNull String generateEvaluateFunction() {
		pushStream();
		CodeGenAnalysis analysis = cgAnalyzer.getCurrentAnalysis();
		OCLExpression bodyExpression = DomainUtil.nonNullModel(expInOcl.getBodyExpression());
		//
		//	"evaluate" function declaration
		//
		String evaluatorName = getEvaluatorName();
		String returnTypeIdName = nameManager.reserveName("returnTypeId", null);
		String selfName = nameManager.reserveName("self", expInOcl.getContextVariable());
		append("@Override\n");
		append("public " + atNullable() + " Object evaluate");
		append("(");
		append(atNonNull() + " " + getImportedName("DomainEvaluator") + " " + evaluatorName);
		append(", " + atNonNull() + " " + getImportedName("TypeId") + " " + returnTypeIdName);
		append(", final " + atNullable() + " Object " + selfName);
		for (Variable parameter : expInOcl.getParameterVariable()) {
			String name = DomainUtil.nonNullModel(parameter.getName());
			append(", final " + atNullable() + " Object " + nameManager.reserveName(name, parameter));
		}
		append(") throws Exception {\n");
		//
		//	"evaluate" function body
		//
		String resultName = nameManager.getSymbolName(bodyExpression, "result");
		pushIndentation();
			generateLocalConstants(analysis);
			append(bodyExpression.accept(statementVisitor));
			append("return " + resultName + ";\n");
		popIndentation();
		append("}\n");
		return popStream();
	}
	
	public void generateClassBodyBad(@NonNull String className) {
		append("/*\n");
		append("«IF expInOcl.messageExpression != null»«(expInOcl.messageExpression as StringLiteralExp).stringSymbol»«ENDIF»\n");
		append("*/\n");
	}
	
	public void generateStaticConstants(@NonNull CodeGenAnalysis analysis) {
		List<CommonSubExpression> commonSubExpressions = analysis.getCommonSubExpressions();
		if (commonSubExpressions != null) {
			append("\n");
			for (CommonSubExpression cse : commonSubExpressions) {
				assert cse != null;
				generateCommonSubExpression(cse);
			}
		}
			
	}
	
	public void generateLocalConstants(@NonNull CodeGenAnalysis analysis) {
		CommonSubExpression referredCommonSubExpression = analysis.getReferredCommonSubExpression();
		if (referredCommonSubExpression != null) {
			
		}
		else {
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
		String variableName = nameManager.getSymbolName(variable, variable.getName());
		String initializer = analysis.getExpression().accept(expressionVisitor);
		append("private ");
		if (analysis.isStaticConstant()) {
			append("static ");
		}
		append("final " + atNonNull() + " Object " + variableName + " = " + initializer + ";\n");
	}

	public @NonNull String getEvaluatorName() {
		String evaluatorName2 = evaluatorName;
		if (evaluatorName2 == null) {
			evaluatorName = evaluatorName2 = nameManager.reserveName("evaluator", null);
		}
		return evaluatorName2;
	}
	
	public @NonNull OCL2JavaExpressionVisitor getExpressionVisitor() {
		return expressionVisitor;
	}

	public @NonNull Id2JavaVisitor getIdVisitor() {
		return idVisitor;
	}

	public @NonNull NameManager getNameManager() {
		return nameManager;
	}

	public @NonNull CodeGenAnalysis getNode(@NonNull TypedElement element) {
		CodeGenAnalysis node = cgAnalyzer.getNode(element);
		if (node == null) {
			throw new IllegalArgumentException("No analysis of " + element.toString());
		}
		return node;
	}

	public @NonNull String getStandardLibraryName() {
		String standardLibraryName2 = standardLibraryName;
		if (standardLibraryName2 == null) {
			standardLibraryName = standardLibraryName2 = nameManager.reserveName("standardLibrary", null);
			append("final " + getImportedName(DomainStandardLibrary.class) + " " + standardLibraryName2 + " = evaluator.getStandardLibrary();\n"); 
		}
		return standardLibraryName2;
	}

	public @NonNull String getStaticSymbolName(@NonNull Operation anOperation) {
		LinkedHashSet<TypedElement> staticObjects2 = staticObjects;
		if (staticObjects2 == null) {
			staticObjects = staticObjects2 = new LinkedHashSet<TypedElement>();
		}
		staticObjects2.add(anOperation);
		return nameManager.getSymbolName(anOperation, "OP_" + anOperation.getName());
	}

	public @NonNull String getTypeName(@NonNull Type type) {
		String displayName = type.getTypeId().getDisplayName();
		return getImportedName(displayName);
	}
}
