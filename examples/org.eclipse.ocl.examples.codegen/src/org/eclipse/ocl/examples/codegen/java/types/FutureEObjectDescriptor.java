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
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.domain.ids.ElementId;

/**
 * A FutureEObjectDescriptor describes a yet-to-be-created type whose boxed and unboxed representations are the same. It has a pivot ElementId, and EClassifier and a Java class name.
 * <p>
 * The Java class is only known by name; it is not yet loadable, since genmodel has not yet generated it.
 * <p>
 * There is no EClassifier available to perform type conformance checks since thie Java class name was provided as an instanceClassName.
 */
public class FutureEObjectDescriptor extends AbstractDescriptor implements SimpleDescriptor
{
	protected final @NonNull EClassifier eClassifier;
	protected final @NonNull String className;
	
	public FutureEObjectDescriptor(@NonNull ElementId elementId, @NonNull EClassifier eClassifier, @NonNull String className) {
		super(elementId);
		this.eClassifier = eClassifier;
		this.className = className;
	}

	public void append(@NonNull JavaStream js) {
		js.appendClassReference(className);
	}

	@Override
	public @Nullable EClassifier getEClassifier() {
		return eClassifier;
	}

	public @NonNull Class<?> getJavaClass() {
		return NamedFuture.class;
	}

	@NonNull
	public String getClassName() {
		return className;
	}

	public @Nullable Class<?> hasJavaClass() {
		return null;
	}

	public final boolean isAssignableFrom(@NonNull TypeDescriptor typeDescriptor) {
		return typeDescriptor == this;
	}
}