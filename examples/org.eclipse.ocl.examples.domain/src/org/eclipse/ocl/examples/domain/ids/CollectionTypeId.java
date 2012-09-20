/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.domain.ids;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A CollectionTypeId provides a unique identifier for an unspecialized collection type such as Set(T).
 */
public interface CollectionTypeId extends BuiltInTypeId, CollectedTypeId
{
	@NonNull CollectionTypeId getCollectedTypeId();
	@NonNull CollectedTypeId getCollectedTypeId(@NonNull TypeId elementTypeId);
	@NonNull TypeTemplateParameterId getElementTypeId();
	@NonNull String getMetaTypeName();
}