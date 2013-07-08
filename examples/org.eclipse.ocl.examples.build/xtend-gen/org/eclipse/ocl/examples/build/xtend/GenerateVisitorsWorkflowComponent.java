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
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public abstract class GenerateVisitorsWorkflowComponent extends AbstractWorkflowComponent {
  protected Logger log = new Function0<Logger>() {
    public Logger apply() {
      Class<? extends GenerateVisitorsWorkflowComponent> _class = GenerateVisitorsWorkflowComponent.this.getClass();
      Logger _logger = Logger.getLogger(_class);
      return _logger;
    }
  }.apply();
  
  private final static String EMPTY_STRING = "";
  
  protected ResourceSet resourceSet = null;
  
  protected String projectName;
  
  protected String modelPackageName;
  
  protected String visitorPackageName;
  
  protected String visitorClassName;
  
  protected String visitablePackageName;
  
  protected String visitableClassName;
  
  protected String javaFolder;
  
  protected String genModelFile;
  
  protected String superVisitorClassName = "";
  
  protected String superVisitorPackageName = "";
  
  protected String sourceFile = "";
  
  protected String copyright = "";
  
  protected String outputFolder = "";
  
  public void checkConfiguration(final Issues issues) {
    boolean _equals = Objects.equal(this.modelPackageName, null);
    if (_equals) {
      issues.addError(this, "modelPackageName not specified.");
    }
    boolean _equals_1 = Objects.equal(this.visitorPackageName, null);
    if (_equals_1) {
      issues.addError(this, "visitorPackageName not specified.");
    }
    boolean _equals_2 = Objects.equal(this.visitorClassName, null);
    if (_equals_2) {
      issues.addError(this, "visitorClassName not specified.");
    }
    boolean _equals_3 = Objects.equal(this.visitableClassName, null);
    if (_equals_3) {
      issues.addError(this, "visitableClassName not specified.");
    }
    boolean _equals_4 = Objects.equal(this.genModelFile, null);
    if (_equals_4) {
      issues.addError(this, "genModelFile not specified.");
    }
  }
  
  public abstract void generateVisitors(final EPackage ePackage);
  
  private String getCopyright(final Resource genModelResource) {
    EList<EObject> _contents = genModelResource.getContents();
    EObject _get = _contents.get(0);
    GenModel genModel = ((GenModel) _get);
    String copyright = genModel.getCopyright("");
    String _xifexpression = null;
    boolean _equals = Objects.equal(copyright, null);
    if (_equals) {
      _xifexpression = GenerateVisitorsWorkflowComponent.EMPTY_STRING;
    } else {
      _xifexpression = copyright;
    }
    return _xifexpression;
  }
  
  private EPackage getEPackage(final Resource genModelResource) {
    EList<EObject> _contents = genModelResource.getContents();
    EObject _get = _contents.get(0);
    GenModel genModel = ((GenModel) _get);
    List<GenPackage> genPackages = genModel.getAllGenPackagesWithConcreteClasses();
    EPackage _xifexpression = null;
    boolean _isEmpty = genPackages.isEmpty();
    if (_isEmpty) {
      _xifexpression = null;
    } else {
      GenPackage _get_1 = genPackages.get(0);
      EPackage _ecorePackage = _get_1.getEcorePackage();
      _xifexpression = _ecorePackage;
    }
    return _xifexpression;
  }
  
  protected void invokeInternal(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
    boolean _equals = Objects.equal(this.visitablePackageName, null);
    if (_equals) {
      this.visitablePackageName = this.visitorPackageName;
    }
    boolean _equals_1 = Objects.equal(this.superVisitorPackageName, null);
    if (_equals_1) {
      this.superVisitorPackageName = this.visitorPackageName;
    }
    Map<String,URI> _platformResourceMap = EcorePlugin.getPlatformResourceMap();
    URI projectFileURI = _platformResourceMap.get(this.projectName);
    String _plus = ("/" + this.projectName);
    String _plus_1 = (_plus + "/");
    URI projectResourceURI = URI.createPlatformResourceURI(_plus_1, true);
    URI _createURI = URI.createURI(this.genModelFile);
    URI genModelURI = _createURI.resolve(projectResourceURI);
    String _plus_2 = (this.javaFolder + "/");
    String _replace = this.visitorPackageName.replace(".", "/");
    String _plus_3 = (_plus_2 + _replace);
    URI outputURI = URI.createURI(_plus_3);
    URI resolvedOutputURI = outputURI.resolve(projectFileURI);
    String _string = resolvedOutputURI.toString();
    String _plus_4 = (_string + "/");
    this.outputFolder = _plus_4;
    boolean _startsWith = this.outputFolder.startsWith("file:/");
    if (_startsWith) {
      String _substring = this.outputFolder.substring(6);
      this.outputFolder = _substring;
    }
    String _plus_5 = ("Loading GenModel \'" + genModelURI);
    this.log.info(_plus_5);
    try {
      Resource genModelResource = this.resourceSet.getResource(genModelURI, true);
      EPackage targetEPackage = this.getEPackage(genModelResource);
      String _copyright = this.getCopyright(genModelResource);
      this.copyright = _copyright;
      this.sourceFile = this.genModelFile;
      this.generateVisitors(targetEPackage);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        Class<? extends GenerateVisitorsWorkflowComponent> _class = this.getClass();
        String _simpleName = _class.getSimpleName();
        String _plus_6 = ("Problems running " + _simpleName);
        RuntimeException _runtimeException = new RuntimeException(_plus_6, e);
        throw _runtimeException;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * The path within the project to the genmodel file that identifies the Ecore file
   * from which the EMF generated interfaces derive. Also provides the copyright for
   * generated Visitor interfaces. (e.g. "model/my.genmodel")
   */
  public void setGenModelFile(final String genModelFile) {
    this.genModelFile = genModelFile;
  }
  
  /**
   * The folder within the project that forms the root of EMF generated sources. (e.g. "src" or "emf-gen")
   */
  public void setJavaFolder(final String javaFolder) {
    this.javaFolder = javaFolder;
  }
  
  /**
   * The package name of the EMF generated interfaces. (e.g. "org.my.project")
   */
  public void setModelPackageName(final String modelPackageName) {
    this.modelPackageName = modelPackageName;
  }
  
  /**
   * The project name containing the genmodel and generated EMF sources. (e.g. "org.my.project")
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
  
  public void setSuperVisitorClassName(final String superVisitorClassName) {
    this.superVisitorClassName = superVisitorClassName;
  }
  
  public void setSuperVisitorPackageName(final String superVisitorPackageName) {
    this.superVisitorPackageName = superVisitorPackageName;
  }
  
  /**
   * The class name for the referenced Visitable interface. (e.g. "Visitable")
   */
  public void setVisitableClassName(final String visitableClassName) {
    this.visitableClassName = visitableClassName;
  }
  
  /**
   * The package name for the referenced Visitable interface. (e.g. "org.my.project.util")
   * If unspecified the visitorPackageName is used.
   */
  public void setVisitablePackageName(final String visitablePackageName) {
    this.visitablePackageName = visitablePackageName;
  }
  
  /**
   * The required class name for the generated Visitor interface. (e.g. "Visitor")
   */
  public void setVisitorClassName(final String visitorClassName) {
    this.visitorClassName = visitorClassName;
  }
  
  /**
   * The required package name for the generated Visitor interface. (e.g. "org.my.project.util")
   */
  public void setVisitorPackageName(final String visitorPackageName) {
    this.visitorPackageName = visitorPackageName;
  }
}
