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
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.OperationTemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class OperationIdImpl extends AbstractElementId implements OperationId, MatchableId<DomainTypeParameters>
{
	protected final @NonNull TypeId parentId;
	protected final @NonNull Integer hashCode;			// Avoids the key getting prematurely garbage collected
	protected final @NonNull String name;
	protected final @NonNull DomainTypeParameters typeParameters;
	
	/**
	 * Map from a type parameter name to the corresponding TypeParameterId. 
	 */
	private @Nullable WeakHashMapOfWeakReference<Integer, OperationTemplateParameterId> templateParameters = null;
	
	public OperationIdImpl(@NonNull TypeId parentId, @NonNull String name, @NonNull DomainTypeParameters typeParameters, @NonNull Integer hashCode) {
		this.hashCode = hashCode;
		this.name = name;;
		this.typeParameters = typeParameters;
		this.parentId = parentId;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitOperationId(this);
	}

	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(parentId);
		s.append("::");
		s.append(name);
		s.append("(");
		s.append(templateParameters);
		s.append(")");
		String string2 = s.toString();
		assert string2 != null;
		return string2;
	}

	public @NonNull String getMetaTypeName() {
		return TypeId.OPERATION_NAME;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}

	public @NonNull OperationTemplateParameterId getTemplateParameterId(int index) {
    	WeakHashMapOfWeakReference<Integer, OperationTemplateParameterId> templateParameters2 = templateParameters;
		if (templateParameters2 == null) {
    		synchronized (this) {
    			templateParameters2 = templateParameters;
    	    	if (templateParameters2 == null) {
    	    		templateParameters = templateParameters2 = new WeakHashMapOfWeakReference<Integer, OperationTemplateParameterId>()
    				{
						@Override
						protected @NonNull OperationTemplateParameterId newTypeId(@NonNull Integer index) {
							return new OperationTemplateParameterIdImpl(OperationIdImpl.this, index);
						}
					};
	    	   }
    		}
    	}
		return templateParameters2.getElementId(index);
    }

	public boolean matches(@NonNull String thatName, @NonNull DomainTypeParameters thoseTypeParameters) {
		if (!this.name.equals(thatName)) {
			return false;
		}
		if (!this.typeParameters.equals(thoseTypeParameters)) {
			return false;
		}
		return true;
	}
}