package org.eclipse.ocl.examples.xtext.essentialocl.cs2as;

import org.eclipse.ocl.examples.xtext.base.InjectorProvider;
import org.eclipse.ocl.examples.xtext.base.cs2as.BaseCS2ASFactory;

import com.google.inject.Inject;


public class EssentialOCLCS2ASFactory extends BaseCS2ASFactory {

	@Inject
	public EssentialOCLCS2ASFactory(InjectorProvider injectorProvider) {
		super(injectorProvider);
	}
}
