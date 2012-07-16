/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: Pivot2CS.java,v 1.4 2011/03/01 08:47:48 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.pivot2cs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.xtext.base.utilities.CSI2PivotMapping;

/**
 * CS2Pivot manages the equivalence between a Concrete Syntax Resources
 * and their corresponding Pivot Resources creating a CS2PivotConversion
 * to update.
 */
public class Pivot2CS extends AbstractConversion
{	
	public static interface Factory {
		BaseDeclarationVisitor createDeclarationVisitor(Pivot2CSConversion converter);
		BaseReferenceVisitor createReferenceVisitor(Pivot2CSConversion converter);

		/**
		 * Return a list of classes for which this Pivot2CS overrides a base Pivot2CS.
		 */
		EClass[] getEClasses();
	}
	
	private Map<EClass, Factory> factoryMap = new HashMap<EClass, Factory>();
	
	/**
	 * Mapping of each CS resource to its corresponding pivot Resource.
	 */
	protected final Map<? extends Resource, ? extends Resource> cs2pivotResourceMap;
	
	public Pivot2CS(Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, MetaModelManager metaModelManager) {
		super(metaModelManager);
		this.cs2pivotResourceMap = cs2pivotResourceMap;
	}
	
	public Pivot2CS(Pivot2CS aConverter) {
		super(aConverter.metaModelManager);
		this.cs2pivotResourceMap = aConverter.cs2pivotResourceMap;
	}

	protected void addFactory(Factory factory) {
		for (EClass eClass : factory.getEClasses()) {
			factoryMap.put(eClass, factory);
		}
	}

	public BaseDeclarationVisitor createDefaultDeclarationVisitor(Pivot2CSConversion conversion) {
		return new BaseDeclarationVisitor(conversion);
	}

	public BaseReferenceVisitor createDefaultReferenceVisitor(Pivot2CSConversion conversion) {
		return new BaseReferenceVisitor(conversion);
	}

	public Collection<? extends Resource> getCSResources() {
		return cs2pivotResourceMap.keySet();
	}

	public Factory getFactory(EClass eClass) {
		return factoryMap.get(eClass);
	}

	public Resource getPivotResource(Resource csResource) {
		return cs2pivotResourceMap.get(csResource);
	}

	public Collection<? extends Resource> getPivotResources() {
		return cs2pivotResourceMap.values();
	}
	
	public void update() {
		Pivot2CSConversion conversion = new Pivot2CSConversion(this);
		Collection<? extends Resource> csResources = getCSResources();
		conversion.update(csResources);
		CSI2PivotMapping cs2PivotMapping = CSI2PivotMapping.getAdapter(metaModelManager);
		cs2PivotMapping.update(csResources);
	}
}