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
package org.eclipse.ocl.examples.codegen.generator.java;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.LambdaTypeId;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.NestedEnumerationId;
import org.eclipse.ocl.examples.domain.ids.NestedPackageId;
import org.eclipse.ocl.examples.domain.ids.NestedTypeId;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.OclInvalidTypeId;
import org.eclipse.ocl.examples.domain.ids.OclVoidTypeId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableTypeId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.ids.UnspecifiedId;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;

public class Id2UnboxedJavaClassVisitor implements IdVisitor<Class<?>>
{
	public static final @NonNull Id2UnboxedJavaClassVisitor INSTANCE = new Id2UnboxedJavaClassVisitor();
	
	protected Id2UnboxedJavaClassVisitor() {}
	
	public @NonNull Class<?> visitCollectionId(@NonNull CollectionTypeId id) {
		return Iterable.class;
	}

	public @NonNull Class<?> visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		return EEnumLiteral.class;
	}

	public @NonNull Class<?> visitInvalidId(@NonNull OclInvalidTypeId id) {
		return InvalidValue.class;
	}

	public @NonNull Class<?> visitLambdaTypeId(@NonNull LambdaTypeId id) {
		return TypeValue.class;
	}
	
	public @NonNull Class<?> visitMetaclassId(@NonNull MetaclassId id) {
		return DomainType.class;
	}

	public @NonNull Class<?> visitNestedEnumerationId(@NonNull NestedEnumerationId id) {
		return DomainEnumeration.class;
	}

	public @NonNull Class<?> visitNestedPackageId(@NonNull NestedPackageId id) {
		return DomainPackage.class;
	}

	public @NonNull Class<?> visitNestedTypeId(@NonNull NestedTypeId id) {
		return Object.class;
	}

	public @NonNull Class<?> visitNsURIPackageId(@NonNull NsURIPackageId id) {
		return DomainPackage.class;
	}

	public @NonNull Class<?> visitNullId(@NonNull OclVoidTypeId id) {
		return NullValue.class;
	}

	public @NonNull Class<?> visitOperationId(@NonNull OperationId id) {
		return DomainOperation.class;
	}

	public @NonNull Class<?> visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		if (id == TypeId.BOOLEAN) {						// FIXME Do reflective field analysis
			return Boolean.class;
		}
		else if (id == TypeId.INTEGER) {
			return Number.class;
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

	public @NonNull Class<?> visitRootPackageId(@NonNull RootPackageId id) {
		return DomainPackage.class;
	}

	public @NonNull Class<?> visitTemplateBinding(@NonNull TemplateBinding id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @NonNull Class<?> visitTemplateParameterId(@NonNull TemplateParameterId id) {
		return Object.class;				// FIXME
	}

	public @NonNull Class<?> visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
		return TypeValue.class;
	}

	public @NonNull Class<?> visitTuplePartId(@NonNull TuplePartId id) {
		return DomainProperty.class;
	}

	public @NonNull Class<?> visitTupleTypeId(@NonNull TupleTypeId id) {
		return TupleValue.class;
	}

	public @NonNull Class<?> visitUnspecifiedId(@NonNull UnspecifiedId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}
	
	public @NonNull Class<?> visiting(@NonNull ElementId id) {
		throw new UnsupportedOperationException("Id2UnboxedJavaClass: " + id.getClass().getName());
	}
}
