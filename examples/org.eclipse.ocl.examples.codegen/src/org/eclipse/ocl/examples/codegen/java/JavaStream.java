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
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.CodeGenOptions;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
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
	
	public static interface SubStream
	{
		void append();
	}
	
	protected @NonNull JavaCodeGenerator codeGenerator;
	protected @NonNull CG2JavaVisitor cg2java;
	protected @NonNull CodeGenAnalyzer analyzer;
	protected final @NonNull Id2JavaExpressionVisitor id2JavaExpressionVisitor;
	protected final boolean useNullAnnotations;
	protected final boolean suppressNullWarnings;

	private @NonNull StringBuilder s = new StringBuilder();
	private @NonNull Stack<String> indentationStack = new Stack<String>();
	private @NonNull String defaultIndentationString = "    ";
	
	public JavaStream(@NonNull JavaCodeGenerator codeGenerator, @NonNull CG2JavaVisitor cg2java) {
		this.codeGenerator = codeGenerator;
		this.cg2java = cg2java;
		this.analyzer = codeGenerator.getAnalyzer();
		this.id2JavaExpressionVisitor = cg2java.createId2JavaExpressionVisitor(this);
		CodeGenOptions options = codeGenerator.getOptions();
		this.useNullAnnotations = options.useNullAnnotations();
		this.suppressNullWarnings = useNullAnnotations && options.suppressNonNullWarningsForEMFCollections();
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

	public boolean appendAssignment(@NonNull CGValuedElement toVariable, @NonNull CGValuedElement cgExpression) {
		CGInvalid cgInvalidValue = cgExpression.getInvalidValue();
		if (cgInvalidValue != null) {
			append("throw ");
//			append("(");
//			appendClassReference(InvalidValueException.class);
//			append(")");
			appendValueName(cgInvalidValue);
			append(";\n");
			return false;
		}
		else {
			TypeDescriptor typeDescriptor = codeGenerator.getTypeDescriptor(toVariable);
			if (!appendLocalStatements(cgExpression)) {
				return false;
			}
			appendValueName(toVariable);
			append(" = ");
			appendReferenceTo(typeDescriptor, cgExpression);
			append(";\n");
		}
		return true;
	}

	public void appendAtomicReferenceTo(@NonNull Class<?> requiredClass, @Nullable CGValuedElement cgValue) {
		if (cgValue == null) {
			append("<<null-appendAtomicReferenceTo>>");
		}
		else {
			TypeDescriptor actualTypeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
			Class<?> actualClass = actualTypeDescriptor.getJavaClass();
			if (cgValue.getNamedValue().isCaught() || !requiredClass.isAssignableFrom(actualClass)) {
				append("((");
				appendClassReference(requiredClass.getName());
				append(")");
				appendValueName(cgValue);
				append(")");
			}
			else {
				appendValueName(cgValue);
			}
		}
	}

	public void appendAtomicReferenceTo(@NonNull TypeDescriptor requiredTypeDescriptor, @Nullable CGValuedElement cgValue) {
		if (cgValue == null) {
			append("<<null-appendAtomicReferenceTo>>");
		}
		else {
			TypeDescriptor actualTypeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
			if (cgValue.getNamedValue().isCaught() || !requiredTypeDescriptor.isAssignableFrom(actualTypeDescriptor)) {
				append("(");
				requiredTypeDescriptor.appendCast(this, null, null);
				appendValueName(cgValue);
				append(")");
			}
			else {
				appendValueName(cgValue);
			}
		}
	}

	public void appendAtomicReferenceTo(@Nullable CGValuedElement cgValue) {
		if (cgValue == null) {
			append("<<null-appendAtomicReferenceTo>>");
		}
		else {
			TypeDescriptor actualTypeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
			if (cgValue.getNamedValue().isCaught()) {
				append("(");
				actualTypeDescriptor.appendCast(this, null, null);
				appendValueName(cgValue);
				append(")");
			}
			else {
				appendValueName(cgValue);
			}
		}
	}

	public void appendBooleanString(boolean isTrue) {
		append(isTrue ? "true" : "false");
	}

	public void appendBooleanValueName(@NonNull CGValuedElement cgValue, boolean isTrue) {
		@NonNull TypeDescriptor typeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
		if (cgValue.isCaught() || cgValue.getNamedValue().isCaught() || (typeDescriptor.getJavaClass() == Object.class)) {
			appendValueName(cgValue);
			append(" == ");
			append(isTrue ? "Boolean.TRUE" : "Boolean.FALSE");
		}
		else {
			if (!isTrue) {
				append("!");
			}
			appendValueName(cgValue);
		}
	}

	public void appendClassCast(@Nullable CGValuedElement cgValue) {
		if (cgValue == null) {
			append("<<null-appendClassCast>>");
		}
		else {
			@NonNull TypeDescriptor typeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
			typeDescriptor.appendCast(this, null, null);
		}
	}

	public void appendClassCast(@Nullable CGValuedElement cgValue, @Nullable Class<?> actualJavaClass) {
		if (cgValue == null) {
			append("<<null-appendClassCast>>");
		}
		else {
			@NonNull TypeDescriptor typeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
			Class<?> requiredJavaClass = typeDescriptor.getJavaClass();
			if ((actualJavaClass == null) || !requiredJavaClass.isAssignableFrom(actualJavaClass)) {
				typeDescriptor.appendCast(this, null, null);
			}
		}
	}

	public void appendClassCast(@NonNull CGValuedElement cgValue, @Nullable Class<?> actualJavaClass, @NonNull SubStream subStream) {
		@NonNull TypeDescriptor typeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
		Class<?> requiredJavaClass = typeDescriptor.getJavaClass();
		if ((actualJavaClass == null) || !requiredJavaClass.isAssignableFrom(actualJavaClass)) {
			typeDescriptor.appendCast(this, actualJavaClass, subStream);
		}
		else {
			subStream.append();
		}
	}

	public void appendClassReference(@Nullable CGValuedElement cgValue) {
		if (cgValue == null) {
			append("<<null->>");
		}
		else if (cgValue.getNamedValue().isCaught()) {
			appendClassReference(Object.class);
		}
		else {
			TypeDescriptor typeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
			typeDescriptor.append(this);
		}
	}

	public void appendClassReference(@Nullable Class<?> javaClass) {
		if (javaClass != null) {
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

	public void appendClassReference(@NonNull TypeDescriptor typeDescriptor) {
		typeDescriptor.append(this);
	}

	public void appendClassReference(@Nullable Class<?> javaClass, @NonNull Class<?>... typeParameters) {
		if (javaClass != null) {
			appendClassReference(javaClass.getName());
			appendTypeParameters(false, typeParameters);
		}
		else {
			appendClassReference(Object.class);
		}
	}

	public void appendClassReference(@Nullable Class<?> javaClass, boolean useExtends, @NonNull Class<?>... typeParameters) {
		if (javaClass != null) {
			appendClassReference(javaClass.getName());
			appendTypeParameters(useExtends, typeParameters);
		}
		else {
			appendClassReference(Object.class);
		}
	}

	public void appendClassReference(@Nullable Class<?> javaClass, boolean useExtends, @NonNull String... typeParameters) {
		if (javaClass != null) {
			appendClassReference(javaClass.getName());
			appendTypeParameters(useExtends, typeParameters);
		}
		else {
			appendClassReference(Object.class);
		}
	}

/*	public void appendClassReference(@Nullable String className, boolean useExtends, @NonNull Class<?>... typeParameters) {
		if (className != null) {
			appendClassReference(className);
			appendTypeParameters(useExtends, typeParameters);
		}
		else {
			appendClassReference(Object.class);
		}
	} */

	@Deprecated
	public void appendClassReference(Class<?> javaClass, @NonNull TypeDescriptor... typeDescriptors) {
		appendClassReference(javaClass, true, typeDescriptors);
	}
		
	public void appendClassReference(Class<?> javaClass, boolean useExtends, @NonNull TypeDescriptor... typeDescriptors) {
		if (javaClass != null) {
			appendClassReference(javaClass.getName());
			if (typeDescriptors.length > 0) {
				append("<");
				for (int i = 0; i < typeDescriptors.length; i++) {
					if (i != 0) {
						append(",");
					}
					if (useExtends) {
						append("? extends ");
					}
					@SuppressWarnings("null")@NonNull TypeDescriptor typeDescriptor = typeDescriptors[i];
					typeDescriptor.append(this);
//					Class<?> javaClass2 = typeDescriptor.getJavaClass();
//					if ((javaClass2 != null) && (javaClass2 != Object.class)) {
//						appendClassReference(javaClass2, new Class<?>[]{});
//					}
//					else {
//						appendClassReference(typeDescriptor.getClassName());
//					}
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
			else if (className.contains(".")){
				append(ImportUtils.getAffixedName(className));
				cg2java.addImport(className);
			}
			else {
				append(className);
			}
		}
	}

	public void appendClassReference(@NonNull CGClass cgClass) {
		CGPackage cgPackage = cgClass.getContainingPackage();
		String packageName = cgPackage.getName();
		if (packageName != null) {
			appendClassReference(packageName + "." + cgClass.getName());
			List<CGClass> cgTemplateParameters = cgClass.getTemplateParameters();
			if (cgTemplateParameters.size() > 0) {
				append("<");
				boolean isFirst = true;
				for (CGClass cgTemplateParameter : cgTemplateParameters) {
					if (!isFirst) {
						append(", ");
					}
					if (cgTemplateParameter != null) {
						appendClassReference(cgTemplateParameter);
					}
					else {
						append("?");
					}
					isFirst = false;
				}
				append(">");
			}
		}
		else {
			append(cgClass.getName());		// the ? wildcard
		}
	}

	public void appendCommentWithOCL(@Nullable String title, @Nullable Element element) {
		append("/**\n");
		pushIndentation(" * ");
		if (title != null) {
			append(title + "\n");
		}
		if (element != null) {
			PrettyPrintOptions.Global createOptions = createOptions(element);
			append(PrettyPrinter.print(element, createOptions).replace("*/",  "* /") + "\n");
//			append("«IF expInOcl.messageExpression != null»«(expInOcl.messageExpression as StringLiteralExp).stringSymbol»«ENDIF»\n");
		}
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
		boolean is_boolean = is_boolean(cgElement);
		boolean isGlobal = cgElement.isGlobal();
		if (isGlobal) {
			append("public static ");
		}
		if (!cgElement.isSettable()) {
			append("final ");
		}
		if (!is_boolean && !cgElement.isAssertedNonNull()) {
			appendIsRequired(cgElement.isNonNull() && !(cgElement instanceof CGUnboxExp)/*|| cgElement.isRequired()*/);	// FIXME Ugh!
			append(" ");
		}
		appendIsCaught(cgElement.isNonInvalid(), cgElement.isCaught());
		append(" ");
		if (is_boolean) {
			append(boolean.class.getSimpleName());
		}
		else {
			appendClassReference(cgElement);
		}
		append(" ");
		String valueName = cg2java.getValueName(cgElement);
		append(valueName);
	}

	/**
	 * Append the value of cgValue, ensuring that it has the returnClassname type.
	 */
	public void appendEcoreValue(@NonNull String returnClassName, @NonNull CGValuedElement cgValue) {
		TypeDescriptor javaTypeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
		Class<?> javaClass = javaTypeDescriptor.hasJavaClass();
		if (cgValue.getNamedValue() instanceof CGParameter) {
			appendValueName(cgValue);
		}
		else if (javaClass == null) {
			append("(");
			appendClassReference(returnClassName);
			append(")");
			appendValueName(cgValue);
		}
		else if (!returnClassName.equals(javaClass.getName())) {
			if (javaClass == Boolean.class) {
				appendValueName(cgValue);
//				if ("boolean".equals(returnClassName) || "java.lang.Boolean".equals(returnClassName)) {
//					append(".booleanValue()");
//				}
			}
			else if (javaClass == Number.class) {						// Real or Integer or UnlimitedNatural (source isn't a Character but target may be)
				if ("java.math.BigDecimal".equals(returnClassName)) {
					appendClassReference(ValuesUtil.class);
					append(".bigDecimalValueOf(");
					appendValueName(cgValue);
					append(")");
				}
				else if ("java.math.BigInteger".equals(returnClassName)) {
					appendClassReference(ValuesUtil.class);
					append(".bigIntegerValueOf(");
					appendValueName(cgValue);
					append(")");
				}
				else if ("char".equals(returnClassName)) {
					append("(char)");
					appendAtomicReferenceTo(cgValue);
					append(".intValue()");
				}
				else if ("java.lang.Character".equals(returnClassName)) {
					appendClassReference(Character.class);
					append(".valueOf((char)");
					appendAtomicReferenceTo(cgValue);
					append(".intValue())");
				}
				else {
					if ("java.lang.Double".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".doubleValue()");
					}
					else if ("java.lang.Float".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".floatValue()");
					}
					else if ("java.lang.Integer".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".intValue()");
					}
					else if ("java.lang.Long".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".longValue()");
					}
					else if ("java.lang.Short".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".shortValue()");
					}
					else if ("double".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".doubleValue()");
					}
					else if ("float".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".floatValue()");
					}
					else if ("int".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".intValue()");
					}
					else if ("long".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".longValue()");
					}
					else if ("short".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".shortValue()");
					}
					else {
						appendValueName(cgValue);
					}
				}
			}
			else if (javaClass == Object.class) {						// Integer or UnlimitedNatural (source isn't a Real)
				if ("java.math.BigInteger".equals(returnClassName)) {
					appendClassReference(ValuesUtil.class);
					append(".bigIntegerValueOf(");
					appendValueName(cgValue);
					append(")");
				}
				else if ("char".equals(returnClassName) || "java.lang.Character".equals(returnClassName)) {
					appendClassReference(ValuesUtil.class);
					append(".characterValueOf(");
					appendValueName(cgValue);
					append(")");
				}
				else {
					if ("java.lang.Integer".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".intValue()");
					}
					else if ("java.lang.Long".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".longValue()");
					}
					else if ("java.lang.Short".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".shortValue()");
					}
					else if ("int".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".intValue()");
					}
					else if ("long".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".longValue()");
					}
					else if ("short".equals(returnClassName)) {
						appendAtomicReferenceTo(Number.class, cgValue);
						append(".shortValue()");
					}
					else {
						appendValueName(cgValue);
					}
				}
			}
			else {
				append("(");
				appendClassReference(returnClassName);
				append(")");
				appendValueName(cgValue);
			}
		}
		else {
			appendValueName(cgValue);
		}
	}

	public void appendFalse() {
		appendClassReference(ValuesUtil.class);
		append(".FALSE_VALUE");
	}

	public void appendIdReference(@Nullable ElementId elementId) {
		if (elementId == null) {
			append("<<null-appendIdReference>>");
		}
		else if (CGUtils.isInlinedId(elementId)) {
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
		if (!useNullAnnotations) {
			append("/*");
			append(isRequired ? "@NonNull" : "@Nullable");
			append("*/");
		}
		else {
			append("@");
			appendClassReference(isRequired ? AbstractCodeGenerator.ORG_ECLIPSE_JDT_ANNOTATION_NON_NULL
				: AbstractCodeGenerator.ORG_ECLIPSE_JDT_ANNOTATION_NULLABLE);
		}
	}

	/**
	 * Append the complete statements for cgElement for use with in a local operation context.
	 * Inline and global contributions are excluded.
	 */
	public boolean appendLocalStatements(@NonNull CGValuedElement cgElement) {
//		if (!cgElement.isInlineable() && !cgElement.isConstant() && !cgElement.isGlobal()) {			// Exclude global constants and inline constants
		if (!cgElement.isInlined()			// Exclude inline constants
		 && !cgElement.isGlobal()) {			// Exclude global constant expressions
			return cgElement.accept(cg2java) == Boolean.TRUE;
		}
		return true;
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

	public void appendReferenceTo(@NonNull Class<?> requiredClass, @Nullable CGValuedElement cgValue) {
		if (cgValue == null) {
			append("<<null-appendReferenceTo>>");
		}
		else {
			TypeDescriptor actualTypeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
			if (cgValue.getNamedValue().isCaught() || !actualTypeDescriptor.isAssignableTo(requiredClass)) {
				append("(");
				appendClassReference(requiredClass.getName());
				append(")");
			}
			appendValueName(cgValue);
		}
	}

	public void appendReferenceTo(@NonNull TypeDescriptor requiredTypeDescriptor, @Nullable CGValuedElement cgValue) {
		if (cgValue == null) {
			append("<<null-appendReferenceTo>>");
		}
		else {
			TypeDescriptor actualTypeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
			if (!cgValue.isNull() && (cgValue.getNamedValue().isCaught() || !requiredTypeDescriptor.isAssignableFrom(actualTypeDescriptor))) {
				requiredTypeDescriptor.appendCast(this, null, null);
			}
			appendValueName(cgValue);
		}
	}

	public void appendReferenceTo(@Nullable CGValuedElement cgValue) {
		if (cgValue == null) {
			append("<<null-appendReferenceTo>>");
		}
		else {
			if (cgValue.getNamedValue().isCaught()) {
				TypeDescriptor actualTypeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
				append("(");
				actualTypeDescriptor.append(this);
				append(")");
			}
			appendValueName(cgValue);
		}
	}

	public void appendString(@NonNull String string) {
		@SuppressWarnings("null")@NonNull String javaString = Strings.convertToJavaString(string);
		append("\"");
		append(javaString);
		append("\"");
	}

	public boolean appendThrowBooleanInvalidValueException(/*@NonNull*/ String message, @NonNull String... arguments) {
		appendClassReference(ValuesUtil.class);
		append(".throwBooleanInvalidValueException(");
		appendString(DomainUtil.nonNullState(message));
		for (String argument : arguments) {
			append(", ");
			appendString(DomainUtil.nonNullState(argument));
		}
		append(");\n");
		return false;
	}

	public boolean appendThrowInvalidValueException(/*@NonNull*/ String message, @NonNull String... arguments) {
		append("throw new ");
		appendClassReference(InvalidValueException.class);
		append("(");
		appendString(DomainUtil.nonNullState(message));
		for (String argument : arguments) {
			append(", ");
			appendString(DomainUtil.nonNullState(argument));
		}
		append(");\n");
		return false;
	}

	public void appendTrue() {
		appendClassReference(ValuesUtil.class);
		append(".TRUE_VALUE");
	}

	public void appendTypeParameters(boolean useExtends, @NonNull Class<?>... typeParameters) {
		if (typeParameters.length > 0) {
			append("<");
			for (int i = 0; i < typeParameters.length; i++) {
				if (i != 0) {
					append(",");
				}
				if (useExtends) {
					append("? extends ");
				}
				appendClassReference(typeParameters[i]);
			}
			append(">");
		}
	}

	public void appendTypeParameters(boolean useExtends, @NonNull String... typeParameters) {
		if (typeParameters.length > 0) {
			append("<");
			for (int i = 0; i < typeParameters.length; i++) {
				if (i != 0) {
					append(",");
				}
				if (useExtends) {
					append("? extends ");
				}
				appendClassReference(typeParameters[i]);
			}
			append(">");
		}
	}

	/**
	 * Append the code name for the value of cgElement, lazily creating one if necessary.
	 */
	public void appendValueName(@Nullable CGValuedElement cgElement) {
		if (cgElement == null) {
			append("<<null-appendValueName>>");
		}
		else if (cgElement.isInlined()) {
			cgElement.accept(cg2java);
		}
//		else if (cgElement.isInlined() && (cgElement.isInvalid() || cgElement.isNull() || cgElement.isTrue() || cgElement.isFalse() || !cgElement.isGlobal())) {	// FIXME
//			CGValuedElement cgValue = cgElement;
//			for (CGValuedElement cgNext; (cgNext = cgValue.getReferredValuedElement()) != cgValue; cgValue = cgNext) {}
//			cgValue.accept(cg2java);
//		}
		else {
			if (cgElement.isGlobal()) {
				cg2java.appendGlobalPrefix();
			}
			String valueName = cg2java.getValueName(cgElement);
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

	public boolean is_boolean(@NonNull CGValuedElement cgValue) {
		if (cgValue.getNamedValue().isCaught()) {
			return false;
		}
		else {
			TypeDescriptor typeDescriptor = codeGenerator.getTypeDescriptor(cgValue);
			Class<?> javaClass = typeDescriptor.getJavaClass();
			return (javaClass == boolean.class) || ((javaClass == Boolean.class) && cgValue.isNonNull());
		}
	}
	
	public boolean isUseNullAnnotations() {
		return useNullAnnotations;
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
