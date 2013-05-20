/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
 * $Id: XtextVisitorCodeGenerator.java,v 1.4 2011/03/17 20:01:45 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.build.acceleo.GenerateXtextVisitors;

/**
 * Generates the javaFolder/'javaPackageName'/visitorClassName.java file providing
 * a static Java-creation of the libraryFile OCL standard library definition.
 */
public class XtextVisitorCodeGenerator extends DerivedModelVisitorCodeGenerator
{

	
	@Override
	protected AbstractAcceleoGenerator createAcceleoGenerator(
			EObject ecoreModel, File outputFolder, List<Object> arguments)
			throws IOException {
		return new GenerateXtextVisitors(ecoreModel, outputFolder, arguments);
	}
}
