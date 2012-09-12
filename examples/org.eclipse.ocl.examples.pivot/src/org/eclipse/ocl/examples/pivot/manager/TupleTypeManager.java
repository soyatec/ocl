/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id$
 */
package org.eclipse.ocl.examples.pivot.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.internal.impl.TypedElementImpl;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * TupleTypeManager encapsulates the knowledge about known tuple types.
 */
public class TupleTypeManager
{
	/**
	 * TuplePart provides a convenient descriptor for a tuple part complying with the full EMF model protocols.
	 */
	public static class TuplePart extends TypedElementImpl implements Comparable<TuplePart>
	{
		public TuplePart(@NonNull String name, @NonNull Type type) {
			setName(name);
			setType(type);
		}

		public int compareTo(TuplePart o) {			// FIXME Type
			String n1 = getName();
			String n2 = o.getName();
			if (n1 == n2) {
				return 0;
			}
			if (n1 == null) {
				return -1;
			}
			if (n2 == null) {
				return +1;
			}				
			return n1.compareTo(n2);
		}

		@Override
		public String toString() {
			return String.valueOf(name) + " : " + String.valueOf(type);
		}
	}

	protected final @NonNull MetaModelManager metaModelManager;
	
	/**
	 * Map from the sum of the part name hashes to the tuple types with the same hash. 
	 */
	private Map<Integer, List<TupleType>> hash2tuple = null;
	
	protected TupleTypeManager(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}

	public void dispose() {
		hash2tuple = null;
	}

    public @Nullable Type getCommonType(@NonNull TupleType leftType, @NonNull TupleType rightType, @Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		List<Property> leftProperties = leftType.getOwnedAttribute();
		List<Property> rightProperties = rightType.getOwnedAttribute();
		if (leftProperties.size() != rightProperties.size()) {
			return null;
		}
		boolean isLeft = true;
		boolean isRight = true;
		List<TypedElement> commonProperties = new ArrayList<TypedElement>(leftProperties.size());
		for (Property leftProperty : leftProperties) {
			Property rightProperty = PivotUtil.getNamedElement(rightProperties, leftProperty.getName());
			Type leftPropertyType = DomainUtil.nonNullModel(leftProperty.getType());
			Type rightPropertyType = DomainUtil.nonNullModel(rightProperty.getType());
			TypedElement commonProperty = null;
			Type commonType = metaModelManager.getCommonType(leftPropertyType, rightPropertyType, bindings);
			if (commonType != leftPropertyType) {
				isLeft = false;
			}
			else {
				commonProperty = leftProperty;
			}
			if (commonType != rightPropertyType) {
				isRight = false;
			}
			else {
				commonProperty = rightProperty;
			}
			if (commonProperty == null) {
				commonProperty = new TuplePart(DomainUtil.nonNullModel(leftProperty.getName()), commonType);
			}
			commonProperties.add(commonProperty);
		}
		if (isLeft) {
			return leftType;
		}
		else if (isRight) {
			return rightType;
		}
		else {
			return getTupleType(DomainUtil.nonNullModel(leftType.getName()), commonProperties, bindings);
		}
	}

	/**
	 * Return the named tuple type with the defined alphabetically ordered parts.
	 */
    protected @NonNull TupleType getOrderedTupleType(@NonNull String name, @NonNull List<TuplePart> orderedParts) {
		if (hash2tuple == null) {
			hash2tuple = new HashMap<Integer, List<TupleType>>();
		}
		int hash = name.hashCode();
		for (TypedElement part : orderedParts) {
			hash = 101 * hash + part.getName().hashCode();
		}
		List<TupleType> tupleList = hash2tuple.get(hash);
		if (tupleList == null) {
			tupleList = new ArrayList<TupleType>();
			hash2tuple.put(hash, tupleList);
		}
		int iMax = orderedParts.size();
		for (TupleType candidateTupleType : tupleList) {
			List<Property> candidateParts = candidateTupleType.getOwnedAttribute();
			if (candidateParts.size() == iMax) {
				int i = 0;
				for (TuplePart orderedPart : orderedParts) {
					Property candidatePart = candidateParts.get(i);
					if (orderedPart.getType() != candidatePart.getType()) {
						break;
					}
					if (!orderedPart.getName().equals(candidatePart.getName())) {
						break;
					}
					i++;
				}
				if (i >= iMax) {
					return candidateTupleType;
				}
			}
		}
		TupleType tupleType = PivotFactory.eINSTANCE.createTupleType();
		tupleType.setName(name);
		List<Property> tupleParts = tupleType.getOwnedAttribute();
		for (TuplePart part : orderedParts) {
			Property tuplePart = PivotFactory.eINSTANCE.createProperty();
			tuplePart.setName(part.getName());
			tuplePart.setType(part.getType());
			tupleParts.add(tuplePart);
		}
		tupleType.getSuperClass().add(metaModelManager.getOclTupleType());
		tupleList.add(tupleType);
		metaModelManager.addOrphanClass(tupleType);
		return tupleType;
	}
	
	public @NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<? extends DomainTypedElement> parts,
			@Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		List<TuplePart> orderedParts = new ArrayList<TuplePart>(parts.size());
		for (DomainTypedElement part : parts) {
			Type type = metaModelManager.getType(DomainUtil.nonNullModel(part.getType()));
			Type specializedType = metaModelManager.getSpecializedType(type, bindings);
			orderedParts.add(new TuplePart(DomainUtil.nonNullModel(part.getName()), specializedType));
		}
		Collections.sort(orderedParts);
		return getOrderedTupleType(typeName, orderedParts);
	}

	public @NonNull TupleType getTupleType(@NonNull TupleType type, @Nullable Map<TemplateParameter, ParameterableElement> usageBindings) {	// FIXME Remove duplication, unify type/multiplicity
		TupleType specializedTupleType = type;
		Map<String, Type> resolutions =  null;
		for (Property property : specializedTupleType.getOwnedAttribute()) {
			if (property != null) {
				Type propertyType = PivotUtil.getBehavioralType(property);
				Type resolvedPropertyType = metaModelManager.getSpecializedType(propertyType, usageBindings);
				if (resolvedPropertyType != propertyType) {
					if (resolutions == null) {
						resolutions = new HashMap<String, Type>();
					}
					resolutions.put(property.getName(), resolvedPropertyType);
				}
			}
		}
		if (resolutions != null) {
			List<TypedElement> parts = new ArrayList<TypedElement>();
			for (Property property : specializedTupleType.getOwnedAttribute()) {
				TypedElement part = property;
				Type resolvedPropertyType = resolutions.get(property.getName());
				if (resolvedPropertyType != null) {
					part = new TuplePart(DomainUtil.nonNullModel(property.getName()), resolvedPropertyType);
				}
				parts.add(part);
			}
			specializedTupleType = getTupleType(DomainUtil.nonNullModel(type.getName()), parts, usageBindings);
		}
		return specializedTupleType;
	}
}