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
 * $Id: CollectionLiteralExpImpl.java,v 1.3 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.PivotValidator;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralExpImpl
		extends LiteralExpImpl
		implements CollectionLiteralExp {

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final CollectionKind KIND_EDEFAULT = CollectionKind.COLLECTION;

	/**
	 * The offset of the flags representing the value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG_OFFSET = 10;

	/**
	 * The flags representing the default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG_DEFAULT = KIND_EDEFAULT.ordinal() << KIND_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link CollectionKind Collection Kind}'
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final CollectionKind[] KIND_EFLAG_VALUES = CollectionKind.values();

	/**
	 * The flags representing the value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG = 0x7 << KIND_EFLAG_OFFSET;

	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionLiteralPart> part;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COLLECTION_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionKind getKind() {
		return KIND_EFLAG_VALUES[(eFlags & KIND_EFLAG) >>> KIND_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(CollectionKind newKind) {
		CollectionKind oldKind = KIND_EFLAG_VALUES[(eFlags & KIND_EFLAG) >>> KIND_EFLAG_OFFSET];
		if (newKind == null) newKind = KIND_EDEFAULT;
		eFlags = eFlags & ~KIND_EFLAG | newKind.ordinal() << KIND_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_LITERAL_EXP__KIND, oldKind, newKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CollectionLiteralPart> getPart()
	{
		if (part == null)
		{
			part = new EObjectContainmentEList<CollectionLiteralPart>(CollectionLiteralPart.class, this, PivotPackage.COLLECTION_LITERAL_EXP__PART);
		}
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionLiteralPart createPart(EClass eClass) {
		CollectionLiteralPart newPart = (CollectionLiteralPart) create(eClass);
		getPart().add(newPart);
		return newPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionKindIsConcrete(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv CollectionKindIsConcrete: kind <> CollectionKind::Collection
		 * 
		 * 
		 */
		final @NonNull /*@NonInvalid*/ CollectionLiteralExp self = this;
		@NonNull /*@Caught*/ Object CAUGHT_ne;
		try {
		    final @NonNull /*@Thrown*/ Enumerator kind = self.getKind();
		    final @NonNull /*@Thrown*/ EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(kind.getName());
		    final @NonNull /*@Thrown*/ Boolean ne = OclAnyNotEqualOperation.INSTANCE.evaluate(BOXED_kind, PivotTables.ELITid_Collection);
		    CAUGHT_ne = ne;
		}
		catch (Exception e) {
		    CAUGHT_ne = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_ne == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"CollectionLiteralExp", "CollectionKindIsConcrete", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.COLLECTION_LITERAL_EXP__COLLECTION_KIND_IS_CONCRETE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetKindIsSet(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv SetKindIsSet: kind = CollectionKind::Set implies type.oclIsKindOf (SetType)
		 * 
		 */
		final @NonNull /*@NonInvalid*/ CollectionLiteralExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SetType = idResolver.getType(PivotTables.CLSSid_SetType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @NonNull /*@Thrown*/ Enumerator kind = self.getKind();
		        final @NonNull /*@Thrown*/ EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(kind.getName());
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(BOXED_kind, PivotTables.ELITid_Set);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @NonNull /*@Thrown*/ Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_SetType);
		        CAUGHT_oclIsKindOf = oclIsKindOf;
		    }
		    catch (Exception e) {
		        CAUGHT_oclIsKindOf = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_oclIsKindOf);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"CollectionLiteralExp", "SetKindIsSet", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.COLLECTION_LITERAL_EXP__SET_KIND_IS_SET, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderedSetKindIsOrderedSet(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv OrderedSetKindIsOrderedSet: kind = CollectionKind::OrderedSet implies type.oclIsKindOf (OrderedSetType)
		 * 
		 */
		final @NonNull /*@NonInvalid*/ CollectionLiteralExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_OrderedSetType = idResolver.getType(PivotTables.CLSSid_OrderedSetType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @NonNull /*@Thrown*/ Enumerator kind = self.getKind();
		        final @NonNull /*@Thrown*/ EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(kind.getName());
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(BOXED_kind, PivotTables.ELITid_OrderedSet);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @NonNull /*@Thrown*/ Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_OrderedSetType);
		        CAUGHT_oclIsKindOf = oclIsKindOf;
		    }
		    catch (Exception e) {
		        CAUGHT_oclIsKindOf = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_oclIsKindOf);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"CollectionLiteralExp", "OrderedSetKindIsOrderedSet", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.COLLECTION_LITERAL_EXP__ORDERED_SET_KIND_IS_ORDERED_SET, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceKindIsSequence(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * 
		 * inv SequenceKindIsSequence: kind = CollectionKind::Sequence implies type.oclIsKindOf (SequenceType)
		 * 
		 */
		final @NonNull /*@NonInvalid*/ CollectionLiteralExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_SequenceType = idResolver.getType(PivotTables.CLSSid_SequenceType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @NonNull /*@Thrown*/ Enumerator kind = self.getKind();
		        final @NonNull /*@Thrown*/ EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(kind.getName());
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(BOXED_kind, PivotTables.ELITid_Sequence);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @NonNull /*@Thrown*/ Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_SequenceType);
		        CAUGHT_oclIsKindOf = oclIsKindOf;
		    }
		    catch (Exception e) {
		        CAUGHT_oclIsKindOf = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_oclIsKindOf);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"CollectionLiteralExp", "SequenceKindIsSequence", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.COLLECTION_LITERAL_EXP__SEQUENCE_KIND_IS_SEQUENCE, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBagKindIsBag(final DiagnosticChain diagnostics, final Map<Object, Object> context)
	{
		/**
		 * inv BagKindIsBag: kind = CollectionKind::Bag implies type.oclIsKindOf (BagType)
		 * 
		 */
		final @NonNull /*@NonInvalid*/ CollectionLiteralExp self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_pivot_c_c_BagType = idResolver.getType(PivotTables.CLSSid_BagType, null);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final @NonNull /*@Thrown*/ Enumerator kind = self.getKind();
		        final @NonNull /*@Thrown*/ EnumerationLiteralId BOXED_kind = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId(kind.getName());
		        final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(BOXED_kind, PivotTables.ELITid_Bag);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_oclIsKindOf;
		    try {
		        final @Nullable /*@Thrown*/ DomainType type = self.getType();
		        final @NonNull /*@Thrown*/ Boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, type, TYP_pivot_c_c_BagType);
		        CAUGHT_oclIsKindOf = oclIsKindOf;
		    }
		    catch (Exception e) {
		        CAUGHT_oclIsKindOf = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_oclIsKindOf);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"CollectionLiteralExp", "BagKindIsBag", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, PivotValidator.DIAGNOSTIC_SOURCE, PivotValidator.COLLECTION_LITERAL_EXP__BAG_KIND_IS_BAG, message, new Object [] { this }));
		}
		return false;
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
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotation()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				return ((InternalEList<?>)getPart()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.COLLECTION_LITERAL_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				return getName();
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				return getKind();
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				return getPart();
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
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				setKind((CollectionKind)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				getPart().clear();
				getPart().addAll((Collection<? extends CollectionLiteralPart>)newValue);
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
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				getPart().clear();
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
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				return type != null;
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				return (eFlags & KIND_EFLAG) != KIND_EFLAG_DEFAULT;
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				return part != null && !part.isEmpty();
		}
		return eDynamicIsSet(featureID);
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
			case PivotPackage.COLLECTION_LITERAL_EXP___ALL_OWNED_ELEMENTS:
				return allOwnedElements();
			case PivotPackage.COLLECTION_LITERAL_EXP___GET_VALUE__TYPE_STRING:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_SET_KIND_IS_SET__DIAGNOSTICCHAIN_MAP:
				return validateSetKindIsSet((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_ORDERED_SET_KIND_IS_ORDERED_SET__DIAGNOSTICCHAIN_MAP:
				return validateOrderedSetKindIsOrderedSet((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_SEQUENCE_KIND_IS_SEQUENCE__DIAGNOSTICCHAIN_MAP:
				return validateSequenceKindIsSequence((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_BAG_KIND_IS_BAG__DIAGNOSTICCHAIN_MAP:
				return validateBagKindIsBag((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.COLLECTION_LITERAL_EXP___VALIDATE_COLLECTION_KIND_IS_CONCRETE__DIAGNOSTICCHAIN_MAP:
				return validateCollectionKindIsConcrete((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCollectionLiteralExp(this);
	}
} //CollectionLiteralExpImpl
