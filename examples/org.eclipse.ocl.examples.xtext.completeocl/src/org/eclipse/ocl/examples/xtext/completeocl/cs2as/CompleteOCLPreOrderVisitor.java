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
 * $Id: CompleteOCLPreOrderVisitor.java,v 1.11 2011/05/20 15:26:50 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.util.AbstractCompleteOCLPreOrderVisitor;

public class CompleteOCLPreOrderVisitor extends AbstractCompleteOCLPreOrderVisitor
{	
	public CompleteOCLPreOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitClassifierContextDeclCS(@NonNull ClassifierContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDefCS(@NonNull DefCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitOperationContextDeclCS(@NonNull OperationContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPackageDeclarationCS(@NonNull PackageDeclarationCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPropertyContextDeclCS(@NonNull PropertyContextDeclCS csElement) {
		return null;
	}
}