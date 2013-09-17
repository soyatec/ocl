/**
 * <copyright>
 * 
 * Copyright (c) 2013 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.build.xtend;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.build.xtend.GenerateCSVisitors;

public class GenerateAutoCS2ASVisitors extends GenerateCSVisitors
{
	@Override
	public void generateVisitors(@NonNull GenPackage genPackage) {
		AutoCodeGenerator.generate(genPackage, isDerived() ? superProjectPrefix : null);
	}
}
