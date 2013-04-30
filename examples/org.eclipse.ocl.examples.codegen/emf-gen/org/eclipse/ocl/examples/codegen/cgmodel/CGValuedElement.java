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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;




/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Valued Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isBoxed <em>Boxed</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isCaught <em>Caught</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isFalse <em>False</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isGlobal <em>Global</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isInlineable <em>Inlineable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isInvalid <em>Invalid</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isNull <em>Null</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isNonInvalid <em>Non Invalid</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isNonNull <em>Non Null</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getReferredValuedElement <em>Referred Valued Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isSettable <em>Settable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isTrue <em>True</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isUnboxed <em>Unboxed</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getValueName <em>Value Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement()
 * @model abstract="true"
 * @generated
 */
public interface CGValuedElement extends CGTypedElement {
	/**
	 * Returns the value of the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boxed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this element is represented using boxed values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Boxed</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_Boxed()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isBoxed();

	/**
	 * Returns the value of the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether an invalid value of this element is represented by an invalid value (true), an invalid exception (false).
	 * The value is null until determined by the FieldingAnalyzer.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Caught</em>' attribute.
	 * @see #setCaught(boolean)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_Caught()
	 * @model
	 * @generated
	 */
	boolean isCaught();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#isCaught <em>Caught</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caught</em>' attribute.
	 * @see #isCaught()
	 * @generated
	 */
	void setCaught(boolean value);

	/**
	 * Returns the value of the '<em><b>Inlineable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inlineable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this element is a constant that can be evaluated inline and so needs no declaration (e.g. null, true).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inlineable</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_Inlineable()
	 * @model default="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isInlineable();

	/**
	 * Returns the value of the '<em><b>Invalid</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invalid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this element is constant and represents an invalid value (and nothing else).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Invalid</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_Invalid()
	 * @model default="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isInvalid();

	/**
	 * Returns the value of the '<em><b>Null</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Null</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this element is constant and represents the null value (and nothing else).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Null</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_Null()
	 * @model default="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isNull();

	/**
	 * Returns the value of the '<em><b>False</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this element is constant and represents the false value (and nothing else).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>False</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_False()
	 * @model default="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isFalse();

	/**
	 * Returns the value of the '<em><b>Global</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this element is global (and constant). Global values may be statically
	 * computed and shared.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Global</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_Global()
	 * @model default="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isGlobal();

	/**
	 * Returns the value of the '<em><b>Non Invalid</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Invalid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this element is constant and represents something other than an invalid value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Non Invalid</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_NonInvalid()
	 * @model default="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isNonInvalid();

	/**
	 * Returns the value of the '<em><b>Non Null</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Null</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this element is constant and represents something other than the null value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Non Null</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_NonNull()
	 * @model default="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isNonNull();

	/**
	 * Returns the value of the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element from which this element's value is determined, which is this for a self-determining
	 * element such as a CGConstant or CGCatchExp, but may delegate for an element such as a CGBoxExp
	 * or CGVariableExp. Following the referredValuedElement daisy chain leads to the value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Valued Element</em>' reference.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_ReferredValuedElement()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	CGValuedElement getReferredValuedElement();

	/**
	 * Returns the value of the '<em><b>Settable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this element is subject to assignment from multiple sources. (e.g the then/else value of an if).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Settable</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_Settable()
	 * @model default="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isSettable();

	/**
	 * Returns the value of the '<em><b>True</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this element is constant and represents the true value (and nothing else).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>True</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_True()
	 * @model default="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isTrue();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The first valued element along the referredValuedElement daisy chain that has a reified value with a name.
	 * e.g. A CGCatchExp defines a variable which is what is referenced, but its underlying type is available
	 * by following the referredValuedElement daisy chain to its end.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_Value()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	@NonNull CGValuedElement getValue();

	/**
	 * Returns the value of the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The declared name value of this element. The text is valid for use in the target language and
	 * unique within the context in which this element is declared.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value Name</em>' attribute.
	 * @see #setValueName(String)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_ValueName()
	 * @model
	 * @generated
	 */
	String getValueName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement#getValueName <em>Value Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Name</em>' attribute.
	 * @see #getValueName()
	 * @generated
	 */
	void setValueName(String value);

	/**
	 * Returns the value of the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unboxed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this element is represented using unboxed values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unboxed</em>' attribute.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_Unboxed()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isUnboxed();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setNonInvalid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setNonNull();

	boolean isConstant();

	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The elements that must be declared before this element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Depends On</em>' reference list.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGValuedElement_DependsOn()
	 * @model resolveProxies="false"
	 * @generated
	 */
	@NonNull List<CGValuedElement> getDependsOn();

} // CGValuedElement
