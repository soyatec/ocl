/**
 * <copyright>
 *
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation
 *   E.D.Willink (CEA LIST) - 425799 Validity View Integration
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.validity.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.xpath.XPathExpressionException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.ui.export.util.TextExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Class testing the TextExport class.
 */
public class TextExportOCLValidationResultTests extends AbstractExportOCLValidationResultTests
{
	private static final int WARNING_NUMBER_XPATH_LOCATION = 15;
	private static final int INFO_NUMBER_XPATH_LOCATION = 14;
	private static final int ERROR_NUMBER_XPATH_LOCATION = 16;
	private static final int FAILURE_NUMBER_XPATH_LOCATION = 17;
	private static final int SUCCESS_NUMBER_XPATH_LOCATION = 13;

	private static final String EXPORTED_FILE_NAME = "testText.txt"; //$NON-NLS-1$

	protected void assertLineContains(int lineNumber, String expression) throws CoreException, IOException {
		InputStream contents = exportedFile.getContents();
		InputStream stream = contents;

		Scanner sc = new Scanner(stream);
		String line = null;
		int i = 1;
		while (i <= lineNumber) {
			line = sc.nextLine();
			i++;
		}
		if (line != null) {
			assertTrue("Expected \"" + line + "\" to contain \"" + expression + "\"", line.contains(expression));
		}
		sc.close();
		contents.close();
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		initExporter(TextExport.class);
		initProject(EXPORTED_FILE_NAME);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * 
	 * Tests that the exported file contains the expected log for metrics
	 * section.
	 * 
	 * @throws IOException
	 * @throws XPathExpressionException
	 * @throws CoreException
	 */
	@Test
	public void testTEXTExport_LoggingMetricsWithNoSeverity()
			throws IOException, XPathExpressionException, CoreException {
		// initiate the test case
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute5 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.OK);

		// launch the exporter
		assertFalse(exportedFile.exists());
		exporter.export(ecoreResource, rootNode, exportedFile.getFullPath());

		// test the exporteFile content
		assertLineContains(SUCCESS_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(INFO_NUMBER_XPATH_LOCATION, "0"); //$NON-NLS-1$
		assertLineContains(WARNING_NUMBER_XPATH_LOCATION, "0"); //$NON-NLS-1$
		assertLineContains(ERROR_NUMBER_XPATH_LOCATION, "0"); //$NON-NLS-1$
		assertLineContains(FAILURE_NUMBER_XPATH_LOCATION, "0"); //$NON-NLS-1$
	}

	/**
	 * Tests that the exported file contains the expected log for metrics
	 * section.
	 * 
	 * @throws IOException
	 * @throws XPathExpressionException
	 * @throws CoreException
	 */
	@Test
	public void testTEXTExport_LoggingMetricsWithInformationSeverity()
			throws IOException, XPathExpressionException, CoreException {
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute5 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.OK);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute3 : EShort") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.INFO);

		// launch the exporter
		assertFalse(exportedFile.exists());
		exporter.export(ecoreResource, rootNode, exportedFile.getFullPath());

		assertLineContains(SUCCESS_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(INFO_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(WARNING_NUMBER_XPATH_LOCATION, "0"); //$NON-NLS-1$
		assertLineContains(ERROR_NUMBER_XPATH_LOCATION, "0"); //$NON-NLS-1$
		assertLineContains(FAILURE_NUMBER_XPATH_LOCATION, "0"); //$NON-NLS-1$
	}

	/**
	 * Tests that the exported file contains the expected log for metrics
	 * section.
	 * 
	 * @throws IOException
	 * @throws XPathExpressionException
	 * @throws CoreException
	 */
	@Test
	public void testTEXTExport_LoggingMetricsWithWarningSeverity()
			throws IOException, InterruptedException, XPathExpressionException,
			CoreException {
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute5 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.OK);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute3 : EShort") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.INFO);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute1 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.WARNING);

		// launch the exporter
		assertFalse(exportedFile.exists());
		exporter.export(ecoreResource, rootNode, exportedFile.getFullPath());

		assertLineContains(SUCCESS_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(INFO_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(WARNING_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(ERROR_NUMBER_XPATH_LOCATION, "0"); //$NON-NLS-1$
		assertLineContains(FAILURE_NUMBER_XPATH_LOCATION, "0"); //$NON-NLS-1$
	}

	/**
	 * Tests that the exported file contains the expected log for metrics
	 * section.
	 * 
	 * @throws IOException
	 * @throws XPathExpressionException
	 * @throws CoreException
	 */
	@Test
	public void testTEXTExport_LoggingMetricsWithErrorSeverity()
			throws IOException, InterruptedException, XPathExpressionException,
			CoreException {
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute5 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.OK);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute3 : EShort") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.INFO);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute1 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.WARNING);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute2 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.ERROR);

		// launch the exporter
		assertFalse(exportedFile.exists());
		exporter.export(ecoreResource, rootNode, exportedFile.getFullPath());

		assertLineContains(SUCCESS_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(INFO_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(WARNING_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(ERROR_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(FAILURE_NUMBER_XPATH_LOCATION, "0"); //$NON-NLS-1$
	}

	/**
	 * Tests that the exported file contains the expected log for metrics
	 * section.
	 * 
	 * @throws IOException
	 * @throws XPathExpressionException
	 * @throws CoreException
	 */
	@Test
	public void testTEXTExport_LoggingMetricsWithFailureSeverity()
			throws IOException, InterruptedException, XPathExpressionException,
			CoreException {
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute5 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.OK);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute3 : EShort") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.INFO);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute1 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.WARNING);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute2 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.ERROR);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute4 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.FATAL);

		// launch the exporter
		assertFalse(exportedFile.exists());
		exporter.export(ecoreResource, rootNode, exportedFile.getFullPath());

		assertLineContains(SUCCESS_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(INFO_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(WARNING_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(ERROR_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
		assertLineContains(FAILURE_NUMBER_XPATH_LOCATION, "1"); //$NON-NLS-1$
	}

	/**
	 * Tests that the exportedFile contains the expected diagnostics for a
	 * constraint.
	 * 
	 * @throws XPathExpressionException
	 * @throws CoreException
	 * @throws IOException
	 */
	public void testTEXTExport_LogNullDiagnosticMessage()
			throws XPathExpressionException, CoreException, IOException {
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute3 : EShort") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.INFO);

		// launch the exporter
		assertFalse(exportedFile.exists());
		exporter.export(ecoreResource, rootNode, exportedFile.getFullPath());

		assertLineContains(26, "null diagnostic message"); //$NON-NLS-1$
	}

	/**
	 * Tests that the exportedFile contains the expected diagnostics for a
	 * constraint.
	 * 
	 * @throws XPathExpressionException
	 * @throws CoreException
	 * @throws IOException
	 */
	@Test
	public void testTEXTExport_LogInfoDiagnosticMessage() throws IOException,
			InterruptedException, XPathExpressionException, CoreException {
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute3 : EShort") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.INFO);
//		exporter.export(TestTool.getIResource(ecoreResource), rootNode, GENERATED_FILE_PATH);
//		assertLineContains(26, "null diagnostic message"); //$NON-NLS-1$

//		clearGeneratedReport();
		String diagnostic = "Diag INFO"; //$NON-NLS-1$
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute3 : EShort") //$NON-NLS-1$ //$NON-NLS-2$
				.setDiagnostic(diagnostic);

		// launch the exporter
		assertFalse(exportedFile.exists());
		exporter.export(ecoreResource, rootNode, exportedFile.getFullPath());

		assertLineContains(26, diagnostic);
	}

	@Test
	public void testTEXTExport_ProducesAllLogHeadings() throws IOException,
			CoreException {
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eclass1_constraint", "Eclass1 e1Att1").setSeverity( //$NON-NLS-1$ //$NON-NLS-2$
				Severity.ERROR);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint epackage_constraint", "ecoreTest").setSeverity( //$NON-NLS-1$ //$NON-NLS-2$
				Severity.FATAL);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute3 : EShort") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.WARNING);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eclass2_constraint", "EClass2").setSeverity( //$NON-NLS-1$ //$NON-NLS-2$
				Severity.INFO);

		// launch the exporter
		assertFalse(exportedFile.exists());
		exporter.export(ecoreResource, rootNode, exportedFile.getFullPath());

		// test tables headings
		assertLineContains(22, "ecoreTest.ocl"); //$NON-NLS-1$
		assertLineContains(23, "Constraint eclass2_constraint"); //$NON-NLS-1$
		assertLineContains(24, "eclass2_constraint"); //$NON-NLS-1$
		assertLineContains(25, "INFO"); //$NON-NLS-1$

		assertLineContains(29, "ecore.ocl"); //$NON-NLS-1$
		assertLineContains(30, "Constraint eattribute_constraint"); //$NON-NLS-1$
		assertLineContains(31, "eattribute_constraint"); //$NON-NLS-1$
		assertLineContains(32, "WARNING"); //$NON-NLS-1$

		assertLineContains(36, "ecoreTest.ocl"); //$NON-NLS-1$
		assertLineContains(37, "Constraint eclass1_constraint"); //$NON-NLS-1$
		assertLineContains(38, "eclass1_constraint"); //$NON-NLS-1$
		assertLineContains(39, "ERROR"); //$NON-NLS-1$

		assertLineContains(43, "ecore.ocl"); //$NON-NLS-1$
		assertLineContains(44, "Constraint epackage_constraint"); //$NON-NLS-1$
		assertLineContains(45, "epackage_constraint"); //$NON-NLS-1$
		assertLineContains(46, "FATAL"); //$NON-NLS-1$
	}

	@Test
	public void testTEXTExport_Statistics() throws IOException, CoreException {
		for (Result result : results) {
			result.setSeverity(Severity.OK);
		}

		getResultOfValidatableNodeFromLabel(results,
				"Constraint eclass1_constraint", "Eclass1 e1Att1").setSeverity( //$NON-NLS-1$ //$NON-NLS-2$
				Severity.ERROR);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint epackage_constraint_2", "ecoreTest").setSeverity( //$NON-NLS-1$ //$NON-NLS-2$
				Severity.ERROR);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint epackage_constraint", "ecoreTest").setSeverity( //$NON-NLS-1$ //$NON-NLS-2$
				Severity.FATAL);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eclass_constraint", "EClass3 -> Eclass5") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.FATAL);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute3 : EShort") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.WARNING);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eclass2_constraint", "EClass2").setSeverity( //$NON-NLS-1$ //$NON-NLS-2$
				Severity.INFO);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute5 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.INFO);
		getResultOfValidatableNodeFromLabel(results,
				"Constraint eattribute_constraint", "eAttribute1 : EString") //$NON-NLS-1$ //$NON-NLS-2$
				.setSeverity(Severity.WARNING);

		// launch the exporter
		assertFalse(exportedFile.exists());
		exporter.export(ecoreResource, rootNode, exportedFile.getFullPath());

		// tests validation results
		// Total number
		assertLineContains(12, EXPECTED_RESULTS.toString()); //$NON-NLS-1$

		// Success
		assertLineContains(13, EXPECTED_SUCCESSES.toString()); //$NON-NLS-1$

		// Infos
		assertLineContains(14, EXPECTED_INFOS.toString()); //$NON-NLS-1$

		// Warning
		assertLineContains(15, EXPECTED_WARNINGS.toString()); //$NON-NLS-1$

		// Errors
		assertLineContains(16, EXPECTED_ERRORS.toString()); //$NON-NLS-1$

		// Failures
		assertLineContains(17, EXPECTED_FAILURES.toString()); //$NON-NLS-1$
	}

	@Test
	public void testTEXTExport_ModelsValidatedSuccessfully()
			throws IOException, CoreException {
		// launch the exporter
		assertFalse(exportedFile.exists());
		exporter.export(ecoreResource, rootNode, exportedFile.getFullPath());

		// test output file name
		assertLineContains(2, exportedFile.getName());

		// test resource validated
		assertLineContains(8, "ecoreTest.ecore"); //$NON-NLS-1$

		// tests validation results
		// Total number
		assertLineContains(12, "0"); //$NON-NLS-1$

		// Success
		assertLineContains(13, "0"); //$NON-NLS-1$

		// Infos
		assertLineContains(14, "0"); //$NON-NLS-1$

		// Warning
		assertLineContains(15, "0"); //$NON-NLS-1$

		// Errors
		assertLineContains(16, "0"); //$NON-NLS-1$

		// Failures
		assertLineContains(17, "0"); //$NON-NLS-1$

		// test logs results
		assertLineContains(21, "No log to display: models has been successfully validated."); //$NON-NLS-1$
	}

}
