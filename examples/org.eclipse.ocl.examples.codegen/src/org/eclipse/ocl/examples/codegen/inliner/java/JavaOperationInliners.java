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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.common.PivotQueries;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet.AbstractTextAppender;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.GenModelException;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.java.JavaSnippet;
import org.eclipse.ocl.examples.codegen.inliner.OperationInliner;
import org.eclipse.ocl.examples.codegen.inliner.java.JavaInliners.AbstractJavaInliner;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.messages.DomainMessage;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.library.EInvokeOperation;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;

public class JavaOperationInliners
{
	protected final @NonNull Map<PropertyId, CodeGenSnippet> propertyInstances = new HashMap<PropertyId, CodeGenSnippet>();
	
	public JavaOperationInliners(@NonNull JavaCodeGenerator codeGenerator) {
		codeGenerator.addInliner(EInvokeOperation.class, new _EInvokeOperation(codeGenerator));
	}

	public static abstract class AbstractJavaOperationInliner extends AbstractJavaInliner implements OperationInliner
	{
		public AbstractJavaOperationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
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
				PrettyPrintOptions.Global createOptions = PivotQueries.createOptions(element);
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
					boolean isFirst = true;
					for (CodeGenSnippet child : children) {
						if (!isFirst) {
							text.append(", " );
						}
						isFirst = false;
						if (child == null) {
							text.append("null");
						}
						else {
							text.appendReferenceTo(null, child);		// FIXME required type
						}
					}
					text.append(")");
				}
			});
		}

		protected @Nullable Class<?> getReturnClass(@NonNull Property referredProperty) {		// FIXME share
			try {
				LibraryFeature implementation = codeGenerator.getMetaModelManager().getImplementation(referredProperty);
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
				throw new UnsupportedOperationException();
//				if (isCatching) {
//					return createCaughtPropertyInstanceCall(analysis, element);
//				}
//				else {
//					return createThrownPropertyInstanceCall(analysis, element);
//				}
			}
		}
	}

	public class _EInvokeOperation extends AbstractJavaOperationInliner
	{
		public _EInvokeOperation(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	
	}
	
}
