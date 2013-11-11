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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody;
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
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 * A AutoCG2JavaVisitor supports generation of Java code from an optimized Auto CG transformation tree.
 */
public class AutoCG2JavaVisitor extends CG2JavaVisitor implements AutoCGModelVisitor<Boolean>
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
		js.append("this.converter = context.getConverter();\n");
			js.append("this.idResolver = converter.getMetaModelManager().getIdResolver();\n");
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

	public @NonNull Boolean visitCGASTCallExp(@NonNull CGASTCallExp object) {
		CGValuedElement cgSource = DomainUtil.nonNullState(object.getSource());
		TypeDescriptor typeDescriptor = context.getTypeDescriptor(object);
		if (!js.appendLocalStatements(cgSource)) {
			return false;
		}
		js.appendDeclaration(object);
		js.append(" = ");
		js.appendReferenceTo(typeDescriptor, cgSource);
		js.append(".getPivot();\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGClass(@NonNull CGClass cgClass) {		
		String className = cgClass.getName();
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
	    js.append("protected final ");
	    js.appendIsRequired(true);
	    js.append(" ");
	    js.appendClassReference(CS2Pivot.class);
	    js.append(" converter;\n");
	    js.append("protected final ");
	    js.appendIsRequired(true);
	    js.append(" ");
	    js.appendClassReference(IdResolver.class);
	    js.append(" idResolver;\n");
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
		return true;
	}

	@Override
	public @NonNull Boolean visitCGEcoreOperation(@NonNull CGEcoreOperation object) {
		String visitName = object.getName();
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
		js.append("self");
		js.append(") {\n");
		js.pushIndentation(null);
		js.append("throw new UnsupportedOperationException(\"");
		js.append(visitName);
		js.append(" is not supported by \" + getClass().getName()");
		js.append(");\n");
		js.popIndentation();
		js.append("}\n");
		return true;
	}

	public @Nullable Boolean visitCGContainmentBody(@NonNull CGContainmentBody object) {
		Type asType = DomainUtil.nonNullState(((Operation) object.getAst()).getType());
		String factoryName = context.getGenModelHelper().getQualifiedFactoryInterfaceName(asType);
		// TypeDescriptor typeDescriptor = context.getTypeDescriptor(asType.getTypeId(), false);
		String typeQualifiedName = context.getGenModelHelper().getEcoreInterfaceName(asType);
		js.append("//\n");
		js.append("// " + asType.getName() + "\n");
		js.append("//\n");
		js.appendClassReference(typeQualifiedName);
		js.append(" result;\n");
		js.appendClassReference(Element.class);
		js.append(" element = converter.getPivotElement(self);\n");
		
		js.append("if ((element != null) && (element.getClass() == ");
		js.appendClassReference(typeQualifiedName);
		js.append(".class)) {\n");
		js.pushIndentation(null);
		js.append("result = (");
		js.appendClassReference(typeQualifiedName);
		js.append(")element;\n");
		js.popIndentation();
		js.append("}\n");
		
		js.append("else {\n");
		js.pushIndentation(null);
		js.append("result = ");
		js.appendClassReference(factoryName);
		js.append(".eINSTANCE.create" + asType.getName() + "();\n");
		//
		js.append("assert result != null;\n");
		//
		js.append("converter.installPivotDefinition(self, result);\n");
		js.popIndentation();
		js.append("}\n");
		
		for (CGContainmentPart part : object.getParts()) {
			part.accept(this);
		}
		// TODO any heuristic to include comment update ?
		js.append("// AS element comments update;\n");
		js.append("context.refreshComments(result, self);\n");
		return true;
	}

	public @NonNull Boolean visitCGContainmentPart(@NonNull CGContainmentPart object) {
		CGValuedElement cgInit = DomainUtil.nonNullState(object.getInit());
		EStructuralFeature eStructuralFeature = DomainUtil.nonNullModel(object.getEStructuralFeature());
		js.append("//\n");
		js.append("// " + eStructuralFeature.getEContainingClass().getName() + "::" + eStructuralFeature.getName() + "\n");
		js.append("//\n");
		if (!js.appendLocalStatements(cgInit)) {
			return false;
		}
		//
		String getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
		if (eStructuralFeature.isMany()) {
			js.append("context.refreshList(result.");
			js.append(getAccessor);
			js.append("(), ");
			js.appendValueName(cgInit);
			js.append(");\n");
		}
		else {
			String setAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
//	        if (name != null ? !name.equals(result.getName()) : (null != result.getName())) { -> It doesn't works with primitive types
//			if ((exists != result.isComposite()) && ((exists == null) || !exists.equals(result.isComposite())))
			js.append("if ((");
			js.appendValueName(cgInit);
			js.append(" != result.");
			js.append(getAccessor);
			js.append("()) && (");
			js.appendValueName(cgInit);
			js.append(" == null || !");
			js.appendValueName(cgInit);
			js.append(".equals(result.");
			js.append(getAccessor);
			js.append("()))) {\n");
			js.pushIndentation(null);
			js.append("result.");
			js.append(setAccessor);
			js.append("(");
			js.appendValueName(cgInit);
			js.append(");\n");
			js.popIndentation();
			js.append("}\n");
		}
		return true;
	}

	public @NonNull Boolean visitCGContainmentVisit(@NonNull CGContainmentVisit object) {
		JavaLocalContext localContext2 = globalContext.getLocalContext(object);
		if (localContext2 != null) {
			localContext = localContext2;
			try {
				CGValuedElement cgContainmentBody = DomainUtil.nonNullState(object.getBody());
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
				js.append("self");
				js.append(") {\n");
				js.pushIndentation(null);
				cgContainmentBody.accept(this);
				js.append("return null;\n");
				js.popIndentation();
				js.append("}\n");
			}
			finally {
				localContext = null;
			}
		}
		return true;
	}
}
