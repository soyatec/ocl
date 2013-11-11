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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage
 * @generated
 */
public class EssentialOCLCSSwitch<T>
		extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EssentialOCLCSPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssentialOCLCSSwitch() {
		if (modelPackage == null)
		{
			modelPackage = EssentialOCLCSPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID)
		{
			case EssentialOCLCSPackage.ABSTRACT_NAME_EXP_CS:
			{
				AbstractNameExpCS abstractNameExpCS = (AbstractNameExpCS)theEObject;
				T result = caseAbstractNameExpCS(abstractNameExpCS);
				if (result == null) result = caseExpCS(abstractNameExpCS);
				if (result == null) result = caseModelElementCS(abstractNameExpCS);
				if (result == null) result = casePivotableElementCS(abstractNameExpCS);
				if (result == null) result = caseElementCS(abstractNameExpCS);
				if (result == null) result = casePivotable(abstractNameExpCS);
				if (result == null) result = caseVisitableCS(abstractNameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.BINARY_OPERATOR_CS:
			{
				BinaryOperatorCS binaryOperatorCS = (BinaryOperatorCS)theEObject;
				T result = caseBinaryOperatorCS(binaryOperatorCS);
				if (result == null) result = caseOperatorCS(binaryOperatorCS);
				if (result == null) result = caseNamedElementCS(binaryOperatorCS);
				if (result == null) result = caseExpCS(binaryOperatorCS);
				if (result == null) result = caseModelElementCS(binaryOperatorCS);
				if (result == null) result = caseNameable(binaryOperatorCS);
				if (result == null) result = casePivotableElementCS(binaryOperatorCS);
				if (result == null) result = caseElementCS(binaryOperatorCS);
				if (result == null) result = casePivotable(binaryOperatorCS);
				if (result == null) result = caseVisitableCS(binaryOperatorCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.BOOLEAN_LITERAL_EXP_CS:
			{
				BooleanLiteralExpCS booleanLiteralExpCS = (BooleanLiteralExpCS)theEObject;
				T result = caseBooleanLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseExpCS(booleanLiteralExpCS);
				if (result == null) result = caseModelElementCS(booleanLiteralExpCS);
				if (result == null) result = casePivotableElementCS(booleanLiteralExpCS);
				if (result == null) result = caseElementCS(booleanLiteralExpCS);
				if (result == null) result = casePivotable(booleanLiteralExpCS);
				if (result == null) result = caseVisitableCS(booleanLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.COLLECTION_LITERAL_EXP_CS:
			{
				CollectionLiteralExpCS collectionLiteralExpCS = (CollectionLiteralExpCS)theEObject;
				T result = caseCollectionLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseExpCS(collectionLiteralExpCS);
				if (result == null) result = caseModelElementCS(collectionLiteralExpCS);
				if (result == null) result = casePivotableElementCS(collectionLiteralExpCS);
				if (result == null) result = caseElementCS(collectionLiteralExpCS);
				if (result == null) result = casePivotable(collectionLiteralExpCS);
				if (result == null) result = caseVisitableCS(collectionLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS:
			{
				CollectionLiteralPartCS collectionLiteralPartCS = (CollectionLiteralPartCS)theEObject;
				T result = caseCollectionLiteralPartCS(collectionLiteralPartCS);
				if (result == null) result = caseModelElementCS(collectionLiteralPartCS);
				if (result == null) result = casePivotableElementCS(collectionLiteralPartCS);
				if (result == null) result = caseElementCS(collectionLiteralPartCS);
				if (result == null) result = casePivotable(collectionLiteralPartCS);
				if (result == null) result = caseVisitableCS(collectionLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.COLLECTION_TYPE_CS:
			{
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)theEObject;
				T result = caseCollectionTypeCS(collectionTypeCS);
				if (result == null) result = caseTypedRefCS(collectionTypeCS);
				if (result == null) result = caseNameable(collectionTypeCS);
				if (result == null) result = caseTypeRefCS(collectionTypeCS);
				if (result == null) result = caseElementRefCS(collectionTypeCS);
				if (result == null) result = casePivotableElementCS(collectionTypeCS);
				if (result == null) result = caseElementCS(collectionTypeCS);
				if (result == null) result = casePivotable(collectionTypeCS);
				if (result == null) result = caseVisitableCS(collectionTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.CONSTRUCTOR_EXP_CS:
			{
				ConstructorExpCS constructorExpCS = (ConstructorExpCS)theEObject;
				T result = caseConstructorExpCS(constructorExpCS);
				if (result == null) result = caseNamedExpCS(constructorExpCS);
				if (result == null) result = caseAbstractNameExpCS(constructorExpCS);
				if (result == null) result = caseExpCS(constructorExpCS);
				if (result == null) result = caseModelElementCS(constructorExpCS);
				if (result == null) result = casePivotableElementCS(constructorExpCS);
				if (result == null) result = caseElementCS(constructorExpCS);
				if (result == null) result = casePivotable(constructorExpCS);
				if (result == null) result = caseVisitableCS(constructorExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS:
			{
				ConstructorPartCS constructorPartCS = (ConstructorPartCS)theEObject;
				T result = caseConstructorPartCS(constructorPartCS);
				if (result == null) result = caseModelElementCS(constructorPartCS);
				if (result == null) result = caseNameable(constructorPartCS);
				if (result == null) result = casePivotableElementCS(constructorPartCS);
				if (result == null) result = caseElementCS(constructorPartCS);
				if (result == null) result = casePivotable(constructorPartCS);
				if (result == null) result = caseVisitableCS(constructorPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.CONTEXT_CS:
			{
				ContextCS contextCS = (ContextCS)theEObject;
				T result = caseContextCS(contextCS);
				if (result == null) result = caseRootCS(contextCS);
				if (result == null) result = caseNamedElementCS(contextCS);
				if (result == null) result = caseModelElementCS(contextCS);
				if (result == null) result = caseNameable(contextCS);
				if (result == null) result = casePivotableElementCS(contextCS);
				if (result == null) result = caseElementCS(contextCS);
				if (result == null) result = casePivotable(contextCS);
				if (result == null) result = caseVisitableCS(contextCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.EXP_CS:
			{
				ExpCS expCS = (ExpCS)theEObject;
				T result = caseExpCS(expCS);
				if (result == null) result = caseModelElementCS(expCS);
				if (result == null) result = casePivotableElementCS(expCS);
				if (result == null) result = caseElementCS(expCS);
				if (result == null) result = casePivotable(expCS);
				if (result == null) result = caseVisitableCS(expCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.EXP_SPECIFICATION_CS:
			{
				ExpSpecificationCS expSpecificationCS = (ExpSpecificationCS)theEObject;
				T result = caseExpSpecificationCS(expSpecificationCS);
				if (result == null) result = caseSpecificationCS(expSpecificationCS);
				if (result == null) result = caseModelElementCS(expSpecificationCS);
				if (result == null) result = casePivotableElementCS(expSpecificationCS);
				if (result == null) result = caseElementCS(expSpecificationCS);
				if (result == null) result = casePivotable(expSpecificationCS);
				if (result == null) result = caseVisitableCS(expSpecificationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.IF_EXP_CS:
			{
				IfExpCS ifExpCS = (IfExpCS)theEObject;
				T result = caseIfExpCS(ifExpCS);
				if (result == null) result = caseExpCS(ifExpCS);
				if (result == null) result = caseModelElementCS(ifExpCS);
				if (result == null) result = casePivotableElementCS(ifExpCS);
				if (result == null) result = caseElementCS(ifExpCS);
				if (result == null) result = casePivotable(ifExpCS);
				if (result == null) result = caseVisitableCS(ifExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.INDEX_EXP_CS:
			{
				IndexExpCS indexExpCS = (IndexExpCS)theEObject;
				T result = caseIndexExpCS(indexExpCS);
				if (result == null) result = caseNamedExpCS(indexExpCS);
				if (result == null) result = caseAbstractNameExpCS(indexExpCS);
				if (result == null) result = caseExpCS(indexExpCS);
				if (result == null) result = caseModelElementCS(indexExpCS);
				if (result == null) result = casePivotableElementCS(indexExpCS);
				if (result == null) result = caseElementCS(indexExpCS);
				if (result == null) result = casePivotable(indexExpCS);
				if (result == null) result = caseVisitableCS(indexExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.INFIX_EXP_CS:
			{
				InfixExpCS infixExpCS = (InfixExpCS)theEObject;
				T result = caseInfixExpCS(infixExpCS);
				if (result == null) result = caseExpCS(infixExpCS);
				if (result == null) result = caseModelElementCS(infixExpCS);
				if (result == null) result = casePivotableElementCS(infixExpCS);
				if (result == null) result = caseElementCS(infixExpCS);
				if (result == null) result = casePivotable(infixExpCS);
				if (result == null) result = caseVisitableCS(infixExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.INVALID_LITERAL_EXP_CS:
			{
				InvalidLiteralExpCS invalidLiteralExpCS = (InvalidLiteralExpCS)theEObject;
				T result = caseInvalidLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = caseExpCS(invalidLiteralExpCS);
				if (result == null) result = caseModelElementCS(invalidLiteralExpCS);
				if (result == null) result = casePivotableElementCS(invalidLiteralExpCS);
				if (result == null) result = caseElementCS(invalidLiteralExpCS);
				if (result == null) result = casePivotable(invalidLiteralExpCS);
				if (result == null) result = caseVisitableCS(invalidLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.INVOCATION_EXP_CS:
			{
				InvocationExpCS invocationExpCS = (InvocationExpCS)theEObject;
				T result = caseInvocationExpCS(invocationExpCS);
				if (result == null) result = caseNamedExpCS(invocationExpCS);
				if (result == null) result = caseAbstractNameExpCS(invocationExpCS);
				if (result == null) result = caseExpCS(invocationExpCS);
				if (result == null) result = caseModelElementCS(invocationExpCS);
				if (result == null) result = casePivotableElementCS(invocationExpCS);
				if (result == null) result = caseElementCS(invocationExpCS);
				if (result == null) result = casePivotable(invocationExpCS);
				if (result == null) result = caseVisitableCS(invocationExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.LET_EXP_CS:
			{
				LetExpCS letExpCS = (LetExpCS)theEObject;
				T result = caseLetExpCS(letExpCS);
				if (result == null) result = caseExpCS(letExpCS);
				if (result == null) result = caseModelElementCS(letExpCS);
				if (result == null) result = casePivotableElementCS(letExpCS);
				if (result == null) result = caseElementCS(letExpCS);
				if (result == null) result = casePivotable(letExpCS);
				if (result == null) result = caseVisitableCS(letExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.LET_VARIABLE_CS:
			{
				LetVariableCS letVariableCS = (LetVariableCS)theEObject;
				T result = caseLetVariableCS(letVariableCS);
				if (result == null) result = caseVariableCS(letVariableCS);
				if (result == null) result = caseExpCS(letVariableCS);
				if (result == null) result = caseNamedElementCS(letVariableCS);
				if (result == null) result = caseModelElementCS(letVariableCS);
				if (result == null) result = caseNameable(letVariableCS);
				if (result == null) result = casePivotableElementCS(letVariableCS);
				if (result == null) result = caseElementCS(letVariableCS);
				if (result == null) result = casePivotable(letVariableCS);
				if (result == null) result = caseVisitableCS(letVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.LITERAL_EXP_CS:
			{
				LiteralExpCS literalExpCS = (LiteralExpCS)theEObject;
				T result = caseLiteralExpCS(literalExpCS);
				if (result == null) result = caseExpCS(literalExpCS);
				if (result == null) result = caseModelElementCS(literalExpCS);
				if (result == null) result = casePivotableElementCS(literalExpCS);
				if (result == null) result = caseElementCS(literalExpCS);
				if (result == null) result = casePivotable(literalExpCS);
				if (result == null) result = caseVisitableCS(literalExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.NAME_EXP_CS:
			{
				NameExpCS nameExpCS = (NameExpCS)theEObject;
				T result = caseNameExpCS(nameExpCS);
				if (result == null) result = caseAbstractNameExpCS(nameExpCS);
				if (result == null) result = caseExpCS(nameExpCS);
				if (result == null) result = caseModelElementCS(nameExpCS);
				if (result == null) result = casePivotableElementCS(nameExpCS);
				if (result == null) result = caseElementCS(nameExpCS);
				if (result == null) result = casePivotable(nameExpCS);
				if (result == null) result = caseVisitableCS(nameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.NAMED_EXP_CS:
			{
				NamedExpCS namedExpCS = (NamedExpCS)theEObject;
				T result = caseNamedExpCS(namedExpCS);
				if (result == null) result = caseAbstractNameExpCS(namedExpCS);
				if (result == null) result = caseExpCS(namedExpCS);
				if (result == null) result = caseModelElementCS(namedExpCS);
				if (result == null) result = casePivotableElementCS(namedExpCS);
				if (result == null) result = caseElementCS(namedExpCS);
				if (result == null) result = casePivotable(namedExpCS);
				if (result == null) result = caseVisitableCS(namedExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.NAVIGATING_ARG_CS:
			{
				NavigatingArgCS navigatingArgCS = (NavigatingArgCS)theEObject;
				T result = caseNavigatingArgCS(navigatingArgCS);
				if (result == null) result = caseModelElementCS(navigatingArgCS);
				if (result == null) result = casePivotableElementCS(navigatingArgCS);
				if (result == null) result = caseElementCS(navigatingArgCS);
				if (result == null) result = casePivotable(navigatingArgCS);
				if (result == null) result = caseVisitableCS(navigatingArgCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.NAVIGATION_OPERATOR_CS:
			{
				NavigationOperatorCS navigationOperatorCS = (NavigationOperatorCS)theEObject;
				T result = caseNavigationOperatorCS(navigationOperatorCS);
				if (result == null) result = caseBinaryOperatorCS(navigationOperatorCS);
				if (result == null) result = caseOperatorCS(navigationOperatorCS);
				if (result == null) result = caseNamedElementCS(navigationOperatorCS);
				if (result == null) result = caseExpCS(navigationOperatorCS);
				if (result == null) result = caseModelElementCS(navigationOperatorCS);
				if (result == null) result = caseNameable(navigationOperatorCS);
				if (result == null) result = casePivotableElementCS(navigationOperatorCS);
				if (result == null) result = caseElementCS(navigationOperatorCS);
				if (result == null) result = casePivotable(navigationOperatorCS);
				if (result == null) result = caseVisitableCS(navigationOperatorCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.NESTED_EXP_CS:
			{
				NestedExpCS nestedExpCS = (NestedExpCS)theEObject;
				T result = caseNestedExpCS(nestedExpCS);
				if (result == null) result = caseExpCS(nestedExpCS);
				if (result == null) result = caseModelElementCS(nestedExpCS);
				if (result == null) result = casePivotableElementCS(nestedExpCS);
				if (result == null) result = caseElementCS(nestedExpCS);
				if (result == null) result = casePivotable(nestedExpCS);
				if (result == null) result = caseVisitableCS(nestedExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.NULL_LITERAL_EXP_CS:
			{
				NullLiteralExpCS nullLiteralExpCS = (NullLiteralExpCS)theEObject;
				T result = caseNullLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseExpCS(nullLiteralExpCS);
				if (result == null) result = caseModelElementCS(nullLiteralExpCS);
				if (result == null) result = casePivotableElementCS(nullLiteralExpCS);
				if (result == null) result = caseElementCS(nullLiteralExpCS);
				if (result == null) result = casePivotable(nullLiteralExpCS);
				if (result == null) result = caseVisitableCS(nullLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.NUMBER_LITERAL_EXP_CS:
			{
				NumberLiteralExpCS numberLiteralExpCS = (NumberLiteralExpCS)theEObject;
				T result = caseNumberLiteralExpCS(numberLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(numberLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(numberLiteralExpCS);
				if (result == null) result = caseExpCS(numberLiteralExpCS);
				if (result == null) result = caseModelElementCS(numberLiteralExpCS);
				if (result == null) result = casePivotableElementCS(numberLiteralExpCS);
				if (result == null) result = caseElementCS(numberLiteralExpCS);
				if (result == null) result = casePivotable(numberLiteralExpCS);
				if (result == null) result = caseVisitableCS(numberLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.OPERATOR_CS:
			{
				OperatorCS operatorCS = (OperatorCS)theEObject;
				T result = caseOperatorCS(operatorCS);
				if (result == null) result = caseNamedElementCS(operatorCS);
				if (result == null) result = caseExpCS(operatorCS);
				if (result == null) result = caseModelElementCS(operatorCS);
				if (result == null) result = caseNameable(operatorCS);
				if (result == null) result = casePivotableElementCS(operatorCS);
				if (result == null) result = caseElementCS(operatorCS);
				if (result == null) result = casePivotable(operatorCS);
				if (result == null) result = caseVisitableCS(operatorCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.PREFIX_EXP_CS:
			{
				PrefixExpCS prefixExpCS = (PrefixExpCS)theEObject;
				T result = casePrefixExpCS(prefixExpCS);
				if (result == null) result = caseExpCS(prefixExpCS);
				if (result == null) result = caseModelElementCS(prefixExpCS);
				if (result == null) result = casePivotableElementCS(prefixExpCS);
				if (result == null) result = caseElementCS(prefixExpCS);
				if (result == null) result = casePivotable(prefixExpCS);
				if (result == null) result = caseVisitableCS(prefixExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.PRIMITIVE_LITERAL_EXP_CS:
			{
				PrimitiveLiteralExpCS primitiveLiteralExpCS = (PrimitiveLiteralExpCS)theEObject;
				T result = casePrimitiveLiteralExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseModelElementCS(primitiveLiteralExpCS);
				if (result == null) result = casePivotableElementCS(primitiveLiteralExpCS);
				if (result == null) result = caseElementCS(primitiveLiteralExpCS);
				if (result == null) result = casePivotable(primitiveLiteralExpCS);
				if (result == null) result = caseVisitableCS(primitiveLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.SELF_EXP_CS:
			{
				SelfExpCS selfExpCS = (SelfExpCS)theEObject;
				T result = caseSelfExpCS(selfExpCS);
				if (result == null) result = caseExpCS(selfExpCS);
				if (result == null) result = caseModelElementCS(selfExpCS);
				if (result == null) result = casePivotableElementCS(selfExpCS);
				if (result == null) result = caseElementCS(selfExpCS);
				if (result == null) result = casePivotable(selfExpCS);
				if (result == null) result = caseVisitableCS(selfExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.STRING_LITERAL_EXP_CS:
			{
				StringLiteralExpCS stringLiteralExpCS = (StringLiteralExpCS)theEObject;
				T result = caseStringLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = caseExpCS(stringLiteralExpCS);
				if (result == null) result = caseModelElementCS(stringLiteralExpCS);
				if (result == null) result = casePivotableElementCS(stringLiteralExpCS);
				if (result == null) result = caseElementCS(stringLiteralExpCS);
				if (result == null) result = casePivotable(stringLiteralExpCS);
				if (result == null) result = caseVisitableCS(stringLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.TUPLE_LITERAL_EXP_CS:
			{
				TupleLiteralExpCS tupleLiteralExpCS = (TupleLiteralExpCS)theEObject;
				T result = caseTupleLiteralExpCS(tupleLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(tupleLiteralExpCS);
				if (result == null) result = caseExpCS(tupleLiteralExpCS);
				if (result == null) result = caseModelElementCS(tupleLiteralExpCS);
				if (result == null) result = casePivotableElementCS(tupleLiteralExpCS);
				if (result == null) result = caseElementCS(tupleLiteralExpCS);
				if (result == null) result = casePivotable(tupleLiteralExpCS);
				if (result == null) result = caseVisitableCS(tupleLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.TUPLE_LITERAL_PART_CS:
			{
				TupleLiteralPartCS tupleLiteralPartCS = (TupleLiteralPartCS)theEObject;
				T result = caseTupleLiteralPartCS(tupleLiteralPartCS);
				if (result == null) result = caseVariableCS(tupleLiteralPartCS);
				if (result == null) result = caseNamedElementCS(tupleLiteralPartCS);
				if (result == null) result = caseModelElementCS(tupleLiteralPartCS);
				if (result == null) result = caseNameable(tupleLiteralPartCS);
				if (result == null) result = casePivotableElementCS(tupleLiteralPartCS);
				if (result == null) result = caseElementCS(tupleLiteralPartCS);
				if (result == null) result = casePivotable(tupleLiteralPartCS);
				if (result == null) result = caseVisitableCS(tupleLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.TYPE_LITERAL_EXP_CS:
			{
				TypeLiteralExpCS typeLiteralExpCS = (TypeLiteralExpCS)theEObject;
				T result = caseTypeLiteralExpCS(typeLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(typeLiteralExpCS);
				if (result == null) result = caseExpCS(typeLiteralExpCS);
				if (result == null) result = caseModelElementCS(typeLiteralExpCS);
				if (result == null) result = casePivotableElementCS(typeLiteralExpCS);
				if (result == null) result = caseElementCS(typeLiteralExpCS);
				if (result == null) result = casePivotable(typeLiteralExpCS);
				if (result == null) result = caseVisitableCS(typeLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.TYPE_NAME_EXP_CS:
			{
				TypeNameExpCS typeNameExpCS = (TypeNameExpCS)theEObject;
				T result = caseTypeNameExpCS(typeNameExpCS);
				if (result == null) result = caseTypedRefCS(typeNameExpCS);
				if (result == null) result = caseTypeRefCS(typeNameExpCS);
				if (result == null) result = caseElementRefCS(typeNameExpCS);
				if (result == null) result = casePivotableElementCS(typeNameExpCS);
				if (result == null) result = caseElementCS(typeNameExpCS);
				if (result == null) result = casePivotable(typeNameExpCS);
				if (result == null) result = caseVisitableCS(typeNameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.UNARY_OPERATOR_CS:
			{
				UnaryOperatorCS unaryOperatorCS = (UnaryOperatorCS)theEObject;
				T result = caseUnaryOperatorCS(unaryOperatorCS);
				if (result == null) result = caseOperatorCS(unaryOperatorCS);
				if (result == null) result = caseNamedElementCS(unaryOperatorCS);
				if (result == null) result = caseExpCS(unaryOperatorCS);
				if (result == null) result = caseModelElementCS(unaryOperatorCS);
				if (result == null) result = caseNameable(unaryOperatorCS);
				if (result == null) result = casePivotableElementCS(unaryOperatorCS);
				if (result == null) result = caseElementCS(unaryOperatorCS);
				if (result == null) result = casePivotable(unaryOperatorCS);
				if (result == null) result = caseVisitableCS(unaryOperatorCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS:
			{
				UnlimitedNaturalLiteralExpCS unlimitedNaturalLiteralExpCS = (UnlimitedNaturalLiteralExpCS)theEObject;
				T result = caseUnlimitedNaturalLiteralExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseModelElementCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = casePivotableElementCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseElementCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = casePivotable(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseVisitableCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSPackage.VARIABLE_CS:
			{
				VariableCS variableCS = (VariableCS)theEObject;
				T result = caseVariableCS(variableCS);
				if (result == null) result = caseNamedElementCS(variableCS);
				if (result == null) result = caseModelElementCS(variableCS);
				if (result == null) result = caseNameable(variableCS);
				if (result == null) result = casePivotableElementCS(variableCS);
				if (result == null) result = caseElementCS(variableCS);
				if (result == null) result = casePivotable(variableCS);
				if (result == null) result = caseVisitableCS(variableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractNameExpCS(AbstractNameExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Operator CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Operator CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryOperatorCS(BinaryOperatorCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteralExpCS(BooleanLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionLiteralExpCS(CollectionLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionLiteralPartCS(CollectionLiteralPartCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionTypeCS(CollectionTypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstructorExpCS(ConstructorExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstructorPartCS(ConstructorPartCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextCS(ContextCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpCS(ExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exp Specification CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp Specification CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpSpecificationCS(ExpSpecificationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfExpCS(IfExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexExpCS(IndexExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Infix Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infix Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfixExpCS(InfixExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvalidLiteralExpCS(InvalidLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invocation Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invocation Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvocationExpCS(InvocationExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetExpCS(LetExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetVariableCS(LetVariableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralExpCS(LiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameExpCS(NameExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedExpCS(NamedExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigating Arg CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigating Arg CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigatingArgCS(NavigatingArgCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Operator CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Operator CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationOperatorCS(NavigationOperatorCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nested Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nested Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNestedExpCS(NestedExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullLiteralExpCS(NullLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberLiteralExpCS(NumberLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorCS(OperatorCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prefix Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prefix Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrefixExpCS(PrefixExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Self Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Self Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelfExpCS(SelfExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralExpCS(StringLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleLiteralExpCS(TupleLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleLiteralPartCS(TupleLiteralPartCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeLiteralExpCS(TypeLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeNameExpCS(TypeNameExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Operator CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Operator CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryOperatorCS(UnaryOperatorCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnlimitedNaturalLiteralExpCS(
			UnlimitedNaturalLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableCS(VariableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitableCS(VisitableCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCS(ElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePivotable(Pivotable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePivotableElementCS(PivotableElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementCS(ModelElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElementCS(NamedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementRefCS(ElementRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeRefCS(TypeRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedRefCS(TypedRefCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootCS(RootCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specification CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specification CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificationCS(SpecificationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EssentialOCLCSSwitch
