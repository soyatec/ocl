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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;

/**
 * An EObjectsDescriptor describes a type for a collection of (unboxed) EObject representations. It has a pivot CollectionTypeId describing
 * both collection and elements, a Java class name for the elements and an EClassifier for the elements.
 * <br>
 * Note that in EMF, that Java class for all collections is java.util.List.
 * <p>
 * This descriptor is used whenever the Java classes actually exist.
 */
public class EObjectsDescriptor extends AbstractCollectionDescriptor implements UnboxedDescriptor
{
	protected final @NonNull EClassifier eClassifier;
	protected final @NonNull Class<?> javaClass;
	protected final @NonNull Class<?> oldJavaClass;
	
	public EObjectsDescriptor(@NonNull CollectionTypeId collectionTypeId, @NonNull EClassifier eClassifier, @NonNull Class<?> javaClass) {
		super(collectionTypeId);
		this.eClassifier = eClassifier;
		this.javaClass = javaClass;
		this.oldJavaClass = reClass(javaClass);
	}

	public void append(@NonNull JavaStream javaStream) {
		javaStream.appendClassReference(List.class, javaClass != oldJavaClass, oldJavaClass);
	}

	@Override
	public void append(@NonNull JavaStream javaStream, boolean reClass) {
		javaStream.appendClassReference(List.class, javaClass != oldJavaClass, reClass ? javaClass : oldJavaClass);
	}

	@Override
	public void appendElement(@NonNull JavaStream javaStream, boolean reClass) {
		javaStream.appendClassReference(reClass ? javaClass : oldJavaClass);
	}

	@SuppressWarnings("null")
	public @NonNull String getClassName() {
		return javaClass.getName();
	}

	public @NonNull Class<?> getJavaClass() {
		return javaClass;
	}

	public @Nullable Class<?> hasJavaClass() {
		return javaClass;
	}

	public final boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor) {
		if (!(typeDescriptor instanceof EObjectsDescriptor)) {
			return false;
		}
		return javaClass.isAssignableFrom(typeDescriptor.getJavaClass());
	}
}