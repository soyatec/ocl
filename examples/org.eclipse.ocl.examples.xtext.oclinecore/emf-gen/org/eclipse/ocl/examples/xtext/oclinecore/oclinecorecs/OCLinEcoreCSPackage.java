/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;

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
 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import basecs='../../org.eclipse.ocl.examples.xtext.base/model/BaseCS.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore' essentialoclcs='../../org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCS.ecore#/' pivot='../../org.eclipse.ocl.examples.pivot/model/Pivot.ecore#/'"
 * @generated
 */
public interface OCLinEcoreCSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oclinecorecs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.1.0/OCLinEcoreCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "oclinecorecs";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.ocl.examples.xtext.oclinecore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLinEcoreCSPackage eINSTANCE = org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.OCLinEcoreCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.OCLinEcoreConstraintCSImpl <em>OC Lin Ecore Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.OCLinEcoreConstraintCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.OCLinEcoreCSPackageImpl#getOCLinEcoreConstraintCS()
	 * @generated
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS = 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__LOGICAL_PARENT = BaseCSPackage.CONSTRAINT_CS__LOGICAL_PARENT;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS <em>OC Lin Ecore Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OC Lin Ecore Constraint CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS
	 * @generated
	 */
	EClass getOCLinEcoreConstraintCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS#isCallable <em>Callable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callable</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS#isCallable()
	 * @see #getOCLinEcoreConstraintCS()
	 * @generated
	 */
	EAttribute getOCLinEcoreConstraintCS_Callable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.SysMLCS <em>Sys MLCS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sys MLCS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.SysMLCS
	 * @generated
	 */
	EClass getSysMLCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.SysMLCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.SysMLCS#getValue()
	 * @see #getSysMLCS()
	 * @generated
	 */
	EAttribute getSysMLCS_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OCLinEcoreCSFactory getOCLinEcoreCSFactory();

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__PIVOT = BaseCSPackage.CONSTRAINT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__OWNED_ANNOTATION = BaseCSPackage.CONSTRAINT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__ORIGINAL_XMI_ID = BaseCSPackage.CONSTRAINT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__CSI = BaseCSPackage.CONSTRAINT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__NAME = BaseCSPackage.CONSTRAINT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__STEREOTYPE = BaseCSPackage.CONSTRAINT_CS__STEREOTYPE;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__SPECIFICATION = BaseCSPackage.CONSTRAINT_CS__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Message Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__MESSAGE_SPECIFICATION = BaseCSPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Callable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS__CALLABLE = BaseCSPackage.CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OC Lin Ecore Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OC_LIN_ECORE_CONSTRAINT_CS_FEATURE_COUNT = BaseCSPackage.CONSTRAINT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.SysMLCSImpl <em>Sys MLCS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.SysMLCSImpl
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.OCLinEcoreCSPackageImpl#getSysMLCS()
	 * @generated
	 */
	int SYS_MLCS = 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MLCS__LOGICAL_PARENT = BaseCSPackage.ANNOTATION_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MLCS__PIVOT = BaseCSPackage.ANNOTATION_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MLCS__OWNED_ANNOTATION = BaseCSPackage.ANNOTATION_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MLCS__ORIGINAL_XMI_ID = BaseCSPackage.ANNOTATION_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MLCS__CSI = BaseCSPackage.ANNOTATION_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MLCS__NAME = BaseCSPackage.ANNOTATION_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Detail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MLCS__OWNED_DETAIL = BaseCSPackage.ANNOTATION_ELEMENT_CS__OWNED_DETAIL;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MLCS__VALUE = BaseCSPackage.ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sys MLCS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MLCS_FEATURE_COUNT = BaseCSPackage.ANNOTATION_ELEMENT_CS_FEATURE_COUNT + 1;

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.OCLinEcoreConstraintCSImpl <em>OC Lin Ecore Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.OCLinEcoreConstraintCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.OCLinEcoreCSPackageImpl#getOCLinEcoreConstraintCS()
		 * @generated
		 */
		EClass OC_LIN_ECORE_CONSTRAINT_CS = eINSTANCE.getOCLinEcoreConstraintCS();
		/**
		 * The meta object literal for the '<em><b>Callable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OC_LIN_ECORE_CONSTRAINT_CS__CALLABLE = eINSTANCE.getOCLinEcoreConstraintCS_Callable();
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.SysMLCSImpl <em>Sys MLCS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.SysMLCSImpl
		 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl.OCLinEcoreCSPackageImpl#getSysMLCS()
		 * @generated
		 */
		EClass SYS_MLCS = eINSTANCE.getSysMLCS();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYS_MLCS__VALUE = eINSTANCE.getSysMLCS_Value();

	}

} //OCLinEcoreCSPackage
