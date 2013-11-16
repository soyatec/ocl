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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.utilities.ASSaver;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;

public abstract class GenerateOCLstdlib extends GenerateOCLCommonXtend
{
	protected abstract @NonNull String generateMetamodel(@NonNull Root pivotModel);

	protected @Nullable Library getLibrary(@NonNull Root root) {
		TreeIterator<EObject> tit = root.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof Library) {
				return (Library) eObject;
			}
		}
		return null;
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		String rootPath = StandaloneSetup.getPlatformRootPath();
		File folder = new File(rootPath + javaFolder + "/" + javaPackageName.replace(".", "/"));
		try {
			sourceFile = "/" + projectName + "/" + modelFile;
			URI fileURI = URI.createPlatformResourceURI(sourceFile, true);
			log.info("Loading OCL library '" + fileURI);
			ResourceSet resourceSet = getResourceSet();
			BaseCSResource xtextResource = (BaseCSResource)resourceSet.getResource(fileURI, true);
			String message = PivotUtil.formatResourceDiagnostics(DomainUtil.nonNullEMF(xtextResource.getErrors()), "OCLstdlib parse failure", "\n");
			if (message != null) {
				issues.addError(this, message, null, null, null);
				return;
			}
			ASResource asResource = xtextResource.getASResource(null);
//			if (asResource == null) {
//				return;
//			}
			EObject pivotModel = DomainUtil.nonNullState(asResource.getContents().get(0));
			ASSaver saver = new ASSaver(asResource);
			saver.localizeSpecializations();
			String fileName = folder + "/" + javaClassName + ".java";
			log.info("Generating '" + fileName + "'");
			String metaModel = generateMetamodel((Root)pivotModel);
			MergeWriter fw = new MergeWriter(fileName);
			fw.append(metaModel);
			fw.close();
			String saveFile = "/" + projectName + "/" + modelFile.replace("model", "model-gen").replace("oclstdlib", "oclas");
			URI saveURI = URI.createPlatformResourceURI(saveFile, true);
			log.info("Loading '" + saveURI + "'");
			log.info("Saving '" + saveURI + "'");
			asResource.setURI(saveURI);
			Map<String, Object> options = new HashMap<String, Object>();
			options.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
			asResource.save(options);
			MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(asResource);
			@SuppressWarnings("null")@NonNull URI ecoreURI = saveURI.trimFileExtension().appendFileExtension("ecore");
			Pivot2Ecore converter = new Pivot2Ecore(metaModelManager, ecoreURI, null);
			Resource eResource = converter.convertResource(asResource, ecoreURI);
			EPackage ePackage = (EPackage) DomainUtil.nonNullState(eResource.getContents().get(0));
			ePackage.setName("oclstdlib");
			ePackage.setNsPrefix("oclstdlib");
			setInstanceClassName(ePackage, "Bag", BagValue.class);
			setInstanceClassName(ePackage, "Boolean", Boolean.class);
			setInstanceClassName(ePackage, "Collection", CollectionValue.class);
			setInstanceClassName(ePackage, "Integer", IntegerValue.class);
			setInstanceClassName(ePackage, "OrderedSet", OrderedSetValue.class);
			setInstanceClassName(ePackage, "Real", RealValue.class);
			setInstanceClassName(ePackage, "Sequence", SequenceValue.class);
			setInstanceClassName(ePackage, "Set", SetValue.class);
			setInstanceClassName(ePackage, "String", String.class);
			setInstanceClassName(ePackage, "UniqueCollection", UniqueCollectionValue.class);
			setInstanceClassName(ePackage, "UnlimitedNatural", IntegerValue.class);
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					eClass.getEOperations().clear();
					eClass.getEStructuralFeatures().clear();
				}
			}
			log.info("Saving '" + ecoreURI + "'");
			eResource.save(null);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	private void setInstanceClassName(@NonNull EPackage ePackage, String typeName, Class<?> javaClass) {
		EClassifier eClassifier = DomainUtil.nonNullState(ePackage.getEClassifier(typeName));
		eClassifier.setInstanceClassName(javaClass.getName());
	}

	/**
	 * The platform relative path to the Java generated source folder (e.g. "/org.eclipse.ocl.examples.pivot/emf-src")
	 */
	public void setJavaFolder(String javaFolder) {
		this.javaFolder = javaFolder;
	}
}
