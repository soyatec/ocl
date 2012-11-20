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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
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
import org.eclipse.ocl.examples.domain.ids.PackageId;
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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.xtext.util.Strings;

public class Id2JavaSnippetVisitor implements IdVisitor<CodeGenSnippet>
{
	protected final @NonNull CodeGenerator codeGenerator;
	protected final @NonNull String typeIdName;
	protected final @NonNull String atNonNull;

	public Id2JavaSnippetVisitor(@NonNull CodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
		typeIdName = codeGenerator.getImportedName(TypeId.class);
		atNonNull = codeGenerator.atNonNull();
	}

	protected @NonNull CodeGenSnippet createInlinedSnippet(@NonNull String name, @NonNull TypeId typeId, @NonNull Class<? extends ElementId> javaClass) {
		return new JavaSnippet(name, typeId, javaClass, codeGenerator, "");
	}

	protected @NonNull <T extends ElementId> CodeGenText createNonInlinedSnippet(@NonNull T id, @NonNull Class<?> javaClass) {
		CodeGenSnippet s = new JavaSnippet("", codeGenerator, TypeId.METACLASS.getSpecializedId(id), javaClass, id, CodeGenSnippet.BOXED | CodeGenSnippet.FINAL);
		return s.append("private static final " + atNonNull + " " + codeGenerator.getImportedName(javaClass) + " " + s.getName() + " = ");
	}
	
	public @NonNull CodeGenSnippet visitCollectionId(@NonNull CollectionTypeId id) {
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
//		CodeGenText text = createNonInlinedSnippet(id, CollectionTypeId.class);
		CodeGenText text = createNonInlinedSnippet(id, CollectionTypeId.class);
//		CodeGenSnippet s = new JavaSnippet("", codeGenerator, id/*TypeId.METACLASS.getSpecializedId(id)*/, javaClass, id, CodeGenSnippet.BOXED | CodeGenSnippet.FINAL);
//		s.setIsStatic();
//		CodeGenText text = s.append("private static final " + atNonNull + " " + codeGenerator.getImportedName(javaClass) + " " + s.getName() + " = ");
		text.append(codeGenerator.getImportedName(TypeId.class) + "." + idName);
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

	public @NonNull CodeGenSnippet visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		CodeGenText text = createNonInlinedSnippet(id, EnumerationLiteralId.class);
		CodeGenSnippet s = text.getSnippet();
		String parentTypeId = s.getSnippetName(id.getParentId());
		String nameString = Strings.convertToJavaString(id.getName());
		text.append(parentTypeId + ".getEnumerationLiteralId(\"" + nameString + "\");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitInvalidId(@NonNull OclInvalidTypeId id) {
		return createInlinedSnippet(typeIdName + ".OCL_INVALID", TypeId.OCL_INVALID, OclInvalidTypeId.class);
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
		text.append(codeGenerator.getImportedName(TypeId.class) + ".METACLASS");
		if (id != TypeId.METACLASS) {
			text.append(".getSpecializedId(");
			ElementId elementId = id.getElementId();
			text.appendReferenceTo(elementId);
			text.append(")");
		}
		text.append(";\n");
		return text.getSnippet();
	}

	public @NonNull CodeGenSnippet visitNestedEnumerationId(@NonNull NestedEnumerationId id) {
		CodeGenText text = createNonInlinedSnippet(id, EnumerationId.class);
		CodeGenSnippet s = text.getSnippet();
		String parentTypeId = s.getSnippetName(id.getParent());
		String nameString = Strings.convertToJavaString(id.getName());
		text.append(parentTypeId + ".getNestedEnumerationId(\"" + nameString + "\");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitNestedPackageId(@NonNull NestedPackageId id) {
		CodeGenText text = createNonInlinedSnippet(id, NestedPackageId.class);
		CodeGenSnippet s = text.getSnippet();
		String parentTypeId = s.getSnippetName(id.getParent());
		String nameString = Strings.convertToJavaString(id.getName());
		text.append(parentTypeId + ".getNestedPackageId(\"" + nameString + "\");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitNestedTypeId(@NonNull NestedTypeId id) {
		CodeGenText text = createNonInlinedSnippet(id, TypeId.class);
		CodeGenSnippet s = text.getSnippet();
		String parentTypeId = s.getSnippetName(id.getParent());
		String nameString = Strings.convertToJavaString(id.getName());
		String templateParameterIds;
		TemplateParameterId[] templateParameters = id.getTemplateParameters();
		if (templateParameters.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (TemplateParameterId templateParameterId : templateParameters) {
				if (sb.length() > 0) {
					sb.append(", ");
				}
				sb.append(s.getSnippetName(templateParameterId));
			}
			templateParameterIds = sb.toString();
		}
		else {
			templateParameterIds = codeGenerator.getImportedName(TemplateParameterId.class) + ".NULL_TEMPLATE_PARAMETER_ID_ARRAY";
		}
		text.append(parentTypeId + ".getNestedTypeId(" + templateParameterIds + ", \"" + nameString + "\");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitNsURIPackageId(@NonNull NsURIPackageId id) {
		CodeGenText text = createNonInlinedSnippet(id, PackageId.class);
		CodeGenSnippet s = text.getSnippet();
		EPackage ePackage = id.getEPackage();
		assert ePackage != null;
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
		text.append(codeGenerator.getImportedName(IdManager.class) + ".INSTANCE.getNsURIPackageId(\"" + nsURIString + "\", " + ePackageString + ");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitNullId(@NonNull OclVoidTypeId id) {
		return createInlinedSnippet(typeIdName + ".OCL_VOID", TypeId.OCL_VOID, OclVoidTypeId.class);
	}

	public @NonNull CodeGenSnippet visitOperationId(@NonNull OperationId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @NonNull CodeGenSnippet visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
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
			return createInlinedSnippet(name, id, PrimitiveTypeId.class);
		}
		return visiting(id);
	}

	public @NonNull CodeGenSnippet visitRootPackageId(@NonNull RootPackageId id) {
		CodeGenText text = createNonInlinedSnippet(id, PackageId.class);
		CodeGenSnippet s = text.getSnippet();
		String name = id.getName();
		String nameString = Strings.convertToJavaString(name);
		text.append(codeGenerator.getImportedName(IdManager.class) + ".INSTANCE.getRootPackageId(\"" + nameString + "\");\n");
		return s;
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
		CodeGenSnippet s = text.getSnippet();
		String typeString = s.getSnippetName(id.getTypeId());
		String nameString = Strings.convertToJavaString(id.getName());
		text.append(codeGenerator.getImportedName(IdManager.class) + ".INSTANCE.createTuplePartId(\"" + nameString + "\", " + typeString + ");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitTupleTypeId(@NonNull TupleTypeId id) {
		CodeGenText text = createNonInlinedSnippet(id, TupleTypeId.class);
		CodeGenSnippet s = text.getSnippet();
		text.append(codeGenerator.getImportedName(IdManager.class) + ".INSTANCE.getTupleTypeId(\"" + Strings.convertToJavaString(id.getName()) + '"');
		for (TuplePartId partId : id.getPartIds()) {
			assert partId != null;
			text.append(", ");
			text.appendReferenceTo(partId);
		}
		text.append(");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitUnspecifiedId(@NonNull UnspecifiedId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}
	
	public @NonNull CodeGenSnippet visiting(@NonNull ElementId id) {
		throw new UnsupportedOperationException("Id: " + id.getClass().getName());
	}
}
