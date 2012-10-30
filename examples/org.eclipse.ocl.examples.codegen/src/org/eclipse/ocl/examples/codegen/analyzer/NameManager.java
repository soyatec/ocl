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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.LiteralExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.Nameable;

/**
 * A NameManager provides suggestions for names and maintains caches of used names so that model elements are consistently
 * named without collisions. 
 */
public class NameManager
{
	public static final String DEFAULT_NAME_PREFIX = "symbol";
	public static final String INTEGER_NAME_HINT_PREFIX = "I_";
	public static final String OPERATION_NAME_HINT_PREFIX = "O_";
	public static final String REAL_NAME_HINT_PREFIX = "R_";
	public static final String STRING_NAME_HINT_PREFIX = "S_";
	public static final String TYPE_NAME_HINT_PREFIX = "T_";
	
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

//	protected final @NonNull MetaModelManager metaModelManager;
	private final @NonNull Map<String, Element> name2element = new HashMap<String, Element>();		// User of each name, null if name ambiguous
	private final @NonNull Map<Element, String> element2name = new HashMap<Element, String>();		// Unambiguous name for each element, null if not determined
	private Map<String, Integer> name2counter = null;										// Auto-generation counter for each colliding name

	public NameManager(@NonNull MetaModelManager metaModelManager) {
//		this.metaModelManager = metaModelManager;
	}
	
	public void addNamedElement(@NonNull NamedElement namedElement) {
		String name = namedElement.getName();
		if (name != null) {
			Element oldNamedElement = name2element.get(name);
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

	/**
	 * Return a suggestion for the name of anObject.
	 * <p>
	 * The returned name is not guaranteed to be unique. Uniqueness is enforced when the hint is passed to getSymbolName(). 
	 */
	public @Nullable String getNameHint(@NonNull Object anObject) {
		if (anObject instanceof IntegerLiteralExp) {
			Number numberSymbol = ((IntegerLiteralExp)anObject).getIntegerSymbol();
			return numberSymbol != null ? getNumericNameHint(numberSymbol) : null;
		}
		else if (anObject instanceof Number) {
			return getNumericNameHint((Number)anObject);
		}
		else if (anObject instanceof Operation) {
			return getOperationNameHint((Operation)anObject);
		}
		else if (anObject instanceof RealLiteralExp) {
			Number numberSymbol = ((RealLiteralExp)anObject).getRealSymbol();
			return numberSymbol != null ? getNumericNameHint(numberSymbol) : null;
		}
		else if (anObject instanceof String) {
			return getStringNameHint((String)anObject);
		}
		else if (anObject instanceof StringLiteralExp) {
			String stringSymbol = ((StringLiteralExp)anObject).getStringSymbol();
			return stringSymbol != null ? getStringNameHint(stringSymbol) : null;
		}
		else if (anObject instanceof Type) {
			return getTypeNameHint((Type)anObject);
		}
		else if (anObject instanceof TypeExp) {
			Type referredType = ((TypeExp)anObject).getType();
			return referredType != null ? getTypeNameHint(referredType) : null;
		}
		else if (anObject instanceof UnlimitedNaturalLiteralExp) {
			Number numberSymbol = ((UnlimitedNaturalLiteralExp)anObject).getUnlimitedNaturalSymbol();
			return numberSymbol != null ? getNumericNameHint(numberSymbol) : null;
		}
		else if (anObject instanceof LiteralExp) {
			return "literal";
		}
		else if (anObject instanceof Nameable) {
			return ((Nameable)anObject).getName();
		}
		else {
			return null;
		}
	}

	public String getNumericNameHint(@NonNull Number aNumber) {
		@SuppressWarnings("null") @NonNull String string = aNumber.toString();
		if ((aNumber instanceof BigInteger) || (aNumber instanceof Long) || (aNumber instanceof Integer) || (aNumber instanceof Short)) {
			return INTEGER_NAME_HINT_PREFIX + string;
		}
		else if ((aNumber instanceof BigDecimal) || (aNumber instanceof Double) || (aNumber instanceof Float)) {
			return REAL_NAME_HINT_PREFIX + getValidJavaIdentifier(string);
		}
		else {
			return null;
		}
	}

	public String getOperationNameHint(@NonNull Operation anOperation) {
		@SuppressWarnings("null") @NonNull String string = anOperation.toString();
		return OPERATION_NAME_HINT_PREFIX + getValidJavaIdentifier(string);
	}

	public String getStringNameHint(@NonNull String aString) {
		@SuppressWarnings("null") @NonNull String string = aString.length() > 20 ? aString.substring(0, 20) : aString;
		return STRING_NAME_HINT_PREFIX + getValidJavaIdentifier(string);
	}

	public @NonNull String getSymbolName(@NonNull Element element, @Nullable String... nameHints) {
		if ((nameHints != null) && (nameHints.length > 0)) {
			return getUniqueName(element, nameHints);
		}
		else {
			return getUniqueName(element, getNameHint(element));
		}
	}

	public String getTypeNameHint(@NonNull Type aType) {
		@SuppressWarnings("null") @NonNull String string = aType.toString();
		return TYPE_NAME_HINT_PREFIX + getValidJavaIdentifier(string);
	}

	protected @NonNull String getUniqueName(@Nullable Element element, @Nullable String... nameHints) {
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
			lastResort = DEFAULT_NAME_PREFIX;
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
			else if (c == '*') {
				s.append("_a");
			}
			else if (c == ':') {
				s.append("_c");
			}
			else if (c == '.') {
				s.append("_d");
			}
			else if (c == ')') {
				s.append("_e");
			}
			else if (c == '>') {
				s.append("_g");
			}
			else if (c == '<') {
				s.append("_l");
			}
			else if (c == '-') {
				s.append("_m");
			}
			else if (c == '(') {
				s.append("_o");
			}
			else if (c == '+') {
				s.append("_p");
			}
			else if (c == '=') {
				s.append("_q");
			}
			else if (c == '/') {
				s.append("_s");
			}
			else {
				s.append('_' + Integer.toString(c));
			}
		}
		@SuppressWarnings("null") @NonNull String string = s.toString();
		return string;
	}
	
	private void install(@NonNull String name, @Nullable Element element) {
		name2element.put(name, element);
		if (element != null) {
			element2name.put(element, name);
		}
	}

	public @NonNull String reserveName(@NonNull String name, @Nullable TypedElement element) {
		String validJavaIdentifier = getUniqueName(element, getValidJavaIdentifier(name));
		Element oldElement = name2element.put(validJavaIdentifier, element);
		assert (oldElement == null) || (oldElement == element);
		return validJavaIdentifier;
	}
}
