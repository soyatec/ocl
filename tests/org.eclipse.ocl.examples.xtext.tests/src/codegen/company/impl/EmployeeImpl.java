/**
 */
package codegen.company.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue.Accumulator;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.examples.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.examples.library.collection.CollectionNotEmptyOperation;
import org.eclipse.ocl.examples.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.examples.library.collection.OrderedCollectionPrependOperation;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.library.logical.BooleanAndOperation;
import org.eclipse.ocl.examples.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.examples.library.logical.BooleanNotOperation;
import org.eclipse.ocl.examples.library.numeric.NumericGreaterThanOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyNotEqualOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclIsUndefinedOperation;
import org.eclipse.ocl.examples.library.string.StringSizeOperation;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.osgi.util.NLS;

import codegen.company.CodegencompanyPackage;
import codegen.company.CodegencompanyTables;
import codegen.company.Company;
import codegen.company.Employee;
import codegen.company.util.CodegencompanyValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link codegen.company.impl.EmployeeImpl#getName <em>Name</em>}</li>
 *   <li>{@link codegen.company.impl.EmployeeImpl#getManager <em>Manager</em>}</li>
 *   <li>{@link codegen.company.impl.EmployeeImpl#getCompany <em>Company</em>}</li>
 *   <li>{@link codegen.company.impl.EmployeeImpl#getDirectReports <em>Direct Reports</em>}</li>
 *   <li>{@link codegen.company.impl.EmployeeImpl#getAllReports <em>All Reports</em>}</li>
 *   <li>{@link codegen.company.impl.EmployeeImpl#getReportingChain <em>Reporting Chain</em>}</li>
 *   <li>{@link codegen.company.impl.EmployeeImpl#isHasNameAsAttribute <em>Has Name As Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings({"unchecked", "unused"})
public class EmployeeImpl extends EObjectImpl implements Employee {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getManager() <em>Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManager()
	 * @generated
	 * @ordered
	 */
	protected Employee manager;

	/**
	 * The default value of the '{@link #isHasNameAsAttribute() <em>Has Name As Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasNameAsAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_NAME_AS_ATTRIBUTE_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmployeeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegencompanyPackage.Literals.EMPLOYEE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegencompanyPackage.EMPLOYEE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Employee getManager() {
		if (manager != null && manager.eIsProxy()) {
			InternalEObject oldManager = (InternalEObject)manager;
			manager = (Employee)eResolveProxy(oldManager);
			if (manager != oldManager) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodegencompanyPackage.EMPLOYEE__MANAGER, oldManager, manager));
			}
		}
		return manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetManager() {
		return manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setManager(Employee newManager) {
		Employee oldManager = manager;
		manager = newManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegencompanyPackage.EMPLOYEE__MANAGER, oldManager, manager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Company getCompany() {
		if (eContainerFeatureID() != CodegencompanyPackage.EMPLOYEE__COMPANY) return null;
		return (Company)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompany(Company newCompany, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCompany, CodegencompanyPackage.EMPLOYEE__COMPANY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompany(Company newCompany) {
		if (newCompany != eInternalContainer() || (eContainerFeatureID() != CodegencompanyPackage.EMPLOYEE__COMPANY && newCompany != null)) {
			if (EcoreUtil.isAncestor(this, newCompany))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCompany != null)
				msgs = ((InternalEObject)newCompany).eInverseAdd(this, CodegencompanyPackage.COMPANY__EMPLOYEES, Company.class, msgs);
			msgs = basicSetCompany(newCompany, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegencompanyPackage.EMPLOYEE__COMPANY, newCompany, newCompany));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Employee> getDirectReports() {
		/**
		 * company.employees->select(manager = self)
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @Nullable /*@Thrown*/ Object company = CodegencompanyTables.IMP_PROPid_company.evaluate(evaluator, CodegencompanyTables.CLSSid_Company, self);
		if (company == null) throw new InvalidValueException("Null Literal");
		final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> employees = (List<?>)CodegencompanyTables.IMP_PROPid_employees.evaluate(evaluator, CodegencompanyTables.ORD_CLSSid_Employee, company);
		final @NonNull /*@Thrown*/ OrderedSetValue BOXED_employees = idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, employees);
		@NonNull /*@Thrown*/ Accumulator employees_accumulator = ValuesUtil.createOrderedSetAccumulatorValue(CodegencompanyTables.ORD_CLSSid_Employee);
		final @NonNull /*@NonInvalid*/ Iterator<?> employees_iterator = BOXED_employees.iterator();
		@NonNull /*@Thrown*/ OrderedSetValue select;
		while (true) {
		    if (!employees_iterator.hasNext()) {
		        select = employees_accumulator;
		        break;
		    }
		    final @Nullable /*@NonInvalid*/ Object _49__ = employees_iterator.next();
		    /**
		     * manager = self
		     */
		    if (_49__ == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ Object manager = CodegencompanyTables.IMP_PROPid_manager.evaluate(evaluator, CodegencompanyTables.CLSSid_Employee, _49__);
		    final @NonNull /*@Thrown*/ Boolean _q = OclAnyEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, manager, self);
		    /**/
		    if (_q == ValuesUtil.TRUE_VALUE) {
		        employees_accumulator.add(_49__);
		    }
		}
		final @NonNull /*@Thrown*/ List<?> UNBOXED_select = select.asEcoreObject();
		return (EList<Employee>)UNBOXED_select;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Employee> getAllReports() {
		/**
		 * Employee.allInstances()->select(reportsTo(self))
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_company_c_c_Employee = idResolver.getType(CodegencompanyTables.CLSSid_Employee, null);
		final @NonNull /*@Thrown*/ SetValue allInstances = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, CodegencompanyTables.SET_CLSSid_Employee, TYP_company_c_c_Employee);
		@NonNull /*@Thrown*/ org.eclipse.ocl.examples.domain.values.SetValue.Accumulator allInstances_accumulator = ValuesUtil.createSetAccumulatorValue(CodegencompanyTables.SET_CLSSid_Employee);
		final @NonNull /*@NonInvalid*/ Iterator<?> allInstances_iterator = allInstances.iterator();
		@NonNull /*@Thrown*/ SetValue select;
		while (true) {
		    if (!allInstances_iterator.hasNext()) {
		        select = allInstances_accumulator;
		        break;
		    }
		    final @Nullable /*@NonInvalid*/ Object _49__ = allInstances_iterator.next();
		    /**
		     * reportsTo(self)
		     */
		    final @NonNull /*@Thrown*/ Boolean reportsTo = (Boolean)CodegencompanyTables.IMP_OPid_reportsTo.evaluate(evaluator, TypeId.BOOLEAN, _49__, self);
		    /**/
		    if (reportsTo == ValuesUtil.TRUE_VALUE) {
		        allInstances_accumulator.add(_49__);
		    }
		}
		final @NonNull /*@Thrown*/ List<?> UNBOXED_select = select.asEcoreObject();
		return (EList<Employee>)UNBOXED_select;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Employee> getReportingChain() {
		/**
		 * 
		 * if manager.oclIsUndefined()
		 * then OrderedSet{}
		 * else manager.reportingChain->prepend(manager)
		 * endif
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Thrown*/ OrderedSetValue symbol_0;
		@Nullable /*@Caught*/ Object manager;
		try {
		    manager = CodegencompanyTables.IMP_PROPid_manager.evaluate(evaluator, CodegencompanyTables.CLSSid_Employee, self);
		}
		catch (Exception e) {
		    manager = ValuesUtil.createInvalidValue(e);
		}
		final @NonNull /*@Thrown*/ Boolean oclIsUndefined = OclAnyOclIsUndefinedOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, manager);
		if (oclIsUndefined == ValuesUtil.TRUE_VALUE) {
		    symbol_0 = CodegencompanyTables.ORD;
		}
		else if (oclIsUndefined == ValuesUtil.FALSE_VALUE) {
		    final @Nullable /*@Thrown*/ Object manager_0 = CodegencompanyTables.IMP_PROPid_manager.evaluate(evaluator, CodegencompanyTables.CLSSid_Employee, self);
		    if (manager_0 == null) throw new InvalidValueException("Null Literal");
		    final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> reportingChain = (List<?>)CodegencompanyTables.IMP_PROPid_reportingChain.evaluate(evaluator, CodegencompanyTables.ORD_CLSSid_Employee, manager_0);
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_reportingChain = idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, reportingChain);
		    final @Nullable /*@Thrown*/ Object manager_1 = CodegencompanyTables.IMP_PROPid_manager.evaluate(evaluator, CodegencompanyTables.CLSSid_Employee, self);
		    final @NonNull /*@Thrown*/ OrderedSetValue prepend = (OrderedSetValue)OrderedCollectionPrependOperation.INSTANCE.evaluate(evaluator, CodegencompanyTables.ORD_CLSSid_Employee, BOXED_reportingChain, manager_1);
		    symbol_0 = prepend;
		}
		else {
		    throw ValuesUtil.INVALID_VALUE;
		}
		if (symbol_0 == null) throw new InvalidValueException("Null Literal");
		final @Nullable /*@Thrown*/ List<?> UNBOXED_symbol_0 = symbol_0.asEcoreObject();
		return (EList<Employee>)UNBOXED_symbol_0;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasNameAsAttribute() {
		/**
		 * name <> null
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @Nullable /*@Thrown*/ String name = (String)CodegencompanyTables.IMP_PROPid_name.evaluate(evaluator, TypeId.STRING, self);
		final @NonNull /*@Thrown*/ Boolean _l_g = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, null);
		return (Boolean)_l_g;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean reportsTo(final Employee manager) {
		/**
		 * self.reportingChain->includes(manager)
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		if (self == null) throw new InvalidValueException("Null Literal");
		final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> reportingChain = (List<?>)CodegencompanyTables.IMP_PROPid_reportingChain.evaluate(evaluator, CodegencompanyTables.ORD_CLSSid_Employee, self);
		final @NonNull /*@Thrown*/ OrderedSetValue BOXED_reportingChain = idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, reportingChain);
		final @NonNull /*@Thrown*/ Boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, BOXED_reportingChain, manager);
		return includes.booleanValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean noManagerImpliesDirectReports(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * manager.oclIsUndefined() implies directReports->size() > 0
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@NonNull /*@Caught*/ Object oclIsUndefined;
		try {
		    @Nullable /*@Caught*/ Object manager;
		    try {
		    if (self == null) throw new InvalidValueException("Null Literal");
		        manager = CodegencompanyTables.IMP_PROPid_manager.evaluate(evaluator, CodegencompanyTables.CLSSid_Employee, self);
		    }
		    catch (Exception e) {
		        manager = ValuesUtil.createInvalidValue(e);
		    }
		    oclIsUndefined = OclAnyOclIsUndefinedOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, manager);
		} catch (Exception e_0) { oclIsUndefined = ValuesUtil.createInvalidValue(e_0); }
		@NonNull /*@Caught*/ Object _g;
		try {
		    final @SuppressWarnings("null")@NonNull /*@Thrown*/ List<?> directReports = (List<?>)CodegencompanyTables.IMP_PROPid_directReports.evaluate(evaluator, CodegencompanyTables.ORD_CLSSid_Employee, self);
		    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_directReports = idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, directReports);
		    final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, BOXED_directReports);
		    _g = NumericGreaterThanOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, CodegencompanyTables.INT_0);
		} catch (Exception e_1) { _g = ValuesUtil.createInvalidValue(e_1); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsUndefined, _g);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Employee", "noManagerImpliesDirectReports", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, CodegencompanyValidator.DIAGNOSTIC_SOURCE, CodegencompanyValidator.EMPLOYEE__NO_MANAGER_IMPLIES_DIRECT_REPORTS, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean hasNameAsOperation() {
		/**
		 * name <> null
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		if (self == null) throw new InvalidValueException("Null Literal");
		final @Nullable /*@Thrown*/ String name = (String)CodegencompanyTables.IMP_PROPid_name.evaluate(evaluator, TypeId.STRING, self);
		final @NonNull /*@Thrown*/ Boolean _l_g = OclAnyNotEqualOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name, null);
		return _l_g.booleanValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean mustHaveName(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * not name.oclIsUndefined() and hasNameAsAttribute and hasNameAsOperation()
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		@Nullable /*@Caught*/ Object and_0;
		try {
		    @Nullable /*@Caught*/ Object not;
		    try {
		        @Nullable /*@Caught*/ Object name;
		        try {
		        if (self == null) throw new InvalidValueException("Null Literal");
		            name = CodegencompanyTables.IMP_PROPid_name.evaluate(evaluator, TypeId.STRING, self);
		        }
		        catch (Exception e) {
		            name = ValuesUtil.createInvalidValue(e);
		        }
		        final @NonNull /*@Thrown*/ Boolean oclIsUndefined = OclAnyOclIsUndefinedOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, name);
		        not = BooleanNotOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclIsUndefined);
		    } catch (Exception e_0) { not = ValuesUtil.createInvalidValue(e_0); }
		    @Nullable /*@Caught*/ Object hasNameAsAttribute;
		    try {
		        hasNameAsAttribute = CodegencompanyTables.IMP_PROPid_hasNameAsAttribute.evaluate(evaluator, TypeId.BOOLEAN, self);
		    }
		    catch (Exception e_1) {
		        hasNameAsAttribute = ValuesUtil.createInvalidValue(e_1);
		    }
		    and_0 = BooleanAndOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, not, hasNameAsAttribute);
		} catch (Exception e_2) { and_0 = ValuesUtil.createInvalidValue(e_2); }
		@Nullable /*@Caught*/ Object hasNameAsOperation;
		try {
		    hasNameAsOperation = CodegencompanyTables.IMP_OPid_hasNameAsOperation.evaluate(evaluator, TypeId.BOOLEAN, self);
		}
		catch (Exception e_3) {
		    hasNameAsOperation = ValuesUtil.createInvalidValue(e_3);
		}
		final @Nullable /*@Thrown*/ Boolean and = BooleanAndOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, and_0, hasNameAsOperation);
		if (and == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = and == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Employee", "mustHaveName", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, CodegencompanyValidator.DIAGNOSTIC_SOURCE, CodegencompanyValidator.EMPLOYEE__MUST_HAVE_NAME, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean mustHaveNonEmptyName(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * name->notEmpty() implies name.size() > 0
		 */
		final @NonNull /*@NonInvalid*/ Object self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
		@NonNull /*@Caught*/ Object notEmpty;
		try {
		    if (self == null) throw new InvalidValueException("Null Literal");
		    final @Nullable /*@Thrown*/ String name = (String)CodegencompanyTables.IMP_PROPid_name.evaluate(evaluator, TypeId.STRING, self);
		    final @NonNull /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, CodegencompanyTables.SET_PRIMid_String, name);
		    notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, oclAsSet);
		} catch (Exception e) { notEmpty = ValuesUtil.createInvalidValue(e); }
		@NonNull /*@Caught*/ Object _g;
		try {
		    final @Nullable /*@Thrown*/ String name_0 = (String)CodegencompanyTables.IMP_PROPid_name.evaluate(evaluator, TypeId.STRING, self);
		    final @NonNull /*@Thrown*/ IntegerValue size = StringSizeOperation.INSTANCE.evaluate(evaluator, TypeId.INTEGER, name_0);
		    _g = NumericGreaterThanOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, size, CodegencompanyTables.INT_0);
		} catch (Exception e_0) { _g = ValuesUtil.createInvalidValue(e_0); }
		final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, notEmpty, _g);
		if (implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
		    String message = NLS.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{"Employee", "mustHaveNonEmptyName", EObjectValidator.getObjectLabel(this, context)});
		    diagnostics.add(new BasicDiagnostic(severity, CodegencompanyValidator.DIAGNOSTIC_SOURCE, CodegencompanyValidator.EMPLOYEE__MUST_HAVE_NON_EMPTY_NAME, message, new Object [] { this }));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCompany((Company)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				return basicSetCompany(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				return eInternalContainer().eInverseRemove(this, CodegencompanyPackage.COMPANY__EMPLOYEES, Company.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodegencompanyPackage.EMPLOYEE__NAME:
				return getName();
			case CodegencompanyPackage.EMPLOYEE__MANAGER:
				if (resolve) return getManager();
				return basicGetManager();
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				return getCompany();
			case CodegencompanyPackage.EMPLOYEE__DIRECT_REPORTS:
				return getDirectReports();
			case CodegencompanyPackage.EMPLOYEE__ALL_REPORTS:
				return getAllReports();
			case CodegencompanyPackage.EMPLOYEE__REPORTING_CHAIN:
				return getReportingChain();
			case CodegencompanyPackage.EMPLOYEE__HAS_NAME_AS_ATTRIBUTE:
				return isHasNameAsAttribute();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CodegencompanyPackage.EMPLOYEE__NAME:
				setName((String)newValue);
				return;
			case CodegencompanyPackage.EMPLOYEE__MANAGER:
				setManager((Employee)newValue);
				return;
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				setCompany((Company)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CodegencompanyPackage.EMPLOYEE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CodegencompanyPackage.EMPLOYEE__MANAGER:
				setManager((Employee)null);
				return;
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				setCompany((Company)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CodegencompanyPackage.EMPLOYEE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CodegencompanyPackage.EMPLOYEE__MANAGER:
				return manager != null;
			case CodegencompanyPackage.EMPLOYEE__COMPANY:
				return getCompany() != null;
			case CodegencompanyPackage.EMPLOYEE__DIRECT_REPORTS:
				return !getDirectReports().isEmpty();
			case CodegencompanyPackage.EMPLOYEE__ALL_REPORTS:
				return !getAllReports().isEmpty();
			case CodegencompanyPackage.EMPLOYEE__REPORTING_CHAIN:
				return !getReportingChain().isEmpty();
			case CodegencompanyPackage.EMPLOYEE__HAS_NAME_AS_ATTRIBUTE:
				return isHasNameAsAttribute() != HAS_NAME_AS_ATTRIBUTE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CodegencompanyPackage.EMPLOYEE___REPORTS_TO__EMPLOYEE:
				return reportsTo((Employee)arguments.get(0));
			case CodegencompanyPackage.EMPLOYEE___NO_MANAGER_IMPLIES_DIRECT_REPORTS__DIAGNOSTICCHAIN_MAP:
				return noManagerImpliesDirectReports((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case CodegencompanyPackage.EMPLOYEE___HAS_NAME_AS_OPERATION:
				return hasNameAsOperation();
			case CodegencompanyPackage.EMPLOYEE___MUST_HAVE_NAME__DIAGNOSTICCHAIN_MAP:
				return mustHaveName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case CodegencompanyPackage.EMPLOYEE___MUST_HAVE_NON_EMPTY_NAME__DIAGNOSTICCHAIN_MAP:
				return mustHaveNonEmptyName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EmployeeImpl
