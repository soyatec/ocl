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
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.domain.ids.ElementId;

/**
 * A BoxedValueDescriptor describes a type whose boxed representation differs from its unboxed representation. It has a pivot ElementId and a Java class.
 * <p>
 * Thus an IntegerValue is a TypeId.INTEGER and an org.eclipse.ocl.examples.domain.values.IntegerValue.
 */
public class BoxedValueDescriptor extends AbstractValueDescriptor implements BoxedDescriptor
{
	protected final @NonNull UnboxedDescriptor unboxedDescriptor;
	
	public BoxedValueDescriptor(@NonNull ElementId elementId, @NonNull Class<?> javaClass, @NonNull UnboxedDescriptor unboxedDescriptor) {
		super(elementId, javaClass);
		this.unboxedDescriptor = unboxedDescriptor;
	}

	@Override
	public @NonNull UnboxedDescriptor getUnboxedDescriptor() {
		return unboxedDescriptor;
	}

	@Override
	public final boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor) {
		if (!(typeDescriptor instanceof BoxedDescriptor)) {
			return false;
		}
		return javaClass.isAssignableFrom(typeDescriptor.getJavaClass());
	}
}