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
package org.eclipse.ocl.examples.codegen.analyzer;

import java.util.Collection;
import java.util.List;
import java.util.Stack;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.common.EmitQueries;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractOperation;
import org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryTernaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public abstract class AbstractOCLCodeGenerator implements OCLCodeGenerator
{
	public static final @NonNull String BODIES_CLASS_SUFFIX = "Bodies";
	public static final @NonNull String BODIES_PACKAGE_NAME = "bodies";
	
	protected final @NonNull MetaModelManager metaModelManager;
	private @NonNull final ImportManager importManager = new ImportManager(EmitQueries.knownClasses);
	//
	private @NonNull Stack<StringBuilder> streamStack = new Stack<StringBuilder>();
	private @NonNull StringBuilder s = new StringBuilder();
	//
	private @NonNull Stack<String> indentationStack = new Stack<String>();
	private @NonNull String defaultIndent = "    ";
	private boolean indentPending = false;

	protected AbstractOCLCodeGenerator(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
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

	public @NonNull String atNonNull() {
		return importManager.getImportedName("@NonNull");
	}

	public @NonNull String atNullable() {
		return importManager.getImportedName("@Nullable");
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

	public @NonNull String getBodiesClassSuffix() {
		return BODIES_CLASS_SUFFIX;
	}

	public @NonNull String getBodiesPackageName() {
		return BODIES_PACKAGE_NAME;
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

	public @NonNull Class<?> getOperationInterface(@NonNull List<? extends TypedElement> parameters) {
		switch (parameters.size()) {
			case 0: return LibraryUnaryOperation.class;
			case 1: return LibraryBinaryOperation.class;
			case 2: return LibraryTernaryOperation.class;
			default: return LibraryOperation.class;
		}
	}

	@SuppressWarnings("null")
	protected @NonNull String getString() {
		return s.toString();
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
		streamStack.push(s);
		s = new StringBuilder();
	}
}
