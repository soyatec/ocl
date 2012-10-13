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
 */
package org.eclipse.ocl.examples.codegen.common;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public class GenModelCodeGenHelper extends CodeGenHelper
{
	protected final @NonNull MetaModelManager metaModelManager;
	private @NonNull Map<EPackage, GenPackage> ePackageMap = new HashMap<EPackage, GenPackage>();
	private @NonNull Map<String, GenPackage> uriMap = new HashMap<String, GenPackage>();
	private @NonNull Map<EClassifier, GenClassifier> eClassifierMap = new HashMap<EClassifier, GenClassifier>();
	
	public GenModelCodeGenHelper(@NonNull GenModel genModel, @NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
		for (GenPackage genPackage : genModel.getGenPackages()) {
			assert genPackage != null;
			install(genPackage);
		}
		for (GenPackage genPackage : genModel.getUsedGenPackages()) {
			assert genPackage != null;
			install(genPackage);
		}
	}

	protected void install(@NonNull GenPackage genPackage) {
		EPackage ePackage = genPackage.getEcorePackage();
		if ((ePackage != null) && !ePackageMap.containsKey(ePackage)) {
			ePackageMap.put(ePackage, genPackage);
			String nsURI = ePackage.getNsURI();
			if (nsURI != null) {
				uriMap.put(nsURI, genPackage);
			}
			for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
				assert genClassifier != null;
				EClassifier eClassifier = genClassifier.getEcoreClassifier();
				eClassifierMap.put(eClassifier, genClassifier);
			}
		}
		for (GenPackage nestedGenPackage : genPackage.getNestedGenPackages()) {
			assert nestedGenPackage != null;
			install(nestedGenPackage);
		}
	}

	protected @NonNull String getCopyright(@NonNull String indentation) {
		return "";
	}
	
	protected @NonNull String getEscapedName(@NonNull Type type) {
		GenPackage genPackage = getGenPackage(type);
		GenClass genClass = getGenClass(genPackage, type);
		if (genClass != null) {
			return "<%" + genClass.getQualifiedInterfaceName() + "%>";
		}
		if (type == metaModelManager.getOclAnyType()) {
			return "Object";
		}
		throw new UnsupportedOperationException();
	}
	
	public @Nullable GenClass getGenClass(@NonNull GenPackage genPackage, @NonNull Type type) {
		String name = type.getName();
		for (GenClass genClass : genPackage.getGenClasses()) {
			String clsName = genClass.getEcoreClass().getName();
			if (name.equals(clsName)) {
				return genClass;
			}
		}
		return null;
	}

	protected @NonNull GenPackage getGenPackage(@NonNull Type type) {
		org.eclipse.ocl.examples.pivot.Package pPackage = type.getPackage();
		String nsURI = pPackage.getNsURI();
		GenPackage genPackage = uriMap.get(nsURI);
		if (nsURI != null) {
			if (genPackage != null) {
				return genPackage;
			}
		}
		if (OCLstdlibPackage.eNS_URI.equals(nsURI)) {		// FIXME regularize
			genPackage = uriMap.get(PivotPackage.eNS_URI);
			if (genPackage != null) {
				return genPackage;
			}
		}
		throw new IllegalArgumentException("Unknown package '" + nsURI + "'");
	}
}
