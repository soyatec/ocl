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
 **/
package org.eclipse.ocl.examples.codegen.generator;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.common.NameQueries;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractOperation;
import org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryTernaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public class AbstractGenModelHelper implements GenModelHelper
{
	public static final @NonNull String BODIES_CLASS_SUFFIX = "Bodies";
	public static final @NonNull String BODIES_PACKAGE_NAME = ".bodies";
	public static final @NonNull String TABLES_CLASS_SUFFIX = "Tables";
	public static final @NonNull String TABLES_PACKAGE_NAME = "";
	
	protected final @NonNull MetaModelManager metaModelManager;

	public AbstractGenModelHelper(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
	}
	
	public @NonNull Class<?> getAbstractOperationClass(@NonNull List<? extends TypedElement> parameters) {
		switch (parameters.size()) {
			case 0: return AbstractUnaryOperation.class;
			case 1: return AbstractBinaryOperation.class;
			case 2: return AbstractTernaryOperation.class;
			default: return AbstractOperation.class;
		}
	}

	public @NonNull Class<?> getEcoreInterfaceClass(@NonNull Type type) throws GenModelException {
		GenClass genClass = getGenClass(type);
		String qualifiedInterfaceName = genClass.getQualifiedInterfaceName();
		try {
			Thread currentThread = Thread.currentThread();
			@SuppressWarnings("null") @NonNull ClassLoader contextClassLoader = currentThread.getContextClassLoader();
			@SuppressWarnings("null") @NonNull Class<?> loadedClass = contextClassLoader.loadClass(qualifiedInterfaceName);
			return loadedClass;
		} catch (Exception e) {
			throw new GenModelException("Failed to load class for " + type);
		}
	}
	
	protected @NonNull GenClass getGenClass(@NonNull Type type) throws GenModelException {
		GenPackage genPackage = getGenPackage(type);
		if (genPackage != null) {
			String name = type.getName();
			for (GenClass genClass : genPackage.getGenClasses()) {
				String clsName = genClass.getEcoreClass().getName();
				if (name.equals(clsName)) {
					return genClass;
				}
			}
		}
		throw new GenModelException("No GenClass for " + type);
	}
	
	protected @NonNull GenClassifier getGenClassifier(@NonNull Type type) throws GenModelException {
		GenPackage genPackage = getGenPackage(type);
		if (genPackage != null) {
			String name = type.getName();
			for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
				String clsName = genClassifier.getEcoreClassifier().getName();
				if (name.equals(clsName)) {
					return genClassifier;
				}
			}
		}
		throw new GenModelException("No GenClassifier for " + type);
	}
	
	public @NonNull GenFeature getGenFeature(@NonNull Property property) throws GenModelException {
		Type owningType = property.getOwningType();
		if (owningType != null) {
			GenClass genClass = getGenClass(owningType);
			String name = property.getName();
			for (GenFeature genFeature : genClass.getGenFeatures()) {
				String featureName = genFeature.getEcoreFeature().getName();
				if (name.equals(featureName)) {
					return genFeature;
				}
			}
		}
		throw new GenModelException("No GenFeature for " + property);
	}

	protected @Nullable GenPackage getGenPackage(@NonNull Type type) {
		org.eclipse.ocl.examples.pivot.Package pPackage = type.getPackage();
		if (pPackage == null) {
			return null;
		}
		EObject eContainer = pPackage.eContainer();
		if (eContainer instanceof Root) {
			String nsURI = ((Root)eContainer).getExternalURI();
			if (nsURI != null) {
				GenPackage genPackage = metaModelManager.getGenPackage(nsURI);
				if (genPackage != null) {
					return genPackage;
				}
			}
		}
		String nsURI = pPackage.getNsURI();
		if (nsURI == null) {
			return null;
		}
		return metaModelManager.getGenPackage(nsURI);
	}
	
	public @NonNull String getGetAccessor(@NonNull Property aProperty) throws GenModelException {
		GenFeature genFeature = getGenFeature(aProperty);
		String getAccessor = genFeature.getGetAccessor();
		if (getAccessor != null) {
			return getAccessor;
		}
		throw new IllegalStateException("No GenFeature for " + aProperty);
	}

	public @NonNull Class<?> getOperationInterface(@NonNull List<? extends TypedElement> parameters) {
		switch (parameters.size()) {
			case 0: return LibraryUnaryOperation.class;
			case 1: return LibraryBinaryOperation.class;
			case 2: return LibraryTernaryOperation.class;
			default: return LibraryOperation.class;
		}
	}

	public @Nullable String getQualifiedOperationImplementationName(@NonNull CodeGenSnippet snippet, @NonNull Operation anOperation, @NonNull String stereotype) {
		Type type = anOperation.getOwningType();
		if (type != null) {
			GenPackage genPackage = getGenPackage(type);
			if (genPackage != null) {
				String qualifiedPackageName = genPackage.getQualifiedPackageName() + BODIES_PACKAGE_NAME;
				String outerClassName = type.getName() + BODIES_CLASS_SUFFIX;
				String qualifiedClassName = snippet.getImportedName(qualifiedPackageName) + "." + outerClassName;
				String innerClassName = "_" + anOperation.getName() + "_" + stereotype + "_";
				return qualifiedClassName + "." + innerClassName + ".INSTANCE";
			}
		}
		return null;
	}

	public @Nullable String getQualifiedPropertyImplementationName(@NonNull CodeGenSnippet snippet, @NonNull Property aProperty, @NonNull String stereotype) {
		Type type = aProperty.getOwningType();
		if (type != null) {
			GenPackage genPackage = getGenPackage(type);
			if (genPackage != null) {
				String qualifiedPackageName = genPackage.getQualifiedPackageName() + BODIES_PACKAGE_NAME;
				String outerClassName = type.getName() + BODIES_CLASS_SUFFIX;
				String qualifiedClassName = snippet.getImportedName(qualifiedPackageName) + "." + outerClassName;
				String innerClassName = "_" + aProperty.getName() + "_" + stereotype + "_";
				return qualifiedClassName + "." + innerClassName + ".INSTANCE";
			}
		}
		return null;
	}

	public @Nullable String getQualifiedLiteralName(@NonNull CodeGenSnippet snippet, @NonNull EnumerationLiteral enumerationLiteral) {
		Type type = enumerationLiteral.getEnumeration();
		if (type != null) {
			GenPackage genPackage = getGenPackage(type);
			if (genPackage != null) {
				String qualifiedPackageName = genPackage.getQualifiedPackageName() + TABLES_PACKAGE_NAME;
				String tablesClassName = genPackage.getPrefix() + TABLES_CLASS_SUFFIX;
				String qualifiedClassName = snippet.getImportedName(qualifiedPackageName + "." + tablesClassName) + ".EnumerationLiterals";
				String enumerationName = "_" + type.getName() + "__" + NameQueries.encodeName(enumerationLiteral);
				return qualifiedClassName + "." + enumerationName;
			}
		}
		return null;
	}

	public @Nullable String getQualifiedLiteralName(@NonNull CodeGenSnippet snippet, @NonNull Operation anOperation) {
		Type type = anOperation.getOwningType();
		if (type != null) {
			GenPackage genPackage = getGenPackage(type);
			if (genPackage != null) {
				String qualifiedPackageName = genPackage.getQualifiedPackageName() + TABLES_PACKAGE_NAME;
				String tablesClassName = genPackage.getPrefix() + TABLES_CLASS_SUFFIX;
				String qualifiedClassName = snippet.getImportedName(qualifiedPackageName + "." + tablesClassName) + ".Operations";
				String operationName = "_" + type.getName() + "__" + NameQueries.encodeName(anOperation);
				return qualifiedClassName + "." + operationName;
			}
		}
		return null;
	}

	public @Nullable String getQualifiedLiteralName(@NonNull CodeGenSnippet snippet, @NonNull Property aProperty) {
		Type type = aProperty.getOwningType();
		if (type != null) {
			GenPackage genPackage = getGenPackage(type);
			if (genPackage != null) {
				String qualifiedPackageName = genPackage.getQualifiedPackageName() + TABLES_PACKAGE_NAME;
				String tablesClassName = genPackage.getPrefix() + TABLES_CLASS_SUFFIX;
				String qualifiedClassName = snippet.getImportedName(qualifiedPackageName + "." + tablesClassName) + ".Properties";
				String operationName = "_" + type.getName() + "__" + NameQueries.encodeName(aProperty);
				return qualifiedClassName + "." + operationName;
			}
		}
		return null;
	}
}