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
package org.eclipse.ocl.examples.codegen.analyzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;

/**
 * A CodeGenAnalysis maintains the analysis results for a single Pivot AST element
 * on behalf of a CodeGenAnalyzer.
 */
public class CodeGenAnalysis
{
	public static CodeGenAnalysis[] EMPTY_ARRAY = new CodeGenAnalysis[0];
	
	protected final @NonNull CodeGenAnalyzer analyzer;		// Overall analyzer context
	protected final @Nullable CodeGenAnalysis parent;		// Parent node, null at depth 0
	protected final int depth;								// Length of parent closure
	protected final @NonNull TypedElement expression;		// Node to be code generated
	// Optional analysis contributions
	/**
	 * An inlineable element is able to be inlined when accessed and so should not be factored out
	 * into a common subexpression.
	 * <p>
	 * For instance true, false and null are simple constants that are more readable when used directly.
	 */
	private boolean isInlineable = false;
	
	/**
	 * A element that is a static constant is independent of the user's meta-model configuration.
	 * Static constants may therefore be generated directly into the class avoiding initialization
	 * overhead for each execution.
	 */
	private boolean isStaticConstant = false;				// Node is a meta-model-independent constant 
	
	/**
	 * A element that is a local constant is dependent of the user's meta-model configuration.
	 * Local constants must therefore be generated directly into the function pre-amble incurring
	 * a shared overhead for each execution.
	 */
	private boolean isLocalConstant = false;				// Node is a meta-model-dependent constant
//	private boolean childrenAreUnique = false;				// false when uniqueness needs enforcement for a SetLiteral
	private Set<CodeGenAnalysis> invalidSources = null;		// AST nodes that may propagate invalid to this node
	private Set<CodeGenAnalysis> nullSources = null;		// AST nodes that may propagate invalid to this node
	private Set<VariableDeclaration> directDependencies = null;	// AST nodes that this depends on
	private Set<VariableDeclaration> transitiveDependencies = null;	// AST nodes that this depends on
	private Set<CodeGenAnalysis> transitiveInvalidSources = null;		// AST nodes that may propagate invalid to this node
	private Object hashSource = null;						// Element that defines unique internal content
	// Defined by setChildren
	private CodeGenAnalysis[] children = null;				// Child node analyses in generation order
	private int structuralHashCode = 0;						// Structural hash code of self and children
	// Analysis conclusions
	private List<CommonSubExpression> commonSubExpressions = null;	// Non-null if one or more CSEs defined here
	private CommonSubExpression referredCommonSubExpression = null;	// Non-null if value cached in a CSE

	public CodeGenAnalysis(@NonNull CodeGenAnalyzer analyzer, @NonNull TypedElement expression) {
		this.analyzer = analyzer;
		this.parent = null;
		this.depth = 0;
		this.expression = expression;
	}

	public CodeGenAnalysis(@NonNull CodeGenAnalysis parent, @NonNull TypedElement expression) {
		this.analyzer = parent.analyzer;
		this.parent = parent;
		this.depth = parent.depth + 1;
		this.expression = expression;
	}

	public void addCommonSubExpression(@NonNull CommonSubExpression commonSubExpression) {
		if (commonSubExpressions == null) {
			commonSubExpressions = new ArrayList<CommonSubExpression>();
		}
		commonSubExpressions.add(commonSubExpression);
	}

	public void addDependency(@NonNull VariableDeclaration variableDeclaration) {
		transitiveDependencies = null;
		if (directDependencies == null) {
			directDependencies = new HashSet<VariableDeclaration>();
		}
		directDependencies.add(variableDeclaration);
	}

	public void addDependencies(@Nullable Set<? extends VariableDeclaration> dependencies) {
		transitiveDependencies = null;
		if ((dependencies != null) && (dependencies.size() > 0)) {
			if (this.directDependencies == null) {
				this.directDependencies = new HashSet<VariableDeclaration>();
			}
			this.directDependencies.addAll(dependencies);
		}
	}

	public void addInvalidSource(@NonNull CodeGenAnalysis invalidSource) {
		if (invalidSources == null) {
			invalidSources = new HashSet<CodeGenAnalysis>();
		}
		invalidSources.add(invalidSource);
	}

	public void addInvalidSources(@Nullable Set<? extends CodeGenAnalysis> invalidSources) {
		if ((invalidSources != null) && (invalidSources.size() > 0)) {
			if (this.invalidSources == null) {
				this.invalidSources = new HashSet<CodeGenAnalysis>();
			}
			this.invalidSources.addAll(invalidSources);
		}
	}

	public void addNullSource(@NonNull CodeGenAnalysis nullSource) {
		if (nullSources == null) {
			nullSources = new HashSet<CodeGenAnalysis>();
		}
		nullSources.add(nullSource);
	}

	public void addNullSources(@Nullable Set<? extends CodeGenAnalysis> nullSources) {
		if ((nullSources != null) && (nullSources.size() > 0)) {
			if (this.nullSources == null) {
				this.nullSources = new HashSet<CodeGenAnalysis>();
			}
			this.nullSources.addAll(nullSources);
		}
	}

	private void gatherTransitiveDependencies(@NonNull Set<VariableDeclaration> knownDependencies, @NonNull Set<VariableDeclaration> newDependencies) {
		for (VariableDeclaration newDependency : newDependencies) {
			if (!knownDependencies.contains(newDependency)) {
				knownDependencies.add(newDependency);
				if (newDependency instanceof Variable) {
					OCLExpression initExpression = ((Variable)newDependency).getInitExpression();
					if (initExpression != null) {
						CodeGenAnalysis analysis = analyzer.getNode(initExpression);
						if (analysis != null) {
							Set<VariableDeclaration> nestedDependencies = analysis.getDirectDependencies();
							if (nestedDependencies != null) {
								gatherTransitiveDependencies(knownDependencies, nestedDependencies);
							}
						}
					}
				}
			}			
		}
	}

	public CodeGenAnalysis getAnalysisAt(int candidateDepth) {
		for (CodeGenAnalysis candidate = this; candidate != null; candidate = candidate.parent) {
			if (candidateDepth == candidate.depth) {
				return candidate;
			}
		}
		return null;
	}

	public @Nullable CodeGenAnalysis[] getChildren() {
		return children;
	}

	public @Nullable List<CommonSubExpression> getCommonSubExpressions() {
		return commonSubExpressions;
	}

	public @Nullable Set<VariableDeclaration> getDirectDependencies() {
		return directDependencies;
	}

	public int getDepth() {
		return depth;
	}

	public @NonNull TypedElement getExpression() {
		return expression;
	}

	public @Nullable Set<CodeGenAnalysis> getInvalidSources() {
		return invalidSources;
	}

	public @Nullable Set<CodeGenAnalysis> getNullSources() {
		return nullSources;
	}

	public @Nullable CodeGenAnalysis getParent() {
		return parent;
	}

	public @Nullable CommonSubExpression getReferredCommonSubExpression() {
		return referredCommonSubExpression;
	}

	public int getStructuralHashCode() {
		return structuralHashCode;
	}

	public @NonNull Set<VariableDeclaration> getTransitiveDependencies() {
		Set<VariableDeclaration> transitiveDependencies2 = transitiveDependencies;
		if (transitiveDependencies2 == null) {
			transitiveDependencies = transitiveDependencies2 = new HashSet<VariableDeclaration>();
			if (directDependencies != null) {
				gatherTransitiveDependencies(transitiveDependencies2, directDependencies);
			}
		}
		return transitiveDependencies2;
	}

	public @NonNull Set<CodeGenAnalysis> getTransitiveInvalidSources() {
		Set<CodeGenAnalysis> transitiveInvalidSources2 = transitiveInvalidSources;
		if (transitiveInvalidSources2 == null) {
			transitiveInvalidSources = transitiveInvalidSources2 = new HashSet<CodeGenAnalysis>();
			for (VariableDeclaration dependency : getTransitiveDependencies()) {
				if (dependency instanceof Variable) {
					OCLExpression initExpression = ((Variable)dependency).getInitExpression();
					if (initExpression != null) {
						CodeGenAnalysis analysis = analyzer.getNode(initExpression);
						if (analysis != null) {
							Set<CodeGenAnalysis> invalidSources = analysis.getInvalidSources();
							if (invalidSources != null) {
								transitiveInvalidSources2.addAll(invalidSources);
							}
						}
					}
				}
			}
		}
		return transitiveInvalidSources2;
	}

	public boolean isConstant() {
		return this.isLocalConstant || this.isStaticConstant;
	}

	public boolean isInlineable() {
		return this.isInlineable;
	}

	public boolean isLocalConstant() {
		return this.isLocalConstant;
	}

	public boolean isStaticConstant() {
		return this.isStaticConstant;
	}

	public boolean isStructurallyEqualTo(@NonNull CodeGenAnalysis that) {
		if (this.structuralHashCode != that.structuralHashCode) {
			return false;
		}
		if (this.hashSource != that.hashSource) {
			return false;
		}
		if (this.expression.getClass() != that.expression.getClass()) {
			return false;
		}
		if (this.children.length != that.children.length) {
			return false;
		}
		for (int i = 0; i < children.length; i++) {
			CodeGenAnalysis thatChild = that.children[i];
			assert thatChild != null;
			if (!this.children[i].isStructurallyEqualTo(thatChild)) {
				return false;
			}
		}
		return true;
	}

	@Deprecated			// This is just for testing
	public void resetConstant() {
		this.isLocalConstant = false;
		this.isStaticConstant = false;
	}
	
	public int setChildren(@Nullable List<CodeGenAnalysis> children) {
		int hash = expression.getClass().hashCode();
		if (hashSource != null) {
			hash += hashSource.hashCode();
		}
		if (children != null) {
			this.children = children.toArray(new CodeGenAnalysis[children.size()]);
			for (CodeGenAnalysis child : children) {
				hash = 3 * hash + child.hashCode();
			}
		}
		else {
			this.children = EMPTY_ARRAY;
		}
		this.structuralHashCode = hash;
		return hash;
	}

	public void setReferredCommonSubExpression(@NonNull CommonSubExpression referredCommonSubExpression) {
		this.referredCommonSubExpression = referredCommonSubExpression;
	}

	public void setContent(int contentHashCode) {
		this.structuralHashCode = contentHashCode;
	}

	public void setHashSource(@Nullable Object hashSource) {
		this.hashSource = hashSource;
	}

	public void setLocalConstant() {
		this.isLocalConstant = true;
	}

	public void setInlineable() {
		this.isInlineable = true;
	}

	public void setStaticConstant() {
		this.isStaticConstant = true;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(expression.toString() + ' ');
		char prefix = '{';
		if (isStaticConstant) { s.append(prefix + "Static"); prefix = ','; }
		if (isLocalConstant) { s.append(prefix + "Local"); prefix = ','; }
		if (isInlineable) { s.append(prefix + "Inline"); prefix = ','; }
		if (prefix == '{') { s.append(prefix); }
		s.append('}');
		return s.toString();
	}
}
