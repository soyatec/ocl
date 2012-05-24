/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCL.java,v 1.4 2011/02/11 20:00:28 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.evaluation.EvaluationHaltedException;
import org.eclipse.ocl.examples.domain.evaluation.InvalidEvaluationException;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.helper.OCLHelperImpl;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.QueryImpl;

/**
 * Convenient subclass of the <code>OCL</code> fa&ccedil;ade that binds the
 * Ecore metamodel to the superclass's generic type parameters.  This frees
 * client code from the long list of parameter substitutions.  This subclass
 * also provides a shortcut to creating an <code>OCL</code> on the shared
 * {@link EcoreEnvironmentFactory} instance.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @see EcoreEnvironmentFactory
 */
public class OCL {

	/**
	 * Initialize registries to support OCL and Ecore usage. This method is
	 * intended for initialization of standalone behaviors for which plugin extension
	 * registrations have not been applied. 
	 *<p> 
	 * A null resourceSet may be provided to initialize the global package registry
	 * and global URI mapping registry.
	 *<p> 
	 * A non-null resourceSet may be provided to identify a specific package registry.
	 *<p>
	 * This method is used to configure the ResourceSet used to load the OCL Standard Library.

	 * @param resourceSet to be initialized or null for global initialization
	 * @return a failure reason, null if successful
	 * 
	 */
	public static String initialize(ResourceSet resourceSet) {
		Resource.Factory.Registry resourceFactoryRegistry = resourceSet != null
			? resourceSet.getResourceFactoryRegistry()
			: Resource.Factory.Registry.INSTANCE;
		resourceFactoryRegistry.getExtensionToFactoryMap().put(
			"ecore", new EcoreResourceFactoryImpl()); //$NON-NLS-1$
		return null;
	}

    /**
     * Creates a new <code>OCL</code> using the shared Ecore environment
     * factory instance.
     * 
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance() {
		return newInstance(PivotEnvironmentFactory.getGlobalRegistryInstance());
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment
     * factory.
     * 
     * @param envFactory an environment factory for Ecore
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance(EnvironmentFactory envFactory) {
		
		return new OCL(envFactory, envFactory.createEnvironment());
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment
     * factory and a resource from which to load the initial environment.
     * 
     * @param envFactory an environment factory for Ecore
     * @param resource the resource containing a persistent environment
     *    (which may be empty for an initially empty environment)
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance(EnvironmentFactory envFactory,
			Resource resource) {
		
		return new OCL(envFactory, envFactory.loadEnvironment(resource));
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified initial Ecore
     * environment.
     * 
     * @param env an environment for Ecore
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance(Environment env) {	
		return new OCL(env.getFactory(), env);
	}
	
	private final EnvironmentFactory environmentFactory;

	private final Environment rootEnvironment;

	private EvaluationEnvironment evalEnv;

	private DomainModelManager modelManager;

	private List<Constraint> constraints = new java.util.ArrayList<Constraint>();

	private Diagnostic problems;
	private Diagnostic evaluationProblems;	

	private int parserRepairCount = 0;

	private boolean traceParsing = PivotPlugin.shouldTrace(OCLDebugOptions.PARSING);

	private boolean traceEvaluation = PivotPlugin.shouldTrace(OCLDebugOptions.EVALUATION);

	/**
	 * Initializes me with my environment factory and root environment.
	 * 
	 * @param envFactory
	 *            my environment factory
	 * @param rootEnv
	 *            my root environment
	 */
	protected OCL(EnvironmentFactory envFactory, Environment rootEnv) {
		this.environmentFactory = envFactory;
		this.rootEnvironment = rootEnv;

		if (envFactory instanceof AbstractEnvironmentFactory) {
			AbstractEnvironmentFactory abstractFactory = (AbstractEnvironmentFactory) envFactory;

			abstractFactory.setEvaluationTracingEnabled(traceEvaluation);
		}
	}

	/**
	 * Checks whether a constraint is satisfied by an object. If the constraint
	 * is an invariant constraint, then no additional variable bindings are
	 * required. If it is an operation precondition or postcondition, however,
	 * then the appropriate parameter variables and (in the postcondition case)
	 * result variable should be bound in the evaluation environment.
	 * 
	 * @param context
	 *            the <tt>self</tt> object of the constraint
	 * @param constraint
	 *            the constraint to check
	 * 
	 * @return whether the context object satisfies the constraint
	 * 
	 * @see #check(Object, OCLExpression)
	 * @see #evaluate(Object, OCLExpression)
	 */
	public boolean check(Object context, Constraint constraint) {
		ExpressionInOcl specification = (ExpressionInOcl) constraint.getSpecification();

		return check(context, specification);
	}

	/**
	 * Checks whether a constraint, specified simply as an OCL expression, is
	 * satisfied by an object. If the constraint is an invariant constraint,
	 * then no additional variable bindings are required. If it is an operation
	 * precondition or postcondition, however, then the appropriate parameter
	 * variables and (in the postcondition case) result variable should be bound
	 * in the evaluation environment.
	 * 
	 * @param context
	 *            the <tt>self</tt> object of the constraint
	 * @param constraint
	 *            the constraint to check, which must be a boolean-valued
	 *            expression
	 * 
	 * @return whether the context object satisfies the constraint
	 * 
	 * @see #check(Object, Object)
	 * @see #evaluate(Object, OCLExpression)
	 * 
	 * @throws IllegalArgumentException
	 *             if the constraint expression is not boolean-valued
	 */
	public boolean check(Object context, ExpressionInOcl specification) {
		DomainStandardLibrary stdlib = getEnvironment().getOCLStandardLibrary();
		if (specification.getBodyExpression().getType() != stdlib.getBooleanType()) {
			throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
		}
		try {
			Value result = evaluate(context, specification);
			return result.isTrue();
		} catch (InvalidEvaluationException e) {
			return false;
		}
	}
    
	/**
	 * Creates a new {@link OCLHelper} instance for convenient parsing of
	 * embedded constraints and query expressions in this environment. The
	 * helper is particulary useful for parsing constraints embedded in the
	 * model, in which case the context of a constraint is determined by its
	 * placement and the textual context declarations are unnecessary.
	 * 
	 * @return a new helper object
	 */
    public OCLHelper createOCLHelper() {
       return new OCLHelperImpl(this);
    }

	/**
	 * Creates a new {@link Query} encapsulating a query expression with the
	 * current environment and extent map. This is convenient for repeated
	 * evaluation of expressions and for filtering/transforming objects using a
	 * query or constraint expression.
	 * <p>
	 * Every query maintains its own evaluation environment, which enables
	 * concurrent evaluation (where this may be safe in an EMF-based model) and
	 * different bindings for client-supplied "global" variables.
	 * </p>
	 * 
	 * @param query
	 *            the OCL query expression, which may be interpreted as a
	 *            constraint if it is boolean-valued
	 * 
	 * @return the new query object
	 * 
	 * @see #createQuery(Object)
	 */
	public Query createQuery(ExpressionInOcl specification) {
		return new QueryImpl(this, specification);
	}

	/**
	 * Creates a new {@link Query} encapsulating a constraint with the current
	 * environment and extent map. This is convenient for repeated evaluation of
	 * constraints and for filtering objects using the constraint expression.
	 * <p>
	 * Every query maintains its own evaluation environment, which enables
	 * concurrent evaluation (where this may be safe in an EMF-based model) and
	 * different bindings for client-supplied "global" variables.
	 * </p>
	 * 
	 * @param constraint
	 *            the OCL constraint
	 * 
	 * @return the new query object
	 * 
	 * @see #createQuery(OCLExpression)
	 */
	public Query createQuery(Constraint constraint) {
		return new QueryImpl(this, (ExpressionInOcl) constraint.getSpecification());
	}

	/**
	 * Return the Pivot resource counterpart of an Xtext csResource.
	 */
	public Resource cs2pivot(BaseResource csResource) {
		MetaModelManager metaModelManager = getMetaModelManager();
		Resource pivotResource = csResource.getPivotResource(metaModelManager);
		return pivotResource;
	}

	/**
	 * Disposes any objects that I have created while I have been in use. This
	 * includes disposing of any {@link #getConstraints() constraints} that I
	 * have parsed and {@linkplain Environment.Internal#dispose() disposing} of
	 * my environment.
	 */
	public void dispose() {
		// dispose of constraints by clearing their adapters
		for (Constraint constraint : getConstraints()) {
			EObject eObject = (EObject) constraint;

			if (eObject.eResource() == null) {
				ObjectUtil.dispose(constraint);
			}
		}

		// forget the constraints
		getConstraints().clear();

		// dispose of my environment
		if (getEnvironment() instanceof Environment.Internal) {
			Environment.Internal env = (Environment.Internal) getEnvironment();
			env.dispose();
		}
		getMetaModelManager().dispose();
	}

	/**
	 * Return the Pivot resource counterpart of an ecoreResource, specifying the uri of the resulting Ecore resource
	 * and options for the Pivot2Ecore converter.
	 */
	public Resource ecore2pivot(Resource ecoreResource) {
		MetaModelManager metaModelManager = getMetaModelManager();
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, metaModelManager);
		org.eclipse.ocl.examples.pivot.Package pivotRoot = ecore2Pivot.getPivotRoot();
		Resource pivotResource = pivotRoot.eResource();
		return pivotResource;
	}

	/**
	 * Evaluates a query expression on a context object (which is bound to the
	 * <tt>self</tt> variable). Clients should use the
	 * {@link #isInvalid(Object)} method to check whether the evaluation result
	 * is <tt>OclInvalid</tt>.
	 * 
	 * @param context
	 *            the context (self) object
	 * @param expression
	 *            the OCL expression to evaluate
	 * 
	 * @return the value of the expression, or <tt>OclInvalid</tt> if the
	 *         evaluation fails for reasons other than a run-time exception
	 * 
	 * @see #isInvalid(Object)
	 * @see #check(Object, Object)
	 */
	public Value evaluate(Object context, ExpressionInOcl expression) {
		evaluationProblems = null;
		
		// can determine a more appropriate context from the context
		// variable of the expression, to account for stereotype constraints
//		context = HelperUtil.getConstraintContext(rootEnvironment, context, expression);
		EvaluationEnvironment localEvalEnv = getEvaluationEnvironment();
		ValueFactory valueFactory = localEvalEnv.getValueFactory();
		Value value = valueFactory.valueOf(context);
		localEvalEnv.add(expression.getContextVariable(), value);
//		if ((value != null) && !value.isUndefined()) {
//			expression.getContextVariable().setValue(value);
//		}
		DomainModelManager extents = getModelManager();
		if (extents == null) {
			// let the evaluation environment create one
			extents = localEvalEnv.createModelManager(context);
		}

		EvaluationVisitor ev = environmentFactory
			.createEvaluationVisitor(rootEnvironment, localEvalEnv, extents);

		Value result;

		try {
			result = expression.accept(ev);
		} catch (EvaluationHaltedException e) {
			evaluationProblems = e.getDiagnostic();
			throw e;
		} finally {
			localEvalEnv.remove(expression.getContextVariable());
		}
		if (result == null) {
			return localEvalEnv.throwInvalidEvaluation("Java-Null value");
		}
		if (result.isInvalid()) {
			return localEvalEnv.throwInvalidEvaluation("Invalid Value");
		}
		return result;
	}

	/**
	 * Obtains all of the constraints parsed hitherto by this OCL instance.
	 * These accumulate with every document that is parsed.
	 * 
	 * @return the constraints that I have parsed
	 * 
	 * @see #parse(OCLInput)
	 */
	public List<Constraint> getConstraints() {
		return constraints;
	}

	/**
	 * Obtains the OCL parsing environment. Clients may manipulate this
	 * environment to support custom requirements, such as adding variables to
	 * it to define "global" values. For any variables that are added, bindings
	 * will have to provided, as well, in the
	 * {@linkplain #getEvaluationEnvironment() evaluation environment}.
	 * 
	 * @return the parsing environment
	 * 
	 * @see #getEvaluationEnvironment()
	 */
	public Environment getEnvironment() {
		return rootEnvironment;
	}

	public EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	/**
	 * Obtains the OCL evaluation environment. Clients may manipulate this
	 * environment to support custom requirements, such as binding the values of
	 * "global" variables.
	 * 
	 * @return the evaluation environment
	 * 
	 * @see #getEnvironment()
	 */
	public EvaluationEnvironment getEvaluationEnvironment() {
		if (evalEnv == null) {
			evalEnv = environmentFactory.createEvaluationEnvironment();
		}

		return evalEnv;
	}
	
	/**
	 * Obtains problems, if any, occurred during evaluation of the last OCL
	 * constraint or query expression.
	 * 
	 * @return evaluation problems or <code>null</code> if all was OK
	 */
	public Diagnostic getEvaluationProblems() {
		return evaluationProblems;
	}

	public MetaModelManager getMetaModelManager() {
		return rootEnvironment.getMetaModelManager();
	}

	/**
	 * Obtains the model manager, if any, provided by the client to customize the
	 * evaluation of constraints.
	 * 
	 * @return the client-provided custom model manager, or <code>null</code> if
	 *         thie OCL is using the default dynamic extent map implementation
	 */
	public DomainModelManager getModelManager() {
		return modelManager;
	}

	/**
	 * <p>
	 * Queries the number of repairs to be made by the parser.
	 * </p>
	 * <p>
	 * The default zero value selects use of the deterministic parser, which
	 * terminates after one serious syntax error is detected.
	 * </p>
	 * <p>
	 * A non-zero value selects the backtracking parser. The backtracking parser
	 * may be about three times slower.
	 * </p>
	 * 
	 * @return the number of repairs to be attempted
	 * 
	 * @see #setParserRepairCount(int)
	 */
	public int getParserRepairCount() {
		return parserRepairCount;
	}

	/**
	 * Obtains problems, if any, found in parsing the last OCL constraint or
	 * query expression.
	 * 
	 * @return parsing problems or <code>null</code> if all was OK
	 */
	public Diagnostic getProblems() {
		return problems;
	}

	public ValueFactory getValueFactory() {
		return getMetaModelManager().getValueFactory();
	}

	/**
	 * Queries whether tracing of evaluation is enabled. Tracing logs the
	 * progress of evaluation to the console, which may be of use in diagnosing
	 * problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option.
	 * </p>
	 * 
	 * @return whether evaluation tracing is enabled
	 * 
	 * @see #setEvaluationTracingEnabled(boolean)
	 */
	public boolean isEvaluationTracingEnabled() {
		return traceEvaluation;
	}

	/**
	 * Queries whether a value is the special <tt>invalid</tt> token. This is
	 * useful for determining whether the result of an expression evaluation is
	 * valid.
	 * 
	 * @param value
	 *            some OCL value
	 * @return <code>true</code> if it is the <tt>invalid</tt>;
	 *         <code>false</code>, otherwise
	 * 
	 * @see #evaluate(Object, OCLExpression)
	 */
//	public boolean isInvalid(Object value) {
//		return getEnvironment().getOCLStandardLibrary().getInvalidValue() == value;
//	}

	/**
	 * Queries whether tracing of parsingis enabled. Tracing logs the progress
	 * of parsing to the console, which may be of use in diagnosing problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/parsing</tt> debug option.
	 * </p>
	 * 
	 * @return whether parse tracing is enabled
	 * 
	 * @see #setParseTracingEnabled(boolean)
	 */
	public boolean isParseTracingEnabled() {
		return traceParsing;
	}

	/**
	 * Update the CS resource from a pivotResource.
	 * 
	 * For a first update, the csResource may be created by something like
	 * <p><tt>
	 * (BaseResource) resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
	 * </tt>
	 */
	public void pivot2cs(Resource pivotResource, BaseResource csResource) {
		MetaModelManager metaModelManager = getMetaModelManager();
		csResource.updateFrom(pivotResource, metaModelManager);
	}

	/**
	 * Return the Ecore resource counterpart of a pivotResource, specifying the uri of the resulting Ecore resource.
	 */
	public Resource pivot2ecore(Resource pivotResource, URI uri) throws IOException {
		MetaModelManager metaModelManager = getMetaModelManager();
		Resource ecoreResource = Pivot2Ecore.createResource(metaModelManager, pivotResource, uri, null);
		return ecoreResource;
	}

	/**
	 * Sets whether tracing of evaluation is enabled. Tracing logs the progress
	 * of parsing to the console, which may be of use in diagnosing problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option.
	 * </p>
	 * 
	 * @param b
	 *            whether evaluation tracing is enabled
	 * 
	 * @see #isEvaluationTracingEnabled()
	 */
	public void setEvaluationTracingEnabled(boolean b) {
		traceEvaluation = b;

		if (environmentFactory instanceof AbstractEnvironmentFactory) {
			AbstractEnvironmentFactory abstractFactory = (AbstractEnvironmentFactory) environmentFactory;

			abstractFactory.setEvaluationTracingEnabled(traceEvaluation);
		}
	}

	/**
	 * Assigns a custom extent map to define the extents of classes in
	 * evaluation of OCL constraints. This is only needed if the default dynamic
	 * extent-map implementation is not suitable.
	 * 
	 * @param modelManager
	 *            a custom extent map, or <code>null</code> to use the default
	 *            dynamic extent map implementation
	 */
	public void setModelManager(DomainModelManager modelManager) {
		this.modelManager = modelManager;
	}

	/**
	 * <p>
	 * Sets the number of repairs to be made by the parser.
	 * </p>
	 * <p>
	 * The default zero value selects use of the deterministic parser, which
	 * terminates after one serious syntax error is detected.
	 * </p>
	 * <p>
	 * A non-zero value selects the backtracking parser. The backtracking parser
	 * may be about three times slower.
	 * </p>
	 * 
	 * @param parserRepairCount
	 *            whether evaluation tracing is enabled
	 * 
	 * @throws IllegalArgumentException
	 *             if the <tt>parserRepairCount</tt> is negative
	 * 
	 * @see #getParserRepairCount()
	 */
	public void setParserRepairCount(int parserRepairCount) {
		if (parserRepairCount < 0) {
			throw new IllegalArgumentException("negative repair count"); //$NON-NLS-1$
		}

		this.parserRepairCount = parserRepairCount;
	}

	/**
	 * Sets whether tracing of parsing is enabled. Tracing logs the progress of
	 * parsing to the console, which may be of use in diagnosing problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/parsing</tt> debug option.
	 * </p>
	 * 
	 * param b whether parsing tracing is enabled
	 * 
	 * @see #isParseTracingEnabled()
	 */
	public void setParseTracingEnabled(boolean b) {
		traceParsing = b;
	}

	/**
	 * Validates an OCL expression, which may have been loaded from some
	 * resource or constructed via the API (perhaps by translation from some
	 * other language).
	 * 
	 * @param expression
	 *            an expression to validate
	 * 
	 * @throws SemanticException
	 *             on detection of any well-formedness problem in the expression
	 * 
	 * @see #validate(Object)
	 */
	public void validate(OclExpression expression) throws SemanticException {
		throw new UnsupportedOperationException(getClass().getName() + ".validate");
		// clear out old diagnostics
/*		ProblemHandler ph = OCLUtil.getAdapter(rootEnvironment,
			ProblemHandler.class);
		if (ph != null) {
			ph.beginValidation();
		}

		expression.accept(ValidationVisitor.getInstance(rootEnvironment));

		if (ph != null) {
			ph.endValidation();

			try {
				OCLUtil.checkForErrors(ph);
			} catch (SyntaxException e) {
				// shouldn't actually be able to get this from validation
				throw new SemanticException(e.getDiagnostic());
			}
		} */
	}

	/**
	 * Validates an OCL constraint, which may have been loaded from some
	 * resource or constructed via the API (perhaps by translation from some
	 * other language).
	 * 
	 * @param constraint
	 *            a constraint to validate
	 * 
	 * @throws SemanticException
	 *             on detection of any well-formedness problem in the constraint
	 */
	public void validate(Constraint constraint) throws SemanticException {
		throw new UnsupportedOperationException(getClass().getName() + ".validate");
		// clear out old diagnostics
/*		ProblemHandler ph = OCLUtil.getAdapter(rootEnvironment,
			ProblemHandler.class);
		if (ph != null) {
			ph.beginValidation();
		}

		ValidationVisitor.getInstance(rootEnvironment).visitConstraint(
			constraint);

		if (ph != null) {
			ph.endValidation();

			try {
				OCLUtil.checkForErrors(ph);
			} catch (SyntaxException e) {
				// shouldn't actually be able to get this from validation
				throw new SemanticException(e.getDiagnostic());
			}
		} */
	}
}
