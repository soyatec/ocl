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
package org.eclipse.ocl.examples.build.utilities;


public abstract class PredefinedQVToTransformationExecutor extends QVToTransformationExecutor {

	
	/**
	 * @deprecated calling this method will throw {@link IllegalAccessException} since
	 * {@link PredefinedQVToTransformationExecutor} components should not allow setting a new
	 * transformation uri. Such a URI is already defined by the own component
	 */
	@Override
	@Deprecated
	public void setUri(String uri) {
		throw new IllegalArgumentException("Predefined QVTo transformations components shall not receive a new transformation URI");
	}
	
	@Override
	public final String getUri() {
		return getPredefinedTransformationURI();
	}
	
	/**
	 * @return the predefined transformation URI for this component
	 */
	abstract protected String getPredefinedTransformationURI();
	
}
