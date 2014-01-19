/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.java.types;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.ElementId;

/**
 * An IntegerObjectDescriptor describes the unboxed representations of an OCL Integer.
 */
public class IntegerObjectDescriptor extends RootObjectDescriptor
{
	public IntegerObjectDescriptor(@NonNull ElementId elementId) {
		super(elementId);
	}
}