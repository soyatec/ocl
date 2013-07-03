/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: AssociationClassImpl.java,v 1.4 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.AssociationClassImpl#getUnownedAttribute <em>Unowned Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationClassImpl
		extends ClassImpl
		implements AssociationClass {

	/**
	 * The cached value of the '{@link #getUnownedAttribute() <em>Unowned Attribute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnownedAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> unownedAttribute;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.ASSOCIATION_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Property> getUnownedAttribute()
	{
		if (unownedAttribute == null)
		{
			unownedAttribute = new EObjectWithInverseResolvingEList<Property>(Property.class, this, PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE, PivotPackage.PROPERTY__ASSOCIATION);
		}
		return unownedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.ASSOCIATION_CLASS__EXTENSION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__OWNING_TEMPLATE_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__TEMPLATE_PARAMETER:
				if (templateParameter != null)
					msgs = ((InternalEObject)templateParameter).eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
				return basicSetTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__TEMPLATE_BINDING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplateBinding()).basicAdd(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.ASSOCIATION_CLASS__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPackage((org.eclipse.ocl.examples.pivot.Package)otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__OWNED_ATTRIBUTE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedAttribute()).basicAdd(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__OWNED_OPERATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperation()).basicAdd(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUnownedAttribute()).basicAdd(otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.ASSOCIATION_CLASS__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__OWNING_TEMPLATE_PARAMETER:
				return basicSetOwningTemplateParameter(null, msgs);
			case PivotPackage.ASSOCIATION_CLASS__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case PivotPackage.ASSOCIATION_CLASS__TEMPLATE_BINDING:
				return ((InternalEList<?>)getTemplateBinding()).basicRemove(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case PivotPackage.ASSOCIATION_CLASS__PACKAGE:
				return basicSetPackage(null, msgs);
			case PivotPackage.ASSOCIATION_CLASS__OWNED_ATTRIBUTE:
				return ((InternalEList<?>)getOwnedAttribute()).basicRemove(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__OWNED_OPERATION:
				return ((InternalEList<?>)getOwnedOperation()).basicRemove(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__OWNED_INVARIANT:
				return ((InternalEList<?>)getOwnedInvariant()).basicRemove(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__OWNED_BEHAVIOR:
				return ((InternalEList<?>)getOwnedBehavior()).basicRemove(otherEnd, msgs);
			case PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE:
				return ((InternalEList<?>)getUnownedAttribute()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.ASSOCIATION_CLASS__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.ASSOCIATION_CLASS__EXTENSION:
				return getExtension();
			case PivotPackage.ASSOCIATION_CLASS__NAME:
				return getName();
			case PivotPackage.ASSOCIATION_CLASS__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.ASSOCIATION_CLASS__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.ASSOCIATION_CLASS__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.ASSOCIATION_CLASS__TEMPLATE_BINDING:
				return getTemplateBinding();
			case PivotPackage.ASSOCIATION_CLASS__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.ASSOCIATION_CLASS__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.ASSOCIATION_CLASS__PACKAGE:
				return getPackage();
			case PivotPackage.ASSOCIATION_CLASS__OWNED_ATTRIBUTE:
				return getOwnedAttribute();
			case PivotPackage.ASSOCIATION_CLASS__OWNED_OPERATION:
				return getOwnedOperation();
			case PivotPackage.ASSOCIATION_CLASS__SUPER_CLASS:
				return getSuperClass();
			case PivotPackage.ASSOCIATION_CLASS__OWNED_INVARIANT:
				return getOwnedInvariant();
			case PivotPackage.ASSOCIATION_CLASS__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.ASSOCIATION_CLASS__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.ASSOCIATION_CLASS__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.ASSOCIATION_CLASS__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case PivotPackage.ASSOCIATION_CLASS__IS_INTERFACE:
				return isInterface();
			case PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE:
				return getUnownedAttribute();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.ASSOCIATION_CLASS__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				getTemplateBinding().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				getOwnedAttribute().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_OPERATION:
				getOwnedOperation().clear();
				getOwnedOperation().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__SUPER_CLASS:
				getSuperClass().clear();
				getSuperClass().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				getOwnedInvariant().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				getOwnedBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE:
				getUnownedAttribute().clear();
				getUnownedAttribute().addAll((Collection<? extends Property>)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.ASSOCIATION_CLASS__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.ASSOCIATION_CLASS__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.ASSOCIATION_CLASS__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.ASSOCIATION_CLASS__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.ASSOCIATION_CLASS__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_ATTRIBUTE:
				getOwnedAttribute().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_OPERATION:
				getOwnedOperation().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS__SUPER_CLASS:
				getSuperClass().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_INVARIANT:
				getOwnedInvariant().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_BEHAVIOR:
				getOwnedBehavior().clear();
				return;
			case PivotPackage.ASSOCIATION_CLASS__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE:
				getUnownedAttribute().clear();
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.ASSOCIATION_CLASS__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ASSOCIATION_CLASS__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.ASSOCIATION_CLASS__TEMPLATE_PARAMETER:
				return isSetTemplateParameter();
			case PivotPackage.ASSOCIATION_CLASS__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.ASSOCIATION_CLASS__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.ASSOCIATION_CLASS__PACKAGE:
				return getPackage() != null;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_ATTRIBUTE:
				return isSetOwnedAttribute();
			case PivotPackage.ASSOCIATION_CLASS__OWNED_OPERATION:
				return isSetOwnedOperation();
			case PivotPackage.ASSOCIATION_CLASS__SUPER_CLASS:
				return isSetSuperClass();
			case PivotPackage.ASSOCIATION_CLASS__OWNED_INVARIANT:
				return ownedInvariant != null && !ownedInvariant.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS__INSTANCE_CLASS_NAME:
				return isSetInstanceClassName();
			case PivotPackage.ASSOCIATION_CLASS__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.ASSOCIATION_CLASS__OWNED_BEHAVIOR:
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case PivotPackage.ASSOCIATION_CLASS__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE:
				return unownedAttribute != null && !unownedAttribute.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitAssociationClass(this);
	}
} //AssociationClassImpl
