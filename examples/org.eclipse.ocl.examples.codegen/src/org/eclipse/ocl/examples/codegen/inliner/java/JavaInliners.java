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
package org.eclipse.ocl.examples.codegen.inliner.java;

import java.lang.reflect.Method;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.inliner.AbstractInliner;

public class JavaInliners
{
	public static abstract class AbstractJavaInliner extends AbstractInliner
	{
		public AbstractJavaInliner(@NonNull JavaCodeGenerator codeGenerator) {
			super(codeGenerator);
		}
		
		protected @Nullable Class<?> getLeastDerivedClass(Class<?> requiredClass, @NonNull String getAccessor) {
			Class<?> superClass = requiredClass.getSuperclass();
			if (superClass != null) {
				try {
					Class<?> lessDerivedSuperClass = getLeastDerivedClass(superClass, getAccessor);
					if (lessDerivedSuperClass != null) {
						return lessDerivedSuperClass;
					}
					Method method = superClass.getMethod(getAccessor);
					if (method != null) {
						return superClass;
					}
				} catch (Exception e) {
				}
			}
			for (Class<?> superInterface : requiredClass.getInterfaces()) {
				Class<?> lessDerivedSuperInterface = getLeastDerivedClass(superInterface, getAccessor);
				if (lessDerivedSuperInterface != null) {
					return lessDerivedSuperInterface;
				}
				try {
					Method method = superInterface.getMethod(getAccessor);
					if (method != null) {
						return superInterface;
					}
				} catch (Exception e) {
				}
			}
			return null;
		}

		protected @Nullable Method getLeastDerivedMethod(Class<?> requiredClass, @NonNull String getAccessor) {
			Method leastDerivedMethod = getLeastDerivedMethodInternal(requiredClass, getAccessor);
			if (leastDerivedMethod != null) {
				return leastDerivedMethod;
			}
			else {
				try {
					return requiredClass.getMethod(getAccessor);
				} catch (Exception e) {
					return null;
				}
			}
		}
		private @Nullable Method getLeastDerivedMethodInternal(Class<?> requiredClass, @NonNull String getAccessor) {
			Class<?> superClass = requiredClass.getSuperclass();
			if (superClass != null) {
				try {
					Method lessDerivedSuperMethod = getLeastDerivedMethodInternal(superClass, getAccessor);
					if (lessDerivedSuperMethod != null) {
						return lessDerivedSuperMethod;
					}
					Method method = superClass.getMethod(getAccessor);
					if (method != null) {
						return method;
					}
				} catch (Exception e) {
				}
			}
			for (Class<?> superInterface : requiredClass.getInterfaces()) {
				Method lessDerivedSuperMethod = getLeastDerivedMethodInternal(superInterface, getAccessor);
				if (lessDerivedSuperMethod != null) {
					return lessDerivedSuperMethod;
				}
				try {
					Method method = superInterface.getMethod(getAccessor);
					if (method != null) {
						return method;
					}
				} catch (Exception e) {
				}
			}
			return null;
		}
	}
}
