/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package codegen.company;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link codegen.company.Employee#getName <em>Name</em>}</li>
 *   <li>{@link codegen.company.Employee#getManager <em>Manager</em>}</li>
 *   <li>{@link codegen.company.Employee#getCompany <em>Company</em>}</li>
 *   <li>{@link codegen.company.Employee#getDirectReports <em>Direct Reports</em>}</li>
 *   <li>{@link codegen.company.Employee#getAllReports <em>All Reports</em>}</li>
 *   <li>{@link codegen.company.Employee#getReportingChain <em>Reporting Chain</em>}</li>
 *   <li>{@link codegen.company.Employee#isHasNameAsAttribute <em>Has Name As Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see codegen.company.CodegencompanyPackage#getEmployee()
 * @model
 * @generated
 */
public interface Employee extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see codegen.company.CodegencompanyPackage#getEmployee_Name()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/test/Pivot/Company.ecore!Employee!name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link codegen.company.Employee#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manager</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager</em>' reference.
	 * @see #setManager(Employee)
	 * @see codegen.company.CodegencompanyPackage#getEmployee_Manager()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/test/Pivot/Company.ecore!Employee!manager'"
	 * @generated
	 */
	Employee getManager();

	/**
	 * Sets the value of the '{@link codegen.company.Employee#getManager <em>Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager</em>' reference.
	 * @see #getManager()
	 * @generated
	 */
	void setManager(Employee value);

	/**
	 * Returns the value of the '<em><b>Company</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link codegen.company.Company#getEmployees <em>Employees</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Company</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Company</em>' container reference.
	 * @see #setCompany(Company)
	 * @see codegen.company.CodegencompanyPackage#getEmployee_Company()
	 * @see codegen.company.Company#getEmployees
	 * @model opposite="employees" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/test/Pivot/Company.ecore!Employee!company'"
	 * @generated
	 */
	Company getCompany();

	/**
	 * Sets the value of the '{@link codegen.company.Employee#getCompany <em>Company</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Company</em>' container reference.
	 * @see #getCompany()
	 * @generated
	 */
	void setCompany(Company value);

	/**
	 * Returns the value of the '<em><b>Direct Reports</b></em>' reference list.
	 * The list contents are of type {@link codegen.company.Employee}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direct Reports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direct Reports</em>' reference list.
	 * @see codegen.company.CodegencompanyPackage#getEmployee_DirectReports()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * company.employees->select(manager = self)\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%codegen.company.Employee%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%codegen.company.CodegencompanyTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%codegen.company.Company%> company = self.getCompany();\nif (company == null) {\n    throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null source\");\n}\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.util.List%> employees = company.getEmployees();\nif (employees == null) {\n    throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null source\");\n}\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> BOXED_employees = idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, employees);\n@<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%>.Accumulator accumulator = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createOrderedSetAccumulatorValue(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee);\n@<%org.eclipse.jdt.annotation.Nullable%> <%java.util.Iterator%> ITERATOR__1 = BOXED_employees.iterator();\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> select;\nwhile (true) {\n    if (!ITERATOR__1.hasNext()) {\n        select = accumulator;\n        break;\n    }\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%codegen.company.Employee%> _1 = (<%codegen.company.Employee%>)ITERATOR__1.next();\n    /**\n     * manager = self\n     \052/\n    if (_1 == null) {\n        throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null source\");\n    }\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%codegen.company.Employee%> manager_0 = _1.getManager();\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> eq = <%org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation%>.INSTANCE.evaluate(manager_0, self);\n    //\n    if (eq == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n        accumulator.add(_1);\n    }\n}\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%> UNBOXED_select = select.asEcoreObject();\nreturn (<%org.eclipse.emf.common.util.EList<codegen.company.Employee>%>)UNBOXED_select;'"
	 * @generated
	 */
	EList<Employee> getDirectReports();

	/**
	 * Returns the value of the '<em><b>All Reports</b></em>' reference list.
	 * The list contents are of type {@link codegen.company.Employee}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Reports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Reports</em>' reference list.
	 * @see codegen.company.CodegencompanyPackage#getEmployee_AllReports()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * Employee.allInstances()->select(reportsTo(self))\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%codegen.company.Employee%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%codegen.company.CodegencompanyTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.elements.DomainType%> TYP_company_c_c_Employee = idResolver.getType(<%codegen.company.CodegencompanyTables%>.CLSSid_Employee, null);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.SetValue%> allInstances = <%org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation%>.INSTANCE.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.SET_CLSSid_Employee, TYP_company_c_c_Employee);\n@<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.values.SetValue%>.Accumulator accumulator = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createSetAccumulatorValue(<%codegen.company.CodegencompanyTables%>.SET_CLSSid_Employee);\n@<%org.eclipse.jdt.annotation.Nullable%> <%java.util.Iterator%> ITERATOR__1 = allInstances.iterator();\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.SetValue%> select;\nwhile (true) {\n    if (!ITERATOR__1.hasNext()) {\n        select = accumulator;\n        break;\n    }\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%codegen.company.Employee%> _1 = (<%codegen.company.Employee%>)ITERATOR__1.next();\n    /**\n     * reportsTo(self)\n     \052/\n    if (_1 == null) {\n        throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null source\");\n    }\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> reportsTo = _1.reportsTo(self);\n    //\n    if (reportsTo == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n        accumulator.add(_1);\n    }\n}\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%> UNBOXED_select = select.asEcoreObject();\nreturn (<%org.eclipse.emf.common.util.EList<codegen.company.Employee>%>)UNBOXED_select;'"
	 * @generated
	 */
	EList<Employee> getAllReports();

	/**
	 * Returns the value of the '<em><b>Reporting Chain</b></em>' reference list.
	 * The list contents are of type {@link codegen.company.Employee}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reporting Chain</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reporting Chain</em>' reference list.
	 * @see codegen.company.CodegencompanyPackage#getEmployee_ReportingChain()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * \n * if manager.oclIsUndefined()\n * then OrderedSet{}\n * else manager.reportingChain->prepend(manager)\n * endif\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%codegen.company.Employee%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%codegen.company.CodegencompanyTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_manager_0;\ntry {\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%codegen.company.Employee%> manager_0 = ((<%codegen.company.Employee%>)self).getManager();\n    CAUGHT_manager_0 = manager_0;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_manager_0 = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n}\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> symbol_0 = (CAUGHT_manager_0 == null) || (CAUGHT_manager_0 instanceof <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>);\nif (symbol_0 == null) {\n    throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null source\");\n}\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> symbol_1;\nif (symbol_0) {\n    symbol_1 = <%codegen.company.CodegencompanyTables%>.OrderedSet;\n}\nelse {\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%codegen.company.Employee%> manager_1 = ((<%codegen.company.Employee%>)self).getManager();\n    if (manager_1 == null) {\n        throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null source\");\n    }\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.util.List%> reportingChain = manager_1.getReportingChain();\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> BOXED_reportingChain = reportingChain == null ? null : idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, reportingChain);\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%codegen.company.Employee%> manager_2 = ((<%codegen.company.Employee%>)self).getManager();\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> prepend = (<%org.eclipse.ocl.examples.domain.values.OrderedSetValue%>)<%org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation%>.INSTANCE.evaluate(BOXED_reportingChain, manager_2);\n    symbol_1 = prepend;\n}\nif (symbol_1 == null) {\n    throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null source\");\n}\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%> UNBOXED_symbol_1 = symbol_1.asEcoreObject();\nreturn (<%org.eclipse.emf.common.util.EList<codegen.company.Employee>%>)UNBOXED_symbol_1;'"
	 * @generated
	 */
	EList<Employee> getReportingChain();

	/**
	 * Returns the value of the '<em><b>Has Name As Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Name As Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Name As Attribute</em>' attribute.
	 * @see codegen.company.CodegencompanyPackage#getEmployee_HasNameAsAttribute()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * name <> null\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%codegen.company.Employee%> self = this;\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name = self.getName();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> ne = <%org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation%>.INSTANCE.evaluate(name, null);\nreturn ne;'"
	 * @generated
	 */
	boolean isHasNameAsAttribute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * self.reportingChain->includes(manager)\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%codegen.company.Employee%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%codegen.company.CodegencompanyTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.util.List%> reportingChain = self.getReportingChain();\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> BOXED_reportingChain = reportingChain == null ? null : idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, reportingChain);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> includes = <%org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation%>.INSTANCE.evaluate(BOXED_reportingChain, manager);\nreturn includes.booleanValue();'"
	 * @generated
	 */
	boolean reportsTo(Employee manager);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv noManagerImpliesDirectReports: manager.oclIsUndefined() implies directReports->size() > 0\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%codegen.company.Employee%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%codegen.company.CodegencompanyTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_implies;\ntry {\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_symbol_0;\n    try {\n        @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_manager_0;\n        try {\n            final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%codegen.company.Employee%> manager_0 = ((<%codegen.company.Employee%>)self).getManager();\n            CAUGHT_manager_0 = manager_0;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_manager_0 = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n        }\n        final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> symbol_0 = (CAUGHT_manager_0 == null) || (CAUGHT_manager_0 instanceof <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>);\n        CAUGHT_symbol_0 = symbol_0;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_symbol_0 = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    @<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_gt;\n    try {\n        final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.util.List%> directReports = ((<%codegen.company.Employee%>)self).getDirectReports();\n        final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> BOXED_directReports = directReports == null ? null : idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, directReports);\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.IntegerValue%> size = <%org.eclipse.ocl.examples.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(BOXED_directReports);\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> gt = <%org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation%>.INSTANCE.evaluate(size, <%codegen.company.CodegencompanyTables%>.INT_0);\n        CAUGHT_gt = gt;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_gt = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> implies = <%org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation%>.INSTANCE.evaluate(CAUGHT_symbol_0, CAUGHT_gt);\n    CAUGHT_implies = implies;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_implies = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_implies == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n    return true;\n}\nif (diagnostics != null) {\n    int severity = CAUGHT_implies == null ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n    <%java.lang.String%> message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"Employee\", \"noManagerImpliesDirectReports\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%codegen.company.util.CodegencompanyValidator%>.DIAGNOSTIC_SOURCE, <%codegen.company.util.CodegencompanyValidator%>.EMPLOYEE__NO_MANAGER_IMPLIES_DIRECT_REPORTS, message, new Object [] { this }));\n}\nreturn false;'"
	 * @generated
	 */
	boolean noManagerImpliesDirectReports(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * name <> null\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%codegen.company.Employee%> self = this;\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name = self.getName();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> ne = <%org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation%>.INSTANCE.evaluate(name, null);\nreturn ne.booleanValue();'"
	 * @generated
	 */
	boolean hasNameAsOperation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv mustHaveName: not name.oclIsUndefined() and hasNameAsAttribute and hasNameAsOperation()\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%codegen.company.Employee%> self = this;\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_and_0;\ntry {\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_and;\n    try {\n        @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_not;\n        try {\n            @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_name;\n            try {\n                final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name = ((<%codegen.company.Employee%>)self).getName();\n                CAUGHT_name = name;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_name = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n            }\n            final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> symbol_0 = (CAUGHT_name == null) || (CAUGHT_name instanceof <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>);\n            final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> not = <%org.eclipse.ocl.examples.library.logical.BooleanNotOperation%>.INSTANCE.evaluate(symbol_0);\n            CAUGHT_not = not;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_not = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n        }\n        @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_hasNameAsAttribute;\n        try {\n            final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> hasNameAsAttribute = ((<%codegen.company.Employee%>)self).isHasNameAsAttribute();\n            CAUGHT_hasNameAsAttribute = hasNameAsAttribute;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_hasNameAsAttribute = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n        }\n        final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> and = <%org.eclipse.ocl.examples.library.logical.BooleanAndOperation%>.INSTANCE.evaluate(CAUGHT_not, CAUGHT_hasNameAsAttribute);\n        CAUGHT_and = and;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_and = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    @<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_hasNameAsOperation;\n    try {\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> hasNameAsOperation = ((<%codegen.company.Employee%>)self).hasNameAsOperation();\n        CAUGHT_hasNameAsOperation = hasNameAsOperation;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_hasNameAsOperation = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> and_0 = <%org.eclipse.ocl.examples.library.logical.BooleanAndOperation%>.INSTANCE.evaluate(CAUGHT_and, CAUGHT_hasNameAsOperation);\n    CAUGHT_and_0 = and_0;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_and_0 = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_and_0 == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n    return true;\n}\nif (diagnostics != null) {\n    int severity = CAUGHT_and_0 == null ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n    <%java.lang.String%> message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"Employee\", \"mustHaveName\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%codegen.company.util.CodegencompanyValidator%>.DIAGNOSTIC_SOURCE, <%codegen.company.util.CodegencompanyValidator%>.EMPLOYEE__MUST_HAVE_NAME, message, new Object [] { this }));\n}\nreturn false;'"
	 * @generated
	 */
	boolean mustHaveName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * inv mustHaveNonEmptyName: name->notEmpty() implies name.size() > 0\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%codegen.company.Employee%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(this, <%codegen.company.CodegencompanyTables%>.LIBRARY);\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_implies;\ntry {\n    @<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_notEmpty;\n    try {\n        final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name = ((<%codegen.company.Employee%>)self).getName();\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.SetValue%> oclAsSet = <%org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.SET_PRIMid_String, name);\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> notEmpty = <%org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation%>.INSTANCE.evaluate(oclAsSet);\n        CAUGHT_notEmpty = notEmpty;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_notEmpty = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    @<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> CAUGHT_gt;\n    try {\n        final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name_0 = ((<%codegen.company.Employee%>)self).getName();\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.IntegerValue%> size = <%org.eclipse.ocl.examples.library.string.StringSizeOperation%>.INSTANCE.evaluate(name_0);\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> gt = <%org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation%>.INSTANCE.evaluate(size, <%codegen.company.CodegencompanyTables%>.INT_0);\n        CAUGHT_gt = gt;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_gt = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> implies = <%org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation%>.INSTANCE.evaluate(CAUGHT_notEmpty, CAUGHT_gt);\n    CAUGHT_implies = implies;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_implies = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_implies == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n    return true;\n}\nif (diagnostics != null) {\n    int severity = CAUGHT_implies == null ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n    <%java.lang.String%> message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"Employee\", \"mustHaveNonEmptyName\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%codegen.company.util.CodegencompanyValidator%>.DIAGNOSTIC_SOURCE, <%codegen.company.util.CodegencompanyValidator%>.EMPLOYEE__MUST_HAVE_NON_EMPTY_NAME, message, new Object [] { this }));\n}\nreturn false;'"
	 * @generated
	 */
	boolean mustHaveNonEmptyName(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Employee
