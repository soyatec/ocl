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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.generator.CodeGenLabel;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet.AbstractTextAppender;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.inliner.Inliner;
import org.eclipse.ocl.examples.codegen.inliner.PropertyInliner;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorDoubleIterationManager;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * An AST2JavaSnippetVisitor creates a JavaSnippet to realize the code for a Pivot AST node.
 * <p>
 * Derived visitors may support an extended AST.
 */
public class AST2JavaSnippetVisitor extends AbstractExtendingVisitor<CodeGenSnippet, CodeGenerator>
{
	public static @NonNull Class<?> getCommonClass(@NonNull Class<?> aClass, @NonNull Class<?> bClass) {
		Class<?> commonClass = getCommonClass2(aClass, bClass);
		return commonClass != null ? commonClass : Object.class;
	}
	private static @Nullable Class<?> getCommonClass2(@NonNull Class<?> aClass, @NonNull Class<?> bClass) {
		if (aClass.isAssignableFrom(bClass)) {
			return aClass;
		}
		Class<?> superClass = aClass.getSuperclass();
		if (superClass != null) {
			Class<?> commonClass = getCommonClass2(superClass, bClass);
			if (commonClass != null) {
				return commonClass;
			}
		}
		for (Class<?> superInterface : aClass.getInterfaces()) {
			assert superInterface != null;
			Class<?> commonClass = getCommonClass2(superInterface, bClass);
			if (commonClass != null) {
				return commonClass;
			}
		}
		return null;
	}

	protected final @NonNull NameManager nameManager;
	protected final @NonNull GenModelHelper genModelHelper;
	
	public AST2JavaSnippetVisitor(@NonNull CodeGenerator codeGenerator) {
		super(codeGenerator);
		nameManager = codeGenerator.getNameManager();
		genModelHelper = codeGenerator.getGenModelHelper();
	}

//	protected String atNonNull() {
//		return context.atNonNull();
//	}

//	protected String atNullable() {
//		return context.atNullable();
//	}

	protected String getImplementationName(@NonNull CodeGenSnippet snippet, @NonNull Operation anOperation) {
		String implementationClass = anOperation.getImplementationClass();
		if (implementationClass != null) {
			return snippet.getImportedName(implementationClass) + ".INSTANCE";
		}
		List<Constraint> constraints = anOperation.getOwnedRule();
		if (constraints.size() > 0) {			
			String stereotype = constraints.get(0).getStereotype();
			if (stereotype != null) {
				String implementationName = genModelHelper.getQualifiedOperationImplementationName(snippet, anOperation, stereotype);
				if (implementationName != null) {
					return implementationName;
				}
			}
		}	
		return "null";
	}

	protected @Nullable String getImplementationName(@NonNull CodeGenSnippet snippet, @NonNull Property aProperty) {
		String implementationClass = aProperty.getImplementationClass();
		if (implementationClass != null) {
			return snippet.getImportedName(implementationClass) + ".INSTANCE";
		}
		List<Constraint> constraints = aProperty.getOwnedRule();
		if (constraints.size() > 0) {			
			String stereotype = constraints.get(0).getStereotype();
			if (stereotype != null) {
				String implementationName = genModelHelper.getQualifiedPropertyImplementationName(snippet, aProperty, stereotype);
				if (implementationName != null) {
					return implementationName;
				}
			}
		}	
		return null;
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

	protected @Nullable Method getLeastDerivedMethod(Class<?> requiredClass, @NonNull String getAccessor) {
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
	private @Nullable Method getLeastDerivedMethodInternal(Class<?> requiredClass, @NonNull String getAccessor) {
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
		for (Class<?> superInterface : requiredClass.getInterfaces()) {
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

	private Class<?> getReturnClass(LibraryFeature libraryFeature, int argumentSize) {
		try {
			@SuppressWarnings("null") @NonNull Class<? extends LibraryFeature> implementationClass = libraryFeature.getClass();
			Class<?>[] arguments = new Class<?>[argumentSize+3];
			arguments[0] = DomainEvaluator.class;
			arguments[1] = TypeId.class; 
			arguments[2] = Object.class; 
			for (int i = 0; i < argumentSize; i++) {
				arguments[3+i] = Object.class; 
			}
			Method method = implementationClass.getMethod("evaluate", arguments);
			return method.getReturnType();
		} catch (Exception e) {
			return null;
		}
	}

	protected @Nullable Class<?> getReturnClass(@NonNull Property referredProperty) {
		try {
			LibraryFeature implementation = context.getMetaModelManager().getImplementation(referredProperty);
			@SuppressWarnings("null") @NonNull Class<? extends LibraryFeature> implementationClass = implementation.getClass();
			Method method = implementationClass.getMethod("evaluate", DomainEvaluator.class, TypeId.class, Object.class);
			return method.getReturnType();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public @NonNull CodeGenSnippet visitBooleanLiteralExp(@NonNull BooleanLiteralExp element) {
		return context.getSnippet(element.isBooleanSymbol());
	}

	@Override
	public @NonNull CodeGenSnippet visitCollectionItem(@NonNull CollectionItem element) {
		@NonNull CodeGenSnippet snippet = context.getSnippet(DomainUtil.nonNullModel(element.getItem()));
		snippet.addElement(element);
		return snippet;
	}

	@Override
	public @NonNull CodeGenSnippet visitCollectionLiteralExp(@NonNull CollectionLiteralExp element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		if (analysis.isConstant()) {
			return context.getSnippet(analysis.getConstantValue());
		}
		CollectionType collectionType = (CollectionType) element.getType();
		Class<?> resultClass = context.getBoxedClass(element.getTypeId());
		@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, CodeGenSnippet.BOXED | CodeGenSnippet.FINAL | CodeGenSnippet.LOCAL | CodeGenSnippet.NON_NULL | CodeGenSnippet.THROWN);
		final StringBuilder partArgs = new StringBuilder();
		List<CollectionLiteralPart> parts = element.getPart();
		boolean isRange = false;
		for (CollectionLiteralPart part : parts) {
			CodeGenSnippet partSnippet = context.getSnippet(DomainUtil.nonNullModel(part));
			snippet.addDependsOn(partSnippet);
			partArgs.append(", ");
			if (part instanceof CollectionRange) {
				isRange = true;
//				if (!IntegerRange.class.isAssignableFrom(partSnippet.getJavaClass())) {
//					partArgs.append(integerRangeCast);
//				}
			} 
			String name = partSnippet.getName();
			if ("null".equals(name) && (parts.size() == 1)) {
				partArgs.append("(Object)");
			}
			partArgs.append(name);
		}
//		String collectionName = snippet.getName();
		final String collectionTypeIdName = snippet.getSnippetName(collectionType.getTypeId());
//		if (collectionType.isOrdered() && (parts.size() == 1) && (parts.get(0) instanceof CollectionRange)) {
//			String createCollectionName = "create" + element.getKind() + "Range";
//			CollectionRange range = (CollectionRange) parts.get(0);
//			context.append("final " + atNonNull() + " Object " + collectionName + " = " + createCollectionName + "(" + collectionTypeIdName);
//			context.append(", createRange(" + firstName + ", " + lastName + "));");
//		}
//		else {	// FIXME folding
		final String createCollectionName = "create" + element.getKind() + (isRange ? "Range" : "Value");
		return snippet.appendText("", new AbstractTextAppender()
		{			
			public void appendToBody(@NonNull CodeGenText text) {
				text.append(createCollectionName + "(" + collectionTypeIdName + partArgs + ")");
			}
		});
	}

	@Override
	public @NonNull CodeGenSnippet visitCollectionRange(final @NonNull CollectionRange element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		CodeGenSnippet snippet = new JavaSnippet("", analysis, IntegerRange.class, CodeGenSnippet.BOXED | CodeGenSnippet.FINAL | CodeGenSnippet.LOCAL | CodeGenSnippet.NON_NULL | CodeGenSnippet.THROWN);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			public void appendToBody(@NonNull CodeGenText text) {
				text.append("createRange(");
				text.appendBoxedReferenceTo(IntegerValue.class, DomainUtil.nonNullModel(element.getFirst()));
				text.append(", ");
				text.appendBoxedReferenceTo(IntegerValue.class, DomainUtil.nonNullModel(element.getLast()));
				text.append(")");
			}
		});
	}

	@Override
	public @NonNull CodeGenSnippet visitConstructorExp(@NonNull ConstructorExp element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		if (analysis.isConstant()) {
			return context.getSnippet(analysis.getConstantValue());
		}
		final Type type = DomainUtil.nonNullModel(element.getType());
		Class<?> resultClass = EObject.class; //context.getBoxedClass(element.getTypeId());
		int flags = CodeGenSnippet.LOCAL | CodeGenSnippet.UNBOXED;
		if (/*isValidating*/ analysis.isCatching()) {
			flags |= CodeGenSnippet.CAUGHT;
		}
		else { //if (/*isValidating*/ analysis.isThrowing()) {
			flags |= CodeGenSnippet.FINAL | CodeGenSnippet.THROWN;
		}
//		else {
//			flags |= CodeGenSnippet.FINAL;
//		}
		CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, flags);
		snippet = snippet.appendText("", new AbstractTextAppender()
		{			
			public void appendToBody(@NonNull CodeGenText text) {
				text.append("(");
				text.appendClassReference(EObject.class);
				text.append(")");
//				text.appendClassReference(ObjectValue.class);
//				text.append(")");
				text.appendReferenceTo(type);
				text.append(".createInstance()");
			}
		});
		context.setSnippet(element, snippet);
		List<ConstructorPart> parts = element.getPart();
		for (ConstructorPart part : parts) {
			CodeGenSnippet partSnippet = part.accept(this);
			assert partSnippet != null;
			snippet.appendContentsOf(partSnippet);
		}
		return snippet;
	}
	
	@Override
	public @Nullable CodeGenSnippet visitConstructorPart(@NonNull ConstructorPart element) {
		final OCLExpression initExpression = DomainUtil.nonNullModel(element.getInitExpression());
		final Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		ConstructorExp eContainer = (ConstructorExp)element.eContainer();
		final CodeGenSnippet instanceSnippet = context.getSnippet(eContainer);
		Class<?> resultClass = Object.class; //context.getBoxedClass(element.getTypeId());
		CodeGenSnippet snippet = new JavaSnippet("", context, TypeId.OCL_INVALID, resultClass, element, CodeGenSnippet.FINAL | CodeGenSnippet.LOCAL | CodeGenSnippet.THROWN | CodeGenSnippet.UNASSIGNED | CodeGenSnippet.UNBOXED);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendReferenceTo(referredProperty);
				text.append(".initValue(");
		//		text.appendReferenceTo(instanceSnippet);
				text.append(instanceSnippet.getName());
				text.append(", ");
				text.appendUnboxedReferenceTo(Object.class, initExpression);
				text.append(")");
			}
		});
	}
	@Override
	public @Nullable CodeGenSnippet visitEnumLiteralExp(@NonNull EnumLiteralExp element) {
		return context.getSnippet(ValuesUtil.createEnumerationLiteralValue(DomainUtil.nonNullModel(element.getReferredEnumLiteral())));
	}

	@Override
	public @NonNull CodeGenSnippet visitExpressionInOCL(@NonNull ExpressionInOCL element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		Class<?> resultClass = context.getBoxedClass(element.getTypeId());
		@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, CodeGenSnippet.BOXED | CodeGenSnippet.LOCAL | CodeGenSnippet.THROWN);
		OCLExpression bodyExpression = DomainUtil.nonNullModel(element.getBodyExpression());
		CodeGenAnalysis bodyAnalysis = context.getAnalysis(bodyExpression);
		CodeGenSnippet bodySnippet = context.getSnippet(bodyExpression);
		if (bodyAnalysis.isInvalid()) {
			CodeGenText throwText = snippet.append("throw ");
			throwText.appendReferenceTo(Exception.class, bodySnippet.getUnboxedSnippet(), false);
			throwText.append(";\n");
		}
		else if (bodyAnalysis.isConstant()) {
			CodeGenText text = snippet.appendIndentedText("");
			text.append("return ");
			text.appendBoxedReferenceTo(Object.class, bodyExpression);
			text.append(";\n");
		}
		else {
			CodeGenSnippet bodyNodes = snippet.appendIndentedNodes("", 0);
			bodyNodes.appendContentsOf(bodySnippet);
			// boxing and throwing gets inserted here between child snippets
			CodeGenSnippet returnNodes = snippet.appendIndentedNodes("", 0);
			if (analysis.isRequired() && !bodySnippet.isNonNull()) {
				CodeGenText throwText = returnNodes.append("if (");
				throwText.appendBoxedReferenceTo(Object.class, bodyExpression);
				throwText.append(" == null) throw new ");
				throwText.appendClassReference(InvalidValueException.class);
				throwText.append("(\"null return\");\n");
			}
			CodeGenText text = returnNodes.appendIndentedText("");
			text.append("return ");
			text.appendBoxedReferenceTo(resultClass, bodyExpression);
			text.append(";\n");
		}
		return snippet;
	}

	@Override
	public @NonNull CodeGenSnippet visitIfExp(@NonNull IfExp element) {
		OCLExpression thenExpression = DomainUtil.nonNullModel(element.getThenExpression());
		OCLExpression elseExpression = DomainUtil.nonNullModel(element.getElseExpression());
		CodeGenLabel scopeLabel = context.getSnippetLabel(CodeGenerator.SCOPE_ROOT);
		CodeGenAnalysis analysis = context.getAnalysis(element);
		Class<?> thenClass = context.getBoxedClass(thenExpression.getTypeId());
		Class<?> elseClass = context.getBoxedClass(elseExpression.getTypeId());
		Class<?> resultClass = getCommonClass(thenClass, elseClass);
		int flags = CodeGenSnippet.BOXED | CodeGenSnippet.ERASED | CodeGenSnippet.LOCAL;
		if (context.getAnalysis(thenExpression).isNonNull() && context.getAnalysis(elseExpression).isNonNull()) {
			flags |= CodeGenSnippet.NON_NULL;
		}
		if (/*isValidating*/ analysis.isCatching()) {
			flags |= CodeGenSnippet.CAUGHT;
		}
		else {
			flags |= CodeGenSnippet.THROWN;
		}
		@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, flags);
		//
		CodeGenText var = snippet.appendIndentedText("");
		var.appendDeclaration(snippet);
		var.close();
		//
		CodeGenText head = snippet.append("if (");
		head.appendReferenceTo(Boolean.class, DomainUtil.nonNullModel(element.getCondition()));
		head.append(" == TRUE_VALUE) {\n");
			//
			CodeGenSnippet thenNodes = snippet.appendIndentedNodes(null, 0);
			scopeLabel.push(thenNodes);
			CodeGenText thenText = thenNodes.append(snippet.getName());
			thenText.append(" = ");
			CodeGenSnippet thenSnippet = thenText.appendBoxedReferenceTo(resultClass, thenExpression);
			if (thenSnippet.isLocal()) {
				thenSnippet.addDependsOn(thenNodes);
			}
			thenText.close();
			scopeLabel.pop();
			//
		CodeGenText elseIfText = snippet.append("}\n");
		elseIfText.append("else if (");
		elseIfText.appendReferenceTo(Boolean.class, DomainUtil.nonNullModel(element.getCondition()));
		elseIfText.append(" == FALSE_VALUE) {\n");
			//
			CodeGenSnippet elseNodes = snippet.appendIndentedNodes(null, 0);
			scopeLabel.push(elseNodes);
			CodeGenText elseText = elseNodes.append(snippet.getName());
			elseText.append(" = ");
			CodeGenSnippet elseSnippet = elseText.appendBoxedReferenceTo(resultClass, elseExpression);
			if (elseSnippet.isLocal()) {
				elseSnippet.addDependsOn(elseNodes);
			}
			elseText.close();
			scopeLabel.pop();
			//
		CodeGenText nullText = snippet.append("}\n");
		nullText.append("else {\n");
			//
			CodeGenSnippet throwNodes = snippet.appendIndentedNodes(null, 0);
			throwNodes.append("throw INVALID_VALUE;\n");
			//
		snippet.append("}\n");
		return snippet;
	}

	@Override
	public @NonNull CodeGenSnippet visitIntegerLiteralExp(@NonNull IntegerLiteralExp element) {
		return context.getSnippet(element.getIntegerSymbol());
	}

	@Override
	public @NonNull CodeGenSnippet visitInvalidLiteralExp(@NonNull InvalidLiteralExp element) {
		return context.getSnippet(ValuesUtil.INVALID_VALUE);
	}

	@Override
	public @NonNull CodeGenSnippet visitIterateExp(final @NonNull IterateExp element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		Class<?> resultClass = Object.class; //context.getBoxedClass(element.getTypeId());
		Iteration referredIteration = DomainUtil.nonNullModel(element.getReferredIteration());
		int flags = CodeGenSnippet.BOXED | CodeGenSnippet.LOCAL;
		if (referredIteration.isRequired()) {
			flags |= CodeGenSnippet.NON_NULL;// | CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
		}
		if (/*isValidating*/ analysis.isCatching()) {
			flags |= CodeGenSnippet.CAUGHT;
		}
		else {
			flags |= CodeGenSnippet.FINAL | CodeGenSnippet.THROWN;
		}
		@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, flags);
		final OCLExpression source = DomainUtil.nonNullModel(element.getSource());
		final OCLExpression bodyExpression = DomainUtil.nonNullModel(element.getBody());
		final List<Variable> iterators = element.getIterator();
		final int arity = iterators.size();
		final String operationTypeName = snippet.getImportedName(genModelHelper.getAbstractOperationClass(iterators));
		final String iterationTypeName = snippet.getImportedName(LibraryIteration.class);
		String astName = snippet.getName();
//		String sourceName = getBoxedSymbolName(source);
		final String typeId = snippet.getSnippetName(element.getTypeId());
		final String referredIterationName = genModelHelper.getQualifiedLiteralName(snippet, referredIteration);
		final String managerTypeName = snippet.getImportedName(ExecutorSingleIterationManager.class);
		final String typeIdName = snippet.getImportedName(TypeId.class);
		final String atNonNull = snippet.atNonNull();
		final String atNullable = snippet.atNullable();
		final String staticTypeName = "TYPE_" + astName;
		final String implementationName = "IMPL_" + astName;
		final String managerName = "MGR_" + astName;
		final String bodyName = "BODY_" + astName;
		final CodeGenLabel localLabel = context.getSnippetLabel(CodeGenerator.LOCAL_ROOT);
		final CodeGenLabel scopeLabel = context.getSnippetLabel(CodeGenerator.SCOPE_ROOT);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendAtHead(@NonNull CodeGenSnippet snippet) {
				CodeGenText head = snippet.appendIndentedText("");
				head.append("/**\n"); 
				head.append(" * Implementation of the iterate body.\n");
				head.append(" */\n");
				head.append("final " + snippet.atNonNull() + " " + operationTypeName + " " + bodyName + " = new " + operationTypeName + "()\n");
				head.append("{\n");
				CodeGenSnippet evaluateBody = snippet.appendIndentedNodes(null, 0);
					CodeGenText text = evaluateBody.appendIndentedText("");
					text.appendCommentWithOCL(null, bodyExpression);
//					text.append("@Override\n");
					text.append("public " + atNullable + " Object evaluate(");
					text.appendDeclaration(context.getEvaluatorSnippet());
					text.append(", final " + atNonNull + " " + typeIdName + " returnTypeId");
					CodeGenSnippet evaluateNodes = evaluateBody.appendIndentedNodes(null, 0);
					localLabel.push(evaluateNodes);
					scopeLabel.push(evaluateNodes);
					text.append(", final " + atNullable + " Object ");
					Variable result = element.getResult();
					CodeGenSnippet resultSnippet = evaluateNodes.getSnippet(result);
					text.append(resultSnippet.getName());
					for (int i = 0; i < arity; i++) {
						text.append(", ");
						text.appendDeclaration(evaluateNodes.getSnippet(iterators.get(i)));
					}
					text.append(") throws Exception {\n");
					//
						CodeGenSnippet iteratorBody = evaluateBody.appendIndentedNodes(null, 0);
						CodeGenText returnText = iteratorBody.append("return ");
						returnText.appendBoxedReferenceTo(Object.class, bodyExpression);
						returnText.append(";\n");
					evaluateBody.append("}\n");
					localLabel.pop();
					scopeLabel.pop();
				snippet.append("};\n");
				//
				CodeGenText tail = snippet.appendIndentedText("");
				tail.appendClassReference(DomainType.class);
				tail.append(" " + staticTypeName + " = ");
				tail.appendEvaluatorReference();
				tail.append(".getStaticTypeOf(");
				tail.appendBoxedReferenceTo(Object.class, source);
				tail.append(");\n");
				tail.append(iterationTypeName + " " + implementationName + " = ");
				tail.append("(" + iterationTypeName + ")" + staticTypeName + ".lookupImplementation(");
				tail.appendReferenceTo(context.getStandardLibrary(snippet));
				tail.append(", " + referredIterationName + ");\n");
				//
				tail.append(managerTypeName + " " + managerName + " = new " + managerTypeName + "(");
				tail.appendEvaluatorReference();
				tail.append(", " + typeId + ", " + bodyName + ", ");
				tail.appendBoxedReferenceTo(CollectionValue.class, source);
				tail.append(", " + resultSnippet.getName() + ");\n");
			}

			public void appendToBody(@NonNull CodeGenText text) {
				text.append(implementationName + ".evaluateIteration(" + managerName + ")");
			}
		});
	}

	@Override
	public @NonNull CodeGenSnippet visitIteratorExp(@NonNull IteratorExp element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		Iteration referredIteration = DomainUtil.nonNullModel(element.getReferredIteration());
		Class<?> resultClass = Object.class; //context.getBoxedClass(element.getTypeId());
		int flags = CodeGenSnippet.BOXED | CodeGenSnippet.LOCAL;
		if (referredIteration.isRequired()) {
//			flags |= CodeGenSnippet.NON_NULL;// | CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
		}
		if (/*isValidating*/ analysis.isCatching()) {
			flags |= CodeGenSnippet.CAUGHT;
		}
		else {
			flags |= CodeGenSnippet.FINAL | CodeGenSnippet.THROWN;
		}
		@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, flags);
		final OCLExpression source = DomainUtil.nonNullModel(element.getSource());
		final OCLExpression bodyExpression = element.getBody();
		final List<Variable> iterators = element.getIterator();
		final int arity = iterators.size();
		final String operationTypeName = snippet.getImportedName(genModelHelper.getAbstractOperationClass(iterators));
		final String iterationTypeName = snippet.getImportedName(LibraryIteration.class);
		String astName = snippet.getName();
//		String sourceName = getBoxedSymbolName(source);
		final String typeId = snippet.getSnippetName(element.getTypeId());
		final String bodyType = snippet.getSnippetName(bodyExpression.getTypeId());
		final String referredIterationName = genModelHelper.getQualifiedLiteralName(snippet, referredIteration);
		final String managerTypeName = snippet.getImportedName(arity == 1 ? ExecutorSingleIterationManager.class : ExecutorDoubleIterationManager.class); 	// FIXME ExecutorMultipleIterationManager
		final String typeIdName = snippet.getImportedName(TypeId.class);
		final String atNonNull = snippet.atNonNull();
		final String atNullable = snippet.atNullable();
		final String staticTypeName = "TYPE_" + astName;
		final String accumulatorName = "ACC_" + astName;
		final String implementationName = "IMPL_" + astName;
		final String managerName = "MGR_" + astName;
		final String bodyName = "BODY_" + astName;
		final CodeGenLabel localLabel = context.getSnippetLabel(CodeGenerator.LOCAL_ROOT);
		final CodeGenLabel scopeLabel = context.getSnippetLabel(CodeGenerator.SCOPE_ROOT);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendAtHead(@NonNull CodeGenSnippet snippet) {
				CodeGenText head = snippet.appendIndentedText("");
				head.append("/**\n"); 
				head.append(" * Implementation of the iterator body.\n");
				head.append(" */\n");
				head.append("final " + atNonNull + " " + operationTypeName + " " + bodyName + " = new " + operationTypeName + "()\n");
				head.append("{\n");
				//
				CodeGenSnippet evaluateBody = snippet.appendIndentedNodes(null, 0);
					CodeGenText text = evaluateBody.appendIndentedText("");
					text.appendCommentWithOCL(null, bodyExpression);
//					text.append("@Override\n");
					text.append("public " + atNullable + " Object evaluate(");
					text.appendDeclaration(context.getEvaluatorSnippet());
					text.append(", final "  + atNonNull +  " " + typeIdName + " returnTypeId, " +
						atNullable + " final Object sourceValue");
					CodeGenSnippet evaluateNodes = evaluateBody.appendIndentedNodes(null, 0);
					localLabel.push(evaluateNodes);
					scopeLabel.push(evaluateNodes);
					for (int i = 0; i < arity; i++) {
						text.append(", ");
						CodeGenSnippet iteratorSnippet = evaluateNodes.getSnippet(iterators.get(i));
						text.appendDeclaration(iteratorSnippet);
						iteratorSnippet.addDependsOn(evaluateNodes);		// FIXME IterateExp too, automate??
					}
					text.append(") throws Exception {\n");
					//
						CodeGenSnippet iteratorBody = evaluateBody.appendIndentedNodes(null, 0);
						CodeGenText returnText = iteratorBody.append("return ");
						returnText.appendBoxedReferenceTo(Object.class, bodyExpression);
						returnText.append(";\n");
					evaluateBody.append("}\n");
					localLabel.pop();
					scopeLabel.pop();
				snippet.append("};\n");

				CodeGenSnippet sourceSnippet = context.getSnippet(source);
				snippet.appendInvalidGuard(sourceSnippet);

				CodeGenText tail = snippet.appendIndentedText("");
				tail.appendClassReference(DomainType.class);
				tail.append(" " + staticTypeName + " = ");
				tail.appendEvaluatorReference();
				tail.append(".getStaticTypeOf(");
				tail.appendBoxedReferenceTo(Object.class, source);
				tail.append(");\n");
				//
				tail.append(iterationTypeName + " " + implementationName + " = (" + iterationTypeName + ")" + staticTypeName + ".lookupImplementation("); 
				tail.appendReferenceTo(context.getStandardLibrary(snippet));
				tail.append(", " + referredIterationName + ");\n");
				//
				tail.append("Object " + accumulatorName + " = " + implementationName + ".createAccumulatorValue(");
				tail.appendEvaluatorReference();
				tail.append(", " + typeId + ", " + bodyType + ");\n");
				//
				tail.append(managerTypeName + " " + managerName + " = new " + managerTypeName + "(");
				tail.appendEvaluatorReference();
				tail.append(", " + typeId + ", " + bodyName + ", ");
				tail.appendBoxedReferenceTo(CollectionValue.class, source);
				tail.append(", " + accumulatorName + ");\n");
			}

			public void appendToBody(@NonNull CodeGenText text) {
				text.append(implementationName + ".evaluateIteration(" + managerName + ")");
			}
		});
	}

	@Override
	public @NonNull CodeGenSnippet visitLetExp(@NonNull LetExp element) {
		OCLExpression inExpression = DomainUtil.nonNullModel(element.getIn());
		CodeGenSnippet inSnippet = context.getSnippet(inExpression);
		return inSnippet;
	}

	@Override
	public @NonNull CodeGenSnippet visitNullLiteralExp(@NonNull NullLiteralExp element) {
		return context.getSnippet(null);
	}

	@Override
	public @NonNull CodeGenSnippet visitOperationCallExp(@NonNull OperationCallExp element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		TypeId returnTypeId = element.getTypeId();
		Class<?> knownResultClass = context.getBoxedClass(returnTypeId);
		Operation referredOperation = DomainUtil.nonNullModel(element.getReferredOperation());
		boolean isInvalidating = referredOperation.isInvalidating();
		final boolean isValidating = referredOperation.isValidating();
		final Class<?> computedResultClass = isInvalidating ? Object.class : context.getBoxedClass(referredOperation.getTypeId());
		int flags = CodeGenSnippet.BOXED | CodeGenSnippet.LOCAL;
		if (!knownResultClass.isAssignableFrom(computedResultClass)) {		// e.g return is a templated type that is statically known
			flags |= CodeGenSnippet.ERASED;
		}
		if (referredOperation.isRequired()) {
			flags |= CodeGenSnippet.NON_NULL;// | CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
		}
		if (/*isValidating*/ analysis.isCatching()) {
			flags |= CodeGenSnippet.CAUGHT;
		}
		else {
			flags |= CodeGenSnippet.FINAL | CodeGenSnippet.THROWN;
		}
		final @NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, computedResultClass, flags);
		final OCLExpression source = element.getSource();
		final List<OCLExpression> arguments = DomainUtil.nonNullEMF(element.getArgument());
		//
		//	Assign each source and argument to a Java variable, unless the source/argument is simple enough to be inlineable.
		//
		//
		//	Call the operation with the appropriate arguments.
		//
		context.addDependency(CodeGenerator.LOCAL_ROOT, snippet);
		String resultSymbolName = snippet.getName();
		String typeIdName;
		if (returnTypeId instanceof TemplateParameterId) {
			typeIdName = snippet.getSnippetName(TypeId.OCL_ANY);
		}
		else {
			typeIdName = snippet.getSnippetName(returnTypeId);
		}
		DomainOperation finalOperation;
		if (source == null) {
			finalOperation = referredOperation;
		}
		else {
			Type sourceType = DomainUtil.nonNullModel(source.getType());
			finalOperation = context.isFinal(referredOperation, sourceType);
		}
		if (finalOperation instanceof Operation) {
			LibraryFeature libraryFeature = ((Operation)finalOperation).getImplementation();
			final Class<?> returnClass = getReturnClass(libraryFeature, arguments.size());
			final String className = getImplementationName(snippet, (Operation)finalOperation);
			final String finalTypeIdName = typeIdName;
			return snippet.appendText("", new AbstractTextAppender()
			{			
				@Override
				public void appendAtHead(@NonNull CodeGenSnippet snippet) {
					if (!isValidating) {
						if (source != null) {
							CodeGenSnippet sourceSnippet = context.getSnippet(source, isValidating, true);
							snippet.appendInvalidGuard(sourceSnippet);
						}
						for (/*@NonNull*/ OCLExpression argument : arguments) {
							if (argument != null) {
								CodeGenSnippet argumentSnippet = context.getSnippet(argument, isValidating, true);
								snippet.appendInvalidGuard(argumentSnippet);
							}
						}
					}
				}

				public void appendToBody(@NonNull CodeGenText text) {
					text.appendResultCast(returnClass, computedResultClass, className);
					text.append(className + ".evaluate(");
					text.appendEvaluatorReference();
					text.append(", " + finalTypeIdName + ", ");
					if (source == null) {
						text.append("null");
					}
					else {
						CodeGenSnippet sourceSnippet = context.getSnippet(source, isValidating, true);
						text.appendReferenceTo(Object.class, sourceSnippet);
					}
					for (/*@NonNull*/ OCLExpression argument : arguments) {
						if (argument != null) {
							text.append(", ");
							CodeGenSnippet argumentSnippet = context.getSnippet(argument, isValidating, true);
							text.appendReferenceTo(Object.class, argumentSnippet);
						}
					}
					text.append(")");
				}
			});
		}
		else {
			CodeGenText text = snippet.appendIndentedText("");
			String operationTypeName = snippet.getImportedName(genModelHelper.getOperationInterface(arguments));
			String operationName = genModelHelper.getQualifiedLiteralName(snippet, referredOperation); //context.getConstantName(referredOperation);
			String staticImplementationName = nameManager.reserveName("static_" + referredOperation.getName(), null);
			String dynamicImplementationName;
			if (source != null) {
				dynamicImplementationName = nameManager.reserveName("dynamic_" + referredOperation.getName(), null);
				text.append("final " + snippet.getImportedName(DomainType.class) + " " + staticImplementationName + " = ");
				text.appendEvaluatorReference();
				text.append(".getStaticTypeOf(");
				CodeGenSnippet sourceSnippet = context.getSnippet(source, isValidating, true);
				text.appendReferenceTo(Object.class, sourceSnippet, false);
				for (OCLExpression argument : arguments) {
					assert argument != null;
					text.append(", ");
					String referredSymbolName = context.getSnippet(argument).getName();
					if ((arguments.size() == 1) && "null".equals(referredSymbolName)) {
						text.append("(Object)");
					}
					CodeGenSnippet argumentSnippet = context.getSnippet(argument, isValidating, true);
					text.appendReferenceTo(Object.class, argumentSnippet, false);
				}
				text.append(");\n");
			}
			else {
				dynamicImplementationName = staticImplementationName;
			}
			//
			text.append("final " + operationTypeName + " " + dynamicImplementationName + " = (" + operationTypeName + ")" + staticImplementationName + ".lookupImplementation(");
			text.appendReferenceTo(context.getStandardLibrary(snippet));
			text.append(", " + operationName + ");\n");
			//
			text.append("final Object " + resultSymbolName + " = " + dynamicImplementationName + ".evaluate(");
			text.appendEvaluatorReference();
			text.append(", " + typeIdName + ", ");
			if (source != null) {
				CodeGenSnippet sourceSnippet = context.getSnippet(source, isValidating, true);
				text.appendReferenceTo(Object.class, sourceSnippet, false);
			}
			else {
				text.append("null");
			}
			for (OCLExpression argument : arguments) {
				assert argument != null;
				text.append(", ");
				CodeGenSnippet argumentSnippet = context.getSnippet(argument, isValidating, true);
				text.appendReferenceTo(Object.class, argumentSnippet, false);
			}
			text.append(")");
			text.close();
			return snippet;
		}
	}

	@Override
	public @Nullable CodeGenSnippet visitProperty(final @NonNull Property element) {
		int flags = CodeGenSnippet.BOXED | CodeGenSnippet.ERASED | CodeGenSnippet.FINAL | CodeGenSnippet.LOCAL | CodeGenSnippet.NON_NULL | CodeGenSnippet.UNBOXED;
		CodeGenSnippet snippet = new JavaSnippet("", context, element.getTypeId(), DomainProperty.class, element, flags);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendReferenceTo(context.getIdResolver());
				text.append(".getProperty(");
				text.appendReferenceTo(element.getPropertyId());
				text.append(")");
			}
		});
	}

	@Override
	public @NonNull CodeGenSnippet visitPropertyCallExp(@NonNull PropertyCallExp element) {
		Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		try {
			LibraryFeature implementation = context.getMetaModelManager().getImplementation(referredProperty);
			@SuppressWarnings("null")@NonNull Class<? extends LibraryFeature> implementationClass = implementation.getClass();
			Inliner inliner = context.getInliner(implementationClass);
			if (inliner instanceof PropertyInliner) {
				return ((PropertyInliner)inliner).visitPropertyCallExp(element);
			}
		} catch (Exception e) {
		}
		CodeGenAnalysis analysis = context.getAnalysis(element);
		final OCLExpression source = element.getSource();
		if ((source == null) || referredProperty.isStatic()) {
			return visitStaticPropertyCallExp(element);
		}
		Type sourceType = source.getType();
		if (sourceType instanceof TupleType) {
			return visitTuplePartCallExp(element);
		}
		Type returnType = DomainUtil.nonNullModel(referredProperty.getType());
		try {
			final String getAccessor = genModelHelper.getGetAccessor(referredProperty);
			Type owningType = DomainUtil.nonNullModel(referredProperty.getOwningType());
			final Class<?> requiredClass = genModelHelper.getEcoreInterfaceClass(owningType);
			final Class<?> leastDerivedClass = getLeastDerivedClass(requiredClass, getAccessor);
			Method leastDerivedMethod = getLeastDerivedMethod(requiredClass, getAccessor);
			Class<?> returnClass = leastDerivedMethod != null ? leastDerivedMethod.getReturnType() : genModelHelper.getEcoreInterfaceClass(returnType);
			int flags = CodeGenSnippet.ERASED | CodeGenSnippet.FINAL | CodeGenSnippet.LOCAL | CodeGenSnippet.THROWN | CodeGenSnippet.UNBOXED;
			if (EObject.class.isAssignableFrom(requiredClass) && !(returnType instanceof DataType)) {	// FIXME Generalize ?? PrimitiveTypes half and half
				flags |= CodeGenSnippet.BOXED;
			}
			if (Iterable.class.isAssignableFrom(returnClass)) {
				flags |= CodeGenSnippet.NON_NULL;
				if (context.getOptions().suppressNonNullWarningsForEMFCollections()) {
					flags |= CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
				}
			}
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, returnClass !=  null ? returnClass : Object.class, flags);
			return snippet.appendText("", new AbstractTextAppender()
			{			
				public void appendToBody(@NonNull CodeGenText text) {
					CodeGenSnippet sourceSnippet = context.getSnippet(source, false, false).getNonNullSnippet();
					text.appendReferenceTo(leastDerivedClass != null ? leastDerivedClass : requiredClass, sourceSnippet, true);
					text.append(".");
					text.append(getAccessor);
					text.append("()");
				}
			});
		} catch (GenModelException e) {
			return visitDynamicPropertyCallExp(element);
		}
	}
	protected @NonNull CodeGenSnippet visitDynamicPropertyCallExp(@NonNull PropertyCallExp element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		try {
			LibraryFeature implementation = context.getMetaModelManager().getImplementation(referredProperty);
			Class<?> knownResultClass = context.getBoxedClass(element.getTypeId());
			final Class<?> computedResultClass = context.getBoxedClass(referredProperty.getTypeId());
			int flags = CodeGenSnippet.BOXED | CodeGenSnippet.LOCAL | CodeGenSnippet.FINAL | CodeGenSnippet.THROWN;
			if (!knownResultClass.isAssignableFrom(computedResultClass)) {		// e.g return is a templated type that is statically known
				flags |= CodeGenSnippet.ERASED;
			}
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, computedResultClass, flags);
			final OCLExpression source = element.getSource();
			@SuppressWarnings("null") @NonNull Class<?> implementationClass = implementation.getClass();
			final String className = snippet.getImportedName(implementationClass) + ".INSTANCE";
			final Class<?> returnClass = getReturnClass(referredProperty);
			CodeGenSnippet typeIdSnippet = snippet.getSnippet(element.getTypeId());
			snippet.addDependsOn(typeIdSnippet);
			final String typeIdName = typeIdSnippet.getName();
			return snippet.appendText("", new AbstractTextAppender()
			{			
				public void appendToBody(@NonNull CodeGenText text) {
					text.appendResultCast(returnClass, computedResultClass, className);
					text.append(className + ".evaluate(");
					text.appendEvaluatorReference();
					text.append(", " + typeIdName + ", ");
					if (source != null) {
						text.appendBoxedReferenceTo(Object.class, source);
					}
					else {
						text.append("null");
					}
					text.append(")");
				}
			});
		} catch (Exception e) {
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, Object.class, CodeGenSnippet.FINAL | CodeGenSnippet.LOCAL | CodeGenSnippet.UNBOXED);
			snippet.appendException(e);		
			return snippet;
		}
	}

	protected @NonNull CodeGenSnippet visitStaticPropertyCallExp(@NonNull PropertyCallExp element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		final Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		Class<?> knownResultClass = context.getBoxedClass(element.getTypeId());
		final Class<?> computedResultClass = context.getBoxedClass(referredProperty.getTypeId());
		int flags = CodeGenSnippet.BOXED | CodeGenSnippet.LOCAL | CodeGenSnippet.FINAL | CodeGenSnippet.THROWN;
		if (!knownResultClass.isAssignableFrom(computedResultClass)) {		// e.g return is a templated type that is statically known
			flags |= CodeGenSnippet.ERASED;
		}
		final @NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, computedResultClass, flags);
		final OCLExpression source = element.getSource();
		final String implementationClassName = referredProperty.getImplementationClass();
		final Class<?> returnClass = getReturnClass(referredProperty);
		CodeGenSnippet typeIdSnippet = snippet.getSnippet(element.getTypeId());
		snippet.addDependsOn(typeIdSnippet);
		final String typeIdName = typeIdSnippet.getName();
		return snippet.appendText("", new AbstractTextAppender()
		{			
			public void appendToBody(@NonNull CodeGenText text) {
				String className;
				if (implementationClassName != null) {
					className = snippet.getImportedName(implementationClassName) + ".INSTANCE";
				}
				else {
					className = genModelHelper.getQualifiedLiteralName(snippet, referredProperty);
				}
				text.appendResultCast(returnClass, computedResultClass, className);
				text.append(className + ".evaluate(");
				text.appendEvaluatorReference();
				text.append(", " + typeIdName + ", ");
				if (source != null) {
					text.appendBoxedReferenceTo(Object.class, source);
				}
				else {
					text.append("null");
				}
				text.append(")");
			}
		});
	}

	@Override
	public @NonNull CodeGenSnippet visitRealLiteralExp(@NonNull RealLiteralExp element) {
		return context.getSnippet(element.getRealSymbol());
	}

	@Override
	public @NonNull CodeGenSnippet visitStringLiteralExp(@NonNull StringLiteralExp element) {
		return context.getSnippet(element.getStringSymbol());
	}

	@Override
	public @NonNull CodeGenSnippet visitTupleLiteralExp(@NonNull TupleLiteralExp element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		if (analysis.isConstant()) {
			return context.getSnippet(analysis.getConstantValue());
		}
		Class<?> resultClass = context.getBoxedClass(element.getTypeId());
		int flags = CodeGenSnippet.BOXED | CodeGenSnippet.LOCAL | CodeGenSnippet.NON_NULL;
		if (/*isValidating*/ analysis.isCatching()) {
			flags |= CodeGenSnippet.CAUGHT;
		}
		else {
			flags |= CodeGenSnippet.FINAL | CodeGenSnippet.THROWN;
		}
		@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, flags);
		TupleType tupleType = (TupleType) element.getType();
		final StringBuilder partArgs = new StringBuilder();
		List<TupleLiteralPart> parts = element.getPart();
		for (TupleLiteralPart part : parts) {
			CodeGenSnippet partSnippet = context.getSnippet(DomainUtil.nonNullModel(part.getInitExpression()));
			snippet.addDependsOn(partSnippet);
			partArgs.append(", ");
			String name = partSnippet.getName();
//			if ("null".equals(name) && (parts.size() == 1)) {
//				partArgs.append("(Object)");
//			}
			partArgs.append(name);
		}
		final String tupleTypeIdName = snippet.getSnippetName(tupleType.getTypeId());
		return snippet.appendText("", new AbstractTextAppender()
		{			
			public void appendToBody(@NonNull CodeGenText text) {
				text.append(" createTupleValue(" + tupleTypeIdName + partArgs + ")");
			}
		});
	}

	protected @NonNull CodeGenSnippet visitTuplePartCallExp(@NonNull PropertyCallExp element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		Class<?> resultClass = context.getBoxedClass(element.getTypeId());
		@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, CodeGenSnippet.FINAL | CodeGenSnippet.NON_NULL |CodeGenSnippet.THROWN | CodeGenSnippet.UNBOXED);
		Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		final OCLExpression source = DomainUtil.nonNullModel(element.getSource());
		String tuplePartName = referredProperty.getName();
		TupleType tupleType = (TupleType) source.getType();
		List<String> names = new ArrayList<String>(tupleType.getOwnedAttribute().size());
		for (Property tuplePart : tupleType.getOwnedAttribute()) {
			names.add(tuplePart.getName());
		}
		Collections.sort(names);										// FIXME maintain sorted list in TupleType
		final int tuplePartIndex = names.indexOf(tuplePartName);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			public void appendToBody(@NonNull CodeGenText text) {
				CodeGenSnippet sourceSnippet = context.getSnippet(source, false, false);
				text.appendReferenceTo(TupleValue.class, sourceSnippet, true);
				text.append(".getValue(" + tuplePartIndex + ")");
			}
		});
	}

	@Override
	public @Nullable CodeGenSnippet visitType(final @NonNull Type element) {
		int flags = CodeGenSnippet.BOXED | CodeGenSnippet.ERASED | CodeGenSnippet.FINAL | CodeGenSnippet.LOCAL | CodeGenSnippet.NON_NULL | CodeGenSnippet.UNBOXED;
		JavaSnippet snippet = new JavaSnippet("", context, element.getTypeId(), DomainType.class, element, flags);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			public void appendToBody(@NonNull CodeGenText text) {
				text.appendReferenceTo(context.getIdResolver());
				text.append(".getType(");
				text.appendReferenceTo(element.getTypeId());
				text.append(", null)");
			}
		});
	}
	
	@Override
	public @NonNull CodeGenSnippet visitTypeExp(@NonNull TypeExp element) {
		return context.getSnippet(element.getReferredType());
	}

	@Override
	public @NonNull CodeGenSnippet visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp element) {
		return context.getSnippet(element.getUnlimitedNaturalSymbol());
	}

	@Override
	public @NonNull CodeGenSnippet visitVariable(@NonNull Variable element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		EObject eContainer = element.eContainer();
		int flags = CodeGenSnippet.BOXED | CodeGenSnippet.ERASED | CodeGenSnippet.INLINE | CodeGenSnippet.LOCAL;
		if (/*isValidating*/ analysis.isCatching()) {
			flags |= CodeGenSnippet.CAUGHT | CodeGenSnippet.FINAL;
		}
		else {
			flags |= CodeGenSnippet.FINAL | CodeGenSnippet.THROWN;
		}
		if (eContainer instanceof LoopExp) {
			return new JavaSnippet("", analysis, Object.class, flags);
		}
		else if (eContainer instanceof ExpressionInOCL) {
//			if (element == ((ExpressionInOCL)eContainer).getContextVariable()) {
//				flags |= CodeGenSnippet.NON_NULL | CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
//			}
//			if ((element.getRepresentedParameter() != null) && element.getRepresentedParameter().isRequired()) {
//				flags |= CodeGenSnippet.NON_NULL | CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
//			}
			return new JavaSnippet("", analysis, Object.class, flags);
		}
		else {
			Class<?> resultClass = context.getBoxedClass(element.getTypeId());
			return new JavaSnippet("", analysis, resultClass, CodeGenSnippet.BOXED | CodeGenSnippet.CAUGHT);
		}
	}

	@Override
	public @NonNull CodeGenSnippet visitVariableExp(@NonNull VariableExp element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		CodeGenAnalysis delegatesTo = analysis.getDelegatesTo();
		if (delegatesTo != null) {
			return context.getSnippet(delegatesTo.getExpression());
		}
		Class<?> resultClass = context.getBoxedClass(element.getTypeId());
		JavaSnippet refSnippet = new JavaSnippet("", analysis, resultClass, CodeGenSnippet.BOXED | CodeGenSnippet.CAUGHT | CodeGenSnippet.FINAL | CodeGenSnippet.LOCAL);
		refSnippet.addDependsOn(context.getSnippet(((Variable)element.getReferredVariable()).getInitExpression()));
		return refSnippet;
	}

	public @NonNull CodeGenSnippet visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Statement: " + visitable.getClass().getName());
	}
}
