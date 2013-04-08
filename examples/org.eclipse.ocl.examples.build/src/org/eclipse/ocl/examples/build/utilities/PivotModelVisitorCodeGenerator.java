package org.eclipse.ocl.examples.build.utilities;

import org.eclipse.ocl.examples.xtext.oclstdlib.OCLstdlibStandaloneSetup;


public class PivotModelVisitorCodeGenerator extends ModelVisitorCodeGenerator {
	
	public PivotModelVisitorCodeGenerator() {
		super();
		OCLstdlibStandaloneSetup.doSetup();
	}
}
