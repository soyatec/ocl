package org.eclipse.ocl.examples.xtext.base.cs2as;

import org.eclipse.xtext.service.AbstractGenericModule;


/**
 * Google Guice runtime module to define the bindings for the CS2AS framework
 * 
 * @author asbh
 */
public abstract class BaseCS2ASRuntimeModule extends AbstractGenericModule{

	public Class<? extends Continuations> bindContinuations() {
		return Continuations.class;
	}
}
