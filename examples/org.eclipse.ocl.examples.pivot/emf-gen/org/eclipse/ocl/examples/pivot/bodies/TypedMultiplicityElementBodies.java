/**
 * <copyright>
 * 
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *************************************************************************
 * This code is 100% auto-generated
 * from: pivot
 * using: org.eclipse.ocl.examples.codegen.tables.model2tables.mtl
 *
 * Do not edit it.
 */
package org.eclipse.ocl.examples.pivot.bodies;

import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.StringValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * TypedMultiplicityElementBodies provides the Java implementation bodies of OCL-defined TypedMultiplicityElement operations and properties.
 */
@SuppressWarnings("nls")
public class TypedMultiplicityElementBodies
{

	/** 
	 * Implementation of the TypedMultiplicityElement::CompatibleBody '' <body>.
	 */
	public static class _CompatibleBody_body_ extends AbstractBinaryOperation
	{
		public static _CompatibleBody_body_ INSTANCE = new _CompatibleBody_body_();
	
		/*
		let bodyType : Type = bodySpecification.type
	in
	  if bodyType.oclIsKindOf(CollectionType)
	  then
	    let
	      bodyCollectionType : CollectionType = bodyType.oclAsType(CollectionType)
	    in
	      let bodyElementType : Type = bodyCollectionType.elementType
	      in
	        bodyElementType.conformsTo(self.type) and self.isOrdered =
	        (
	          bodyCollectionType.conformsTo(OrderedSet(OclAny)) or
	          bodyCollectionType.conformsTo(Sequence(OclAny))
	        ) and self.isUnique =
	        (
	          bodyCollectionType.conformsTo(OrderedSet(OclAny)) or
	          bodyCollectionType.conformsTo(Set(OclAny))
	        )
	  else bodyType.conformsTo(self.type)
	  endif
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self, final Value bodySpecification) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final Value T_ClassClassifier_Pivot_ecore__pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
			final ExecutorOperation O_OclType_conformsTo = OCLstdlibTables.Operations._OclType__conformsTo;
			final ExecutorType T_Pivot_ecore__pivot__Type = PivotTables.Types._Type;
			final ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final ExecutorOperation O_Boolean__eq_ = OCLstdlibTables.Operations._Boolean___eq_;
			final ExecutorProperty P_MultiplicityElement_isOrdered = PivotTables.Properties._MultiplicityElement__isOrdered;
			final LibraryProperty IP_MultiplicityElement_isOrdered = P_MultiplicityElement_isOrdered.getImplementation();
			final ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final Value T_CollectionClassifier_OrderedSet_OclAny__OclAny_ = valueFactory.createTypeValue(OCLstdlibTables.Types._OrderedSet);
			final Value T_CollectionClassifier_Sequence_OclAny__OclAny_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Sequence);
			final ExecutorProperty P_MultiplicityElement_isUnique = PivotTables.Properties._MultiplicityElement__isUnique;
			final LibraryProperty IP_MultiplicityElement_isUnique = P_MultiplicityElement_isUnique.getImplementation();
			final Value T_CollectionClassifier_Set_OclAny__OclAny_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Set);
			final ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final ExecutorType T_Pivot_ecore__pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			
			
			Value A_symbol_105 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, bodySpecification, P_TypedElement_type);
			
			final Value V_bodyType = A_symbol_105;
				
				DomainType static_A_symbol_106 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_106 = (LibraryBinaryOperation)static_A_symbol_106.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_106 = dynamic_A_symbol_106.evaluate(evaluator, T_Boolean, V_bodyType, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
			Value A_symbol_107;
			if (A_symbol_106.isTrue()) {
				
				DomainType static_A_symbol_108 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_108 = (LibraryBinaryOperation)static_A_symbol_108.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_108 = dynamic_A_symbol_108.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, V_bodyType, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				final Value V_bodyCollectionType = A_symbol_108;
				
				Value A_symbol_109 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, V_bodyCollectionType, P_CollectionType_elementType);
				
				final Value V_bodyElementType = A_symbol_109;
				Value leftA_symbol_110;
				try {
					Value leftA_symbol_111;
					try {
						
						
						Value A_symbol_112 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
						
						DomainType static_A_symbol_113 = valueFactory.typeOf(V_bodyElementType);
						LibraryBinaryOperation dynamic_A_symbol_113 = (LibraryBinaryOperation)static_A_symbol_113.lookupImplementation(standardLibrary, O_OclType_conformsTo);
						Value A_symbol_113 = dynamic_A_symbol_113.evaluate(evaluator, T_Boolean, V_bodyElementType, A_symbol_112);
						leftA_symbol_111 = A_symbol_113;
					} catch (InvalidValueException e) {
						leftA_symbol_111 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_113 = leftA_symbol_111;
					Value rightA_symbol_111;
					try {
						Value leftA_symbol_114;
						try {
							
							Value A_symbol_115 = IP_MultiplicityElement_isOrdered.evaluate(evaluator, T_Boolean, self, P_MultiplicityElement_isOrdered);
							
							leftA_symbol_114 = A_symbol_115;
						} catch (InvalidValueException e) {
							leftA_symbol_114 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_115 = leftA_symbol_114;
						Value rightA_symbol_114;
						try {
							Value leftA_symbol_116;
							try {
								
								DomainType static_A_symbol_117 = valueFactory.typeOf(V_bodyCollectionType);
								LibraryBinaryOperation dynamic_A_symbol_117 = (LibraryBinaryOperation)static_A_symbol_117.lookupImplementation(standardLibrary, O_OclType_conformsTo);
								Value A_symbol_117 = dynamic_A_symbol_117.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_OrderedSet_OclAny__OclAny_);
								leftA_symbol_116 = A_symbol_117;
							} catch (InvalidValueException e) {
								leftA_symbol_116 = valueFactory.createInvalidValue(e);
							}
							Value A_symbol_117 = leftA_symbol_116;
							Value rightA_symbol_116;
							try {
								
								DomainType static_A_symbol_118 = valueFactory.typeOf(V_bodyCollectionType);
								LibraryBinaryOperation dynamic_A_symbol_118 = (LibraryBinaryOperation)static_A_symbol_118.lookupImplementation(standardLibrary, O_OclType_conformsTo);
								Value A_symbol_118 = dynamic_A_symbol_118.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_Sequence_OclAny__OclAny_);
								rightA_symbol_116 = A_symbol_118;
							} catch (InvalidValueException e) {
								rightA_symbol_116 = valueFactory.createInvalidValue(e);
							}
							Value A_symbol_118 = rightA_symbol_116;
							DomainType static_A_symbol_116 = valueFactory.typeOf(A_symbol_117);
							LibraryBinaryOperation dynamic_A_symbol_116 = (LibraryBinaryOperation)static_A_symbol_116.lookupImplementation(standardLibrary, O_Boolean_or);
							Value A_symbol_116 = dynamic_A_symbol_116.evaluate(evaluator, T_Boolean, A_symbol_117, A_symbol_118);
							rightA_symbol_114 = A_symbol_116;
						} catch (InvalidValueException e) {
							rightA_symbol_114 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_116 = rightA_symbol_114;
						DomainType static_A_symbol_114 = valueFactory.typeOf(A_symbol_115, A_symbol_116);
						LibraryBinaryOperation dynamic_A_symbol_114 = (LibraryBinaryOperation)static_A_symbol_114.lookupImplementation(standardLibrary, O_Boolean__eq_);
						Value A_symbol_114 = dynamic_A_symbol_114.evaluate(evaluator, T_Boolean, A_symbol_115, A_symbol_116);
						rightA_symbol_111 = A_symbol_114;
					} catch (InvalidValueException e) {
						rightA_symbol_111 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_114 = rightA_symbol_111;
					DomainType static_A_symbol_111 = valueFactory.typeOf(A_symbol_113);
					LibraryBinaryOperation dynamic_A_symbol_111 = (LibraryBinaryOperation)static_A_symbol_111.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_111 = dynamic_A_symbol_111.evaluate(evaluator, T_Boolean, A_symbol_113, A_symbol_114);
					leftA_symbol_110 = A_symbol_111;
				} catch (InvalidValueException e) {
					leftA_symbol_110 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_111 = leftA_symbol_110;
				Value rightA_symbol_110;
				try {
					Value leftA_symbol_119;
					try {
						
						Value A_symbol_120 = IP_MultiplicityElement_isUnique.evaluate(evaluator, T_Boolean, self, P_MultiplicityElement_isUnique);
						
						leftA_symbol_119 = A_symbol_120;
					} catch (InvalidValueException e) {
						leftA_symbol_119 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_120 = leftA_symbol_119;
					Value rightA_symbol_119;
					try {
						Value leftA_symbol_121;
						try {
							
							DomainType static_A_symbol_122 = valueFactory.typeOf(V_bodyCollectionType);
							LibraryBinaryOperation dynamic_A_symbol_122 = (LibraryBinaryOperation)static_A_symbol_122.lookupImplementation(standardLibrary, O_OclType_conformsTo);
							Value A_symbol_122 = dynamic_A_symbol_122.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_OrderedSet_OclAny__OclAny_);
							leftA_symbol_121 = A_symbol_122;
						} catch (InvalidValueException e) {
							leftA_symbol_121 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_122 = leftA_symbol_121;
						Value rightA_symbol_121;
						try {
							
							DomainType static_A_symbol_123 = valueFactory.typeOf(V_bodyCollectionType);
							LibraryBinaryOperation dynamic_A_symbol_123 = (LibraryBinaryOperation)static_A_symbol_123.lookupImplementation(standardLibrary, O_OclType_conformsTo);
							Value A_symbol_123 = dynamic_A_symbol_123.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_Set_OclAny__OclAny_);
							rightA_symbol_121 = A_symbol_123;
						} catch (InvalidValueException e) {
							rightA_symbol_121 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_123 = rightA_symbol_121;
						DomainType static_A_symbol_121 = valueFactory.typeOf(A_symbol_122);
						LibraryBinaryOperation dynamic_A_symbol_121 = (LibraryBinaryOperation)static_A_symbol_121.lookupImplementation(standardLibrary, O_Boolean_or);
						Value A_symbol_121 = dynamic_A_symbol_121.evaluate(evaluator, T_Boolean, A_symbol_122, A_symbol_123);
						rightA_symbol_119 = A_symbol_121;
					} catch (InvalidValueException e) {
						rightA_symbol_119 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_121 = rightA_symbol_119;
					DomainType static_A_symbol_119 = valueFactory.typeOf(A_symbol_120, A_symbol_121);
					LibraryBinaryOperation dynamic_A_symbol_119 = (LibraryBinaryOperation)static_A_symbol_119.lookupImplementation(standardLibrary, O_Boolean__eq_);
					Value A_symbol_119 = dynamic_A_symbol_119.evaluate(evaluator, T_Boolean, A_symbol_120, A_symbol_121);
					rightA_symbol_110 = A_symbol_119;
				} catch (InvalidValueException e) {
					rightA_symbol_110 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_119 = rightA_symbol_110;
				DomainType static_A_symbol_110 = valueFactory.typeOf(A_symbol_111);
				LibraryBinaryOperation dynamic_A_symbol_110 = (LibraryBinaryOperation)static_A_symbol_110.lookupImplementation(standardLibrary, O_Boolean_and);
				Value A_symbol_110 = dynamic_A_symbol_110.evaluate(evaluator, T_Boolean, A_symbol_111, A_symbol_119);
				final Value A_symbol_124 = A_symbol_110;
				final Value A_symbol_125 = A_symbol_124;
				A_symbol_107 = A_symbol_125;
			}
			else if (A_symbol_106.isFalse()) {
				
				
				Value A_symbol_126 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_127 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_127 = (LibraryBinaryOperation)static_A_symbol_127.lookupImplementation(standardLibrary, O_OclType_conformsTo);
				Value A_symbol_127 = dynamic_A_symbol_127.evaluate(evaluator, T_Boolean, V_bodyType, A_symbol_126);
				A_symbol_107 = A_symbol_127;
			}
			else if (A_symbol_106.isNull()) {
				A_symbol_107 = valueFactory.throwInvalidValueException("null if condition");
			}
			else {
				A_symbol_107 = valueFactory.throwInvalidValueException("invalid if condition");
			}
			final Value A_symbol_128 = A_symbol_107;
			return A_symbol_128;
		}
	}

	/** 
	 * Implementation of the TypedMultiplicityElement::makeParameter '' <body>.
	 */
	public static class _makeParameter_body_ extends AbstractUnaryOperation
	{
		public static _makeParameter_body_ INSTANCE = new _makeParameter_body_();
	
		/*
		Parameter{name = 'name'}
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final StringValue S_name = valueFactory.stringValueOf("name");
			
			ObjectValue A_symbol_129 = PivotTables.Types._Parameter.createInstance(valueFactory);
			
			P_NamedElement_name.setValue(A_symbol_129, S_name);
			
			return A_symbol_129;
		}
	}
}

