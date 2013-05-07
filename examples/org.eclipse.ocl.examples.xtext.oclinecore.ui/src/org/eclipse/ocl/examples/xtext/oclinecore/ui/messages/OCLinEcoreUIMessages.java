/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
 * $Id$
 */

package org.eclipse.ocl.examples.xtext.oclinecore.ui.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class OCLinEcoreUIMessages
{	
	static {
		NLS.initializeMessages(OCLinEcoreUIMessages.class.getName(), OCLinEcoreUIMessages.class);
	}

	public static String OCLinEcore_EditorDelegationMode;
	public static String OCLinEcore_PageTitle;
}
