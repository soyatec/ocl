/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
import java.io.FileWriter;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * Generates the javaFolder/'javaPackageName'Tables.java file defining
 * the static dispatch tables for the OCL executor.
 */
public class Model2tablesGenerator extends AbstractWorkflowComponent
{
	private Logger log = Logger.getLogger(getClass());	
	private ResourceSet resourceSet = null;	
	private boolean genOCLstdlib = false;	
	protected String genModelFile;

	@Override
	public void checkConfiguration(Issues issues) {
		if (genModelFile == null) {
			issues.addError(this, "genModel not specified.");
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
		URI genModelURI = URI.createPlatformResourceURI(genModelFile, true);
		log.info("Loading Gen Model '" + genModelURI);
		ResourceSet resourceSet = getResourceSet();
		if (genOCLstdlib) {
			final MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
			if (adapter != null) {
				adapter.getMetaModelManager().setLibraryLoadInProgress(true);
			}
		}
		try {
			StandaloneProjectMap projectMap = new StandaloneProjectMap();
			projectMap.initializeResourceSet(resourceSet);
			resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
			Resource genModelResource = resourceSet.getResource(genModelURI, true);
			List<Diagnostic> genModelErrors = DomainUtil.nonNullEMF(genModelResource.getErrors());
			String errorsString = PivotUtil.formatResourceDiagnostics(genModelErrors, "Loading " + genModelURI, "\n");
			if (errorsString != null) {
				issues.addError(this, errorsString, null, null, null);
				return;
			}
			GenModel genModel = (GenModel) genModelResource.getContents().get(0);
			String modelDirectory = genModel.getModelDirectory();
			String modelProjectDirectory = genModel.getModelProjectDirectory();
			@SuppressWarnings("null")@NonNull String modelProject = modelProjectDirectory.substring(1);
			String folderPath = modelDirectory.substring(modelProjectDirectory.length());
			URI locationURI = projectMap.getLocation(modelProject);
			if (locationURI == null) {
				issues.addError(this, "NO location URI for " + modelProjectDirectory, null, null, null);
				return;
			}
			URL url = new URL(locationURI.toString());
			java.net.URI uri = url.toURI();
			File targetFolder = new File(uri.getRawPath() + folderPath);
			log.info("Generating to '" + targetFolder + "'");
   			List<GenPackage> genPackages = genModel.getAllGenPackagesWithClassifiers();
   			for (@SuppressWarnings("null")@NonNull GenPackage genPackage : genPackages) {
				OCLinEcoreTables generateTables = new OCLinEcoreTables(genPackage);
				String tablesClass = generateTables.getTablesClassName();
				String dir = genPackage.getQualifiedPackageName().replace(".", "/");
				generateTables.generateTablesClass(null);
				String str = generateTables.toString();
				FileWriter testFile = new FileWriter(new File(targetFolder, dir + "/" + tablesClass + ".java"));
				testFile.append(str);
				testFile.close();
   			}
		} catch (Exception e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	public void setGenModelFile(String genModelFile) {
		this.genModelFile = genModelFile;
	}

	public void setGenOCLstdlib(boolean genOCLstdlib) {
		this.genOCLstdlib = genOCLstdlib;
	}
	
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
}
