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
 * This code is auto-generated
 * from: /org.eclipse.ocl.examples.xtext.base/model/BaseCST.ecore
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
 * An AbstractExtendingBaseCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingBaseCSVisitor<R, C>
	extends AbstractBaseCSVisitor<R, C>
	implements BaseCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingBaseCSVisitor(@NonNull C context) {
	    super(context);
	}	

	public @Nullable R visitAnnotationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS object) {
		return visitAnnotationElementCS(object);
	}

	public @Nullable R visitAnnotationElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitAttributeCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS object) {
		return visitStructuralFeatureCS(object);
	}

	public @Nullable R visitClassCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS object) {
		return visitClassifierCS(object);
	}

	public @Nullable R visitClassifierCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitCollectionTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS object) {
		return visitTypedTypeRefCS(object);
	}

	public @Nullable R visitConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitDataTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS object) {
		return visitClassifierCS(object);
	}

	public @Nullable R visitDetailCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitDocumentationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS object) {
		return visitAnnotationElementCS(object);
	}

	public @Nullable R visitElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS object) {
		return visiting(object);
	}

	public @Nullable R visitElementRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ElementRefCS object) {
		return visitPivotableElementCS(object);
	}

	public @Nullable R visitEnumerationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS object) {
		return visitClassifierCS(object);
	}

	public @Nullable R visitEnumerationLiteralCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitImportCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitLambdaTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.LambdaTypeCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitLibraryCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitModelElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS object) {
		return visitPivotableElementCS(object);
	}

	public @Nullable R visitModelElementRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementRefCS object) {
		return visitElementRefCS(object);
	}

	public @Nullable R visitMultiplicityBoundsCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityBoundsCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitMultiplicityStringCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityStringCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitNamedElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitOperationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS object) {
		return visitTypedElementCS(object);
	}

	public @Nullable R visitPackageCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS object) {
		return visitTypedElementCS(object);
	}

	public @Nullable R visitPathElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PathElementCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitPathElementWithURICS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PathElementWithURICS object) {
		return visitPathElementCS(object);
	}

	public @Nullable R visitPathNameCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitPivotableElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PivotableElementCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitPrimitiveTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitReferenceCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS object) {
		return visitStructuralFeatureCS(object);
	}

	public @Nullable R visitRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS object) {
		return visitPackageCS(object);
	}

	public @Nullable R visitSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.SpecificationCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitStructuralFeatureCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS object) {
		return visitTypedElementCS(object);
	}

	public @Nullable R visitTemplateBindingCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS object) {
		return visitElementRefCS(object);
	}

	public @Nullable R visitTemplateParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitTemplateParameterSubstitutionCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitTemplateSignatureCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitTuplePartCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS object) {
		return visitTypedElementCS(object);
	}

	public @Nullable R visitTupleTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitTypeParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS object) {
		return visitTemplateParameterCS(object);
	}

	public @Nullable R visitTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS object) {
		return visitElementRefCS(object);
	}

	public @Nullable R visitTypedElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitTypedRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS object) {
		return visitTypeRefCS(object);
	}

	public @Nullable R visitTypedTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitWildcardTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS object) {
		return visitTypeRefCS(object);
	}
}
