/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: OCLstdlibLeft2RightVisitor.java,v 1.6 2011/05/23 05:51:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2pivot;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS;

public class OCLstdlibLeft2RightVisitor extends AbstractOCLstdlibLeft2RightVisitor
{
	public OCLstdlibLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override			// FIXME redundant wrt base functionality
	public Element visitLibConstraintCS(@NonNull LibConstraintCS csConstraint) {
		Constraint pivotConstraint = PivotUtil.getPivot(Constraint.class, csConstraint);
		if (pivotConstraint != null) {
			ExpSpecificationCS csSpecification = (ExpSpecificationCS) csConstraint.getSpecification();
			ExpCS csExpression = csSpecification.getOwnedExpression();
			if (csExpression != null) {
				ExpressionInOCL pivotSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csSpecification);
				if (pivotSpecification != null) {
					pivotConstraint.setSpecification(pivotSpecification);
					context.setContextVariable(pivotSpecification, Environment.SELF_VARIABLE_NAME, null);
					EObject eContainer = csConstraint.eContainer();
					if (eContainer instanceof TypeCS) {
						Type contextType = PivotUtil.getPivot(Type.class, (TypeCS)eContainer);
						if (contextType != null) {
							context.setClassifierContext(pivotSpecification, contextType);
						}
					}
					else if (eContainer instanceof StructuralFeatureCS) {
						Property contextProperty = PivotUtil.getPivot(Property.class, (StructuralFeatureCS)eContainer);
						if (contextProperty != null) {
							context.setPropertyContext(pivotSpecification, contextProperty);
						}
					}
					else if (eContainer instanceof OperationCS) {
						Operation contextOperation = PivotUtil.getPivot(Operation.class, (OperationCS)eContainer);
						if (contextOperation != null) {
							boolean isPostCondition = "post".equals(csConstraint.getStereotype());
							String resultVariableName = isPostCondition ? Environment.RESULT_VARIABLE_NAME : null;
					        context.setOperationContext(pivotSpecification, contextOperation, resultVariableName);
						}
					}
					OCLExpression bodyExpression = context.visitLeft2Right(OCLExpression.class, csExpression);		
					PivotUtil.setBody(pivotSpecification, bodyExpression, ElementUtil.getExpressionText(csExpression));
					context.setType(pivotSpecification, bodyExpression.getType(), bodyExpression.isRequired());
					ExpSpecificationCS csMessageSpecification = (ExpSpecificationCS) csConstraint.getMessageSpecification();
					if (csMessageSpecification != null) {
						ExpCS csMessageExpression = csMessageSpecification.getOwnedExpression();
						if (csMessageExpression != null) {
							OCLExpression messageExpression = context.visitLeft2Right(OCLExpression.class, csMessageExpression);		
							PivotUtil.setMessage(pivotSpecification, messageExpression, ElementUtil.getExpressionText(csMessageExpression));
						}
					}
				}
			}
		}
		return pivotConstraint;
	}

	@Override
	public Element visitPrecedenceCS(@NonNull PrecedenceCS object) {
		return null;
	}
}