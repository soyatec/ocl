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

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
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
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.xtext.util.Strings;

public class Id2JavaSnippetVisitor implements IdVisitor<CodeGenSnippet>
{
	protected final @NonNull CodeGenerator codeGenerator;

	public Id2JavaSnippetVisitor(@NonNull CodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
	}

	protected @NonNull CodeGenSnippet createInlinedSnippet(@NonNull String name, @NonNull TypeId typeId, @NonNull Class<? extends ElementId> javaClass) {
		return new JavaSnippet(name, typeId, javaClass, codeGenerator, "", CodeGenSnippet.FINAL | CodeGenSnippet.INLINE | CodeGenSnippet.NON_NULL);
	}

	protected @NonNull <T extends ElementId> CodeGenText createNonInlinedSnippet(@NonNull T id, @NonNull Class<?> javaClass) {
		CodeGenSnippet s = new JavaSnippet("", codeGenerator, TypeId.METACLASS.getSpecializedId(id), javaClass, id, CodeGenSnippet.BOXED | CodeGenSnippet.FINAL | CodeGenSnippet.NON_NULL | CodeGenSnippet.UNBOXED);
//		return s.append("private static final " + s.atNonNull() + " " + s.getImportedName(javaClass) + " " + s.getName() + " = ");
		return s.open("");
	}

	public @NonNull CodeGenSnippet visitClassId(@NonNull ClassId id) {
		CodeGenText text = createNonInlinedSnippet(id, ClassId.class);
		text.appendReferenceTo(id.getParent());
		text.append(".getClassId(");
		text.appendString(id.getName());
		for (TemplateParameterId templateParameterId : id.getTemplateParameters()) {
			assert templateParameterId != null;
			text.append(", ");
			text.appendReferenceTo(templateParameterId);
		}
		text.append(");\n");
		return text.getSnippet();
	}
	
	public @NonNull CodeGenSnippet visitCollectionTypeId(@NonNull CollectionTypeId id) {
		CollectionTypeId generalizedId = id.getGeneralizedId();
		String idName;
		if (generalizedId == TypeId.BAG) {
			idName = "BAG";
		}
		else if (generalizedId == TypeId.ORDERED_SET) {
			idName = "ORDERED_SET";
		}
		else if (generalizedId == TypeId.SEQUENCE) {
			idName = "SEQUENCE";
		}
		else if (generalizedId == TypeId.SET) {
			idName = "SET";
		}
		else {
			idName = "COLLECTION";
		}
		CodeGenText text = createNonInlinedSnippet(id, CollectionTypeId.class);
		text.append(text.getSnippet().getImportedName(TypeId.class) + "." + idName);
		if (id instanceof SpecializedId) {
			text.append(".getSpecializedId(");
			TemplateBindings templateBindings = ((SpecializedId)id).getTemplateBindings();
			for (int i = 0; i < templateBindings.parametersSize(); i++) {
				if (i > 0) {
					text.append(", ");
				}
				ElementId elementId = DomainUtil.nonNullModel(templateBindings.get(i));
				text.appendReferenceTo(elementId);
			}
			text.append(")");
		}
		text.append(";\n");
		return text.getSnippet();
	}

	public @NonNull CodeGenSnippet visitDataTypeId(@NonNull DataTypeId id) {
		CodeGenText text = createNonInlinedSnippet(id, DataTypeId.class);
		text.appendReferenceTo(id.getParent());
		text.append(".getDataTypeId(");
		text.appendString(id.getName());
		for (TemplateParameterId templateParameterId : id.getTemplateParameters()) {
			assert templateParameterId != null;
			text.append(", ");
			text.appendReferenceTo(templateParameterId);
		}
		text.append(");\n");
		return text.getSnippet();
	}

	public @NonNull CodeGenSnippet visitEnumerationId(@NonNull EnumerationId id) {
		CodeGenText text = createNonInlinedSnippet(id, EnumerationId.class);
		text.appendReferenceTo(id.getParent());
		text.append(".getEnumerationId(");
		text.appendString(id.getName());
		text.append(");\n");
		return text.getSnippet();
	}

	public @NonNull CodeGenSnippet visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		CodeGenText text = createNonInlinedSnippet(id, EnumerationLiteralId.class);
		text.appendReferenceTo(id.getParentId());
		text.append(".getEnumerationLiteralId(");
		text.appendString(id.getName());
		text.append(");\n");
		return text.getSnippet();
	}

	public @NonNull CodeGenSnippet visitInvalidId(@NonNull OclInvalidTypeId id) {
		String typeIdName = codeGenerator.getImportedName2(TypeId.class);
		CodeGenSnippet snippet = createInlinedSnippet(typeIdName + ".OCL_INVALID", TypeId.OCL_INVALID, OclInvalidTypeId.class);
		snippet.addClassReference(TypeId.class);
		return snippet;
	}

	public @NonNull CodeGenSnippet visitLambdaTypeId(@NonNull LambdaTypeId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}
	
	public @NonNull CodeGenSnippet visitMetaclassId(@NonNull MetaclassId id) {
//		CollectionTypeId generalizedId = id.getGeneralizedId();
		Class<?> javaClass = MetaclassId.class;
		CodeGenText text = createNonInlinedSnippet(id, javaClass);
//		CodeGenSnippet s = new JavaSnippet("", codeGenerator, id/*TypeId.METACLASS.getSpecializedId(id)*/, javaClass, id, CodeGenSnippet.BOXED | CodeGenSnippet.FINAL);
//		s.setIsStatic();
//		CodeGenText text = s.append("private static final " + atNonNull + " " + codeGenerator.getImportedName(javaClass) + " " + s.getName() + " = ");
		text.append(text.getSnippet().getImportedName(TypeId.class) + ".METACLASS");
		if (id != TypeId.METACLASS) {
			text.append(".getSpecializedId(");
			ElementId elementId = id.getElementId();
			text.appendReferenceTo(elementId);
			text.append(")");
		}
		text.append(";\n");
		return text.getSnippet();
	}

	public @NonNull CodeGenSnippet visitNestedPackageId(@NonNull NestedPackageId id) {
		CodeGenText text = createNonInlinedSnippet(id, PackageId.class);
		text.appendReferenceTo(id.getParent());
		text.append(".getNestedPackageId(");
		text.appendString(id.getName());
		text.append(");\n");
		return text.getSnippet();
	}

	public @NonNull CodeGenSnippet visitNsURIPackageId(@NonNull NsURIPackageId id) {
		CodeGenText text = createNonInlinedSnippet(id, PackageId.class);
		CodeGenSnippet s = text.getSnippet();
//		EPackage ePackage = id.getEPackage();
//		assert ePackage != null;
		String nsURI = id.getNsURI();
		GenPackage genPackage = codeGenerator.getMetaModelManager().getGenPackage(nsURI);
		String nsURIString = Strings.convertToJavaString(nsURI);
		String ePackageString;
		if (genPackage != null) {
			ePackageString = genPackage.getQualifiedPackageInterfaceName() + ".eINSTANCE";
		}
		else {
			ePackageString = "null";
		}
		text.append(s.getImportedName(IdManager.class) + ".INSTANCE.getNsURIPackageId(\"" + nsURIString + "\", " + ePackageString + ");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitNullId(@NonNull OclVoidTypeId id) {
		String typeIdName = codeGenerator.getImportedName2(TypeId.class);
		CodeGenSnippet snippet = createInlinedSnippet(typeIdName + ".OCL_VOID", TypeId.OCL_VOID, OclVoidTypeId.class);
		snippet.addClassReference(TypeId.class);
		return snippet;
	}

	public @NonNull CodeGenSnippet visitOperationId(@NonNull OperationId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @NonNull CodeGenSnippet visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		String typeIdName = codeGenerator.getImportedName2(TypeId.class);
		String name = null;
		if (id == TypeId.BOOLEAN) {						// FIXME Do reflective field analysis
			name = typeIdName + ".BOOLEAN";
		}
		else if (id == TypeId.INTEGER) {
			name = typeIdName + ".INTEGER";
		}
		else if (id == TypeId.OCL_ANY) {
			name = typeIdName + ".OCL_ANY";
		}
		else if (id == TypeId.OCL_COMPARABLE) {
			name = typeIdName + ".OCL_COMPARABLE";
		}
		else if (id == TypeId.OCL_SUMMABLE) {
			name = typeIdName + ".OCL_SUMMABLE";
		}
		else if (id == TypeId.REAL) {
			name = typeIdName + ".REAL";
		}
		else if (id == TypeId.STRING) {
			name = typeIdName + ".STRING";
		}
		else if (id == TypeId.UNLIMITED_NATURAL) {
			name = typeIdName + ".UNLIMITED_NATURAL";
		}
		if (name != null) {
			CodeGenSnippet snippet = createInlinedSnippet(name, id, PrimitiveTypeId.class);
			snippet.addClassReference(TypeId.class);
			return snippet;
		}
		return visiting(id);
	}

	public @NonNull CodeGenSnippet visitPropertyId(@NonNull PropertyId id) {
		CodeGenText text = createNonInlinedSnippet(id, PropertyId.class);
		text.appendReferenceTo(id.getParent());
		text.append(".getPropertyId(");
		text.appendString(id.getName());
		text.append(");\n");
		return text.getSnippet();
	}

	public @NonNull CodeGenSnippet visitRootPackageId(@NonNull RootPackageId id) {
		CodeGenText text = createNonInlinedSnippet(id, PackageId.class);
		text.appendClassReference(IdManager.class);
		text.append(".INSTANCE.getRootPackageId()");
		text.appendString(id.getName());
		text.append(");\n");
		return text.getSnippet();
	}

	public @NonNull CodeGenSnippet visitTemplateBinding(@NonNull TemplateBinding id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @NonNull CodeGenSnippet visitTemplateParameterId(@NonNull TemplateParameterId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @NonNull CodeGenSnippet visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @NonNull CodeGenSnippet visitTuplePartId(@NonNull TuplePartId id) {
		CodeGenText text = createNonInlinedSnippet(id, TuplePartId.class);
		text.appendClassReference(IdManager.class);
		text.append(".INSTANCE.createTuplePartId(");
		text.appendString(id.getName());
		text.append(", ");
		text.appendReferenceTo(id.getTypeId());
		text.append(");\n");
		return text.getSnippet();
	}

	public @NonNull CodeGenSnippet visitTupleTypeId(@NonNull TupleTypeId id) {
		CodeGenText text = createNonInlinedSnippet(id, TupleTypeId.class);
		text.appendClassReference(IdManager.class);
		text.append(".INSTANCE.getTupleTypeId(");
		text.appendString(id.getName());
		for (TuplePartId partId : id.getPartIds()) {
			assert partId != null;
			text.append(", ");
			text.appendReferenceTo(partId);
		}
		text.append(");\n");
		return text.getSnippet();
	}

	public @NonNull CodeGenSnippet visitUnspecifiedId(@NonNull UnspecifiedId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}
	
	public @NonNull CodeGenSnippet visiting(@NonNull ElementId id) {
		throw new UnsupportedOperationException("Id: " + id.getClass().getName());
	}
}
