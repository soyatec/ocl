/**
 */
package org.eclipse.ocl.examples.domain.values.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.BooleanValue;
import org.eclipse.ocl.examples.domain.values.ClassifierTypeValue;
import org.eclipse.ocl.examples.domain.values.CollectionTypeValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.ElementValue;
import org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue;
import org.eclipse.ocl.examples.domain.values.EnumerationTypeValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.SimpleTypeValue;
import org.eclipse.ocl.examples.domain.values.StringValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValuesFactory;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ValuesPackageImpl extends EPackageImpl implements ValuesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bagValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierTypeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationLiteralValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationTypeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invalidValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedSetValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleTypeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uniqueCollectionValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unlimitedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.examples.domain.values.ValuesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ValuesPackageImpl() {
		super(eNS_URI, ValuesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ValuesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ValuesPackage init() {
		if (isInited) return (ValuesPackage)EPackage.Registry.INSTANCE.getEPackage(ValuesPackage.eNS_URI);

		// Obtain or create and register package
		ValuesPackageImpl theValuesPackage = (ValuesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ValuesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ValuesPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theValuesPackage.createPackageContents();

		// Initialize created meta-data
		theValuesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theValuesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ValuesPackage.eNS_URI, theValuesPackage);
		return theValuesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBagValue() {
		return bagValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanValue() {
		return booleanValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierTypeValue() {
		return classifierTypeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionValue() {
		return collectionValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionTypeValue() {
		return collectionTypeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementValue() {
		return elementValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationLiteralValue() {
		return enumerationLiteralValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationTypeValue() {
		return enumerationTypeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerValue() {
		return integerValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvalidValue() {
		return invalidValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNullValue() {
		return nullValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericValue() {
		return numericValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectValue() {
		return objectValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedSetValue() {
		return orderedSetValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealValue() {
		return realValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceValue() {
		return sequenceValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetValue() {
		return setValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleTypeValue() {
		return simpleTypeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringValue() {
		return stringValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTupleValue() {
		return tupleValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeValue() {
		return typeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUniqueCollectionValue() {
		return uniqueCollectionValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnlimitedValue() {
		return unlimitedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValue() {
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValuesFactory getValuesFactory() {
		return (ValuesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		bagValueEClass = createEClass(BAG_VALUE);

		booleanValueEClass = createEClass(BOOLEAN_VALUE);

		classifierTypeValueEClass = createEClass(CLASSIFIER_TYPE_VALUE);

		collectionValueEClass = createEClass(COLLECTION_VALUE);

		collectionTypeValueEClass = createEClass(COLLECTION_TYPE_VALUE);

		elementValueEClass = createEClass(ELEMENT_VALUE);

		enumerationLiteralValueEClass = createEClass(ENUMERATION_LITERAL_VALUE);

		enumerationTypeValueEClass = createEClass(ENUMERATION_TYPE_VALUE);

		integerValueEClass = createEClass(INTEGER_VALUE);

		invalidValueEClass = createEClass(INVALID_VALUE);

		nullValueEClass = createEClass(NULL_VALUE);

		numericValueEClass = createEClass(NUMERIC_VALUE);

		objectValueEClass = createEClass(OBJECT_VALUE);

		orderedSetValueEClass = createEClass(ORDERED_SET_VALUE);

		realValueEClass = createEClass(REAL_VALUE);

		sequenceValueEClass = createEClass(SEQUENCE_VALUE);

		setValueEClass = createEClass(SET_VALUE);

		simpleTypeValueEClass = createEClass(SIMPLE_TYPE_VALUE);

		stringValueEClass = createEClass(STRING_VALUE);

		tupleValueEClass = createEClass(TUPLE_VALUE);

		typeValueEClass = createEClass(TYPE_VALUE);

		uniqueCollectionValueEClass = createEClass(UNIQUE_COLLECTION_VALUE);

		unlimitedValueEClass = createEClass(UNLIMITED_VALUE);

		valueEClass = createEClass(VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		bagValueEClass.getESuperTypes().add(this.getCollectionValue());
		booleanValueEClass.getESuperTypes().add(this.getValue());
		classifierTypeValueEClass.getESuperTypes().add(this.getTypeValue());
		collectionValueEClass.getESuperTypes().add(this.getValue());
		collectionTypeValueEClass.getESuperTypes().add(this.getTypeValue());
		elementValueEClass.getESuperTypes().add(this.getObjectValue());
		enumerationLiteralValueEClass.getESuperTypes().add(this.getElementValue());
		enumerationTypeValueEClass.getESuperTypes().add(this.getTypeValue());
		integerValueEClass.getESuperTypes().add(this.getNumericValue());
		invalidValueEClass.getESuperTypes().add(this.getNullValue());
		nullValueEClass.getESuperTypes().add(this.getBooleanValue());
		nullValueEClass.getESuperTypes().add(this.getIntegerValue());
		nullValueEClass.getESuperTypes().add(this.getObjectValue());
		nullValueEClass.getESuperTypes().add(this.getOrderedSetValue());
		nullValueEClass.getESuperTypes().add(this.getRealValue());
		nullValueEClass.getESuperTypes().add(this.getSetValue());
		nullValueEClass.getESuperTypes().add(this.getStringValue());
		nullValueEClass.getESuperTypes().add(this.getTypeValue());
		nullValueEClass.getESuperTypes().add(this.getUnlimitedValue());
		numericValueEClass.getESuperTypes().add(this.getValue());
		objectValueEClass.getESuperTypes().add(this.getValue());
		orderedSetValueEClass.getESuperTypes().add(this.getSequenceValue());
		orderedSetValueEClass.getESuperTypes().add(this.getUniqueCollectionValue());
		realValueEClass.getESuperTypes().add(this.getNumericValue());
		sequenceValueEClass.getESuperTypes().add(this.getCollectionValue());
		setValueEClass.getESuperTypes().add(this.getBagValue());
		setValueEClass.getESuperTypes().add(this.getUniqueCollectionValue());
		simpleTypeValueEClass.getESuperTypes().add(this.getTypeValue());
		stringValueEClass.getESuperTypes().add(this.getValue());
		tupleValueEClass.getESuperTypes().add(this.getValue());
		typeValueEClass.getESuperTypes().add(this.getElementValue());
		uniqueCollectionValueEClass.getESuperTypes().add(this.getCollectionValue());
		unlimitedValueEClass.getESuperTypes().add(this.getNumericValue());

		// Initialize classes and features; add operations and parameters
		initEClass(bagValueEClass, BagValue.class, "BagValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanValueEClass, BooleanValue.class, "BooleanValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classifierTypeValueEClass, ClassifierTypeValue.class, "ClassifierTypeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionValueEClass, CollectionValue.class, "CollectionValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionTypeValueEClass, CollectionTypeValue.class, "CollectionTypeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementValueEClass, ElementValue.class, "ElementValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumerationLiteralValueEClass, EnumerationLiteralValue.class, "EnumerationLiteralValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumerationTypeValueEClass, EnumerationTypeValue.class, "EnumerationTypeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerValueEClass, IntegerValue.class, "IntegerValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(invalidValueEClass, InvalidValue.class, "InvalidValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nullValueEClass, NullValue.class, "NullValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numericValueEClass, NumericValue.class, "NumericValue", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectValueEClass, ObjectValue.class, "ObjectValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orderedSetValueEClass, OrderedSetValue.class, "OrderedSetValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(realValueEClass, RealValue.class, "RealValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sequenceValueEClass, SequenceValue.class, "SequenceValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setValueEClass, SetValue.class, "SetValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleTypeValueEClass, SimpleTypeValue.class, "SimpleTypeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringValueEClass, StringValue.class, "StringValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tupleValueEClass, TupleValue.class, "TupleValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeValueEClass, TypeValue.class, "TypeValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uniqueCollectionValueEClass, UniqueCollectionValue.class, "UniqueCollectionValue", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unlimitedValueEClass, UnlimitedValue.class, "UnlimitedValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ValuesPackageImpl
