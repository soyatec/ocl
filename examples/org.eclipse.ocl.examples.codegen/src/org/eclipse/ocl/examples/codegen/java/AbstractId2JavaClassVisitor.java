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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.domain.elements.DomainLambdaType;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.LambdaTypeId;
import org.eclipse.ocl.examples.domain.ids.NestedPackageId;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.OclInvalidTypeId;
import org.eclipse.ocl.examples.domain.ids.OclVoidTypeId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableTypeId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.UnspecifiedId;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public abstract class AbstractId2JavaClassVisitor implements IdVisitor<Class<?>>
{
	protected final @NonNull GenModelHelper genModelHelper;;
	
	protected AbstractId2JavaClassVisitor(@NonNull GenModelHelper genModelHelper) {
		this.genModelHelper = genModelHelper;
	}

	public @NonNull Class<?> visitClassId(@NonNull ClassId id) {
		MetaModelManager metaModelManager = genModelHelper.getMetaModelManager();
		Type type = metaModelManager.getIdResolver().getType(id, null);
		EClass eClass = (EClass) type.getETarget();
		if (eClass != null) {
			try {
				return genModelHelper.getEcoreInterfaceClass(eClass);
			}
			catch (Exception e) {}
		}
		return Object.class;
	}

	public @NonNull Class<?> visitInvalidId(@NonNull OclInvalidTypeId id) {
		return InvalidValueException.class;
	}

	public @NonNull Class<?> visitLambdaTypeId(@NonNull LambdaTypeId id) {
		return DomainLambdaType.class;
	}

	public @NonNull Class<?> visitNestedPackageId(@NonNull NestedPackageId id) {
		return DomainPackage.class;
	}

	public @NonNull Class<?> visitNsURIPackageId(@NonNull NsURIPackageId id) {
		return DomainPackage.class;
	}

	public @NonNull Class<?> visitNullId(@NonNull OclVoidTypeId id) {
		return Object.class;		// NullValue is never used
	}

	public @NonNull Class<?> visitOperationId(@NonNull OperationId id) {
		return DomainOperation.class;
	}

	public @NonNull Class<?> visitPropertyId(@NonNull PropertyId id) {
		return DomainProperty.class;
	}

	public @NonNull Class<?> visitRootPackageId(@NonNull RootPackageId id) {
		return DomainPackage.class;
	}

	public @NonNull Class<?> visitTemplateBinding(@NonNull TemplateBinding id) {
		return visiting(id);
	}

	public @NonNull Class<?> visitTemplateParameterId(@NonNull TemplateParameterId id) {
		return Object.class;				// FIXME
	}

	public @NonNull Class<?> visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
		return DomainType.class;
	}

	public @NonNull Class<?> visitTuplePartId(@NonNull TuplePartId id) {
		return DomainProperty.class;
	}

	public @NonNull Class<?> visitTupleTypeId(@NonNull TupleTypeId id) {
		return TupleValue.class;
	}

	public @NonNull Class<?> visitUnspecifiedId(@NonNull UnspecifiedId id) {
		return visiting(id);
	}
	
	public @NonNull Class<?> visiting(@NonNull ElementId id) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + id.getClass().getName());
	}
}
