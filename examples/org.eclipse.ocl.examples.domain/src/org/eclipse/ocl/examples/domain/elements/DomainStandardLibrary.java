/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: Bag.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.elements;

import java.util.Enumeration;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;

/**
 * A representation of the OCL Standard Library, which is the set of singleton
 * instances of the OCL-defined metatypes, including the generic collection
 * types (e.g., <tt>Set(T)</tt>).
 */
public interface DomainStandardLibrary
{
	boolean conformsToCollectionType(@NonNull DomainCollectionType firstCollectionType, @NonNull DomainCollectionType secondCollectionType);

	boolean conformsToLambdaType(@NonNull DomainLambdaType firstLambdaType, @NonNull DomainLambdaType secondLambdaType);

	boolean conformsToTupleType(@NonNull DomainTupleType firstTupleType, @NonNull DomainTupleType secondTupleType);
	
    /**
     * Obtains the generic instance of the {@link BagType} metatype, named
     * <tt>Bag(T)</tt>.
     * 
     * @return the <tt>Bag(T)</tt> type (an instance of {@link BagType})
     */
	@NonNull DomainType getBagType();

	/**
	 * Return the instance of the Bag metatype whose elements are of elementType.
	 */
	@Deprecated
	@NonNull DomainCollectionType getBagType(@NonNull DomainType elementType);
	@NonNull DomainCollectionType getBagType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper);
	
    /**
     * Obtains the instance of the {@link PrimitiveType} metatype, named
     * <tt>Boolean</tt>.
     * 
     * @return the <tt>Boolean</tt> type (an instance of {@link PrimitiveType})
     */
	@NonNull DomainType getBooleanType();
	
    /**
     * Obtains the generic instance of the {@link CollectionType} metatype, named
     * <tt>Collection(T)</tt>.
     * 
     * @return the <tt>Collection(T)</tt> type (an instance of {@link CollectionType})
     */
	@NonNull DomainType getCollectionType();
	
	/**
	 * Return the specialized collection type for the containerType for elementType.
	 */
	@NonNull DomainCollectionType getCollectionType(@NonNull DomainCollectionType containerType, @NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper);

	/**
	 * Return the enumeration for a given enumerator.
	 */
	DomainEnumeration getEnumeration(@NonNull Enumerator enumerator);
	
    /**
     * Obtains the single instance of the {@link EnumerationType} metatype, named
     * <tt>Enumeration</tt>.
     * 
     * @return the <tt>Enumeration</tt> type (an instance of {@link Enumeration})
     */
	@NonNull DomainType getEnumerationType();

	/**
	 * Return the Inheritance dispatch table for a given type.
	 */
	@NonNull DomainInheritance getInheritance(@NonNull DomainType type);
	
    /**
     * Obtains the instance of the {@link PrimitiveType} metatype, named
     * <tt>Integer</tt>.
     * 
     * @return the <tt>Integer</tt> type (an instance of {@link PrimitiveType})
     */
	@NonNull DomainType getIntegerType();

	/**
	 * Return the instance of the Metaclass metatype whose class is classType.
	 */
	@NonNull DomainMetaclass getMetaclass(@NonNull DomainType classType);
	
    /**
     * Obtains the single instance of the {@link DomainMetaclass} metatype, named
     * <tt>Metaclass</tt>.
     * 
     * @return the <tt>Metaclass</tt> type (an instance of {@link Metaclass})
     */
	@NonNull DomainType getMetaclassType();

    /**
     * Returns the meta-type of a given type.
     */
	DomainType getMetaType(@NonNull DomainType type);
	
    /**
     * Obtains the single instance of the {@link AnyType} metatype, named
     * <tt>OclAny</tt>.
     * 
     * @return the <tt>OclAny</tt> type (an instance of {@link AnyType})
     */
	@NonNull DomainType getOclAnyType();
	
    /**
     * Obtains the single instance of the {@link OclComparable} metatype, named
     * <tt>OclAny</tt>.
     * 
     * @return the <tt>OclAny</tt> type (an instance of {@link Class})
     */
	@NonNull DomainType getOclComparableType();

    /**
     * Obtains the single instance of the {@link Class} metatype, named
     * <tt>OclElement</tt>.
     * 
     * @return the <tt>OclElement</tt> type (an instance of {@link Class})
     */
	@NonNull DomainType getOclElementType();
	
    /**
     * Obtains the single instance of the {@link InvalidType} metatype, named
     * <tt>OclInvalid</tt>.
     * 
     * @return the <tt>OclInvalid</tt> type (an instance of {@link InvalidType})
     */
	@NonNull DomainType getOclInvalidType();
	
    /**
     * Obtains the generic instance of the {@link MessageType} metatype, named
     * <tt>OclMessage</tt>.
     * 
     * @return the <tt>OclMessage</tt> type (an instance of {@link MessageType})
     */
	DomainType getOclMessageType();

    /**
     * Obtains the single instance of the {@link OclSelf} pseudo-metatype, named
     * <tt>OclSelf</tt>.
     * 
     * @return the <tt>OclSelf</tt> type (an instance of {@link SelfType})
     */
	@NonNull DomainType getOclSelfType();
	
    /**
     * Obtains the single instance of the {@link OclSummable} metatype, named
     * <tt>OclAny</tt>.
     * 
     * @return the <tt>OclAny</tt> type (an instance of {@link Class})
     */
	@NonNull DomainType getOclSummableType();
	
    /**
     * Obtains the single instance of the {@link OclTupleType} metatype, named
     * <tt>OclVoid</tt>.
     * 
     * @return the <tt>OclTuple</tt> type (an instance of {@link Class})
     */
	@NonNull DomainType getOclTupleType();
	
	DomainType getOclType(@NonNull String typeName);
	
    /**
     * Obtains the single instance of the {@link VoidType} metatype, named
     * <tt>OclVoid</tt>.
     * 
     * @return the <tt>OclVoid</tt> type (an instance of {@link VoidType})
     */
	@NonNull DomainType getOclVoidType();
	
    /**
     * Obtains the generic instance of the {@link OrderedSetType} metatype, named
     * <tt>OrderedSet(T)</tt>.
     * 
     * @return the <tt>OrderedSet(T)</tt> type (an instance of {@link OrderedSetType})
     */
	@NonNull DomainType getOrderedSetType();

	/**
	 * Return the instance of the OrderedSet metatype whose elements are of elementType.
	 */
	@Deprecated
	@NonNull DomainCollectionType getOrderedSetType(@NonNull DomainType elementType);
	@NonNull DomainCollectionType getOrderedSetType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper);
	
    /**
     * Obtains the instance of the {@link PrimitiveType} metatype, named
     * <tt>Real</tt>.
     * 
     * @return the <tt>Real</tt> type (an instance of {@link PrimitiveType})
     */
	@NonNull DomainType getRealType();
	
    /**
     * Obtains the generic instance of the {@link SequenceType} metatype, named
     * <tt>Sequence(T)</tt>.
     * 
     * @return the <tt>Sequence(T)</tt> type (an instance of {@link SequenceType})
     */
	@NonNull DomainType getSequenceType();

	/**
	 * Return the instance of the Sequence metatype whose elements are of elementType.
	 */
	@Deprecated
	@NonNull DomainCollectionType getSequenceType(@NonNull DomainType elementType);
	@NonNull DomainCollectionType getSequenceType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper);
	
    /**
     * Obtains the generic instance of the {@link SetType} metatype, named
     * <tt>Set(T)</tt>.
     * 
     * @return the <tt>Set(T)</tt> type (an instance of {@link SetType})
     */
	@NonNull DomainType getSetType();

	/**
	 * Return the instance of the Set metatype whose elements are of elementType.
	 */
	@Deprecated
	@NonNull DomainCollectionType getSetType(@NonNull DomainType elementType);
	@NonNull DomainCollectionType getSetType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper);
	
    /**
     * Obtains the instance of the {@link PrimitiveType} metatype, named
     * <tt>String</tt>.
     * 
     * @return the <tt>String</tt> type (an instance of {@link PrimitiveType})
     */
	@NonNull DomainType getStringType();

	/**
	 * Obtains the instance of the tuple part description for a name and a type.
	 */
	@NonNull DomainTypedElement getTuplePart(@NonNull String name, @NonNull DomainType type);

	/**
	 * Obtains the instance of the {@link TupleType} metatype for the given list of parts,
	 * which must be alphabetical order by name.
	 */
	@NonNull DomainTupleType getTupleType(@NonNull List<? extends DomainTypedElement> parts);
	@NonNull DomainTupleType getTupleType(DomainTypedElement... parts);

	@NonNull DomainType getType(@NonNull DomainElement element);
	@NonNull DomainType getType(@NonNull EClassifier eClassifier);
	
    /**
     * Obtains the generic instance of the {@link UniqueCollection} metatype, named
     * <tt>Set(T)</tt>.
     * 
     * @return the <tt>Set(T)</tt> type (an instance of {@link CollectionType})
     */
	@NonNull DomainType getUniqueCollectionType();
   
    /**
     * Obtains the instance of the {@link PrimitiveType} metatype,
     * named <tt>UnlimitedNatural</tt>.
     * 
     * @return the <tt>UnlimitedNatural</tt> type (an instance of
     *     {@link PrimitiveType})
     */
	@NonNull DomainType getUnlimitedNaturalType();

	@NonNull ValueFactory getValueFactory();
	
	boolean isEqualToCollectionType(@NonNull DomainCollectionType firstCollectionType, @NonNull DomainCollectionType secondCollectionType);

	boolean isEqualToTupleType(@NonNull DomainTupleType firstTupleType, @NonNull DomainTupleType secondTupleType);
}
