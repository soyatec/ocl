/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.build.xtend

import java.io.IOException
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.mwe.core.WorkflowContext
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor

public abstract class GenerateVisitorsWorkflowComponent extends AbstractWorkflowComponent
{
	protected Logger log = Logger.getLogger(getClass());	
	private static final String EMPTY_STRING = "";

	protected ResourceSet resourceSet = null;
	protected String projectName;
	protected String modelPackageName;
	protected String visitorPackageName;
	protected String visitorClassName;
	protected String visitablePackageName;
	protected String visitableClassName;
	protected String javaFolder;
	protected String genModelFile;
	
	protected String superVisitorClassName = "";
	protected String superVisitorPackageName = "";
	protected String sourceFile = "";
	protected String copyright = "";
	protected String outputFolder = "";

	override checkConfiguration(Issues issues) {
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

	abstract def void generateVisitors(EPackage ePackage);

	private def String getCopyright(Resource genModelResource) {
		var GenModel genModel = genModelResource.getContents().get(0) as GenModel;
		var String copyright = genModel.getCopyright("");
		return if(copyright == null) EMPTY_STRING else copyright;
	}

	private def EPackage getEPackage(Resource genModelResource) {
		var GenModel genModel = genModelResource.getContents().get(0) as GenModel;
		var List<GenPackage> genPackages = genModel.getAllGenPackagesWithConcreteClasses();
		return if (genPackages.isEmpty())
			null
		else
			genPackages.get(0).getEcorePackage(); // We assume we want the first one;
	}

	override protected invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		if (visitablePackageName == null) {
			visitablePackageName = visitorPackageName;
		}
		if (superVisitorPackageName == null) {
			superVisitorPackageName = visitorPackageName;
		}
		var URI projectFileURI = EcorePlugin.platformResourceMap.get(projectName);
		var URI projectResourceURI = URI.createPlatformResourceURI("/" + projectName + "/", true);
		var URI genModelURI = URI.createURI(genModelFile).resolve(projectResourceURI);
		var URI outputURI = URI.createURI(javaFolder + '/' + visitorPackageName.replace('.', '/'));
		var URI resolvedOutputURI = outputURI.resolve(projectFileURI);
		outputFolder = resolvedOutputURI.toString() + "/";
		if (outputFolder.startsWith("file:/")) {
			outputFolder = outputFolder.substring(6);
		}

		log.info("Loading GenModel '" + genModelURI);
		try {
			var Resource genModelResource = resourceSet.getResource(genModelURI, true);
			var EPackage targetEPackage = getEPackage(genModelResource);
			copyright = getCopyright(genModelResource);
			sourceFile = genModelFile;
			generateVisitors(targetEPackage);
		} catch (IOException e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	/**
	 * The path within the project to the genmodel file that identifies the Ecore file
	 * from which the EMF generated interfaces derive. Also provides the copyright for
	 * generated Visitor interfaces. (e.g. "model/my.genmodel")
	 */
	public def void setGenModelFile(String genModelFile) {
		this.genModelFile = genModelFile;
	}

	/**
	 * The folder within the project that forms the root of EMF generated sources. (e.g. "src" or "emf-gen")
	 */
	// FIXME this is 100% deriveable from the genmodel.
	public def void setJavaFolder(String javaFolder) {
		this.javaFolder = javaFolder;
	}

	/**
	 * The package name of the EMF generated interfaces. (e.g. "org.my.project")
	 */
	// FIXME this is 100% deriveable from the genmodel.
	public def void setModelPackageName(String modelPackageName) {
		this.modelPackageName = modelPackageName;
	}

	/**
	 * The project name containing the genmodel and generated EMF sources. (e.g. "org.my.project")
	 */
	public def void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * An optional ResourceSet that MWE components may share to reduce model loading. 
	 */
	public def void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
	
	public def void setSuperVisitorClassName(String superVisitorClassName) {
		this.superVisitorClassName = superVisitorClassName;
	}
	
	public def void setSuperVisitorPackageName(String superVisitorPackageName) {
		this.superVisitorPackageName = superVisitorPackageName;
	}

	/**
	 * The class name for the referenced Visitable interface. (e.g. "Visitable")
	 */
	// FIXME this could have Visitable as a default.
	public def void setVisitableClassName(String visitableClassName) {
		this.visitableClassName = visitableClassName;
	}

	/**
	 * The package name for the referenced Visitable interface. (e.g. "org.my.project.util")
	 * If unspecified the visitorPackageName is used.
	 */
	// FIXME this could have the util package as a default.
	public def void setVisitablePackageName(String visitablePackageName) {
		this.visitablePackageName = visitablePackageName;
	}

	/**
	 * The required class name for the generated Visitor interface. (e.g. "Visitor")
	 */
	// FIXME this could have Visitor as a default.
	public def void setVisitorClassName(String visitorClassName) {
		this.visitorClassName = visitorClassName;
	}

	/**
	 * The required package name for the generated Visitor interface. (e.g. "org.my.project.util")
	 */
	// FIXME this could have the util package as a default.
	public def void setVisitorPackageName(String visitorPackageName) {
		this.visitorPackageName = visitorPackageName;
	}
}
