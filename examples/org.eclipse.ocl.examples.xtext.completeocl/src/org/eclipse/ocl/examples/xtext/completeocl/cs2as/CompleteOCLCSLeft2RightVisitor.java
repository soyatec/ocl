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
 * $Id: CompleteOCLLeft2RightVisitor.java,v 1.10 2011/05/23 05:51:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.util.AbstractCompleteOCLCSLeft2RightVisitor;

public class CompleteOCLCSLeft2RightVisitor extends AbstractCompleteOCLCSLeft2RightVisitor
{
	public CompleteOCLCSLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}
}