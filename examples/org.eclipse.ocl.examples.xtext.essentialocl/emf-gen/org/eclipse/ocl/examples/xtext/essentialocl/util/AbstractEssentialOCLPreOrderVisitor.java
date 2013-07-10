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
 * $Id: EssentialOCLPreOrderVisitor.java,v 1.7 2011/05/11 19:26:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.BasePreOrderVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

public class AbstractEssentialOCLPreOrderVisitor
	extends BasePreOrderVisitor implements EssentialOCLCSVisitor<Continuation<?>>
{
	//
	//	This file is maintained by copying from AbstractExtendingEssentialOCLCSVisitor and changing R to Continuation<?>.
	//
	protected AbstractEssentialOCLPreOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Continuation<?> visitBinaryOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS object) {
		return visitOperatorCS(object);
	}

	public @Nullable Continuation<?> visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable Continuation<?> visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public @Nullable Continuation<?> visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable Continuation<?> visitCollectionTypeCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable Continuation<?> visitConstructorExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ConstructorExpCS object) {
		return visitNamedExpCS(object);
	}

	public @Nullable Continuation<?> visitConstructorPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ConstructorPartCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable Continuation<?> visitContextCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable Continuation<?> visitExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable Continuation<?> visitExpSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS object) {
		return visitSpecificationCS(object);
	}

	public @Nullable Continuation<?> visitIfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Continuation<?> visitIndexExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS object) {
		return visitNamedExpCS(object);
	}

	public @Nullable Continuation<?> visitInfixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Continuation<?> visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable Continuation<?> visitInvocationExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS object) {
		return visitNamedExpCS(object);
	}

	public @Nullable Continuation<?> visitLetExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Continuation<?> visitLetVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS object) {
		return visitVariableCS(object);
	}

	public @Nullable Continuation<?> visitLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Continuation<?> visitNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Continuation<?> visitNamedExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Continuation<?> visitNavigatingArgCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable Continuation<?> visitNavigationOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS object) {
		return visitBinaryOperatorCS(object);
	}

	public @Nullable Continuation<?> visitNestedExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Continuation<?> visitNullLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable Continuation<?> visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable Continuation<?> visitOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable Continuation<?> visitPrefixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Continuation<?> visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public @Nullable Continuation<?> visitSelfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Continuation<?> visitStringLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable Continuation<?> visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public @Nullable Continuation<?> visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS object) {
		return visitVariableCS(object);
	}

	public @Nullable Continuation<?> visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public @Nullable Continuation<?> visitTypeNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable Continuation<?> visitUnaryOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS object) {
		return visitOperatorCS(object);
	}

	public @Nullable Continuation<?> visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable Continuation<?> visitVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS object) {
		return visitNamedElementCS(object);
	}
}