/**
 * <copyright>
 *
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *	Obeo - Add selection facilities
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.emf.validation.validity.ui.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;
import org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;

public class ValidityNodeCheckStateListener implements ICheckStateListener {
	private final CheckboxTreeViewer validatableTree;
	
	private final CheckboxTreeViewer constraintsTree;
	
	public ValidityNodeCheckStateListener(CheckboxTreeViewer validatableTree, CheckboxTreeViewer constraintsTree) {
		this.validatableTree = validatableTree;
		this.constraintsTree = constraintsTree;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICheckStateListener#checkStateChanged(org.eclipse.jface.viewers.CheckStateChangedEvent)
	 */
	public void checkStateChanged(CheckStateChangedEvent event) { 
		validatableTree.getTree().setRedraw(false);
		constraintsTree.getTree().setRedraw(false); 
		Object element = event.getElement();
		if (element instanceof AbstractNode) {
			AbstractNode abstractNode = (AbstractNode) element;
			boolean enabled = event.getChecked();
			updateAbstractNodeState(abstractNode, enabled);
		}
		validatableTree.getTree().setRedraw(true);
		constraintsTree.getTree().setRedraw(true); 
	}

	/**
	 * This updates:
	 * <ul>
	 * <li>
	 * the selected abstract node state,</li>
	 * <li>
	 * its own children and ancestors states,</li>
	 * <li>
	 * the corresponding children in the adjacent tree.</li>
	 * <li>
	 * the ancestors states of corresponding children in the adjacent tree.</li>
	 * </ul>
	 * 
	 * @param abstractNode
	 *            the abstract node
	 * @param enabled
	 *            true when the node is checked, false otherwise.
	 */
	private void updateAbstractNodeState(AbstractNode abstractNode,
			boolean enabled) {
		// update checked Element state
		abstractNode.setEnabled(enabled);
		
		// update results children check state
		updateChildrenNodesState(abstractNode, enabled);

		// update corresponding node in adjacent tree
		if (abstractNode instanceof ResultValidatableNode
				|| abstractNode instanceof ResultConstrainingNode) {
			propagateToAdjacentTree(abstractNode, enabled);
		}

		// update Selected Element and get parents to checks/grayed
		if (abstractNode instanceof RootValidatableNode || abstractNode instanceof RootConstrainingNode){
			updateRootNode(abstractNode, enabled);					
		} else if (abstractNode instanceof ConstrainingNode) {
			ConstrainingNode constrainingNode = (ConstrainingNode) abstractNode;
				updateConstrainingNodeAncestors(constrainingNode, enabled);
		} else if (abstractNode instanceof ValidatableNode) {
			ValidatableNode validatableNode = (ValidatableNode) abstractNode;
				updateValidatableNodeAncestors(validatableNode, enabled);
		}
	}

	/**
	 * Update the root node check state.
	 * 
	 * @param root
	 *            the root node.
	 * @param enabled
	 *            true when the node is checked, false otherwise.
	 */
	private void updateRootNode(AbstractNode root, boolean enabled) {
		if (root instanceof RootValidatableNode) {
			validatableTree.setGrayed(root, false);
			validatableTree.setChecked(root, enabled);
		} else if (root instanceof RootConstrainingNode) {
			constraintsTree.setGrayed(root, false);
			constraintsTree.setChecked(root, enabled);
		}
	}
	
	/**
	 * Select/Deselect all constraints tree ancestors states.
	 * 
	 * @param constrainingNode
	 *            the constraining node.
	 * @param enabled
	 *            true when the node is checked, false otherwise.
	 */
	private void updateConstrainingNodeAncestors(ConstrainingNode constrainingNode, boolean enabled) {
		ConstrainingNode parent = constrainingNode.getParent();
		if (parent != null) {
			//Enable/disable the parent if all children are enabled/disabled
			if (enabled && !parent.isAllChildrenDisabled() || 
					!enabled && parent.isAllChildrenEnabled() || 
					!enabled && parent.isAllChildrenDisabled()) {
				parent.setEnabled(enabled);
				constraintsTree.setChecked(parent, enabled);
			}
			if (parent.isEnabled()){
				List<AbstractNode> checkedChildren = getCheckedNodeChildren(parent);
				if (checkedChildren.size() == parent.getChildren().size()) {
					List<AbstractNode> grayedChildren = getGrayedChildren(parent);
					if (grayedChildren.size() == 0) {
						constraintsTree.setGrayed(parent, false);
					} else {
						constraintsTree.setGrayed(parent, true);
					}
				} else {
					constraintsTree.setGrayed(parent, true);
				}
			}
			updateConstrainingNodeAncestors(parent, enabled);
		}
	}
	
	/**
	 * Select/Deselect all validatable tree ancestors states.
	 * 
	 * @param validatableNode
	 *            the validatable node.
	 * @param enabled
	 *            true when the node is checked, false otherwise.
	 */
	private void updateValidatableNodeAncestors(ValidatableNode validatableNode, boolean enable) {
		ValidatableNode parent = validatableNode.getParent();
		if (parent != null) {
			//Enable/disable the parent if all children are enabled/disabled
			if (enable && !parent.isAllChildrenDisabled() || !enable && parent.isAllChildrenEnabled()){
				parent.setEnabled(enable);
				validatableTree.setChecked(parent, enable);
			} else if (!enable && parent.isAllChildrenDisabled()){
				parent.setEnabled(enable);
				validatableTree.setChecked(parent, enable);
			}
			if (parent.isEnabled()){
				List<AbstractNode> checkedChildren = getCheckedNodeChildren(parent);
				if (checkedChildren.size() == parent.getChildren().size()) {
					List<AbstractNode> grayedChildren = getGrayedChildren(parent);
					if (grayedChildren.size() == 0) {
						validatableTree.setGrayed(parent, false);
					} else {
						validatableTree.setGrayed(parent, true);
					}
				} else {
					validatableTree.setGrayed(parent, true);
				}
			}
			updateValidatableNodeAncestors(parent, enable);
		}
	}

	/**
	 * Select/Deselect all children nodes and propagates selection to
	 * grand-children nodes.
	 * 
	 * @param abstractNode
	 *            the abstract node.
	 * @param enabled
	 *            true when the node is checked, false otherwise.
	 */
	private void updateChildrenNodesState(AbstractNode abstractNode,
			boolean enabled) {
		for (AbstractNode child : abstractNode.getChildren()) {
			child.setEnabled(enabled);
			if (child instanceof ResultValidatableNode) {
				validatableTree.setChecked(child, enabled);
				validatableTree.setGrayed(child, false);
				propagateToAdjacentTree(child, enabled);
			} else if (child instanceof ValidatableNode) {
				validatableTree.setChecked(child, enabled);
				validatableTree.setGrayed(child, false);
				updateChildrenNodesState(child, enabled);
			} else if (child instanceof ResultConstrainingNode) {
				constraintsTree.setChecked(child, enabled);
				constraintsTree.setGrayed(child, false);
				propagateToAdjacentTree(child, enabled);
			} else if (child instanceof ConstrainingNode) {
				constraintsTree.setChecked(child, enabled);
				constraintsTree.setGrayed(child, false);
				updateChildrenNodesState(child, enabled);
			}
		}
	}

	/**
	 * Propagates results selection to the adjacent tree. The propagation is ascendant since the
	 * Result nodes have no children.
	 * 
	 * @param abstractNode
	 *            the abstract node.
	 * @param enabled
	 *            true when the node is checked, false otherwise.
	 */
	private void propagateToAdjacentTree(AbstractNode abstractNode,
			boolean enabled) {
		if (abstractNode instanceof ResultValidatableNode) {
			ResultConstrainingNode resultConstrainingNode = ((ResultValidatableNode) abstractNode)
					.getResultConstrainingNode();
			resultConstrainingNode.setEnabled(enabled);
			constraintsTree.setChecked(resultConstrainingNode, enabled);

			// update Element parents checks/grayed
			updateConstrainingNodeAncestors(resultConstrainingNode, enabled);
		} else if (abstractNode instanceof ResultConstrainingNode) {
			ResultValidatableNode resultValidatableNode = ((ResultConstrainingNode) abstractNode)
					.getResultValidatableNode();
			resultValidatableNode.setEnabled(enabled);
			validatableTree.setChecked(resultValidatableNode, enabled);

			// update Element parents checks/grayed
			updateValidatableNodeAncestors(resultValidatableNode, enabled);
		}
	}

	/**
	 * gets all current children check state.
	 * 
	 * @param abstractNode
	 *            the abstract node.
	 */
	private List<AbstractNode> getCheckedNodeChildren(AbstractNode node) {
		List<AbstractNode> checkedChildren = new ArrayList<AbstractNode>();
		for (AbstractNode child : node.getChildren()) {
			if (child instanceof ValidatableNode) {
				if (validatableTree.getChecked(child)) {
					checkedChildren.add(child);
				}
			} else if (child instanceof ConstrainingNode) {
				if (constraintsTree.getChecked(child)) {
					checkedChildren.add(child);
				}
			}
		}
		return checkedChildren;
	}

	/**
	 * gets all current children gray state.
	 * 
	 * @param abstractNode
	 *            the abstract node.
	 */
	private List<AbstractNode> getGrayedChildren(AbstractNode parent) {
		List<AbstractNode> grayedChildren = new ArrayList<AbstractNode>();
		for (AbstractNode child : parent.getChildren()) {
			if (validatableTree.getGrayed(child)) {
				grayedChildren.add(child);
			}
		}
		return grayedChildren;
	}
}
