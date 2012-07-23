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
 * $Id: Nameable.java,v 1.2 2011/01/24 20:49:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.executor;

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.types.AbstractFragment;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ReflectiveType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public class PivotReflectiveType extends ReflectiveType
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull Type type;
	
	public PivotReflectiveType(@NonNull PivotReflectivePackage executorPackage, @NonNull Type type) {
		super(DomainUtil.nonNullModel(type.getName()), executorPackage, computeFlags(type));
		this.metaModelManager = executorPackage.getMetaModelManager();
		this.type = type;
	}

	@Override
	protected @NonNull AbstractFragment createFragment(@NonNull DomainInheritance baseInheritance) {
		return new PivotReflectiveFragment(this, baseInheritance);
	}

	@Override
	public @NonNull Iterable<? extends DomainInheritance> getInitialSuperInheritances() {
		final Iterator<Type> iterator = metaModelManager.getSuperClasses(type).iterator();
		return new Iterable<DomainInheritance>()
		{
			public Iterator<DomainInheritance> iterator() {
				return new Iterator<DomainInheritance>()
				{
					public boolean hasNext() {
						return iterator.hasNext();
					}

					public DomainInheritance next() {
						return iterator.next().getInheritance(metaModelManager);
					}

					public void remove() {
						throw new UnsupportedOperationException();
					}					
				};
			}			
		};
	}

	public @NonNull Iterable<? extends DomainOperation> getLocalOperations() {
		return DomainUtil.nonNullEMF(type.getOwnedOperation());
	}

	public @NonNull Iterable<? extends DomainProperty> getLocalProperties() {
		return DomainUtil.nonNullEMF(type.getOwnedAttribute());
	}

	public @NonNull Iterable<? extends DomainType> getLocalSuperTypes() {
		return DomainUtil.nonNullEMF(type.getSuperClass());
	}
	
	public final @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	public @NonNull String getMetaTypeName() {
		return type.getMetaTypeName();
	}

	public final @NonNull Type getPivotType() {
		return type;
	}

	public final @NonNull DomainStandardLibrary getStandardLibrary() {
		return metaModelManager;
	}
}
