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
 * $Id: OCLstdlibCS2Pivot.java,v 1.2 2011/01/24 22:28:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2as;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2Pivot;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;

public class OCLstdlibCS2Pivot extends EssentialOCLCS2Pivot
{	
	public OCLstdlibCS2Pivot(@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2pivotResourceMap, metaModelManager);
	}
	
	public OCLstdlibCS2Pivot(@NonNull OCLstdlibCS2Pivot cs2pivot) {
		super(cs2pivot);
	}

	@Override
	protected @NonNull OCLstdlibContainmentVisitor createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLstdlibContainmentVisitor(converter);
	}

	@Override
	protected @NonNull OCLstdlibLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLstdlibLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull OCLstdlibPostOrderVisitor createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLstdlibPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull OCLstdlibPreOrderVisitor createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new OCLstdlibPreOrderVisitor(converter);
	}

	@Override
	public synchronized void update(@NonNull IDiagnosticConsumer diagnosticsConsumer) {
		metaModelManager.setLibraryLoadInProgress(true);
		try {
			super.update(diagnosticsConsumer);
		} finally {
			metaModelManager.setLibraryLoadInProgress(false);
		}
	}
}
