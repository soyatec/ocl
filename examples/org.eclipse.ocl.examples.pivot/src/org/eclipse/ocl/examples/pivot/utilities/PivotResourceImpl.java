/**
 * <copyright>
 *
 * Copyright (c) 2010, 2011 E.D.Willink and others.
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
 * $Id: PivotResourceImpl.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.utilities.PivotSaver.LocateVisitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotSaver.ResolveVisitor;

public class PivotResourceImpl extends AbstractASResourceImpl
{
	private Resource adaptedResource = null;
	
	/**
	 * Creates an instance of the resource.
	 */
	public PivotResourceImpl(URI uri) {
		super(uri);
	}

	public @NonNull AS2IDVisitor createIDVisitor(@NonNull AS2ID as2id) {
		return new AS2IDVisitor(as2id);
	}

	public @NonNull LocateVisitor createLocateVisitor(@NonNull AbstractPivotSaver saver) {
		return new LocateVisitor(saver);
	}
	
	public @NonNull Pivot2MonikerVisitor createMonikerVisitor(@NonNull Abstract2Moniker pivot2moniker) {
		return new Pivot2MonikerVisitor(pivot2moniker);
	}

	public @NonNull ResolveVisitor createResolveVisitor(@NonNull AbstractPivotSaver saver) {
		return new ResolveVisitor(saver);
	}

	@Override
	public void load(Map<?, ?> options) throws IOException {
		try {
			super.load(options);
		} catch (IOException e) {
			URI trimmedURI1 = uri.trimFileExtension();
			URI trimmedURI2 = trimmedURI1.trimFileExtension();
			if (trimmedURI1 != trimmedURI2) {
				adaptedResource = resourceSet.createResource(trimmedURI1);
				adaptedResource.load(options);
			}
			else {
				throw e;
			}
		}
	}
}
