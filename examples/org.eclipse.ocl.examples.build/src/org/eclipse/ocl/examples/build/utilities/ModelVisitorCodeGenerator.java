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
 * $Id: ModelVisitorCodeGenerator.java,v 1.4 2011/03/17 20:01:45 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.build.acceleo.GeneratePivotVisitors;
import org.eclipse.ocl.examples.xtext.oclstdlib.OCLstdlibStandaloneSetup;

/**
 * Generates the javaFolder/'javaPackageName'/javaClassName.java file providing
 * a static Java-creation of the libraryFile OCL standard library definition.
 */
public class ModelVisitorCodeGenerator extends AbstractWorkflowComponent
{
	private Logger log = Logger.getLogger(getClass());	
	private ResourceSet resourceSet = null;	
	protected String visitorClassName;
	protected String javaFolder;
	protected String visitorPackageName;
	protected String modelPackageName;
	protected String ecoreFile;

	public ModelVisitorCodeGenerator() {
		OCLstdlibStandaloneSetup.doSetup();
	}

	public void checkConfiguration(Issues issues) {
		if (ecoreFile == null) {
			issues.addError(this, "libraryFile not specified.");
		}
		if (visitorClassName == null) {
			issues.addError(this, "visitorClassName not specified.");
		}
		if (visitorPackageName == null) {
			issues.addError(this, "visitorPackageName not specified.");
		}
		if (modelPackageName == null) {
			issues.addError(this, "modelPackageName not specified.");
		}
		if (ecoreFile == null) {
			issues.addError(this, "ecoreFile not specified.");
		}
	}

	public @NonNull ResourceSet getResourceSet() {
		ResourceSet resourceSet2 = resourceSet;
		if (resourceSet2 == null) {
			resourceSet = resourceSet2 = new ResourceSetImpl();
		}
		return resourceSet2;
	}

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues issues) {
		URI fileURI = URI.createPlatformResourceURI(ecoreFile, true);
		File outputFolder = new File(javaFolder + '/' + visitorPackageName.replace('.', '/'));
		log.info("Loading Ecore Model '" + fileURI);
		
		try {
			ResourceSet resourceSet = getResourceSet();
			Resource ecoreResource = resourceSet.getResource(fileURI, true);
			List<Object> arguments = new ArrayList<Object>();
			arguments.add(visitorPackageName);
			arguments.add(modelPackageName);
			arguments.add(visitorClassName);
			arguments.add("");
			arguments.add("");
			arguments.add(ecoreFile);
			EObject ecoreModel = ecoreResource.getContents().get(0);
			GeneratePivotVisitors acceleo = new GeneratePivotVisitors(ecoreModel, outputFolder, arguments);
			log.info("Generating to ' " + outputFolder + "'");
			EMF2MWEMonitorAdapter monitor = new EMF2MWEMonitorAdapter(arg1);
			acceleo.generate(monitor);
		} catch (IOException e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	public void setVisitorClassName(String visitorClassName) {
		this.visitorClassName = visitorClassName;
	}

	public void setJavaFolder(String javaFolder) {
		this.javaFolder = javaFolder;
	}

	public void setVisitorPackageName(String javaPackageName) {
		this.visitorPackageName = javaPackageName;
	}

	public void setModelPackageName(String modelPackageName) {
		this.modelPackageName = modelPackageName;
	}

	public void setEcoreFile(String ecoreFile) {
		this.ecoreFile = ecoreFile;
	}
	
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
}
