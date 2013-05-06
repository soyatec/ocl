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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.ocl.examples.pivot.ecore.EObjectProperty;
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
	@SuppressWarnings("unchecked")
	@Override
	public EList<Employee> getDirectReports() {
		/**
		 * company.employees->select(manager = self)
		 */
		final @NonNull /*@NonInvalid*/ Employee self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @Nullable /*@Thrown*/ Company company = self.getCompany();
		if (company == null) {
		    throw new InvalidValueException("Null source");
		}
		final @Nullable /*@Thrown*/ List employees = company.getEmployees();
		if (employees == null) {
		    throw new InvalidValueException("Null source");
		}
		final @NonNull /*@Thrown*/ OrderedSetValue BOXED_employees = idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, employees);
		@NonNull /*@NonInvalid*/ OrderedSetValue.Accumulator accumulator = ValuesUtil.createOrderedSetAccumulatorValue(CodegencompanyTables.ORD_CLSSid_Employee);
		@Nullable Iterator ITERATOR__1 = BOXED_employees.iterator();
		@NonNull /*@Thrown*/ OrderedSetValue select;
		while (true) {
		    if (!ITERATOR__1.hasNext()) {
		        select = accumulator;
		        break;
		    }
		    @Nullable /*@NonInvalid*/ Employee _1 = (Employee)ITERATOR__1.next();
		    /**
		     * manager = self
		     */
		    if (_1 == null) {
		        throw new InvalidValueException("Null source");
		    }
		    final @Nullable /*@Thrown*/ Employee manager_0 = _1.getManager();
		    final @NonNull /*@Thrown*/ Boolean eq = OclAnyEqualOperation.INSTANCE.evaluate(manager_0, self);
		    //
		    if (eq == ValuesUtil.TRUE_VALUE) {
		        accumulator.add(_1);
		    }
		}
		final @NonNull /*@Thrown*/ List UNBOXED_select = select.asEcoreObject();
		return (EList<Employee>)UNBOXED_select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Employee> getAllReports() {
		/**
		 * Employee.allInstances()->select(reportsTo(self))
		 */
		final @NonNull /*@NonInvalid*/ Employee self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @NonNull /*@NonInvalid*/ DomainType TYP_company_c_c_Employee = idResolver.getType(CodegencompanyTables.CLSSid_Employee, null);
		final @NonNull /*@Thrown*/ SetValue allInstances = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, CodegencompanyTables.SET_CLSSid_Employee, TYP_company_c_c_Employee);
		@NonNull /*@NonInvalid*/ SetValue.Accumulator accumulator = ValuesUtil.createSetAccumulatorValue(CodegencompanyTables.SET_CLSSid_Employee);
		@Nullable Iterator ITERATOR__1 = allInstances.iterator();
		@NonNull /*@Thrown*/ SetValue select;
		while (true) {
		    if (!ITERATOR__1.hasNext()) {
		        select = accumulator;
		        break;
		    }
		    @Nullable /*@NonInvalid*/ Employee _1 = (Employee)ITERATOR__1.next();
		    /**
		     * reportsTo(self)
		     */
		    if (_1 == null) {
		        throw new InvalidValueException("Null source");
		    }
		    final @NonNull /*@Thrown*/ Boolean reportsTo = _1.reportsTo(self);
		    //
		    if (reportsTo == ValuesUtil.TRUE_VALUE) {
		        accumulator.add(_1);
		    }
		}
		final @NonNull /*@Thrown*/ List UNBOXED_select = select.asEcoreObject();
		return (EList<Employee>)UNBOXED_select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Employee> getReportingChain() {
		/**
		 * 
		 * if manager.oclIsUndefined()
		 * then OrderedSet{}
		 * else manager.reportingChain->prepend(manager)
		 * endif
		 */
		final @NonNull /*@NonInvalid*/ Employee self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object CAUGHT_manager_0;
		try {
		    final @Nullable /*@Thrown*/ Employee manager_0 = ((Employee)self).getManager();
		    CAUGHT_manager_0 = manager_0;
		}
		catch (Exception e) {
		    CAUGHT_manager_0 = ValuesUtil.createInvalidValue(e);
		}
		final @Nullable /*@Thrown*/ Boolean symbol_0 = (CAUGHT_manager_0 == null) || (CAUGHT_manager_0 instanceof InvalidValueException);
		if (symbol_0 == null) {
		    throw new InvalidValueException("Null source");
		}
		@Nullable /*@Thrown*/ OrderedSetValue symbol_1;
		if (symbol_0) {
		    symbol_1 = CodegencompanyTables.OrderedSet;
		}
		else {
		    final @Nullable /*@Thrown*/ Employee manager_1 = ((Employee)self).getManager();
		    if (manager_1 == null) {
		        throw new InvalidValueException("Null source");
		    }
		    final @Nullable /*@Thrown*/ List reportingChain = manager_1.getReportingChain();
		    final @Nullable /*@Thrown*/ OrderedSetValue BOXED_reportingChain = reportingChain == null ? null : idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, reportingChain);
		    final @Nullable /*@Thrown*/ Employee manager_2 = ((Employee)self).getManager();
		    final @NonNull /*@Thrown*/ OrderedSetValue prepend = (OrderedSetValue)OrderedCollectionPrependOperation.INSTANCE.evaluate(BOXED_reportingChain, manager_2);
		    symbol_1 = prepend;
		}
		if (symbol_1 == null) {
		    throw new InvalidValueException("Null source");
		}
		final @NonNull /*@Thrown*/ List UNBOXED_symbol_1 = symbol_1.asEcoreObject();
		return (EList<Employee>)UNBOXED_symbol_1;
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
		final @NonNull /*@NonInvalid*/ Employee self = this;
		final @Nullable /*@Thrown*/ String name = self.getName();
		final @NonNull /*@Thrown*/ Boolean ne = OclAnyNotEqualOperation.INSTANCE.evaluate(name, null);
		return ne;
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
		final @NonNull /*@NonInvalid*/ Employee self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final @Nullable /*@Thrown*/ List reportingChain = self.getReportingChain();
		final @Nullable /*@Thrown*/ OrderedSetValue BOXED_reportingChain = reportingChain == null ? null : idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, reportingChain);
		final @NonNull /*@Thrown*/ Boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_reportingChain, manager);
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
		 * 
		 * inv noManagerImpliesDirectReports: manager.oclIsUndefined() implies directReports->size() > 0
		 */
		final @NonNull /*@NonInvalid*/ Employee self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @Nullable /*@Caught*/ Object CAUGHT_symbol_0;
		    try {
		        @Nullable /*@Caught*/ Object CAUGHT_manager_0;
		        try {
		            final @Nullable /*@Thrown*/ Employee manager_0 = ((Employee)self).getManager();
		            CAUGHT_manager_0 = manager_0;
		        }
		        catch (Exception e) {
		            CAUGHT_manager_0 = ValuesUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean symbol_0 = (CAUGHT_manager_0 == null) || (CAUGHT_manager_0 instanceof InvalidValueException);
		        CAUGHT_symbol_0 = symbol_0;
		    }
		    catch (Exception e) {
		        CAUGHT_symbol_0 = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_gt;
		    try {
		        final @Nullable /*@Thrown*/ List directReports = ((Employee)self).getDirectReports();
		        final @Nullable /*@Thrown*/ OrderedSetValue BOXED_directReports = directReports == null ? null : idResolver.createOrderedSetOfAll(CodegencompanyTables.ORD_CLSSid_Employee, directReports);
		        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_directReports);
		        final @NonNull /*@Thrown*/ Boolean gt = NumericGreaterThanOperation.INSTANCE.evaluate(size, CodegencompanyTables.INT_0);
		        CAUGHT_gt = gt;
		    }
		    catch (Exception e) {
		        CAUGHT_gt = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_symbol_0, CAUGHT_gt);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
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
		final @NonNull /*@NonInvalid*/ Employee self = this;
		final @Nullable /*@Thrown*/ String name = self.getName();
		final @NonNull /*@Thrown*/ Boolean ne = OclAnyNotEqualOperation.INSTANCE.evaluate(name, null);
		return ne.booleanValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean mustHaveName(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv mustHaveName: not name.oclIsUndefined() and hasNameAsAttribute and hasNameAsOperation()
		 */
		final @NonNull /*@NonInvalid*/ Employee self = this;
		@Nullable /*@Caught*/ Object CAUGHT_and_0;
		try {
		    @Nullable /*@Caught*/ Object CAUGHT_and;
		    try {
		        @Nullable /*@Caught*/ Object CAUGHT_not;
		        try {
		            @Nullable /*@Caught*/ Object CAUGHT_name;
		            try {
		                final @Nullable /*@Thrown*/ String name = ((Employee)self).getName();
		                CAUGHT_name = name;
		            }
		            catch (Exception e) {
		                CAUGHT_name = ValuesUtil.createInvalidValue(e);
		            }
		            final @Nullable /*@Thrown*/ Boolean symbol_0 = (CAUGHT_name == null) || (CAUGHT_name instanceof InvalidValueException);
		            final @Nullable /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(symbol_0);
		            CAUGHT_not = not;
		        }
		        catch (Exception e) {
		            CAUGHT_not = ValuesUtil.createInvalidValue(e);
		        }
		        @Nullable /*@Caught*/ Object CAUGHT_hasNameAsAttribute;
		        try {
		            final @Nullable /*@Thrown*/ Boolean hasNameAsAttribute = ((Employee)self).isHasNameAsAttribute();
		            CAUGHT_hasNameAsAttribute = hasNameAsAttribute;
		        }
		        catch (Exception e) {
		            CAUGHT_hasNameAsAttribute = ValuesUtil.createInvalidValue(e);
		        }
		        final @Nullable /*@Thrown*/ Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_not, CAUGHT_hasNameAsAttribute);
		        CAUGHT_and = and;
		    }
		    catch (Exception e) {
		        CAUGHT_and = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_hasNameAsOperation;
		    try {
		        final @NonNull /*@Thrown*/ Boolean hasNameAsOperation = ((Employee)self).hasNameAsOperation();
		        CAUGHT_hasNameAsOperation = hasNameAsOperation;
		    }
		    catch (Exception e) {
		        CAUGHT_hasNameAsOperation = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and, CAUGHT_hasNameAsOperation);
		    CAUGHT_and_0 = and_0;
		}
		catch (Exception e) {
		    CAUGHT_and_0 = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_and_0 == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_and_0 == null ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	public boolean mustHaveNonEmptyName(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * inv mustHaveNonEmptyName: name->notEmpty() implies name.size() > 0
		 */
		final @NonNull /*@NonInvalid*/ Employee self = this;
		final @NonNull /*@NonInvalid*/ DomainEvaluator evaluator = new EcoreExecutorManager(this, CodegencompanyTables.LIBRARY);
		@Nullable /*@Caught*/ Object CAUGHT_implies;
		try {
		    @NonNull /*@Caught*/ Object CAUGHT_notEmpty;
		    try {
		        final @Nullable /*@Thrown*/ String name = ((Employee)self).getName();
		        final @NonNull /*@Thrown*/ SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(evaluator, CodegencompanyTables.SET_PRIMid_String, name);
		        final @NonNull /*@Thrown*/ Boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(oclAsSet);
		        CAUGHT_notEmpty = notEmpty;
		    }
		    catch (Exception e) {
		        CAUGHT_notEmpty = ValuesUtil.createInvalidValue(e);
		    }
		    @NonNull /*@Caught*/ Object CAUGHT_gt;
		    try {
		        final @Nullable /*@Thrown*/ String name_0 = ((Employee)self).getName();
		        final @NonNull /*@Thrown*/ IntegerValue size = StringSizeOperation.INSTANCE.evaluate(name_0);
		        final @NonNull /*@Thrown*/ Boolean gt = NumericGreaterThanOperation.INSTANCE.evaluate(size, CodegencompanyTables.INT_0);
		        CAUGHT_gt = gt;
		    }
		    catch (Exception e) {
		        CAUGHT_gt = ValuesUtil.createInvalidValue(e);
		    }
		    final @Nullable /*@Thrown*/ Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_notEmpty, CAUGHT_gt);
		    CAUGHT_implies = implies;
		}
		catch (Exception e) {
		    CAUGHT_implies = ValuesUtil.createInvalidValue(e);
		}
		if (CAUGHT_implies == ValuesUtil.TRUE_VALUE) {
		    return true;
		}
		if (diagnostics != null) {
		    int severity = CAUGHT_implies == null ? Diagnostic.ERROR : Diagnostic.WARNING;
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
	@SuppressWarnings("unchecked")
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
