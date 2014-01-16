/**
 * <copyright>
 *
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.build.utilities;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Corrects OpaqueExpression.expressionInOCL volatile   // Bug 425927.
 */
public class PivotWorkarounds extends WorkflowComponentWithModelSlot
{
	private Logger log = Logger.getLogger(getClass());

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		Resource resource = (Resource) ctx.get(getModelSlot());
		log.info("Applying Pivot Workarpunds to '" + resource.getURI() + "'");
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage) eObject;
				EClass eClassifier = (EClass) ePackage.getEClassifier("OpaqueExpression");
				EStructuralFeature eReference = eClassifier.getEStructuralFeature("expressionInOCL");
				eReference.setVolatile(false);
			}
		}
	}
}
