/**
 * <copyright>
 * 
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: DocumentationExamples.java,v 1.1 2011/05/09 16:43:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.BookCategory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Query;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;



/**
 * Tests for the OCL delegate implementations.
 */
@SuppressWarnings({"nls","null"})
public class PivotDocumentationExamples extends XtextTestCase
{
	public void debugPrintf(String format, Object... args) {
//		System.out.printf(format,  args);
	}
	
	public InputStream getInputStream(String fileName) throws MalformedURLException, IOException {
		URI uri = getTestModelURI(fileName);
		URL url = new URL(uri.toString());
		return url.openStream();
	}
	
	public URI getInputURI(String fileName) throws MalformedURLException, IOException {
		return getTestModelURI(fileName);
	}
	
	private List<Library> getLibraries() {
		return Collections.emptyList();
	}

	public Library getLibrary() {
		Library library = EXTLibraryFactory.eINSTANCE.createLibrary();
		Book aBook = EXTLibraryFactory.eINSTANCE.createBook();
		aBook.setTitle("Bleak House");
		library.getBooks().add(aBook);
		return library;
	}
	
	/*
	 * This 'test' provides the source text for the 'Parsing OCL Document' example
	 * in org.eclipse.ocl.doc/doc/5120-parsing-constraints.textile
	 */
	public void test_parsingConstraintsExample() throws IOException, ParserException {
		// create an OCL instance for Ecore
		OCL ocl = OCL.newInstance();

		// create an OCL helper object
		OCLHelper helper = ocl.createOCLHelper(EXTLibraryPackage.Literals.LIBRARY);

		ExpressionInOCL invariant = helper.createInvariant(
		    "books->forAll(b1, b2 | b1 <> b2 implies b1.title <> b2.title)");
		   
		ExpressionInOCL query = helper.createQuery(
		    "books->collect(b : Book | b.category)->asSet()");

		EOperation oper = null;
		for (EOperation next : EcorePackage.Literals.EMODEL_ELEMENT.getEOperations()) {
		    if ("getEAnnotation".equals(next.getName())) {
		        oper = next;
		        break;
		    }
		}

		// define a post-condition specifying the value of EModelElement::getEAnnotation(EString).
		// This operation environment includes variables representing the operation
		// parameters (in this case, only "source : String") and the operation result
		helper.setOperationContext(EcorePackage.Literals.ECLASS, oper);
		ExpressionInOCL body = helper.createPostcondition(
		    "result = self.eAnnotations->any(ann | ann.source = source)");

		// define a derivation constraint for the EReference::eReferenceType property
		helper.setPropertyContext(
		    EcorePackage.Literals.EREFERENCE,
		    EcorePackage.Literals.EREFERENCE__EREFERENCE_TYPE);
		ExpressionInOCL derive = helper.createDerivedValueExpression(
		    "self.eType->any(true).oclAsType(EClass)");
	
		if ((body == derive) && (invariant == query)) { /* the yellow markers go away */ }
		
		ocl.dispose();
	}
	
	
	/*
	 * This 'test' provides the source text for the 'Parsing OCL Document' example
	 * in org.eclipse.ocl.doc/doc/5115-evaluating-constraints.textile
	 */
	public void test_evaluatingConstraintsExample() throws IOException, ParserException {
		OCL ocl = OCL.newInstance();
		OCLHelper helper = ocl.createOCLHelper(EXTLibraryPackage.Literals.LIBRARY);
		ExpressionInOCL invariant = helper.createInvariant(
		    "books->forAll(b1, b2 | b1 <> b2 implies b1.title <> b2.title)");
		ExpressionInOCL query = helper.createQuery(
		    "books->collect(b : Book | b.category)->asSet()");

		// create a Query to evaluate our query expression
		Query queryEval = ocl.createQuery(query);

		// create another to check our constraint
		Query constraintEval = ocl.createQuery(invariant);

		List<Library> libraries = getLibraries();  // hypothetical source of libraries

		// only print the set of book categories for valid libraries
		for (Library next : libraries) {
		    if (constraintEval.check(next)) {
		        // the OCL result type of our query expression is Set(BookCategory)
		        @SuppressWarnings("unchecked")
		        Set<BookCategory> categories = (Set<BookCategory>) queryEval.evaluate(next);
		        
		        debugPrintf("%s: %s%n\n", next.getName(), categories);
		    }
		}

		// Check one
		
		// check a single library
		Library lib = getLibrary();  // hypothetical source of a library

		// check whether it satisfies the constraint
		debugPrintf("%s valid: %b\n", lib.getName(), ocl.check(lib, invariant));

		// MoreSuccinct

		// only print the set of book categories for valid libraries
		for (Library next : constraintEval.select(libraries)) {
		    @SuppressWarnings("unchecked")
		    Set<BookCategory> categories = (Set<BookCategory>) queryEval.evaluate(next);
		    
		    debugPrintf("%s: %s%n\n", next.getName(), categories);
		}

		ocl.dispose();
	}

	/*
	 * This 'test' provides the source text for the 'Parsing OCL Document' example
	 * in org.eclipse.ocl.doc/doc/5120-parsing-documents.textile
	 */
	public void test_parsingDocumentsExample() throws IOException, ParserException {
		//-------------------------------------------------------------------------
		//	The OCL Input
		//-------------------------------------------------------------------------
		EPackage.Registry registry = new EPackageRegistryImpl();
		registry.put(EXTLibraryPackage.eNS_URI, EXTLibraryPackage.eINSTANCE);
		OCL ocl = OCL.newInstance(registry);

		// get an OCL text file via some hypothetical API
		URI uri = getInputURI("/model/parsingDocumentsExample.ocl");

		Map<String, ExpressionInOCL> constraintMap = new HashMap<String, ExpressionInOCL>();

		// parse the contents as an OCL document
		Resource asResource = ocl.parse(uri);
	    for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
	    	EObject next = tit.next();
	    	if (next instanceof Constraint) {
		        Constraint constraint = (Constraint)next;
//				String stereotype = constraint.getStereotype();
//				if (UMLReflection.INVARIANT.equals(stereotype)) {
			        ExpressionInOCL expressionInOCL = ocl.getSpecification(constraint);
			        if (expressionInOCL != null) {
						String name = constraint.getName();
						if (name != null) {
							constraintMap.put(name, expressionInOCL);
							debugPrintf("%s: %s%n\n", name,
					        	expressionInOCL.getBodyExpression());
						}
					}
//				}
	    	}
	    }
		//-------------------------------------------------------------------------
		//	Accessing the Constraints
		//-------------------------------------------------------------------------
		Library library = getLibrary();  // get library from a hypothetical source

		OCLHelper helper = ocl.createOCLHelper(EXTLibraryPackage.Literals.LIBRARY);

		// use the constraints defined in the OCL document

		// use the getBooks() additional operation to find a book
		ExpressionInOCL query = helper.createQuery(
		    "getBooks('Bleak House')->asSequence()->first()");

		Book book = (Book) ocl.evaluate(library, query);
		debugPrintf("Got book: %s%n\n", book);

		// use the unique_title constraint to validate the book
		boolean isValid = ocl.check(book, constraintMap.get("unique_title"));
		debugPrintf("Validate book: %b%n\n", isValid);	

		ocl.dispose();
	}
}
