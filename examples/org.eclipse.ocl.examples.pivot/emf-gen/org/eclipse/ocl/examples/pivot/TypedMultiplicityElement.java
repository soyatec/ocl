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
 * $Id: TypedMultiplicityElement.java,v 1.3 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Multiplicity Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TypedMultiplicityElement#isRequired <em>Is Required</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTypedMultiplicityElement()
 * @model abstract="true"
 * @generated
 */
public interface TypedMultiplicityElement
		extends TypedElement {

	/**
	 * Returns the value of the '<em><b>Is Required</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Required</em>' attribute.
	 * @see #setIsRequired(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTypedMultiplicityElement_IsRequired()
	 * @model default="true" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!TypedMultiplicityElement!isRequired'"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.TypedMultiplicityElement#isRequired <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setIsRequired(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" bodySpecificationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nbodySpecification.type.conformsTo(self.type)\n\052/\ntry {\n\tfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\n\tfinal @NonNull <%org.eclipse.ocl.examples.library.executor.ExecutorType%> T_Boolean = <%org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables%>.Types._Boolean;\n\tfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.TypeId%> returnTypeId = T_Boolean.getTypeId();\n\tfinal @NonNull Object result = <%org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies%>._CompatibleBody_body_.INSTANCE.evaluate(evaluator, returnTypeId, this, <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.valueOf(bodySpecification));\n\treturn evaluator.asEcoreObject((Boolean)null, result);\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\tthrow new <%org.eclipse.emf.common.util.WrappedException%>(\"Failed to evaluate org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies\", e);\n}\n'"
	 * @generated
	 */
	boolean CompatibleBody(ValueSpecification bodySpecification);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nParameter{name = \'name\'}\n\052/\ntry {\n\tfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\n\tfinal @NonNull <%org.eclipse.ocl.examples.library.executor.ExecutorType%> T_pivot__Parameter = <%org.eclipse.ocl.examples.pivot.PivotTables%>.Types._Parameter;\n\tfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.TypeId%> returnTypeId = T_pivot__Parameter.getTypeId();\n\tfinal @NonNull Object result = <%org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies%>._makeParameter_body_.INSTANCE.evaluate(evaluator, returnTypeId, this);\n\treturn evaluator.asEcoreObject((Parameter)null, result);\n} catch (<%org.eclipse.ocl.examples.domain.evaluation.InvalidValueException%> e) {\n\tthrow new <%org.eclipse.emf.common.util.WrappedException%>(\"Failed to evaluate org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies\", e);\n}\n'"
	 * @generated
	 */
	Parameter makeParameter();
} // TypedMultiplicityElement
