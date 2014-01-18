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
package org.eclipse.ocl.examples.codegen.java.types;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.AbstractId2JavaClassVisitor;
import org.eclipse.ocl.examples.codegen.java.Id2BoxedJavaClassVisitor;
import org.eclipse.ocl.examples.codegen.java.Id2UnboxedJavaClassVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.domain.elements.DomainLambdaType;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.DataTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
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
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableTypeId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.ids.UnspecifiedId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public class Id2BoxedDescriptorVisitor implements IdVisitor<BoxedDescriptor>
{
	protected final @NonNull JavaCodeGenerator javaCodeGenerator;
	protected final @NonNull GenModelHelper genModelHelper;
	protected final @NonNull MetaModelManager metaModelManager;
	private /*@LazyNonNull*/ Id2BoxedJavaClassVisitor id2BoxedJavaClassVisitor = null;
	private /*@LazyNonNull*/ Id2UnboxedJavaClassVisitor id2UnboxedJavaClassVisitor = null;
	
	public Id2BoxedDescriptorVisitor(@NonNull JavaCodeGenerator javaCodeGenerator) {
		this.javaCodeGenerator = javaCodeGenerator;
		this.genModelHelper = javaCodeGenerator.getGenModelHelper();
		this.metaModelManager = javaCodeGenerator.getMetaModelManager();
	}

	protected @NonNull Id2BoxedJavaClassVisitor createId2BoxedJavaClassVisitor() {
		return new Id2BoxedJavaClassVisitor(genModelHelper);
	}

	protected @NonNull Id2UnboxedJavaClassVisitor createId2UnboxedJavaClassVisitor() {
		return new Id2UnboxedJavaClassVisitor(genModelHelper);
	}

//	protected EClass getEClass(@NonNull Type type) {
//		return (EClass) getEClassifier(type);
//	}
	
	public EClassifier getEClassifier(@NonNull Type type) {
		for (DomainType dType : metaModelManager.getPartialTypes(type)) {
			if (dType instanceof Type) {
				Type pType = (Type) dType;
				EClassifier eClass = (EClassifier) pType.getETarget();
				if (eClass != null) {
					return eClass;
				}
			}
		}
		return null;
	}

	public @NonNull Id2BoxedJavaClassVisitor getId2BoxedClassVisitor() {
		Id2BoxedJavaClassVisitor id2BoxedJavaClassVisitor2 = id2BoxedJavaClassVisitor;
		if (id2BoxedJavaClassVisitor2 == null) {
			id2BoxedJavaClassVisitor = id2BoxedJavaClassVisitor2 = createId2BoxedJavaClassVisitor();
		}
		return id2BoxedJavaClassVisitor2;
	}

	public @NonNull Id2UnboxedJavaClassVisitor getId2UnboxedClassVisitor() {
		Id2UnboxedJavaClassVisitor id2UnboxedJavaClassVisitor2 = id2UnboxedJavaClassVisitor;
		if (id2UnboxedJavaClassVisitor2 == null) {
			id2UnboxedJavaClassVisitor = id2UnboxedJavaClassVisitor2 = createId2UnboxedJavaClassVisitor();
		}
		return id2UnboxedJavaClassVisitor2;
	}

	@Override
	public @NonNull BoxedDescriptor visitClassId(@NonNull ClassId id) {
		Type type = metaModelManager.getIdResolver().getType(id, null);
		EClassifier eClassifier = getEClassifier(type);
		if (eClassifier != null) {
			try {
				Class<?> javaClass = genModelHelper.getEcoreInterfaceClassifier(eClassifier);
				return new EObjectDescriptor(id, eClassifier, javaClass);
			}
			catch (Exception e) {
				String instanceClassName = type.getInstanceClassName();
				if (instanceClassName == null) {
					instanceClassName = genModelHelper.getEcoreInterfaceClassifierName(eClassifier);
				}
				if (instanceClassName != null) {
					return new FutureEObjectDescriptor(id, eClassifier, instanceClassName);
				}
			}
		}
		return visiting(id);
	}
	
	@Override
	public @NonNull BoxedDescriptor visitCollectionTypeId(@NonNull CollectionTypeId id) {
/*		CollectionTypeId generalizedId = id.getGeneralizedId();
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
		return CollectionValue.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitDataTypeId(@NonNull DataTypeId id) {
		Type type = metaModelManager.getIdResolver().getType(id, null);
		String instanceClassName = type.getInstanceClassName();
		if (instanceClassName != null) {
			return new SimpleDataTypeDescriptor(id, instanceClassName);
		}
		return visiting(id);
	}

	protected @Nullable SimpleDescriptor getDataTypeDescriptor(@NonNull DataTypeId elementId) {
		Type type = metaModelManager.getIdResolver().getType(elementId, null);
		String instanceClassName = type.getInstanceClassName();
		if (instanceClassName == null) {
			return null;
		}
		return new SimpleDataTypeDescriptor(elementId, instanceClassName); /// ?? ObjectValue/Object
	}

	@Override
	public @NonNull BoxedDescriptor visitEnumerationId(@NonNull EnumerationId id) {
/*		return EnumerationLiteralId.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
/*		return EnumerationLiteralId.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitInvalidId(@NonNull OclInvalidTypeId id) {
/*		return InvalidValueException.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitLambdaTypeId(@NonNull LambdaTypeId id) {
/*		return DomainLambdaType.class; */
		return visiting(id);
	}
	
	@Override
	public @NonNull BoxedDescriptor visitMetaclassId(@NonNull MetaclassId id) {
/*		if (id.getElementId() instanceof EnumerationLiteralId) {
			return EnumerationLiteralId.class;
		}
		return DomainType.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitNestedPackageId(@NonNull NestedPackageId id) {
/*		return DomainPackage.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitNsURIPackageId(@NonNull NsURIPackageId id) {
/*		return DomainPackage.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitNullId(@NonNull OclVoidTypeId id) {
/*		return Object.class;		// NullValue is never used */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitOperationId(@NonNull OperationId id) {
/*		return DomainOperation.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
/*		if (id instanceof JavaTypeId) {
			return ((JavaTypeId)id).getJavaClass();
		}
		else if (id == TypeId.BOOLEAN) {						// FIXME Do reflective field analysis
			return Boolean.class;
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
		else if (id == TypeId.STRING) {
			return String.class;
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
		return visiting(id); */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitPropertyId(@NonNull PropertyId id) {
/*		return DomainProperty.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitRootPackageId(@NonNull RootPackageId id) {
/*		return DomainPackage.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitTemplateBinding(@NonNull TemplateBinding id) {
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitTemplateParameterId(@NonNull TemplateParameterId id) {
/*		return Object.class;				// FIXME */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
/*		return DomainType.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitTuplePartId(@NonNull TuplePartId id) {
/*		return DomainProperty.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitTupleTypeId(@NonNull TupleTypeId id) {
/*		return TupleValue.class; */
		return visiting(id);
	}

	@Override
	public @NonNull BoxedDescriptor visitUnspecifiedId(@NonNull UnspecifiedId id) {
		return visiting(id);
	}
	
	public @NonNull BoxedDescriptor visiting(@NonNull ElementId elementId) {
//		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + id.getClass().getName());
		Class<?> boxedClass = getId2BoxedClassVisitor().doVisit(elementId);
		Class<?> unboxedClass = getId2UnboxedClassVisitor().doVisit(elementId);
		if (boxedClass == unboxedClass) {
			BoxedDescriptor simpleDescriptor;
			if (boxedClass == Object.class) {
				simpleDescriptor = new RootObjectDescriptor(elementId);
			}
			else if (boxedClass == Boolean.class) {
				simpleDescriptor = new BooleanObjectDescriptor(elementId);
			}
			else if (boxedClass == boolean.class) {
				simpleDescriptor = new BooleanObjectDescriptor(elementId);
//				maybePrimitive = true;
			}
			else {
				simpleDescriptor = new SimpleValueDescriptor(elementId, boxedClass);
			}
			return simpleDescriptor;
		}
		{
			UnboxedDescriptor unboxedDescriptor = null;
			if (unboxedClass == Object.class) {
				unboxedDescriptor = new RootObjectDescriptor(elementId);
			}
			else if (elementId instanceof CollectionTypeId) {
				CollectionTypeId collectionTypeId = (CollectionTypeId)elementId;
				TypeId generalizedId = collectionTypeId.getGeneralizedId();
				Type type;
				if (generalizedId == collectionTypeId) {
					type = metaModelManager.getIdResolver().getType(collectionTypeId, null);
				}
				else {
					TypeId typeId = collectionTypeId.getElementTypeId();
					type = metaModelManager.getIdResolver().getType(typeId, null);
				}
				EClassifier eClassifier = getEClassifier(type);
				if (eClassifier != null) {
					try {
						Class<?> javaClass = genModelHelper.getEcoreInterfaceClassifier(eClassifier);
						unboxedDescriptor = new EObjectsDescriptor(collectionTypeId, eClassifier, javaClass);
					}
					catch (Exception e) {
						String instanceClassName = type.getInstanceClassName();
						if (instanceClassName == null) {
							instanceClassName = genModelHelper.getEcoreInterfaceClassifierName(eClassifier);
						}
						if (instanceClassName != null) {
							unboxedDescriptor = new FutureEObjectsDescriptor(collectionTypeId, eClassifier, instanceClassName);
						}
//						else {
//							unboxedDescriptor = new UnboxedDynamicEObjectsDescriptor(collectionTypeId, eClassifier);
//						}
					}
				}
				if (unboxedDescriptor == null) {
					unboxedDescriptor = new UnboxedElementsDescriptor(collectionTypeId, metaModelManager, type);
				}
			}
			else {
				unboxedDescriptor = new UnboxedValueDescriptor(elementId, unboxedClass);
			}
			return new BoxedValueDescriptor(elementId, boxedClass, unboxedDescriptor);
		}
	}
}
