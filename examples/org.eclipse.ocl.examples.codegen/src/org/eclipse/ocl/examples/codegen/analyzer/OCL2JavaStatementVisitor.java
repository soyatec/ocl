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
package org.eclipse.ocl.examples.codegen.analyzer;

import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.LiteralExp;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.ReferringElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
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
public class OCL2JavaStatementVisitor extends AbstractExtendingVisitor<String, OCLCodeGenerator>
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull NameManager nameManager;
	protected final @NonNull OCL2JavaExpressionVisitor expressionVisitor;
	protected /*@LazyNonNull*/ String invalidValueName = null;
	
	public OCL2JavaStatementVisitor(@NonNull OCLCodeGenerator codeGenerator) {
		super(codeGenerator);
		metaModelManager = codeGenerator.getMetaModelManager();
		nameManager = codeGenerator.getNameManager();
		expressionVisitor = context.getExpressionVisitor();
	}

	/**
	 * Emit a statement that assigns the value of anExpression to its designated symbol catching
	 * an exception thrown during computation of anExpression and assigning an InvalidValue to
	 * the symbol to preserve the caught exception.
	 */
	protected void  appendCatchingStatement(@Nullable Variable aVariable, @NonNull OCLExpression anExpression) {
		CodeGenAnalysis analysis = context.getNode(anExpression);
		if (isInlineable(anExpression)) { /* Nothing to do */}
		else if (analysis.isStaticConstant()) {
			if (analysis.getReferredCommonSubExpression() == null) {
				context.getStaticConstantName(getConstant(anExpression));
			}
		}
		else if (analysis.isLocalConstant()) {
			if (analysis.getReferredCommonSubExpression() == null) {
				context.getLocalConstantName(getConstant(anExpression));
			}
		}
		else {
			String symbolName = getSymbolName(aVariable);
//			String generatedComputation = expressionVisitor.visit(anExpression);
			if (mayBeException(anExpression)) {
				context.append("Object " + symbolName + ";\n");
				context.append("try {\n");
				context.pushIndentation();
//				context.append(symbolName + " = " + generatedComputation + ";\n");
				anExpression.accept(this);
				context.popIndentation();
				context.append("}\n");
				context.append("catch (Exception e) {\n");
				context.pushIndentation();
				context.append(symbolName + " = new " + context.getImportedName(InvalidValueImpl.class) + "(e);\n");
				context.popIndentation();
				context.append("}\n");
			}
			else {
//				context.append("final Object " + symbolName + " = " + generatedComputation + ";\n");
				anExpression.accept(this);
			}
		}
	}

	/**
	 * Emit a statement that assigns the value of anExpression to its designated symbol throwing
	 * an exception in the event that computation of anException results an InvalidValue.
	 */
	protected void appendThrowingStatement(@NonNull OCLExpression anExpression) {
		CodeGenAnalysis analysis = context.getNode(anExpression);
		if (isInlineable(anExpression)) {
//			if (analysis.getTransitiveInvalidSources().size() > 0) {
//				context.append("throwNewInvalidException();\n");
//			}
		}
		else if (analysis.isStaticConstant()) {
			if (analysis.getReferredCommonSubExpression() == null) {
				context.getStaticConstantName(getConstant(anExpression));
			}
		}
		else if (analysis.isLocalConstant()) {
			if (analysis.getReferredCommonSubExpression() == null) {
				context.getLocalConstantName(getConstant(anExpression));
			}
		}
		else {
			String symbolName;
			if (anExpression instanceof VariableExp) {
				symbolName = getSymbolName(((VariableExp)anExpression).getReferredVariable());
			}
			else {
//				String generatedComputation = expressionVisitor.visit(anExpression);
//				context.append("final Object " + symbolName + " = " + generatedComputation + ";\n");
				anExpression.accept(this);
				symbolName = getSymbolName(anExpression);
			}
			if (mayBeInvalidValue(anExpression)) {
				appendThrowCheck(symbolName);
			}
		}
	}

	protected void appendThrowCheck(String symbolName) {
		String invalidValueName = getInvalidValueName();
		context.append("if (" + symbolName + " instanceof " + invalidValueName + ") ");
		context.append("throw ((" + invalidValueName + ")" + symbolName + ").getException();\n");
	}

	protected String atNonNull() {
		return context.atNonNull();
	}

	protected String atNullable() {
		return context.atNullable();
	}

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
	
	protected @NonNull String getInvalidValueName() {
		String invalidValueName2 = invalidValueName;
		if (invalidValueName2 == null) {
			invalidValueName = invalidValueName2 = context.getImportedName(InvalidValue.class);
		}
		return invalidValueName2;
	}

	protected @NonNull String getReferredSymbolName(@NonNull TypedElement element) {
		CodeGenAnalysis analysis = context.getNode(element);
		if (analysis.isInlineable()) {
			return expressionVisitor.visit(element);
		}
		VariableDeclaration referredVariable = null;
		CommonSubExpression referredCommonSubExpression = analysis.getReferredCommonSubExpression();
		if (referredCommonSubExpression != null) {
			referredVariable = referredCommonSubExpression.getVariable();
		}
		else if (element instanceof TypeExp) {
			return getSymbolName(element.getType());
		}
		else if (element instanceof VariableExp) {
			referredVariable = ((VariableExp)element).getReferredVariable();
		}
		if (referredVariable == null) {
			return getSymbolName(element);
		}
		else {
			return expressionVisitor.visit(referredVariable);
		}
	}

	protected @NonNull String getReferredValueText(@NonNull TypedElement element) {
		CodeGenAnalysis analysis = context.getNode(element);
		if (analysis.isInlineable()) {
			return expressionVisitor.visit(element);
		}
		VariableDeclaration referredVariable = null;
		CommonSubExpression referredCommonSubExpression = analysis.getReferredCommonSubExpression();
		if (referredCommonSubExpression != null) {
			referredVariable = referredCommonSubExpression.getVariable();
		}
		else if (element instanceof VariableExp) {
			referredVariable = ((VariableExp)element).getReferredVariable();
		}
		if (referredVariable == null) {
			return expressionVisitor.visit(element);
		}
		else {
			return expressionVisitor.visit(referredVariable);
		}
	}

	protected @NonNull String getSymbolName(@Nullable Element element, @Nullable String... nameHints) {
		return element != null ? nameManager.getSymbolName(element, nameHints) : "null";
	}

	protected String getTypeDeclarator(@NonNull TypedElement element) {
		Type type = element.getType();
		TypeId typeId = type.getTypeId();
		return typeId.accept(context.getIdVisitor());
	}

	protected boolean isFinal(@NonNull Operation anOperation) {
		FinalAnalysis finalAnalysis = metaModelManager.getPackageManager().getFinalAnalysis();
		return finalAnalysis.isFinal(anOperation);
	}

	protected boolean isInlineable(@NonNull TypedElement element) {
		CodeGenAnalysis analysis = context.getNode(element);
		if (analysis.isInlineable()) {
			return true;
		}
		if (element instanceof VariableExp) {
			VariableDeclaration referredVariable = ((VariableExp)element).getReferredVariable();
			if (referredVariable instanceof Variable) {
				OCLExpression initExpression = ((Variable)referredVariable).getInitExpression();
				if (initExpression != null) {
					CodeGenAnalysis initAnalysis = context.getNode(initExpression);
					if (initAnalysis.isInlineable()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Return true if anExpression may be an invalid value thrown as an exception, such as propagated invalid.
	 */
	protected boolean mayBeException(@Nullable OCLExpression anExpression) {
		if ((anExpression == null) || (anExpression instanceof VariableExp)) {
			return false;
		}
		CodeGenAnalysis analysis = context.getNode(anExpression);
		Set<CodeGenAnalysis> invalidSources = analysis.getInvalidSources();
		return (invalidSources != null) && (invalidSources.size() > 0);
	}

	/**
	 * Return true if anExpression may be an invalid value passed by value, such as a result cached in a let expression.
	 */
	protected boolean mayBeInvalidValue(@Nullable OCLExpression anExpression) {
		while (anExpression instanceof VariableExp) {
			VariableDeclaration referredVariable = ((VariableExp)anExpression).getReferredVariable();
			anExpression = referredVariable instanceof Variable ? ((Variable)referredVariable).getInitExpression() : null;
		}
		if (anExpression == null) {
			return false;
		}
		CodeGenAnalysis analysis = context.getNode(anExpression);
		Set<CodeGenAnalysis> invalidSources = analysis.getInvalidSources();
		return (invalidSources != null) && (invalidSources.size() > 0);
	}

	/**
	 * Return true if anExpression may be a null value.
	 * <p>
	 * This takes no account of invalid values even though they 'conform' to null.
	 */
	protected boolean mayBeNullValue(@Nullable OCLExpression anExpression) {
		if (anExpression == null) {
			return false;
		}
		CodeGenAnalysis analysis = context.getNode(anExpression);
		Set<CodeGenAnalysis> nullSources = analysis.getNullSources();
		return (nullSources != null) && (nullSources.size() > 0);
	}

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
	public @Nullable String visitCollectionItem(@NonNull CollectionItem element) {
		OCLExpression item = element.getItem();
		item.accept(this);
		return getSymbolName(item);
	}

	@Override
	public @Nullable String visitCollectionLiteralExp(@NonNull CollectionLiteralExp element) {
		CodeGenAnalysis analysis = context.getNode(element);
//		if (analysis.getTransitiveInvalidSources().size() > 0) {
//			context.append("throwInvalidValueException();");
//			return null;
//		}
		CollectionType collectionType = (CollectionType) element.getType();
		StringBuilder partArgs = new StringBuilder();
		List<CollectionLiteralPart> parts = element.getPart();
		for (CollectionLiteralPart part : parts) {
			partArgs.append(", " + part.accept(this));
		}
		String collectionName = getSymbolName(element);
		String collectionTypeIdName = context.getIdName(collectionType.getTypeId());
//		if (collectionType.isOrdered() && (parts.size() == 1) && (parts.get(0) instanceof CollectionRange)) {
//			String createCollectionName = "create" + element.getKind() + "Range";
//			CollectionRange range = (CollectionRange) parts.get(0);
//			context.append("final " + atNonNull() + " Object " + collectionName + " = " + createCollectionName + "(" + collectionTypeIdName);
//			context.append(", createRange(" + firstName + ", " + lastName + "));");
//		}
//		else {	// FIXME folding
		String createCollectionName = "create" + element.getKind() + "Value";
		context.append("final " + atNonNull() + " Object " + collectionName + " = " + createCollectionName + "(" + collectionTypeIdName + partArgs + ");\n");
		return collectionName;
//		}
/*		[ast.type.emitConstants(genPackage, expInOcl)/]
				[if (not ast.isConstantCollectionLiteralExp())]
				[for (part : CollectionLiteralPart | ast.part)]
				[part.emitConstants(genPackage, expInOcl)/]
				[/for]
				[debug(ast, 'nonConstant')/]
				[elseif ((ast.part->size() = 1) and ast.type.oclIsKindOf(SequenceType) and ast.part->at(1).oclIsKindOf(CollectionRange))]
				[for (part : CollectionLiteralPart | ast.part)]
				[part.emitConstants(genPackage, expInOcl)/]
				[/for]
				[let range : CollectionRange = ast.part->at(1).oclAsType(CollectionRange)]
				[debug(ast, 'oneRange')/]
				static final @NonNull Object [ast.symbolName(expInOcl)/] = create[ast.kind.toString()/]Range([ast.type.typeId(expInOcl)/], createRange([range.first.symbolName(expInOcl)/], [range.last.symbolName(expInOcl)/]));[/let]
				[else]
				[let folded : CollectionLiteralExp = if ast.isFoldable() then ast.evaluate().oclAsType(CollectionLiteralExp) else ast endif]
				[debug(folded, 'folded')/]
				[for (part : CollectionLiteralPart | folded.part)]
				[debug(part, 'foldedPart')/]
				[part.emitConstants(genPackage, expInOcl)/]
				[/for]
				static final @NonNull Object [ast.symbolName(expInOcl)/] = create[folded.kind.toString()/]Value([folded.type.typeId(expInOcl)/][for (part : CollectionLiteralPart | folded.part)], [part.oclAsType(CollectionItem).item.symbolName(expInOcl)/][/for]);[/let]
				[/if] */
	}

	@Override
	public @Nullable String visitCollectionRange(@NonNull CollectionRange element) {
		String firstName = element.getFirst().accept(this);
		String lastName = element.getLast().accept(this);
		String integerValueCast = "(" + context.getImportedName(IntegerValue.class) + ")";
		return "createRange(" + integerValueCast + firstName + ", " + integerValueCast + lastName + ")";
	}

//	@Override
//	public @Nullable String visitExpressionInOCL(@NonNull ExpressionInOCL element) {
//		return element.getBodyExpression().accept(this);
//	}

	@Override
	public @Nullable String visitInvalidLiteralExp(@NonNull InvalidLiteralExp element) {
		context.append("throwInvalidValueException();");
		return null;
	}

	@Override
	public @Nullable String visitLetExp(@NonNull LetExp element) {
		Variable letVariable = element.getVariable();
		OCLExpression initExpression = letVariable.getInitExpression();
		if (initExpression != null) {
			CodeGenAnalysis initAnalysis = context.getNode(initExpression);
			if (!initAnalysis.isInlineable()) {
				 appendCatchingStatement(letVariable, initExpression);
			}
		}
		OCLExpression inExpression = DomainUtil.nonNullModel(element.getIn());
		if (!isInlineable(inExpression)) {
			getSymbolName(inExpression, letVariable.getName());
			inExpression.accept(this);
		}
		String resultName = getSymbolName(element, "let");
		context.append("final Object " + resultName + " = " + getReferredSymbolName(inExpression) + ";\n");
		CodeGenAnalysis analysis = context.getNode(inExpression);
		if (analysis.getTransitiveInvalidSources().size() > 0) {
			appendThrowCheck(resultName);
		}
		return null;
	}

	@Override
	public @Nullable String visitLiteralExp(@NonNull LiteralExp element) {
		CodeGenAnalysis analysis = context.getNode(element);
//		if (analysis.getTransitiveInvalidSources().size() > 0) {
//			context.append("throwInvalidValueException();");
//			return null;
//		}
//		else {
			return super.visitLiteralExp(element);
//		}
	}
	
	@Override
	public @Nullable String visitMetaclass(@NonNull Metaclass element) {
		String symbolName = getSymbolName(element);
		String typeValueName = context.getImportedName(TypeValue.class);
		String evaluatorName = context.getEvaluatorName();
		String typeIdName = element.getInstanceType().getTypeId().accept(context.getIdVisitor());
		context.append("final " + atNonNull() + " " + typeValueName + " " + symbolName + " = createTypeValue(" + evaluatorName + ".getIdResolver().getType(" + typeIdName + ", null));\n");	
		return symbolName;
	}

	@Override
	public @Nullable String visitOCLExpression(@NonNull OCLExpression element) {
		CodeGenAnalysis analysis = context.getNode(element);
		String symbolName = getSymbolName(element);
		context.append("final " + atNonNull() + " Object " + symbolName + " = " + getReferredValueText(element) + ";\n");	
		if (analysis.getTransitiveInvalidSources().size() > 0) {
			appendThrowCheck(symbolName);
		}
		return symbolName;
	}

	@Override
	public @Nullable String visitOperation(@NonNull Operation element) {
		String symbolName = getSymbolName(element);
		context.append("final " + atNonNull() + " " + context.getImportedName(ExecutorOperation.class) + " " + symbolName + " = " + context.getQualifiedLiteralName(element) + ";\n");	
		return symbolName;
	}

	@Override
	public @Nullable String visitOperationCallExp(@NonNull OperationCallExp element) {
		Operation referredOperation = DomainUtil.nonNullModel(element.getReferredOperation());
		OCLExpression source = element.getSource();
		List<OCLExpression> arguments = DomainUtil.nonNullEMF(element.getArgument());
		//
		//	Assign each source and argument to a Java variable, unless the source/argument is simple enough to be inlineable.
		//
		if (mayEvaluateFor(referredOperation, metaModelManager.getOclInvalidType())) {		// If operation processes invalid, must catch any incoming exceptions as invalid values.
			if (source != null) {
				 appendCatchingStatement(null, source);
			}
			for (OCLExpression argument : arguments) {
				if (argument != null) {
					 appendCatchingStatement(null, argument);
				}
			}
		}
		else {																				// If operation propagates invalid, must throw exceptions for any incoming invalid values
			if (source != null) {
				appendThrowingStatement(source);
			}
			for (OCLExpression argument : arguments) {
				if (argument != null) {
					appendThrowingStatement(argument);
				}
			}
		}
		//
		//	Call the operation with the appropriate arguments.
		//
		String evaluatorName = context.getEvaluatorName();
		String resultSymbolName = getSymbolName(element, referredOperation.getName());
		String sourceSymbolName = source != null ? getReferredSymbolName(source) : "null";
		if (isFinal(referredOperation)) {
			String className = getImplementationName(referredOperation);
			context.append("final Object " + resultSymbolName + " = " + className + ".evaluate(" + evaluatorName + ", " + getTypeDeclarator(element));
			context.append(", " + sourceSymbolName);
			for (OCLExpression argument : arguments) {
				assert argument != null;
				context.append(", " + getReferredSymbolName(argument));
			}
			context.append(");\n");
		}
		else {
			String standardLibraryName = context.getStandardLibraryName();
			String operationTypeName = context.getImportedName(context.getOperationInterface(arguments));
			String operationName = context.getStaticConstantName(referredOperation);
			String staticImplementationName = nameManager.reserveName("static_" + referredOperation.getName(), null);
			String dynamicImplementationName = nameManager.reserveName("dynamic_" + referredOperation.getName(), null);
			context.append("final " + context.getImportedName(DomainType.class) + " " + staticImplementationName + " = ");
			context.append(evaluatorName + ".getStaticTypeOf(" + sourceSymbolName);
			for (OCLExpression argument : arguments) {
				assert argument != null;
				String referredSymbolName = getReferredSymbolName(argument);
				if ((arguments.size() == 1) && "null".equals(referredSymbolName)) {
					context.append(", (Object)" + referredSymbolName);
				}
				else {
					context.append(", " + referredSymbolName);
				}
			}
			context.append(");\n");
			context.append("final " + operationTypeName + " " + dynamicImplementationName + " = (" + operationTypeName + ")" + staticImplementationName + ".lookupImplementation(" + standardLibraryName + ", " + operationName + ");\n");
			context.append("final Object " + resultSymbolName + " = " + dynamicImplementationName + ".evaluate(" + evaluatorName + ", " + getTypeDeclarator(element) + ", " + sourceSymbolName);
			for (OCLExpression argument : arguments) {
				assert argument != null;
				context.append(", " + getReferredSymbolName(argument));
			}
			context.append(");\n");
		}
		return resultSymbolName;
	}
	
	@Override
	public @Nullable String visitPrimitiveType(@NonNull PrimitiveType element) {
		String symbolName = getSymbolName(element);
		context.append("final " + atNonNull() + " " + context.getImportedName(ExecutorType.class) + " " + symbolName + " = " + "context.getQualifiedLiteralName(element)" + ";\n");	
		return symbolName;
	}

	public @NonNull String visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Statement: " + visitable.getClass().getName());
	}
}
