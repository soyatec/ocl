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
 * $Id: Value.java,v 1.6 2011/05/07 16:41:16 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values;


import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;

/**
 * asXXX returns an XXX if self is an XXX and not Null (and is not Invalid),
 * Null (and Invalid) throw an InvalidValueException.
 * 
 * isXXX returns an XXX-related value if self is an XXX and is not Null (and is not Invalid).
 * 
 * toXXX returns an XXX if self is or can be converted to an XXX; Invalid otherwise.
 */
public interface Value
{	
	/**
	 * @generated NOT
	 */
	public static final String INVALID_NAME = "invalid";

	/**
	 * @generated NOT
	 */
	BagValue asBagValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	boolean asBoolean() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	BooleanValue asBooleanValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	CollectionValue asCollectionValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	Double asDouble() throws InvalidValueException;
	
	/**
	 * Return the Ecore representation of this value.
	 * @generated NOT
	 */
	Object asEcoreObject();


	/**
	 * @generated NOT
	 */
	DomainElement asElement(); 

	/**
	 * @generated NOT
	 */
	ElementValue asElementValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	Integer asInteger() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	IntegerValue asIntegerValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	EObject asNavigableObject() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	Object asObject();

	/**
	 * @generated NOT
	 */
	ObjectValue asObjectValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	OrderedSetValue asOrderedSetValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	RealValue asRealValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	SequenceValue asSequenceValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	SetValue asSetValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	String asString() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	StringValue asStringValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	TypeValue asTypeValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	UniqueCollectionValue asUniqueCollectionValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	Value asValidValue() throws InvalidValueException;
	
	/**
	 * Return the type of this value determined from its content. In the case of collections
	 * this may differ from the constructed type. The actual type is used for validating
	 * oclAsType conversions.
	 * @generated NOT
	 */
	DomainType getActualType();

	/**
	 * 
	 * Return the type of this value determined from its construction context. In the case of collections
	 * this may differ from the actual type.
	 * @generated NOT
	 */
	DomainType getType();

	/**
	 * @generated NOT
	 */
	ValueFactory getValueFactory();	

	/**
	 * @generated NOT
	 */
	CollectionValue isCollectionValue();

	/**
	 * @generated NOT
	 */
	boolean isFalse();

	/**
	 * @generated NOT
	 */
	IntegerValue isIntegerValue();

	/**
	 * @generated NOT
	 */
	boolean isInvalid();

	/**
	 * @generated NOT
	 */
	boolean isNull();

	/**
	 * @generated NOT
	 */
	RealValue isRealValue();

	/**
	 * @generated NOT
	 */
	boolean isTrue();

	/**
	 * @generated NOT
	 */
	boolean isUndefined();

	/**
	 * @generated NOT
	 */
	boolean isUnlimited();

	/**
	 * @generated NOT
	 */
	boolean isUnlimitedNatural();

	/**
	 * @generated NOT
	 */
	String oclToString();

	/**
	 * @generated NOT
	 */
	IntegerValue toIntegerValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	Iterator<Value> toIteratorValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	RealValue toRealValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	void toString(StringBuilder s, int sizeLimit);
}
