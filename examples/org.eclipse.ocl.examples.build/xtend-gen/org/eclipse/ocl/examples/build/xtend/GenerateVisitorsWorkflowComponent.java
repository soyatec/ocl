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
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - bug397429
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.build.xtend;

import com.google.common.base.Objects;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IProjectDescriptor;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public abstract class GenerateVisitorsWorkflowComponent extends AbstractWorkflowComponent {
  private Logger log = new Function0<Logger>() {
    public Logger apply() {
      Class<? extends GenerateVisitorsWorkflowComponent> _class = GenerateVisitorsWorkflowComponent.this.getClass();
      Logger _logger = Logger.getLogger(_class);
      return _logger;
    }
  }.apply();
  
  private final static String EMPTY_STRING = "";
  
  private ResourceSet resourceSet = null;
  
  private String projectPrefix;
  
  private String superProjectPrefix;
  
  private String projectName;
  
  private String superProjectName;
  
  private String modelPackageName;
  
  private String superModelPackageName;
  
  private String visitorPackageName;
  
  private String visitorClassName;
  
  private String visitablePackageName;
  
  private String visitableClassName;
  
  private String javaFolder;
  
  private String genModelFile;
  
  private String superVisitorClassName;
  
  private String superVisitorPackageName;
  
  private String sourceFile = "";
  
  private String copyright = "";
  
  private String outputFolder = "";
  
  public void checkConfiguration(final Issues issues) {
    boolean _equals = Objects.equal(this.projectName, null);
    if (_equals) {
      issues.addError(this, "projectName not specified.");
    }
    boolean _equals_1 = Objects.equal(this.projectPrefix, null);
    if (_equals_1) {
      issues.addError(this, "languageName not specified.");
    }
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(this.superProjectName, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _equals_2 = Objects.equal(this.superProjectPrefix, null);
      _and = (_notEquals && _equals_2);
    }
    if (_and) {
      issues.addError(this, "If you provide a superProjectName for an extended language, you must provide superProjectPrefix.");
    }
    boolean _and_1 = false;
    boolean _equals_3 = Objects.equal(this.superProjectName, null);
    if (!_equals_3) {
      _and_1 = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(this.superProjectPrefix, null));
      _and_1 = (_equals_3 && _notEquals_1);
    }
    if (_and_1) {
      issues.addError(this, "If you don\'t provide a superProjectName, providing a superProjectPrefix for an extended language is not expected.");
    }
    boolean _and_2 = false;
    boolean _notEquals_2 = (!Objects.equal(this.superVisitorClassName, null));
    if (!_notEquals_2) {
      _and_2 = false;
    } else {
      boolean _equals_4 = Objects.equal(this.superVisitorPackageName, null);
      _and_2 = (_notEquals_2 && _equals_4);
    }
    if (_and_2) {
      issues.addError(this, "If you provide a superVisitorClassName for the extended language, you must provide a superVisitorPackageName as well.");
    }
    boolean _and_3 = false;
    boolean _equals_5 = Objects.equal(this.superVisitorClassName, null);
    if (!_equals_5) {
      _and_3 = false;
    } else {
      boolean _notEquals_3 = (!Objects.equal(this.superVisitorPackageName, null));
      _and_3 = (_equals_5 && _notEquals_3);
    }
    if (_and_3) {
      issues.addError(this, "If you don\'t provide a superVisitorClassName, providing a superVisitorPackageName for an extended language is not expected.");
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
    ResourceSet resourceSet = this.getResourceSet();
    StandaloneProjectMap projectMap = StandaloneProjectMap.getAdapter(resourceSet);
    String _projectName = this.getProjectName();
    IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor(_projectName);
    String _genModelFile = this.getGenModelFile();
    URI genModelURI = projectDescriptor.getPlatformResourceURI(_genModelFile);
    String _javaFolder = this.getJavaFolder();
    String _plus = (_javaFolder + "/");
    String _visitorPackageName = this.getVisitorPackageName();
    String _replace = _visitorPackageName.replace(".", "/");
    String _plus_1 = (_plus + _replace);
    File _locationFile = projectDescriptor.getLocationFile(_plus_1);
    String _string = _locationFile.toString();
    String _plus_2 = (_string + "/");
    this.outputFolder = _plus_2;
    String _plus_3 = ("Loading Pivot Model \'" + genModelURI);
    this.log.info(_plus_3);
    try {
      Resource genModelResource = resourceSet.getResource(genModelURI, true);
      EPackage targetEPackage = this.getEPackage(genModelResource);
      String _copyright = this.getCopyright(genModelResource);
      this.copyright = _copyright;
      String _genModelFile_1 = this.getGenModelFile();
      this.sourceFile = _genModelFile_1;
      this.generateVisitors(targetEPackage);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        Class<? extends GenerateVisitorsWorkflowComponent> _class = this.getClass();
        String _simpleName = _class.getSimpleName();
        String _plus_4 = ("Problems running " + _simpleName);
        RuntimeException _runtimeException = new RuntimeException(_plus_4, e);
        throw _runtimeException;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * The optional path within the project to the genmodel file that identifies the Ecore file
   * from which the EMF generated interfaces derive. Also provides the copyright for
   * generated Visitor interfaces. (e.g. "model/my.genmodel")
   * <p>
   * If not provided <code>"model/"+getProjectPrefix+".genmodel"<code> will be used.
   * </p>
   */
  public void setGenModelFile(final String genModelFile) {
    this.genModelFile = genModelFile;
  }
  
  /**
   * The folder within the project that forms the root of EMF generated sources. (e.g. "src" or "emf-gen")
   * 
   * <p>
   * If not provided <code>"src"<code> will be used.
   * </p>
   */
  public void setJavaFolder(final String javaFolder) {
    this.javaFolder = javaFolder;
  }
  
  /**
   * The optional package name of the EMF generated interfaces. (e.g. "org.my.project")
   * <p>
   * If not provided <code>getProjectName+"."+getProjectPrefix.toLowerCase<code> will be used.
   * </p>
   */
  public void setModelPackageName(final String modelPackageName) {
    this.modelPackageName = modelPackageName;
  }
  
  /**
   * The optional package name of the EMF generated interfaces of extended language. (e.g. "org.my.extendedproject")
   * <p>
   * If not provided <code>getSuperProjectName+"."+getSuperProjectPrefix.toLowerCase<code> will be used.
   * </p>
   */
  public void setSuperModelPackageName(final String superModelPackageName) {
    this.superModelPackageName = superModelPackageName;
  }
  
  /**
   * The mandatory project name containing the genmodel and generated EMF sources. (e.g. "org.my.project")
   */
  public void setProjectName(final String projectName) {
    this.projectName = projectName;
  }
  
  /**
   * The mandatory project name containing the genmodel and generated EMF sources of the extended language. (e.g. "org.my.extendedproject")
   */
  public void setSuperProjectName(final String superProjectName) {
    this.superProjectName = superProjectName;
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
   * The optional class name for the referenced Visitable interface. (e.g. "Visitable")
   * <p>
   * If not provided <code>getProjectPrefix.toFirstUpper + "Visitable"<code> will be used.
   * </p>
   */
  public void setVisitableClassName(final String visitableClassName) {
    this.visitableClassName = visitableClassName;
  }
  
  /**
   * The package name for the referenced Visitable interface. (e.g. "org.my.project.util")
   * <p>
   * If not provided <code>visitorPackageName<code> will be used.
   * </p>
   */
  public void setVisitablePackageName(final String visitablePackageName) {
    this.visitablePackageName = visitablePackageName;
  }
  
  /**
   * The optional class name for the generated Visitor interface. (e.g. "Visitor").
   * <p>
   * If not provided <code>getProjectPrefix.toFirstUpper + "Visitor"<code> will be used.
   * </p>
   */
  public void setVisitorClassName(final String visitorClassName) {
    this.visitorClassName = visitorClassName;
  }
  
  /**
   * The required package name for the generated Visitor interface. (e.g. "org.my.project.util")
   * <p>
   * If not provided <code>modelPackageName + "util"<code> will be used.
   * </p>
   */
  public void setVisitorPackageName(final String visitorPackageName) {
    this.visitorPackageName = visitorPackageName;
  }
  
  /**
   * The required name of the language. It me used as prefix for some interfaces/classes
   * so it should be in UpperCamelCase format.
   */
  public void setProjectPrefix(final String projectPrefix) {
    this.projectPrefix = projectPrefix;
  }
  
  /**
   * The required name of the extended language. It me used as prefix for some interfaces/classes
   * so it should be in UpperCamelCase format.
   */
  public void setSuperProjectPrefix(final String superProjectPrefix) {
    this.superProjectPrefix = superProjectPrefix;
  }
  
  protected String getGenModelFile() {
    boolean _equals = Objects.equal(this.genModelFile, null);
    if (_equals) {
      String _plus = ("model/" + this.projectPrefix);
      return (_plus + ".genmodel");
    }
    return this.genModelFile;
  }
  
  protected String getJavaFolder() {
    boolean _equals = Objects.equal(this.javaFolder, null);
    if (_equals) {
      return "src";
    }
    return this.javaFolder;
  }
  
  protected String getModelPackageName() {
    boolean _equals = Objects.equal(this.modelPackageName, null);
    if (_equals) {
      String _projectName = this.getProjectName();
      String _plus = (_projectName + ".");
      String _projectPrefix = this.getProjectPrefix();
      String _lowerCase = _projectPrefix.toLowerCase();
      return (_plus + _lowerCase);
    }
    return this.modelPackageName;
  }
  
  protected String getSuperModelPackageName() {
    boolean _equals = Objects.equal(this.superModelPackageName, null);
    if (_equals) {
      String _superProjectName = this.getSuperProjectName();
      boolean _notEquals = (!Objects.equal(_superProjectName, null));
      if (_notEquals) {
        String _superProjectName_1 = this.getSuperProjectName();
        String _plus = (_superProjectName_1 + ".");
        String _superProjectPrefix = this.getSuperProjectPrefix();
        String _lowerCase = _superProjectPrefix.toLowerCase();
        return (_plus + _lowerCase);
      }
    }
    return this.superModelPackageName;
  }
  
  protected String getProjectName() {
    return this.projectName;
  }
  
  protected String getSuperProjectName() {
    return this.superProjectName;
  }
  
  protected ResourceSet getResourceSet() {
    return this.resourceSet;
  }
  
  protected String getSuperVisitorClassName() {
    boolean _equals = Objects.equal(this.superVisitorClassName, null);
    if (_equals) {
      String _superProjectPrefix = this.getSuperProjectPrefix();
      boolean _notEquals = (!Objects.equal(_superProjectPrefix, null));
      if (_notEquals) {
        String _superProjectPrefix_1 = this.getSuperProjectPrefix();
        String _firstUpper = StringExtensions.toFirstUpper(_superProjectPrefix_1);
        return (_firstUpper + "Visitor");
      }
    }
    return this.superVisitorClassName;
  }
  
  protected String getSuperVisitorPackageName() {
    boolean _equals = Objects.equal(this.superVisitorPackageName, null);
    if (_equals) {
      String _superModelPackageName = this.getSuperModelPackageName();
      boolean _notEquals = (!Objects.equal(_superModelPackageName, null));
      if (_notEquals) {
        String _superModelPackageName_1 = this.getSuperModelPackageName();
        return (_superModelPackageName_1 + ".util");
      }
    }
    return this.superVisitorPackageName;
  }
  
  protected String getVisitorClassName() {
    boolean _equals = Objects.equal(this.visitorClassName, null);
    if (_equals) {
      String _projectPrefix = this.getProjectPrefix();
      String _firstUpper = StringExtensions.toFirstUpper(_projectPrefix);
      return (_firstUpper + "Visitor");
    }
    return this.visitorClassName;
  }
  
  protected String getVisitorPackageName() {
    boolean _equals = Objects.equal(this.visitorPackageName, null);
    if (_equals) {
      String _modelPackageName = this.getModelPackageName();
      return (_modelPackageName + ".util");
    }
    return this.visitorPackageName;
  }
  
  protected String getVisitableClassName() {
    boolean _equals = Objects.equal(this.visitableClassName, null);
    if (_equals) {
      String _projectPrefix = this.getProjectPrefix();
      String _firstUpper = StringExtensions.toFirstUpper(_projectPrefix);
      return (_firstUpper + "Visitable");
    }
    return this.visitableClassName;
  }
  
  protected String getVisitablePackageName() {
    boolean _equals = Objects.equal(this.visitablePackageName, null);
    if (_equals) {
      return this.getVisitorPackageName();
    }
    return this.visitablePackageName;
  }
  
  protected String getProjectPrefix() {
    return this.projectPrefix;
  }
  
  protected String getSuperProjectPrefix() {
    return this.superProjectPrefix;
  }
  
  protected String getOutputFolder() {
    return this.outputFolder;
  }
  
  protected String getSourceFile() {
    return this.sourceFile;
  }
  
  protected String getCopyright() {
    return this.copyright;
  }
  
  protected Logger getLogger() {
    return this.getLogger();
  }
}
