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

import org.eclipse.jdt.annotation.NonNull;

/**
 * A CommonSubExpressionEliminator annotates the structurally equivalent analysis nodes in an analyzed tree with CommonSubExpression instances that
 * unify and potentially hoist their computations.
 */
public class CommonSubExpressionEliminator
{	
	protected final @NonNull CodeGenAnalyzer analyzer;
	protected final @NonNull CodeGenAnalysis rootAnalysis;
	/**
	 * Map from structural hash code to same-hashed analysis in the analysis tree rooted at rootAnalysis.
	 * <p>
	 * Since not all same-hashed analyses are actually equal there may be multiple lists per hash, each list corresponding
	 * to a distinct list of structurally equal analyses.
	 */
	protected final @NonNull Map<Integer, List<List<CodeGenAnalysis>>> hash2nodes;
	/**
	 * Map from analysis to its structural hash code.
	 */
//	protected final @NonNull Map<CodeGenAnalysis, Integer> node2hash;
	
	public CommonSubExpressionEliminator(@NonNull CodeGenAnalyzer analyzer, @NonNull CodeGenAnalysis rootAnalysis) {
		this.analyzer = analyzer;
		this.rootAnalysis = rootAnalysis;
		this.hash2nodes = new HashMap<Integer, List<List<CodeGenAnalysis>>>();
//		this.node2hash = new HashMap<CodeGenAnalysis, Integer>();
	}
	
	/**
	 * Populate the map from structural hash code to same-hashed analysis in the analysis tree rooted at thisAnalysis.
	 * <p>
	 * Returns the structural hash code of thisAnalysis.
	 */
	protected int buildHashedNodeMap(@NonNull CodeGenAnalysis thisAnalysis) {
		int structuralHashCode = thisAnalysis.getExpression().getClass().hashCode();
		structuralHashCode += thisAnalysis.getLocalStructuralHashCode();
		CodeGenAnalysis[] childAnalyses = thisAnalysis.getChildren();
		if (childAnalyses != null) {
			for (CodeGenAnalysis childAnalysis : childAnalyses) {
				assert childAnalysis != null;
				int childHash = buildHashedNodeMap(childAnalysis);
				structuralHashCode = 3 * structuralHashCode + childHash;
			}
		}
		List<List<CodeGenAnalysis>> hashedAnalyses = hash2nodes.get(structuralHashCode);
		if (hashedAnalyses == null) {
			hashedAnalyses = new ArrayList<List<CodeGenAnalysis>>();
			hash2nodes.put(structuralHashCode, hashedAnalyses);
		}
		boolean gotIt = false;
		for (List<CodeGenAnalysis> hashedAnalysis : hashedAnalyses) {
			CodeGenAnalysis anAnalysis = hashedAnalysis.get(0);
			assert anAnalysis != null;
			if (thisAnalysis.isStructurallyEqualTo(anAnalysis)) {
				if (!hashedAnalyses.contains(thisAnalysis)) {
					hashedAnalysis.add(thisAnalysis);
				}
				gotIt = true;
				break;
			}
		}
		if (!gotIt) {
			List<CodeGenAnalysis> hashedAnalysis = new ArrayList<CodeGenAnalysis>();
			hashedAnalyses.add(hashedAnalysis);
			hashedAnalysis.add(thisAnalysis);
		}
		thisAnalysis.initStructuralHashCode(structuralHashCode);
		return structuralHashCode;
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
				if (!analysis.isConstant() && !analysis.isInvalid() && ((iSize > 1) /*|| analysis.isConstant()*/)) {
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
			if (!candidate0.isConstant() && ((iSize > 1) /*|| candidate0.isConstant()*/)) {
				CommonSubExpression cse = new CommonSubExpression(analyzer, candidate);
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

	/**
	 * Return the deepest analysis of which both firstAnalysis and secondAnalysis are self or descendants.
	 * <p>
	 * Returns null if firstAnalysis and secondAnalysis are from distinct trees.
	 */
	protected CodeGenAnalysis findCommonNode(@NonNull CodeGenAnalysis firstAnalysis, @NonNull CodeGenAnalysis secondAnalysis) {
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

	protected void findCommonSubExpressionsPrune(@NonNull CodeGenAnalysis[] analyses) {
		for (CodeGenAnalysis analysis : analyses) {
			int structuralHashCode = analysis.getStructuralHashCode();
			List<List<CodeGenAnalysis>> equivalentAnalyses = hash2nodes.get(structuralHashCode);
			if (equivalentAnalyses != null) {
				for (List<CodeGenAnalysis> equivalentAnalysis : equivalentAnalyses) {
					equivalentAnalysis.remove(analysis);
				}
			}
			CodeGenAnalysis[] children = analysis.getChildren();
			if ((children != null) && (children.length > 0)) {
				findCommonSubExpressionsPrune(children);
			}
		}
	}

	/**
	 * Optimize the rootAnalysis tree by eliminating common subexpressions.
	 */
	public void optimize() {
		buildHashedNodeMap(rootAnalysis);
		Map<CodeGenAnalysis, CommonSubExpression> cseMap = findCommonSubExpressions();
		for (CommonSubExpression cse : new HashSet<CommonSubExpression>(cseMap.values())) {
			cse.createVariable();
		}
	}
}
