package org.eclipse.ocl.examples.consumers.tests;
/**
 * <copyright>
 * 
 * Copyright (c) 2002, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 298634
 *
 * </copyright>
 *
 * $Id: AllXtextTests.java,v 1.10 2011/05/20 15:27:16 ewillink Exp $
 */


import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Tests the Consumer support.
 */
@SuppressWarnings("nls")
public class AllConsumerTests extends TestCase
{
	public AllConsumerTests() {
		super("");
	}

	public static Test suite() {
//		if (System.getProperty("standalone") != null) {
			// running tests stand-alone:  must set up the environment registry
//			Environment.Registry.INSTANCE.registerEnvironment(
//					EcoreEnvironmentFactory.INSTANCE.createEnvironment());
//		}

    	String testSuiteName = System.getProperty("testSuiteName", "Consumer Support");
		TestSuite result = new TestSuite(testSuiteName);			
		result.addTestSuite(ConsumerProjectMapTest.class);
		result.addTestSuite(ConsumerValidateTests.class);
		return result;
	}

	public Object run(Object args)
		throws Exception {

		TestRunner.run(suite());
		return Arrays
			.asList(new String[] {"Please see raw test suite output for details."});
	}
}