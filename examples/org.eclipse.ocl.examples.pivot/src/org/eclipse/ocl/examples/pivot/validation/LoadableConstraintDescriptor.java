/**
 * <copyright>
 *
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * A CompleteOCLConstraintDescriptor realizes both an IConstraintDescriptor and IModelConstraint
 * to support a Constraint derived from parsing a CompleteOCL document. The resulting desciptor
 * is suitable for use with the EMF.Valitation framework.
 */
public class LoadableConstraintDescriptor extends AbstractConstraintDescriptor implements IModelConstraint
{
	private final @NonNull Constraint constraint;
	private final @NonNull EClassifier targetType;
	private final @NonNull String id;
	private final @NonNull String name;
	private final String namespace;
	private final int code;
	private ExpressionInOCL query = null;
	
	public LoadableConstraintDescriptor(@NonNull EClassifier targetType, @NonNull Constraint constraint, int code) {
		String namespace = targetType.getEPackage().getNsURI();
		this.constraint = constraint;
		this.targetType = targetType;
		String name = constraint.getName();
		if (name == null) {
			name = Long.toHexString(System.identityHashCode(constraint));
		}
		
		id = "'" + namespace + "'::" + targetType.getName() + "::" + name;
		this.name = targetType.getName() + "::" + name;
		this.namespace = namespace;
		this.code = code;
	}
	
	final Constraint getConstraint() {
		return constraint;
	}
	
	public String getBody() {
		return PrettyPrinter.print(constraint);
	}

	public String getDescription() {
		return getBody();
	}

	public EvaluationMode<?> getEvaluationMode() {
		return EvaluationMode.BATCH;
	}

	public String getId() {
		return id;
	}

	public String getMessagePattern() {
		return String.format("Constraint %s violated on {0}", getName()); //$NON-NLS-1$
	}

	public String getName() {
		return name;
	}

	public String getPluginId() {
		return namespace;
	}

	public ConstraintSeverity getSeverity() {
		return ConstraintSeverity.WARNING;
	}

	public int getStatusCode() {
		return code;
	}

	public boolean targetsEvent(Notification notification) {
		return false;
	}

	public boolean targetsTypeOf(EObject eObject) {
		return targetType.isInstance(eObject);
	}

	public IStatus validate(IValidationContext ctx) {
		EObject target = ctx.getTarget();
		EClassifier eClassifier = target.eClass();
		OCL ocl = LoadableConstraintProvider.getOCL();
		ExpressionInOCL query2 = query;
		if (query2 == null) {
			MetaModelManager metaModelManager = ocl.getMetaModelManager();
			NamedElement contextElement = metaModelManager.getPivotOfEcore(NamedElement.class, eClassifier);
			if (contextElement == null) {
				return ctx.createFailureStatus(target);
			}
			ValueSpecification specification = constraint.getSpecification();
			if (specification == null) {
				return ctx.createFailureStatus(target);
			}
			query = query2 = PivotUtil.getExpressionInOCL(contextElement, specification);
			if (query2 == null) {
				return ctx.createFailureStatus(target);
			}
		}
		Object result = ocl.evaluate(target, query2);
		if (result != Boolean.TRUE) {
			return ctx.createFailureStatus(target);
		}
		return ctx.createSuccessStatus();
	}
}
