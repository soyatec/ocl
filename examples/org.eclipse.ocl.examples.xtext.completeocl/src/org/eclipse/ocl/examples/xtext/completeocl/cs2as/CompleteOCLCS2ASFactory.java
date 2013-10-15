package org.eclipse.ocl.examples.xtext.completeocl.cs2as;

import org.eclipse.ocl.examples.xtext.base.InjectorProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2ASFactory;

import com.google.inject.Inject;

public class CompleteOCLCS2ASFactory extends EssentialOCLCS2ASFactory {

	@Inject
	public CompleteOCLCS2ASFactory(InjectorProvider injectorProvider) {
		super(injectorProvider);
	}
}
