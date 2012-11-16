/**
 * 
 *************************************************************************
 * This code is 100% auto-generated
 * from: company
 * using: org.eclipse.ocl.examples.codegen.tables.model2tables.mtl
 *
 * Do not edit it.
 */
package codegen.company;

import org.eclipse.jdt.annotation.NonNull;
import codegen.company.CodegencompanyTables;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumeration;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumerationLiteral;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.examples.library.ecore.EcoreLibraryProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorFragment;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;

/**
 * CodegencompanyTables provides the dispatch tables for the company for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class CodegencompanyTables
{
	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(CodegencompanyPackage.eINSTANCE);

/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;  //new ExecutorStandardLibrary(PACKAGE); 

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
	    public static final @NonNull EcoreExecutorType _Company = new EcoreExecutorType(CodegencompanyPackage.Literals.COMPANY, PACKAGE, 0);
	    public static final @NonNull EcoreExecutorEnumeration _CompanySizeKind = new EcoreExecutorEnumeration(CodegencompanyPackage.Literals.COMPANY_SIZE_KIND, PACKAGE, 0);
	    public static final @NonNull EcoreExecutorType _Employee = new EcoreExecutorType(CodegencompanyPackage.Literals.EMPLOYEE, PACKAGE, 0);
	
		private static final @NonNull EcoreExecutorType[] types = {
		    _Company,
		    _CompanySizeKind,
		    _Employee
		};
	
		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			TypeFragments.init();
			FragmentOperations.init();
			FragmentProperties.init();
			EnumerationLiterals.init();
		}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		public static final @NonNull ExecutorFragment _Company__Company = new ExecutorFragment(Types._Company, CodegencompanyTables.Types._Company);
		public static final @NonNull ExecutorFragment _Company__OclAny = new ExecutorFragment(Types._Company, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Company__OclElement = new ExecutorFragment(Types._Company, OCLstdlibTables.Types._OclElement);
		
		public static final @NonNull ExecutorFragment _CompanySizeKind__CompanySizeKind = new ExecutorFragment(Types._CompanySizeKind, CodegencompanyTables.Types._CompanySizeKind);
		public static final @NonNull ExecutorFragment _CompanySizeKind__OclAny = new ExecutorFragment(Types._CompanySizeKind, OCLstdlibTables.Types._OclAny);
		
		public static final @NonNull ExecutorFragment _Employee__Employee = new ExecutorFragment(Types._Employee, CodegencompanyTables.Types._Employee);
		public static final @NonNull ExecutorFragment _Employee__OclAny = new ExecutorFragment(Types._Employee, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Employee__OclElement = new ExecutorFragment(Types._Employee, OCLstdlibTables.Types._OclElement);
		
	}

	/**
	 *	The parameter lists shared by operations.
	 */
	public static class Parameters {
		public static final @NonNull DomainParameterTypes _ = new DomainParameterTypes();
		public static final @NonNull DomainParameterTypes _Employee = new DomainParameterTypes(CodegencompanyTables.Types._Employee);
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 */
	public static class Operations {
		public static final @NonNull ExecutorOperation _Employee__hasNameAsOperation = new ExecutorOperation("hasNameAsOperation", Parameters._, Types._Employee,
			0, DomainTypeParameters.EMPTY_LIST, codegen.company.bodies.EmployeeBodies._hasNameAsOperation_body_.INSTANCE);
		public static final @NonNull ExecutorOperation _Employee__reportsTo = new ExecutorOperation("reportsTo", Parameters._Employee, Types._Employee,
			1, DomainTypeParameters.EMPTY_LIST, codegen.company.bodies.EmployeeBodies._reportsTo_body_.INSTANCE);
	}

	/**
	 *	The property descriptors for each property of each type.
	 */
	public static class Properties {
		public static final @NonNull ExecutorProperty _Company__employees = new ExecutorProperty("employees", Types._Company, 0, new EcoreLibraryProperty(CodegencompanyPackage.Literals.COMPANY__EMPLOYEES));
		public static final @NonNull ExecutorProperty _Company__name = new ExecutorProperty("name", Types._Company, 1, new EcoreLibraryProperty(CodegencompanyPackage.Literals.COMPANY__NAME));
		public static final @NonNull ExecutorProperty _Company__size = new ExecutorProperty("size", Types._Company, 2, codegen.company.bodies.CompanyBodies._size_derivation_.INSTANCE);
	
		public static final @NonNull ExecutorProperty _Employee__allReports = new ExecutorProperty("allReports", Types._Employee, 0, codegen.company.bodies.EmployeeBodies._allReports_derivation_.INSTANCE);
		public static final @NonNull ExecutorProperty _Employee__company = new ExecutorProperty("company", Types._Employee, 1, new EcoreLibraryProperty(CodegencompanyPackage.Literals.EMPLOYEE__COMPANY));
		public static final @NonNull ExecutorProperty _Employee__directReports = new ExecutorProperty("directReports", Types._Employee, 2, codegen.company.bodies.EmployeeBodies._directReports_derivation_.INSTANCE);
		public static final @NonNull ExecutorProperty _Employee__hasNameAsAttribute = new ExecutorProperty("hasNameAsAttribute", Types._Employee, 3, codegen.company.bodies.EmployeeBodies._hasNameAsAttribute_derivation_.INSTANCE);
		public static final @NonNull ExecutorProperty _Employee__manager = new ExecutorProperty("manager", Types._Employee, 4, new EcoreLibraryProperty(CodegencompanyPackage.Literals.EMPLOYEE__MANAGER));
		public static final @NonNull ExecutorProperty _Employee__name = new ExecutorProperty("name", Types._Employee, 5, new EcoreLibraryProperty(CodegencompanyPackage.Literals.EMPLOYEE__NAME));
		public static final @NonNull ExecutorProperty _Employee__reportingChain = new ExecutorProperty("reportingChain", Types._Employee, 6, codegen.company.bodies.EmployeeBodies._reportingChain_derivation_.INSTANCE);
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		private static final @NonNull ExecutorFragment[] _Company =
		{
		    Fragments._Company__OclAny /* 0 */,
		    Fragments._Company__OclElement /* 1 */,
		    Fragments._Company__Company /* 2 */
		};
		private static final @NonNull int[] __Company = { 1,1,1 };
	
		private static final @NonNull ExecutorFragment[] _CompanySizeKind =
		{
		    Fragments._CompanySizeKind__OclAny /* 0 */,
		    Fragments._CompanySizeKind__CompanySizeKind /* 1 */
		};
		private static final @NonNull int[] __CompanySizeKind = { 1,1 };
	
		private static final @NonNull ExecutorFragment[] _Employee =
		{
		    Fragments._Employee__OclAny /* 0 */,
		    Fragments._Employee__OclElement /* 1 */,
		    Fragments._Employee__Employee /* 2 */
		};
		private static final @NonNull int[] __Employee = { 1,1,1 };
	
		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._Company.initFragments(_Company, __Company);
			Types._CompanySizeKind.initFragments(_CompanySizeKind, __CompanySizeKind);
			Types._Employee.initFragments(_Employee, __Employee);
		}
	
		public static void init() {}
	}
	

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		private static final @NonNull ExecutorOperation[] _Company__Company = {};
		private static final @NonNull ExecutorOperation[] _Company__OclAny = {
		    OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
		    OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
		    OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
		    OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
		    OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
		    OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
		    OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
		    OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Company__OclElement = {
		    OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
		    OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
		    OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
	
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__CompanySizeKind = {};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__OclAny = {
		    OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
		    OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
		    OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
		    OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
		    OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
		    OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
		    OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
		    OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
	
		private static final @NonNull ExecutorOperation[] _Employee__Employee = {
		    CodegencompanyTables.Operations._Employee__hasNameAsOperation /* hasNameAsOperation() */,
		    CodegencompanyTables.Operations._Employee__reportsTo /* reportsTo(Employee[?]) */
		};
		private static final @NonNull ExecutorOperation[] _Employee__OclAny = {
		    OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
		    OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
		    OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
		    OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
		    OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
		    OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
		    OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
		    OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Employee__OclElement = {
		    OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
		    OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
		    OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
	
		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Company__Company.initOperations(_Company__Company);
			Fragments._Company__OclAny.initOperations(_Company__OclAny);
			Fragments._Company__OclElement.initOperations(_Company__OclElement);
	
			Fragments._CompanySizeKind__CompanySizeKind.initOperations(_CompanySizeKind__CompanySizeKind);
			Fragments._CompanySizeKind__OclAny.initOperations(_CompanySizeKind__OclAny);
	
			Fragments._Employee__Employee.initOperations(_Employee__Employee);
			Fragments._Employee__OclAny.initOperations(_Employee__OclAny);
			Fragments._Employee__OclElement.initOperations(_Employee__OclElement);
		}
	
		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		private static final @NonNull ExecutorProperty[] _Company = {
		    CodegencompanyTables.Properties._Company__employees,
		    CodegencompanyTables.Properties._Company__name,
		    CodegencompanyTables.Properties._Company__size
		};
	
		private static final @NonNull ExecutorProperty[] _CompanySizeKind = {};
	
		private static final @NonNull ExecutorProperty[] _Employee = {
		    CodegencompanyTables.Properties._Employee__allReports,
		    CodegencompanyTables.Properties._Employee__company,
		    CodegencompanyTables.Properties._Employee__directReports,
		    CodegencompanyTables.Properties._Employee__hasNameAsAttribute,
		    CodegencompanyTables.Properties._Employee__manager,
		    CodegencompanyTables.Properties._Employee__name,
		    CodegencompanyTables.Properties._Employee__reportingChain
		};
	
		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
	  	 	Fragments._Company__Company.initProperties(_Company);
	  	 	Fragments._CompanySizeKind__CompanySizeKind.initProperties(_CompanySizeKind);
	  	 	Fragments._Employee__Employee.initProperties(_Employee);
		}
	
		public static void init() {}
	}
	
	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		public static final @NonNull EcoreExecutorEnumerationLiteral _CompanySizeKind__small = new EcoreExecutorEnumerationLiteral(CodegencompanyPackage.Literals.COMPANY_SIZE_KIND.getEEnumLiteral("small"), Types._CompanySizeKind, 0);
		public static final @NonNull EcoreExecutorEnumerationLiteral _CompanySizeKind__medium = new EcoreExecutorEnumerationLiteral(CodegencompanyPackage.Literals.COMPANY_SIZE_KIND.getEEnumLiteral("medium"), Types._CompanySizeKind, 1);
		public static final @NonNull EcoreExecutorEnumerationLiteral _CompanySizeKind__large = new EcoreExecutorEnumerationLiteral(CodegencompanyPackage.Literals.COMPANY_SIZE_KIND.getEEnumLiteral("large"), Types._CompanySizeKind, 2);
		
		private static final @NonNull EcoreExecutorEnumerationLiteral[] _CompanySizeKind = {
		    _CompanySizeKind__small,
		    _CompanySizeKind__medium,
		    _CompanySizeKind__large
		};
	
		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
	  	 	Types._CompanySizeKind.initLiterals(_CompanySizeKind);
		}
	
		public static void init() {}
	}
	
	static {
		Types.types[0].getClass();
	}
}

