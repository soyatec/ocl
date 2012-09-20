/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.examples.domain.ids.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.ElementId;

/**
 * A MatchableId supports complex identifiers such as Lambda, Operation and Tuple types for which a secondary key must be matched to
 * resolve one of a list of candidates from a first key..
 */
public interface MatchableId<T> extends ElementId
{
	boolean matches(@NonNull String name, @NonNull T parameters);
}