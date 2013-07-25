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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * CGElement is the abstract class from which all classes contribution to a CG tree derive.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGElement()
 * @model abstract="true"
 * @generated
 */
public interface CGElement extends EObject {

	/**
	 * Accept a visit from a visitor and return the result of a call to the derived type-specific visitXXX in the visitor.
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build/templates/model/Class/insert.javajetinc
	public @Nullable <R> R accept(@NonNull CGModelVisitor<R> visitor);

	/**
	 * Return the child CGElements.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.modelspecs.CGElementModelSpec$1
	@NonNull Iterable<? extends CGElement> getChildren();

	/**
	 * Return the parent node in a CG tree, null at the root.
	 *
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build.modelspecs.CGElementModelSpec$2
	@Nullable CGElement getParent();
} // CGElement
