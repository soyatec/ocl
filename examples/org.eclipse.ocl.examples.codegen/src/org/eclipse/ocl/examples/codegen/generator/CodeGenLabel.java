/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.generator;

import org.eclipse.jdt.annotation.NonNull;


/**
 * A CodeGenLabel is a CodeGenNode future, indirecting the requirement for a node upon which constants and
 * expressions are dependent and the node resolving that dependence. The future is needed since dependencies
 * are established during analysis, but the target is not created till the final code generation. 
 */
public interface CodeGenLabel
{ 
	void addDependency(@NonNull CodeGenSnippet cgElement);
	@NonNull CodeGenSnippet pop();
	void push(@NonNull CodeGenSnippet cgElement);
}