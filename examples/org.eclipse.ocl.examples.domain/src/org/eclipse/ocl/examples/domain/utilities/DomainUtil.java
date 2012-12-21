/**
 * <copyright>
 * 
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: PivotUtil.java,v 1.18 2011/05/20 15:27:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.utilities;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.osgi.util.NLS;

public class DomainUtil
{	
	private static final AdapterFactory reflectiveAdapterFactory =
			new ReflectiveItemProviderAdapterFactory();

	private static final AdapterFactory defaultAdapterFactory =
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	private static final String maxIntValue = Integer.toString(Integer.MAX_VALUE);
	private static final int maxIntSize = maxIntValue.length();	
	private static final String maxLongValue = Long.toString(Long.MAX_VALUE);
	private static final int maxLongSize = maxLongValue.length();	


	public static @NonNull String bind(String messageTemplate, Object... bindings) {
		@SuppressWarnings("null") @NonNull String result = NLS.bind(messageTemplate, bindings);
		return result;
	}

	public static @NonNull Number createNumberFromString(@NonNull String aValue) throws NumberFormatException {
		if ("*".equals(aValue)) {
			return Unlimited.INSTANCE;
		}
		int len = aValue.length();
		if ((len < maxIntSize) || ((len == maxIntSize) && (maxIntValue.compareTo(aValue) >= 0))) {
			Integer result = Integer.valueOf(aValue);
			assert result != null;
			return result;
		}
		else if ((len < maxLongSize) || ((len == maxLongSize) && (maxLongValue.compareTo(aValue) >= 0))) {
			Long result = Long.valueOf(aValue);
			assert result != null;
			return result;
		}
		else {
			return new BigInteger(aValue);
		}
	}
	
	public static String debugFullName(Object object) {
		if (object == null) {
			return "null";
		}
		else {
			return object.getClass().getName() + "@" + Integer.toHexString(object.hashCode());
		}
	}
	
	public static String debugSimpleName(Object object) {
		if (object == null) {
			return "null";
		}
		else {
			return object.getClass().getSimpleName() + "@" + Integer.toHexString(object.hashCode());
		}
	}

	/**
	 * Append a multiplicity string such as "[1..5]" to a StringBuilder.
	 * <br>
	 * Shortforms such as "[?]",  "[+]",  "[*]",  "[1]",  "[2..*]" are used if possible.
	 * <br>
	 * A -ve upper signals unlimited.
	 */
	public static void formatMultiplicity(@NonNull StringBuilder s, long lower, long upper) {
		s.append("[");
		if (upper < 0) {
			if (lower == 1) {
				s.append("+");
			}
			else {
				if (lower != 0) {
					s.append(lower);
					s.append("..");
				}
				s.append("*");
			}
		}
		else if ((lower == 0) && (upper == 1)) {
			s.append("?");
		}
		else {
			s.append(lower);
			if (lower != upper) {
				s.append("..");
				s.append(upper);
			}
		}
		s.append("]");
	}

	/**
	 * Return a simple readable description of eObject using an IItemLabelProvider if possible.
	 */
	public static String getLabel(EObject eObject) {
		IItemLabelProvider labeler =
			(IItemLabelProvider) defaultAdapterFactory.adapt(eObject, IItemLabelProvider.class);		
		if (labeler == null) {
			labeler = (IItemLabelProvider) reflectiveAdapterFactory.adapt(eObject, IItemLabelProvider.class);
		}		
		if ((labeler != null) && (eObject != null)) {
			return labeler.getText(eObject);
		}
		return String.valueOf(eObject);
	}

	/**
	 * Return a simple readable description of object. If non-null eClassifier
	 * identifoes the type of object. If non-null context may provide an ESubstitutionLabelProvider.
	 */
	public static String getLabel(EClassifier eClassifier, Object object, Map<Object, Object> context) {
		if (eClassifier instanceof EDataType) {
			return EObjectValidator.getValueLabel((EDataType) eClassifier, object, context);
		}
		else if (object instanceof EObject) {
			if (context != null) {					// Use an ESubstitutionLabelProvider
				return EObjectValidator.getObjectLabel((EObject)object, context);
			}
			else {									// Use an ItemProvider rather than EcoreUtil.getIdentification
				return getLabel((EObject)object);
			}
		}
		else {			// Never happens
			return String.valueOf(object);
		}
	}

	public static <T extends DomainNamedElement> T getNamedElement(Iterable<T> elements, String name) {
		if (elements == null)
			return null;
		for (T element : elements)
			if (ClassUtils.equals(name, element.getName()))
				return element;
		return null;				
	}
	
	/**
	 * Return aT, checking the assertion that this call would not be necessary if EMF had comprehensive @NonNull annotations.
	 */
	public static @NonNull <T> T nonNullEMF(@Nullable T aT) {// FIXME remove once EMF guarantees non-null
		assert aT != null;
		return aT;
	}

	/**
	 * Check for an in appropriate model state which should have been detected by a model validation pass. Typical problems
	 * that nonNullModel detects are null mandatory model elements.
	 *<p>
	 * Return aT, checking the assertion that this call would not be necessary if the Ecore model was guaranteed to be valid.
	 */
	public static @NonNull <T> T nonNullModel(@Nullable T aT) {
		assert aT != null;			// FIXME Change to InvalidModelException
		return aT;
	}

	/**
	 * Return aT, checking the assertion that this call would not be necessary if the Pivot model was guaranteed to be valid.
	 */
	public static @NonNull <T> T nonNullPivot(@Nullable T aT) {
		assert aT != null;			// FIXME Change to InvalidModelException
		return aT;
	}

	/**
	 * Check for an in appropriate program state. This should not happen, but is not impossible. For instance
	 * a Resource should be contained in a ResourceSet, but that doesn;t mean it always is.
	 *<p>
	 * If the inappropriate state really cannot happen, an assertion should be used instead to avoid non-debug
	 * run-time cost.
	 * <p>
	 * Return aT, throwing an IllegalStateException if null.
	 */
	public static @NonNull <T> T nonNullState(@Nullable T aT) {
		if (aT == null) {
			throw new IllegalStateException();
		}
		return aT;
	}

	/**
	 * This dummy function may be invoked from auto-generated code that does not throw
	 * an exception to avoid a compilation error.
	 * 
	 * @throws InvalidValueException
	 * @deprecated
	 */
	@Deprecated
	public static void suppressThrowWarnings()  {}
}
