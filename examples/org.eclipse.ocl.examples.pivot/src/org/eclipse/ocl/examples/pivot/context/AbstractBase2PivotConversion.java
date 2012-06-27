/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.pivot.context;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * AbstractBase2PivotConversion provides the Xtext independent support for Concrete Syntax
 * to Pivot conversion.
 */
public abstract class AbstractBase2PivotConversion extends AbstractConversion implements Base2PivotConversion
{
	/**
	 * Set of all expression nodes whose type involves an UnspecifiedType. These are
	 * created during the left2right pass and are finally resolved to
	 * minimize invalidity.
	 */
	private HashSet<TypedElement> underspecifiedTypedElements = null;

	protected AbstractBase2PivotConversion(MetaModelManager metaModelManager) {
		super(metaModelManager);
	}

	protected void addUnderspecifiedTypedElement(TypedElement pivotElement) {
		if (underspecifiedTypedElements == null) {
			underspecifiedTypedElements  = new HashSet<TypedElement>();
		}
		underspecifiedTypedElements.add(pivotElement);
	}

	public void refreshName(NamedElement pivotNamedElement, String newName) {
		String oldName = pivotNamedElement.getName();
		if ((newName != oldName) && ((newName == null) || !newName.equals(oldName))) {
			pivotNamedElement.setName(newName);
		}
	}

	protected void resolveUnderspecifiedTypes() {
		if (underspecifiedTypedElements != null) {
			for (TypedElement underspecifiedTypedElement : underspecifiedTypedElements) {
				Type underspecifiedType = underspecifiedTypedElement.getType();
				Type resolvedType = resolveUnderspecifiedType(underspecifiedType);
				underspecifiedTypedElement.setType(resolvedType);
			}
		}
	}
	
	protected Type resolveUnderspecifiedType(Type type) {
		if (type instanceof UnspecifiedType) {
			return ((UnspecifiedType)type).getLowerBound();
		}
		if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)type;
			Type resolvedElementType = resolveUnderspecifiedType(collectionType.getElementType());
			return metaModelManager.getCollectionType(collectionType.getName(), resolvedElementType);
		}
		if (type instanceof PrimitiveType) {
			return type;
		}
		if (type instanceof TupleType) {
			TupleType tupleType = (TupleType)type;
			List<Property> resolvedProperties = new ArrayList<Property>();
			for (Property part : ((TupleType)type).getOwnedAttribute()) {
				if (metaModelManager.isUnderspecified(part.getType())) {
					Property prop = PivotFactory.eINSTANCE.createProperty();
					prop.setName(part.getName());
					prop.setType(resolveUnderspecifiedType(part.getType()));
					resolvedProperties.add(part);
				}
				else {
					resolvedProperties.add(part);
				}
			}
			return metaModelManager.getTupleType(tupleType.getName(), resolvedProperties, null);
		}
		if (type instanceof ClassifierType) {
			ClassifierType classifierType = (ClassifierType)type;
			Type resolvedElementType = resolveUnderspecifiedType(classifierType.getInstanceType());
			return metaModelManager.getClassifierType(resolvedElementType);
		}
		throw new UnsupportedOperationException();
//		return null;
	}

	public void setContextVariable(ExpressionInOCL pivotSpecification, String selfVariableName, Type contextType) {
		Variable contextVariable = pivotSpecification.getContextVariable();
		if (contextVariable == null) {
			contextVariable = PivotFactory.eINSTANCE.createVariable();
			pivotSpecification.setContextVariable(contextVariable);
		}
		refreshName(contextVariable, selfVariableName);
		setType(contextVariable, contextType);
	}

	public void setClassifierContext(ExpressionInOCL pivotSpecification, Type contextType) {
		Variable contextVariable = pivotSpecification.getContextVariable();
		if (contextType.eIsProxy()) {
			contextType = null;
		}
		setType(contextVariable, contextType);
	}

	public void setOperationContext(ExpressionInOCL pivotSpecification, Operation contextOperation, String resultName) {
		Variable contextVariable = pivotSpecification.getContextVariable();
//		pivotSpecification.getParameterVariable().clear();
		if ((contextOperation != null) && !contextOperation.eIsProxy()) {
			setType(contextVariable, contextOperation.getOwningType());
			setParameterVariables(pivotSpecification, contextOperation.getOwnedParameter());
		}
		if (resultName != null) {
			setResultVariable(pivotSpecification, contextOperation, resultName);
		}
	}

	public void setParameterVariables(ExpressionInOCL pivotSpecification, List<Parameter> parameters) {
		List<Variable> oldVariables = new ArrayList<Variable>(pivotSpecification.getParameterVariable());
		List<Variable> newVariables = new ArrayList<Variable>();
		for (Parameter parameter : parameters) {
		    String name = parameter.getName();
			Variable param = PivotUtil.getNamedElement(oldVariables, name);
		    if (param != null) {
		    	oldVariables.remove(param);
		    }
		    else {
		    	param = PivotFactory.eINSTANCE.createVariable();
		        param.setName(name);
		    }
			setTypeWithMultiplicity(param, parameter);
		    param.setRepresentedParameter(parameter);
		    newVariables.add(param);
		}
		refreshList(pivotSpecification.getParameterVariable(), newVariables);
	}

	public void setParameterVariables(ExpressionInOCL pivotSpecification, Map<String, Type> parameters) {
		List<Variable> oldVariables = new ArrayList<Variable>(pivotSpecification.getParameterVariable());
		List<Variable> newVariables = new ArrayList<Variable>();
		for (String name : parameters.keySet()) {
		    Type type = parameters.get(name);
			Variable param = PivotUtil.getNamedElement(oldVariables, name);
		    if (param != null) {
		    	oldVariables.remove(param);
		    }
		    else {
		    	param = PivotFactory.eINSTANCE.createVariable();
		        param.setName(name);
		    }
			setType(param, type);
//		    param.setRepresentedParameter(parameter);
		    newVariables.add(param);
		}
		refreshList(pivotSpecification.getParameterVariable(), newVariables);
	}

	public void setPropertyContext(ExpressionInOCL pivotSpecification, Property contextProperty) {
		Variable contextVariable = pivotSpecification.getContextVariable();
		if ((contextProperty != null) && !contextProperty.eIsProxy()) {
			setType(contextVariable, contextProperty.getOwningType());
		}
	}

	public void setResultVariable(ExpressionInOCL pivotSpecification, Operation contextOperation, String resultName) {
		Variable resultVariable = pivotSpecification.getResultVariable();
		if (resultVariable == null) {
			resultVariable = PivotFactory.eINSTANCE.createVariable();
		}
		resultVariable.setName(resultName);
		setTypeWithMultiplicity(resultVariable, contextOperation);
		pivotSpecification.setResultVariable(resultVariable);
	}

	/**
	 * Set the type and so potentially satisfy some TypeOfDependency. This method ensures that
	 * type is not set to null.
	 * 
	 * @param pivotExpression
	 * @param type
	 */
	public void setType(TypedElement pivotElement, Type type) {
	//	PivotUtil.debugObjectUsage("setType ", pivotElement);
	//	PivotUtil.debugObjectUsage(" to ", type);
//		if (type != null) {
//			if (type.eResource() == null) {			// WIP
	//			PivotUtil.debugObjectUsage("setType orphan ", type);
//				assert false;
//			}
//		}
//		if (type == null) {
//			type = metaModelManager.getOclInvalidType();	// FIXME unresolved type with explanation
//		}
		Type primaryType = metaModelManager.getPrimaryType(type);
		if (primaryType != pivotElement.getType()) {
			pivotElement.setType(primaryType);
			if (metaModelManager.isUnderspecified(primaryType)) {
				addUnderspecifiedTypedElement(pivotElement);
			}
		}
		if (primaryType != null) {
			PivotUtil.debugWellContainedness(primaryType);
		}
	}

	public void setTypeWithMultiplicity(TypedElement typedElement, TypedMultiplicityElement typedMultiplicityElement) {
		if ((typedMultiplicityElement != null) && !typedMultiplicityElement.eIsProxy()) {
			Type type = metaModelManager.getTypeWithMultiplicity(typedMultiplicityElement);
			if ((type != null) && !type.eIsProxy()) {
				setType(typedElement, type);
				return;
			}
		}
		setType(typedElement, null);
	}
}