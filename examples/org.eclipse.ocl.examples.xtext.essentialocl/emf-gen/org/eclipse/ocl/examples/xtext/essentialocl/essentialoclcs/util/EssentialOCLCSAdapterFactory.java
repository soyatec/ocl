/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage
 * @generated
 */
public class EssentialOCLCSAdapterFactory
		extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EssentialOCLCSPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssentialOCLCSAdapterFactory() {
		if (modelPackage == null)
		{
			modelPackage = EssentialOCLCSPackage.eINSTANCE;
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
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
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
	protected EssentialOCLCSSwitch<Adapter> modelSwitch = new EssentialOCLCSSwitch<Adapter>()
		{
			@Override
			public Adapter caseAbstractNameExpCS(AbstractNameExpCS object)
			{
				return createAbstractNameExpCSAdapter();
			}
			@Override
			public Adapter caseBinaryOperatorCS(BinaryOperatorCS object)
			{
				return createBinaryOperatorCSAdapter();
			}
			@Override
			public Adapter caseBooleanLiteralExpCS(BooleanLiteralExpCS object)
			{
				return createBooleanLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseCollectionLiteralExpCS(CollectionLiteralExpCS object)
			{
				return createCollectionLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseCollectionLiteralPartCS(CollectionLiteralPartCS object)
			{
				return createCollectionLiteralPartCSAdapter();
			}
			@Override
			public Adapter caseCollectionTypeCS(CollectionTypeCS object)
			{
				return createCollectionTypeCSAdapter();
			}
			@Override
			public Adapter caseConstructorExpCS(ConstructorExpCS object)
			{
				return createConstructorExpCSAdapter();
			}
			@Override
			public Adapter caseConstructorPartCS(ConstructorPartCS object)
			{
				return createConstructorPartCSAdapter();
			}
			@Override
			public Adapter caseContextCS(ContextCS object)
			{
				return createContextCSAdapter();
			}
			@Override
			public Adapter caseExpCS(ExpCS object)
			{
				return createExpCSAdapter();
			}
			@Override
			public Adapter caseExpSpecificationCS(ExpSpecificationCS object)
			{
				return createExpSpecificationCSAdapter();
			}
			@Override
			public Adapter caseIfExpCS(IfExpCS object)
			{
				return createIfExpCSAdapter();
			}
			@Override
			public Adapter caseIndexExpCS(IndexExpCS object)
			{
				return createIndexExpCSAdapter();
			}
			@Override
			public Adapter caseInfixExpCS(InfixExpCS object)
			{
				return createInfixExpCSAdapter();
			}
			@Override
			public Adapter caseInvalidLiteralExpCS(InvalidLiteralExpCS object)
			{
				return createInvalidLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseInvocationExpCS(InvocationExpCS object)
			{
				return createInvocationExpCSAdapter();
			}
			@Override
			public Adapter caseLetExpCS(LetExpCS object)
			{
				return createLetExpCSAdapter();
			}
			@Override
			public Adapter caseLetVariableCS(LetVariableCS object)
			{
				return createLetVariableCSAdapter();
			}
			@Override
			public Adapter caseLiteralExpCS(LiteralExpCS object)
			{
				return createLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseNameExpCS(NameExpCS object)
			{
				return createNameExpCSAdapter();
			}
			@Override
			public Adapter caseNamedExpCS(NamedExpCS object)
			{
				return createNamedExpCSAdapter();
			}
			@Override
			public Adapter caseNavigatingArgCS(NavigatingArgCS object)
			{
				return createNavigatingArgCSAdapter();
			}
			@Override
			public Adapter caseNavigationOperatorCS(NavigationOperatorCS object)
			{
				return createNavigationOperatorCSAdapter();
			}
			@Override
			public Adapter caseNestedExpCS(NestedExpCS object)
			{
				return createNestedExpCSAdapter();
			}
			@Override
			public Adapter caseNullLiteralExpCS(NullLiteralExpCS object)
			{
				return createNullLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseNumberLiteralExpCS(NumberLiteralExpCS object)
			{
				return createNumberLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseOperatorCS(OperatorCS object)
			{
				return createOperatorCSAdapter();
			}
			@Override
			public Adapter casePrefixExpCS(PrefixExpCS object)
			{
				return createPrefixExpCSAdapter();
			}
			@Override
			public Adapter casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object)
			{
				return createPrimitiveLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseSelfExpCS(SelfExpCS object)
			{
				return createSelfExpCSAdapter();
			}
			@Override
			public Adapter caseStringLiteralExpCS(StringLiteralExpCS object)
			{
				return createStringLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseTupleLiteralExpCS(TupleLiteralExpCS object)
			{
				return createTupleLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseTupleLiteralPartCS(TupleLiteralPartCS object)
			{
				return createTupleLiteralPartCSAdapter();
			}
			@Override
			public Adapter caseTypeLiteralExpCS(TypeLiteralExpCS object)
			{
				return createTypeLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseTypeNameExpCS(TypeNameExpCS object)
			{
				return createTypeNameExpCSAdapter();
			}
			@Override
			public Adapter caseUnaryOperatorCS(UnaryOperatorCS object)
			{
				return createUnaryOperatorCSAdapter();
			}
			@Override
			public Adapter caseUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS object)
			{
				return createUnlimitedNaturalLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseVariableCS(VariableCS object)
			{
				return createVariableCSAdapter();
			}
			@Override
			public Adapter caseVisitableCS(VisitableCS object)
			{
				return createVisitableCSAdapter();
			}
			@Override
			public Adapter caseElementCS(ElementCS object)
			{
				return createElementCSAdapter();
			}
			@Override
			public Adapter casePivotable(Pivotable object)
			{
				return createPivotableAdapter();
			}
			@Override
			public Adapter casePivotableElementCS(PivotableElementCS object)
			{
				return createPivotableElementCSAdapter();
			}
			@Override
			public Adapter caseModelElementCS(ModelElementCS object)
			{
				return createModelElementCSAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object)
			{
				return createNameableAdapter();
			}
			@Override
			public Adapter caseNamedElementCS(NamedElementCS object)
			{
				return createNamedElementCSAdapter();
			}
			@Override
			public Adapter caseElementRefCS(ElementRefCS object)
			{
				return createElementRefCSAdapter();
			}
			@Override
			public Adapter caseTypeRefCS(TypeRefCS object)
			{
				return createTypeRefCSAdapter();
			}
			@Override
			public Adapter caseTypedRefCS(TypedRefCS object)
			{
				return createTypedRefCSAdapter();
			}
			@Override
			public Adapter caseRootCS(RootCS object)
			{
				return createRootCSAdapter();
			}
			@Override
			public Adapter caseSpecificationCS(SpecificationCS object)
			{
				return createSpecificationCSAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS <em>Abstract Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS
	 * @generated
	 */
	public Adapter createAbstractNameExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS <em>Binary Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS
	 * @generated
	 */
	public Adapter createBinaryOperatorCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS <em>Boolean Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS
	 * @generated
	 */
	public Adapter createBooleanLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS <em>Collection Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS
	 * @generated
	 */
	public Adapter createCollectionLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS <em>Collection Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS
	 * @generated
	 */
	public Adapter createCollectionLiteralPartCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS <em>Collection Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS
	 * @generated
	 */
	public Adapter createCollectionTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS <em>Constructor Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS
	 * @generated
	 */
	public Adapter createConstructorExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS <em>Constructor Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS
	 * @generated
	 */
	public Adapter createConstructorPartCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS <em>Context CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS
	 * @generated
	 */
	public Adapter createContextCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS <em>Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS
	 * @generated
	 */
	public Adapter createExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS <em>Exp Specification CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS
	 * @generated
	 */
	public Adapter createExpSpecificationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS <em>If Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS
	 * @generated
	 */
	public Adapter createIfExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IndexExpCS <em>Index Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IndexExpCS
	 * @generated
	 */
	public Adapter createIndexExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS <em>Infix Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS
	 * @generated
	 */
	public Adapter createInfixExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS <em>Invalid Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS
	 * @generated
	 */
	public Adapter createInvalidLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS <em>Invocation Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS
	 * @generated
	 */
	public Adapter createInvocationExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS <em>Let Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS
	 * @generated
	 */
	public Adapter createLetExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS <em>Let Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS
	 * @generated
	 */
	public Adapter createLetVariableCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS <em>Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS
	 * @generated
	 */
	public Adapter createLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS <em>Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS
	 * @generated
	 */
	public Adapter createNameExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NamedExpCS <em>Named Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NamedExpCS
	 * @generated
	 */
	public Adapter createNamedExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS <em>Navigating Arg CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS
	 * @generated
	 */
	public Adapter createNavigatingArgCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS <em>Navigation Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS
	 * @generated
	 */
	public Adapter createNavigationOperatorCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS <em>Nested Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS
	 * @generated
	 */
	public Adapter createNestedExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS <em>Null Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS
	 * @generated
	 */
	public Adapter createNullLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS <em>Number Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS
	 * @generated
	 */
	public Adapter createNumberLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS <em>Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS
	 * @generated
	 */
	public Adapter createOperatorCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS <em>Prefix Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS
	 * @generated
	 */
	public Adapter createPrefixExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS <em>Primitive Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS
	 * @generated
	 */
	public Adapter createPrimitiveLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS <em>Self Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS
	 * @generated
	 */
	public Adapter createSelfExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS <em>String Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS
	 * @generated
	 */
	public Adapter createStringLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS <em>Tuple Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS
	 * @generated
	 */
	public Adapter createTupleLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS <em>Tuple Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS
	 * @generated
	 */
	public Adapter createTupleLiteralPartCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS <em>Type Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS
	 * @generated
	 */
	public Adapter createTypeLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS <em>Type Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS
	 * @generated
	 */
	public Adapter createTypeNameExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnaryOperatorCS <em>Unary Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnaryOperatorCS
	 * @generated
	 */
	public Adapter createUnaryOperatorCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS <em>Unlimited Natural Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS
	 * @generated
	 */
	public Adapter createUnlimitedNaturalLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS <em>Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS
	 * @generated
	 */
	public Adapter createVariableCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS <em>Visitable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS
	 * @generated
	 */
	public Adapter createVisitableCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ElementCS <em>Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ElementCS
	 * @generated
	 */
	public Adapter createElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.pivot.util.Pivotable <em>Pivotable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.pivot.util.Pivotable
	 * @generated
	 */
	public Adapter createPivotableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS <em>Pivotable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS
	 * @generated
	 */
	public Adapter createPivotableElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS <em>Model Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS
	 * @generated
	 */
	public Adapter createModelElementCSAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS <em>Named Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS
	 * @generated
	 */
	public Adapter createNamedElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS <em>Element Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS
	 * @generated
	 */
	public Adapter createElementRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS <em>Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS
	 * @generated
	 */
	public Adapter createTypeRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS <em>Typed Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS
	 * @generated
	 */
	public Adapter createTypedRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.RootCS <em>Root CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.RootCS
	 * @generated
	 */
	public Adapter createRootCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS <em>Specification CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS
	 * @generated
	 */
	public Adapter createSpecificationCSAdapter() {
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

} //EssentialOCLCSAdapterFactory
