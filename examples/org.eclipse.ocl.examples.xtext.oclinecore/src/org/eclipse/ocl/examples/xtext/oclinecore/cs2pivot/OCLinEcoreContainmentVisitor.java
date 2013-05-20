/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.xtext.oclinecore.cs2pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.SysMLCS;

public class OCLinEcoreContainmentVisitor extends AbstractOCLinEcoreContainmentVisitor
{
	public OCLinEcoreContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitSysMLCS(@NonNull SysMLCS csElement) {
		Annotation pivotElement = context.refreshModelElement(Annotation.class, PivotPackage.Literals.ANNOTATION, csElement);
		if (pivotElement != null) {
			context.refreshName(pivotElement, PivotConstants.SYSML_ANNOTATION_SOURCE);
			context.refreshComments(pivotElement, csElement);
		}
		return null;
	}
}
