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
package org.eclipse.ocl.examples.codegen.generator;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.LambdaTypeId;
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

public class Id2JavaVisitor implements IdVisitor<CodeGenSnippet>
{
	protected final @NonNull OCLCodeGenerator codeGenerator;
	protected final @NonNull String typeIdName;
	protected final @NonNull String atNonNull;

	public Id2JavaVisitor(@NonNull OCLCodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
		typeIdName = codeGenerator.getImportedName(TypeId.class);
		atNonNull = codeGenerator.atNonNull();
	}

	protected @NonNull CodeGenSnippet createInlinedSnippet(@NonNull String name, @NonNull Class<? extends ElementId> javaClass) {
		CodeGenSnippet s = new CodeGenSnippet(name, javaClass, codeGenerator);
		s.setIsInlined();
		s.setIsStatic();
		return s;
	}

	protected @NonNull <T extends ElementId> CodeGenSnippet createNonInlinedSnippet(@NonNull T id, @NonNull Class<? extends T> javaClass) {
		CodeGenSnippet s = new CodeGenSnippet(codeGenerator, id);
		s.setIsStatic();
		s.append("private static final " + atNonNull + " " + codeGenerator.getImportedName(javaClass) + " " + s.getName() + " = ");
		return s;
	}
	
	public @NonNull CodeGenSnippet visit(@NonNull ElementId id) {
		CodeGenSnippet s = id.accept(this);
		assert s != null;
		return s;
	}
	
	public @NonNull CodeGenSnippet visitCollectionId(@NonNull CollectionTypeId id) {
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
		CodeGenSnippet s = createNonInlinedSnippet(id, CollectionTypeId.class);
		s.append(codeGenerator.getImportedName(TypeId.class) + "." + idName +".getSpecializedId(");
		if (id instanceof SpecializedId) {
			TemplateBindings templateBindings = ((SpecializedId)id).getTemplateBindings();
			for (int i = 0; i < templateBindings.parametersSize(); i++) {
				if (i > 0) {
					s.append(", ");
				}
				ElementId elementId = DomainUtil.nonNullModel(templateBindings.get(i));
				s.appendReference(elementId);
			}
		}
		s.append(");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @NonNull CodeGenSnippet visitInvalidId(@NonNull OclInvalidTypeId id) {
		return createInlinedSnippet(typeIdName + ".OCL_INVALID", OclInvalidTypeId.class);
	}

	public @NonNull CodeGenSnippet visitLambdaTypeId(@NonNull LambdaTypeId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}

	public @NonNull CodeGenSnippet visitNestedPackageId(@NonNull NestedPackageId id) {
		CodeGenSnippet s = createNonInlinedSnippet(id, NestedPackageId.class);
		String parentTypeId = s.getConstant(id.getParent()).getName();
		String nameString = Strings.convertToJavaString(id.getName());
		s.append(parentTypeId + ".getNestedPackageId(\"" + nameString + "\");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitNestedTypeId(@NonNull NestedTypeId id) {
		CodeGenSnippet s = createNonInlinedSnippet(id, TypeId.class);
		String parentTypeId = s.getConstant(id.getParent()).getName();
		String nameString = Strings.convertToJavaString(id.getName());
		String templateParameterIds;
		TemplateParameterId[] templateParameters = id.getTemplateParameters();
		if (templateParameters.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (TemplateParameterId templateParameterId : templateParameters) {
				if (sb.length() > 0) {
					sb.append(", ");
				}
				sb.append(s.getConstantName(templateParameterId));
			}
			templateParameterIds = sb.toString();
		}
		else {
			templateParameterIds = codeGenerator.getImportedName(TemplateParameterId.class) + ".NULL_TEMPLATE_PARAMETER_ID_ARRAY";
		}
		s.append(parentTypeId + ".getNestedTypeId(" + templateParameterIds + ", \"" + nameString + "\");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitNsURIPackageId(@NonNull NsURIPackageId id) {
		CodeGenSnippet s = createNonInlinedSnippet(id, PackageId.class);
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
		s.append(codeGenerator.getImportedName(IdManager.class) + ".INSTANCE.getNsURIPackageId(\"" + nsURIString + "\", " + ePackageString + ");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitNullId(@NonNull OclVoidTypeId id) {
		return createInlinedSnippet(typeIdName + ".OCL_VOID", OclVoidTypeId.class);
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
			return createInlinedSnippet(name, PrimitiveTypeId.class);
		}
		return visiting(id);
	}

	public @NonNull CodeGenSnippet visitRootPackageId(@NonNull RootPackageId id) {
		CodeGenSnippet s = createNonInlinedSnippet(id, PackageId.class);
		String name = id.getName();
		String nameString = Strings.convertToJavaString(name);
		s.append(codeGenerator.getImportedName(IdManager.class) + ".INSTANCE.getRootPackageId(\"" + nameString + "\");\n");
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
		CodeGenSnippet s = createNonInlinedSnippet(id, TuplePartId.class);
		String typeString = s.getConstant(id.getTypeId()).getName();
		String nameString = Strings.convertToJavaString(id.getName());
		s.append(codeGenerator.getImportedName(IdManager.class) + ".INSTANCE.createTuplePartId(\"" + nameString + "\", " + typeString + ");\n");
		return s;
	}

	public @NonNull CodeGenSnippet visitTupleTypeId(@NonNull TupleTypeId id) {
		CodeGenSnippet s = createNonInlinedSnippet(id, TupleTypeId.class);
		s.append(codeGenerator.getImportedName(IdManager.class) + ".INSTANCE.getTupleTypeId(\"" + Strings.convertToJavaString(id.getName()) + '"');
		for (TuplePartId partId : id.getPartIds()) {
			assert partId != null;
			s.append(", ");
			s.appendReference(partId);
		}
		s.append(");\n");
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
