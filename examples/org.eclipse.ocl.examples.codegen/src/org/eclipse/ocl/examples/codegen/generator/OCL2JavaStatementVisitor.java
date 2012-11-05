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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.CommonSubExpression;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.library.executor.ExecutorDoubleIterationManager;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.FinalAnalysis;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * An OCL2JavaStatementVisitor appends one or more Java statements to an OCLCodeGenerator
 * to realize the code for a Pivot AST node.
 * <p>
 * Derived visitors may support an extended AST.
 */
public class OCL2JavaStatementVisitor extends AbstractExtendingVisitor<CodeGenSnippet, OCLCodeGenerator>
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull NameManager nameManager;
	protected /*@LazyNonNull*/ String invalidValueName = null;
	
	public OCL2JavaStatementVisitor(@NonNull OCLCodeGenerator codeGenerator) {
		super(codeGenerator);
		metaModelManager = codeGenerator.getMetaModelManager();
		nameManager = codeGenerator.getNameManager();
	}

	/**
	 * Emit a statement that assigns the value of anExpression to its designated symbol catching
	 * an exception thrown during computation of anExpression and assigning an InvalidValue to
	 * the symbol to preserve the caught exception.
	 */
	protected void appendCatchingStatement(@NonNull CodeGenSnippet s, @Nullable Variable aVariable, @NonNull OCLExpression anExpression) {
		CodeGenAnalysis analysis = context.getAnalysis(anExpression);
		if (analysis.isInlineable()) { /* Nothing to do */}
		else if (analysis.isConstant()) {}
		else {
			CodeGenSnippet nestedSnippet = visit(anExpression);
			if (aVariable != null) {
				String symbolName = getSymbolName(aVariable);
				if (analysis.mayBeException()) {
					s.append("Object " + symbolName + ";\n");
					s.append("try {\n");
					s.pushIndentation();
					s.append(nestedSnippet);
					s.popIndentation();
					s.append("}\n");
					s.append("catch (Exception e) {\n");
					s.pushIndentation();
					s.append(symbolName + " = new " + context.getImportedName(InvalidValueImpl.class) + "(e);\n");
					s.popIndentation();
					s.append("}\n");
				}
				else {
					s.append(nestedSnippet);
				}
			}
			else {
				s.append(nestedSnippet);
			}
		}
	}

	/**
	 * Emit a statement that assigns the value of anExpression to its designated symbol throwing
	 * an exception in the event that computation of anException results an InvalidValue.
	 */
	protected void appendThrowingStatement(@NonNull CodeGenSnippet s, @NonNull OCLExpression anExpression) {
		CodeGenAnalysis analysis = context.getAnalysis(anExpression);
		if (analysis.isInlineable()) { /* Nothing to do */
			if (analysis.getConstantValue() instanceof InvalidValue) {
				s.append("throwInvalidValueException();\n");
			}
		}
		else if (analysis.isConstant()) {}
		else {
			CodeGenSnippet nestedSnippet = visit(anExpression);
			String symbolName;
			if (anExpression instanceof VariableExp) {
				symbolName = getSymbolName(((VariableExp)anExpression).getReferredVariable());
			}
			else {
//				String generatedComputation = expressionVisitor.visit(anExpression);
//				context.append("final Object " + symbolName + " = " + generatedComputation + ";\n");
				s.append(nestedSnippet);
				symbolName = getSymbolName(anExpression);
			}
			if (analysis.mayBeInvalidValue()) {
				appendThrowCheck(s, symbolName);
			}
		}
	}

	protected void appendThrowCheck(@NonNull CodeGenSnippet s, String symbolName) {
		String invalidValueName = getInvalidValueName();
		s.append("if (" + symbolName + " instanceof " + invalidValueName + ") ");
		s.append("throw ((" + invalidValueName + ")" + symbolName + ").getException();\n");
	}

	protected String atNonNull() {
		return context.atNonNull();
	}

	protected String atNullable() {
		return context.atNullable();
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
			return context.getImportedName(implementationClass) + ".INSTANCE";
		}
		List<Constraint> constraints = anOperation.getOwnedRule();
		if (constraints.size() > 0) {			
			String stereotype = constraints.get(0).getStereotype();
			if (stereotype != null) {
				String implementationName = context.getQualifiedOperationImplementationName(anOperation, stereotype);
				if (implementationName != null) {
					return implementationName;
				}
			}
		}	
		return "null";
	}

	protected String getImplementationName(@NonNull Property aProperty) {
		String implementationClass = aProperty.getImplementationClass();
		if (implementationClass != null) {
			return context.getImportedName(implementationClass) + ".INSTANCE";
		}
		List<Constraint> constraints = aProperty.getOwnedRule();
		if (constraints.size() > 0) {			
			String stereotype = constraints.get(0).getStereotype();
			if (stereotype != null) {
				String implementationName = context.getQualifiedPropertyImplementationName(aProperty, stereotype);
				if (implementationName != null) {
					return implementationName;
				}
			}
		}	
		return "null";
	}
	
	protected @NonNull String getInvalidValueName() {
		String invalidValueName2 = invalidValueName;
		if (invalidValueName2 == null) {
			invalidValueName = invalidValueName2 = context.getImportedName(InvalidValue.class);
		}
		return invalidValueName2;
	}

	protected @NonNull String getSymbolName(@Nullable Object element, @Nullable String... nameHints) {
		if (element instanceof Element) {
			CodeGenAnalysis analysis = context.getAnalysis((Element) element);
			CommonSubExpression referredCommonSubExpression = analysis.getReferredCommonSubExpression();
			if (referredCommonSubExpression != null) {
				return referredCommonSubExpression.getSymbolName();
			}
		}
		return element != null ? nameManager.getSymbolName(element, nameHints) : "null";
	}

	protected boolean isFinal(@NonNull Operation anOperation) {
		FinalAnalysis finalAnalysis = metaModelManager.getPackageManager().getFinalAnalysis();
		return finalAnalysis.isFinal(anOperation);
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

	/**
	 * Return true if anOperation has an overload for targetType (typically null or invalid).
	 */
	protected boolean mayEvaluateFor(@NonNull Operation anOperation, @NonNull Type targetType) {
		String name = anOperation.getName();
		if (name == null) {
			return false;
		}
		DomainInheritance inheritance = targetType.getInheritance(metaModelManager);
		DomainInheritance[] arguments;
		List<Parameter> parameters = anOperation.getOwnedParameter();
		int iSize = parameters.size();
		if (iSize > 0) {
			arguments = new DomainInheritance[iSize];
			for (int i = 0; i < iSize; i++) {
				Parameter parameter = parameters.get(i);
				Type type = parameter.getType();
				if (type == null) {
					return false;
				}
				if (type.getOwningTemplateParameter() != null) {
					return false;					// FIXME invalid not supported for templated operations
				}
				arguments[i] = type.getInheritance(metaModelManager);
			}
		}
		else {
			arguments = DomainInheritance.EMPTY_ARRAY;
		}
		DomainOperation localOperation = inheritance.lookupLocalOperation(metaModelManager, name, arguments);
		return localOperation != null;
	}

//	@Override
//	public @Nullable String visitBooleanLiteralExp(@NonNull BooleanLiteralExp element) {
//		return "static final " + atNonNull() + " Object " + getSymbolName(element) + " = " + super.visitBooleanLiteralExp(element) + ";";
//	}

	@Override
	public @NonNull CodeGenSnippet visit(@NonNull Visitable element) {
//		TypedElement element2 = (TypedElement)DomainUtil.nonNullModel(element);
//		CodeGenAnalysis analysis = context.findAnalysis(element2);			// FIXME cast
//		if ((analysis == null) || !analysis.isConstant()) {
			CodeGenSnippet s = element.accept(this);
			assert s != null;
			return s;			
//		}
/*		else if (!analysis.isInlineable()) {
			String symbolName = getSymbolName(element2);
			Object constantValue = analysis.getConstantValue();
			String literalText = context.getConstantHelper().getNonInlineValue(constantValue);
//			context.append("final " + atNonNull() + " Object " + symbolName + " = " + literalText + ";\n");	
			String constantString = constantValue != null ? getSymbolName(constantValue) : "null";
			context.append("final " + atNonNull() + " Object " + symbolName + " = " + constantString + ";\n");	
			if (analysis.mayBeInvalidValue()) {
				appendThrowCheck(s, symbolName);
			}
			return s;
		}
		else {
			return null;
		} */
	}

	@Override
	public @NonNull CodeGenSnippet visitCollectionItem(@NonNull CollectionItem element) {
		@NonNull CodeGenSnippet snippet = visit(DomainUtil.nonNullModel(element.getItem()));
		snippet.addElement(element);
		return snippet;
	}

	@Override
	public @NonNull CodeGenSnippet visitCollectionLiteralExp(@NonNull CollectionLiteralExp element) {
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
//		CodeGenAnalysis analysis = context.getAnalysis(element);
//		if (analysis.getTransitiveInvalidSources().size() > 0) {
//			context.append("throwInvalidValueException();");
//			return null;
//		}
		CollectionType collectionType = (CollectionType) element.getType();
		StringBuilder partArgs = new StringBuilder();
		List<CollectionLiteralPart> parts = element.getPart();
		String integerRangeCast = null;
		for (CollectionLiteralPart part : parts) {
			CodeGenSnippet partSnippet = visit(DomainUtil.nonNullModel(part));
			s.addDependsOn(partSnippet);
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
				s.append("(Object)");
			}
			partArgs.append(name);
		}
		String collectionName = getSymbolName(element);
		String collectionTypeIdName = s.getConstantName(collectionType.getTypeId());
//		if (collectionType.isOrdered() && (parts.size() == 1) && (parts.get(0) instanceof CollectionRange)) {
//			String createCollectionName = "create" + element.getKind() + "Range";
//			CollectionRange range = (CollectionRange) parts.get(0);
//			context.append("final " + atNonNull() + " Object " + collectionName + " = " + createCollectionName + "(" + collectionTypeIdName);
//			context.append(", createRange(" + firstName + ", " + lastName + "));");
//		}
//		else {	// FIXME folding
		String createCollectionName = "create" + element.getKind() + (integerRangeCast != null ? "Range" : "Value");
		s.append("final " + atNonNull() + " Object " + collectionName + " = " + createCollectionName + "(" + collectionTypeIdName + partArgs + ");\n");
		return s;
	}

	@Override
	public @NonNull CodeGenSnippet visitCollectionRange(@NonNull CollectionRange element) {
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
		s.setJavaClass(IntegerRange.class);
		String firstName = s.getConstantName(element.getFirst());
		String lastName = s.getConstantName(element.getLast());
		String integerValueCast = "(" + context.getImportedName(IntegerValue.class) + ")";
		s.append("final " + s.getJavaClassName() + " " + s.getName() + " = createRange(" + integerValueCast + firstName + ", " + integerValueCast + lastName + ");\n");
		return s;
	}

	@Override
	public @NonNull CodeGenSnippet visitExpressionInOCL(@NonNull ExpressionInOCL element) {
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
		OCLExpression bodyExpression = DomainUtil.nonNullModel(element.getBodyExpression());
		CodeGenAnalysis bodyAnalysis = context.getAnalysis(bodyExpression);
		if (!bodyAnalysis.isConstant()) {
			String resultName = getSymbolName(bodyExpression);
			s.append(visit(bodyExpression));
			if (bodyAnalysis.mayBeInvalidValue()) {
				appendThrowCheck(s, resultName);
			}
			s.append("return " + resultName + ";\n");
		}
		else {
			Object constantValue = bodyAnalysis.getConstantValue();
			if (constantValue instanceof InvalidValue) {
				String resultText = context.getDefiningText(bodyExpression);
//				append(resultText + ";\n");
				s.append("throw (" + resultText + ").getException();\n");
			}
			else {
				String resultText = context.getReferringText(s, bodyExpression);
				s.append("return " + resultText + ";\n");
			}	// FIXME maybeInvalid check
//			if (analysis.getTransitiveInvalidSources().size() > 0) {
//				appendThrowCheck(symbolName);
//			}
		}
		return s;
	}

	@Override
	public @NonNull CodeGenSnippet visitIfExp(@NonNull IfExp element) {
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
		s.append("if (");
		s.appendReference(DomainUtil.nonNullModel(element.getCondition()));
		s.append(") {\n");
		s.pushIndentation();
		s.append(visit(DomainUtil.nonNullModel(element.getThenExpression())));
		s.popIndentation();
		s.append("}\n");
		s.append("else {\n");
		s.pushIndentation();
		s.append(visit(DomainUtil.nonNullModel(element.getElseExpression())));
		s.popIndentation();
		s.append("}\n");
		return s;
	}

	@Override
	public @NonNull CodeGenSnippet visitIntegerLiteralExp(@NonNull IntegerLiteralExp element) {
		return context.getConstant(element.getIntegerSymbol());
	}

	@Override
	public @NonNull CodeGenSnippet visitInvalidLiteralExp(@NonNull InvalidLiteralExp element) {
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
		s.append("throwInvalidValueException();");
		return s;
	}

	@Override
	public @NonNull CodeGenSnippet visitIteratorExp(@NonNull IteratorExp element) {
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
		Iteration referredIteration = DomainUtil.nonNullModel(element.getReferredIteration());
		OCLExpression source = element.getSource();
		OCLExpression body = element.getBody();
		List<Parameter> ownedIterators = referredIteration.getOwnedIterator();
		int arity = ownedIterators.size();
		String operationTypeName = context.getImportedName(context.getAbstractOperationClass(ownedIterators));
		String iterationTypeName = context.getImportedName(LibraryIteration.class);
		String astName = getSymbolName(element);
		String sourceName = getSymbolName(source);
		String typeId = s.getConstantName(element.getTypeId());
		String bodyType = s.getConstantName(body.getTypeId());
		String referredIterationName = context.getQualifiedLiteralName(referredIteration);
		String managerTypeName = context.getImportedName(arity == 1 ? ExecutorSingleIterationManager.class : ExecutorDoubleIterationManager.class); 	// FIXME ExecutorMultipleIterationManager
		String domainEvaluatorName = context.getImportedName(DomainEvaluator.class);
		String typeIdName = context.getImportedName(TypeId.class);
		String atNonNull = atNonNull();
		String atNullable = atNullable();
		String standardLibraryName = context.getStandardLibrary(s).getName();
		String evaluatorName = context.getEvaluatorName();
		
		s.append("/**\n"); 
		s.append(" * Implementation of the iterator body.\n");
		s.append(" */\n");
		s.append(operationTypeName + " body_" + astName + " = new " + operationTypeName + "()\n");
		s.append("{\n");
		s.append("/*\n");
//		[ast.body.prettyPrint().trim()/]
		s.append(" */\n");
		s.pushIndentation();
			s.append("@Override\n");
			s.append("public " + atNullable + " Object evaluate(" +
				atNonNull + " " + domainEvaluatorName + " " + evaluatorName + ", " +
				atNonNull + " " + typeIdName + " returnTypeId, " +
				atNullable + " Object sourceValue");
			for (int i = 0; i < arity; i++) {
				s.append(", " + atNullable + " Object iterator" + i);
			}
			s.append(") throws Exception {\n");
			s.pushIndentation();
				for (int i = 0; i < arity; i++) {
					s.append("final Object " + "xx/*getSymbolName(ownedIterators.get(i))*/"  + " = iterator" + i + ";\n");
				}  
				s.append(visit(body));
				s.append("return " + getSymbolName(body) + ";\n");
			s.popIndentation();
			s.append("}\n");
		s.popIndentation();
		s.append("};\n");
		if (source != null) {
//			if (mayEvaluateFor(referredProperty, metaModelManager.getOclInvalidType())) {		// If property processes invalid, must catch any incoming exceptions as invalid values.
				 appendCatchingStatement(s, null, source);
//			}
//			else {																				// If property propagates invalid, must throw exceptions for any incoming invalid values
//				appendThrowingStatement(s, source);
//			}
		}
		s.append(context.getImportedName(DomainType.class) + " static_" + astName + " = " + evaluatorName + ".getStaticTypeOf(" + sourceName + ");\n");
		s.append(iterationTypeName + " dynamic_" + astName + " = (" + iterationTypeName + ")static_" + astName + ".lookupImplementation(" + standardLibraryName + ", " + referredIterationName + ");\n");
		s.append("Object acc_" + astName + " = dynamic_" + astName + ".createAccumulatorValue(" + evaluatorName + ", " + typeId + ", " + bodyType + ");\n");
		s.append(managerTypeName + " manager_" + astName + " = new " + managerTypeName + "(" + evaluatorName + ", " + typeId + ", body_" + astName + ", (" + context.getImportedName(CollectionValue.class) + ")" + sourceName + ", acc_" + astName + ");\n");
		s.append("Object " + astName + " = dynamic_" + astName+ ".evaluateIteration(manager_" + astName + ");\n");
		return s;
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
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
		Variable letVariable = element.getVariable();
		OCLExpression initExpression = letVariable.getInitExpression();
		if (initExpression != null) {
			CodeGenAnalysis initAnalysis = context.getAnalysis(initExpression);
			if (!initAnalysis.isInlineable()) {
				 appendCatchingStatement(s, letVariable, initExpression);
			}
		}
		OCLExpression inExpression = DomainUtil.nonNullModel(element.getIn());
		CodeGenAnalysis inAnalysis = context.getAnalysis(inExpression);
		if (!inAnalysis.isInlineable()) {
			getSymbolName(inExpression, letVariable.getName());
			s.append(visit(inExpression));
		}
		String resultName = getSymbolName(element, "let");
		s.append("final Object " + resultName + " = " + context.getReferringText(s, inExpression) + ";\n");
//		CodeGenAnalysis analysis = context.getAnalysis(inExpression);
//		if (analysis.getTransitiveInvalidSources().size() > 0) {
//			appendThrowCheck(resultName);
//		}
		return s;
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
	public @NonNull CodeGenSnippet visitOCLExpression(@NonNull OCLExpression element) {
		CodeGenAnalysis analysis = context.getAnalysis(element);
		if (analysis.isConstant()) {
			return context.getConstant(element);
		}
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
		String symbolName = getSymbolName(element);
		s.append("final " + atNonNull() + " Object " + symbolName + " = " + context.getDefiningText(element) + ";\n");	
		if (analysis.mayBeInvalidValue()) {
			appendThrowCheck(s, symbolName);
		}
		return s;
	}

/*	@Override
	public @NonNull CodeGenSnippet visitOperation(@NonNull Operation element) {
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
		String symbolName = getSymbolName(element);
		s.append("final " + atNonNull() + " " + context.getImportedName(ExecutorOperation.class) + " " + symbolName + " = " + context.getQualifiedLiteralName(element) + ";\n");	
		return s;
	} */

	@Override
	public @NonNull CodeGenSnippet visitOperationCallExp(@NonNull OperationCallExp element) {
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
		Operation referredOperation = DomainUtil.nonNullModel(element.getReferredOperation());
		OCLExpression source = element.getSource();
		List<OCLExpression> arguments = DomainUtil.nonNullEMF(element.getArgument());
		//
		//	Assign each source and argument to a Java variable, unless the source/argument is simple enough to be inlineable.
		//
		if (mayEvaluateFor(referredOperation, metaModelManager.getOclInvalidType())) {		// If operation processes invalid, must catch any incoming exceptions as invalid values.
			if (source != null) {
				 appendCatchingStatement(s, null, source);
			}
			for (OCLExpression argument : arguments) {
				if (argument != null) {
					 appendCatchingStatement(s, null, argument);
				}
			}
		}
		else {																				// If operation propagates invalid, must throw exceptions for any incoming invalid values
			if (source != null) {
				appendThrowingStatement(s, source);
			}
			for (OCLExpression argument : arguments) {
				if (argument != null) {
					appendThrowingStatement(s, argument);
				}
			}
		}
		//
		//	Call the operation with the appropriate arguments.
		//
		String evaluatorName = context.getEvaluatorName();
		String resultSymbolName = getSymbolName(element, referredOperation.getName());
		String sourceText = source != null ? context.getReferringText(s, source) : "null";
		String typeIdName = s.getConstantName(element.getTypeId());
		if (isFinal(referredOperation)) {
			String className = getImplementationName(referredOperation);
			s.append("final Object " + resultSymbolName + " = " + className + ".evaluate(" + evaluatorName + ", " + typeIdName);
			s.append(", " + sourceText);
			for (OCLExpression argument : arguments) {
				assert argument != null;
				s.append(", " + context.getReferringText(s, argument));
			}
			s.append(");\n");
		}
		else {
			String standardLibraryName = context.getStandardLibrary(s).getName();
			String operationTypeName = context.getImportedName(context.getOperationInterface(arguments));
			String operationName = context.getQualifiedLiteralName(referredOperation); //context.getConstantName(referredOperation);
			String staticImplementationName = nameManager.reserveName("static_" + referredOperation.getName(), null);
			String dynamicImplementationName = nameManager.reserveName("dynamic_" + referredOperation.getName(), null);
			s.append("final " + context.getImportedName(DomainType.class) + " " + staticImplementationName + " = ");
			s.append(evaluatorName + ".getStaticTypeOf(" + sourceText);
			for (OCLExpression argument : arguments) {
				assert argument != null;
				String referredSymbolName = context.getReferringText(s, argument);
				if ((arguments.size() == 1) && "null".equals(referredSymbolName)) {
					s.append(", (Object)" + referredSymbolName);
				}
				else {
					s.append(", " + referredSymbolName);
				}
			}
			s.append(");\n");
			s.append("final " + operationTypeName + " " + dynamicImplementationName + " = (" + operationTypeName + ")" + staticImplementationName + ".lookupImplementation(" + standardLibraryName + ", " + operationName + ");\n");
			s.append("final Object " + resultSymbolName + " = " + dynamicImplementationName + ".evaluate(" + evaluatorName + ", " + typeIdName + ", " + sourceText);
			for (OCLExpression argument : arguments) {
				assert argument != null;
				s.append(", " + context.getReferringText(s, argument));
			}
			s.append(");\n");
		}
		return s;
	}
	
/*	@Override
	public @NonNull CodeGenSnippet visitPrimitiveType(@NonNull PrimitiveType element) {
		String symbolName = getSymbolName(element);
		context.append("final " + atNonNull() + " " + context.getImportedName(ExecutorType.class) + " " + symbolName + " = " + "context.getQualifiedLiteralName(element)" + ";\n");	
		return symbolName;
	} */

	@Override
	public @NonNull CodeGenSnippet visitPropertyCallExp(@NonNull PropertyCallExp element) {
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
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
		//
		//	Assign each source and argument to a Java variable, unless the source/argument is simple enough to be inlineable.
		//
		if (source != null) {
//			if (mayEvaluateFor(referredProperty, metaModelManager.getOclInvalidType())) {		// If property processes invalid, must catch any incoming exceptions as invalid values.
				 appendCatchingStatement(s, null, source);
//			}
//			else {																				// If property propagates invalid, must throw exceptions for any incoming invalid values
//				appendThrowingStatement(s, source);
//			}
		}
		//
		//	Call the property with the appropriate arguments.
		//
		String evaluatorName = context.getEvaluatorName();
		String resultSymbolName = getSymbolName(element, referredProperty.getName());
		String sourceText = getSymbolName(source); //"s.getConstantName(source)"; //source != null ? context.getReferringText(s, source) : "null";
		String typeIdName = s.getConstantName(element.getTypeId());
		String className = getImplementationName(referredProperty);
		s.append("final Object " + resultSymbolName + " = " + className + ".evaluate(" + evaluatorName + ", " + typeIdName);
		s.append(", " + sourceText);
		s.append(");\n");
		return s;
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
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
		Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		OCLExpression source = element.getSource();
		assert source != null;
		appendCatchingStatement(s, null, source);
		String implementationClass = referredProperty.getImplementationClass();
		String className;
		if (implementationClass != null) {
			className = context.getImportedName(implementationClass) + ".INSTANCE";
		}
		else {
			className = context.getQualifiedLiteralName(referredProperty);
		}
		String typeIdName = s.getConstantName(element.getTypeId());
		String resultName = getSymbolName(element);
		String sourceName = getSymbolName(source);
		s.append("final Object " + resultName + " = " + className + ".evaluate(" + context.getEvaluatorName() + ", " + typeIdName + ", " + sourceName + ");\n");
		return s;
	}

	@Override
	public @NonNull CodeGenSnippet visitRealLiteralExp(@NonNull RealLiteralExp element) {
		return context.getConstant(element.getRealSymbol());
	}

	@Override
	public @NonNull CodeGenSnippet visitStringLiteralExp(@NonNull StringLiteralExp element) {
		return context.getConstant(element.getStringSymbol());
	}

	protected @NonNull CodeGenSnippet visitTuplePartCallExp(@NonNull PropertyCallExp element) {
		@NonNull CodeGenSnippet s = new CodeGenSnippet(context, element);
		Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		OCLExpression source = element.getSource();
		assert source != null;
		String tuplePartName = referredProperty.getName();
		TupleType tupleType = (TupleType) source.getType();
		List<String> names = new ArrayList<String>(tupleType.getOwnedAttribute().size());
		for (Property tuplePart : tupleType.getOwnedAttribute()) {
			names.add(tuplePart.getName());
		}
		Collections.sort(names);										// FIXME maintain sorted list in TupleType
		int tuplePartIndex = names.indexOf(tuplePartName);
		appendCatchingStatement(s, null, source);
		String tupleValueName = getCastSymbolName(TupleValue.class, source);
		String resultName = getSymbolName(element);
		s.append("final Object " + resultName + " = (" + tupleValueName + ").getValue(" + tuplePartIndex + ");/n");
		return s;
	}

	@Override
	public @NonNull CodeGenSnippet visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp element) {
		return context.getConstant(element.getUnlimitedNaturalSymbol());
	}

//	@Override
//	public @NonNull CodeGenSnippet visitVariableExp(@NonNull VariableExp element) {
//		VariableDeclaration referredVariable = element.getReferredVariable();
//		if (referredVariable)
//		return context.getConstant(referredVariable.UnlimitedNaturalSymbol());
//	}

	public @NonNull CodeGenSnippet visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Statement: " + visitable.getClass().getName());
	}
}
