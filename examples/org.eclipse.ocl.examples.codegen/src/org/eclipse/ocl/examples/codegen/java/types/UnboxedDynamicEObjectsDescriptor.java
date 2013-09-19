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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;

public class UnboxedDynamicEObjectsDescriptor extends AbstractCollectionDescriptor implements UnboxedDescriptor
{
	protected final @NonNull EClassifier eClassifier;
	
	public UnboxedDynamicEObjectsDescriptor(@NonNull CollectionTypeId elementId, @NonNull EClassifier eClassifier) {
		super(elementId, List.class);
		this.eClassifier = eClassifier;
	}

	@Override
	public void append(@NonNull JavaStream javaStream) {
		javaStream.appendClassReference(javaClass);
	}

	public final boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor) {
		if (!(typeDescriptor instanceof UnboxedDynamicEObjectsDescriptor)) {
			return false;
		}
		EClassifier thatEClassifier = ((UnboxedDynamicEObjectsDescriptor)typeDescriptor).eClassifier;
		if (eClassifier == thatEClassifier) {
			return true;
		}
		if (!(eClassifier instanceof EClass) || !(thatEClassifier instanceof EClass)) {
			return false;
		}
		return ((EClass)eClassifier).isSuperTypeOf((EClass)thatEClassifier);
	}

	@Override
	public @NonNull String toString() {
		return elementId + " => List<Object/*" + eClassifier.getName() + "*/>";
	}
}