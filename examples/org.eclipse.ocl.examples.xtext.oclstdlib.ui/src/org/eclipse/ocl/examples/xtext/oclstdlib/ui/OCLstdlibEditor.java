/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.oclstdlib.ui;

import org.eclipse.ocl.examples.xtext.oclstdlib.ui.internal.OCLstdlibActivator;
import org.eclipse.xtext.ui.editor.XtextEditor;

public class OCLstdlibEditor extends XtextEditor
{
	public static final String EDITOR_ID = OCLstdlibActivator.ORG_ECLIPSE_OCL_EXAMPLES_XTEXT_OCLSTDLIB_OCLSTDLIB;

	public OCLstdlibEditor() {
		super();
	}
}