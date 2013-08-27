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

import java.io.File
import org.eclipse.emf.common.util.TreeIterator
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.mwe.core.WorkflowContext
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.ocl.examples.domain.utilities.DomainUtil
import org.eclipse.ocl.examples.pivot.DataType
import org.eclipse.ocl.examples.pivot.Library
import org.eclipse.ocl.examples.pivot.Package
import org.eclipse.ocl.examples.pivot.Root
import org.eclipse.ocl.examples.pivot.resource.ASResource
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource
import org.eclipse.ocl.examples.pivot.utilities.ASSaver
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid

public class GenerateOCLstdlib extends GenerateOCLCommon
{
	protected def String defineConstantType(DataType type) {'''
		«IF "Boolean".equals(type.name)»
			protected final PrimitiveType «type.getPrefixedSymbolName("_"+type.partialName())» = OCLstdlib._Boolean;«ELSEIF "Classifier".equals(type.name)»
			protected final PrimitiveType «type.getPrefixedSymbolName("_"+type.partialName())» = OCLstdlib._Classifier;«ELSEIF "Integer".equals(type.name)»
			protected final PrimitiveType «type.getPrefixedSymbolName("_"+type.partialName())» = OCLstdlib._Integer;«ELSEIF "Real".equals(type.name)»
			protected final PrimitiveType «type.getPrefixedSymbolName("_"+type.partialName())» = OCLstdlib._Real;«ELSEIF "String".equals(type.name)»
			protected final PrimitiveType «type.getPrefixedSymbolName("_"+type.partialName())» = OCLstdlib._String;«ELSEIF "UnlimitedNatural".equals(type.name)»
			protected final PrimitiveType «type.getPrefixedSymbolName("_"+type.partialName())» = OCLstdlib._UnlimitedNatural;«ELSE»
			protected final DataType «type.getPrefixedSymbolName("_"+type.partialName())» = createDataType("«type.name»");«ENDIF»
	'''}

	protected def String generateMetamodel(Root root) {
		var lib = root.getLibrary();
		var allEnumerations = root.getSortedEnumerations();
		'''
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
			 *
			 * This code is auto-generated
			 * from: «sourceFile»
			 * by: org.eclipse.ocl.examples.build.xtend.generateOCLstdlib.xtend
			 * and: org.eclipse.ocl.examples.build.GenerateOCLstdlibModel.mwe2
			 *
			 * Do not edit it.
			 */
			package	«javaPackageName»;
			
			import java.util.ArrayList;
			import java.util.List;
			import java.util.Map;
			import java.util.Set;
			import java.util.WeakHashMap;
			
			import org.eclipse.emf.common.util.TreeIterator;
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.EObject;
			import org.eclipse.emf.ecore.EReference;
			import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
			import org.eclipse.emf.ecore.resource.Resource;
			import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
			import org.eclipse.ocl.examples.pivot.*;
			import org.eclipse.ocl.examples.pivot.Class;
			import org.eclipse.ocl.examples.pivot.Package;
			import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
			import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
			import org.eclipse.ocl.examples.pivot.resource.ASResourceImpl;
			import org.eclipse.ocl.examples.pivot.resource.OCLASResourceFactory;
			import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid;
			import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
			
			/**
			 * This is the «uri» Standard Library
			 * auto-generated from «sourceFile».
			 * It facilitates efficient library loading without the overheads of model reading.
			 * <p>
			 * This Standard Library may be registered as the definition of a Standard Library for
			 * the OCL evaluation framework by invoking {@link #install}.
			 * <p>
			 * The Standard Library is normally activated when the MetaModelManager attempts
			 * to locate a library type when its default Standard Library URI is the same
			 * as this Standard Library.
			 */
			@SuppressWarnings({"nls", "unused"})
			public class «javaClassName» extends ASResourceImpl
			{
				/**
				 *	The static package-of-types pivot model of the Standard Library.
				 */
				private static «javaClassName» INSTANCE = null;
				
				/**
				 *	The URI of this Standard Library.
				 */
				public static final @NonNull String STDLIB_URI = "«uri»";
			
				/**
				 * Return the default OCL standard Library. 
				 *  This static definition auto-generated from «sourceFile»
				 *  is used as the default when no overriding copy is registered. 
				 */
				public static @NonNull OCLstdlib getDefault() {
					OCLstdlib oclstdlib = INSTANCE;
					if (oclstdlib == null) {
						Contents contents = new Contents();
						Root libraryModel = contents.create("«lib.nsURI»", "«lib.name»", "«lib.nsPrefix»", "«lib.nsURI»");
						oclstdlib = INSTANCE = new OCLstdlib(STDLIB_URI + PivotConstants.DOT_OCL_AS_FILE_EXTENSION, libraryModel);
						new AS2XMIid().assignIds(oclstdlib);
					}
					return oclstdlib;
				}
			
				/**
				 * Return true if the default OCL standard Library has been created. 
				 */
				public static boolean hasDefault() {
					return INSTANCE != null;
				}
			
				/**
				 * Install this library in the {@link StandardLibraryContribution#REGISTRY}.
				 * This method may be invoked by standalone applications to replicate
				 * the registration that should appear as a standard_library plugin
				 * extension when running within Eclipse. 
				 */
				public static void install() {
					StandardLibraryContribution.REGISTRY.put(STDLIB_URI, new Loader());
				}
			
				/**
				 * Unnstall this library from the {@link StandardLibraryContribution#REGISTRY}.
				 * This method may be invoked by standalone applications to release the library
				 * resources for garbage collection and memory leakage detection. 
				 */
				public static void uninstall() {
					StandardLibraryContribution.REGISTRY.remove(STDLIB_URI);
					INSTANCE = null;
				}
				
				/**
				 * The Loader shares the Standard Library instance whenever this default library
				 * is loaded from the registry of Standard Libraries populated by the standard_library 
				 * extension point.
				 */
				public static class Loader implements StandardLibraryContribution
				{
					public StandardLibraryContribution getContribution() {
						return this;
					}
					
					public @NonNull Resource getResource() {
						return getDefault();
					}
				}
				
				/**
				 *	Construct a copy of the OCL Standard Library with specified resource URI,
				 *  and package name, prefix and namespace URI.
				 */
				public static @NonNull «javaClassName» create(@NonNull String asURI, @NonNull String name, @NonNull String nsPrefix, @NonNull String nsURI) {
					Contents contents = new Contents();
					Root libraryModel = contents.create(asURI, name, nsPrefix, nsURI);
					return new «javaClassName»(asURI, libraryModel);
				}
				
				/**
				 *	Construct an OCL Standard Library with specified resource URI and library content.
				 */
				public «javaClassName»(@NonNull String asURI, @NonNull Root libraryModel) {
					super(DomainUtil.nonNullState(URI.createURI(asURI)), OCLASResourceFactory.INSTANCE);
					assert PivotUtil.isASURI(asURI);
					getContents().add(libraryModel);
			//		System.out.println(Thread.currentThread().getName() + " Create " + debugSimpleName(this));		
			//		liveOCLstdlibs.put(this, null);
				}
			
				protected static class Contents extends AbstractContents
				{
					protected Root «root.getPrefixedSymbolName("root")»;
					protected Library «lib.getPrefixedSymbolName("library")»;
					// protected Package «root.getOrphanPackage().getPrefixedSymbolName("orphans")»;
			
					protected @NonNull Root create(@NonNull String asURI, @NonNull String name, @NonNull String nsPrefix, @NonNull String nsURI)
					{
						Root theRoot = «root.getSymbolName()» = createRoot("«root.name»", asURI);
						«lib.getSymbolName()» = createLibrary(name, nsPrefix, nsURI);
						installPackages();
						installOclTypes();
						installPrimitiveTypes();
			«IF allEnumerations.size() > 0»
						installEnumerations();
			«ENDIF»
						installParameterTypes();
						installCollectionTypes();
						installMetaclasses();
						installLambdaTypes();
						installTupleTypes();
						installOperations();
						installIterations();
						installProperties();
						installTemplateSignatures();
						installTemplateBindings();
						installPrecedences();
						installComments();
						return theRoot;
					}
				
					«lib.definePackages()»

					«lib.declareOclTypes()»

					«lib.declarePrimitiveTypes()»
					«IF allEnumerations.size() > 0»

					«lib.declareEnumerations()»
					«ENDIF»

					«lib.declareParameterTypes()»

					«lib.declareCollectionTypes()»

					«lib.declareMetaclasses()»

					«lib.declareTupleTypes()»

					«lib.defineOclTypes()»

					«lib.definePrimitiveTypes()»
					«IF allEnumerations.size() > 0»

					«lib.defineEnumerations()»
					«ENDIF»

					«lib.defineParameterTypes()»

					«lib.defineCollectionTypes()»

					«lib.defineMetaclasses()»

					«lib.defineTupleTypes()»

					«lib.defineLambdaTypes()»	

					«lib.defineOperations()»	

					«lib.defineIterations()»	

					«lib.declareProperties()»

					«lib.defineProperties()»

					«lib.defineTemplateSignatures()»

					«lib.defineTemplateBindings()»

					«lib.definePrecedences()»

					«lib.defineComments()»
				}

			/*	private static WeakHashMap<OCLstdlib,Object> liveOCLstdlibs = new WeakHashMap<OCLstdlib,Object>();
				
				public static String debugSimpleName(Object object) {
					if (object == null) {
						return "null";
					}
					else {
						return object.getClass().getSimpleName() + "@" + Integer.toHexString(object.hashCode());
					}
				}

				@Override
				protected void finalize() throws Throwable {
					System.out.println("Finalize " + debugSimpleName(this));		
					super.finalize();
					Set<OCLstdlib> keySet = liveOCLstdlibs.keySet();
					if (!keySet.isEmpty()) {
						StringBuilder s = new StringBuilder();
						s.append(" live");
						for (OCLstdlib stdlib : keySet) {
							s.append(" @" + Integer.toHexString(stdlib.hashCode()));		
						}
						System.out.println(s);		
					}
				} */

			/*	public static void decontain() {
					Map<EObject, Object> allContents = new WeakHashMap<EObject,Object>(1000);
					for (OCLstdlib oclstdlib : liveOCLstdlibs.keySet()) {
						for (TreeIterator<EObject> tit = oclstdlib.getAllContents(); tit.hasNext(); ) {
							allContents.put(tit.next(), null);
						}
					}
					for (EObject eObject : allContents.keySet()) {
						for (EReference eReference : eObject.eClass().getEAllReferences()) {
							boolean isUnsettable = eReference.isUnsettable();
							boolean isChangeable = eReference.isChangeable();
							if (isChangeable) {
			//					System.out.println("unset : " + debugSimpleName(eObject) + " " + eReference.getName());
								try {
									eObject.eUnset(eReference);
								}
								catch (Exception e) {}
							}
						}
					}
					System.gc();
					System.runFinalization();
					for (EObject eObject : allContents.keySet()) {
						System.out.println("   still live : " + debugSimpleName(eObject));
					}
				} */
			}
		'''
	}

	protected def Library getLibrary(Root root) {
		var TreeIterator<EObject> tit = root.eAllContents;
		while (tit.hasNext()) {
			var EObject eObject = tit.next();
			if (eObject instanceof Library) {
				return eObject as Library;
			}
		}
		return null;
	}

	override protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		var String rootPath = StandaloneSetup.getPlatformRootPath();
		var File folder = new File(rootPath + javaFolder + "/" + javaPackageName.replace(".", "/"));
		try {
			sourceFile = "/" + projectName + "/" + modelFile;
			var URI fileURI = URI.createPlatformResourceURI(sourceFile, true);
			log.info("Loading OCL library '" + fileURI);
			var ResourceSet resourceSet = getResourceSet();
			var BaseCSResource xtextResource = resourceSet.getResource(fileURI, true) as BaseCSResource;
			var String message = PivotUtil.formatResourceDiagnostics(DomainUtil.nonNullEMF(xtextResource.getErrors()), "OCLstdlib parse failure", "\n");
			if (message != null) {
				issues.addError(this, message, null, null, null);
				return;
			}
			var ASResource asResource = xtextResource.getASResource(null);
			if (asResource == null) {
				return;
			}
			var EObject pivotModel = asResource.getContents().get(0);
			var ASSaver saver = new ASSaver(asResource);
			var Package orphanage = saver.localizeSpecializations();
			if ((orphanage != null) && (pivotModel instanceof Root)) {
				(pivotModel as Root).getNestedPackage().add(orphanage);
			}
			var String fileName = folder + "/" + javaClassName + ".java";
			log.info("Generating '" + fileName + "'");
			var String metaModel = generateMetamodel(pivotModel as Root);
			var MergeWriter fw = new MergeWriter(fileName);
			fw.append(metaModel);
			fw.close();
			var String saveFile = "/" + projectName + "/" + modelFile.replace("model", "model-gen").replace("oclstdlib", "oclas");
			var URI saveURI = URI.createPlatformResourceURI(saveFile, true);
			log.info("Loading '" + saveURI + "'");
			var AS2XMIid as2id = AS2XMIid.load(saveURI);
			log.info("Saving '" + saveURI + "'");
			asResource.setURI(saveURI);
	    	as2id.assignIds(asResource.getResourceSet());
			asResource.save(null);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	/**
	 * The platform relative path to the Java generated source folder (e.g. "/org.eclipse.ocl.examples.pivot/emf-src")
	 */
	public def void setJavaFolder(String javaFolder) {
		this.javaFolder = javaFolder;
	}
}
