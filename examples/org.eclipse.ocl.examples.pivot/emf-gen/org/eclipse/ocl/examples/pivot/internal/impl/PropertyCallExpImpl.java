/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: PropertyCallExpImpl.java,v 1.4 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.logical.BooleanNotOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.TemplateSpecialisation;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyCallExpImpl#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyCallExpImpl
		extends NavigationCallExpImpl
		implements PropertyCallExp {

	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.PROPERTY_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getReferredProperty() {
		if (referredProperty != null && ((EObject)referredProperty).eIsProxy())
		{
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredProperty() {
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredProperty(Property newReferredProperty) {
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
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
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.PROPERTY_CALL_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				return getName();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_RULE:
				return getOwnedRule();
			case PivotPackage.PROPERTY_CALL_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.PROPERTY_CALL_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.PROPERTY_CALL_EXP__SOURCE:
				return getSource();
			case PivotPackage.PROPERTY_CALL_EXP__IMPLICIT:
				return isImplicit();
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				return isPre();
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIER:
				return getQualifier();
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				if (resolve) return getNavigationSource();
				return basicGetNavigationSource();
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
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
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_RULE:
				getOwnedRule().clear();
				getOwnedRule().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__SOURCE:
				setSource((OCLExpression)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				setIsPre((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIER:
				getQualifier().clear();
				getQualifier().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((Property)newValue);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
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
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_RULE:
				getOwnedRule().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__SOURCE:
				setSource((OCLExpression)null);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				setIsPre(IS_PRE_EDEFAULT);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIER:
				getQualifier().clear();
				return;
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				setNavigationSource((Property)null);
				return;
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
				setReferredProperty((Property)null);
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
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_RULE:
				return ownedRule != null && !ownedRule.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__TYPE:
				return type != null;
			case PivotPackage.PROPERTY_CALL_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__SOURCE:
				return source != null;
			case PivotPackage.PROPERTY_CALL_EXP__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__IS_PRE:
				return ((eFlags & IS_PRE_EFLAG) != 0) != IS_PRE_EDEFAULT;
			case PivotPackage.PROPERTY_CALL_EXP__QUALIFIER:
				return qualifier != null && !qualifier.isEmpty();
			case PivotPackage.PROPERTY_CALL_EXP__NAVIGATION_SOURCE:
				return navigationSource != null;
			case PivotPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
				return referredProperty != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
	{
		if (baseClass == ReferringElement.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.REFERRING_ELEMENT___GET_REFERRED_ELEMENT: return PivotPackage.PROPERTY_CALL_EXP___GET_REFERRED_ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case PivotPackage.PROPERTY_CALL_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.PROPERTY_CALL_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.PROPERTY_CALL_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP:
				return validateNotOwnSelf((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.PROPERTY_CALL_EXP___GET_REFERRED_ELEMENT:
				return getReferredElement();
			case PivotPackage.PROPERTY_CALL_EXP___GET_SPECIALIZED_REFERRED_PROPERTY_OWNING_TYPE:
				return getSpecializedReferredPropertyOwningType();
			case PivotPackage.PROPERTY_CALL_EXP___GET_SPECIALIZED_REFERRED_PROPERTY_TYPE:
				return getSpecializedReferredPropertyType();
			case PivotPackage.PROPERTY_CALL_EXP___VALIDATE_NON_STATIC_SOURCE_TYPE_IS_CONFORMANT__DIAGNOSTICCHAIN_MAP:
				return validateNonStaticSourceTypeIsConformant((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.PROPERTY_CALL_EXP___VALIDATE_COMPATIBLE_RESULT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleResultType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitPropertyCallExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element getReferredElement()
	{
		return getReferredProperty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DomainType getSpecializedReferredPropertyOwningType()
	{
		Property referredProperty = getReferredProperty();
		Type referencedType = referredProperty.getOwningType();
		if (!TemplateSpecialisation.needsSpecialisation(referencedType)) {
			return referencedType;
		}
		TemplateSpecialisation templateSpecialization = new TemplateSpecialisation(PivotTables.LIBRARY);
		DomainType resultType = getType();
		if (resultType instanceof DomainMetaclass) {
			resultType = ((DomainMetaclass)resultType).getInstanceType();
		}
		templateSpecialization.installEquivalence(resultType, referredProperty.getType());
		return templateSpecialization.getSpecialisation(referencedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DomainType getSpecializedReferredPropertyType()
	{
		Property referredProperty = getReferredProperty();
		Type referencedType = referredProperty.getType();
		if (!TemplateSpecialisation.needsSpecialisation(referencedType)) {
			return referencedType;
		}
		TemplateSpecialisation templateSpecialization = new TemplateSpecialisation(PivotTables.LIBRARY);
		DomainType resultType = getType();
		boolean isMetaclass = resultType instanceof DomainMetaclass;
		if (isMetaclass) {
			resultType = ((DomainMetaclass)resultType).getInstanceType();
		}
		templateSpecialization.installEquivalence(resultType, referredProperty.getType());
		DomainType specializedType = templateSpecialization.getSpecialisation(referencedType);
		if (isMetaclass) {
			specializedType = PivotTables.LIBRARY.getMetaclass(specializedType);
		}
		return specializedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNonStaticSourceTypeIsConformant(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv NonStaticSourceTypeIsConformant: not referredProperty.isStatic implies source.type.conformsTo(getSpecializedReferredPropertyOwningType())
		 * 
		 */
		final @NonNull /*@NonInvalid*/ PropertyCallExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		@Nullable /*@Caught*/ Object symbol_0;
		try {
		    @Nullable /*@Caught*/ Object symbol_1;
		    try {
		        final @Nullable /*@Thrown*/ DomainProperty referredProperty = self.getReferredProperty();
		        if (referredProperty == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @Nullable /*@Thrown*/ Boolean isStatic = referredProperty.isStatic();
		        final @Nullable /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(isStatic);
		        symbol_1 = not;
		    }
		    catch (Exception e) {
		        symbol_1 = ValuesUtil.createInvalidValue(e);
		    }
		    @Nullable /*@Caught*/ Object symbol_2;
		    try {
		        final @Nullable /*@Thrown*/ OCLExpression source = self.getSource();
		        if (source == null) {
		            throw new InvalidValueException("Null source");
		        }
		        final @Nullable /*@Thrown*/ Object type = source.getType();
		        final @Nullable /*@Thrown*/ Object getSpecializedReferredPropertyOwningType = self.getSpecializedReferredPropertyOwningType();
		        final @Nullable /*@Thrown*/ Boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(evaluator, type, getSpecializedReferredPropertyOwningType);
		        symbol_2 = conformsTo;
		    }
		    catch (Exception e) {
		        symbol_2 = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(symbol_1, symbol_2);
		    symbol_0 = implies;
		}
		catch (Exception e) {
		    symbol_0 = ValuesUtil.createInvalidValue(e);
		}
		if (symbol_0 == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = symbol_0 == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"PropertyCallExp", "NonStaticSourceTypeIsConformant", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.PROPERTY_CALL_EXP__NON_STATIC_SOURCE_TYPE_IS_CONFORMANT, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompatibleResultType(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv CompatibleResultType: type = getSpecializedReferredPropertyType()
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ PropertyCallExp self = this;
		@Nullable /*@Caught*/ Object symbol_0;
		try {
		    final @Nullable /*@Thrown*/ Object type = self.getType();
		    final @Nullable /*@Thrown*/ Object getSpecializedReferredPropertyType = self.getSpecializedReferredPropertyType();
		    final @Nullable /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(type, getSpecializedReferredPropertyType);
		    symbol_0 = eq;
		}
		catch (Exception e) {
		    symbol_0 = ValuesUtil.createInvalidValue(e);
		}
		if (symbol_0 == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = symbol_0 == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"PropertyCallExp", "CompatibleResultType", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.PROPERTY_CALL_EXP__COMPATIBLE_RESULT_TYPE, message, new Object [] { this }));
		}
		return false;
	}
} //PropertyCallExpImpl
