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
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: Bag.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.types;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainLambdaType;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.CollectedTypeId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Bag;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.OrderedSet;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.BagImpl;
import org.eclipse.ocl.examples.domain.values.impl.OrderedSetImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

public abstract class AbstractStandardLibrary implements DomainStandardLibrary
{
	/**
	 * Mapping from name to list of correspondingly named types for definition of tuple parts. This cache is used to provide the
	 * required part definitions to construct a tuple type in the lightweight execution environment. This cache may remain
	 * unused when using the full pivot environment.
	 */
	private Map<String, Map<DomainType, WeakReference<DomainTypedElement>>> tupleParts = null;		// Lazily created

	/**
	 * The value creation capabilities.
	 */
//	private ValueFactory valueFactory = null;			// Lazily created
	
	private @NonNull IdResolver idResolver = new IdResolver(this);
		
/*	protected AbstractStandardLibrary() {
		System.out.println(Thread.currentThread().getName() + " Create " + debugSimpleName(this));		
		liveAbstractStandardLibraries.put(this, null);
	} */
	
	/**
	 * Return the Ecore representation of this value.
	 * @throws Exception 
	 * @generated NOT
	 */
	public @Nullable Object asEcoreObject(@NonNull Object aValue) {
		if (aValue instanceof Value) {
			if (aValue instanceof InvalidValue) {
				((InvalidValue)aValue).asInteger();			// Propagate any internal exception or throw default
				return null;								// Dead code - always throws above
			}
			else if (aValue instanceof NullValue) {
				return null;
			}
			else if (aValue instanceof CollectionValue) {
				CollectionValue collectionValue = (CollectionValue)aValue;
				List<Object> ecoreResult = new BasicEList<Object>(collectionValue.intSize());
				for (Object elementValue : collectionValue.iterable()) {
					assert elementValue != null;
					ecoreResult.add(asEcoreObject(elementValue));
				}
				return ecoreResult;
			}
			else if (aValue instanceof EnumerationLiteralValue) {
				EnumerationLiteralValue enumerationLiteralValue = (EnumerationLiteralValue)aValue;
//				DomainEnumerationLiteral element = enumerationLiteralValue.getElement();
				return enumerationLiteralValue.asEcoreObject();
//				EnumerationLiteralValue enumerationLiteralValue = (EnumerationLiteralValue)aValue;
//				enumerationLiteralValue.getElement()
//				EnumerationLiteralId enumerationLiteralId = enumerationLiteralValue.getEnumerationLiteralId();
//				TypeId typeId = enumerationLiteralId.getParentId();
//				DomainEnumeration enumeration = (DomainEnumeration) typeId.accept(idVisitor);
//				if (enumeration == null) {
//					throw new UnsupportedOperationException();
//				}
				
//				getE
//					return object.asEcoreObject(valueFactory.getStandardLibrary());
//					return object;
//				}
			}
			else {
				return ((Value)aValue).asObject();
			}
		}
		else if (aValue instanceof Number) {
			return aValue;
		}
		else {
			return aValue;
		}
	}

	public boolean conformsToCollectionType(@NonNull DomainCollectionType firstCollectionType, @NonNull DomainCollectionType secondCollectionType) {
		DomainType firstContainerType = firstCollectionType.getContainerType();
		DomainType secondContainerType = secondCollectionType.getContainerType();
		if (firstContainerType != secondContainerType) {
			if ((firstContainerType == null) || (secondContainerType == null)) {
				return false;
			}
			DomainInheritance firstInheritance = firstContainerType.getInheritance(this);
			DomainInheritance secondInheritance = secondContainerType.getInheritance(this);
			if (!secondInheritance.isSuperInheritanceOf(this, firstInheritance)) {
				return false;
			}
		}
		DomainType firstElementType = firstCollectionType.getElementType();
		DomainType secondElementType = secondCollectionType.getElementType();
		if (firstElementType != secondElementType) {
			if ((firstElementType == null) || (secondElementType == null)) {
				return false;
			}
			if (!firstElementType.conformsTo(this, secondElementType)) {
				return false;
			}
		}
		IntegerValue firstLower = firstCollectionType.getLowerValue();
		IntegerValue secondLower = secondCollectionType.getLowerValue();
		if (firstLower.compareTo(secondLower) > 0) {
			return false;
		}
		IntegerValue firstUpper = firstCollectionType.getUpperValue();
		IntegerValue secondUpper = secondCollectionType.getUpperValue();
		if (firstUpper.compareTo(secondUpper) < 0) {
			return false;
		}
		return true;
	}

	public boolean conformsToLambdaType(@NonNull DomainLambdaType firstLambdaType, @NonNull DomainLambdaType secondLambdaType) {
		throw new UnsupportedOperationException();
	}

	public boolean conformsToTupleType(@NonNull DomainTupleType firstTupleType, @NonNull DomainTupleType secondTupleType) {
		if (isEqualToTupleType(firstTupleType, secondTupleType)) {
			return true;
		}
		DomainInheritance firstInheritance = firstTupleType.getInheritance(this);
		DomainInheritance secondInheritance = secondTupleType.getInheritance(this);
		return firstInheritance.isSuperInheritanceOf(this, secondInheritance);
	}
	
	public @NonNull BagValue createBagValueOf(@NonNull CollectedTypeId typeId, @NonNull Object... objects) {
		Bag<Object> values = new BagImpl<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createBagValue(typeId, values);
	}

	public @NonNull BagValue createBagValueOf(@NonNull CollectedTypeId typeId, @NonNull Iterable<? extends Object> objects) {
		Bag<Object> values = new BagImpl<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createBagValue(typeId, values);
	}

	public @NonNull OrderedSetValue createOrderedSetValueOf(@NonNull CollectedTypeId typeId, @NonNull Object... objects) {
		OrderedSet<Object> values = new OrderedSetImpl<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createOrderedSetValue(typeId, values);
	}

	public @NonNull OrderedSetValue createOrderedSetValueOf(@NonNull CollectedTypeId typeId, @NonNull Iterable<? extends Object> objects) {
		OrderedSet<Object> values = new OrderedSetImpl<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createOrderedSetValue(typeId, values);
	}

	public @NonNull SequenceValue createSequenceValueOf(@NonNull CollectedTypeId typeId, @NonNull Object... objects) {
		List<Object> values = new ArrayList<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createSequenceValue(typeId, values);
	}

	public @NonNull SequenceValue createSequenceValueOf(@NonNull CollectedTypeId typeId, @NonNull Iterable<? extends Object> objects) {
		List<Object> values = new ArrayList<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createSequenceValue(typeId, values);
	}

	public @NonNull SetValue createSetValueOf(@NonNull CollectedTypeId typeId, @NonNull Object... objects) {
		Set<Object> values = new HashSet<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createSetValue(typeId, values);
	}

	public @NonNull SetValue createSetValueOf(@NonNull CollectedTypeId typeId, @NonNull Iterable<? extends Object> objects) {
		Set<Object> values = new HashSet<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createSetValue(typeId, values);
	}

	public void dispose() {
		tupleParts = null;	
	}

	public @NonNull DomainCollectionType getBagType(@NonNull DomainType elementType) {
		return getBagType(elementType, null, null);
	}

	public @NonNull DomainCollectionType getCollectionType(@NonNull DomainType elementType) {
		return getCollectionType(getCollectionType(), elementType, null, null);
	}
	
	public @NonNull DomainCollectionType getCollectionType(@NonNull DomainType containerType, @NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		boolean isOrdered = containerType.isOrdered();
		boolean isUnique = containerType.isUnique();
		if (isOrdered) {
			if (isUnique) {
				return getOrderedSetType(elementType, lower, upper);
			}
			else {
				return getSequenceType(elementType, lower, upper);
			}
		}
		else {
			if (isUnique) {
				return getSetType(elementType, lower, upper);
			}
			else {
				return getBagType(elementType, lower, upper);
			}
		}
	}

	public @NonNull DomainType getCollectionType(@NonNull CollectionTypeId typeId) {
		if (typeId == TypeId.BAG) {
			return getBagType();
		}
		else if (typeId == TypeId.COLLECTION) {
			return getCollectionType();
		}
		else if (typeId == TypeId.ORDERED_SET) {
			return getOrderedSetType();
		}
		else if (typeId == TypeId.SEQUENCE) {
			return getSequenceType();
		}
		else if (typeId == TypeId.SET) {
			return getSetType();
		}
		else if (typeId == TypeId.METACLASS) {
			return getMetaclassType();
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	public @NonNull DomainType getCollectionType(@NonNull CollectedTypeId typeId) {
		@NonNull CollectionTypeId collectionId = typeId.getCollectionTypeId();
		DomainType elementType = (DomainType) typeId.getElementTypeId().accept(idResolver);
		assert elementType != null;
		if (collectionId == TypeId.BAG) {
			return getBagType(elementType, null, null);
		}
		else if (collectionId == TypeId.COLLECTION) {
			return getCollectionType(elementType);
		}
		else if (collectionId == TypeId.ORDERED_SET) {
			return getOrderedSetType(elementType);
		}
		else if (collectionId == TypeId.SEQUENCE) {
			return getSequenceType(elementType);
		}
		else if (collectionId == TypeId.SET) {
			return getSetType(elementType);
		}
		else if (collectionId == TypeId.METACLASS) {
			return getMetaclass(elementType);
		}
		else {
			throw new UnsupportedOperationException();
		}
	}
	
/*	public final @NonNull DomainType getDynamicTypeOf(@NonNull IdResolver idResolver, @NonNull Object value) {
		if (value instanceof NullValue) {
			return getType(((Value)value).getTypeId());
		}
		else if (value instanceof CollectionValue) {
			CollectionValue collectionValue = (CollectionValue) value;
			DomainType elementType = getDynamicTypeOf(idResolver, collectionValue.iterable());
			CollectedTypeId collectedId = collectionValue.getCollectedTypeId();
			CollectionTypeId collectionId = collectedId.getCollectionTypeId();
			TypeId elementTypeId = elementType.getTypeId();
			collectedId = collectionId.getCollectedTypeId(elementTypeId);
			return getCollectionType(collectedId);
		}
		else {
			return idResolver.getStaticTypeOf(value);
		}
	}
	
	public final @NonNull DomainType getDynamicTypeOf(@NonNull IdResolver idResolver, @NonNull Object... values) {
		DomainType elementType = null;
		for (Object value : values) {
			assert value != null;
			DomainType valueType = getDynamicTypeOf(idResolver, value);
			if (elementType == null) {
				elementType = valueType;
			}
			else {
				elementType = elementType.getCommonType(this, valueType);
			}
		}
		if (elementType == null) {
			elementType = getOclInvalidType();
		}
		return elementType;
	}
	
	public final @NonNull DomainType getDynamicTypeOf(@NonNull IdResolver idResolver, @NonNull Iterable<?> values) {
		DomainType elementType = null;
		for (Object value : values) {
			assert value != null;
			DomainType valueType = getDynamicTypeOf(idResolver, value);
			if (elementType == null) {
				elementType = valueType;
			}
			else {
				elementType = elementType.getCommonType(this, valueType);
			}
		}
		if (elementType == null) {
			elementType = getOclInvalidType();
		}
		return elementType;
	} */

	public DomainEnumeration getEnumeration(@NonNull Enumerator enumerator) {
		throw new UnsupportedOperationException();
	}

	public @NonNull IdResolver getIdResolver() {
		return idResolver;
	}

	public DomainType getMetaType(@NonNull DomainType instanceType) {
		throw new UnsupportedOperationException();
	}

	public @Nullable DomainPackage getNestedPackage(@NonNull DomainPackage parentPackage, @NonNull String name) {
		return DomainUtil.getNamedElement(parentPackage.getNestedPackage(), name);
	}

	public @Nullable DomainType getNestedType(@NonNull DomainPackage parentPackage, @NonNull String name) {
		return DomainUtil.getNamedElement(parentPackage.getOwnedType(), name);
	}

	public @Nullable DomainPackage getNsURIPackage(@NonNull String nsURI) {
		throw new UnsupportedOperationException();
	}

	public @Nullable DomainElement getOperationTemplateParameter(@NonNull DomainOperation anOperation, int index) {
		return anOperation.getTypeParameters().get(index);
	}

	public @NonNull DomainCollectionType getOrderedSetType(@NonNull DomainType elementType) {
		return getOrderedSetType(elementType, null, null);
	}

	public @Nullable DomainType getPrimitiveType(@NonNull PrimitiveTypeId typeId) {
		if (typeId == TypeId.BOOLEAN) {
			return getBooleanType();
		}
		else if (typeId == TypeId.INTEGER) {
			return getIntegerType();
		}
		else if (typeId == TypeId.REAL) {
			return getRealType();
		}
		else if (typeId == TypeId.STRING) {
			return getStringType();
		}
		else if (typeId == TypeId.UNLIMITED_NATURAL) {
			return getUnlimitedNaturalType();
		}
		else if (typeId == TypeId.OCL_ANY) {
			return getOclAnyType();
		}
		else if (typeId == TypeId.OCL_COMPARABLE) {
			return getOclComparableType();
		}
		else if (typeId == TypeId.OCL_SUMMABLE) {
			return getOclSummableType();
		}
		throw new UnsupportedOperationException();
	}

	public DomainPackage getRootPackage(@NonNull String name) {
		throw new UnsupportedOperationException();
	}

	public @NonNull DomainCollectionType getSequenceType(@NonNull DomainType elementType) {
		return getSequenceType(elementType, null, null);
	}

	public @NonNull DomainCollectionType getSetType(@NonNull DomainType elementType) {
		return getSetType(elementType, null, null);
	}

//	public @NonNull DomainType getStaticTypeOf(@NonNull Object value) {
//		return getStaticTypeOfWith(idVisitor, value);
//	}

//	public @NonNull DomainType getStaticTypeOf(@NonNull Object value, Object... values) {
//		return getStaticTypeOfWith(idVisitor, value, values);
//	}

/*	public final @NonNull DomainType getStaticTypeOf(@NonNull IdResolver idResolver, @NonNull Object value) {
		if (value instanceof Value) {
			DomainElement type = (DomainElement) ((Value)value).getTypeId().accept(idResolver);
			assert type != null;
			return (DomainType) type;
		}
		else if (value instanceof Boolean) {
			return getBooleanType();
		}
		else if (value instanceof String) {
			return getStringType();
		}
		else if (value instanceof DomainType) {
			return getMetaclass((DomainType) value);
		}
		else if (value instanceof EObject) {
			EClass eClass = ((EObject)value).eClass();
			assert eClass != null;
			return getType(eClass);
		}
		else {
			return new DomainInvalidTypeImpl(this, DomainUtil.bind("Unsupported Object", value));
		}
//		else if (value instanceof DomainElement){
//			return standardLibrary.getType((DomainElement)value);
//		}
	}

	public @NonNull DomainType getStaticTypeOf(@NonNull IdResolver idResolver, @NonNull Object value, @NonNull Object... values) {
		DomainType type = getStaticTypeOf(idResolver, value);
		for (Object anotherValue : values) {
			assert anotherValue != null;
			DomainType anotherType = getStaticTypeOf(idResolver, anotherValue);
			type = type.getCommonType(this, anotherType);
		}		
		return type;
	}

	public @NonNull DomainType getStaticTypeOf(@NonNull IdResolver idResolver, @NonNull Object value, @NonNull Iterable<?> values) {
		DomainType type = getStaticTypeOf(idResolver, value);
		for (Object anotherValue : values) {
			assert anotherValue != null;
			DomainType anotherType = getStaticTypeOf(idResolver, anotherValue);
			type = type.getCommonType(this, anotherType);
		}		
		return type;
	} */

	public synchronized @NonNull DomainTypedElement getTuplePart(@NonNull String name, @NonNull DomainType type) {
		if (tupleParts == null) {
			tupleParts = new WeakHashMap<String, Map<DomainType, WeakReference<DomainTypedElement>>>();
		}
		Map<DomainType, WeakReference<DomainTypedElement>> typeMap = tupleParts.get(name);
		if (typeMap == null) {
			typeMap = new WeakHashMap<DomainType, WeakReference<DomainTypedElement>>();
			tupleParts.put(name, typeMap);
		}
		DomainTypedElement tupleProperty = weakGet(typeMap, type);
		if (tupleProperty == null) {
			tupleProperty = new AbstractTuplePart(type, name);
			typeMap.put(type, new WeakReference<DomainTypedElement>(tupleProperty));
		}
		return tupleProperty;
	}
	
	public @NonNull DomainTupleType getTupleType(DomainTypedElement ... parts) {
		List<DomainTypedElement> partsList = new ArrayList<DomainTypedElement>(parts.length);
		for (DomainTypedElement part : parts) {
			partsList.add(part);
		}
		return getTupleType(IdManager.INSTANCE.getTupleTypeId("Tuple", partsList));
	}

	public @NonNull DomainType getType(@NonNull DomainElement element) {
		if (element instanceof EObject) {
			return getType(DomainUtil.nonNullEMF(((EObject)element).eClass()));
		}
		throw new UnsupportedOperationException();
	}

	public @NonNull DomainType getType(@NonNull TypeId typeId) {
		DomainElement type = typeId.accept(idResolver);
		assert type != null;
		return (DomainType)type;
	}

	public @Nullable DomainType getTypeTemplateParameter(@NonNull DomainType aType, int index) {
		DomainElement domainElement = aType.getTypeParameters().get(index);
		return (DomainType) domainElement;
	}
	
	public boolean isEqualToCollectionType(@NonNull DomainCollectionType firstCollectionType, @NonNull DomainCollectionType secondCollectionType) {
		DomainType firstContainerType = firstCollectionType.getContainerType();
		DomainType secondContainerType = secondCollectionType.getContainerType();
		if (firstContainerType != secondContainerType) {
			if ((firstContainerType == null) || (secondContainerType == null)) {
				return false;
			}
			if (!firstContainerType.isEqualToUnspecializedType(this, secondContainerType)) {
				return false;
			}
		}
		DomainType firstElementType = firstCollectionType.getElementType();
		DomainType secondElementType = secondCollectionType.getElementType();
		if (firstElementType != secondElementType) {
			if ((firstElementType == null) || (secondElementType == null)) {
				return false;
			}
			if (!firstElementType.isEqualTo(this, secondElementType)) {
				return false;
			}
		}
		return true;
	}

	public boolean isEqualToTupleType(@NonNull DomainTupleType firstTupleType, @NonNull DomainTupleType secondTupleType) {
		TypeId firstParts = firstTupleType.getTypeId();
		TypeId secondParts = secondTupleType.getTypeId();
		return firstParts == secondParts;
/*		int iMax = firstParts.size();
		if (iMax != secondParts.size()) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {		// NB. Names are in alphabetical order
			DomainTypedElement firstPart = firstParts.get(i);
			DomainTypedElement secondPart = secondParts.get(i);
			String firstName = firstPart.getName();
			String secondName = secondPart.getName();
			if (firstName != secondName)  {
				if ((firstName == null) || (secondName == null)) {
					return false;
				}
				if (!firstName.equals(secondName)) {
					return false;
				}
			}
			DomainType firstType = firstPart.getType();
			DomainType secondType = secondPart.getType();
			if (firstType != secondType) {
				if ((firstType == null) || (secondType == null)) {
					return false;
				}
				if (!firstType.isEqualTo(this, secondType)) {
					return false;
				}
			}
		}
		return true; */
	}

	public Object valueOf(Object object) {
		if (object.getClass().isArray()) {
			try {
				Object[] objects = (Object[])object;
				TypeId elementTypeId = getIdResolver().getDynamicTypeOf(objects).getTypeId();
				CollectedTypeId collectedTypeId = TypeId.SEQUENCE.getCollectedTypeId(elementTypeId);
				return ValuesUtil.createSequenceValue(collectedTypeId, (Object[])object);
			} 
			catch (IllegalArgumentException e) {}
		}
		else if (object instanceof Iterable<?>) {
			Iterable<?> objects = (Iterable<?>)object;
			TypeId elementTypeId = getIdResolver().getDynamicTypeOf(objects).getTypeId();
			CollectedTypeId collectedTypeId = TypeId.SEQUENCE.getCollectedTypeId(elementTypeId);
			if ((object instanceof LinkedHashSet) || (object instanceof OrderedSet)) {
				return ValuesUtil.createOrderedSetValue(collectedTypeId, objects);
			}
			else if (object instanceof Bag) {
				return ValuesUtil.createBagValue(collectedTypeId, objects);
			}
			else if (object instanceof Set) {
				return ValuesUtil.createSetValue(collectedTypeId, objects);
			}
			else {
				return ValuesUtil.createSequenceValue(collectedTypeId, objects);
			}
		}
		return ValuesUtil.valueOf(object);
	}

	/**
	 * Return the map.get(key).get() entry if there is one or null if not, removing any stale
	 * entry that may be encountered.
	 */
	protected <K, V> V weakGet(@NonNull Map<K, WeakReference<V>> map, @NonNull K key) {
		WeakReference<V> ref = map.get(key);
		if (ref == null) {
			return null;
		}
		V value = ref.get();
		if (value == null) {
			map.remove(key);
		}
		return value;
	}
	
/*	private static WeakHashMap<AbstractStandardLibrary,Object> liveAbstractStandardLibraries = new WeakHashMap<AbstractStandardLibrary,Object>();
	
	public static String debugSimpleName(Object object) {
		if (object == null) {
			return "null";
		}
		else {
			return object.getClass().getSimpleName() + "@" + Integer.toHexString(object.hashCode());
		}
	}

	@Override
	protected void finalize() throws Throwable {
//		System.out.println("Finalize " + debugSimpleName(this));		
		super.finalize();
		Set<AbstractStandardLibrary> keySet = liveAbstractStandardLibraries.keySet();
		if (!keySet.isEmpty()) {
			StringBuilder s = new StringBuilder();
			s.append(" live AbstractStandardLibrary:");
			for (AbstractStandardLibrary stdlib : keySet) {
				s.append(" @" + Integer.toHexString(stdlib.hashCode()));		
			}
//			System.out.println(s);		
		}
	} */
}
