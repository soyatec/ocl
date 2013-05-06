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
import org.eclipse.ocl.examples.codegen.java.JavaTypeDescriptor;
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
		js.appendCommentWithOCL(title, expInOcl);
		String className = cgClass.getName();
		js.append("@SuppressWarnings(\"nls\")\n");
		js.append("public class " + className + " extends ");
		js.appendClassReference(baseClass);
		js.append("\n");
		js.append("{\n");
		js.pushIndentation(null);
		js.append("public static final ");
		js.appendIsRequired(true);
		js.append(" " + className + " " + globalContext.getInstanceName() + " = new " + className + "();\n");
		CGDependencyVisitor dependencyVisitor = new CGDependencyVisitor(analyzer); //CGJavaDependencyVisitor(globalContext);
		dependencyVisitor.visitAll(globalContext.getGlobals());
		dependencyVisitor.visitAll(cgClass.getOperations());
//		dependencyVisitor.visitAll(localContext.getLocalVariables());
		Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
		generateGlobals(sortedDependencies);
		js.append("\n");
		if (expInOcl.getContextVariable() != null) {
			for (CGOperation cgOperation : cgClass.getOperations()) {
				cgOperation.accept(this);
			}
		}
		else {
			js.append("/*\n");
			js.append("«IF expInOcl.messageExpression != null»«(expInOcl.messageExpression as StringLiteralExp).stringSymbol»«ENDIF»\n");
			js.append("*/\n");
		}
		js.popIndentation();
		js.append("}\n");
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
				js.append("@Override\n");
				js.append("public");
		//		if (cgElement.isNull()) {
		//			js.append("/*@Null*/");
		//		}
		//		else {
		//			js.appendIsRequired(true);
		//		}
		//		js.append(" ");
		//		js.appendIsCaught(!cgElement.isInvalid(), cgElement.isInvalid());
				js.append(" ");
				CGTypeId cgTypeId = cgOperation.getTypeId();
				JavaTypeDescriptor javaTypeDescriptor = context.getJavaTypeDescriptor(cgTypeId, true);
//				ElementId elementId = cgTypeId.getElementId();
//				Class<?> boxedClass = /*cgOperation.isBoxed() ?*/ context.getBoxedClass(elementId) /*: context.getUnboxedClass(elementId)*/;
				js.appendClassReference(javaTypeDescriptor);
				js.append(" ");
				js.append(cgOperation.getName());
				js.append("(");
				js.appendDeclaration(evaluatorParameter);
				js.append(", ");
				js.appendDeclaration(typeIdParameter);
				for (@SuppressWarnings("null")@NonNull CGParameter cgParameter : cgParameters) {
					js.append(", ");
					js.appendDeclaration(cgParameter);
				}
				js.append(") {\n");
				js.pushIndentation(null);
					js.appendCastParameters(localContext2, cgParameters);
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
					js.appendLocalStatements(body);
					if (body.isInvalid()) {
						js.append("throw ");
					}
					else {
						js.append("return ");
						// js.appendCast(cgOperation.getType())
					}
					js.appendValueName(body);
					js.append(";\n");
				js.popIndentation();
				js.append("}\n");
			}
			finally {
				localContext = null;
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGPackage(@NonNull CGPackage cgPackage) {
		js.appendCopyrightHeader();
		super.visitCGPackage(cgPackage);
		js.append(ImportUtils.IMPORTS_MARKER + "\n");
		for (CGClass cgClass : cgPackage.getClasses()) {
			cgClass.accept(this);
		}
		return null;
	}
}
