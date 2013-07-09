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
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.mwe.core.WorkflowContext
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IProjectDescriptor
import org.apache.log4j.Logger

public abstract class GenerateVisitorsWorkflowComponent extends AbstractWorkflowComponent
{
	private Logger log = Logger.getLogger(getClass());	
	private static final String EMPTY_STRING = "";

	private ResourceSet resourceSet = null;
	private String projectPrefix;	
	private String superProjectPrefix;
	private String projectName;
	private String superProjectName;
	private String modelPackageName;
	private String superModelPackageName;
	private String visitorPackageName;
	private String visitorClassName;
	private String visitablePackageName;
	private String visitableClassName;
	private String javaFolder;
	private String genModelFile;
	private String superVisitorClassName;
	private String superVisitorPackageName;
	
	private String sourceFile = "";
	private String copyright = "";
	private String outputFolder = "";

	override checkConfiguration(Issues issues) {
		if (projectName == null ) {
			issues.addError(this, "projectName not specified.");
		}
		if (projectPrefix == null) {
			issues.addError(this, "languageName not specified.");
		}
		if (superProjectName != null && superProjectPrefix == null) {
			issues.addError(this, "If you provide a superProjectName for an extended language, you must provide superProjectPrefix.");
		}
		if (superProjectName == null && superProjectPrefix != null) {
			issues.addError(this, "If you don't provide a superProjectName, providing a superProjectPrefix for an extended language is not expected.");
		}
		if (superVisitorClassName != null  && superVisitorPackageName == null ) {
			issues.addError(this, "If you provide a superVisitorClassName for the extended language, you must provide a superVisitorPackageName as well.");
		}
		if (superVisitorClassName == null && superVisitorPackageName != null) {
			issues.addError(this, "If you don't provide a superVisitorClassName, providing a superVisitorPackageName for an extended language is not expected.");
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
		var ResourceSet resourceSet = getResourceSet;	
		var StandaloneProjectMap projectMap = StandaloneProjectMap.getAdapter(resourceSet);
		var IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(getProjectName);
		var URI genModelURI = projectDescriptor.getPlatformResourceURI(getGenModelFile);
		outputFolder = projectDescriptor.getLocationFile(
			getJavaFolder + '/' + getVisitorPackageName.replace('.', '/')).toString() + "/";

		log.info("Loading Pivot Model '" + genModelURI);
		try {
			var Resource genModelResource = resourceSet.getResource(genModelURI, true);
			var EPackage targetEPackage = getEPackage(genModelResource);
			copyright = getCopyright(genModelResource);
			sourceFile = getGenModelFile;
			generateVisitors(targetEPackage);
		} catch (IOException e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	/**
	 * The optional path within the project to the genmodel file that identifies the Ecore file
	 * from which the EMF generated interfaces derive. Also provides the copyright for
	 * generated Visitor interfaces. (e.g. "model/my.genmodel")
	 * <p>
	 * If not provided <code>"model/"+getProjectPrefix+".genmodel"<code> will be used.
	 * </p>
	 */
	public def void setGenModelFile(String genModelFile) {
		this.genModelFile = genModelFile;
	}

	/**
	 * The folder within the project that forms the root of EMF generated sources. (e.g. "src" or "emf-gen")
	 * 
	 * <p>
	 * If not provided <code>"src"<code> will be used.
	 * </p>
	 */
	public def void setJavaFolder(String javaFolder) {
		this.javaFolder = javaFolder;
	}

	/**
	 * The optional package name of the EMF generated interfaces. (e.g. "org.my.project")
	 * <p>
	 * If not provided <code>getProjectName+"."+getProjectPrefix.toLowerCase<code> will be used.
	 * </p>
	 */
	public def void setModelPackageName(String modelPackageName) {
		this.modelPackageName = modelPackageName;
	}
	
	/**
	 * The optional package name of the EMF generated interfaces of extended language. (e.g. "org.my.extendedproject")
	 * <p>
	 * If not provided <code>getSuperProjectName+"."+getSuperProjectPrefix.toLowerCase<code> will be used.
	 * </p>
	 */
	public def void setSuperModelPackageName(String superModelPackageName) {
		this.superModelPackageName = superModelPackageName;
	}

	/**
	 * The mandatory project name containing the genmodel and generated EMF sources. (e.g. "org.my.project")
	 */
	public def void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	/**
	 * The mandatory project name containing the genmodel and generated EMF sources of the extended language. (e.g. "org.my.extendedproject")
	 */
	public def void setSuperProjectName(String superProjectName) {
		this.superProjectName = superProjectName;
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
	 * The optional class name for the referenced Visitable interface. (e.g. "Visitable")
	 * <p>
	 * If not provided <code>getProjectPrefix.toFirstUpper + "Visitable"<code> will be used.
	 * </p>
	 */
	public def void setVisitableClassName(String visitableClassName) {
		this.visitableClassName = visitableClassName;
	}

	/**
	 * The package name for the referenced Visitable interface. (e.g. "org.my.project.util")
	 * <p>
	 * If not provided <code>visitorPackageName<code> will be used.
	 * </p>
	 */
	public def void setVisitablePackageName(String visitablePackageName) {
		this.visitablePackageName = visitablePackageName;
	}

	/**
	 * The optional class name for the generated Visitor interface. (e.g. "Visitor").
	 * <p>
	 * If not provided <code>getProjectPrefix.toFirstUpper + "Visitor"<code> will be used.
	 * </p>
	 */	
	public def void setVisitorClassName(String visitorClassName) {
		this.visitorClassName = visitorClassName;
	}

	/**
	 * The required package name for the generated Visitor interface. (e.g. "org.my.project.util")
	 * <p>
	 * If not provided <code>modelPackageName + "util"<code> will be used.
	 * </p>
	 */
	// FIXME this could have the util package as a default.
	public def void setVisitorPackageName(String visitorPackageName) {
		this.visitorPackageName = visitorPackageName;
	}
	
	/**
	 * The required name of the language. It me used as prefix for some interfaces/classes
	 * so it should be in UpperCamelCase format.
	 */
	public def void setProjectPrefix(String projectPrefix) {
		this.projectPrefix = projectPrefix;
	}
	
	/**
	 * The required name of the extended language. It me used as prefix for some interfaces/classes
	 * so it should be in UpperCamelCase format.
	 */
	public def void setSuperProjectPrefix(String superProjectPrefix) {
		this.superProjectPrefix = superProjectPrefix;
	}
	
	
	protected def String getGenModelFile() {
		if (genModelFile == null) {
			return "model/"+projectPrefix + ".genmodel";
		}
		return genModelFile;
	}

	// FIXME this is 100% deriveable from the genmodel.
	// when fixed, fix setter doc
	protected def String getJavaFolder() {
		if (javaFolder == null) {
			return "src";
		}
		return javaFolder;
	}

	// FIXME this is 100% deriveable from the genmodel.
	// when fixed, fix setter doc
	protected def String getModelPackageName() {
		if (modelPackageName == null) {
			return getProjectName + "."+ getProjectPrefix.toLowerCase;
		}
		return modelPackageName;
	}

	protected def String getSuperModelPackageName() {
		if (superModelPackageName == null) {
			if (getSuperProjectName != null) { // parameters checking ensures that if we have superProjectName we have superProjectPrefix
				return getSuperProjectName + "."+ getSuperProjectPrefix.toLowerCase;	
			}
		}
		return superModelPackageName;
	}

	protected def String getProjectName() {
		return projectName;
	}
	
	protected def String getSuperProjectName() {
		return superProjectName;
	}

	protected def ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	protected def String getSuperVisitorClassName() {
		if (superVisitorClassName == null ) {
			if (getSuperProjectPrefix != null) {
				return getSuperProjectPrefix.toFirstUpper + "Visitor";	
			} 
		}
		return superVisitorClassName;
	}
	
	protected def String getSuperVisitorPackageName() {
		if (superVisitorPackageName == null) {
			if (getSuperModelPackageName != null) {
				return getSuperModelPackageName + ".util";	// FIXME .util or .visitor ?
			}
		}
		return superVisitorPackageName;
	}

	protected def String getVisitorClassName() {
		if (visitorClassName == null ) {
			return getProjectPrefix.toFirstUpper + "Visitor";
		}
		return visitorClassName;
	}

	protected def String getVisitorPackageName() {
		if (visitorPackageName == null) {
			return getModelPackageName + ".util";
		}
		return visitorPackageName;
	}
	
	protected def String getVisitableClassName() {
		if (visitableClassName == null ) {
			return getProjectPrefix.toFirstUpper + "Visitable";
		}
		return visitableClassName;
	}

	protected def String getVisitablePackageName() {
		if (visitablePackageName == null) {
			return getVisitorPackageName;
		}
		return visitablePackageName;
	}

	protected def String getProjectPrefix() {
		return projectPrefix;
	}

	protected def String getSuperProjectPrefix() {
		return superProjectPrefix;
	}
	
	protected def String getOutputFolder() {
		return outputFolder;
	}
	
	protected def String getSourceFile() {
		return sourceFile;
	}
	
	protected def String getCopyright() {
		return copyright;
	}
	
	protected def Logger getLogger() {
		return logger;
	}
}
