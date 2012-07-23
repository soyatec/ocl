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
			
			
			Value A_symbol_328 = IP_TypedElement_type.evaluate(evaluator, T_Type, bodySpecification, P_TypedElement_type);
			
			final @NonNull Value V_bodyType = A_symbol_328;
				
				DomainType static_A_symbol_329 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_329 = (LibraryBinaryOperation)static_A_symbol_329.lookupImplementation(standardLibrary, O_OclAny_oclIsKindOf);
				Value A_symbol_329 = dynamic_A_symbol_329.evaluate(evaluator, T_Boolean, V_bodyType, T_ClassClassifier_pivot__CollectionType_);
			Value A_symbol_330;
			if (A_symbol_329.isTrue()) {
				
				DomainType static_A_symbol_331 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_331 = (LibraryBinaryOperation)static_A_symbol_331.lookupImplementation(standardLibrary, O_OclAny_oclAsType);
				Value A_symbol_331 = dynamic_A_symbol_331.evaluate(evaluator, T_pivot__CollectionType, V_bodyType, T_ClassClassifier_pivot__CollectionType_);
				final @NonNull Value V_bodyCollectionType = A_symbol_331;
				
				Value A_symbol_332 = IP_CollectionType_elementType.evaluate(evaluator, T_Type, V_bodyCollectionType, P_CollectionType_elementType);
				
				final @NonNull Value V_bodyElementType = A_symbol_332;
				Value leftA_symbol_333;
				try {
					Value leftA_symbol_334;
					try {
						
						
						Value A_symbol_335 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
						
						DomainType static_A_symbol_336 = valueFactory.typeOf(V_bodyElementType);
						LibraryBinaryOperation dynamic_A_symbol_336 = (LibraryBinaryOperation)static_A_symbol_336.lookupImplementation(standardLibrary, O_OclType_conformsTo);
						Value A_symbol_336 = dynamic_A_symbol_336.evaluate(evaluator, T_Boolean, V_bodyElementType, A_symbol_335);
						leftA_symbol_334 = A_symbol_336;
					} catch (InvalidValueException e) {
						leftA_symbol_334 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_336 = leftA_symbol_334;
					Value rightA_symbol_334;
					try {
						Value leftA_symbol_337;
						try {
							
							Value A_symbol_338 = IP_MultiplicityElement_isOrdered.evaluate(evaluator, T_Boolean, self, P_MultiplicityElement_isOrdered);
							
							leftA_symbol_337 = A_symbol_338;
						} catch (InvalidValueException e) {
							leftA_symbol_337 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_338 = leftA_symbol_337;
						Value rightA_symbol_337;
						try {
							Value leftA_symbol_339;
							try {
								
								DomainType static_A_symbol_340 = valueFactory.typeOf(V_bodyCollectionType);
								LibraryBinaryOperation dynamic_A_symbol_340 = (LibraryBinaryOperation)static_A_symbol_340.lookupImplementation(standardLibrary, O_OclType_conformsTo);
								Value A_symbol_340 = dynamic_A_symbol_340.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_OrderedSet_OclAny__OclAny_);
								leftA_symbol_339 = A_symbol_340;
							} catch (InvalidValueException e) {
								leftA_symbol_339 = valueFactory.createInvalidValue(e);
							}
							Value A_symbol_340 = leftA_symbol_339;
							Value rightA_symbol_339;
							try {
								
								DomainType static_A_symbol_341 = valueFactory.typeOf(V_bodyCollectionType);
								LibraryBinaryOperation dynamic_A_symbol_341 = (LibraryBinaryOperation)static_A_symbol_341.lookupImplementation(standardLibrary, O_OclType_conformsTo);
								Value A_symbol_341 = dynamic_A_symbol_341.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_Sequence_OclAny__OclAny_);
								rightA_symbol_339 = A_symbol_341;
							} catch (InvalidValueException e) {
								rightA_symbol_339 = valueFactory.createInvalidValue(e);
							}
							Value A_symbol_341 = rightA_symbol_339;
							DomainType static_A_symbol_339 = valueFactory.typeOf(A_symbol_340);
							LibraryBinaryOperation dynamic_A_symbol_339 = (LibraryBinaryOperation)static_A_symbol_339.lookupImplementation(standardLibrary, O_Boolean_or);
							Value A_symbol_339 = dynamic_A_symbol_339.evaluate(evaluator, T_Boolean, A_symbol_340, A_symbol_341);
							rightA_symbol_337 = A_symbol_339;
						} catch (InvalidValueException e) {
							rightA_symbol_337 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_339 = rightA_symbol_337;
						DomainType static_A_symbol_337 = valueFactory.typeOf(A_symbol_338, A_symbol_339);
						LibraryBinaryOperation dynamic_A_symbol_337 = (LibraryBinaryOperation)static_A_symbol_337.lookupImplementation(standardLibrary, O_Boolean__eq_);
						Value A_symbol_337 = dynamic_A_symbol_337.evaluate(evaluator, T_Boolean, A_symbol_338, A_symbol_339);
						rightA_symbol_334 = A_symbol_337;
					} catch (InvalidValueException e) {
						rightA_symbol_334 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_337 = rightA_symbol_334;
					DomainType static_A_symbol_334 = valueFactory.typeOf(A_symbol_336);
					LibraryBinaryOperation dynamic_A_symbol_334 = (LibraryBinaryOperation)static_A_symbol_334.lookupImplementation(standardLibrary, O_Boolean_and);
					Value A_symbol_334 = dynamic_A_symbol_334.evaluate(evaluator, T_Boolean, A_symbol_336, A_symbol_337);
					leftA_symbol_333 = A_symbol_334;
				} catch (InvalidValueException e) {
					leftA_symbol_333 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_334 = leftA_symbol_333;
				Value rightA_symbol_333;
				try {
					Value leftA_symbol_342;
					try {
						
						Value A_symbol_343 = IP_MultiplicityElement_isUnique.evaluate(evaluator, T_Boolean, self, P_MultiplicityElement_isUnique);
						
						leftA_symbol_342 = A_symbol_343;
					} catch (InvalidValueException e) {
						leftA_symbol_342 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_343 = leftA_symbol_342;
					Value rightA_symbol_342;
					try {
						Value leftA_symbol_344;
						try {
							
							DomainType static_A_symbol_345 = valueFactory.typeOf(V_bodyCollectionType);
							LibraryBinaryOperation dynamic_A_symbol_345 = (LibraryBinaryOperation)static_A_symbol_345.lookupImplementation(standardLibrary, O_OclType_conformsTo);
							Value A_symbol_345 = dynamic_A_symbol_345.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_OrderedSet_OclAny__OclAny_);
							leftA_symbol_344 = A_symbol_345;
						} catch (InvalidValueException e) {
							leftA_symbol_344 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_345 = leftA_symbol_344;
						Value rightA_symbol_344;
						try {
							
							DomainType static_A_symbol_346 = valueFactory.typeOf(V_bodyCollectionType);
							LibraryBinaryOperation dynamic_A_symbol_346 = (LibraryBinaryOperation)static_A_symbol_346.lookupImplementation(standardLibrary, O_OclType_conformsTo);
							Value A_symbol_346 = dynamic_A_symbol_346.evaluate(evaluator, T_Boolean, V_bodyCollectionType, T_CollectionClassifier_Set_OclAny__OclAny_);
							rightA_symbol_344 = A_symbol_346;
						} catch (InvalidValueException e) {
							rightA_symbol_344 = valueFactory.createInvalidValue(e);
						}
						Value A_symbol_346 = rightA_symbol_344;
						DomainType static_A_symbol_344 = valueFactory.typeOf(A_symbol_345);
						LibraryBinaryOperation dynamic_A_symbol_344 = (LibraryBinaryOperation)static_A_symbol_344.lookupImplementation(standardLibrary, O_Boolean_or);
						Value A_symbol_344 = dynamic_A_symbol_344.evaluate(evaluator, T_Boolean, A_symbol_345, A_symbol_346);
						rightA_symbol_342 = A_symbol_344;
					} catch (InvalidValueException e) {
						rightA_symbol_342 = valueFactory.createInvalidValue(e);
					}
					Value A_symbol_344 = rightA_symbol_342;
					DomainType static_A_symbol_342 = valueFactory.typeOf(A_symbol_343, A_symbol_344);
					LibraryBinaryOperation dynamic_A_symbol_342 = (LibraryBinaryOperation)static_A_symbol_342.lookupImplementation(standardLibrary, O_Boolean__eq_);
					Value A_symbol_342 = dynamic_A_symbol_342.evaluate(evaluator, T_Boolean, A_symbol_343, A_symbol_344);
					rightA_symbol_333 = A_symbol_342;
				} catch (InvalidValueException e) {
					rightA_symbol_333 = valueFactory.createInvalidValue(e);
				}
				Value A_symbol_342 = rightA_symbol_333;
				DomainType static_A_symbol_333 = valueFactory.typeOf(A_symbol_334);
				LibraryBinaryOperation dynamic_A_symbol_333 = (LibraryBinaryOperation)static_A_symbol_333.lookupImplementation(standardLibrary, O_Boolean_and);
				Value A_symbol_333 = dynamic_A_symbol_333.evaluate(evaluator, T_Boolean, A_symbol_334, A_symbol_342);
				final @NonNull Value A_symbol_347 = A_symbol_333;
				final @NonNull Value A_symbol_348 = A_symbol_347;
				A_symbol_330 = A_symbol_348;
			}
			else if (A_symbol_329.isFalse()) {
				
				
				Value A_symbol_349 = IP_TypedElement_type.evaluate(evaluator, T_Type, self, P_TypedElement_type);
				
				DomainType static_A_symbol_350 = valueFactory.typeOf(V_bodyType);
				LibraryBinaryOperation dynamic_A_symbol_350 = (LibraryBinaryOperation)static_A_symbol_350.lookupImplementation(standardLibrary, O_OclType_conformsTo);
				Value A_symbol_350 = dynamic_A_symbol_350.evaluate(evaluator, T_Boolean, V_bodyType, A_symbol_349);
				A_symbol_330 = A_symbol_350;
			}
			else if (A_symbol_329.isNull()) {
				A_symbol_330 = valueFactory.throwInvalidValueException("null if condition");
			}
			else {
				A_symbol_330 = valueFactory.throwInvalidValueException("invalid if condition");
			}
			final @NonNull Value A_symbol_351 = A_symbol_330;
			return A_symbol_351;
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
			
			ObjectValue A_symbol_352 = PivotTables.Types._Parameter.createInstance(valueFactory);
			
			P_NamedElement_name.setValue(A_symbol_352, S_name);
			
			return A_symbol_352;
		}
	}
}

