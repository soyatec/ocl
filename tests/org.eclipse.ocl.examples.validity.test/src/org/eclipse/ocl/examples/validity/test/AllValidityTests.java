/**
 * <copyright>
 * 
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - Initial API and implementation
 *
 * </copyright>
 */

package org.eclipse.ocl.examples.validity.test;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.emf.common.EMFPlugin;

/**
 * Tests for the Xtext editor support.
 */
@SuppressWarnings("nls")
public class AllValidityTests
	extends TestCase {

	public AllValidityTests() {
		super("");
	}

	public static void buildSuite(TestSuite suite) {
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
//			suite.addTestSuite(HTMLExportOCLValidationResultTests.class);
//			suite.addTestSuite(TextExportOCLValidationResultTests.class);
			suite.addTestSuite(ValidityManagerTests.class);
			suite.addTestSuite(ValidityModelTests.class);
		}
	}

	public static Test suite() {
		String testSuiteName = System.getProperty("testSuiteName", "Validity View Tests");
		TestSuite result = new TestSuite(testSuiteName);			
		buildSuite(result);
		return result;
	}

	public Object run(Object args) throws Exception {
		TestRunner.run(suite());
		return Arrays.asList(new String[] {"Please see raw test suite output for details."});
	}
}
