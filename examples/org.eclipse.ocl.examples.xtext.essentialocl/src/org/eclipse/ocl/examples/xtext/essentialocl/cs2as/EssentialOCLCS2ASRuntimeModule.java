package org.eclipse.ocl.examples.xtext.essentialocl.cs2as;

import org.eclipse.ocl.examples.xtext.base.cs2as.BaseCS2ASRuntimeModule;
import org.eclipse.ocl.examples.xtext.base.cs2as.ICS2ASFactory;


public class EssentialOCLCS2ASRuntimeModule extends BaseCS2ASRuntimeModule {
		
	/**
	 * @return 
	 */ 
	public Class<? extends ICS2ASFactory> bindICS2ASFactory() {
		return EssentialOCLCS2ASFactory.class;
	}
}