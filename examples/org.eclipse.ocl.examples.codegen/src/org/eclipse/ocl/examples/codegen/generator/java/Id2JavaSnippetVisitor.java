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
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet.AbstractTextAppender;
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

	protected @NonNull CodeGenSnippet createInlinedSnippet(@NonNull String name, @NonNull TypeId typeId, @NonNull Class<? extends ElementId> javaClass, @NonNull Object constantValue) {
		return new JavaSnippet(name, typeId, javaClass, constantValue, codeGenerator, "",
			CodeGenSnippet.CONSTANT | CodeGenSnippet.GLOBAL | CodeGenSnippet.INLINE | CodeGenSnippet.NON_NULL);
	}

	protected @NonNull <T extends ElementId> CodeGenSnippet createNonInlinedSnippet(@NonNull T id, @NonNull Class<?> javaClass) {
		return new JavaSnippet("", codeGenerator, TypeId.METACLASS.getSpecializedId(id), javaClass, id,
			CodeGenSnippet.BOXED | CodeGenSnippet.CONSTANT | CodeGenSnippet.GLOBAL | CodeGenSnippet.NON_NULL | CodeGenSnippet.SYNTHESIZED | CodeGenSnippet.UNBOXED);
	}

	public @NonNull CodeGenSnippet visitClassId(final @NonNull ClassId id) {
		CodeGenSnippet snippet = createNonInlinedSnippet(id, ClassId.class);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendReferenceTo(id.getParent());
				text.append(".getClassId(");
				text.appendString(id.getName());
				for (TemplateParameterId templateParameterId : id.getTemplateParameters()) {
					assert templateParameterId != null;
					text.append(", ");
					text.appendReferenceTo(templateParameterId);
				}
				text.append(")");
			}
		});
	}
	
	public @NonNull CodeGenSnippet visitCollectionTypeId(final @NonNull CollectionTypeId id) {
		CodeGenSnippet snippet = createNonInlinedSnippet(id, CollectionTypeId.class);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
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
			}
		});
	}

	public @NonNull CodeGenSnippet visitDataTypeId(final @NonNull DataTypeId id) {
		CodeGenSnippet snippet = createNonInlinedSnippet(id, DataTypeId.class);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendReferenceTo(id.getParent());
				text.append(".getDataTypeId(");
				text.appendString(id.getName());
				for (TemplateParameterId templateParameterId : id.getTemplateParameters()) {
					assert templateParameterId != null;
					text.append(", ");
					text.appendReferenceTo(templateParameterId);
				}
				text.append(")");
			}
		});
	}

	public @NonNull CodeGenSnippet visitEnumerationId(final @NonNull EnumerationId id) {
		CodeGenSnippet snippet = createNonInlinedSnippet(id, EnumerationId.class);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendReferenceTo(id.getParent());
				text.append(".getEnumerationId(");
				text.appendString(id.getName());
				text.append(")");
			}
		});
	}

	public @NonNull CodeGenSnippet visitEnumerationLiteralId(final @NonNull EnumerationLiteralId id) {
		CodeGenSnippet snippet = createNonInlinedSnippet(id, EnumerationLiteralId.class);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendReferenceTo(id.getParentId());
				text.append(".getEnumerationLiteralId(");
				text.appendString(id.getName());
				text.append(")");
			}
		});
	}

	public @NonNull CodeGenSnippet visitInvalidId(@NonNull OclInvalidTypeId id) {
		String typeIdName = codeGenerator.getImportedName2(TypeId.class);
		CodeGenSnippet snippet = createInlinedSnippet(typeIdName + ".OCL_INVALID", TypeId.OCL_INVALID, OclInvalidTypeId.class, id);
		snippet.addClassReference(TypeId.class);
		return snippet;
	}

	public @NonNull CodeGenSnippet visitLambdaTypeId(@NonNull LambdaTypeId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}
	
	public @NonNull CodeGenSnippet visitMetaclassId(final @NonNull MetaclassId id) {
		Class<?> javaClass = MetaclassId.class;
		CodeGenSnippet snippet = createNonInlinedSnippet(id, javaClass);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.append(text.getSnippet().getImportedName(TypeId.class) + ".METACLASS");
				if (id != TypeId.METACLASS) {
					text.append(".getSpecializedId(");
					ElementId elementId = id.getElementId();
					text.appendReferenceTo(elementId);
					text.append(")");
				}
			}
		});
	}

	public @NonNull CodeGenSnippet visitNestedPackageId(final @NonNull NestedPackageId id) {
		CodeGenSnippet snippet = createNonInlinedSnippet(id, PackageId.class);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendReferenceTo(id.getParent());
				text.append(".getNestedPackageId(");
				text.appendString(id.getName());
				text.append(")");
			}
		});
	}

	public @NonNull CodeGenSnippet visitNsURIPackageId(final @NonNull NsURIPackageId id) {
		CodeGenSnippet snippet = createNonInlinedSnippet(id, PackageId.class);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
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
				text.appendClassReference(IdManager.class);
				text.append(".INSTANCE.getNsURIPackageId(\"" + nsURIString + "\", " + ePackageString + ")");
			}
		});
	}

	public @NonNull CodeGenSnippet visitNullId(@NonNull OclVoidTypeId id) {
		String typeIdName = codeGenerator.getImportedName2(TypeId.class);
		CodeGenSnippet snippet = createInlinedSnippet(typeIdName + ".OCL_VOID", TypeId.OCL_VOID, OclVoidTypeId.class, id);
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
			CodeGenSnippet snippet = createInlinedSnippet(name, id, PrimitiveTypeId.class, id);
			snippet.addClassReference(TypeId.class);
			return snippet;
		}
		return visiting(id);
	}

	public @NonNull CodeGenSnippet visitPropertyId(final @NonNull PropertyId id) {
		CodeGenSnippet snippet = createNonInlinedSnippet(id, PropertyId.class);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendReferenceTo(id.getParent());
				text.append(".getPropertyId(");
				text.appendString(id.getName());
				text.append(")");
			}
		});
	}

	public @NonNull CodeGenSnippet visitRootPackageId(final @NonNull RootPackageId id) {
		CodeGenSnippet snippet = createNonInlinedSnippet(id, PackageId.class);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendClassReference(IdManager.class);
				text.append(".INSTANCE.getRootPackageId()");
				text.appendString(id.getName());
				text.append(")");
			}
		});
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

	public @NonNull CodeGenSnippet visitTuplePartId(final @NonNull TuplePartId id) {
		CodeGenSnippet snippet = createNonInlinedSnippet(id, TuplePartId.class);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendClassReference(IdManager.class);
				text.append(".INSTANCE.createTuplePartId(");
				text.appendString(id.getName());
				text.append(", ");
				text.appendReferenceTo(id.getTypeId());
				text.append(")");
			}
		});
	}

	public @NonNull CodeGenSnippet visitTupleTypeId(final @NonNull TupleTypeId id) {
		CodeGenSnippet snippet = createNonInlinedSnippet(id, TupleTypeId.class);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendClassReference(IdManager.class);
				text.append(".INSTANCE.getTupleTypeId(");
				text.appendString(id.getName());
				for (TuplePartId partId : id.getPartIds()) {
					assert partId != null;
					text.append(", ");
					text.appendReferenceTo(partId);
				}
				text.append(")");
			}
		});
	}

	public @NonNull CodeGenSnippet visitUnspecifiedId(@NonNull UnspecifiedId id) {
		// TODO Auto-generated method stub
		return visiting(id);
	}
	
	public @NonNull CodeGenSnippet visiting(@NonNull ElementId id) {
		throw new UnsupportedOperationException("Id: " + id.getClass().getName());
	}
}
