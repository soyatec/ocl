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

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGText;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;

/**
 * CGTypedElementModelSpec supports generation of the CGTypedElement.getPivotTypeId() method hierarchy.
 */
public class CGTypedElementModelSpec extends ModelSpec
{
	protected abstract static class MyMethodSpec extends MethodSpec
	{
		public MyMethodSpec(@NonNull Class<?> rootClass, @NonNull String interfaceDecl, @Nullable String variableDecl, @Nullable String comment) {
			super(rootClass, interfaceDecl, variableDecl, comment);
		}

		@Override
		protected final @Nullable String getBody(@NonNull ModelSpec modelSpec) {
			return getBody((CGTypedElementModelSpec)modelSpec);
		}

		protected abstract @Nullable String getBody(@NonNull CGTypedElementModelSpec cgModelSpec);		
	}

	/**
	 * The algorithm options for getPivotTypeId()
	 */
	protected static enum Pti { ROOT, TEXT, T_ID }
		
	protected static MethodSpec getPivotTypeId = new MyMethodSpec(CGTypedElement.class, "@Nullable TypeId getPivotTypeId()", null,
		"Return the TypeId of the pivot element.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGTypedElementModelSpec modelSpec) {
				Pti enumValue = modelSpec.pti;
				if (enumValue == null) {
					return null;
				}
				switch (enumValue) {
					case ROOT: return "return pivot != null ? ((DomainTypedElement) pivot).getTypeId() : null;";
					case TEXT: return "return (TypeId) getTypeId().getElementId();		// FIXME Why irregular?";
					case T_ID: return "return (TypeId)elementId;";
					default: return "MISSING_CASE_for_" + enumValue + ";";
				}
			}
		};

	public static void register() {
		new CGTypedElementModelSpec(CGTypedElement.class, Pti.ROOT );
		new CGTypedElementModelSpec(CGText.class, Pti.TEXT );
		new CGTypedElementModelSpec(CGTypeId.class, Pti.T_ID );
	}

	protected final @Nullable Pti pti;
	
	protected CGTypedElementModelSpec(@NonNull Class<?> cgClass, @Nullable Pti pti) {
		super(cgClass);
		this.pti = pti;
	}
	
	@Override
	public void generate(@NonNull StringBuilder s, @NonNull GenModel genModel, boolean isImplementation) {
		getPivotTypeId.generate(s, this, genModel, isImplementation);
	}
}
