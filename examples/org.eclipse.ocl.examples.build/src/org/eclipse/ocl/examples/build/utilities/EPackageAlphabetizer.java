/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
 * $Id: EPackageAlphabetizer.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * Alphabeticizes a designated <tt>modelSlot</tt> so that primitive types
 * appear before enumerations before classes before associations, each
 * in alphabetical order.
 */
public class EPackageAlphabetizer extends WorkflowComponentWithModelSlot
{
	public static final class EClassifierComparator implements Comparator<EClassifier>
	{
		public static final @NonNull EClassifierComparator INSTANCE = new EClassifierComparator();

		@Override
		public int compare(EClassifier o1, EClassifier o2) {
			EClass e1 = o1.eClass();
			EClass e2 = o2.eClass();
			if (e1 != e2) {
				if (EcorePackage.Literals.ECLASS.isSuperTypeOf(e1)) {
					return 1;
				}
				else if (EcorePackage.Literals.ECLASS.isSuperTypeOf(e2)) {
					return -1;
				}
				if (EcorePackage.Literals.EENUM.isSuperTypeOf(e1)) {
					return 1;
				}
				else if (EcorePackage.Literals.EENUM.isSuperTypeOf(e2)) {
					return -1;
				}
				if (EcorePackage.Literals.EDATA_TYPE.isSuperTypeOf(e1)) {
					return -1;
				}
				else if (EcorePackage.Literals.EDATA_TYPE.isSuperTypeOf(e2)) {
					return 1;
				}
			}
			String n1 = o1.getName();
			String n2 = o2.getName();
			return DomainUtil.safeCompareTo(n1, n2);
		}
	}

	private Logger log = Logger.getLogger(getClass());	

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		Resource resource = (Resource) ctx.get(getModelSlot());
		log.info("Alphabeticizing '" + resource.getURI() + "'");
		Map<EList<? extends EObject>, Comparator<? extends EObject>> listOfLists = new HashMap<EList<? extends EObject>, Comparator<? extends EObject>>();
		for (Iterator<EObject> it = resource.getAllContents(); it.hasNext(); ) {
			EObject eObject = it.next();
			if (eObject instanceof EPackage) {
				EPackage package_ = (EPackage) eObject;
				listOfLists.put(package_.getESubpackages(), DomainUtil.ENamedElementComparator.INSTANCE);
				listOfLists.put(package_.getEClassifiers(), EClassifierComparator.INSTANCE);
			}
			else if (eObject instanceof EClass) {
				EClass class_ = (EClass) eObject;
				listOfLists.put(class_.getEStructuralFeatures(), DomainUtil.ENamedElementComparator.INSTANCE);
				listOfLists.put(class_.getEOperations(), DomainUtil.ENamedElementComparator.INSTANCE);
			}
			if (eObject instanceof EModelElement) {
				EModelElement eEModelElement = (EModelElement) eObject;
				listOfLists.put(eEModelElement.getEAnnotations(), DomainUtil.EAnnotationComparator.INSTANCE);
			}
		}
		for (Map.Entry<EList<? extends EObject>, Comparator<? extends EObject>> entry : listOfLists.entrySet()) {
			@SuppressWarnings("unchecked") EList<EObject> eList = (EList<EObject>)entry.getKey();
			@SuppressWarnings("unchecked") Comparator<EObject> comparator = (Comparator<EObject>) entry.getValue();
			List<EObject> list = new ArrayList<EObject>(eList);
			Collections.sort(list, comparator);
			eList.clear();
			eList.addAll(list);
		}
	}
}
