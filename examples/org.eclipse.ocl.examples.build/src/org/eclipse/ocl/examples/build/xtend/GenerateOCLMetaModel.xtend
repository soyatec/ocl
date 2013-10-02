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
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.mwe.core.WorkflowContext
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor
import org.eclipse.ocl.examples.domain.utilities.DomainUtil
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IPackageDescriptor
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IProjectDescriptor
import org.eclipse.ocl.examples.pivot.CollectionType
import org.eclipse.ocl.examples.pivot.DataType
import org.eclipse.ocl.examples.pivot.EnumerationLiteral
import org.eclipse.ocl.examples.pivot.Package
import org.eclipse.ocl.examples.pivot.PivotPackage
import org.eclipse.ocl.examples.pivot.Property
import org.eclipse.ocl.examples.pivot.Root
import org.eclipse.ocl.examples.pivot.Type
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter
import org.eclipse.ocl.examples.pivot.model.OCLstdlib
import org.eclipse.ocl.examples.pivot.utilities.ASSaver
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid

public class GenerateOCLMetaModel extends GenerateOCLCommonXtend
{
	protected override String declareEnumerations(Package pkg) {
		var allEnumerations = pkg.getRootPackage().getSortedEnumerations();
	'''
		«FOR enumeration : allEnumerations»
			«var enumerationName = enumeration.getPrefixedSymbolName("_"+enumeration.partialName())»
			protected final @NonNull Enumeration «enumerationName» = createEnumeration(«getEcoreLiteral(enumeration)»);
			«FOR enumerationLiteral : enumeration.ownedLiteral»
			protected final @NonNull EnumerationLiteral «enumerationLiteral.getPrefixedSymbolName("el_"+enumerationName+"_"+enumerationLiteral.name)» = createEnumerationLiteral(«getEcoreLiteral(enumerationLiteral)»);
			«ENDFOR»
		«ENDFOR»
	'''}
	
	protected override String declareOclTypes(Package pkg) {
		var allOclTypes = pkg.getSortedOclTypes();
	'''
		«FOR type : allOclTypes»
		protected final @NonNull «type.eClass().name» «type.getPrefixedSymbolName("_"+type.partialName())» = create«type.eClass().name»(«getEcoreLiteral(type)»);
		«ENDFOR»
	'''}
	
	protected override String declareProperties(Package pkg) {
	'''
		«FOR property : pkg.getRootPackage().getSortedProperties()»
		protected final @NonNull Property «property.getPrefixedSymbolName("pr_"+property.partialName())» = createProperty(«getEcorePropertyLiteral(property)», «property.type.getSymbolName()»);
		«ENDFOR»
	'''}
	
	protected def String defineCollectionTypeName(Set<Type> allTypes, String typeName) {
		var CollectionType collectionType = allTypes.findCollectionType(typeName);
		var collectionName = collectionType.getPrefixedSymbolName("_"+typeName);
		var signatureName = collectionType.ownedTemplateSignature.getPrefixedSymbolName("_"+typeName+"_");
		var parameterName = collectionType.ownedTemplateSignature.parameter.get(0).getPrefixedSymbolName("_"+typeName+"_T");
	'''
		protected final @NonNull CollectionType «collectionName» = standardLibrary.get«typeName»Type();
		@SuppressWarnings("null") protected final @NonNull TemplateSignature «signatureName» = «collectionName».getOwnedTemplateSignature();
		@SuppressWarnings("null") protected final @NonNull TemplateParameter «parameterName» = «signatureName».getParameter().get(0);
	'''
	}
	
	protected def String definePrimitiveTypeName(Set<Type> allTypes, String typeName) {
		var DataType primitiveType = allTypes.findPrimitiveType(typeName);
	'''
		protected final @NonNull PrimitiveType «primitiveType.getPrefixedSymbolName("_"+typeName)» = standardLibrary.get«typeName»Type();
	'''}
	
	protected def CollectionType findCollectionType(Iterable<Type> types, String name) {
		for (Type type : types) {
			if ((type instanceof CollectionType) && (type.name.equals(name))) {
				var unspecializedElement = type.unspecializedElement;
				if (unspecializedElement instanceof CollectionType) {
					return unspecializedElement;
				}
			}
		}
		return null;
	}

	protected def Package findPackage(Iterable<Package> packages) {
		for (pkg : packages) {
			if (!"$$".equals(pkg.name)) {
				return pkg;
			}
		}
		return null;
	}
	
	protected def DataType findPrimitiveType(Iterable<Type> types, String name) {
		for (Type type : types) {
			if ((type instanceof DataType) && (type.name.equals(name))) {
				return type as DataType;
			}
		}
		return null;
	}

	protected def String generateMetamodel(Root root) {
		var Package pkg = root.nestedPackage.findPackage();
		if (pkg == null) {
			return null;
		}
		var allMetaclasses  = root.getAllMetaclasses();
		var allCollectionTypes = root.getAllCollectionTypes();
		var allEnumerations = root.getAllEnumerations();
		var allLambdaTypes = root.getAllLambdaTypes();
		var allPrecedences = root.getAllPrecedences();
		var allPrimitiveTypes = root.getAllPrimitiveTypes();
		var allTemplateBindings = root.getAllTemplateBindings();
		var allTemplateSignatures = root.getAllTemplateSignatures();
		var allTupleTypes = root.getAllTupleTypes();
		var allTypes = root.getAllTypes();
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
			 * by: org.eclipse.ocl.examples.build.xtend.GenerateOCLMetaModel.xtend
			 * and: org.eclipse.ocl.examples.build.GeneratePivotMetaModel.mwe2
			 *
			 * Do not edit it.
			 *
			 * $Id$
			 */
			package	«javaPackageName»;
			
			import java.math.BigInteger;
			import java.util.List;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;
			import org.eclipse.ocl.examples.domain.library.LibraryFeature;
			import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
			import org.eclipse.ocl.examples.pivot.*;
			import org.eclipse.ocl.examples.pivot.Class;
			import org.eclipse.ocl.examples.pivot.Package;
			import org.eclipse.ocl.examples.pivot.manager.PivotStandardLibrary;
			import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
			import org.eclipse.ocl.examples.pivot.resource.ASResourceImpl;
			import org.eclipse.ocl.examples.pivot.resource.OCLASResourceFactory;
			import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
			
			/**
			 * This is the «uri» Pivot Model of the Pivot Model
			 * auto-generated from «sourceFile».
			 * It facilitates efficient model loading without the overheads of model reading.
			 */
			@SuppressWarnings({"nls", "unused"})
			public class «javaClassName» extends ASResourceImpl
			{
				/**
				 *	The URI of this Standard Library.
				 */
				public static final @NonNull String PIVOT_URI = "«uri»";
			
				public static @NonNull Package create(@NonNull PivotStandardLibrary standardLibrary, @NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {
					«javaClassName» resource = new «javaClassName»(DomainUtil.nonNullEMF(URI.createURI(PIVOT_URI)));
					Contents contents = new Contents(standardLibrary, name, nsPrefix, nsURI);
					resource.getContents().add(contents.root);
					return contents.metamodel;
				}
			
				protected OCLMetaModel(@NonNull URI uri) {
					super(uri, OCLASResourceFactory.INSTANCE);
				}
			
				protected static class LibraryContents extends AbstractContents
				{
					protected final @NonNull PivotStandardLibrary standardLibrary;
			
					protected LibraryContents(@NonNull PivotStandardLibrary standardLibrary) {
						this.standardLibrary = standardLibrary;
					}
				}

				protected static class Contents extends LibraryContents
				{
					protected final @NonNull Root «root.getPrefixedSymbolName("root")»;
					protected final @NonNull Package «pkg.getPrefixedSymbolName("metamodel")»;
					«allTypes.defineCollectionTypeName("Bag")»
					
					«allTypes.definePrimitiveTypeName("Boolean")»
					
					«allTypes.defineCollectionTypeName("Collection")»
					
					«allTypes.definePrimitiveTypeName("Integer")»
					
					protected final @NonNull Class _OclElement = standardLibrary.getOclElementType();
					
					«allTypes.defineCollectionTypeName("OrderedSet")»
					
					«allTypes.definePrimitiveTypeName("Real")»
					
					«allTypes.defineCollectionTypeName("Sequence")»
					
					«allTypes.defineCollectionTypeName("Set")»
					
					«allTypes.definePrimitiveTypeName("String")»
					
					«allTypes.definePrimitiveTypeName("UnlimitedNatural")»
					
					«allTypes.defineCollectionTypeName("UniqueCollection")»

					protected Contents(@NonNull PivotStandardLibrary standardLibrary, @NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {
						super(standardLibrary);
						«root.getSymbolName()» = createRoot("«pkg.name»", "«pkg.nsURI»");
						«pkg.getSymbolName()» = createPackage(name, nsPrefix, nsURI);
						installPackages();
						installOclTypes();
						«IF allPrimitiveTypes.size() > 0»
						installPrimitiveTypes();
						«ENDIF»
						«IF allEnumerations.size() > 0»
						installEnumerations();
						«ENDIF»
						installParameterTypes();
						«IF allCollectionTypes.size() > 0»
						installCollectionTypes();
						«ENDIF»
						«IF allMetaclasses.size() > 0»
						installMetaclasses();
						«ENDIF»
						«IF allLambdaTypes.size() > 0»
						installLambdaTypes();
						«ENDIF»
						«IF allTupleTypes.size() > 0»
						installTupleTypes();
						«ENDIF»
						installOperations();
						installIterations();
						installProperties();
						«IF allTemplateSignatures.size() > 0»
						installTemplateSignatures();
						«ENDIF»
						«IF allTemplateBindings.size() > 0»
						installTemplateBindings();
						«ENDIF»
						«IF allPrecedences.size() > 0»
						installPrecedences();
						«ENDIF»
						installComments();
					}
				
					«pkg.definePackages()»

					«pkg.declareOclTypes()»
					«IF allPrimitiveTypes.size() > 0»

					«pkg.declarePrimitiveTypes()»
					«ENDIF»
					«IF allEnumerations.size() > 0»

					«pkg.declareEnumerations()»
					«ENDIF»

					«pkg.declareParameterTypes()»
					«IF allCollectionTypes.size() > 0»

					«pkg.declareCollectionTypes()»
					«ENDIF»
					«IF allMetaclasses.size() > 0»

					«pkg.declareMetaclasses()»
					«ENDIF»
					«IF allTupleTypes.size() > 0»

					«pkg.declareTupleTypes()»
					«ENDIF»

					«pkg.defineOclTypes()»

					«pkg.definePrimitiveTypes()»
					«IF allEnumerations.size() > 0»

					«pkg.defineEnumerations()»
					«ENDIF»

					«pkg.defineParameterTypes()»
					«IF allCollectionTypes.size() > 0»

					«pkg.defineCollectionTypes()»
					«ENDIF»
					«IF allMetaclasses.size() > 0»

					«pkg.defineMetaclasses()»
					«ENDIF»
					«IF allTupleTypes.size() > 0»

					«pkg.defineTupleTypes()»
					«ENDIF»	
					«IF allLambdaTypes.size() > 0»

					«pkg.defineLambdaTypes()»	
					«ENDIF»	

					«pkg.defineOperations()»

					«pkg.defineIterations()»	

					«pkg.declareProperties()»

					«pkg.defineProperties()»
					«IF allTemplateSignatures.size() > 0»

					«pkg.defineTemplateSignatures()»
					«ENDIF»
					«IF allTemplateBindings.size() > 0»

					«pkg.defineTemplateBindings()»
					«ENDIF»
					«IF allPrecedences.size() > 0»

					«pkg.definePrecedences()»
					«ENDIF»

					«pkg.defineComments()»
				}
			}
		'''
	}

	protected def String getEcoreLiteral(Type elem) {
		return NameQueries.getEcoreLiteral(elem);
	}

	protected def String getEcoreLiteral(EnumerationLiteral elem) {
		return NameQueries.getEcoreLiteral(elem);
	}

	protected def String getEcorePropertyLiteral(Property property) {
		return NameQueries.getEcoreLiteral(property);
	}

	override protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		var ResourceSet resourceSet = DomainUtil.nonNullState(getResourceSet());
		var StandaloneProjectMap projectMap = StandaloneProjectMap.getAdapter(resourceSet);
		var IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(projectName);
		var IPackageDescriptor packageDescriptor = projectDescriptor.getPackageDescriptor(URI.createURI(PivotPackage.eNS_URI));
		packageDescriptor.setUseModel(true, resourceSet.packageRegistry);
		var URI inputURI = projectDescriptor.getPlatformResourceURI(modelFile);
		var File outputFolder = projectDescriptor.getLocationFile(javaFolder + '/' + javaPackageName.replace('.', '/'));
		OCLstdlib.install();
		log.info("Loading Pivot Model '" + inputURI);
		try {
			var MetaModelManager metaModelManager = MetaModelManager.getAdapter(resourceSet);
			NameQueries.setMetaModelManager(metaModelManager);
			var Resource ecoreResource = DomainUtil.nonNullState(resourceSet.getResource(inputURI, true));
			MetaModelManagerResourceAdapter.getAdapter(ecoreResource, metaModelManager);
			var String ecoreErrorsString = PivotUtil.formatResourceDiagnostics(DomainUtil.nonNullEMF(ecoreResource.getErrors()), "Loading " + inputURI, "\n");
			if (ecoreErrorsString != null) {
				issues.addError(this, ecoreErrorsString, null, null, null);
				return;
			}
			var Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, metaModelManager);
			var Root pivotRoot = ecore2Pivot.getPivotRoot();
			var Resource asResource = pivotRoot.eResource();
			var String pivotErrorsString = PivotUtil.formatResourceDiagnostics(DomainUtil.nonNullEMF(asResource.getErrors()), "Converting " + inputURI, "\n");
				if (pivotErrorsString != null) {
					issues.addError(this, pivotErrorsString, null, null, null);
					return;
				}
			sourceFile = "/" + projectName + "/" + modelFile;
			if (asResource == null) {
				return;
			}
			var EObject pivotModel = asResource.getContents().get(0);
			var ASSaver saver = new ASSaver(asResource);
			var Package orphanage = saver.localizeSpecializations();
			if ((orphanage != null) && (pivotModel instanceof Root)) {
				(pivotModel as Root).getNestedPackage().add(orphanage);
			}
			var String fileName = outputFolder + "/" + javaClassName + ".java";
			log.info("Generating '" + fileName + "'");
			var String metaModel = generateMetamodel(pivotModel as Root);
			var MergeWriter fw = new MergeWriter(fileName);
			fw.append(metaModel);
			fw.close();
			var String saveFile = "/" + projectName + "/" + modelFile.replace("model", "model-gen").replace("ecore", "oclas");
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
	 * The projectName relative path to the Java generated source folder (e.g. "emf-src")
	 */
	public def void setJavaFolder(String javaFolder) {
		this.javaFolder = javaFolder;
	}
}