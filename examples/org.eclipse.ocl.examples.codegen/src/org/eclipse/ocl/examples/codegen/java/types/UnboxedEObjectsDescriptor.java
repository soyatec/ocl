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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;

/**
 * An UnboxedEObjectsDescriptor describes a type for a collection of unboxed representations. It has a pivot CollectionTypeId describing
 * both collection and elements, a Java class name for the elements and an EClassifier for the elements.
 * <br>
 * Note that in EMF, that Java class for all collections is java.util.List.
 * <p>
 * This descriptor is used whenever the Java classes actually exist.
 */
public class UnboxedEObjectsDescriptor extends AbstractCollectionDescriptor implements UnboxedDescriptor
{
	protected final @NonNull EClassifier eClassifier;
	protected final @NonNull Class<?> oldJavaClass;
	
	public UnboxedEObjectsDescriptor(@NonNull CollectionTypeId elementId, @NonNull Class<?> javaClass, @NonNull EClassifier eClassifier) {
		super(elementId, reClass(javaClass));
		this.eClassifier = eClassifier;
		this.oldJavaClass = javaClass;
	}

	@Override
	public void append(@NonNull JavaStream javaStream) {
		javaStream.appendClassReference(List.class, javaClass != oldJavaClass, javaClass);
	}

	@Override
	public void append(@NonNull JavaStream javaStream, boolean reClass) {
		javaStream.appendClassReference(List.class, javaClass != oldJavaClass, reClass ? javaClass : oldJavaClass);
	}

	@Override
	public void appendElement(@NonNull JavaStream javaStream, boolean reClass) {
		javaStream.appendClassReference(reClass ? javaClass : oldJavaClass);
	}

	public final boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor) {
		if (!(typeDescriptor instanceof UnboxedEObjectsDescriptor)) {
			return false;
		}
		return javaClass.isAssignableFrom(typeDescriptor.getJavaClass());
	}

	@Override
	public boolean isAssignableTo(@NonNull Class<?> javaClass) {
		return javaClass.isAssignableFrom(List.class);
	}

	@Override
	public @NonNull String toString() {
		return elementId + " => List<" + javaClass.getName() + ">";
	}
}