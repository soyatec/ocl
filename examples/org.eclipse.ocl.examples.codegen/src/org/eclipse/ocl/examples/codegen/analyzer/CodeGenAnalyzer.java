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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.TypedElement;

/**
 * A CodeGenAnalyzer performs the analysis of a Pivot AST in preparation for code generation.
 */
public class CodeGenAnalyzer
{	
	protected final @NonNull NameManager nameManager;
	protected final @NonNull CodeGenAnalysisVisitor visitor;
	protected final @NonNull TypedElement rootElement;
	protected final @NonNull Map<Element, CodeGenAnalysis> element2node = new HashMap<Element, CodeGenAnalysis>();
	// Current context during tree traversal, final state is the root analysis
	private List<CodeGenAnalysis> theseChildren = null;
	private @NonNull CodeGenAnalysis thisAnalysis;
	
	public CodeGenAnalyzer(@NonNull NameManager nameManager, @NonNull TypedElement element) {
		this.nameManager = nameManager;
		this.visitor = new CodeGenAnalysisVisitor(this);
		this.rootElement = element;
		this.thisAnalysis = new CodeGenAnalysis(this, element);
	}

	protected void addLocalConstant() {
		thisAnalysis.setLocalConstant();
//		localConstants.add(thisAnalysis);
	}
	
	public void addNamedElement(@Nullable NamedElement namedElement) {
		if (namedElement != null) {
			nameManager.addNamedElement(namedElement);
		}
	}

	protected void addStaticConstant() {
		thisAnalysis.setStaticConstant();
//		staticConstants.add(thisAnalysis);
	}

	public void analyze() {
		element2node.put(rootElement, thisAnalysis);
		rootElement.accept(visitor);
		thisAnalysis.setChildren(theseChildren);
	}
	
	/**
	 * The descent pushes the current analysis and children, then creates a new analysis for the visit.
	 * On completion of the visit, the children are installed establishing the structural hash code
	 * and the former analysis and children are popped.
	 * 
	 * @param element to be visited, which may (but should not) be null
	 * @return the elemental analysis or null if a null element
	 */
	protected @NonNull CodeGenAnalysis descend(@NonNull TypedElement expression) {
		CodeGenAnalysis thisAnalysis2 = thisAnalysis;
		assert thisAnalysis2 != null;
		@NonNull CodeGenAnalysis savedAnalysis = thisAnalysis2;
		@Nullable List<CodeGenAnalysis> savedChildren = theseChildren;
		try {
			thisAnalysis = thisAnalysis2 = new CodeGenAnalysis(thisAnalysis2, expression);
			theseChildren = null;
			CodeGenAnalysis oldAnalysis = element2node.put(expression, thisAnalysis2);
			assert oldAnalysis == null;
			CodeGenAnalysisVisitor visitor2 = visitor;
			assert visitor2 != null;
			expression.accept(visitor2);
			return thisAnalysis2;
		}
		finally {
			if (theseChildren != null) {
				for (CodeGenAnalysis child : theseChildren) {
					thisAnalysis2.addDependencies(child.getDirectDependencies());
				}
			}
			theseChildren = savedChildren;
			List<CodeGenAnalysis> theseChildren2 = theseChildren;
			if (theseChildren2 == null) {
				theseChildren = theseChildren2 = new ArrayList<CodeGenAnalysis>();
			}
			theseChildren2.add(thisAnalysis2);
			thisAnalysis = savedAnalysis;
		}
	}

	protected void descendAll(Iterable<? extends TypedElement> expressions) {
		boolean localConstant = true;
		boolean staticConstant = true;
		for (TypedElement expression : expressions) {
			assert expression != null;
			CodeGenAnalysis child = descend(expression);
			thisAnalysis.addInvalidSources(child.getInvalidSources());
			if (!child.isStaticConstant()) {
				staticConstant = false;
				if (!child.isLocalConstant()) {
					localConstant = false;
				}
			}
		}
		if (staticConstant) {
			addStaticConstant();
		}
		else if (localConstant) {
			addLocalConstant();
		}
	}

	public @NonNull CodeGenAnalysis getCurrentAnalysis() {
		return DomainUtil.nonNullState(thisAnalysis);
	}

	public @Nullable List<CodeGenAnalysis> getCurrentChildren() {
		return theseChildren;
	}

	public @NonNull NameManager getNameManager() {
		return DomainUtil.nonNullState(nameManager);
	}

	public CodeGenAnalysis getNode(@NonNull Element element) {
		return element2node.get(element);
	}

	public @NonNull String getUniqueName(@NonNull NamedElement element, @NonNull String... nameHints) {
		return nameManager.getUniqueName(element, nameHints);
	}

	public void optimize() {
		CommonSubExpressionEliminator commonSubExpressionEliminator = new CommonSubExpressionEliminator(this, thisAnalysis);
		commonSubExpressionEliminator.optimize();
	}
}
