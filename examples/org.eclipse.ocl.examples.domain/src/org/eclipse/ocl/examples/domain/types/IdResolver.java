package org.eclipse.ocl.examples.domain.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.DataTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;

public class IdResolver implements IdVisitor<DomainElement>
{
	protected final @NonNull DomainStandardLibrary standardLibrary;
	private final @NonNull Map<Object, DomainType> key2type = new HashMap<Object, DomainType>();	// Concurrent puts are duplicates
	
	public IdResolver(@NonNull DomainStandardLibrary standardLibrary) {
		this.standardLibrary = standardLibrary;
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
				elementType = elementType.getCommonType(standardLibrary, valueType);
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
				elementType = elementType.getCommonType(standardLibrary, valueType);
			}
		}
		return elementType;
	}

	public @NonNull DomainEnumerationLiteral getEnumerationLiteral(@NonNull EnumerationLiteralId enumerationLiteralId, @Nullable DomainElement context) {
		DomainElement element = enumerationLiteralId.accept(this);
		assert element != null;
		return (DomainEnumerationLiteral)element;
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

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value) {
		/*if (value instanceof DomainType) {
			DomainType type = (DomainType) id2element.get(value);
			if (type == null) {
				type = standardLibrary.getMetaclass((DomainType) value);
				assert type != null;
				id2element.put(value, type);
			}
			return type;
		}
		else*/ if (value instanceof EObject) {
			EClass eClass = ((EObject)value).eClass();
			assert eClass != null;
			DomainType type = key2type.get(eClass);
			if (type == null) {
				type = standardLibrary.getType(eClass);
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
		else {
			Class<?> jClass = value.getClass();
			assert jClass != null;
			DomainType type = key2type.get(jClass);
			if (type != null) {
				return type;
			}
			if (value instanceof Boolean) {
				type = standardLibrary.getBooleanType();
			}
			else if (value instanceof String) {
				type = standardLibrary.getStringType();
			}
			if (type != null) {
				key2type.put(jClass, type);
				return type;
			}
		}
		return new DomainInvalidTypeImpl(standardLibrary, DomainUtil.bind("Unsupported Object", value));
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
				DomainType commonType = bestType.getCommonType(standardLibrary, anotherType);
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
				DomainType commonType = bestType.getCommonType(standardLibrary, anotherType);
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
				type = standardLibrary.getType(typeKey);
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
		throw new UnsupportedOperationException();
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
		return standardLibrary.getTupleType(this, id);
	}

	public @NonNull DomainType visitUnspecifiedId(@NonNull UnspecifiedId id) {
		return (DomainType) id.getSpecifier();
	}
}
