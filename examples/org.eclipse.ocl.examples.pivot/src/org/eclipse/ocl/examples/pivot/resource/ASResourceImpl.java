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
package org.eclipse.ocl.examples.pivot.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIidVisitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotSaveImpl;

public class ASResourceImpl extends XMIResourceImpl implements ASResource
{
	/**
	 * The ASXMIHelperImpl modifies references to unnavigable opposites to be a modified xmi:id of the navigable forward property.
	 * This ensures that when loaded, the resource identifies a resource with a loadable entity, in which the forward property can be found
	 * and its unnavigable opposite selected.
	 */
	protected static final class ASXMIHelperImpl extends XMIHelperImpl
	{
		private ASXMIHelperImpl(XMLResource resource) {
			super(resource);
		}

		@Override
		public String getHREF(EObject obj) {
			if (obj instanceof Property) {
				Property property = (Property)obj;
				if (property.isImplicit()) {
					Property oppositeProperty = property.getOpposite();
					String oppositeHREF = super.getHREF(oppositeProperty);
					return oppositeHREF.replace(AS2XMIidVisitor.FRAGMENT_SEPARATOR,  AS2XMIidVisitor.FRAGMENT_SEPARATOR + AS2XMIidVisitor.OPPOSITE_PREFIX);
				}
			}
			return super.getHREF(obj);
		}
	}

	protected final @NonNull ASResourceFactory asResourceFactory;

	/**
	 * Creates an instance of the resource.
	 */
	public ASResourceImpl(@NonNull URI uri, @NonNull ASResourceFactory asResourceFactory) {
		super(uri);
		this.asResourceFactory = asResourceFactory;
	}

	@Override
	protected XMLSave createXMLSave() {
		return new PivotSaveImpl(new ASXMIHelperImpl(this));
	}

	public @NonNull ASResourceFactory getASResourceFactory() {
		return asResourceFactory;
	}
	
	@Override
	protected EObject getEObjectByID(String id) {
		if (id.startsWith(AS2XMIidVisitor.OPPOSITE_PREFIX)) {
			EObject eObjectByID = super.getEObjectByID(id.substring(1));
			return ((Property)eObjectByID).getOpposite();
		}
		else {
			return super.getEObjectByID(id);
		}
	}

	@Override
	protected boolean useIDs() {
		return true;
	}
}
