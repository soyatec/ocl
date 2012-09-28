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
 * $Id: EssentialOCLLabelProvider.java,v 1.5 2011/03/08 16:20:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS;

import com.google.inject.Inject;

/**
 * Provides labels for EssentialOCL objects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class EssentialOCLLabelProvider extends BaseLabelProvider
{
	@Inject
	public EssentialOCLLabelProvider(@NonNull AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected void appendTemplateParameter(@NonNull StringBuilder s, TemplateParameterCS templateParameter) {
		appendName(s, templateParameter);
	}

	@Override
	protected void appendType(@NonNull StringBuilder s, Type type) {
		if (type instanceof CollectionTypeCS) {
			appendName(s, (CollectionTypeCS)type);
			s.append("(");
			appendType(s, ((CollectionTypeCS)type).getOwnedType());
			s.append(")");
		}
		else if (type instanceof TupleTypeCS) {
			appendName(s, (TupleTypeCS)type);
			s.append("Tuple(");
			String prefix = "";
			for (TuplePartCS part : ((TupleTypeCS)type).getOwnedParts()) {
				s.append(prefix);
				appendName(s, part);
				s.append(" : ");
				appendType(s, part.getOwnedType());
				prefix = ", ";
			}
			s.append(")");
		}
		else if (type instanceof NameExpCS) {
//			appendName(s, ((NameExpCS)type).getNamedElement());
		}
		else {
			super.appendType(s, type);
		}	
	}

/*	protected String text(InfixExpCS ele) {
		String op = ele.getOp();
		if (!".".equals(op) &&  !"->".equals(op)) {
			return op;
		}
	StringBuilder s = new StringBuilder();
	appendString(s, op);
	ExpCS argument = ele.getArgument();
	if (argument instanceof NamedExpCS) {
		s.append(" ");
		appendName(s, ((NamedExpCS)argument).getName().getNamedElement());
		if (((NamedExpCS) argument).isPre()) {
			s.append(" @pre");
		}
	}
	return s.toString();
	} */

	protected String text(ExpCS ele) {
		return "<<" + ele.eClass().getName() + ">>";
	}

	protected String text(InvocationExpCS ele) {
		return "<<" + ele.eClass().getName() + ">> " + String.valueOf(ele.getNamedElement().getName());
	}

	protected String text(NameExpCS ele) {
		return "<<" + ele.eClass().getName() + ">> " + String.valueOf(ele.getPathName().toString());
	}

	protected String text(NavigatingArgCS ele) {
		return "<<" + ele.eClass().getName() + ">> " + String.valueOf(ele.getName());
	}

	protected String text(OperatorCS ele) {
		return "<<" + ele.eClass().getName() + ">> " + String.valueOf(ele.getName());
	}

}
