/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.java.types;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.java.JavaStream.SubStream;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.values.IntegerValue;

/**
 * An IntegerValueDescriptor describes the boxed unbounded polymorphic representation of an OCL Integer.
 */
public class IntegerValueDescriptor extends BoxedValueDescriptor
{
	public IntegerValueDescriptor(@NonNull ElementId elementId) {
		super(elementId, IntegerValue.class, new IntegerObjectDescriptor(elementId));
	}

	@Override
	public void appendCast(@NonNull JavaStream js,
			@Nullable Class<?> actualJavaClass, @Nullable SubStream subStream) {
		// TODO Auto-generated method stub
		super.appendCast(js, actualJavaClass, subStream);
	}

	@Override
	public void appendCastTerm(@NonNull JavaStream js,
			@NonNull CGValuedElement cgElement) {
		// TODO Auto-generated method stub
		super.appendCastTerm(js, cgElement);
	}

	@Override
	public void appendNotEqualsTerm(@NonNull JavaStream js,
			@NonNull CGValuedElement thisValue,
			@NonNull TypeDescriptor thatTypeDescriptor, @NonNull String thatName) {
		// TODO Auto-generated method stub
		super.appendNotEqualsTerm(js, thisValue, thatTypeDescriptor, thatName);
	}

	@Override
	public void appendEqualsValue(@NonNull JavaStream js,
			@NonNull CGValuedElement thisValue,
			@NonNull CGValuedElement thatValue, boolean notEquals) {
		// TODO Auto-generated method stub
		super.appendEqualsValue(js, thisValue, thatValue, notEquals);
	}

	@Override
	public @NonNull Boolean appendUnboxStatements(@NonNull JavaStream js, @NonNull JavaLocalContext localContext,
			@NonNull CGUnboxExp cgUnboxExp, @NonNull CGValuedElement boxedValue) {
		js.appendDeclaration(cgUnboxExp);
		js.append(" = ");
		js.appendValueName(boxedValue);
		js.append(".asNumber();\n");
		return true;
	}
}