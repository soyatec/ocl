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
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotFruitTestSuite.java,v 1.2 2011/05/06 09:05:14 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.UML2EcoreConverter;

/**
 * Test suite with a simple Fruit model.
 */
@SuppressWarnings("nls")
public abstract class PivotStateMachineTestSuite extends PivotTestSuite
{
	protected EPackage statefulEPackage;
	protected EFactory statefulEFactory;

//	protected org.eclipse.ocl.examples.pivot.Package fruitPackage;
	
	protected EClass c1Class;

	public PivotStateMachineTestSuite(boolean useCodeGen) {
		super(useCodeGen);
	}

	private EEnumLiteral getELiteral(EEnum eEnum, String name) {
		return eEnum.getEEnumLiteral(name);
	}
	
	private EOperation getEOperation(EClass eClass, String name, Object object, Object object2) {
		return EcoreUtils.getNamedElement(eClass.getEOperations(), name);
	}

	private EAttribute getEAttribute(EClass cls, String name, Object object) {
		return (EAttribute) cls.getEStructuralFeature(name);
	}

	private EReference getEReference(EClass cls, String name, Object object) {
		return (EReference) cls.getEStructuralFeature(name);
	}

	private EClassifier getEClassifier(EPackage ePackage, String name) {
		return ePackage.getEClassifier(name);
	}

	@SuppressWarnings("null")
	protected Resource getPivotFromUML(MetaModelManager metaModelManager, Resource umlResource) throws ParserException {
//		String problem = UML2Pivot.initialize(metaModelManager.getExternalResourceSet());
//		assertNull(problem);
		UML2Pivot uml2Pivot = UML2Pivot.getAdapter(umlResource, metaModelManager);
		Root pivotRoot = uml2Pivot.getPivotRoot();
		Resource pivotResource = pivotRoot.eResource();
		assertNoResourceErrors("Normalisation failed", pivotResource);
		assertNoValidationErrors("Normalisation invalid", pivotResource);
		return pivotResource;
	}
	
	protected Resource initStateMachinePackage() throws ParserException {
		UML2Pivot.initialize(resourceSet);
		URI uri = getTestModelURI("/model/StateMachines.uml");
		Resource umlResource = resourceSet.getResource(uri, true);
		List<EObject> contents = umlResource.getContents();
		Map<String, String> options = new HashMap<String, String>();
		options.put(UML2EcoreConverter.OPTION__ECORE_TAGGED_VALUES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__REDEFINING_OPERATIONS, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__REDEFINING_PROPERTIES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__SUBSETTING_PROPERTIES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__UNION_PROPERTIES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DERIVED_FEATURES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DUPLICATE_OPERATIONS, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DUPLICATE_OPERATION_INHERITANCE, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DUPLICATE_FEATURES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DUPLICATE_FEATURE_INHERITANCE, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__SUPER_CLASS_ORDER, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__ANNOTATION_DETAILS, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__INVARIANT_CONSTRAINTS, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__OPERATION_BODIES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__COMMENTS,  UMLUtil.OPTION__PROCESS);
		UML2EcoreConverter uml2EcoreConverter = new UML2EcoreConverter();
		Collection<? extends EObject> ecoreContents = uml2EcoreConverter.convert(contents, options, null, null);
		Resource ecoreResource = resourceSet.createResource(URI.createURI("StateMachines.ecore"));
		ecoreResource.getContents().addAll(ecoreContents);
		statefulEPackage = (EPackage) ecoreResource.getContents().get(0);
		statefulEFactory = statefulEPackage.getEFactoryInstance();
		c1Class = (EClass) statefulEPackage.getEClassifier("C1");
//		OCL ocl1 = OCL.newInstance();
//		MetaModelManager metaModelManager1 = ocl1.getMetaModelManager();
//		try {
			Resource pivotResource = getPivotFromUML(metaModelManager, umlResource);
		return pivotResource;
	}

	@SuppressWarnings("null")
	@Override
    protected void setUp() throws Exception {
        super.setUp();
		metaModelManager.addGlobalNamespace(PivotConstants.OCL_NAME, metaModelManager.getPivotMetaModel());
    }
}