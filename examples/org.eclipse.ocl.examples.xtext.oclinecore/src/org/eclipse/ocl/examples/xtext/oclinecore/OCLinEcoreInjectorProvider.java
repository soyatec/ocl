package org.eclipse.ocl.examples.xtext.oclinecore;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.InjectorProvider;

import com.google.inject.Injector;


public class OCLinEcoreInjectorProvider implements InjectorProvider{

	@NonNull
	public Injector getInjector() {
		return OCLinEcoreStandaloneSetup.getInjector();
	}
}
