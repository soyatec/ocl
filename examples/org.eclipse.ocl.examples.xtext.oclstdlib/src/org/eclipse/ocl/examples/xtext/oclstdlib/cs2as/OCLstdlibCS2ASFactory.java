package org.eclipse.ocl.examples.xtext.oclstdlib.cs2as;

import org.eclipse.ocl.examples.xtext.base.InjectorProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2ASFactory;

import com.google.inject.Inject;


public class OCLstdlibCS2ASFactory extends EssentialOCLCS2ASFactory {

	@Inject
	public OCLstdlibCS2ASFactory(InjectorProvider injectorProvider) {
		super(injectorProvider);
	}
}
