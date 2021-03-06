/*******************************************************************************
 * Copyright (c) 2009, 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************
 * $Id: ContentEquals.java,v 1.2 2011/03/05 21:51:23 auhl Exp $
 */
package dataaccess.expressions;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content Equals</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Compares two entity objects by the content of those associations marked as equality relevant for the entity.
 * <!-- end-model-doc -->
 *
 *
 * @see dataaccess.expressions.ExpressionsPackage#getContentEquals()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ContentEqualsOnlyForEntities='self.left.getType().getInnermost().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n  self.right.getType().getInnermost().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n  not self.left.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.valueType and\r\n  not self.right.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.valueType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ContentEqualsOnlyForEntities'"
 * @generated
 */
public interface ContentEquals extends Equals {
} // ContentEquals
