/**
 * <copyright>
 *
 * Copyright (c) 2010, 2011 E.D.Willink and others.
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
 * $Id: AnnotationCS.java,v 1.3 2011/05/05 17:53:02 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.basecs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS#getOwnedContent <em>Owned Content</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS#getOwnedReference <em>Owned Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getAnnotationCS()
 * @model
 * @generated
 */
public interface AnnotationCS extends AnnotationElementCS {
	/**
	 * Returns the value of the '<em><b>Owned Content</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Content</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Content</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getAnnotationCS_OwnedContent()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementCS> getOwnedContent();

	/**
	 * Returns the value of the '<em><b>Owned Reference</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Reference</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Reference</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getAnnotationCS_OwnedReference()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementRefCS> getOwnedReference();

} // AnnotationCS