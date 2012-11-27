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

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.common.PivotQueries;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * OCL2JavaClass supports generation of the content of a JavaClassFile to provide the polymorphic implementation
 * of an ExpressionInOCL.
 */
public class OCLinEcore2JavaClass extends JavaCodeGenerator
{
	public static final @NonNull String INSTANCE_NAME = "INSTANCE";

	protected final @NonNull CodeGenAnalyzer cgAnalyzer;
	protected final @NonNull EClassifier eClassifier;
	protected final CodeGenSnippet fileSnippet = createCodeGenSnippet("", CodeGenSnippet.LIVE);

	public OCLinEcore2JavaClass(@NonNull MetaModelManager metaModelManager, @NonNull EClassifier eClassifier) {
		super(metaModelManager);
		cgAnalyzer = new CodeGenAnalyzer(this);
		this.eClassifier = eClassifier;
		nameManager.reserveName(INSTANCE_NAME, null);
	}

	public @Nullable CodeGenAnalysis findAnalysis(@NonNull Element element) {
		return cgAnalyzer.findAnalysis(element);
	}

	protected void generateInnerClass(@NonNull CodeGenSnippet innerClassSnippet, @NonNull String className, @NonNull String title, @NonNull ExpressionInOCL expression) {
		CodeGenAnalysis rootAnalysis = cgAnalyzer.analyze(expression);
		cgAnalyzer.optimize(rootAnalysis);
		List<Variable> parameterVariable = DomainUtil.nonNullEMF(expression.getParameterVariable());
		Class<?> baseClass = genModelHelper.getAbstractOperationClass(parameterVariable);
		CodeGenText classDefinition = innerClassSnippet.appendIndentedText("");
		classDefinition.appendCommentWithOCL(title, expression);
		classDefinition.append("public static class " + className + " extends ");
		classDefinition.appendClassReference(baseClass);
		classDefinition.append("\n");
		classDefinition.append("{\n");
		//
		//	Inner Class statics
		//
		CodeGenSnippet innerStatics = innerClassSnippet.appendIndentedNodes(null, CodeGenSnippet.LIVE);
		innerStatics.append("public static final " + innerClassSnippet.atNonNull() + " " + className + " " + INSTANCE_NAME + " = new " + className + "();\n");
//		getSnippetLabel(GLOBAL_ROOT).push(globalRoot);
		innerClassSnippet.append("\n");
		OCLExpression bodyExpression = DomainUtil.nonNullModel(expression.getBodyExpression());
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
		CodeGenSnippet evaluateSnippet = innerClassSnippet.appendIndentedNodes(null, CodeGenSnippet.LIVE);
		CodeGenText evaluateDecl = evaluateSnippet.appendIndentedText("");
//		evaluateDecl.append("@Override\n");
		evaluateDecl.append("public " + evaluateSnippet.atNullable() + " Object evaluate");
		evaluateDecl.append("(");
		evaluateDecl.appendDeclaration(getEvaluatorSnippet());
		evaluateDecl.append(", final " + evaluateSnippet.atNonNull() + " ");
		evaluateDecl.appendClassReference(TypeId.class);
		evaluateDecl.append(" " + returnTypeIdName + ", ");
		evaluateDecl.appendDeclaration(getSnippet(expression.getContextVariable()));
		for (Variable parameter : expression.getParameterVariable()) {
			evaluateDecl.append(", ");
			evaluateDecl.appendDeclaration(getSnippet(parameter));
		}
		evaluateDecl.append(") throws Exception {\n");
		CodeGenSnippet evaluateNodes = evaluateSnippet.appendIndentedNodes(null, CodeGenSnippet.LIVE);
		CodeGenSnippet localRoot = evaluateNodes.appendIndentedNodes("", CodeGenSnippet.LIVE);
		getSnippetLabel(LOCAL_ROOT).push(localRoot);
		//
		//	"evaluate" function body
		//
		CodeGenSnippet evaluateBodySnippet = getSnippet(expression);
		if (evaluateBodySnippet.isInline() && (evaluateBodySnippet.getJavaClass() == InvalidValue.class)) {
			evaluateNodes.append("throw INVALID_VALUE.getException();\n");
		}
		else {
			evaluateNodes.appendContentsOf(evaluateBodySnippet);
		}
		evaluateSnippet.append("}\n");
		innerClassSnippet.append("}\n");
	}

	protected void generateOuterClassDefinition(@NonNull GenClassifier genClassifier, @NonNull String className, @Nullable Class<?> baseClass, @NonNull org.eclipse.ocl.examples.pivot.Class pivotClass) {
//		@NonNull EClassifier eClassifier = genClassifier.getEcoreClassifier();
//		Element element = expInOcl;
//		String outerTitle = className + " provides the Java implementation for\n";
		CodeGenText classDefinition = fileSnippet.appendIndentedText("");
//		classDefinition.appendCommentWithOCL(title, element);
		classDefinition.append("@SuppressWarnings(\"nls\")\n");
		classDefinition.append("public class " + className);
		if (baseClass != null) {
			classDefinition.append(" extends ");
			classDefinition.appendClassReference(baseClass);
			classDefinition.append("\n");
		}
		classDefinition.append("\n");
		classDefinition.append("{\n");
		//
		//	Outer class statics
		//
		CodeGenSnippet globalRoot = fileSnippet.appendIndentedNodes(null, CodeGenSnippet.LIVE);
//		globalRoot.append("public static " + fileSnippet.atNonNull() + " " + className + " " + instanceName + " = new " + className + "();\n");
		getSnippetLabel(GLOBAL_ROOT).push(globalRoot);
		//
		//	Class invariants
		//
		for (Constraint constraint : pivotClass.getOwnedRule()) {
			ValueSpecification specification = DomainUtil.nonNullModel(constraint.getSpecification());
			ExpressionInOCL expression = PivotQueries.getExpressionInOCL(pivotClass, specification);
			if ((expression != null) && (expression.getContextVariable() != null)) {
				CodeGenSnippet innerClassSnippet = fileSnippet.appendIndentedNodes(null, 0);
				String innerClassName = "_" + constraint.getStereotype() +  "_" + constraint.getName();
				String innerTitle = "Implementation of the " + pivotClass.getName() + " '" + constraint.getName() + "' <" + constraint.getStereotype() + ">\n";
				generateInnerClass(innerClassSnippet, innerClassName, innerTitle, expression);
			}
		}
		//
		//	Operation bodies
		//
		for (Operation anOperation : PivotQueries.getOperations(pivotClass)) {
			assert anOperation != null;
			for (Constraint constraint : anOperation.getOwnedRule()) {
				ValueSpecification specification = DomainUtil.nonNullModel(constraint.getSpecification());
				ExpressionInOCL expression = PivotQueries.getExpressionInOCL(anOperation, specification);
				if ((expression != null) && (expression.getContextVariable() != null)) {
					CodeGenSnippet innerClassSnippet = fileSnippet.appendIndentedNodes(null, 0);
					String innerClassName = "_" + anOperation.getName() +  "_" + constraint.getStereotype() +  "_" + constraint.getName();
					String innerTitle = "Implementation of the " + pivotClass.getName() + "::" + anOperation.getName() + " '" + constraint.getName() + "' <" + constraint.getStereotype() + ">\n";
					generateInnerClass(innerClassSnippet, innerClassName, innerTitle, expression);
				}
			}
		}
		//
		//	Property bodies
		//
		for (Property aProperty : PivotQueries.getProperties(pivotClass)) {
			assert aProperty != null;
			for (Constraint constraint : aProperty.getOwnedRule()) {
				ValueSpecification specification = DomainUtil.nonNullModel(constraint.getSpecification());
				ExpressionInOCL expression = PivotQueries.getExpressionInOCL(aProperty, specification);
				if ((expression != null) && (expression.getContextVariable() != null)) {
					CodeGenSnippet innerClassSnippet = fileSnippet.appendIndentedNodes(null, 0);
					String innerClassName = "_" + aProperty.getName() +  "_" + constraint.getStereotype() +  "_" + constraint.getName();
					String innerTitle = "Implementation of the " + pivotClass.getName() + "::" + aProperty.getName() + " '" + constraint.getName() + "' <" + constraint.getStereotype() + ">\n";
					generateInnerClass(innerClassSnippet, innerClassName, innerTitle, expression);
				}
			}
		}
		
		fileSnippet.append("}\n");
	}

	public @NonNull CodeGenSnippet generateClassFile(@NonNull GenClassifier genClassifier, @NonNull String className, @NonNull org.eclipse.ocl.examples.pivot.Class pivotClass) {
		@SuppressWarnings("null")@NonNull GenPackage genPackage = genClassifier.getGenPackage();
//		@NonNull EPackage ePackage = genPackage.getEcorePackage();
		@SuppressWarnings("null")@NonNull String packageName = genPackage.getPackageName();
		String copyright = genPackage.getCopyright(" ");
//		List<Variable> parameterVariable = DomainUtil.nonNullEMF(expInOcl.getParameterVariable());
//		String baseClassName = fileSnippet.getImportedName(genModelHelper.getAbstractOperationClass(parameterVariable));
		fileSnippet.append("/**\n");
		CodeGenText commentBody = fileSnippet.appendIndentedText(" *");
		if (copyright != null) {
			commentBody.append(copyright);
			commentBody.append("\n");
		}
		commentBody.append("************************************************************************\n");
		commentBody.append(" This code is 100% auto-generated\n");
		commentBody.append(" using: " + getClass().getName() + "\n");
		commentBody.append("\n");
		commentBody.append(" Do not edit it.\n");
		commentBody.append("/\n");
		fileSnippet.append("package " + packageName + ";\n");
		fileSnippet.append("\n");
		//
		CodeGenText importsBlock = fileSnippet.appendIndentedText("");
		//
		generateOuterClassDefinition(genClassifier, className, null, pivotClass);
		//
		resolveLiveImports(importsBlock);
		importsBlock.append("\n");
		return fileSnippet;
	}

	public @NonNull CodeGenAnalysis getAnalysis(@NonNull Element element) {
		return cgAnalyzer.getAnalysis(element);
	}

	protected void resolveLiveImports(@NonNull CodeGenText importsBlock) {
		Set<String> referencedClasses = new HashSet<String>();
		fileSnippet.gatherLiveSnippets(new HashSet<CodeGenSnippet>(), referencedClasses);
		List<String> allImports = new ArrayList<String>(referencedClasses);
		Collections.sort(allImports);
		for (String anImport : allImports) {
			importsBlock.append("import " + anImport + ";\n");
		}
	}
}
