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
import org.eclipse.ocl.examples.codegen.analyzer.CGDependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.Pivot2CGAnalysisVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.CGJavaDependencyVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.NamedElement;
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
//	protected GenClassifier genClassifier;
	protected ExpressionInOCL expInOcl;
	protected Feature feature;
	
	public OCLinEcoreCG2JavaVisitor(@NonNull JavaCodeGenerator codeGenerator, @NonNull GenPackage genPackage) {
		super(codeGenerator);
		this.genPackage = genPackage;
		MetaModelManager metaModelManager = codeGenerator.getMetaModelManager();
		EPackage ecorePackage = genPackage.getEcorePackage();
		org.eclipse.ocl.examples.pivot.Package pivotPackage = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Package.class, ecorePackage);
		assert pivotPackage != null;
		Pivot2CGAnalysisVisitor pivot2CGVisitor = new OCLinEcorePivot2CGAnalysisVisitor(analyzer, getGlobalContext());
		this.cgPackage = (CGPackage) DomainUtil.nonNullState(pivotPackage.accept(pivot2CGVisitor));
		Resource resource = new XMIResourceImpl(URI.createURI("cg.xmi"));
		resource.getContents().add(cgPackage);
		analyzer.analyze(cgPackage);
	}

	@Override
	protected void appendGlobalPrefix() {
		append(getGlobalContext().getTablesClassName());
		append(".");
	}

	public @NonNull CGPackage generate() {
		resetStream();
		CG2JavaPreVisitor cg2PreVisitor = new CG2JavaPreVisitor(globalContext);
		cgPackage.accept(cg2PreVisitor);
		return cgPackage;
	}

	public @NonNull Map<String, String> generateBodies() {
		Map<String, String> bodies = new HashMap<String, String>();
		for (CGClass cgClass : cgPackage.getClasses()) {
			for (CGConstraint cgConstraint : cgClass.getInvariants()) {
				CGValuedElement cgBody = cgConstraint.getBody();
				NamedElement pivotClass = cgClass.getPivot();
				NamedElement pivotElement = cgConstraint.getPivot();
				if ((cgBody != null) && (pivotClass instanceof Type) && (pivotElement instanceof Constraint)) {
					Constraint pivotConstraint = (Constraint) pivotElement;
					localContext = globalContext.getLocalContext(cgConstraint);
					String bodyText = generateValidatorBody(cgBody, pivotConstraint, (Type)pivotClass);
					String fragmentURI = getFragmentURI(pivotClass) + "==" + getRuleName(pivotConstraint);
					bodies.put(fragmentURI, bodyText);
				}
			}
			for (CGOperation cgOperation : cgClass.getOperations()) {
				CGValuedElement cgBody = cgOperation.getBody();
				NamedElement pivotOperation = cgOperation.getPivot();
				if ((cgBody != null) && (pivotOperation instanceof Operation)) {
					String returnClassName = genModelHelper.getOperationReturnType((Operation)pivotOperation);
					localContext = globalContext.getLocalContext(cgOperation);
					String bodyText = generateBody(cgBody, returnClassName);
					String fragmentURI = getFragmentURI(pivotOperation);
					bodies.put(fragmentURI, bodyText);
				}
			}
			for (CGProperty cgProperty : cgClass.getProperties()) {
				CGValuedElement cgBody = cgProperty.getBody();
				NamedElement pivotProperty = cgProperty.getPivot();
				if ((cgBody != null) && (pivotProperty instanceof Property)) {
					String returnClassName = genModelHelper.getPropertyResultType((Property)pivotProperty);
					localContext = globalContext.getLocalContext(cgProperty);
					String bodyText = generateBody(cgBody, returnClassName);
					String fragmentURI = getFragmentURI(pivotProperty);
					bodies.put(fragmentURI, bodyText);
				}
			}
		}
		localContext = null;
		return bodies;
	}

	public @NonNull String generateBody(@NonNull CGValuedElement cgBody, @NonNull String returnClassName) {
		resetStream();
		if ("isAttribute".equals(((CGNamedElement)cgBody.getParent()).getName())) {
			System.out.println("generateBody for " + DomainUtil.debugSimpleName(localContext) + " " + cgBody.getPivot().toString());
		}
		appendCommentWithOCL(null, cgBody.getPivot());
		appendCastParameters(localContext);
		CGJavaDependencyVisitor dependencyVisitor = new CGJavaDependencyVisitor(localContext);
		dependencyVisitor.visit(cgBody);
		dependencyVisitor.visitAll(localContext.getLocalVariables());
		Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
		for (CGValuedElement cgElement : sortedDependencies) {
			if (!cgElement.isInlineable() && cgElement.isConstant() && !cgElement.isGlobal()) {
				cgElement.accept(this);
			}
		}
		// FIXME merge locals into AST as LetExps.
		appendLocalStatements(cgBody);
		if (cgBody.isInvalid()) {
			append("throw ");
			appendValueName(cgBody);
		}
		else {
			append("return ");
			// appendCast(cgOperation.getType())
		    String suffix = null;
		    Class<?> javaClass = getJavaClass(cgBody);
		    if (javaClass != null) {
				String bodyTypeName = javaClass.getName();
				if (!returnClassName.equals(bodyTypeName)) {
					if ("boolean".equals(returnClassName)) {
						suffix = ".booleanValue()";
					}
					else if ("double".equals(returnClassName)) {
						suffix = ".doubleValue()";
					}
					else if ("float".equals(returnClassName)) {
						suffix = ".floatValue()";
					}
					else if ("int".equals(returnClassName)) {
						suffix = ".intValue()";
					}
					else if ("long".equals(returnClassName)) {
						suffix = ".longValue()";
					}
					else if ("short".equals(returnClassName)) {
						suffix = ".shortValue()";
					}
					else {
						append("(");
						appendClassReference(returnClassName);
						append(")");
					}
				}
				appendValueName(cgBody);
				if (suffix != null) {
					append(suffix);
				}
		    }
		}
		append(";");
		return toString();
	}

	public @NonNull String generateConstants() {
		resetStream();
		pushIndentation(null);
		CGDependencyVisitor dependencyVisitor = new CGDependencyVisitor(analyzer); //CGJavaDependencyVisitor(globalContext);
		dependencyVisitor.visitAll(globalContext.getGlobals());
//		dependencyVisitor.visitAll(cgPackage.getClasses());
//		dependencyVisitor.visitAll(cgClass.getOperations());
//		dependencyVisitor.visitAll(localContext.getLocalVariables());
		Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
		generateGlobals(sortedDependencies);
		return toString();
	}

	public @NonNull String generateValidatorBody(@NonNull CGValuedElement cgBody, @NonNull Constraint pivotConstraint, @NonNull Type pivotType) {
		resetStream();
		if ("CompatibleInitialiser".equals(((CGNamedElement)cgBody.getParent()).getName())) {
			System.out.println("generateValidatorBody for " + DomainUtil.debugSimpleName(localContext) + " " + cgBody.getPivot().toString());
		}
		String constraintName = pivotConstraint.getName();
		GenClassifier genClassifier = genModelHelper.getGenClassifier(pivotType);
		String genClassifierName = genClassifier != null ? genClassifier.getName() : null;
		if (genClassifierName == null) {
			genClassifierName = "";
		}
		String constraintLiteralName = CodeGenUtil.upperName(genClassifierName) + "__" + CodeGenUtil.upperName(constraintName != null ? constraintName : "");
		String validatorClass = genModelHelper.getQualifiedValidatorClassName(genPackage);

		appendCommentWithOCL(null, pivotConstraint);
		appendCastParameters(localContext);
		CGJavaDependencyVisitor dependencyVisitor = new CGJavaDependencyVisitor(localContext);
		dependencyVisitor.visit(cgBody);
		dependencyVisitor.visitAll(localContext.getLocalVariables());
		Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
		for (CGValuedElement cgElement : sortedDependencies) {
			if (!cgElement.isInlineable() && cgElement.isConstant() && !cgElement.isGlobal()) {
				cgElement.accept(this);
			}
		}
		// FIXME merge locals into AST as LetExps.
/*		appendDeclaration(cgBody);
		append(";\n");
		//
		append("try {\n");
		pushIndentation(null);
			safeVisit(cgBody);
			appendValueName(cgBody);
			append(" = ");
			appendValueName(cgBody);
			append(";");
		popIndentation(); */
		appendLocalStatements(cgBody);
		append("if (");
		appendValueName(cgBody);
		append(" == ");
		appendClassReference(ValuesUtil.class);
		append(".TRUE_VALUE) {\n");
		pushIndentation(null);
			append("return true;\n");
		popIndentation();
		append("}\n");
		// FIXME diagnostics
/*		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"PropertyCallExp", "NonStaticSourceTypeIsConformant", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.PROPERTY_CALL_EXP__NON_STATIC_SOURCE_TYPE_IS_CONFORMANT, message, new Object [] { this }));
		} */
		append("if (diagnostics != null) {\n");
		pushIndentation(null);
			append("int ");
			append(getLocalContext().getSeverityName());
			append(" = ");
			appendValueName(cgBody);
			append(" == null ? ");
			appendClassReference(Diagnostic.class);
			append(".ERROR : ");
			appendClassReference(Diagnostic.class);
			append(".WARNING;\n");
			//
			appendClassReference(String.class);
			append(" " + getLocalContext().getMessageName() + " = ");
			appendClassReference(NLS.class);
			append(".bind(");
			appendClassReference(EvaluatorMessages.class);
			append(".ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"");
			append(genClassifierName);
			append("\", \"");
			append(constraintName!= null ? constraintName : "UnnamedConstraint");
			append("\", ");
			appendClassReference(EObjectValidator.class);
			append(".getObjectLabel(this, context)});\n");
			//
			append("diagnostics.add(new ");
			appendClassReference(BasicDiagnostic.class);
			append("(" + getLocalContext().getSeverityName() + ", ");
			appendClassReference(validatorClass);
			append(".DIAGNOSTIC_SOURCE, ");
			appendClassReference(validatorClass);
			append("." + constraintLiteralName + ", " + getLocalContext().getMessageName() + ", new Object [] { this }));\n");
			
//		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"PropertyCallExp", "NonStaticSourceTypeIsConformant", EObjectValidator.getObjectLabel(this, context)});
//		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.PROPERTY_CALL_EXP__NON_STATIC_SOURCE_TYPE_IS_CONFORMANT, message, new Object [] { this }));
		popIndentation();
		append("}\n");
		append("return false;");
		return toString();
	}

/*	protected String generateExpressionBody(@NonNull String className, @NonNull String returnClassName) {

		Constraint constraint = null;
		
//		boolean isRequired = (feature == null) || feature.isRequired();
//		String returnClass = feature != null ? className : Boolean.class.getSimpleName();
		//
		// Start with a comment containing the OCL
		//
		appendCommentWithOCL(null, expInOcl);
		//
		//	Reserve parameter names
		//
//		CodeGenAnalysis rootAnalysis = cgAnalyzer.analyze(expInOcl, isRequired);
//		cgAnalyzer.optimize(rootAnalysis);
		//
		OCLExpression bodyExpression = DomainUtil.nonNullModel(expInOcl.getBodyExpression());
		if (feature == null) {
//			getAnalysis(bodyExpression).setCatching();
		}
		//
		//	Reserve result name
		//
//		CodeGenAnalysis bodyAnalysis = getAnalysis(bodyExpression);
//		if (!bodyAnalysis.isConstant()) {
//			nameManager.getSymbolName(bodyExpression, "result");
//		}
		//
		//	"evaluate" function declaration
		//
//		CodeGenSnippet evaluateSnippet = snippet.appendIndentedNodes("", CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
//		CodeGenSnippet evaluateNodes = evaluateSnippet.appendIndentedNodes("", CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		CGValuedElement evaluateBodySnippet = null; //evaluateNodes.appendUnboxedGuardedChild(bodyExpression, isRequired && (feature != null) ? DomainMessage.NULL : null, null);
		if (evaluateBodySnippet != null) {
			if (!evaluateBodySnippet.isInvalid()) {
				if (feature == null) {
					String validatorClass = genModelHelper.getQualifiedValidatorClassName(genPackage);
					boolean isConstant = evaluateBodySnippet.isConstant();
					if (isConstant /*&& (evaluateBodySnippet.getConstantValue() == Boolean.TRUE)* /) {
						append("return true;\n");
					}
					else {
						if (!isConstant) {
							append("if (");
						    appendValueName(evaluateBodySnippet);
						    append(" == ");
							appendClassReference(ValuesUtil.class);
						    append(".TRUE_VALUE) {\n");
						    pushIndentation(null);
								append("return true;\n");
							popIndentation();
						    append("}\n");
						}
					    append("if (diagnostics != null) {\n");
					    pushIndentation(null);
							String constraintName = constraint.getName();
							String genClassifierName = genClassifier.getName();
							if (genClassifierName == null) {
								genClassifierName = "";
							}
							String constraintLiteralName = CodeGenUtil.upperName(genClassifierName) + "__" + CodeGenUtil.upperName(constraintName != null ? constraintName : "");
							
							append("int " + severityName + " = ");
							if (evaluateBodySnippet.isNull()) {
								appendClassReference(Diagnostic.class);
								append(".ERROR");
							}
							else if (evaluateBodySnippet.isNonNull()) {
								appendClassReference(Diagnostic.class);
								append(".WARNING");
							}
							else {
								appendReferenceTo(null, evaluateBodySnippet);
								append(" == null ? ");
								appendClassReference(Diagnostic.class);
								append(".ERROR : ");
								appendClassReference(Diagnostic.class);
								append(".WARNING");
							}
							append(";\n");
							//
							appendClassReference(String.class);
							append(" " + messageName + " = ");
							appendClassReference(NLS.class);
							append(".bind(");
							appendClassReference(EvaluatorMessages.class);
							append(".ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"");
							append(genClassifierName);
							append("\", \"");
							append(constraintName!= null ? constraintName : "UnnamedConstraint");
							append("\", ");
							appendClassReference(EObjectValidator.class);
							append(".getObjectLabel(this, context)});\n");
							//
							append("diagnostics.add(new ");
							appendClassReference(BasicDiagnostic.class);
							append("(" + severityName + ", ");
							appendClassReference(validatorClass);
							append(".DIAGNOSTIC_SOURCE, ");
							appendClassReference(validatorClass);
							append("." + constraintLiteralName + ", " + messageName + ", new Object [] { this }));\n");
							//
						popIndentation();
					    append("}\n");
					    append("return false;\n");
					}
				}
				else  {
				    append("return ");
				    String suffix = null;
				    String bodyTypeName = null; //evaluateBodySnippet.getJavaClassName();
					if (!returnClassName.equals(bodyTypeName)) {
						if ("boolean".equals(returnClassName)) {
							suffix = ".booleanValue()";
						}
						else if ("double".equals(returnClassName)) {
							suffix = ".doubleValue()";
						}
						else if ("float".equals(returnClassName)) {
							suffix = ".floatValue()";
						}
						else if ("int".equals(returnClassName)) {
							suffix = ".intValue()";
						}
						else if ("long".equals(returnClassName)) {
							suffix = ".longValue()";
						}
						else if ("short".equals(returnClassName)) {
							suffix = ".shortValue()";
						}
						else {
							append("(");
							appendClassReference(returnClassName);
							append(")");
						}
					}
					appendReferenceTo(null, evaluateBodySnippet);
					if (suffix != null) {
						append(suffix);
					}
					append(";\n");
				}
			}
//			else if (!evaluateBodySnippet.isCaught() && !evaluateBodySnippet.isInline()) {
//				/* Already thrown * /
//			}
			else {
			    append("throw ");
				appendReferenceTo(Exception.class, evaluateBodySnippet);
				append(";\n");
			}
		}
		String javaCodeSource = toString();
		return javaCodeSource;
	} */

	protected String getFragmentURI(@NonNull Element element) {
		return EcoreUtil.getURI(element).fragment().toString();
	}

	protected @NonNull OCLinEcoreGlobalContext getGlobalContext() {
		return (OCLinEcoreGlobalContext) globalContext;
	}

	protected @NonNull OCLinEcoreLocalContext getLocalContext() {
		return (OCLinEcoreLocalContext) localContext;
	}
	
	protected String getRuleName(@NonNull Constraint constraint) {
		String name = constraint.getName();
		return name != null ? name : "";
	}

	@Override
	public @Nullable Object visitCGClass(@NonNull CGClass cgClass) {
/*		Class<?> baseClass = genModelHelper.getAbstractOperationClass(expInOcl.getParameterVariable());
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
		append(" " + className + " " + instanceName + " = new " + className + "();\n");
		CGJavaDependencyVisitor dependencyVisitor = new CGJavaDependencyVisitor(localContext);
		dependencyVisitor.visitAll(cgClass.getGlobals());
		dependencyVisitor.visitAll(cgClass.getOperations());
//		dependencyVisitor.visitAll(localContext.getLocalVariables());
		Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
		for (CGValuedElement cgElement : sortedDependencies) {
			if (!cgElement.isInlineable() && cgElement.isConstant() && cgElement.isGlobal()) {
				cgElement.accept(this);
			}
		}
		append("\n");
		if (expInOcl.getContextVariable() != null) {
			for (CGOperation cgOperation : cgClass.getOperations()) {
				cgOperation.accept(this);
			}
		}
		else {
			append("/*\n");
			append("«IF expInOcl.messageExpression != null»«(expInOcl.messageExpression as StringLiteralExp).stringSymbol»«ENDIF»\n");
			append("* /\n");
		}
		popIndentation();
		append("}\n"); */
		return null;
	}

	@Override
	public @Nullable Object visitCGConstantExp(@NonNull CGConstantExp cgConstantExp) {
		CGValuedElement globalConstant = cgConstantExp.getReferredConstant();
		if (globalConstant != null) {
			appendGlobalPrefix();
			appendValueName(globalConstant);
		}
		return null;
	}

/*	@Override
	public @Nullable Object visitCGOperation(@NonNull CGOperation cgOperation) {
		localContext = globalContext.getLocalContext(cgOperation);
		append("@Override\n");
		append("public");
//		if (cgElement.isNull()) {
//			append("/*@Null* /");
//		}
//		else {
//			appendIsRequired(true);
//		}
//		append(" ");
//		appendIsCaught(!cgElement.isInvalid(), cgElement.isInvalid());
		append(" ");
		CGTypeId cgType = cgOperation.getTypeId();
		ElementId elementId = cgType.getElementId();
		Class<?> boxedClass = /*cgOperation.isBoxed() ?* / context.getBoxedClass(elementId) /*: context.getUnboxedClass(elementId)* /;
		appendClassReference(boxedClass);
		append(" ");
		append(cgOperation.getName());
		append("(");
		CGValuedElement evaluatorParameter = localContext.getEvaluatorParameter();
		appendDeclaration(evaluatorParameter);
		append(", ");
		CGParameter typeIdParameter = localContext.getTypeIdParameter();
		appendDeclaration(typeIdParameter);
		for (@SuppressWarnings("null")@NonNull CGParameter cgParameter : cgOperation.getParameters()) {
			append(", ");
			appendDeclaration(cgParameter);
		}
		append(") {\n");
		pushIndentation(null);
		CGValuedElement body = getExpression(cgOperation.getBody());
			Iterable<? extends CGValuedElement> localVariables = localContext.getLocalVariables();
			CGJavaDependencyVisitor dependencyVisitor = new CGJavaDependencyVisitor(localContext);
			dependencyVisitor.visit(body);
			if (localVariables != null) {
				dependencyVisitor.visitAll(localVariables);
			}
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
		return null;
	} */

/*	protected void generateEvaluateFunction(@NonNull CodeGenSnippet snippet,
			@NonNull Class<?> returnClass, boolean isRequired,
			@NonNull ExpressionInOCL expression) {
		OCLExpression bodyExpression = DomainUtil.nonNullModel(expression
			.getBodyExpression());
		//
		// Reserve declaration names
		//
		String returnTypeIdName = nameManager.reserveName("returnTypeId", null);
		CodeGenAnalysis bodyAnalysis = getAnalysis(bodyExpression);
		if (!bodyAnalysis.isConstant()) {
			nameManager.getSymbolName(bodyExpression, "result");
		}
		//
		// "evaluate" function declaration
		//
		CodeGenSnippet evaluateSnippet = snippet.appendIndentedNodes(null,
			CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		CodeGenSnippet evaluateNodes = evaluateSnippet.appendIndentedNodes(
			null, CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		CodeGenSnippet localRoot = evaluateNodes.appendIndentedNodes("",
			CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		getSnippetLabel(LOCAL_ROOT).push(localRoot);
		getSnippetLabel(SCOPE_ROOT).push(localRoot);
		getEvaluatorSnippet(evaluateSnippet).addDependsOn(localRoot);
		//
		// "evaluate" function body
		//
		CodeGenSnippet evaluateBodySnippet = evaluateNodes
			.appendBoxedGuardedChild(bodyExpression, isRequired
				? DomainMessage.NULL
				: null, DomainMessage.INVALID);
		if (evaluateBodySnippet != null) {
			if (!evaluateBodySnippet.isInvalid()) {
				CodeGenText returnText = evaluateNodes.append("return ");
				returnText.appendReferenceTo(returnClass, evaluateBodySnippet);
				returnText.append(";\n");
			} else if (!evaluateBodySnippet.isCaught()
				&& !evaluateBodySnippet.isInline()) {
				/* Already thrown * /
			} else {
				CodeGenText returnText = evaluateNodes.append("throw ");
				returnText.appendReferenceTo(Exception.class,
					evaluateBodySnippet);
				returnText.append(";\n");
			}
		}
	} */

	@Override
	public @Nullable Object visitCGPackage(@NonNull CGPackage cgPackage) {
		return null;
	}
}
