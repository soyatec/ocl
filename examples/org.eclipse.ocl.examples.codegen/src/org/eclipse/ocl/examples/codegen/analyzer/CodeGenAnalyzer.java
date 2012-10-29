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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	/**
	 * Names that will not be allocated to temporary variables.
	 */
	public static final Set<String> reservedNames = new HashSet<String>();
	{
//		reservedNames.add("endif");
//		reservedNames.add("in");
//		reservedNames.add("invalid");
//		reservedNames.add("let");
//		reservedNames.add("unlimited");
//		reservedNames.add("and");
//		reservedNames.add("not");
//		reservedNames.add("or");
//		reservedNames.add("xor");
		
		reservedNames.add("Boolean");
		reservedNames.add("Class");
		reservedNames.add("Integer");
		reservedNames.add("List");
		reservedNames.add("Long");
		reservedNames.add("Map");
		reservedNames.add("Package");
		reservedNames.add("String");
		
		reservedNames.add("boolean");
		reservedNames.add("byte");
		reservedNames.add("char");
		reservedNames.add("class");
		reservedNames.add("enum");
		reservedNames.add("int");
		reservedNames.add("long");
		reservedNames.add("package");
		reservedNames.add("short");
		reservedNames.add("void");
		
		reservedNames.add("break");
		reservedNames.add("case");
		reservedNames.add("catch");
		reservedNames.add("do");
		reservedNames.add("else");
		reservedNames.add("finally");
		reservedNames.add("for");
		reservedNames.add("goto");
		reservedNames.add("if");
		reservedNames.add("new");
		reservedNames.add("private");
		reservedNames.add("protected");
		reservedNames.add("public");
		reservedNames.add("return");
		reservedNames.add("switch");
		reservedNames.add("throw");
		reservedNames.add("throws");
		reservedNames.add("try");
		reservedNames.add("while");

		reservedNames.add("false");
		reservedNames.add("null");
		reservedNames.add("super");
		reservedNames.add("this");
		reservedNames.add("true");
	}
	
	private CodeGenAnalysisVisitor visitor = null;
//	private Element rootElement = null;
	private Map<Element, CodeGenAnalysis> element2node = null;
	private Map<Integer, List<List<CodeGenAnalysis>>> hash2nodes = null;
	private List<CodeGenAnalysis> staticConstants = null;
	private List<CodeGenAnalysis> localConstants = null;
	// Naming
	private NameManager nameManager = null;
	// Current context during tree traversal
	private List<CodeGenAnalysis> theseChildren = null;
	private CodeGenAnalysis thisAnalysis = null;
	
	public CodeGenAnalyzer() {}

	protected void addLocalConstant() {
		thisAnalysis.setLocalConstant();
		localConstants.add(thisAnalysis);
	}
	
	public void addNamedElement(@Nullable NamedElement namedElement) {
		if (namedElement != null) {
			nameManager.addNamedElement(namedElement);
		}
	}

	protected void addStaticConstant() {
		thisAnalysis.setStaticConstant();
		staticConstants.add(thisAnalysis);
	}
	
	/**
	 * The descent pushes the current analysis and children, then creates a new analysis for the visit.
	 * On completion of the visit, the children are installed establishing the structural hash code
	 * and the former analysis and children are popped.
	 * 
	 * @param element to be visited, which may (but should not) be null
	 * @return the elemental analysis or null if a null element
	 */
	protected @Nullable CodeGenAnalysis descend(@Nullable TypedElement expression) {
		if (expression == null) {
			return null;
		}
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
					thisAnalysis2.addDependencies(child.getDependencies());
				}
			}
			int structuralHashCode = thisAnalysis2.setChildren(theseChildren);
			List<List<CodeGenAnalysis>> hashedAnalyses = hash2nodes.get(structuralHashCode);
			if (hashedAnalyses == null) {
				hashedAnalyses = new ArrayList<List<CodeGenAnalysis>>();
				hash2nodes.put(structuralHashCode, hashedAnalyses);
			}
			boolean gotIt = false;
			for (List<CodeGenAnalysis> hashedAnalysis : hashedAnalyses) {
				CodeGenAnalysis analysis = hashedAnalysis.get(0);
				assert analysis != null;
				if (thisAnalysis2.isStructurallyEqualTo(analysis)) {
					if (!hashedAnalyses.contains(thisAnalysis2)) {
						hashedAnalysis.add(thisAnalysis2);
					}
					gotIt = true;
					break;
				}
			}
			if (!gotIt) {
				List<CodeGenAnalysis> hashedAnalysis = new ArrayList<CodeGenAnalysis>();
				hashedAnalyses.add(hashedAnalysis);
				hashedAnalysis.add(thisAnalysis2);
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
			CodeGenAnalysis child = descend(expression);
			if (child != null) {
				thisAnalysis.addInvalidSources(child.getInvalidSources());
				if (!child.isStaticConstant()) {
					staticConstant = false;
					if (!child.isLocalConstant()) {
						localConstant = false;
					}
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

	/**
	 * Compute a map from each common subexpression to a list of all structurally equal sub-expressions.
	 * @return
	 */
	protected Map<CodeGenAnalysis, CommonSubExpression> findCommonSubExpressions() {
		//
		//	Locate all candidate CSEs; the identical structural trees that are constant or used more than once.
		//
		List<List<CodeGenAnalysis>> candidates = new ArrayList<List<CodeGenAnalysis>>();
		for (List<List<CodeGenAnalysis>> hashedAnalyses : hash2nodes.values()) {
			for (List<CodeGenAnalysis> hashedAnalysis : hashedAnalyses) {
				int iSize = hashedAnalysis.size();
				CodeGenAnalysis analysis = hashedAnalysis.get(0);
				if (!analysis.isInlineable() && ((iSize > 1) || analysis.isConstant())) {
					candidates.add(hashedAnalysis);
				}
			}
		}
		//
		//	Prune the candidate CSEs by reducing the CSE children to a single copy for each shared common node.
		//
		Map<List<CodeGenAnalysis>, List<CodeGenAnalysis>> allCommonNodes = new HashMap<List<CodeGenAnalysis>, List<CodeGenAnalysis>>();
		for (List<CodeGenAnalysis> candidate : candidates) {
			List<CodeGenAnalysis> commonNodes = new ArrayList<CodeGenAnalysis>();
			allCommonNodes.put(candidate, commonNodes);
			int iSize = candidate.size();
			CodeGenAnalysis firstAnalysis = candidate.get(0);
			if (firstAnalysis.isStaticConstant()) {
				commonNodes.add(firstAnalysis.getAnalysisAt(0));
				for (int i = 1; i < iSize; i++) {			// Omit first analysis
					CodeGenAnalysis secondAnalysis = candidate.get(i);
					assert secondAnalysis != null;
					CodeGenAnalysis[] children = secondAnalysis.getChildren();
					if ((children != null) && (children.length > 0)) {
						findCommonSubExpressionsPrune(children);
					}
				}
			}
			else {
				commonNodes.add(firstAnalysis);
				for (int i = 1; i < iSize; i++) {			// Omit first analysis
					CodeGenAnalysis secondAnalysis = candidate.get(i);
					CodeGenAnalysis commonerNode = null;
					for (CodeGenAnalysis commonNode : commonNodes) {
						assert commonNode != null;
						assert secondAnalysis != null;
						commonerNode = findCommonNode(commonNode, secondAnalysis);	// FIXME dependency validity
						if (commonerNode != null) {
							if (commonerNode != commonNode) {
								commonNodes.remove(commonNode);
								commonNodes.add(commonerNode);
							}
							CodeGenAnalysis[] children = secondAnalysis.getChildren();
							if ((children != null) && (children.length > 0)) {
								findCommonSubExpressionsPrune(children);
							}
							break;
						}
					}
					if (commonerNode == null) {
						commonNodes.add(secondAnalysis);
					}
				}
			}
		}
		//
		//	Install a CommonSubExpression for each common node or residual CSE.
		//
		Map<CodeGenAnalysis, CommonSubExpression> commonSubExpressions = new HashMap<CodeGenAnalysis, CommonSubExpression>();
		for (List<CodeGenAnalysis> candidate : candidates) {
			int iSize = candidate.size();
			CodeGenAnalysis candidate0 = candidate.get(0);
			if (!candidate0.isInlineable() && ((iSize > 1) || candidate0.isConstant())) {
				CommonSubExpression cse = new CommonSubExpression(this, candidate);
				for (CodeGenAnalysis analysis : candidate) {
					commonSubExpressions.put(analysis, cse);
				}
				for (CodeGenAnalysis commonNode : allCommonNodes.get(candidate)) {
					assert cse != null;
					commonNode.addCommonSubExpression(cse);
				}
			}
		}
		return commonSubExpressions;
	}

	private CodeGenAnalysis findCommonNode(@NonNull CodeGenAnalysis firstAnalysis, @NonNull CodeGenAnalysis secondAnalysis) {
		int firstDepth = firstAnalysis.getDepth();
		int secondDepth = secondAnalysis.getDepth();
		int candidateDepth = Math.min(firstDepth, secondDepth);
		CodeGenAnalysis firstCandidate = firstAnalysis.getAnalysisAt(candidateDepth);
		CodeGenAnalysis secondCandidate = secondAnalysis.getAnalysisAt(candidateDepth);
		while ((firstCandidate != null) && (secondCandidate != null)) {
			if (firstCandidate == secondCandidate) {
				return firstCandidate;
			}
			firstCandidate = firstCandidate.getParent();
			secondCandidate = secondCandidate.getParent();
		}
		return null;
	}

	private void findCommonSubExpressionsPrune(@NonNull CodeGenAnalysis[] analyses) {
		for (CodeGenAnalysis child : analyses) {
			List<List<CodeGenAnalysis>> hashedAnalyses = hash2nodes.get(child.getStructuralHashCode());
			if (hashedAnalyses != null) {
				for (List<CodeGenAnalysis> hashedAnalysis : hashedAnalyses) {
					hashedAnalysis.remove(child);
				}
			}
			CodeGenAnalysis[] children = child.getChildren();
			if ((children != null) && (children.length > 0)) {
				findCommonSubExpressionsPrune(children);
			}
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

	public @NonNull String getUniqueName(@NonNull TypedElement element, @NonNull String... nameHints) {
		return nameManager.getUniqueName(element, nameHints);
	}
	
	public void initialize(@NonNull CodeGenAnalysisVisitor visitor, @NonNull TypedElement element) {
		this.visitor = visitor;
//		this.rootElement = element;
		this.element2node = new HashMap<Element, CodeGenAnalysis>();
		this.hash2nodes = new HashMap<Integer, List<List<CodeGenAnalysis>>>();
		this.staticConstants = new ArrayList<CodeGenAnalysis>();
		this.localConstants = new ArrayList<CodeGenAnalysis>();
		this.nameManager = new NameManager();
		this.theseChildren = null;
		this.thisAnalysis = new CodeGenAnalysis(this, element);
		element2node.put(element, thisAnalysis);
		element.accept(visitor);
		thisAnalysis.setChildren(theseChildren);
	}

	public void optimize() {
		Map<CodeGenAnalysis, CommonSubExpression> cseMap = findCommonSubExpressions();
		for (CommonSubExpression cse : new HashSet<CommonSubExpression>(cseMap.values())) {
			cse.createVariable();
		}
	}
}
