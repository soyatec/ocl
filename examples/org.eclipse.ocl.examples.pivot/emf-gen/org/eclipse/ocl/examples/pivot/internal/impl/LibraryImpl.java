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
 * $Id: LibraryImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.LibraryImpl#getOwnedPrecedence <em>Owned Precedence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends PackageImpl implements Library
{
	/**
	 * The cached value of the '{@link #getOwnedPrecedence() <em>Owned Precedence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPrecedence()
	 * @generated
	 * @ordered
	 */
	protected EList<Precedence> ownedPrecedence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Precedence> getOwnedPrecedence()
	{
		if (ownedPrecedence == null)
		{
			ownedPrecedence = new EObjectContainmentEList<Precedence>(Precedence.class, this, PivotPackage.LIBRARY__OWNED_PRECEDENCE);
		}
		return ownedPrecedence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Precedence createOwnedPrecedence()
	{
		Precedence newOwnedPrecedence = (Precedence) create(PivotPackage.Literals.PRECEDENCE);
		getOwnedPrecedence().add(newOwnedPrecedence);
		return newOwnedPrecedence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PivotPackage.LIBRARY__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.LIBRARY__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.LIBRARY__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.LIBRARY__OWNING_TEMPLATE_PARAMETER:
				return basicSetOwningTemplateParameter(null, msgs);
			case PivotPackage.LIBRARY__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case PivotPackage.LIBRARY__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRule()).basicRemove(otherEnd, msgs);
			case PivotPackage.LIBRARY__TEMPLATE_BINDING:
				return ((InternalEList<?>)getTemplateBinding()).basicRemove(otherEnd, msgs);
			case PivotPackage.LIBRARY__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case PivotPackage.LIBRARY__NESTED_PACKAGE:
				return ((InternalEList<?>)getNestedPackage()).basicRemove(otherEnd, msgs);
			case PivotPackage.LIBRARY__NESTING_PACKAGE:
				return basicSetNestingPackage(null, msgs);
			case PivotPackage.LIBRARY__OWNED_TYPE:
				return ((InternalEList<?>)getOwnedType()).basicRemove(otherEnd, msgs);
			case PivotPackage.LIBRARY__OWNED_PRECEDENCE:
				return ((InternalEList<?>)getOwnedPrecedence()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case PivotPackage.LIBRARY__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.LIBRARY__EXTENSION:
				return getExtension();
			case PivotPackage.LIBRARY__NAME:
				return getName();
			case PivotPackage.LIBRARY__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.LIBRARY__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter();
			case PivotPackage.LIBRARY__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.LIBRARY__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.LIBRARY__TEMPLATE_BINDING:
				return getTemplateBinding();
			case PivotPackage.LIBRARY__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case PivotPackage.LIBRARY__UNSPECIALIZED_ELEMENT:
				return getUnspecializedElement();
			case PivotPackage.LIBRARY__NESTED_PACKAGE:
				return getNestedPackage();
			case PivotPackage.LIBRARY__NESTING_PACKAGE:
				return getNestingPackage();
			case PivotPackage.LIBRARY__NS_PREFIX:
				return getNsPrefix();
			case PivotPackage.LIBRARY__NS_URI:
				return getNsURI();
			case PivotPackage.LIBRARY__IMPORTED_PACKAGE:
				return getImportedPackage();
			case PivotPackage.LIBRARY__OWNED_TYPE:
				return getOwnedType();
			case PivotPackage.LIBRARY__OWNED_PRECEDENCE:
				return getOwnedPrecedence();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PivotPackage.LIBRARY__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.LIBRARY__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.LIBRARY__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.LIBRARY__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.LIBRARY__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.LIBRARY__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.LIBRARY__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.LIBRARY__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				getTemplateBinding().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.LIBRARY__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.LIBRARY__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case PivotPackage.LIBRARY__NESTED_PACKAGE:
				getNestedPackage().clear();
				getNestedPackage().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case PivotPackage.LIBRARY__NESTING_PACKAGE:
				setNestingPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.LIBRARY__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case PivotPackage.LIBRARY__NS_URI:
				setNsURI((String)newValue);
				return;
			case PivotPackage.LIBRARY__IMPORTED_PACKAGE:
				getImportedPackage().clear();
				getImportedPackage().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case PivotPackage.LIBRARY__OWNED_TYPE:
				getOwnedType().clear();
				getOwnedType().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.LIBRARY__OWNED_PRECEDENCE:
				getOwnedPrecedence().clear();
				getOwnedPrecedence().addAll((Collection<? extends Precedence>)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.LIBRARY__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.LIBRARY__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.LIBRARY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.LIBRARY__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.LIBRARY__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.LIBRARY__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.LIBRARY__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.LIBRARY__TEMPLATE_BINDING:
				getTemplateBinding().clear();
				return;
			case PivotPackage.LIBRARY__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.LIBRARY__UNSPECIALIZED_ELEMENT:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case PivotPackage.LIBRARY__NESTED_PACKAGE:
				getNestedPackage().clear();
				return;
			case PivotPackage.LIBRARY__NESTING_PACKAGE:
				setNestingPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.LIBRARY__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case PivotPackage.LIBRARY__NS_URI:
				setNsURI(NS_URI_EDEFAULT);
				return;
			case PivotPackage.LIBRARY__IMPORTED_PACKAGE:
				getImportedPackage().clear();
				return;
			case PivotPackage.LIBRARY__OWNED_TYPE:
				getOwnedType().clear();
				return;
			case PivotPackage.LIBRARY__OWNED_PRECEDENCE:
				getOwnedPrecedence().clear();
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.LIBRARY__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.LIBRARY__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.LIBRARY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.LIBRARY__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.LIBRARY__OWNING_TEMPLATE_PARAMETER:
				return getOwningTemplateParameter() != null;
			case PivotPackage.LIBRARY__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.LIBRARY__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.LIBRARY__TEMPLATE_BINDING:
				return templateBinding != null && !templateBinding.isEmpty();
			case PivotPackage.LIBRARY__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.LIBRARY__UNSPECIALIZED_ELEMENT:
				return unspecializedElement != null;
			case PivotPackage.LIBRARY__NESTED_PACKAGE:
				return nestedPackage != null && !nestedPackage.isEmpty();
			case PivotPackage.LIBRARY__NESTING_PACKAGE:
				return getNestingPackage() != null;
			case PivotPackage.LIBRARY__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case PivotPackage.LIBRARY__NS_URI:
				return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
			case PivotPackage.LIBRARY__IMPORTED_PACKAGE:
				return importedPackage != null && !importedPackage.isEmpty();
			case PivotPackage.LIBRARY__OWNED_TYPE:
				return ownedType != null && !ownedType.isEmpty();
			case PivotPackage.LIBRARY__OWNED_PRECEDENCE:
				return ownedPrecedence != null && !ownedPrecedence.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitLibrary(this);
	}
} //LibraryImpl
