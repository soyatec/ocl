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

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CGUtils;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoolean;
import org.eclipse.ocl.examples.codegen.cgmodel.CGBoxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCatchExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstantExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeConstructorExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElementId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorCompositionProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorConstructorPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorNavigationProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositeProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIfExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInfinity;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInteger;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsInvalidExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIsUndefinedExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterateCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLibraryPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGReal;
import org.eclipse.ocl.examples.codegen.cgmodel.CGString;
import org.eclipse.ocl.examples.codegen.cgmodel.CGText;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGThrowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTupleExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTuplePartCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGWhileExp;
import org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractExtendingCGModelVisitor;
import org.eclipse.ocl.examples.codegen.generator.AbstractCodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibrarySimpleOperation;
import org.eclipse.ocl.examples.domain.library.LibraryUntypedOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorDoubleIterationManager;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.xtext.util.Strings;

/**
 * A CG2JavaVisitor serializes the contributions of a tree of model elements in a StringBuilder whose result may be
 * obtained by toString() on completion.
 * 
 * The internal protected API has many appendXXX helper methods and a push/pop[ facility for auto-indentation.
 * 
 * The individual visits contribute a complete construct, usually one or more statements to the output. However
 * inlineable expressions contribute just their expression value.
 */
public abstract class CG2JavaVisitor extends AbstractExtendingCGModelVisitor<Object, JavaCodeGenerator>
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

	protected final @NonNull JavaGlobalContext globalContext;
//	protected final @NonNull NameManager nameManager;
	protected final @NonNull GenModelHelper genModelHelper;
	protected final @NonNull CodeGenAnalyzer analyzer;
	protected final @NonNull Id2JavaInterfaceVisitor id2JavaInterfaceVisitor;
	protected final @NonNull Id2JavaExpressionVisitor id2JavaExpressionVisitor;
	
	/**
	 * The local Java context for the current operation.
	 */
	protected JavaLocalContext localContext;

	private @NonNull StringBuilder s = new StringBuilder();
	private @NonNull Stack<String> indentationStack = new Stack<String>();
	private @NonNull String defaultIndentationString = "    ";
	
	public CG2JavaVisitor(@NonNull JavaCodeGenerator codeGenerator) {
		super(codeGenerator);
		this.globalContext = codeGenerator.getGlobalContext();
//		nameManager = context.getNameManager();
		this.genModelHelper = context.getGenModelHelper();
		this.analyzer = context.getAnalyzer();
		this.id2JavaInterfaceVisitor = createId2JavaClassVisitor();
		this.id2JavaExpressionVisitor = createId2JavaExpressionVisitor();
	}

	protected void append(@Nullable String string) {
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

	protected void appendAssignment(@NonNull CGValuedElement toVariable, @NonNull CGValuedElement cgExpression) {
		if (cgExpression.isInvalid()) {
			cgExpression.accept(this);
		}
		else {
			appendLocalStatements(cgExpression);
			appendValueName(toVariable);
			append(" = ");
			appendValueName(cgExpression);
			append(";\n");
		}
	}

	protected void appendAtomicReferenceTo(@Nullable Class<?> requiredClass, @NonNull CGValuedElement cgVariable) {
		appendAtomicReferenceTo(requiredClass, cgVariable, true);
	}

	protected void appendAtomicReferenceTo(@Nullable Class<?> requiredClass, @NonNull CGValuedElement cgElement, boolean reClass) {
		if (requiredClass != null) {
//			Class<?> actualClass = Object.class;
//			if (!cgVariable.getValue().isCaught()) {
//				actualClass = context.getUnboxedClass(cgVariable.getPivotTypeId());
//			}
			Class<?> actualClass = getJavaClass(cgElement);
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

	protected void appendCastParameters(@NonNull JavaLocalContext localContext) {
		for (@SuppressWarnings("null")@NonNull CGVariable castParameter : localContext.getCastParameters()) {
			castParameter.accept(this);
		}
	}

	protected void appendCastParameters(@NonNull JavaLocalContext localContext, @NonNull List<? extends CGParameter> cgParameters) {
		for (@SuppressWarnings("null")@NonNull CGParameter cgParameter : cgParameters) {
			CGParameter castParameter = localContext.basicGetCastParameter(cgParameter);
			if (castParameter != null) {
				castParameter.accept(this);
			}
		}
	}

	protected boolean appendClassCast(@NonNull Class<?> requiredClass, @NonNull Class<?> actualClass) {
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

	protected void appendClassReference(@Nullable Class<?> javaClass) {
		appendClassReference(javaClass, true);
	}

	protected void appendClassReference(@Nullable Class<?> javaClass, boolean reClass) {
		if (javaClass != null) {
			if (reClass) {
				javaClass = reClass(javaClass);
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

	protected void appendClassReference(@Nullable Class<?> javaClass, @NonNull Class<?>... typeParameters) {
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

	protected void appendClassReference(@Nullable String className) {
		if (className != null) {
			append(ImportUtils.getAffixedName(className));
			globalContext.addImport(className);
		}
	}

	protected void appendCommentWithOCL(@Nullable String title, @NonNull Element element) {
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

	protected void appendCopyrightHeader() {
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

/*	protected void appendDeclaration(@NonNull CGValue cgElement) {
		if (cgElement.isConstant()) {
			append("public static final ");
		}
		else {
			append("final ");
		}
		if (cgElement.isNull()) {
			append("/*@Null* /");
		}
		else {
			appendIsRequired(true);
		}
		append(" ");
		appendIsCaught(!cgElement.isInvalid(), cgElement.isInvalid());
		append(" ");
		CGTypeId cgType = cgElement.getTypeId();
		ElementId elementId = cgType.getElementId();
		Class<?> boxedClass = cgElement.isBoxed() ? context.getBoxedClass(elementId) : context.getUnboxedClass(elementId);
		appendClassReference(boxedClass);
		append(" ");
		appendValueName(cgElement);//.getValue());
	} */

	protected void appendDeclaration(@NonNull CGValuedElement cgElement) {
		appendDeclaration(cgElement, true);
	}

	protected void appendDeclaration(@NonNull CGValuedElement cgElement, boolean reClass) {
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
		Class<?> javaClass = getJavaClass(cgElement);
		appendClassReference(javaClass, reClass);
		append(" ");
		String valueName = localContext != null ? localContext.getValueName(cgElement) : globalContext.getValueName(cgElement);
		append(valueName);
	}

	protected void appendFalse() {
		appendClassReference(ValuesUtil.class);
		append(".FALSE_VALUE");
	}

	protected void appendGlobalPrefix() {}

	public void appendIdReference(@NonNull ElementId elementId) {
		if (CGUtils.isInlineableId(elementId)) {
			elementId.accept(id2JavaExpressionVisitor);
		}
		else {
			appendValueName(analyzer.getElementId(elementId));
		}
	}

	protected void appendIsCaught(boolean isNonInvalid, boolean isCaught) {
		append("/*");
		append(isNonInvalid ? "@NonInvalid" : isCaught ? "@Caught" : "@Thrown");
		append("*/");
	}

	protected void appendIsRequired(boolean isRequired) {
		boolean useNullAnnotations = context.getOptions().useNullAnnotations();
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
	protected void appendLocalStatements(@NonNull CGValuedElement cgElement) {
		if (!cgElement.isInlineable() && !cgElement.isConstant() && !cgElement.isGlobal()) {			// Exclude global constants and inline constants
			cgElement.accept(this);
		}
	}

	protected void appendQualifiedLiteralName(@NonNull Operation anOperation) {
		Type type = anOperation.getOwningType();
		if (type != null) {
			GenPackage genPackage = genModelHelper.getGenPackage(type);
			if (genPackage != null) {
				String qualifiedPackageName = genPackage.getQualifiedPackageName() + AbstractGenModelHelper.TABLES_PACKAGE_NAME;
				String tablesClassName = genPackage.getPrefix() + AbstractGenModelHelper.TABLES_CLASS_SUFFIX;
				appendClassReference(qualifiedPackageName + "." + tablesClassName);
				append(".Operations._" + type.getName() + "__" + AbstractGenModelHelper.encodeName(anOperation));
			}
		}
	}

//	public void appendReferenceTo(@NonNull ElementId elementId) {
//		appendScope(elementId);
//		appendReferenceTo(null, codeGenerator.getSnippet(elementId));
//		elementId.accept(id2JavaVisitor);
//	}

	protected void appendReferenceTo(@Nullable Class<?> requiredClass, @NonNull CGValuedElement cgValue) {
		appendReferenceTo(requiredClass, cgValue, true);
	}

	protected void appendReferenceTo(@Nullable Class<?> requiredClass, @NonNull CGValuedElement cgValue, boolean reClass) {
		if (requiredClass != null) {
			CGValuedElement value = cgValue.getValue();
//			Class<?> actualClass = value.isCaught() ? Object.class : context.getUnboxedClass(value.getPivotTypeId());
			Class<?> actualClass = getJavaClass(value);
			if ((value instanceof CGParameter) || !(requiredClass.isAssignableFrom(actualClass))) {		// FIXME true typeId for Parameters
				append("(");
				appendClassReference(requiredClass, reClass);
				append(")");
			}
		}
		append(getValueName(cgValue));
	}

	protected void appendString(@NonNull String string) {
		@SuppressWarnings("null")@NonNull String javaString = Strings.convertToJavaString(string);
		append("\"");
		append(javaString);
		append("\"");
	}

	protected void appendTrue() {
		appendClassReference(ValuesUtil.class);
		append(".TRUE_VALUE");
	}

	/**
	 * Append the code name for the value of cgElement, lazily creating one if necessary.
	 */
	protected void appendValueName(@NonNull CGValuedElement cgElement) {
		if (cgElement.isInlineable()) {
			CGValuedElement cgValue = cgElement;
			for (CGValuedElement cgNext; (cgNext = cgValue.getReferredValuedElement()) != cgValue; cgValue = cgNext) {}
			cgValue.accept(this);
		}
		else {
			if (cgElement.isGlobal()) {
				appendGlobalPrefix();
			}
			String valueName = localContext != null ? localContext.getValueName(cgElement) : globalContext.getValueName(cgElement);
			append(valueName);
		}
	}
	
	protected @NonNull Id2JavaInterfaceVisitor createId2JavaClassVisitor() {
		return new Id2JavaInterfaceVisitor();
	}

	protected @NonNull Id2JavaExpressionVisitor createId2JavaExpressionVisitor() {
		return new Id2JavaExpressionVisitor(this);
	}

	public @NonNull CodeGenAnalyzer getAnalyzer() {
		return analyzer;
	}

	private Class<?> getBoxedReturnClass(@NonNull LibraryIteration libraryIteration, int argumentSize) {
		try {
			@SuppressWarnings("null") @NonNull Class<? extends LibraryIteration> implementationClass = libraryIteration.getClass();
			Method method = implementationClass.getMethod("evaluateIteration", DomainIterationManager.class);
			return method.getReturnType();
		} catch (Exception e) {
			return null;
		}
	}

	private Class<?> getBoxedReturnClass(@NonNull LibraryOperation libraryOperation, int argumentSize) {
		try {
			@SuppressWarnings("null") @NonNull Class<? extends LibraryOperation> implementationClass = libraryOperation.getClass();
			Class<?>[] arguments = new Class<?>[argumentSize+3];
			arguments[0] = DomainEvaluator.class;
			arguments[1] = TypeId.class; 
			arguments[2] = Object.class; 
			for (int i = 0; i < argumentSize; i++) {
				arguments[3+i] = Object.class; 
			}
			Method method = implementationClass.getMethod("evaluate", arguments);
			return method.getReturnType();
		} catch (Exception e) {
			return null;
		}
	}

	private Class<?> getBoxedReturnClass(@NonNull LibraryProperty libraryProperty) {
		try {
			@SuppressWarnings("null") @NonNull Class<? extends LibraryProperty> implementationClass = libraryProperty.getClass();
			Class<?>[] arguments = new Class<?>[3];
			arguments[0] = DomainEvaluator.class;
			arguments[1] = TypeId.class; 
			arguments[2] = Object.class; 
			Method method = implementationClass.getMethod("evaluate", arguments);
			return method.getReturnType();
		} catch (Exception e) {
			return null;
		}
	}

	public void generateGlobals(@NonNull Iterable<? extends CGValuedElement> sortedElements) {
		for (CGValuedElement cgElement : sortedElements) {
			if (!cgElement.isInlineable() && cgElement.isConstant() && cgElement.isGlobal()) {
				cgElement.accept(this);
			}
		}
	}

	public @NonNull CodeGenerator getCodeGenerator() {
		return context;
	}

	protected @NonNull CGValuedElement getExpression(@Nullable CGValuedElement cgExpression) {
		return analyzer.getExpression(cgExpression);
	}
	
	public @NonNull GenModelHelper getGenModelHelper() {
		return genModelHelper;
	}

	protected @NonNull Class<?> getJavaClass(@NonNull CGValuedElement cgElement) {
		CGTypeId cgTypeId = cgElement.getTypeId();
		if (cgTypeId != null) {
			ElementId elementId = cgTypeId.getElementId();
			if (elementId != null) {
				if (cgElement.isNonInvalid() || (!cgElement.isCaught() && !cgElement.getValue().isCaught())) {
					return cgElement.isBoxed() ? context.getBoxedClass(elementId) : context.getUnboxedClass(elementId);
				}
			}
		}
		return Object.class;
	}

	protected @Nullable Class<?> getLeastDerivedClass(Class<?> requiredClass, @NonNull String getAccessor) {
		Class<?> superClass = requiredClass.getSuperclass();
		if (superClass != null) {
			try {
				Class<?> lessDerivedSuperClass = getLeastDerivedClass(superClass, getAccessor);
				if (lessDerivedSuperClass != null) {
					return lessDerivedSuperClass;
				}
				Method method = superClass.getMethod(getAccessor);
				if (method != null) {
					return superClass;
				}
			} catch (Exception e) {
			}
		}
		for (Class<?> superInterface : requiredClass.getInterfaces()) {
			Class<?> lessDerivedSuperInterface = getLeastDerivedClass(superInterface, getAccessor);
			if (lessDerivedSuperInterface != null) {
				return lessDerivedSuperInterface;
			}
			try {
				Method method = superInterface.getMethod(getAccessor);
				if (method != null) {
					return superInterface;
				}
			} catch (Exception e) {
			}
		}
		return null;
	}

	protected @Nullable Method getLeastDerivedMethod(Class<?> requiredClass, @NonNull String getAccessor) {
		Method leastDerivedMethod = getLeastDerivedMethodInternal(requiredClass, getAccessor);
		if (leastDerivedMethod != null) {
			return leastDerivedMethod;
		}
		else {
			try {
				return requiredClass.getMethod(getAccessor);
			} catch (Exception e) {
				return null;
			}
		}
	}
	private @Nullable Method getLeastDerivedMethodInternal(Class<?> requiredClass, @NonNull String getAccessor) {
		Class<?> superClass = requiredClass.getSuperclass();
		if (superClass != null) {
			try {
				Method lessDerivedSuperMethod = getLeastDerivedMethodInternal(superClass, getAccessor);
				if (lessDerivedSuperMethod != null) {
					return lessDerivedSuperMethod;
				}
				Method method = superClass.getMethod(getAccessor);
				if (method != null) {
					return method;
				}
			} catch (Exception e) {
			}
		}
		for (Class<?> superInterface : requiredClass.getInterfaces()) {
			Method lessDerivedSuperMethod = getLeastDerivedMethodInternal(superInterface, getAccessor);
			if (lessDerivedSuperMethod != null) {
				return lessDerivedSuperMethod;
			}
			try {
				Method method = superInterface.getMethod(getAccessor);
				if (method != null) {
					return method;
				}
			} catch (Exception e) {
			}
		}
		return null;
	}

	protected @NonNull MetaModelManager getMetaModelManager() {
		return context.getMetaModelManager();
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

/*	protected @NonNull CGVariable getVariable(@NonNull CGComputedExp cgValuedElement) {
		CGVariable variableValue = cgValuedElement.getVariableValue();
		if (variableValue == null) {
			CGLocalVariable localVariable = CGModelFactory.eINSTANCE.createCGLocalVariable();
			localVariable.setName(nameManager.getNameHint(cgValuedElement));
			localVariable.setType(cgValuedElement.getType());
			cgValuedElement.setVariableValue(localVariable);
//			cgValuedElement.getLocalVariables().add(localVariable);
			variableValue = localVariable;
		}
		return variableValue;
	} */

	protected void popIndentation() {
		indentationStack.pop();
	}

	protected void pushIndentation(@Nullable String extraIndentation) {
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

	protected @NonNull Class<?> reClass(@NonNull Class<?> javaClass) {
		if (javaClass == NamedElement.class) {			// FIXME Avoid two-level Pivot interfaces
			javaClass = DomainNamedElement.class;
		}
		else if (javaClass == Operation.class) {
			javaClass = DomainOperation.class;
		}
		else if (javaClass == org.eclipse.ocl.examples.pivot.Package.class) {
			javaClass = DomainPackage.class;
		}
		else if (javaClass == Property.class) {
			javaClass = DomainProperty.class;
		}
		else if (javaClass == Type.class) {
			javaClass = DomainType.class;
		}
		return javaClass;
	}

	protected void resetStream() {
		s.setLength(0);
	}
	
	@Override
	public @NonNull String toString() {
		@SuppressWarnings("null")@NonNull String string = s.toString();
		return string;
	}
	
	@Nullable
	public Object visiting(@NonNull CGElement visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public @Nullable Object visitCGBoolean(@NonNull CGBoolean cgBoolean) {
		boolean booleanValue = cgBoolean.isBooleanValue();
		if (booleanValue) {
			appendTrue();
		}
		else {
			appendFalse();
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGBoxExp(@NonNull CGBoxExp cgBoxExp) {
//		CGValuedElement boxedVariable = cgBoxExp.getInit();
//		TypeId typeId = boxedVariable.getPivotTypeId();
		CGValuedElement unboxedValue = getExpression(cgBoxExp.getSource());
		TypeId typeId = unboxedValue.getPivotTypeId();
//		CGVariable unboxedVariable = (CGVariable) localContext.getFinalVariable(boxedInit);
//		TypeId boxedTypeId = cgBoxExp.getTypeId();
		Class<?> unboxedClass = context.getUnboxedClass(typeId);
		Class<?> boxedClass = context.getBoxedClass(typeId);
//
		appendLocalStatements(unboxedValue);
//		if (!isNonNull()) {
//			text.appendReferenceTo(null, JavaSnippet.this);
//			text.append(" == null ? null : ");
//		}
		appendDeclaration(cgBoxExp);
		append(" = ");
		if (!unboxedValue.isNonNull()) {
			appendReferenceTo(null, unboxedValue);
			append(" == null ? null : ");
		}
		if (Iterable.class.isAssignableFrom(unboxedClass)) {
			@NonNull String collectionName = "Collection";
			if (typeId instanceof CollectionTypeId) {
				collectionName = ((CollectionTypeId)typeId).getGeneralizedId().getName();
			}
			appendReferenceTo(null, localContext.getIdResolverVariable());
			append(".create" + collectionName + "OfAll(");
			appendIdReference(typeId);
			append(", ");
			appendReferenceTo(Iterable.class, unboxedValue);
			append(")");
		}
		else if (BigInteger.class.isAssignableFrom(unboxedClass)
				  || Long.class.isAssignableFrom(unboxedClass)
				  || Integer.class.isAssignableFrom(unboxedClass)
				  || Short.class.isAssignableFrom(unboxedClass)
				  || Byte.class.isAssignableFrom(unboxedClass)
				  || Character.class.isAssignableFrom(unboxedClass)) {
				appendClassReference(ValuesUtil.class);
				append(".integerValueOf(");
				appendReferenceTo(null, unboxedValue);
				append(")");
			}
		else if ((unboxedClass == Object.class) && (typeId == TypeId.INTEGER)) {
				appendClassReference(ValuesUtil.class);
				append(".integerValueOf(");
				appendReferenceTo(null, unboxedValue);		// Character is unboxed as Object!
				append(")");
			}
		else if (BigDecimal.class.isAssignableFrom(unboxedClass)
				  || Double.class.isAssignableFrom(unboxedClass)
				  || Float.class.isAssignableFrom(unboxedClass)) {
				appendClassReference(ValuesUtil.class);
				append(".realValueOf(");
				appendReferenceTo(null, unboxedValue);
				append(")");
			}
		else if (Number.class.isAssignableFrom(unboxedClass)) {
			if (typeId == TypeId.REAL){
				appendClassReference(ValuesUtil.class);
				append(".realValueOf(");
				appendReferenceTo(null, unboxedValue);
				append(")");
			}
			else {
				appendClassReference(ValuesUtil.class);
				append(".integerValueOf(");
				appendReferenceTo(null, unboxedValue);
				append(")");
			}
		}
		else if (EEnumLiteral.class.isAssignableFrom(unboxedClass)) {
			appendClassReference(IdManager.class);
			append(".getEnumerationLiteralId(");
			appendReferenceTo(null, unboxedValue);
			append(")");
		}
		else if (Enumerator.class.isAssignableFrom(unboxedClass)) {
			appendIdReference(typeId);
			append(".getEnumerationLiteralId(");
			appendReferenceTo(null, unboxedValue);
			append(".getName())");
		}
		else {//if (ObjectValue.class.isAssignableFrom(javaClass)) {
			appendClassReference(ValuesUtil.class);
			append(".createObjectValue(");
			appendIdReference(typeId);
			append(", ");
			appendReferenceTo(null, unboxedValue);
			append(")");
		}
		append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGCastParameter(@NonNull CGCastParameter cgCastParameter) {
		CGParameter cgParameter = cgCastParameter.getReferredParameter();
		if (cgParameter != null) {
			appendDeclaration(cgCastParameter);
			append(" = ");
			appendReferenceTo(getJavaClass(cgCastParameter), cgParameter);
			append(";\n");
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGCatchExp(@NonNull CGCatchExp cgCatchExp) {
		String eName = globalContext.getEName();
		CGValuedElement cgSource = getExpression(cgCatchExp.getSource());
		if (cgSource.isNonInvalid()) {
			appendLocalStatements(cgSource);
			appendDeclaration(cgCatchExp);
			append(" = ");
			appendValueName(cgSource);
			append(";\n");
		}
		else {
			appendDeclaration(cgCatchExp);
			append(";\n");
			append("try {\n");
			pushIndentation(null);
				appendLocalStatements(cgSource);
				appendValueName(cgCatchExp);
				append(" = ");
				appendValueName(cgSource);
				append(";\n");
			popIndentation();
			append("}\n");
			append("catch (");
			appendClassReference(Exception.class);
			append(" " + eName + ") {\n");
			pushIndentation(null);
				appendValueName(cgCatchExp);
				append(" = ");
				appendClassReference(ValuesUtil.class);
				append(".createInvalidValue(" + eName + ");\n");
			popIndentation();
			append("}\n");
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGCollectionExp(@NonNull CGCollectionExp cgCollectionExp) {
		int ranges = 0;
		for (CGCollectionPart cgPart : cgCollectionExp.getParts()) {
			if (cgPart.isRange()) {
				ranges++;
			}
			appendLocalStatements(cgPart);
		}
		appendDeclaration(cgCollectionExp);
		append(" = ");
		appendClassReference(ValuesUtil.class);
		String kind = ((CollectionLiteralExp)cgCollectionExp.getPivot()).getKind().getName();
		if (ranges > 0) {
			append(".create" + kind + "Range(");
//			CGTypeVariable typeVariable = localContext.getTypeVariable(cgCollectionExp.getTypeId());
			appendIdReference(cgCollectionExp.getTypeId().getElementId());
			for (CGCollectionPart cgPart : cgCollectionExp.getParts()) {
				append(", ");
				appendValueName(cgPart);
			}
		}
		else {
			append(".create" + kind + "OfEach(");
	//		CGTypeVariable typeVariable = localContext.getTypeVariable(cgCollectionExp.getTypeId());
			appendIdReference(cgCollectionExp.getTypeId().getElementId());
			for (CGCollectionPart cgPart : cgCollectionExp.getParts()) {
				append(", ");
				if (cgPart.isNull() && (cgCollectionExp.getParts().size() == 1)) {
					append("(Object)");
				}
				appendValueName(cgPart);
			}
		}
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGCollectionPart(@NonNull CGCollectionPart cgCollectionPart) {
		CGValuedElement first = getExpression(cgCollectionPart.getFirst());
		CGValuedElement last = cgCollectionPart.getLast();
		if (last != null) {
			appendLocalStatements(first);
			appendLocalStatements(last);
			appendDeclaration(cgCollectionPart);
			append(" = ");
			appendClassReference(ValuesUtil.class);
			append(".createRange(");
			appendValueName(first);
			append(", ");
			appendValueName(last);
			append(");\n");
		}
		else {
			first.accept(this);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGConstantExp(@NonNull CGConstantExp cgConstantExp) {
		CGValuedElement globalConstant = cgConstantExp.getReferredConstant();
		if (globalConstant != null) {
			appendValueName(globalConstant);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGConstraint(@NonNull CGConstraint cgConstraint) {
		localContext = globalContext.getLocalContext(cgConstraint);
		try {
			return super.visitCGConstraint(cgConstraint);
		}
		finally {
			localContext = null;
		}
	}

	@Override
	public @Nullable Object visitCGConstructorExp(@NonNull CGConstructorExp cgConstructorExp) {
/*
		CodeGenAnalysis analysis = context.getAnalysis(element);
		if (analysis.isConstant()) {
			return context.getSnippet(analysis.getConstantValue());
		}
		final Type type = DomainUtil.nonNullModel(element.getTypeId());
		final Class<?> resultClass = Object.class; //context.getBoxedClass(element.getTypeId());
		int flags = CodeGenSnippet.NON_NULL | CodeGenSnippet.UNBOXED;
		if (/*isValidating* / analysis.isCatching()) {
			flags |= CodeGenSnippet.CAUGHT | CodeGenSnippet.MUTABLE;
		}
		else { //if (/*isValidating* / analysis.isThrowing()) {
			flags |= CodeGenSnippet.THROWN;
		}
//		else {
//			flags |= CodeGenSnippet.FINAL;
//		}
		CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, flags);
		snippet = snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
//				text.append("(");
//				text.appendClassReference(EObject.class);
//				text.append(")");
//				text.appendClassReference(ObjectValue.class);
//				text.append(")");
*/
		TypeId typeId = ((ConstructorExp)cgConstructorExp.getPivot()).getTypeId();
		CGExecutorType cgExecutorType = localContext.getExecutorType(typeId);
		Class<?> javaClass = getJavaClass(cgConstructorExp);
		//
		appendDeclaration(cgConstructorExp);
		append(" = ");
		if (javaClass != null) {
			appendClassCast(javaClass, Object.class);
		}
		appendValueName(cgExecutorType);
		append(".createInstance();\n");
		for (CGConstructorPart part : cgConstructorExp.getParts()) {
			part.accept(this);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGConstructorPart(@NonNull CGConstructorPart cgConstructorPart) {
/*		final OCLExpression initExpression = DomainUtil.nonNullModel(element.getInitExpression());
		final Property referredProperty = DomainUtil.nonNullModel(element.getReferredProperty());
		ConstructorExp eContainer = (ConstructorExp)element.eContainer();
		final CodeGenSnippet instanceSnippet = context.getSnippet(eContainer);
		Class<?> resultClass = Object.class; //context.getBoxedClass(element.getTypeId());
		CodeGenSnippet snippet = new JavaSnippet("", context, TypeId.OCL_INVALID, resultClass, element,
			CodeGenSnippet.THROWN | CodeGenSnippet.UNASSIGNED | CodeGenSnippet.UNBOXED);
		return snippet.appendText("", new AbstractTextAppender()
		{
			private CodeGenSnippet initSnippet;
			
			@Override
			public boolean appendAtHead(@NonNull CodeGenSnippet snippet) {
				initSnippet = snippet.appendUnboxedGuardedChild(initExpression, null, DomainMessage.INVALID);
				return true;
			}

			@Override
			public void appendToBody(@NonNull CodeGenText text) { */
//		appendReferenceTo(null, context.getSnippet(referredProperty));
		PropertyId propertyId = ((ConstructorPart)cgConstructorPart.getPivot()).getReferredProperty().getPropertyId();
		CGExecutorConstructorPart cgExecutorConstructorPart = analyzer.getExecutorConstructorPart(propertyId);
		CGValuedElement init = getExpression(cgConstructorPart.getInit());
		//
		appendLocalStatements(init);
		//
		appendValueName(cgExecutorConstructorPart);
		append(".initValue(");
		appendValueName(cgConstructorPart.getConstructorExp());
		append(", ");
		appendValueName(init);
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGEcoreDataTypeConstructorExp(@NonNull CGEcoreDataTypeConstructorExp cgConstructorExp) {
		//
		//	Availability of a GenPackage is mandatory since we must have an EFactory.createFromString method to do the construction.
		//
		EDataType eDataType = cgConstructorExp.getEDataType();
		final Class<?> javaClass = eDataType.getInstanceClass();
		if (javaClass == null) {
			throw new IllegalStateException("No Java class for " + cgConstructorExp + " in CG2JavaVisitor.visitCGEcoreDataTypeConstructorExp()");
		}
		final EPackage ePackage = eDataType.getEPackage();
		String nsURI = ePackage.getNsURI();
		if (nsURI == null) {
			throw new IllegalStateException("No EPackage NsURI for " + cgConstructorExp + " in CG2JavaVisitor.visitCGEcoreDataTypeConstructorExp()");
		}
		GenPackage genPackage = getMetaModelManager().getGenPackage(nsURI);
		if (genPackage == null) {
			throw new IllegalStateException("No GenPackage for " + cgConstructorExp + " in CG2JavaVisitor.visitCGEcoreDataTypeConstructorExp()");
		}
		final String eFactoryName = genPackage.getQualifiedFactoryInterfaceName();
		final String ePackageName = genPackage.getQualifiedPackageInterfaceName();
		final String dataTypeName = CodeGenUtil.upperName(eDataType.getName());
		ClassLoader classLoader = eDataType.getClass().getClassLoader();
		Class<?> factoryClass;
		Class<?> packageClass;
		try {
			factoryClass = classLoader.loadClass(eFactoryName);
			packageClass = eDataType.getClass().getClassLoader().loadClass(ePackageName);
		}
		catch (ClassNotFoundException e) {
			throw new IllegalStateException("Load class failure for " + cgConstructorExp + " in CG2JavaVisitor.visitCGEcoreDataTypeConstructorExp()", e);
		}
		//
		appendDeclaration(cgConstructorExp);
		append(" = ");
		append("(");
		appendClassReference(javaClass);
		append(")");
		appendClassReference(factoryClass);
		append(".eINSTANCE.createFromString(");
		appendClassReference(packageClass);
		append(".Literals." + dataTypeName + ", \"");
		String partString = cgConstructorExp.getString();
//		EFactory eFactoryInstance = ePackage.getEFactoryInstance();
//		String partString = eFactoryInstance.convertToString(eDataType, object);
		if (partString != null) {
			@SuppressWarnings("null") @NonNull String javaString = Strings.convertToJavaString(partString);
			append(javaString);
		}
		append("\");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGEcoreOperationCallExp(@NonNull CGEcoreOperationCallExp cgOperationCallExp) {
		Operation pOperation = cgOperationCallExp.getReferredOperation();
		EOperation eOperation = cgOperationCallExp.getEOperation();
		CGValuedElement source = getExpression(cgOperationCallExp.getSource());
		List<CGValuedElement> cgArguments = cgOperationCallExp.getArguments();
		List<Parameter> pParameters = pOperation.getOwnedParameter();
		//
		appendLocalStatements(source);
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgArguments) {
			CGValuedElement argument = getExpression(cgArgument);
			appendLocalStatements(argument);
		}
		//
		String operationAccessor = genModelHelper.getOperationAccessor(pOperation);
//		Class<?> actualBoxedReturnClass = getBoxedReturnClass(libraryOperation, arguments.size());
		Class<?> unboxedSourceClass = genModelHelper.getEcoreInterfaceClass(eOperation.getEContainingClass());
		appendDeclaration(cgOperationCallExp);
		append(" = ");
		appendAtomicReferenceTo(unboxedSourceClass, source, false);
		append(".");
			append(operationAccessor);
		append("(");
		int iMax = Math.min(pParameters.size(), cgArguments.size());
		for (int i = 0; i < iMax; i++) {
			if (i > 0) {
				append(", ");
			}
			CGValuedElement cgArgument = cgArguments.get(i);
			Parameter pParameter = pParameters.get(i);
			Class<?> parameterClass = genModelHelper.getEcoreInterfaceClass(pParameter.getType());
			CGValuedElement argument = getExpression(cgArgument);
			appendReferenceTo(parameterClass, argument, false);
		}
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGEcorePropertyCallExp(@NonNull CGEcorePropertyCallExp cgPropertyCallExp) {
		Property pivotProperty = cgPropertyCallExp.getReferredProperty();
		Type owningType = pivotProperty.getOwningType();
		EStructuralFeature eStructuralFeature = cgPropertyCallExp.getEStructuralFeature();
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
//		Type returnType = DomainUtil.nonNullModel(pivotProperty.getType());
		String getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
		Class<?> requiredClass = genModelHelper.getEcoreInterfaceClass(owningType);
//		Class<?> leastDerivedClass = getLeastDerivedClass(requiredClass, getAccessor);
		Method leastDerivedMethod = getLeastDerivedMethod(requiredClass, getAccessor);
//		Class<?> returnClass = leastDerivedMethod != null ? leastDerivedMethod.getReturnType() : genModelHelper.getEcoreInterfaceClass(returnType);
		Class<?> unboxedSourceClass = leastDerivedMethod != null ? leastDerivedMethod.getDeclaringClass() : genModelHelper.getEcoreInterfaceClass(eStructuralFeature.getEContainingClass());
		//
		appendLocalStatements(source);
		//
		appendDeclaration(cgPropertyCallExp);
		append(" = ");
		appendAtomicReferenceTo(unboxedSourceClass, source, false);
		append(".");
			append(getAccessor);
		append("();\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGElementId(@NonNull CGElementId cgElementId) {
		ElementId elementId = cgElementId.getElementId();
		if ((elementId != null) && !CGUtils.isInlineableId(elementId)) {
			append("public static final ");
			appendIsRequired(true);
			append(" ");
			appendIsCaught(true, false);
			append(" ");
			appendClassReference(elementId.accept(id2JavaInterfaceVisitor));
			append(" ");
			append(globalContext.getValueName(cgElementId));
			append(" = ");
			elementId.accept(id2JavaExpressionVisitor);
			append(";\n");
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorCompositionProperty(@NonNull CGExecutorCompositionProperty cgExecutorProperty) {
		appendDeclaration(cgExecutorProperty);
		append(" = new ");
		appendClassReference(getJavaClass(cgExecutorProperty));
		append("(");
		Property pivotProperty = (Property) cgExecutorProperty.getPivot();
		Property pivotOppositeProperty = pivotProperty.getOpposite();
		appendString(pivotOppositeProperty.getName());
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorConstructorPart(@NonNull CGExecutorConstructorPart cgExecutorConstructorPart) {
		appendDeclaration(cgExecutorConstructorPart);
		append(" = ");
		appendValueName(localContext.getIdResolverVariable());
		append(".getProperty(");
		appendIdReference(cgExecutorConstructorPart.getUnderlyingPropertyId().getElementId());
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorNavigationProperty(@NonNull CGExecutorNavigationProperty cgExecutorProperty) {
		appendDeclaration(cgExecutorProperty);
		append(" = new ");
		appendClassReference(getJavaClass(cgExecutorProperty));
		append("(");
		appendIdReference(cgExecutorProperty.getUnderlyingPropertyId().getElementId());
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorOppositeProperty(@NonNull CGExecutorOppositeProperty cgExecutorProperty) {
		Property pivotProperty = (Property) cgExecutorProperty.getPivot();
		Property pivotOppositeProperty = pivotProperty.getOpposite();
		appendDeclaration(cgExecutorProperty);
		append(" = new ");
		appendClassReference(getJavaClass(cgExecutorProperty));
		append("(");
		appendIdReference(pivotOppositeProperty.getPropertyId());
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorOperation(@NonNull CGExecutorOperation cgExecutorOperation) {
		appendDeclaration(cgExecutorOperation);
		append(" = ");
		appendValueName(localContext.getIdResolverVariable());
		append(".getOperation(");
		appendIdReference(cgExecutorOperation.getUnderlyingOperationId().getElementId());
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorOperationCallExp(@NonNull CGExecutorOperationCallExp cgOperationCallExp) {
		Operation pOperation = cgOperationCallExp.getReferredOperation();
		CGValuedElement source = getExpression(cgOperationCallExp.getSource());
		List<CGValuedElement> cgArguments = cgOperationCallExp.getArguments();
		List<Parameter> pParameters = pOperation.getOwnedParameter();
		CGValuedElement resultVariable = cgOperationCallExp.getValue();
		CGTypeId resultType = resultVariable.getTypeId();
		ElementId elementId = resultType.getElementId();
//		Class<?> requiredBoxedReturnClass = resultVariable.isBoxed() ? context.getBoxedClass(elementId) : context.getUnboxedClass(elementId);
		Class<?> requiredBoxedReturnClass = getJavaClass(cgOperationCallExp);
		//
		appendLocalStatements(source);
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgArguments) {
			CGValuedElement argument = getExpression(cgArgument);
			appendLocalStatements(argument);
		}
		//
		appendDeclaration(cgOperationCallExp);
		append(" = ");
		appendClassCast(requiredBoxedReturnClass, Object.class);
		appendReferenceTo(null, cgOperationCallExp.getExecutorOperation());
		append(".evaluate(");
		append(getValueName(localContext.getEvaluatorParameter()));
		append(", ");
		appendIdReference(cgOperationCallExp.getPivotTypeId());
		append(", ");
		appendValueName(source);
		int iMax = Math.min(pParameters.size(), cgArguments.size());
		for (int i = 0; i < iMax; i++) {
			append(", ");
			CGValuedElement cgArgument = cgArguments.get(i);
			Parameter pParameter = pParameters.get(i);
			Class<?> parameterClass = genModelHelper.getEcoreInterfaceClass(pParameter.getType());
			CGValuedElement argument = getExpression(cgArgument);
			appendReferenceTo(parameterClass, argument, false);
		}
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorPropertyCallExp(@NonNull CGExecutorPropertyCallExp cgPropertyCallExp) {
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		CGValuedElement resultVariable = cgPropertyCallExp.getValue();
		CGTypeId resultType = resultVariable.getTypeId();
		ElementId elementId = resultType.getElementId();
//		Class<?> requiredBoxedReturnClass = resultVariable.isBoxed() ? context.getBoxedClass(elementId) : context.getUnboxedClass(elementId);
		Class<?> requiredBoxedReturnClass = getJavaClass(cgPropertyCallExp);
		//
		appendLocalStatements(source);
		//
		appendDeclaration(cgPropertyCallExp);
		append(" = ");
		appendClassCast(requiredBoxedReturnClass, Object.class);
		appendReferenceTo(null, cgPropertyCallExp.getExecutorProperty());
		append(".evaluate(");
		append(getValueName(localContext.getEvaluatorParameter()));
		append(", ");
		appendIdReference(cgPropertyCallExp.getPivotTypeId());
		append(", ");
		appendValueName(source);
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGExecutorType(@NonNull CGExecutorType cgExecutorType) {
		appendDeclaration(cgExecutorType);
		append(" = ");
		appendValueName(localContext.getIdResolverVariable());
		append(".getType(");
		appendIdReference(cgExecutorType.getUnderlyingTypeId().getElementId());
		append(", null);\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGGuardExp(@NonNull CGGuardExp cgGuardExp) {
		CGValuedElement cgSource = getExpression(cgGuardExp.getSource());
		//
		if (cgSource.isNull()) {
			append("throw new ");
			appendClassReference(InvalidValueException.class);
			append("();\n");
		}
		else {
			appendLocalStatements(cgSource);
			if (!cgSource.isNonNull()) {
				append("if (");
				appendValueName(cgSource);
				append(" == null) {\n");
				pushIndentation(null);
					append("throw new ");
					appendClassReference(InvalidValueException.class);
					append("(\"Null source\");\n");
				popIndentation();
				append("}\n");
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGIfExp(@NonNull CGIfExp cgIfExp) {
		CGValuedElement condition = getExpression(cgIfExp.getCondition());
		CGValuedElement thenExpression = getExpression(cgIfExp.getThenExpression());
		CGValuedElement elseExpression = getExpression(cgIfExp.getElseExpression());
//		CGVariable resultVariable = localContext.getLocalVariable(cgIfExp);
		//
		appendLocalStatements(condition);
		appendDeclaration(cgIfExp);
		append(";\n");
		//
		append("if (");
		appendValueName(condition);
		append(") {\n");
		pushIndentation(null);
			appendAssignment(cgIfExp, thenExpression);
		popIndentation();
		append("}\n");
		append("else {\n");
		pushIndentation(null);
			appendAssignment(cgIfExp, elseExpression);
		popIndentation();
		append("}\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGInfinity(@NonNull CGInfinity object) {
		appendClassReference(ValuesUtil.class);
		append(".UNLIMITED_VALUE");
		return null;
	}

	@Override
	public @Nullable Object visitCGInteger(@NonNull CGInteger object) {
		appendDeclaration(object);
		append(" = ");
		appendClassReference(ValuesUtil.class);
		append(".integerValueOf(");
		Number integerValue = object.getIntegerValue();
		String valueString = integerValue.toString();
		assert valueString != null;
		if (integerValue instanceof IntIntegerValueImpl) {
			append(valueString);
		}
		else if (integerValue instanceof LongIntegerValueImpl) {
			append(valueString + "L");
		}
		else {
			append("\"" + valueString + "\"");
		}
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGInvalid(@NonNull CGInvalid object) {
		String message = object.getMessageTemplate();
		if (message != null) {
			append("new ");
			appendClassReference(InvalidValueException.class);
			append("(");
			appendString(message);
			for (Object binding : object.getBindings()) {
				s.append(", ");
				appendString(String.valueOf(binding));
			}
			append(")");
		}
		else {
			appendClassReference(ValuesUtil.class);
			append(".INVALID_VALUE");
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGIsInvalidExp(@NonNull CGIsInvalidExp cgIsInvalidExp) {
		if (cgIsInvalidExp.isTrue()) {
			appendTrue();
		}
		else if (cgIsInvalidExp.isFalse()) {
			appendFalse();
		}
		else {
			CGValuedElement cgSource = getExpression(cgIsInvalidExp.getSource());
			appendLocalStatements(cgSource);
			//
			appendDeclaration(cgIsInvalidExp);
			append(" = ");
			appendValueName(cgSource);
			append(" instanceof ");
			appendClassReference(InvalidValueException.class);
			append(";\n");
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGIsUndefinedExp(@NonNull CGIsUndefinedExp cgIsUndefinedExp) {
		if (cgIsUndefinedExp.isTrue()) {
			appendTrue();
		}
		else if (cgIsUndefinedExp.isFalse()) {
			appendFalse();
		}
		else {
			CGValuedElement cgSource = getExpression(cgIsUndefinedExp.getSource());
			boolean sourceIsNonInvalid = cgSource.isNonInvalid();
			boolean sourceIsNonNull = cgSource.isNonNull();
			appendLocalStatements(cgSource);
			//
			appendDeclaration(cgIsUndefinedExp);
			append(" = ");
			if (!sourceIsNonNull && !sourceIsNonInvalid) {
				append("(");
				appendValueName(cgSource);
				append(" == null) || (");
				appendValueName(cgSource);
				append(" instanceof ");
				appendClassReference(InvalidValueException.class);
				append(")");
			}
			else if (!sourceIsNonNull && sourceIsNonInvalid) {
				appendValueName(cgSource);
				append(" == null");
			}
			else if (sourceIsNonNull && !sourceIsNonInvalid) {
				appendValueName(cgSource);
				append(" instanceof ");
				appendClassReference(InvalidValueException.class);
			}
			append(";\n");
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGLetExp(@NonNull CGLetExp cgLetExp) {
		cgLetExp.getInit().accept(this);
		appendLocalStatements(cgLetExp.getIn());
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryIterateCallExp(@NonNull CGLibraryIterateCallExp cgIterateCallExp) {
		CGValuedElement source = getExpression(cgIterateCallExp.getSource());
		CGValuedElement body = getExpression(cgIterateCallExp.getBody());
		LibraryIteration libraryIteration = cgIterateCallExp.getLibraryIteration();
		CGIterator iterateResult = cgIterateCallExp.getResult();
		Class<?> actualBoxedReturnClass = getBoxedReturnClass(libraryIteration, 0);
		CGTypeId resultType = cgIterateCallExp.getTypeId();
		Class<?> requiredBoxedReturnClass = context.getBoxedClass(resultType.getElementId());
		CGValuedElement evaluatorParameter = localContext.getEvaluatorParameter();
		List<CGIterator> iterators = cgIterateCallExp.getIterators();
		final int arity = iterators.size();
		final Class<?> operationClass = genModelHelper.getAbstractOperationClass(iterators);
		final String astName = cgIterateCallExp.getValueName();
		Operation referredOperation = ((LoopExp)cgIterateCallExp.getPivot()).getReferredIteration();
		final Class<?> managerClass = ExecutorSingleIterationManager.class;
		final String staticTypeName = "TYPE_" + astName;
		final String implementationName = "IMPL_" + astName;
		final String managerName = "MGR_" + astName;
		final String bodyName = "BODY_" + astName;
		
		
		
		appendLocalStatements(source);
		CGValuedElement init = iterateResult.getInit();
		final String accumulatorName = init.getValueName();
		appendLocalStatements(init);
		appendDeclaration(iterateResult);
		append(" = ");
		appendValueName(init);
		append(";\n");
		//
		append("/**\n"); 
		append(" * Implementation of the iterator body.\n");
		append(" */\n");
		append("final ");
		appendIsRequired(true);
		append(" ");
		appendClassReference(operationClass);
		append(" " + bodyName + " = new ");
		appendClassReference(operationClass);
		append("()\n");
		append("{\n");

		pushIndentation(null);
			appendCommentWithOCL(null, body.getPivot());
			append("@Override\n");
			append("public ");
			appendIsRequired(false);
			append(" Object evaluate(");
			appendDeclaration(evaluatorParameter);
			append(", ");
			appendDeclaration(localContext.getTypeIdParameter());
//			append(", ");
//			appendDeclaration(context.getEvaluatorSnippet(snippet));
			append(", ");
//			appendIsRequired(false);
//			append(" final Object sourceValue");
			appendDeclaration(iterateResult);
			for (@SuppressWarnings("null")@NonNull CGParameter iterator : iterators) {
				append(", ");
				appendDeclaration(iterator);
			}
			append(") {\n");
			pushIndentation(null);
				JavaLocalContext savedLocalContext = localContext;
				try {
					localContext = globalContext.getLocalContext(cgIterateCallExp);
					List<CGIterator> allIterators = new ArrayList<CGIterator>(iterators);
					allIterators.add(iterateResult);
					appendCastParameters(localContext, allIterators);
					appendLocalStatements(body);
					append("return ");
					appendValueName(body);
					append(";\n");
				}
				finally {
					localContext = savedLocalContext;
				}
			popIndentation();
			append("}\n");
		popIndentation();
		append("};\n");
		//
		appendClassReference(DomainType.class);
		append(" " + staticTypeName + " = ");
		appendReferenceTo(null, evaluatorParameter);
		append(".getStaticTypeOf(");
		appendValueName(source);
		append(");\n");
		//
		appendClassReference(LibraryIteration.class);
		append(" " + implementationName + " = ("); 
		appendClassReference(LibraryIteration.class);
		append( ")" + staticTypeName + ".lookupImplementation("); 
		appendReferenceTo(null, localContext.getStandardLibraryVariable());
		append(", ");
		appendQualifiedLiteralName(referredOperation);
		append(");\n");
		//
		appendClassReference(managerClass);
		append(" " + managerName + " = new ");
		appendClassReference(managerClass);
		append("(");
		appendReferenceTo(null, evaluatorParameter);
		append(", ");
		appendValueName(resultType);
		append(", " + bodyName + ", ");
//		appendReferenceTo(CollectionValue.class, source);
		appendValueName(source);
		append(", " + accumulatorName + ");\n");
		//
		appendDeclaration(cgIterateCallExp);
		append(" = ");
		appendClassCast(requiredBoxedReturnClass, actualBoxedReturnClass);
		append(implementationName + ".evaluateIteration(" + managerName + ")");
		append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryIterationCallExp(@NonNull CGLibraryIterationCallExp cgIterationCallExp) {
		CGValuedElement source = getExpression(cgIterationCallExp.getSource());
		CGValuedElement body = getExpression(cgIterationCallExp.getBody());
		LibraryIteration libraryIteration = cgIterationCallExp.getLibraryIteration();
		Class<?> actualBoxedReturnClass = getBoxedReturnClass(libraryIteration, 0);
//		CGValuedElement resultVariable = cgIterationCallExp.getValue();
		CGTypeId resultType = cgIterationCallExp.getTypeId();
		Class<?> requiredBoxedReturnClass = context.getBoxedClass(resultType.getElementId());
		CGValuedElement evaluatorParameter = localContext.getEvaluatorParameter();
		List<CGIterator> iterators = cgIterationCallExp.getIterators();
		final int arity = iterators.size();
		final Class<?> operationClass = genModelHelper.getAbstractOperationClass(iterators);
		final String astName = cgIterationCallExp.getValueName();
		Operation referredOperation = ((LoopExp)cgIterationCallExp.getPivot()).getReferredIteration();
		final Class<?> managerClass = arity == 1 ? ExecutorSingleIterationManager.class : ExecutorDoubleIterationManager.class; 	// FIXME ExecutorMultipleIterationManager
		final String staticTypeName = "TYPE_" + astName;
		final String accumulatorName = "ACC_" + astName;
		final String implementationName = "IMPL_" + astName;
		final String managerName = "MGR_" + astName;
		final String bodyName = "BODY_" + astName;
		
		
		
		appendLocalStatements(source);
		//
		append("/**\n"); 
		append(" * Implementation of the iterator body.\n");
		append(" */\n");
		append("final ");
		appendIsRequired(true);
		append(" ");
		appendClassReference(operationClass);
		append(" " + bodyName + " = new ");
		appendClassReference(operationClass);
		append("()\n");
		append("{\n");

		pushIndentation(null);
			appendCommentWithOCL(null, body.getPivot());
			append("@Override\n");
			append("public ");
			appendIsRequired(false);
			append(" Object evaluate(");
			appendDeclaration(evaluatorParameter);
			append(", ");
			appendDeclaration(localContext.getTypeIdParameter());
//			append(", ");
//			appendDeclaration(context.getEvaluatorSnippet(snippet));
			append(", final ");
			appendIsRequired(false);
			append(" Object ");
			appendValueName(source);
//			appendDeclaration(source);
			for (@SuppressWarnings("null")@NonNull CGParameter iterator : iterators) {
				append(", ");
				appendDeclaration(iterator);
			}
			append(") {\n");
			pushIndentation(null);
				JavaLocalContext savedLocalContext = localContext;
				try {
					localContext = globalContext.getLocalContext(cgIterationCallExp);
					appendCastParameters(localContext, iterators);
					appendLocalStatements(body);
					append("return ");
					appendValueName(body);
					append(";\n");
				}
				finally {
					localContext = savedLocalContext;
				}
			popIndentation();
			append("}\n");
		popIndentation();
		append("};\n");
		//
		appendClassReference(DomainType.class);
		append(" " + staticTypeName + " = ");
		appendReferenceTo(null, evaluatorParameter);
		append(".getStaticTypeOf(");
		appendValueName(source);
		append(");\n");
		//
		appendClassReference(LibraryIteration.class);
		append(" " + implementationName + " = ("); 
		appendClassReference(LibraryIteration.class);
		append( ")" + staticTypeName + ".lookupImplementation("); 
		appendReferenceTo(null, localContext.getStandardLibraryVariable());
		append(", ");
		appendQualifiedLiteralName(referredOperation);
		append(");\n");
		//
		append("Object " + accumulatorName + " = " + implementationName + ".createAccumulatorValue(");
		appendValueName(evaluatorParameter);
		append(", ");
		appendValueName(resultType);
		append(", ");
		appendValueName(body.getTypeId());
		append(");\n");
		//
		appendClassReference(managerClass);
		append(" " + managerName + " = new ");
		appendClassReference(managerClass);
		append("(");
		appendReferenceTo(null, evaluatorParameter);
		append(", ");
		appendValueName(resultType);
		append(", " + bodyName + ", ");
		appendReferenceTo(CollectionValue.class, source);
		append(", " + accumulatorName + ");\n");
		//
		appendDeclaration(cgIterationCallExp);
		append(" = ");
		appendClassCast(requiredBoxedReturnClass, actualBoxedReturnClass);
		append(implementationName + ".evaluateIteration(" + managerName + ")");
		append(";\n");
		return null;
	}

/*	@Override
	public @NonNull CodeGenSnippet visitIteratorExp(@NonNull IteratorExp element) {
		Iteration referredIteration = DomainUtil.nonNullModel(element.getReferredIteration());
		try {
			LibraryFeature implementation = context.getMetaModelManager().getImplementation(referredIteration);
			@SuppressWarnings("null")@NonNull Class<? extends LibraryFeature> implementationClass = implementation.getClass();
			Inliner inliner = context.getInliner(implementationClass);
			if (inliner instanceof IterationInliner) {
				return ((IterationInliner)inliner).visitLoopExp(element);
			}
		} catch (UnsupportedOperationException e) {		// Deliberate fallback
		} catch (Exception e) {
			System.out.println("Iteration inlining aborted for '" + element + "'\n\t" + e);
		}
		CodeGenAnalysis analysis = context.getAnalysis(element);
		Class<?> resultClass = Object.class; //context.getBoxedClass(element.getTypeId());
		int flags = CodeGenSnippet.BOXED;
		if (referredIteration.isRequired()) {
//			flags |= CodeGenSnippet.NON_NULL;// | CodeGenSnippet.SUPPRESS_NON_NULL_WARNINGS;
		}
		if (/*isValidating* / analysis.isCatching()) {
			flags |= CodeGenSnippet.CAUGHT | CodeGenSnippet.MUTABLE;
		}
		else {
			flags |= CodeGenSnippet.THROWN;
		}
		final @NonNull CodeGenSnippet snippet = new JavaSnippet("", analysis, resultClass, flags);
		final OCLExpression source = DomainUtil.nonNullModel(element.getSource());
		final OCLExpression bodyExpression = element.getBody();
		final List<Variable> iterators = element.getIterator();
		final int arity = iterators.size();
		final String operationTypeName = snippet.getImportedName(genModelHelper.getAbstractOperationClass(iterators));
		final String iterationTypeName = snippet.getImportedName(LibraryIteration.class);
		String astName = snippet.getName();
//		String sourceName = getBoxedSymbolName(source);
		final CodeGenSnippet typeIdText = snippet.getSnippet(element.getTypeId());
		final CodeGenSnippet bodyTypeText = snippet.getSnippet(bodyExpression.getTypeId());
		final String referredIterationName = genModelHelper.getQualifiedLiteralName(snippet, referredIteration);
		final String managerTypeName = snippet.getImportedName(arity == 1 ? ExecutorSingleIterationManager.class : ExecutorDoubleIterationManager.class); 	// FIXME ExecutorMultipleIterationManager
		final String typeIdName = snippet.getImportedName(TypeId.class);
		final String atNonNull = snippet.atNonNull(false);
		final String atNullable = snippet.atNullable();
		final String staticTypeName = "TYPE_" + astName;
		final String accumulatorName = "ACC_" + astName;
		final String implementationName = "IMPL_" + astName;
		final String managerName = "MGR_" + astName;
		final String bodyName = "BODY_" + astName;
		final CodeGenLabel localLabel = context.getSnippetLabel(CodeGenerator.LOCAL_ROOT);
		final CodeGenLabel scopeLabel = context.getSnippetLabel(CodeGenerator.SCOPE_ROOT);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public boolean appendAtHead(@NonNull CodeGenSnippet snippet) {
				CodeGenText head = snippet.appendIndentedText("");
				head.append("/**\n"); 
				head.append(" * Implementation of the iterator body.\n");
				head.append(" * /\n");
				head.append("final " + atNonNull + " " + operationTypeName + " " + bodyName + " = new " + operationTypeName + "()\n");
				head.append("{\n");
				//
				CodeGenSnippet evaluateBody = snippet.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
					CodeGenText text = evaluateBody.appendIndentedText("");
					text.appendCommentWithOCL(null, bodyExpression);
					text.append("@Override\n");
					text.append("public " + atNullable + " Object evaluate(");
					text.appendDeclaration(context.getEvaluatorSnippet(snippet));
					text.append(", final "  + atNonNull +  " " + typeIdName + " returnTypeId, " +
						atNullable + " final Object sourceValue");
					CodeGenSnippet evaluateNodes = evaluateBody.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
					localLabel.push(evaluateNodes);
					scopeLabel.push(evaluateNodes);
					for (int i = 0; i < arity; i++) {
						text.append(", ");
						CodeGenSnippet iteratorSnippet = evaluateNodes.getSnippet(iterators.get(i));
						text.appendDeclaration(iteratorSnippet);
						iteratorSnippet.addDependsOn(evaluateNodes);		// FIXME IterateExp too, automate??
					}
					text.append(") {\n");
					//
					CodeGenSnippet bodyNodes = evaluateBody.appendIndentedNodes(null, CodeGenSnippet.UNASSIGNED);
					scopeLabel.push(bodyNodes);
					CodeGenSnippet bodySnippet = bodyNodes.appendBoxedGuardedChild(bodyExpression, null, null);
					if (bodySnippet != null) {
						CodeGenText returnText = bodyNodes.append("return ");
						returnText.appendReferenceTo(null, bodySnippet);
						returnText.append(";\n");
					}
					scopeLabel.pop();
//					CodeGenSnippet iteratorBody = evaluateBody.appendIndentedNodes(null, CodeGenSnippet.LOCAL);
//						CodeGenText returnText = iteratorBody.append("return ");
//						returnText.appendBoxedReferenceTo(Object.class, bodyExpression);
//						returnText.append(";\n");
					evaluateBody.append("}\n");
					localLabel.pop();
					scopeLabel.pop();
				snippet.append("};\n");

				CodeGenSnippet sourceSnippet = snippet.appendBoxedGuardedChild(source, DomainMessage.NULL, DomainMessage.INVALID);
				if (sourceSnippet == null) {
					return false;
				}
				CodeGenText tail = snippet.appendIndentedText("");
				tail.appendClassReference(DomainType.class);
				tail.append(" " + staticTypeName + " = ");
				tail.appendEvaluatorReference();
				tail.append(".getStaticTypeOf(");
				tail.appendReferenceTo(null, sourceSnippet);
				tail.append(");\n");
				//
				tail.append(iterationTypeName + " " + implementationName + " = (" + iterationTypeName + ")" + staticTypeName + ".lookupImplementation("); 
				tail.appendReferenceTo(null, context.getStandardLibrary(snippet));
				tail.append(", " + referredIterationName + ");\n");
				//
				tail.append("Object " + accumulatorName + " = " + implementationName + ".createAccumulatorValue(");
				tail.appendEvaluatorReference();
				tail.append(", ");
				tail.appendReferenceTo(null, typeIdText);
				tail.append(", ");
				tail.appendReferenceTo(null, bodyTypeText);
				tail.append(");\n");
				//
				tail.append(managerTypeName + " " + managerName + " = new " + managerTypeName + "(");
				tail.appendEvaluatorReference();
				tail.append(", ");
				tail.appendReferenceTo(null, typeIdText);
				tail.append(", " + bodyName + ", ");
				tail.appendReferenceTo(CollectionValue.class, sourceSnippet);
				tail.append(", " + accumulatorName + ");\n");
				return true;
			}

			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.append(implementationName + ".evaluateIteration(" + managerName + ")");
			}
		});
	} */

	@Override
	public @Nullable Object visitCGLibraryOperationCallExp(@NonNull CGLibraryOperationCallExp cgOperationCallExp) {
		CGValuedElement source = getExpression(cgOperationCallExp.getSource());
		List<CGValuedElement> arguments = cgOperationCallExp.getArguments();
		LibraryOperation libraryOperation = cgOperationCallExp.getLibraryOperation();
		Class<?> actualBoxedReturnClass = getBoxedReturnClass(libraryOperation, arguments.size());
//		CGValuedElement resultVariable = cgOperationCallExp; //.getValue();
		CGTypeId resultType = cgOperationCallExp.getTypeId();
		Class<?> requiredBoxedReturnClass = context.getBoxedClass(resultType.getElementId());
		appendLocalStatements(source);
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : arguments) {
			appendLocalStatements(cgArgument);
		}
		appendDeclaration(cgOperationCallExp);
		append(" = ");
		appendClassCast(requiredBoxedReturnClass, actualBoxedReturnClass);
		appendClassReference(libraryOperation.getClass());
//		CGOperation cgOperation = DomainUtil.nonNullState(CGUtils.getContainingOperation(cgOperationCallExp));
		append("."+ globalContext.getInstanceName() + "."+ globalContext.getEvaluateName() + "(");
		if (!(libraryOperation instanceof LibrarySimpleOperation)) {
			append(getValueName(localContext.getEvaluatorParameter()));
			append(", ");
			if (!(libraryOperation instanceof LibraryUntypedOperation)) {
//				CGTypeVariable typeVariable = localContext.getTypeVariable(resultType);
				appendValueName(resultType);
				append(", ");
			}
		}
		appendValueName(source);
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : arguments) {
			append(", ");
			appendValueName(cgArgument);
		}
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGLibraryPropertyCallExp(@NonNull CGLibraryPropertyCallExp cgPropertyCallExp) {
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		LibraryProperty libraryProperty = cgPropertyCallExp.getLibraryProperty();
		Class<?> actualBoxedReturnClass = getBoxedReturnClass(libraryProperty);
//		CGValuedElement resultVariable = cgOperationCallExp; //.getValue();
		CGTypeId resultType = cgPropertyCallExp.getTypeId();
		Class<?> requiredBoxedReturnClass = context.getBoxedClass(resultType.getElementId());
		appendLocalStatements(source);
		appendDeclaration(cgPropertyCallExp);
		append(" = ");
		appendClassCast(requiredBoxedReturnClass, actualBoxedReturnClass);
		appendClassReference(libraryProperty.getClass());
//		CGOperation cgOperation = DomainUtil.nonNullState(CGUtils.getContainingOperation(cgPropertyCallExp));
		append("."+ globalContext.getInstanceName() + "."+ globalContext.getEvaluateName() + "(");
//		if (!(libraryOperation instanceof LibrarySimpleOperation)) {
			append(getValueName(localContext.getEvaluatorParameter()));
			append(", ");
//			if (!(libraryProperty instanceof LibraryUntypedOperation)) {
//				CGTypeVariable typeVariable = localContext.getTypeVariable(resultType);
				appendValueName(resultType);
				append(", ");
//			}
//		}
		appendValueName(source);
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGNull(@NonNull CGNull object) {
		append("null");
		return null;
	}

	@Override
	public @Nullable Object visitCGOperation(@NonNull CGOperation cgOperation) {
		localContext = globalContext.getLocalContext(cgOperation);
		try {
			return super.visitCGOperation(cgOperation);
		}
		finally {
			localContext = null;
		}
	}

	@Override
	public @Nullable Object visitCGPackage(@NonNull CGPackage cgPackage) {
		append("package " + cgPackage.getName() + ";\n");
		append("\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGParameter(@NonNull CGParameter object) {
		return null;			// Parameters are declared by their Operation
	}

	@Override
	public @Nullable Object visitCGReal(@NonNull CGReal object) {
		appendDeclaration(object);
		append(" = ");
		appendClassReference(ValuesUtil.class);
		append(".realValueOf(");
		Number realValue = object.getRealValue();
		String valueString = realValue.toString();
		if (realValue instanceof Double) {
			append(valueString + "d");
		}
		else {
			append("\"" + valueString + "\"");
		}
		append(");\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGString(@NonNull CGString object) {
		appendDeclaration(object);
		append(" = ");
		appendString(object.getStringValue());
		append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGText(@NonNull CGText cgText) {
		appendDeclaration(cgText);
		append(" = ");
		append(cgText.getTextValue());
		append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGTextParameter(@NonNull CGTextParameter cgTextParameter) {
		appendDeclaration(cgTextParameter, false);
		append(" = ");
		append(cgTextParameter.getTextValue());
		append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGThrowExp(@NonNull CGThrowExp cgThrowExp) {
		CGValuedElement cgSource = getExpression(cgThrowExp.getSource());
		if (cgSource.isNonInvalid()) {
			cgSource.accept(this);
		}
		else if (cgSource.isInvalid()) {
			append("throw ");
			appendClassCast(InvalidValueException.class, getJavaClass(cgSource));
			appendValueName(cgSource);
			append(";\n");
		}
		else {
			appendLocalStatements(cgSource);
			append("if (");
			if (cgSource.isGlobal()) {				// FIXME debugging
				appendValueName(cgSource);
			}
			else {
				appendValueName(cgSource);
			}
			append(" instanceof ");
			appendClassReference(InvalidValueException.class);
			append(") {\n");
			pushIndentation(null);
				append("throw ");
				appendClassCast(InvalidValueException.class, getJavaClass(cgSource));
				appendValueName(cgSource);
				append(";\n");
			popIndentation();
			append("}\n");
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGTupleExp(@NonNull CGTupleExp cgTupleExp) {
		List<CGTuplePart> parts = cgTupleExp.getParts();
		for (CGTuplePart cgPart : parts) {
			appendLocalStatements(cgPart.getValue());
		}
		appendDeclaration(cgTupleExp);
		append(" = ");
		appendClassReference(ValuesUtil.class);
		append(".createTupleOfEach(");
		appendReferenceTo(TupleTypeId.class, cgTupleExp.getTypeId());
		int iSize = parts.size();
		for (int i = 0; i < iSize; i++) {
			CGValuedElement cgPartValue = parts.get(i).getValue();
			append(", ");
			if ((cgPartValue.isNull()) && (iSize == 1)) {
				append("(Object)");						// Disambiguate Object... from Object[] 
			}
			appendValueName(cgPartValue);
		}
		append(");\n");
		return null;
	}

//	@Override
//	public @Nullable Object visitCGTuplePart(@NonNull CGTuplePart cgTuplePart) {
//		appendLocalStatements(cgTuplePart.getInit());
//		return null;
//	}

	@Override
	public @Nullable Object visitCGTuplePartCallExp(@NonNull CGTuplePartCallExp cgTuplePartCallExp) {
		CGValuedElement source = getExpression(cgTuplePartCallExp.getSource());
		CGTypeId resultType = cgTuplePartCallExp.getTypeId();
		Class<?> requiredBoxedReturnClass = context.getBoxedClass(resultType.getElementId());
		TuplePartId partId = cgTuplePartCallExp.getPivotTuplePartId();
		//
		appendLocalStatements(source);
		//
		appendDeclaration(cgTuplePartCallExp);
		append(" = ");
		appendClassCast(requiredBoxedReturnClass, Object.class);
		appendAtomicReferenceTo(TupleValue.class, source);
		append(".getValue(" + partId.getIndex() + "/*" + partId.getName() + "*/);\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGTypeId(@NonNull CGTypeId cgTypeId) {
		if (cgTypeId.isInlineable()) {
			appendIdReference(cgTypeId.getElementId());
		}
		else {
			super.visitCGTypeId(cgTypeId);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGTypeExp(@NonNull CGTypeExp cgTypeExp) {
//		getTypeVariable(cgTypeExp.getReferredType());
//		CGType type = cTypeExp.getReferredType();
//		if (type != null) {
//			type.accept(this);
//		}
		return null;
	}

	@Override
	public @Nullable Object visitCGUnboxExp(@NonNull CGUnboxExp cgUnboxExp) {
		CGValuedElement source = getExpression(cgUnboxExp.getSource());
		appendLocalStatements(source);
		Class<?> boxedClass = context.getBoxedClass(source.getPivotTypeId());
//		Class<?> unboxedClass = context.getUnboxedClass(cgUnboxExp.getPivotTypeId());
		appendDeclaration(cgUnboxExp);
		append(" = ");
		if (CollectionValue.class.isAssignableFrom(boxedClass)) {
//			appendAtomicReferenceTo(CollectionValue.class, source);
			appendValueName(source);
			append(".asEcoreObject()");
		}
		else if (IntegerValue.class.isAssignableFrom(boxedClass)) {
//			appendAtomicReferenceTo(IntegerValue.class, source);
			appendValueName(source);
			append(".asNumber()");
		}
		else if (RealValue.class.isAssignableFrom(boxedClass)) {
//			appendAtomicReferenceTo(RealValue.class, source);
			appendValueName(source);
			append(".asNumber()");
		}
		else if (EnumerationLiteralId.class.isAssignableFrom(boxedClass)) {
			appendReferenceTo(null, localContext.getIdResolverVariable());
			append(".unboxedValueOf(");
//			appendAtomicReferenceTo(EnumerationLiteralId.class, source);
			appendValueName(source);
			append(")");
		}
		else {
			append(cgUnboxExp.getName() + ".GET_UNBOXED_VALUE(");
//			appendReferenceTo(null, typeIdText);
			append(", \"" + boxedClass.getName() + "\")");
		}
		append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGVariable(@NonNull CGVariable cgVariable) {
		CGValuedElement init = cgVariable.getInit();
		if (init != null) {
			appendLocalStatements(init);
		}
//		appendDeclaration(cgVariable);
//		if (init != null) {
//			append(" = ");
//			appendValueName(init);
//		}
//		append(";\n");
		return null;
	}

	@Override
	public @Nullable Object visitCGVariableExp(@NonNull CGVariableExp cgVariableExp) {
//		CGValuedElement variable = cgVariableExp.getReferredVariable();
//		if (variable != null) {
//			variable.accept(this);
//		}
		return null;
	}

	@Override
	public @Nullable Object visitCGWhileExp(@NonNull CGWhileExp cgWhileExp) {
//		CGVariable resultVariable = localContext.getLocalVariable(cgWhileExp);
		CGValuedElement condition = getExpression(cgWhileExp.getCondition());
		CGValuedElement bodyExpression = getExpression(cgWhileExp.getBodyExpression());
		CGValuedElement finallyExpression = getExpression(cgWhileExp.getFinallyExpression());
//		Object conditionValue = condition.getConstantValue();
/*		if (conditionValue instanceof Boolean) {
			boolean constantCondition = ((Boolean)conditionValue).booleanValue();
			if (constantCondition) {
				appendExpression(resultVariableName, thenExpression);
			}
			else {
				appendExpression(resultVariableName, elseExpression);
			}
		}
		else if (conditionValue instanceof NullValue) {
			// FIXME
		}
		else if (conditionValue instanceof InvalidValue) {
			// FIXME
		}
		else { */
			append("while (true) {");
			pushIndentation(null);
				appendLocalStatements(condition);
				append("if (");
				appendValueName(condition);
				append(") {\n");
				pushIndentation(null);
					appendAssignment(cgWhileExp, bodyExpression);
				popIndentation();
				append("}\n");
				append("else {\n");
				pushIndentation(null);
					appendAssignment(cgWhileExp, finallyExpression);
					append("break;\n");
				popIndentation();
				append("}\n");
			popIndentation();
			append("}\n");
//		}
		return null;
	}
}
