/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: BasePivot2CS.java,v 1.2 2011/01/24 21:00:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.pivot2cs;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public class BasePivot2CS extends Pivot2CS
{	
	private static final class Factory implements Pivot2CS.Factory
	{
		private static @NonNull Pivot2CS.Factory INSTANCE = new Factory();

		public @NonNull BaseDeclarationVisitor createDeclarationVisitor(@NonNull Pivot2CSConversion converter) {
			return new BaseDeclarationVisitor(converter);
		}

		public @NonNull BaseReferenceVisitor createReferenceVisitor(@NonNull Pivot2CSConversion converter) {
			return new BaseReferenceVisitor(converter);
		}

		public @NonNull EClass[] getEClasses() {
			return new EClass[] {};
		}
	}

	public BasePivot2CS(@NonNull Map<? extends Resource, ? extends Resource> cs2asResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
		addFactory(Factory.INSTANCE);
	}
}