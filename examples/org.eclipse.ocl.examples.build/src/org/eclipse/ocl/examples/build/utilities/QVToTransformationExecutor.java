/**
 * <copyright>
 *
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.build.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.StringBufferLog;

public class QVToTransformationExecutor extends AbstractWorkflowComponent
{
	private static enum Kind { IN, INOUT, OUT };

	private static final Logger logger = Logger.getLogger(QVToTransformationExecutor.class);
	
	private ResourceSet resourceSet = null;	
	private String uri = null;	
	private @NonNull List<URI> modelURIs = new ArrayList<URI>();
	private @NonNull List<Kind> modelKinds = new ArrayList<Kind>();
	private String trace = null;
	private String encoding = "UTF-8"; //$NON-NLS-1$
	
	/**
	 * Specify the next model transformation input/output URI which has an 'in' direection,
	 * e.g. "platform:/resource/org.eclipse.ocl.examples.xtext.base/model/BaseCST.ecore" 
	 */
	public void addIn(String uri) {
		modelURIs.add(URI.createURI(uri, true));
		modelKinds.add(Kind.IN);
	}
	
	/**
	 * Specify the next model transformation input/output URI which has an 'inout' direection,
	 * e.g. "platform:/resource/org.eclipse.ocl.examples.xtext.base/model/BaseCST.ecore" 
	 */
	public void addInout(String uri) {
		modelURIs.add(URI.createURI(uri, true));
		modelKinds.add(Kind.INOUT);
	}
	
	/**
	 * Specify the next model transformation input/output URI which has an 'out' direection,
	 * e.g. "platform:/resource/org.eclipse.ocl.examples.xtext.base/model/BaseCST.ecore" 
	 */
	public void addOut(String uri) {
		modelURIs.add(URI.createURI(uri, true));
		modelKinds.add(Kind.OUT);
	}

	public void checkConfiguration(Issues issues) {
		if (getUri() == null) {
			issues.addError(this, "Transformation uri not specified.");
		}
	}
	
	public String getEncoding() {
		return encoding;
	}

	public ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	protected Map<String, Object> getSaveOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		options.put(XMLResource.OPTION_LINE_WIDTH, 80);
		options.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		return options;
	}

	public String getTrace() {
		return trace;
	}

	public String getUri() {
		return uri;
	}

	/**
	 * Clients may override to do any configuration 
	 * properties initialization
	 * 
	 * @return creates a context to be used by the transformation
	 */
	protected void initializeConfigurationProperties(ExecutionContextImpl context) {
		// do nothing
	}
	
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		String uri = getUri();
		URI txURI = URI.createURI(uri, true);
		logger.info("Loading '" + txURI + "'");
		TransformationExecutor transformationExecutor = new TransformationExecutor(txURI);
		Diagnostic diagnostic = transformationExecutor.loadTransformation();
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			StringBuilder s = new StringBuilder();
			s.append("Failed to load ");
			s.append(txURI);
			for (Diagnostic child : diagnostic.getChildren()) {
				s.append("\n  " + child.getMessage());
			}
			issues.addError(this, s.toString(), txURI, null, null);
			return;
		}
		
		ResourceSet resourceSet = getResourceSet();
		List<ModelExtent> modelExtents = new ArrayList<ModelExtent>();
		for (int i = 0; i < modelURIs.size(); i++) {
			URI modelURI = modelURIs.get(i);
			Kind kind = modelKinds.get(i);
			if (kind != Kind.OUT) { 
				logger.info("Loading " + i + " " + kind + " '" + modelURI + "'");
				Resource inResource = resourceSet.getResource(modelURI, true);
				if (inResource.getErrors().size() > 0) {
					issues.addError(this, "Failed to load", modelURI, null, null);
					return;
				}
				modelExtents.add(new BasicModelExtent(inResource.getContents()));
			}
			else {
				logger.info("Creating output:  " + i + " " + kind + " '" + modelURI + "'");
				Resource outResource = resourceSet.createResource(modelURI, null);
				if (outResource instanceof XMLResource) {
					((XMLResource)outResource).setEncoding(getEncoding());
				}
				modelExtents.add(new BasicModelExtent());
			}
		}

//		String traceUri = trace != null ? URI.createPlatformResourceURI(trace, true).toString() : null;
		
		
		StringBufferLog qvtoLog = new StringBufferLog();
		try {
			logger.info("Executing transformation '" + uri + "'");
			ExecutionContextImpl executionContext = new ExecutionContextImpl();
			executionContext.setLog(qvtoLog);
			initializeConfigurationProperties(executionContext);
//			executionContext.setMonitor();
			ExecutionDiagnostic executionDiagnostic = transformationExecutor.execute(executionContext, modelExtents.toArray(new ModelExtent[modelExtents.size()]));
			if (executionDiagnostic.getSeverity() != Diagnostic.OK) {
				StringBuilder s = new StringBuilder();
				s.append("Failed to execute ");
				s.append(txURI);
				s.append(": ");
				s.append(executionDiagnostic.getMessage());
				for (Diagnostic child : diagnostic.getChildren()) {
					s.append("\n  " + child.getMessage());
				}
				issues.addError(this, s.toString(), txURI, null, null);
				return;
			}
		} catch (Exception e) {
			issues.addError(this, "Failed to launch transformation", txURI, e, null);
			return;
		}
		Map<String, Object> options = getSaveOptions();
		for (int i = 0; i < modelURIs.size(); i++) {
			URI modelURI = modelURIs.get(i);
			Kind kind = modelKinds.get(i);
			if (kind != Kind.IN) { 
				try {
					logger.info("Saving output:  " + i + " " + kind + " '" + modelURI + "'");
					Resource outResource = resourceSet.getResource(modelURI, false);
					if (kind == Kind.OUT) { 
						outResource.getContents().addAll(modelExtents.get(modelExtents.size()-1).getContents());
					}
					outResource.save(options);
				} catch (IOException e) {
					issues.addError(this, "Failed to save ", modelURI, e, null);
					return;
				}	
			}
		}
		String qvtoLogContents = qvtoLog.getContents().trim();
		if (qvtoLogContents.length() > 0) {
			logger.info("Log '\n" + qvtoLogContents);
		}
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	/**
	 * @param uri the QVTo Transformations URI
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
}
