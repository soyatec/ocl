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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * An CollectionTypeServer supports one or more merged collection types as the source for operations, properties or superclasses
 * and additionally supports their specializations.
 */
public class CollectionTypeServer extends ExtensibleTypeServer
{
	private static final Logger logger = Logger.getLogger(CollectionTypeServer.class);

	public static class TemplateArguments implements Iterable<Object>
	{
		protected class Iterator implements java.util.Iterator<Object>
		{
			private int position = 0;
			
			public boolean hasNext() {
				return position < 3;
			}

			public Object next() {
				switch (position++) {
					case 0: return elementType;
					case 1: return lower;
					case 2: return upper;
				}
				throw new NoSuchElementException();
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		}
		
		private final int hashCode;
		private final @NonNull Type elementType;
		private final @NonNull IntegerValue lower;
		private final @NonNull IntegerValue upper;

		public TemplateArguments(@NonNull Type elementType, @NonNull IntegerValue lower, @NonNull IntegerValue upper) {
			this.elementType = elementType;
			this.lower = lower;
			this.upper = upper;
			int hash = elementType.hashCode();
			hash = 111 * hash + lower.hashCode();
			hash = 111 * hash + upper.hashCode();
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
			if (!this.elementType.equals(that.elementType)) {
				return false;
			}
			if (!this.lower.equals(that.lower)) {
				return false;
			}
			if (!this.upper.equals(that.upper)) {
				return false;
			}
			return true;
		}

		public @NonNull Type getElementType() {
			return elementType;
		}

		public @NonNull IntegerValue getLower() {
			return lower;
		}

		public @NonNull IntegerValue getUpper() {
			return upper;
		}

		@Override
		public int hashCode() {
			return hashCode;
		}

		public @NonNull Iterator iterator() {
			return new Iterator();
		}		

		public int parametersSize() {
			return 1;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append('(');
			s.append(elementType);
			s.append(',');
			s.append(lower);
			s.append(',');
			s.append(upper);
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

	protected CollectionTypeServer(@NonNull PackageServer packageServer, @NonNull DomainCollectionType domainType) {
		super(packageServer, domainType);
	}
	
	protected @NonNull Type createSpecialization(@NonNull TemplateArguments templateArguments) {
		Type unspecializedType = getPivotType();
		String typeName = unspecializedType.getName();
		TemplateSignature templateSignature = unspecializedType.getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
		EClass eClass = unspecializedType.eClass();
		EFactory eFactoryInstance = eClass.getEPackage().getEFactoryInstance();
		CollectionType specializedType = (CollectionType) eFactoryInstance.create(eClass);		
		specializedType.setName(typeName);
		TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		templateBinding.setSignature(templateSignature);
		Map<TemplateParameter, ParameterableElement> allBindings = new HashMap<TemplateParameter, ParameterableElement>();
		TemplateParameter formalParameter = templateParameters.get(0);
		Type elementType = templateArguments.getElementType();
		allBindings.put(formalParameter, elementType);
		TemplateParameterSubstitution templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
		templateParameterSubstitution.setFormal(formalParameter);
		if (elementType.eResource() == null) {
			templateParameterSubstitution.setOwnedActual(elementType);
		}
		else {
			templateParameterSubstitution.setActual(elementType);
		}
		templateBinding.getParameterSubstitution().add(templateParameterSubstitution);
		specializedType.getTemplateBinding().add(templateBinding);
		packageManager.resolveSuperClasses(specializedType, unspecializedType, allBindings);
		CollectionType specializedCollectionType = (CollectionType)specializedType;
		specializedCollectionType.setElementType(templateArguments.getElementType());
		try {
			specializedCollectionType.setLowerValue(templateArguments.getLower());
		} catch (InvalidValueException e) {
			logger.error("Out of range lower bound", e);
		}
		try {
			specializedCollectionType.setUpperValue(templateArguments.getUpper());
		} catch (InvalidValueException e) {
			logger.error("Out of range upper bound", e);
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
		if (templateParameters.size() != 1) {
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

	public synchronized @NonNull Type getSpecializedType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		assert getPivotType() instanceof CollectionType;
		if (lower == null) {
			lower = ValuesUtil.ZERO_VALUE;
		}
		if (upper == null) {
			upper = ValuesUtil.UNLIMITED_VALUE;
		}
		TemplateArguments templateArguments = new TemplateArguments(elementType, lower, upper);
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
}
