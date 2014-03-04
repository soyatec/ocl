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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.ui.filters.AlwaysTrueViewerFilter;
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidationDebugMessages;

public final class EnableAllNodesAction extends AbstractFilterAction {
	private AlwaysTrueViewerFilter filter = new AlwaysTrueViewerFilter();
	
	public EnableAllNodesAction(@NonNull ValidityManager validityManager, @NonNull StructuredViewer filteredViewer, boolean isValidatableFilterAction) {
		super(ValidationDebugMessages.ValidityView_Action_SelectAllNodes_Title,
				isValidatableFilterAction ? ValidationDebugMessages.ValidityView_Action_SelectAllValidatableNodes_ToolTipText
										  : ValidationDebugMessages.ValidityView_Action_SelectAllConstrainingNodes_ToolTipText,
				ValidationDebugMessages.ValidityView_Action_SelectAllNodes_ImageLocation,
				validityManager, filteredViewer, isValidatableFilterAction);
	}

	@Override
	public void run() {
		if (this.isEnabled()) {
			RootNode rootNode = validityManager.getRootNode();
			if (rootNode != null) {
				if (isValidatableFilterAction) {
					selectAll(rootNode.getValidatableNodes());
				} else {
					selectAll(rootNode.getConstrainingNodes());
				}
			}
			filteredViewer.addFilter(filter);
		} else {
			filteredViewer.removeFilter(filter);
		}
	}
}