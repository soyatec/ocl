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
import org.eclipse.ocl.examples.codegen.cgmodel.CGBuiltInIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

public class ForAllIteration2Java extends AbstractIteration2Java
{
	public static final @NonNull ForAllIteration2Java INSTANCE = new ForAllIteration2Java();

//	@Override
//	public void appendAccumulatorInit(@NonNull JavaStream js, @NonNull CGBuiltInIterationCallExp cgIterationCallExp) {
//		if (LibraryConstants.NULL_SATISFIES_INVOLUTION) {
//			js.append("null");
//		};
//	}
	
	public void appendUpdate(@NonNull JavaStream js, @NonNull CGBuiltInIterationCallExp cgIterationCallExp) {
		CGValuedElement cgBody = getBody(cgIterationCallExp);
		if (cgBody.getASTypeId() == TypeId.BOOLEAN) { 
			js.append("if (");
			js.appendValueName(cgBody);
			js.append(" != ");
			js.appendClassReference(ValuesUtil.class);
			js.append(".TRUE_VALUE) {			// Carry unless something not found\n");
			js.pushIndentation(null);
				js.appendValueName(cgIterationCallExp);
				js.append(" = ");
				js.appendClassReference(ValuesUtil.class);
				js.append(".FALSE_VALUE;			// Abort after a fail\n");
				js.append("break;\n");
			js.popIndentation();
			js.append("}\n");
		}
		else {
			js.appendThrowInvalidValueException(EvaluatorMessages.NonBooleanBody, "forAll");
		}
	}
	
	public boolean appendFinalValue(@NonNull JavaStream js, @NonNull CGBuiltInIterationCallExp cgIterationCallExp) {
//		if (LibraryConstants.NULL_SATISFIES_INVOLUTION) {
//			js.append("forAll = accumulator == evaluator ? null : accumulator != null ? throw accumulator : true");
//		};
//		else {
			js.appendAssignment(cgIterationCallExp, js.getCodeGenerator().getAnalyzer().getBoolean(true));
//		}
		return true;
	}

//	@Override
//	public @Nullable CGTypeId getAccumulatorTypeId(@NonNull CodeGenAnalyzer analyzer, @NonNull CGBuiltInIterationCallExp cgIterationCallExp) {
//		return LibraryConstants.NULL_SATISFIES_INVOLUTION ? analyzer.getTypeId(new JavaTypeId(Object.class)) : null;
//	}
}
