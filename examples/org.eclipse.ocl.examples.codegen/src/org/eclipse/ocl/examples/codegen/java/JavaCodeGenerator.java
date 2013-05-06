/**
 * <copyright>
 *
 * Copyright (c) 2011,2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 **/
package org.eclipse.ocl.examples.codegen.java;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.java.iteration.AnyIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.CollectIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.CollectNestedIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.ExistsIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.ForAllIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.IsUniqueIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.IterateIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.OneIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.RejectIteration2Java;
import org.eclipse.ocl.examples.codegen.java.iteration.SelectIteration2Java;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.library.iterator.AnyIteration;
import org.eclipse.ocl.examples.library.iterator.CollectIteration;
import org.eclipse.ocl.examples.library.iterator.CollectNestedIteration;
import org.eclipse.ocl.examples.library.iterator.ExistsIteration;
import org.eclipse.ocl.examples.library.iterator.ForAllIteration;
import org.eclipse.ocl.examples.library.iterator.IsUniqueIteration;
import org.eclipse.ocl.examples.library.iterator.IterateIteration;
import org.eclipse.ocl.examples.library.iterator.OneIteration;
import org.eclipse.ocl.examples.library.iterator.RejectIteration;
import org.eclipse.ocl.examples.library.iterator.SelectIteration;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * OCL2JavaClass supports generation of the content of a JavaClassFile to
 * provide the polymorphic implementation of an ExpressionInOCL.
 */
public abstract class JavaCodeGenerator extends AbstractCodeGenerator
{
	public static Map<Class<?>, Class<?>> javaPrimitiveClasses = new HashMap<Class<?>, Class<?>>();

	public static Map<String, Class<?>> javaPrimitiveNames = new HashMap<String, Class<?>>();
	{
		initPrimitive(boolean.class, Boolean.class);
		initPrimitive(byte.class, Byte.class);
		initPrimitive(char.class, Character.class);
		initPrimitive(double.class, Double.class);
		initPrimitive(float.class, Float.class);
		initPrimitive(int.class, Integer.class);
		initPrimitive(long.class, Long.class);
		initPrimitive(short.class, Short.class);
	}

	/**
	 * The known classes that templates may use in unqualified form. The list is
	 * here in a Java form to reduce the impact of refactoring on Acceleo
	 * templates.
	 */
	public static final @NonNull Class<?>[] knownClasses = {
		java.lang.Class.class,
		java.lang.Object.class,
		java.lang.Package.class,
		java.util.Iterator.class,
		org.eclipse.ocl.examples.domain.elements.DomainElement.class,
		org.eclipse.ocl.examples.domain.elements.DomainMetaclass.class,
		org.eclipse.ocl.examples.domain.elements.DomainCollectionType.class,
		org.eclipse.ocl.examples.domain.elements.DomainParameterTypes.class,
		org.eclipse.ocl.examples.domain.elements.DomainProperty.class,
		org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary.class,
		org.eclipse.ocl.examples.domain.elements.DomainTupleType.class,
		org.eclipse.ocl.examples.domain.elements.DomainType.class,
		org.eclipse.ocl.examples.domain.elements.DomainTypeParameters.class,
		org.eclipse.ocl.examples.domain.elements.DomainTypedElement.class,
		org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator.class,
		org.eclipse.ocl.examples.domain.ids.ClassId.class,
		org.eclipse.ocl.examples.domain.ids.CollectionTypeId.class,
		org.eclipse.ocl.examples.domain.ids.DataTypeId.class,
		org.eclipse.ocl.examples.domain.ids.EnumerationId.class,
		org.eclipse.ocl.examples.domain.ids.IdManager.class,
		org.eclipse.ocl.examples.domain.ids.MetaclassId.class,
		org.eclipse.ocl.examples.domain.ids.PackageId.class,
		org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId.class,
		org.eclipse.ocl.examples.domain.ids.TemplateParameterId.class,
		org.eclipse.ocl.examples.domain.ids.TuplePartId.class,
		org.eclipse.ocl.examples.domain.ids.TupleTypeId.class,
		org.eclipse.ocl.examples.domain.ids.TypeId.class,
		org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation.class,
		org.eclipse.ocl.examples.domain.library.AbstractProperty.class,
		org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation.class,
		org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation.class,
		org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation.class,
		org.eclipse.ocl.examples.domain.library.LibraryIteration.class,
		org.eclipse.ocl.examples.domain.library.LibraryProperty.class,
		org.eclipse.ocl.examples.domain.library.LibraryTernaryOperation.class,
		org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation.class,
		org.eclipse.ocl.examples.domain.messages.EvaluatorMessages.class,
		org.eclipse.ocl.examples.domain.values.BagValue.class,
		org.eclipse.ocl.examples.domain.values.CollectionValue.class,
		org.eclipse.ocl.examples.domain.values.IntegerRange.class,
		org.eclipse.ocl.examples.domain.values.IntegerValue.class,
		org.eclipse.ocl.examples.domain.values.InvalidValue.class,
		org.eclipse.ocl.examples.domain.values.OrderedSetValue.class,
		org.eclipse.ocl.examples.domain.values.RealValue.class,
		org.eclipse.ocl.examples.domain.values.SequenceValue.class,
		org.eclipse.ocl.examples.domain.values.SetValue.class,
		org.eclipse.ocl.examples.domain.values.TupleValue.class,
		org.eclipse.ocl.examples.domain.values.UnlimitedValue.class,
		org.eclipse.ocl.examples.domain.values.Value.class,
		org.eclipse.ocl.examples.domain.values.impl.InvalidValueException.class,
		org.eclipse.ocl.examples.domain.values.util.ValuesUtil.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumeration.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumerationLiteral.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorInvalidType.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorPackage.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorProperty.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorType.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorVoidType.class,
		org.eclipse.ocl.examples.library.executor.ExecutorDoubleIterationManager.class,
		org.eclipse.ocl.examples.library.executor.ExecutorFragment.class,
		org.eclipse.ocl.examples.library.executor.ExecutorLambdaType.class,
		org.eclipse.ocl.examples.library.executor.ExecutorOperation.class,
		org.eclipse.ocl.examples.library.executor.ExecutorProperty.class,
		org.eclipse.ocl.examples.library.executor.ExecutorPropertyWithImplementation.class,
		org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager.class,
		org.eclipse.ocl.examples.library.executor.ExecutorSpecializedType.class,
		org.eclipse.ocl.examples.library.executor.ExecutorStandardLibrary.class,
		org.eclipse.ocl.examples.library.executor.ExecutorType.class,
		org.eclipse.ocl.examples.library.executor.ExecutorTypeParameter.class,
		org.eclipse.ocl.examples.pivot.PivotPackage.class,
		org.eclipse.osgi.util.NLS.class};

	public static void initPrimitive(Class<?> class1, Class<?> class2) {
		javaPrimitiveClasses.put(class1, class2);
		javaPrimitiveNames.put(class1.getName(), class2);
	}

	private /*@LazyNonNull*/ Id2BoxedJavaClassVisitor id2BoxedJavaClassVisitor = null;
	private /*@LazyNonNull*/ Id2EClassVisitor id2EClassVisitor = null;
//	protected final @NonNull Id2JavaInterfaceVisitor id2JavaInterfaceVisitor;
	private /*@LazyNonNull*/ Id2UnboxedJavaClassVisitor id2UnboxedJavaClassVisitor = null;
	private /*@LazyNonNull*/ JavaGlobalContext globalContext = null;
	private @NonNull Map<CGTypeId, JavaTypeDescriptor> boxedTypeId2descriptor = new HashMap<CGTypeId, JavaTypeDescriptor>();
	private @NonNull Map<CGTypeId, JavaTypeDescriptor> unboxedTypeId2descriptor = new HashMap<CGTypeId, JavaTypeDescriptor>();

	public JavaCodeGenerator(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
	}

	public @NonNull BoxingAnalyzer createBoxingAnalyzer(@NonNull CodeGenAnalyzer analyzer) {
		return new BoxingAnalyzer(analyzer);
	}

	public @NonNull FieldingAnalyzer createFieldingAnalyzer(@NonNull CodeGenAnalyzer analyzer) {
		return new FieldingAnalyzer(analyzer);
	}

	@Override
	protected @NonNull GenModelHelper createGenModelHelper() {
		return new AbstractGenModelHelper(metaModelManager);
	}

	protected abstract @NonNull JavaGlobalContext createGlobalContext();

	protected @NonNull Id2BoxedJavaClassVisitor createId2BoxedJavaClassVisitor() {
		return new Id2BoxedJavaClassVisitor(genModelHelper);
	}

	protected @NonNull Id2EClassVisitor createId2EClassVisitor() {
		return new Id2EClassVisitor(metaModelManager);
	}

	protected @NonNull Id2UnboxedJavaClassVisitor createId2UnboxedJavaClassVisitor() {
		return new Id2UnboxedJavaClassVisitor(genModelHelper);
	}

	@Override
	protected @NonNull NameManager createNameManager() {
		return new NameManager();
	}

	public @NonNull Class<?> getBoxedClass(@NonNull ElementId elementId) {
		IdVisitor<Class<?>> id2BoxedClassVisitor = getId2BoxedClassVisitor();
		Class<?> javaClass = elementId.accept(id2BoxedClassVisitor);
		assert javaClass != null;
		return javaClass;
	}

	public @Nullable String getConstantsClass() {
		return null;
	}
	
	public @NonNull JavaGlobalContext getGlobalContext() {
		JavaGlobalContext globalContext2 = globalContext;
		if (globalContext2 == null) {
			globalContext = globalContext2 = createGlobalContext();
		}
		return globalContext2;
	}

	public @NonNull Id2BoxedJavaClassVisitor getId2BoxedClassVisitor() {
		Id2BoxedJavaClassVisitor id2BoxedJavaClassVisitor2 = id2BoxedJavaClassVisitor;
		if (id2BoxedJavaClassVisitor2 == null) {
			id2BoxedJavaClassVisitor = id2BoxedJavaClassVisitor2 = createId2BoxedJavaClassVisitor();
		}
		return id2BoxedJavaClassVisitor2;
	}

	public @NonNull Id2EClassVisitor getId2EClassVisitor() {
		Id2EClassVisitor id2EClassVisitor2 = id2EClassVisitor;
		if (id2EClassVisitor2 == null) {
			id2EClassVisitor = id2EClassVisitor2 = createId2EClassVisitor();
		}
		return id2EClassVisitor2;
	}

	public @NonNull Id2UnboxedJavaClassVisitor getId2UnboxedClassVisitor() {
		Id2UnboxedJavaClassVisitor id2UnboxedJavaClassVisitor2 = id2UnboxedJavaClassVisitor;
		if (id2UnboxedJavaClassVisitor2 == null) {
			id2UnboxedJavaClassVisitor = id2UnboxedJavaClassVisitor2 = createId2UnboxedJavaClassVisitor();
		}
		return id2UnboxedJavaClassVisitor2;
	}

	public @Nullable Iteration2Java getIterationHelper(@NonNull Iteration pivotIteration) {
		LibraryIteration libraryIteration = (LibraryIteration) pivotIteration.getImplementation();
		if (pivotIteration.getOwnedIterator().size() != 1) {
			return null;
		}
		if (libraryIteration instanceof AnyIteration) {
			return AnyIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof CollectIteration) {
			return CollectIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof CollectNestedIteration) {
			return CollectNestedIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof ExistsIteration) {
			return ExistsIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof ForAllIteration) {
			return ForAllIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof IsUniqueIteration) {
			return IsUniqueIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof IterateIteration) {
			return IterateIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof OneIteration) {
			return OneIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof RejectIteration) {
			return RejectIteration2Java.INSTANCE;
		}
		else if (libraryIteration instanceof SelectIteration) {
			return SelectIteration2Java.INSTANCE;
		}
		else {
			return null;
		}
	}

	public @NonNull JavaTypeDescriptor getJavaTypeDescriptor(@NonNull CGValuedElement cgElement) {
		CGTypeId cgTypeId = DomainUtil.nonNullState(cgElement.getTypeId());
		return getJavaTypeDescriptor(cgTypeId, cgElement.isBoxed());
	}

	public @NonNull JavaTypeDescriptor getJavaTypeDescriptor(@NonNull CGTypeId cgTypeId, boolean isBoxed) {
		Map<CGTypeId, JavaTypeDescriptor> typeId2descriptor = isBoxed ? boxedTypeId2descriptor : unboxedTypeId2descriptor;
		JavaTypeDescriptor javaTypeDescriptor = typeId2descriptor.get(cgTypeId);
		if (javaTypeDescriptor == null) {
			ElementId typeId = cgTypeId.getElementId();
			if (typeId instanceof JavaTypeId) {
				Class<?> javaClass = ((JavaTypeId)typeId).getJavaClass();
				javaTypeDescriptor = new JavaTypeDescriptor(javaClass);
			}
			else if (typeId == TypeId.INTEGER_RANGE) {
				javaTypeDescriptor = new JavaTypeDescriptor(IntegerRange.class);
			}
			else if (isBoxed && !(typeId instanceof ClassId)) {
				Class<?> javaClass = getBoxedClass(typeId);
				javaTypeDescriptor = new JavaTypeDescriptor(javaClass);
			}
			else if (typeId instanceof TypeId) {
				Type pivotType = metaModelManager.getIdResolver().getType((TypeId)typeId, null);
				EObject eTarget = null;
				for (DomainType dType : metaModelManager.getPartialTypes(pivotType)) {
					if (dType instanceof Type) {
						Type pType = (Type) dType;
						eTarget = pType.getETarget();
						if (eTarget != null) {
							pivotType = pType;
							break;
						}
					}
				}
				EClassifier eClassifier = eTarget instanceof EClassifier ? (EClassifier)eTarget : null;
				String className = null;
				Class<?> javaClass = null;
				try {
					if (eClassifier != null) {
						className = genModelHelper.getEcoreInterfaceClassifierName(eClassifier);
					}
					if (pivotType != null) {
						javaClass = genModelHelper.getEcoreInterfaceClass(pivotType);
					}
				}
				catch (Exception e) {
					javaClass = getUnboxedClass(typeId);
				}
				if (className == null) {
					className = javaClass.getName();
				}
				javaTypeDescriptor = new JavaTypeDescriptor(className, eClassifier, javaClass);
			}
			else {
				javaTypeDescriptor = new JavaTypeDescriptor(Object.class);
			}
			typeId2descriptor.put(cgTypeId, javaTypeDescriptor);
		}
		return javaTypeDescriptor;
	}

	public @NonNull Class<?> getUnboxedClass(@NonNull ElementId elementId) {
		IdVisitor<Class<?>> id2UnboxedClassVisitor = getId2UnboxedClassVisitor();
		Class<?> javaClass = elementId.accept(id2UnboxedClassVisitor);
		assert javaClass != null;
		return javaClass;
	}
}
