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
import org.eclipse.ocl.examples.domain.ids.ElementId;
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
import org.eclipse.ocl.examples.domain.ids.SpecializedId;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
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
		String name = id.getName();
		String idName;
		if ("Bag".equals(name)) {
			idName = "BAG";
		}
		else if ("OrderedSet".equals(name)) {
			idName = "ORDERED_SET";
		}
		else if ("Sequence".equals(name)) {
			idName = "SEQUENCE";
		}
		else if ("Set".equals(name)) {
			idName = "SET";
		}
		else {
			idName = "COLLECTION";
		}
		StringBuilder s = new StringBuilder();
		s.append(codeGenerator.getImportedName(TypeId.class) + "." + idName +".getSpecializedId(");
		if (id instanceof SpecializedId) {
			TemplateBindings templateBindings = ((SpecializedId)id).getTemplateBindings();
			for (int i = 0; i < templateBindings.parametersSize(); i++) {
				if (i > 0) {
					s.append(", ");
				}
				ElementId elementId = templateBindings.get(i);
				s.append(elementId.accept(this));
			}
		}
		s.append(")");
		return s.toString();
	}

	public @Nullable String visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable String visitInvalidId(@NonNull OclInvalidTypeId id) {
		return typeIdName + ".OCL_INVALID";
	}

	public @Nullable String visitLambdaTypeId(@NonNull LambdaTypeId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable String visitNestedPackageId(@NonNull NestedPackageId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable String visitNestedTypeId(@NonNull NestedTypeId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable String visitNsURIPackageId(@NonNull NsURIPackageId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable String visitNullId(@NonNull OclVoidTypeId id) {
		return typeIdName + ".OCL_VOID";
	}

	public @Nullable String visitOperationId(@NonNull OperationId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable String visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		if (id == TypeId.BOOLEAN) {						// FIXME Do reflective field analysis
			return typeIdName + ".BOOLEAN";
		}
		else if (id == TypeId.INTEGER) {
			return typeIdName + ".INTEGER";
		}
		else if (id == TypeId.OCL_ANY) {
			return typeIdName + ".OCL_ANY";
		}
		else if (id == TypeId.OCL_COMPARABLE) {
			return typeIdName + ".OCL_COMPARABLE";
		}
//		else if (id == TypeId.OCL_INVALID) {
//			return typeIdName + ".OCL_INVALID";
//		}
		else if (id == TypeId.OCL_SUMMABLE) {
			return typeIdName + ".OCL_SUMMABLE";
		}
//		else if (id == TypeId.OCL_VOID) {
//			return typeIdName + ".OCL_VOID";
//		}
		else if (id == TypeId.REAL) {
			return typeIdName + ".REAL";
		}
		else if (id == TypeId.STRING) {
			return typeIdName + ".STRING";
		}
		else if (id == TypeId.UNLIMITED_NATURAL) {
			return typeIdName + ".UNLIMITED_NATURAL";
		}
		return visiting(id);
	}

	public @Nullable String visitRootPackageId(@NonNull RootPackageId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable String visitTemplateBinding(@NonNull TemplateBinding id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable String visitTemplateParameterId(@NonNull TemplateParameterId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable String visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable String visitTuplePartId(@NonNull TuplePartId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable String visitTupleTypeId(@NonNull TupleTypeId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable String visitUnspecifiedId(@NonNull UnspecifiedId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}
	
	public @Nullable String visiting(@NonNull ElementId id) {
		throw new UnsupportedOperationException(id.getClass().getName());
	}
}
