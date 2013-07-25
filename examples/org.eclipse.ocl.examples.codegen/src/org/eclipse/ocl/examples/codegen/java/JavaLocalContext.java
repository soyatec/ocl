/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.java;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElementId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGText;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.generator.LocalContext;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;

/**
 * A JavaLocalContext maintains the Java-specific context for generation of coide from a CGOperation.
 */
public abstract class JavaLocalContext extends AbstractJavaContext implements LocalContext
{
	protected final @NonNull JavaGlobalContext globalContext;
	protected final @Nullable JavaLocalContext parentContext;
	protected @NonNull CGElement cgScope;
	protected @NonNull NameManager.Context nameManagerContext;

	private /*LazyNonNull*/ CGText idResolver = null;
	private /*LazyNonNull*/ Set<CGValuedElement> localVariables = null;
	private /*LazyNonNull*/ Map<CGParameter, CGParameter> castParameters = null;
	private /*LazyNonNull*/ CGParameter evaluatorParameter;
	private /*LazyNonNull*/ CGParameter typeIdParameter;
	private /*LazyNonNull*/ CGText standardLibrary;
	private final @NonNull Map<PropertyId, CGExecutorProperty> cgProperties = new HashMap<PropertyId, CGExecutorProperty>();
	private final @NonNull Map<TypeId, CGExecutorType> cgTypes = new HashMap<TypeId, CGExecutorType>();

	public JavaLocalContext(@NonNull JavaGlobalContext globalContext, @NonNull CGElement cgScope) {
		super(globalContext.getCodeGenerator());
		this.globalContext = globalContext;
		this.parentContext = null;
		this.cgScope = cgScope;
		this.nameManagerContext = codeGenerator.getNameManager().createNestedContext();
	}
	
	public JavaLocalContext(@NonNull JavaLocalContext parentContext, @NonNull CGElement cgScope) {
		super(parentContext.getCodeGenerator());
		this.globalContext = parentContext.getGlobalContext();
		this.parentContext = parentContext;
		this.cgScope = cgScope;
		this.nameManagerContext = parentContext.nameManagerContext.createNestedContext();
		if (cgScope instanceof CGIterationCallExp) {
			for (CGIterator cgIterator : ((CGIterationCallExp)cgScope).getIterators()) {
				nameManagerContext.getSymbolName(cgIterator);
			}
		}
	}

	protected void addCastParameter(@NonNull CGParameter cgParameter, @NonNull CGParameter cgCastParameter) {
		assert parentContext != null || !(cgParameter instanceof CGIterator);
		if (castParameters == null) {
			castParameters = new HashMap<CGParameter, CGParameter>();
		}
		castParameters.put(cgParameter, cgCastParameter);
		addDependency(cgCastParameter, cgParameter);
	}

	public void addDependency(@NonNull CGValuedElement cgElement, @NonNull CGValuedElement cgDependency) {
		List<CGValuedElement> dependsOns = cgElement.getDependsOn();
		if (!dependsOns.contains(cgDependency)) {
			dependsOns.add(cgDependency);
		}
	}

	public void addLocalVariable(@NonNull CGValuedElement cgVariable) {
		if (localVariables == null) {
			localVariables = new HashSet<CGValuedElement>();
		}
		localVariables.add(cgVariable);
	}

	public @Nullable CGParameter basicGetCastParameter(@NonNull CGParameter cgParameter) {
		if (cgParameter instanceof CGCastParameter) {
			return cgParameter;
		}
		if (castParameters == null) {
			return null;
		}
		return castParameters.get(cgParameter);
	}

	/**
	 * Return a CGCastParameter for cgParameter, unless the cast would be a redundant cast to Object.
	 */
	protected @NonNull CGParameter createCastParameter(@NonNull CGParameter cgParameter) {
		TypedElement pParameter = (TypedElement) cgParameter.getPivot();
		CGTypeId cgTypeId = analyzer.getTypeId(pParameter.getTypeId());
		ElementId elementId = cgTypeId.getElementId();
		if (elementId == null) { 
			return cgParameter;
		}
		TypeDescriptor unboxedTypeDescriptor = codeGenerator.getTypeDescriptor(elementId, false);
		if (cgParameter.getInit() != null) { 
			return cgParameter;						// Inlined parameters need no cast
		}
		else if (unboxedTypeDescriptor.getJavaClass() == Object.class) { 
			return cgParameter;
		}
		else {
			CGCastParameter cgCastParameter = CGModelFactory.eINSTANCE.createCGCastParameter();
			cgCastParameter.setName(cgParameter.getName());
			cgCastParameter.setPivot(pParameter);
			cgCastParameter.setTypeId(cgTypeId);
			cgCastParameter.setReferredParameter(cgParameter);
			return cgCastParameter;
		}
	}

	protected abstract @NonNull JavaLocalContext createNestedContext(@NonNull CGElement cgScope);

	public @NonNull CGParameter getCastParameter(@NonNull CGParameter cgParameter) {
		if (cgParameter instanceof CGCastParameter) {
			return cgParameter;
		}
		if ((cgParameter instanceof CGIterator) && !(cgParameter.eContainer() instanceof CGBuiltInIterationCallExp)) {	// FIXME more elegant test
			CGParameter cgCastParameter = basicGetCastParameter(cgParameter);
			if (cgCastParameter == null) {
				cgCastParameter = createCastParameter(cgParameter);
				addCastParameter(cgParameter, cgCastParameter);
			}
			return cgCastParameter;
		}
		return cgParameter;
	}

	@SuppressWarnings("null")
	public @NonNull Collection<CGParameter> getCastParameters() {
		if (castParameters != null) {
			return castParameters.values();
		}
		else {
			return Collections.emptyList();
		}
	}

	public @NonNull CGValuedElement getEvaluatorParameter() {
		if (parentContext != null) {
			return parentContext.getEvaluatorParameter();
		}
		CGParameter evaluatorParameter2 = evaluatorParameter;
		if (evaluatorParameter2 == null) {
			evaluatorParameter = evaluatorParameter2 = CGModelFactory.eINSTANCE.createCGParameter();
			setNames(evaluatorParameter2, JavaConstants.EVALUATOR_NAME, JavaConstants.EVALUATOR_TYPE_ID);
		}
		return evaluatorParameter2;
	}

	public @NonNull CGExecutorProperty getExecutorProperty(@NonNull Property pivotProperty) {
		PropertyId propertyId = pivotProperty.getPropertyId();
		CGExecutorProperty cgProperty = cgProperties.get(propertyId);
		if (cgProperty == null) {
			cgProperty = CGModelFactory.eINSTANCE.createCGExecutorNavigationProperty();
			CGElementId cgPropertyId = analyzer.getElementId(propertyId);
//			cgProperty.setUnderlyingTypeId(cgTypeId);
			cgProperty.setPivot(pivotProperty);
			cgProperty.setName(analyzer.getNameManager().getGlobalSymbolName(pivotProperty));
			cgProperty.setValueName(cgProperty.getName());
			cgProperties.put(propertyId, cgProperty);
			cgProperty.getDependsOn().add(cgPropertyId);
		}
		return cgProperty;
	}

	public @NonNull CGExecutorType getExecutorType(@NonNull Type pivotType) {
		TypeId typeId = pivotType.getTypeId();
		CGExecutorType cgType = cgTypes.get(typeId);
		if (cgType == null) {
			cgType = CGModelFactory.eINSTANCE.createCGExecutorType();
			CGTypeId cgTypeId = analyzer.getTypeId(typeId);
			cgType.setUnderlyingTypeId(cgTypeId);
			cgType.setPivot(pivotType);
			cgType.setName(analyzer.getNameManager().getGlobalSymbolName(pivotType));
			cgType.setValueName(cgType.getName());
			cgTypes.put(typeId, cgType);
			cgType.getDependsOn().add(cgTypeId);
		}
		return cgType;
	}

	public @NonNull CGExecutorType getExecutorType(@NonNull TypeId typeId) {
		return DomainUtil.nonNullState(cgTypes.get(typeId));
	}

/*	public @NonNull CGValuedElement getFinalVariable(@NonNull CGValuedElement cgExpression) {
		CGValuedElement variableValue = cgExpression.getValue();
		if (variableValue == null) {
			CGFinalVariable finalVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
			String name = nameManagerContext.getSymbolName(cgExpression);
			finalVariable.setName(name);
			finalVariable.setValueName(name);
			finalVariable.setTypeId(cgExpression.getTypeId());
			cgExpression.setVariableValue(finalVariable);
			variableValue = finalVariable;
		}
		return variableValue;
	} */

	public @NonNull JavaGlobalContext getGlobalContext() {
		return globalContext;
	}
	
	public @NonNull CGValuedElement getIdResolverVariable() {
		if (parentContext != null) {
			return parentContext.getIdResolverVariable();
		}
		CGText idResolver2 = idResolver;
		if (idResolver2 == null) {
			CGValuedElement evaluatorParameter = getEvaluatorParameter();
			idResolver = idResolver2 = CGModelFactory.eINSTANCE.createCGText();
			setNames(idResolver2, JavaConstants.ID_RESOLVER_NAME, JavaConstants.ID_RESOLVER_TYPE_ID);
			idResolver2.setTextValue(evaluatorParameter.getValueName() + ".getIdResolver()");
			addDependency(idResolver2, evaluatorParameter);
			addLocalVariable(idResolver2);
		}
		return idResolver2;
	}

/*	public @NonNull CGVariable getLocalVariable(@NonNull CGExpression cgExpression) {
		CGVariable variableValue = (CGVariable) cgExpression.getValue();
		if (variableValue == null) {
			variableValue = CGModelFactory.eINSTANCE.createCGLocalVariable();
			setNames(variableValue, cgExpression);
			variableValue.setTypeId(cgExpression.getTypeId());
			cgExpression.setVariableValue(variableValue);
		}
		return variableValue;
	} */

//	public Collection<? extends CGType> getLocalTypes() {
//		return localTypes;
//	}

	public Collection<? extends CGValuedElement> getLocalVariables() {
		return localVariables;
	}

	public @NonNull JavaLocalContext getOuterContext() {
		return parentContext != null ? parentContext.getOuterContext() : this;
	}

/*	public @NonNull CGParameter getSelfParameter() {
		CGParameter selfParameter2 = selfParameter;
		if (selfParameter2 == null) {
			selfParameter = selfParameter2 = CGModelFactory.eINSTANCE.createCGParameter();
			setNames(selfParameter2, CodeGenAnalyzer.SELF_NAME);
			selfParameter2.setTypeId(analyzer.getTypeId(CodeGenAnalyzer.SELF_TYPE_ID));
			selfParameter2.setNonInvalid();
			selfParameter2.setNonNull();
		}
		return selfParameter2;
	} */
	
	public @NonNull NameManager.Context getNameManagerContext() {
		return nameManagerContext;
	}

	public @NonNull CGText getStandardLibraryVariable() {
		if (parentContext != null) {
			return parentContext.getStandardLibraryVariable();
		}
		CGText standardLibrary2 = standardLibrary;
		if (standardLibrary2 == null) {
			CGValuedElement idResolverVariable = getIdResolverVariable();
			standardLibrary = standardLibrary2 = CGModelFactory.eINSTANCE.createCGText();
			setNames(standardLibrary2, JavaConstants.STANDARD_LIBRARY_NAME, JavaConstants.STANDARD_LIBRARY_TYPE_ID);
			standardLibrary2.setTextValue(idResolverVariable.getValueName() + ".getStandardLibrary()");
			addDependency(standardLibrary2, idResolverVariable);
			addLocalVariable(standardLibrary2);
			addDependency(standardLibrary2, getIdResolverVariable());
		}
		return standardLibrary2;
	}

	public @NonNull CGParameter getTypeIdParameter() {
		if (parentContext != null) {
			return parentContext.getTypeIdParameter();
		}
		CGParameter typeIdParameter2 = typeIdParameter;
		if (typeIdParameter2 == null) {
			typeIdParameter = typeIdParameter2 = CGModelFactory.eINSTANCE.createCGParameter();
			setNames(typeIdParameter2, JavaConstants.TYPE_ID_NAME, JavaConstants.TYPE_ID_TYPE_ID);
		}
		return typeIdParameter2;
	}

/*	public CGTypeWithReflection getTypeWithReflection(CGTypeId cgTypeId) {
		if (localTypes == null) {
			localTypes = new HashMap<TypeId, CGTypeWithReflection>();
		}
		TypeId pivotTypeId = cgTypeId.getPivotTypeId();
		CGTypeWithReflection typeVariable = localTypes.get(pivotTypeId);
		if (typeVariable == null) {
			typeVariable = CGModelFactory.eINSTANCE.createCGTypeWithReflection();
			String name = nameManagerContext.getSymbolName(cgTypeId);
			typeVariable.setName(name);
			typeVariable.setValueName(name);
			typeVariable.setTypeId(analyzer.getTypeId(JavaConstants.DOMAIN_TYPE_ID));
			typeVariable.setUnderlyingTypeId(cgTypeId);
			localTypes.put(pivotTypeId, typeVariable);
			addLocalVariable(typeVariable);
			typeVariable.getDependsOn().add(getIdResolverVariable());
			typeVariable.getDependsOn().add(cgTypeId);
//			typeVariable.setVariableValue(cgType);
		}
		return typeVariable;
	} */

	public @NonNull String getValueName(@NonNull CGValuedElement cgElement) {
		CGValuedElement cgValue = cgElement;
		String valueName = cgElement.getValueName();
		if (valueName != null) {
			return valueName;
		}
/*		if (cgValue != cgValue.getValue()) {
			CGValuedElement cgValue2 = cgValue.getValue();
			String valueName2 = cgElement.getValueName();
			String valueName3 = cgValue.getValueName();
			assert false;
		} */
		assert cgValue == cgValue.getValue();
		cgValue = cgValue.getValue();
		valueName = cgValue.getValueName();
		if (valueName == null) {
			valueName = nameManagerContext.getSymbolName(cgValue, cgValue.getName());
			cgValue.setValueName(valueName);
		}
		return valueName;
	}

	public void setNames(@NonNull CGValuedElement cgValueElement, @NonNull CGValuedElement cgExpression) {
		String name = cgExpression.getName();
		if (name == null) {
			name = nameManagerContext.getSymbolName(cgExpression);
		}
		cgValueElement.setName(name);
		cgValueElement.setValueName(name);
	}

	protected void setNames(@NonNull CGValuedElement cgValueElement, @NonNull String nameHint, @NonNull TypeId typeId) {
		String name = nameManagerContext.getSymbolName(null, nameHint);
		cgValueElement.setName(name);
		cgValueElement.setValueName(name);
		cgValueElement.setTypeId(analyzer.getTypeId(typeId));
		if (cgValueElement instanceof CGVariable) {
			CGVariable cgVariable = (CGVariable)cgValueElement;
			cgVariable.setNonInvalid();
			cgVariable.setNonNull();
		}
	}
}