/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.oclinjunit;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;

/**
 * A JavaLocalContext maintains the Java-specific context for generation of coide from a CGOperation.
 */
public class JUnitLocalContext extends JavaLocalContext
{
	public JUnitLocalContext(@NonNull JUnitGlobalContext globalContext, @NonNull CGElement cgScope) {
		super(globalContext, cgScope);
	}
	
	public JUnitLocalContext(@NonNull JUnitLocalContext parentContext, @NonNull CGElement cgScope) {
		super(parentContext, cgScope);
	}

	@Override
	public @NonNull JUnitLocalContext createNestedContext(@NonNull CGElement cgScope) {
		return new JUnitLocalContext(this, cgScope);
	}

	/*
	 * If the self parameter has a known type other than Object, we add a CGCastParamter that casts the passed parameter self_0:Object to a better self.
	 * Otherwise we just rename the passed parameter to be self. The self parameter is of course maintained in the outer name context.
	 */
	@Override
	public @NonNull CGParameter getCastParameter(@NonNull CGParameter cgParameter) {
		if (cgParameter instanceof CGCastParameter) {
			return cgParameter;
		}
		if (JavaConstants.SELF_NAME.equals(cgParameter.getName())) {
			JavaLocalContext parentContext2 = parentContext;
			if (parentContext2 != null) {
				return parentContext2.getCastParameter(cgParameter);
			}
			else {
				CGParameter cgCastParameter = basicGetCastParameter(cgParameter);
				if (cgCastParameter == null) {
					cgCastParameter = createCastParameter(cgParameter);
					cgCastParameter.setValueName(globalContext.getSelfName());
					addCastParameter(cgParameter, cgCastParameter);
				}
				return cgCastParameter;
			}
		}
		return super.getCastParameter(cgParameter);
	}

	@Override
	public @NonNull JUnitGlobalContext getGlobalContext() {
		return (JUnitGlobalContext) globalContext;
	}
}
