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
	private String baseVisitorInterfaceQualifiedName;
	private String superVisitorInterfaceName;
	private String superVisitorInterfaceQualifiedName;
	private String derivedVisitorInterfaceName;
	private String derivedVisitorInterfaceQualifiedName;
	
	public String getBaseVisitorInterfaceName() {
		return baseVisitorInterfaceName;
	}
	
	public void setBaseVisitorInterfaceName(String baseVisitorInterfaceName) {
		this.baseVisitorInterfaceName = baseVisitorInterfaceName;
	}
	
	public String getBaseVisitorInterfaceQualifiedName() {
		return baseVisitorInterfaceQualifiedName;
	}

	public void setBaseVisitorInterfaceQualifiedName(
			String baseVisitorInterfaceQualifiedName) {
		this.baseVisitorInterfaceQualifiedName = baseVisitorInterfaceQualifiedName;
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

	

	public String getSuperVisitorInterfaceName() {
		return superVisitorInterfaceName;
	}

	public void setSuperVisitorInterfaceName(String superVisitorInterfaceName) {
		this.superVisitorInterfaceName = superVisitorInterfaceName;
	}

	public String getSuperVisitorInterfaceQualifiedName() {
		return superVisitorInterfaceQualifiedName;
	}

	public void setSuperVisitorInterfaceQualifiedName(
			String superVisitorInterfaceQualifiedName) {
		this.superVisitorInterfaceQualifiedName = superVisitorInterfaceQualifiedName;
	}

	@Override
	public void checkConfiguration(Issues issues) {
		if (derivedVisitorInterfaceName == null) {
			issues.addError(this, "derivedVisitorInterfaceName not specified.");
		}
		if (derivedVisitorInterfaceQualifiedName == null) {
			issues.addError(this, "derivedVisitorInterfaceQualifiedName not specified.");
		}
	}
	
	@Override
	protected void initializeConfigurationProperties(ExecutionContextImpl context) {
		context.setConfigProperty("derivedVisitorInterfaceName", getDerivedVisitorInterfaceName());
		context.setConfigProperty("derivedVisitorInterfaceQualifiedName", getDerivedVisitorInterfaceQualifiedName());
		context.setConfigProperty("superVisitorInterfaceName", getSuperVisitorInterfaceName());
		context.setConfigProperty("superVisitorInterfaceQualifiedName", getSuperVisitorInterfaceQualifiedName());
		context.setConfigProperty("baseVisitorInterfaceName", getBaseVisitorInterfaceName() == null ? 
				getSuperVisitorInterfaceName() : getBaseVisitorInterfaceName());
		context.setConfigProperty("baseVisitorInterfaceQualifiedName", getBaseVisitorInterfaceQualifiedName() == null ?
				getSuperVisitorInterfaceQualifiedName() : getBaseVisitorInterfaceQualifiedName());
	}
}