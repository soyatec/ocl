/*******************************************************************************
 * Copyright (c) 2009, 2012 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.deltaPropagation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluator;
import org.eclipse.ocl.examples.impactanalyzer.ValueNotFoundException;
import org.eclipse.ocl.examples.impactanalyzer.impl.OperationBodyToCallMapper;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.Tuple.Pair;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;


/**
 * Can evaluate an OCL expression when the model is in some state which just got modified by a change indicated by an event
 * {@link Notification} such that the evaluation result is based on the state that the model was in <em>before</em> the
 * modification occurred. This is similar to the <code>@pre</code> operator in OCL.
 * <p>
 * 
 * Additionally, if the expression to evaluate is a {@link CallExp} expression, the evaluation result of its
 * {@link CallExp#getSource() source} expression can be provided, cutting short the evaluation of this source
 * expression. For this, it uses an adapted OCL evaluation environment.
 * 
 * TODO need to be able to accept a set of variable definitions for the starting scope that are added to the initial evaluation environment on the OCL instance being used
 * 
 * @author Axel Uhl
 * 
 */
public class PartialEvaluatorImpl implements PartialEvaluator {
    private final OCL ocl;
    private final Helper helper;
    private PartialEcoreEnvironmentFactory factory;
    
    /**
     * Uses a {@link DefaultOppositeEndFinder} to navigate hidden opposite properties and evaluates
     * the model based on its current state.
     */
    public PartialEvaluatorImpl(OCLFactory oclFactory) {
        this(new PartialEcoreEnvironmentFactory(), oclFactory);
    }
    
    /**
     * Constructs the OCL instance using {@link OCLFactory#createOCL(OppositeEndFinder)}, passing the
     * <code>oppositeEndFinder</code> provided. A default {@link PartialEcoreEnvironmentFactory} is
     * used, configured as well with the <code>oppositeEndFinder</code> provided here.
     */
    public PartialEvaluatorImpl(OCLFactory oclFactory, OppositeEndFinder oppositeEndFinder) {
        this.factory = new PartialEcoreEnvironmentFactory(oppositeEndFinder);
        this.ocl = oclFactory.createOCL(this.factory);
        helper = ocl.createOCLHelper();
    }
    
    protected PartialEvaluatorImpl(PartialEcoreEnvironmentFactory factory, OCLFactory oclFactory) {
        this.factory = factory;
        this.ocl = oclFactory.createOCL(factory);
        helper = ocl.createOCLHelper();
    }

	/**
	 * Taking a {@link Notification} object such that an evaluation will be
	 * based on the state *before* the notification. For example, if the
	 * notification indicates the removal of a reference from an element
	 * <tt>e1</tt> to an element <tt>e2</tt> across reference <tt>r</tt> then
	 * when during partial evaluation <tt>r</tt> is traversed starting from
	 * <tt>e1</tt> then <tt>e2</tt> will show in the results although in the
	 * current version of the model it would not.
	 * <p>
	 * 
	 * A {@link DefaultOppositeEndFinder} is used for hidden opposite
	 * navigation.
	 * 
	 * @param atPre
	 *            if <code>null</code>, the constructor behaves the same as
	 *            {@link #PartialEvaluatorImpl(OCLFactory)}
	 */
    public PartialEvaluatorImpl(Notification atPre, OCLFactory oclFactory) {
        this(new PartialEcoreEnvironmentFactory(atPre), oclFactory);
    }

	/**
	 * Taking a {@link Notification} object such that an evaluation will be
	 * based on the state *before* the notification. For example, if the
	 * notification indicates the removal of a reference from an element
	 * <tt>e1</tt> to an element <tt>e2</tt> across reference <tt>r</tt> then
	 * when during partial evaluation <tt>r</tt> is traversed starting from
	 * <tt>e1</tt> then <tt>e2</tt> will show in the results although in the
	 * current version of the model it would not.
	 * <p>
	 * 
	 * @param atPre
	 *            if <code>null</code>, the constructor behaves the same as
	 *            {@link #PartialEvaluatorImpl(OCLFactory, OppositeEndFinder)}
	 */
    public PartialEvaluatorImpl(Notification atPre, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        this(new PartialEcoreEnvironmentFactory(atPre, oppositeEndFinder), oclFactory);
    }
    
    public OCL getOcl() {
        return ocl;
    }

    public Helper getHelper() {
        return helper;
    }

    public Object evaluate(Object context, CallExp e, Object valueOfSourceExpression) {
        factory.setExpressionValue((OCLExpression) e.getSource(), valueOfSourceExpression);
        return ocl.evaluate(context, e);
    }

    public Object evaluate(Object context, OCLExpression e) {
        return ocl.evaluate(context, e);
    }
    
    /**
     * Determines the operation of which <tt>bodyExpression</tt> is the body. If <tt>bodyOperation</tt>
     * is not the body of an operation in the scope of <tt>mapper</tt>, then <tt>null</tt> is returned.
     */
    private EOperation getOperationFromBody(OCLExpression bodyExpression, OperationBodyToCallMapper mapper) {
        EOperation result = null;
        Set<OperationCallExp> calls = mapper.getCallsOf(bodyExpression);
        if (!calls.isEmpty()) {
            result = calls.iterator().next().getReferredOperation();
        }
        return result;
    }

    /**
     * Determines if a change of <tt>e</tt>'s value from <tt>oldValue</tt> to
     * <tt>newValue</tt> may or may not have an effect on the overall expression by which <tt>e</tt> is used. If this
     * methods returns <tt>true</tt> then this guarantees that the change has no effect. If it returns <tt>false</tt> this only
     * means that the absence of an effect could not be proven and that it is still possible that the change had no effect.
     * <p>
     * 
     * The method first applies partial evaluation along chains of {@link CallExp} and operation calls. If the computation of the
     * full value based on old and new source value reaches the end of such a chain of {@link CallExp} and operation
     * body/operation call constructs, {@link #transitivelyPropagateDelta(OCLExpression, Collection)} tries to
     * propagate the delta between old and new value further. If the result of this delta propagation is empty for all
     * expressions to which it propagates then this proves that the original change indicated by <tt>oldSourceValue</tt>
     * and <tt>newSourceValue</tt> has no effect on the overall expression.
     * 
     * @param mapper
     *            needs to be able to map an operation body in which <tt>callExp</tt> is used to the calls of that operation, as
     *            well as all operation calls in which those calls appear (transitively) to the calls of those operations, and so
     *            on, for the overall expression for which the effect of the change is to be analyzed.
     */
    public boolean hasNoEffectOnOverallExpression(OCLExpression e, Object oldValue, Object newValue,
            OperationBodyToCallMapper mapper) {
        boolean result;
        boolean oldEqualsNew = (oldValue == null && newValue == null) ||
                               (oldValue != null && oldValue.equals(newValue));
        if (oldEqualsNew) {
            result = true;
        } else {
            try {
                if (e.eContainer() != null && e.eContainer() instanceof CallExp && ((CallExp) e.eContainer()).getSource() == e) {
                    // e is source of a CallExp
                    CallExp callExp = (CallExp) e.eContainer();
                    Object oldCallExpValue = evaluate(/* self context */null, callExp, oldValue);
                    Object newCallExpValue = evaluate(/* self context */null, callExp, newValue);
                    result = hasNoEffectOnOverallExpression(callExp, oldCallExpValue, newCallExpValue, mapper);
                } else {
                    // check if it's an operation body
                    EOperation op = getOperationFromBody(e, mapper);
                    if (op != null) {
                        result = true;
                        for (OperationCallExp call : mapper.getCallsOf(e)) {
                            result = hasNoEffectOnOverallExpression(call, oldValue, newValue, mapper);
                            if (!result) {
                                // if one operation call may have an effect then so may the original change
                                break;
                            }
                        }
                    } else {
                        // neither was e the source of a CallExp nor was it the body of an operation that gets called
                        // try delta propagation:
                        Collection<Object> delta = symmetricDifference(oldValue, newValue);
                        result = transitivelyPropagateDelta(e, delta, mapper).isEmpty();
                    }
                }
            } catch (ValueNotFoundException ex) {
                // can't perform the partial evaluation due to access to undefined variable
                result = false; // we don't know, so we have to answer conservatively
            }
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    private Collection<Object> symmetricDifference(Object oldSourceValue, Object newSourceValue) {
        Collection<Object> result;
        Collection<Object> oldSourceValueAsCollection = ((oldSourceValue instanceof Collection<?> ? (Collection<Object>) oldSourceValue
                : Collections.singleton(oldSourceValue)));
        Collection<Object> newSourceValueAsCollection = ((newSourceValue instanceof Collection<?> ? (Collection<Object>) newSourceValue
                : Collections.singleton(newSourceValue)));
        if (oldSourceValueAsCollection instanceof List<?> ||
        		newSourceValueAsCollection instanceof List<?>) {
        	// at least one value is ordered; perform position-by-position comparison
        	result = computeOrderedSymmetricDifference(oldSourceValueAsCollection, newSourceValueAsCollection);
		} else {
			// both values are unordered; compare using set semantics
			result = computeUnorderedSymmetricDifference(oldSourceValueAsCollection, newSourceValueAsCollection);
		}
        return result;
    }

	private Set<Object> computeUnorderedSymmetricDifference(
			Collection<Object> oldSourceValueAsCollection,
			Collection<Object> newSourceValueAsCollection) {
		Set<Object> result = new HashSet<Object>();
		result.addAll(oldSourceValueAsCollection);
		result.removeAll(newSourceValueAsCollection);
		Collection<Object> newSourceValueMinusOldSourceValue = new HashSet<Object>();
		newSourceValueMinusOldSourceValue
				.addAll(newSourceValueAsCollection);
		newSourceValueMinusOldSourceValue
				.removeAll(oldSourceValueAsCollection);
		result.addAll(newSourceValueMinusOldSourceValue);
		return result;
	}

	private List<Object> computeOrderedSymmetricDifference(
			Collection<Object> oldSourceValueAsCollection,
			Collection<Object> newSourceValueAsCollection) {
		List<Object> result = new ArrayList<Object>();
		Iterator<Object> oldIt = oldSourceValueAsCollection.iterator();
		Iterator<Object> newIt = newSourceValueAsCollection.iterator();
		while (oldIt.hasNext() || newIt.hasNext()) {
			Object old = null;
			boolean oldItHadNext = oldIt.hasNext();
			if (oldIt.hasNext()) {
				old = oldIt.next();
			}
			Object nw = null;
			boolean newItHadNext = newIt.hasNext();
			if (newIt.hasNext()) {
				nw = newIt.next();
			}
			if (oldItHadNext && newItHadNext) {
				if (old != nw) {
					result.add(old);
					result.add(nw);
				}
			} else if (oldItHadNext) {
				result.add(old);
			} else {
				result.add(nw);
			}
		}
		return result;
	}

    /**
     * Determines a strategy that can propagate a delta for <tt>e</tt>'s value to a superset of the
     * delta for another expression using <tt>e</tt>. For example, the delta of the source expression
     * of an <tt>asSet()</tt> call propagates to the <tt>asSet()</tt> call expression unchanged.
     * 
     * @return a propagation strategy if the expression using <tt>e</tt> is monotonic in <tt>e</tt> such
     * that mapping <tt>e</tt>'s delta is possible at all, or <tt>null</tt> if no propagation strategy is
     * defined or possible to define for the use of <tt>e</tt>.
     */
    private DeltaPropagationStrategy getDeltaPropagationStrategy(OCLExpression e, OperationBodyToCallMapper mapper) {
        DeltaPropagationStrategy result = null;
        if (e.eContainer() != null && e.eContainer() instanceof CallExp && ((CallExp) e.eContainer()).getSource() == e) {
            CallExp callExp = (CallExp) e.eContainer();
            if (callExp instanceof IteratorExp) {
                IteratorExp loopExp = (IteratorExp) callExp;
                switch (OCLStandardLibraryUtil.getOperationCode(loopExp.getName())) {
                case PredefinedType.COLLECT:
                case PredefinedType.SELECT:
                case PredefinedType.REJECT:
                    // the iterator's delta can be computed from the source delta by applying the iterator to the source delta collection
                    result = new IteratorSourcePropagationStrategy(loopExp, this);
                    break;
                }
            } else if (callExp instanceof OperationCallExp) {
                switch (OCLStandardLibraryUtil.getOperationCode(((OperationCallExp) callExp).getReferredOperation().getName())) {
                case PredefinedType.UNION:
                case PredefinedType.INTERSECTION:
                case PredefinedType.MINUS:
                case PredefinedType.INCLUDING:
                case PredefinedType.EXCLUDING:
                case PredefinedType.APPEND:
                case PredefinedType.PREPEND:
                case PredefinedType.INSERT_AT:
                case PredefinedType.AS_BAG:
                case PredefinedType.AS_ORDERED_SET:
                case PredefinedType.AS_SEQUENCE:
                case PredefinedType.AS_SET:
                case PredefinedType.FLATTEN:
                // case PredefinedType.REVERSE  // not supported as of now
                    // the iterator's delta (superset) equals the source's delta
                    result = new IdentityPropagationStrategy(callExp);
                    break;
                }
            }
        } else {
            // Not the source of a CallExp.
            // Check if e is the last parameter expression of a call to any of the stdlib operations
            // that are monotonic in their last parameter:
            if (e.eContainer() != null && e.eContainer() instanceof OperationCallExp && ((OperationCallExp) e.eContainer()).getArgument().contains(e)) {
                OperationCallExp operationCall = (OperationCallExp) e.eContainer();
                if (e == operationCall.getArgument().get(operationCall.getArgument().size() - 1)) { // last parameter?
                    switch (OCLStandardLibraryUtil.getOperationCode(operationCall.getReferredOperation().getName())) {
                    case PredefinedType.UNION:
                    case PredefinedType.INTERSECTION:
                    case PredefinedType.INCLUDING:
                    case PredefinedType.APPEND:
                    case PredefinedType.PREPEND:
                    case PredefinedType.INSERT_AT:
                        result = new IdentityPropagationStrategy(operationCall);
                        break;
                    }
                }
            } else {
                // not a parameter of an operation; check if e is the thenExpression or elseExpression of an IfExp
                if (e.eContainer() != null
                        && e.eContainer() instanceof IfExp
                        && (((IfExp) e.eContainer()).getThenExpression() == e || ((IfExp) e.eContainer()).getElseExpression() == e)) {
                    result = new IdentityPropagationStrategy((IfExp) e.eContainer());
                } else {
                    // no then or else expression of an IfExp
                    // Check if e is the body of an operation:
                    Set<OperationCallExp> callsOfOperationBody = mapper.getCallsOf(e);
                    if (!callsOfOperationBody.isEmpty()) {
                        result = new OperationBodyPropagationStrategy(mapper);
                    } else {
                        // Not an operation body whose operation is called anywhere in the scope of the overall expression.
                        // Check is e is the body of a ->collect expression
                        if (e.eContainer() != null
                                && e.eContainer() instanceof IteratorExp
                                && ((IteratorExp) e.eContainer()).getBody() == e) {
                            LoopExp loopExp = (LoopExp) e.eContainer();
                            if (OCLStandardLibraryUtil.getOperationCode(loopExp.getName()) == PredefinedType.COLLECT) {
                                result = new IdentityPropagationStrategy(loopExp);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Tries to find a {@link DeltaPropagationStrategy propagation strategy} for the combination of the OCL expression <tt>e</tt>
     * and a given <tt>delta</tt> for its evaluation result. If no such strategy is found, the pair of <tt>e</tt> and
     * <tt>delta</tt> is returned. Otherwise, the strategy is applied, and the <tt>delta</tt> is mapped to a delta for another
     * expression using <tt>e</tt>. The result of this step is recursively passed to this method so that propagation terminates
     * when no propagation strategy can be found for an expression.
     * <p>
     * 
     * When the object collection returned in the {@link Pair#getB b} component of the result is empty then this means that the
     * overall expression in which <tt>e</tt> occurs will not be affected by the <tt>delta</tt> of <tt>e</tt>'s value.
     * <p>
     * 
     * <b>Postcondition</b>:
     * <tt>this.{@link #getDeltaPropagationStrategy(OCLExpression) getDeltaPropagationStrategy}(result.getA()) == null</tt>
     * 
     * @param deltaForEValue
     *            may be null, empty or a valid non-empty collection specifying a delta in <tt>e</tt>'s evaluation result
     * @param mapper
     *            needs to be able to map an operation body in which <tt>callExp</tt> is used to the calls of that operation, as
     *            well as all operation calls in which those calls appear (transitively) to the calls of those operations, and so
     *            on, for the overall expression for which the effect of the change is to be analyzed.
     * @return zero or more pairs with a non-<tt>null</tt>, non-empty {@link Pair#getB b} component which is a collection
     *         specifying the delta to which <tt>delta</tt> maps for the expression returned as the {@link Pair#getA a} component
     *         of the pair contained in the collection returned. If the collection returned is empty this means that
     *         the <tt>delta</tt> of <tt>e</tt>'s value has no effect on the overall expression in which <tt>e</tt> appears.
     */
    public Collection<Pair<OCLExpression, Collection<Object>>> transitivelyPropagateDelta(OCLExpression e, Collection<Object> deltaForEValue,
            OperationBodyToCallMapper mapper) {
        return transitivelyPropagateDelta(e, deltaForEValue, mapper, new HashMap<OCLExpression, Set<Collection<Object>>>());
    }
    
    private Collection<Pair<OCLExpression, Collection<Object>>> transitivelyPropagateDelta(OCLExpression e, Collection<Object> deltaForEValue,
            OperationBodyToCallMapper mapper, Map<OCLExpression, Set<Collection<Object>>> cache) {
        Collection<Pair<OCLExpression, Collection<Object>>> result;
        Set<Collection<Object>> cacheEntry = cache.get(e);
        if (cacheEntry != null && cacheEntry.contains(deltaForEValue)) {
            // we visited the same expression for an equal delta already; the only thing we can do to
            // avoid an endless recursion is stop here, give up and return the current delta for e
            result = getResultCollectionFromSingleDelta(e, deltaForEValue);
        } else {
            if (cacheEntry == null) {
                cacheEntry = new HashSet<Collection<Object>>();
                cache.put(e, cacheEntry);
            }
            cacheEntry.add(deltaForEValue);
            DeltaPropagationStrategy propagationStrategy = getDeltaPropagationStrategy(e, mapper);
            if (propagationStrategy == null) {
                result = getResultCollectionFromSingleDelta(e, deltaForEValue);
            } else {
                Collection<Pair<OCLExpression, Collection<Object>>> propagated = null;
                try {
                    propagated = propagationStrategy.mapDelta(e, deltaForEValue);
                } catch (ValueNotFoundException vnfe) {
                    // that's ok; probably an access to "self" or another variable that isn't known at this time
                }
                if (propagated == null) {
                    result = getResultCollectionFromSingleDelta(e, deltaForEValue);
                } else {
                    result = new HashSet<Pair<OCLExpression, Collection<Object>>>();
                    for (Pair<OCLExpression, Collection<Object>> singlePropagationResult : propagated) {
                        Collection<Pair<OCLExpression, Collection<Object>>> singleResult = transitivelyPropagateDelta(
                                singlePropagationResult.getA(), singlePropagationResult.getB(), mapper, cache);
                        result.addAll(singleResult);
                    }
                }
            }
        }
        return result;
    }

    static Collection<Pair<OCLExpression, Collection<Object>>> getResultCollectionFromSingleDelta(OCLExpression e,
            Collection<Object> delta) {
        Collection<Pair<OCLExpression, Collection<Object>>> result;
        // no (further) propagation possible
        if (delta == null || delta.isEmpty()) {
            // no change anyhow
            result = Collections.emptySet();
        } else {
            result = Collections.singleton(new Pair<OCLExpression, Collection<Object>>(e, delta));
        }
        return result;
    }
}
