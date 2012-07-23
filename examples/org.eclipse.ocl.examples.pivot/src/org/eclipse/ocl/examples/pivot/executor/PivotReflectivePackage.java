/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id$
 */
package org.eclipse.ocl.examples.pivot.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ReflectivePackage;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public class PivotReflectivePackage extends ReflectivePackage
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage;

	public PivotReflectivePackage(@NonNull MetaModelManager metaModelManager, @NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		super(DomainUtil.nonNullModel(pivotPackage.getName()), pivotPackage.getNsURI());
		this.metaModelManager = metaModelManager;		
		this.pivotPackage = pivotPackage;		
	}

	@Override
	protected @NonNull PivotReflectiveType createExecutorType(@NonNull DomainType domainType) {
		if (domainType instanceof InvalidType) {
			return new PivotReflectiveInvalidType(this, (InvalidType)domainType);
		}
		else if (domainType instanceof VoidType) {
			return new PivotReflectiveVoidType(this, (VoidType)domainType);
		}
		else if (domainType instanceof AnyType) {
			return new PivotReflectiveAnyType(this, (AnyType)domainType);
		}
		else if (domainType instanceof Enumeration) {
			return new PivotReflectiveEnumerationType(this, (Enumeration)domainType);
		}
		else {
			return new PivotReflectiveType(this, (Type) domainType);
		}
	}

	@Override
	protected @NonNull Iterable<? extends DomainType> getDomainTypes() {
		return metaModelManager.getLocalClasses(pivotPackage);
	}

	public final @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}
	
	public final @NonNull org.eclipse.ocl.examples.pivot.Package getPivotPackage() {
		return pivotPackage;
	}
	
	@Override
	protected @NonNull DomainStandardLibrary getStandardLibrary() {
		return metaModelManager;
	}
}