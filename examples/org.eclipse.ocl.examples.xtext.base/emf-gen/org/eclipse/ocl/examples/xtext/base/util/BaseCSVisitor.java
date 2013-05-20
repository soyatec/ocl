/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 * 
 *
 * This code is auto-generated
 * from: model/BaseCST.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.ocl.examples.xtext.base.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface BaseCSVisitor<R>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class, 
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	@Nullable <A> A getAdapter(@NonNull Class<A> adapter);

	/**
     * Return the result of visiting a visitable for which no more specific pivot type method
     * is available.
     */
	@Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable);

	@Nullable R visitAnnotationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS object);
	@Nullable R visitAnnotationElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS object);
	@Nullable R visitAttributeCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS object);
	@Nullable R visitClassCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS object);
	@Nullable R visitClassifierCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS object);
	@Nullable R visitConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS object);
	@Nullable R visitDataTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS object);
	@Nullable R visitDetailCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS object);
	@Nullable R visitDocumentationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS object);
	@Nullable R visitElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS object);
	@Nullable R visitElementRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ElementRefCS object);
	@Nullable R visitEnumerationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS object);
	@Nullable R visitEnumerationLiteralCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS object);
	@Nullable R visitImportCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS object);
	@Nullable R visitLambdaTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.LambdaTypeCS object);
	@Nullable R visitLibraryCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS object);
	@Nullable R visitModelElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS object);
	@Nullable R visitModelElementRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementRefCS object);
	@Nullable R visitMultiplicityBoundsCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityBoundsCS object);
	@Nullable R visitMultiplicityStringCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityStringCS object);
	@Nullable R visitNamedElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS object);
	@Nullable R visitOperationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS object);
	@Nullable R visitPackageCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS object);
	@Nullable R visitParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS object);
	@Nullable R visitPathElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PathElementCS object);
	@Nullable R visitPathElementWithURICS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PathElementWithURICS object);
	@Nullable R visitPathNameCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS object);
	@Nullable R visitPivotableElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PivotableElementCS object);
	@Nullable R visitPrimitiveTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS object);
	@Nullable R visitReferenceCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS object);
	@Nullable R visitRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS object);
	@Nullable R visitSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.SpecificationCS object);
	@Nullable R visitStructuralFeatureCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS object);
	@Nullable R visitTemplateBindingCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS object);
	@Nullable R visitTemplateParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS object);
	@Nullable R visitTemplateParameterSubstitutionCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS object);
	@Nullable R visitTemplateSignatureCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS object);
	@Nullable R visitTuplePartCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS object);
	@Nullable R visitTupleTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS object);
	@Nullable R visitTypeParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS object);
	@Nullable R visitTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS object);
	@Nullable R visitTypedElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS object);
	@Nullable R visitTypedRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS object);
	@Nullable R visitTypedTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS object);
	@Nullable R visitWildcardTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS object);
}
