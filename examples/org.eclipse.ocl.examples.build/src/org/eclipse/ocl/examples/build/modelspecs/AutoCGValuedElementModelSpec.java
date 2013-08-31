/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.build.modelspecs;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;

public class AutoCGValuedElementModelSpec extends CGValuedElementModelSpec
{
	public static void register() {
//		new AutoCGValuedElementModelSpec(CGCallExp.class, null,							null     , null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , Val.THIS , null     , null     , null     , null     , null     );
		new AutoCGValuedElementModelSpec(CGASTCallExp.class, "source",	                Box.FALSE, Ref.DELEG, null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     , null     );
		new AutoCGValuedElementModelSpec(CGContainmentPart.class, null,					Box.FALSE, null     , null     , Nul.FALSE, null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , Com.FALSE, null     );
		new AutoCGValuedElementModelSpec(CGContainmentVisit.class, null,				Box.FALSE, null     , null     , Nul.FALSE, null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , Com.FALSE, null     );
	}
	
	protected AutoCGValuedElementModelSpec(@NonNull Class<?> cgClass, @Nullable String delegate,
			@Nullable Box box, @Nullable Ref ref, @Nullable Log log, @Nullable Nul nul, @Nullable Inv inv,
			@Nullable Glo glo, @Nullable Inl inl, @Nullable Set set, @Nullable Ct ct, @Nullable Con con,
			@Nullable Val val, @Nullable Cvl cvl, @Nullable Ctx ctx, @Nullable Ctl ctl, @Nullable Com com, @Nullable Rew rew) {
		super(cgClass, delegate, box, ref, log, nul, inv, glo, inl, set, ct, con, val, cvl, ctx, ctl, com, rew);
	}
}
