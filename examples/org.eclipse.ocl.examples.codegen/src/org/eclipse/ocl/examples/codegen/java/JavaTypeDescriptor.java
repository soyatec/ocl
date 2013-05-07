/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.codegen.java;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * A JavaTypeDescriptor provides alternate views of a type.
 */
public class JavaTypeDescriptor
{
	protected final @NonNull String className;
	protected final @Nullable EClassifier eClassifier;
	protected final @Nullable Class<?> javaClass;

	@SuppressWarnings("null")
	public JavaTypeDescriptor(@NonNull String className, @Nullable EClassifier eClassifier, @Nullable Class<?> javaClass) {
		if ((javaClass != null) && (javaClass != Object.class)) {
			javaClass = reClass(javaClass);
			this.className = javaClass.getName();
			this.eClassifier = eClassifier;
			this.javaClass = javaClass;
		}
		else {
			this.className = className;
			this.eClassifier = eClassifier;
			this.javaClass = null;
		}
	}

	@SuppressWarnings("null")
	public JavaTypeDescriptor(@NonNull Class<?> javaClass) {
		javaClass = reClass(javaClass);
		this.className = javaClass.getName();
		this.eClassifier = null;
		this.javaClass = javaClass;
	}

	public @NonNull String getClassName() {
		return className;
	}

	public @Nullable EClassifier getEClassifier() {
		return eClassifier;
	}

	public @Nullable Class<?> getJavaClass() {
		return javaClass;
	}

	public @NonNull String getReClassName() {
		return className;
	}

	public boolean isAssignableFrom(@NonNull JavaTypeDescriptor thatTypeDescriptor) {
		if ((javaClass != null) && (thatTypeDescriptor.javaClass != null)) {
			return javaClass.isAssignableFrom(thatTypeDescriptor.javaClass);
		}
		if (eClassifier == thatTypeDescriptor.eClassifier) {
			return true;
		}
		EClassifier eClassifier2 = eClassifier;
		if ((eClassifier2 instanceof EClass) && (thatTypeDescriptor.eClassifier instanceof EClass)) {
			return ((EClass)eClassifier2).isSuperTypeOf((EClass) thatTypeDescriptor.eClassifier);
		}
		return false;
	}

	protected @NonNull Class<?> reClass(@NonNull Class<?> javaClass) {
		if (javaClass == NamedElement.class) {			// FIXME Avoid two-level Pivot interfaces
			javaClass = DomainNamedElement.class;
		}
		else if (javaClass == OCLExpression.class) {
			javaClass = DomainExpression.class;
		}
		else if (javaClass == OpaqueExpression.class) {
			javaClass = DomainExpression.class;
		}
		else if (javaClass == Operation.class) {
			javaClass = DomainOperation.class;
		}
		else if (javaClass == org.eclipse.ocl.examples.pivot.Package.class) {
			javaClass = DomainPackage.class;
		}
		else if (javaClass == Property.class) {
			javaClass = DomainProperty.class;
		}
		else if (javaClass == Type.class) {
			javaClass = DomainType.class;
		}
		return javaClass;
	}

	@Override
	public @NonNull String toString() {
		return className;
	}
}