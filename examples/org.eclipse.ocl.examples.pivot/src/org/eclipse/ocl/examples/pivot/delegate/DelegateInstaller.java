/**
 * <copyright>
 * 
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: PivotInstaller.java,v 1.3 2011/04/25 09:49:15 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLCommon;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.options.OCLinEcoreOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.uml2.codegen.ecore.genmodel.util.UML2GenModelUtil;

public class DelegateInstaller
{
	public static @Nullable String getDelegateURI(@NonNull List<EObject> contents) {
		for (EObject eObject : contents) {
			if (eObject instanceof EPackage) {
				String exportURI = getDelegateURI((EPackage)eObject);
				if (exportURI != null) {
					return exportURI;
				}
			}
		}
		return null;
	}

	public static @Nullable String getDelegateURI(@NonNull EPackage ePackage) {
		Set<String> allURIs = new HashSet<String>();
//		allURIs.addAll(EcoreUtil.getConversionDelegates(ePackage));
		allURIs.addAll(EcoreUtil.getInvocationDelegates(ePackage));
//		allURIs.addAll(EcoreUtil.getQueryDelegates(ePackage));
		allURIs.addAll(EcoreUtil.getSettingDelegates(ePackage));
		allURIs.addAll(EcoreUtil.getValidationDelegates(ePackage));
		String theURI = null;
		for (String uri : allURIs) {
			if (uri.startsWith(OCLConstants.OCL_DELEGATE_URI)) {
				if (theURI != null) {
					return OCLConstants.OCL_DELEGATE_URI;
				}
				theURI = uri;
			}
		}
		if (theURI != null) {
			return theURI;
		}
		for (@SuppressWarnings("null")@NonNull EPackage eSubpackage : ePackage.getESubpackages()) {
			String exportURI = getDelegateURI(eSubpackage);
			if (exportURI != null) {
				return exportURI;
			}
		}
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			EAnnotation classifierAnnotation = OCLCommon.getDelegateAnnotation(eClassifier);
			if ((classifierAnnotation != null) && !classifierAnnotation.getDetails().isEmpty()) {
				return classifierAnnotation.getSource();
			}
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
					EAnnotation featureAnnotation = OCLCommon.getDelegateAnnotation(eFeature);
					if ((featureAnnotation != null) && !featureAnnotation.getDetails().isEmpty()) {
						return featureAnnotation.getSource();
					}
				}
				for (EOperation eOperation : eClass.getEOperations()) {
					EAnnotation operationAnnotation = OCLCommon.getDelegateAnnotation(eOperation);
					if ((operationAnnotation != null) && !operationAnnotation.getDetails().isEmpty()) {
						return operationAnnotation.getSource();
					}
				}
			}
		}
		return null;
	}

	public static boolean needsDelegates(@NonNull EPackage ePackage) {
		boolean needsDelegates = false;
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			EAnnotation classifierAnnotation = OCLCommon.getDelegateAnnotation(eClassifier);
			if ((classifierAnnotation != null) && !classifierAnnotation.getDetails().isEmpty()) {
				needsDelegates = true;
				break;
			}
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
					EAnnotation featureAnnotation = OCLCommon.getDelegateAnnotation(eFeature);
					if ((featureAnnotation != null) && !featureAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
				for (EOperation eOperation : eClass.getEOperations()) {
					EAnnotation operationAnnotation = OCLCommon.getDelegateAnnotation(eOperation);
					if ((operationAnnotation != null) && !operationAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
			}
		}
		return needsDelegates;
	}

	protected final @NonNull MetaModelManager metaModelManager;
	protected final String exportDelegateURI;
	
	public DelegateInstaller(@NonNull MetaModelManager metaModelManager, @Nullable String exportDelegateURI) {
		this.metaModelManager = metaModelManager;
		this.exportDelegateURI = exportDelegateURI != null ? exportDelegateURI : OCLinEcoreOptions.EXPORT_DELEGATION_URI.getPreferredValue();
	}
	
	/**
	 * Install all Constraints from pivotPackage and its nestedPackages as OCL Delegates.
	 * 
	 * @param metaModelManager
	 * @param pivotPackage
	 */
	public void installDelegates(@NonNull PackageServer packageServer) {
		boolean hasDelegates = false;
//		for (Type aType : metaModelManager.getLocalClasses(pivotPackage)) {
		for (TypeServer typeServer : packageServer.getMemberTypes()) {
			if (installDelegates(typeServer.getPivotType())) {
				hasDelegates = true;
			}
		}
//		PackageServer packageServer = metaModelManager.getPackageServer(pivotPackage);
		EPackage ePackage = packageServer.getEPackage();
		if ((ePackage != null) && hasDelegates) {
			installDelegates(ePackage);
		}
		for (PackageServer nestedPackage : packageServer.getMemberPackages()) {
			if (nestedPackage != null) {
				installDelegates(nestedPackage);
			}
		}
	}

	/**
	 * Install all Constraints from pivotType and its operations as OCL Delegates. Returning true if any OCL Delegate installed.
	 * 
	 * @param metaModelManager
	 * @param pivotPackage
	 */
	private boolean installDelegates(@NonNull Type pivotType) {
		boolean hasDelegates = false;
		Type primaryType = metaModelManager.getPrimaryType(pivotType);
		EObject eTarget = primaryType.getETarget();
		if (eTarget instanceof EClassifier) {
			@NonNull EClassifier eClassifier = (EClassifier)eTarget;
			for (Constraint constraint : metaModelManager.getLocalInvariants(pivotType)) {
				EModelElement eContext;
				if (constraint.isCallable()) {
					String name = constraint.getName();
					eContext = null;
					for (EOperation candidate : ((EClass) eClassifier).getEOperations()) {
						if (name.equals(candidate.getName()) && EcoreUtil.isInvariant(candidate)) {
							eContext = candidate;
							break;
						}
					}
					if (eContext == null) {
						@NonNull EOperation eOperation = Pivot2Ecore.createConstraintEOperation(constraint, name);
						((EClass) eClassifier).getEOperations().add(eOperation);
						eContext = eOperation;
					}
				}
				else {
					eContext = eClassifier;
				}
				if ((eContext != null) && installDelegate(eContext, constraint, null)) {
					hasDelegates = true;
				}
			}
			for (Operation anOperation : metaModelManager.getMemberOperations(pivotType, false)) {
				EOperation eOperation = (EOperation)anOperation.getETarget();
				if (eOperation != null) {
					installDelegate(eOperation);
				}
			}
			for (Operation anOperation : metaModelManager.getMemberOperations(pivotType, true)) {
				EOperation eOperation = (EOperation)anOperation.getETarget();
				if (eOperation != null) {
					installDelegate(eOperation);
				}
			}
			for (Property aProperty : metaModelManager.getMemberProperties(pivotType, false)) {
				EStructuralFeature eFeature = (EStructuralFeature)aProperty.getETarget();
				if (eFeature != null) {
					installDelegate(eFeature);
				}
			}
			for (Property aProperty : metaModelManager.getMemberProperties(pivotType, true)) {
				EStructuralFeature eFeature = (EStructuralFeature)aProperty.getETarget();
				if (eFeature != null) {
					installDelegate(eFeature);
				}
			}
			for (EAnnotation eAnnotation : eClassifier.getEAnnotations()) {		// Fix redefines/duplicates
				for (TreeIterator<EObject> tit = eAnnotation.eAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					if (eObject instanceof EAnnotation) {
						EAnnotation nestedAnnotation = (EAnnotation) eObject;
						if (UML2GenModelUtil.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI.equals(nestedAnnotation.getSource())) {
							nestedAnnotation.setSource(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
						}
					}
				}
			}
			if (hasDelegates) {
				installDelegates(eClassifier, pivotType);
			}
		}
		return hasDelegates;
	}
	
	// FIXME eModelElement is only an EClassifier now
	public boolean installDelegate(@NonNull EModelElement eModelElement, @NonNull Constraint pivotConstraint, @Nullable URI ecoreURI) {
		OpaqueExpression specification = pivotConstraint.getSpecification();
		if (specification == null) {
			return false;
		}
		String exprString = PivotUtil.getBody(specification);
		Namespace namespace = PivotUtil.getNamespace(specification);
		PrettyPrintOptions.Global options = PrettyPrinter.createOptions(namespace);
		options.setBaseURI(ecoreURI);
		if ((exprString == null) && (specification instanceof ExpressionInOCL)) {
			exprString = PrettyPrinter.print(DomainUtil.nonNullModel(((ExpressionInOCL)specification).getBodyExpression()), options);
		}
		if (exprString == null) {
			return false;
		}
		EAnnotation oclAnnotation = removeDelegateAnnotations(eModelElement, exportDelegateURI);
		if (oclAnnotation == null) {
			oclAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			oclAnnotation.setSource(exportDelegateURI);
			eModelElement.getEAnnotations().add(oclAnnotation);
		}
//		String stereotype = pivotConstraint.getStereotype();
		String name = pivotConstraint.getName();
		EStructuralFeature eContainingFeature = pivotConstraint.eContainingFeature();
		if (eContainingFeature == PivotPackage.Literals.TYPE__OWNED_INVARIANT) {
			if (eModelElement instanceof EOperation) {
				oclAnnotation.getDetails().put("body", exprString);
			}
			else {
				oclAnnotation.getDetails().put(name, exprString);
				String messageString = PivotUtil.getMessage(specification);
				if ((messageString == null) && (specification instanceof ExpressionInOCL)) {
					OCLExpression messageExpression = ((ExpressionInOCL)specification).getMessageExpression();
					if (messageExpression != null) {
						messageString = PrettyPrinter.print(messageExpression, options);
					}
				}
				if ((messageString != null) && (messageString.length() > 0)) {
					oclAnnotation.getDetails().put(name + PivotConstants.MESSAGE_ANNOTATION_DETAIL_SUFFIX, messageString);
				}
			}
		}
		else if (eContainingFeature == PivotPackage.Literals.PROPERTY__DEFAULT_EXPRESSION) {
			oclAnnotation.getDetails().put(SettingBehavior.DERIVATION_CONSTRAINT_KEY, exprString);
		}
//		else if (eContainingFeature == PivotPackage.Literals.PROPERTY__DERIVATION_EXPRESSION) {
//			oclAnnotation.getDetails().put(SettingBehavior.INITIAL_CONSTRAINT_KEY, exprString);
//		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__BODY_EXPRESSION) {
			String key = name != null ? "body_" + name : InvocationBehavior.BODY_CONSTRAINT_KEY;
			oclAnnotation.getDetails().put(key, exprString);
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__PRECONDITION) {
			oclAnnotation.getDetails().put("pre_" + name, exprString);
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__POSTCONDITION) {
			oclAnnotation.getDetails().put("post_" + name, exprString);
		}
		else {
//			error("Unsupported " + pivotConstraint);
		}
		return true;
	}

	public void installDelegate(@NonNull EOperation eOperation) {
		List<EAnnotation> eAnnotations = eOperation.getEAnnotations();
		EAnnotation oclAnnotation = eOperation.getEAnnotation(UML2GenModelUtil.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
			oclAnnotation.setSource(exportDelegateURI);
			eAnnotations.add(oclAnnotation);
		}
	}

	public void installDelegate(@NonNull EStructuralFeature eFeature) {
		List<EAnnotation> eAnnotations = eFeature.getEAnnotations();
		EAnnotation oclAnnotation = eFeature.getEAnnotation(UML2GenModelUtil.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
			oclAnnotation.setSource(exportDelegateURI);
			eAnnotations.add(oclAnnotation);
		}
	}
	
	public void installDelegates(@NonNull EClassifier eClassifier, @NonNull Type pivotType) {
		StringBuilder s = null;
		for (Constraint pivotConstraint : metaModelManager.getLocalInvariants(pivotType)) {
			String constraintName = pivotConstraint.getName();
			if (!pivotConstraint.isCallable() && (constraintName != null)) {
				if (s == null) {
					s = new StringBuilder();
				}
				else {
					s.append(" ");
				}
				s.append(constraintName);
			}
		}
		EAnnotation eAnnotation = eClassifier.getEAnnotation(EcorePackage.eNS_URI);
		if (s != null) {
			if (eAnnotation == null) {
				eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(EcorePackage.eNS_URI);
				eClassifier.getEAnnotations().add(0, eAnnotation);
			}
			eAnnotation.getDetails().put("constraints", s.toString());
		}
		else {
			eClassifier.getEAnnotations().remove(eAnnotation);
		}
	}

	public void installDelegates(@NonNull EPackage ePackage) {
		EAnnotation packageAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
		if (packageAnnotation == null) {
			packageAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			packageAnnotation.setSource(EcorePackage.eNS_URI);
			ePackage.getEAnnotations().add(packageAnnotation);
		}
		EMap<String, String> details = packageAnnotation.getDetails();
		details.put(InvocationBehavior.NAME, exportDelegateURI);
		details.put(SettingBehavior.NAME, exportDelegateURI);
		details.put(ValidationBehavior.NAME, exportDelegateURI);
	}
	
	public boolean installOperationDelegate(@NonNull EOperation eOperation, @NonNull OpaqueExpression bodyExpression, @Nullable URI ecoreURI) {
		String exprString = PivotUtil.getBody(bodyExpression);
		Namespace namespace = PivotUtil.getNamespace(bodyExpression);
		PrettyPrintOptions.Global options = PrettyPrinter.createOptions(namespace);
		options.setBaseURI(ecoreURI);
		if ((exprString == null) && (bodyExpression instanceof ExpressionInOCL)) {
			exprString = PrettyPrinter.print(DomainUtil.nonNullModel(((ExpressionInOCL)bodyExpression).getBodyExpression()), options);
		}
		if (exprString == null) {
			return false;
		}
		EAnnotation oclAnnotation = removeDelegateAnnotations(eOperation, exportDelegateURI);
		if (oclAnnotation == null) { 
			oclAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			oclAnnotation.setSource(exportDelegateURI);
			eOperation.getEAnnotations().add(oclAnnotation);
		}
		oclAnnotation.getDetails().put(InvocationBehavior.BODY_CONSTRAINT_KEY, exprString);
		return true;
	}
	
	public boolean installPropertyDelegate(@NonNull EStructuralFeature eStructuralFeature, @NonNull OpaqueExpression defaultExpression, @Nullable URI ecoreURI) {
		String exprString = PivotUtil.getBody(defaultExpression);
		Namespace namespace = PivotUtil.getNamespace(defaultExpression);
		PrettyPrintOptions.Global options = PrettyPrinter.createOptions(namespace);
		options.setBaseURI(ecoreURI);
		if ((exprString == null) && (defaultExpression instanceof ExpressionInOCL)) {
			exprString = PrettyPrinter.print(DomainUtil.nonNullModel(((ExpressionInOCL)defaultExpression).getBodyExpression()), options);
		}
		if (exprString == null) {
			return false;
		}
		EAnnotation oclAnnotation = removeDelegateAnnotations(eStructuralFeature, exportDelegateURI);
		if (oclAnnotation == null) {
			oclAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			oclAnnotation.setSource(exportDelegateURI);
			eStructuralFeature.getEAnnotations().add(oclAnnotation);
		}
		oclAnnotation.getDetails().put(SettingBehavior.DERIVATION_CONSTRAINT_KEY, exprString);
		return true;
	}

	/**
	 * Remove all OCL Delegate annotations except that corresponding to exportDelegateURI which is returned.
	 */
	protected EAnnotation removeDelegateAnnotations(@NonNull EModelElement eModelElement, @Nullable String exportDelegateURI) {
		List<EAnnotation> eAnnotations = eModelElement.getEAnnotations();
		EAnnotation oclAnnotation = null;
		EAnnotation annotation1 = eModelElement.getEAnnotation(OCLConstants.OCL_DELEGATE_URI);
		if (annotation1 != null) {
			if (OCLConstants.OCL_DELEGATE_URI.equals(exportDelegateURI)) {
				oclAnnotation = annotation1;
			}
			else {
				eAnnotations.remove(annotation1);
			}
		}
		EAnnotation annotation2 = eModelElement.getEAnnotation(OCLConstants.OCL_DELEGATE_URI_LPG);
		if (annotation2 != null) {
			if (OCLConstants.OCL_DELEGATE_URI_LPG.equals(exportDelegateURI)) {
				oclAnnotation = annotation2;
			}
			else {
				eAnnotations.remove(annotation2);
			}
		}
		EAnnotation annotation3 = eModelElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		if (annotation3 != null) {
			if (OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT.equals(exportDelegateURI)) {
				oclAnnotation = annotation3;
			}
			else {
				eAnnotations.remove(annotation3);
			}
		}
		EAnnotation annotation4 = eModelElement.getEAnnotation(UML2GenModelUtil.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI);
		if (annotation4 != null) {
			eAnnotations.remove(annotation4);
		}
		return oclAnnotation;
	}
}