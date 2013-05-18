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
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.Pivot2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
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
		Pivot2CGVisitor pivot2CGVisitor = new Pivot2CGVisitor(analyzer);
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
		CG2JavaPreVisitor cg2PreVisitor = context.createCG2JavaPreVisitor();
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
		DependencyVisitor dependencyVisitor = new DependencyVisitor(analyzer); //CGJavaDependencyVisitor(globalContext);
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
}
