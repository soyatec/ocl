/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.internal.options.CommonOptions;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.validation.DomainSubstitutionLabelProvider;
import org.eclipse.ocl.examples.domain.values.Bag;
import org.eclipse.ocl.examples.domain.values.impl.BagImpl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.completeocl.ui.commands.LoadCompleteOCLResourceHandler.Helper;
import org.eclipse.ocl.examples.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.ocl.examples.xtext.oclinecore.validation.OCLinEcoreEObjectValidator;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;

/**
 * Tests that OCL for model validation works.
 */
public class ValidateTests extends XtextTestCase
{	
	public static void checkValidationDiagnostics(EObject testInstance, int severity, String... expectedMessage) {
		Bag<String> expectedMessages = new BagImpl<String>();
		for (String message : expectedMessage) {
			expectedMessages.add(message);
		}
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(testInstance, validationContext);
		Bag<String> actualMessages = new BagImpl<String>();
		for (Diagnostic diagnostic : diagnostics.getChildren()) {
			assertEquals(severity, diagnostic.getSeverity());
			actualMessages.add(diagnostic.getMessage());
		}
		String s = formatMessageDifferences(expectedMessages, actualMessages);
		if (s != null) {
			fail("Inconsistent validation: (expected/actual) message" + s);
		}
	}	

	@SuppressWarnings("null")
	public Resource doLoadOCLinEcore(OCL ocl, String stem) throws IOException {
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		String inputName = stem + ".oclinecore";
		String ecoreName = stem + ".ecore";
		URI inputURI = getProjectFileURI(inputName);
		URI ecoreURI = getProjectFileURI(ecoreName);
		BaseCSResource xtextResource = (BaseCSResource) metaModelManager.getExternalResourceSet().createResource(inputURI);
		MetaModelManagerResourceAdapter.getAdapter(xtextResource, metaModelManager);
		xtextResource.load(null);
		assertNoResourceErrors("Load failed", xtextResource);
		Resource pivotResource = ocl.cs2pivot(xtextResource);
		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
		assertNoValidationErrors("Pivot validation errors", pivotResource.getContents().get(0));
		Resource ecoreResource = pivot2ecore(ocl, pivotResource, ecoreURI, true);
		return ecoreResource;
	}

	protected EObject eCreate(EPackage ePackage, String className) {
		EClass eClass = (EClass) ePackage.getEClassifier(className);
		EFactory eFactoryInstance = ePackage.getEFactoryInstance();
		return eFactoryInstance.create(eClass);
	}

	protected void eSet(EObject eObject, String eFeatureName, Object value) {
		EClass eClass = eObject.eClass();
		EStructuralFeature eFeature = eClass.getEStructuralFeature(eFeatureName);
		assert eFeature != null;
		eObject.eSet(eFeature, value);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		PivotEnvironmentFactory.disposeGlobalRegistryInstance();
		super.tearDown();
	}

	public void testValidate_Bug366229_oclinecore() throws IOException, InterruptedException {
		//
		//	Create model
		//
		OCL ocl1 = OCL.newInstance(new PivotEnvironmentFactory());
		OCL ocl2 = OCL.newInstance(new PivotEnvironmentFactory());
		MetaModelManager metaModelManager1 = ocl1.getMetaModelManager();
		MetaModelManager metaModelManager2 = ocl2.getMetaModelManager();
		Resource ecoreResource = doLoadOCLinEcore(ocl1, "Bug366229");
		metaModelManager2.getExternalResourceSet().getResources().add(ecoreResource);
		metaModelManager1.dispose();
		EPackage overloadsPackage = (EPackage) ecoreResource.getContents().get(0);
		EObject testInstance = eCreate(overloadsPackage, "SubClass");
		//
		//	Check EObjectValidator errors
		//
		EValidator.Registry.INSTANCE.put(overloadsPackage, EObjectValidator.INSTANCE);
		checkValidationDiagnostics(testInstance, Diagnostic.ERROR);
		metaModelManager2.dispose();
	}

	public void testValidate_Validate_completeocl() throws IOException, InterruptedException {
		//
		//	Create model
		//
		//	0 - the complementing type system for the validator
		//	1 - the evolving complemented type system under test
		//	2 - the stable complemented type system under test
		//
		OCL ocl0 = OCL.newInstance(new PivotEnvironmentFactory());
		OCL ocl1 = OCL.newInstance(new PivotEnvironmentFactory());
		OCL ocl2 = OCL.newInstance(new PivotEnvironmentFactory());
		MetaModelManager metaModelManager0 = ocl0.getMetaModelManager();
		MetaModelManager metaModelManager1 = ocl1.getMetaModelManager();
		MetaModelManager metaModelManager2 = ocl2.getMetaModelManager();
		Resource ecoreResource1 = doLoadOCLinEcore(ocl1, "Validate");
		Resource ecoreResource2 = doLoadOCLinEcore(ocl2, "Validate");
		EPackage validatePackage1 = DomainUtil.nonNullState((EPackage) ecoreResource1.getContents().get(0));
		EPackage validatePackage2 = DomainUtil.nonNullState((EPackage) ecoreResource2.getContents().get(0));
		URI oclURI = getProjectFileURI("Validate.ocl");
		CompleteOCLEObjectValidator completeOCLEObjectValidator = new CompleteOCLEObjectValidator(validatePackage1, oclURI, metaModelManager0);
		EValidator.Registry.INSTANCE.put(validatePackage1, completeOCLEObjectValidator);
		try {
			EObject testInstance1 = eCreate(validatePackage1, "Level3");
			EObject testInstance2 = eCreate(validatePackage2, "Level3");
			String template = EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_;
			String objectLabel;
			//
			//	No errors
			//
			eSet(testInstance1, "ref", "xx");
			eSet(testInstance1, "l1", "xx");
			eSet(testInstance1, "l2a", "xx");
			eSet(testInstance1, "l2b", "xx");
			eSet(testInstance1, "l3", "xx");
			eSet(testInstance2, "ref", "yy");
			eSet(testInstance2, "l1", "yy");
			eSet(testInstance2, "l2a", "yy");
			eSet(testInstance2, "l2b", "yy");
			eSet(testInstance2, "l3", "yy");
			checkValidationDiagnostics(testInstance1, Diagnostic.WARNING);
			checkValidationDiagnostics(testInstance2, Diagnostic.WARNING);
			//
			//	CompleteOCL errors all round
			//
			eSet(testInstance1, "ref", "xxx");
			eSet(testInstance1, "l1", "xxx");
			eSet(testInstance1, "l2a", "xxx");
			eSet(testInstance1, "l2b", "xxx");
			eSet(testInstance1, "l3", "xxx");
			eSet(testInstance2, "ref", "yyy");
			eSet(testInstance2, "l1", "yyy");
			eSet(testInstance2, "l2a", "yyy");
			eSet(testInstance2, "l2b", "yyy");
			eSet(testInstance2, "l3", "yyy");
			objectLabel = DomainUtil.getLabel(testInstance1);
			checkValidationDiagnostics(testInstance1, Diagnostic.WARNING,
				DomainUtil.bind(template,  "Level1", "V1", objectLabel),
				DomainUtil.bind(template,  "Level2a", "V2a", objectLabel),
				DomainUtil.bind(template,  "Level2b", "V2b", objectLabel),
				DomainUtil.bind(template,  "Level3", "V3", objectLabel));
			checkValidationDiagnostics(testInstance2, Diagnostic.WARNING);
			//
			//	One CompleteOCl and one OCLinEcore
			//
			eSet(testInstance1, "ref", "ok");
			eSet(testInstance1, "l1", "ok");
			eSet(testInstance1, "l2a", "bad");
			eSet(testInstance1, "l2b", "ok");
			eSet(testInstance1, "l3", "ok");
			eSet(testInstance2, "ref", "ok");
			eSet(testInstance2, "l1", "ok");
			eSet(testInstance2, "l2a", "bad");
			eSet(testInstance2, "l2b", "ok");
			eSet(testInstance2, "l3", "ok");
			objectLabel = DomainUtil.getLabel(testInstance1);
			checkValidationDiagnostics(testInstance1, Diagnostic.WARNING,
				DomainUtil.bind(template,  "Level2a", "L2a", objectLabel),
				DomainUtil.bind(template,  "Level2a", "V2a", objectLabel));
			objectLabel = DomainUtil.getLabel(testInstance2);
			checkValidationDiagnostics(testInstance2, Diagnostic.ERROR,
				DomainUtil.bind("The ''{0}'' constraint is violated on ''{1}''", "L2a", "Level3 ok", objectLabel));
		}
		finally {
			metaModelManager0.dispose();
			metaModelManager1.dispose();
			metaModelManager2.dispose();
			EValidator.Registry.INSTANCE.remove(validatePackage1);			
		}
	}

	public void testValidate_Validate_completeocl_loadresource() throws IOException, InterruptedException {		
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet2 = DomainUtil.nonNullState(resourceSet);
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet2);			
		OCLDelegateDomain.initialize(resourceSet2, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		//
		URI ecoreURI = getTestModelURI("model/OCLinEcoreTutorial.ecore");
		URI xmiURI = getTestModelURI("model/OCLinEcoreTutorial.xmi");
		URI oclURI = getProjectFileURI("ExtraOCLinEcoreTutorial.ocl");
		String testDocument = 
				"import '" + ecoreURI.toString() + "'\n" +
				"package tutorial\n" +
				"context Book\n" +
				"inv ExactlyOneCopy: copies=1\n" +
				"endpackage\n";
		createOCLinEcoreFile("ExtraOCLinEcoreTutorial.ocl", testDocument);
		//
		Resource resource = DomainUtil.nonNullState(resourceSet2.getResource(xmiURI, true));
		assertValidationDiagnostics("Without Complete OCL", resource, 
			"The 'SufficientCopies' constraint is violated on 'Book b2'",
			"The 'AtMostTwoLoans' constraint is violated on 'Member m3'",
			"The 'UniqueLoans' constraint is violated on 'Member m3'");
		//
		Helper helper = new Helper(resourceSet2) {
			@Override
			protected boolean error(@NonNull String primaryMessage, @Nullable String detailMessage) {
				TestCase.fail(primaryMessage + "\n\t" + detailMessage);
				return false;
			}
		};
		assertTrue(helper.loadMetaModels());
		assertTrue(helper.loadDocument(oclURI));
		helper.installPackages();
		
		assertValidationDiagnostics("Without Complete OCL", resource, 
			"'Book::SufficientCopies' constraint is not satisfied for 'Book b2'",
			"'Member::AtMostTwoLoans' constraint is not satisfied for 'Member m3'",
			"'Member::UniqueLoans' constraint is not satisfied for 'Member m3'",
			"'Book::ExactlyOneCopy' constraint is not satisfied for 'Book b2'");
	}
	public void testValidate_Validate_completeocl_Bug422583() throws IOException, InterruptedException {		
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet2 = DomainUtil.nonNullState(resourceSet);
		UML2Pivot.initialize(resourceSet2);
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet2);			
		OCLDelegateDomain.initialize(resourceSet2, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		//
		URI umlURI = getProjectFileURI("Names.uml");
		URI oclURI = getProjectFileURI("Bug422583.ocl");
		String testDocument = 
				"import uml : 'http://www.eclipse.org/uml2/4.0.0/UML#/'\n" +
				"package uml\n" +
				"  context Element\n" +
				"  def: alwaysTrue() : Boolean = true\n" +
				"  def: rootFalse() : Boolean = false\n" +
				"  inv IsElement: self.alwaysTrue()\n" +
				"  context Classifier\n" +
				"  def: rootFalse() : Boolean = true\n" +
				"  def: leafFalse() : Boolean = true\n" +
				"  inv IsClassifier: self.alwaysTrue()\n" +
				"  inv IsClassifierWrtLeaf: self.leafFalse()\n" +
				"  context Class\n" +
				"  def: leafFalse() : Boolean = false\n" +
				"  inv IsClass: self.alwaysTrue()\n" +
				"  inv IsClassWrtRoot: self.rootFalse()\n" +
				"  inv IsClassWrtLeaf: self.leafFalse()\n" +
				"endpackage\n";
		createOCLinEcoreFile("Bug422583.ocl", testDocument);
		//
		Resource resource = DomainUtil.nonNullState(resourceSet2.getResource(umlURI, true));
		org.eclipse.uml2.uml.NamedElement uNamed = null;
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof org.eclipse.uml2.uml.Class) {
				if ("UNamed".equals(((org.eclipse.uml2.uml.Class)eObject).getName())) {
					uNamed = (org.eclipse.uml2.uml.NamedElement)eObject;
					break;
				}
			}
		}
		assertValidationDiagnostics("Without Complete OCL", resource);
		//
		Helper helper = new Helper(resourceSet2) {
			@Override
			protected boolean error(@NonNull String primaryMessage, @Nullable String detailMessage) {
				TestCase.fail(primaryMessage + "\n\t" + detailMessage);
				return false;
			}
		};
		assertTrue(helper.loadMetaModels());
		assertTrue(helper.loadDocument(oclURI));
		helper.installPackages();
		String objectLabel = DomainUtil.getLabel(uNamed);
		assertValidationDiagnostics("Without Complete OCL", resource,
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Classifier", "IsClassifierWrtLeaf", objectLabel),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Class", "IsClassWrtLeaf", objectLabel));
	}

	@SuppressWarnings("null")
	public void testValidate_Validate_oclinecore() throws IOException, InterruptedException {
		//
		//	Create model
		//
		OCL ocl1 = OCL.newInstance(new PivotEnvironmentFactory());
		MetaModelManager metaModelManager1 = ocl1.getMetaModelManager();
		Resource ecoreResource = doLoadOCLinEcore(ocl1, "Validate");
		MetaModelManagerResourceSetAdapter.getAdapter(ecoreResource.getResourceSet(), metaModelManager1);
		EPackage validatePackage = (EPackage) ecoreResource.getContents().get(0);
		EObject testInstance = eCreate(validatePackage, "Level3");
		eSet(testInstance, "ref", "ref");
		eSet(testInstance, "l1", "l1");
		eSet(testInstance, "l2a", "l2a");
		eSet(testInstance, "l2b", "l2b");
		eSet(testInstance, "l3", "l3");
		String objectLabel = DomainUtil.getLabel(testInstance);
		//
		//	Check EObjectValidator errors
		//
		EValidator.Registry.INSTANCE.put(validatePackage, EObjectValidator.INSTANCE);
		try {
			String template = EcorePlugin.INSTANCE.getString("_UI_GenericConstraint_diagnostic");
			checkValidationDiagnostics(testInstance, Diagnostic.ERROR,
				DomainUtil.bind(template,  "L1", objectLabel),
				DomainUtil.bind(template,  "L2a", objectLabel),
	//BUG355184		DomainUtil.bind(template,  "L2b", objectLabel),
				DomainUtil.bind(template,  "L3", objectLabel));
			//
			//	Check OCLinEcoreEObjectValidator warnings and distinct message
			//
			EValidator.Registry.INSTANCE.put(validatePackage, new OCLinEcoreEObjectValidator());
			template = EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_;
			checkValidationDiagnostics(testInstance, Diagnostic.WARNING,
				DomainUtil.bind(template, "Level1", "L1", objectLabel),
				DomainUtil.bind(template, "Level2a", "L2a", objectLabel),
	//BUG355184		DomainUtil.bind(template,  "L2b", objectLabel),
				DomainUtil.bind(template, "Level3", "L3", objectLabel));
			//
			//	No errors
			//
			eSet(testInstance, "ref", "ok");
			eSet(testInstance, "l1", "ok");
			eSet(testInstance, "l2a", "ok");
			eSet(testInstance, "l2b", "ok");
			eSet(testInstance, "l3", "ok");
			objectLabel = DomainUtil.getLabel(testInstance);
			checkValidationDiagnostics(testInstance, Diagnostic.WARNING);
			//
			//	Just one error
			//
			eSet(testInstance, "ref", "ok");
			eSet(testInstance, "l1", "bad");
			eSet(testInstance, "l2a", "ok");
			eSet(testInstance, "l2b", "ok");
			eSet(testInstance, "l3", "ok");
			objectLabel = DomainUtil.getLabel(testInstance);
			checkValidationDiagnostics(testInstance, Diagnostic.WARNING,
				DomainUtil.bind(template, "Level1", "L1", objectLabel));
		} finally {
			metaModelManager1.dispose();
			EValidator.Registry.INSTANCE.remove(validatePackage);
		}
	}
}
