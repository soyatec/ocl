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
package org.eclipse.ocl.examples.codegen.java;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CGUtils;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAssertNonNullExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElementId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorCompositionProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorNavigationProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositeProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInteger;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsEqualExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGReal;
import org.eclipse.ocl.examples.codegen.cgmodel.CGString;
import org.eclipse.ocl.examples.codegen.cgmodel.CGText;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnlimited;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractExtendingCGModelVisitor;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.NestedTypeId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibrarySimpleOperation;
import org.eclipse.ocl.examples.domain.library.LibraryUntypedOperation;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorDoubleIterationManager;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.xtext.util.Strings;

/**
 * A CG2JavaVisitor serializes the contributions of a tree of model elements in a StringBuilder whose result may be
 * obtained by toString() on completion.
 * 
 * The individual visits contribute a complete construct, usually one or more statements to the output. However
 * inlineable expressions contribute just their expression value.
 * 
 * Visits return true if the generated flow of control flows out of the gebnerated code,
 * false if an uncondituionl exception is thrown.
 */
public abstract class CG2JavaVisitor extends AbstractExtendingCGModelVisitor<Boolean, JavaCodeGenerator>
{
	protected final @NonNull JavaGlobalContext globalContext;
	protected final @NonNull GenModelHelper genModelHelper;
	protected final @NonNull CodeGenAnalyzer analyzer;
	protected final @NonNull Id2JavaInterfaceVisitor id2JavaInterfaceVisitor;
	protected final @NonNull JavaStream js;
	
	/**
	 * The local Java context for the current operation.
	 */
	protected JavaLocalContext localContext;
	
	/**
	 * Scoping prefix for "this"
	 */
	private @Nullable String localPrefix = null;
	
	public CG2JavaVisitor(@NonNull JavaCodeGenerator codeGenerator) {
		super(codeGenerator);
		this.globalContext = codeGenerator.getGlobalContext();
		this.genModelHelper = context.getGenModelHelper();
		this.analyzer = context.getAnalyzer();
		this.id2JavaInterfaceVisitor = createId2JavaClassVisitor();
		this.js = new JavaStream(codeGenerator, this);
	}

	protected void addImport(@NonNull String className) {
		globalContext.addImport(className);
	}

	protected void appendGlobalPrefix() {}

	protected @NonNull Boolean appendLoopCall(@NonNull CGLibraryIterationCallExp cgIterationCallExp, @Nullable CGIterator iterateResult) {
		final CGValuedElement source = getExpression(cgIterationCallExp.getSource());
		final List<CGIterator> iterators = cgIterationCallExp.getIterators();
		final CGValuedElement body = getExpression(cgIterationCallExp.getBody());
		final CGTypeId resultType = cgIterationCallExp.getTypeId();
		final Operation referredOperation = ((LoopExp)cgIterationCallExp.getAst()).getReferredIteration();
		final Class<?> operationClass = genModelHelper.getAbstractOperationClass(iterators);
		final int arity = iterators.size();
		final Class<?> managerClass = arity == 1 ? ExecutorSingleIterationManager.class : ExecutorDoubleIterationManager.class; 	// FIXME ExecutorMultipleIterationManager
		final LibraryIteration libraryIteration = DomainUtil.nonNullState(cgIterationCallExp.getLibraryIteration());
		final Method actualMethod = getJavaMethod(libraryIteration);
		final Class<?> actualReturnClass = actualMethod != null ? actualMethod.getReturnType() : null;
		final String astName = getSymbolName(null, cgIterationCallExp.getValueName());
		final String bodyName = getSymbolName(null, "BODY_" + astName);
		final String implementationName = getSymbolName(null, "IMPL_" + astName);
		final String managerName = getSymbolName(null, "MGR_" + astName);
		final String staticTypeName = getSymbolName(null, "TYPE_" + astName);
		String accumulatorName;
		//
		//	Pre-amble: hoisted assignments
		//
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		//
		//	Dispatch: Determine static type
		//
		js.append("final "); 
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(DomainType.class);
		js.append(" " + staticTypeName + " = ");
//		js.appendReferenceTo(evaluatorParameter);
		js.append(JavaConstants.EVALUATOR_NAME);
		js.append(".getStaticTypeOf(");
		js.appendValueName(source);
		js.append(");\n");
		//
		//	Dispatch: Determine dynamic operation
		//
		js.append("final "); 
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(LibraryIteration.class);
		js.append(" " + implementationName + " = ("); 
		js.appendClassReference(LibraryIteration.class);
		js.append( ")" + staticTypeName + ".lookupImplementation("); 
		js.appendReferenceTo(localContext.getStandardLibraryVariable(cgIterationCallExp));
		js.append(", ");
		js.appendQualifiedLiteralName(DomainUtil.nonNullState(referredOperation));
		js.append(");\n");
		//
		if (iterateResult != null) {
			CGValuedElement init = iterateResult.getInit();
			accumulatorName = getSymbolName(null, init.getValueName());
			if (!js.appendLocalStatements(init)) {
				return false;
			}
			js.appendDeclaration(iterateResult);
			js.append(" = ");
			js.appendValueName(init);
			js.append(";\n");
			//
/*			js.append("Object " + accumulatorName + " = " + implementationName + ".createAccumulatorValue(");
//			js.appendValueName(evaluatorParameter);
			js.append(JavaConstants.EVALUATOR_NAME);
			js.append(", ");
			js.appendValueName(resultType);
			js.append(", ");
			js.appendValueName(body.getTypeId());
			js.append(");\n"); */
		}
		else {
			accumulatorName = "ACC_" + astName;	
			js.append("final ");
			js.appendIsRequired(true);
			js.append(" Object " + accumulatorName + " = " + implementationName + ".createAccumulatorValue(");
//			js.appendValueName(evaluatorParameter);
			js.append(JavaConstants.EVALUATOR_NAME);
			js.append(", ");
			js.appendValueName(resultType);
			js.append(", ");
			js.appendValueName(body.getTypeId());
			js.append(");\n");
		}
		//
		js.append("/**\n"); 
		js.append(" * Implementation of the iterator body.\n");
		js.append(" */\n");
		js.append("final ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(operationClass);
		js.append(" " + bodyName + " = new ");
		js.appendClassReference(operationClass);
		js.append("()\n");
		js.append("{\n");
		js.pushIndentation(null);
			js.appendCommentWithOCL(null, body.getAst());
			js.append("@Override\n");
			js.append("public ");
			js.appendIsRequired(false);
			js.append(" Object evaluate(");
			js.append("final ");
			js.appendIsRequired(true);
			js.append(" ");
	//		js.appendDeclaration(evaluatorParameter);
			js.appendClassReference(DomainEvaluator.class);
			js.append(" ");
			js.append(JavaConstants.EVALUATOR_NAME);
			js.append(", ");
			js.append("final ");
			js.appendIsRequired(true);
			js.append(" ");
	//		js.appendDeclaration(localContext.getTypeIdParameter(cgIterateCallExp));
			js.appendClassReference(TypeId.class);
			js.append(" ");
			js.append(JavaConstants.TYPE_ID_NAME);
			if (iterateResult != null) {
				js.append(", ");
				js.appendDeclaration(iterateResult);
			}
			else {
				js.append(", final ");
				js.appendIsRequired(false);
				js.append(" Object ");
				js.appendValueName(source);
//				js.appendDeclaration(source);
			}
			for (@SuppressWarnings("null")@NonNull CGParameter iterator : iterators) {
				js.append(", final ");
				js.appendDeclaration(iterator);
			}
			js.append(") {\n");
			js.pushIndentation(null);
				String savedLocalPrefix = localPrefix;
				JavaLocalContext savedLocalContext = localContext;
				try {
					CGClass cgClass = CGUtils.getContainingClass(cgIterationCallExp);
					Element ast = cgClass != null ? cgClass.getAst() : null;
					EObject eObject = ast != null ? ast.getETarget() : null;
					if (eObject instanceof EClassifier) {
						localPrefix = genModelHelper.getImplementationClassName((EClassifier)eObject);
					}
					localContext = globalContext.getLocalContext(cgIterationCallExp);
					appendReturn(body);
				}
				finally {
					localContext = savedLocalContext;
					localPrefix = savedLocalPrefix;
				}
			js.popIndentation();
			js.append("}\n");
		js.popIndentation();
		js.append("};\n");
		//
		//	Dispatch: Create execution manager
		//
		js.append("final ");
		js.appendIsRequired(true);
		js.append("  ");
		js.appendClassReference(managerClass);
		js.append(" " + managerName + " = new ");
		js.appendClassReference(managerClass);
		js.append("(");
//		js.appendReferenceTo(evaluatorParameter);
		js.append(JavaConstants.EVALUATOR_NAME);
		js.append(", ");
		js.appendValueName(resultType);
		js.append(", " + bodyName + ", ");
		js.appendReferenceTo(CollectionValue.class, source);
//		js.appendValueName(source);
		js.append(", " + accumulatorName + ");\n");
		//
		//	Dispatch: Invoke iteration
		//
		js.appendDeclaration(cgIterationCallExp);
		js.append(" = ");
		js.appendClassCast(cgIterationCallExp, actualReturnClass);
		js.append(implementationName + ".evaluateIteration(" + managerName + ")");
		js.append(";\n");
		return true;
	}

	protected void appendReturn(@NonNull CGValuedElement body) {
		if (js.appendLocalStatements(body)) {
			if (body instanceof CGThrowExp) {				// FIXME generalize
				body.accept(this);
			}
			else {
				CGInvalid cgInvalidValue = body.getInvalidValue();
				if (cgInvalidValue != null) {
					js.append("throw ");
					js.appendValueName(cgInvalidValue);
				}
				else {
					js.append("return ");
					js.appendValueName(body);
				}
				js.append(";\n");
			}
		}
	}

	protected @NonNull Id2JavaInterfaceVisitor createId2JavaClassVisitor() {
		return new Id2JavaInterfaceVisitor();
	}

	protected @NonNull Id2JavaExpressionVisitor createId2JavaExpressionVisitor(@NonNull JavaStream javaStream) {
		return new Id2JavaExpressionVisitor(javaStream);
	}

	public void generateGlobals(@NonNull Iterable<? extends CGValuedElement> sortedElements) {
		for (CGValuedElement cgElement : sortedElements) {
			cgElement.accept(this);
		}
	}

	public @NonNull Set<String> getAllImports() {
		return globalContext.getImports();
	}

	public @NonNull CodeGenAnalyzer getAnalyzer() {
		return analyzer;
	}

	public @NonNull JavaCodeGenerator getCodeGenerator() {
		return context;
	}

	protected @NonNull CGValuedElement getExpression(@Nullable CGValuedElement cgExpression) {
		return analyzer.getExpression(cgExpression);
	}
	
	public @NonNull GenModelHelper getGenModelHelper() {
		return genModelHelper;
	}

	private Method getJavaMethod(@NonNull LibraryIteration libraryIteration) {
		try {
			@SuppressWarnings("null") @NonNull Class<? extends LibraryIteration> implementationClass = libraryIteration.getClass();
			Method method = implementationClass.getMethod("evaluateIteration", DomainIterationManager.class);
			return method;
		} catch (Exception e) {
			return null;
		}
	}

	private Method getJavaMethod(@NonNull LibraryOperation libraryOperation, int argumentSize) {
		try {
			@SuppressWarnings("null") @NonNull Class<? extends LibraryOperation> implementationClass = libraryOperation.getClass();
			Class<?>[] arguments;
			int i = 0;
			if (libraryOperation instanceof LibrarySimpleOperation) {
				arguments = new Class<?>[argumentSize+1];
			}
			else if (libraryOperation instanceof LibraryUntypedOperation) {
				arguments = new Class<?>[argumentSize+2];
				arguments[i++] = DomainEvaluator.class;
			}
			else {
			    arguments = new Class<?>[argumentSize+3];
				arguments[i++] = DomainEvaluator.class;
				arguments[i++] = TypeId.class; 
			}
			while (i < arguments.length) {
				arguments[i++] = Object.class; 
			}
			Method method = implementationClass.getMethod("evaluate", arguments);
			return method;
		} catch (Exception e) {
			return null;
		}
	}

	private Method getJavaMethod(@NonNull LibraryProperty libraryProperty) {
		try {
			@SuppressWarnings("null") @NonNull Class<? extends LibraryProperty> implementationClass = libraryProperty.getClass();
			Class<?>[] arguments = new Class<?>[3];
			arguments[0] = DomainEvaluator.class;
			arguments[1] = TypeId.class; 
			arguments[2] = Object.class; 
			Method method = implementationClass.getMethod("evaluate", arguments);
			return method;
		} catch (Exception e) {
			return null;
		}
	}

	protected @Nullable Class<?> getLeastDerivedClass(Class<?> requiredClass, @NonNull String getAccessor) {
		Class<?> superClass = requiredClass.getSuperclass();
		if (superClass != null) {
			try {
				Class<?> lessDerivedSuperClass = getLeastDerivedClass(superClass, getAccessor);
				if (lessDerivedSuperClass != null) {
					return lessDerivedSuperClass;
				}
				Method method = superClass.getMethod(getAccessor);
				if (method != null) {
					return superClass;
				}
			} catch (Exception e) {
			}
		}
		for (Class<?> superInterface : requiredClass.getInterfaces()) {
			Class<?> lessDerivedSuperInterface = getLeastDerivedClass(superInterface, getAccessor);
			if (lessDerivedSuperInterface != null) {
				return lessDerivedSuperInterface;
			}
			try {
				Method method = superInterface.getMethod(getAccessor);
				if (method != null) {
					return superInterface;
				}
			} catch (Exception e) {
			}
		}
		return null;
	}

	protected @NonNull MetaModelManager getMetaModelManager() {
		return context.getMetaModelManager();
	}

	protected @NonNull String getSymbolName(@Nullable Object anObject, @Nullable String... nameHints) {
		return localContext.getNameManagerContext().getSymbolName(anObject, nameHints);
	}

	protected String getValueName(@NonNull CGValuedElement cgElement) {
		String valueName = localContext != null ? localContext.getValueName(cgElement) : globalContext.getValueName(cgElement);
		return valueName;
	}

	protected boolean isBoxedElement(@NonNull CGValuedElement cgValue) {
		TypeId typeId = cgValue.getASTypeId();
		if (typeId instanceof EnumerationLiteralId) {
			return true;
		}
		if (typeId instanceof EnumerationId) {
			return true;
		}
		if (typeId instanceof ClassId) {
			return true;
		}
		return false;
	}

	protected boolean isBoxedType2(@NonNull CGValuedElement cgValue) {
		TypeId typeId = cgValue.getASTypeId();
		if (typeId instanceof MetaclassId) {
			return true;
		}
		if (typeId instanceof NestedTypeId) {
			return true;
		}
		return false;
	}

	protected boolean isBoxedType(@NonNull CGValuedElement cgValue) {
		Element ast = cgValue.getAst();
		if (!(ast instanceof TypedElement)) {
			return false;
		}
		Type type = ((TypedElement)ast).getType();
		if (type == null) {
			return false;
		}
		if (type instanceof DomainEnumeration) {
			return false;
		}
		MetaModelManager metaModelManager = getMetaModelManager();
		Type oclTypeType = metaModelManager.getOclTypeType();
		return metaModelManager.conformsTo(type, oclTypeType, null);
	}

	protected boolean isEnumerationLiteral(@NonNull CGValuedElement cgValue) {
		Element ast = cgValue.getAst();
		if (!(ast instanceof TypedElement)) {
			return false;
		}
		Type type = ((TypedElement)ast).getType();
		return type instanceof DomainEnumeration;
	}
	
	@Override
	public @NonNull String toString() {
		String string = js.toString();
		return string;
	}
	
	@Override
	public @NonNull Boolean visiting(@NonNull CGElement visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public @NonNull Boolean visitCGAssertNonNullExp(@NonNull CGAssertNonNullExp cgAssertNonNullExp) {
		CGValuedElement cgSource = getExpression(cgAssertNonNullExp.getSource());
		//
		if (cgSource.isNull()) {
			js.append("throw new ");
			js.appendClassReference(InvalidValueException.class);
			js.append("();\n");
		}
		else {
			if (!js.appendLocalStatements(cgSource)) {
				return false;
			}
			if (!cgSource.isNonNull()) {
				js.append("assert ");
				js.appendValueName(cgSource);
				js.append(" != null;\n");
			}
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGBoolean(@NonNull CGBoolean cgBoolean) {
		boolean booleanValue = cgBoolean.isBooleanValue();
		if (booleanValue) {
			js.appendTrue();
		}
		else {
			js.appendFalse();
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGBoxExp(@NonNull CGBoxExp cgBoxExp) {
		CGValuedElement unboxedValue = getExpression(cgBoxExp.getSource());
		TypeDescriptor unboxedTypeDescriptor = context.getTypeDescriptor(unboxedValue);
		JavaLocalContext localContext2 = localContext;
		assert localContext2 != null;
//
		if (!js.appendLocalStatements(unboxedValue)) {
			return false;
		}
		return unboxedTypeDescriptor.appendBox(js, localContext2, cgBoxExp, unboxedValue);
	}

	@Override
	public @NonNull Boolean visitCGBuiltInIterationCallExp(@NonNull CGBuiltInIterationCallExp cgIterationCallExp) {
		CGValuedElement cgSource = getExpression(cgIterationCallExp.getSource());
		CGValuedElement cgBody = getExpression(cgIterationCallExp.getBody());
		CGIterator cgAccumulator = cgIterationCallExp.getAccumulator();
		CGIterator cgIterator = cgIterationCallExp.getIterators().get(0);
		String iteratorName = getSymbolName(null, "ITERATOR_" + cgIterator.getValueName());
		Iteration2Java iterationHelper = context.getIterationHelper(DomainUtil.nonNullState(cgIterationCallExp.getReferredIteration()));
		assert iterationHelper != null;
		boolean flowContinues = false;
		//
		if (!js.appendLocalStatements(cgSource)) {
			return false;
		}
		//
		if (cgAccumulator != null) {
			CGValuedElement cgInit = cgAccumulator.getInit();
			if (cgInit != null) {
				if (!js.appendLocalStatements(cgInit)) {
					return false;
				}
			}
			js.appendDeclaration(cgAccumulator);
			js.append(" = ");
			iterationHelper.appendAccumulatorInit(js, cgIterationCallExp);
			js.append(";\n");
		}
		//
		js.appendIsRequired(cgIterator.isRequired());
		js.append(" ");
		js.appendClassReference(Iterator.class); //, getJavaClass(cgIterator));
		js.append(" " + iteratorName + " = ");
		js.appendAtomicReferenceTo(cgSource);
		js.append(".iterator();\n");
		//
		js.appendDeclaration(cgIterationCallExp);
		js.append(";\n");
		//
		js.append("while (true) {\n");
		js.pushIndentation(null);
			js.append("if (!" + iteratorName + ".hasNext()) {\n");
			js.pushIndentation(null);
				if (iterationHelper.appendFinalValue(js, cgIterationCallExp)) {
					js.append("break;\n");
					flowContinues = true;
				}
			js.popIndentation();
			js.append("}\n");
			js.appendDeclaration(cgIterator);
			js.append(" = ");
			js.appendClassCast(cgIterator);
			js.append(iteratorName + ".next();\n");
			js.appendCommentWithOCL(null, cgBody.getAst());
			if (js.appendLocalStatements(cgBody)) {
				js.append("//\n");
				if (iterationHelper.appendUpdate(js, cgIterationCallExp)) {
					flowContinues = true;
				}
			}
		js.popIndentation();
		js.append("}\n");
		return flowContinues;
	}

	@Override
	public @NonNull Boolean visitCGCastExp(@NonNull CGCastExp cgCastExp) {
		CGValuedElement cgSource = getExpression(cgCastExp.getSource());
		CGExecutorType cgType = cgCastExp.getExecutorType();
		if (cgType != null) {
			TypeDescriptor typeDescriptor = context.getTypeDescriptor(cgCastExp);
			js.appendDeclaration(cgCastExp);
			js.append(" = ");
			typeDescriptor.appendCastTerm(js, cgSource);
			js.append(";\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGCatchExp(@NonNull CGCatchExp cgCatchExp) {
		String eName = globalContext.getEName();
		CGValuedElement cgSource = getExpression(cgCatchExp.getSource());
		if (cgSource.isNonInvalid()) {
			if (!js.appendLocalStatements(cgSource)) {
				return false;
			}
			js.appendDeclaration(cgCatchExp);
			js.append(" = ");
			js.appendValueName(cgSource);
			js.append(";\n");
		}
		else {
			js.appendDeclaration(cgCatchExp);
			js.append(";\n");
			js.append("try {\n");
			js.pushIndentation(null);
				if (!js.appendLocalStatements(cgSource)) {
					return false;
				}
				js.appendValueName(cgCatchExp);
				js.append(" = ");
				js.appendValueName(cgSource);
				js.append(";\n");
				js.popIndentation();
			js.append("}\n");
			js.append("catch (");
			js.appendClassReference(Exception.class);
			js.append(" " + eName + ") {\n");
			js.pushIndentation(null);
				js.appendValueName(cgCatchExp);
				js.append(" = ");
				js.appendClassReference(ValuesUtil.class);
				js.append(".createInvalidValue(" + eName + ");\n");
				js.popIndentation();
			js.append("}\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGCollectionExp(@NonNull CGCollectionExp cgCollectionExp) {
		int ranges = 0;
		for (CGCollectionPart cgPart : cgCollectionExp.getParts()) {
			if (cgPart.isRange()) {
				ranges++;
			}
			if (!js.appendLocalStatements(cgPart)) {
				return false;
			}
		}
		js.appendDeclaration(cgCollectionExp);
		js.append(" = ");
		js.appendClassReference(ValuesUtil.class);
		String kind = ((CollectionLiteralExp)cgCollectionExp.getAst()).getKind().getName();
		if (ranges > 0) {
			js.append(".create" + kind + "Range(");
//			CGTypeVariable typeVariable = localContext.getTypeVariable(cgCollectionExp.getTypeId());
			js.appendIdReference(cgCollectionExp.getTypeId().getElementId());
			for (CGCollectionPart cgPart : cgCollectionExp.getParts()) {
				js.append(", ");
				js.appendValueName(cgPart);
			}
		}
		else {
			js.append(".create" + kind + "OfEach(");
	//		CGTypeVariable typeVariable = localContext.getTypeVariable(cgCollectionExp.getTypeId());
			js.appendIdReference(cgCollectionExp.getTypeId().getElementId());
			for (CGCollectionPart cgPart : cgCollectionExp.getParts()) {
				js.append(", ");
				if (cgPart.isNull() && (cgCollectionExp.getParts().size() == 1)) {
					js.append("(Object)");
				}
				js.appendValueName(cgPart);
			}
		}
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGCollectionPart(@NonNull CGCollectionPart cgCollectionPart) {
		CGValuedElement first = getExpression(cgCollectionPart.getFirst());
		CGValuedElement last = cgCollectionPart.getLast();
		if (last != null) {
			if (!js.appendLocalStatements(first)) {
				return false;
			}
			if (!js.appendLocalStatements(last)) {
				return false;
			}
			js.appendDeclaration(cgCollectionPart);
			js.append(" = ");
			js.appendClassReference(ValuesUtil.class);
			js.append(".createRange(");
			js.appendValueName(first);
			js.append(", ");
			js.appendValueName(last);
			js.append(");\n");
		}
		else {
			if (first.isInlined()) {
				js.appendValueName(first);
			}
			else {
				if (!js.appendLocalStatements(first)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGConstantExp(@NonNull CGConstantExp cgConstantExp) {
		CGValuedElement referredConstant = cgConstantExp.getReferredConstant();
		if ((referredConstant != null) && referredConstant.isInlined()) {
			referredConstant.accept(this);
		}
		else {
			// Non-inline constants should be generated somewhere else and referenced by name in the caller
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGConstraint(@NonNull CGConstraint cgConstraint) {
		localContext = globalContext.getLocalContext(cgConstraint);
		try {
			Boolean flowContinues = super.visitCGConstraint(cgConstraint);
			assert flowContinues != null;
			return flowContinues;
		}
		finally {
			localContext = null;
		}
	}

	@Override
	public @NonNull Boolean visitCGConstructorExp(@NonNull CGConstructorExp cgConstructorExp) {
/*
		CodeGenAnalysis analysis = context.getAnalysis(element);
		if (analysis.isConstant()) {
			return context.getSnippet(analysis.getConstantValue());
		}
		final Type type = DomainUtil.nonNullModel(element.getTypeId());
		final Class<?> resultClass = Object.class; //context.getBoxedClass(element.getTypeId());
		int flags = CodeGenSnippet.NON_NULL | CodeGenSnippet.UNBOXED;
		if (/*isValidating* / analysis.isCatching()) {
			flags |= CodeGenSnippet.CAUGHT | CodeGenSnippet.MUTABLE;
		}
		else { //if (/*isValidating* / analysis.isThrowing()) {
			flags |= CodeGenSnippet.THROWN;
		}
//		else {
//			flags |= CodeGenSnippet.FINAL;
//		}
		CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, flags);
		snippet = snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
//				text.append("(");
//				text.appendClassReference(EObject.class);
//				text.append(")");
//				text.appendClassReference(ObjectValue.class);
//				text.append(")");
*/
		CGExecutorType cgExecutorType = cgConstructorExp.getExecutorType();
		//
		js.appendDeclaration(cgConstructorExp);
		js.append(" = ");
		js.appendClassCast(cgConstructorExp);
		js.appendValueName(cgExecutorType);
		js.append(".createInstance();\n");
		for (CGConstructorPart part : cgConstructorExp.getParts()) {
			part.accept(this);
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGConstructorPart(@NonNull CGConstructorPart cgConstructorPart) {
/*		final OCLExpression initExpression = DomainUtil.nonNullModel(element.getInitExpression());
		final Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		ConstructorExp eContainer = (ConstructorExp)element.eContainer();
		final CodeGenSnippet instanceSnippet = context.getSnippet(eContainer);
		Class<?> resultClass = Object.class; //context.getBoxedClass(element.getTypeId());
		CodeGenSnippet snippet = new JavaSnippet("", context, TypeId.OCL_INVALID, resultClass, element,
			CodeGenSnippet.THROWN | CodeGenSnippet.UNASSIGNED | CodeGenSnippet.UNBOXED);
		return snippet.appendText("", new AbstractTextAppender()
		{
			private CodeGenSnippet initSnippet;
			
			@Override
			public boolean appendAtHead(@NonNull CodeGenSnippet snippet) {
				initSnippet = snippet.appendUnboxedGuardedChild(initExpression, null, DomainMessage.INVALID);
				return true;
			}

			@Override
			public void appendToBody(@NonNull CodeGenText text) { */
//		appendReferenceTo(context.getSnippet(referredProperty));
		CGExecutorConstructorPart cgExecutorConstructorPart = cgConstructorPart.getExecutorPart();
		CGValuedElement init = getExpression(cgConstructorPart.getInit());
		//
		if (!js.appendLocalStatements(init)) {
			return false;
		}
		//
		js.appendValueName(cgExecutorConstructorPart);
		js.append(".initValue(");
		js.appendValueName(cgConstructorPart.getConstructorExp());
		js.append(", ");
		js.appendValueName(init);
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGEcoreDataTypeConstructorExp(@NonNull CGEcoreDataTypeConstructorExp cgConstructorExp) {
		//
		//	Availability of a GenPackage is mandatory since we must have an EFactory.createFromString method to do the construction.
		//
		EDataType eDataType = cgConstructorExp.getEDataType();
		final Class<?> javaClass = eDataType.getInstanceClass();
		if (javaClass == null) {
			throw new IllegalStateException("No Java class for " + cgConstructorExp + " in CG2JavaVisitor.visitCGEcoreDataTypeConstructorExp()");
		}
		final EPackage ePackage = eDataType.getEPackage();
		String nsURI = ePackage.getNsURI();
		if (nsURI == null) {
			throw new IllegalStateException("No EPackage NsURI for " + cgConstructorExp + " in CG2JavaVisitor.visitCGEcoreDataTypeConstructorExp()");
		}
		GenPackage genPackage = getMetaModelManager().getGenPackage(nsURI);
		if (genPackage == null) {
			throw new IllegalStateException("No GenPackage for " + cgConstructorExp + " in CG2JavaVisitor.visitCGEcoreDataTypeConstructorExp()");
		}
		final String eFactoryName = genPackage.getQualifiedFactoryInterfaceName();
		final String ePackageName = genPackage.getQualifiedPackageInterfaceName();
		final String dataTypeName = CodeGenUtil.upperName(eDataType.getName());
		ClassLoader classLoader = eDataType.getClass().getClassLoader();
		Class<?> factoryClass;
		Class<?> packageClass;
		try {
			factoryClass = classLoader.loadClass(eFactoryName);
			packageClass = eDataType.getClass().getClassLoader().loadClass(ePackageName);
		}
		catch (ClassNotFoundException e) {
			throw new IllegalStateException("Load class failure for " + cgConstructorExp + " in CG2JavaVisitor.visitCGEcoreDataTypeConstructorExp()", e);
		}
		//
		js.appendDeclaration(cgConstructorExp);
		js.append(" = ");
		js.append("(");
		js.appendClassReference(javaClass);
		js.append(")");
		js.appendClassReference(factoryClass);
		js.append(".eINSTANCE.createFromString(");
		js.appendClassReference(packageClass);
		js.append(".Literals." + dataTypeName + ", \"");
		String partString = cgConstructorExp.getString();
//		EFactory eFactoryInstance = ePackage.getEFactoryInstance();
//		String partString = eFactoryInstance.convertToString(eDataType, object);
		if (partString != null) {
			@SuppressWarnings("null") @NonNull String javaString = Strings.convertToJavaString(partString);
			js.append(javaString);
		}
		js.append("\");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGEcoreOperationCallExp(@NonNull CGEcoreOperationCallExp cgOperationCallExp) {
		Operation pOperation = cgOperationCallExp.getReferredOperation();
		CGTypeId cgTypeId = analyzer.getTypeId(pOperation.getOwningType().getTypeId());
//		TypeDescriptor requiredTypeDescriptor = context.getUnboxedDescriptor(cgTypeId.getElementId());
		TypeDescriptor requiredTypeDescriptor = context.getUnboxedDescriptor(DomainUtil.nonNullState(cgTypeId.getElementId()));
		CGValuedElement source = getExpression(cgOperationCallExp.getSource());
		List<CGValuedElement> cgArguments = cgOperationCallExp.getArguments();
		List<Parameter> pParameters = pOperation.getOwnedParameter();
		//
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgArguments) {
			CGValuedElement argument = getExpression(cgArgument);
			if (!js.appendLocalStatements(argument)) {
				return false;
			}
		}
		//
		String operationAccessor = genModelHelper.getOperationAccessor(pOperation);
//		Class<?> actualBoxedReturnClass = getBoxedReturnClass(libraryOperation, arguments.size());
//		Class<?> unboxedSourceClass;
//		try {		// FIXME this peeking is only needed for the Pivot Domain/non-Domain levels
//			unboxedSourceClass = genModelHelper.getEcoreInterfaceClass(eOperation.getEContainingClass());
//		}
//		catch (GenModelException e) {
//			unboxedSourceClass = getJavaClass(source);
//		}
		js.appendDeclaration(cgOperationCallExp);
		js.append(" = ");
		js.appendAtomicReferenceTo(requiredTypeDescriptor, source);
		js.append(".");
			js.append(operationAccessor);
		js.append("(");
		int iMax = Math.min(pParameters.size(), cgArguments.size());
		for (int i = 0; i < iMax; i++) {
			if (i > 0) {
				js.append(", ");
			}
			CGValuedElement cgArgument = cgArguments.get(i);
			CGValuedElement argument = getExpression(cgArgument);
			Parameter pParameter = DomainUtil.nonNullState(pParameters.get(i));
			GenParameter genParameter = context.getGenModelHelper().getGenParameter(pParameter);
			if (genParameter != null) {
				String rawBoundType = DomainUtil.nonNullState(genParameter.getRawBoundType());
				js.appendEcoreValue(rawBoundType, argument);
			}
			else {	// ? never happens
				CGTypeId cgParameterTypeId = analyzer.getTypeId(pParameter.getTypeId());
				TypeDescriptor parameterTypeDescriptor = context.getUnboxedDescriptor(DomainUtil.nonNullState(cgParameterTypeId.getElementId()));
				js.appendReferenceTo(parameterTypeDescriptor, argument);
				
			}
		}
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGEcorePropertyCallExp(@NonNull CGEcorePropertyCallExp cgPropertyCallExp) {
		Property asProperty = cgPropertyCallExp.getReferredProperty();
		CGTypeId cgTypeId = analyzer.getTypeId(asProperty.getOwningType().getTypeId());
		ElementId elementId = DomainUtil.nonNullState(cgTypeId.getElementId());
		TypeDescriptor requiredTypeDescriptor = context.getUnboxedDescriptor(elementId);
		EStructuralFeature eStructuralFeature = DomainUtil.nonNullState(cgPropertyCallExp.getEStructuralFeature());
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		String getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
		Class<?> requiredJavaClass = requiredTypeDescriptor.hasJavaClass();
		Method leastDerivedMethod = requiredJavaClass != null ? context.getLeastDerivedMethod(requiredJavaClass, getAccessor) : null;
		Class<?> unboxedSourceClass;
		if (leastDerivedMethod != null){
			unboxedSourceClass = leastDerivedMethod.getDeclaringClass();
		}
		else {
			unboxedSourceClass = requiredJavaClass;
		}
		//
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		//
		js.appendDeclaration(cgPropertyCallExp);
		js.append(" = ");
		if ((unboxedSourceClass != null) && (unboxedSourceClass != Object.class)) {
			js.appendAtomicReferenceTo(unboxedSourceClass, source);
		}
		else {
			js.appendAtomicReferenceTo(source);
		}
		js.append(".");
		js.append(getAccessor);
		js.append("();\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGElementId(@NonNull CGElementId cgElementId) {
		ElementId elementId = cgElementId.getElementId();
		if ((elementId != null) && !CGUtils.isInlinedId(elementId)) {
			js.append("public static final ");
			js.appendIsRequired(true);
			js.append(" ");
			js.appendIsCaught(true, false);
			js.append(" ");
			js.appendClassReference(elementId.accept(id2JavaInterfaceVisitor));
			js.append(" ");
			js.append(globalContext.getValueName(cgElementId));
			js.append(" = ");
			js.appendIdReference2(elementId);
			js.append(";\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGExecutorCompositionProperty(@NonNull CGExecutorCompositionProperty cgExecutorProperty) {
		js.appendDeclaration(cgExecutorProperty);
		js.append(" = new ");
		js.appendClassReference(cgExecutorProperty);
		js.append("(");
		Property asProperty = (Property) cgExecutorProperty.getAst();
		Property asOppositeProperty = asProperty.getOpposite();
		js.appendString(DomainUtil.nonNullState(asOppositeProperty.getName()));
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGExecutorConstructorPart(@NonNull CGExecutorConstructorPart cgExecutorConstructorPart) {
		js.appendDeclaration(cgExecutorConstructorPart);
		js.append(" = ");
		js.appendValueName(localContext.getIdResolverVariable(cgExecutorConstructorPart));
		js.append(".getProperty(");
		js.appendIdReference(cgExecutorConstructorPart.getUnderlyingPropertyId().getElementId());
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGExecutorNavigationProperty(@NonNull CGExecutorNavigationProperty cgExecutorProperty) {
		js.appendDeclaration(cgExecutorProperty);
		js.append(" = new ");
		js.appendClassReference(cgExecutorProperty);
		js.append("(");
		js.appendIdReference(cgExecutorProperty.getUnderlyingPropertyId().getElementId());
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGExecutorOppositeProperty(@NonNull CGExecutorOppositeProperty cgExecutorProperty) {
		Property asProperty = (Property) cgExecutorProperty.getAst();
		Property asOppositeProperty = asProperty.getOpposite();
		js.appendDeclaration(cgExecutorProperty);
		js.append(" = new ");
		js.appendClassReference(cgExecutorProperty);
		js.append("(");
		js.appendIdReference(asOppositeProperty.getPropertyId());
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGExecutorOperation(@NonNull CGExecutorOperation cgExecutorOperation) {
		js.appendDeclaration(cgExecutorOperation);
		js.append(" = ");
		js.appendValueName(localContext.getIdResolverVariable(cgExecutorOperation));
		js.append(".getOperation(");
		js.appendIdReference(cgExecutorOperation.getUnderlyingOperationId().getElementId());
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGExecutorOperationCallExp(@NonNull CGExecutorOperationCallExp cgOperationCallExp) {
		Operation pOperation = cgOperationCallExp.getReferredOperation();
		CGValuedElement source = getExpression(cgOperationCallExp.getSource());
		List<CGValuedElement> cgArguments = cgOperationCallExp.getArguments();
		List<Parameter> pParameters = pOperation.getOwnedParameter();
		//
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgArguments) {
			CGValuedElement argument = getExpression(cgArgument);
			if (!js.appendLocalStatements(argument)) {
				return false;
			}
		}
		//
		js.appendDeclaration(cgOperationCallExp);
		js.append(" = ");
		js.appendClassCast(cgOperationCallExp);
		js.appendReferenceTo(cgOperationCallExp.getExecutorOperation());
		js.append(".evaluate(");
//		js.append(getValueName(localContext.getEvaluatorParameter(cgOperationCallExp)));
		js.append(JavaConstants.EVALUATOR_NAME);
		js.append(", ");
		js.appendIdReference(cgOperationCallExp.getASTypeId());
		js.append(", ");
		js.appendValueName(source);
		int iMax = Math.min(pParameters.size(), cgArguments.size());
		for (int i = 0; i < iMax; i++) {
			js.append(", ");
			CGValuedElement cgArgument = cgArguments.get(i);
			Parameter pParameter = pParameters.get(i);
			CGTypeId cgTypeId = analyzer.getTypeId(pParameter.getTypeId());
			TypeDescriptor parameterTypeDescriptor = context.getUnboxedDescriptor(DomainUtil.nonNullState(cgTypeId.getElementId()));
			CGValuedElement argument = getExpression(cgArgument);
			js.appendReferenceTo(parameterTypeDescriptor, argument);
		}
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGExecutorOppositePropertyCallExp(@NonNull CGExecutorOppositePropertyCallExp cgPropertyCallExp) {
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		//
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		//
		js.appendDeclaration(cgPropertyCallExp);
		js.append(" = ");
		js.appendClassCast(cgPropertyCallExp);
		js.appendReferenceTo(cgPropertyCallExp.getExecutorProperty());
		js.append(".evaluate(");
//		js.append(getValueName(localContext.getEvaluatorParameter(cgPropertyCallExp)));
		js.append(JavaConstants.EVALUATOR_NAME);
		js.append(", ");
		js.appendIdReference(cgPropertyCallExp.getASTypeId());
		js.append(", ");
		js.appendValueName(source);
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGExecutorPropertyCallExp(@NonNull CGExecutorPropertyCallExp cgPropertyCallExp) {
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		//
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		//
		js.appendDeclaration(cgPropertyCallExp);
		js.append(" = ");
		js.appendClassCast(cgPropertyCallExp);
		js.appendReferenceTo(cgPropertyCallExp.getExecutorProperty());
		js.append(".evaluate(");
//		js.append(getValueName(localContext.getEvaluatorParameter(cgPropertyCallExp)));
		js.append(JavaConstants.EVALUATOR_NAME);
		js.append(", ");
		js.appendIdReference(cgPropertyCallExp.getASTypeId());
		js.append(", ");
		js.appendValueName(source);
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGExecutorType(@NonNull CGExecutorType cgExecutorType) {
		js.appendDeclaration(cgExecutorType);
		js.append(" = ");
		js.appendValueName(localContext.getIdResolverVariable(cgExecutorType));
		js.append(".getType(");
		js.appendIdReference(cgExecutorType.getUnderlyingTypeId().getElementId());
		js.append(", null);\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGGuardExp(@NonNull CGGuardExp cgGuardExp) {
		CGValuedElement cgSource = getExpression(cgGuardExp.getSource());
		//
		if (cgSource.isNull()) {
			js.append("throw new ");
			js.appendClassReference(InvalidValueException.class);
			js.append("();\n");
		}
		else {
			if (!js.appendLocalStatements(cgSource)) {
				return false;
			}
			if (!cgSource.isNonNull()) {
				js.append("if (");
				js.appendValueName(cgSource);
				js.append(" == null) {\n");
				js.pushIndentation(null);
					js.append("throw new ");
					js.appendClassReference(InvalidValueException.class);
					js.append("(");
					js.appendString("Null " + cgGuardExp.getMessage());
					js.append(");\n");
					js.popIndentation();
				js.append("}\n");
			}
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGIfExp(@NonNull CGIfExp cgIfExp) {
		CGValuedElement condition = getExpression(cgIfExp.getCondition());
		CGValuedElement thenExpression = getExpression(cgIfExp.getThenExpression());
		CGValuedElement elseExpression = getExpression(cgIfExp.getElseExpression());
//		CGVariable resultVariable = localContext.getLocalVariable(cgIfExp);
		boolean flowContinues = false;
		//
		if (!js.appendLocalStatements(condition)) {
			return flowContinues;
		}
		js.appendDeclaration(cgIfExp);
		js.append(";\n");
		//
		js.append("if (");
		js.appendBooleanValueName(condition, true);
		js.append(") {\n");
		try {
			js.pushIndentation(null);
			if (js.appendAssignment(cgIfExp, thenExpression)) {
				flowContinues = true;
			}
		} finally {
			js.popIndentation();
		}
		js.append("}\n");
		js.append("else {\n");
		try {
			js.pushIndentation(null);
			if (js.appendAssignment(cgIfExp, elseExpression)) {
				flowContinues = true;
			}
		} finally {
			js.popIndentation();
		}
		js.append("}\n");
		return flowContinues;
	}

	@Override
	public @NonNull Boolean visitCGInteger(@NonNull CGInteger object) {
		js.appendDeclaration(object);
		js.append(" = ");
		js.appendClassReference(ValuesUtil.class);
		js.append(".integerValueOf(");
		Number integerValue = object.getNumericValue();
		String valueString = integerValue.toString();
		assert valueString != null;
		if (integerValue instanceof IntIntegerValueImpl) {
			js.append(valueString);
		}
		else if (integerValue instanceof LongIntegerValueImpl) {
			js.append(valueString + "L");
		}
		else {
			js.append("\"" + valueString + "\"");
		}
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGInvalid(@NonNull CGInvalid object) {
		String message = object.getMessageTemplate();
		if (message != null) {
			js.append("new ");
			js.appendClassReference(InvalidValueException.class);
			js.append("(");
			js.appendString(message);
			for (Object binding : object.getBindings()) {
				js.append(", ");
				js.appendString(DomainUtil.nonNullState(String.valueOf(binding)));
			}
			js.append(")");
		}
		else {
			js.appendClassReference(ValuesUtil.class);
			js.append(".INVALID_VALUE");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGIsEqualExp(@NonNull CGIsEqualExp cgIsEqualExp) {		// FIXME BUG 421738 move irregulaties to e.g. BooleanPrimitiveDescriptor
		if (cgIsEqualExp.isTrue()) {
			js.appendDeclaration(cgIsEqualExp);
			js.append(" = ");
			js.appendTrue();
			js.append(";\n");
		}
		else if (cgIsEqualExp.isFalse()) {
			js.appendDeclaration(cgIsEqualExp);
			js.append(" = ");
			js.appendFalse();
			js.append(";\n");
		}
		else {
			CGValuedElement cgSource = getExpression(cgIsEqualExp.getSource());
			CGValuedElement cgArgument = getExpression(cgIsEqualExp.getArgument());
			if (!js.appendLocalStatements(cgSource)) {
				return false;
			}
			if (!js.appendLocalStatements(cgArgument)) {
				return false;
			}
			//
			boolean notEquals = cgIsEqualExp.isNotEquals();
			js.appendDeclaration(cgIsEqualExp);
			js.append(" = ");
			if (cgSource.isNull()) {
				if (cgArgument.isNull()) {
					js.appendBooleanString(true ^ notEquals);
				}
				else if (cgArgument.isNonNull()) {
					js.appendBooleanString(false ^ notEquals);
				}
				else {
					js.appendValueName(cgArgument);
					js.append(notEquals ? " != " : " == ");
					js.append("null");
				}
			}
			else if (cgArgument.isNull()) {
				if (cgSource.isNonNull()) {
					js.appendBooleanString(false ^ notEquals);
				}
				else {
					js.appendValueName(cgSource);
					js.append(notEquals ? " != " : " == ");
					js.append("null");
				}
			}
			else if (cgSource.isTrue()) {
				if (cgArgument.isTrue()) {
					js.appendBooleanString(true ^ notEquals);
				}
				else if (cgArgument.isFalse()) {
					js.appendBooleanString(false ^ notEquals);
				}
				else {
					js.appendBooleanValueName(cgArgument, true ^ notEquals);
				}
			}
			else if (cgSource.isFalse()) {
				if (cgArgument.isFalse()) {
					js.appendBooleanString(true ^ notEquals);
				}
				else if (cgArgument.isTrue()) {
					js.appendBooleanString(false ^ notEquals);
				}
				else {
					js.appendBooleanValueName(cgArgument, false ^ notEquals);
				}
			}
			else if (cgArgument.isTrue()) {
				js.appendBooleanValueName(cgSource, true ^ notEquals);
			}
			else if (cgArgument.isFalse()) {
				js.appendBooleanValueName(cgSource, false ^ notEquals);
			}
			else {
				TypeDescriptor sourceTypeDescriptor = context.getTypeDescriptor(cgSource);
				sourceTypeDescriptor.appendEqualsValue(js, cgSource, cgArgument, notEquals);
			}
			js.append(";\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGIsInvalidExp(@NonNull CGIsInvalidExp cgIsInvalidExp) {
		if (cgIsInvalidExp.isTrue()) {
			js.appendTrue();
		}
		else if (cgIsInvalidExp.isFalse()) {
			js.appendFalse();
		}
		else {
			CGValuedElement cgSource = getExpression(cgIsInvalidExp.getSource());
			if (!js.appendLocalStatements(cgSource)) {
				return false;
			}
			//
			js.appendDeclaration(cgIsInvalidExp);
			js.append(" = ");
			js.appendValueName(cgSource);
			js.append(" instanceof ");
			js.appendClassReference(InvalidValueException.class);
			js.append(";\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGIsUndefinedExp(@NonNull CGIsUndefinedExp cgIsUndefinedExp) {
		if (cgIsUndefinedExp.isTrue()) {
			js.appendTrue();
		}
		else if (cgIsUndefinedExp.isFalse()) {
			js.appendFalse();
		}
		else {
			CGValuedElement cgSource = getExpression(cgIsUndefinedExp.getSource());
			boolean sourceIsNonInvalid = cgSource.isNonInvalid();
			boolean sourceIsNonNull = cgSource.isNonNull();
			if (!js.appendLocalStatements(cgSource)) {
				return false;
			}
			//
			js.appendDeclaration(cgIsUndefinedExp);
			js.append(" = ");
			if (!sourceIsNonNull && !sourceIsNonInvalid) {
				js.append("(");
				js.appendValueName(cgSource);
				js.append(" == null) || (");
				js.appendValueName(cgSource);
				js.append(" instanceof ");
				js.appendClassReference(InvalidValueException.class);
				js.append(")");
			}
			else if (!sourceIsNonNull && sourceIsNonInvalid) {
				js.appendValueName(cgSource);
				js.append(" == null");
			}
			else if (sourceIsNonNull && !sourceIsNonInvalid) {
				js.appendValueName(cgSource);
				js.append(" instanceof ");
				js.appendClassReference(InvalidValueException.class);
			}
			js.append(";\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGLetExp(@NonNull CGLetExp cgLetExp) {
		cgLetExp.getInit().accept(this);
		CGValuedElement cgIn = cgLetExp.getIn();
		if (cgIn != null) {
			if (!js.appendLocalStatements(cgIn)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGLibraryIterateCallExp(@NonNull CGLibraryIterateCallExp cgIterateCallExp) {
		return appendLoopCall(cgIterateCallExp, cgIterateCallExp.getResult());
	}

	@Override
	public @NonNull Boolean visitCGLibraryIterationCallExp(@NonNull CGLibraryIterationCallExp cgIterationCallExp) {
		return appendLoopCall(cgIterationCallExp, null);
	}

	@Override
	public @NonNull Boolean visitCGLibraryOperationCallExp(@NonNull CGLibraryOperationCallExp cgOperationCallExp) {
		final CGValuedElement source = getExpression(cgOperationCallExp.getSource());
		final List<CGValuedElement> arguments = cgOperationCallExp.getArguments();
		final LibraryOperation libraryOperation = DomainUtil.nonNullState(cgOperationCallExp.getLibraryOperation());
		Method actualMethod = getJavaMethod(libraryOperation, arguments.size());
		Class<?> actualReturnClass = actualMethod != null ? actualMethod.getReturnType() : null;
		boolean actualIsNonNull = (actualMethod != null) && (context.getIsNonNull(actualMethod) == Boolean.TRUE);
		boolean expectedIsNonNull = cgOperationCallExp.isNonNull();
		final CGTypeId resultType = cgOperationCallExp.getTypeId();
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : arguments) {
			if (!js.appendLocalStatements(cgArgument)) {
				return false;
			}
		}
		js.appendDeclaration(cgOperationCallExp);
		js.append(" = ");
		if (expectedIsNonNull && !actualIsNonNull) {
			js.appendClassReference(DomainUtil.class);
			js.append(".nonNullState(");
		}
		js.appendClassCast(cgOperationCallExp, actualReturnClass, new JavaStream.SubStream()
		{
			@Override
			public void append() {
				js.appendClassReference(libraryOperation.getClass());
				js.append("."+ globalContext.getInstanceName() + "."+ globalContext.getEvaluateName() + "(");
				if (!(libraryOperation instanceof LibrarySimpleOperation)) {
//					js.append(getValueName(localContext.getEvaluatorParameter(cgOperationCallExp)));
					js.append(JavaConstants.EVALUATOR_NAME);
					js.append(", ");
					if (!(libraryOperation instanceof LibraryUntypedOperation)) {
//						CGTypeVariable typeVariable = localContext.getTypeVariable(resultType);
						js.appendValueName(resultType);
						js.append(", ");
					}
				}
				js.appendValueName(source);
				for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : arguments) {
					js.append(", ");
					js.appendValueName(cgArgument);		// FIXME cast
				}
				js.append(")");
			}
		});
		if (expectedIsNonNull && !actualIsNonNull) {
			js.append(")");
		}
		js.append(";\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGLibraryPropertyCallExp(@NonNull CGLibraryPropertyCallExp cgPropertyCallExp) {
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		LibraryProperty libraryProperty = DomainUtil.nonNullState(cgPropertyCallExp.getLibraryProperty());
		Method actualMethod = getJavaMethod(libraryProperty);
		Class<?> actualReturnClass = actualMethod != null ? actualMethod.getReturnType() : null;
		boolean actualIsNonNull = (actualMethod != null) && (context.getIsNonNull(actualMethod) == Boolean.TRUE);
		boolean expectedIsNonNull = cgPropertyCallExp.isNonNull();
//		Class<?> actualBoxedReturnClass = getBoxedReturnClass(libraryProperty);
//		CGValuedElement resultVariable = cgOperationCallExp; //.getValue();
		CGTypeId resultType = cgPropertyCallExp.getTypeId();
//		Class<?> requiredBoxedReturnClass = context.getBoxedClass(resultType.getElementId());
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		js.appendDeclaration(cgPropertyCallExp);
		js.append(" = ");
		if (expectedIsNonNull && !actualIsNonNull) {
			js.appendClassReference(DomainUtil.class);
			js.append(".nonNullState(");
		}
		js.appendClassCast(cgPropertyCallExp, actualReturnClass);
		js.appendClassReference(libraryProperty.getClass());
//		CGOperation cgOperation = DomainUtil.nonNullState(CGUtils.getContainingOperation(cgPropertyCallExp));
		js.append("."+ globalContext.getInstanceName() + "."+ globalContext.getEvaluateName() + "(");
//		if (!(libraryOperation instanceof LibrarySimpleOperation)) {
//			js.append(getValueName(localContext.getEvaluatorParameter(cgPropertyCallExp)));
			js.append(JavaConstants.EVALUATOR_NAME);
			js.append(", ");
//			if (!(libraryProperty instanceof LibraryUntypedOperation)) {
//				CGTypeVariable typeVariable = localContext.getTypeVariable(resultType);
				js.appendValueName(resultType);
				js.append(", ");
//			}
//		}
		js.appendValueName(source);
		if (expectedIsNonNull && !actualIsNonNull) {
			js.append(")");
		}
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGNull(@NonNull CGNull object) {
		js.append("null");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGOperation(@NonNull CGOperation cgOperation) {
		JavaLocalContext localContext2 = globalContext.getLocalContext(cgOperation);
		if (localContext2 != null) {
			localContext = localContext2;
			try {
//				CGValuedElement evaluatorParameter = localContext2.getEvaluatorParameter(cgOperation);
//				CGParameter typeIdParameter = localContext2.getTypeIdParameter(cgOperation);
				List<CGParameter> cgParameters = cgOperation.getParameters();
				CGValuedElement body = getExpression(cgOperation.getBody());
				//
				js.append("@Override\n");
				js.append("public ");
				if (cgOperation.isNull()) {
					js.append("/*@Null*/");
				}
				else {
					js.appendIsRequired(cgOperation.isRequired());
				}
				js.append(" ");
				boolean cgOperationIsInvalid = cgOperation.getInvalidValue() != null;
				js.appendIsCaught(!cgOperationIsInvalid, cgOperationIsInvalid);
				js.append(" ");
				js.appendClassReference(cgOperation);
				js.append(" ");
				js.append(cgOperation.getName());
				js.append("(");
				boolean isFirst = true;
				for (@SuppressWarnings("null")@NonNull CGParameter cgParameter : cgParameters) {
					if (!isFirst) {
						js.append(", ");
					}
					js.appendDeclaration(cgParameter);
					isFirst = false;
				}
				js.append(") {\n");
				js.pushIndentation(null);
					appendReturn(body);
				js.popIndentation();
				js.append("}\n");
			}
			finally {
				localContext = null;
			}
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGPackage(@NonNull CGPackage cgPackage) {
		js.appendCopyrightHeader();
		js.append("package " + cgPackage.getName() + ";\n");
		js.append("\n");
		js.append(ImportUtils.IMPORTS_MARKER + "\n");
		for (CGClass cgClass : cgPackage.getClasses()) {
			cgClass.accept(this);
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGParameter(@NonNull CGParameter object) {
		return true;			// Parameters are declared by their Operation
	}

	@Override
	public @NonNull Boolean visitCGProperty(@NonNull CGProperty cgProperty) {
		localContext = globalContext.getLocalContext(cgProperty);
		try {
			Boolean flowContinues = super.visitCGProperty(cgProperty);
			assert flowContinues != null;
			return flowContinues;
		}
		finally {
			localContext = null;
		}
	}

	@Override
	public @NonNull Boolean visitCGReal(@NonNull CGReal object) {
		js.appendDeclaration(object);
		js.append(" = ");
		js.appendClassReference(ValuesUtil.class);
		js.append(".realValueOf(");
		Number realValue = object.getNumericValue();
		String valueString = realValue.toString();
		if (realValue instanceof Double) {
			js.append(valueString + "d");
		}
		else {
			js.append("\"" + valueString + "\"");
		}
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGString(@NonNull CGString object) {
		js.appendDeclaration(object);
		js.append(" = ");
		js.appendString(DomainUtil.nonNullState(object.getStringValue()));
		js.append(";\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGText(@NonNull CGText cgText) {
		js.appendDeclaration(cgText);
		js.append(" = ");
		js.append(cgText.getTextValue());
		js.append(";\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGTextParameter(@NonNull CGTextParameter cgTextParameter) {
		String name = cgTextParameter.getTextValue();
		if ((localPrefix != null) && "this".equals(name)) {
			js.append(localPrefix);
			js.append(".");
		}
		js.append(name);
		return true;
	}

	@Override
	public @NonNull Boolean visitCGThrowExp(@NonNull CGThrowExp cgThrowExp) {
		CGValuedElement cgSource = getExpression(cgThrowExp.getSource());
		CGInvalid cgInvalidValue;
		if (cgSource.isNonInvalid()) {
			cgSource.accept(this);
		}
		else if ((cgInvalidValue = cgSource.getInvalidValue()) != null) {
			js.append("throw ");
			js.appendReferenceTo(InvalidValueException.class, cgInvalidValue);
			js.append(";\n");
			return false;
		}
		else {
			if (!js.appendLocalStatements(cgSource)) {
				return false;
			}
			js.append("if (");
			js.appendValueName(cgSource);
			js.append(" instanceof ");
			js.appendClassReference(InvalidValueException.class);
			js.append(") {\n");
			js.pushIndentation(null);
				js.append("throw ");
				js.appendReferenceTo(InvalidValueException.class, cgSource);
				js.append(";\n");
			js.popIndentation();
			js.append("}\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGTupleExp(@NonNull CGTupleExp cgTupleExp) {
		List<CGTuplePart> parts = cgTupleExp.getParts();
		for (CGTuplePart cgPart : parts) {
			if (!js.appendLocalStatements(cgPart.getNamedValue())) {
				return false;
			}
		}
		js.appendDeclaration(cgTupleExp);
		js.append(" = ");
		js.appendClassReference(ValuesUtil.class);
		js.append(".createTupleOfEach(");
		js.appendIdReference(cgTupleExp.getTypeId().getElementId());
		int iSize = parts.size();
		for (int i = 0; i < iSize; i++) {
			CGValuedElement cgPartValue = parts.get(i).getNamedValue();
			js.append(", ");
			if ((cgPartValue.isNull()) && (iSize == 1)) {
				js.append("(Object)");						// Disambiguate Object... from Object[] 
			}
			js.appendValueName(cgPartValue);
		}
		js.append(");\n");
		return true;
	}

//	@Override
//	public @NonNull Boolean visitCGTuplePart(@NonNull CGTuplePart cgTuplePart) {
//		js.appendLocalStatements(cgTuplePart.getInit());
//		return true;
//	}

	@Override
	public @NonNull Boolean visitCGTuplePartCallExp(@NonNull CGTuplePartCallExp cgTuplePartCallExp) {
		CGValuedElement source = getExpression(cgTuplePartCallExp.getSource());
//		CGTypeId resultType = cgTuplePartCallExp.getTypeId();
//		Class<?> requiredBoxedReturnClass = context.getBoxedClass(resultType.getElementId());
		TuplePartId partId = cgTuplePartCallExp.getAstTuplePartId();
		//
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		//
		js.appendDeclaration(cgTuplePartCallExp);
		js.append(" = ");
		js.appendClassCast(cgTuplePartCallExp);
		js.appendAtomicReferenceTo(TupleValue.class, source);
		js.append(".getValue(" + partId.getIndex() + "/*" + partId.getName() + "*/);\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGTypeId(@NonNull CGTypeId cgTypeId) {
		if (cgTypeId.isInlined()) {
			js.appendIdReference(cgTypeId.getElementId());
		}
		else {
			super.visitCGTypeId(cgTypeId);
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGTypeExp(@NonNull CGTypeExp cgTypeExp) {
//		getTypeVariable(cgTypeExp.getReferredType());
//		CGExecutorType type = cgTypeExp.getExecutorType();
//		if (type != null) {
//			type.accept(this);
//		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGUnboxExp(@NonNull CGUnboxExp cgUnboxExp) {
		CGValuedElement boxedValue = getExpression(cgUnboxExp.getSource());
		TypeDescriptor boxedTypeDescriptor = context.getTypeDescriptor(boxedValue);
		JavaLocalContext localContext2 = localContext;
		assert localContext2 != null;
		//
		if (!js.appendLocalStatements(boxedValue)) {
			return false;
		}
		return boxedTypeDescriptor.appendUnboxStatements(js, localContext2, cgUnboxExp, boxedValue);
	}

	@Override
	public @NonNull Boolean visitCGUnlimited(@NonNull CGUnlimited object) {
		js.appendClassReference(ValuesUtil.class);
		js.append(".UNLIMITED_VALUE");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGVariable(@NonNull CGVariable cgVariable) {
		CGValuedElement init = cgVariable.getInit();
		if (init != null) {
			if (!js.appendLocalStatements(init)) {
				return false;
			}
		}
//		js.appendDeclaration(cgVariable);
//		if (init != null) {
//			js.append(" = ");
//			js.appendValueName(init);
//		}
//		js.append(";\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGVariableExp(@NonNull CGVariableExp cgVariableExp) {
//		CGValuedElement variable = cgVariableExp.getReferredVariable();
//		if (variable != null) {
//			variable.accept(this);
//		}
		return true;
	}
}
