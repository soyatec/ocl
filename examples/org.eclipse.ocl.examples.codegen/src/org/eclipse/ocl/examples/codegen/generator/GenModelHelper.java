/**
 * <copyright>
 *
 * Copyright (c) 2011,2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 **/
package org.eclipse.ocl.examples.codegen.generator;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;

public interface GenModelHelper
{
	@NonNull Class<?> getAbstractOperationClass(@NonNull List<? extends TypedElement> parameters);
	@NonNull String getGetAccessor(@NonNull Property aProperty) throws GenModelException;
	@NonNull Class<?> getEcoreInterfaceClass(@NonNull Type owningType) throws GenModelException;
//	@Nullable GenClass getGenClass(@NonNull Type type);
	@NonNull Class<?> getOperationInterface(@NonNull List<? extends TypedElement> parameters);
	@Nullable String getQualifiedOperationImplementationName(@NonNull Operation anOperation, @NonNull String stereotype);
	@Nullable String getQualifiedPropertyImplementationName(@NonNull Property aProperty, @NonNull String stereotype);
	@Nullable String getQualifiedLiteralName(@NonNull Operation anOperation);
	@Nullable String getQualifiedLiteralName(@NonNull Property aProperty);
}
