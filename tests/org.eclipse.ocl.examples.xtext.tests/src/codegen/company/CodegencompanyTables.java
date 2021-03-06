/**
 *************************************************************************
 * This code is 100% auto-generated
 * from: company
 * using: org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 */
package codegen.company;

import codegen.company.CodegencompanyPackage;
import codegen.company.CodegencompanyTables;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumeration;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumerationLiteral;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.examples.library.executor.ExecutorFragment;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotTables;

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
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_test_s_Pivot_s_Company_ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/ocl/test/Pivot/Company.ecore", "co", CodegencompanyPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Company = CodegencompanyTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_test_s_Pivot_s_Company_ecore.getClassId("Company", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Employee = CodegencompanyTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_test_s_Pivot_s_Company_ecore.getClassId("Employee", 0);
    public static final @NonNull /*@NonInvalid*/ EnumerationId ENUMid_CompanySizeKind = CodegencompanyTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_test_s_Pivot_s_Company_ecore.getEnumerationId("CompanySizeKind");
    public static final @NonNull /*@NonInvalid*/ IntegerValue INT_0 = ValuesUtil.integerValueOf("0");
    public static final @NonNull /*@NonInvalid*/ IntegerValue INT_1000 = ValuesUtil.integerValueOf("1000");
    public static final @NonNull /*@NonInvalid*/ IntegerValue INT_1000000 = ValuesUtil.integerValueOf("1000000");
    public static final @NonNull /*@NonInvalid*/ IntegerValue INT_49 = ValuesUtil.integerValueOf("49");
    public static final @NonNull /*@NonInvalid*/ IntegerValue INT_50 = ValuesUtil.integerValueOf("50");
    public static final @NonNull /*@NonInvalid*/ IntegerValue INT_999 = ValuesUtil.integerValueOf("999");
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_PRIMid_Integer = TypeId.SEQUENCE.getSpecializedId(TypeId.INTEGER);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_PRIMid_UnlimitedNatural = TypeId.SEQUENCE.getSpecializedId(TypeId.UNLIMITED_NATURAL);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_PRIMid_String = TypeId.SET.getSpecializedId(TypeId.STRING);
    public static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_large = CodegencompanyTables.ENUMid_CompanySizeKind.getEnumerationLiteralId("large");
    public static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_medium = CodegencompanyTables.ENUMid_CompanySizeKind.getEnumerationLiteralId("medium");
    public static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_small = CodegencompanyTables.ENUMid_CompanySizeKind.getEnumerationLiteralId("small");
    public static final @NonNull /*@NonInvalid*/ MetaclassId METAid_Metaclass = TypeId.METACLASS.getSpecializedId(CodegencompanyTables.CLSSid_Employee);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Employee = TypeId.ORDERED_SET.getSpecializedId(CodegencompanyTables.CLSSid_Employee);
    public static final @NonNull /*@NonInvalid*/ TuplePartId PARTid_ = IdManager.getTuplePartId(0, "range", CodegencompanyTables.SEQ_PRIMid_UnlimitedNatural);
    public static final @NonNull /*@NonInvalid*/ TuplePartId PARTid__0 = IdManager.getTuplePartId(1, "size", CodegencompanyTables.ENUMid_CompanySizeKind);
    public static final @NonNull /*@NonInvalid*/ TuplePartId PARTid__1 = IdManager.getTuplePartId(0, "range", CodegencompanyTables.SEQ_PRIMid_Integer);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Employee = TypeId.SET.getSpecializedId(CodegencompanyTables.CLSSid_Employee);
    public static final @NonNull /*@NonInvalid*/ IntegerRange symbol_0 = ValuesUtil.createRange(CodegencompanyTables.INT_0, CodegencompanyTables.INT_49);
    public static final @NonNull /*@NonInvalid*/ IntegerRange symbol_4 = ValuesUtil.createRange(CodegencompanyTables.INT_1000, CodegencompanyTables.INT_1000000);
    public static final @NonNull /*@NonInvalid*/ IntegerRange symbol_2 = ValuesUtil.createRange(CodegencompanyTables.INT_50, CodegencompanyTables.INT_999);
    public static final @NonNull /*@NonInvalid*/ OrderedSetValue OrderedSet = ValuesUtil.createOrderedSetOfEach(CodegencompanyTables.ORD_CLSSid_Employee);
    public static final @NonNull /*@NonInvalid*/ SequenceValue Sequence = ValuesUtil.createSequenceRange(CodegencompanyTables.SEQ_PRIMid_UnlimitedNatural, CodegencompanyTables.symbol_0);
    public static final @NonNull /*@NonInvalid*/ SequenceValue Sequence_1 = ValuesUtil.createSequenceRange(CodegencompanyTables.SEQ_PRIMid_UnlimitedNatural, CodegencompanyTables.symbol_4);
    public static final @NonNull /*@NonInvalid*/ SequenceValue Sequence_0 = ValuesUtil.createSequenceRange(CodegencompanyTables.SEQ_PRIMid_UnlimitedNatural, CodegencompanyTables.symbol_2);
    public static final @NonNull /*@NonInvalid*/ TupleTypeId TUPLid_ = IdManager.getTupleTypeId("Tuple", CodegencompanyTables.PARTid_, CodegencompanyTables.PARTid__0);
    public static final @NonNull /*@NonInvalid*/ TupleTypeId TUPLid__0 = IdManager.getTupleTypeId("Tuple", CodegencompanyTables.PARTid__1, CodegencompanyTables.PARTid__0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_TUPLid_ = TypeId.SET.getSpecializedId(CodegencompanyTables.TUPLid_);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_TUPLid__0 = TypeId.SET.getSpecializedId(CodegencompanyTables.TUPLid__0);
    public static final @NonNull /*@NonInvalid*/ TupleValue symbol_1 = ValuesUtil.createTupleOfEach(CodegencompanyTables.TUPLid_, CodegencompanyTables.Sequence, CodegencompanyTables.ELITid_small);
    public static final @NonNull /*@NonInvalid*/ TupleValue symbol_5 = ValuesUtil.createTupleOfEach(CodegencompanyTables.TUPLid_, CodegencompanyTables.Sequence_1, CodegencompanyTables.ELITid_large);
    public static final @NonNull /*@NonInvalid*/ TupleValue symbol_3 = ValuesUtil.createTupleOfEach(CodegencompanyTables.TUPLid_, CodegencompanyTables.Sequence_0, CodegencompanyTables.ELITid_medium);
    public static final @NonNull /*@NonInvalid*/ SetValue table = ValuesUtil.createSetOfEach(CodegencompanyTables.SET_TUPLid_, CodegencompanyTables.symbol_1, CodegencompanyTables.symbol_3, CodegencompanyTables.symbol_5);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {	}

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

		public static void init() {}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		private static final @NonNull ExecutorFragment _Company__Company = new ExecutorFragment(Types._Company, CodegencompanyTables.Types._Company);
		private static final @NonNull ExecutorFragment _Company__OclAny = new ExecutorFragment(Types._Company, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Company__OclElement = new ExecutorFragment(Types._Company, OCLstdlibTables.Types._OclElement);

		private static final @NonNull ExecutorFragment _CompanySizeKind__Class = new ExecutorFragment(Types._CompanySizeKind, PivotTables.Types._Class);
		private static final @NonNull ExecutorFragment _CompanySizeKind__CompanySizeKind = new ExecutorFragment(Types._CompanySizeKind, CodegencompanyTables.Types._CompanySizeKind);
		private static final @NonNull ExecutorFragment _CompanySizeKind__DataType = new ExecutorFragment(Types._CompanySizeKind, PivotTables.Types._DataType);
		private static final @NonNull ExecutorFragment _CompanySizeKind__Element = new ExecutorFragment(Types._CompanySizeKind, PivotTables.Types._Element);
		private static final @NonNull ExecutorFragment _CompanySizeKind__Enumeration = new ExecutorFragment(Types._CompanySizeKind, PivotTables.Types._Enumeration);
		private static final @NonNull ExecutorFragment _CompanySizeKind__Nameable = new ExecutorFragment(Types._CompanySizeKind, PivotTables.Types._Nameable);
		private static final @NonNull ExecutorFragment _CompanySizeKind__NamedElement = new ExecutorFragment(Types._CompanySizeKind, PivotTables.Types._NamedElement);
		private static final @NonNull ExecutorFragment _CompanySizeKind__Namespace = new ExecutorFragment(Types._CompanySizeKind, PivotTables.Types._Namespace);
		private static final @NonNull ExecutorFragment _CompanySizeKind__OclAny = new ExecutorFragment(Types._CompanySizeKind, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _CompanySizeKind__OclElement = new ExecutorFragment(Types._CompanySizeKind, OCLstdlibTables.Types._OclElement);
		private static final @NonNull ExecutorFragment _CompanySizeKind__OclType = new ExecutorFragment(Types._CompanySizeKind, OCLstdlibTables.Types._OclType);
		private static final @NonNull ExecutorFragment _CompanySizeKind__ParameterableElement = new ExecutorFragment(Types._CompanySizeKind, PivotTables.Types._ParameterableElement);
		private static final @NonNull ExecutorFragment _CompanySizeKind__TemplateableElement = new ExecutorFragment(Types._CompanySizeKind, PivotTables.Types._TemplateableElement);
		private static final @NonNull ExecutorFragment _CompanySizeKind__Type = new ExecutorFragment(Types._CompanySizeKind, PivotTables.Types._Type);
		private static final @NonNull ExecutorFragment _CompanySizeKind__Visitable = new ExecutorFragment(Types._CompanySizeKind, PivotTables.Types._Visitable);

		private static final @NonNull ExecutorFragment _Employee__Employee = new ExecutorFragment(Types._Employee, CodegencompanyTables.Types._Employee);
		private static final @NonNull ExecutorFragment _Employee__OclAny = new ExecutorFragment(Types._Employee, OCLstdlibTables.Types._OclAny);
		private static final @NonNull ExecutorFragment _Employee__OclElement = new ExecutorFragment(Types._Employee, OCLstdlibTables.Types._OclElement);

		/*
		 * Force initialization.
		 */
		public static void init() {
			Types.init();
		}
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
			0, DomainTypeParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _Employee__reportsTo = new ExecutorOperation("reportsTo", Parameters._Employee, Types._Employee,
			1, DomainTypeParameters.EMPTY_LIST, null);

	}

	/**
	 *	The property descriptors for each property of each type.
	 */
	public static class Properties {

		public static final @NonNull ExecutorProperty _Company__employees = new EcoreExecutorProperty(CodegencompanyPackage.Literals.COMPANY__EMPLOYEES, Types._Company, 0);
		public static final @NonNull ExecutorProperty _Company__name = new EcoreExecutorProperty(CodegencompanyPackage.Literals.COMPANY__NAME, Types._Company, 1);
		public static final @NonNull ExecutorProperty _Company__size = new EcoreExecutorProperty(CodegencompanyPackage.Literals.COMPANY__SIZE, Types._Company, 2);

		public static final @NonNull ExecutorProperty _Employee__allReports = new EcoreExecutorProperty(CodegencompanyPackage.Literals.EMPLOYEE__ALL_REPORTS, Types._Employee, 0);
		public static final @NonNull ExecutorProperty _Employee__company = new EcoreExecutorProperty(CodegencompanyPackage.Literals.EMPLOYEE__COMPANY, Types._Employee, 1);
		public static final @NonNull ExecutorProperty _Employee__directReports = new EcoreExecutorProperty(CodegencompanyPackage.Literals.EMPLOYEE__DIRECT_REPORTS, Types._Employee, 2);
		public static final @NonNull ExecutorProperty _Employee__hasNameAsAttribute = new EcoreExecutorProperty(CodegencompanyPackage.Literals.EMPLOYEE__HAS_NAME_AS_ATTRIBUTE, Types._Employee, 3);
		public static final @NonNull ExecutorProperty _Employee__manager = new EcoreExecutorProperty(CodegencompanyPackage.Literals.EMPLOYEE__MANAGER, Types._Employee, 4);
		public static final @NonNull ExecutorProperty _Employee__name = new EcoreExecutorProperty(CodegencompanyPackage.Literals.EMPLOYEE__NAME, Types._Employee, 5);
		public static final @NonNull ExecutorProperty _Employee__reportingChain = new EcoreExecutorProperty(CodegencompanyPackage.Literals.EMPLOYEE__REPORTING_CHAIN, Types._Employee, 6);

		/*
		 * Force initialization.
		 */
		public static void init() {
			Types.init();
		}
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
			Fragments._CompanySizeKind__OclElement /* 1 */,
			Fragments._CompanySizeKind__Nameable /* 2 */,
			Fragments._CompanySizeKind__OclType /* 2 */,
			Fragments._CompanySizeKind__Visitable /* 2 */,
			Fragments._CompanySizeKind__Element /* 3 */,
			Fragments._CompanySizeKind__NamedElement /* 4 */,
			Fragments._CompanySizeKind__ParameterableElement /* 4 */,
			Fragments._CompanySizeKind__TemplateableElement /* 4 */,
			Fragments._CompanySizeKind__Namespace /* 5 */,
			Fragments._CompanySizeKind__Type /* 5 */,
			Fragments._CompanySizeKind__Class /* 6 */,
			Fragments._CompanySizeKind__DataType /* 7 */,
			Fragments._CompanySizeKind__Enumeration /* 8 */,
			Fragments._CompanySizeKind__CompanySizeKind /* 9 */
		};
		private static final @NonNull int[] __CompanySizeKind = { 1,1,3,1,3,2,1,1,1,1 };

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
		public static void init() {
			Fragments.init();
			Properties.init();

			Types._Company.initFragments(_Company, __Company);
			Types._CompanySizeKind.initFragments(_CompanySizeKind, __CompanySizeKind);
			Types._Employee.initFragments(_Employee, __Employee);
		}
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
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Company__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final @NonNull ExecutorOperation[] _CompanySizeKind__CompanySizeKind = {};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__Class = {};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__DataType = {};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__Enumeration = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */
		};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__Nameable = {};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__Namespace = {};
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
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__OclElement = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _CompanySizeKind__Visitable = {};

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
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
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
		public static void init() {
			TypeFragments.init();

			Fragments._Company__Company.initOperations(_Company__Company);
			Fragments._Company__OclAny.initOperations(_Company__OclAny);
			Fragments._Company__OclElement.initOperations(_Company__OclElement);

			Fragments._CompanySizeKind__Class.initOperations(_CompanySizeKind__Class);
			Fragments._CompanySizeKind__CompanySizeKind.initOperations(_CompanySizeKind__CompanySizeKind);
			Fragments._CompanySizeKind__DataType.initOperations(_CompanySizeKind__DataType);
			Fragments._CompanySizeKind__Element.initOperations(_CompanySizeKind__Element);
			Fragments._CompanySizeKind__Enumeration.initOperations(_CompanySizeKind__Enumeration);
			Fragments._CompanySizeKind__Nameable.initOperations(_CompanySizeKind__Nameable);
			Fragments._CompanySizeKind__NamedElement.initOperations(_CompanySizeKind__NamedElement);
			Fragments._CompanySizeKind__Namespace.initOperations(_CompanySizeKind__Namespace);
			Fragments._CompanySizeKind__OclAny.initOperations(_CompanySizeKind__OclAny);
			Fragments._CompanySizeKind__OclElement.initOperations(_CompanySizeKind__OclElement);
			Fragments._CompanySizeKind__OclType.initOperations(_CompanySizeKind__OclType);
			Fragments._CompanySizeKind__ParameterableElement.initOperations(_CompanySizeKind__ParameterableElement);
			Fragments._CompanySizeKind__TemplateableElement.initOperations(_CompanySizeKind__TemplateableElement);
			Fragments._CompanySizeKind__Type.initOperations(_CompanySizeKind__Type);
			Fragments._CompanySizeKind__Visitable.initOperations(_CompanySizeKind__Visitable);

			Fragments._Employee__Employee.initOperations(_Employee__Employee);
			Fragments._Employee__OclAny.initOperations(_Employee__OclAny);
			Fragments._Employee__OclElement.initOperations(_Employee__OclElement);
		}
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
		public static void init() {
			TypeFragments.init();

			Fragments._Company__Company.initProperties(_Company);
			Fragments._CompanySizeKind__CompanySizeKind.initProperties(_CompanySizeKind);
			Fragments._Employee__Employee.initProperties(_Employee);
		}
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

	/*
	 * Force initialization.
	 */
	static {
		Types.init();
	}
}
