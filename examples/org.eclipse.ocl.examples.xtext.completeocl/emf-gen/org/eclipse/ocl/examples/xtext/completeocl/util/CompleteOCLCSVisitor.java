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
 * from: /org.eclipse.ocl.examples.xtext.completeocl/model/CompleteOCLCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.ocl.examples.xtext.completeocl.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface CompleteOCLCSVisitor<R> extends org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitBodyCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS object);
	@Nullable R visitClassifierContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS object);
	@Nullable R visitCompleteOCLDocumentCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS object);
	@Nullable R visitContextConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS object);
	@Nullable R visitContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS object);
	@Nullable R visitContextSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextSpecificationCS object);
	@Nullable R visitDefCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS object);
	@Nullable R visitDefFeatureCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefFeatureCS object);
	@Nullable R visitDefOperationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefOperationCS object);
	@Nullable R visitDefPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefPropertyCS object);
	@Nullable R visitDerCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS object);
	@Nullable R visitFeatureContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS object);
	@Nullable R visitIncludeCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.IncludeCS object);
	@Nullable R visitInitCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS object);
	@Nullable R visitInvCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS object);
	@Nullable R visitOCLMessageArgCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OCLMessageArgCS object);
	@Nullable R visitOperationContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS object);
	@Nullable R visitPackageDeclarationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS object);
	@Nullable R visitPathNameDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PathNameDeclCS object);
	@Nullable R visitPostCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS object);
	@Nullable R visitPreCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS object);
	@Nullable R visitPropertyContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS object);
}
