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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.build.xtend.GenerateMetamodelWorkflowComponent;
import org.eclipse.ocl.examples.build.xtend.NameQueries;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.Pivot2Moniker;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Strings;

@SuppressWarnings("all")
public abstract class GenerateOCLCommon extends GenerateMetamodelWorkflowComponent {
  protected String declareCollectionTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<CollectionType> _sortedCollectionTypes = this.getSortedCollectionTypes(_rootPackage);
      for(final CollectionType type : _sortedCollectionTypes) {
        _builder.append("protected final @NonNull ");
        EClass _eClass = type.eClass();
        String _name = _eClass.getName();
        _builder.append(_name, "");
        _builder.append(" ");
        String _partialName = this.partialName(type);
        String _plus = ("_" + _partialName);
        String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
        _builder.append(_prefixedSymbolName, "");
        _builder.append(" = create");
        EClass _eClass_1 = type.eClass();
        String _name_1 = _eClass_1.getName();
        _builder.append(_name_1, "");
        _builder.append("(\"");
        String _name_2 = type.getName();
        _builder.append(_name_2, "");
        _builder.append("\"/*");
        Type _elementType = type.getElementType();
        String _name_3 = _elementType.getName();
        _builder.append(_name_3, "");
        _builder.append("*/, \"");
        Number _lower = type.getLower();
        String _string = _lower.toString();
        _builder.append(_string, "");
        _builder.append("\", \"");
        Number _upper = type.getUpper();
        String _string_1 = _upper.toString();
        _builder.append(_string_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String declareEnumerations(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Enumeration> _sortedEnumerations = this.getSortedEnumerations(_rootPackage);
      for(final Enumeration enumeration : _sortedEnumerations) {
        String _partialName = this.partialName(enumeration);
        String _plus = ("_" + _partialName);
        String enumerationName = this.getPrefixedSymbolName(enumeration, _plus);
        _builder.newLineIfNotEmpty();
        _builder.append("protected final @NonNull Enumeration ");
        _builder.append(enumerationName, "");
        _builder.append(" = createEnumeration(\"");
        String _name = enumeration.getName();
        _builder.append(_name, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        {
          List<EnumerationLiteral> _ownedLiteral = enumeration.getOwnedLiteral();
          for(final EnumerationLiteral enumerationLiteral : _ownedLiteral) {
            _builder.append("protected final @NonNull EnumerationLiteral ");
            String _plus_1 = ("el_" + enumerationName);
            String _plus_2 = (_plus_1 + "_");
            String _name_1 = enumerationLiteral.getName();
            String _plus_3 = (_plus_2 + _name_1);
            String _prefixedSymbolName = this.getPrefixedSymbolName(enumerationLiteral, _plus_3);
            _builder.append(_prefixedSymbolName, "");
            _builder.append(" = createEnumerationLiteral(\"");
            String _name_2 = enumerationLiteral.getName();
            _builder.append(_name_2, "");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder.toString();
  }
  
  protected String declareMetaclasses(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Metaclass> _sortedMetaclasses = this.getSortedMetaclasses(_rootPackage);
      for(final Metaclass type : _sortedMetaclasses) {
        _builder.append("protected final @NonNull Metaclass ");
        String _partialName = this.partialName(type);
        String _plus = ("_" + _partialName);
        String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
        _builder.append(_prefixedSymbolName, "");
        _builder.append(" = createMetaclass(\"");
        String _name = type.getName();
        _builder.append(_name, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String declareOclTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Type> _sortedOclTypes = this.getSortedOclTypes(pkg);
      for(final Type type : _sortedOclTypes) {
        _builder.append("protected final @NonNull ");
        EClass _eClass = type.eClass();
        String _name = _eClass.getName();
        _builder.append(_name, "");
        _builder.append(" ");
        String _partialName = this.partialName(type);
        String _plus = ("_" + _partialName);
        String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
        _builder.append(_prefixedSymbolName, "");
        _builder.append(" = create");
        EClass _eClass_1 = type.eClass();
        String _name_1 = _eClass_1.getName();
        _builder.append(_name_1, "");
        _builder.append("(\"");
        String _name_2 = type.getName();
        _builder.append(_name_2, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String declareParameterTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Type> _sortedParameterTypes = this.getSortedParameterTypes(_rootPackage);
      for(final Type type : _sortedParameterTypes) {
        _builder.append("protected final @NonNull Class ");
        String _partialName = this.partialName(type);
        String _plus = ("_" + _partialName);
        String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
        _builder.append(_prefixedSymbolName, "");
        _builder.append(" = createClass(\"");
        String _name = type.getName();
        _builder.append(_name, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String declarePrimitiveTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<PrimitiveType> _sortedPrimitiveTypes = this.getSortedPrimitiveTypes(_rootPackage);
      for(final PrimitiveType type : _sortedPrimitiveTypes) {
        _builder.append("protected final @NonNull PrimitiveType ");
        String _partialName = this.partialName(type);
        String _plus = ("_" + _partialName);
        String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
        _builder.append(_prefixedSymbolName, "");
        _builder.append(" = createPrimitiveType(\"");
        String _name = type.getName();
        _builder.append(_name, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String declareProperties(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Property> allProperties = this.getAllProperties(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final Property property : allProperties) {
          _builder.append("protected final @NonNull Property ");
          String _partialName = this.partialName(property);
          String _plus = ("pr_" + _partialName);
          String _prefixedSymbolName = this.getPrefixedSymbolName(property, _plus);
          _builder.append(_prefixedSymbolName, "");
          _builder.append(" = createProperty(\"");
          String _name = property.getName();
          _builder.append(_name, "");
          _builder.append("\", ");
          Type _type = property.getType();
          String _symbolName = this.getSymbolName(_type);
          _builder.append(_symbolName, "");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String declareTupleTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<TupleType> _sortedTupleTypes = this.getSortedTupleTypes(_rootPackage);
      for(final TupleType type : _sortedTupleTypes) {
        _builder.append("protected final @NonNull TupleType ");
        String _partialName = this.partialName(type);
        String _plus = ("_" + _partialName);
        String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
        _builder.append(_prefixedSymbolName, "");
        _builder.append(" = createTupleType(\"");
        String _name = type.getName();
        _builder.append(_name, "");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        {
          List<Property> _sortedTupleParts = this.getSortedTupleParts(type);
          boolean _hasElements = false;
          for(final Property property : _sortedTupleParts) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append("\t", "");
            } else {
              _builder.appendImmediate(",\n\t", "");
            }
            _builder.append("createProperty(\"");
            String _name_1 = property.getName();
            _builder.append(_name_1, "");
            _builder.append("\", ");
            Type _type = property.getType();
            String _symbolName = this.getSymbolName(_type);
            _builder.append(_symbolName, "");
            _builder.append(")");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String defineCollectionTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      org.eclipse.ocl.examples.pivot.Package orphanPackage = this.getOrphanPackage(pkg);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installCollectionTypes() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final List<Type> ownedTypes = ");
      String _symbolName = this.getSymbolName(pkg);
      _builder.append(_symbolName, "	");
      _builder.append(".getOwnedType();");
      _builder.newLineIfNotEmpty();
      {
        boolean _notEquals = (!Objects.equal(orphanPackage, null));
        if (_notEquals) {
          _builder.append("\t");
          _builder.append("final List<Type> orphanTypes = ");
          String _symbolName_1 = this.getSymbolName(orphanPackage);
          _builder.append(_symbolName_1, "	");
          _builder.append(".getOwnedType();");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("CollectionType type;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Type> superClasses;");
      _builder.newLine();
      {
        Root _rootPackage = this.getRootPackage(pkg);
        List<CollectionType> _sortedCollectionTypes = this.getSortedCollectionTypes(_rootPackage);
        for(final CollectionType type : _sortedCollectionTypes) {
          {
            TemplateableElement _unspecializedElement = type.getUnspecializedElement();
            boolean _equals = Objects.equal(_unspecializedElement, null);
            if (_equals) {
              _builder.append("\t");
              _builder.append("ownedTypes.add(type = ");
              String _symbolName_2 = this.getSymbolName(type);
              _builder.append(_symbolName_2, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              _builder.append("orphanTypes.add(type = ");
              String _symbolName_3 = this.getSymbolName(type);
              _builder.append(_symbolName_3, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("type.setUnspecializedElement(");
              TemplateableElement _unspecializedElement_1 = type.getUnspecializedElement();
              String _symbolName_4 = this.getSymbolName(_unspecializedElement_1);
              _builder.append(_symbolName_4, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("type.setElementType(");
          Type _elementType = type.getElementType();
          String _symbolName_5 = this.getSymbolName(_elementType);
          _builder.append(_symbolName_5, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          String _emitSuperClasses = this.emitSuperClasses(type);
          _builder.append(_emitSuperClasses, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String defineComments(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void installComments() {");
    _builder.newLine();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Element> _sortedCommentedElements = this.getSortedCommentedElements(_rootPackage);
      for(final Element pElement : _sortedCommentedElements) {
        {
          List<Comment> _sortedComments = this.getSortedComments(pElement);
          for(final Comment pComment : _sortedComments) {
            _builder.append("\t");
            _builder.append("installComment(");
            String _symbolName = this.getSymbolName(pElement);
            _builder.append(_symbolName, "	");
            _builder.append(", \"");
            String _javaString = this.javaString(pComment);
            _builder.append(_javaString, "	");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String defineEnumerations(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void installEnumerations() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final List<Type> ownedTypes = ");
    String _symbolName = this.getSymbolName(pkg);
    _builder.append(_symbolName, "	");
    _builder.append(".getOwnedType();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("Enumeration type;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("List<EnumerationLiteral> enumerationLiterals;");
    _builder.newLine();
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Enumeration> _sortedEnumerations = this.getSortedEnumerations(_rootPackage);
      for(final Enumeration enumeration : _sortedEnumerations) {
        _builder.append("\t");
        _builder.append("ownedTypes.add(type = ");
        String _symbolName_1 = this.getSymbolName(enumeration);
        _builder.append(_symbolName_1, "	");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("enumerationLiterals = type.getOwnedLiteral();");
        _builder.newLine();
        {
          List<EnumerationLiteral> _ownedLiteral = enumeration.getOwnedLiteral();
          for(final EnumerationLiteral enumerationLiteral : _ownedLiteral) {
            _builder.append("\t");
            _builder.append("enumerationLiterals.add(");
            String _symbolName_2 = this.getSymbolName(enumerationLiteral);
            _builder.append(_symbolName_2, "	");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("type.getSuperClass().add(_Enumeration);");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String defineIterations(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Iteration> allIterations = this.getSortedIterations(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      {
        int _size = allIterations.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          {
            for(final Iteration iteration : allIterations) {
              _builder.append("protected final @NonNull Iteration ");
              String _partialName = this.partialName(iteration);
              String _plus = ("it_" + _partialName);
              String _prefixedSymbolName = this.getPrefixedSymbolName(iteration, _plus);
              _builder.append(_prefixedSymbolName, "");
              _builder.append(" = createIteration(\"");
              String _name = iteration.getName();
              _builder.append(_name, "");
              _builder.append("\", ");
              Type _type = iteration.getType();
              String _symbolName = this.getSymbolName(_type);
              _builder.append(_symbolName, "");
              _builder.append(", ");
              {
                String _implementationClass = iteration.getImplementationClass();
                boolean _notEquals = (!Objects.equal(_implementationClass, null));
                if (_notEquals) {
                  _builder.append("\"");
                  String _implementationClass_1 = iteration.getImplementationClass();
                  _builder.append(_implementationClass_1, "");
                  _builder.append("\", ");
                  String _implementationClass_2 = iteration.getImplementationClass();
                  _builder.append(_implementationClass_2, "");
                  _builder.append(".INSTANCE");
                } else {
                  _builder.append("null, null");
                }
              }
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.newLine();
        }
      }
      _builder.append("protected void installIterations() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Operation> ownedIterations;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Parameter> ownedParameters;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Iteration iteration;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Parameter parameter;");
      _builder.newLine();
      {
        List<Type> _sortedOwningTypes = this.getSortedOwningTypes(allIterations);
        for(final Type type : _sortedOwningTypes) {
          _builder.append("\t");
          _builder.append("ownedIterations = ");
          String _symbolName_1 = this.getSymbolName(type);
          _builder.append(_symbolName_1, "	");
          _builder.append(".getOwnedOperation();");
          _builder.newLineIfNotEmpty();
          {
            List<Iteration> _sortedIterations = this.getSortedIterations(type, allIterations);
            for(final Iteration iteration_1 : _sortedIterations) {
              _builder.append("\t");
              _builder.append("ownedIterations.add(iteration = ");
              String _symbolName_2 = this.getSymbolName(iteration_1);
              _builder.append(_symbolName_2, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              {
                boolean _isInvalidating = iteration_1.isInvalidating();
                if (_isInvalidating) {
                  _builder.append("\t");
                  _builder.append("iteration.setIsInvalidating(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isRequired = iteration_1.isRequired();
                boolean _not = (!_isRequired);
                if (_not) {
                  _builder.append("\t");
                  _builder.append("iteration.setIsRequired(false);");
                  _builder.newLine();
                }
              }
              {
                boolean _isStatic = iteration_1.isStatic();
                if (_isStatic) {
                  _builder.append("\t");
                  _builder.append("iteration.setIsStatic(true);");
                  _builder.newLine();
                }
              }
              {
                List<Parameter> _ownedIterator = iteration_1.getOwnedIterator();
                int _size_1 = _ownedIterator.size();
                boolean _greaterThan_1 = (_size_1 > 0);
                if (_greaterThan_1) {
                  _builder.append("\t");
                  _builder.append("ownedParameters = iteration.getOwnedIterator();");
                  _builder.newLine();
                  {
                    List<Parameter> _ownedIterator_1 = iteration_1.getOwnedIterator();
                    for(final Parameter parameter : _ownedIterator_1) {
                      _builder.append("\t");
                      _builder.append("ownedParameters.add(parameter = createParameter(\"");
                      String _name_1 = parameter.getName();
                      _builder.append(_name_1, "	");
                      _builder.append("\", ");
                      Type _type_1 = parameter.getType();
                      String _symbolName_3 = this.getSymbolName(_type_1);
                      _builder.append(_symbolName_3, "	");
                      _builder.append(", ");
                      boolean _isRequired_1 = parameter.isRequired();
                      _builder.append(_isRequired_1, "	");
                      _builder.append("));");
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _isRequired_2 = parameter.isRequired();
                        boolean _not_1 = (!_isRequired_2);
                        if (_not_1) {
                          _builder.append("\t");
                          _builder.append("parameter.setIsRequired(false);");
                          _builder.newLine();
                        }
                      }
                    }
                  }
                }
              }
              {
                List<Parameter> _ownedAccumulator = iteration_1.getOwnedAccumulator();
                int _size_2 = _ownedAccumulator.size();
                boolean _greaterThan_2 = (_size_2 > 0);
                if (_greaterThan_2) {
                  _builder.append("\t");
                  _builder.append("ownedParameters = iteration.getOwnedAccumulator();");
                  _builder.newLine();
                  {
                    List<Parameter> _ownedAccumulator_1 = iteration_1.getOwnedAccumulator();
                    for(final Parameter parameter_1 : _ownedAccumulator_1) {
                      _builder.append("\t");
                      _builder.append("ownedParameters.add(parameter = createParameter(\"");
                      String _name_2 = parameter_1.getName();
                      _builder.append(_name_2, "	");
                      _builder.append("\", ");
                      Type _type_2 = parameter_1.getType();
                      String _symbolName_4 = this.getSymbolName(_type_2);
                      _builder.append(_symbolName_4, "	");
                      _builder.append(", ");
                      boolean _isRequired_3 = parameter_1.isRequired();
                      _builder.append(_isRequired_3, "	");
                      _builder.append("));");
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _isRequired_4 = parameter_1.isRequired();
                        boolean _not_2 = (!_isRequired_4);
                        if (_not_2) {
                          _builder.append("\t");
                          _builder.append("parameter.setIsRequired(false);");
                          _builder.newLine();
                        }
                      }
                    }
                  }
                }
              }
              {
                List<Parameter> _ownedParameter = iteration_1.getOwnedParameter();
                int _size_3 = _ownedParameter.size();
                boolean _greaterThan_3 = (_size_3 > 0);
                if (_greaterThan_3) {
                  _builder.append("\t");
                  _builder.append("ownedParameters = iteration.getOwnedParameter();");
                  _builder.newLine();
                  {
                    List<Parameter> _ownedParameter_1 = iteration_1.getOwnedParameter();
                    for(final Parameter parameter_2 : _ownedParameter_1) {
                      _builder.append("\t");
                      _builder.append("ownedParameters.add(parameter = createParameter(\"");
                      String _name_3 = parameter_2.getName();
                      _builder.append(_name_3, "	");
                      _builder.append("\", ");
                      Type _type_3 = parameter_2.getType();
                      String _symbolName_5 = this.getSymbolName(_type_3);
                      _builder.append(_symbolName_5, "	");
                      _builder.append(", ");
                      boolean _isRequired_5 = parameter_2.isRequired();
                      _builder.append(_isRequired_5, "	");
                      _builder.append("));");
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _isRequired_6 = parameter_2.isRequired();
                        boolean _not_3 = (!_isRequired_6);
                        if (_not_3) {
                          _builder.append("\t");
                          _builder.append("parameter.setIsRequired(false);");
                          _builder.newLine();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String defineLambdaTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<LambdaType> allLambdaTypes = this.getSortedLambdaTypes(_rootPackage);
      org.eclipse.ocl.examples.pivot.Package orphanPackage = this.getOrphanPackage(pkg);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final LambdaType type : allLambdaTypes) {
          _builder.append("protected final @NonNull LambdaType ");
          String _partialName = this.partialName(type);
          String _plus = ("_" + _partialName);
          String _prefixedSymbolName = this.getPrefixedSymbolName(type, _plus);
          _builder.append(_prefixedSymbolName, "");
          _builder.append(" = createLambdaType(\"");
          String _name = type.getName();
          _builder.append(_name, "");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("protected void installLambdaTypes() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final List<Type> orphanTypes = ");
      String _symbolName = this.getSymbolName(orphanPackage);
      _builder.append(_symbolName, "	");
      _builder.append(".getOwnedType();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("LambdaType type;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Type> superClasses;");
      _builder.newLine();
      {
        for(final LambdaType type_1 : allLambdaTypes) {
          _builder.append("\t");
          _builder.append("orphanTypes.add(type = ");
          String _symbolName_1 = this.getSymbolName(type_1);
          _builder.append(_symbolName_1, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("type.setContextType(");
          Type _contextType = type_1.getContextType();
          String _symbolName_2 = this.getSymbolName(_contextType);
          _builder.append(_symbolName_2, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          {
            List<Type> _parameterType = type_1.getParameterType();
            for(final Type parameterType : _parameterType) {
              _builder.append("\t");
              _builder.append("type.getParameterType().add(");
              String _symbolName_3 = this.getSymbolName(parameterType);
              _builder.append(_symbolName_3, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("type.setResultType(");
          Type _resultType = type_1.getResultType();
          String _symbolName_4 = this.getSymbolName(_resultType);
          _builder.append(_symbolName_4, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          String _emitSuperClasses = this.emitSuperClasses(type_1);
          _builder.append(_emitSuperClasses, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String defineMetaclasses(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Metaclass> allMetaclasses = this.getSortedMetaclasses(_rootPackage);
      org.eclipse.ocl.examples.pivot.Package orphanPackage = this.getOrphanPackage(pkg);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installMetaclasses() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final List<Type> ownedTypes = ");
      String _symbolName = this.getSymbolName(pkg);
      _builder.append(_symbolName, "	");
      _builder.append(".getOwnedType();");
      _builder.newLineIfNotEmpty();
      {
        boolean _notEquals = (!Objects.equal(orphanPackage, null));
        if (_notEquals) {
          _builder.append("\t");
          _builder.append("final List<Type> orphanTypes = ");
          String _symbolName_1 = this.getSymbolName(orphanPackage);
          _builder.append(_symbolName_1, "	");
          _builder.append(".getOwnedType();");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("Metaclass type;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Type> superClasses;");
      _builder.newLine();
      {
        for(final Metaclass type : allMetaclasses) {
          {
            TemplateableElement _unspecializedElement = type.getUnspecializedElement();
            boolean _equals = Objects.equal(_unspecializedElement, null);
            if (_equals) {
              _builder.append("\t");
              _builder.append("ownedTypes.add(type = ");
              String _symbolName_2 = this.getSymbolName(type);
              _builder.append(_symbolName_2, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              _builder.append("orphanTypes.add(type = ");
              String _symbolName_3 = this.getSymbolName(type);
              _builder.append(_symbolName_3, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("type.setUnspecializedElement(");
              TemplateableElement _unspecializedElement_1 = type.getUnspecializedElement();
              String _symbolName_4 = this.getSymbolName(_unspecializedElement_1);
              _builder.append(_symbolName_4, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("type.setInstanceType(");
          Type _instanceType = type.getInstanceType();
          String _symbolName_5 = this.getSymbolName(_instanceType);
          _builder.append(_symbolName_5, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          String _emitSuperClasses = this.emitSuperClasses(type);
          _builder.append(_emitSuperClasses, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String defineOclTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      List<Type> allOclTypes = this.getSortedOclTypes(pkg);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installOclTypes() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final List<Type> ownedTypes = ");
      String _symbolName = this.getSymbolName(pkg);
      _builder.append(_symbolName, "	");
      _builder.append(".getOwnedType();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("Type type;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Type> superClasses;");
      _builder.newLine();
      {
        for(final Type type : allOclTypes) {
          _builder.append("\t");
          _builder.append("ownedTypes.add(type = ");
          String _symbolName_1 = this.getSymbolName(type);
          _builder.append(_symbolName_1, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          {
            boolean _not = (!(type instanceof AnyType));
            if (_not) {
              _builder.append("\t");
              String _emitSuperClasses = this.emitSuperClasses(type);
              _builder.append(_emitSuperClasses, "	");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String defineOperations(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Operation> allOperations = this.getSortedOperations(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final Operation operation : allOperations) {
          _builder.append("protected final @NonNull Operation ");
          String _partialName = this.partialName(operation);
          String _plus = ("op_" + _partialName);
          String _prefixedSymbolName = this.getPrefixedSymbolName(operation, _plus);
          _builder.append(_prefixedSymbolName, "");
          _builder.append(" = createOperation(\"");
          String _name = operation.getName();
          _builder.append(_name, "");
          _builder.append("\", ");
          Type _type = operation.getType();
          String _symbolName = this.getSymbolName(_type);
          _builder.append(_symbolName, "");
          _builder.append(", ");
          {
            String _implementationClass = operation.getImplementationClass();
            boolean _notEquals = (!Objects.equal(_implementationClass, null));
            if (_notEquals) {
              _builder.append("\"");
              String _implementationClass_1 = operation.getImplementationClass();
              _builder.append(_implementationClass_1, "");
              _builder.append("\", ");
              String _implementationClass_2 = operation.getImplementationClass();
              _builder.append(_implementationClass_2, "");
              _builder.append(".INSTANCE");
            } else {
              _builder.append("null, null");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("protected void installOperations() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Operation> ownedOperations;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Parameter> ownedParameters;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Operation operation;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Parameter parameter;");
      _builder.newLine();
      {
        List<Type> _sortedOwningTypes = this.getSortedOwningTypes(allOperations);
        for(final Type type : _sortedOwningTypes) {
          _builder.append("\t");
          _builder.append("ownedOperations = ");
          String _symbolName_1 = this.getSymbolName(type);
          _builder.append(_symbolName_1, "	");
          _builder.append(".getOwnedOperation();");
          _builder.newLineIfNotEmpty();
          {
            List<Operation> _sortedOperations = this.getSortedOperations(type, allOperations);
            for(final Operation operation_1 : _sortedOperations) {
              _builder.append("\t");
              _builder.append("ownedOperations.add(operation = ");
              String _symbolName_2 = this.getSymbolName(operation_1);
              _builder.append(_symbolName_2, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              {
                boolean _isInvalidating = operation_1.isInvalidating();
                if (_isInvalidating) {
                  _builder.append("\t");
                  _builder.append("operation.setIsInvalidating(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isRequired = operation_1.isRequired();
                boolean _not = (!_isRequired);
                if (_not) {
                  _builder.append("\t");
                  _builder.append("operation.setIsRequired(false);");
                  _builder.newLine();
                }
              }
              {
                boolean _isStatic = operation_1.isStatic();
                if (_isStatic) {
                  _builder.append("\t");
                  _builder.append("operation.setIsStatic(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isValidating = operation_1.isValidating();
                if (_isValidating) {
                  _builder.append("\t");
                  _builder.append("operation.setIsValidating(true);");
                  _builder.newLine();
                }
              }
              {
                OpaqueExpression _bodyExpression = operation_1.getBodyExpression();
                boolean _notEquals_1 = (!Objects.equal(_bodyExpression, null));
                if (_notEquals_1) {
                  _builder.append("\t");
                  _builder.append("operation.setBodyExpression(createOpaqueExpression(");
                  Type _type_1 = operation_1.getType();
                  String _symbolName_3 = this.getSymbolName(_type_1);
                  _builder.append(_symbolName_3, "	");
                  _builder.append(", \"");
                  OpaqueExpression _bodyExpression_1 = operation_1.getBodyExpression();
                  String _javaString = this.javaString(_bodyExpression_1);
                  _builder.append(_javaString, "	");
                  _builder.append("\"));");
                  _builder.newLineIfNotEmpty();
                }
              }
              {
                List<Parameter> _ownedParameter = operation_1.getOwnedParameter();
                int _size = _ownedParameter.size();
                boolean _greaterThan = (_size > 0);
                if (_greaterThan) {
                  _builder.append("\t");
                  _builder.append("ownedParameters = operation.getOwnedParameter();");
                  _builder.newLine();
                  {
                    List<Parameter> _ownedParameter_1 = operation_1.getOwnedParameter();
                    for(final Parameter parameter : _ownedParameter_1) {
                      _builder.append("\t");
                      _builder.append("ownedParameters.add(parameter = createParameter(\"");
                      String _name_1 = parameter.getName();
                      _builder.append(_name_1, "	");
                      _builder.append("\", ");
                      Type _type_2 = parameter.getType();
                      String _symbolName_4 = this.getSymbolName(_type_2);
                      _builder.append(_symbolName_4, "	");
                      _builder.append(", ");
                      boolean _isRequired_1 = parameter.isRequired();
                      _builder.append(_isRequired_1, "	");
                      _builder.append("));");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String definePackages(final org.eclipse.ocl.examples.pivot.Package pkg0) {
    String _xblockexpression = null;
    {
      Root rootPackage = this.getRootPackage(pkg0);
      List<org.eclipse.ocl.examples.pivot.Package> allPackages = this.getSortedPackages(rootPackage);
      HashSet<org.eclipse.ocl.examples.pivot.Package> _hashSet = new HashSet<org.eclipse.ocl.examples.pivot.Package>(allPackages);
      HashSet<org.eclipse.ocl.examples.pivot.Package> morePackages = _hashSet;
      morePackages.remove(pkg0);
      StringConcatenation _builder = new StringConcatenation();
      {
        int _size = morePackages.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          {
            for(final org.eclipse.ocl.examples.pivot.Package pkg1 : morePackages) {
              _builder.append("protected final @NonNull ");
              EClass _eClass = pkg1.eClass();
              String _name = _eClass.getName();
              _builder.append(_name, "");
              _builder.append(" ");
              String _partialName = this.partialName(pkg1);
              String _plus = ("pk_" + _partialName);
              String _prefixedSymbolName = this.getPrefixedSymbolName(pkg1, _plus);
              _builder.append(_prefixedSymbolName, "");
              _builder.append(" = create");
              EClass _eClass_1 = pkg1.eClass();
              String _name_1 = _eClass_1.getName();
              _builder.append(_name_1, "");
              _builder.append("(\"");
              String _name_2 = pkg1.getName();
              _builder.append(_name_2, "");
              _builder.append("\", ");
              {
                String _nsPrefix = pkg1.getNsPrefix();
                boolean _notEquals = (!Objects.equal(_nsPrefix, null));
                if (_notEquals) {
                  _builder.append("\"");
                  String _nsPrefix_1 = pkg1.getNsPrefix();
                  _builder.append(_nsPrefix_1, "");
                  _builder.append("\"");
                } else {
                  _builder.append("null");
                }
              }
              _builder.append(", ");
              {
                String _nsURI = pkg1.getNsURI();
                boolean _notEquals_1 = (!Objects.equal(_nsURI, null));
                if (_notEquals_1) {
                  _builder.append("\"");
                  String _nsURI_1 = pkg1.getNsURI();
                  _builder.append(_nsURI_1, "");
                  _builder.append("\"");
                } else {
                  _builder.append("null");
                }
              }
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.newLine();
        }
      }
      _builder.append("protected void installPackages() {");
      _builder.newLine();
      _builder.append("\t");
      String _emitRoot = this.emitRoot(rootPackage);
      _builder.append(_emitRoot, "	");
      _builder.newLineIfNotEmpty();
      {
        int _size_1 = allPackages.size();
        boolean _greaterThan_1 = (_size_1 > 0);
        if (_greaterThan_1) {
          {
            for(final org.eclipse.ocl.examples.pivot.Package pkg2 : allPackages) {
              _builder.append("\t");
              String _emitPackage = this.emitPackage(pkg2);
              _builder.append(_emitPackage, "	");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String defineParameterTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void installParameterTypes() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String definePrecedences(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Library> allLibraries = this.getSortedLibraries(_rootPackage);
      Root _rootPackage_1 = this.getRootPackage(pkg);
      List<Operation> allOperations = this.getSortedOperationsWithPrecedence(_rootPackage_1);
      StringConcatenation _builder = new StringConcatenation();
      {
        int _size = allLibraries.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          _builder.append("protected void installPrecedences() {");
          _builder.newLine();
          {
            for(final Library lib : allLibraries) {
              _builder.append("\t");
              List<Precedence> allPrecedences = this.getSortedPrecedences(lib);
              _builder.newLineIfNotEmpty();
              {
                for(final Precedence precedence : allPrecedences) {
                  _builder.append("\t");
                  _builder.append("final Precedence ");
                  String _partialName = this.partialName(precedence);
                  String _plus = ("prec_" + _partialName);
                  String _prefixedSymbolName = this.getPrefixedSymbolName(precedence, _plus);
                  _builder.append(_prefixedSymbolName, "	");
                  _builder.append(" = createPrecedence(\"");
                  String _name = precedence.getName();
                  _builder.append(_name, "	");
                  _builder.append("\", AssociativityKind.");
                  AssociativityKind _associativity = precedence.getAssociativity();
                  String _string = _associativity.toString();
                  String _upperCase = _string.toUpperCase();
                  _builder.append(_upperCase, "	");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.newLine();
              _builder.append("\t");
              _builder.append("final List<Precedence> ownedPrecedences = ");
              String _symbolName = this.getSymbolName(lib);
              _builder.append(_symbolName, "	");
              _builder.append(".getOwnedPrecedence();");
              _builder.newLineIfNotEmpty();
              {
                List<Precedence> _ownedPrecedence = lib.getOwnedPrecedence();
                for(final Precedence precedence_1 : _ownedPrecedence) {
                  _builder.append("\t");
                  _builder.append("ownedPrecedences.add(");
                  String _symbolName_1 = this.getSymbolName(precedence_1);
                  _builder.append(_symbolName_1, "	");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.newLine();
          {
            for(final Operation operation : allOperations) {
              _builder.append("\t");
              String _symbolName_2 = this.getSymbolName(operation);
              _builder.append(_symbolName_2, "	");
              _builder.append(".setPrecedence(");
              Precedence _precedence = operation.getPrecedence();
              String _symbolName_3 = this.getSymbolName(_precedence);
              _builder.append(_symbolName_3, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("}");
          _builder.newLine();
        }
      }
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String definePrimitiveTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<PrimitiveType> allTypes = this.getSortedPrimitiveTypes(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installPrimitiveTypes() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final List<Type> ownedTypes = ");
      String _symbolName = this.getSymbolName(pkg);
      _builder.append(_symbolName, "	");
      _builder.append(".getOwnedType();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("PrimitiveType type;");
      _builder.newLine();
      {
        for(final PrimitiveType type : allTypes) {
          _builder.append("\t");
          List<Type> superClasses = this.getSuperclassesInPackage(type);
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("ownedTypes.add(type = ");
          String _symbolName_1 = this.getSymbolName(type);
          _builder.append(_symbolName_1, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          {
            for(final Type superClass : superClasses) {
              _builder.append("\t");
              _builder.append("type.getSuperClass().add(");
              String _symbolName_2 = this.getSymbolName(superClass);
              _builder.append(_symbolName_2, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String defineProperties(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<Property> allProperties = this.getAllProperties(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installProperties() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Property> ownedProperties;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Property property;");
      _builder.newLine();
      {
        List<Type> _sortedOwningTypes2 = this.getSortedOwningTypes2(allProperties);
        for(final Type type : _sortedOwningTypes2) {
          _builder.append("\t");
          _builder.append("ownedProperties = ");
          String _symbolName = this.getSymbolName(type);
          _builder.append(_symbolName, "	");
          _builder.append(".getOwnedAttribute();");
          _builder.newLineIfNotEmpty();
          {
            List<Property> _sortedProperties = this.getSortedProperties(type, allProperties);
            for(final Property property : _sortedProperties) {
              _builder.append("\t");
              _builder.append("ownedProperties.add(property = ");
              String _symbolName_1 = this.getSymbolName(property);
              _builder.append(_symbolName_1, "	");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              {
                boolean _isComposite = property.isComposite();
                if (_isComposite) {
                  _builder.append("\t");
                  _builder.append("property.setIsComposite(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isDerived = property.isDerived();
                if (_isDerived) {
                  _builder.append("\t");
                  _builder.append("property.setIsDerived(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isID = property.isID();
                if (_isID) {
                  _builder.append("\t");
                  _builder.append("property.setIsID(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isImplicit = property.isImplicit();
                if (_isImplicit) {
                  _builder.append("\t");
                  _builder.append("property.setImplicit(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isReadOnly = property.isReadOnly();
                if (_isReadOnly) {
                  _builder.append("\t");
                  _builder.append("property.setIsReadOnly(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isRequired = property.isRequired();
                boolean _not = (!_isRequired);
                if (_not) {
                  _builder.append("\t");
                  _builder.append("property.setIsRequired(false);");
                  _builder.newLine();
                }
              }
              {
                boolean _isResolveProxies = property.isResolveProxies();
                if (_isResolveProxies) {
                  _builder.append("\t");
                  _builder.append("property.setIsResolveProxies(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isStatic = property.isStatic();
                if (_isStatic) {
                  _builder.append("\t");
                  _builder.append("property.setIsStatic(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isTransient = property.isTransient();
                if (_isTransient) {
                  _builder.append("\t");
                  _builder.append("property.setIsTransient(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isUnsettable = property.isUnsettable();
                if (_isUnsettable) {
                  _builder.append("\t");
                  _builder.append("property.setIsUnsettable(true);");
                  _builder.newLine();
                }
              }
              {
                boolean _isVolatile = property.isVolatile();
                if (_isVolatile) {
                  _builder.append("\t");
                  _builder.append("property.setIsVolatile(true);");
                  _builder.newLine();
                }
              }
              {
                Property _opposite = property.getOpposite();
                boolean _notEquals = (!Objects.equal(_opposite, null));
                if (_notEquals) {
                  _builder.append("\t");
                  _builder.append("property.setOpposite(");
                  Property _opposite_1 = property.getOpposite();
                  String _symbolName_2 = this.getSymbolName(_opposite_1);
                  _builder.append(_symbolName_2, "	");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
              {
                String _implementationClass = property.getImplementationClass();
                boolean _notEquals_1 = (!Objects.equal(_implementationClass, null));
                if (_notEquals_1) {
                  _builder.append("\t");
                  _builder.append("property.setImplementationClass(\"");
                  String _implementationClass_1 = property.getImplementationClass();
                  _builder.append(_implementationClass_1, "	");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("property.setImplementation(");
                  String _implementationClass_2 = property.getImplementationClass();
                  _builder.append(_implementationClass_2, "	");
                  _builder.append(".INSTANCE);");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String defineTemplateBindings(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<TemplateableElement> allTemplateableElements = this.getSortedTemplateableElements(_rootPackage);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installTemplateBindings() {");
      _builder.newLine();
      {
        for(final TemplateableElement templateableElement : allTemplateableElements) {
          {
            List<TemplateBinding> _templateBinding = templateableElement.getTemplateBinding();
            for(final TemplateBinding templateBinding : _templateBinding) {
              _builder.append("\t");
              String _symbolName = this.getSymbolName(templateableElement);
              _builder.append(_symbolName, "	");
              _builder.append(".getTemplateBinding().add(createTemplateBinding(");
              TemplateSignature _signature = templateBinding.getSignature();
              String _symbolName_1 = this.getSymbolName(_signature);
              _builder.append(_symbolName_1, "	");
              _builder.append(",");
              _builder.newLineIfNotEmpty();
              {
                List<TemplateParameterSubstitution> _parameterSubstitution = templateBinding.getParameterSubstitution();
                boolean _hasElements = false;
                for(final TemplateParameterSubstitution templateParameterSubstitution : _parameterSubstitution) {
                  if (!_hasElements) {
                    _hasElements = true;
                  } else {
                    _builder.appendImmediate(",\n", "		");
                  }
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("createTemplateParameterSubstitution(");
                  TemplateParameter _formal = templateParameterSubstitution.getFormal();
                  String _symbolName_2 = this.getSymbolName(_formal);
                  _builder.append(_symbolName_2, "		");
                  _builder.append(", ");
                  ParameterableElement _actual = templateParameterSubstitution.getActual();
                  String _symbolName_3 = this.getSymbolName(_actual);
                  _builder.append(_symbolName_3, "		");
                  _builder.append(")");
                }
              }
              _builder.append("));");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String defineTemplateSignatures(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<TemplateParameter> allTemplateParameters = this.getSortedTemplateParameters(_rootPackage);
      Root _rootPackage_1 = this.getRootPackage(pkg);
      List<TemplateSignature> allTemplateSignatures = this.getSortedTemplateSignatures(_rootPackage_1);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final TemplateParameter templateParameter : allTemplateParameters) {
          _builder.append("protected final @NonNull TypeTemplateParameter ");
          String _partialName = this.partialName(templateParameter);
          String _plus = ("tp_" + _partialName);
          String _prefixedSymbolName = this.getPrefixedSymbolName(templateParameter, _plus);
          _builder.append(_prefixedSymbolName, "");
          _builder.append(" = createTypeTemplateParameter(");
          ParameterableElement _ownedParameteredElement = templateParameter.getOwnedParameteredElement();
          String _symbolName = this.getSymbolName(_ownedParameteredElement);
          _builder.append(_symbolName, "");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        for(final TemplateSignature templateSignature : allTemplateSignatures) {
          _builder.append("protected final @NonNull TemplateSignature ");
          String _partialName_1 = this.partialName(templateSignature);
          String _plus_1 = ("ts_" + _partialName_1);
          String _prefixedSymbolName_1 = this.getPrefixedSymbolName(templateSignature, _plus_1);
          _builder.append(_prefixedSymbolName_1, "");
          _builder.append(" = createTemplateSignature(");
          TemplateableElement _template = templateSignature.getTemplate();
          String _symbolName_1 = this.getSymbolName(_template);
          _builder.append(_symbolName_1, "");
          {
            List<TemplateParameter> _ownedParameter = templateSignature.getOwnedParameter();
            for(final TemplateParameter templateParameter_1 : _ownedParameter) {
              _builder.append(", ");
              String _symbolName_2 = this.getSymbolName(templateParameter_1);
              _builder.append(_symbolName_2, "");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("protected void installTemplateSignatures() {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String defineTupleTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    String _xblockexpression = null;
    {
      Root _rootPackage = this.getRootPackage(pkg);
      List<TupleType> allTupleTypes = this.getSortedTupleTypes(_rootPackage);
      org.eclipse.ocl.examples.pivot.Package orphanPackage = this.getOrphanPackage(pkg);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("protected void installTupleTypes() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final List<Type> orphanTypes = ");
      String _symbolName = this.getSymbolName(orphanPackage);
      _builder.append(_symbolName, "	");
      _builder.append(".getOwnedType();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("TupleType type;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("List<Type> superClasses;");
      _builder.newLine();
      {
        for(final TupleType type : allTupleTypes) {
          _builder.append("\t");
          _builder.append("orphanTypes.add(type = ");
          String _symbolName_1 = this.getSymbolName(type);
          _builder.append(_symbolName_1, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          {
            List<Property> _sortedProperties = this.getSortedProperties(type);
            for(final Property property : _sortedProperties) {
              {
                String _implementationClass = property.getImplementationClass();
                boolean _notEquals = (!Objects.equal(_implementationClass, null));
                if (_notEquals) {
                  _builder.append("\t");
                  String _symbolName_2 = this.getSymbolName(property);
                  _builder.append(_symbolName_2, "	");
                  _builder.append(".setImplementationClass(\"");
                  String _implementationClass_1 = property.getImplementationClass();
                  _builder.append(_implementationClass_1, "	");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  String _symbolName_3 = this.getSymbolName(property);
                  _builder.append(_symbolName_3, "	");
                  _builder.append(".setImplementation(");
                  String _implementationClass_2 = property.getImplementationClass();
                  _builder.append(_implementationClass_2, "	");
                  _builder.append(".INSTANCE);");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.append("\t");
          String _emitSuperClasses = this.emitSuperClasses(type);
          _builder.append(_emitSuperClasses, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String emitCreateProperty(final Property property) {
    String _name = property.getName();
    String _plus = ("createProperty(" + _name);
    String _plus_1 = (_plus + ", ");
    Type _type = property.getType();
    String _symbolName = this.getSymbolName(_type);
    String _plus_2 = (_plus_1 + _symbolName);
    return (_plus_2 + ")");
  }
  
  protected String emitPackage(final org.eclipse.ocl.examples.pivot.Package pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<org.eclipse.ocl.examples.pivot.Package> _sortedPackages = this.getSortedPackages(pkg);
      for(final org.eclipse.ocl.examples.pivot.Package nestedPackage : _sortedPackages) {
        {
          List<org.eclipse.ocl.examples.pivot.Package> _nestedPackage = nestedPackage.getNestedPackage();
          int _size = _nestedPackage.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            String _emitPackage = this.emitPackage(nestedPackage);
            _builder.append(_emitPackage, "");
            _builder.newLineIfNotEmpty();
          }
        }
        String _symbolName = this.getSymbolName(pkg);
        _builder.append(_symbolName, "");
        _builder.append(".getNestedPackage().add(");
        String _symbolName_1 = this.getSymbolName(nestedPackage);
        _builder.append(_symbolName_1, "");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String emitRoot(final Root pkg) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<org.eclipse.ocl.examples.pivot.Package> _sortedPackages = this.getSortedPackages(pkg);
      for(final org.eclipse.ocl.examples.pivot.Package nestedPackage : _sortedPackages) {
        {
          List<org.eclipse.ocl.examples.pivot.Package> _nestedPackage = nestedPackage.getNestedPackage();
          int _size = _nestedPackage.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            String _emitPackage = this.emitPackage(nestedPackage);
            _builder.append(_emitPackage, "");
            _builder.newLineIfNotEmpty();
          }
        }
        String _symbolName = this.getSymbolName(pkg);
        _builder.append(_symbolName, "");
        _builder.append(".getNestedPackage().add(");
        String _symbolName_1 = this.getSymbolName(nestedPackage);
        _builder.append(_symbolName_1, "");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String emitSuperClasses(final Type type) {
    String _xblockexpression = null;
    {
      List<Type> superClasses = this.getSuperclassesInPackage(type);
      StringConcatenation _builder = new StringConcatenation();
      {
        int _size = superClasses.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          _builder.append("superClasses = type.getSuperClass();");
          _builder.newLine();
          {
            for(final Type superClass : superClasses) {
              _builder.append("superClasses.add(");
              String _symbolName = this.getSymbolName(superClass);
              _builder.append(_symbolName, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        } else {
          boolean _not = (!(type instanceof AnyType));
          if (_not) {
            _builder.append("superClasses = type.getSuperClass();");
            _builder.newLine();
            _builder.append("superClasses.add(_OclElement);");
            _builder.newLine();
          }
        }
      }
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected Set<CollectionType> getAllCollectionTypes(final Root root) {
    HashSet<CollectionType> _hashSet = new HashSet<CollectionType>();
    Set<CollectionType> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof CollectionType)) {
          allElements.add(((CollectionType) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    return allElements;
  }
  
  protected Set<Enumeration> getAllEnumerations(final Root root) {
    HashSet<Enumeration> _hashSet = new HashSet<Enumeration>();
    Set<Enumeration> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof Enumeration)) {
          allElements.add(((Enumeration) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    return allElements;
  }
  
  protected Set<LambdaType> getAllLambdaTypes(final Root root) {
    HashSet<LambdaType> _hashSet = new HashSet<LambdaType>();
    Set<LambdaType> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof LambdaType)) {
          allElements.add(((LambdaType) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    return allElements;
  }
  
  protected Set<Metaclass> getAllMetaclasses(final Root root) {
    HashSet<Metaclass> _hashSet = new HashSet<Metaclass>();
    Set<Metaclass> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof Metaclass)) {
          allElements.add(((Metaclass) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    return allElements;
  }
  
  protected List<org.eclipse.ocl.examples.pivot.Package> getAllPackages(final Root root) {
    HashSet<org.eclipse.ocl.examples.pivot.Package> _hashSet = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
    Set<org.eclipse.ocl.examples.pivot.Package> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof org.eclipse.ocl.examples.pivot.Package)) {
          allElements.add(((org.eclipse.ocl.examples.pivot.Package) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<org.eclipse.ocl.examples.pivot.Package> _arrayList = new ArrayList<org.eclipse.ocl.examples.pivot.Package>(allElements);
    List<org.eclipse.ocl.examples.pivot.Package> sortedElements = _arrayList;
    final Comparator<org.eclipse.ocl.examples.pivot.Package> _function = new Comparator<org.eclipse.ocl.examples.pivot.Package>() {
        public int compare(final org.eclipse.ocl.examples.pivot.Package t1, final org.eclipse.ocl.examples.pivot.Package t2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(t1);
            String m2 = GenerateOCLCommon.this.getMoniker(t2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<org.eclipse.ocl.examples.pivot.Package>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected Set<Precedence> getAllPrecedences(final Root root) {
    HashSet<Precedence> _hashSet = new HashSet<Precedence>();
    Set<Precedence> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof Precedence)) {
          allElements.add(((Precedence) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    return allElements;
  }
  
  protected Set<PrimitiveType> getAllPrimitiveTypes(final Root root) {
    HashSet<PrimitiveType> _hashSet = new HashSet<PrimitiveType>();
    Set<PrimitiveType> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof PrimitiveType)) {
          allElements.add(((PrimitiveType) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    return allElements;
  }
  
  protected List<Property> getAllProperties(final Root root) {
    ArrayList<Property> _arrayList = new ArrayList<Property>();
    List<Property> allElements = _arrayList;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        boolean _and = false;
        boolean _and_1 = false;
        if (!(eObject instanceof Property)) {
          _and_1 = false;
        } else {
          EObject _eContainer = eObject.eContainer();
          boolean _not = (!(_eContainer instanceof TupleType));
          _and_1 = ((eObject instanceof Property) && _not);
        }
        if (!_and_1) {
          _and = false;
        } else {
          Type _owningType = ((Property) eObject).getOwningType();
          boolean _notEquals = (!Objects.equal(_owningType, null));
          _and = (_and_1 && _notEquals);
        }
        if (_and) {
          allElements.add(((Property) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    return allElements;
  }
  
  protected Set<TemplateBinding> getAllTemplateBindings(final Root root) {
    HashSet<TemplateBinding> _hashSet = new HashSet<TemplateBinding>();
    Set<TemplateBinding> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof TemplateBinding)) {
          allElements.add(((TemplateBinding) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    return allElements;
  }
  
  protected Set<TemplateSignature> getAllTemplateSignatures(final Root root) {
    HashSet<TemplateSignature> _hashSet = new HashSet<TemplateSignature>();
    Set<TemplateSignature> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof TemplateSignature)) {
          allElements.add(((TemplateSignature) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    return allElements;
  }
  
  protected Set<TupleType> getAllTupleTypes(final Root root) {
    HashSet<TupleType> _hashSet = new HashSet<TupleType>();
    Set<TupleType> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof TupleType)) {
          allElements.add(((TupleType) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    return allElements;
  }
  
  protected Set<Type> getAllTypes(final Root root) {
    HashSet<Type> _hashSet = new HashSet<Type>();
    Set<Type> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof Type)) {
          allElements.add(((Type) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    return allElements;
  }
  
  protected String getMoniker(final Element elem) {
    return Pivot2Moniker.toString(elem);
  }
  
  protected Collection<Type> getOclTypes(final Root root) {
    HashMap<String,Type> _hashMap = new HashMap<String,Type>();
    Map<String,Type> allElements = _hashMap;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        boolean _and = false;
        boolean _and_1 = false;
        boolean _and_2 = false;
        boolean _and_3 = false;
        boolean _and_4 = false;
        boolean _and_5 = false;
        boolean _and_6 = false;
        if (!(eObject instanceof Type)) {
          _and_6 = false;
        } else {
          boolean _not = (!(eObject instanceof Enumeration));
          _and_6 = ((eObject instanceof Type) && _not);
        }
        if (!_and_6) {
          _and_5 = false;
        } else {
          boolean _not_1 = (!(eObject instanceof LambdaType));
          _and_5 = (_and_6 && _not_1);
        }
        if (!_and_5) {
          _and_4 = false;
        } else {
          boolean _not_2 = (!(eObject instanceof CollectionType));
          _and_4 = (_and_5 && _not_2);
        }
        if (!_and_4) {
          _and_3 = false;
        } else {
          boolean _not_3 = (!(eObject instanceof PrimitiveType));
          _and_3 = (_and_4 && _not_3);
        }
        if (!_and_3) {
          _and_2 = false;
        } else {
          boolean _not_4 = (!(eObject instanceof Metaclass));
          _and_2 = (_and_3 && _not_4);
        }
        if (!_and_2) {
          _and_1 = false;
        } else {
          boolean _not_5 = (!(eObject instanceof TupleType));
          _and_1 = (_and_2 && _not_5);
        }
        if (!_and_1) {
          _and = false;
        } else {
          TemplateParameter _owningTemplateParameter = ((Type) eObject).getOwningTemplateParameter();
          boolean _equals = Objects.equal(_owningTemplateParameter, null);
          _and = (_and_1 && _equals);
        }
        if (_and) {
          String _name = ((Type) eObject).getName();
          allElements.put(_name, ((Type) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    boolean _containsKey = allElements.containsKey("Boolean");
    if (_containsKey) {
      allElements.remove("Boolean");
      allElements.remove("Integer");
      allElements.remove("OclElement");
      allElements.remove("Real");
      allElements.remove("String");
      allElements.remove("UnlimitedNatural");
    }
    return allElements.values();
  }
  
  protected org.eclipse.ocl.examples.pivot.Package getOrphanPackage(final org.eclipse.ocl.examples.pivot.Package elem) {
    Root _rootPackage = this.getRootPackage(elem);
    return this.getOrphanPackage(_rootPackage);
  }
  
  protected org.eclipse.ocl.examples.pivot.Package getOrphanPackage(final Root elem) {
    List<org.eclipse.ocl.examples.pivot.Package> _allPackages = this.getAllPackages(elem);
    for (final org.eclipse.ocl.examples.pivot.Package pkg : _allPackages) {
      String _name = pkg.getName();
      boolean _equals = "$$".equals(_name);
      if (_equals) {
        return pkg;
      }
    }
    return null;
  }
  
  protected Root getRootPackage(final org.eclipse.ocl.examples.pivot.Package elem) {
    EObject eObject = elem;
    boolean _notEquals = (!Objects.equal(eObject, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        if ((eObject instanceof Root)) {
          return ((Root) eObject);
        }
        EObject _eContainer = eObject.eContainer();
        eObject = _eContainer;
      }
      boolean _notEquals_1 = (!Objects.equal(eObject, null));
      _while = _notEquals_1;
    }
    return null;
  }
  
  protected String getSignature(final NamedElement elem) {
    EObject parent = elem.eContainer();
    boolean _notEquals = (!Objects.equal(parent, null));
    if (_notEquals) {
      String _signature = this.getSignature(((NamedElement) parent));
      String _plus = (_signature + "::");
      String _name = elem.getName();
      return (_plus + _name);
    } else {
      return elem.getName();
    }
  }
  
  protected String getSignature(final Operation elem) {
    EObject parent = elem.eContainer();
    boolean _notEquals = (!Objects.equal(parent, null));
    if (_notEquals) {
      String _signature = this.getSignature(((NamedElement) parent));
      String _plus = (_signature + "::");
      String _name = elem.getName();
      String _plus_1 = (_plus + _name);
      return (_plus_1 + "()");
    } else {
      String _name_1 = elem.getName();
      return (_name_1 + "()");
    }
  }
  
  protected String getPrefixedSymbolName(final EObject elem, final String prefix) {
    return NameQueries.getPrefixedSymbolName(prefix, elem);
  }
  
  protected ResourceSet getResourceSet() {
    boolean _equals = Objects.equal(this.resourceSet, null);
    if (_equals) {
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      this.resourceSet = _resourceSetImpl;
    }
    return this.resourceSet;
  }
  
  protected List<CollectionType> getSortedCollectionTypes(final Root root) {
    HashSet<CollectionType> _hashSet = new HashSet<CollectionType>();
    Set<CollectionType> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof CollectionType)) {
          allElements.add(((CollectionType) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<CollectionType> _arrayList = new ArrayList<CollectionType>(allElements);
    List<CollectionType> sortedElements = _arrayList;
    final Comparator<CollectionType> _function = new Comparator<CollectionType>() {
        public int compare(final CollectionType c1, final CollectionType c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<CollectionType>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Element> getSortedCommentedElements(final Root root) {
    Collection<Type> oclTypes = this.getOclTypes(root);
    HashSet<Element> _hashSet = new HashSet<Element>();
    Set<Element> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        boolean _and = false;
        boolean _and_1 = false;
        boolean _and_2 = false;
        if (!(eObject instanceof Element)) {
          _and_2 = false;
        } else {
          boolean _not = (!(eObject instanceof Constraint));
          _and_2 = ((eObject instanceof Element) && _not);
        }
        if (!_and_2) {
          _and_1 = false;
        } else {
          boolean _and_3 = false;
          if (!(eObject instanceof Property)) {
            _and_3 = false;
          } else {
            Type _owningType = ((Property) eObject).getOwningType();
            boolean _equals = Objects.equal(_owningType, null);
            _and_3 = ((eObject instanceof Property) && _equals);
          }
          boolean _not_1 = (!_and_3);
          _and_1 = (_and_2 && _not_1);
        }
        if (!_and_1) {
          _and = false;
        } else {
          boolean _and_4 = false;
          if (!(eObject instanceof Type)) {
            _and_4 = false;
          } else {
            boolean _contains = oclTypes.contains(eObject);
            boolean _not_2 = (!_contains);
            _and_4 = ((eObject instanceof Type) && _not_2);
          }
          boolean _not_3 = (!_and_4);
          _and = (_and_1 && _not_3);
        }
        if (_and) {
          Element t = ((Element) eObject);
          List<Comment> _ownedComment = t.getOwnedComment();
          int _size = _ownedComment.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            allElements.add(t);
          }
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<Element> _arrayList = new ArrayList<Element>(allElements);
    List<Element> sortedElements = _arrayList;
    final Comparator<Element> _function = new Comparator<Element>() {
        public int compare(final Element t1, final Element t2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(t1);
            String m2 = GenerateOCLCommon.this.getMoniker(t2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Element>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Comment> getSortedComments(final Element element) {
    List<Comment> _ownedComment = element.getOwnedComment();
    ArrayList<Comment> _arrayList = new ArrayList<Comment>(_ownedComment);
    List<Comment> sortedElements = _arrayList;
    final Comparator<Comment> _function = new Comparator<Comment>() {
        public int compare(final Comment c1, final Comment c2) {
          int _xblockexpression = (int) 0;
          {
            String n1 = c1.getBody();
            String n2 = c2.getBody();
            int _compareTo = n1.compareTo(n2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Comment>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Enumeration> getSortedEnumerations(final Root root) {
    HashSet<Enumeration> _hashSet = new HashSet<Enumeration>();
    Set<Enumeration> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof Enumeration)) {
          allElements.add(((Enumeration) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<Enumeration> _arrayList = new ArrayList<Enumeration>(allElements);
    List<Enumeration> sortedElements = _arrayList;
    final Comparator<Enumeration> _function = new Comparator<Enumeration>() {
        public int compare(final Enumeration c1, final Enumeration c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Enumeration>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Iteration> getSortedIterations(final Root root) {
    HashSet<Iteration> _hashSet = new HashSet<Iteration>();
    Set<Iteration> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof Iteration)) {
          allElements.add(((Iteration) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<Iteration> _arrayList = new ArrayList<Iteration>(allElements);
    List<Iteration> sortedElements = _arrayList;
    final Comparator<Iteration> _function = new Comparator<Iteration>() {
        public int compare(final Iteration c1, final Iteration c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Iteration>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Iteration> getSortedIterations(final Type type, final List<Iteration> allIterations) {
    HashSet<Iteration> _hashSet = new HashSet<Iteration>();
    Set<Iteration> allElements = _hashSet;
    List<Operation> _ownedOperation = type.getOwnedOperation();
    for (final Operation operation : _ownedOperation) {
      boolean _contains = allIterations.contains(operation);
      if (_contains) {
        allElements.add(((Iteration) operation));
      }
    }
    ArrayList<Iteration> _arrayList = new ArrayList<Iteration>(allElements);
    List<Iteration> sortedElements = _arrayList;
    final Comparator<Iteration> _function = new Comparator<Iteration>() {
        public int compare(final Iteration c1, final Iteration c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Iteration>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<LambdaType> getSortedLambdaTypes(final Root root) {
    HashSet<LambdaType> _hashSet = new HashSet<LambdaType>();
    Set<LambdaType> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof LambdaType)) {
          allElements.add(((LambdaType) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<LambdaType> _arrayList = new ArrayList<LambdaType>(allElements);
    List<LambdaType> sortedElements = _arrayList;
    final Comparator<LambdaType> _function = new Comparator<LambdaType>() {
        public int compare(final LambdaType c1, final LambdaType c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<LambdaType>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Library> getSortedLibraries(final Root root) {
    HashSet<Library> _hashSet = new HashSet<Library>();
    Set<Library> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof Library)) {
          allElements.add(((Library) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<Library> _arrayList = new ArrayList<Library>(allElements);
    List<Library> sortedElements = _arrayList;
    final Comparator<Library> _function = new Comparator<Library>() {
        public int compare(final Library t1, final Library t2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(t1);
            String m2 = GenerateOCLCommon.this.getMoniker(t2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Library>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Metaclass> getSortedMetaclasses(final Root root) {
    HashSet<Metaclass> _hashSet = new HashSet<Metaclass>();
    Set<Metaclass> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof Metaclass)) {
          allElements.add(((Metaclass) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<Metaclass> _arrayList = new ArrayList<Metaclass>(allElements);
    List<Metaclass> sortedElements = _arrayList;
    final Comparator<Metaclass> _function = new Comparator<Metaclass>() {
        public int compare(final Metaclass c1, final Metaclass c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Metaclass>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Type> getSortedOclTypes(final org.eclipse.ocl.examples.pivot.Package pkg) {
    Root _rootPackage = this.getRootPackage(pkg);
    Collection<Type> _oclTypes = this.getOclTypes(_rootPackage);
    ArrayList<Type> _arrayList = new ArrayList<Type>(_oclTypes);
    List<Type> sortedElements = _arrayList;
    final Comparator<Type> _function = new Comparator<Type>() {
        public int compare(final Type t1, final Type t2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(t1);
            String m2 = GenerateOCLCommon.this.getMoniker(t2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Type>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Operation> getSortedOperations(final Root root) {
    HashSet<Operation> _hashSet = new HashSet<Operation>();
    Set<Operation> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        boolean _and = false;
        boolean _and_1 = false;
        if (!(eObject instanceof Operation)) {
          _and_1 = false;
        } else {
          boolean _not = (!(eObject instanceof Iteration));
          _and_1 = ((eObject instanceof Operation) && _not);
        }
        if (!_and_1) {
          _and = false;
        } else {
          Boolean _isEcoreConstraint = this.isEcoreConstraint(((Operation) eObject));
          boolean _not_1 = (!(_isEcoreConstraint).booleanValue());
          _and = (_and_1 && _not_1);
        }
        if (_and) {
          allElements.add(((Operation) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<Operation> _arrayList = new ArrayList<Operation>(allElements);
    List<Operation> sortedElements = _arrayList;
    final Comparator<Operation> _function = new Comparator<Operation>() {
        public int compare(final Operation c1, final Operation c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Operation>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Operation> getSortedOperations(final Type type, final List<Operation> allOperations) {
    HashSet<Operation> _hashSet = new HashSet<Operation>();
    Set<Operation> allElements = _hashSet;
    List<Operation> _ownedOperation = type.getOwnedOperation();
    for (final Operation operation : _ownedOperation) {
      boolean _contains = allOperations.contains(operation);
      if (_contains) {
        allElements.add(operation);
      }
    }
    ArrayList<Operation> _arrayList = new ArrayList<Operation>(allElements);
    List<Operation> sortedElements = _arrayList;
    final Comparator<Operation> _function = new Comparator<Operation>() {
        public int compare(final Operation c1, final Operation c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Operation>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Operation> getSortedOperationsWithPrecedence(final Root root) {
    HashSet<Operation> _hashSet = new HashSet<Operation>();
    Set<Operation> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        boolean _and = false;
        boolean _and_1 = false;
        if (!(eObject instanceof Operation)) {
          _and_1 = false;
        } else {
          boolean _not = (!(eObject instanceof Iteration));
          _and_1 = ((eObject instanceof Operation) && _not);
        }
        if (!_and_1) {
          _and = false;
        } else {
          Boolean _isEcoreConstraint = this.isEcoreConstraint(((Operation) eObject));
          boolean _not_1 = (!(_isEcoreConstraint).booleanValue());
          _and = (_and_1 && _not_1);
        }
        if (_and) {
          Operation operation = ((Operation) eObject);
          boolean _and_2 = false;
          boolean _and_3 = false;
          boolean _not_2 = (!(operation instanceof Iteration));
          if (!_not_2) {
            _and_3 = false;
          } else {
            Boolean _isEcoreConstraint_1 = this.isEcoreConstraint(operation);
            boolean _not_3 = (!(_isEcoreConstraint_1).booleanValue());
            _and_3 = (_not_2 && _not_3);
          }
          if (!_and_3) {
            _and_2 = false;
          } else {
            Precedence _precedence = operation.getPrecedence();
            boolean _notEquals = (!Objects.equal(_precedence, null));
            _and_2 = (_and_3 && _notEquals);
          }
          if (_and_2) {
            allElements.add(operation);
          }
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<Operation> _arrayList = new ArrayList<Operation>(allElements);
    List<Operation> sortedElements = _arrayList;
    final Comparator<Operation> _function = new Comparator<Operation>() {
        public int compare(final Operation c1, final Operation c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Operation>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Type> getSortedOwningTypes(final List<? extends Operation> operations) {
    HashSet<Type> _hashSet = new HashSet<Type>();
    Set<Type> allElements = _hashSet;
    for (final Operation operation : operations) {
      Type _owningType = operation.getOwningType();
      boolean _notEquals = (!Objects.equal(_owningType, null));
      if (_notEquals) {
        Type _owningType_1 = operation.getOwningType();
        allElements.add(_owningType_1);
      }
    }
    ArrayList<Type> _arrayList = new ArrayList<Type>(allElements);
    List<Type> sortedElements = _arrayList;
    final Comparator<Type> _function = new Comparator<Type>() {
        public int compare(final Type c1, final Type c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Type>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Type> getSortedOwningTypes2(final List<? extends Property> properties) {
    HashSet<Type> _hashSet = new HashSet<Type>();
    Set<Type> allElements = _hashSet;
    for (final Property property : properties) {
      Type _owningType = property.getOwningType();
      boolean _notEquals = (!Objects.equal(_owningType, null));
      if (_notEquals) {
        Type _owningType_1 = property.getOwningType();
        allElements.add(_owningType_1);
      }
    }
    ArrayList<Type> _arrayList = new ArrayList<Type>(allElements);
    List<Type> sortedElements = _arrayList;
    final Comparator<Type> _function = new Comparator<Type>() {
        public int compare(final Type c1, final Type c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Type>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<org.eclipse.ocl.examples.pivot.Package> getSortedPackages(final Root root) {
    HashSet<org.eclipse.ocl.examples.pivot.Package> _hashSet = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
    Set<org.eclipse.ocl.examples.pivot.Package> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof org.eclipse.ocl.examples.pivot.Package)) {
          allElements.add(((org.eclipse.ocl.examples.pivot.Package) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<org.eclipse.ocl.examples.pivot.Package> _arrayList = new ArrayList<org.eclipse.ocl.examples.pivot.Package>(allElements);
    List<org.eclipse.ocl.examples.pivot.Package> sortedElements = _arrayList;
    final Comparator<org.eclipse.ocl.examples.pivot.Package> _function = new Comparator<org.eclipse.ocl.examples.pivot.Package>() {
        public int compare(final org.eclipse.ocl.examples.pivot.Package t1, final org.eclipse.ocl.examples.pivot.Package t2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = t1.getName();
            String m2 = t2.getName();
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<org.eclipse.ocl.examples.pivot.Package>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<org.eclipse.ocl.examples.pivot.Package> getSortedPackages(final org.eclipse.ocl.examples.pivot.Package pkg) {
    List<org.eclipse.ocl.examples.pivot.Package> _nestedPackage = pkg.getNestedPackage();
    ArrayList<org.eclipse.ocl.examples.pivot.Package> _arrayList = new ArrayList<org.eclipse.ocl.examples.pivot.Package>(_nestedPackage);
    List<org.eclipse.ocl.examples.pivot.Package> sortedElements = _arrayList;
    final Comparator<org.eclipse.ocl.examples.pivot.Package> _function = new Comparator<org.eclipse.ocl.examples.pivot.Package>() {
        public int compare(final org.eclipse.ocl.examples.pivot.Package c1, final org.eclipse.ocl.examples.pivot.Package c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = c1.getName();
            String m2 = c2.getName();
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<org.eclipse.ocl.examples.pivot.Package>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Type> getSortedParameterTypes(final Root root) {
    HashSet<Type> _hashSet = new HashSet<Type>();
    Set<Type> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof Type)) {
          Type t = ((Type) eObject);
          TemplateParameter _owningTemplateParameter = t.getOwningTemplateParameter();
          boolean _notEquals = (!Objects.equal(_owningTemplateParameter, null));
          if (_notEquals) {
            allElements.add(t);
          }
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<Type> _arrayList = new ArrayList<Type>(allElements);
    List<Type> sortedElements = _arrayList;
    final Comparator<Type> _function = new Comparator<Type>() {
        public int compare(final Type t1, final Type t2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(t1);
            String m2 = GenerateOCLCommon.this.getMoniker(t2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Type>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Precedence> getSortedPrecedences(final Library library) {
    List<Precedence> _ownedPrecedence = library.getOwnedPrecedence();
    ArrayList<Precedence> _arrayList = new ArrayList<Precedence>(_ownedPrecedence);
    List<Precedence> sortedElements = _arrayList;
    final Comparator<Precedence> _function = new Comparator<Precedence>() {
        public int compare(final Precedence t1, final Precedence t2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = t1.getName();
            String m2 = t2.getName();
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Precedence>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<PrimitiveType> getSortedPrimitiveTypes(final Root root) {
    HashSet<PrimitiveType> _hashSet = new HashSet<PrimitiveType>();
    Set<PrimitiveType> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof PrimitiveType)) {
          allElements.add(((PrimitiveType) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<PrimitiveType> _arrayList = new ArrayList<PrimitiveType>(allElements);
    List<PrimitiveType> sortedElements = _arrayList;
    final Comparator<PrimitiveType> _function = new Comparator<PrimitiveType>() {
        public int compare(final PrimitiveType t1, final PrimitiveType t2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(t1);
            String m2 = GenerateOCLCommon.this.getMoniker(t2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<PrimitiveType>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Property> getSortedProperties(final Root root) {
    ArrayList<Property> _arrayList = new ArrayList<Property>();
    List<Property> allElements = _arrayList;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        boolean _and = false;
        boolean _and_1 = false;
        if (!(eObject instanceof Property)) {
          _and_1 = false;
        } else {
          EObject _eContainer = eObject.eContainer();
          boolean _not = (!(_eContainer instanceof TupleType));
          _and_1 = ((eObject instanceof Property) && _not);
        }
        if (!_and_1) {
          _and = false;
        } else {
          Type _owningType = ((Property) eObject).getOwningType();
          boolean _notEquals = (!Objects.equal(_owningType, null));
          _and = (_and_1 && _notEquals);
        }
        if (_and) {
          allElements.add(((Property) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<Property> _arrayList_1 = new ArrayList<Property>(allElements);
    List<Property> sortedElements = _arrayList_1;
    final Comparator<Property> _function = new Comparator<Property>() {
        public int compare(final Property t1, final Property t2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(t1);
            String m2 = GenerateOCLCommon.this.getMoniker(t2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Property>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Property> getSortedProperties(final Type type) {
    List<Property> _ownedAttribute = type.getOwnedAttribute();
    ArrayList<Property> _arrayList = new ArrayList<Property>(_ownedAttribute);
    List<Property> sortedElements = _arrayList;
    final Comparator<Property> _function = new Comparator<Property>() {
        public int compare(final Property c1, final Property c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = c1.getName();
            String m2 = c2.getName();
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Property>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Property> getSortedProperties(final Type type, final List<Property> allProperties) {
    HashSet<Property> _hashSet = new HashSet<Property>();
    Set<Property> allElements = _hashSet;
    List<Property> _ownedAttribute = type.getOwnedAttribute();
    for (final Property property : _ownedAttribute) {
      boolean _contains = allProperties.contains(property);
      if (_contains) {
        allElements.add(property);
      }
    }
    ArrayList<Property> _arrayList = new ArrayList<Property>(allElements);
    List<Property> sortedElements = _arrayList;
    final Comparator<Property> _function = new Comparator<Property>() {
        public int compare(final Property c1, final Property c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Property>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<TemplateParameter> getSortedTemplateParameters(final Root root) {
    HashSet<TemplateParameter> _hashSet = new HashSet<TemplateParameter>();
    Set<TemplateParameter> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof TemplateParameter)) {
          allElements.add(((TemplateParameter) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<TemplateParameter> _arrayList = new ArrayList<TemplateParameter>(allElements);
    List<TemplateParameter> sortedElements = _arrayList;
    final Comparator<TemplateParameter> _function = new Comparator<TemplateParameter>() {
        public int compare(final TemplateParameter c1, final TemplateParameter c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<TemplateParameter>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<TemplateSignature> getSortedTemplateSignatures(final Root root) {
    HashSet<TemplateSignature> _hashSet = new HashSet<TemplateSignature>();
    Set<TemplateSignature> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof TemplateSignature)) {
          allElements.add(((TemplateSignature) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<TemplateSignature> _arrayList = new ArrayList<TemplateSignature>(allElements);
    List<TemplateSignature> sortedElements = _arrayList;
    final Comparator<TemplateSignature> _function = new Comparator<TemplateSignature>() {
        public int compare(final TemplateSignature c1, final TemplateSignature c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<TemplateSignature>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<TemplateableElement> getSortedTemplateableElements(final Root root) {
    HashSet<TemplateableElement> _hashSet = new HashSet<TemplateableElement>();
    Set<TemplateableElement> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        boolean _and = false;
        if (!(eObject instanceof TemplateableElement)) {
          _and = false;
        } else {
          List<TemplateBinding> _templateBinding = ((TemplateableElement) eObject).getTemplateBinding();
          int _size = _templateBinding.size();
          boolean _greaterThan = (_size > 0);
          _and = ((eObject instanceof TemplateableElement) && _greaterThan);
        }
        if (_and) {
          allElements.add(((TemplateableElement) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<TemplateableElement> _arrayList = new ArrayList<TemplateableElement>(allElements);
    List<TemplateableElement> sortedElements = _arrayList;
    final Comparator<TemplateableElement> _function = new Comparator<TemplateableElement>() {
        public int compare(final TemplateableElement c1, final TemplateableElement c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<TemplateableElement>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Property> getSortedTupleParts(final TupleType tupleType) {
    List<Property> _ownedAttribute = tupleType.getOwnedAttribute();
    ArrayList<Property> _arrayList = new ArrayList<Property>(_ownedAttribute);
    List<Property> sortedElements = _arrayList;
    final Comparator<Property> _function = new Comparator<Property>() {
        public int compare(final Property c1, final Property c2) {
          int _xblockexpression = (int) 0;
          {
            String n1 = c1.getName();
            String n2 = c2.getName();
            int _compareTo = n1.compareTo(n2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<Property>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<TupleType> getSortedTupleTypes(final Root root) {
    HashSet<TupleType> _hashSet = new HashSet<TupleType>();
    Set<TupleType> allElements = _hashSet;
    TreeIterator<EObject> tit = root.eAllContents();
    boolean _hasNext = tit.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject eObject = tit.next();
        if ((eObject instanceof TupleType)) {
          allElements.add(((TupleType) eObject));
        }
      }
      boolean _hasNext_1 = tit.hasNext();
      _while = _hasNext_1;
    }
    ArrayList<TupleType> _arrayList = new ArrayList<TupleType>(allElements);
    List<TupleType> sortedElements = _arrayList;
    final Comparator<TupleType> _function = new Comparator<TupleType>() {
        public int compare(final TupleType c1, final TupleType c2) {
          int _xblockexpression = (int) 0;
          {
            String m1 = GenerateOCLCommon.this.getMoniker(c1);
            String m2 = GenerateOCLCommon.this.getMoniker(c2);
            int _compareTo = m1.compareTo(m2);
            _xblockexpression = (_compareTo);
          }
          return _xblockexpression;
        }
      };
    Collections.<TupleType>sort(sortedElements, _function);
    return sortedElements;
  }
  
  protected List<Type> getSuperclassesInPackage(final Type type) {
    ArrayList<Type> _arrayList = new ArrayList<Type>();
    List<Type> allElements = _arrayList;
    List<Type> _superClass = type.getSuperClass();
    for (final Type superclass : _superClass) {
      org.eclipse.ocl.examples.pivot.Package _package = superclass.getPackage();
      Root _rootPackage = this.getRootPackage(_package);
      org.eclipse.ocl.examples.pivot.Package _package_1 = type.getPackage();
      Root _rootPackage_1 = this.getRootPackage(_package_1);
      boolean _equals = Objects.equal(_rootPackage, _rootPackage_1);
      if (_equals) {
        allElements.add(superclass);
      }
    }
    return allElements;
  }
  
  protected List<TemplateParameterSubstitution> getTemplateParameterSubstitutions(final TemplateableElement element) {
    ArrayList<TemplateParameterSubstitution> _arrayList = new ArrayList<TemplateParameterSubstitution>();
    List<TemplateParameterSubstitution> allElements = _arrayList;
    List<TemplateBinding> _templateBinding = element.getTemplateBinding();
    for (final TemplateBinding templateBinding : _templateBinding) {
      List<TemplateParameterSubstitution> _parameterSubstitution = templateBinding.getParameterSubstitution();
      allElements.addAll(_parameterSubstitution);
    }
    return allElements;
  }
  
  protected String getSymbolName(final EObject elem) {
    return NameQueries.getSymbolName(elem);
  }
  
  protected Boolean isEcoreConstraint(final Operation operation) {
    List<Parameter> _ownedParameter = operation.getOwnedParameter();
    for (final Parameter p : _ownedParameter) {
      boolean _and = false;
      String _name = p.getName();
      boolean _equals = _name.equals("diagnostics");
      if (!_equals) {
        _and = false;
      } else {
        Type _type = p.getType();
        String _name_1 = _type.getName();
        boolean _equals_1 = _name_1.equals("EDiagnosticChain");
        _and = (_equals && _equals_1);
      }
      if (_and) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
  
  protected String javaName(final NamedElement element) {
    String _name = element.getName();
    return NameQueries.rawEncodeName(_name, Integer.valueOf(0));
  }
  
  protected String javaName(final Object element, final String string) {
    return NameQueries.rawEncodeName(string, Integer.valueOf(0));
  }
  
  protected String javaString(final Comment aComment) {
    String _body = aComment.getBody();
    String _trim = _body.trim();
    return Strings.convertToJavaString(_trim);
  }
  
  protected String javaString(final OpaqueExpression anExpression) {
    List<String> _body = anExpression.getBody();
    String _get = _body.get(0);
    String _trim = _get.trim();
    return Strings.convertToJavaString(_trim);
  }
  
  protected String partialName(final EObject element) {
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof CollectionType) {
        final CollectionType _collectionType = (CollectionType)element;
        Type _elementType = _collectionType.getElementType();
        boolean _equals = Objects.equal(_elementType, null);
        if (_equals) {
          _matched=true;
          return this.javaName(_collectionType);
        }
      }
    }
    if (!_matched) {
      if (element instanceof CollectionType) {
        final CollectionType _collectionType = (CollectionType)element;
        _matched=true;
        String _javaName = this.javaName(_collectionType);
        String _plus = (_javaName + "_");
        Type _elementType = _collectionType.getElementType();
        String _partialName = this.partialName(_elementType);
        return (_plus + _partialName);
      }
    }
    if (!_matched) {
      if (element instanceof LambdaType) {
        final LambdaType _lambdaType = (LambdaType)element;
        Type _contextType = _lambdaType.getContextType();
        boolean _equals = Objects.equal(_contextType, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof LambdaType) {
        final LambdaType _lambdaType = (LambdaType)element;
        _matched=true;
        String _javaName = this.javaName(_lambdaType);
        String _plus = (_javaName + "_");
        Type _contextType = _lambdaType.getContextType();
        String _partialName = this.partialName(_contextType);
        return (_plus + _partialName);
      }
    }
    if (!_matched) {
      if (element instanceof Type) {
        final Type _type = (Type)element;
        TemplateParameter _templateParameter = _type.getTemplateParameter();
        boolean _notEquals = (!Objects.equal(_templateParameter, null));
        if (_notEquals) {
          _matched=true;
          TemplateParameter _templateParameter_1 = _type.getTemplateParameter();
          String _simpleName = this.simpleName(_templateParameter_1);
          String _plus = (_simpleName + "_");
          String _javaName = this.javaName(_type);
          return (_plus + _javaName);
        }
      }
    }
    if (!_matched) {
      if (element instanceof Type) {
        final Type _type = (Type)element;
        List<TemplateBinding> _templateBinding = _type.getTemplateBinding();
        int _size = _templateBinding.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          String _javaName = this.javaName(_type);
          _builder.append(_javaName, "");
          {
            List<TemplateParameterSubstitution> _templateParameterSubstitutions = this.getTemplateParameterSubstitutions(_type);
            for(final TemplateParameterSubstitution tps : _templateParameterSubstitutions) {
              _builder.append("_");
              ParameterableElement _actual = tps.getActual();
              String _simpleName = this.simpleName(_actual);
              _builder.append(_simpleName, "");
            }
          }
          return _builder.toString();
        }
      }
    }
    if (!_matched) {
      if (element instanceof Type) {
        final Type _type = (Type)element;
        _matched=true;
        return this.javaName(_type);
      }
    }
    if (!_matched) {
      if (element instanceof Comment) {
        final Comment _comment = (Comment)element;
        String _body = _comment.getBody();
        boolean _equals = Objects.equal(_body, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof Comment) {
        final Comment _comment = (Comment)element;
        _matched=true;
        String _body = _comment.getBody();
        String _body_1 = _comment.getBody();
        int _length = _body_1.length();
        int _minus = (_length - 1);
        int _min = Math.min(11, _minus);
        String _substring = _body.substring(0, _min);
        return this.javaName(_comment, _substring);
      }
    }
    if (!_matched) {
      if (element instanceof EnumerationLiteral) {
        final EnumerationLiteral _enumerationLiteral = (EnumerationLiteral)element;
        Enumeration _enumeration = _enumerationLiteral.getEnumeration();
        boolean _equals = Objects.equal(_enumeration, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof EnumerationLiteral) {
        final EnumerationLiteral _enumerationLiteral = (EnumerationLiteral)element;
        _matched=true;
        Enumeration _enumeration = _enumerationLiteral.getEnumeration();
        String _partialName = this.partialName(_enumeration);
        String _plus = (_partialName + "_");
        String _javaName = this.javaName(_enumerationLiteral);
        return (_plus + _javaName);
      }
    }
    if (!_matched) {
      if (element instanceof Operation) {
        final Operation _operation = (Operation)element;
        Type _owningType = _operation.getOwningType();
        boolean _equals = Objects.equal(_owningType, null);
        if (_equals) {
          _matched=true;
          String _javaName = this.javaName(_operation);
          return ("null_" + _javaName);
        }
      }
    }
    if (!_matched) {
      if (element instanceof Operation) {
        final Operation _operation = (Operation)element;
        _matched=true;
        Type _owningType = _operation.getOwningType();
        String _partialName = this.partialName(_owningType);
        String _plus = (_partialName + "_");
        String _javaName = this.javaName(_operation);
        return (_plus + _javaName);
      }
    }
    if (!_matched) {
      if (element instanceof org.eclipse.ocl.examples.pivot.Package) {
        final org.eclipse.ocl.examples.pivot.Package _package = (org.eclipse.ocl.examples.pivot.Package)element;
        _matched=true;
        return this.javaName(_package);
      }
    }
    if (!_matched) {
      if (element instanceof Parameter) {
        final Parameter _parameter = (Parameter)element;
        EObject _eContainer = _parameter.eContainer();
        boolean _equals = Objects.equal(_eContainer, null);
        if (_equals) {
          _matched=true;
          String _javaName = this.javaName(_parameter);
          return ("null_" + _javaName);
        }
      }
    }
    if (!_matched) {
      if (element instanceof Parameter) {
        final Parameter _parameter = (Parameter)element;
        _matched=true;
        EObject _eContainer = _parameter.eContainer();
        String _partialName = this.partialName(_eContainer);
        String _plus = (_partialName + "_");
        String _javaName = this.javaName(_parameter);
        return (_plus + _javaName);
      }
    }
    if (!_matched) {
      if (element instanceof Precedence) {
        final Precedence _precedence = (Precedence)element;
        _matched=true;
        return this.javaName(_precedence);
      }
    }
    if (!_matched) {
      if (element instanceof Property) {
        final Property _property = (Property)element;
        Type _owningType = _property.getOwningType();
        boolean _equals = Objects.equal(_owningType, null);
        if (_equals) {
          _matched=true;
          String _javaName = this.javaName(_property);
          return ("null_" + _javaName);
        }
      }
    }
    if (!_matched) {
      if (element instanceof Property) {
        final Property _property = (Property)element;
        _matched=true;
        Type _owningType = _property.getOwningType();
        String _partialName = this.partialName(_owningType);
        String _plus = (_partialName + "_");
        String _javaName = this.javaName(_property);
        return (_plus + _javaName);
      }
    }
    if (!_matched) {
      if (element instanceof TemplateBinding) {
        final TemplateBinding _templateBinding = (TemplateBinding)element;
        TemplateSignature _signature = _templateBinding.getSignature();
        TemplateableElement _template = _signature.getTemplate();
        boolean _equals = Objects.equal(_template, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateBinding) {
        final TemplateBinding _templateBinding = (TemplateBinding)element;
        _matched=true;
        TemplateableElement _boundElement = _templateBinding.getBoundElement();
        return this.partialName(_boundElement);
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameter) {
        final TemplateParameter _templateParameter = (TemplateParameter)element;
        TemplateSignature _signature = _templateParameter.getSignature();
        TemplateableElement _template = _signature.getTemplate();
        boolean _equals = Objects.equal(_template, null);
        if (_equals) {
          _matched=true;
          TemplateSignature _signature_1 = _templateParameter.getSignature();
          String _partialName = this.partialName(_signature_1);
          String _plus = ("[" + _partialName);
          return (_plus + "]");
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameter) {
        final TemplateParameter _templateParameter = (TemplateParameter)element;
        ParameterableElement _parameteredElement = _templateParameter.getParameteredElement();
        boolean _equals = Objects.equal(_parameteredElement, null);
        if (_equals) {
          _matched=true;
          TemplateSignature _signature = _templateParameter.getSignature();
          TemplateableElement _template = _signature.getTemplate();
          return this.partialName(_template);
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameter) {
        final TemplateParameter _templateParameter = (TemplateParameter)element;
        if (true) {
          _matched=true;
          TemplateSignature _signature = _templateParameter.getSignature();
          TemplateableElement _template = _signature.getTemplate();
          return this.partialName(_template);
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameter) {
        final TemplateParameter _templateParameter = (TemplateParameter)element;
        _matched=true;
        TemplateSignature _signature = _templateParameter.getSignature();
        TemplateableElement _template = _signature.getTemplate();
        String _partialName = this.partialName(_template);
        String _plus = (_partialName + "_");
        ParameterableElement _parameteredElement = _templateParameter.getParameteredElement();
        String _simpleName = this.simpleName(_parameteredElement);
        return (_plus + _simpleName);
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameterSubstitution) {
        final TemplateParameterSubstitution _templateParameterSubstitution = (TemplateParameterSubstitution)element;
        TemplateBinding _templateBinding = _templateParameterSubstitution.getTemplateBinding();
        boolean _equals = Objects.equal(_templateBinding, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameterSubstitution) {
        final TemplateParameterSubstitution _templateParameterSubstitution = (TemplateParameterSubstitution)element;
        TemplateBinding _templateBinding = _templateParameterSubstitution.getTemplateBinding();
        TemplateableElement _boundElement = _templateBinding.getBoundElement();
        boolean _equals = Objects.equal(_boundElement, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameterSubstitution) {
        final TemplateParameterSubstitution _templateParameterSubstitution = (TemplateParameterSubstitution)element;
        _matched=true;
        TemplateBinding _templateBinding = _templateParameterSubstitution.getTemplateBinding();
        TemplateableElement _boundElement = _templateBinding.getBoundElement();
        return this.partialName(_boundElement);
      }
    }
    if (!_matched) {
      if (element instanceof TemplateSignature) {
        final TemplateSignature _templateSignature = (TemplateSignature)element;
        TemplateableElement _template = _templateSignature.getTemplate();
        boolean _equals = Objects.equal(_template, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateSignature) {
        final TemplateSignature _templateSignature = (TemplateSignature)element;
        _matched=true;
        TemplateableElement _template = _templateSignature.getTemplate();
        return this.partialName(_template);
      }
    }
    EClass _eClass = element.eClass();
    String _name = _eClass.getName();
    return ("xyzzy" + _name);
  }
  
  protected String simpleName(final EObject element) {
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof TemplateParameter) {
        final TemplateParameter _templateParameter = (TemplateParameter)element;
        TemplateSignature _signature = _templateParameter.getSignature();
        TemplateableElement _template = _signature.getTemplate();
        boolean _equals = Objects.equal(_template, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameter) {
        final TemplateParameter _templateParameter = (TemplateParameter)element;
        _matched=true;
        TemplateSignature _signature = _templateParameter.getSignature();
        TemplateableElement _template = _signature.getTemplate();
        return this.simpleName(_template);
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameterSubstitution) {
        final TemplateParameterSubstitution _templateParameterSubstitution = (TemplateParameterSubstitution)element;
        TemplateBinding _templateBinding = _templateParameterSubstitution.getTemplateBinding();
        boolean _equals = Objects.equal(_templateBinding, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameterSubstitution) {
        final TemplateParameterSubstitution _templateParameterSubstitution = (TemplateParameterSubstitution)element;
        TemplateBinding _templateBinding = _templateParameterSubstitution.getTemplateBinding();
        TemplateableElement _boundElement = _templateBinding.getBoundElement();
        boolean _equals = Objects.equal(_boundElement, null);
        if (_equals) {
          _matched=true;
          return "null";
        }
      }
    }
    if (!_matched) {
      if (element instanceof TemplateParameterSubstitution) {
        final TemplateParameterSubstitution _templateParameterSubstitution = (TemplateParameterSubstitution)element;
        _matched=true;
        TemplateBinding _templateBinding = _templateParameterSubstitution.getTemplateBinding();
        TemplateableElement _boundElement = _templateBinding.getBoundElement();
        return this.simpleName(_boundElement);
      }
    }
    if (!_matched) {
      if (element instanceof Type) {
        final Type _type = (Type)element;
        TemplateParameter _templateParameter = _type.getTemplateParameter();
        boolean _equals = Objects.equal(_templateParameter, null);
        if (_equals) {
          _matched=true;
          return this.javaName(_type);
        }
      }
    }
    if (!_matched) {
      if (element instanceof Type) {
        final Type _type = (Type)element;
        _matched=true;
        TemplateParameter _templateParameter = _type.getTemplateParameter();
        String _simpleName = this.simpleName(_templateParameter);
        String _plus = (_simpleName + "_");
        String _javaName = this.javaName(_type);
        return (_plus + _javaName);
      }
    }
    if (!_matched) {
      if (element instanceof Operation) {
        final Operation _operation = (Operation)element;
        Type _owningType = _operation.getOwningType();
        boolean _equals = Objects.equal(_owningType, null);
        if (_equals) {
          _matched=true;
          String _javaName = this.javaName(_operation);
          return ("null_" + _javaName);
        }
      }
    }
    if (!_matched) {
      if (element instanceof Operation) {
        final Operation _operation = (Operation)element;
        _matched=true;
        Type _owningType = _operation.getOwningType();
        String _simpleName = this.simpleName(_owningType);
        String _plus = (_simpleName + "_");
        String _javaName = this.javaName(_operation);
        return (_plus + _javaName);
      }
    }
    EClass _eClass = element.eClass();
    String _name = _eClass.getName();
    return ("xyzzy" + _name);
  }
}
