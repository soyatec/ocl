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
 * $Id: OCLinEcoreCSTFactoryImpl.java,v 1.7 2011/03/01 08:46:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.*;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTFactory;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLinEcoreCSTFactoryImpl extends EFactoryImpl implements OCLinEcoreCSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OCLinEcoreCSTFactory init() {
		try
		{
			OCLinEcoreCSTFactory theOCLinEcoreCSTFactory = (OCLinEcoreCSTFactory)EPackage.Registry.INSTANCE.getEFactory(OCLinEcoreCSTPackage.eNS_URI);
			if (theOCLinEcoreCSTFactory != null)
			{
				return theOCLinEcoreCSTFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OCLinEcoreCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreCSTFactoryImpl() {
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
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CONSTRAINT_CS: return createOCLinEcoreConstraintCS();
			case OCLinEcoreCSTPackage.SYS_MLCS: return createSysMLCS();
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
	public OCLinEcoreCSTPackage getOCLinEcoreCSTPackage() {
		return (OCLinEcoreCSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OCLinEcoreCSTPackage getPackage() {
		return OCLinEcoreCSTPackage.eINSTANCE;
	}

} //OCLinEcoreCSTFactoryImpl