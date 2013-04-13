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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface VisitableCS
{
	/**
	 * Returns the result of accepting a visit from a visitor.
	 * Implementations typically invoke a derived-class-specific
	 * variant of visitXXX() to facilitate derived-class-specific
	 * processing or just visit() when no such method is available.
	 * <p>
	 * Implementations of visit() may use the EcoreSwitch to perform
	 * derived-class-specific processing.
	 * <p>
	 * Derived implementations of accept() may use getAdapter() to obtain
	 * richer visitor interfaces.
	 * @param <R, C>
	 * @param visitor
	 * @return the result of the visit.
	 */
	@Nullable <R> R accept(@NonNull org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor<R> visitor);
	
	EClass eClass();
}
