package org.eclipse.ocl.examples.xtext.base.cs2as;

import org.eclipse.ocl.examples.xtext.base.InjectorProvider;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class BaseCS2ASFactory implements ICS2ASFactory {
	
	private final InjectorProvider injectorProvider;
	
	@Inject
	public BaseCS2ASFactory(InjectorProvider injectorProvider) {
		this.injectorProvider = injectorProvider;
	}
	
	public Continuations createContinuations() {
		return getInjector().getInstance(Continuations.class);
	}
	
	protected final Injector getInjector() {
		return injectorProvider.getInjector();
	}
}