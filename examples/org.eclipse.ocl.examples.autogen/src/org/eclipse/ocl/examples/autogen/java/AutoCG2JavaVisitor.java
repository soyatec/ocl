/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.ocl.examples.autogen.java;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;
import org.eclipse.ocl.examples.autogen.autocgmodel.util.AutoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;

/**
 * A AutoCG2JavaVisitor supports generation of Java code from an optimized Auto CG transformation tree.
 */
public class AutoCG2JavaVisitor extends CG2JavaVisitor implements AutoCGModelVisitor<Object>
{
	protected final @NonNull AutoAnalyzer analyzer;
	protected final @NonNull CGPackage cgPackage;
	protected final @Nullable List<CGValuedElement> sortedGlobals;
	
	public AutoCG2JavaVisitor(@NonNull AutoCodeGenerator codeGenerator, @NonNull CGPackage cgPackage,
			@Nullable List<CGValuedElement> sortedGlobals) {
		super(codeGenerator);
		this.analyzer = codeGenerator.getAnalyzer();
		this.cgPackage = cgPackage;
		this.sortedGlobals = sortedGlobals;
	}

	protected void doConstructor(@NonNull CGClass cgClass) {
		js.append("/**\n");
		js.append(" * Initializes me with an initial value for my result.\n");
		js.append(" * \n");
		js.append(" * @param context my initial result value\n");
		js.append(" */\n");
		js.append("public " + cgClass.getName() + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(CS2PivotConversion.class);
		js.append(" context) {\n");
		js.pushIndentation(null);
		js.append("super(context);\n");
		js.popIndentation();
		js.append("}\n");
	}

	protected void doVisiting() {
		js.append("public ");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(Continuation.class);
		js.append(" visiting(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(VisitableCS.class);
		js.append(" visitable) {\n");
		js.pushIndentation(null);
		js.append("throw new UnsupportedOperationException();\n");
		js.popIndentation();
		js.append("}\n");
	}

	public @Nullable Object visitCGASTCallExp(@NonNull CGASTCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @Nullable Object visitCGClass(@NonNull CGClass cgClass) {		
		String className = cgClass.getName();
/*		js.append("/**\n");
		js.append(" * The " + className + " transformation:\n");
		js.append(" * <p>\n");
		js.append(" * Construct with an evaluator\n");
		js.append(" * <br>\n");
		js.append(" * Populate each input model with {@link addRootObjects(String,List)}\n");
		js.append(" * <br>\n");
		js.append(" * {@link run()}\n");
		js.append(" * <br>\n");
		js.append(" * Extract each output model with {@link getRootObjects(String)}\n");
		js.append(" * /\n"); */
//		js.append("@SuppressWarnings(\"nls\")\n");
		js.append("public class " + className);
		List<CGClass> cgSuperTypes = cgClass.getSuperTypes();
		boolean isFirst = true;
		for (CGClass cgSuperType : cgSuperTypes) {
			if (!cgSuperType.isInterface()) {
				if (isFirst) {
					js.append("\n\textends ");
				}
				else {
					js.append(", ");
				}
				js.appendClassReference(cgSuperType);
				isFirst = false;
			}
		}
		isFirst = true;
		for (CGClass cgSuperType : cgSuperTypes) {
			if (cgSuperType.isInterface()) {
				if (isFirst) {
					js.append("\n\timplements ");
				}
				else {
					js.append(", ");
				}
				js.appendClassReference(cgSuperType);
				isFirst = false;
			}
		}
		js.append("\n");
		js.append("{\n");
		js.pushIndentation(null);
		if (sortedGlobals != null) {
			for (CGValuedElement cgElement : sortedGlobals) {
				assert cgElement.isGlobal();
				cgElement.accept(this);
			}
		}
		js.append("\n");
		doConstructor(cgClass);
		if (cgSuperTypes.size() <= 1) {
			js.append("\n");
			doVisiting();
		}
		for (CGOperation cgOperation : cgClass.getOperations()) {
			js.append("\n");
			cgOperation.accept(this);
		}
		js.popIndentation();
		js.append("}\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGEcoreOperation(@NonNull CGEcoreOperation object) {
		Type csType = (Type) object.getAst();
		TypeDescriptor typeDescriptor = context.getTypeDescriptor(csType.getTypeId(), false);
		js.append("public ");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(Continuation.class);
		js.append(" " + object.getName() + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(typeDescriptor);
		js.append(" ");
		js.append("csElement");
		js.append(") {\n");
		js.pushIndentation(null);
		js.append("throw new UnsupportedOperationException();\n");
		js.popIndentation();
		js.append("}\n");
		return null;
	}

	public @Nullable Object visitCGContainmentPart(@NonNull CGContainmentPart object) {
		return visitCGValuedElement(object);
	}

	public @Nullable Object visitCGContainmentVisit(@NonNull CGContainmentVisit object) {
		Type csType = (Type) object.getAst();
//		Operation astOperation = DomainUtil.getNamedElement(csType.getOwnedOperation(), "ast");
		TypeDescriptor typeDescriptor = context.getTypeDescriptor(csType.getTypeId(), false);
		js.append("public ");
		js.appendIsRequired(false);
		js.append(" ");
		js.appendClassReference(Continuation.class);
		js.append(" " + object.getName() + "(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(typeDescriptor);
		js.append(" ");
		js.append("csElement");
		js.append(") {\n");
		js.pushIndentation(null);
		
		js.appendClassReference(CS2Pivot.class);
		js.append("converter = context.getConverter();\n");
		js.append("// AS element creation\n");
		
/*		result.append('''
			CS2Pivot converter = context.getConverter();
			// AS element creation
			«typeQN» asElement = csElement != null ? («typeQN») converter.getPivotElement(csElement) : null;
			if (asElement == null) {
				asElement = «getFactoryInstanceAccessor(astType)».create«astType.name»();
				converter.installPivotDefinition(csElement, asElement);
			}
			
		''');
		
		*/
		for (CGContainmentPart part : object.getParts()) {
			part.accept(this);
		}
			
		// TODO any heuristic to include comment update ?
		js.append("// AS element comments update;\n");
		js.append("context.refreshComments(asElement, csElement);\n");
		js.append("return null;\n");
		js.popIndentation();
		js.append("}\n");
		return null;
	}
}
