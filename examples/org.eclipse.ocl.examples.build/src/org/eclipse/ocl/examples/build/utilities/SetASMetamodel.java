/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: PruneSuperClasses.java,v 1.3 2011/02/15 19:58:23 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.ocl.examples.pivot.PivotConstants;

/**
 * Adds the http://www.eclipse.org/OCL/ASMetamodel annotation.
 */
public class SetASMetamodel extends WorkflowComponentWithModelSlot
{
	private Logger log = Logger.getLogger(getClass());

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		Resource resource = (Resource) ctx.get(getModelSlot());
		log.info("Adding ASMetamodel annotation in '" + resource.getURI() + "'");
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage) eObject;
				EAnnotation eAnnotation = ePackage.getEAnnotation(PivotConstants.AS_METAMODEL_ANNOTATION_SOURCE);
				if (eAnnotation == null) {
					eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					eAnnotation.setSource(PivotConstants.AS_METAMODEL_ANNOTATION_SOURCE);
					ePackage.getEAnnotations().add(eAnnotation);
				}
			}
		}
	}
}
