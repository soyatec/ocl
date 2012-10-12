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
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.elements.DomainTypeTemplateParameter;
import org.eclipse.ocl.examples.domain.ids.impl.GeneralizedCollectionTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.GeneralizedLambdaTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.GeneralizedTupleTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.NsURIPackageIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.PrimitiveTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.RootPackageIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.TemplateBindingImpl;
import org.eclipse.ocl.examples.domain.ids.impl.TemplateParameterIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.TuplePartIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.TypeTemplateParameterIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.UnspecifiedIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.WeakHashMapOfListOfWeakReference3;
import org.eclipse.ocl.examples.domain.ids.impl.WeakHashMapOfWeakReference;

/**
 * IdManager supervises the thread-safe allocation of unique hierarchical identifier to each metamodel element.
 * 
 * @see ElementId.
 */
public class IdManager
{
	public static @NonNull IdManager INSTANCE = new IdManager();

	/**
	 * Map from a Collection type name to the corresponding CollectionTypeId. 
	 */
	private @NonNull WeakHashMapOfWeakReference<String, CollectionTypeId> collectionNames =
		new WeakHashMapOfWeakReference<String, CollectionTypeId>()
		{
			@Override
			protected @NonNull CollectionTypeId newTypeId(@NonNull String name) {
				TypeTemplateParameterIdImpl elementTypeId = createTypeTemplateParameterId(null);
				return new GeneralizedCollectionTypeIdImpl(new TemplateParameterId[]{elementTypeId}, name, elementTypeId);
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
	private @Nullable WeakHashMapOfListOfWeakReference3<Integer, String, DomainParameterTypes, GeneralizedLambdaTypeIdImpl> lambdaTypes = null;

	/**
	 * Map from the Tuple hashCode to the tuple typeIds with the same hash. 
	 *
	private WeakHashMapOfListOfWeakReference4<Integer, String, Integer, Integer, OperationTemplateParameterIdImpl> operationTemplateParameters = 
		new WeakHashMapOfListOfWeakReference4<Integer, String, Integer, Integer, OperationTemplateParameterIdImpl>()
		{
			@Override
			protected @NonNull OperationTemplateParameterIdImpl newTypeId(@NonNull Integer hashCode, @NonNull String operationName, @NonNull Integer parameterCount, @NonNull Integer templateParameterIndex) {
				return new OperationTemplateParameterIdImpl(hashCode, operationName, parameterCount, templateParameterIndex);
			}		
		}; */

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
	 * List of template parameters; 0 index at least index ... up to most nested
	 *
	private @NonNull List<TemplateParameterId> templateParameters = new ArrayList<TemplateParameterId>();
	{
		templateParameters.add(new TemplateParameterIdImpl(0));
		templateParameters.add(new TemplateParameterIdImpl(1));
	} */
		

	/**
	 * Map from the Tuple hashCode to the tuple typeIds with the same hash. 
	 */
	private @Nullable WeakHashMapOfListOfWeakReference3<Integer, String, TuplePartId[], GeneralizedTupleTypeIdImpl> tupleTypes = null;

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

	public @NonNull TemplateBinding createTemplateBinding(@NonNull DomainTemplateParameter owningTemplateParameter) {
		return new TemplateBindingImpl(owningTemplateParameter);
	}

	public @NonNull TemplateParameterIdImpl createTemplateParameterId(@Nullable DomainTemplateParameter origin) {
		return new TemplateParameterIdImpl(origin);
	}
	
	public @NonNull TemplateParameterId[] createTemplateParameterIds(@NonNull TemplateParameterId[] oldTemplateParameters) {
		int templateParameterCount = oldTemplateParameters.length;
		TemplateParameterId[] newTemplateParameters = new TemplateParameterId[templateParameterCount];
		for (int i = 0; i < templateParameterCount; i++) {
			TemplateParameterId oldTemplateParameter = oldTemplateParameters[i];
			if (oldTemplateParameter instanceof TypeTemplateParameterId) {
				newTemplateParameters[i] = createTypeTemplateParameterId(null);
			}
			else {
				newTemplateParameters[i] = createTemplateParameterId(null);
			}
		}
		return newTemplateParameters;
	}
	
	public @NonNull TemplateParameterId[] createTemplateParameterIds(@NonNull List<ETypeParameter> oldTemplateParameters) {
		int templateParameterCount = oldTemplateParameters.size();
		TemplateParameterId[] newTemplateParameters = new TemplateParameterId[templateParameterCount];
		for (int i = 0; i < templateParameterCount; i++) {
			@SuppressWarnings("unused") ETypeParameter oldTemplateParameter = oldTemplateParameters.get(i);
			newTemplateParameters[i] = createTypeTemplateParameterId(null);
		}
		return newTemplateParameters;
	}
	
	public @NonNull TemplateParameterId[] createTemplateParameterIds(@NonNull DomainTypeParameters typeParameters) {
		int templateParameterCount = typeParameters.parametersSize();
		TemplateParameterId[] newTemplateParameters = new TemplateParameterId[templateParameterCount];
		for (int i = 0; i < templateParameterCount; i++) {
			DomainElement templateParameter = typeParameters.get(i);
			if (templateParameter instanceof DomainTypeTemplateParameter) {
				newTemplateParameters[i] = createTypeTemplateParameterId(null);
			}
			else {
				newTemplateParameters[i] = createTemplateParameterId(null);
			}
		}
		return newTemplateParameters;
	}

	public @NonNull TuplePartId createTuplePartId(@NonNull String name, @NonNull TypeId typeId) {
	   	return new TuplePartIdImpl(name, typeId);
	}

	public @NonNull TypeTemplateParameterIdImpl createTypeTemplateParameterId(@Nullable DomainTypeTemplateParameter origin) {
		return new TypeTemplateParameterIdImpl(origin);
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
    public @NonNull TypeId getLambdaTypeId(final @NonNull TemplateParameterId[] templateParameters, @NonNull String name, @NonNull DomainParameterTypes parameterTypes) {
		WeakHashMapOfListOfWeakReference3<Integer, String, DomainParameterTypes, GeneralizedLambdaTypeIdImpl> lambdaTypes2 = lambdaTypes;
		if (lambdaTypes2 == null) {
    		synchronized (this) {
    			lambdaTypes2 = lambdaTypes;
    	    	if (lambdaTypes2 == null) {
    	    		lambdaTypes = lambdaTypes2 = new WeakHashMapOfListOfWeakReference3<Integer, String, DomainParameterTypes, GeneralizedLambdaTypeIdImpl>()
    				{
    	    			@Override
    	    			protected @NonNull GeneralizedLambdaTypeIdImpl newTypeId(@NonNull Integer hashCode, @NonNull String name, @NonNull DomainParameterTypes parameterTypes) {
    	    				return new GeneralizedLambdaTypeIdImpl(hashCode, templateParameters, name, parameterTypes);
    	    			}		
					};
	    	   }
    		}
    	}
    	return lambdaTypes2.getTypeId(79 * name.hashCode() + parameterTypes.hashCode(), name, parameterTypes);
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
		DomainTypeParameters typeParameters = anOperation.getTypeParameters();
		TemplateParameterId[] templateParameters = IdManager.INSTANCE.createTemplateParameterIds(typeParameters);
		return parentType.getTypeId().getOperationId(templateParameters, name, anOperation.getParameterTypes());
	}

    /**
     * Return the anOperation template parameter Id for the templateParameterIndex'th template parameter of an operationName with parameterCount.
     *
	public @NonNull OperationTemplateParameterId getOperationTemplateParameterId(@NonNull String operationName, final int parameterCount, final int templateParameterIndex) {
		int hash = 67 * parameterCount + 11 * templateParameterIndex + operationName.hashCode();
	   	return operationTemplateParameters.getTypeId(hash, operationName, parameterCount, templateParameterIndex);
	} */

	/**
	 * Return the named tuple typeId with the defined parts (which are alphabetically ordered by part name).
	 */
    public @NonNull TupleTypeId getOrderedTupleTypeId(final @NonNull TemplateParameterId[] templateParameters, @NonNull String name, @NonNull TuplePartId[] parts) {
		WeakHashMapOfListOfWeakReference3<Integer, String, TuplePartId[], GeneralizedTupleTypeIdImpl> tupleTypes2 = tupleTypes;
		if (tupleTypes2 == null) {
    		synchronized (this) {
    			tupleTypes2 = tupleTypes;
    	    	if (tupleTypes2 == null) {
    	    		tupleTypes = tupleTypes2 = new WeakHashMapOfListOfWeakReference3<Integer, String, TuplePartId[], GeneralizedTupleTypeIdImpl>()
    				{
    	    			@Override
    	    			protected @NonNull GeneralizedTupleTypeIdImpl newTypeId(@NonNull Integer hashCode, @NonNull String name, @NonNull TuplePartId[] parts) {
    	    				return new GeneralizedTupleTypeIdImpl(hashCode, templateParameters, name, parts);
    	    			}		
					};
	    	   }
    		}
    	}
		int hash = name.hashCode();
		for (TuplePartId part : parts) {
			hash = 101 * hash + part.hashCode();
		}
		return tupleTypes2.getTypeId(hash, name, parts);
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

/*	public @NonNull TemplateParameterId getTemplateParameterId(int index) {
		if (index >= templateParameters.size()) {
			synchronized (templateParameters) {
				while (index >= templateParameters.size()) {
					templateParameters.add(new TemplateParameterIdImpl(templateParameters.size()));
				}
			}
		}
		TemplateParameterId templateParameterId = templateParameters.get(index);
		assert templateParameterId != null;
		return templateParameterId;
    } */

	/**
	 * Return the named tuple typeId with the defined parts (which need not be alphabetically ordered).
	 */
	public @NonNull TupleTypeId getTupleTypeId(@NonNull String name, @NonNull Collection<? extends TuplePartId> parts) {
		TuplePartId[] orderedParts = new TuplePartId[parts.size()];
		int i = 0;
		Map<DomainTemplateParameter, List<TemplateBinding>> bindings = new LinkedHashMap<DomainTemplateParameter, List<TemplateBinding>>();
		for (TuplePartId part : parts) {
			orderedParts[i++] = part;
			((ElementId.Internal)part).resolveTemplateBindings(bindings);
		}
		Arrays.sort(orderedParts);
		int bindingsSize = bindings.size();
		if (bindingsSize > 0) {
			List<ElementId> specializers = new ArrayList<ElementId>();
			TemplateParameterId[] templateParameters = new TemplateParameterId[bindingsSize];
			i = 0;
			for (Map.Entry<DomainTemplateParameter, List<TemplateBinding>> entry : bindings.entrySet()) {
				TypeTemplateParameterIdImpl templateParameterId = createTypeTemplateParameterId(null);
				templateParameters[i++] = templateParameterId;
				for (TemplateBinding templateBinding : entry.getValue()) {
					assert templateParameterId != null;
					templateBinding.install(templateParameterId);
				}
				DomainTemplateParameter key = entry.getKey();
				assert key != null;
				specializers.add(createTemplateBinding(key));
			}
			TupleTypeId generalizedTupleTypeId = getOrderedTupleTypeId(templateParameters, name, orderedParts);
			TemplateBindings templateBindings = new TemplateBindings(specializers);
			TupleTypeId specializedTupleTypeId = (TupleTypeId) generalizedTupleTypeId.specialize(templateBindings);
			return specializedTupleTypeId;
			}
		else {
			return getOrderedTupleTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, name, orderedParts);
		}
	}
	public @NonNull TupleTypeId getTupleTypeId(@NonNull String name, @NonNull TuplePartId... parts) {
		TuplePartId[] orderedParts = new TuplePartId[parts.length];
		int i = 0;
		for (TuplePartId part : parts) {
			orderedParts[i++] = part;
		}
		Arrays.sort(orderedParts);
		return getOrderedTupleTypeId(TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY, name, orderedParts);
	}

    /**
     * Return the typeId for aType.
      */
	public @NonNull TypeId getTypeId(@NonNull DomainType aType) {
		String name = aType.getName();
		assert name != null;
		DomainPackage parentPackage = aType.getPackage();
		if (parentPackage != null) {
			DomainTypeParameters typeParameters = aType.getTypeParameters();
			TemplateParameterId[] templateParameters = IdManager.INSTANCE.createTemplateParameterIds(typeParameters);
			return parentPackage.getPackageId().getNestedTypeId(templateParameters, name);
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
		List<ETypeParameter> typeParameters = eClassifier.getETypeParameters();
		assert typeParameters != null;
		TemplateParameterId[] templateParameters = IdManager.INSTANCE.createTemplateParameterIds(typeParameters);
		return getPackageId(parentPackage).getNestedTypeId(templateParameters, name);
	}

    /**
     * Return the typeId for aType.
      */
	public @NonNull TypeId getUnspecifiedTypeId(@NonNull DomainType aType) {
		return new UnspecifiedIdImpl(aType);		// FIXME This occurs for underspecified/wildcard types
	}
}