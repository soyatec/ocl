/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
 * $Id: SingleContinuation.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2as;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;

public abstract class SingleContinuation<T extends EObject> extends BasicContinuation<T>
{
	public SingleContinuation(@NonNull CS2PivotConversion context, Element pivotParent, EStructuralFeature pivotFeature,
			@NonNull T csElement, Dependency... dependencies) {
		super(context, pivotParent, pivotFeature, csElement, dependencies);
	}
	
	public SingleContinuation(@NonNull CS2PivotConversion context, Element pivotParent, EStructuralFeature pivotFeature,
			@NonNull T csElement, @NonNull List<Dependency> dependencies) {
		super(context, pivotParent, pivotFeature, csElement, dependencies.toArray(new Dependency[dependencies.size()]));
	}
}