/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
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
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.autogen/model/autocgmodel.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.ocl.examples.autogen.autocgmodel.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingAutoCGModelVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingAutoCGModelVisitor<R, C>
	extends org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractExtendingCGModelVisitor<R, C>
	implements AutoCGModelVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingAutoCGModelVisitor(@NonNull C context) {
		super(context);
	}	

	public @Nullable R visitCGASTCallExp(@NonNull org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp object) {
		return visitCGOperationCallExp(object);
	}

	public @Nullable R visitCGContainmentBody(@NonNull org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody object) {
		return visitCGValuedElement(object);
	}

	public @Nullable R visitCGContainmentPart(@NonNull org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart object) {
		return visitCGValuedElement(object);
	}

	public @Nullable R visitCGContainmentVisit(@NonNull org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit object) {
		return visitCGOperation(object);
	}
}
