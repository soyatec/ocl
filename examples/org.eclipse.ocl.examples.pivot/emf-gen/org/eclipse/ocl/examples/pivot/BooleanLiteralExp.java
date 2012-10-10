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
 * $Id: BooleanLiteralExp.java,v 1.2 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getBooleanLiteralExp()
 * @model
 * @generated
 */
public interface BooleanLiteralExp
		extends PrimitiveLiteralExp {

	/**
	 * Returns the value of the '<em><b>Boolean Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean Symbol</em>' attribute.
	 * @see #isSetBooleanSymbol()
	 * @see #unsetBooleanSymbol()
	 * @see #setBooleanSymbol(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getBooleanLiteralExp_BooleanSymbol()
	 * @model unsettable="true" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!BooleanLiteralExp!booleanSymbol'"
	 * @generated
	 */
	boolean isBooleanSymbol();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean Symbol</em>' attribute.
	 * @see #isSetBooleanSymbol()
	 * @see #unsetBooleanSymbol()
	 * @see #isBooleanSymbol()
	 * @generated
	 */
	void setBooleanSymbol(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.ocl.examples.pivot.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBooleanSymbol()
	 * @see #isBooleanSymbol()
	 * @see #setBooleanSymbol(boolean)
	 * @generated
	 */
	void unsetBooleanSymbol();

	/**
	 * Returns whether the value of the '{@link org.eclipse.ocl.examples.pivot.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Boolean Symbol</em>' attribute is set.
	 * @see #unsetBooleanSymbol()
	 * @see #isBooleanSymbol()
	 * @see #setBooleanSymbol(boolean)
	 * @generated
	 */
	boolean isSetBooleanSymbol();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of a boolean Literal expression is the type Boolean.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nself.type = Boolean\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\n\nfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.BooleanLiteralExpBodies%>._invariant_TypeIsBoolean.INSTANCE.evaluate(evaluator, T_Boolean, this);\nfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\nif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\treturn true;\n}\nif (diagnostics != null) {\n\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"BooleanLiteralExp\", \"TypeIsBoolean\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.BOOLEAN_LITERAL_EXP__TYPE_IS_BOOLEAN, message, new Object [] { this }));\n}\nreturn false;\n\n'"
	 * @generated
	 */
	boolean validateTypeIsBoolean(DiagnosticChain diagnostics, Map<Object, Object> context);

} // BooleanLiteralExp
