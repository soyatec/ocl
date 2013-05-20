/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.modelregistry;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllRegistryTests
{
	public static void buildSuite(TestSuite suite) {
		suite.addTestSuite(TestContents.class);
		suite.addTestSuite(TestFileHandles.class);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All Registry Tests");
		buildSuite(suite);
		return suite;
	}
}
