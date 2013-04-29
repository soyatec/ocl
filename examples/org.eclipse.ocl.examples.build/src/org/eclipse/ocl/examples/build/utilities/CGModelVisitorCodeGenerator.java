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
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.build.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.build.acceleo.GenerateCGModelVisitors;

/**
 * Specifies the Acceleo template that selects the CG visitors.
 */
public class CGModelVisitorCodeGenerator extends ModelVisitorCodeGenerator
{
	@Override
	protected AbstractAcceleoGenerator createAcceleoGenerator(EObject ecoreModel,
			File outputFolder, List<Object> arguments) throws IOException {
		return new GenerateCGModelVisitors(ecoreModel, outputFolder, arguments);
	}
}
