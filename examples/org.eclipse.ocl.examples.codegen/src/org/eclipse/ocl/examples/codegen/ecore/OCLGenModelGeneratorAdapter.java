/**
 * <copyright>
 * 
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id$
 */
package org.eclipse.ocl.examples.codegen.ecore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.acceleo.engine.generation.strategy.IAcceleoGenerationStrategy;
import org.eclipse.acceleo.engine.generation.strategy.PreviewStrategy;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.codegen.tables.Model2tables;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;

public class OCLGenModelGeneratorAdapter extends GenBaseGeneratorAdapter
	{
		public OCLGenModelGeneratorAdapter(OCLGeneratorAdapterFactory generatorAdapterFactory) {
			super(generatorAdapterFactory);
		}

		protected void convertConstraintToOperation(Ecore2Pivot ecore2pivot, EClassifier eClassifier, String key, String body, String message) {
			Type pType = ecore2pivot.getCreated(Type.class, eClassifier);
			List<Constraint> ownedRules = pType.getOwnedRules();
			for (Constraint rule : ownedRules) {
				if (rule.getStereotype().equals(UMLReflection.INVARIANT) && rule.getName().equals(key)) {
					EOperation eOperation = Pivot2Ecore.createConstraintEOperation(rule, "invariant_" + rule.getName());
					((EClass)eClassifier).getEOperations().add(eOperation);
					ecore2pivot.addCreated(eOperation, rule);
					EcoreUtil.setAnnotation(eOperation, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT, "body", body);
					if (message != null) {
						EcoreUtil.setAnnotation(eOperation, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT, "body" + PivotConstants.MESSAGE_ANNOTATION_DETAIL_SUFFIX, message);
					}
				}
			}
		}

		protected void convertConstraintsToOperations(MetaModelManager metaModelManager, GenModel genModel) {
			List<GenPackage> genPackages = genModel.getAllGenPackagesWithClassifiers();
			for (GenPackage genPackage : genPackages) {
				EPackage ecorePackage = genPackage.getEcorePackage();
				Ecore2Pivot ecore2pivot = Ecore2Pivot.getAdapter(ecorePackage.eResource(), metaModelManager);
				for (GenClass genClass : genPackage.getGenClasses()) {
					EClass eClass = genClass.getEcoreClass();
					EClassifier eClassifier = eClass;
					EAnnotation eAnnotation = eClassifier.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
					if (eAnnotation != null) {
						EMap<String, String> details = eAnnotation.getDetails();
						for (String key : details.keySet()) {
							if (!key.endsWith(PivotConstants.MESSAGE_ANNOTATION_DETAIL_SUFFIX)) {
								String expression = details.get(key);
								String messageExpression = details.get(key + PivotConstants.MESSAGE_ANNOTATION_DETAIL_SUFFIX);
								convertConstraintToOperation(ecore2pivot, eClassifier, key, expression, messageExpression);
							}
						}
						eClassifier.getEAnnotations().remove(eAnnotation);
					}
					eAnnotation = eClassifier.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI_LPG);
					if (eAnnotation != null) {
						EMap<String, String> details = eAnnotation.getDetails();
						for (String key : details.keySet()) {
							convertConstraintToOperation(ecore2pivot, eClassifier, key, details.get(key), details.get(key + PivotConstants.MESSAGE_ANNOTATION_DETAIL_SUFFIX));
						}
						eClassifier.getEAnnotations().remove(eAnnotation);
					}
				    eAnnotation = eClassifier.getEAnnotation(EcorePackage.eNS_URI);
				    if (eAnnotation != null)
				    {
				      eAnnotation.getDetails().remove("constraints");
				    }
					genClass.initialize(eClass);
				}
			}
		}

		protected Map<String, String> createJavaBodies(GenModel genModel) {
			Map<String, String> results = new HashMap<String, String>();
		  	try {
	            File folder = new File("/");       
	            List<String> arguments = new ArrayList<String>();
				Ocl2java4genmodel generator = new Ocl2java4genmodel(genModel, folder, arguments)
				{
				    public IAcceleoGenerationStrategy getGenerationStrategy() {
				        return new PreviewStrategy();
				    }
				};
		        Map<String, String> result = generator.generate(new BasicMonitor());
		        for (String key : result.keySet()) {
		        	String key2 = "/" + key.replace('\\', '/');		// BUG 359139
					String value = result.get(key);
					results.put(key2, value);
		        }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return results;
		}

		protected void createDispatchTables(GenModel genModel, Monitor monitor) {
		  	try {
		        IWorkspace workspace = ResourcesPlugin.getWorkspace();
	            IProject modelProject = workspace.getRoot().getProject(genModel.getModelProjectDirectory());
	            IPath javaSource = new Path(genModel.getModelDirectory());
	            IFolder folder = modelProject.getParent().getFolder(javaSource);
	            java.net.URI locationURI = folder.getLocationURI();
	            String rawPath = locationURI.getRawPath();
	            List<String> arguments = new ArrayList<String>();
	            Model2tables generator = new Model2tables(genModel, new File(rawPath), arguments);
		        generator.generate(monitor);
		        folder.refreshLocal(IResource.DEPTH_INFINITE, BasicMonitor.toIProgressMonitor(CodeGenUtil.createMonitor(monitor, 1)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		protected Diagnostic doPreGenerate(Object object, Object projectType) {
			GenModel genModel = (GenModel) object;
			Resource genResource = genModel.eResource();
			MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.getAdapter(genResource.getResourceSet(), null);
			MetaModelManager metaModelManager = adapter.getMetaModelManager();
			convertConstraintsToOperations(metaModelManager, genModel);
		    Map<String, String> results = createJavaBodies(genModel);			
			installJavaBodies(metaModelManager, genModel, results);
			return super.doPreGenerate(object, projectType);
		}

		@Override
		protected Diagnostic generateModel(Object object, Monitor monitor) {
			GenModel genModel = (GenModel) object;
		    monitor.beginTask("", 2);
		    monitor.subTask("Generating Dispatch Tables");
			createDispatchTables(genModel, monitor);
		    monitor.worked(1);
			return super.generateModel(object, monitor);
		}

		protected void installJavaBodies(MetaModelManager metaModelManager, GenModel genModel, Map<String, String> results) {
			List<GenPackage> genPackages = genModel.getAllGenPackagesWithClassifiers();
			for (GenPackage genPackage : genPackages) {
				EPackage ecorePackage = genPackage.getEcorePackage();
				Ecore2Pivot ecore2pivot = Ecore2Pivot.getAdapter(ecorePackage.eResource(), metaModelManager);
				for (GenClass genClass : genPackage.getGenClasses()) {
					EClass eClass = genClass.getEcoreClass();
					for (EOperation eOperation : eClass.getEOperations()) {
						installOperation(ecore2pivot, eOperation, results);
					}
					for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
						installProperty(ecore2pivot, eFeature, results);
					}
				}
			}
		}

		protected void installOperation(Ecore2Pivot ecore2pivot, EOperation eOperation, Map<String, String> results) {
			Element pOperation = ecore2pivot.getCreated(Element.class, eOperation);
			String fragmentURI;
			if (pOperation instanceof Operation) {
				fragmentURI = EcoreUtil.getURI(pOperation).fragment().toString();
			}
			else {
				Constraint constraint = (Constraint) pOperation;
				fragmentURI = EcoreUtil.getURI(constraint.eContainer()).fragment().toString() + "==" + constraint.getName();
			}
			String body = results.get(fragmentURI);
			if (body != null) {
				EcoreUtil.setAnnotation(eOperation, GenModelPackage.eNS_URI, "body", body);
			}
		}

		protected void installProperty(Ecore2Pivot ecore2pivot, EStructuralFeature eFeature, Map<String, String> results) {
			Property pProperty = ecore2pivot.getCreated(Property.class, eFeature);
			String fragmentURI = EcoreUtil.getURI(pProperty).fragment().toString();
			String body = results.get(fragmentURI);
			if (body != null) {
				EcoreUtil.setAnnotation(eFeature, GenModelPackage.eNS_URI, "body", body);
			}
		}
	}