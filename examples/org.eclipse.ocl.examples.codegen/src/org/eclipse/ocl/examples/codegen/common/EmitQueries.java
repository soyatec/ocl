/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
package org.eclipse.ocl.examples.codegen.common;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class EmitQueries
{
	/**
	 * The known classes that templates may use in unqualified form. The list is here
	 * in a Java form to reduce the impact of refactoring on Acceleo templates.
	 */
	public static final @NonNull Class<?>[] knownClasses = {
		java.lang.Class.class,
		java.lang.Object.class,
		java.lang.Package.class,
		java.util.Iterator.class,
		org.eclipse.ocl.examples.domain.elements.DomainElement.class,
		org.eclipse.ocl.examples.domain.elements.DomainMetaclass.class,
		org.eclipse.ocl.examples.domain.elements.DomainCollectionType.class,
		org.eclipse.ocl.examples.domain.elements.DomainParameterTypes.class,
		org.eclipse.ocl.examples.domain.elements.DomainProperty.class,
		org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary.class,
		org.eclipse.ocl.examples.domain.elements.DomainTupleType.class,
		org.eclipse.ocl.examples.domain.elements.DomainType.class,
		org.eclipse.ocl.examples.domain.elements.DomainTypeParameters.class,
		org.eclipse.ocl.examples.domain.elements.DomainTypedElement.class,
		org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator.class,
		org.eclipse.ocl.examples.domain.ids.ClassId.class,
		org.eclipse.ocl.examples.domain.ids.CollectionTypeId.class,
		org.eclipse.ocl.examples.domain.ids.DataTypeId.class,
		org.eclipse.ocl.examples.domain.ids.EnumerationId.class,
		org.eclipse.ocl.examples.domain.ids.IdManager.class,
		org.eclipse.ocl.examples.domain.ids.MetaclassId.class,
		org.eclipse.ocl.examples.domain.ids.PackageId.class,
		org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId.class,
		org.eclipse.ocl.examples.domain.ids.TemplateParameterId.class,
		org.eclipse.ocl.examples.domain.ids.TuplePartId.class,
		org.eclipse.ocl.examples.domain.ids.TupleTypeId.class,
		org.eclipse.ocl.examples.domain.ids.TypeId.class,
		org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation.class,
		org.eclipse.ocl.examples.domain.library.AbstractProperty.class,
		org.eclipse.ocl.examples.domain.library.AbstractTernaryOperation.class,
		org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation.class,
		org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation.class,
		org.eclipse.ocl.examples.domain.library.LibraryIteration.class,
		org.eclipse.ocl.examples.domain.library.LibraryProperty.class,
		org.eclipse.ocl.examples.domain.library.LibraryTernaryOperation.class,
		org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation.class,
		org.eclipse.ocl.examples.domain.messages.EvaluatorMessages.class,
		org.eclipse.ocl.examples.domain.values.BagValue.class,
		org.eclipse.ocl.examples.domain.values.CollectionValue.class,
		org.eclipse.ocl.examples.domain.values.IntegerRange.class,
		org.eclipse.ocl.examples.domain.values.IntegerValue.class,
		org.eclipse.ocl.examples.domain.values.InvalidValue.class,
		org.eclipse.ocl.examples.domain.values.OrderedSetValue.class,
		org.eclipse.ocl.examples.domain.values.RealValue.class,
		org.eclipse.ocl.examples.domain.values.SequenceValue.class,
		org.eclipse.ocl.examples.domain.values.SetValue.class,
		org.eclipse.ocl.examples.domain.values.TupleValue.class,
		org.eclipse.ocl.examples.domain.values.UnlimitedValue.class,
		org.eclipse.ocl.examples.domain.values.Value.class,
		org.eclipse.ocl.examples.domain.values.impl.InvalidValueException.class,
		org.eclipse.ocl.examples.domain.values.util.ValuesUtil.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumeration.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumerationLiteral.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorInvalidType.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorPackage.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorProperty.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorType.class,
		org.eclipse.ocl.examples.library.ecore.EcoreExecutorVoidType.class,
		org.eclipse.ocl.examples.library.executor.ExecutorDoubleIterationManager.class,
		org.eclipse.ocl.examples.library.executor.ExecutorFragment.class,
		org.eclipse.ocl.examples.library.executor.ExecutorLambdaType.class,
		org.eclipse.ocl.examples.library.executor.ExecutorOperation.class,
		org.eclipse.ocl.examples.library.executor.ExecutorProperty.class,
		org.eclipse.ocl.examples.library.executor.ExecutorPropertyWithImplementation.class,
		org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager.class,
		org.eclipse.ocl.examples.library.executor.ExecutorSpecializedType.class,
		org.eclipse.ocl.examples.library.executor.ExecutorStandardLibrary.class,
		org.eclipse.ocl.examples.library.executor.ExecutorType.class,
		org.eclipse.ocl.examples.library.executor.ExecutorTypeParameter.class,
		org.eclipse.ocl.examples.pivot.PivotPackage.class,
		org.eclipse.osgi.util.NLS.class
	};

	public static Map<String, String> computeKnown2ExternalMap(String knownImports) {
		Map<String, String> known2external = new HashMap<String, String>();
		for (String knownClass : knownImports.split("\\n")) {
			String trimmed = knownClass.trim();
			if (trimmed.length() > 0) {
				String lastSegment = trimmed.substring(trimmed.lastIndexOf(".")+1);
				known2external.put(lastSegment, trimmed);
				known2external.put(trimmed, trimmed);
			}
		}
		return known2external;
	}	

	public String debug(Object element, String context) {
		return null;
	}
	
	/**
	 * Evaluate a constant-expression, folding it to a constant value
	 */
	public OCLExpression evaluate(@NonNull OCLExpression expression) {
		MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(expression);
		PivotEnvironmentFactory factory = new PivotEnvironmentFactory(null, metaModelManager);
		Environment env = factory.createEnvironment();
		EvaluationEnvironment evalEnv = factory.createEvaluationEnvironment();
		DomainModelManager modelManager = evalEnv.createModelManager(null);
		EvaluationVisitorImpl evaluator = new EvaluationVisitorImpl(env, evalEnv, modelManager);
		Object constantResult = expression.accept(evaluator);		
		return createConstant(constantResult, metaModelManager);
	}
	
	private OCLExpression createConstant(Object value, MetaModelManager metaModelManager) {
		if (value instanceof String) {
			StringLiteralExp result = PivotFactory.eINSTANCE.createStringLiteralExp();
			result.setStringSymbol((String)value);
			result.setType(metaModelManager.getStringType());
			return result;
		}
		else if (value instanceof Boolean) {
			BooleanLiteralExp result = PivotFactory.eINSTANCE.createBooleanLiteralExp();
			result.setBooleanSymbol((Boolean)value);
			result.setType(metaModelManager.getBooleanType());
			return result;
		}
		else if (value == null) {
			NullLiteralExp result = PivotFactory.eINSTANCE.createNullLiteralExp();
			result.setType(metaModelManager.getOclVoidType());
			return result;
		}
		else if (value instanceof RealValue) {
			RealLiteralExp result = PivotFactory.eINSTANCE.createRealLiteralExp();
			result.setRealSymbol(((RealValue)value).asNumber());
			result.setType(metaModelManager.getRealType());
			return result;
		}
		else if (value instanceof IntegerValue) {
			IntegerLiteralExp result = PivotFactory.eINSTANCE.createIntegerLiteralExp();
			result.setIntegerSymbol(((IntegerValue)value).asNumber());
			result.setType(metaModelManager.getIntegerType());
			return result;
		}
		else if (value instanceof UnlimitedValue) {
			UnlimitedNaturalLiteralExp result = PivotFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
			result.setUnlimitedNaturalSymbol(-1);
			result.setType(metaModelManager.getUnlimitedNaturalType());
			return result;
		}
		else if (value instanceof CollectionValue) {
			CollectionValue collectionValue = (CollectionValue)value;
			CollectionLiteralExp result = PivotFactory.eINSTANCE.createCollectionLiteralExp();
			CollectionType type = (CollectionType) metaModelManager.getIdResolver().getDynamicTypeOf(collectionValue);
			result.setType(type);
			result.setKind(PivotUtil.getCollectionKind(type));
			for (Object element : collectionValue.getElements()) {
				CollectionItem part = PivotFactory.eINSTANCE.createCollectionItem();
				part.setItem(createConstant(element, metaModelManager));
				result.getPart().add(part);
			}
			return result;
		}
		throw new UnsupportedOperationException(value.getClass().getName());
	}

	/**
	 * Replace all embedded <%xxx%> embedded import paths using unqualified names
	 * for knownImports by fully qualified names so that the return value may be
	 * correctly processed by the GenModel ImportManager.
	 * prefix the return with corresponding Java import declarations.
	 */
	public static String expandKnownImports(String knownImports, String markedUpDocument) {
		Map<String, String> known2external = computeKnown2ExternalMap(knownImports);
		String[] splits = markedUpDocument.split("(\\<%)|(%\\>)");	
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < splits.length; i += 2) {
			s.append(splits[i]);
			if (i+1 < splits.length) {
				String candidate = splits[i+1].trim();
				String knownImport = known2external.get(candidate);
				s.append("<%");
				s.append(knownImport != null ? knownImport : candidate);
				s.append("%>");
			}
		}		
		return s.toString();
	}
	
	public String knownImports() {
		StringBuilder s = new StringBuilder();
		for (Class<?> knownClass : knownClasses) {
			s.append(knownClass.getName());
			s.append("\n");
		}
		return s.toString();
	}
	
	protected String integerValueOfInitializer(Number number) {
		IntegerValue value;
		if (number instanceof Integer){
			 value = ValuesUtil.integerValueOf(number.intValue());
		}
		else if (number instanceof Long) {
			 value = ValuesUtil.integerValueOf(number.longValue());
		}
		else if (number instanceof BigInteger) {
			 value = ValuesUtil.integerValueOf((BigInteger)number);
		}
		else {
			 return "\"\"";
		}
		if (value instanceof IntIntegerValueImpl) {
			return value.toString();
		}
		else if (value instanceof LongIntegerValueImpl) {
			return value.toString() + "L";
		}
		else {
			return "\"" + value.toString() + "\"";
		}
	}
	
	public String integerValueOfInitializer(IntegerLiteralExp literal) {
		return integerValueOfInitializer(literal.getIntegerSymbol());
	}
	
	public String integerValueOfInitializer(UnlimitedNaturalLiteralExp literal) {
		return integerValueOfInitializer(literal.getUnlimitedNaturalSymbol());
	}
	
	/**
	 * Replace all embedded <%xxx%> embedded import paths by shorter names and
	 * prefix the return with correspondinbg Java import declarations.
	 */
	public String prefixImports(String knownImports, String markedUpDocument) {
		/*
		 * Map of known short internal name to external name.
		 */
		Map<String, String> known2external = computeKnown2ExternalMap(knownImports);
		String[] splits = markedUpDocument.split("(\\<%)|(%\\>)");	
		/*
		 * Map of full external name to short internal name. The short internal name is the full name if
		 * there is any ambiguity.
		 */
		Map<String, String> external2internal = new HashMap<String, String>();
		/*
		 * Map of short internal name to full external name or null if there is an ambiguity.
		 */
		Map<String, String> internal2external = new HashMap<String, String>();
		
		for (int i = 1; i < splits.length; i += 2) {
			external2internal.put(splits[i].trim(), null);
		}
		
		ArrayList<String> candidates = new ArrayList<String>(external2internal.keySet());
		for (String candidate : candidates) {
			String lastSegment = candidate.substring(candidate.lastIndexOf(".")+1);
			String knownClass = known2external.get(candidate);
			if (knownClass != null) {
				if (knownClass.equals(candidate) || lastSegment.equals(candidate)) {
					internal2external.put(lastSegment, knownClass);
					external2internal.put(knownClass, lastSegment);
					external2internal.put(lastSegment, lastSegment);
				}
				else {
					external2internal.put(candidate, candidate);
				}
			}
			else {
				if (!internal2external.containsKey(lastSegment)) {
					internal2external.put(lastSegment, candidate);
					external2internal.put(candidate, lastSegment);
				}
				else {
					String oldExternal = internal2external.get(lastSegment);
					if (oldExternal != null) {
						external2internal.put(oldExternal, oldExternal);
						internal2external.put(lastSegment, null);
					}
					external2internal.put(candidate, candidate);
				}
			}
		}
		
		List<String> allValues = new ArrayList<String>(internal2external.values());
		allValues.remove(null);
		Collections.sort(allValues);
		StringBuilder s = new StringBuilder();
		for (String externalPath : allValues) {
			s.append("import ");
			s.append(externalPath);
			s.append(";\n");
		}
		s.append("\n");
		for (int i = 0; i < splits.length; i += 2) {
			s.append(splits[i]);
			if (i+1 < splits.length) {
				String candidate = splits[i+1].trim();
				s.append(external2internal.get(candidate));
			}
		}		
		return s.toString();
	}
	
	public String realValueOfInitializer(RealLiteralExp literal) {
		Number number = literal.getRealSymbol();
		if (number instanceof Double) {
			return number.toString() + "d";
		}
		return "\"" + number.toString() + "\"";
	}}
