package org.eclipse.ocl.examples.xtext.completeocl.cs2as;

import org.eclipse.ocl.examples.xtext.base.cs2as.BaseCS2ASRuntimeModule;
import org.eclipse.ocl.examples.xtext.base.cs2as.ICS2ASFactory;


public class CompleteOCLCS2ASRuntimeModule extends BaseCS2ASRuntimeModule {
		 
	public Class<? extends ICS2ASFactory> bindICS2ASFactory() {
		return CompleteOCLCS2ASFactory.class;
	}
}