/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 253252
 *   Radek Dvorak - Bugs 261128, 265066
 *   E.D.Willink - Bug 297541
 *
 * </copyright>
 *
 * $Id: EvaluationVisitorImpl.java,v 1.13 2011/05/07 16:41:08 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainException;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.evaluation.InvalidEvaluationException;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.EvaluatorMultipleIterationManager;
import org.eclipse.ocl.examples.domain.library.EvaluatorSingleIterationManager;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibraryTernaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.BooleanValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * An evaluation visitor implementation for OCL expressions.
 */
public class EvaluationVisitorImpl extends AbstractEvaluationVisitor
{
	public static boolean isSimpleRange(@NonNull CollectionLiteralExp cl) {
		List<CollectionLiteralPart> partsList = cl.getPart();
		int size = partsList.size();
		if (size == 1) {
			CollectionLiteralPart part = partsList.get(0);
			return part instanceof CollectionRange;
		}
		return false;
	}
	
	/**
	 * Constructor
	 * 
	 * @param env
	 *            an evaluation environment (map of variable names to values)
	 * @param modelManager
	 *            a map of classes to their instance lists
	 */
	public EvaluationVisitorImpl( @NonNull Environment env,  @NonNull EvaluationEnvironment evalEnv, @NonNull DomainModelManager modelManager) {
		super(env, evalEnv, modelManager);
	}
	
	public @NonNull EvaluationVisitor createNestedEvaluator() {
		Environment environment = getEnvironment();
		EnvironmentFactory factory = environment.getFactory();
    	EvaluationEnvironment nestedEvalEnv = factory.createEvaluationEnvironment(getEvaluationEnvironment());
		return new EvaluationVisitorImpl(environment, nestedEvalEnv, getModelManager());
	}

	public @NonNull Value evaluate(@NonNull DomainExpression body) {
		Value value = ((OCLExpression) body).accept(this);
		if (value == null) {
			return throwInvalidEvaluation("null evaluation result");
		}
		else {
			return value;
		}
	}

	public @NonNull Value evaluate(@NonNull ExpressionInOCL expressionInOCL) {
		Value value = expressionInOCL.accept(this);
		if (value == null) {
			return throwInvalidEvaluation("null evaluation result");
		}
		else {
			return value;
		}
	}

	public @NonNull EvaluationVisitor getEvaluator() {
		return this;
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainType dynamicType, @NonNull DomainOperation staticOperation) {
		DomainInheritance inheritance = metaModelManager.getInheritance(dynamicType);
		return inheritance.lookupImplementation(metaModelManager, staticOperation);
	}

	@Override
	public Value safeVisit(@Nullable Visitable v) {
		if (v == null) {
			return evaluationEnvironment.throwInvalidEvaluation("null expression");
		}
		try {
			return v.accept(this);
		} catch (DomainException e) {
			throw e;
		} catch (Exception e) {
			return evaluationEnvironment.throwInvalidEvaluation(e, null, v, "Evaluation Failure");
		}
	}


	/**
	 * Callback for an AssociationClassCallExp visit. Evaluates the source of the
	 * expression and then reflectively gets the value of the reference on the
	 * result. For example, in "self.foo", "self" is the source and would be
	 * evaluated first, then the value of the reference "foo" would be derived
	 * on that object.
	 */
	@Override
    public Value visitAssociationClassCallExp(@NonNull AssociationClassCallExp ae) {
		Value context = ae.getSource().accept(getUndecoratedVisitor());
		
		if ((context == null) || context.isUndefined()) {
			return evaluationEnvironment.throwInvalidEvaluation("Undefined context for AssociationClassCall", ae);
		}
		
		// evaluate attribute on source value
		return evaluationEnvironment.navigateAssociationClass(
			ae.getReferredAssociationClass(),
			ae.getNavigationSource(),
			context);
	}

	/**
	 * Callback for a BooleanLiteralExp visit.
	 * 
	 * @return the value of the boolean literal as a java.lang.Boolean.
	 */
	@Override
    public BooleanValue visitBooleanLiteralExp(@NonNull BooleanLiteralExp booleanLiteralExp) {
    	boolean value = booleanLiteralExp.isBooleanSymbol();
		return valueFactory.booleanValueOf(value);
	}

	@Override
	public Value visitCollectionItem(@NonNull CollectionItem item) {
		throw new UnsupportedOperationException("evaluation of CollectionItem"); //$NON-NLS-1$
	}

	/**
	 * Callback for a CollectionLiteralExp visit.
	 */
	@Override
    public Value visitCollectionLiteralExp(@NonNull CollectionLiteralExp cl) {
		// construct the appropriate collection from the parts
		// based on the collection kind.
		List<CollectionLiteralPart> parts = cl.getPart();
		DomainCollectionType type = (DomainCollectionType) cl.getType();
		boolean isOrdered = type.isOrdered();
		if (isOrdered && isSimpleRange(cl)) {
			// literal is of the form: Sequence{first..last}.
			// construct a list with a lazy iterator for it.
			CollectionRange collRange = (CollectionRange) parts.get(0);
			OCLExpression first = collRange.getFirst();
			OCLExpression last = collRange.getLast();

			// evaluate first value
			Value firstVal = first.accept(getUndecoratedVisitor());
			if (firstVal == null) {
				return evaluationEnvironment.throwInvalidEvaluation("Invalid first element", cl, first);
			}
			// evaluate last value
			Value lastVal = last.accept(getUndecoratedVisitor());
			if (lastVal == null) {
				return evaluationEnvironment.throwInvalidEvaluation("Invalid last element", cl, last);
			}
			IntegerValue firstInteger;
			try {
				firstInteger = firstVal.asIntegerValue();
			} catch (InvalidValueException e) {
				return evaluationEnvironment.throwInvalidEvaluation(e, cl, firstVal, "Non integer first element");
			}
			IntegerValue lastInteger;
			try {
				lastInteger = lastVal.asIntegerValue();
			} catch (InvalidValueException e) {
				return evaluationEnvironment.throwInvalidEvaluation(e, cl, lastVal, "Non integer last element");
			}
			// construct a lazy integer list for the range
			try {
				IntegerRange range = valueFactory.createRange(firstInteger, lastInteger);
				if (type.isUnique()) {
					return valueFactory.createOrderedSetRange(type, range);
				}
				else {
					return valueFactory.createSequenceRange(type, range);
				}
			} catch (InvalidValueException e) {
				return evaluationEnvironment.throwInvalidEvaluation(e, cl, lastVal, "Non integer first or last element");
			}
		} else
		{
			List<Value> results = new ArrayList<Value>();
			// not a sequence or not a simple range
			for (CollectionLiteralPart part : parts) {
				if (part instanceof CollectionItem) {
					// CollectionItem part
					CollectionItem item = (CollectionItem) part;
					OCLExpression itemExp = item.getItem();
					Value itemVal = itemExp.accept(getUndecoratedVisitor());
					if (itemVal != null) {
						// add it to the result set
						results.add(itemVal);
					}
				} else {
					// Collection range
					CollectionRange range = (CollectionRange) part;
					OCLExpression first = range.getFirst();
					OCLExpression last = range.getLast();

					// evaluate first value
					Value firstVal = first.accept(getUndecoratedVisitor());
					if (firstVal == null) {
						return evaluationEnvironment.throwInvalidEvaluation("Invalid first element", cl, first);
					}
					Value lastVal = last.accept(getUndecoratedVisitor());
					if (lastVal == null) {
						return evaluationEnvironment.throwInvalidEvaluation("Invalid last element", cl, last);
					}
					IntegerValue firstInteger;
					try {
						firstInteger = firstVal.asIntegerValue();
					} catch (InvalidValueException e) {
						return evaluationEnvironment.throwInvalidEvaluation(e, cl, firstVal, "Non integer first element");
					}
					IntegerValue lastInteger;
					try {
						lastInteger = lastVal.asIntegerValue();
					} catch (InvalidValueException e) {
						return evaluationEnvironment.throwInvalidEvaluation(e, cl, lastVal, "Non integer last element");
					}
					Integer firstInt;
					try {
						firstInt = firstInteger.asInteger();
					} catch (InvalidValueException e) {
						return evaluationEnvironment.throwInvalidEvaluation(e, cl, firstInteger, "Out of range first element");
					}
					Integer lastInt;
					try {
						lastInt = lastInteger.asInteger();
					} catch (InvalidValueException e) {
						return evaluationEnvironment.throwInvalidEvaluation(e, cl, lastInteger, "Out of range last element");
					}
					// TODO: enhance IntegerRangeList to support multiple ranges
					// add values between first and last inclusive
					int increment = lastInt.compareTo(firstInt);
					for (int i = firstInt; true; i = i + increment) {
                        results.add(valueFactory.integerValueOf(i));
                        if (i == lastInt) {
                        	break;
                        }
                    }
				} // end of collection range

			} // end of parts iterator
			return valueFactory.createCollectionValue(type.isOrdered(), type.isUnique(), DomainUtil.nonNullModel(type.getElementType()), results);
		} // end of not-simple range case
	} // end of Set, OrderedSet, Bag Literals

	@Override
	public Value visitCollectionRange(@NonNull CollectionRange range) {
		throw new UnsupportedOperationException("evaluation of CollectionRange"); //$NON-NLS-1$
	}

    @Override
	public Value visitConstructorExp(@NonNull ConstructorExp ce) {
		DomainType type = ce.getType();
		String value = ce.getValue();
		if (value == null) {
			ObjectValue objectValue = type.createInstance(valueFactory);
			for (ConstructorPart part : ce.getPart()) {
				OCLExpression initExpression = part.getInitExpression();
				if (initExpression != null) {
					Value propertyValue = getUndecoratedVisitor().evaluate(initExpression);
					try {
						part.getReferredProperty().setValue(objectValue, propertyValue);
					} catch (InvalidValueException e) {
						return evaluationEnvironment.throwInvalidEvaluation(e);
					}
				}
			}
			return objectValue;
		}
		else {
			return type.createInstance(valueFactory, value);
		}
    }

	/**
	 * Callback for an EnumLiteralExp visit. Get the referred enum literal and
	 * return it as an Integer.
	 * 
	 * @param el
	 *            the enumeration literal expresion
	 * @return the enumeration literal as an Integer
	 */
	@Override
    public Value visitEnumLiteralExp(@NonNull EnumLiteralExp el) {
		return valueFactory.createEnumerationLiteralValue(DomainUtil.nonNullModel(el.getReferredEnumLiteral()));
	}

	@Override
	public Value visitExpressionInOCL(@NonNull ExpressionInOCL expression) {
		return safeVisit(expression.getBodyExpression());
	}

	/**
	 * Callback for an IfExp visit.
	 */
	@Override
    public Value visitIfExp(@NonNull IfExp ifExp) {
		OCLExpression condition = ifExp.getCondition();
//		if (condition == null) {
//			return null;
//		}
		BooleanValue evaluatedCondition;
		try {
			Value acceptedValue = condition.accept(getUndecoratedVisitor());
			if (acceptedValue == null) {
				return evaluationEnvironment.throwInvalidEvaluation("null condition");
			}
			evaluatedCondition = acceptedValue.asBooleanValue();
		} catch (InvalidValueException e) {
			return evaluationEnvironment.throwInvalidEvaluation(e);
		}
		OCLExpression expression = null;
		if (evaluatedCondition.isTrue()) {
			expression = ifExp.getThenExpression();
		} else {
			expression = ifExp.getElseExpression();
		}
		return expression.accept(getUndecoratedVisitor());
	}

	/**
	 * Callback for an IntegerLiteralExp visit.
	 * 
	 * @return the value of the integer literal as a java.lang.Integer.
	 */
	@Override
    public Value visitIntegerLiteralExp(@NonNull IntegerLiteralExp integerLiteralExp) {
		return integerLiteralExp.getIntegerValue(valueFactory);
	}

	@Override
    public Value visitInvalidLiteralExp(@NonNull InvalidLiteralExp invalidLiteralExp) {
		return evaluationEnvironment.throwInvalidEvaluation("Invalid Literal");
	}

	/**
	 * Callback for an IterateExp visit.
	 */
	@Override
    public Value visitIterateExp(@NonNull IterateExp iterateExp) {
		Iteration staticIteration = DomainUtil.nonNullModel(iterateExp.getReferredIteration());
		EvaluationVisitor undecoratedVisitor = getUndecoratedVisitor();
		CollectionValue sourceValue;
		try {
			OCLExpression source = iterateExp.getSource();
			Value acceptedValue = source.accept(undecoratedVisitor);
			if (acceptedValue == null) {
				return evaluationEnvironment.throwInvalidEvaluation("null iterate source");
			}
			sourceValue = acceptedValue.asCollectionValue();
		} catch (InvalidValueException e) {
			return evaluationEnvironment.throwInvalidEvaluation(e);
		}
		DomainType dynamicSourceType = sourceValue.getType();
		LibraryIteration implementation = (LibraryIteration) dynamicSourceType.lookupImplementation(metaModelManager, staticIteration);
/*		Operation dynamicIteration = metaModelManager.getDynamicOperation((org.eclipse.ocl.examples.pivot.Type) dynamicSourceType, staticIteration);
 		if (dynamicIteration == null) {
 			dynamicIteration = staticIteration;
 		}
 		LibraryIteration implementation1;
		try {
			implementation = (LibraryIteration) metaModelManager.getImplementation(dynamicIteration);
		} catch (Exception e) {
			String implementationClass = dynamicIteration.getImplementationClass();
			if (implementationClass != null) {
				return evaluationEnvironment.throwInvalidEvaluation(e, iterateExp, null, EvaluatorMessages.ImplementationClassLoadFailure, implementationClass);
			}
			else {
				return evaluationEnvironment.throwInvalidEvaluation(e, iterateExp, null, "Failed to load implementation for '" + dynamicIteration + "'");
			}
		} */
		Value result = null;
		try {
			Variable accumulator = iterateExp.getResult();
			Value initValue = accumulator.getInitExpression().accept(undecoratedVisitor);
			if ((initValue == null) || initValue.isUndefined()) {
				return evaluationEnvironment.throwInvalidEvaluation(null, iterateExp, initValue, EvaluatorMessages.UndefinedInitialiser);
			}
			DomainIterationManager iterationManager;
			VariableDeclaration accumulatorVariable = accumulator.getRepresentedParameter();
			OCLExpression body = DomainUtil.nonNullModel(iterateExp.getBody());
			List<Variable> iterators = iterateExp.getIterator();
			int iSize = iterators.size();
			if (iSize == 1) {
				VariableDeclaration firstIterator = DomainUtil.nonNullModel(iterators.get(0).getRepresentedParameter());
				iterationManager = new EvaluatorSingleIterationManager(undecoratedVisitor, body, sourceValue, accumulatorVariable, initValue, firstIterator);
			}
			else {
				VariableDeclaration[] variables = new VariableDeclaration[iSize];
				for (int i = 0; i < iSize; i++) {
					variables[i] = iterators.get(i).getRepresentedParameter();
				}
				iterationManager = new EvaluatorMultipleIterationManager(undecoratedVisitor, body, sourceValue, accumulatorVariable, initValue, variables);
			}
			result = implementation.evaluateIteration(iterationManager);
		} catch (InvalidValueException e) {
			return evaluationEnvironment.throwInvalidEvaluation(e);
		} catch (DomainException e) {
			throw e;
		} catch (Exception e) {
			// This is a backstop. Library iterations should catch their own exceptions
			//  and produce a better reason as a result.
			return evaluationEnvironment.throwInvalidEvaluation(e, iterateExp, sourceValue, "Failed to evaluate '" + staticIteration + "'");	// FIXME dymamicIteration throughout
		}
		return result;
	}

	/**
	 * Callback for an IteratorExp visit.
	 */
	@Override
    public Value visitIteratorExp(@NonNull IteratorExp iteratorExp) {
		Iteration staticIteration = DomainUtil.nonNullModel(iteratorExp.getReferredIteration());
		EvaluationVisitor undecoratedVisitor = getUndecoratedVisitor();
		CollectionValue sourceValue;
		try {
			OCLExpression source = iteratorExp.getSource();
			Value sourceVal = source.accept(undecoratedVisitor);
			if (sourceVal == null) {
				return evaluationEnvironment.throwInvalidEvaluation("null iterator source");
			}
			sourceValue = sourceVal.asCollectionValue();
		} catch (InvalidValueException e) {
			return evaluationEnvironment.throwInvalidEvaluation(e);
		}
		DomainType dynamicSourceType = sourceValue.getType();
		LibraryIteration implementation = (LibraryIteration) dynamicSourceType.lookupImplementation(metaModelManager, staticIteration);
/*		Operation dynamicIteration = metaModelManager.getDynamicOperation((org.eclipse.ocl.examples.pivot.Type) dynamicSourceType, staticIteration);
 		if (dynamicIteration == null) {
 			dynamicIteration = staticIteration;
 		}
 		LibraryIteration implementation;
		try {
			implementation = (LibraryIteration) metaModelManager.getImplementation(dynamicIteration);
		} catch (Exception e) {
			String implementationClass = dynamicIteration.getImplementationClass();
			if (implementationClass != null) {
				return evaluationEnvironment.throwInvalidEvaluation(e, iteratorExp, null, EvaluatorMessages.ImplementationClassLoadFailure, implementationClass);
			}
			else {
				return evaluationEnvironment.throwInvalidEvaluation(e, iteratorExp, null, "Failed to load implementation for '" + dynamicIteration + "'");
			}
		} */
		Value result = null;
		try {
			DomainIterationManager iterationManager;
			OCLExpression body = iteratorExp.getBody();
			Type iterationType = PivotUtil.getBehavioralType(DomainUtil.nonNullModel(iteratorExp.getType()));
			Type bodyType = PivotUtil.getBehavioralType(DomainUtil.nonNullModel(body.getType()));
			Value accumulatorValue = implementation.createAccumulatorValue(undecoratedVisitor, iterationType, bodyType);
			List<Variable> iterators = iteratorExp.getIterator();
			int iSize = iterators.size();
			if (iSize == 1) {
				VariableDeclaration firstIterator = DomainUtil.nonNullModel(iterators.get(0).getRepresentedParameter());
				iterationManager = new EvaluatorSingleIterationManager(undecoratedVisitor, body, sourceValue, null, accumulatorValue, firstIterator);
			}
			else {
				VariableDeclaration[] variables = new VariableDeclaration[iSize];
				for (int i = 0; i < iSize; i++) {
					variables[i] = iterators.get(i).getRepresentedParameter();
				}
				iterationManager = new EvaluatorMultipleIterationManager(undecoratedVisitor, body, sourceValue, null, accumulatorValue, variables);
			}
			result = implementation.evaluateIteration(iterationManager);
		} catch (InvalidValueException e) {
			return evaluationEnvironment.throwInvalidEvaluation(e);
		} catch (DomainException e) {
			throw e;
		} catch (Exception e) {
			// This is a backstop. Library iterations should catch their own exceptions
			//  and produce a better reason as a result.
			return evaluationEnvironment.throwInvalidEvaluation(e, iteratorExp, sourceValue, "Failed to evaluate '" + staticIteration + "'");
		}
		return result;
	}

	/**
	 * Callback for LetExp visit.
	 */
	@Override
    public Value visitLetExp(@NonNull LetExp letExp) {
		OCLExpression expression = letExp.getIn();		// Never null when valid
		Variable variable = letExp.getVariable();		// Never null when valid
		Value value;
		try {
			value = variable.accept(this);
		}
		catch (InvalidEvaluationException e) {
			value = valueFactory.createInvalidValue(e);
		}
    	EvaluationVisitor nestedVisitor = getUndecoratedVisitor().createNestedEvaluator();		
		nestedVisitor.getEvaluationEnvironment().add(variable, value);
		return expression.accept(nestedVisitor);
	}
	
	@Override
    public Value visitMessageExp(@NonNull MessageExp m) {
		throw new UnsupportedOperationException("evaluation of MessageExp"); //$NON-NLS-1$
/*        T targetResult = safeVisit(messageExp.getTarget());        
        List<T> argumentResults;
        List<OCLExpression> arguments = messageExp.getArgument();       
        if (arguments.isEmpty()) {
            argumentResults = Collections.emptyList();
        } else {
            argumentResults = new java.util.ArrayList<T>(arguments.size());
            for (OCLExpression qual : arguments) {
                argumentResults.add(safeVisit(qual));
            }
        }        
        return handleMessageExp(messageExp, targetResult, argumentResults);
*/	}

	@Override
    public Value visitNullLiteralExp(@NonNull NullLiteralExp nullLiteralExp) {
		return valueFactory.getNull();
	}

	/**
	 * Callback for an OperationCallExp visit.
	 */
	@Override
    public Value visitOperationCallExp(@NonNull OperationCallExp operationCallExp) {
		EvaluationVisitor undecoratedVisitor = getUndecoratedVisitor();
		DomainEvaluator evaluator = undecoratedVisitor.getEvaluator();
		Operation staticOperation = operationCallExp.getReferredOperation();
		//
		//	Resolve source value
		//
 		Value sourceValue;
		OCLExpression source = operationCallExp.getSource();
		try {
			sourceValue = source.accept(undecoratedVisitor);
			if (sourceValue == null) {
				return evaluationEnvironment.throwInvalidEvaluation("null operation source");
			}
		}
		catch (InvalidEvaluationException e) {
			sourceValue = valueFactory.createInvalidValue(e);	// FIXME ?? propagate part of environment
		}
		//
		//	Resolve source dispatch type
		//
 		DomainType dynamicSourceType = sourceValue.getType();
		List<OCLExpression> arguments = operationCallExp.getArgument();
		Value onlyArgument = null;
		List<Parameter> ownedParameters = staticOperation.getOwnedParameter();
		if ((ownedParameters.size() == 1) && (ownedParameters.get(0).getType() instanceof SelfType)) {
			onlyArgument =  arguments.get(0).accept(undecoratedVisitor);
			if (onlyArgument != null) {
				DomainType argType = onlyArgument.getType();
				dynamicSourceType = dynamicSourceType.getCommonType(metaModelManager, argType);
			}
	 	}
		//
		//	Resolve operation to dispatch
		//
		LibraryFeature implementation = dynamicSourceType.lookupImplementation(metaModelManager, staticOperation);
//		if (implementation == null) {
//			return evaluationEnvironment.throwInvalidEvaluation("No implementation for '" + staticOperation + "'", operationCallExp, sourceValue);
//		}
		//
		//	Dispatch implementation avoiding variable argument list where possible
		//
		try {
			Value result = null;
			int iSize = arguments.size();
			switch (iSize) {
				case 0: {
					result = ((LibraryUnaryOperation)implementation).evaluate(evaluator, operationCallExp, sourceValue);
					break;
				}
				case 1: {
					LibraryBinaryOperation binaryOperation = (LibraryBinaryOperation)implementation;
					if (onlyArgument == null) {
						OCLExpression argument0 = arguments.get(0);
						if (binaryOperation.argumentsMayBeInvalid()) {
							try {
								onlyArgument = argument0 != null ? undecoratedVisitor.evaluate(argument0) : valueFactory.getInvalid();
							} catch (InvalidEvaluationException e) {
								onlyArgument = valueFactory.createInvalidValue(e);
							}
						}
						else {
							onlyArgument = argument0 != null ? undecoratedVisitor.evaluate(argument0) : valueFactory.getInvalid();
						}
					}
					result = binaryOperation.evaluate(evaluator, operationCallExp, sourceValue, onlyArgument);
					break;
				}
				case 2: {
					OCLExpression argument0 = arguments.get(0);
					OCLExpression argument1 = arguments.get(1);
					Value firstArgument = argument0 != null ? undecoratedVisitor.evaluate(argument0) : valueFactory.getInvalid();
					Value secondArgument = argument1 != null ? undecoratedVisitor.evaluate(argument1) : valueFactory.getInvalid();
					result = ((LibraryTernaryOperation)implementation).evaluate(evaluator, operationCallExp, sourceValue, firstArgument, secondArgument);
					break;
				}
				default: {
					Value[] values = new Value[iSize];
					for (int i = 0; i < iSize; i++) {
						OCLExpression argumentI = arguments.get(i);
						values[i] = argumentI != null ? undecoratedVisitor.evaluate(argumentI) : valueFactory.getInvalid();
					}
					result = ((LibraryOperation)implementation).evaluate(evaluator, operationCallExp, sourceValue, values);
					break;
				}
			}
			if (result == null) {
				return evaluationEnvironment.throwInvalidEvaluation("Java-Null result from '" + staticOperation + "'", operationCallExp, sourceValue);
			}
			return result;
		} catch (InvalidValueException e) {
			return evaluationEnvironment.throwInvalidEvaluation(e);
		} catch (DomainException e) {
			throw e;
		} catch (Exception e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			return evaluationEnvironment.throwInvalidEvaluation(e, operationCallExp, sourceValue, "Failed to evaluate '" + staticOperation + "'");
		}
	}

	/**
	 * Callback for a PropertyCallExp visit.
	 */
	@Override
    public Value visitPropertyCallExp(@NonNull PropertyCallExp propertyCallExp) {
		Property property = DomainUtil.nonNullModel(propertyCallExp.getReferredProperty());
		LibraryProperty implementation;
		try {
			implementation = (LibraryProperty) metaModelManager.getImplementation(property);
		} catch (Exception e) {
			String implementationClass = property.getImplementationClass();
			if (implementationClass != null) {
				return evaluationEnvironment.throwInvalidEvaluation(e, propertyCallExp, null, EvaluatorMessages.ImplementationClassLoadFailure, implementationClass);
			}
			else {
				return evaluationEnvironment.throwInvalidEvaluation(e, propertyCallExp, null, "Failed to load implementation for '" + property + "'");
			}
		}
		OCLExpression source = DomainUtil.nonNullModel(propertyCallExp.getSource());
		EvaluationVisitor evaluationVisitor = getUndecoratedVisitor();
		Value sourceValue = evaluationVisitor.evaluate(source);
		Value resultValue = null;
		try {
			resultValue = implementation.evaluate(this, DomainUtil.nonNullModel(propertyCallExp.getType()), sourceValue, DomainUtil.nonNullModel(propertyCallExp.getReferredProperty()));
		}
		catch (DomainException e) {
			throw e;
		}
		catch (Exception e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			return evaluationEnvironment.throwInvalidEvaluation(e, propertyCallExp, sourceValue, "Failed to evaluate '" + property + "'");
		}
		return resultValue;
	}
	
	/**
	 * Callback for a RealLiteralExp visit.
	 * 
	 * @return the value of the real literal as a java.lang.Double.
	 */
	@Override
    public Value visitRealLiteralExp(@NonNull RealLiteralExp realLiteralExp) {
		return realLiteralExp.getRealValue(valueFactory);
	}
	
	@Override
    public Value visitStateExp(@NonNull StateExp s) {
		return valueFactory.createElementValue(DomainUtil.nonNullModel(s.getReferredState()));
	}

	/**
	 * Callback for a StringLiteralExp visit.
	 * 
	 * @return the value of the string literal as a java.lang.String.
	 */
	@Override
    public Value visitStringLiteralExp(@NonNull StringLiteralExp stringLiteralExp) {
		String value = stringLiteralExp.getStringSymbol();
		if (value == null) {
			return evaluationEnvironment.throwInvalidEvaluation("Invalid String Value", stringLiteralExp);
		}
		return valueFactory.stringValueOf(value);
	}

	/**
	 * Callback for a TupleLiteralExp visit.
	 * 
	 * @param tl
	 *            tuple literal expression
	 * @return String
	 */
	@Override
    public Value visitTupleLiteralExp(@NonNull TupleLiteralExp tl) {
		DomainType type = DomainUtil.nonNullModel(tl.getType());
		Map<TypedElement, Value> propertyValues = new HashMap<TypedElement, Value>();		
		for (TupleLiteralPart part : tl.getPart()) {
			// Set the tuple field with the value of the init expression
			propertyValues.put(part, part.accept(getUndecoratedVisitor()));
		}
//		TupleType tupleType = metaModelManager.getTupleType(type.getName(), propertyValues.keySet());
		return valueFactory.createTupleValue((TupleType) type, propertyValues);
	}
	
	@Override
    public Value visitTupleLiteralPart(@NonNull TupleLiteralPart tp) {
		return tp.getInitExpression().accept(getUndecoratedVisitor());
	}

	/**
	 * Callback for a TypeExp visit.
	 */
	@Override
    public Value visitTypeExp(@NonNull TypeExp t) {
		return valueFactory.createTypeValue(DomainUtil.nonNullModel(((DomainMetaclass)t.getType()).getInstanceType()));
	}
    
    /**
     * Callback for an UnlimitedNaturalLiteralExp visit.
     * 
     * @return the value of the natural literal as a java.lang.Integer.
     */
    @Override
    public Value visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp unlimitedNaturalLiteralExp) {
		return unlimitedNaturalLiteralExp.getUnlimitedNaturalValue(valueFactory);
	}
	
	/**
	 * Callback for an UnspecifiedValueExp visit.
	 */
	@Override
    public Value visitUnspecifiedValueExp(@NonNull UnspecifiedValueExp uv) {
		// TODO: return a "random instance of the type of the expression"
		throw new UnsupportedOperationException("evaluation of UnspecifiedValueExp"); //$NON-NLS-1$
	}

	/**
	 * Callback for a Variable visit.
	 */
	@Override
    public Value visitVariable(@NonNull Variable variable) {
		// return the initial (only) value
		OCLExpression initExp = variable.getInitExpression();
		if (initExp == null) {
			return evaluationEnvironment.throwInvalidEvaluation("Uninitialized variable", null, variable);
		}
		else {
			return initExp.accept(getUndecoratedVisitor());
		}
	}

	/**
	 * Callback for a VariableExp visit.
	 * 
	 * @param v
	 *            the variable expression
	 * @return the value of the variable
	 */
	@Override
    public Value visitVariableExp(@NonNull VariableExp variableExp) {
		VariableDeclaration variableDeclaration = variableExp.getReferredVariable();
		if (variableDeclaration instanceof Variable) {
			Parameter representedParameter = ((Variable)variableDeclaration).getRepresentedParameter();
			if (representedParameter != null) {				// Non-null to map iterator actual to formal
				variableDeclaration = representedParameter;
			}
		}
		if (variableDeclaration == null) {
			return evaluationEnvironment.throwInvalidEvaluation("Undefined variable", variableExp);
		}
		Value value = evaluationEnvironment.getValueOf(variableDeclaration);
		if (value == null) {
			return evaluationEnvironment.throwInvalidEvaluation("Undefined variable '" + variableDeclaration.getName() + "'", variableExp);
		}
		else if (value.isInvalid()) {
			Exception e = ((InvalidValue)value).getException();
			return evaluationEnvironment.throwInvalidEvaluation(e, variableExp, null, "Invalid variable '" + variableDeclaration.getName() +"'");
		}
		else {
			return value;
		}
	}

	public Value visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for EvaluationVisitor");
	}
}
