/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
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
 * from: org.eclipse.ocl.examples.xtext.base/model/BaseCST.genmodel
 * by: org.eclipse.ocl.examples.build.xtend.GenerateVisitors
 * invoked by: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 */
package	org.eclipse.ocl.examples.xtext.base.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingBaseCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingBaseCSVisitor<R, C, D extends BaseCSVisitor<R>>
	extends AbstractBaseCSVisitor<R, C>
	implements BaseCSVisitor<R>
{
	protected final D delegate;
	
	protected AbstractDelegatingBaseCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(context);
	//	assert delegate != null : "cannot decorate a null visitor"; //$NON-NLS-1$
		this.delegate = delegate;		
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	//	public @NonNull DecorableBaseCSVisitor<R> createNestedVisitor() {
	//		return delegate.createNestedVisitor();
	//	}

	/**
	 * Obtains the visitor that I decorate.
	 * 
	 * @return my decorated visitor
	 */
	@SuppressWarnings("null")
	protected final @NonNull D getDelegate() {
		return delegate;
	}

	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitAnnotationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS object) {
		return delegate.visitAnnotationCS(object);
	}

	public @Nullable R visitAnnotationElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS object) {
		return delegate.visitAnnotationElementCS(object);
	}

	public @Nullable R visitAttributeCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS object) {
		return delegate.visitAttributeCS(object);
	}

	public @Nullable R visitClassCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS object) {
		return delegate.visitClassCS(object);
	}

	public @Nullable R visitClassifierCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS object) {
		return delegate.visitClassifierCS(object);
	}

	public @Nullable R visitConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS object) {
		return delegate.visitConstraintCS(object);
	}

	public @Nullable R visitDataTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS object) {
		return delegate.visitDataTypeCS(object);
	}

	public @Nullable R visitDetailCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS object) {
		return delegate.visitDetailCS(object);
	}

	public @Nullable R visitDocumentationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS object) {
		return delegate.visitDocumentationCS(object);
	}

	public @Nullable R visitElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitElementRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ElementRefCS object) {
		return delegate.visitElementRefCS(object);
	}

	public @Nullable R visitEnumerationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS object) {
		return delegate.visitEnumerationCS(object);
	}

	public @Nullable R visitEnumerationLiteralCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS object) {
		return delegate.visitEnumerationLiteralCS(object);
	}

	public @Nullable R visitImportCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS object) {
		return delegate.visitImportCS(object);
	}

	public @Nullable R visitLambdaTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.LambdaTypeCS object) {
		return delegate.visitLambdaTypeCS(object);
	}

	public @Nullable R visitLibraryCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS object) {
		return delegate.visitLibraryCS(object);
	}

	public @Nullable R visitModelElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS object) {
		return delegate.visitModelElementCS(object);
	}

	public @Nullable R visitModelElementRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementRefCS object) {
		return delegate.visitModelElementRefCS(object);
	}

	public @Nullable R visitMultiplicityBoundsCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityBoundsCS object) {
		return delegate.visitMultiplicityBoundsCS(object);
	}

	public @Nullable R visitMultiplicityStringCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.MultiplicityStringCS object) {
		return delegate.visitMultiplicityStringCS(object);
	}

	public @Nullable R visitNamedElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public @Nullable R visitOperationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS object) {
		return delegate.visitOperationCS(object);
	}

	public @Nullable R visitPackageCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS object) {
		return delegate.visitPackageCS(object);
	}

	public @Nullable R visitParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS object) {
		return delegate.visitParameterCS(object);
	}

	public @Nullable R visitPathElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PathElementCS object) {
		return delegate.visitPathElementCS(object);
	}

	public @Nullable R visitPathElementWithURICS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PathElementWithURICS object) {
		return delegate.visitPathElementWithURICS(object);
	}

	public @Nullable R visitPathNameCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS object) {
		return delegate.visitPathNameCS(object);
	}

	public @Nullable R visitPivotableElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PivotableElementCS object) {
		return delegate.visitPivotableElementCS(object);
	}

	public @Nullable R visitPrimitiveTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS object) {
		return delegate.visitPrimitiveTypeRefCS(object);
	}

	public @Nullable R visitReferenceCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS object) {
		return delegate.visitReferenceCS(object);
	}

	public @Nullable R visitRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS object) {
		return delegate.visitRootPackageCS(object);
	}

	public @Nullable R visitSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.SpecificationCS object) {
		return delegate.visitSpecificationCS(object);
	}

	public @Nullable R visitStructuralFeatureCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS object) {
		return delegate.visitStructuralFeatureCS(object);
	}

	public @Nullable R visitTemplateBindingCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS object) {
		return delegate.visitTemplateBindingCS(object);
	}

	public @Nullable R visitTemplateParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS object) {
		return delegate.visitTemplateParameterCS(object);
	}

	public @Nullable R visitTemplateParameterSubstitutionCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS object) {
		return delegate.visitTemplateParameterSubstitutionCS(object);
	}

	public @Nullable R visitTemplateSignatureCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS object) {
		return delegate.visitTemplateSignatureCS(object);
	}

	public @Nullable R visitTuplePartCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS object) {
		return delegate.visitTuplePartCS(object);
	}

	public @Nullable R visitTupleTypeCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS object) {
		return delegate.visitTupleTypeCS(object);
	}

	public @Nullable R visitTypeParameterCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS object) {
		return delegate.visitTypeParameterCS(object);
	}

	public @Nullable R visitTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS object) {
		return delegate.visitTypeRefCS(object);
	}

	public @Nullable R visitTypedElementCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public @Nullable R visitTypedRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS object) {
		return delegate.visitTypedRefCS(object);
	}

	public @Nullable R visitTypedTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS object) {
		return delegate.visitTypedTypeRefCS(object);
	}

	public @Nullable R visitWildcardTypeRefCS(@NonNull org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS object) {
		return delegate.visitWildcardTypeRefCS(object);
	}
}
