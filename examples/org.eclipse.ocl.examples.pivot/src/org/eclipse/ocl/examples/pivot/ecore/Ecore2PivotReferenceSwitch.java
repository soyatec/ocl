/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: Ecore2PivotReferenceSwitch.java,v 1.9 2011/05/12 06:07:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.library.LibraryConstants;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.library.JavaCompareToOperation;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class Ecore2PivotReferenceSwitch extends EcoreSwitch<Object>
{				
    /**
     * The key that identifies opposite role names in an annotation
     */
    public static final String PROPERTY_OPPOSITE_ROLE_NAME_KEY = "Property.oppositeRoleName"; //$NON-NLS-1$
    public static final Object PROPERTY_OPPOSITE_ROLE_UNIQUE_KEY = "Property.oppositeUnique"; //$NON-NLS-1$
    public static final Object PROPERTY_OPPOSITE_ROLE_ORDERED_KEY = "Property.oppositeOrdered"; //$NON-NLS-1$
    public static final Object PROPERTY_OPPOSITE_ROLE_LOWER_KEY = "Property.oppositeLower"; //$NON-NLS-1$
    public static final Object PROPERTY_OPPOSITE_ROLE_UPPER_KEY = "Property.oppositeUpper"; //$NON-NLS-1$

    protected final Ecore2Pivot converter;
	protected final MetaModelManager metaModelManager;
	
	public Ecore2PivotReferenceSwitch(Ecore2Pivot converter) {
		this.converter = converter;
		this.metaModelManager = converter.getMetaModelManager();
	}
	
	@Override
	public Object caseEAnnotation(EAnnotation eObject) {
		@SuppressWarnings("null") @NonNull EAnnotation eObject2 = eObject;
		Annotation pivotElement = converter.getCreated(Annotation.class, eObject2);
		if (pivotElement != null) {
			doSwitchAll(Element.class, pivotElement.getReference(), eObject2.getReferences());
		}
		return null;
	}

	@Override
	public Object caseEClass(EClass eObject) {
		@SuppressWarnings("null") @NonNull EClass eObject2 = eObject;
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Class.class, eObject2);
		if (pivotElement != null) {
			doSwitchAll(Type.class, pivotElement.getSuperClass(), eObject2.getEGenericSuperTypes());
			if (pivotElement.getSuperClass().isEmpty()) {
				org.eclipse.ocl.examples.pivot.Class oclElementType = metaModelManager.getOclElementType();
				pivotElement.getSuperClass().add(oclElementType);
			}
		}
		return null;
	}

	@Override
	public Object caseEDataType(EDataType eObject) {
		@SuppressWarnings("null") @NonNull EDataType eObject2 = eObject;
		DataType pivotElement = converter.getCreated(DataType.class, eObject2);
		if (pivotElement != null) {
			Class<?> instanceClass = eObject2.getInstanceClass();
			if (instanceClass != null) {
				try {
					Method declaredMethod = instanceClass.getDeclaredMethod("compareTo", instanceClass);
					if (declaredMethod != null) {
						Operation operation = PivotFactory.eINSTANCE.createOperation();
						operation.setName(LibraryConstants.COMPARE_TO);
						operation.setImplementation(new JavaCompareToOperation(declaredMethod));
						Parameter parameter = PivotFactory.eINSTANCE.createParameter();
						parameter.setName("that");
						parameter.setType(metaModelManager.getOclSelfType());
						operation.getOwnedParameter().add(parameter);
						operation.setType(metaModelManager.getIntegerType());
						pivotElement.getOwnedOperation().add(operation);
						pivotElement.getSuperClass().add(metaModelManager.getOclComparableType());
					}
				} catch (Exception e) {
				}
			}
		}
		return null;
	}

	@Override
	public Object caseEEnum(EEnum eObject) {
		return null;
	}

	@Override
	public Object caseEOperation(EOperation eObject) {
		@SuppressWarnings("null") @NonNull EOperation eObject2 = eObject;
		Operation pivotElement = converter.getCreated(Operation.class, eObject2);
		if (pivotElement != null) {
			doSwitchAll(Type.class, pivotElement.getRaisedException(), eObject2.getEGenericExceptions());
		}
		return null;
	}

	@Override
	public Object caseEReference(EReference eObject) {
//		Property pivotElement = converter.getCreated(Property.class, eObject);		
		Property pivotElement = (Property) caseETypedElement(eObject);
		doSwitchAll(Property.class, pivotElement.getKeys(), eObject.getEKeys());
		Property oppositeProperty = null;
		EReference eOpposite = eObject.getEOpposite();
		if (eOpposite != null) {
			oppositeProperty = converter.getCreated(Property.class, eOpposite);
		}
		else {
			EAnnotation oppositeRole = eObject.getEAnnotation(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0);
			if (oppositeRole != null) {
				EMap<String, String> details = oppositeRole.getDetails();
				String oppositeName = details.get(PROPERTY_OPPOSITE_ROLE_NAME_KEY);
				if (oppositeName != null) {
					oppositeProperty = PivotFactory.eINSTANCE.createProperty();
					oppositeProperty.setName(oppositeName);
					oppositeProperty.setImplicit(true);
					Type remoteType = pivotElement.getType();
					Type localType = PivotUtil.getOwningType(pivotElement);
					oppositeProperty.setType(localType);
					String uniqueValue = details.get(PROPERTY_OPPOSITE_ROLE_UNIQUE_KEY);
					String orderedValue = details.get(PROPERTY_OPPOSITE_ROLE_ORDERED_KEY);
					String lowerValue = details.get(PROPERTY_OPPOSITE_ROLE_LOWER_KEY);
					String upperValue = details.get(PROPERTY_OPPOSITE_ROLE_UPPER_KEY);
					boolean isOrdered = orderedValue != null ? Boolean.valueOf(orderedValue) : false;
					boolean isUnique = uniqueValue != null ? Boolean.valueOf(uniqueValue) : true;
					long lower = lowerValue != null ? Long.parseLong(lowerValue) : 1;
					long upper = upperValue != null ? Long.parseLong(upperValue) : 1;
					if (upper != 1) {
						oppositeProperty.setType(metaModelManager.getCollectionType(isOrdered, isUnique, localType, BigInteger.valueOf(lower), BigInteger.valueOf(upper)));
						oppositeProperty.setIsRequired(true);
					}
					else {
						oppositeProperty.setType(localType);
						oppositeProperty.setIsRequired(lower == 1);
					}
					remoteType.getOwnedAttribute().add(oppositeProperty);
					oppositeProperty.setOpposite(pivotElement);
				}
			}
			else {
				oppositeRole = eObject.getEAnnotation(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
				if (oppositeRole != null) {
					EMap<String, String> details = oppositeRole.getDetails();
					String oppositeName = details.get(EMOFExtendedMetaData.EMOF_COMMENT_BODY);
					if (oppositeName != null) {
						oppositeProperty = PivotFactory.eINSTANCE.createProperty();
						oppositeProperty.setName(oppositeName);
						oppositeProperty.setImplicit(true);
						Type remoteType = pivotElement.getType();
						Type localType = PivotUtil.getOwningType(pivotElement);
						oppositeProperty.setType(localType);
						remoteType.getOwnedAttribute().add(oppositeProperty);
						oppositeProperty.setOpposite(pivotElement);
					}
				}
			}
		}
		if (oppositeProperty != null) {
			pivotElement.setOpposite(oppositeProperty);
		}
//		else if (eObject.eContainer() instanceof EClass) {		// Skip annotation references
//			metaModelManager.installPropertyDeclaration(pivotElement);
//		}
		return pivotElement;
	}

	@Override
	public TypedElement caseETypedElement(ETypedElement eObject) {
		@SuppressWarnings("null") @NonNull ETypedElement eObject2 = eObject;
		TypedElement pivotElement = converter.getCreated(TypedElement.class, eObject2);
		if (pivotElement != null) {
			EGenericType eType = eObject2.getEGenericType();
			if (eType != null) {
				Type pivotType = converter.getPivotType(eType);
				long upper = eObject.getUpperBound();
				if (upper != 1) {
					long lower = eObject.getLowerBound();
					boolean isOrdered = eObject.isOrdered();
					boolean isUnique = eObject.isUnique();
					if (pivotType != null) {
						pivotType = metaModelManager.getCollectionType(isOrdered, isUnique, pivotType, BigInteger.valueOf(lower), BigInteger.valueOf(upper));
					}
				}
				pivotElement.setType(pivotType);
			}
			else {
				pivotElement.setType(metaModelManager.getOclVoidType());
			}
		}
		return pivotElement;
	}

	@Override
	public Object caseETypeParameter(ETypeParameter eObject) {
		@SuppressWarnings("null") @NonNull ETypeParameter eObject2 = eObject;
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Class.class, eObject2);
		if (pivotElement != null) {
			TypeTemplateParameter typeTemplateParameter = (TypeTemplateParameter) pivotElement.getTemplateParameter();
			doSwitchAll(Type.class, typeTemplateParameter.getConstrainingType(), eObject2.getEBounds());
		}
		return null;
	}

	public Object doInPackageSwitch(EObject eObject) {
		int classifierID = eObject.eClass().getClassifierID();
		return doSwitch(classifierID, eObject);
	}

	public <T extends Element> void doSwitchAll(Class<T> pivotClass, Collection<T> pivotElements, List<? extends EObject> eObjects) {
		@SuppressWarnings("null") @NonNull Class<T> pivotClass2 = pivotClass;
		for (EObject eObject : eObjects) {
			if (eObject != null) {
				T pivotElement = converter.getPivotElement(pivotClass2, eObject);
				if (pivotElement != null) {
					pivotElements.add(pivotElement);
				}
			}
		}
	}
}