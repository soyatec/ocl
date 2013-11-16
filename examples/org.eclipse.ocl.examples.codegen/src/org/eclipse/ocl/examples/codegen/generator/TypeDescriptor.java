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
package org.eclipse.ocl.examples.codegen.generator;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.java.types.CollectionDescriptor;

/**
 * TypeDescriptor captures the characteristics of a Java type and supports serialization to a javaStream.
 * <p>
 * Derived classes support boxed/unboxed types, static/dynamic Ecore and collections.
 */
public interface TypeDescriptor
{
	/**
	 * Append the declaration of this type to a JavaStream. e.g. "typename"
	 */
	void append(@NonNull JavaStream js);

	/**
	 * Append the declaration of this type as a cast to a JavaStream. e.g. "(typename)"
	 */
	void appendCast(@NonNull JavaStream js);

	/**
	 * Append an expression term that evaluaties whether (this Typedescriptor and )thisValue is not equal to thatTypeDescriptor and thatName.
	 */
	void appendNotEqualsTerm(@NonNull JavaStream js, @NonNull CGValuedElement thisValue, @NonNull TypeDescriptor thatTypeDescriptor, @NonNull String thatName);

	/**
	 * Return a non-null Collection type descriptor if this type descriptor dedescribes a Collection.
	 * @return
	 */
	@Nullable CollectionDescriptor asCollectionDescriptor();
	
	/**
	 * Return the fully qualified Java class name described by this type. In the case of collection types, this method returns
	 * the class name of the collection elements.
	 */
	@NonNull String getClassName();

	/**
	 * Return the Ecore EClassifier described by this type. In the case of collection types, this method returns
	 * the EClassifier of the collection elements. May return null when no EClssifier available.
	 */
	@Nullable EClassifier getEClassifier();

	/**
	 * Return the basic Java class for this descriptor. e.g. List<?> for an unboxed collection.
	 */
	@NonNull Class<?> getJavaClass();

	/**
	 * Return the basic Java class for this descriptor. e.g. List<?> for an unboxed collection.
	 * Returns null for no Java class known.
	 */
	@Nullable Class<?> hasJavaClass();

	/**
	 * Return true if an instance described by typeDescriptor may be assigned to an instance described by this.
	 */
	boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor);

	/**
	 * Return true if an instance described by this typeDescriptor may be assigned to a javaClass.
	 */
	boolean isAssignableTo(@NonNull Class<?> javaClass);
}