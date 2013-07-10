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
 * $Id: OCLinEcoreLeft2RightVisitor.java,v 1.9 2011/05/23 05:51:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.oclinecore.util.AbstractOCLinEcoreLeft2RightVisitor;

public class OCLinEcoreLeft2RightVisitor extends AbstractOCLinEcoreLeft2RightVisitor
{
	public OCLinEcoreLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}
}