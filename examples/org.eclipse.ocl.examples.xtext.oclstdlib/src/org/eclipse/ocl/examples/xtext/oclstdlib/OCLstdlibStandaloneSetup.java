/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: OCLstdlibStandaloneSetup.java,v 1.2 2011/01/24 22:28:26 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.util.OCLstdlibCSTValidator;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.OCLstdlibScoping;
import org.eclipse.ocl.examples.xtext.oclstdlib.utilities.OCLstdlibCS2MonikerVisitor;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class OCLstdlibStandaloneSetup extends OCLstdlibStandaloneSetupGenerated
{
	private static Injector injector = null;
	
	public static void doSetup() {
		if (injector == null) {
			new OCLstdlibStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}
	
	public static void doTearDown() {
		injector = null;
	}

	public static void init() {
		OCLstdlibScoping.init();
		OCLstdlibCS2MonikerVisitor.FACTORY.getClass();
//		OCLstdlibCS2Pivot.FACTORY.getClass();
		EPackage.Registry.INSTANCE.put(OCLstdlibCSTPackage.eNS_URI, OCLstdlibCSTPackage.eINSTANCE);
		EValidator.Registry.INSTANCE.put(OCLstdlibCSTPackage.eINSTANCE, OCLstdlibCSTValidator.INSTANCE);
	}
	
	/**
	 * Return the Injector for this plugin.
	 */
	public static final Injector getInjector() {
		return injector;
	}

	@Override
	public Injector createInjector() {
		init();
		injector = super.createInjector();
		return injector;
	}
}

