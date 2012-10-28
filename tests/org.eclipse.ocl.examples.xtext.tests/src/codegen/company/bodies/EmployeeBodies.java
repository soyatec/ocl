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
import org.eclipse.jdt.annotation.Nullable;
import codegen.company.CodegencompanyTables;
import codegen.company.Employee;
import java.util.Iterator;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.logical.BooleanAndOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.logical.BooleanNotOperation;
import org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.library.string.StringSizeOperation;

/**
 * EmployeeBodies provides the Java implementation bodies of OCL-defined Employee operations and properties.
 */
@SuppressWarnings({"nls", "null", "unused"})
public class EmployeeBodies
{

	/** 
	 * Implementation of the Employee 'mustHaveName' invariant.
	 */
	public static class _invariant_mustHaveName extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_mustHaveName INSTANCE = new _invariant_mustHaveName();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
		static final @NonNull ExecutorOperation O_Boolean_not = OCLstdlibTables.Operations._Boolean__not;
		static final @NonNull ExecutorOperation O_OclAny_oclIsUndefined = OCLstdlibTables.Operations._OclAny__oclIsUndefined;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull ExecutorOperation O_Employee_hasNameAsOperation = CodegencompanyTables.Operations._Employee__hasNameAsOperation;
		
	
		/*
		not name.oclIsUndefined() and hasNameAsAttribute and hasNameAsOperation()
		*/
		@Override
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Employee unboxed_self = (Employee)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol_;
			try {
				Object leftA_symbol__1;
				try {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					java.lang.String unboxed_A_symbol__2 = unboxed_self.getName();
					Object A_symbol__2 = unboxed_A_symbol__2; // String
					
					
					Object A_symbol__3 = OclAnyOclIsUndefinedOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__2);
					Object A_symbol__4 = BooleanNotOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__3);
					leftA_symbol__1 = A_symbol__4;
				} catch (Exception e) {
					leftA_symbol__1 = new InvalidValueImpl(e);
				}
				Object A_symbol__4 = leftA_symbol__1;
				Object rightA_symbol__1;
				try {
					
					if (self == null) { throw new InvalidValueException("Null property source"); }
					java.lang.Boolean unboxed_A_symbol__5 = unboxed_self.isHasNameAsAttribute();
					Object A_symbol__5 = unboxed_A_symbol__5;
					
					
					rightA_symbol__1 = A_symbol__5;
				} catch (Exception e) {
					rightA_symbol__1 = new InvalidValueImpl(e);
				}
				Object A_symbol__5 = rightA_symbol__1;
				Object A_symbol__1 = BooleanAndOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__4, A_symbol__5);
				leftA_symbol_ = A_symbol__1;
			} catch (Exception e) {
				leftA_symbol_ = new InvalidValueImpl(e);
			}
			Object A_symbol__1 = leftA_symbol_;
			Object rightA_symbol_;
			try {
				
				Object A_symbol__6 = codegen.company.bodies.EmployeeBodies._hasNameAsOperation_body_.INSTANCE.evaluate(evaluator, T_Boolean, self);
				rightA_symbol_ = A_symbol__6;
			} catch (Exception e) {
				rightA_symbol_ = new InvalidValueImpl(e);
			}
			Object A_symbol__6 = rightA_symbol_;
			Object A_symbol_ = BooleanAndOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__1, A_symbol__6);
			return A_symbol_;
		}
	}

	/** 
	 * Implementation of the Employee 'mustHaveNonEmptyName' invariant.
	 */
	public static class _invariant_mustHaveNonEmptyName extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_mustHaveNonEmptyName INSTANCE = new _invariant_mustHaveNonEmptyName();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_Collection_notEmpty = OCLstdlibTables.Operations._Collection__notEmpty;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final @NonNull CollectionTypeId T_Set_String_ = TypeId.SET.getSpecializedId(T_String);
		static final @NonNull ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
		static final @NonNull ExecutorOperation O_Real__gt_ = OCLstdlibTables.Operations._Real___gt_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_String_size = OCLstdlibTables.Operations._String__size;
		static final @NonNull IntegerValue I_0 = integerValueOf(0);
		
	
		/*
		name->notEmpty() implies name.size() > 0
		*/
		@Override
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Employee unboxed_self = (Employee)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__7;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__8 = unboxed_self.getName();
				Object A_symbol__8 = unboxed_A_symbol__8; // String
				
				
				Object A_symbol__9 = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, T_Set_String_, A_symbol__8);
				Object A_symbol__10 = CollectionNotEmptyOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__9);
				leftA_symbol__7 = A_symbol__10;
			} catch (Exception e) {
				leftA_symbol__7 = new InvalidValueImpl(e);
			}
			Object A_symbol__10 = leftA_symbol__7;
			Object rightA_symbol__7;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				java.lang.String unboxed_A_symbol__11 = unboxed_self.getName();
				Object A_symbol__11 = unboxed_A_symbol__11; // String
				
				
				Object A_symbol__12 = StringSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__11);
				Object A_symbol__13 = NumericGreaterThanOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__12, I_0);
				rightA_symbol__7 = A_symbol__13;
			} catch (Exception e) {
				rightA_symbol__7 = new InvalidValueImpl(e);
			}
			Object A_symbol__13 = rightA_symbol__7;
			Object A_symbol__7 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__10, A_symbol__13);
			return A_symbol__7;
		}
	}

	/** 
	 * Implementation of the Employee 'noManagerImpliesDirectReports' invariant.
	 */
	public static class _invariant_noManagerImpliesDirectReports extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_noManagerImpliesDirectReports INSTANCE = new _invariant_noManagerImpliesDirectReports();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
		static final @NonNull ExecutorOperation O_OclAny_oclIsUndefined = OCLstdlibTables.Operations._OclAny__oclIsUndefined;
		static final @NonNull TypeId T_company__Employee = CodegencompanyTables.Types._Employee.getTypeId();
		static final @NonNull ExecutorOperation O_Real__gt_ = OCLstdlibTables.Operations._Real___gt_;
		static final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
		static final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
		static final @NonNull CollectionTypeId T_OrderedSet_company__Employee_ = TypeId.ORDERED_SET.getSpecializedId(T_company__Employee);
		static final @NonNull IntegerValue I_0 = integerValueOf(0);
		
	
		/*
		manager.oclIsUndefined() implies directReports->size() > 0
		*/
		@Override
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Employee unboxed_self = (Employee)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			Object leftA_symbol__14;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				codegen.company.Employee unboxed_A_symbol__15 = unboxed_self.getManager();
				Object A_symbol__15 = valueOf(unboxed_A_symbol__15); // Employee
				
				
				Object A_symbol__16 = OclAnyOclIsUndefinedOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__15);
				leftA_symbol__14 = A_symbol__16;
			} catch (Exception e) {
				leftA_symbol__14 = new InvalidValueImpl(e);
			}
			Object A_symbol__16 = leftA_symbol__14;
			Object rightA_symbol__14;
			try {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.emf.common.util.EList<codegen.company.Employee> unboxed_A_symbol__17 = unboxed_self.getDirectReports();
				assert unboxed_A_symbol__17 != null;
				final @NonNull Value A_symbol__17 = createOrderedSetValue(T_OrderedSet_company__Employee_, unboxed_A_symbol__17);
				
				
				Object A_symbol__18 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__17);
				Object A_symbol__19 = NumericGreaterThanOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__18, I_0);
				rightA_symbol__14 = A_symbol__19;
			} catch (Exception e) {
				rightA_symbol__14 = new InvalidValueImpl(e);
			}
			Object A_symbol__19 = rightA_symbol__14;
			Object A_symbol__14 = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__16, A_symbol__19);
			return A_symbol__14;
		}
	}

	/** 
	 * Implementation of the Employee::hasNameAsOperation '' <body>.
	 */
	public static class _hasNameAsOperation_body_ extends AbstractUnaryOperation
	{
		public static @NonNull _hasNameAsOperation_body_ INSTANCE = new _hasNameAsOperation_body_();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_String__lt__gt_ = OCLstdlibTables.Operations._String___lt__gt_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final Object Null = null;
		
	
		/*
		name <> null
		*/
		@Override
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Employee unboxed_self = (Employee)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			java.lang.String unboxed_A_symbol__20 = unboxed_self.getName();
			Object A_symbol__20 = unboxed_A_symbol__20; // String
			
			
			Object A_symbol__21 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__20, Null);
			return A_symbol__21;
		}
	}

	/** 
	 * Implementation of the Employee::reportsTo '' <body>.
	 */
	public static class _reportsTo_body_ extends AbstractBinaryOperation
	{
		public static @NonNull _reportsTo_body_ INSTANCE = new _reportsTo_body_();
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Collection_includes = OCLstdlibTables.Operations._Collection__includes;
		static final @NonNull TypeId T_company__Employee = CodegencompanyTables.Types._Employee.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_company__Employee_ = TypeId.ORDERED_SET.getSpecializedId(T_company__Employee);
		
	
		/*
		self.reportingChain->includes(manager)
		*/
		@Override
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self, final @Nullable Object manager) throws Exception {
			assert self != null;
			final @NonNull Employee unboxed_self = (Employee)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.emf.common.util.EList<codegen.company.Employee> unboxed_A_symbol__22 = unboxed_self.getReportingChain();
			assert unboxed_A_symbol__22 != null;
			final @NonNull Value A_symbol__22 = createOrderedSetValue(T_OrderedSet_company__Employee_, unboxed_A_symbol__22);
			
			
			
			Object A_symbol__23 = CollectionIncludesOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__22, manager);
			return A_symbol__23;
		}
	}


	/** 
	 * Implementation of the Employee::allReports '' <derivation>.
	 */
	public static class _allReports_derivation_ extends AbstractProperty
	{
		public static @NonNull _allReports_derivation_ INSTANCE = new _allReports_derivation_();
	
		static final @NonNull TypeId T_company__Employee = CodegencompanyTables.Types._Employee.getTypeId();
		static final @NonNull CollectionTypeId T_Set_company__Employee_ = TypeId.SET.getSpecializedId(T_company__Employee);
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_Set_select = OCLstdlibTables.Operations._Set__select;
		static final @NonNull ExecutorOperation O_OclElement_allInstances = OCLstdlibTables.Operations._OclElement__allInstances;
		static final @NonNull Object T_Metaclass_company__Employee_ = createTypeValue(CodegencompanyTables.Types._Employee);
		static final @NonNull ExecutorOperation O_Employee_reportsTo = CodegencompanyTables.Operations._Employee__reportsTo;
		
		/*
		Employee.allInstances()->select(reportsTo(self))
		*/
		@Override
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Employee unboxed_self = (Employee)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			DomainType static_A_symbol__25 = evaluator.getStaticTypeOf(T_Metaclass_company__Employee_);
			LibraryUnaryOperation dynamic_A_symbol__25 = (LibraryUnaryOperation)static_A_symbol__25.lookupImplementation(standardLibrary, O_OclElement_allInstances);
			Object A_symbol__25 = dynamic_A_symbol__25.evaluate(evaluator, T_Set_company__Employee_, T_Metaclass_company__Employee_);
			CollectionValue.Accumulator acc_A_symbol__24 = createCollectionAccumulatorValue(T_Set_company__Employee_);
			
			assert A_symbol__25 != null;
			final @NonNull Iterator<?> A_symbol__24_iteratorVal = ((CollectionValue)A_symbol__25).iterator();
			Object V_1_ = null;	// iterator: 1_
			Object A_symbol__24;
			while (true) {
				if (!A_symbol__24_iteratorVal.hasNext()) {
					A_symbol__24 = acc_A_symbol__24;
					
					break;
				}
				/*
					reportsTo(self)
				*/
				V_1_ = A_symbol__24_iteratorVal.next();
				
				
				Object A_symbol__26 = codegen.company.bodies.EmployeeBodies._reportsTo_body_.INSTANCE.evaluate(evaluator, T_Boolean, V_1_, self);
				Object A_symbol__24_bodyVal = A_symbol__26;
				if (A_symbol__24_bodyVal == TRUE_VALUE) {
					acc_A_symbol__24.add(V_1_);
				}
				else if (A_symbol__24_bodyVal == null) {
					throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "select");
				}
			}
			
			return A_symbol__24;
		}}


	/** 
	 * Implementation of the Employee::directReports '' <derivation>.
	 */
	public static class _directReports_derivation_ extends AbstractProperty
	{
		public static @NonNull _directReports_derivation_ INSTANCE = new _directReports_derivation_();
	
		static final @NonNull TypeId T_company__Employee = CodegencompanyTables.Types._Employee.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_company__Employee_ = TypeId.ORDERED_SET.getSpecializedId(T_company__Employee);
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_OrderedSet_select = OCLstdlibTables.Operations._OrderedSet__select;
		static final @NonNull TypeId T_company__Company = CodegencompanyTables.Types._Company.getTypeId();
		static final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
		
		/*
		company.employees->select(manager = self)
		*/
		@Override
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Employee unboxed_self = (Employee)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			codegen.company.Company unboxed_A_symbol__28 = unboxed_self.getCompany();
			Object A_symbol__28 = valueOf(unboxed_A_symbol__28); // Company
			
			
			if (A_symbol__28 == null) { throw new InvalidValueException("Null property source"); }
			org.eclipse.emf.common.util.EList<codegen.company.Employee> unboxed_A_symbol__29 = unboxed_A_symbol__28.getEmployees();
			assert unboxed_A_symbol__29 != null;
			final @NonNull Value A_symbol__29 = createOrderedSetValue(T_OrderedSet_company__Employee_, unboxed_A_symbol__29);
			
			
			CollectionValue.Accumulator acc_A_symbol__27 = createCollectionAccumulatorValue(T_OrderedSet_company__Employee_);
			
			assert A_symbol__29 != null;
			final @NonNull Iterator<?> A_symbol__27_iteratorVal = ((CollectionValue)A_symbol__29).iterator();
			Object V_1_ = null;	// iterator: 1_
			Object A_symbol__27;
			while (true) {
				if (!A_symbol__27_iteratorVal.hasNext()) {
					A_symbol__27 = acc_A_symbol__27;
					
					break;
				}
				/*
					manager = self
				*/
				V_1_ = A_symbol__27_iteratorVal.next();
				
				if (V_1_ == null) { throw new InvalidValueException("Null property source"); }
				Employee unboxed_V_1_ = (Employee)V_1_;	// Employee
				codegen.company.Employee unboxed_A_symbol__30 = unboxed_V_1_.getManager();
				Object A_symbol__30 = valueOf(unboxed_A_symbol__30); // Employee
				
				
				
				DomainType static_A_symbol__31 = evaluator.getStaticTypeOf(A_symbol__30, self);
				LibraryBinaryOperation dynamic_A_symbol__31 = (LibraryBinaryOperation)static_A_symbol__31.lookupImplementation(standardLibrary, O_OclAny__eq_);
				Object A_symbol__31 = dynamic_A_symbol__31.evaluate(evaluator, T_Boolean, A_symbol__30, self);
				Object A_symbol__27_bodyVal = A_symbol__31;
				if (A_symbol__27_bodyVal == TRUE_VALUE) {
					acc_A_symbol__27.add(V_1_);
				}
				else if (A_symbol__27_bodyVal == null) {
					throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "select");
				}
			}
			
			return A_symbol__27;
		}}

	/** 
	 * Implementation of the Employee::hasNameAsAttribute '' <derivation>.
	 */
	public static class _hasNameAsAttribute_derivation_ extends AbstractProperty
	{
		public static @NonNull _hasNameAsAttribute_derivation_ INSTANCE = new _hasNameAsAttribute_derivation_();
	
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_String__lt__gt_ = OCLstdlibTables.Operations._String___lt__gt_;
		static final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
		static final Object Null = null;
		
		/*
		name <> null
		*/
		@Override
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Employee unboxed_self = (Employee)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
			
			if (self == null) { throw new InvalidValueException("Null property source"); }
			java.lang.String unboxed_A_symbol__32 = unboxed_self.getName();
			Object A_symbol__32 = unboxed_A_symbol__32; // String
			
			
			Object A_symbol__33 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__32, Null);
			return A_symbol__33;
		}}



	/** 
	 * Implementation of the Employee::reportingChain '' <derivation>.
	 */
	public static class _reportingChain_derivation_ extends AbstractProperty
	{
		public static @NonNull _reportingChain_derivation_ INSTANCE = new _reportingChain_derivation_();
	
		static final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
		static final @NonNull ExecutorOperation O_OclAny_oclIsUndefined = OCLstdlibTables.Operations._OclAny__oclIsUndefined;
		static final @NonNull TypeId T_company__Employee = CodegencompanyTables.Types._Employee.getTypeId();
		static final @NonNull CollectionTypeId T_OrderedSet_company__Employee_ = TypeId.ORDERED_SET.getSpecializedId(T_company__Employee);
		static final @NonNull Object A_symbol__34 = createOrderedSetValue(T_OrderedSet_company__Employee_);
		static final @NonNull ExecutorOperation O_OrderedSet_prepend = OCLstdlibTables.Operations._OrderedSet__prepend;
		
		/*
		if manager.oclIsUndefined()
	then OrderedSet{}
	else manager.reportingChain->prepend(manager)
	endif
		*/
		@Override
		public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @Nullable Object self) throws Exception {
			assert self != null;
			final @NonNull Employee unboxed_self = (Employee)self;
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				codegen.company.Employee unboxed_A_symbol__35 = unboxed_self.getManager();
				Object A_symbol__35 = valueOf(unboxed_A_symbol__35); // Employee
				
				
				Object A_symbol__36 = OclAnyOclIsUndefinedOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__35);
			Object A_symbol__37;
			if (A_symbol__36 == ValuesUtil.TRUE_VALUE) {
				A_symbol__37 = A_symbol__34;
			}
			else if (A_symbol__36 == ValuesUtil.FALSE_VALUE) {
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				codegen.company.Employee unboxed_A_symbol__38 = unboxed_self.getManager();
				Object A_symbol__38 = valueOf(unboxed_A_symbol__38); // Employee
				
				
				if (A_symbol__38 == null) { throw new InvalidValueException("Null property source"); }
				org.eclipse.emf.common.util.EList<codegen.company.Employee> unboxed_A_symbol__39 = unboxed_A_symbol__38.getReportingChain();
				assert unboxed_A_symbol__39 != null;
				final @NonNull Value A_symbol__39 = createOrderedSetValue(T_OrderedSet_company__Employee_, unboxed_A_symbol__39);
				
				
				
				if (self == null) { throw new InvalidValueException("Null property source"); }
				codegen.company.Employee unboxed_A_symbol__40 = unboxed_self.getManager();
				Object A_symbol__40 = valueOf(unboxed_A_symbol__40); // Employee
				
				
				Object A_symbol__41 = OrderedCollectionPrependOperation.INSTANCE.evaluate(evaluator, T_OrderedSet_company__Employee_, A_symbol__39, A_symbol__40);
				A_symbol__37 = A_symbol__41;
			}
			else {
				throw new InvalidValueException("non-Boolean if condition");
			}
			return A_symbol__37;
		}}
}

