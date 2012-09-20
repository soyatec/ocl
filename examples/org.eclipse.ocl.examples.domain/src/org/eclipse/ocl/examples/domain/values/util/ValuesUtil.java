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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluationEnvironment;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectedTypeId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
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
import org.eclipse.ocl.examples.domain.values.impl.BagValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.BigIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.EEnumLiteralValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.EnumerationLiteralValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.IntegerRangeImpl;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.JavaObjectValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.NullValueImpl;
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
	private static final int NEGATIVE_INTEGERS = 256;
	private static final int POSITIVE_INTEGERS = 1025;
	private static final @NonNull IntegerValue[] INTEGER_VALUES = new IntegerValue[NEGATIVE_INTEGERS + POSITIVE_INTEGERS];

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
	public static final @NonNull InvalidValue INVALID_VALUE = new InvalidValueImpl(); 
	public static final @NonNull NullValue NULL_VALUE = new NullValueImpl(); 
	public static final @NonNull IntegerValue ONE_VALUE = integerValueOf(1);
	@SuppressWarnings("null")
	public static final @NonNull Boolean TRUE_VALUE = Boolean.TRUE;
	public static final @NonNull UnlimitedValue UNLIMITED_VALUE = new UnlimitedValueImpl(); 
	public static final @NonNull IntegerValue ZERO_VALUE = integerValueOf(0);

	public static @NonNull BagValue asBagValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asBagValue();
		}
		else {
			return createInvalidValue(EvaluatorMessages.TypedValueRequired, "Bag", getTypeName(value));
		}
	}

	public static @NonNull Boolean asBoolean(@Nullable Object value) {
		if (value instanceof Boolean) {
			return (Boolean)value;
		}
		else if (value instanceof InvalidValue) {
			throw new InvalidValueException((InvalidValue)value);
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, TypeId.BOOLEAN_NAME, getTypeName(value)));
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
				throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_TYPE_NAME, getTypeName(value)));
			}
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_TYPE_NAME, getTypeName(value)));
		}
	}

	public static @NonNull CollectionValue asCollectionValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asCollectionValue();
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, "Collection", getTypeName(value)));
		}
	}

/*	@Deprecated
	public static Object asEcoreObject(@Nullable Object value) {
		if (value instanceof Value) {	
			throw new UnsupportedOperationException();
//			return ((Value)value).asObject();
		}
		else if (value != null) {
			return value;			
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, "EcoreObject", getTypeName(value)));
		}
	} */

	public static @NonNull Integer asInteger(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asInteger();
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName(value)));
		}
	}

	public static @NonNull IntegerValue asIntegerValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asIntegerValue();
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName(value)));
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
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, "NavigableObject", getTypeName(value)));
		}
	}

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
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, "OrderedSet", getTypeName(value)));
		}
	}

	public static @NonNull RealValue asRealValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asRealValue();
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, TypeId.REAL_NAME, getTypeName(value)));
		}
	}

	public static @NonNull SequenceValue asSequenceValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asSequenceValue();
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, "Sequence", getTypeName(value)));
		}
	}

	public static @NonNull SetValue asSetValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asSetValue();
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, "Set", getTypeName(value)));
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
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, TypeId.STRING_NAME, getTypeName(value)));
		}
	}

	public static @NonNull TupleValue asTupleValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asTupleValue();
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, "Tuple", getTypeName(value)));
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
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, "Type", getTypeName(value)));
		}
	}

	public static @NonNull UniqueCollectionValue asUniqueCollectionValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asUniqueCollectionValue();
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, "UniqueCollection", getTypeName(value)));
		}
	}

	public static @NonNull Value asUnlimitedNaturalValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asUnlimitedNaturalValue();
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, TypeId.UNLIMITED_NATURAL_NAME, getTypeName(value)));
		}
	}

	public static @NonNull Object asValidValue(@Nullable Object value) {
		if (value instanceof InvalidValue) {
			throw new InvalidValueException((InvalidValue)value);
		}
		else if (value != null) {
			return value;
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, "OclAny", getTypeName(value)));
		}
	}

	public static Object asValue(Object value) {
		if (value != null) {
			return value;
		}
		else {
			throw new InvalidValueException(createInvalidValue(EvaluatorMessages.TypedValueRequired, "OclAny", getTypeName(value)));
		}
	}

	public static @NonNull BagValue createBagValue(@NonNull CollectedTypeId typeId, @NonNull Bag<? extends Object> values) {
		return new BagValueImpl(typeId, values);
	}
	
	public static @NonNull BagValue createBagValue(@NonNull CollectedTypeId typeId, Object... values) {
		return new BagValueImpl(typeId, values);
	}
	
	public static @NonNull BagValue createBagValue(@NonNull CollectedTypeId typeId, @NonNull Iterable<? extends Object> values) {
		return new BagValueImpl(typeId, values);
	}

	public static @NonNull CollectionValue.Accumulator createCollectionAccumulatorValue(@NonNull CollectedTypeId collectedId) {
		CollectionTypeId collectionId = collectedId.getCollectionTypeId();
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

	public static @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull TypeId elementTypeId, Object... values) {
		if (isOrdered) {
			if (isUnique) {
				return createOrderedSetValue(TypeId.ORDERED_SET.getCollectedTypeId(elementTypeId), values);
			}
			else {
				return createSequenceValue(TypeId.SEQUENCE.getCollectedTypeId(elementTypeId), values);
			}
		}
		else {
			if (isUnique) {
				return createSetValue(TypeId.SET.getCollectedTypeId(elementTypeId), values);
			}
			else {
				return createBagValue(TypeId.BAG.getCollectedTypeId(elementTypeId), values);
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
				return createOrderedSetValue(TypeId.ORDERED_SET.getCollectedTypeId(elementTypeId), values);
			}
			else {
				return createSequenceValue(TypeId.SEQUENCE.getCollectedTypeId(elementTypeId), values);
			}
		}
		else {
			if (isUnique) {
				return createSetValue(TypeId.SET.getCollectedTypeId(elementTypeId), values);
			}
			else {
				return createBagValue(TypeId.BAG.getCollectedTypeId(elementTypeId), values);
			}
		}
	}

	public static @NonNull CollectionValue createCollectionValue(@NonNull CollectedTypeId collectedId, @NonNull Iterable<?> values) {
		CollectionTypeId collectionId = collectedId.getCollectionTypeId();
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

	public static @NonNull EnumerationLiteralValue createEnumerationLiteralValue(@NonNull EEnumLiteral eEnumLiteral) {
		EEnum eEnum = eEnumLiteral.getEEnum();
		assert eEnum != null;
		TypeId enumId = IdManager.INSTANCE.getTypeId(eEnum);
		String name = eEnumLiteral.getName();
		assert name != null;
		EnumerationLiteralId enumerationLiteralId = enumId.getEnumerationLiteralId(name);
		return new EEnumLiteralValueImpl(enumerationLiteralId, eEnumLiteral);
	}

	public static @NonNull InvalidValue createInvalidValue(@NonNull Exception exception) {
		return new InvalidValueImpl("invalid", exception);
	}

	public static @NonNull InvalidValue createInvalidValue(/*@NonNull*/ String messageTemplate, Object... bindings) {
		return new InvalidValueImpl(DomainUtil.bind(messageTemplate, bindings), null);
	}

	public static @NonNull InvalidValue createInvalidValue(Exception e, /*@NonNull*/ String messageTemplate, Object... bindings) {
		return new InvalidValueImpl(DomainUtil.bind(messageTemplate, bindings), e);
	}

	public static @NonNull InvalidValue createInvalidValue(@NonNull String message,
			@NonNull DomainEvaluationEnvironment evaluationEnvironment, @Nullable Object context, @Nullable DomainExpression expression) {
		return new InvalidValueImpl(message, evaluationEnvironment, context, expression);
	}

	public static @NonNull InvalidValue createInvalidValue(@NonNull String message, @Nullable Exception exception,
			@Nullable DomainEvaluationEnvironment evaluationEnvironment, @Nullable Object context, @Nullable DomainExpression expression) {
		return new InvalidValueImpl(message, exception, evaluationEnvironment, context, expression);
	}

	public static @NonNull InvalidValue createInvalidValue(@NonNull String message, @Nullable InvalidValue nestedValue,
			@Nullable DomainEvaluationEnvironment evaluationEnvironment, @Nullable Object context, @Nullable DomainExpression expression) {
		return new InvalidValueImpl(message, nestedValue, evaluationEnvironment, context, expression);
	}

	public static @NonNull ObjectValue createObjectValue(@NonNull Object object) {
		return new JavaObjectValueImpl(object);
	}

	public static @NonNull OrderedSetValue createOrderedSetRange(@NonNull CollectedTypeId typeId, @NonNull IntegerRange range) {
		return new RangeOrderedSetValueImpl(typeId, range);
	}

	public static @NonNull OrderedSetValue createOrderedSetValue(@NonNull CollectedTypeId typeId, Object... values) {
		return new SparseOrderedSetValueImpl(typeId, values);
	}

	public static @NonNull OrderedSetValue createOrderedSetValue(@NonNull CollectedTypeId typeId, @NonNull OrderedSet<? extends Object> values) {
		return new SparseOrderedSetValueImpl(typeId, values);
	}

	public static @NonNull OrderedSetValue createOrderedSetValue(@NonNull CollectedTypeId typeId, @NonNull Iterable<? extends Object> values) {
		return new SparseOrderedSetValueImpl(typeId, values);
	}

	public static @NonNull IntegerRange createRange(@NonNull IntegerValue firstInteger, @NonNull IntegerValue lastInteger) {
		return new IntegerRangeImpl(firstInteger, lastInteger);
	}

	public static @NonNull SequenceValue createSequenceRange(@NonNull CollectedTypeId typeId, @NonNull IntegerRange range) {
		return new RangeSequenceValueImpl(typeId, range);
	}

	public static @NonNull SequenceValue createSequenceValue(@NonNull CollectedTypeId typeId, Object... values) {
		return new SparseSequenceValueImpl(typeId, values);
	}

	public static @NonNull SequenceValue createSequenceValue(@NonNull CollectedTypeId typeId, @NonNull List<? extends Object> values) {
		return new SparseSequenceValueImpl(typeId, values);
	}

	public static @NonNull SequenceValue createSequenceValue(@NonNull CollectedTypeId typeId, @NonNull Iterable<? extends Object> values) {
		return new SparseSequenceValueImpl(typeId, values);
	}

	public static @NonNull SetValue createSetValue(@NonNull CollectedTypeId typeId, @NonNull Set<? extends Object> values) {
		return new SetValueImpl(typeId, values);
	}

	public static @NonNull SetValue createSetValue(@NonNull CollectedTypeId typeId, Object... values) {
		return new SetValueImpl(typeId, values);
	}

	public static @NonNull SetValue createSetValue(@NonNull CollectedTypeId typeId, @NonNull Iterable<? extends Object> values) {
		return new SetValueImpl(typeId, values);
	}

	public static @NonNull TupleValue createTupleValue(@NonNull TupleTypeId typeId, @NonNull Map<? extends DomainTypedElement, Object> values) {
		return new TupleValueImpl(typeId, values);
	}

	public static @NonNull TypeValue createTypeValue(@NonNull DomainType type) {
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
				else {
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
			return createInvalidValue(e, EvaluatorMessages.InvalidInteger, aValue);
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

	public static boolean isInvalid(@Nullable Object value) {
		return value instanceof InvalidValue;
	}

	public static boolean isNull(@Nullable Object value) {
		return (value instanceof NullValue) && !(value instanceof InvalidValue);
	}

	public static boolean isTrue(@Nullable Object value) {
		return value == Boolean.TRUE;
	}

	public static boolean isUndefined(@Nullable Object value) {
		return value instanceof NullValue;
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
			return createInvalidValue(EvaluatorMessages.InvalidInteger, e, null, integerValue);
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
			return createInvalidValue(e, EvaluatorMessages.InvalidReal, aValue);
		}
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

	public static @NonNull Object valueOf(@Nullable Object object) {
		if (object == null) {
			return ValuesUtil.NULL_VALUE;
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
		return createObjectValue(object);
	}

	public static @NonNull Object valueOf(@NonNull Object eValue, @Nullable EClassifier eClassifier) {
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

	public static @NonNull Object valueOf(@NonNull Object eValue, @NonNull ETypedElement eFeature, @Nullable TypeId typeId) {
		EClassifier eClassifier = eFeature.getEType();
		if (typeId instanceof CollectedTypeId) {
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
			return ValuesUtil.createCollectionValue((CollectedTypeId)typeId, eValues);
		}
		else {
			if (eClassifier instanceof EClassifier) {
				return valueOf(eValue, eClassifier);
			}
			else {
				return eValue;
			}
		}
	}
}
