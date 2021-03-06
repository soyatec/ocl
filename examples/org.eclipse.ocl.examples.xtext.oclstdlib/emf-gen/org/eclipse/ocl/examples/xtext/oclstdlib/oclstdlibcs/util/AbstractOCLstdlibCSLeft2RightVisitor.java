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
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.xtext.oclstdlib/model/OCLstdlibCS.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCSLeft2RightVisitor;
import org.eclipse.ocl.examples.pivot.Element;

/**
 * An AbstractOCLstdlibCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractOCLstdlibCSLeft2RightVisitor
	extends EssentialOCLCSLeft2RightVisitor
	implements OCLstdlibCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractOCLstdlibCSLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Element visitLibClassCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS csElement) {
		return visitClassCS(csElement);
	}

	public @Nullable Element visitLibConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibConstraintCS csElement) {
		return visitConstraintCS(csElement);
	}

	public @Nullable Element visitLibIterationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS csElement) {
		return visitOperationCS(csElement);
	}

	public @Nullable Element visitLibOperationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS csElement) {
		return visitOperationCS(csElement);
	}

	public @Nullable Element visitLibPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS csElement) {
		return visitPackageCS(csElement);
	}

	public @Nullable Element visitLibPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS csElement) {
		return visitAttributeCS(csElement);
	}

	public @Nullable Element visitLibRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibRootPackageCS csElement) {
		return visitRootPackageCS(csElement);
	}

	public @Nullable Element visitMetaTypeName(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaTypeName csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitPrecedenceCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS csElement) {
		return visitNamedElementCS(csElement);
	}
}
