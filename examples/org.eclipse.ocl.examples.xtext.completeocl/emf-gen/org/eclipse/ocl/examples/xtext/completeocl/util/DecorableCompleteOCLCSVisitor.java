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

/**
 */
public interface DecorableCompleteOCLCSVisitor<R> extends CompleteOCLCSVisitor<R>, org.eclipse.ocl.examples.xtext.essentialocl.util.DecorableEssentialOCLCSVisitor<R>
{
	void setUndecoratedVisitor(@NonNull org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor<R> visitor);
}
