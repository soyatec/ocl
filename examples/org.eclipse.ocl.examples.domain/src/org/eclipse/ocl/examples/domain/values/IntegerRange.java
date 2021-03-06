/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
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
 * $Id: IntegerRangeImpl.java,v 1.1 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.values;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A range of integer values from the first up to and including the last.
 * If last is less than the first. the range is empty.
 */
public interface IntegerRange extends List<Value>
{
	@NonNull IntegerValue getFirst();
	@NonNull IntegerValue getLast();
	@NonNull IntegerValue getSize();	
//	@NonNull ValueFactory getValueFactory();
	@NonNull Iterator<Value> iterator();
}