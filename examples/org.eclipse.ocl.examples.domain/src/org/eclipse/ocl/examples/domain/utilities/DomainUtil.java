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
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.osgi.util.NLS;

public class DomainUtil
{	
	private static final AdapterFactory reflectiveAdapterFactory =
			new ReflectiveItemProviderAdapterFactory();

	private static final AdapterFactory defaultAdapterFactory =
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	public static @NonNull String bind(String messageTemplate, Object... bindings) {
		return nonNullJava(NLS.bind(messageTemplate, bindings));
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
	
	/**
	 * Return aT, checking the assertion that this call would not be necessary if EMF had comprehensive @NonNull annotations.
	 */
	@SuppressWarnings("null")
	public static @NonNull <T> T nonNullEMF(T aT) {// FIXME remove once EMF guarantees non-null
		assert aT != null;
		return aT;
	}
	
	/**
	 * Return aT, checking the assertion that this call would not be necessary if JDT collection entry analysis was more comprehensive.
	 */
	@SuppressWarnings("null")
	public static @NonNull <T> T nonNullEntry(T aT) {// FIXME remove once JDT guarantees non-null entries
		assert aT != null;
		return aT;
	}
	
	/**
	 * Return aT, checking the assertion that this call would not be necessary if JDT null analysis was more comprehensive.
	 */
	@SuppressWarnings("null")
	public static @NonNull <T> T nonNullJDT(T aT) {// FIXME remove once JDT guarantees non-null
		assert aT != null;
		return aT;
	}
	
	/**
	 * Return aT, checking the assertion that this call would not be necessary if Java had comprehensive @NonNull annotations.
	 */
	@SuppressWarnings("null")
	public static @NonNull <T> T nonNullJava(T aT) {// FIXME remove once Java guarantees non-null
		assert aT != null;
		return aT;
	}

	/**
	 * Return aT, checking the assertion that this call would not be necessary if the Ecore model was guaranteed to be valid.
	 */
	@SuppressWarnings("null")
	public static @NonNull <T> T nonNullModel(T aT) {
		assert aT != null;			// FIXME Change to InvalidModelException
		return aT;
	}

	/**
	 * Return aT, checking the assertion that this call would not be necessary if the Pivot model was guaranteed to be valid.
	 */
	@SuppressWarnings("null")
	public static @NonNull <T> T nonNullPivot(T aT) {
		assert aT != null;			// FIXME Change to InvalidModelException
		return aT;
	}

	/**
	 * Return aT, throwing an IllegalStateException if null.
	 */
	public static @NonNull <T> T nonNullState(T aT) {
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
	public static void suppressThrowWarnings()  throws InvalidValueException {}
}
