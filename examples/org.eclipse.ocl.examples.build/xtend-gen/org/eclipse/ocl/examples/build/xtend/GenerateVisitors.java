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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.build.xtend.GenerateVisitorsWorkflowComponent;
import org.eclipse.ocl.examples.build.xtend.MergeWriter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public abstract class GenerateVisitors extends GenerateVisitorsWorkflowComponent {
  protected static EClass firstSuperClass(final EClass eClass, final EClass nullClass) {
    EList<EClass> _eSuperTypes = eClass.getESuperTypes();
    int _size = _eSuperTypes.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      return nullClass;
    } else {
      EList<EClass> _eSuperTypes_1 = eClass.getESuperTypes();
      EClass eSuperClass = _eSuperTypes_1.get(0);
      boolean _isInterface = eSuperClass.isInterface();
      if (_isInterface) {
        return GenerateVisitors.firstSuperClass(eSuperClass, nullClass);
      } else {
        return eSuperClass;
      }
    }
  }
  
  @NonNull
  protected static List<EClass> getSortedEClasses(@NonNull final EPackage ePackage) {
    ArrayList<EClass> _arrayList = new ArrayList<EClass>();
    List<EClass> sortedEClasses = _arrayList;
    EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
    for (final EClassifier eClassifier : _eClassifiers) {
      boolean _and = false;
      if (!(eClassifier instanceof EClass)) {
        _and = false;
      } else {
        boolean _isInterface = ((EClass) eClassifier).isInterface();
        boolean _not = (!_isInterface);
        _and = ((eClassifier instanceof EClass) && _not);
      }
      if (_and) {
        sortedEClasses.add(((EClass) eClassifier));
      }
    }
    final Comparator<ENamedElement> _function = new Comparator<ENamedElement>() {
        public int compare(final ENamedElement e1, final ENamedElement e2) {
          String _name = e1.getName();
          String _name_1 = e2.getName();
          int _compareTo = _name.compareTo(_name_1);
          return _compareTo;
        }
      };
    Comparator<ENamedElement> comparator = _function;
    Collections.<EClass>sort(sortedEClasses, comparator);
    return sortedEClasses;
  }
  
  /**
   * AbstractDelegatingVisitor
   */
  protected void generateAbstractDelegatingVisitor(@NonNull final EPackage ePackage) {
    try {
      String _superVisitorPackageName = this.getSuperVisitorPackageName();
      Boolean isDerived = Boolean.valueOf((!Objects.equal(_superVisitorPackageName, null)));
      String _outputFolder = this.getOutputFolder();
      String _plus = (_outputFolder + "AbstractDelegating");
      String _visitorClassName = this.getVisitorClassName();
      String _plus_1 = (_plus + _visitorClassName);
      String _plus_2 = (_plus_1 + ".java");
      MergeWriter _mergeWriter = new MergeWriter(_plus_2);
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
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An AbstractDelegating");
      String _visitorClassName_1 = this.getVisitorClassName();
      _builder.append(_visitorClassName_1, " ");
      _builder.append(" delegates all visits.");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class AbstractDelegating");
      String _visitorClassName_2 = this.getVisitorClassName();
      _builder.append(_visitorClassName_2, "");
      _builder.append("<R, C, D extends ");
      String _visitorClassName_3 = this.getVisitorClassName();
      _builder.append(_visitorClassName_3, "");
      _builder.append("<R>>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("extends ");
      {
        if ((isDerived).booleanValue()) {
          String _superVisitorPackageName_1 = this.getSuperVisitorPackageName();
          _builder.append(_superVisitorPackageName_1, "	");
          _builder.append(".AbstractDelegating");
          String _superVisitorClassName = this.getSuperVisitorClassName();
          _builder.append(_superVisitorClassName, "	");
          _builder.append("<R, C, D>");
        } else {
          {
            if ((isDerived).booleanValue()) {
              String _superVisitorClassName_1 = this.getSuperVisitorClassName();
              _builder.append(_superVisitorClassName_1, "	");
            } else {
              _builder.append("Abstract");
              String _visitorClassName_4 = this.getVisitorClassName();
              _builder.append(_visitorClassName_4, "	");
            }
          }
          _builder.append("<R, C>");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("implements ");
      String _visitorClassName_5 = this.getVisitorClassName();
      _builder.append(_visitorClassName_5, "	");
      _builder.append("<R>");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      {
        if ((isDerived).booleanValue()) {
          _builder.append("\t");
          _builder.append("protected AbstractDelegating");
          String _visitorClassName_6 = this.getVisitorClassName();
          _builder.append(_visitorClassName_6, "	");
          _builder.append("(@NonNull D delegate, @NonNull C context) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super(delegate, context);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        } else {
          _builder.append("\t");
          _builder.append("protected final D delegate;");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected AbstractDelegating");
          String _visitorClassName_7 = this.getVisitorClassName();
          _builder.append(_visitorClassName_7, "	");
          _builder.append("(@NonNull D delegate, @NonNull C context) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super(context);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tassert delegate != null : \"cannot decorate a null visitor\"; //$NON-NLS-1$");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.delegate = delegate;\t\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tdelegate.setUndecoratedVisitor(this);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Delegates to my decorated visitor.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tpublic @NonNull Decorable");
          String _visitorClassName_8 = this.getVisitorClassName();
          _builder.append(_visitorClassName_8, "	");
          _builder.append("<R> createNestedVisitor() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("//\t\treturn delegate.createNestedVisitor();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\t}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Obtains the visitor that I decorate.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return my decorated visitor");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@SuppressWarnings(\"null\")");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected final @NonNull D getDelegate() {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return delegate;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        if ((isDerived).booleanValue()) {
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("public @Nullable R visiting(@NonNull ");
      String _visitablePackageName = this.getVisitablePackageName();
      _builder.append(_visitablePackageName, "	");
      _builder.append(".");
      String _visitableClassName = this.getVisitableClassName();
      _builder.append(_visitableClassName, "	");
      _builder.append(" visitable) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return delegate.visiting(visitable);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public @Nullable R visit");
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
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return delegate.visit");
          String _name_2 = eClass.getName();
          _builder.append(_name_2, "		");
          _builder.append("(object);");
          _builder.newLineIfNotEmpty();
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
  
  /**
   * AbstractDelegatingVisitor
   */
  protected void generateAbstractExtendingDelegatingVisitor(@NonNull final EPackage ePackage) {
    try {
      String _outputFolder = this.getOutputFolder();
      String _plus = (_outputFolder + "AbstractExtendingDelegating");
      String _visitorClassName = this.getVisitorClassName();
      String _plus_1 = (_plus + _visitorClassName);
      String _plus_2 = (_plus_1 + ".java");
      MergeWriter _mergeWriter = new MergeWriter(_plus_2);
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
      String _superVisitorPackageName = this.getSuperVisitorPackageName();
      _builder.append(_superVisitorPackageName, "");
      _builder.append(".AbstractDelegating");
      String _superVisitorClassName = this.getSuperVisitorClassName();
      _builder.append(_superVisitorClassName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      String _superVisitorPackageName_1 = this.getSuperVisitorPackageName();
      _builder.append(_superVisitorPackageName_1, "");
      _builder.append(".");
      String _superVisitorClassName_1 = this.getSuperVisitorClassName();
      _builder.append(_superVisitorClassName_1, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An AbstractExtendingDelegating");
      String _visitorClassName_1 = this.getVisitorClassName();
      _builder.append(_visitorClassName_1, " ");
      _builder.append(" delegates all visits.");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class AbstractExtendingDelegating");
      String _visitorClassName_2 = this.getVisitorClassName();
      _builder.append(_visitorClassName_2, "");
      _builder.append("<R, C, D extends ");
      String _superVisitorClassName_2 = this.getSuperVisitorClassName();
      _builder.append(_superVisitorClassName_2, "");
      _builder.append("<R>>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("extends AbstractDelegating");
      String _superVisitorClassName_3 = this.getSuperVisitorClassName();
      _builder.append(_superVisitorClassName_3, "	");
      _builder.append("<R, C, D>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("implements ");
      String _visitorClassName_3 = this.getVisitorClassName();
      _builder.append(_visitorClassName_3, "	");
      _builder.append("<R>");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      {
        if (true) {
          _builder.append("\t");
          _builder.append("protected AbstractExtendingDelegating");
          String _visitorClassName_4 = this.getVisitorClassName();
          _builder.append(_visitorClassName_4, "	");
          _builder.append("(@NonNull D delegate, @NonNull C context) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super(delegate, context);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        } else {
          _builder.append("\t");
          _builder.append("protected final D delegate;");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected AbstractExtendingDelegating");
          String _visitorClassName_5 = this.getVisitorClassName();
          _builder.append(_visitorClassName_5, "	");
          _builder.append("(@NonNull D delegate, @NonNull C context) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super(context);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tassert delegate != null : \"cannot decorate a null visitor\"; //$NON-NLS-1$\t\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.delegate = delegate;\t\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tdelegate.setUndecoratedVisitor(this);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Delegates to my decorated visitor.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tpublic Decorable");
          String _visitorClassName_6 = this.getVisitorClassName();
          _builder.append(_visitorClassName_6, "	");
          _builder.append("<R> createNestedVisitor() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("//\t\treturn delegate.createNestedVisitor();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\t}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Obtains the visitor that I decorate.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return my decorated visitor");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected final D getDelegate() {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return delegate;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public @Nullable R visiting(@NonNull ");
      String _visitablePackageName = this.getVisitablePackageName();
      _builder.append(_visitablePackageName, "	");
      _builder.append(".");
      String _visitableClassName = this.getVisitableClassName();
      _builder.append(_visitableClassName, "	");
      _builder.append(" visitable) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return delegate.visiting(visitable);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.append("\t");
          EClass firstSuperClass = GenerateVisitors.firstSuperClass(eClass, eClass);
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public @Nullable R visit");
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
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("return visiting(object);");
              _builder.newLine();
            } else {
              EPackage _ePackage = firstSuperClass.getEPackage();
              EPackage _ePackage_1 = eClass.getEPackage();
              boolean _equals_1 = Objects.equal(_ePackage, _ePackage_1);
              if (_equals_1) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return visit");
                String _name_2 = firstSuperClass.getName();
                _builder.append(_name_2, "		");
                _builder.append("(object);");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return delegate.visit");
                String _name_3 = firstSuperClass.getName();
                _builder.append(_name_3, "		");
                _builder.append("(object);");
                _builder.newLineIfNotEmpty();
              }
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
  
  /**
   * AbstractExtendingVisitor
   */
  protected void generateAbstractExtendingVisitor(@NonNull final EPackage ePackage) {
    try {
      String _superVisitorPackageName = this.getSuperVisitorPackageName();
      Boolean isDerived = Boolean.valueOf((!Objects.equal(_superVisitorPackageName, null)));
      String _outputFolder = this.getOutputFolder();
      String _plus = (_outputFolder + "AbstractExtending");
      String _visitorClassName = this.getVisitorClassName();
      String _plus_1 = (_plus + _visitorClassName);
      String _plus_2 = (_plus_1 + ".java");
      MergeWriter _mergeWriter = new MergeWriter(_plus_2);
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
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An AbstractExtending");
      String _visitorClassName_1 = this.getVisitorClassName();
      _builder.append(_visitorClassName_1, " ");
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
      _builder.append("public abstract class AbstractExtending");
      String _visitorClassName_2 = this.getVisitorClassName();
      _builder.append(_visitorClassName_2, "");
      _builder.append("<R, C>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("extends ");
      {
        if ((isDerived).booleanValue()) {
          String _superVisitorPackageName_1 = this.getSuperVisitorPackageName();
          _builder.append(_superVisitorPackageName_1, "	");
          _builder.append(".AbstractExtending");
          String _superVisitorClassName = this.getSuperVisitorClassName();
          _builder.append(_superVisitorClassName, "	");
        } else {
          _builder.append("Abstract");
          String _visitorClassName_3 = this.getVisitorClassName();
          _builder.append(_visitorClassName_3, "	");
        }
      }
      _builder.append("<R, C>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("implements ");
      String _visitorClassName_4 = this.getVisitorClassName();
      _builder.append(_visitorClassName_4, "	");
      _builder.append("<R>");
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
      _builder.append("protected AbstractExtending");
      String _visitorClassName_5 = this.getVisitorClassName();
      _builder.append(_visitorClassName_5, "	");
      _builder.append("(@NonNull C context) {");
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
          _builder.append("public @Nullable R visit");
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
  
  /**
   * AbstractNullVisitor
   */
  protected void generateAbstractNullVisitor(@NonNull final EPackage ePackage) {
    try {
      String _superVisitorPackageName = this.getSuperVisitorPackageName();
      Boolean isDerived = Boolean.valueOf((!Objects.equal(_superVisitorPackageName, null)));
      String _outputFolder = this.getOutputFolder();
      String _plus = (_outputFolder + "AbstractNull");
      String _visitorClassName = this.getVisitorClassName();
      String _plus_1 = (_plus + _visitorClassName);
      String _plus_2 = (_plus_1 + ".java");
      MergeWriter _mergeWriter = new MergeWriter(_plus_2);
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
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An AbstractNull");
      String _visitorClassName_1 = this.getVisitorClassName();
      _builder.append(_visitorClassName_1, " ");
      _builder.append(" provides a default implementation for each");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* visitXxx method that returns null.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class AbstractNull");
      String _visitorClassName_2 = this.getVisitorClassName();
      _builder.append(_visitorClassName_2, "");
      _builder.append("<R, C>");
      _builder.newLineIfNotEmpty();
      {
        boolean _not = (!(isDerived).booleanValue());
        if (_not) {
          _builder.append("\t");
          _builder.append("extends Abstract");
          String _visitorClassName_3 = this.getVisitorClassName();
          _builder.append(_visitorClassName_3, "	");
          _builder.append("<R, C>");
          _builder.newLineIfNotEmpty();
        } else {
          _builder.append("\t");
          _builder.append("extends ");
          String _superVisitorPackageName_1 = this.getSuperVisitorPackageName();
          _builder.append(_superVisitorPackageName_1, "	");
          _builder.append(".AbstractNull");
          String _superVisitorClassName = this.getSuperVisitorClassName();
          _builder.append(_superVisitorClassName, "	");
          _builder.append("<R, C> implements ");
          String _visitorClassName_4 = this.getVisitorClassName();
          _builder.append(_visitorClassName_4, "	");
          _builder.append("<R>");
          _builder.newLineIfNotEmpty();
        }
      }
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
      _builder.append("protected AbstractNull");
      String _visitorClassName_5 = this.getVisitorClassName();
      _builder.append(_visitorClassName_5, "	");
      _builder.append("(@NonNull C context) {");
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
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public @Nullable R visit");
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
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return null;");
          _builder.newLine();
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
  
  /**
   * AbstractVisitor
   */
  protected void generateAbstractVisitor(@NonNull final EPackage ePackage) {
    try {
      String _superVisitorPackageName = this.getSuperVisitorPackageName();
      Boolean isDerived = Boolean.valueOf((!Objects.equal(_superVisitorPackageName, null)));
      String _outputFolder = this.getOutputFolder();
      String _plus = (_outputFolder + "Abstract");
      String _visitorClassName = this.getVisitorClassName();
      String _plus_1 = (_plus + _visitorClassName);
      String _plus_2 = (_plus_1 + ".java");
      MergeWriter _mergeWriter = new MergeWriter(_plus_2);
      MergeWriter writer = _mergeWriter;
      StringConcatenation _builder = new StringConcatenation();
      String _visitorPackageName = this.getVisitorPackageName();
      String _generateHeader = this.generateHeader(ePackage, _visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      {
        boolean _not = (!(isDerived).booleanValue());
        if (_not) {
          _builder.append("import org.eclipse.jdt.annotation.Nullable;");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("/*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* An Abstract");
      String _visitorClassName_1 = this.getVisitorClassName();
      _builder.append(_visitorClassName_1, " ");
      _builder.append(" provides a default implementation of the visitor framework");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* but n implementations of the visitXXX methods..");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public abstract class Abstract");
      String _visitorClassName_2 = this.getVisitorClassName();
      _builder.append(_visitorClassName_2, "");
      _builder.append("<R, C>");
      _builder.newLineIfNotEmpty();
      {
        if ((isDerived).booleanValue()) {
          _builder.append("\t");
          _builder.append("extends ");
          String _superVisitorPackageName_1 = this.getSuperVisitorPackageName();
          _builder.append(_superVisitorPackageName_1, "	");
          _builder.append(".Abstract");
          String _superVisitorClassName = this.getSuperVisitorClassName();
          _builder.append(_superVisitorClassName, "	");
          _builder.append("<R, C>");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("implements ");
      String _visitorClassName_3 = this.getVisitorClassName();
      _builder.append(_visitorClassName_3, "	");
      _builder.append("<R>");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      {
        boolean _not_1 = (!(isDerived).booleanValue());
        if (_not_1) {
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Context for the AST visitation.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected final @NonNull C context;");
          _builder.newLine();
          _builder.newLine();
        }
      }
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
      _builder.append("protected Abstract");
      String _visitorClassName_4 = this.getVisitorClassName();
      _builder.append(_visitorClassName_4, "	");
      _builder.append("(@NonNull C context) {");
      _builder.newLineIfNotEmpty();
      {
        boolean _not_2 = (!(isDerived).booleanValue());
        if (_not_2) {
          _builder.append("\t\t");
          _builder.append("this.context = context;");
          _builder.newLine();
        } else {
          _builder.append("\t\t");
          _builder.append("super(context);");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      {
        boolean _not_3 = (!(isDerived).booleanValue());
        if (_not_3) {
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@SuppressWarnings(\"unchecked\")");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public <A> A getAdapter(@NonNull Class<A> adapter) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("if (adapter.isAssignableFrom(getClass())) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("return (A) this;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("else {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("return null;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* A null-safe visitation of the specified visitable.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @param v a visitable, or <code>null</code>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return <code>null</code> if the visitable is <code>null</code>;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*\t otherwise, the result of visiting it");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public @Nullable R safeVisit(@Nullable ");
          String _visitablePackageName = this.getVisitablePackageName();
          _builder.append(_visitablePackageName, "	");
          _builder.append(".");
          String _visitableClassName = this.getVisitableClassName();
          _builder.append(_visitableClassName, "	");
          _builder.append(" v) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return (v == null) ? null : v.accept(this);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Perform a visit to the specified visitable.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @param v a visitable, or <code>null</code>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return <code>null</code> if the visitable is <code>null</code>;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*\t otherwise, the result of visiting it");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public @Nullable R visit(@NonNull ");
          String _visitablePackageName_1 = this.getVisitablePackageName();
          _builder.append(_visitablePackageName_1, "	");
          _builder.append(".");
          String _visitableClassName_1 = this.getVisitableClassName();
          _builder.append(_visitableClassName_1, "	");
          _builder.append(" v) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return v.accept(this);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\tpublic @Nullable R visiting(@NonNull ");
          String _visitablePackageName_2 = this.getVisitablePackageName();
          _builder.append(_visitablePackageName_2, "	");
          _builder.append(".");
          String _visitableClassName_2 = this.getVisitableClassName();
          _builder.append(_visitableClassName_2, "	");
          _builder.append(" visitable) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("//\t\treturn null;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//\t}");
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
  
  /**
   * DecorableVisitorInterface
   */
  protected void generateDecorableVisitorInterface(@NonNull final EPackage ePackage, final String visitorRootClass) {
    try {
      String _superVisitorPackageName = this.getSuperVisitorPackageName();
      Boolean isDerived = Boolean.valueOf((!Objects.equal(_superVisitorPackageName, null)));
      String _outputFolder = this.getOutputFolder();
      String _plus = (_outputFolder + "Decorable");
      String _visitorClassName = this.getVisitorClassName();
      String _plus_1 = (_plus + _visitorClassName);
      String _plus_2 = (_plus_1 + ".java");
      MergeWriter _mergeWriter = new MergeWriter(_plus_2);
      MergeWriter writer = _mergeWriter;
      StringConcatenation _builder = new StringConcatenation();
      String _visitorPackageName = this.getVisitorPackageName();
      String _generateHeader = this.generateHeader(ePackage, _visitorPackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public interface Decorable");
      String _visitorClassName_1 = this.getVisitorClassName();
      _builder.append(_visitorClassName_1, "");
      _builder.append("<R> extends ");
      String _visitorClassName_2 = this.getVisitorClassName();
      _builder.append(_visitorClassName_2, "");
      _builder.append("<R>");
      {
        if ((isDerived).booleanValue()) {
          _builder.append(", ");
          String _superVisitorPackageName_1 = this.getSuperVisitorPackageName();
          _builder.append(_superVisitorPackageName_1, "");
          _builder.append(".Decorable");
          String _superVisitorClassName = this.getSuperVisitorClassName();
          _builder.append(_superVisitorClassName, "");
          _builder.append("<R>");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("void setUndecoratedVisitor(@NonNull ");
      _builder.append(visitorRootClass, "	");
      _builder.append("<R> visitor);");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String generateHeader(@NonNull final EPackage ePackage, final String javaPackage) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    String _copyright = this.getCopyright();
    String _copyright_1 = MergeWriter.getCopyright(_copyright);
    String _replace = _copyright_1.replace("\n", "\n* ");
    _builder.append(_replace, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This code is auto-generated");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* from: ");
    String _sourceFile = this.getSourceFile();
    _builder.append(_sourceFile, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* invoked by: org.eclipse.ocl.examples.build.utilities.*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* from: org.eclipse.ocl.examples.build.*.mwe2");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Do not edit it.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* $Id$");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("package\t");
    _builder.append(javaPackage, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected void generateVisitableInterface(@NonNull final EPackage ePackage) {
    try {
      String _outputFolder = this.getOutputFolder();
      String _visitableClassName = this.getVisitableClassName();
      String _plus = (_outputFolder + _visitableClassName);
      String _plus_1 = (_plus + ".java");
      MergeWriter _mergeWriter = new MergeWriter(_plus_1);
      MergeWriter writer = _mergeWriter;
      StringConcatenation _builder = new StringConcatenation();
      String _visitablePackageName = this.getVisitablePackageName();
      String _generateHeader = this.generateHeader(ePackage, _visitablePackageName);
      _builder.append(_generateHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.EClass;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.NonNull;");
      _builder.newLine();
      _builder.append("import org.eclipse.jdt.annotation.Nullable;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public interface ");
      String _visitableClassName_1 = this.getVisitableClassName();
      _builder.append(_visitableClassName_1, "");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Returns the result of accepting a visit from a visitor.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Implementations typically invoke a derived-class-specific");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* variant of visitXXX() to facilitate derived-class-specific");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* processing or just visit() when no such method is available.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* <p>");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Implementations of visit() may use the EcoreSwitch to perform");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* derived-class-specific processing.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* <p>");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Derived implementations of accept() may use getAdapter() to obtain");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* richer visitor interfaces.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param <R, C>");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param visitor");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @return the result of the visit.");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Nullable <R> R accept(@NonNull ");
      String _visitorPackageName = this.getVisitorPackageName();
      _builder.append(_visitorPackageName, "	");
      _builder.append(".");
      String _visitorClassName = this.getVisitorClassName();
      _builder.append(_visitorClassName, "	");
      _builder.append("<R> visitor);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("EClass eClass();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      writer.append(_builder.toString());
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void generateVisitorInterface(@NonNull final EPackage ePackage) {
    try {
      String _superVisitorPackageName = this.getSuperVisitorPackageName();
      Boolean isDerived = Boolean.valueOf((!Objects.equal(_superVisitorPackageName, null)));
      String _outputFolder = this.getOutputFolder();
      String _visitorClassName = this.getVisitorClassName();
      String _plus = (_outputFolder + _visitorClassName);
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
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("public interface ");
      String _visitorClassName_1 = this.getVisitorClassName();
      _builder.append(_visitorClassName_1, "");
      _builder.append("<R>");
      {
        if ((isDerived).booleanValue()) {
          _builder.append(" extends ");
          String _superVisitorPackageName_1 = this.getSuperVisitorPackageName();
          _builder.append(_superVisitorPackageName_1, "");
          _builder.append(".");
          String _superVisitorClassName = this.getSuperVisitorClassName();
          _builder.append(_superVisitorClassName, "");
          _builder.append("<R>");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      {
        boolean _not = (!(isDerived).booleanValue());
        if (_not) {
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Returns an object which is an instance of the given class");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* associated with this object. Returns <code>null</code> if");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* no such object can be found.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @param adapter the adapter class to look up");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* @return an object of the given class, ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*    or <code>null</code> if this object does not");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*    have an adapter for the given class");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Nullable <A> A getAdapter(@NonNull Class<A> adapter);");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* Return the result of visiting a visitable for which no more specific pivot type method");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("* is available.");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Nullable R visiting(@NonNull ");
          String _visitablePackageName = this.getVisitablePackageName();
          _builder.append(_visitablePackageName, "	");
          _builder.append(".");
          String _visitableClassName = this.getVisitableClassName();
          _builder.append(_visitableClassName, "	");
          _builder.append(" visitable);");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
        }
      }
      {
        List<EClass> _sortedEClasses = GenerateVisitors.getSortedEClasses(ePackage);
        for(final EClass eClass : _sortedEClasses) {
          _builder.append("\t");
          _builder.append("@Nullable R visit");
          String _name = eClass.getName();
          _builder.append(_name, "	");
          _builder.append("(@NonNull ");
          String _modelPackageName = this.getModelPackageName();
          _builder.append(_modelPackageName, "	");
          _builder.append(".");
          String _name_1 = eClass.getName();
          _builder.append(_name_1, "	");
          _builder.append(" object);");
          _builder.newLineIfNotEmpty();
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
