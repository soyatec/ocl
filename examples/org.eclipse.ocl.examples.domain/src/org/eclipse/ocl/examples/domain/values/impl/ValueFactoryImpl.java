/**
 * <copyright>
 *
 * Copyright (c) 2011,2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.domain.values.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.InvalidEvaluationException;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.InvalidTypeImpl;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Bag;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.BooleanValue;
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
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.osgi.util.NLS;

/**
 * @generated NOT
 */
public abstract class ValueFactoryImpl implements ValueFactory
{
	public static final BigInteger INTEGER_MAX_VALUE = BigInteger.valueOf(Integer.MAX_VALUE);
	public static final BigInteger INTEGER_MIN_VALUE = BigInteger.valueOf(Integer.MIN_VALUE);
	public static final BigInteger LONG_MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
	public static final BigInteger LONG_MIN_VALUE = BigInteger.valueOf(Long.MIN_VALUE);
	private static final String maxLongValue = Long.toString(Long.MAX_VALUE);
	private static final int maxLongSize = maxLongValue.length();	

	private BooleanValue falseValue; 
	private InvalidValue invalidValue; 
	private NullValue nullValue; 
	private IntegerValue oneValue;
	private BooleanValue trueValue; 
	private UnlimitedValue unlimitedValue; 
	private IntegerValue zeroValue;

	protected final @NonNull DomainStandardLibrary standardLibrary;

	public ValueFactoryImpl(@NonNull DomainStandardLibrary standardLibrary) {
		this.standardLibrary = standardLibrary;
	}

	public @NonNull BooleanValue booleanValueOf(boolean value) {
		return value ? getTrue() : getFalse();
	}

    public @NonNull BagValue createBagOf(Object... objects) {
    	Bag<Object> collection = new BagImpl<Object>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createBagValue(standardLibrary.getBagType(elementType, null, null), collection);
    }

    public @NonNull BagValue createBagOf(@NonNull Iterable<?> objects) {
    	Bag<Object> collection = new BagImpl<Object>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createBagValue(standardLibrary.getBagType(elementType, null, null), collection);
    }
	
	public @NonNull BagValue createBagValue(@NonNull DomainCollectionType type, Object... values) {
		return new BagValueImpl(this, type, values);
	}

	public @NonNull BagValue createBagValue(@NonNull DomainCollectionType type, @NonNull Bag<? extends Object> values) {
		return new BagValueImpl(this, type, values);
	}

	public @NonNull BagValue createBagValue(@NonNull DomainCollectionType type, @NonNull Iterable<? extends Object> values) {
		return new BagValueImpl(this, type, values);
	}

	public @NonNull BagValue createBagValue(Object... values) {
		DomainType elementType = getElementType(values);
		DomainCollectionType collectionType = standardLibrary.getBagType(elementType, null, null);
		return new BagValueImpl(this, collectionType, values);
	}

	public @NonNull BooleanValue.Accumulator createBooleanAccumulatorValue() {
		return new BooleanValueImpl.Accumulator(this, false);
	}

	public @NonNull CollectionValue.Accumulator createCollectionAccumulatorValue(@NonNull DomainCollectionType type) {
		DomainStandardLibrary standardLibrary = getStandardLibrary();
		if (type instanceof DomainCollectionType) {
			DomainCollectionType collectionValueType = (DomainCollectionType)type;
			boolean isOrdered = collectionValueType.isOrdered();
			boolean isUnique = collectionValueType.isUnique();
			if (isOrdered) {
				if (isUnique) {
					return new SparseOrderedSetValueImpl.Accumulator(this, collectionValueType);
				}
				else {
					return new SparseSequenceValueImpl.Accumulator(this, collectionValueType);
				}
			}
			else {
				if (isUnique) {
					return new SetValueImpl.Accumulator(this, collectionValueType);
				}
				else {
					return new BagValueImpl.Accumulator(this, collectionValueType);
				}
			}
		}
		else {
			return new SetValueImpl.Accumulator(this, standardLibrary.getSetType(type, null, null));		// WIP used by "any"
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
	public @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, Object... values) {
		return createCollectionValue(isOrdered, isUnique, getElementType(values), values);
	}

	public @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull Collection<? extends Object> values) {
		return createCollectionValue(isOrdered, isUnique, getElementType(values), values);
	}

	public @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull DomainType elementType, Object... values) {
		if (isOrdered) {
			if (isUnique) {
				return createOrderedSetValue(standardLibrary.getOrderedSetType(elementType, null, null), values);
			}
			else {
				return createSequenceValue(standardLibrary.getSequenceType(elementType, null, null), values);
			}
		}
		else {
			if (isUnique) {
				return createSetValue(standardLibrary.getSetType(elementType, null, null), values);
			}
			else {
				return createBagValue(standardLibrary.getBagType(elementType, null, null), values);
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
	public @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull DomainType elementType, @NonNull Collection<? extends Object> values) {
		if (isOrdered) {
			if (isUnique) {
				return createOrderedSetValue(standardLibrary.getOrderedSetType(elementType, null, null), values);
			}
			else {
				return createSequenceValue(standardLibrary.getSequenceType(elementType, null, null), values);
			}
		}
		else {
			if (isUnique) {
				return createSetValue(standardLibrary.getSetType(elementType, null, null), values);
			}
			else {
				return createBagValue(standardLibrary.getBagType(elementType, null, null), values);
			}
		}
	}

	public @NonNull EnumerationLiteralValue createEnumerationLiteralValue(@NonNull DomainEnumerationLiteral element) {
		return new EnumerationLiteralValueImpl(this, element);
	}

	public @NonNull EnumerationLiteralValue createEnumerationLiteralValue(@NonNull EEnumLiteral eEnumLiteral) {
		DomainEnumeration enumeration = (DomainEnumeration) standardLibrary.getType(DomainUtil.nonNullModel(eEnumLiteral.getEEnum()));
		DomainEnumerationLiteral enumerationLiteral = enumeration.getEnumerationLiteral(DomainUtil.nonNullModel(eEnumLiteral.getName()));
		return createEnumerationLiteralValue(DomainUtil.nonNullPivot(enumerationLiteral));
	}

	public @NonNull EnumerationLiteralValue createEnumerationLiteralValue(@NonNull Enumerator enumerator, @NonNull EEnum eEnum) {
		DomainEnumeration enumeration = (DomainEnumeration) standardLibrary.getType(eEnum);
		DomainEnumerationLiteral enumerationLiteral = enumeration.getEnumerationLiteral(DomainUtil.nonNullModel(enumerator.getName()));
		return createEnumerationLiteralValue(DomainUtil.nonNullPivot(enumerationLiteral));
	}

	public @NonNull InvalidValue createInvalidValue(@NonNull InvalidEvaluationException exception) {
		return new InvalidValueImpl(this, exception);
	}

	public @NonNull InvalidValue createInvalidValue(@NonNull InvalidValueException exception) {
		return new InvalidValueImpl(this, new InvalidEvaluationException(null, exception));
	}

	public @NonNull InvalidValue createInvalidValue(String message, @Nullable Throwable e, @Nullable DomainExpression expression, @Nullable Object context) {
		return new InvalidValueImpl(this, new InvalidEvaluationException(null, message, null, null, null));
	}

	public @NonNull ObjectValue createObjectValue(@NonNull Object object) {
		return new JavaObjectValueImpl(this, object);
	}

    public @NonNull OrderedSetValue createOrderedSetOf(@NonNull Iterable<?> objects) {
    	OrderedSet<Object> collection = new OrderedSetImpl<Object>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createOrderedSetValue(standardLibrary.getOrderedSetType(elementType, null, null), collection);
    }

    public @NonNull OrderedSetValue createOrderedSetOf(Object... objects) {
    	OrderedSet<Object> collection = new OrderedSetImpl<Object>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createOrderedSetValue(standardLibrary.getOrderedSetType(elementType, null, null), collection);
    }

	public @NonNull OrderedSetValue createOrderedSetRange(@NonNull DomainCollectionType type, @NonNull IntegerRange range) {
		return new RangeOrderedSetValueImpl(this, type, range);
	}

	public @NonNull OrderedSetValue createOrderedSetValue(@NonNull DomainCollectionType type, Object... values) {
		return new SparseOrderedSetValueImpl(this, type, values);
	}

	public @NonNull OrderedSetValue createOrderedSetValue(@NonNull DomainCollectionType type, @NonNull OrderedSet<? extends Object> values) {
		return new SparseOrderedSetValueImpl(this, type, values);
	}

	public @NonNull OrderedSetValue createOrderedSetValue(@NonNull DomainCollectionType type, @NonNull Iterable<? extends Object> values) {
		return new SparseOrderedSetValueImpl(this, type, values);
	}

	public @NonNull OrderedSetValue createOrderedSetValue(Object... values) {
		DomainType elementType = getElementType(values);
		DomainCollectionType collectionType = standardLibrary.getOrderedSetType(elementType, null, null);
		return new SparseOrderedSetValueImpl(this, collectionType, values);
	}

    public @NonNull SequenceValue createSequenceOf(Object... objects) {
    	List<Object> collection = new ArrayList<Object>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createSequenceValue(standardLibrary.getSequenceType(elementType, null, null), collection);
    }

    public @NonNull SequenceValue createSequenceOf(@NonNull Iterable<?> objects) {
    	List<Object> collection = new ArrayList<Object>();
		for (Object object : objects) {
		   	if (object != null) {
		   		collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createSequenceValue(standardLibrary.getSequenceType(elementType, null, null), collection);
    }

	public @NonNull IntegerRange createRange(@NonNull IntegerValue firstInteger, @NonNull IntegerValue lastInteger) throws InvalidValueException {
		return new IntegerRangeImpl(firstInteger, lastInteger);
	}

	public @NonNull SequenceValue.Accumulator createSequenceAccumulatorValue(@NonNull DomainCollectionType type) {
		return new SparseSequenceValueImpl.Accumulator(this, type);
	}

	public @NonNull SequenceValue.Accumulator createSequenceAccumulatorValue(@NonNull DomainCollectionType type, @NonNull List<Value> values) {
		return new SparseSequenceValueImpl.Accumulator(this, type, values);
	}

	public @NonNull SequenceValue createSequenceRange(@NonNull DomainCollectionType type, @NonNull IntegerRange range) {
		return new RangeSequenceValueImpl(this, type, range);
	}

	public @NonNull SequenceValue createSequenceValue(@NonNull DomainCollectionType type, Object... values) {
		return new SparseSequenceValueImpl(this, type, values);
	}

	public @NonNull SequenceValue createSequenceValue(@NonNull DomainCollectionType type, @NonNull List<? extends Object> values) {
		return new SparseSequenceValueImpl(this, type, values);
	}

	public @NonNull SequenceValue createSequenceValue(@NonNull DomainCollectionType type, @NonNull Iterable<? extends Object> values) {
		return new SparseSequenceValueImpl(this, type, values);
	}

	public @NonNull SequenceValue createSequenceValue(Object... values) {
		DomainType elementType = getElementType(values);
		DomainCollectionType collectionType = standardLibrary.getSequenceType(elementType, null, null);
		return new SparseSequenceValueImpl(this, collectionType, values);
	}

    public @NonNull SetValue createSetOf(Object... objects) {
    	Set<Object> collection = new HashSet<Object>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createSetValue(standardLibrary.getSetType(elementType, null, null), collection);
    }

    public @NonNull SetValue createSetOf(@NonNull Iterable<?> objects) {
    	Set<Object> collection = new HashSet<Object>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createSetValue(standardLibrary.getSetType(elementType, null, null), collection);
    }

	public @NonNull SetValue createSetValue(@NonNull DomainCollectionType type, Object... values) {
		return new SetValueImpl(this, type, values);
	}

	public @NonNull SetValue createSetValue(@NonNull DomainCollectionType type, @NonNull Set<? extends Object> values) {
		return new SetValueImpl(this, type, values);
	}

	public @NonNull SetValue createSetValue(@NonNull DomainCollectionType type, @NonNull Iterable<? extends Object> values) {
		return new SetValueImpl(this, type, values);
	}

	public @NonNull SetValue createSetValue(Object... values) {
		DomainType elementType = getElementType(values);
		DomainCollectionType collectionType = standardLibrary.getSetType(elementType, null, null);
		return new SetValueImpl(this, collectionType, values);
	}

	public @NonNull TupleValue createTupleValue(@NonNull DomainTupleType type, @NonNull Map<? extends DomainTypedElement, Object> values) {
		return new TupleValueImpl(this, type, values);
	}

	public @NonNull TypeValue createTypeValue(@NonNull DomainType type) {
/*		if (type instanceof DomainMetaclass) {
			return new MetaclassValueImpl(this, (DomainMetaclass)type);
		}
		else if (type instanceof DomainCollectionType) {
			return new CollectionTypeValueImpl(this, (DomainCollectionType)type);
		}
		else if (type instanceof DomainEnumeration) {
			return new EnumerationTypeValueImpl(this, (DomainEnumeration)type);
		}
		else {
			return new SimpleTypeValueImpl(this, type);
		} */
		return new TypeValueImpl(this, type);
	}

	public void dispose() {
		falseValue = null; 
		invalidValue = null; 
		nullValue = null; 
		oneValue = null;
		trueValue = null; 
		unlimitedValue = null; 
		zeroValue = null;
	}

	public final @NonNull Object getEcoreValueOf(@NonNull Value value) throws InvalidValueException {
		return value.asEcoreObject();
	}
	
    public @NonNull DomainType getElementType(Object... values) {
    	DomainType elementType = standardLibrary.getOclVoidType();
    	for (Object value : values) {
    		assert value != null;
    		elementType = elementType.getCommonType(standardLibrary, typeOf(value));
    	}
     	return elementType;
    }

    public @NonNull DomainType getElementType(@NonNull Iterable<? extends Object> values) {
    	DomainType elementType = standardLibrary.getOclVoidType();
    	for (Object value : values) {
    		assert value != null;
    		elementType = elementType.getCommonType(standardLibrary, typeOf(value));
    	}
     	return elementType;
    }

	public @NonNull BooleanValue getFalse() {
		BooleanValue falseValue2 = falseValue;
		if (falseValue2 == null) {
			falseValue2 = falseValue = new BooleanValueImpl(this, false); 
		}
		return falseValue2;
	}

	public @NonNull InvalidValue getInvalid() {
		InvalidValue invalidValue2 = invalidValue;
		if (invalidValue2 == null) {
			invalidValue2 = invalidValue = new InvalidValueImpl(this); 
		}
		return invalidValue2;
	}

	public @NonNull NullValue getNull() {
		NullValue nullValue2 = nullValue;
		if (nullValue2 == null) {
			nullValue2 = nullValue = new NullValueImpl(this); 
		}
		return nullValue2;
	}

	public @NonNull IntegerValue getOne() {
		IntegerValue oneValue2 = oneValue;
		if (oneValue2 == null) {
			oneValue2 = oneValue = integerValueOf(1);
		}
		return oneValue2;
	}
	
	public final @NonNull DomainStandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	public @NonNull BooleanValue getTrue() {
		BooleanValue trueValue2 = trueValue;
		if (trueValue2 == null) {
			trueValue2 = trueValue = new BooleanValueImpl(this, true); 
		}
		return trueValue2;
	}

	public @NonNull UnlimitedValue getUnlimited() {
		UnlimitedValue unlimitedValue2 = unlimitedValue;
		if (unlimitedValue2 == null) {
			unlimitedValue2 = unlimitedValue = new UnlimitedValueImpl(this);
		}
		return unlimitedValue2;
	}

	public @NonNull IntegerValue getZero() {
		IntegerValue zeroValue2 = zeroValue;
		if (zeroValue2 == null) {
			zeroValue2 = zeroValue = integerValueOf(0);
		}
		return zeroValue2;
	}

	public @NonNull IntegerValue integerValueOf(int value) {
		return new IntIntegerValueImpl(this, value);
	}

	public @NonNull IntegerValue integerValueOf(long value) {
		if ((Integer.MIN_VALUE <= value) && (value <= Integer.MAX_VALUE)) {
			return new IntIntegerValueImpl(this, (int) value);
		}
		else {
			return new LongIntegerValueImpl(this, value);
		}
	}
	
	public @NonNull IntegerValue integerValueOf(@NonNull BigInteger value) {
		if (value.signum() >= 0) {
			if (value.compareTo(INTEGER_MAX_VALUE) <= 0) {
				return new IntIntegerValueImpl(this, value.intValue());
			}
			if (value.compareTo(LONG_MAX_VALUE) <= 0) {
				return new LongIntegerValueImpl(this, value.longValue());
			}
		}
		else {
			if (value.compareTo(INTEGER_MIN_VALUE) >= 0) {
				return new IntIntegerValueImpl(this, value.intValue());
			}
			if (value.compareTo(LONG_MIN_VALUE) >= 0) {
				return new LongIntegerValueImpl(this, value.longValue());
			}
		}
		return new BigIntegerValueImpl(this, value);
	}
    
	public @NonNull IntegerValue integerValueOf(@NonNull Number aNumber) {
		if (aNumber instanceof BigInteger) {
			return new BigIntegerValueImpl(this, (BigInteger)aNumber);
		}
		else if (aNumber instanceof Unlimited) {
			return getUnlimited();
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
	public @NonNull IntegerValue integerValueOf(@NonNull String aValue) {
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
			return createInvalidValue(new InvalidValueException(NLS.bind(EvaluatorMessages.InvalidInteger, aValue), e));
		}
	}

	public @NonNull RealValue realValueOf(double value) {
		return new RealValueImpl(this, value);
	}

	public @NonNull RealValue realValueOf(@NonNull BigDecimal value) {
		return new RealValueImpl(this, value);
	}

//	public static RealValue realValueOf(IntegerValue value) {
//		return new RealValueImpl(value.bigDecimalValue());
//	}

	public @NonNull RealValue realValueOf(@NonNull IntegerValue integerValue) {
		try {
			return realValueOf(integerValue.bigDecimalValue());
		} catch (InvalidValueException e) {
			return createInvalidValue(EvaluatorMessages.InvalidInteger, e, null, integerValue);
		}
	}
    
	public @NonNull RealValue realValueOf(@NonNull Number aNumber) {
		if (aNumber instanceof BigDecimal) {
			return new RealValueImpl(this, (BigDecimal)aNumber);
		}
		else if (aNumber instanceof BigInteger) {
			return new RealValueImpl(this, new BigDecimal((BigInteger)aNumber));
		}
		else if (aNumber instanceof Unlimited) {
			return new RealValueImpl(this, Double.POSITIVE_INFINITY);
		}
		else {
			return new RealValueImpl(this, aNumber.doubleValue());
		}
	}
	
	public @NonNull RealValue realValueOf(@NonNull String aValue) {
		try {
			return new RealValueImpl(this, new BigDecimal(aValue.trim()));
		}
		catch (NumberFormatException e) {
			return createInvalidValue(new InvalidValueException(NLS.bind(EvaluatorMessages.InvalidReal, aValue), e));
		}
	}

	public @NonNull <T> T throwInvalidValueException(/*@NonNull*/ String message, Object... bindings) throws InvalidValueException {
		String boundMessage = NLS.bind(message, bindings);
		throw new InvalidValueException(boundMessage);
	}

	public @NonNull <T> T throwInvalidValueException(@NonNull Throwable e, /*@NonNull*/ String message, Object... bindings) throws InvalidValueException {
		assert message != null;
		String boundMessage = NLS.bind(message, bindings);
		throw new InvalidValueException(boundMessage, e);
	}

	public @NonNull DomainType typeOf(@NonNull Object value) {
		if (value instanceof Value) {
			return ((Value)value).getType();
		}
		else if (value instanceof String) {
			return standardLibrary.getStringType();
		}
		else if (value instanceof DomainType) {
			return standardLibrary.getMetaclass((DomainType) value);
		}
		else if (value instanceof EObject){
			EClass eClass = ((EObject)value).eClass();
			assert eClass != null;
			return standardLibrary.getType(eClass);
		}
		else {
			return new InvalidTypeImpl(standardLibrary, DomainUtil.bind("Unsupported Object", value));
		}
//		else if (value instanceof DomainElement){
//			return standardLibrary.getType((DomainElement)value);
//		}
	}

	public @NonNull DomainType typeOf(@NonNull Object value, Object... values) {
		DomainType type = typeOf(value);
		for (Object anotherValue : values) {
			assert anotherValue != null;
			DomainType anotherType = typeOf(anotherValue);
			type = type.getCommonType(standardLibrary, anotherType);
		}		
		return type;
	}

	public @NonNull Object valueOf(@Nullable Object object) {
		if (object == null) {
			return getNull();
		}
		else if (object instanceof Value) {
			return object;
		}
		else if (object instanceof DomainType) {
			return createTypeValue((DomainType) object);
		}
		else if (object instanceof DomainEnumerationLiteral) {
			return createEnumerationLiteralValue((DomainEnumerationLiteral) object);
		}
		else if (object instanceof EEnumLiteral) {
			return createEnumerationLiteralValue((EEnumLiteral) object);
		}
		else if (object instanceof EObject) {
			return object;
		}
//		else if (object instanceof Enumerator) {
//			return createEnumerationLiteralValue((Enumerator) object, null);
//		}
		else if (object instanceof Number) {
			if ((object instanceof Integer) || (object instanceof Long) || (object instanceof Short) || (object instanceof Byte)) {
				return integerValueOf(((Number) object).longValue());
			}
			if ((object instanceof Float) || (object instanceof Double)) {
				return realValueOf(((Number) object).doubleValue());
			}
			if (object instanceof BigDecimal) {
				return realValueOf((BigDecimal) object);
			}
			if (object instanceof BigInteger) {
				return integerValueOf((BigInteger) object);
			}			
		}
		else if (object instanceof String) {
			return object;
		}
		else if (object instanceof Character) {
			return integerValueOf(((Character) object).charValue());
		}			
		else if (object instanceof Boolean) {
			return booleanValueOf((Boolean) object);
		}
		else if (object.getClass().isArray()) {
			try {
				return createSequenceOf((Object[])object);
			} 
			catch (IllegalArgumentException e) {}
		}
		else if (object instanceof Iterable<?>) {
			if ((object instanceof LinkedHashSet) || (object instanceof OrderedSet)) {
				return createOrderedSetOf((Iterable<?>)object);
			}
			else if (object instanceof Bag) {
				return createBagOf((Iterable<?>)object);
			}
			else if (object instanceof Set) {
				return createSetOf((Iterable<?>)object);
			}
			else {
				return createSequenceOf((Iterable<?>)object);
			}
		}
		return createObjectValue(object);
	}

	public @NonNull Object valueOf(@NonNull Object eValue, @Nullable EClassifier eClassifier) {
		if (eValue instanceof Value) {
			return eValue;		
		}
		else if (eClassifier instanceof EEnum) {
			return createEnumerationLiteralValue((Enumerator)eValue, (EEnum)eClassifier);		
		}
//		else if (eValue instanceof Enumerator) {
//			return createEnumerationLiteralValue((Enumerator)eValue, eClassifier);		
//		}
		else {
			return valueOf(eValue);
		}
	}

	public @NonNull Object valueOf(@NonNull Object eValue, @NonNull ETypedElement eFeature) {
		EClassifier eClassifier = eFeature.getEType();
		if (eFeature.isMany()) {
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
			boolean isOrdered = eFeature.isOrdered();
			boolean isUnique = eFeature.isUnique();
			return createCollectionValue(isOrdered, isUnique, eValues);
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
 
