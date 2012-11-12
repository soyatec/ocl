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

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.common.CodeGenHelper;
import org.eclipse.ocl.examples.codegen.dynamic.GenModelCodeGenHelper;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotTables;
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

	private void assertCgEquals(Object expectedResult, String expression) throws Exception {
		OCL ocl = OCL.newInstance();
		OCLHelper helper = ocl.createOCLHelper();
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		helper.setContext(metaModelManager.getOclAnyType());
		ExpressionInOCL query = helper.createQuery(expression);
		
		CodeGenHelper genModelHelper = getCodeGenHelper(metaModelManager);

		File targetFolder = new File("src-gen");
		String packageName = "test_package";
		String className = getName();
		
		LibraryOperation testInstance = genModelHelper.loadClass(query, targetFolder, packageName, className, true);
		DomainEvaluator evaluator = new EcoreExecutorManager(metaModelManager.getOclAnyType(), PivotTables.LIBRARY);
		OperationCallExp callExp = PivotFactory.eINSTANCE.createOperationCallExp();
		callExp.setType(query.getType());
		Object result = testInstance.evaluate(evaluator, callExp, testInstance);
        assertEquals(expectedResult, result);
	}

	public CodeGenHelper getCodeGenHelper(@NonNull MetaModelManager metaModelManager) {
		URI genModelURI = URI.createPlatformResourceURI(
				"/org.eclipse.ocl.examples.pivot/model/Pivot.merged.genmodel",
				true);
		ResourceSet resourceSet = getResourceSet();
		Resource genModelResource = resourceSet.getResource(genModelURI, true);
		String errorsString = PivotUtil.formatResourceDiagnostics(
				genModelResource.getErrors(), "Loading " + genModelURI, "\n");
		if (errorsString != null) {
			// issues.addError(this, errorsString, null, null, null);
			return null;
		}
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
		return new GenModelCodeGenHelper(genModel,metaModelManager);
	}

	public ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			StandaloneProjectMap projectMap = new StandaloneProjectMap();
			projectMap.initializeResourceSet(resourceSet);
			resourceSet.getPackageRegistry().put(org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eNS_URI, org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eINSTANCE);
			resourceSet.getPackageRegistry().put(org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage.eNS_URI, org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage.eINSTANCE);
		}
		return resourceSet;
	}
	
	public void setUp() throws Exception {
		super.setUp();
		EssentialOCLStandaloneSetup.doSetup();
		OCLstdlib.install();
	}

	public void testFalse() throws Exception, IllegalArgumentException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
		assertCgEquals(Boolean.FALSE, "false");
	}

	public void testSum() throws Exception, IllegalArgumentException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
		assertCgEquals(ValuesUtil.integerValueOf(3), "1+2");
	}

	public void testTrue() throws Exception, IllegalArgumentException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
		assertCgEquals(Boolean.TRUE, "true");
	}
}
