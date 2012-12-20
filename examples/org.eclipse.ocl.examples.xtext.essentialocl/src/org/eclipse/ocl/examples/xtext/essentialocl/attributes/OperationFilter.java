/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: OperationFilter.java,v 1.10 2011/05/02 09:31:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole;

public class OperationFilter extends AbstractOperationFilter
{
	protected final @NonNull List<NavigatingArgCS> csArguments;
	protected final int iterators;
	protected final int accumulators;
	protected final int expressions;
	
	@Deprecated // Preserved only for QVTd API migration
	public OperationFilter(@NonNull MetaModelManager metaModelManager, @Nullable Type sourceType, @NonNull InvocationExpCS csNavigatingExp) {
		this(sourceType, csNavigatingExp);
	}
	
	public OperationFilter(@Nullable Type sourceType, @NonNull InvocationExpCS csNavigatingExp) {
		super(sourceType);
		int accumulators = 0;
		int iterators = 0;
		int expressions = 0;
		@SuppressWarnings("null") @NonNull List<NavigatingArgCS> csArguments = csNavigatingExp.getArgument();
		this.csArguments = csArguments;
		for (NavigatingArgCS csNavigatingArg : csArguments) {
			if (csNavigatingArg.getRole() == NavigationRole.ITERATOR) {
				iterators++;
			}
			else if (csNavigatingArg.getRole() == NavigationRole.ACCUMULATOR) {
				accumulators++;
			}
			else if (csNavigatingArg.getRole() == NavigationRole.EXPRESSION) {
				expressions++;
			}
		}
		this.iterators = iterators;
		this.accumulators = accumulators;
		this.expressions = expressions;
	}

	@Override
	public int compareMatches(@NonNull MetaModelManager metaModelManager, @NonNull DomainElement match1, @Nullable Map<TemplateParameter, ParameterableElement> referenceBindings,
			@NonNull DomainElement match2, @Nullable Map<TemplateParameter, ParameterableElement> candidateBindings) {
		@NonNull Operation reference = (Operation) match1;
		@NonNull Operation candidate = (Operation) match2;
		Type referenceType = PivotUtil.getBehavioralType(PivotUtil.getOwningType(reference));
		Type candidateType = PivotUtil.getBehavioralType(PivotUtil.getOwningType(candidate));
		Type specializedReferenceType = metaModelManager.getSpecializedType(referenceType, referenceBindings);
		Type specializedCandidateType = metaModelManager.getSpecializedType(candidateType, candidateBindings);
		if ((reference instanceof Iteration) && (candidate instanceof Iteration)) {
			int iteratorCountDelta = ((Iteration)candidate).getOwnedIterator().size() - ((Iteration)reference).getOwnedIterator().size();
			if (iteratorCountDelta != 0) {
				return iteratorCountDelta;
			}
			if (referenceType != candidateType) {
				if (metaModelManager.conformsTo(specializedReferenceType, specializedCandidateType, null)) {
					return 1;
				}
				else if (metaModelManager.conformsTo(specializedCandidateType, specializedReferenceType, null)) {
					return -1;
				}
			}
		}
		int referenceConversions = 0;
		int candidateConversions = 0;
		if (sourceType != specializedReferenceType) {
			referenceConversions++;
		}
		if (sourceType != specializedCandidateType) {
			candidateConversions++;
		}
		List<Parameter> candidateParameters = candidate.getOwnedParameter();
		List<Parameter> referenceParameters = reference.getOwnedParameter();
		for (int i = 0; i < candidateParameters.size(); i++) {
			NavigatingArgCS csArgument = csArguments.get(i);
			OCLExpression pivotArgument = PivotUtil.getPivot(OCLExpression.class, csArgument);
			if (pivotArgument == null) {
				return 0;
			}
			Type argumentType = pivotArgument.getType();
			Parameter referenceParameter = referenceParameters.get(i);
			Parameter candidateParameter = candidateParameters.get(i);
			if ((referenceParameter == null) || (candidateParameter == null)) {					// Doesn't happen (just a supurious NPE guard)
				referenceConversions = Integer.MIN_VALUE;
				candidateConversions = Integer.MIN_VALUE;
			}
			else {
				referenceType = PivotUtil.getBehavioralType(referenceParameter);
				candidateType = PivotUtil.getBehavioralType(candidateParameter);
				specializedReferenceType = metaModelManager.getSpecializedType(referenceType, referenceBindings);
				specializedCandidateType = metaModelManager.getSpecializedType(candidateType, candidateBindings);
				if (argumentType != specializedReferenceType) {
					referenceConversions++;
				}
				if (argumentType != specializedCandidateType) {
					candidateConversions++;
				}
			}
		}
		if (candidateConversions != referenceConversions) {
			return candidateConversions - referenceConversions;
		}
		int verdict = metaModelManager.compareOperationMatches(reference, referenceBindings, candidate, candidateBindings);
		return verdict;
	}

	protected @Nullable OCLExpression getExpressionArgument(int index) {
		int expIndex = 0;
		for (NavigatingArgCS csNavigatingArg : csArguments) {
			if (csNavigatingArg.getRole() == NavigationRole.EXPRESSION) {
				if (expIndex == index) {
					return PivotUtil.getPivot(OCLExpression.class, csNavigatingArg);
				}
				expIndex++;
			}
		}
		return null;
	}

	protected @Nullable Map<TemplateParameter, ParameterableElement> getIterationBindings(@NonNull MetaModelManager metaModelManager, @NonNull Iteration candidateIteration) {
		Type sourceType = this.sourceType;
		if (!(sourceType instanceof CollectionType) && (candidateIteration.getOwningType() instanceof CollectionType) && (sourceType != null)) {
			sourceType = metaModelManager.getSetType(sourceType, null, null);		// Implicit oclAsSet()
		}
		if (!(sourceType instanceof CollectionType)) {			// May be InvalidType
			return null;
		}
		HashMap<TemplateParameter, ParameterableElement> bindings = new HashMap<TemplateParameter, ParameterableElement>();
		bindings.put(candidateIteration.getOwningType().getOwnedTemplateSignature().getOwnedParameter().get(0), ((CollectionType)sourceType).getElementType());
		PivotUtil.getAllTemplateParameterSubstitutions(bindings, sourceType);
		TemplateSignature templateSignature = candidateIteration.getOwnedTemplateSignature();
		if (templateSignature != null) {
			List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
			int accIndex = 0;
			for (NavigatingArgCS csArgument : csArguments) {
				if (csArgument.getRole() == NavigationRole.ACCUMULATOR) {
					if (accIndex < templateParameters.size()) {
						Variable argument = PivotUtil.getPivot(Variable.class, csArgument);
						if (argument != null) {
							Type argumentType = argument.getType();
							TemplateParameter accParameter = templateParameters.get(accIndex);
							bindings.put(accParameter, argumentType);
						}
					}
					accIndex++;
				}
			}
		}
		return bindings;
	}

	@Override
	protected @Nullable Map<TemplateParameter, ParameterableElement> getOperationBindings(@NonNull MetaModelManager metaModelManager, @NonNull Operation candidateOperation) {
		Type sourceType = this.sourceType;
		Map<TemplateParameter, ParameterableElement> bindings = null;
		Type containingType = candidateOperation.getOwningType();
		if ((containingType instanceof CollectionType) && (sourceType != null)) {
			if (!(sourceType instanceof CollectionType)) {
				sourceType = metaModelManager.getSetType(sourceType, null, null);		// Implicit oclAsSet()
			}			
			Type elementType;
			if (sourceType instanceof CollectionType) {
				elementType = ((CollectionType)sourceType).getElementType();
			}
			else {
				elementType = metaModelManager.getOclInvalidType();
			}
			bindings = new HashMap<TemplateParameter, ParameterableElement>();
			bindings.put(containingType.getOwnedTemplateSignature().getOwnedParameter().get(0), elementType);
		}			
		bindings = PivotUtil.getAllTemplateParameterSubstitutions(bindings, sourceType);
		TemplateSignature templateSignature = candidateOperation.getOwnedTemplateSignature();
		if (templateSignature != null) {
			for (TemplateParameter templateParameter : templateSignature.getOwnedParameter()) {
				if (bindings == null) {
					bindings = new HashMap<TemplateParameter, ParameterableElement>();
				}
				bindings.put(templateParameter, null);
			}
		}
		return bindings;
	}

	@Override
	protected void installBindings(@NonNull EnvironmentView environmentView, @NonNull DomainElement eObject,
			@Nullable Map<TemplateParameter, ParameterableElement> bindings) {
		List<Parameter> parameters = ((Operation)eObject).getOwnedParameter();
		int iMax = parameters.size();
		if (iMax > 0) {
			for (int i = 0; i < iMax; i++) {
				Parameter parameter = parameters.get(i);
				OCLExpression argument = getExpressionArgument(i);
				if (argument != null) {
					Type parameterType = parameter.getType();
					if (parameterType instanceof LambdaType) {
						PivotUtil.getAllTemplateParameterSubstitutions(bindings, argument.getType(), (LambdaType) parameterType);
					}
				}
			}
		}
		super.installBindings(environmentView, eObject, bindings);
	}

	public boolean matches(@NonNull EnvironmentView environmentView, @NonNull DomainElement eObject) {
		MetaModelManager metaModelManager = environmentView.getMetaModelManager();
		if (eObject instanceof Iteration) {
			Iteration candidateIteration = (Iteration)eObject;
			int iteratorCount = candidateIteration.getOwnedIterator().size();
			if ((0 < iterators) && (iteratorCount != iterators)) {
				return false;
			}
			int accumulatorCount = candidateIteration.getOwnedAccumulator().size();
			if (accumulatorCount != accumulators) {
				return false;
			}
			Map<TemplateParameter, ParameterableElement> bindings = getIterationBindings(metaModelManager, candidateIteration);
			if (bindings != null) {
				installBindings(environmentView, eObject, bindings);
			}
			return true;
		}
		else if (eObject instanceof Operation) {
			if (iterators > 0) {
				return false;
			}
			if (accumulators > 0) {
				return false;
			}
			Operation candidateOperation = (Operation)eObject;
			List<Parameter> candidateParameters = candidateOperation.getOwnedParameter();
			if (expressions != candidateParameters.size()) {
				return false;
			}
			Map<TemplateParameter, ParameterableElement> bindings = getOperationBindings(metaModelManager, candidateOperation);
			for (int i = 0; i < expressions; i++) {
				Parameter candidateParameter = candidateParameters.get(i);
				if (candidateParameter != null) {
					NavigatingArgCS csExpression = csArguments.get(i);
					OCLExpression expression = PivotUtil.getPivot(OCLExpression.class, csExpression);
					if (expression == null) {
						return false;
					}
					Type candidateType = PivotUtil.getBehavioralType(candidateParameter);
					if (candidateType instanceof SelfType) {
						candidateType = candidateOperation.getOwningType();
					}
					Type expressionType = expression.getType();
					if ((expressionType == null) || (candidateType == null)) {
						return false;
					}
					expressionType = PivotUtil.getBehavioralType(expressionType);			// FIXME make this a general facility
					if (!metaModelManager.conformsTo(expressionType, candidateType, bindings)) {
						return false;
					}
				}
			}
			if (bindings != null) {
				installBindings(environmentView, eObject, bindings);
			}
			return true;
		}
		else {
			return false;
		}
	}
}