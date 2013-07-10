/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.build.xtend;

import com.google.common.base.Objects;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.ocl.examples.xtext.oclstdlib.OCLstdlibStandaloneSetup;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public abstract class GenerateMetamodelWorkflowComponent extends AbstractWorkflowComponent {
  protected Logger log = new Function0<Logger>() {
    public Logger apply() {
      Class<? extends GenerateMetamodelWorkflowComponent> _class = GenerateMetamodelWorkflowComponent.this.getClass();
      Logger _logger = Logger.getLogger(_class);
      return _logger;
    }
  }.apply();
  
  protected ResourceSet resourceSet = null;
  
  protected String uri;
  
  protected String javaClassName;
  
  protected String javaFolder;
  
  protected String javaPackageName;
  
  protected String projectName;
  
  protected String modelFile;
  
  protected String sourceFile;
  
  protected GenerateMetamodelWorkflowComponent() {
    OCLstdlibStandaloneSetup.doSetup();
  }
  
  public void checkConfiguration(final Issues issues) {
    boolean _equals = Objects.equal(this.uri, null);
    if (_equals) {
      issues.addError(this, "uri not specified.");
    }
    boolean _equals_1 = Objects.equal(this.javaClassName, null);
    if (_equals_1) {
      issues.addError(this, "javaClassName not specified.");
    }
    boolean _equals_2 = Objects.equal(this.javaFolder, null);
    if (_equals_2) {
      issues.addError(this, "javaFolder not specified.");
    }
    boolean _equals_3 = Objects.equal(this.javaPackageName, null);
    if (_equals_3) {
      issues.addError(this, "javaPackageName not specified.");
    }
    boolean _equals_4 = Objects.equal(this.projectName, null);
    if (_equals_4) {
      issues.addError(this, "projectName not specified.");
    }
    boolean _equals_5 = Objects.equal(this.modelFile, null);
    if (_equals_5) {
      issues.addError(this, "modelFile not specified.");
    }
  }
  
  /**
   * The Class Name of the generated metamodel.
   */
  public void setJavaClassName(final String javaClassName) {
    this.javaClassName = javaClassName;
  }
  
  /**
   * The Java package path for the metamodel. (e.g. "org.eclipse.ocl.examples.pivot.path")
   */
  public void setJavaPackageName(final String javaPackageName) {
    this.javaPackageName = javaPackageName;
  }
  
  /**
   * The projectName relative path to the metamodel definition. (e.g. "model/Pivot.ecore")
   */
  public void setModelFile(final String modelFile) {
    this.modelFile = modelFile;
  }
  
  /**
   * The project name hosting the Metamodel. (e.g. "org.eclipse.ocl.examples.pivot")
   */
  public void setProjectName(final String projectName) {
    this.projectName = projectName;
  }
  
  /**
   * An optional ResourceSet that MWE components may share to reduce model loading.
   */
  public void setResourceSet(final ResourceSet resourceSet) {
    this.resourceSet = resourceSet;
  }
  
  /**
   * The nsURI for use in the generated metamodel. (e.g. "http://www.eclipse.org/ocl/3.1.0/Pivot").
   */
  public void setUri(final String uri) {
    this.uri = uri;
  }
}
