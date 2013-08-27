/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EssentialOCLCSResource.java,v 1.15 2011/05/23 08:45:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.utilities.IllegalLibraryException;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.LibraryDiagnostic;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2Pivot;
import org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs.EssentialOCLPivot2CS;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.util.CancelIndicator;

public class EssentialOCLCSResource extends LazyLinkingResource implements BaseCSResource
{	
	private @Nullable ParserContext parserContext = null;
	
	public EssentialOCLCSResource() {
		super();
	}

	protected void addLibraryError(List<Diagnostic> errors, IllegalLibraryException e) {
		String message = e.getMessage();
		for (Resource.Diagnostic diagnostic : errors) {
			if (diagnostic instanceof LibraryDiagnostic) {
				Exception exception = ((LibraryDiagnostic)diagnostic).getException();
				if (exception instanceof IllegalLibraryException) {
					if (message.equals(exception.getMessage())) {
						return;
					}
				}
			}
		}
		errors.add(new LibraryDiagnostic(e));
	}

	@Override		// FIXME This workaround should be eliminated by a BUG 404438 fix
	protected void addSyntaxErrors() {
		if (isValidationDisabled()) {
			return;
		}
		IParseResult parseResult = getParseResult();
		if (parseResult == null) {
			return;
		}
		List<Diagnostic> errors2 = getErrors();
		for (final INode error : parseResult.getSyntaxErrors()) {
			AbstractDiagnostic diagnostic = null;
			final SyntaxErrorMessage syntaxErrorMessage = error.getSyntaxErrorMessage();
			if (syntaxErrorMessage != null) {
				String message = syntaxErrorMessage.getMessage();
				if (message != null) {
					int index = message.indexOf("<EOF>");
					if (index >= 0) {
						String tokenText = NodeModelUtils.getTokenText(error);
						if (tokenText != null) {
							final String newMessage = message.substring(0, index) + tokenText + message.substring(index+5);
							diagnostic = new AbstractDiagnostic()
							{
								public String getMessage() {
									return newMessage;
								}

								@Override
								protected INode getNode() {
									return error;
								}

								@Override
								public String getCode() {
									return syntaxErrorMessage.getIssueCode();
								}

								@Override
								public String[] getData() {
									return syntaxErrorMessage.getIssueData();
								}
							};
						}
					}
				}
			}
			if (diagnostic == null) {
				diagnostic = new XtextSyntaxDiagnostic(error);
			}
			errors2.add(diagnostic);
		}
	}

	public @NonNull CS2Pivot createCS2Pivot(@NonNull Map<? extends Resource, ? extends ASResource> cs2asResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		return new EssentialOCLCS2Pivot(cs2asResourceMap, metaModelManager);
	}

	public Pivot2CS createPivot2CS(@NonNull Map<? extends Resource, ? extends ASResource> cs2asResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		return new EssentialOCLPivot2CS(cs2asResourceMap, metaModelManager);
	}

	public @NonNull MetaModelManager createMetaModelManager() {
		ResourceSet resourceSet = getResourceSet();
		if (resourceSet != null) {
			MetaModelManagerResourceSetAdapter resourceSetAdapter = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
			if (resourceSetAdapter != null) {
				return resourceSetAdapter.getMetaModelManager();
			}
		}
		return new MetaModelManager();
	}

	@Override
	protected void doLinking() {
//		CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".doLinking start", false, +1);
		List<Diagnostic> errors = getErrors();
		if (errors.size() > 0) {
			for (int i = errors.size(); --i >= 0; ) {
				Diagnostic error = errors.get(i);
				if (error instanceof LibraryDiagnostic) {
					errors.remove(i);
				}
			}
		}
		super.doLinking();
//		CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".doLinking end", false, -1);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
//		CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".doLoad start", false, +1);
		try {
			super.doLoad(inputStream, options);
		}
		finally {
//			CS2Pivot.printDiagnostic(getClass().getSimpleName() + ".doLoad end", true, -1);
		}
	}
	
	public final @Nullable CS2PivotResourceAdapter findCS2ASAdapter() {
		return PivotUtil.getAdapter(CS2PivotResourceAdapter.class, this);
	}
	
	public @NonNull String getASContentType() {
		return ASResource.ESSENTIALOCL_CONTENT_TYPE;
	}
	
	public final @NonNull CS2PivotResourceAdapter getCS2ASAdapter(@Nullable MetaModelManager metaModelManager) {
		CS2PivotResourceAdapter adapter = PivotUtil.getAdapter(CS2PivotResourceAdapter.class, this);
		if (adapter == null) {
			if (metaModelManager == null) {
				metaModelManager = PivotUtil.findMetaModelManager(this);					
				if (metaModelManager == null) {
					metaModelManager = createMetaModelManager();
					ResourceSet csResourceSet = getResourceSet();
					if (csResourceSet != null) {
						MetaModelManagerResourceSetAdapter.getAdapter(csResourceSet, metaModelManager);
					}
				}
				ClassLoader classLoader = getClass().getClassLoader();
				if (classLoader != null) {
					metaModelManager.addClassLoader(classLoader);
				}
			}
			@SuppressWarnings("null")@NonNull Registry resourceFactoryRegistry = metaModelManager.getASResourceSet().getResourceFactoryRegistry();
			initializeResourceFactory(resourceFactoryRegistry);
			adapter = new CS2PivotResourceAdapter(this, metaModelManager);
			eAdapters().add(adapter);
		}
		return adapter;
	}

	public @NonNull String getEditorName() {
		return "Essential OCL";
	}

	public final @Nullable ParserContext getParserContext() {
		return parserContext;
	}

	public final @NonNull ASResource getASResource(@Nullable MetaModelManager metaModelManager) {
		CS2PivotResourceAdapter adapter = getCS2ASAdapter(metaModelManager);
		ASResource asResource = adapter.getASResource(this);
		if (asResource == null) {
			throw new IllegalStateException("No Pivot Resource created");
		}
		return asResource;
	}

	@SuppressWarnings("null")
	public @NonNull URI getASURI(@NonNull URI csURI) {
		return csURI.appendFileExtension(PivotConstants.OCL_AS_FILE_EXTENSION);
	}

	/**
	 * Install any required extension/content-type registrations to enable AS Resources
	 * to be created satisfactorily.
	 */
	protected void initializeResourceFactory(@NonNull Resource.Factory.Registry resourceFactoryRegistry) {}

	public final @NonNull URI resolve(@NonNull URI uri) {
		URI csURI = getURI();
		if (csURI.isRelative()) {
			File csRelative = new File(csURI.toFileString());
			File csAbsolute = csRelative.getAbsoluteFile();
			csURI = URI.createFileURI(csAbsolute.toString());
		}
		URI resolvedURI = uri.resolve(csURI);
		assert resolvedURI != null;
		return resolvedURI;
	}

	@Override
	public void resolveLazyCrossReferences(CancelIndicator mon) {	// FIXME move to Validation rules
		List<Diagnostic> errors = getErrors();
		assert errors != null;
		if (ElementUtil.hasSyntaxError(errors)) {
			return;
		}
		MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(this);
		if (metaModelManager != null) {
//			if (metaModelManager.getLibraryResource() != org.eclipse.ocl.examples.library.oclstdlib.OCLstdlib.INSTANCE) {
//				metaModelManager.resetLibrary();		// FIXME is this needed; if so test it
//			}
			try {
				metaModelManager.getOclAnyType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getOclElementType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getOclVoidType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getOclInvalidType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getMetaclassType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getBooleanType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getRealType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getIntegerType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getUnlimitedNaturalType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getStringType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getCollectionType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getBagType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getSequenceType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getSetType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getOrderedSetType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getEnumerationType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getOclTupleType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
			try {
				metaModelManager.getOclLambdaType();
			} catch (IllegalLibraryException e) {			
				addLibraryError(errors, e);
			}
		}
		super.resolveLazyCrossReferences(mon);
	}

	public final void setParserContext(@Nullable ParserContext parserContext) {
		this.parserContext = parserContext;
	}

	public void updateFrom(@NonNull ASResource asResource, @NonNull MetaModelManager metaModelManager) {		
		Map<Resource, ASResource> cs2PivotResourceMap = new HashMap<Resource, ASResource>();
		cs2PivotResourceMap.put(this, asResource);
		Pivot2CS pivot2cs = createPivot2CS(cs2PivotResourceMap, metaModelManager);
		pivot2cs.update();
	}
}
