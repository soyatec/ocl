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
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TemplateBindings;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableId;

public abstract class AbstractSpecializedIdImpl<T extends TemplateableId> extends AbstractTemplateableIdImpl<T>
{
	protected final @NonNull T generalizedId;
	protected final @NonNull TemplateBindings templateBindings;

	public AbstractSpecializedIdImpl(@NonNull T generalizedId, @NonNull TemplateBindings templateBindings) {
		super(generalizedId.hashCode() + templateBindings.hashCode(), IdManager.INSTANCE.createTemplateParameterIds(generalizedId.getTemplateParameters()));
		this.generalizedId = generalizedId;
		this.templateBindings = templateBindings;
		TemplateParameterId[] generalizedTemplateParameters = generalizedId.getTemplateParameters();
		int templateParameterCount = generalizedTemplateParameters.length;
		assert templateParameterCount > 0;
		assert templateBindings.parametersSize() == templateParameterCount;
	}

	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(generalizedId.getDisplayName());
		s.append("<");
		for (int i = 0; i < templateParameters.length; i++) {
			if (i > 0) {
				s.append(",");
			}
			s.append(generalizedId.getTemplateParameterId(i).getName());
			s.append(":");
			s.append(templateBindings.get(i));
		}
		s.append(">");
/*		s.append("<");
		boolean isFirst = true;
		for (TemplateParameterId templateParameter : templateParameters) {
			if (!isFirst) {
				s.append(",");
			}
			s.append(templateParameter.getName());
			isFirst = false;
		}
		s.append(">"); */
		String string2 = s.toString();
		assert string2 != null;
		return string2;
	}

	public @NonNull T getGeneralizedId() {
		return generalizedId;
	}

	public @NonNull String getMetaTypeName() {
		return generalizedId.getMetaTypeName();
	}

	public @NonNull String getName() {
		return generalizedId.getName();
	}
}