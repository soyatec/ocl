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
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;

/**
 * A CollectionTypeid provides a unique identifier for a 'conceptual' collection type such as Set.
 */
class CollectionTypeid extends AbstractTypeid
{
	protected final @NonNull String name;
	/**
	 * Map from a parameter specialization to the corresponding SpecializedTypeid. 
	 */
	private @NonNull WeakHashMapOfWeakReference<Typeid, CollectedTypeid> typeid2collectedid = new WeakHashMapOfWeakReference<Typeid, CollectedTypeid>()
		{
			@Override
			protected @NonNull CollectedTypeid newTypeid(@NonNull Typeid elementTypeid) {
				return new CollectedTypeid(CollectionTypeid.this, elementTypeid);
			}
		};
	
	/**
	 * Map from the operation hashCode to the lambda typeids with the same hash. 
	 */
	private @NonNull WeakHashMapOfListOfWeakReference<Integer, DomainTypeParameters, OperationTypeid> hash2operationid =
		new WeakHashMapOfListOfWeakReference<Integer, DomainTypeParameters, OperationTypeid>()
		{
			@Override
			protected @NonNull OperationTypeid newTypeid(@NonNull Integer hashCode, @NonNull DomainTypeParameters typeParameters, @NonNull String name) {
				return new OperationTypeid(CollectionTypeid.this, name, typeParameters, hashCode);
			}		
		};

	/**
	 * Map from a type parameter name to the corresponding ParameterTypeId. 
	 */
	private @NonNull WeakHashMapOfWeakReference<String, ParameterTypeid> name2parameterid = new WeakHashMapOfWeakReference<String, ParameterTypeid>()
		{
			@Override
			protected @NonNull ParameterTypeid newTypeid(@NonNull String name) {
				return new ParameterTypeid(CollectionTypeid.this, name);
			}
		};

	CollectionTypeid(@NonNull String name) {
		super(name.hashCode());
		this.name = name;
	}

    @Override
	public @NonNull Typeid getCollectedTypeid(@NonNull Typeid elementTypeid) {
    	return typeid2collectedid.getTypeid(elementTypeid);
    }

	@Override
	public @NonNull Typeid getOperationTypeid(@NonNull DomainOperation anOperation) {
		String name = anOperation.getName();
		assert name != null;
		DomainTypeParameters typeParameters = anOperation.getTypeParameters();
		int hashCode = 47 * hashCode() + 37 * name.hashCode() + typeParameters.hashCode();
		return hash2operationid.getTypeid(hashCode, typeParameters, name);
	}

    @Override
	public @NonNull Typeid getParameterTypeid(final @NonNull String name) {
    	return name2parameterid.getTypeid(name);
    }
	
	@Override
	public String toString() {
		return name + "(?)";
	}
}