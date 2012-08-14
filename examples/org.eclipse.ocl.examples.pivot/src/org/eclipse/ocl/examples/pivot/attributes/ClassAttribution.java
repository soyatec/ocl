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
 * $Id: ClassAttribution.java,v 1.10 2011/05/21 14:56:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.util.Pivotable;

public class ClassAttribution extends AbstractAttribution
{
	public static final ClassAttribution INSTANCE = new ClassAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		org.eclipse.ocl.examples.pivot.Class targetClass = (org.eclipse.ocl.examples.pivot.Class) target;
		MetaModelManager metaModelManager = environmentView.getMetaModelManager();
		if (targetClass.getOwningTemplateParameter() != null) {
			Type type = metaModelManager.getOclAnyType(); // WIP use lowerbound
			environmentView.addAllOperations(type, Boolean.FALSE);
			environmentView.addAllProperties(type, Boolean.FALSE);
			return null;
		}
		if (targetClass.getTemplateBinding().size() == 0) {
			EObject scopeTarget = scopeView.getTarget();
			if (scopeTarget instanceof Pivotable) {
				Element pivot = ((Pivotable)scopeTarget).getPivot();
				if (pivot == target) {		// Inherited template parameters are invisible.
					environmentView.addAllTypeTemplateParameterables(targetClass);
				}
			}
		}
		if (target instanceof Metaclass) {
			Type instanceType = ((Metaclass)target).getInstanceType();
			if ((instanceType != null) && (instanceType.getOwningTemplateParameter() == null)) {		// Maybe null
//				environmentView.addNamedElements(instanceType, metaModelManager.getLocalOperations(instanceType, Boolean.TRUE));
//				environmentView.addNamedElements(instanceType, metaModelManager.getLocalProperties(instanceType, Boolean.TRUE));
				environmentView.addAllOperations(instanceType, Boolean.TRUE);
				environmentView.addAllProperties(instanceType, null /*Boolean.TRUE*/);		// FIXME
			}
		}
		environmentView.addAllOperations(targetClass, Boolean.FALSE);
		environmentView.addAllProperties(targetClass, null);
//		environmentView.addNamedElements(targetClass, metaModelManager.getLocalOperations(targetClass, Boolean.FALSE));
//		environmentView.addNamedElements(targetClass, metaModelManager.getLocalProperties(targetClass, Boolean.FALSE));
//		if (!environmentView.hasFinalResult()) {
/*			if (target instanceof Metaclass) {
				Set<Type> alreadyVisitedMetaTypes = new HashSet<Type>();
				Type instanceType = ((Metaclass)target).getInstanceType();
				if ((instanceType != null) && (instanceType.getOwningTemplateParameter() == null)) {		// Maybe null
					environmentView.addAllContents(instanceType, scopeView, instanceType, Boolean.TRUE, alreadyVisitedMetaTypes);
				}
			}	// FIXME don't shorten non-static search after static match
			Set<Type> alreadyVisitedTypes = new HashSet<Type>();
//			org.eclipse.ocl.examples.pivot.Class unspecializedTarget = PivotUtil.getUnspecializedTemplateableElement(target);	// FIXME
			for (Type superClass : metaModelManager.getSuperClasses(targetClass)) {
				if (superClass != null) {
					environmentView.addAllContents(targetClass, scopeView, superClass, Boolean.FALSE, alreadyVisitedTypes);
				}
			}
//		} */
		return scopeView.getParent();
	}
}
