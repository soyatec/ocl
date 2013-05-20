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
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2pivot;

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
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.MetaTypeName;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS;

public class OCLstdlibContainmentVisitor extends AbstractOCLstdlibContainmentVisitor
{
	public OCLstdlibContainmentVisitor(@NonNull CS2PivotConversion context) {
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
	public Continuation<?> visitLibConstraintCS(@NonNull LibConstraintCS object) {
		// TODO Auto-generated method stub
		return super.visitLibConstraintCS(object);
	}

	@Override
	public Continuation<?> visitLibIterationCS(@NonNull LibIterationCS csElement) {
		Iteration pivotElement = refreshNamedElement(Iteration.class, PivotPackage.Literals.ITERATION, csElement);
		if (pivotElement != null) {
			pivotElement.setIsInvalidating(csElement.isInvalidating());
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
			Root pivotElement = refreshRoot(Root.class, PivotPackage.Literals.ROOT, csElement);		
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
