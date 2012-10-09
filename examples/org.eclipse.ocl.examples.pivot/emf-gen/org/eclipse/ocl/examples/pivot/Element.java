/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: Element.java,v 1.4 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainElement
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An element is a constituent of a model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Element#getOwnedComment <em>Owned Comment</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Element#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getElement()
 * @model abstract="true" superTypes="org.eclipse.ocl.examples.pivot.Visitable"
 * @extends PivotObject
 * @generated
 */
public interface Element
		extends PivotObject, Visitable, org.eclipse.ocl.examples.domain.elements.DomainElement {

	/**
	 * Returns the value of the '<em><b>Owned Comment</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Comment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Comments owned by this element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Comment</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getElement_OwnedComment()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!Element!ownedComment'"
	 * @generated
	 */
	EList<Comment> getOwnedComment();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Comment} and appends it to the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Comment}.
	 * @see #getOwnedComment()
	 * @generated
	 */
	Comment createOwnedComment();
	
	/**
	 * Returns the value of the '<em><b>Extension</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.ElementExtension}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.ElementExtension#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getElement_Extension()
	 * @see org.eclipse.ocl.examples.pivot.ElementExtension#getBase
	 * @model opposite="base" containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!Element!extension'"
	 * @generated
	 */
	EList<ElementExtension> getExtension();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.ElementExtension} and appends it to the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.ElementExtension}.
	 * @see #getExtension()
	 * @generated
	 */
	ElementExtension createExtension();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\noclContents()\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary%> standardLibrary = evaluator.getStandardLibrary();\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.TypeId%> T_OclElement = <%org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables%>.Types._OclElement.getTypeId();\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.CollectionTypeId%> T_Set_OclElement_ = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.SET.getSpecializedId(T_OclElement);\n\nfinal @NonNull Object result = <%org.eclipse.ocl.examples.pivot.bodies.ElementBodies%>._allOwnedElements_body_.INSTANCE.evaluate(evaluator, T_Set_OclElement_, this);\nreturn (EList<Element>)((<%org.eclipse.ocl.examples.domain.values.Value%>)result).asEcoreObject();\n\n'"
	 * @generated
	 */
	EList<Element> allOwnedElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" stereotypeRequired="true" propertyNameDataType="org.eclipse.ocl.examples.pivot.String" propertyNameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nnull\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.TypeId%> T_OclVoid = <%org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables%>.Types._OclVoid.getTypeId();\n\nfinal @NonNull Object result = <%org.eclipse.ocl.examples.pivot.bodies.ElementBodies%>._getValue_body_.INSTANCE.evaluate(evaluator, T_OclVoid, this, <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.valueOf(stereotype), <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.valueOf(propertyName));\nreturn (Element)result;\n\n'"
	 * @generated
	 */
	Element getValue(Type stereotype, String propertyName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Elements that must be owned must have an owner.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nnot allOwnedElements()->includes(self)\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\n\nfinal @NonNull Object result = <%org.eclipse.ocl.examples.pivot.bodies.ElementBodies%>._invariant_not_own_self.INSTANCE.evaluate(evaluator, T_Boolean, this);\nfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\nif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\treturn true;\n}\nif (diagnostics != null) {\n\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"Element\", \"not_own_self\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.ELEMENT__NOT_OWN_SELF, message, new Object [] { this }));\n}\nreturn false;\n\n'"
	 * @generated
	 */
	boolean validateNotOwnSelf(DiagnosticChain diagnostics, Map<Object, Object> context);

	EObject getETarget();
} // Element
