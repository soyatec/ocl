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

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.LiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.FinalAnalysis;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * An OCL2JavaStatementVisitor appends one or more Java statements to an OCLCodeGenerator
 * to realize the code for a Pivot AST node.
 * <p>
 * Derived visitors may support an extended AST.
 */
public class OCL2JavaStatementVisitor extends OCL2JavaExpressionVisitor
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull OCL2JavaExpressionVisitor expressionVisitor;
	protected /*@LazyNonNull*/ String invalidValueName = null;
	
	public OCL2JavaStatementVisitor(@NonNull OCLCodeGenerator codeGenerator) {
		super(codeGenerator);
		metaModelManager = codeGenerator.getMetaModelManager();
		expressionVisitor = context.getExpressionVisitor();
	}

	protected String atNonNull() {
		return context.atNonNull();
	}

	protected String atNullable() {
		return context.atNullable();
	}

	/**
	 * Emit a statement that assigns the value of anExpression to its designated symbol catching
	 * an exception thrown during computation of anExpression and assigning an InvalidValue to
	 * the symbol to preserve the caught exception.
	 */
	protected void emitCatchingStatement(@Nullable Variable aVariable, @NonNull OCLExpression anExpression) {
		if (!isInlineable(anExpression)) {
			String symbolName = getSymbolName(aVariable);
			String generatedComputation = expressionVisitor.visit(anExpression);
			if (mayBeException(anExpression)) {
				context.append("Object " + symbolName + ";\n");
				context.append("try {\n");
				context.pushIndentation();
				context.append(symbolName + " = " + generatedComputation + ";\n");
				context.popIndentation();
				context.append("}\n");
				context.append("catch (Exception e) {\n");
				context.pushIndentation();
				context.append(symbolName + " = new " + context.getImportedName(InvalidValueImpl.class) + "(e);\n");
				context.popIndentation();
				context.append("}\n");
			}
			else {
				context.append("final Object " + symbolName + " = " + generatedComputation + ";\n");
			}
		}
	}

	/**
	 * Emit a statement that assigns the value of anExpression to its designated symbol throwing
	 * an exception in the event that computation of anException results an InvalidValue.
	 */
	protected void emitThrowingStatement(@NonNull OCLExpression anExpression) {
		CodeGenAnalysis analysis = context.getNode(anExpression);
		if (!analysis.isConstant() && !analysis.isInlineable()) {
			String symbolName;
			if (anExpression instanceof VariableExp) {
				symbolName = getSymbolName(((VariableExp)anExpression).getReferredVariable());
			}
			else {
				symbolName = getSymbolName(anExpression);
				String generatedComputation = expressionVisitor.visit(anExpression);
				context.append("final Object " + symbolName + " = " + generatedComputation + ";\n");
			}
			if (mayBeInvalidValue(anExpression)) {
				String invalidValueName = getInvalidValueName();
				context.append("if (" + symbolName + " instanceof " + invalidValueName + ") ");
				context.append("throw ((" + invalidValueName + ")" + symbolName + ").getException();\n");
			}
		}
	}

	private String emitTypeOf(OCLExpression source) {
		// TODO Auto-generated method stub
		return null;
	}

	protected @Nullable GenPackage getGenPackage(@NonNull Type type) {
		org.eclipse.ocl.examples.pivot.Package pPackage = type.getPackage();
		if (pPackage == null) {
			return null;
		}
		String nsURI = pPackage.getNsURI();
		if (nsURI == null) {
			return null;
		}
		return metaModelManager.getGenPackage(nsURI);
	}

	protected String getImplementationName(@NonNull Operation anOperation) {
		String implementationClass = anOperation.getImplementationClass();
		if (implementationClass != null) {
			return context.getImportedName(implementationClass) + ".INSTANCE";
		}
		List<Constraint> constraints = anOperation.getOwnedRule();
		if (constraints.size() > 0) {
			Type type = anOperation.getOwningType();
			if (type != null) {
				GenPackage genPackage = getGenPackage(type);
				if (genPackage != null) {
					String qualifiedPackageName = genPackage.getQualifiedPackageName() + "." + context.getBodiesPackageName();
					String outerClassName = type.getName() + context.getBodiesClassSuffix();
					String qualifiedClassName = context.getImportedName(qualifiedPackageName + "." + outerClassName);
					String innerClassName = "_" + anOperation.getName() + "_" + constraints.get(0).getStereotype() + "_";
					return qualifiedClassName + "." + innerClassName + ".INSTANCE";
				}
			}
		}	
		return "null";
	}
	
	public @NonNull String getInvalidValueName() {
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
		else if (element instanceof VariableExp) {
			referredVariable = ((VariableExp)element).getReferredVariable();
		}
		if (referredVariable == null) {
			return getSymbolName(element);
		}
		else {
			return expressionVisitor.visit(referredVariable);
		}
/*		if (referredVariable instanceof Variable) {
			OCLExpression initExpression = ((Variable)referredVariable).getInitExpression();
			if (initExpression != null) {
				CodeGenAnalysis initAnalysis = context.getNode(initExpression);
				if (initAnalysis.isInlineable()) {
					return expressionVisitor.visit(initExpression);
				}
			}
		}
		return getSymbolName(referredVariable); */
	}

	protected @NonNull String getSymbolName(@Nullable TypedElement element, @Nullable String... nameHints) {
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
	public @Nullable String visitExpressionInOCL(@NonNull ExpressionInOCL element) {
		return element.getBodyExpression().accept(this);
	}

	@Override
	public @Nullable String visitInvalidLiteralExp(@NonNull InvalidLiteralExp element) {
		return "throwInvalidValueException()";
	}

	@Override
	public @Nullable String visitLetExp(@NonNull LetExp element) {
		Variable letVariable = element.getVariable();
		OCLExpression initExpression = letVariable.getInitExpression();
		if (initExpression != null) {
			CodeGenAnalysis initAnalysis = context.getNode(initExpression);
			if (!initAnalysis.isInlineable()) {
				emitCatchingStatement(letVariable, initExpression);
			}
		}
		OCLExpression inExpression = element.getIn();
		inExpression.accept(this);
		context.append("final Object " + getSymbolName(element, "let") + " = " + getReferredSymbolName(inExpression) + ";\n");	
		return null;
	}

	@Override
	public @Nullable String visitLiteralExp(@NonNull LiteralExp element) {
		return null;
	}

	@Override
	public @Nullable String visitOperationCallExp(@NonNull OperationCallExp element) {
		Operation referredOperation = DomainUtil.nonNullModel(element.getReferredOperation());
		OCLExpression source = element.getSource();
		List<OCLExpression> arguments = DomainUtil.nonNullEMF(element.getArgument());
		//
		//	Assign each source and argument to a Java variable.
		//
		if (mayEvaluateFor(referredOperation, metaModelManager.getOclInvalidType())) {
			if (source != null) {
				emitCatchingStatement(null, source);
			}
			for (OCLExpression argument : arguments) {
				if (argument != null) {
					emitCatchingStatement(null, argument);
				}
			}
		}
		else {
			if (source != null) {
				emitThrowingStatement(source);
			}
			for (OCLExpression argument : arguments) {
				if (argument != null) {
					emitThrowingStatement(argument);
				}
			}
		}
		//
		//	Call the operation with the appropriate arguments.
		//
		String resultSymbolName = getSymbolName(element, referredOperation.getName());
		String sourceSymbolName = source != null ? getReferredSymbolName(source) : "null";
		if (isFinal(referredOperation)) {
			String className = getImplementationName(referredOperation);
			context.append("final Object " + resultSymbolName + " = " + className + ".evaluate(evaluator, " + getTypeDeclarator(element));
			context.append(", " + sourceSymbolName);
			for (OCLExpression argument : arguments) {
				assert argument != null;
				context.append(", " + getReferredSymbolName(argument));
			}
			context.append(");\n");
		}
		else {
			String operationTypeName = context.getImportedName(context.getOperationInterface(arguments));
			String symbolName = getSymbolName(element, "OP_" + referredOperation.getName());
			String staticImplementationName = "static" + symbolName;
			String dynamicImplementationName = "dynamic" + symbolName;
			context.append(context.getImportedName(DomainType.class) + " " + staticImplementationName + " = ");
			emitTypeOf(source);
			for (OCLExpression argument : arguments) {
				assert argument != null;
				context.append(", " + getReferredSymbolName(argument));
			}
			context.append(");\n");
			context.append(operationTypeName + " " + dynamicImplementationName + " = (" + operationTypeName + ")" + staticImplementationName + ".lookupImplementation(standardLibrary, " + getSymbolName(referredOperation) + ");\n");
			context.append("final Object " + resultSymbolName + " = " + dynamicImplementationName + ".evaluate(evaluator, " + getTypeDeclarator(element) + ", " + sourceSymbolName);
			for (OCLExpression argument : arguments) {
				assert argument != null;
				context.append(", " + getReferredSymbolName(argument));
			}
			context.append(");\n");
		}
		return null;
	}
}
