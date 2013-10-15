package org.eclipse.ocl.examples.xtext.oclinecore.cs2as;

import org.eclipse.ocl.examples.xtext.base.cs2as.BaseCS2ASRuntimeModule;
import org.eclipse.ocl.examples.xtext.base.cs2as.ICS2ASFactory;

public class OCLinEcoreCS2ASRuntimeModule extends BaseCS2ASRuntimeModule {

	public Class<? extends ICS2ASFactory> bindICS2ASFactory() {
		return OCLinEcoreCS2ASFactory.class;
	}
}