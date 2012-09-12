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
package org.eclipse.ocl.examples.domain.typeids;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;

/**
 * TypeidManager supervises the thread-safe allocation of unique typeids to each 'conceptaul' type.
 * 
 * @see Typeid.
 */
public class TypeidManager
{
	public static @NonNull TypeidManager INSTANCE = new TypeidManager();

	private static final class NameComparator implements Comparator<DomainTypedElement>
	{
		public int compare(DomainTypedElement o1, DomainTypedElement o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}
	
	public static @NonNull NameComparator NAME_COMPARATOR = new NameComparator();

	/**
	 * Map from a Primitive type name to the corresponding PrimitiveTypeId or CollectionTypeid. 
	 */
	private @NonNull WeakHashMapOfWeakReference<String, CollectionTypeid> name2unscopedid =
		new WeakHashMapOfWeakReference<String, CollectionTypeid>()
		{
			@Override
			protected @NonNull CollectionTypeid newTypeid(@NonNull String name) {
				return new CollectionTypeid(name);
			}
		};

	/**
	 * Map from an nsURI to the corresponding NsURITypeid. 
	 */
	private @NonNull WeakHashMapOfWeakReference<String, NsURITypeid> nsURI2packageid =
		new WeakHashMapOfWeakReference<String, NsURITypeid>()
		{
			@Override
			protected @NonNull NsURITypeid newTypeid(@NonNull String nsURI) {
				return new NsURITypeid(nsURI);
			}
		};
	
	/**
	 * Map from the Lambda hashCode to the lambda typeids with the same hash. 
	 */
	private @NonNull WeakHashMapOfListOfWeakReference<Integer, DomainTypeParameters, LambdaTypeid> hash2lambdaid =
		new WeakHashMapOfListOfWeakReference<Integer, DomainTypeParameters, LambdaTypeid>()
		{
			@Override
			protected @NonNull LambdaTypeid newTypeid(@NonNull Integer hashCode, @NonNull DomainTypeParameters typeParameters, @NonNull String name) {
				return new LambdaTypeid(name, typeParameters, hashCode);
			}		
		};

	/**
	 * Map from the Tuple hashCode to the tuple typeids with the same hash. 
	 */
	private @NonNull WeakHashMapOfListOfWeakReference<Integer, List<? extends DomainTypedElement>, TupleTypeid> hash2tupleid =
		new WeakHashMapOfListOfWeakReference<Integer, List<? extends DomainTypedElement>, TupleTypeid>()
		{
			@Override
			protected @NonNull TupleTypeid newTypeid(@NonNull Integer hashCode, @NonNull List<? extends DomainTypedElement> parts, @NonNull String name) {
				return new TupleTypeid(name, parts, hashCode);
			}		
		};
	
	private TypeidManager() {}

	/**
	 * Return the typeid for the elementTypeid specialization of collectionTypeName.
	 */
	public @NonNull Typeid getCollectedTypeid(@NonNull String collectionTypeName, @NonNull Typeid elementTypeid) {
		Typeid newTypeid = getUnscopedTypeid(collectionTypeName);
		return newTypeid.getCollectedTypeid(elementTypeid);
	}

	/**
	 * Return the named lambda typeid with the defined type parameters.
	 */
    public @NonNull Typeid getLambdaTypeid(@NonNull String name, @NonNull DomainTypeParameters typeParameters) {
    	return hash2lambdaid.getTypeid(79 * name.hashCode() + typeParameters.hashCode(), typeParameters, name);
	}

	/**
	 * Return the URIed package typeid.
	 */
    public @NonNull Typeid getNsURITypeid(@NonNull String nsURI) {
		WeakReference<NsURITypeid> ref = nsURI2packageid.get(nsURI);
		if (ref != null) {
			NsURITypeid oldTypeid = ref.get();
			if (oldTypeid != null) {
				return oldTypeid;
			}
		}
		synchronized (nsURI2packageid) {
			ref = nsURI2packageid.get(nsURI);
			if (ref != null) {
				NsURITypeid oldTypeid = ref.get();
				if (oldTypeid != null) {
					return oldTypeid;
				}
			}
			NsURITypeid newTypeid = new NsURITypeid(nsURI);
			nsURI2packageid.put(nsURI, new WeakReference<NsURITypeid>(newTypeid));
			return newTypeid;
		}
    }

    /**
     * Return the typeid for anOperation.
      */
	public @NonNull Typeid getOperationTypeid(@NonNull DomainOperation anOperation) {
		String name = anOperation.getName();
		assert name != null;
		DomainType parentType = anOperation.getOwningType();
		assert parentType != null;
		return parentType.getTypeid().getOperationTypeid(anOperation);
	}

	/**
	 * Return the named tuple typeid with the defined parts (which are alphabetically ordered by part name).
	 */
    public @NonNull Typeid getOrderedTupleTypeid(@NonNull String name, @NonNull List<? extends DomainTypedElement> parts) {
		int hash = name.hashCode();
		for (DomainTypedElement part : parts) {
			hash = 101 * hash + 57 * part.getName().hashCode() + part.getType().getTypeid().hashCode();
		}
	   	return hash2tupleid.getTypeid(hash, parts, name);
	}

    /**
     * Return the typeid for aPackage.
     */
	public @NonNull Typeid getPackageTypeid(@NonNull DomainPackage aPackage) {
		String nsURI = aPackage.getNsURI();
		if (nsURI != null) {
			return getNsURITypeid(nsURI);
		}
		String name = aPackage.getName();
		assert name != null;
		DomainPackage parentPackage = aPackage.getNestingPackage();
		if (parentPackage != null) {
			return parentPackage.getTypeid().getNestedTypeid(name);
		}
		return getNsURITypeid(name);
	}

    /**
     * Return the typeid for ePackage.
     */
	public @NonNull Typeid getPackageTypeid(@NonNull EPackage aPackage) {
		String nsURI = aPackage.getNsURI();
		if (nsURI != null) {
			return getNsURITypeid(nsURI);
		}
		String name = aPackage.getName();
		assert name != null;
		EPackage parentPackage = aPackage.getESuperPackage();
		if (parentPackage != null) {
			return getPackageTypeid(parentPackage).getNestedTypeid(name);
		}
		return getNsURITypeid(name);
	}

	/**
	 * Return the named tuple typeid with the defined parts (which need not be alphabetically ordered).
	 */
	public @NonNull Typeid getTupleTypeid(@NonNull String name, @NonNull Collection<? extends DomainTypedElement> parts) {
		List<DomainTypedElement> orderedParts = new ArrayList<DomainTypedElement>(parts);
		Collections.sort(orderedParts, NAME_COMPARATOR);
		return getOrderedTupleTypeid(name, orderedParts);
	}

    /**
     * Return the typeid for aType.
      */
	public @NonNull Typeid getTypeTypeid(@NonNull DomainType aType) {
		String name = aType.getName();
		assert name != null;
		DomainPackage parentPackage = aType.getPackage();
		if (parentPackage != null) {
			return parentPackage.getTypeid().getNestedTypeid(name);
		}
		else {
			return new AbstractTypeid(aType.hashCode()) {};		// FIXME This occurs for underspecified/wildcard types
		}
	}

    /**
     * Return the typeid for an EClassifier.
      */
	public @NonNull Typeid getTypeTypeid(@NonNull EClassifier eClassifier) {
		String name = eClassifier.getName();
		assert name != null;
		EPackage parentPackage = eClassifier.getEPackage();
		assert parentPackage != null;
		return getPackageTypeid(parentPackage).getNestedTypeid(name);
	}

	/**
	 * Return the named collection or primitive typeid.
	 */
	public @NonNull Typeid getUnscopedTypeid(@NonNull String name) {
		return name2unscopedid.getTypeid(name);
	}
}