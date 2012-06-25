/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.examples.library.executor;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.examples.domain.elements.DomainClassifierType;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.types.AbstractClassifierType;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;

public class ExecutorStandardLibrary extends ExecutableStandardLibrary
{
//	private Map<EPackage, EcoreExecutorPackage> ePackageMap = new HashMap<EPackage, EcoreExecutorPackage>();
	private Map<String, WeakReference<EcoreExecutorPackage>> ePackageMap = new WeakHashMap<String, WeakReference<EcoreExecutorPackage>>();
	private Map<DomainPackage, WeakReference<DomainReflectivePackage>> domainPackageMap = null;
	private Map<EClassifier, WeakReference<ExecutorType>> typeMap = new WeakHashMap<EClassifier, WeakReference<ExecutorType>>();
//	private Map<Class<?>, DomainEnumeration> enumerationMap = null;
	
	public ExecutorStandardLibrary(EcoreExecutorPackage... execPackages) {
		OCLstdlibTables.PACKAGE.getClass();
		for (EcoreExecutorPackage execPackage : execPackages) {
			addPackage(execPackage);
		}
	}

	public synchronized void addPackage(EcoreExecutorPackage execPackage) {
		@SuppressWarnings("unused")
		WeakReference<EcoreExecutorPackage> oldExecPackage = ePackageMap.put(execPackage.getNsURI(), new WeakReference<EcoreExecutorPackage>(execPackage));
//		if ((oldExecPackage != null) && (oldExecPackage != execPackage)) {
//			Iterable<ExecutorType> newTypes = execPackage.getOwnedType();
//			for (DomainType oldType : oldExecPackage.getOwnedType()) {
//				-- check for type compatibility
//			}
//		}
	}

	@Override
	protected DomainClassifierType createClassifierType(DomainType classType) {
		DomainType anyClassifierType = getAnyClassifierType();
		DomainClassifierType classifierType = new AbstractClassifierType(this, anyClassifierType, classType);
		return classifierType;
	}
	
	@Override
	public DomainEvaluator createEvaluator(EObject contextObject, Map<Object, Object> contextMap) {
		return new EcoreExecutorManager(contextObject, contextMap, this);
	}

/*	@Override
	public DomainEnumeration getEnumeration(Enumerator enumerator) {
		Class<?> enumeratorClass = enumerator.getClass();
		String enumerationName = enumeratorClass.getSimpleName();
		if (enumerationMap == null) {
			enumerationMap = new HashMap<Class<?>, DomainEnumeration>();
		}
		else {
			DomainEnumeration enumeration = enumerationMap.get(enumeratorClass);
			if (enumeration != null) {
				return enumeration;
			}
		}
		Package enumeratorPackage = enumeratorClass.getPackage();
		for (EcoreExecutorPackage dPackage : ePackageMap.values()) {
// FIXME			if (OCLstdlibTables.PACKAGE.getNsURI().equals(dPackage.getNsURI())) {	
							ExecutorType type = dPackage.getType(enumerationName);
							if (type != null) {
								enumerationMap.put(enumeratorClass, (DomainEnumeration)type);
								return (DomainEnumeration)type;
							}
//						}
					}
		return super.getEnumeration(enumerator);
	} */

	public DomainInheritance getInheritance(DomainType type) {
		if (type instanceof DomainInheritance) {
			return (DomainInheritance) type;
		}
		if (type instanceof DomainClassifierType) {
			DomainType instanceType = ((DomainClassifierType)type).getInstanceType();
			DomainClassifierType classifierType = getClassifierType(instanceType);
			DomainType containerType = classifierType.getContainerType();
			return containerType.getInheritance(this);
		}
		if (type instanceof DomainCollectionType) {
			DomainType containerType = ((DomainCollectionType)type).getContainerType();
			if ((containerType != null) && (containerType != type)) {
				return containerType.getInheritance(this);
			}
		}
		DomainPackage domainPackage = type.getPackage();
		synchronized (this) {
			String nsURI = domainPackage.getNsURI();
			EcoreExecutorPackage ecoreExecutorPackage = weakGet(ePackageMap, nsURI);
			if (ecoreExecutorPackage != null) {
				ExecutorType executorType = ecoreExecutorPackage.getType(type.getName());
				if (executorType != null) {
					return executorType;
				}
			}
			if (domainPackageMap == null) {
				domainPackageMap = new WeakHashMap<DomainPackage, WeakReference<DomainReflectivePackage>>();
			}
		}
		synchronized (domainPackageMap) {
			DomainReflectivePackage domainExecutorPackage = weakGet(domainPackageMap, domainPackage);
			if (domainExecutorPackage == null) {
				domainExecutorPackage = new DomainReflectivePackage(this, domainPackage);
				domainPackageMap.put(domainPackage, new WeakReference<DomainReflectivePackage>(domainExecutorPackage));
			}
			return domainExecutorPackage.getInheritance(type);
		}
	}

	public synchronized EcoreExecutorPackage getPackage(EPackage ePackage) {
		return weakGet(ePackageMap, ePackage.getNsURI());
	}

	public synchronized ExecutorType getOclType(String typeName) {
		for (WeakReference<EcoreExecutorPackage> dPackage : ePackageMap.values()) {
// FIXME			if (OCLstdlibTables.PACKAGE.getNsURI().equals(dPackage.getNsURI())) {
			if (dPackage != null) {
				EcoreExecutorPackage packageRef = dPackage.get();
				if (packageRef != null) {
					ExecutorType type = packageRef.getType(typeName);
					if (type != null) {
						return type;
					}
				}
			}
		}
		return null;
	}

	public synchronized ExecutorType getType(EClassifier eClassifier) {
		ExecutorType type = weakGet(typeMap, eClassifier);
		if (type == null) {
			EcoreExecutorPackage execPackage = getPackage(eClassifier.getEPackage());
			if (execPackage != null) {
				type = execPackage.getType(eClassifier.getName());
				typeMap.put(eClassifier, new WeakReference<ExecutorType>(type));
			}
		}
		return type;
	}
}
