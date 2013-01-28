/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: VisitableAcceptGenerator.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.extenders.utilities;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 *
 *@deprecated OCLExtenderVisitorPatternWeaverComponent does already do this work
 *
 */
public class OCLExtenderVisitableAcceptGenerator extends AbstractWorkflowComponent
{
	private Logger log = Logger.getLogger(getClass());	

	private ResourceSet rSet;
	
	private String targetEcoreFile;
	
	private String visitorEcoreFile;
	
	private String baseVisitorInterfaceName;
	
	private String derivedVisitorInterfaceName;
	
	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		
		assert(targetEcoreFile != null);
		
		ResourceSet rSet = getResourceSet();
		URI targetEcoreFileURI = URI.createPlatformResourceURI(getTargetEcoreFile(), true);
		URI visitorEcoreFileURI = URI.createPlatformResourceURI(getVisitorEcoreFile(), true);
		Resource targetResource = rSet.getResource(targetEcoreFileURI, true);
		Resource visitorResource = rSet.getResource(visitorEcoreFileURI, true);
		
		
		log.info("Inserting Visitable.accept in '" + targetResource.getURI() + "'");
		EClassifier visitorClass = findClassifier(visitorResource.getContents(), getBaseVisitorInterfaceName());
		if (visitorClass != null) {
			processPackages(targetResource.getContents(), visitorClass);
		}
		else {
			log.error("No Visitor class found in '" + targetResource.getURI() + "'");
		}
	}

	protected EClassifier findClassifier(List<? extends EObject> eContents, String string) {
		for (EObject eContent : eContents) {
			if (eContent instanceof EPackage) {
				EPackage ePackage = (EPackage) eContent;
				for (EClassifier eClassifier : ePackage.getEClassifiers()) {
					if (string.equals(eClassifier.getName())) {
						return eClassifier;
					}
				}
				EClassifier eClassifier = findClassifier(ePackage.getESubpackages(), string);
				if (eClassifier != null) {
					return eClassifier;
				}
			}
		}
		return null;
	}
	
	

	protected void processPackages(List<? extends EObject> eContents, EClassifier visitorClass) {
		for (EObject eContent : eContents) {
			if (eContent instanceof EPackage) {
				EPackage ePackage = (EPackage) eContent;
				for (EClassifier eClassifier : ePackage.getEClassifiers()) {
					if (eClassifier instanceof EClass) {
						EClass eClass = (EClass) eClassifier;
						if (!eClass.isAbstract() && !eClass.isInterface()) {
							processClass(eClass, visitorClass);
						}
					}
				}
				processPackages(ePackage.getESubpackages(), visitorClass);
			}
		}
	}

	protected void processClass(EClass eClass, EClassifier visitorClass) {
		EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
		eOperation.setName("accept");
		ETypeParameter eTypeParameter1 = EcoreFactory.eINSTANCE.createETypeParameter();
		eTypeParameter1.setName("R");
		eOperation.getETypeParameters().add(eTypeParameter1);
		EGenericType eGenericReturnType = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericReturnType.setETypeParameter(eTypeParameter1);
		eOperation.setEGenericType(eGenericReturnType);
		EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
		eParameter.setName("v");
		EGenericType eGenericParameterType = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericParameterType.setEClassifier(visitorClass);
		EGenericType eGenericArgument1 = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericArgument1.setETypeParameter(eTypeParameter1);
		eGenericParameterType.getETypeArguments().add(eGenericArgument1);
		eParameter.setEGenericType(eGenericParameterType);
		eOperation.getEParameters().add(eParameter);
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eAnnotation.setSource("http://www.eclipse.org/emf/2002/GenModel");		// FIXME find constant
		String bodyValue = getBaseVisitorInterfaceName() == getDerivedVisitorInterfaceName() 
				? "return v.visit" + eClass.getName() + "(this);"
				: "return ((" + getDerivedVisitorInterfaceName() + "<R>)v).visit" + eClass.getName() + "(this);";
		eAnnotation.getDetails().put("body", bodyValue);
		eOperation.getEAnnotations().add(eAnnotation);
		eClass.getEOperations().add(eOperation);	
	}
	
	public void setResourceSet(ResourceSet rSet) {
		this.rSet = rSet;
	}
	
	public ResourceSet getResourceSet() {
		if (rSet == null) {
			rSet = new ResourceSetImpl();
		}
		return rSet;
	}
	
	public void setTargetEcoreFile(String targetEcoreFile) {
		this.targetEcoreFile = targetEcoreFile;
	}
	
	public String getTargetEcoreFile() {
		return targetEcoreFile;
	}
	
	public void setVisitorEcoreFile(String visitorEcoreFile) {
		this.visitorEcoreFile = visitorEcoreFile;
	}
	
	public String getVisitorEcoreFile() {
		return visitorEcoreFile;
	}
	
	public void setBaseVisitorInterfaceName(String baseVisitorInterfaceName) {
		this.baseVisitorInterfaceName = baseVisitorInterfaceName;
	}
	
	public String getBaseVisitorInterfaceName() {
		if (baseVisitorInterfaceName == null) {
			baseVisitorInterfaceName = "Visitor"; // default value
		}
		return baseVisitorInterfaceName;
	}
	
	public String getDerivedVisitorInterfaceName() {
		if (derivedVisitorInterfaceName == null) {
			derivedVisitorInterfaceName = getBaseVisitorInterfaceName();
		}
		return derivedVisitorInterfaceName;
	}
	
	public void setDerivedVisitorInterfaceName(String derivedVisitorInterfaceName) {
		this.derivedVisitorInterfaceName = derivedVisitorInterfaceName;
	}	
	
	public void checkConfiguration(Issues issues) {
		
		if (targetEcoreFile == null) {
			issues.addError(this, "Target ecore file not specified.");
		}
		
		if (visitorEcoreFile == null) {
			issues.addError(this, "Visitor ecore file not specified.");
		}		
	}
}
