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
package org.eclipse.ocl.examples.build.xtend;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IPackageDescriptor;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IProjectDescriptor;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.LoadModelStrategy;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.utilities.ASSaver;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public abstract class GenerateOCLMetaModel extends GenerateOCLCommonXtend
{
	protected CollectionType findCollectionType(Iterable<Type> types, String name) {
		for (Type type : types) {
			if ((type instanceof CollectionType) && (type.getName().equals(name))) {
				TemplateableElement unspecializedElement = type.getUnspecializedElement();
				if (unspecializedElement instanceof CollectionType) {
					return (CollectionType)unspecializedElement;
				}
			}
		}
		return null;
	}

	protected org.eclipse.ocl.examples.pivot.Package findPackage(Iterable<org.eclipse.ocl.examples.pivot.Package> packages) {
		for (org.eclipse.ocl.examples.pivot.Package pkg : packages) {
			if (!"$$".equals(pkg.getName())) {
				return pkg;
			}
		}
		return null;
	}
	
	protected DataType findPrimitiveType(Iterable<Type> types, String name) {
		for (Type type : types) {
			if ((type instanceof DataType) && (type.getName().equals(name))) {
				return (DataType)type;
			}
		}
		return null;
	}

	protected abstract String generateMetamodel(@NonNull Root pivotModel);
	
	protected String getEcoreLiteral(@NonNull Type elem) {
		return NameQueries.getEcoreLiteral(elem);
	}

	protected String getEcoreLiteral(@NonNull EnumerationLiteral elem) {
		return NameQueries.getEcoreLiteral(elem);
	}

	protected String getEcorePropertyLiteral(@NonNull Property property) {
		return NameQueries.getEcoreLiteral(property);
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		ResourceSet resourceSet = DomainUtil.nonNullState(getResourceSet());
		StandaloneProjectMap projectMap = StandaloneProjectMap.getAdapter(resourceSet);
		assert projectName != null;
		IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(projectName);
		if (projectDescriptor == null) {
			issues.addError(this, "Unknown project '" + projectName + "'", null, null, null);
			return;
		}
		@SuppressWarnings("null")@NonNull URI nsURI = URI.createURI(PivotPackage.eNS_URI);
		IPackageDescriptor packageDescriptor = projectDescriptor.getPackageDescriptor(nsURI);
	    packageDescriptor.configure(resourceSet, LoadModelStrategy.INSTANCE, null);
		assert modelFile != null;
		URI inputURI = projectDescriptor.getPlatformResourceURI(modelFile);
		File outputFolder = projectDescriptor.getLocationFile(javaFolder + '/' + javaPackageName.replace('.', '/'));
		OCLstdlib.install();
		log.info("Loading Pivot Model '" + inputURI);
		try {
			MetaModelManager metaModelManager = MetaModelManager.getAdapter(resourceSet);
			NameQueries.setMetaModelManager(metaModelManager);
			Resource ecoreResource = DomainUtil.nonNullState(resourceSet.getResource(inputURI, true));
			MetaModelManagerResourceAdapter.getAdapter(ecoreResource, metaModelManager);
			String ecoreErrorsString = PivotUtil.formatResourceDiagnostics(DomainUtil.nonNullEMF(ecoreResource.getErrors()), "Loading " + inputURI, "\n");
			if (ecoreErrorsString != null) {
				issues.addError(this, ecoreErrorsString, null, null, null);
				return;
			}
			Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, metaModelManager);
			Root pivotRoot = ecore2Pivot.getPivotRoot();
			Resource asResource = pivotRoot.eResource();
			String pivotErrorsString = PivotUtil.formatResourceDiagnostics(DomainUtil.nonNullEMF(asResource.getErrors()), "Converting " + inputURI, "\n");
				if (pivotErrorsString != null) {
					issues.addError(this, pivotErrorsString, null, null, null);
					return;
				}
			sourceFile = "/" + projectName + "/" + modelFile;
			EObject pivotModel = asResource.getContents().get(0);
			ASSaver saver = new ASSaver(asResource);
			/*Package orphanage =*/ saver.localizeSpecializations();
//			if ((orphanage != null) && (pivotModel instanceof Root)) {
//				(pivotModel as Root).getNestedPackage().add(orphanage);
//			}
			String fileName = outputFolder + "/" + javaClassName + ".java";
			log.info("Generating '" + fileName + "'");
			assert pivotModel instanceof Root;
			String metaModel = generateMetamodel((Root)pivotModel);
			MergeWriter fw = new MergeWriter(fileName);
			if (metaModel != null) {
				fw.append(metaModel);
			}
			fw.close();
			String saveFile = "/" + projectName + "/" + modelFile.replace("model", "model-gen").replace("ecore", "oclas");
			URI saveURI = URI.createPlatformResourceURI(saveFile, true);
//			log.info("Loading '" + saveURI + "'");
//			AS2XMIid as2id = AS2XMIid.load(saveURI);
			log.info("Saving '" + saveURI + "'");
			asResource.setURI(saveURI);
//	    	as2id.assignIds(asResource.getResourceSet());
			asResource.save(null);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	/**
	 * The projectName relative path to the Java generated source folder (e.g. "emf-src")
	 */
	public void setJavaFolder(String javaFolder) {
		this.javaFolder = javaFolder;
	}
}
