/**
 * <copyright>
 * 
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLSettingDelegate.java,v 1.4 2011/03/01 08:47:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicSettingDelegate;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.common.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.examples.domain.evaluation.DomainException;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Query;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.osgi.util.NLS;

/**
 * An implementation of a setting delegate that computes OCL derived features.
 * 
 * @since 3.0
 */
public class OCLSettingDelegate extends BasicSettingDelegate.Stateless
{
	protected final OCLDelegateDomain delegateDomain;
	private Property property;
	private ExpressionInOCL specification;

	/**
	 * Initializes me with my structural feature.
	 * 
	 * @param structuralFeature
	 *            the structural feature that I handle
	 */
	public OCLSettingDelegate(@NonNull OCLDelegateDomain delegateDomain, @NonNull EStructuralFeature structuralFeature) {
		super(structuralFeature);
		this.delegateDomain = delegateDomain;
	}

	@Override
	protected Object get(InternalEObject owner, boolean resolve, boolean coreType) {
		try {
			OCL ocl = delegateDomain.getOCL();
			MetaModelManager metaModelManager = ocl.getEnvironment().getMetaModelManager();
			if (specification == null) {
				Property property = getProperty();
				specification = SettingBehavior.INSTANCE.getExpressionInOCL(metaModelManager, property);
				SettingBehavior.INSTANCE.validate(property);
			}
			Query query = ocl.createQuery(DomainUtil.nonNullJDT(specification));
			Value result = query.evaluate(owner);
			return result.asEcoreObject();
		}
		catch (DomainException e) {
			String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, property);
			throw new OCLDelegateException(message, e);
		}
	}

	public @NonNull Property getProperty() {
		if (property == null) {
			property = delegateDomain.getPivot(Property.class, DomainUtil.nonNullJDT(eStructuralFeature));
			if (property == null) {
				throw new OCLDelegateException("No pivot property for " + eStructuralFeature) ;
			}
		}
		return DomainUtil.nonNullJDT(property);
	}

	@Override
	protected boolean isSet(InternalEObject owner) {
		return false; // derived features are, implicitly, never set
	}

	@Override
	public String toString() {
		if (property != null) {
			return "<" + delegateDomain.getURI() + ":setting> " + property; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			String name = eStructuralFeature.getEContainingClass().getEPackage().getName()
			+ "::" + eStructuralFeature.getEContainingClass().getName()
			+ "." + eStructuralFeature.getName();
			return "<" + delegateDomain.getURI() + ":setting> " + name; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
