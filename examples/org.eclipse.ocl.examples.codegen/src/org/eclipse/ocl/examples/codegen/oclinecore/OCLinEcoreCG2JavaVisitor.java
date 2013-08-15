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
package org.eclipse.ocl.examples.codegen.oclinecore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.osgi.util.NLS;

/**
 * A CG2JavaClassVisitor supports generation of an OCL expression as the LIbraryOperation INSTSANCE of a Java Class.
 */
public class OCLinEcoreCG2JavaVisitor extends CG2JavaVisitor
{
	protected final @NonNull GenPackage genPackage;
	protected final @NonNull CGPackage cgPackage;
	protected ExpressionInOCL expInOcl;
	protected Feature feature;
	
	public OCLinEcoreCG2JavaVisitor(@NonNull JavaCodeGenerator codeGenerator, @NonNull GenPackage genPackage) {
		super(codeGenerator);
		this.genPackage = genPackage;
		MetaModelManager metaModelManager = codeGenerator.getMetaModelManager();
		EPackage ecorePackage = genPackage.getEcorePackage();
		org.eclipse.ocl.examples.pivot.Package asPackage = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Package.class, ecorePackage);
		assert asPackage != null;
		AS2CGVisitor pivot2CGVisitor = new OCLinEcoreAS2CGVisitor(analyzer, getGlobalContext());
		this.cgPackage = (CGPackage) DomainUtil.nonNullState(asPackage.accept(pivot2CGVisitor));
		Resource resource = new XMIResourceImpl(URI.createURI("cg.xmi"));
		resource.getContents().add(cgPackage);
		analyzer.analyze(cgPackage);
	}

	@Override
	protected void appendGlobalPrefix() {
		js.append(getGlobalContext().getTablesClassName());
		js.append(".");
	}

	public @NonNull CGPackage generate() {
		js.resetStream();
		CG2JavaPreVisitor cg2PreVisitor = context.createCG2JavaPreVisitor();
		cgPackage.accept(cg2PreVisitor);
		return cgPackage;
	}

	public @NonNull Map<String, String> generateBodies() {
		Map<String, String> bodies = new HashMap<String, String>();
		for (CGClass cgClass : cgPackage.getClasses()) {
			for (CGConstraint cgConstraint : cgClass.getInvariants()) {
				CGValuedElement cgBody = cgConstraint.getBody();
				Element pivotClass = cgClass.getAst();
				Element asElement = cgConstraint.getAst();
				if ((cgBody != null) && (pivotClass instanceof Type) && (asElement instanceof Constraint)) {
					Constraint asConstraint = (Constraint) asElement;
					localContext = globalContext.getLocalContext(cgConstraint);
					String bodyText = generateValidatorBody(cgBody, asConstraint, (Type)pivotClass);
					String fragmentURI = getFragmentURI(pivotClass) + "==" + getRuleName(asConstraint);
					bodies.put(fragmentURI, bodyText);
				}
			}
			for (CGOperation cgOperation : cgClass.getOperations()) {
				CGValuedElement cgBody = cgOperation.getBody();
				Element asOperation = cgOperation.getAst();
				if ((cgBody != null) && (asOperation instanceof Operation)) {
					String returnClassName = genModelHelper.getOperationReturnType((Operation)asOperation);
					localContext = globalContext.getLocalContext(cgOperation);
					String bodyText = generateBody(cgBody, returnClassName);
					String fragmentURI = getFragmentURI(asOperation);
					bodies.put(fragmentURI, bodyText);
				}
			}
			for (CGProperty cgProperty : cgClass.getProperties()) {
				CGValuedElement cgBody = cgProperty.getBody();
				Element asProperty = cgProperty.getAst();
				if ((cgBody != null) && (asProperty instanceof Property)) {
					String returnClassName = genModelHelper.getPropertyResultType((Property)asProperty);
					localContext = globalContext.getLocalContext(cgProperty);
					String bodyText = generateBody(cgBody, returnClassName);
					String fragmentURI = getFragmentURI(asProperty);
					bodies.put(fragmentURI, bodyText);
				}
			}
		}
		localContext = null;
		return bodies;
	}

	public @NonNull String generateBody(@NonNull CGValuedElement cgBody, @NonNull String returnClassName) {
		js.resetStream();
//		if ("isAttribute".equals(((CGNamedElement)cgBody.getParent()).getName())) {
//			System.out.println("generateBody for " + DomainUtil.debugSimpleName(localContext) + " " + cgBody.getPivot().toString());
//		}
		js.appendCommentWithOCL(null, cgBody.getAst());
//		JavaDependencyVisitor dependencyVisitor = new JavaDependencyVisitor(localContext, null);
//		dependencyVisitor.visit(cgBody);
//		dependencyVisitor.visitAll(localContext.getLocalVariables());
//		Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
//		for (CGValuedElement cgElement : sortedDependencies) {
//			if (!cgElement.isInlined() && cgElement.isConstant() && !cgElement.isGlobal()) {
//				cgElement.accept(this);
//			}
//		}
		// FIXME merge locals into AST as LetExps.
		js.appendLocalStatements(cgBody);
		if (cgBody.isInvalid()) {
			js.append("throw ");
			js.appendValueName(cgBody);
		}
		else {
			js.append("return ");
		    js.appendEcoreValue(returnClassName, cgBody);
		}
		js.append(";");
		return toString();
	}

	public @NonNull String generateConstants(@NonNull GlobalPlace globalPlace) {
		js.resetStream();
		js.pushIndentation(null);
//		CommonSubexpressionEliminator cseEliminator = context.createCommonSubexpressionEliminator();
//		GlobalPlace globalPlace = cseEliminator.optimize(cgPackage);
		DependencyVisitor dependencyVisitor = context.createDependencyVisitor();
		dependencyVisitor.visitAll(globalContext.getGlobals());
		List<CGValuedElement> sortedGlobals = globalPlace.getSortedGlobals(dependencyVisitor);
		if (sortedGlobals != null) {
			generateGlobals(sortedGlobals);
		}
		return toString();
	}

	public @NonNull String generateValidatorBody(@NonNull CGValuedElement cgBody, @NonNull Constraint asConstraint, @NonNull Type asType) {
		js.resetStream();
//		if ("CompatibleInitialiser".equals(((CGNamedElement)cgBody.getParent()).getName())) {
//			System.out.println("generateValidatorBody for " + DomainUtil.debugSimpleName(localContext) + " " + cgBody.getPivot().toString());
//		}
		String constraintName = asConstraint.getName();
		GenClassifier genClassifier = genModelHelper.getGenClassifier(asType);
		String genClassifierName = genClassifier != null ? genClassifier.getName() : null;
		if (genClassifierName == null) {
			genClassifierName = "";
		}
		String constraintLiteralName = CodeGenUtil.upperName(genClassifierName) + "__" + CodeGenUtil.upperName(constraintName != null ? constraintName : "");
		String validatorClass = genModelHelper.getQualifiedValidatorClassName(genPackage);

		js.appendCommentWithOCL(null, asConstraint);
//		DependencyVisitor dependencyVisitor = context.createDependencyVisitor(localContext, null);
//		dependencyVisitor.visit(cgBody);
//		dependencyVisitor.visitAll(localContext.getLocalVariables());
//		Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
//		for (CGValuedElement cgElement : sortedDependencies) {
//			if (!cgElement.isInlined() && cgElement.isConstant() && !cgElement.isGlobal()) {
//				cgElement.accept(this);
//			}
//		}
		// FIXME merge locals into AST as LetExps.
		js.appendLocalStatements(cgBody);		// FieldingAnalyzer override ensures this is caught
		js.append("if (");
		js.appendValueName(cgBody);
		js.append(" == ");
		js.appendClassReference(ValuesUtil.class);
		js.append(".TRUE_VALUE) {\n");
		js.pushIndentation(null);
			js.append("return true;\n");
		js.popIndentation();
		js.append("}\n");
		//
		js.append("if (diagnostics != null) {\n");
		js.pushIndentation(null);
			js.append("int ");
			js.append(getLocalContext().getSeverityName());
			js.append(" = ");
			if (cgBody.isNull()) {
				js.appendClassReference(Diagnostic.class);
				js.append(".ERROR : ");
			}
			else if (cgBody.isNonNull()) {
				js.appendClassReference(Diagnostic.class);
				js.append(".WARNING;\n");
			}
			else {
				js.appendValueName(cgBody);
				js.append(" == null ? ");
				js.appendClassReference(Diagnostic.class);
				js.append(".ERROR : ");
				js.appendClassReference(Diagnostic.class);
				js.append(".WARNING;\n");
			}
			//
			js.appendClassReference(String.class);
			js.append(" " + getLocalContext().getMessageName() + " = ");
			js.appendClassReference(NLS.class);
			js.append(".bind(");
			js.appendClassReference(EvaluatorMessages.class);
			js.append(".ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"");
			js.append(genClassifierName);
			js.append("\", \"");
			js.append(constraintName!= null ? constraintName : "UnnamedConstraint");
			js.append("\", ");
			js.appendClassReference(EObjectValidator.class);
			js.append(".getObjectLabel(this, context)});\n");
			//
			js.append("diagnostics.add(new ");
			js.appendClassReference(BasicDiagnostic.class);
			js.append("(" + getLocalContext().getSeverityName() + ", ");
			js.appendClassReference(validatorClass);
			js.append(".DIAGNOSTIC_SOURCE, ");
			js.appendClassReference(validatorClass);
			js.append("." + constraintLiteralName + ", " + getLocalContext().getMessageName() + ", new Object [] { this }));\n");
		js.popIndentation();
		js.append("}\n");
		js.append("return false;");
		return toString();
	}

	protected String getFragmentURI(@NonNull Element element) {
		return EcoreUtil.getURI(element).fragment().toString();
	}

	protected @NonNull OCLinEcoreGlobalContext getGlobalContext() {
		return (OCLinEcoreGlobalContext) globalContext;
	}

	protected @NonNull OCLinEcoreLocalContext getLocalContext() {
		return DomainUtil.nonNullState((OCLinEcoreLocalContext) localContext);
	}
	
	protected String getRuleName(@NonNull Constraint constraint) {
		String name = constraint.getName();
		return name != null ? name : "";
	}

	@Override
	public @Nullable Object visitCGClass(@NonNull CGClass cgClass) {
		return null;
	}

	@Override
	public @Nullable Object visitCGConstantExp(@NonNull CGConstantExp cgConstantExp) {
		CGValuedElement globalConstant = cgConstantExp.getReferredConstant();
		if (globalConstant != null) {
			if (!cgConstantExp.isInlined()) {
				appendGlobalPrefix();
			}
			js.appendValueName(globalConstant);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGOperation(@NonNull CGOperation cgOperation) {
		return null;
	}

	@Override
	public @Nullable Object visitCGPackage(@NonNull CGPackage cgPackage) {
		return null;
	}
}
