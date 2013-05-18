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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.java.JavaStream;

/**
 * TypeDescriptor captures the characteristics of a Java type and supports serialization to a javaStream.
 * <p>
 * Derived classes support boxed/unboxed types, static/dynamic Ecore and collections.
 */
public interface TypeDescriptor
{
	/**
	 * Append the declaration of this type to a JavaStream.
	 */
	void append(@NonNull JavaStream javaStream);

	@NonNull String getClassName();

	@Nullable EClassifier getEClassifier();

	/**
	 * Return the basic Java class fpr this descriptor. e.g. List<?> for an unboxed collection.
	 */
	@NonNull Class<?> getJavaClass();

	/**
	 * Return true if an instance described by typeDescriptor may be assigned to an instance described by this.
	 */
	boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor);
}