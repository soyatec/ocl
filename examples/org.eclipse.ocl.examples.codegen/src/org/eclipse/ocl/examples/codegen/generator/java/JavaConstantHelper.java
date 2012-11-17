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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.CodeGenSnippet;
import org.eclipse.ocl.examples.codegen.generator.CodeGenText;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.generator.ConstantHelper;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.EnumerationLiteralValue;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.NumericValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.TypeValue;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.xtext.util.Strings;

/**
 * A ConstantHelper provides textual representations of constant values.
 */
public class JavaConstantHelper implements ConstantHelper
{
	protected final @NonNull CodeGenerator codeGenerator;
	protected final @NonNull MetaModelManager metaModelManager;
	
	public JavaConstantHelper(@NonNull CodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
		this.metaModelManager = codeGenerator.getMetaModelManager();
	}

	protected @NonNull CodeGenText configureLocalDependency(@NonNull CodeGenSnippet snippet, @NonNull Class<?> javaClass) {
//		snippet.setIsLocal();
		snippet.setJavaClass(javaClass);
		codeGenerator.addDependency(CodeGenerator.LOCAL_ROOT, snippet);
		String atNonNull = codeGenerator.atNonNull();
		String javaClassName = snippet.getJavaClassName();
		String name = snippet.getName();
		return snippet.append("final " + atNonNull + " " + javaClassName + " " + name + " = ");
	}

	protected @NonNull CodeGenText configureGlobalDependency(@NonNull CodeGenSnippet snippet, @NonNull Class<?> javaClass) {
//		snippet.setIsStatic();
		snippet.setJavaClass(javaClass);
		codeGenerator.addDependency(CodeGenerator.GLOBAL_ROOT, snippet);
		String atNonNull = codeGenerator.atNonNull();
		String javaClassName = snippet.getJavaClassName();
		String name = snippet.getName();
		return snippet.append("private static final " + atNonNull + " " + javaClassName + " " + name + " = ");
	}

	protected @NonNull CodeGenSnippet createBooleanSnippet(Object anObject) {
		String booleanText = ((Boolean)anObject).booleanValue() ? "Boolean.TRUE" : "Boolean.FALSE";
		CodeGenSnippet snippet = new JavaSnippet(booleanText, TypeId.BOOLEAN, Boolean.class, codeGenerator, "");
		snippet.setIsInlined();
//		snippet.setIsStatic();
		return snippet;
	}

	protected @NonNull CodeGenText createCollectionSnippet(@NonNull CollectionValue collectionValue) {
		Class<? extends CollectionValue> javaClass;
		if (collectionValue instanceof SetValue) {
			javaClass = SetValue.class;
		}
		else if (collectionValue instanceof BagValue) {
			javaClass = BagValue.class;
		}
		else if (collectionValue instanceof OrderedSetValue) {
			javaClass = OrderedSetValue.class;
		}
		else if (collectionValue instanceof SequenceValue) {
			javaClass = SequenceValue.class;
		}
		else {
			javaClass = CollectionValue.class;
		}
		CollectionTypeId collectionTypeId = collectionValue.getTypeId();
		CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", collectionTypeId, collectionValue);
		CodeGenText s = configureGlobalDependency(snippet, javaClass);
		String kind = collectionValue.getKind();
		String collectionTypeIdName = snippet.getSnippetName(collectionTypeId);
		Collection<? extends Object> elements = collectionValue.getElements();
		if ((elements instanceof IntegerRange) && (elements.size() > 1)){
			String rangeText = snippet.getSnippetName(elements);
			s.append("create" + kind + "Range(" + collectionTypeIdName + ", " + rangeText);
		}
		else {
			s.append("create" + kind + "Value(" + collectionTypeIdName);
			for (Object element : elements) {
				String elementText = snippet.getSnippetName(element);
				s.append(", ");
				if ((element == null) && (elements.size() == 1)) {
					s.append("(Object)");						// Disambiguate Object... from Iterable<?> 
				}
				s.append(elementText);
			}
		}
		s.append(")");
		return s;
	}

	protected @NonNull CodeGenText createEDataTypeSnippet(@NonNull ObjectValue objectValue, @NonNull EDataType eDataType) {
		//
		//	Availability of a GenPackage is mandatory since we must have an EFactory.createFromString method to do the construction.
		//
		TypeId typeId = objectValue.getTypeId();
		CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", typeId, objectValue);
		snippet.setIsUnboxed();
		Class<?> javaClass = eDataType.getInstanceClass();
		if (javaClass == null) {
			throw new IllegalStateException("No Java class for " + objectValue + " in JavaConstantHelper.createEDataTypeSnippet()");
		}
		CodeGenText s = configureGlobalDependency(snippet, javaClass);
		EPackage ePackage = eDataType.getEPackage();
		String nsURI = ePackage.getNsURI();
		if (nsURI == null) {
			throw new IllegalStateException("No EPackage NsURI for " + objectValue + " in JavaConstantHelper.createEDataTypeSnippet()");
		}
		GenPackage genPackage = metaModelManager.getGenPackage(nsURI);
		if (genPackage == null) {
			throw new IllegalStateException("No GenPackage for " + objectValue + " in JavaConstantHelper.createEDataTypeSnippet()");
		}
		String className = codeGenerator.getImportedName(javaClass);
		String eFactoryName = genPackage.getQualifiedFactoryInterfaceName();
		String ePackageName = genPackage.getQualifiedPackageInterfaceName();
		String dataTypeName = CodeGenUtil.upperName(eDataType.getName());
		try {
			ClassLoader classLoader = eDataType.getClass().getClassLoader();
			@SuppressWarnings("null") @NonNull Class<?> factoryClass = classLoader.loadClass(eFactoryName);
			@SuppressWarnings("null") @NonNull Class<?> packageClass = eDataType.getClass().getClassLoader().loadClass(ePackageName);
			String factoryClassName = codeGenerator.getImportedName(factoryClass);
			String packageClassName = codeGenerator.getImportedName(packageClass);
			s.append("(" + className + ")" + factoryClassName + ".eINSTANCE.createFromString(" + packageClassName + ".Literals." + dataTypeName + ", \"");
			EFactory eFactoryInstance = ePackage.getEFactoryInstance();
			Object object = objectValue.getObject();
			String partString = eFactoryInstance.convertToString(eDataType, object);
			if (partString != null) {
				@SuppressWarnings("null") @NonNull String javaString = Strings.convertToJavaString(partString);
				s.append(javaString);
			}
			s.append("\")");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Load class failure for " + objectValue + " in JavaConstantHelper.createEDataTypeSnippet()", e);
		}
		return s;
	}

	protected @NonNull CodeGenText createEObjectSnippet(@NonNull ObjectValue objectValue, @NonNull Type type) {
		CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", objectValue.getTypeId(), objectValue);
		CodeGenText s = configureGlobalDependency(snippet, ObjectValue.class);
		TypeId typeId = objectValue.getTypeId();
//		int iSize = tupleTypeId.getPartIds().length;
		String typeIdName = snippet.getSnippetName(typeId);
		s.append("createObjectValue(" + typeIdName);
/*		for (int i = 0; i < iSize; i++) {
			Object tuplePart = tupleValue.getValue(i);
			String elementText = snippet.getSnippetName(tuplePart);
			s.append(", ");
			if ((tuplePart == null) && (iSize == 1)) {
				s.append("(Object)");						// Disambiguate Object... from Map<?> 
			}
			s.append(elementText);
		} */
		s.append(")");
		return s;
	}

	protected @NonNull CodeGenText createEnumerationLiteralSnippet(@NonNull EnumerationLiteralValue enumerationLiteralValue) {
		TypeId typeId = enumerationLiteralValue.getTypeId();
		CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", typeId, enumerationLiteralValue);
		CodeGenText s = configureLocalDependency(snippet, EnumerationLiteralValue.class);
		String evaluatorName = codeGenerator.getEvaluatorName();
		String typeIdName = snippet.getSnippetName(enumerationLiteralValue.getEnumerationLiteralId());
		s.append("createEnumerationLiteralValue(" + evaluatorName + ".getIdResolver().getEnumerationLiteral(" + typeIdName + ", null))");	
		return s;
	}
	
	protected @NonNull CodeGenText createIntegerLiteralSnippet(@NonNull IntegerValue integerValue) {
		CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", TypeId.INTEGER, integerValue);
		CodeGenText s = configureGlobalDependency(snippet, IntegerValue.class);
		s.append("integerValueOf(");
		String valueString = integerValue.toString();
		assert valueString != null;
		if (integerValue instanceof IntIntegerValueImpl) {
			s.append(valueString);
		}
		else if (integerValue instanceof LongIntegerValueImpl) {
			s.append(valueString + "L");
		}
		else {
			s.append("\"" + valueString + "\"");
		}
		s.append(")");
		return s;
	}

	protected @NonNull CodeGenText createIntegerRangeSnippet(@NonNull IntegerRange integerRange) {
		CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", TypeId.OCL_ANY, integerRange);		// FIXME narrower TypeId
		CodeGenText s = configureGlobalDependency(snippet, IntegerRange.class);
		String firstName = snippet.getSnippetName(integerRange.getFirst());
		String lastName = snippet.getSnippetName(integerRange.getLast());
		s.append("createRange(" + firstName + ", " + lastName + ")");
		return s;
	}

	protected @NonNull CodeGenSnippet createInvalidSnippet(Object anObject) {
		String text;
		InvalidValueException exception = ((InvalidValue)anObject).getException();
		if (exception == ValuesUtil.INVALID_VALUE.getException()) {
			text = "INVALID_VALUE";
		}
		else {
			text = "new " + codeGenerator.getImportedName(InvalidValueImpl.class) + "(" + Strings.convertToJavaString(exception.getMessage()) + ")";
		}
		CodeGenSnippet snippet = new JavaSnippet(text, TypeId.OCL_INVALID, InvalidValue.class, codeGenerator, "");
		snippet.setIsInlined();
//		snippet.setIsStatic();
		return snippet;
	}
	
	protected @NonNull CodeGenText createNonInlineSnippet(@Nullable Object aConstant) {
		if (aConstant instanceof NumericValue) {
			return createNumericSnippet((NumericValue)aConstant);
		}
		else if (aConstant instanceof CollectionValue) {
			return createCollectionSnippet((CollectionValue) aConstant);
		}
		else if (aConstant instanceof EnumerationLiteralValue) {
			return createEnumerationLiteralSnippet((EnumerationLiteralValue)aConstant);
		}
		else if (aConstant instanceof IntegerRange) {
			return createIntegerRangeSnippet((IntegerRange) aConstant);
		}
		else if (aConstant instanceof Number) {
			return createNumberLiteralSnippet((Number)aConstant);
		}
		else if (aConstant instanceof ObjectValue) {
			ObjectValue objectValue = (ObjectValue)aConstant;
			TypeId typeId = objectValue.getTypeId();
			DomainType domainType = metaModelManager.getIdResolver().getType(typeId, null);
			Type type = metaModelManager.getType(domainType);
			if (type instanceof DataType) {
				EDataType eDataType = metaModelManager.getEcoreOfPivot(EDataType.class, type);
				if (eDataType == null) {
					throw new IllegalStateException("No EDataType for " + type + " in JavaConstantHelper.createNonInlineSnippet()");
				}
				return createEDataTypeSnippet(objectValue, eDataType);
			}
			else {
				return createEObjectSnippet(objectValue, type);
			}
		}
		else  if (aConstant instanceof String) {
			return createStringLiteralSnippet((String)aConstant);
		}
		else if (aConstant instanceof TupleValue) {
			return createTupleSnippet((TupleValue)aConstant);
		}
		else if (aConstant instanceof TypeValue) {
			return createTypeSnippet((TypeValue)aConstant);
		}
		else if (aConstant != null) {
			throw new IllegalArgumentException("Unknown " + aConstant.getClass().getName() + " for JavaConstantHelper.createNonInlineSnippet()");
		}
		else {
			throw new IllegalArgumentException("Unknown null for JavaConstantHelper.createNonInlineSnippet()");
		}
	}

	protected @NonNull CodeGenSnippet createNullValue() {
		CodeGenSnippet snippet = new JavaSnippet("null", TypeId.OCL_VOID, null, codeGenerator, "");
		snippet.setIsInlined();
//		snippet.setIsStatic();
		return snippet;
	}

	protected @NonNull CodeGenText createNumberLiteralSnippet(@NonNull Number number) {
		if (number instanceof BigInteger) {
			return createIntegerLiteralSnippet(ValuesUtil.integerValueOf((BigInteger)number));
		}
		else if ((number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
			assert number != null;
			return createIntegerLiteralSnippet(ValuesUtil.integerValueOf(number.longValue()));
		}
		else if (number instanceof BigDecimal) {
			return createRealLiteralSnippet(ValuesUtil.realValueOf((BigDecimal)number));
		}
		else if ((number instanceof Double) || (number instanceof Float)) {
			assert number != null;
			return createRealLiteralSnippet(ValuesUtil.realValueOf(number.doubleValue()));
		}
		else if (number instanceof Unlimited) {
			CodeGenSnippet snippet = new JavaSnippet("UNLIMITED_VALUE", TypeId.UNLIMITED_NATURAL, UnlimitedValue.class, codeGenerator, "");
			CodeGenText s = configureGlobalDependency(snippet, UnlimitedValue.class);
			s.append("UNLIMITED_VALUE");
			return s;
		}
		else {
			throw new IllegalArgumentException("Unknown " + number.getClass().getName() + " for JavSnippetntHelper.createNumberLiteralSnippet()");
		}
	}

	protected @NonNull CodeGenText createNumericSnippet(@NonNull NumericValue numericValue) {
		if (numericValue instanceof IntegerValue) {
			return createIntegerLiteralSnippet((IntegerValue) numericValue);
		}
		else if (numericValue instanceof RealValue) {
			return createRealLiteralSnippet((RealValue) numericValue);
		}
		else {
			throw new IllegalArgumentException("Unknown " + numericValue.getClass().getName() + " for JavaConstantHelper.createNumericSnippet()");
		}
	}

	protected @NonNull CodeGenText createRealLiteralSnippet(@NonNull RealValue realValue) {
		CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", TypeId.REAL, realValue);
		CodeGenText s = configureGlobalDependency(snippet, RealValue.class);
		s.append("realValueOf(");
		Number realNumber = realValue.asNumber();
		String valueString = realNumber.toString();
		if (realNumber instanceof Double) {
			s.append(valueString + "d");
		}
		else {
			s.append("\"" + valueString + "\"");
		}
		s.append(")");
		return s;
	}

	public @NonNull CodeGenSnippet createSnippet(@Nullable Object anObject) {
		if (anObject == null) {
			return createNullValue();
		}
		else if (anObject instanceof Boolean) {
			return createBooleanSnippet(anObject);
		}
		else if (anObject == ValuesUtil.UNLIMITED_VALUE) {
			return createUnlimitedSnippet();
		}
		else if (anObject instanceof InvalidValue) {
			return createInvalidSnippet(anObject);
		}
		else {
			CodeGenText cgText = createNonInlineSnippet(anObject);
			cgText.append(";\n");
			return cgText.getSnippet();
		}
	}
	
	protected @NonNull CodeGenText createStringLiteralSnippet(@NonNull String aString) {
		CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", TypeId.STRING, aString);
		CodeGenText s = configureGlobalDependency(snippet, String.class);
		s.append('"' + Strings.convertToJavaString(aString) + '"');
		return s;
	}

	protected @NonNull CodeGenText createTupleSnippet(@NonNull TupleValue tupleValue) {
		TupleTypeId tupleTypeId = tupleValue.getTypeId();
		CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", tupleTypeId, tupleValue);
		CodeGenText s = configureGlobalDependency(snippet, TupleValue.class);
		int iSize = tupleTypeId.getPartIds().length;
		String tupleTypeIdName = snippet.getSnippetName(tupleTypeId);
		s.append("createTupleValue(" + tupleTypeIdName);
		for (int i = 0; i < iSize; i++) {
			Object tuplePart = tupleValue.getValue(i);
			String elementText = snippet.getSnippetName(tuplePart);
			s.append(", ");
			if ((tuplePart == null) && (iSize == 1)) {
				s.append("(Object)");						// Disambiguate Object... from Map<?> 
			}
			s.append(elementText);
		}
		s.append(")");
		return s;
	}

	protected @NonNull CodeGenText createTypeSnippet(@NonNull TypeValue typeValue) {
		TypeId typeId = typeValue.getTypeId();
		CodeGenSnippet snippet = new JavaSnippet(codeGenerator, "", typeId, typeValue);
		CodeGenText s = configureLocalDependency(snippet, TypeValue.class);
		String evaluatorName = codeGenerator.getEvaluatorName();
		String typeIdName = snippet.getSnippetName(typeValue.getInstanceType().getTypeId());
		s.append("createTypeValue(" + evaluatorName + ".getIdResolver().getType(" + typeIdName + ", null))");	
		return s;
	}

	protected @NonNull CodeGenSnippet createUnlimitedSnippet() {
		CodeGenSnippet snippet = new JavaSnippet("UNLIMITED_VALUE", TypeId.UNLIMITED_NATURAL, UnlimitedValue.class, codeGenerator, "");
		snippet.setIsInlined();
//		snippet.setIsStatic();
		return snippet;
	}
}
