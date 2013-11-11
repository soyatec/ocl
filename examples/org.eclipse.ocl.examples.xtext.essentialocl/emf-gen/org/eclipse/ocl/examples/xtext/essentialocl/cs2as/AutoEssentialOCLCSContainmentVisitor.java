/*
 * «codeGenHelper.getCopyright(' * ')»
 *************************************************************************
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 */

package org.eclipse.ocl.examples.xtext.essentialocl.cs2as;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.NewBaseCSContainmentVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IndexExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NamedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PrimitiveLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

public class AutoEssentialOCLCSContainmentVisitor
	extends NewBaseCSContainmentVisitor
	implements EssentialOCLCSVisitor<Continuation<?>>
{
    
    protected final @NonNull CS2Pivot converter;
    protected final @NonNull IdResolver idResolver;
    
    /**
     * Initializes me with an initial value for my result.
     * 
     * @param context my initial result value
     */
    public AutoEssentialOCLCSContainmentVisitor(@NonNull CS2PivotConversion context) {
        super(context);
        this.converter = context.getConverter();
        this.idResolver = converter.getMetaModelManager().getIdResolver();
    }
    
    public @Nullable Continuation<?> visitAbstractNameExpCS(@NonNull AbstractNameExpCS self) {
        throw new UnsupportedOperationException("visitAbstractNameExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitBinaryOperatorCS(@NonNull BinaryOperatorCS self) {
        throw new UnsupportedOperationException("visitBinaryOperatorCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitBooleanLiteralExpCS(@NonNull BooleanLiteralExpCS self) {
        throw new UnsupportedOperationException("visitBooleanLiteralExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitCollectionLiteralExpCS(@NonNull CollectionLiteralExpCS self) {
        throw new UnsupportedOperationException("visitCollectionLiteralExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitCollectionLiteralPartCS(@NonNull CollectionLiteralPartCS self) {
        throw new UnsupportedOperationException("visitCollectionLiteralPartCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitCollectionTypeCS(@NonNull CollectionTypeCS self) {
        throw new UnsupportedOperationException("visitCollectionTypeCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitConstructorExpCS(@NonNull ConstructorExpCS self) {
        throw new UnsupportedOperationException("visitConstructorExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitConstructorPartCS(@NonNull ConstructorPartCS self) {
        throw new UnsupportedOperationException("visitConstructorPartCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitContextCS(@NonNull ContextCS self) {
        throw new UnsupportedOperationException("visitContextCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitExpCS(@NonNull ExpCS self) {
        throw new UnsupportedOperationException("visitExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitExpSpecificationCS(@NonNull ExpSpecificationCS self) {
        throw new UnsupportedOperationException("visitExpSpecificationCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitIfExpCS(@NonNull IfExpCS self) {
        throw new UnsupportedOperationException("visitIfExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitIndexExpCS(@NonNull IndexExpCS self) {
        throw new UnsupportedOperationException("visitIndexExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitInfixExpCS(@NonNull InfixExpCS self) {
        throw new UnsupportedOperationException("visitInfixExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitInvalidLiteralExpCS(@NonNull InvalidLiteralExpCS self) {
        throw new UnsupportedOperationException("visitInvalidLiteralExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitInvocationExpCS(@NonNull InvocationExpCS self) {
        throw new UnsupportedOperationException("visitInvocationExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitLetExpCS(@NonNull LetExpCS self) {
        throw new UnsupportedOperationException("visitLetExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitLetVariableCS(@NonNull LetVariableCS self) {
        throw new UnsupportedOperationException("visitLetVariableCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitLiteralExpCS(@NonNull LiteralExpCS self) {
        throw new UnsupportedOperationException("visitLiteralExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitNameExpCS(@NonNull NameExpCS self) {
        throw new UnsupportedOperationException("visitNameExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitNamedExpCS(@NonNull NamedExpCS self) {
        throw new UnsupportedOperationException("visitNamedExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitNavigatingArgCS(@NonNull NavigatingArgCS self) {
        throw new UnsupportedOperationException("visitNavigatingArgCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitNavigationOperatorCS(@NonNull NavigationOperatorCS self) {
        throw new UnsupportedOperationException("visitNavigationOperatorCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitNestedExpCS(@NonNull NestedExpCS self) {
        throw new UnsupportedOperationException("visitNestedExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitNullLiteralExpCS(@NonNull NullLiteralExpCS self) {
        throw new UnsupportedOperationException("visitNullLiteralExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitNumberLiteralExpCS(@NonNull NumberLiteralExpCS self) {
        throw new UnsupportedOperationException("visitNumberLiteralExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitOperatorCS(@NonNull OperatorCS self) {
        throw new UnsupportedOperationException("visitOperatorCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitPrefixExpCS(@NonNull PrefixExpCS self) {
        throw new UnsupportedOperationException("visitPrefixExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitPrimitiveLiteralExpCS(@NonNull PrimitiveLiteralExpCS self) {
        throw new UnsupportedOperationException("visitPrimitiveLiteralExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitSelfExpCS(@NonNull SelfExpCS self) {
        throw new UnsupportedOperationException("visitSelfExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitStringLiteralExpCS(@NonNull StringLiteralExpCS self) {
        throw new UnsupportedOperationException("visitStringLiteralExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitTupleLiteralExpCS(@NonNull TupleLiteralExpCS self) {
        throw new UnsupportedOperationException("visitTupleLiteralExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitTupleLiteralPartCS(@NonNull TupleLiteralPartCS self) {
        throw new UnsupportedOperationException("visitTupleLiteralPartCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitTypeLiteralExpCS(@NonNull TypeLiteralExpCS self) {
        throw new UnsupportedOperationException("visitTypeLiteralExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitTypeNameExpCS(@NonNull TypeNameExpCS self) {
        throw new UnsupportedOperationException("visitTypeNameExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitUnaryOperatorCS(@NonNull UnaryOperatorCS self) {
        throw new UnsupportedOperationException("visitUnaryOperatorCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitUnlimitedNaturalLiteralExpCS(@NonNull UnlimitedNaturalLiteralExpCS self) {
        throw new UnsupportedOperationException("visitUnlimitedNaturalLiteralExpCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitVariableCS(@NonNull VariableCS self) {
        throw new UnsupportedOperationException("visitVariableCS is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitBigNumber(@NonNull Number self) {
        throw new UnsupportedOperationException("visitBigNumber is not supported by " + getClass().getName());
    }
    
    public @Nullable Continuation<?> visitNavigationRole(@NonNull Enumerator self) {
        throw new UnsupportedOperationException("visitNavigationRole is not supported by " + getClass().getName());
    }
}
