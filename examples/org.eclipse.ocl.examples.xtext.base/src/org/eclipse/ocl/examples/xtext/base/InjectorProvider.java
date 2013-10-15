package org.eclipse.ocl.examples.xtext.base;

import org.eclipse.jdt.annotation.NonNull;

import com.google.inject.Injector;


public interface InjectorProvider {

	@NonNull
	public Injector getInjector();
}