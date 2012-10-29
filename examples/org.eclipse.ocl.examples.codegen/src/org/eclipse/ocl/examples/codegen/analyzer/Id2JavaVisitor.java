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
package org.eclipse.ocl.examples.codegen.analyzer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.LambdaTypeId;
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


public class Id2JavaVisitor implements IdVisitor<String>
{
	protected final @NonNull OCLCodeGenerator codeGenerator;
	protected final @NonNull String typeIdName;

	public Id2JavaVisitor(@NonNull OCLCodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
		typeIdName = codeGenerator.getImportedName(TypeId.class);
	}
	
	public @Nullable String visitCollectionId(@NonNull CollectionTypeId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitInvalidId(@NonNull OclInvalidTypeId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitLambdaTypeId(@NonNull LambdaTypeId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitNestedPackageId(@NonNull NestedPackageId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitNestedTypeId(@NonNull NestedTypeId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitNsURIPackageId(@NonNull NsURIPackageId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitNullId(@NonNull OclVoidTypeId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitOperationId(@NonNull OperationId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		if (id == TypeId.BOOLEAN) {
			return typeIdName + ".BOOLEAN";
		}
		else if (id == TypeId.INTEGER) {
			return typeIdName + ".INTEGER";
		}
		else if (id == TypeId.REAL) {
			return typeIdName + ".REAL";
		}
		else if (id == TypeId.STRING) {
			return typeIdName + ".STRING";
		}
		else if (id == TypeId.UNLIMITED_NATURAL) {
			return typeIdName + ".UNLIMITED_NATURAL";
		}
		return null;
	}

	public @Nullable String visitRootPackageId(@NonNull RootPackageId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitTemplateBinding(@NonNull TemplateBinding templateBinding) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitTemplateParameterId(@NonNull TemplateParameterId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitTuplePartId(@NonNull TuplePartId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitTupleTypeId(@NonNull TupleTypeId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable String visitUnspecifiedId(@NonNull UnspecifiedId id) {
		// TODO Auto-generated method stub
		return null;
	}
}
