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
 * $Id: OCLinEcoreLeft2RightVisitor.java,v 1.9 2011/05/23 05:51:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.cs2pivot;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS;

public class OCLinEcoreLeft2RightVisitor extends AbstractOCLinEcoreLeft2RightVisitor
{
	public OCLinEcoreLeft2RightVisitor(CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Element visitOCLinEcoreConstraintCS(OCLinEcoreConstraintCS csConstraint) {
		Constraint pivotConstraint = PivotUtil.getPivot(Constraint.class, csConstraint);
		ExpSpecificationCS csSpecification = (ExpSpecificationCS) csConstraint.getSpecification();
		pivotConstraint.setIsCallable(csConstraint.isCallable());
		ExpCS csExpression = csSpecification.getOwnedExpression();
		if (csExpression != null) {
			ExpressionInOCL pivotSpecification = PivotUtil.getPivot(ExpressionInOCL.class, csSpecification);
			pivotConstraint.setSpecification(pivotSpecification);
			context.setContextVariable(pivotSpecification, Environment.SELF_VARIABLE_NAME, null);
			EObject eContainer = csConstraint.eContainer();
			if (eContainer instanceof TypeCS) {
				Type contextType = PivotUtil.getPivot(Type.class, (TypeCS)eContainer);
				context.setClassifierContext(pivotSpecification, contextType);
			}
			else if (eContainer instanceof StructuralFeatureCS) {
				Property contextProperty = PivotUtil.getPivot(Property.class, (StructuralFeatureCS)eContainer);
				context.setPropertyContext(pivotSpecification, contextProperty);
			}
			else if (eContainer instanceof OperationCS) {
				Operation contextOperation = PivotUtil.getPivot(Operation.class, (OperationCS)eContainer);
				boolean isPostCondition = UMLReflection.POSTCONDITION.equals(csConstraint.getStereotype());
				String resultVariableName = isPostCondition ? Environment.RESULT_VARIABLE_NAME : null;
				context.setOperationContext(pivotSpecification, contextOperation,resultVariableName);
			}
			OCLExpression bodyExpression = context.visitLeft2Right(OCLExpression.class, csExpression);		
			pivotSpecification.setBodyExpression(bodyExpression);
			if (bodyExpression != null) {
				pivotSpecification.setType(bodyExpression.getType());
			}
			ExpSpecificationCS csMessageSpecification = (ExpSpecificationCS) csConstraint.getMessageSpecification();
			if (csMessageSpecification != null) {
				context.installPivotUsage(csMessageSpecification, pivotSpecification);
				ExpCS csMessageExpression = csMessageSpecification.getOwnedExpression();
				if (csMessageExpression != null) {
					OCLExpression messageExpression = context.visitLeft2Right(OCLExpression.class, csMessageExpression);		
					pivotSpecification.setMessageExpression(messageExpression);
				}
			}
		}
		return pivotConstraint;
	}
}