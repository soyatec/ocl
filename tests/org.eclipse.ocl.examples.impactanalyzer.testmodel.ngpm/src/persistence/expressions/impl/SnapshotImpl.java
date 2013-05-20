/*******************************************************************************
 * Copyright (c) 2009, 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************
 * $Id: SnapshotImpl.java,v 1.2 2011/03/05 21:52:05 auhl Exp $
 */
package persistence.expressions.impl;

import dataaccess.expressions.impl.ObjectBasedExpressionImpl;

import org.eclipse.emf.ecore.EClass;

import persistence.expressions.ExpressionsPackage;
import persistence.expressions.Snapshot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Snapshot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SnapshotImpl extends ObjectBasedExpressionImpl implements Snapshot {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SnapshotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.SNAPSHOT;
	}

} //SnapshotImpl
