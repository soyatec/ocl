/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.autogen.autocgmodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;

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
 * <!-- begin-model-doc -->
 * The CGModel provides a Code Generation friendly form of the OCL Pivot model, with distinct classes
 * such as LibraryPropertyCallExp and EcorePropertyCallExp for distinct purposes. Additional classes
 * such as BoxExpr, CatchExpr and CastParameter support rewrite optimizations.
 * <p>
 * References to the Pivot model are expressed as attributes with datatype values in order to avoid
 * confusion as to whether the new or old pivot mosdel is in use while code generating the pivot model.
 * <!-- end-model-doc -->
 * @see org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore#/'"
 * @generated
 */
public interface AutoCGModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "autocgmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/1.0.0/AutoCG";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "autocg";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.examples.autogen.autocgmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AutoCGModelPackage eINSTANCE = org.eclipse.ocl.examples.autogen.autocgmodel.impl.AutoCGModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGASTCallExpImpl <em>CGAST Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGASTCallExpImpl
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.impl.AutoCGModelPackageImpl#getCGASTCallExp()
	 * @generated
	 */
	int CGAST_CALL_EXP = 0;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGAST_CALL_EXP__AST = CGModelPackage.CG_OPERATION_CALL_EXP__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGAST_CALL_EXP__NAME = CGModelPackage.CG_OPERATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGAST_CALL_EXP__TYPE_ID = CGModelPackage.CG_OPERATION_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGAST_CALL_EXP__REQUIRED = CGModelPackage.CG_OPERATION_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGAST_CALL_EXP__DEPENDS_ON = CGModelPackage.CG_OPERATION_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGAST_CALL_EXP__OWNS = CGModelPackage.CG_OPERATION_CALL_EXP__OWNS;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGAST_CALL_EXP__INVALIDATING = CGModelPackage.CG_OPERATION_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGAST_CALL_EXP__VALIDATING = CGModelPackage.CG_OPERATION_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGAST_CALL_EXP__SOURCE = CGModelPackage.CG_OPERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGAST_CALL_EXP__ARGUMENTS = CGModelPackage.CG_OPERATION_CALL_EXP__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGAST_CALL_EXP__REFERRED_OPERATION = CGModelPackage.CG_OPERATION_CALL_EXP__REFERRED_OPERATION;

	/**
	 * The number of structural features of the '<em>CGAST Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGAST_CALL_EXP_FEATURE_COUNT = CGModelPackage.CG_OPERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGContainmentVisitImpl <em>CG Containment Visit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGContainmentVisitImpl
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.impl.AutoCGModelPackageImpl#getCGContainmentVisit()
	 * @generated
	 */
	int CG_CONTAINMENT_VISIT = 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT__AST = CGModelPackage.CG_OPERATION__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT__NAME = CGModelPackage.CG_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT__TYPE_ID = CGModelPackage.CG_OPERATION__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT__REQUIRED = CGModelPackage.CG_OPERATION__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT__DEPENDS_ON = CGModelPackage.CG_OPERATION__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT__OWNS = CGModelPackage.CG_OPERATION__OWNS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT__PARAMETERS = CGModelPackage.CG_OPERATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT__BODY = CGModelPackage.CG_OPERATION__BODY;

	/**
	 * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT__PRECONDITIONS = CGModelPackage.CG_OPERATION__PRECONDITIONS;

	/**
	 * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT__POSTCONDITIONS = CGModelPackage.CG_OPERATION__POSTCONDITIONS;

	/**
	 * The feature id for the '<em><b>Containing Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT__CONTAINING_CLASS = CGModelPackage.CG_OPERATION__CONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT__PARTS = CGModelPackage.CG_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Containment Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_VISIT_FEATURE_COUNT = CGModelPackage.CG_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGContainmentPartImpl <em>CG Containment Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGContainmentPartImpl
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.impl.AutoCGModelPackageImpl#getCGContainmentPart()
	 * @generated
	 */
	int CG_CONTAINMENT_PART = 2;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_PART__AST = CGModelPackage.CG_VALUED_ELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_PART__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_PART__TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_PART__REQUIRED = CGModelPackage.CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_PART__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_PART__OWNS = CGModelPackage.CG_VALUED_ELEMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Containment Visit</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_PART__CONTAINMENT_VISIT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_PART__INIT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Containment Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONTAINMENT_PART_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp <em>CGAST Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CGAST Call Exp</em>'.
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp
	 * @generated
	 */
	EClass getCGASTCallExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit <em>CG Containment Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Containment Visit</em>'.
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit
	 * @generated
	 */
	EClass getCGContainmentVisit();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit#getParts()
	 * @see #getCGContainmentVisit()
	 * @generated
	 */
	EReference getCGContainmentVisit_Parts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart <em>CG Containment Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Containment Part</em>'.
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart
	 * @generated
	 */
	EClass getCGContainmentPart();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart#getContainmentVisit <em>Containment Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containment Visit</em>'.
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart#getContainmentVisit()
	 * @see #getCGContainmentPart()
	 * @generated
	 */
	EReference getCGContainmentPart_ContainmentVisit();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init</em>'.
	 * @see org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart#getInit()
	 * @see #getCGContainmentPart()
	 * @generated
	 */
	EReference getCGContainmentPart_Init();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AutoCGModelFactory getAutoCGModelFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGASTCallExpImpl <em>CGAST Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGASTCallExpImpl
		 * @see org.eclipse.ocl.examples.autogen.autocgmodel.impl.AutoCGModelPackageImpl#getCGASTCallExp()
		 * @generated
		 */
		EClass CGAST_CALL_EXP = eINSTANCE.getCGASTCallExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGContainmentVisitImpl <em>CG Containment Visit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGContainmentVisitImpl
		 * @see org.eclipse.ocl.examples.autogen.autocgmodel.impl.AutoCGModelPackageImpl#getCGContainmentVisit()
		 * @generated
		 */
		EClass CG_CONTAINMENT_VISIT = eINSTANCE.getCGContainmentVisit();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONTAINMENT_VISIT__PARTS = eINSTANCE.getCGContainmentVisit_Parts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGContainmentPartImpl <em>CG Containment Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.autogen.autocgmodel.impl.CGContainmentPartImpl
		 * @see org.eclipse.ocl.examples.autogen.autocgmodel.impl.AutoCGModelPackageImpl#getCGContainmentPart()
		 * @generated
		 */
		EClass CG_CONTAINMENT_PART = eINSTANCE.getCGContainmentPart();

		/**
		 * The meta object literal for the '<em><b>Containment Visit</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONTAINMENT_PART__CONTAINMENT_VISIT = eINSTANCE.getCGContainmentPart_ContainmentVisit();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONTAINMENT_PART__INIT = eINSTANCE.getCGContainmentPart_Init();

	}

} //AutoCGModelPackage
