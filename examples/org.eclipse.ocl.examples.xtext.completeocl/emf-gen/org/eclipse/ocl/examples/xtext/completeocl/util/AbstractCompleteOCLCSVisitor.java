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
public abstract class AbstractCompleteOCLCSVisitor<R, C>
 extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractEssentialOCLCSVisitor<R, C>
	implements CompleteOCLCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractCompleteOCLCSVisitor(@NonNull C context) {
	    super(context);
	}
}
