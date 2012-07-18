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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.library.executor.ReflectiveType;
import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.executor.PivotReflectivePackage;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * A TypeServer serves coordinated behaviour of one or more
 * merged Types as required for Complete OCL type extension.
 * 
 * For specializeable types, a TypeServer keeps track of zero or more specializations
 * using WeakReferences so that the specializations vanish once no longer required.
 */
public class TypeServer
{
	public static Function<TypeServer, Type> server2type = new Function<TypeServer, Type>()
	{
		public Type apply(TypeServer typeServer) {
			return typeServer.getPrimaryType();
		}
	};

	protected final PackageServer packageServer;
	protected final String name;
	protected final PackageManager packageManager;
	
	private final List<TypeTracker> trackers = new ArrayList<TypeTracker>();

	/**
	 * Lazily created map from operation name to the list of overloaded operation which is a list of operations to be treated as merged.
	 * The inner list of operations have the same name and signature. The outer list have the same name, but distinct signatures. 
	 */
	private Map<String, List<List<Operation>>> operation2operations = null;

	/**
	 * Lazily created map from property name to the list of properties to be treated as merged. 
	 */
	private Map<String, List<Property>> property2properties = null;
	
	private Type primaryType;
	
	/**
	 * Compiled inheritance relationships used by compiled expressions.
	 */
	private ReflectiveType executorType = null;
	
	/**
	 * Map from first actual type to list of specialized types for further actual types. 
	 */
	private Map<ParameterableElement, List<WeakReference<Type>>> firstActual2specializations = null;
	
	TypeServer(@NonNull PackageServer packageServer, @NonNull String name) {
		this.packageServer = packageServer;
		this.name = name;
		this.packageManager = packageServer.getPackageManager();
	}

	void addedMemberOperation(@NonNull Operation pivotOperation) {
		if (operation2operations != null) {
			String operationName = pivotOperation.getName();
			List<List<Operation>> overloads = operation2operations.get(operationName);
			if (overloads == null) {
				overloads = new ArrayList<List<Operation>>();
				operation2operations.put(operationName, overloads);
			}
			List<Operation> overload = findOverload(overloads, pivotOperation);
			if (overload == null) {
				overload = new ArrayList<Operation>();
				overloads.add(overload);
			}
			if (!overload.contains(pivotOperation)) {
				overload.add(pivotOperation);
			}
		}
	}

	void addedMemberProperty(@NonNull Property pivotProperty) {
		if (property2properties != null) {
			String propertyName = pivotProperty.getName();
			List<Property> properties = property2properties.get(propertyName);
			if (properties == null) {
				properties = new ArrayList<Property>();
				property2properties.put(propertyName, properties);
			}
			if (!properties.contains(pivotProperty)) {
				properties.add(pivotProperty);
			}
		}
	}

	void changedInheritance() {
		if (executorType != null) {
			executorType.uninstall();
			executorType = null;
		}
	}
	
	protected @NonNull Type createSpecialization(@NonNull List<? extends ParameterableElement> templateArguments) {
		Type unspecializedType = primaryType;
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
		Orphanage.getOrphanage(metaModelManager.getPivotResourceSet()).add(specializedType);
//		specializeableClassServer.metaModelManager.addOrphanClass(specializedType);
		return specializedType;
	}

	void dispose() {
		if (!trackers.isEmpty()) {
			Collection<TypeTracker> savedTypeTrackers = new ArrayList<TypeTracker>(trackers);
			trackers.clear();
			for (TypeTracker typeTracker : savedTypeTrackers) {
				typeTracker.dispose();
			}
		}
		if (property2properties != null) {
			property2properties.clear();
			property2properties = null;
		}
		if (operation2operations != null) {
			operation2operations.clear();
			operation2operations = null;
		}
		if (executorType != null) {
			executorType.dispose();
			executorType = null;
		}
		packageServer.disposedTypeServer(this);
	}
	
	void disposedTypeTracker(@NonNull TypeTracker typeTracker) {
		trackers.remove(typeTracker);
		setPrimaryType();
		if (trackers.size() <= 0) {
			dispose();
		}
		packageManager.disposedTypeTracker(typeTracker);
	}
	
	private @Nullable List<Operation> findOverload(@NonNull List<List<Operation>> overloads, @NonNull Operation requiredOperation) {
		List<Parameter> requiredParameters;
		if (requiredOperation instanceof Iteration) {
			requiredParameters = ((Iteration)requiredOperation).getOwnedIterator();
		}
		else {
			requiredParameters = requiredOperation.getOwnedParameter();
		}
		MetaModelManager metaModelManager = packageManager.getMetaModelManager();
		int requiredSize = requiredParameters.size();
		for (List<Operation> overload : overloads) {
			if (overload.size() > 0) {
				Operation operation = overload.get(0);
				List<Parameter> actualParameters;
				if (operation instanceof Iteration) {
					actualParameters = ((Iteration)operation).getOwnedIterator();
				}
				else {
					actualParameters = operation.getOwnedParameter();
				}
				if (requiredSize == actualParameters.size()) {
					boolean gotIt = true;
					for (int i = 0; i < requiredSize; i++) {
						Parameter requiredParameter = requiredParameters.get(i);
						Parameter actualParameter = actualParameters.get(i);
						Type requiredType = metaModelManager.getTypeWithMultiplicity(requiredParameter);
						Type actualType = metaModelManager.getTypeWithMultiplicity(actualParameter);
						if (requiredType != actualType) {
							gotIt = false;
							break;
						}
					}
					if (gotIt) {
						return overload;
					}
				}
			}
		}			
		return null;
	}

	Type findSpecialization(@NonNull List<WeakReference<Type>> partialSpecializations, @NonNull List<? extends ParameterableElement> templateArguments) {
		for (int j = partialSpecializations.size(); --j >= 0; ) {
			Type specializedType = partialSpecializations.get(j).get();
			if (specializedType == null) {
				partialSpecializations.remove(j);
			}
			else {
				int i = 0;
				boolean gotIt = true;
				for (TemplateBinding templateBinding : specializedType.getTemplateBinding()) {
					for (TemplateParameterSubstitution parameterSubstitution : templateBinding.getParameterSubstitution()) {
						if (i > 0) {
							ParameterableElement requiredTemplateArgument = templateArguments.get(i);
							ParameterableElement actualTemplateArgument = parameterSubstitution.getActual();
							if (requiredTemplateArgument != actualTemplateArgument) {			// WIP isEquals ???
								gotIt = false;
								break;
							}
						}
						i++;
					}
					if (!gotIt) {
						break;
					}
				}
				if (gotIt) {
					return specializedType;
				}
			}
		}
		return null;
	}

	public synchronized Type findSpecializedType(@NonNull List<? extends ParameterableElement> templateArguments) {
		TemplateSignature templateSignature = primaryType.getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getParameter();
		int iMax = templateParameters.size();
		if (templateArguments.size() != iMax) {
			return null;
		}
		if (firstActual2specializations == null) {
			return null;
		}
		ParameterableElement firstTemplateArgument = templateArguments.get(0);
		List<WeakReference<Type>> partialSpecializations = firstActual2specializations.get(firstTemplateArgument);
		if (partialSpecializations == null) {
			return null;
		}
		return findSpecialization(partialSpecializations, templateArguments);
	}

	public @NonNull ReflectiveType getExecutorType() {
		if (executorType == null) {
			PivotReflectivePackage executorPackage = packageServer.getExecutorPackage();
			executorType = executorPackage.getInheritance(primaryType);
		}
		@SuppressWarnings("null")
		@NonNull ReflectiveType executorType2 = executorType;
		return executorType2;
	}

	public @Nullable Operation getMemberOperation(@NonNull Operation pivotOperation) {
		if (operation2operations == null) {
			initMemberOperations();
		}
		String operationName = pivotOperation.getName();
		List<List<Operation>> overloads = operation2operations.get(operationName);
		if (overloads == null) {
			return null;
		}
		List<Operation> overload = findOverload(overloads, pivotOperation);
		if (overload == null) {
			return null;
		}
		return overload.isEmpty() ? null : overload.get(0);
	}

	public @Nullable Iterable<Operation> getMemberOperations(@NonNull Operation pivotOperation) {
		if (operation2operations == null) {
			initMemberOperations();
		}
		String operationName = pivotOperation.getName();
		List<List<Operation>> overloads = operation2operations.get(operationName);
		if (overloads == null) {
			return null;
		}
		return findOverload(overloads, pivotOperation);
	}

	public @Nullable Iterable<Property> getMemberProperties(@NonNull Property pivotProperty) {
		if (property2properties == null) {
			initMemberProperties();
		}
		String propertyName = pivotProperty.getName();
		return property2properties.get(propertyName);
	}

	public @Nullable Property getMemberProperty(@NonNull String propertyName) {
		if (property2properties == null) {
			initMemberProperties();
		}
		List<Property> properties = property2properties.get(propertyName);
		if (properties == null) {
			return null;
		}
		return properties.isEmpty() ? null : properties.get(0);
	}

	@SuppressWarnings("null")
	public @NonNull String getName() {
		return name;
	}

	@SuppressWarnings("null")
	public final @NonNull PackageManager getPackageManager() {
		return packageManager;
	}

	public @NonNull Type getPrimaryType() {
		Type thePrimaryType = primaryType;
		if (thePrimaryType == null) {
			throw new IllegalStateException("Missing primary type");
		}
		return thePrimaryType;
	}

	public synchronized @NonNull Type getSpecializedType(@NonNull List<? extends ParameterableElement> templateArguments) {
		TemplateSignature templateSignature = primaryType.getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getParameter();
		int iMax = templateParameters.size();
		if (templateArguments.size() != iMax) {
			throw new IllegalArgumentException("Incompatible template argument count");
		}
		if (firstActual2specializations == null) {
			firstActual2specializations = new HashMap<ParameterableElement, List<WeakReference<Type>>>();
		}
		ParameterableElement firstTemplateArgument = templateArguments.get(0);
		List<WeakReference<Type>> partialSpecializations = firstActual2specializations.get(firstTemplateArgument);
		if (partialSpecializations == null) {
			partialSpecializations = new ArrayList<WeakReference<Type>>();
			firstActual2specializations.put(firstTemplateArgument, partialSpecializations);
		}
		Type specializedType = findSpecialization(partialSpecializations, templateArguments);
		if (specializedType == null) {
			specializedType = createSpecialization(templateArguments);
			partialSpecializations.add(new WeakReference<Type>(specializedType));
		}
		return specializedType;
	}

	public @NonNull Iterable<Type> getTrackedTypes() {
		@SuppressWarnings("null")
		@NonNull Iterable<Type> transform = Iterables.transform(trackers, TypeTracker.tracker2type);
		return transform;
	}

	public @NonNull TypeTracker getTypeTracker(@NonNull Type pivotType) {
		for (TypeTracker typeTracker : trackers) {
			if (typeTracker.getTarget() == pivotType) {
				return typeTracker;
			}
		}
		TypeTracker typeTracker = new TypeTracker(this, pivotType);
		packageManager.addTypeTracker(pivotType, typeTracker);
		if (operation2operations != null) {
			initMemberOperations(pivotType);
		}	
		if (property2properties != null) {
			initMemberProperties(pivotType);
		}	
		trackers.add(typeTracker);
		if (trackers.size() == 1) {
			setPrimaryType();
		}
		return typeTracker;
	}

	@SuppressWarnings("null")
	public @NonNull List<TypeTracker> getTypeTrackers() {
		return trackers;
	}

	private void initMemberOperations() {
		if (operation2operations == null) {
			operation2operations = new HashMap<String, List<List<Operation>>>();
			for (TypeTracker typeTracker : trackers) {
				initMemberOperations(typeTracker.getTarget());
			}
		}	
	}

	private  void initMemberOperations(@NonNull Type type) {
		for (Operation pivotOperation : type.getOwnedOperation()) {
			if (pivotOperation != null) {
				addedMemberOperation(pivotOperation);
			}
		}
	}

	private void initMemberProperties() {
		if (property2properties == null) {
			property2properties = new HashMap<String, List<Property>>();
			for (TypeTracker typeTracker : trackers) {
				initMemberProperties(typeTracker.getTarget());
			}
		}	
	}

	private  void initMemberProperties(@NonNull Type type) {
		for (Property pivotProperty : type.getOwnedAttribute()) {
			if (pivotProperty != null) {
				addedMemberProperty(pivotProperty);
			}
		}
	}

	void removedMemberOperation(@NonNull Operation pivotOperation) {
		if (operation2operations != null) {
			String operationName = pivotOperation.getName();
			List<List<Operation>> overloads = operation2operations.get(operationName);
			if (overloads == null) {
				overloads = new ArrayList<List<Operation>>();
				operation2operations.put(operationName, overloads);
			}
			List<Operation> overload = findOverload(overloads, pivotOperation);
			if (overload != null) {
				overload.remove(pivotOperation);
				if (overload.isEmpty()) {
					overloads.remove(overload);
					if (overloads.isEmpty()) {
						operation2operations.remove(operationName);
					}
				}
			}
		}
	}

	void removedMemberProperty(@NonNull Property pivotProperty) {
		if (property2properties != null) {
			String propertyName = pivotProperty.getName();
			List<Property> properties = property2properties.get(propertyName);
			if (properties != null) {
				properties.remove(propertyName);
				if (properties.isEmpty()) {
					property2properties.remove(propertyName);
				}
			}
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
				@SuppressWarnings("null")
				@NonNull Type unspecializedSuperType = PivotUtil.getUnspecializedTemplateableElement(superType);
				TypeServer superTypeServer = metaModelManager.getTypeServer(unspecializedSuperType);
/*				List<ParameterableElement> superTemplateArgumentList = new ArrayList<ParameterableElement>();
				for (TemplateBinding templateBinding : superTemplateBindings) {
					for (TemplateParameterSubstitution parameterSubstitution : templateBinding.getParameterSubstitution()) {
						ParameterableElement templateArgument = parameterSubstitution.getActual();
						superTemplateArgumentList.add(templateArgument);
					}
				} */
				if (superTypeServer != null) {
					Type specializedSuperType = superTypeServer.getSpecializedType(superTemplateArgumentList);
					specializedClass.getSuperClass().add(specializedSuperType);
				}
			}
			else {
				specializedClass.getSuperClass().add(superType);
			}
		}
	}

	void setPrimaryType() {
		if (trackers.size() > 0) {
			primaryType = trackers.get(0).getTarget();
		}
		else {
			primaryType = null;
		}
	}

	@Override
	public String toString() {
		return String.valueOf(primaryType);
	}
}
