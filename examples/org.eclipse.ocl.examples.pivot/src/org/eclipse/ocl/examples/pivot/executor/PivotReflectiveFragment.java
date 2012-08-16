/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id$
 */
package org.eclipse.ocl.examples.pivot.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.library.executor.ReflectiveFragment;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;

public class PivotReflectiveFragment extends ReflectiveFragment
{
	public PivotReflectiveFragment(@NonNull TypeServer derivedInheritance, @NonNull DomainInheritance baseInheritance) {
		super(derivedInheritance, baseInheritance);
	}

	@Override
	protected @NonNull DomainOperation getOperationOverload(@NonNull DomainOperation baseOperation) {
		Type pivotType = ((TypeServer) derivedInheritance).getPivotType();
		DomainParameterTypes baseParameterTypes = baseOperation.getParameterTypes();
		int iMax = baseParameterTypes.size();
		for (DomainOperation localOperation : pivotType.getOwnedOperation()) {
			if (localOperation.getName().equals(baseOperation.getName())) {
				DomainParameterTypes localParameterTypes = localOperation.getParameterTypes();
				if (iMax == localParameterTypes.size()) {
					int i = 0;
					for (; i < iMax; i++) {
						DomainType localParameterType = localParameterTypes.get(i);
						DomainType baseParameterType = baseParameterTypes.get(i);
						if (!localParameterType.equals(baseParameterType)) {
							break;
						}
					}
					if (i >= iMax) {
						return localOperation;
					}
				}
			}
		}
		return baseOperation;			// Shouldn't ever happen.
	}
}