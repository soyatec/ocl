package org.eclipse.ocl.examples.domain.compatibility;

import java.lang.reflect.Method;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

/**
 * EMF_2_9 provides backwards compatible implementations of functionality first available in EMF 2.9.
 */
@SuppressWarnings("deprecation")
public class EMF_2_9
{
	private static final Method ECORE_PLUGIN_GET_EPACKAGE_NSURI_TO_GEN_MODEL_LOCATION_MAP_METHOD;

	static {
		Method ecorePlugin_getEPackageNsURIToGenModelLocationMap_Method = null;

		try {
			Class<?> pluginEcorePluginClass = org.eclipse.emf.ecore.plugin.EcorePlugin.class; //CommonPlugin.loadClass("org.eclipse.emf.ecore","org.eclipse.emf.ecore.plugin.EcorePlugin");
			ecorePlugin_getEPackageNsURIToGenModelLocationMap_Method = pluginEcorePluginClass.getMethod("getEPackageNsURIToGenModelLocationMap", boolean.class);
		} catch (Throwable exception) {
			// Ignore.
		}

		ECORE_PLUGIN_GET_EPACKAGE_NSURI_TO_GEN_MODEL_LOCATION_MAP_METHOD = ecorePlugin_getEPackageNsURIToGenModelLocationMap_Method;
	}
	  
	public static class EcorePlugin {

		/**
		 * EMF 2.9 deprecates EcorePlugin.getEPackageNsURIToGenModelLocationMap() in favor of
		 * EcorePlugin.getEPackageNsURIToGenModelLocationMap(boolean) so redirect the new call
		 * to the original method if the new method unavailable.
		 */
		@SuppressWarnings("unchecked")
		public static Map<String, URI> getEPackageNsURIToGenModelLocationMap(boolean targetPlatform) {
			if (ECORE_PLUGIN_GET_EPACKAGE_NSURI_TO_GEN_MODEL_LOCATION_MAP_METHOD != null) {
				try {
					return (Map<String, URI>) ECORE_PLUGIN_GET_EPACKAGE_NSURI_TO_GEN_MODEL_LOCATION_MAP_METHOD.invoke(null, targetPlatform);
				} catch (Exception e) {
				}
			}
			return org.eclipse.emf.ecore.plugin.EcorePlugin.getEPackageNsURIToGenModelLocationMap();
		}
	}
}