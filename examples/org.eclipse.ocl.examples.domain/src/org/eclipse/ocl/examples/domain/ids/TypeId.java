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
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.ids.impl.OclInvalidTypeIdImpl;
import org.eclipse.ocl.examples.domain.ids.impl.OclVoidTypeIdImpl;


/**
 * A TypeId provides a unique hierarchical for type which may have many 'actual' type variants.
 * <p>
 * For instance 'Boolean' is a well-understood conceptual, but it may have many 'actual' as a result of Complete OCL
 * definitions merging additional features in to the 'actual' type.
 * 
 * @see CollectionTypeId
 * @see LambdaTypeId
 * @see OclInvalidTypeId
 * @see OclVoidTypeId
 * @see PrimitiveTypeId
 * @see TupleTypeId
 */
public interface TypeId extends ElementId
{
	public static final @NonNull String BAG_NAME = "Bag";
	public static final @NonNull String BOOLEAN_NAME = "Boolean";
	public static final @NonNull String CLASS_NAME = "Class";
	public static final @NonNull String COLLECTION_NAME = "Collection";
	public static final @NonNull String COLLECTION_TYPE_NAME = "CollectionType";
	public static final @NonNull String ENUMERATION_NAME = "Enumeration";
	public static final @NonNull String INTEGER_NAME = "Integer";
	public static final @NonNull String LAMBDA_TYPE_NAME = "LambdaType";
	public static final @NonNull String METACLASS_NAME = "Metaclass";
	public static final @NonNull String OCL_ANY_NAME = "OclAny";
	public static final @NonNull String OCL_COMPARABLE_NAME = "OclComparable";
	public static final @NonNull String OCL_INVALID_NAME = "OclInvalid";
	public static final @NonNull String OCL_SUMMABLE_NAME = "OclSummable";
	public static final @NonNull String OCL_VOID_NAME = "OclVoid";
	public static final @NonNull String OPERATION_NAME = "Operation";
	public static final @NonNull String ORDERED_SET_NAME = "OrderedSet";
	public static final @NonNull String PRIMITIVE_TYPE_NAME = "PrimitiveType";
	public static final @NonNull String REAL_NAME = "Real";
	public static final @NonNull String SEQUENCE_NAME = "Sequence";
	public static final @NonNull String SET_NAME = "Set";
	public static final @NonNull String STRING_NAME = "String";
	public static final @NonNull String TUPLE_TYPE_NAME = "TupleType";
	public static final @NonNull String UNIQUE_COLLECTION_NAME = "UniqueCollection";
	public static final @NonNull String UNLIMITED_NATURAL_NAME = "UnlimitedNatural";
	
	public static final @NonNull PrimitiveTypeId BOOLEAN = IdManager.INSTANCE.getPrimitiveTypeId(BOOLEAN_NAME);
	public static final @NonNull PrimitiveTypeId INTEGER = IdManager.INSTANCE.getPrimitiveTypeId(INTEGER_NAME);
	public static final @NonNull PrimitiveTypeId OCL_ANY = IdManager.INSTANCE.getPrimitiveTypeId(OCL_ANY_NAME);
	public static final @NonNull PrimitiveTypeId OCL_COMPARABLE = IdManager.INSTANCE.getPrimitiveTypeId(OCL_COMPARABLE_NAME);
	public static final @NonNull OclInvalidTypeId OCL_INVALID = new OclInvalidTypeIdImpl(OCL_INVALID_NAME);
	public static final @NonNull PrimitiveTypeId OCL_SUMMABLE = IdManager.INSTANCE.getPrimitiveTypeId(OCL_SUMMABLE_NAME);
	public static final @NonNull OclVoidTypeId OCL_VOID = new OclVoidTypeIdImpl(OCL_VOID_NAME);
	public static final @NonNull PrimitiveTypeId REAL = IdManager.INSTANCE.getPrimitiveTypeId(REAL_NAME);
	public static final @NonNull PrimitiveTypeId STRING = IdManager.INSTANCE.getPrimitiveTypeId(STRING_NAME);
	public static final @NonNull PrimitiveTypeId UNLIMITED_NATURAL = IdManager.INSTANCE.getPrimitiveTypeId(UNLIMITED_NATURAL_NAME);

	public static final @NonNull CollectionTypeId BAG = IdManager.INSTANCE.getCollectionTypeId(BAG_NAME);
	public static final @NonNull CollectionTypeId COLLECTION = IdManager.INSTANCE.getCollectionTypeId(COLLECTION_NAME);
	public static final @NonNull CollectionTypeId METACLASS = IdManager.INSTANCE.getCollectionTypeId(METACLASS_NAME);
	public static final @NonNull CollectionTypeId ORDERED_SET = IdManager.INSTANCE.getCollectionTypeId(ORDERED_SET_NAME);
	public static final @NonNull CollectionTypeId SEQUENCE = IdManager.INSTANCE.getCollectionTypeId(SEQUENCE_NAME);
	public static final @NonNull CollectionTypeId SET = IdManager.INSTANCE.getCollectionTypeId(SET_NAME);
	public static final @NonNull CollectionTypeId UNIQUE_COLLECTION = IdManager.INSTANCE.getCollectionTypeId(UNIQUE_COLLECTION_NAME);

	public static final @NonNull TypeTemplateParameterId BAG_T = (TypeTemplateParameterId) BAG.getTemplateParameterId(0);
	public static final @NonNull TypeTemplateParameterId COLLECTION_T = (TypeTemplateParameterId) COLLECTION.getTemplateParameterId(0);
	public static final @NonNull TypeTemplateParameterId METACLASS_T = (TypeTemplateParameterId) METACLASS.getTemplateParameterId(0);
	public static final @NonNull TypeTemplateParameterId ORDERED_SET_T = (TypeTemplateParameterId) ORDERED_SET.getTemplateParameterId(0);
	public static final @NonNull TypeTemplateParameterId SEQUENCE_T = (TypeTemplateParameterId) SEQUENCE.getTemplateParameterId(0);
	public static final @NonNull TypeTemplateParameterId SET_T = (TypeTemplateParameterId) SET.getTemplateParameterId(0);
	public static final @NonNull TypeTemplateParameterId UNIQUE_COLLECTION_T = (TypeTemplateParameterId) UNIQUE_COLLECTION.getTemplateParameterId(0);

	public static final @NonNull String[] NULL_STRING_ARRAY = new String[0];
	public static final @NonNull TuplePartId[] NULL_TUPLE_PART_ID_ARRAY = new TuplePartId[0];	
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
	@NonNull OperationId getOperationId(@NonNull TemplateParameterId[] templateParameters, @NonNull String name, @NonNull DomainParameterTypes parameterTypes);

	/**
	 * Return the typeId for this typeId specialized by typeParameters.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not be specialized.
	 */
//	@NonNull TypeId getSpecializedTypeId(@NonNull DomainTypeParameters typeParameters);

	/**
	 * Return the typeId for the named type parameter of this typeId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have type parameters.
	 */
	@NonNull TemplateParameterId getTemplateParameterId(int index);
	@NonNull TemplateParameterId[] getTemplateParameters();

	@NonNull TypeId specialize(@NonNull TemplateBindings templateBindings);
}