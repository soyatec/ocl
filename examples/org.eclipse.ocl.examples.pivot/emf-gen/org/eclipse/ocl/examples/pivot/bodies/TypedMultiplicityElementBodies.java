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

import org.eclipse.jdt.annotation.NonNull;
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
		public static @NonNull _CompatibleBody_body_ INSTANCE = new _CompatibleBody_body_();
	
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
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self, final @NonNull Value bodySpecification) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_OclAny_oclIsKindOf = OCLstdlibTables.Operations._OclAny__oclIsKindOf;
			final @NonNull Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final @NonNull ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
			final @NonNull ExecutorOperation O_OclType_conformsTo = OCLstdlibTables.Operations._OclType__conformsTo;
			final @NonNull ExecutorType T_Type = OCLstdlibTables.Types._Type;
			final @NonNull ExecutorProperty P_TypedElement_type = PivotTables.Properties._TypedElement__type;
			final @NonNull LibraryProperty IP_TypedElement_type = P_TypedElement_type.getImplementation();
			final @NonNull ExecutorOperation O_Boolean__eq_ = OCLstdlibTables.Operations._Boolean___eq_;
			final @NonNull ExecutorProperty P_MultiplicityElement_isOrdered = PivotTables.Properties._MultiplicityElement__isOrdered;
			final @NonNull LibraryProperty IP_MultiplicityElement_isOrdered = P_MultiplicityElement_isOrdered.getImplementation();
			final @NonNull ExecutorOperation O_Boolean_or = OCLstdlibTables.Operations._Boolean__or;
			final @NonNull Value T_CollectionClassifier_OrderedSet_OclAny__OclAny_ = valueFactory.createTypeValue(OCLstdlibTables.Types._OrderedSet);
			final @NonNull Value T_CollectionClassifier_Sequence_OclAny__OclAny_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Sequence);
			final @NonNull ExecutorProperty P_MultiplicityElement_isUnique = PivotTables.Properties._MultiplicityElement__isUnique;
			final @NonNull LibraryProperty IP_MultiplicityElement_isUnique = P_MultiplicityElement_isUnique.getImplementation();
			final @NonNull Value T_CollectionClassifier_Set_OclAny__OclAny_ = valueFactory.createTypeValue(OCLstdlibTables.Types._Set);
			final @NonNull ExecutorProperty P_CollectionType_elementType = PivotTables.Properties._CollectionType__elementType;
			final @NonNull LibraryProperty IP_CollectionType_elementType = P_CollectionType_elementType.getImplementation();
			final @NonNull ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final @NonNull ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			
			
			Value A_symbol_6 = IP_TypedElement_type.evaluate(evaluator, T_Type, bodySpecification, P_TypedElement_type);
			
			final @NonNull Value V_bodyType = A_symbol_6;
				
				DomainType static_A_symbol_7 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_7 = (LibraryBinaryOperation)static_A_symbol_7.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_7 = dynamic_A_symbol_7.evaluate(evaluator, T_Boolean, V_bodyType, T_ClassClassifier_pivot__CollectionType_);
			Value A_symbol_8;
			if (A_symbol_7.isTrue()) {
				
				DomainType static_A_symbol_9 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_9 = (LibraryBinaryOperation)static_A_symbol_9.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_9 = dynamic_A_symbol_9.evaluate(evaluator, T_pivot__CollectionType, V_bodyType, T_ClassClassifier_pivot__CollectionType_);
				final @NonNull Value V_bodyCollectionType = A_symbol_9;
				
				Value A_symbol_10 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, V_bodyCollectionType, P_CollectionType_elementType);
				
				final @NonNull Value V_bodyElementType = A_symbol_10;
				Value leftA_symbol_11;
				try {
					Value leftA_symbol_12;
					try {
						
						
						Value A_symbol_13 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
						
						DomainType static_A_symbol_14 = valueFactory.typeOf(V_bodyElementType);
						LibraryBinaryOperation dynamic_A_symbol_14 = (LibraryBinaryOperation)static_A_symbol_14.lookupImplementation(standardLibrary, O_OclType_conformsTo);
						Value A_symbol_14 = dynamic_A_symbol_14.evaluate(evaluator, T_Boolean, V_bodyElementType, A_symbol_13);
						leftA_symbol_12 = A_symbol_14;
					} catch (InvalidValueException e) {
						leftA_symbol_12 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_14 = leftA_symbol_12;
					Value rightA_symbol_12;
					try {
						Value leftA_symbol_15;
						try {
							
							Value A_symbol_16 = IP_MultiplicityElement_isOrdered.evaluate(evaluator, T_Boolean, self, P_MultiplicityElement_isOrdered);
							
							leftA_symbol_15 = A_symbol_16;
						} catch (InvalidValueException e) {
							leftA_symbol_15 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_16 = leftA_symbol_15;
						Value rightA_symbol_15;
						try {
							Value leftA_symbol_17;
							try {
								
								DomainType static_A_symbol_18 = valueFactory.typeOf(V_bodyCollectionType);
								LibraryBinaryOperation dynamic_A_symbol_18 = (LibraryBinaryOperation)static_A_symbol_18.lookupImplementation(standardLibrary, O_OclType_conformsTo);
								Value A_symbol_18 = dynamic_A_symbol_18.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_OrderedSet_OclAny__OclAny_);
								leftA_symbol_17 = A_symbol_18;
							} catch (InvalidValueException e) {
								leftA_symbol_17 = valueFactory.createInvalidValue(e);
							}
							Value A_symbol_18 = leftA_symbol_17;
							Value rightA_symbol_17;
							try {
								
								DomainType static_A_symbol_19 = valueFactory.typeOf(V_bodyCollectionType);
								LibraryBinaryOperation dynamic_A_symbol_19 = (LibraryBinaryOperation)static_A_symbol_19.lookupImplementation(standardLibrary, O_OclType_conformsTo);
								Value A_symbol_19 = dynamic_A_symbol_19.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_Sequence_OclAny__OclAny_);
								rightA_symbol_17 = A_symbol_19;
							} catch (InvalidValueException e) {
								rightA_symbol_17 = valueFactory.createInvalidValue(e);
							}
							Value A_symbol_19 = rightA_symbol_17;
							DomainType static_A_symbol_17 = valueFactory.typeOf(A_symbol_18);
							LibraryBinaryOperation dynamic_A_symbol_17 = (LibraryBinaryOperation)static_A_symbol_17.lookupImplementation(standardLibrary, O_Boolean_or);
							Value A_symbol_17 = dynamic_A_symbol_17.evaluate(evaluator, T_Boolean, A_symbol_18, A_symbol_19);
							rightA_symbol_15 = A_symbol_17;
						} catch (InvalidValueException e) {
							rightA_symbol_15 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_17 = rightA_symbol_15;
						DomainType static_A_symbol_15 = valueFactory.typeOf(A_symbol_16, A_symbol_17);
						LibraryBinaryOperation dynamic_A_symbol_15 = (LibraryBinaryOperation)static_A_symbol_15.lookupImplementation(standardLibrary, O_Boolean__eq_);
						Value A_symbol_15 = dynamic_A_symbol_15.evaluate(evaluator, T_Boolean, A_symbol_16, A_symbol_17);
						rightA_symbol_12 = A_symbol_15;
					} catch (InvalidValueException e) {
						rightA_symbol_12 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_15 = rightA_symbol_12;
					DomainType static_A_symbol_12 = valueFactory.typeOf(A_symbol_14);
					LibraryBinaryOperation dynamic_A_symbol_12 = (LibraryBinaryOperation)static_A_symbol_12.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_12 = dynamic_A_symbol_12.evaluate(evaluator, T_Boolean, A_symbol_14, A_symbol_15);
					leftA_symbol_11 = A_symbol_12;
				} catch (InvalidValueException e) {
					leftA_symbol_11 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_12 = leftA_symbol_11;
				Value rightA_symbol_11;
				try {
					Value leftA_symbol_20;
					try {
						
						Value A_symbol_21 = IP_MultiplicityElement_isUnique.evaluate(evaluator, T_Boolean, self, P_MultiplicityElement_isUnique);
						
						leftA_symbol_20 = A_symbol_21;
					} catch (InvalidValueException e) {
						leftA_symbol_20 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_21 = leftA_symbol_20;
					Value rightA_symbol_20;
					try {
						Value leftA_symbol_22;
						try {
							
							DomainType static_A_symbol_23 = valueFactory.typeOf(V_bodyCollectionType);
							LibraryBinaryOperation dynamic_A_symbol_23 = (LibraryBinaryOperation)static_A_symbol_23.lookupImplementation(standardLibrary, O_OclType_conformsTo);
							Value A_symbol_23 = dynamic_A_symbol_23.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_OrderedSet_OclAny__OclAny_);
							leftA_symbol_22 = A_symbol_23;
						} catch (InvalidValueException e) {
							leftA_symbol_22 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_23 = leftA_symbol_22;
						Value rightA_symbol_22;
						try {
							
							DomainType static_A_symbol_24 = valueFactory.typeOf(V_bodyCollectionType);
							LibraryBinaryOperation dynamic_A_symbol_24 = (LibraryBinaryOperation)static_A_symbol_24.lookupImplementation(standardLibrary, O_OclType_conformsTo);
							Value A_symbol_24 = dynamic_A_symbol_24.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_Set_OclAny__OclAny_);
							rightA_symbol_22 = A_symbol_24;
						} catch (InvalidValueException e) {
							rightA_symbol_22 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_24 = rightA_symbol_22;
						DomainType static_A_symbol_22 = valueFactory.typeOf(A_symbol_23);
						LibraryBinaryOperation dynamic_A_symbol_22 = (LibraryBinaryOperation)static_A_symbol_22.lookupImplementation(standardLibrary, O_Boolean_or);
						Value A_symbol_22 = dynamic_A_symbol_22.evaluate(evaluator, T_Boolean, A_symbol_23, A_symbol_24);
						rightA_symbol_20 = A_symbol_22;
					} catch (InvalidValueException e) {
						rightA_symbol_20 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_22 = rightA_symbol_20;
					DomainType static_A_symbol_20 = valueFactory.typeOf(A_symbol_21, A_symbol_22);
					LibraryBinaryOperation dynamic_A_symbol_20 = (LibraryBinaryOperation)static_A_symbol_20.lookupImplementation(standardLibrary, O_Boolean__eq_);
					Value A_symbol_20 = dynamic_A_symbol_20.evaluate(evaluator, T_Boolean, A_symbol_21, A_symbol_22);
					rightA_symbol_11 = A_symbol_20;
				} catch (InvalidValueException e) {
					rightA_symbol_11 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_20 = rightA_symbol_11;
				DomainType static_A_symbol_11 = valueFactory.typeOf(A_symbol_12);
				LibraryBinaryOperation dynamic_A_symbol_11 = (LibraryBinaryOperation)static_A_symbol_11.lookupImplementation(standardLibrary, O_Boolean_and);
				Value A_symbol_11 = dynamic_A_symbol_11.evaluate(evaluator, T_Boolean, A_symbol_12, A_symbol_20);
				final @NonNull Value A_symbol_25 = A_symbol_11;
				final @NonNull Value A_symbol_26 = A_symbol_25;
				A_symbol_8 = A_symbol_26;
			}
			else if (A_symbol_7.isFalse()) {
				
				
				Value A_symbol_27 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_28 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_28 = (LibraryBinaryOperation)static_A_symbol_28.lookupImplementation(standardLibrary, O_OclType_conformsTo);
				Value A_symbol_28 = dynamic_A_symbol_28.evaluate(evaluator, T_Boolean, V_bodyType, A_symbol_27);
				A_symbol_8 = A_symbol_28;
			}
			else if (A_symbol_7.isNull()) {
				A_symbol_8 = valueFactory.throwInvalidValueException("null if condition");
			}
			else {
				A_symbol_8 = valueFactory.throwInvalidValueException("invalid if condition");
			}
			final @NonNull Value A_symbol_29 = A_symbol_8;
			return A_symbol_29;
		}
	}

	/** 
	 * Implementation of the TypedMultiplicityElement::makeParameter '' <body>.
	 */
	public static class _makeParameter_body_ extends AbstractUnaryOperation
	{
		public static @NonNull _makeParameter_body_ INSTANCE = new _makeParameter_body_();
	
		/*
		Parameter{name = 'name'}
		*/
		public @NonNull Value evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Value self) throws InvalidValueException {
			final @NonNull ExecutorProperty P_NamedElement_name = PivotTables.Properties._NamedElement__name;
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull StringValue S_name = valueFactory.stringValueOf("name");
			
			ObjectValue A_symbol_30 = PivotTables.Types._Parameter.createInstance(valueFactory);
			
			P_NamedElement_name.setValue(A_symbol_30, S_name);
			
			return A_symbol_30;
		}
	}
}

