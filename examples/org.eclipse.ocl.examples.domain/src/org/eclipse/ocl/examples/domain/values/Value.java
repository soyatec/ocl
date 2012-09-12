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


import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;

/**
 * asXXX returns a non-null XXX if self is convertible to an XXX and is not NullValue/InvalidValue
 * throws an InvalidValueException for a NullValue/InvalidValue. A Value object may be converted
 * if the conversion to XXX is exact and type conformant.
 * 
 * isXXX returns an XXX-related value if self is an XXX and is not a NullValue/InvalidValue, returns null otherwise.
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
	@NonNull BagValue asBagValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue asCollectionValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull Double asDouble() throws InvalidValueException;
	
	/**
	 * Return the Ecore representation of this value.
	 * @generated NOT
	 */
	Object asEcoreObject() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	DomainElement asElement(); 

	/**
	 * @generated NOT
	 */
	@NonNull Integer asInteger() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue asIntegerValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull EObject asNavigableObject() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull Object asObject() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull ObjectValue asObjectValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull OrderedSetValue asOrderedSetValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull RealValue asRealValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull SequenceValue asSequenceValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull SetValue asSetValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull TupleValue asTupleValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull UniqueCollectionValue asUniqueCollectionValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull Value asUnlimitedNaturalValue() throws InvalidValueException;

	/**
	 * @generated NOT
	 */
	@NonNull Value asValidValue() throws InvalidValueException;
	
	/**
	 * Return the type of this value determined from its content. In the case of collections
	 * this may differ from the constructed type. The actual type is used for validating
	 * oclAsType conversions.
	 * @throws InvalidValueException 
	 * @generated NOT
	 */
	@NonNull DomainType getActualType() throws InvalidValueException;

	/**
	 * 
	 * Return the type of this value determined from its construction context. In the case of collections
	 * this may differ from the actual type.
	 * @generated NOT
	 */
	@NonNull DomainType getType();

	/**
	 * @generated NOT
	 */
	@NonNull ValueFactory getValueFactory();	

	/**
	 * @generated NOT
	 */
	boolean isInvalid();

	/**
	 * @generated NOT
	 */
	boolean isUndefined();

	/**
	 * @generated NOT
	 */
	void toString(@NonNull StringBuilder s, int sizeLimit);
}
