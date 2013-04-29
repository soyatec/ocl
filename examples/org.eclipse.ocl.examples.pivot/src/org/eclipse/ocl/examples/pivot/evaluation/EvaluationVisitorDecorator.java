/**
 * <copyright>
 *
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EvaluationVisitorDecorator.java,v 1.4 2011/02/08 17:51:47 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * A visitor that decorates another {@link EvaluationVisitor}, to intercept
 * invocations of the <code>visitXxx(...)</code> methods.  By default, every
 * visitation is simply delegated to the decorated visitor.  Subclasses may
 * extend these delegations with any additional behaviour that is required,
 * even replacing calls to the delegate where necessary.
 * <p>
 * This class works together with the {@link AbstractEvaluationVisitor} to
 * ensure that recursive <code>visitXxx()</code> calls are correctly intercepted
 * by me (and not just implemented within the decorated visitor).  Moreover,
 * this works with decorators nested to any depth.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class EvaluationVisitorDecorator extends AbstractExtendingVisitor<Object, Object> implements EvaluationVisitor {

    private final EvaluationVisitor delegate;
    
    protected EvaluationVisitorDecorator(@NonNull EvaluationVisitor decorated) {
        super(Object.class);						// Useless dummy object as context
        assert decorated != null : "cannot decorate a null visitor"; //$NON-NLS-1$
        
        this.delegate = decorated;
        
        decorated.setUndecoratedVisitor(this);
    }

    /**
     * Delegates to my decorated visitor.
     */
	public @NonNull EvaluationVisitor createNestedEvaluator() {
        return getDelegate().createNestedEvaluator();
	}
  
    /**
     * Obtains the visitor that I decorate.
     * 
     * @return my decorated visitor
     */
    @SuppressWarnings("null")
	protected final @NonNull EvaluationVisitor getDelegate() {
        return delegate;
    }
    
    /**
     * Obtains my delegate's environment.
     */
    public Environment getEnvironment() {
        return getDelegate().getEnvironment();
    }

    /**
     * Obtains my delegate's evaluation environment.
     */
    public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
        return getDelegate().getEvaluationEnvironment();
    }

    /**
     * Obtains my delegate's extent map.
     */
    public @NonNull DomainModelManager getModelManager() {
        return getDelegate().getModelManager();
    }

    /**
     * Delegates to my decorated visitor.
     */
	public void setUndecoratedVisitor(@NonNull EvaluationVisitor evaluationVisitor) {
        getDelegate().setUndecoratedVisitor(evaluationVisitor);
	}

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitConstraint(@NonNull Constraint constraint) {
        return getDelegate().visitConstraint(constraint);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitAssociationClassCallExp(
            @NonNull AssociationClassCallExp callExp) {
        return getDelegate().visitAssociationClassCallExp(callExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitBooleanLiteralExp(@NonNull BooleanLiteralExp literalExp) {
        return getDelegate().visitBooleanLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitCollectionItem(@NonNull CollectionItem item) {
        return getDelegate().visitCollectionItem(item);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitCollectionLiteralExp(@NonNull CollectionLiteralExp literalExp) {
        return getDelegate().visitCollectionLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitCollectionRange(@NonNull CollectionRange range) {
        return getDelegate().visitCollectionRange(range);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitConstructorExp(@NonNull ConstructorExp constructorExp) {
        return getDelegate().visitConstructorExp(constructorExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitEnumLiteralExp(@NonNull EnumLiteralExp literalExp) {
        return getDelegate().visitEnumLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitExpressionInOCL(@NonNull ExpressionInOCL expression) {
        return getDelegate().visitExpressionInOCL(expression);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitIfExp(@NonNull IfExp ifExp) {
        return getDelegate().visitIfExp(ifExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitIntegerLiteralExp(@NonNull IntegerLiteralExp literalExp) {
        return getDelegate().visitIntegerLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitInvalidLiteralExp(@NonNull InvalidLiteralExp literalExp) {
        return getDelegate().visitInvalidLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitLetExp(@NonNull LetExp letExp) {
        return getDelegate().visitLetExp(letExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitMessageExp(@NonNull MessageExp messageExp) {
        return getDelegate().visitMessageExp(messageExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitNullLiteralExp(@NonNull NullLiteralExp literalExp) {
        return getDelegate().visitNullLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitOperationCallExp(@NonNull OperationCallExp callExp) {
        return getDelegate().visitOperationCallExp(callExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitPropertyCallExp(@NonNull PropertyCallExp callExp) {
        return getDelegate().visitPropertyCallExp(callExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitRealLiteralExp(@NonNull RealLiteralExp literalExp) {
        return getDelegate().visitRealLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitStateExp(@NonNull StateExp stateExp) {
        return getDelegate().visitStateExp(stateExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitStringLiteralExp(@NonNull StringLiteralExp literalExp) {
        return getDelegate().visitStringLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitTupleLiteralExp(@NonNull TupleLiteralExp literalExp) {
        return getDelegate().visitTupleLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitTupleLiteralPart(@NonNull TupleLiteralPart part) {
        return getDelegate().visitTupleLiteralPart(part);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitTypeExp(@NonNull TypeExp typeExp) {
        return getDelegate().visitTypeExp(typeExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitUnlimitedNaturalLiteralExp(
            @NonNull UnlimitedNaturalLiteralExp literalExp) {
        return getDelegate().visitUnlimitedNaturalLiteralExp(literalExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitUnspecifiedValueExp(@NonNull UnspecifiedValueExp unspecExp) {
        return getDelegate().visitUnspecifiedValueExp(unspecExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitVariable(@NonNull Variable variable) {
        return getDelegate().visitVariable(variable);
    }

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public Object visitVariableExp(@NonNull VariableExp variableExp) {
        return getDelegate().visitVariableExp(variableExp);
    }

    /**
     * Delegates to my decorated visitor.
     */
	public Object visiting(@NonNull Visitable visitable) {
        return getDelegate().visiting(visitable);
	}
}
