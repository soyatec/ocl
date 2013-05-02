/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: BaseLeft2RightVisitor.java,v 1.3 2011/03/01 08:47:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;

public class BaseLeft2RightVisitor extends AbstractExtendingBaseCSVisitor<Element, CS2PivotConversion>
{
	public BaseLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Element visitAnnotationCS(@NonNull AnnotationCS object) {
		return null;
	}

	@Override
	public Element visitClassifierCS(@NonNull ClassifierCS object) {
		return null;
	}

	@Override
	public Element visitConstraintCS(@NonNull ConstraintCS object) {
//		SpecificationCS specification = object.getSpecification();
//		if (specification == null) {
//			return null;
//		}
//		return context.visitLeft2Right(ExpressionInOCL.class, specification);
		return null;
	}

	@Override
	public Element visitDetailCS(@NonNull DetailCS object) {
		return null;
	}

	@Override
	public Element visitOperationCS(@NonNull OperationCS object) {
		return null;
	}

	@Override
	public Element visitParameterCS(@NonNull ParameterCS object) {
		return null;
	}

	@Override
	public Element visitSpecificationCS(@NonNull SpecificationCS object) {
		return null;
	}

	@Override
	public Element visitStructuralFeatureCS(@NonNull StructuralFeatureCS object) {
		return null;
	}

	@Override
	public Element visitTemplateBindingCS(@NonNull TemplateBindingCS object) {
		return null;
	}

	@Override
	public Element visitTemplateParameterCS(@NonNull TemplateParameterCS object) {
		return null;
	}

	@Override
	public Element visitTemplateParameterSubstitutionCS(@NonNull TemplateParameterSubstitutionCS object) {
		return null;
	}

	@Override
	public Element visitTemplateSignatureCS(@NonNull TemplateSignatureCS object) {
		return null;
	}

	@Override
	public Element visitTuplePartCS(@NonNull TuplePartCS object) {
		return null;
	}

	@Override
	public Element visitTupleTypeCS(@NonNull TupleTypeCS object) {
		return null;
	}

	@Override
	public Element visitTypeRefCS(@NonNull TypeRefCS object) {
		return null;
	}

	public Element visiting(@NonNull VisitableCS visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for CS2Pivot Left2Right pass");
	}
}