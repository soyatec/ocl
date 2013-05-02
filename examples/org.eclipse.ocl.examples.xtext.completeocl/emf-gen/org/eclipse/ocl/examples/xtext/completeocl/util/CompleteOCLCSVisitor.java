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
 */
public interface CompleteOCLCSVisitor<R> extends org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitClassifierContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS object);
	@Nullable R visitCompleteOCLDocumentCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS object);
	@Nullable R visitContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS object);
	@Nullable R visitDefCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS object);
	@Nullable R visitDefOperationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefOperationCS object);
	@Nullable R visitDefPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefPropertyCS object);
	@Nullable R visitFeatureContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS object);
	@Nullable R visitIncludeCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.IncludeCS object);
	@Nullable R visitOCLMessageArgCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OCLMessageArgCS object);
	@Nullable R visitOperationContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS object);
	@Nullable R visitPackageDeclarationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS object);
	@Nullable R visitPathNameDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PathNameDeclCS object);
	@Nullable R visitPropertyContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS object);
}
