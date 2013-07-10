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
 * $Id: OCLstdlibPostOrderVisitor.java,v 1.7 2011/05/20 15:27:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS;

public class OCLstdlibPostOrderVisitor extends AbstractOCLstdlibPostOrderVisitor
{		
	public OCLstdlibPostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitPrecedenceCS(@NonNull PrecedenceCS csPrecedence) {
		return null;
	}
}