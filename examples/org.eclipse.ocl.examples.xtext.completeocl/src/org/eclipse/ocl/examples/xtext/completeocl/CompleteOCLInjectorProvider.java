package org.eclipse.ocl.examples.xtext.completeocl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.InjectorProvider;

import com.google.inject.Injector;


public class CompleteOCLInjectorProvider implements InjectorProvider{

	@NonNull
	public Injector getInjector() {
		return CompleteOCLStandaloneSetup.getInjector();
	}
}