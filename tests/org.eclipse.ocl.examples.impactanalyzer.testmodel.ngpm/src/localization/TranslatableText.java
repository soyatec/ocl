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
 * $Id: TranslatableText.java,v 1.2 2011/03/05 21:52:06 auhl Exp $
 */
package localization;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Translatable Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link localization.TranslatableText#getText <em>Text</em>}</li>
 *   <li>{@link localization.TranslatableText#getHintForTranslator <em>Hint For Translator</em>}</li>
 * </ul>
 * </p>
 *
 * @see localization.LocalizationPackage#getTranslatableText()
 * @model
 * @generated
 */
public interface TranslatableText extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see localization.LocalizationPackage#getTranslatableText_Text()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link localization.TranslatableText#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Hint For Translator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hint For Translator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hint For Translator</em>' attribute.
	 * @see #setHintForTranslator(String)
	 * @see localization.LocalizationPackage#getTranslatableText_HintForTranslator()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getHintForTranslator();

	/**
	 * Sets the value of the '{@link localization.TranslatableText#getHintForTranslator <em>Hint For Translator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hint For Translator</em>' attribute.
	 * @see #getHintForTranslator()
	 * @generated
	 */
	void setHintForTranslator(String value);

} // TranslatableText
