/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
 * $Id: OCLinEcorePreOrderVisitor.java,v 1.4 2011/05/20 15:27:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLLeft2RightVisitor;

public class AbstractOCLinEcoreLeft2RightVisitor
	extends EssentialOCLLeft2RightVisitor implements OCLinEcoreCSVisitor<Element>
{
	//
	//	This file is maintained by copying from AbstractExtendingOCLinEcoreCSVisitor and changing R to Element.
	//
	protected AbstractOCLinEcoreLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Element visitOCLinEcoreConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS object) {
		return visitConstraintCS(object);
	}

	public @Nullable Element visitSysMLCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.SysMLCS object) {
		return visitAnnotationElementCS(object);
	}
}