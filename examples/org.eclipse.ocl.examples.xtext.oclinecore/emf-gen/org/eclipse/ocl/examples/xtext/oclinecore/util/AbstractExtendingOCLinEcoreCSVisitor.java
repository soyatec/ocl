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
 * An AbstractExtendingOCLinEcoreCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingOCLinEcoreCSVisitor<R, C>
	extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements OCLinEcoreCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingOCLinEcoreCSVisitor(@NonNull C context) {
	    super(context);
	}	

	public @Nullable R visitOCLinEcoreConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS object) {
		return visitConstraintCS(object);
	}
}
