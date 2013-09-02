/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.BaseDeclarationVisitor;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS;

public class EssentialOCLDeclarationVisitor extends BaseDeclarationVisitor
{
	static final Logger logger = Logger.getLogger(EssentialOCLDeclarationVisitor.class);

	public static final @NonNull TuplePartId TUPLE_MESSAGE_STATUS_0 = IdManager.getTuplePartId(0, PivotConstants.MESSAGE_PART_NAME, TypeId.STRING);
	public static final @NonNull TuplePartId TUPLE_MESSAGE_STATUS_1 = IdManager.getTuplePartId(1, PivotConstants.STATUS_PART_NAME, TypeId.BOOLEAN);
	public static final @NonNull TupleTypeId TUPLE_MESSAGE_STATUS = IdManager.getTupleTypeId("Tuple", TUPLE_MESSAGE_STATUS_0, TUPLE_MESSAGE_STATUS_1);

	public EssentialOCLDeclarationVisitor(@NonNull Pivot2CSConversion context) {
		super(context);
	}	

	protected ElementCS refreshConstraint(@NonNull ConstraintCS csElement, @NonNull Constraint object) {
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
			OCLExpression bodyExpression = ((ExpressionInOCL)specification).getBodyExpression();
			if ((bodyExpression instanceof TupleLiteralExp) && (bodyExpression.getTypeId() == TUPLE_MESSAGE_STATUS)) {
				TupleLiteralPart messagePart = DomainUtil.getNamedElement(((TupleLiteralExp)bodyExpression).getPart(), TUPLE_MESSAGE_STATUS_0.getName());
				TupleLiteralPart statusPart = DomainUtil.getNamedElement(((TupleLiteralExp)bodyExpression).getPart(), TUPLE_MESSAGE_STATUS_1.getName());
				OCLExpression messageExpression = messagePart.getInitExpression();
				OCLExpression statusExpression = statusPart.getInitExpression();
				ExpSpecificationCS csMessage = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSTPackage.Literals.EXP_SPECIFICATION_CS, specification);
				csMessage.setExprString(messageExpression != null ? PrettyPrinter.print(messageExpression) : "null");
				csElement.setMessageSpecification(csMessage);
				ExpSpecificationCS csStatus = context.refreshElement(ExpSpecificationCS.class, EssentialOCLCSTPackage.Literals.EXP_SPECIFICATION_CS, specification);
				csStatus.setExprString(statusExpression != null ? PrettyPrinter.print(statusExpression) : "null");
				csElement.setSpecification(csStatus);
				return csElement;
			}
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
		}
		csElement.setSpecification(context.visitDeclaration(SpecificationCS.class, specification));	
		return csElement;
	}

	@Override
	public ElementCS visitConstraint(@NonNull Constraint object) {
		ConstraintCS csElement = context.refreshNamedElement(ConstraintCS.class, BaseCSTPackage.Literals.CONSTRAINT_CS, object);
		if (csElement != null) {
			refreshConstraint(csElement, object);
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
	}	}