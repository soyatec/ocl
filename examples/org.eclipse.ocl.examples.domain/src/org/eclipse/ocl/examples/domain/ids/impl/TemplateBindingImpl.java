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
package org.eclipse.ocl.examples.domain.ids.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TypeId;


public class TemplateBindingImpl extends AbstractTypeId implements TemplateBinding
{
	private DomainTemplateParameter templateParameter;
	private TemplateParameterId templateParameterId;
	
	public TemplateBindingImpl(@NonNull DomainTemplateParameter templateParameter) {
		this.templateParameter = templateParameter;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTemplateBinding(this);
	}

	public @NonNull String getDisplayName() {
		if (templateParameter != null) {
			return String.valueOf(templateParameter);
		}
		else {
			return String.valueOf(templateParameterId);
		}
	}

	public @NonNull DomainTemplateParameter getTemplateParameter() {
		return templateParameter;
	}

	@Override
	public int hashCode() {
		return templateParameter.hashCode();
	}

	public void install(@NonNull TemplateParameterId templateParameterId) {
		this.templateParameterId = templateParameterId;
		this.templateParameter = null;
	}

	@Override
	public void resolveTemplateBindings(@NonNull Map<DomainTemplateParameter, List<TemplateBinding>> bindings) {
		if (templateParameter != null) {
			List<TemplateBinding> list = bindings.get(templateParameter);
			if (list == null) {
				synchronized (bindings) {
					list = bindings.get(templateParameter);
					if (list == null) {
						list = new ArrayList<TemplateBinding>();
						bindings.put(templateParameter, list);
					}
				}
			}
			if (!list.contains(this)) {
				synchronized (list) {
					if (!list.contains(this)) {
						list.add(this);
					}
				}
			}
		}
	}
	   
    public @NonNull TypeId specialize(@NonNull TemplateBindings templateBindings) {
    	int index = templateParameterId.getIndex();
		ElementId templateBinding = templateBindings.get(index);
		if (templateBinding instanceof TemplateBinding) {
			return new TemplateBindingImpl(((TemplateBinding)templateBinding).getTemplateParameter());
		}
		else {
			return (TypeId) templateBinding;
		}
	}
}
