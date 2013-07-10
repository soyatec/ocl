/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.xtext.completeocl.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLPreOrderVisitor;

public class AbstractCompleteOCLPreOrderVisitor
	extends EssentialOCLPreOrderVisitor implements CompleteOCLCSVisitor<Continuation<?>>
{	
	//
	//	This file is maintained by copying from AbstractExtendingCompleteOCLCSVisitor and changing R to Continuation<?>.
	//
	protected AbstractCompleteOCLPreOrderVisitor(@NonNull CS2PivotConversion context) {
	    super(context);
	}	

	public Continuation<?> visitClassifierContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS object) {
		return visitContextDeclCS(object);
	}

	public Continuation<?> visitCompleteOCLDocumentCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS object) {
		return visitPackageCS(object);
	}

	public Continuation<?> visitContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS object) {
		return visitPathNameDeclCS(object);
	}

	public Continuation<?> visitDefCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS object) {
		return visitTypedElementCS(object);
	}

	public Continuation<?> visitDefOperationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefOperationCS object) {
		return visitDefCS(object);
	}

	public Continuation<?> visitDefPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefPropertyCS object) {
		return visitDefCS(object);
	}

	public Continuation<?> visitFeatureContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS object) {
		return visitContextDeclCS(object);
	}

	public Continuation<?> visitIncludeCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.IncludeCS object) {
		return visitNamedElementCS(object);
	}

	public Continuation<?> visitOCLMessageArgCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OCLMessageArgCS object) {
		return visitExpCS(object);
	}

	public Continuation<?> visitOperationContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS object) {
		return visitFeatureContextDeclCS(object);
	}

	public Continuation<?> visitPackageDeclarationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS object) {
		return visitPathNameDeclCS(object);
	}

	public Continuation<?> visitPathNameDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PathNameDeclCS object) {
		return visitModelElementCS(object);
	}

	public Continuation<?> visitPropertyContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS object) {
		return visitFeatureContextDeclCS(object);
	}
}