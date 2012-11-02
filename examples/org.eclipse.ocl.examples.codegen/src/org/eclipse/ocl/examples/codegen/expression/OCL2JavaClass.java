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
import java.util.LinkedHashMap;
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
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;

/**
 * OCL2JavaClass supports generation of the content of a JavaClassFile to provide the polymorphic implementation
 * of an ExpressionInOCL.
 */
public class OCL2JavaClass extends AbstractOCLCodeGenerator
{
	protected final @NonNull CodeGenAnalyzer cgAnalyzer;
	protected final @NonNull ExpressionInOCL expInOcl;
	private /*@LazyNonNull*/ String evaluatorName = null;
	private /*@LazyNonNull*/ String standardLibraryName = null;
	private @Nullable LinkedHashMap<ElementId, String> idConstants = null;
	private @Nullable LinkedHashSet<Object> staticConstants = null;
	private @Nullable LinkedHashSet<Object> localConstants = null;

	public OCL2JavaClass(@NonNull MetaModelManager metaModelManager, @NonNull ExpressionInOCL expInOcl) {
		super(metaModelManager);
		cgAnalyzer = new CodeGenAnalyzer(this, expInOcl);
		this.expInOcl = expInOcl;
		cgAnalyzer.analyze();
		cgAnalyzer.optimize();
	}
	
	protected OCL2JavaClass(@NonNull MetaModelManager metaModelManager, @NonNull NameManager nameManager, @NonNull CodeGenAnalyzer cgAnalyzer,
			@NonNull OCL2JavaExpressionVisitor expressionVisitor, @NonNull Id2JavaVisitor idVisitor, @NonNull OCL2JavaStatementVisitor statementVisitor,
			@NonNull ExpressionInOCL expInOcl) {
		super(metaModelManager, nameManager, expressionVisitor, idVisitor, statementVisitor);
		this.expInOcl = expInOcl;
		this.cgAnalyzer = cgAnalyzer;
	}
	
	protected void appendCommonSubExpression(@NonNull CommonSubExpression commonSubExpression) {
		CodeGenAnalysis analysis = commonSubExpression.getAnalysis();
		Variable variable = commonSubExpression.getVariable();
		String variableName = nameManager.getSymbolName(variable, variable.getName());
		String initializer = expressionVisitor.visit(analysis.getExpression());			// FIXME append as statement
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

	protected void appendStatements(@NonNull Element element) {
		statementVisitor.visit(element);
	}

	public @Nullable CodeGenAnalysis findAnalysis(@NonNull Element element) {
		return cgAnalyzer.findAnalysis(element);
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
		String functionString = generateEvaluateFunctionDefinition(expInOcl);
		String staticConstantsString = generateStaticConstants();
		String idConstantsString = generateIdConstants();
		append(idConstantsString);
		append(staticConstantsString);
		append("\n");
		append(functionString);
	}
	
	public @NonNull String generateClassFile(@NonNull CodeGenHelper codeGenHelper, @NonNull String packageName, @NonNull String className) {
/*		CodeGenAssignment rootAssignment = getAssignment(expInOcl);
		Map<CodeGenAssignment, String> codeSnippets = rootAssignment.computeCodeSnippets(statementVisitor);
		Map<CodeGenAssignment, Integer> dependencySizes = rootAssignment.computeDependencySizes();
		List<Map.Entry<CodeGenAssignment, Integer>> orderedDependencies = new ArrayList<Map.Entry<CodeGenAssignment, Integer>>(dependencySizes.entrySet());
		Collections.sort(orderedDependencies, new Comparator<Map.Entry<CodeGenAssignment, Integer>>()
		{
			public int compare(Entry<CodeGenAssignment, Integer> o1, Entry<CodeGenAssignment, Integer> o2) {
				return o2.getValue() - o1.getValue();		// Largest first
			}
		});
		List<CodeGenAssignment> staticAssignments = new ArrayList<CodeGenAssignment>(orderedDependencies.size());
		List<CodeGenAssignment> localAssignments = new ArrayList<CodeGenAssignment>(orderedDependencies.size());
		for (Map.Entry<CodeGenAssignment, Integer> entry : orderedDependencies) {
			CodeGenAssignment assignment = entry.getKey();
			if (assignment.isStaticConstant()) {
				staticAssignments.add(assignment);
			}
			if (assignment.isStaticConstant()) {
				localAssignments.add(assignment);
			}
		} */
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

	protected String generateEvaluateFunctionBody(@NonNull ExpressionInOCL expressionInOCL) {
		pushStream();
		appendStatements(expressionInOCL);
		return popStream();
/*		CodeGenAnalysis analysis = getAnalysis(expressionInOCL);
		if (!analysis.isConstant()) {
			appendStatements(expressionInOCL);
		}
		else {
			Object constantValue = analysis.getConstantValue();
			if (constantValue instanceof InvalidValue) {
				String resultText = getDefiningText(expressionInOCL);
//				append(resultText + ";\n");
				append("throw (" + resultText + ").getException();\n");
			}
			else {
				String resultText = getReferringText(expressionInOCL);
				append("return " + resultText + ";\n");
			}	// FIXME maybeInvalid check
//			if (analysis.getTransitiveInvalidSources().size() > 0) {
//				appendThrowCheck(symbolName);
//			}
		}
		return popStream(); */
	}

	protected @NonNull String generateEvaluateFunctionDefinition(@NonNull ExpressionInOCL expressionInOCL) {
		OCLExpression bodyExpression = DomainUtil.nonNullModel(expressionInOCL.getBodyExpression());
		//
		//	Reserve declaration names
		//
		String evaluatorName = getEvaluatorName();
		String returnTypeIdName = nameManager.reserveName("returnTypeId", null);
		String selfName = nameManager.reserveName("self", expressionInOCL.getContextVariable());
		CodeGenAnalysis bodyAnalysis = getAnalysis(bodyExpression);
		if (!bodyAnalysis.isConstant()) {
			nameManager.getSymbolName(bodyExpression, "result");
		}
		//
		//	Generate body and discover local constant declarations
		//
		String generatedFunctionBody = generateEvaluateFunctionBody(expressionInOCL);
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
		for (Variable parameter : expressionInOCL.getParameterVariable()) {
			String name = DomainUtil.nonNullModel(parameter.getName());
			append(", final " + atNullable() + " Object " + nameManager.reserveName(name, parameter));
		}
		append(") throws Exception {\n");
		//
		//	"evaluate" function body
		//
		pushIndentation();
			appendLocalConstants(analysis);
			if (localConstants != null) {
				for (Object localConstant : localConstants) {
					assert localConstant != null;
					if (localConstant instanceof Element) {
						appendStatements((Element) localConstant);
					}
					else {
						append("final " + atNonNull() + " Object " + nameManager.getSymbolName(localConstant) + " = " + getConstantHelper().getNonInlineValue(localConstant) + ";\n");
					}
				}
			}
			append(generatedFunctionBody);
		popIndentation();
		append("}\n");
		return popStream();
	}

	protected String generateIdConstants() {
		pushStream();
		LinkedHashMap<ElementId, String> idConstants2 = idConstants;
		if (idConstants2 != null) {
			pushIndentation("private static final " + atNonNull() + " ");
			for (ElementId idConstants : idConstants2.keySet()) {
				assert idConstants != null;
				Class<?> typeIdClass;
				if (idConstants instanceof CollectionTypeId) {
					typeIdClass = CollectionTypeId.class;
				}
				else {
					typeIdClass = TypeId.class;
				}
				append(getImportedName(typeIdClass) + " " + idConstants2.get(idConstants) + " = " + idVisitor.visit(idConstants) + ";\n");
			}
			popIndentation();
		}
		return popStream();
	}

	protected String generateStaticConstants() {
		pushStream();
/*		LinkedHashSet<Object> staticConstantValues2 = staticConstantValues;
		if (staticConstantValues2 != null) {
			pushIndentation("private static ");
			for (Object staticConstant : staticConstantValues2) {
				assert staticConstant != null;
				append(atNonNull() + " Object " + nameManager.getSymbolName(null, staticConstant) + " = " + getConstantHelper().getNonInlineValue(staticConstant));
//				appendStatements(staticConstant);
			}
			popIndentation();
		} */
		LinkedHashSet<Object> staticConstants2 = staticConstants;
		if (staticConstants2 != null) {
			pushIndentation("private static ");
			for (Object staticConstant : staticConstants2) {
				assert staticConstant != null;
				if (staticConstant instanceof Element) {
					appendStatements((Element) staticConstant);
				}
				else {
					append("final " + atNonNull() + " Object " + nameManager.getSymbolName(staticConstant) + " = " + getConstantHelper().getNonInlineValue(staticConstant) + ";\n");
				}
			}
			popIndentation();
		}
		return popStream();
	}

	public @NonNull CodeGenAnalysis getAnalysis(@NonNull Element element) {
		return cgAnalyzer.getAnalysis(element);
	}

	public @NonNull String getEvaluatorName() {
		String evaluatorName2 = evaluatorName;
		if (evaluatorName2 == null) {
			evaluatorName = evaluatorName2 = nameManager.reserveName("evaluator", null);
		}
		return evaluatorName2;
	}

	public @NonNull String getIdName(@NonNull ElementId id) {
		LinkedHashMap<ElementId, String> typeIdConstants2 = idConstants;
		if (typeIdConstants2 == null) {
			idConstants = typeIdConstants2 = new LinkedHashMap<ElementId, String>();
		}
		String name = typeIdConstants2.get(id);
		if (name == null) {
			name = "TID_" + typeIdConstants2.size();
			typeIdConstants2.put(id, name);		
		}
		return name;
	}

	public @NonNull String getLocalConstantName(@NonNull Object anObject) {
		if (anObject instanceof NumericValue) {
			anObject = ((NumericValue)anObject).asNumber();
		}
		LinkedHashSet<Object> localConstants2 = localConstants;
		if (localConstants2 == null) {
			localConstants = localConstants2 = new LinkedHashSet<Object>();
		}
		localConstants2.add(anObject);
		return nameManager.getSymbolName(anObject, nameManager.getNameHint(anObject));
	}

	public @NonNull String getStandardLibraryName() {
		String standardLibraryName2 = standardLibraryName;
		if (standardLibraryName2 == null) {
			standardLibraryName = standardLibraryName2 = nameManager.reserveName("standardLibrary", null);
			append("final " + getImportedName(DomainStandardLibrary.class) + " " + standardLibraryName2 + " = evaluator.getStandardLibrary();\n"); 
		}
		return standardLibraryName2;
	}

	public @NonNull String getStaticConstantName(@NonNull Object anObject) {
		if (anObject instanceof NumericValue) {
			anObject = ((NumericValue)anObject).asNumber();
		}
		LinkedHashSet<Object> staticConstants2 = staticConstants;
		if (staticConstants2 == null) {
			staticConstants = staticConstants2 = new LinkedHashSet<Object>();
		}
		staticConstants2.add(anObject);
		String symbolName = nameManager.getSymbolName(anObject, nameManager.getNameHint(anObject));
		return symbolName;
	}
}
