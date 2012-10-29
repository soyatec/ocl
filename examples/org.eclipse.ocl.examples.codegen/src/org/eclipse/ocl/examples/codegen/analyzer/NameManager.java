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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.TypedElement;

/**
 * A CodeGenAnalyzer performs the analysis of a Pivot AST in preparation for code generation.
 */
public class NameManager
{
	/**
	 * Names that will not be allocated to temporary variables.
	 * <p>
	 * This Set is public and unsynchronized. Clients may change it in arbitrary ways at their own risk.
	 * <p>
	 * It is strongly recommended that clients do no more than add additional names.
	 */
	public static final Set<String> reservedJavaNames = new HashSet<String>();
	{
		reservedJavaNames.add("Boolean");
		reservedJavaNames.add("Character");
		reservedJavaNames.add("Class");
		reservedJavaNames.add("Double");
		reservedJavaNames.add("Float");
		reservedJavaNames.add("Integer");
		reservedJavaNames.add("List");
		reservedJavaNames.add("Long");
		reservedJavaNames.add("Map");
		reservedJavaNames.add("Package");
		reservedJavaNames.add("String");
		
		reservedJavaNames.add("boolean");
		reservedJavaNames.add("byte");
		reservedJavaNames.add("char");
		reservedJavaNames.add("double");
		reservedJavaNames.add("float");
		reservedJavaNames.add("int");
		reservedJavaNames.add("long");
		reservedJavaNames.add("short");
		reservedJavaNames.add("void");
		
		reservedJavaNames.add("abstract");
		reservedJavaNames.add("assert");
		reservedJavaNames.add("break");
		reservedJavaNames.add("case");
		reservedJavaNames.add("catch");
		reservedJavaNames.add("class");
		reservedJavaNames.add("const");
		reservedJavaNames.add("continue");
		reservedJavaNames.add("default");
		reservedJavaNames.add("do");
		reservedJavaNames.add("else");
		reservedJavaNames.add("enum");
		reservedJavaNames.add("extends");
		reservedJavaNames.add("final");
		reservedJavaNames.add("finally");
		reservedJavaNames.add("for");
		reservedJavaNames.add("goto");
		reservedJavaNames.add("if");
		reservedJavaNames.add("implements");
		reservedJavaNames.add("import");
		reservedJavaNames.add("instanceof");
		reservedJavaNames.add("interface");
		reservedJavaNames.add("native");
		reservedJavaNames.add("new");
		reservedJavaNames.add("package");
		reservedJavaNames.add("private");
		reservedJavaNames.add("protected");
		reservedJavaNames.add("public");
		reservedJavaNames.add("return");
		reservedJavaNames.add("static");
		reservedJavaNames.add("strictfp");
		reservedJavaNames.add("switch");
		reservedJavaNames.add("synchronized");
		reservedJavaNames.add("throw");
		reservedJavaNames.add("throws");
		reservedJavaNames.add("transient");
		reservedJavaNames.add("try");
		reservedJavaNames.add("volatile");
		reservedJavaNames.add("while");

		reservedJavaNames.add("false");
		reservedJavaNames.add("null");
		reservedJavaNames.add("super");
		reservedJavaNames.add("this");
		reservedJavaNames.add("true");
	}

	protected static void appendJavaCharacters(StringBuilder s, String string) {
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (Character.isJavaIdentifierPart(c)) {
				s.append(c);
			}
			else {
				s.append('_');
			}
		}
	}

	protected static void appendJavaCharacters(StringBuilder s, String string, int iMax) {
		for (int i = 0; i < Math.min(iMax, string.length()); i++) {
			char c = string.charAt(i);
			if (Character.isJavaIdentifierPart(c)) {
				s.append(c);
			}
			else {
				s.append('_');
			}
		}
	}

	private final Map<String, NamedElement> name2element = new HashMap<String, NamedElement>();		// User of each name, null if name ambiguous
	private final Map<NamedElement, String> element2name = new HashMap<NamedElement, String>();		// Unambiguous name for each element, null if not determined
	private Map<String, Integer> name2counter = null;												// Auto-generation counter for each colliding name

	public void addNamedElement(@NonNull NamedElement namedElement) {
		String name = namedElement.getName();
		if (name != null) {
			NamedElement oldNamedElement = name2element.get(name);
			if (oldNamedElement == null) {
				if (name2element.containsKey(name)) {		// Existing ambiguity
					name = null;
				}
				else {										// New name
					name2element.put(name, namedElement);
				}
				name2element.put(name, namedElement);
			}
			else {
				if (oldNamedElement != namedElement) {
					name2element.put(name, null);			// New ambiguity
					name = null;
				}
				else {}										// Compatible redefinition
			}
		}
		element2name.put(namedElement, name);
	}

	public @NonNull String getSymbolName(@NonNull TypedElement element, @Nullable String... nameHints) {
		return getUniqueName(element, nameHints);
	}

	public @NonNull String getUniqueName(@Nullable TypedElement element, @Nullable String... nameHints) {
		if (element != null) {
			String knownName = element2name.get(element);
			if (knownName != null) {
				return knownName;
			}
		}
		String lastResort = null;
		if (nameHints != null) {
			for (String nameHint : nameHints) {
				if (nameHint != null)  {
					String validHint = getValidJavaIdentifier(nameHint);
					if (!reservedJavaNames.contains(validHint)) {
						if (element != null) {
							Element oldElement = name2element.get(validHint);
							if (oldElement == element) {
								return validHint;
							}
							if (oldElement == null) {
								install(validHint, element);
								return validHint;
							}
						}
						else {
							if (!name2element.containsKey(validHint)) {
								install(validHint, element);
								return validHint;
							}
						}
						if (lastResort == null) {
							lastResort = validHint;
						}
					}
				}
			}
		}
		if (lastResort == null) {
			lastResort = "symbol";
		}
		if (name2counter == null) {
			name2counter = new HashMap<String, Integer>();
		}
		Integer counter = name2counter.get(lastResort);
		int count = counter != null ? counter : 0;			
		for ( ; true; count++) {
			String attempt = lastResort + "_" + Integer.toString(count);
			if (!name2element.containsKey(attempt)) {		// Assumes that reserved names do not end in _ count
				install(attempt, element);
				name2counter.put(lastResort, ++count);
				return attempt;
			}
		}
	}

	private @NonNull String getValidJavaIdentifier(@NonNull String nameHint) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < nameHint.length(); i++) {
			char c = nameHint.charAt(i);
			if (Character.isJavaIdentifierPart(c)) {
				s.append(c);
			}
			else if (c == '=') {
				s.append("_eq_");
			}
			else if (c == '+') {
				s.append("_pl_");
			}
			else if (c == '-') {
				s.append("_mi_");
			}
			else if (c == '/') {
				s.append("_sl_");
			}
			else if (c == '*') {
				s.append("_as_");
			}
			else if (c == '<') {
				s.append("_lt_");
			}
			else if (c == '>') {
				s.append("_gt_");
			}
			else {
				s.append('_');
			}
		}
		@SuppressWarnings("null") @NonNull String string = s.toString();
		return string;
	}
	
	private void install(@NonNull String name, @Nullable TypedElement element) {
		name2element.put(name, element);
		if (element != null) {
			element2name.put(element, name);
		}
	}

	public @NonNull String reserveName(@NonNull String name, @Nullable TypedElement element) {
		String validJavaIdentifier = getUniqueName(element, getValidJavaIdentifier(name));
		NamedElement oldElement = name2element.put(validJavaIdentifier, element);
		assert (oldElement == null) || (oldElement == element);
		return validJavaIdentifier;
	}
}
