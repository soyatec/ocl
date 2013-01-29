/**
 * <copyright>
 * 
 * Copyright (c) 2011,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *     E.D.Willink (CEA LIST) - Bug 388493, 399378
 *
 * </copyright>
 *
 * $Id: EvaluateNameVisibilityTest.java,v 1.8 2011/05/20 15:27:16 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.xtext.oclinecore.OCLinEcoreStandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for Name access.
 */
@SuppressWarnings({"nls","null"})
@RunWith(value = Parameterized.class)
public class EvaluateNameVisibilityTest4 extends PivotFruitTestSuite
{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false}, {true}};
		return Arrays.asList(data);
	}

	public EvaluateNameVisibilityTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	@Override
	protected @NonNull String getTestPackageName() {
		return "EvaluateNameVisibility";
	}
	
	@BeforeClass public static void resetCounter() throws Exception {
		PivotTestSuite.resetCounter();
    }

    @Override
    @Before public void setUp() throws Exception {
        super.setUp();
    }

	@Override
	@After public void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Tests the basic name accesses
	 */
	@Test public void test_bad_navigation() throws InvocationTargetException {
		assertSemanticErrorQuery("let a : Type = null in a.Package", OCLMessages.UnresolvedProperty_ERROR_, "Package", "Type");
		assertSemanticErrorQuery("let a : Type = null in a.Package()", OCLMessages.UnresolvedOperation_ERROR_, "Package", "Type");
		assertSemanticErrorQuery("let a : Set(Type) = null in a.Package", OCLMessages.UnresolvedProperty_ERROR_, "Package", "Set(Type)");
		assertSemanticErrorQuery("let a : Set(Type) = null in a.Package()", OCLMessages.UnresolvedOperation_ERROR_, "Package", "Set(Type)");
		assertSemanticErrorQuery("Type.Package", OCLMessages.UnresolvedProperty_ERROR_, "Package", "Metaclass(Type)");
		assertSemanticErrorQuery("Type.Package()", OCLMessages.UnresolvedOperation_ERROR_, "Package", "Metaclass(Type)");
		assertSemanticErrorQuery("Set(Type).Package", OCLMessages.UnresolvedProperty_ERROR_, "Package", "Metaclass(Set(Type))");
		assertSemanticErrorQuery("Set(Type).Package()", OCLMessages.UnresolvedOperation_ERROR_, "Package", "Metaclass(Set(Type))");
		assertSemanticErrorQuery("let a : Type = null in a->Package", OCLMessages.UnresolvedProperty_ERROR_, "Package", "Set(Type)");
		assertSemanticErrorQuery("let a : Type = null in a->Package()", OCLMessages.UnresolvedOperation_ERROR_, "Package", "Set(Type)");
		assertSemanticErrorQuery("let a : Set(Type) = null in a->Package", OCLMessages.UnresolvedProperty_ERROR_, "Package", "Set(Type)");
		assertSemanticErrorQuery("let a : Set(Type) = null in a->Package()", OCLMessages.UnresolvedOperation_ERROR_, "Package", "Set(Type)");
		assertSemanticErrorQuery("Type->Package", OCLMessages.UnresolvedProperty_ERROR_, "Package", "Set(Metaclass(Type))");
		assertSemanticErrorQuery("Type->Package()", OCLMessages.UnresolvedOperation_ERROR_, "Package", "Set(Metaclass(Type))");
		assertSemanticErrorQuery("Set(Type)->Package", OCLMessages.UnresolvedProperty_ERROR_, "Package", "Set(Metaclass(Set(Type)))");
		assertSemanticErrorQuery("Set(Type)->Package()", OCLMessages.UnresolvedOperation_ERROR_, "Package", "Set(Metaclass(Set(Type)))");
		assertSemanticErrorQuery("let a : Type = null in a.if", "missing EOF at ''.''");
		assertSemanticErrorQuery("let a : Type = null in a->if", "missing EOF at ''->''");
	}

	@Test public void test_iterator_scope() {
		assertQueryEquals(null, 6, "Set{1, 2, 3 }->iterate(i : Integer; sum : Integer = 0 | sum + i)");
		assertQueryInvalid(null, "let s : Set(String) = invalid in Set{'a'}->union(s)");
	}

	@Test public void test_self_scope() {
		ExpressionInOCL query = createQuery(null, "Sequence{1}");
		CollectionLiteralExp coll = (CollectionLiteralExp) query.getBodyExpression();
		CollectionItem item = (CollectionItem) coll.getPart().get(0);
		assertQueryTrue(item, "type = item.type");
		assertQueryInvalid(null, "type = item.type");		// A2.2 def'n of invalid = invalid
	}

	@Test public void test_caught_and_uncaught() {
		initFruitPackage();
		EObject context = fruitEFactory.create(tree);
		assertQueryTrue(context, "let myName : String = name in myName.oclIsKindOf(String) and myName.oclAsType(String) = myName");
	}

	/**
	 * Tests same names on both if branches. This gave CG problems.
	 */
	@Test public void test_double_get() {
		initFruitPackage();
		EObject context = fruitEFactory.create(tree);
		assertQueryEquals(context, null, "if true then name else name endif");
	}

	/**
	 * Tests a guarded let if in operator. This gave CG problems.
	 */
	@Test public void test_cg_let_implies() {
		String textQuery = 
			    "let bodyConstraint : Constraint = null\n" + 
			    "in bodyConstraint <> null implies\n" +
			    "bodyConstraint.specification = null";
		Type testType = metaModelManager.getIntegerType();
		assert testType.getOwnedRule().isEmpty();
		assertQueryTrue(metaModelManager.getMetaclass(testType), textQuery);
//		assertQueryTrue(ValuesUtil.createTypeValue(metaModelManager.getMetaclass(testType)), textQuery);
	}
	
	@Test public void test_let_implies_let_implies() {
		String textQuery = 
			    "let bodyConstraint : Constraint = ownedRule->any(stereotype = 'body')\n" + 
			    "in bodyConstraint <> null implies\n" +
			    "let bodySpecification : ValueSpecification = bodyConstraint.specification\n" +
			    "in bodySpecification <> null and\n" +
			    "bodySpecification.oclIsKindOf(ExpressionInOCL) implies\n" +
			    "true";
//	    "CompatibleBody(bodySpecification)";
		Type testType = metaModelManager.getIntegerType();
		assert testType.getOwnedRule().isEmpty();
		assertQueryTrue(metaModelManager.getMetaclass(testType), textQuery);
	}
	
	@Test public void test_no_self() throws ParserException {
		assertSemanticErrorQuery("self->any(true)", "The context of ''self'' is unspecified");
	}
	
	@Test public void test_cg_implies_calls() throws ParserException {
		getHelper().setContext(metaModelManager.getOclVoidType());
		ExpressionInOCL query = getHelper().createQuery("self->any(true)");
		String textQuery = 
			    "name = 'closure' implies\n" +
			    "type.oclAsType(CollectionType).elementType = null";
		assertQueryTrue(query.getBodyExpression(), textQuery);
	}
	
	@Test public void test_cg_caught_if() throws ParserException {
		getHelper().setContext(metaModelManager.getOclVoidType());
		ExpressionInOCL query = getHelper().createQuery("self->any(true)");
		String textQuery = 
			    "name = 'closure' implies\n" +
			    "if self.source.type.oclIsKindOf(SequenceType) or self.source.type.oclIsKindOf(OrderedSetType)"
			    + "then self.type.oclIsKindOf(OrderedSetType) else self.type.oclIsKindOf(SetType) endif";
		assertQueryTrue(query.getBodyExpression(), textQuery);
	}
	
	@Test public void test_cg_loop_source_self_or() throws ParserException, IOException {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLinEcoreStandaloneSetup.doSetup();
		}
		String metaModelText =
				"import ecore : 'http://www.eclipse.org/emf/2002/Ecore#/';\n" +
				"package pkg : pkg = 'pkg' {\n" +
				"  class A {\n" +
				"    invariant True : true;\n" +
				"  }\n" +
				"}\n";
		Resource metaModel = cs2pivot(getOCL(), metaModelText);
		Root pivotRoot = (Root) metaModel.getContents().get(0);
		org.eclipse.ocl.examples.pivot.Package pivotPackage = pivotRoot.getNestedPackage().get(0);
		Type pivotType = pivotPackage.getOwnedType().get(0);
		Constraint pivotConstraint = pivotType.getOwnedRule().get(0);
		String textQuery = "context.ownedRule->excluding(self)->forAll(name <> self.name or stereotype <> self.stereotype)";
		assertQueryTrue(pivotConstraint, textQuery);
	}
	
	@Test public void test_cg_derived_property() throws ParserException, IOException {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLinEcoreStandaloneSetup.doSetup();
			OCLDelegateDomain.initialize(null);
		}
		String metaModelText =
				"import ecore : 'http://www.eclipse.org/emf/2002/Ecore#/';\n" +
				"package pkg : pkg = 'pkg' {\n" +
				"  class A {\n" +
				"    property derivedInteger : Integer { derivation: 99; }\n" +
				"    property derivedDerivedInteger : Integer { derivation: 2 * derivedInteger;}\n" +
				"  }\n" +
				"}\n";
		Resource metaModel = cs2pivot(getOCL(), metaModelText);
		Root pivotRoot = (Root) metaModel.getContents().get(0);
		org.eclipse.ocl.examples.pivot.Package pivotPackage = pivotRoot.getNestedPackage().get(0);
		Type pivotType = pivotPackage.getOwnedType().get(0);
		EClass eClass = metaModelManager.getEcoreOfPivot(EClass.class, pivotType);
		Object testObject = eClass.getEPackage().getEFactoryInstance().create(eClass);
		String textQuery = "self.derivedDerivedInteger";
		assertQueryEquals(testObject, 198, textQuery);
	}
	
	/**
	 * Tests the basic name accesses
	 */
	@Test public void test_container_navigation() throws InvocationTargetException {
		initFruitPackage();
		metaModelManager.addGlobalNamespace("fruit", fruitPackage);
		//
		//	Simple model: aTree contains redApple
		//
		EObject redApple = fruitEFactory.create(apple);
		redApple.eSet(fruit_color, color_red);
//		EObject greenApple = fruitEFactory.create(apple);
//		greenApple.eSet(fruit_color, color_green);
		EObject aTree = fruitEFactory.create(tree);
		@SuppressWarnings("unchecked")
		List<Object> treeFruits = (List<Object>) aTree.eGet(tree_fruits);
		treeFruits.add(redApple);
		//
		Type pivotTree = metaModelManager.getPivotOfEcore(Type.class, tree);
		//
		assertQueryEquals(redApple, color_red, "let aFruit : fruit::Fruit = self in aFruit.color");
		assertQueryEquals(aTree, idResolver.createOrderedSetOfEach(null, redApple), "let aTree : fruit::Tree = self in aTree.fruits");
		assertQueryEquals(aTree, idResolver.createOrderedSetOfEach(null, redApple), "self.fruits");
		assertQueryEquals(aTree, idResolver.createOrderedSetOfEach(null, redApple), "fruits");
		assertQueryEquals(redApple, aTree, "self.oclContainer()");
		assertQueryEquals(redApple, aTree, "self.Tree");
		//
		//	type/property ambiguity is resolved to type.
		//
		assertQueryEquals(redApple, pivotTree, "Tree");
		//
		//	type/property ambiguity is resolved to type.
		//
		assertQueryInvalid(redApple, "self.oclAsType(Tree)");
//		assertQueryEquals(aTree, ValuesUtil.createOrderedSetValue(null, redApple), "self.oclAsType(Tree).fruits");
	}
	
	/**
	 * Tests the nested name accesses
	 */
	@Test public void test_nested_names() throws InvocationTargetException {
		initFruitPackage();
		//
		//	Simple model: appleTree contains redApple
		//
		EObject redApple = fruitEFactory.create(apple);
		redApple.eSet(fruit_color, color_red);
		redApple.eSet(fruit_name, "RedApple");
		EObject appleTree = fruitEFactory.create(tree);
		appleTree.eSet(tree_name, "AppleTree");
		@SuppressWarnings("unchecked")
		List<Object> treeFruits = (List<Object>) appleTree.eGet(tree_fruits);
		treeFruits.add(redApple);
//		
		assertQueryEquals(redApple, redApple, "self.oclAsType(Apple)");//
		assertQueryEquals(redApple, redApple, "self.oclAsType(fruit::Apple)");
		assertQueryEquals(redApple, idResolver.createSetOfEach(null, redApple), "self->oclAsType(Set(Fruit))");
		assertQueryEquals(redApple, idResolver.createSetOfEach(null, redApple), "self->oclAsType(Set(fruit::Apple))");
		assertSemanticErrorQuery("self->oclAsType(Set(fruit::apple::BadApple))", OCLMessages.UnresolvedType_ERROR_, "BadApple");
		assertSemanticErrorQuery("self->oclAsType(Set(fruit::apple::BadApple))", OCLMessages.UnresolvedType_ERROR_, "BadApple");
		assertSemanticErrorQuery("self->oclAsType(Set(fruit::badapple::BadApple))", OCLMessages.UnresolvedNamespace_ERROR_, "badapple");
		assertSemanticErrorQuery("self->oclAsType(Set(badfruit::badapple::BadApple))", OCLMessages.UnresolvedNamespace_ERROR_, "badfruit");
		assertQueryInvalid(redApple, "self->oclAsType(Set(fruit::apple::EatingApple))");
		assertQueryInvalid(redApple, "self->oclAsType(Set(fruit::Tree))");		
		//
		assertQueryEquals(redApple, idResolver.createSetOfEach(null, appleTree), "Tree.allInstances()");
		assertQueryEquals(redApple, idResolver.createSetOfEach(null, appleTree), "fruit::Tree.allInstances()");
		assertQueryEquals(null, getEmptySetValue(), "fruit::Tree.allInstances()");
//
		metaModelManager.addGlobalNamespace("zz", fruitPackage);
		assertQueryEquals(redApple, idResolver.createSetOfEach(null, appleTree), "zz::Tree.allInstances()");
//
		assertQueryEquals(redApple, idResolver.createBagOfEach(null, redApple), "Fruit.allInstances().oclAsType(Apple)");		
		assertQueryEquals(redApple, idResolver.createSetOfEach(null, redApple), "Fruit.allInstances()->oclAsType(Set(Apple))");		
	}
	
	/**
	 * Tests construction of a type instance with property values
	 */
	@Test public void test_type_construction() throws InvocationTargetException {
		initFruitPackage();
		EObject context = fruitEFactory.create(tree);
		assertQueryEquals(context, "RedApple", "Apple{name='RedApple',color=Color::red}.name");
		assertQueryEquals(context, color_red, "Apple{name='RedApple',color=Color::red}.color");
		assertQueryFalse(context, "Apple{name='RedApple',color=Color::red} = Apple{name='RedApple',color=Color::red}");
		assertQueryFalse(context, "let thisApple = Apple{name='AnApple',color=Color::red}, thatApple = Apple{name='AnApple',color=Color::red} in thisApple = thatApple");
		assertQueryTrue(context, "let thisApple = Apple{name='AnApple',color=Color::red}, thatApple = Apple{name='AnApple',color=Color::red} in thisApple.name = thatApple.name");
		assertQueryTrue(context, "let thisApple = Apple{name='AnApple',color=Color::red}, thatApple = Apple{name='AnApple',color=Color::red} in thisApple.color = thatApple.color");
		assertQueryTrue(context, "let thisApple = Apple{name='AnApple',color=Color::red}, thatApple = Apple{name='AnApple',color=Color::red} in thisApple.name = thatApple.name and thisApple.color = thatApple.color");
		assertQueryFalse(context, "let thisApple = Apple{name='ThisApple',color=Color::red}, thatApple = Apple{name='ThatApple',color=Color::red} in thisApple.name = thatApple.name and thisApple.color = thatApple.color");
		assertQueryFalse(context, "let thisApple = Apple{name='AnApple',color=Color::red}, thatApple = Apple{name='AnApple',color=Color::black} in thisApple.name = thatApple.name and thisApple.color = thatApple.color");
	}
	
	/**
	 * Tests construction of a type instance with property values
	 * @throws ParserException 
	 */
	@Test public void test_uml_primitives_399378() throws ParserException {
		UML2Pivot.initialize(resourceSet);
		URI uri = getTestModelURI("/model/Fruit.uml");
		Element element = metaModelManager.loadResource(uri, null, resourceSet);
		org.eclipse.ocl.examples.pivot.Package fruitPackage = ((Root)element).getNestedPackage().get(0);
		org.eclipse.ocl.examples.pivot.Class treeClass = (org.eclipse.ocl.examples.pivot.Class) DomainUtil.getNamedElement(fruitPackage.getOwnedType(), "Tree");
		ExpressionInOCL query = createQuery(treeClass, "self.height>20");
		assertNotNull(query);
	}
}
