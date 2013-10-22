/**
 * <copyright>
 * 
 * Copyright (c) 2011,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 243079, 244948, 244886, 245619
 *   E.D.Willink - Bug 191689, 254919, 296409, 298634
 *   Obeo - Bug 291310
 *   E.D.Willink (CEA LIST) - Bug 388529
 *
 * </copyright>
 *
 * $Id: PivotTestSuite.java,v 1.9 2011/05/30 16:09:59 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import junit.framework.TestSuite;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.common.CodeGenHelper;
import org.eclipse.ocl.examples.codegen.dynamic.JavaGenModelCodeGenHelper;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryOperation;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.SemanticException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.context.ClassContext;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.manager.AbstractMetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.tests.TestCaseAppender;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;

/**
 * Default test framework.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public abstract class PivotTestSuite extends PivotTestCase
{
	// set this variable true when testing for memory leaks
    private static boolean DISPOSE_RESOURCE_SET = false;
//	protected static int testCounter = 0;

	public static final @NonNull String ORG_ECLIPSE_OCL_EXAMPLES_XTEXT_TESTRESULTS = "org.eclipse.ocl.examples.xtext.tests";
	
    public static final class CheckedTestSuite extends TestSuite {

		public CheckedTestSuite(String name) {
			super(name);
		}

		public void createTestSuite(Class<? extends PivotTestSuite> testClass, String testName) {
	        addTest(new TestSuite(testClass, testName));
		}

		public void addTestSuite(CheckedTestSuite suite) {
	        addTest(suite);
		}
	}
/*	private static final class TestCaseAppender extends ConsoleAppender {

		public TestCaseAppender() {
			super(new SimpleLayout(), SYSTEM_OUT); 
			setName("TestHarness");
		}
		
		@Override
		public void append(LoggingEvent event) {
			if (event.getLevel().isGreaterOrEqual(Level.INFO)) {
				String renderedMessage = event.getRenderedMessage();
				ThrowableInformation throwableInformation = event.getThrowableInformation();
				Throwable throwable = throwableInformation != null ? throwableInformation.getThrowable() : null;
				throw new Error(renderedMessage, throwable);
			}
//			super.append(event);
		}
	} */
	
//	protected static Logger rootLogger = Logger.getRootLogger();
//	protected static TestCaseAppender testCaseAppender = new TestCaseAppender();
//	{
//		rootLogger.addAppender(testCaseAppender);
//	}
    
	protected static boolean noDebug = false;
	protected static ResourceSet resourceSet;
	private static ArrayList<Resource> standardResources;
	protected static int testCounter = 0;

	private static boolean initialized = false;
	
	public static void debugPrintln(String string) {
		if (!noDebug) {
			System.out.println(string);
		}		
	}

	public static boolean eclipseIsRunning() {
		try {
			Class<?> platformClass = Class.forName("org.eclipse.core.runtime.Platform");
			Method isRunningMethod = platformClass.getDeclaredMethod("isRunning");
			return Boolean.TRUE.equals(isRunningMethod.invoke(null));
		} catch (Exception e) {
		}
		return false;
	}

	public static void initializeStandalone() {
		if (initialized)
			return;
		initialized = true;
	}

	protected MetaModelManager metaModelManager;
	protected IdResolver idResolver;
	protected OCL ocl;
	protected Environment environment;
	protected OCLHelper helper;
	protected final boolean useCodeGen;

	protected PivotTestSuite() {
		this.useCodeGen = false;
//		System.out.println(getName());
	}

	protected PivotTestSuite(boolean useCodeGen) {
		this.useCodeGen = useCodeGen;
	}
	
	public void addSupertype(@NonNull org.eclipse.ocl.examples.pivot.Class aClass, @NonNull org.eclipse.ocl.examples.pivot.Class superClass) {
		aClass.getSuperClass().add(superClass);
	}
    
	/**
	 * Assert that an expression cannot be used as an invariant, because an exception is thrown
	 * with a diagnostic of severity containing a message that is the result of messageTemplate
	 * resolved by bindings.
	 */
    @SuppressWarnings("null")
	protected void assertBadInvariant(@NonNull Class<?> exception, int severity,
    		@NonNull String expression, /*@NonNull*/ String messageTemplate, Object... bindings) {
		BaseResource resource = null;
        try {
    		PivotEnvironment environment = (PivotEnvironment) helper.getEnvironment();
    		MetaModelManager metaModelManager = environment.getMetaModelManager();
    		Type contextClassifier = environment.getContextClassifier();
    		ParserContext semanticContext = new ClassContext(metaModelManager, null, contextClassifier);
			resource = semanticContext.createBaseResource(expression);
			PivotUtil.checkResourceErrors(DomainUtil.bind(OCLMessages.ErrorsInResource, expression), resource);
            fail("Should not have parsed \"" + expression + "\"");
        } catch (ParserException e) {
        	assertEquals("Exception for \"" + expression + "\"", exception, e.getClass());
        	if (resource != null) {
        		Resource.Diagnostic diagnostic = getDiagnostic(resource);
    			assertNoException(diagnostic, ClassCastException.class);
            	assertNoException(diagnostic, NullPointerException.class);
//            	assertEquals("Severity for \"" + expression + "\"", severity, diagnostic.getSeverity());
            	String expectedMessage = DomainUtil.bind(messageTemplate, bindings);
            	assertEquals("Message for \"" + expression + "\"", expectedMessage, diagnostic.getMessage());
        	}
        } catch (IOException e) {
			fail(e.getMessage());
		} finally {
			if (resource != null) {
				AbstractMetaModelManagerResourceAdapter.disposeAll(resource);
			}
		}	   
    }
	 
	/**
	 * Assert that an expression cannot be used as a query, because an exception is thrown
	 * with a diagnostic of severity containing a message that is the result of messageTemplate
	 * resolved by bindings.
	 * @throws IOException 
	 */
    @SuppressWarnings("null")
	protected void assertBadQuery(@NonNull Class<?> exception, int severity,
    		@NonNull String expression, /*@NonNull*/ String messageTemplate, Object... bindings) {
		BaseCSResource csResource = null;
		try {
   		PivotEnvironment environment = (PivotEnvironment) helper.getEnvironment();
   		MetaModelManager metaModelManager = environment.getMetaModelManager();
   		Type contextClassifier = environment.getContextClassifier();
   		ParserContext classContext = new ClassContext(metaModelManager, null, contextClassifier);
   		csResource = (BaseCSResource) classContext.createBaseResource(expression);
			PivotUtil.checkResourceErrors(DomainUtil.bind(OCLMessages.ErrorsInResource, expression), csResource);
			CS2PivotResourceAdapter cs2pivot = csResource.getCS2ASAdapter(metaModelManager);
			Resource asResource = cs2pivot.getASResource(csResource);
			assertNoValidationErrors("Validating", asResource);
			
           fail("Should not have parsed \"" + expression + "\"");
       } catch (ParserException e) {
       	assertEquals("Exception for \"" + expression + "\"", exception, e.getClass());
       	Resource.Diagnostic diagnostic = getDiagnostic(csResource);
//			assertNoException(diagnostic, ClassCastException.class);
//       	assertNoException(diagnostic, NullPointerException.class);
//       	assertEquals("Severity for \"" + expression + "\"", severity, diagnostic.getSeverity());
       	String expectedMessage = DomainUtil.bind(messageTemplate, bindings);
       	assertEquals("Message for \"" + expression + "\"", expectedMessage, diagnostic.getMessage());
       } catch (IOException e) {
			fail(e.getMessage());
		} finally {
			if (csResource != null) {
				AbstractMetaModelManagerResourceAdapter.disposeAll(csResource);
			}
		}	   
	}
    @SuppressWarnings("null")
	protected void assertBadQuery2(@NonNull Class<?> exception, int severity, @Nullable Type contextType, @NonNull String expression, /*@NonNull*/ String messageTemplate, Object... bindings) {
		BaseCSResource csResource = null;
		try {
			OCLHelper helper = getHelper();
			helper.setContext(contextType);
			PivotEnvironment environment = (PivotEnvironment) helper.getEnvironment();
			MetaModelManager metaModelManager = environment.getMetaModelManager();
			Type contextClassifier = environment.getContextClassifier();
			ParserContext classContext = new ClassContext(metaModelManager, null, contextClassifier);
			csResource = (BaseCSResource) classContext.createBaseResource(expression);
			PivotUtil.checkResourceErrors(DomainUtil.bind(OCLMessages.ErrorsInResource, expression), csResource);
			CS2PivotResourceAdapter cs2pivot = csResource.getCS2ASAdapter(metaModelManager);
			Resource asResource = cs2pivot.getASResource(csResource);
			assertNoValidationErrors("Validating", asResource);
			
			fail("Should not have parsed \"" + expression + "\"");
		} catch (ParserException e) {
			assertEquals("Exception for \"" + expression + "\"", exception, e.getClass());
			Resource.Diagnostic diagnostic = getDiagnostic(csResource);
//			assertNoException(diagnostic, ClassCastException.class);
//       	assertNoException(diagnostic, NullPointerException.class);
//       	assertEquals("Severity for \"" + expression + "\"", severity, diagnostic.getSeverity());
			String expectedMessage = DomainUtil.bind(messageTemplate, bindings);
			assertEquals("Message for \"" + expression + "\"", expectedMessage, diagnostic.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		} finally {
			if (csResource != null) {
				AbstractMetaModelManagerResourceAdapter.disposeAll(csResource);
			}
		}	   
	}
	
	/**
	 * Assert that an expression can be parsed as an invariant for a context and return the invariant.
	 */
	protected @Nullable ExpressionInOCL assertInvariant(@NonNull Type context, @NonNull String expression) {
		getHelper().setContext(context);
		try {
			ExpressionInOCL result = getHelper().createInvariant(expression);
			return result;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that an expression evaluated as an invariant for a context returns false.
	 */
	protected @Nullable Object assertInvariantFalse(@Nullable Object context, @NonNull String expression) {
		try {
			Object value = check(getHelper(), context, expression);
			assertEquals(expression, false, value);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that an expression evaluated as an invariant for a context returns true.
	 */
	protected @Nullable Object assertInvariantTrue(@Nullable Object context, @NonNull String expression) {
		try {
			Object value = evaluate(getHelper(), context, expression);
			assertEquals(expression, true, value);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Asserts that a exception of the specified kind is not signalled by
	 * the a given diagnostic or (recursively) its children.
	 * 
	 * @param diagnostic a diagnostic
	 * @param excType an exception that must not be indicated by the diagnostic
	 */
    protected void assertNoException(Resource.Diagnostic diagnostic, java.lang.Class<? extends Throwable> excType) {
    	if (diagnostic instanceof ExceptionDiagnostic) {
	    	if (excType.isInstance(((ExceptionDiagnostic)diagnostic).getException())) {
	    		fail("Diagnostic signals a(n) " + excType.getSimpleName());
	    	}
	    	
//	    	for (Diagnostic nested : diagnostic.getChildren()) {
//	    		assertNoException(nested, excType);
//	    	}
    	}
    }
    
	/**
	 * Asserts that two objects are equal using OCL semantics. If they are not
	 * an AssertionFailedError is thrown with the given message.
	 */
	public void assertOCLEquals(String message, Object expected, Object actual) {
		if (idResolver.oclEquals(expected, actual))
			return;
		failNotEquals(message, expected, actual);
	}
	
	/**
	 * Asserts that the specified choice is <em>not</em> to be found in the
	 * collection of <code>choices</code>.
	 * 
	 * @param choices a collection of {@link Choice}s
	 * @param kind the kind of choice not to find
	 * @param name the name of the choice not to find
	 *
	protected void assertNotChoice(Collection<Choice> choices, ChoiceKind kind, String name) {
		assertNull("Choice found: " + name + ", " + kind, //$NON-NLS-2$
			findChoice(choices, kind, name));
	} */
	
	/**
	 * Assert that an expression can be parsed as a query for a context and return the query.
	 */
	@SuppressWarnings("null")
	protected @NonNull ExpressionInOCL assertQuery(Type context, @NonNull String expression) {
		getHelper().setContext(context);
		try {
			ExpressionInOCL result = getHelper().createQuery(expression);
			return result;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is not undefined.
	 * @return the evaluation result
	 */
	protected Object assertQueryDefined(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(getHelper(), context, expression);
			assertFalse(expression + " expected defined: ", value == null);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is equal to expected.
	 * @return the evaluation result
	 */
	protected @Nullable Object assertQueryEquals(@Nullable Object context, @Nullable Object expected, @NonNull String expression) {
		try {
			Object expectedValue = expected instanceof Value ? expected : metaModelManager.getIdResolver().boxedValueOf(expected);
//			typeManager.addLockedElement(expectedValue.getType());
			Object value = evaluate(getHelper(), context, expression);
//			String expectedAsString = String.valueOf(expected);
//			String valueAsString = String.valueOf(value);
			assertOCLEquals(expression, expectedValue, value);
			// FIXME Following is probably redundant
			if (expectedValue instanceof OrderedSetValue) {
				assertTrue(expression, value instanceof OrderedSetValue);
				Iterator<?> es = ((OrderedSetValue)expectedValue).iterator();
				@SuppressWarnings("null")
				Iterator<?> vs = ((OrderedSetValue)value).iterator();
				while (es.hasNext()) {
					Object e = es.next();
					Object v = vs.next();
					assertEquals(expression, e, v);
				}
			}
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is equal to expected.
	 * @return the evaluation result
	 */
	@SuppressWarnings("null")
	protected @Nullable Object assertQueryEquals(@Nullable Object context, @NonNull BigDecimal expected, @NonNull BigDecimal delta, @NonNull String expression) {
		try {
			BigDecimal value = (BigDecimal) evaluate(getHelper(), context, expression);
			assertTrue(expression, (value.compareTo(expected.add(delta)) >= 0) && (value.compareTo(expected.subtract(delta)) >= 0));
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is equal to expected.
	 * @return the evaluation result
	 */
	protected Object assertQueryEquals(Object context, @NonNull Number expected, @NonNull String expression, double tolerance) {
		try {
			Object expectedValue = idResolver.boxedValueOf(expected);
			Object value = evaluate(getHelper(), context, expression);
			@SuppressWarnings("null")
			BigDecimal expectedVal = ((RealValue)expectedValue).bigDecimalValue();
			@SuppressWarnings("null")
			BigDecimal val = ((RealValue)value).bigDecimalValue();
			double delta = val.subtract(expectedVal).doubleValue();
			if ((delta < -tolerance) || (tolerance < delta)) {
				assertEquals(expression, expected, value);
			}
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is the same as expected.
	 */
	protected Object assertQueryEvaluate(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(getHelper(), context, expression);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is false.
	 * @return the evaluation result
	 */
	protected Object assertQueryFalse(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(getHelper(), context, expression);
			assertEquals(expression, Boolean.FALSE, value);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is invalid.
	 * @return the evaluation result
	 */
	protected Value assertQueryInvalid(Object context, @NonNull String expression) {
		try {
			Object value = evaluateWithoutValidation(getHelper(), context, expression);
			fail(expression + " expected: invalid but was: " + value);
		} catch (InvalidValueException e) {		// OCL invalid is always an InvalidValueException
		} catch (Exception e) {					// Something else is nasty
			failOn(expression, e);
		}
		return null;
	}

	protected Object assertQueryInvalid(Object context, @NonNull String expression, String reason, Class<?> exceptionClass) {
		try {
			Object value = evaluateWithoutValidation(getHelper(), context, expression);
//			if (!ValuesUtil.isInvalid(value)) {
				fail(expression + " expected: invalid but was: " + value);
//			}
//			InvalidValue invalidValue = (InvalidValue)value;
//           fail("Expected invalid for \"" + expression + "\"");
		} catch (InvalidValueException e) {
			Throwable ex = e;
			Throwable cause = e.getCause();
//			Exception cause = invalidValue.getException();
//			Throwable ex = cause;
			String message = e.getMessage();
			if (cause != null) {
				ex = cause;
				if (!(cause instanceof NumberFormatException)) {
					String m = ex.getMessage();
					if (m != null) {
						message = m;
					}
				}
			}
			if (reason != null) {
				assertEquals("Invalid Value Reason", reason, message);
			}
			if (exceptionClass != null) {
				assertEquals("Invalid Value Throwable", exceptionClass, ex.getClass());
			}
		} catch (Exception e) {
			if ((exceptionClass != null) && (exceptionClass != e.getClass())) {
				assertEquals("Invalid Value Throwable", exceptionClass, e.getClass() + " : " + e.getMessage());
			}
			if (reason != null) {
				assertEquals("Invalid Value Reason", reason, e.getMessage());
			}
//			failOn(expression, e);
		}
		return null;
	}

	/**
	 * Assert that the result of evaluating an expression as a query is not null.
	 * @return the evaluation result
	 */
	protected Object assertQueryNotJavaNull(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(getHelper(), context, expression);
			assertNotNull(expression, value);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}
	
	/**
	 * Assert that the result of evaluating an expression as a query is not the same as expected.
	 * @return the evaluation result
	 */
	protected Object assertQueryNotSame(Object context, Object expected, @NonNull String expression) {
		try {
			Object value = evaluate(getHelper(), context, expression);
			assertNotSame(expression, expected, value);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is OCL null.
	 * @return the evaluation result
	 */
	protected Object assertQueryNull(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(getHelper(), context, expression);
			assertEquals(expression, null, value);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Creates a query given the expression that is to be evaluated, then
	 * asserts its result is equal to the evaluation of the given
	 * <code>expectedResultExpression</code>.
	 * <p>
	 * If either the expected result or the expression result is a double, we'll
	 * compare the two with a margin of 0.001.
	 * </p>
	 * 
	 * @param expectedResult
	 *            Object with which the query's result is to be compared.
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	protected Object assertQueryResults(Object context, @NonNull String expectedResultExpression, @NonNull String expression) {
		try {
			Object expectedResultQuery = evaluateLocal(getHelper(), context, expectedResultExpression);
			Object result = assertQueryEquals(context, expectedResultQuery, expression);
			return result;
		} catch (Exception e) {
			failOn(expectedResultExpression, e);
			return null;
		}
	}
	/**
	 * Creates a query given the expression that is to be evaluated, then
	 * asserts its result contains all elements included in
	 * <code>expectedResult</code>.
	 * 
	 * @param expectedResult
	 *            Collection with which the query's result is to be compared.
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	@SuppressWarnings("null")
	protected Object assertResultContainsAll(Object context, @NonNull CollectionValue expectedResult, @NonNull String expression) {
		try {
			Object result = evaluate(getHelper(), context, expression);
			assertTrue(expectedResult.getClass().isInstance(result));
			assertSame(expectedResult.intSize(), ((CollectionValue) result).intSize());
			Object actualResult = ((CollectionValue) result).includesAll(expectedResult);
			assertTrue("Expected " + result + " to contain " + expectedResult, actualResult == ValuesUtil.TRUE_VALUE);
			return result;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Creates a query given the expression that is to be evaluated, then
	 * asserts its result contains all elements included in
	 * <code>expectedResult</code>.
	 * 
	 * @param expectedResultExpression
	 *            Expression which is to be evaluated to determine the expected
	 *            result.
	 * @param expression
	 *            Expression that is to be evaluated. Note that we'll use
	 *            {@link EClass} as this expression's context.
	 */
	protected Object assertResultContainsAll(Object context, @NonNull String expectedResultExpression, @NonNull String expression) {
		try {
			Object expectedResultQuery = evaluateLocal(getHelper(), null, expectedResultExpression);
			assertTrue(expectedResultQuery instanceof CollectionValue);
			@SuppressWarnings("null")
			Object result = assertResultContainsAll(context, (CollectionValue) expectedResultQuery, expression);
			return result;
		} catch (Exception e) {
			failOn(expectedResultExpression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is the same as expected.
	 * @return the evaluation result
	 *
	protected Object assertQuerySame(Object context, Object expected, String expression) {
		try {
			Object value = evaluate(getHelper(), context, expression);
			assertSame(expression, expected, value);
			return value;
		} catch (ParserException e) {
            fail("Failed to parse or evaluate \"" + expression + "\": " + e.getLocalizedMessage());
			return null;
		}
	} */

	/**
	 * Assert that the result of evaluating an expression as a query is true.
	 * @return the evaluation result
	 */
	protected Object assertQueryTrue(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(getHelper(), context, expression);
			assertEquals(expression, Boolean.TRUE, value);
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}

	/**
	 * Assert that the result of evaluating an expression as a query is an unlimited value.
	 * @return the evaluation result
	 */
	protected Object assertQueryUnlimited(Object context, @NonNull String expression) {
		try {
			Object value = evaluate(getHelper(), context, expression);
			if (!ValuesUtil.isUnlimited(value)) {
				assertEquals(expression, ValuesUtil.UNLIMITED_VALUE, value);
			}
			return value;
		} catch (Exception e) {
			failOn(expression, e);
			return null;
		}
	}
    
    
	protected void assertSemanticErrorQuery(@NonNull String expression, String messageTemplate, Object... bindings) {
		assertBadQuery(SemanticException.class, Diagnostic.ERROR, expression, messageTemplate, bindings);	   
	}
	protected void assertSemanticErrorQuery2(@NonNull Type contextType, @NonNull String expression, String messageTemplate, Object... bindings) {
		assertBadQuery2(SemanticException.class, Diagnostic.ERROR, contextType, expression, messageTemplate, bindings);	   
	}
	 
	/**
	 * Assert that an expression cannot be used as a query, because an exception is thrown
	 * with a diagnostic of severity containing a message that is the result of messageTemplate
	 * resolved by bindings.
	 * @throws IOException 
	 */
   @SuppressWarnings("null")
   protected void assertValidationErrorQuery(@NonNull String expression, String messageTemplate, Object... bindings) {
		BaseCSResource csResource = null;
		try {
	   		PivotEnvironment environment = (PivotEnvironment) getHelper().getEnvironment();
	   		MetaModelManager metaModelManager = environment.getMetaModelManager();
	   		Type contextClassifier = environment.getContextClassifier();
	   		ParserContext classContext = new ClassContext(metaModelManager, null, contextClassifier);
	   		csResource = (BaseCSResource) classContext.createBaseResource(expression);
			PivotUtil.checkResourceErrors(DomainUtil.bind(OCLMessages.ErrorsInResource, expression), csResource);
			CS2PivotResourceAdapter cs2pivot = csResource.getCS2ASAdapter(metaModelManager);
			Resource asResource = cs2pivot.getASResource(csResource);
	       	String expectedMessage = DomainUtil.bind(messageTemplate, bindings);
			assertValidationDiagnostics("Validating", asResource, new String[] {expectedMessage});
		} catch (Exception e) {
			fail(e.getMessage());
		} finally {
			if (csResource != null) {
				AbstractMetaModelManagerResourceAdapter.disposeAll(csResource);
			}
		}	   
	}
   @SuppressWarnings("null")
   protected void assertValidationErrorQuery2(@Nullable Type contextType, @NonNull String expression, String messageTemplate, Object... bindings) {
		BaseCSResource csResource = null;
		try {
			OCLHelper helper = getHelper();
			helper.setContext(contextType);
	   		PivotEnvironment environment = (PivotEnvironment) helper.getEnvironment();
	   		MetaModelManager metaModelManager = environment.getMetaModelManager();
	   		Type contextClassifier = environment.getContextClassifier();
	   		ParserContext classContext = new ClassContext(metaModelManager, null, contextClassifier);
	   		csResource = (BaseCSResource) classContext.createBaseResource(expression);
			PivotUtil.checkResourceErrors(DomainUtil.bind(OCLMessages.ErrorsInResource, expression), csResource);
			CS2PivotResourceAdapter cs2pivot = csResource.getCS2ASAdapter(metaModelManager);
			Resource asResource = cs2pivot.getASResource(csResource);
	       	String expectedMessage = DomainUtil.bind(messageTemplate, bindings);
			assertValidationDiagnostics("Validating", asResource, new String[] {expectedMessage});
		} catch (Exception e) {
			fail(e.getMessage());
		} finally {
			if (csResource != null) {
				AbstractMetaModelManagerResourceAdapter.disposeAll(csResource);
			}
		}	   
	}

   	/**
   	 * Assert that the expression is free of syntactic and semantic errors when parsed
   	 * for evaluation on an object of contextType. No evaluation is performed since no
   	 * object of contextType need exist. 
   	 */
	protected void assertValidQuery(@NonNull Type contextType, @NonNull String expression) throws Exception {
		OCLHelper helper = getHelper();
		helper.setContext(contextType);
		ExpressionInOCL query = helper.createQuery(expression);
		assertNoValidationErrors(expression, query);
	}

	/**
	 * Asserts that the <code>toString</code> representation of an AST node as
	 * generated by the toString visitor does not throw a run-time exception
	 * and is not <code>null</code>.
	 * 
	 * @param node a visitable AST node
	 */
	protected void assertValidToString(@NonNull Visitable node) {
		try {
			String toString = node.toString();
			assertNotNull("ToStringVisitorImpl returned null", toString);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail("ToStringVisitorImpl threw an exception: " + e.getLocalizedMessage());
		}
	}
	
/*	protected boolean check(@NonNull String contextFreeExpression) {
		boolean result = false;
		
		try {
			String document = "package uml context String" +
					" inv: " + contextFreeExpression + " endpackage";
			ExpressionInOCL expr = parse(document);
			
			result = check(expr, "");
		} catch (Exception e) {
			fail("Check failed: " + e.getLocalizedMessage());
		}
		
		return result;
	} */
    
    protected boolean check(@NonNull OCLHelper aHelper, Object context,
    		@NonNull String expression) throws ParserException {
        
    	ExpressionInOCL constraint = aHelper.createInvariant(expression);
//		DomainStandardLibrary stdlib = ocl.getEnvironment().getOCLStandardLibrary();
		if (constraint.getBodyExpression().getType() != metaModelManager.getBooleanType()) {
			throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
		}
		try {
			Object result = evaluate(constraint, context);
			return result == ValuesUtil.TRUE_VALUE;
		} catch (Exception e) {
			return false;
		}
	}
	
/*	protected boolean check(@NonNull ExpressionInOCL expr, Object self) {
		boolean result = false;
		
		try {
			result = ocl.check(self, expr);
		} catch (RuntimeException e) {
			fail("Check failed: " + e.getLocalizedMessage());
		}
		
		return result;
	} */
 	
	/**
	 * This can be called by subclasses to provide a meaningful error message
	 * when the tests are run with an encoding distinct from UTF-8.
	 */
	protected void checkForUTF8Encoding() {
		String testCharacter = "´";
		int length = testCharacter.length();
		if ((length != 1) || (testCharacter.charAt(0) != 0xB4)) {
			StringBuilder s = new StringBuilder();
			s.append("The Resource text file encoding should be set to UTF-8: test character was");
			for (int i = 0; i < length; i++){
				s.append(" ");
				s.append(Integer.toHexString(testCharacter.charAt(i)));
			}
			s.append(" rather than B4");
			fail(s.toString());
		}
	}

	@SuppressWarnings("null")
	protected @NonNull ExpressionInOCL createBodyCondition(@NonNull Operation context, @NonNull String text) {
		OCLHelper helper = ocl.createOCLHelper();
		helper.setOperationContext(context.getOwningType(), context);
		
		ExpressionInOCL result = null;
		
		try {
			result = helper.createBodyCondition(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}

	public org.eclipse.ocl.examples.pivot.Class createClass() {
		return PivotFactory.eINSTANCE.createClass();
	}

	/**
	 * Return an isOrdered,isUnique collection containing args.
	 *
	protected @NonNull CollectionValue createCollection(boolean isOrdered, boolean isUnique, @NonNull TypeId typeId, @NonNull Object... args) {
		return ValuesUtil.createCollectionOfEach(isOrdered, isUnique, typeId, args);
	} */

	public Comment createComment() {
		return PivotFactory.eINSTANCE.createComment();
	}

	protected void createDocument(String text) {
		throw new UnsupportedOperationException();
//		try {
//			ocl.parse(new OCLInput(text));
//        } catch (Exception e) {
//            fail("Failed to parse: " + e.getLocalizedMessage());
//        }
	}

	public void createGeneralization(Type special, Type general) {
		special.getSuperClass().add(general);
	}

	protected @NonNull OCLHelper createHelper() {
		return ocl.createOCLHelper();
	}
	
	protected ExpressionInOCL createInvariant(@NonNull Type context, @NonNull String expression) {
		return assertInvariant(context, expression);
	}

	protected Property createOwnedAttribute(org.eclipse.ocl.examples.pivot.Class aClass, String name, Type type) {
		Property eAttribute = PivotFactory.eINSTANCE.createProperty();
		eAttribute.setName(name);
		eAttribute.setType(type);
		aClass.getOwnedAttribute().add(eAttribute);
		return eAttribute;
	}

	protected @NonNull org.eclipse.ocl.examples.pivot.Class createOwnedClass(org.eclipse.ocl.examples.pivot.Package aPackage, String name, boolean isAbstract) {
		org.eclipse.ocl.examples.pivot.Class eClass = PivotFactory.eINSTANCE.createClass();
		eClass.setName(name);
		eClass.setIsAbstract(isAbstract);
		aPackage.getOwnedType().add(eClass);
		return eClass;
	}

	protected Enumeration createOwnedEnumeration(org.eclipse.ocl.examples.pivot.Package aPackage, String name) {
		Enumeration eEnum = PivotFactory.eINSTANCE.createEnumeration();
		eEnum.setName(name);
		aPackage.getOwnedType().add(eEnum);
		return eEnum;
	}

	protected EnumerationLiteral createOwnedLiteral(Enumeration anEnumeration, String name) {
		EnumerationLiteral eLiteral = PivotFactory.eINSTANCE.createEnumerationLiteral();
		eLiteral.setName(name);
		anEnumeration.getOwnedLiteral().add(eLiteral);
		return eLiteral;
	}

	protected Operation createOwnedOperation(Type aClass, String name, List<String> paramNames, List<Type> paramTypes, Type type, boolean isQuery) {
		Operation eOperation = PivotFactory.eINSTANCE.createOperation();
		eOperation.setName(name);
		eOperation.setType(type);
		if (paramNames != null) {
			for (int i = 0; i < paramNames.size(); i++) {
				createOwnedParameter(eOperation, paramNames.get(i), paramTypes.get(i));
			}
		}
		aClass.getOwnedOperation().add(eOperation);
		return eOperation;
	}

	protected Parameter createOwnedParameter(Operation eOperation, String name, Type type) {
		Parameter eParameter = PivotFactory.eINSTANCE.createParameter();
		eParameter.setName(name);
		eParameter.setType(type);
		eOperation.getOwnedParameter().add(eParameter);
		return eParameter;
	}

	protected Operation createOwnedPrimitiveOperation(Type aPrimitiveType, String name, EList<String> paramNames, EList<Type> paramTypes, Type type, boolean isQuery) {
		return createOwnedOperation(aPrimitiveType, name, paramNames, paramTypes, type, isQuery);
	}

	protected org.eclipse.ocl.examples.pivot.Class createOwnedPrimitiveType(org.eclipse.ocl.examples.pivot.Package aPackage, String name) {
		org.eclipse.ocl.examples.pivot.Class eClass = PivotFactory.eINSTANCE.createClass();
		eClass.setName(name);
		aPackage.getOwnedType().add(eClass);
		return eClass;
	}

	protected Property createOwnedReference(org.eclipse.ocl.examples.pivot.Class aClass, String name, org.eclipse.ocl.examples.pivot.Class type) {
		Property eReference = PivotFactory.eINSTANCE.createProperty();
		eReference.setName(name);
		eReference.setType(type);
		aClass.getOwnedAttribute().add(eReference);
		return eReference;
	}

	protected OCL createOCL() {
		Registry packageRegistry = resourceSet.getPackageRegistry();
		PivotEnvironmentFactory envFactory = new PivotEnvironmentFactory(packageRegistry, metaModelManager);
		return OCL.newInstance(envFactory);
	}

	protected @NonNull org.eclipse.ocl.examples.pivot.Package createPackage(@NonNull Root parentRoot, @NonNull String name) {
		@SuppressWarnings("null")
		org.eclipse.ocl.examples.pivot.Package aPackage = metaModelManager.createPackage(org.eclipse.ocl.examples.pivot.Package.class, PivotPackage.Literals.PACKAGE, name, null);
		parentRoot.getNestedPackage().add(aPackage);
		return aPackage;
	}

	protected @NonNull org.eclipse.ocl.examples.pivot.Package createPackage(@NonNull org.eclipse.ocl.examples.pivot.Package parentPackage, @NonNull String name) {
		@SuppressWarnings("null")
		org.eclipse.ocl.examples.pivot.Package aPackage = metaModelManager.createPackage(org.eclipse.ocl.examples.pivot.Package.class, PivotPackage.Literals.PACKAGE, name, null);
		parentPackage.getNestedPackage().add(aPackage);
		return aPackage;
	}
	
	@SuppressWarnings("null")
	protected @NonNull ExpressionInOCL createPostcondition(@NonNull Operation context, @NonNull String text) {
		OCLHelper helper = ocl.createOCLHelper();
		helper.setOperationContext(context.getOwningType(), context);
		
		ExpressionInOCL result = null;
		
		try {
			return helper.createPostcondition(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	@SuppressWarnings("null")
	protected @NonNull ExpressionInOCL createPrecondition(@NonNull Operation context, @NonNull String text) {
		OCLHelper helper = ocl.createOCLHelper();
		helper.setOperationContext(context.getOwningType(), context);
		
		ExpressionInOCL result = null;
		
		try {
			result = helper.createPrecondition(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	protected @NonNull ExpressionInOCL createQuery(@NonNull org.eclipse.ocl.examples.pivot.Class context, @NonNull String expression) {
		return assertQuery(context, expression);
	}
	
	@SuppressWarnings("null")
	protected @NonNull ExpressionInOCL createQuery(
			@NonNull EnvironmentFactory envFactory,
			@NonNull Type context, @NonNull String text) {
		
		OCL localOcl = OCL.newInstance(envFactory);
		OCLHelper helper = localOcl.createOCLHelper();
		helper.setContext(context);
		
		ExpressionInOCL result = null;
		
		try {
			result = helper.createQuery(text);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	public @NonNull ResourceSet createResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			"ecore", new EcoreResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(PivotPackage.eINSTANCE.getNsURI(), PivotPackage.eINSTANCE);
		return resourceSet;
	}

	protected @NonNull Root createRoot(@NonNull String name) {
		Root aRoot = metaModelManager.createRoot(name, null);
		return aRoot;
	}

	@SuppressWarnings("null")
	protected void createVariableInEnvironment(@NonNull String name, @NonNull Type type) {
		Variable var = environment.getOCLFactory().createVariable();
        var.setName(name);
        var.setType(type);
        environment.addElement(var.getName(), var, true);
	}
	
	protected void disposeResourceSet() {
        for (Resource res : resourceSet.getResources()) {
            res.unload();
            res.eAdapters().clear();
        }
        resourceSet.getResources().clear();
        resourceSet.eAdapters().clear();
        resourceSet = null;
		standardResources = null;
	}
	
	protected @Nullable Object evaluate(@NonNull String contextFreeExpression) {
		Object result = null;
		
		try {
			String document = "package uml context String" +
					" inv: " + contextFreeExpression +" endpackage";
			ExpressionInOCL expr = parse(document);
			
			result = evaluate(expr, "");
		} catch (Exception e) {
			fail("Evaluation failed: " + e.getLocalizedMessage());
		}
		
		return result;
	}

	protected @Nullable Object evaluate(@NonNull OCLHelper aHelper, @Nullable Object context, @NonNull String expression) throws Exception {
		Type contextType = metaModelManager.getType(idResolver.getStaticTypeOf(context));
		aHelper.setContext(contextType);
		ExpressionInOCL query = aHelper.createQuery(expression);
		assertNoValidationErrors(expression, query);
        try {
        	return evaluate(query, context);
		} finally {
			metaModelManager.getASResourceSet().getResources().remove(query.eResource());
		}
    }

	protected @Nullable Object evaluateWithoutValidation(@NonNull OCLHelper aHelper, @Nullable Object context, @NonNull String expression) throws Exception {
		Type contextType = metaModelManager.getType(idResolver.getStaticTypeOf(context));
		aHelper.setContext(contextType);
		ExpressionInOCL query = aHelper.createQuery(expression);
        try {
        	return evaluate(query, context);
		} finally {
			metaModelManager.getASResourceSet().getResources().remove(query.eResource());
		}
    }

	protected @Nullable Object evaluateLocal(@NonNull OCLHelper aHelper, @Nullable Object context, @NonNull String expression) throws Exception {
		Type contextType = metaModelManager.getType(idResolver.getStaticTypeOf(context));
		aHelper.setContext(contextType);
		ExpressionInOCL query = aHelper.createQuery(expression);
        try {
    		return ocl.evaluate(context, query);
		} finally {
			metaModelManager.getASResourceSet().getResources().remove(query.eResource());
		}
    }
	
/*	@Deprecated
	protected Object evaluate(ExpressionInOCL expr) {
		try {
			return evaluate(expr, null);
		} catch (Exception e) {
			fail("Evaluation failed: " + e.getLocalizedMessage());
			return null;
		}
	} */
    
	protected @Nullable Object evaluate(@NonNull ExpressionInOCL expr, @Nullable Object self) throws Exception {
		Object result = null;
		
//		try {
			if (!useCodeGen) {
				result = ocl.evaluate(self, expr);
			}
			else {
				ProjectMap projectMap = getProjectMap();
				projectMap.initializeResourceSet(resourceSet);
				resourceSet.getPackageRegistry().put(org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eNS_URI, org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eINSTANCE);
				resourceSet.getPackageRegistry().put(org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage.eNS_URI, org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage.eINSTANCE);

				@SuppressWarnings("null")
				CodeGenHelper genModelHelper = getCodeGenHelper(metaModelManager);

				File targetFolder = new File("../" + ORG_ECLIPSE_OCL_EXAMPLES_XTEXT_TESTRESULTS + "/src-gen");
				targetFolder.mkdir();
				String packageName = getTestPackageName();			// FIXME need to create this
				String className = "TestClass" + testCounter++;
				File dir = new File(targetFolder, packageName);
				dir.mkdir();
				LibraryOperation testInstance = genModelHelper.loadClass(expr, targetFolder, packageName, className, true);
				DomainEvaluator evaluator = new EcoreExecutorManager(self, PivotTables.LIBRARY);
				OperationCallExp callExp = PivotFactory.eINSTANCE.createOperationCallExp();
				callExp.setType(expr.getType());
				result = testInstance.evaluate(evaluator, callExp, self);
			}
//		} catch (Exception e) {
//			fail("Evaluation failed: " + e.getLocalizedMessage());
//		}
		
		return result;
	}
	
	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '<em><b>Attribute</b></em>' reference list.
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @param type The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or <code>null</code>.
	 */
	protected Property getAttribute(@NonNull Type classifier, @NonNull String name, @NonNull Type type) {
		Property feature = DomainUtil.getNamedElement(classifier.getOwnedAttribute(), name);
		if (feature == null)
			return null;
		// check type
		return feature;
	}

	@SuppressWarnings("null")
	public CodeGenHelper getCodeGenHelper(@NonNull MetaModelManager metaModelManager) throws IOException {
		URI genModelURI = URI.createPlatformResourceURI(
				"/org.eclipse.ocl.examples.pivot/model/Pivot.merged.genmodel",
				true);
//		ResourceSet resourceSet = getResourceSet();
		Resource genModelResource = resourceSet.getResource(genModelURI, true);
		String errorsString = PivotUtil.formatResourceDiagnostics(
				genModelResource.getErrors(), "Loading " + genModelURI, "\n");
		if (errorsString != null) {
			// issues.addError(this, errorsString, null, null, null);
			return null;
		}
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
		return new JavaGenModelCodeGenHelper(genModel, metaModelManager);
//		return new GenModelCodeGenHelper(genModel, metaModelManager);
	}
   
    /**
     * Obtains the diagnostic describing the problem in the last failed parse,
     * asserting that it is not <code>null</code>.
     * 
     * @return the diagnostic
     */
    protected Resource.Diagnostic getDiagnostic(@NonNull Resource resource) {
    	org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic = resource.getErrors().get(0);
		return diagnostic;
    }

    protected @NonNull Value getEmptyBagValue() {
		return idResolver.createBagOfEach(TypeId.BAG.getSpecializedId(TypeId.OCL_VOID));
	}

	protected @NonNull Value getEmptyOrderedSetValue() {
		return idResolver.createOrderedSetOfEach(TypeId.ORDERED_SET.getSpecializedId(TypeId.OCL_VOID));
	}

	protected @NonNull Value getEmptySequenceValue() {
		return idResolver.createSequenceOfEach(TypeId.SEQUENCE.getSpecializedId(TypeId.OCL_VOID));
	}

	protected @NonNull Value getEmptySetValue() {
		return idResolver.createSetOfEach(TypeId.SET.getSpecializedId(TypeId.OCL_VOID));
	}

	protected @NonNull OCLHelper getHelper() {
		return DomainUtil.nonNullState(helper);
	}

	public @NonNull Metaclass<?> getMetaclass(@NonNull Type type) {
		Metaclass<?> metaclass = metaModelManager.getMetaclass(type);
		metaModelManager.addLockedElement(metaclass);
		return metaclass;
	}
   
	protected @NonNull Type getMetaclass(@NonNull String name) {
		return metaModelManager.getRequiredLibraryType(name);
	}
	
	protected Object getNull() {
		return null;
	}

	protected @NonNull OCL getOCL() {
		return DomainUtil.nonNullState(ocl);
	}
	
	protected @NonNull DomainStandardLibrary getOCLStandardLibrary() {
		return ocl.getEnvironment().getOCLStandardLibrary();
	}

	protected @NonNull String getTestPackageName() {
		return "test_package";
	}
	
	protected @NonNull DomainType getUMLBoolean() {
		return getOCLStandardLibrary().getBooleanType();
	}
	
	protected @NonNull DomainType getUMLInteger() {
		return getOCLStandardLibrary().getIntegerType();
	}

	protected @NonNull DomainPackage getUMLMetamodel() {
		return DomainUtil.nonNullState(metaModelManager.getASMetamodel());
	}
	
	protected @NonNull DomainType getUMLString() {
		return getOCLStandardLibrary().getStringType();
	}
	
	protected @NonNull DomainType getUMLUnlimitedNatural() {
		return getOCLStandardLibrary().getUnlimitedNaturalType();
	}

	protected void initializeResourceSet() {
	    resourceSet = createResourceSet();
		standardResources = new ArrayList<Resource>(resourceSet.getResources());
	}
	
	@SuppressWarnings("null")
	public void loadEPackage(@NonNull String alias, /*@NonNull*/ EPackage ePackage) {		
		Element ecoreElement = Ecore2Pivot.importFromEcore(metaModelManager, alias, ePackage);
		metaModelManager.addGlobalNamespace(alias, (Namespace) ecoreElement);
	}
	
	/**
	 * Parses the specified <code>text</code>.
	 * 
	 * @param text the OCL text
	 * @return the OCL expression
	 */
	protected @NonNull ExpressionInOCL parse(@NonNull String text) {
		ExpressionInOCL result = parseUnvalidated(text);
		validate(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	/**
	 * Parses the specified <code>text</code> as an OCL constraint.
	 * 
	 * @param text the OCL text
	 * @return the OCL constraint expression
	 */
	protected @NonNull ExpressionInOCL parseConstraint(@NonNull String text) {
		ExpressionInOCL result = parseConstraintUnvalidated(text);
		validate(result);
		
		assertValidToString(result);
		
		return result;
	}
	
	/**
	 * Parses the specified <code>text</code> as an OCL constraint, without
	 * validating it.
	 * 
	 * @param text the OCL text
	 * @return the OCL constraint expression, unvalidated
	 */
	protected @NonNull ExpressionInOCL parseConstraintUnvalidated(@NonNull String text) {
		throw new UnsupportedOperationException();
/*		List<Constraint> constraints;
		Constraint constraint = null;
		
		try {
			constraints = ocl.parse(new OCLInput(text));
			constraint = constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		} catch (IllegalArgumentException e) {
			fail("Parse failed (illegal argument): " + e.getLocalizedMessage());
		}
		
		ExpressionInOCL result = null;
		result = (ExpressionInOCL) constraint.getSpecification();
		
		assertNotNull(result);
		
		assertValidToString(result);
		
		return result; */
	}
	
	/**
	 * Parses the specified <code>text</code> as a def expression.  This differs
	 * from the {@link #parse} method in not separating the expression from its
	 * constraint, which is critically important to the structure of the defined
	 * feature.
	 * 
	 * @param env the environment in which the operation or property is to be defined
	 * @param text the OCL text
	 * @return the OCL def expression
	 */
	protected @NonNull ExpressionInOCL parseDef(@NonNull String text) {
		throw new UnsupportedOperationException();
/*		List<Constraint> constraints ;
		Constraint constraint = null;
		
		try {
			constraints = ocl.parse(new OCLInput(text));
			constraint = constraints.get(0);
		} catch (ParserException e) {
			fail("Parse failed: " + e.getLocalizedMessage());
		} catch (IllegalArgumentException e) {
			fail("Parse failed (illegal argument): " + e.getLocalizedMessage());
		}
		
		ExpressionInOCL result = (ExpressionInOCL) constraint.getSpecification();		
		assertNotNull(result);
		validate(result);		
		assertValidToString(result);		
		return result; */
	}

	/**
	 * Parses the specified <code>text</code> without validating it.
	 * 
	 * @param text the OCL text
	 *    
	 * @return the OCL expression, unvalidated
	 */
	protected @NonNull ExpressionInOCL parseUnvalidated(@NonNull String text) {
		ExpressionInOCL result = parseConstraintUnvalidated(text);
		
		// forget the constraint because it interferes with validation
		EcoreUtil.remove(result);
		
		assertValidToString(result);
		
		return result;
	}

	/**
	 * Create a Resource to register a binding-dependent pkg for access with a given nsPrefix and nsUri.
	 */
	protected @NonNull org.eclipse.ocl.examples.pivot.Package registerPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pkg, @NonNull String nsPrefix, @NonNull String nsUri) {
		pkg.setNsPrefix(nsPrefix);
        pkg.setNsURI(nsUri);
		Resource resource = new ResourceImpl(URI.createURI(nsUri));
        resource.getContents().add(pkg);
        resourceSet.getResources().add(resource);					// FIXME UML needs this
        resourceSet.getPackageRegistry().put(nsUri, pkg);			//  whereas Ecore needs this
        return pkg;
	}
	
	public static void resetCounter() throws Exception {
        testCounter = 0;
    }
	
	@SuppressWarnings("null")
	@Override
    protected void setUp() throws Exception {
		super.setUp();
		TestCaseAppender.INSTANCE.install();
 		OCLstdlib.install();
 		doEssentialOCLSetup();
		metaModelManager = new MetaModelManager();
		idResolver = metaModelManager.getIdResolver();
		if ((resourceSet != null) && DISPOSE_RESOURCE_SET) {
        	disposeResourceSet();
        }
		if (!initialized) {
			noDebug = System.getProperty(PLUGIN_ID + ".nodebug") != null;
			if (!eclipseIsRunning()) {
				initializeStandalone();
			}
		}		
		if (resourceSet == null) {
			initializeResourceSet();
		}
		MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
//		debugPrintln("==> Start  " + getName());
		ocl = createOCL();
		environment = ocl.getEnvironment();
//		reflection = staticReflection.createReflection(environment);
		String repairs = System.getProperty(PLUGIN_ID + ".repairs");
		if (repairs != null)
			ocl.setParserRepairCount(Integer.parseInt(repairs));
//        ocl.setParseTracingEnabled(true);
//        ocl.setEvaluationTracingEnabled(true);
		
		helper = createHelper();
	}

	@SuppressWarnings("null")
	@Override
    protected void tearDown() throws Exception {
		//
		//	Unload any resources that a test may have loaded.
		//
		for (ListIterator<Resource> i = resourceSet.getResources().listIterator(); i.hasNext(); ) {
			Resource res = i.next();
			if (!standardResources.contains(res)) {
				i.remove();
				res.unload();
                res.eAdapters().clear();
			}				
		}
		//
		//	Null out any references that a test may have left behind, so that unwanted
		//	objects are not locked into memory.
		//
		for (java.lang.Class<?> aClass = getClass(); PivotTestSuite.class.isAssignableFrom(aClass); aClass = aClass.getSuperclass()) {
			for (Field field : aClass.getDeclaredFields()) {
				int modifiers = field.getModifiers();
				if (Modifier.isFinal(modifiers)) {
				}
				else if (!Modifier.isStatic(modifiers)) {
					java.lang.Class<?> fieldType = field.getType();
					if (Object.class.isAssignableFrom(fieldType)) {
						String fieldName = field.getName();
						try {
							String tearDownName = "tearDown_" + fieldName;
							Method method = aClass.getDeclaredMethod(tearDownName);
							try {
								tearDownUsing(method);
							} catch (Exception e) {
								// tearDown_xxx must be public
								fail("Failed to invoke " + getClass().getSimpleName() + "." + tearDownName + " : " + e);  //$NON-NLS-2$//$NON-NLS-3$
							}
						}
						catch (NoSuchMethodException e) {
							try {
								tearDownField(field);
							} catch (Exception e1) {
								// xxx without a tearDown_xxx must be public to ensure that leakage can be stopped
								fail("Failed to set " + getClass().getSimpleName() + "." + fieldName + " to null : " + e1); //$NON-NLS-2$ //$NON-NLS-3$
							}
						}
					}
				} else {
					tearDownStatic(aClass, field);
				}
			}
		}
		unloadResourceSet(resourceSet);
		resourceSet = null;
		super.tearDown();
	}

	protected void tearDownField(@NonNull Field field) throws IllegalAccessException {
		field.set(this, null);
	}

	protected void tearDownStatic(@NonNull java.lang.Class<?> aClass, @NonNull Field field) {
		if (aClass != PivotTestSuite.class) {
			// Tests may not have statics since they are prone to memory leakage
			fail("static test variable:" + field); 
		}
	}

	protected void tearDownUsing(@NonNull Method method)
			throws IllegalAccessException, InvocationTargetException {
		method.invoke(this);
	}

	protected void tearDown_ocl() {
		if (ocl != null) {
			ocl.dispose();
			ocl = null;
		}
	}

	protected void tearDown_idResolver() {
		if (idResolver != null) {
			idResolver.dispose();
			idResolver = null;
		}
	}

	protected void tearDown_metaModelManager() {
		if (metaModelManager != null) {
			metaModelManager.dispose();
			metaModelManager = null;
		}
	}
    
    /**
     * Validates an OCL expression, asserting that it is valid.
     * 
     * @param expr the OCL expression to validate
     * @param env an environment to use for validation
     */
    protected void validate(@NonNull Constraint constraint) {
        try {
            ocl.validate(constraint);
        } catch (SemanticException e) {
            fail("Validation failed: " + e.getLocalizedMessage());
        }
    }
    
	/**
	 * Validates an OCL expression, asserting that it is valid.
	 * 
	 * @param expr the OCL expression to validate
	 * @param env an environment to use for validation
	 */
	@SuppressWarnings("null")
	protected void validate(@NonNull ExpressionInOCL expr) {
		try {
			EObject eContainer = expr.eContainer();
			if ((eContainer != null)
					&& Constraint.class.isAssignableFrom(eContainer.eContainer().getClass())) {
				// start validation from the constraint, for good measure
				Constraint eContainerContainer = (Constraint) eContainer.eContainer();
				validate(eContainerContainer);
			} else {
				ocl.validate(expr.getBodyExpression());
			}
		} catch (SemanticException e) {
			fail("Validation failed: " + e.getLocalizedMessage());
		}
	}
}
