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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.common.CodeGenHelper;
import org.eclipse.ocl.examples.codegen.common.PivotQueries;
import org.eclipse.ocl.examples.codegen.generator.AbstractOCLCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.Id2JavaVisitor;
import org.eclipse.ocl.examples.codegen.generator.OCL2JavaExpressionVisitor;
import org.eclipse.ocl.examples.codegen.generator.OCL2JavaStatementVisitor;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
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
	private @NonNull Map<Object, CodeGenSnippet> constants = new HashMap<Object, CodeGenSnippet>();
	private /*@LazyNonNull*/ String evaluatorName = null;
	private /*@LazyNonNull*/ CodeGenSnippet standardLibraryName = null;

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
	
	protected void appendSnippet(@NonNull CodeGenSnippet s) {
		for (Object content : s.getContents()) {
			if (content instanceof String) {
				append((String)content);
			}
			else if (content instanceof CodeGenSnippet) {
				appendSnippet((CodeGenSnippet)content);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
	}

	public @Nullable CodeGenAnalysis findAnalysis(@NonNull Element element) {
		return cgAnalyzer.findAnalysis(element);
	}
	
	protected void appendBadClassBody(@NonNull String className) {
		append("/*\n");
		append("«IF expInOcl.messageExpression != null»«(expInOcl.messageExpression as StringLiteralExp).stringSymbol»«ENDIF»\n");
		append("*/\n");
	}

	protected void appendClassBody(@NonNull String className, @NonNull List<CodeGenSnippet> allSnippets) {
		//
		//	Class statics
		//
		String instanceName = nameManager.reserveName("INSTANCE", null);
		append("public static " + atNonNull() + " " + className + " " + instanceName + " = new " + className + "();\n");
		for (CodeGenSnippet aSnippet : allSnippets) {
			if (aSnippet.isStatic()) {
				append(aSnippet);
			}
		}
		append("\n");
		OCLExpression bodyExpression = DomainUtil.nonNullModel(expInOcl.getBodyExpression());
		//
		//	Reserve declaration names
		//
		String evaluatorName = getEvaluatorName();
		String returnTypeIdName = nameManager.reserveName("returnTypeId", null);
		String selfName = nameManager.reserveName("self", expInOcl.getContextVariable());
		CodeGenAnalysis bodyAnalysis = getAnalysis(bodyExpression);
		if (!bodyAnalysis.isConstant()) {
			nameManager.getSymbolName(bodyExpression, "result");
		}
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
		pushIndentation();
		for (CodeGenSnippet aSnippet : allSnippets) {
			if (!aSnippet.isStatic()) {
				append(aSnippet);
			}
		}
		popIndentation();
		append("}\n");
	}

	protected @NonNull String generateClassDefinition(@NonNull String className, @NonNull String baseClassName) {
		CodeGenSnippet rootSnippet = statementVisitor.visit(expInOcl);
		List<CodeGenSnippet> allSnippets = rootSnippet.getAllSnippets();
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
			appendClassBody(className, allSnippets);
		}
		else {
			appendBadClassBody(className);
		}
		popIndentation();
		append("}\n");
		return popStream();
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
		String body = generateClassDefinition(className, baseClassName);
		List<String> allImports = new ArrayList<String>(getAllImports());
		Collections.sort(allImports);
		for (String anImport : allImports) {
			append("import " + anImport + ";\n");
		}
		append("\n");
		append(body);
		return getString();
	}

	public @NonNull CodeGenAnalysis getAnalysis(@NonNull Element element) {
		return cgAnalyzer.getAnalysis(element);
	}

	public @NonNull CodeGenSnippet getConstant(@Nullable Object anObject) {
		if ((anObject instanceof NumericValue) && !(anObject instanceof UnlimitedValue)) {			// exclude unlimited, (null), invalid
			anObject = ((NumericValue)anObject).asNumber();				// Integer and Real may have distinct constants.
		}
		CodeGenSnippet snippet = constants.get(anObject);
		if (snippet == null) {
			if (anObject instanceof Element) {
				snippet = statementVisitor.visit((Element)anObject);
			}
			else if (anObject instanceof ElementId) {
				snippet = idVisitor.visit((ElementId)anObject);
			}
			else {
				snippet = getConstantHelper().visit(anObject);
			}
			constants.put(anObject, snippet);
		}
		return snippet;
	}

	public @NonNull String getEvaluatorName() {
		String evaluatorName2 = evaluatorName;
		if (evaluatorName2 == null) {
			evaluatorName = evaluatorName2 = nameManager.reserveName("evaluator", null);
		}
		return evaluatorName2;
	}

	public @NonNull CodeGenSnippet getStandardLibrary(@NonNull CodeGenSnippet referringSnippet) {
		CodeGenSnippet standardLibraryName2 = standardLibraryName;
		if (standardLibraryName2 == null) {
			String name = nameManager.reserveName("standardLibrary", null);
			standardLibraryName = standardLibraryName2 = new CodeGenSnippet(name, DomainStandardLibrary.class, this);
			standardLibraryName.append("final " + atNonNull() + " " + getImportedName(DomainStandardLibrary.class) + " " + name + " = " + getEvaluatorName() + ".getStandardLibrary();\n");
		}
		referringSnippet.addDependsOn(standardLibraryName2);
		return standardLibraryName2;
	}
}
