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
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTypedMultiplicityElement()
 * @model abstract="true"
 * @generated
 */
public interface TypedMultiplicityElement
		extends TypedElement {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" bodySpecificationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nbodySpecification.type.conformsTo(self.type)\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId%> T_Boolean = <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN;\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies%>._CompatibleBody_body_.INSTANCE.evaluate(evaluator, T_Boolean, this, <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.valueOf(bodySpecification));\n\tfinal java.lang.Boolean ecoreResult = (java.lang.Boolean)result;\n\tif (ecoreResult != null) {\n\t\treturn ecoreResult;\n\t}\n\tthrow new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"null result from <%org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies%>._CompatibleBody_body_\");\n} catch (<%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%> e) {\n\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(e);\n}'"
	 * @generated
	 */
	boolean CompatibleBody(ValueSpecification bodySpecification);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/*\nParameter{name = \'name\'}\n\052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.PackageId%> Pk_pivot = <%org.eclipse.ocl.examples.domain.ids.IdManager%>.INSTANCE.getPackageId(<%org.eclipse.ocl.examples.pivot.PivotPackage%>.eINSTANCE);\nfinal @NonNull <%org.eclipse.ocl.examples.domain.ids.ClassId%> T_pivot__Parameter = Pk_pivot.getClassId(\"Parameter\");\ntry {\n\tfinal Object result = <%org.eclipse.ocl.examples.pivot.bodies.TypedMultiplicityElementBodies%>._makeParameter_body_.INSTANCE.evaluate(evaluator, T_pivot__Parameter, this);\n\tfinal org.eclipse.ocl.examples.pivot.Parameter ecoreResult = (org.eclipse.ocl.examples.pivot.Parameter)result;\n\treturn ecoreResult;\n} catch (<%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%> e) {\n\tthrow e;\n} catch (Exception e) {\n\tthrow new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(e);\n}'"
	 * @generated
	 */
	Parameter makeParameter();
} // TypedMultiplicityElement
