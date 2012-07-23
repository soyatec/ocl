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
 * $Id$
 */
package org.eclipse.ocl.examples.library.executor;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClassifierType;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.types.AbstractCollectionType;
import org.eclipse.ocl.examples.domain.types.AbstractStandardLibrary;
import org.eclipse.ocl.examples.domain.types.AbstractTupleType;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;

public abstract class ExecutableStandardLibrary extends AbstractStandardLibrary
{
	/**
	 * Shared cache of the lazily created lazily deleted Classifier types of each type. 
	 */
	private Map<DomainType, WeakReference<DomainClassifierType>> classifiers = new WeakHashMap<DomainType, WeakReference<DomainClassifierType>>();
	
	/**
	 * Shared cache of the lazily created lazily deleted specializations of each type. 
	 */
	private Map<DomainType, Map<DomainType, WeakReference<AbstractCollectionType>>> specializations = new WeakHashMap<DomainType, Map<DomainType, WeakReference<AbstractCollectionType>>>();
	
	/**
	 * Shared cache of the lazily created lazily deleted tuples. 
	 */
	private Map<String, List<WeakReference<DomainTupleType>>> tupleTypeMap = new WeakHashMap<String, List<WeakReference<DomainTupleType>>>();

	protected abstract @NonNull DomainClassifierType createClassifierType(@NonNull DomainType classType);
	
	public abstract @NonNull DomainEvaluator createEvaluator(@NonNull EObject contextObject, @Nullable Map<Object, Object> contextMap);

	public @NonNull DomainType getAnyClassifierType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._AnyClassifier);
	}
	
	public @NonNull DomainType getBagType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._Bag);
	}

	public @NonNull DomainCollectionType getBagType(@NonNull DomainType elementType) {
		return getCollectionType(getBagType(), elementType);
	}

	public @NonNull DomainType getBooleanType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._Boolean);
	}

	public synchronized @NonNull DomainClassifierType getClassifierType(@NonNull DomainType classType) {
		DomainClassifierType classifierType = weakGet(classifiers, classType);
		if (classifierType == null) {
			classifierType = createClassifierType(classType);
			classifiers.put(classType, new WeakReference<DomainClassifierType>(classifierType));
		}
		return classifierType;
	}

	public @NonNull DomainType getCollectionType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._Collection);
	}

	public synchronized @NonNull DomainCollectionType getCollectionType(@NonNull DomainType genericType, @NonNull DomainType elementType) {
		AbstractCollectionType specializedType = null;
		Map<DomainType, WeakReference<AbstractCollectionType>> map = specializations.get(genericType);
		if (map == null) {
			map = new WeakHashMap<DomainType, WeakReference<AbstractCollectionType>>();
			specializations.put(genericType, map);
		}
		else {
			specializedType = weakGet(map, elementType);
		}
		if (specializedType == null) {
			specializedType = new AbstractCollectionType(this, DomainUtil.nonNullModel(genericType.getName()), genericType, elementType);
			map.put(elementType, new WeakReference<AbstractCollectionType>(specializedType));
		}
		return specializedType;
	}

	public @NonNull DomainType getEnumerationType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._Enumeration);
	}

	public @NonNull DomainType getIntegerType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._Integer);
	}

	public @NonNull DomainType getOclAnyType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._OclAny);
	}

	public @NonNull DomainType getOclComparableType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._OclComparable);
	}

	public @NonNull DomainType getOclElementType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._OclElement);
	}

	public @NonNull DomainType getOclInvalidType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._OclInvalid);
	}

	public DomainType getOclMessageType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._OclMessage);
	}

	public @NonNull DomainType getOclSelfType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._OclSelf);
	}

	public @NonNull DomainType getOclSummableType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._OclSummable);
	}

	public @NonNull DomainType getOclTupleType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._OclTuple);
	}

	public @NonNull DomainType getOclVoidType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._OclVoid);
	}

	public @NonNull DomainType getOrderedSetType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._OrderedSet);
	}

	public @NonNull DomainCollectionType getOrderedSetType(@NonNull DomainType elementType) {
		return getCollectionType(getOrderedSetType(), elementType);
	}

	public @NonNull DomainType getRealType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._Real);
	}

	public @NonNull DomainType getSequenceType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._Sequence);
	}

	public @NonNull DomainCollectionType getSequenceType(@NonNull DomainType elementType) {
		return getCollectionType(getSequenceType(), elementType);
	}

	public @NonNull DomainType getSetType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._Set);
	}

	public @NonNull DomainCollectionType getSetType(@NonNull DomainType elementType) {
		return getCollectionType(getSetType(), elementType);
	}

	public @NonNull DomainType getStringType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._String);
	}

	public @NonNull DomainTupleType getTupleType(@NonNull List<? extends DomainTypedElement> parts) {
		StringBuilder s = new StringBuilder();
		for (DomainTypedElement part : parts) {
			s.append(part.getName());
			s.append("\n"); //$NON-NLS-1$
		}
		String key = s.toString();
		synchronized (this) {
			List<WeakReference<DomainTupleType>> tupleTypes = tupleTypeMap.get(key);
			if (tupleTypes != null) {
				for (int j = tupleTypes.size(); --j >= 0; ) {
					WeakReference<DomainTupleType> tupleTypeRef = tupleTypes.get(j);
					DomainTupleType tupleType = tupleTypeRef.get();
					if (tupleType == null) {
						tupleTypes.remove(j);		// Trim stale list entry.
					}
					else {
						int i = 0;
						for (; i < parts.size(); i++) {
							List<? extends DomainTypedElement> ownedAttributes = tupleType.getOwnedAttribute();
							if (ownedAttributes.get(i).getType() != parts.get(i).getType()) {
								break;
							}
						}
						if (i >= parts.size()) {
							return tupleType;
						}
					}
				}
			}
			else {
				tupleTypes = new ArrayList<WeakReference<DomainTupleType>>();
				tupleTypeMap.put(key, tupleTypes);
			}
			DomainTupleType tupleType = new AbstractTupleType(this, parts);
			tupleTypes.add(new WeakReference<DomainTupleType>(tupleType));
			return tupleType;
		}
	}

	public @NonNull DomainType getUnlimitedNaturalType() {
		return DomainUtil.nonNullJava(OCLstdlibTables.Types._UnlimitedNatural);
	}
}
