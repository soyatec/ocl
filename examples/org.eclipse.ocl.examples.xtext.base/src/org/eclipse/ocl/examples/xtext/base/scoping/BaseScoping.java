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
package org.eclipse.ocl.examples.xtext.base.scoping;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.ocl.examples.pivot.scoping.EmptyAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.ClassCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.ConstraintCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.ImportCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.LambdaTypeCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.LibraryCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.OperationCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.PackageCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.PathElementCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.PivotCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.ReferenceCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.RootPackageCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.SpecificationCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.TemplateParameterSubstitutionCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.TemplateSignatureCSAttribution;
import org.eclipse.ocl.examples.xtext.base.attributes.TypedTypeRefCSAttribution;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot.AbstractUnresolvedProxyMessageProvider;


public class BaseScoping
{	
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(BaseCSTPackage.Literals.CLASS_CS, ClassCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.CONSTRAINT_CS, ConstraintCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.DATA_TYPE_CS, PivotCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.ELEMENT_CS, EmptyAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.ENUMERATION_CS, PivotCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.IMPORT_CS, ImportCSAttribution.INSTANCE);	// return new ImportAttribution();		// WIP static instance
		registry.put(BaseCSTPackage.Literals.LAMBDA_TYPE_CS, LambdaTypeCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.LIBRARY_CS, LibraryCSAttribution.INSTANCE);	// return new LibraryAttribution();		// WIP static instance
		registry.put(BaseCSTPackage.Literals.OPERATION_CS, OperationCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.PACKAGE_CS, PackageCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.PATH_ELEMENT_CS, PathElementCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.REFERENCE_CS, ReferenceCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.ROOT_PACKAGE_CS, RootPackageCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.SPECIFICATION_CS, SpecificationCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS, TemplateParameterSubstitutionCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.TEMPLATE_SIGNATURE_CS, TemplateSignatureCSAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.TUPLE_TYPE_CS, EmptyAttribution.INSTANCE);
		registry.put(BaseCSTPackage.Literals.TYPED_TYPE_REF_CS, TypedTypeRefCSAttribution.INSTANCE);
		CS2Pivot.addUnresolvedProxyMessageProvider(ImportCSAttribution.INSTANCE);			
		CS2Pivot.addUnresolvedProxyMessageProvider(LibraryCSAttribution.INSTANCE);			
		CS2Pivot.addUnresolvedProxyMessageProvider(new SimpleNamedElementRefCSTypeUnresolvedProxyMessageProvider());			
		CS2Pivot.addUnresolvedProxyMessageProvider(new TypedTypeRefCSTypeUnresolvedProxyMessageProvider());
	}
	
	private static final class SimpleNamedElementRefCSTypeUnresolvedProxyMessageProvider extends AbstractUnresolvedProxyMessageProvider
	{		
		private SimpleNamedElementRefCSTypeUnresolvedProxyMessageProvider() {
			super(BaseCSTPackage.Literals.PATH_ELEMENT_CS__ELEMENT);
		}
		
		@Override
		public @Nullable String getMessage(@NonNull EObject context, @NonNull String linkText) {
			PathElementCS pathElement = (PathElementCS)context;
			EClassifier elementType = pathElement.getElementType();
			PathNameCS pathName = pathElement.getPathName();
			List<PathElementCS> path = pathName.getPath();
			int index = path.indexOf(pathElement);
			if (index > 0) {
				Element pathScope = path.get(index-1).getElement();
				if ((pathScope == null) || pathScope.eIsProxy()) {
					return null;		// Suppress message for child when parent has error
				}
			}
			String element = elementType != null ? elementType.getName() : "unknown";
			@SuppressWarnings("null") @NonNull String messageTemplate = OCLMessages.Unresolved_ERROR_;
			return CS2Pivot.getMessageBinder().bind(context, messageTemplate, element, linkText);
		}
	}
	
	private static final class TypedTypeRefCSTypeUnresolvedProxyMessageProvider extends AbstractUnresolvedProxyMessageProvider
	{		
		private TypedTypeRefCSTypeUnresolvedProxyMessageProvider() {
			super(BaseCSTPackage.Literals.TYPED_TYPE_REF_CS__TYPE);
		}
		
		@Override
		public @Nullable String getMessage(@NonNull EObject context, @NonNull String linkText) {
			@SuppressWarnings("null") @NonNull String messageTemplate = OCLMessages.UnresolvedType_ERROR_;
			return CS2Pivot.getMessageBinder().bind(context, messageTemplate, linkText);
		}
	}
}
