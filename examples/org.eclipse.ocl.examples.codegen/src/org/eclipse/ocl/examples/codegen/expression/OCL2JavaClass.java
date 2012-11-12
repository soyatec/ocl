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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.common.CodeGenHelper;
import org.eclipse.ocl.examples.codegen.common.EmitQueries;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.ConstantHelper;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.ImportManager;
import org.eclipse.ocl.examples.codegen.generator.java.AST2JavaSnippetVisitor;
import org.eclipse.ocl.examples.codegen.generator.java.Id2JavaSnippetVisitor;
import org.eclipse.ocl.examples.codegen.generator.java.JavaConstantHelper;
import org.eclipse.ocl.examples.codegen.generator.java.JavaImportManager;
import org.eclipse.ocl.examples.codegen.generator.java.JavaSnippet;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * OCL2JavaClass supports generation of the content of a JavaClassFile to provide the polymorphic implementation
 * of an ExpressionInOCL.
 */
public class OCL2JavaClass extends AbstractCodeGenerator
{
	protected final @NonNull CodeGenAnalyzer cgAnalyzer;
	protected final @NonNull ExpressionInOCL expInOcl;
	private /*@LazyNonNull*/ String evaluatorName = null;
	private /*@LazyNonNull*/ CodeGenSnippet standardLibraryName = null;
	protected final CodeGenSnippet fileSnippet = createCodeGenSnippet("");

	public OCL2JavaClass(@NonNull MetaModelManager metaModelManager, @NonNull ExpressionInOCL expInOcl) {
		super(metaModelManager);
		cgAnalyzer = new CodeGenAnalyzer(this, expInOcl);
		this.expInOcl = expInOcl;
		cgAnalyzer.analyze();
		cgAnalyzer.optimize();
	}
	
	protected OCL2JavaClass(@NonNull MetaModelManager metaModelManager, @NonNull NameManager nameManager, @NonNull ConstantHelper constantHelper,
			@NonNull ImportManager importManager, @NonNull GenModelHelper genModelHelper, @NonNull CodeGenAnalyzer cgAnalyzer,
			@NonNull Id2JavaSnippetVisitor idVisitor, @NonNull AST2JavaSnippetVisitor astVisitor, @NonNull ExpressionInOCL expInOcl) {
		super(metaModelManager, nameManager, constantHelper, importManager, genModelHelper, idVisitor, astVisitor);
		this.expInOcl = expInOcl;
		this.cgAnalyzer = cgAnalyzer;
	}
	
/*	protected void appendSnippet(@NonNull CodeGenSnippet s) {
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
	} */

	@Override
	protected @NonNull Visitor<CodeGenSnippet> createAST2SnippetVisitor() {
		return new AST2JavaSnippetVisitor(this);
	}

	public @NonNull JavaSnippet createCodeGenSnippet(@Nullable String indentation) {
		return new JavaSnippet(this, indentation != null ? indentation : getDefaultIndent());
	}

	@Override
	protected @NonNull ConstantHelper createConstantHelper() {
		return new JavaConstantHelper(this);
	}

	@Override
	protected @NonNull GenModelHelper createGenModelHelper() {
		return new AbstractGenModelHelper(this);
	}

	@Override
	protected @NonNull IdVisitor<CodeGenSnippet> createId2SnippetVisitor() {
		return new Id2JavaSnippetVisitor(this);
	}

	@Override
	protected @NonNull ImportManager createImportManager() {
		return new JavaImportManager(EmitQueries.knownClasses);
	}

	@Override
	protected @NonNull NameManager createNameManager() {
		return new NameManager(metaModelManager);
	}

	public @Nullable CodeGenAnalysis findAnalysis(@NonNull Element element) {
		return cgAnalyzer.findAnalysis(element);
	}

	protected void generateClassBody(@NonNull String className) {
		//
		//	Class statics
		//
		String instanceName = nameManager.reserveName("INSTANCE", null);
		CodeGenSnippet globalRoot = fileSnippet.appendIndentedNodes(null);
		globalRoot.append("public static " + atNonNull() + " " + className + " " + instanceName + " = new " + className + "();\n");
		getSnippetLabel(GLOBAL_ROOT).push(globalRoot);
//		CodeGenSnippet globalSnippet = fileSnippet.appendIndentedNodes("");
//		for (CodeGenSnippet.CodeGenText aContent : allContents) {
//			if (aSnippet.isStatic()) {
//				append(aSnippet);
//			}
//		}
		fileSnippet.append("\n");
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
		CodeGenSnippet evaluateSnippet = fileSnippet.appendIndentedNodes(null);
		CodeGenText evaluateDecl = evaluateSnippet.appendIndentedText("");
		evaluateDecl.append("@Override\n");
		evaluateDecl.append("public " + atNullable() + " Object evaluate");
		evaluateDecl.append("(");
		evaluateDecl.append(atNonNull() + " " + getImportedName(DomainEvaluator.class) + " " + evaluatorName);
		evaluateDecl.append(", " + atNonNull() + " " + getImportedName(TypeId.class) + " " + returnTypeIdName);
		evaluateDecl.append(", final " + atNullable() + " Object " + selfName);
		for (Variable parameter : expInOcl.getParameterVariable()) {
			String name = DomainUtil.nonNullModel(parameter.getName());
			evaluateDecl.append(", final " + atNullable() + " Object " + nameManager.reserveName(name, parameter));
		}
		evaluateDecl.append(") throws Exception {\n");
		CodeGenSnippet evaluateNodes = evaluateSnippet.appendIndentedNodes(null);
//		CodeGenSnippet evaluateNodes = evaluateSnippet.appendIndentedNodes("");
		getSnippetLabel(LOCAL_ROOT).push(evaluateNodes.appendIndentedNodes(""));
//		pushSnippetLabel(evaluatorName, evaluateHead);
		//
		//	"evaluate" function body
		//
		CodeGenSnippet evaluateBodySnippet = getSnippet(expInOcl);
		if (evaluateBodySnippet.isInlined() && (evaluateBodySnippet.getJavaClass() == InvalidValue.class)) {
			evaluateNodes.append("throw INVALID_VALUE.getException();\n");
		}
		else {
			evaluateNodes.appendContentsOf(evaluateBodySnippet);
		}
		evaluateSnippet.append("}\n");
	}

	protected void generateClassDefinition(@NonNull String className, @NonNull String baseClassName) {

		Element element = expInOcl;
		String title = className + " provides the Java implementation for\n";
		CodeGenText classDefinition = fileSnippet.appendIndentedText("");
		classDefinition.appendCommentWithOCL(title, element);
		classDefinition.append("@SuppressWarnings(\"nls\")\n");
		classDefinition.append("public class " + className + " extends " + getImportManager().getImportedName(baseClassName) + "\n");
		classDefinition.append("{\n");
//		CodeGenSnippet classNodes = fileSnippet.appendIndentedNodes(null);
		if (expInOcl.getContextVariable() != null) {
			generateClassBody(className);
		}
		else {
			CodeGenText badClass = fileSnippet.appendIndentedText(null);
			badClass.append("/*\n");
			badClass.append("«IF expInOcl.messageExpression != null»«(expInOcl.messageExpression as StringLiteralExp).stringSymbol»«ENDIF»\n");
			badClass.append("*/\n");
		}
		fileSnippet.append("}\n");
	}

	public @NonNull CodeGenSnippet generateClassFile(@NonNull CodeGenHelper codeGenHelper, @NonNull String packageName, @NonNull String className) {
		List<Variable> parameterVariable = DomainUtil.nonNullEMF(expInOcl.getParameterVariable());
		String baseClassName = getImportedName(genModelHelper.getAbstractOperationClass(parameterVariable));
		fileSnippet.append("/**\n");
		CodeGenText commentBody = fileSnippet.appendIndentedText(" *");
		commentBody.append(" «codeGenHelper.getCopyright(' * ')»\n");
		commentBody.append("************************************************************************\n");
		commentBody.append(" This code is 100% auto-generated\n");
		commentBody.append(" using: " + getClass().getName() + "\n");
		commentBody.append("\n");
		commentBody.append(" Do not edit it.\n");
		commentBody.append("/\n");
		fileSnippet.append("package " + packageName + ";\n");
		fileSnippet.append("\n");
		CodeGenText importsBlock = fileSnippet.appendIndentedText("");
		generateClassDefinition(className, baseClassName);
		List<String> allImports = new ArrayList<String>(getAllImports());
		Collections.sort(allImports);
		for (String anImport : allImports) {
			importsBlock.append("import " + anImport + ";\n");
		}
		importsBlock.append("\n");
		return fileSnippet;
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

	public @NonNull CodeGenSnippet getStandardLibrary(@NonNull CodeGenSnippet referringSnippet) {
		CodeGenSnippet standardLibraryName2 = standardLibraryName;
		if (standardLibraryName2 == null) {
			String name = nameManager.reserveName("standardLibrary", null);
			standardLibraryName = standardLibraryName2 = new JavaSnippet(name, DomainStandardLibrary.class, this, "");
			standardLibraryName.append("final " + atNonNull() + " " + getImportedName(DomainStandardLibrary.class) + " " + name + " = " + getEvaluatorName() + ".getStandardLibrary();\n");
		}
		referringSnippet.addDependsOn(standardLibraryName2);
		return standardLibraryName2;
	}
}
