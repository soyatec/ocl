/**
 * <copyright>
 *
 * Copyright (c) 2011,2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 **/
package org.eclipse.ocl.examples.codegen.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.FinalAnalysis;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.Visitor;

public abstract class AbstractCodeGenerator implements CodeGenerator
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull NameManager nameManager;
	protected final @NonNull ConstantHelper constantHelper;
	protected final @NonNull GenModelHelper genModelHelper;
	protected final @NonNull ImportManager importManager;
	protected final @NonNull IdVisitor<CodeGenSnippet> idVisitor;
	protected final @NonNull Visitor<CodeGenSnippet> astVisitor;
	protected final @NonNull CodeGenOptions options = new CodeGenOptions();
	//
	private /*@LazyNonNull*/ List<Exception> problems = null;
	private @NonNull String defaultIndent = "    ";
	private @NonNull Map<Object, CodeGenSnippet> snippets = new HashMap<Object, CodeGenSnippet>();
	private @NonNull Map<String, CodeGenLabel> labels = new HashMap<String, CodeGenLabel>();

	protected AbstractCodeGenerator(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
		this.nameManager = createNameManager();
		this.constantHelper = createConstantHelper();
		this.importManager = createImportManager();
		this.genModelHelper = createGenModelHelper();
		this.idVisitor = createId2SnippetVisitor();
		this.astVisitor = createAST2SnippetVisitor();
	}

	protected AbstractCodeGenerator(@NonNull MetaModelManager metaModelManager, @NonNull NameManager nameManager, @NonNull ConstantHelper constantHelper,
			@NonNull ImportManager importManager, @NonNull GenModelHelper genModelHelper, 
			@NonNull IdVisitor<CodeGenSnippet> idVisitor, @NonNull Visitor<CodeGenSnippet> astVisitor) {
		this.metaModelManager = metaModelManager;
		this.nameManager = nameManager;
		this.constantHelper = constantHelper;
		this.importManager = importManager;
		this.genModelHelper = genModelHelper;
		this.idVisitor = idVisitor;
		this.astVisitor = astVisitor;
	}

	public void addDependency(@NonNull String onLabel, @NonNull CodeGenSnippet snippet) {
		CodeGenLabel cgLabel = getSnippetLabel(onLabel);
		cgLabel.addDependency(snippet);
	}
	
	public void addProblem(@NonNull Exception problem) {
		List<Exception> problems2 = problems;
		if (problems2 == null) {
			problems = problems2 = new ArrayList<Exception>();
		}
		problems2.add(problem);
	}

	public @NonNull String atNonNull2() {
		return importManager.getImportedName(NonNull.class, true);
	}

	public @NonNull String atNullable2() {
		return importManager.getImportedName(Nullable.class, true);
	}

	protected abstract @NonNull Visitor<CodeGenSnippet> createAST2SnippetVisitor();

	protected abstract @NonNull ConstantHelper createConstantHelper();

	protected abstract @NonNull IdVisitor<CodeGenSnippet> createId2SnippetVisitor();

	protected abstract @NonNull GenModelHelper createGenModelHelper();

	protected @NonNull CodeGenLabel createLabel(@NonNull String label) {
		return new AbstractCodeGenLabel(label);
	}

	protected abstract @NonNull ImportManager createImportManager();

	protected abstract @NonNull NameManager createNameManager();

	protected @NonNull Collection<String> getAllImports() {
		return importManager.getAllImports();
	}

	public @NonNull ConstantHelper getConstantHelper() {
		return constantHelper;
	}

	public @NonNull String getDefaultIndent() {
		return defaultIndent;
	}

	public @NonNull GenModelHelper getGenModelHelper() {
		return genModelHelper;
	}

	public @NonNull IdVisitor<CodeGenSnippet> getIdVisitor() {
		return idVisitor;
	}

	public @NonNull ImportManager getImportManager() {
		return importManager;
	}
	
	public @NonNull String getImportedName2(@NonNull Class<?> className) {
		return importManager.getImportedName(className, false);
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	public @NonNull NameManager getNameManager() {
		return nameManager;
	}

	public @NonNull CodeGenOptions getOptions() {
		return options;
	}
	
	public @NonNull CodeGenSnippet getSnippet(@Nullable Object anObject) {
		if ((anObject instanceof RealValue) && !(anObject instanceof UnlimitedValue)) {			// exclude unlimited, (null), invalid
			anObject = ((RealValue)anObject).asNumber();				// Integer and Real may have distinct constants.
		}
		CodeGenSnippet snippet = snippets.get(anObject);
		if (snippet == null) {
			if (anObject instanceof Element) {
				Element element = (Element)anObject;
				CodeGenAnalysis analysis = getAnalysis(element);
				if (analysis.isInvalid()) {
					return getSnippet(analysis.getConstantValue());
				}
				else {
					snippet = element.accept(astVisitor);
					assert snippet != null;
				}
			}
			else if (anObject instanceof ElementId) {
				snippet = ((ElementId)anObject).accept(idVisitor);
				assert snippet != null;
				addDependency(GLOBAL_ROOT, snippet);
			}
			else {
				snippet = constantHelper.createSnippet(anObject);
			}
			snippets.put(anObject, snippet);
		}
		return snippet;
	}
	
	public @NonNull CodeGenSnippet getSnippet(@Nullable Object anObject, boolean asCaught, boolean asBoxed) {
		CodeGenSnippet originalSnippet = getSnippet(anObject);
		CodeGenSnippet caughtSnippet = asCaught ? originalSnippet.getCaughtSnippet() : originalSnippet.getThrownSnippet();
		CodeGenSnippet boxedSnippet = asBoxed ? caughtSnippet.getBoxedSnippet() : caughtSnippet.getUnboxedSnippet();
		boolean asFinal = false;		// FIXME compute from label stack equality
		CodeGenSnippet finalSnippet = asFinal ? boxedSnippet.getFinalSnippet() : boxedSnippet;
		return finalSnippet;
	}

	public @NonNull CodeGenLabel getSnippetLabel(@NonNull String label) {
		CodeGenLabel cgLabel = labels.get(label);
		if (cgLabel == null) {
			cgLabel = createLabel(label);
			labels.put(label, cgLabel);
		}
		return cgLabel;
	}

	public @NonNull String getTypeName(@NonNull Type type) {
		String displayName = type.getTypeId().getDisplayName();
		return importManager.getImportedName(displayName);
	}

	public @Nullable DomainOperation isFinal(@NonNull Operation anOperation, @NonNull Type staticType) {
		FinalAnalysis finalAnalysis = metaModelManager.getPackageManager().getFinalAnalysis();
		return finalAnalysis.isFinal(anOperation, metaModelManager.getInheritance(staticType));
	}

	/**
	 * Return true if anOperation has an overload for invalid values.
	 */
	public boolean mayEvaluateForInvalid(@NonNull Operation anOperation) {
		Type targetType = metaModelManager.getOclInvalidType();
		String name = anOperation.getName();
		if (name == null) {
			return false;
		}
		DomainInheritance inheritance = targetType.getInheritance(metaModelManager);
		DomainInheritance[] arguments;
		List<Parameter> parameters = anOperation.getOwnedParameter();
		int iSize = parameters.size();
		if (iSize > 0) {
			arguments = new DomainInheritance[iSize];
			for (int i = 0; i < iSize; i++) {
				Parameter parameter = parameters.get(i);
				Type type = parameter.getType();
				if (type == null) {
					return false;
				}
				if (type.getOwningTemplateParameter() != null) {
					return false;					// FIXME invalid not supported for templated operations
				}
				arguments[i] = type.getInheritance(metaModelManager);
			}
		}
		else {
			arguments = DomainInheritance.EMPTY_ARRAY;
		}
		DomainOperation localOperation = inheritance.lookupLocalOperation(metaModelManager, name, arguments);
		return localOperation != null;
	}
	
	public void setSnippet(@NonNull Element element, @NonNull CodeGenSnippet snippet) {
		snippets.put(element, snippet);
	}
}
