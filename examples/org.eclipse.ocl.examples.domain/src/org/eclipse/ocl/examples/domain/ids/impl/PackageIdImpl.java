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
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public abstract class PackageIdImpl extends AbstractElementId implements PackageId
{
	protected final int hashCode;

	/**
	 * Map from a nested type name to the corresponding NestedTypeId. 
	 */
	private @Nullable WeakHashMapOfWeakReference<String, NestedEnumerationIdImpl> nestedEnumerations = null;

	/**
	 * Map from a nested package name to the corresponding NestedTypeId. 
	 */
	private @Nullable WeakHashMapOfWeakReference<String, PackageId> nestedPackages = null;

	/**
	 * Map from a nested type name to the corresponding NestedTypeId. 
	 */
	private @Nullable WeakHashMapOfWeakReference<String, GeneralizedNestedTypeIdImpl> nestedTypes = null;
	
	
	PackageIdImpl(int hashCode) {
		this.hashCode = hashCode;
	}

	public @NonNull String getMetaTypeName() {
		return TypeId.CLASS_NAME;
	}

	public @NonNull EnumerationId getNestedEnumerationId(@NonNull String name) {
    	WeakHashMapOfWeakReference<String, NestedEnumerationIdImpl> nestedEnumerations2 = nestedEnumerations;
		if (nestedEnumerations2 == null) {
    		synchronized (this) {
    			nestedEnumerations2 = nestedEnumerations;
    	    	if (nestedEnumerations2 == null) {
    	    		nestedEnumerations = nestedEnumerations2 = new WeakHashMapOfWeakReference<String, NestedEnumerationIdImpl>()
    				{
						@Override
						protected @NonNull NestedEnumerationIdImpl newTypeId(@NonNull String name) {
							return new NestedEnumerationIdImpl(PackageIdImpl.this, name);
						}
					};
    	    	}
    		}
    	}
		return nestedEnumerations2.getElementId(name);
    }

 	public @NonNull PackageId getNestedPackageId(@NonNull String name) {
    	WeakHashMapOfWeakReference<String, PackageId> nestedPackages2 = nestedPackages;
		if (nestedPackages2 == null) {
    		synchronized (this) {
    			nestedPackages2 = nestedPackages;
    	    	if (nestedPackages2 == null) {
    	    		nestedPackages = nestedPackages2 = new WeakHashMapOfWeakReference<String, PackageId>()
    				{
						@Override
						protected @NonNull PackageId newTypeId(@NonNull String name) {
							return new NestedPackageIdImpl(PackageIdImpl.this, name);
						}
					};
    	    	}
    		}
    	}
		return nestedPackages2.getElementId(name);
    }

	public @NonNull TypeId getNestedTypeId(final @NonNull TemplateParameterId[] templateParameters, @NonNull String name) {
    	WeakHashMapOfWeakReference<String, GeneralizedNestedTypeIdImpl> nestedTypes2 = nestedTypes;
		if (nestedTypes2 == null) {
    		synchronized (this) {
    			nestedTypes2 = nestedTypes;
    	    	if (nestedTypes2 == null) {
    	    		nestedTypes = nestedTypes2 = new WeakHashMapOfWeakReference<String, GeneralizedNestedTypeIdImpl>()
    				{
						@Override
						protected @NonNull GeneralizedNestedTypeIdImpl newTypeId(@NonNull String name) {
							return new GeneralizedNestedTypeIdImpl(PackageIdImpl.this, templateParameters, name);
						}
					};
    	    	}
    		}
    	}
		return nestedTypes2.getElementId(name);
    }

	@Override
	public final int hashCode() {
		return hashCode;
	}
}