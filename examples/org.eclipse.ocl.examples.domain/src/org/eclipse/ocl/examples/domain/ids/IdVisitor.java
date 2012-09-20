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
 * from: model/Pivot.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.ocl.examples.domain.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An IdVisitor supports visting an ElementId to react according to the derived Element type.
 */
public interface IdVisitor<R>
{	
	@Nullable R visitCollectedId(@NonNull CollectedTypeId id);
	@Nullable R visitCollectionId(@NonNull CollectionTypeId id);
	@Nullable R visitEnumerationLiteralId(@NonNull EnumerationLiteralId id);
	@Nullable R visitInvalidId(@NonNull OclInvalidTypeId id);
	@Nullable R visitLambdaId(@NonNull LambdaTypeId id);
	@Nullable R visitNestedPackageId(@NonNull NestedPackageId id);
	@Nullable R visitNestedTypeId(@NonNull NestedTypeId id);
	@Nullable R visitNsURIPackageId(@NonNull NsURIPackageId id);
	@Nullable R visitNullId(@NonNull OclVoidTypeId id);
	@Nullable R visitOperationId(@NonNull OperationId id);
	@Nullable R visitOperationTemplateParameterId(@NonNull OperationTemplateParameterId id);
	@Nullable R visitPrimitiveTypeId(@NonNull PrimitiveTypeId id);
	@Nullable R visitRootPackageId(@NonNull RootPackageId id);
	@Nullable R visitSpecializedTypeId(@NonNull SpecializedTypeId id);
	@Nullable R visitTupleId(@NonNull TupleTypeId id);
	@Nullable R visitTypeTemplateParameterId(@NonNull TypeTemplateParameterId id);
	@Nullable R visitUnspecifiedId(@NonNull UnspecifiedId id);
}
