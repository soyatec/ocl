/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2as;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibRootPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaTypeName;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.util.AbstractOCLstdlibCSContainmentVisitor;

public class OCLstdlibCSContainmentVisitor extends AbstractOCLstdlibCSContainmentVisitor
{
	public OCLstdlibCSContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitLibClassCS(@NonNull LibClassCS csElement) {
		EClass eClass = null;
		MetaTypeName metaType = csElement.getMetaTypeName();
		if ((metaType != null) && !metaType.eIsProxy()) {
			String metaTypeName = metaType.getName();
			eClass = (EClass) EcoreUtils.getNamedElement(PivotPackage.eINSTANCE.getEClassifiers(), metaTypeName);
		}
		if (eClass == null) {
			eClass = PivotPackage.Literals.CLASS;
		}
		@SuppressWarnings("unchecked")
		Class<org.eclipse.ocl.examples.pivot.Class> instanceClass = (Class<org.eclipse.ocl.examples.pivot.Class>)eClass.getInstanceClass();
		if (instanceClass != null) {
			org.eclipse.ocl.examples.pivot.Class pivotElement = refreshNamedElement(instanceClass, eClass, csElement);
			if (pivotElement != null) {
				refreshClass(pivotElement, csElement);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitLibIterationCS(@NonNull LibIterationCS csElement) {
		Iteration pivotElement = refreshNamedElement(Iteration.class, PivotPackage.Literals.ITERATION, csElement);
		if (pivotElement != null) {
			pivotElement.setIsInvalidating(csElement.isInvalidating());
			pivotElement.setIsValidating(csElement.isValidating());
			context.refreshTemplateSignature(csElement, pivotElement);
			context.refreshPivotList(Parameter.class, pivotElement.getOwnedIterator(), csElement.getOwnedIterator());
			context.refreshPivotList(Parameter.class, pivotElement.getOwnedAccumulator(), csElement.getOwnedAccumulator());
			context.refreshPivotList(Parameter.class, pivotElement.getOwnedParameter(), csElement.getOwnedParameter());
		}
		return null;
	}

	@Override
	public Continuation<?> visitLibOperationCS(@NonNull LibOperationCS csElement) {
		Continuation<?> cont = super.visitLibOperationCS(csElement);
		Operation pivotElement = refreshNamedElement(Operation.class, PivotPackage.Literals.OPERATION, csElement);
		if (pivotElement != null) {
			pivotElement.setIsInvalidating(csElement.isInvalidating());
			pivotElement.setIsValidating(csElement.isValidating());
		}
		return cont;
	}

	@Override
	public Continuation<?> visitLibPackageCS(@NonNull LibPackageCS csElement) {
		@SuppressWarnings("unused")
		Library pivotElement = refreshPackage(Library.class, PivotPackage.Literals.LIBRARY, csElement);		
		return null;
	}

	@Override
	public Continuation<?> visitLibRootPackageCS(@NonNull LibRootPackageCS csElement) {
		Resource eResource = csElement.eResource();
		if (eResource != null) {
			Root pivotElement = refreshRootPackage(Root.class, PivotPackage.Literals.ROOT, csElement);		
			if (pivotElement != null) {
				context.installRootElement(eResource, pivotElement);		// Ensure containment viable for imported library type references
				importPackages(csElement);			// FIXME This has to be after refreshPackage which is irregular and prevents local realization of ImportCS etc
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitPrecedenceCS(@NonNull PrecedenceCS csElement) {
		Precedence pivotElement = refreshNamedElement(Precedence.class, PivotPackage.Literals.PRECEDENCE, csElement);
		if (pivotElement != null) {
			pivotElement.setAssociativity(csElement.isRightAssociative() ? AssociativityKind.RIGHT : AssociativityKind.LEFT);
		}
		return null;
	}
}
