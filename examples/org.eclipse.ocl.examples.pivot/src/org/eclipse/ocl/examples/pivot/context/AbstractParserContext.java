/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.osgi.util.NLS;

public abstract class AbstractParserContext /*extends AdapterImpl*/ implements ParserContext
{
	protected final MetaModelManager metaModelManager;
	protected final URI uri;
	
	protected AbstractParserContext(MetaModelManager metaModelManager, URI uri) {
		this.metaModelManager = metaModelManager;
		this.uri = uri;
	}

	public BaseResource createBaseResource(String expression) throws IOException {
		InputStream inputStream = new URIConverter.ReadableInputStream(expression, "UTF-8");
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		BaseResource baseResource = (BaseResource)resource;
		MetaModelManagerResourceAdapter.getAdapter(resource, metaModelManager);
		baseResource.setParserContext(this);
		baseResource.load(inputStream, null);
		return baseResource;
	}

	public Type getClassContext() {
		return null;
	}

	public ExpressionInOcl getExpression(BaseResource resource) throws ParserException {
		List<EObject> contents = resource.getContents();
		int size = contents.size();
		if (size == 0) {
			return null;
		}
		if (size > 1) {
			throw new ParserException("Extra returns ignored");
		}
		EObject csObject = contents.get(0);
		if (csObject instanceof Pivotable) {
			Element pivotElement = ((Pivotable)csObject).getPivot();
			if (pivotElement instanceof ExpressionInOcl) {
				return (ExpressionInOcl) pivotElement;
			}
		}
		throw new ParserException("Non-expression ignored");
	}

	public MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	public URI getURI() {
		return uri;
	}

	public void initialize(Base2PivotConversion conversion, ExpressionInOcl expression) {
		List<String> language = expression.getLanguage();
		language.clear();
		language.add(PivotConstants.OCL_LANGUAGE);
	}

	public ExpressionInOcl parse(String expression) throws ParserException {
		BaseResource resource = null;
		try {
			resource = createBaseResource(expression);
			PivotUtil.checkResourceErrors(NLS.bind(OCLMessages.ErrorsInResource, expression), resource);
			return getExpression(resource);
		} catch (IOException e) {
//				throw new ParserException("Failed to load expression", e);
			ExpressionInOcl specification = PivotFactory.eINSTANCE.createExpressionInOcl();
			OclExpression invalidValueBody = metaModelManager.createInvalidExpression();
			specification.setBodyExpression(invalidValueBody);
			return specification;
		} finally {
			if (resource != null) {
				MetaModelManagerResourceAdapter adapter = MetaModelManagerResourceAdapter.findAdapter(resource);
				if (adapter != null) {
					adapter.dispose();
				}
			}
		}
	}
}
