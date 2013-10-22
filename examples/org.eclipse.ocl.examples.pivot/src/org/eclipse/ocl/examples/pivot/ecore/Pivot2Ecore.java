/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: Pivot2Ecore.java,v 1.6 2011/05/20 19:06:01 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.delegate.DelegateInstaller;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.options.OCLinEcoreOptions;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.pivot.utilities.PivotObjectImpl;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class Pivot2Ecore extends AbstractConversion
{
	public static final Logger logger = Logger.getLogger(Pivot2Ecore.class);

	public static void copyAnnotationComments(@NonNull EAnnotation eModelElement, @NonNull Constraint pivotConstraint) {
		String key = DelegateInstaller.getAnnotationKey(pivotConstraint);
		EAnnotation commentAnnotation = eModelElement.getEAnnotation(PivotConstants.DOCUMENTATION_ANNOTATION_SOURCE);
		List<Comment> newComments = pivotConstraint.getOwnedComment();
		int iMax = newComments.size();
		if (iMax > 0) {
			if (commentAnnotation == null) {
				commentAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				commentAnnotation.setSource(PivotConstants.DOCUMENTATION_ANNOTATION_SOURCE);
				eModelElement.getEAnnotations().add(commentAnnotation);
			}
			StringBuilder s = new StringBuilder();
			for (int iComment = 0; iComment < iMax; iComment++) {
				if (iComment > 0) {
					s.append("\n");
				}
				s.append(newComments.get(iComment).getBody());
			}
			commentAnnotation.getDetails().put(key, s.toString());
		}
		else if (commentAnnotation != null) {
			commentAnnotation.getDetails().remove(key);
		}
	}

	public static void copyComments(EModelElement eModelElement, Element pivotElement) {
		EList<EAnnotation> allEAnnotations = eModelElement.getEAnnotations();
		List<Comment> newComments = pivotElement.getOwnedComment();
		int iComment = 0;
		int iMax = newComments.size();
		List<EAnnotation> removals = null;
		for (EAnnotation eAnnotation : allEAnnotations) {
			if (PivotConstants.DOCUMENTATION_ANNOTATION_SOURCE.equals(eAnnotation.getSource())) {
				if (iComment >= iMax) {
					if (removals == null) {
						removals = new ArrayList<EAnnotation>();
					}
					removals.add(eAnnotation);
				}
				else {
					String body = newComments.get(iComment).getBody();
					eAnnotation.getDetails().put(PivotConstants.DOCUMENTATION_ANNOTATION_KEY, body);
				}
				iComment++;
			}
		}
		for ( ; iComment < iMax; iComment++) {
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(PivotConstants.DOCUMENTATION_ANNOTATION_SOURCE);
			String body = newComments.get(iComment).getBody();
			eAnnotation.getDetails().put(PivotConstants.DOCUMENTATION_ANNOTATION_KEY, body);
			allEAnnotations.add(eAnnotation);
		}
		if (removals != null) {
			allEAnnotations.removeAll(removals);
		}
	}

	public static @NonNull EOperation createConstraintEOperation(Constraint pivotConstraint, String operationName) {
		EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
		eOperation.setName(operationName != null ? operationName : "");
		eOperation.setEType(EcorePackage.Literals.EBOOLEAN);
		EParameter firstParameter = EcoreFactory.eINSTANCE.createEParameter();
		firstParameter.setName("diagnostics");
		firstParameter.setEType(EcorePackage.Literals.EDIAGNOSTIC_CHAIN);
		eOperation.getEParameters().add(firstParameter);
		EParameter secondParameter = EcoreFactory.eINSTANCE.createEParameter();
		secondParameter.setName("context");
		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericType.setEClassifier(EcorePackage.Literals.EMAP);
		EGenericType firstTypeArgument = EcoreFactory.eINSTANCE.createEGenericType();
		firstTypeArgument.setEClassifier(EcorePackage.Literals.EJAVA_OBJECT);
		eGenericType.getETypeArguments().add(firstTypeArgument);
		EGenericType secondTypeArgument = EcoreFactory.eINSTANCE.createEGenericType();
		secondTypeArgument.setEClassifier(EcorePackage.Literals.EJAVA_OBJECT);
		eGenericType.getETypeArguments().add(secondTypeArgument);
		secondParameter.setEGenericType(eGenericType);
		eOperation.getEParameters().add(secondParameter);
		OpaqueExpression specification = pivotConstraint.getSpecification();
		if (specification != null) {
			String body = PivotUtil.getBody(specification);
			if (body != null) {
				EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(OCLinEcoreOptions.EXPORT_DELEGATION_URI.getPreferredValue());
				eAnnotation.getDetails().put("body", body);
				eOperation.getEAnnotations().add(eAnnotation);
			}
		}
		copyComments(eOperation, pivotConstraint);
		return eOperation;
	}

	public static @NonNull XMLResource createResource(@NonNull MetaModelManager metaModelManager, @NonNull Resource asResource, @NonNull URI ecoreURI, @Nullable Map<String,Object> options) {
		Pivot2Ecore converter = new Pivot2Ecore(metaModelManager, ecoreURI, options);
		return converter.convertResource(asResource, ecoreURI);
	}
	
	public static @NonNull Boolean getBoolean(@Nullable Map<String, Object> options, @NonNull String key) {
		if (options == null) {
			return false;
		}
		Object value = options.get(key);
		if (value instanceof Boolean) {
			return (Boolean) value;
		}
		if (value != null) {
			logger.error("Non-Boolean '" + key + "' for '" + value + "'");
		}
		return false;
	}
	
	public static @Nullable String getString(@Nullable Map<String, Object> options, @NonNull String key) {
		if (options == null) {
			return null;
		}
		Object value = options.get(key);
		if (value instanceof String) {
			return (String) value;
		}
		if (value != null) {
			logger.error("Non-String '" + key + "' for '" + value + "'");
		}
		return null;
	}

	/**
	 * Mapping of pivot elements to the resulting E elements.
	 */
	private final @NonNull Map<Element, EModelElement> createMap = new HashMap<Element, EModelElement>();

	/**
	 * Mapping of all E elements created during pass 1 that require further work
	 * with respect to the corresponding CS element in pass 2.
	 */
	private final @NonNull Set<Element> deferMap = new HashSet<Element>();
	
	private @Nullable List<Resource.Diagnostic> errors = null;
	
	protected final @NonNull DelegateInstaller delegateInstaller;
	protected final @NonNull Pivot2EcoreDeclarationVisitor pass1;	
	protected final @NonNull Pivot2EcoreReferenceVisitor pass2;
	protected final @NonNull URI ecoreURI;
	protected final @Nullable Map<String,Object> options;
	protected final @Nullable String primitiveTypesUriPrefix;
	
	public Pivot2Ecore(@NonNull MetaModelManager metaModelManager, @NonNull URI ecoreURI, @Nullable Map<String,Object> options) {
		super(metaModelManager);
		String exportDelegateURI = options != null ? (String)options.get(OCLConstants.OCL_DELEGATE_URI) : null;
		this.delegateInstaller = new DelegateInstaller(metaModelManager, exportDelegateURI);
		this.pass1 = new Pivot2EcoreDeclarationVisitor(this);	
		this.pass2 = new Pivot2EcoreReferenceVisitor(this);
		this.ecoreURI = ecoreURI;
		this.options = options;
		this.primitiveTypesUriPrefix = getString(options, PivotConstants.PRIMITIVE_TYPES_URI_PREFIX);
	}

	protected @Nullable Object convert(@NonNull Element pivotObject) {
		Object eObject = pass1.safeVisit(pivotObject);
		for (Element eKey : deferMap) {
			pass2.safeVisit(eKey);
		}
		return eObject;
	}

	public @NonNull XMLResource convertResource(@NonNull Resource asResource, @NonNull URI ecoreURI) {
		ResourceSet resourceSet = metaModelManager.getExternalResourceSet();
		XMLResource ecoreResource = (XMLResource) resourceSet.createResource(ecoreURI);
		List<EObject> contents = ecoreResource.getContents();
		for (EObject eContent : asResource.getContents()) {
			if (eContent instanceof Root) {
				Object results = pass1.safeVisit((Root)eContent);
				if (results instanceof List<?>) {
					@SuppressWarnings("unchecked")
					List<EObject> results2 = (List<EObject>)results;
					contents.addAll(results2);
				}
			}
		}
		for (Element eKey : deferMap) {
			pass2.safeVisit(eKey);
		}
		for (Element pivotElement : createMap.keySet()) {
			EObject eObject = createMap.get(pivotElement);
			((PivotObjectImpl) pivotElement).setTarget(eObject);
		}
		return ecoreResource;
	}

	public void defer(@NonNull Element pivotElement) {
		deferMap.add(pivotElement);
	}

	protected void error(@NonNull String message) {
		List<Diagnostic> errors2 = errors;
		if (errors2 == null) {
			errors = errors2 = new ArrayList<Resource.Diagnostic>();
		}
		errors2.add(new XMIException(message));
	}

	public <T extends EObject> T getCreated(@NonNull Class<T> requiredClass, @NonNull Element pivotElement) {
		EModelElement eModelElement = createMap.get(pivotElement);
//		System.out.println("Get " + PivotUtil.debugSimpleName(pivotElement) + " " + PivotUtil.debugSimpleName(eModelElement));
		if (eModelElement == null) {
			Element primaryElement = metaModelManager.getPrimaryElement(pivotElement);
			if (pivotElement != primaryElement) {
				eModelElement = createMap.get(primaryElement);
			}
		}
		if (eModelElement == null) {
			return null;
		}
		if (!requiredClass.isAssignableFrom(eModelElement.getClass())) {
			logger.error("Ecore " + eModelElement.getClass().getName() + "' element is not a '" + requiredClass.getName() + "'"); //$NON-NLS-1$
			return null;
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) eModelElement;
		return castElement;
	}

	public @NonNull DelegateInstaller getDelegateInstaller() {
		return delegateInstaller;
	}

	public final @NonNull URI getEcoreURI() {
		return ecoreURI;
	}

	public @Nullable Map<String, Object> getOptions() {
		return options;
	}

	public String getPrimitiveTypesUriPrefix() {
		return primitiveTypesUriPrefix;
	}

	/**
	 * Return tre if asPackage is a Pivot Metamodel.
	 */
	public boolean isPivot(@NonNull org.eclipse.ocl.examples.pivot.Package asPackage) {
		List<Type> asTypes = asPackage.getOwnedType();
		if (DomainUtil.getNamedElement(asTypes, PivotPackage.Literals.ENUMERATION_LITERAL.getName()) == null) {
			return false;
		}
		if (DomainUtil.getNamedElement(asTypes, PivotPackage.Literals.EXPRESSION_IN_OCL.getName()) == null) {
			return false;
		}
		if (DomainUtil.getNamedElement(asTypes, PivotPackage.Literals.OPERATION_CALL_EXP.getName()) == null) {
			return false;
		}
		if (DomainUtil.getNamedElement(asTypes, PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION.getName()) == null) {
			return false;
		}
		return true;
	}

	public void putCreated(@NonNull Element pivotElement, @NonNull EModelElement eModelElement) {
		Element primaryElement = metaModelManager.getPrimaryElement(pivotElement);
//		System.out.println("Put1 " + PivotUtil.debugSimpleName(pivotElement) + " " + PivotUtil.debugSimpleName(eModelElement));
		EModelElement oldPivot = createMap.put(pivotElement, eModelElement);
		assert oldPivot == null;
		if (pivotElement != primaryElement) {
//			System.out.println("Put2 " + PivotUtil.debugSimpleName(pivotElement) + " " + PivotUtil.debugSimpleName(eModelElement));
			EModelElement oldPrimary = createMap.put(primaryElement, eModelElement);
			assert oldPrimary == null;
		}
	}
}
