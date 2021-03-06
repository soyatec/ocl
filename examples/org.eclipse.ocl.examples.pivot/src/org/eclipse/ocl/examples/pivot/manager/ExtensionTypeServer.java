/**
 * <copyright>
 *
 * Copyright (c) 2011,2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.pivot.manager;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * An ExtensionTypeServer supports the type for the extension of a class by a stereotype application.
 */
public class ExtensionTypeServer extends ExtensibleTypeServer
{
	public ExtensionTypeServer(@NonNull PackageServer packageServer, @NonNull ElementExtension pivotType) {
		super(packageServer, pivotType);
	}

	@Override
	protected @NonNull Map<String, PartialProperties> initMemberProperties() {
		Type pivotType = getPivotType();
		if (pivotType instanceof ElementExtension) {
			Type containingType = PivotUtil.getContainingType(((ElementExtension)pivotType).getBase());
			if (containingType != null) {
				TypeServer typeServer = packageServer.getTypeServer(containingType);
				if (typeServer instanceof AbstractTypeServer) {
					((AbstractTypeServer)typeServer).initMemberProperties();
				}
			}
		}
		return super.initMemberProperties();
	}
}
