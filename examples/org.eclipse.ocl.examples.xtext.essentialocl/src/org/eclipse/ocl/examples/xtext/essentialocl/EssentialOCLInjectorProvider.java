package org.eclipse.ocl.examples.xtext.essentialocl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.InjectorProvider;

import com.google.inject.Injector;


public class EssentialOCLInjectorProvider implements InjectorProvider {

	public @NonNull	Injector getInjector() {
		return EssentialOCLStandaloneSetup.getInjector();
	}
}