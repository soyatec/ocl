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
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryIteration;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;

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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_and = OCLstdlibTables.Operations._Boolean__and;
			final @NonNull ExecutorOperation O_Boolean_not = OCLstdlibTables.Operations._Boolean__not;
			final @NonNull ExecutorOperation O_OclAny_oclIsUndefined = OCLstdlibTables.Operations._OclAny__oclIsUndefined;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_Employee_name = CodegencompanyTables.Properties._Employee__name;
			final @NonNull LibraryProperty IP_Employee_name = P_Employee_name.getImplementation();
			final @NonNull ExecutorProperty P_Employee_hasNameAsAttribute = CodegencompanyTables.Properties._Employee__hasNameAsAttribute;
			final @NonNull LibraryProperty IP_Employee_hasNameAsAttribute = P_Employee_hasNameAsAttribute.getImplementation();
			final @NonNull ExecutorOperation O_Employee_hasNameAsOperation = CodegencompanyTables.Operations._Employee__hasNameAsOperation;
			
			Object leftA_symbol_;
			try {
				Object leftA_symbol__1;
				try {
					
					Object A_symbol__2 = IP_Employee_name.evaluate(evaluator, T_String, self, P_Employee_name);
					
					DomainType static_A_symbol__3 = valueFactory.typeOf(A_symbol__2);
					LibraryUnaryOperation dynamic_A_symbol__3 = (LibraryUnaryOperation)static_A_symbol__3.lookupImplementation(standardLibrary, O_OclAny_oclIsUndefined);
					Object A_symbol__3 = dynamic_A_symbol__3.evaluate(evaluator, T_Boolean, A_symbol__2);
					DomainType static_A_symbol__4 = valueFactory.typeOf(A_symbol__3);
					LibraryUnaryOperation dynamic_A_symbol__4 = (LibraryUnaryOperation)static_A_symbol__4.lookupImplementation(standardLibrary, O_Boolean_not);
					Object A_symbol__4 = dynamic_A_symbol__4.evaluate(evaluator, T_Boolean, A_symbol__3);
					leftA_symbol__1 = A_symbol__4;
				} catch (InvalidValueException e) {
					leftA_symbol__1 = valueFactory.createInvalidValue(e);
				}
				Object A_symbol__4 = leftA_symbol__1;
				Object rightA_symbol__1;
				try {
					
					Object A_symbol__5 = IP_Employee_hasNameAsAttribute.evaluate(evaluator, T_Boolean, self, P_Employee_hasNameAsAttribute);
					
					rightA_symbol__1 = A_symbol__5;
				} catch (InvalidValueException e) {
					rightA_symbol__1 = valueFactory.createInvalidValue(e);
				}
				Object A_symbol__5 = rightA_symbol__1;
				DomainType static_A_symbol__1 = valueFactory.typeOf(A_symbol__4);
				LibraryBinaryOperation dynamic_A_symbol__1 = (LibraryBinaryOperation)static_A_symbol__1.lookupImplementation(standardLibrary, O_Boolean_and);
				Object A_symbol__1 = dynamic_A_symbol__1.evaluate(evaluator, T_Boolean, A_symbol__4, A_symbol__5);
				leftA_symbol_ = A_symbol__1;
			} catch (InvalidValueException e) {
				leftA_symbol_ = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__1 = leftA_symbol_;
			Object rightA_symbol_;
			try {
				
				DomainType static_A_symbol__6 = valueFactory.typeOf(self);
				LibraryUnaryOperation dynamic_A_symbol__6 = (LibraryUnaryOperation)static_A_symbol__6.lookupImplementation(standardLibrary, O_Employee_hasNameAsOperation);
				Object A_symbol__6 = dynamic_A_symbol__6.evaluate(evaluator, T_Boolean, self);
				rightA_symbol_ = A_symbol__6;
			} catch (InvalidValueException e) {
				rightA_symbol_ = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__6 = rightA_symbol_;
			DomainType static_A_symbol_ = valueFactory.typeOf(A_symbol__1);
			LibraryBinaryOperation dynamic_A_symbol_ = (LibraryBinaryOperation)static_A_symbol_.lookupImplementation(standardLibrary, O_Boolean_and);
			Object A_symbol_ = dynamic_A_symbol_.evaluate(evaluator, T_Boolean, A_symbol__1, A_symbol__6);
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_Collection_notEmpty = OCLstdlibTables.Operations._Collection__notEmpty;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull DomainCollectionType T_Set_String_ = standardLibrary.getSetType(T_String, null, null);
			final @NonNull ExecutorOperation O_OclAny_oclAsSet = OCLstdlibTables.Operations._OclAny__oclAsSet;
			final @NonNull ExecutorProperty P_Employee_name = CodegencompanyTables.Properties._Employee__name;
			final @NonNull LibraryProperty IP_Employee_name = P_Employee_name.getImplementation();
			final @NonNull ExecutorOperation O_Real__gt_ = OCLstdlibTables.Operations._Real___gt_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_String_size = OCLstdlibTables.Operations._String__size;
			final @NonNull IntegerValue I_0 = valueFactory.integerValueOf(0);
			
			Object leftA_symbol__7;
			try {
				
				Object A_symbol__8 = IP_Employee_name.evaluate(evaluator, T_String, self, P_Employee_name);
				
				DomainType static_A_symbol__9 = valueFactory.typeOf(A_symbol__8);
				LibraryUnaryOperation dynamic_A_symbol__9 = (LibraryUnaryOperation)static_A_symbol__9.lookupImplementation(standardLibrary, O_OclAny_oclAsSet);
				Object A_symbol__9 = dynamic_A_symbol__9.evaluate(evaluator, T_Set_String_, A_symbol__8);
				DomainType static_A_symbol__10 = valueFactory.typeOf(A_symbol__9);
				LibraryUnaryOperation dynamic_A_symbol__10 = (LibraryUnaryOperation)static_A_symbol__10.lookupImplementation(standardLibrary, O_Collection_notEmpty);
				Object A_symbol__10 = dynamic_A_symbol__10.evaluate(evaluator, T_Boolean, A_symbol__9);
				leftA_symbol__7 = A_symbol__10;
			} catch (InvalidValueException e) {
				leftA_symbol__7 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__10 = leftA_symbol__7;
			Object rightA_symbol__7;
			try {
				
				Object A_symbol__11 = IP_Employee_name.evaluate(evaluator, T_String, self, P_Employee_name);
				
				DomainType static_A_symbol__12 = valueFactory.typeOf(A_symbol__11);
				LibraryUnaryOperation dynamic_A_symbol__12 = (LibraryUnaryOperation)static_A_symbol__12.lookupImplementation(standardLibrary, O_String_size);
				Object A_symbol__12 = dynamic_A_symbol__12.evaluate(evaluator, T_Integer, A_symbol__11);
				DomainType static_A_symbol__13 = valueFactory.typeOf(A_symbol__12, I_0);
				LibraryBinaryOperation dynamic_A_symbol__13 = (LibraryBinaryOperation)static_A_symbol__13.lookupImplementation(standardLibrary, O_Real__gt_);
				Object A_symbol__13 = dynamic_A_symbol__13.evaluate(evaluator, T_Boolean, A_symbol__12, I_0);
				rightA_symbol__7 = A_symbol__13;
			} catch (InvalidValueException e) {
				rightA_symbol__7 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__13 = rightA_symbol__7;
			DomainType static_A_symbol__7 = valueFactory.typeOf(A_symbol__10);
			LibraryBinaryOperation dynamic_A_symbol__7 = (LibraryBinaryOperation)static_A_symbol__7.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__7 = dynamic_A_symbol__7.evaluate(evaluator, T_Boolean, A_symbol__10, A_symbol__13);
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Boolean_implies = OCLstdlibTables.Operations._Boolean__implies;
			final @NonNull ExecutorOperation O_OclAny_oclIsUndefined = OCLstdlibTables.Operations._OclAny__oclIsUndefined;
			final @NonNull ExecutorType T_company__Employee = CodegencompanyTables.Types._Employee;
			final @NonNull ExecutorProperty P_Employee_manager = CodegencompanyTables.Properties._Employee__manager;
			final @NonNull LibraryProperty IP_Employee_manager = P_Employee_manager.getImplementation();
			final @NonNull ExecutorOperation O_Real__gt_ = OCLstdlibTables.Operations._Real___gt_;
			final @NonNull ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final @NonNull ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final @NonNull DomainCollectionType T_OrderedSet_company__Employee_ = standardLibrary.getOrderedSetType(T_company__Employee, null, null);
			final @NonNull ExecutorProperty P_Employee_directReports = CodegencompanyTables.Properties._Employee__directReports;
			final @NonNull LibraryProperty IP_Employee_directReports = P_Employee_directReports.getImplementation();
			final @NonNull IntegerValue I_0 = valueFactory.integerValueOf(0);
			
			Object leftA_symbol__14;
			try {
				
				Object A_symbol__15 = IP_Employee_manager.evaluate(evaluator, T_company__Employee, self, P_Employee_manager);
				
				DomainType static_A_symbol__16 = valueFactory.typeOf(A_symbol__15);
				LibraryUnaryOperation dynamic_A_symbol__16 = (LibraryUnaryOperation)static_A_symbol__16.lookupImplementation(standardLibrary, O_OclAny_oclIsUndefined);
				Object A_symbol__16 = dynamic_A_symbol__16.evaluate(evaluator, T_Boolean, A_symbol__15);
				leftA_symbol__14 = A_symbol__16;
			} catch (InvalidValueException e) {
				leftA_symbol__14 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__16 = leftA_symbol__14;
			Object rightA_symbol__14;
			try {
				
				Object A_symbol__17 = IP_Employee_directReports.evaluate(evaluator, T_OrderedSet_company__Employee_, self, P_Employee_directReports);
				
				DomainType static_A_symbol__18 = valueFactory.typeOf(A_symbol__17);
				LibraryUnaryOperation dynamic_A_symbol__18 = (LibraryUnaryOperation)static_A_symbol__18.lookupImplementation(standardLibrary, O_Collection_size);
				Object A_symbol__18 = dynamic_A_symbol__18.evaluate(evaluator, T_Integer, A_symbol__17);
				DomainType static_A_symbol__19 = valueFactory.typeOf(A_symbol__18, I_0);
				LibraryBinaryOperation dynamic_A_symbol__19 = (LibraryBinaryOperation)static_A_symbol__19.lookupImplementation(standardLibrary, O_Real__gt_);
				Object A_symbol__19 = dynamic_A_symbol__19.evaluate(evaluator, T_Boolean, A_symbol__18, I_0);
				rightA_symbol__14 = A_symbol__19;
			} catch (InvalidValueException e) {
				rightA_symbol__14 = valueFactory.createInvalidValue(e);
			}
			Object A_symbol__19 = rightA_symbol__14;
			DomainType static_A_symbol__14 = valueFactory.typeOf(A_symbol__16);
			LibraryBinaryOperation dynamic_A_symbol__14 = (LibraryBinaryOperation)static_A_symbol__14.lookupImplementation(standardLibrary, O_Boolean_implies);
			Object A_symbol__14 = dynamic_A_symbol__14.evaluate(evaluator, T_Boolean, A_symbol__16, A_symbol__19);
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_String__lt__gt_ = OCLstdlibTables.Operations._String___lt__gt_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_Employee_name = CodegencompanyTables.Properties._Employee__name;
			final @NonNull LibraryProperty IP_Employee_name = P_Employee_name.getImplementation();
			final @NonNull NullValue Null = valueFactory.getNull();
			
			
			Object A_symbol__20 = IP_Employee_name.evaluate(evaluator, T_String, self, P_Employee_name);
			
			DomainType static_A_symbol__21 = valueFactory.typeOf(A_symbol__20, Null);
			LibraryBinaryOperation dynamic_A_symbol__21 = (LibraryBinaryOperation)static_A_symbol__21.lookupImplementation(standardLibrary, O_String__lt__gt_);
			Object A_symbol__21 = dynamic_A_symbol__21.evaluate(evaluator, T_Boolean, A_symbol__20, Null);
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self, final @NonNull Object manager) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Collection_includes = OCLstdlibTables.Operations._Collection__includes;
			final @NonNull ExecutorType T_company__Employee = CodegencompanyTables.Types._Employee;
			final @NonNull DomainCollectionType T_OrderedSet_company__Employee_ = standardLibrary.getOrderedSetType(T_company__Employee, null, null);
			final @NonNull ExecutorProperty P_Employee_reportingChain = CodegencompanyTables.Properties._Employee__reportingChain;
			final @NonNull LibraryProperty IP_Employee_reportingChain = P_Employee_reportingChain.getImplementation();
			
			
			Object A_symbol__22 = IP_Employee_reportingChain.evaluate(evaluator, T_OrderedSet_company__Employee_, self, P_Employee_reportingChain);
			
			
			DomainType static_A_symbol__23 = valueFactory.typeOf(A_symbol__22);
			LibraryBinaryOperation dynamic_A_symbol__23 = (LibraryBinaryOperation)static_A_symbol__23.lookupImplementation(standardLibrary, O_Collection_includes);
			Object A_symbol__23 = dynamic_A_symbol__23.evaluate(evaluator, T_Boolean, A_symbol__22, manager);
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self, @NonNull DomainProperty property) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_company__Employee = CodegencompanyTables.Types._Employee;
			final @NonNull DomainCollectionType T_Set_company__Employee_ = standardLibrary.getSetType(T_company__Employee, null, null);
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_Set_select = OCLstdlibTables.Operations._Set__select;
			final @NonNull ExecutorOperation O_OclElement_allInstances = OCLstdlibTables.Operations._OclElement__allInstances;
			final @NonNull Object T_Metaclass_company__Employee_ = valueFactory.createTypeValue(CodegencompanyTables.Types._Employee);
			final @NonNull ExecutorOperation O_Employee_reportsTo = CodegencompanyTables.Operations._Employee__reportsTo;
			
			DomainType static_A_symbol__24 = valueFactory.typeOf(T_Metaclass_company__Employee_);
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
				public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Object sourceValue, @NonNull Object iterator1) throws InvalidValueException {
					final @NonNull Object V_1_ = iterator1;	// iterator: 1_
					
					
					DomainType static_A_symbol__26 = valueFactory.typeOf(V_1_);
					LibraryBinaryOperation dynamic_A_symbol__26 = (LibraryBinaryOperation)static_A_symbol__26.lookupImplementation(standardLibrary, O_Employee_reportsTo);
					Object A_symbol__26 = dynamic_A_symbol__26.evaluate(evaluator, T_Boolean, V_1_, self);
					return A_symbol__26;
				}
			};
			DomainType static_A_symbol__25 = valueFactory.typeOf(A_symbol__24);
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self, @NonNull DomainProperty property) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_company__Employee = CodegencompanyTables.Types._Employee;
			final @NonNull DomainCollectionType T_OrderedSet_company__Employee_ = standardLibrary.getOrderedSetType(T_company__Employee, null, null);
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_OrderedSet_select = OCLstdlibTables.Operations._OrderedSet__select;
			final @NonNull ExecutorProperty P_Company_employees = CodegencompanyTables.Properties._Company__employees;
			final @NonNull LibraryProperty IP_Company_employees = P_Company_employees.getImplementation();
			final @NonNull ExecutorType T_company__Company = CodegencompanyTables.Types._Company;
			final @NonNull ExecutorProperty P_Employee_company = CodegencompanyTables.Properties._Employee__company;
			final @NonNull LibraryProperty IP_Employee_company = P_Employee_company.getImplementation();
			final @NonNull ExecutorOperation O_OclAny__eq_ = OCLstdlibTables.Operations._OclAny___eq_;
			final @NonNull ExecutorProperty P_Employee_manager = CodegencompanyTables.Properties._Employee__manager;
			final @NonNull LibraryProperty IP_Employee_manager = P_Employee_manager.getImplementation();
			
			
			Object A_symbol__29 = IP_Employee_company.evaluate(evaluator, T_company__Company, self, P_Employee_company);
			
			Object A_symbol__27 = IP_Company_employees.evaluate(evaluator, T_OrderedSet_company__Employee_, A_symbol__29, P_Company_employees);
			
			
			/** 
			 * Implementation of the iterator body.
			 */
			AbstractBinaryOperation body_A_symbol__28 = new AbstractBinaryOperation()
			{
			/*
			manager = self
			*/
				public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, @NonNull Object sourceValue, @NonNull Object iterator1) throws InvalidValueException {
					final @NonNull Object V_1_ = iterator1;	// iterator: 1_
					
					Object A_symbol__30 = IP_Employee_manager.evaluate(evaluator, T_company__Employee, V_1_, P_Employee_manager);
					
					
					DomainType static_A_symbol__31 = valueFactory.typeOf(A_symbol__30, self);
					LibraryBinaryOperation dynamic_A_symbol__31 = (LibraryBinaryOperation)static_A_symbol__31.lookupImplementation(standardLibrary, O_OclAny__eq_);
					Object A_symbol__31 = dynamic_A_symbol__31.evaluate(evaluator, T_Boolean, A_symbol__30, self);
					return A_symbol__31;
				}
			};
			DomainType static_A_symbol__28 = valueFactory.typeOf(A_symbol__27);
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self, @NonNull DomainProperty property) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_String__lt__gt_ = OCLstdlibTables.Operations._String___lt__gt_;
			final @NonNull ExecutorType T_String = OCLstdlibTables.Types._String;
			final @NonNull ExecutorProperty P_Employee_name = CodegencompanyTables.Properties._Employee__name;
			final @NonNull LibraryProperty IP_Employee_name = P_Employee_name.getImplementation();
			final @NonNull NullValue Null = valueFactory.getNull();
			
			
			Object A_symbol__32 = IP_Employee_name.evaluate(evaluator, T_String, self, P_Employee_name);
			
			DomainType static_A_symbol__33 = valueFactory.typeOf(A_symbol__32, Null);
			LibraryBinaryOperation dynamic_A_symbol__33 = (LibraryBinaryOperation)static_A_symbol__33.lookupImplementation(standardLibrary, O_String__lt__gt_);
			Object A_symbol__33 = dynamic_A_symbol__33.evaluate(evaluator, T_Boolean, A_symbol__32, Null);
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
		public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainType returnType, final @NonNull Object self, @NonNull DomainProperty property) throws InvalidValueException {
			final @NonNull ValueFactory valueFactory = evaluator.getValueFactory();
			final @NonNull DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final @NonNull ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final @NonNull ExecutorOperation O_OclAny_oclIsUndefined = OCLstdlibTables.Operations._OclAny__oclIsUndefined;
			final @NonNull ExecutorType T_company__Employee = CodegencompanyTables.Types._Employee;
			final @NonNull ExecutorProperty P_Employee_manager = CodegencompanyTables.Properties._Employee__manager;
			final @NonNull LibraryProperty IP_Employee_manager = P_Employee_manager.getImplementation();
			final @NonNull DomainCollectionType T_OrderedSet_company__Employee_ = standardLibrary.getOrderedSetType(T_company__Employee, null, null);
			final @NonNull Object A_symbol__34 = valueFactory.createOrderedSetValue(T_OrderedSet_company__Employee_);
			final @NonNull ExecutorOperation O_OrderedSet_prepend = OCLstdlibTables.Operations._OrderedSet__prepend;
			final @NonNull ExecutorProperty P_Employee_reportingChain = CodegencompanyTables.Properties._Employee__reportingChain;
			final @NonNull LibraryProperty IP_Employee_reportingChain = P_Employee_reportingChain.getImplementation();
			
				
				Object A_symbol__35 = IP_Employee_manager.evaluate(evaluator, T_company__Employee, self, P_Employee_manager);
				
				DomainType static_A_symbol__36 = valueFactory.typeOf(A_symbol__35);
				LibraryUnaryOperation dynamic_A_symbol__36 = (LibraryUnaryOperation)static_A_symbol__36.lookupImplementation(standardLibrary, O_OclAny_oclIsUndefined);
				Object A_symbol__36 = dynamic_A_symbol__36.evaluate(evaluator, T_Boolean, A_symbol__35);
			Object A_symbol__37;
			if (ValuesUtil.isTrue(A_symbol__36)) {
				A_symbol__37 = A_symbol__34;
			}
			else if (ValuesUtil.isFalse(A_symbol__36)) {
				
				Object A_symbol__38 = IP_Employee_manager.evaluate(evaluator, T_company__Employee, self, P_Employee_manager);
				
				Object A_symbol__39 = IP_Employee_reportingChain.evaluate(evaluator, T_OrderedSet_company__Employee_, A_symbol__38, P_Employee_reportingChain);
				
				
				Object A_symbol__40 = IP_Employee_manager.evaluate(evaluator, T_company__Employee, self, P_Employee_manager);
				
				DomainType static_A_symbol__41 = valueFactory.typeOf(A_symbol__39);
				LibraryBinaryOperation dynamic_A_symbol__41 = (LibraryBinaryOperation)static_A_symbol__41.lookupImplementation(standardLibrary, O_OrderedSet_prepend);
				Object A_symbol__41 = dynamic_A_symbol__41.evaluate(evaluator, T_OrderedSet_company__Employee_, A_symbol__39, A_symbol__40);
				A_symbol__37 = A_symbol__41;
			}
			else if (ValuesUtil.isNull(A_symbol__36)) {
				A_symbol__37 = valueFactory.throwInvalidValueException("null if condition");
			}
			else {
				A_symbol__37 = valueFactory.throwInvalidValueException("invalid if condition");
			}
			return A_symbol__37;
		}}
}

