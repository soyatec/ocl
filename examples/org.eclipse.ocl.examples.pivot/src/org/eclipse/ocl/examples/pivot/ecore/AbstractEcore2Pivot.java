/**
 * <copyright>
 *
 * Copyright (c) 2010,2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.pivot.ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.pivot.utilities.External2Pivot;

public abstract class AbstractEcore2Pivot extends AbstractConversion implements External2Pivot, PivotConstants
{
	protected AbstractEcore2Pivot(MetaModelManager metaModelManager) {
		super(metaModelManager);
	}
	
	public abstract void addGenericType(EGenericType eObject);

	public abstract void addMapping(EObject eObject, Element pivotElement);
	
	public abstract void error(String message);

	public abstract void queueReference(EObject eObject);

	public <T extends NamedElement> T refreshNamedElement(Class<T> pivotClass, EClass pivotEClass, ENamedElement eNamedElement) {
		EFactory eFactoryInstance = pivotEClass.getEPackage().getEFactoryInstance();
		EObject pivotElement = eFactoryInstance.create(pivotEClass);
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException();
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		if (eNamedElement != null) {
			castElement.setName(eNamedElement.getName());
		}
		return castElement;
	}
}