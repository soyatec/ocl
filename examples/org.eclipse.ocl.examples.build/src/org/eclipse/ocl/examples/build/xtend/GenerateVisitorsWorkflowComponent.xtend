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
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - bug397429
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
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.mwe.core.WorkflowContext
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor
import org.eclipse.jdt.annotation.NonNull
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil

public abstract class GenerateVisitorsWorkflowComponent extends AbstractWorkflowComponent
{
	private Logger log = Logger.getLogger(getClass());	
	private static final String EMPTY_STRING = "";

	protected ResourceSet resourceSet = null;
	protected String projectName;
	protected String projectPrefix;
	protected String modelPackageName;
	protected String visitorPackageName;
	protected String visitorClassName;
	protected String visitablePackageName;
	protected String visitableClassName;
	protected String javaFolder = "emf-gen";
	protected String genModelFile;

	protected String superProjectName;
	protected String superProjectPrefix;
	protected String superVisitorClassName;
	protected String superVisitorPackageName;
	protected String sourceFile;
	protected String copyright;
	protected String outputFolder;

	override checkConfiguration(Issues issues) {
		if (!isDefined(projectName)) {
			issues.addError(this, "projectName not specified.");
		}
		if (!isDefined(projectPrefix)) {
			issues.addError(this, "projectPrefix not specified.");
		}
		if (!isDefined(modelPackageName)) {
			issues.addError(this, "modelPackageName not specified.");
		}
		if (!isDefined(visitorPackageName)) {
			issues.addError(this, "visitorPackageName not specified.");
		}
		if (!isDefined(visitorClassName)) {
			issues.addError(this, "visitorClassName not specified.");
		}
		if (!isDefined(visitableClassName)) {
			issues.addError(this, "visitableClassName not specified.");
		}
		if (!isDefined(genModelFile)) {
			issues.addError(this, "genModelFile not specified.");
		}
		if (!isDefined(superProjectName)) {
			issues.addError(this, "superProjectName not specified (use \"\" for a base visitor).");
		}
		else if (isDerived()) {
			if (!isDefined(superProjectPrefix)) {
				issues.addError(this, "superProjectPrefix not specified.");
			}
			if (!isDefined(superVisitorPackageName)) {
				issues.addError(this, "superVisitorPackageName not specified.");
			}
			if (!isDefined(superVisitorClassName)) {
				issues.addError(this, "superVisitorClassName not specified.");
			}
		}
	}

	abstract def void generateVisitors(@NonNull GenPackage genPackage);

	private def String getCopyright(Resource genModelResource) {
		var GenModel genModel = genModelResource.getContents().get(0) as GenModel;
		var String copyright = genModel.getCopyright("");
		return if(copyright == null) EMPTY_STRING else copyright;
	}

	private def GenPackage getGenPackage(Resource genModelResource) {
		var GenModel genModel = genModelResource.getContents().get(0) as GenModel;
		var List<GenPackage> genPackages = genModel.getAllGenPackagesWithConcreteClasses();
		return if (genPackages.isEmpty())
			null
		else
			genPackages.get(0); // We assume we want the first one;
	}
	
	@NonNull 
	private def GenModel getGenModel(@NonNull Resource genModelResource) {
		var EList<EObject> contents = genModelResource.getContents();
		if (contents.isEmpty()) {
			throw new IllegalArgumentException("Illegal empty genModelResource: " + genModelResource.getURI())
		}
		var EObject rootElement = contents.get(0);
		if (!(rootElement instanceof GenModel)) { 
			throw new IllegalArgumentException("Illegal non GenModel root element: " + genModelResource.getURI())
		}
		return rootElement as GenModel;
	}
	
/* 	private def void registerGenModel(@NonNull GenModel genModel, @NonNull EPackage ePackage) {
		var MetaModelManager mManager = MetaModelManager.getAdapter(resourceSet);
		// var MetaModelManager mManager = PivotUtil.getMetaModelManager(ePackage.eResource());
		mManager.addGenModel(genModel);
		for (GenPackage usedGenPackage : genModel.getUsedGenPackages()) {
			mManager.addGenPackage(usedGenPackage);
		}
	} */

	override protected invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		if (!isDefined(visitablePackageName)) {
			visitablePackageName = visitorPackageName;
		}
		if (!isDefined(superVisitorPackageName)) {
			superVisitorPackageName = visitorPackageName;
		}
		if (!isDerived()) {
			superProjectPrefix = "";
			superVisitorPackageName = "";
			superVisitorClassName = "";
		}
		doSetup();
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
			var GenPackage genPackage = getGenPackage(genModelResource);
//			var GenModel genModel = getGenModel(genModelResource);
//			var EPackage targetEPackage = getEPackage(genModelResource);
//			registerGenModel(genModel, targetEPackage);
			copyright = getCopyright(genModelResource);
			sourceFile = genModelFile;
			generateVisitors(genPackage);
		} catch (IOException e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	/**
	 * It gives a chance to derived components to do some setup subprocess, prior to
	 * start with the component generation process
	 * 
	 * derived components may override
	 */
	protected def void doSetup() {
		// Do nothing by
	}
	
	protected static def boolean isDefined(String string) {
		return (string != null); // && (string.length() > 0);
	}

	protected def boolean isDerived() {
		return superProjectName.length() > 0;
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
	 * (Optional) The folder within the project that forms the root of EMF generated sources. (default is "emf-gen")
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
	 * The name prefix of the EMF generated infrasdtructure classes. (e.g. "Project")
	 */
	// FIXME this is 100% deriveable from the genmodel.
	public def void setProjectPrefix(String projectPrefix) {
		this.projectPrefix = projectPrefix;
	}

	/**
	 * An optional ResourceSet that MWE components may share to reduce model loading. 
	 */
	public def void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	/**
	 * The project name that is extended by the project containing the genmodel and generated EMF sources. (e.g. "org.my.superproject").
	 * Must be null or "" if there is no super project to extend.
	 */
	public def void setSuperProjectName(String superProjectName) {
		this.superProjectName = superProjectName;
	}

	/**
	 * The name prefix of the project that is extended by the project containing the genmodel and generated EMF sources. (e.g. "SuperProject").
	 * The value is ignored if the superProjectName is "".
	 */
	public def void setSuperProjectPrefix(String superProjectPrefix) {
		this.superProjectPrefix = superProjectPrefix;
	}
	
	/**
	 * The class name for the extended Visitor interface. (e.g. "SuperVisitor").
	 * The value is ignored if the superProjectName is "".
	 */
	public def void setSuperVisitorClassName(String superVisitorClassName) {
		this.superVisitorClassName = superVisitorClassName;
	}
	
	/**
	 * The package name for the extended Visitor interface. (e.g. "org.my.superproject.util").
	 * The value is ignored if the superProjectName is "".
	 */
	public def void setSuperVisitorPackageName(String superVisitorPackageName) {
		this.superVisitorPackageName = superVisitorPackageName;
	}

	/**
	 * The class name for the referenced Visitable interface. (e.g. "Visitable")
	 */
	public def void setVisitableClassName(String visitableClassName) {
		this.visitableClassName = visitableClassName;
	}

	/**
	 * The package name for the referenced Visitable interface. (e.g. "org.my.project.util")
	 * If unspecified the visitorPackageName is used.
	 */
	public def void setVisitablePackageName(String visitablePackageName) {
		this.visitablePackageName = visitablePackageName;
	}

	/**
	 * The required class name for the generated Visitor interface. (e.g. "Visitor")
	 */
	public def void setVisitorClassName(String visitorClassName) {
		this.visitorClassName = visitorClassName;
	}

	/**
	 * The required package name for the generated Visitor interface. (e.g. "org.my.project.util")
	 */
	public def void setVisitorPackageName(String visitorPackageName) {
		this.visitorPackageName = visitorPackageName;
	}
}
