/**
 * <copyright>
 * 
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 * 
 * The standalone functionality is heavily influenced by org.eclipse.emf.mwe.utils.StandaloneSetup.
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.examples.domain.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.impl.SingletonAdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.domain.compatibility.EMF_2_9;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * StandaloneProjectMap and {@link ProjectMap} provides facilities to assist in
 * preparing the {@link URIConverter} and the {@link EPackage.Registry} of a
 * {@link ResourceSet} and the global and
 * {@link EcorePlugin#getPlatformResourceMap()} and
 * {@link EcorePlugin#getEPackageNsURIToGenModelLocationMap} to support
 * arbitrary and compatible use of <tt>platform:/plugin</tt>,
 * <tt>platform:/resource</tt> and registered URIs in both plugin and standalone
 * environments.
 * <p>
 * StandaloneProjectMap supports only standalone usage and so is free of
 * dependencies on the Eclipse platform. ProjectMap extends StandaloneProjectMap
 * to provide polymorphic standalone and plugin environments.
 * <p>
 * As a result, when the current file context is my.project/model/MyModel.ecore,
 * and when the classpath contains only the JAR version of Ecore, referencing a
 * resource as any or all of
 * <ul>
 * <li>http://www.eclipse.org/emf/2002/Ecore</li>
 * <li>platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore</li>
 * <li>platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore</li>
 * <li>../../org.eclipse.emf.ecore/model/Ecore.ecore</li>
 * </ul>
 * results in the same Resource being returned by {@link
 * ResourceSet.getResource()}.
 * <p>
 * If the classpath contains distinct imported project and JAR versions of
 * Ecore, referencing
 * <ul>
 * <li>http://www.eclipse.org/emf/2002/Ecore</li>
 * </ul>
 * returns the JAR plugin version while referencing
 * <ul>
 * <li>platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore</li>
 * <li>platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore</li>
 * <li>../../org.eclipse.emf.ecore/model/Ecore.ecore</li>
 * </ul>
 * returns the imported project version.
 * <p>
 * A ProjectMap consists of a map from a project or bundle name to a location
 * that is resolvable by the conventional Platform URL stream opening
 * capabilities. Utility methods support export of the map to initialize the
 * URIMap in a {@link URIConverter} and/or the
 * {@link EcorePlugin#getPlatformResourceMap()}.
 * <p>
 * Minimal usage to configure <tt>aResourceSet</tt> is just <br>
 * <tt>new ProjectMap().initializeResourceSet(aResourceSet);</tt> <br>
 * or <tt>ProjectMap.getAdapter(aResourceSet);</tt> <br>
 * Thereafter EMF accesses to projects and bundles should just work.
 * 
 * <h4>Standalone Environment</h4>
 * 
 * A resolvable location is a physical location such as
 * <ul>
 * <li>
 * <tt>archive:file:/C:/Tools/Eclipse/3.7.1/plugins/org.antlr.runtime_3.2.0.v201101311130.jar!/</tt>
 * </li>
 * <li>
 * <tt>file:/C:/GIT/org.eclipse.ocl/examples/org.eclipse.ocl.examples.common/</tt>
 * </li>
 * </ul>
 * <p>
 * {@link #getProjectMap()} returns a map of project names and bundle names to a
 * physical location which is established by searching the classpath for folders
 * and JARs containing .project files. If a manifest is also found, the search
 * has found a bundle and the Bundle-SymbolicName is read from the manifest.
 * <p>
 * {@link #initializePackageRegistry(ResourceSet)} populates a trio of
 * registrations for each <tt>genPackages.ecorePackage</tt> referenced from a
 * <tt>genmodel</tt> referenced from a
 * <tt>org.eclipse.emf.ecore.generated_package</tt> defined in any
 * <tt>plugin.xml</tt> found on the classpath. The three declarations ensure
 * that when appropriate, each of the namespace URI (e.g.
 * <tt>http://www.eclipse.org/emf/2002/Ecore</tt>), the project URI (e.g.
 * <tt>platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore</tt>) and the
 * plugin URI (e.g.
 * <tt>platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore</tt>) resolve to
 * the same Resource eliminating most opportunities for meta-model
 * schizophrenia.
 * <p>
 * {@link #initializePlatformResourceMap()} populates
 * {@link EcorePlugin#getPlatformResourceMap()} with a <i>project</i> to
 * <tt>platform:/resource/<i>project</i></tt> entry for each project and a
 * <i>bundle</i> to <tt>platform:/plugin/<i>bundle</i></tt> entry for each
 * bundle.
 * <p>
 * {@link #initializeGenModelLocationMap(ResourceSet)} exploits the classpath
 * scan for plugins and projects to identify all plugin.xml files and populate
 * the {@link EcorePlugin#getEPackageNsURIToGenModelLocationMap()} from the
 * <tt>org.eclipse.emf.ecore.generated_package</tt> extension points in the same
 * way as occurs automatically in a plugin environment.
 * <p>
 * {@link #initializeURIMap(URIConverter)} installs a
 * <tt>platform:/plugin/<i>project</i></tt> to
 * <tt>platform:/resource/<i>project</i></tt> URI mapping for each project and a
 * <tt>platform:/resource/<i>bundle</i></tt> to
 * <tt>platform:/plugin/<i>bundle</i></tt> URI mapping for each bundle.
 * 
 * <h4>Static Instances and Re-Use</h4>
 * 
 * No static <tt>INSTANCE</tt> is provided because different class loaders or
 * dynamic class path changes may result in stale content. Standalone
 * applications are strongly advised to create their own static instance in a
 * stable context and so avoid repeating the significant costs of a full class
 * path search.
 * <p>
 * The {@link #getAdapter(ResourceSet)} method may be used to invoke
 * {@link #initializeResourceSet(ResourceSet)} if not already invoked and to
 * install the ProjectMap as a ResourceSet adapter allowing an invocation of
 * {@link #findAdapter(ResourceSet)} to find it for subsequent re-use.
 */
public class StandaloneProjectMap extends SingletonAdapterImpl
{
	private static final String PLUGIN_ID = "org.eclipse.ocl.examples.domain";;

	private static final Logger logger = Logger.getLogger(StandaloneProjectMap.class);

	public static final @NonNull TracingOption PROJECT_MAP_ADD_EPACKAGE = new TracingOption(PLUGIN_ID, "projectMap/addEPackage");
	public static final @NonNull TracingOption PROJECT_MAP_ADD_GEN_MODEL = new TracingOption(PLUGIN_ID, "projectMap/addGenModel");
	public static final @NonNull TracingOption PROJECT_MAP_ADD_URI_MAP = new TracingOption(PLUGIN_ID, "projectMap/addURIMap");
	public static final @NonNull TracingOption PROJECT_MAP_CONFIGURE = new TracingOption(PLUGIN_ID, "projectMap/configure");
	public static final @NonNull TracingOption PROJECT_MAP_INSTALL = new TracingOption(PLUGIN_ID, "projectMap/install");
	public static final @NonNull TracingOption PROJECT_MAP_RESOLVE = new TracingOption(PLUGIN_ID, "projectMap/resolve");
	
	{
//		PROJECT_MAP_ADD_EPACKAGE.setState(true);
//		PROJECT_MAP_ADD_GEN_MODEL.setState(true);
//		PROJECT_MAP_ADD_URI_MAP.setState(true);
//		PROJECT_MAP_CONFIGURE.setState(true);
//		PROJECT_MAP_INSTALL.setState(true);
//		PROJECT_MAP_RESOLVE.setState(true);
	}
	
	/**
	 * An AbstractEPackageDescriptor provides common support for loading an EPackage to support a particular style of reference.
	 * Derived classes specialize the variaous namespace, platform-resource or platform-plugin references.
	 * <p>
	 * The EPackage.Descriptor is installed in an EPackage.Registry to support lazy resolution of the URI to EPackage mapping.
	 * Distinct derived AbstractEPackageDescriptor instances for each kind of URI. THe instances redirect the lazy resolution to
	 * a distinct IPackageDescripror.Internal method which in turn redirects to a corresponding
	 */
	protected static abstract class AbstractEPackageDescriptor implements EPackage.Descriptor
	{
		protected final @NonNull IPackageLoadStatus packageLoadStatus;	// The PackageLoadStatus of the required package.

		protected AbstractEPackageDescriptor(@NonNull IPackageLoadStatus packageLoadStatus, @NonNull EPackage.Registry packageRegistry) {
			this.packageLoadStatus = packageLoadStatus;
			if (PROJECT_MAP_INSTALL.isActive()) {
				PROJECT_MAP_INSTALL.println("" + toString());
			}
			packageRegistry.put(getURI().toString(), this);
		}

		public EFactory getEFactory() {
			EPackage ePackage = resolveEPackage();
			if (ePackage != null) {
				return ePackage.getEFactoryInstance();
			}
			else {
				return null;
			}
		}

		public final @Nullable EPackage getEPackage() {
			EPackage ePackage = resolveEPackage();
			if (ePackage != null) {
				Resource eResource = ePackage.eResource();
				if (DomainUtil.isRegistered(eResource)) {
					if (PROJECT_MAP_RESOLVE.isActive()) {
						PROJECT_MAP_RESOLVE.println(getURI() + " => " + ePackage.getNsURI() + " : " + DomainUtil.debugSimpleName(ePackage));
					}
					Set<EPackage> allEPackages = new HashSet<EPackage>();
					for (EObject eObject : eResource.getContents()) {
						if (eObject instanceof EPackage) {
							allEPackages.add((EPackage)eObject);
							locateTransitiveEPackages((EPackage)eObject, allEPackages);
						}
					}
					EPackage.Registry packageRegistry = packageLoadStatus.getPackageRegistry();
					for (EPackage transitiveEPackage : allEPackages) {
						if ((transitiveEPackage != null) && (transitiveEPackage != ePackage)) {
							Object entry = packageRegistry.get(transitiveEPackage.getNsURI());
							if (entry instanceof AbstractEPackageDescriptor) {
								AbstractEPackageDescriptor referencedEPackageDescriptor = (AbstractEPackageDescriptor)entry;
								referencedEPackageDescriptor.packageLoadStatus.setTransitivelyLoadedBy(transitiveEPackage, ePackage);
								if (PROJECT_MAP_RESOLVE.isActive()) {
									PROJECT_MAP_RESOLVE.println(referencedEPackageDescriptor.getURI() + " => " + transitiveEPackage.getNsURI() + " : " + DomainUtil.debugSimpleName(transitiveEPackage));
								}
								packageRegistry.put(transitiveEPackage.getNsURI(), transitiveEPackage);
							}
						}
					}
					return ePackage;
				}
			}
			if (PROJECT_MAP_RESOLVE.isActive()) {
				URI uri = ePackage != null ? EcoreUtil.getURI(ePackage) : null;
				PROJECT_MAP_RESOLVE.println(getURI() + " => " + uri);
			}
			return ePackage;
		}

		/**
		 * Update allEPackages to 
		 * @param ePackage
		 * @param allEPackages
		 */
		private void locateTransitiveEPackages(@NonNull EPackage ePackage, @NonNull Set<EPackage> allEPackages) {
			EPackage.Registry packageRegistry = packageLoadStatus.getPackageRegistry();
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					EPackage referencedEPackage;
					EClassifier referencedEClassifier;
					for (EClass eSuperclass : eClass.getESuperTypes()) {
						referencedEPackage = eSuperclass.getEPackage();
						if ((referencedEPackage != null) && allEPackages.add(referencedEPackage) && (packageRegistry.get(referencedEPackage) instanceof IPackageDescriptor)) {
							locateTransitiveEPackages(referencedEPackage, allEPackages);
						}
						for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
							referencedEClassifier = eFeature.getEType();
							referencedEPackage = referencedEClassifier.getEPackage();
							if ((referencedEPackage != null) && allEPackages.add(referencedEPackage)) {
								locateTransitiveEPackages(referencedEPackage, allEPackages);
							}
						}
						for (EOperation eOperation : eClass.getEOperations()) {
							referencedEClassifier = eOperation.getEType();
							if (referencedEClassifier != null) {
								referencedEPackage = referencedEClassifier.getEPackage();
								if ((referencedEPackage != null) && allEPackages.add(referencedEPackage) && (packageRegistry.get(referencedEPackage) instanceof IPackageDescriptor)) {
									locateTransitiveEPackages(referencedEPackage, allEPackages);
								}
							}
							for (EParameter eParameter : eOperation.getEParameters()) {
								referencedEClassifier = eParameter.getEType();
								if (referencedEClassifier != null) {
									referencedEPackage = referencedEClassifier.getEPackage();
									if ((referencedEPackage != null) && allEPackages.add(referencedEPackage) && (packageRegistry.get(referencedEPackage) instanceof IPackageDescriptor)) {
										locateTransitiveEPackages(referencedEPackage, allEPackages);
									}
								}
							}
						}
					}
				}
			}
			for (EPackage eSubpackage : ePackage.getESubpackages()) {
				if (eSubpackage != null) {
					locateTransitiveEPackages(eSubpackage, allEPackages);
				}
			}
		}

		protected abstract @NonNull URI getURI();

		protected abstract @Nullable EPackage resolveEPackage();

		@Override
		public String toString() {
			return getClass().getSimpleName() + ": " + getURI() + " with " + packageLoadStatus.getPackageLoadStrategy();
		}

		public void uninstall(@NonNull Registry packageRegistry) {
			if (PROJECT_MAP_INSTALL.isActive()) {
				PROJECT_MAP_INSTALL.println("" + toString());
			}
			packageRegistry.put(getURI().toString(), null);
		}
	}
	
	/**
	 * NamespaceURIDescriptor is an EPackage.Descriptor that loads the EPackage to resolve a Namespace URI reference.
	 */
	protected final static class NamespaceURIDescriptor extends AbstractEPackageDescriptor
	{	
		protected NamespaceURIDescriptor(@NonNull IPackageLoadStatus packageLoadStatus, @NonNull EPackage.Registry packageRegistry) {
			super(packageLoadStatus, packageRegistry);
		}

		@Override
		public @NonNull URI getURI() {
			return packageLoadStatus.getPackageDescriptor().getNamespaceURI();
		}

		@Override
		public @Nullable EPackage resolveEPackage() {
			IPackageLoadStrategy packageLoadStrategy = packageLoadStatus.getPackageLoadStrategy();
			return packageLoadStrategy.getEPackageByNamespaceURI(packageLoadStatus);
		}
	}
	
	/**
	 * PlatformPluginURIDescriptor is an EPackage.Descriptor that loads the EPackage to resolve a platform:/plugin/... URI reference.
	 */
	protected final static class PlatformPluginURIDescriptor extends AbstractEPackageDescriptor
	{	
		protected PlatformPluginURIDescriptor(@NonNull IPackageLoadStatus packageLoadStatus, @NonNull EPackage.Registry packageRegistry) {
			super(packageLoadStatus, packageRegistry);
		}

		@Override
		public @NonNull URI getURI() {
			return packageLoadStatus.getPackageDescriptor().getPlatformPluginURI();
		}

		@Override
		public @Nullable EPackage resolveEPackage() {
			IPackageLoadStrategy packageLoadStrategy = packageLoadStatus.getPackageLoadStrategy();
			return packageLoadStrategy.getEPackageByPlatformPluginURI(packageLoadStatus);
		}
	}
	
	/**
	 * PlatformResourceURIDescriptor is an EPackage.Descriptor that loads the EPackage to resolve a platform:/resource/... URI reference.
	 */
	protected final static class PlatformResourceURIDescriptor extends AbstractEPackageDescriptor
	{	
		protected PlatformResourceURIDescriptor(@NonNull IPackageLoadStatus packageLoadStatus, @NonNull EPackage.Registry packageRegistry) {
			super(packageLoadStatus, packageRegistry);
		}

		@Override
		public @NonNull URI getURI() {
			return packageLoadStatus.getPackageDescriptor().getPlatformResourceURI();
		}

		@Override
		public @Nullable EPackage resolveEPackage() {
			IPackageLoadStrategy packageLoadStrategy = packageLoadStatus.getPackageLoadStrategy();
			return packageLoadStrategy.getEPackageByPlatformResourceURI(packageLoadStatus);
		}
	}

	/**
	 * An IPackageLoadState maintains the lazy load state of a package within an EPackage.Registry
	 */
	public static interface IPackageLoadStatus
	{	
		/**
		 * Dispose of all facilities used by the PackageLoadStatus, and remove all EPackageDescriptor entries.
		 */
		void dispose();

		/**
		 * Return the EPackage to be used for a platform-resource/plugin URI after a namespace URI has already been loaded.
		 */
		@Nullable EPackage getConflictingModelURI();

		/**
		 * Return the EPackage to be used for a namespace URI after a platform-resource/plugin URI has already been loaded.
		 */
		@Nullable EPackage getConflictingNamespaceURI();

		/**
		 * Return the EPackage resolved by the first loadEPackageByModelURI/loadEPackageByNamespaceURI.
		 * @return
		 */
		@Nullable EPackage getFirstEPackage();

		/**
		 * Return the descriptor for the package.
		 */
		@NonNull IPackageDescriptor getPackageDescriptor();

		/**
		 * Return the current package loading strategy.
		 */
		@NonNull IPackageLoadStrategy getPackageLoadStrategy();
		
		/**
		 * Return the package registry maintained by this package load status
		 */
		@NonNull EPackage.Registry getPackageRegistry();

		/**
		 * Load and return the EPackage appropriate to the platform resource or plugin URI.
		 */
		@Nullable EPackage loadEPackageByModelURI();

		/**
		 * Load and return the EPackage appropriate to the namespace URI.
		 */
		@Nullable EPackage loadEPackageByNamespaceURI();

		/**
		 * Define a new conflict handler.
		 */
		void setConflictHandler(@Nullable IConflictHandler conflictHandler);

		void setEPackage(@NonNull EPackage ePackage);

		/**
		 * Define a new package load strategy.
		 */
		void setPackageLoadStrategy(@NonNull IPackageLoadStrategy packageLoadStrategy);

		/**
		 * Update the status to accommodate the parasitic loading of loadedEPackage as a consequence of a reference from loadingEPackage.
		 */
		void setTransitivelyLoadedBy(@NonNull EPackage loadedEPackage, @NonNull EPackage loadingEPackage);
	}

	/**
	 * An IPackageLoadStrategy determines how each of the possible forms of URI reference to an EPackage should loaded.
	 */
	public static interface IPackageLoadStrategy
	{
		/**
		 * Load and return the EPackage appropriate to the namespace URI.
		 */
		@Nullable EPackage getEPackageByNamespaceURI(@NonNull IPackageLoadStatus packageLoadStatus);

		/**
		 * Load and return the EPackage appropriate to the platform plugin URI.
		 */
		@Nullable EPackage getEPackageByPlatformPluginURI(@NonNull IPackageLoadStatus packageLoadStatus);

		/**
		 * Load and return the EPackage appropriate to the platform resource URI.
		 */
		@Nullable EPackage getEPackageByPlatformResourceURI(@NonNull IPackageLoadStatus packageLoadStatus);

		/**
		 * Update the packageLoadStatus to accommodate the parasitic loading of loadedEPackage as a consequence of a reference from loadingEPackage.
		 */
		void setTransitivelyLoadedBy(@NonNull PackageLoadStatus packageLoadStatus, @NonNull EPackage loadedEPackage, @NonNull EPackage loadingEPackage);
	}

	protected static abstract class AbstractPackageLoadStrategy implements IPackageLoadStrategy
	{
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}
	}
	
	/**
	 * The LoadedStrategy re-uses the already loaded EPackage.
	 */
	private static final class LoadedStrategy extends AbstractPackageLoadStrategy
	{
		public static final @NonNull IPackageLoadStrategy INSTANCE = new LoadedStrategy();
		
		public @Nullable EPackage getEPackageByNamespaceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.getFirstEPackage();
		}

		public @Nullable EPackage getEPackageByPlatformPluginURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.getFirstEPackage();
		}

		public @Nullable EPackage getEPackageByPlatformResourceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.getFirstEPackage();
		}

		public void setTransitivelyLoadedBy(@NonNull PackageLoadStatus packageLoadStatus, @NonNull EPackage loadedEPackage, @NonNull EPackage loadingEPackage) {
			logger.error("Should have already loaded + '" + loadedEPackage + "'");
		}
	}
	
	/**
	 * The LoadedAsEPackageStrategy re-uses the already loaded EPackage for namespace URI accesses, and invokes the conflict handler for
	 * platform URI accesses.
	 */
	private static final class LoadedAsEPackageStrategy extends AbstractPackageLoadStrategy
	{
		public static final @NonNull IPackageLoadStrategy INSTANCE = new LoadedAsEPackageStrategy();
		
		public @Nullable EPackage getEPackageByNamespaceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.getFirstEPackage();
		}

		public @Nullable EPackage getEPackageByPlatformPluginURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.getConflictingModelURI();
		}

		public @Nullable EPackage getEPackageByPlatformResourceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.getConflictingModelURI();
		}

		public void setTransitivelyLoadedBy(@NonNull PackageLoadStatus packageLoadStatus, @NonNull EPackage loadedEPackage, @NonNull EPackage loadingEPackage) {
			logger.error("Should have already loaded + '" + loadedEPackage + "'");
		}
	}
	
	/**
	 * The LoadedAsModelStrategy re-uses the already loaded EPackage for platform URI accesses, and invokes the conflict handler for
	 * namespace URI accesses.
	 */
	private static final class LoadedAsModelStrategy extends AbstractPackageLoadStrategy
	{
		public static final @NonNull IPackageLoadStrategy INSTANCE = new LoadedAsModelStrategy();
		
		public @Nullable EPackage getEPackageByNamespaceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.getConflictingNamespaceURI();
		}

		public @Nullable EPackage getEPackageByPlatformPluginURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.getFirstEPackage();
		}

		public @Nullable EPackage getEPackageByPlatformResourceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.getFirstEPackage();
		}

		public void setTransitivelyLoadedBy(@NonNull PackageLoadStatus packageLoadStatus, @NonNull EPackage loadedEPackage, @NonNull EPackage loadingEPackage) {
			logger.error("Should not load + '" + loadedEPackage + "' when a Model load strategy specified");
		}
	}

	/**
	 * The LoadBothStrategy permits metamodel schizophrenia and so access to the namespace URI resolves to an installed
	 * resource while access to the platform plugin or resource URI resolve to a dynmically loaded resource.
	 */
	public static final class LoadBothStrategy extends AbstractPackageLoadStrategy
	{
		public static final @NonNull IPackageLoadStrategy INSTANCE = new LoadBothStrategy();
		
		public @Nullable EPackage getEPackageByNamespaceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.loadEPackageByNamespaceURI();
		}

		public @Nullable EPackage getEPackageByPlatformPluginURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.loadEPackageByModelURI();
		}

		public @Nullable EPackage getEPackageByPlatformResourceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.loadEPackageByModelURI();
		}

		public void setTransitivelyLoadedBy(@NonNull PackageLoadStatus packageLoadStatus, @NonNull EPackage loadedEPackage, @NonNull EPackage loadingEPackage) {
			packageLoadStatus.setEPackage(loadedEPackage);
		}
	}

	/**
	 * The LoadEPackageStrategy uses the EPackage referenced by the namespace URI for all kinds of access, and then changes the
	 * strategy to LOADED for all further accesses.
	 */
	public static final class LoadEPackageStrategy extends AbstractPackageLoadStrategy
	{
		public static final @NonNull IPackageLoadStrategy INSTANCE = new LoadEPackageStrategy();
		
		public @Nullable EPackage getEPackageByNamespaceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			EPackage ePackage = packageLoadStatus.loadEPackageByNamespaceURI();
			packageLoadStatus.setPackageLoadStrategy(LoadedStrategy.INSTANCE);
			return ePackage;
		}

		public @Nullable EPackage getEPackageByPlatformPluginURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			EPackage ePackage = packageLoadStatus.loadEPackageByNamespaceURI();
			packageLoadStatus.setPackageLoadStrategy(LoadedStrategy.INSTANCE);
			return ePackage;
		}

		public @Nullable EPackage getEPackageByPlatformResourceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			EPackage ePackage = packageLoadStatus.loadEPackageByNamespaceURI();
			packageLoadStatus.setPackageLoadStrategy(LoadedStrategy.INSTANCE);
			return ePackage;
		}

		public void setTransitivelyLoadedBy(@NonNull PackageLoadStatus packageLoadStatus, @NonNull EPackage loadedEPackage, @NonNull EPackage loadingEPackage) {
			packageLoadStatus.setEPackage(loadedEPackage);
			packageLoadStatus.setPackageLoadStrategy(LoadedStrategy.INSTANCE);
		}
	}

	/**
	 * The LoadFirstStrategy use the EPackage corresponding to the first access as either a namespace URI or platform plugin.resource URI.
	 * Thereafter accesses to the same URI use the first loaded EPackage. Accesses to the other form of URI are arbitrated by the IConflictHandler
	 * in the IPackageLoadStatus.
	 */
	public static final class LoadFirstStrategy extends AbstractPackageLoadStrategy
	{
		public static final @NonNull IPackageLoadStrategy INSTANCE = new LoadFirstStrategy();
		
		public @Nullable EPackage getEPackageByNamespaceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			EPackage ePackage = packageLoadStatus.loadEPackageByNamespaceURI();
			packageLoadStatus.setPackageLoadStrategy(LoadedAsEPackageStrategy.INSTANCE);
			return ePackage;
		}

		public @Nullable EPackage getEPackageByPlatformPluginURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			EPackage ePackage = packageLoadStatus.loadEPackageByModelURI();
			packageLoadStatus.setPackageLoadStrategy(LoadedAsModelStrategy.INSTANCE);
			return ePackage;
		}

		public @Nullable EPackage getEPackageByPlatformResourceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			EPackage ePackage = packageLoadStatus.loadEPackageByModelURI();
			packageLoadStatus.setPackageLoadStrategy(LoadedAsModelStrategy.INSTANCE);
			return ePackage;
		}

		public void setTransitivelyLoadedBy(@NonNull PackageLoadStatus packageLoadStatus, @NonNull EPackage loadedEPackage, @NonNull EPackage loadingEPackage) {
			packageLoadStatus.setEPackage(loadedEPackage);
			packageLoadStatus.setPackageLoadStrategy(LoadedAsEPackageStrategy.INSTANCE);
		}
	}

	/**
	 * The LoadModelStrategy uses the EPackage referenced by the platform resopurce/plugin URI for all kinds of access, and then changes the
	 * strategy to LOADED for all further accesses.
	 */
	public static final class LoadModelStrategy extends AbstractPackageLoadStrategy
	{
		public static final @NonNull IPackageLoadStrategy INSTANCE = new LoadModelStrategy();
		
		public @Nullable EPackage getEPackageByNamespaceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			EPackage ePackage = packageLoadStatus.loadEPackageByModelURI();
			packageLoadStatus.setPackageLoadStrategy(LoadedStrategy.INSTANCE);
			return ePackage;
		}

		public @Nullable EPackage getEPackageByPlatformPluginURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			EPackage ePackage = packageLoadStatus.loadEPackageByModelURI();
			packageLoadStatus.setPackageLoadStrategy(LoadedStrategy.INSTANCE);
			return ePackage;
		}

		public @Nullable EPackage getEPackageByPlatformResourceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			EPackage ePackage = packageLoadStatus.loadEPackageByModelURI();
			packageLoadStatus.setPackageLoadStrategy(LoadedStrategy.INSTANCE);
			return ePackage;
		}

		public void setTransitivelyLoadedBy(@NonNull PackageLoadStatus packageLoadStatus, @NonNull EPackage loadedEPackage, @NonNull EPackage loadingEPackage) {
			logger.error("Should not load + '" + loadedEPackage + "' when a Model load strategy specified");
			packageLoadStatus.setPackageLoadStrategy(LoadedStrategy.INSTANCE);
		}
	}
	
	/**
	 * An IPackageDescriptor describes the modeling capabilities of a known
	 * model package and may be installed under a variety of synonyms in an
	 * EPackage.Registry to map multiple URIs to a single EPackage.
	 */
	public static interface IPackageDescriptor
	{
		public static interface Internal extends IPackageDescriptor
		{
			/**
			 * Internal callback from Ecore model pre-parse to register the
			 * Ecore Package URI.
			 */
			void addEcorePackage(@NonNull String ecorePackage);


			/**
			 * Internal preparation for Ecore model pre-parse.
			 */
			@NonNull GenModelEcorePackageHandler createGenModelEcorePackageHandler();

			/**
			 * Load the EPackage defined by the namespace URI.
			 */
//			@Nullable EPackage getEPackage();

			/**
			 * Load the EPackage defined by the platform-resource URI or platform-plugin URI.
			 */
//			@Nullable EPackage getModel();

			/**
			 * Internal partial configuration.
			 */
			void setClassName(@NonNull String className);

		}

		void configure(@Nullable ResourceSet resourceSet, @NonNull IPackageLoadStrategy packageLoadStrategy, @Nullable IConflictHandler conflictHandler);


		@Nullable String getClassName();

		/**
		 * Return the project relative Ecore Model URI, which may be null if there is no corresponding Ecore model.
		 */
		@Nullable URI getEcoreModelURI();

		@Nullable URI getEcorePackageURI();

		/**
		 * Return the project relative Gen Model URI.
		 */
		@NonNull URI getGenModelURI();

		/**
		 * Return the external filespace form of the model URI containing the package.
		 * @Throws IllegalStateException if there is no Ecore model.
		 */
		@NonNull URI getLocationURI();

		/**
		 * Return the Package NS URI.
		 */
		@NonNull URI getNamespaceURI();
		
		@NonNull IPackageLoadStatus getPackageLoadStatus(@Nullable ResourceSet resourceSet, @Nullable IConflictHandler conflictHandler);

		/**
		 * Return the platform:/resource form of the model URI containing the package
		 * @Throws IllegalStateException if there is no Ecore model.
		 */
		@NonNull URI getPlatformResourceURI();

		/**
		 * Return the platform:/plugin form of the model URI containing the package
		 * @Throws IllegalStateException if there is no Ecore model.
		 */
		@NonNull URI getPlatformPluginURI();

		/**
		 * Return the Project Descriptor containing this package.
		 */
		@NonNull IProjectDescriptor getProjectDescriptor();

		/**
		 * Unload the package registry to force a reload.
		 */
		void unload(@NonNull EPackage.Registry packageRegistry);
	}

	/**
	 * An IProjectDescriptor describes the capabilities of a project.
	 */
	public static interface IProjectDescriptor {

		public static interface Internal extends IProjectDescriptor
		{
			/**
			 * Internal callback from Ecore model pre-parse to register the
			 * Ecore Package URI.
			 */
			@NonNull IPackageDescriptor.Internal createPackageDescriptor(@NonNull URI nsURI, @NonNull URI deresolve);
		}

		void configure(@Nullable ResourceSet resourceSet, @NonNull IPackageLoadStrategy packageLoadStrategy, @Nullable IConflictHandler conflictHandler);

		/**
		 * Return the physical location of this project.
		 */
		@NonNull URI getLocationURI();

		/**
		 * Return the physical location of a projectRelativeFileName as a URI.
		 */
		@NonNull URI getLocationURI(@NonNull String projectRelativeFileName);

		/**
		 * Return the physical location of a projectRelativeFileName as a File.
		 */
		@NonNull File getLocationFile(@NonNull String projectRelativeFileName);

		/**
		 * Return project name.
		 */
		@NonNull String getName();

		/**
		 * Return the location of this project as a platform:/plugin URI.
		 */
		@NonNull URI getPlatformPluginURI();

		/**
		 * Return the location of a projectRelativeFileName as a
		 * platform:/resource URI.
		 */
		@NonNull URI getPlatformPluginURI(@NonNull String projectRelativeFileName);

		/**
		 * Return the location of this project as a platform:/resource URI.
		 */
		@NonNull URI getPlatformResourceURI();

		/**
		 * Return the location of a projectRelativeFileName as a
		 * platform:/resource URI.
		 */
		@NonNull URI getPlatformResourceURI(@NonNull String projectRelativeFileName);

		/**
		 * Return the package descriptor for the package with a given nsURI or
		 * null if none known in the project.
		 */
		IPackageDescriptor getPackageDescriptor(@NonNull URI nsURI);

		/**
		 * Return all package descriptor in the project.
		 */
		@Nullable Collection<IPackageDescriptor> getPackageDescriptors();

		void initializeGenModelLocationMap(@NonNull Map<URI, IPackageDescriptor> nsURI2package);

//		void initializePackageRegistration(@NonNull EPackage.Registry packageRegistry, @NonNull IPackageDescriptor packageDescriptor);

		void initializePlatformResourceMap();

		void initializeURIMap(@NonNull Map<URI, URI> uriMap);

//		void useModelsAndPackages(@NonNull Resource ecoreResource);

		/**
		 * Treat any top level packages in ecoreResource as preloaded packages
		 * for use by corresponding URIs in this project.
		 */
//		void usePackages(@NonNull Resource ecoreResource);
	}
	
	public static final class PackageLoadStatus implements IPackageLoadStatus
	{
		protected final @NonNull IPackageDescriptor.Internal packageDescriptor;
		private @Nullable ResourceSet resourceSet;
		protected final @NonNull EPackage.Registry packageRegistry;
		
		protected final @NonNull NamespaceURIDescriptor namespaceURIDescriptor;
		protected final @NonNull PlatformPluginURIDescriptor platformPluginURIDescriptor;
		protected final @NonNull PlatformResourceURIDescriptor platformResourceURIDescriptor;
		
		/**
		 * The optional handler for namespace/platform or platform/namespace metamodel schizophrenia.
		 */
		private @Nullable IConflictHandler conflictHandler = MapToFirstConflictHandlerWithLog.INSTANCE;
		
		/**
		 * The strategy to be be used to resolve further URI to EPackage mappings.
		 */
		protected @NonNull IPackageLoadStrategy packageLoadStrategy = LoadFirstStrategy.INSTANCE;
		
		/**
		 * The EPackage resulting from the first loadEPackageByModelURI/loadEPackageByNamespaceURI
		 */
		private @Nullable EPackage firstEPackage;

		/**
		 * The resolved compiled EPackage (e.g. org.eclipse.emf.ecore.EcorePackage.eINSTANCE).
		 */
		private @Nullable EPackage ePackage = null;

		/**
		 * The resolved EPackage from a dynamically loaded model (e.g. platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore#/).
		 */
		private @Nullable EPackage eModel = null;

		/**
		 * Re-entrancy detector for self-referential models such as Ecore.ecore.
		 */
		private boolean modelLoadInProgress = false;

		public PackageLoadStatus(@NonNull IPackageDescriptor.Internal packageDescriptor, @Nullable ResourceSet resourceSet) {
			this.packageDescriptor = packageDescriptor;
			this.resourceSet = resourceSet;
			this.packageRegistry = StandaloneProjectMap.getPackageRegistry(resourceSet);
			this.namespaceURIDescriptor = new NamespaceURIDescriptor(this, packageRegistry);
			this.platformPluginURIDescriptor = new PlatformPluginURIDescriptor(this, packageRegistry);
			this.platformResourceURIDescriptor = new PlatformResourceURIDescriptor(this, packageRegistry);
			if (PROJECT_MAP_CONFIGURE.isActive()) {
				PROJECT_MAP_CONFIGURE.println(this.toString());
			}
		}
		
		public void dispose() {
			namespaceURIDescriptor.uninstall(packageRegistry);
			platformPluginURIDescriptor.uninstall(packageRegistry);
			platformResourceURIDescriptor.uninstall(packageRegistry);
			resourceSet = null;
		}

		public @Nullable EPackage getConflictingModelURI() {
			if (conflictHandler != null) {
				return conflictHandler.handleConflictingModelURI(this);
			}
			else {
				return null;
			}
		}

		public @Nullable EPackage getConflictingNamespaceURI() {
			if (conflictHandler != null) {
				return conflictHandler.handleConflictingNamespaceURI(this);
			}
			else {
				return null;
			}
		}

		public @Nullable EPackage getEPackage() {
			if (ePackage == null) {
				String className = packageDescriptor.getClassName();
				if (className != null) {
					try {
						Class<?> javaClass = Class.forName(className);
						Field field = javaClass.getField("eINSTANCE");
						ePackage = (EPackage) field.get(null);
					} catch (ClassNotFoundException e) {
						throw new WrappedException(e);
					} catch (IllegalAccessException e) {
						throw new WrappedException(e);
					} catch (NoSuchFieldException e) {
						throw new WrappedException(e);
					}
				} else {
					Object object = EPackage.Registry.INSTANCE.get(packageDescriptor.getNamespaceURI().toString());
					if (object instanceof EPackage) {
						ePackage = (EPackage) object;
					} else if (object instanceof EPackage.Descriptor) {
						ePackage = ((EPackage.Descriptor) object).getEPackage();
					}
				}
			}
//			PROJECT_MAP_RESOLVE.println("GetEPackage " + namespaceURI);
//			PROJECT_MAP_RESOLVE.println(DomainUtil.debugSimpleName(this) + " " + namespaceURI + " " + DomainUtil.debugSimpleName(ePackage));
			return ePackage;
		}

		public @Nullable EPackage getFirstEPackage() {
			return firstEPackage;
		}

		public @Nullable EPackage getModel() {
			if (eModel == null) {
				try {
					modelLoadInProgress = true;
					URI ecorePackageURI = packageDescriptor.getEcorePackageURI();
					if (ecorePackageURI != null) {
						URI physicalURI = packageDescriptor.getLocationURI();
						URI logicalURI = packageDescriptor.getPlatformResourceURI();
						ResourceSet resourceSet = this.resourceSet != null ? this.resourceSet : new ResourceSetImpl();
						Resource resource = resourceSet.createResource(logicalURI);
						try {
							if (resource == null) {
								throw new IOException("Failed to create " + logicalURI);
							}
							InputStream inputStream = resourceSet.getURIConverter().createInputStream(physicalURI);
							resource.load(inputStream, null);
							String fragment = ecorePackageURI.fragment();
							EObject eObject = resource.getEObject(fragment != null ? fragment : "/");
							eModel = (EPackage) eObject;
						} catch (Exception exception) {
							handleLoadException(resource, DomainUtil.nonNullEMF(physicalURI.toString()), exception);
						} 
					}
				} finally {
					modelLoadInProgress = false;
				}
			}
//			PROJECT_MAP_RESOLVE.println("GetEPackage " + namespaceURI);
//			PROJECT_MAP_RESOLVE.println(DomainUtil.debugSimpleName(this) + " " + namespaceURI + " " + DomainUtil.debugSimpleName(eModel));
			return eModel;
		}

		public @NonNull IPackageDescriptor getPackageDescriptor() {
			return packageDescriptor;
		}

		public @NonNull IPackageLoadStrategy getPackageLoadStrategy() {
			return packageLoadStrategy;
		}

		public @NonNull EPackage.Registry getPackageRegistry() {
			return packageRegistry;
		}

		protected void handleLoadException(Resource resource, final @NonNull String location, Exception exception) throws RuntimeException {
			class DiagnosticWrappedException extends WrappedException implements Resource.Diagnostic
			{
				private static final long serialVersionUID = 1L;

				public DiagnosticWrappedException(Exception exception) {
					super(exception);
				}

				public String getLocation() {
					return location;
				}

				public int getColumn() {
					return 0;
				}

				public int getLine() {
					return 0;
				}
			}
			Exception cause = exception instanceof Resource.IOWrappedException ? (Exception) exception.getCause() : exception;
			DiagnosticWrappedException wrappedException = new DiagnosticWrappedException(cause);
			if ((resource != null) && resource.getErrors().isEmpty()) {
				resource.getErrors().add(exception instanceof Resource.Diagnostic ? (Resource.Diagnostic) exception : wrappedException);
			}
			throw wrappedException;
		}

		public synchronized @Nullable EPackage loadEPackageByModelURI() {
			if (modelLoadInProgress) {					// Recursive load
				logger.error("Attempt to load self-referential '" + packageDescriptor.getNamespaceURI() + "' as model replaced by registered EPackage");
				return getEPackage();
			}
			EPackage ePackage = getModel();
			if (firstEPackage == null) {
				firstEPackage = ePackage;
			}
			return ePackage;
		}

		public synchronized @Nullable EPackage loadEPackageByNamespaceURI() {
			EPackage ePackage = getEPackage();
			if (firstEPackage == null) {
				firstEPackage = ePackage;
			}
			return ePackage;
		}

		public void setConflictHandler(@Nullable IConflictHandler conflictHandler) {
			this.conflictHandler = conflictHandler;
		}

		public void setEPackage(@NonNull EPackage ePackage) {
			assert firstEPackage == null;
			firstEPackage = ePackage;
			this.ePackage = ePackage;
		}

		public void setPackageLoadStrategy(@NonNull IPackageLoadStrategy packageLoadStrategy) {
			this.packageLoadStrategy = packageLoadStrategy;
			if (PROJECT_MAP_CONFIGURE.isActive()) {
				PROJECT_MAP_CONFIGURE.println(this.toString());
			}
		}

		@Override
		public @NonNull String toString() {
			StringBuilder s = new StringBuilder();
			s.append(packageLoadStrategy +  " for " + packageDescriptor.getNamespaceURI());
			if (packageRegistry == EPackage.Registry.INSTANCE) {
				s.append(" in global ");
			}
			else {
				s.append(" in ");
			}
			s.append(DomainUtil.debugSimpleName(packageRegistry));
			@SuppressWarnings("null")@NonNull String string = s.toString();
			return string;
		}

		public void setTransitivelyLoadedBy(@NonNull EPackage loadedEPackage, @NonNull EPackage loadingEPackage) {
			packageLoadStrategy.setTransitivelyLoadedBy(this, loadedEPackage, loadingEPackage);
		}
	}

	/**
	 * PackageDescriptor supports lazy class loading and initialization of a
	 * compiled Ecore package. Class loading occurs in the context of the
	 * ProjectMap, which performs classpath scans, so it is assumed that
	 * everything is visible. Re-use in a larger context may require a new
	 * ProjectMap to be created.
	 * 
	 * If a PackageDescriptor is installed under multiple URIs, the resource
	 * created by the first load is shared by all subsequent resolutions.
	 * 
	 * If a PackageDescriptor is set to useModel, the *.ecore file is loaded to
	 * provide the EPackage, rather than the Java className.
	 * 
	 * A PackageDescriptor maintains the declared context of a package which may be shared by
	 * many ResourceSets. In contrast a PackageStatus maintains the actual state of a package
	 * for a particular EPackage.Registry, each of which may have a distinct PackageLoadStrategy
	 * and consequently may not load the same EPackage.
	 */
	public static final class PackageDescriptor implements IPackageDescriptor.Internal
	{

		/**
		 * The bundle/project in which this package is defined (e.g. for org.eclipse.emf.ecore). 
		 */
		protected final @NonNull IProjectDescriptor projectDescriptor;

		/**
		 * The namespace URI of the EPackage (e.g. http://www.eclipse.org/emf/2002/Ecore). 
		 */
		protected final @NonNull URI namespaceURI;

		/**
		 * The project-relative URI of the GenModel for the EPackage (e.g. model/Ecore.genmodel). 
		 */
		protected final @NonNull URI genModelURI;

		/**
		 * The Java class name of the compiled EPackage (e.g. org.eclipse.emf.ecore.EcorePackage). 
		 */
		protected @Nullable String className = null;

		/**
		 * The project-relative URI of the model for the EPackage (e.g. model/Ecore.ecore#/). 
		 */
		private @Nullable URI ecorePackageURI = null;
		
		/**
		 * The filespace URI of the EPackage (e.g. file:/C:/Eclipse/plugins/org.eclipse.emf.ecore/model/Ecore.ecore). 
		 */
		private @Nullable  URI locationURI = null;
		
		/**
		 * The platform resource URI of the EPackage (e.g. platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore). 
		 */
		private @Nullable  URI platformResourceURI = null;
		
		/**
		 * The platform plugin URI of the EPackage (e.g. platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore). 
		 */
		private @Nullable  URI platformPluginURI = null;
		
		/**
		 * The PackageLoadStatus for each ResourceSet (null is the global 'ResourceSet' 'containing' all Java'd packages).
		 */
		private final @NonNull WeakHashMap<ResourceSet, IPackageLoadStatus> resourceSet2packageLoadStatus = new WeakHashMap<ResourceSet, IPackageLoadStatus>();
		
		public PackageDescriptor(@NonNull IProjectDescriptor projectDescriptor, @NonNull URI nsURI, @NonNull URI genModelURI) {
			this.projectDescriptor = projectDescriptor;
			this.namespaceURI = nsURI;
			this.genModelURI = genModelURI;
		}

		public void addEcorePackage(@NonNull String ecorePackage) {
			URI uri = URI.createURI(ecorePackage);
			URI projectLocationURI = projectDescriptor.getLocationURI();
			URI absoluteGenModelURI = genModelURI.resolve(projectLocationURI);
			URI absolutePackageURI = uri.resolve(absoluteGenModelURI);
			@SuppressWarnings("null")@NonNull URI ecorePackageURI2 = absolutePackageURI.deresolve(projectLocationURI, true, true, true);
			ecorePackageURI = ecorePackageURI2;
			URI resourceURI = projectDescriptor.getPlatformResourceURI();
			URI pluginURI = projectDescriptor.getPlatformPluginURI();
			URI ecoreURI = ecorePackageURI2.trimFragment();
			platformResourceURI = ecoreURI.resolve(resourceURI);
			platformPluginURI = ecoreURI.resolve(pluginURI);
			locationURI = ecoreURI.resolve(projectDescriptor.getLocationURI());
			if (PROJECT_MAP_ADD_EPACKAGE.isActive()) {
				PROJECT_MAP_ADD_EPACKAGE.println(namespaceURI + " => " + ecorePackage + " : " + className);
			}
		}

		public void configure(@Nullable ResourceSet resourceSet, @NonNull IPackageLoadStrategy packageLoadStrategy, @Nullable IConflictHandler conflictHandler) {
			if (ecorePackageURI != null) {
				IPackageLoadStatus packageLoadStatus = getPackageLoadStatus(resourceSet, conflictHandler);
				packageLoadStatus.setPackageLoadStrategy(packageLoadStrategy);
			}
		}

		public @NonNull GenModelEcorePackageHandler createGenModelEcorePackageHandler() {
			return new GenModelEcorePackageHandler(this);
		}

		public @Nullable String getClassName() {
			return className;
		}

		public @Nullable EFactory getEFactory() {
			return null;
		}

		public @Nullable URI getEcoreModelURI() {
			return ecorePackageURI != null ? ecorePackageURI.trimFragment() : null;
		}

		public @Nullable URI getEcorePackageURI() {
			return ecorePackageURI;
		}

		public @NonNull URI getGenModelURI() {
			return genModelURI;
		}

		public @NonNull URI getLocationURI() {
			return DomainUtil.nonNullState(locationURI);
		}

		public @NonNull URI getNamespaceURI() {
			return namespaceURI;
		}
		
		public @NonNull IPackageLoadStatus getPackageLoadStatus(@Nullable ResourceSet resourceSet, @Nullable IConflictHandler conflictHandler) {
			assert ecorePackageURI != null;
			IPackageLoadStatus packageLoadStatus = resourceSet2packageLoadStatus.get(resourceSet);
			if (packageLoadStatus == null) {
				synchronized (resourceSet2packageLoadStatus) {
					packageLoadStatus = resourceSet2packageLoadStatus.get(resourceSet);
					if (packageLoadStatus == null) {
						packageLoadStatus = new PackageLoadStatus(this, resourceSet);
						resourceSet2packageLoadStatus.put(resourceSet, packageLoadStatus);
					}
				}
			}
			packageLoadStatus.setConflictHandler(conflictHandler);
			return packageLoadStatus;
		}
		
		public @NonNull URI getPlatformPluginURI() {
			return DomainUtil.nonNullState(platformPluginURI);
		}

		public @NonNull URI getPlatformResourceURI() {
			return DomainUtil.nonNullState(platformResourceURI);
		}

		public @NonNull IProjectDescriptor getProjectDescriptor() {
			return projectDescriptor;
		}

		public void setClassName(@NonNull String className) {
			this.className = className;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(namespaceURI);
			s.append(" => ");
			s.append(className);
			s.append(", ");
			s.append(genModelURI);
			if (ecorePackageURI != null) {
				s.append(", ");
				s.append(ecorePackageURI);
			}
			return s.toString();
		}

		public void unload() {
			synchronized (resourceSet2packageLoadStatus) {
				for (IPackageLoadStatus packageLoadStatus : resourceSet2packageLoadStatus.values()) {
					packageLoadStatus.dispose();
				}
				resourceSet2packageLoadStatus.clear();
			}
		}

		public void unload(@NonNull EPackage.Registry packageRegistry) {
			if (ecorePackageURI != null) {
				synchronized (resourceSet2packageLoadStatus) {
					IPackageLoadStatus packageLoadStatus = resourceSet2packageLoadStatus.remove(packageRegistry);
					if (packageLoadStatus != null) {
						packageLoadStatus.dispose();
					}
				}
			}
		}
	}

	/**
	 * PluginGenModelHandler provides the SAX callbacks to support reading the
	 * org.eclipse.emf.ecore.generated_package extension point in a plugin.xml
	 * file and activating the GenModelEcorePackageHandler to process the
	 * ecorePackage locations and invoking {@link addGenModel()} for each
	 * encounter.
	 */
	protected static class PluginGenModelHandler extends DefaultHandler
	{
		public static final @NonNull String pluginTag = "plugin";
		public static final @NonNull String extensionTag = "extension";
		public static final @NonNull String pointTag = "point";
		public static final @NonNull String packageTag = "package";
		public static final @NonNull String extensionPointAttribute = "org.eclipse.emf.ecore.generated_package";
		public static final @NonNull String uriAttribute = "uri";
		public static final @NonNull String classAttribute = "class";
		public static final @NonNull String genModelAttribute = "genModel";

		protected final JarFile jarFile;
		protected final IProjectDescriptor.Internal projectDescriptor;
		private int pluginCount = 0;
		private int extensionCount = 0;
		private boolean inPoint = false;
		private int packageCount = 0;
		private @NonNull Map<String, GenModelEcorePackageHandler> genModelEcorePackageHandlers = new HashMap<String, GenModelEcorePackageHandler>();

		private PluginGenModelHandler(@Nullable IProjectDescriptor.Internal projectDescriptor) {
			this.jarFile = null;
			this.projectDescriptor = projectDescriptor;
		}

		public PluginGenModelHandler(@NonNull JarFile jarFile, @NonNull IProjectDescriptor.Internal projectDescriptor) {
			this.jarFile = jarFile;
			this.projectDescriptor = projectDescriptor;
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if (pluginCount == 1) {
				if (pluginTag.equals(qName)) {
					pluginCount--;
				}
				if (extensionCount == 1) {
					if (extensionTag.equals(qName)) {
						extensionCount--;
					}
					if (packageCount == 1) {
						if (packageTag.equals(qName)) {
							packageCount--;
						}
					}
				}
			}
		}

		public void scanContents(SAXParser saxParser)
				throws SAXParseException {
			for (String genModel : genModelEcorePackageHandlers.keySet()) {
				GenModelEcorePackageHandler genModelEcorePackageHandler = genModelEcorePackageHandlers
					.get(genModel);
				URI locationURI = projectDescriptor.getLocationURI();
				URI genModelURI = URI.createURI(genModel).resolve(locationURI);
				InputStream inputStream = null;
				try {
					if (jarFile != null) {
						ZipEntry entry = jarFile.getEntry(genModel);
						if (entry != null) {
							inputStream = jarFile.getInputStream(entry);
						}
					} else {
						inputStream = new FileInputStream(genModelURI
							.toString().substring(5)); // Lose file:
					}
					if (inputStream != null) {
						saxParser.parse(inputStream,
							genModelEcorePackageHandler);
					}
				} catch (Exception e) {
					throw new SAXParseException("Failed to parse "
						+ locationURI, null, e);
				} finally {
					try {
						if (inputStream != null) {
							inputStream.close();
						}
					} catch (IOException e) {
					}
				}
			}
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) {
			if (pluginCount == 0) {
				if (pluginTag.equals(qName)) {
					pluginCount++;
				}
			} else if (pluginCount == 1) {
				if ((extensionCount == 0) && extensionTag.equals(qName)) {
					extensionCount++;
					inPoint = extensionPointAttribute.equals(attributes.getValue(pointTag));
				} else if ((extensionCount == 1) && inPoint) {
					if ((packageCount == 0) && packageTag.equals(qName)) {
						packageCount++;
						String className = attributes.getValue(classAttribute);
						@SuppressWarnings("null")@NonNull URI nsURI = URI.createURI(attributes.getValue(uriAttribute));
						String genModel = attributes.getValue(genModelAttribute);
						if ((genModel != null) && (className != null)) {
							URI locationURI = projectDescriptor.getLocationURI();
							URI absoluteGenModelURI = URI.createURI(genModel).resolve(locationURI);
							@SuppressWarnings("null")@NonNull URI projectGenModelURI = absoluteGenModelURI.deresolve(locationURI, true, true, true);
							IPackageDescriptor.Internal packageDescriptor = (IPackageDescriptor.Internal) projectDescriptor.getPackageDescriptor(nsURI);
							if (packageDescriptor == null) {
								packageDescriptor = projectDescriptor.createPackageDescriptor(nsURI, projectGenModelURI);
							}
							packageDescriptor.setClassName(className);
							GenModelEcorePackageHandler genModelEcorePackageHandler = packageDescriptor.createGenModelEcorePackageHandler();
							genModelEcorePackageHandlers.put(genModel,genModelEcorePackageHandler);
						}
					}
				}
			}
		}
	}

	/**
	 * GenModelEcorePackageHandler provides the SAX callbacks to support reading
	 * the genPackages element in a genmodel file and invoking {@link
	 * addEcorePackage()} for each encounter.
	 */
	protected static class GenModelEcorePackageHandler extends DefaultHandler
	{
		public static final String genmodelTag = "genmodel:GenModel";

		public static final String genPackagesTag = "genPackages";

		public static final String ecorePackageTag = "ecorePackage";

		public static final String ecorePackageAttribute = "ecorePackage";

		public static final String hrefAttribute = "href";

		protected final IPackageDescriptor.Internal packageDescriptor;

		private int genmodelCount = 0;

		private int genPackagesCount = 0;

		private int ecorePackageCount = 0;

		public GenModelEcorePackageHandler(
				IPackageDescriptor.Internal packageDescriptor) {
			this.packageDescriptor = packageDescriptor;
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if (genmodelCount == 1) {
				if (genmodelTag.equals(qName)) {
					genmodelCount--;
				}
				if (genPackagesCount == 1) {
					if (genPackagesTag.equals(qName)) {
						genPackagesCount--;
					}
					if (ecorePackageCount == 1) {
						if (ecorePackageTag.equals(qName)) {
							ecorePackageCount--;
						}
					}
				}
			}
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes)
				throws SAXException {
			if (genmodelCount == 0) {
				if (genmodelTag.equals(qName)) {
					genmodelCount++;
				}
			} else if (genmodelCount == 1) {
				if ((genPackagesCount == 0) && genPackagesTag.equals(qName)) {
					genPackagesCount++;
					String ecorePackage = attributes
						.getValue(ecorePackageAttribute);
					if (ecorePackage != null) {
						packageDescriptor.addEcorePackage(ecorePackage);
					}
				} else if ((genPackagesCount == 1)
					&& ecorePackageTag.equals(qName)) {
					ecorePackageCount++;
					String ecorePackage = attributes.getValue(hrefAttribute);
					if (ecorePackage != null) {
						packageDescriptor.addEcorePackage(ecorePackage);
					}
				}
			}
		}
	}

	public static class ProjectDescriptor implements IProjectDescriptor.Internal
	{
		/**
		 * The project/bundle/plugin name; e.g. "org.eclipse.emf.ecore"
		 */
		protected final @NonNull String name;

		/**
		 * The resolveable location.
		 */
		protected final @NonNull URI locationURI;

		/**
		 * Map from local Model URI to lazy EPackageDescriptor. e.g. from "model/Ecore.ecore".
		 */
		private @Nullable Map<URI, IPackageDescriptor> nsURI2packageDescriptor = null;

		public ProjectDescriptor(@NonNull String name, @NonNull URI locationURI) {
			this.name = name;
			this.locationURI = locationURI;
		}

		public void configure(@Nullable ResourceSet resourceSet, @NonNull IPackageLoadStrategy packageLoadStrategy, @Nullable IConflictHandler conflictHandler) {
			if (nsURI2packageDescriptor != null) {
				for (IPackageDescriptor packageDescriptor : nsURI2packageDescriptor.values()) {
					packageDescriptor.configure(resourceSet, packageLoadStrategy, conflictHandler);
				}
			}
		}

		public @NonNull IPackageDescriptor.Internal createPackageDescriptor(@NonNull URI nsURI, @NonNull URI genModelURI) {
			IPackageDescriptor.Internal packageDescriptor = new PackageDescriptor(this, nsURI, genModelURI);
			Map<URI, IPackageDescriptor> nsURI2packageDescriptor2 = nsURI2packageDescriptor;
			if (nsURI2packageDescriptor2 == null) {
				nsURI2packageDescriptor = nsURI2packageDescriptor2 = new HashMap<URI, IPackageDescriptor>();
			}
			nsURI2packageDescriptor2.put(nsURI, packageDescriptor);
			return packageDescriptor;
		}

		public @NonNull URI getLocationURI() {
			return locationURI;
		}

		@SuppressWarnings("null")
		public @NonNull URI getLocationURI(@NonNull String projectRelativeFileName) {
			return URI.createURI(projectRelativeFileName).resolve(locationURI);
		}

		public @NonNull File getLocationFile(@NonNull String projectRelativeFileName) {
			return new File(getLocationURI(projectRelativeFileName).toFileString());
		}

		public @NonNull String getName() {
			return name;
		}

		public @Nullable IPackageDescriptor getPackageDescriptor(@NonNull URI nsURI) {
			return nsURI2packageDescriptor != null ? nsURI2packageDescriptor.get(nsURI) : null;
		}

		public @Nullable Collection<IPackageDescriptor> getPackageDescriptors() {
			return nsURI2packageDescriptor != null ? nsURI2packageDescriptor.values() : null;
		}

		@SuppressWarnings("null")
		public @NonNull URI getPlatformPluginURI() {
			return URI.createPlatformPluginURI("/" + name + "/", true);
		}

		@SuppressWarnings("null")
		public @NonNull URI getPlatformPluginURI(@NonNull String projectRelativeFileName) {
			return URI.createURI(projectRelativeFileName).resolve(getPlatformPluginURI());
		}

		@SuppressWarnings("null")
		public @NonNull URI getPlatformResourceURI() {
			return URI.createPlatformResourceURI("/" + name + "/", true);
		}

		@SuppressWarnings("null")
		public @NonNull URI getPlatformResourceURI(@NonNull String projectRelativeFileName) {
			return URI.createURI(projectRelativeFileName).resolve(getPlatformResourceURI());
		}

/*		public void installEcoreModel(@NonNull ResourceSet resourceSet, @NonNull URI nsURI) {
			IPackageDescriptor packageDescriptor = getPackageDescriptor(nsURI);
			if (packageDescriptor != null) {
				EPackage.Registry packageRegistry = getPackageRegistry(resourceSet);
				URI ecoreModelURI = packageDescriptor.getEcoreModelURI();
				URI resourceURI = getPlatformResourceURI();
				URI pluginURI = getPlatformPluginURI();
				URI ecorePackageResourceURI = ecoreModelURI.resolve(resourceURI);
				URI ecorePackagePluginURI = ecoreModelURI.resolve(pluginURI);
				packageRegistry.remove(ecorePackageResourceURI.toString());
				packageRegistry.remove(ecorePackagePluginURI.toString());
				packageRegistry.remove(nsURI.toString());
				URI modelURI = ecoreModelURI.resolve(locationURI);
				Map<URI, URI> uriMap = getURIMap(resourceSet);
				uriMap.put(resourceURI, modelURI);
				uriMap.put(pluginURI, modelURI);
				uriMap.put(nsURI, modelURI);
			}
		} */

		public void initializeGenModelLocationMap(@NonNull Map<URI, IPackageDescriptor> nsURI2package) {
			Collection<IPackageDescriptor> packageDescriptors = getPackageDescriptors();
			if (packageDescriptors != null) {
				Map<String, URI> ePackageNsURIToGenModelLocationMap = EMF_2_9.EcorePlugin.getEPackageNsURIToGenModelLocationMap(false);
				for (IPackageDescriptor packageDescriptor : packageDescriptors) {
					URI nsURI = packageDescriptor.getNamespaceURI();
					URI genModelURI = packageDescriptor.getGenModelURI();
					URI resolvedURI = genModelURI.resolve(locationURI);
					String nsURIstring = nsURI.toString();
					ePackageNsURIToGenModelLocationMap.put(nsURIstring, resolvedURI);
					nsURI2package.put(nsURI, packageDescriptor);
					if (PROJECT_MAP_ADD_GEN_MODEL.isActive()) {
						PROJECT_MAP_ADD_GEN_MODEL.println(nsURI + " => " + resolvedURI);
					}
				}
			}
		}

/*		public void initializePackageRegistration(@NonNull EPackage.Registry packageRegistry, @NonNull IPackageDescriptor packageDescriptor) {
			URI ecoreModelURI = packageDescriptor.getEcoreModelURI();
			if (ecoreModelURI != null) {
				URI resourceURI = getPlatformResourceURI();
				URI pluginURI = getPlatformPluginURI();
				@SuppressWarnings("null")@NonNull URI ecorePackageResourceURI = ecoreModelURI.resolve(resourceURI);
				@SuppressWarnings("null")@NonNull URI ecorePackagePluginURI = ecoreModelURI.resolve(pluginURI);
				PackageDescriptor.TheEPackageDescriptor.install(packageDescriptor, packageRegistry, ecorePackageResourceURI);
				PackageDescriptor.TheEPackageDescriptor.install(packageDescriptor, packageRegistry, ecorePackagePluginURI);
			}
		} */

		public void initializePlatformResourceMap() {
			Map<String, URI> platformResourceMap = EcorePlugin.getPlatformResourceMap();
			platformResourceMap.put(name, locationURI);
		}

		public void initializeURIMap(@NonNull Map<URI, URI> uriMap) {
			URI resourceURI = getPlatformResourceURI();
			URI pluginURI = getPlatformPluginURI();
			uriMap.put(resourceURI, locationURI);
			uriMap.put(pluginURI, locationURI);
			if (PROJECT_MAP_ADD_URI_MAP.isActive()) {
				PROJECT_MAP_ADD_URI_MAP.println(resourceURI + " => " + locationURI);
				PROJECT_MAP_ADD_URI_MAP.println(pluginURI + " => " + locationURI);
			}
		}

		@Override
		public String toString() {
			return name + " => " + locationURI.toString();
		}

/*		public void useModelsAndPackages(@NonNull Resource ecoreResource) {
			for (EObject eObject : ecoreResource.getContents()) {
				if (eObject instanceof EPackage) {
					EPackage ePackage = (EPackage) eObject;
					IPackageDescriptor packageDescriptor = getPackageDescriptor(URI.createURI(ePackage.getNsURI()));
					if (packageDescriptor != null) {
						packageDescriptor.configure(packageRegistry, StandaloneProjectMap.LoadFirstStrategy.INSTANCE, conflictHandler);
						packageDescriptor.setUseModelAndPackage(ePackage, null);
					}
				}
			}
		} */

/*		public void usePackages(@NonNull Resource ecoreResource) {
			for (EObject eObject : ecoreResource.getContents()) {
				if (eObject instanceof EPackage) {
					EPackage ePackage = (EPackage) eObject;
					IPackageDescriptor packageDescriptor = getPackageDescriptor(URI.createURI(ePackage.getNsURI()));
					if (packageDescriptor != null) {
						packageDescriptor.setUsePackage(ePackage, null);
					}
				}
			}
		} */
	}
	
	public static interface IConflictHandler
	{
		/**
		 * Return the EPackage to be used for a namespace URI reference after the model EPackage has already been used.
		 */
		@Nullable EPackage handleConflictingNamespaceURI(@NonNull IPackageLoadStatus packageLoadStatus);

		/**
		 * Return the EPackage to be used for a model URI reference after the namespace EPackage has already been used.
		 */
		@Nullable EPackage handleConflictingModelURI(@NonNull IPackageLoadStatus packageLoadStatus);
	}
	
	/**
	 * MapToFirstConflictHandler resolves conflicts by returning the first loaded EPackage.
	 */
	public static class MapToFirstConflictHandler implements IConflictHandler
	{
		public static final @NonNull IConflictHandler INSTANCE = new MapToFirstConflictHandler();
		
		public @Nullable EPackage handleConflictingNamespaceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.getFirstEPackage();
		}

		public @Nullable EPackage handleConflictingModelURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			return packageLoadStatus.getFirstEPackage();
		}
	}
	
	/**
	 * MapToFirstConflictHandler resolves conflicts by returning the first loaded EPackage.
	 */
	public static class MapToFirstConflictHandlerWithLog implements IConflictHandler
	{
		public static final @NonNull IConflictHandler INSTANCE = new MapToFirstConflictHandlerWithLog();
		
		public @Nullable EPackage handleConflictingNamespaceURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			EPackage firstEPackage = packageLoadStatus.getFirstEPackage();
			IPackageDescriptor packageDescriptor = packageLoadStatus.getPackageDescriptor();
			logger.error("Conflicting access to '" + packageDescriptor.getNamespaceURI() + "' already accessed as '" + packageDescriptor.getPlatformResourceURI() + "' or '" + packageDescriptor.getPlatformPluginURI() + "'");
			packageLoadStatus.setConflictHandler(MapToFirstConflictHandler.INSTANCE);
			return firstEPackage;
		}

		public @Nullable EPackage handleConflictingModelURI(@NonNull IPackageLoadStatus packageLoadStatus) {
			EPackage firstEPackage = packageLoadStatus.getFirstEPackage();
			IPackageDescriptor packageDescriptor = packageLoadStatus.getPackageDescriptor();
			logger.error("Conflicting access to '" + packageDescriptor.getPlatformResourceURI() + "'  or '" + packageDescriptor.getPlatformPluginURI() + "' already accessed as '" + packageDescriptor.getNamespaceURI() + "'");
			packageLoadStatus.setConflictHandler(MapToFirstConflictHandler.INSTANCE);
			return firstEPackage;
		}
	}
	
	/**
	 * Return any StandaloneProjectMap already installed as an adapter on a
	 * <tt>resourceSet</tt>. Returns null if there is no such adapter.
	 */
	public static @Nullable StandaloneProjectMap findAdapter(@NonNull ResourceSet resourceSet) {
		return (StandaloneProjectMap) EcoreUtil.getAdapter(
			resourceSet.eAdapters(), StandaloneProjectMap.class);
	}

	/**
	 * Return the StandaloneProjectMap already installed as an adapter on a
	 * <tt>resourceSet</tt> if one exists, else creates, installs, initializes
	 * and returns a new StandaloneProjectMap.
	 */
	public static @NonNull StandaloneProjectMap getAdapter(@NonNull ResourceSet resourceSet) {
		StandaloneProjectMap adapter = findAdapter(resourceSet);
		if (adapter == null) {
			adapter = new StandaloneProjectMap();
			resourceSet.eAdapters().add(adapter);
			adapter.initializeResourceSet(resourceSet);
		}
		return adapter;
	}

	/**
	 * Return the EPackage.Registry for a resourceSet or the Global
	 * {@link EPackage.Registry.INSTANCE} if resourceSet is null.
	 */
	public static @NonNull EPackage.Registry getPackageRegistry(@Nullable ResourceSet resourceSet) {
		if (resourceSet == null) {
			@SuppressWarnings("null")
			@NonNull
			Registry globalRegistry = EPackage.Registry.INSTANCE;
			return globalRegistry;
		} else {
			@SuppressWarnings("null")
			@NonNull
			Registry packageRegistry = resourceSet.getPackageRegistry();
			return packageRegistry;
		}
	}

	/**
	 * Return the Resource.Factory.Registry for a resourceSet or the Global
	 * {@link Resource.Factory.Registry.INSTANCE} if resourceSet is null.
	 */
	public static Resource.Factory.Registry getResourceFactoryRegistry(
			@Nullable ResourceSet resourceSet) {
		return resourceSet != null
			? resourceSet.getResourceFactoryRegistry()
			: Resource.Factory.Registry.INSTANCE;
	}

	/**
	 * Return the URIConverter for a resourceSet or the Global
	 * {@link URIConverter.INSTANCE} if resourceSet is null.
	 */
	@SuppressWarnings("null")
	public static @NonNull URIConverter getURIConverter(@Nullable ResourceSet resourceSet) {
		return resourceSet != null ? resourceSet.getURIConverter() : URIConverter.INSTANCE;
	}

	/**
	 * Return the URI Map for a resourceSet or the Global
	 * {@link URIConverter.URI_MAP} if resourceSet is null.
	 */
	@SuppressWarnings("null")
	public static @NonNull Map<URI, URI> getURIMap(@Nullable ResourceSet resourceSet) {
		return resourceSet != null ? resourceSet.getURIConverter().getURIMap() : URIConverter.URI_MAP;
	}

	/**
	 * A simple public static method that may be used to force class
	 * initialization.
	 */
	public static void initStatics() {
		new GenModelEcorePackageHandler(null);
		new PluginGenModelHandler(null);
	}

	/**
	 * Activate any ResourceSetImpl.uriResourceMap so that repeated lookups use
	 * a hash rather than linear search.
	 */
	public static void initializeURIResourceMap(@Nullable ResourceSet resourceSet) {
		if (resourceSet instanceof ResourceSetImpl) {
			ResourceSetImpl resourceSetImpl = (ResourceSetImpl) resourceSet;
			Map<URI, Resource> uriResourceMap = resourceSetImpl.getURIResourceMap();
			if (uriResourceMap == null) {
				resourceSetImpl.setURIResourceMap(new HashMap<URI, Resource>());
			}
		}
	}

	public StandaloneProjectMap() {
		super();
	}

	/**
	 * Exceptions encountered during processing as a map from File to Exception.
	 */
	private @Nullable Map<File, Exception> exceptionMap = null;

	/**
	 * The map of bundle/project name to project descriptor.
	 */
	private Map<String, IProjectDescriptor.Internal> project2descriptor = null;

	protected boolean initializedPlatformResourceMap = false;

	/**
	 * The map of package nsURI to package descriptor.
	 */
	protected @Nullable Map<URI, IPackageDescriptor> nsURI2package = null;

	/**
	 * Configure the PackageRegistry associated with ResourceSet to use a packageLoadStrategy and conflictHandler when
	 * resolving namespace ansd platform URIs.
	 */
	public void configure(@Nullable ResourceSet resourceSet, @NonNull IPackageLoadStrategy packageLoadStrategy, @Nullable IConflictHandler conflictHandler) {
		Map<String, IProjectDescriptor.Internal> projectDescriptors = getProjectDescriptors();
		if (projectDescriptors != null) {
			for (IProjectDescriptor projectDescriptor : projectDescriptors.values()) {
				projectDescriptor.configure(resourceSet, packageLoadStrategy, conflictHandler);
			}
		}
	}

	protected @NonNull IProjectDescriptor.Internal createProjectDescriptor(@NonNull String projectName, @NonNull URI locationURI) {
		return new ProjectDescriptor(projectName, locationURI);
	}

	/**
	 * Return the IPackageDescriptor for a given nsURI.
	 */
	public @Nullable IPackageDescriptor getPackageDescriptor(@NonNull URI nsURI) {
		return nsURI2package != null ? nsURI2package.get(nsURI) : null;
	}

	/**
	 * Return the IProjectDescriptor for a given project or bundle name.
	 */
	public @Nullable IProjectDescriptor getProjectDescriptor(@NonNull String projectName) {
		Map<String, IProjectDescriptor.Internal> projectDescriptors = getProjectDescriptors();
		if (projectDescriptors == null) {
			return null;
		}
		return projectDescriptors.get(projectName);
	}

	protected @NonNull IProjectDescriptor.Internal getProjectDescriptorInternal(@NonNull URI platformURI) {
		@SuppressWarnings("null")@NonNull String projectName = platformURI.segment(1);
		getProjectDescriptors();
		IProjectDescriptor.Internal projectDescriptor = project2descriptor.get(projectName);
		if (projectDescriptor == null) {
			@SuppressWarnings("null")@NonNull URI locationURI = platformURI.trimSegments(platformURI.segmentCount() - 2).appendSegment("");
			projectDescriptor = createProjectDescriptor(projectName, locationURI);
			project2descriptor.put(projectName, projectDescriptor);
		}
		return projectDescriptor;
	}

	/**
	 * Return the mapping of problem files to exceptions, or null if not yet
	 * computed or if no exceptions thrown.
	 */
	public @Nullable Map<File, Exception> getExceptionMap() {
		return exceptionMap;
	}

	/**
	 * Return the resolveable URI for a given project or bundle name.
	 */
	public @Nullable URI getLocation(@NonNull String projectName) {
		Map<String, IProjectDescriptor.Internal> projectDescriptors = getProjectDescriptors();
		if (projectDescriptors == null) {
			return null;
		}
		IProjectDescriptor projectDescriptor = projectDescriptors.get(projectName);
		if (projectDescriptor == null) {
			return null;
		}
		return projectDescriptor.getLocationURI();
	}

	/**
	 * Return the mapping of project name or bundle name, as defined in a
	 * manifest file to the location of that project as determined by scanning
	 * the classpath.
	 * <p>
	 * e.g. entries such as <br>
	 * org.antlr.runtime =>
	 * archive:file:/C:/Tools/Eclipse/3.7.1/plugins/org.antlr
	 * .runtime_3.2.0.v201101311130.jar!/ <br>
	 * org.eclipse.ocl.examples.common =>
	 * file:/C:/GIT/org.eclipse.ocl/examples/org.eclipse.ocl.examples.common/
	 * <p>
	 * Any problems arising while creating the project map are gathered into the
	 * exception map accessible using {@link #getExceptionMap()}. An overall
	 * problem may be attributed to the null file.
	 */
	protected synchronized @Nullable Map<String, IProjectDescriptor.Internal> getProjectDescriptors() {
		Map<String, IProjectDescriptor.Internal> project2descriptor2 = project2descriptor;
		if (project2descriptor2 == null) {
			project2descriptor = project2descriptor2 = new HashMap<String, IProjectDescriptor.Internal>();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			try {
				SAXParser saxParser = factory.newSAXParser();
				if (saxParser != null) {
					scanClassPath(project2descriptor2, saxParser);
				}
			} catch (Exception e) {
				logException(null, e);
				return null;
			}
		}
		return project2descriptor2;
	}

	/**
	 * Initialize the
	 * {@link EcorePlugin#getEPackageNsURIToGenModelLocationMap()} so that in a
	 * standalone environment the locations of all genmodels are available.
	 * <p>
	 * Initialization is only necessary once and for a standalone environment.
	 * If <tt>force</tt> is true a re-initialization or plugin initialization
	 * may be forced.
	 */
	public synchronized void initializeGenModelLocationMap(boolean force) {
		if (force || (nsURI2package == null)) {
			Map<URI, IPackageDescriptor> nsURI2package2 = new HashMap<URI, IPackageDescriptor> ();
			nsURI2package = nsURI2package2;
			Map<String, IProjectDescriptor.Internal> projectDescriptors = getProjectDescriptors();
			if (projectDescriptors != null) {
				for (IProjectDescriptor projectDescriptor : projectDescriptors.values()) {
					projectDescriptor.initializeGenModelLocationMap(nsURI2package2);
				}
			}
		}
	}

	/**
	 * Install lazy EPackageDescriptors in the EPackage.Registry for all
	 * registered packages and their platform:/plugin and platform:/resource
	 * synonyms, which are determined by examining the genPackages.ecorePackage
	 * attribute in all genModels.
	 */
	public synchronized void initializePackageRegistry(@Nullable ResourceSet resourceSet) {
		getProjectDescriptors();
		for (IProjectDescriptor projectDescriptor : project2descriptor.values()) {
			Collection<IPackageDescriptor> packageDescriptors = projectDescriptor.getPackageDescriptors();
			if (packageDescriptors != null) {
				for (IPackageDescriptor packageDescriptor : packageDescriptors) {
					assert packageDescriptor != null;
					if (packageDescriptor.getEcoreModelURI() != null) {
						packageDescriptor.getPackageLoadStatus(resourceSet, MapToFirstConflictHandlerWithLog.INSTANCE);
					}
				}
			}
		}
	}

	/**
	 * Initialize the {@link EcorePlugin#getPlatformResourceMap()} so that in a
	 * standalone environment and in conjunction with {@link
	 * initializeURIMap(URIConverter)} URIs such as
	 * <tt>platform:/resource/<i>project</i></tt> and
	 * <tt>platform:/plugin/<i>project</i></tt> are useable.
	 * <p>
	 * Initialization is only necessary once and for a standalone environment.
	 * If <tt>force</tt> is true a re-initialization or plugin initialization
	 * may be forced.
	 */
	public synchronized void initializePlatformResourceMap(boolean force) {
		if (force || !initializedPlatformResourceMap) {
			initializedPlatformResourceMap = true;
			getProjectDescriptors();
			for (IProjectDescriptor projectDescriptor : project2descriptor.values()) {
				projectDescriptor.initializePlatformResourceMap();
			}
		}
	}

	/**
	 * Ensure that both the {@link EcorePlugin#getPlatformResourceMap()} and
	 * {@link ResourceSet#getURIConverter()} are initialized so that
	 * <tt>platform:/resource/<i>project</i></tt> and
	 * <tt>platform:/plugin/<i>project</i></tt> are useable..
	 * 
	 * A null ResourceSet may be used to provoke initialization of the global
	 * EPackage.Registry.INSTANCE and URIConverter.URI_MAP.
	 */
	public void initializeResourceSet(@Nullable ResourceSet resourceSet) {
		initializeURIResourceMap(resourceSet);
		initializePlatformResourceMap(false);
		initializeURIMap(resourceSet);
		initializeGenModelLocationMap(false);
		initializePackageRegistry(resourceSet);
	}

	/**
	 * Initialize the uriMap of a uriConverter so that each of
	 * <tt>platform:/resource/<i>project</i></tt> and
	 * <tt>platform:/plugin/<i>project</i></tt> resolve the workspace project
	 * resource else the plugin bundle for use in either standalone or plugin
	 * environment.
	 * <p>
	 * Note that in a plugin environment, a single <tt>platform:/resource/</tt>
	 * to <tt>platform:/plugin/</tt> mapping is sufficient since
	 * <tt>platform:/plugin/</tt> is directly resolveable by the Eclipse
	 * Platform.
	 */
	public synchronized void initializeURIMap(@Nullable ResourceSet resourceSet) {
		getProjectDescriptors();
		Map<URI, URI> uriMap = getURIMap(resourceSet);
		for (String project : project2descriptor.keySet()) {
			IProjectDescriptor projectDescriptor = project2descriptor.get(project);
			projectDescriptor.initializeURIMap(uriMap);
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return (type instanceof Class<?>)
			&& ((Class<?>) type).isAssignableFrom(StandaloneProjectMap.class);
	}

	protected void logException(@Nullable File file, @NonNull Exception e) {
		Map<File, Exception> exceptionMap2 = exceptionMap;
		if (exceptionMap2 == null) {
			exceptionMap = exceptionMap2 = new HashMap<File, Exception>();
		}
		exceptionMap2.put(file, e);
	}

	protected @Nullable IProjectDescriptor registerBundle(@NonNull File file, @NonNull SAXParser saxParser) {
		try {
			JarFile jarFile = new JarFile(file);
			Manifest manifest = jarFile.getManifest();
			if (manifest == null) {
				return null;
			}
			String project = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
			if (project != null) {
				final int indexOf = project.indexOf(';');
				if (indexOf > 0) {
					project = project.substring(0, indexOf);
				}
				IProjectDescriptor.Internal projectDescriptor = project2descriptor.get(project);
				if (projectDescriptor != null)
					return projectDescriptor;
				String path = "archive:" + file.toURI() + "!/";
				@SuppressWarnings("null")@NonNull URI locationURI = URI.createURI(path);
				assert project != null;
				projectDescriptor = createProjectDescriptor(project, locationURI);
				project2descriptor.put(project, projectDescriptor);
				ZipEntry entry = jarFile.getEntry("plugin.xml");
				if (entry != null) {
					InputStream inputStream = jarFile.getInputStream(entry);
					try {
						PluginGenModelHandler pluginGenModelHandler = new PluginGenModelHandler(jarFile, projectDescriptor);
						saxParser.parse(inputStream, pluginGenModelHandler);
						pluginGenModelHandler.scanContents(saxParser);
					} finally {
						inputStream.close();
					}
				}
				return projectDescriptor;
			}
		} catch (ZipException e) {
			logException(file, new WrappedException("Could not open Jar file " + file.getAbsolutePath() + ".", e));
		} catch (Exception e) {
			logException(file, e);
		}
		return null;
	}

	protected @Nullable IProjectDescriptor.Internal registerProject(@NonNull File file) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
			String project = document.getDocumentElement().getElementsByTagName("name").item(0).getTextContent();
			if (project != null) {
				@SuppressWarnings("null")@NonNull URI locationURI = URI.createFileURI(file.getParentFile().getCanonicalPath() + File.separator);
				IProjectDescriptor.Internal projectDescriptor = createProjectDescriptor(project, locationURI);
				project2descriptor.put(project, projectDescriptor);
				return projectDescriptor;
			}
		} catch (Exception e) {
			logException(file, new WrappedException("Couldn't read " + file, e));
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}
		return null;
	}

	protected void scanClassPath(@NonNull Map<String, IProjectDescriptor.Internal> projectDescriptors, @NonNull SAXParser saxParser) {
		String property = System.getProperty("java.class.path");
		String separator = System.getProperty("path.separator");
		if (property != null) {
			String[] entries = property.split(separator);
			for (String entry : entries) {
				File fileEntry = new File(entry);
				try {
					File f = fileEntry.getCanonicalFile();
					if (f.getPath().endsWith(".jar")) {
						registerBundle(f, saxParser);
					} else if (!scanFolder(f, saxParser, new HashSet<String>(), 0)) {
						// eclipse bin folder?
						File parentFile = f.getParentFile();
						File dotProject = new File(parentFile, ".project");
						if (dotProject.exists()) {
							IProjectDescriptor.Internal projectDescriptor = registerProject(dotProject);
							if (projectDescriptor != null) {
								File plugIn = new File(parentFile, "plugin.xml");
								if (plugIn.exists()) {
									PluginGenModelHandler pluginGenModelHandler = new PluginGenModelHandler(projectDescriptor);
									saxParser.parse(plugIn, pluginGenModelHandler);
									pluginGenModelHandler.scanContents(saxParser);
								}
							}
						}
					}
				} catch (Exception e) {
					logException(fileEntry, e);
				}
			}
		}
	}

	protected boolean scanFolder(@NonNull File f, @NonNull SAXParser saxParser, @NonNull Set<String> alreadyVisited, int depth) {
		try {
			if (!alreadyVisited.add(f.getCanonicalPath()))
				return true;
		} catch (Exception e) {
			logException(f, e);
			return true;
		}
		File[] files = f.listFiles();
		boolean containsProject = false;
		File dotProject = null;
		if (files != null) {
			for (File file : files) {
				if (file.exists() && file.isDirectory() && (depth < 2) && !file.getName().startsWith(".")) {
					containsProject |= scanFolder(file, saxParser, alreadyVisited, depth + 1);
				} else if (".project".equals(file.getName())) {
					dotProject = file;
				} else if (file.getName().endsWith(".jar")) {
					registerBundle(file, saxParser);
				}
			}
		}
		if (!containsProject && dotProject != null)
			registerProject(dotProject);
		return containsProject || dotProject != null;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (project2descriptor != null) {
			List<String> projectNames = new ArrayList<String>(project2descriptor.keySet());
			Collections.sort(projectNames);
			for (String projectName : projectNames) {
				if (s.length() > 0) {
					s.append("\n");
				}
				s.append(projectName);
				s.append(" => ");
				s.append(project2descriptor.get(projectName).getLocationURI());
			}
		}
		return s.toString();
	}
}
