/**
 * <copyright>
 *
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.completeocl.validation;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.validation.LoadableConstraintProvider;

/**
 * A CompleteOCLConstraintParser supports registration and lazy resolution of
 * the constraints defined in a Complete OCL document for use with the EMF.Validation
 * framework.
 * <p>
 * Since the ConstraintProvider is not extensible, it is necessary to provide
 * support using a ConstraintParser for the CompleteOCL language.
 * <p>
 * The redirection to e.g Loans.ocl should be defined as:
 * <p>
<extension point="org.eclipse.emf.validation.constraintProviders" id="oclProvider">
  <category
            name="Loans.ocl"
            id="org.eclipse.ocl.examples.xtext.completeocl.validation.CompleteOCL/Loans.ocl">
         Constraints determined by parsing Loans.ocl
      </category>
      <constraintProvider cache="true">
         <package namespaceUri="platform:/resource/Play/Loans.ecore"/>
         
         <constraints categories="org.eclipse.ocl.examples.xtext.completeocl.validation.CompleteOCL/Loans.ocl">
            <constraint id="placeholder" lang="CompleteOCL" mode="Batch" statusCode="101"
                name="=== The Loans.ocl Constraints ===">
               <description>
Placeholder for the actual constraints in Loans.ocl.

The actual constraints are lazily loaded by the first validation run that uses them.</description>
               <message>No message</message>
               <param name="path" value="Loans.ocl"/>
            </constraint>
         </constraints>
      </constraintProvider>
  </extension>
 * <p>
 * and a binding to a client context as:
 * <p>
   <extension point="org.eclipse.emf.validation.constraintBindings">
      <clientContext id="oclProvider.context" default="false">
         <selector class="org.eclipse.ocl.examples.xtext.completeocl.validation.CompleteOCLClientSelector"/>
      </clientContext>
      <binding
            context="oclProvider.context"
            category="org.eclipse.ocl.examples.xtext.completeocl.validation.CompleteOCL/Loans.ocl"/>
   </extension>
 * <p>
 * and a lazy constraint creation as:
 * <p>
   <extension point="org.eclipse.emf.validation.traversal">
      <traversalStrategy
            class="org.eclipse.ocl.examples.xtext.completeocl.validation.LazyLoadingTraversalStrategy"
            namespaceUri="platform:/resource/Play/Loans.ecore">
         <eclass name="Model"/>
      </traversalStrategy>
   </extension>
 */
public class CompleteOCLConstraintProvider extends LoadableConstraintProvider
{
	private static final Logger logger = Logger.getLogger(CompleteOCLConstraintProvider.class);

	public CompleteOCLConstraintProvider() {
    	System.out.println("new CompleteOCLConstraintProvider");
	}

	@Override
	protected boolean load(@NonNull MetaModelManager metaModelManager,@NonNull URI uri, @NonNull Set<Category> categories) {
		ResourceSet resourceSet = metaModelManager.getExternalResourceSet();
		BaseResource xtextResource = null;
		try {
			xtextResource = (BaseResource) resourceSet.getResource(uri, true);
		}
		catch (WrappedException e) {
			logger.error("Failed to load '" + uri, e);
			throw e;
		}
		List<Resource.Diagnostic> errors = xtextResource.getErrors();
		assert errors != null;
		String message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
		if (message != null) {
			logger.error("Failed to load '" + uri + message);
			return false;
		}
		Resource asResource = xtextResource.getASResource(metaModelManager);
		return installResource(asResource, categories);
	}
}
