/*
 * «codeGenHelper.getCopyright(' * ')»
 *************************************************************************
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 */

package org.eclipse.ocl.examples.xtext.base.cs2as;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DetailCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.basecs.FeatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.LambdaTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityCS;
import org.eclipse.ocl.examples.xtext.base.basecs.MultiplicityStringCS;
import org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathElementWithURICS;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.AbstractBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS;

public class AutoBaseCSContainmentVisitor
	extends AbstractBaseCSVisitor<Continuation<?>, CS2PivotConversion>
{
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_BaseCST = IdManager.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/BaseCST", "basecs", BaseCSPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", "pivot", PivotPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Enumeration = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Enumeration", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_EnumerationCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_BaseCST.getClassId("EnumerationCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_EnumerationLiteral = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("EnumerationLiteral", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_EnumerationLiteralCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_BaseCST.getClassId("EnumerationLiteralCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Operation = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Operation", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OperationCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_BaseCST.getClassId("OperationCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PackageCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_BaseCST.getClassId("PackageCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Parameter = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Parameter", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ParameterCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_BaseCST.getClassId("ParameterCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Property = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Property", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_StructuralFeatureCS = PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_BaseCST.getClassId("StructuralFeatureCS", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_EnumerationLiteral = TypeId.ORDERED_SET.getSpecializedId(CLSSid_EnumerationLiteral);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_EnumerationLiteralCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_EnumerationLiteralCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_EnumerationLiteral = TypeId.SEQUENCE.getSpecializedId(CLSSid_EnumerationLiteral);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(CLSSid_Package);
    
    protected final @NonNull CS2Pivot converter;
    protected final @NonNull IdResolver idResolver;
    
    /**
     * Initializes me with an initial value for my result.
     * 
     * @param context my initial result value
     */
    public AutoBaseCSContainmentVisitor(@NonNull CS2PivotConversion context) {
        super(context);
        this.converter = context.getConverter();
        this.idResolver = converter.getMetaModelManager().getIdResolver();
    }
    
    public @Nullable Continuation<?> visiting(@NonNull VisitableCS visitable) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitAnnotationCS(@NonNull AnnotationCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitAnnotationElementCS(@NonNull AnnotationElementCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitAttributeCS(@NonNull AttributeCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitClassCS(@NonNull ClassCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitClassifierCS(@NonNull ClassifierCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitConstraintCS(@NonNull ConstraintCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitDataTypeCS(@NonNull DataTypeCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitDetailCS(@NonNull DetailCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitDocumentationCS(@NonNull DocumentationCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitElementCS(@NonNull ElementCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitElementRefCS(@NonNull ElementRefCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitEnumerationCS(@NonNull EnumerationCS self) {
        //
        // Enumeration
        //
        Enumeration result;
        Element element = converter.getPivotElement(self);
        if ((element != null) && (element.getClass() == Enumeration.class)) {
            result = (Enumeration)element;
        }
        else {
            result = PivotFactory.eINSTANCE.createEnumeration();
            assert result != null;
            converter.installPivotDefinition(self, result);
        }
        //
        // NamedElement::name
        //
        final @Nullable /*@Thrown*/ String name = self.getName();
        if ((name != result.getName()) && (name == null || !name.equals(result.getName()))) {
            result.setName(name);
        }
        //
        // Enumeration::ownedLiteral
        //
        final @Nullable /*@Thrown*/ List<EnumerationLiteralCS> ownedLiterals = self.getOwnedLiterals();
        assert ownedLiterals != null;
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedLiterals = idResolver.createOrderedSetOfAll(ORD_CLSSid_EnumerationLiteralCS, ownedLiterals);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValuesUtil.createSequenceAccumulatorValue(SEQ_CLSSid_EnumerationLiteral);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedLiterals.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ EnumerationLiteralCS _1 = (EnumerationLiteralCS)ITERATOR__1.next();
            /**
             * ast()
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'null\'");
            }
            final @Nullable /*@Thrown*/ EnumerationLiteral ast = (EnumerationLiteral)_1.getPivot();
            //
            accumulator.add(ast);
        }
        final List<EnumerationLiteral> UNBOXED_collect = collect.asEcoreObjects(idResolver, EnumerationLiteral.class);
        assert UNBOXED_collect != null;
        context.refreshList(result.getOwnedLiteral(), UNBOXED_collect);
        // AS element comments update;
        context.refreshComments(result, self);
        return null;
    }
    
    public @Nullable Continuation<?> visitEnumerationLiteralCS(@NonNull EnumerationLiteralCS self) {
        //
        // EnumerationLiteral
        //
        EnumerationLiteral result;
        Element element = converter.getPivotElement(self);
        if ((element != null) && (element.getClass() == EnumerationLiteral.class)) {
            result = (EnumerationLiteral)element;
        }
        else {
            result = PivotFactory.eINSTANCE.createEnumerationLiteral();
            assert result != null;
            converter.installPivotDefinition(self, result);
        }
        //
        // NamedElement::name
        //
        final @Nullable /*@Thrown*/ String name = self.getName();
        if ((name != result.getName()) && (name == null || !name.equals(result.getName()))) {
            result.setName(name);
        }
        // AS element comments update;
        context.refreshComments(result, self);
        return null;
    }
    
    public @Nullable Continuation<?> visitFeatureCS(@NonNull FeatureCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitImportCS(@NonNull ImportCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitLambdaTypeCS(@NonNull LambdaTypeCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitLibraryCS(@NonNull LibraryCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitModelElementCS(@NonNull ModelElementCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitModelElementRefCS(@NonNull ModelElementRefCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitMultiplicityBoundsCS(@NonNull MultiplicityBoundsCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitMultiplicityCS(@NonNull MultiplicityCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitMultiplicityStringCS(@NonNull MultiplicityStringCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitNamedElementCS(@NonNull NamedElementCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitNamespaceCS(@NonNull NamespaceCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitOperationCS(@NonNull OperationCS self) {
        //
        // Operation
        //
        Operation result;
        Element element = converter.getPivotElement(self);
        if ((element != null) && (element.getClass() == Operation.class)) {
            result = (Operation)element;
        }
        else {
            result = PivotFactory.eINSTANCE.createOperation();
            assert result != null;
            converter.installPivotDefinition(self, result);
        }
        //
        // NamedElement::name
        //
        final @Nullable /*@Thrown*/ String name = self.getName();
        if ((name != result.getName()) && (name == null || !name.equals(result.getName()))) {
            result.setName(name);
        }
        // AS element comments update;
        context.refreshComments(result, self);
        return null;
    }
    
    public @Nullable Continuation<?> visitPackageCS(@NonNull PackageCS self) {
        //
        // Package
        //
        Package result;
        Element element = converter.getPivotElement(self);
        if ((element != null) && (element.getClass() == Package.class)) {
            result = (Package)element;
        }
        else {
            result = PivotFactory.eINSTANCE.createPackage();
            assert result != null;
            converter.installPivotDefinition(self, result);
        }
        //
        // NamedElement::name
        //
        final @Nullable /*@Thrown*/ String name = self.getName();
        if ((name != result.getName()) && (name == null || !name.equals(result.getName()))) {
            result.setName(name);
        }
        //
        // Package::nestedPackage
        //
        final @Nullable /*@Thrown*/ List<PackageCS> ownedNestedPackage = self.getOwnedNestedPackage();
        assert ownedNestedPackage != null;
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedNestedPackage = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedNestedPackage);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValuesUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedNestedPackage.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ PackageCS _1 = (PackageCS)ITERATOR__1.next();
            /**
             * ast()
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'null\'");
            }
            final @Nullable /*@Thrown*/ Package ast = (Package)_1.getPivot();
            //
            accumulator.add(ast);
        }
        final List<? extends Package> UNBOXED_collect = collect.asEcoreObjects(idResolver, Package.class);
        assert UNBOXED_collect != null;
        context.refreshList(result.getNestedPackage(), UNBOXED_collect);
        // AS element comments update;
        context.refreshComments(result, self);
        return null;
    }
    
    public @Nullable Continuation<?> visitParameterCS(@NonNull ParameterCS self) {
        //
        // Parameter
        //
        Parameter result;
        Element element = converter.getPivotElement(self);
        if ((element != null) && (element.getClass() == Parameter.class)) {
            result = (Parameter)element;
        }
        else {
            result = PivotFactory.eINSTANCE.createParameter();
            assert result != null;
            converter.installPivotDefinition(self, result);
        }
        //
        // NamedElement::name
        //
        final @Nullable /*@Thrown*/ String name = self.getName();
        if ((name != result.getName()) && (name == null || !name.equals(result.getName()))) {
            result.setName(name);
        }
        // AS element comments update;
        context.refreshComments(result, self);
        return null;
    }
    
    public @Nullable Continuation<?> visitPathElementCS(@NonNull PathElementCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitPathElementWithURICS(@NonNull PathElementWithURICS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitPathNameCS(@NonNull PathNameCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitPivotableElementCS(@NonNull PivotableElementCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitPrimitiveTypeRefCS(@NonNull PrimitiveTypeRefCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitReferenceCS(@NonNull ReferenceCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitRootCS(@NonNull RootCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitRootPackageCS(@NonNull RootPackageCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitSpecificationCS(@NonNull SpecificationCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitStructuralFeatureCS(@NonNull StructuralFeatureCS self) {
        //
        // Property
        //
        Property result;
        Element element = converter.getPivotElement(self);
        if ((element != null) && (element.getClass() == Property.class)) {
            result = (Property)element;
        }
        else {
            result = PivotFactory.eINSTANCE.createProperty();
            assert result != null;
            converter.installPivotDefinition(self, result);
        }
        //
        // NamedElement::name
        //
        final @Nullable /*@Thrown*/ String name = self.getName();
        if ((name != result.getName()) && (name == null || !name.equals(result.getName()))) {
            result.setName(name);
        }
        // AS element comments update;
        context.refreshComments(result, self);
        return null;
    }
    
    public @Nullable Continuation<?> visitTemplateBindingCS(@NonNull TemplateBindingCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitTemplateParameterCS(@NonNull TemplateParameterCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitTemplateParameterSubstitutionCS(@NonNull TemplateParameterSubstitutionCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitTemplateSignatureCS(@NonNull TemplateSignatureCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitTemplateableElementCS(@NonNull TemplateableElementCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitTuplePartCS(@NonNull TuplePartCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitTupleTypeCS(@NonNull TupleTypeCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitTypeCS(@NonNull TypeCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitTypeParameterCS(@NonNull TypeParameterCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitTypeRefCS(@NonNull TypeRefCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitTypedElementCS(@NonNull TypedElementCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitTypedRefCS(@NonNull TypedRefCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitTypedTypeRefCS(@NonNull TypedTypeRefCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitVisitableCS(@NonNull VisitableCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitWildcardTypeRefCS(@NonNull WildcardTypeRefCS self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitIteratorKind(@NonNull Enumerator self) {
        throw new UnsupportedOperationException();
    }
    
    public @Nullable Continuation<?> visitScopeFilter(@NonNull ScopeFilter self) {
        throw new UnsupportedOperationException();
    }
}
