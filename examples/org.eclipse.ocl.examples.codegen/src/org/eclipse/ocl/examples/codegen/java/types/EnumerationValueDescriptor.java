/**
 * <copyright>
 * 
 * Copyright (c) 2014 CEA LIST and others.
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

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;

public class EnumerationValueDescriptor extends BoxedValueDescriptor
{
	public EnumerationValueDescriptor(@NonNull ElementId elementId) {
		super(elementId, EnumerationLiteralId.class, new UnboxedValueDescriptor(elementId, Enumerator.class));
	}

	@Override
	public void appendEqualsValue(@NonNull JavaStream js, @NonNull CGValuedElement thisValue,
			@NonNull CGValuedElement thatValue, boolean notEquals) {
		js.appendValueName(thisValue);
		js.append(notEquals ? " != " : " == ");
		js.appendValueName(thatValue);
	}
}