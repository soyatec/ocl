/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
 * $Id: CompleteOCLStandaloneSetup.java,v 1.2 2011/01/24 21:08:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.cs2as.CompleteOCLCS2Pivot;
import org.eclipse.ocl.examples.xtext.completeocl.scoping.CompleteOCLScoping;
import org.eclipse.ocl.examples.xtext.completeocl.utilities.CompleteOCLCS2MonikerVisitor;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class CompleteOCLStandaloneSetup extends CompleteOCLStandaloneSetupGenerated
{
	private static Injector injector = null;
	
	public static void doSetup() {
		if (injector == null) {
			new CompleteOCLStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}
	
	public static void doTearDown() {
		injector = null;
	}

	public static void init() {
		CompleteOCLScoping.init();
		CompleteOCLCS2MonikerVisitor.FACTORY.getClass();
		CompleteOCLCS2Pivot.FACTORY.getClass();
//		CompleteOCLPivot2CS.FACTORY.getClass();
		EPackage.Registry.INSTANCE.put(CompleteOCLCSTPackage.eNS_URI, CompleteOCLCSTPackage.eINSTANCE);
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

