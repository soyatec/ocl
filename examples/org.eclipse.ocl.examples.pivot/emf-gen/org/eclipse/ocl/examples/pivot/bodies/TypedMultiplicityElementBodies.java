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
			
			
			Value A_symbol_20 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, bodySpecification, P_TypedElement_type);
			
			final Value V_bodyType = A_symbol_20;
				
				DomainType static_A_symbol_21 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_21 = (LibraryBinaryOperation)static_A_symbol_21.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_21 = dynamic_A_symbol_21.evaluate(evaluator, T_Boolean, V_bodyType, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
			Value A_symbol_22;
			if (A_symbol_21.isTrue()) {
				
				DomainType static_A_symbol_23 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_23 = (LibraryBinaryOperation)static_A_symbol_23.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_23 = dynamic_A_symbol_23.evaluate(evaluator, T_Pivot_ecore__pivot__CollectionType, V_bodyType, T_ClassClassifier_Pivot_ecore__pivot__CollectionType_);
				final Value V_bodyCollectionType = A_symbol_23;
				
				Value A_symbol_24 = IP_CollectionType_elementType.evaluate(evaluator, T_Pivot_ecore__pivot__Type, V_bodyCollectionType, P_CollectionType_elementType);
				
				final Value V_bodyElementType = A_symbol_24;
				Value leftA_symbol_25;
				try {
					Value leftA_symbol_26;
					try {
						
						
						Value A_symbol_27 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
						
						DomainType static_A_symbol_28 = valueFactory.typeOf(V_bodyElementType);
						LibraryBinaryOperation dynamic_A_symbol_28 = (LibraryBinaryOperation)static_A_symbol_28.lookupImplementation(standardLibrary, O_OclType_conformsTo);
						Value A_symbol_28 = dynamic_A_symbol_28.evaluate(evaluator, T_Boolean, V_bodyElementType, A_symbol_27);
						leftA_symbol_26 = A_symbol_28;
					} catch (InvalidValueException e) {
						leftA_symbol_26 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_28 = leftA_symbol_26;
					Value rightA_symbol_26;
					try {
						Value leftA_symbol_29;
						try {
							
							Value A_symbol_30 = IP_MultiplicityElement_isOrdered.evaluate(evaluator, T_Boolean, self, P_MultiplicityElement_isOrdered);
							
							leftA_symbol_29 = A_symbol_30;
						} catch (InvalidValueException e) {
							leftA_symbol_29 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_30 = leftA_symbol_29;
						Value rightA_symbol_29;
						try {
							Value leftA_symbol_31;
							try {
								
								DomainType static_A_symbol_32 = valueFactory.typeOf(V_bodyCollectionType);
								LibraryBinaryOperation dynamic_A_symbol_32 = (LibraryBinaryOperation)static_A_symbol_32.lookupImplementation(standardLibrary, O_OclType_conformsTo);
								Value A_symbol_32 = dynamic_A_symbol_32.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_OrderedSet_OclAny__OclAny_);
								leftA_symbol_31 = A_symbol_32;
							} catch (InvalidValueException e) {
								leftA_symbol_31 = valueFactory.createInvalidValue(e);
							}
							Value A_symbol_32 = leftA_symbol_31;
							Value rightA_symbol_31;
							try {
								
								DomainType static_A_symbol_33 = valueFactory.typeOf(V_bodyCollectionType);
								LibraryBinaryOperation dynamic_A_symbol_33 = (LibraryBinaryOperation)static_A_symbol_33.lookupImplementation(standardLibrary, O_OclType_conformsTo);
								Value A_symbol_33 = dynamic_A_symbol_33.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_Sequence_OclAny__OclAny_);
								rightA_symbol_31 = A_symbol_33;
							} catch (InvalidValueException e) {
								rightA_symbol_31 = valueFactory.createInvalidValue(e);
							}
							Value A_symbol_33 = rightA_symbol_31;
							DomainType static_A_symbol_31 = valueFactory.typeOf(A_symbol_32);
							LibraryBinaryOperation dynamic_A_symbol_31 = (LibraryBinaryOperation)static_A_symbol_31.lookupImplementation(standardLibrary, O_Boolean_or);
							Value A_symbol_31 = dynamic_A_symbol_31.evaluate(evaluator, T_Boolean, A_symbol_32, A_symbol_33);
							rightA_symbol_29 = A_symbol_31;
						} catch (InvalidValueException e) {
							rightA_symbol_29 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_31 = rightA_symbol_29;
						DomainType static_A_symbol_29 = valueFactory.typeOf(A_symbol_30, A_symbol_31);
						LibraryBinaryOperation dynamic_A_symbol_29 = (LibraryBinaryOperation)static_A_symbol_29.lookupImplementation(standardLibrary, O_Boolean__eq_);
						Value A_symbol_29 = dynamic_A_symbol_29.evaluate(evaluator, T_Boolean, A_symbol_30, A_symbol_31);
						rightA_symbol_26 = A_symbol_29;
					} catch (InvalidValueException e) {
						rightA_symbol_26 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_29 = rightA_symbol_26;
					DomainType static_A_symbol_26 = valueFactory.typeOf(A_symbol_28);
					LibraryBinaryOperation dynamic_A_symbol_26 = (LibraryBinaryOperation)static_A_symbol_26.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_26 = dynamic_A_symbol_26.evaluate(evaluator, T_Boolean, A_symbol_28, A_symbol_29);
					leftA_symbol_25 = A_symbol_26;
				} catch (InvalidValueException e) {
					leftA_symbol_25 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_26 = leftA_symbol_25;
				Value rightA_symbol_25;
				try {
					Value leftA_symbol_34;
					try {
						
						Value A_symbol_35 = IP_MultiplicityElement_isUnique.evaluate(evaluator, T_Boolean, self, P_MultiplicityElement_isUnique);
						
						leftA_symbol_34 = A_symbol_35;
					} catch (InvalidValueException e) {
						leftA_symbol_34 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_35 = leftA_symbol_34;
					Value rightA_symbol_34;
					try {
						Value leftA_symbol_36;
						try {
							
							DomainType static_A_symbol_37 = valueFactory.typeOf(V_bodyCollectionType);
							LibraryBinaryOperation dynamic_A_symbol_37 = (LibraryBinaryOperation)static_A_symbol_37.lookupImplementation(standardLibrary, O_OclType_conformsTo);
							Value A_symbol_37 = dynamic_A_symbol_37.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_OrderedSet_OclAny__OclAny_);
							leftA_symbol_36 = A_symbol_37;
						} catch (InvalidValueException e) {
							leftA_symbol_36 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_37 = leftA_symbol_36;
						Value rightA_symbol_36;
						try {
							
							DomainType static_A_symbol_38 = valueFactory.typeOf(V_bodyCollectionType);
							LibraryBinaryOperation dynamic_A_symbol_38 = (LibraryBinaryOperation)static_A_symbol_38.lookupImplementation(standardLibrary, O_OclType_conformsTo);
							Value A_symbol_38 = dynamic_A_symbol_38.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_Set_OclAny__OclAny_);
							rightA_symbol_36 = A_symbol_38;
						} catch (InvalidValueException e) {
							rightA_symbol_36 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_38 = rightA_symbol_36;
						DomainType static_A_symbol_36 = valueFactory.typeOf(A_symbol_37);
						LibraryBinaryOperation dynamic_A_symbol_36 = (LibraryBinaryOperation)static_A_symbol_36.lookupImplementation(standardLibrary, O_Boolean_or);
						Value A_symbol_36 = dynamic_A_symbol_36.evaluate(evaluator, T_Boolean, A_symbol_37, A_symbol_38);
						rightA_symbol_34 = A_symbol_36;
					} catch (InvalidValueException e) {
						rightA_symbol_34 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_36 = rightA_symbol_34;
					DomainType static_A_symbol_34 = valueFactory.typeOf(A_symbol_35, A_symbol_36);
					LibraryBinaryOperation dynamic_A_symbol_34 = (LibraryBinaryOperation)static_A_symbol_34.lookupImplementation(standardLibrary, O_Boolean__eq_);
					Value A_symbol_34 = dynamic_A_symbol_34.evaluate(evaluator, T_Boolean, A_symbol_35, A_symbol_36);
					rightA_symbol_25 = A_symbol_34;
				} catch (InvalidValueException e) {
					rightA_symbol_25 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_34 = rightA_symbol_25;
				DomainType static_A_symbol_25 = valueFactory.typeOf(A_symbol_26);
				LibraryBinaryOperation dynamic_A_symbol_25 = (LibraryBinaryOperation)static_A_symbol_25.lookupImplementation(standardLibrary, O_Boolean_and);
				Value A_symbol_25 = dynamic_A_symbol_25.evaluate(evaluator, T_Boolean, A_symbol_26, A_symbol_34);
				final Value A_symbol_39 = A_symbol_25;
				final Value A_symbol_40 = A_symbol_39;
				A_symbol_22 = A_symbol_40;
			}
			else if (A_symbol_21.isFalse()) {
				
				
				Value A_symbol_41 = IP_TypedElement_type.evaluate(evaluator, T_Pivot_ecore__pivot__Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_42 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_42 = (LibraryBinaryOperation)static_A_symbol_42.lookupImplementation(standardLibrary, O_OclType_conformsTo);
				Value A_symbol_42 = dynamic_A_symbol_42.evaluate(evaluator, T_Boolean, V_bodyType, A_symbol_41);
				A_symbol_22 = A_symbol_42;
			}
			else if (A_symbol_21.isNull()) {
				A_symbol_22 = valueFactory.throwInvalidValueException("null if condition");
			}
			else {
				A_symbol_22 = valueFactory.throwInvalidValueException("invalid if condition");
			}
			final Value A_symbol_43 = A_symbol_22;
			return A_symbol_43;
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
			
			ObjectValue A_symbol_44 = PivotTables.Types._Parameter.createInstance(valueFactory);
			
			P_NamedElement_name.setValue(A_symbol_44, S_name);
			
			return A_symbol_44;
		}
	}
}

