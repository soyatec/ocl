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
package org.eclipse.ocl.examples.codegen.cgmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The CGModel provides a Code Generation friendly form of the OCL Pivot model, with distinct classes
 * such as LibraryPropertyCallExp and EcorePropertyCallExp for distinct purposes. Additional classes
 * such as BoxExpr, CatchExpr and CastParameter support rewrite optimizations.
 * <p>
 * References to the Pivot model are expressed as attributes with datatype values in order to avoid
 * confusion as to whether the new or old pivot mosdel is in use while code generating the pivot model.
 * <!-- end-model-doc -->
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore#/'"
 * @generated
 */
public interface CGModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cgmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/1.0.0/CG";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ch";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.examples.codegen.cgmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@NonNull CGModelPackage eINSTANCE = org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGElementImpl <em>CG Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGElementImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGElement()
	 * @generated
	 */
	int CG_ELEMENT = 17;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT__PARENT = 0;

	/**
	 * The number of structural features of the '<em>CG Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>CG Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGNamedElementImpl <em>CG Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGNamedElementImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGNamedElement()
	 * @generated
	 */
	int CG_NAMED_ELEMENT = 46;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGClassImpl <em>CG Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGClassImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGClass()
	 * @generated
	 */
	int CG_CLASS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelImpl <em>CG Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGModel()
	 * @generated
	 */
	int CG_MODEL = 45;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypedElementImpl <em>CG Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypedElementImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTypedElement()
	 * @generated
	 */
	int CG_TYPED_ELEMENT = 65;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl <em>CG Valued Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGValuedElement()
	 * @generated
	 */
	int CG_VALUED_ELEMENT = 67;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIfExpImpl <em>CG If Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIfExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGIfExp()
	 * @generated
	 */
	int CG_IF_EXP = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationImpl <em>CG Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGOperation()
	 * @generated
	 */
	int CG_OPERATION = 48;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPackageImpl <em>CG Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPackageImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGPackage()
	 * @generated
	 */
	int CG_PACKAGE = 50;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGParameterImpl <em>CG Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGParameterImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGParameter()
	 * @generated
	 */
	int CG_PARAMETER = 51;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGBooleanImpl <em>CG Boolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGBooleanImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGBoolean()
	 * @generated
	 */
	int CG_BOOLEAN = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGInfinityImpl <em>CG Infinity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGInfinityImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGInfinity()
	 * @generated
	 */
	int CG_INFINITY = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIntegerImpl <em>CG Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIntegerImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGInteger()
	 * @generated
	 */
	int CG_INTEGER = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGInvalidImpl <em>CG Invalid</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGInvalidImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGInvalid()
	 * @generated
	 */
	int CG_INVALID = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstantImpl <em>CG Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstantImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGConstant()
	 * @generated
	 */
	int CG_CONSTANT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCallExpImpl <em>CG Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGCallExp()
	 * @generated
	 */
	int CG_CALL_EXP = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCatchExpImpl <em>CG Catch Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCatchExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGCatchExp()
	 * @generated
	 */
	int CG_CATCH_EXP = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCollectionExpImpl <em>CG Collection Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCollectionExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGCollectionExp()
	 * @generated
	 */
	int CG_COLLECTION_EXP = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCollectionPartImpl <em>CG Collection Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCollectionPartImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGCollectionPart()
	 * @generated
	 */
	int CG_COLLECTION_PART = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryOperationCallExpImpl <em>CG Library Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryOperationCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGLibraryOperationCallExp()
	 * @generated
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP = 42;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryPropertyCallExpImpl <em>CG Library Property Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryPropertyCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGLibraryPropertyCallExp()
	 * @generated
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP = 43;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGNullImpl <em>CG Null</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGNullImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGNull()
	 * @generated
	 */
	int CG_NULL = 47;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationCallExpImpl <em>CG Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGOperationCallExp()
	 * @generated
	 */
	int CG_OPERATION_CALL_EXP = 49;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPropertyImpl <em>CG Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPropertyImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGProperty()
	 * @generated
	 */
	int CG_PROPERTY = 52;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPropertyCallExpImpl <em>CG Property Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPropertyCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGPropertyCallExp()
	 * @generated
	 */
	int CG_PROPERTY_CALL_EXP = 53;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGRealImpl <em>CG Real</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGRealImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGReal()
	 * @generated
	 */
	int CG_REAL = 54;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGStringImpl <em>CG String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGStringImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGString()
	 * @generated
	 */
	int CG_STRING = 56;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGVariableImpl <em>CG Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGVariableImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGVariable()
	 * @generated
	 */
	int CG_VARIABLE = 68;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLocalVariableImpl <em>CG Local Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLocalVariableImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGLocalVariable()
	 * @generated
	 */
	int CG_LOCAL_VARIABLE = 44;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreOperationCallExpImpl <em>CG Ecore Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreOperationCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGEcoreOperationCallExp()
	 * @generated
	 */
	int CG_ECORE_OPERATION_CALL_EXP = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcorePropertyCallExpImpl <em>CG Ecore Property Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcorePropertyCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGEcorePropertyCallExp()
	 * @generated
	 */
	int CG_ECORE_PROPERTY_CALL_EXP = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstantExpImpl <em>CG Constant Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstantExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGConstantExp()
	 * @generated
	 */
	int CG_CONSTANT_EXP = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGFinalVariableImpl <em>CG Final Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGFinalVariableImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGFinalVariable()
	 * @generated
	 */
	int CG_FINAL_VARIABLE = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLetExpImpl <em>CG Let Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLetExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGLetExp()
	 * @generated
	 */
	int CG_LET_EXP = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGSettableVariableImpl <em>CG Settable Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGSettableVariableImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGSettableVariable()
	 * @generated
	 */
	int CG_SETTABLE_VARIABLE = 55;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGThrowExpImpl <em>CG Throw Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGThrowExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGThrowExp()
	 * @generated
	 */
	int CG_THROW_EXP = 59;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTupleExpImpl <em>CG Tuple Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTupleExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTupleExp()
	 * @generated
	 */
	int CG_TUPLE_EXP = 60;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTuplePartImpl <em>CG Tuple Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTuplePartImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTuplePart()
	 * @generated
	 */
	int CG_TUPLE_PART = 61;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypeExpImpl <em>CG Type Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypeExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTypeExp()
	 * @generated
	 */
	int CG_TYPE_EXP = 64;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstructorExpImpl <em>CG Constructor Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstructorExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGConstructorExp()
	 * @generated
	 */
	int CG_CONSTRUCTOR_EXP = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstructorPartImpl <em>CG Constructor Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstructorPartImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGConstructorPart()
	 * @generated
	 */
	int CG_CONSTRUCTOR_PART = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreClassConstructorExpImpl <em>CG Ecore Class Constructor Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreClassConstructorExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGEcoreClassConstructorExp()
	 * @generated
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreDataTypeConstructorExpImpl <em>CG Ecore Data Type Constructor Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreDataTypeConstructorExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGEcoreDataTypeConstructorExp()
	 * @generated
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGElementIdImpl <em>CG Element Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGElementIdImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGElementId()
	 * @generated
	 */
	int CG_ELEMENT_ID = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIterationCallExpImpl <em>CG Iteration Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIterationCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGIterationCallExp()
	 * @generated
	 */
	int CG_ITERATION_CALL_EXP = 37;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGBoxExpImpl <em>CG Box Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGBoxExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGBoxExp()
	 * @generated
	 */
	int CG_BOX_EXP = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryIterationCallExpImpl <em>CG Library Iteration Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryIterationCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGLibraryIterationCallExp()
	 * @generated
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP = 41;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTextImpl <em>CG Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTextImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGText()
	 * @generated
	 */
	int CG_TEXT = 57;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypeIdImpl <em>CG Type Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypeIdImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTypeId()
	 * @generated
	 */
	int CG_TYPE_ID = 63;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NAMED_ELEMENT__PARENT = CG_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NAMED_ELEMENT__NAME = CG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NAMED_ELEMENT__PIVOT = CG_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NAMED_ELEMENT_FEATURE_COUNT = CG_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>CG Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NAMED_ELEMENT_OPERATION_COUNT = CG_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_ELEMENT__PARENT = CG_NAMED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_ELEMENT__NAME = CG_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_ELEMENT__PIVOT = CG_NAMED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_ELEMENT__PIVOT_TYPE_ID = CG_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_ELEMENT__TYPE_ID = CG_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_ELEMENT__REQUIRED = CG_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CG Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_ELEMENT_FEATURE_COUNT = CG_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>CG Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_ELEMENT_OPERATION_COUNT = CG_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__PARENT = CG_TYPED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__NAME = CG_TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__PIVOT = CG_TYPED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__PIVOT_TYPE_ID = CG_TYPED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__TYPE_ID = CG_TYPED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__REQUIRED = CG_TYPED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__BOXED = CG_TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__CAUGHT = CG_TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__CONSTANT = CG_TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__DEPENDS_ON = CG_TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__FALSE = CG_TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__GLOBAL = CG_TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__INLINEABLE = CG_TYPED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__INVALID = CG_TYPED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__NULL = CG_TYPED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__NON_INVALID = CG_TYPED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__NON_NULL = CG_TYPED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT = CG_TYPED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__SETTABLE = CG_TYPED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__TRUE = CG_TYPED_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__UNBOXED = CG_TYPED_ELEMENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__VALUE = CG_TYPED_ELEMENT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT__VALUE_NAME = CG_TYPED_ELEMENT_FEATURE_COUNT + 16;

	/**
	 * The number of structural features of the '<em>CG Valued Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT_FEATURE_COUNT = CG_TYPED_ELEMENT_FEATURE_COUNT + 17;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT___SET_NON_INVALID = CG_TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT___SET_NON_NULL = CG_TYPED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>CG Valued Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VALUED_ELEMENT_OPERATION_COUNT = CG_TYPED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT__CONSTANT_VALUE = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__PARENT = CG_CONSTANT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__NAME = CG_CONSTANT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__PIVOT = CG_CONSTANT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__PIVOT_TYPE_ID = CG_CONSTANT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__TYPE_ID = CG_CONSTANT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__REQUIRED = CG_CONSTANT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__BOXED = CG_CONSTANT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__CAUGHT = CG_CONSTANT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__CONSTANT = CG_CONSTANT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__DEPENDS_ON = CG_CONSTANT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__FALSE = CG_CONSTANT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__GLOBAL = CG_CONSTANT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__INLINEABLE = CG_CONSTANT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__INVALID = CG_CONSTANT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__NULL = CG_CONSTANT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__NON_INVALID = CG_CONSTANT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__NON_NULL = CG_CONSTANT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__REFERRED_VALUED_ELEMENT = CG_CONSTANT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__SETTABLE = CG_CONSTANT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__TRUE = CG_CONSTANT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__UNBOXED = CG_CONSTANT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__VALUE = CG_CONSTANT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__VALUE_NAME = CG_CONSTANT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__CONSTANT_VALUE = CG_CONSTANT__CONSTANT_VALUE;

	/**
	 * The feature id for the '<em><b>Boolean Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN__BOOLEAN_VALUE = CG_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN_FEATURE_COUNT = CG_CONSTANT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN___SET_NON_INVALID = CG_CONSTANT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN___SET_NON_NULL = CG_CONSTANT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOOLEAN_OPERATION_COUNT = CG_CONSTANT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__INVALIDATING = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__VALIDATING = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP__SOURCE = CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CG Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CALL_EXP_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__PARENT = CG_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__NAME = CG_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__PIVOT = CG_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__PIVOT_TYPE_ID = CG_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__TYPE_ID = CG_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__REQUIRED = CG_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__BOXED = CG_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__CAUGHT = CG_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__CONSTANT = CG_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__DEPENDS_ON = CG_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__FALSE = CG_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__GLOBAL = CG_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__INLINEABLE = CG_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__INVALID = CG_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__NULL = CG_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__NON_INVALID = CG_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__NON_NULL = CG_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__REFERRED_VALUED_ELEMENT = CG_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__SETTABLE = CG_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__TRUE = CG_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__UNBOXED = CG_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__VALUE = CG_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__VALUE_NAME = CG_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__INVALIDATING = CG_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__VALIDATING = CG_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP__SOURCE = CG_CALL_EXP__SOURCE;

	/**
	 * The number of structural features of the '<em>CG Box Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP_FEATURE_COUNT = CG_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP___SET_NON_INVALID = CG_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP___SET_NON_NULL = CG_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Box Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_BOX_EXP_OPERATION_COUNT = CG_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorOperationImpl <em>CG Executor Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorOperationImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorOperation()
	 * @generated
	 */
	int CG_EXECUTOR_OPERATION = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorOperationCallExpImpl <em>CG Executor Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorOperationCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorOperationCallExp()
	 * @generated
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorPropertyImpl <em>CG Executor Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorPropertyImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorProperty()
	 * @generated
	 */
	int CG_EXECUTOR_PROPERTY = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorPropertyCallExpImpl <em>CG Executor Property Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorPropertyCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorPropertyCallExp()
	 * @generated
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorCompositionPropertyImpl <em>CG Executor Composition Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorCompositionPropertyImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorCompositionProperty()
	 * @generated
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorConstructorPartImpl <em>CG Executor Constructor Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorConstructorPartImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorConstructorPart()
	 * @generated
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorNavigationPropertyImpl <em>CG Executor Navigation Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorNavigationPropertyImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorNavigationProperty()
	 * @generated
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorTypeImpl <em>CG Executor Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorTypeImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorType()
	 * @generated
	 */
	int CG_EXECUTOR_TYPE = 28;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE__INIT = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGGuardExpImpl <em>CG Guard Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGGuardExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGGuardExp()
	 * @generated
	 */
	int CG_GUARD_EXP = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryIterateCallExpImpl <em>CG Library Iterate Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryIterateCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGLibraryIterateCallExp()
	 * @generated
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP = 40;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__PARENT = CG_VARIABLE__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__NAME = CG_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__PIVOT = CG_VARIABLE__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__PIVOT_TYPE_ID = CG_VARIABLE__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__TYPE_ID = CG_VARIABLE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__REQUIRED = CG_VARIABLE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__BOXED = CG_VARIABLE__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__CAUGHT = CG_VARIABLE__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__CONSTANT = CG_VARIABLE__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__DEPENDS_ON = CG_VARIABLE__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__FALSE = CG_VARIABLE__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__GLOBAL = CG_VARIABLE__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__INLINEABLE = CG_VARIABLE__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__INVALID = CG_VARIABLE__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__NULL = CG_VARIABLE__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__NON_INVALID = CG_VARIABLE__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__NON_NULL = CG_VARIABLE__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__REFERRED_VALUED_ELEMENT = CG_VARIABLE__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__SETTABLE = CG_VARIABLE__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__TRUE = CG_VARIABLE__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__UNBOXED = CG_VARIABLE__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__VALUE = CG_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__VALUE_NAME = CG_VARIABLE__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__INIT = CG_VARIABLE__INIT;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER__OPERATION = CG_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER_FEATURE_COUNT = CG_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER___SET_NON_INVALID = CG_VARIABLE___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER___SET_NON_NULL = CG_VARIABLE___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PARAMETER_OPERATION_COUNT = CG_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCastParameterImpl <em>CG Cast Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCastParameterImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGCastParameter()
	 * @generated
	 */
	int CG_CAST_PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__PARENT = CG_PARAMETER__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__NAME = CG_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__PIVOT = CG_PARAMETER__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__PIVOT_TYPE_ID = CG_PARAMETER__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__TYPE_ID = CG_PARAMETER__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__REQUIRED = CG_PARAMETER__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__BOXED = CG_PARAMETER__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__CAUGHT = CG_PARAMETER__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__CONSTANT = CG_PARAMETER__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__DEPENDS_ON = CG_PARAMETER__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__FALSE = CG_PARAMETER__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__GLOBAL = CG_PARAMETER__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__INLINEABLE = CG_PARAMETER__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__INVALID = CG_PARAMETER__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__NULL = CG_PARAMETER__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__NON_INVALID = CG_PARAMETER__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__NON_NULL = CG_PARAMETER__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__REFERRED_VALUED_ELEMENT = CG_PARAMETER__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__SETTABLE = CG_PARAMETER__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__TRUE = CG_PARAMETER__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__UNBOXED = CG_PARAMETER__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__VALUE = CG_PARAMETER__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__VALUE_NAME = CG_PARAMETER__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__INIT = CG_PARAMETER__INIT;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__OPERATION = CG_PARAMETER__OPERATION;

	/**
	 * The feature id for the '<em><b>Referred Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER__REFERRED_PARAMETER = CG_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Cast Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER_FEATURE_COUNT = CG_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER___SET_NON_INVALID = CG_PARAMETER___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER___SET_NON_NULL = CG_PARAMETER___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Cast Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CAST_PARAMETER_OPERATION_COUNT = CG_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__PARENT = CG_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__NAME = CG_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__PIVOT = CG_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__PIVOT_TYPE_ID = CG_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__TYPE_ID = CG_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__REQUIRED = CG_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__BOXED = CG_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__CAUGHT = CG_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__CONSTANT = CG_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__DEPENDS_ON = CG_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__FALSE = CG_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__GLOBAL = CG_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__INLINEABLE = CG_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__INVALID = CG_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__NULL = CG_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__NON_INVALID = CG_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__NON_NULL = CG_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__REFERRED_VALUED_ELEMENT = CG_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__SETTABLE = CG_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__TRUE = CG_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__UNBOXED = CG_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__VALUE = CG_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__VALUE_NAME = CG_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__INVALIDATING = CG_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__VALIDATING = CG_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP__SOURCE = CG_CALL_EXP__SOURCE;

	/**
	 * The number of structural features of the '<em>CG Catch Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP_FEATURE_COUNT = CG_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP___SET_NON_INVALID = CG_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP___SET_NON_NULL = CG_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Catch Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CATCH_EXP_OPERATION_COUNT = CG_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CLASS__PARENT = CG_NAMED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CLASS__NAME = CG_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CLASS__PIVOT = CG_NAMED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CLASS__CONTAINING_PACKAGE = CG_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CLASS__OPERATIONS = CG_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CLASS__PROPERTIES = CG_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CLASS__INVARIANTS = CG_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>CG Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CLASS_FEATURE_COUNT = CG_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>CG Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CLASS_OPERATION_COUNT = CG_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP__PARTS = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Collection Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Collection Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_EXP_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__FIRST = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__LAST = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Collection Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__COLLECTION_EXP = CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART__RANGE = CG_VALUED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>CG Collection Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Collection Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_COLLECTION_PART_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Referred Constant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP__REFERRED_CONSTANT = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Constant Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Constant Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTANT_EXP_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstraintImpl <em>CG Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstraintImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGConstraint()
	 * @generated
	 */
	int CG_CONSTRAINT = 10;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRAINT__PARENT = CG_NAMED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRAINT__NAME = CG_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRAINT__PIVOT = CG_NAMED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRAINT__BODY = CG_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRAINT__MESSAGE = CG_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRAINT_FEATURE_COUNT = CG_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>CG Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRAINT_OPERATION_COUNT = CG_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP__PARTS = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Constructor Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Constructor Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_EXP_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__INIT = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constructor Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART__CONSTRUCTOR_EXP = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Constructor Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Constructor Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONSTRUCTOR_PART_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__PARENT = CG_CONSTRUCTOR_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__NAME = CG_CONSTRUCTOR_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__PIVOT = CG_CONSTRUCTOR_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__PIVOT_TYPE_ID = CG_CONSTRUCTOR_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__TYPE_ID = CG_CONSTRUCTOR_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__REQUIRED = CG_CONSTRUCTOR_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__BOXED = CG_CONSTRUCTOR_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__CAUGHT = CG_CONSTRUCTOR_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__CONSTANT = CG_CONSTRUCTOR_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__DEPENDS_ON = CG_CONSTRUCTOR_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__FALSE = CG_CONSTRUCTOR_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__GLOBAL = CG_CONSTRUCTOR_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__INLINEABLE = CG_CONSTRUCTOR_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__INVALID = CG_CONSTRUCTOR_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__NULL = CG_CONSTRUCTOR_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__NON_INVALID = CG_CONSTRUCTOR_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__NON_NULL = CG_CONSTRUCTOR_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__REFERRED_VALUED_ELEMENT = CG_CONSTRUCTOR_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__SETTABLE = CG_CONSTRUCTOR_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__TRUE = CG_CONSTRUCTOR_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__UNBOXED = CG_CONSTRUCTOR_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__VALUE = CG_CONSTRUCTOR_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__VALUE_NAME = CG_CONSTRUCTOR_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__PARTS = CG_CONSTRUCTOR_EXP__PARTS;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP__ECLASS = CG_CONSTRUCTOR_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Ecore Class Constructor Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP_FEATURE_COUNT = CG_CONSTRUCTOR_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP___SET_NON_INVALID = CG_CONSTRUCTOR_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP___SET_NON_NULL = CG_CONSTRUCTOR_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Ecore Class Constructor Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CLASS_CONSTRUCTOR_EXP_OPERATION_COUNT = CG_CONSTRUCTOR_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__PARENT = CG_CONSTRUCTOR_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__NAME = CG_CONSTRUCTOR_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__PIVOT = CG_CONSTRUCTOR_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__PIVOT_TYPE_ID = CG_CONSTRUCTOR_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__TYPE_ID = CG_CONSTRUCTOR_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__REQUIRED = CG_CONSTRUCTOR_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__BOXED = CG_CONSTRUCTOR_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__CAUGHT = CG_CONSTRUCTOR_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__CONSTANT = CG_CONSTRUCTOR_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__DEPENDS_ON = CG_CONSTRUCTOR_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__FALSE = CG_CONSTRUCTOR_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__GLOBAL = CG_CONSTRUCTOR_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__INLINEABLE = CG_CONSTRUCTOR_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__INVALID = CG_CONSTRUCTOR_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__NULL = CG_CONSTRUCTOR_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__NON_INVALID = CG_CONSTRUCTOR_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__NON_NULL = CG_CONSTRUCTOR_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__REFERRED_VALUED_ELEMENT = CG_CONSTRUCTOR_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__SETTABLE = CG_CONSTRUCTOR_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__TRUE = CG_CONSTRUCTOR_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__UNBOXED = CG_CONSTRUCTOR_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__VALUE = CG_CONSTRUCTOR_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__VALUE_NAME = CG_CONSTRUCTOR_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__PARTS = CG_CONSTRUCTOR_EXP__PARTS;

	/**
	 * The feature id for the '<em><b>EData Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__EDATA_TYPE = CG_CONSTRUCTOR_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__STRING = CG_CONSTRUCTOR_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Ecore Data Type Constructor Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP_FEATURE_COUNT = CG_CONSTRUCTOR_EXP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP___SET_NON_INVALID = CG_CONSTRUCTOR_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP___SET_NON_NULL = CG_CONSTRUCTOR_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Ecore Data Type Constructor Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP_OPERATION_COUNT = CG_CONSTRUCTOR_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__PARENT = CG_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__NAME = CG_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__PIVOT = CG_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__PIVOT_TYPE_ID = CG_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__TYPE_ID = CG_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__REQUIRED = CG_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__BOXED = CG_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__CAUGHT = CG_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__CONSTANT = CG_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__DEPENDS_ON = CG_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__FALSE = CG_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__GLOBAL = CG_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__INLINEABLE = CG_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__INVALID = CG_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__NULL = CG_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__NON_INVALID = CG_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__NON_NULL = CG_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__SETTABLE = CG_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__TRUE = CG_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__UNBOXED = CG_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__VALUE = CG_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__VALUE_NAME = CG_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__INVALIDATING = CG_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__VALIDATING = CG_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__SOURCE = CG_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__REFERRED_OPERATION = CG_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP__ARGUMENTS = CG_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP_FEATURE_COUNT = CG_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP___SET_NON_INVALID = CG_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP___SET_NON_NULL = CG_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_CALL_EXP_OPERATION_COUNT = CG_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__PARENT = CG_OPERATION_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__NAME = CG_OPERATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__PIVOT = CG_OPERATION_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__PIVOT_TYPE_ID = CG_OPERATION_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__TYPE_ID = CG_OPERATION_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__REQUIRED = CG_OPERATION_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__BOXED = CG_OPERATION_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__CAUGHT = CG_OPERATION_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__CONSTANT = CG_OPERATION_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__DEPENDS_ON = CG_OPERATION_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__FALSE = CG_OPERATION_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__GLOBAL = CG_OPERATION_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__INLINEABLE = CG_OPERATION_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__INVALID = CG_OPERATION_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__NULL = CG_OPERATION_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__NON_INVALID = CG_OPERATION_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__NON_NULL = CG_OPERATION_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_OPERATION_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__SETTABLE = CG_OPERATION_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__TRUE = CG_OPERATION_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__UNBOXED = CG_OPERATION_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__VALUE = CG_OPERATION_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__VALUE_NAME = CG_OPERATION_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__INVALIDATING = CG_OPERATION_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__VALIDATING = CG_OPERATION_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__SOURCE = CG_OPERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__REFERRED_OPERATION = CG_OPERATION_CALL_EXP__REFERRED_OPERATION;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__ARGUMENTS = CG_OPERATION_CALL_EXP__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>EOperation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP__EOPERATION = CG_OPERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Ecore Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP_FEATURE_COUNT = CG_OPERATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP___SET_NON_INVALID = CG_OPERATION_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP___SET_NON_NULL = CG_OPERATION_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Ecore Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_OPERATION_CALL_EXP_OPERATION_COUNT = CG_OPERATION_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__PARENT = CG_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__NAME = CG_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__PIVOT = CG_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__PIVOT_TYPE_ID = CG_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__TYPE_ID = CG_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__REQUIRED = CG_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__BOXED = CG_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__CAUGHT = CG_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__CONSTANT = CG_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__DEPENDS_ON = CG_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__FALSE = CG_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__GLOBAL = CG_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__INLINEABLE = CG_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__INVALID = CG_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__NULL = CG_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__NON_INVALID = CG_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__NON_NULL = CG_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__SETTABLE = CG_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__TRUE = CG_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__UNBOXED = CG_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__VALUE = CG_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__VALUE_NAME = CG_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__INVALIDATING = CG_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__VALIDATING = CG_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__SOURCE = CG_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP__REFERRED_PROPERTY = CG_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP_FEATURE_COUNT = CG_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP___SET_NON_INVALID = CG_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP___SET_NON_NULL = CG_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_CALL_EXP_OPERATION_COUNT = CG_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__PARENT = CG_PROPERTY_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__NAME = CG_PROPERTY_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__PIVOT = CG_PROPERTY_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__PIVOT_TYPE_ID = CG_PROPERTY_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__TYPE_ID = CG_PROPERTY_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__REQUIRED = CG_PROPERTY_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__BOXED = CG_PROPERTY_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__CAUGHT = CG_PROPERTY_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__CONSTANT = CG_PROPERTY_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__DEPENDS_ON = CG_PROPERTY_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__FALSE = CG_PROPERTY_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__GLOBAL = CG_PROPERTY_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__INLINEABLE = CG_PROPERTY_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__INVALID = CG_PROPERTY_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__NULL = CG_PROPERTY_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__NON_INVALID = CG_PROPERTY_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__NON_NULL = CG_PROPERTY_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_PROPERTY_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__SETTABLE = CG_PROPERTY_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__TRUE = CG_PROPERTY_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__UNBOXED = CG_PROPERTY_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__VALUE = CG_PROPERTY_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__VALUE_NAME = CG_PROPERTY_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__INVALIDATING = CG_PROPERTY_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__VALIDATING = CG_PROPERTY_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__SOURCE = CG_PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__REFERRED_PROPERTY = CG_PROPERTY_CALL_EXP__REFERRED_PROPERTY;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP__ESTRUCTURAL_FEATURE = CG_PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Ecore Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP_FEATURE_COUNT = CG_PROPERTY_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP___SET_NON_INVALID = CG_PROPERTY_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP___SET_NON_NULL = CG_PROPERTY_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Ecore Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_CALL_EXP_OPERATION_COUNT = CG_PROPERTY_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__PARENT = CG_CONSTANT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__NAME = CG_CONSTANT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__PIVOT = CG_CONSTANT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__PIVOT_TYPE_ID = CG_CONSTANT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__TYPE_ID = CG_CONSTANT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__REQUIRED = CG_CONSTANT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__BOXED = CG_CONSTANT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__CAUGHT = CG_CONSTANT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__CONSTANT = CG_CONSTANT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__DEPENDS_ON = CG_CONSTANT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__FALSE = CG_CONSTANT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__GLOBAL = CG_CONSTANT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__INLINEABLE = CG_CONSTANT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__INVALID = CG_CONSTANT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__NULL = CG_CONSTANT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__NON_INVALID = CG_CONSTANT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__NON_NULL = CG_CONSTANT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__REFERRED_VALUED_ELEMENT = CG_CONSTANT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__SETTABLE = CG_CONSTANT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__TRUE = CG_CONSTANT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__UNBOXED = CG_CONSTANT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__VALUE = CG_CONSTANT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__VALUE_NAME = CG_CONSTANT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__CONSTANT_VALUE = CG_CONSTANT__CONSTANT_VALUE;

	/**
	 * The feature id for the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID__ELEMENT_ID = CG_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Element Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID_FEATURE_COUNT = CG_CONSTANT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID___SET_NON_INVALID = CG_CONSTANT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID___SET_NON_NULL = CG_CONSTANT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Element Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ELEMENT_ID_OPERATION_COUNT = CG_CONSTANT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEqualsExpImpl <em>CG Equals Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEqualsExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGEqualsExp()
	 * @generated
	 */
	int CG_EQUALS_EXP = 19;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__PARENT = CG_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__NAME = CG_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__PIVOT = CG_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__PIVOT_TYPE_ID = CG_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__TYPE_ID = CG_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__REQUIRED = CG_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__BOXED = CG_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__CAUGHT = CG_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__CONSTANT = CG_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__DEPENDS_ON = CG_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__FALSE = CG_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__GLOBAL = CG_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__INLINEABLE = CG_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__INVALID = CG_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__NULL = CG_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__NON_INVALID = CG_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__NON_NULL = CG_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__REFERRED_VALUED_ELEMENT = CG_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__SETTABLE = CG_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__TRUE = CG_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__UNBOXED = CG_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__VALUE = CG_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__VALUE_NAME = CG_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__INVALIDATING = CG_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__VALIDATING = CG_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__SOURCE = CG_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP__ARGUMENT = CG_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Equals Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP_FEATURE_COUNT = CG_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP___SET_NON_INVALID = CG_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP___SET_NON_NULL = CG_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Equals Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EQUALS_EXP_OPERATION_COUNT = CG_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Underlying Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY__UNDERLYING_PROPERTY_ID = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Executor Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Executor Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__PARENT = CG_EXECUTOR_PROPERTY__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__NAME = CG_EXECUTOR_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__PIVOT = CG_EXECUTOR_PROPERTY__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__PIVOT_TYPE_ID = CG_EXECUTOR_PROPERTY__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__TYPE_ID = CG_EXECUTOR_PROPERTY__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__REQUIRED = CG_EXECUTOR_PROPERTY__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__BOXED = CG_EXECUTOR_PROPERTY__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__CAUGHT = CG_EXECUTOR_PROPERTY__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__CONSTANT = CG_EXECUTOR_PROPERTY__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__DEPENDS_ON = CG_EXECUTOR_PROPERTY__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__FALSE = CG_EXECUTOR_PROPERTY__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__GLOBAL = CG_EXECUTOR_PROPERTY__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__INLINEABLE = CG_EXECUTOR_PROPERTY__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__INVALID = CG_EXECUTOR_PROPERTY__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__NULL = CG_EXECUTOR_PROPERTY__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__NON_INVALID = CG_EXECUTOR_PROPERTY__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__NON_NULL = CG_EXECUTOR_PROPERTY__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__REFERRED_VALUED_ELEMENT = CG_EXECUTOR_PROPERTY__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__SETTABLE = CG_EXECUTOR_PROPERTY__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__TRUE = CG_EXECUTOR_PROPERTY__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__UNBOXED = CG_EXECUTOR_PROPERTY__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__VALUE = CG_EXECUTOR_PROPERTY__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__VALUE_NAME = CG_EXECUTOR_PROPERTY__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Underlying Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY__UNDERLYING_PROPERTY_ID = CG_EXECUTOR_PROPERTY__UNDERLYING_PROPERTY_ID;

	/**
	 * The number of structural features of the '<em>CG Executor Composition Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY_FEATURE_COUNT = CG_EXECUTOR_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY___SET_NON_INVALID = CG_EXECUTOR_PROPERTY___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY___SET_NON_NULL = CG_EXECUTOR_PROPERTY___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Executor Composition Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_COMPOSITION_PROPERTY_OPERATION_COUNT = CG_EXECUTOR_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__PARENT = CG_EXECUTOR_PROPERTY__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__NAME = CG_EXECUTOR_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__PIVOT = CG_EXECUTOR_PROPERTY__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__PIVOT_TYPE_ID = CG_EXECUTOR_PROPERTY__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__TYPE_ID = CG_EXECUTOR_PROPERTY__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__REQUIRED = CG_EXECUTOR_PROPERTY__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__BOXED = CG_EXECUTOR_PROPERTY__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__CAUGHT = CG_EXECUTOR_PROPERTY__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__CONSTANT = CG_EXECUTOR_PROPERTY__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__DEPENDS_ON = CG_EXECUTOR_PROPERTY__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__FALSE = CG_EXECUTOR_PROPERTY__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__GLOBAL = CG_EXECUTOR_PROPERTY__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__INLINEABLE = CG_EXECUTOR_PROPERTY__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__INVALID = CG_EXECUTOR_PROPERTY__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__NULL = CG_EXECUTOR_PROPERTY__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__NON_INVALID = CG_EXECUTOR_PROPERTY__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__NON_NULL = CG_EXECUTOR_PROPERTY__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__REFERRED_VALUED_ELEMENT = CG_EXECUTOR_PROPERTY__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__SETTABLE = CG_EXECUTOR_PROPERTY__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__TRUE = CG_EXECUTOR_PROPERTY__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__UNBOXED = CG_EXECUTOR_PROPERTY__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__VALUE = CG_EXECUTOR_PROPERTY__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__VALUE_NAME = CG_EXECUTOR_PROPERTY__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Underlying Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART__UNDERLYING_PROPERTY_ID = CG_EXECUTOR_PROPERTY__UNDERLYING_PROPERTY_ID;

	/**
	 * The number of structural features of the '<em>CG Executor Constructor Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART_FEATURE_COUNT = CG_EXECUTOR_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART___SET_NON_INVALID = CG_EXECUTOR_PROPERTY___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART___SET_NON_NULL = CG_EXECUTOR_PROPERTY___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Executor Constructor Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_CONSTRUCTOR_PART_OPERATION_COUNT = CG_EXECUTOR_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__PARENT = CG_EXECUTOR_PROPERTY__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__NAME = CG_EXECUTOR_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__PIVOT = CG_EXECUTOR_PROPERTY__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__PIVOT_TYPE_ID = CG_EXECUTOR_PROPERTY__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__TYPE_ID = CG_EXECUTOR_PROPERTY__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__REQUIRED = CG_EXECUTOR_PROPERTY__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__BOXED = CG_EXECUTOR_PROPERTY__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__CAUGHT = CG_EXECUTOR_PROPERTY__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__CONSTANT = CG_EXECUTOR_PROPERTY__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__DEPENDS_ON = CG_EXECUTOR_PROPERTY__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__FALSE = CG_EXECUTOR_PROPERTY__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__GLOBAL = CG_EXECUTOR_PROPERTY__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__INLINEABLE = CG_EXECUTOR_PROPERTY__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__INVALID = CG_EXECUTOR_PROPERTY__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__NULL = CG_EXECUTOR_PROPERTY__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__NON_INVALID = CG_EXECUTOR_PROPERTY__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__NON_NULL = CG_EXECUTOR_PROPERTY__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__REFERRED_VALUED_ELEMENT = CG_EXECUTOR_PROPERTY__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__SETTABLE = CG_EXECUTOR_PROPERTY__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__TRUE = CG_EXECUTOR_PROPERTY__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__UNBOXED = CG_EXECUTOR_PROPERTY__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__VALUE = CG_EXECUTOR_PROPERTY__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__VALUE_NAME = CG_EXECUTOR_PROPERTY__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Underlying Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY__UNDERLYING_PROPERTY_ID = CG_EXECUTOR_PROPERTY__UNDERLYING_PROPERTY_ID;

	/**
	 * The number of structural features of the '<em>CG Executor Navigation Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY_FEATURE_COUNT = CG_EXECUTOR_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY___SET_NON_INVALID = CG_EXECUTOR_PROPERTY___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY___SET_NON_NULL = CG_EXECUTOR_PROPERTY___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Executor Navigation Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_NAVIGATION_PROPERTY_OPERATION_COUNT = CG_EXECUTOR_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorOppositePropertyImpl <em>CG Executor Opposite Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorOppositePropertyImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorOppositeProperty()
	 * @generated
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY = 23;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__PARENT = CG_EXECUTOR_PROPERTY__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__NAME = CG_EXECUTOR_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__PIVOT = CG_EXECUTOR_PROPERTY__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__PIVOT_TYPE_ID = CG_EXECUTOR_PROPERTY__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__TYPE_ID = CG_EXECUTOR_PROPERTY__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__REQUIRED = CG_EXECUTOR_PROPERTY__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__BOXED = CG_EXECUTOR_PROPERTY__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__CAUGHT = CG_EXECUTOR_PROPERTY__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__CONSTANT = CG_EXECUTOR_PROPERTY__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__DEPENDS_ON = CG_EXECUTOR_PROPERTY__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__FALSE = CG_EXECUTOR_PROPERTY__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__GLOBAL = CG_EXECUTOR_PROPERTY__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__INLINEABLE = CG_EXECUTOR_PROPERTY__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__INVALID = CG_EXECUTOR_PROPERTY__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__NULL = CG_EXECUTOR_PROPERTY__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__NON_INVALID = CG_EXECUTOR_PROPERTY__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__NON_NULL = CG_EXECUTOR_PROPERTY__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__REFERRED_VALUED_ELEMENT = CG_EXECUTOR_PROPERTY__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__SETTABLE = CG_EXECUTOR_PROPERTY__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__TRUE = CG_EXECUTOR_PROPERTY__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__UNBOXED = CG_EXECUTOR_PROPERTY__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__VALUE = CG_EXECUTOR_PROPERTY__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__VALUE_NAME = CG_EXECUTOR_PROPERTY__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Underlying Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY__UNDERLYING_PROPERTY_ID = CG_EXECUTOR_PROPERTY__UNDERLYING_PROPERTY_ID;

	/**
	 * The number of structural features of the '<em>CG Executor Opposite Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY_FEATURE_COUNT = CG_EXECUTOR_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY___SET_NON_INVALID = CG_EXECUTOR_PROPERTY___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY___SET_NON_NULL = CG_EXECUTOR_PROPERTY___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Executor Opposite Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPPOSITE_PROPERTY_OPERATION_COUNT = CG_EXECUTOR_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Underlying Operation Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION__UNDERLYING_OPERATION_ID = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Executor Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Executor Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__PARENT = CG_OPERATION_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__NAME = CG_OPERATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__PIVOT = CG_OPERATION_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__PIVOT_TYPE_ID = CG_OPERATION_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__TYPE_ID = CG_OPERATION_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__REQUIRED = CG_OPERATION_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__BOXED = CG_OPERATION_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__CAUGHT = CG_OPERATION_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__CONSTANT = CG_OPERATION_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__DEPENDS_ON = CG_OPERATION_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__FALSE = CG_OPERATION_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__GLOBAL = CG_OPERATION_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__INLINEABLE = CG_OPERATION_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__INVALID = CG_OPERATION_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__NULL = CG_OPERATION_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__NON_INVALID = CG_OPERATION_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__NON_NULL = CG_OPERATION_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_OPERATION_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__SETTABLE = CG_OPERATION_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__TRUE = CG_OPERATION_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__UNBOXED = CG_OPERATION_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__VALUE = CG_OPERATION_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__VALUE_NAME = CG_OPERATION_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__INVALIDATING = CG_OPERATION_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__VALIDATING = CG_OPERATION_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__SOURCE = CG_OPERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__REFERRED_OPERATION = CG_OPERATION_CALL_EXP__REFERRED_OPERATION;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__ARGUMENTS = CG_OPERATION_CALL_EXP__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Executor Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP__EXECUTOR_OPERATION = CG_OPERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Executor Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP_FEATURE_COUNT = CG_OPERATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP___SET_NON_INVALID = CG_OPERATION_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP___SET_NON_NULL = CG_OPERATION_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Executor Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_OPERATION_CALL_EXP_OPERATION_COUNT = CG_OPERATION_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__PARENT = CG_PROPERTY_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__NAME = CG_PROPERTY_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__PIVOT = CG_PROPERTY_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__PIVOT_TYPE_ID = CG_PROPERTY_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__TYPE_ID = CG_PROPERTY_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__REQUIRED = CG_PROPERTY_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__BOXED = CG_PROPERTY_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__CAUGHT = CG_PROPERTY_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__CONSTANT = CG_PROPERTY_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__DEPENDS_ON = CG_PROPERTY_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__FALSE = CG_PROPERTY_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__GLOBAL = CG_PROPERTY_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__INLINEABLE = CG_PROPERTY_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__INVALID = CG_PROPERTY_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__NULL = CG_PROPERTY_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__NON_INVALID = CG_PROPERTY_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__NON_NULL = CG_PROPERTY_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_PROPERTY_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__SETTABLE = CG_PROPERTY_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__TRUE = CG_PROPERTY_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__UNBOXED = CG_PROPERTY_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__VALUE = CG_PROPERTY_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__VALUE_NAME = CG_PROPERTY_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__INVALIDATING = CG_PROPERTY_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__VALIDATING = CG_PROPERTY_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__SOURCE = CG_PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__REFERRED_PROPERTY = CG_PROPERTY_CALL_EXP__REFERRED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Executor Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP__EXECUTOR_PROPERTY = CG_PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Executor Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP_FEATURE_COUNT = CG_PROPERTY_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP___SET_NON_INVALID = CG_PROPERTY_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP___SET_NON_NULL = CG_PROPERTY_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Executor Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_PROPERTY_CALL_EXP_OPERATION_COUNT = CG_PROPERTY_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Underlying Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE__UNDERLYING_TYPE_ID = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Executor Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Executor Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_EXECUTOR_TYPE_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__PARENT = CG_VARIABLE__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__NAME = CG_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__PIVOT = CG_VARIABLE__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__PIVOT_TYPE_ID = CG_VARIABLE__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__TYPE_ID = CG_VARIABLE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__REQUIRED = CG_VARIABLE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__BOXED = CG_VARIABLE__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__CAUGHT = CG_VARIABLE__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__CONSTANT = CG_VARIABLE__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__DEPENDS_ON = CG_VARIABLE__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__FALSE = CG_VARIABLE__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__GLOBAL = CG_VARIABLE__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__INLINEABLE = CG_VARIABLE__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__INVALID = CG_VARIABLE__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__NULL = CG_VARIABLE__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__NON_INVALID = CG_VARIABLE__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__NON_NULL = CG_VARIABLE__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__REFERRED_VALUED_ELEMENT = CG_VARIABLE__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__SETTABLE = CG_VARIABLE__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__TRUE = CG_VARIABLE__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__UNBOXED = CG_VARIABLE__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__VALUE = CG_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__VALUE_NAME = CG_VARIABLE__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE__INIT = CG_VARIABLE__INIT;

	/**
	 * The number of structural features of the '<em>CG Final Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE_FEATURE_COUNT = CG_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE___SET_NON_INVALID = CG_VARIABLE___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE___SET_NON_NULL = CG_VARIABLE___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Final Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FINAL_VARIABLE_OPERATION_COUNT = CG_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__PARENT = CG_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__NAME = CG_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__PIVOT = CG_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__PIVOT_TYPE_ID = CG_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__TYPE_ID = CG_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__REQUIRED = CG_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__BOXED = CG_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__CAUGHT = CG_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__CONSTANT = CG_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__DEPENDS_ON = CG_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__FALSE = CG_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__GLOBAL = CG_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__INLINEABLE = CG_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__INVALID = CG_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__NULL = CG_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__NON_INVALID = CG_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__NON_NULL = CG_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__REFERRED_VALUED_ELEMENT = CG_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__SETTABLE = CG_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__TRUE = CG_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__UNBOXED = CG_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__VALUE = CG_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__VALUE_NAME = CG_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__INVALIDATING = CG_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__VALIDATING = CG_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP__SOURCE = CG_CALL_EXP__SOURCE;

	/**
	 * The number of structural features of the '<em>CG Guard Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP_FEATURE_COUNT = CG_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP___SET_NON_INVALID = CG_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP___SET_NON_NULL = CG_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Guard Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_EXP_OPERATION_COUNT = CG_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__CONDITION = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__THEN_EXPRESSION = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP__ELSE_EXPRESSION = CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CG If Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG If Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IF_EXP_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__PARENT = CG_CONSTANT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__NAME = CG_CONSTANT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__PIVOT = CG_CONSTANT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__PIVOT_TYPE_ID = CG_CONSTANT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__TYPE_ID = CG_CONSTANT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__REQUIRED = CG_CONSTANT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__BOXED = CG_CONSTANT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__CAUGHT = CG_CONSTANT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__CONSTANT = CG_CONSTANT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__DEPENDS_ON = CG_CONSTANT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__FALSE = CG_CONSTANT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__GLOBAL = CG_CONSTANT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__INLINEABLE = CG_CONSTANT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__INVALID = CG_CONSTANT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__NULL = CG_CONSTANT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__NON_INVALID = CG_CONSTANT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__NON_NULL = CG_CONSTANT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__REFERRED_VALUED_ELEMENT = CG_CONSTANT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__SETTABLE = CG_CONSTANT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__TRUE = CG_CONSTANT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__UNBOXED = CG_CONSTANT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__VALUE = CG_CONSTANT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__VALUE_NAME = CG_CONSTANT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY__CONSTANT_VALUE = CG_CONSTANT__CONSTANT_VALUE;

	/**
	 * The number of structural features of the '<em>CG Infinity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY_FEATURE_COUNT = CG_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY___SET_NON_INVALID = CG_CONSTANT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY___SET_NON_NULL = CG_CONSTANT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Infinity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INFINITY_OPERATION_COUNT = CG_CONSTANT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__PARENT = CG_CONSTANT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__NAME = CG_CONSTANT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__PIVOT = CG_CONSTANT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__PIVOT_TYPE_ID = CG_CONSTANT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__TYPE_ID = CG_CONSTANT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__REQUIRED = CG_CONSTANT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__BOXED = CG_CONSTANT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__CAUGHT = CG_CONSTANT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__CONSTANT = CG_CONSTANT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__DEPENDS_ON = CG_CONSTANT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__FALSE = CG_CONSTANT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__GLOBAL = CG_CONSTANT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__INLINEABLE = CG_CONSTANT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__INVALID = CG_CONSTANT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__NULL = CG_CONSTANT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__NON_INVALID = CG_CONSTANT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__NON_NULL = CG_CONSTANT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__REFERRED_VALUED_ELEMENT = CG_CONSTANT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__SETTABLE = CG_CONSTANT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__TRUE = CG_CONSTANT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__UNBOXED = CG_CONSTANT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__VALUE = CG_CONSTANT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__VALUE_NAME = CG_CONSTANT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__CONSTANT_VALUE = CG_CONSTANT__CONSTANT_VALUE;

	/**
	 * The feature id for the '<em><b>Integer Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER__INTEGER_VALUE = CG_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER_FEATURE_COUNT = CG_CONSTANT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER___SET_NON_INVALID = CG_CONSTANT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER___SET_NON_NULL = CG_CONSTANT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INTEGER_OPERATION_COUNT = CG_CONSTANT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__PARENT = CG_CONSTANT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__NAME = CG_CONSTANT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__PIVOT = CG_CONSTANT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__PIVOT_TYPE_ID = CG_CONSTANT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__TYPE_ID = CG_CONSTANT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__REQUIRED = CG_CONSTANT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__BOXED = CG_CONSTANT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__CAUGHT = CG_CONSTANT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__CONSTANT = CG_CONSTANT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__DEPENDS_ON = CG_CONSTANT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__FALSE = CG_CONSTANT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__GLOBAL = CG_CONSTANT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__INLINEABLE = CG_CONSTANT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__INVALID = CG_CONSTANT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__NULL = CG_CONSTANT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__NON_INVALID = CG_CONSTANT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__NON_NULL = CG_CONSTANT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__REFERRED_VALUED_ELEMENT = CG_CONSTANT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__SETTABLE = CG_CONSTANT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__TRUE = CG_CONSTANT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__UNBOXED = CG_CONSTANT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__VALUE = CG_CONSTANT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__VALUE_NAME = CG_CONSTANT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__CONSTANT_VALUE = CG_CONSTANT__CONSTANT_VALUE;

	/**
	 * The feature id for the '<em><b>Message Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__MESSAGE_TEMPLATE = CG_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID__BINDINGS = CG_CONSTANT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Invalid</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID_FEATURE_COUNT = CG_CONSTANT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID___SET_NON_INVALID = CG_CONSTANT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID___SET_NON_NULL = CG_CONSTANT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Invalid</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_INVALID_OPERATION_COUNT = CG_CONSTANT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIsInvalidExpImpl <em>CG Is Invalid Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIsInvalidExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGIsInvalidExp()
	 * @generated
	 */
	int CG_IS_INVALID_EXP = 35;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__PARENT = CG_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__NAME = CG_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__PIVOT = CG_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__PIVOT_TYPE_ID = CG_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__TYPE_ID = CG_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__REQUIRED = CG_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__BOXED = CG_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__CAUGHT = CG_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__CONSTANT = CG_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__DEPENDS_ON = CG_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__FALSE = CG_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__GLOBAL = CG_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__INLINEABLE = CG_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__INVALID = CG_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__NULL = CG_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__NON_INVALID = CG_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__NON_NULL = CG_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__REFERRED_VALUED_ELEMENT = CG_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__SETTABLE = CG_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__TRUE = CG_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__UNBOXED = CG_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__VALUE = CG_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__VALUE_NAME = CG_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__INVALIDATING = CG_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__VALIDATING = CG_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP__SOURCE = CG_CALL_EXP__SOURCE;

	/**
	 * The number of structural features of the '<em>CG Is Invalid Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP_FEATURE_COUNT = CG_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP___SET_NON_INVALID = CG_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP___SET_NON_NULL = CG_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Is Invalid Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_INVALID_EXP_OPERATION_COUNT = CG_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIsUndefinedExpImpl <em>CG Is Undefined Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIsUndefinedExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGIsUndefinedExp()
	 * @generated
	 */
	int CG_IS_UNDEFINED_EXP = 36;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__PARENT = CG_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__NAME = CG_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__PIVOT = CG_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__PIVOT_TYPE_ID = CG_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__TYPE_ID = CG_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__REQUIRED = CG_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__BOXED = CG_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__CAUGHT = CG_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__CONSTANT = CG_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__DEPENDS_ON = CG_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__FALSE = CG_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__GLOBAL = CG_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__INLINEABLE = CG_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__INVALID = CG_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__NULL = CG_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__NON_INVALID = CG_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__NON_NULL = CG_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__REFERRED_VALUED_ELEMENT = CG_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__SETTABLE = CG_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__TRUE = CG_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__UNBOXED = CG_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__VALUE = CG_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__VALUE_NAME = CG_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__INVALIDATING = CG_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__VALIDATING = CG_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP__SOURCE = CG_CALL_EXP__SOURCE;

	/**
	 * The number of structural features of the '<em>CG Is Undefined Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP_FEATURE_COUNT = CG_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP___SET_NON_INVALID = CG_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP___SET_NON_NULL = CG_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Is Undefined Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_IS_UNDEFINED_EXP_OPERATION_COUNT = CG_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__PARENT = CG_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__NAME = CG_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__PIVOT = CG_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__PIVOT_TYPE_ID = CG_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__TYPE_ID = CG_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__REQUIRED = CG_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__BOXED = CG_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__CAUGHT = CG_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__CONSTANT = CG_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__DEPENDS_ON = CG_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__FALSE = CG_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__GLOBAL = CG_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__INLINEABLE = CG_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__INVALID = CG_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__NULL = CG_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__NON_INVALID = CG_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__NON_NULL = CG_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__SETTABLE = CG_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__TRUE = CG_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__UNBOXED = CG_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__VALUE = CG_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__VALUE_NAME = CG_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__INVALIDATING = CG_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__VALIDATING = CG_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__SOURCE = CG_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__REFERRED_ITERATION = CG_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__ITERATORS = CG_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP__BODY = CG_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CG Iteration Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP_FEATURE_COUNT = CG_CALL_EXP_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP___SET_NON_INVALID = CG_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP___SET_NON_NULL = CG_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Iteration Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATION_CALL_EXP_OPERATION_COUNT = CG_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIteratorImpl <em>CG Iterator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIteratorImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGIterator()
	 * @generated
	 */
	int CG_ITERATOR = 38;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__PARENT = CG_PARAMETER__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__NAME = CG_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__PIVOT = CG_PARAMETER__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__PIVOT_TYPE_ID = CG_PARAMETER__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__TYPE_ID = CG_PARAMETER__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__REQUIRED = CG_PARAMETER__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__BOXED = CG_PARAMETER__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__CAUGHT = CG_PARAMETER__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__CONSTANT = CG_PARAMETER__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__DEPENDS_ON = CG_PARAMETER__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__FALSE = CG_PARAMETER__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__GLOBAL = CG_PARAMETER__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__INLINEABLE = CG_PARAMETER__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__INVALID = CG_PARAMETER__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__NULL = CG_PARAMETER__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__NON_INVALID = CG_PARAMETER__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__NON_NULL = CG_PARAMETER__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__REFERRED_VALUED_ELEMENT = CG_PARAMETER__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__SETTABLE = CG_PARAMETER__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__TRUE = CG_PARAMETER__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__UNBOXED = CG_PARAMETER__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__VALUE = CG_PARAMETER__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__VALUE_NAME = CG_PARAMETER__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__INIT = CG_PARAMETER__INIT;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR__OPERATION = CG_PARAMETER__OPERATION;

	/**
	 * The number of structural features of the '<em>CG Iterator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR_FEATURE_COUNT = CG_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR___SET_NON_INVALID = CG_PARAMETER___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR___SET_NON_NULL = CG_PARAMETER___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Iterator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ITERATOR_OPERATION_COUNT = CG_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__INIT = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP__IN = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Let Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Let Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LET_EXP_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__PARENT = CG_ITERATION_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__NAME = CG_ITERATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__PIVOT = CG_ITERATION_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__PIVOT_TYPE_ID = CG_ITERATION_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__TYPE_ID = CG_ITERATION_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__REQUIRED = CG_ITERATION_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__BOXED = CG_ITERATION_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__CAUGHT = CG_ITERATION_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__CONSTANT = CG_ITERATION_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__DEPENDS_ON = CG_ITERATION_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__FALSE = CG_ITERATION_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__GLOBAL = CG_ITERATION_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__INLINEABLE = CG_ITERATION_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__INVALID = CG_ITERATION_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__NULL = CG_ITERATION_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__NON_INVALID = CG_ITERATION_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__NON_NULL = CG_ITERATION_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_ITERATION_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__SETTABLE = CG_ITERATION_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__TRUE = CG_ITERATION_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__UNBOXED = CG_ITERATION_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__VALUE = CG_ITERATION_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__VALUE_NAME = CG_ITERATION_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__INVALIDATING = CG_ITERATION_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__VALIDATING = CG_ITERATION_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__SOURCE = CG_ITERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__REFERRED_ITERATION = CG_ITERATION_CALL_EXP__REFERRED_ITERATION;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__ITERATORS = CG_ITERATION_CALL_EXP__ITERATORS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__BODY = CG_ITERATION_CALL_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Library Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__LIBRARY_ITERATION = CG_ITERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP__RESULT = CG_ITERATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Library Iterate Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP_FEATURE_COUNT = CG_ITERATION_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP___SET_NON_INVALID = CG_ITERATION_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP___SET_NON_NULL = CG_ITERATION_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Library Iterate Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATE_CALL_EXP_OPERATION_COUNT = CG_ITERATION_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__PARENT = CG_ITERATION_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__NAME = CG_ITERATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__PIVOT = CG_ITERATION_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__PIVOT_TYPE_ID = CG_ITERATION_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__TYPE_ID = CG_ITERATION_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__REQUIRED = CG_ITERATION_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__BOXED = CG_ITERATION_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__CAUGHT = CG_ITERATION_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__CONSTANT = CG_ITERATION_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__DEPENDS_ON = CG_ITERATION_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__FALSE = CG_ITERATION_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__GLOBAL = CG_ITERATION_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__INLINEABLE = CG_ITERATION_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__INVALID = CG_ITERATION_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__NULL = CG_ITERATION_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__NON_INVALID = CG_ITERATION_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__NON_NULL = CG_ITERATION_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_ITERATION_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__SETTABLE = CG_ITERATION_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__TRUE = CG_ITERATION_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__UNBOXED = CG_ITERATION_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__VALUE = CG_ITERATION_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__VALUE_NAME = CG_ITERATION_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__INVALIDATING = CG_ITERATION_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__VALIDATING = CG_ITERATION_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__SOURCE = CG_ITERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__REFERRED_ITERATION = CG_ITERATION_CALL_EXP__REFERRED_ITERATION;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__ITERATORS = CG_ITERATION_CALL_EXP__ITERATORS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__BODY = CG_ITERATION_CALL_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Library Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP__LIBRARY_ITERATION = CG_ITERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Library Iteration Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP_FEATURE_COUNT = CG_ITERATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP___SET_NON_INVALID = CG_ITERATION_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP___SET_NON_NULL = CG_ITERATION_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Library Iteration Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_ITERATION_CALL_EXP_OPERATION_COUNT = CG_ITERATION_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__PARENT = CG_OPERATION_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__NAME = CG_OPERATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__PIVOT = CG_OPERATION_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__PIVOT_TYPE_ID = CG_OPERATION_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__TYPE_ID = CG_OPERATION_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__REQUIRED = CG_OPERATION_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__BOXED = CG_OPERATION_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__CAUGHT = CG_OPERATION_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__CONSTANT = CG_OPERATION_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__DEPENDS_ON = CG_OPERATION_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__FALSE = CG_OPERATION_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__GLOBAL = CG_OPERATION_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__INLINEABLE = CG_OPERATION_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__INVALID = CG_OPERATION_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__NULL = CG_OPERATION_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__NON_INVALID = CG_OPERATION_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__NON_NULL = CG_OPERATION_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_OPERATION_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__SETTABLE = CG_OPERATION_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__TRUE = CG_OPERATION_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__UNBOXED = CG_OPERATION_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__VALUE = CG_OPERATION_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__VALUE_NAME = CG_OPERATION_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__INVALIDATING = CG_OPERATION_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__VALIDATING = CG_OPERATION_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__SOURCE = CG_OPERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__REFERRED_OPERATION = CG_OPERATION_CALL_EXP__REFERRED_OPERATION;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__ARGUMENTS = CG_OPERATION_CALL_EXP__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Library Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP__LIBRARY_OPERATION = CG_OPERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Library Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP_FEATURE_COUNT = CG_OPERATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP___SET_NON_INVALID = CG_OPERATION_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP___SET_NON_NULL = CG_OPERATION_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Library Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_OPERATION_CALL_EXP_OPERATION_COUNT = CG_OPERATION_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__PARENT = CG_PROPERTY_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__NAME = CG_PROPERTY_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__PIVOT = CG_PROPERTY_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__PIVOT_TYPE_ID = CG_PROPERTY_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__TYPE_ID = CG_PROPERTY_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__REQUIRED = CG_PROPERTY_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__BOXED = CG_PROPERTY_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__CAUGHT = CG_PROPERTY_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__CONSTANT = CG_PROPERTY_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__DEPENDS_ON = CG_PROPERTY_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__FALSE = CG_PROPERTY_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__GLOBAL = CG_PROPERTY_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__INLINEABLE = CG_PROPERTY_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__INVALID = CG_PROPERTY_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__NULL = CG_PROPERTY_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__NON_INVALID = CG_PROPERTY_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__NON_NULL = CG_PROPERTY_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_PROPERTY_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__SETTABLE = CG_PROPERTY_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__TRUE = CG_PROPERTY_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__UNBOXED = CG_PROPERTY_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__VALUE = CG_PROPERTY_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__VALUE_NAME = CG_PROPERTY_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__INVALIDATING = CG_PROPERTY_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__VALIDATING = CG_PROPERTY_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__SOURCE = CG_PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__REFERRED_PROPERTY = CG_PROPERTY_CALL_EXP__REFERRED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Library Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP__LIBRARY_PROPERTY = CG_PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Library Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP_FEATURE_COUNT = CG_PROPERTY_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP___SET_NON_INVALID = CG_PROPERTY_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP___SET_NON_NULL = CG_PROPERTY_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Library Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LIBRARY_PROPERTY_CALL_EXP_OPERATION_COUNT = CG_PROPERTY_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__PARENT = CG_VARIABLE__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__NAME = CG_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__PIVOT = CG_VARIABLE__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__PIVOT_TYPE_ID = CG_VARIABLE__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__TYPE_ID = CG_VARIABLE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__REQUIRED = CG_VARIABLE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__BOXED = CG_VARIABLE__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__CAUGHT = CG_VARIABLE__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__CONSTANT = CG_VARIABLE__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__DEPENDS_ON = CG_VARIABLE__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__FALSE = CG_VARIABLE__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__GLOBAL = CG_VARIABLE__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__INLINEABLE = CG_VARIABLE__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__INVALID = CG_VARIABLE__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__NULL = CG_VARIABLE__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__NON_INVALID = CG_VARIABLE__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__NON_NULL = CG_VARIABLE__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__REFERRED_VALUED_ELEMENT = CG_VARIABLE__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__SETTABLE = CG_VARIABLE__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__TRUE = CG_VARIABLE__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__UNBOXED = CG_VARIABLE__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__VALUE = CG_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__VALUE_NAME = CG_VARIABLE__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE__INIT = CG_VARIABLE__INIT;

	/**
	 * The number of structural features of the '<em>CG Local Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE_FEATURE_COUNT = CG_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE___SET_NON_INVALID = CG_VARIABLE___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE___SET_NON_NULL = CG_VARIABLE___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Local Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_LOCAL_VARIABLE_OPERATION_COUNT = CG_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MODEL__PARENT = CG_NAMED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MODEL__NAME = CG_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MODEL__PIVOT = CG_NAMED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Globals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MODEL__GLOBALS = CG_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MODEL__PACKAGES = CG_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MODEL_FEATURE_COUNT = CG_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>CG Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MODEL_OPERATION_COUNT = CG_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__PARENT = CG_CONSTANT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__NAME = CG_CONSTANT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__PIVOT = CG_CONSTANT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__PIVOT_TYPE_ID = CG_CONSTANT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__TYPE_ID = CG_CONSTANT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__REQUIRED = CG_CONSTANT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__BOXED = CG_CONSTANT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__CAUGHT = CG_CONSTANT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__CONSTANT = CG_CONSTANT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__DEPENDS_ON = CG_CONSTANT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__FALSE = CG_CONSTANT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__GLOBAL = CG_CONSTANT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__INLINEABLE = CG_CONSTANT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__INVALID = CG_CONSTANT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__NULL = CG_CONSTANT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__NON_INVALID = CG_CONSTANT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__NON_NULL = CG_CONSTANT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__REFERRED_VALUED_ELEMENT = CG_CONSTANT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__SETTABLE = CG_CONSTANT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__TRUE = CG_CONSTANT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__UNBOXED = CG_CONSTANT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__VALUE = CG_CONSTANT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__VALUE_NAME = CG_CONSTANT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL__CONSTANT_VALUE = CG_CONSTANT__CONSTANT_VALUE;

	/**
	 * The number of structural features of the '<em>CG Null</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL_FEATURE_COUNT = CG_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL___SET_NON_INVALID = CG_CONSTANT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL___SET_NON_NULL = CG_CONSTANT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Null</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_NULL_OPERATION_COUNT = CG_CONSTANT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION__PARENT = CG_TYPED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION__NAME = CG_TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION__PIVOT = CG_TYPED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION__PIVOT_TYPE_ID = CG_TYPED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION__TYPE_ID = CG_TYPED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION__REQUIRED = CG_TYPED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION__PARAMETERS = CG_TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION__BODY = CG_TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION__PRECONDITIONS = CG_TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION__POSTCONDITIONS = CG_TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Containing Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION__CONTAINING_CLASS = CG_TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>CG Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_FEATURE_COUNT = CG_TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>CG Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_OPERATION_OPERATION_COUNT = CG_TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PACKAGE__PARENT = CG_NAMED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PACKAGE__NAME = CG_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PACKAGE__PIVOT = CG_NAMED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PACKAGE__CLASSES = CG_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PACKAGE__PACKAGES = CG_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PACKAGE__CONTAINING_PACKAGE = CG_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CG Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PACKAGE_FEATURE_COUNT = CG_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>CG Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PACKAGE_OPERATION_COUNT = CG_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY__PARENT = CG_TYPED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY__NAME = CG_TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY__PIVOT = CG_TYPED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY__PIVOT_TYPE_ID = CG_TYPED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY__TYPE_ID = CG_TYPED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY__REQUIRED = CG_TYPED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Containing Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY__CONTAINING_CLASS = CG_TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY__BODY = CG_TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_FEATURE_COUNT = CG_TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>CG Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_OPERATION_COUNT = CG_TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__PARENT = CG_CONSTANT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__NAME = CG_CONSTANT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__PIVOT = CG_CONSTANT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__PIVOT_TYPE_ID = CG_CONSTANT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__TYPE_ID = CG_CONSTANT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__REQUIRED = CG_CONSTANT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__BOXED = CG_CONSTANT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__CAUGHT = CG_CONSTANT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__CONSTANT = CG_CONSTANT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__DEPENDS_ON = CG_CONSTANT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__FALSE = CG_CONSTANT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__GLOBAL = CG_CONSTANT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__INLINEABLE = CG_CONSTANT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__INVALID = CG_CONSTANT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__NULL = CG_CONSTANT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__NON_INVALID = CG_CONSTANT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__NON_NULL = CG_CONSTANT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__REFERRED_VALUED_ELEMENT = CG_CONSTANT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__SETTABLE = CG_CONSTANT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__TRUE = CG_CONSTANT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__UNBOXED = CG_CONSTANT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__VALUE = CG_CONSTANT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__VALUE_NAME = CG_CONSTANT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__CONSTANT_VALUE = CG_CONSTANT__CONSTANT_VALUE;

	/**
	 * The feature id for the '<em><b>Real Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL__REAL_VALUE = CG_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Real</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL_FEATURE_COUNT = CG_CONSTANT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL___SET_NON_INVALID = CG_CONSTANT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL___SET_NON_NULL = CG_CONSTANT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Real</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REAL_OPERATION_COUNT = CG_CONSTANT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__PARENT = CG_VARIABLE__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__NAME = CG_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__PIVOT = CG_VARIABLE__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__PIVOT_TYPE_ID = CG_VARIABLE__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__TYPE_ID = CG_VARIABLE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__REQUIRED = CG_VARIABLE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__BOXED = CG_VARIABLE__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__CAUGHT = CG_VARIABLE__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__CONSTANT = CG_VARIABLE__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__DEPENDS_ON = CG_VARIABLE__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__FALSE = CG_VARIABLE__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__GLOBAL = CG_VARIABLE__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__INLINEABLE = CG_VARIABLE__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__INVALID = CG_VARIABLE__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__NULL = CG_VARIABLE__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__NON_INVALID = CG_VARIABLE__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__NON_NULL = CG_VARIABLE__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__REFERRED_VALUED_ELEMENT = CG_VARIABLE__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__SETTABLE = CG_VARIABLE__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__TRUE = CG_VARIABLE__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__UNBOXED = CG_VARIABLE__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__VALUE = CG_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__VALUE_NAME = CG_VARIABLE__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE__INIT = CG_VARIABLE__INIT;

	/**
	 * The number of structural features of the '<em>CG Settable Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE_FEATURE_COUNT = CG_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE___SET_NON_INVALID = CG_VARIABLE___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE___SET_NON_NULL = CG_VARIABLE___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Settable Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SETTABLE_VARIABLE_OPERATION_COUNT = CG_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__PARENT = CG_CONSTANT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__NAME = CG_CONSTANT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__PIVOT = CG_CONSTANT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__PIVOT_TYPE_ID = CG_CONSTANT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__TYPE_ID = CG_CONSTANT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__REQUIRED = CG_CONSTANT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__BOXED = CG_CONSTANT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__CAUGHT = CG_CONSTANT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__CONSTANT = CG_CONSTANT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__DEPENDS_ON = CG_CONSTANT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__FALSE = CG_CONSTANT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__GLOBAL = CG_CONSTANT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__INLINEABLE = CG_CONSTANT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__INVALID = CG_CONSTANT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__NULL = CG_CONSTANT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__NON_INVALID = CG_CONSTANT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__NON_NULL = CG_CONSTANT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__REFERRED_VALUED_ELEMENT = CG_CONSTANT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__SETTABLE = CG_CONSTANT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__TRUE = CG_CONSTANT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__UNBOXED = CG_CONSTANT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__VALUE = CG_CONSTANT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__VALUE_NAME = CG_CONSTANT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__CONSTANT_VALUE = CG_CONSTANT__CONSTANT_VALUE;

	/**
	 * The feature id for the '<em><b>String Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING__STRING_VALUE = CG_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING_FEATURE_COUNT = CG_CONSTANT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING___SET_NON_INVALID = CG_CONSTANT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING___SET_NON_NULL = CG_CONSTANT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_STRING_OPERATION_COUNT = CG_CONSTANT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__PARENT = CG_CONSTANT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__NAME = CG_CONSTANT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__PIVOT = CG_CONSTANT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__PIVOT_TYPE_ID = CG_CONSTANT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__TYPE_ID = CG_CONSTANT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__REQUIRED = CG_CONSTANT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__BOXED = CG_CONSTANT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__CAUGHT = CG_CONSTANT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__CONSTANT = CG_CONSTANT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__DEPENDS_ON = CG_CONSTANT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__FALSE = CG_CONSTANT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__GLOBAL = CG_CONSTANT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__INLINEABLE = CG_CONSTANT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__INVALID = CG_CONSTANT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__NULL = CG_CONSTANT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__NON_INVALID = CG_CONSTANT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__NON_NULL = CG_CONSTANT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__REFERRED_VALUED_ELEMENT = CG_CONSTANT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__SETTABLE = CG_CONSTANT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__TRUE = CG_CONSTANT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__UNBOXED = CG_CONSTANT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__VALUE = CG_CONSTANT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__VALUE_NAME = CG_CONSTANT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__CONSTANT_VALUE = CG_CONSTANT__CONSTANT_VALUE;

	/**
	 * The feature id for the '<em><b>Text Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT__TEXT_VALUE = CG_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_FEATURE_COUNT = CG_CONSTANT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT___SET_NON_INVALID = CG_CONSTANT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT___SET_NON_NULL = CG_CONSTANT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_OPERATION_COUNT = CG_CONSTANT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTextParameterImpl <em>CG Text Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTextParameterImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTextParameter()
	 * @generated
	 */
	int CG_TEXT_PARAMETER = 58;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__PARENT = CG_PARAMETER__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__NAME = CG_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__PIVOT = CG_PARAMETER__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__PIVOT_TYPE_ID = CG_PARAMETER__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__TYPE_ID = CG_PARAMETER__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__REQUIRED = CG_PARAMETER__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__BOXED = CG_PARAMETER__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__CAUGHT = CG_PARAMETER__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__CONSTANT = CG_PARAMETER__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__DEPENDS_ON = CG_PARAMETER__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__FALSE = CG_PARAMETER__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__GLOBAL = CG_PARAMETER__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__INLINEABLE = CG_PARAMETER__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__INVALID = CG_PARAMETER__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__NULL = CG_PARAMETER__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__NON_INVALID = CG_PARAMETER__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__NON_NULL = CG_PARAMETER__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__REFERRED_VALUED_ELEMENT = CG_PARAMETER__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__SETTABLE = CG_PARAMETER__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__TRUE = CG_PARAMETER__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__UNBOXED = CG_PARAMETER__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__VALUE = CG_PARAMETER__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__VALUE_NAME = CG_PARAMETER__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__INIT = CG_PARAMETER__INIT;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__OPERATION = CG_PARAMETER__OPERATION;

	/**
	 * The feature id for the '<em><b>Text Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER__TEXT_VALUE = CG_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Text Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER_FEATURE_COUNT = CG_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER___SET_NON_INVALID = CG_PARAMETER___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER___SET_NON_NULL = CG_PARAMETER___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Text Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TEXT_PARAMETER_OPERATION_COUNT = CG_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__PARENT = CG_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__NAME = CG_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__PIVOT = CG_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__PIVOT_TYPE_ID = CG_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__TYPE_ID = CG_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__REQUIRED = CG_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__BOXED = CG_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__CAUGHT = CG_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__CONSTANT = CG_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__DEPENDS_ON = CG_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__FALSE = CG_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__GLOBAL = CG_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__INLINEABLE = CG_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__INVALID = CG_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__NULL = CG_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__NON_INVALID = CG_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__NON_NULL = CG_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__REFERRED_VALUED_ELEMENT = CG_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__SETTABLE = CG_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__TRUE = CG_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__UNBOXED = CG_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__VALUE = CG_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__VALUE_NAME = CG_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__INVALIDATING = CG_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__VALIDATING = CG_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP__SOURCE = CG_CALL_EXP__SOURCE;

	/**
	 * The number of structural features of the '<em>CG Throw Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP_FEATURE_COUNT = CG_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP___SET_NON_INVALID = CG_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP___SET_NON_NULL = CG_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Throw Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_THROW_EXP_OPERATION_COUNT = CG_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP__PARTS = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Tuple Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Tuple Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_EXP_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__INIT = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tuple Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART__TUPLE_EXP = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Tuple Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Tuple Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTuplePartCallExpImpl <em>CG Tuple Part Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTuplePartCallExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTuplePartCallExp()
	 * @generated
	 */
	int CG_TUPLE_PART_CALL_EXP = 62;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__PARENT = CG_PROPERTY_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__NAME = CG_PROPERTY_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__PIVOT = CG_PROPERTY_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__PIVOT_TYPE_ID = CG_PROPERTY_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__TYPE_ID = CG_PROPERTY_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__REQUIRED = CG_PROPERTY_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__BOXED = CG_PROPERTY_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__CAUGHT = CG_PROPERTY_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__CONSTANT = CG_PROPERTY_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__DEPENDS_ON = CG_PROPERTY_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__FALSE = CG_PROPERTY_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__GLOBAL = CG_PROPERTY_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__INLINEABLE = CG_PROPERTY_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__INVALID = CG_PROPERTY_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__NULL = CG_PROPERTY_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__NON_INVALID = CG_PROPERTY_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__NON_NULL = CG_PROPERTY_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__REFERRED_VALUED_ELEMENT = CG_PROPERTY_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__SETTABLE = CG_PROPERTY_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__TRUE = CG_PROPERTY_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__UNBOXED = CG_PROPERTY_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__VALUE = CG_PROPERTY_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__VALUE_NAME = CG_PROPERTY_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__INVALIDATING = CG_PROPERTY_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__VALIDATING = CG_PROPERTY_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__SOURCE = CG_PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__REFERRED_PROPERTY = CG_PROPERTY_CALL_EXP__REFERRED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Pivot Tuple Part Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP__PIVOT_TUPLE_PART_ID = CG_PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Tuple Part Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP_FEATURE_COUNT = CG_PROPERTY_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP___SET_NON_INVALID = CG_PROPERTY_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP___SET_NON_NULL = CG_PROPERTY_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Tuple Part Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TUPLE_PART_CALL_EXP_OPERATION_COUNT = CG_PROPERTY_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__PARENT = CG_ELEMENT_ID__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__NAME = CG_ELEMENT_ID__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__PIVOT = CG_ELEMENT_ID__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__PIVOT_TYPE_ID = CG_ELEMENT_ID__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__TYPE_ID = CG_ELEMENT_ID__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__REQUIRED = CG_ELEMENT_ID__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__BOXED = CG_ELEMENT_ID__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__CAUGHT = CG_ELEMENT_ID__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__CONSTANT = CG_ELEMENT_ID__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__DEPENDS_ON = CG_ELEMENT_ID__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__FALSE = CG_ELEMENT_ID__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__GLOBAL = CG_ELEMENT_ID__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__INLINEABLE = CG_ELEMENT_ID__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__INVALID = CG_ELEMENT_ID__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__NULL = CG_ELEMENT_ID__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__NON_INVALID = CG_ELEMENT_ID__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__NON_NULL = CG_ELEMENT_ID__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__REFERRED_VALUED_ELEMENT = CG_ELEMENT_ID__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__SETTABLE = CG_ELEMENT_ID__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__TRUE = CG_ELEMENT_ID__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__UNBOXED = CG_ELEMENT_ID__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__VALUE = CG_ELEMENT_ID__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__VALUE_NAME = CG_ELEMENT_ID__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__CONSTANT_VALUE = CG_ELEMENT_ID__CONSTANT_VALUE;

	/**
	 * The feature id for the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID__ELEMENT_ID = CG_ELEMENT_ID__ELEMENT_ID;

	/**
	 * The number of structural features of the '<em>CG Type Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID_FEATURE_COUNT = CG_ELEMENT_ID_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID___SET_NON_INVALID = CG_ELEMENT_ID___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID___SET_NON_NULL = CG_ELEMENT_ID___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Type Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_ID_OPERATION_COUNT = CG_ELEMENT_ID_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Referred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP__REFERRED_TYPE = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Type Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Type Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPE_EXP_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGUnboxExpImpl <em>CG Unbox Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGUnboxExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGUnboxExp()
	 * @generated
	 */
	int CG_UNBOX_EXP = 66;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__PARENT = CG_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__NAME = CG_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__PIVOT = CG_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__PIVOT_TYPE_ID = CG_CALL_EXP__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__TYPE_ID = CG_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__REQUIRED = CG_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__BOXED = CG_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__CAUGHT = CG_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__CONSTANT = CG_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__DEPENDS_ON = CG_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__FALSE = CG_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__GLOBAL = CG_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__INLINEABLE = CG_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__INVALID = CG_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__NULL = CG_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__NON_INVALID = CG_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__NON_NULL = CG_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__REFERRED_VALUED_ELEMENT = CG_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__SETTABLE = CG_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__TRUE = CG_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__UNBOXED = CG_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__VALUE = CG_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__VALUE_NAME = CG_CALL_EXP__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__INVALIDATING = CG_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__VALIDATING = CG_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP__SOURCE = CG_CALL_EXP__SOURCE;

	/**
	 * The number of structural features of the '<em>CG Unbox Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP_FEATURE_COUNT = CG_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP___SET_NON_INVALID = CG_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP___SET_NON_NULL = CG_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Unbox Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_UNBOX_EXP_OPERATION_COUNT = CG_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGVariableExpImpl <em>CG Variable Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGVariableExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGVariableExp()
	 * @generated
	 */
	int CG_VARIABLE_EXP = 69;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP__REFERRED_VARIABLE = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_EXP_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGWhileExpImpl <em>CG While Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGWhileExpImpl
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGWhileExp()
	 * @generated
	 */
	int CG_WHILE_EXP = 70;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__PARENT = CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__NAME = CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__PIVOT = CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__PIVOT_TYPE_ID = CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__TYPE_ID = CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__REQUIRED = CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__BOXED = CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__CAUGHT = CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__CONSTANT = CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__DEPENDS_ON = CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__FALSE = CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__GLOBAL = CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__INLINEABLE = CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__INVALID = CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__NULL = CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__NON_INVALID = CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__NON_NULL = CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__REFERRED_VALUED_ELEMENT = CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__SETTABLE = CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__TRUE = CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__UNBOXED = CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__VALUE = CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__VALUE_NAME = CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__CONDITION = CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__BODY_EXPRESSION = CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Finally Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP__FINALLY_EXPRESSION = CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CG While Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP_FEATURE_COUNT = CG_VALUED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP___SET_NON_INVALID = CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP___SET_NON_NULL = CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG While Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_WHILE_EXP_OPERATION_COUNT = CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.domain.elements.Nameable <em>Nameable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.elements.Nameable
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getNameable()
	 * @generated
	 */
	int NAMEABLE = 71;

	/**
	 * The number of structural features of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>Element Id</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.ids.ElementId
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getElementId()
	 * @generated
	 */
	int ELEMENT_ID = 72;

	/**
	 * The meta object id for the '<em>Enumeration Literal Id</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getEnumerationLiteralId()
	 * @generated
	 */
	int ENUMERATION_LITERAL_ID = 73;

	/**
	 * The meta object id for the '<em>Iteration</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.Iteration
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getIteration()
	 * @generated
	 */
	int ITERATION = 74;

	/**
	 * The meta object id for the '<em>Library Iteration</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.library.LibraryIteration
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getLibraryIteration()
	 * @generated
	 */
	int LIBRARY_ITERATION = 75;

	/**
	 * The meta object id for the '<em>Library Operation</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.library.LibraryOperation
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getLibraryOperation()
	 * @generated
	 */
	int LIBRARY_OPERATION = 76;

	/**
	 * The meta object id for the '<em>Library Property</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.library.LibraryProperty
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getLibraryProperty()
	 * @generated
	 */
	int LIBRARY_PROPERTY = 77;

	/**
	 * The meta object id for the '<em>Named Element</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.NamedElement
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 78;

	/**
	 * The meta object id for the '<em>Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getNumber()
	 * @generated
	 */
	int NUMBER = 79;

	/**
	 * The meta object id for the '<em>Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 80;

	/**
	 * The meta object id for the '<em>Operation</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.Operation
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 81;

	/**
	 * The meta object id for the '<em>Property</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.pivot.Property
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 82;

	/**
	 * The meta object id for the '<em>Tuple Part Id</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.ids.TuplePartId
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getTuplePartId()
	 * @generated
	 */
	int TUPLE_PART_ID = 83;

	/**
	 * The meta object id for the '<em>Type Id</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.domain.ids.TypeId
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getTypeId()
	 * @generated
	 */
	int TYPE_ID = 84;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean <em>CG Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Boolean</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean
	 * @generated
	 */
	EClass getCGBoolean();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean#isBooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean Value</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean#isBooleanValue()
	 * @see #getCGBoolean()
	 * @generated
	 */
	EAttribute getCGBoolean_BooleanValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp <em>CG Box Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Box Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp
	 * @generated
	 */
	EClass getCGBoxExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGClass <em>CG Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Class</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGClass
	 * @generated
	 */
	EClass getCGClass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getOperations()
	 * @see #getCGClass()
	 * @generated
	 */
	EReference getCGClass_Operations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getProperties()
	 * @see #getCGClass()
	 * @generated
	 */
	EReference getCGClass_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getInvariants <em>Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invariants</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getInvariants()
	 * @see #getCGClass()
	 * @generated
	 */
	EReference getCGClass_Invariants();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp <em>CG Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp
	 * @generated
	 */
	EClass getCGCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp#isInvalidating <em>Invalidating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invalidating</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp#isInvalidating()
	 * @see #getCGCallExp()
	 * @generated
	 */
	EAttribute getCGCallExp_Invalidating();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp#isValidating <em>Validating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validating</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp#isValidating()
	 * @see #getCGCallExp()
	 * @generated
	 */
	EAttribute getCGCallExp_Validating();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp#getSource()
	 * @see #getCGCallExp()
	 * @generated
	 */
	EReference getCGCallExp_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter <em>CG Cast Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Cast Parameter</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter
	 * @generated
	 */
	EClass getCGCastParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter#getReferredParameter <em>Referred Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Parameter</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter#getReferredParameter()
	 * @see #getCGCastParameter()
	 * @generated
	 */
	EReference getCGCastParameter_ReferredParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp <em>CG Catch Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Catch Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp
	 * @generated
	 */
	EClass getCGCatchExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp <em>CG Collection Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Collection Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp
	 * @generated
	 */
	EClass getCGCollectionExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp#getParts()
	 * @see #getCGCollectionExp()
	 * @generated
	 */
	EReference getCGCollectionExp_Parts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart <em>CG Collection Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Collection Part</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart
	 * @generated
	 */
	EClass getCGCollectionPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart#getFirst()
	 * @see #getCGCollectionPart()
	 * @generated
	 */
	EReference getCGCollectionPart_First();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart#getLast <em>Last</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Last</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart#getLast()
	 * @see #getCGCollectionPart()
	 * @generated
	 */
	EReference getCGCollectionPart_Last();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart#getCollectionExp <em>Collection Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Collection Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart#getCollectionExp()
	 * @see #getCGCollectionPart()
	 * @generated
	 */
	EReference getCGCollectionPart_CollectionExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart#isRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart#isRange()
	 * @see #getCGCollectionPart()
	 * @generated
	 */
	EAttribute getCGCollectionPart_Range();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getContainingPackage <em>Containing Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Package</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGClass#getContainingPackage()
	 * @see #getCGClass()
	 * @generated
	 */
	EReference getCGClass_ContainingPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstant <em>CG Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Constant</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstant
	 * @generated
	 */
	EClass getCGConstant();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstant#getConstantValue <em>Constant Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constant Value</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstant#getConstantValue()
	 * @see #getCGConstant()
	 * @generated
	 */
	EAttribute getCGConstant_ConstantValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable <em>CG Final Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Final Variable</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable
	 * @generated
	 */
	EClass getCGFinalVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp <em>CG Guard Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Guard Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp
	 * @generated
	 */
	EClass getCGGuardExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp <em>CG Ecore Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Ecore Operation Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp
	 * @generated
	 */
	EClass getCGEcoreOperationCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp#getEOperation <em>EOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EOperation</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp#getEOperation()
	 * @see #getCGEcoreOperationCallExp()
	 * @generated
	 */
	EReference getCGEcoreOperationCallExp_EOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp <em>CG Ecore Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Ecore Property Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp
	 * @generated
	 */
	EClass getCGEcorePropertyCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp#getEStructuralFeature <em>EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EStructural Feature</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp#getEStructuralFeature()
	 * @see #getCGEcorePropertyCallExp()
	 * @generated
	 */
	EReference getCGEcorePropertyCallExp_EStructuralFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGInfinity <em>CG Infinity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Infinity</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGInfinity
	 * @generated
	 */
	EClass getCGInfinity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGInteger <em>CG Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Integer</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGInteger
	 * @generated
	 */
	EClass getCGInteger();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGInteger#getIntegerValue <em>Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Value</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGInteger#getIntegerValue()
	 * @see #getCGInteger()
	 * @generated
	 */
	EAttribute getCGInteger_IntegerValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid <em>CG Invalid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Invalid</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid
	 * @generated
	 */
	EClass getCGInvalid();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid#getMessageTemplate <em>Message Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Template</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid#getMessageTemplate()
	 * @see #getCGInvalid()
	 * @generated
	 */
	EAttribute getCGInvalid_MessageTemplate();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Bindings</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid#getBindings()
	 * @see #getCGInvalid()
	 * @generated
	 */
	EAttribute getCGInvalid_Bindings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp <em>CG Is Invalid Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Is Invalid Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp
	 * @generated
	 */
	EClass getCGIsInvalidExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp <em>CG Is Undefined Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Is Undefined Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp
	 * @generated
	 */
	EClass getCGIsUndefinedExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp <em>CG Iteration Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Iteration Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp
	 * @generated
	 */
	EClass getCGIterationCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp#getReferredIteration <em>Referred Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referred Iteration</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp#getReferredIteration()
	 * @see #getCGIterationCallExp()
	 * @generated
	 */
	EAttribute getCGIterationCallExp_ReferredIteration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp#getIterators <em>Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Iterators</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp#getIterators()
	 * @see #getCGIterationCallExp()
	 * @generated
	 */
	EReference getCGIterationCallExp_Iterators();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp#getBody()
	 * @see #getCGIterationCallExp()
	 * @generated
	 */
	EReference getCGIterationCallExp_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterator <em>CG Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Iterator</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIterator
	 * @generated
	 */
	EClass getCGIterator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp <em>CG Library Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Library Operation Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp
	 * @generated
	 */
	EClass getCGLibraryOperationCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp#getLibraryOperation <em>Library Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Library Operation</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp#getLibraryOperation()
	 * @see #getCGLibraryOperationCallExp()
	 * @generated
	 */
	EAttribute getCGLibraryOperationCallExp_LibraryOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp <em>CG Library Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Library Property Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp
	 * @generated
	 */
	EClass getCGLibraryPropertyCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp#getLibraryProperty <em>Library Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Library Property</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp#getLibraryProperty()
	 * @see #getCGLibraryPropertyCallExp()
	 * @generated
	 */
	EAttribute getCGLibraryPropertyCallExp_LibraryProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp <em>CG Constant Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Constant Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp
	 * @generated
	 */
	EClass getCGConstantExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp#getReferredConstant <em>Referred Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Constant</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp#getReferredConstant()
	 * @see #getCGConstantExp()
	 * @generated
	 */
	EReference getCGConstantExp_ReferredConstant();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint <em>CG Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Constraint</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint
	 * @generated
	 */
	EClass getCGConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint#getBody()
	 * @see #getCGConstraint()
	 * @generated
	 */
	EReference getCGConstraint_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Message</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint#getMessage()
	 * @see #getCGConstraint()
	 * @generated
	 */
	EReference getCGConstraint_Message();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp <em>CG Constructor Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Constructor Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp
	 * @generated
	 */
	EClass getCGConstructorExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp#getParts()
	 * @see #getCGConstructorExp()
	 * @generated
	 */
	EReference getCGConstructorExp_Parts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart <em>CG Constructor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Constructor Part</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart
	 * @generated
	 */
	EClass getCGConstructorPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart#getInit()
	 * @see #getCGConstructorPart()
	 * @generated
	 */
	EReference getCGConstructorPart_Init();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart#getConstructorExp <em>Constructor Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Constructor Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart#getConstructorExp()
	 * @see #getCGConstructorPart()
	 * @generated
	 */
	EReference getCGConstructorPart_ConstructorExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp <em>CG Ecore Class Constructor Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Ecore Class Constructor Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp
	 * @generated
	 */
	EClass getCGEcoreClassConstructorExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EClass</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp#getEClass()
	 * @see #getCGEcoreClassConstructorExp()
	 * @generated
	 */
	EReference getCGEcoreClassConstructorExp_EClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp <em>CG Ecore Data Type Constructor Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Ecore Data Type Constructor Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp
	 * @generated
	 */
	EClass getCGEcoreDataTypeConstructorExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp#getEDataType <em>EData Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EData Type</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp#getEDataType()
	 * @see #getCGEcoreDataTypeConstructorExp()
	 * @generated
	 */
	EReference getCGEcoreDataTypeConstructorExp_EDataType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp#getString()
	 * @see #getCGEcoreDataTypeConstructorExp()
	 * @generated
	 */
	EAttribute getCGEcoreDataTypeConstructorExp_String();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp <em>CG Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Let Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp
	 * @generated
	 */
	EClass getCGLetExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp#getInit()
	 * @see #getCGLetExp()
	 * @generated
	 */
	EReference getCGLetExp_Init();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp#getIn()
	 * @see #getCGLetExp()
	 * @generated
	 */
	EReference getCGLetExp_In();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp <em>CG Library Iterate Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Library Iterate Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp
	 * @generated
	 */
	EClass getCGLibraryIterateCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp#getLibraryIteration <em>Library Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Library Iteration</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp#getLibraryIteration()
	 * @see #getCGLibraryIterateCallExp()
	 * @generated
	 */
	EAttribute getCGLibraryIterateCallExp_LibraryIteration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp#getResult()
	 * @see #getCGLibraryIterateCallExp()
	 * @generated
	 */
	EReference getCGLibraryIterateCallExp_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp <em>CG Library Iteration Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Library Iteration Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp
	 * @generated
	 */
	EClass getCGLibraryIterationCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp#getLibraryIteration <em>Library Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Library Iteration</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp#getLibraryIteration()
	 * @see #getCGLibraryIterationCallExp()
	 * @generated
	 */
	EAttribute getCGLibraryIterationCallExp_LibraryIteration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLocalVariable <em>CG Local Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Local Variable</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLocalVariable
	 * @generated
	 */
	EClass getCGLocalVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGModel <em>CG Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Model</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModel
	 * @generated
	 */
	EClass getCGModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGModel#getGlobals <em>Globals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Globals</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModel#getGlobals()
	 * @see #getCGModel()
	 * @generated
	 */
	EReference getCGModel_Globals();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGModel#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModel#getPackages()
	 * @see #getCGModel()
	 * @generated
	 */
	EReference getCGModel_Packages();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGElement <em>CG Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Element</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGElement
	 * @generated
	 */
	EClass getCGElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGElement#getParent()
	 * @see #getCGElement()
	 * @generated
	 */
	EReference getCGElement_Parent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGElementId <em>CG Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Element Id</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGElementId
	 * @generated
	 */
	EClass getCGElementId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGElementId#getElementId <em>Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Id</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGElementId#getElementId()
	 * @see #getCGElementId()
	 * @generated
	 */
	EAttribute getCGElementId_ElementId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEqualsExp <em>CG Equals Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Equals Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEqualsExp
	 * @generated
	 */
	EClass getCGEqualsExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEqualsExp#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Argument</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEqualsExp#getArgument()
	 * @see #getCGEqualsExp()
	 * @generated
	 */
	EReference getCGEqualsExp_Argument();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorCompositionProperty <em>CG Executor Composition Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Executor Composition Property</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorCompositionProperty
	 * @generated
	 */
	EClass getCGExecutorCompositionProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart <em>CG Executor Constructor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Executor Constructor Part</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart
	 * @generated
	 */
	EClass getCGExecutorConstructorPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorNavigationProperty <em>CG Executor Navigation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Executor Navigation Property</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorNavigationProperty
	 * @generated
	 */
	EClass getCGExecutorNavigationProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositeProperty <em>CG Executor Opposite Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Executor Opposite Property</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositeProperty
	 * @generated
	 */
	EClass getCGExecutorOppositeProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation <em>CG Executor Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Executor Operation</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation
	 * @generated
	 */
	EClass getCGExecutorOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation#getUnderlyingOperationId <em>Underlying Operation Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Underlying Operation Id</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation#getUnderlyingOperationId()
	 * @see #getCGExecutorOperation()
	 * @generated
	 */
	EReference getCGExecutorOperation_UnderlyingOperationId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp <em>CG Executor Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Executor Operation Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp
	 * @generated
	 */
	EClass getCGExecutorOperationCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp#getExecutorOperation <em>Executor Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executor Operation</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp#getExecutorOperation()
	 * @see #getCGExecutorOperationCallExp()
	 * @generated
	 */
	EReference getCGExecutorOperationCallExp_ExecutorOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty <em>CG Executor Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Executor Property</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty
	 * @generated
	 */
	EClass getCGExecutorProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty#getUnderlyingPropertyId <em>Underlying Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Underlying Property Id</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty#getUnderlyingPropertyId()
	 * @see #getCGExecutorProperty()
	 * @generated
	 */
	EReference getCGExecutorProperty_UnderlyingPropertyId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp <em>CG Executor Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Executor Property Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp
	 * @generated
	 */
	EClass getCGExecutorPropertyCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp#getExecutorProperty <em>Executor Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executor Property</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp#getExecutorProperty()
	 * @see #getCGExecutorPropertyCallExp()
	 * @generated
	 */
	EReference getCGExecutorPropertyCallExp_ExecutorProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType <em>CG Executor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Executor Type</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType
	 * @generated
	 */
	EClass getCGExecutorType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType#getUnderlyingTypeId <em>Underlying Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Underlying Type Id</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType#getUnderlyingTypeId()
	 * @see #getCGExecutorType()
	 * @generated
	 */
	EReference getCGExecutorType_UnderlyingTypeId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp <em>CG If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG If Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp
	 * @generated
	 */
	EClass getCGIfExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp#getCondition()
	 * @see #getCGIfExp()
	 * @generated
	 */
	EReference getCGIfExp_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp#getThenExpression <em>Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Expression</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp#getThenExpression()
	 * @see #getCGIfExp()
	 * @generated
	 */
	EReference getCGIfExp_ThenExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp#getElseExpression <em>Else Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Expression</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp#getElseExpression()
	 * @see #getCGIfExp()
	 * @generated
	 */
	EReference getCGIfExp_ElseExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement <em>CG Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Named Element</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement
	 * @generated
	 */
	EClass getCGNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement#getName()
	 * @see #getCGNamedElement()
	 * @generated
	 */
	EAttribute getCGNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement#getPivot <em>Pivot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pivot</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement#getPivot()
	 * @see #getCGNamedElement()
	 * @generated
	 */
	EAttribute getCGNamedElement_Pivot();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGNull <em>CG Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Null</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGNull
	 * @generated
	 */
	EClass getCGNull();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperation <em>CG Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Operation</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperation
	 * @generated
	 */
	EClass getCGOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperation#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperation#getBody()
	 * @see #getCGOperation()
	 * @generated
	 */
	EReference getCGOperation_Body();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperation#getPreconditions <em>Preconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preconditions</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperation#getPreconditions()
	 * @see #getCGOperation()
	 * @generated
	 */
	EReference getCGOperation_Preconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperation#getPostconditions <em>Postconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Postconditions</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperation#getPostconditions()
	 * @see #getCGOperation()
	 * @generated
	 */
	EReference getCGOperation_Postconditions();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperation#getContainingClass <em>Containing Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Class</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperation#getContainingClass()
	 * @see #getCGOperation()
	 * @generated
	 */
	EReference getCGOperation_ContainingClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp <em>CG Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Operation Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp
	 * @generated
	 */
	EClass getCGOperationCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referred Operation</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp#getReferredOperation()
	 * @see #getCGOperationCallExp()
	 * @generated
	 */
	EAttribute getCGOperationCallExp_ReferredOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp#getArguments()
	 * @see #getCGOperationCallExp()
	 * @generated
	 */
	EReference getCGOperationCallExp_Arguments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperation#getParameters()
	 * @see #getCGOperation()
	 * @generated
	 */
	EReference getCGOperation_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGPackage <em>CG Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Package</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGPackage
	 * @generated
	 */
	EClass getCGPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGPackage#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGPackage#getClasses()
	 * @see #getCGPackage()
	 * @generated
	 */
	EReference getCGPackage_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGPackage#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGPackage#getPackages()
	 * @see #getCGPackage()
	 * @generated
	 */
	EReference getCGPackage_Packages();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGPackage#getContainingPackage <em>Containing Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Package</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGPackage#getContainingPackage()
	 * @see #getCGPackage()
	 * @generated
	 */
	EReference getCGPackage_ContainingPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGParameter <em>CG Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Parameter</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGParameter
	 * @generated
	 */
	EClass getCGParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGParameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGParameter#getOperation()
	 * @see #getCGParameter()
	 * @generated
	 */
	EReference getCGParameter_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGProperty <em>CG Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Property</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGProperty
	 * @generated
	 */
	EClass getCGProperty();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGProperty#getContainingClass <em>Containing Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Class</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGProperty#getContainingClass()
	 * @see #getCGProperty()
	 * @generated
	 */
	EReference getCGProperty_ContainingClass();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGProperty#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGProperty#getBody()
	 * @see #getCGProperty()
	 * @generated
	 */
	EReference getCGProperty_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp <em>CG Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Property Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp
	 * @generated
	 */
	EClass getCGPropertyCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referred Property</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp#getReferredProperty()
	 * @see #getCGPropertyCallExp()
	 * @generated
	 */
	EAttribute getCGPropertyCallExp_ReferredProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGReal <em>CG Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Real</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGReal
	 * @generated
	 */
	EClass getCGReal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGReal#getRealValue <em>Real Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real Value</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGReal#getRealValue()
	 * @see #getCGReal()
	 * @generated
	 */
	EAttribute getCGReal_RealValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGSettableVariable <em>CG Settable Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Settable Variable</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGSettableVariable
	 * @generated
	 */
	EClass getCGSettableVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGString <em>CG String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG String</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGString
	 * @generated
	 */
	EClass getCGString();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGString#getStringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Value</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGString#getStringValue()
	 * @see #getCGString()
	 * @generated
	 */
	EAttribute getCGString_StringValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGText <em>CG Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Text</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGText
	 * @generated
	 */
	EClass getCGText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGText#getTextValue <em>Text Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Value</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGText#getTextValue()
	 * @see #getCGText()
	 * @generated
	 */
	EAttribute getCGText_TextValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter <em>CG Text Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Text Parameter</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter
	 * @generated
	 */
	EClass getCGTextParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter#getTextValue <em>Text Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Value</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter#getTextValue()
	 * @see #getCGTextParameter()
	 * @generated
	 */
	EAttribute getCGTextParameter_TextValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp <em>CG Throw Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Throw Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp
	 * @generated
	 */
	EClass getCGThrowExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp <em>CG Tuple Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Tuple Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp
	 * @generated
	 */
	EClass getCGTupleExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp#getParts()
	 * @see #getCGTupleExp()
	 * @generated
	 */
	EReference getCGTupleExp_Parts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart <em>CG Tuple Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Tuple Part</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart
	 * @generated
	 */
	EClass getCGTuplePart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart#getInit()
	 * @see #getCGTuplePart()
	 * @generated
	 */
	EReference getCGTuplePart_Init();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart#getTupleExp <em>Tuple Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tuple Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart#getTupleExp()
	 * @see #getCGTuplePart()
	 * @generated
	 */
	EReference getCGTuplePart_TupleExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp <em>CG Tuple Part Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Tuple Part Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp
	 * @generated
	 */
	EClass getCGTuplePartCallExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp#getPivotTuplePartId <em>Pivot Tuple Part Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pivot Tuple Part Id</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp#getPivotTuplePartId()
	 * @see #getCGTuplePartCallExp()
	 * @generated
	 */
	EAttribute getCGTuplePartCallExp_PivotTuplePartId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId <em>CG Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Type Id</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId
	 * @generated
	 */
	EClass getCGTypeId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp <em>CG Type Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Type Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp
	 * @generated
	 */
	EClass getCGTypeExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp#getReferredType <em>Referred Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Type</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp#getReferredType()
	 * @see #getCGTypeExp()
	 * @generated
	 */
	EReference getCGTypeExp_ReferredType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement <em>CG Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Typed Element</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement
	 * @generated
	 */
	EClass getCGTypedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement#getPivotTypeId <em>Pivot Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pivot Type Id</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement#getPivotTypeId()
	 * @see #getCGTypedElement()
	 * @generated
	 */
	EAttribute getCGTypedElement_PivotTypeId();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement#getTypeId <em>Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Id</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement#getTypeId()
	 * @see #getCGTypedElement()
	 * @generated
	 */
	EReference getCGTypedElement_TypeId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement#isRequired()
	 * @see #getCGTypedElement()
	 * @generated
	 */
	EAttribute getCGTypedElement_Required();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp <em>CG Unbox Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Unbox Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp
	 * @generated
	 */
	EClass getCGUnboxExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement <em>CG Valued Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Valued Element</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement
	 * @generated
	 */
	EClass getCGValuedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isBoxed <em>Boxed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boxed</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isBoxed()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_Boxed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isCaught <em>Caught</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caught</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isCaught()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_Caught();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isConstant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constant</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isConstant()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_Constant();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getDependsOn <em>Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depends On</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getDependsOn()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EReference getCGValuedElement_DependsOn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isInlineable <em>Inlineable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inlineable</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isInlineable()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_Inlineable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isInvalid <em>Invalid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invalid</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isInvalid()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_Invalid();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isNull <em>Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Null</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isNull()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_Null();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isFalse <em>False</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>False</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isFalse()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_False();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isGlobal <em>Global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Global</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isGlobal()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_Global();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isNonInvalid <em>Non Invalid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Non Invalid</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isNonInvalid()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_NonInvalid();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isNonNull <em>Non Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Non Null</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isNonNull()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_NonNull();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getReferredValuedElement <em>Referred Valued Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Valued Element</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getReferredValuedElement()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EReference getCGValuedElement_ReferredValuedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isSettable <em>Settable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Settable</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isSettable()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_Settable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isTrue <em>True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>True</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isTrue()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_True();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getValue()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EReference getCGValuedElement_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getValueName <em>Value Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Name</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getValueName()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_ValueName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isUnboxed <em>Unboxed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unboxed</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isUnboxed()
	 * @see #getCGValuedElement()
	 * @generated
	 */
	EAttribute getCGValuedElement_Unboxed();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#setNonInvalid() <em>Set Non Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Non Invalid</em>' operation.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#setNonInvalid()
	 * @generated
	 */
	EOperation getCGValuedElement__SetNonInvalid();

	/**
	 * Returns the meta object for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#setNonNull() <em>Set Non Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Non Null</em>' operation.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#setNonNull()
	 * @generated
	 */
	EOperation getCGValuedElement__SetNonNull();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGVariable <em>CG Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Variable</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGVariable
	 * @generated
	 */
	EClass getCGVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGVariable#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGVariable#getInit()
	 * @see #getCGVariable()
	 * @generated
	 */
	EReference getCGVariable_Init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp <em>CG Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Variable Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp
	 * @generated
	 */
	EClass getCGVariableExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp#getReferredVariable()
	 * @see #getCGVariableExp()
	 * @generated
	 */
	EReference getCGVariableExp_ReferredVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp <em>CG While Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG While Exp</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp
	 * @generated
	 */
	EClass getCGWhileExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp#getCondition()
	 * @see #getCGWhileExp()
	 * @generated
	 */
	EReference getCGWhileExp_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp#getBodyExpression <em>Body Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body Expression</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp#getBodyExpression()
	 * @see #getCGWhileExp()
	 * @generated
	 */
	EReference getCGWhileExp_BodyExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp#getFinallyExpression <em>Finally Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Finally Expression</em>'.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp#getFinallyExpression()
	 * @see #getCGWhileExp()
	 * @generated
	 */
	EReference getCGWhileExp_FinallyExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.domain.elements.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nameable</em>'.
	 * @see org.eclipse.ocl.examples.domain.elements.Nameable
	 * @model instanceClass="org.eclipse.ocl.examples.domain.elements.Nameable"
	 * @generated
	 */
	EClass getNameable();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.domain.ids.ElementId <em>Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Element Id</em>'.
	 * @see org.eclipse.ocl.examples.domain.ids.ElementId
	 * @model instanceClass="org.eclipse.ocl.examples.domain.ids.ElementId"
	 * @generated
	 */
	EDataType getElementId();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId <em>Enumeration Literal Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Enumeration Literal Id</em>'.
	 * @see org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId
	 * @model instanceClass="org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId"
	 * @generated
	 */
	EDataType getEnumerationLiteralId();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.pivot.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Iteration</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Iteration
	 * @model instanceClass="org.eclipse.ocl.examples.pivot.Iteration"
	 * @generated
	 */
	EDataType getIteration();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.domain.library.LibraryIteration <em>Library Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Library Iteration</em>'.
	 * @see org.eclipse.ocl.examples.domain.library.LibraryIteration
	 * @model instanceClass="org.eclipse.ocl.examples.domain.library.LibraryIteration"
	 * @generated
	 */
	EDataType getLibraryIteration();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.domain.library.LibraryOperation <em>Library Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Library Operation</em>'.
	 * @see org.eclipse.ocl.examples.domain.library.LibraryOperation
	 * @model instanceClass="org.eclipse.ocl.examples.domain.library.LibraryOperation"
	 * @generated
	 */
	EDataType getLibraryOperation();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.domain.library.LibraryProperty <em>Library Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Library Property</em>'.
	 * @see org.eclipse.ocl.examples.domain.library.LibraryProperty
	 * @model instanceClass="org.eclipse.ocl.examples.domain.library.LibraryProperty"
	 * @generated
	 */
	EDataType getLibraryProperty();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.pivot.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Named Element</em>'.
	 * @see org.eclipse.ocl.examples.pivot.NamedElement
	 * @model instanceClass="org.eclipse.ocl.examples.pivot.NamedElement"
	 * @generated
	 */
	EDataType getNamedElement();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Number</em>'.
	 * @see java.lang.Number
	 * @model instanceClass="java.lang.Number"
	 * @generated
	 */
	EDataType getNumber();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getObject();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.pivot.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Operation</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Operation
	 * @model instanceClass="org.eclipse.ocl.examples.pivot.Operation"
	 * @generated
	 */
	EDataType getOperation();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.pivot.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Property</em>'.
	 * @see org.eclipse.ocl.examples.pivot.Property
	 * @model instanceClass="org.eclipse.ocl.examples.pivot.Property"
	 * @generated
	 */
	EDataType getProperty();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.domain.ids.TuplePartId <em>Tuple Part Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Tuple Part Id</em>'.
	 * @see org.eclipse.ocl.examples.domain.ids.TuplePartId
	 * @model instanceClass="org.eclipse.ocl.examples.domain.ids.TuplePartId"
	 * @generated
	 */
	EDataType getTuplePartId();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.domain.ids.TypeId <em>Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Id</em>'.
	 * @see org.eclipse.ocl.examples.domain.ids.TypeId
	 * @model instanceClass="org.eclipse.ocl.examples.domain.ids.TypeId"
	 * @generated
	 */
	EDataType getTypeId();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CGModelFactory getCGModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGBooleanImpl <em>CG Boolean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGBooleanImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGBoolean()
		 * @generated
		 */
		EClass CG_BOOLEAN = eINSTANCE.getCGBoolean();

		/**
		 * The meta object literal for the '<em><b>Boolean Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_BOOLEAN__BOOLEAN_VALUE = eINSTANCE.getCGBoolean_BooleanValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGBoxExpImpl <em>CG Box Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGBoxExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGBoxExp()
		 * @generated
		 */
		EClass CG_BOX_EXP = eINSTANCE.getCGBoxExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGClassImpl <em>CG Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGClassImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGClass()
		 * @generated
		 */
		EClass CG_CLASS = eINSTANCE.getCGClass();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CLASS__OPERATIONS = eINSTANCE.getCGClass_Operations();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CLASS__PROPERTIES = eINSTANCE.getCGClass_Properties();

		/**
		 * The meta object literal for the '<em><b>Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CLASS__INVARIANTS = eINSTANCE.getCGClass_Invariants();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCallExpImpl <em>CG Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGCallExp()
		 * @generated
		 */
		EClass CG_CALL_EXP = eINSTANCE.getCGCallExp();

		/**
		 * The meta object literal for the '<em><b>Invalidating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_CALL_EXP__INVALIDATING = eINSTANCE.getCGCallExp_Invalidating();

		/**
		 * The meta object literal for the '<em><b>Validating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_CALL_EXP__VALIDATING = eINSTANCE.getCGCallExp_Validating();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CALL_EXP__SOURCE = eINSTANCE.getCGCallExp_Source();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCastParameterImpl <em>CG Cast Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCastParameterImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGCastParameter()
		 * @generated
		 */
		EClass CG_CAST_PARAMETER = eINSTANCE.getCGCastParameter();

		/**
		 * The meta object literal for the '<em><b>Referred Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CAST_PARAMETER__REFERRED_PARAMETER = eINSTANCE.getCGCastParameter_ReferredParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCatchExpImpl <em>CG Catch Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCatchExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGCatchExp()
		 * @generated
		 */
		EClass CG_CATCH_EXP = eINSTANCE.getCGCatchExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCollectionExpImpl <em>CG Collection Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCollectionExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGCollectionExp()
		 * @generated
		 */
		EClass CG_COLLECTION_EXP = eINSTANCE.getCGCollectionExp();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_COLLECTION_EXP__PARTS = eINSTANCE.getCGCollectionExp_Parts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCollectionPartImpl <em>CG Collection Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGCollectionPartImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGCollectionPart()
		 * @generated
		 */
		EClass CG_COLLECTION_PART = eINSTANCE.getCGCollectionPart();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_COLLECTION_PART__FIRST = eINSTANCE.getCGCollectionPart_First();

		/**
		 * The meta object literal for the '<em><b>Last</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_COLLECTION_PART__LAST = eINSTANCE.getCGCollectionPart_Last();

		/**
		 * The meta object literal for the '<em><b>Collection Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_COLLECTION_PART__COLLECTION_EXP = eINSTANCE.getCGCollectionPart_CollectionExp();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_COLLECTION_PART__RANGE = eINSTANCE.getCGCollectionPart_Range();

		/**
		 * The meta object literal for the '<em><b>Containing Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CLASS__CONTAINING_PACKAGE = eINSTANCE.getCGClass_ContainingPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstantImpl <em>CG Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstantImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGConstant()
		 * @generated
		 */
		EClass CG_CONSTANT = eINSTANCE.getCGConstant();

		/**
		 * The meta object literal for the '<em><b>Constant Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_CONSTANT__CONSTANT_VALUE = eINSTANCE.getCGConstant_ConstantValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGFinalVariableImpl <em>CG Final Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGFinalVariableImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGFinalVariable()
		 * @generated
		 */
		EClass CG_FINAL_VARIABLE = eINSTANCE.getCGFinalVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGGuardExpImpl <em>CG Guard Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGGuardExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGGuardExp()
		 * @generated
		 */
		EClass CG_GUARD_EXP = eINSTANCE.getCGGuardExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreOperationCallExpImpl <em>CG Ecore Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreOperationCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGEcoreOperationCallExp()
		 * @generated
		 */
		EClass CG_ECORE_OPERATION_CALL_EXP = eINSTANCE.getCGEcoreOperationCallExp();

		/**
		 * The meta object literal for the '<em><b>EOperation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ECORE_OPERATION_CALL_EXP__EOPERATION = eINSTANCE.getCGEcoreOperationCallExp_EOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcorePropertyCallExpImpl <em>CG Ecore Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcorePropertyCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGEcorePropertyCallExp()
		 * @generated
		 */
		EClass CG_ECORE_PROPERTY_CALL_EXP = eINSTANCE.getCGEcorePropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>EStructural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ECORE_PROPERTY_CALL_EXP__ESTRUCTURAL_FEATURE = eINSTANCE.getCGEcorePropertyCallExp_EStructuralFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGInfinityImpl <em>CG Infinity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGInfinityImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGInfinity()
		 * @generated
		 */
		EClass CG_INFINITY = eINSTANCE.getCGInfinity();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIntegerImpl <em>CG Integer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIntegerImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGInteger()
		 * @generated
		 */
		EClass CG_INTEGER = eINSTANCE.getCGInteger();

		/**
		 * The meta object literal for the '<em><b>Integer Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_INTEGER__INTEGER_VALUE = eINSTANCE.getCGInteger_IntegerValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGInvalidImpl <em>CG Invalid</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGInvalidImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGInvalid()
		 * @generated
		 */
		EClass CG_INVALID = eINSTANCE.getCGInvalid();

		/**
		 * The meta object literal for the '<em><b>Message Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_INVALID__MESSAGE_TEMPLATE = eINSTANCE.getCGInvalid_MessageTemplate();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_INVALID__BINDINGS = eINSTANCE.getCGInvalid_Bindings();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIsInvalidExpImpl <em>CG Is Invalid Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIsInvalidExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGIsInvalidExp()
		 * @generated
		 */
		EClass CG_IS_INVALID_EXP = eINSTANCE.getCGIsInvalidExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIsUndefinedExpImpl <em>CG Is Undefined Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIsUndefinedExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGIsUndefinedExp()
		 * @generated
		 */
		EClass CG_IS_UNDEFINED_EXP = eINSTANCE.getCGIsUndefinedExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIterationCallExpImpl <em>CG Iteration Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIterationCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGIterationCallExp()
		 * @generated
		 */
		EClass CG_ITERATION_CALL_EXP = eINSTANCE.getCGIterationCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Iteration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_ITERATION_CALL_EXP__REFERRED_ITERATION = eINSTANCE.getCGIterationCallExp_ReferredIteration();

		/**
		 * The meta object literal for the '<em><b>Iterators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ITERATION_CALL_EXP__ITERATORS = eINSTANCE.getCGIterationCallExp_Iterators();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ITERATION_CALL_EXP__BODY = eINSTANCE.getCGIterationCallExp_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIteratorImpl <em>CG Iterator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIteratorImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGIterator()
		 * @generated
		 */
		EClass CG_ITERATOR = eINSTANCE.getCGIterator();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryOperationCallExpImpl <em>CG Library Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryOperationCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGLibraryOperationCallExp()
		 * @generated
		 */
		EClass CG_LIBRARY_OPERATION_CALL_EXP = eINSTANCE.getCGLibraryOperationCallExp();

		/**
		 * The meta object literal for the '<em><b>Library Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_LIBRARY_OPERATION_CALL_EXP__LIBRARY_OPERATION = eINSTANCE.getCGLibraryOperationCallExp_LibraryOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryPropertyCallExpImpl <em>CG Library Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryPropertyCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGLibraryPropertyCallExp()
		 * @generated
		 */
		EClass CG_LIBRARY_PROPERTY_CALL_EXP = eINSTANCE.getCGLibraryPropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Library Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_LIBRARY_PROPERTY_CALL_EXP__LIBRARY_PROPERTY = eINSTANCE.getCGLibraryPropertyCallExp_LibraryProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstantExpImpl <em>CG Constant Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstantExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGConstantExp()
		 * @generated
		 */
		EClass CG_CONSTANT_EXP = eINSTANCE.getCGConstantExp();

		/**
		 * The meta object literal for the '<em><b>Referred Constant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONSTANT_EXP__REFERRED_CONSTANT = eINSTANCE.getCGConstantExp_ReferredConstant();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstraintImpl <em>CG Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstraintImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGConstraint()
		 * @generated
		 */
		EClass CG_CONSTRAINT = eINSTANCE.getCGConstraint();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONSTRAINT__BODY = eINSTANCE.getCGConstraint_Body();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONSTRAINT__MESSAGE = eINSTANCE.getCGConstraint_Message();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstructorExpImpl <em>CG Constructor Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstructorExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGConstructorExp()
		 * @generated
		 */
		EClass CG_CONSTRUCTOR_EXP = eINSTANCE.getCGConstructorExp();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONSTRUCTOR_EXP__PARTS = eINSTANCE.getCGConstructorExp_Parts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstructorPartImpl <em>CG Constructor Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGConstructorPartImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGConstructorPart()
		 * @generated
		 */
		EClass CG_CONSTRUCTOR_PART = eINSTANCE.getCGConstructorPart();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONSTRUCTOR_PART__INIT = eINSTANCE.getCGConstructorPart_Init();

		/**
		 * The meta object literal for the '<em><b>Constructor Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONSTRUCTOR_PART__CONSTRUCTOR_EXP = eINSTANCE.getCGConstructorPart_ConstructorExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreClassConstructorExpImpl <em>CG Ecore Class Constructor Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreClassConstructorExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGEcoreClassConstructorExp()
		 * @generated
		 */
		EClass CG_ECORE_CLASS_CONSTRUCTOR_EXP = eINSTANCE.getCGEcoreClassConstructorExp();

		/**
		 * The meta object literal for the '<em><b>EClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ECORE_CLASS_CONSTRUCTOR_EXP__ECLASS = eINSTANCE.getCGEcoreClassConstructorExp_EClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreDataTypeConstructorExpImpl <em>CG Ecore Data Type Constructor Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreDataTypeConstructorExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGEcoreDataTypeConstructorExp()
		 * @generated
		 */
		EClass CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP = eINSTANCE.getCGEcoreDataTypeConstructorExp();

		/**
		 * The meta object literal for the '<em><b>EData Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__EDATA_TYPE = eINSTANCE.getCGEcoreDataTypeConstructorExp_EDataType();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_ECORE_DATA_TYPE_CONSTRUCTOR_EXP__STRING = eINSTANCE.getCGEcoreDataTypeConstructorExp_String();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLetExpImpl <em>CG Let Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLetExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGLetExp()
		 * @generated
		 */
		EClass CG_LET_EXP = eINSTANCE.getCGLetExp();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_LET_EXP__INIT = eINSTANCE.getCGLetExp_Init();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_LET_EXP__IN = eINSTANCE.getCGLetExp_In();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryIterateCallExpImpl <em>CG Library Iterate Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryIterateCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGLibraryIterateCallExp()
		 * @generated
		 */
		EClass CG_LIBRARY_ITERATE_CALL_EXP = eINSTANCE.getCGLibraryIterateCallExp();

		/**
		 * The meta object literal for the '<em><b>Library Iteration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_LIBRARY_ITERATE_CALL_EXP__LIBRARY_ITERATION = eINSTANCE.getCGLibraryIterateCallExp_LibraryIteration();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_LIBRARY_ITERATE_CALL_EXP__RESULT = eINSTANCE.getCGLibraryIterateCallExp_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryIterationCallExpImpl <em>CG Library Iteration Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLibraryIterationCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGLibraryIterationCallExp()
		 * @generated
		 */
		EClass CG_LIBRARY_ITERATION_CALL_EXP = eINSTANCE.getCGLibraryIterationCallExp();

		/**
		 * The meta object literal for the '<em><b>Library Iteration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_LIBRARY_ITERATION_CALL_EXP__LIBRARY_ITERATION = eINSTANCE.getCGLibraryIterationCallExp_LibraryIteration();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLocalVariableImpl <em>CG Local Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGLocalVariableImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGLocalVariable()
		 * @generated
		 */
		EClass CG_LOCAL_VARIABLE = eINSTANCE.getCGLocalVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelImpl <em>CG Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGModel()
		 * @generated
		 */
		EClass CG_MODEL = eINSTANCE.getCGModel();

		/**
		 * The meta object literal for the '<em><b>Globals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MODEL__GLOBALS = eINSTANCE.getCGModel_Globals();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MODEL__PACKAGES = eINSTANCE.getCGModel_Packages();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGElementImpl <em>CG Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGElementImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGElement()
		 * @generated
		 */
		EClass CG_ELEMENT = eINSTANCE.getCGElement();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ELEMENT__PARENT = eINSTANCE.getCGElement_Parent();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGElementIdImpl <em>CG Element Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGElementIdImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGElementId()
		 * @generated
		 */
		EClass CG_ELEMENT_ID = eINSTANCE.getCGElementId();

		/**
		 * The meta object literal for the '<em><b>Element Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_ELEMENT_ID__ELEMENT_ID = eINSTANCE.getCGElementId_ElementId();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEqualsExpImpl <em>CG Equals Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEqualsExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGEqualsExp()
		 * @generated
		 */
		EClass CG_EQUALS_EXP = eINSTANCE.getCGEqualsExp();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_EQUALS_EXP__ARGUMENT = eINSTANCE.getCGEqualsExp_Argument();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorCompositionPropertyImpl <em>CG Executor Composition Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorCompositionPropertyImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorCompositionProperty()
		 * @generated
		 */
		EClass CG_EXECUTOR_COMPOSITION_PROPERTY = eINSTANCE.getCGExecutorCompositionProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorConstructorPartImpl <em>CG Executor Constructor Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorConstructorPartImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorConstructorPart()
		 * @generated
		 */
		EClass CG_EXECUTOR_CONSTRUCTOR_PART = eINSTANCE.getCGExecutorConstructorPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorNavigationPropertyImpl <em>CG Executor Navigation Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorNavigationPropertyImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorNavigationProperty()
		 * @generated
		 */
		EClass CG_EXECUTOR_NAVIGATION_PROPERTY = eINSTANCE.getCGExecutorNavigationProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorOppositePropertyImpl <em>CG Executor Opposite Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorOppositePropertyImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorOppositeProperty()
		 * @generated
		 */
		EClass CG_EXECUTOR_OPPOSITE_PROPERTY = eINSTANCE.getCGExecutorOppositeProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorOperationImpl <em>CG Executor Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorOperationImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorOperation()
		 * @generated
		 */
		EClass CG_EXECUTOR_OPERATION = eINSTANCE.getCGExecutorOperation();

		/**
		 * The meta object literal for the '<em><b>Underlying Operation Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_EXECUTOR_OPERATION__UNDERLYING_OPERATION_ID = eINSTANCE.getCGExecutorOperation_UnderlyingOperationId();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorOperationCallExpImpl <em>CG Executor Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorOperationCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorOperationCallExp()
		 * @generated
		 */
		EClass CG_EXECUTOR_OPERATION_CALL_EXP = eINSTANCE.getCGExecutorOperationCallExp();

		/**
		 * The meta object literal for the '<em><b>Executor Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_EXECUTOR_OPERATION_CALL_EXP__EXECUTOR_OPERATION = eINSTANCE.getCGExecutorOperationCallExp_ExecutorOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorPropertyImpl <em>CG Executor Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorPropertyImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorProperty()
		 * @generated
		 */
		EClass CG_EXECUTOR_PROPERTY = eINSTANCE.getCGExecutorProperty();

		/**
		 * The meta object literal for the '<em><b>Underlying Property Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_EXECUTOR_PROPERTY__UNDERLYING_PROPERTY_ID = eINSTANCE.getCGExecutorProperty_UnderlyingPropertyId();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorPropertyCallExpImpl <em>CG Executor Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorPropertyCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorPropertyCallExp()
		 * @generated
		 */
		EClass CG_EXECUTOR_PROPERTY_CALL_EXP = eINSTANCE.getCGExecutorPropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Executor Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_EXECUTOR_PROPERTY_CALL_EXP__EXECUTOR_PROPERTY = eINSTANCE.getCGExecutorPropertyCallExp_ExecutorProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorTypeImpl <em>CG Executor Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGExecutorTypeImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGExecutorType()
		 * @generated
		 */
		EClass CG_EXECUTOR_TYPE = eINSTANCE.getCGExecutorType();

		/**
		 * The meta object literal for the '<em><b>Underlying Type Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_EXECUTOR_TYPE__UNDERLYING_TYPE_ID = eINSTANCE.getCGExecutorType_UnderlyingTypeId();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIfExpImpl <em>CG If Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGIfExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGIfExp()
		 * @generated
		 */
		EClass CG_IF_EXP = eINSTANCE.getCGIfExp();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_IF_EXP__CONDITION = eINSTANCE.getCGIfExp_Condition();

		/**
		 * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_IF_EXP__THEN_EXPRESSION = eINSTANCE.getCGIfExp_ThenExpression();

		/**
		 * The meta object literal for the '<em><b>Else Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_IF_EXP__ELSE_EXPRESSION = eINSTANCE.getCGIfExp_ElseExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGNamedElementImpl <em>CG Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGNamedElementImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGNamedElement()
		 * @generated
		 */
		EClass CG_NAMED_ELEMENT = eINSTANCE.getCGNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_NAMED_ELEMENT__NAME = eINSTANCE.getCGNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Pivot</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_NAMED_ELEMENT__PIVOT = eINSTANCE.getCGNamedElement_Pivot();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGNullImpl <em>CG Null</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGNullImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGNull()
		 * @generated
		 */
		EClass CG_NULL = eINSTANCE.getCGNull();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationImpl <em>CG Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGOperation()
		 * @generated
		 */
		EClass CG_OPERATION = eINSTANCE.getCGOperation();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_OPERATION__BODY = eINSTANCE.getCGOperation_Body();

		/**
		 * The meta object literal for the '<em><b>Preconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_OPERATION__PRECONDITIONS = eINSTANCE.getCGOperation_Preconditions();

		/**
		 * The meta object literal for the '<em><b>Postconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_OPERATION__POSTCONDITIONS = eINSTANCE.getCGOperation_Postconditions();

		/**
		 * The meta object literal for the '<em><b>Containing Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_OPERATION__CONTAINING_CLASS = eINSTANCE.getCGOperation_ContainingClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationCallExpImpl <em>CG Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGOperationCallExp()
		 * @generated
		 */
		EClass CG_OPERATION_CALL_EXP = eINSTANCE.getCGOperationCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_OPERATION_CALL_EXP__REFERRED_OPERATION = eINSTANCE.getCGOperationCallExp_ReferredOperation();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_OPERATION_CALL_EXP__ARGUMENTS = eINSTANCE.getCGOperationCallExp_Arguments();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_OPERATION__PARAMETERS = eINSTANCE.getCGOperation_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPackageImpl <em>CG Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPackageImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGPackage()
		 * @generated
		 */
		EClass CG_PACKAGE = eINSTANCE.getCGPackage();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PACKAGE__CLASSES = eINSTANCE.getCGPackage_Classes();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PACKAGE__PACKAGES = eINSTANCE.getCGPackage_Packages();

		/**
		 * The meta object literal for the '<em><b>Containing Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PACKAGE__CONTAINING_PACKAGE = eINSTANCE.getCGPackage_ContainingPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGParameterImpl <em>CG Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGParameterImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGParameter()
		 * @generated
		 */
		EClass CG_PARAMETER = eINSTANCE.getCGParameter();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PARAMETER__OPERATION = eINSTANCE.getCGParameter_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPropertyImpl <em>CG Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPropertyImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGProperty()
		 * @generated
		 */
		EClass CG_PROPERTY = eINSTANCE.getCGProperty();

		/**
		 * The meta object literal for the '<em><b>Containing Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY__CONTAINING_CLASS = eINSTANCE.getCGProperty_ContainingClass();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY__BODY = eINSTANCE.getCGProperty_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPropertyCallExpImpl <em>CG Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPropertyCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGPropertyCallExp()
		 * @generated
		 */
		EClass CG_PROPERTY_CALL_EXP = eINSTANCE.getCGPropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_PROPERTY_CALL_EXP__REFERRED_PROPERTY = eINSTANCE.getCGPropertyCallExp_ReferredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGRealImpl <em>CG Real</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGRealImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGReal()
		 * @generated
		 */
		EClass CG_REAL = eINSTANCE.getCGReal();

		/**
		 * The meta object literal for the '<em><b>Real Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_REAL__REAL_VALUE = eINSTANCE.getCGReal_RealValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGSettableVariableImpl <em>CG Settable Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGSettableVariableImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGSettableVariable()
		 * @generated
		 */
		EClass CG_SETTABLE_VARIABLE = eINSTANCE.getCGSettableVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGStringImpl <em>CG String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGStringImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGString()
		 * @generated
		 */
		EClass CG_STRING = eINSTANCE.getCGString();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_STRING__STRING_VALUE = eINSTANCE.getCGString_StringValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTextImpl <em>CG Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTextImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGText()
		 * @generated
		 */
		EClass CG_TEXT = eINSTANCE.getCGText();

		/**
		 * The meta object literal for the '<em><b>Text Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_TEXT__TEXT_VALUE = eINSTANCE.getCGText_TextValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTextParameterImpl <em>CG Text Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTextParameterImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTextParameter()
		 * @generated
		 */
		EClass CG_TEXT_PARAMETER = eINSTANCE.getCGTextParameter();

		/**
		 * The meta object literal for the '<em><b>Text Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_TEXT_PARAMETER__TEXT_VALUE = eINSTANCE.getCGTextParameter_TextValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGThrowExpImpl <em>CG Throw Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGThrowExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGThrowExp()
		 * @generated
		 */
		EClass CG_THROW_EXP = eINSTANCE.getCGThrowExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTupleExpImpl <em>CG Tuple Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTupleExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTupleExp()
		 * @generated
		 */
		EClass CG_TUPLE_EXP = eINSTANCE.getCGTupleExp();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TUPLE_EXP__PARTS = eINSTANCE.getCGTupleExp_Parts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTuplePartImpl <em>CG Tuple Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTuplePartImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTuplePart()
		 * @generated
		 */
		EClass CG_TUPLE_PART = eINSTANCE.getCGTuplePart();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TUPLE_PART__INIT = eINSTANCE.getCGTuplePart_Init();

		/**
		 * The meta object literal for the '<em><b>Tuple Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TUPLE_PART__TUPLE_EXP = eINSTANCE.getCGTuplePart_TupleExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTuplePartCallExpImpl <em>CG Tuple Part Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTuplePartCallExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTuplePartCallExp()
		 * @generated
		 */
		EClass CG_TUPLE_PART_CALL_EXP = eINSTANCE.getCGTuplePartCallExp();

		/**
		 * The meta object literal for the '<em><b>Pivot Tuple Part Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_TUPLE_PART_CALL_EXP__PIVOT_TUPLE_PART_ID = eINSTANCE.getCGTuplePartCallExp_PivotTuplePartId();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypeIdImpl <em>CG Type Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypeIdImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTypeId()
		 * @generated
		 */
		EClass CG_TYPE_ID = eINSTANCE.getCGTypeId();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypeExpImpl <em>CG Type Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypeExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTypeExp()
		 * @generated
		 */
		EClass CG_TYPE_EXP = eINSTANCE.getCGTypeExp();

		/**
		 * The meta object literal for the '<em><b>Referred Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TYPE_EXP__REFERRED_TYPE = eINSTANCE.getCGTypeExp_ReferredType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypedElementImpl <em>CG Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTypedElementImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGTypedElement()
		 * @generated
		 */
		EClass CG_TYPED_ELEMENT = eINSTANCE.getCGTypedElement();

		/**
		 * The meta object literal for the '<em><b>Pivot Type Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_TYPED_ELEMENT__PIVOT_TYPE_ID = eINSTANCE.getCGTypedElement_PivotTypeId();

		/**
		 * The meta object literal for the '<em><b>Type Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TYPED_ELEMENT__TYPE_ID = eINSTANCE.getCGTypedElement_TypeId();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_TYPED_ELEMENT__REQUIRED = eINSTANCE.getCGTypedElement_Required();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGUnboxExpImpl <em>CG Unbox Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGUnboxExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGUnboxExp()
		 * @generated
		 */
		EClass CG_UNBOX_EXP = eINSTANCE.getCGUnboxExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl <em>CG Valued Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGValuedElement()
		 * @generated
		 */
		EClass CG_VALUED_ELEMENT = eINSTANCE.getCGValuedElement();

		/**
		 * The meta object literal for the '<em><b>Boxed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__BOXED = eINSTANCE.getCGValuedElement_Boxed();

		/**
		 * The meta object literal for the '<em><b>Caught</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__CAUGHT = eINSTANCE.getCGValuedElement_Caught();

		/**
		 * The meta object literal for the '<em><b>Constant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__CONSTANT = eINSTANCE.getCGValuedElement_Constant();

		/**
		 * The meta object literal for the '<em><b>Depends On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_VALUED_ELEMENT__DEPENDS_ON = eINSTANCE.getCGValuedElement_DependsOn();

		/**
		 * The meta object literal for the '<em><b>Inlineable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__INLINEABLE = eINSTANCE.getCGValuedElement_Inlineable();

		/**
		 * The meta object literal for the '<em><b>Invalid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__INVALID = eINSTANCE.getCGValuedElement_Invalid();

		/**
		 * The meta object literal for the '<em><b>Null</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__NULL = eINSTANCE.getCGValuedElement_Null();

		/**
		 * The meta object literal for the '<em><b>False</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__FALSE = eINSTANCE.getCGValuedElement_False();

		/**
		 * The meta object literal for the '<em><b>Global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__GLOBAL = eINSTANCE.getCGValuedElement_Global();

		/**
		 * The meta object literal for the '<em><b>Non Invalid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__NON_INVALID = eINSTANCE.getCGValuedElement_NonInvalid();

		/**
		 * The meta object literal for the '<em><b>Non Null</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__NON_NULL = eINSTANCE.getCGValuedElement_NonNull();

		/**
		 * The meta object literal for the '<em><b>Referred Valued Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT = eINSTANCE.getCGValuedElement_ReferredValuedElement();

		/**
		 * The meta object literal for the '<em><b>Settable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__SETTABLE = eINSTANCE.getCGValuedElement_Settable();

		/**
		 * The meta object literal for the '<em><b>True</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__TRUE = eINSTANCE.getCGValuedElement_True();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_VALUED_ELEMENT__VALUE = eINSTANCE.getCGValuedElement_Value();

		/**
		 * The meta object literal for the '<em><b>Value Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__VALUE_NAME = eINSTANCE.getCGValuedElement_ValueName();

		/**
		 * The meta object literal for the '<em><b>Unboxed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_VALUED_ELEMENT__UNBOXED = eINSTANCE.getCGValuedElement_Unboxed();

		/**
		 * The meta object literal for the '<em><b>Set Non Invalid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CG_VALUED_ELEMENT___SET_NON_INVALID = eINSTANCE.getCGValuedElement__SetNonInvalid();

		/**
		 * The meta object literal for the '<em><b>Set Non Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CG_VALUED_ELEMENT___SET_NON_NULL = eINSTANCE.getCGValuedElement__SetNonNull();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGVariableImpl <em>CG Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGVariableImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGVariable()
		 * @generated
		 */
		EClass CG_VARIABLE = eINSTANCE.getCGVariable();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_VARIABLE__INIT = eINSTANCE.getCGVariable_Init();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGVariableExpImpl <em>CG Variable Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGVariableExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGVariableExp()
		 * @generated
		 */
		EClass CG_VARIABLE_EXP = eINSTANCE.getCGVariableExp();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_VARIABLE_EXP__REFERRED_VARIABLE = eINSTANCE.getCGVariableExp_ReferredVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.cgmodel.impl.CGWhileExpImpl <em>CG While Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGWhileExpImpl
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getCGWhileExp()
		 * @generated
		 */
		EClass CG_WHILE_EXP = eINSTANCE.getCGWhileExp();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_WHILE_EXP__CONDITION = eINSTANCE.getCGWhileExp_Condition();

		/**
		 * The meta object literal for the '<em><b>Body Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_WHILE_EXP__BODY_EXPRESSION = eINSTANCE.getCGWhileExp_BodyExpression();

		/**
		 * The meta object literal for the '<em><b>Finally Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_WHILE_EXP__FINALLY_EXPRESSION = eINSTANCE.getCGWhileExp_FinallyExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.domain.elements.Nameable <em>Nameable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.elements.Nameable
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getNameable()
		 * @generated
		 */
		EClass NAMEABLE = eINSTANCE.getNameable();

		/**
		 * The meta object literal for the '<em>Element Id</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.ids.ElementId
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getElementId()
		 * @generated
		 */
		EDataType ELEMENT_ID = eINSTANCE.getElementId();

		/**
		 * The meta object literal for the '<em>Enumeration Literal Id</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getEnumerationLiteralId()
		 * @generated
		 */
		EDataType ENUMERATION_LITERAL_ID = eINSTANCE.getEnumerationLiteralId();

		/**
		 * The meta object literal for the '<em>Iteration</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.Iteration
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getIteration()
		 * @generated
		 */
		EDataType ITERATION = eINSTANCE.getIteration();

		/**
		 * The meta object literal for the '<em>Library Iteration</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.library.LibraryIteration
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getLibraryIteration()
		 * @generated
		 */
		EDataType LIBRARY_ITERATION = eINSTANCE.getLibraryIteration();

		/**
		 * The meta object literal for the '<em>Library Operation</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.library.LibraryOperation
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getLibraryOperation()
		 * @generated
		 */
		EDataType LIBRARY_OPERATION = eINSTANCE.getLibraryOperation();

		/**
		 * The meta object literal for the '<em>Library Property</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.library.LibraryProperty
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getLibraryProperty()
		 * @generated
		 */
		EDataType LIBRARY_PROPERTY = eINSTANCE.getLibraryProperty();

		/**
		 * The meta object literal for the '<em>Named Element</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.NamedElement
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getNamedElement()
		 * @generated
		 */
		EDataType NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em>Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getNumber()
		 * @generated
		 */
		EDataType NUMBER = eINSTANCE.getNumber();

		/**
		 * The meta object literal for the '<em>Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getObject()
		 * @generated
		 */
		EDataType OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em>Operation</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.Operation
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getOperation()
		 * @generated
		 */
		EDataType OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em>Property</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.pivot.Property
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getProperty()
		 * @generated
		 */
		EDataType PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em>Tuple Part Id</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.ids.TuplePartId
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getTuplePartId()
		 * @generated
		 */
		EDataType TUPLE_PART_ID = eINSTANCE.getTuplePartId();

		/**
		 * The meta object literal for the '<em>Type Id</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.domain.ids.TypeId
		 * @see org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelPackageImpl#getTypeId()
		 * @generated
		 */
		EDataType TYPE_ID = eINSTANCE.getTypeId();

	}

} //CGModelPackage
