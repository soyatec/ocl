/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TupleLiteralPartImpl.java,v 1.4 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.pivot.Type;


public class TuplePartImpl
		extends PropertyImpl {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param partType 
	 * @param partId2 
	 * @generated
	 */
	protected TuplePartImpl() {
		super();
	}
	
	private TuplePartId partId;
	
	public TuplePartImpl(@NonNull TuplePartId partId, @NonNull Type partType) {
		this.partId = partId;
		setName(partId.getName());
		setType(partType);
	}
	
	public @NonNull TuplePartId getTuplePartId() {
		TuplePartId partId2 = partId;
		if (partId2 == null) {
			String name2 = getName();
			assert name2 != null;
			partId = partId2 = IdManager.INSTANCE.createTuplePartId(name2, getTypeId());
		}
		return partId2;
	}
} //TupleImpl