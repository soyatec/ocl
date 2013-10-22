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
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.importer.ModelImporter;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IPackageDescriptor;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IProjectDescriptor;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.uml2.uml.ecore.importer.UMLImporter;

/**
 * Reloads the designated <tt>genModel</tt>.
 */
public class GenmodelReloader extends AbstractProjectComponent
{
	protected Logger log = Logger.getLogger(getClass());	
//	protected String modelImporter = UMLImporter.class.getName();
	protected String genModel;							// URI of the genmodel
	protected String ecoreFile = null;					// Explicit file URI of the Ecore
	protected boolean showProgress = false;				// Set true to show genmodel new tasks

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (genModel == null) {
			issues.addError(this, "genModel name not specified.");
		}
//		if (modelImporter == null) {
//			issues.addError(this, "modelImporter class not specified.");
//		}
	}

	public String getEcoreFile() {
		return ecoreFile;
	}

	public String getGenModel() {
		return genModel;
	}

//	public String getModelImporter() {
//		return modelImporter;
//	}

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		URI genModelURI = URI.createPlatformResourceURI(genModel, true);
		log.info("Reloading '" + genModelURI + "'");
		Monitor monitor = showProgress ? new LoggerMonitor(log) : new BasicMonitor();
		IProjectDescriptor projectDescriptor = DomainUtil.nonNullState(getProjectDescriptor());
		@SuppressWarnings("null")@NonNull URI nsURI = URI.createURI(PivotPackage.eNS_URI);
		IPackageDescriptor packageDescriptor = projectDescriptor.getPackageDescriptor(nsURI);
		packageDescriptor.configure(null, StandaloneProjectMap.LoadModelStrategy.INSTANCE, null);
		ModelImporter modelImporterInstance = new UMLImporter()
		{
			@Override
			public ResourceSet createResourceSet() {
				ResourceSet resourceSet = super.createResourceSet();
				ProjectMap.initializeURIResourceMap(resourceSet);
				return resourceSet;
			}
			
		};
//		Class<?> clazz = ResourceLoaderFactory.createResourceLoader().loadClass(modelImporter);
//		if (clazz == null)
//			throw new ConfigurationException("Couldn't find class " + modelImporter);
//		try {
//			modelImporterInstance = (ModelImporter) clazz.newInstance();
//		} catch (Exception e) {
//			throw new ConfigurationException("Couldn't create instance of class " + modelImporter, e);
//		}
		try {
			Path path = new Path(genModel);
			modelImporterInstance.defineOriginalGenModelPath(path);

		    Diagnostic diagnostic = modelImporterInstance.computeEPackages(monitor);
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				log.info(diagnostic);
	    	}
//		    modelImporterInstance.adjustEPackages(monitor);
			if (ecoreFile != null) {
			    ResourceSet genModelResourceSet = modelImporterInstance.getGenModelResourceSet();
			    URI ecoreURI = URI.createPlatformResourceURI(ecoreFile, true);
		    	Resource ecoreResource = genModelResourceSet.getResource(ecoreURI, true);
				ecoreResource.setURI(ecoreURI);										// change file:... to platform:...
		    	List<EPackage> ePackages = modelImporterInstance.getEPackages();
		    	ecoreResource.getContents().clear();
		    	ecoreResource.getContents().addAll(ePackages);
				projectDescriptor.configure(genModelResourceSet, StandaloneProjectMap.LoadBothStrategy.INSTANCE, null);
		    }
			
			modelImporterInstance.prepareGenModelAndEPackages(monitor);
			
//			modelImporterInstance.saveGenModelAndEPackages(monitor); -- assumes Eclipse running
		    List<Resource> resources = computeResourcesToBeSaved(modelImporterInstance);    
//		    String readOnlyFiles = ConverterUtil.WorkspaceResourceValidator.validate(resources);
//		    if (readOnlyFiles != null)
//		    {
//		      throw new Exception(ImporterPlugin.INSTANCE.getString("_UI_ReadOnlyFiles_error", new String[]{readOnlyFiles})); 
//		    }
	    	ResourceUtils.checkResourceSet(resources.get(0).getResourceSet());
//		    if (ecoreFile != null) {
//		    	Resource ecoreResource = resources.get(1);
//			    URI ecoreURI = URI.createPlatformResourceURI(ecoreFile, true);
//				ecoreResource.setURI(ecoreURI);		// change file:... to platform:...
//		    }
		    for (Resource resource : resources)
		    {
		      resource.save(getGenModelSaveOptions());
		    }
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	public void setEcoreFile(String ecoreFile) {
		this.ecoreFile = ecoreFile;
	}

	public void setGenModel(String genModel) {
		this.genModel = genModel;
	}

//	public void setModelImporter(String modelImporter) {
//		this.modelImporter = modelImporter;
//	}
	  
	public static List<Resource> computeResourcesToBeSaved(
			ModelImporter modelImporter) { // This is a clone of the protected
											// ModelImporter method
		List<Resource> resources = new UniqueEList.FastCompare<Resource>();
		Resource genModelResource = modelImporter.getGenModel().eResource();
		resources.add(genModelResource);
		for (GenPackage genPackage : modelImporter.getGenModel()
			.getGenPackages()) {
			resources.add(genPackage.getEcorePackage().eResource());
		}

		// Handle application genmodel stub
		//
		for (GenPackage genPackage : modelImporter.getGenModel()
			.getUsedGenPackages()) {
			if (genPackage.eResource() == genModelResource) {
				resources.add(genPackage.getEcorePackage().eResource());
			}
		}

		return resources;
	}

	protected Map<?, ?> getGenModelSaveOptions() {
		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
//		result.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));
		result.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		return result;
	}
}
