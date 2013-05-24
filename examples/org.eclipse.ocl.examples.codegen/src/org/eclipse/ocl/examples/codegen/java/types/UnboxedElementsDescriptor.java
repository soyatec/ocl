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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Type;

public class UnboxedElementsDescriptor extends AbstractValueDescriptor implements UnboxedDescriptor
{
	protected final @NonNull DomainStandardLibrary standardLibrary;
	protected final @NonNull Type type;
	
	public UnboxedElementsDescriptor(@NonNull CollectionTypeId elementId, @NonNull DomainStandardLibrary standardLibrary, @NonNull Type type) {
		super(elementId, List.class);
		this.standardLibrary = standardLibrary;
		this.type = type;
	}

	@Override
	public @NonNull String getClassName() {
		return DomainUtil.nonNullModel(type.getName());
	}


	public final boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor) {
		if (!(typeDescriptor instanceof UnboxedElementsDescriptor)) {
			return false;
		}
		Type thatType = ((UnboxedElementsDescriptor)typeDescriptor).type;
		return thatType.conformsTo(standardLibrary, type);
	}

	@Override
	public @NonNull String toString() {
		return elementId + " => List<Object/*" + type.getName() + "*/>";
	}
}