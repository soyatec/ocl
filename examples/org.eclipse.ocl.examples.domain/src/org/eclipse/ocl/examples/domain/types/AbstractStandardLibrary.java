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
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainLambdaType;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

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
	private ValueFactory valueFactory = null;			// Lazily created
		
/*	protected AbstractStandardLibrary() {
		System.out.println(Thread.currentThread().getName() + " Create " + debugSimpleName(this));		
		liveAbstractStandardLibraries.put(this, null);
	} */

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
		ValueFactory valueFactory = getValueFactory();
		IntegerValue firstLower = firstCollectionType.getLowerValue(valueFactory);
		IntegerValue secondLower = secondCollectionType.getLowerValue(valueFactory);
		if (firstLower.compareTo(secondLower) > 0) {
			return false;
		}
		IntegerValue firstUpper = firstCollectionType.getUpperValue(valueFactory);
		IntegerValue secondUpper = secondCollectionType.getUpperValue(valueFactory);
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
	
	protected abstract @NonNull ValueFactory createValueFactory();

	public void dispose() {
		tupleParts = null;	
		if (valueFactory != null) {
			valueFactory.dispose();
			valueFactory = null;
		}
	}

	public @NonNull DomainCollectionType getBagType(@NonNull DomainType elementType) {
		return getBagType(elementType, null, null);
	}
	
	public @NonNull DomainCollectionType getCollectionType(@NonNull DomainCollectionType containerType, @NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
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

	public DomainEnumeration getEnumeration(@NonNull Enumerator enumerator) {
		throw new UnsupportedOperationException();
	}

	public DomainType getMetaType(@NonNull DomainType instanceType) {
		throw new UnsupportedOperationException();
	}

	public @NonNull DomainCollectionType getOrderedSetType(@NonNull DomainType elementType) {
		return getOrderedSetType(elementType, null, null);
	}

	public @NonNull DomainCollectionType getSequenceType(@NonNull DomainType elementType) {
		return getSequenceType(elementType, null, null);
	}

	public @NonNull DomainCollectionType getSetType(@NonNull DomainType elementType) {
		return getSetType(elementType, null, null);
	}

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
		return getTupleType(partsList);
	}

	public @NonNull DomainType getType(@NonNull DomainElement element) {
		if (element instanceof EObject) {
			return getType(DomainUtil.nonNullEMF(((EObject)element).eClass()));
		}
		throw new UnsupportedOperationException();
	}

	public @NonNull ValueFactory getValueFactory() {
		ValueFactory valueFactory2 = valueFactory;
		if (valueFactory2 == null) {
			valueFactory2 = valueFactory = createValueFactory();
		}
		return valueFactory2;
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
		List<? extends DomainTypedElement> firstParts = firstTupleType.getOwnedAttribute();
		List<? extends DomainTypedElement> secondParts = secondTupleType.getOwnedAttribute();
		int iMax = firstParts.size();
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
		return true;
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
