/**
 * <copyright>
 *
 * Copyright (c) 2012,2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.xtext.oclinecore.ui.preferences;

import java.util.List;

import org.eclipse.ocl.common.ui.internal.preferences.AbstractProjectPreferencePage;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.options.OCLinEcoreOptions;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.messages.OCLinEcoreUIMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * The Project/Property preference page for the OCLinEcore options.
 */
public class OCLinEcoreProjectPreferencePage extends AbstractProjectPreferencePage
{
	
	public OCLinEcoreProjectPreferencePage() {
		super(PivotConstants.PLUGIN_ID, OCLinEcoreUIMessages.OCLinEcore_PageTitle);
	}

	@Override
	protected AbstractProjectPreferencePage createClonePage() {
		return new OCLinEcoreProjectPreferencePage();
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	@Override
	protected void createFieldEditors(Composite fieldEditorParent, List<IFieldEditor> fields) {
		Label horizontalLine= new Label(fieldEditorParent, SWT.SEPARATOR | SWT.HORIZONTAL);
		horizontalLine.setLayoutData(new GridData(GridData.FILL, GridData.FILL, false, false, 2, 1));
		horizontalLine.setFont(fieldEditorParent.getFont());
		fields.add(new MyComboFieldEditor(OCLinEcoreOptions.EXPORT_DELEGATION_URI,
			OCLinEcoreUIMessages.OCLinEcore_EditorDelegationMode, ElementUtil.getDelegateURIs(), fieldEditorParent));
	}
}