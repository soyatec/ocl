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
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;

public abstract class OperateableTypeIdImpl extends AbstractTypeId
{
	protected final @NonNull Integer hashCode;
	
	/**
	 * Map from the operation hashCode to the operationIds with the same hash. 
	 */
	private @Nullable WeakHashMapOfListOfWeakReference3<Integer, String, DomainParameterTypes, GeneralizedOperationIdImpl> memberOperations = null;
		
	protected OperateableTypeIdImpl(@NonNull Integer hashCode) {
		this.hashCode = hashCode;
	}

	public @NonNull OperationId getOperationId(final @NonNull DomainOperation anOperation) {
		WeakHashMapOfListOfWeakReference3<Integer, String, DomainParameterTypes, GeneralizedOperationIdImpl> memberOperations2 = memberOperations;
		if (memberOperations2 == null) {
    		synchronized (this) {
    			memberOperations2 = memberOperations;
    	    	if (memberOperations2 == null) {
    	    		synchronized (this) {
    	    			memberOperations = memberOperations2 = new WeakHashMapOfListOfWeakReference3<Integer, String, DomainParameterTypes, GeneralizedOperationIdImpl>()
    	        		{
    						@Override
    						protected @NonNull GeneralizedOperationIdImpl newTypeId(@NonNull Integer hashCode, @NonNull String name, @NonNull DomainParameterTypes parameterTypes) {
    							return new GeneralizedOperationIdImpl(hashCode, OperateableTypeIdImpl.this, computeTemplateParameters(parameterTypes.get()), name, parameterTypes);
    						}		
    					};
    	    		}
    	    	}
    		}
    	}
		String name = anOperation.getName();
		assert name != null;
		DomainTypeParameters typeParameters = anOperation.getTypeParameters();
		int hashCode = 47 * hashCode() + 37 * name.hashCode() + typeParameters.hashCode();
		return memberOperations2.getTypeId(hashCode, name, anOperation.getParameterTypes());
	}

	protected TemplateParameterId[] computeTemplateParameters(DomainType[] domainTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}
}