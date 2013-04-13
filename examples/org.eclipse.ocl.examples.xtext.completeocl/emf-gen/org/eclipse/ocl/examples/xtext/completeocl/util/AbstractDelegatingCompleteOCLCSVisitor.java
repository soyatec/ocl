/**
 * 
 *
 * This code is auto-generated
 * from: model/CompleteOCLCST.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.ocl.examples.xtext.completeocl.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingCompleteOCLCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingCompleteOCLCSVisitor<R, C, D extends CompleteOCLCSVisitor<R>>
	extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements CompleteOCLCSVisitor<R>
{
    protected AbstractDelegatingCompleteOCLCSVisitor(@NonNull D delegate, @NonNull C context) {
        super(delegate, context);
    }

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitBodyCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS object) {
		return delegate.visitBodyCS(object);
	}

	public @Nullable R visitClassifierContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS object) {
		return delegate.visitClassifierContextDeclCS(object);
	}

	public @Nullable R visitCompleteOCLDocumentCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS object) {
		return delegate.visitCompleteOCLDocumentCS(object);
	}

	public @Nullable R visitContextConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS object) {
		return delegate.visitContextConstraintCS(object);
	}

	public @Nullable R visitContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS object) {
		return delegate.visitContextDeclCS(object);
	}

	public @Nullable R visitContextSpecificationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextSpecificationCS object) {
		return delegate.visitContextSpecificationCS(object);
	}

	public @Nullable R visitDefCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS object) {
		return delegate.visitDefCS(object);
	}

	public @Nullable R visitDefFeatureCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefFeatureCS object) {
		return delegate.visitDefFeatureCS(object);
	}

	public @Nullable R visitDefOperationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefOperationCS object) {
		return delegate.visitDefOperationCS(object);
	}

	public @Nullable R visitDefPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefPropertyCS object) {
		return delegate.visitDefPropertyCS(object);
	}

	public @Nullable R visitDerCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS object) {
		return delegate.visitDerCS(object);
	}

	public @Nullable R visitFeatureContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS object) {
		return delegate.visitFeatureContextDeclCS(object);
	}

	public @Nullable R visitIncludeCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.IncludeCS object) {
		return delegate.visitIncludeCS(object);
	}

	public @Nullable R visitInitCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS object) {
		return delegate.visitInitCS(object);
	}

	public @Nullable R visitInvCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS object) {
		return delegate.visitInvCS(object);
	}

	public @Nullable R visitOCLMessageArgCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OCLMessageArgCS object) {
		return delegate.visitOCLMessageArgCS(object);
	}

	public @Nullable R visitOperationContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS object) {
		return delegate.visitOperationContextDeclCS(object);
	}

	public @Nullable R visitPackageDeclarationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS object) {
		return delegate.visitPackageDeclarationCS(object);
	}

	public @Nullable R visitPathNameDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PathNameDeclCS object) {
		return delegate.visitPathNameDeclCS(object);
	}

	public @Nullable R visitPostCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS object) {
		return delegate.visitPostCS(object);
	}

	public @Nullable R visitPreCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS object) {
		return delegate.visitPreCS(object);
	}

	public @Nullable R visitPropertyContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS object) {
		return delegate.visitPropertyContextDeclCS(object);
	}
}
