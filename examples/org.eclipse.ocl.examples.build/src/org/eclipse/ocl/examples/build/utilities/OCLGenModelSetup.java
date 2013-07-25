/**
 * <copyright>
 *
 * Copyright (c) 2010, 2011 E.D.Willink and others.
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
 * $Id: UMLGenModelSetup.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import org.eclipse.ocl.examples.build.modelspecs.CGTypedElementModelSpec;
import org.eclipse.ocl.examples.build.modelspecs.CGValuedElementModelSpec;

/**
 * Initializes OCL genmodel support by registering the contributing MethodSpecs.
 */
public class OCLGenModelSetup
{
	public OCLGenModelSetup() {
	    CGValuedElementModelSpec.register();
	    CGTypedElementModelSpec.register();
	}
}
