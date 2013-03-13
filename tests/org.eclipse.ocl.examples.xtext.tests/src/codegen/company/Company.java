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
 * A representation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link codegen.company.Company#getName <em>Name</em>}</li>
 *   <li>{@link codegen.company.Company#getEmployees <em>Employees</em>}</li>
 *   <li>{@link codegen.company.Company#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see codegen.company.CodegencompanyPackage#getCompany()
 * @model
 * @generated
 */
public interface Company extends EObject {
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
	 * @see codegen.company.CodegencompanyPackage#getCompany_Name()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/test/Pivot/Company.ecore!Company!name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link codegen.company.Company#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Employees</b></em>' containment reference list.
	 * The list contents are of type {@link codegen.company.Employee}.
	 * It is bidirectional and its opposite is '{@link codegen.company.Employee#getCompany <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employees</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employees</em>' containment reference list.
	 * @see codegen.company.CodegencompanyPackage#getCompany_Employees()
	 * @see codegen.company.Employee#getCompany
	 * @model opposite="company" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/test/Pivot/Company.ecore!Company!employees'"
	 * @generated
	 */
	EList<Employee> getEmployees();

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The literals are from the enumeration {@link codegen.company.CompanySizeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see codegen.company.CompanySizeKind
	 * @see codegen.company.CodegencompanyPackage#getCompany_Size()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='/**\n * \n * let\n *   table : Set(Tuple(range : Sequence(Integer), size : CompanySizeKind)) = Set{\n *     Tuple{range = Sequence{0..49}, size = CompanySizeKind::small\n *     }\n *     , Tuple{range = Sequence{50..999}, size = CompanySizeKind::medium\n *     }\n *     , Tuple{range = Sequence{1000..1000000}, size = CompanySizeKind::large\n *     }\n *   }\n * in\n *   table->any(range->includes(employees->size())).size\n \052/\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.lang.Object%> self = this;\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = new <%org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager%>(self, <%org.eclipse.ocl.examples.pivot.PivotTables%>.LIBRARY);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.TupleValue%> literal =  <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createTupleOfEach(<%codegen.company.CodegencompanyTables%>.TUPLid_, <%codegen.company.CodegencompanyTables%>.SEQ, <%codegen.company.CodegencompanyTables%>.ELITid_small);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.TupleValue%> literal_0 =  <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createTupleOfEach(<%codegen.company.CodegencompanyTables%>.TUPLid_, <%codegen.company.CodegencompanyTables%>.SEQ_0, <%codegen.company.CodegencompanyTables%>.ELITid_medium);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.TupleValue%> literal_1 =  <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createTupleOfEach(<%codegen.company.CodegencompanyTables%>.TUPLid_, <%codegen.company.CodegencompanyTables%>.SEQ_1, <%codegen.company.CodegencompanyTables%>.ELITid_large);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.SetValue%> SET = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createSetOfEach(<%codegen.company.CodegencompanyTables%>.SET_TUPLid_, literal, literal_0, literal_1);\nfinal @<%org.eclipse.jdt.annotation.NonNull%> /*@NonInvalid\052/ <%java.util.Iterator%><?> SET_iterator = SET.iterator();\n@<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.TupleValue%> any;\nwhile (true) {\n    if (!SET_iterator.hasNext()) {\n        throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"No matching content for \'any\'\");\n    }\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.values.TupleValue%> _49__ = (<%org.eclipse.ocl.examples.domain.values.TupleValue%>)SET_iterator.next();\n    /**\n     * range->includes(employees->size())\n     \052/\n    final @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.SequenceValue%> range = (<%org.eclipse.ocl.examples.domain.values.SequenceValue%>)_49__.getValue(0/*range\052/);\n    if (self == null) throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null Literal\");\n    final @SuppressWarnings(\"null\")@<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.util.List%><?> employees = (<%java.util.List%><?>)<%codegen.company.CodegencompanyTables%>.IMP_PROPid_employees.evaluate(evaluator, <%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, self);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.OrderedSetValue%> BOXED_employees = idResolver.createOrderedSetOfAll(<%codegen.company.CodegencompanyTables%>.ORD_CLSSid_Employee, employees);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.IntegerValue%> size_0 = <%org.eclipse.ocl.examples.library.collection.CollectionSizeOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.INTEGER, BOXED_employees);\n    final @<%org.eclipse.jdt.annotation.NonNull%> /*@Thrown\052/ <%java.lang.Boolean%> includes = <%org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.examples.domain.ids.TypeId%>.BOOLEAN, range, size_0);\n    /*\052/\n    if (includes != <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.FALSE_VALUE) {\t\t\t// Carry on till something found\n        any = _49__;\n        break;\n    }\n}\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId%> size = (<%org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId%>)any.getValue(1/*size\052/);\nif (size == null) throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null Literal\");\nfinal @<%org.eclipse.jdt.annotation.Nullable%> /*@Thrown\052/ <%org.eclipse.emf.common.util.Enumerator%> UNBOXED_size = idResolver.unboxedValueOf(size);\nreturn (<%codegen.company.CompanySizeKind%>)UNBOXED_size;\n'"
	 * @generated
	 */
	CompanySizeKind getSize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * true\n \052/\nreturn true;'"
	 * @generated
	 */
	boolean dummyInvariant(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Company
