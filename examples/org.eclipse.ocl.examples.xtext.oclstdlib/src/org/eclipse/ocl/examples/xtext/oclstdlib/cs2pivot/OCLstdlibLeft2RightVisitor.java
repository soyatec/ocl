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
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS;

public class OCLstdlibLeft2RightVisitor extends AbstractOCLstdlibLeft2RightVisitor
{
	public OCLstdlibLeft2RightVisitor(CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Element visitLibConstraintCS(LibConstraintCS csConstraint) {
		Constraint pivotConstraint = PivotUtil.getPivot(Constraint.class, csConstraint);
		ExpSpecificationCS csSpecification = (ExpSpecificationCS) csConstraint.getSpecification();
		ExpCS csExpression = csSpecification.getOwnedExpression();
		if (csExpression != null) {
			ExpressionInOcl pivotSpecification = PivotUtil.getPivot(ExpressionInOcl.class, csSpecification);
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
				boolean isPostCondition = "post".equals(csConstraint.getStereotype());
				String resultVariableName = isPostCondition ? Environment.RESULT_VARIABLE_NAME : null;
		        context.setOperationContext(pivotSpecification, contextOperation, resultVariableName);
			}
			OclExpression bodyExpression = context.visitLeft2Right(OclExpression.class, csExpression);		
			pivotSpecification.setBodyExpression(bodyExpression);
			ExpSpecificationCS csMessageSpecification = (ExpSpecificationCS) csConstraint.getMessageSpecification();
			if (csMessageSpecification != null) {
				ExpCS csMessageExpression = csMessageSpecification.getOwnedExpression();
				if (csMessageExpression != null) {
					OclExpression messageExpression = context.visitLeft2Right(OclExpression.class, csMessageExpression);		
					pivotSpecification.setMessageExpression(messageExpression);
				}
			}
		}
		return pivotConstraint;
	}

	@Override
	public Element visitPrecedenceCS(PrecedenceCS object) {
		return null;
	}
}