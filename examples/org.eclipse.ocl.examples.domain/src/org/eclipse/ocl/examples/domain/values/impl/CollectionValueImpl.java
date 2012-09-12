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
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

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
	protected final @NonNull Collection<? extends Object> elements;		// For datatypes each element is a Value, for objects each element is an Object
	private DomainType actualType = null;			// Lazily computed
	
	protected CollectionValueImpl(@NonNull ValueFactory valueFactory, @NonNull DomainCollectionType type, @NonNull Collection<? extends Object> elements) {
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

	public @NonNull Collection<? extends Object> asCollection() {
		return elements;
	}

	@Override
	public @NonNull CollectionValue asCollectionValue() {
		return this;
	}

	@Override
	public @NonNull Object asEcoreObject() throws InvalidValueException {
		List<Object> ecoreResult = new BasicEList<Object>(intSize());
		for (Object elementValue : elements) {
			ecoreResult.add(ValuesUtil.asEcoreObject(elementValue));
		}
		return ecoreResult;
	}

	public @NonNull List<? extends Object> asList() {
		return new ArrayList<Object>(elements);
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
    public @NonNull IntegerValue count(@NonNull Object value) throws InvalidValueException {
        long count = 0;
        for (Object next : elements) {
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
    public @NonNull Object excludes(@NonNull Object value) {
        for (Object next : elements) {
            if (next.equals(value)) {
            	return Boolean.FALSE;
            }
        } 
        return Boolean.TRUE;
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
    public @NonNull Object excludesAll(@NonNull CollectionValue c) {
        for (Object e1 : elements) {
	        for (Object e2 : c.iterable()) {
	            if (e1.equals(e2)) {
	            	return Boolean.FALSE;
	            }
	        } 
        } 
        return Boolean.TRUE;
    }

    /**
     * Returns true if any element flattened.
     * @throws InvalidValueException 
     */
	public boolean flatten(@NonNull Collection<Object> flattenedElements) throws InvalidValueException {
		boolean flattened = false;
		for (Object element : elements) {
			CollectionValue collectionElement = ValuesUtil.isCollectionValue(element);
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
	public @NonNull DomainType getActualType() throws InvalidValueException {
		DomainType actualType2 = actualType;
		if (actualType2 == null) {
			DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			DomainType elementType = null;
			for (Object value : elements) {
				assert value != null;
				DomainType valueType;
				if (value instanceof Value) {
					valueType = ((Value)value).getActualType();
				}
				else {
					valueType = valueFactory.typeOf(value);
				}
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
		return valueFactory.getStandardLibrary().getBagType(getElementType(), null, null);
	}

	public @NonNull DomainCollectionType getCollectionType() {
		return (DomainCollectionType) getType();
	}

	protected @NonNull DomainType getElementType() {
		return DomainUtil.nonNullModel(getCollectionType().getElementType());
	}

	protected @NonNull Collection<? extends Object> getElements() {
		return elements;
	}

	public @NonNull Collection<? extends Object> getObject() {
		return elements;
	}

	public @NonNull DomainCollectionType getOrderedSetType() {
		return valueFactory.getStandardLibrary().getOrderedSetType(getElementType(), null, null);
	}

	public @NonNull DomainCollectionType getSequenceType() {
		return valueFactory.getStandardLibrary().getSequenceType(getElementType(), null, null);
	}

	public @NonNull DomainCollectionType getSetType() {
		return valueFactory.getStandardLibrary().getSetType(getElementType(), null, null);
	}

	public @NonNull DomainCollectionType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return elements.hashCode();
	}

    public @NonNull Object includes(@NonNull Object value) {
		return elements.contains(value);
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
    public @NonNull Object includesAll(@NonNull CollectionValue c) {
        for (Object e1 : c.iterable()) {
        	boolean gotIt = false;
	        for (Object e2 : elements) {
	            if (e1.equals(e2)) {
	            	gotIt = true;
	            	break;
	            }
	        } 
        	if (!gotIt) {
        		return Boolean.FALSE;
        	}
        } 
        return Boolean.TRUE;
    }

	public int intSize() {
		return elements.size();
	}

	public @NonNull CollectionValue intersection(@NonNull CollectionValue c) throws InvalidValueException {
		DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
		if (this instanceof OrderedSetValue) {
            return OrderedSetValueImpl.intersection(valueFactory, standardLibrary.getOrderedSetType(getElementType(), null, null), this, c);
        }
        else if (this instanceof SequenceValue && c instanceof UniqueCollectionValue) {
            return OrderedSetValueImpl.intersection(valueFactory, standardLibrary.getOrderedSetType(getElementType(), null, null), this, c);
        }
        else if (this instanceof UniqueCollectionValue || c instanceof UniqueCollectionValue) {
            return SetValueImpl.intersection(valueFactory, standardLibrary.getSetType(getElementType(), null, null), this, c);
        }
        else {
            return BagValueImpl.intersection(valueFactory, standardLibrary.getBagType(getElementType(), null, null), this, c);
        }
	}

//	@Override
//	public @NonNull CollectionValue isCollectionValue() {
//		return this;
//	}

	public @NonNull Object isEmpty() {
		return intSize() == 0;
	}

	public @NonNull Iterable<? extends Object> iterable() {
		return elements;
	}

	public @NonNull Iterator<? extends Object> iterator() {
		@SuppressWarnings("null") @NonNull Iterator<? extends Object> result = elements.iterator();
		return result;
	}

	public @NonNull Object maxMin(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull LibraryBinaryOperation binaryOperation) throws InvalidValueException {
		Object result = null;
        for (Object element : elements) {
        	if (result == null) {
        		result = element;
        	}
        	else if (element != null) {
        		result = binaryOperation.evaluate(evaluator, returnType, result, element);
        		if (ValuesUtil.isUndefined(result)) {
                	valueFactory.throwInvalidValueException(EvaluatorMessages.UndefinedResult, "max/min");
        		}
        	}
        }
		if (result == null) {
        	return valueFactory.throwInvalidValueException(EvaluatorMessages.EmptyCollection, getKind(), "max/min");
		}
		return result;
    }

	public @NonNull Object notEmpty() {
		return intSize() != 0;
	}

    public @NonNull Set<TupleValue> product(@NonNull CollectionValue c, @NonNull DomainTupleType tupleType) {   	
		ValueFactory nonNullValueFactory = valueFactory;
    	Set<TupleValue> result = new HashSet<TupleValue>();		
        for (Object next1 : iterable()) {
        	if (next1 != null) {
         		for (Object next2 : c.iterable()) {
    				if (next2 != null) {
    					assert next1 != null;
    					result.add(new TupleValueImpl(nonNullValueFactory, tupleType, next1, next2));
    				}
        		}
        	}
        }
        return result;
    }

	public @NonNull CollectionValue selectByKind(@NonNull DomainType requiredElementType) throws InvalidValueException {
    	DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
		boolean changedContents = false;
		Collection<Object> newElements = new ArrayList<Object>();
        for (Object element : elements) {
        	assert element != null;
			if (ValuesUtil.isNull(element)) {
        		changedContents = true;
			}
			else {
				DomainType elementType = valueFactory.typeOf(element);
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
		Collection<Object> newElements = new ArrayList<Object>();
        for (Object element : elements) {
        	assert element != null;
			DomainType elementType = valueFactory.typeOf(element);
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

	public @NonNull Object sum(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull LibraryBinaryOperation binaryOperation, @NonNull Object zero) throws InvalidValueException {
		Object result = zero;
        for (Object element : elements) {
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
		for (Object element : this.iterable()) {
			if (!isFirst) {
				s.append(",");
			}
			if (s.length() < lengthLimit) {
				ValuesUtil.toString(element, s, lengthLimit-1);
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
