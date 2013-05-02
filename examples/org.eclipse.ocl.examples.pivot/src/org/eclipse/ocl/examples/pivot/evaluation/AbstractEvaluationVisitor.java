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
 *   Zeligsoft - Bugs 238050, 253252
 *   Radek Dvorak - Bugs 261128, 265066
 *
 * </copyright>
 *
 * $Id: AbstractEvaluationVisitor.java,v 1.8 2011/05/07 16:41:08 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainLogger;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * An evaluation visitor implementation for OCL expressions.
 * <p>
 * <b>Note</b> that this class is not intended to be used or extended by
 * clients.  Use the {@link AbstractEvaluationVisitor} interface, instead.
 * </p>
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractEvaluationVisitor
	extends AbstractExtendingVisitor<Object, Object> implements EvaluationVisitor {

    // stereotypes associated with boolean-valued constraints
//	private static @NonNull Set<String> BOOLEAN_CONSTRAINTS;
	
	protected final @NonNull EvaluationEnvironment evaluationEnvironment;
	protected final @NonNull Environment environment;
	protected final @NonNull MetaModelManager metaModelManager;	
	protected final @NonNull DomainModelManager modelManager;

    private @NonNull EvaluationVisitor undecoratedVisitor;
	private DomainLogger logger = new DomainLogger()
	{
		public void append(@NonNull String message) {
			System.out.append(message);
		}		
	};

    /**
     * Set true by {@link #setCanceled} to terminate execution at next call to {@link #getValuefactory()}.
     */
	private boolean isCanceled = false;
    
//	static {
//		BOOLEAN_CONSTRAINTS = new java.util.HashSet<String>();
//		BOOLEAN_CONSTRAINTS.add(UMLReflection.INVARIANT);
//		BOOLEAN_CONSTRAINTS.add(UMLReflection.PRECONDITION);
//		BOOLEAN_CONSTRAINTS.add(UMLReflection.POSTCONDITION);
//	}
	
	/**
	 * Initializes me.
	 * 
     * @param env the current environment
	 * @param evalEnv an evaluation environment (map of variable names to values)
	 * @param modelManager a map of classes to their instance sets
	 */
	protected AbstractEvaluationVisitor(@NonNull Environment env, @NonNull EvaluationEnvironment evalEnv,
			@NonNull DomainModelManager modelManager) {
        super(Object.class);						// Useless dummy object as context
        this.evaluationEnvironment = evalEnv;
        this.environment = env;
        this.metaModelManager = env.getMetaModelManager();
        this.modelManager = modelManager;
        this.undecoratedVisitor = this;  // assume I have no decorator
    }

    // implements the interface method
	public @NonNull Environment getEnvironment() {
		return environment;
	}
    
    // implements the interface method
	public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
		return evaluationEnvironment;
	}

	public @NonNull IdResolver getIdResolver() {
		return metaModelManager.getIdResolver();
	}

	public @Nullable DomainLogger getLogger() {
		return logger;
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}
	
    // implements the interface method
	public @NonNull DomainModelManager getModelManager() {
		return modelManager;
	}

	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return metaModelManager;
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value) {
		return metaModelManager.getIdResolver().getStaticTypeOf(value);
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
		return metaModelManager.getIdResolver().getStaticTypeOf(value, values);
	}
 
	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		return metaModelManager.getIdResolver().getStaticTypeOf(value, values);
	}
 
    /**
     * Obtains the visitor on which I perform nested
     * {@link Visitable#accept(org.eclipse.ocl.utilities.Visitor)} calls.  This
     * handles the case in which I am decorated by another visitor that must
     * intercept every <tt>visitXxx()</tt> method.  If I internally just
     * recursively visit myself, then this decorator is cut out of the picture.
     * 
     * @return my delegate visitor, which may be my own self or some other
     */
	protected final @NonNull EvaluationVisitor getUndecoratedVisitor() {
        return undecoratedVisitor;
    }
    
    /**
     * Obtains the visitor on which I perform nested
     * {@link Visitable#accept(org.eclipse.ocl.utilities.Visitor)} calls.  This
     * handles the case in which I am decorated by another visitor that must
     * intercept every <tt>visitXxx()</tt> method.  If I internally just
     * recursively visit myself, then this decorator is cut out of the picture.
     * 
     * @return my delegate visitor, which may be my own self or some other
     * 
     * @deprecated use {@link #getUndecoratedVisitor}
     */
	@Deprecated
    protected final EvaluationVisitor getVisitor() {
        return undecoratedVisitor;
    }

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public void setLogger(@Nullable DomainLogger logger) {
		this.logger = logger;
	}

    /**
     * Sets the visitor on which I perform nested
     * {@link Visitable#accept(org.eclipse.ocl.utilities.Visitor)} calls.
     * 
     * @param visitor my delegate visitor
     * 
     * @see #getUndecoratedVisitor()
     */
	public void setUndecoratedVisitor(@NonNull EvaluationVisitor evaluationVisitor) {
        this.undecoratedVisitor = evaluationVisitor;
	}
    
    /**
     * Sets the visitor on which I perform nested
     * {@link Visitable#accept(org.eclipse.ocl.utilities.Visitor)} calls.
     * 
     * @param visitor my delegate visitor
     * 
     * @see #getVisitor()
     * 
     * @deprecated use {@link #setUndecoratedVisitor}
     */
	@Deprecated
    void setVisitor(@NonNull EvaluationVisitor visitor) {
		setUndecoratedVisitor(visitor);
    }
	
	@Override
    public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (evaluation environment: ");//$NON-NLS-1$
		result.append(getEvaluationEnvironment());
		result.append(')');
		return result.toString();
	}

	/**
	 * This default implementation asserts that the <tt>constraint</tt> is
	 * boolean-valued if it is an invariant, pre-condition, or post-condition
	 * constraint and returns the value of its body expression by delegation to
	 * {@link #visitExpression(OCLExpression)}.
	 */
	@Override
    public Object visitConstraint(@NonNull Constraint constraint) {
		OpaqueExpression specification = constraint.getSpecification();
		if (!(specification instanceof ExpressionInOCL)) {
			return null;
		}
		OCLExpression body = ((ExpressionInOCL)specification).getBodyExpression();
//		boolean isBoolean = BOOLEAN_CONSTRAINTS.contains(constraint.getStereotype());
		
		if (body == null) {
			throw new IllegalArgumentException("constraint has no body expression"); //$NON-NLS-1$
		}
		
//		if (isBoolean && !(body.getType() != metaModelManager.getBooleanType())) {
//			throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
//		}
		
		Object result = body.accept(getUndecoratedVisitor());
//		try {
//			if (result == null) {
//				return evaluationEnvironment.throwInvalidEvaluation("null constraint result");
//			}
			return ValuesUtil.asBoolean(result);
//		} catch (InvalidValueException e) {
//			return e.getValue();
//		}
	}
} //EvaluationVisitorImpl
