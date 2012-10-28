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

	private Map<String, NamedElement> name2element = null;		// User of each name, null if name ambiguous
	private Map<NamedElement, String> element2name = null;		// Unambiguous name for each element, null if not determined
	private Map<String, Integer> name2counter = null;			// Auto-generation counter for each name
	
	public NameManager() {}
	
	public void addNamedElement(@NonNull NamedElement namedElement) {
		if (name2element == null) {
			name2element = new HashMap<String, NamedElement>();
			element2name = new HashMap<NamedElement, String>();
		}
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

	public @NonNull String getUniqueName(@NonNull TypedElement element, @Nullable String... nameHints) {
		if (name2element == null) {
			name2element = new HashMap<String, NamedElement>();
			element2name = new HashMap<NamedElement, String>();
		}
		String knownName = element2name.get(element);
		if (knownName != null) {
			return knownName;
		}
		String lastResort = null;
		if (nameHints != null) {
			for (String nameHint : nameHints) {
				if ((nameHint != null) && !reservedNames.contains(nameHint)) {
					Element oldElement = name2element.get(nameHint);
					if (oldElement == element) {
						return nameHint;
					}
					if (oldElement == null) {
						install(nameHint, element);
						return nameHint;
					}
					if (lastResort == null) {
						lastResort = nameHint;
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

	private void install(@NonNull String name, @NonNull TypedElement element) {
		name2element.put(name, element);
		element2name.put(element, name);
	}

	public void reserveName(@NonNull String name, @Nullable NamedElement namedElement) {
		NamedElement oldElement = name2element.put(name, namedElement);
		assert oldElement == null;
	}
}
