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
 * $Id: MessageExp.java,v 1.5 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageExp#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageExp#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageExp#getCalledOperation <em>Called Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageExp#getSentSignal <em>Sent Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp()
 * @model
 * @generated
 */
public interface MessageExp
		extends OCLExpression {

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(OCLExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp_Target()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!MessageExp!target'"
	 * @generated
	 */
	OCLExpression getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MessageExp#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(OCLExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OCLExpression} and sets the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OCLExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OCLExpression}.
	 * @see #getTarget()
	 * @generated
	 */
	OCLExpression createTarget(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp_Argument()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!MessageExp!argument'"
	 * @generated
	 */
	EList<OCLExpression> getArgument();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OCLExpression} and appends it to the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OCLExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OCLExpression}.
	 * @see #getArgument()
	 * @generated
	 */
	OCLExpression createArgument(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Called Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Operation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Operation</em>' containment reference.
	 * @see #setCalledOperation(CallOperationAction)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp_CalledOperation()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!MessageExp!calledOperation'"
	 * @generated
	 */
	CallOperationAction getCalledOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MessageExp#getCalledOperation <em>Called Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Called Operation</em>' containment reference.
	 * @see #getCalledOperation()
	 * @generated
	 */
	void setCalledOperation(CallOperationAction value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.CallOperationAction} and sets the '<em><b>Called Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.CallOperationAction}.
	 * @see #getCalledOperation()
	 * @generated
	 */
	CallOperationAction createCalledOperation();

	/**
	 * Returns the value of the '<em><b>Sent Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sent Signal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sent Signal</em>' containment reference.
	 * @see #setSentSignal(SendSignalAction)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp_SentSignal()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/3.1.0/Pivot!MessageExp!sentSignal'"
	 * @generated
	 */
	SendSignalAction getSentSignal();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MessageExp#getSentSignal <em>Sent Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sent Signal</em>' containment reference.
	 * @see #getSentSignal()
	 * @generated
	 */
	void setSentSignal(SendSignalAction value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.SendSignalAction} and sets the '<em><b>Sent Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.SendSignalAction}.
	 * @see #getSentSignal()
	 * @generated
	 */
	SendSignalAction createSentSignal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An OCL message has either a called operation or a sent signal.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\ncalledOperation->size() + sentSignal->size() = 1\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\n\nfinal @NonNull Object result = <%org.eclipse.ocl.examples.pivot.bodies.MessageExpBodies%>._invariant_OneCallOrOneSend.INSTANCE.evaluate(evaluator, T_Boolean, this);\nfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\nif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\treturn true;\n}\nif (diagnostics != null) {\n\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"MessageExp\", \"OneCallOrOneSend\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.MESSAGE_EXP__ONE_CALL_OR_ONE_SEND, message, new Object [] { this }));\n}\nreturn false;\n\n'"
	 * @generated
	 */
	boolean validateOneCallOrOneSend(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target of an OCL message cannot be a collection.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nnot target.type.oclIsKindOf(CollectionType)\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\n\nfinal @NonNull Object result = <%org.eclipse.ocl.examples.pivot.bodies.MessageExpBodies%>._invariant_TargetIsNotACollection.INSTANCE.evaluate(evaluator, T_Boolean, this);\nfinal boolean resultIsNull = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.isNull(result);\nif (!resultIsNull && <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.asBoolean(result)) {\t// true => true, false/null => dropthrough, invalid => exception\n\treturn true;\n}\nif (diagnostics != null) {\n\tint severity = resultIsNull ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n\tString message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"MessageExp\", \"TargetIsNotACollection\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.DIAGNOSTIC_SOURCE, <%org.eclipse.ocl.examples.pivot.util.PivotValidator%>.MESSAGE_EXP__TARGET_IS_NOT_ACOLLECTION, message, new Object [] { this }));\n}\nreturn false;\n\n'"
	 * @generated
	 */
	boolean validateTargetIsNotACollection(DiagnosticChain diagnostics, Map<Object, Object> context);
} // MessageExp
