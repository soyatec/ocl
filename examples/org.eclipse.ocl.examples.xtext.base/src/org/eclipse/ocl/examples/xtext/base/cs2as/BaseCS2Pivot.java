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
 * $Id: BaseCS2Pivot.java,v 1.4 2011/05/20 15:27:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2as;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * BaseCST2Pivot provides an extensible conversion from CS models to the pivot model.
 */
public class BaseCS2Pivot extends CS2Pivot
{	
	public BaseCS2Pivot(@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		super(cs2pivotResourceMap, metaModelManager);
	}

	public BaseCS2Pivot(@NonNull BaseCS2Pivot cs2pivot) {
		super(cs2pivot);
	}

	@Override
	protected @NonNull BaseContainmentVisitor createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new BaseContainmentVisitor(converter);
	}

	@Override
	protected @NonNull BaseLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new BaseLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull BasePostOrderVisitor createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new BasePostOrderVisitor(converter);
	}

	@Override
	protected @NonNull BasePreOrderVisitor createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new BasePreOrderVisitor(converter);
	}
}
