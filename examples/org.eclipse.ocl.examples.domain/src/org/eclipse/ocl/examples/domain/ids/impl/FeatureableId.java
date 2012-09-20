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
 */
package org.eclipse.ocl.examples.domain.ids.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.SpecializedTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.ids.TypeTemplateParameterId;

public abstract class FeatureableId extends AbstractTypeId
{
	protected final int hashCode;

	/**
	 * Map from a nested type name to the corresponding EnumerationLiteralId. 
	 */
	private @Nullable WeakHashMapOfWeakReference<String, EnumerationLiteralId> memberEnumerationLiterals = null;
	
	/**
	 * Map from the operation hashCode to the lambda typeIds with the same hash. 
	 */
	private @NonNull WeakHashMapOfListOfWeakReference<Integer, DomainTypeParameters, OperationIdImpl> memberOperations =
		new WeakHashMapOfListOfWeakReference<Integer, DomainTypeParameters, OperationIdImpl>()
		{
			@Override
			protected @NonNull OperationIdImpl newTypeId(@NonNull Integer hashCode, @NonNull DomainTypeParameters typeParameters, @NonNull String name) {
				return new OperationIdImpl(FeatureableId.this, name, typeParameters, hashCode);
			}		
		};

	/**
	 * Map from a parameter specialization to the corresponding SpecializedTypeId. 
	 */
	private @Nullable WeakHashMapOfWeakReference<DomainTypeParameters, SpecializedTypeId> specializations = null;

	/**
	 * Map from a type parameter name to the corresponding TypeParameterId. 
	 */
	private @Nullable WeakHashMapOfWeakReference<Integer, TypeTemplateParameterId> templateParameters = null;
		
	protected FeatureableId(int hashCode) {
		this.hashCode = hashCode;
	}

	@Override
	public @NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull String name) {
    	WeakHashMapOfWeakReference<String, EnumerationLiteralId> memberEnumerationLiterals2 = memberEnumerationLiterals;
		if (memberEnumerationLiterals2 == null) {
    		synchronized (this) {
    			memberEnumerationLiterals2 = memberEnumerationLiterals;
    	    	if (memberEnumerationLiterals2 == null) {
    	    		memberEnumerationLiterals = memberEnumerationLiterals2 = new WeakHashMapOfWeakReference<String, EnumerationLiteralId>()
    				{
						@Override
						protected @NonNull EnumerationLiteralId newTypeId(@NonNull String name) {
							return new EnumerationLiteralIdImpl(FeatureableId.this, name);
						}
					};
	    	   }
    		}
    	}
		return memberEnumerationLiterals2.getElementId(name);
	}

	@Override
	public @NonNull OperationId getOperationId(@NonNull DomainOperation anOperation) {
		String name = anOperation.getName();
		assert name != null;
		DomainTypeParameters typeParameters = anOperation.getTypeParameters();
		int hashCode = 47 * hashCode() + 37 * name.hashCode() + typeParameters.hashCode();
		return memberOperations.getTypeId(hashCode, typeParameters, name);
	}

    @Override
	public @NonNull TypeId getSpecializedTypeId(@NonNull DomainTypeParameters typeParameters) {
    	WeakHashMapOfWeakReference<DomainTypeParameters, SpecializedTypeId> name2specializedid2 = specializations;
		if (name2specializedid2 == null) {
    		synchronized (this) {
    			name2specializedid2 = specializations;
    	    	if (name2specializedid2 == null) {
    	    		synchronized (this) {
    	    			specializations = name2specializedid2 = new WeakHashMapOfWeakReference<DomainTypeParameters, SpecializedTypeId>()
    	        		{
    						@Override
    						protected @NonNull SpecializedTypeId newTypeId(@NonNull DomainTypeParameters typeParameters) {
    							return new SpecializedTypeIdImpl(FeatureableId.this, typeParameters);
    						}
    					};
    	    		}
    	    	}
    		}
    	}
		return name2specializedid2.getElementId(typeParameters);
    }

    @Override
	public @NonNull TypeTemplateParameterId getTemplateParameterId(int index) {
    	WeakHashMapOfWeakReference<Integer, TypeTemplateParameterId> templateParameters2 = templateParameters;
		if (templateParameters2 == null) {
    		synchronized (this) {
    			templateParameters2 = templateParameters;
    	    	if (templateParameters2 == null) {
    	    		templateParameters = templateParameters2 = new WeakHashMapOfWeakReference<Integer, TypeTemplateParameterId>()
    				{
						@Override
						protected @NonNull TypeTemplateParameterId newTypeId(@NonNull Integer index) {
							return new TypeTemplateParameterIdImpl(FeatureableId.this, index);
						}
					};
	    	   }
    		}
    	}
		return templateParameters2.getElementId(index);
    }

	@Override
	public final int hashCode() {
		return hashCode;
	}
}