/**
 * <copyright>
 * 
 * Copyright (c) 2011, 2013 E.D.Willink and others.
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
 * $Id: EvaluateNameVisibilityTest.java,v 1.8 2011/05/20 15:27:16 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
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
@SuppressWarnings({"nls"})
@RunWith(value = Parameterized.class)
public class EvaluateUMLTest4 extends PivotStateMachineTestSuite
{
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{false} /*, {true}*/};
		return Arrays.asList(data);
	}

	public EvaluateUMLTest4(boolean useCodeGen) {
		super(useCodeGen);
	}

	@Override
	protected @NonNull String getTestPackageName() {
		return "EvaluateUML";
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
	 * Tests construction of a type instance with property values
	 * @throws ParserException 
	 */
	@Test public void test_oclIsInState() throws InvocationTargetException, ParserException {
		initStateMachinePackage();
		EObject context = statefulEFactory.create(c1Class);
		Type contextType = metaModelManager.getPivotOfEcore(Type.class, context);
		assert contextType != null;
		assertSemanticErrorQuery2(contextType, "self.oclIsInState(S2b)", OCLMessages.UnresolvedProperty_ERROR_, "S2b", "Model::C1");	
		assertQueryInvalid(context, "self.oclIsInState(S1a)", "Failed to evaluate ocl::OclAny.oclIsInState(ocl::OclState)", UnsupportedOperationException.class);	
	}
}
