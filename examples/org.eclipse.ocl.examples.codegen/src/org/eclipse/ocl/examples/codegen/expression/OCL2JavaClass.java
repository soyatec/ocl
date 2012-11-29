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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.common.CodeGenHelper;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.ConstantHelper;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.ImportManager;
import org.eclipse.ocl.examples.codegen.generator.java.AST2JavaSnippetVisitor;
import org.eclipse.ocl.examples.codegen.generator.java.Id2JavaSnippetVisitor;
import org.eclipse.ocl.examples.codegen.generator.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * OCL2JavaClass supports generation of the content of a JavaClassFile to provide the polymorphic implementation
 * of an ExpressionInOCL.
 */
public class OCL2JavaClass extends JavaCodeGenerator
{
	protected final @NonNull CodeGenAnalyzer cgAnalyzer;
	protected final @NonNull ExpressionInOCL expInOcl;
	protected final CodeGenSnippet fileSnippet = createCodeGenSnippet("", CodeGenSnippet.LIVE);

	public OCL2JavaClass(@NonNull MetaModelManager metaModelManager, @NonNull ExpressionInOCL expInOcl) {
		super(metaModelManager);
		cgAnalyzer = new CodeGenAnalyzer(this);
		this.expInOcl = expInOcl;
		CodeGenAnalysis rootAnalysis = cgAnalyzer.analyze(expInOcl);
		cgAnalyzer.optimize(rootAnalysis);
	}
	
	protected OCL2JavaClass(@NonNull MetaModelManager metaModelManager, @NonNull NameManager nameManager, @NonNull ConstantHelper constantHelper,
			@NonNull ImportManager importManager, @NonNull GenModelHelper genModelHelper, @NonNull CodeGenAnalyzer cgAnalyzer,
			@NonNull Id2JavaSnippetVisitor idVisitor, @NonNull AST2JavaSnippetVisitor astVisitor, @NonNull ExpressionInOCL expInOcl) {
		super(metaModelManager, nameManager, constantHelper, importManager, genModelHelper, idVisitor, astVisitor);
		this.expInOcl = expInOcl;
		this.cgAnalyzer = cgAnalyzer;
	}

	public @Nullable CodeGenAnalysis findAnalysis(@NonNull Element element) {
		return cgAnalyzer.findAnalysis(element);
	}

	protected void generateClassBody(@NonNull String className) {
		//
		//	Class statics
		//
		String instanceName = nameManager.reserveName("INSTANCE", null);
		CodeGenSnippet globalRoot = fileSnippet.appendIndentedNodes(null, CodeGenSnippet.LIVE);
		globalRoot.append("public static " + fileSnippet.atNonNull() + " " + className + " " + instanceName + " = new " + className + "();\n");
		getSnippetLabel(GLOBAL_ROOT).push(globalRoot);
		fileSnippet.append("\n");
		OCLExpression bodyExpression = DomainUtil.nonNullModel(expInOcl.getBodyExpression());
		//
		//	Reserve declaration names
		//
		String returnTypeIdName = nameManager.reserveName("returnTypeId", null);
		CodeGenAnalysis bodyAnalysis = getAnalysis(bodyExpression);
		if (!bodyAnalysis.isConstant()) {
			nameManager.getSymbolName(bodyExpression, "result");
		}
		//
		//	"evaluate" function declaration
		//
		CodeGenSnippet evaluateSnippet = fileSnippet.appendIndentedNodes(null, CodeGenSnippet.LIVE);
		CodeGenText evaluateDecl = evaluateSnippet.appendIndentedText("");
		evaluateDecl.append("@Override\n");
		evaluateDecl.append("public " + evaluateSnippet.atNullable() + " Object evaluate");
		evaluateDecl.append("(");
		evaluateDecl.appendDeclaration(getEvaluatorSnippet());
		evaluateDecl.append(", final " + evaluateSnippet.atNonNull() + " " + evaluateSnippet.getImportedName(TypeId.class) + " " + returnTypeIdName + ", ");
		evaluateDecl.appendDeclaration(getSnippet(expInOcl.getContextVariable()));
		for (Variable parameter : expInOcl.getParameterVariable()) {
			evaluateDecl.append(", ");
			evaluateDecl.appendDeclaration(getSnippet(parameter));
		}
		evaluateDecl.append(") throws Exception {\n");
		CodeGenSnippet evaluateNodes = evaluateSnippet.appendIndentedNodes(null, CodeGenSnippet.LIVE);
		CodeGenSnippet localRoot = evaluateNodes.appendIndentedNodes("", CodeGenSnippet.LIVE);
		getSnippetLabel(LOCAL_ROOT).push(localRoot);
		getEvaluatorSnippet().addDependsOn(localRoot);
		//
		//	"evaluate" function body
		//
		CodeGenSnippet evaluateBodySnippet = getSnippet(expInOcl);
		if (evaluateBodySnippet.isInline() && (evaluateBodySnippet.getJavaClass() == InvalidValue.class)) {
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
		String baseClassName = fileSnippet.getImportedName(genModelHelper.getAbstractOperationClass(parameterVariable));
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
//		List<String> allImports = new ArrayList<String>(getAllImports());
//		Collections.sort(allImports);
//		for (String anImport : allImports) {
//			importsBlock.append("import " + anImport + ";\n");
//		}
//		importsBlock.append("\n");
		Set<CodeGenSnippet> liveSnippets = new HashSet<CodeGenSnippet>();
		Set<String> referencedClasses = new HashSet<String>();
		fileSnippet.gatherLiveSnippets(liveSnippets, referencedClasses);
		List<String> allImports = new ArrayList<String>(referencedClasses); //(getAllImports());
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
}
