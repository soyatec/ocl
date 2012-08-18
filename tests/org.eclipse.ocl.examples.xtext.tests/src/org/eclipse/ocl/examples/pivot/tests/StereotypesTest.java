/**
 * <copyright>
 * 
 * Copyright (c) 2006,2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 296409, 297541
 *
 * </copyright>
 *
 * $Id: IteratorsTest.java,v 1.9 2011/05/20 15:27:16 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

import java.util.Iterator;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.PivotResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * Tests for stereotype expressions.
 */
@SuppressWarnings("nls")
public class StereotypesTest extends PivotTestSuite
{
	PivotResource pivotResource;
    Type helloClass;
    Type worldClass;
    Type englishClass;
	
    @Override
    protected void setUp() throws Exception {
        super.setUp();
		StandardLibraryContribution.REGISTRY.put(MetaModelManager.DEFAULT_OCL_STDLIB_URI, new OCLstdlib.Cloner());
		ProjectMap.getAdapter(resourceSet);
		OCL.initialize(resourceSet);
		String problem = UML2Pivot.initialize(resourceSet);
		assertNull(problem);
		URI testModelURI = getTestModelURI("model/HelloWorld.uml");
        Resource umlResource = resourceSet.getResource(testModelURI, true);
        pivotResource = ocl.uml2pivot(umlResource);
        Root root = (Root) pivotResource.getContents().get(0);
        org.eclipse.ocl.examples.pivot.Package modelPackage = PivotUtil.getNamedElement(root.getNestedPackage(), "Model");
        helloClass = PivotUtil.getNamedElement(modelPackage.getOwnedType(), "Hello");
        worldClass = PivotUtil.getNamedElement(modelPackage.getOwnedType(), "World");
        PackageServer englishProfile = metaModelManager.getPackageManager().getPackageByURI("http://www.eclipse.org/ocl/examples/EnglishProfile");
        englishClass = englishProfile.getMemberType("EnglishClass");
    }

    /**
     * Tests the generic iterate() iterator.
     */
    public void test_stereotypeNavigation() {
    	assertQueryEquals2(helloClass, englishClass, "self.base_EnglishClass");
    }
    
	protected Object assertQueryEquals2(Object context, Object expected, String expression) {
		try {
			Value expectedValue = expected instanceof Value ? (Value)expected : valueFactory.valueOf(expected);
//			typeManager.addLockedElement(expectedValue.getType());
			Value value = evaluate2(helper, context, expression);
//			String expectedAsString = String.valueOf(expected);
//			String valueAsString = String.valueOf(value);
			assertEquals(expression, expectedValue, value);
			// FIXME Following is probably redundant
			if (expectedValue instanceof OrderedSetValue) {
				assertTrue(expression, value instanceof OrderedSetValue);
				Iterator<?> es = ((OrderedSetValue)expectedValue).iterator();
				Iterator<?> vs = ((OrderedSetValue)value).iterator();
				while (es.hasNext()) {
					Object e = es.next();
					Object v = vs.next();
					assertEquals(expression, e, v);
				}
			}
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	protected Value evaluate2(OCLHelper aHelper, Object context,
            String expression) throws ParserException {
		if (context instanceof Type) {
		   	Metaclass metaclass = metaModelManager.getMetaclass((Type)context);
			aHelper.setContext(metaclass);
		}
		else if (context instanceof EObject) {
			EClass eClass = ((EObject)context).eClass();
			Type pivotType = metaModelManager.getPivotType(eClass.getName());
			if (pivotType == null) {
				Resource resource = eClass.eResource();
				Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(resource, metaModelManager);
				pivotType = ecore2Pivot.getCreated(Type.class, eClass);
			}
			aHelper.setContext(pivotType);
		}
		ExpressionInOCL query = aHelper.createQuery(expression);
//        @SuppressWarnings("unused")
//		String s = query.toString();
        try {
        	return ocl.evaluate(context, query);
        } finally {
			metaModelManager.getPivotResourceSet().getResources().remove(query.eResource());
		}
    }
}
