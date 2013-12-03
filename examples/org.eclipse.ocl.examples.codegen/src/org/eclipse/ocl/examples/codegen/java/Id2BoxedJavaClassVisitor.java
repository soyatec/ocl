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
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;

public class Id2BoxedJavaClassVisitor extends AbstractId2JavaClassVisitor
{
	protected Id2BoxedJavaClassVisitor(@NonNull GenModelHelper genModelHelper) {
		super(genModelHelper);
	}
	
	@Override
	public @NonNull Class<?> visitCollectionTypeId(@NonNull CollectionTypeId id) {
		CollectionTypeId generalizedId = id.getGeneralizedId();
		if (generalizedId == TypeId.BAG) {
			return BagValue.class;
		}
		else if (generalizedId == TypeId.COLLECTION) {
			return CollectionValue.class;
		}
		else if (generalizedId == TypeId.ORDERED_SET) {
			return OrderedSetValue.class;
		}
		else if (generalizedId == TypeId.SEQUENCE) {
			return SequenceValue.class;
		}
		else if (generalizedId == TypeId.SET) {
			return SetValue.class;
		}
		return CollectionValue.class;
	}

	@Override
	public @NonNull Class<?> visitDataTypeId(@NonNull DataTypeId id) {
		return ObjectValue.class;
	}

	@Override
	public @NonNull Class<?> visitEnumerationId(@NonNull EnumerationId id) {
		return EnumerationLiteralId.class;
	}

	@Override
	public @NonNull Class<?> visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		return EnumerationLiteralId.class;
	}
	
	@Override
	public @NonNull Class<?> visitMetaclassId(@NonNull MetaclassId id) {
		if (id.getElementId() instanceof EnumerationLiteralId) {
			return EnumerationLiteralId.class;
		}
		return DomainType.class;
	}

	@Override
	public @NonNull Class<?> visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		Class<?> javaClass = super.visitPrimitiveTypeId(id);
		if (javaClass != null) {
			return javaClass;
		}
		else if (id == TypeId.INTEGER) {
			return IntegerValue.class;
		}
		else if (id == TypeId.REAL) {
			return RealValue.class;
		}
		else if (id == TypeId.UNLIMITED_NATURAL) {
			return IntegerValue.class;
		}
//		else {
//			try {
//				javaClass = Class.forName(id.getName());
//				if (javaClass != null) {
//					return javaClass;
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
		return visiting(id);
	}
}
