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
package org.eclipse.ocl.examples.codegen.cgmodel.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CG2StringVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.ocl.examples.codegen.cse.AbstractPlace;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class CGElementImpl extends MinimalEObjectImpl.Container implements CGElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGModelPackage.Literals.CG_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return CG2StringVisitor.toString(this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return visitor.visitCGElement(this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @NonNull Iterable<? extends CGElement> getChildren() {
		@SuppressWarnings({"null", "unchecked"}) @NonNull Iterable<? extends CGElement> eContents = (Iterable<? extends CGElement>) eContents();
		return eContents;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable CGElement getParent() {
		return (CGElement)eContainer();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable AbstractPlace getPlace(@NonNull Map<CGElement,AbstractPlace> element2place) {
		return GlobalPlace.createGlobalPlace(element2place, this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isContext() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean rewriteAs(@NonNull CGValuedElement oldValue, @NonNull CGValuedElement newValue) {
		throw new UnsupportedOperationException(getClass().getName() + ".rewriteAs()");
	}

} //CGElementImpl
