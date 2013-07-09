/**
 * <copyright>
 * 
 * Copyright (c) 2013 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.build.xtend;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.build.xtend.GenerateVisitors;
import org.eclipse.ocl.examples.build.xtend.GenerateXtextVisitors;
import org.eclipse.ocl.examples.build.xtend.MergeWriter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class GenerateCS2ASVisitors extends GenerateXtextVisitors {
  public void generateVisitors(final EPackage ePackage) {
    super.generateVisitors(ePackage);
    this.generateContainmentVisitor(ePackage);
    this.generatePreOrderVisitor(ePackage);
    this.generatePostOrderVisitor(ePackage);
    this.generateLeft2RightVisitor(ePackage);
  }
  
  protected void generateContainmentVisitor(@NonNull final EPackage ePackage) {
    String visitorVariant = "Containment";
    String resultTypeName = "Continuation<?>";
    String _projectPrefix = this.getProjectPrefix();
    String _plus = ("Abstract" + _projectPrefix);
    String _plus_1 = (_plus + visitorVariant);
    String className = (_plus_1 + "Visitor");
    String _superProjectPrefix = this.getSuperProjectPrefix();
    String _plus_2 = (_superProjectPrefix + visitorVariant);
    String extendedClass = (_plus_2 + "Visitor");
    String _visitorClassName = this.getVisitorClassName();
    String _plus_3 = (_visitorClassName + "<");
    String _plus_4 = (_plus_3 + resultTypeName);
    String interfaceName = (_plus_4 + ">");
    ArrayList<String> _arrayList = new ArrayList<String>();
    List<String> additionalImports = _arrayList;
    additionalImports.add("org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion");
    additionalImports.add("org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation");
    this.generateContextfulAbstractExtendingVisitor(ePackage, className, extendedClass, interfaceName, resultTypeName, additionalImports);
  }
  
  protected void generatePreOrderVisitor(@NonNull final EPackage ePackage) {
    String visitorVariant = "PreOrder";
    String resultTypeName = "Continuation<?>";
    String _projectPrefix = this.getProjectPrefix();
    String _plus = ("Abstract" + _projectPrefix);
    String _plus_1 = (_plus + visitorVariant);
    String className = (_plus_1 + "Visitor");
    String _superProjectPrefix = this.getSuperProjectPrefix();
    String _plus_2 = (_superProjectPrefix + visitorVariant);
    String extendedClass = (_plus_2 + "Visitor");
    String _visitorClassName = this.getVisitorClassName();
    String _plus_3 = (_visitorClassName + "<");
    String _plus_4 = (_plus_3 + resultTypeName);
    String interfaceName = (_plus_4 + ">");
    ArrayList<String> _arrayList = new ArrayList<String>();
    List<String> additionalImports = _arrayList;
    additionalImports.add("org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion");
    additionalImports.add("org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation");
    this.generateContextfulAbstractExtendingVisitor(ePackage, className, extendedClass, interfaceName, resultTypeName, additionalImports);
  }
  
  protected void generatePostOrderVisitor(@NonNull final EPackage ePackage) {
    String visitorVariant = "PostOrder";
    String resultTypeName = "Continuation<?>";
    String _projectPrefix = this.getProjectPrefix();
    String _plus = ("Abstract" + _projectPrefix);
    String _plus_1 = (_plus + visitorVariant);
    String className = (_plus_1 + "Visitor");
    String _superProjectPrefix = this.getSuperProjectPrefix();
    String _plus_2 = (_superProjectPrefix + visitorVariant);
    String extendedClass = (_plus_2 + "Visitor");
    String _visitorClassName = this.getVisitorClassName();
    String _plus_3 = (_visitorClassName + "<");
    String _plus_4 = (_plus_3 + resultTypeName);
    String interfaceName = (_plus_4 + ">");
    ArrayList<String> _arrayList = new ArrayList<String>();
    List<String> additionalImports = _arrayList;
    additionalImports.add("org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion");
    additionalImports.add("org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation");
    this.generateContextfulAbstractExtendingVisitor(ePackage, className, extendedClass, interfaceName, resultTypeName, additionalImports);
  }
  
  protected void generateLeft2RightVisitor(@NonNull final EPackage ePackage) {
    String visitorVariant = "Left2Right";
    String resultTypeName = "Element";
    String _projectPrefix = this.getProjectPrefix();
    String _plus = ("Abstract" + _projectPrefix);
    String _plus_1 = (_plus + visitorVariant);
    String className = (_plus_1 + "Visitor");
    String _superProjectPrefix = this.getSuperProjectPrefix();
    String _plus_2 = (_superProjectPrefix + visitorVariant);
    String extendedClass = (_plus_2 + "Visitor");
    String _visitorClassName = this.getVisitorClassName();
    String _plus_3 = (_visitorClassName + "<");
    String _plus_4 = (_plus_3 + resultTypeName);
    String interfaceName = (_plus_4 + ">");
    ArrayList<String> _arrayList = new ArrayList<String>();
    List<String> additionalImports = _arrayList;
    additionalImports.add("org.eclipse.ocl.examples.pivot.Element");
    this.generateContextfulAbstractExtendingVisitor(ePackage, className, extendedClass, interfaceName, resultTypeName, additionalImports);
  }
  
  /**
   * Assumptions to be considered:
   * - the package of the extended visitor of generated visitors need to be qualified as follows:
   *    <code> «superProjectName».cs2as </code>
   */
  protected void generateContextfulAbstractExtendingVisitor(@NonNull final EPackage ePackage, @NonNull final String className, @NonNull final String extendedClassName, @NonNull final String interfaceName, @NonNull final String resultTypeName, @NonNull final List<String> additionalImports) {
    try {
      String _outputFolder = this.getOutputFolder();
      String _plus = (_outputFolder + className);
      String _plus_1 = (_plus + ".java");
      MergeWriter _mergeWriter = new MergeWriter(_plus_1);
      MergeWriter writer = _mergeWriter;
      StringConcatenation _builder = new StringConcatenation();
      String _visitorPackageName = this.getVisitorPackageName();
      String _generateHeader = this.generateHeader(ePackage, _visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.append("import ");
      String _superProjectName = this.getSuperProjectName();
      _builder.append(_superProjectName, "");
      _builder.append(".cs2as.");
      _builder.append(extendedClassName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      {
        for(final String addtionalImport : additionalImports) {
          _builder.append("import ");
          _builder.append(addtionalImport, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An ");
      _builder.append(className, " ");
      _builder.append(" provides a default implementation for each");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* visitXxx method that delegates to the visitYyy method of the first");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* super class, (or transitively its first super class first super class");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* until a non-interface super-class is found). In the absence of any");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* suitable first super class, the method delegates to visiting().");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class ");
      _builder.append(className, "");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("extends ");
      _builder.append(extendedClassName, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("implements ");
      _builder.append(interfaceName, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Initializes me with an initial value for my result.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* ");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param context my initial result value");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected ");
      _builder.append(className, "	");
      _builder.append("(@NonNull CS2PivotConversion context) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(context);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}\t");
      _builder.newLine();
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.append("\t");
          EClass firstSuperClass = GenerateVisitors.firstSuperClass(eClass, eClass);
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public @Nullable ");
          _builder.append(resultTypeName, "	");
          _builder.append(" visit");
          String _name = eClass.getName();
          _builder.append(_name, "	");
          _builder.append("(@NonNull ");
          String _modelPackageName = this.getModelPackageName();
          _builder.append(_modelPackageName, "	");
          _builder.append(".");
          String _name_1 = eClass.getName();
          _builder.append(_name_1, "	");
          _builder.append(" object) {");
          _builder.newLineIfNotEmpty();
          {
            boolean _equals = Objects.equal(firstSuperClass, eClass);
            if (_equals) {
              _builder.append("\t\t");
              _builder.append("return visiting(object);");
              _builder.newLine();
            } else {
              _builder.append("\t\t");
              _builder.append("return visit");
              String _name_2 = firstSuperClass.getName();
              _builder.append(_name_2, "		");
              _builder.append("(object);");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
