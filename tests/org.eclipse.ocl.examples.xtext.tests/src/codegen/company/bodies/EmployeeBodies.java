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
import codegen.company.Employee;
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
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
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
@SuppressWarnings("nls")
public class EmployeeBodies
{

	/** 
	 * Implementation of the Employee 'mustHaveName' invariant.
	 */
	public static class _invariant_mustHaveName extends AbstractUnaryOperation
	{
		public static @NonNull _invariant_mustHaveName INSTANCE = new _invariant_mustHaveName();
	
		/*
		not name.oclIsUndefined() and hasNameAsAttribute and hasNameAsOperation()
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
			final @NonNull ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
			final @NonNull ExecutorOperation O_Boolean_not = OCLstdlibTables.Operations._Boolean__not;
			final @NonNull ExecutorOperation O_OclAny_oclIsUndefined = OCLstdlibTables.Operations._OclAny__oclIsUndefined;
			final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
			final @NonNull ExecutorOperation O_Employee_hasNameAsOperation = CodegencompanyTables.Operations._Employee__hasNameAsOperation;
			
			Object leftA_symbol_;
			try {
				Object leftA_symbol__1;
				try {
					
					Employee unboxed_self = (Employee)self;
					java.lang.String unboxed_A_symbol__2 = unboxed_self.getName();
					Object A_symbol__2 = unboxed_A_symbol__2 != null ? unboxed_A_symbol__2 : null;
					
					
					Object A_symbol__3 = OclAnyOclIsUndefinedOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__2);
					Object A_symbol__4 = BooleanNotOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__3);
					leftA_symbol__1 = A_symbol__4;
				} catch (InvalidValueException e) {
					leftA_symbol__1 = createInvalidValue(e);
				}
				Object A_symbol__4 = leftA_symbol__1;
				Object rightA_symbol__1;
				try {
					
					Employee unboxed_self = (Employee)self;
					java.lang.Boolean unboxed_A_symbol__5 = unboxed_self.isHasNameAsAttribute();
					Object A_symbol__5 = unboxed_A_symbol__5 != null ? unboxed_A_symbol__5 : null;
					
					
					rightA_symbol__1 = A_symbol__5;
				} catch (InvalidValueException e) {
					rightA_symbol__1 = createInvalidValue(e);
				}
				Object A_symbol__5 = rightA_symbol__1;
				Object A_symbol__1 = BooleanAndOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__4, A_symbol__5);
				leftA_symbol_ = A_symbol__1;
			} catch (InvalidValueException e) {
				leftA_symbol_ = createInvalidValue(e);
			}
			Object A_symbol__1 = leftA_symbol_;
			Object rightA_symbol_;
			try {
				
				Object A_symbol__6 = _hasNameAsOperation_body_.INSTANCE.evaluate(evaluator, T_Boolean, self);
				rightA_symbol_ = A_symbol__6;
			} catch (InvalidValueException e) {
				rightA_symbol_ = createInvalidValue(e);
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
	
		/*
		name->notEmpty() implies name.size() > 0
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_Collection_notEmpty = OCLstdlibTables.Operations._Collection__notEmpty;
			final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
			final @NonNull CollectionTypeId T_Set_String_ = TypeId.SET.getSpecializedId(T_String);
			final @NonNull ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
			final @NonNull ExecutorOperation O_Real__gt_ = OCLstdlibTables.Operations._Real___gt_;
			final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
			final @NonNull ExecutorOperation O_String_size = OCLstdlibTables.Operations._String__size;
			final @NonNull IntegerValue I_0 = integerValueOf(0);
			
			Object leftA_symbol__7;
			try {
				
				Employee unboxed_self = (Employee)self;
				java.lang.String unboxed_A_symbol__8 = unboxed_self.getName();
				Object A_symbol__8 = unboxed_A_symbol__8 != null ? unboxed_A_symbol__8 : null;
				
				
				Object A_symbol__9 = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, T_Set_String_, A_symbol__8);
				Object A_symbol__10 = CollectionNotEmptyOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__9);
				leftA_symbol__7 = A_symbol__10;
			} catch (InvalidValueException e) {
				leftA_symbol__7 = createInvalidValue(e);
			}
			Object A_symbol__10 = leftA_symbol__7;
			Object rightA_symbol__7;
			try {
				
				Employee unboxed_self = (Employee)self;
				java.lang.String unboxed_A_symbol__11 = unboxed_self.getName();
				Object A_symbol__11 = unboxed_A_symbol__11 != null ? unboxed_A_symbol__11 : null;
				
				
				Object A_symbol__12 = StringSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__11);
				Object A_symbol__13 = NumericGreaterThanOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__12, I_0);
				rightA_symbol__7 = A_symbol__13;
			} catch (InvalidValueException e) {
				rightA_symbol__7 = createInvalidValue(e);
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
	
		/*
		manager.oclIsUndefined() implies directReports->size() > 0
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_OclAny_oclIsUndefined = OCLstdlibTables.Operations._OclAny__oclIsUndefined;
			final @NonNull TypeId T_company__Employee = CodegencompanyTables.Types._Employee.getTypeId();
			final @NonNull ExecutorOperation O_Real__gt_ = OCLstdlibTables.Operations._Real___gt_;
			final @NonNull PrimitiveTypeId T_Integer = TypeId.INTEGER;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull CollectionTypeId T_OrderedSet_company__Employee_ = TypeId.ORDERED_SET.getSpecializedId(T_company__Employee);
			final @NonNull IntegerValue I_0 = integerValueOf(0);
			
			Object leftA_symbol__14;
			try {
				
				Employee unboxed_self = (Employee)self;
				codegen.company.Employee unboxed_A_symbol__15 = unboxed_self.getManager();
				Object A_symbol__15 = unboxed_A_symbol__15 != null ? unboxed_A_symbol__15 : null;
				
				
				Object A_symbol__16 = OclAnyOclIsUndefinedOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__15);
				leftA_symbol__14 = A_symbol__16;
			} catch (InvalidValueException e) {
				leftA_symbol__14 = createInvalidValue(e);
			}
			Object A_symbol__16 = leftA_symbol__14;
			Object rightA_symbol__14;
			try {
				
				Employee unboxed_self = (Employee)self;
				org.eclipse.emf.common.util.EList<codegen.company.Employee> unboxed_A_symbol__17 = unboxed_self.getDirectReports();
				Value A_symbol__17 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_company__Employee_, unboxed_A_symbol__17);
				
				
				Object A_symbol__18 = CollectionSizeOperation.INSTANCE.evaluate(evaluator, T_Integer, A_symbol__17);
				Object A_symbol__19 = NumericGreaterThanOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__18, I_0);
				rightA_symbol__14 = A_symbol__19;
			} catch (InvalidValueException e) {
				rightA_symbol__14 = createInvalidValue(e);
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
	
		/*
		name <> null
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
			final @NonNull ExecutorOperation O_String__lt__gt_ = OCLstdlibTables.Operations._String___lt__gt_;
			final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
			final @NonNull NullValue Null = null;
			
			
			Employee unboxed_self = (Employee)self;
			java.lang.String unboxed_A_symbol__20 = unboxed_self.getName();
			Object A_symbol__20 = unboxed_A_symbol__20 != null ? unboxed_A_symbol__20 : null;
			
			
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
	
		/*
		self.reportingChain->includes(manager)
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self, final @NonNull Object manager) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
			final @NonNull ExecutorOperation O_Collection_includes = OCLstdlibTables.Operations._Collection__includes;
			final @NonNull TypeId T_company__Employee = CodegencompanyTables.Types._Employee.getTypeId();
			final @NonNull CollectionTypeId T_OrderedSet_company__Employee_ = TypeId.ORDERED_SET.getSpecializedId(T_company__Employee);
			
			
			Employee unboxed_self = (Employee)self;
			org.eclipse.emf.common.util.EList<codegen.company.Employee> unboxed_A_symbol__22 = unboxed_self.getReportingChain();
			Value A_symbol__22 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_company__Employee_, unboxed_A_symbol__22);
			
			
			
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
	
		/*
		Employee.allInstances()->select(reportsTo(self))
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self, @NonNull DomainProperty property) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull TypeId T_company__Employee = CodegencompanyTables.Types._Employee.getTypeId();
			final @NonNull CollectionTypeId T_Set_company__Employee_ = TypeId.SET.getSpecializedId(T_company__Employee);
			final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
			final @NonNull ExecutorOperation O_Set_select = OCLstdlibTables.Operations._Set__select;
			final @NonNull ExecutorOperation O_OclElement_allInstances = OCLstdlibTables.Operations._OclElement__allInstances;
			final @NonNull Object T_Metaclass_company__Employee_ = createTypeValue(CodegencompanyTables.Types._Employee);
			final @NonNull ExecutorOperation O_Employee_reportsTo = CodegencompanyTables.Operations._Employee__reportsTo;
			
			DomainType static_A_symbol__24 = evaluator.getStaticTypeOf(T_Metaclass_company__Employee_);
			LibraryUnaryOperation dynamic_A_symbol__24 = (LibraryUnaryOperation)static_A_symbol__24.lookupImplementation(standardLibrary, O_OclElement_allInstances);
			Object A_symbol__24 = dynamic_A_symbol__24.evaluate(evaluator, T_Set_company__Employee_, T_Metaclass_company__Employee_);
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol__25 = new AbstractBinaryOperation()
			{
			/*
			reportsTo(self)
			*/
			public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull Object iterator1) throws InvalidValueException {
					final @NonNull Object V_1_ = iterator1;	// iterator: 1_
					
					
					Object A_symbol__26 = _reportsTo_body_.INSTANCE.evaluate(evaluator, T_Boolean, V_1_, self);
					return A_symbol__26;
				}
			};
			DomainType static_A_symbol__25 = evaluator.getStaticTypeOf(A_symbol__24);
			LibraryIteration dynamic_A_symbol__25 = (LibraryIteration)static_A_symbol__25.lookupImplementation(standardLibrary, O_Set_select);
			Object acc_A_symbol__25 = dynamic_A_symbol__25.createAccumulatorValue(evaluator, T_Set_company__Employee_, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol__25 = new ExecutorSingleIterationManager(evaluator, T_Set_company__Employee_, body_A_symbol__25, (CollectionValue)A_symbol__24, acc_A_symbol__25);
			Object A_symbol__25 = dynamic_A_symbol__25.evaluateIteration(manager_A_symbol__25);
			return A_symbol__25;
		}}


	/** 
	 * Implementation of the Employee::directReports '' <derivation>.
	 */
	public static class _directReports_derivation_ extends AbstractProperty
	{
		public static @NonNull _directReports_derivation_ INSTANCE = new _directReports_derivation_();
	
		/*
		company.employees->select(manager = self)
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self, @NonNull DomainProperty property) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull TypeId T_company__Employee = CodegencompanyTables.Types._Employee.getTypeId();
			final @NonNull CollectionTypeId T_OrderedSet_company__Employee_ = TypeId.ORDERED_SET.getSpecializedId(T_company__Employee);
			final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
			final @NonNull ExecutorOperation O_OrderedSet_select = OCLstdlibTables.Operations._OrderedSet__select;
			final @NonNull TypeId T_company__Company = CodegencompanyTables.Types._Company.getTypeId();
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			
			
			Employee unboxed_self = (Employee)self;
			codegen.company.Company unboxed_A_symbol__29 = unboxed_self.getCompany();
			Object A_symbol__29 = unboxed_A_symbol__29 != null ? unboxed_A_symbol__29 : null;
			
			
			org.eclipse.emf.common.util.EList<codegen.company.Employee> unboxed_A_symbol__27 = unboxed_A_symbol__29.getEmployees();
			Value A_symbol__27 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_company__Employee_, unboxed_A_symbol__27);
			
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol__28 = new AbstractBinaryOperation()
			{
			/*
			manager = self
			*/
			public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull Object sourceValue, @NonNull Object iterator1) throws InvalidValueException {
					final @NonNull Object V_1_ = iterator1;	// iterator: 1_
					
					Employee unboxed_V_1_ = (Employee)V_1_;
					codegen.company.Employee unboxed_A_symbol__30 = unboxed_V_1_.getManager();
					Object A_symbol__30 = unboxed_A_symbol__30 != null ? unboxed_A_symbol__30 : null;
					
					
					
					DomainType static_A_symbol__31 = evaluator.getStaticTypeOf(A_symbol__30, self);
					LibraryBinaryOperation dynamic_A_symbol__31 = (LibraryBinaryOperation)static_A_symbol__31.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Object A_symbol__31 = dynamic_A_symbol__31.evaluate(evaluator, T_Boolean, A_symbol__30, self);
					return A_symbol__31;
				}
			};
			DomainType static_A_symbol__28 = evaluator.getStaticTypeOf(A_symbol__27);
			LibraryIteration dynamic_A_symbol__28 = (LibraryIteration)static_A_symbol__28.lookupImplementation(standardLibrary, O_OrderedSet_select);
			Object acc_A_symbol__28 = dynamic_A_symbol__28.createAccumulatorValue(evaluator, T_OrderedSet_company__Employee_, T_Boolean);
			ExecutorSingleIterationManager manager_A_symbol__28 = new ExecutorSingleIterationManager(evaluator, T_OrderedSet_company__Employee_, body_A_symbol__28, (CollectionValue)A_symbol__27, acc_A_symbol__28);
			Object A_symbol__28 = dynamic_A_symbol__28.evaluateIteration(manager_A_symbol__28);
			return A_symbol__28;
		}}

	/** 
	 * Implementation of the Employee::hasNameAsAttribute '' <derivation>.
	 */
	public static class _hasNameAsAttribute_derivation_ extends AbstractProperty
	{
		public static @NonNull _hasNameAsAttribute_derivation_ INSTANCE = new _hasNameAsAttribute_derivation_();
	
		/*
		name <> null
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self, @NonNull DomainProperty property) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
			final @NonNull ExecutorOperation O_String__lt__gt_ = OCLstdlibTables.Operations._String___lt__gt_;
			final @NonNull PrimitiveTypeId T_String = TypeId.STRING;
			final @NonNull NullValue Null = null;
			
			
			Employee unboxed_self = (Employee)self;
			java.lang.String unboxed_A_symbol__32 = unboxed_self.getName();
			Object A_symbol__32 = unboxed_A_symbol__32 != null ? unboxed_A_symbol__32 : null;
			
			
			Object A_symbol__33 = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__32, Null);
			return A_symbol__33;
		}}



	/** 
	 * Implementation of the Employee::reportingChain '' <derivation>.
	 */
	public static class _reportingChain_derivation_ extends AbstractProperty
	{
		public static @NonNull _reportingChain_derivation_ INSTANCE = new _reportingChain_derivation_();
	
		/*
		if manager.oclIsUndefined()
	then OrderedSet{}
	else manager.reportingChain->prepend(manager)
	endif
		*/
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, final @NonNull Object self, @NonNull DomainProperty property) throws InvalidValueException {
			final @NonNull DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
			final @NonNull PrimitiveTypeId T_Boolean = TypeId.BOOLEAN;
			final @NonNull ExecutorOperation O_OclAny_oclIsUndefined = OCLstdlibTables.Operations._OclAny__oclIsUndefined;
			final @NonNull TypeId T_company__Employee = CodegencompanyTables.Types._Employee.getTypeId();
			final @NonNull CollectionTypeId T_OrderedSet_company__Employee_ = TypeId.ORDERED_SET.getSpecializedId(T_company__Employee);
			final @NonNull Object A_symbol__34 = createOrderedSetValue(T_OrderedSet_company__Employee_);
			final @NonNull ExecutorOperation O_OrderedSet_prepend = OCLstdlibTables.Operations._OrderedSet__prepend;
			
				
				Employee unboxed_self = (Employee)self;
				codegen.company.Employee unboxed_A_symbol__35 = unboxed_self.getManager();
				Object A_symbol__35 = unboxed_A_symbol__35 != null ? unboxed_A_symbol__35 : null;
				
				
				Object A_symbol__36 = OclAnyOclIsUndefinedOperation.INSTANCE.evaluate(evaluator, T_Boolean, A_symbol__35);
			Object A_symbol__37;
			if (A_symbol__36 == ValuesUtil.TRUE_VALUE) {
				A_symbol__37 = A_symbol__34;
			}
			else if (A_symbol__36 == ValuesUtil.FALSE_VALUE) {
				
				codegen.company.Employee unboxed_A_symbol__38 = unboxed_self.getManager();
				Object A_symbol__38 = unboxed_A_symbol__38 != null ? unboxed_A_symbol__38 : null;
				
				
				org.eclipse.emf.common.util.EList<codegen.company.Employee> unboxed_A_symbol__39 = unboxed_A_symbol__38.getReportingChain();
				Value A_symbol__39 = standardLibrary.createOrderedSetValueOf(T_OrderedSet_company__Employee_, unboxed_A_symbol__39);
				
				
				
				codegen.company.Employee unboxed_A_symbol__40 = unboxed_self.getManager();
				Object A_symbol__40 = unboxed_A_symbol__40 != null ? unboxed_A_symbol__40 : null;
				
				
				Object A_symbol__41 = OrderedCollectionPrependOperation.INSTANCE.evaluate(evaluator, T_OrderedSet_company__Employee_, A_symbol__39, A_symbol__40);
				A_symbol__37 = A_symbol__41;
			}
			else {
				A_symbol__37 = createInvalidValue("non-Boolean if condition");
			}
			return A_symbol__37;
		}}
}

