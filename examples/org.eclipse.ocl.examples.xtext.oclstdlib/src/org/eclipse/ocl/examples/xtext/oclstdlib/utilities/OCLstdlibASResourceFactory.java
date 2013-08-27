package org.eclipse.ocl.examples.xtext.oclstdlib.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.resource.AbstractASResourceFactory;

public final class OCLstdlibASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull OCLstdlibASResourceFactory INSTANCE = new OCLstdlibASResourceFactory();
	
	protected OCLstdlibASResourceFactory() {
		super(ASResource.OCLSTDLIB_CONTENT_TYPE, null);
	}
}