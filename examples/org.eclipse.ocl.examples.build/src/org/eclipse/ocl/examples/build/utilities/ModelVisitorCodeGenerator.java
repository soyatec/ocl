/**
 * <copyright>
 *
 * Copyright (c) 2010,2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.build.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.build.acceleo.GeneratePivotVisitors;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IProjectDescriptor;

/**
 * Invokes an Acceleo template specified in createAcceleoGenerator to generate a selection
 * of Visitor interfaces and abstract implementations.
 * <p>
 * An MWE2 script invokes this Workflow Component with appropriate configuration, then
 * the invoked Acceleo template invokes the selected Visitor generators typically by
 * passing parameters through to the genweric generateVisitors.mtl. 
 */
public class ModelVisitorCodeGenerator extends AbstractWorkflowComponent
{
	private static final String EMPTY_STRING = "";
	private Logger log = Logger.getLogger(getClass());	
	private ResourceSet resourceSet = null;
	private String projectName;
	private String modelPackageName;
	private String visitorPackageName;
	private String visitorClassName;
	private String visitablePackageName;
	private String visitableClassName;
	private String javaFolder;	
	private String genModelFile;

	public void checkConfiguration(Issues issues) {
		if (modelPackageName == null) {
			issues.addError(this, "modelPackageName not specified.");
		}
		if (visitorPackageName == null) {
			issues.addError(this, "visitorPackageName not specified.");
		}
		if (visitorClassName == null) {
			issues.addError(this, "visitorClassName not specified.");
		}
		if (visitableClassName == null) {
			issues.addError(this, "visitableClassName not specified.");
		}
		if (genModelFile == null) {
			issues.addError(this, "genModelFile not specified.");
		}
	}


	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues issues) {
		ResourceSet resourceSet = getResourceSet();
		StandaloneProjectMap projectMap = StandaloneProjectMap.getAdapter(resourceSet);
		IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(getProjectName());
		URI genModelURI = projectDescriptor.getPlatformResourceURI(getGenModelFile());
		File outputFolder = projectDescriptor.getLocationFile(getJavaFolder() + '/' + getVisitorPackageName().replace('.', '/'));
		log.info("Loading Pivot Model '" + genModelURI);
		
		try {
			Resource genModelResource = resourceSet.getResource(genModelURI, true);
			EPackage targetEPackage = getEPackage(genModelResource);
			String copyright = getCopyright(genModelResource);
			
			List<Object> arguments = new ArrayList<Object>();
			arguments.add(getModelPackageName());
			arguments.add(getVisitorPackageName());
			arguments.add(getVisitorClassName());			
			arguments.add(getSuperVisitorPackageName() == null ? getVisitorPackageName() : getSuperVisitorPackageName());
			arguments.add(getSuperVisitorClassName());
			arguments.add(getVisitablePackageName() == null ? getVisitorPackageName() : getVisitablePackageName()); // If null, we use the visitorPackageName
			arguments.add(getVisitableClassName());
			arguments.add(getGenModelFile());
			arguments.add(copyright);

			AbstractAcceleoGenerator acceleo = createAcceleoGenerator(targetEPackage, outputFolder, arguments);
			log.info("Generating to '" + outputFolder + "'");
			EMF2MWEMonitorAdapter monitor = new EMF2MWEMonitorAdapter(arg1);
			acceleo.generate(monitor);
		} catch (IOException e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	/**
	 * The project name containing the genmodel and generated EMF sources. (e.g. "org.my.project")
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	/**
	 * The required class name for the generated Visitor interface. (e.g. "Visitor")
	 */
	// FIXME this could have Visitor as a default.
	public void setVisitorClassName(String visitorClassName) {
		this.visitorClassName = visitorClassName;
	}
	
	/**
	 * The class name for the referenced Visitable interface. (e.g. "Visitable")
	 */
	// FIXME this could have Visitable as a default.
	public void setVisitableClassName(String visitableClassName) {
		this.visitableClassName = visitableClassName;
	}

	/**
	 * The folder within the project that forms the root of EMF generated sources. (e.g. "src" or "emf-gen")
	 */
	// FIXME this is 100% deriveable from the genmodel.
	public void setJavaFolder(String javaFolder) {
		this.javaFolder = javaFolder;
	}

	/**
	 * The required package name for the generated Visitor interface. (e.g. "org.my.project.util")
	 */
	// FIXME this could have the util package as a default.
	public void setVisitorPackageName(String visitorPackageName) {
		this.visitorPackageName = visitorPackageName;
	}
	
	/**
	 * The package name for the referenced Visitable interface. (e.g. "org.my.project.util")
	 * If unspecified the visitorPackageName is used.
	 */
	// FIXME this could have the util package as a default.
	public void setVisitablePackageName(String visitablePackageName) {
		this.visitablePackageName = visitablePackageName;
	}

	/**
	 * The package name of the EMF generated interfaces. (e.g. "org.my.project")
	 */
	// FIXME this is 100% deriveable from the genmodel.
	public void setModelPackageName(String modelPackageName) {
		this.modelPackageName = modelPackageName;
	}

	/**
	 * The path within the project to the genmodel file that identifies the Ecore file
	 * from which the EMF generated interfaces derive. Also provides the copyright for
	 * generated Visitor interfaces. (e.g. "model/my.genmodel")
	 */
	public void setGenModelFile(String genModelFile) {
		this.genModelFile = genModelFile;
	}
	
	/**
	 * An optional ResourceSet that MWE components may share to reduce model loading. 
	 */
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public @NonNull ResourceSet getResourceSet() {
		ResourceSet resourceSet2 = resourceSet;
		if (resourceSet2 == null) {
			resourceSet = resourceSet2 = new ResourceSetImpl();
		}
		return resourceSet2;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public String getModelPackageName() {
		return modelPackageName;
	}
	
	public String getVisitorPackageName() {
		return visitorPackageName;
	}
	
	public String getVisitorClassName() {
		return visitorClassName;
	}
	
	public String getVisitablePackageName() {
		return visitablePackageName;
	}
	
	public String getVisitableClassName() {
		return visitableClassName;
	}

	public String getJavaFolder() {
		return javaFolder;
	}

	public String getGenModelFile() {
		return genModelFile;
	}
	
	protected String getSuperVisitorPackageName() {
		return EMPTY_STRING;
	}
	
	protected String getSuperVisitorClassName() {
		return EMPTY_STRING;
	}

	protected AbstractAcceleoGenerator createAcceleoGenerator(EObject ecoreModel,
			File outputFolder, List<Object> arguments) throws IOException {
		return new GeneratePivotVisitors(ecoreModel, outputFolder, arguments);
	}
	
	private EPackage getEPackage(Resource genModelResource) {
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
		List<GenPackage> genPackages = genModel.getAllGenPackagesWithConcreteClasses();
		return genPackages.isEmpty()
			 ?  null
			 : genPackages.get(0).getEcorePackage(); // We assume we want the first one;
	}
	
	private String getCopyright(Resource genModelResource) {
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
		String copyright = genModel.getCopyright("");
		return copyright == null ? EMPTY_STRING : copyright;
	}
}