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
 */
package org.eclipse.ocl.examples.codegen.cgmodel;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage
 * @generated
 */
public interface CGModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull CGModelFactory eINSTANCE = org.eclipse.ocl.examples.codegen.cgmodel.impl.CGModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CG Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Boolean</em>'.
	 * @generated
	 */
	@NonNull CGBoolean createCGBoolean();

	/**
	 * Returns a new object of class '<em>CG Box Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Box Exp</em>'.
	 * @generated
	 */
	@NonNull CGBoxExp createCGBoxExp();

	/**
	 * Returns a new object of class '<em>CG Built In Iteration Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Built In Iteration Call Exp</em>'.
	 * @generated
	 */
	CGBuiltInIterationCallExp createCGBuiltInIterationCallExp();

	/**
	 * Returns a new object of class '<em>CG Cast Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Cast Parameter</em>'.
	 * @generated
	 */
	@NonNull CGCastParameter createCGCastParameter();

	/**
	 * Returns a new object of class '<em>CG Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Class</em>'.
	 * @generated
	 */
	@NonNull CGClass createCGClass();

	/**
	 * Returns a new object of class '<em>CG Catch Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Catch Exp</em>'.
	 * @generated
	 */
	@NonNull CGCatchExp createCGCatchExp();

	/**
	 * Returns a new object of class '<em>CG Collection Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Collection Exp</em>'.
	 * @generated
	 */
	@NonNull CGCollectionExp createCGCollectionExp();

	/**
	 * Returns a new object of class '<em>CG Collection Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Collection Part</em>'.
	 * @generated
	 */
	@NonNull CGCollectionPart createCGCollectionPart();

	/**
	 * Returns a new object of class '<em>CG Final Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Final Variable</em>'.
	 * @generated
	 */
	@NonNull CGFinalVariable createCGFinalVariable();

	/**
	 * Returns a new object of class '<em>CG Guard Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Guard Exp</em>'.
	 * @generated
	 */
	@NonNull CGGuardExp createCGGuardExp();

	/**
	 * Returns a new object of class '<em>CG Ecore Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Ecore Operation Call Exp</em>'.
	 * @generated
	 */
	@NonNull CGEcoreOperationCallExp createCGEcoreOperationCallExp();

	/**
	 * Returns a new object of class '<em>CG Ecore Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Ecore Property Call Exp</em>'.
	 * @generated
	 */
	@NonNull CGEcorePropertyCallExp createCGEcorePropertyCallExp();

	/**
	 * Returns a new object of class '<em>CG Element Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Element Id</em>'.
	 * @generated
	 */
	@NonNull CGElementId createCGElementId();

	/**
	 * Returns a new object of class '<em>CG Equals Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Equals Exp</em>'.
	 * @generated
	 */
	CGEqualsExp createCGEqualsExp();

	/**
	 * Returns a new object of class '<em>CG Executor Composition Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Executor Composition Property</em>'.
	 * @generated
	 */
	@NonNull CGExecutorCompositionProperty createCGExecutorCompositionProperty();

	/**
	 * Returns a new object of class '<em>CG Executor Constructor Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Executor Constructor Part</em>'.
	 * @generated
	 */
	@NonNull CGExecutorConstructorPart createCGExecutorConstructorPart();

	/**
	 * Returns a new object of class '<em>CG Executor Navigation Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Executor Navigation Property</em>'.
	 * @generated
	 */
	@NonNull CGExecutorNavigationProperty createCGExecutorNavigationProperty();

	/**
	 * Returns a new object of class '<em>CG Executor Opposite Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Executor Opposite Property</em>'.
	 * @generated
	 */
	@NonNull CGExecutorOppositeProperty createCGExecutorOppositeProperty();

	/**
	 * Returns a new object of class '<em>CG Executor Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Executor Operation</em>'.
	 * @generated
	 */
	@NonNull CGExecutorOperation createCGExecutorOperation();

	/**
	 * Returns a new object of class '<em>CG Executor Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Executor Operation Call Exp</em>'.
	 * @generated
	 */
	@NonNull CGExecutorOperationCallExp createCGExecutorOperationCallExp();

	/**
	 * Returns a new object of class '<em>CG Executor Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Executor Property Call Exp</em>'.
	 * @generated
	 */
	@NonNull CGExecutorPropertyCallExp createCGExecutorPropertyCallExp();

	/**
	 * Returns a new object of class '<em>CG Executor Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Executor Type</em>'.
	 * @generated
	 */
	@NonNull CGExecutorType createCGExecutorType();

	/**
	 * Returns a new object of class '<em>CG Infinity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Infinity</em>'.
	 * @generated
	 */
	@NonNull CGInfinity createCGInfinity();

	/**
	 * Returns a new object of class '<em>CG Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Integer</em>'.
	 * @generated
	 */
	@NonNull CGInteger createCGInteger();

	/**
	 * Returns a new object of class '<em>CG Invalid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Invalid</em>'.
	 * @generated
	 */
	@NonNull CGInvalid createCGInvalid();

	/**
	 * Returns a new object of class '<em>CG Is Invalid Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Is Invalid Exp</em>'.
	 * @generated
	 */
	CGIsInvalidExp createCGIsInvalidExp();

	/**
	 * Returns a new object of class '<em>CG Is Undefined Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Is Undefined Exp</em>'.
	 * @generated
	 */
	CGIsUndefinedExp createCGIsUndefinedExp();

	/**
	 * Returns a new object of class '<em>CG Iterator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Iterator</em>'.
	 * @generated
	 */
	@NonNull CGIterator createCGIterator();

	/**
	 * Returns a new object of class '<em>CG Library Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Library Operation Call Exp</em>'.
	 * @generated
	 */
	@NonNull CGLibraryOperationCallExp createCGLibraryOperationCallExp();

	/**
	 * Returns a new object of class '<em>CG Library Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Library Property Call Exp</em>'.
	 * @generated
	 */
	@NonNull CGLibraryPropertyCallExp createCGLibraryPropertyCallExp();

	/**
	 * Returns a new object of class '<em>CG Constant Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Constant Exp</em>'.
	 * @generated
	 */
	@NonNull CGConstantExp createCGConstantExp();

	/**
	 * Returns a new object of class '<em>CG Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Constraint</em>'.
	 * @generated
	 */
	@NonNull CGConstraint createCGConstraint();

	/**
	 * Returns a new object of class '<em>CG Constructor Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Constructor Part</em>'.
	 * @generated
	 */
	@NonNull CGConstructorPart createCGConstructorPart();

	/**
	 * Returns a new object of class '<em>CG Ecore Class Constructor Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Ecore Class Constructor Exp</em>'.
	 * @generated
	 */
	@NonNull CGEcoreClassConstructorExp createCGEcoreClassConstructorExp();

	/**
	 * Returns a new object of class '<em>CG Ecore Data Type Constructor Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Ecore Data Type Constructor Exp</em>'.
	 * @generated
	 */
	@NonNull CGEcoreDataTypeConstructorExp createCGEcoreDataTypeConstructorExp();

	/**
	 * Returns a new object of class '<em>CG Let Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Let Exp</em>'.
	 * @generated
	 */
	@NonNull CGLetExp createCGLetExp();

	/**
	 * Returns a new object of class '<em>CG Library Iterate Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Library Iterate Call Exp</em>'.
	 * @generated
	 */
	@NonNull CGLibraryIterateCallExp createCGLibraryIterateCallExp();

	/**
	 * Returns a new object of class '<em>CG Library Iteration Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Library Iteration Call Exp</em>'.
	 * @generated
	 */
	@NonNull CGLibraryIterationCallExp createCGLibraryIterationCallExp();

	/**
	 * Returns a new object of class '<em>CG Local Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Local Variable</em>'.
	 * @generated
	 */
	@NonNull CGLocalVariable createCGLocalVariable();

	/**
	 * Returns a new object of class '<em>CG Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Model</em>'.
	 * @generated
	 */
	@NonNull CGModel createCGModel();

	/**
	 * Returns a new object of class '<em>CG Null</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Null</em>'.
	 * @generated
	 */
	@NonNull CGNull createCGNull();

	/**
	 * Returns a new object of class '<em>CG If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG If Exp</em>'.
	 * @generated
	 */
	@NonNull CGIfExp createCGIfExp();

	/**
	 * Returns a new object of class '<em>CG Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Operation</em>'.
	 * @generated
	 */
	@NonNull CGOperation createCGOperation();

	/**
	 * Returns a new object of class '<em>CG Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Package</em>'.
	 * @generated
	 */
	@NonNull CGPackage createCGPackage();

	/**
	 * Returns a new object of class '<em>CG Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Parameter</em>'.
	 * @generated
	 */
	@NonNull CGParameter createCGParameter();

	/**
	 * Returns a new object of class '<em>CG Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Property</em>'.
	 * @generated
	 */
	@NonNull CGProperty createCGProperty();

	/**
	 * Returns a new object of class '<em>CG Real</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Real</em>'.
	 * @generated
	 */
	@NonNull CGReal createCGReal();

	/**
	 * Returns a new object of class '<em>CG Settable Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Settable Variable</em>'.
	 * @generated
	 */
	@NonNull CGSettableVariable createCGSettableVariable();

	/**
	 * Returns a new object of class '<em>CG String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG String</em>'.
	 * @generated
	 */
	@NonNull CGString createCGString();

	/**
	 * Returns a new object of class '<em>CG Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Text</em>'.
	 * @generated
	 */
	@NonNull CGText createCGText();

	/**
	 * Returns a new object of class '<em>CG Text Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Text Parameter</em>'.
	 * @generated
	 */
	CGTextParameter createCGTextParameter();

	/**
	 * Returns a new object of class '<em>CG Throw Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Throw Exp</em>'.
	 * @generated
	 */
	@NonNull CGThrowExp createCGThrowExp();

	/**
	 * Returns a new object of class '<em>CG Tuple Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Tuple Exp</em>'.
	 * @generated
	 */
	@NonNull CGTupleExp createCGTupleExp();

	/**
	 * Returns a new object of class '<em>CG Tuple Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Tuple Part</em>'.
	 * @generated
	 */
	@NonNull CGTuplePart createCGTuplePart();

	/**
	 * Returns a new object of class '<em>CG Tuple Part Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Tuple Part Call Exp</em>'.
	 * @generated
	 */
	@NonNull CGTuplePartCallExp createCGTuplePartCallExp();

	/**
	 * Returns a new object of class '<em>CG Type Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Type Id</em>'.
	 * @generated
	 */
	@NonNull CGTypeId createCGTypeId();

	/**
	 * Returns a new object of class '<em>CG Type Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Type Exp</em>'.
	 * @generated
	 */
	@NonNull CGTypeExp createCGTypeExp();

	/**
	 * Returns a new object of class '<em>CG Unbox Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Unbox Exp</em>'.
	 * @generated
	 */
	@NonNull CGUnboxExp createCGUnboxExp();

	/**
	 * Returns a new object of class '<em>CG Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Variable Exp</em>'.
	 * @generated
	 */
	@NonNull CGVariableExp createCGVariableExp();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	@NonNull CGModelPackage getCGModelPackage();

} //CGModelFactory