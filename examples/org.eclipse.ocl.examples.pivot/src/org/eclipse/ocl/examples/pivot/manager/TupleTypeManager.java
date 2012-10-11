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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.internal.impl.TuplePartImpl;
import org.eclipse.ocl.examples.pivot.internal.impl.TupleTypeImpl;
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
	public static class TuplePart extends TypedElementImpl // implements Comparable<TuplePart>
	{
		protected final @NonNull TuplePartId partId;
		
		public TuplePart(@NonNull TuplePartId partId) {
			this.partId = partId;
			setName(partId.getName());
		}

		
//		public TuplePart(@NonNull String name, @NonNull Type type) {
//			setName(name);
//			setType(type);
//			this.partId = IdManager.INSTANCE.getTuplePartId(name, type.getTypeId());
//		}

/*		public int compareTo(TupleTypeId.Part o) {			// FIXME Type
			String n1 = name;
			String n2 = o.getName();
			if (n1 == n2) {
				return 0;
			}
			return n1.compareTo(n2);
		} */


		public @NonNull TypeId getTypeId() {
			return partId.getTypeId();
		}

		@Override
		public String toString() {
			return String.valueOf(name) + " : " + String.valueOf(type);
		}
	}

	protected final @NonNull MetaModelManager metaModelManager;
	
	/**
	 * Map from the tuple typeId to the tuple type. 
	 */
	private @Nullable Map<TupleTypeId, TupleType> tupleid2tuple = null;
	
	protected TupleTypeManager(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}

	public void dispose() {
		tupleid2tuple = null;
	}

	public @NonNull TupleType getTupleType(@NonNull IdResolver idResolver, @NonNull TupleTypeId tupleTypeId) {
		Map<TupleTypeId, TupleType> tupleid2tuple2 = tupleid2tuple;
		if (tupleid2tuple2 == null) {
			synchronized (this) {
				tupleid2tuple2 = tupleid2tuple;
				if (tupleid2tuple2 == null) {
					tupleid2tuple2 = tupleid2tuple = new HashMap<TupleTypeId, TupleType>();
				}
			}
		}
		TupleType tupleType = tupleid2tuple2.get(tupleTypeId);
		if (tupleType == null) {
			synchronized (tupleid2tuple2) {
				tupleType = tupleid2tuple2.get(tupleTypeId);
				if (tupleType == null) {
					TuplePartId[] partIds = tupleTypeId.getPartIds();
					List<TuplePartImpl> ownedAttributes = new ArrayList<TuplePartImpl>(partIds.length);
					for (TuplePartId partId : partIds) {
						DomainType partType = idResolver.getType(partId.getTypeId(), null);
						Type partType2 = metaModelManager.getType(partType);
						ownedAttributes.add(new TuplePartImpl(partId, partType2));
					}		
					tupleType = new TupleTypeImpl(tupleTypeId, ownedAttributes);
					tupleType.getSuperClass().add(metaModelManager.getOclTupleType());
					tupleid2tuple2.put(tupleTypeId, tupleType);
					metaModelManager.addOrphanClass(tupleType);
				}
			}
		}
		return tupleType;
	}

    public @Nullable Type getCommonType(@NonNull TupleType leftType, @NonNull TupleType rightType, @Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		List<Property> leftProperties = leftType.getOwnedAttribute();
		List<Property> rightProperties = rightType.getOwnedAttribute();
		if (leftProperties.size() != rightProperties.size()) {
			return null;
		}
//		boolean isLeft = true;
//		boolean isRight = true;
//		List<TypedElement> commonProperties = new ArrayList<TypedElement>(leftProperties.size());
		List<TuplePartId> commonPartIds = new ArrayList<TuplePartId>(leftProperties.size());
		for (Property leftProperty : leftProperties) {
			Property rightProperty = DomainUtil.getNamedElement(rightProperties, leftProperty.getName());
			Type leftPropertyType = DomainUtil.nonNullModel(leftProperty.getType());
			Type rightPropertyType = DomainUtil.nonNullModel(rightProperty.getType());
//			TypedElement commonProperty = null;
			Type commonType = metaModelManager.getCommonType(leftPropertyType, rightPropertyType, bindings);
			TuplePartId commonPartId = IdManager.INSTANCE.createTuplePartId(leftProperty.getName(), commonType.getTypeId());
			commonPartIds.add(commonPartId);
//			if (commonType != leftPropertyType) {
//				isLeft = false;
//			}
//			else {
//				commonProperty = leftProperty;
//			}
//			if (commonType != rightPropertyType) {
//				isRight = false;
//			}
//			else {
//				commonProperty = rightProperty;
//			}
//			if (commonProperty == null) {
//				TuplePartId commonPartId = IdManager.INSTANCE.getTuplePartId(leftProperty.getName(), commonType.getTypeId());
//				commonProperty = new TuplePart(commonPartId);
//			}
//			commonProperties.add(commonProperty);
		}
//		if (isLeft) {
//			return leftType;
//		}
//		else if (isRight) {
//			return rightType;
//		}
//		else {
//			return getTupleType(DomainUtil.nonNullModel(leftType.getName()), commonProperties, bindings);
//		}
		TupleTypeId commonTupleTypeId = IdManager.INSTANCE.getTupleTypeId("Tuple", commonPartIds);
		return getTupleType(metaModelManager.getIdResolver(), commonTupleTypeId);
	}

	/**
	 * Return the named tuple type with the defined alphabetically ordered parts.
	 */
/*    protected @NonNull TupleType getOrderedTupleType(@NonNull String name, @NonNull List<TuplePart> orderedParts) {
		TupleTypeId tupleTypeId = IdManager.INSTANCE.getTupleTypeId(name, orderedParts);
		Map<TupleTypeId, TupleType> tupleid2tuple2 = tupleid2tuple;
		if (tupleid2tuple2 == null) {
			synchronized (this) {
				tupleid2tuple2 = tupleid2tuple;
				if (tupleid2tuple2 == null) {
					tupleid2tuple = tupleid2tuple2 = new HashMap<TupleTypeId, TupleType>();
				}
			}
		}
		TupleType oldTupleType = tupleid2tuple2.get(tupleTypeId);
		if (oldTupleType != null) {
			return oldTupleType;
		}
		synchronized (tupleid2tuple2) {
			TupleType newTupleType = PivotFactory.eINSTANCE.createTupleType();
			newTupleType.setName(name);
			List<Property> tupleParts = newTupleType.getOwnedAttribute();
			for (TuplePart part : orderedParts) {
				Property tuplePart = PivotFactory.eINSTANCE.createProperty();
				tuplePart.setName(part.getName());
				tuplePart.setType(part.getType());
				tupleParts.add(tuplePart);
			}
			newTupleType.getSuperClass().add(metaModelManager.getOclTupleType());
			tupleid2tuple2.put(tupleTypeId, newTupleType);
			metaModelManager.addOrphanClass(newTupleType);
			return newTupleType;
		}
	} */
	
	public @NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<? extends DomainTypedElement> parts,
			@Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		List<TuplePartId> partIds = new ArrayList<TuplePartId>(parts.size());
		for (DomainTypedElement part : parts) {
			Type type = metaModelManager.getType(DomainUtil.nonNullModel(part.getType()));
			Type specializedType = metaModelManager.getSpecializedType(type, bindings);
			TuplePartId tuplePartId = IdManager.INSTANCE.createTuplePartId(DomainUtil.nonNullModel(part.getName()), specializedType.getTypeId());
			partIds.add(tuplePartId);
		}
		TupleTypeId tupleTypeId = IdManager.INSTANCE.getTupleTypeId(typeName, partIds);
		return getTupleType(metaModelManager.getIdResolver(), tupleTypeId);
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
			List<TuplePartId> partIds = new ArrayList<TuplePartId>(specializedTupleType.getOwnedAttribute().size());
			for (Property property : specializedTupleType.getOwnedAttribute()) {
				TuplePartId tuplePartId;
				Type resolvedPropertyType = resolutions.get(property.getName());
				if (resolvedPropertyType != null) {
					tuplePartId = IdManager.INSTANCE.createTuplePartId(DomainUtil.nonNullModel(property.getName()), resolvedPropertyType.getTypeId());
				}
				else {
					tuplePartId = IdManager.INSTANCE.createTuplePartId(DomainUtil.nonNullModel(property.getName()), property.getTypeId());
				}
				partIds.add(tuplePartId);
			}
			TupleTypeId tupleTypeId = IdManager.INSTANCE.getTupleTypeId(DomainUtil.nonNullModel(type.getName()), partIds);
			specializedTupleType = getTupleType(metaModelManager.getIdResolver(), tupleTypeId);
		}
		return specializedTupleType;
	}
}