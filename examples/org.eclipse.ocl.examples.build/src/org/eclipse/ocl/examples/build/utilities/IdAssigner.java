/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
 * $Id: GenmodelReloader.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Assigns simple package/type/type-name xmi:ids to Packages, Types, Properties that do not already have them.
 */
public class IdAssigner extends AbstractProjectComponent
{
	protected Logger log = Logger.getLogger(getClass());	
	protected String uri;								// URI of the model with ids

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (uri == null) {
			issues.addError(this, "uri not specified.");
		}
	}

	public String getUri() {
		return uri;
	}

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		URI umlURI = URI.createPlatformResourceURI(uri, true);
		Resource cmofResource = (Resource) ctx.get(getModelSlot());
		log.info("Assigning Ids from '" + cmofResource.getURI() + "'to '" + umlURI + "'");
		UMLResource umlResource = (UMLResource) getResourceSet().createResource(umlURI);
		umlResource.getContents().addAll(cmofResource.getContents());
		for (TreeIterator<EObject> tit = umlResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if ((eObject instanceof org.eclipse.uml2.uml.Package) || (eObject instanceof Type)) {
				NamedElement namedElement = (NamedElement) eObject;
				umlResource.setID(eObject, namedElement.getName());
			}
			else if (eObject instanceof Property) {
				Property property = (Property) eObject;
				Type type = property.getClass_();
				if (type != null) {
					String id = umlResource.getID(eObject);
					if ((id == null) || !id.startsWith(type.getName())) {	// If it starts with type it may be a good name
						umlResource.setID(eObject, type.getName() + "-" + property.getName());
					}
				}
			}
		}
		ctx.set(getModelSlot(), umlResource);
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	protected Map<?, ?> getGenModelSaveOptions() {
		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		result.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));
		result.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		return result;
	}
}
