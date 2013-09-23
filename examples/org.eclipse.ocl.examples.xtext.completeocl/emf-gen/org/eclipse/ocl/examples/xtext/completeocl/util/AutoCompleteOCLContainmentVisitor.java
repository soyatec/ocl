/*
 * «codeGenHelper.getCopyright(' * ')»
 *************************************************************************
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 */

package org.eclipse.ocl.examples.xtext.completeocl.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefOperationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefPropertyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.IncludeCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OCLMessageArgCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PathNameDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.util.CompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.util.cs2as.EssentialOCLContainmentVisitor;

public class AutoCompleteOCLContainmentVisitor
	extends EssentialOCLContainmentVisitor
	implements CompleteOCLCSVisitor<Continuation<?>>
{
    
    protected final @NonNull CS2Pivot converter;
    protected final @NonNull IdResolver idResolver;
    
    /**
     * Initializes me with an initial value for my result.
     * 
     * @param context my initial result value
     */
    public AutoCompleteOCLContainmentVisitor(@NonNull CS2PivotConversion context) {
        super(context);
        this.converter = context.getConverter();
        this.idResolver = converter.getMetaModelManager().getIdResolver();
    }
    
    public @Nullable Continuation<?> visitClassifierContextDeclCS(@NonNull ClassifierContextDeclCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitCompleteOCLDocumentCS(@NonNull CompleteOCLDocumentCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitContextDeclCS(@NonNull ContextDeclCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitDefCS(@NonNull DefCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitDefOperationCS(@NonNull DefOperationCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitDefPropertyCS(@NonNull DefPropertyCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitFeatureContextDeclCS(@NonNull FeatureContextDeclCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitIncludeCS(@NonNull IncludeCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitOCLMessageArgCS(@NonNull OCLMessageArgCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitOperationContextDeclCS(@NonNull OperationContextDeclCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitPackageDeclarationCS(@NonNull PackageDeclarationCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitPathNameDeclCS(@NonNull PathNameDeclCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitPropertyContextDeclCS(@NonNull PropertyContextDeclCS self) {
        throw new UnsupportedOperationException();
    }
}
