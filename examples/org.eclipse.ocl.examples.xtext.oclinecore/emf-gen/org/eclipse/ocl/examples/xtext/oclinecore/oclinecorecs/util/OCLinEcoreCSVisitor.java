/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
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
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.xtext.oclinecore/model/OCLinEcoreCS.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface OCLinEcoreCSVisitor<R> extends org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitOCLinEcoreConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS object);
	@Nullable R visitSysMLCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.SysMLCS object);
	@Nullable R visitTopLevelCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.TopLevelCS object);
}
