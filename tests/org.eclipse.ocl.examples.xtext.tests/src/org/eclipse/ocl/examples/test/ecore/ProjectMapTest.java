/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 283509, 296409
 *
 * </copyright>
 *
 * $Id: KeywordsTest.java,v 1.3 2011/02/19 12:03:51 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.ecore;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IPackageDescriptor;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IProjectDescriptor;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.tests.TestCaseAppender;
import org.eclipse.ocl.examples.xtext.tests.TestCaseLogger;

/**
 */
public class ProjectMapTest extends TestCase
{
	public static ProjectMap projectMap = new ProjectMap();

/*	protected void doTestProjectMapRegistered(/ *@NonNull* / EPackage modelPackage, @NonNull String modelPath) {
		URI nsURI = URI.createURI(modelPackage.getNsURI());
		URI pluginURI = URI.createPlatformPluginURI(modelPath, true);
		URI resourceURI = URI.createPlatformResourceURI(modelPath, true);
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		ProjectMap projectMap = new ProjectMap();
		projectMap.initializeResourceSet(resourceSet);
//		IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(project);
//		IPackageDescriptor packageDescriptor = projectDescriptor.getPackageDescriptor(nsURI);
		projectMap.configure(resourceSet, StandaloneProjectMap.LoadModelStrategy.INSTANCE, null);
		Resource registeredResource = resourceSet.getResource(nsURI, true);
		assertNull(registeredResource.getResourceSet());		// Registered packages have a private shared resource
		assertEquals(registeredResource.getURI(), nsURI);
		Resource pluginResource = resourceSet.getResource(pluginURI, true);
		Resource projectResource = resourceSet.getResource(resourceURI, true);
		assertEquals(registeredResource, pluginResource);
		assertEquals(registeredResource, projectResource);
		assertNull(registeredResource.getResourceSet());
	} */

/*	protected void doTestProjectMapLocal(@NonNull EPackage ePackage, @NonNull String project, @NonNull String modelPath) {
		ProjectMap.getResourceFactoryRegistry(null).getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		@SuppressWarnings("null")@NonNull URI nsURI = URI.createURI(ePackage.getNsURI());
		@SuppressWarnings("null")@NonNull URI platformPluginURI = URI.createPlatformPluginURI(modelPath, true);
		@SuppressWarnings("null")@NonNull URI platformResourceURI = URI.createPlatformResourceURI(modelPath, true);
		ProjectMap projectMap = new ProjectMap();
		IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(project);
		assert projectDescriptor != null;
		IPackageDescriptor packageDescriptor = projectDescriptor.getPackageDescriptor(nsURI);
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadEPackageStrategy.INSTANCE, null);
			Resource resource = resourceSet.getResource(nsURI, true);
			assertTrue(DomainUtil.isRegistered(resource));	
			assertEquals(nsURI, resource.getURI());
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			assertEquals(resource, pluginResource);
			assertEquals(resource, projectResource);
		}
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadModelStrategy.INSTANCE, null);
			Resource resource = resourceSet.getResource(nsURI, true);
			assertFalse(DomainUtil.isRegistered(resource));	
			assertEquals(platformResourceURI, resource.getURI());
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			assertEquals(resource, pluginResource);
			assertEquals(resource, projectResource);
		}
	} */

	@Override
	protected void setUp() throws Exception {
//		StandaloneProjectMap.PROJECT_MAP_ADD_EPACKAGE.setState(true);
//		StandaloneProjectMap.PROJECT_MAP_ADD_GEN_MODEL.setState(true);
//		StandaloneProjectMap.PROJECT_MAP_ADD_PROJECT.setState(true);
//		StandaloneProjectMap.PROJECT_MAP_ADD_URI_MAP.setState(true);
//		StandaloneProjectMap.PROJECT_MAP_CONFIGURE.setState(true);
//		StandaloneProjectMap.PROJECT_MAP_INSTALL.setState(true);
//		StandaloneProjectMap.PROJECT_MAP_RESOLVE.setState(true);
		super.setUp();
    	TestCaseAppender.INSTANCE.install();
	}

	@Override
	protected void tearDown() throws Exception {
    	TestCaseLogger.INSTANCE.uninstall();
		super.tearDown();
	}

	protected void doTestProjectMap_LoadBoth(/*@NonNull*/ EPackage ePackage, @NonNull String project, @NonNull String modelPath) {
		ProjectMap.getResourceFactoryRegistry(null).getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		@SuppressWarnings("null")@NonNull URI nsURI = URI.createURI(ePackage.getNsURI());
		@SuppressWarnings("null")@NonNull URI platformPluginURI = URI.createPlatformPluginURI(modelPath, true);
		@SuppressWarnings("null")@NonNull URI platformResourceURI = URI.createPlatformResourceURI(modelPath, true);
		IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(project);
		assert projectDescriptor != null;
		IPackageDescriptor packageDescriptor = projectDescriptor.getPackageDescriptor(nsURI);
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadBothStrategy.INSTANCE, null);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			assertTrue(DomainUtil.isRegistered(nsResource));	
			assertFalse(DomainUtil.isRegistered(pluginResource));	
			assertEquals(nsURI, nsResource.getURI());
			assertEquals(platformResourceURI, pluginResource.getURI());
			assertFalse(nsResource == pluginResource);
			assertEquals(pluginResource, projectResource);
		}
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadBothStrategy.INSTANCE, null);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			assertTrue(DomainUtil.isRegistered(nsResource));	
			assertFalse(DomainUtil.isRegistered(pluginResource));	
			assertEquals(nsURI, nsResource.getURI());
			assertEquals(platformResourceURI, pluginResource.getURI());
			assertFalse(nsResource == pluginResource);
			assertEquals(pluginResource, projectResource);
		}
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadBothStrategy.INSTANCE, null);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			assertTrue(DomainUtil.isRegistered(nsResource));	
			assertFalse(DomainUtil.isRegistered(pluginResource));	
			assertEquals(nsURI, nsResource.getURI());
			assertEquals(platformResourceURI, pluginResource.getURI());
			assertFalse(nsResource == pluginResource);
			assertEquals(pluginResource, projectResource);
		}
	}

	protected void doTestProjectMap_LoadDefault(/*@NonNull*/ EPackage ePackage, @NonNull String project, @NonNull String modelPath, boolean selfReferential) {
    	TestCaseAppender.INSTANCE.uninstall();
		TestCaseLogger.INSTANCE.install();
		ProjectMap.getResourceFactoryRegistry(null).getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		@SuppressWarnings("null")@NonNull URI nsURI = URI.createURI(ePackage.getNsURI());
		@SuppressWarnings("null")@NonNull URI platformPluginURI = URI.createPlatformPluginURI(modelPath, true);
		@SuppressWarnings("null")@NonNull URI platformResourceURI = URI.createPlatformResourceURI(modelPath, true);
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			assertTrue(DomainUtil.isRegistered(nsResource));	
			assertEquals(nsURI, nsResource.getURI());
			assertEquals(nsResource, pluginResource);
			assertEquals(nsResource, projectResource);
			assertEquals("Conflicting access to '" + platformResourceURI + "'  or '" + platformPluginURI + "' already accessed as '" + nsURI + "'", TestCaseLogger.INSTANCE.get());
		}
		TestCaseLogger.INSTANCE.clear();
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			assertEquals(selfReferential, DomainUtil.isRegistered(nsResource));	
			assertEquals(selfReferential, !platformResourceURI.equals(nsResource.getURI()));
			assertEquals(selfReferential, nsResource != pluginResource);
			assertEquals(pluginResource, projectResource);
			if (!selfReferential) {
				assertEquals(selfReferential ? "" : "Conflicting access to '" + nsURI + "' already accessed as '" + platformResourceURI + "' or '" + platformPluginURI + "'", TestCaseLogger.INSTANCE.get());
			}
		}
		TestCaseLogger.INSTANCE.clear();
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			assertEquals(selfReferential, DomainUtil.isRegistered(nsResource));	
			assertEquals(selfReferential, !platformResourceURI.equals(nsResource.getURI()));
			assertEquals(selfReferential, nsResource != pluginResource);
			assertEquals(pluginResource, projectResource);
			if (!selfReferential) {
				assertEquals(selfReferential ? "" : "Conflicting access to '" + nsURI + "' already accessed as '" + platformResourceURI + "' or '" + platformPluginURI + "'", TestCaseLogger.INSTANCE.get());
			}
		}
	}

	protected void doTestProjectMap_LoadEPackage(/*@NonNull*/ EPackage ePackage, @NonNull String project, @NonNull String modelPath) {
		ProjectMap.getResourceFactoryRegistry(null).getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		@SuppressWarnings("null")@NonNull URI nsURI = URI.createURI(ePackage.getNsURI());
		@SuppressWarnings("null")@NonNull URI platformPluginURI = URI.createPlatformPluginURI(modelPath, true);
		@SuppressWarnings("null")@NonNull URI platformResourceURI = URI.createPlatformResourceURI(modelPath, true);
		IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(project);
		assert projectDescriptor != null;
		IPackageDescriptor packageDescriptor = projectDescriptor.getPackageDescriptor(nsURI);
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadEPackageStrategy.INSTANCE, null);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			assertTrue(DomainUtil.isRegistered(nsResource));	
			assertEquals(nsURI, nsResource.getURI());
			assertEquals(nsResource, pluginResource);
			assertEquals(nsResource, projectResource);
		}
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadEPackageStrategy.INSTANCE, null);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			assertTrue(DomainUtil.isRegistered(nsResource));	
			assertEquals(nsURI, nsResource.getURI());
			assertEquals(nsResource, pluginResource);
			assertEquals(nsResource, projectResource);
		}
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadEPackageStrategy.INSTANCE, null);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			assertTrue(DomainUtil.isRegistered(nsResource));	
			assertEquals(nsURI, nsResource.getURI());
			assertEquals(nsResource, pluginResource);
			assertEquals(nsResource, projectResource);
		}
	}

	protected void doTestProjectMap_LoadFirst(/*@NonNull*/ EPackage ePackage, @NonNull String project, @NonNull String modelPath, boolean selfReferential) {
		ProjectMap.getResourceFactoryRegistry(null).getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		@SuppressWarnings("null")@NonNull URI nsURI = URI.createURI(ePackage.getNsURI());
		@SuppressWarnings("null")@NonNull URI platformPluginURI = URI.createPlatformPluginURI(modelPath, true);
		@SuppressWarnings("null")@NonNull URI platformResourceURI = URI.createPlatformResourceURI(modelPath, true);
		IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(project);
		assert projectDescriptor != null;
		IPackageDescriptor packageDescriptor = projectDescriptor.getPackageDescriptor(nsURI);
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadFirstStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			assertTrue(DomainUtil.isRegistered(nsResource));	
			assertEquals(nsURI, nsResource.getURI());
			assertEquals(nsResource, pluginResource);
			assertEquals(nsResource, projectResource);
		}
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadFirstStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			assertEquals(selfReferential, DomainUtil.isRegistered(nsResource));	
			assertEquals(selfReferential, !platformResourceURI.equals(nsResource.getURI()));
			assertEquals(selfReferential, nsResource != pluginResource);
			assertEquals(pluginResource, projectResource);
		}
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadFirstStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			assertEquals(selfReferential, DomainUtil.isRegistered(nsResource));	
			assertEquals(selfReferential, !platformResourceURI.equals(nsResource.getURI()));
			assertEquals(selfReferential, nsResource != pluginResource);
			assertEquals(pluginResource, projectResource);
		}
	}

	protected void doTestProjectMap_LoadModel(/*@NonNull*/ EPackage ePackage, @NonNull String project, @NonNull String modelPath, boolean selfReferential) {
		TestCaseAppender.INSTANCE.uninstall();
		TestCaseLogger.INSTANCE.install();
		ProjectMap.getResourceFactoryRegistry(null).getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		@SuppressWarnings("null")@NonNull URI nsURI = URI.createURI(ePackage.getNsURI());
		@SuppressWarnings("null")@NonNull URI platformPluginURI = URI.createPlatformPluginURI(modelPath, true);
		@SuppressWarnings("null")@NonNull URI platformResourceURI = URI.createPlatformResourceURI(modelPath, true);
		IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(project);
		assert projectDescriptor != null;
		IPackageDescriptor packageDescriptor = projectDescriptor.getPackageDescriptor(nsURI);
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadModelStrategy.INSTANCE, null);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			assertFalse(DomainUtil.isRegistered(nsResource));	
			assertEquals(platformResourceURI, nsResource.getURI());
			assertEquals(nsResource, pluginResource);
			assertEquals(nsResource, projectResource);
			assertEquals(selfReferential ? "Attempt to load self-referential '" + nsURI + "' as model replaced by registered EPackage" : "", TestCaseLogger.INSTANCE.get());
		}
		TestCaseLogger.INSTANCE.clear();
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadModelStrategy.INSTANCE, null);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			assertEquals(selfReferential, DomainUtil.isRegistered(nsResource));	
			assertEquals(selfReferential, !platformResourceURI.equals(nsResource.getURI()));
			assertEquals(selfReferential, nsResource != pluginResource);
			assertEquals(pluginResource, projectResource);
			assertEquals(selfReferential ? "Attempt to load self-referential '" + nsURI + "' as model replaced by registered EPackage" : "", TestCaseLogger.INSTANCE.get());
		}
		TestCaseLogger.INSTANCE.clear();
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			projectMap.initializeResourceSet(resourceSet);
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadModelStrategy.INSTANCE, null);
			Resource projectResource = resourceSet.getResource(platformResourceURI, true);
			Resource pluginResource = resourceSet.getResource(platformPluginURI, true);
			Resource nsResource = resourceSet.getResource(nsURI, true);
			assertEquals(selfReferential, DomainUtil.isRegistered(nsResource));	
			assertEquals(selfReferential, !platformResourceURI.equals(nsResource.getURI()));
			assertEquals(selfReferential, nsResource != pluginResource);
			assertEquals(pluginResource, projectResource);
			assertEquals(selfReferential ? "Attempt to load self-referential '" + nsURI + "' as model replaced by registered EPackage" : "", TestCaseLogger.INSTANCE.get());
		}
	}
	
	public void testProjectMap_Ecore_LoadBoth() {					// Almost certainly a workspace project; always a project on Hudson
		@SuppressWarnings("null")@NonNull String project = EcorePackage.class.getPackage().getName();
		String modelPath = project + "/model/Ecore.ecore";
		doTestProjectMap_LoadBoth(EcorePackage.eINSTANCE, project, modelPath);
	}
	
	public void testProjectMap_Ecore_LoadDefault() {					// Almost certainly a workspace project; always a project on Hudson
		@SuppressWarnings("null")@NonNull String project = EcorePackage.class.getPackage().getName();
		String modelPath = project + "/model/Ecore.ecore";
		doTestProjectMap_LoadDefault(EcorePackage.eINSTANCE, project, modelPath, true);
	}
	
	public void testProjectMap_Ecore_LoadEPackage() {					// Almost certainly a workspace project; always a project on Hudson
		@SuppressWarnings("null")@NonNull String project = EcorePackage.class.getPackage().getName();
		String modelPath = project + "/model/Ecore.ecore";
		doTestProjectMap_LoadEPackage(EcorePackage.eINSTANCE, project, modelPath);
	}
	
	public void testProjectMap_Ecore_LoadFirst() {					// Almost certainly a workspace project; always a project on Hudson
		@SuppressWarnings("null")@NonNull String project = EcorePackage.class.getPackage().getName();
		String modelPath = project + "/model/Ecore.ecore";
		doTestProjectMap_LoadFirst(EcorePackage.eINSTANCE, project, modelPath, true);
	}
	
	public void testProjectMap_Ecore_LoadModel() {					// Almost certainly a workspace project; always a project on Hudson
		@SuppressWarnings("null")@NonNull String project = EcorePackage.class.getPackage().getName();
		String modelPath = project + "/model/Ecore.ecore";
		doTestProjectMap_LoadModel(EcorePackage.eINSTANCE, project, modelPath, true);
	}
	
	public void testProjectMap_JavaVMTypes_LoadBoth() {					// Almost certainly a workspace project; always a project on Hudson
		EPackage.Registry.INSTANCE.put(org.eclipse.xtext.common.types.TypesPackage.eNS_URI, org.eclipse.xtext.common.types.TypesPackage.eINSTANCE);
		String project = "org.eclipse.xtext.common.types";
		String modelPath = project + "/model/JavaVMTypes.ecore";
		doTestProjectMap_LoadBoth(org.eclipse.xtext.common.types.TypesPackage.eINSTANCE, project, modelPath);
	}
	
	public void testProjectMap_JavaVMTypes_LoadDefault() {					// Almost certainly a workspace project; always a project on Hudson
		EPackage.Registry.INSTANCE.put(org.eclipse.xtext.common.types.TypesPackage.eNS_URI, org.eclipse.xtext.common.types.TypesPackage.eINSTANCE);
		String project = "org.eclipse.xtext.common.types";
		String modelPath = project + "/model/JavaVMTypes.ecore";
		doTestProjectMap_LoadDefault(org.eclipse.xtext.common.types.TypesPackage.eINSTANCE, project, modelPath, false);
	}
	
	public void testProjectMap_JavaVMTypes_LoadEPackage() {					// Almost certainly a workspace project; always a project on Hudson
		EPackage.Registry.INSTANCE.put(org.eclipse.xtext.common.types.TypesPackage.eNS_URI, org.eclipse.xtext.common.types.TypesPackage.eINSTANCE);
		String project = "org.eclipse.xtext.common.types";
		String modelPath = project + "/model/JavaVMTypes.ecore";
		doTestProjectMap_LoadEPackage(org.eclipse.xtext.common.types.TypesPackage.eINSTANCE, project, modelPath);
	}
	
	public void testProjectMap_JavaVMTypes_LoadFirst() {					// Almost certainly a workspace project; always a project on Hudson
		EPackage.Registry.INSTANCE.put(org.eclipse.xtext.common.types.TypesPackage.eNS_URI, org.eclipse.xtext.common.types.TypesPackage.eINSTANCE);
		String project = "org.eclipse.xtext.common.types";
		String modelPath = project + "/model/JavaVMTypes.ecore";
		doTestProjectMap_LoadFirst(org.eclipse.xtext.common.types.TypesPackage.eINSTANCE, project, modelPath, false);
	}
	
	public void testProjectMap_JavaVMTypes_LoadModel() {					// Almost certainly a workspace project; always a project on Hudson
		EPackage.Registry.INSTANCE.put(org.eclipse.xtext.common.types.TypesPackage.eNS_URI, org.eclipse.xtext.common.types.TypesPackage.eINSTANCE);
		String project = "org.eclipse.xtext.common.types";
		String modelPath = project + "/model/JavaVMTypes.ecore";
		doTestProjectMap_LoadModel(org.eclipse.xtext.common.types.TypesPackage.eINSTANCE, project, modelPath, false);
	}
	
	public void testProjectMap_Pivot_LoadBoth() {					// Almost certainly a workspace project; always a project on Hudson
		@SuppressWarnings("null")@NonNull String project = PivotPackage.class.getPackage().getName();
		String modelPath = project + "/model/Pivot.ecore";
		doTestProjectMap_LoadBoth(PivotPackage.eINSTANCE, project, modelPath);
	}
	
	public void testProjectMap_Pivot_LoadDefault() {					// Almost certainly a workspace project; always a project on Hudson
		@SuppressWarnings("null")@NonNull String project = PivotPackage.class.getPackage().getName();
		String modelPath = project + "/model/Pivot.ecore";
		doTestProjectMap_LoadDefault(PivotPackage.eINSTANCE, project, modelPath, false);
	}
	
	public void testProjectMap_Pivot_LoadEPackage() {					// Almost certainly a workspace project; always a project on Hudson
		@SuppressWarnings("null")@NonNull String project = PivotPackage.class.getPackage().getName();
		String modelPath = project + "/model/Pivot.ecore";
		doTestProjectMap_LoadEPackage(PivotPackage.eINSTANCE, project, modelPath);
	}
	
	public void testProjectMap_Pivot_LoadFirst() {					// Almost certainly a workspace project; always a project on Hudson
		@SuppressWarnings("null")@NonNull String project = PivotPackage.class.getPackage().getName();
		String modelPath = project + "/model/Pivot.ecore";
		doTestProjectMap_LoadFirst(PivotPackage.eINSTANCE, project, modelPath, false);
	}
	
	public void testProjectMap_Pivot_LoadModel() {					// Almost certainly a workspace project; always a project on Hudson
		@SuppressWarnings("null")@NonNull String project = PivotPackage.class.getPackage().getName();
		String modelPath = project + "/model/Pivot.ecore";
		doTestProjectMap_LoadModel(PivotPackage.eINSTANCE, project, modelPath, false);
	}
}
