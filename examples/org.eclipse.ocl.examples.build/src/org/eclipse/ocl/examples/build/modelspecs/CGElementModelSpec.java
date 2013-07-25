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
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;

/**
 * CGTypedElementModelSpec supports generation of the CGTypedElement.getPivotTypeId() method hierarchy.
 */
public class CGElementModelSpec extends ModelSpec
{
	protected abstract static class MyMethodSpec extends MethodSpec
	{
		public MyMethodSpec(@NonNull Class<?> rootClass, @NonNull String interfaceDecl, @Nullable String variableDecl, @Nullable String comment) {
			super(rootClass, interfaceDecl, variableDecl, comment);
		}

		@Override
		protected final @Nullable String getBody(@NonNull ModelSpec modelSpec) {
			if (modelSpec instanceof CGElementModelSpec) {
				return getBody((CGElementModelSpec)modelSpec);
			}
			else {
				return null;
			}
		}

		protected abstract @Nullable String getBody(@NonNull CGElementModelSpec cgModelSpec);		
	}
		
	protected static MethodSpec getChildren = new MyMethodSpec(CGElement.class, "@NonNull Iterable<? extends " + classRef(CGElement.class) + "> getChildren()", null,
		"Return the child CGElements.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGElementModelSpec modelSpec) {
				if (modelSpec.cgClass == rootClass) {
					return "return (Iterable<? extends " + classRef(CGElement.class) + ">) eContents();";
				}
				else {
					return null;
				}
			}
		};
		
	protected static MethodSpec getParent = new MyMethodSpec(CGElement.class, "@Nullable " + classRef(CGElement.class) + " getParent()", null,
		"Return the parent node in a CG tree, null at the root.")
		{
			@Override
			protected @Nullable String getBody(@NonNull CGElementModelSpec modelSpec) {
				if (modelSpec.cgClass == rootClass) {
					return "return (" + classRef(CGElement.class) + ")eContainer();";
				}
				else {
					return null;
				}
			}
		};

	public static void register() {
		new CGElementModelSpec(CGElement.class);
	}
	
	protected CGElementModelSpec(@NonNull Class<?> cgClass) {
		super(cgClass);
	}
	
	@Override
	public void generate(@NonNull StringBuilder s, @NonNull GenModel genModel, boolean isImplementation) {
		getChildren.generate(s, this, genModel, isImplementation);
		getParent.generate(s, this, genModel, isImplementation);
	}
}
