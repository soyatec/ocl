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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * company.employees->select(manager = self)\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.lang.Object%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(self, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Object%> company = <%codegen.company.CodegencompanyTables%>.IMP_PROPid_company.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.CLSSid_Company, self);\nfinal @SuppressWarnings(\"null\")@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%><?> employees = (<%java.util.List%><?>)<%codegen.company.CodegencompanyTables%>.IMP_PROPid_employees.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, company);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> BOXED_employees = idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, employees);\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue.Accumulator%> employees_accumulator = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createOrderedSetAccumulatorValue(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.util.Iterator%><?> employees_iterator = BOXED_employees.iterator();\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> select;\nwhile (true) {\n    if (!employees_iterator.hasNext()) {\n        select = employees_accumulator;\n        break;\n    }\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%java.lang.Object%> _49__ = employees_iterator.next();\n    /**\n     * manager = self\n     \052/\n    if (_49__ == null) throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null Literal\");\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Object%> manager = <%codegen.company.CodegencompanyTables%>.IMP_PROPid_manager.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.CLSSid_Employee, _49__);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> _q = <%org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, manager, self);\n    /*\052/\n    if (_q == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n        employees_accumulator.add(_49__);\n    }\n}\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.util.List%><?> UNBOXED_select = select.asEcoreObject();\nreturn (<%org.eclipse.emf.common.util.EList<codegen.company.Employee>%>)UNBOXED_select;\n'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * Employee.allInstances()->select(reportsTo(self))\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.lang.Object%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(self, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.elements.DomainType%> TYP_company_c_c_Employee = idResolver.getType(<%codegen.company.CodegencompanyTables%>.CLSSid_Employee, null);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.SetValue%> allInstances = <%org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation%>.INSTANCE.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.SET_CLSSid_Employee, TYP_company_c_c_Employee);\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.SetValue.Accumulator%> allInstances_accumulator = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createSetAccumulatorValue(<%codegen.company.CodegencompanyTables%>.SET_CLSSid_Employee);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.util.Iterator%><?> allInstances_iterator = allInstances.iterator();\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.SetValue%> select;\nwhile (true) {\n    if (!allInstances_iterator.hasNext()) {\n        select = allInstances_accumulator;\n        break;\n    }\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%java.lang.Object%> _49__ = allInstances_iterator.next();\n    /**\n     * reportsTo(self)\n     \052/\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> reportsTo = (<%java.lang.Boolean%>)<%codegen.company.CodegencompanyTables%>.IMP_OPid_reportsTo.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, _49__, self);\n    /*\052/\n    if (reportsTo == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n        allInstances_accumulator.add(_49__);\n    }\n}\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.util.List%><?> UNBOXED_select = select.asEcoreObject();\nreturn (<%org.eclipse.emf.common.util.EList<codegen.company.Employee>%>)UNBOXED_select;\n'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * \n * if manager.oclIsUndefined()\n * then OrderedSet{}\n * else manager.reportingChain->prepend(manager)\n * endif\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.lang.Object%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(self, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> symbol_0;\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> manager;\ntry {\n    manager = <%codegen.company.CodegencompanyTables%>.IMP_PROPid_manager.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.CLSSid_Employee, self);\n}\ncatch (<%java.lang.Exception%> e) {\n    manager = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n}\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> oclIsUndefined = <%org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, manager);\nif (oclIsUndefined == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n    symbol_0 = <%codegen.company.CodegencompanyTables%>.ORD;\n}\nelse if (oclIsUndefined == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.FALSE_VALUE) {\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Object%> manager_0 = <%codegen.company.CodegencompanyTables%>.IMP_PROPid_manager.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.CLSSid_Employee, self);\n    if (manager_0 == null) throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null Literal\");\n    final @SuppressWarnings(\"null\")@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%><?> reportingChain = (<%java.util.List%><?>)<%codegen.company.CodegencompanyTables%>.IMP_PROPid_reportingChain.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, manager_0);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> BOXED_reportingChain = idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, reportingChain);\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Object%> manager_1 = <%codegen.company.CodegencompanyTables%>.IMP_PROPid_manager.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.CLSSid_Employee, self);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> prepend = (<%org.eclipse.ocl.examples.domain.values.OrderedSetValue%>)<%org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation%>.INSTANCE.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, BOXED_reportingChain, manager_1);\n    symbol_0 = prepend;\n}\nelse {\n    throw <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.INVALID_VALUE;\n}\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.util.List%><?> UNBOXED_symbol_0 = symbol_0.asEcoreObject();\nreturn (<%org.eclipse.emf.common.util.EList<codegen.company.Employee>%>)UNBOXED_symbol_0;\n'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * name <> null\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.lang.Object%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(self, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name = (<%java.lang.String%>)<%codegen.company.CodegencompanyTables%>.IMP_PROPid_name.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.STRING, self);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> _l_g = <%org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, name, null);\nreturn (<%java.lang.Boolean%>)_l_g;\n'"
	 * @generated
	 */
	boolean isHasNameAsAttribute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * self.reportingChain->includes(manager)\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.lang.Object%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(self, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\nif (self == null) throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null Literal\");\nfinal @SuppressWarnings(\"null\")@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%><?> reportingChain = (<%java.util.List%><?>)<%codegen.company.CodegencompanyTables%>.IMP_PROPid_reportingChain.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, self);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> BOXED_reportingChain = idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, reportingChain);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> includes = <%org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, BOXED_reportingChain, manager);\nreturn (<%boolean%>)includes;'"
	 * @generated
	 */
	boolean reportsTo(Employee manager);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * manager.oclIsUndefined() implies directReports->size() > 0\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.lang.Object%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(self, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> oclIsUndefined;\ntry {\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> manager;\n    try {\n    if (self == null) throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null Literal\");\n        manager = <%codegen.company.CodegencompanyTables%>.IMP_PROPid_manager.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.CLSSid_Employee, self);\n    }\n    catch (<%java.lang.Exception%> e) {\n        manager = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n    }\n    oclIsUndefined = <%org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, manager);\n} catch (<%java.lang.Exception%> e_0) { oclIsUndefined = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e_0); }\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> _g;\ntry {\n    final @SuppressWarnings(\"null\")@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%><?> directReports = (<%java.util.List%><?>)<%codegen.company.CodegencompanyTables%>.IMP_PROPid_directReports.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, self);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> BOXED_directReports = idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, directReports);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.IntegerValue%> size = <%org.eclipse.ocl.examples.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.INTEGER, BOXED_directReports);\n    _g = <%org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, size, <%codegen.company.CodegencompanyTables%>.INT_0);\n} catch (<%java.lang.Exception%> e_1) { _g = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e_1); }\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> implies = <%org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, oclIsUndefined, _g);\nif (implies == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n    return true;\n}\nif (diagnostics != null) {\n    int severity = implies == null ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n    String message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"Employee\", \"noManagerImpliesDirectReports\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%codegen.company.util.CodegencompanyValidator%>.DIAGNOSTIC_SOURCE, <%codegen.company.util.CodegencompanyValidator%>.EMPLOYEE__NO_MANAGER_IMPLIES_DIRECT_REPORTS, message, new Object [] { this }));\n}\nreturn false;'"
	 * @generated
	 */
	boolean noManagerImpliesDirectReports(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * name <> null\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.lang.Object%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(self, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nif (self == null) throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null Literal\");\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name = (<%java.lang.String%>)<%codegen.company.CodegencompanyTables%>.IMP_PROPid_name.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.STRING, self);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> _l_g = <%org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, name, null);\nreturn (<%boolean%>)_l_g;'"
	 * @generated
	 */
	boolean hasNameAsOperation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * not name.oclIsUndefined() and hasNameAsAttribute and hasNameAsOperation()\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.lang.Object%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(self, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> and_0;\ntry {\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> not;\n    try {\n        @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> name;\n        try {\n        if (self == null) throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null Literal\");\n            name = <%codegen.company.CodegencompanyTables%>.IMP_PROPid_name.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.STRING, self);\n        }\n        catch (<%java.lang.Exception%> e) {\n            name = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n        }\n        final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> oclIsUndefined = <%org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, name);\n        not = <%org.eclipse.ocl.examples.library.logical.BooleanNotOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, oclIsUndefined);\n    } catch (<%java.lang.Exception%> e_0) { not = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e_0); }\n    @<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> hasNameAsAttribute;\n    try {\n        hasNameAsAttribute = <%codegen.company.CodegencompanyTables%>.IMP_PROPid_hasNameAsAttribute.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, self);\n    }\n    catch (<%java.lang.Exception%> e_1) {\n        hasNameAsAttribute = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e_1);\n    }\n    and_0 = <%org.eclipse.ocl.examples.library.logical.BooleanAndOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, not, hasNameAsAttribute);\n} catch (<%java.lang.Exception%> e_2) { and_0 = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e_2); }\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Caught\052/ <%java.lang.Object%> hasNameAsOperation;\ntry {\n    hasNameAsOperation = <%codegen.company.CodegencompanyTables%>.IMP_OPid_hasNameAsOperation.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, self);\n}\ncatch (<%java.lang.Exception%> e_3) {\n    hasNameAsOperation = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e_3);\n}\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> and = <%org.eclipse.ocl.examples.library.logical.BooleanAndOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, and_0, hasNameAsOperation);\nif (and == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n    return true;\n}\nif (diagnostics != null) {\n    int severity = and == null ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n    String message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"Employee\", \"mustHaveName\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%codegen.company.util.CodegencompanyValidator%>.DIAGNOSTIC_SOURCE, <%codegen.company.util.CodegencompanyValidator%>.EMPLOYEE__MUST_HAVE_NAME, message, new Object [] { this }));\n}\nreturn false;'"
	 * @generated
	 */
	boolean mustHaveName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * name->notEmpty() implies name.size() > 0\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.lang.Object%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(self, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> notEmpty;\ntry {\n    if (self == null) throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null Literal\");\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name = (<%java.lang.String%>)<%codegen.company.CodegencompanyTables%>.IMP_PROPid_name.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.STRING, self);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.SetValue%> oclAsSet = <%org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.SET_PRIMid_String, name);\n    notEmpty = <%org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, oclAsSet);\n} catch (<%java.lang.Exception%> e) { notEmpty = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e); }\n@<%org.eclipse.jdt.annotation.NonNull%> /*@Caught\052/ <%java.lang.Object%> _g;\ntry {\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.String%> name_0 = (<%java.lang.String%>)<%codegen.company.CodegencompanyTables%>.IMP_PROPid_name.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.STRING, self);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.IntegerValue%> size = <%org.eclipse.ocl.examples.library.string.StringSizeOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.INTEGER, name_0);\n    _g = <%org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, size, <%codegen.company.CodegencompanyTables%>.INT_0);\n} catch (<%java.lang.Exception%> e_0) { _g = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e_0); }\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%java.lang.Boolean%> implies = <%org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, notEmpty, _g);\nif (implies == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n    return true;\n}\nif (diagnostics != null) {\n    int severity = implies == null ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n    String message = <%org.eclipse.osgi.util.NLS%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"Employee\", \"mustHaveNonEmptyName\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%codegen.company.util.CodegencompanyValidator%>.DIAGNOSTIC_SOURCE, <%codegen.company.util.CodegencompanyValidator%>.EMPLOYEE__MUST_HAVE_NON_EMPTY_NAME, message, new Object [] { this }));\n}\nreturn false;'"
	 * @generated
	 */
	boolean mustHaveNonEmptyName(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Employee
