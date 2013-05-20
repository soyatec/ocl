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
 * $Id: CompleteOCLPostOrderVisitor.java,v 1.9 2011/05/20 19:51:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.cs2pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefOperationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefPropertyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.IncludeCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;

public class CompleteOCLPostOrderVisitor extends AbstractCompleteOCLPostOrderVisitor
{
	public CompleteOCLPostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitClassifierContextDeclCS(@NonNull ClassifierContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitCompleteOCLDocumentCS(@NonNull CompleteOCLDocumentCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitContextDeclCS(@NonNull ContextDeclCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDefOperationCS(@NonNull DefOperationCS csElement) {
		Operation contextOperation = PivotUtil.getPivot(Operation.class, csElement);
		if (contextOperation != null) {
			context.refreshRequiredType(contextOperation, csElement);		// FIXME type consistency check
		}
		return null;
	}

	@Override
	public Continuation<?> visitDefPropertyCS(@NonNull DefPropertyCS csElement) {
		Property contextProperty = PivotUtil.getPivot(Property.class, csElement);
		if (contextProperty != null) {
			context.refreshRequiredType(contextProperty, csElement);		// FIXME type consistency check
		}
		return null;
	}

	@Override
	public Continuation<?> visitIncludeCS(@NonNull IncludeCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitOperationContextDeclCS(@NonNull OperationContextDeclCS csElement) {
		Operation modelOperation = csElement.getOperation();
		if ((modelOperation != null) && !modelOperation.eIsProxy()) {
			Operation contextOperation = PivotUtil.getPivot(Operation.class, csElement);
			if (contextOperation != null) {
				context.refreshName(contextOperation, DomainUtil.nonNullModel(modelOperation.getName()));
				context.setType(contextOperation, modelOperation.getType(), modelOperation.isRequired());		// FIXME type consistency check
			}
		}
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