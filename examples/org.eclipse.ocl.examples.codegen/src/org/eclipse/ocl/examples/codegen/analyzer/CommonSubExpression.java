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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.Variable;

/**
 * A CommonSubExpression provides the unifying state of the multiple analyses that are combined and possibly hoisted
 * to eliminate the redundant compuations.
 */
public class CommonSubExpression
{
	protected final @NonNull CodeGenAnalyzer analyzer;
	private final @NonNull Set<CodeGenAnalysis> analyses = new HashSet<CodeGenAnalysis>();
	private Variable variable = null;

	public CommonSubExpression(@NonNull CodeGenAnalyzer analyzer, @NonNull List<CodeGenAnalysis> analyses) {
		this.analyzer = analyzer;
		this.analyses.addAll(analyses);
	}

	public Variable createVariable() {
		Variable variable2 = DomainUtil.nonNullEMF(PivotFactory.eINSTANCE.createVariable());
		variable = variable2;
		TypedElement element = null;
		NameManager nameManager = analyzer.getNameManager();
		List<String> nameHints = new ArrayList<String>();
		for (CodeGenAnalysis analysis : analyses) {
			element = analysis.getExpression();
			String nameHint = nameManager.getNameHint(element);
			if ((nameHint != null) && !nameHints.contains(nameHint)) {
				nameHints.add(nameHint);
			}
		}
		assert element != null;
		@SuppressWarnings("null") @NonNull String[] nameHintArray = nameHints.toArray(new String[nameHints.size()]);
		String name = nameManager.getUniqueName(variable2, nameHintArray);
		variable2.setName(name);
		variable2.setType(element.getType());
		for (CodeGenAnalysis analysis : analyses) {
			analysis.setReferredCommonSubExpression(this);
		}
		return variable2;
	}

	public CodeGenAnalysis getAnalysis() {
		return analyses.iterator().next();
	}

	public Variable getVariable() {
		return variable;
	}

	@Override
	public String toString() {
		return analyses.iterator().next().toString();
	}
}
