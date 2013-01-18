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
 * $Id: TupleTypeImpl.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("cast")
public class TupleTypeImpl
		extends DataTypeImpl
		implements TupleType {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TupleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TUPLE_TYPE;
	}
	
	private TupleTypeId tupleTypeId;
	
	public TupleTypeImpl(@NonNull TupleTypeId tupleTypeId, List<? extends Property> tupleParts) {
		this.tupleTypeId = tupleTypeId;;
		setName(tupleTypeId.getName());
		getOwnedAttribute().addAll(tupleParts);
	}

	@Override
	public @NonNull TypeId computeId() {
		TupleTypeId tupleTypeId2 = tupleTypeId;
		if (tupleTypeId2 == null) {
			String name2 = getName();
			List<Property> ownedAttribute2 = getOwnedAttribute();
			assert name2 != null;
			assert ownedAttribute2 != null;
			List<TuplePartId> partIds = new ArrayList<TuplePartId>(ownedAttribute2.size());
			for (DomainTypedElement ownedAttribute : ownedAttribute2) {
				String partName = ownedAttribute.getName();
				assert partName != null;
				TypeId partTypeId = ownedAttribute.getTypeId();
				partIds.add(IdManager.INSTANCE.createTuplePartId(partName, partTypeId));
			}
			tupleTypeId = tupleTypeId2 = IdManager.INSTANCE.getTupleTypeId(name2, partIds);
		}
		return tupleTypeId2;
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitTupleType(this);
	}

	@Override
	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		DomainType tupleType = standardLibrary.getOclTupleType();
		return tupleType.getInheritance(standardLibrary);
	}

	public @NonNull TupleTypeId getTupleTypeId() {
		return (TupleTypeId) getTypeId();
	}

	@Override
	public @NonNull TupleTypeId getTypeId() {
		return (TupleTypeId) super.getTypeId();
	}
} //TupleTypeImpl
