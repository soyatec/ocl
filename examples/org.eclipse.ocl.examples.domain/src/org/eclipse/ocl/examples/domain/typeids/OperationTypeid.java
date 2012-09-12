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
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;

/**
 * A OperationTypeid identifies an operation name and parameters.
 */
class OperationTypeid extends LambdaTypeid
{
	protected final @NonNull Typeid typeTypeid;

	/**
	 * Map from a type parameter name to the corresponding ParameterTypeId. 
	 */
	private @Nullable WeakHashMapOfWeakReference<String, ParameterTypeid> name2parameterid = null;
	
	OperationTypeid(@NonNull Typeid typeTypeid, @NonNull String name, @NonNull DomainTypeParameters typeParameters, int hashCode) {
		super(name, typeParameters, hashCode);
		this.typeTypeid = typeTypeid;
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
							return new ParameterTypeid(OperationTypeid.this, name);
						}
					};
	    	   }
    		}
    	}
		return name2parameterid2.getTypeid(name);
    }

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(typeTypeid);
		s.append("::");
		s.append(name);
		s.append("(");
		s.append(typeParameters);
		s.append(")");
		return s.toString();
	}
}