/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.domain.ids;

import org.eclipse.ocl.examples.domain.utilities.IndexableIterable;


/**
 * ParametersId provides a hashable list of operation
 * parameter ids suitable for use when indexing operation overloads.
 */
public interface ParametersId extends IndexableIterable<TypeId>
{
}