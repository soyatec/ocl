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
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectedTypeId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
//import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;

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

	private final @NonNull CollectedTypeId typeId;
	protected final @NonNull Collection<? extends Object> elements;		// Using Value instances where necessary to ensure correct equals semantics
	
	protected CollectionValueImpl(@NonNull CollectedTypeId typeId, @NonNull Collection<? extends Object> values) {
		this.typeId = typeId;
		this.elements = values;
		assert checkElementsAreValues(values);
	}
	
	private boolean checkElementsAreValues(Iterable<? extends Object> elements) {
		for (Object element : elements) {
			assert element != null;
			assert !(element instanceof Number);
			assert !(element instanceof DomainEnumerationLiteral);
			assert !(element instanceof DomainType);
			assert !(element instanceof EEnumLiteral);
			if (element instanceof Collection<?>) {
				assert checkElementsAreValues((Iterable<?>)element);
			}
		}
		return true;
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
        return createBagValue(getBagTypeId(), elements);
    }

	public @NonNull Collection<? extends Object> asCollection() {
		return elements;
	}

	@Override
	public @NonNull CollectionValue asCollectionValue() {
		return this;
	}
	
	@Override
	public @Nullable Object asEcoreObject() {
		List<Object> ecoreResult = new BasicEList<Object>(intSize());
		for (Object elementValue : iterable()) {
			if (elementValue instanceof Value)
				ecoreResult.add(((Value)elementValue).asEcoreObject());
			else {
				ecoreResult.add(elementValue);
			}
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
        return createOrderedSetValue(getOrderedSetTypeId(), elements);
    }

    @Override
    public @NonNull SequenceValue asSequenceValue() {
        return createSequenceValue(getSequenceTypeId(), elements);
    }

    @Override
    public @NonNull SetValue asSetValue() {
        return createSetValue(getSetTypeId(), elements);
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
    public @NonNull IntegerValue count(@NonNull Object value) {
        long count = 0;
        for (Object next : elements) {
            if (next.equals(value)) {
                count++;
            }
        } 
	    return ValuesUtil.integerValueOf(count);
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
            	return false;
            }
        } 
        return true;
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
	            	return false;
	            }
	        } 
        } 
        return true;
    }

    /**
     * Returns true if any element flattened.
     * @throws InvalidValueException 
     */
	public boolean flatten(@NonNull Collection<Object> flattenedElements) {
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

/*	@Override
	public @NonNull DomainType getActualType(@NonNull DomainStandardLibrary standardLibrary) {
		DomainType actualType2 = actualType;
		if (actualType2 == null) {
			DomainType elementType = null;
			for (Object value : elements) {
				assert value != null;
				DomainType valueType;
				if (value instanceof Value) {
					valueType = ((Value)value).getActualType(standardLibrary);
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
	} */

	public @NonNull CollectedTypeId getBagTypeId() {
		return TypeId.BAG.getCollectedTypeId(getElementTypeId());
	}

//	public @NonNull CollectedTypeId getCollectionTypeId() {
//		return TypeId.COLLECTION.getCollectedTypeId(getElementType().getTypeId());
//	}

	public @NonNull CollectedTypeId getCollectedTypeId() {
		CollectedTypeId typeId2 = typeId;
//		if (typeId2 == null) {
//			typeId2 = getCollectionTypeId().getCollectedTypeId(getElementTypeId());
//		}
		return typeId2;
	}

	public @NonNull CollectionTypeId getCollectionTypeId() {
		return TypeId.COLLECTION;
	}

	public @NonNull TypeId getElementTypeId() {
//    	DomainType elementType = standardLibrary.getOclVoidType();
//    	for (Object value : values) {
//    		assert value != null;
//    		elementType = elementType.getCommonType(standardLibrary, standardLibrary.typeOf(value));
//    	}
//		for (Value element : iterable()) {
//			
//		}
		
		return getCollectedTypeId().getElementTypeId();
	}

	protected @NonNull Collection<? extends Object> getElements() {
		return elements;
	}

	public @NonNull Collection<? extends Object> getObject() {
		return elements;
	}

	public @NonNull CollectedTypeId getOrderedSetTypeId() {
		return TypeId.ORDERED_SET.getCollectedTypeId(getElementTypeId());
	}

	public @NonNull CollectedTypeId getSequenceTypeId() {
		return TypeId.SEQUENCE.getCollectedTypeId(getElementTypeId());
	}

	public @NonNull CollectedTypeId getSetTypeId() {
		return TypeId.SET.getCollectedTypeId(getElementTypeId());
	}

	public @NonNull CollectedTypeId getTypeId() {
		return getCollectedTypeId();
	}

	@Override
	public int hashCode() {
		return elements.hashCode();
	}

    public @NonNull Object includes(@NonNull Object value) {
		return elements.contains(value) != false;			// FIXME redundant test to suppress warning
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
        		return false;
        	}
        } 
        return true;
    }

	public int intSize() {
		return elements.size();
	}

	public @NonNull CollectionValue intersection(@NonNull CollectionValue c) {
		if (this instanceof OrderedSetValue) {
            return OrderedSetValueImpl.intersection(getOrderedSetTypeId(), this, c);
        }
        else if (this instanceof SequenceValue && c instanceof UniqueCollectionValue) {
            return OrderedSetValueImpl.intersection(getOrderedSetTypeId(), this, c);
        }
        else if (this instanceof UniqueCollectionValue || c instanceof UniqueCollectionValue) {
            return SetValueImpl.intersection(getSetTypeId(), this, c);
        }
        else {
            return BagValueImpl.intersection(getBagTypeId(), this, c);
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

	public @NonNull Object notEmpty() {
		return intSize() != 0;
	}

    public @NonNull Set<TupleValue> product(@NonNull CollectionValue c, @NonNull TupleTypeId tupleTypeId) {   	
    	Set<TupleValue> result = new HashSet<TupleValue>();		
        for (Object next1 : iterable()) {
        	if (next1 != null) {
         		for (Object next2 : c.iterable()) {
    				if (next2 != null) {
    					assert next1 != null;
    					result.add(new TupleValueImpl(tupleTypeId, next1, next2));
    				}
        		}
        	}
        }
        return result;
    }

	public @NonNull IntegerValue size() {
		return ValuesUtil.integerValueOf(intSize());
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

    public @NonNull CollectionValue union(@NonNull CollectionValue c) {
    	if (this instanceof SetValue && c instanceof SetValue) {
            return SetValueImpl.union(getSetTypeId(), this, c);
        }
        else if (this instanceof BagValue || c instanceof BagValue) {
            return BagValueImpl.union(getBagTypeId(), this, c);
        }
        else if (this instanceof OrderedSetValue && c instanceof OrderedSetValue) {
            return OrderedSetValueImpl.union(getOrderedSetTypeId(), this, c);
        }
        else if (this instanceof SequenceValue || c instanceof SequenceValue) {
            return SparseSequenceValueImpl.union(getSequenceTypeId(), this, c);
        }
        else {
            return SetValueImpl.union(getSetTypeId(), this, c);
        }
    }
}
