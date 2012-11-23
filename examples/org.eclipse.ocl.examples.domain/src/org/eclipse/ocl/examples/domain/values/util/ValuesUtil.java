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
package org.eclipse.ocl.examples.domain.values.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.UnsupportedOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.messages.StatusCodes;
import org.eclipse.ocl.examples.domain.types.AbstractInheritance;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.domain.validation.DomainSubstitutionLabelProvider;
import org.eclipse.ocl.examples.domain.values.Bag;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedSet;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;
import org.eclipse.ocl.examples.domain.values.impl.BagImpl;
import org.eclipse.ocl.examples.domain.values.impl.BagValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.BigIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.CollectionValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.EEnumLiteralValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.EnumerationLiteralValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.IntegerRangeImpl;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.JavaObjectValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.OrderedSetImpl;
import org.eclipse.ocl.examples.domain.values.impl.RangeOrderedSetValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.RangeSequenceValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.RealValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.SetValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.SparseOrderedSetValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.SparseSequenceValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.TupleValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.TypeValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.UnlimitedValueImpl;

/**
 */
public abstract class ValuesUtil
{	
	public static final @NonNull String NULL_STRING = "null";

	private static final int NEGATIVE_INTEGERS = 256;
	private static final int POSITIVE_INTEGERS = 1025;
	private static final @NonNull IntegerValue[] INTEGER_VALUES = new IntegerValue[NEGATIVE_INTEGERS + POSITIVE_INTEGERS];

	public static @NonNull Bag<?> EMPTY_BAG = new BagImpl<Object>();	
	@SuppressWarnings("null")
	public static final @NonNull Set<Object> EMPTY_SET = Collections.emptySet();

	@SuppressWarnings("null")
	public static final @NonNull BigInteger INTEGER_MAX_VALUE = BigInteger.valueOf(Integer.MAX_VALUE);
	@SuppressWarnings("null")
	public static final @NonNull BigInteger INTEGER_MIN_VALUE = BigInteger.valueOf(Integer.MIN_VALUE);
	@SuppressWarnings("null")
	public static final @NonNull BigInteger LONG_MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
	@SuppressWarnings("null")
	public static final @NonNull BigInteger LONG_MIN_VALUE = BigInteger.valueOf(Long.MIN_VALUE);
	private static final String maxLongValue = Long.toString(Long.MAX_VALUE);
	private static final int maxLongSize = maxLongValue.length();	

	@SuppressWarnings("null")
	public static final @NonNull Boolean FALSE_VALUE = Boolean.FALSE;
	public static final @NonNull InvalidValue INVALID_VALUE = new InvalidValueImpl(new InvalidValueException("invalid")); 
	public static final @NonNull IntegerValue ONE_VALUE = integerValueOf(1);
	@SuppressWarnings("null")
	public static final @NonNull Boolean TRUE_VALUE = Boolean.TRUE;
	public static final @NonNull UnlimitedValue UNLIMITED_VALUE = new UnlimitedValueImpl(); 
	public static final @NonNull IntegerValue ZERO_VALUE = integerValueOf(0);
	
	private static boolean allStaticsInitialized = false;

	public static @NonNull BagValue asBagValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asBagValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.BAG_NAME, getTypeName(value));
		}
	}

	public static @NonNull Boolean asBoolean(@Nullable Object value) {
		if (value instanceof Boolean) {
			return (Boolean)value;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.BOOLEAN_NAME, getTypeName(value));
		}
	}

	public static @NonNull DomainCollectionType asCollectionType(@Nullable Object value) {
//		if (value instanceof DomainCollectionType) {
//			return (DomainCollectionType)value;
//		}
		if (value instanceof TypeValue) {
			DomainType instanceType = ((TypeValue)value).getInstanceType();
			if (instanceType instanceof DomainCollectionType) {
				return (DomainCollectionType)instanceType;
			}
			else {
				throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_TYPE_NAME, getTypeName(value));
			}
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_TYPE_NAME, getTypeName(value));
		}
	}

	public static @NonNull CollectionValue asCollectionValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asCollectionValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_NAME, getTypeName(value));
		}
	}

	@Deprecated
	public static Object asEcoreObject(@NonNull Object value) {
		if (value instanceof Value) {	
			return ((Value)value).asEcoreObject();
		}
		else {
			return value;			
		}
	}

	public static @NonNull Integer asInteger(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asInteger();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName(value));
		}
	}

	public static @NonNull IntegerValue asIntegerValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asIntegerValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName(value));
		}
	}

	public static @NonNull EObject asNavigableObject(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asNavigableObject();
		}
		else if (value instanceof EObject) {
			return (EObject)value;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "NavigableObject", getTypeName(value));
		}
	}

/*	public static @NonNull NumericValue asNumericValue(@Nullable Object value) {
		if (value instanceof NumericValue) {
			return (NumericValue)value;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Numeric Value", getTypeName(value));
		}
	} */

	public static @Nullable Object asObject(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asObject();
		}
		else {
			return value;			
		}
	}

	public static @NonNull OrderedSetValue asOrderedSetValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asOrderedSetValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.ORDERED_SET_NAME, getTypeName(value));
		}
	}

	public static @NonNull RealValue asRealValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asRealValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.REAL_NAME, getTypeName(value));
		}
	}

	public static @NonNull SequenceValue asSequenceValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asSequenceValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.SEQUENCE_NAME, getTypeName(value));
		}
	}

	public static @NonNull SetValue asSetValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asSetValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.SET_NAME, getTypeName(value));
		}
	}

	public static @NonNull String asString(@Nullable Object value) {
		if (value instanceof String) {
			return (String)value;
		}
//		else if (value instanceof Value) {
//			return ((Value)value).asString();
//		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.STRING_NAME, getTypeName(value));
		}
	}

	public static @NonNull TupleValue asTupleValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asTupleValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Tuple", getTypeName(value));
		}
	}

	public static @NonNull DomainType asType(@Nullable Object value) {
//		if (value instanceof DomainType) {
//			return (DomainType)value;
//		}
		if (value instanceof TypeValue) {
			return ((TypeValue)value).getInstanceType();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Type", getTypeName(value));
		}
	}

	public static @NonNull UniqueCollectionValue asUniqueCollectionValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asUniqueCollectionValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.UNIQUE_COLLECTION_NAME, getTypeName(value));
		}
	}

	public static @NonNull Value asUnlimitedNaturalValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asUnlimitedNaturalValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.UNLIMITED_NATURAL_NAME, getTypeName(value));
		}
	}

/*	public static @NonNull Object asValidValue(@Nullable Object value) {
		assert !(value instanceof InvalidValue);
		if (value != null) {
			return value;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.OCL_ANY_NAME, getTypeName(value));
		}
	} */

	public static Object asValue(Object value) {
		if (value != null) {
			return value;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.OCL_ANY_NAME, getTypeName(value));
		}
	}

	public static @NonNull BagValue createBagRange(@NonNull CollectionTypeId typeId, @NonNull Object... values) {
		Bag<Object> allValues = new BagImpl<Object>();
		for (Object value : values) {
			if (value instanceof IntegerRange) {
				allValues.addAll((IntegerRange)value);
			}
			else {
				allValues.add(value);
			}
		}
		return new BagValueImpl(typeId, allValues);
	}

	public static @NonNull BagValue createBagValue(@NonNull CollectionTypeId typeId, @NonNull Bag<? extends Object> values) {
		return new BagValueImpl(typeId, values);
	}
	
	public static @NonNull BagValue createBagValue(@NonNull CollectionTypeId typeId, @NonNull Object... values) {
		return new BagValueImpl(typeId, values);
	}
	
	public static @NonNull BagValue createBagValue(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> values) {
		return new BagValueImpl(typeId, values);
	}

	public static @NonNull CollectionValue.Accumulator createCollectionAccumulatorValue(@NonNull CollectionTypeId collectedId) {
		CollectionTypeId collectionId = collectedId.getGeneralizedId();
		if (collectionId == TypeId.BAG) {
			return new BagValueImpl.Accumulator(collectedId);
		}
		else if (collectionId == TypeId.ORDERED_SET) {
			return new SparseOrderedSetValueImpl.Accumulator(collectedId);
		}
		else if (collectionId == TypeId.SEQUENCE) {
			return new SparseSequenceValueImpl.Accumulator(collectedId);
		}
		else /*if (collectionId == TypeId.SET)*/ {
			return new SetValueImpl.Accumulator(collectedId);
		}
	}	
	
	/**
	 * Creates a new OCL <tt>Collection</tt> of the specified ordering and uniqueness.
     * 
	 * @param isOrdered the required collection ordering
	 * @param isUnique the required collection uniqueness
	 * @param values the required collection contents
	 * @return the new collection
	 */
//	public static @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, Object... values) {
//		return createCollectionValue(isOrdered, isUnique, getElementType(values), values);
//	}

//	public static @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull Collection<? extends Object> values) {
//		return createCollectionValue(isOrdered, isUnique, getElementType(values), values);
//	}

	public static @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull TypeId elementTypeId, @NonNull Object... values) {
		if (isOrdered) {
			if (isUnique) {
				return createOrderedSetValue(TypeId.ORDERED_SET.getSpecializedId(elementTypeId), values);
			}
			else {
				return createSequenceValue(TypeId.SEQUENCE.getSpecializedId(elementTypeId), values);
			}
		}
		else {
			if (isUnique) {
				return createSetValue(TypeId.SET.getSpecializedId(elementTypeId), values);
			}
			else {
				return createBagValue(TypeId.BAG.getSpecializedId(elementTypeId), values);
			}
		}
	}
   
	/**
	 * Creates a new OCL <tt>Collection</tt> of the specified ordering and uniqueness.
     * 
	 * @param isOrdered the required collection ordering
	 * @param isUnique the required collection uniqueness
	 * @param values the required collection contents
	 * @return the new collection
	 */
	public static @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull TypeId elementTypeId, @NonNull Collection<? extends Object> values) {
		if (isOrdered) {
			if (isUnique) {
				return createOrderedSetValue(TypeId.ORDERED_SET.getSpecializedId(elementTypeId), values);
			}
			else {
				return createSequenceValue(TypeId.SEQUENCE.getSpecializedId(elementTypeId), values);
			}
		}
		else {
			if (isUnique) {
				return createSetValue(TypeId.SET.getSpecializedId(elementTypeId), values);
			}
			else {
				return createBagValue(TypeId.BAG.getSpecializedId(elementTypeId), values);
			}
		}
	}

	public static @NonNull CollectionValue createCollectionValue(@NonNull CollectionTypeId collectedId, @NonNull Iterable<?> values) {
		CollectionTypeId collectionId = collectedId.getGeneralizedId();
		if (collectionId == TypeId.BAG) {
			return createBagValue(collectedId, values);
		}
		else if (collectionId == TypeId.ORDERED_SET) {
			return createOrderedSetValue(collectedId, values);
		}
		else if (collectionId == TypeId.SEQUENCE) {
			return createSequenceValue(collectedId, values);
		}
		else /*if (collectionId == TypeId.SET)*/ {
			return createSetValue(collectedId, values);
		}
	}

	public static @NonNull EnumerationLiteralValue createEnumerationLiteralValue(@NonNull DomainEnumerationLiteral element) {
		return new EnumerationLiteralValueImpl(element);
	}

//	public static @NonNull EnumerationLiteralValue createEnumerationLiteralValue(@NonNull DomainEnumerationLiteral element, @NonNull EEnum eEnum) {
//		return new EnumerationLiteralValueImpl(element);
//	}

	public static @NonNull EnumerationLiteralValue createEnumerationLiteralValue(@NonNull EEnumLiteral eEnumLiteral) {
		EEnum eEnum = eEnumLiteral.getEEnum();
		assert eEnum != null;
		EnumerationId enumId = IdManager.INSTANCE.getEnumerationId(eEnum);
		String name = eEnumLiteral.getName();
		assert name != null;
		EnumerationLiteralId enumerationLiteralId = enumId.getEnumerationLiteralId(name);
		return new EEnumLiteralValueImpl(enumerationLiteralId, eEnumLiteral);
	}

	public static @NonNull EnumerationLiteralValue createEnumerationLiteralValue(@NonNull Enumerator enumerator, @NonNull EEnum eEnum) {
//		EEnum eEnum = eEnumLiteral.getEEnum();
		assert eEnum != null;
		EnumerationId enumId = IdManager.INSTANCE.getEnumerationId(eEnum);
		String name = enumerator.getName();
		assert name != null;
		EnumerationLiteralId enumerationLiteralId = enumId.getEnumerationLiteralId(name);
		EEnumLiteral eEnumLiteral = eEnum.getEEnumLiteral(name);
		assert eEnumLiteral != null;
		return new EEnumLiteralValueImpl(enumerationLiteralId, eEnumLiteral);
	}

	public static @NonNull ObjectValue createObjectValue(@NonNull TypeId typeId, @NonNull Object object) {
		return new JavaObjectValueImpl(typeId, object);
	}

	public static @NonNull OrderedSetValue createOrderedSetRange(@NonNull CollectionTypeId typeId, @NonNull IntegerRange range) {
		return new RangeOrderedSetValueImpl(typeId, range);
	}

	public static @NonNull OrderedSetValue createOrderedSetRange(@NonNull CollectionTypeId typeId, @NonNull Object... values) {
		OrderedSet<Object> allValues = new OrderedSetImpl<Object>();
		for (Object value : values) {
			if (value instanceof IntegerRange) {
				allValues.addAll((IntegerRange)value);
			}
			else {
				allValues.add(value);
			}
		}
		return new SparseOrderedSetValueImpl(typeId, allValues);
	}

	public static @NonNull OrderedSetValue createOrderedSetValue(@NonNull CollectionTypeId typeId, @NonNull Object... values) {
		return new SparseOrderedSetValueImpl(typeId, values);
	}

	public static @NonNull OrderedSetValue createOrderedSetValue(@NonNull CollectionTypeId typeId, @NonNull Collection<? extends Object> values) {
		return new SparseOrderedSetValueImpl(typeId, values);
	}

	public static @NonNull OrderedSetValue createOrderedSetValue(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> values) {
		return new SparseOrderedSetValueImpl(typeId, values);
	}

	public static @NonNull IntegerRange createRange(@NonNull IntegerValue firstInteger, @NonNull IntegerValue lastInteger) {
		return new IntegerRangeImpl(firstInteger, lastInteger);
	}

	public static @NonNull SequenceValue createSequenceRange(@NonNull CollectionTypeId typeId, @NonNull IntegerRange range) {
		return new RangeSequenceValueImpl(typeId, range);
	}

	public static @NonNull SequenceValue createSequenceRange(@NonNull CollectionTypeId typeId, @NonNull Object... values) {
		List<Object> allValues = new ArrayList<Object>();
		for (Object value : values) {
			if (value instanceof IntegerRange) {
				allValues.addAll((IntegerRange)value);
			}
			else {
				allValues.add(value);
			}
		}
		return new SparseSequenceValueImpl(typeId, allValues);
	}

	public static @NonNull SequenceValue createSequenceValue(@NonNull CollectionTypeId typeId, @NonNull Object... values) {
		return new SparseSequenceValueImpl(typeId, values);
	}

	public static @NonNull SequenceValue createSequenceValue(@NonNull CollectionTypeId typeId, @NonNull List<? extends Object> values) {
		return new SparseSequenceValueImpl(typeId, values);
	}

	public static @NonNull SequenceValue createSequenceValue(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> values) {
		return new SparseSequenceValueImpl(typeId, values);
	}

	public static @NonNull SetValue createSetRange(@NonNull CollectionTypeId typeId, @NonNull Object... values) {
		Set<Object> allValues = new HashSet<Object>();
		for (Object value : values) {
			if (value instanceof IntegerRange) {
				allValues.addAll((IntegerRange)value);
			}
			else {
				allValues.add(value);
			}
		}
		return new SetValueImpl(typeId, allValues);
	}

	public static @NonNull SetValue createSetValue(@NonNull CollectionTypeId typeId, @NonNull Collection<? extends Object> values) {
		return new SetValueImpl(typeId, values);
	}

	public static @NonNull SetValue createSetValue(@NonNull CollectionTypeId typeId, @NonNull Object... values) {
		return new SetValueImpl(typeId, values);
	}

	public static @NonNull SetValue createSetValue(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> values) {
		return new SetValueImpl(typeId, values);
	}

	public static @NonNull TupleValue createTupleValue(@NonNull TupleTypeId typeId, @NonNull Map<? extends TuplePartId, Object> values) {
		return new TupleValueImpl(typeId, values);
	}

	public static @NonNull TupleValue createTupleValue(@NonNull TupleTypeId typeId, @NonNull Object... values) {
		return new TupleValueImpl(typeId, values);
	}

	public static @NonNull TypeValue createTypeValue(@Nullable DomainType type) {
		if (type == null) {
			throw new InvalidValueException("null type");
		}
		return new TypeValueImpl(type);
	}

	public static String getTypeName(@Nullable Object value) {
		if (value instanceof Boolean) {
			return TypeId.BOOLEAN_NAME;
		}
		else if (value instanceof String) {
			return TypeId.STRING_NAME;
		}
		else if (value instanceof Value) {
			return ((Value) value).getTypeId().getDisplayName();
		}
		else if (value == null) {
			return TypeId.OCL_VOID_NAME;
		}
		return "Object";
	}

	public static @NonNull IntegerValue integerValueOf(int value) {
		if (value > -NEGATIVE_INTEGERS) {
			if (value < POSITIVE_INTEGERS) {
				int index = value + NEGATIVE_INTEGERS;
				IntegerValue integerValue = INTEGER_VALUES[index];
				if (integerValue != null) {
					return integerValue;
				}
				synchronized (INTEGER_VALUES) {
					integerValue = INTEGER_VALUES[index];
					if (integerValue != null) {
						return integerValue;
					}
					return INTEGER_VALUES[index] = new IntIntegerValueImpl(value);
				}
			}			
		}
		return new IntIntegerValueImpl(value);
	}

	public static @NonNull IntegerValue integerValueOf(long value) {
		if ((Integer.MIN_VALUE <= value) && (value <= Integer.MAX_VALUE)) {
			return new IntIntegerValueImpl((int) value);
		}
		else {
			return new LongIntegerValueImpl(value);
		}
	}
	
	/**
	 * Initialize all static variables in this package to avoid thread contention between conflicting initializations.
	 * <p>
	 * Returns true if this invocation performed the initialization.
	 */
	public static boolean initAllStatics() {
		if (!allStaticsInitialized) {
			synchronized (ValuesUtil.class) {
				if (!allStaticsInitialized) {
					allStaticsInitialized = true;
					// org.eclipse.ocl.examples.domain.elements
					DomainParameterTypes.EMPTY_LIST.getClass();
					DomainTypeParameters.EMPTY_LIST.getClass();
					// org.eclipse.ocl.examples.domain.evaluation
					DomainModelManager.NULL.getClass();
					// org.eclipse.ocl.examples.domain.ids
					IdManager.INSTANCE.getClass();
					TemplateableId.NULL_TEMPLATEABLE_ID_ARRAY.getClass();
					TemplateBindings.EMPTY_LIST.getClass();
					TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY.getClass();
					TypeId.INTEGER.getClass();
					// org.eclipse.ocl.examples.domain.types
					AbstractInheritance.initStatics();
					// org.eclipse.ocl.examples.domain.library
					UnsupportedOperation.INSTANCE.getClass();
					// org.eclipse.ocl.examples.domain.messages
					EvaluatorMessages.InvalidOperation.getClass();
					new StatusCodes();
					// org.eclipse.ocl.examples.domain.types
					AbstractInheritance.initStatics();
					// org.eclipse.ocl.examples.domain.utilities
					DomainUtil.createNumberFromString("0");
					StandaloneProjectMap.initStatics();
					// org.eclipse.ocl.examples.domain.validation
					DomainSubstitutionLabelProvider.INSTANCE.getClass();
					// org.eclipse.ocl.examples.domain.values
					ValuesPackage.eINSTANCE.getClass();
					// org.eclipse.ocl.examples.domain.values.impl
					CollectionValueImpl.initStatics();
					RealValueImpl.initStatics();
					// org.eclipse.ocl.examples.domain.values.util
//					new ValuesAdapterFactory();
//					new ValuesSwitch<Object>();
					return true;
				}
			}
		}
		return false;
	}
	
	public static @NonNull IntegerValue integerValueOf(@NonNull BigInteger value) {
		if (value.signum() >= 0) {
			if (value.compareTo(INTEGER_MAX_VALUE) <= 0) {
				return new IntIntegerValueImpl(value.intValue());
			}
			if (value.compareTo(LONG_MAX_VALUE) <= 0) {
				return new LongIntegerValueImpl(value.longValue());
			}
		}
		else {
			if (value.compareTo(INTEGER_MIN_VALUE) >= 0) {
				return new IntIntegerValueImpl(value.intValue());
			}
			if (value.compareTo(LONG_MIN_VALUE) >= 0) {
				return new LongIntegerValueImpl(value.longValue());
			}
		}
		return new BigIntegerValueImpl(value);
	}
    
	public static @NonNull IntegerValue integerValueOf(@NonNull Number aNumber) {
		if (aNumber instanceof BigInteger) {
			return new BigIntegerValueImpl((BigInteger)aNumber);
		}
		else if (aNumber instanceof Unlimited) {
			return UNLIMITED_VALUE;
		}
		else {
			return integerValueOf(aNumber.longValue());
		}
	}
	
	/**
	 * Creates a BigInteger representation for aValue.
	 * @param aValue the string representation of a (non-negative) integer number
	 * @return the numeric representation
	 */
	public static @NonNull IntegerValue integerValueOf(@NonNull String aValue) {
		try {
			int len = aValue.length();
			if ((len < maxLongSize) || ((len == maxLongSize) && (maxLongValue.compareTo(aValue) >= 0))) {
				@SuppressWarnings("null") @NonNull BigInteger result = BigInteger.valueOf(Long.parseLong(aValue));
				return integerValueOf(result);
			}
			else {
				return integerValueOf(new BigInteger(aValue));
			}
		}
		catch (NumberFormatException e) {
			throw new InvalidValueException(e, EvaluatorMessages.InvalidInteger, aValue);
		}
	}

	public static @Nullable CollectionValue isCollectionValue(@Nullable Object value) {
		if ((value instanceof CollectionValue) && !(value instanceof NullValue)) {
			return (CollectionValue)value;
		}
		else {
			return null;
		}
	}

	public static boolean isFalse(@Nullable Object value) {
		return value == Boolean.FALSE;
	}
	
	public static IntegerValue isIntegerValue(@Nullable Object value) {
		if ((value instanceof IntegerValue) && !(value instanceof NullValue)) {
			return (IntegerValue)value;
		}
		else {
			return null;
		}
	}

	public static boolean isNull(@Nullable Object value) {
		return (value == null) || ((value instanceof NullValue) && !(value instanceof InvalidValue));
	}

	public static boolean isTrue(@Nullable Object value) {
		return value == Boolean.TRUE;
	}

	public static boolean isUnlimited(@Nullable Object value) {
		return (value instanceof UnlimitedValue) && !(value instanceof NullValue);
	}

	public static @NonNull String oclToString(@NonNull Object value) {
		@SuppressWarnings("null") @NonNull String result = value.toString();
		return result;
	}

	public static @NonNull RealValue realValueOf(double value) {
		return new RealValueImpl(value);
	}

	public static @NonNull RealValue realValueOf(@NonNull BigDecimal value) {
		return new RealValueImpl(value);
	}

//	public static RealValue realValueOf(IntegerValue value) {
//		return new RealValueImpl(value.bigDecimalValue());
//	}

	public static @NonNull RealValue realValueOf(@NonNull IntegerValue integerValue) {
		try {
			return realValueOf(integerValue.bigDecimalValue());
		} catch (InvalidValueException e) {
			throw new InvalidValueException(e, EvaluatorMessages.InvalidInteger, integerValue);
		}
	}
    
	public static @NonNull RealValue realValueOf(@NonNull Number aNumber) {
		if (aNumber instanceof BigDecimal) {
			return new RealValueImpl((BigDecimal)aNumber);
		}
		else if (aNumber instanceof BigInteger) {
			return new RealValueImpl(new BigDecimal((BigInteger)aNumber));
		}
		else if (aNumber instanceof Unlimited) {
			return new RealValueImpl(Double.POSITIVE_INFINITY);
		}
		else {
			return new RealValueImpl(aNumber.doubleValue());
		}
	}
	
	public static @NonNull RealValue realValueOf(@NonNull String aValue) {
		try {
			return new RealValueImpl(new BigDecimal(aValue.trim()));
		}
		catch (NumberFormatException e) {
			throw new InvalidValueException(e, EvaluatorMessages.InvalidReal, aValue);
		}
	}

	public static @NonNull String stringValueOf(@Nullable Object aValue) {
		String stringValue = null;
		if (aValue == null) {
			stringValue = NULL_STRING;
		}
//		else if (aValue instanceof Value) {
//			return ((Value)aValue).toString();
//		}
		else if (aValue instanceof String) {
			stringValue = "'" + ((String)aValue).toString() + "'";		// FIXME Escapes
		}
//		else if (aValue instanceof DomainType) {
//			return String.valueOf(aValue);
//		}
//		else if (aValue instanceof DomainEnumerationLiteral) {
//			return String.valueOf(aValue);
//		}
//		else if (aValue instanceof EEnumLiteral) {
//			return String.valueOf(aValue);
//		}
		else if ((aValue instanceof EObject) &&
			!((aValue instanceof DomainElement) || (aValue instanceof EEnumLiteral))) {
			stringValue = DomainUtil.getLabel((EObject) aValue);
		}
		else if (aValue.getClass().isArray()) {
			throw new UnsupportedOperationException();			// Must invoke DomainStandardLibrary.valueOf() for aggregates
		}
		else if (aValue instanceof Iterable<?>) {
			throw new UnsupportedOperationException();			// Must invoke DomainStandardLibrary.valueOf() for aggregates
		}
		else {
			stringValue = String.valueOf(aValue);
		}
		return stringValue != null ? stringValue : "<<null>>"; 
	}

	/**
	 * Throw an InvalidValueException without subsequent code appearing to be unreachable.
	 */
	public static Object throwInvalidValueException() {
		throw new InvalidValueException("invalid");
	}
	
	public static void toString(@Nullable Object value, @NonNull StringBuilder s, int sizeLimit) {
		if (value instanceof Value) {
			((Value)value).toString(s, sizeLimit);
		}
		else if (value instanceof String) {
			String string = (String)value;
			s.append("'");
			int length = string.length();
			int available = sizeLimit - (length + 1);
			if (length <= available) {
				s.append(value);
			}
			else {
				if (available > 0) {
					s.append(string.substring(0, available));
				}
				s.append("...");
			}
			s.append("'");
		}
		else if (value != null) {
			s.append(value.toString());		// FIXME limit
		}
		else {
			s.append(NULL_STRING);		// FIXME limit
		}
	}

/*	public static @NonNull TypeId typeIdOf(@NonNull Object value) {
		if (value instanceof Value) {
			return ((Value)value).getTypeId();
		}
		else if (value instanceof Boolean) {
			return TypeId.BOOLEAN;
		}
		else if (value instanceof String) {
			return TypeId.STRING;
		}
		else if (value instanceof DomainType) {
			return TypeId.METACLASS.getCollectedId(((DomainType) value).getTypeId());
		}
		else if (value instanceof EObject){
			EClass eClass = ((EObject)value).eClass();
			assert eClass != null;
			return standardLibrary.getType(eClass).getTypeId();
		}
		else {
			return new InvalidTypeImpl(standardLibrary, DomainUtil.bind("Unsupported Object", value));
		}
//		else if (value instanceof DomainElement){
//			return standardLibrary.getType((DomainElement)value);
//		}
	} */

/*	public static @NonNull DomainType typeIdOf(@NonNull Object value, Object... values) {
		DomainType type = typeOf(value);
		for (Object anotherValue : values) {
			assert anotherValue != null;
			DomainType anotherType = typeOf(anotherValue);
			type = type.getCommonType(standardLibrary, anotherType);
		}		
		return type;
	} */

	public static @Nullable Object valueOf(@Nullable Object object) {
		if (object == null) {
			return null;
		}
		else if (object instanceof Value) {
			return object;
		}
		else if (object instanceof DomainType) {
			return ValuesUtil.createTypeValue((DomainType) object);
		}
		else if (object instanceof DomainEnumerationLiteral) {
			return ValuesUtil.createEnumerationLiteralValue((DomainEnumerationLiteral) object);
		}
		else if (object instanceof EEnumLiteral) {
			return ValuesUtil.createEnumerationLiteralValue((EEnumLiteral) object);
		}
		else if (object instanceof EObject) {
			return object;
		}
//		else if (object instanceof Enumerator) {
//			return createEnumerationLiteralValue((Enumerator) object, null);
//		}
		else if (object instanceof Number) {
			if ((object instanceof Integer) || (object instanceof Long) || (object instanceof Short) || (object instanceof Byte)) {
				return ValuesUtil.integerValueOf(((Number) object).longValue());
			}
			if ((object instanceof Float) || (object instanceof Double)) {
				return ValuesUtil.realValueOf(((Number) object).doubleValue());
			}
			if (object instanceof BigDecimal) {
				return ValuesUtil.realValueOf((BigDecimal) object);
			}
			if (object instanceof BigInteger) {
				return ValuesUtil.integerValueOf((BigInteger) object);
			}			
		}
		else if (object instanceof String) {
			return object;
		}
		else if (object instanceof Character) {
			return ValuesUtil.integerValueOf(((Character) object).charValue());
		}			
		else if (object instanceof Boolean) {
			return object;
		}
		else if (object.getClass().isArray()) {
			throw new UnsupportedOperationException();			// Must invoke DomainStandardLibrary.valueOf() for aggregates
		}
		else if (object instanceof Iterable<?>) {
			throw new UnsupportedOperationException();			// Must invoke DomainStandardLibrary.valueOf() for aggregates
		}
		else if (object instanceof EObject) {
			EClass eClass = DomainUtil.nonNullEMF(((EObject)object).eClass());
			TypeId typeId = IdManager.INSTANCE.getTypeId(eClass);
			return createObjectValue(typeId, object);
		}
		throw new UnsupportedOperationException();				// Must invoke createObjectValue with the appropriate TypeId
	}

	public static @Nullable Object valueOf(@NonNull Object eValue, @Nullable EClassifier eClassifier) {
		if (eValue instanceof Value) {
			return eValue;		
		}
		else if (eClassifier instanceof EEnum) {
			EEnum eEnum = (EEnum)eClassifier;
			String name = ((Enumerator)eValue).getName();
//			TypeId enumId = ElementIdManager.INSTANCE.getTypeTypeId(eEnum);
//			EnumerationLiteralId enumerationLiteralId = enumId.getEnumerationLiteralId(name);
			EEnumLiteral eEnumLiteral = eEnum.getEEnumLiteral(name);
			assert eEnumLiteral != null;
			return createEnumerationLiteralValue(eEnumLiteral);		
		}
//		else if (eValue instanceof Enumerator) {
//			return createEnumerationLiteralValue((Enumerator)eValue, eClassifier);		
//		}
		else {
			return valueOf(eValue);
		}
	}

	public static @Nullable Object valueOf(@NonNull Object eValue, @NonNull ETypedElement eFeature, @Nullable TypeId typeId) {
		EClassifier eClassifier = eFeature.getEType();
		if (typeId instanceof CollectionTypeId) {
			Collection<?> eValues = (Collection<?>) eValue;
			if (eClassifier instanceof EDataType) {
				ArrayList<Object> values = new ArrayList<Object>(eValues.size());
				for (Object eVal : eValues) {
					if (eVal != null) {
						values.add(valueOf(eVal, eClassifier));
					}
				}
				eValues = values;
			}
			return ValuesUtil.createCollectionValue((CollectionTypeId)typeId, eValues);
		}
		else {
			return valueOf(eValue, eClassifier);
		}
	}
}
