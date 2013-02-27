/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
package org.eclipse.ocl.examples.codegen.generator.java;

import java.lang.reflect.TypeVariable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.xtext.util.Strings;

public class JavaText extends AbstractCodeGenText
{ 
	public static @NonNull PrettyPrintOptions.Global createOptions(@NonNull Visitable element) {
		Namespace scope = null;
		if (element instanceof EObject) {
			for (EObject eObject = (EObject) element; eObject != null; ) {
				if (eObject instanceof Root) {
					break;
				}
				if (eObject instanceof Type) {
					scope = (Namespace) eObject;
					break;
				}
				if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
					scope = (Namespace) eObject;
					break;
				}
				if ((eObject instanceof ExpressionInOCL) && (((ExpressionInOCL)eObject).getContextVariable() != null)) {
					eObject = ((ExpressionInOCL)eObject).getContextVariable().getType();
				}
				else {
					eObject = eObject.eContainer();
				}
			}
		}
		PrettyPrintOptions.Global createOptions = PrettyPrinter.createOptions(scope);
		createOptions.setLinelength(80);
		if (element instanceof EObject) {
			Resource resource = EcoreUtil.getRootContainer((EObject)element).eResource();
			if (resource != null) {
				ResourceSet resourceSet = resource.getResourceSet();
				if (resourceSet != null) {
					MetaModelManager metaModelManager = MetaModelManager.getAdapter(resourceSet);
					createOptions.setMetaModelManager(metaModelManager);
				}
			}
		}
		return createOptions;
	}
	
	public JavaText(@NonNull CodeGenSnippet snippet, @NonNull String indentation) {
		super(snippet, indentation);
	}

	public void appendClassReference(@NonNull Class<?> javaClass) {
		if (JavaCodeGenerator.javaPrimitiveClasses.containsKey(javaClass)) {
			@SuppressWarnings("null")@NonNull String name = javaClass.getName();
			append(name);
		}
		else {
			append(snippet.getImportedName(javaClass));
		}
		TypeVariable<?>[] typeParameters = javaClass.getTypeParameters();
		if (typeParameters.length > 0) {
			append("<");
			for (int i = 0; i < typeParameters.length; i++) {
				if (i != 0) {
					append(",");
				}
				append("?");
			}
			append(">");
		}
	}

	public void appendClassReference(@NonNull String javaClass) {
		append(snippet.getImportedName(javaClass));
	}

	public void appendCommentWithOCL(@Nullable String title, @NonNull Element element) {
		String combinedIndentation = indentation + " * ";
		append("/**\n");
		if (title != null) {
			appendWithIndentation(title + "\n", combinedIndentation);
		}
		PrettyPrintOptions.Global createOptions = createOptions(element);
		appendWithIndentation(PrettyPrinter.print(element, createOptions) + "\n", combinedIndentation);
		append(" */\n");
	}
	
	public void appendDeclaration(@NonNull CodeGenSnippet declaredSnippet) {
		if (declaredSnippet.isGlobal()) {
			append("public static ");
		}
		if (declaredSnippet.isFinal()) {
			append("final ");
		}
		Class<?> javaClass = declaredSnippet.getJavaClass();
		if (!JavaCodeGenerator.javaPrimitiveClasses.containsKey(javaClass)) {
			if (declaredSnippet.isNonNull()) {
				append(snippet.atNonNull(declaredSnippet.isSuppressNonNullWarnings()));
			}
			else {
				append(snippet.atNullable());
			}
			append(" ");
			if (declaredSnippet.isCaught()) {
				append("/*@Caught*/");
			}
			else if (declaredSnippet.isThrown()) {
				append("/*@Thrown*/");
			}
			else {
				append("/*@NonInvalid*/");
			}
			append(" ");
		}
		appendClassReference(javaClass);
		append(" ");
		append(declaredSnippet.getName());
	}

	public void appendString(@NonNull String string) {
		@SuppressWarnings("null")@NonNull String javaString = Strings.convertToJavaString(string);
		append("\"");
		append(javaString);
		append("\"");
	}
	
	public void close() {
		append(";\n");
	}
}