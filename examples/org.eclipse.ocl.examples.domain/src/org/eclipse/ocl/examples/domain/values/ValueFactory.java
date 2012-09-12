/**
 * <copyright>
 *
 * Copyright (c) 2010,2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.domain.values;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.InvalidEvaluationException;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;

public interface ValueFactory
{
	@NonNull BooleanValue booleanValueOf(boolean value);
		
	@NonNull BagValue createBagOf(Object... objects);
	@NonNull BagValue createBagOf(@NonNull Iterable<?> objects);
	@NonNull BagValue createBagValue(Object... values);
	@NonNull BagValue createBagValue(@NonNull DomainCollectionType type, Object... values);
	@NonNull BagValue createBagValue(@NonNull DomainCollectionType type, @NonNull Bag<? extends Object> values);
	@NonNull BagValue createBagValue(@NonNull DomainCollectionType type, @NonNull Iterable<? extends Object> values);

	@NonNull BooleanValue.Accumulator createBooleanAccumulatorValue();
	@NonNull CollectionValue.Accumulator createCollectionAccumulatorValue(@NonNull DomainCollectionType type);
    
	/**
	 * Creates a new OCL <tt>Collection</tt> of the specified ordering and uniqueness.
     * 
	 * @param isOrdered the required collection ordering
	 * @param isUnique the required collection uniqueness
	 * @return the new collection
	 */
	@NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, Object... values);
	@NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull Collection<? extends Object> values);
	@NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull DomainType elementType, Object... values);
	@NonNull CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, @NonNull DomainType elementType, @NonNull Collection<? extends Object> values);
	
	@NonNull EnumerationLiteralValue createEnumerationLiteralValue(@NonNull DomainEnumerationLiteral element);
	@NonNull EnumerationLiteralValue createEnumerationLiteralValue(@NonNull EEnumLiteral eEnumLiteral);
	@NonNull EnumerationLiteralValue createEnumerationLiteralValue(@NonNull Enumerator enumerator, @NonNull EEnum eEnum);
	
	@NonNull InvalidValue createInvalidValue(@NonNull InvalidEvaluationException exception);
	@NonNull InvalidValue createInvalidValue(@NonNull InvalidValueException exception);
	@NonNull InvalidValue createInvalidValue(/*@NonNull*/ String message, @Nullable Throwable e, @Nullable DomainExpression expression, @Nullable Object context);

	@NonNull ObjectValue createObjectValue(@NonNull Object object);

	@NonNull OrderedSetValue createOrderedSetOf(Object... objects);
	@NonNull OrderedSetValue createOrderedSetOf(@NonNull Iterable<?> objects);
	@NonNull OrderedSetValue createOrderedSetRange(@NonNull DomainCollectionType type, @NonNull IntegerRange range);
	@NonNull OrderedSetValue createOrderedSetValue(Object... value);
	@NonNull OrderedSetValue createOrderedSetValue(@NonNull DomainCollectionType type, Object... values);
	@NonNull OrderedSetValue createOrderedSetValue(@NonNull DomainCollectionType type, @NonNull OrderedSet<? extends Object> values);
	@NonNull OrderedSetValue createOrderedSetValue(@NonNull DomainCollectionType type, @NonNull Iterable<? extends Object> values);

	@NonNull IntegerRange createRange(@NonNull IntegerValue firstInteger, @NonNull IntegerValue lastInteger) throws InvalidValueException;

	@NonNull SequenceValue.Accumulator createSequenceAccumulatorValue(@NonNull DomainCollectionType type);
	@NonNull SequenceValue.Accumulator createSequenceAccumulatorValue(@NonNull DomainCollectionType type, @NonNull List<Value> values);
	@NonNull SequenceValue createSequenceOf(Object... objects);
	@NonNull SequenceValue createSequenceOf(@NonNull Iterable<?> objects);
	@NonNull SequenceValue createSequenceRange(@NonNull DomainCollectionType type, @NonNull IntegerRange range);
	@NonNull SequenceValue createSequenceValue(Object... value);
	@NonNull SequenceValue createSequenceValue(@NonNull DomainCollectionType type, Object... values);
	@NonNull SequenceValue createSequenceValue(@NonNull DomainCollectionType type, @NonNull List<? extends Object> values);
	@NonNull SequenceValue createSequenceValue(@NonNull DomainCollectionType type, @NonNull Iterable<? extends Object> values);
	
	@NonNull SetValue createSetOf(Object... objects);
	@NonNull SetValue createSetOf(@NonNull Iterable<?> objects);
	@NonNull SetValue createSetValue(Object... value);
	@NonNull SetValue createSetValue(@NonNull DomainCollectionType type, Object... values);
	@NonNull SetValue createSetValue(@NonNull DomainCollectionType type, @NonNull Set<? extends Object> values);
	@NonNull SetValue createSetValue(@NonNull DomainCollectionType type, @NonNull Iterable<? extends Object> values);
	
	@NonNull TupleValue createTupleValue(@NonNull DomainTupleType type, @NonNull Map<? extends DomainTypedElement, Object> values);

	@NonNull TypeValue createTypeValue(@NonNull DomainType type);

	void dispose();

	Object getEcoreValueOf(@NonNull Value result) throws InvalidValueException;
	@NonNull DomainType getElementType(Object... values);
	@NonNull DomainType getElementType(@NonNull Iterable<? extends Object> values);

    @NonNull BooleanValue getFalse();
    @NonNull InvalidValue getInvalid();
    @NonNull NullValue getNull();
    @NonNull IntegerValue getOne();
    @NonNull DomainStandardLibrary getStandardLibrary();
    @NonNull BooleanValue getTrue();
    @NonNull UnlimitedValue getUnlimited();
    @NonNull IntegerValue getZero();
	
    @NonNull IntegerValue integerValueOf(int value);
    @NonNull IntegerValue integerValueOf(long value);
    @NonNull IntegerValue integerValueOf(@NonNull BigInteger value);
    @NonNull IntegerValue integerValueOf(@NonNull Number aNumber);
    @NonNull IntegerValue integerValueOf(@NonNull String aValue);
	
    @NonNull RealValue realValueOf(double value);
    @NonNull RealValue realValueOf(@NonNull BigDecimal value);
    @NonNull RealValue realValueOf(@NonNull IntegerValue integerValue);	
    @NonNull RealValue realValueOf(@NonNull Number aNumber);
    @NonNull RealValue realValueOf(@NonNull String aValue);
	
    @NonNull StringValue stringValueOf(@NonNull String value) ;
	
	@NonNull <T> T throwInvalidValueException(/*@NonNull*/ String message, Object... bindings) throws InvalidValueException;
//	@NonNull <T> T throwInvalidValueException(@NonNull Throwable e) throws InvalidValueException;

	@NonNull DomainType typeOf(@NonNull Object value);
	@NonNull DomainType typeOf(@NonNull Object value, Object... values);

	@NonNull Object valueOf(@Nullable Object object);
	@NonNull Object valueOf(@NonNull Object eValue, @NonNull EClassifier eClassifier);
	@NonNull Object valueOf(@NonNull Object eValue, @NonNull ETypedElement eFeature);
}
 
