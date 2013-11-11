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
package org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.*;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSFactory;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.SysMLCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLinEcoreCSFactoryImpl extends EFactoryImpl implements OCLinEcoreCSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OCLinEcoreCSFactory init() {
		try
		{
			OCLinEcoreCSFactory theOCLinEcoreCSFactory = (OCLinEcoreCSFactory)EPackage.Registry.INSTANCE.getEFactory(OCLinEcoreCSPackage.eNS_URI);
			if (theOCLinEcoreCSFactory != null)
			{
				return theOCLinEcoreCSFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OCLinEcoreCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreCSFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
			case OCLinEcoreCSPackage.OC_LIN_ECORE_CONSTRAINT_CS: return createOCLinEcoreConstraintCS();
			case OCLinEcoreCSPackage.SYS_MLCS: return createSysMLCS();
			case OCLinEcoreCSPackage.TOP_LEVEL_CS: return createTopLevelCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreConstraintCS createOCLinEcoreConstraintCS()
	{
		OCLinEcoreConstraintCSImpl ocLinEcoreConstraintCS = new OCLinEcoreConstraintCSImpl();
		return ocLinEcoreConstraintCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SysMLCS createSysMLCS()
	{
		SysMLCSImpl sysMLCS = new SysMLCSImpl();
		return sysMLCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopLevelCS createTopLevelCS()
	{
		TopLevelCSImpl topLevelCS = new TopLevelCSImpl();
		return topLevelCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreCSPackage getOCLinEcoreCSPackage()
	{
		return (OCLinEcoreCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OCLinEcoreCSPackage getPackage() {
		return OCLinEcoreCSPackage.eINSTANCE;
	}

} //OCLinEcoreCSFactoryImpl
