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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainFragment;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.types.AbstractFragment;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ReflectiveType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.executor.PivotReflectiveFragment;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * An AbstractTypeServer provides the co-ordinated operation, property and superclass lookup caches for one or more merged types.
 */
public abstract class AbstractTypeServer extends ReflectiveType implements TypeServer
{
	public static final class BestOperation implements Function<List<DomainOperation>, DomainOperation> {

		public DomainOperation apply(List<DomainOperation> operations) {
			return operations.get(0);
		}
	}

	public static final class MapValues implements Function<Map<Iterable<? extends DomainType>, List<DomainOperation>>, Iterable<List<DomainOperation>>> {

		public Iterable<List<DomainOperation>> apply(Map<Iterable<? extends DomainType>, List<DomainOperation>> operations) {
			return operations.values();
		}
	}
	
	public static final class RejectStaticOperation implements Predicate<DomainOperation>
	{
		public boolean apply(DomainOperation operation) {
			return !operation.isStatic();
		}
	}

	public static final class RejectStaticProperty implements Predicate<DomainProperty>
	{
		public boolean apply(DomainProperty property) {
			return !property.isStatic();
		}
	}
	
	public static final class SelectStaticOperation implements Predicate<DomainOperation>
	{
		public boolean apply(DomainOperation operation) {
			return operation.isStatic();
		}
	}

	public static final class SelectStaticProperty implements Predicate<DomainProperty>
	{
		public boolean apply(DomainProperty property) {
			return property.isStatic();
		}
	}

	public static final @NonNull BestOperation bestOperation = new BestOperation();
	public static final @NonNull MapValues MAP_VALUES = new MapValues();	

	protected static class QualifiedName2DomainInheritance implements Function<String, DomainInheritance>
	{
		protected final @NonNull Map<String, DomainInheritance> name2superclasses;
		
		protected QualifiedName2DomainInheritance(@NonNull Map<String, DomainInheritance> name2superclasses) {
			this.name2superclasses = name2superclasses;
		}

		public DomainInheritance apply(String qualifiedClassName) {
			return name2superclasses.get(qualifiedClassName);
		}
	}

	public  static final Predicate<DomainOperation> REJECT_STATIC_OPERATION = new RejectStaticOperation();

	public  static final Predicate<DomainProperty> REJECT_STATIC_PROPERTY = new RejectStaticProperty();

	public  static final Predicate<DomainOperation> SELECT_STATIC_OPERATION = new SelectStaticOperation();

	public  static final Predicate<DomainProperty> SELECT_STATIC_PROPERTY = new SelectStaticProperty();

	protected final @NonNull PackageServer packageServer;
	protected final @NonNull PackageManager packageManager;

	/**
	 * Lazily created map from class name to the superclass. This is a map from unqualified name to
	 * class for the normal case when all superclass names are distinct. However if any two superclasses
	 * including this class share a name, all superclasses are mapped by qualified name, and the
	 * name2qualifiedNames provides an additional mapping of the ambiguities.
	 */
	private @Nullable Map<String, DomainInheritance> name2superclasses = null;

	/**
	 * Lazily created map from class name to the list of qualified names for same-named super-classes.
	 * This list is only non-null if a class has two same-named superclasses that need disambiguation..
	 */
	private @Nullable Map<String, List<String>> name2qualifiedNames = null;

	/**
	 * Lazily created map from operation name to map of parameter types to the list of partial operations to be treated as merged.
	 */
	private @Nullable Map<String, Map<Iterable<? extends DomainType>, List<DomainOperation>>> name2operations = null;

	/**
	 * Lazily created map from property name to the list of properties to be treated as merged. 
	 */
	private @Nullable Map<String, List<DomainProperty>> name2properties = null;
	
	protected AbstractTypeServer(@NonNull PackageServer packageServer, @NonNull DomainType domainType) {
		super(DomainUtil.nonNullModel(domainType.getName()), packageServer, computeFlags(domainType));
		this.packageServer = packageServer;
		this.packageManager = packageServer.getPackageManager();
	}

	void addedMemberOperation(@NonNull DomainOperation pivotOperation) {
		Map<String, Map<Iterable<? extends DomainType>, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 != null) {
			String operationName = pivotOperation.getName();
			Map<Iterable<? extends DomainType>, List<DomainOperation>> overloads = name2operations2.get(operationName);
			if (overloads == null) {
				overloads = new HashMap<Iterable<? extends DomainType>, List<DomainOperation>>();
				name2operations2.put(operationName, overloads);
			}
			Iterable<? extends DomainType> parameterTypes = getParameterTypes(pivotOperation);
			List<DomainOperation> partials = overloads.get(parameterTypes);
			if (partials == null) {
				partials = new ArrayList<DomainOperation>();
				overloads.put(parameterTypes, partials);
			}
			if (!partials.contains(pivotOperation)) {
				partials.add(pivotOperation);
			}
		}
	}

	void addedMemberProperty(@NonNull DomainProperty pivotProperty) {
		Map<String, List<DomainProperty>> name2properties2 = name2properties;
		if (name2properties2 != null) {
			String propertyName = pivotProperty.getName();
			List<DomainProperty> partials = name2properties2.get(propertyName);
			if (partials == null) {
				partials = new ArrayList<DomainProperty>();
				name2properties2.put(propertyName, partials);
			}
			if (!partials.contains(pivotProperty)) {
				partials.add(pivotProperty);
			}
		}
	}

	void changedInheritance() {
//		if (executorType != null) {
			/*executorType.*/uninstall();
//			executorType = null;
//		}
	}

	@Override
	protected @NonNull AbstractFragment createFragment(@NonNull DomainInheritance baseInheritance) {
		return new PivotReflectiveFragment(this, baseInheritance);
	}

	@Override
	public void dispose() {
		Map<String, List<DomainProperty>> name2properties2 = name2properties;
		if (name2properties2 != null) {
			name2properties2.clear();
			name2properties = null;
		}
		Map<String, Map<Iterable<? extends DomainType>, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 != null) {
			name2operations2.clear();
			name2operations = null;
		}
//		if (executorType != null) {
//			executorType.dispose();
//			executorType = null;
//		}
	}
	
/*	private @Nullable List<DomainOperation> findOverload(@NonNull List<List<DomainOperation>> overloads, @NonNull DomainOperation requiredOperation) {
		if (requiredOperation instanceof Iteration) {
			List<Parameter> requiredParameters = ((Iteration)requiredOperation).getOwnedIterator();
			MetaModelManager metaModelManager = packageManager.getMetaModelManager();
			int requiredSize = requiredParameters.size();
			for (List<DomainOperation> overload : overloads) {
				if (overload.size() > 0) {
					DomainOperation operation = overload.get(0);
					List<Parameter> actualParameters = ((Iteration)operation).getOwnedIterator();
					if (requiredSize == actualParameters.size()) {
						boolean gotIt = true;
						for (int i = 0; i < requiredSize; i++) {
							Parameter requiredParameter = DomainUtil.nonNullEntry(requiredParameters.get(i));
							Parameter actualParameter = DomainUtil.nonNullEntry(actualParameters.get(i));
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
		else {
			IndexableIterable<? extends DomainType> requiredParameters = requiredOperation.getParameterType();
			MetaModelManager metaModelManager = packageManager.getMetaModelManager();
			int requiredSize = requiredParameters.size();
			for (List<DomainOperation> overload : overloads) {
				if (overload.size() > 0) {
					DomainOperation operation = overload.get(0);
					IndexableIterable<? extends DomainType> actualParameters = operation.getParameterType();
					if (requiredSize == actualParameters.size()) {
						boolean gotIt = true;
						for (int i = 0; i < requiredSize; i++) {
							DomainType requiredParameter = DomainUtil.nonNullEntry(requiredParameters.get(i));
							DomainType actualParameter = DomainUtil.nonNullEntry(actualParameters.get(i));
							Type requiredType = metaModelManager.getType/ *WithMultiplicity* /(requiredParameter);		// FIXME
							Type actualType = metaModelManager.getType/ *WithMultiplicity* /(actualParameter);
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
	} */

	public @NonNull Iterable<? extends DomainOperation> getAllOperations(@Nullable Boolean selectStatic) {
		Map<String, Map<Iterable<? extends DomainType>, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = initMemberOperations();
		}
		Iterable<Map<Iterable<? extends DomainType>, List<DomainOperation>>> itMapListOps = name2operations2.values();
		@SuppressWarnings("null")
		@NonNull Iterable<Iterable<List<DomainOperation>>> itItListOps = Iterables.transform(itMapListOps, MAP_VALUES);
		@SuppressWarnings("null")
		@NonNull Iterable<List<DomainOperation>> itListOps = Iterables.concat(itItListOps);
		@SuppressWarnings("null")
		@NonNull Iterable<DomainOperation> itOps = Iterables.concat(itListOps);
		if (selectStatic == null) {
			return itOps;			
		}
		else {
			@SuppressWarnings("null")
			@NonNull Iterable<DomainOperation> subItOps = Iterables.filter(itOps, selectStatic ? SELECT_STATIC_OPERATION : REJECT_STATIC_OPERATION);
			return subItOps;
		}
	}
	

	public @NonNull Iterable<? extends DomainOperation> getAllOperations(@Nullable Boolean selectStatic, @NonNull String name) {
		Map<String, Map<Iterable<? extends DomainType>, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = initMemberOperations();
		}
		Map<Iterable<? extends DomainType>, List<DomainOperation>> overloads = name2operations2.get(name);
		if ((overloads == null) || overloads.isEmpty()) {
			return MetaModelManager.EMPTY_OPERATION_LIST;
		}
		@SuppressWarnings("null")
		@NonNull Iterable<DomainOperation> transform = Iterables.transform(overloads.values(), bestOperation);
		if (selectStatic == null) {
			return transform;			
		}
		else {
			@SuppressWarnings("null")
			@NonNull Iterable<DomainOperation> subItOps = Iterables.filter(transform, selectStatic ? SELECT_STATIC_OPERATION : REJECT_STATIC_OPERATION);
			return subItOps;
		}
	}

	public @NonNull Iterable<? extends DomainProperty> getAllProperties(@Nullable Boolean selectStatic) {
		Map<String, List<DomainProperty>> name2properties2 = name2properties;
		if (name2properties2 == null) {
			name2properties2 = initMemberProperties();
		}
		@SuppressWarnings("null")
		@NonNull Iterable<DomainProperty> transform = Iterables.transform(name2properties2.values(), new Function<List<DomainProperty>, DomainProperty>()
			{
				public DomainProperty apply(List<DomainProperty> properties) {
					return properties.get(0);
				}
			});
		if (selectStatic == null) {
			return transform;			
		}
		else {
			@SuppressWarnings("null")
			@NonNull Iterable<DomainProperty> subItOps = Iterables.filter(transform, selectStatic ? SELECT_STATIC_PROPERTY : REJECT_STATIC_PROPERTY);
			return subItOps;
		}
	}

	public @NonNull Iterable<? extends DomainProperty> getAllProperties(@Nullable Boolean selectStatic, @NonNull String name) {
		Map<String, List<DomainProperty>> name2properties2 = name2properties;
		if (name2properties2 == null) {
			name2properties2 = initMemberProperties();
		}
		List<DomainProperty> partials = name2properties2.get(name);
		if ((partials == null) || partials.isEmpty()) {
			return MetaModelManager.EMPTY_PROPERTY_LIST;
		}
		@SuppressWarnings("null")
		@NonNull List<DomainProperty> singletonList = Collections.singletonList(partials.get(0));
		if (selectStatic == null) {
			return singletonList;			
		}
		else {
			@SuppressWarnings("null")
			@NonNull Iterable<DomainProperty> subItOps = Iterables.filter(singletonList, selectStatic ? SELECT_STATIC_PROPERTY : REJECT_STATIC_PROPERTY);
			return subItOps;
		}
	}

	public @NonNull Iterable<? extends DomainInheritance> getAllSuperClasses() {
		Map<String, DomainInheritance> name2superclasses2 = name2superclasses;
		if (name2superclasses2 == null) {
			name2superclasses2 = initSuperClasses();
		}
		@SuppressWarnings("null")
		@NonNull Collection<DomainInheritance> values = name2superclasses2.values();
		return values;
	}

	public @NonNull Iterable<? extends DomainInheritance> getAllSuperClasses(@NonNull String className) {
		Map<String, DomainInheritance> name2superclasses2 = name2superclasses;
		if (name2superclasses2 == null) {
			name2superclasses2 = initSuperClasses();
		}
		final Map<String, List<String>> name2qualifiedNames2 = name2qualifiedNames;
		if (name2qualifiedNames2 == null) {
			DomainInheritance typeServer = name2superclasses2.get(className);
			if (typeServer == null) {
				return MetaModelManager.EMPTY_TYPE_SERVER_LIST;
			}
			@SuppressWarnings("null")
			@NonNull List<DomainInheritance> asList = Arrays.asList(typeServer);
			return asList;
		}
		else {
			List<String> qualifiedNames = name2qualifiedNames2.get(className);
			if (qualifiedNames == null) {
				return MetaModelManager.EMPTY_TYPE_SERVER_LIST;
			}
			else {
				@SuppressWarnings("null")
				@NonNull Iterable<DomainInheritance> transform = Iterables.transform(qualifiedNames, new QualifiedName2DomainInheritance(name2superclasses2));
				return transform;
			}
		}
	}

	@Override
	public @NonNull Iterable<? extends DomainInheritance> getInitialSuperInheritances() {
		final @NonNull MetaModelManager metaModelManager = packageManager.getMetaModelManager();
		final Iterator<Type> iterator = metaModelManager.getSuperClasses(getPivotType()).iterator();			// FIXME Use local cache
		return new Iterable<DomainInheritance>()
		{
			public Iterator<DomainInheritance> iterator() {
				return new Iterator<DomainInheritance>()
				{
					public boolean hasNext() {
						return iterator.hasNext();
					}

					public DomainInheritance next() {
						return iterator.next().getInheritance(metaModelManager);
					}

					public void remove() {
						throw new UnsupportedOperationException();
					}					
				};
			}			
		};
	}
	
	public @NonNull Iterable<? extends DomainOperation> getLocalOperations() {
		return DomainUtil.nonNullEMF(getPivotType().getOwnedOperation());			// FIXME Use local cache
	}

	public @NonNull Iterable<? extends DomainProperty> getLocalProperties() {
		return DomainUtil.nonNullEMF(getPivotType().getOwnedAttribute());			// FIXME Use local cache
	}

	public @NonNull Iterable<? extends DomainType> getLocalSuperTypes() {
		return DomainUtil.nonNullEMF(getPivotType().getSuperClass());			// FIXME Use local cache
	}

	public @Nullable DomainOperation getMemberOperation(@NonNull DomainOperation pivotOperation) {
		Map<String, Map<Iterable<? extends DomainType>, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = initMemberOperations();
		}
		String operationName = pivotOperation.getName();
		Map<Iterable<? extends DomainType>, List<DomainOperation>> overloads = name2operations2.get(operationName);
		if (overloads == null) {
			return null;
		}
		Iterable<? extends DomainType> parameterTypes = getParameterTypes(pivotOperation);
		List<DomainOperation> partials = overloads.get(parameterTypes);
		return (partials == null) || partials.isEmpty() ? null : partials.get(0);
	}

	public @Nullable Iterable<DomainOperation> getMemberOperations(@NonNull DomainOperation pivotOperation) {
		Map<String, Map<Iterable<? extends DomainType>, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = initMemberOperations();
		}
		String operationName = pivotOperation.getName();
		Map<Iterable<? extends DomainType>, List<DomainOperation>> overloads = name2operations2.get(operationName);
		if (overloads == null) {
			return null;
		}
		Iterable<? extends DomainType> parameterTypes = getParameterTypes(pivotOperation);
		return overloads.get(parameterTypes);
	}

	public @Nullable Iterable<DomainProperty> getMemberProperties(@NonNull DomainProperty pivotProperty) {
		Map<String, List<DomainProperty>> name2properties2 = name2properties;
		if (name2properties2 == null) {
			name2properties2 = initMemberProperties();
		}
		String propertyName = pivotProperty.getName();
		return name2properties2.get(propertyName);
	}

	public @Nullable DomainProperty getMemberProperty(@NonNull String propertyName) {
		Map<String, List<DomainProperty>> name2properties2 = name2properties;
		if (name2properties2 == null) {
			name2properties2 = initMemberProperties();
		}
		List<DomainProperty> partials = name2properties2.get(propertyName);
		if (partials == null) {
			return null;
		}
		return partials.isEmpty() ? null : partials.get(0);
	}

	public @NonNull String getMetaTypeName() {
		return getPivotType().getMetaTypeName();
	}

	public final @NonNull PackageManager getPackageManager() {
		return packageManager;
	}

	public PackageServer getPackageServer() {
		return packageServer;
	}
	
	private @Nullable Iterable<? extends DomainType> getParameterTypes(@NonNull DomainOperation operation) {
		if (operation instanceof Iteration) {
			return operation.getParameterType();
/*			List<Parameter> requiredParameters = ((Iteration)operation).getOwnedIterator();
			MetaModelManager metaModelManager = packageManager.getMetaModelManager();
			int requiredSize = requiredParameters.size();
			for (List<DomainOperation> overload : overloads) {
				if (overload.size() > 0) {
					DomainOperation operation = overload.get(0);
					List<Parameter> actualParameters = ((Iteration)operation).getOwnedIterator();
					if (requiredSize == actualParameters.size()) {
						boolean gotIt = true;
						for (int i = 0; i < requiredSize; i++) {
							Parameter requiredParameter = DomainUtil.nonNullEntry(requiredParameters.get(i));
							Parameter actualParameter = DomainUtil.nonNullEntry(actualParameters.get(i));
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
			return null; */
		}
		else {
			return operation.getParameterType();
		}
	}

	public final @NonNull DomainStandardLibrary getStandardLibrary() {
		return packageManager.getMetaModelManager();
	}

	private @NonNull Map<String, Map<Iterable<? extends DomainType>, List<DomainOperation>>> initMemberOperations() {
		Map<String, Map<Iterable<? extends DomainType>, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 == null) {
			name2operations2 = name2operations = new HashMap<String, Map<Iterable<? extends DomainType>, List<DomainOperation>>>();
			for (DomainInheritance superClass : getAllSuperClasses()) {
				TypeServer superTypeServer = null;
				if (superClass instanceof TypeServer) {
					superTypeServer = (TypeServer)superClass;
				}
				else if (superClass != null) {
					superTypeServer = packageManager.getTypeServer(superClass);
				}
				if (superTypeServer != null) {
					for (DomainType superType : superTypeServer.getPartialTypes()) {
						if (superType != null) {
							initMemberOperationsFrom(superType);
						}
					}
				}
			}
			for (Map<Iterable<? extends DomainType>, List<DomainOperation>> overloads : name2operations2.values()) {
				for (List<DomainOperation> operations : overloads.values()) {
					if (operations != null) {
						initMemberOperationsPostProcess(name, operations);
					}
				}
			}
		}	
		return name2operations2;
	}

	private void initMemberOperationsFrom(@NonNull DomainType type) {
		for (DomainOperation pivotOperation : type.getLocalOperations()) {
			if (pivotOperation != null) {
				addedMemberOperation(pivotOperation);
			}
		}
	}

	protected void initMemberOperationsPostProcess(@NonNull String name, @NonNull List<DomainOperation> operations) {
		// TODO Auto-generated method stub // FIXME Prune occlusions		
	}

	private @NonNull Map<String, List<DomainProperty>> initMemberProperties() {
//		System.out.println("initMemberProperties " + toString());
		Map<String, List<DomainProperty>> name2properties2 = name2properties;
		if (name2properties2 == null) {
			name2properties2 = name2properties = new HashMap<String, List<DomainProperty>>();
			for (DomainInheritance superClass : getAllSuperClasses()) {
				TypeServer superTypeServer = null;
				if (superClass instanceof TypeServer) {
					superTypeServer = (TypeServer)superClass;
				}
				else if (superClass != null) {
					superTypeServer = packageManager.getTypeServer(superClass);
				}
				if (superTypeServer != null) {
					for (DomainType superType : superTypeServer.getPartialTypes()) {
						if (superType != null) {
							initMemberPropertiesFrom(superType);
						}
					}
				}
			}
			for (List<DomainProperty> properties : name2properties2.values()) {
				if (properties != null) {
					initMemberPropertiesPostProcess(name, properties);
				}
			}
		}	
		return name2properties2;
	}

	private void initMemberPropertiesFrom(@NonNull DomainType type) {
		for (DomainProperty pivotProperty : type.getLocalProperties()) {
			if (pivotProperty != null) {
				addedMemberProperty(pivotProperty);
			}
		}
	}

	protected void initMemberPropertiesPostProcess(@NonNull String name, @NonNull List<DomainProperty> properties) {
		// TODO Auto-generated method stub // FIXME Prune occlusions		
	}

	protected @NonNull Map<String, DomainInheritance> initSuperClasses() {
//		System.out.println("initSuperClasses " + toString());
		Map<String, DomainInheritance> name2superclasses2 = name2superclasses = new HashMap<String, DomainInheritance>();
		name2qualifiedNames = null;
		for (DomainFragment fragment : getFragments()) {
			DomainInheritance baseInheritance = fragment.getBaseInheritance();
			String name = baseInheritance.getName();
			DomainInheritance oldInheritance = name2superclasses2.put(name, baseInheritance);
			if (oldInheritance != null) {
				name2superclasses2.clear();
				name2qualifiedNames = initSuperClassesWithAmbiguousNames(name2superclasses2, new HashMap<String, List<String>>());
				break;
			}
		}
		return name2superclasses2;
	}

	protected Map<String, List<String>> initSuperClassesWithAmbiguousNames(Map<String, DomainInheritance> name2superclasses2, Map<String, List<String>> name2qualifiedNames2) {
		int counter = 0;
		for (DomainFragment fragment : getFragments()) {
			DomainInheritance baseInheritance = fragment.getBaseInheritance();
			String name = baseInheritance.getName();
			String qualifiedName = Integer.toString(counter++);
			name2superclasses2.put(qualifiedName, baseInheritance);
			List<String> names = name2qualifiedNames2.get(name);
			if (names == null) {
				names = new ArrayList<String>();
				name2qualifiedNames2.put(name, names);
			}
			names.add(name);
		}
		return name2qualifiedNames2;
	}

	void removedMemberOperation(@NonNull DomainOperation pivotOperation) {
		Map<String, Map<Iterable<? extends DomainType>, List<DomainOperation>>> name2operations2 = name2operations;
		if (name2operations2 != null) {
			String operationName = pivotOperation.getName();
			Map<Iterable<? extends DomainType>, List<DomainOperation>> overloads = name2operations2.get(operationName);
			if (overloads != null) {
				Iterable<? extends DomainType> parameterTypes = getParameterTypes(pivotOperation);
				List<DomainOperation> partials = overloads.get(parameterTypes);
				if (partials != null) {
					partials.add(pivotOperation);
					if (partials.isEmpty()) {
						overloads.remove(parameterTypes);
						if (overloads.isEmpty()) {
							name2operations2.remove(operationName);
						}
					}
				}
			}
		}
	}

	void removedMemberProperty(@NonNull DomainProperty pivotProperty) {
		Map<String, List<DomainProperty>> name2properties2 = name2properties;
		if (name2properties2 != null) {
			String propertyName = pivotProperty.getName();
			List<DomainProperty> partials = name2properties2.get(propertyName);
			if (partials != null) {
				partials.remove(propertyName);
				if (partials.isEmpty()) {
					name2properties2.remove(propertyName);
				}
			}
		}
	}

	@Override
	public void uninstall() {
//		System.out.println("uninstall " + toString());
		name2superclasses = null;
		name2properties = null;
		name2operations = null;
		super.uninstall();
	}
}
