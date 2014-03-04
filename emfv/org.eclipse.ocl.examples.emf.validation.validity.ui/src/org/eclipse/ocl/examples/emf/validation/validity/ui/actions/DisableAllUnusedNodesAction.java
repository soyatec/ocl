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
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.ui.filters.HideUnusedNodesViewerFilter;
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidationDebugMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.plugin.ValidityUIPlugin;

public final class DisableAllUnusedNodesAction extends AbstractFilterAction
{
	private HideUnusedNodesViewerFilter filter = new HideUnusedNodesViewerFilter();
	
	public DisableAllUnusedNodesAction(@NonNull ValidityManager validityManager, @NonNull StructuredViewer filteredViewer, boolean isValidatableFilterAction) {
		super(ValidationDebugMessages.ValidityView_Action_ShowHideUnusedNodes_Title,
				IAction.AS_CHECK_BOX,
				isValidatableFilterAction ? ValidationDebugMessages.ValidityView_Action_HideUnusedValidatableNodes_ToolTipText
										  : ValidationDebugMessages.ValidityView_Action_HideUnusedConstrainingNodes_ToolTipText,
				ValidationDebugMessages.ValidityView_Action_ShowUnusedNodes_ImageLocation,
				validityManager, filteredViewer, isValidatableFilterAction);
	}

	@Override
	public void run() {
		if (this.isChecked()){
			setToolTipText(isValidatableFilterAction ? ValidationDebugMessages.ValidityView_Action_ShowUnusedValidatableNodes_ToolTipText
													 : ValidationDebugMessages.ValidityView_Action_ShowUnusedConstrainingNodes_ToolTipText);
			URL image = (URL) ValidityUIPlugin.INSTANCE.getImage(ValidationDebugMessages.ValidityView_Action_HideUnusedNodes_ImageLocation);
			setImageDescriptor(ImageDescriptor.createFromURL(image));
			filteredViewer.addFilter(filter);
		} else {
			setToolTipText(isValidatableFilterAction ? ValidationDebugMessages.ValidityView_Action_HideUnusedValidatableNodes_ToolTipText
													 : ValidationDebugMessages.ValidityView_Action_HideUnusedConstrainingNodes_ToolTipText);
			URL image = (URL) ValidityUIPlugin.INSTANCE.getImage(ValidationDebugMessages.ValidityView_Action_ShowUnusedNodes_ImageLocation);
			setImageDescriptor(ImageDescriptor.createFromURL(image));
			filteredViewer.removeFilter(filter);
		}
	}
}