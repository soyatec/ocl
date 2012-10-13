/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.ocl4acceleo;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.ocl.examples.codegen.ocl4acceleo.OCL4AcceleoFactory
 * @model kind="package"
 * @generated
 */
public interface OCL4AcceleoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ocl4acceleo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.1.0/OCL4Acceleo";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ocl4acceleo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCL4AcceleoPackage eINSTANCE = org.eclipse.ocl.examples.codegen.ocl4acceleo.impl.OCL4AcceleoPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.codegen.common.CodeGenHelper <em>Code Gen Helper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.codegen.common.CodeGenHelper
	 * @see org.eclipse.ocl.examples.codegen.ocl4acceleo.impl.OCL4AcceleoPackageImpl#getCodeGenHelper()
	 * @generated
	 */
	int CODE_GEN_HELPER = 0;

	/**
	 * The number of structural features of the '<em>Code Gen Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_GEN_HELPER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '<em>OCL Integer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Integer
	 * @see org.eclipse.ocl.examples.codegen.ocl4acceleo.impl.OCL4AcceleoPackageImpl#getOCLInteger()
	 * @generated
	 */
	int OCL_INTEGER = 1;

	/**
	 * The meta object id for the '<em>OCL Real</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Double
	 * @see org.eclipse.ocl.examples.codegen.ocl4acceleo.impl.OCL4AcceleoPackageImpl#getOCLReal()
	 * @generated
	 */
	int OCL_REAL = 2;

	/**
	 * The meta object id for the '<em>OCL String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.ocl.examples.codegen.ocl4acceleo.impl.OCL4AcceleoPackageImpl#getOCLString()
	 * @generated
	 */
	int OCL_STRING = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.codegen.common.CodeGenHelper <em>Code Gen Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Gen Helper</em>'.
	 * @see org.eclipse.ocl.examples.codegen.common.CodeGenHelper
	 * @model instanceClass="org.eclipse.ocl.examples.codegen.common.CodeGenHelper"
	 * @generated
	 */
	EClass getCodeGenHelper();

	/**
	 * Returns the meta object for data type '{@link java.lang.Integer <em>OCL Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>OCL Integer</em>'.
	 * @see java.lang.Integer
	 * @model instanceClass="java.lang.Integer" serializeable="false"
	 * @generated
	 */
	EDataType getOCLInteger();

	/**
	 * Returns the meta object for data type '{@link java.lang.Double <em>OCL Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>OCL Real</em>'.
	 * @see java.lang.Double
	 * @model instanceClass="java.lang.Double" serializeable="false"
	 * @generated
	 */
	EDataType getOCLReal();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>OCL String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>OCL String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String" serializeable="false"
	 * @generated
	 */
	EDataType getOCLString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OCL4AcceleoFactory getOCL4AcceleoFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.codegen.common.CodeGenHelper <em>Code Gen Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.codegen.common.CodeGenHelper
		 * @see org.eclipse.ocl.examples.codegen.ocl4acceleo.impl.OCL4AcceleoPackageImpl#getCodeGenHelper()
		 * @generated
		 */
		EClass CODE_GEN_HELPER = eINSTANCE.getCodeGenHelper();

		/**
		 * The meta object literal for the '<em>OCL Integer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Integer
		 * @see org.eclipse.ocl.examples.codegen.ocl4acceleo.impl.OCL4AcceleoPackageImpl#getOCLInteger()
		 * @generated
		 */
		EDataType OCL_INTEGER = eINSTANCE.getOCLInteger();

		/**
		 * The meta object literal for the '<em>OCL Real</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Double
		 * @see org.eclipse.ocl.examples.codegen.ocl4acceleo.impl.OCL4AcceleoPackageImpl#getOCLReal()
		 * @generated
		 */
		EDataType OCL_REAL = eINSTANCE.getOCLReal();

		/**
		 * The meta object literal for the '<em>OCL String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.ocl.examples.codegen.ocl4acceleo.impl.OCL4AcceleoPackageImpl#getOCLString()
		 * @generated
		 */
		EDataType OCL_STRING = eINSTANCE.getOCLString();

	}

} //OCL4AcceleoPackage
