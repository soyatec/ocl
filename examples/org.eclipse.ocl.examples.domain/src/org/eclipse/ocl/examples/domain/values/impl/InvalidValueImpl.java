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
 * $Id: InvalidValueImpl.java,v 1.6 2011/05/07 16:41:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluationEnvironment;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectedTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public class InvalidValueImpl extends UndefinedCollectionValueImpl implements InvalidValue
{	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.INVALID_VALUE;
	}

	protected final @NonNull String message;
	protected final @Nullable InvalidValue nestedValue;
	protected final @Nullable Exception exception;
	protected final @Nullable DomainEvaluationEnvironment evaluationEnvironment;
	protected final @Nullable Object context;
	protected final @Nullable DomainExpression expression; 

	public InvalidValueImpl() {
		this("invalid", null);
	}

	public InvalidValueImpl(@NonNull String message) {
		this(message, null);
	}

	public InvalidValueImpl(@NonNull String message, @Nullable Exception exception) {
		this.message = message;
		this.exception = exception;
		this.nestedValue = null;
		this.evaluationEnvironment = null;
		this.context = null;
		this.expression = null;
	}

	public InvalidValueImpl(@NonNull String message,
			@NonNull DomainEvaluationEnvironment evaluationEnvironment, @Nullable Object context, @Nullable DomainExpression expression) {
		this.message = message;
		this.exception = null;
		this.nestedValue = null;
		this.evaluationEnvironment = evaluationEnvironment;
		this.context = context;
		this.expression = expression;
	}

	public InvalidValueImpl(@NonNull String message, @Nullable Exception exception,
			@Nullable DomainEvaluationEnvironment evaluationEnvironment, @Nullable Object context, @Nullable DomainExpression expression) {
		this.message = message;
		this.exception = exception;
		this.nestedValue = null;
		this.evaluationEnvironment = evaluationEnvironment;
		this.context = context;
		this.expression = expression;
	}

	public InvalidValueImpl(@NonNull String message, @Nullable InvalidValue nestedValue,
			@Nullable DomainEvaluationEnvironment evaluationEnvironment, @Nullable Object context, @Nullable DomainExpression expression) {
		this.message = message;
		this.exception = null;
		this.nestedValue = nestedValue;
		this.evaluationEnvironment = evaluationEnvironment;
		this.context = context;
		this.expression = expression;
	}

	@Override
	public @NonNull BagValue asBagValue() {
		throw new InvalidValueException(this);
	}

	@Override
	public @NonNull CollectionValue asCollectionValue() {
		throw new InvalidValueException(this);
	}

	@Override
	public @NonNull Double asDouble() {
		throw new InvalidValueException(this);
	}
	
	public @Nullable Object asEcoreObject() {
		throw new InvalidValueException(this);
	}

	@Override
	public DomainElement asElement() {
		throw new InvalidValueException(this);
	}

	@Override
	public @NonNull Integer asInteger() {
		throw new InvalidValueException(this);
	}

	@Override
	public @NonNull IntegerValue asIntegerValue() {
		throw new InvalidValueException(this);
	}

	@Override
	public @NonNull EObject asNavigableObject() {
		throw new InvalidValueException(this);
	}

	@Override
	public @NonNull ObjectValue asObjectValue() {
		throw new InvalidValueException(this);
	}

	@Override
	public @NonNull OrderedSetValue asOrderedSetValue() {
		throw new InvalidValueException(this);
	}

	@Override
	public @NonNull RealValue asRealValue() {
		throw new InvalidValueException(this);
	}

	@Override
	public @NonNull SequenceValue asSequenceValue() {
		throw new InvalidValueException(this);
	}

	@Override
	public @NonNull SetValue asSetValue() {
		throw new InvalidValueException(this);
	}

	@Override
	public @NonNull UniqueCollectionValue asUniqueCollectionValue() {
		throw new InvalidValueException(this);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof InvalidValue;
	}

	public @NonNull CollectedTypeId getCollectedTypeId() {
		return TypeId.OCL_INVALID;
	}
	
	public @Nullable Exception getException() {
		return exception;
	}
	
	public @NonNull String getMessage() {
		return message;
	}

	public @NonNull DomainType getType(@NonNull DomainStandardLibrary standardLibrary) {
		return standardLibrary.getOclInvalidType();
	}

	public @Nullable Value getValue(@NonNull String partName) {
    	return toInvalidValue();
	}

	public @Nullable Value getValue(@NonNull DomainTypedElement part) {
    	return toInvalidValue();
	}

	public int intValue() {
    	toInvalidValue();		// throws rather than returns
    	return 0;
	}

	@Override
	public int hashCode() {
		return 0x22222222;
	}

	@Override
	public boolean isInvalid() {
		return true;
	}

	@Override
	public String toString() {
//		if (exception != null) {
//			return Value.INVALID_NAME + "<" + exception.getMessage() + ">";
//		}
//		else {
			return Value.INVALID_NAME;
//		}
	}
}
