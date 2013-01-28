package org.eclipse.ocl.examples.build.extenders.utilities;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.ocl.examples.build.utilities.QVToWorkflowComponent;

/**
 * extra input:
 *    - derivedVisitorInterfaceName: A mandatory name of the interface visitor which will be
 *    weaved into the ecore model
 *    
 *    
 *    
 *    
 *    
 * @author asbh
 *
 */
public class OCLExtenderVisitorPatternWeaverComponent extends QVToWorkflowComponent {
	private String baseVisitorInterfaceName;
	private String derivedVisitorInterfaceName;
	private String derivedVisitorInterfaceQualifiedName;
	
	public String getBaseVisitorInterfaceName() {
		return baseVisitorInterfaceName;
	}
	
	public void setBaseVisitorInterfaceName(String baseVisitorInterfaceName) {
		this.baseVisitorInterfaceName = baseVisitorInterfaceName;
	}
	
	public String getDerivedVisitorInterfaceName() {
		return derivedVisitorInterfaceName;
	}
	
	public void setDerivedVisitorInterfaceName(String derivedVisitorInterfaceName) {
		this.derivedVisitorInterfaceName = derivedVisitorInterfaceName;
	}	
	
	public String getDerivedVisitorInterfaceQualifiedName() {
		return derivedVisitorInterfaceQualifiedName;
	}

	
	public void setDerivedVisitorInterfaceQualifiedName(
			String derivedVisitorInterfaceQualifiedName) {
		this.derivedVisitorInterfaceQualifiedName = derivedVisitorInterfaceQualifiedName;
	}
		
	@Override
	public void checkConfiguration(Issues issues) {
		if (derivedVisitorInterfaceName == null) {
			issues.addError(this, "derivedVisitorInterfaceName not specified.");
		}
	}
	
	@Override
	protected void initializeConfigurationProperties(ExecutionContextImpl context) {
		
		context.setConfigProperty("baseVisitorInterfaceName", getBaseVisitorInterfaceName());
		context.setConfigProperty("derivedVisitorInterfaceName", getDerivedVisitorInterfaceName());
		context.setConfigProperty("derivedVisitorInterfaceQualifiedName", getDerivedVisitorInterfaceQualifiedName());
	}
}