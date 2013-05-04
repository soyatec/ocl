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
package org.eclipse.ocl.examples.codegen.analyzer;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEqualsExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractExtendingCGModelVisitor;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.library.iterator.IterateIteration;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;

/**
 * A BoxingAnalyzer performs a bottom up tree-traversal inserting CGBoxExp or CGUnboxExp wherever a
 * conversion from boxed to unboxed or vice-versa is required. No attempt at optimisation is made,
 * since this can be performed by Common SubExpression Elimination.
 */
public class BoxingAnalyzer extends AbstractExtendingCGModelVisitor<Object, CodeGenAnalyzer>
{
	protected final @NonNull CodeGenerator codeGenerator;
	
	public BoxingAnalyzer(@NonNull CodeGenAnalyzer analyzer) {
		super(analyzer);
		codeGenerator = analyzer.getCodeGenerator();
	}

	protected boolean hasOclVoidOperation(@NonNull OperationId operationId) {
		MetaModelManager metaModelManager = codeGenerator.getMetaModelManager();
		TypeServer typeServer = metaModelManager.getTypeServer(metaModelManager.getOclVoidType());
		DomainOperation memberOperation = typeServer.getMemberOperation(operationId);
		if (memberOperation == null) {
			return false;
		}
		DomainType owningType = memberOperation.getOwningType();
		if (owningType == null) {
			return false;
		}
		TypeServer owningTypeServer = metaModelManager.getTypeServer(owningType);
		return typeServer == owningTypeServer;
	}

	/**
	 * Insert a CGBoxExp between cgParent and cgChild.
	 */
	protected void rewriteAsBoxed(@Nullable CGValuedElement cgChild) {
		if ((cgChild == null) || cgChild.isBoxed()) {
			return;
		}
		CGTypeId cgTypeId = cgChild.getTypeId();
		ElementId elementId = cgTypeId.getElementId();
		if (elementId != null) {
			Class<?> boxedClass = codeGenerator.getBoxedClass(elementId);
			Class<?> unboxedClass = codeGenerator.getUnboxedClass(elementId);
			if (boxedClass == unboxedClass) {
				return;
			}
		}
		CGBoxExp cgBoxExp = CGModelFactory.eINSTANCE.createCGBoxExp();
		CGUtils.wrap(cgBoxExp, cgChild);
	}

	protected void rewriteAsGuarded(@Nullable CGValuedElement cgChild) {
		if ((cgChild == null) || cgChild.isNonNull() /*|| (cgParent instanceof CGGuardExp)*/) {
			return;
		}
		CGGuardExp cgGuardExp = CGModelFactory.eINSTANCE.createCGGuardExp();
		CGUtils.wrap(cgGuardExp, cgChild);
	}

	/**
	 * Insert a CGUnboxExp between cgParent and cgChild.
	 */
	protected void rewriteAsUnboxed(@Nullable CGValuedElement cgChild) {
		if ((cgChild == null) || cgChild.isUnboxed()) {
			return;
		}
		CGTypeId cgTypeId = cgChild.getTypeId();
		ElementId elementId = cgTypeId.getElementId();
		if (elementId != null) {
			Class<?> boxedClass = codeGenerator.getBoxedClass(elementId);
			Class<?> unboxedClass = codeGenerator.getUnboxedClass(elementId);
			if (boxedClass == unboxedClass) {
				return;
			}
		}
		CGUnboxExp cgUnboxExp = CGModelFactory.eINSTANCE.createCGUnboxExp();
		CGUtils.wrap(cgUnboxExp, cgChild);
	}

	@Nullable
	public Object visiting(@NonNull CGElement visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public @Nullable Object visitCGConstructorPart(@NonNull CGConstructorPart cgConstructorPart) {
		rewriteAsUnboxed(cgConstructorPart.getInit());
		return super.visitCGConstructorPart(cgConstructorPart);
	}

	@Override
	public @Nullable Object visitCGEcoreOperationCallExp(@NonNull CGEcoreOperationCallExp cgElement) {
		super.visitCGEcoreOperationCallExp(cgElement);
		CGValuedElement cgSource = cgElement.getSource();
		rewriteAsGuarded(cgSource);
		rewriteAsUnboxed(cgSource);
		List<CGValuedElement> cgArguments = cgElement.getArguments();
		int iMax = cgArguments.size();
		for (int i = 0; i < iMax; i++) {			// Avoid CME from rewrite
			rewriteAsUnboxed(cgArguments.get(i));
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGEqualsExp(@NonNull CGEqualsExp cgElement) {
		super.visitCGEqualsExp(cgElement);
		CGValuedElement cgSource = cgElement.getSource();
		CGValuedElement cgArgument = cgElement.getArgument();
		boolean sourceIsBoxed = cgSource.isBoxed();
		boolean argumentIsBoxed = cgArgument.isBoxed();
		if (sourceIsBoxed != argumentIsBoxed) {				// FIXME also needs-boxing
			if (!sourceIsBoxed) {
				rewriteAsBoxed(cgSource);
			}
			if (!argumentIsBoxed) {
				rewriteAsBoxed(cgArgument);
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorPropertyCallExp(@NonNull CGExecutorPropertyCallExp cgElement) {
		super.visitCGExecutorPropertyCallExp(cgElement);
		rewriteAsUnboxed(cgElement.getSource());
		CGTypedElement cgParent = (CGTypedElement) cgElement.getParent();
		if (cgParent != null) {
			rewriteAsBoxed(cgElement);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGElement(@NonNull CGElement cgElement) {
		for (@SuppressWarnings("null")@NonNull CGElement cgChild : cgElement.getChildren()) {
			cgChild.accept(this);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGIfExp(@NonNull CGIfExp cgElement) {
		super.visitCGIfExp(cgElement);
		rewriteAsGuarded(cgElement.getCondition());
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryIterateCallExp(@NonNull CGLibraryIterateCallExp cgElement) {
		super.visitCGLibraryIterateCallExp(cgElement);
		rewriteAsGuarded(cgElement.getSource());
		rewriteAsBoxed(cgElement.getSource());
		LibraryIteration libraryIteration = cgElement.getLibraryIteration();
		if (!(libraryIteration instanceof IterateIteration)) {
			rewriteAsBoxed(cgElement.getBody());
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryIterationCallExp(@NonNull CGLibraryIterationCallExp cgElement) {
		super.visitCGLibraryIterationCallExp(cgElement);
		rewriteAsGuarded(cgElement.getSource());
		rewriteAsBoxed(cgElement.getSource());
		LibraryIteration libraryIteration = cgElement.getLibraryIteration();
		if (!(libraryIteration instanceof IterateIteration)) {
			rewriteAsBoxed(cgElement.getBody());
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryOperationCallExp(@NonNull CGLibraryOperationCallExp cgElement) {
		super.visitCGLibraryOperationCallExp(cgElement);
//		if (!cgElement.getReferredOperation().isValidating()) {
//			OperationId operationId = cgElement.getReferredOperation().getOperationId();
//			if (!hasOclVoidOperation(operationId)) {
//				guard(cgElement, cgElement.getSource());
//			}
//		}
		rewriteAsBoxed(cgElement.getSource());
		List<CGValuedElement> cgArguments = cgElement.getArguments();
		int iMax = cgArguments.size();
		for (int i = 0; i < iMax; i++) {			// Avoid CME from rewrite
			rewriteAsBoxed(cgArguments.get(i));
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGOperation(@NonNull CGOperation cgElement) {
		super.visitCGOperation(cgElement);
//		if ("isAttribute".equals(cgElement.getName())) {
//			System.out.println("visitCGOperation for " + cgElement.getPivot().toString());
//		}
		if (cgElement.isRequired()) {
			CGValuedElement body = cgElement.getBody();
			if (body != null) {
				rewriteAsGuarded(body);
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGProperty(@NonNull CGProperty cgElement) {
		super.visitCGProperty(cgElement);
		if (cgElement.isRequired()) {
			CGValuedElement body = cgElement.getBody();
			if (body != null) {
				rewriteAsGuarded(body);
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGPropertyCallExp(@NonNull CGPropertyCallExp cgElement) {
		super.visitCGPropertyCallExp(cgElement);
		rewriteAsGuarded(cgElement.getSource());
		return null;
	}
}
