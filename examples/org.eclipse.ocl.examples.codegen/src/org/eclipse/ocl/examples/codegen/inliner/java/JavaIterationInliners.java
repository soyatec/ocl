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

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.generator.CodeGenLabel;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet.AbstractTextAppender;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.java.JavaSnippet;
import org.eclipse.ocl.examples.codegen.inliner.AbstractInliner;
import org.eclipse.ocl.examples.codegen.inliner.IterationInliner;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.DomainMessage;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.iterator.AnyIteration;
import org.eclipse.ocl.examples.library.iterator.CollectIteration;
import org.eclipse.ocl.examples.library.iterator.CollectNestedIteration;
import org.eclipse.ocl.examples.library.iterator.ExistsIteration;
import org.eclipse.ocl.examples.library.iterator.ForAllIteration;
import org.eclipse.ocl.examples.library.iterator.IsUniqueIteration;
import org.eclipse.ocl.examples.library.iterator.OneIteration;
import org.eclipse.ocl.examples.library.iterator.RejectIteration;
import org.eclipse.ocl.examples.library.iterator.SelectIteration;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;

public class JavaIterationInliners
{
	public JavaIterationInliners(@NonNull JavaCodeGenerator codeGenerator) { // FIXME IterateIteration
		codeGenerator.addInliner(AnyIteration.class, new AnyIterationInliner(codeGenerator));
		codeGenerator.addInliner(CollectIteration.class, new CollectIterationInliner(codeGenerator));
		codeGenerator.addInliner(CollectNestedIteration.class, new CollectNestedIterationInliner(codeGenerator));
		codeGenerator.addInliner(ExistsIteration.class, new ExistsIterationInliner(codeGenerator)); // FIXME exists2
		codeGenerator.addInliner(ForAllIteration.class, new ForAllIterationInliner(codeGenerator)); // FIXME forAll2
		codeGenerator.addInliner(IsUniqueIteration.class, new IsUniqueIterationInliner(codeGenerator));
		codeGenerator.addInliner(OneIteration.class, new OneIterationInliner(codeGenerator));
		codeGenerator.addInliner(RejectIteration.class, new RejectIterationInliner(codeGenerator));
		codeGenerator.addInliner(SelectIteration.class, new SelectIterationInliner(codeGenerator));
	}
	
	public static class IterationInlinerContext
	{
		protected final @NonNull CodeGenerator codeGenerator;
		protected final @NonNull LoopExp element;
		protected final @NonNull OCLExpression source;
		protected final @NonNull CodeGenSnippet sourceSnippet;		
		
		protected final @NonNull Variable iterator;
		protected final @NonNull Class<?> iteratorClass;
		private CodeGenSnippet iteratorSnippet = null;
		protected final @NonNull CodeGenSnippet iteratorValSnippet;
		
		protected final @NonNull OCLExpression body;
		private CodeGenSnippet accumulatorSnippet = null;			
		protected String resultName;
		private CodeGenSnippet bodySnippet = null;
		
		public IterationInlinerContext(@NonNull CodeGenerator codeGenerator, @NonNull LoopExp element) {
			this.codeGenerator = codeGenerator;
			this.element = element;
			this.source = DomainUtil.nonNullModel(element.getSource());
			this.sourceSnippet = codeGenerator.getSnippet(source);
			
			this.iterator = DomainUtil.nonNullModel(element.getIterator().get(0));
			this.iteratorClass = codeGenerator.getBoxedClass(iterator.getTypeId());

			this.body = DomainUtil.nonNullModel(element.getBody());
			this.iteratorValSnippet = new JavaSnippet(sourceSnippet.getName() + "_iterator", null, Iterator.class, codeGenerator, "",
				CodeGenSnippet.NON_NULL /*| CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS*/ /*| CodeGenSnippet.THROWN*/ | CodeGenSnippet.UNBOXED);
		}

		public @NonNull CodeGenSnippet getAccumulatorSnippet() {
			return DomainUtil.nonNullState(accumulatorSnippet);
		}

		public @NonNull OCLExpression getBody() {
			return body;
		}

		public @NonNull Class<?> getBodyClass() {
			return getBodySnippet().getJavaClass();
		}

		public @NonNull CodeGenSnippet getBodySnippet() {
			return DomainUtil.nonNullState(bodySnippet);
		}

		public @NonNull Variable getIterator() {
			return iterator;
		}

		public @NonNull Class<?> getIteratorClass() {
			return iteratorClass;
		}

		public @NonNull CodeGenSnippet getIteratorSnippet() {
			return DomainUtil.nonNullState(iteratorSnippet);
		}

		public @NonNull CodeGenSnippet getIteratorValSnippet() {
			return iteratorValSnippet;
		}

		public @NonNull String getResultName() {
			return DomainUtil.nonNullState(resultName);
		}

		public @NonNull TypeId getResultTypeId() {
			return element.getTypeId();
		}

		public @NonNull CodeGenSnippet getSourceSnippet() {
			return sourceSnippet;
		}

		public @NonNull TypeId getSourceTypeId() {
			return source.getTypeId();
		}

		public void setAccumulatorSnippet(@NonNull CodeGenSnippet accumulatorSnippet) {
			this.accumulatorSnippet = accumulatorSnippet;
		}

		public void setBodySnippet(@NonNull CodeGenSnippet bodySnippet) {
			this.bodySnippet = bodySnippet;
		}

		public void setIteratorSnippet(@NonNull CodeGenSnippet iteratorSnippet) {
			this.iteratorSnippet = iteratorSnippet;
		}

		public void setResultName(@NonNull String resultName) {
			this.resultName = resultName;
		}
	}

	public static abstract class AbstractJavaIterationInliner extends AbstractInliner implements IterationInliner
	{
		public AbstractJavaIterationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}

		protected void appendEvaluateBody(@NonNull CodeGenSnippet snippet, final @NonNull IterationInlinerContext context) {
			CodeGenLabel scopeLabel = codeGenerator.getSnippetLabel(CodeGenerator.SCOPE_ROOT);
			scopeLabel.push(snippet);
			CodeGenText commentText = snippet.append("");
			OCLExpression body = context.getBody();
			commentText.appendCommentWithOCL(null, body);
			CodeGenSnippet bodySnippet = snippet.appendBoxedGuardedChild(body, null, DomainMessage.INVALID); //codeGenerator.getSnippet(body);
			if (bodySnippet != null) {
				context.setBodySnippet(bodySnippet);
			}
			snippet.append("/**/\n");
			scopeLabel.pop();
		}

		protected void appendIteratorAdvance(@NonNull CodeGenSnippet snippet, final @NonNull IterationInlinerContext context) {
			CodeGenLabel scopeLabel = codeGenerator.getSnippetLabel(CodeGenerator.SCOPE_ROOT);
			scopeLabel.push(snippet);
			final CodeGenAnalysis analysis = codeGenerator.getAnalysis(context.getIterator());
			int flags = /* CodeGenSnippet.THROWN |*/ CodeGenSnippet.UNBOXED;
			assert !analysis.isCatching();
			CodeGenSnippet iteratorSnippet = new JavaSnippet("", analysis, context.getIteratorClass(), flags);
			codeGenerator.setSnippet(context.getIterator(), iteratorSnippet);
//			codeGenerator.setSnippet(analysis, iteratorSnippet);
			context.setIteratorSnippet(iteratorSnippet);
			iteratorSnippet.appendText("", new AbstractTextAppender()
			{
				@Override
				public void appendToBody(@NonNull CodeGenText text) {
					text.appendReferenceTo(context.getIteratorClass(), context.getIteratorValSnippet());
					text.append(".next()");
				}
			});
			snippet.appendContentsOf(iteratorSnippet);
			scopeLabel.pop();
		}

		protected void appendIteratorGuard(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenLabel scopeLabel = codeGenerator.getSnippetLabel(CodeGenerator.SCOPE_ROOT);
			scopeLabel.push(snippet);
			CodeGenText guardText = snippet.append("if (!");
			guardText.appendReferenceTo(null, context.getIteratorValSnippet());
			guardText.append(".hasNext()) {\n");
				//
				CodeGenSnippet terminalNodes = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
				scopeLabel.push(terminalNodes);
				appendResolveTerminalValue(terminalNodes, context);
				terminalNodes.append("break;\n");
				scopeLabel.pop();
				//
				snippet.append("}\n");
			scopeLabel.pop();
		}

/*		protected void appendNullGuard(@NonNull CodeGenSnippet snippet, @NonNull CodeGenSnippet bodySnippet) {
			if (!bodySnippet.isNonNull()) {
				CodeGenText text = snippet.append("if (");
				text.appendReferenceTo(null, bodySnippet);
				text.append(" == null) { throw new ");
				text.appendClassReference(InvalidValueException.class);
				text.append("(");
				text.appendClassReference(EvaluatorMessages.class);
				text.append(".UndefinedBody, \"" + getName() + "\"); }\n");
			}
		} */

		protected void appendResolveTerminalValue(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {}

		protected void appendUpdateAccumulator(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {}

		protected @Nullable CodeGenSnippet createAccumulatorSnippet(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			return null;
		}
		
		protected abstract @NonNull String getName();

		public @NonNull CodeGenSnippet visitLoopExp(final @NonNull LoopExp element) {
			if (element.getIterator().size() > 1) {
				throw new UnsupportedOperationException();		// Fall-back on non inline implementation
			}
			final IterationInlinerContext context = new IterationInlinerContext(codeGenerator, element);
			final CodeGenAnalysis analysis = codeGenerator.getAnalysis(element);
			Class<?> resultClass = codeGenerator.getBoxedClass(element.getTypeId());
			int flags = CodeGenSnippet.UNASSIGNED | CodeGenSnippet.UNBOXED;
			if (analysis.isNonNull()) {
				flags |= CodeGenSnippet.NON_NULL;
			}
			if (analysis.isCatching()) {
				flags |= CodeGenSnippet.CAUGHT;
			}
			else {
				flags |= /*CodeGenSnippet.FINAL |*/ CodeGenSnippet.THROWN;
			}
			final @NonNull CodeGenSnippet resultSnippet = new JavaSnippet("", analysis, resultClass, flags);
			try {
				final @NonNull String resultName = resultSnippet.getName();
				context.setResultName(resultName);
				return resultSnippet.appendText("", new AbstractTextAppender()
				{
					@Override
					public boolean appendAtHead(@NonNull CodeGenSnippet snippet) {
						DomainMessage nullMessage = new DomainMessage(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_NAME, TypeId.OCL_VOID_NAME);
						OCLExpression source = DomainUtil.nonNullModel(element.getSource());
						final CodeGenSnippet sourceSnippet = snippet.appendBoxedGuardedChild(source, nullMessage, null);
						if (sourceSnippet == null) {
							return false;
						}
						CodeGenSnippet accumulatorSnippet = createAccumulatorSnippet(snippet, context);
						if (accumulatorSnippet != null) {
							context.setAccumulatorSnippet(accumulatorSnippet);
							snippet.appendContentsOf(accumulatorSnippet);
						}
						//
						CodeGenSnippet iteratorValSnippet = context.getIteratorValSnippet();
						iteratorValSnippet.appendText("", new AbstractTextAppender()
						{
							@Override
							public void appendToBody(@NonNull CodeGenText text) {
								text.appendReferenceTo(null, sourceSnippet);
								text.append(".iterator()");
							}
						});
						snippet.appendContentsOf(iteratorValSnippet);
						//
						return true;
					}
	
					@Override
					public void appendAtTail(@NonNull CodeGenSnippet snippet) {
						snippet.append("while (true) {\n");
							//
							appendIteratorGuard(snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED), context);
							appendIteratorAdvance(snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED), context);
							appendEvaluateBody(snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED), context);
							appendUpdateAccumulator(snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED), context);
							//
						snippet.append("}\n");
					}
	
					@Override
					public void appendToBody(@NonNull CodeGenText text) {
						if (!analysis.isCatching()) {
							text.appendDeclaration(resultSnippet);
						}
					}
				});
			}
			catch (RuntimeException e) {
				resultSnippet.dispose();	// Avoid reuse conflict from retry
				System.out.println("Abandoning iteration inlining: " + e);
				throw e;
			}
		}
	}
	
	public static abstract class AbstractAccumulatingIterationInliner extends AbstractJavaIterationInliner
	{
		public AbstractAccumulatingIterationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}

		@Override
		protected void appendResolveTerminalValue(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenText text = snippet.append("");
			text.append(context.getResultName());
			text.append(" = ");
			text.appendReferenceTo(null, context.getAccumulatorSnippet());
			text.append(";\n");
		}

		@Override
		protected @NonNull CodeGenSnippet createAccumulatorSnippet(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			final CollectionTypeId collectionTypeId = getAccumulatorTypeId(context);
			final CodeGenSnippet sourceSnippet = context.getSourceSnippet();
			Class<? extends CollectionValue.Accumulator> accumulatorClass = CollectionValue.Accumulator.class;
			CollectionTypeId collectionId = collectionTypeId.getGeneralizedId();
			if (collectionId == TypeId.BAG) {
				accumulatorClass = BagValue.Accumulator.class;
			}
			else if (collectionId == TypeId.ORDERED_SET) {
				accumulatorClass = OrderedSetValue.Accumulator.class;
			}
			else if (collectionId == TypeId.SEQUENCE) {
				accumulatorClass = SequenceValue.Accumulator.class;
			}
			else if (collectionId == TypeId.SET) {
				accumulatorClass = SetValue.Accumulator.class;
			}
			else {
				accumulatorClass = CollectionValue.Accumulator.class;
			}
			CodeGenSnippet accumulatorSnippet = new JavaSnippet(sourceSnippet.getName() + "_accumulator", collectionTypeId, accumulatorClass, codeGenerator, "",
				CodeGenSnippet.BOXED | CodeGenSnippet.MUTABLE | CodeGenSnippet.NON_NULL | CodeGenSnippet.THROWN);
			return accumulatorSnippet.appendText("", new AbstractTextAppender()
				{
					@Override
					public void appendToBody(@NonNull CodeGenText text) {
						CollectionTypeId generalizedId = collectionTypeId.getGeneralizedId();
						text.append("create" + generalizedId.getName() + "AccumulatorValue(");
						text.appendReferenceTo(collectionTypeId);
						text.append(")");
					}
				});
		}

		protected @NonNull CollectionTypeId getAccumulatorTypeId(@NonNull IterationInlinerContext context) {
			return (CollectionTypeId) context.getResultTypeId();
		}
	}
	
	public static class AnyIterationInliner extends AbstractJavaIterationInliner
	{
		public AnyIterationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	

		@Override
		protected void appendResolveTerminalValue(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenText text = snippet.append("");
			text.append(context.getResultName());
			text.append(" = null;\n");
		}

		@Override
		protected void appendUpdateAccumulator(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenText ifText = snippet.append("if (");
			ifText.appendReferenceTo(null, context.getBodySnippet());
			ifText.append(" != ");
			ifText.appendClassReference(ValuesUtil.class);
			ifText.append(".FALSE_VALUE) {			// Carry on till something found\n");
				//
				CodeGenSnippet innerNodes = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
				innerNodes.appendNullGuard(context.getBodySnippet(), DomainMessage.NULL);
				CodeGenText text = innerNodes.append("");
				text.append(context.getResultName());
				text.append(" = ");
				text.appendReferenceTo(null, codeGenerator.getSnippet(context.getIterator()));
				text.append(";\n");
				text.append("break;\n");
				//
			snippet.append("}\n");
		}
		
		@Override
		public @NonNull String getName() { return "any"; }
	}

	public static class CollectIterationInliner extends AbstractAccumulatingIterationInliner
	{
		public CollectIterationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	

		@Override
		protected void appendUpdateAccumulator(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenSnippet bodySnippet = context.getBodySnippet();
			CodeGenSnippet boxedBodySnippet = bodySnippet.getBoxedSnippet();
			if (boxedBodySnippet != bodySnippet) {
				snippet.appendContentsOf(boxedBodySnippet);
			}
			if (CollectionValue.class.isAssignableFrom(boxedBodySnippet.getJavaClass())) {
				CodeGenText loopText = snippet.append("for (Object value : ");
				loopText.appendReferenceTo(null, boxedBodySnippet);
				loopText.append(".flatten().getElements()) {\n");
				{
					CodeGenSnippet elementNodes = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
					CodeGenText text = elementNodes.append("");
					text.appendReferenceTo(null, context.getAccumulatorSnippet());
					text.append(".add(value);\n");
				}
				snippet.append("}\n");
			}
			else if (boxedBodySnippet.getJavaClass().isAssignableFrom(CollectionValue.class)) {
				CodeGenText ifText = snippet.append("if (");
				ifText.appendReferenceTo(null, boxedBodySnippet);
				ifText.append(" instanceof ");
				ifText.appendClassReference(CollectionValue.class);
				ifText.append(") {\n");
				{
					CodeGenSnippet thenNodes = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
					CodeGenText loopText = thenNodes.append("for (Object value : ((");
					loopText.appendClassReference(CollectionValue.class);
					loopText.append(")");
					loopText.appendReferenceTo(null, boxedBodySnippet);
					loopText.append(").flatten().getElements()) {\n");
					{
						CodeGenSnippet elementNodes = thenNodes.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
						CodeGenText text = elementNodes.append("");
						text.appendReferenceTo(null, context.getAccumulatorSnippet());
						text.append(".add(value);\n");
					}
					thenNodes.append("}\n");
				}
				snippet.append("}\n");
				snippet.append("else {\n");
				{
					CodeGenSnippet elseNodes = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
					CodeGenText text = elseNodes.append("");
					text.appendReferenceTo(null, context.getAccumulatorSnippet());
					text.append(".add(");
					text.appendReferenceTo(null, boxedBodySnippet);
					text.append(");\n");
				}
				snippet.append("}\n");				
			}
			else {
				CodeGenText text = snippet.append("");
				text.appendReferenceTo(null, context.getAccumulatorSnippet());
				text.append(".add(");
				text.appendReferenceTo(null, boxedBodySnippet);
				text.append(");\n");
			}
		}

		@Override
		public @NonNull String getName() { return "collect"; }
	}

	public static class CollectNestedIterationInliner extends AbstractAccumulatingIterationInliner
	{
		public CollectNestedIterationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	

		@Override
		protected void appendUpdateAccumulator(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenSnippet bodySnippet = context.getBodySnippet();
			CodeGenSnippet boxedBodySnippet = bodySnippet.getBoxedSnippet();
			if (boxedBodySnippet != bodySnippet) {
				snippet.appendContentsOf(boxedBodySnippet);
			}
			CodeGenText text = snippet.append("");
			text.appendReferenceTo(null, context.getAccumulatorSnippet());
			text.append(".add(");
			text.appendReferenceTo(null, boxedBodySnippet);
			text.append(");\n");
		}

		@Override
		public @NonNull String getName() { return "collectNested"; }
	}
	
	public static class ExistsIterationInliner extends AbstractJavaIterationInliner
	{
		public ExistsIterationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	

		@Override
		protected void appendResolveTerminalValue(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenText text = snippet.append("");
			text.append(context.getResultName());
			text.append(" = ");
			text.appendClassReference(ValuesUtil.class);
			text.append(".FALSE_VALUE;\n");
		}

		@Override
		protected void appendUpdateAccumulator(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenText ifText = snippet.append("if (");
			ifText.appendReferenceTo(null, context.getBodySnippet());
			ifText.append(" != ");
			ifText.appendClassReference(ValuesUtil.class);
			ifText.append(".FALSE_VALUE) {			// Carry on till something found\n");
				//
				CodeGenSnippet innerNodes = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
				innerNodes.appendNullGuard(context.getBodySnippet(), DomainMessage.NULL);
				CodeGenText text = innerNodes.append("");
				text.append(context.getResultName());
				text.append(" = ");
				text.appendClassReference(ValuesUtil.class);
				text.append(".TRUE_VALUE;			// Abort after a find\n");
				text.append("break;\n");
				//
			snippet.append("}\n");
		}
		
		@Override
		public @NonNull String getName() { return "exists"; }
	}

	public static class ForAllIterationInliner extends AbstractJavaIterationInliner
	{
		public ForAllIterationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	

		@Override
		protected void appendResolveTerminalValue(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenText text = snippet.append("");
			text.append(context.getResultName());
			text.append(" = ");
			text.appendClassReference(ValuesUtil.class);
			text.append(".TRUE_VALUE;\n");
		}

		@Override
		protected void appendUpdateAccumulator(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenText ifText = snippet.append("if (");
			ifText.appendReferenceTo(null, context.getBodySnippet());
			ifText.append(" != ");
			ifText.appendClassReference(ValuesUtil.class);
			ifText.append(".TRUE_VALUE) {			// Carry unless something not found\n");
				//
				CodeGenSnippet innerNodes = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
				innerNodes.appendNullGuard(context.getBodySnippet(), DomainMessage.NULL);
				CodeGenText text = innerNodes.append("");
				text.append(context.getResultName());
				text.append(" = ");
				text.appendClassReference(ValuesUtil.class);
				text.append(".FALSE_VALUE;			// Abort after a fail\n");
				text.append("break;\n");
				//
			snippet.append("}\n");
		}

		@Override
		public @NonNull String getName() { return "forAll"; }
	}

	public static class IsUniqueIterationInliner extends AbstractAccumulatingIterationInliner
	{
		public IsUniqueIterationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	

		@Override
		protected void appendResolveTerminalValue(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenText text = snippet.append("");
			text.append(context.getResultName());
			text.append(" = ");
			text.appendClassReference(ValuesUtil.class);
			text.append(".TRUE_VALUE;\n");
		}

		@Override
		protected void appendUpdateAccumulator(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenText ifText = snippet.append("if (");
			ifText.appendReferenceTo(null, context.getAccumulatorSnippet());
			ifText.append(".includes(");
			ifText.appendReferenceTo(null, context.getBodySnippet());
			ifText.append(") == ");
			ifText.appendClassReference(ValuesUtil.class);
			ifText.append(".TRUE_VALUE) {\n");
			{
				//
				CodeGenSnippet innerNodes = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
				CodeGenText text = innerNodes.append("");
				text.append(context.getResultName());
				text.append(" = ");
				text.appendClassReference(ValuesUtil.class);
				text.append(".FALSE_VALUE;			// Abort after second find\n");
				text.append("break;\n");
				//
			}
			CodeGenText elseText = snippet.append("}\n");
			elseText.append("else {\n");
			{
				//
				CodeGenSnippet innerNodes = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
				CodeGenText text = innerNodes.append("");
				text.appendReferenceTo(null, context.getAccumulatorSnippet());
				text.append(".add(");
				text.appendReferenceTo(null, context.getBodySnippet());
				text.append(");\n");
				//
			}
			snippet.append("}\n");
		}
	
		@Override
		protected @NonNull CollectionTypeId getAccumulatorTypeId(@NonNull IterationInlinerContext context) {
			return TypeId.SET.getSpecializedId(((CollectionTypeId) context.getSourceTypeId()).getElementTypeId());
		}

		@Override
		public @NonNull String getName() { return "isUnique"; }
	}

	public static class OneIterationInliner extends AbstractAccumulatingIterationInliner
	{
		public OneIterationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	

		@Override
		protected void appendUpdateAccumulator(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			CodeGenText ifText = snippet.append("if (");
			ifText.appendReferenceTo(null, context.getBodySnippet());
			ifText.append(" != ");
			ifText.appendClassReference(ValuesUtil.class);
			ifText.append(".FALSE_VALUE) {			// Carry on till something found\n");
				//
				CodeGenSnippet innerNodes = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
				innerNodes.appendNullGuard(context.getBodySnippet(), DomainMessage.NULL);
				CodeGenText testText = innerNodes.append("if (");
				testText.appendReferenceTo(null, context.getAccumulatorSnippet());
				testText.append(") {\n");
				{
					CodeGenSnippet thenNodes = innerNodes.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
					CodeGenText text = thenNodes.append(context.getResultName());
					text.append(" = ");
					text.appendClassReference(ValuesUtil.class);
					text.append(".FALSE_VALUE;\n");
					text.append("break;\n");
				}
				innerNodes.append("}\n");
				innerNodes.append("else {\n");
				{
					CodeGenSnippet elseNodes = innerNodes.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
					CodeGenText text = elseNodes.append("");
					text.appendReferenceTo(null, context.getAccumulatorSnippet());
					text.append(" = true;\n");
				}
				innerNodes.append("}\n");
				//
			snippet.append("}\n");
		}

		@Override
		protected @NonNull CodeGenSnippet createAccumulatorSnippet(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			final CodeGenSnippet sourceSnippet = context.getSourceSnippet();
			CodeGenSnippet accumulatorSnippet = new JavaSnippet(sourceSnippet.getName() + "_accumulator", TypeId.BOOLEAN, boolean.class, codeGenerator, "",
				CodeGenSnippet.MUTABLE | CodeGenSnippet.NON_NULL | CodeGenSnippet.THROWN | CodeGenSnippet.UNBOXED);
			return accumulatorSnippet.appendText("", new AbstractTextAppender()
				{
					@Override
					public void appendToBody(@NonNull CodeGenText text) {
						text.append("false");
					}
				});
		}

		@Override
		public @NonNull String getName() { return "one"; }
	}

	public static class RejectIterationInliner extends AbstractAccumulatingIterationInliner
	{
		public RejectIterationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	

		@Override
		protected void appendUpdateAccumulator(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			snippet.appendNullGuard(context.getBodySnippet(), DomainMessage.NULL);
			CodeGenText ifText = snippet.append("if (");
			ifText.appendReferenceTo(null, context.getBodySnippet());
			ifText.append(" == ");
			ifText.appendClassReference(ValuesUtil.class);
			ifText.append(".FALSE_VALUE) {\n");
			{
				//
				CodeGenSnippet innerNodes = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
				CodeGenText text = innerNodes.append("");
				text.appendReferenceTo(null, context.getAccumulatorSnippet());
				text.append(".add(");
				text.appendReferenceTo(null, context.getIteratorSnippet());
				text.append(");\n");
				//
			}
			snippet.append("}\n");
		}

		@Override
		public @NonNull String getName() { return "reject"; }
	}

	public static class SelectIterationInliner extends AbstractAccumulatingIterationInliner
	{
		public SelectIterationInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}	

		@Override
		protected void appendUpdateAccumulator(@NonNull CodeGenSnippet snippet, @NonNull IterationInlinerContext context) {
			snippet.appendNullGuard(context.getBodySnippet(), DomainMessage.NULL);
			CodeGenText ifText = snippet.append("if (");
			ifText.appendReferenceTo(null, context.getBodySnippet());
			ifText.append(" == ");
			ifText.appendClassReference(ValuesUtil.class);
			ifText.append(".TRUE_VALUE) {\n");
			{
				//
				CodeGenSnippet innerNodes = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
				CodeGenText text = innerNodes.append("");
				text.appendReferenceTo(null, context.getAccumulatorSnippet());
				text.append(".add(");
				text.appendReferenceTo(null, context.getIteratorSnippet());
				text.append(");\n");
				//
			}
			snippet.append("}\n");
		}

		@Override
		public @NonNull String getName() { return "select"; }
	}
}
