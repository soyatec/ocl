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
package org.eclipse.ocl.examples.pivot.manager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.library.UnsupportedOperation;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.library.CompositionProperty;
import org.eclipse.ocl.examples.pivot.library.ConstrainedOperation;
import org.eclipse.ocl.examples.pivot.library.ConstrainedProperty;
import org.eclipse.ocl.examples.pivot.library.ExplicitNavigationProperty;
import org.eclipse.ocl.examples.pivot.library.ImplicitNonCompositionProperty;
import org.eclipse.ocl.examples.pivot.library.StaticProperty;
import org.eclipse.ocl.examples.pivot.library.TuplePartProperty;

/**
 * ImplementationManager encapsulates the knowledge about known feature implementations.
 */
public class ImplementationManager
{		
	protected final @NonNull MetaModelManager metaModelManager;

	/**
	 * ClassLoaders that may be able to load a library implementation.
	 */
	private List<ClassLoader> classLoaders = null;
	
	protected ImplementationManager(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}

	public void addClassLoader(@NonNull ClassLoader classLoader) {
		List<ClassLoader> classLoaders = getClassLoaders();
		if (!classLoaders.contains(classLoader)) {
			classLoaders.add(classLoader);
		}
	}

	public @NonNull List<ClassLoader> getClassLoaders() {
		List<ClassLoader> classLoaders2 = classLoaders;
		if (classLoaders2 == null) {
			classLoaders2 = classLoaders = new ArrayList<ClassLoader>();
			classLoaders2.add(metaModelManager.getClass().getClassLoader());
		}
		return classLoaders2;
	}

	protected @NonNull LibraryFeature getOperationImplementation(@NonNull Operation operation) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		LibraryFeature implementation = operation.getImplementation();
		String implementationClassName = operation.getImplementationClass();
		if (implementationClassName != null) {
			if ((implementation == null) || !implementation.getClass().getName().equals(implementationClassName)) {
				implementation = loadImplementation(operation);
				if (implementation != null) {
					return implementation;
				}
				else {
					return UnsupportedOperation.INSTANCE;
				}
			}
		}
		for (Constraint constraint : metaModelManager.getLocalConstraints(operation)) {
			if (UMLReflection.BODY.equals(constraint.getStereotype())) {
				ValueSpecification specification = constraint.getSpecification();
				if (specification instanceof ExpressionInOCL) {
					return new ConstrainedOperation((ExpressionInOCL) specification);
				}
			}
		}
		return UnsupportedOperation.INSTANCE;
	}

	protected @NonNull LibraryFeature getPropertyImplementation(@NonNull Property property) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		LibraryFeature implementation = property.getImplementation();
		String implementationClassName = property.getImplementationClass();
		if (implementationClassName != null) {
			if ((implementation == null) || !implementation.getClass().getName().equals(implementationClassName)) {
				implementation = loadImplementation(property);
				if (implementation != null) {
					return implementation;
				}
				else {
					return UnsupportedOperation.INSTANCE;
				}
			}
		}
		//
		// An initial 'OCL expression is evaluated at the creation time of the instance' so
		// if there is an initial constraint do lazy creation evaluation.
		//
		for (Constraint constraint : metaModelManager.getLocalConstraints(property)) {
			if (UMLReflection.INITIAL.equals(constraint.getStereotype())) {
				ValueSpecification specification = constraint.getSpecification();
				if (specification instanceof ExpressionInOCL) {
					return new ConstrainedProperty((ExpressionInOCL) specification);
				}
			}
		}
		//
		// 'A derived value expression is an invariant' so perhaps we'd better evaluate
		// it to support the lazy practice of using derivation as initial.
		//
		for (Constraint constraint : metaModelManager.getLocalConstraints(property)) {
			if (UMLReflection.DERIVATION.equals(constraint.getStereotype())) {
				ValueSpecification specification = constraint.getSpecification();
				if (specification instanceof ExpressionInOCL) {
					return new ConstrainedProperty((ExpressionInOCL) specification);
				}
			}
		}
		Property opposite = property.getOpposite();
		if ((opposite != null) && opposite.isComposite()) {
			return new CompositionProperty(property);
		}
		if (property.isImplicit()) {
			return new ImplicitNonCompositionProperty(property);
		}
		else if (property.getOwningType() instanceof TupleType) {
			TupleType tupleType = (TupleType)property.getOwningType();
			String name = property.getName();
			assert name != null;
			TuplePartId tuplePartId = tupleType.getTypeId().getPartId(name);
			assert tuplePartId != null;
			return new TuplePartProperty(tuplePartId);
		}
		else if (property.isStatic()) {
			return new StaticProperty(property);
		}
		else {
			return new ExplicitNavigationProperty(property.getPropertyId());
		}
	}
	
	public void dispose() {
		classLoaders = null;
	}

	/**
	 * Return the implementation of a feature.
	 * 
	 * @param feature to be implemented.
	 * @return the implementation, or null if the feature has no implementation
	 * as is the case for a normal model feature
	 * @throws ClassNotFoundException if the implementation class realising
	 * the implementation is not loadable 
	 * @throws NoSuchFieldException if the implementation class realising
	 * the implementation does not provide a static INSTANCE field
	 * @throws SecurityException if the implementation class is not accessible
	 * @throws IllegalAccessException if the implementation class is not accessible
	 * @throws IllegalArgumentException if the implementation class is not accessible
	 */
	public @Nullable LibraryFeature loadImplementation(@NonNull Feature feature) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		LibraryFeature implementation = feature.getImplementation();
		if (implementation == null) {
			String implementationClassName = feature.getImplementationClass();
			if (implementationClassName != null) {
				Class<?> theClass = null;
				ClassLoader featureClassLoader = feature.getClass().getClassLoader();
				if (featureClassLoader != null) {
					addClassLoader(featureClassLoader);
				}
				ClassNotFoundException e = null;
				for (ClassLoader classLoader : getClassLoaders()) {
					try {
						theClass = classLoader.loadClass(implementationClassName);
						e = null;
						break;
					} catch (ClassNotFoundException e1) {
						if (e == null) {
							e = e1;
						}
					}						
				}
				if (e != null) {
					throw e;
				}
				if (theClass != null) {
					Field field = theClass.getField("INSTANCE");
					implementation = (LibraryFeature) field.get(null);
				}
			}
		}
		return implementation;
	}
}