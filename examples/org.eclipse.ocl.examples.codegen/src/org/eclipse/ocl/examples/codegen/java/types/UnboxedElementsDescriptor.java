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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * A UnboxedElementsDescriptor describes a collection type for which no Java class may eveer exist. It has a pivot CollectionTypeId, and
 * a stamdardLibrary and the pivot type.
 * <p>
 * Theis descriptor is used in JUnit tests for expressions and when the genModel is unknown.
 */
public class UnboxedElementsDescriptor extends AbstractCollectionDescriptor implements UnboxedDescriptor
{
	protected final @NonNull DomainStandardLibrary standardLibrary;
	protected final @NonNull Type type;
	
	public UnboxedElementsDescriptor(@NonNull CollectionTypeId collectionTypeId, @NonNull DomainStandardLibrary standardLibrary, @NonNull Type type) {
		super(collectionTypeId);
		this.standardLibrary = standardLibrary;
		this.type = type;
	}

	@Override
	public void append(@NonNull JavaStream javaStream) {
		javaStream.appendClassReference(List.class, true, Object.class);
	}

	@Override
	public void appendElement(@NonNull JavaStream javaStream, boolean reClass) {
		javaStream.appendClassReference(getJavaClass());
	}

	@Override
	public @NonNull String getClassName() {
		return DomainUtil.nonNullModel(type.getName());
	}

	@Override
	@NonNull
	public Class<?> getJavaClass() {
		return Object.class;
	}

	@Override
	public @NonNull UnboxedDescriptor getUnboxedDescriptor() {
		return this;
	}

	@Override
	@Nullable
	public Class<?> hasJavaClass() {
		return null;
	}

	@Override
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