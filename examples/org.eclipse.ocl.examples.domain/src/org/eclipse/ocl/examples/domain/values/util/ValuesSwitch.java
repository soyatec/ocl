/**
 */
package org.eclipse.ocl.examples.domain.values.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.ocl.examples.domain.values.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.domain.values.ValuesPackage
 * @generated
 */
public class ValuesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ValuesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValuesSwitch() {
		if (modelPackage == null) {
			modelPackage = ValuesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ValuesPackage.BAG_VALUE: {
				BagValue bagValue = (BagValue)theEObject;
				T result = caseBagValue(bagValue);
				if (result == null) result = caseCollectionValue(bagValue);
				if (result == null) result = caseValue(bagValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.BOOLEAN_VALUE: {
				BooleanValue booleanValue = (BooleanValue)theEObject;
				T result = caseBooleanValue(booleanValue);
				if (result == null) result = caseValue(booleanValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.COLLECTION_VALUE: {
				CollectionValue collectionValue = (CollectionValue)theEObject;
				T result = caseCollectionValue(collectionValue);
				if (result == null) result = caseValue(collectionValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.COLLECTION_TYPE_VALUE: {
				CollectionTypeValue collectionTypeValue = (CollectionTypeValue)theEObject;
				T result = caseCollectionTypeValue(collectionTypeValue);
				if (result == null) result = caseTypeValue(collectionTypeValue);
				if (result == null) result = caseElementValue(collectionTypeValue);
				if (result == null) result = caseObjectValue(collectionTypeValue);
				if (result == null) result = caseValue(collectionTypeValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.ELEMENT_VALUE: {
				ElementValue elementValue = (ElementValue)theEObject;
				T result = caseElementValue(elementValue);
				if (result == null) result = caseObjectValue(elementValue);
				if (result == null) result = caseValue(elementValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.ENUMERATION_LITERAL_VALUE: {
				EnumerationLiteralValue enumerationLiteralValue = (EnumerationLiteralValue)theEObject;
				T result = caseEnumerationLiteralValue(enumerationLiteralValue);
				if (result == null) result = caseElementValue(enumerationLiteralValue);
				if (result == null) result = caseObjectValue(enumerationLiteralValue);
				if (result == null) result = caseValue(enumerationLiteralValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.ENUMERATION_TYPE_VALUE: {
				EnumerationTypeValue enumerationTypeValue = (EnumerationTypeValue)theEObject;
				T result = caseEnumerationTypeValue(enumerationTypeValue);
				if (result == null) result = caseTypeValue(enumerationTypeValue);
				if (result == null) result = caseElementValue(enumerationTypeValue);
				if (result == null) result = caseObjectValue(enumerationTypeValue);
				if (result == null) result = caseValue(enumerationTypeValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.INTEGER_VALUE: {
				IntegerValue integerValue = (IntegerValue)theEObject;
				T result = caseIntegerValue(integerValue);
				if (result == null) result = caseNumericValue(integerValue);
				if (result == null) result = caseValue(integerValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.INVALID_VALUE: {
				InvalidValue invalidValue = (InvalidValue)theEObject;
				T result = caseInvalidValue(invalidValue);
				if (result == null) result = caseNullValue(invalidValue);
				if (result == null) result = caseBooleanValue(invalidValue);
				if (result == null) result = caseIntegerValue(invalidValue);
				if (result == null) result = caseOrderedSetValue(invalidValue);
				if (result == null) result = caseRealValue(invalidValue);
				if (result == null) result = caseSetValue(invalidValue);
				if (result == null) result = caseStringValue(invalidValue);
				if (result == null) result = caseTypeValue(invalidValue);
				if (result == null) result = caseUnlimitedValue(invalidValue);
				if (result == null) result = caseNumericValue(invalidValue);
				if (result == null) result = caseSequenceValue(invalidValue);
				if (result == null) result = caseUniqueCollectionValue(invalidValue);
				if (result == null) result = caseBagValue(invalidValue);
				if (result == null) result = caseElementValue(invalidValue);
				if (result == null) result = caseObjectValue(invalidValue);
				if (result == null) result = caseCollectionValue(invalidValue);
				if (result == null) result = caseValue(invalidValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.METACLASS_VALUE: {
				MetaclassValue metaclassValue = (MetaclassValue)theEObject;
				T result = caseMetaclassValue(metaclassValue);
				if (result == null) result = caseTypeValue(metaclassValue);
				if (result == null) result = caseElementValue(metaclassValue);
				if (result == null) result = caseObjectValue(metaclassValue);
				if (result == null) result = caseValue(metaclassValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.NULL_VALUE: {
				NullValue nullValue = (NullValue)theEObject;
				T result = caseNullValue(nullValue);
				if (result == null) result = caseBooleanValue(nullValue);
				if (result == null) result = caseIntegerValue(nullValue);
				if (result == null) result = caseOrderedSetValue(nullValue);
				if (result == null) result = caseRealValue(nullValue);
				if (result == null) result = caseSetValue(nullValue);
				if (result == null) result = caseStringValue(nullValue);
				if (result == null) result = caseTypeValue(nullValue);
				if (result == null) result = caseUnlimitedValue(nullValue);
				if (result == null) result = caseNumericValue(nullValue);
				if (result == null) result = caseSequenceValue(nullValue);
				if (result == null) result = caseUniqueCollectionValue(nullValue);
				if (result == null) result = caseBagValue(nullValue);
				if (result == null) result = caseElementValue(nullValue);
				if (result == null) result = caseObjectValue(nullValue);
				if (result == null) result = caseCollectionValue(nullValue);
				if (result == null) result = caseValue(nullValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.NUMERIC_VALUE: {
				NumericValue numericValue = (NumericValue)theEObject;
				T result = caseNumericValue(numericValue);
				if (result == null) result = caseValue(numericValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.OBJECT_VALUE: {
				ObjectValue objectValue = (ObjectValue)theEObject;
				T result = caseObjectValue(objectValue);
				if (result == null) result = caseValue(objectValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.ORDERED_SET_VALUE: {
				OrderedSetValue orderedSetValue = (OrderedSetValue)theEObject;
				T result = caseOrderedSetValue(orderedSetValue);
				if (result == null) result = caseSequenceValue(orderedSetValue);
				if (result == null) result = caseUniqueCollectionValue(orderedSetValue);
				if (result == null) result = caseCollectionValue(orderedSetValue);
				if (result == null) result = caseValue(orderedSetValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.REAL_VALUE: {
				RealValue realValue = (RealValue)theEObject;
				T result = caseRealValue(realValue);
				if (result == null) result = caseNumericValue(realValue);
				if (result == null) result = caseValue(realValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.SEQUENCE_VALUE: {
				SequenceValue sequenceValue = (SequenceValue)theEObject;
				T result = caseSequenceValue(sequenceValue);
				if (result == null) result = caseCollectionValue(sequenceValue);
				if (result == null) result = caseValue(sequenceValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.SET_VALUE: {
				SetValue setValue = (SetValue)theEObject;
				T result = caseSetValue(setValue);
				if (result == null) result = caseBagValue(setValue);
				if (result == null) result = caseUniqueCollectionValue(setValue);
				if (result == null) result = caseCollectionValue(setValue);
				if (result == null) result = caseValue(setValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.SIMPLE_TYPE_VALUE: {
				SimpleTypeValue simpleTypeValue = (SimpleTypeValue)theEObject;
				T result = caseSimpleTypeValue(simpleTypeValue);
				if (result == null) result = caseTypeValue(simpleTypeValue);
				if (result == null) result = caseElementValue(simpleTypeValue);
				if (result == null) result = caseObjectValue(simpleTypeValue);
				if (result == null) result = caseValue(simpleTypeValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.STRING_VALUE: {
				StringValue stringValue = (StringValue)theEObject;
				T result = caseStringValue(stringValue);
				if (result == null) result = caseValue(stringValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.TUPLE_VALUE: {
				TupleValue tupleValue = (TupleValue)theEObject;
				T result = caseTupleValue(tupleValue);
				if (result == null) result = caseValue(tupleValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.TYPE_VALUE: {
				TypeValue typeValue = (TypeValue)theEObject;
				T result = caseTypeValue(typeValue);
				if (result == null) result = caseElementValue(typeValue);
				if (result == null) result = caseObjectValue(typeValue);
				if (result == null) result = caseValue(typeValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.UNIQUE_COLLECTION_VALUE: {
				UniqueCollectionValue uniqueCollectionValue = (UniqueCollectionValue)theEObject;
				T result = caseUniqueCollectionValue(uniqueCollectionValue);
				if (result == null) result = caseCollectionValue(uniqueCollectionValue);
				if (result == null) result = caseValue(uniqueCollectionValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.UNLIMITED_VALUE: {
				UnlimitedValue unlimitedValue = (UnlimitedValue)theEObject;
				T result = caseUnlimitedValue(unlimitedValue);
				if (result == null) result = caseNumericValue(unlimitedValue);
				if (result == null) result = caseValue(unlimitedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValuesPackage.VALUE: {
				Value value = (Value)theEObject;
				T result = caseValue(value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBagValue(BagValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanValue(BooleanValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionValue(CollectionValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionTypeValue(CollectionTypeValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementValue(ElementValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Literal Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationLiteralValue(EnumerationLiteralValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Type Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Type Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationTypeValue(EnumerationTypeValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerValue(IntegerValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvalidValue(InvalidValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metaclass Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metaclass Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaclassValue(MetaclassValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullValue(NullValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericValue(NumericValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectValue(ObjectValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedSetValue(OrderedSetValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealValue(RealValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceValue(SequenceValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetValue(SetValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Type Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Type Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleTypeValue(SimpleTypeValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringValue(StringValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleValue(TupleValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeValue(TypeValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unique Collection Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unique Collection Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUniqueCollectionValue(UniqueCollectionValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unlimited Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlimited Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnlimitedValue(UnlimitedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValue(Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ValuesSwitch
