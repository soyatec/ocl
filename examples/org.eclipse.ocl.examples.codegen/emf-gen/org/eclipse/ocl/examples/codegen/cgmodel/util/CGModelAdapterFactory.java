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
package org.eclipse.ocl.examples.codegen.cgmodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.codegen.cgmodel.*;
import org.eclipse.ocl.examples.domain.elements.Nameable;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage
 * @generated
 */
public class CGModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CGModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CGModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGModelSwitch<Adapter> modelSwitch =
		new CGModelSwitch<Adapter>() {
			@Override
			public Adapter caseCGBoolean(CGBoolean object) {
				return createCGBooleanAdapter();
			}
			@Override
			public Adapter caseCGBoxExp(CGBoxExp object) {
				return createCGBoxExpAdapter();
			}
			@Override
			public Adapter caseCGBuiltInIterationCallExp(CGBuiltInIterationCallExp object) {
				return createCGBuiltInIterationCallExpAdapter();
			}
			@Override
			public Adapter caseCGCallExp(CGCallExp object) {
				return createCGCallExpAdapter();
			}
			@Override
			public Adapter caseCGCastParameter(CGCastParameter object) {
				return createCGCastParameterAdapter();
			}
			@Override
			public Adapter caseCGCatchExp(CGCatchExp object) {
				return createCGCatchExpAdapter();
			}
			@Override
			public Adapter caseCGClass(CGClass object) {
				return createCGClassAdapter();
			}
			@Override
			public Adapter caseCGCollectionExp(CGCollectionExp object) {
				return createCGCollectionExpAdapter();
			}
			@Override
			public Adapter caseCGCollectionPart(CGCollectionPart object) {
				return createCGCollectionPartAdapter();
			}
			@Override
			public Adapter caseCGConstant(CGConstant object) {
				return createCGConstantAdapter();
			}
			@Override
			public Adapter caseCGConstantExp(CGConstantExp object) {
				return createCGConstantExpAdapter();
			}
			@Override
			public Adapter caseCGConstraint(CGConstraint object) {
				return createCGConstraintAdapter();
			}
			@Override
			public Adapter caseCGConstructorExp(CGConstructorExp object) {
				return createCGConstructorExpAdapter();
			}
			@Override
			public Adapter caseCGConstructorPart(CGConstructorPart object) {
				return createCGConstructorPartAdapter();
			}
			@Override
			public Adapter caseCGEcoreClassConstructorExp(CGEcoreClassConstructorExp object) {
				return createCGEcoreClassConstructorExpAdapter();
			}
			@Override
			public Adapter caseCGEcoreDataTypeConstructorExp(CGEcoreDataTypeConstructorExp object) {
				return createCGEcoreDataTypeConstructorExpAdapter();
			}
			@Override
			public Adapter caseCGEcoreOperationCallExp(CGEcoreOperationCallExp object) {
				return createCGEcoreOperationCallExpAdapter();
			}
			@Override
			public Adapter caseCGEcorePropertyCallExp(CGEcorePropertyCallExp object) {
				return createCGEcorePropertyCallExpAdapter();
			}
			@Override
			public Adapter caseCGElement(CGElement object) {
				return createCGElementAdapter();
			}
			@Override
			public Adapter caseCGElementId(CGElementId object) {
				return createCGElementIdAdapter();
			}
			@Override
			public Adapter caseCGEqualsExp(CGEqualsExp object) {
				return createCGEqualsExpAdapter();
			}
			@Override
			public Adapter caseCGExecutorCompositionProperty(CGExecutorCompositionProperty object) {
				return createCGExecutorCompositionPropertyAdapter();
			}
			@Override
			public Adapter caseCGExecutorConstructorPart(CGExecutorConstructorPart object) {
				return createCGExecutorConstructorPartAdapter();
			}
			@Override
			public Adapter caseCGExecutorNavigationProperty(CGExecutorNavigationProperty object) {
				return createCGExecutorNavigationPropertyAdapter();
			}
			@Override
			public Adapter caseCGExecutorOppositeProperty(CGExecutorOppositeProperty object) {
				return createCGExecutorOppositePropertyAdapter();
			}
			@Override
			public Adapter caseCGExecutorOperation(CGExecutorOperation object) {
				return createCGExecutorOperationAdapter();
			}
			@Override
			public Adapter caseCGExecutorOperationCallExp(CGExecutorOperationCallExp object) {
				return createCGExecutorOperationCallExpAdapter();
			}
			@Override
			public Adapter caseCGExecutorProperty(CGExecutorProperty object) {
				return createCGExecutorPropertyAdapter();
			}
			@Override
			public Adapter caseCGExecutorPropertyCallExp(CGExecutorPropertyCallExp object) {
				return createCGExecutorPropertyCallExpAdapter();
			}
			@Override
			public Adapter caseCGExecutorType(CGExecutorType object) {
				return createCGExecutorTypeAdapter();
			}
			@Override
			public Adapter caseCGFinalVariable(CGFinalVariable object) {
				return createCGFinalVariableAdapter();
			}
			@Override
			public Adapter caseCGGuardExp(CGGuardExp object) {
				return createCGGuardExpAdapter();
			}
			@Override
			public Adapter caseCGIfExp(CGIfExp object) {
				return createCGIfExpAdapter();
			}
			@Override
			public Adapter caseCGInfinity(CGInfinity object) {
				return createCGInfinityAdapter();
			}
			@Override
			public Adapter caseCGInteger(CGInteger object) {
				return createCGIntegerAdapter();
			}
			@Override
			public Adapter caseCGInvalid(CGInvalid object) {
				return createCGInvalidAdapter();
			}
			@Override
			public Adapter caseCGIsInvalidExp(CGIsInvalidExp object) {
				return createCGIsInvalidExpAdapter();
			}
			@Override
			public Adapter caseCGIsUndefinedExp(CGIsUndefinedExp object) {
				return createCGIsUndefinedExpAdapter();
			}
			@Override
			public Adapter caseCGIterationCallExp(CGIterationCallExp object) {
				return createCGIterationCallExpAdapter();
			}
			@Override
			public Adapter caseCGIterator(CGIterator object) {
				return createCGIteratorAdapter();
			}
			@Override
			public Adapter caseCGLetExp(CGLetExp object) {
				return createCGLetExpAdapter();
			}
			@Override
			public Adapter caseCGLibraryIterateCallExp(CGLibraryIterateCallExp object) {
				return createCGLibraryIterateCallExpAdapter();
			}
			@Override
			public Adapter caseCGLibraryIterationCallExp(CGLibraryIterationCallExp object) {
				return createCGLibraryIterationCallExpAdapter();
			}
			@Override
			public Adapter caseCGLibraryOperationCallExp(CGLibraryOperationCallExp object) {
				return createCGLibraryOperationCallExpAdapter();
			}
			@Override
			public Adapter caseCGLibraryPropertyCallExp(CGLibraryPropertyCallExp object) {
				return createCGLibraryPropertyCallExpAdapter();
			}
			@Override
			public Adapter caseCGLocalVariable(CGLocalVariable object) {
				return createCGLocalVariableAdapter();
			}
			@Override
			public Adapter caseCGModel(CGModel object) {
				return createCGModelAdapter();
			}
			@Override
			public Adapter caseCGNamedElement(CGNamedElement object) {
				return createCGNamedElementAdapter();
			}
			@Override
			public Adapter caseCGNull(CGNull object) {
				return createCGNullAdapter();
			}
			@Override
			public Adapter caseCGOperation(CGOperation object) {
				return createCGOperationAdapter();
			}
			@Override
			public Adapter caseCGOperationCallExp(CGOperationCallExp object) {
				return createCGOperationCallExpAdapter();
			}
			@Override
			public Adapter caseCGPackage(CGPackage object) {
				return createCGPackageAdapter();
			}
			@Override
			public Adapter caseCGParameter(CGParameter object) {
				return createCGParameterAdapter();
			}
			@Override
			public Adapter caseCGProperty(CGProperty object) {
				return createCGPropertyAdapter();
			}
			@Override
			public Adapter caseCGPropertyCallExp(CGPropertyCallExp object) {
				return createCGPropertyCallExpAdapter();
			}
			@Override
			public Adapter caseCGReal(CGReal object) {
				return createCGRealAdapter();
			}
			@Override
			public Adapter caseCGSettableVariable(CGSettableVariable object) {
				return createCGSettableVariableAdapter();
			}
			@Override
			public Adapter caseCGString(CGString object) {
				return createCGStringAdapter();
			}
			@Override
			public Adapter caseCGText(CGText object) {
				return createCGTextAdapter();
			}
			@Override
			public Adapter caseCGTextParameter(CGTextParameter object) {
				return createCGTextParameterAdapter();
			}
			@Override
			public Adapter caseCGThrowExp(CGThrowExp object) {
				return createCGThrowExpAdapter();
			}
			@Override
			public Adapter caseCGTupleExp(CGTupleExp object) {
				return createCGTupleExpAdapter();
			}
			@Override
			public Adapter caseCGTuplePart(CGTuplePart object) {
				return createCGTuplePartAdapter();
			}
			@Override
			public Adapter caseCGTuplePartCallExp(CGTuplePartCallExp object) {
				return createCGTuplePartCallExpAdapter();
			}
			@Override
			public Adapter caseCGTypeId(CGTypeId object) {
				return createCGTypeIdAdapter();
			}
			@Override
			public Adapter caseCGTypeExp(CGTypeExp object) {
				return createCGTypeExpAdapter();
			}
			@Override
			public Adapter caseCGTypedElement(CGTypedElement object) {
				return createCGTypedElementAdapter();
			}
			@Override
			public Adapter caseCGUnboxExp(CGUnboxExp object) {
				return createCGUnboxExpAdapter();
			}
			@Override
			public Adapter caseCGValuedElement(CGValuedElement object) {
				return createCGValuedElementAdapter();
			}
			@Override
			public Adapter caseCGVariable(CGVariable object) {
				return createCGVariableAdapter();
			}
			@Override
			public Adapter caseCGVariableExp(CGVariableExp object) {
				return createCGVariableExpAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean <em>CG Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean
	 * @generated
	 */
	public Adapter createCGBooleanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp <em>CG Box Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp
	 * @generated
	 */
	public Adapter createCGBoxExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp <em>CG Built In Iteration Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp
	 * @generated
	 */
	public Adapter createCGBuiltInIterationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGClass <em>CG Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGClass
	 * @generated
	 */
	public Adapter createCGClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp <em>CG Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp
	 * @generated
	 */
	public Adapter createCGCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter <em>CG Cast Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter
	 * @generated
	 */
	public Adapter createCGCastParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp <em>CG Catch Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp
	 * @generated
	 */
	public Adapter createCGCatchExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp <em>CG Collection Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp
	 * @generated
	 */
	public Adapter createCGCollectionExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart <em>CG Collection Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart
	 * @generated
	 */
	public Adapter createCGCollectionPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstant <em>CG Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstant
	 * @generated
	 */
	public Adapter createCGConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable <em>CG Final Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable
	 * @generated
	 */
	public Adapter createCGFinalVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp <em>CG Guard Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp
	 * @generated
	 */
	public Adapter createCGGuardExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp <em>CG Ecore Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp
	 * @generated
	 */
	public Adapter createCGEcoreOperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp <em>CG Ecore Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp
	 * @generated
	 */
	public Adapter createCGEcorePropertyCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGInfinity <em>CG Infinity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGInfinity
	 * @generated
	 */
	public Adapter createCGInfinityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGInteger <em>CG Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGInteger
	 * @generated
	 */
	public Adapter createCGIntegerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid <em>CG Invalid</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid
	 * @generated
	 */
	public Adapter createCGInvalidAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp <em>CG Is Invalid Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp
	 * @generated
	 */
	public Adapter createCGIsInvalidExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp <em>CG Is Undefined Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp
	 * @generated
	 */
	public Adapter createCGIsUndefinedExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp <em>CG Iteration Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp
	 * @generated
	 */
	public Adapter createCGIterationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIterator <em>CG Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIterator
	 * @generated
	 */
	public Adapter createCGIteratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp <em>CG Library Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp
	 * @generated
	 */
	public Adapter createCGLibraryOperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp <em>CG Library Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp
	 * @generated
	 */
	public Adapter createCGLibraryPropertyCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp <em>CG Constant Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp
	 * @generated
	 */
	public Adapter createCGConstantExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint <em>CG Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint
	 * @generated
	 */
	public Adapter createCGConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp <em>CG Constructor Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp
	 * @generated
	 */
	public Adapter createCGConstructorExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart <em>CG Constructor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart
	 * @generated
	 */
	public Adapter createCGConstructorPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp <em>CG Ecore Class Constructor Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp
	 * @generated
	 */
	public Adapter createCGEcoreClassConstructorExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp <em>CG Ecore Data Type Constructor Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp
	 * @generated
	 */
	public Adapter createCGEcoreDataTypeConstructorExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp <em>CG Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp
	 * @generated
	 */
	public Adapter createCGLetExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp <em>CG Library Iterate Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp
	 * @generated
	 */
	public Adapter createCGLibraryIterateCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp <em>CG Library Iteration Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp
	 * @generated
	 */
	public Adapter createCGLibraryIterationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGLocalVariable <em>CG Local Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGLocalVariable
	 * @generated
	 */
	public Adapter createCGLocalVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGModel <em>CG Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModel
	 * @generated
	 */
	public Adapter createCGModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGElement <em>CG Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGElement
	 * @generated
	 */
	public Adapter createCGElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGElementId <em>CG Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGElementId
	 * @generated
	 */
	public Adapter createCGElementIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEqualsExp <em>CG Equals Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGEqualsExp
	 * @generated
	 */
	public Adapter createCGEqualsExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorCompositionProperty <em>CG Executor Composition Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorCompositionProperty
	 * @generated
	 */
	public Adapter createCGExecutorCompositionPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart <em>CG Executor Constructor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart
	 * @generated
	 */
	public Adapter createCGExecutorConstructorPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorNavigationProperty <em>CG Executor Navigation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorNavigationProperty
	 * @generated
	 */
	public Adapter createCGExecutorNavigationPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositeProperty <em>CG Executor Opposite Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositeProperty
	 * @generated
	 */
	public Adapter createCGExecutorOppositePropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation <em>CG Executor Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation
	 * @generated
	 */
	public Adapter createCGExecutorOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp <em>CG Executor Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp
	 * @generated
	 */
	public Adapter createCGExecutorOperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty <em>CG Executor Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty
	 * @generated
	 */
	public Adapter createCGExecutorPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp <em>CG Executor Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp
	 * @generated
	 */
	public Adapter createCGExecutorPropertyCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType <em>CG Executor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType
	 * @generated
	 */
	public Adapter createCGExecutorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp <em>CG If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp
	 * @generated
	 */
	public Adapter createCGIfExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement <em>CG Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement
	 * @generated
	 */
	public Adapter createCGNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGNull <em>CG Null</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGNull
	 * @generated
	 */
	public Adapter createCGNullAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperation <em>CG Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperation
	 * @generated
	 */
	public Adapter createCGOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp <em>CG Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp
	 * @generated
	 */
	public Adapter createCGOperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGPackage <em>CG Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGPackage
	 * @generated
	 */
	public Adapter createCGPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGParameter <em>CG Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGParameter
	 * @generated
	 */
	public Adapter createCGParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGProperty <em>CG Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGProperty
	 * @generated
	 */
	public Adapter createCGPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp <em>CG Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp
	 * @generated
	 */
	public Adapter createCGPropertyCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGReal <em>CG Real</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGReal
	 * @generated
	 */
	public Adapter createCGRealAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGSettableVariable <em>CG Settable Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGSettableVariable
	 * @generated
	 */
	public Adapter createCGSettableVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGString <em>CG String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGString
	 * @generated
	 */
	public Adapter createCGStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGText <em>CG Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGText
	 * @generated
	 */
	public Adapter createCGTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter <em>CG Text Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter
	 * @generated
	 */
	public Adapter createCGTextParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp <em>CG Throw Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp
	 * @generated
	 */
	public Adapter createCGThrowExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp <em>CG Tuple Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp
	 * @generated
	 */
	public Adapter createCGTupleExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart <em>CG Tuple Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart
	 * @generated
	 */
	public Adapter createCGTuplePartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp <em>CG Tuple Part Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp
	 * @generated
	 */
	public Adapter createCGTuplePartCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId <em>CG Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId
	 * @generated
	 */
	public Adapter createCGTypeIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp <em>CG Type Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp
	 * @generated
	 */
	public Adapter createCGTypeExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement <em>CG Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement
	 * @generated
	 */
	public Adapter createCGTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp <em>CG Unbox Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp
	 * @generated
	 */
	public Adapter createCGUnboxExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement <em>CG Valued Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement
	 * @generated
	 */
	public Adapter createCGValuedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGVariable <em>CG Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGVariable
	 * @generated
	 */
	public Adapter createCGVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp <em>CG Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp
	 * @generated
	 */
	public Adapter createCGVariableExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.domain.elements.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.domain.elements.Nameable
	 * @generated
	 */
	public Adapter createNameableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CGModelAdapterFactory