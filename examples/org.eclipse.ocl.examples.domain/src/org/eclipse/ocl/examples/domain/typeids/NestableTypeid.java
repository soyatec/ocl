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
package org.eclipse.ocl.examples.domain.typeids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;

/**
 * A NestableTypeid supports provision of unique identifier for nested and specialized 'conceptual' types or packages.
 */
class NestableTypeid extends AbstractTypeid
{
		/**
	 * Map from a nested type name to the corresponding NestedTypeId. 
	 */
	private @Nullable WeakHashMapOfWeakReference<String, NestedTypeid> name2nestedid = null;

	/**
	 * Map from a type parameter name to the corresponding ParameterTypeId. 
	 */
	private @Nullable WeakHashMapOfWeakReference<String, ParameterTypeid> name2parameterid = null;

	/**
	 * Map from a parameter specialization to the corresponding SpecializedTypeid. 
	 */
	private @Nullable WeakHashMapOfWeakReference<DomainTypeParameters, SpecializedTypeid> name2specializedid = null;
	
	NestableTypeid(int hashCode) {
		super(hashCode);
	}

    @Override
	public @NonNull Typeid getNestedTypeid(@NonNull String name) {
    	WeakHashMapOfWeakReference<String, NestedTypeid> name2nestedid2 = name2nestedid;
		if (name2nestedid2 == null) {
    		synchronized (this) {
    			name2nestedid2 = name2nestedid;
    	    	if (name2nestedid2 == null) {
    	    		name2nestedid = name2nestedid2 = new WeakHashMapOfWeakReference<String, NestedTypeid>()
    				{
						@Override
						protected @NonNull NestedTypeid newTypeid(@NonNull String name) {
							return new NestedTypeid(NestableTypeid.this, name);
						}
					};
    	    	}
    		}
    	}
		return name2nestedid2.getTypeid(name);
    }
	
	/**
	 * Map from the operation hashCode to the lambda typeids with the same hash. 
	 */
	private @NonNull WeakHashMapOfListOfWeakReference<Integer, DomainTypeParameters, OperationTypeid> hash2operationid =
		new WeakHashMapOfListOfWeakReference<Integer, DomainTypeParameters, OperationTypeid>()
		{
			@Override
			protected @NonNull OperationTypeid newTypeid(@NonNull Integer hashCode, @NonNull DomainTypeParameters typeParameters, @NonNull String name) {
				return new OperationTypeid(NestableTypeid.this, name, typeParameters, hashCode);
			}		
		};

	@Override
	public @NonNull Typeid getOperationTypeid(@NonNull DomainOperation anOperation) {
		String name = anOperation.getName();
		assert name != null;
		DomainTypeParameters typeParameters = anOperation.getTypeParameters();
		int hashCode = 47 * hashCode() + 37 * name.hashCode() + typeParameters.hashCode();
		return hash2operationid.getTypeid(hashCode, typeParameters, name);
	}

    @Override
	public @NonNull Typeid getParameterTypeid(@NonNull String name) {
    	WeakHashMapOfWeakReference<String, ParameterTypeid> name2parameterid2 = name2parameterid;
		if (name2parameterid2 == null) {
    		synchronized (this) {
    			name2parameterid2 = name2parameterid;
    	    	if (name2parameterid2 == null) {
    	    		name2parameterid = name2parameterid2 = new WeakHashMapOfWeakReference<String, ParameterTypeid>()
    				{
						@Override
						protected @NonNull ParameterTypeid newTypeid(@NonNull String name) {
							return new ParameterTypeid(NestableTypeid.this, name);
						}
					};
	    	   }
    		}
    	}
		return name2parameterid2.getTypeid(name);
    }

    @Override
	public @NonNull Typeid getSpecializedTypeid(@NonNull DomainTypeParameters typeParameters) {
    	WeakHashMapOfWeakReference<DomainTypeParameters, SpecializedTypeid> name2specializedid2 = name2specializedid;
		if (name2specializedid2 == null) {
    		synchronized (this) {
    			name2specializedid2 = name2specializedid;
    	    	if (name2specializedid2 == null) {
    	    		synchronized (this) {
    	    			name2specializedid = name2specializedid2 = new WeakHashMapOfWeakReference<DomainTypeParameters, SpecializedTypeid>()
    	        		{
    						@Override
    						protected @NonNull SpecializedTypeid newTypeid(@NonNull DomainTypeParameters typeParameters) {
    							return new SpecializedTypeid(NestableTypeid.this, typeParameters);
    						}
    					};
    	    		}
    	    	}
    		}
    	}
		return name2specializedid2.getTypeid(typeParameters);
    }
}