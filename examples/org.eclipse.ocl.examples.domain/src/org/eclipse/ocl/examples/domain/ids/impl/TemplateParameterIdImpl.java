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
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableId;

public class TemplateParameterIdImpl /*extends AbstractTypeId*/ implements TemplateParameterId
{
	private @Nullable DomainTemplateParameter origin;
	private @Nullable TemplateableId parent;
	private int index;

	public TemplateParameterIdImpl(@Nullable DomainTemplateParameter origin) {
		this.origin = origin;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTemplateParameterId(this);
	}

	public @NonNull String getDisplayName() {
		return parent != null ? "$" + index : "?";
	}

	public int getIndex() {
		assert parent != null;
		return index;
	}

	public @NonNull String getName() {
		assert parent != null;
		return "$" + index;
	}

	public @Nullable DomainElement getOrigin() {
		return origin;
	}

	public @NonNull TemplateableId getParent() {
		TemplateableId parent2 = parent;
		assert parent2 != null;
		return parent2;
	}

	@Override
	public final int hashCode() {
		return 5555 + index * 77;
	}
	
	public void install(@NonNull TemplateableId templateableId, int index) {
		assert parent == null;
		this.parent = templateableId;
		this.index = index;
	}

    public @NonNull ElementId specialize(@NonNull TemplateBindings templateBindings) {
		assert parent != null;
    	ElementId elementId = templateBindings.get(index);
		assert elementId != null;
		return elementId;
	}

	@Override
	public String toString() {
		return getDisplayName();
	}
}