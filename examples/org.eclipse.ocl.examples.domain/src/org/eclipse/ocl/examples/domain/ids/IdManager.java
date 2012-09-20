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
package org.eclipse.ocl.examples.domain.ids;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.impl.CollectionTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.LambdaTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.NsURIPackageIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.PrimitiveTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.RootPackageIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.TupleTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.UnspecifiedIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.WeakHashMapOfListOfWeakReference;
import org.eclipse.ocl.examples.domain.ids.impl.WeakHashMapOfWeakReference;

/**
 * IdManager supervises the thread-safe allocation of unique hierarchical identifier to each metamodel element.
 * 
 * @see ElementId.
 */
public class IdManager
{
	public static @NonNull IdManager INSTANCE = new IdManager();

	private static final class NameComparator implements Comparator<DomainTypedElement>
	{
		public int compare(DomainTypedElement o1, DomainTypedElement o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}
	
	public static @NonNull NameComparator NAME_COMPARATOR = new NameComparator();

	/**
	 * Map from a Collection type name to the corresponding CollectionTypeId. 
	 */
	private @NonNull WeakHashMapOfWeakReference<String, CollectionTypeId> collectionNames =
		new WeakHashMapOfWeakReference<String, CollectionTypeId>()
		{
			@Override
			protected @NonNull CollectionTypeId newTypeId(@NonNull String name) {
				return new CollectionTypeIdImpl(name);
			}
		};

	/**
	 * Map from an nsURI to the corresponding NsURITypeId. 
	 */
	private @NonNull WeakHashMapOfWeakReference<String, NsURIPackageId> nsURIs =
		new WeakHashMapOfWeakReference<String, NsURIPackageId>()
		{
			@Override
			protected @NonNull NsURIPackageId newTypeId(@NonNull String nsURI) {
				return new NsURIPackageIdImpl(nsURI);
			}
		};
	
	/**
	 * Map from the Lambda hashCode to the lambda typeIds with the same hash. 
	 */
	private @NonNull WeakHashMapOfListOfWeakReference<Integer, DomainTypeParameters, LambdaTypeIdImpl> lambdaTypes =
		new WeakHashMapOfListOfWeakReference<Integer, DomainTypeParameters, LambdaTypeIdImpl>()
		{
			@Override
			protected @NonNull LambdaTypeIdImpl newTypeId(@NonNull Integer hashCode, @NonNull DomainTypeParameters typeParameters, @NonNull String name) {
				return new LambdaTypeIdImpl(name, typeParameters, hashCode);
			}		
		};

	/**
	 * Map from a name to the corresponding URI-less unnested RootPackageTypeId. 
	 */
	private @NonNull WeakHashMapOfWeakReference<String, RootPackageId> roots =
		new WeakHashMapOfWeakReference<String, RootPackageId>()
		{
			@Override
			protected @NonNull RootPackageId newTypeId(@NonNull String name) {
				return new RootPackageIdImpl(name);
			}
		};

	/**
	 * Map from the Tuple hashCode to the tuple typeIds with the same hash. 
	 */
	private @NonNull WeakHashMapOfListOfWeakReference<Integer, List<? extends DomainTypedElement>, TupleTypeIdImpl> tupleTypes =
		new WeakHashMapOfListOfWeakReference<Integer, List<? extends DomainTypedElement>, TupleTypeIdImpl>()
		{
			@Override
			protected @NonNull TupleTypeIdImpl newTypeId(@NonNull Integer hashCode, @NonNull List<? extends DomainTypedElement> parts, @NonNull String name) {
				return new TupleTypeIdImpl(name, parts, hashCode);
			}		
		};

	/**
	 * Map from a Primitive type name to the corresponding PrimitiveTypeId. 
	 */
	private @NonNull WeakHashMapOfWeakReference<String, PrimitiveTypeId> primitiveTypes =
		new WeakHashMapOfWeakReference<String, PrimitiveTypeId>()
		{
			@Override
			protected @NonNull PrimitiveTypeId newTypeId(@NonNull String name) {
				return new PrimitiveTypeIdImpl(name);
			}
		};
	
	private IdManager() {}

	/**
	 * Return the typeId for the elementTypeId specialization of collectionTypeName.
	 */
	public @NonNull CollectedTypeId getCollectedTypeId(@NonNull String collectionTypeName, @NonNull TypeId elementTypeId) {
		CollectionTypeId newTypeId = getCollectionTypeId(collectionTypeName);
		return newTypeId.getCollectedTypeId(elementTypeId);
	}

	/**
	 * Return the named collection typeId.
	 */
	public @NonNull CollectionTypeId getCollectionTypeId(@NonNull String collectionTypeName) {
		return collectionNames.getElementId(collectionTypeName);
	}

	public @NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull DomainEnumerationLiteral enumerationLiteral) {
		DomainEnumeration enumeration = enumerationLiteral.getEnumeration();
		assert enumeration != null;
		TypeId typeId = getTypeId(enumeration);
		String name = enumerationLiteral.getName();
		assert name != null;
		return typeId.getEnumerationLiteralId(name);
	}

	/**
	 * Return the named lambda typeId with the defined type parameters.
	 */
    public @NonNull TypeId getLambdaTypeId(@NonNull String name, @NonNull DomainTypeParameters typeParameters) {
    	return lambdaTypes.getTypeId(79 * name.hashCode() + typeParameters.hashCode(), typeParameters, name);
	}

	/**
	 * Return the URIed package typeId.
	 */
    public @NonNull PackageId getNsURITypeId(@NonNull String nsURI) {
		WeakReference<NsURIPackageId> ref = nsURIs.get(nsURI);
		if (ref != null) {
			PackageId oldTypeId = ref.get();
			if (oldTypeId != null) {
				return oldTypeId;
			}
		}
		synchronized (nsURIs) {
			ref = nsURIs.get(nsURI);
			if (ref != null) {
				PackageId oldTypeId = ref.get();
				if (oldTypeId != null) {
					return oldTypeId;
				}
			}
			NsURIPackageId newTypeId = new NsURIPackageIdImpl(nsURI);
			nsURIs.put(nsURI, new WeakReference<NsURIPackageId>(newTypeId));
			return newTypeId;
		}
    }

    /**
     * Return the typeId for anOperation.
      */
	public @NonNull OperationId getOperationId(@NonNull DomainOperation anOperation) {
		String name = anOperation.getName();
		assert name != null;
		DomainType parentType = anOperation.getOwningType();
		assert parentType != null;
		return parentType.getTypeId().getOperationId(anOperation);
	}

	/**
	 * Return the named tuple typeId with the defined parts (which are alphabetically ordered by part name).
	 */
    public @NonNull TupleTypeId getOrderedTupleTypeId(@NonNull String name, @NonNull List<? extends DomainTypedElement> parts) {
		int hash = name.hashCode();
		for (DomainTypedElement part : parts) {
			hash = 101 * hash + 57 * part.getName().hashCode() + part.getType().getTypeId().hashCode();
		}
	   	return tupleTypes.getTypeId(hash, parts, name);
	}

    /**
     * Return the typeId for aPackage.
     */
	public @NonNull PackageId getPackageId(@NonNull DomainPackage aPackage) {
		String nsURI = aPackage.getNsURI();
		if (nsURI != null) {
			return getNsURITypeId(nsURI);
		}
		String name = aPackage.getName();
		assert name != null;
		DomainPackage parentPackage = aPackage.getNestingPackage();
		if (parentPackage != null) {
			return parentPackage.getPackageId().getNestedPackageId(name);
		}
		else {
			return getRootPackageId(name);
		}
	}

    /**
     * Return the typeId for ePackage.
     */
	public @NonNull PackageId getPackageId(@NonNull EPackage aPackage) {
		String nsURI = aPackage.getNsURI();
		if (nsURI != null) {
			return getNsURITypeId(nsURI);
		}
		String name = aPackage.getName();
		assert name != null;
		EPackage parentPackage = aPackage.getESuperPackage();
		if (parentPackage != null) {
			return getPackageId(parentPackage).getNestedPackageId(name);
		}
		return getNsURITypeId(name);
	}

	/**
	 * Return the named primitive typeId.
	 */
	public @NonNull PrimitiveTypeId getPrimitiveTypeId(@NonNull String name) {
		return primitiveTypes.getElementId(name);
	}

	/**
	 * Return the URI-less unnested package typeId.
	 */
    public @NonNull PackageId getRootPackageId(@NonNull String name) {
		WeakReference<RootPackageId> ref = roots.get(name);
		if (ref != null) {
			PackageId oldTypeId = ref.get();
			if (oldTypeId != null) {
				return oldTypeId;
			}
		}
		synchronized (roots) {
			ref = roots.get(name);
			if (ref != null) {
				PackageId oldTypeId = ref.get();
				if (oldTypeId != null) {
					return oldTypeId;
				}
			}
			RootPackageId newTypeId = new RootPackageIdImpl(name);
			roots.put(name, new WeakReference<RootPackageId>(newTypeId));
			return newTypeId;
		}
    }

	/**
	 * Return the named tuple typeId with the defined parts (which need not be alphabetically ordered).
	 */
	public @NonNull TupleTypeId getTupleTypeId(@NonNull String name, @NonNull Collection<? extends DomainTypedElement> parts) {
		List<DomainTypedElement> orderedParts = new ArrayList<DomainTypedElement>(parts);
		Collections.sort(orderedParts, NAME_COMPARATOR);
		return getOrderedTupleTypeId(name, orderedParts);
	}

    /**
     * Return the typeId for aType.
      */
	public @NonNull TypeId getTypeId(@NonNull DomainType aType) {
		String name = aType.getName();
		assert name != null;
		DomainPackage parentPackage = aType.getPackage();
		if (parentPackage != null) {
			return parentPackage.getPackageId().getNestedTypeId(name);
		}
		else {
			return new UnspecifiedIdImpl(aType);		// FIXME This occurs for underspecified/wildcard types
		}
	}

    /**
     * Return the typeId for an EClassifier.
      */
	public @NonNull TypeId getTypeId(@NonNull EClassifier eClassifier) {
		String name = eClassifier.getName();
		assert name != null;
		EPackage parentPackage = eClassifier.getEPackage();
		assert parentPackage != null;
		return getPackageId(parentPackage).getNestedTypeId(name);
	}

    /**
     * Return the typeId for aType.
      */
	public @NonNull TypeId getUnspecifiedTypeId(@NonNull DomainType aType) {
		return new UnspecifiedIdImpl(aType);		// FIXME This occurs for underspecified/wildcard types
	}
}