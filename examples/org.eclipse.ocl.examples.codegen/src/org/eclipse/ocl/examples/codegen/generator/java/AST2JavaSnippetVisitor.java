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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.CommonSubExpression;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.generator.CodeGenLabel;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
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
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.ReferringElement;
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
	protected final @NonNull NameManager nameManager;
	protected final @NonNull GenModelHelper genModelHelper;
	protected /*@LazyNonNull*/ String invalidValueName = null;
	
	public AST2JavaSnippetVisitor(@NonNull CodeGenerator codeGenerator) {
		super(codeGenerator);
		nameManager = codeGenerator.getNameManager();
		genModelHelper = codeGenerator.getGenModelHelper();
	}

	/**
	 * Emit a statement that assigns the value of anExpression to its designated symbol catching
	 * an exception thrown during computation of anExpression and assigning an InvalidValue to
	 * the symbol to preserve the caught exception.
	 */
	protected void appendCatchingStatement(@NonNull CodeGenSnippet snippet, @Nullable Variable aVariable, @NonNull OCLExpression anExpression) {
		CodeGenAnalysis analysis = context.getAnalysis(anExpression);
		if (analysis.isInlineable()) { /* Nothing to do */}
		else if (analysis.isConstant()) {}
		else {
			CodeGenSnippet nestedSnippet = context.getSnippet(anExpression);
			if (aVariable != null) {
				String symbolName = getSymbolName(aVariable);
				if (analysis.mayBeException()) {
					CodeGenText head = snippet.appendIndentedText("");
					head.append("Object " + symbolName + ";\n");
					head.append("try {\n");
					CodeGenSnippet tryNodes = snippet.appendIndentedNodes(null);
					tryNodes.appendContentsOf(nestedSnippet);
					CodeGenText catchText = snippet.append("}\n");
					catchText.append("catch (Exception e) {\n");
					CodeGenText catchBody = snippet.appendIndentedText("");
					catchBody.append(symbolName + " = new " + context.getImportedName(InvalidValueImpl.class) + "(e);\n");
					snippet.append("}\n");
				}
				else {
					snippet.addDependsOn(nestedSnippet);
				}
			}
			else {
				snippet.addDependsOn(nestedSnippet);
			}
		}
	}

	/**
	 * Emit a statement that assigns the value of anExpression to its designated symbol throwing
	 * an exception in the event that computation of anException results an InvalidValue.
	 */
	protected void appendThrowingStatement(@NonNull CodeGenSnippet snippet, @NonNull OCLExpression anExpression) {
		CodeGenAnalysis analysis = context.getAnalysis(anExpression);
		if (analysis.isInlineable()) { /* Nothing to do */
			if (analysis.getConstantValue() instanceof InvalidValue) {
				CodeGenText text = snippet.appendIndentedText("");
				text.append("throwInvalidValueException();\n");
			}
		}
		else if (analysis.isConstant()) {}
		else {
			CodeGenSnippet nestedSnippet = context.getSnippet(anExpression);
			String symbolName;
			if (anExpression instanceof VariableExp) {			// FIXME redundant ??
				symbolName = getSymbolName(((VariableExp)anExpression).getReferredVariable());
			}
			else {
//				String generatedComputation = expressionVisitor.visit(anExpression);
//				context.append("final Object " + symbolName + " = " + generatedComputation + ";\n");
				snippet.addDependsOn(nestedSnippet);
				symbolName = nestedSnippet.getName(); //getSymbolName(anExpression);
			}
			if (analysis.mayBeInvalidValue()) {
				appendThrowCheck(snippet, symbolName);
			}
		}
	}

	protected void appendThrowCheck(@NonNull CodeGenSnippet snippet, String symbolName) {
		String invalidValueName = getInvalidValueName();
		snippet.append("if (" + symbolName + " instanceof " + invalidValueName + ") throw ((" + invalidValueName + ")" + symbolName + ").getException();\n");
	}

	protected String atNonNull() {
		return context.atNonNull();
	}

	protected String atNullable() {
		return context.atNullable();
	}

	protected @NonNull String getBoxedSymbolName(@Nullable Object element, @Nullable String... nameHints) {
		if (element instanceof Element) {
			CodeGenAnalysis analysis = context.getAnalysis((Element) element);
			CommonSubExpression referredCommonSubExpression = analysis.getReferredCommonSubExpression();
			if (referredCommonSubExpression != null) {
				return referredCommonSubExpression.getSymbolName();
			}
		}
		if (element == null) {
			return "null";
		}
		CodeGenSnippet snippet = context.getSnippet(element);
		return snippet.getBoxedSnippet().getName();
	}

	public @NonNull String getCastSymbolName(@NonNull Class<TupleValue> javaClassName, @NonNull Object element) {
		return "(" + context.getImportedName(javaClassName) + ")" + getSymbolName(element);
	}

	@Deprecated
	protected @NonNull Element getConstant(@NonNull Element anElement) {
		if (anElement instanceof TypeExp) {
			return DomainUtil.nonNullModel(((TypeExp)anElement).getType());
		}
		else if (anElement instanceof ReferringElement) {
			return DomainUtil.nonNullModel(((ReferringElement)anElement).getReferredElement());
		}
		else {
			return anElement;
		}
	}

	protected String getImplementationName(@NonNull Operation anOperation) {
		String implementationClass = anOperation.getImplementationClass();
		if (implementationClass != null) {
			return context.getImportManager().getImportedName(implementationClass) + ".INSTANCE";
		}
		List<Constraint> constraints = anOperation.getOwnedRule();
		if (constraints.size() > 0) {			
			String stereotype = constraints.get(0).getStereotype();
			if (stereotype != null) {
				String implementationName = genModelHelper.getQualifiedOperationImplementationName(anOperation, stereotype);
				if (implementationName != null) {
					return implementationName;
				}
			}
		}	
		return "null";
	}

	protected @Nullable String getImplementationName(@NonNull Property aProperty) {
		String implementationClass = aProperty.getImplementationClass();
		if (implementationClass != null) {
			return context.getImportManager().getImportedName(implementationClass) + ".INSTANCE";
		}
		List<Constraint> constraints = aProperty.getOwnedRule();
		if (constraints.size() > 0) {			
			String stereotype = constraints.get(0).getStereotype();
			if (stereotype != null) {
				String implementationName = genModelHelper.getQualifiedPropertyImplementationName(aProperty, stereotype);
				if (implementationName != null) {
					return implementationName;
				}
			}
		}	
		return null;
	}
	
	protected @NonNull String getInvalidValueName() {
		String invalidValueName2 = invalidValueName;
		if (invalidValueName2 == null) {
			invalidValueName = invalidValueName2 = context.getImportedName(InvalidValue.class);
		}
		return invalidValueName2;
	}

	@SuppressWarnings("null")
	protected @NonNull Class<?> getReturnClass(@NonNull Class<?> boxedClass) {
		try {
			Method method = boxedClass.getDeclaredMethod("evaluate", DomainEvaluator.class, TypeId.class, Object.class);
			return method.getReturnType();
		} catch (Exception e) {
			return Object.class;
		}
	}

	protected @NonNull String getSymbolName(@Nullable Object element, @Nullable String... nameHints) {
		if (element instanceof Element) {
			CodeGenAnalysis analysis = context.getAnalysis((Element) element);
			CommonSubExpression referredCommonSubExpression = analysis.getReferredCommonSubExpression();
			if (referredCommonSubExpression != null) {
				return referredCommonSubExpression.getSymbolName();
			}
		}
		return element != null ? context.getSnippet(element).getName() : "null";
	}

/*	protected boolean isInlineable(@NonNull TypedElement element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		if (analysis.isInlineable()) {
			return true;
		}
		if (element instanceof VariableExp) {
			VariableDeclaration referredVariable = ((VariableExp)element).getReferredVariable();
			if (referredVariable instanceof Variable) {
				OCLExpression initExpression = ((Variable)referredVariable).getInitExpression();
				if (initExpression != null) {
					CodeGenAnalysis initAnalysis = context.getAnalysis(initExpression);
					if (initAnalysis.isInlineable()) {
						return true;
					}
				}
			}
		}
		return false;
	} */

	/**
	 * Return true if anExpression may be a null value.
	 * <p>
	 * This takes no account of invalid values even though they 'conform' to null.
	 *
	protected boolean mayBeNullValue(@Nullable OCLExpression anExpression) {
		if (anExpression == null) {
			return false;
		}
		CodeGenAnalysis analysis = context.getAnalysis(anExpression);
		Set<CodeGenAnalysis> nullSources = analysis.getNullSources();
		return (nullSources != null) && (nullSources.size() > 0);
	} */

//	@Override
//	public @Nullable String visitBooleanLiteralExp(@NonNull BooleanLiteralExp element) {
//		return "static final " + atNonNull() + " Object " + getSymbolName(element) + " = " + super.visitBooleanLiteralExp(element) + ";";
//	}

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
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", collectionType.getTypeId(), element);
		StringBuilder partArgs = new StringBuilder();
		List<CollectionLiteralPart> parts = element.getPart();
		String integerRangeCast = null;
		for (CollectionLiteralPart part : parts) {
			CodeGenSnippet partSnippet = context.getSnippet(DomainUtil.nonNullModel(part));
			snippet.addDependsOn(partSnippet);
			partArgs.append(", ");
			if (part instanceof CollectionRange) {
				if (integerRangeCast == null) {
					integerRangeCast = "(" + context.getImportedName(IntegerRange.class) + ")";
				}
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
		String collectionName = snippet.getName();
		String collectionTypeIdName = snippet.getSnippetName(collectionType.getTypeId());
//		if (collectionType.isOrdered() && (parts.size() == 1) && (parts.get(0) instanceof CollectionRange)) {
//			String createCollectionName = "create" + element.getKind() + "Range";
//			CollectionRange range = (CollectionRange) parts.get(0);
//			context.append("final " + atNonNull() + " Object " + collectionName + " = " + createCollectionName + "(" + collectionTypeIdName);
//			context.append(", createRange(" + firstName + ", " + lastName + "));");
//		}
//		else {	// FIXME folding
		String createCollectionName = "create" + element.getKind() + (integerRangeCast != null ? "Range" : "Value");
		snippet.append("final " + atNonNull() + " Object " + collectionName + " = " + createCollectionName + "(" + collectionTypeIdName + partArgs + ");\n");
		return snippet;
	}

	@Override
	public @NonNull CodeGenSnippet visitCollectionRange(@NonNull CollectionRange element) {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		snippet.setJavaClass(IntegerRange.class);
		String firstName = snippet.getSnippetName(element.getFirst());
		String lastName = snippet.getSnippetName(element.getLast());
		String integerValueCast = "(" + context.getImportedName(IntegerValue.class) + ")";
		snippet.append("final " + atNonNull() + " " + snippet.getJavaClassName() + " " + snippet.getName() + " = createRange(" + integerValueCast + firstName + ", " + integerValueCast + lastName + ");\n");
		return snippet;
	}

	@Override
	public @NonNull CodeGenSnippet visitConstructorExp(@NonNull ConstructorExp element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		if (analysis.isConstant()) {
			return context.getSnippet(analysis.getConstantValue());
		}
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		Type type = element.getType();
		StringBuilder partArgs = new StringBuilder();
		List<ConstructorPart> parts = element.getPart();
		for (ConstructorPart part : parts) {
			CodeGenSnippet partSnippet = context.getSnippet(DomainUtil.nonNullModel(part));
			snippet.addDependsOn(partSnippet);
			partArgs.append(", ");
			String name = partSnippet.getName();
//			if ("null".equals(name) && (parts.size() == 1)) {
//				partArgs.append("(Object)");
//			}
			partArgs.append(name);
		}
		String name = snippet.getName();
		String typeIdName = snippet.getSnippetName(type.getTypeId());
		snippet.append("final " + atNonNull() + " Object " + name + " = createObjectValue(" + typeIdName + partArgs + ");\n");
		return snippet;
	}

	@Override
	public @Nullable CodeGenSnippet visitEnumLiteralExp(@NonNull EnumLiteralExp element) {
		return context.getSnippet(ValuesUtil.createEnumerationLiteralValue(DomainUtil.nonNullModel(element.getReferredEnumLiteral())));
	}

	@Override
	public @NonNull CodeGenSnippet visitExpressionInOCL(@NonNull ExpressionInOCL element) {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		OCLExpression bodyExpression = DomainUtil.nonNullModel(element.getBodyExpression());
		CodeGenAnalysis bodyAnalysis = context.getAnalysis(bodyExpression);
		CodeGenSnippet bodySnippet = context.getSnippet(bodyExpression);
		if (!bodyAnalysis.isConstant()) {
			String resultName = bodySnippet.getName(); //getSymbolName(bodyExpression);
			snippet.appendContentsOf(bodySnippet);
			if (bodyAnalysis.mayBeInvalidValue()) {
				appendThrowCheck(snippet, resultName);
			}
			CodeGenText text = snippet.appendIndentedText("");
			snippet.addDependsOn(bodySnippet);
			text.append("return ");
			text.appendReferenceTo(bodyExpression);
			text.append(";\n");
		}
		else {
			Object constantValue = bodyAnalysis.getConstantValue();
			if (constantValue instanceof InvalidValue) {
				String resultText = bodySnippet.getName();
//				append(resultText + ";\n");
				snippet.append("throw (" + resultText + ").getException();\n");
			}
			else {
				CodeGenText text = snippet.appendIndentedText("");
				snippet.addDependsOn(bodySnippet);
				text.append("return ");
				text.appendReferenceTo(bodyExpression);
				text.append(";\n");
			}	// FIXME maybeInvalid check
//			if (analysis.getTransitiveInvalidSources().size() > 0) {
//				appendThrowCheck(symbolName);
//			}
		}
		return snippet;
	}

	@Override
	public @NonNull CodeGenSnippet visitIfExp(@NonNull IfExp element) {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		CodeGenText head = snippet.appendIndentedText("");
		head.append("if (");
		head.appendReferenceTo(DomainUtil.nonNullModel(element.getCondition()));
		head.append(") {\n");
		CodeGenSnippet thenNodes = snippet.appendIndentedNodes(null);
		thenNodes.appendContentsOf(context.getSnippet(DomainUtil.nonNullModel(element.getThenExpression())));
		CodeGenText  text = snippet.appendIndentedText("");
		text.append("}\n");
		text.append("else {\n");
		CodeGenSnippet elseNodes = snippet.appendIndentedNodes(null);
		elseNodes.appendContentsOf(context.getSnippet(DomainUtil.nonNullModel(element.getElseExpression())));
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
	public @NonNull CodeGenSnippet visitIterateExp(@NonNull IterateExp element) {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		Iteration referredIteration = DomainUtil.nonNullModel(element.getReferredIteration());
		OCLExpression source = element.getSource();
		OCLExpression bodyExpression = DomainUtil.nonNullModel(element.getBody());
		List<Variable> iterators = element.getIterator();
		int arity = iterators.size();
		String operationTypeName = context.getImportedName(genModelHelper.getAbstractOperationClass(iterators));
		String iterationTypeName = context.getImportedName(LibraryIteration.class);
		String astName = snippet.getName();
		String sourceName = getBoxedSymbolName(source);
		String typeId = snippet.getSnippetName(element.getTypeId());
		String referredIterationName = genModelHelper.getQualifiedLiteralName(referredIteration);
		String managerTypeName = context.getImportedName(ExecutorSingleIterationManager.class);
		String domainEvaluatorName = context.getImportedName(DomainEvaluator.class);
		String typeIdName = context.getImportedName(TypeId.class);
		String atNonNull = atNonNull();
		String atNullable = atNullable();
		String standardLibraryName = context.getStandardLibrary(snippet).getName();
		String evaluatorName = context.getEvaluatorName();
		String staticTypeName = "TYPE_" + astName;
		String implementationName = "IMPL_" + astName;
		String managerName = "MGR_" + astName;
		String bodyName = "BODY_" + astName;

		
		CodeGenText head = snippet.appendIndentedText("");
		head.append("/**\n"); 
		head.append(" * Implementation of the iterate body.\n");
		head.append(" */\n");
		head.append("final " + atNonNull() + " " + operationTypeName + " " + bodyName + " = new " + operationTypeName + "()\n");
		head.append("{\n");
		CodeGenSnippet evaluateBody = snippet.appendIndentedNodes(null);
			CodeGenLabel localLabel = context.getSnippetLabel(CodeGenerator.LOCAL_ROOT);
			CodeGenText text = evaluateBody.appendIndentedText("");
			text.appendCommentWithOCL(null, bodyExpression);
			text.append("@Override\n");
			text.append("public " + atNullable + " Object evaluate(" +
				atNonNull + " " + domainEvaluatorName + " " + evaluatorName + ", " +
				atNonNull + " " + typeIdName + " returnTypeId");
			CodeGenSnippet evaluateNodes = evaluateBody.appendIndentedNodes(null);
			localLabel.push(evaluateNodes);
			text.append(", " + atNullable + " Object ");
			Variable result = element.getResult();
			CodeGenSnippet resultSnippet = evaluateNodes.getSnippet(result);
			text.append(resultSnippet.getName());
			for (int i = 0; i < arity; i++) {
				text.append(", " + atNullable + " Object ");
				Variable iterator = iterators.get(i);
				CodeGenSnippet iteratorSnippet = evaluateNodes.getSnippet(iterator);
				text.append(iteratorSnippet.getName());
			}
			text.append(") throws Exception {\n");
			CodeGenSnippet iteratorBody = evaluateBody.appendIndentedNodes(null);
				CodeGenSnippet bodySnippet = context.getSnippet(bodyExpression);
				iteratorBody.appendContentsOf(bodySnippet);
				CodeGenSnippet boxedBodySnippet = bodySnippet.getBoxedSnippet();
				iteratorBody.append("return " + boxedBodySnippet.getName() + ";\n");
				evaluateBody.append("}\n");
			localLabel.pop();
		snippet.append("};\n");
		if (source != null) {
//			if (mayEvaluateFor(referredProperty, metaModelManager.getOclInvalidType())) {		// If property processes invalid, must catch any incoming exceptions as invalid values.
//				 appendCatchingStatement(s, null, source);
//			}
//			else {																				// If property propagates invalid, must throw exceptions for any incoming invalid values
				appendThrowingStatement(snippet, source);
//			}
		}
		CodeGenText tail = snippet.appendIndentedText("");
		tail.append(context.getImportedName(DomainType.class) + " " + staticTypeName + " = " + evaluatorName + ".getStaticTypeOf(" + sourceName + ");\n");
		tail.append(iterationTypeName + " " + implementationName + " = (" + iterationTypeName + ")" + staticTypeName + ".lookupImplementation(" + standardLibraryName + ", " + referredIterationName + ");\n");
//		tail.append("Object " + accumulatorName + " = " + implementationName + ".createAccumulatorValue(" + evaluatorName + ", " + typeId + ", " + bodyType + ");\n");
		tail.append(managerTypeName + " " + managerName + " = new " + managerTypeName + "(" + evaluatorName + ", " + typeId + ", " + bodyName + ", (" + context.getImportedName(CollectionValue.class) + ")" + sourceName + ", " + resultSnippet.getName() + ");\n");
		tail.append("Object " + astName + " = " + implementationName+ ".evaluateIteration(" + managerName + ");\n");
		return snippet;
/*
[template public emitExpression(ast : IteratorExp, importer : NamedElement, genPackage : GenPackage, expInOcl : ExpressionInOCL) ?(not ast.isInlineable())]
[let arity : OCLInteger = ast.iterator->size()]
[let leftVarName : String = ast.source.symbolName(expInOcl)]
[let astName : String = ast.symbolName(expInOcl)]
[let operationTypeName : String = 'org.eclipse.ocl.examples.domain.library.Abstract' + genPackage.emitOperationArity(arity)]
[let iterationTypeName : String = 'org.eclipse.ocl.examples.domain.library.LibraryIteration']
[let managerTypeName : String = 'org.eclipse.ocl.examples.library.executor.' + genPackage.emitManagerArity(arity)]
[ast.source.emitExpression(importer, genPackage, expInOcl)/]
if ([ast.source.symbolName(expInOcl)/] == null) throw new <%InvalidValueException%>("null '[ast.referredIteration.name/]' source");
if ([ast.source.symbolName(expInOcl)/] instanceof <%InvalidValue%>) throw ((<%InvalidValue%>)[ast.source.symbolName(expInOcl)/]).getException();

/ ** 
 * Implementation of the iterator body.
 * /
<%[operationTypeName/]%> body_[astName/] = new <%[operationTypeName/]%>()
{
/ *
[ast._'body'.prettyPrint().trim()/]
* /
	@Override
    public @Nullable Object evaluate(@NonNull <%DomainEvaluator%> evaluator, @NonNull <%TypeId%> returnTypeId, @Nullable Object sourceValue[for (i : OCLInteger | Sequence{1..arity})], @Nullable Object iterator[i/][/for]) throws Exception {
[for (i : OCLInteger | Sequence{1..arity})]
		final Object [ast.iterator->at(i).symbolName(expInOcl)/] = iterator[i/];	// iterator: [ast.iterator->at(i).name/]
[/for]  
		[ast._'body'.emitExpression(importer, genPackage, expInOcl)/]
		return [ast._'body'.symbolName(expInOcl)/];
	}
};
<%org.eclipse.ocl.examples.domain.elements.DomainType%> static_[astName/] = evaluator.getStaticTypeOf([ast.source.symbolName(expInOcl)/]);
<%[iterationTypeName/]%> dynamic_[astName/] = (<%[iterationTypeName/]%>)static_[astName/].lookupImplementation(standardLibrary, [ast.referredIteration.symbolName(expInOcl)/]);
Object acc_[astName/] = dynamic_[astName/].createAccumulatorValue(evaluator, [ast.type.typeId(expInOcl)/], [ast._body.type.typeId(expInOcl)/]);
<%[managerTypeName/]%> manager_[astName/] = new <%[managerTypeName/]%>(evaluator, [ast.type.typeId(expInOcl)/], body_[astName/], (<%CollectionValue%>)[ast.source.symbolName(expInOcl)/], acc_[astName/]);
Object [astName/] = dynamic_[astName/].evaluateIteration(manager_[astName/]);[/let][/let][/let][/let][/let][/let][/template]
 */
	}

	@Override
	public @NonNull CodeGenSnippet visitIteratorExp(@NonNull IteratorExp element) {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		Iteration referredIteration = DomainUtil.nonNullModel(element.getReferredIteration());
		OCLExpression source = element.getSource();
		OCLExpression bodyExpression = element.getBody();
		List<Variable> iterators = element.getIterator();
		int arity = iterators.size();
		String operationTypeName = context.getImportedName(genModelHelper.getAbstractOperationClass(iterators));
		String iterationTypeName = context.getImportedName(LibraryIteration.class);
		String astName = snippet.getName();
		String sourceName = getBoxedSymbolName(source);
		String typeId = snippet.getSnippetName(element.getTypeId());
		String bodyType = snippet.getSnippetName(bodyExpression.getTypeId());
		String referredIterationName = genModelHelper.getQualifiedLiteralName(referredIteration);
		String managerTypeName = context.getImportedName(arity == 1 ? ExecutorSingleIterationManager.class : ExecutorDoubleIterationManager.class); 	// FIXME ExecutorMultipleIterationManager
		String domainEvaluatorName = context.getImportedName(DomainEvaluator.class);
		String typeIdName = context.getImportedName(TypeId.class);
		String atNonNull = atNonNull();
		String atNullable = atNullable();
		String standardLibraryName = context.getStandardLibrary(snippet).getName();
		String evaluatorName = context.getEvaluatorName();
		String staticTypeName = "TYPE_" + astName;
		String accumulatorName = "ACC_" + astName;
		String implementationName = "IMPL_" + astName;
		String managerName = "MGR_" + astName;
		String bodyName = "BODY_" + astName;

		
		CodeGenText head = snippet.appendIndentedText("");
		head.append("/**\n"); 
		head.append(" * Implementation of the iterator body.\n");
		head.append(" */\n");
		head.append("final " + atNonNull() + " " + operationTypeName + " " + bodyName + " = new " + operationTypeName + "()\n");
		head.append("{\n");
		CodeGenSnippet evaluateBody = snippet.appendIndentedNodes(null);
			CodeGenLabel localLabel = context.getSnippetLabel(CodeGenerator.LOCAL_ROOT);
			CodeGenText text = evaluateBody.appendIndentedText("");
			text.appendCommentWithOCL(null, bodyExpression);
			text.append("@Override\n");
			text.append("public " + atNullable + " Object evaluate(" +
				atNonNull + " " + domainEvaluatorName + " " + evaluatorName + ", " +
				atNonNull + " " + typeIdName + " returnTypeId, " +
				atNullable + " Object sourceValue");
			CodeGenSnippet evaluateNodes = evaluateBody.appendIndentedNodes(null);
			localLabel.push(evaluateNodes);
			for (int i = 0; i < arity; i++) {
				text.append(", " + atNullable + " Object ");
				Variable iterator = iterators.get(i);
				CodeGenSnippet iteratorSnippet = evaluateNodes.getSnippet(iterator);
				text.append(iteratorSnippet.getName());
			}
			text.append(") throws Exception {\n");
			CodeGenSnippet iteratorBody = evaluateBody.appendIndentedNodes(null);
				CodeGenSnippet bodySnippet = context.getSnippet(bodyExpression);
				iteratorBody.appendContentsOf(bodySnippet);
				CodeGenSnippet boxedBodySnippet = bodySnippet.getBoxedSnippet();
				iteratorBody.append("return " + boxedBodySnippet.getName() + ";\n");
				evaluateBody.append("}\n");
			localLabel.pop();
		snippet.append("};\n");
		if (source != null) {
//			if (mayEvaluateFor(referredProperty, metaModelManager.getOclInvalidType())) {		// If property processes invalid, must catch any incoming exceptions as invalid values.
//				 appendCatchingStatement(s, null, source);
//			}
//			else {																				// If property propagates invalid, must throw exceptions for any incoming invalid values
				appendThrowingStatement(snippet, source);
//			}
		}
		CodeGenText tail = snippet.appendIndentedText("");
		tail.append(context.getImportedName(DomainType.class) + " " + staticTypeName + " = " + evaluatorName + ".getStaticTypeOf(" + sourceName + ");\n");
		tail.append(iterationTypeName + " " + implementationName + " = (" + iterationTypeName + ")" + staticTypeName + ".lookupImplementation(" + standardLibraryName + ", " + referredIterationName + ");\n");
		tail.append("Object " + accumulatorName + " = " + implementationName + ".createAccumulatorValue(" + evaluatorName + ", " + typeId + ", " + bodyType + ");\n");
		tail.append(managerTypeName + " " + managerName + " = new " + managerTypeName + "(" + evaluatorName + ", " + typeId + ", " + bodyName + ", (" + context.getImportedName(CollectionValue.class) + ")" + sourceName + ", " + accumulatorName + ");\n");
		tail.append("Object " + astName + " = " + implementationName+ ".evaluateIteration(" + managerName + ");\n");
		return snippet;
/*
[template public emitExpression(ast : IteratorExp, importer : NamedElement, genPackage : GenPackage, expInOcl : ExpressionInOCL) ?(not ast.isInlineable())]
[let arity : OCLInteger = ast.iterator->size()]
[let leftVarName : String = ast.source.symbolName(expInOcl)]
[let astName : String = ast.symbolName(expInOcl)]
[let operationTypeName : String = 'org.eclipse.ocl.examples.domain.library.Abstract' + genPackage.emitOperationArity(arity)]
[let iterationTypeName : String = 'org.eclipse.ocl.examples.domain.library.LibraryIteration']
[let managerTypeName : String = 'org.eclipse.ocl.examples.library.executor.' + genPackage.emitManagerArity(arity)]
[ast.source.emitExpression(importer, genPackage, expInOcl)/]
if ([ast.source.symbolName(expInOcl)/] == null) throw new <%InvalidValueException%>("null '[ast.referredIteration.name/]' source");
if ([ast.source.symbolName(expInOcl)/] instanceof <%InvalidValue%>) throw ((<%InvalidValue%>)[ast.source.symbolName(expInOcl)/]).getException();

/ ** 
 * Implementation of the iterator body.
 * /
<%[operationTypeName/]%> body_[astName/] = new <%[operationTypeName/]%>()
{
/ *
[ast._'body'.prettyPrint().trim()/]
* /
	@Override
    public @Nullable Object evaluate(@NonNull <%DomainEvaluator%> evaluator, @NonNull <%TypeId%> returnTypeId, @Nullable Object sourceValue[for (i : OCLInteger | Sequence{1..arity})], @Nullable Object iterator[i/][/for]) throws Exception {
[for (i : OCLInteger | Sequence{1..arity})]
		final Object [ast.iterator->at(i).symbolName(expInOcl)/] = iterator[i/];	// iterator: [ast.iterator->at(i).name/]
[/for]  
		[ast._'body'.emitExpression(importer, genPackage, expInOcl)/]
		return [ast._'body'.symbolName(expInOcl)/];
	}
};
<%org.eclipse.ocl.examples.domain.elements.DomainType%> static_[astName/] = evaluator.getStaticTypeOf([ast.source.symbolName(expInOcl)/]);
<%[iterationTypeName/]%> dynamic_[astName/] = (<%[iterationTypeName/]%>)static_[astName/].lookupImplementation(standardLibrary, [ast.referredIteration.symbolName(expInOcl)/]);
Object acc_[astName/] = dynamic_[astName/].createAccumulatorValue(evaluator, [ast.type.typeId(expInOcl)/], [ast._body.type.typeId(expInOcl)/]);
<%[managerTypeName/]%> manager_[astName/] = new <%[managerTypeName/]%>(evaluator, [ast.type.typeId(expInOcl)/], body_[astName/], (<%CollectionValue%>)[ast.source.symbolName(expInOcl)/], acc_[astName/]);
Object [astName/] = dynamic_[astName/].evaluateIteration(manager_[astName/]);[/let][/let][/let][/let][/let][/let][/template]
 */
	}

	@Override
	public @NonNull CodeGenSnippet visitLetExp(@NonNull LetExp element) {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		Variable letVariable = element.getVariable();
		OCLExpression initExpression = letVariable.getInitExpression();
		if (initExpression != null) {
			CodeGenSnippet initSnippet = context.getSnippet(initExpression);
//			CodeGenAnalysis initAnalysis = context.getAnalysis(initExpression);
			if (!initSnippet.isInlined()) {
				 appendCatchingStatement(snippet, letVariable, initExpression);
			}
		}
		OCLExpression inExpression = DomainUtil.nonNullModel(element.getIn());
//		CodeGenAnalysis inAnalysis = context.getAnalysis(inExpression);
		CodeGenSnippet inSnippet = context.getSnippet(inExpression);
		if (!inSnippet.isInlined()) {
			snippet.appendContentsOf(inSnippet);
		}
//		String resultName = snippet.getName();
//		s.append("final Object " + resultName + " = " + context.getReferringText(s, inExpression) + ";\n");
//		CodeGenAnalysis analysis = context.getAnalysis(inExpression);
//		if (analysis.getTransitiveInvalidSources().size() > 0) {
//			appendThrowCheck(resultName);
//		}
		return snippet;
	}
	
/*	@Override
	public @NonNull CodeGenSnippet visitMetaclass(@NonNull Metaclass element) {
		String symbolName = getSymbolName(element);
		String typeValueName = context.getImportedName(TypeValue.class);
		String evaluatorName = context.getEvaluatorName();
		String typeIdName = element.getInstanceType().getTypeId().accept(context.getIdVisitor());
		context.append("final " + atNonNull() + " " + typeValueName + " " + symbolName + " = createTypeValue(" + evaluatorName + ".getIdResolver().getType(" + typeIdName + ", null));\n");	
		return symbolName;
	} */

	@Override
	public @NonNull CodeGenSnippet visitNullLiteralExp(@NonNull NullLiteralExp element) {
		return context.getSnippet(null);
	}

/*	@Override
	public @NonNull CodeGenSnippet visitOCLExpression(@NonNull OCLExpression element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		if (analysis.isConstant()) {
			return context.getConstant(element);
		}
		@NonNull CodeGenSnippet snippet = new CodeGenSnippet(context, element);
		String symbolName = getSymbolName(element);
		s.append("final " + atNonNull() + " Object " + symbolName + " = " + context.getDefiningText(element) + ";\n");	
		if (analysis.mayBeInvalidValue()) {
			appendThrowCheck(s, symbolName);
		}
		return s;
	} */

/*	@Override
	public @NonNull CodeGenSnippet visitOperation(@NonNull Operation element) {
		@NonNull CodeGenSnippet snippet = new CodeGenSnippet(context, element);
		String symbolName = getSymbolName(element);
		s.append("final " + atNonNull() + " " + context.getImportedName(ExecutorOperation.class) + " " + symbolName + " = " + context.getQualifiedLiteralName(element) + ";\n");	
		return s;
	} */

	@Override
	public @NonNull CodeGenSnippet visitOperationCallExp(@NonNull OperationCallExp element) {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		snippet.setIsBoxed();
		Operation referredOperation = DomainUtil.nonNullModel(element.getReferredOperation());
		OCLExpression source = element.getSource();
		List<OCLExpression> arguments = DomainUtil.nonNullEMF(element.getArgument());
		//
		//	Assign each source and argument to a Java variable, unless the source/argument is simple enough to be inlineable.
		//
		if (context.mayEvaluateForInvalid(referredOperation)) {		// If operation processes invalid, must catch any incoming exceptions as invalid values.
			if (source != null) {
				 appendCatchingStatement(snippet, null, source);
			}
			for (OCLExpression argument : arguments) {
				if (argument != null) {
					 appendCatchingStatement(snippet, null, argument);
				}
			}
		}
		else {																				// If operation propagates invalid, must throw exceptions for any incoming invalid values
			if (source != null) {
				appendThrowingStatement(snippet, source);
			}
			for (OCLExpression argument : arguments) {
				if (argument != null) {
					appendThrowingStatement(snippet, argument);
				}
			}
		}
		//
		//	Call the operation with the appropriate arguments.
		//
		context.addDependency(CodeGenerator.LOCAL_ROOT, snippet);
		String evaluatorName = context.getEvaluatorName();
		String resultSymbolName = snippet.getName();
//		String sourceText = source != null ? s.appendReference(source)/*context.getReferringText(s, source)*/ : "null";
		String typeIdName = snippet.getSnippetName(element.getTypeId());
		CodeGenText text = snippet.appendIndentedText("");
		if (context.isFinal(referredOperation)) {
			String className = getImplementationName(referredOperation);
			text.append("final Object " + resultSymbolName + " = " + className + ".evaluate(" + evaluatorName + ", " + typeIdName);
			text.append(", ");
			if (source != null) {
				text.appendReferenceTo(source);
			}
			else {
				text.append("null");
			}
			for (OCLExpression argument : arguments) {
				assert argument != null;
				text.append(", " /*context.getReferringText(s, argument)*/);
				text.appendReferenceTo(argument);
			}
			text.append(");\n");
		}
		else {
			String standardLibraryName = context.getStandardLibrary(snippet).getName();
			String operationTypeName = context.getImportedName(genModelHelper.getOperationInterface(arguments));
			String operationName = genModelHelper.getQualifiedLiteralName(referredOperation); //context.getConstantName(referredOperation);
			String staticImplementationName = nameManager.reserveName("static_" + referredOperation.getName(), null);
			String dynamicImplementationName;
			if (source != null) {
				dynamicImplementationName = nameManager.reserveName("dynamic_" + referredOperation.getName(), null);
				text.append("final " + context.getImportedName(DomainType.class) + " " + staticImplementationName + " = ");
				text.append(evaluatorName + ".getStaticTypeOf(");
				text.appendReferenceTo(source);
				for (OCLExpression argument : arguments) {
					assert argument != null;
					text.append(", ");
					String referredSymbolName = context.getSnippet(argument).getName();
					if ((arguments.size() == 1) && "null".equals(referredSymbolName)) {
						text.append("(Object)");
					}
					text.appendReferenceTo(argument);
				}
				text.append(");\n");
			}
			else {
				dynamicImplementationName = staticImplementationName;
			}
			text.append("final " + operationTypeName + " " + dynamicImplementationName + " = (" + operationTypeName + ")" + staticImplementationName + ".lookupImplementation(" + standardLibraryName + ", " + operationName + ");\n");
			text.append("final Object " + resultSymbolName + " = " + dynamicImplementationName + ".evaluate(" + evaluatorName + ", " + typeIdName + ", ");
			if (source != null) {
				text.appendReferenceTo(source);
			}
			else {
				text.append("null");
			}
			for (OCLExpression argument : arguments) {
				assert argument != null;
				text.append(", ");
				text.appendReferenceTo(argument);
			}
			text.append(");\n");
		}
		return snippet;
	}
	
/*	@Override
	public @NonNull CodeGenSnippet visitPrimitiveType(@NonNull PrimitiveType element) {
		String symbolName = getSymbolName(element);
		context.append("final " + atNonNull() + " " + context.getImportedName(ExecutorType.class) + " " + symbolName + " = " + "context.getQualifiedLiteralName(element)" + ";\n");	
		return symbolName;
	} */

	@Override
	public @NonNull CodeGenSnippet visitPropertyCallExp(@NonNull PropertyCallExp element) {
		Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		OCLExpression source = element.getSource();
		if (source != null) {
			Type sourceType = source.getType();
			if (sourceType instanceof TupleType) {
				return visitTuplePartCallExp(element);
			}
		}
		if (referredProperty.isStatic()) {
			return visitStaticPropertyCallExp(element);
		}
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		//
		//	Assign each source and argument to a Java variable, unless the source/argument is simple enough to be inlineable.
		//
		if (source != null) {
//			if (mayEvaluateFor(referredProperty, metaModelManager.getOclInvalidType())) {		// If property processes invalid, must catch any incoming exceptions as invalid values.
				 appendCatchingStatement(snippet, null, source);
//			}
//			else {																				// If property propagates invalid, must throw exceptions for any incoming invalid values
//				appendThrowingStatement(s, source);
//			}
			CodeGenText text = snippet.appendIndentedText("");
			TypeId targetTypeId = DomainUtil.nonNullModel(referredProperty.getType()).getTypeId();
			Class<?> unboxedClass = context.getUnboxedClass(targetTypeId);
			String unboxedClassName = context.getImportedName(unboxedClass);
			String resultName = snippet.getName();
//			String typeIdName = snippet.getSnippetName(element.getTypeId());
			text.append("final " + unboxedClassName + " " + resultName + " = ");
			Type owningType = DomainUtil.nonNullModel(referredProperty.getOwningType());
			text.appendReferenceTo(source, owningType);
			text.append(".");
			try {
				String getAccessor = genModelHelper.getGetAccessor(referredProperty);
				text.append(getAccessor);
			}
			catch (GenModelException e) {
				text.appendException(e);				
			}
			text.append("();\n");
			snippet.setIsUnboxed();
			snippet.setIsFinal();
		}
//		+ className + ".evaluate(" + evaluatorName + ", " + typeIdName + ", ");
/*		String className = getImplementationName(referredProperty);
		if (classname != null) {
			//
			//	Call the property with the appropriate arguments.
			//
			String evaluatorName = context.getEvaluatorName();
			String resultSymbolName = snippet.getName();
			String typeIdName = snippet.getSnippetName(element.getTypeId());
			s.append("final Object " + resultSymbolName + " = " + className + ".evaluate(" + evaluatorName + ", " + typeIdName + ", ");
			if (source != null) {
				s.appendReferenceTo(source);
			}
			else {
				s.append("null");
			}
			s.append(");\n");
		} */
		return snippet;
/*
[if (not ast.source.isConstant())]
[ast.source.emitExpression(importer, genPackage, expInOcl)/]
[/if]
if ([ast.source.symbolName(expInOcl)/] == null) { throw new <%InvalidValueException%>("Null property source"); }
[ast.source.emitUnbox(ast, genPackage, expInOcl)/][genPackage.getEscapedPropertyType(ast.referredProperty)/] [ast.defineFlag('unboxed_' + ast.symbolName(expInOcl))/] = unboxed_[ast.source.symbolName(expInOcl)/].[genPackage.getPropertyGetter(ast.referredProperty)/]();
[ast.emitBox(importer, genPackage, expInOcl)/]
 */
	}

	protected @NonNull CodeGenSnippet visitStaticPropertyCallExp(@NonNull PropertyCallExp element) {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		OCLExpression source = element.getSource();
		assert source != null;
		appendCatchingStatement(snippet, null, source);
		String implementationClassName = referredProperty.getImplementationClass();
		String className;
		if (implementationClassName != null) {
			className = context.getImportManager().getImportedName(implementationClassName) + ".INSTANCE";
		}
		else {
			className = genModelHelper.getQualifiedLiteralName(referredProperty);
		}
		TypeId targetTypeId = DomainUtil.nonNullModel(referredProperty.getType()).getTypeId();
		Class<?> boxedClass = context.getBoxedClass(targetTypeId);
		Class<?> returnClass = Object.class;
		try {
			LibraryFeature implementation = context.getMetaModelManager().getImplementation(referredProperty);
			@SuppressWarnings("null") @NonNull Class<? extends LibraryFeature> implementationClass = implementation.getClass();
			returnClass = getReturnClass(implementationClass);
		} catch (Exception e) {
		}
		String boxedClassName = context.getImportedName(boxedClass);
		String typeIdName = snippet.getSnippetName(element.getTypeId());
		String resultName = snippet.getName();
		String sourceName = getSymbolName(source);
		String evaluatorName = context.getEvaluatorName();
		CodeGenText text = snippet.append("final " + boxedClassName + " " + resultName + " = ");
		if (!boxedClass.isAssignableFrom(returnClass)) {
			System.out.println("Cast needed for " + className);
			text.append("(" + boxedClassName + ")");
		}
		text.append(className + ".evaluate(" + evaluatorName + ", " + typeIdName + ", " + sourceName + ");\n");
		snippet.setIsBoxed();
		snippet.setIsFinal();
		return snippet;
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
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		TupleType tupleType = (TupleType) element.getType();
		StringBuilder partArgs = new StringBuilder();
		List<TupleLiteralPart> parts = element.getPart();
		for (TupleLiteralPart part : parts) {
			CodeGenSnippet partSnippet = context.getSnippet(DomainUtil.nonNullModel(part));
			snippet.addDependsOn(partSnippet);
			partArgs.append(", ");
			String name = partSnippet.getName();
//			if ("null".equals(name) && (parts.size() == 1)) {
//				partArgs.append("(Object)");
//			}
			partArgs.append(name);
		}
		String tupleName = snippet.getName();
		String tupleTypeIdName = snippet.getSnippetName(tupleType.getTypeId());
		snippet.append("final " + atNonNull() + " Object " + tupleName + " = createTupleValue(" + tupleTypeIdName + partArgs + ");\n");
		return snippet;
	}

	protected @NonNull CodeGenSnippet visitTuplePartCallExp(@NonNull PropertyCallExp element) {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		OCLExpression source = DomainUtil.nonNullModel(element.getSource());
		String tuplePartName = referredProperty.getName();
		TupleType tupleType = (TupleType) source.getType();
		List<String> names = new ArrayList<String>(tupleType.getOwnedAttribute().size());
		for (Property tuplePart : tupleType.getOwnedAttribute()) {
			names.add(tuplePart.getName());
		}
		Collections.sort(names);										// FIXME maintain sorted list in TupleType
		int tuplePartIndex = names.indexOf(tuplePartName);
		appendCatchingStatement(snippet, null, source);
		String tupleValueName = getCastSymbolName(TupleValue.class, source);
		String resultName = snippet.getName();
		snippet.append("final Object " + resultName + " = (" + tupleValueName + ").getValue(" + tuplePartIndex + ");/n");
		return snippet;
	}

	@Override
	public @NonNull CodeGenSnippet visitTypeExp(@NonNull TypeExp element) {
		return context.getSnippet(ValuesUtil.createTypeValue(element.getReferredType()));
	}

	@Override
	public @NonNull CodeGenSnippet visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp element) {
		return context.getSnippet(element.getUnlimitedNaturalSymbol());
	}

	@Override
	public @NonNull CodeGenSnippet visitVariable(@NonNull Variable element) {
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		return snippet;
//		VariableDeclaration referredVariable = element.getReferredVariable();
//		if (referredVariable)
//		return context.getSnippet(referredVariable.UnlimitedNaturalSymbol());
	}

	@Override
	public @NonNull CodeGenSnippet visitVariableExp(@NonNull VariableExp element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		CodeGenAnalysis delegatesTo = analysis.getDelegatesTo();
		if (delegatesTo != null) {
			return context.getSnippet(delegatesTo.getExpression());
		}
		@NonNull CodeGenSnippet snippet = new JavaSnippet(context, "", element.getTypeId(), element);
		return snippet;
//		VariableDeclaration referredVariable = element.getReferredVariable();
//		if (referredVariable)
//		return context.getSnippet(referredVariable.UnlimitedNaturalSymbol());
	}

	public @NonNull CodeGenSnippet visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Statement: " + visitable.getClass().getName());
	}
}
