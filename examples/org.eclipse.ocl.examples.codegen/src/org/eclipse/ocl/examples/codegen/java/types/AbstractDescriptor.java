/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.java.types;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.domain.elements.DomainConstraint;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.elements.DomainNamespace;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;

public abstract class AbstractDescriptor implements TypeDescriptor
{
	/**
	 * Convert a Pivot javaClass to its underlying Domain interface.
	 * FIXME Avoid two-level Pivot interfaces
	 */
	protected static @NonNull Class<?> reClass(@NonNull Class<?> javaClass) {
		if (javaClass == Constraint.class) {
			javaClass = DomainConstraint.class;
		}
		else if (javaClass == NamedElement.class) {
			javaClass = DomainNamedElement.class;
		}
		else if (javaClass == Namespace.class) {
			javaClass = DomainNamespace.class;
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
		else if (javaClass == Parameter.class) {
			javaClass = DomainTypedElement.class;
		}
		else if (javaClass == Property.class) {
			javaClass = DomainProperty.class;
		}
		else if (javaClass == Type.class) {
			javaClass = DomainType.class;
		}
		return javaClass;
	}

	protected final @NonNull ElementId elementId;
	
	public AbstractDescriptor(@NonNull ElementId elementId) {
		this.elementId = elementId;
	}

	public @Nullable EClassifier getEClassifier() {
		return null;
	}
	
	public @NonNull ElementId getElementId() {
		return elementId;
	}

	public boolean isAssignableTo(@NonNull Class<?> javaClass) {
		return javaClass == Object.class;
	}

	@Override
	public @NonNull String toString() {
		return elementId + " => " + getClassName();
	}
}