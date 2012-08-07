/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * This code is auto-generated
 * from: /org.eclipse.ocl.examples.xtext.oclstdlib/model/OCLstdlibCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.ocl.examples.xtext.oclstdlib.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingOCLstdlibCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingOCLstdlibCSVisitor<R, C>
	extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements OCLstdlibCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingOCLstdlibCSVisitor(@Nullable C context) {
	    super(context);
	}	

	public @Nullable R visitLibClassCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS object) {
		return visitClassCS(object);
	}

	public @Nullable R visitLibConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS object) {
		return visitConstraintCS(object);
	}

	public @Nullable R visitLibIterationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS object) {
		return visitOperationCS(object);
	}

	public @Nullable R visitLibOperationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS object) {
		return visitOperationCS(object);
	}

	public @Nullable R visitLibPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPackageCS object) {
		return visitPackageCS(object);
	}

	public @Nullable R visitLibPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS object) {
		return visitAttributeCS(object);
	}

	public @Nullable R visitLibRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS object) {
		return visitRootPackageCS(object);
	}

	public @Nullable R visitMetaTypeName(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.MetaTypeName object) {
		return visiting(object);
	}

	public @Nullable R visitPrecedenceCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS object) {
		return visitNamedElementCS(object);
	}
}
