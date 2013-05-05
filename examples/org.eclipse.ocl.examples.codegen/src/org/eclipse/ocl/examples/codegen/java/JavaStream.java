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
package org.eclipse.ocl.examples.codegen.java;

import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CGUtils;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.xtext.util.Strings;

/**
 * A JavaStream provides many appendXXX helper methods and a push/pop facility for auto-indentation of Java text.
 */
public class JavaStream
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
	
	protected @NonNull JavaCodeGenerator codeGenerator;
	protected @NonNull CG2JavaVisitor cg2java;
	protected @NonNull CodeGenAnalyzer analyzer;
	protected final @NonNull Id2JavaExpressionVisitor id2JavaExpressionVisitor;

	private @NonNull StringBuilder s = new StringBuilder();
	private @NonNull Stack<String> indentationStack = new Stack<String>();
	private @NonNull String defaultIndentationString = "    ";
	
	public JavaStream(@NonNull JavaCodeGenerator codeGenerator, @NonNull CG2JavaVisitor cg2java) {
		this.codeGenerator = codeGenerator;
		this.cg2java = cg2java;
		this.analyzer = codeGenerator.getAnalyzer();
		this.id2JavaExpressionVisitor = cg2java.createId2JavaExpressionVisitor(this);
	}

	public void append(@Nullable String string) {
		if (string != null) {
			if (indentationStack.isEmpty()) {
				s.append(string);
			}
			else {
				int sLength = s.length();
				boolean atStartOfLine = (sLength == 0) || (s.charAt(sLength-1) == '\n');
				for (int i = 0; i < string.length(); i++) {
					char c = string.charAt(i);
					if (c == '\r') { /* ignore */ }
					else {
						if (atStartOfLine){
							atStartOfLine = false;
							s.append(indentationStack.peek());
						}
						s.append(c);
						atStartOfLine = c == '\n';
					}
				}
			}
		}
	}

	public void appendAssignment(@NonNull CGValuedElement toVariable, @NonNull CGValuedElement cgExpression) {
		if (cgExpression.isInvalid()) {
			cgExpression.accept(cg2java);
		}
		else {
			appendLocalStatements(cgExpression);
			appendValueName(toVariable);
			append(" = ");
			appendValueName(cgExpression);
			append(";\n");
		}
	}

	public void appendAtomicReferenceTo(@Nullable Class<?> requiredClass, @NonNull CGValuedElement cgVariable) {
		appendAtomicReferenceTo(requiredClass, cgVariable, true);
	}

	public void appendAtomicReferenceTo(@Nullable Class<?> requiredClass, @NonNull CGValuedElement cgElement, boolean reClass) {
		if (requiredClass != null) {
//			Class<?> actualClass = Object.class;
//			if (!cgVariable.getValue().isCaught()) {
//				actualClass = context.getUnboxedClass(cgVariable.getPivotTypeId());
//			}
			Class<?> actualClass = cg2java.getJavaClass(cgElement);
			if (!(requiredClass.isAssignableFrom(actualClass))) {
				append("((");
				appendClassReference(requiredClass, reClass);
				append(")");
				append(getValueName(cgElement));
				append(")");
				return;
			}
		}
		append(getValueName(cgElement));
	}

	public void appendCastParameters(@NonNull JavaLocalContext localContext) {
		for (@SuppressWarnings("null")@NonNull CGVariable castParameter : localContext.getCastParameters()) {
			castParameter.accept(cg2java);
		}
	}

	public void appendCastParameters(@NonNull JavaLocalContext localContext, @NonNull List<? extends CGParameter> cgParameters) {
		for (@SuppressWarnings("null")@NonNull CGParameter cgParameter : cgParameters) {
			CGParameter castParameter = localContext.basicGetCastParameter(cgParameter);
			if (castParameter != null) {
				castParameter.accept(cg2java);
			}
		}
	}

	public boolean appendClassCast(@NonNull Class<?> requiredClass, @NonNull Class<?> actualClass) {
		if (requiredClass.isAssignableFrom(actualClass)) {
			return false;
		}
		else {
			append("(");
			appendClassReference(requiredClass);
			append(")");
			return true;
		}	
	}

	public void appendClassReference(@Nullable Class<?> javaClass) {
		appendClassReference(javaClass, true);
	}

	public void appendClassReference(@Nullable Class<?> javaClass, boolean reClass) {
		if (javaClass != null) {
			if (reClass) {
				javaClass = cg2java.reClass(javaClass);
			}
			appendClassReference(javaClass.getName());
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
		else {
			appendClassReference(Object.class);
		}
	}

	public void appendClassReference(@Nullable Class<?> javaClass, @NonNull Class<?>... typeParameters) {
		if (javaClass != null) {
			appendClassReference(javaClass.getName());
			if (typeParameters.length > 0) {
				append("<");
				for (int i = 0; i < typeParameters.length; i++) {
					if (i != 0) {
						append(",");
					}
					appendClassReference(typeParameters[i]);
				}
				append(">");
			}
		}
		else {
			appendClassReference(Object.class);
		}
	}

	public void appendClassReference(@Nullable String className) {
		if (className != null) {
			int dollar = className.indexOf("$");
			if (dollar > 0) {
				@SuppressWarnings("null")@NonNull String importClassName = className.substring(0, dollar);
				append(ImportUtils.getAffixedName(importClassName));
				cg2java.addImport(importClassName);
				append(className.substring(dollar).replace('$',  '.'));
			}
			else {
				append(ImportUtils.getAffixedName(className));
				cg2java.addImport(className);
			}
		}
	}

	public void appendCommentWithOCL(@Nullable String title, @NonNull Element element) {
		append("/**\n");
		pushIndentation(" * ");
		if (title != null) {
			append(title + "\n");
		}
		PrettyPrintOptions.Global createOptions = createOptions(element);
		append(PrettyPrinter.print(element, createOptions) + "\n");
//		append("«IF expInOcl.messageExpression != null»«(expInOcl.messageExpression as StringLiteralExp).stringSymbol»«ENDIF»\n");
		popIndentation();
		append(" */\n");
	}

	public void appendCopyrightHeader() {
		append("/*\n");
		pushIndentation(" *");
		append(" «codeGenHelper.getCopyright(' * ')»\n");
		append("************************************************************************\n");
		append(" This code is 100% auto-generated\n");
		append(" using: " + getClass().getName() + "\n");
		append("\n");
		append(" Do not edit it.\n");
		append("/\n");
		popIndentation();
		append("\n");
	}

	public void appendDeclaration(@NonNull CGValuedElement cgElement) {
		appendDeclaration(cgElement, true);
	}

	public void appendDeclaration(@NonNull CGValuedElement cgElement, boolean reClass) {
		boolean isGlobal = cgElement.isGlobal();
		if (isGlobal) {
			append("public static ");
		}
		if (!cgElement.isSettable()) {
			append("final ");
		}
		appendIsRequired(cgElement.isNonNull() /*|| cgElement.isRequired()*/);
		append(" ");
		appendIsCaught(cgElement.isNonInvalid(), cgElement.isCaught());
		append(" ");
		Class<?> javaClass = cg2java.getJavaClass(cgElement);
		appendClassReference(javaClass, reClass);
		append(" ");
		String valueName = cg2java.getValueName2(cgElement);
		append(valueName);
	}

	public void appendFalse() {
		appendClassReference(ValuesUtil.class);
		append(".FALSE_VALUE");
	}

	public void appendIdReference(@NonNull ElementId elementId) {
		if (CGUtils.isInlineableId(elementId)) {
			elementId.accept(id2JavaExpressionVisitor);
		}
		else {
			appendValueName(analyzer.getElementId(elementId));
		}
	}

	public void appendIdReference2(@NonNull ElementId elementId) {
		elementId.accept(id2JavaExpressionVisitor);
	}

	public void appendIsCaught(boolean isNonInvalid, boolean isCaught) {
		append("/*");
		append(isNonInvalid ? "@NonInvalid" : isCaught ? "@Caught" : "@Thrown");
		append("*/");
	}

	public void appendIsRequired(boolean isRequired) {
		boolean useNullAnnotations = codeGenerator.getOptions().useNullAnnotations();
		if (!useNullAnnotations) {
			append("/*");
		}
		append("@");
		appendClassReference(isRequired ? AbstractCodeGenerator.ORG_ECLIPSE_JDT_ANNOTATION_NON_NULL
			: AbstractCodeGenerator.ORG_ECLIPSE_JDT_ANNOTATION_NULLABLE);
		if (!useNullAnnotations) {
			append("*/");
		}
	}

	/**
	 * Append the complete statements for cgElement for use with in a local operation context.
	 * Inline and global contributions are excluded.
	 */
	public void appendLocalStatements(@NonNull CGValuedElement cgElement) {
		if (!cgElement.isInlineable() && !cgElement.isConstant() && !cgElement.isGlobal()) {			// Exclude global constants and inline constants
			cgElement.accept(cg2java);
		}
	}

	public void appendQualifiedLiteralName(@NonNull Operation anOperation) {
		Type type = anOperation.getOwningType();
		if (type != null) {
			GenPackage genPackage = codeGenerator.getGenModelHelper().getGenPackage(type);
			if (genPackage != null) {
				String qualifiedPackageName = genPackage.getQualifiedPackageName() + AbstractGenModelHelper.TABLES_PACKAGE_NAME;
				String tablesClassName = genPackage.getPrefix() + AbstractGenModelHelper.TABLES_CLASS_SUFFIX;
				appendClassReference(qualifiedPackageName + "." + tablesClassName);
				append(".Operations._" + type.getName() + "__" + AbstractGenModelHelper.encodeName(anOperation));
			}
		}
	}

	public void appendReferenceTo(@Nullable Class<?> requiredClass, @NonNull CGValuedElement cgValue) {
		appendReferenceTo(requiredClass, cgValue, true);
	}

	public void appendReferenceTo(@Nullable Class<?> requiredClass, @NonNull CGValuedElement cgValue, boolean reClass) {
		if (requiredClass != null) {
			CGValuedElement value = cgValue.getValue();
//			Class<?> actualClass = value.isCaught() ? Object.class : context.getUnboxedClass(value.getPivotTypeId());
			Class<?> actualClass = cg2java.getJavaClass(value);
			if ((value instanceof CGParameter) || !(requiredClass.isAssignableFrom(actualClass))) {		// FIXME true typeId for Parameters
				append("(");
				appendClassReference(requiredClass, reClass);
				append(")");
			}
		}
		append(getValueName(cgValue));
	}

	public void appendString(@NonNull String string) {
		@SuppressWarnings("null")@NonNull String javaString = Strings.convertToJavaString(string);
		append("\"");
		append(javaString);
		append("\"");
	}

	public void appendTrue() {
		appendClassReference(ValuesUtil.class);
		append(".TRUE_VALUE");
	}

	/**
	 * Append the code name for the value of cgElement, lazily creating one if necessary.
	 */
	public void appendValueName(@Nullable CGValuedElement cgElement) {
		if (cgElement == null) {
			append("<<null-appendValueName>>");
		}
		else if (cgElement.isInlineable()) {
			CGValuedElement cgValue = cgElement;
			for (CGValuedElement cgNext; (cgNext = cgValue.getReferredValuedElement()) != cgValue; cgValue = cgNext) {}
			cgValue.accept(cg2java);
		}
		else {
			if (cgElement.isGlobal()) {
				cg2java.appendGlobalPrefix();
			}
			String valueName = cg2java.getValueName2(cgElement);
			append(valueName);
		}
	}

	public @NonNull CodeGenerator getCodeGenerator() {
		return codeGenerator;
	}

	protected @NonNull String getValueName(@NonNull CGValuedElement cgElement) {
		String name = cgElement.getValueName();
		if (name == null) {
			name = cgElement.getName();
		}
		if (name == null) {
			name = "<null-" + cgElement.eClass().getName() + ">";
		}
		return name;
	}

	public void popIndentation() {
		indentationStack.pop();
	}

	public void pushIndentation(@Nullable String extraIndentation) {
		if (extraIndentation == null) {
			extraIndentation = defaultIndentationString;
		}
		if (indentationStack.isEmpty()) {
			indentationStack.push(extraIndentation);
		}
		else {
			indentationStack.push(indentationStack.peek() + extraIndentation);
		}
	}

	public void resetStream() {
		s.setLength(0);
	}
	
	@Override
	public @NonNull String toString() {
		@SuppressWarnings("null")@NonNull String string = s.toString();
		return string;
	}
}
