/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.examples.codegen.common;

import java.util.List;

import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.xtext.util.Strings;

public class ValueQueries
{

	/**
	 * Mostly copied from {@link java.util.Properties#saveConvert} via
	 * {@link org.eclipse.xtext.util.Strings#convertToJavaString}
	 *
	public static String convertToJavaString(String theString) {
		if (theString == null) {
			return null;
		}
		int len = theString.length();
		int bufLen = len * 2;
		if (bufLen < 0) {
			bufLen = Integer.MAX_VALUE;
		}
		StringBuilder outBuffer = new StringBuilder(bufLen+2);
		outBuffer.append('"');
		for (int x = 0; x < len; x++) {
			char aChar = theString.charAt(x);
			// Handle common case first, selecting largest block that
			// avoids the specials below
			if ((aChar > 61) && (aChar < 127)) {
				if (aChar == '\\') {
					outBuffer.append('\\');
					outBuffer.append('\\');
					continue;
				}
				outBuffer.append(aChar);
				continue;
			}
			switch (aChar) {
				case ' ':
					outBuffer.append(' ');
					break;
				case '\t':
					outBuffer.append('\\');
					outBuffer.append('t');
					break;
				case '\n':
					outBuffer.append('\\');
					outBuffer.append('n');
					break;
				case '\r':
					outBuffer.append('\\');
					outBuffer.append('r');
					break;
				case '\f':
					outBuffer.append('\\');
					outBuffer.append('f');
					break;
				case '\b':
					outBuffer.append('\\');
					outBuffer.append('b');
					break;
//				case '\'':
//					outBuffer.append('\\');
//					outBuffer.append('\'');
//					break;
				case '"':
					outBuffer.append('\\');
					outBuffer.append('"');
					break;
				default:
					if (((aChar < 0x0020) || (aChar > 0x007e))) {
						outBuffer.append('\\');
						outBuffer.append('u');
						outBuffer.append(PivotUtil.toHex((aChar >> 12) & 0xF));
						outBuffer.append(PivotUtil.toHex((aChar >> 8) & 0xF));
						outBuffer.append(PivotUtil.toHex((aChar >> 4) & 0xF));
						outBuffer.append(PivotUtil.toHex(aChar & 0xF));
					} else {
						outBuffer.append(aChar);
					}
			}
		}
		outBuffer.append('"');
		return outBuffer.toString();
	} */
	@SuppressWarnings("unchecked")
	public static List<Object> elements(CollectionValue value) {
		return (List<Object>) value.getElements();
	}
	
	public static String emit(Object value) {
		if (value instanceof CollectionValue) {
			CollectionValue collectionValue = (CollectionValue)value;
			StringBuilder s = new StringBuilder();
			s.append("create" + collectionValue.getKind() + "Value(");
			s.append(collectionValue.getTypeId());
			for (Object element : collectionValue.getElements()) {
				s.append(", ");
				s.append(emit(element));
			}
			s.append(")");
			return s.toString();
		}
		else if (value instanceof String) {
			return "\"" + Strings.convertToJavaString((String)value) + "\"";
		}
		return ValuesUtil.stringValueOf(value);
	}
	
	public static String typeId(Value value) {
		return value.getTypeId().toString();
	}
}
