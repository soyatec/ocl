/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: PrimitiveTypeImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Self Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getSelfType()
 * @model
 * @generated
 */
public interface SelfType extends org.eclipse.ocl.examples.pivot.Class
{

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" selfTypeRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nselfType\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.TypeId%> T_Type = <%org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables%>.Types._Type.getTypeId();\n\nfinal @NonNull Object result = <%org.eclipse.ocl.examples.pivot.bodies.SelfTypeBodies%>._resolveSelfType_body_.INSTANCE.evaluate(evaluator, T_Type, this, <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.valueOf(selfType));\nreturn (Type)result;\n\n'"
	 * @generated
	 */
	Type resolveSelfType(Type selfType);
} // SelfType
