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
package org.eclipse.ocl.examples.domain.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.impl.OclInvalidTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.OclVoidTypeIdImpl;


/**
 * A TypeId provides a unique hierarchical for type which may have many 'actual' type variants.
 * <p>
 * For instance 'Boolean' is a well-understood conceptual, but it may have many 'actual' as a result of Complete OCL
 * definitions merging additional features in to the 'actual' type.
 * 
 * @see CollectedTypeId
 * @see CollectionTypeId
 * @see LambdaTypeId
 * @see OclInvalidTypeId
 * @see OclVoidTypeId
 * @see PrimitiveTypeId
 * @see SpecializedTypeId
 * @see TupleTypeId
 */
public interface TypeId extends ElementId
{
	public static final @NonNull String CLASS_NAME = "Class";
	public static final @NonNull String COLLECTION_TYPE_NAME = "CollectionType";
	public static final @NonNull String ENUMERATION_NAME = "Enumeration";
	public static final @NonNull String INTEGER_NAME = "Integer";
	public static final @NonNull String LAMBDA_TYPE_NAME = "LambdaType";
	public static final @NonNull String OPERATION_NAME = "Operation";
	public static final @NonNull String PRIMITIVE_TYPE_NAME = "PrimitiveType";
	public static final @NonNull String REAL_NAME = "Real";
	public static final @NonNull String STRING_NAME = "String";
	public static final @NonNull String TUPLE_TYPE_NAME = "TupleType";
	public static final @NonNull String UNLIMITED_NATURAL_NAME = "UnlimitedNatural";
	public static final @NonNull String BOOLEAN_NAME = "Boolean";
	
	public static final @NonNull PrimitiveTypeId BOOLEAN = IdManager.INSTANCE.getPrimitiveTypeId(BOOLEAN_NAME);
	public static final @NonNull PrimitiveTypeId INTEGER = IdManager.INSTANCE.getPrimitiveTypeId(INTEGER_NAME);
	public static final @NonNull PrimitiveTypeId OCL_ANY = IdManager.INSTANCE.getPrimitiveTypeId("OclAny");
	public static final @NonNull PrimitiveTypeId OCL_COMPARABLE = IdManager.INSTANCE.getPrimitiveTypeId("OclComparable");
	public static final @NonNull OclInvalidTypeId OCL_INVALID = new OclInvalidTypeIdImpl("OclInvalid");
	public static final @NonNull PrimitiveTypeId OCL_SUMMABLE = IdManager.INSTANCE.getPrimitiveTypeId("OclSummable");
	public static final @NonNull OclVoidTypeId OCL_VOID = new OclVoidTypeIdImpl("OclVoid");
	public static final @NonNull PrimitiveTypeId REAL = IdManager.INSTANCE.getPrimitiveTypeId(REAL_NAME);
	public static final @NonNull PrimitiveTypeId STRING = IdManager.INSTANCE.getPrimitiveTypeId(STRING_NAME);
	public static final @NonNull PrimitiveTypeId UNLIMITED_NATURAL = IdManager.INSTANCE.getPrimitiveTypeId(UNLIMITED_NATURAL_NAME);

	public static final @NonNull CollectionTypeId BAG = IdManager.INSTANCE.getCollectionTypeId("Bag");
	public static final @NonNull CollectionTypeId COLLECTION = IdManager.INSTANCE.getCollectionTypeId("Collection");
	public static final @NonNull CollectionTypeId METACLASS = IdManager.INSTANCE.getCollectionTypeId("Metaclass");
	public static final @NonNull CollectionTypeId ORDERED_SET = IdManager.INSTANCE.getCollectionTypeId("OrderedSet");
	public static final @NonNull CollectionTypeId SEQUENCE = IdManager.INSTANCE.getCollectionTypeId("Sequence");
	public static final @NonNull CollectionTypeId SET = IdManager.INSTANCE.getCollectionTypeId("Set");
	public static final @NonNull CollectionTypeId UNIQUE_COLLECTION = IdManager.INSTANCE.getCollectionTypeId("UniqueCollection");

	public static final @NonNull TypeTemplateParameterId BAG_T = BAG.getElementTypeId();
	public static final @NonNull TypeTemplateParameterId COLLECTION_T = COLLECTION.getElementTypeId();
	public static final @NonNull TypeTemplateParameterId METACLASS_T = METACLASS.getElementTypeId();
	public static final @NonNull TypeTemplateParameterId ORDERED_SET_T = ORDERED_SET.getElementTypeId();
	public static final @NonNull TypeTemplateParameterId SEQUENCE_T = SEQUENCE.getElementTypeId();
	public static final @NonNull TypeTemplateParameterId SET_T = SET.getElementTypeId();
	public static final @NonNull TypeTemplateParameterId UNIQUE_COLLECTION_T = UNIQUE_COLLECTION.getElementTypeId();

	public static final @NonNull String[] NULL_STRING_ARRAY = new String[0];
	public static final @NonNull TypeId[] NULL_TYPE_ID_ARRAY = new TypeId[0];	
	
	/**
     * Return the typeId for anEnumerationLiteral of this typeId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have enumeration literals.
     */
	@NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull String name);

	@NonNull String getMetaTypeName();

	/**
     * Return the typeId for anOperation of this typeId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have operations.
     */
	@NonNull OperationId getOperationId(@NonNull DomainOperation anOperation);

	/**
	 * Return the typeId for this typeId specialized by typeParameters.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not be specialized.
	 */
	@NonNull TypeId getSpecializedTypeId(@NonNull DomainTypeParameters typeParameters);

	/**
	 * Return the typeId for the named type parameter of this typeId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have type parameters.
	 */
	@NonNull TypeTemplateParameterId getTemplateParameterId(int index);
}