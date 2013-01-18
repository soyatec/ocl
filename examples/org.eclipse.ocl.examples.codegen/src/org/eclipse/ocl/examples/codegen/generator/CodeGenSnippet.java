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
package org.eclipse.ocl.examples.codegen.generator;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.DomainMessage;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCLExpression;

/**
 * A CodeGenSnippet captures the textual contribution of one or more elements to the generated output. Multiple elements may be
 * serviced in the case of common sub-expressions. The elements may be model elements (Element), element identifiers (ElementId)
 * or values (Object) including null.
 * <p>
 * A non-inlined snippet has a symbol name to be used in referring contexts, and contents to be emitted to define the symbol name.
 * The contents may be a concatenation of strings and nested snippets.
 * <p>
 * An inlined snippet has no contents, just a 'symbol name' to be re-used in referring contexts.
 * <p>
 * A static snippet has no meta-model dependencies and so may be emitted as a static Java constant.
 * <p>
 * Snippets may have a Java class type to be used when defining the symbol name and which may be used to eliminate casts
 * in referring contexts.
 * <p>
 * Snippets may depend on other snippets thereby ensuring that the dependencies are emitted to define symbols before
 * they are referenced by this snippet. Nested snippets may also have dependencies.
 * <p>
 * CodeGenSnippet extends IndentingBuilder allowing a line prefix indentation to be pushed and popped. When nested snippets
 * are emitted the indentation of this snippet prefixes each line of the nested snippet.
 */
public interface CodeGenSnippet extends CodeGenNode
{
	//	If boxed and unboxed representations are the same, both BOXED and UNBOXED are set
	static final int BOXED = 1 << 0;		// Snippet describes a boxed type such as CollectionValue rather than List.
	static final int UNBOXED = 1 << 1;		// Snippet describes a unboxed type such as List rather than CollectionValue
	//	If an invalid/exception is impossible, neither CAUGHT nor THROWN are set
	static final int CAUGHT = 1 << 2;		// Snippet propagates invalid values as InvalidValues rather than as thrown exceptions
	static final int THROWN = 1 << 3;		// Snippet propagates invalid values as thrown exceptions rather than as InvalidValues 
	static final int MUTABLE = 1 << 4;		// Snippet may take alternate values (not-final)
	static final int GLOBAL = 1 << 5;		// Snippet is a statically constructed global (constant)
	static final int INLINE = 1 << 6;		// Snippet should be re-used directly at each instantiation site rather than referenced by name
	static final int ERASED = 1 << 7;		// Snippet specifies a more general type than is available by static analysis of template types
	static final int NON_NULL = 1 << 8;		// Snippet cannot be null
	static final int LIVE = 1 << 9;			// Snippet must be emitted
	static final int UNASSIGNED = 1 << 10;	// Snippet is not assigned to a name (not-final, not-mutable)
	static final int INVALID = 1 << 11;		// Snippet is unconditionally invalid THROWN for a throw, CAUGHT for a constant 
	static final int SYNTHESIZED = 1 << 12;	// Snippet is not an explicit part of the AST; placed by dependence rather than containment  
	static final int CONSTANT = 1 << 13;	// Snippet has a constant value  
	
	static final int SUPPRESS_NON_NULL_WARNINGS = 1 << 14;		// Prefix an @SuppressWarnings("null")


	void addClassReference(@NonNull String javaClass);
	void addClassReference(@NonNull Class<?> javaClass);
	void addDependsOn(@NonNull CodeGenSnippet cgNode);
	void addElement(@NonNull Element element);
	@NonNull CodeGenText append(@NonNull String string);
	@NonNull String atNonNull();
	@NonNull String atNullable();
//	@Nullable CodeGenAnalysis getAnalysis();
	@Nullable CodeGenSnippet appendBoxedGuardedChild(@NonNull OCLExpression expression, @Nullable DomainMessage nullMessage, @Nullable DomainMessage invalidMessage);
	void appendContentsOf(@NonNull CodeGenSnippet nestedSnippet);
	@NonNull CodeGenSnippet appendIndentedNodes(@Nullable String indentation, int flags);
	@NonNull CodeGenText appendIndentedText(@Nullable String indentation);
	boolean appendInvalidGuard(@NonNull CodeGenSnippet referredSnippet, @NonNull DomainMessage message);
	boolean appendNullGuard(@NonNull CodeGenSnippet referredSnippet, @NonNull DomainMessage message);
	@NonNull CodeGenSnippet appendText(@Nullable String indentation, @NonNull TextAppender textAppender);
	@Nullable CodeGenSnippet appendUnboxedGuardedChild(@NonNull OCLExpression expression, @Nullable DomainMessage nullMessage, @Nullable DomainMessage invalidMessage);
	boolean checkDependencies(@NonNull LinkedHashMap<CodeGenText, String> emittedTexts, @NonNull Set<CodeGenSnippet> emittedSnippets, @NonNull Set<CodeGenSnippet> startedSnippets, @NonNull HashSet<CodeGenSnippet> knownDependencies);
	void dispose();
	@NonNull LinkedHashMap<CodeGenText, String> flatten();
	boolean flatten(@NonNull LinkedHashMap<CodeGenText, String> emittedTexts, @NonNull Set<CodeGenSnippet> emittedSnippets, @NonNull Set<CodeGenSnippet> startedSnippets, @NonNull String outerIndentation);
	void gatherLiveSnippets(@NonNull Set<CodeGenSnippet> liveSnippets, @NonNull Set<String> referencedClasses);
	@Nullable Object getConstantValue();
	@NonNull List<CodeGenNode> getContents();
	@Nullable Iterable<CodeGenSnippet> getDependsOn();
	int getFlags();
	@NonNull String getName();
	@NonNull Class<?> getJavaClass();
	@NonNull String getJavaClassName();
	@NonNull CodeGenSnippet getBoxedSnippet();
	@NonNull CodeGenSnippet getFinalSnippet();
	@NonNull String getImportedName(@NonNull Class<?> javaClass);
	@NonNull String getImportedName(@NonNull String javaClass);
	@NonNull CodeGenSnippet getNonNullSnippet();
	@Nullable CodeGenSnippet getParent();
	@Nullable CodeGenNode getPredecessor();
	@NonNull CodeGenSnippet getSnippet(@Nullable Object anObject);
	@NonNull String getSnippetName(@Nullable Object anObject);
	@Nullable TypeId getTypeId();
	@NonNull CodeGenSnippet getUnboxedSnippet();
	void internalAddDependant(@NonNull CodeGenSnippet cgNode);
	boolean isBoxed();
	boolean isCaught();
	boolean isConstant();
	boolean isContentable(@NonNull OCLExpression sourceExpression);
	boolean isErased();
	boolean isFinal();
	boolean isGlobal();
	boolean isInline();
	boolean isInvalid();
	boolean isLive();
	boolean isNonInvalid();
	boolean isNonNull();
	boolean isNull();
	boolean isSuppressNonNullWarnings();
	boolean isSynthesized();
	boolean isThrown();
	boolean isUnassigned();
	boolean isUnboxed();
	
	public interface TextAppender {
		boolean appendAtHead(@NonNull CodeGenSnippet snippet);		
		void appendAtTail(@NonNull CodeGenSnippet snippet);		
		void appendToBody(@NonNull CodeGenText text);		
	}
	
	public static abstract class AbstractTextAppender implements TextAppender {
		public boolean appendAtHead(@NonNull CodeGenSnippet snippet) { return true; }	
		public void appendAtTail(@NonNull CodeGenSnippet snippet) {}	
		public void appendToBody(@NonNull CodeGenText text) {}
	}

}
