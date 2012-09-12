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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.BooleanValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.osgi.util.NLS;

/**
 */
public abstract class ValuesUtil
{
	public static @NonNull BagValue asBagValue(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asBagValue();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "Bag", "Object"));
		}
	}

	public static boolean asBoolean(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asBoolean();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "Boolean", "Object"));
		}
	}

	public static @NonNull BooleanValue asBooleanValue(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asBooleanValue();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "Boolean", "Object"));
		}
	}

	public static @NonNull DomainCollectionType asCollectionType(@NonNull Object value) throws InvalidValueException {
//		if (value instanceof DomainCollectionType) {
//			return (DomainCollectionType)value;
//		}
		if (value instanceof TypeValue) {
			DomainType instanceType = ((TypeValue)value).getInstanceType();
			if (instanceType instanceof DomainCollectionType) {
				return (DomainCollectionType)instanceType;
			}
			else {
				throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "CollectionType", "Object"));
			}
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "CollectionType", "Object"));
		}
	}

	public static @NonNull CollectionValue asCollectionValue(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asCollectionValue();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "Collection", "Object"));
		}
	}

	public static Object asEcoreObject(@Nullable Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asEcoreObject();
		}
		else if (value != null) {
			return value;			
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "EcoreObject", "Object"));
		}
	}

	public static @NonNull Integer asInteger(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asInteger();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "Integer", "Object"));
		}
	}

	public static @NonNull IntegerValue asIntegerValue(@Nullable Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asIntegerValue();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "Integer", "Object"));
		}
	}

	public static @NonNull EObject asNavigableObject(@Nullable Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asNavigableObject();
		}
		if (value instanceof EObject) {
			return (EObject)value;
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "NavigableObject", "Object"));
		}
	}

	public static @Nullable Object asObject(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asObject();
		}
		else {
			return value;			
		}
	}

	public static @NonNull OrderedSetValue asOrderedSetValue(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asOrderedSetValue();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "OrderedSet", "Object"));
		}
	}

	public static @NonNull RealValue asRealValue(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asRealValue();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "Real", "Object"));
		}
	}

	public static @NonNull SequenceValue asSequenceValue(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asSequenceValue();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "Sequence", "Object"));
		}
	}

	public static @NonNull SetValue asSetValue(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asSetValue();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "Set", "Object"));
		}
	}

	public static @NonNull String asString(@NonNull Object value) throws InvalidValueException {
		if (value instanceof String) {
			return (String)value;
		}
		else if (value instanceof Value) {
			return ((Value)value).asString();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "String", "Object"));
		}
	}

	public static @NonNull TupleValue asTupleValue(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asTupleValue();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "Tuple", "Object"));
		}
	}

	public static @NonNull DomainType asType(@NonNull Object value) throws InvalidValueException {
//		if (value instanceof DomainType) {
//			return (DomainType)value;
//		}
		if (value instanceof TypeValue) {
			return ((TypeValue)value).getInstanceType();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "Type", "Object"));
		}
	}

	public static @NonNull UniqueCollectionValue asUniqueCollectionValue(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asUniqueCollectionValue();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "UniqueCollection", "Object"));
		}
	}

	public static @NonNull Value asUnlimitedNaturalValue(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asUnlimitedNaturalValue();
		}
		else {
			throw new InvalidValueException(NLS.bind(EvaluatorMessages.TypedValueRequired, "UnlimitedNatural", "Object"));
		}
	}

	public static @NonNull Object asValidValue(@NonNull Object value) throws InvalidValueException {
		if (value instanceof Value) {
			return ((Value)value).asValidValue();
		}
		else {
			return value;
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
		return (value instanceof BooleanValue) && ((BooleanValue)value).isFalse();
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
		return (value instanceof BooleanValue) && ((BooleanValue)value).isTrue();
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
}
