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
			final Value T_ClassClassifier_pivot__CollectionType_ = valueFactory.createTypeValue(PivotTables.Types._CollectionType);
			final ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
			final ExecutorOperation O_OclType_conformsTo = OCLstdlibTables.Operations._OclType__conformsTo;
			final ExecutorType T_Type = OCLstdlibTables.Types._Type;
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
			final ExecutorType T_pivot__CollectionType = PivotTables.Types._CollectionType;
			final ExecutorOperation O_OclAny_oclAsType = OCLstdlibTables.Operations._OclAny__oclAsType;
			
			
			Value A_symbol_68 = IP_TypedElement_type.evaluate(evaluator, T_Type, bodySpecification, P_TypedElement_type);
			
			final Value V_bodyType = A_symbol_68;
				
				DomainType static_A_symbol_69 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_69 = (LibraryBinaryOperation)static_A_symbol_69.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_69 = dynamic_A_symbol_69.evaluate(evaluator, T_Boolean, V_bodyType, T_ClassClassifier_pivot__CollectionType_);
			Value A_symbol_70;
			if (A_symbol_69.isTrue()) {
				
				DomainType static_A_symbol_71 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_71 = (LibraryBinaryOperation)static_A_symbol_71.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_71 = dynamic_A_symbol_71.evaluate(evaluator, T_pivot__CollectionType, V_bodyType, T_ClassClassifier_pivot__CollectionType_);
				final Value V_bodyCollectionType = A_symbol_71;
				
				Value A_symbol_72 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, V_bodyCollectionType, P_CollectionType_elementType);
				
				final Value V_bodyElementType = A_symbol_72;
				Value leftA_symbol_73;
				try {
					Value leftA_symbol_74;
					try {
						
						
						Value A_symbol_75 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
						
						DomainType static_A_symbol_76 = valueFactory.typeOf(V_bodyElementType);
						LibraryBinaryOperation dynamic_A_symbol_76 = (LibraryBinaryOperation)static_A_symbol_76.lookupImplementation(standardLibrary, O_OclType_conformsTo);
						Value A_symbol_76 = dynamic_A_symbol_76.evaluate(evaluator, T_Boolean, V_bodyElementType, A_symbol_75);
						leftA_symbol_74 = A_symbol_76;
					} catch (InvalidValueException e) {
						leftA_symbol_74 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_76 = leftA_symbol_74;
					Value rightA_symbol_74;
					try {
						Value leftA_symbol_77;
						try {
							
							Value A_symbol_78 = IP_MultiplicityElement_isOrdered.evaluate(evaluator, T_Boolean, self, P_MultiplicityElement_isOrdered);
							
							leftA_symbol_77 = A_symbol_78;
						} catch (InvalidValueException e) {
							leftA_symbol_77 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_78 = leftA_symbol_77;
						Value rightA_symbol_77;
						try {
							Value leftA_symbol_79;
							try {
								
								DomainType static_A_symbol_80 = valueFactory.typeOf(V_bodyCollectionType);
								LibraryBinaryOperation dynamic_A_symbol_80 = (LibraryBinaryOperation)static_A_symbol_80.lookupImplementation(standardLibrary, O_OclType_conformsTo);
								Value A_symbol_80 = dynamic_A_symbol_80.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_OrderedSet_OclAny__OclAny_);
								leftA_symbol_79 = A_symbol_80;
							} catch (InvalidValueException e) {
								leftA_symbol_79 = valueFactory.createInvalidValue(e);
							}
							Value A_symbol_80 = leftA_symbol_79;
							Value rightA_symbol_79;
							try {
								
								DomainType static_A_symbol_81 = valueFactory.typeOf(V_bodyCollectionType);
								LibraryBinaryOperation dynamic_A_symbol_81 = (LibraryBinaryOperation)static_A_symbol_81.lookupImplementation(standardLibrary, O_OclType_conformsTo);
								Value A_symbol_81 = dynamic_A_symbol_81.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_Sequence_OclAny__OclAny_);
								rightA_symbol_79 = A_symbol_81;
							} catch (InvalidValueException e) {
								rightA_symbol_79 = valueFactory.createInvalidValue(e);
							}
							Value A_symbol_81 = rightA_symbol_79;
							DomainType static_A_symbol_79 = valueFactory.typeOf(A_symbol_80);
							LibraryBinaryOperation dynamic_A_symbol_79 = (LibraryBinaryOperation)static_A_symbol_79.lookupImplementation(standardLibrary, O_Boolean_or);
							Value A_symbol_79 = dynamic_A_symbol_79.evaluate(evaluator, T_Boolean, A_symbol_80, A_symbol_81);
							rightA_symbol_77 = A_symbol_79;
						} catch (InvalidValueException e) {
							rightA_symbol_77 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_79 = rightA_symbol_77;
						DomainType static_A_symbol_77 = valueFactory.typeOf(A_symbol_78, A_symbol_79);
						LibraryBinaryOperation dynamic_A_symbol_77 = (LibraryBinaryOperation)static_A_symbol_77.lookupImplementation(standardLibrary, O_Boolean__eq_);
						Value A_symbol_77 = dynamic_A_symbol_77.evaluate(evaluator, T_Boolean, A_symbol_78, A_symbol_79);
						rightA_symbol_74 = A_symbol_77;
					} catch (InvalidValueException e) {
						rightA_symbol_74 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_77 = rightA_symbol_74;
					DomainType static_A_symbol_74 = valueFactory.typeOf(A_symbol_76);
					LibraryBinaryOperation dynamic_A_symbol_74 = (LibraryBinaryOperation)static_A_symbol_74.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_74 = dynamic_A_symbol_74.evaluate(evaluator, T_Boolean, A_symbol_76, A_symbol_77);
					leftA_symbol_73 = A_symbol_74;
				} catch (InvalidValueException e) {
					leftA_symbol_73 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_74 = leftA_symbol_73;
				Value rightA_symbol_73;
				try {
					Value leftA_symbol_82;
					try {
						
						Value A_symbol_83 = IP_MultiplicityElement_isUnique.evaluate(evaluator, T_Boolean, self, P_MultiplicityElement_isUnique);
						
						leftA_symbol_82 = A_symbol_83;
					} catch (InvalidValueException e) {
						leftA_symbol_82 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_83 = leftA_symbol_82;
					Value rightA_symbol_82;
					try {
						Value leftA_symbol_84;
						try {
							
							DomainType static_A_symbol_85 = valueFactory.typeOf(V_bodyCollectionType);
							LibraryBinaryOperation dynamic_A_symbol_85 = (LibraryBinaryOperation)static_A_symbol_85.lookupImplementation(standardLibrary, O_OclType_conformsTo);
							Value A_symbol_85 = dynamic_A_symbol_85.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_OrderedSet_OclAny__OclAny_);
							leftA_symbol_84 = A_symbol_85;
						} catch (InvalidValueException e) {
							leftA_symbol_84 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_85 = leftA_symbol_84;
						Value rightA_symbol_84;
						try {
							
							DomainType static_A_symbol_86 = valueFactory.typeOf(V_bodyCollectionType);
							LibraryBinaryOperation dynamic_A_symbol_86 = (LibraryBinaryOperation)static_A_symbol_86.lookupImplementation(standardLibrary, O_OclType_conformsTo);
							Value A_symbol_86 = dynamic_A_symbol_86.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_Set_OclAny__OclAny_);
							rightA_symbol_84 = A_symbol_86;
						} catch (InvalidValueException e) {
							rightA_symbol_84 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_86 = rightA_symbol_84;
						DomainType static_A_symbol_84 = valueFactory.typeOf(A_symbol_85);
						LibraryBinaryOperation dynamic_A_symbol_84 = (LibraryBinaryOperation)static_A_symbol_84.lookupImplementation(standardLibrary, O_Boolean_or);
						Value A_symbol_84 = dynamic_A_symbol_84.evaluate(evaluator, T_Boolean, A_symbol_85, A_symbol_86);
						rightA_symbol_82 = A_symbol_84;
					} catch (InvalidValueException e) {
						rightA_symbol_82 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_84 = rightA_symbol_82;
					DomainType static_A_symbol_82 = valueFactory.typeOf(A_symbol_83, A_symbol_84);
					LibraryBinaryOperation dynamic_A_symbol_82 = (LibraryBinaryOperation)static_A_symbol_82.lookupImplementation(standardLibrary, O_Boolean__eq_);
					Value A_symbol_82 = dynamic_A_symbol_82.evaluate(evaluator, T_Boolean, A_symbol_83, A_symbol_84);
					rightA_symbol_73 = A_symbol_82;
				} catch (InvalidValueException e) {
					rightA_symbol_73 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_82 = rightA_symbol_73;
				DomainType static_A_symbol_73 = valueFactory.typeOf(A_symbol_74);
				LibraryBinaryOperation dynamic_A_symbol_73 = (LibraryBinaryOperation)static_A_symbol_73.lookupImplementation(standardLibrary, O_Boolean_and);
				Value A_symbol_73 = dynamic_A_symbol_73.evaluate(evaluator, T_Boolean, A_symbol_74, A_symbol_82);
				final Value A_symbol_87 = A_symbol_73;
				final Value A_symbol_88 = A_symbol_87;
				A_symbol_70 = A_symbol_88;
			}
			else if (A_symbol_69.isFalse()) {
				
				
				Value A_symbol_89 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_90 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_90 = (LibraryBinaryOperation)static_A_symbol_90.lookupImplementation(standardLibrary, O_OclType_conformsTo);
				Value A_symbol_90 = dynamic_A_symbol_90.evaluate(evaluator, T_Boolean, V_bodyType, A_symbol_89);
				A_symbol_70 = A_symbol_90;
			}
			else if (A_symbol_69.isNull()) {
				A_symbol_70 = valueFactory.throwInvalidValueException("null if condition");
			}
			else {
				A_symbol_70 = valueFactory.throwInvalidValueException("invalid if condition");
			}
			final Value A_symbol_91 = A_symbol_70;
			return A_symbol_91;
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
			
			ObjectValue A_symbol_92 = PivotTables.Types._Parameter.createInstance(valueFactory);
			
			P_NamedElement_name.setValue(A_symbol_92, S_name);
			
			return A_symbol_92;
		}
	}
}

