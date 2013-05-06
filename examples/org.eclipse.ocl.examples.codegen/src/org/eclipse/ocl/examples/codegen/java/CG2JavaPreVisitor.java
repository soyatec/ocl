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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreClassConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElementId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorCompositionProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorNavigationProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositeProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGText;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractExtendingCGModelVisitor;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibrarySimpleOperation;
import org.eclipse.ocl.examples.domain.library.LibraryUntypedOperation;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;

/**
 * A CG2JavaPreVisitor prepares for Java code generation by performing a tree traversal
 * to gather all imports and global constants.
 */
public class CG2JavaPreVisitor extends AbstractExtendingCGModelVisitor<Object, JavaGlobalContext>
{
	protected final @NonNull JavaCodeGenerator codeGenerator;
	protected final @NonNull GenModelHelper genModelHelper;
	protected final @NonNull CodeGenAnalyzer analyzer;
	protected JavaLocalContext localContext;

	public CG2JavaPreVisitor(@NonNull JavaGlobalContext javaContext) {
		super(javaContext);
		this.codeGenerator = javaContext.getCodeGenerator();
		this.analyzer = codeGenerator.getAnalyzer();
		this.genModelHelper = codeGenerator.getGenModelHelper();
	}

	protected void doTypedElement(@NonNull CGTypedElement cgTypedElement) {
		CGTypeId cgTypeId = cgTypedElement.getTypeId();
		if (cgTypeId != null) {
			cgTypeId.accept(this);
		}
	}

	protected void doValuedElement(@NonNull CGValuedElement cgValuedElement) {
		CGValuedElement value = cgValuedElement.getValue();
		if (value.isGlobal()) {
			context.addGlobal(value);
		}
		if (cgValuedElement.getValue() == cgValuedElement) {
			if (localContext != null) {
				localContext.getValueName(cgValuedElement);
			}
			else {
				context.getValueName(cgValuedElement);
			}
		}
	}

	public @NonNull JavaCodeGenerator getCodeGenerator() {
		return codeGenerator;
	}

	protected @NonNull CGText getIdResolverVariable() {
		CGText idResolverVariable = localContext.getIdResolverVariable();
		CGTypeId type = idResolverVariable.getTypeId();
		type.accept(this);
		return idResolverVariable;
	}

	protected @NonNull CGText getStandardLibraryVariable() {
		getIdResolverVariable();
		CGText standardLibraryVariable = localContext.getStandardLibraryVariable();
		CGTypeId type = standardLibraryVariable.getTypeId();
		type.accept(this);
		return standardLibraryVariable;
	}

	public @Nullable Object visiting(@NonNull CGElement visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public @Nullable Object visitCGBoxExp(@NonNull CGBoxExp cgBoxExp) {
		CGValuedElement unboxedValue = cgBoxExp.getSource();
		TypeId typeId = unboxedValue.getPivotTypeId();
		if (typeId != null) {
			Class<?> unboxedClass = codeGenerator.getUnboxedClass(typeId);
			if (Iterable.class.isAssignableFrom(unboxedClass)) {
				getIdResolverVariable();
			}
		}
		return super.visitCGBoxExp(cgBoxExp);
	}

	@Override
	public @Nullable Object visitCGCollectionPart(@NonNull CGCollectionPart cgCollectionPart) {
		boolean isRange = cgCollectionPart.isRange();
		if (cgCollectionPart.isConstant() && isRange) {
			context.addGlobal(cgCollectionPart);
		}
		if (isRange) {
//			context.getFinalVariable(cgCollectionPart);
		}
		return super.visitCGCollectionPart(cgCollectionPart);
	}

	@Override
	public @Nullable Object visitCGConstantExp(@NonNull CGConstantExp cgConstantExp) {
		CGValuedElement referredConstant = cgConstantExp.getReferredConstant();
		if (referredConstant != null) {
			referredConstant.accept(this);
		}
		return super.visitCGConstantExp(cgConstantExp);
	}

	@Override
	public @Nullable Object visitCGConstraint(@NonNull CGConstraint cgConstraint) {
		localContext = context.getLocalContext(cgConstraint);
		try {
			return super.visitCGConstraint(cgConstraint);
		}
		finally {
			localContext = null;
		}
	}

	@Override
	public @Nullable Object visitCGConstructorPart(@NonNull CGConstructorPart cgConstructorPart) {
		PropertyId propertyId = ((ConstructorPart)cgConstructorPart.getPivot()).getReferredProperty().getPropertyId();
		CGExecutorConstructorPart cgExecutorConstructorPart = analyzer.getExecutorConstructorPart(propertyId);
		cgExecutorConstructorPart.accept(this);
		JavaTypeId javaPropertyTypeId = JavaConstants.DOMAIN_PROPERTY_TYPE_ID;
		cgExecutorConstructorPart.setTypeId(analyzer.getTypeId(javaPropertyTypeId));
		localContext.addLocalVariable(cgExecutorConstructorPart);
		cgExecutorConstructorPart.getDependsOn().add(getIdResolverVariable());
		cgConstructorPart.getDependsOn().add(cgExecutorConstructorPart);
		cgConstructorPart.getDependsOn().add(cgConstructorPart.getConstructorExp());
		return super.visitCGConstructorPart(cgConstructorPart);
	}

	@Override
	public @Nullable Object visitCGEcoreClassConstructorExp(@NonNull CGEcoreClassConstructorExp cgConstructorExp) {
		TypeId typeId = ((ConstructorExp)cgConstructorExp.getPivot()).getTypeId();
		CGExecutorType cgExecutorType = localContext.getExecutorType(typeId);
		cgExecutorType.accept(this);
		localContext.getOuterContext().addLocalVariable(cgExecutorType);
		return super.visitCGEcoreClassConstructorExp(cgConstructorExp);
	}

	@Override
	public @Nullable Object visitCGElement(@NonNull CGElement cgElement) {
		for (CGElement cgChild : cgElement.getChildren()) {
			cgChild.accept(this);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorCompositionProperty(@NonNull CGExecutorCompositionProperty cgExecutorProperty) {
		Property pivotProperty = (Property) cgExecutorProperty.getPivot();
		Property pivotOppositeProperty = pivotProperty.getOpposite();
		if ((pivotOppositeProperty != null) && pivotOppositeProperty.isComposite()) {
			JavaTypeId javaPropertyTypeId = JavaConstants.UNBOXED_COMPOSITION_PROPERTY_TYPE_ID;
			cgExecutorProperty.setTypeId(analyzer.getTypeId(javaPropertyTypeId));
		}
		return super.visitCGExecutorCompositionProperty(cgExecutorProperty);
	}

	@Override
	public @Nullable Object visitCGExecutorNavigationProperty(@NonNull CGExecutorNavigationProperty cgExecutorProperty) {
		JavaTypeId javaPropertyTypeId = JavaConstants.UNBOXED_EXPLICIT_NAVIGATION_PROPERTY_TYPE_ID;
		cgExecutorProperty.setTypeId(analyzer.getTypeId(javaPropertyTypeId));
		return super.visitCGExecutorNavigationProperty(cgExecutorProperty);
	}

	@Override
	public @Nullable Object visitCGExecutorOperation(@NonNull CGExecutorOperation cgExecutorOperation) {
		getIdResolverVariable();
		CGElementId cgOperationId = cgExecutorOperation.getUnderlyingOperationId();
		if (cgOperationId != null) {
			cgOperationId.accept(this);
		}
		cgExecutorOperation.getDependsOn().add(getIdResolverVariable());
		return super.visitCGExecutorOperation(cgExecutorOperation);
	}

	@Override
	public @Nullable Object visitCGExecutorOperationCallExp(@NonNull CGExecutorOperationCallExp cgExecutorOperationCallExp) {
		Operation referredOperation = cgExecutorOperationCallExp.getReferredOperation();
		OperationId operationId = referredOperation.getOperationId();
		CGExecutorOperation cgExecutorOperation = analyzer.getExecutorOperation(operationId);
		cgExecutorOperation.accept(this);
		localContext.getOuterContext().addLocalVariable(cgExecutorOperation);
		return super.visitCGExecutorOperationCallExp(cgExecutorOperationCallExp);
	}

	@Override
	public @Nullable Object visitCGExecutorOppositeProperty(@NonNull CGExecutorOppositeProperty cgExecutorProperty) {
		JavaTypeId javaPropertyTypeId = JavaConstants.UNBOXED_OPPOSITE_NAVIGATION_PROPERTY_TYPE_ID;
		cgExecutorProperty.setTypeId(analyzer.getTypeId(javaPropertyTypeId));
		return super.visitCGExecutorOppositeProperty(cgExecutorProperty);
	}

	@Override
	public @Nullable Object visitCGExecutorProperty(@NonNull CGExecutorProperty cgExecutorProperty) {
		CGElementId cgPropertyId = cgExecutorProperty.getUnderlyingPropertyId();
		if (cgPropertyId != null) {
			cgPropertyId.accept(this);
		}
		return super.visitCGExecutorProperty(cgExecutorProperty);
	}

	@Override
	public @Nullable Object visitCGExecutorPropertyCallExp(@NonNull CGExecutorPropertyCallExp cgExecutorPropertyCallExp) {
		Property referredProperty = cgExecutorPropertyCallExp.getReferredProperty();
		PropertyId propertyId = referredProperty.getPropertyId();
		CGExecutorProperty cgExecutorProperty = analyzer.getExecutorProperty(propertyId);
		cgExecutorProperty.accept(this);
		localContext.getOuterContext().addLocalVariable(cgExecutorProperty);
		cgExecutorProperty.getDependsOn().add(getIdResolverVariable());
		return super.visitCGExecutorPropertyCallExp(cgExecutorPropertyCallExp);
	}

	@Override
	public @Nullable Object visitCGExecutorType(@NonNull CGExecutorType cgExecutorType) {
		getIdResolverVariable();
		CGTypeId cgTypeId = cgExecutorType.getUnderlyingTypeId();
		if (cgTypeId != null) {
			cgTypeId.accept(this);
		}
		return super.visitCGExecutorType(cgExecutorType);
	}

	@Override
	public @Nullable Object visitCGIterationCallExp(@NonNull CGIterationCallExp cgIterationCallExp) {
		doValuedElement(cgIterationCallExp);				// Resolve name in outer context
		doTypedElement(cgIterationCallExp);
		CGValuedElement cgSource = cgIterationCallExp.getSource();
		if (cgSource != null) {
			cgSource.accept(this);
		}
		for (CGIterator cgIterator : cgIterationCallExp.getIterators()) {
			CGValuedElement cgInit = cgIterator.getInit();
			if (cgInit != null) {
				cgInit.accept(this);
			}
		}
		JavaLocalContext savedLocalContext = localContext;
		localContext = context.getLocalContext(cgIterationCallExp);
		try {
			CGValuedElement cgBody = cgIterationCallExp.getBody();
			if (cgBody != null) {
				cgBody.accept(this);
			}
			for (CGIterator cgIterator : cgIterationCallExp.getIterators()) {
				cgIterator.accept(this);
			}
			return null;
		}
		finally {
			localContext = savedLocalContext;
		}
	}

	@Override
	public @Nullable Object visitCGLetExp(@NonNull CGLetExp cgLetExp) {
		CGValuedElement in = cgLetExp.getIn();
		if (in != null) {
//			context.getFinalVariable(in);
		}
		return super.visitCGLetExp(cgLetExp);
	}

	@Override
	public @Nullable Object visitCGLibraryIterateCallExp(@NonNull CGLibraryIterateCallExp cgLibraryIterateCallExp) {
		getStandardLibraryVariable();
		return super.visitCGLibraryIterateCallExp(cgLibraryIterateCallExp);
	}

	@Override
	public @Nullable Object visitCGLibraryIterationCallExp(@NonNull CGLibraryIterationCallExp cgLibraryIterationCallExp) {
		getStandardLibraryVariable();
		return super.visitCGLibraryIterationCallExp(cgLibraryIterationCallExp);
	}

	@Override
	public @Nullable Object visitCGLibraryOperationCallExp(@NonNull CGLibraryOperationCallExp cgOperationCallExp) {
		LibraryOperation libraryOperation = cgOperationCallExp.getLibraryOperation();
		try {
			return super.visitCGLibraryOperationCallExp(cgOperationCallExp);
		}
		finally {
			if (!(libraryOperation instanceof LibrarySimpleOperation)) {
				localContext.getEvaluatorParameter();
				if (!(libraryOperation instanceof LibraryUntypedOperation)) {
					context.addGlobal(cgOperationCallExp.getTypeId());
				}
			}
		}
	}

	@Override
	public @Nullable Object visitCGLibraryPropertyCallExp(@NonNull CGLibraryPropertyCallExp cgPropertyCallExp) {
		LibraryProperty libraryProperty = cgPropertyCallExp.getLibraryProperty();
		try {
			return super.visitCGLibraryPropertyCallExp(cgPropertyCallExp);
		}
		finally {
			localContext.getEvaluatorParameter();
//			if (!(libraryOperation instanceof LibraryUntypedOperation)) {
				context.addGlobal(cgPropertyCallExp.getTypeId());
//			}
		}
	}

	@Override
	public @Nullable Object visitCGOperation(@NonNull CGOperation cgOperation) {
		localContext = context.getLocalContext(cgOperation);
		try {
			return super.visitCGOperation(cgOperation);
		}
		finally {
			localContext = null;
		}
	}

	@Override
	public @Nullable Object visitCGProperty(@NonNull CGProperty cgProperty) {
		localContext = context.getLocalContext(cgProperty);
		try {
			return super.visitCGProperty(cgProperty);
		}
		finally {
			localContext = null;
		}
	}

	@Override
	public @Nullable Object visitCGTypeExp(@NonNull CGTypeExp cgTypeExp) {
		CGExecutorType cgType = cgTypeExp.getReferredType();
		if (cgType != null) {
			cgType.accept(this);
		}
		return super.visitCGTypeExp(cgTypeExp);
	}

	@Override
	public @Nullable Object visitCGTypedElement(@NonNull CGTypedElement cgTypedElement) {
		doTypedElement(cgTypedElement);
		return super.visitCGTypedElement(cgTypedElement);
	}

	@Override
	public @Nullable Object visitCGValuedElement(@NonNull CGValuedElement cgValuedElement) {
		super.visitCGValuedElement(cgValuedElement);
		doValuedElement(cgValuedElement);
		return null;
	}

	@Override
	public @Nullable Object visitCGVariableExp(@NonNull CGVariableExp cgVariableExp) {
		CGVariable cgVariable = cgVariableExp.getReferredVariable();
		if (cgVariable != null) {
			cgVariable.accept(this);
			if (cgVariable instanceof CGParameter) {
				CGVariable castParameter = localContext.getCastParameter((CGParameter) cgVariable);
				cgVariableExp.setReferredVariable(castParameter);
				cgVariableExp.getDependsOn().add(castParameter);
			}
		}
		return super.visitCGVariableExp(cgVariableExp);
	}
}
