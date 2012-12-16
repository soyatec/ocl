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
import org.eclipse.ocl.examples.codegen.generator.ConstantHelper;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * A CodeGenAnalyzer performs the analysis of a Pivot AST in preparation for code generation.
 */
public class CodeGenAnalyzer
{	
	protected final @NonNull CodeGenerator codeGenerator;
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull NameManager nameManager;
	protected final @NonNull CodeGenAnalysisVisitor visitor;
//	protected final @NonNull TypedElement rootElement;
	protected final @NonNull Map<Element, CodeGenAnalysis> element2node = new HashMap<Element, CodeGenAnalysis>();
	private /*Lazy@NonNull*/ ConstantHelper constantHelper = null;
	// Current context during tree traversal, final state is the root analysis
	private CodeGenAnalysis thisAnalysis = null;
	private List<CodeGenAnalysis> theseChildren = null;
	
	public CodeGenAnalyzer(@NonNull CodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
		this.metaModelManager = codeGenerator.getMetaModelManager();
		this.nameManager = codeGenerator.getNameManager();
		this.visitor = new CodeGenAnalysisVisitor(this);
//		this.rootElement = element;
//		this.thisAnalysis = new CodeGenAnalysis(this, element);
	}

//	public void addNamedElement(@Nullable NamedElement namedElement) {
//		if (namedElement != null) {
//			nameManager.addNamedElement(namedElement);
//		}
//	}

	public @NonNull CodeGenAnalysis analyze(@NonNull TypedElement rootElement, boolean isRequired) {
		CodeGenAnalysis rootAnalysis = new CodeGenAnalysis(this, rootElement, isRequired);
		thisAnalysis = rootAnalysis;
		element2node.put(rootElement, thisAnalysis);
		rootElement.accept(visitor);
		thisAnalysis.initChildren(theseChildren);
		return rootAnalysis;
	}
	
	/**
	 * The descent pushes the current analysis and children, then creates a new analysis for the visit.
	 * On completion of the visit, the children are installed and the former analysis and children are popped.
	 * 
	 * @param element to be visited, which may (but should not) be null
	 * @return the elemental analysis or null if a null element
	 */
	protected @NonNull CodeGenAnalysis descend(@NonNull Element element) {
		CodeGenAnalysis thisAnalysis2 = thisAnalysis;
		assert thisAnalysis2 != null;
		@NonNull CodeGenAnalysis savedAnalysis = thisAnalysis2;
		@Nullable List<CodeGenAnalysis> savedChildren = theseChildren;
		try {
			thisAnalysis = thisAnalysis2 = new CodeGenAnalysis(thisAnalysis2, element);
			theseChildren = null;
			CodeGenAnalysis oldAnalysis = element2node.put(element, thisAnalysis2);
			assert oldAnalysis == null;
			CodeGenAnalysisVisitor visitor2 = visitor;
			assert visitor2 != null;
			element.accept(visitor2);
			return thisAnalysis2;
		}
		finally {
			if (theseChildren != null) {
				for (CodeGenAnalysis child : theseChildren) {
					thisAnalysis2.addDependencies(child.getDirectDependencies());
				}
			}
			thisAnalysis.initChildren(theseChildren);
			theseChildren = savedChildren;
			List<CodeGenAnalysis> theseChildren2 = theseChildren;
			if (theseChildren2 == null) {
				theseChildren = theseChildren2 = new ArrayList<CodeGenAnalysis>();
			}
			theseChildren2.add(thisAnalysis2);
			thisAnalysis = savedAnalysis;
		}
	}

	public @Nullable CodeGenAnalysis findAnalysis(@NonNull Element element) {
		return element2node.get(element);
	}

	public @NonNull CodeGenAnalysis getAnalysis(@NonNull Element element) {
		CodeGenAnalysis analysis = element2node.get(element);
		if (analysis == null) {
			throw new IllegalStateException("No analysis of " + element);
		}
		return analysis;
	}

	public @NonNull CodeGenerator getCodeGenerator() {
		return codeGenerator;
	}

	public @NonNull ConstantHelper getConstantHelper() {
		ConstantHelper constantHelper2 = constantHelper;
		if (constantHelper2 == null) {
			constantHelper = constantHelper2 = codeGenerator.getConstantHelper();
		}
		return constantHelper2;
	}

	public @NonNull CodeGenAnalysis getCurrentAnalysis() {
		return DomainUtil.nonNullState(thisAnalysis);
	}

	public @Nullable List<CodeGenAnalysis> getCurrentChildren() {
		return theseChildren;
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	public @NonNull NameManager getNameManager() {
		return DomainUtil.nonNullState(nameManager);
	}

	public void optimize(@NonNull CodeGenAnalysis rootAnalysis) {
		ConstantFolder constantFolder = new ConstantFolder(this, rootAnalysis, null);
		constantFolder.optimize();
//		CommonSubExpressionEliminator commonSubExpressionEliminator = new CommonSubExpressionEliminator(this, rootAnalysis);
//		commonSubExpressionEliminator.optimize();
		FieldingAnalyzer fieldingAnalyzer = new FieldingAnalyzer(this, rootAnalysis);
		fieldingAnalyzer.analyze();
	}
}
