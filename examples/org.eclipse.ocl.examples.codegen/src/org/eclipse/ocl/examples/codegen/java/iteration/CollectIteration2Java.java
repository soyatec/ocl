/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
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
package org.eclipse.ocl.examples.codegen.java.iteration;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.values.CollectionValue;

public class CollectIteration2Java extends AbstractAccumulation2Java
{
	public static final @NonNull CollectIteration2Java INSTANCE = new CollectIteration2Java();
	
	public void appendUpdate(@NonNull JavaStream js, @NonNull CGBuiltInIterationCallExp cgIterationCallExp) {
		CGValuedElement cgBody = getBody(cgIterationCallExp);
		CGIterator cgAccumulator = getAccumulator(cgIterationCallExp);
		CGTypeId cgBodyTypeId = cgBody.getTypeId();
		ElementId elementId = cgBodyTypeId.getElementId();
		Class<?> boxedClass = elementId != null ? js.getCodeGenerator().getBoxedClass(elementId) : Object.class;
		if (CollectionValue.class.isAssignableFrom(boxedClass)) {
			js.append("for (Object value : ");
			js.appendValueName(cgBody);
			js.append(".flatten().getElements()) {\n");
			{
				js.pushIndentation(null);
				js.appendValueName(cgAccumulator);
				js.append(".add(value);\n");
				js.popIndentation();
			}
			js.append("}\n");
		}
		else if (boxedClass.isAssignableFrom(CollectionValue.class)) {
			js.append("if (");
			js.appendValueName(cgBody);
			js.append(" instanceof ");
			js.appendClassReference(CollectionValue.class);
			js.append(") {\n");
			{
				js.pushIndentation(null);
				js.append("for (Object value : ((");
				js.appendClassReference(CollectionValue.class);
				js.append(")");
				js.appendValueName(cgBody);
				js.append(").flatten().getElements()) {\n");
				{
					js.pushIndentation(null);
					js.appendValueName(cgAccumulator);
					js.append(".add(value);\n");
					js.popIndentation();
				}
				js.append("}\n");
				js.popIndentation();
			}
			js.append("}\n");
			js.append("else {\n");
			{
				js.pushIndentation(null);
				js.appendValueName(cgAccumulator);
				js.append(".add(");
				js.appendValueName(cgBody);
				js.append(");\n");
				js.popIndentation();
			}
			js.append("}\n");				
		}
		else {
			js.appendValueName(cgAccumulator);
			js.append(".add(");
			js.appendValueName(cgBody);
			js.append(");\n");
		}
	}
}