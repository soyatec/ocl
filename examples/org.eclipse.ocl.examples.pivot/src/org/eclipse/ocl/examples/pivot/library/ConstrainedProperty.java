/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
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
 * $Id: ConstrainedProperty.java,v 1.1 2011/04/27 06:19:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;

/**
 * An instance of ConstrainedProperty supports evaluation of
 * a relationship defined by constraints.
 */
public class ConstrainedProperty extends AbstractProperty
{
	protected final @NonNull Property property;
	protected /*@LazyNonNull*/ ExpressionInOCL expression = null;
	
	public ConstrainedProperty(@NonNull Property property) {
		this.property = property;
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		ExpressionInOCL expression2 = expression;
		if (expression2 == null) {
			OpaqueExpression defaultExpression = property.getDefaultExpression();
			if (defaultExpression == null) {
				throw new InvalidValueException("No defaultExpression for '{0}'", property);
			}
			expression = expression2 = defaultExpression.getExpressionInOCL();
			if (expression2 == null) {
				throw new InvalidValueException("Bad defaultExpression for '{0}'", property);
			}
		}
		EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
		EvaluationVisitor nestedVisitor = evaluationVisitor.createNestedEvaluator();
		EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
		Variable contextVariable = expression2.getContextVariable();
		if (contextVariable != null) {
			nestedEvaluationEnvironment.add(contextVariable, sourceValue);
		}
		return nestedVisitor.evaluate(expression2);
	}
}
