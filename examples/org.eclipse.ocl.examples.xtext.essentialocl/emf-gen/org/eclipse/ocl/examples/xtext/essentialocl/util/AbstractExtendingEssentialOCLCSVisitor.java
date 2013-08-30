/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
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
 * from: org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCST.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.ocl.examples.xtext.essentialocl.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingEssentialOCLCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingEssentialOCLCSVisitor<R, C>
	extends org.eclipse.ocl.examples.xtext.base.util.AbstractExtendingBaseCSVisitor<R, C>
	implements EssentialOCLCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingEssentialOCLCSVisitor(@NonNull C context) {
		super(context);
	}	

	public @Nullable R visitBinaryOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS object) {
		return visitOperatorCS(object);
	}

	public @Nullable R visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable R visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public @Nullable R visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitCollectionTypeCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitConstructorExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ConstructorExpCS object) {
		return visitNamedExpCS(object);
	}

	public @Nullable R visitConstructorPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ConstructorPartCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitContextCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitExpSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS object) {
		return visitSpecificationCS(object);
	}

	public @Nullable R visitIfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitIndexExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS object) {
		return visitNamedExpCS(object);
	}

	public @Nullable R visitInfixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable R visitInvocationExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS object) {
		return visitNamedExpCS(object);
	}

	public @Nullable R visitLetExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitLetVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS object) {
		return visitVariableCS(object);
	}

	public @Nullable R visitLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitNamedExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitNavigatingArgCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitNavigationOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS object) {
		return visitBinaryOperatorCS(object);
	}

	public @Nullable R visitNestedExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitNullLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable R visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable R visitOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitPrefixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public @Nullable R visitSelfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitStringLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable R visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public @Nullable R visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS object) {
		return visitVariableCS(object);
	}

	public @Nullable R visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public @Nullable R visitTypeNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitUnaryOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS object) {
		return visitOperatorCS(object);
	}

	public @Nullable R visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable R visitVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS object) {
		return visitNamedElementCS(object);
	}
}
