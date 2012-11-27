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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainLambdaType;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableId;
import org.eclipse.ocl.examples.domain.ids.TemplateableTypeId;

public abstract class GeneralizedTypeIdImpl<T extends TemplateableId> extends AbstractGeneralizedIdImpl<T> implements TemplateableTypeId, ElementId.Internal
{		
	/**
	 * Map from the operation hashCode to the operationIds with the same hash. 
	 */
	private @Nullable WeakHashMapOfListOfWeakReference3<Integer, String, DomainParameterTypes, GeneralizedOperationIdImpl> memberOperations = null;

	/**
	 * Map from the property name to the propertyIds. 
	 */
	private @Nullable WeakHashMapOfWeakReference<String, PropertyIdImpl> memberProperties = null;

	protected GeneralizedTypeIdImpl(@NonNull Integer hashCode, @NonNull TemplateParameterId[] templateParameters, @NonNull String name) {
		super(hashCode, templateParameters, name);
	}

	protected @NonNull TemplateParameterId[] computeTemplateParameters(DomainType[] domainTypes) {
		List<TemplateParameterId> templateParameters = new ArrayList<TemplateParameterId>();
		for (DomainType domainType : domainTypes) {
			computeTemplateParameters(templateParameters, domainType);
		}
		int size = templateParameters.size();
		if (size > 0) {
			TemplateParameterId[] array = templateParameters.toArray(new TemplateParameterId[size]);
			assert array != null;
			return array;
		}
		else {
			return TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY;
		}
	}

	private void computeTemplateParameters(List<TemplateParameterId> templateParameters, DomainType domainType) {
		if (domainType instanceof DomainCollectionType) {
			computeTemplateParameters(templateParameters, ((DomainCollectionType)domainType).getElementType());
		}
		else if (domainType instanceof DomainTupleType) {
//			for (DomainTypedElement domainPart : ((DomainTupleType)domainType).getParts()) {
//				computeTemplateParameters(templateParameters, domainPart.getType());
//			}
		}
		else if (domainType instanceof DomainLambdaType) {
			for (DomainType parameterType : ((DomainLambdaType)domainType).getParameterType()) {
				computeTemplateParameters(templateParameters, parameterType);
			}
		}
//		else if (domainType instanceof DomainLambdaType) {
//			for (DomainType parameterType : ((DomainLambdaType)domainType).getParameterType()) {
//				computeTemplateParameters(templateParameters, parameterType);
//			}
//		}
		
	}

	@Override
	public @NonNull OperationId getOperationId(final @NonNull TemplateParameterId[] templateParameters, @NonNull String name, @NonNull DomainParameterTypes parameterTypes) {
		WeakHashMapOfListOfWeakReference3<Integer, String, DomainParameterTypes, GeneralizedOperationIdImpl> memberOperations2 = memberOperations;
		if (memberOperations2 == null) {
    		synchronized (this) {
    			memberOperations2 = memberOperations;
    	    	if (memberOperations2 == null) {
	    			memberOperations = memberOperations2 = new WeakHashMapOfListOfWeakReference3<Integer, String, DomainParameterTypes, GeneralizedOperationIdImpl>()
	        		{
						@Override
						protected @NonNull GeneralizedOperationIdImpl newId(@NonNull Integer hashCode, @NonNull String name, @NonNull DomainParameterTypes parameterTypes) {
							return new GeneralizedOperationIdImpl(hashCode, GeneralizedTypeIdImpl.this, templateParameters/*computeTemplateParameters(parameterTypes.get())*/, name, parameterTypes);
						}		
					};
    	    	}
    		}
    	}
		int hashCode = 47 * hashCode() + 37 * parameterTypes.hashCode() + name.hashCode();
		return memberOperations2.getId(hashCode, name, parameterTypes);
	}

	@Override
	public @NonNull PropertyId getPropertyId(@NonNull String name) {
		WeakHashMapOfWeakReference<String, PropertyIdImpl> memberProperties2 = memberProperties;
		if (memberProperties2 == null) {
    		synchronized (this) {
    			memberProperties2 = memberProperties;
    	    	if (memberProperties2 == null) {
    	    		memberProperties = memberProperties2 = new WeakHashMapOfWeakReference<String, PropertyIdImpl>()
	        		{
						@Override
						protected @NonNull PropertyIdImpl newId(@NonNull String name) {
							return new PropertyIdImpl(GeneralizedTypeIdImpl.this, name);
						}		
					};
    	    	}
    		}
    	}
		return memberProperties2.getId(name);
	}
}