/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
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
 * from: model/OCLstdlibCST.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * An AbstractExtendingDelegatingOCLstdlibCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingOCLstdlibCSVisitor<R, C, D extends EssentialOCLCSVisitor<R>>
	extends AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements OCLstdlibCSVisitor<R>
{
	protected AbstractExtendingDelegatingOCLstdlibCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitLibClassCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS object) {
		return delegate.visitClassCS(object);
	}

	public @Nullable R visitLibConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibConstraintCS object) {
		return delegate.visitConstraintCS(object);
	}

	public @Nullable R visitLibIterationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS object) {
		return delegate.visitOperationCS(object);
	}

	public @Nullable R visitLibOperationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS object) {
		return delegate.visitOperationCS(object);
	}

	public @Nullable R visitLibPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS object) {
		return delegate.visitPackageCS(object);
	}

	public @Nullable R visitLibPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS object) {
		return delegate.visitAttributeCS(object);
	}

	public @Nullable R visitLibRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibRootPackageCS object) {
		return delegate.visitRootPackageCS(object);
	}

	public @Nullable R visitMetaTypeName(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaTypeName object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitPrecedenceCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS object) {
		return delegate.visitNamedElementCS(object);
	}
}