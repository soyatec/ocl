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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClassifierType;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Bag;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.BooleanValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.ElementValue;
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
import org.eclipse.ocl.examples.domain.values.StringValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
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
    	Bag<Value> collection = new BagImpl<Value>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createBagValue(standardLibrary.getBagType(elementType), collection);
    }

    public @NonNull BagValue createBagOf(@NonNull Iterable<?> objects) {
    	Bag<Value> collection = new BagImpl<Value>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createBagValue(standardLibrary.getBagType(elementType), collection);
    }
	
	public @NonNull BagValue createBagValue(@NonNull DomainCollectionType type, Value... values) {
		return new BagValueImpl(this, type, values);
	}

	public @NonNull BagValue createBagValue(@NonNull DomainCollectionType type, @NonNull Bag<? extends Value> values) {
		return new BagValueImpl(this, type, values);
	}

	public @NonNull BagValue createBagValue(@NonNull DomainCollectionType type, @NonNull Collection<? extends Value> values) {
		return new BagValueImpl(this, type, values);
	}

	public @NonNull BagValue createBagValue(Value... values) {
		DomainType elementType = getElementType(values);
		DomainCollectionType collectionType = standardLibrary.getBagType(elementType);
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
			return new SetValueImpl.Accumulator(this, standardLibrary.getSetType(type));		// WIP used by "any"
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
	public @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, Value... values) {
		return createCollectionValue(isOrdered, isUnique, getElementType(values), values);
	}

	public @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull Collection<Value> values) {
		return createCollectionValue(isOrdered, isUnique, getElementType(values), values);
	}

	public @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull DomainType elementType, Value... values) {
		if (isOrdered) {
			if (isUnique) {
				return createOrderedSetValue(standardLibrary.getOrderedSetType(elementType), values);
			}
			else {
				return createSequenceValue(standardLibrary.getSequenceType(elementType), values);
			}
		}
		else {
			if (isUnique) {
				return createSetValue(standardLibrary.getSetType(elementType), values);
			}
			else {
				return createBagValue(standardLibrary.getBagType(elementType), values);
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
	public @NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull DomainType elementType, @NonNull Collection<Value> values) {
		if (isOrdered) {
			if (isUnique) {
				return createOrderedSetValue(standardLibrary.getOrderedSetType(elementType), values);
			}
			else {
				return createSequenceValue(standardLibrary.getSequenceType(elementType), values);
			}
		}
		else {
			if (isUnique) {
				return createSetValue(standardLibrary.getSetType(elementType), values);
			}
			else {
				return createBagValue(standardLibrary.getBagType(elementType), values);
			}
		}
	}

	public @NonNull ObjectValue createEObjectValue(@NonNull EObject eObject) {
		if (eObject instanceof DomainElement) {
			if (eObject instanceof DomainType) {
				return createTypeValue((DomainType) eObject);
			}
			else if (eObject instanceof DomainEnumerationLiteral) {
				return createEnumerationLiteralValue((DomainEnumerationLiteral) eObject);
			}
			else {
				ElementValue elementValue = createElementValue((DomainElement) eObject);
				if (elementValue != null) {
					return elementValue;
				}
			}
		}
		else if (eObject instanceof EEnumLiteral) {
			return createEnumerationLiteralValue((EEnumLiteral) eObject);
		}
		return new EObjectValueImpl(this, eObject);
	}

	public @Nullable ElementValue createElementValue(@NonNull DomainElement element) {
		return new ElementValueImpl(this, element);
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
    	OrderedSet<Value> collection = new OrderedSetImpl<Value>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createOrderedSetValue(standardLibrary.getOrderedSetType(elementType), collection);
    }

    public @NonNull OrderedSetValue createOrderedSetOf(Object... objects) {
    	OrderedSet<Value> collection = new OrderedSetImpl<Value>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createOrderedSetValue(standardLibrary.getOrderedSetType(elementType), collection);
    }

	public @NonNull OrderedSetValue createOrderedSetRange(@NonNull DomainCollectionType type, @NonNull IntegerRange range) {
		return new RangeOrderedSetValueImpl(this, type, range);
	}

	public @NonNull OrderedSetValue createOrderedSetValue(@NonNull DomainCollectionType type, Value... values) {
		return new SparseOrderedSetValueImpl(this, type, values);
	}

	public @NonNull OrderedSetValue createOrderedSetValue(@NonNull DomainCollectionType type, @NonNull OrderedSet<? extends Value> values) {
		return new SparseOrderedSetValueImpl(this, type, values);
	}

	public @NonNull OrderedSetValue createOrderedSetValue(@NonNull DomainCollectionType type, @NonNull Collection<? extends Value> values) {
		return new SparseOrderedSetValueImpl(this, type, values);
	}

	public @NonNull OrderedSetValue createOrderedSetValue(Value... values) {
		DomainType elementType = getElementType(values);
		DomainCollectionType collectionType = standardLibrary.getOrderedSetType(elementType);
		return new SparseOrderedSetValueImpl(this, collectionType, values);
	}

    public @NonNull SequenceValue createSequenceOf(Object... objects) {
    	List<Value> collection = new ArrayList<Value>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createSequenceValue(standardLibrary.getSequenceType(elementType), collection);
    }

    public @NonNull SequenceValue createSequenceOf(@NonNull Iterable<?> objects) {
    	List<Value> collection = new ArrayList<Value>();
		for (Object object : objects) {
		   	if (object != null) {
		   		collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createSequenceValue(standardLibrary.getSequenceType(elementType), collection);
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

	public @NonNull SequenceValue createSequenceValue(@NonNull DomainCollectionType type, Value... values) {
		return new SparseSequenceValueImpl(this, type, values);
	}

	public @NonNull SequenceValue createSequenceValue(@NonNull DomainCollectionType type, @NonNull List<? extends Value> values) {
		return new SparseSequenceValueImpl(this, type, values);
	}

	public @NonNull SequenceValue createSequenceValue(@NonNull DomainCollectionType type, @NonNull Collection<? extends Value> values) {
		return new SparseSequenceValueImpl(this, type, values);
	}

	public @NonNull SequenceValue createSequenceValue(Value... values) {
		DomainType elementType = getElementType(values);
		DomainCollectionType collectionType = standardLibrary.getSequenceType(elementType);
		return new SparseSequenceValueImpl(this, collectionType, values);
	}

    public @NonNull SetValue createSetOf(Object... objects) {
    	Set<Value> collection = new HashSet<Value>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createSetValue(standardLibrary.getSetType(elementType), collection);
    }

    public @NonNull SetValue createSetOf(@NonNull Iterable<?> objects) {
    	Set<Value> collection = new HashSet<Value>();
		for (Object object : objects) {
		   	if (object != null) {
 				collection.add(valueOf(object));
    		}
    	}
    	DomainType elementType = getElementType(collection);
    	return createSetValue(standardLibrary.getSetType(elementType), collection);
    }

	public @NonNull SetValue createSetValue(@NonNull DomainCollectionType type, Value... values) {
		return new SetValueImpl(this, type, values);
	}

	public @NonNull SetValue createSetValue(@NonNull DomainCollectionType type, @NonNull Set<? extends Value> values) {
		return new SetValueImpl(this, type, values);
	}

	public @NonNull SetValue createSetValue(@NonNull DomainCollectionType type, @NonNull Collection<? extends Value> values) {
		return new SetValueImpl(this, type, values);
	}

	public @NonNull SetValue createSetValue(Value... values) {
		DomainType elementType = getElementType(values);
		DomainCollectionType collectionType = standardLibrary.getSetType(elementType);
		return new SetValueImpl(this, collectionType, values);
	}

	public @NonNull TupleValue createTupleValue(@NonNull DomainTupleType type, @NonNull Map<? extends DomainTypedElement, Value> values) {
		return new TupleValueImpl(this, type, values);
	}

	public @NonNull TypeValue createTypeValue(@NonNull DomainType type) {
		if (type instanceof DomainClassifierType) {
			return new ClassifierTypeValueImpl(this, (DomainClassifierType)type);
		}
		else if (type instanceof DomainCollectionType) {
			return new CollectionTypeValueImpl(this, (DomainCollectionType)type);
		}
		else if (type instanceof DomainEnumeration) {
			return new EnumerationTypeValueImpl(this, (DomainEnumeration)type);
		}
		else {
			return new SimpleTypeValueImpl(this, type);
		}
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
	
    public @NonNull DomainType getElementType(Value... values) {
    	DomainType elementType = standardLibrary.getOclVoidType();
    	for (Value value : values) {
    		elementType = elementType.getCommonType(standardLibrary, value.getType());
    	}
     	return elementType;
    }

	public final Object getEcoreValueOf(@NonNull Value value) {
		return value.asEcoreObject();
	}

    public @NonNull DomainType getElementType(@NonNull Iterable<Value> values) {
    	DomainType elementType = standardLibrary.getOclVoidType();
    	for (Value value : values) {
    		elementType = elementType.getCommonType(standardLibrary, value.getType());
    	}
     	return elementType;
    }

	public @NonNull BooleanValue getFalse() {
		if (falseValue == null) {
			falseValue = new BooleanValueImpl(this, false); 
		}
		return DomainUtil.nonNullJDT(falseValue);
	}

	public @NonNull InvalidValue getInvalid() {
		if (invalidValue == null) {
			invalidValue = new InvalidValueImpl(this); 
		}
		return DomainUtil.nonNullJDT(invalidValue);
	}

	public @NonNull NullValue getNull() {
		if (nullValue == null) {
			nullValue = new NullValueImpl(this); 
		}
		return DomainUtil.nonNullJDT(nullValue);
	}

	public @NonNull IntegerValue getOne() {
		if (oneValue == null) {
			oneValue = integerValueOf(1);
		}
		return DomainUtil.nonNullJDT(oneValue);
	}
	
	public final @NonNull DomainStandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	public @NonNull BooleanValue getTrue() {
		if (trueValue == null) {
			trueValue = new BooleanValueImpl(this, true); 
		}
		return DomainUtil.nonNullJDT(trueValue);
	}

	public @NonNull UnlimitedValue getUnlimited() {
		if (unlimitedValue == null) {
			unlimitedValue = new UnlimitedValueImpl(this);
		}
		return DomainUtil.nonNullJDT(unlimitedValue);
	}

	public @NonNull IntegerValue getZero() {
		if (zeroValue == null) {
			zeroValue = integerValueOf(0);
		}
		return DomainUtil.nonNullJDT(zeroValue);
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
	
	/**
	 * Creates a BigInteger representation for aValue.
	 * @param aValue the string representation of a (non-negative) integer number
	 * @return the numeric representation
	 */
	public @NonNull IntegerValue integerValueOf(@NonNull String aValue) throws InvalidValueException {
		try {
			int len = aValue.length();
			if ((len < maxLongSize) || ((len == maxLongSize) && (maxLongValue.compareTo(aValue) >= 0))) {
				BigInteger result = DomainUtil.nonNullJava(BigInteger.valueOf(Long.parseLong(aValue)));
				return integerValueOf(result);
			}
			else {
				return integerValueOf(new BigInteger(aValue));
			}
		}
		catch (NumberFormatException e) {
			return throwInvalidValueException(e, EvaluatorMessages.InvalidInteger, aValue);
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
	
	public @NonNull RealValue realValueOf(@NonNull String aValue) throws InvalidValueException {
		try {
			return new RealValueImpl(this, new BigDecimal(aValue.trim()));
		}
		catch (NumberFormatException e) {
			return throwInvalidValueException(e, EvaluatorMessages.InvalidReal, aValue);
		}
	}
	
	public @NonNull StringValue stringValueOf(@NonNull String value) {
		return new StringValueImpl(this, value);
	}

	public @NonNull <T> T throwInvalidValueException(/*@NonNull*/ String message, Object... bindings) throws InvalidValueException {
		String boundMessage = NLS.bind(message, bindings);
		throw new InvalidValueException(boundMessage);
	}

	public @NonNull <T> T throwInvalidValueException(@NonNull Throwable e, /*@NonNull*/ String message, Object... bindings) throws InvalidValueException {
		String boundMessage = NLS.bind(message, bindings);
		throw new InvalidValueException(boundMessage, e);
	}

	public @NonNull DomainType typeOf(@NonNull Value value, Value... values) {
		DomainType type = value.getType();
//		if (values != null) {
			for (Value anotherValue : values) {
				type = type.getCommonType(standardLibrary, anotherValue.getType());
			}		
//		}
		return type;
	}

	public @NonNull Value valueOf(@Nullable Object object) {
		if (object == null) {
			return getNull();
		}
		else if (object instanceof Value) {
			return (Value) object;
		}
		else if (object instanceof EObject) {
			return createEObjectValue((EObject) object);
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
			return stringValueOf((String) object);
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

	public @NonNull Value valueOf(@NonNull Object eValue, @Nullable EClassifier eClassifier) {
		if (eValue instanceof Value) {
			return (Value) eValue;		
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

	public @NonNull Value valueOf(@NonNull Object eValue, @NonNull ETypedElement eFeature) {
		EClassifier eClassifier = eFeature.getEType();
		if (eFeature.isMany()) {
			Collection<?> eValues = (Collection<?>) eValue;
			ArrayList<Value> values = new ArrayList<Value>(eValues.size());
			for (Object eVal : eValues) {
				values.add(valueOf(DomainUtil.nonNullEntry(eVal), eClassifier));
			}
			boolean isOrdered = eFeature.isOrdered();
			boolean isUnique = eFeature.isUnique();
			return createCollectionValue(isOrdered, isUnique, values);
		}
		return valueOf(eValue, eClassifier);
	}
}
 