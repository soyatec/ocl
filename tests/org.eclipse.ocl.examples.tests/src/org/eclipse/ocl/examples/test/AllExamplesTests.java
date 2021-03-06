/**
 * <copyright>
 * 
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.ocl.examples.test.label.AllLabelTests;
import org.eclipse.ocl.examples.test.modelregistry.AllRegistryTests;
import org.eclipse.ocl.examples.validity.test.AllValidityTests;

public class AllExamplesTests extends TestCase
{
	public static void buildSuite(TestSuite suite) {
		AllLabelTests.buildSuite(suite);
		AllRegistryTests.buildSuite(suite);
		AllValidityTests.buildSuite(suite);
	}

	public static Test suite() {
    	String testSuiteName = System.getProperty("testSuiteName", "All Examples Tests");
		TestSuite suite = new TestSuite(testSuiteName);
		buildSuite(suite);
		return suite;
	}
}
