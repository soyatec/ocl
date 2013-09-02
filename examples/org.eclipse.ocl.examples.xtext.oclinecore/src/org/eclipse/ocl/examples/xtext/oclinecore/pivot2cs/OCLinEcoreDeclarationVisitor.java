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
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
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
		if (specification instanceof ExpressionInOCL) {
			csElement.setSpecification(context.visitDeclaration(SpecificationCS.class, specification));	
		}
		else if (specification != null) {
			String body = PivotUtil.getBody(specification);
			if ((body != null) && body.startsWith("Tuple")) {
				String[] lines = body.split("\n");
				if ((lines.length == 4)
				 && lines[0].replaceAll("\\s", "").equals("Tuple{")
				 && lines[1].endsWith(",")
				 && lines[3].trim().equals("}")
				 && lines[1].replaceAll("\\s", "").startsWith("message:String=")
				 && lines[2].replaceAll("\\s", "").startsWith("status:Boolean=")) {
					String messageText = lines[1].substring(lines[1].indexOf("=")+1, lines[1].length()-1).trim();
					ExpSpecificationCS csMessage = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSTPackage.Literals.EXP_SPECIFICATION_CS, specification);
					csMessage.setExprString(messageText);
					csElement.setMessageSpecification(csMessage);
					String statusText = lines[2].substring(lines[2].indexOf("=")+1).trim();
					ExpSpecificationCS csStatus = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSTPackage.Literals.EXP_SPECIFICATION_CS, specification);
					csStatus.setExprString(statusText);
					csElement.setSpecification(csStatus);
					return csElement;
				}
			}
			csElement.setSpecification(context.visitDeclaration(SpecificationCS.class, specification));	
		}
		return csElement;
	}

	@Override
	public ElementCS visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		ExpSpecificationCS csElement = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSTPackage.Literals.EXP_SPECIFICATION_CS, object);
		OCLExpression bodyExpression = object.getBodyExpression();
		if (bodyExpression != null) {
			assert !(bodyExpression instanceof TupleLiteralExp);
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
/*		if (body.startsWith("Tuple")) {
			String[] lines = body.split("\n");
			if ((lines.length == 4)
			 && lines[0].replaceAll("\\s", "").equals("Tuple{")
			 && lines[1].endsWith(",")
			 && lines[3].trim().equals("}")
			 && lines[1].replaceAll("\\s", "").startsWith("message:String=")
			 && lines[2].replaceAll("\\s", "").startsWith("status:Boolean=")) {
				String messageText = lines[1].substring(lines[1].indexOf("=")+1, lines[1].length()-1).trim();
				String statusText = lines[2].substring(lines[2].indexOf("=")+1).trim();
				ExpSpecificationCS csElement = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSTPackage.Literals.EXP_SPECIFICATION_CS, object);
				csElement.setExprString(statusText);
				return csElement;
			}
		}
//		assert !body.contains("Tuple"); */
		ExpSpecificationCS csElement = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSTPackage.Literals.EXP_SPECIFICATION_CS, object);
		csElement.setExprString(body);
		return csElement;
	}	
}