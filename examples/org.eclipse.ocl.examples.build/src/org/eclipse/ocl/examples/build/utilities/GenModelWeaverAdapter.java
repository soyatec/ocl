/**
 * <copyright>
 * 
 * Copyright (c) 2012,2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.build.utilities;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.StringBufferLog;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;

public class GenModelWeaverAdapter extends GenBaseGeneratorAdapter
{
	private static final Logger logger = Logger.getLogger(GenModelWeaverAdapter.class);
 //	public static final @NonNull String OCL_GENMODEL_URI = "http://www.eclipse.org/OCL/GenModel";
	
	public GenModelWeaverAdapter(@NonNull GenModelWeaverAdapterFactory generatorAdapterFactory) {
		super(generatorAdapterFactory);
	}

	@Override
	protected Diagnostic doPreGenerate(Object object, Object projectType) {
		assert object != null;
		GenModel genModel = (GenModel) object;
	    try {
			if (projectType == MODEL_PROJECT_TYPE) {//&& !useDelegates(genModel) && (hasDelegates(genModel) || hadDelegates.contains(genModel))) {
//				List<String> modelPluginVariables = genModel.getModelPluginVariables();
//				if (!modelPluginVariables.contains(LibraryConstants.PLUGIN_ID)) {
//					modelPluginVariables.add(LibraryConstants.PLUGIN_ID);
//				}				
//				if (!modelPluginVariables.contains(PivotPlugin.PLUGIN_ID)) {	// FIXME delete me BUG 401862
//					modelPluginVariables.add(PivotPlugin.PLUGIN_ID);
//				}				
//				if (!modelPluginVariables.contains("org.eclipse.ocl.examples.codegen")) {	// FIXME delete me BUG 401862
//					modelPluginVariables.add("org.eclipse.ocl.examples.codegen");
//				}				
//				if (useNullAnnotations(genModel) && !modelPluginVariables.contains("org.eclipse.jdt.annotation")) {
//					modelPluginVariables.add("org.eclipse.jdt.annotation");
//				}
				for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
					createImportManager(genPackage.getReflectionPackageName(), genPackage.getFactoryInterfaceName() + AbstractGenModelHelper.TABLES_CLASS_SUFFIX);	// Only used to suppress NPE
				}
				GenAnnotation genAnnotation = genModel.getGenAnnotation("http://www.eclipse.org/OCL/GenModel/WeavePatternWeaver");
				if (genAnnotation != null) {
					for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
						weaveVisitorPattern(genPackage, genAnnotation.getDetails());
					}
				}
				Resource genResource = genModel.eResource();
				ResourceSet resourceSet = genResource.getResourceSet();
				if (resourceSet == null) {
					throw new NullPointerException("No ResourceSet for genmodel");
				}
				MetaModelManager metaModelManager = MetaModelManager.findAdapter(resourceSet);
				MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
				metaModelManager = adapter.getMetaModelManager();
//				convertConstraintsToOperations(metaModelManager, genModel);
//			    Map<String, String> results = createFeatureBodies(genModel);			
//				installJavaBodies(metaModelManager, genModel, results);
//				pruneDelegates(genModel);
			}
		} catch (Exception e) {
			BasicDiagnostic thisDiagnostic = new BasicDiagnostic(Diagnostic.ERROR, getClass().getPackage().getName(), 0, "Failed to pre-generate " + genModel.getModelPluginID() + " constraints", new Object[]{e});
			Diagnostic thatDiagnostic = super.doPreGenerate(object, projectType);
			if (thatDiagnostic.getSeverity() == Diagnostic.OK) {
				return thisDiagnostic;
			}
			else {
				thatDiagnostic.getChildren().add(thisDiagnostic);
				return thatDiagnostic;
			}
		}
		return super.doPreGenerate(object, projectType);
	}

	private void weaveVisitorPattern(GenPackage genPackage, EMap<String, String> details) {
		String uri = "platform:/resource/org.eclipse.ocl.examples.build/src/org/eclipse/ocl/examples/build/qvto/VisitorPatternWeaver.qvto";
		URI txURI = URI.createURI(uri, true);
		logger.info("Loading '" + txURI + "'");
		TransformationExecutor transformationExecutor = new TransformationExecutor(txURI);
		Diagnostic diagnostic = transformationExecutor.loadTransformation();
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			StringBuilder s = new StringBuilder();
			s.append("Failed to load ");
			s.append(txURI);
			for (Diagnostic child : diagnostic.getChildren()) {
				s.append("\n  " + child.getMessage());
			}
//			issues.addError(this, s.toString(), txURI, null, null);
//			return;
		}
		
//		ResourceSet resourceSet = genPackage.eResource().getResourceSet();
		List<ModelExtent> modelExtents = new ArrayList<ModelExtent>();
		modelExtents.add(new BasicModelExtent(genPackage.getEcorePackage().eResource().getContents()));
		modelExtents.add(new BasicModelExtent(genPackage.getEcorePackage().eResource().getContents()));		// FIXME Base

//		String traceUri = trace != null ? URI.createPlatformResourceURI(trace, true).toString() : null;
		
		
		StringBufferLog qvtoLog = new StringBufferLog();
		try {
			logger.info("Executing transformation '" + uri + "'");
			ExecutionContextImpl executionContext = new ExecutionContextImpl();
			executionContext.setLog(qvtoLog);
//			initializeConfigurationProperties(executionContext);
			executionContext.setConfigProperty("rootVisitorInterfaceName", details.get("rootVisitorInterfaceName"));
			executionContext.setConfigProperty("rootVisitorInterfaceQualifiedName", details.get("rootVisitorInterfaceQualifiedName"));
			executionContext.setConfigProperty("visitorInterfaceName", details.get("visitorInterfaceName"));
			executionContext.setConfigProperty("visitorInterfaceQualifiedName", details.get("visitorInterfaceQualifiedName"));
			executionContext.setConfigProperty("visitableInterfaceName", details.get("visitableInterfaceName"));
			executionContext.setConfigProperty("visitableInterfaceQualifiedName", details.get("visitableInterfaceQualifiedName"));
//			executionContext.setMonitor();
			ExecutionDiagnostic executionDiagnostic = transformationExecutor.execute(executionContext, modelExtents.toArray(new ModelExtent[modelExtents.size()]));
			if (executionDiagnostic.getSeverity() != Diagnostic.OK) {
				StringBuilder s = new StringBuilder();
				s.append("Failed to execute ");
				s.append(txURI);
				s.append(": ");
				s.append(executionDiagnostic.getMessage());
				for (Diagnostic child : diagnostic.getChildren()) {
					s.append("\n  " + child.getMessage());
				}
//				issues.addError(this, s.toString(), txURI, null, null);
//				return;
			}
		} catch (Exception e) {
//			issues.addError(this, "Failed to launch transformation", txURI, e, null);
//			return;
		}
		String qvtoLogContents = qvtoLog.getContents().trim();
		if (qvtoLogContents.length() > 0) {
			logger.info("Log '\n" + qvtoLogContents);
		}
		genPackage.reconcile();
	}
}
