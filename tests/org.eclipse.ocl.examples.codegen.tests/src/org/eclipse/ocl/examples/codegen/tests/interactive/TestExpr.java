/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.codegen.tests.interactive;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.codegen.common.GenModelCodeGenHelper;
import org.eclipse.ocl.examples.codegen.expression.Ast2class;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLStandaloneSetup;
//import org.apache.log4j.Logger;

/**
 * Invokes genmodel with an OCL2Java adapter for debug purposes.
 */
public class TestExpr extends TestCase
{
//	private Logger log = Logger.getLogger(getClass());	
	private ResourceSet resourceSet = null;	
//	private boolean genOCLstdlib = false;	
//	protected String genModelFile;

	private void assertCgEquals(Object expectedResult, String expression) throws ParserException, IOException {
		OCL ocl = OCL.newInstance();
		OCLHelper helper = ocl.createOCLHelper();
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		helper.setContext(metaModelManager.getOclAnyType());
		ExpressionInOCL query = helper.createQuery(expression);
		File targetFolder = new File("src-gen/test");
		
		
		
		URI genModelURI = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.pivot/model/Pivot.merged.genmodel", true);
		ResourceSet resourceSet = getResourceSet();
		Resource genModelResource = resourceSet.getResource(genModelURI, true);
		String errorsString = PivotUtil.formatResourceDiagnostics(genModelResource.getErrors(), "Loading " + genModelURI, "\n");
		if (errorsString != null) {
//			issues.addError(this, errorsString, null, null, null);
			return;
		}
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
		
		
		
		
		List<Object> arguments = new ArrayList<Object>();
		arguments.add(new GenModelCodeGenHelper(genModel, metaModelManager));
		arguments.add("test_package");
		arguments.add("TestClass");
		Ast2class ast2class = new Ast2class(query, targetFolder, arguments);
		ast2class.doGenerate(null);
	}

	public ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			StandaloneProjectMap projectMap = new StandaloneProjectMap();
			projectMap.initializeResourceSet(resourceSet);
			resourceSet.getPackageRegistry().put(org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eNS_URI, org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eINSTANCE);
			resourceSet.getPackageRegistry().put(org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage.eNS_URI, org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage.eINSTANCE);
//			Resource r = resourceSet.getResource(URI.createPlatformResourceURI("/org.eclipse.ocl.examples.codegen/model/OCL4Acceleo.ecore", true), true);
//			((ResourceSetImpl)resourceSet).getURIResourceMap().put(URI.createURI(((EPackage)r.getContents().get(0)).getNsURI()), r);
		}
		return resourceSet;
	}
	
	public void setUp() throws Exception {
		super.setUp();
		EssentialOCLStandaloneSetup.doSetup();
		OCLstdlib.install();
	}

	public void testTrue() throws ParserException, IOException {
		assertCgEquals(Boolean.TRUE, "true");
	}
}
