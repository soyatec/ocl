/**
 * 
 *************************************************************************
 * This code is 100% auto-generated
 * from: company
 * using: org.eclipse.ocl.examples.codegen.tables.model2tables.mtl
 *
 * Do not edit it.
 */
package codegen.company.bodies;

import org.eclipse.jdt.annotation.NonNull;
import codegen.company.CodegencompanyTables;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;

/**
 * CompanyBodies provides the Java implementation bodies of OCL-defined Company operations and properties.
 */
@SuppressWarnings("nls")
public class CompanyBodies
{

	/** 
	 * Implementation of the Company 'dummyInvariant' invariant.
	 */
	public static class _invariant_dummyInvariant extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_dummyInvariant INSTANCE = new _invariant_dummyInvariant();
	
		/*
		true
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull Object True = true;
			
			
			return True;
		}
	}



	/** 
	 * Implementation of the Company::size '' <derivation>.
	 */
	public static class _size_derivation_ extends AbstractProperty
	{
		public static @NonNull _size_derivation_ INSTANCE = new _size_derivation_();
	
		/*
		let
	  table : Set(Tuple(range : Sequence(Integer), size : CompanySizeKind)) = Set{
	    Tuple{range = Sequence{0..49}, size = CompanySizeKind::small
	    }
	    , Tuple{range = Sequence{50..999}, size = CompanySizeKind::medium
	    }
	    , Tuple{range = Sequence{1000..1000000}, size = CompanySizeKind::large
	    }
	  }
	in
	  table->any(range->includes(employees->size())).size
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self, @NonNull DomainProperty property) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull ExecutorType T_company__CompanySizeKind = CodegencompanyTables.Types._CompanySizeKind;
			final @NonNull DomainTypedElement L_size_company__CompanySizeKind = standardLibrary.getTuplePart("size", T_company__CompanySizeKind);
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull DomainCollectionType T_Sequence_Integer_ = standardLibrary.getSequenceType(T_Integer, null, null);
			final @NonNull DomainTypedElement L_range_Sequence_Integer_ = standardLibrary.getTuplePart("range", T_Sequence_Integer_);
			final @NonNull DomainTupleType U_Tuple_range_Sequence_size_CompanySizeKind_ = standardLibrary.getTupleType(L_range_Sequence_Integer_, L_size_company__CompanySizeKind);
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Collection_any = OCLstdlibTables.Operations._Collection__any;
			final @NonNull ExecutorOperation O_Collection_includes = OCLstdlibTables.Operations._Collection__includes;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull ExecutorType T_company__Employee = CodegencompanyTables.Types._Employee;
			final @NonNull DomainCollectionType T_OrderedSet_company__Employee_ = standardLibrary.getOrderedSetType(T_company__Employee, null, null);
			final @NonNull ExecutorProperty P_Company_employees = CodegencompanyTables.Properties._Company__employees;
			final @NonNull LibraryProperty IP_Company_employees = P_Company_employees.getImplementation();
			final @NonNull ExecutorType T_UnlimitedNatural = OCLstdlibTables.Types._UnlimitedNatural;
			final @NonNull DomainCollectionType T_Sequence_UnlimitedNatural_ = standardLibrary.getSequenceType(T_UnlimitedNatural, null, null);
			final @NonNull DomainTypedElement L_range_Sequence_UnlimitedNatural_ = standardLibrary.getTuplePart("range", T_Sequence_UnlimitedNatural_);
			final @NonNull DomainTupleType U_Tuple_range_Sequence_size_CompanySizeKind_1 = standardLibrary.getTupleType(L_range_Sequence_UnlimitedNatural_, L_size_company__CompanySizeKind);
			final @NonNull DomainCollectionType T_Set_Tuple_range_Sequence_size_CompanySizeKind__ = standardLibrary.getSetType(U_Tuple_range_Sequence_size_CompanySizeKind_1, null, null);
			final @NonNull IntegerValue I_0 = integerValueOf(0);
			final @NonNull IntegerValue I_49 = integerValueOf(49);
			final @NonNull IntegerRange rA_symbol_ = createRange(I_0.asIntegerValue(), I_49.asIntegerValue());
			final @NonNull Object A_symbol_ = createSequenceRange(T_Sequence_UnlimitedNatural_.getTypeId(), rA_symbol_);
			final @NonNull Object A_symbol__1 = createEnumerationLiteralValue(CodegencompanyTables.EnumerationLiterals._CompanySizeKind__small);
			final @NonNull IntegerValue I_50 = integerValueOf(50);
			final @NonNull IntegerValue I_999 = integerValueOf(999);
			final @NonNull IntegerRange rA_symbol__2 = createRange(I_50.asIntegerValue(), I_999.asIntegerValue());
			final @NonNull Object A_symbol__2 = createSequenceRange(T_Sequence_UnlimitedNatural_.getTypeId(), rA_symbol__2);
			final @NonNull Object A_symbol__3 = createEnumerationLiteralValue(CodegencompanyTables.EnumerationLiterals._CompanySizeKind__medium);
			final @NonNull IntegerValue I_1000 = integerValueOf(1000);
			final @NonNull IntegerValue I_1000000 = integerValueOf(1000000);
			final @NonNull IntegerRange rA_symbol__4 = createRange(I_1000.asIntegerValue(), I_1000000.asIntegerValue());
			final @NonNull Object A_symbol__4 = createSequenceRange(T_Sequence_UnlimitedNatural_.getTypeId(), rA_symbol__4);
			final @NonNull Object A_symbol__5 = createEnumerationLiteralValue(CodegencompanyTables.EnumerationLiterals._CompanySizeKind__large);
			
			
			final @NonNull Map<DomainTypedElement, Object> mA_symbol__6 = new HashMap<DomainTypedElement, Object>();
			mA_symbol__6.put(L_range_Sequence_UnlimitedNatural_, A_symbol_);
			mA_symbol__6.put(L_size_company__CompanySizeKind, A_symbol__1);
			TupleValue A_symbol__6 = createTupleValue(U_Tuple_range_Sequence_size_CompanySizeKind_1.getTupleTypeId(), mA_symbol__6);
			
			
			final @NonNull Map<DomainTypedElement, Object> mA_symbol__7 = new HashMap<DomainTypedElement, Object>();
			mA_symbol__7.put(L_range_Sequence_UnlimitedNatural_, A_symbol__2);
			mA_symbol__7.put(L_size_company__CompanySizeKind, A_symbol__3);
			TupleValue A_symbol__7 = createTupleValue(U_Tuple_range_Sequence_size_CompanySizeKind_1.getTupleTypeId(), mA_symbol__7);
			
			
			final @NonNull Map<DomainTypedElement, Object> mA_symbol__8 = new HashMap<DomainTypedElement, Object>();
			mA_symbol__8.put(L_range_Sequence_UnlimitedNatural_, A_symbol__4);
			mA_symbol__8.put(L_size_company__CompanySizeKind, A_symbol__5);
			TupleValue A_symbol__8 = createTupleValue(U_Tuple_range_Sequence_size_CompanySizeKind_1.getTupleTypeId(), mA_symbol__8);
			
			final @NonNull Object A_symbol__9 = createSetValue(T_Set_Tuple_range_Sequence_size_CompanySizeKind__.getTypeId(), A_symbol__6, A_symbol__7, A_symbol__8);
			final @NonNull Object V_table = A_symbol__9;
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol__10 = new AbstractBinaryOperation()
			{
			/*
			range->includes(employees->size())
			*/
				public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull Object iterator1) throws InvalidValueException {
					final @NonNull Object V_1_ = iterator1;	// iterator: 1_
					
					Object A_symbol__11 = ((TupleValue)V_1_).getValue(L_range_Sequence_Integer_);
					
					
					Object A_symbol__12 = IP_Company_employees.evaluate(evaluator, T_OrderedSet_company__Employee_.getTypeId(), self, P_Company_employees);
					
					DomainType static_A_symbol__13 = evaluator.getStaticTypeOf(A_symbol__12);
					LibraryUnaryOperation dynamic_A_symbol__13 = (LibraryUnaryOperation)static_A_symbol__13.lookupImplementation(standardLibrary, O_Collection_size);
					Object A_symbol__13 = dynamic_A_symbol__13.evaluate(evaluator, T_Integer.getTypeId(), A_symbol__12);
					DomainType static_A_symbol__14 = evaluator.getStaticTypeOf(A_symbol__11);
					LibraryBinaryOperation dynamic_A_symbol__14 = (LibraryBinaryOperation)static_A_symbol__14.lookupImplementation(standardLibrary, O_Collection_includes);
					Object A_symbol__14 = dynamic_A_symbol__14.evaluate(evaluator, T_Boolean.getTypeId(), A_symbol__11, A_symbol__13);
					return A_symbol__14;
				}
			};
			DomainType static_A_symbol__10 = evaluator.getStaticTypeOf(V_table);
			LibraryIteration dynamic_A_symbol__10 = (LibraryIteration)static_A_symbol__10.lookupImplementation(standardLibrary, O_Collection_any);
			Object acc_A_symbol__10 = dynamic_A_symbol__10.createAccumulatorValue(evaluator, U_Tuple_range_Sequence_size_CompanySizeKind_.getTypeId(), T_Boolean.getTypeId());
			ExecutorSingleIterationManager manager_A_symbol__10 = new ExecutorSingleIterationManager(evaluator, U_Tuple_range_Sequence_size_CompanySizeKind_.getTypeId(), body_A_symbol__10, (CollectionValue)V_table, acc_A_symbol__10);
			Object A_symbol__10 = dynamic_A_symbol__10.evaluateIteration(manager_A_symbol__10);
			Object A_symbol__15 = ((TupleValue)A_symbol__10).getValue(L_size_company__CompanySizeKind);
			
			final @NonNull Object A_symbol__16 = A_symbol__15;
			return A_symbol__16;
		}}
}

