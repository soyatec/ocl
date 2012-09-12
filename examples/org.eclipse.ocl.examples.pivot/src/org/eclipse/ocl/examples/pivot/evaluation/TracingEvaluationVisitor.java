/**
 * <copyright>
 *
 * Copyright (c) 2007,2011 IBM Corporation and others.
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
 * $Id: TracingEvaluationVisitor.java,v 1.5 2011/05/07 16:41:08 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.evaluation.InvalidEvaluationException;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
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
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;


/**
 * A decorator for evaluation visitors that is installed when evaluation tracing
 * is enabled, to trace interim evaluation results to the console.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class TracingEvaluationVisitor extends EvaluationVisitorDecorator {

    /**
     * Initializes me with the visitor whose evaluation I trace to the console.
     * 
     * @param decorated a real evaluation visitor
     */
    public TracingEvaluationVisitor(@NonNull EvaluationVisitor decorated) {
        super(decorated);
    }

	@Override
	public @NonNull EvaluationVisitor createNestedEvaluator() {
		return new TracingEvaluationVisitor(super.createNestedEvaluator());
	}

	public @NonNull Object evaluate(@NonNull DomainExpression body) {
		return getDelegate().evaluate(body);
	}

	public @NonNull Object evaluate(@NonNull ExpressionInOCL expressionInOCL) {
		return getDelegate().evaluate(expressionInOCL);
	}
	
	public @NonNull EvaluationVisitor getEvaluator() {
		return getDelegate().getEvaluator();
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return getDelegate().getMetaModelManager();
	}

	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return getDelegate().getStandardLibrary();
	}

	public @NonNull ValueFactory getValueFactory() {
		return getDelegate().getValueFactory();
	}

	public boolean isCanceled() {
		return getDelegate().isCanceled();
	}

	public void setCanceled(boolean isCanceled) {
		getDelegate().setCanceled(isCanceled);
	}
	
	public @NonNull NullValue throwInvalidEvaluation(InvalidValueException e) throws InvalidEvaluationException {
	       return getDelegate().throwInvalidEvaluation(e);
	}

	public @NonNull NullValue throwInvalidEvaluation(String message) throws InvalidEvaluationException {
        return getDelegate().throwInvalidEvaluation(message);
	}

	public @NonNull NullValue throwInvalidEvaluation(Throwable e, DomainExpression expression, Object value, String message, Object... bindings) {
	       return getDelegate().throwInvalidEvaluation(e, expression, value, message, bindings);
	}
    
    private Object trace(Object expression, Object value) {
        try {
            PivotPlugin.trace("Evaluate: " + expression); //$NON-NLS-1$
            PivotPlugin.trace("Result  : " + //$NON-NLS-1$
                (value != null ? "OclInvalid" : String.valueOf(value))); //$NON-NLS-1$
        } catch (Exception e) {
            // tracing must not interfere with evaluation
        }
        
        return value;
    }
    
    @Override
    public Object visitAssociationClassCallExp(@NonNull AssociationClassCallExp callExp) {
        return trace(callExp, getDelegate().visitAssociationClassCallExp(callExp));
    }

    @Override
    public Object visitBooleanLiteralExp(@NonNull BooleanLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitBooleanLiteralExp(literalExp));
    }

    @Override
    public Object visitCollectionItem(@NonNull CollectionItem item) {
        return trace(item, getDelegate().visitCollectionItem(item));
    }

    @Override
    public Object visitCollectionLiteralExp(@NonNull CollectionLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitCollectionLiteralExp(literalExp));
    }

    @Override
    public Object visitCollectionRange(@NonNull CollectionRange range) {
        return trace(range, getDelegate().visitCollectionRange(range));
    }

    @Override
    public Object visitConstraint(@NonNull Constraint constraint) {
        return trace(constraint, getDelegate().visitConstraint(constraint));
    }

    @Override
	public Object visitConstructorExp(@NonNull ConstructorExp constraint) {
        return trace(constraint, getDelegate().visitConstructorExp(constraint));
    }

    @Override
    public Object visitEnumLiteralExp(@NonNull EnumLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitEnumLiteralExp(literalExp));
    }

//    @Override
//    public Object visitExpression(OCLExpression expression) {
//        return trace(expression, getDelegate().visitExpression(expression));
//    }

    @Override
    public Object visitExpressionInOCL(@NonNull ExpressionInOCL expression) {
        return trace(expression, getDelegate().visitExpressionInOCL(expression));
    }

    @Override
    public Object visitIfExp(@NonNull IfExp ifExp) {
        return trace(ifExp, getDelegate().visitIfExp(ifExp));
    }

    @Override
    public Object visitIntegerLiteralExp(@NonNull IntegerLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitIntegerLiteralExp(literalExp));
    }

    @Override
    public Object visitInvalidLiteralExp(@NonNull InvalidLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitInvalidLiteralExp(literalExp));
    }

    @Override
    public Object visitLetExp(@NonNull LetExp letExp) {
        return trace(letExp, getDelegate().visitLetExp(letExp));
    }

    @Override
    public Object visitMessageExp(@NonNull MessageExp messageExp) {
        return trace(messageExp, getDelegate().visitMessageExp(messageExp));
    }

    @Override
    public Object visitNullLiteralExp(@NonNull NullLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitNullLiteralExp(literalExp));
    }

    @Override
    public Object visitOperationCallExp(@NonNull OperationCallExp callExp) {
        return trace(callExp, getDelegate().visitOperationCallExp(callExp));
    }

    @Override
    public Object visitPropertyCallExp(@NonNull PropertyCallExp callExp) {
        return trace(callExp, getDelegate().visitPropertyCallExp(callExp));
    }

    @Override
    public Object visitRealLiteralExp(@NonNull RealLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitRealLiteralExp(literalExp));
    }

    @Override
    public Object visitStateExp(@NonNull StateExp stateExp) {
        return trace(stateExp, getDelegate().visitStateExp(stateExp));
    }

    @Override
    public Object visitStringLiteralExp(@NonNull StringLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitStringLiteralExp(literalExp));
    }

    @Override
    public Object visitTupleLiteralExp(@NonNull TupleLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitTupleLiteralExp(literalExp));
    }

    @Override
    public Object visitTupleLiteralPart(@NonNull TupleLiteralPart part) {
        return trace(part, getDelegate().visitTupleLiteralPart(part));
    }

    @Override
    public Object visitTypeExp(@NonNull TypeExp typeExp) {
        return trace(typeExp, getDelegate().visitTypeExp(typeExp));
    }

    @Override
    public Object visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp literalExp) {
        return trace(literalExp, getDelegate().visitUnlimitedNaturalLiteralExp(literalExp));
    }

    @Override
    public Object visitUnspecifiedValueExp(@NonNull UnspecifiedValueExp unspecExp) {
        return trace(unspecExp, getDelegate().visitUnspecifiedValueExp(unspecExp));
    }

    @Override
    public Object visitVariable(@NonNull Variable variable) {
        return trace(variable, getDelegate().visitVariable(variable));
    }

    @Override
    public Object visitVariableExp(@NonNull VariableExp variableExp) {
        return trace(variableExp, getDelegate().visitVariableExp(variableExp));
    }
}
