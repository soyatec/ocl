package org.eclipse.ocl.examples.uml25;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.resource.CMOF2UMLResourceHandler;

public class CMOF252UMLResourceHandler extends CMOF2UMLResourceHandler
{
	public CMOF252UMLResourceHandler(XMLResource.ResourceHandler delegate) {
		super(delegate);
	}

	@Override
	protected Profile getEcoreProfile(EObject eObject) {
		return null;
	}

	@Override
	protected Stereotype getEcoreStereotype(EObject eObject, String name) {
		return null;
	}

}
