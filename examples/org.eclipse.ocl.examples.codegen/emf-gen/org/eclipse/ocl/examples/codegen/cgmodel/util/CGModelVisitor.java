/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: model/cgmodel.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.ocl.examples.codegen.cgmodel.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface CGModelVisitor<R>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class, 
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	@Nullable <A> A getAdapter(@NonNull Class<A> adapter);

	/**
     * Return the result of visiting a visitable for which no more specific pivot type method
     * is available.
     */
	@Nullable R visiting(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGElement visitable);

	@Nullable R visitCGBoolean(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean object);
	@Nullable R visitCGBoxExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp object);
	@Nullable R visitCGBuiltInIterationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp object);
	@Nullable R visitCGCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp object);
	@Nullable R visitCGCastParameter(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter object);
	@Nullable R visitCGCatchExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp object);
	@Nullable R visitCGClass(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGClass object);
	@Nullable R visitCGCollectionExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp object);
	@Nullable R visitCGCollectionPart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart object);
	@Nullable R visitCGConstant(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstant object);
	@Nullable R visitCGConstantExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp object);
	@Nullable R visitCGConstraint(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint object);
	@Nullable R visitCGConstructorExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp object);
	@Nullable R visitCGConstructorPart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart object);
	@Nullable R visitCGEcoreClassConstructorExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp object);
	@Nullable R visitCGEcoreDataTypeConstructorExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp object);
	@Nullable R visitCGEcoreOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp object);
	@Nullable R visitCGEcorePropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp object);
	@Nullable R visitCGElement(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGElement object);
	@Nullable R visitCGElementId(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGElementId object);
	@Nullable R visitCGEqualsExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGEqualsExp object);
	@Nullable R visitCGExecutorCompositionProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorCompositionProperty object);
	@Nullable R visitCGExecutorConstructorPart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart object);
	@Nullable R visitCGExecutorNavigationProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorNavigationProperty object);
	@Nullable R visitCGExecutorOperation(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation object);
	@Nullable R visitCGExecutorOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp object);
	@Nullable R visitCGExecutorOppositeProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositeProperty object);
	@Nullable R visitCGExecutorProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty object);
	@Nullable R visitCGExecutorPropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp object);
	@Nullable R visitCGExecutorType(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType object);
	@Nullable R visitCGFinalVariable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable object);
	@Nullable R visitCGGuardExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp object);
	@Nullable R visitCGIfExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp object);
	@Nullable R visitCGInfinity(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGInfinity object);
	@Nullable R visitCGInteger(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGInteger object);
	@Nullable R visitCGInvalid(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid object);
	@Nullable R visitCGIsInvalidExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp object);
	@Nullable R visitCGIsUndefinedExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp object);
	@Nullable R visitCGIterationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp object);
	@Nullable R visitCGIterator(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGIterator object);
	@Nullable R visitCGLetExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp object);
	@Nullable R visitCGLibraryIterateCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp object);
	@Nullable R visitCGLibraryIterationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp object);
	@Nullable R visitCGLibraryOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp object);
	@Nullable R visitCGLibraryPropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp object);
	@Nullable R visitCGLocalVariable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGLocalVariable object);
	@Nullable R visitCGModel(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGModel object);
	@Nullable R visitCGNamedElement(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement object);
	@Nullable R visitCGNull(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGNull object);
	@Nullable R visitCGOperation(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGOperation object);
	@Nullable R visitCGOperationCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp object);
	@Nullable R visitCGPackage(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGPackage object);
	@Nullable R visitCGParameter(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGParameter object);
	@Nullable R visitCGProperty(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGProperty object);
	@Nullable R visitCGPropertyCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp object);
	@Nullable R visitCGReal(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGReal object);
	@Nullable R visitCGSettableVariable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGSettableVariable object);
	@Nullable R visitCGString(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGString object);
	@Nullable R visitCGText(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGText object);
	@Nullable R visitCGTextParameter(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter object);
	@Nullable R visitCGThrowExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp object);
	@Nullable R visitCGTupleExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp object);
	@Nullable R visitCGTuplePart(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart object);
	@Nullable R visitCGTuplePartCallExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp object);
	@Nullable R visitCGTypeExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp object);
	@Nullable R visitCGTypeId(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId object);
	@Nullable R visitCGTypedElement(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement object);
	@Nullable R visitCGUnboxExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp object);
	@Nullable R visitCGValuedElement(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement object);
	@Nullable R visitCGVariable(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGVariable object);
	@Nullable R visitCGVariableExp(@NonNull org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp object);
}
