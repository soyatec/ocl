/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.library.executor;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.DataTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.LambdaTypeId;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.NestedPackageId;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.OclInvalidTypeId;
import org.eclipse.ocl.examples.domain.ids.OclVoidTypeId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableTypeId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.ids.UnspecifiedId;
import org.eclipse.ocl.examples.domain.types.AbstractTuplePart;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.Bag;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.OrderedSet;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.BagImpl;
import org.eclipse.ocl.examples.domain.values.impl.OrderedSetImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

public abstract class AbstractIdResolver implements IdResolver
{
	protected final @NonNull DomainStandardLibrary standardLibrary;
	private final @NonNull Map<Object, DomainType> key2type = new HashMap<Object, DomainType>();	// Concurrent puts are duplicates

	/**
	 * Mapping from name to list of correspondingly named types for definition of tuple parts. This cache is used to provide the
	 * required part definitions to construct a tuple type in the lightweight execution environment. This cache may remain
	 * unused when using the full pivot environment.
	 */
	private Map<String, Map<DomainType, WeakReference<DomainTypedElement>>> tupleParts = null;		// Lazily created
	
	public AbstractIdResolver(@NonNull DomainStandardLibrary standardLibrary) {
		this.standardLibrary = standardLibrary;
	}
	
	public @NonNull BagValue createBagValueOf(@NonNull CollectionTypeId typeId, @NonNull Object... objects) {
		Bag<Object> values = new BagImpl<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createBagValue(typeId, values);
	}

	public @NonNull BagValue createBagValueOf(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> objects) {
		Bag<Object> values = new BagImpl<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createBagValue(typeId, values);
	}

	public @NonNull OrderedSetValue createOrderedSetValueOf(@NonNull CollectionTypeId typeId, @NonNull Object... objects) {
		OrderedSet<Object> values = new OrderedSetImpl<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createOrderedSetValue(typeId, values);
	}

	public @NonNull OrderedSetValue createOrderedSetValueOf(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> objects) {
		OrderedSet<Object> values = new OrderedSetImpl<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createOrderedSetValue(typeId, values);
	}

	public @NonNull SequenceValue createSequenceValueOf(@NonNull CollectionTypeId typeId, @NonNull Object... objects) {
		List<Object> values = new ArrayList<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createSequenceValue(typeId, values);
	}

	public @NonNull SequenceValue createSequenceValueOf(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> objects) {
		List<Object> values = new ArrayList<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createSequenceValue(typeId, values);
	}

	public @NonNull SetValue createSetValueOf(@NonNull CollectionTypeId typeId, @NonNull Object... objects) {
		Set<Object> values = new HashSet<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createSetValue(typeId, values);
	}

	public @NonNull SetValue createSetValueOf(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> objects) {
		Set<Object> values = new HashSet<Object>();
		for (Object object : objects) {
			values.add(valueOf(object));
		}
		return ValuesUtil.createSetValue(typeId, values);
	}

	public void dispose() {
		tupleParts = null;
		key2type.clear();
	}

	public @NonNull DomainType getCollectionType(@NonNull CollectionTypeId typeId) {
		CollectionTypeId generalizedId = typeId.getGeneralizedId();
		if (typeId == generalizedId) {
			if (generalizedId == TypeId.BAG) {
				return standardLibrary.getBagType();
			}
			else if (generalizedId == TypeId.COLLECTION) {
				return standardLibrary.getCollectionType();
			}
			else if (generalizedId == TypeId.ORDERED_SET) {
				return standardLibrary.getOrderedSetType();
			}
			else if (generalizedId == TypeId.SEQUENCE) {
				return standardLibrary.getSequenceType();
			}
			else if (generalizedId == TypeId.SET) {
				return standardLibrary.getSetType();
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
		else {
			TypeId elementTypeId = typeId.getElementTypeId();
			DomainType elementType = getType(elementTypeId, null);
			if (generalizedId == TypeId.BAG) {
				return standardLibrary.getBagType(elementType, null, null);
			}
			else if (generalizedId == TypeId.COLLECTION) {
				return standardLibrary.getCollectionType(standardLibrary.getCollectionType(), elementType, null, null);
			}
			else if (generalizedId == TypeId.ORDERED_SET) {
				return standardLibrary.getOrderedSetType(elementType, null, null);
			}
			else if (generalizedId == TypeId.SEQUENCE) {
				return standardLibrary.getSequenceType(elementType, null, null);
			}
			else if (generalizedId == TypeId.SET) {
				return standardLibrary.getSetType(elementType, null, null);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
	}
	
	public @NonNull DomainType getDynamicTypeOf(@Nullable Object value) {
		if (value instanceof CollectionValue) {
			CollectionValue collectionValue = (CollectionValue) value;
			DomainType elementType = getDynamicTypeOf(collectionValue.iterable());
			if (elementType == null) {
				elementType = getType(collectionValue.getTypeId().getElementTypeId(), null);
			}
			CollectionTypeId collectedId = collectionValue.getTypeId();
			CollectionTypeId collectionId = collectedId.getGeneralizedId();
			TypeId elementTypeId = elementType.getTypeId();
			collectedId = collectionId.getSpecializedId(elementTypeId);
			return getCollectionType(collectedId);
		}
		else {
			return getStaticTypeOf(value);
		}
	}
	
	public @Nullable DomainType getDynamicTypeOf(@NonNull Object... values) {
		DomainType elementType = null;
		for (Object value : values) {
			DomainType valueType = getDynamicTypeOf(value);
			if (elementType == null) {
				elementType = valueType;
			}
			else {
				elementType = elementType.getCommonType(this, valueType);
			}
		}
		if (elementType == null) {
			elementType = standardLibrary.getOclInvalidType();
		}
		return elementType;
	}
	
	public @Nullable DomainType getDynamicTypeOf(@NonNull Iterable<?> values) {
		DomainType elementType = null;
		for (Object value : values) {
			DomainType valueType = getDynamicTypeOf(value);
			if (elementType == null) {
				elementType = valueType;
			}
			else {
				elementType = elementType.getCommonType(this, valueType);
			}
		}
		return elementType;
	}

	public @NonNull DomainEnumerationLiteral getEnumerationLiteral(@NonNull EnumerationLiteralId enumerationLiteralId, @Nullable DomainElement context) {
		DomainElement element = enumerationLiteralId.accept(this);
		assert element != null;
		return (DomainEnumerationLiteral)element;
	}

	public synchronized @NonNull DomainType getJavaType(@NonNull Class<?> javaClass) {
		DomainType type = key2type.get(javaClass);
		if (type != null) {
			return type;
		}
/*		if (javaClass == Boolean.class) {
			type = standardLibrary.getBooleanType();
		}
		else if (javaClass == String.class) {
			type = standardLibrary.getStringType();
		}
		else { */
			type = new JavaType(standardLibrary, javaClass);
//		}
		key2type.put(javaClass, type);
		return type;
	}

	public @NonNull DomainType getMetaclass(@NonNull MetaclassId metaclassId) {
		if (metaclassId == TypeId.METACLASS) {
			return standardLibrary.getMetaclassType();
		}
		else {
			ElementId elementId = metaclassId.getElementId();
			DomainType elementType = getType((TypeId)elementId, null);
			return standardLibrary.getMetaclass(elementType);
		}
	}

	public @NonNull DomainProperty getProperty(@NonNull PropertyId propertyId) {
		DomainElement element = propertyId.accept(this);
		if (element instanceof DomainProperty) {
			return (DomainProperty) element;
		}
		throw new IllegalStateException("No " + propertyId); //$NON-NLS-1$
	}

	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value) {
		if (value instanceof DomainType) {
			DomainType type = key2type.get(value);
			if (type == null) {
				type = standardLibrary.getMetaclass((DomainType) value);
				assert type != null;
				key2type.put(value, type);
			}
			return type;
		}
		else if (value instanceof EObject) {
			EClass eClass = ((EObject)value).eClass();
			assert eClass != null;
			DomainType type = key2type.get(eClass);
			if (type == null) {
				type = getType(eClass);
				assert type != null;
				key2type.put(eClass, type);
			}
			return type;
		}
		else if (value instanceof Value) {
			TypeId typeId = ((Value)value).getTypeId();			
			DomainType type = key2type.get(typeId);
			if (type == null) {
				type = (DomainType) typeId.accept(this);
				assert type != null;
				key2type.put(typeId, type);
			}
			return type;
		}
		else if (value == null) {
			return standardLibrary.getOclVoidType();
		}
		if (value instanceof Boolean) {
			return standardLibrary.getBooleanType();
		}
		else if (value instanceof String) {
			return standardLibrary.getStringType();
		}
		else if (value instanceof Number) {
			if ((value instanceof BigDecimal) || (value instanceof Double) || (value instanceof Float)) {
				return standardLibrary.getRealType();
			}
			if ((value instanceof BigInteger) || (value instanceof Byte) || (value instanceof Integer) || (value instanceof Long) || (value instanceof Short)) {
				return standardLibrary.getIntegerType();
			}
		}
		Class<?> jClass = value.getClass();
		assert jClass != null;
		return getJavaType(jClass);
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, Object... values) {
		Object bestTypeId = getTypeKeyOf(value);
		DomainType bestType = key2type.get(bestTypeId);
		assert bestType != null;
		Collection<Object> assessedTypeKeys = null;
		int count = 0;
		for (Object anotherValue : values) {
			Object anotherTypeId = getTypeKeyOf(anotherValue);
			if ((assessedTypeKeys == null) ? (anotherTypeId != bestTypeId) : !assessedTypeKeys.contains(anotherTypeId)) {
				DomainType anotherType = key2type.get(anotherTypeId);
				assert anotherType != null;
				DomainType commonType = bestType.getCommonType(this, anotherType);
				if (commonType != bestType) {
					if (assessedTypeKeys == null) {
						assessedTypeKeys = new ArrayList<Object>();
						assessedTypeKeys.add(bestTypeId);
					}
					else if (count++ == 4) {
						assessedTypeKeys = new HashSet<Object>(assessedTypeKeys);
					}
					assessedTypeKeys.add(anotherTypeId);
					bestType = commonType;
					bestTypeId = anotherTypeId;
				}
			}
		}		
		return bestType;
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		Object bestTypeKey = getTypeKeyOf(value);
		DomainType bestType = key2type.get(bestTypeKey);
		assert bestType != null;
		Collection<Object> assessedTypeKeys = null;
		int count = 0;
		for (Object anotherValue : values) {
			assert anotherValue != null;
			Object anotherTypeKey = getTypeKeyOf(anotherValue);
			if ((assessedTypeKeys == null) ? (anotherTypeKey != bestTypeKey) : !assessedTypeKeys.contains(anotherTypeKey)) {
				DomainType anotherType = key2type.get(anotherTypeKey);
				assert anotherType != null;
				DomainType commonType = bestType.getCommonType(this, anotherType);
				if (commonType != bestType) {
					if (assessedTypeKeys == null) {
						assessedTypeKeys = new ArrayList<Object>();
						assessedTypeKeys.add(bestTypeKey);
					}
					else if (count++ == 4) {
						assessedTypeKeys = new HashSet<Object>(assessedTypeKeys);
					}
					assessedTypeKeys.add(anotherTypeKey);
				}
			}
		}		
		return bestType;
	}
	
	public @NonNull DomainTypedElement getTuplePart(@NonNull String name, @NonNull TypeId typeId) {
		return getTuplePart(name, getType(typeId, null));
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

	public abstract @NonNull DomainTupleType getTupleType(@NonNull TupleTypeId typeId);

	public abstract @NonNull DomainType getType(@NonNull EClassifier eClassifier);

	public @NonNull DomainType getType(@NonNull TypeId typeId, @Nullable DomainElement context) {
		DomainElement type = typeId.accept(this);
		assert type != null;
		return (DomainType)type;
	}

	private @NonNull Object getTypeKeyOf(@Nullable Object value) {
		/*if (value instanceof DomainType) {
			DomainType type = (DomainType) id2element.get(value);
			if (type == null) {
				type = standardLibrary.getMetaclass((DomainType) value);
				assert type != null;
				id2element.put(value, type);
			}
			return value;
		}
		else*/ if (value instanceof EObject) {
			EClass typeKey = ((EObject)value).eClass();
			assert typeKey != null;
			DomainType type = key2type.get(typeKey);
			if (type == null) {
				type = getType(typeKey);
				assert type != null;
				key2type.put(typeKey, type);
			}
			return typeKey;
		}
		else if (value instanceof Value) {
			TypeId typeKey = ((Value)value).getTypeId();			
			DomainType type = key2type.get(typeKey);
			if (type == null) {
				type = (DomainType) typeKey.accept(this);
				assert type != null;
				key2type.put(typeKey, type);
			}
			return typeKey;
		}
		else if (value == null) {
			TypeId typeKey = TypeId.OCL_VOID;			
			key2type.put(typeKey, standardLibrary.getOclVoidType());
			return typeKey;
		}
		else {
			Class<?> typeKey = value.getClass();
			assert typeKey != null;
			DomainType type = key2type.get(typeKey);
			if (type != null) {
				return typeKey;
			}
			if (value instanceof Boolean) {
				type = standardLibrary.getBooleanType();
			}
			else if (value instanceof String) {
				type = standardLibrary.getStringType();
			}
			if (type != null) {
				key2type.put(typeKey, type);
				return typeKey;
			}
		}
		throw new UnsupportedOperationException();
	}

	public void initValue(@NonNull Object object, @NonNull PropertyId propertyId, @Nullable Object value) {
		DomainProperty property = getProperty(propertyId);
		EObject eObject = ValuesUtil.asNavigableObject(object);
		Object eValue;
		if (value instanceof Value) {
			eValue = ((Value)value).asEcoreObject();
		}
		else {
			eValue = value;
		}
//		eObject.eSet(eFeature, eValue);
		throw new UnsupportedOperationException();
	}

	public @Nullable Object valueOf(@Nullable Object object) {
		if (object == null) {
			return object;
		}
		else if (object.getClass().isArray()) {
			try {
				Object[] objects = (Object[])object;
				DomainType dynamicType = getDynamicTypeOf(objects);
				if (dynamicType == null) {
					dynamicType = standardLibrary.getOclInvalidType();
				}
				TypeId elementTypeId = dynamicType.getTypeId();
				CollectionTypeId collectedTypeId = TypeId.SEQUENCE.getSpecializedId(elementTypeId);
				return ValuesUtil.createSequenceValue(collectedTypeId, (Object[])object);
			} 
			catch (IllegalArgumentException e) {}
		}
		else if (object instanceof Iterable<?>) {
			Iterable<?> objects = (Iterable<?>)object;
			DomainType dynamicType = getDynamicTypeOf(objects);
			if (dynamicType == null) {
				dynamicType = standardLibrary.getOclInvalidType();
			}
			TypeId elementTypeId = dynamicType.getTypeId();
			CollectionTypeId collectedTypeId = TypeId.SEQUENCE.getSpecializedId(elementTypeId);
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

	public @NonNull DomainType visitClassId(@NonNull ClassId id) {
		DomainPackage parentPackage = (DomainPackage) id.getParent().accept(this);
		assert parentPackage != null;
		DomainType nestedType = standardLibrary.getNestedType(parentPackage, id.getName());
		if (nestedType == null) {
			nestedType = standardLibrary.getNestedType(parentPackage, id.getName());
			throw new UnsupportedOperationException();
		}
		return nestedType;
	}
	
	public @NonNull DomainType visitCollectedId(@NonNull CollectionTypeId id) {
		DomainType elementType = (DomainType) id.getElementTypeId().accept(this);
		if (elementType == null) {
			throw new UnsupportedOperationException();
		}
		CollectionTypeId collectionTypeId = id.getGeneralizedId();
		if (collectionTypeId == TypeId.METACLASS) {
			return standardLibrary.getMetaclass(elementType);
		}
		else {
			DomainType collectionType = getCollectionType(collectionTypeId);
			return standardLibrary.getCollectionType(collectionType, elementType, null, null);
		}
	}

	public @NonNull DomainType visitCollectionTypeId(@NonNull CollectionTypeId id) {
		return getCollectionType(id);
	}

	public @NonNull DomainType visitDataTypeId(@NonNull DataTypeId id) {
		DomainPackage parentPackage = (DomainPackage) id.getParent().accept(this);
		assert parentPackage != null;
		DomainType nestedType = standardLibrary.getNestedType(parentPackage, id.getName());
		if (nestedType == null) {
			nestedType = standardLibrary.getNestedType(parentPackage, id.getName());
			throw new UnsupportedOperationException();
		}
		return nestedType;
	}
	
	public @NonNull DomainEnumeration visitEnumerationId(@NonNull EnumerationId id) {
		DomainPackage parentPackage = (DomainPackage) id.getParent().accept(this);
		assert parentPackage != null;
		DomainType nestedType = standardLibrary.getNestedType(parentPackage, id.getName());
		if (nestedType == null) {
			nestedType = standardLibrary.getNestedType(parentPackage, id.getName());
			throw new UnsupportedOperationException();
		}
		if (!(nestedType instanceof DomainEnumeration)) {
			throw new UnsupportedOperationException();
		}
		return (DomainEnumeration) nestedType;
	}

	public @NonNull DomainEnumerationLiteral visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		DomainElement parent = id.getParentId().accept(this);
		if (!(parent instanceof DomainEnumeration)) {
			throw new UnsupportedOperationException();
		}
		DomainEnumerationLiteral enumerationLiteral = ((DomainEnumeration)parent).getEnumerationLiteral(id.getName());
		if (enumerationLiteral == null) {
			throw new UnsupportedOperationException();
		}
		return enumerationLiteral;
	}

	public @NonNull DomainType visitInvalidId(@NonNull OclInvalidTypeId id) {
		return standardLibrary.getOclInvalidType();
	}

	public @NonNull DomainType visitLambdaTypeId(@NonNull LambdaTypeId id) {
		throw new UnsupportedOperationException();
	}

	public @NonNull DomainType visitMetaclassId(@NonNull MetaclassId id) {
		return getMetaclass(id);
	}


	public @NonNull DomainPackage visitNestedPackageId(@NonNull NestedPackageId packageId) {
		DomainPackage parentPackage = (DomainPackage) packageId.getParent().accept(this);
		assert parentPackage != null;
		DomainPackage nestedPackage = standardLibrary.getNestedPackage(parentPackage, packageId.getName());
		if (nestedPackage == null) {
			throw new UnsupportedOperationException();
		}
		return nestedPackage;
	}

	public @NonNull DomainPackage visitNsURIPackageId(@NonNull NsURIPackageId id) {
		DomainPackage nsURIPackage = standardLibrary.getNsURIPackage(id.getNsURI());
		if (nsURIPackage == null) {
			throw new UnsupportedOperationException();
		}
		return nsURIPackage;
	}

	public @NonNull DomainType visitNullId(@NonNull OclVoidTypeId id) {
		return standardLibrary.getOclVoidType();
	}

	public @NonNull DomainOperation visitOperationId(@NonNull OperationId id) {
		throw new UnsupportedOperationException();
	}

//	public @NonNull DomainElement visitOperationTemplateParameterId(@NonNull OperationTemplateParameterId id) {
//		DomainOperation anOperation = (DomainOperation) id.getParent().accept(this);
//		if (anOperation == null) {
//			throw new UnsupportedOperationException();
//		}
//		DomainElement operationTemplateParameter = standardLibrary.getOperationTemplateParameter(anOperation, id.getIndex());
//		if (operationTemplateParameter == null) {
//			throw new UnsupportedOperationException();
//		}
//		return operationTemplateParameter;
//	}

	public @NonNull DomainType visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		DomainType primitiveType = standardLibrary.getPrimitiveType(id);
		if (primitiveType == null) {
			throw new UnsupportedOperationException();
		}
		return primitiveType;
	}

	public @NonNull DomainProperty visitPropertyId(@NonNull PropertyId id) {
		DomainType domainType = (DomainType) id.getParent().accept(this);
		if (domainType == null) {
			throw new UnsupportedOperationException();
		}
		DomainInheritance inheritance = standardLibrary.getInheritance(domainType);
		DomainProperty memberProperty = inheritance.getMemberProperty(id.getName());
		if (memberProperty == null) {
			throw new UnsupportedOperationException();
		}
		return memberProperty;
	}

	public @NonNull DomainPackage visitRootPackageId(@NonNull RootPackageId id) {
		DomainPackage rootPackage = standardLibrary.getRootPackage(id.getName());
		if (rootPackage == null) {
			throw new UnsupportedOperationException();
		}
		return rootPackage;
	}

	public @NonNull DomainElement visitTemplateBinding(@NonNull TemplateBinding id) {
		return id.getTemplateParameter();
	}

	public @NonNull DomainElement visitTemplateParameterId(@NonNull TemplateParameterId id) {
		return standardLibrary.getTemplateParameter(id, null);
//		DomainType aType = (DomainType) id.getParent().accept(this);
//		if (aType == null) {
//			throw new UnsupportedOperationException();
//		}
//		DomainElement typeTemplateParameter = standardLibrary.getTypeTemplateParameter(aType, id.getIndex());
//		if (typeTemplateParameter == null) {
//			throw new UnsupportedOperationException();
//		}
//		return typeTemplateParameter;
	}

	public @NonNull DomainType visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
		return getType(id, null);
	}

	public @NonNull DomainTypedElement visitTuplePartId(@NonNull TuplePartId id) {
		throw new UnsupportedOperationException();
	}

	public @NonNull DomainType visitTupleTypeId(@NonNull TupleTypeId id) {
		return getTupleType(id);
	}

	public @NonNull DomainType visitUnspecifiedId(@NonNull UnspecifiedId id) {
		return (DomainType) id.getSpecifier();
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
}
