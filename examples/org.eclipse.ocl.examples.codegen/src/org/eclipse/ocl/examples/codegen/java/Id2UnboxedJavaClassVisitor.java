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
package org.eclipse.ocl.examples.codegen.java;

import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.DataTypeId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.IntegerRange;

public class Id2UnboxedJavaClassVisitor extends AbstractId2JavaClassVisitor
{
	protected Id2UnboxedJavaClassVisitor(@NonNull GenModelHelper genModelHelper) {
		super(genModelHelper);
	}
	
	public @NonNull Class<?> visitCollectionTypeId(@NonNull CollectionTypeId id) {
		return List.class;
	}

	public @NonNull Class<?> visitDataTypeId(@NonNull DataTypeId id) {
		return Object.class;
	}

	public @NonNull Class<?> visitEnumerationId(@NonNull EnumerationId id) {
		return Enumerator.class;
	}

	public @NonNull Class<?> visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		return Enumerator.class;
	}
	
	public @NonNull Class<?> visitMetaclassId(@NonNull MetaclassId id) {
		if (id.getElementId() instanceof EnumerationLiteralId) {
			return Enumerator.class;
		}
		return DomainType.class;
	}

	public @NonNull Class<?> visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		if (id instanceof JavaTypeId) {
			return ((JavaTypeId)id).getJavaClass();
		}
		else if (id == TypeId.BOOLEAN) {						// FIXME Do reflective field analysis
			return Boolean.class;
		}
		else if (id == TypeId.INTEGER) {
			return Object.class;						// NB Not Number since might be Character
		}
		else if (id == TypeId.INTEGER_RANGE) {
			return IntegerRange.class;
		}
		else if (id == TypeId.OCL_ANY) {
			return Object.class;
		}
		else if (id == TypeId.OCL_COMPARABLE) {
			return Object.class;
		}
		else if (id == TypeId.OCL_SUMMABLE) {
			return Object.class;
		}
		else if (id == TypeId.REAL) {
			return Number.class;
		}
		else if (id == TypeId.STRING) {
			return String.class;
		}
		else if (id == TypeId.UNLIMITED_NATURAL) {
			return Number.class;
		}
		return visiting(id);
	}
}
