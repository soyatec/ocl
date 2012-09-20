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
 */
package org.eclipse.ocl.examples.domain.values;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;


/**
 * A TypeValue is a value object whose value is a type, such as Boolean. The type of
 * a type value is a classifier such as Classifier&lt;Boolean&gt;. 
 */
public interface TypeValue extends Value
	{
		/**
		 * @throws InvalidValueException 
		 * @generated NOT
		 */
		@NonNull DomainType getInstanceType();//;
	}
