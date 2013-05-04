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

import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CGDependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.Pivot2CGAnalysisVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.CGJavaDependencyVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Variable;

/**
 * A CG2JavaClassVisitor supports generation of an OCL expression as the LibraryOperation INSTANCE of a Java Class.
 */
public class JUnitCG2JavaClassVisitor extends CG2JavaVisitor
{
	public static @NonNull JUnitCG2JavaClassVisitor generate(@NonNull JavaCodeGenerator codeGenerator,
			@NonNull ExpressionInOCL expInOcl, String packageName, String className) {
		JUnitCG2JavaClassVisitor cg2JavaClassVisitor = new JUnitCG2JavaClassVisitor(codeGenerator, expInOcl, packageName, className);
		cg2JavaClassVisitor.generate();
		return cg2JavaClassVisitor;
	}

	protected final @NonNull ExpressionInOCL expInOcl;
	protected final @NonNull CGPackage cgPackage;
	
	public JUnitCG2JavaClassVisitor(@NonNull JavaCodeGenerator codeGenerator,
			@NonNull ExpressionInOCL expInOcl, String packageName, String className) {
		super(codeGenerator);
		this.expInOcl = expInOcl;
		this.cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		cgPackage.setName(packageName);
		CGClass cgClass = CGModelFactory.eINSTANCE.createCGClass();
		cgClass.setName(className);
		cgPackage.getClasses().add(cgClass);
		CGOperation cgOperation = createCGOperation(expInOcl);
		cgClass.getOperations().add(cgOperation);
		analyzer.analyze(cgPackage);
	}

	public @NonNull CGOperation createCGOperation(@NonNull ExpressionInOCL expInOcl) {
		Pivot2CGAnalysisVisitor pivot2CGVisitor = new Pivot2CGAnalysisVisitor(analyzer);
		CGValuedElement cgBody = (CGValuedElement)DomainUtil.nonNullState(expInOcl.accept(pivot2CGVisitor));
		CGOperation cgOperation = CGModelFactory.eINSTANCE.createCGOperation();
		Variable contextVariable = expInOcl.getContextVariable();
		List<CGParameter> cgParameters = cgOperation.getParameters();
		if (contextVariable != null) {
			@SuppressWarnings("unused")CGParameter cgContext = pivot2CGVisitor.getParameter(contextVariable);
			cgParameters.add(cgContext);
		}
		for (@SuppressWarnings("null")@NonNull Variable parameterVariable : expInOcl.getParameterVariable()) {
			@SuppressWarnings("unused")CGParameter cgParameter = pivot2CGVisitor.getParameter(parameterVariable);
			cgParameters.add(cgParameter);
		}
		cgOperation.setPivot(expInOcl);
		TypeId pivotTypeId = expInOcl.getTypeId();
		cgOperation.setTypeId(analyzer.getTypeId(pivotTypeId));
		cgOperation.setName(globalContext.getEvaluateName());
		cgOperation.setBody(cgBody);
		return cgOperation;
	}

	protected void generate() {
		CG2JavaPreVisitor cg2PreVisitor = new CG2JavaPreVisitor(globalContext);
		cgPackage.accept(cg2PreVisitor);
//		cgClass.getGlobals().addAll(cg2PreVisitor.getCGGlobalConstants());
		safeVisit(cgPackage);
	}

	public @NonNull Set<String> getAllImports() {
		return globalContext.getImports();
	}

	@Override
	public @Nullable Object visitCGClass(@NonNull CGClass cgClass) {
		
		Class<?> baseClass = genModelHelper.getAbstractOperationClass(expInOcl.getParameterVariable());
		String title = cgClass.getName() + " provides the Java implementation for\n";
		appendCommentWithOCL(title, expInOcl);
		String className = cgClass.getName();
		append("@SuppressWarnings(\"nls\")\n");
		append("public class " + className + " extends ");
		appendClassReference(baseClass);
		append("\n");
		append("{\n");
		pushIndentation(null);
		append("public static final ");
		appendIsRequired(true);
		append(" " + className + " " + globalContext.getInstanceName() + " = new " + className + "();\n");
		CGDependencyVisitor dependencyVisitor = new CGDependencyVisitor(analyzer); //CGJavaDependencyVisitor(globalContext);
		dependencyVisitor.visitAll(globalContext.getGlobals());
		dependencyVisitor.visitAll(cgClass.getOperations());
//		dependencyVisitor.visitAll(localContext.getLocalVariables());
		Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
		generateGlobals(sortedDependencies);
		append("\n");
		if (expInOcl.getContextVariable() != null) {
			for (CGOperation cgOperation : cgClass.getOperations()) {
				cgOperation.accept(this);
			}
		}
		else {
			append("/*\n");
			append("«IF expInOcl.messageExpression != null»«(expInOcl.messageExpression as StringLiteralExp).stringSymbol»«ENDIF»\n");
			append("*/\n");
		}
		popIndentation();
		append("}\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGOperation(@NonNull CGOperation cgOperation) {
		JavaLocalContext localContext2 = globalContext.getLocalContext(cgOperation);
		if (localContext2 != null) {
			localContext = localContext2;
			try {
				CGValuedElement evaluatorParameter = localContext2.getEvaluatorParameter();
				CGParameter typeIdParameter = localContext2.getTypeIdParameter();
				List<CGParameter> cgParameters = cgOperation.getParameters();
				CGValuedElement body = getExpression(cgOperation.getBody());
				//
				append("@Override\n");
				append("public");
		//		if (cgElement.isNull()) {
		//			append("/*@Null*/");
		//		}
		//		else {
		//			appendIsRequired(true);
		//		}
		//		append(" ");
		//		appendIsCaught(!cgElement.isInvalid(), cgElement.isInvalid());
				append(" ");
				CGTypeId cgType = cgOperation.getTypeId();
				ElementId elementId = cgType.getElementId();
				Class<?> boxedClass = /*cgOperation.isBoxed() ?*/ context.getBoxedClass(elementId) /*: context.getUnboxedClass(elementId)*/;
				appendClassReference(boxedClass);
				append(" ");
				append(cgOperation.getName());
				append("(");
				appendDeclaration(evaluatorParameter);
				append(", ");
				appendDeclaration(typeIdParameter);
				for (@SuppressWarnings("null")@NonNull CGParameter cgParameter : cgParameters) {
					append(", ");
					appendDeclaration(cgParameter);
				}
				append(") {\n");
				pushIndentation(null);
					appendCastParameters(localContext2, cgParameters);
					CGJavaDependencyVisitor dependencyVisitor = new CGJavaDependencyVisitor(localContext2);
					dependencyVisitor.visit(body);
					dependencyVisitor.visitAll(localContext2.getLocalVariables());
					Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
					for (CGValuedElement cgElement : sortedDependencies) {
						if (!cgElement.isInlineable() && cgElement.isConstant() && !cgElement.isGlobal()) {
							cgElement.accept(this);
						}
					}
					// FIXME merge locals into AST as LetExps.
					appendLocalStatements(body);
					if (body.isInvalid()) {
						append("throw ");
					}
					else {
						append("return ");
						// appendCast(cgOperation.getType())
					}
					appendValueName(body);
					append(";\n");
				popIndentation();
				append("}\n");
			}
			finally {
				localContext = null;
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGPackage(@NonNull CGPackage cgPackage) {
		appendCopyrightHeader();
		super.visitCGPackage(cgPackage);
		append(ImportUtils.IMPORTS_MARKER + "\n");
		for (CGClass cgClass : cgPackage.getClasses()) {
			cgClass.accept(this);
		}
		return null;
	}
}
