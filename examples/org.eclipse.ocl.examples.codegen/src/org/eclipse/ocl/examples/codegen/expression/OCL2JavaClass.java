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
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CommonSubExpression;
import org.eclipse.ocl.examples.codegen.analyzer.Id2JavaVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.analyzer.OCL2JavaExpressionVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.OCL2JavaStatementVisitor;
import org.eclipse.ocl.examples.codegen.common.CodeGenHelper;
import org.eclipse.ocl.examples.codegen.common.PivotQueries;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;

/**
 * OCL2JavaClass supports generation of the content of a JavaClassFile to provide the polymorphic imp[lementation
 * of an ExpressionInOCL.
 */
public class OCL2JavaClass extends AbstractOCLCodeGenerator
{
	protected final @NonNull NameManager nameManager;
	protected final @NonNull CodeGenAnalyzer cgAnalyzer;
	protected final @NonNull OCL2JavaExpressionVisitor expressionVisitor;
	protected final @NonNull Id2JavaVisitor idVisitor;
	protected final @NonNull OCL2JavaStatementVisitor statementVisitor;
	protected final @NonNull ExpressionInOCL expInOcl;
	private /*@LazyNonNull*/ String evaluatorName = null;
	private /*@LazyNonNull*/ String standardLibraryName = null;
	private @Nullable LinkedHashSet<Element> staticConstants = null;
	private @Nullable LinkedHashSet<Element> localConstants = null;

	public OCL2JavaClass(@NonNull MetaModelManager metaModelManager, @NonNull ExpressionInOCL expInOcl) {
		super(metaModelManager);
		nameManager = new NameManager(metaModelManager);
		cgAnalyzer = new CodeGenAnalyzer(nameManager, expInOcl);
		expressionVisitor = new OCL2JavaExpressionVisitor(this);
		idVisitor = new Id2JavaVisitor(this);
		statementVisitor = new OCL2JavaStatementVisitor(this);
		this.expInOcl = expInOcl;
		cgAnalyzer.analyze();
		cgAnalyzer.optimize();
	}
	
	protected OCL2JavaClass(@NonNull MetaModelManager metaModelManager, @NonNull NameManager nameManager, @NonNull CodeGenAnalyzer cgAnalyzer,
			@NonNull OCL2JavaExpressionVisitor expressionVisitor, @NonNull Id2JavaVisitor idVisitor, @NonNull OCL2JavaStatementVisitor statementVisitor,
			@NonNull ExpressionInOCL expInOcl) {
		super(metaModelManager);
		this.expInOcl = expInOcl;
		this.nameManager = nameManager;
		this.cgAnalyzer = cgAnalyzer;
		this.expressionVisitor = expressionVisitor;
		this.idVisitor = idVisitor;
		this.statementVisitor = statementVisitor;
	}
	
	protected void appendCommonSubExpression(@NonNull CommonSubExpression commonSubExpression) {
		CodeGenAnalysis analysis = commonSubExpression.getAnalysis();
		Variable variable = commonSubExpression.getVariable();
		String variableName = nameManager.getSymbolName(variable, variable.getName());
		String initializer = analysis.getExpression().accept(expressionVisitor);			// FIXME append as statement
		append("private ");
		if (analysis.isStaticConstant()) {
			append("static ");
		}
		append("final " + atNonNull() + " Object " + variableName + " = " + initializer + ";\n");
	}
	
	protected void appendLocalConstants(@NonNull CodeGenAnalysis analysis) {
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
	
	protected void appendStaticConstants(@NonNull CodeGenAnalysis analysis) {
		List<CommonSubExpression> commonSubExpressions = analysis.getCommonSubExpressions();
		if (commonSubExpressions != null) {
			append("\n");
			for (CommonSubExpression cse : commonSubExpressions) {
				assert cse != null;
				appendCommonSubExpression(cse);
			}
		}
			
	}

	protected void appendStatements(@NonNull Element bodyExpression) {
		bodyExpression.accept(statementVisitor);
	}

	protected @NonNull String generateBody(@NonNull String className, @NonNull String baseClassName) {
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
			appendClassBody(className);
		}
		else {
			appendBadClassBody(className);
		}
		popIndentation();
		append("}\n");
		return popStream();
	}
	
	protected void appendBadClassBody(@NonNull String className) {
		append("/*\n");
		append("«IF expInOcl.messageExpression != null»«(expInOcl.messageExpression as StringLiteralExp).stringSymbol»«ENDIF»\n");
		append("*/\n");
	}

	protected void appendClassBody(@NonNull String className) {
		CodeGenAnalysis analysis = cgAnalyzer.getCurrentAnalysis();
		//
		//	Class statics
		//
		String instanceName = nameManager.reserveName("INSTANCE", null);
		append("public static " + atNonNull() + " " + className + " " + instanceName + " = new " + className + "();\n");
		appendStaticConstants(analysis);
		String functionString = generateEvaluateFunctionDefinition();
		LinkedHashSet<Element> staticConstants2 = staticConstants;
		if (staticConstants2 != null) {
			pushIndentation("private static ");
			for (Element staticConstant : staticConstants2) {
				assert staticConstant != null;
				appendStatements(staticConstant);
			}
			popIndentation();
		}
		append("\n");
		append(functionString);
	}
	
	public @NonNull String generateClassFile(@NonNull CodeGenHelper codeGenHelper, @NonNull String packageName, @NonNull String className) {
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

	protected String generateEvaluateFunctionBody(@NonNull OCLExpression bodyExpression) {
		pushStream();
		appendStatements(bodyExpression);
		return popStream();
	}

	protected @NonNull String generateEvaluateFunctionDefinition() {
		OCLExpression bodyExpression = DomainUtil.nonNullModel(expInOcl.getBodyExpression());
		//
		//	Reserve declaration names
		//
		String evaluatorName = getEvaluatorName();
		String returnTypeIdName = nameManager.reserveName("returnTypeId", null);
		String selfName = nameManager.reserveName("self", expInOcl.getContextVariable());
		//
		//	Generate body and discover local constant declarations
		//
		String generatedFunctionBody = generateEvaluateFunctionBody(bodyExpression);
		//
		pushStream();
		CodeGenAnalysis analysis = cgAnalyzer.getCurrentAnalysis();
		//
		//	"evaluate" function declaration
		//
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
			appendLocalConstants(analysis);
			if (localConstants != null) {
				for (Element localConstant : localConstants) {
					assert localConstant != null;
					appendStatements(localConstant);
				}
			}
			append(generatedFunctionBody);
			append("return " + resultName + ";\n");
		popIndentation();
		append("}\n");
		return popStream();
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

	public @NonNull String getLocalConstantName(@NonNull Element element) {
		LinkedHashSet<Element> localConstants2 = localConstants;
		if (localConstants2 == null) {
			localConstants = localConstants2 = new LinkedHashSet<Element>();
		}
		localConstants2.add(element);
		return nameManager.getSymbolName(element, nameManager.getNameHint(element));
	}

	public @NonNull NameManager getNameManager() {
		return nameManager;
	}

	public @NonNull CodeGenAnalysis getNode(@NonNull Element element) {
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

	public @NonNull String getStaticConstantName(@NonNull Element element) {
		LinkedHashSet<Element> staticConstants2 = staticConstants;
		if (staticConstants2 == null) {
			staticConstants = staticConstants2 = new LinkedHashSet<Element>();
		}
		staticConstants2.add(element);
		return nameManager.getSymbolName(element, nameManager.getNameHint(element));
	}

	public @NonNull String getTypeName(@NonNull Type type) {
		String displayName = type.getTypeId().getDisplayName();
		return getImportedName(displayName);
	}
}
