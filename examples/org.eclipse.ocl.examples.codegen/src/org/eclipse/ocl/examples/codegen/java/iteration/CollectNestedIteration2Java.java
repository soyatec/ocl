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
package org.eclipse.ocl.examples.codegen.java.iteration;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp;
import org.eclipse.ocl.examples.codegen.java.JavaStream;

public class CollectNestedIteration2Java extends AbstractAccumulation2Java
{
	public static final @NonNull CollectNestedIteration2Java INSTANCE = new CollectNestedIteration2Java();
	
	public void appendUpdate(@NonNull JavaStream js, @NonNull CGBuiltInIterationCallExp cgWhileExp) {
		CGValuedElement cgBody = getBody(cgWhileExp);
		CGIterator cgAccumulator = getAccumulator(cgWhileExp);
		js.appendValueName(cgAccumulator);
		js.append(".add(");
		js.appendValueName(cgBody);
		js.append(");\n");
	}
}