/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.base.ui.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class BaseMessages
{
	static {
		NLS.initializeMessages(BaseMessages.class.getName(), BaseMessages.class);
	}

	public static String SaveAS_ShellTitle;
	public static String SaveAS_Title;
	public static String SaveAS_Description;
	public static String SaveCS_ShellTitle;
	public static String SaveCS_Title;
	public static String SaveCS_Description;
	public static String SaveError_Title;
}
