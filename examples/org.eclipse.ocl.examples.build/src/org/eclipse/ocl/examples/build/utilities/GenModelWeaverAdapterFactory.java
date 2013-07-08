/**
 * <copyright>
 * 
 * Copyright (c) 2012,2013 CEA LIST and others.
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
package org.eclipse.ocl.examples.build.utilities;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * The GenModelWeaverAdapterFactory contributes weaving functionality to the GenModel activity.
 */
public class GenModelWeaverAdapterFactory extends GenModelGeneratorAdapterFactory
{
	/**
	 * A descriptor for this adapter factory, which can be used to programatically
	 * {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.Descriptor.Registry#addDescriptor(String, org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.Descriptor)
	 * register} it.
	 * 
	 * @see org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.Descriptor.Registry
	 */
	public static final GeneratorAdapterFactory.Descriptor DESCRIPTOR = new GeneratorAdapterFactory.Descriptor()
	{
		public GeneratorAdapterFactory createAdapterFactory() {
			return new GenModelWeaverAdapterFactory();
		}
	};

	public GenModelWeaverAdapterFactory() {
		GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor(GenModelPackage.eNS_URI, DESCRIPTOR);
	}

	@Override
	public Adapter createGenClassAdapter() {
		genClassGeneratorAdapter = null;
		return genClassGeneratorAdapter;
	}

	@Override
	public Adapter createGenEnumAdapter() {
	    genEnumGeneratorAdapter = null;
	    return genEnumGeneratorAdapter;
	}

	@Override
	public Adapter createGenModelAdapter() {
		if (genModelGeneratorAdapter == null) {
			genModelGeneratorAdapter = new GenModelWeaverAdapter(this);
		}
		return genModelGeneratorAdapter;
	}

	@Override
	public Adapter createGenPackageAdapter() {
		genPackageGeneratorAdapter = null;
		return genPackageGeneratorAdapter;
	}
}
