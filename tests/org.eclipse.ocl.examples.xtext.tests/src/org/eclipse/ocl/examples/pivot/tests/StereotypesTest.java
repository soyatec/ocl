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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.PivotResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * Tests for stereotype expressions.
 */
@SuppressWarnings("nls")
public class StereotypesTest extends PivotTestSuite
{
	public class InternationalizedMetamodel
	{
		PivotResource pivotResource;
	    Type englishClass;
	    Type frenchClass;
	    Type germanClass;
	    Type plainClass;
	    Type englishClassInEnglish;
	    Type inEnglishStereotype;
	    Type inFrenchStereotype;
	    Type inGermanStereotype;
	    
	    public InternationalizedMetamodel() throws ParserException {
			URI testModelURI = getTestModelURI("model/InternationalizedClasses.uml");
	        Resource umlResource = resourceSet.getResource(testModelURI, true);
	        pivotResource = ocl.uml2pivot(umlResource);
	        Root root = (Root) pivotResource.getContents().get(0);
	        org.eclipse.ocl.examples.pivot.Package modelPackage = PivotUtil.getNamedElement(root.getNestedPackage(), "Model");
	        englishClass = PivotUtil.getNamedElement(modelPackage.getOwnedType(), "EnglishClass");
	        frenchClass = PivotUtil.getNamedElement(modelPackage.getOwnedType(), "FrenchClass");
	        germanClass = PivotUtil.getNamedElement(modelPackage.getOwnedType(), "GermanClass");
	        plainClass = PivotUtil.getNamedElement(modelPackage.getOwnedType(), "PlainClass");
	        PackageServer profile = metaModelManager.getPackageManager().getPackageByURI("http://www.eclipse.org/ocl/examples/Internationalized");
	        inEnglishStereotype = profile.getMemberType("InEnglish");
	        inFrenchStereotype = profile.getMemberType("InFrench");
	        inGermanStereotype = profile.getMemberType("InGerman");
	        englishClassInEnglish = PivotUtil.getNamedElement(englishClass.getExtension(), "EnglishClass$InEnglish");
	    }
	}

	InternationalizedMetamodel mm = null;
	
    @Override
    protected void setUp() throws Exception {
        super.setUp();
		ProjectMap.getAdapter(resourceSet);
		OCL.initialize(resourceSet);
		String problem = UML2Pivot.initialize(resourceSet);
		assertNull(problem);
		mm = new InternationalizedMetamodel();
    }

    @Override
	protected void tearDown() throws Exception {
		mm = null;
	}

	/**
     * Tests naigations using base_XXX and extension_YYY.
     */
    public void test_stereotypeNavigation() {
//
    	assertQueryEquals(mm.englishClass, "EnglishClass", "self.name");
    	assertQueryEquals(mm.englishClass, metaModelManager.getMetaclass(mm.englishClassInEnglish), "self.extension_InEnglish");
    	assertQueryEquals(mm.englishClassInEnglish, metaModelManager.getMetaclass(mm.englishClass), "self.base_Class");
    	assertQueryEquals(mm.englishClass, "EnglishClass$InEnglish", "self.extension_InEnglish.instanceType.name");
    	assertSemanticErrorQuery2(mm.englishClass, "self.extension_InGerman", OCLMessages.UnresolvedProperty_ERROR_, "extension_InGerman", "Metaclass(Model::EnglishClass)");
    	assertSemanticErrorQuery2(mm.englishClass, "self.extension_InEnglish.extension_InEnglish", OCLMessages.UnresolvedProperty_ERROR_, "extension_InEnglish", "Metaclass(Model::EnglishClass$InEnglish)");
    	assertQueryEquals(mm.englishClass, metaModelManager.getMetaclass(mm.englishClass), "self.extension_InEnglish.base_Class");
    	assertQueryEquals(mm.englishClassInEnglish, metaModelManager.getMetaclass(mm.englishClassInEnglish), "self.base_Class.extension_InEnglish");
    	assertQueryTrue(mm.englishClass, "extension_InEnglish.base_Class = oclType()");
    	assertQueryTrue(mm.englishClassInEnglish,  "base_Class.extension_InEnglish = oclType()");
    	assertSemanticErrorQuery2(mm.frenchClass, "self.text", OCLMessages.UnresolvedProperty_ERROR_, "text", "Metaclass(Model::FrenchClass)");
    	assertQueryEquals(mm.frenchClass, "Merci", "extension_InFrench.instanceType.ownedAttribute->any(name='text').default");
    	assertQueryTrue(mm.frenchClass, "extension_InFrench.instanceType.ownedAttribute->any(name='text').default = 'Merci'");
    }

    /**
     * Tests allInstances in a stereotyped context.
     */
    public void test_stereotyped_allInstances_382981() {
//
    	assertQueryEquals(mm.englishClass, "EnglishClass", "EnglishClass.allInstances()");
    }

    /**
     * Tests getAppliedStereotypes.
     */
    public void test_MDT_UML2_operations_382978() {
//
    	assertQueryEquals(mm.englishClass, "EnglishClass", "self.getAppliedStereotypes()");
    }
}
