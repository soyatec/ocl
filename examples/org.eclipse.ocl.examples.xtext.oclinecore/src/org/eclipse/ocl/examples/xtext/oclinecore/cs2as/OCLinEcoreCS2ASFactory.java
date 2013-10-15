package org.eclipse.ocl.examples.xtext.oclinecore.cs2as;

import org.eclipse.ocl.examples.xtext.base.InjectorProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2ASFactory;

import com.google.inject.Inject;


public class OCLinEcoreCS2ASFactory extends EssentialOCLCS2ASFactory {

	@Inject
	public OCLinEcoreCS2ASFactory(InjectorProvider injectorProvider) {
		super(injectorProvider);
	}
}
