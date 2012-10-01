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
import codegen.company.Company;
import java.util.Iterator;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
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
			final @NonNull TypeId T_company__CompanySizeKind = CodegencompanyTables.Types._CompanySizeKind.getTypeId();
			final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
			final @NonNull CollectionTypeId T_Sequence_Integer_ = TypeId.SEQUENCE.getSpecializedId(T_Integer);
			final @NonNull TupleTypeId U_Tuple_range_Sequence_size_CompanySizeKind_ = IdManager.INSTANCE.getTupleTypeId("Tuple", IdManager.INSTANCE.createTuplePartId("range", T_Sequence_Integer_), IdManager.INSTANCE.createTuplePartId("size", T_company__CompanySizeKind));
			final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
			final @NonNull ExecutorOperation O_Collection_any = OCLstdlibTables.Operations._Collection__any;
			final @NonNull ExecutorOperation O_Collection_includes = OCLstdlibTables.Operations._Collection__includes;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull TypeId T_company__Employee = CodegencompanyTables.Types._Employee.getTypeId();
			final @NonNull CollectionTypeId T_OrderedSet_company__Employee_ = TypeId.ORDERED_SET.getSpecializedId(T_company__Employee);
			final @NonNull PrimitiveTypeId T_UnlimitedNatural = TypeId.UNLIMITED_NATURAL;
			final @NonNull CollectionTypeId T_Sequence_UnlimitedNatural_ = TypeId.SEQUENCE.getSpecializedId(T_UnlimitedNatural);
			final @NonNull TupleTypeId U_Tuple_range_Sequence_size_CompanySizeKind_1 = IdManager.INSTANCE.getTupleTypeId("Tuple", IdManager.INSTANCE.createTuplePartId("range", T_Sequence_UnlimitedNatural_), IdManager.INSTANCE.createTuplePartId("size", T_company__CompanySizeKind));
			final @NonNull CollectionTypeId T_Set_Tuple_range_Sequence_size_CompanySizeKind__ = TypeId.SET.getSpecializedId(U_Tuple_range_Sequence_size_CompanySizeKind_1);
			final @NonNull IntegerValue I_0 = integerValueOf(0);
			final @NonNull IntegerValue I_49 = integerValueOf(49);
			final @NonNull IntegerRange rA_symbol_ = createRange(I_0.asIntegerValue(), I_49.asIntegerValue());
			final @NonNull Object A_symbol_ = createSequenceRange(T_Sequence_UnlimitedNatural_, rA_symbol_);
			final @NonNull Object A_symbol__1 = createEnumerationLiteralValue(CodegencompanyTables.EnumerationLiterals._CompanySizeKind__small);
			final @NonNull IntegerValue I_50 = integerValueOf(50);
			final @NonNull IntegerValue I_999 = integerValueOf(999);
			final @NonNull IntegerRange rA_symbol__2 = createRange(I_50.asIntegerValue(), I_999.asIntegerValue());
			final @NonNull Object A_symbol__2 = createSequenceRange(T_Sequence_UnlimitedNatural_, rA_symbol__2);
			final @NonNull Object A_symbol__3 = createEnumerationLiteralValue(CodegencompanyTables.EnumerationLiterals._CompanySizeKind__medium);
			final @NonNull IntegerValue I_1000 = integerValueOf(1000);
			final @NonNull IntegerValue I_1000000 = integerValueOf(1000000);
			final @NonNull IntegerRange rA_symbol__4 = createRange(I_1000.asIntegerValue(), I_1000000.asIntegerValue());
			final @NonNull Object A_symbol__4 = createSequenceRange(T_Sequence_UnlimitedNatural_, rA_symbol__4);
			final @NonNull Object A_symbol__5 = createEnumerationLiteralValue(CodegencompanyTables.EnumerationLiterals._CompanySizeKind__large);
			
			
			TupleValue A_symbol__6 = createTupleValue(U_Tuple_range_Sequence_size_CompanySizeKind_1, A_symbol_, A_symbol__1);
			
			
			TupleValue A_symbol__7 = createTupleValue(U_Tuple_range_Sequence_size_CompanySizeKind_1, A_symbol__2, A_symbol__3);
			
			
			TupleValue A_symbol__8 = createTupleValue(U_Tuple_range_Sequence_size_CompanySizeKind_1, A_symbol__4, A_symbol__5);
			
			final @NonNull Object A_symbol__9 = createSetValue(T_Set_Tuple_range_Sequence_size_CompanySizeKind__, A_symbol__6, A_symbol__7, A_symbol__8);
			final @NonNull Object V_table = A_symbol__9;
			
			
			final @NonNull Iterator<?> A_symbol__10_iteratorVal = ((CollectionValue)V_table).iterator();
			@NonNull Object V_1_ = null;	// iterator: 1_
			Object A_symbol__10;
			while (true) {
				if (!A_symbol__10_iteratorVal.hasNext()) {
					A_symbol__10 = NULL_VALUE;
					
					break;
				}
				Object A_symbol__10_bodyVal;
				try {
					/*
						range->includes(employees->size())
					*/
					V_1_ = A_symbol__10_iteratorVal.next();
					
					Object A_symbol__11 = ((TupleValue)V_1_).getValue(0);
					
					Company unboxed_self = (Company)self;
					org.eclipse.emf.common.util.EList<codegen.company.Employee> unboxed_A_symbol__12 = unboxed_self.getEmployees();
					Value A_symbol__12 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_company__Employee_, unboxed_A_symbol__12);
					
					
					Object A_symbol__13 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__12);
					Object A_symbol__14 = CollectionIncludesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__11, A_symbol__13);
					A_symbol__10_bodyVal = A_symbol__14;
				} catch (Exception e) {
					A_symbol__10_bodyVal = createInvalidValue(e);
				}
				if (ValuesUtil.isNull(A_symbol__10_bodyVal)) {
					A_symbol__10 = createInvalidValue(EvaluatorMessages.UndefinedBody, "any");
					break;
				}
				else if (A_symbol__10_bodyVal != FALSE_VALUE) {			// Carry on till something found
					A_symbol__10 = V_1_;
					break;
				}
				
			}
			
			Object A_symbol__15 = ((TupleValue)A_symbol__10).getValue(1);
			final @NonNull Object A_symbol__16 = A_symbol__15;
			return A_symbol__16;
		}}
}

