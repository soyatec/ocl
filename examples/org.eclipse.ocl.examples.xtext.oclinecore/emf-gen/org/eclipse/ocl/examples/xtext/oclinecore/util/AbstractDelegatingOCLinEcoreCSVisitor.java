/**
 * 
 *
 * This code is auto-generated
 * from: model/OCLinEcoreCST.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.ocl.examples.xtext.oclinecore.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingOCLinEcoreCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingOCLinEcoreCSVisitor<R, C, D extends OCLinEcoreCSVisitor<R>>
	extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements OCLinEcoreCSVisitor<R>
{
    protected AbstractDelegatingOCLinEcoreCSVisitor(@NonNull D delegate, @NonNull C context) {
        super(delegate, context);
    }

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitOCLinEcoreConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS object) {
		return delegate.visitOCLinEcoreConstraintCS(object);
	}
}
