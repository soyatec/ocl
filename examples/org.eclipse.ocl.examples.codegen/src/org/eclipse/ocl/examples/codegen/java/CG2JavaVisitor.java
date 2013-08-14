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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CGUtils;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
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
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInteger;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid;
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
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibrarySimpleOperation;
import org.eclipse.ocl.examples.domain.library.LibraryUntypedOperation;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorDoubleIterationManager;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.xtext.util.Strings;

/**
 * A CG2JavaVisitor serializes the contributions of a tree of model elements in a StringBuilder whose result may be
 * obtained by toString() on completion.
 * 
 * The individual visits contribute a complete construct, usually one or more statements to the output. However
 * inlineable expressions contribute just their expression value.
 */
public abstract class CG2JavaVisitor extends AbstractExtendingCGModelVisitor<Object, JavaCodeGenerator>
{
	protected final @NonNull JavaGlobalContext globalContext;
	protected final @NonNull GenModelHelper genModelHelper;
	protected final @NonNull CodeGenAnalyzer analyzer;
	protected final @NonNull Id2JavaInterfaceVisitor id2JavaInterfaceVisitor;
//	protected final @NonNull Id2JavaExpressionVisitor id2JavaExpressionVisitor;
	protected final @NonNull JavaStream js;
	
	/**
	 * The local Java context for the current operation.
	 */
	protected JavaLocalContext localContext;
	
	public CG2JavaVisitor(@NonNull JavaCodeGenerator codeGenerator) {
		super(codeGenerator);
		this.globalContext = codeGenerator.getGlobalContext();
		this.genModelHelper = context.getGenModelHelper();
		this.analyzer = context.getAnalyzer();
		this.id2JavaInterfaceVisitor = createId2JavaClassVisitor();
//		this.id2JavaExpressionVisitor = createId2JavaExpressionVisitor();
		this.js = new JavaStream(codeGenerator, this);
	}

	protected void addImport(@NonNull String className) {
		globalContext.addImport(className);
	}

	protected void appendGlobalPrefix() {}

	protected void appendReturn(@NonNull CGValuedElement body) {
		js.appendLocalStatements(body);
		if (body instanceof CGThrowExp) {				// FIXME generalize
			body.accept(this);
		}
		else {
			if (body.isInvalid()) {
				js.append("throw ");
			}
			else {
				js.append("return ");
			}
			js.appendValueName(body);
			js.append(";\n");
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

	private Class<?> getJavaReturnClass(@NonNull LibraryIteration libraryIteration) {
		try {
			@SuppressWarnings("null") @NonNull Class<? extends LibraryIteration> implementationClass = libraryIteration.getClass();
			Method method = implementationClass.getMethod("evaluateIteration", DomainIterationManager.class);
			return method.getReturnType();
		} catch (Exception e) {
			return null;
		}
	}

	private Class<?> getJavaReturnClass(@NonNull LibraryOperation libraryOperation, int argumentSize) {
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
			return method.getReturnType();
		} catch (Exception e) {
			return null;
		}
	}

	private Class<?> getJavaReturnClass(@NonNull LibraryProperty libraryProperty) {
		try {
			@SuppressWarnings("null") @NonNull Class<? extends LibraryProperty> implementationClass = libraryProperty.getClass();
			Class<?>[] arguments = new Class<?>[3];
			arguments[0] = DomainEvaluator.class;
			arguments[1] = TypeId.class; 
			arguments[2] = Object.class; 
			Method method = implementationClass.getMethod("evaluate", arguments);
			return method.getReturnType();
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

	protected @Nullable Method getLeastDerivedMethod(@NonNull Class<?> requiredClass, @NonNull String getAccessor) {
		Method leastDerivedMethod = getLeastDerivedMethodInternal(requiredClass, getAccessor);
		if (leastDerivedMethod != null) {
			return leastDerivedMethod;
		}
		else {
			try {
				return requiredClass.getMethod(getAccessor);
			} catch (Exception e) {
				return null;
			}
		}
	}

	private @Nullable Method getLeastDerivedMethodInternal(@NonNull Class<?> requiredClass, @NonNull String getAccessor) {
		Class<?> superClass = requiredClass.getSuperclass();
		if (superClass != null) {
			try {
				Method lessDerivedSuperMethod = getLeastDerivedMethodInternal(superClass, getAccessor);
				if (lessDerivedSuperMethod != null) {
					return lessDerivedSuperMethod;
				}
				Method method = superClass.getMethod(getAccessor);
				if (method != null) {
					return method;
				}
			} catch (Exception e) {
			}
		}
		for (@SuppressWarnings("null")@NonNull Class<?> superInterface : requiredClass.getInterfaces()) {
			Method lessDerivedSuperMethod = getLeastDerivedMethodInternal(superInterface, getAccessor);
			if (lessDerivedSuperMethod != null) {
				return lessDerivedSuperMethod;
			}
			try {
				Method method = superInterface.getMethod(getAccessor);
				if (method != null) {
					return method;
				}
			} catch (Exception e) {
			}
		}
		return null;
	}

	protected @NonNull MetaModelManager getMetaModelManager() {
		return context.getMetaModelManager();
	}

	protected @NonNull String getValueName(@NonNull CGValuedElement cgElement) {
		String name = cgElement.getValueName();
		if (name == null) {
			name = cgElement.getName();
		}
		if (name == null) {
			name = "<null-" + cgElement.eClass().getName() + ">";
		}
		return name;
	}

	protected String getValueName2(@NonNull CGValuedElement cgElement) {
		String valueName = localContext != null ? localContext.getValueName(cgElement) : globalContext.getValueName(cgElement);
		return valueName;
	}

/*	protected @NonNull CGVariable getVariable(@NonNull CGComputedExp cgValuedElement) {
		CGVariable variableValue = cgValuedElement.getVariableValue();
		if (variableValue == null) {
			CGLocalVariable localVariable = CGModelFactory.eINSTANCE.createCGLocalVariable();
			localVariable.setName(nameManager.getNameHint(cgValuedElement));
			localVariable.setType(cgValuedElement.getType());
			cgValuedElement.setVariableValue(localVariable);
//			cgValuedElement.getLocalVariables().add(localVariable);
			variableValue = localVariable;
		}
		return variableValue;
	} */

/*	protected @NonNull Class<?> reClass(@NonNull Class<?> javaClass) {
		if (javaClass == NamedElement.class) {			// FIXME Avoid two-level Pivot interfaces
			javaClass = DomainNamedElement.class;
		}
		else if (javaClass == Operation.class) {
			javaClass = DomainOperation.class;
		}
		else if (javaClass == org.eclipse.ocl.examples.pivot.Package.class) {
			javaClass = DomainPackage.class;
		}
		else if (javaClass == Property.class) {
			javaClass = DomainProperty.class;
		}
		else if (javaClass == Type.class) {
			javaClass = DomainType.class;
		}
		return javaClass;
	} */

/*	public @Nullable EClass reClass(@NonNull EClass eClass) {
		if (eClass == PivotPackage.Literals.NAMED_ELEMENT) {			// FIXME Avoid two-level Pivot interfaces
			return null;
		}
		else if (eClass == PivotPackage.Literals.OPERATION) {
			return null;
		}
		else if (eClass == PivotPackage.Literals.PACKAGE) {
			return null;
		}
		else if (eClass == PivotPackage.Literals.PROPERTY) {
			return null;
		}
		else if (eClass == PivotPackage.Literals.TYPE) {
			return null;
		}
		return eClass;
	} */
	
	@Override
	public @NonNull String toString() {
		String string = js.toString();
		return string;
	}
	
	@Nullable
	public Object visiting(@NonNull CGElement visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public @Nullable Object visitCGBoolean(@NonNull CGBoolean cgBoolean) {
		boolean booleanValue = cgBoolean.isBooleanValue();
		if (booleanValue) {
			js.appendTrue();
		}
		else {
			js.appendFalse();
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGBoxExp(@NonNull CGBoxExp cgBoxExp) {
		CGValuedElement unboxedValue = getExpression(cgBoxExp.getSource());
		TypeId typeId = unboxedValue.getPivotTypeId();
		TypeDescriptor unboxedTypeDescriptor = context.getTypeDescriptor(unboxedValue);
//
		js.appendLocalStatements(unboxedValue);
//		if (!isNonNull()) {
//			text.appendReferenceTo(JavaSnippet.this);
//			text.append(" == null ? null : ");
//		}
		js.appendDeclaration(cgBoxExp);
		js.append(" = ");
		if (!unboxedValue.isNonNull()) {
			js.appendReferenceTo(unboxedValue);
			js.append(" == null ? null : ");
		}
		if (unboxedTypeDescriptor.isAssignableTo(Iterable.class)) {
			@NonNull String collectionName = "Collection";
			if (typeId instanceof CollectionTypeId) {
				collectionName = ((CollectionTypeId)typeId).getGeneralizedId().getName();
			}
			js.appendReferenceTo(localContext.getIdResolverVariable(cgBoxExp));
			js.append(".create" + collectionName + "OfAll(");
			js.appendIdReference(typeId);
			js.append(", ");
			js.appendReferenceTo(Iterable.class, unboxedValue);
			js.append(")");
		}
		else if (unboxedTypeDescriptor.isAssignableTo(BigInteger.class)
				  || unboxedTypeDescriptor.isAssignableTo(Long.class)
				  || unboxedTypeDescriptor.isAssignableTo(Integer.class)
				  || unboxedTypeDescriptor.isAssignableTo(Short.class)
				  || unboxedTypeDescriptor.isAssignableTo(Byte.class)
				  || unboxedTypeDescriptor.isAssignableTo(Character.class)) {
				js.appendClassReference(ValuesUtil.class);
				js.append(".integerValueOf(");
				js.appendReferenceTo(unboxedValue);
				js.append(")");
			}
		else if ((unboxedTypeDescriptor.getJavaClass() == Object.class) && (typeId == TypeId.INTEGER)) {
				js.appendClassReference(ValuesUtil.class);
				js.append(".integerValueOf(");
				js.appendReferenceTo(unboxedValue);		// Character is unboxed as Object!
				js.append(")");
			}
		else if (unboxedTypeDescriptor.isAssignableTo(BigDecimal.class)
				  || unboxedTypeDescriptor.isAssignableTo(Double.class)
				  || unboxedTypeDescriptor.isAssignableTo(Float.class)) {
				js.appendClassReference(ValuesUtil.class);
				js.append(".realValueOf(");
				js.appendReferenceTo(unboxedValue);
				js.append(")");
			}
		else if (unboxedTypeDescriptor.isAssignableTo(Number.class)) {
			if (typeId == TypeId.REAL){
				js.appendClassReference(ValuesUtil.class);
				js.append(".realValueOf(");
				js.appendReferenceTo(unboxedValue);
				js.append(")");
			}
			else {
				js.appendClassReference(ValuesUtil.class);
				js.append(".integerValueOf(");
				js.appendReferenceTo(unboxedValue);
				js.append(")");
			}
		}
		else if (unboxedTypeDescriptor.isAssignableTo(EEnumLiteral.class)) {
			js.appendClassReference(IdManager.class);
			js.append(".getEnumerationLiteralId(");
			js.appendReferenceTo(unboxedValue);
			js.append(")");
		}
		else if (unboxedTypeDescriptor.isAssignableTo(Enumerator.class)) {
			js.appendIdReference(typeId);
			js.append(".getEnumerationLiteralId(");
			js.appendReferenceTo(unboxedValue);
			js.append(".getName())");
		}
		else {//if (ObjectValue.class.isAssignableFrom(javaClass)) {
			js.appendClassReference(ValuesUtil.class);
			js.append(".createObjectValue(");
			js.appendIdReference(typeId);
			js.append(", ");
			js.appendReferenceTo(unboxedValue);
			js.append(")");
		}
		js.append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGBuiltInIterationCallExp(@NonNull CGBuiltInIterationCallExp cgIterationCallExp) {
		CGValuedElement cgSource = getExpression(cgIterationCallExp.getSource());
		CGValuedElement cgBody = getExpression(cgIterationCallExp.getBody());
		CGIterator cgAccumulator = cgIterationCallExp.getAccumulator();
		CGIterator cgIterator = cgIterationCallExp.getIterators().get(0);
		String iteratorName = localContext.getNameManagerContext().getSymbolName(null, "ITERATOR_" + cgIterator.getValueName());
		Iteration2Java iterationHelper = context.getIterationHelper(DomainUtil.nonNullState(cgIterationCallExp.getReferredIteration()));
		assert iterationHelper != null;
		//
		js.appendLocalStatements(cgSource);
		//
		if (cgAccumulator != null) {
			CGValuedElement cgInit = cgAccumulator.getInit();
			if (cgInit != null) {
				js.appendLocalStatements(cgInit);
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
		js.appendReferenceTo(cgSource);
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
				}
			js.popIndentation();
			js.append("}\n");
			js.appendDeclaration(cgIterator);
			js.append(" = ");
			js.appendClassCast(cgIterator);
			js.append(iteratorName + ".next();\n");
			js.appendCommentWithOCL(null, cgBody.getPivot());
			js.appendLocalStatements(cgBody);
			js.append("//\n");
			iterationHelper.appendUpdate(js, cgIterationCallExp);
		js.popIndentation();
		js.append("}\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGCastExp(@NonNull CGCastExp cgCastExp) {
		CGExecutorType cgType = cgCastExp.getExecutorType();
		if (cgType != null) {
			js.appendDeclaration(cgCastExp);
			js.append(" = (");
			js.appendClassReference(context.getTypeDescriptor(cgCastExp));
			js.append(")");
			js.appendReferenceTo(cgCastExp.getSource());
			js.append(";\n");
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGCatchExp(@NonNull CGCatchExp cgCatchExp) {
		String eName = globalContext.getEName();
		CGValuedElement cgSource = getExpression(cgCatchExp.getSource());
		if (cgSource.isNonInvalid()) {
			js.appendLocalStatements(cgSource);
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
				js.appendLocalStatements(cgSource);
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
		return null;
	}

	@Override
	public @Nullable Object visitCGCollectionExp(@NonNull CGCollectionExp cgCollectionExp) {
		int ranges = 0;
		for (CGCollectionPart cgPart : cgCollectionExp.getParts()) {
			if (cgPart.isRange()) {
				ranges++;
			}
			js.appendLocalStatements(cgPart);
		}
		js.appendDeclaration(cgCollectionExp);
		js.append(" = ");
		js.appendClassReference(ValuesUtil.class);
		String kind = ((CollectionLiteralExp)cgCollectionExp.getPivot()).getKind().getName();
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
		return null;
	}

	@Override
	public @Nullable Object visitCGCollectionPart(@NonNull CGCollectionPart cgCollectionPart) {
		CGValuedElement first = getExpression(cgCollectionPart.getFirst());
		CGValuedElement last = cgCollectionPart.getLast();
		if (last != null) {
			js.appendLocalStatements(first);
			js.appendLocalStatements(last);
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
				js.appendLocalStatements(first);
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGConstantExp(@NonNull CGConstantExp cgConstantExp) {
		CGValuedElement referredConstant = cgConstantExp.getReferredConstant();
		if ((referredConstant != null) && referredConstant.isInlined()) {
			referredConstant.accept(this);
		}
		else {
			// Non-inline constants should be generated somewhere else and referenced by name in the caller
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGConstraint(@NonNull CGConstraint cgConstraint) {
		localContext = globalContext.getLocalContext(cgConstraint);
		try {
			return super.visitCGConstraint(cgConstraint);
		}
		finally {
			localContext = null;
		}
	}

	@Override
	public @Nullable Object visitCGConstructorExp(@NonNull CGConstructorExp cgConstructorExp) {
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
		return null;
	}

	@Override
	public @Nullable Object visitCGConstructorPart(@NonNull CGConstructorPart cgConstructorPart) {
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
		js.appendLocalStatements(init);
		//
		js.appendValueName(cgExecutorConstructorPart);
		js.append(".initValue(");
		js.appendValueName(cgConstructorPart.getConstructorExp());
		js.append(", ");
		js.appendValueName(init);
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGEcoreDataTypeConstructorExp(@NonNull CGEcoreDataTypeConstructorExp cgConstructorExp) {
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
		return null;
	}

	@Override
	public @Nullable Object visitCGEcoreOperationCallExp(@NonNull CGEcoreOperationCallExp cgOperationCallExp) {
		Operation pOperation = cgOperationCallExp.getReferredOperation();
		CGTypeId cgTypeId = analyzer.getTypeId(pOperation.getOwningType().getTypeId());
//		TypeDescriptor requiredTypeDescriptor = context.getUnboxedDescriptor(cgTypeId.getElementId());
		TypeDescriptor requiredTypeDescriptor = context.getTypeDescriptor(DomainUtil.nonNullState(cgTypeId.getElementId()), false);
		CGValuedElement source = getExpression(cgOperationCallExp.getSource());
		List<CGValuedElement> cgArguments = cgOperationCallExp.getArguments();
		List<Parameter> pParameters = pOperation.getOwnedParameter();
		//
		js.appendLocalStatements(source);
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgArguments) {
			CGValuedElement argument = getExpression(cgArgument);
			js.appendLocalStatements(argument);
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
				TypeDescriptor parameterTypeDescriptor = context.getTypeDescriptor(DomainUtil.nonNullState(cgParameterTypeId.getElementId()), false);
				js.appendReferenceTo(parameterTypeDescriptor, argument);
				
			}
		}
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGEcorePropertyCallExp(@NonNull CGEcorePropertyCallExp cgPropertyCallExp) {
		Property pivotProperty = cgPropertyCallExp.getReferredProperty();
		CGTypeId cgTypeId = analyzer.getTypeId(pivotProperty.getOwningType().getTypeId());
		ElementId elementId = DomainUtil.nonNullState(cgTypeId.getElementId());
		TypeDescriptor requiredTypeDescriptor = context.getTypeDescriptor(elementId, false);
		EStructuralFeature eStructuralFeature = DomainUtil.nonNullState(cgPropertyCallExp.getEStructuralFeature());
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		String getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
		Class<?> requiredJavaClass = requiredTypeDescriptor.hasJavaClass();
		Method leastDerivedMethod = requiredJavaClass != null ? getLeastDerivedMethod(requiredJavaClass, getAccessor) : null;
//		boolean isNonNull;
//		boolean isNullable;
		Class<?> unboxedSourceClass;
		if (leastDerivedMethod != null){
//			NonNull nonNullAnnotation = leastDerivedMethod.getAnnotation(NonNull.class);
//			Nullable nullableAnnotation = leastDerivedMethod.getAnnotation(Nullable.class);
//			isNonNull = nonNullAnnotation != null;		// FIXME Never present
//			isNullable = nullableAnnotation != null;
			unboxedSourceClass = leastDerivedMethod.getDeclaringClass();
		}
		else {
//			isNonNull = false;
//			isNullable = false;
			unboxedSourceClass = requiredJavaClass;
		}
		//
		js.appendLocalStatements(source);
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
		js.append("();");
//		js.append(" // " + (unboxedSourceClass != null ? unboxedSourceClass.getName() : "null"));
//		js.append(unboxedSourceClass != null ? unboxedSourceClass.getName() : "null");
//		js.append(source.isCaught() ? " caught" : " thrown");
//		js.append(source.getValue().isCaught() ? " caught" : " thrown");
		js.append("\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGElementId(@NonNull CGElementId cgElementId) {
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
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorCompositionProperty(@NonNull CGExecutorCompositionProperty cgExecutorProperty) {
		js.appendDeclaration(cgExecutorProperty);
		js.append(" = new ");
		js.appendClassReference(cgExecutorProperty);
		js.append("(");
		Property pivotProperty = (Property) cgExecutorProperty.getPivot();
		Property pivotOppositeProperty = pivotProperty.getOpposite();
		js.appendString(DomainUtil.nonNullState(pivotOppositeProperty.getName()));
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorConstructorPart(@NonNull CGExecutorConstructorPart cgExecutorConstructorPart) {
		js.appendDeclaration(cgExecutorConstructorPart);
		js.append(" = ");
		js.appendValueName(localContext.getIdResolverVariable(cgExecutorConstructorPart));
		js.append(".getProperty(");
		js.appendIdReference(cgExecutorConstructorPart.getUnderlyingPropertyId().getElementId());
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorNavigationProperty(@NonNull CGExecutorNavigationProperty cgExecutorProperty) {
		js.appendDeclaration(cgExecutorProperty);
		js.append(" = new ");
		js.appendClassReference(cgExecutorProperty);
		js.append("(");
		js.appendIdReference(cgExecutorProperty.getUnderlyingPropertyId().getElementId());
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorOppositeProperty(@NonNull CGExecutorOppositeProperty cgExecutorProperty) {
		Property pivotProperty = (Property) cgExecutorProperty.getPivot();
		Property pivotOppositeProperty = pivotProperty.getOpposite();
		js.appendDeclaration(cgExecutorProperty);
		js.append(" = new ");
		js.appendClassReference(cgExecutorProperty);
		js.append("(");
		js.appendIdReference(pivotOppositeProperty.getPropertyId());
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorOperation(@NonNull CGExecutorOperation cgExecutorOperation) {
		js.appendDeclaration(cgExecutorOperation);
		js.append(" = ");
		js.appendValueName(localContext.getIdResolverVariable(cgExecutorOperation));
		js.append(".getOperation(");
		js.appendIdReference(cgExecutorOperation.getUnderlyingOperationId().getElementId());
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorOperationCallExp(@NonNull CGExecutorOperationCallExp cgOperationCallExp) {
		Operation pOperation = cgOperationCallExp.getReferredOperation();
		CGValuedElement source = getExpression(cgOperationCallExp.getSource());
		List<CGValuedElement> cgArguments = cgOperationCallExp.getArguments();
		List<Parameter> pParameters = pOperation.getOwnedParameter();
		//
		js.appendLocalStatements(source);
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgArguments) {
			CGValuedElement argument = getExpression(cgArgument);
			js.appendLocalStatements(argument);
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
		js.appendIdReference(cgOperationCallExp.getPivotTypeId());
		js.append(", ");
		js.appendValueName(source);
		int iMax = Math.min(pParameters.size(), cgArguments.size());
		for (int i = 0; i < iMax; i++) {
			js.append(", ");
			CGValuedElement cgArgument = cgArguments.get(i);
			Parameter pParameter = pParameters.get(i);
			CGTypeId cgTypeId = analyzer.getTypeId(pParameter.getTypeId());
			TypeDescriptor parameterTypeDescriptor = context.getTypeDescriptor(DomainUtil.nonNullState(cgTypeId.getElementId()), false);
			CGValuedElement argument = getExpression(cgArgument);
			js.appendReferenceTo(parameterTypeDescriptor, argument);
		}
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorPropertyCallExp(@NonNull CGExecutorPropertyCallExp cgPropertyCallExp) {
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		//
		js.appendLocalStatements(source);
		//
		js.appendDeclaration(cgPropertyCallExp);
		js.append(" = ");
		js.appendClassCast(cgPropertyCallExp);
		js.appendReferenceTo(cgPropertyCallExp.getExecutorProperty());
		js.append(".evaluate(");
//		js.append(getValueName(localContext.getEvaluatorParameter(cgPropertyCallExp)));
		js.append(JavaConstants.EVALUATOR_NAME);
		js.append(", ");
		js.appendIdReference(cgPropertyCallExp.getPivotTypeId());
		js.append(", ");
		js.appendValueName(source);
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorType(@NonNull CGExecutorType cgExecutorType) {
		js.appendDeclaration(cgExecutorType);
		js.append(" = ");
		js.appendValueName(localContext.getIdResolverVariable(cgExecutorType));
		js.append(".getType(");
		js.appendIdReference(cgExecutorType.getUnderlyingTypeId().getElementId());
		js.append(", null);\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGGuardExp(@NonNull CGGuardExp cgGuardExp) {
		CGValuedElement cgSource = getExpression(cgGuardExp.getSource());
		//
		if (cgSource.isNull()) {
			js.append("throw new ");
			js.appendClassReference(InvalidValueException.class);
			js.append("();\n");
		}
		else {
			js.appendLocalStatements(cgSource);
			if (!cgSource.isNonNull()) {
				js.append("if (");
				js.appendValueName(cgSource);
				js.append(" == null) {\n");
				js.pushIndentation(null);
					js.append("throw new ");
					js.appendClassReference(InvalidValueException.class);
					js.append("(\"Null source\");\n");
					js.popIndentation();
				js.append("}\n");
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGIfExp(@NonNull CGIfExp cgIfExp) {
		CGValuedElement condition = getExpression(cgIfExp.getCondition());
		CGValuedElement thenExpression = getExpression(cgIfExp.getThenExpression());
		CGValuedElement elseExpression = getExpression(cgIfExp.getElseExpression());
//		CGVariable resultVariable = localContext.getLocalVariable(cgIfExp);
		//
		js.appendLocalStatements(condition);
		js.appendDeclaration(cgIfExp);
		js.append(";\n");
		//
		js.append("if (");
		js.appendValueName(condition);
		js.append(") {\n");
		js.pushIndentation(null);
			js.appendAssignment(cgIfExp, thenExpression);
		js.popIndentation();
		js.append("}\n");
		js.append("else {\n");
		js.pushIndentation(null);
			js.appendAssignment(cgIfExp, elseExpression);
		js.popIndentation();
		js.append("}\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGInteger(@NonNull CGInteger object) {
		js.appendDeclaration(object);
		js.append(" = ");
		js.appendClassReference(ValuesUtil.class);
		js.append(".integerValueOf(");
		Number integerValue = object.getIntegerValue();
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
		return null;
	}

	@Override
	public @Nullable Object visitCGInvalid(@NonNull CGInvalid object) {
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
		return null;
	}

	@Override
	public @Nullable Object visitCGIsInvalidExp(@NonNull CGIsInvalidExp cgIsInvalidExp) {
		if (cgIsInvalidExp.isTrue()) {
			js.appendTrue();
		}
		else if (cgIsInvalidExp.isFalse()) {
			js.appendFalse();
		}
		else {
			CGValuedElement cgSource = getExpression(cgIsInvalidExp.getSource());
			js.appendLocalStatements(cgSource);
			//
			js.appendDeclaration(cgIsInvalidExp);
			js.append(" = ");
			js.appendValueName(cgSource);
			js.append(" instanceof ");
			js.appendClassReference(InvalidValueException.class);
			js.append(";\n");
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGIsUndefinedExp(@NonNull CGIsUndefinedExp cgIsUndefinedExp) {
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
			js.appendLocalStatements(cgSource);
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
		return null;
	}

	@Override
	public @Nullable Object visitCGLetExp(@NonNull CGLetExp cgLetExp) {
		cgLetExp.getInit().accept(this);
		CGValuedElement cgIn = cgLetExp.getIn();
		if (cgIn != null) {
			js.appendLocalStatements(cgIn);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryIterateCallExp(@NonNull CGLibraryIterateCallExp cgIterateCallExp) {
		CGValuedElement source = getExpression(cgIterateCallExp.getSource());
		CGValuedElement body = getExpression(cgIterateCallExp.getBody());
		LibraryIteration libraryIteration = DomainUtil.nonNullState(cgIterateCallExp.getLibraryIteration());
		Class<?> actualReturnClass = getJavaReturnClass(libraryIteration);
		CGIterator iterateResult = cgIterateCallExp.getResult();
		CGTypeId resultType = cgIterateCallExp.getTypeId();
//		CGValuedElement evaluatorParameter = localContext.getEvaluatorParameter(cgIterateCallExp);
		List<CGIterator> iterators = cgIterateCallExp.getIterators();
//		final int arity = iterators.size();
		final Class<?> operationClass = genModelHelper.getAbstractOperationClass(iterators);
		final String astName = cgIterateCallExp.getValueName();
		Operation referredOperation = ((LoopExp)cgIterateCallExp.getPivot()).getReferredIteration();
		final Class<?> managerClass = ExecutorSingleIterationManager.class;
		final String staticTypeName = "TYPE_" + astName;
		final String implementationName = "IMPL_" + astName;
		final String managerName = "MGR_" + astName;
		final String bodyName = "BODY_" + astName;
		
		
		
		js.appendLocalStatements(source);
		CGValuedElement init = iterateResult.getInit();
		final String accumulatorName = init.getValueName();
		js.appendLocalStatements(init);
		js.appendDeclaration(iterateResult);
		js.append(" = ");
		js.appendValueName(init);
		js.append(";\n");
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
			js.appendCommentWithOCL(null, body.getPivot());
			js.append("@Override\n");
			js.append("public ");
			js.appendIsRequired(false);
			js.append(" Object evaluate(");
			js.append("final ");
			js.appendIsRequired(true);
			js.append("  ");
//			js.appendDeclaration(evaluatorParameter);
			js.appendClassReference(DomainEvaluator.class);
			js.append("  ");
			js.append(JavaConstants.EVALUATOR_NAME);
			js.append(", ");
			js.append("final ");
			js.appendIsRequired(true);
			js.append("  ");
//			js.appendDeclaration(localContext.getTypeIdParameter(cgIterateCallExp));
			js.appendClassReference(TypeId.class);
			js.append("  ");
			js.append(JavaConstants.TYPE_ID_NAME);
			js.append(", ");
			js.appendDeclaration(iterateResult);
			for (@SuppressWarnings("null")@NonNull CGParameter iterator : iterators) {
				js.append(", ");
				js.appendDeclaration(iterator);
			}
			js.append(") {\n");
			js.pushIndentation(null);
				JavaLocalContext savedLocalContext = localContext;
				try {
					localContext = globalContext.getLocalContext(cgIterateCallExp);
					List<CGIterator> allIterators = new ArrayList<CGIterator>(iterators);
					allIterators.add(iterateResult);
					appendReturn(body);
				}
				finally {
					localContext = savedLocalContext;
				}
			js.popIndentation();
			js.append("}\n");
		js.popIndentation();
		js.append("};\n");
		//
		js.appendClassReference(DomainType.class);
		js.append(" " + staticTypeName + " = ");
//		js.appendReferenceTo(evaluatorParameter);
		js.appendClassReference(DomainEvaluator.class);
		js.append(".getStaticTypeOf(");
		js.appendValueName(source);
		js.append(");\n");
		//
		js.appendClassReference(LibraryIteration.class);
		js.append(" " + implementationName + " = ("); 
		js.appendClassReference(LibraryIteration.class);
		js.append( ")" + staticTypeName + ".lookupImplementation("); 
		js.appendReferenceTo(localContext.getStandardLibraryVariable(cgIterateCallExp));
		js.append(", ");
		js.appendQualifiedLiteralName(DomainUtil.nonNullState(referredOperation));
		js.append(");\n");
		//
		js.appendClassReference(managerClass);
		js.append(" " + managerName + " = new ");
		js.appendClassReference(managerClass);
		js.append("(");
//		js.appendReferenceTo(evaluatorParameter);
		js.appendClassReference(DomainEvaluator.class);
		js.append(", ");
		js.appendValueName(resultType);
		js.append(", " + bodyName + ", ");
//		js.appendReferenceTo(CollectionValue.class, source);
		js.appendValueName(source);
		js.append(", " + accumulatorName + ");\n");
		//
		js.appendDeclaration(cgIterateCallExp);
		js.append(" = ");
		js.appendClassCast(cgIterateCallExp, actualReturnClass);
		js.append(implementationName + ".evaluateIteration(" + managerName + ")");
		js.append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryIterationCallExp(@NonNull CGLibraryIterationCallExp cgIterationCallExp) {
		CGValuedElement source = getExpression(cgIterationCallExp.getSource());
		CGValuedElement body = getExpression(cgIterationCallExp.getBody());
		LibraryIteration libraryIteration = DomainUtil.nonNullState(cgIterationCallExp.getLibraryIteration());
		Class<?> actualReturnClass = getJavaReturnClass(libraryIteration);
//		Class<?> actualBoxedReturnClass = getBoxedReturnClass(libraryIteration, 0);
//		CGValuedElement resultVariable = cgIterationCallExp.getValue();
		CGTypeId resultType = cgIterationCallExp.getTypeId();
//		Class<?> requiredBoxedReturnClass = context.getBoxedClass(resultType.getElementId());
//		CGValuedElement evaluatorParameter = localContext.getEvaluatorParameter(cgIterationCallExp);
		List<CGIterator> iterators = cgIterationCallExp.getIterators();
		final int arity = iterators.size();
		final Class<?> operationClass = genModelHelper.getAbstractOperationClass(iterators);
		final String astName = cgIterationCallExp.getValueName();
		Operation referredOperation = ((LoopExp)cgIterationCallExp.getPivot()).getReferredIteration();
		final Class<?> managerClass = arity == 1 ? ExecutorSingleIterationManager.class : ExecutorDoubleIterationManager.class; 	// FIXME ExecutorMultipleIterationManager
		final String staticTypeName = "TYPE_" + astName;
		final String accumulatorName = "ACC_" + astName;
		final String implementationName = "IMPL_" + astName;
		final String managerName = "MGR_" + astName;
		final String bodyName = "BODY_" + astName;
		
		
		
		js.appendLocalStatements(source);
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
			js.appendCommentWithOCL(null, body.getPivot());
			js.append("@Override\n");
			js.append("public ");
			js.appendIsRequired(false);
			js.append(" Object evaluate(");
			js.append("final ");
			js.appendIsRequired(true);
			js.append("  ");
//			js.appendDeclaration(evaluatorParameter);
			js.appendClassReference(DomainEvaluator.class);
			js.append("  ");
			js.append(JavaConstants.EVALUATOR_NAME);
			js.append(", ");
			js.append("final ");
			js.appendIsRequired(true);
			js.append("  ");
//			js.appendDeclaration(localContext.getTypeIdParameter(cgIterateCallExp));
			js.appendClassReference(TypeId.class);
			js.append("  ");
			js.append(JavaConstants.TYPE_ID_NAME);
			js.append(", final ");
			js.appendIsRequired(false);
			js.append(" Object ");
			js.appendValueName(source);
//			js.appendDeclaration(source);
			for (@SuppressWarnings("null")@NonNull CGParameter iterator : iterators) {
				js.append(", ");
				js.appendDeclaration(iterator);
			}
			js.append(") {\n");
			js.pushIndentation(null);
				JavaLocalContext savedLocalContext = localContext;
				try {
					localContext = globalContext.getLocalContext(cgIterationCallExp);
					appendReturn(body);
				}
				finally {
					localContext = savedLocalContext;
				}
			js.popIndentation();
			js.append("}\n");
		js.popIndentation();
		js.append("};\n");
		//
		js.appendClassReference(DomainType.class);
		js.append(" " + staticTypeName + " = ");
//		js.appendReferenceTo(evaluatorParameter);
		js.append(JavaConstants.EVALUATOR_NAME);
		js.append(".getStaticTypeOf(");
		js.appendValueName(source);
		js.append(");\n");
		//
		js.appendClassReference(LibraryIteration.class);
		js.append(" " + implementationName + " = ("); 
		js.appendClassReference(LibraryIteration.class);
		js.append( ")" + staticTypeName + ".lookupImplementation("); 
		js.appendReferenceTo(localContext.getStandardLibraryVariable(cgIterationCallExp));
		js.append(", ");
		js.appendQualifiedLiteralName(DomainUtil.nonNullState(referredOperation));
		js.append(");\n");
		//
		js.append("Object " + accumulatorName + " = " + implementationName + ".createAccumulatorValue(");
//		js.appendValueName(evaluatorParameter);
		js.append(JavaConstants.EVALUATOR_NAME);
		js.append(", ");
		js.appendValueName(resultType);
		js.append(", ");
		js.appendValueName(body.getTypeId());
		js.append(");\n");
		//
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
		js.append(", " + accumulatorName + ");\n");
		//
		js.appendDeclaration(cgIterationCallExp);
		js.append(" = ");
		js.appendClassCast(cgIterationCallExp, actualReturnClass);
		js.append(implementationName + ".evaluateIteration(" + managerName + ")");
		js.append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryOperationCallExp(@NonNull CGLibraryOperationCallExp cgOperationCallExp) {
		CGValuedElement source = getExpression(cgOperationCallExp.getSource());
		List<CGValuedElement> arguments = cgOperationCallExp.getArguments();
		LibraryOperation libraryOperation = DomainUtil.nonNullState(cgOperationCallExp.getLibraryOperation());
		Class<?> actualReturnClass = getJavaReturnClass(libraryOperation, arguments.size());
		CGTypeId resultType = cgOperationCallExp.getTypeId();
		js.appendLocalStatements(source);
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : arguments) {
			js.appendLocalStatements(cgArgument);
		}
		js.appendDeclaration(cgOperationCallExp);
		js.append(" = ");
		js.appendClassCast(cgOperationCallExp, actualReturnClass);
		js.appendClassReference(libraryOperation.getClass());
		js.append("."+ globalContext.getInstanceName() + "."+ globalContext.getEvaluateName() + "(");
		if (!(libraryOperation instanceof LibrarySimpleOperation)) {
//			js.append(getValueName(localContext.getEvaluatorParameter(cgOperationCallExp)));
			js.append(JavaConstants.EVALUATOR_NAME);
			js.append(", ");
			if (!(libraryOperation instanceof LibraryUntypedOperation)) {
//				CGTypeVariable typeVariable = localContext.getTypeVariable(resultType);
				js.appendValueName(resultType);
				js.append(", ");
			}
		}
		js.appendValueName(source);
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : arguments) {
			js.append(", ");
			js.appendValueName(cgArgument);		// FIXME cast
		}
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryPropertyCallExp(@NonNull CGLibraryPropertyCallExp cgPropertyCallExp) {
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		LibraryProperty libraryProperty = DomainUtil.nonNullState(cgPropertyCallExp.getLibraryProperty());
		Class<?> actualReturnClass = getJavaReturnClass(libraryProperty);
//		Class<?> actualBoxedReturnClass = getBoxedReturnClass(libraryProperty);
//		CGValuedElement resultVariable = cgOperationCallExp; //.getValue();
		CGTypeId resultType = cgPropertyCallExp.getTypeId();
//		Class<?> requiredBoxedReturnClass = context.getBoxedClass(resultType.getElementId());
		js.appendLocalStatements(source);
		js.appendDeclaration(cgPropertyCallExp);
		js.append(" = ");
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
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGNull(@NonNull CGNull object) {
		js.append("null");
		return null;
	}

	@Override
	public @Nullable Object visitCGOperation(@NonNull CGOperation cgOperation) {
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
				js.appendIsCaught(!cgOperation.isInvalid(), cgOperation.isInvalid());
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
		return null;
	}

	@Override
	public @Nullable Object visitCGPackage(@NonNull CGPackage cgPackage) {
		js.appendCopyrightHeader();
		js.append("package " + cgPackage.getName() + ";\n");
		js.append("\n");
		js.append(ImportUtils.IMPORTS_MARKER + "\n");
		for (CGClass cgClass : cgPackage.getClasses()) {
			cgClass.accept(this);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGParameter(@NonNull CGParameter object) {
		return null;			// Parameters are declared by their Operation
	}

	@Override
	public @Nullable Object visitCGProperty(@NonNull CGProperty cgProperty) {
		localContext = globalContext.getLocalContext(cgProperty);
		try {
			return super.visitCGProperty(cgProperty);
		}
		finally {
			localContext = null;
		}
	}

	@Override
	public @Nullable Object visitCGReal(@NonNull CGReal object) {
		js.appendDeclaration(object);
		js.append(" = ");
		js.appendClassReference(ValuesUtil.class);
		js.append(".realValueOf(");
		Number realValue = object.getRealValue();
		String valueString = realValue.toString();
		if (realValue instanceof Double) {
			js.append(valueString + "d");
		}
		else {
			js.append("\"" + valueString + "\"");
		}
		js.append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGString(@NonNull CGString object) {
		js.appendDeclaration(object);
		js.append(" = ");
		js.appendString(DomainUtil.nonNullState(object.getStringValue()));
		js.append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGText(@NonNull CGText cgText) {
		js.appendDeclaration(cgText);
		js.append(" = ");
		js.append(cgText.getTextValue());
		js.append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGTextParameter(@NonNull CGTextParameter cgTextParameter) {
		js.append(cgTextParameter.getTextValue());
		return null;
	}

	@Override
	public @Nullable Object visitCGThrowExp(@NonNull CGThrowExp cgThrowExp) {
		CGValuedElement cgSource = getExpression(cgThrowExp.getSource());
		if (cgSource.isNonInvalid()) {
			cgSource.accept(this);
		}
		else if (cgSource.isInvalid()) {
			js.append("throw ");
			js.appendReferenceTo(InvalidValueException.class, cgSource);
			js.append(";\n");
		}
		else {
			js.appendLocalStatements(cgSource);
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
		return null;
	}

	@Override
	public @Nullable Object visitCGTupleExp(@NonNull CGTupleExp cgTupleExp) {
		List<CGTuplePart> parts = cgTupleExp.getParts();
		for (CGTuplePart cgPart : parts) {
			js.appendLocalStatements(cgPart.getValue());
		}
		js.appendDeclaration(cgTupleExp);
		js.append(" = ");
		js.appendClassReference(ValuesUtil.class);
		js.append(".createTupleOfEach(");
		js.appendIdReference(cgTupleExp.getTypeId().getElementId());
		int iSize = parts.size();
		for (int i = 0; i < iSize; i++) {
			CGValuedElement cgPartValue = parts.get(i).getValue();
			js.append(", ");
			if ((cgPartValue.isNull()) && (iSize == 1)) {
				js.append("(Object)");						// Disambiguate Object... from Object[] 
			}
			js.appendValueName(cgPartValue);
		}
		js.append(");\n");
		return null;
	}

//	@Override
//	public @Nullable Object visitCGTuplePart(@NonNull CGTuplePart cgTuplePart) {
//		js.appendLocalStatements(cgTuplePart.getInit());
//		return null;
//	}

	@Override
	public @Nullable Object visitCGTuplePartCallExp(@NonNull CGTuplePartCallExp cgTuplePartCallExp) {
		CGValuedElement source = getExpression(cgTuplePartCallExp.getSource());
//		CGTypeId resultType = cgTuplePartCallExp.getTypeId();
//		Class<?> requiredBoxedReturnClass = context.getBoxedClass(resultType.getElementId());
		TuplePartId partId = cgTuplePartCallExp.getPivotTuplePartId();
		//
		js.appendLocalStatements(source);
		//
		js.appendDeclaration(cgTuplePartCallExp);
		js.append(" = ");
		js.appendClassCast(cgTuplePartCallExp);
		js.appendAtomicReferenceTo(TupleValue.class, source);
		js.append(".getValue(" + partId.getIndex() + "/*" + partId.getName() + "*/);\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGTypeId(@NonNull CGTypeId cgTypeId) {
		if (cgTypeId.isInlined()) {
			js.appendIdReference(cgTypeId.getElementId());
		}
		else {
			super.visitCGTypeId(cgTypeId);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGTypeExp(@NonNull CGTypeExp cgTypeExp) {
//		getTypeVariable(cgTypeExp.getReferredType());
//		CGExecutorType type = cgTypeExp.getExecutorType();
//		if (type != null) {
//			type.accept(this);
//		}
		return null;
	}

	@Override
	public @Nullable Object visitCGUnboxExp(@NonNull CGUnboxExp cgUnboxExp) {
		CGValuedElement source = getExpression(cgUnboxExp.getSource());
		TypeDescriptor boxedTypeDescriptor = context.getTypeDescriptor(source);
		//
		js.appendLocalStatements(source);
		if (boxedTypeDescriptor.isAssignableTo(CollectionValue.class)) {
			js.append("final ");
//			js.appendIsRequired(true);
//			js.append(" ");
			js.appendClassReference(List.class);
			js.append(" ");
			js.appendValueName(cgUnboxExp);
			js.append(" = ");
			js.appendValueName(source);
			js.append(".asEcoreObject(");
			js.appendReferenceTo(localContext.getIdResolverVariable(cgUnboxExp));
			js.append(")");
		}
		else {
			js.appendDeclaration(cgUnboxExp);
			js.append(" = ");
			if (boxedTypeDescriptor.isAssignableTo(IntegerValue.class)) {
				js.appendValueName(source);
				js.append(".asNumber()");
			}
			else if (boxedTypeDescriptor.isAssignableTo(RealValue.class)) {
				js.appendValueName(source);
				js.append(".asNumber()");
			}
			else { //if (boxedTypeDescriptor.isAssignableTo(EnumerationLiteralId.class)) {
				js.appendReferenceTo(localContext.getIdResolverVariable(cgUnboxExp));
				js.append(".unboxedValueOf(");
				js.appendValueName(source);
				js.append(")");
			}
		}
//		else {
//			js.appendValueName(source);
//			js.append(".GET_UNBOXED_VALUE(\"" + boxedTypeDescriptor.getClassName() + "\")");
//		}
		js.append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGUnlimited(@NonNull CGUnlimited object) {
		js.appendClassReference(ValuesUtil.class);
		js.append(".UNLIMITED_VALUE");
		return null;
	}

	@Override
	public @Nullable Object visitCGVariable(@NonNull CGVariable cgVariable) {
		CGValuedElement init = cgVariable.getInit();
		if (init != null) {
			js.appendLocalStatements(init);
		}
//		js.appendDeclaration(cgVariable);
//		if (init != null) {
//			js.append(" = ");
//			js.appendValueName(init);
//		}
//		js.append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGVariableExp(@NonNull CGVariableExp cgVariableExp) {
//		CGValuedElement variable = cgVariableExp.getReferredVariable();
//		if (variable != null) {
//			variable.accept(this);
//		}
		return null;
	}
}
