package org.eclipse.ocl.examples.build.utilities;


public abstract class PredefinedQVToTransformationExecutor extends QVToTransformationExecutor {

	
	/**
	 * @deprecated calling this method will throw {@link IllegalAccessException} since
	 * {@link PredefinedQVToTransformationExecutor} components should not allow setting a new
	 * transformation uri. Such a URI is already defined by the own component
	 */
	@Override
	@Deprecated
	public void setUri(String uri) {
		throw new IllegalArgumentException("Predefined QVTo transformations components shall not receive a new transformation URI");
	}
	
	@Override
	public final String getUri() {
		return getPredefinedTransformationURI();
	}
	
	/**
	 * @return the predefined transformation URI for this component
	 */
	abstract protected String getPredefinedTransformationURI();
	
}
