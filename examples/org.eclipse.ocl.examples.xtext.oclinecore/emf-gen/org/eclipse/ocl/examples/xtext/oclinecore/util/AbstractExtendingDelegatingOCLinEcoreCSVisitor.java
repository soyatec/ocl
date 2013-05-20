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
import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;

/**
 * An AbstractExtendingDelegatingOCLinEcoreCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingOCLinEcoreCSVisitor<R, C, D extends EssentialOCLCSVisitor<R>>
	extends AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements OCLinEcoreCSVisitor<R>
{
    protected AbstractExtendingDelegatingOCLinEcoreCSVisitor(@NonNull D delegate, @NonNull C context) {
        super(delegate, context);
    }

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitOCLinEcoreConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS object) {
		return delegate.visitConstraintCS(object);
	}

	public @Nullable R visitSysMLCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.SysMLCS object) {
		return delegate.visitAnnotationElementCS(object);
	}
}
