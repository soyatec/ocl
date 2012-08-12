/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: CS2PivotConversion.java,v 1.23 2011/05/23 05:51:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.context.AbstractBase2PivotConversion;
import org.eclipse.ocl.examples.pivot.util.MorePivotable;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PivotableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasePreOrderVisitor.TemplateSignatureContinuation;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2Moniker;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class CS2PivotConversion extends AbstractBase2PivotConversion
{	
	private static final Logger logger = Logger.getLogger(CS2PivotConversion.class);
	public static final @NonNull TracingOption CONTINUATION = new TracingOption("org.eclipse.ocl.examples.xtext.base", "continuation");  //$NON-NLS-1$//$NON-NLS-2$

	public static class CacheKey<T>
	{
		protected final @NonNull String name;
		
		public CacheKey(@NonNull String name) {
			this.name = name;
		}
		
		@Override
		public String toString() { return name; }
	}
	
	protected final @NonNull CS2Pivot converter;
	protected final @NonNull Collection<? extends Resource> csResources;
	
	/**
	 * The Visitors
	 */
	private final @NonNull BaseCSVisitor<Continuation<?>> containmentVisitor;
	private final @NonNull BaseCSVisitor<Element> left2RightVisitor;
	private final @NonNull BaseCSVisitor<Continuation<?>> postOrderVisitor;
	private final @NonNull BaseCSVisitor<Continuation<?>> preOrderVisitor;

	private @NonNull InterDependency<TemplateSignatureContinuation> typesHaveSignatures = new InterDependency<TemplateSignatureContinuation>("All unspecialized signatures defined", null);

	/**
	 * A typed cache for use by derived conversions.
	 */
	private final @NonNull Map<CacheKey<?>, Object> intermediateCache = new HashMap<CacheKey<?>, Object>();

	private Map<String, org.eclipse.ocl.examples.pivot.Package> oldPackagesByName = null;
	private Map<String, org.eclipse.ocl.examples.pivot.Package> oldPackagesByQualifiedName = null;	// WIP lose this since using nsURIs

	/**
	 * The handler for any generated diagnostics. If null (which is deprecated) diagnostics are inserted
	 * directly into the resource errors list.
	 */
	@SuppressWarnings("unused")
	private final IDiagnosticConsumer diagnosticsConsumer;
	
	public CS2PivotConversion(@NonNull CS2Pivot converter, @NonNull IDiagnosticConsumer diagnosticsConsumer, @NonNull Collection<? extends Resource> csResources) {
		super(converter.getMetaModelManager());
		this.converter = converter;
		this.diagnosticsConsumer = diagnosticsConsumer;
		this.csResources = csResources;
		this.containmentVisitor = converter.createContainmentVisitor(this);
		this.left2RightVisitor = converter.createLeft2RightVisitor(this);
		this.postOrderVisitor = converter.createPostOrderVisitor(this);
		this.preOrderVisitor = converter.createPreOrderVisitor(this);
		List<Resource> mappedResources = new ArrayList<Resource>();
		for (Resource csResource : csResources) {
			if (csResource != null) {
				mappedResources.add(converter.getPivotResource(csResource));
			}
		}
	}

	public @NonNull OCLExpression addBadExpressionError(@NonNull ModelElementCS csElement, @NonNull String boundMessage) {
		INode node = NodeModelUtils.getNode(csElement);
		Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, boundMessage);
		csElement.eResource().getErrors().add(resourceDiagnostic);
		InvalidLiteralExp invalidLiteralExp = metaModelManager.createInvalidExpression();
		csElement.setPivot(invalidLiteralExp);
		return invalidLiteralExp;
	}

	public void addDiagnostic(@NonNull ModelElementCS csElement, @NonNull Diagnostic diagnostic) {
		INode node = NodeModelUtils.getNode(csElement);
		Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, diagnostic.getMessage());
		csElement.eResource().getErrors().add(resourceDiagnostic);
	}

	public void addDiagnostic(@NonNull ElementCS csElement, @NonNull String boundMessage) {
		INode node = NodeModelUtils.getNode(csElement);
		Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, boundMessage);
		csElement.eResource().getErrors().add(resourceDiagnostic);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ocl.examples.xtext.base.cs2pivot.DiagnosticHandler#addWarning(org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS, java.lang.String, java.lang.Object)
	 */
	public void addWarning(@NonNull ModelElementCS csElement, /*@NonNull*/ String message, Object... bindings) {
		String boundMessage = NLS.bind(message, bindings);
		INode node = NodeModelUtils.getNode(csElement);
		Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, boundMessage);
		csElement.eResource().getErrors().add(resourceDiagnostic);
	}

	public @NonNull String bind(@NonNull EObject csContext, /*@NonNull*/ String messageTemplate, Object... bindings) {
		return converter.bind(csContext, messageTemplate, bindings);
	}

	public boolean checkForNoErrors(@NonNull Collection<? extends Resource> csResources) {
		for (Resource csResource : csResources) {
			@SuppressWarnings("null") @NonNull List<Resource.Diagnostic> errors = csResource.getErrors();
			if (ElementUtil.hasSyntaxError(errors)) {
				return false;
			}
		}
		return true;
	}

	public Dependency createTypeIsReferenceableDependency(@NonNull TypeRefCS csTemplateParameter) {
		if (csTemplateParameter instanceof WildcardTypeRefCS) {
			return null;
		}
		else {
			return new PivotDependency(csTemplateParameter);
		}
	}

	protected void diagnoseContinuationFailure(@NonNull List<BasicContinuation<?>> continuations) {
		if (CONTINUATION.isActive()) {
			for (BasicContinuation<?> continuation : continuations) {
				CONTINUATION.println(continuation.toString());
				for (Dependency dependency : continuation.getDependencies()) {
					boolean canExecute = dependency.canExecute();
					CONTINUATION.println((canExecute ? "+ " : "- ") + dependency.toString());
				}
			}
		}
		StringBuilder s = new StringBuilder();
		int i = 0;
		for (BasicContinuation<?> continuation : continuations) {
			s.append("\n  ");
			s.append(continuation);
			for (Dependency dependency : continuation.getDependencies()) {
				s.append("\n    ");
				if (!dependency.canExecute()) {
					s.append("BLOCKED ");
					dependency.canExecute();			// FIXME debugging
				}
				s.append(dependency);					
			}
			continuation.canExecute();			// FIXME debugging
			if (++i >= 10) {
				s.append("\n  ...");
				break;
			}
		}
		logger.error("Failed to complete continuations" + s.toString());		// FIXME
	}

/*	private void enforceConformance(AnyType oclAny) {
		Collection<? extends Resource> pivotResources = converter.getPivotResources();
		Collection<Notifier> allPivotResources = new ArrayList<Notifier>(pivotResources);
		allPivotResources.add(metaModelManager.getOrphanPackage());
		for (TreeIterator<Object> tit = EcoreUtil.getAllContents(allPivotResources); tit.hasNext(); ) {
			Object object = tit.next();
			if (object instanceof org.eclipse.ocl.examples.pivot.Package) {
				for (Type type : ((org.eclipse.ocl.examples.pivot.Package)object).getOwnedType()) {
					if (type instanceof org.eclipse.ocl.examples.pivot.Class) {
						List<org.eclipse.ocl.examples.pivot.Class> superClasses = ((org.eclipse.ocl.examples.pivot.Class)type).getSuperClass();
						if (superClasses.isEmpty()) {
							if (type != oclAny) {
								if (type instanceof org.eclipse.ocl.examples.pivot.Enumeration) {
									superClasses.add(metaModelManager.getEnumerationType());
								}
								else {
									superClasses.add(oclAny);
								}
							}
						}
					}
				}
			}
			else {
				tit.prune();
			}
		}
	} */

/*	protected List<String> getDocumentationStrings1(CompositeNode node) {
		List<LeafNode> documentationNodes = CS2Pivot.getDocumentationNodes(node);
		if (documentationNodes == null) {
			return null;
		}
		List<String> documentationStrings = new ArrayList<String>();
		for (LeafNode documentationNode : documentationNodes) {
			String text = documentationNode.getText();
			documentationStrings.add(text.substring(3, text.length()-3).trim());
		}
		return documentationStrings;
	} */
	
	/**
	 * Prune the pivots to eliminate:
	 * - redundant orphans - e.g. obsolete specializations
	 * - redundant elements - e.g. pivots that are not needed as a result of a CS update
	 * - dependent caches that reference any of the above
	 *  
	 * Wanted pivot elements are
	 * - all elements in all libraries
	 * - all elements locked via MetaModelManager.addLockedElement()
	 * - all elements transitively in/referenced from the above
	 * - all elements referenced by incoming CS resources
	 * - all elements in all incoming pivot resources
	 * - except pivot resources mapped to incoming CS resources
	 *     this is what we're cleaning up
	 */
	public void garbageCollect(@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap) {
//		org.eclipse.ocl.examples.pivot.Class orphanClass = metaModelManager.getOrphanClass();
//		org.eclipse.ocl.examples.pivot.Package orphanPackage = metaModelManager.getOrphanPackage();
//		Resource orphanResource = orphanPackage.eResource();
		final Collection<Notifier> prunableResources = new ArrayList<Notifier>(cs2pivotResourceMap.values());
//		prunableResources.add(orphanResource);
		Collection<Notifier> allPivotResources = new ArrayList<Notifier>(metaModelManager.getPivotResourceSet().getResources());
//		allPivotResources.removeAll(prunableResources);					// Dead elements in orphanage or pivot of CS can be pruned
		EObject lockingObject = metaModelManager.getLockingObject();
		if (lockingObject != null) {
			allPivotResources.add(lockingObject);						// Locked elements are not dead
		}
		allPivotResources.addAll(metaModelManager.getLibraries());			// Library elements are not dead
		allPivotResources.addAll(cs2pivotResourceMap.keySet());			// Incoming elements are not dead
		allPivotResources.remove(metaModelManager.getOrphanage().eResource());
		@SuppressWarnings("serial")
		Map<EObject, Collection<Setting>> referencesToOrphans = new EcoreUtil.CrossReferencer(allPivotResources)
		{
			{ crossReference(); }
			@Override
			protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
				Resource eResource = crossReferencedEObject.eResource();
				boolean isPrunable = prunableResources.contains(eResource);
//				if (isPrunable && prunableResources.contains(eObject.eResource())) {
//					PivotUtil.debugObjectUsage("prunable xref ", crossReferencedEObject);
//					PivotUtil.debugObjectUsage(" from " + eReference.getName() + " ", eObject);
//				}
//				else {
//					PivotUtil.debugObjectUsage("unprunable xref ", crossReferencedEObject);
//					PivotUtil.debugObjectUsage(" from " + eReference.getName() + " ", eObject);
//				}
				return isPrunable;
			}

			@Override
			protected void handleCrossReference(EObject eObject) {
				try {
					super.handleCrossReference(eObject);
				    InternalEObject internalEObject = (InternalEObject)eObject;
					for (EObject eContent : eObject.eContents()) {
						EReference eReference = (EReference) eContent.eContainingFeature();
				        add(internalEObject, eReference, eContent);
					}
				}
				catch (Exception e) {}
			}
			
			@Override
			protected boolean resolve() {
				return false;		// Don't start creating specializations to resolve proxies
			}
		};
		Set<EObject> wantedOrphans = new HashSet<EObject>();
		List<Map.Entry<EObject, Collection<EStructuralFeature.Setting>>> suspects = new ArrayList<Map.Entry<EObject, Collection<EStructuralFeature.Setting>>>();
		for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : referencesToOrphans.entrySet()) {
			EObject referencedOrphan = entry.getKey();
			Collection<EStructuralFeature.Setting> referencesToOrphan = entry.getValue();
			boolean wantIt = false;
			for (EStructuralFeature.Setting setting : referencesToOrphan) {
				EObject eObject = setting.getEObject();
				Resource eResource = eObject.eResource();
				if (!prunableResources.contains(eResource)) {
//					PivotUtil.debugObjectUsage("externally refd ", referencedOrphan);
					wantedOrphans.add(referencedOrphan);
					wantIt = true;
					break;
				}
			}
			if (!wantIt) {
//				if ((referencedOrphan != orphanPackage) && (referencedOrphan != orphanClass)) {
//					PivotUtil.debugObjectUsage("externally unrefd ", referencedOrphan);
					suspects.add(entry);
//				}
//				else {
//					PivotUtil.debugObjectUsage("unkillable ", referencedOrphan);
//				}
			}
		}
		while (!suspects.isEmpty()) {
			List<Map.Entry<EObject, Collection<EStructuralFeature.Setting>>> oldSuspects = suspects;
			suspects = new ArrayList<Map.Entry<EObject, Collection<EStructuralFeature.Setting>>>();
			for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : oldSuspects) {
				EObject referencedOrphan = entry.getKey();
				Collection<EStructuralFeature.Setting> referencesToOrphan = entry.getValue();
				boolean wantIt = false;
				for (EStructuralFeature.Setting setting : referencesToOrphan) {
					EObject eObject = setting.getEObject();
					if (wantedOrphans.contains(eObject)) {
//						PivotUtil.debugObjectUsage(pass + " internally refd ", referencedOrphan);
//						PivotUtil.debugObjectUsage("     by ", eObject);
						wantedOrphans.add(referencedOrphan);
						wantIt = true;
						break;
					}
				}
				if (!wantIt) {
//					PivotUtil.debugObjectUsage(pass + " internally unrefd ", referencedOrphan);
					suspects.add(entry);
				}
			}
			if (oldSuspects.size() <= suspects.size()) {
				break;
			}
		}
		for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : suspects) {
			EObject referencedOrphan = entry.getKey();
			boolean wantIt = false;
			for (EObject eChild : referencedOrphan.eContents()) {		// FIXME this avoids a loss of the Ecore part of a Complete OCL resource
				if (wantedOrphans.contains(eChild)) {					//  surely an earlier containment want search should have found this
					wantIt = true;
					break;
				}
			}
			if (!wantIt) {
//				PivotUtil.debugObjectUsage("kill ", referencedOrphan);
				Collection<EStructuralFeature.Setting> referencesToOrphan = entry.getValue();
				if (referencesToOrphan != null) {
					for (EStructuralFeature.Setting setting : referencesToOrphan) {
						EObject eObject = setting.getEObject();
						EStructuralFeature eStructuralFeature = setting.getEStructuralFeature();
						if (!eStructuralFeature.isDerived()) {
//							PivotUtil.debugObjectUsage(" non-derived " + eStructuralFeature.getEContainingClass().getName() + "::" + eStructuralFeature.getName() + " : ", eObject);
							if (eStructuralFeature.isMany()) {
								@SuppressWarnings("unchecked")
								Collection<Object> list = (Collection<Object>) eObject.eGet(eStructuralFeature);
								list.remove(referencedOrphan);
							}
							else {
								eObject.eSet(eStructuralFeature, null);
							}
						}
						else {
//							PivotUtil.debugObjectUsage(" derived " + eStructuralFeature.getEContainingClass().getName() + "::" + eStructuralFeature.getName() + " : ", eObject);
//							System.out.println("  derived " + eObject.getClass().getName() + "@" + eObject.hashCode() + " " + eStructuralFeature.getName());
						}
					}
				}
				EObject eContainer = referencedOrphan.eContainer();
				if (eContainer != null) {
					PivotUtil.debugObjectUsage("  container ", eContainer);
					referencedOrphan.eSet(referencedOrphan.eContainingFeature(), null);
				}
//WIP			metaModelManager.kill(referencedOrphan);
			}
		}
//		for (MonikeredElement element : oldMoniker2PivotMap.values()) {
//			if (element.eResource() == null) {
//				PivotUtil.debugObjectUsage("Final Old residue ", element);
				// This is a bit late: a notification of non-containment would be sharper.
//				metaModelManager.kill(element);
//			}
//		}
//		for (MonikeredElement element : newMoniker2PivotMap.values()) {
//			if (element.eResource() == null) {
//				PivotUtil.debugObjectUsage("Final New residue ", element);
//			}
//		}
//		for (Type orphanType : orphanPackage.getOwnedType()) {
//			if (!PivotUtil.debugWellContainedness(orphanType)) {
//				for (Setting setting : referencesToOrphans.get(orphanType)) {
//					PivotUtil.debugObjectUsage("Dangling reference " + setting.getEStructuralFeature().getName() + " ", setting.getEObject());				
//				}
//			}
//		}
	}

	protected void gatherNewPackage(@NonNull Set<org.eclipse.ocl.examples.pivot.Package> newPackages, @NonNull EObject pivot) {
		if (pivot instanceof org.eclipse.ocl.examples.pivot.Package) {
			newPackages.add((org.eclipse.ocl.examples.pivot.Package)pivot);
		}
		EObject eContainer = pivot.eContainer();
		if (eContainer != null) {
			gatherNewPackage(newPackages, eContainer);
		}
	}

	/**
	 * Add any packages and nested packages pivoted by csResource to newPackages. This
	 * is invoked at the end of an update to identify redundant packages. 
	 */
	protected void gatherNewPackages(@NonNull Set<org.eclipse.ocl.examples.pivot.Package> newPackages, @NonNull Resource csResource) {
		for (TreeIterator<EObject> tit = csResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Pivotable) {
				Element pObject = ((Pivotable)eObject).getPivot();
				if (pObject instanceof org.eclipse.ocl.examples.pivot.Package) {
					gatherNewPackage(newPackages, pObject);
				}
				else if (pObject instanceof Root) {
					gatherNewPackage(newPackages, pObject);
				}
				else {		// CompleteOCL has package references from non-package contexts
					if (pObject instanceof Type) {
						gatherNewPackage(newPackages, pObject);
					}
					else if (pObject instanceof Operation) {
						gatherNewPackage(newPackages, pObject);
					}
					else if (pObject instanceof Property) {
						gatherNewPackage(newPackages, pObject);
					}
					tit.prune();
				}
				if (eObject instanceof MorePivotable) {  // CompleteOCL has package references from non-package contexts
					for (Element pivot : ((MorePivotable)eObject).getMorePivots()) {
						if (pivot != null) {
							gatherNewPackage(newPackages, pivot);
						}
					}
				}
			}
		}	
	}

	/**
	 * Add any packages and nested packages in eObjects to oldPackages. This
	 * is invoked at the start of an update to cache the packages for re-use. 
	 */
	protected void gatherOldPackages(@NonNull List<? extends org.eclipse.ocl.examples.pivot.Package> pkgs) {
		for (org.eclipse.ocl.examples.pivot.Package pkg : pkgs) {
			String name = pkg.getName();
			if (name == null) {
				name = PivotConstants.NULL_ROOT;
			}
			String qualifiedName = getQualifiedName(new StringBuilder(), pkg);
			org.eclipse.ocl.examples.pivot.Package oldPkg = oldPackagesByQualifiedName.put(qualifiedName, pkg);
			if (oldPkg != null) {
				logger.warn("Duplicate qualified package name: " + qualifiedName);
			}
			if (name.equals(qualifiedName)) {
				oldPkg = oldPackagesByName.put(name, pkg);
				if ((oldPkg != null) && name.equals(getQualifiedName(new StringBuilder(), oldPkg))) {
					logger.warn("Duplicate unqualified package name: " + qualifiedName);
				}
			}
			else {
				oldPkg = oldPackagesByName.get(name);
				if (oldPkg == null) {
					oldPackagesByName.put(name, pkg);
				}
			}
			@SuppressWarnings("null") @NonNull List<org.eclipse.ocl.examples.pivot.Package> nestedPackage = pkg.getNestedPackage();
			gatherOldPackages(nestedPackage);
		}
	}
	
	public final @NonNull CS2Pivot getConverter() {
		return converter;
	}

	@SuppressWarnings("unchecked")
	public <T> T getIntermediate(@NonNull CacheKey<T> key) {
		return (T) intermediateCache.get(key);
	}

	public @Nullable org.eclipse.ocl.examples.pivot.Package getOldPackageByQualifiedName(@NonNull PackageCS csElement) {
		String qualifiedName = getQualifiedName(new StringBuilder(), csElement);
		return oldPackagesByQualifiedName.get(qualifiedName);
	}

	public @Nullable org.eclipse.ocl.examples.pivot.Package getOldPackageBySimpleName(@NonNull String name) {
		return oldPackagesByName.get(name);
	}

	protected @NonNull String getQualifiedName(@NonNull StringBuilder s, @NonNull org.eclipse.ocl.examples.pivot.Package pkg) {
		org.eclipse.ocl.examples.pivot.Package nestingPackage = pkg.getNestingPackage();
		if (nestingPackage != null) {
			getQualifiedName(s, nestingPackage);
			s.append("$$");
		}
		String name = pkg.getName();
		if (name == null) {
			name = PivotConstants.NULL_ROOT;
		}
		s.append(name);
		@SuppressWarnings("null") @NonNull String string = s.toString();
		return string;
	}
	
	protected @NonNull String getQualifiedName(@NonNull StringBuilder s, @NonNull PackageCS csPackage) {
		EObject eContainer = csPackage.eContainer();
		if (eContainer instanceof PackageCS) {
			getQualifiedName(s, (PackageCS) eContainer);
			s.append("$$");
		}
		String name = csPackage.getName();
		if (name == null) {
			name = PivotConstants.NULL_ROOT;
			if (eContainer == null) {
				Resource csResource = csPackage.eResource();
				if (csResource != null) {
					URI csURI = csResource.getURI();
					if (csURI != null) {
						name = csURI.lastSegment();
					}
				}
			}
		}
		s.append(name);
		@SuppressWarnings("null") @NonNull String string = s.toString();
		return string;
	}

	protected @NonNull List<TemplateBindingCS> getTemplateBindings(@NonNull ElementCS csElement) {
		List<TemplateBindingCS> csTemplateBindings;
//		EObject container = csElement.eContainer();
//		if (container instanceof ElementCS) {			
//			csTemplateBindings = getTemplateBindings((ElementCS) container);
//		}
//		else {
			csTemplateBindings = new ArrayList<TemplateBindingCS>();
//		}
		if (csElement instanceof TypedTypeRefCS) {
			TypedTypeRefCS csTemplateableElement = (TypedTypeRefCS)csElement;
			TemplateBindingCS csTemplateBinding = csTemplateableElement.getOwnedTemplateBinding();
			if (csTemplateBinding != null) {
				csTemplateBindings.add(csTemplateBinding);
			}
		}
		return csTemplateBindings;
	}
	
	protected @NonNull List<TemplateSignature> getTemplateSignatures(@NonNull Element pivotElement) {
		List<TemplateSignature> pivotTemplateSignatures;
		EObject container = pivotElement.eContainer();
		if (container instanceof Element) {			
			pivotTemplateSignatures = getTemplateSignatures((Element) container);
		}
		else {
			pivotTemplateSignatures = new ArrayList<TemplateSignature>();
		}
		if (pivotElement instanceof TemplateableElement) {
			TemplateableElement templateableElement = (TemplateableElement)pivotElement;
			TemplateSignature templateSignature = templateableElement.getOwnedTemplateSignature();
			if (templateSignature != null) {
				pivotTemplateSignatures.add(templateSignature);
			}
		}
		return pivotTemplateSignatures;
	}

	public @NonNull InterDependency<TemplateSignatureContinuation> getTypesHaveSignaturesInterDependency() {
		return typesHaveSignatures;
	}

	public void handleVisitNamedElement(@NonNull NamedElementCS csNamedElement, @NonNull NamedElement pivotElement) {
		List<Annotation> pivotAnnotations = pivotElement.getOwnedAnnotation();
		List<AnnotationElementCS> csAnnotations = csNamedElement.getOwnedAnnotation();
//		if ((csAnnotations.size() <= 1) && (pivotAnnotations.size() <= 1)) {
			refreshPivotList(Annotation.class, pivotAnnotations, csAnnotations);
/*		}
		else {
			HashSet<String> names = new HashSet<String>();
			HashMap<String, List<Annotation>> pivotMap = new HashMap<String, List<Annotation>>();
			HashMap<String, List<AnnotationElementCS>> csMap = new HashMap<String, List<AnnotationElementCS>>();
			for (Annotation pivotAnnotation : pivotAnnotations) {
				String name = pivotAnnotation.getName();
				names.add(name);
				List<Annotation> pivotList = pivotMap.get(name);
				if (pivotList == null) {
					pivotList = new ArrayList<Annotation>();
					pivotMap.put(name, pivotList);
				}
				pivotList.add(pivotAnnotation);
			}
			for (AnnotationElementCS csAnnotation : csAnnotations) {
				String name = csAnnotation.getName();
				names.add(name);
				List<AnnotationElementCS> csList = csMap.get(name);
				if (csList == null) {
					csList = new ArrayList<AnnotationElementCS>();
					csMap.put(name, csList);
				}
				csList.add(csAnnotation);
			}
			for (String name : names) {
				List<Annotation> pivotList = pivotMap.get(name);
				List<AnnotationElementCS> csList = csMap.get(name);
//				refreshPivotList(Annotation.class, pivotAnnotations, csAnnotations);
				List<Annotation> newPivotAnnotations = new ArrayList<Annotation>();
				for (ModelElementCS csElement : csList) {
					Annotation pivotAnnotation = getPivotElement(Annotation.class, csElement);
					assert pivotAnnotation != null;
					if (pivotElement != null) {
						newPivotAnnotations.add(pivotAnnotation);
					}
				}
				refreshList(pivotAnnotations, newPivotAnnotations);
			}
		} */
	}

	public void installPivotReference(@NonNull ElementRefCS csElement, @NonNull Element newPivotElement, /*@NonNull*/ EReference eReference) {
		assert eReference != null;
		converter.installPivotReference(csElement, newPivotElement, eReference);
	}
	
	public void installPivotUsage(@NonNull ModelElementCS csElement, @NonNull Element newPivotElement) {
		converter.installPivotUsage(csElement, newPivotElement);
	}

	protected void installRootContents(@NonNull Resource csResource) {	// FIXME This code is no longer needed; delete once QVTd checked
		for (EObject eObject : csResource.getContents()) {
			if (eObject instanceof Pivotable) {
				Element pivotElement = ((Pivotable)eObject).getPivot();
				if (pivotElement != null) {
					Resource pivotResource = pivotElement.eResource();
					if (pivotResource == null) {
						installRootElement(csResource, pivotElement);
					}
				}
			}
		}
	}

	public void installRootElement(@NonNull Resource csResource, @NonNull Element pivotElement) {
		Resource pivotResource = converter.getPivotResource(csResource);
		if (pivotResource != null) {
			pivotResource.getContents().add(pivotElement);
			metaModelManager.installResource(pivotResource);
		}
	}

	/**
	 * Invoke all of the continuations that can execute, returning the list of
	 * continuations till to perform, some of which may be ones that were
	 * blocked by unsatisfied dependencies, others of which may be further
	 * continuations resulting from only partial progress. Returns null if
	 * none of the continuations could execute.
	 * 
	 * @param continuations
	 * @return continuations still to perform, null if stuck.
	 */
	protected @Nullable List<BasicContinuation<?>> progressContinuations(@NonNull List<BasicContinuation<?>> continuations) {
		List<BasicContinuation<?>> moreContinuations = new ArrayList<BasicContinuation<?>>();
		boolean madeProgress = false;
		boolean tracingOn = CONTINUATION.isActive();
		if (tracingOn) {
			CONTINUATION.println("------------------------------------------------ " + continuations.size());
			CONTINUATION.println(typesHaveSignatures.toString());
		}
		for (BasicContinuation<?> continuation : continuations) {
			boolean canExecute = continuation.canExecute();
			if (tracingOn) {
				CONTINUATION.println((canExecute ? "+ " : "- ") + continuation);
			}
			if (canExecute) {
				madeProgress = true;
				BasicContinuation<?> nextContinuation = continuation.execute();
				if (nextContinuation != null) {
					nextContinuation.addTo(moreContinuations);
				}
			}
			else {
				moreContinuations.add(continuation);
			}
		}
		return madeProgress ? moreContinuations : null;
	}

	@SuppressWarnings("unchecked")
	public <T> T putIntermediate(CacheKey<T> key, T object) {
		return (T) intermediateCache.put(key, object);
	}

	public void refreshComments(Element pivotElement, ElementCS csElement) {
		ICompositeNode node = NodeModelUtils.getNode(csElement);
		if (node != null) {
			List<ILeafNode> documentationNodes = CS2Pivot.getDocumentationNodes(node);
			if (documentationNodes != null) {
				List<String> documentationStrings = new ArrayList<String>();
				for (ILeafNode documentationNode : documentationNodes) {
					String text = documentationNode.getText();
					int startIndex = text.startsWith("/**") ? 3 : 0;
					int endIndex = text.length() - (text.endsWith("*/") ? text.endsWith("**/") ? 3 : 2 : 0);
					if (startIndex < endIndex) {
						documentationStrings.add(text.substring(startIndex, endIndex).trim());
					}
				}
				List<Comment> ownedComments = pivotElement.getOwnedComment();
				int iMax = Math.min(documentationStrings.size(), ownedComments.size());
				int i = 0;
				for (; i < iMax; i++) {
					String string = documentationStrings.get(i);
					if (string != null) {
						String trimmedString = trimComments(string);
						Comment comment = ownedComments.get(i);
						if (!trimmedString.equals(comment.getBody())) {
							comment.setBody(trimmedString);
						}
					}
				}
				for ( ; i < documentationStrings.size(); i++) {
					String string = documentationStrings.get(i);
					if (string != null) {
						String trimmedString = trimComments(string);
						Comment comment = PivotFactory.eINSTANCE.createComment();
						comment.setBody(trimmedString);
						ownedComments.add(comment);
					}
				}
				while (i < ownedComments.size()) {
					ownedComments.remove(ownedComments.size()-1);
				}
			}
		}
	}

	public <T extends Element> void refreshList(@NonNull Class<T> pivotClass, List<T> pivotElements, /*@NonNull*/ List<? extends PivotableElementCS> csElements) {
		assert csElements != null;
		if (!pivotElements.isEmpty() ||!csElements.isEmpty()) {
			List<T> newPivotElements = new ArrayList<T>();
			for (PivotableElementCS csElement : csElements) {
				T pivotElement = PivotUtil.getPivot(pivotClass, csElement);
				if ((pivotElement == null) && (csElement instanceof ModelElementCS)) {
					pivotElement = converter.getPivotElement(pivotClass, (ModelElementCS)csElement);
				}
				if ((pivotElement != null) && !newPivotElements.contains(pivotElement)) {		// OclInvalid can be prolific
					newPivotElements.add(pivotElement);
				}
			}
			PivotUtil.refreshList(pivotElements, newPivotElements);
		}
	}

	/**
	 * Return a pivotEClass instance cast to pivotClass registered for csElement.getCSI().
	 * <p>An existing element is re-used else an new instance is created.
	 * <p>The pivot element is installed as the original object of csElement. 
	 * @param <T>
	 * @param pivotClass
	 * @param pivotEClass
	 * @param csElement
	 * @return
	 */
	public @Nullable <T extends Element> T refreshModelElement(@NonNull Class<T> pivotClass, /*@NonNull*/ EClass pivotEClass, @Nullable ModelElementCS csElement) {
		assert pivotEClass != null;
		return converter.refreshModelElement(pivotClass, pivotEClass, csElement);
	}

	public <T extends Element> void refreshPivotList(@NonNull Class<T> pivotClass, /*@NonNull*/ List<? super T> pivotElements,
			/*@NonNull*/ List<? extends ModelElementCS> csElements) {
		assert pivotElements != null;
		assert csElements != null;
		if (pivotElements.isEmpty() && csElements.isEmpty()) {
			return;
		}
		List<T> newPivotElements = new ArrayList<T>();
		for (ModelElementCS csElement : csElements) {
			T pivotElement = PivotUtil.getPivot(pivotClass, csElement);
			if (pivotElement != null) {
				newPivotElements.add(pivotElement);
			}
		}
		PivotUtil.refreshList(pivotElements, newPivotElements);
	}

	public void refreshTemplateSignature(@NonNull TemplateableElementCS csTemplateableElement, @NonNull TemplateableElement pivotTemplateableElement) {
		TemplateSignatureCS csTemplateSignature = csTemplateableElement.getOwnedTemplateSignature();
		if (csTemplateSignature == null) {
			if (pivotTemplateableElement.getOwnedTemplateSignature() != null) {
				pivotTemplateableElement.setOwnedTemplateSignature(null);
			}
			return;
		}
		TemplateSignature pivotTemplateSignature = PivotUtil.getPivot(TemplateSignature.class, csTemplateSignature);
		if (pivotTemplateableElement.getOwnedTemplateSignature() != pivotTemplateSignature) {
			pivotTemplateableElement.setOwnedTemplateSignature(pivotTemplateSignature);
		}
	}

	protected void resetPivotMappings(@NonNull Collection<? extends Resource> csResources) {
		for (Resource csResource : csResources) {
			for (TreeIterator<EObject> tit = csResource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof Pivotable) {
					Pivotable pivotable = (Pivotable)eObject;
//					Element pivot = pivotable.getPivot();
					pivotable.resetPivot();
				}				
			}
		}
	}

	public void setReferredIteration(@NonNull LoopExp expression, @Nullable Iteration iteration) {
		expression.setReferredIteration(iteration);
	}

	public void setReferredOperation(@NonNull OperationCallExp expression, @Nullable Operation operation) {
		expression.setReferredOperation(operation);
	}

	/**
	 * Update a list of TemplateBinding to match a list of TemplateSignature
	 * by moving/adding/removing existing entries. Once matched each TemplateBinding.signature
	 * references the corresponding TemplateSignature, and each TemplateBinding.parameterSubstitution.formal
	 * references the corresponding TemplateSignature.ownedParameter.
	 * 
	 * @param templateBindings
	 * @param templateSignatures
	 */
	protected void specializeTemplateBindings(@NonNull List<TemplateBinding> templateBindings, @NonNull List<TemplateSignature> templateSignatures, @NonNull List<TemplateBindingCS> csTemplateBindings) {
		int csIMax = csTemplateBindings.size();
		int pivotIMax = templateSignatures.size();
		if (csIMax != pivotIMax) {
			TypedTypeRefCS owningTemplateBindableElement = csTemplateBindings.get(0).getOwningTemplateBindableElement();
			String string = owningTemplateBindableElement != null ? CS2Moniker.toString(owningTemplateBindableElement) : "<null>";
			logger.warn("Inconsistent template bindings size for " + string); //$NON-NLS-1$
		}
		int newMax = Math.min(csIMax, pivotIMax);
		for (int i = 0; i < newMax; i++) {					// Invariant: lists are equal up to index i
			TemplateBindingCS csTemplateBinding = csTemplateBindings.get(i);
			if (csTemplateBinding != null) {
				TemplateSignature templateSignature = templateSignatures.get(i);
				int oldMax = templateBindings.size();
				TemplateBinding templateBinding = null;;
				for (int j = i; j < oldMax; j++) {
					TemplateBinding oldTemplateBinding = templateBindings.get(j);
					if (oldTemplateBinding.getSignature() == templateSignature) {
						if (j != i) {
							templateBindings.add(i, templateBindings.remove(j));
						}
						templateBinding = oldTemplateBinding;
	//					registerPivotElement(csTemplateBinding, templateBinding);
	//					installPivotElement(csTemplateBinding, templateBinding);
						break;
					}
				}
				if (templateBinding == null) {
	//				templateBinding = refreshElement(TemplateBinding.class, PivotPackage.Literals.TEMPLATE_BINDING, csTemplateBinding);
					templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
					templateBinding.setSignature(templateSignature);
					if (i < oldMax) {
						templateBindings.add(i, templateBinding);
					}
					else {
						templateBindings.add(templateBinding);					
					}
				}
				installPivotReference(csTemplateBinding, templateBinding, BaseCSTPackage.Literals.PIVOTABLE_ELEMENT_CS__PIVOT);
				@SuppressWarnings("null") @NonNull List<TemplateParameterSubstitution> parameterSubstitutions = templateBinding.getParameterSubstitution();
				@SuppressWarnings("null") @NonNull List<TemplateParameter> templateParameters = templateSignature.getOwnedParameter();
				@SuppressWarnings("null") @NonNull List<TemplateParameterSubstitutionCS> csParameterSubstitutions = csTemplateBinding.getOwnedParameterSubstitution();
				specializeTemplateParameterSubstitutions(parameterSubstitutions, templateParameters, csParameterSubstitutions);
				assert templateSignatures.get(i) == templateBindings.get(i).getSignature();
			}
		}
		for (int k = templateBindings.size(); k > newMax; ) {
			templateBindings.remove(--k);
		}
		assert templateSignatures.size() == templateBindings.size();
	}

	/**
	 * Update a list of TemplateParameterSubstitution to match a list of TemplateParameter
	 * by moving/adding/removing existing entries. Once matched each TemplateParameterSubstitution.formal
	 * references the corresponding TemplateParameter.
	 * @param eList 
	 * 
	 * @param templateSignature
	 * @param templateBinding
	 */
	protected void specializeTemplateParameterSubstitutions(@NonNull List<TemplateParameterSubstitution> templateParameterSubstitutions,
			@NonNull List<TemplateParameter> templateParameters, @NonNull List<TemplateParameterSubstitutionCS> csTemplateParameterSubstitutions) {
		int csIMax = csTemplateParameterSubstitutions.size();
		int pivotIMax = templateParameters.size();
		if (csIMax != pivotIMax) {
			logger.warn("Inconsistent template parameter substitutions size"); // FIXME //$NON-NLS-1$
		}
		int newMax = Math.min(csIMax, pivotIMax);
		for (int i = 0; i < newMax; i++) {					// Invariant: lists are equal up to index i
			TemplateParameterSubstitutionCS csTemplateParameterSubstitution = csTemplateParameterSubstitutions.get(i);
			TemplateParameter templateParameter = templateParameters.get(i);
			int oldMax = templateParameterSubstitutions.size();
			TemplateParameterSubstitution templateParameterSubstitution = null;
			for (int j = i; j < oldMax; j++) {
				TemplateParameterSubstitution oldTemplateParameterSubstitution = templateParameterSubstitutions.get(j);
				if (oldTemplateParameterSubstitution.getFormal() == templateParameter) {
					if (j != i) {
						templateParameterSubstitutions.add(i, templateParameterSubstitutions.remove(j));
					}
					templateParameterSubstitution = oldTemplateParameterSubstitution;
//					registerPivotElement(csTemplateParameterSubstitution, templateParameterSubstitution);
//					installPivotElement(csTemplateParameterSubstitution, templateParameterSubstitution);
					break;
				}
			}
			if (templateParameterSubstitution == null) {
//				templateParameterSubstitution = refreshElement(TemplateParameterSubstitution.class, PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION, csTemplateParameterSubstitution);
				templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
				templateParameterSubstitution.setFormal(templateParameter);
				if (i < oldMax) {
					templateParameterSubstitutions.add(i, templateParameterSubstitution);
				}
				else {
					templateParameterSubstitutions.add(templateParameterSubstitution);
				}
			}
			TypeRefCS csActualParameter = csTemplateParameterSubstitution.getOwnedActualParameter();
			if (csActualParameter instanceof WildcardTypeRefCS) {
				ParameterableElement pivotActualParameter = templateParameterSubstitution.getOwnedActual();
				if (pivotActualParameter == null) {
					pivotActualParameter = PivotFactory.eINSTANCE.createClass();
					templateParameterSubstitution.setOwnedActual(pivotActualParameter);
				}
				String name = PivotConstants.WILDCARD_NAME;
				if (i > 1) {
					name += i;
				}
				((NamedElement)pivotActualParameter).setName(name);
			}
			else {
				ParameterableElement pivotActualParameter = PivotUtil.getPivot(ParameterableElement.class, csActualParameter);
				templateParameterSubstitution.setActual(pivotActualParameter);
			}
//			installPivotElement(csTemplateParameterSubstitution, templateParameterSubstitution);
//			queueResolver(csTemplateParameterSubstitution);		// To resolve actuals
			assert templateParameters.get(i) == templateParameterSubstitutions.get(i).getFormal();
		}
		for (int k = templateParameterSubstitutions.size(); k > newMax; ) {
			templateParameterSubstitutions.remove(--k);
		}
		assert templateParameters.size() == templateParameterSubstitutions.size();
	}

	protected @Nullable TemplateableElement specializeTemplates(@NonNull TypedTypeRefCS csElement) {
		TemplateBindingCS ownedTemplateBinding = csElement.getOwnedTemplateBinding();
		assert ownedTemplateBinding != null;
		Type unspecializedPivotElement = csElement.getType();
//		logger.trace("Specializing " + moniker); //$NON-NLS-1$
		if ((unspecializedPivotElement == null) || unspecializedPivotElement.eIsProxy()) {
			String moniker = CS2Moniker.toString(csElement);
			logger.error("Nothing to specialize as " + moniker); //$NON-NLS-1$
			return null;
		}
/*WIP		List<Type> templateArguments = new ArrayList<Type>();
		for (TemplateParameterSubstitutionCS tps : ownedTemplateBinding.getOwnedParameterSubstitution()) {
			Type templateArgument = PivotUtil.getPivot(Type.class, tps.getOwnedActualParameter());
			templateArguments.add(templateArgument);
		}
		TemplateSignature templateSignature = unspecializedPivotElement.getOwnedTemplateSignature();
		List<TemplateParameter> templateParameters = templateSignature != null ? templateSignature.getParameter() : Collections.<TemplateParameter>emptyList();
		boolean isUnspecialized = PivotUtil.isUnspecialized(templateParameters, templateArguments);	// WIP
		if (isUnspecialized) {
//			int iMax = templateParameters.size();
//			assert templateArguments.size() == iMax;
//			for (int i = 0; i < iMax; i++) {
//				reusePivotElement(ownedTemplateBinding.getOwnedParameterSubstitution().get(i), templateParameters.get(i).getParameteredElement());
//			}
			reusePivotElement(csElement, unspecializedPivotElement);
			return unspecializedPivotElement;
		} */
		//
		//	Refresh the pivot specialization root
		//
		Type specializedPivotElement = PivotUtil.getPivot(Type.class, csElement);
		if (specializedPivotElement == null) {
			List<Type> templateArguments = new ArrayList<Type>();
			for (TemplateParameterSubstitutionCS csTemplateParameterSubstitution : ownedTemplateBinding.getOwnedParameterSubstitution()) {
				Type templateArgument = PivotUtil.getPivot(Type.class, csTemplateParameterSubstitution.getOwnedActualParameter());
				templateArguments.add(templateArgument);
			}
			specializedPivotElement = metaModelManager.getLibraryType(unspecializedPivotElement, templateArguments);
/*			EClass eClass = unspecializedPivotElement.eClass();
			@SuppressWarnings("unchecked")
			Class<? extends Type> pivotClazz = (Class<? extends Type>) eClass.getInstanceClass();
			Type pivotClass = converter.refreshReferencedElement(pivotClazz, eClass, csElement, BaseCSTPackage.Literals.MODEL_ELEMENT_CS__PIVOT);
			refreshName(pivotClass, unspecializedPivotElement.getName());
			specializedPivotElement = pivotClass;
			if (pivotClass instanceof CollectionType) {
				Type elementType = PivotUtil.getPivot(Type.class, ownedTemplateBinding.getOwnedParameterSubstitution().get(0).getOwnedActualParameter());
				((CollectionType)pivotClass).setElementType(elementType);
			}
			else if (pivotClass instanceof ClassifierType) {
				Type instanceType = PivotUtil.getPivot(Type.class, ownedTemplateBinding.getOwnedParameterSubstitution().get(0).getOwnedActualParameter());
				((ClassifierType)pivotClass).setInstanceType(instanceType);
			}
			specializedPivotElement.setUnspecializedElement(unspecializedPivotElement);
//WIP			metaModelManager.addOrphanClass(specializedPivotElement); */
		}
		installPivotReference(csElement, specializedPivotElement, BaseCSTPackage.Literals.TYPED_TYPE_REF_CS__TYPE);
		if (specializedPivotElement != unspecializedPivotElement) {
			//
			//	Refresh the pivot specialization bindings and parameter substitutions
			//
			@SuppressWarnings("null") @NonNull List<TemplateBinding> templateBindings = specializedPivotElement.getTemplateBinding();
			List<TemplateSignature> templateSignatures = getTemplateSignatures(unspecializedPivotElement);
			List<TemplateBindingCS> csTemplateBindings = getTemplateBindings(csElement);
			specializeTemplateBindings(templateBindings, templateSignatures, csTemplateBindings);
		}
		return specializedPivotElement;
	}

	/**
	 * Remove the internal "* " that may result from a comment formatted in the style of this comment.
	 * 
	 * @param string
	 * @return
	 */
	protected @NonNull String trimComments(@NonNull String string) {
		String[] strings = string.trim().split("\n");
		boolean isFormatted = true;
		for (int i = 0; i < strings.length; i++) {
			String line = strings[i];
			String trimmedLine = line.trim();
			if (trimmedLine.startsWith("*")) {
				if (trimmedLine.length() > 1) {
					if (!Character.isWhitespace(trimmedLine.charAt(1))) {
						isFormatted = false;
						break;
					}
				}
			}
			else if (i > 0) {
				isFormatted = false;
				break;
			}
		}
		StringBuilder s = new StringBuilder();
		for (String line : strings) {
			String trimmedLine = line.trim();
			if (!isFormatted) {
			}
			else if (trimmedLine.length() <= 1) {
				trimmedLine = "";
			}
			else if (Character.isWhitespace(trimmedLine.charAt(1))) {
				trimmedLine = trimmedLine.substring(2);			
			}
			if (s.length() > 0) {
				s.append("\n");
			}
			s.append(trimmedLine);
		}
		@SuppressWarnings("null") @NonNull String trimmedString = s.toString();
		return trimmedString;
	}

	/**
	 * Sequence the update passes to make the pivot match the CS.
	 * @param csResources 
	 */
	public boolean update() {
		resetPivotMappings(csResources);
		oldPackagesByName = new HashMap<String, org.eclipse.ocl.examples.pivot.Package>();
		oldPackagesByQualifiedName = new HashMap<String, org.eclipse.ocl.examples.pivot.Package>();
		for (Resource resource : converter.cs2pivotResourceMap.values()) {
			for (EObject eObject : resource.getContents()) {
				if (eObject instanceof Root) {
					@SuppressWarnings("null") @NonNull List<org.eclipse.ocl.examples.pivot.Package> nestedPackage = ((Root)eObject).getNestedPackage();
					gatherOldPackages(nestedPackage);
				}
			}
		}
		List<BasicContinuation<?>> continuations = new ArrayList<BasicContinuation<?>>();
		//
		//	Perform the post-order containment traversal to:
		//
		//	Create the Piviotable.pivot elements for all 1:1 CS to pivot relationships.
		//	Create the parent-child containment hierarchy.
		//	Configure derived CS properties such as PathNameCS.elementType
		//	Queue continuations to compute simple references
		//
		//	The containment pass may only access the pivot elements of immediate children.
		//
		for (Resource csResource : csResources) {
			for (EObject eObject : csResource.getContents()) {
				if (eObject != null) {
					visitContainment(eObject, continuations);
				}
			}
		}
		while (continuations.size() > 0) {
			List<BasicContinuation<?>> moreContinuations = progressContinuations(continuations);
			if (moreContinuations == null) {
				boolean hasNoErrors = checkForNoErrors(csResources);
				if (!hasNoErrors) {
					return false;
				}
				diagnoseContinuationFailure(continuations);
				break;
			}
			continuations = moreContinuations;
		}
		//
		//	Put all orphan root pivot elements in their resources.
		//
		for (Resource csResource : csResources) {
			if (csResource != null) {
				installRootContents(csResource);
			}
		}
		//
		//	Perform the pre-order traversal to resolve specializations and references.
		//
		for (Resource csResource : csResources) {
			for (EObject eObject : csResource.getContents()) {
				if (eObject != null) {
					visitInPreOrder(eObject, continuations);
				}
			}
		}
		//
		//	Perform pre-order continuations to establish package, class containment and classifier template signatures.
		//
//		Collections.reverse(continuations);
		while (continuations.size() > 0) {
			List<BasicContinuation<?>> moreContinuations = progressContinuations(continuations);
			if (moreContinuations == null) {
				boolean hasNoErrors = checkForNoErrors(csResources);
				if (!hasNoErrors) {
					return false;
				}
				diagnoseContinuationFailure(continuations);
				break;
			}
			continuations = moreContinuations;
		}
		//
		//	Load the library. 
		//
		@SuppressWarnings("unused")
		AnyType oclAnyType = metaModelManager.getOclAnyType();
		//
		//	Perform the post-order traversal to create and install the bulk of non-package/class
		//	elements.
		//
		for (Resource csResource : csResources) {
			for (EObject eObject : csResource.getContents()) {
				if (eObject != null) {
					visitInPostOrder(eObject, continuations);
				}
			}
		}
		boolean hasNoErrors = checkForNoErrors(csResources);
		if (!hasNoErrors) {
			return false;
		}
		//
		//	Perform post-order continuations to establish complex dependencies.
		//
		while (continuations.size() > 0) {
			List<BasicContinuation<?>> moreContinuations = progressContinuations(continuations);
			if (moreContinuations == null) {
				diagnoseContinuationFailure(continuations);
				break;
			}
			continuations = moreContinuations;
		}
		//
		//	Put all orphan root pivot elements in their resources.
		//
		for (Resource csResource : csResources) {
			if (csResource != null) {
				installRootContents(csResource);		// FIXME ExpressionInOCL very late
			}
		}
		//
		//	Resolve UnspecifiedTypes
		//
		resolveUnderspecifiedTypes();
		boolean hasNoMoreErrors = checkForNoErrors(csResources);
		if (!hasNoMoreErrors) {
			return false;
		}
		//
		//	Prune obsolete packages
		//
		Set<org.eclipse.ocl.examples.pivot.Package> newPackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
		for (Resource csResource : csResources) {
			if (csResource != null) {
				gatherNewPackages(newPackages, csResource);
			}
		}
		Set<org.eclipse.ocl.examples.pivot.Package> obsoletePackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>(oldPackagesByQualifiedName.values());
//		for (org.eclipse.ocl.examples.pivot.Package oldPackage : obsoletePackages) {
//			System.out.println("Old package @" + Integer.toHexString(oldPackage.hashCode()) + " " + oldPackage.eResource().getURI() + " " + oldPackage.getName());
//		}
//		for (org.eclipse.ocl.examples.pivot.Package newPackage : newPackages) {
//			System.out.println("New package @" + Integer.toHexString(newPackage.hashCode()) + " " + newPackage.eResource().getURI() + " " + newPackage.getName());
//		}
		obsoletePackages.removeAll(newPackages);
		for (org.eclipse.ocl.examples.pivot.Package obsoletePackage : obsoletePackages) {
			EObject eContainer = obsoletePackage.eContainer();
			if (eContainer != null) {
				EReference eContainmentFeature = obsoletePackage.eContainmentFeature();
				if (eContainmentFeature.isMany()) {
					List<?> siblings = (List<?>) eContainer.eGet(eContainmentFeature);
//					System.out.println("Kill package @" + Integer.toHexString(obsoletePackage.hashCode()) + " " + obsoletePackage.eResource().getURI() + " " + obsoletePackage.getName());
					siblings.remove(obsoletePackage);
				}
				else {
					eContainer.eSet(eContainmentFeature, null);
				}
			}
		}
		return true;
	}

	protected void visitContainment(@NonNull EObject eObject, @NonNull List<BasicContinuation<?>> continuations) {
		for (EObject eContent : eObject.eContents()) {
			if (eContent != null) {
				visitContainment(eContent, continuations);
			}
		}
		Continuation<?> continuation = ((VisitableCS)eObject).accept(containmentVisitor);
		if (continuation != null) {
			continuation.addTo(continuations);
		}
	}

	public <T extends Element> T visitLeft2Right(@NonNull Class<T> pivotClass, @NonNull VisitableCS csObject) {
		assert csObject != null;
		Element element = csObject.accept(left2RightVisitor);
		if (element == null) {
			return null;
		}
		if (!pivotClass.isAssignableFrom(element.getClass())) {
			throw new ClassCastException(element.getClass().getName() + " is not assignable to " + pivotClass.getName());
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) element;
		return castElement;
	}

	protected void visitInPostOrder(@NonNull EObject eObject, @NonNull List<BasicContinuation<?>> continuations) {
		for (EObject eContent : eObject.eContents()) {
			if (eContent != null) {
				visitInPostOrder(eContent, continuations);
			}
		}
		Continuation<?> continuation = ((VisitableCS)eObject).accept(postOrderVisitor);
		if (continuation != null) {
			continuation.addTo(continuations);
		}
	}

	protected void visitInPreOrder(@NonNull EObject eObject, @NonNull List<BasicContinuation<?>> continuations) {
		Continuation<?> continuation = ((VisitableCS)eObject).accept(preOrderVisitor);
		if (continuation != null) {
			continuation.addTo(continuations);
		}
		for (EObject eContent : eObject.eContents()) {
			if (eContent != null) {
				visitInPreOrder(eContent, continuations);
			}
		}
	}
}
