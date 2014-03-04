/**
 * <copyright>
 *
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation
 *   E.D.Willink (Obeo) - 425799 Validity View Integration
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.validity.test;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultSet;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.validity.test.ecoreTest.EClass2;
import org.eclipse.ocl.examples.validity.test.ecoreTest.impl.Eclass1Impl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Class testing the validityModel initialization mechanism.
 */
public class ValidityModelTests extends AbstractValidityTestCase
{
	private static final String PREFIX_CONSTRAINT_LABEL = "Constraint ";

	protected @NonNull ConstrainingNode assertHasConstrainingNodeByLabel(@NonNull ConstrainingNode constrainingNode, @NonNull String label, @NonNull Class<?> constrainingClass) {
		ConstrainingNode containedConstrainingNode = getConstrainingNodeByLabel(constrainingNode.getChildren(), label);
		assertNotNull(containedConstrainingNode);
		assertTrue(constrainingClass.isAssignableFrom(containedConstrainingNode.getConstrainingObject().getClass()));
		return containedConstrainingNode;
	}

	protected @NonNull ConstrainingNode assertHasConstrainingNodeByLabel(@NonNull RootNode rootNode, @NonNull String label, @NonNull Class<?> constrainingClass) {
		ConstrainingNode containedConstrainingNode = getConstrainingNodeByLabel(rootNode.getConstrainingNodes(), label);
		assertNotNull(containedConstrainingNode);
		assertTrue(constrainingClass.isAssignableFrom(containedConstrainingNode.getConstrainingObject().getClass()));
		return containedConstrainingNode;
	}

	protected @NonNull List<? extends ConstrainingNode> assertHasConstrainingNodes(@NonNull ConstrainingNode constrainingNode, int expectedChildCount) {
		List<ConstrainingNode> children = constrainingNode.getChildren();
		assertEquals("Expected child count for " + constrainingNode, expectedChildCount, children.size());
		return children;
	}

	protected @NonNull List<? extends ConstrainingNode> assertHasConstrainingNodes(@NonNull RootNode rootNode, int expectedChildCount) {
		List<? extends ConstrainingNode> children = rootNode.getConstrainingNodes();
		assertEquals("Expected child count for " + rootNode, expectedChildCount, children.size());
		return children;
	}

	protected @NonNull LeafConstrainingNode assertHasLeafConstrainingNodeByPrefixedLabel(@NonNull ConstrainingNode constrainingNode, @NonNull String label) {
		ConstrainingNode containedConstrainingNode = getConstrainingNodeByLabel(constrainingNode.getChildren(), PREFIX_CONSTRAINT_LABEL + label);
		assertTrue(containedConstrainingNode instanceof LeafConstrainingNode);
		return (LeafConstrainingNode) containedConstrainingNode;
	}

	protected @NonNull ResultConstrainingNode assertHasResultConstrainingNodeByLabel(@NonNull ConstrainingNode constrainingNode, @NonNull String label) {
		ConstrainingNode containedConstrainingNode = getConstrainingNodeByLabel(constrainingNode.getChildren(), label);
		assertTrue(containedConstrainingNode instanceof ResultConstrainingNode);
		assertTrue(containedConstrainingNode.getConstrainingObject() == null);
		return (ResultConstrainingNode) containedConstrainingNode;
	}

	protected @NonNull List<? extends ValidatableNode> assertHasValidatableNodes(@NonNull RootNode rootNode, int expectedChildCount) {
		List<? extends ValidatableNode> children = rootNode.getValidatableNodes();
		assertEquals("Expected child count for " + rootNode, expectedChildCount, children.size());
		return children;
	}

	protected @NonNull List<? extends ValidatableNode> assertHasValidatableNodes(@NonNull ValidatableNode validatableNode, int expectedChildCount) {
		List<? extends ValidatableNode> children = validatableNode.getChildren();
		assertEquals("Expected child count for " + validatableNode, expectedChildCount, children.size());
		return children;
	}

	protected @NonNull ValidatableNode assertHasValidatableNodeByLabel(@NonNull RootNode rootNode, @NonNull String label, @NonNull Class<?> constrainingClass) {
		ValidatableNode containedValidatableNode = getValidatableNodeByLabel(rootNode.getValidatableNodes(), label);
		assertNotNull(containedValidatableNode);
		assertTrue(constrainingClass.isAssignableFrom(containedValidatableNode.getConstrainedObject().getClass()));
		return containedValidatableNode;
	}

	protected @NonNull ValidatableNode assertHasValidatableNodeByLabel(@NonNull ValidatableNode validatableNode, @NonNull String label, @NonNull Class<?> constrainingClass) {
		ValidatableNode containedValidatableNode = getValidatableNodeByLabel(validatableNode.getChildren(), label);
		assertNotNull(containedValidatableNode);
		assertTrue(constrainingClass.isAssignableFrom(containedValidatableNode.getConstrainedObject().getClass()));
		return containedValidatableNode;
	}

	protected @NonNull ResultValidatableNode assertHasResultValidatableNodeByPrefixedLabel(@NonNull ValidatableNode validatableNode, @NonNull String label) {
		ValidatableNode containedValidatableNode = getValidatableNodeByLabel(validatableNode.getChildren(), PREFIX_CONSTRAINT_LABEL + label);
		assertTrue(containedValidatableNode instanceof ResultValidatableNode);
		assertNull(containedValidatableNode.getConstrainedObject());
		return (ResultValidatableNode) containedValidatableNode;
	}

	@Before
	public void setUp() throws Exception {
		initTestModels();
		initValidityManager(null);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testValidityModel_AllResourcesArePresent() {
		Set<Resource> resources = validityModel.getResources();
		assertEquals((Integer) 5, (Integer) resources.size());
		assertTrue(resources.contains(ecoreResource));
		assertTrue(resources.contains(ecoreResource2));
		assertTrue(resources.contains(ecoreResource3));
		assertTrue(isCompleteOCLCSResourcePresent(resources));
	}

	@Test
	public void testValidityModelInitialization_RootValidatableNodesArePresent() {
		final ValidatableNode _e1Att1 = assertHasValidatableNodeByLabel(rootNode, "Eclass1 e1Att1", Eclass1Impl.class);
		assertHasValidatableNodes(_e1Att1, 3);
		assertHasResultValidatableNodeByPrefixedLabel(_e1Att1, "eclass1_constraint");

		final ValidatableNode _e1Att1__EClass2 = assertHasValidatableNodeByLabel(_e1Att1, "EClass2", EClass2.class);
		assertHasValidatableNodes(_e1Att1__EClass2, 1);
		assertHasResultValidatableNodeByPrefixedLabel(_e1Att1__EClass2, "eclass2_constraint");

		final ValidatableNode containedValidatableNode2 = assertHasValidatableNodeByLabel(_e1Att1, "EClass2", null);		// FIXME Duplicate
		assertHasValidatableNodes(containedValidatableNode2, 1);
		assertHasResultValidatableNodeByPrefixedLabel(containedValidatableNode2, "eclass2_constraint");

		final ValidatableNode _ecoreTest2 = assertHasValidatableNodeByLabel(rootNode, "ecoreTest2", null);
		assertHasValidatableNodes(_ecoreTest2, 9/*3*/);
		assertHasResultValidatableNodeByPrefixedLabel(_ecoreTest2, "epackage_constraint_2");
		assertHasResultValidatableNodeByPrefixedLabel(_ecoreTest2, "epackage_constraint");

		final ValidatableNode _ecoreTest2__Eclass5 = assertHasValidatableNodeByLabel(_ecoreTest2, "Eclass5", null);
		assertHasValidatableNodes(_ecoreTest2__Eclass5, 13/*2*/);
		assertHasResultValidatableNodeByPrefixedLabel(_ecoreTest2__Eclass5, "eclass_constraint");

		final ValidatableNode _ecoreTest2__Eclass5__eAttribute5 = assertHasValidatableNodeByLabel(_ecoreTest2__Eclass5, "eAttribute5 : EString", null);
		assertHasValidatableNodes(_ecoreTest2__Eclass5__eAttribute5, 9/*1*/);
		assertHasResultValidatableNodeByPrefixedLabel(_ecoreTest2__Eclass5__eAttribute5, "eattribute_constraint");

	}

	@Test
	public void testValidityModelInitializationModelElements() {
		final ValidatableNode _e1Att1 = assertHasValidatableNodeByLabel(rootNode, "Eclass1 e1Att1", Eclass1Impl.class);
		assertHasValidatableNodes(_e1Att1, 3);
		assertHasResultValidatableNodeByPrefixedLabel(_e1Att1, "eclass1_constraint");

		final ValidatableNode _e1Att1__EClass2 = assertHasValidatableNodeByLabel(_e1Att1, "EClass2", EClass2.class);		// FIXME Duplicate
		assertTrue(_e1Att1__EClass2.getConstrainedObject() instanceof EClass2);
		assertHasValidatableNodes(_e1Att1__EClass2, 1);
		assertHasResultValidatableNodeByPrefixedLabel(_e1Att1__EClass2, "eclass2_constraint");

		final ValidatableNode containedValidatableNode2 = assertHasValidatableNodeByLabel(_e1Att1, "EClass2", null);
		assertHasValidatableNodes(containedValidatableNode2, 1);
		assertHasResultValidatableNodeByPrefixedLabel(containedValidatableNode2, "eclass2_constraint");

		final ValidatableNode _ecoreTest2 = assertHasValidatableNodeByLabel(rootNode, "ecoreTest2", null);
		assertHasValidatableNodes(_ecoreTest2, 9/*3*/);
		assertHasResultValidatableNodeByPrefixedLabel(_ecoreTest2, "epackage_constraint_2");
		assertHasResultValidatableNodeByPrefixedLabel(_ecoreTest2, "epackage_constraint");

		final ValidatableNode _ecoreTest2__Eclass5 = assertHasValidatableNodeByLabel(_ecoreTest2, "Eclass5", null);
		assertHasResultValidatableNodeByPrefixedLabel(_ecoreTest2__Eclass5, "eclass_constraint");
		
		final ValidatableNode _ecoreTest2__Eclass5__eAttribute5 = assertHasValidatableNodeByLabel(_ecoreTest2__Eclass5, "eAttribute5 : EString", null);
		assertHasValidatableNodes(_ecoreTest2__Eclass5__eAttribute5, 9/*1*/);
		assertHasResultValidatableNodeByPrefixedLabel(_ecoreTest2__Eclass5__eAttribute5, "eattribute_constraint");
	}

	@Test
	public void testValidityModelInitializationConstraints() {

		Set<Resource> resources = validityModel.getResources();
		assertEquals((Integer) 5, (Integer) resources.size());
		assertTrue(resources.contains(ecoreResource));
		assertTrue(resources.contains(ecoreResource2));
		assertTrue(resources.contains(ecoreResource3));
		assertTrue(isCompleteOCLCSResourcePresent(resources));

		// Tests that we have all the RootConstrainingNode ecoreTest and ecore.
		assertHasConstrainingNodes(rootNode, 2);
		final ConstrainingNode _ecore = assertHasConstrainingNodeByLabel(rootNode, "ecore", EPackage.class);
		assertHasConstrainingNodes(_ecore, 45/*3*/);
		final ConstrainingNode _ecore__EClass = assertHasConstrainingNodeByLabel(_ecore, "EClass", EClass.class);
		assertHasConstrainingNodes(_ecore__EClass, 9/*1*/);
		final ConstrainingNode _ecore__EClass__eclass_constraint = assertHasLeafConstrainingNodeByPrefixedLabel(_ecore__EClass, "eclass_constraint");
		assertTrue(_ecore__EClass__eclass_constraint.getConstrainingObject() instanceof Constraint);
		assertHasConstrainingNodes(_ecore__EClass__eclass_constraint, 4);
		assertHasResultConstrainingNodeByLabel(_ecore__EClass__eclass_constraint, "Eclass1");
		assertHasResultConstrainingNodeByLabel(_ecore__EClass__eclass_constraint, "Eclass5");
		assertHasResultConstrainingNodeByLabel(_ecore__EClass__eclass_constraint, "EClass2");
		assertHasResultConstrainingNodeByLabel(_ecore__EClass__eclass_constraint, "EClass3 -> Eclass5");

		final ConstrainingNode _ecore__EPackage = assertHasConstrainingNodeByLabel(_ecore, "EPackage", EClass.class);
		assertHasConstrainingNodes(_ecore__EPackage, 7/*2*/);
		final ConstrainingNode _ecore__EPackage__epackage_constraint = assertHasLeafConstrainingNodeByPrefixedLabel(_ecore__EPackage, "epackage_constraint");
		assertHasConstrainingNodes(_ecore__EPackage__epackage_constraint, 2);
		assertHasResultConstrainingNodeByLabel(_ecore__EPackage__epackage_constraint, "ecoreTest2");
		assertHasResultConstrainingNodeByLabel(_ecore__EPackage__epackage_constraint, "ecoreTest");

		final ConstrainingNode _ecore__EPackage__epackage_constraint_2 = assertHasLeafConstrainingNodeByPrefixedLabel(_ecore__EPackage, "epackage_constraint_2");
		assertHasConstrainingNodes(_ecore__EPackage__epackage_constraint_2, 2);
		assertHasResultConstrainingNodeByLabel(_ecore__EPackage__epackage_constraint_2, "ecoreTest2");
		assertHasResultConstrainingNodeByLabel(_ecore__EPackage__epackage_constraint_2, "ecoreTest");

		final ConstrainingNode _ecore__EAttribute = assertHasConstrainingNodeByLabel(_ecore, "EAttribute", EClass.class);
		assertHasConstrainingNodes(_ecore__EAttribute, 2/*1*/);
		final ConstrainingNode _ecore__EAttribute__eattribute_constraint = assertHasLeafConstrainingNodeByPrefixedLabel(_ecore__EAttribute, "eattribute_constraint");
		assertHasConstrainingNodes(_ecore__EAttribute__eattribute_constraint, 5);
		assertHasResultConstrainingNodeByLabel(_ecore__EAttribute__eattribute_constraint, "eAttribute1 : EString");
		assertHasResultConstrainingNodeByLabel(_ecore__EAttribute__eattribute_constraint, "eAttribute2 : EString");
		assertHasResultConstrainingNodeByLabel(_ecore__EAttribute__eattribute_constraint, "eAttribute3 : EShort");
		assertHasResultConstrainingNodeByLabel(_ecore__EAttribute__eattribute_constraint, "eAttribute5 : EString");

		final ConstrainingNode _ecoreTest = assertHasConstrainingNodeByLabel(rootNode, "ecoreTest", EPackage.class);
		assertHasConstrainingNodes(_ecoreTest, 2);

		final ConstrainingNode _ecoreTest__Eclass1 = assertHasConstrainingNodeByLabel(_ecoreTest, "Eclass1", EClass.class);
		assertHasConstrainingNodes(_ecoreTest__Eclass1, 1);
		final ConstrainingNode _ecoreTest__Eclass1__eclass1_constraint = assertHasLeafConstrainingNodeByPrefixedLabel(_ecoreTest__Eclass1, "eclass1_constraint");
		assertHasConstrainingNodes(_ecoreTest__Eclass1__eclass1_constraint, 1);
		assertHasResultConstrainingNodeByLabel(_ecoreTest__Eclass1__eclass1_constraint, "Eclass1 e1Att1");

		final ConstrainingNode _ecoreTest__EClass2 = assertHasConstrainingNodeByLabel(_ecoreTest, "EClass2", EClass.class);
		assertHasConstrainingNodes(_ecoreTest__EClass2, 1);
		final ConstrainingNode _ecoreTest__EClass2__eclass2_constraint = assertHasLeafConstrainingNodeByPrefixedLabel(_ecoreTest__EClass2, "eclass2_constraint");
		assertHasConstrainingNodes(_ecoreTest__EClass2__eclass2_constraint, 2);
		assertHasResultConstrainingNodeByLabel(_ecoreTest__EClass2__eclass2_constraint, "EClass2");
		assertHasResultConstrainingNodeByLabel(_ecoreTest__EClass2__eclass2_constraint, "EClass2");		// FIXME Duplicate
	}

	@Test
	public void testValidityModelCreateResultSet() {
		ResultSet resultSet = validityManager.createResultSet(new NullProgressMonitor());
		List<Result> results = resultSet.getResults();
		for (Result result : results) {
			ResultValidatableNode resultValidatableNode = result.getResultValidatableNode();
			assertNotNull(resultValidatableNode);
			ResultConstrainingNode resultConstrainingNode = resultValidatableNode.getResultConstrainingNode();
			assertNotNull(resultConstrainingNode);
			assertEquals(resultValidatableNode, resultConstrainingNode.getResultValidatableNode());
		}
		assertEquals(EXPECTED_RESULTS, (Integer) results.size());
	}
}
