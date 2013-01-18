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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.common.PivotQueries;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet.AbstractTextAppender;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.generator.ImportManager;
import org.eclipse.ocl.examples.codegen.generator.java.JETImportManager;
import org.eclipse.ocl.examples.codegen.generator.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.java.JavaSnippet;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.DomainMessage;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;

/**
 * OCL2JavaClass supports generation of the content of a JavaClassFile to provide the polymorphic implementation
 * of an ExpressionInOCL.
 */
public class OCLinEcore2JavaBodies extends JavaCodeGenerator
{
	public static final @NonNull String INSTANCE_NAME = "INSTANCE";

	protected final @NonNull GenModel genModel;
	protected final @NonNull CodeGenAnalyzer cgAnalyzer;
	protected final @NonNull Map<String, String> bodies = new HashMap<String, String>();
	private GenPackage genPackage = null;
	private GenClassifier genClassifier = null;
	private Constraint constraint = null;
	private ValueSpecification specification = null;
	private ExpressionInOCL expression = null;
	protected final @NonNull String constantsClassName;

	private static @NonNull Comparator<? super NamedElement> nameComparator = new Comparator<NamedElement>(){

		public int compare(NamedElement o1, NamedElement o2) {
			String n1 = String.valueOf(o1.getName());
			String n2 = String.valueOf(o2.getName());
			return n1.compareTo(n2);
		}
	};

	public OCLinEcore2JavaBodies(@NonNull GenModel genModel, @Nullable Map<Object, CodeGenSnippet> globalSnippets) {
		super(PivotUtil.getMetaModelManager(genModel.eResource()), globalSnippets);
		this.genModel = genModel;
		metaModelManager.addGenModel(genModel);
		cgAnalyzer = new CodeGenAnalyzer(this);
		nameManager.reserveName(INSTANCE_NAME, null);
		GenPackage genPackage = genModel.getGenPackages().get(0);
		constantsClassName = genPackage.getQualifiedPackageName() + "." + genPackage.getPrefix() + AbstractGenModelHelper.TABLES_CLASS_SUFFIX;
	}

	private void activateGuards(@NonNull CodeGenAnalysis analysis) {
		Set<CodeGenAnalysis> invalidGuards = analysis.getInvalidGuards();
		if (invalidGuards != null) {
			for (CodeGenAnalysis invalidGuard : invalidGuards) {
				getSnippet(invalidGuard.getExpression()).getName();
			}
		}
		Set<CodeGenAnalysis> nullGuards = analysis.getNullGuards();
		if (nullGuards != null) {
			for (CodeGenAnalysis nullGuard : nullGuards) {
				getSnippet(nullGuard.getExpression()).getName();
			}
		}
		CodeGenAnalysis[] children = analysis.getChildren();
		if (children != null) {
			for (CodeGenAnalysis child : children) {
				assert child != null;
				activateGuards(child);
			}
		}
	}

	@Override
	protected @NonNull ImportManager createImportManager() {
		return new JETImportManager();
	}

	@Override
	protected @NonNull CodeGenSnippet createEvaluatorSnippet(@NonNull CodeGenSnippet referringSnippet) {
		final CodeGenSnippet snippet = new JavaSnippet(getEvaluatorName(), TypeId.OCL_ANY, DomainEvaluator.class, this, "",
			CodeGenSnippet.NON_NULL | CodeGenSnippet.SYNTHESIZED);
		referringSnippet.addDependsOn(snippet);
		addDependency(CodeGenerator.LOCAL_ROOT, snippet);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.append("new ");
				text.appendClassReference(EcoreExecutorManager.class);
				text.append("(");
				text.appendReferenceTo(null, getSelfSnippet(snippet));
				text.append(", ");
				text.appendClassReference(PivotTables.class);		// FIXME
				text.append(".LIBRARY)");
			}
		});
	}

	@Override
	protected @NonNull CodeGenSnippet createSelfSnippet() {
		CodeGenSnippet snippet = new JavaSnippet(getSelfName(), TypeId.OCL_ANY, Object.class, this, "",
			CodeGenSnippet.NON_NULL | CodeGenSnippet.SYNTHESIZED);
//			System.out.println("selfSnippet " + DomainUtil.debugSimpleName(selfSnippet2));
		setSnippet(expression.getContextVariable(), snippet);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.append("this");
			}
		});
	}

	public @Nullable CodeGenAnalysis findAnalysis(@NonNull Element element) {
		return cgAnalyzer.findAnalysis(element);
	}

	public @NonNull Map<String, String> generateBodies() {
		for (Iterator<GenPackage> genPackages = genModel.getGenPackages().iterator(); genPackages.hasNext(); ) {
			genPackage = genPackages.next();
			for (Iterator<GenClassifier> genClassifiers = genPackage.getGenClassifiers().iterator(); genClassifiers.hasNext(); ) {
				genClassifier = genClassifiers.next();
				generateClassBodies();
			}
		}
		return bodies;
	}

	protected void generateClassBodies() {
		EClassifier eClassifier = DomainUtil.nonNullEMF(genClassifier.getEcoreClassifier());
		String selfClassName = DomainUtil.nonNullEMF(genClassifier.getRawInstanceClassName());
		org.eclipse.ocl.examples.pivot.Class pivotClass = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Class.class, eClassifier);
		assert pivotClass != null;
		//
		//	Unused globals -- FIXME delete
		//
		CodeGenSnippet globalRoot = createCodeGenSnippet("", CodeGenSnippet.GLOBAL | CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		getSnippetLabel(GLOBAL_ROOT).push(globalRoot);
		//
		//	Class invariants
		//
		List<Constraint> ownedRules = new ArrayList<Constraint>(pivotClass.getOwnedRule());
		Collections.sort(ownedRules, nameComparator);
		for (Iterator<Constraint> rules = ownedRules.iterator(); rules.hasNext(); ) {
			constraint = rules.next();
			specification = constraint.getSpecification();
			expression = PivotUtil.getExpressionInOCL(pivotClass, DomainUtil.nonNullModel(specification));
			if ((expression != null) && (expression.getContextVariable() != null)) {
				@SuppressWarnings("null")@NonNull String booleanName = Boolean.class.getName();
				String body = generateExpressionBody(null, selfClassName, booleanName);
				String fragmentURI = getFragmentURI(pivotClass) + "==" + getRuleName(constraint);
				bodies.put(fragmentURI, body);
			}
		}
		//
		//	Operation bodies
		//
		List<Operation> ownedOperations = new ArrayList<Operation>(PivotQueries.getOperations(pivotClass));
		Collections.sort(ownedOperations, nameComparator);
		for (Operation anOperation : ownedOperations) {
			assert anOperation != null;
			for (Iterator<Constraint> rules = anOperation.getOwnedRule().iterator(); rules.hasNext(); ) {
				constraint = rules.next();
				specification = constraint.getSpecification();
				expression = PivotUtil.getExpressionInOCL(anOperation, DomainUtil.nonNullModel(specification));
				if ((expression != null) && (expression.getContextVariable() != null)) {
					String returnClassName;
					try {
						returnClassName = genModelHelper.getOperationReturnType(anOperation);
					} catch (GenModelException e) {
						returnClassName = "Object";		// FIXME
					}
					String body = generateExpressionBody(anOperation, selfClassName, returnClassName);
					String fragmentURI = getFragmentURI(anOperation);
					bodies.put(fragmentURI, body);
				}
			}
		}
		//
		//	Property bodies
		//
		List<Property> ownedProperties = new ArrayList<Property>(PivotQueries.getProperties(pivotClass));
		Collections.sort(ownedProperties, nameComparator);
		for (Property aProperty : ownedProperties) {
			assert aProperty != null;
			for (Iterator<Constraint> rules = aProperty.getOwnedRule().iterator(); rules.hasNext(); ) {
				constraint = rules.next();
				specification = constraint.getSpecification();
				expression = PivotUtil.getExpressionInOCL(aProperty, DomainUtil.nonNullModel(specification));
				if ((expression != null) && (expression.getContextVariable() != null)) {
					String returnClassName;
					try {
						returnClassName = genModelHelper.getPropertyResultType(aProperty);
					} catch (GenModelException e) {
						returnClassName = "Object";		// FIXME
					}
					String body = generateExpressionBody(aProperty, selfClassName, returnClassName);
					String fragmentURI = getFragmentURI(aProperty);
					bodies.put(fragmentURI, body);
				}
			}
		}
	}

	protected String generateExpressionBody(@Nullable Feature feature, @NonNull String className, @NonNull String returnClassName) {
		boolean isRequired = (feature == null) || feature.isRequired();
//		String returnClass = feature != null ? className : Boolean.class.getSimpleName();
		CodeGenSnippet snippet = createCodeGenSnippet("", CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		//
		// Start with a comment containing the OCL
		//
		CodeGenText oclComment = snippet.appendIndentedText("");
		oclComment.appendCommentWithOCL(null, expression);
		//
		//	The a placeholding scope for the local variables
		//
		CodeGenSnippet scopeSnippet = push();
		snippet.appendContentsOf(scopeSnippet);
		//
		//	Reserve parameter names
		//
		if (feature == null) {
			nameManager.reserveName("diagnostics", null);
			nameManager.reserveName("context", null);
		}
		CodeGenAnalysis rootAnalysis = cgAnalyzer.analyze(expression, isRequired);
		cgAnalyzer.optimize(rootAnalysis);
		//
		OCLExpression bodyExpression = DomainUtil.nonNullModel(expression.getBodyExpression());
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
		CodeGenSnippet evaluateSnippet = snippet.appendIndentedNodes("", CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		CodeGenSnippet evaluateNodes = evaluateSnippet.appendIndentedNodes("", CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		CodeGenSnippet evaluateBodySnippet = evaluateNodes.appendUnboxedGuardedChild(bodyExpression, isRequired && (feature != null) ? DomainMessage.NULL : null, DomainMessage.INVALID);
		if (evaluateBodySnippet != null) {
			if (!evaluateBodySnippet.isInvalid()) {
				if (feature == null) {
					String validatorClass = genModelHelper.getQualifiedValidatorClassName(genPackage);
					boolean isConstant = evaluateBodySnippet.isConstant();
					if (isConstant && (evaluateBodySnippet.getConstantValue() == Boolean.TRUE)) {
						evaluateNodes.append("return true;\n");
					}
					else {
						if (!isConstant) {
							CodeGenText ifOkText = evaluateNodes.append("if (");
						    ifOkText.appendReferenceTo(null, evaluateBodySnippet);
						    ifOkText.append(" == ");
						    ifOkText.appendReferenceTo(null, getSnippet(true));
						    ifOkText.append(") {\n");
								CodeGenSnippet returnNodes = evaluateNodes.appendIndentedNodes(null, CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
								returnNodes.append("return true;\n");
						    evaluateNodes.append("}\n");
						}
					    evaluateNodes.append("if (diagnostics != null) {\n");
							String constraintName = constraint.getName();
							String constraintLiteralName = CodeGenUtil.upperName(genClassifier.getName()) + "__" + CodeGenUtil.upperName(constraintName != null ? constraintName : "");
							String severityName = nameManager.reserveName("severity", null);
							String messageName = nameManager.reserveName("message", null);
							CodeGenSnippet diagsNodes = evaluateNodes.appendIndentedNodes(null, CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
							CodeGenText severityText = diagsNodes.append("int " + severityName + " = ");
							severityText.appendReferenceTo(null, evaluateBodySnippet);
							severityText.append(" == null ? ");
							severityText.appendClassReference(Diagnostic.class);
							severityText.append(".ERROR : ");
							severityText.appendClassReference(Diagnostic.class);
							severityText.append(".WARNING;\n");
							CodeGenText messageText = diagsNodes.append("String " + messageName + " = ");
							messageText.appendClassReference(NLS.class);
							messageText.append(".bind(");
							messageText.appendClassReference(EvaluatorMessages.class);
							messageText.append(".ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"");
							messageText.append(genClassifier.getName());
							messageText.append("\", \"");
							messageText.append(constraintName!= null ? constraintName : "UnnamedConstraint");
							messageText.append("\", ");
							messageText.appendClassReference(EObjectValidator.class);
							messageText.append(".getObjectLabel(this, context)});\n");
							CodeGenText addText = diagsNodes.append("diagnostics.add(new ");
							addText.appendClassReference(BasicDiagnostic.class);
							addText.append("(" + severityName + ", ");
							addText.appendClassReference(validatorClass);
							addText.append(".DIAGNOSTIC_SOURCE, ");
							addText.appendClassReference(validatorClass);
							addText.append("." + constraintLiteralName + ", " + messageName + ", new Object [] { this }));\n");
					    evaluateNodes.append("}\n");
					    evaluateNodes.append("return false;\n");
					}
				}
				else  {
				    CodeGenText returnText = evaluateNodes.append("return ");
				    String bodyTypeName = evaluateBodySnippet.getJavaClassName();
					if (!returnClassName.equals(bodyTypeName)) {
						returnText.append("(");
						returnText.appendClassReference(returnClassName);
						returnText.append(")");
					}
					returnText.appendReferenceTo(null, evaluateBodySnippet);
					returnText.append(";\n");
				}
			}
			else if (!evaluateBodySnippet.isCaught() && !evaluateBodySnippet.isInline()) {
				/* Already thrown */
			}
			else {
			    CodeGenText returnText = evaluateNodes.append("throw ");
				returnText.appendReferenceTo(Exception.class, evaluateBodySnippet);
				returnText.append(";\n");
			}
		}

		
		activateGuards(rootAnalysis);
		pop();
		Set<CodeGenSnippet> liveSnippets = new HashSet<CodeGenSnippet>();
		Set<String> referencedClasses = new HashSet<String>();
		snippet.gatherLiveSnippets(liveSnippets, referencedClasses);
		LinkedHashMap<CodeGenText, String> flatContents = snippet.flatten();
		StringBuilder s = new StringBuilder();
		for (Map.Entry<CodeGenText, String> entry : flatContents.entrySet()) {
			CodeGenText key = entry.getKey();
			if (!key.getSnippet().isGlobal()) {		// Global goes in Constants file
				String value = entry.getValue();
				key.toString(s, value);
			}
		}
		String javaCodeSource = s.toString();
		return javaCodeSource;
	}

	public @NonNull CodeGenAnalysis getAnalysis(@NonNull Element element) {
		return cgAnalyzer.getAnalysis(element);
	}

	@Override
	public @NonNull String getConstantsClass() {
		return constantsClassName;
	}

	protected String getFragmentURI(@NonNull Element element) {
		return EcoreUtil.getURI(element).fragment().toString();
	}

	protected String getRuleName(@NonNull Constraint constraint) {
		String name = constraint.getName();
		return name != null ? name : "";
	}

	@Override
	public @NonNull String getSelfName() {
		return "self";
	}
}
