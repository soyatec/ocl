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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstant;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInteger;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGReal;
import org.eclipse.ocl.examples.codegen.cgmodel.CGString;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.ecore.EObjectOperation;
import org.eclipse.ocl.examples.pivot.internal.impl.TuplePartImpl;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * A CGElementVisitor handles the Pivot AST visits on behalf of a CodeGenAnalyzer.
 * Derived visitors may support an extended AST.
 */
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
public class Pivot2CGAnalysisVisitor extends AbstractExtendingVisitor<CGNamedElement, CodeGenAnalyzer>
{
	protected final @NonNull CodeGenerator codeGenerator;
	protected final @NonNull GenModelHelper genModelHelper;

	/*
	 * The pivot to CG parameter map assists in construction of ExpressionInOcl before/without an Operation.
	 */
	private final @NonNull Map<Variable, CGParameter> cgParameters = new HashMap<Variable, CGParameter>();

	private @NonNull Map<VariableDeclaration, CGVariable> variables = new HashMap<VariableDeclaration, CGVariable>();
	
	public Pivot2CGAnalysisVisitor(@NonNull CodeGenAnalyzer analyzer) {
		super(analyzer);
		codeGenerator = context.getCodeGenerator();
		genModelHelper = codeGenerator.getGenModelHelper();
	}

	protected void addParameter(@NonNull Variable aParameter, @NonNull CGParameter cgParameter) {
		cgParameters.put(aParameter, cgParameter);
		variables.put(aParameter, cgParameter);
	}

	public @Nullable CGVariable basicGetParameter(@NonNull Variable aParameter) {
		return cgParameters.get(aParameter);
	}

/*	public @NonNull CGParameter createCGParameter(@NonNull VariableDeclaration pVariable) {
		CGParameter cgParameter = CGModelFactory.eINSTANCE.createCGParameter();
		setPivot(cgParameter, pVariable);
		cgParameter.setTypeId(context.getTypeId(TypeId.OCL_VOID));			// FIXME Java-specific
		return cgParameter;
	} */

	public @NonNull CGVariable createCGVariable(@NonNull Variable pVariable) {
		CGVariable cgVariable = variables.get(pVariable);
		if (cgVariable == null) {
			CGFinalVariable cgVariable2 = CGModelFactory.eINSTANCE.createCGFinalVariable();
			cgVariable = cgVariable2;
			variables.put(pVariable, cgVariable);
		}
		else {
			assert cgVariable.eContainer() == null;
		}
		setPivot(cgVariable, pVariable);
//		cgVariable.setInit(getExpression(pVariable.getInitExpression()));
		return cgVariable;
	}

	public @NonNull CodeGenAnalyzer getAnalyzer() {
		return context;
	}

	public @NonNull CGValuedElement getExpression(@NonNull OCLExpression pivotChild) {
		return (CGValuedElement) safeVisit(pivotChild);
	}

	public @NonNull CGIterator getIterator(@NonNull VariableDeclaration pVariable) {
		CGParameter cgParameter = (CGParameter) variables.get(pVariable);
		if (cgParameter == null) {
			cgParameter = CGModelFactory.eINSTANCE.createCGIterator();
			setPivot(cgParameter, pVariable);
			cgParameter.setTypeId(context.getTypeId(TypeId.OCL_VOID));			// FIXME Java-specific
			variables.put(pVariable, cgParameter);
		}
		return (CGIterator) cgParameter;
	}

	public @NonNull CGParameter getParameter(@NonNull Variable aParameter) {
		CGParameter cgParameter = cgParameters.get(aParameter);
		if (cgParameter == null) {
			cgParameter = CGModelFactory.eINSTANCE.createCGParameter();
			context.setNames(cgParameter, aParameter);
			setPivot(cgParameter, aParameter);
			cgParameter.setTypeId(context.getTypeId(TypeId.OCL_VOID));			// FIXME Java-specific
			addParameter(aParameter, cgParameter);
		}
		return cgParameter;
	}

	public @NonNull CGVariable getSelfParameter(@NonNull Variable aParameter) {
		return getParameter(aParameter);
	}

	public @NonNull CGVariable getVariable(@NonNull VariableDeclaration pVariable) {
		CGVariable cgVariable = variables.get(pVariable);
		if (cgVariable == null) {
			cgVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
			setPivot(cgVariable, pVariable);
			variables.put(pVariable, cgVariable);
		}
		return cgVariable;
	}

	@Override
	public @NonNull CGNamedElement safeVisit(@Nullable Visitable v) {
		Visitable nonNullElement = DomainUtil.nonNullState(v);
		CGNamedElement cg = nonNullElement.accept(this);
		return DomainUtil.nonNullState(cg);
	}

	protected void setPivot(@NonNull CGNamedElement cgElement, @NonNull NamedElement pivotElement) {
		cgElement.setPivot(pivotElement);
		cgElement.setName(pivotElement.getName());
	}

	protected void setPivot(@NonNull CGTypedElement cgElement, @NonNull TypedElement pivotElement) {
		cgElement.setPivot(pivotElement);
		TypeId pivotTypeId = pivotElement.getTypeId();
		cgElement.setTypeId(context.getTypeId(pivotTypeId));
		cgElement.setName(pivotElement.getName());
	}

/*	@Override
	public @Nullable CGElement visitAssociationClassCallExp(@NonNull AssociationClassCallExp element) {
//		CGElement thisAnalysis = context.getCurrentAnalysis();
		return super.visitAssociationClassCallExp(element);
	} */

	@Override
	public @Nullable CGConstantExp visitBooleanLiteralExp(@NonNull BooleanLiteralExp element) {
		CGConstant constant = context.getBoolean(element.isBooleanSymbol());
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, constant);
		setPivot(cgLiteralExp, element);
//		thisAnalysis.initHashSource(DomainUtil.nonNullModel(Boolean.valueOf(element.isBooleanSymbol())));
		return cgLiteralExp;
	}

	@Override
	public @Nullable CGClass visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class element) {
		CGClass cgClass = CGModelFactory.eINSTANCE.createCGClass();
		setPivot(cgClass, element);
		for (Constraint pivotConstraint : element.getOwnedRule()) {
			CGConstraint cgConstraint = (CGConstraint) safeVisit(pivotConstraint);
			cgClass.getInvariants().add(cgConstraint);
		}
		for (Operation pivotOperation : element.getOwnedOperation()) {
			CGOperation cgOperation = (CGOperation) safeVisit(pivotOperation);
			cgClass.getOperations().add(cgOperation);
		}
		for (Property pivotProperty : element.getOwnedAttribute()) {
			CGProperty cgProperty = (CGProperty) safeVisit(pivotProperty);
			cgClass.getProperties().add(cgProperty);
		}
		return cgClass;
	}

	@Override
	public @Nullable CGCollectionPart visitCollectionItem(@NonNull CollectionItem element) {
		CGCollectionPart cgCollectionPart = CGModelFactory.eINSTANCE.createCGCollectionPart();
		setPivot(cgCollectionPart, element);
		cgCollectionPart.setFirst(getExpression(element.getItem()));
		return cgCollectionPart;
	} 

	@Override
	public @Nullable CGCollectionExp visitCollectionLiteralExp(@NonNull CollectionLiteralExp element) {
		CGCollectionExp cgCollectionExp = CGModelFactory.eINSTANCE.createCGCollectionExp();
		setPivot(cgCollectionExp, element);
		cgCollectionExp.setName(element.getKind().getName());
		List<CGCollectionPart> cgParts = cgCollectionExp.getParts();
		for (CollectionLiteralPart pivotPart : element.getPart()) {
			cgParts.add((CGCollectionPart) pivotPart.accept(this));
		}
		context.getTypeId(element.getTypeId());
		return cgCollectionExp;
	}

	@Override
	public @Nullable CGCollectionPart visitCollectionRange(@NonNull CollectionRange element) {
		CGCollectionPart cgCollectionPart = CGModelFactory.eINSTANCE.createCGCollectionPart();
		setPivot(cgCollectionPart, element);
		cgCollectionPart.setFirst(getExpression(element.getFirst()));
		cgCollectionPart.setLast(getExpression(element.getLast()));
		cgCollectionPart.setTypeId(context.getTypeId(TypeId.INTEGER_RANGE));
		return cgCollectionPart;
	}

	@Override
	public @Nullable CGConstraint visitConstraint(@NonNull Constraint element) {
		CGConstraint cgConstraint = CGModelFactory.eINSTANCE.createCGConstraint();
		setPivot(cgConstraint, element);
		ValueSpecification specification = element.getSpecification();
		if (specification != null) {
			ExpressionInOCL expressionInOCL = PivotUtil.getExpressionInOCL(element, specification);
			if (expressionInOCL != null) {
				Variable contextVariable = expressionInOCL.getContextVariable();
				if (contextVariable != null) {
					getSelfParameter(contextVariable);
				}
				for (Variable parameterVariable : expressionInOCL.getParameterVariable()) {
					getParameter(parameterVariable);
				}
				cgConstraint.setBody(getExpression(expressionInOCL.getBodyExpression()));
				OCLExpression messageExpression = expressionInOCL.getMessageExpression();
				if (messageExpression != null) {
					cgConstraint.setMessage(getExpression(messageExpression));
				}
			}
		}
		return cgConstraint;
	}

	@Override
	public @Nullable CGConstructorExp visitConstructorExp(@NonNull ConstructorExp element) {
		CGConstructorExp cgConstructorExp = null;
		Type type = element.getType();
		if (type != null) {
			EObject eTarget = type.getETarget();
			if (eTarget instanceof EDataType) {
				CGEcoreDataTypeConstructorExp cgEConstructorExp = CGModelFactory.eINSTANCE.createCGEcoreDataTypeConstructorExp();
				cgEConstructorExp.setEDataType((EDataType)eTarget);
				cgEConstructorExp.setString(element.getValue());
				cgConstructorExp = cgEConstructorExp;
			}
			else if (eTarget instanceof EClass) {
				CGEcoreClassConstructorExp cgEConstructorExp = CGModelFactory.eINSTANCE.createCGEcoreClassConstructorExp();
				cgEConstructorExp.setEClass((EClass)eTarget);
				cgConstructorExp = cgEConstructorExp;
//				LocalContext localContext = globalContext.getLocalContext(element);
//				if (localContext != null) {
//					CGExecutorType cgExecutorType = localContext.getExecutorType(type);
//					cgTypeExp.setReferredType(cgExecutorType);
//					cgConstructorExp.getDependsOn().add(cgExecutorType);
//				}
			}
		}
		if (cgConstructorExp != null) {
			setPivot(cgConstructorExp, element);
//			context.setNames(cgConstructorExp, element);
			List<CGConstructorPart> cgParts = cgConstructorExp.getParts();
			for (ConstructorPart pivotPart : element.getPart()) {
				cgParts.add((CGConstructorPart) pivotPart.accept(this));
			}
		}
		return cgConstructorExp;
	}

	@Override
	public @Nullable CGConstructorPart visitConstructorPart(@NonNull ConstructorPart element) {
		CGConstructorPart cgConstructorPart = CGModelFactory.eINSTANCE.createCGConstructorPart();
		setPivot(cgConstructorPart, element);
		cgConstructorPart.setInit(getExpression(element.getInitExpression()));
		Property referredProperty = element.getReferredProperty();
		if (referredProperty != null) {
			CGExecutorConstructorPart cgExecutorConstructorPart = context.getExecutorConstructorPart(referredProperty);
			cgConstructorPart.getDependsOn().add(cgExecutorConstructorPart);
		}
		return cgConstructorPart;
	}

	@Override
	public @Nullable CGConstantExp visitEnumLiteralExp(@NonNull EnumLiteralExp element) {
//		CGConstant constant = context.getEnumerationLiteral(element.getReferredEnumLiteral());
		CGConstant constant = context.getElementId(element.getReferredEnumLiteral().getEnumerationLiteralId());
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, constant);
		setPivot(cgLiteralExp, element);
//		thisAnalysis.initHashSource(DomainUtil.nonNullModel(Boolean.valueOf(element.isBooleanSymbol())));
		return cgLiteralExp;
	}

	@Override
	public @NonNull CGValuedElement visitExpressionInOCL(@NonNull ExpressionInOCL element) {
		Variable contextVariable = element.getContextVariable();
		if (contextVariable != null) {
			CGVariable cgContext = getParameter(contextVariable);
			cgContext.setNonInvalid();
//			cgContext.setNonNull();
		}
		for (@SuppressWarnings("null")@NonNull Variable parameterVariable : element.getParameterVariable()) {
			@SuppressWarnings("unused") CGVariable cgParameter = getParameter(parameterVariable);
		}
		CGValuedElement cgBody = getExpression(element.getBodyExpression());
//		cgOperation.getDependsOn().add(cgBody);
		return cgBody;
	}

	@Override
	public @NonNull CGIfExp visitIfExp(@NonNull IfExp element) {
		CGIfExp cgIfExp = CGModelFactory.eINSTANCE.createCGIfExp();
		setPivot(cgIfExp, element);
		CGValuedElement cgCondition = getExpression(element.getCondition());
		CGValuedElement cgThenExpression = getExpression(element.getThenExpression());
		CGValuedElement cgElseExpression = getExpression(element.getElseExpression());
		cgIfExp.setCondition(cgCondition);
		cgIfExp.setThenExpression(cgThenExpression);
		cgIfExp.setElseExpression(cgElseExpression);
//		cgIfExp.getDependsOn().add(cgCondition);
//		cgIfExp.getDependsOn().add(cgThenExpression);
//		cgIfExp.getDependsOn().add(cgElseExpression);
		return cgIfExp;
	}

	@Override
	public @Nullable CGConstantExp visitIntegerLiteralExp(@NonNull IntegerLiteralExp element) {
		Number integerSymbol = element.getIntegerSymbol();
		CGInteger constant = context.getInteger(integerSymbol != null ? integerSymbol : 0);
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, constant);
		setPivot(cgLiteralExp, element);
		return cgLiteralExp;
	}

	@Override
	public @Nullable CGConstantExp visitInvalidLiteralExp(@NonNull InvalidLiteralExp element) {
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, context.getInvalid());
		setPivot(cgLiteralExp, element);
		return cgLiteralExp;
	}

	@Override
	public @NonNull CGLibraryIterateCallExp visitIterateExp(@NonNull IterateExp element) {
		Iteration pivotIteration = element.getReferredIteration();
		LibraryIteration libraryIteration = (LibraryIteration) pivotIteration.getImplementation();
		CGLibraryIterateCallExp cgLibraryIterateCallExp = CGModelFactory.eINSTANCE.createCGLibraryIterateCallExp();
		cgLibraryIterateCallExp.setLibraryIteration(libraryIteration);
		cgLibraryIterateCallExp.setReferredIteration(pivotIteration);
		setPivot(cgLibraryIterateCallExp, element);
		cgLibraryIterateCallExp.setInvalidating(pivotIteration.isInvalidating());
		cgLibraryIterateCallExp.setValidating(pivotIteration.isValidating());
		cgLibraryIterateCallExp.setSource(getExpression(element.getSource()));
		for (@SuppressWarnings("null")@NonNull Variable iterator : element.getIterator()) {
			cgLibraryIterateCallExp.getIterators().add(getIterator(iterator));
		}
		Variable result = element.getResult();
		if (result != null) {
			CGIterator cgResult = getIterator(result);
			cgLibraryIterateCallExp.setResult(cgResult);
			CGValuedElement cgInitExpression = getExpression(result.getInitExpression());
			cgResult.setInit(cgInitExpression);
		}
		cgLibraryIterateCallExp.setBody(getExpression(element.getBody()));
		cgLibraryIterateCallExp.setRequired(pivotIteration.isRequired());
//		cgIterationCallExp.setOperation(getOperation(element.getReferredOperation()));
		return cgLibraryIterateCallExp;
	}

	@Override
	public @NonNull CGLibraryIterationCallExp visitIteratorExp(@NonNull IteratorExp element) {
		Iteration pivotIteration = element.getReferredIteration();
		LibraryIteration libraryIteration = (LibraryIteration) pivotIteration.getImplementation();
		CGLibraryIterationCallExp cgLibraryIterationCallExp = CGModelFactory.eINSTANCE.createCGLibraryIterationCallExp();
		cgLibraryIterationCallExp.setLibraryIteration(libraryIteration);
		cgLibraryIterationCallExp.setReferredIteration(pivotIteration);
		setPivot(cgLibraryIterationCallExp, element);
		cgLibraryIterationCallExp.setInvalidating(pivotIteration.isInvalidating());
		cgLibraryIterationCallExp.setValidating(pivotIteration.isValidating());
		cgLibraryIterationCallExp.setSource(getExpression(element.getSource()));
		for (@SuppressWarnings("null")@NonNull Variable iterator : element.getIterator()) {
			cgLibraryIterationCallExp.getIterators().add(getIterator(iterator));
		}
		cgLibraryIterationCallExp.setBody(getExpression(element.getBody()));
		cgLibraryIterationCallExp.setRequired(pivotIteration.isRequired());
//		cgIterationCallExp.setOperation(getOperation(element.getReferredOperation()));
		return cgLibraryIterationCallExp;
	}

	@Override
	public @Nullable CGLetExp visitLetExp(@NonNull LetExp element) {
		CGLetExp cgLetExp = CGModelFactory.eINSTANCE.createCGLetExp();
		setPivot(cgLetExp, element);
		Variable variable = element.getVariable();
		CGValuedElement initExpression = getExpression(variable.getInitExpression());
		initExpression.setName(variable.getName());
		CGFinalVariable cgVariable = (CGFinalVariable) createCGVariable(variable);		// FIXME Lose cast
		cgVariable.setInit(initExpression);
//		initExpression.setVariableValue(cgVariable);
//		variables.put(variable, cgVariable);
		cgLetExp.setInit(cgVariable);
		cgLetExp.setIn(getExpression(element.getIn()));
		return cgLetExp;
	}

/*	@Override
	public @Nullable CGElement visitMessageExp(@NonNull MessageExp element) {
//		CGElement thisAnalysis = context.getCurrentAnalysis();
		return super.visitMessageExp(element);
	} */

	@Override
	public @Nullable CGConstantExp visitNullLiteralExp(@NonNull NullLiteralExp element) {
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, context.getNull());
		setPivot(cgLiteralExp, element);
		return cgLiteralExp;
	}

	@Override
	public @Nullable CGOperation visitOperation(@NonNull Operation element) {
		CGOperation cgOperation = CGModelFactory.eINSTANCE.createCGOperation();
		setPivot(cgOperation, element);
		cgOperation.setRequired(element.isRequired());
		for (Constraint pivotConstraint : element.getOwnedRule()) {
			if (UMLReflection.BODY.equals(pivotConstraint.getStereotype())) {
				ValueSpecification specification = pivotConstraint.getSpecification();
				if (specification != null) {
					ExpressionInOCL expressionInOCL = PivotUtil.getExpressionInOCL(element, specification);
					if (expressionInOCL != null) {
						Variable contextVariable = expressionInOCL.getContextVariable();
						if (contextVariable != null) {
							getSelfParameter(contextVariable);
						}
						for (Variable parameterVariable : expressionInOCL.getParameterVariable()) {
							getParameter(parameterVariable);
						}
						cgOperation.setBody(getExpression(expressionInOCL.getBodyExpression()));
					}
				}
			}
		}
		return cgOperation;
	}

	@Override
	public @NonNull CGOperationCallExp visitOperationCallExp(@NonNull OperationCallExp element) {
		CGOperationCallExp cgOperationCallExp = null;
		Operation pivotOperation = element.getReferredOperation();
//		if ("allOwnedElements".equals(pivotOperation.getName())) {
//			System.out.println("Got it");
//		}
		LibraryOperation libraryOperation = (LibraryOperation) pivotOperation.getImplementation();
		if ((libraryOperation != null) && !(libraryOperation instanceof EObjectOperation)) {
			CGLibraryOperationCallExp cgLibraryOperationCallExp = CGModelFactory.eINSTANCE.createCGLibraryOperationCallExp();
			cgLibraryOperationCallExp.setLibraryOperation(libraryOperation);
			cgOperationCallExp = cgLibraryOperationCallExp;
		}
		else {		// FIXME proper alternatives
			EOperation eOperation = (EOperation) pivotOperation.getETarget();
			if (eOperation != null) {
				try {
					genModelHelper.getOperationAccessor(pivotOperation);
					CGEcoreOperationCallExp cgEcoreOperationCallExp = CGModelFactory.eINSTANCE.createCGEcoreOperationCallExp();
					cgEcoreOperationCallExp.setEOperation(eOperation);
					cgOperationCallExp = cgEcoreOperationCallExp;
				} catch (GenModelException e) {}
			}
		}
		if (cgOperationCallExp == null) {
			CGExecutorOperationCallExp cgExecutorOperationCallExp = CGModelFactory.eINSTANCE.createCGExecutorOperationCallExp();
			CGExecutorOperation cgExecutorOperation = context.getExecutorOperation(pivotOperation);
			cgExecutorOperationCallExp.setExecutorOperation(cgExecutorOperation);
			cgOperationCallExp = cgExecutorOperationCallExp;
			cgOperationCallExp.getDependsOn().add(cgExecutorOperation);
		}
		cgOperationCallExp.setReferredOperation(pivotOperation);
		setPivot(cgOperationCallExp, element);
		cgOperationCallExp.setInvalidating(pivotOperation.isInvalidating());
		cgOperationCallExp.setValidating(pivotOperation.isValidating());
		cgOperationCallExp.setRequired(pivotOperation.isRequired());
		CGValuedElement cgSource = getExpression(element.getSource());
		cgOperationCallExp.setSource(cgSource);
//		cgOperationCallExp.getDependsOn().add(cgSource);
		for (OCLExpression pArgument : element.getArgument()) {
			CGValuedElement cgArgument = getExpression(pArgument);
			cgOperationCallExp.getArguments().add(cgArgument);
//			cgOperationCallExp.getDependsOn().add(cgArgument);
		}
//		cgOperationCallExp.setOperation(getOperation(element.getReferredOperation()));
		return cgOperationCallExp;
	}

	@Override
	public @Nullable CGPackage visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package element) {
		CGPackage cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		setPivot(cgPackage, element);
		for (Type pivotType : element.getOwnedType()) {
			CGClass cgClass = (CGClass) safeVisit(pivotType);
			cgPackage.getClasses().add(cgClass);
		}
		return cgPackage;
	}

	@Override
	public @Nullable CGProperty visitProperty(@NonNull Property element) {
		CGProperty cgProperty = CGModelFactory.eINSTANCE.createCGProperty();
		setPivot(cgProperty, element);
		cgProperty.setRequired(element.isRequired());
		Constraint theConstraint = null;
		Constraint initialConstraint = null;
		for (Constraint pivotConstraint : element.getOwnedRule()) {
			if (UMLReflection.DERIVATION.equals(pivotConstraint.getStereotype())) {
				theConstraint = pivotConstraint;
			}
			if (UMLReflection.DERIVATION.equals(pivotConstraint.getStereotype())) {
				initialConstraint = pivotConstraint;
			}
		}
		if (theConstraint == null) {
			theConstraint = initialConstraint;
		}
		if (theConstraint != null) {
			ValueSpecification specification = theConstraint.getSpecification();
			if (specification != null) {
				ExpressionInOCL expressionInOCL = PivotUtil.getExpressionInOCL(element, specification);
				if (expressionInOCL != null) {
					cgProperty.setBody(getExpression(expressionInOCL.getBodyExpression()));
				}
			}
		}
		return cgProperty;
	}

	@Override
	public @NonNull CGPropertyCallExp visitPropertyCallExp(@NonNull PropertyCallExp element) {
		Property pivotProperty = element.getReferredProperty();
		LibraryProperty libraryProperty = (LibraryProperty) pivotProperty.getImplementation();
		CGPropertyCallExp cgPropertyCallExp = null;
		if (pivotProperty instanceof TuplePartImpl) {				// FIXME Make TuplePart regular
			CGTuplePartCallExp cgTuplePartCallExp = CGModelFactory.eINSTANCE.createCGTuplePartCallExp();
			cgTuplePartCallExp.setPivotTuplePartId(((TuplePartImpl) pivotProperty).getTuplePartId());
			cgPropertyCallExp = cgTuplePartCallExp;
		}
		else {
			if (libraryProperty != null) {
				CGLibraryPropertyCallExp cgLibraryPropertyCallExp = CGModelFactory.eINSTANCE.createCGLibraryPropertyCallExp();
				cgLibraryPropertyCallExp.setLibraryProperty(libraryProperty);
				cgPropertyCallExp = cgLibraryPropertyCallExp;
			}
			else {
				EStructuralFeature eStructuralFeature = (EStructuralFeature) pivotProperty.getETarget();
				if (eStructuralFeature != null) {
					try {
						genModelHelper.getGetAccessor(eStructuralFeature);
						CGEcorePropertyCallExp cgEcorePropertyCallExp = CGModelFactory.eINSTANCE.createCGEcorePropertyCallExp();
						cgEcorePropertyCallExp.setEStructuralFeature(eStructuralFeature);
						cgPropertyCallExp = cgEcorePropertyCallExp;
					} catch (GenModelException e) {
					}
				}
			}
		}
		if (cgPropertyCallExp == null) {
			CGExecutorPropertyCallExp cgExecutorPropertyCallExp = CGModelFactory.eINSTANCE.createCGExecutorPropertyCallExp();					
			CGExecutorProperty cgExecutorProperty = context.getExecutorProperty(pivotProperty);
			cgExecutorPropertyCallExp.setExecutorProperty(cgExecutorProperty);
			cgPropertyCallExp = cgExecutorPropertyCallExp;
			cgPropertyCallExp.getDependsOn().add(cgExecutorProperty);
		}
		cgPropertyCallExp.setReferredProperty(pivotProperty);
		setPivot(cgPropertyCallExp, element);
		cgPropertyCallExp.setRequired(pivotProperty.isRequired());
		CGValuedElement cgSource = getExpression(element.getSource());
		cgPropertyCallExp.setSource(cgSource);
		return cgPropertyCallExp;
	}

	@Override
	public @Nullable CGConstantExp visitRealLiteralExp(@NonNull RealLiteralExp element) {
		Number realSymbol = element.getRealSymbol();
		@SuppressWarnings("null")
		CGReal cgReal = context.getReal(realSymbol != null ? realSymbol : Double.valueOf(0.0));
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, cgReal);
		setPivot(cgLiteralExp, element);
		return cgLiteralExp;
	}

	@Override
	public @Nullable CGNamedElement visitStateExp(@NonNull StateExp element) {
//		CGElement thisAnalysis = context.getCurrentAnalysis();
		return super.visitStateExp(element);
	}

	@Override
	public @Nullable CGConstantExp visitStringLiteralExp(@NonNull StringLiteralExp element) {
		String stringSymbol = element.getStringSymbol();
		CGString cgString = context.getString(stringSymbol != null ? stringSymbol : "");
		CGConstantExp cgLiteralExp = context.createCGConstantExp(element, cgString);
		return cgLiteralExp;
	}

	@Override
	public @Nullable CGTupleExp visitTupleLiteralExp(@NonNull TupleLiteralExp element) {
		CGTupleExp cgTupleExp = CGModelFactory.eINSTANCE.createCGTupleExp();
		setPivot(cgTupleExp, element);
		List<CGTuplePart> cgParts = cgTupleExp.getParts();
		for (TupleLiteralPart pivotPart : element.getPart()) {
			cgParts.add((CGTuplePart) pivotPart.accept(this));
		}
		context.getTypeId(element.getTypeId());
		return cgTupleExp;
	}

	@Override
	public @Nullable CGTuplePart visitTupleLiteralPart(@NonNull TupleLiteralPart element) {
		CGTuplePart cgTuplePart = CGModelFactory.eINSTANCE.createCGTuplePart();
		setPivot(cgTuplePart, element);
		cgTuplePart.setInit(getExpression(element.getInitExpression()));
		TuplePartId partId = element.getPartId();
		if (partId != null) {
			context.getElementId(partId);
		}
		return cgTuplePart;
	}

	@Override
	public @Nullable CGTypeExp visitTypeExp(@NonNull TypeExp pTypeExp) {
//		Type referredType = pTypeExp.getReferredType();
		CGTypeExp cgTypeExp = CGModelFactory.eINSTANCE.createCGTypeExp();
//		setPivot(cgTypeExp, pTypeExp);
		cgTypeExp.setPivot(pTypeExp);
//		TypeId pivotTypeId = pTypeExp.getTypeId();
//		cgTypeExp.setTypeId(context.getTypeId(pivotTypeId)); -- no need to reify the metaclassid
		cgTypeExp.setName(pTypeExp.getName());
		return cgTypeExp;
	}

	@Override
	public @Nullable CGConstantExp visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp element) {
		Number unlimitedNaturalSymbol = element.getUnlimitedNaturalSymbol();
		CGConstantExp cgLiteralExp;
		if (unlimitedNaturalSymbol instanceof UnlimitedValue) {
			cgLiteralExp = context.createCGConstantExp(element, context.getInfinity());
		}
		else if (unlimitedNaturalSymbol instanceof Unlimited) {
			cgLiteralExp = context.createCGConstantExp(element, context.getInfinity());
		}
		else if (unlimitedNaturalSymbol != null) {
			cgLiteralExp = context.createCGConstantExp(element, context.getInteger(unlimitedNaturalSymbol));
		}
		else {
			cgLiteralExp = context.createCGConstantExp(element, context.getInteger(0));
		}
		setPivot(cgLiteralExp, element);
		return cgLiteralExp;
	}

	@Override
	public @Nullable CGNamedElement visitUnspecifiedValueExp(@NonNull UnspecifiedValueExp element) {
//		CGElement thisAnalysis = context.getCurrentAnalysis();
		return super.visitUnspecifiedValueExp(element);
	}

	@Override
	public @Nullable CGVariableExp visitVariableExp(@NonNull VariableExp pVariableExp) {
		VariableDeclaration referredVariable = pVariableExp.getReferredVariable();
		CGVariableExp cgVariableExp = CGModelFactory.eINSTANCE.createCGVariableExp();
		setPivot(cgVariableExp, pVariableExp);
		if (referredVariable != null) {
			cgVariableExp.setReferredVariable(getVariable(referredVariable));
		}
		return cgVariableExp;
	}

	@Nullable
	public CGValuedElement visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}
}
