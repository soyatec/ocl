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
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.cs2as.BaseLeft2RightVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;

public class AbstractEssentialOCLLeft2RightVisitor
	extends BaseLeft2RightVisitor implements EssentialOCLCSVisitor<Element>
{
	//
	//	This file is maintained by copying from AbstractExtendingEssentialOCLCSVisitor and changing R to Element.
	//
	protected AbstractEssentialOCLLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Element visitBinaryOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS object) {
		return visitOperatorCS(object);
	}

	public @Nullable Element visitBooleanLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable Element visitCollectionLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public @Nullable Element visitCollectionLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable Element visitCollectionTypeCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable Element visitConstructorExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ConstructorExpCS object) {
		return visitNamedExpCS(object);
	}

	public @Nullable Element visitConstructorPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ConstructorPartCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable Element visitContextCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable Element visitExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable Element visitExpSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS object) {
		return visitSpecificationCS(object);
	}

	public @Nullable Element visitIfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Element visitIndexExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS object) {
		return visitNamedExpCS(object);
	}

	public @Nullable Element visitInfixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Element visitInvalidLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable Element visitInvocationExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS object) {
		return visitNamedExpCS(object);
	}

	public @Nullable Element visitLetExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Element visitLetVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS object) {
		return visitVariableCS(object);
	}

	public @Nullable Element visitLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Element visitNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Element visitNamedExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Element visitNavigatingArgCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable Element visitNavigationOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS object) {
		return visitBinaryOperatorCS(object);
	}

	public @Nullable Element visitNestedExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Element visitNullLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable Element visitNumberLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable Element visitOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable Element visitPrefixExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Element visitPrimitiveLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public @Nullable Element visitSelfExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable Element visitStringLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable Element visitTupleLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public @Nullable Element visitTupleLiteralPartCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS object) {
		return visitVariableCS(object);
	}

	public @Nullable Element visitTypeLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS object) {
		return visitLiteralExpCS(object);
	}

	public @Nullable Element visitTypeNameExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable Element visitUnaryOperatorCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS object) {
		return visitOperatorCS(object);
	}

	public @Nullable Element visitUnlimitedNaturalLiteralExpCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS object) {
		return visitPrimitiveLiteralExpCS(object);
	}

	public @Nullable Element visitVariableCS(@NonNull org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS object) {
		return visitNamedElementCS(object);
	}
}