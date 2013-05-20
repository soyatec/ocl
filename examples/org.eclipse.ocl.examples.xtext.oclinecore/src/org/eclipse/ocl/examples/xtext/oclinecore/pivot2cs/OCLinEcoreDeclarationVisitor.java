/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
 * $Id: OCLinEcoreDeclarationVisitor.java,v 1.8 2011/05/14 10:38:08 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.pivot2cs;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs.EssentialOCLDeclarationVisitor;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.SysMLCS;

public class OCLinEcoreDeclarationVisitor extends EssentialOCLDeclarationVisitor
{
	public OCLinEcoreDeclarationVisitor(@NonNull Pivot2CSConversion context) {
		super(context);
	}

	@Override
	public ElementCS visitAnnotation(@NonNull Annotation object) {
		if (PivotConstants.SYSML_ANNOTATION_SOURCE.equals(object.getName())) {
			SysMLCS csElement = context.refreshElement(SysMLCS.class, OCLinEcoreCSTPackage.Literals.SYS_MLCS, object);
//			context.refreshList(csElement.getOwnedAnnotation(), context.visitDeclarations(AnnotationCS.class, object.getOwnedAnnotation(), null));
			context.refreshList(csElement.getOwnedDetail(), context.visitDeclarations(DetailCS.class, object.getOwnedDetail(), null));
			return csElement;
		}
		else {
			return super.visitAnnotation(object);
		}
	}

	@Override
	public ElementCS visitConstraint(@NonNull Constraint object) {
		OCLinEcoreConstraintCS csElement = context.refreshNamedElement(OCLinEcoreConstraintCS.class, OCLinEcoreCSTPackage.Literals.OC_LIN_ECORE_CONSTRAINT_CS, object);
		csElement.setCallable(object.isCallable());
		if (object.eContainmentFeature() == PivotPackage.Literals.OPERATION__POSTCONDITION) {
			csElement.setStereotype(UMLReflection.POSTCONDITION);
		}
		else if (object.eContainmentFeature() == PivotPackage.Literals.OPERATION__PRECONDITION) {
			csElement.setStereotype(UMLReflection.PRECONDITION);
		}
		else {
			csElement.setStereotype(UMLReflection.INVARIANT);
		}
		OpaqueExpression specification = object.getSpecification();
		if (specification != null) {
			csElement.setSpecification(context.visitDeclaration(SpecificationCS.class, specification));
			String message = PivotUtil.getMessage(specification);
			if ((message != null) && (message.length() > 0)) {
				int lastComment = message.lastIndexOf("--");
				if (lastComment >= 0) {
					int lastNewLine = message.lastIndexOf("\n");
					if (lastNewLine < lastComment) {
						message += "\n";				// Avoid the trailing ';' getting added within the comment
					}
				}
				ExpSpecificationCS csMessageElement = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSTPackage.Literals.EXP_SPECIFICATION_CS, specification);
				csMessageElement.setExprString(message);
				csElement.setMessageSpecification(csMessageElement);
			}
		}
		return csElement;
	}

	@Override
	public ElementCS visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		ExpSpecificationCS csElement = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSTPackage.Literals.EXP_SPECIFICATION_CS, object);
		OCLExpression bodyExpression = object.getBodyExpression();
		if (bodyExpression != null) {
			String body = PrettyPrinter.print(bodyExpression);
			csElement.setExprString(body);
		}
		return csElement;
	}

	@Override
	public ElementCS visitOpaqueExpression(@NonNull OpaqueExpression object) {
		String body = PivotUtil.getBody(object);
		if (body == null) {
			return null;
		}
		ExpSpecificationCS csElement = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSTPackage.Literals.EXP_SPECIFICATION_CS, object);
		csElement.setExprString(body);
		return csElement;
	}	
}