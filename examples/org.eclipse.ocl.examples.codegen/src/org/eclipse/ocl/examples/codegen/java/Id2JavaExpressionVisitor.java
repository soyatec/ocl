/**
 * <copyright>
 * 
 * Copyright (c) 2012,2013 CEA LIST and others.
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

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.DataTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.LambdaTypeId;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.NestedPackageId;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.OclInvalidTypeId;
import org.eclipse.ocl.examples.domain.ids.OclVoidTypeId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.ids.SpecializedId;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableTypeId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.ids.UnspecifiedId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * An Id2JavaExpressionVisitor appends the expression body of an Id declaration.
 */
public class Id2JavaExpressionVisitor implements IdVisitor<Object>
{
	protected final @NonNull CG2JavaVisitor cg2JavaVisitor;
	protected final @NonNull CodeGenerator codeGenerator;

	public Id2JavaExpressionVisitor(@NonNull CG2JavaVisitor cg2JavaVisitor) {
		this.cg2JavaVisitor = cg2JavaVisitor;
		this.codeGenerator = cg2JavaVisitor.getCodeGenerator();
	}

	public @Nullable Object visitClassId(@NonNull ClassId id) {
		cg2JavaVisitor.appendIdReference(id.getParent());
		cg2JavaVisitor.append(".getClassId(");
		cg2JavaVisitor.appendString(id.getName());
		cg2JavaVisitor.append(", " + id.getTemplateParameters() + ")");
		return null;
	}
	
	public @Nullable Object visitCollectionTypeId(@NonNull CollectionTypeId id) {
		cg2JavaVisitor.appendClassReference(TypeId.class);
		CollectionTypeId generalizedId = id.getGeneralizedId();
		String idName = generalizedId.getLiteralName();
		if (idName == null) {
			idName = "COLLECTION";
		}
		cg2JavaVisitor.append("." + idName);
		if (id instanceof SpecializedId) {
			cg2JavaVisitor.append(".getSpecializedId(");
			BindingsId templateBindings = ((SpecializedId)id).getTemplateBindings();
			for (int i = 0; i < templateBindings.size(); i++) {
				if (i > 0) {
					cg2JavaVisitor.append(", ");
				}
				ElementId elementId = DomainUtil.nonNullModel(templateBindings.get(i));
				cg2JavaVisitor.appendIdReference(elementId);
			}
			cg2JavaVisitor.append(")");
		}
		return null;
	}

	public @Nullable Object visitDataTypeId(@NonNull DataTypeId id) {
		cg2JavaVisitor.appendIdReference(id.getParent());
		cg2JavaVisitor.append(".getDataTypeId(");
		cg2JavaVisitor.appendString(id.getName());
		cg2JavaVisitor.append(", " + id.getTemplateParameters() + ")");
		return null;
	}

	public @Nullable Object visitEnumerationId(@NonNull EnumerationId id) {
		cg2JavaVisitor.appendIdReference(id.getParent());
		cg2JavaVisitor.append(".getEnumerationId(");
		cg2JavaVisitor.appendString(id.getName());
		cg2JavaVisitor.append(")");
		return null;
	}

	public @Nullable Object visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		cg2JavaVisitor.appendIdReference(id.getParentId());
		cg2JavaVisitor.append(".getEnumerationLiteralId(");
		cg2JavaVisitor.appendString(id.getName());
		cg2JavaVisitor.append(")");
		return null;
	}

	public @Nullable Object visitInvalidId(@NonNull OclInvalidTypeId id) {
		cg2JavaVisitor.appendClassReference(TypeId.class);
		cg2JavaVisitor.append(".");
		cg2JavaVisitor.append(id.getLiteralName());
		return null;
	}

	public @Nullable Object visitLambdaTypeId(@NonNull LambdaTypeId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}
	
	public @Nullable Object visitMetaclassId(@NonNull MetaclassId id) {
		cg2JavaVisitor.appendClassReference(TypeId.class);
		cg2JavaVisitor.append(".METACLASS");
		if (id != TypeId.METACLASS) {
			cg2JavaVisitor.append(".getSpecializedId(");
			cg2JavaVisitor.appendIdReference(id.getElementId());
			cg2JavaVisitor.append(")");
		}
		return null;
	}

	public @Nullable Object visitNestedPackageId(@NonNull NestedPackageId id) {
		cg2JavaVisitor.appendIdReference(id.getParent());
		cg2JavaVisitor.append(".getNestedPackageId(");
		cg2JavaVisitor.appendString(id.getName());
		cg2JavaVisitor.append(")");
		return null;
	}

	public @Nullable Object visitNsURIPackageId(@NonNull NsURIPackageId id) {
		String nsURI = id.getNsURI();
		GenPackage genPackage = codeGenerator.getMetaModelManager().getGenPackage(nsURI);
		cg2JavaVisitor.appendClassReference(IdManager.class);
		cg2JavaVisitor.append(".getNsURIPackageId(");
		cg2JavaVisitor.appendString(nsURI);
		cg2JavaVisitor.append(", ");
		if (genPackage != null) {
			cg2JavaVisitor.appendClassReference(genPackage.getQualifiedPackageInterfaceName());
			cg2JavaVisitor.append(".eINSTANCE");
		}
		else {
			cg2JavaVisitor.append("null");
		}
		cg2JavaVisitor.append(")");
		return null;
	}

	public @Nullable Object visitNullId(@NonNull OclVoidTypeId id) {
		cg2JavaVisitor.appendClassReference(TypeId.class);
		cg2JavaVisitor.append(".");
		cg2JavaVisitor.append(id.getLiteralName());
		return null;
	}

	public @Nullable Object visitOperationId(@NonNull OperationId id) {
		cg2JavaVisitor.appendIdReference(id.getParent());
		cg2JavaVisitor.append(".getOperationId(" + id.getTemplateParameters() + ", ");
		cg2JavaVisitor.appendString(id.getName());
		cg2JavaVisitor.append(", ");
		cg2JavaVisitor.appendClassReference(IdManager.class);
		cg2JavaVisitor.append(".getParametersId(");
		boolean isFirst = true;
		for (@SuppressWarnings("null")@NonNull TypeId parameterId : id.getParametersId()) {
			if (!isFirst) {
				cg2JavaVisitor.append(", ");
			}
			cg2JavaVisitor.appendIdReference(parameterId);
			isFirst = false;
		}
		cg2JavaVisitor.append("))");
		return null;
	}

	public @Nullable Object visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		cg2JavaVisitor.appendClassReference(TypeId.class);
		cg2JavaVisitor.append(".");
		cg2JavaVisitor.append(id.getLiteralName());
		return null;
	}

	public @Nullable Object visitPropertyId(@NonNull PropertyId id) {
		cg2JavaVisitor.appendIdReference(id.getParent());
		cg2JavaVisitor.append(".getPropertyId(");
		cg2JavaVisitor.appendString(id.getName());
		cg2JavaVisitor.append(")");
		return null;
	}

	public @Nullable Object visitRootPackageId(@NonNull RootPackageId id) {
		cg2JavaVisitor.appendClassReference(IdManager.class);
		cg2JavaVisitor.append(".getRootPackageId(");
		cg2JavaVisitor.appendString(id.getName());
		cg2JavaVisitor.append(")");
		return null;
	}

	public @Nullable Object visitTemplateBinding(@NonNull TemplateBinding id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable Object visitTemplateParameterId(@NonNull TemplateParameterId id) {
		cg2JavaVisitor.append("visitTemplateParameterId");
		return null;
	}

	public @Nullable Object visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @Nullable Object visitTuplePartId(@NonNull TuplePartId id) {
		cg2JavaVisitor.appendClassReference(IdManager.class);
		cg2JavaVisitor.append(".getTuplePartId(" + id.getIndex() + ", ");
		cg2JavaVisitor.appendString(id.getName());
		cg2JavaVisitor.append(", ");
		cg2JavaVisitor.appendIdReference(id.getTypeId());
		cg2JavaVisitor.append(")");
		return null;
	}

	public @Nullable Object visitTupleTypeId(@NonNull TupleTypeId id) {
		cg2JavaVisitor.appendClassReference(IdManager.class);
		cg2JavaVisitor.append(".getTupleTypeId(");
		cg2JavaVisitor.appendString(id.getName());
		for (@SuppressWarnings("null")@NonNull TuplePartId partId : id.getPartIds()) {
			cg2JavaVisitor.append(", ");
			cg2JavaVisitor.appendIdReference(partId);
		}
		cg2JavaVisitor.append(")");
		return null;
	}

	public @Nullable Object visitUnspecifiedId(@NonNull UnspecifiedId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}
	
	public @Nullable Object visiting(@NonNull ElementId id) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + id.getClass().getName());
	}
}
