/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
package org.eclipse.ocl.examples.domain.typeids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;

/**
 * A Typeid provides a unique identifier for a 'conceptual' type which may have many 'actual' type variants.
 * <p>
 * For instance 'Boolean' is a well-understood conceptual, but it may have many 'actual' as a result of Complete OCL
 * definitions merging additional features in to the 'actual' type.
 */
public interface Typeid
{
//	public static @NonNull Typeid BAG = TypeidManager.INSTANCE.getCollectionTypeid("Bag");
	public static @NonNull Typeid BOOLEAN = TypeidManager.INSTANCE.getUnscopedTypeid("Boolean");
//	public static @NonNull Typeid COLLECTION = TypeidManager.INSTANCE.getCollectionTypeid("Collection");
	public static @NonNull Typeid INTEGER = TypeidManager.INSTANCE.getUnscopedTypeid("Integer");
	public static @NonNull Typeid OCL_ANY = TypeidManager.INSTANCE.getUnscopedTypeid("OclAny");
	public static @NonNull Typeid OCL_INVALID = TypeidManager.INSTANCE.getUnscopedTypeid("OclInvalid");
	public static @NonNull Typeid OCL_NULL = TypeidManager.INSTANCE.getUnscopedTypeid("OclVoid");
//	public static @NonNull Typeid ORDERED_SET = TypeidManager.INSTANCE.getCollectionTypeid("OrderedSet");
	public static @NonNull Typeid REAL = TypeidManager.INSTANCE.getUnscopedTypeid("Real");
//	public static @NonNull Typeid SEQUENCE = TypeidManager.INSTANCE.getCollectionTypeid("Sequence");
//	public static @NonNull Typeid SET = TypeidManager.INSTANCE.getCollectionTypeid("Set");
	public static @NonNull Typeid STRING = TypeidManager.INSTANCE.getUnscopedTypeid("String");
	public static @NonNull Typeid UNLIMITED_NATURAL = TypeidManager.INSTANCE.getUnscopedTypeid("UnlimitedNatural");
	
	/**
	 * Return the typeid for this collection typeid specialized by elementTypeid.
	 * <p>
	 * Throws UnsupportedException for typeids such as Primitive Types that may not be collected.
	 */
	@NonNull Typeid getCollectedTypeid(@NonNull Typeid elementTypeid);

	/**
	 * Return the typeid for the named child of this typeid.
	 * <p>
	 * Throws UnsupportedException for typeids such as Primitive Types that may not have nested types.
	 */
	@NonNull Typeid getNestedTypeid(@NonNull String name);
 
	/**
     * Return the typeid for anOperation of this typeid.
	 * <p>
	 * Throws UnsupportedException for typeids such as Primitive Types that may not have operations.
     */
	@NonNull Typeid getOperationTypeid(@NonNull DomainOperation anOperation);

	/**
	 * Return the typeid for the named type parameter of this typeid.
	 * <p>
	 * Throws UnsupportedException for typeids such as Primitive Types that may not have type parameters.
	 */
	@NonNull Typeid getParameterTypeid(@NonNull String name);

	/**
	 * Return the typeid for this typeid specialized by typeParameters.
	 * <p>
	 * Throws UnsupportedException for typeids such as Primitive Types that may not be specialized.
	 */
	@NonNull Typeid getSpecializedTypeid(@NonNull DomainTypeParameters typeParameters);
}