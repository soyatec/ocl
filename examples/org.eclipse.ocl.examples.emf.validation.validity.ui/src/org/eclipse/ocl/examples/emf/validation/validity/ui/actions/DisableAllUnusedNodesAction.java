/**
 * <copyright>
 *
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	 Obeo - initial API and implementation
 *  
 * </copyright>
 */
package org.eclipse.ocl.examples.emf.validation.validity.ui.actions;

import java.net.URL;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ocl.examples.emf.validation.validity.ui.filters.UnusedNodesVisibilityFilter;
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidityUIMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.plugin.ValidityUIPlugin;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;

public final class DisableAllUnusedNodesAction extends AbstractFilterAction
{
	private @NonNull UnusedNodesVisibilityFilter filter = new UnusedNodesVisibilityFilter();
	
	public DisableAllUnusedNodesAction(@NonNull ValidityView validityView, boolean isValidatableFilterAction) {
		super(ValidityUIMessages.ValidityView_Action_ShowHideUnusedNodes_Title,
				IAction.AS_CHECK_BOX,
				isValidatableFilterAction ? ValidityUIMessages.ValidityView_Action_HideUnusedValidatableNodes_ToolTipText
										  : ValidityUIMessages.ValidityView_Action_HideUnusedConstrainingNodes_ToolTipText,
				ValidityUIMessages.ValidityView_Action_ShowUnusedNodes_ImageLocation,
				validityView,  isValidatableFilterAction);
//		refreshChecked();
	}

	public void refreshChecked() {
		if (this.isChecked()){
			setToolTipText(isValidatableAction ? ValidityUIMessages.ValidityView_Action_ShowUnusedValidatableNodes_ToolTipText
													 : ValidityUIMessages.ValidityView_Action_ShowUnusedConstrainingNodes_ToolTipText);
			URL image = (URL) ValidityUIPlugin.INSTANCE.getImage(ValidityUIMessages.ValidityView_Action_HideUnusedNodes_ImageLocation);
			setImageDescriptor(ImageDescriptor.createFromURL(image));
			validityView.addFilter(isValidatableAction, filter);
		} else {
			setToolTipText(isValidatableAction ? ValidityUIMessages.ValidityView_Action_HideUnusedValidatableNodes_ToolTipText
													 : ValidityUIMessages.ValidityView_Action_HideUnusedConstrainingNodes_ToolTipText);
			URL image = (URL) ValidityUIPlugin.INSTANCE.getImage(ValidityUIMessages.ValidityView_Action_ShowUnusedNodes_ImageLocation);
			setImageDescriptor(ImageDescriptor.createFromURL(image));
			validityView.removeFilter(isValidatableAction, filter);
		}
	}

	@Override
	public void run() {
		refreshChecked();
	}

	@Override
	public void setChecked(boolean isChecked) {
		super.setChecked(isChecked);
		refreshChecked();
	}
}