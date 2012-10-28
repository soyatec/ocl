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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.OclInvalidTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
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

	protected final @NonNull Exception exception;

//	public InvalidValueImpl() {
//		this("invalid", null);
//	}

	public InvalidValueImpl(@NonNull Exception exception) {
		this.exception = exception;
	}

	@Override
	public @NonNull BagValue asBagValue() {
		throw new InvalidValueException(exception, "asBagValue");
	}

	@Override
	public @NonNull CollectionValue asCollectionValue() {
		throw new InvalidValueException(exception, "asCollectionValue");
	}

	@Override
	public @NonNull Double asDouble() {
		throw new InvalidValueException(exception, "asDouble");
	}
	
	@Override
	public @Nullable Object asEcoreObject() {
		throw new InvalidValueException(exception, "asEcoreObject");
	}

	@Override
	public DomainElement asElement() {
		throw new InvalidValueException(exception, "asElement");
	}

	@Override
	public @NonNull Integer asInteger() {
		throw new InvalidValueException(exception, "asInteger");
	}

	@Override
	public @NonNull IntegerValue asIntegerValue() {
		throw new InvalidValueException(exception, "asIntegerValue");
	}

	@Override
	public @NonNull EObject asNavigableObject() {
		throw new InvalidValueException(exception, "asNavigableObject");
	}

	@Override
	public @NonNull Number asNumber() {
		throw new InvalidValueException(exception, "asNumberValue");
	}

	@Override
	public @NonNull ObjectValue asObjectValue() {
		throw new InvalidValueException(exception, "asObjectValue");
	}

	@Override
	public @NonNull OrderedSetValue asOrderedSetValue() {
		throw new InvalidValueException(exception, "asOrderedSetValue");
	}

	@Override
	public @NonNull RealValue asRealValue() {
		throw new InvalidValueException(exception, "asRealValue");
	}

	@Override
	public @NonNull SequenceValue asSequenceValue() {
		throw new InvalidValueException(exception, "asSequenceValue");
	}

	@Override
	public @NonNull SetValue asSetValue() {
		throw new InvalidValueException(exception, "asSetValue");
	}

	@Override
	public @NonNull UniqueCollectionValue asUniqueCollectionValue() {
		throw new InvalidValueException(exception, "asUniqueCollectionValue");
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof InvalidValue;
	}

	public @NonNull OclInvalidTypeId getCollectionTypeId() {
		return TypeId.OCL_INVALID;
	}
	
	public @NonNull InvalidValueException getException() {
		return exception instanceof InvalidValueException ? (InvalidValueException)exception : new InvalidValueException(exception);
	}
	
	public @Nullable String getMessage() {
		return exception.getMessage();
	}

	public @NonNull DomainType getType(@NonNull DomainStandardLibrary standardLibrary) {
		return standardLibrary.getOclInvalidType();
	}

	public @NonNull OclInvalidTypeId getTypeId() {
		return TypeId.OCL_INVALID;
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
			return exception.getMessage(); //Value.INVALID_NAME;
//		}
	}
}
