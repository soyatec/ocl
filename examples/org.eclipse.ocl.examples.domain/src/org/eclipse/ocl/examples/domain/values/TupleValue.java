/**
 * <copyright>
 *
 * Copyright (c) 2006,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TupleValue.java,v 1.3 2011/02/11 20:00:29 ewillink Exp $
 */

package org.eclipse.ocl.examples.domain.values;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

/**
 * Interface of a tuple instance value.  OCL expressions resulting in tuples
 * yield instances of this interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface TupleValue extends Value {
    /**
     * Obtains the tuple's type.
     * 
     * @return its type
	 * @generated NOT
     */
//	@NonNull DomainType getType();
	@NonNull TupleTypeId getTypeId();
	
    /**
     * Queries the value of the specified tuple part.
     * 
     * @param partName the name of the part
     * @return the corresponding value
     * @throws InvalidValueException 
	 * @generated NOT
     */
//	@Nullable Object getValue(@NonNull String partName);
    
    /**
     * Queries the value of the specified tuple part.
     * 
     * @param part the tuple part (as an attribute)
     * @return the corresponding value
     * @throws InvalidValueException 
	 * @generated NOT
     */
	@NonNull Object getValue(@NonNull TuplePartId partId);
    
    /**
     * Queries the value of the specified tuple part at 0-based index corresponding to the position of the
     * required part-name in the alphabetically sorted list of all part-names.
     */
	@NonNull Object getValue(int index);
}
