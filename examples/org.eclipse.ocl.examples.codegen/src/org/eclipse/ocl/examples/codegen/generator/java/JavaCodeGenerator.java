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
package org.eclipse.ocl.examples.codegen.generator.java;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet.AbstractTextAppender;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.ConstantHelper;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.ImportManager;
import org.eclipse.ocl.examples.codegen.inliner.java.JavaIterationInliners;
import org.eclipse.ocl.examples.codegen.inliner.java.JavaOperationInliners;
import org.eclipse.ocl.examples.codegen.inliner.java.JavaPropertyInliners;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.DomainMessage;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * OCL2JavaClass supports generation of the content of a JavaClassFile to
 * provide the polymorphic implementation of an ExpressionInOCL.
 */
public abstract class JavaCodeGenerator
		extends AbstractCodeGenerator {

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
	public static final @NonNull
	Class<?>[] knownClasses = {
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

	private String evaluatorName = null;

	private CodeGenSnippet evaluatorSnippet = null;

	private String selfName = null;

	private CodeGenSnippet selfSnippet = null;

	private CodeGenSnippet standardLibraryName = null;

	private CodeGenSnippet idResolverName = null;

	public JavaCodeGenerator(@NonNull MetaModelManager metaModelManager,
			@Nullable Map<Object, CodeGenSnippet> globalSnippets) {
		super(metaModelManager, globalSnippets);
		initInliners();
	}

	protected JavaCodeGenerator(@NonNull MetaModelManager metaModelManager,
			@NonNull NameManager nameManager,
			@NonNull ConstantHelper constantHelper,
			@NonNull ImportManager importManager,
			@NonNull GenModelHelper genModelHelper,
			@NonNull Id2JavaSnippetVisitor idVisitor,
			@NonNull AST2JavaSnippetVisitor astVisitor) {
		super(metaModelManager, nameManager, constantHelper, importManager,
			genModelHelper, idVisitor, astVisitor);
		initInliners();
	}

	@Override
	protected @NonNull
	Visitor<CodeGenSnippet> createAST2SnippetVisitor() {
		return new AST2JavaSnippetVisitor(this);
	}

	public @NonNull
	JavaSnippet createCodeGenSnippet(@Nullable String indentation, int flags) {
		return new JavaSnippet(indentation != null
			? indentation
			: getDefaultIndent(), this, flags);
	}

	@Override
	protected @NonNull
	ConstantHelper createConstantHelper() {
		return new JavaConstantHelper(this);
	}

	protected @NonNull
	CodeGenSnippet createEvaluatorSnippet(
			@NonNull CodeGenSnippet referringSnippet) {
		return new JavaSnippet(getEvaluatorName(), TypeId.OCL_ANY,
			DomainEvaluator.class, this, "", CodeGenSnippet.INLINE
				| CodeGenSnippet.NON_NULL | CodeGenSnippet.SYNTHESIZED);
	}

	@Override
	protected @NonNull
	GenModelHelper createGenModelHelper() {
		return new AbstractGenModelHelper(metaModelManager);
	}

	@Override
	protected @NonNull
	IdVisitor<CodeGenSnippet> createId2SnippetVisitor() {
		return new Id2JavaSnippetVisitor(this);
	}

	@Override
	protected @NonNull
	ImportManager createImportManager() {
		return new JavaImportManager(knownClasses);
	}

	@Override
	protected @NonNull
	NameManager createNameManager() {
		return new NameManager();
	}

	protected @NonNull
	CodeGenSnippet createSelfSnippet() {
		CodeGenSnippet snippet = new JavaSnippet(getSelfName(), TypeId.OCL_ANY,
			Object.class, this, "", CodeGenSnippet.NON_NULL
				| CodeGenSnippet.SYNTHESIZED);
		// System.out.println("selfSnippet " +
		// DomainUtil.debugSimpleName(selfSnippet2));
		return snippet;
	}

	protected void generateEvaluateFunction(@NonNull CodeGenSnippet snippet,
			@NonNull Class<?> returnClass, boolean isRequired,
			@NonNull ExpressionInOCL expression) {
		OCLExpression bodyExpression = DomainUtil.nonNullModel(expression
			.getBodyExpression());
		//
		// Reserve declaration names
		//
		String returnTypeIdName = nameManager.reserveName("returnTypeId", null);
		CodeGenAnalysis bodyAnalysis = getAnalysis(bodyExpression);
		if (!bodyAnalysis.isConstant()) {
			nameManager.getSymbolName(bodyExpression, "result");
		}
		//
		// "evaluate" function declaration
		//
		CodeGenSnippet evaluateSnippet = snippet.appendIndentedNodes(null,
			CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		CodeGenText evaluateDecl = evaluateSnippet.appendIndentedText("");
		evaluateDecl.append("@Override\n");
		evaluateDecl.append("public " + (isRequired
			? evaluateSnippet.atNonNull(false)
			: evaluateSnippet.atNullable()) + " /*@Thrown*/ ");
		evaluateDecl.appendClassReference(returnClass);
		evaluateDecl.append(" evaluate(");
		evaluateDecl.appendDeclaration(getEvaluatorSnippet(evaluateSnippet));
		evaluateDecl.append(", final " + evaluateSnippet.atNonNull(false)
			+ " /*@NonInvalid*/ "
			+ evaluateSnippet.getImportedName(TypeId.class) + " "
			+ returnTypeIdName + ", ");
		evaluateDecl.appendDeclaration(getSnippet(expression
			.getContextVariable()));
		for (Variable parameter : expression.getParameterVariable()) {
			evaluateDecl.append(", ");
			evaluateDecl.appendDeclaration(getSnippet(parameter));
		}
		evaluateDecl.append(") {\n");
		CodeGenSnippet evaluateNodes = evaluateSnippet.appendIndentedNodes(
			null, CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		CodeGenSnippet localRoot = evaluateNodes.appendIndentedNodes("",
			CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		getSnippetLabel(LOCAL_ROOT).push(localRoot);
		getSnippetLabel(SCOPE_ROOT).push(localRoot);
		getEvaluatorSnippet(evaluateSnippet).addDependsOn(localRoot);
		//
		// "evaluate" function body
		//
		CodeGenSnippet evaluateBodySnippet = evaluateNodes
			.appendBoxedGuardedChild(bodyExpression, isRequired
				? DomainMessage.NULL
				: null, DomainMessage.INVALID);
		if (evaluateBodySnippet != null) {
			if (!evaluateBodySnippet.isInvalid()) {
				CodeGenText returnText = evaluateNodes.append("return ");
				returnText.appendReferenceTo(returnClass, evaluateBodySnippet);
				returnText.append(";\n");
			} else if (!evaluateBodySnippet.isCaught()
				&& !evaluateBodySnippet.isInline()) {
				/* Already thrown */
			} else {
				CodeGenText returnText = evaluateNodes.append("throw ");
				returnText.appendReferenceTo(Exception.class,
					evaluateBodySnippet);
				returnText.append(";\n");
			}
		}
		evaluateSnippet.append("}\n");
	}

	public @NonNull
	Class<?> getBoxedClass(@NonNull TypeId typeId) {
		IdVisitor<Class<?>> id2BoxedClassVisitor = getId2BoxedClassVisitor();
		Class<?> javaClass = typeId.accept(id2BoxedClassVisitor);
		assert javaClass != null;
		return javaClass;
	}

	public @Nullable
	String getConstantsClass() {
		return null;
	}

	public @NonNull
	String getEvaluatorName() {
		String evaluatorName2 = evaluatorName;
		if (evaluatorName2 == null) {
			evaluatorName = evaluatorName2 = nameManager.reserveName(
				"evaluator", null);
		}
		return evaluatorName2;
	}

	public @NonNull
	CodeGenSnippet getEvaluatorSnippet(@NonNull CodeGenSnippet referringSnippet) {
		CodeGenSnippet evaluatorSnippet2 = evaluatorSnippet;
		if (evaluatorSnippet2 == null) {
			// System.out.println("evaluatorSnippet " +
			// DomainUtil.debugSimpleName(evaluatorSnippet2));
			evaluatorSnippet2 = evaluatorSnippet = createEvaluatorSnippet(referringSnippet);
		}
		return evaluatorSnippet2;
	}

	public @NonNull
	IdVisitor<Class<?>> getId2BoxedClassVisitor() {
		return Id2BoxedJavaClassVisitor.INSTANCE;
	}

	public @NonNull
	IdVisitor<Class<?>> getId2UnboxedClassVisitor() {
		return Id2UnboxedJavaClassVisitor.INSTANCE;
	}

	public @NonNull
	CodeGenSnippet getIdResolver() {
		CodeGenSnippet idResolverName2 = idResolverName;
		if (idResolverName2 == null) {
			String name = nameManager.reserveName("idResolver", null);
			idResolverName = idResolverName2 = new JavaSnippet(name,
				TypeId.OCL_ANY, IdResolver.class, this, "",
				CodeGenSnippet.ERASED | CodeGenSnippet.NON_NULL
					| CodeGenSnippet.SYNTHESIZED);
			// CodeGenText text = idResolverName.append("final " +
			// referringSnippet.atNonNull() + " " +
			// referringSnippet.getImportedName(DomainStandardLibrary.class) +
			// " " + name + " = ");
			return idResolverName.appendText("", new AbstractTextAppender() {

				@Override
				public void appendToBody(@NonNull CodeGenText text) {
					text.appendReferenceTo(null,
						getEvaluatorSnippet(text.getSnippet()));
					text.append(".getIdResolver()");
				}
			});
			// System.out.println("idResolverName " +
			// DomainUtil.debugSimpleName(idResolverName));
		}
		// referringSnippet.addDependsOn(idResolverName2);
		return idResolverName2;
	}

	public @NonNull
	String getSelfName() {
		String selfName2 = selfName;
		if (selfName2 == null) {
			selfName = selfName2 = nameManager.reserveName("self", null);
		}
		return selfName2;
	}

	public @NonNull
	CodeGenSnippet getSelfSnippet(@NonNull CodeGenSnippet referringSnippet) {
		CodeGenSnippet selfSnippet2 = selfSnippet;
		if (selfSnippet2 == null) {
			selfSnippet2 = selfSnippet = createSelfSnippet();
			referringSnippet.addDependsOn(selfSnippet2);
			addDependency(CodeGenerator.LOCAL_ROOT, selfSnippet2);
		}
		return selfSnippet2;
	}

	public @NonNull
	CodeGenSnippet getStandardLibrary(@NonNull CodeGenSnippet referringSnippet) {
		CodeGenSnippet standardLibraryName2 = standardLibraryName;
		if (standardLibraryName2 == null) {
			String name = nameManager.reserveName("standardLibrary", null);
			standardLibraryName = standardLibraryName2 = new JavaSnippet(name,
				TypeId.OCL_ANY, DomainStandardLibrary.class, this, "",
				CodeGenSnippet.INLINE | CodeGenSnippet.NON_NULL);
			standardLibraryName.append("final " + referringSnippet.atNonNull(false)
				+ " "
				+ referringSnippet.getImportedName(DomainStandardLibrary.class)
				+ " " + name + " = " + getEvaluatorName()
				+ ".getStandardLibrary();\n");
		}
		referringSnippet.addDependsOn(standardLibraryName2);
		addDependency(CodeGenerator.LOCAL_ROOT, standardLibraryName2);
		return standardLibraryName2;
	}

	public @NonNull
	Class<?> getUnboxedClass(@NonNull Type type) {
		Class<?> typeIdClass = getUnboxedClass(type.getTypeId());
		Class<?> instanceClass = null;
		if (type instanceof DataType) {
			String instanceClassName = ((DataType) type).getInstanceClassName();
			if (instanceClassName != null) {
				try {
					Class<?> primitiveClass = javaPrimitiveNames
						.get(instanceClassName);
					if (primitiveClass != null) {
						return primitiveClass;
					}
					instanceClass = type.getClass().getClassLoader()
						.loadClass(instanceClassName);
				} catch (Exception e) {

				}
			}
		}
		if ((instanceClass != null)
			&& typeIdClass.isAssignableFrom(instanceClass)) {
			return instanceClass;
		} else if (instanceClass == Character.class) { // FIXME Should this be
														// standard ?
			return instanceClass;
		} else {
			return typeIdClass;
		}
	}

	public @NonNull
	Class<?> getUnboxedClass(@NonNull TypeId typeId) {
		IdVisitor<Class<?>> id2UnboxedClassVisitor = getId2UnboxedClassVisitor();
		Class<?> javaClass = typeId.accept(id2UnboxedClassVisitor);
		assert javaClass != null;
		return javaClass;
	}

	protected void initInliners() {
		new JavaPropertyInliners(this);
		new JavaOperationInliners(this);
		new JavaIterationInliners(this);
	}

	@Override
	protected void resetLocals() {
		evaluatorName = null;
		evaluatorSnippet = null;
		idResolverName = null;
		selfName = null;
		selfSnippet = null;
		standardLibraryName = null;
	}
}
