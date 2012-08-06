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

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * An TemplateableTypeServer supports one or more merged types as the source for operations, properties or superclasses
 * and additionally supports their specializations.
 */
public class TemplateableTypeServer extends ExtensibleTypeServer
{	
	/**
	 * Map from actual types to specialization.
	 * <br>
	 * The specializations are weakly referenced so that stale specializations are garbage collected.
	 */
	// FIXME tests fail if keys are weak since GC is too aggressive across tests
	// The actual types are weak keys so that parameterizations using stale types are garbage collected. 
	//
	private @Nullable /*WeakHash*/Map<List<? extends ParameterableElement>, WeakReference<Type>> specializations = null;

	protected TemplateableTypeServer(@NonNull PackageServer packageServer, @NonNull DomainType domainType) {
		super(packageServer, domainType);
	}
	
	protected @NonNull Type createSpecialization(@NonNull List<? extends ParameterableElement> templateArguments) {
		Type unspecializedType = getPivotType();
		String typeName = unspecializedType.getName();
		TemplateSignature templateSignature = unspecializedType.getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
		EClass eClass = unspecializedType.eClass();
		EFactory eFactoryInstance = eClass.getEPackage().getEFactoryInstance();
		Type specializedType = (Type) eFactoryInstance.create(eClass);		
		specializedType.setName(typeName);
		TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		templateBinding.setSignature(templateSignature);
		Map<TemplateParameter, ParameterableElement> allBindings = new HashMap<TemplateParameter, ParameterableElement>();
		for (int i = 0; i < templateParameters.size(); i++) {
			TemplateParameter formalParameter = templateParameters.get(i);
			ParameterableElement actualType = templateArguments.get(i);
			allBindings.put(formalParameter, templateArguments.get(i));
			TemplateParameterSubstitution templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
			templateParameterSubstitution.setFormal(formalParameter);
			if ((actualType != null) && (actualType.eResource() == null)) {
				templateParameterSubstitution.setOwnedActual(actualType);
			}
			else {
				templateParameterSubstitution.setActual(actualType);
			}
			templateBinding.getParameterSubstitution().add(templateParameterSubstitution);
		}
		specializedType.getTemplateBinding().add(templateBinding);
		resolveSuperClasses(specializedType, unspecializedType, allBindings);
		if (specializedType instanceof CollectionType) {
			ParameterableElement templateArgument = templateArguments.get(0);
			CollectionType specializedCollectionType = (CollectionType)specializedType;
			specializedCollectionType.setElementType((Type) templateArgument);
		}
		else if (specializedType instanceof ClassifierType) {
			ParameterableElement templateArgument = templateArguments.get(0);
			ClassifierType specializedClassifierType = (ClassifierType)specializedType;
			specializedClassifierType.setInstanceType((Type)templateArgument);
		}
		specializedType.setUnspecializedElement(unspecializedType);
		MetaModelManager metaModelManager = packageManager.getMetaModelManager();
		Orphanage orphanage = Orphanage.getOrphanage(metaModelManager.getPivotResourceSet());
		specializedType.setPackage(orphanage);
		return specializedType;
	}

	public synchronized @Nullable Type findSpecializedType(@NonNull List<? extends ParameterableElement> templateArguments) {
		TemplateSignature templateSignature = getPivotType().getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getParameter();
		int iMax = templateParameters.size();
		if (templateArguments.size() != iMax) {
			return null;
		}
		Map<List<? extends ParameterableElement>, WeakReference<Type>> specializations2 = specializations;
		if (specializations2 == null) {
			return null;
		}
		WeakReference<Type> weakReference = specializations2.get(templateArguments);
		if (weakReference == null) {
			return null;
		}
		Type type = weakReference.get();
		if (type == null) {
			synchronized (specializations2) {
				type = weakReference.get();
				if (type == null) {
					specializations2.remove(templateArguments);
				}
			}
		}
		return type;
	}

	public synchronized @NonNull Type getSpecializedType(@NonNull List<? extends ParameterableElement> templateArguments) {
		TemplateSignature templateSignature = getPivotType().getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getParameter();
		int iMax = templateParameters.size();
		if (templateArguments.size() != iMax) {
			throw new IllegalArgumentException("Incompatible template argument count");
		}
		Map<List<? extends ParameterableElement>, WeakReference<Type>> specializations2 = specializations;
		if (specializations2 == null) {
			synchronized(this) {
				specializations2 = specializations;
				if (specializations2 == null) {
					specializations2 = specializations = new /*Weak*/HashMap<List<? extends ParameterableElement>, WeakReference<Type>>();
				}
			}
		}
		synchronized (specializations2) {
			Type specializedType = null;
			WeakReference<Type> weakReference = specializations2.get(templateArguments);
			if (weakReference != null) {
				specializedType = weakReference.get();
			}
			if (specializedType == null) {
				specializedType = createSpecialization(templateArguments);
				specializations2.put(templateArguments, new WeakReference<Type>(specializedType));
			}
			return specializedType;
		}
	}

	void resolveSuperClasses(@NonNull Type specializedClass, @NonNull Type libraryClass, Map<TemplateParameter, ParameterableElement> allBindings) {
		MetaModelManager metaModelManager = packageManager.getMetaModelManager();
		for (Type superType : libraryClass.getSuperClass()) {
			List<TemplateBinding> superTemplateBindings = superType.getTemplateBinding();
			if (superTemplateBindings.size() > 0) {
//				Map<TemplateParameter, ParameterableElement> superTemplateArgumentMap = new HashMap<TemplateParameter, ParameterableElement>();
				List<ParameterableElement> superTemplateArgumentList = new ArrayList<ParameterableElement>();
				for (TemplateBinding superTemplateBinding : superTemplateBindings) {
					for (TemplateParameterSubstitution superParameterSubstitution : superTemplateBinding.getParameterSubstitution()) {
						ParameterableElement superActual = superParameterSubstitution.getActual();
//						TemplateParameter superFormal = superParameterSubstitution.getFormal();
						TemplateParameter superTemplateParameter = superActual.getTemplateParameter();
						ParameterableElement actualActual = allBindings.get(superTemplateParameter);
//						superTemplateArgumentMap.put(superFormal, actualActual);
						superTemplateArgumentList.add(actualActual);
					}
				}
				@NonNull Type unspecializedSuperType = PivotUtil.getUnspecializedTemplateableElement(superType);
				TemplateableTypeServer superTypeServer = (TemplateableTypeServer) metaModelManager.getTypeServer(unspecializedSuperType);
/*				List<ParameterableElement> superTemplateArgumentList = new ArrayList<ParameterableElement>();
				for (TemplateBinding templateBinding : superTemplateBindings) {
					for (TemplateParameterSubstitution parameterSubstitution : templateBinding.getParameterSubstitution()) {
						ParameterableElement templateArgument = parameterSubstitution.getActual();
						superTemplateArgumentList.add(templateArgument);
					}
				} */
//				if (superTypeServer != null) {
					Type specializedSuperType = superTypeServer.getSpecializedType(superTemplateArgumentList);
					specializedClass.getSuperClass().add(specializedSuperType);
//				}
			}
			else {
				specializedClass.getSuperClass().add(superType);
			}
		}
	}
}
