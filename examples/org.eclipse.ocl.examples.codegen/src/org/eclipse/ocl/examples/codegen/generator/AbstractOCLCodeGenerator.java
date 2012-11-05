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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalysis;
import org.eclipse.ocl.examples.codegen.analyzer.CommonSubExpression;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.common.EmitQueries;
import org.eclipse.ocl.examples.codegen.common.NameQueries;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractOperation;
import org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryTernaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public abstract class AbstractOCLCodeGenerator implements OCLCodeGenerator
{
	public static final @NonNull String BODIES_CLASS_SUFFIX = "Bodies";
	public static final @NonNull String BODIES_PACKAGE_NAME = ".bodies";
	public static final @NonNull String TABLES_CLASS_SUFFIX = "Tables";
	public static final @NonNull String TABLES_PACKAGE_NAME = "";
	
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull NameManager nameManager;
	protected final @NonNull OCL2JavaExpressionVisitor expressionVisitor;
	protected final @NonNull Id2JavaVisitor idVisitor;
	protected final @NonNull OCL2JavaStatementVisitor statementVisitor;
	private @NonNull final ImportManager importManager = new ImportManager(EmitQueries.knownClasses);
	private /*Lazy@NonNull*/ ConstantHelper constantHelper = null;
	//
	private @NonNull Stack<StringBuilder> streamStack = new Stack<StringBuilder>();
	private @NonNull StringBuilder s = new StringBuilder();
	//
	private @NonNull Stack<String> indentationStack = new Stack<String>();
	private @NonNull String defaultIndent = "    ";
	private boolean indentPending = false;
	private @NonNull Map<Object, CodeGenSnippet> snippets = new HashMap<Object, CodeGenSnippet>();

	protected AbstractOCLCodeGenerator(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
		nameManager = new NameManager(metaModelManager);
		expressionVisitor = new OCL2JavaExpressionVisitor(this);
		idVisitor = new Id2JavaVisitor(this);
		statementVisitor = new OCL2JavaStatementVisitor(this);
	}

	protected AbstractOCLCodeGenerator(@NonNull MetaModelManager metaModelManager, @NonNull NameManager nameManager,
			@NonNull OCL2JavaExpressionVisitor expressionVisitor, @NonNull Id2JavaVisitor idVisitor, @NonNull OCL2JavaStatementVisitor statementVisitor) {
		this.metaModelManager = metaModelManager;
		this.nameManager = nameManager;
		this.expressionVisitor = expressionVisitor;
		this.idVisitor = idVisitor;
		this.statementVisitor = statementVisitor;
	}
	
	public void append(@Nullable String string) {
		if (string != null) {
			for (int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);
				if (c == '\n') {
					if (indentPending && !indentationStack.isEmpty()) {
						String indentation = indentationStack.peek();
						boolean isWhite = true;
						for (int j = 0; j < indentation.length(); j++) {
							if (!Character.isWhitespace(indentation.charAt(j))) {
								isWhite = false;
								break;
							}
						}
						if (!isWhite) {
							s.append(indentation);
						}
					}
					s.append(c);
					indentPending = true;
				}
				else {
					if (indentPending) {
						indentPending = false;
						if (!indentationStack.isEmpty()) {
							s.append(indentationStack.peek());
						}
					}
					s.append(c);
				}
			}
		}
	}
	
	public void append(@NonNull CodeGenSnippet aSnippet) {
		for (Object content : aSnippet.getContents()) {
			if (content instanceof String) {
				append((String)content);
			}
			else if (content instanceof CodeGenSnippet){
				append((CodeGenSnippet)content);
			}
		}
	}

	public @NonNull String atNonNull() {
		return importManager.getImportedName("@NonNull");
	}

	public @NonNull String atNullable() {
		return importManager.getImportedName("@Nullable");
	}

	protected @NonNull ConstantHelper createConstantHelper() {
		return new ConstantHelper(this);
	}
	
	public @NonNull Class<?> getAbstractOperationClass(@NonNull List<? extends TypedElement> parameters) {
		switch (parameters.size()) {
			case 0: return AbstractUnaryOperation.class;
			case 1: return AbstractBinaryOperation.class;
			case 2: return AbstractTernaryOperation.class;
			default: return AbstractOperation.class;
		}
	}

	protected @NonNull Collection<String> getAllImports() {
		return importManager.getAllImports();
	}

	public @NonNull ConstantHelper getConstantHelper() {
		ConstantHelper constantHelper2 = constantHelper;
		if (constantHelper2 == null) {
			constantHelper = constantHelper2 = createConstantHelper();
		}
		return constantHelper2;
	}

	public @NonNull String getDefaultIndent() {
		return defaultIndent;
	}

	public @NonNull String getDefiningText(@NonNull TypedElement element) {
		CodeGenAnalysis analysis = getAnalysis(element);
		if (analysis.isInlineable()) {
			return expressionVisitor.visit(element);
		}
		VariableDeclaration referredVariable = null;
		CommonSubExpression referredCommonSubExpression = analysis.getReferredCommonSubExpression();
		if (referredCommonSubExpression != null) {
			referredVariable = referredCommonSubExpression.getVariable();
		}
		else if (element instanceof VariableExp) {
			referredVariable = ((VariableExp)element).getReferredVariable();
		}
		if (referredVariable == null) {
			return expressionVisitor.visit(element);
		}
		else {
			return expressionVisitor.visit(referredVariable);
		}
	}
	
	public @NonNull OCL2JavaExpressionVisitor getExpressionVisitor() {
		return expressionVisitor;
	}

	protected @Nullable GenPackage getGenPackage(@NonNull Type type) {
		org.eclipse.ocl.examples.pivot.Package pPackage = type.getPackage();
		if (pPackage == null) {
			return null;
		}
		String nsURI = pPackage.getNsURI();
		if (nsURI == null) {
			return null;
		}
		return metaModelManager.getGenPackage(nsURI);
	}

	public @NonNull Id2JavaVisitor getIdVisitor() {
		return idVisitor;
	}

	public @NonNull String getImportedName(@NonNull String className) {
		return importManager.getImportedName(className);
	}
	
	@SuppressWarnings("null")
	public @NonNull String getImportedName(@NonNull Class<?> className) {
		return importManager.getImportedName(className.getName());
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	public @NonNull NameManager getNameManager() {
		return nameManager;
	}

	public @NonNull Class<?> getOperationInterface(@NonNull List<? extends TypedElement> parameters) {
		switch (parameters.size()) {
			case 0: return LibraryUnaryOperation.class;
			case 1: return LibraryBinaryOperation.class;
			case 2: return LibraryTernaryOperation.class;
			default: return LibraryOperation.class;
		}
	}

	public @Nullable String getQualifiedOperationImplementationName(@NonNull Operation anOperation, @NonNull String stereotype) {
		Type type = anOperation.getOwningType();
		if (type != null) {
			GenPackage genPackage = getGenPackage(type);
			if (genPackage != null) {
				String qualifiedPackageName = genPackage.getQualifiedPackageName() + BODIES_PACKAGE_NAME;
				String outerClassName = type.getName() + BODIES_CLASS_SUFFIX;
				String qualifiedClassName = getImportedName(qualifiedPackageName) + "." + outerClassName;
				String innerClassName = "_" + anOperation.getName() + "_" + stereotype + "_";
				return qualifiedClassName + "." + innerClassName + ".INSTANCE";
			}
		}
		return null;
	}

	public @Nullable String getQualifiedPropertyImplementationName(@NonNull Property aProperty, @NonNull String stereotype) {
		Type type = aProperty.getOwningType();
		if (type != null) {
			GenPackage genPackage = getGenPackage(type);
			if (genPackage != null) {
				String qualifiedPackageName = genPackage.getQualifiedPackageName() + BODIES_PACKAGE_NAME;
				String outerClassName = type.getName() + BODIES_CLASS_SUFFIX;
				String qualifiedClassName = getImportedName(qualifiedPackageName) + "." + outerClassName;
				String innerClassName = "_" + aProperty.getName() + "_" + stereotype + "_";
				return qualifiedClassName + "." + innerClassName + ".INSTANCE";
			}
		}
		return null;
	}

	public @Nullable String getQualifiedLiteralName(@NonNull Operation anOperation) {
		Type type = anOperation.getOwningType();
		if (type != null) {
			GenPackage genPackage = getGenPackage(type);
			if (genPackage != null) {
				String qualifiedPackageName = genPackage.getQualifiedPackageName() + TABLES_PACKAGE_NAME;
				String tablesClassName = genPackage.getPrefix() + TABLES_CLASS_SUFFIX;
				String qualifiedClassName = getImportedName(qualifiedPackageName + "." + tablesClassName) + ".Operations";
				String operationName = "_" + type.getName() + "__" + NameQueries.encodeName(anOperation);
				return qualifiedClassName + "." + operationName;
			}
		}
		return null;
	}

	public @Nullable String getQualifiedLiteralName(@NonNull Property aProperty) {
		Type type = aProperty.getOwningType();
		if (type != null) {
			GenPackage genPackage = getGenPackage(type);
			if (genPackage != null) {
				String qualifiedPackageName = genPackage.getQualifiedPackageName() + TABLES_PACKAGE_NAME;
				String tablesClassName = genPackage.getPrefix() + TABLES_CLASS_SUFFIX;
				String qualifiedClassName = getImportedName(qualifiedPackageName + "." + tablesClassName) + ".Properties";
				String operationName = "_" + type.getName() + "__" + NameQueries.encodeName(aProperty);
				return qualifiedClassName + "." + operationName;
			}
		}
		return null;
	}

	public @NonNull String getReferringText(@NonNull CodeGenSnippet referringSnippet, @NonNull TypedElement element) {			// FIXME simplify
		CodeGenAnalysis analysis = getAnalysis(element);
		if (analysis.isConstant()) {
			if (analysis.isInlineable()) {
				return expressionVisitor.visit(element);
			}
			else {
				Object constantValue = analysis.getConstantValue();
				assert constantValue != null;
				CodeGenSnippet constantSnippet = getConstant(constantValue);
				referringSnippet.addDependsOn(constantSnippet);
				return constantSnippet.getName();
			}
		}
		if (analysis.isInlineable()) {
			return expressionVisitor.visit(element);
		}
		VariableDeclaration referredVariable = null;
		CommonSubExpression referredCommonSubExpression = analysis.getReferredCommonSubExpression();
		if (referredCommonSubExpression != null) {
			referredVariable = referredCommonSubExpression.getVariable();
			return referredCommonSubExpression.getSymbolName();
		}
		else if (element instanceof TypeExp) {
			return getSymbolName(element.getType());
		}
		else if (element instanceof VariableExp) {
			referredVariable = ((VariableExp)element).getReferredVariable();
		}
		if (referredVariable == null) {
			return getSymbolName(element);
		}
		else {
			return expressionVisitor.visit(referredVariable);
		}
	}
	
	public @NonNull CodeGenSnippet getSnippet(@NonNull Object element) {
		CodeGenSnippet snippet = snippets.get(element);
		if (snippet == null) {
			snippet = new CodeGenSnippet(this, element);
			snippets.put(element, snippet);
		}
		return snippet;
	}

	@SuppressWarnings("null")
	protected @NonNull String getString() {
		return s.toString();
	}

	protected @NonNull String getSymbolName(@Nullable Object element, @Nullable String... nameHints) {
		return element != null ? nameManager.getSymbolName(element, nameHints) : "null";
	}

	public @NonNull String getTypeName(@NonNull Type type) {
		String displayName = type.getTypeId().getDisplayName();
		return getImportedName(displayName);
	}
	
	public void popIndentation() {
		if (!indentationStack.isEmpty()) {
			indentationStack.pop();
		}
	}

	@SuppressWarnings("null")
	protected @NonNull String popStream() {
		String str = getString();
		s = streamStack.pop();
		indentationStack.pop();
		return str;
	}

	public void pushIndentation() {
		pushIndentation(defaultIndent);
	}

	public void pushIndentation(@NonNull String moreIndentation) {
		if (indentationStack.isEmpty()) {
			indentationStack.push(moreIndentation);
		}
		else {
			indentationStack.push(indentationStack.peek() + moreIndentation);
		}
	}

	protected void pushStream() {
		indentationStack.push("");
		streamStack.push(s);
		s = new StringBuilder();
	}
	
	public void setSnippet(@NonNull Element element, @NonNull CodeGenSnippet snippet) {
		snippets.put(element, snippet);
	}
}
