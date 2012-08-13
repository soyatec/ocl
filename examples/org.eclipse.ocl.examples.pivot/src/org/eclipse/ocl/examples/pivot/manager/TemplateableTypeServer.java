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
import java.math.BigInteger;
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
	public static class TemplateArguments extends ArrayList<Object>
	{
		private static final long serialVersionUID = 1L;
		
		private final int parametersSize;
		private final int hashCode;

		public TemplateArguments(List<? extends ParameterableElement> parameters) {
			parametersSize = parameters.size();
			int hash = 0;
			for (ParameterableElement parameter : parameters) {
				hash = 111 * hash + parameter.hashCode();
				add(parameter);
			}
			hashCode = hash;
		}

		public TemplateArguments(ParameterableElement parameter, BigInteger lower, BigInteger upper) {
			parametersSize = 1;
			int hash = parameter.hashCode();
			add(parameter);
			if (lower == null) {
				lower = BigInteger.valueOf(0);
			}
			hash = 111 * hash + lower.hashCode();
			add(lower);
			if (upper == null) {
				upper = BigInteger.valueOf(-1);
			}
			hash = 111 * hash + upper.hashCode();
			add(upper);
			hashCode = hash;
		}
		
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof TemplateArguments)) {
				return false;
			}
			TemplateArguments that = (TemplateArguments)o;
			if (this.hashCode != that.hashCode){
				return false;
			}
			int iMax = this.size();
			if (iMax != that.size()) {
				return false;
			}
			for (int i = 0; i < iMax; i++) {
				Object thisParameter = this.get(i);
				Object thatParameter = that.get(i);
				if (thisParameter != null) {
					if (thatParameter != null) {
						if (!thisParameter.equals(thatParameter)) {
							return false;
						}
					}
					else {
						return false;
					}				
				}
				else {
					if (thatParameter != null) {
						return false;
					}
					else {
					}				
				}
			}
			return true;
		}

		@Override
		public int hashCode() {
			return hashCode;
		}

		public int parametersSize() {
			return parametersSize;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append('(');
			int iMax = this.size();
			for (int i = 0; i < iMax; i++) {
				if (i > 0) {
					s.append(',');
				}
				s.append(String.valueOf(this.get(i)));
			}
			s.append(')');
			return s.toString();
		}		
	}
	
	/**
	 * Map from actual types to specialization.
	 * <br>
	 * The specializations are weakly referenced so that stale specializations are garbage collected.
	 */
	// FIXME tests fail if keys are weak since GC is too aggressive across tests
	// The actual types are weak keys so that parameterizations using stale types are garbage collected. 
	//
	private @Nullable /*WeakHash*/Map<TemplateArguments, WeakReference<Type>> specializations = null;

	protected TemplateableTypeServer(@NonNull PackageServer packageServer, @NonNull DomainType domainType) {
		super(packageServer, domainType);
	}
	
	protected @NonNull Type createSpecialization(@NonNull TemplateArguments templateArguments) {
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
			Object templateArgument = templateArguments.get(i);
			if (templateArgument instanceof ParameterableElement) {
				ParameterableElement actualType = (ParameterableElement) templateArgument;
				allBindings.put(formalParameter, actualType);
				TemplateParameterSubstitution templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				templateParameterSubstitution.setFormal(formalParameter);
				if (actualType.eResource() == null) {
					templateParameterSubstitution.setOwnedActual(actualType);
				}
				else {
					templateParameterSubstitution.setActual(actualType);
				}
			templateBinding.getParameterSubstitution().add(templateParameterSubstitution);
			}
		}
		specializedType.getTemplateBinding().add(templateBinding);
		resolveSuperClasses(specializedType, unspecializedType, allBindings);
		if (specializedType instanceof CollectionType) {
			Type elementType = (Type) templateArguments.get(0);
			BigInteger lower = (BigInteger) templateArguments.get(1);
			BigInteger upper = (BigInteger) templateArguments.get(2);
			CollectionType specializedCollectionType = (CollectionType)specializedType;
			specializedCollectionType.setElementType(elementType);
			specializedCollectionType.setLower(lower);
			specializedCollectionType.setUpper(upper);
		}
		else if (specializedType instanceof ClassifierType) {
			Type instanceType = (Type) templateArguments.get(0);
			ClassifierType specializedClassifierType = (ClassifierType)specializedType;
			specializedClassifierType.setInstanceType(instanceType);
		}
		specializedType.setUnspecializedElement(unspecializedType);
		MetaModelManager metaModelManager = packageManager.getMetaModelManager();
		Orphanage orphanage = Orphanage.getOrphanage(metaModelManager.getPivotResourceSet());
		specializedType.setPackage(orphanage);
		return specializedType;
	}

	public synchronized @Nullable Type findSpecializedType(@NonNull TemplateArguments templateArguments) {
		TemplateSignature templateSignature = getPivotType().getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getParameter();
		int iMax = templateParameters.size();
		if (templateArguments.parametersSize() != iMax) {
			return null;
		}
		Map<TemplateArguments, WeakReference<Type>> specializations2 = specializations;
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
		return getSpecializedType(new TemplateArguments(templateArguments));
	}

	public synchronized @NonNull Type getSpecializedType(@NonNull ParameterableElement templateArgument, BigInteger lower, BigInteger upper) {
		assert getPivotType() instanceof CollectionType;
		return getSpecializedType(new TemplateArguments(templateArgument, lower, upper));
	}

	public synchronized @NonNull Type getSpecializedType(@NonNull TemplateArguments templateArguments) {
		TemplateSignature templateSignature = getPivotType().getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getParameter();
		int iMax = templateParameters.size();
		if (templateArguments.parametersSize() != iMax) {
			throw new IllegalArgumentException("Incompatible template argument count");
		}
		Map<TemplateArguments, WeakReference<Type>> specializations2 = specializations;
		if (specializations2 == null) {
			synchronized(this) {
				specializations2 = specializations;
				if (specializations2 == null) {
					specializations2 = specializations = new /*Weak*/HashMap<TemplateArguments, WeakReference<Type>>();
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
				TypeServer superTypeServer = metaModelManager.getTypeServer(unspecializedSuperType);
/*				List<ParameterableElement> superTemplateArgumentList = new ArrayList<ParameterableElement>();
				for (TemplateBinding templateBinding : superTemplateBindings) {
					for (TemplateParameterSubstitution parameterSubstitution : templateBinding.getParameterSubstitution()) {
						ParameterableElement templateArgument = parameterSubstitution.getActual();
						superTemplateArgumentList.add(templateArgument);
					}
				} */
				if (superTypeServer instanceof TemplateableTypeServer) {
					Type specializedSuperType = ((TemplateableTypeServer)superTypeServer).getSpecializedType(superTemplateArgumentList);
					specializedClass.getSuperClass().add(specializedSuperType);
				}
			}
			else {
				specializedClass.getSuperClass().add(superType);
			}
		}
	}
}
