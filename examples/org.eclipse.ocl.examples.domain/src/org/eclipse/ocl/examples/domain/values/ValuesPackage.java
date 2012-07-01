/**
 */
package org.eclipse.ocl.examples.domain.values;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.domain.values.ValuesFactory
 * @generated
 */
public interface ValuesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "values";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ww.eclipse.org/OCL/Values";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "values";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ValuesPackage eINSTANCE = org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 23;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.CollectionValueImpl <em>Collection Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.CollectionValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getCollectionValue()
	 * @generated
	 */
	int COLLECTION_VALUE = 3;

	/**
	 * The number of structural features of the '<em>Collection Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.BagValueImpl <em>Bag Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.BagValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getBagValue()
	 * @generated
	 */
	int BAG_VALUE = 0;

	/**
	 * The number of structural features of the '<em>Bag Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_VALUE_FEATURE_COUNT = COLLECTION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.BooleanValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getBooleanValue()
	 * @generated
	 */
	int BOOLEAN_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Boolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.ObjectValueImpl <em>Object Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.ObjectValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getObjectValue()
	 * @generated
	 */
	int OBJECT_VALUE = 12;

	/**
	 * The number of structural features of the '<em>Object Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.ElementValueImpl <em>Element Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.ElementValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getElementValue()
	 * @generated
	 */
	int ELEMENT_VALUE = 5;

	/**
	 * The number of structural features of the '<em>Element Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_VALUE_FEATURE_COUNT = OBJECT_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.TypeValueImpl <em>Type Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.TypeValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getTypeValue()
	 * @generated
	 */
	int TYPE_VALUE = 20;

	/**
	 * The number of structural features of the '<em>Type Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_VALUE_FEATURE_COUNT = ELEMENT_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.ClassifierTypeValueImpl <em>Classifier Type Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.ClassifierTypeValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getClassifierTypeValue()
	 * @generated
	 */
	int CLASSIFIER_TYPE_VALUE = 2;

	/**
	 * The number of structural features of the '<em>Classifier Type Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_TYPE_VALUE_FEATURE_COUNT = TYPE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.CollectionTypeValueImpl <em>Collection Type Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.CollectionTypeValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getCollectionTypeValue()
	 * @generated
	 */
	int COLLECTION_TYPE_VALUE = 4;

	/**
	 * The number of structural features of the '<em>Collection Type Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_VALUE_FEATURE_COUNT = TYPE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.EnumerationLiteralValueImpl <em>Enumeration Literal Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.EnumerationLiteralValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getEnumerationLiteralValue()
	 * @generated
	 */
	int ENUMERATION_LITERAL_VALUE = 6;

	/**
	 * The number of structural features of the '<em>Enumeration Literal Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_VALUE_FEATURE_COUNT = ELEMENT_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.EnumerationTypeValueImpl <em>Enumeration Type Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.EnumerationTypeValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getEnumerationTypeValue()
	 * @generated
	 */
	int ENUMERATION_TYPE_VALUE = 7;

	/**
	 * The number of structural features of the '<em>Enumeration Type Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE_VALUE_FEATURE_COUNT = TYPE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.NumericValue <em>Numeric Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.NumericValue
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getNumericValue()
	 * @generated
	 */
	int NUMERIC_VALUE = 11;

	/**
	 * The number of structural features of the '<em>Numeric Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.IntegerValueImpl <em>Integer Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.IntegerValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getIntegerValue()
	 * @generated
	 */
	int INTEGER_VALUE = 8;

	/**
	 * The number of structural features of the '<em>Integer Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_FEATURE_COUNT = NUMERIC_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.NullValueImpl <em>Null Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.NullValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getNullValue()
	 * @generated
	 */
	int NULL_VALUE = 10;

	/**
	 * The number of structural features of the '<em>Null Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_VALUE_FEATURE_COUNT = BOOLEAN_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl <em>Invalid Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getInvalidValue()
	 * @generated
	 */
	int INVALID_VALUE = 9;

	/**
	 * The number of structural features of the '<em>Invalid Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_VALUE_FEATURE_COUNT = NULL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.SequenceValueImpl <em>Sequence Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.SequenceValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getSequenceValue()
	 * @generated
	 */
	int SEQUENCE_VALUE = 15;

	/**
	 * The number of structural features of the '<em>Sequence Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_VALUE_FEATURE_COUNT = COLLECTION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.OrderedSetValueImpl <em>Ordered Set Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.OrderedSetValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getOrderedSetValue()
	 * @generated
	 */
	int ORDERED_SET_VALUE = 13;

	/**
	 * The number of structural features of the '<em>Ordered Set Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_VALUE_FEATURE_COUNT = SEQUENCE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.RealValueImpl <em>Real Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.RealValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getRealValue()
	 * @generated
	 */
	int REAL_VALUE = 14;

	/**
	 * The number of structural features of the '<em>Real Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_FEATURE_COUNT = NUMERIC_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.SetValueImpl <em>Set Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.SetValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getSetValue()
	 * @generated
	 */
	int SET_VALUE = 16;

	/**
	 * The number of structural features of the '<em>Set Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE_FEATURE_COUNT = BAG_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.SimpleTypeValueImpl <em>Simple Type Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.SimpleTypeValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getSimpleTypeValue()
	 * @generated
	 */
	int SIMPLE_TYPE_VALUE = 17;

	/**
	 * The number of structural features of the '<em>Simple Type Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE_VALUE_FEATURE_COUNT = TYPE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.StringValueImpl <em>String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.StringValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getStringValue()
	 * @generated
	 */
	int STRING_VALUE = 18;

	/**
	 * The number of structural features of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.TupleValueImpl <em>Tuple Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.TupleValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getTupleValue()
	 * @generated
	 */
	int TUPLE_VALUE = 19;

	/**
	 * The number of structural features of the '<em>Tuple Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.UniqueCollectionValue <em>Unique Collection Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.UniqueCollectionValue
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getUniqueCollectionValue()
	 * @generated
	 */
	int UNIQUE_COLLECTION_VALUE = 21;

	/**
	 * The number of structural features of the '<em>Unique Collection Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_COLLECTION_VALUE_FEATURE_COUNT = COLLECTION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.values.impl.UnlimitedValueImpl <em>Unlimited Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.values.impl.UnlimitedValueImpl
	 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getUnlimitedValue()
	 * @generated
	 */
	int UNLIMITED_VALUE = 22;

	/**
	 * The number of structural features of the '<em>Unlimited Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_VALUE_FEATURE_COUNT = NUMERIC_VALUE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.BagValue <em>Bag Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.BagValue
	 * @generated
	 */
	EClass getBagValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.BooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.BooleanValue
	 * @generated
	 */
	EClass getBooleanValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.ClassifierTypeValue <em>Classifier Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Type Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.ClassifierTypeValue
	 * @generated
	 */
	EClass getClassifierTypeValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.CollectionValue <em>Collection Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.CollectionValue
	 * @generated
	 */
	EClass getCollectionValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.CollectionTypeValue <em>Collection Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.CollectionTypeValue
	 * @generated
	 */
	EClass getCollectionTypeValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.ElementValue <em>Element Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.ElementValue
	 * @generated
	 */
	EClass getElementValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue <em>Enumeration Literal Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue
	 * @generated
	 */
	EClass getEnumerationLiteralValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.EnumerationTypeValue <em>Enumeration Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Type Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.EnumerationTypeValue
	 * @generated
	 */
	EClass getEnumerationTypeValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.IntegerValue <em>Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.IntegerValue
	 * @generated
	 */
	EClass getIntegerValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.InvalidValue <em>Invalid Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.InvalidValue
	 * @generated
	 */
	EClass getInvalidValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.NullValue <em>Null Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.NullValue
	 * @generated
	 */
	EClass getNullValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.NumericValue <em>Numeric Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.NumericValue
	 * @generated
	 */
	EClass getNumericValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.ObjectValue <em>Object Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.ObjectValue
	 * @generated
	 */
	EClass getObjectValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.OrderedSetValue <em>Ordered Set Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.OrderedSetValue
	 * @generated
	 */
	EClass getOrderedSetValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.RealValue <em>Real Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.RealValue
	 * @generated
	 */
	EClass getRealValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.SequenceValue <em>Sequence Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.SequenceValue
	 * @generated
	 */
	EClass getSequenceValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.SetValue <em>Set Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.SetValue
	 * @generated
	 */
	EClass getSetValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.SimpleTypeValue <em>Simple Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Type Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.SimpleTypeValue
	 * @generated
	 */
	EClass getSimpleTypeValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.StringValue
	 * @generated
	 */
	EClass getStringValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.TupleValue <em>Tuple Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.TupleValue
	 * @generated
	 */
	EClass getTupleValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.TypeValue <em>Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.TypeValue
	 * @generated
	 */
	EClass getTypeValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.UniqueCollectionValue <em>Unique Collection Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unique Collection Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.UniqueCollectionValue
	 * @generated
	 */
	EClass getUniqueCollectionValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.UnlimitedValue <em>Unlimited Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlimited Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.UnlimitedValue
	 * @generated
	 */
	EClass getUnlimitedValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.values.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.domain.values.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ValuesFactory getValuesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.BagValueImpl <em>Bag Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.BagValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getBagValue()
		 * @generated
		 */
		EClass BAG_VALUE = eINSTANCE.getBagValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.BooleanValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getBooleanValue()
		 * @generated
		 */
		EClass BOOLEAN_VALUE = eINSTANCE.getBooleanValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.ClassifierTypeValueImpl <em>Classifier Type Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.ClassifierTypeValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getClassifierTypeValue()
		 * @generated
		 */
		EClass CLASSIFIER_TYPE_VALUE = eINSTANCE.getClassifierTypeValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.CollectionValueImpl <em>Collection Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.CollectionValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getCollectionValue()
		 * @generated
		 */
		EClass COLLECTION_VALUE = eINSTANCE.getCollectionValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.CollectionTypeValueImpl <em>Collection Type Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.CollectionTypeValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getCollectionTypeValue()
		 * @generated
		 */
		EClass COLLECTION_TYPE_VALUE = eINSTANCE.getCollectionTypeValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.ElementValueImpl <em>Element Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.ElementValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getElementValue()
		 * @generated
		 */
		EClass ELEMENT_VALUE = eINSTANCE.getElementValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.EnumerationLiteralValueImpl <em>Enumeration Literal Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.EnumerationLiteralValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getEnumerationLiteralValue()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL_VALUE = eINSTANCE.getEnumerationLiteralValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.EnumerationTypeValueImpl <em>Enumeration Type Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.EnumerationTypeValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getEnumerationTypeValue()
		 * @generated
		 */
		EClass ENUMERATION_TYPE_VALUE = eINSTANCE.getEnumerationTypeValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.IntegerValueImpl <em>Integer Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.IntegerValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getIntegerValue()
		 * @generated
		 */
		EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl <em>Invalid Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getInvalidValue()
		 * @generated
		 */
		EClass INVALID_VALUE = eINSTANCE.getInvalidValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.NullValueImpl <em>Null Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.NullValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getNullValue()
		 * @generated
		 */
		EClass NULL_VALUE = eINSTANCE.getNullValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.NumericValue <em>Numeric Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.NumericValue
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getNumericValue()
		 * @generated
		 */
		EClass NUMERIC_VALUE = eINSTANCE.getNumericValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.ObjectValueImpl <em>Object Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.ObjectValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getObjectValue()
		 * @generated
		 */
		EClass OBJECT_VALUE = eINSTANCE.getObjectValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.OrderedSetValueImpl <em>Ordered Set Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.OrderedSetValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getOrderedSetValue()
		 * @generated
		 */
		EClass ORDERED_SET_VALUE = eINSTANCE.getOrderedSetValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.RealValueImpl <em>Real Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.RealValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getRealValue()
		 * @generated
		 */
		EClass REAL_VALUE = eINSTANCE.getRealValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.SequenceValueImpl <em>Sequence Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.SequenceValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getSequenceValue()
		 * @generated
		 */
		EClass SEQUENCE_VALUE = eINSTANCE.getSequenceValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.SetValueImpl <em>Set Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.SetValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getSetValue()
		 * @generated
		 */
		EClass SET_VALUE = eINSTANCE.getSetValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.SimpleTypeValueImpl <em>Simple Type Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.SimpleTypeValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getSimpleTypeValue()
		 * @generated
		 */
		EClass SIMPLE_TYPE_VALUE = eINSTANCE.getSimpleTypeValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.StringValueImpl <em>String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.StringValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getStringValue()
		 * @generated
		 */
		EClass STRING_VALUE = eINSTANCE.getStringValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.TupleValueImpl <em>Tuple Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.TupleValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getTupleValue()
		 * @generated
		 */
		EClass TUPLE_VALUE = eINSTANCE.getTupleValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.TypeValueImpl <em>Type Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.TypeValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getTypeValue()
		 * @generated
		 */
		EClass TYPE_VALUE = eINSTANCE.getTypeValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.UniqueCollectionValue <em>Unique Collection Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.UniqueCollectionValue
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getUniqueCollectionValue()
		 * @generated
		 */
		EClass UNIQUE_COLLECTION_VALUE = eINSTANCE.getUniqueCollectionValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.UnlimitedValueImpl <em>Unlimited Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.UnlimitedValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getUnlimitedValue()
		 * @generated
		 */
		EClass UNLIMITED_VALUE = eINSTANCE.getUnlimitedValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.values.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValueImpl
		 * @see org.eclipse.ocl.examples.domain.values.impl.ValuesPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

	}

} //ValuesPackage
