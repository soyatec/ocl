/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id$
 */
package org.eclipse.ocl.examples.xtext.completeocl.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.essentialocl.serializer.EssentialOCLHiddenTokenSequencer;

public class CompleteOCLHiddenTokenSequencer extends EssentialOCLHiddenTokenSequencer
{
	@Override
	protected String getCommentIndent(EObject semanticChild) {
		return "\t";
	}
}