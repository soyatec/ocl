/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.context;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * EObjectContext supports parsing OCL expressions in the context of the lazily determined classifier of an EObject.
 */
public class EObjectContext extends AbstractParserContext
{
	protected final @Nullable EObject eObject;
	private /*@LazyNonNull*/ Type classContext = null;

	public EObjectContext(@NonNull MetaModelManager metaModelManager, @Nullable URI uri, @Nullable EObject eObject) {
		super(metaModelManager, uri);
		this.eObject = eObject;
	}

	@Override
	public @NonNull Type getClassContext() {
		Type classContext2 = classContext;
		if (classContext2 == null) {
			try {
				if (eObject instanceof Type) {
					classContext2 = metaModelManager.getMetaclass((Type)eObject);
				}
//				else if (eObject instanceof NamedElement) {
//					classContext = eObject;
//				}
//				else if (eObject instanceof EClassifier) {
//					Type type = metaModelManager.getPivotOf(Type.class, eObject);
//					if (type != null) {
//						classContext = metaModelManager.getMetaclass(type);
//					}
//				}
				else if (eObject != null) {
					classContext2 = metaModelManager.getPivotOf(Type.class, eObject.eClass());
				}
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (classContext2 == null) {
				classContext2 = metaModelManager.getOclVoidType();
			}
			classContext = classContext2;
		}
		return classContext2;
	}

	@Override
	public void initialize(@NonNull Base2PivotConversion conversion, @NonNull ExpressionInOCL expression) {
		super.initialize(conversion, expression);
		Type classContext = getClassContext();
		conversion.setContextVariable(expression, Environment.SELF_VARIABLE_NAME, classContext);
	}
}
