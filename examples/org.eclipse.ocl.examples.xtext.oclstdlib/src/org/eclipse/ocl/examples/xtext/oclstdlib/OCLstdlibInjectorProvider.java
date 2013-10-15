package org.eclipse.ocl.examples.xtext.oclstdlib;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.InjectorProvider;

import com.google.inject.Injector;


public class OCLstdlibInjectorProvider implements InjectorProvider {
	
	@NonNull
	public Injector getInjector() {
		return OCLstdlibStandaloneSetup.getInjector();
	}
}