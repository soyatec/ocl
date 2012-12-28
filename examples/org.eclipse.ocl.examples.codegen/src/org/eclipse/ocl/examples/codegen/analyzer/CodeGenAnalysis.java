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
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;

/**
 * A CodeGenAnalysis maintains the analysis results for a single Pivot AST element
 * on behalf of a CodeGenAnalyzer.
 */
public class CodeGenAnalysis
{
	public static CodeGenAnalysis[] EMPTY_ARRAY = new CodeGenAnalysis[0];
	
	protected final @NonNull CodeGenAnalyzer analyzer;		// Overall analyzer context
	protected final @NonNull Element expression;			// Node to be code generated
	//
	//	Initial tree structure
	//
	protected final @Nullable CodeGenAnalysis parent;		// Parent node, null at depth 0
	protected final int depth;								// Length of parent closure
	// Defined by initChildren
	private CodeGenAnalysis[] children = null;				// Child node analyses in generation order
	// Defined by initHashSource()
	private Object hashSource = null;						// Element that defines unique internal content
	// Optional analysis contributions
	/**
	 * An inlineable element is able to be inlined when accessed and so should not be factored out
	 * into a common subexpression.
	 * <p>
	 * For instance true, false and null are simple constants that are more readable when used directly.
	 */
	private boolean isInlineable = false;
	
//	private boolean childrenAreUnique = false;				// false when uniqueness needs enforcement for a SetLiteral
//	private Set<CodeGenAnalysis> invalidSources = null;		// AST nodes that may propagate invalid to this node
//	private Set<CodeGenAnalysis> nullSources = null;		// AST nodes that may propagate invalid to this node
	private Set<VariableDeclaration> directDependencies = null;	// AST nodes that this depends on
	private Set<VariableDeclaration> transitiveDependencies = null;	// AST nodes that this depends on
//	private Set<CodeGenAnalysis> transitiveInvalidSources = null;	// AST nodes that may propagate invalid to this node
//	private int structuralHashCode = 0;								// Structural hash code of self and children
	private @Nullable CodeGenAnalysis delegateTo = null;			// Non-null to delegate the analysis to another node; e.g VariableExp delegates to its initExpression
	private @Nullable Variable targetVariable = null;				// Non-null if the analyzed expression is assigned to a target variable
	private @Nullable Set<CodeGenAnalysis> invalidGuards = null;	// AST nodes for which an invalid value must be thrown before code generating this analysis
	private @Nullable Set<CodeGenAnalysis> nullGuards = null;		// AST nodes for which a null value must be thrown before code generating this analysis
	//
	// DependencyAnalysis conclusions
	//
	//
	// ConstantFolder analysis conclusions
	//
	/**
	 * A element that is a static constant is independent of the user's meta-model configuration.
	 * Static constants may therefore be generated directly into the class avoiding initialization
	 * overhead for each execution.
	 */
	private boolean isStaticConstant = false;						// Node is a meta-model-independent constant 
	
	/**
	 * A element that is a local constant is dependent of the user's meta-model configuration.
	 * Local constants must therefore be generated directly into the function pre-amble incurring
	 * a shared overhead for each execution.
	 */
	private boolean isLocalConstant = false;						// Node is a meta-model-dependent constant

	private boolean isNull = false;									// True if value definitely null
	private boolean isInvalid = false;								// True if value definitely invalid
	private boolean isCatching = false;								// True if accessed as a caught value 
	private boolean isThrowing = false;								// True if accessed as a thrown value
	private boolean isInvalidating = false;							// True if value may be invalid
	private boolean isValidating = false;							// True if invalid values are processed
	private boolean isRequired = false;								// True for a required root
	
	private Object constantValue = null;
	//
	// CommonSubExpressionEliminator analysis conclusions
	//
	/**
	 * The structural hash code determined by the CommonSubExpressionEliminator. Equivalent trees share the same structural
	 * hash code at their roots.
	 */
	private int structuralHashCode = 0;								// Initilaized by initStructuralHashCode()
	private List<CommonSubExpression> commonSubExpressions = null;	// Non-null if one or more CSEs defined here
	private CommonSubExpression referredCommonSubExpression = null;	// Non-null if value cached in a CSE


	public CodeGenAnalysis(@NonNull CodeGenAnalyzer analyzer, @NonNull Element expression, boolean isRequired) {
		this.analyzer = analyzer;
		this.expression = expression;
		this.parent = null;
		this.depth = 0;
		this.isRequired = isRequired;
	}

	public CodeGenAnalysis(@NonNull CodeGenAnalysis parent, @NonNull Element expression) {
		this.analyzer = parent.analyzer;
		this.expression = expression;
		this.parent = parent;
		this.depth = parent.depth + 1;
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

	public void addInvalidGuard(@NonNull CodeGenAnalysis invalidSource) {
		if (delegateTo != null) {
			delegateTo.addInvalidGuard(invalidSource);
		}
		else {
			Set<CodeGenAnalysis> invalidGuards2 = invalidGuards;
			if (invalidGuards2 == null) {
				invalidGuards = invalidGuards2 = new HashSet<CodeGenAnalysis>();
			}
			invalidGuards2.add(invalidSource);
		}
	}

//	public void addInvalidSource(@NonNull CodeGenAnalysis invalidSource) {
//		if (invalidSources == null) {
//			invalidSources = new HashSet<CodeGenAnalysis>();
//		}
//		invalidSources.add(invalidSource);
//	}

//	public void addInvalidSources(@Nullable Set<? extends CodeGenAnalysis> invalidSources) {
//		if ((invalidSources != null) && (invalidSources.size() > 0)) {
//			if (this.invalidSources == null) {
//				this.invalidSources = new HashSet<CodeGenAnalysis>();
//			}
//			this.invalidSources.addAll(invalidSources);
//		}
//	}

	public void addNullGuard(@NonNull CodeGenAnalysis nullSource) {
		if (delegateTo != null) {
			delegateTo.addNullGuard(nullSource);
		}
		else {
			Set<CodeGenAnalysis> nullGuards2 = nullGuards;
			if (nullGuards2 == null) {
				nullGuards = nullGuards2 = new HashSet<CodeGenAnalysis>();
			}
			nullGuards2.add(nullSource);
		}
	}

//	public void addNullSource(@NonNull CodeGenAnalysis nullSource) {
//		if (nullSources == null) {
//			nullSources = new HashSet<CodeGenAnalysis>();
//		}
//		nullSources.add(nullSource);
//	}

//	public void addNullSources(@Nullable Set<? extends CodeGenAnalysis> nullSources) {
//		if ((nullSources != null) && (nullSources.size() > 0)) {
//			if (this.nullSources == null) {
//				this.nullSources = new HashSet<CodeGenAnalysis>();
//			}
//			this.nullSources.addAll(nullSources);
//		}
//	}

	private void gatherTransitiveDependencies(@NonNull Set<VariableDeclaration> knownDependencies, @NonNull Set<VariableDeclaration> newDependencies) {
		for (VariableDeclaration newDependency : newDependencies) {
			if (!knownDependencies.contains(newDependency)) {
				knownDependencies.add(newDependency);
				if (newDependency instanceof Variable) {
					OCLExpression initExpression = ((Variable)newDependency).getInitExpression();
					if (initExpression != null) {
						CodeGenAnalysis analysis = analyzer.getAnalysis(initExpression);
						Set<VariableDeclaration> nestedDependencies = analysis.getDirectDependencies();
						if (nestedDependencies != null) {
							gatherTransitiveDependencies(knownDependencies, nestedDependencies);
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

	public @NonNull CodeGenerator getCodeGenerator() {
		return analyzer.getCodeGenerator();
	}

	public @Nullable List<CommonSubExpression> getCommonSubExpressions() {
		return commonSubExpressions;
	}

	public @Nullable Object getConstantValue() {
		if (delegateTo != null) {
			return delegateTo.getConstantValue();
		}
		else if (!isConstant() && !isInvalid()) {
			throw new IllegalStateException("getConstantValue of non-constant");
		}
		return constantValue;
	}

	public int getDepth() {
		return depth;
	}

	public @Nullable CodeGenAnalysis getDelegatesTo() {
		return delegateTo;
	}

	public @Nullable Set<VariableDeclaration> getDirectDependencies() {
		return directDependencies;
	}

	public @NonNull Element getExpression() {
		return expression;
	}

	public @Nullable Set<CodeGenAnalysis> getInvalidGuards() {
		return invalidGuards;
	}

//	public @Nullable Set<CodeGenAnalysis> getInvalidSources() {
//		return invalidSources;
//	}

	public int getLocalStructuralHashCode() {
		int structuralHashCode = expression.getClass().hashCode();
		if (hashSource != null) {
			structuralHashCode += hashSource.hashCode();
		}
		return structuralHashCode;
	}

	public @Nullable Set<CodeGenAnalysis> getNullGuards() {
		return nullGuards;
	}

//	public @Nullable Set<CodeGenAnalysis> getNullSources() {
//		return nullSources;
//	}

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

/*	public @NonNull Set<CodeGenAnalysis> getTransitiveInvalidSources() {
		Set<CodeGenAnalysis> transitiveInvalidSources2 = transitiveInvalidSources;
		if (transitiveInvalidSources2 == null) {
			transitiveInvalidSources = transitiveInvalidSources2 = new HashSet<CodeGenAnalysis>();
			if (invalidSources != null) {
				transitiveInvalidSources.addAll(invalidSources);
			}
			for (VariableDeclaration dependency : getTransitiveDependencies()) {
				if (dependency instanceof Variable) {
					OCLExpression initExpression = ((Variable)dependency).getInitExpression();
					if (initExpression != null) {
						CodeGenAnalysis analysis = analyzer.getAnalysis(initExpression);
						Set<CodeGenAnalysis> nestedInvalidSources = analysis.getInvalidSources();
						if (nestedInvalidSources != null) {
							transitiveInvalidSources2.addAll(nestedInvalidSources);
						}
					}
				}
			}
		}
		return transitiveInvalidSources2;
	} */
	
	public void initChildren(@Nullable List<CodeGenAnalysis> children) {
		if (children != null) {
//			assert delegateTo == null;
			this.children = children.toArray(new CodeGenAnalysis[children.size()]);
		}
		else {
			this.children = EMPTY_ARRAY;
		}
	}

	public void initHashSource(@NonNull Object hashSource) {
		assert delegateTo == null;
		this.hashSource = hashSource;
	}

	public void initStructuralHashCode(int structuralHashCode) {
		assert (this.structuralHashCode == 0) || (this.structuralHashCode == structuralHashCode);
		assert this.children != null;
		this.structuralHashCode = structuralHashCode;
	}

	public boolean isCatching() {
		return this.isCatching;
	}

	public boolean isConstant() {
		if (delegateTo != null) {
			return delegateTo.isConstant();
		}
		else {
			return this.isLocalConstant || this.isStaticConstant;
		}
	}

	public boolean isInlineable() {
		if (delegateTo != null) {
			return delegateTo.isInlineable();
		}
		else {
			return this.isInlineable;
		}
	}

	public boolean isInvalid() {
		if (delegateTo != null) {
			return delegateTo.isInvalid();
		}
		else {
			return isInvalid || (this.constantValue instanceof InvalidValueException);
		}
	}

	public boolean isInvalidating() {
		if (delegateTo != null) {
			return delegateTo.isInvalidating();
		}
		else {
			return isInvalidating;
		}
	}

	public boolean isLocalConstant() {
		if (delegateTo != null) {
			return delegateTo.isLocalConstant();
		}
		else {
			return this.isLocalConstant;
		}
	}

	public boolean isNonNull() {
		if (delegateTo != null) {
			return delegateTo.isNull();
		}
		else {
			return isConstant() && (this.constantValue != null);
		}
	}

	public boolean isNull() {
		if (delegateTo != null) {
			return delegateTo.isNull();
		}
		else {
			return isNull; // || (isConstant() && (this.constantValue == null);
		}
	}

	public boolean isRequired() {
		return isRequired;
	}

	public boolean isStaticConstant() {
		if (delegateTo != null) {
			return delegateTo.isStaticConstant();
		}
		else {
			return this.isStaticConstant;
		}
	}

	public boolean isStructurallyEqualTo(@NonNull CodeGenAnalysis that) {
//		if (this.structuralHashCode != that.structuralHashCode) {
//			return false;
//		}
		if ((this.hashSource != that.hashSource) && ((this.hashSource == null) || !this.hashSource.equals(that.hashSource))) {
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

	public boolean isThrowing() {
		if (delegateTo != null) {
			return delegateTo.isThrowing();
		}
		else {
			return this.isThrowing;
		}
	}

	public boolean isValidating() {
		return isValidating;
	}

	public boolean mayBeCommoned() {
		if (isConstant()) {
			return false;
		}
		if (isInvalid()) {
			return false;
		}
		if (expression instanceof VariableExp) {
			return false;
		}
		return true;
	}

	/**
	 * Return true if the expression may be an invalid value thrown as an exception, such as propagated invalid.
	 */
	public boolean mayBeException() {
		if (expression instanceof Variable) {
			if (expression.eContainer() instanceof ExpressionInOCL) {
				return false;
			}
			if (expression.eContainer() instanceof LoopExp) {
				return false;
			}
			return false;
		}
		if ((expression instanceof VariableExp) && !isInlineable()) {
			return false;
		}
		if (isConstant() && !isInvalid()) {
			return false;
		}
//		Set<VariableDeclaration> allDependencies = getTransitiveDependencies();
//		return allDependencies.size() > 0;
		return true;
	}

	/**
	 * Return true if the expression may be an invalid value passed by value, such as a result cached in a let expression.
	 */
	public boolean mayBeInvalidValue() {
		if ((expression instanceof VariableExp) && isInlineable()) {
			Set<VariableDeclaration> allDependencies = getTransitiveDependencies();
			return allDependencies.size() > 0;
		}
		return false;
/*		for (TypedElement element = expression; element instanceof VariableExp; ) {
			VariableDeclaration referredVariable = ((VariableExp)element).getReferredVariable();
			if (referredVariable instanceof Variable) {
				element = ((Variable)referredVariable).getInitExpression();
			}
			else {
				break;
			}
		}
		if (anExpression == null) {
			return false;
		}
		CodeGenAnalysis analysis = context.getAnalysis(anExpression);
		Set<CodeGenAnalysis> invalidSources = analysis.getInvalidSources();
		return (invalidSources != null) && (invalidSources.size() > 0); */
	}

	public void setCatching() {
		if ((expression instanceof  Variable) && (expression.eContainer() instanceof LoopExp)) {
			return;
		}
		this.isCatching = true;
		if (delegateTo != null) {
			delegateTo.setCatching();
		}
	}

	public void setDelegateTo(@NonNull CodeGenAnalysis anAnalysis) {
//		assert children == EMPTY_ARRAY;
		assert isInvalid || (constantValue == null);		// FIXME revert to constantValue set by analysis
		assert delegateTo == null;
		assert isInlineable == false;
		assert isLocalConstant == false;
		assert isStaticConstant == false;
		assert isCatching == false;
		delegateTo = anAnalysis;
	}

	public void setInlineable() {
		assert delegateTo == null;
		this.isInlineable = true;
	}

	public void setInvalid() {
//		assert delegateTo == null;
		this.isInvalid = true;
		this.constantValue = ValuesUtil.INVALID_VALUE;
	}

	public void setInvalidating() {
		assert delegateTo == null;
		this.isInvalidating = true;
	}

	public void setLocalConstant() {
		assert delegateTo == null;
		this.isLocalConstant = true;
	}

	public void setLocalConstantValue(@Nullable Object constantValue) {
		assert delegateTo == null;
		this.isLocalConstant = true;
		this.constantValue = constantValue;	
//		this.isInlineable = (constantValue == null) || (constantValue instanceof Boolean);
//		this.isInlineable = analyzer.getConstantHelper().isInlineable(constantValue);
//		if (!isInlineable) {				// null is always inlineable
//			assert constantValue != null;
			@SuppressWarnings("unused") String name = analyzer.getCodeGenerator().getSnippet(constantValue).getName();
//		}
	}

	public void setNull() {
//		assert delegateTo == null;
		this.isNull = true;
	}

	public void setReferredCommonSubExpression(@NonNull CommonSubExpression referredCommonSubExpression) {
		assert delegateTo == null;
		this.referredCommonSubExpression = referredCommonSubExpression;
	}

	public void setStaticConstant() {
		assert delegateTo == null;
		this.isStaticConstant = true;
	}

	public void setStaticConstantValue(@Nullable Object constantValue) {
		assert (delegateTo == null) || (isInvalid() && (constantValue instanceof InvalidValueException)) || (isNull() && (constantValue == null));
		this.isStaticConstant = true;
		this.constantValue = constantValue;	
//		this.isInlineable = analyzer.getConstantHelper().isInlineable(constantValue);
//		if (!isInlineable) {				// null is always inlineable
//			assert constantValue != null;
			CodeGenSnippet constantSnippet = analyzer.getCodeGenerator().getSnippet(constantValue);
			@SuppressWarnings("unused") String name = constantSnippet.getName();
//		}
	}

	public void setThrowing() {
		if (isThrowing && !((expression instanceof Variable) && (expression.eContainer() instanceof LoopExp))) {
			setCatching();		// FIXME unnecessary once flow analysis can share a thrown let variable
		}
		isThrowing  = true;
		if (delegateTo != null) {
			delegateTo.setThrowing();
		}
	}

	public void setValidating() {
		assert delegateTo == null;
		this.isValidating = true;
	}

	public void setVariable(@NonNull Variable targetVariable) {
//		assert delegateTo == null;
		assert this.targetVariable == null;
		this.targetVariable  = targetVariable;
	}

	@Override
	public String toString() {
		if (delegateTo != null) {
			return "=>" + delegateTo.toString();
		}
		StringBuilder s = new StringBuilder();
		s.append(expression.toString() + ' ');
		char prefix = '{';
		if (isStaticConstant) { s.append(prefix + "Static=" + String.valueOf(constantValue)); prefix = ','; }
		if (isLocalConstant) { s.append(prefix + "Local=" + String.valueOf(constantValue)); prefix = ','; }
		if (isInlineable) { s.append(prefix + "Inline"); prefix = ','; }
		if (isNull) { s.append(prefix + "Null"); prefix = ','; }
		if (isInvalid) { s.append(prefix + "Invalid"); prefix = ','; }
		if (isInvalidating) { s.append(prefix + "Invalidating"); prefix = ','; }
		if (isValidating) { s.append(prefix + "Validating"); prefix = ','; }
		if (isCatching) { s.append(prefix + "ForCatching"); prefix = ','; }
		if (isThrowing) { s.append(prefix + "ForThrowing"); prefix = ','; }
		if (isRequired) { s.append(prefix + "Required"); prefix = ','; }
		if (prefix == '{') { s.append(prefix); }
		s.append('}');
		return s.toString();
	}
}
