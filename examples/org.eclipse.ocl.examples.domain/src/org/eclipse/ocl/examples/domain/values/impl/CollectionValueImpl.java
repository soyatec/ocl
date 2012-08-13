/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: AbstractCollectionValue.java,v 1.7 2011/05/07 16:41:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.BooleanValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public abstract class CollectionValueImpl extends ValueImpl implements CollectionValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.COLLECTION_VALUE;
	}

	protected final @NonNull DomainCollectionType type;
	protected final @NonNull Collection<Value> elements;
	private DomainType actualType = null;			// Lazily computed
	
	protected CollectionValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull Collection<Value> elements) {
		super(valueFactory);
		this.type = type;
		this.elements = elements;
	}
	
	/**
	 * Add a value to a working collection, returning true if the working
	 * collection is changed by the addition.
	 * <p>
	 * The default implementation is appropriate for non-unique collections and
	 * must be overridden to support OCL rather than Java uniqueness semantics.
	 */
//	protected boolean add(C values, Value value) {
//		return values.add(value);
//	}

    @Override
    public @NonNull BagValue asBagValue() {
        return valueFactory.createBagValue(getBagType(), elements);
    }

	public @NonNull Collection<Value> asCollection() {
		return elements;
	}

	@Override
	public @NonNull CollectionValue asCollectionValue() {
		return this;
	}

	@Override
	public Object asEcoreObject() {
		List<Object> ecoreResult = new BasicEList<Object>(intSize());
		for (Value elementValue : this) {
			ecoreResult.add(elementValue.asEcoreObject());
		}
		return ecoreResult;
	}

	public @NonNull List<Value> asList() {
		return new ArrayList<Value>(elements);
	}

	public @NonNull Object asObject() {
		return elements;
	}

    @Override
	public @NonNull OrderedSetValue asOrderedSetValue() {
        return valueFactory.createOrderedSetValue(getOrderedSetType(), elements);
    }

    @Override
    public @NonNull SequenceValue asSequenceValue() {
        return valueFactory.createSequenceValue(getSequenceType(), elements);
    }

    @Override
    public @NonNull SetValue asSetValue() {
        return valueFactory.createSetValue(getSetType(), elements);
    }

	public @NonNull Value asValidValue() {
		return this;
	}

    /**
     * Implementation of the OCL
     * <tt>Collection::count(object : T) : Integer</tt>
     * operation.
     * 
     * @param self the source collection
     * @param object an object
     * @return the number of occurrences of the object in the collection
     * @throws InvalidValueException 
     */
    public @NonNull IntegerValue count(@NonNull Value value) throws InvalidValueException {
        long count = 0;
        for (Value next : elements) {
            if (next.equals(value)) {
                count++;
            }
        }        
        return valueFactory.integerValueOf(count);
    }

    /**
     * Implementation of the OCL
     * <tt>Collection::excludes(object : T) : Boolean</tt>
     * operation.
     * 
     * @param self the source collection
     * @param object an object
     * @return whether the collection does not include the object
     */
    public @NonNull BooleanValue excludes(@NonNull Value value) {
    	return valueFactory.booleanValueOf(!elements.contains(value));
    }

	/**
     * Implementation of the OCL
     * <tt>Collection::excludesAll(c : Collection(T)) : Boolean</tt>
     * operation.
     * 
     * @param self the source collection
     * @param c another collection
     * @return whether the source collection does not contain any of the
     *     elements of the other
     */
    public @NonNull BooleanValue excludesAll(@NonNull CollectionValue c) {
        for (Value next : c) {
            if (elements.contains(next)) {
                return valueFactory.getFalse();
            }
        }
        return valueFactory.getTrue();
    }

    /**
     * Returns true if any element flattened.
     * @throws InvalidValueException 
     */
	public boolean flatten(@NonNull Collection<Value> flattenedElements) throws InvalidValueException {
		boolean flattened = false;
		for (Value element : elements) {
			CollectionValue collectionElement = element.isCollectionValue();
			if (collectionElement != null) {
				flattened = true;
				collectionElement.flatten(flattenedElements);
			}
			else {
				flattenedElements.add(element);
			}
		}
		return flattened;
	}

	@Override
	public @NonNull DomainType getActualType() {
		DomainType actualType2 = actualType;
		if (actualType2 == null) {
			DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			DomainType elementType = null;
			for (Value value : elements) {
				DomainType valueType = value.getActualType();
				if (elementType == null) {
					elementType = valueType;
				}
				else {
					elementType = elementType.getCommonType(standardLibrary, valueType);
				}
			}
			if (elementType == null) {
				actualType2 = actualType = type;
			}
			else {
				DomainCollectionType containerType = ((DomainCollectionType)type).getContainerType();
				assert containerType != null;
				actualType2 = actualType = standardLibrary.getCollectionType(containerType, elementType, null, null);
			}
		}	
		return actualType2;
	}

	public @NonNull DomainCollectionType getBagType() {
		return valueFactory.getStandardLibrary().getBagType(getElementType());
	}

	public @NonNull DomainCollectionType getCollectionType() {
		return (DomainCollectionType) getType();
	}

	protected @NonNull DomainType getElementType() {
		return DomainUtil.nonNullModel(getCollectionType().getElementType());
	}

	protected @NonNull Collection<Value> getElements() {
		return elements;
	}

	public @NonNull Collection<Value> getObject() {
		return elements;
	}

	public @NonNull DomainCollectionType getOrderedSetType() {
		return valueFactory.getStandardLibrary().getOrderedSetType(getElementType());
	}

	public @NonNull DomainCollectionType getSequenceType() {
		return valueFactory.getStandardLibrary().getSequenceType(getElementType());
	}

	public @NonNull DomainCollectionType getSetType() {
		return valueFactory.getStandardLibrary().getSetType(getElementType());
	}

	public @NonNull DomainCollectionType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return elements.hashCode();
	}

    public @NonNull BooleanValue includes(@NonNull Value value) {
		return valueFactory.booleanValueOf(elements.contains(value));
    }

    /**
     * Implementation of the OCL
     * <tt>Collection::includesAll(c : Collection(T)) : Boolean</tt>
     * operation.
     * 
     * @param self the source collection
     * @param c another collection
     * @return whether the source collection includes all of the elements
     *     of the other
     */
    public @NonNull BooleanValue includesAll(@NonNull CollectionValue c) {
    	for (Value next : c) {
    		if (!elements.contains(next)) {
    			return valueFactory.getFalse();
    		}
    	}   	
        return valueFactory.getTrue();
    }

	public int intSize() {
		return elements.size();
	}

	public @NonNull CollectionValue intersection(@NonNull CollectionValue c) throws InvalidValueException {
		DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
		if (this instanceof OrderedSetValue) {
            return OrderedSetValueImpl.intersection(valueFactory, standardLibrary.getOrderedSetType(getElementType()), this, c);
        }
        else if (this instanceof SequenceValue && c instanceof UniqueCollectionValue) {
            return OrderedSetValueImpl.intersection(valueFactory, standardLibrary.getOrderedSetType(getElementType()), this, c);
        }
        else if (this instanceof UniqueCollectionValue || c instanceof UniqueCollectionValue) {
            return SetValueImpl.intersection(valueFactory, standardLibrary.getSetType(getElementType()), this, c);
        }
        else {
            return BagValueImpl.intersection(valueFactory, standardLibrary.getBagType(getElementType()), this, c);
        }
	}

	@Override
	public @NonNull CollectionValue isCollectionValue() {
		return this;
	}

	public @NonNull BooleanValue isEmpty() {
		return valueFactory.booleanValueOf(intSize() == 0);
	}

	public @NonNull Iterator<Value> iterator() {
		@SuppressWarnings("null") @NonNull Iterator<Value> result = elements.iterator();
		return result;
	}

	public @NonNull Value maxMin(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull LibraryBinaryOperation binaryOperation) throws InvalidValueException {
		Value result = null;
        for (Value element : elements) {
        	if (result == null) {
        		result = element;
        	}
        	else if (element != null) {
        		result = binaryOperation.evaluate(evaluator, returnType, result, element);
        		if (result.isUndefined()) {
                	valueFactory.throwInvalidValueException(EvaluatorMessages.UndefinedResult, "max/min");
        		}
        	}
        }
		if (result == null) {
        	return valueFactory.throwInvalidValueException(EvaluatorMessages.EmptyCollection, getKind(), "max/min");
		}
		return result;
    }

	public @NonNull BooleanValue notEmpty() {
		return valueFactory.booleanValueOf(intSize() != 0);
	}

    public @NonNull Set<TupleValue> product(@NonNull CollectionValue c, @NonNull DomainTupleType tupleType) {   	
		ValueFactory nonNullValueFactory = valueFactory;
    	Set<TupleValue> result = new HashSet<TupleValue>();		
        for (Value next1 : this) {
        	if (next1 != null) {
        		@NonNull Value next1a = next1;
        		for (Value next2 : c) {
            		@SuppressWarnings("null")
					@NonNull Value next1b = next1a;
    				if (next2 != null) {
    					result.add(new TupleValueImpl(nonNullValueFactory, tupleType, next1b, next2));
    				}
        		}
        	}
        }
        return result;
    }

	public @NonNull CollectionValue selectByKind(@NonNull DomainType requiredElementType) throws InvalidValueException {
    	DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
		boolean changedContents = false;
		Collection<Value> newElements = new ArrayList<Value>();
        for (Value element : elements) {
			if (element.isNull()) {
        		changedContents = true;
			}
			else {
				DomainType elementType = element.getType();
				if (elementType.conformsTo(standardLibrary, requiredElementType)) {
	        		newElements.add(element);
	        	}
	        	else {
	        		changedContents = true;
	        	}
			}
        }
        if (changedContents) {
        	DomainCollectionType collectionType = getType();
        	return valueFactory.createCollectionValue(collectionType.isOrdered(), collectionType.isUnique(), newElements);
        }
        else {
        	return this;
        }
	}

	public @NonNull CollectionValue selectByType(@NonNull DomainType requiredElementType) throws InvalidValueException {
    	DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
		boolean changedContents = false;
		Collection<Value> newElements = new ArrayList<Value>();
        for (Value element : elements) {
			DomainType elementType = element.getType();
			if (elementType.isEqualTo(standardLibrary, requiredElementType)) {
        		newElements.add(element);
        	}
        	else {
        		changedContents = true;
        	}
        }
        if (changedContents) {
        	DomainCollectionType collectionType = getType();
        	return valueFactory.createCollectionValue(collectionType.isOrdered(), collectionType.isUnique(), newElements);
        }
        else {
        	return this;
        }
	}

	public @NonNull IntegerValue size() {
		return valueFactory.integerValueOf(intSize());
	}

	public @NonNull Value sum(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull LibraryBinaryOperation binaryOperation, @NonNull Value zero) throws InvalidValueException {
		Value result = zero;
        for (Value element : elements) {
        	if (element != null) {
        		result = binaryOperation.evaluate(evaluator, returnType, result, element);
        	}
        }
        return result;
    }

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		toString(s, 100);
		return s.toString();
	}

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append("{");
		boolean isFirst = true;
		for (Value element : this) {
			if (!isFirst) {
				s.append(",");
			}
			if (s.length() < lengthLimit) {
				element.toString(s, lengthLimit-1);
			}
			else {
				s.append("...");
				break;
			}
			isFirst = false;
		}
		s.append("}");		
	}

    public @NonNull CollectionValue union(@NonNull CollectionValue c) throws InvalidValueException {
    	if (this instanceof SetValue && c instanceof SetValue) {
            return SetValueImpl.union(valueFactory, getSetType(), this, c);
        }
        else if (this instanceof BagValue || c instanceof BagValue) {
            return BagValueImpl.union(valueFactory, getBagType(), this, c);
        }
        else if (this instanceof OrderedSetValue && c instanceof OrderedSetValue) {
            return OrderedSetValueImpl.union(valueFactory, getOrderedSetType(), this, c);
        }
        else if (this instanceof SequenceValue || c instanceof SequenceValue) {
            return SparseSequenceValueImpl.union(valueFactory, getSequenceType(), this, c);
        }
        else {
            return SetValueImpl.union(valueFactory, getSetType(), this, c);
        }
    }
}
