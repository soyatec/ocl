/**
 * 
 *
 * This code is auto-generated
 * from: model/OCLstdlibCST.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.ocl.examples.xtext.oclstdlib.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface OCLstdlibCSVisitor<R> extends org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitLibClassCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS object);
	@Nullable R visitLibConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS object);
	@Nullable R visitLibIterationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS object);
	@Nullable R visitLibOperationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS object);
	@Nullable R visitLibPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPackageCS object);
	@Nullable R visitLibPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS object);
	@Nullable R visitLibRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS object);
	@Nullable R visitMetaTypeName(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.MetaTypeName object);
	@Nullable R visitPrecedenceCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS object);
}
