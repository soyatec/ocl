/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.library.ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.typeids.Typeid;
import org.eclipse.ocl.examples.domain.typeids.TypeidManager;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorFragment;
import org.eclipse.ocl.examples.library.executor.ExecutorPackage;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.executor.ExecutorTypeParameter;

public class EcoreExecutorType extends ExecutorType
{
	protected @Nullable EClassifier eClassifier;
	private @Nullable Typeid typeid = null;
	
	/**
	 * Construct an executable type descriptor in the absence of a known EClassifier. A subsequent
	 * call of {@link #init(EClassifier)} may define an EClassifier.
	 */
	public EcoreExecutorType(@NonNull String name, @NonNull ExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter... typeParameters) {
		super(name, evaluationPackage, flags, typeParameters);
		this.eClassifier = null;		
	}
	
	/**
	 * Construct an executable type descriptor for a known EClassifier.
	 */
	public EcoreExecutorType(/*@NonNull*/ EClassifier eClassifier, @NonNull EcoreExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter... typeParameters) {
		super(DomainUtil.nonNullModel(eClassifier.getName()), evaluationPackage, flags, typeParameters);
		this.eClassifier = eClassifier;		
	}

	@Override
	public @NonNull ObjectValue createInstance(@NonNull ValueFactory valueFactory) {
		EClassifier eClassifier2 = eClassifier;
		if (eClassifier2 instanceof EClass) {
			EClass eClass = (EClass)eClassifier2;
			EObject element = eClass.getEPackage().getEFactoryInstance().create(eClass);
			return valueFactory.createObjectValue(DomainUtil.nonNullEMF(element));
		}
		return super.createInstance(valueFactory);
	}

	@Override
	public @NonNull Object createInstance(@NonNull ValueFactory valueFactory, @NonNull String value) {
		EClassifier eClassifier2 = eClassifier;
		if (eClassifier2 instanceof EDataType) {
			EDataType eDataType = (EDataType) eClassifier2;
			Object element = eDataType.getEPackage().getEFactoryInstance().createFromString(eDataType, value);
			return valueFactory.valueOf(DomainUtil.nonNullEMF(element));
		}
		return super.createInstance(valueFactory);
	}

	public final EClassifier getEClassifier() {
		return eClassifier;
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return DomainUtil.nonNullModel(DomainUtil.nonNullState(eClassifier).getName());
	}
	
	@Override
	public @NonNull Typeid getTypeid() {
		Typeid typeid2 = typeid;
		if (typeid2 == null) {
			EClassifier eClassifier2 = eClassifier;
			if (eClassifier2 != null) {
				typeid2 = TypeidManager.INSTANCE.getTypeTypeid(eClassifier2);
			}
			else {
				if ("Metaclass".equals(name)) {
					typeid2 = TypeidManager.INSTANCE.getUnscopedTypeid(name);
				}
				else {
					Typeid packageTypeid = TypeidManager.INSTANCE.getPackageTypeid(evaluationPackage);
					typeid2 = packageTypeid.getNestedTypeid(name);
				}
			}
			typeid = typeid2;
		}
		return typeid2;
	}

	/**
	 * Define the EClassifier associated with an executable type. This initialization may
	 * be performed once to allow an Ecore-aware package of type descriptors to re-use and
	 * enhance an Ecore-unaware package. This occurs for the PivotTables that enhance the
	 * OCLstdlibTables.
	 */
	public @NonNull EcoreExecutorType initFragments(@NonNull ExecutorFragment[] fragments, int[] depthCounts, /*@NonNull*/ EClassifier eClassifier) {
		assert eClassifier != null;
		assert this.eClassifier == null;
		assert name.equals(eClassifier.getName());
		this.eClassifier = DomainUtil.nonNullState(eClassifier);		
		initFragments(fragments, depthCounts);
		return this;
	}
}
