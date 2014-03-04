/**
 * <copyright>
 *
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.validity.plugin;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class OCLValidityPlugin extends Plugin
{
	public static final String PLUGIN_ID = "org.eclipse.ocl.examples.validity"; //$NON-NLS-1$
	
	// The shared instance
	private static OCLValidityPlugin plugin;
	

	/**
	 * The constructor
	 */
	public OCLValidityPlugin() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static OCLValidityPlugin getDefault() {
		return plugin;
	}
	
	public static IStatus createStatus(int severity, String message, Throwable throwable) {
		return new Status(severity, PLUGIN_ID, message, throwable);
	}
	
	public static IStatus createStatus(int severity, String message) {
		return createStatus(severity, message, null);
	}
	
	public static IStatus createError(String message, int code,  Throwable throwable) {
		return new Status(IStatus.ERROR, PLUGIN_ID, code, message, throwable);
	}
	

    public static void log(IStatus status) {
    	OCLValidityPlugin debugPlugin = getDefault();
		if(debugPlugin != null) {
    		debugPlugin.getLog().log(status);
    	}
    }

	/**
	 * Logs an exception as an error in the Error Log view.
	 * @param e Exception to be logged.
	 */
	public void logException(Exception e) {
		getLog().log(
			new Status(IStatus.ERROR, PLUGIN_ID, e.getLocalizedMessage(), e));
	}

    public static void log(Throwable e) {
        log(new Status(IStatus.ERROR, PLUGIN_ID, "Exception caught", e)); //$NON-NLS-1$
    }
}
