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
package org.eclipse.ocl.examples.codegen.inliner.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet.AbstractTextAppender;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.java.JavaSnippet;
import org.eclipse.ocl.examples.codegen.generator.java.JavaText;
import org.eclipse.ocl.examples.codegen.inliner.OperationInliner;
import org.eclipse.ocl.examples.codegen.inliner.java.JavaInliners.AbstractJavaInliner;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractPolyOperation;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.messages.DomainMessage;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.library.EInvokeOperation;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;

public class JavaOperationInliners
{
	protected final @NonNull Map<OperationId, CodeGenSnippet> operationInstances = new HashMap<OperationId, CodeGenSnippet>();
	
	public JavaOperationInliners(@NonNull JavaCodeGenerator codeGenerator) {
		codeGenerator.addInliner(EInvokeOperation.class, new _EInvokeOperation(codeGenerator));
	}

	public static abstract class AbstractJavaOperationInliner extends AbstractJavaInliner implements OperationInliner
	{
		public AbstractJavaOperationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}

		protected @NonNull CodeGenSnippet createCaughtOperationInstanceCall(@NonNull CodeGenAnalysis analysis, @NonNull OperationCallExp element) {
			Operation referredOperation = DomainUtil.nonNullModel(element.getReferredOperation());
			int flags = CodeGenSnippet.CAUGHT | CodeGenSnippet.ERASED | CodeGenSnippet.MUTABLE | getBoxingFlags();
			if (referredOperation.getType() instanceof CollectionType) {
				flags |= CodeGenSnippet.NON_NULL | CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
			}
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, Object.class, flags);
			//
			CodeGenText decl = snippet.append("");
			decl.appendDeclaration(snippet);
			decl.append(";\n");
			//
			decl.append("try {\n");
			//
			//	Assign each source and argument to a Java variable, unless the source/argument is simple enough to be inlineable.
			//
			List<CodeGenSnippet> children = getChildSnippets(snippet, element, false);
			//
//			CodeGenSnippet sourceSnippet = source != null ? snippet.appendBoxedGuardedChild(source, DomainMessage.NULL, DomainMessage.INVALID) : null;
			CodeGenText text = snippet.appendIndentedText(null);
			text.append(snippet.getName());
			text.append(" = ");
			text.appendReferenceTo(null, getOperationInstance(referredOperation));
			text.append(".evaluate(");
			text.appendEvaluatorReference();
			text.append(", ");
			text.appendReferenceTo(element.getTypeId());
			for (CodeGenSnippet child : children) {
				text.append(", ");
				if (child != null) {
					text.appendReferenceTo(null, child);
				}
				else {
					text.append("null");
				}
			}
			text.append(");\n");
			//
			CodeGenText tail = snippet.append("}\n");
			Object exceptionObject = tail;			// A convenient object that would otherwise be nameless
			String exceptionName = codeGenerator.getNameManager().getSymbolName(exceptionObject, "e");
			tail.append("catch (");
			tail.appendClassReference(Exception.class);
			tail.append(" " + exceptionName + ") {\n");
			//
			CodeGenText throwText = snippet.appendIndentedText(null);
			throwText.append(snippet.getName());
			throwText.append(" = ");
			throwText.appendClassReference(ValuesUtil.class);
			throwText.append(".createInvalidValue(" + exceptionName + ");\n");
			//
			snippet.append("}\n");
			return snippet;
		}
		
		protected @NonNull CodeGenSnippet createThrownOperationInstanceCall(@NonNull CodeGenAnalysis analysis, final @NonNull OperationCallExp element) {
			final Operation referredOperation = DomainUtil.nonNullModel(element.getReferredOperation());
			Type returnType = DomainUtil.nonNullModel(referredOperation.getType());
			final OCLExpression source = element.getSource();
			Type elementType = DomainUtil.nonNullModel(element.getType());
			Class<?> knownResultClass = codeGenerator.getUnboxedClass(elementType);
			final Class<?> computedResultClass = codeGenerator.getUnboxedClass(returnType);
			int flags = CodeGenSnippet.THROWN | getBoxingFlags();
			if (!knownResultClass.isAssignableFrom(computedResultClass)) {		// e.g return is a templated type that is statically known
				flags |= CodeGenSnippet.ERASED;
			}
			if (referredOperation.getType() instanceof CollectionType) {
				flags |= CodeGenSnippet.NON_NULL | CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
			}
			if (referredOperation.isRequired()) {
				flags |= CodeGenSnippet.NON_NULL;
			}
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, computedResultClass, flags);
			//
			//	Assign each source and argument to a Java variable, unless the source/argument is simple enough to be inlineable.
			//
			final List<CodeGenSnippet> children = getChildSnippets(snippet, element, false);
			final Class<?> returnClass = getReturnClass(referredOperation);
			//
			return snippet.appendText("", new AbstractTextAppender()
			{
				@Override
				public void appendToBody(@NonNull CodeGenText text) {
					text.appendResultCast(returnClass, computedResultClass, "");
					text.appendReferenceTo(null, getOperationInstance(referredOperation));
					text.append(".evaluate(");
					text.appendEvaluatorReference();
					text.append(", ");
					text.appendReferenceTo(element.getTypeId());
					for (CodeGenSnippet child : children) {
						text.append(", ");
						if (child != null) {
							text.appendReferenceTo(null, child);
						}
						else {
							text.append("null");
						}
					}
					text.append(")");
				}
			});
		}

		protected @NonNull CodeGenSnippet createGenModelDirectCall(final @NonNull OperationCallExp element) throws GenModelException {
			final OCLExpression source = element.getSource();
			final CodeGenSnippet sourceSnippet = codeGenerator.getSnippet(source, false, false);
			if (sourceSnippet.isNull()) {
				final @NonNull CodeGenSnippet throwSnippet = new JavaSnippet("", codeGenerator, TypeId.OCL_INVALID, Throwable.class, element,
					CodeGenSnippet.INLINE | CodeGenSnippet.INVALID | CodeGenSnippet.THROWN);
				CodeGenText text = throwSnippet.append("throw new ");
				text.appendClassReference(InvalidValueException.class);
				text.append("(\"Null source for operation: ");
				PrettyPrintOptions.Global createOptions = JavaText.createOptions(element);
				text.append(PrettyPrinter.print(element, createOptions));
				text.append("\");\n");
				return throwSnippet;
			}
			CodeGenAnalysis analysis = codeGenerator.getAnalysis(element);
			Operation referredOperation = DomainUtil.nonNullModel(element.getReferredOperation());
			Type returnType = DomainUtil.nonNullModel(referredOperation.getType());
			GenModelHelper genModelHelper = codeGenerator.getGenModelHelper();
			final String getAccessor = genModelHelper.getOperationAccessor(referredOperation);
			Type owningType = DomainUtil.nonNullModel(referredOperation.getOwningType());
			final Class<?> requiredClass = genModelHelper.getEcoreInterfaceClass(owningType);
			final Class<?> leastDerivedClass = getLeastDerivedClass(requiredClass, getAccessor);
			Method leastDerivedMethod = getLeastDerivedMethod(requiredClass, getAccessor);
			Class<?> returnClass = leastDerivedMethod != null ? leastDerivedMethod.getReturnType() : genModelHelper.getEcoreInterfaceClass(returnType);
			int flags = CodeGenSnippet.ERASED | CodeGenSnippet.UNBOXED;
			if (EObject.class.isAssignableFrom(requiredClass) && !(returnType instanceof DataType)) {	// FIXME Generalize ?? PrimitiveTypes half and half
				flags |= CodeGenSnippet.BOXED;
			}
			if (analysis.isCatching()) {
				flags |= CodeGenSnippet.CAUGHT | CodeGenSnippet.MUTABLE;
			}
			else {
				flags |= CodeGenSnippet.THROWN;
			}
			if (Iterable.class.isAssignableFrom(returnClass)) {
				flags |= CodeGenSnippet.NON_NULL;
				if (codeGenerator.getOptions().suppressNonNullWarningsForEMFCollections()) {
					flags |= CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
				}
			}
			final List<OCLExpression> arguments = DomainUtil.nonNullEMF(element.getArgument());
			final List<CodeGenSnippet> children = new ArrayList<CodeGenSnippet>();
			@NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, returnClass !=  null ? returnClass : Object.class, flags);
			return snippet.appendText("", new AbstractTextAppender()
			{			
				@Override
				public boolean appendAtHead(@NonNull CodeGenSnippet snippet) {
/*					if (!sourceSnippet.isNonNull()) {
						CodeGenText ifText = snippet.append("if (");
						ifText.appendReferenceTo(null, sourceSnippet);
						ifText.append(" == null) throw new ");
						ifText.appendClassReference(InvalidValueException.class);
						ifText.append("(\"Null source for property: ");
						PrettyPrintOptions.Global createOptions = PivotQueries.createOptions(element);
						ifText.append(PrettyPrinter.print(element, createOptions));
						ifText.append("\");\n");
					}
//					if (!isValidating) {
						snippet.appendInvalidGuard(sourceSnippet);
//					} */
					snippet.appendUnboxedGuardedChild(source, DomainMessage.NULL, DomainMessage.INVALID);
					for (/*@NonNull*/ OCLExpression argument : arguments) {
						if (argument == null) {
							children.add(null);
						}
						else {
							CodeGenSnippet child = snippet.appendUnboxedGuardedChild(argument, null, DomainMessage.INVALID);
//							if ((child != null) && !child.isLocal()) {
//								Object constantValue = child.getConstantValue();
//								if (constantValue instanceof CollectionTypeId) {
//									System.out.println("Got it");
//								}
//							}
//							System.out.println("Arg: " + child);
							children.add(child);
						}
					}
					return true;
				}

				@Override
				public void appendToBody(@NonNull CodeGenText text) {
					CodeGenSnippet sourceSnippet = codeGenerator.getSnippet(source, false, false);
					text.appendAtomicReferenceTo(leastDerivedClass != null ? leastDerivedClass : requiredClass, sourceSnippet);
					text.append(".");
					text.append(getAccessor);
					text.append("(");
					for (int i = 0; i < children.size(); i++) {
						if (i > 0) {
							text.append(", " );
						}
						CodeGenSnippet child = children.get(i);
						if (child == null) {
							text.append("null");
						}
						else {
							OCLExpression argument = arguments.get(i);
							Type type = argument.getType();
							Class<?> argumentClass;
							try {
								argumentClass = codeGenerator.getGenModelHelper().getEcoreInterfaceClass(type);
							} catch (GenModelException e) {
								argumentClass = null;
							}
							text.appendReferenceTo(argumentClass, child);
						}
					}
					text.append(")");
				}
			});
		}

		protected int getBoxingFlags() {
			return CodeGenSnippet.BOXED;
		}

		protected List<CodeGenSnippet> getChildSnippets(CodeGenSnippet snippet, @NonNull OperationCallExp callExp, boolean isValidating) {
			OCLExpression source = callExp.getSource();
			List<OCLExpression> arguments = callExp.getArgument();
			List<CodeGenSnippet> children = new ArrayList<CodeGenSnippet>();
			children.add(source != null ? snippet.appendBoxedGuardedChild(source, null, isValidating ? null : DomainMessage.INVALID) : null);
			for (/*@NonNull*/ OCLExpression argument : arguments) {
				if (argument == null) {
					children.add(null);
				}
				else {
					CodeGenSnippet child = snippet.appendBoxedGuardedChild(argument, null, isValidating ? null : DomainMessage.INVALID);
					children.add(child);
				}
			}
			return children;
		}

		protected abstract @NonNull CodeGenSnippet getOperationInstance(@NonNull Operation referredOperation);

		protected @Nullable Class<?> getReturnClass(@NonNull Operation referredOperation) {		// FIXME share
			try {
				LibraryFeature implementation = codeGenerator.getMetaModelManager().getImplementation(referredOperation);
				@SuppressWarnings("null") @NonNull Class<? extends LibraryFeature> implementationClass = implementation.getClass();
				Method method = implementationClass.getMethod("evaluate", DomainEvaluator.class, TypeId.class, Object.class);
				return method.getReturnType();
			} catch (Exception e) {
				return null;
			}
		}
		
		public @NonNull CodeGenSnippet visitOperationCallExp(@NonNull OperationCallExp element) {
			try {
				return createGenModelDirectCall(element);
			} catch (GenModelException e) {
				CodeGenAnalysis analysis = codeGenerator.getAnalysis(element);
				boolean isCatching = analysis.isCatching();
				if (isCatching) {
					return createCaughtOperationInstanceCall(analysis, element);
				}
				else {
					return createThrownOperationInstanceCall(analysis, element);
				}
			}
		}
	}
	
	public static class UnboxedInvocationOperation extends AbstractPolyOperation
	{
		protected @NonNull OperationId operationId;
		private EOperation eOperation = null;
		
		public UnboxedInvocationOperation(@NonNull OperationId operationId) {
			this.operationId = operationId;
			// FIXME static attempt at eFeature
		}

		@Nullable
		public Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue, Object... argumentValues)  {
			assert sourceValue != null;
			EObject eObject = (EObject)sourceValue; 
			EOperation eOperation2 = eOperation;
			if (eOperation2 == null) {
				eOperation = eOperation2 = getEOperation(eObject);
			}
			EList<Object> args = new BasicEList<Object>();
			for (Object argumentValue : argumentValues) {
				args.add(argumentValue);
			}
			try {
				return eObject.eInvoke(eOperation2, args);
			} catch (InvocationTargetException e) {
				throw new InvalidValueException(e, "Null Operation");
			}
		}
		
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
			assert sourceValue != null;
			EObject eObject = (EObject)sourceValue; 
			EOperation eOperation2 = eOperation;
			if (eOperation2 == null) {
				eOperation = eOperation2 = getEOperation(eObject);
			}
			EList<Object> args = new BasicEList<Object>();
			args.add(sourceValue);
			try {
				return eObject.eInvoke(eOperation2, args);
			} catch (InvocationTargetException e) {
				throw new InvalidValueException(e, "Null Operation");
			}
		}

		@Nullable
		public Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
			assert sourceValue != null;
			EObject eObject = (EObject)sourceValue; 
			EOperation eOperation2 = eOperation;
			if (eOperation2 == null) {
				eOperation = eOperation2 = getEOperation(eObject);
			}
			EList<Object> args = new BasicEList<Object>();
			args.add(argumentValue);
			try {
				return eObject.eInvoke(eOperation2, args);
			} catch (InvocationTargetException e) {
				throw new InvalidValueException(e, "Null Operation");
			}
		}

		@Nullable
		public Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
			assert sourceValue != null;
			EObject eObject = (EObject)sourceValue; 
			EOperation eOperation2 = eOperation;
			if (eOperation2 == null) {
				eOperation = eOperation2 = getEOperation(eObject);
			}
			EList<Object> args = new BasicEList<Object>();
			args.add(firstArgumentValue);
			args.add(secondArgumentValue);
			try {
				return eObject.eInvoke(eOperation2, args);
			} catch (InvocationTargetException e) {
				throw new InvalidValueException(e, "Null Operation");
			}
		}

		protected @NonNull EOperation getEOperation(EObject eObject) {
			EClass eClass = eObject.eClass();
			for (EOperation eOperation : eClass.getEAllOperations()) {
				if (operationId.getName().equals(eOperation.getName())) {
					return eOperation;				// FIXME check argument lists
				}
			}
			throw new InvalidValueException("No such operation", operationId);
		}
	}

	public class _EInvokeOperation extends AbstractJavaOperationInliner
	{
		public _EInvokeOperation(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	
		
		@Override
		public @NonNull CodeGenSnippet getOperationInstance(@NonNull Operation referredOperation) {
			OperationId operationId = referredOperation.getOperationId();
			CodeGenSnippet snippet = operationInstances.get(operationId);
			if (snippet == null) {
				final CodeGenSnippet operationIdSnippet = codeGenerator.getSnippet(operationId);
				int flags = operationIdSnippet.getFlags() | CodeGenSnippet.BOXED | CodeGenSnippet.ERASED | CodeGenSnippet.NON_NULL | CodeGenSnippet.UNBOXED;
//				snippet = new JavaSnippet((JavaSnippet)propertyIdSnippet, "IMP_", UnboxedCompositionOperation.class, flags, 0);
				snippet = new JavaSnippet("IMP_"+operationIdSnippet.getName(), operationIdSnippet.getTypeId(), UnboxedInvocationOperation.class, operationId, codeGenerator, "", flags);
				snippet = snippet.appendText("", new AbstractTextAppender()
				{			
					@Override
					public void appendToBody(@NonNull CodeGenText text) {
						text.append("new ");
						text.appendClassReference(UnboxedInvocationOperation.class);
						text.append("(");
						text.appendReferenceTo(null, operationIdSnippet);
						text.append(")");
					}
				});
				operationInstances.put(operationId, snippet);
			}
			return snippet;
		}
	}
	
}
