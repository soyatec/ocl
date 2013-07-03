/**
 * <copyright>
 * 
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *************************************************************************
 * This code is 100% auto-generated
 * from: pivot
 * using: org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 */
package org.eclipse.ocl.examples.pivot;

import java.lang.String;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.DataTypeId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumeration;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumerationLiteral;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.examples.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorFragment;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.examples.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.examples.library.executor.ExecutorTypeParameter;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotTables;

/**
 * PivotTables provides the dispatch tables for the pivot for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class PivotTables
{
	/**
	 *	The package descriptor for the package.
	 */
	public static final @NonNull EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(PivotPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final @NonNull ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot = IdManager.getNsURIPackageId("http://www.eclipse.org/ocl/3.1.0/Pivot", PivotPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Annotation = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Annotation", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_AssociationClass = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("AssociationClass", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_AssociationClassCallExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("AssociationClassCallExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_BagType = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("BagType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Behavior = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Behavior", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_BooleanLiteralExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("BooleanLiteralExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_CallExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("CallExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_CallOperationAction = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("CallOperationAction", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_CollectionItem = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("CollectionItem", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_CollectionLiteralExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("CollectionLiteralExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_CollectionLiteralPart = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("CollectionLiteralPart", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_CollectionType = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("CollectionType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Comment = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Comment", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ConnectionPointReference = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("ConnectionPointReference", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Constraint = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Constraint", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ConstructorExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("ConstructorExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ConstructorPart = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("ConstructorPart", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_DataType = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("DataType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Detail = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Detail", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_DynamicElement = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("DynamicElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_DynamicProperty = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("DynamicProperty", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_DynamicType = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("DynamicType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Element = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Element", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ElementExtension = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("ElementExtension", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_EnumLiteralExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("EnumLiteralExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Enumeration = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Enumeration", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_EnumerationLiteral = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("EnumerationLiteral", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ExpressionInOCL = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("ExpressionInOCL", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IfExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("IfExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Import = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Import", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IntegerLiteralExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("IntegerLiteralExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IterateExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("IterateExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Iteration = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Iteration", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IteratorExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("IteratorExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_LetExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("LetExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Library = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Library", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_LoopExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("LoopExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_MessageExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("MessageExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_MessageType = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("MessageType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Metaclass = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Metaclass", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_NamedElement = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("NamedElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Namespace = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Namespace", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_NavigationCallExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("NavigationCallExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OCLExpression = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OCLExpression", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OclElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OpaqueExpression = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OpaqueExpression", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Operation = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Operation", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OperationCallExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OperationCallExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OrderedSetType = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("OrderedSetType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Parameter = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Parameter", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ParameterableElement = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("ParameterableElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Precedence = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Precedence", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Profile = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Profile", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Property = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Property", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PropertyCallExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("PropertyCallExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Pseudostate = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Pseudostate", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Region = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Region", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Root = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Root", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_SendSignalAction = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("SendSignalAction", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_SequenceType = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("SequenceType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_SetType = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("SetType", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Signal = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Signal", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_State = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("State", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_StateExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("StateExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_StateMachine = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("StateMachine", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Stereotype = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Stereotype", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TemplateBinding = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("TemplateBinding", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TemplateParameter = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("TemplateParameter", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TemplateParameterSubstitution = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("TemplateParameterSubstitution", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TemplateSignature = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("TemplateSignature", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TemplateableElement = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("TemplateableElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Transition = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Transition", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Trigger = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Trigger", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TupleLiteralExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("TupleLiteralExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TupleLiteralPart = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("TupleLiteralPart", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Type = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Type", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TypeExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("TypeExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TypeTemplateParameter = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("TypeTemplateParameter", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TypedElement = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("TypedElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TypedMultiplicityElement = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("TypedMultiplicityElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ValueSpecification = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("ValueSpecification", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Variable = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Variable", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_VariableDeclaration = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("VariableDeclaration", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_VariableExp = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("VariableExp", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Vertex = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getClassId("Vertex", 0);
    public static final @NonNull /*@NonInvalid*/ DataTypeId DATAid_Integer = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getDataTypeId("Integer", 0);
    public static final @NonNull /*@NonInvalid*/ DataTypeId DATAid_LibraryFeature = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getDataTypeId("LibraryFeature", 0);
    public static final @NonNull /*@NonInvalid*/ DataTypeId DATAid_Real = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getDataTypeId("Real", 0);
    public static final @NonNull /*@NonInvalid*/ DataTypeId DATAid_UnlimitedNatural = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getDataTypeId("UnlimitedNatural", 0);
    public static final @NonNull /*@NonInvalid*/ EnumerationId ENUMid_AssociativityKind = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getEnumerationId("AssociativityKind");
    public static final @NonNull /*@NonInvalid*/ EnumerationId ENUMid_CollectionKind = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getEnumerationId("CollectionKind");
    public static final @NonNull /*@NonInvalid*/ EnumerationId ENUMid_PseudostateKind = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getEnumerationId("PseudostateKind");
    public static final @NonNull /*@NonInvalid*/ EnumerationId ENUMid_TransitionKind = PivotTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_3_1_0_s_Pivot.getEnumerationId("TransitionKind");
    public static final @NonNull /*@NonInvalid*/ IntegerValue INT_1 = ValuesUtil.integerValueOf("1");
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_PRIMid_String = TypeId.ORDERED_SET.getSpecializedId(TypeId.STRING);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_PRIMid_Integer = TypeId.SEQUENCE.getSpecializedId(TypeId.INTEGER);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_PRIMid_String = TypeId.SEQUENCE.getSpecializedId(TypeId.STRING);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_PRIMid_String = TypeId.SET.getSpecializedId(TypeId.STRING);
    public static final @NonNull /*@NonInvalid*/ String STR_Boolean = "Boolean";
    public static final @NonNull /*@NonInvalid*/ String STR_any = "any";
    public static final @NonNull /*@NonInvalid*/ String STR_closure = "closure";
    public static final @NonNull /*@NonInvalid*/ String STR_collect = "collect";
    public static final @NonNull /*@NonInvalid*/ String STR_collectNested = "collectNested";
    public static final @NonNull /*@NonInvalid*/ String STR_exists = "exists";
    public static final @NonNull /*@NonInvalid*/ String STR_forAll = "forAll";
    public static final @NonNull /*@NonInvalid*/ String STR_isUnique = "isUnique";
    public static final @NonNull /*@NonInvalid*/ String STR_name = "name";
    public static final @NonNull /*@NonInvalid*/ String STR_one = "one";
    public static final @NonNull /*@NonInvalid*/ String STR_reject = "reject";
    public static final @NonNull /*@NonInvalid*/ String STR_select = "select";
    public static final @NonNull /*@NonInvalid*/ String STR_sortedBy = "sortedBy";
    public static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_Bag = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId("Bag");
    public static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_Collection = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId("Collection");
    public static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_OrderedSet = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId("OrderedSet");
    public static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_Sequence = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId("Sequence");
    public static final @NonNull /*@NonInvalid*/ EnumerationLiteralId ELITid_Set = PivotTables.ENUMid_CollectionKind.getEnumerationLiteralId("Set");
    public static final @NonNull /*@NonInvalid*/ MetaclassId METAid_Metaclass = TypeId.METACLASS.getSpecializedId(PivotTables.CLSSid_ParameterableElement);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Annotation = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_Annotation);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_CollectionLiteralPart = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_CollectionLiteralPart);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ConstructorPart = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_ConstructorPart);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Detail = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_Detail);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Element = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_Element);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_EnumerationLiteral = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_EnumerationLiteral);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Import = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_Import);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_OCLExpression = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_OCLExpression);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_Operation);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_Parameter);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Precedence = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_Precedence);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_Property);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_TemplateParameter = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_TemplateParameter);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_TupleLiteralPart = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_TupleLiteralPart);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Type = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_Type);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Variable = TypeId.ORDERED_SET.getSpecializedId(PivotTables.CLSSid_Variable);
    public static final @NonNull /*@NonInvalid*/ PropertyId PROPid_name = PivotTables.CLSSid_NamedElement.getPropertyId("name");
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Type = TypeId.SEQUENCE.getSpecializedId(PivotTables.CLSSid_Type);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_AssociationClassCallExp = TypeId.SET.getSpecializedId(PivotTables.CLSSid_AssociationClassCallExp);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Behavior = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Behavior);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_CallOperationAction = TypeId.SET.getSpecializedId(PivotTables.CLSSid_CallOperationAction);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_CollectionType = TypeId.SET.getSpecializedId(PivotTables.CLSSid_CollectionType);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Comment = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Comment);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ConnectionPointReference = TypeId.SET.getSpecializedId(PivotTables.CLSSid_ConnectionPointReference);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Constraint = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Constraint);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ConstructorPart = TypeId.SET.getSpecializedId(PivotTables.CLSSid_ConstructorPart);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_DataType = TypeId.SET.getSpecializedId(PivotTables.CLSSid_DataType);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_DynamicElement = TypeId.SET.getSpecializedId(PivotTables.CLSSid_DynamicElement);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_DynamicProperty = TypeId.SET.getSpecializedId(PivotTables.CLSSid_DynamicProperty);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Element = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Element);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ElementExtension = TypeId.SET.getSpecializedId(PivotTables.CLSSid_ElementExtension);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_EnumLiteralExp = TypeId.SET.getSpecializedId(PivotTables.CLSSid_EnumLiteralExp);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Import = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Import);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_LoopExp = TypeId.SET.getSpecializedId(PivotTables.CLSSid_LoopExp);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_MessageType = TypeId.SET.getSpecializedId(PivotTables.CLSSid_MessageType);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Metaclass = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Metaclass);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_NavigationCallExp = TypeId.SET.getSpecializedId(PivotTables.CLSSid_NavigationCallExp);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_OCLExpression = TypeId.SET.getSpecializedId(PivotTables.CLSSid_OCLExpression);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(PivotTables.CLSSid_OclElement);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Operation = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Operation);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_OperationCallExp = TypeId.SET.getSpecializedId(PivotTables.CLSSid_OperationCallExp);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Package = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Package);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ParameterableElement = TypeId.SET.getSpecializedId(PivotTables.CLSSid_ParameterableElement);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Property = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Property);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_PropertyCallExp = TypeId.SET.getSpecializedId(PivotTables.CLSSid_PropertyCallExp);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Pseudostate = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Pseudostate);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Region = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Region);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_SendSignalAction = TypeId.SET.getSpecializedId(PivotTables.CLSSid_SendSignalAction);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_State = TypeId.SET.getSpecializedId(PivotTables.CLSSid_State);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_StateExp = TypeId.SET.getSpecializedId(PivotTables.CLSSid_StateExp);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_StateMachine = TypeId.SET.getSpecializedId(PivotTables.CLSSid_StateMachine);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Stereotype = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Stereotype);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_TemplateBinding = TypeId.SET.getSpecializedId(PivotTables.CLSSid_TemplateBinding);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_TemplateParameterSubstitution = TypeId.SET.getSpecializedId(PivotTables.CLSSid_TemplateParameterSubstitution);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_TemplateSignature = TypeId.SET.getSpecializedId(PivotTables.CLSSid_TemplateSignature);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Transition = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Transition);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Trigger = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Trigger);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Type = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Type);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_TypeExp = TypeId.SET.getSpecializedId(PivotTables.CLSSid_TypeExp);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_TypeTemplateParameter = TypeId.SET.getSpecializedId(PivotTables.CLSSid_TypeTemplateParameter);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_TypedElement = TypeId.SET.getSpecializedId(PivotTables.CLSSid_TypedElement);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Variable = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Variable);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_VariableExp = TypeId.SET.getSpecializedId(PivotTables.CLSSid_VariableExp);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Vertex = TypeId.SET.getSpecializedId(PivotTables.CLSSid_Vertex);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		public static final @NonNull ExecutorTypeParameter _Visitor_R = new ExecutorTypeParameter(TypeId.T_1, LIBRARY, "R");
	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		public static final @NonNull EcoreExecutorType _Annotation = new EcoreExecutorType(PivotPackage.Literals.ANNOTATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _AnyType = new EcoreExecutorType(PivotPackage.Literals.ANY_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _AssociationClass = new EcoreExecutorType(PivotPackage.Literals.ASSOCIATION_CLASS, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _AssociationClassCallExp = new EcoreExecutorType(PivotPackage.Literals.ASSOCIATION_CLASS_CALL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorEnumeration _AssociativityKind = new EcoreExecutorEnumeration(PivotPackage.Literals.ASSOCIATIVITY_KIND, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _BagType = new EcoreExecutorType(PivotPackage.Literals.BAG_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Behavior = new EcoreExecutorType(PivotPackage.Literals.BEHAVIOR, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _BooleanLiteralExp = new EcoreExecutorType(PivotPackage.Literals.BOOLEAN_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CallExp = new EcoreExecutorType(PivotPackage.Literals.CALL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CallOperationAction = new EcoreExecutorType(PivotPackage.Literals.CALL_OPERATION_ACTION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Class = new EcoreExecutorType(PivotPackage.Literals.CLASS, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CollectionItem = new EcoreExecutorType(PivotPackage.Literals.COLLECTION_ITEM, PACKAGE, 0);
		public static final @NonNull EcoreExecutorEnumeration _CollectionKind = new EcoreExecutorEnumeration(PivotPackage.Literals.COLLECTION_KIND, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CollectionLiteralExp = new EcoreExecutorType(PivotPackage.Literals.COLLECTION_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CollectionLiteralPart = new EcoreExecutorType(PivotPackage.Literals.COLLECTION_LITERAL_PART, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CollectionRange = new EcoreExecutorType(PivotPackage.Literals.COLLECTION_RANGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _CollectionType = new EcoreExecutorType(PivotPackage.Literals.COLLECTION_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Comment = new EcoreExecutorType(PivotPackage.Literals.COMMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ConnectionPointReference = new EcoreExecutorType(PivotPackage.Literals.CONNECTION_POINT_REFERENCE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Constraint = new EcoreExecutorType(PivotPackage.Literals.CONSTRAINT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ConstructorExp = new EcoreExecutorType(PivotPackage.Literals.CONSTRUCTOR_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ConstructorPart = new EcoreExecutorType(PivotPackage.Literals.CONSTRUCTOR_PART, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _DataType = new EcoreExecutorType(PivotPackage.Literals.DATA_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Detail = new EcoreExecutorType(PivotPackage.Literals.DETAIL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _DynamicElement = new EcoreExecutorType(PivotPackage.Literals.DYNAMIC_ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _DynamicProperty = new EcoreExecutorType(PivotPackage.Literals.DYNAMIC_PROPERTY, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _DynamicType = new EcoreExecutorType(PivotPackage.Literals.DYNAMIC_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Element = new EcoreExecutorType(PivotPackage.Literals.ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ElementExtension = new EcoreExecutorType(PivotPackage.Literals.ELEMENT_EXTENSION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _EnumLiteralExp = new EcoreExecutorType(PivotPackage.Literals.ENUM_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Enumeration = new EcoreExecutorType(PivotPackage.Literals.ENUMERATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _EnumerationLiteral = new EcoreExecutorType(PivotPackage.Literals.ENUMERATION_LITERAL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ExpressionInOCL = new EcoreExecutorType(PivotPackage.Literals.EXPRESSION_IN_OCL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Feature = new EcoreExecutorType(PivotPackage.Literals.FEATURE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _FeatureCallExp = new EcoreExecutorType(PivotPackage.Literals.FEATURE_CALL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _FinalState = new EcoreExecutorType(PivotPackage.Literals.FINAL_STATE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IfExp = new EcoreExecutorType(PivotPackage.Literals.IF_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Import = new EcoreExecutorType(PivotPackage.Literals.IMPORT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IntegerLiteralExp = new EcoreExecutorType(PivotPackage.Literals.INTEGER_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _InvalidLiteralExp = new EcoreExecutorType(PivotPackage.Literals.INVALID_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _InvalidType = new EcoreExecutorType(PivotPackage.Literals.INVALID_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IterateExp = new EcoreExecutorType(PivotPackage.Literals.ITERATE_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Iteration = new EcoreExecutorType(PivotPackage.Literals.ITERATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _IteratorExp = new EcoreExecutorType(PivotPackage.Literals.ITERATOR_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _LambdaType = new EcoreExecutorType(PivotPackage.Literals.LAMBDA_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _LetExp = new EcoreExecutorType(PivotPackage.Literals.LET_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Library = new EcoreExecutorType(PivotPackage.Literals.LIBRARY, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _LibraryFeature = new EcoreExecutorType("LibraryFeature", PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _LiteralExp = new EcoreExecutorType(PivotPackage.Literals.LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _LoopExp = new EcoreExecutorType(PivotPackage.Literals.LOOP_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MessageExp = new EcoreExecutorType(PivotPackage.Literals.MESSAGE_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MessageType = new EcoreExecutorType(PivotPackage.Literals.MESSAGE_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Metaclass = new EcoreExecutorType(PivotPackage.Literals.METACLASS, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _MorePivotable = new EcoreExecutorType(PivotPackage.Literals.MORE_PIVOTABLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Nameable = new EcoreExecutorType(PivotPackage.Literals.NAMEABLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NamedElement = new EcoreExecutorType(PivotPackage.Literals.NAMED_ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Namespace = new EcoreExecutorType(PivotPackage.Literals.NAMESPACE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NavigationCallExp = new EcoreExecutorType(PivotPackage.Literals.NAVIGATION_CALL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NullLiteralExp = new EcoreExecutorType(PivotPackage.Literals.NULL_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _NumericLiteralExp = new EcoreExecutorType(PivotPackage.Literals.NUMERIC_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OCLExpression = new EcoreExecutorType(PivotPackage.Literals.OCL_EXPRESSION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Object = new EcoreExecutorType("Object", PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OpaqueExpression = new EcoreExecutorType(PivotPackage.Literals.OPAQUE_EXPRESSION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Operation = new EcoreExecutorType(PivotPackage.Literals.OPERATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationCallExp = new EcoreExecutorType(PivotPackage.Literals.OPERATION_CALL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OperationTemplateParameter = new EcoreExecutorType(PivotPackage.Literals.OPERATION_TEMPLATE_PARAMETER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _OrderedSetType = new EcoreExecutorType(PivotPackage.Literals.ORDERED_SET_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Package = new EcoreExecutorType(PivotPackage.Literals.PACKAGE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PackageableElement = new EcoreExecutorType(PivotPackage.Literals.PACKAGEABLE_ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Parameter = new EcoreExecutorType(PivotPackage.Literals.PARAMETER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ParameterableElement = new EcoreExecutorType(PivotPackage.Literals.PARAMETERABLE_ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Pivotable = new EcoreExecutorType(PivotPackage.Literals.PIVOTABLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Precedence = new EcoreExecutorType(PivotPackage.Literals.PRECEDENCE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PrimitiveLiteralExp = new EcoreExecutorType(PivotPackage.Literals.PRIMITIVE_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PrimitiveType = new EcoreExecutorType(PivotPackage.Literals.PRIMITIVE_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Profile = new EcoreExecutorType(PivotPackage.Literals.PROFILE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Property = new EcoreExecutorType(PivotPackage.Literals.PROPERTY, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _PropertyCallExp = new EcoreExecutorType(PivotPackage.Literals.PROPERTY_CALL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Pseudostate = new EcoreExecutorType(PivotPackage.Literals.PSEUDOSTATE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorEnumeration _PseudostateKind = new EcoreExecutorEnumeration(PivotPackage.Literals.PSEUDOSTATE_KIND, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _RealLiteralExp = new EcoreExecutorType(PivotPackage.Literals.REAL_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ReferringElement = new EcoreExecutorType(PivotPackage.Literals.REFERRING_ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Region = new EcoreExecutorType(PivotPackage.Literals.REGION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Root = new EcoreExecutorType(PivotPackage.Literals.ROOT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _SelfType = new EcoreExecutorType(PivotPackage.Literals.SELF_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _SendSignalAction = new EcoreExecutorType(PivotPackage.Literals.SEND_SIGNAL_ACTION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _SequenceType = new EcoreExecutorType(PivotPackage.Literals.SEQUENCE_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _SetType = new EcoreExecutorType(PivotPackage.Literals.SET_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Signal = new EcoreExecutorType(PivotPackage.Literals.SIGNAL, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _State = new EcoreExecutorType(PivotPackage.Literals.STATE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _StateExp = new EcoreExecutorType(PivotPackage.Literals.STATE_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _StateMachine = new EcoreExecutorType(PivotPackage.Literals.STATE_MACHINE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Stereotype = new EcoreExecutorType(PivotPackage.Literals.STEREOTYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _StringLiteralExp = new EcoreExecutorType(PivotPackage.Literals.STRING_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TemplateBinding = new EcoreExecutorType(PivotPackage.Literals.TEMPLATE_BINDING, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TemplateParameter = new EcoreExecutorType(PivotPackage.Literals.TEMPLATE_PARAMETER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TemplateParameterSubstitution = new EcoreExecutorType(PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TemplateParameterType = new EcoreExecutorType(PivotPackage.Literals.TEMPLATE_PARAMETER_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TemplateSignature = new EcoreExecutorType(PivotPackage.Literals.TEMPLATE_SIGNATURE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TemplateableElement = new EcoreExecutorType(PivotPackage.Literals.TEMPLATEABLE_ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Throwable = new EcoreExecutorType("Throwable", PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Transition = new EcoreExecutorType(PivotPackage.Literals.TRANSITION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorEnumeration _TransitionKind = new EcoreExecutorEnumeration(PivotPackage.Literals.TRANSITION_KIND, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Trigger = new EcoreExecutorType(PivotPackage.Literals.TRIGGER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TupleLiteralExp = new EcoreExecutorType(PivotPackage.Literals.TUPLE_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TupleLiteralPart = new EcoreExecutorType(PivotPackage.Literals.TUPLE_LITERAL_PART, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TupleType = new EcoreExecutorType(PivotPackage.Literals.TUPLE_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Type = new EcoreExecutorType(PivotPackage.Literals.TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TypeExp = new EcoreExecutorType(PivotPackage.Literals.TYPE_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TypeTemplateParameter = new EcoreExecutorType(PivotPackage.Literals.TYPE_TEMPLATE_PARAMETER, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TypedElement = new EcoreExecutorType(PivotPackage.Literals.TYPED_ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _TypedMultiplicityElement = new EcoreExecutorType(PivotPackage.Literals.TYPED_MULTIPLICITY_ELEMENT, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _UnlimitedNaturalLiteralExp = new EcoreExecutorType(PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _UnspecifiedType = new EcoreExecutorType(PivotPackage.Literals.UNSPECIFIED_TYPE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _UnspecifiedValueExp = new EcoreExecutorType(PivotPackage.Literals.UNSPECIFIED_VALUE_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _ValueSpecification = new EcoreExecutorType(PivotPackage.Literals.VALUE_SPECIFICATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Variable = new EcoreExecutorType(PivotPackage.Literals.VARIABLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _VariableDeclaration = new EcoreExecutorType(PivotPackage.Literals.VARIABLE_DECLARATION, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _VariableExp = new EcoreExecutorType(PivotPackage.Literals.VARIABLE_EXP, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Vertex = new EcoreExecutorType(PivotPackage.Literals.VERTEX, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Visitable = new EcoreExecutorType(PivotPackage.Literals.VISITABLE, PACKAGE, 0);
		public static final @NonNull EcoreExecutorType _Visitor = new EcoreExecutorType(PivotPackage.Literals.VISITOR, PACKAGE, 0, TypeParameters._Visitor_R);
		public static final @NonNull EcoreExecutorType _VoidType = new EcoreExecutorType(PivotPackage.Literals.VOID_TYPE, PACKAGE, 0);

		private static final @NonNull EcoreExecutorType[] types = {
			_Annotation,
			_AnyType,
			_AssociationClass,
			_AssociationClassCallExp,
			_AssociativityKind,
			_BagType,
			_Behavior,
			_BooleanLiteralExp,
			_CallExp,
			_CallOperationAction,
			_Class,
			_CollectionItem,
			_CollectionKind,
			_CollectionLiteralExp,
			_CollectionLiteralPart,
			_CollectionRange,
			_CollectionType,
			_Comment,
			_ConnectionPointReference,
			_Constraint,
			_ConstructorExp,
			_ConstructorPart,
			_DataType,
			_Detail,
			_DynamicElement,
			_DynamicProperty,
			_DynamicType,
			_Element,
			_ElementExtension,
			_EnumLiteralExp,
			_Enumeration,
			_EnumerationLiteral,
			_ExpressionInOCL,
			_Feature,
			_FeatureCallExp,
			_FinalState,
			_IfExp,
			_Import,
			_IntegerLiteralExp,
			_InvalidLiteralExp,
			_InvalidType,
			_IterateExp,
			_Iteration,
			_IteratorExp,
			_LambdaType,
			_LetExp,
			_Library,
			_LibraryFeature,
			_LiteralExp,
			_LoopExp,
			_MessageExp,
			_MessageType,
			_Metaclass,
			_MorePivotable,
			_Nameable,
			_NamedElement,
			_Namespace,
			_NavigationCallExp,
			_NullLiteralExp,
			_NumericLiteralExp,
			_OCLExpression,
			_Object,
			_OpaqueExpression,
			_Operation,
			_OperationCallExp,
			_OperationTemplateParameter,
			_OrderedSetType,
			_Package,
			_PackageableElement,
			_Parameter,
			_ParameterableElement,
			_Pivotable,
			_Precedence,
			_PrimitiveLiteralExp,
			_PrimitiveType,
			_Profile,
			_Property,
			_PropertyCallExp,
			_Pseudostate,
			_PseudostateKind,
			_RealLiteralExp,
			_ReferringElement,
			_Region,
			_Root,
			_SelfType,
			_SendSignalAction,
			_SequenceType,
			_SetType,
			_Signal,
			_State,
			_StateExp,
			_StateMachine,
			_Stereotype,
			_StringLiteralExp,
			_TemplateBinding,
			_TemplateParameter,
			_TemplateParameterSubstitution,
			_TemplateParameterType,
			_TemplateSignature,
			_TemplateableElement,
			_Throwable,
			_Transition,
			_TransitionKind,
			_Trigger,
			_TupleLiteralExp,
			_TupleLiteralPart,
			_TupleType,
			_Type,
			_TypeExp,
			_TypeTemplateParameter,
			_TypedElement,
			_TypedMultiplicityElement,
			_UnlimitedNaturalLiteralExp,
			_UnspecifiedType,
			_UnspecifiedValueExp,
			_ValueSpecification,
			_Variable,
			_VariableDeclaration,
			_VariableExp,
			_Vertex,
			_Visitable,
			_Visitor,
			_VoidType
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			LIBRARY.addExtension(OCLstdlibTables.PACKAGE, PACKAGE);
			TypeFragments.init();
			FragmentOperations.init();
			FragmentProperties.init();
			EnumerationLiterals.init();
		}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		public static final @NonNull ExecutorFragment _Annotation__Annotation = new ExecutorFragment(Types._Annotation, PivotTables.Types._Annotation);
		public static final @NonNull ExecutorFragment _Annotation__Element = new ExecutorFragment(Types._Annotation, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Annotation__Nameable = new ExecutorFragment(Types._Annotation, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Annotation__NamedElement = new ExecutorFragment(Types._Annotation, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Annotation__OclAny = new ExecutorFragment(Types._Annotation, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Annotation__OclElement = new ExecutorFragment(Types._Annotation, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Annotation__Visitable = new ExecutorFragment(Types._Annotation, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _AnyType__AnyType = new ExecutorFragment(Types._AnyType, PivotTables.Types._AnyType);
		public static final @NonNull ExecutorFragment _AnyType__Class = new ExecutorFragment(Types._AnyType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _AnyType__Element = new ExecutorFragment(Types._AnyType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _AnyType__Nameable = new ExecutorFragment(Types._AnyType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _AnyType__NamedElement = new ExecutorFragment(Types._AnyType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _AnyType__Namespace = new ExecutorFragment(Types._AnyType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _AnyType__OclAny = new ExecutorFragment(Types._AnyType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _AnyType__OclElement = new ExecutorFragment(Types._AnyType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _AnyType__OclType = new ExecutorFragment(Types._AnyType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _AnyType__PackageableElement = new ExecutorFragment(Types._AnyType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _AnyType__ParameterableElement = new ExecutorFragment(Types._AnyType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _AnyType__TemplateableElement = new ExecutorFragment(Types._AnyType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _AnyType__Type = new ExecutorFragment(Types._AnyType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _AnyType__Visitable = new ExecutorFragment(Types._AnyType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _AssociationClass__AssociationClass = new ExecutorFragment(Types._AssociationClass, PivotTables.Types._AssociationClass);
		public static final @NonNull ExecutorFragment _AssociationClass__Class = new ExecutorFragment(Types._AssociationClass, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _AssociationClass__Element = new ExecutorFragment(Types._AssociationClass, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _AssociationClass__Nameable = new ExecutorFragment(Types._AssociationClass, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _AssociationClass__NamedElement = new ExecutorFragment(Types._AssociationClass, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _AssociationClass__Namespace = new ExecutorFragment(Types._AssociationClass, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _AssociationClass__OclAny = new ExecutorFragment(Types._AssociationClass, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _AssociationClass__OclElement = new ExecutorFragment(Types._AssociationClass, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _AssociationClass__OclType = new ExecutorFragment(Types._AssociationClass, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _AssociationClass__PackageableElement = new ExecutorFragment(Types._AssociationClass, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _AssociationClass__ParameterableElement = new ExecutorFragment(Types._AssociationClass, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _AssociationClass__TemplateableElement = new ExecutorFragment(Types._AssociationClass, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _AssociationClass__Type = new ExecutorFragment(Types._AssociationClass, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _AssociationClass__Visitable = new ExecutorFragment(Types._AssociationClass, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _AssociationClassCallExp__AssociationClassCallExp = new ExecutorFragment(Types._AssociationClassCallExp, PivotTables.Types._AssociationClassCallExp);
		public static final @NonNull ExecutorFragment _AssociationClassCallExp__CallExp = new ExecutorFragment(Types._AssociationClassCallExp, PivotTables.Types._CallExp);
		public static final @NonNull ExecutorFragment _AssociationClassCallExp__Element = new ExecutorFragment(Types._AssociationClassCallExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _AssociationClassCallExp__FeatureCallExp = new ExecutorFragment(Types._AssociationClassCallExp, PivotTables.Types._FeatureCallExp);
		public static final @NonNull ExecutorFragment _AssociationClassCallExp__Nameable = new ExecutorFragment(Types._AssociationClassCallExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _AssociationClassCallExp__NamedElement = new ExecutorFragment(Types._AssociationClassCallExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _AssociationClassCallExp__NavigationCallExp = new ExecutorFragment(Types._AssociationClassCallExp, PivotTables.Types._NavigationCallExp);
		public static final @NonNull ExecutorFragment _AssociationClassCallExp__OCLExpression = new ExecutorFragment(Types._AssociationClassCallExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _AssociationClassCallExp__OclAny = new ExecutorFragment(Types._AssociationClassCallExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _AssociationClassCallExp__OclElement = new ExecutorFragment(Types._AssociationClassCallExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _AssociationClassCallExp__TypedElement = new ExecutorFragment(Types._AssociationClassCallExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _AssociationClassCallExp__Visitable = new ExecutorFragment(Types._AssociationClassCallExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _AssociativityKind__AssociativityKind = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._AssociativityKind);
		public static final @NonNull ExecutorFragment _AssociativityKind__Class = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _AssociativityKind__DataType = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _AssociativityKind__Element = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _AssociativityKind__Enumeration = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._Enumeration);
		public static final @NonNull ExecutorFragment _AssociativityKind__Nameable = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _AssociativityKind__NamedElement = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _AssociativityKind__Namespace = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _AssociativityKind__OclAny = new ExecutorFragment(Types._AssociativityKind, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _AssociativityKind__OclElement = new ExecutorFragment(Types._AssociativityKind, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _AssociativityKind__OclType = new ExecutorFragment(Types._AssociativityKind, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _AssociativityKind__PackageableElement = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _AssociativityKind__ParameterableElement = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _AssociativityKind__TemplateableElement = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _AssociativityKind__Type = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _AssociativityKind__Visitable = new ExecutorFragment(Types._AssociativityKind, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _BagType__BagType = new ExecutorFragment(Types._BagType, PivotTables.Types._BagType);
		public static final @NonNull ExecutorFragment _BagType__Class = new ExecutorFragment(Types._BagType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _BagType__CollectionType = new ExecutorFragment(Types._BagType, PivotTables.Types._CollectionType);
		public static final @NonNull ExecutorFragment _BagType__DataType = new ExecutorFragment(Types._BagType, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _BagType__Element = new ExecutorFragment(Types._BagType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _BagType__Nameable = new ExecutorFragment(Types._BagType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _BagType__NamedElement = new ExecutorFragment(Types._BagType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _BagType__Namespace = new ExecutorFragment(Types._BagType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _BagType__OclAny = new ExecutorFragment(Types._BagType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _BagType__OclElement = new ExecutorFragment(Types._BagType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _BagType__OclType = new ExecutorFragment(Types._BagType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _BagType__PackageableElement = new ExecutorFragment(Types._BagType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _BagType__ParameterableElement = new ExecutorFragment(Types._BagType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _BagType__TemplateableElement = new ExecutorFragment(Types._BagType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _BagType__Type = new ExecutorFragment(Types._BagType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _BagType__Visitable = new ExecutorFragment(Types._BagType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Behavior__Behavior = new ExecutorFragment(Types._Behavior, PivotTables.Types._Behavior);
		public static final @NonNull ExecutorFragment _Behavior__Class = new ExecutorFragment(Types._Behavior, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _Behavior__Element = new ExecutorFragment(Types._Behavior, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Behavior__Nameable = new ExecutorFragment(Types._Behavior, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Behavior__NamedElement = new ExecutorFragment(Types._Behavior, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Behavior__Namespace = new ExecutorFragment(Types._Behavior, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Behavior__OclAny = new ExecutorFragment(Types._Behavior, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Behavior__OclElement = new ExecutorFragment(Types._Behavior, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Behavior__OclType = new ExecutorFragment(Types._Behavior, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _Behavior__PackageableElement = new ExecutorFragment(Types._Behavior, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _Behavior__ParameterableElement = new ExecutorFragment(Types._Behavior, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Behavior__TemplateableElement = new ExecutorFragment(Types._Behavior, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _Behavior__Type = new ExecutorFragment(Types._Behavior, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _Behavior__Visitable = new ExecutorFragment(Types._Behavior, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _BooleanLiteralExp__BooleanLiteralExp = new ExecutorFragment(Types._BooleanLiteralExp, PivotTables.Types._BooleanLiteralExp);
		public static final @NonNull ExecutorFragment _BooleanLiteralExp__Element = new ExecutorFragment(Types._BooleanLiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _BooleanLiteralExp__LiteralExp = new ExecutorFragment(Types._BooleanLiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _BooleanLiteralExp__Nameable = new ExecutorFragment(Types._BooleanLiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _BooleanLiteralExp__NamedElement = new ExecutorFragment(Types._BooleanLiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _BooleanLiteralExp__OCLExpression = new ExecutorFragment(Types._BooleanLiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _BooleanLiteralExp__OclAny = new ExecutorFragment(Types._BooleanLiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _BooleanLiteralExp__OclElement = new ExecutorFragment(Types._BooleanLiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _BooleanLiteralExp__PrimitiveLiteralExp = new ExecutorFragment(Types._BooleanLiteralExp, PivotTables.Types._PrimitiveLiteralExp);
		public static final @NonNull ExecutorFragment _BooleanLiteralExp__TypedElement = new ExecutorFragment(Types._BooleanLiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _BooleanLiteralExp__Visitable = new ExecutorFragment(Types._BooleanLiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _CallExp__CallExp = new ExecutorFragment(Types._CallExp, PivotTables.Types._CallExp);
		public static final @NonNull ExecutorFragment _CallExp__Element = new ExecutorFragment(Types._CallExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _CallExp__Nameable = new ExecutorFragment(Types._CallExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _CallExp__NamedElement = new ExecutorFragment(Types._CallExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _CallExp__OCLExpression = new ExecutorFragment(Types._CallExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _CallExp__OclAny = new ExecutorFragment(Types._CallExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _CallExp__OclElement = new ExecutorFragment(Types._CallExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _CallExp__TypedElement = new ExecutorFragment(Types._CallExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _CallExp__Visitable = new ExecutorFragment(Types._CallExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _CallOperationAction__CallOperationAction = new ExecutorFragment(Types._CallOperationAction, PivotTables.Types._CallOperationAction);
		public static final @NonNull ExecutorFragment _CallOperationAction__Element = new ExecutorFragment(Types._CallOperationAction, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _CallOperationAction__Nameable = new ExecutorFragment(Types._CallOperationAction, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _CallOperationAction__NamedElement = new ExecutorFragment(Types._CallOperationAction, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _CallOperationAction__OclAny = new ExecutorFragment(Types._CallOperationAction, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _CallOperationAction__OclElement = new ExecutorFragment(Types._CallOperationAction, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _CallOperationAction__Visitable = new ExecutorFragment(Types._CallOperationAction, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Class__Class = new ExecutorFragment(Types._Class, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _Class__Element = new ExecutorFragment(Types._Class, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Class__Nameable = new ExecutorFragment(Types._Class, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Class__NamedElement = new ExecutorFragment(Types._Class, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Class__Namespace = new ExecutorFragment(Types._Class, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Class__OclAny = new ExecutorFragment(Types._Class, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Class__OclElement = new ExecutorFragment(Types._Class, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Class__OclType = new ExecutorFragment(Types._Class, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _Class__PackageableElement = new ExecutorFragment(Types._Class, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _Class__ParameterableElement = new ExecutorFragment(Types._Class, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Class__TemplateableElement = new ExecutorFragment(Types._Class, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _Class__Type = new ExecutorFragment(Types._Class, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _Class__Visitable = new ExecutorFragment(Types._Class, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _CollectionItem__CollectionItem = new ExecutorFragment(Types._CollectionItem, PivotTables.Types._CollectionItem);
		public static final @NonNull ExecutorFragment _CollectionItem__CollectionLiteralPart = new ExecutorFragment(Types._CollectionItem, PivotTables.Types._CollectionLiteralPart);
		public static final @NonNull ExecutorFragment _CollectionItem__Element = new ExecutorFragment(Types._CollectionItem, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _CollectionItem__Nameable = new ExecutorFragment(Types._CollectionItem, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _CollectionItem__NamedElement = new ExecutorFragment(Types._CollectionItem, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _CollectionItem__OclAny = new ExecutorFragment(Types._CollectionItem, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _CollectionItem__OclElement = new ExecutorFragment(Types._CollectionItem, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _CollectionItem__TypedElement = new ExecutorFragment(Types._CollectionItem, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _CollectionItem__Visitable = new ExecutorFragment(Types._CollectionItem, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _CollectionKind__Class = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _CollectionKind__CollectionKind = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._CollectionKind);
		public static final @NonNull ExecutorFragment _CollectionKind__DataType = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _CollectionKind__Element = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _CollectionKind__Enumeration = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._Enumeration);
		public static final @NonNull ExecutorFragment _CollectionKind__Nameable = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _CollectionKind__NamedElement = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _CollectionKind__Namespace = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _CollectionKind__OclAny = new ExecutorFragment(Types._CollectionKind, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _CollectionKind__OclElement = new ExecutorFragment(Types._CollectionKind, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _CollectionKind__OclType = new ExecutorFragment(Types._CollectionKind, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _CollectionKind__PackageableElement = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _CollectionKind__ParameterableElement = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _CollectionKind__TemplateableElement = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _CollectionKind__Type = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _CollectionKind__Visitable = new ExecutorFragment(Types._CollectionKind, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _CollectionLiteralExp__CollectionLiteralExp = new ExecutorFragment(Types._CollectionLiteralExp, PivotTables.Types._CollectionLiteralExp);
		public static final @NonNull ExecutorFragment _CollectionLiteralExp__Element = new ExecutorFragment(Types._CollectionLiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _CollectionLiteralExp__LiteralExp = new ExecutorFragment(Types._CollectionLiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _CollectionLiteralExp__Nameable = new ExecutorFragment(Types._CollectionLiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _CollectionLiteralExp__NamedElement = new ExecutorFragment(Types._CollectionLiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _CollectionLiteralExp__OCLExpression = new ExecutorFragment(Types._CollectionLiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _CollectionLiteralExp__OclAny = new ExecutorFragment(Types._CollectionLiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _CollectionLiteralExp__OclElement = new ExecutorFragment(Types._CollectionLiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _CollectionLiteralExp__TypedElement = new ExecutorFragment(Types._CollectionLiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _CollectionLiteralExp__Visitable = new ExecutorFragment(Types._CollectionLiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _CollectionLiteralPart__CollectionLiteralPart = new ExecutorFragment(Types._CollectionLiteralPart, PivotTables.Types._CollectionLiteralPart);
		public static final @NonNull ExecutorFragment _CollectionLiteralPart__Element = new ExecutorFragment(Types._CollectionLiteralPart, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _CollectionLiteralPart__Nameable = new ExecutorFragment(Types._CollectionLiteralPart, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _CollectionLiteralPart__NamedElement = new ExecutorFragment(Types._CollectionLiteralPart, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _CollectionLiteralPart__OclAny = new ExecutorFragment(Types._CollectionLiteralPart, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _CollectionLiteralPart__OclElement = new ExecutorFragment(Types._CollectionLiteralPart, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _CollectionLiteralPart__TypedElement = new ExecutorFragment(Types._CollectionLiteralPart, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _CollectionLiteralPart__Visitable = new ExecutorFragment(Types._CollectionLiteralPart, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _CollectionRange__CollectionLiteralPart = new ExecutorFragment(Types._CollectionRange, PivotTables.Types._CollectionLiteralPart);
		public static final @NonNull ExecutorFragment _CollectionRange__CollectionRange = new ExecutorFragment(Types._CollectionRange, PivotTables.Types._CollectionRange);
		public static final @NonNull ExecutorFragment _CollectionRange__Element = new ExecutorFragment(Types._CollectionRange, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _CollectionRange__Nameable = new ExecutorFragment(Types._CollectionRange, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _CollectionRange__NamedElement = new ExecutorFragment(Types._CollectionRange, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _CollectionRange__OclAny = new ExecutorFragment(Types._CollectionRange, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _CollectionRange__OclElement = new ExecutorFragment(Types._CollectionRange, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _CollectionRange__TypedElement = new ExecutorFragment(Types._CollectionRange, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _CollectionRange__Visitable = new ExecutorFragment(Types._CollectionRange, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _CollectionType__Class = new ExecutorFragment(Types._CollectionType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _CollectionType__CollectionType = new ExecutorFragment(Types._CollectionType, PivotTables.Types._CollectionType);
		public static final @NonNull ExecutorFragment _CollectionType__DataType = new ExecutorFragment(Types._CollectionType, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _CollectionType__Element = new ExecutorFragment(Types._CollectionType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _CollectionType__Nameable = new ExecutorFragment(Types._CollectionType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _CollectionType__NamedElement = new ExecutorFragment(Types._CollectionType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _CollectionType__Namespace = new ExecutorFragment(Types._CollectionType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _CollectionType__OclAny = new ExecutorFragment(Types._CollectionType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _CollectionType__OclElement = new ExecutorFragment(Types._CollectionType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _CollectionType__OclType = new ExecutorFragment(Types._CollectionType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _CollectionType__PackageableElement = new ExecutorFragment(Types._CollectionType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _CollectionType__ParameterableElement = new ExecutorFragment(Types._CollectionType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _CollectionType__TemplateableElement = new ExecutorFragment(Types._CollectionType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _CollectionType__Type = new ExecutorFragment(Types._CollectionType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _CollectionType__Visitable = new ExecutorFragment(Types._CollectionType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Comment__Comment = new ExecutorFragment(Types._Comment, PivotTables.Types._Comment);
		public static final @NonNull ExecutorFragment _Comment__Element = new ExecutorFragment(Types._Comment, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Comment__OclAny = new ExecutorFragment(Types._Comment, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Comment__OclElement = new ExecutorFragment(Types._Comment, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Comment__Visitable = new ExecutorFragment(Types._Comment, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _ConnectionPointReference__ConnectionPointReference = new ExecutorFragment(Types._ConnectionPointReference, PivotTables.Types._ConnectionPointReference);
		public static final @NonNull ExecutorFragment _ConnectionPointReference__Element = new ExecutorFragment(Types._ConnectionPointReference, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _ConnectionPointReference__Nameable = new ExecutorFragment(Types._ConnectionPointReference, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _ConnectionPointReference__NamedElement = new ExecutorFragment(Types._ConnectionPointReference, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _ConnectionPointReference__OclAny = new ExecutorFragment(Types._ConnectionPointReference, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _ConnectionPointReference__OclElement = new ExecutorFragment(Types._ConnectionPointReference, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _ConnectionPointReference__Vertex = new ExecutorFragment(Types._ConnectionPointReference, PivotTables.Types._Vertex);
		public static final @NonNull ExecutorFragment _ConnectionPointReference__Visitable = new ExecutorFragment(Types._ConnectionPointReference, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Constraint__Constraint = new ExecutorFragment(Types._Constraint, PivotTables.Types._Constraint);
		public static final @NonNull ExecutorFragment _Constraint__Element = new ExecutorFragment(Types._Constraint, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Constraint__Nameable = new ExecutorFragment(Types._Constraint, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Constraint__NamedElement = new ExecutorFragment(Types._Constraint, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Constraint__OclAny = new ExecutorFragment(Types._Constraint, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Constraint__OclElement = new ExecutorFragment(Types._Constraint, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Constraint__PackageableElement = new ExecutorFragment(Types._Constraint, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _Constraint__ParameterableElement = new ExecutorFragment(Types._Constraint, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Constraint__Visitable = new ExecutorFragment(Types._Constraint, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _ConstructorExp__ConstructorExp = new ExecutorFragment(Types._ConstructorExp, PivotTables.Types._ConstructorExp);
		public static final @NonNull ExecutorFragment _ConstructorExp__Element = new ExecutorFragment(Types._ConstructorExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _ConstructorExp__Nameable = new ExecutorFragment(Types._ConstructorExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _ConstructorExp__NamedElement = new ExecutorFragment(Types._ConstructorExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _ConstructorExp__OCLExpression = new ExecutorFragment(Types._ConstructorExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _ConstructorExp__OclAny = new ExecutorFragment(Types._ConstructorExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _ConstructorExp__OclElement = new ExecutorFragment(Types._ConstructorExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _ConstructorExp__TypedElement = new ExecutorFragment(Types._ConstructorExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _ConstructorExp__Visitable = new ExecutorFragment(Types._ConstructorExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _ConstructorPart__ConstructorPart = new ExecutorFragment(Types._ConstructorPart, PivotTables.Types._ConstructorPart);
		public static final @NonNull ExecutorFragment _ConstructorPart__Element = new ExecutorFragment(Types._ConstructorPart, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _ConstructorPart__Nameable = new ExecutorFragment(Types._ConstructorPart, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _ConstructorPart__NamedElement = new ExecutorFragment(Types._ConstructorPart, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _ConstructorPart__OclAny = new ExecutorFragment(Types._ConstructorPart, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _ConstructorPart__OclElement = new ExecutorFragment(Types._ConstructorPart, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _ConstructorPart__TypedElement = new ExecutorFragment(Types._ConstructorPart, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _ConstructorPart__Visitable = new ExecutorFragment(Types._ConstructorPart, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _DataType__Class = new ExecutorFragment(Types._DataType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _DataType__DataType = new ExecutorFragment(Types._DataType, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _DataType__Element = new ExecutorFragment(Types._DataType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _DataType__Nameable = new ExecutorFragment(Types._DataType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _DataType__NamedElement = new ExecutorFragment(Types._DataType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _DataType__Namespace = new ExecutorFragment(Types._DataType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _DataType__OclAny = new ExecutorFragment(Types._DataType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _DataType__OclElement = new ExecutorFragment(Types._DataType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _DataType__OclType = new ExecutorFragment(Types._DataType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _DataType__PackageableElement = new ExecutorFragment(Types._DataType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _DataType__ParameterableElement = new ExecutorFragment(Types._DataType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _DataType__TemplateableElement = new ExecutorFragment(Types._DataType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _DataType__Type = new ExecutorFragment(Types._DataType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _DataType__Visitable = new ExecutorFragment(Types._DataType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Detail__Detail = new ExecutorFragment(Types._Detail, PivotTables.Types._Detail);
		public static final @NonNull ExecutorFragment _Detail__Element = new ExecutorFragment(Types._Detail, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Detail__Nameable = new ExecutorFragment(Types._Detail, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Detail__NamedElement = new ExecutorFragment(Types._Detail, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Detail__OclAny = new ExecutorFragment(Types._Detail, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Detail__OclElement = new ExecutorFragment(Types._Detail, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Detail__Visitable = new ExecutorFragment(Types._Detail, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _DynamicElement__DynamicElement = new ExecutorFragment(Types._DynamicElement, PivotTables.Types._DynamicElement);
		public static final @NonNull ExecutorFragment _DynamicElement__Element = new ExecutorFragment(Types._DynamicElement, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _DynamicElement__OclAny = new ExecutorFragment(Types._DynamicElement, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _DynamicElement__OclElement = new ExecutorFragment(Types._DynamicElement, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _DynamicElement__Visitable = new ExecutorFragment(Types._DynamicElement, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _DynamicProperty__DynamicProperty = new ExecutorFragment(Types._DynamicProperty, PivotTables.Types._DynamicProperty);
		public static final @NonNull ExecutorFragment _DynamicProperty__Element = new ExecutorFragment(Types._DynamicProperty, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _DynamicProperty__OclAny = new ExecutorFragment(Types._DynamicProperty, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _DynamicProperty__OclElement = new ExecutorFragment(Types._DynamicProperty, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _DynamicProperty__Visitable = new ExecutorFragment(Types._DynamicProperty, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _DynamicType__DynamicElement = new ExecutorFragment(Types._DynamicType, PivotTables.Types._DynamicElement);
		public static final @NonNull ExecutorFragment _DynamicType__DynamicType = new ExecutorFragment(Types._DynamicType, PivotTables.Types._DynamicType);
		public static final @NonNull ExecutorFragment _DynamicType__Element = new ExecutorFragment(Types._DynamicType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _DynamicType__Nameable = new ExecutorFragment(Types._DynamicType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _DynamicType__NamedElement = new ExecutorFragment(Types._DynamicType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _DynamicType__OclAny = new ExecutorFragment(Types._DynamicType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _DynamicType__OclElement = new ExecutorFragment(Types._DynamicType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _DynamicType__OclType = new ExecutorFragment(Types._DynamicType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _DynamicType__PackageableElement = new ExecutorFragment(Types._DynamicType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _DynamicType__ParameterableElement = new ExecutorFragment(Types._DynamicType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _DynamicType__TemplateableElement = new ExecutorFragment(Types._DynamicType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _DynamicType__Type = new ExecutorFragment(Types._DynamicType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _DynamicType__Visitable = new ExecutorFragment(Types._DynamicType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Element__Element = new ExecutorFragment(Types._Element, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Element__OclAny = new ExecutorFragment(Types._Element, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Element__OclElement = new ExecutorFragment(Types._Element, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Element__Visitable = new ExecutorFragment(Types._Element, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _ElementExtension__Element = new ExecutorFragment(Types._ElementExtension, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _ElementExtension__ElementExtension = new ExecutorFragment(Types._ElementExtension, PivotTables.Types._ElementExtension);
		public static final @NonNull ExecutorFragment _ElementExtension__Nameable = new ExecutorFragment(Types._ElementExtension, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _ElementExtension__NamedElement = new ExecutorFragment(Types._ElementExtension, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _ElementExtension__OclAny = new ExecutorFragment(Types._ElementExtension, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _ElementExtension__OclElement = new ExecutorFragment(Types._ElementExtension, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _ElementExtension__OclType = new ExecutorFragment(Types._ElementExtension, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _ElementExtension__PackageableElement = new ExecutorFragment(Types._ElementExtension, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _ElementExtension__ParameterableElement = new ExecutorFragment(Types._ElementExtension, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _ElementExtension__TemplateableElement = new ExecutorFragment(Types._ElementExtension, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _ElementExtension__Type = new ExecutorFragment(Types._ElementExtension, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _ElementExtension__Visitable = new ExecutorFragment(Types._ElementExtension, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _EnumLiteralExp__Element = new ExecutorFragment(Types._EnumLiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _EnumLiteralExp__EnumLiteralExp = new ExecutorFragment(Types._EnumLiteralExp, PivotTables.Types._EnumLiteralExp);
		public static final @NonNull ExecutorFragment _EnumLiteralExp__LiteralExp = new ExecutorFragment(Types._EnumLiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _EnumLiteralExp__Nameable = new ExecutorFragment(Types._EnumLiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _EnumLiteralExp__NamedElement = new ExecutorFragment(Types._EnumLiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _EnumLiteralExp__OCLExpression = new ExecutorFragment(Types._EnumLiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _EnumLiteralExp__OclAny = new ExecutorFragment(Types._EnumLiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _EnumLiteralExp__OclElement = new ExecutorFragment(Types._EnumLiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _EnumLiteralExp__TypedElement = new ExecutorFragment(Types._EnumLiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _EnumLiteralExp__Visitable = new ExecutorFragment(Types._EnumLiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Enumeration__Class = new ExecutorFragment(Types._Enumeration, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _Enumeration__DataType = new ExecutorFragment(Types._Enumeration, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _Enumeration__Element = new ExecutorFragment(Types._Enumeration, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Enumeration__Enumeration = new ExecutorFragment(Types._Enumeration, PivotTables.Types._Enumeration);
		public static final @NonNull ExecutorFragment _Enumeration__Nameable = new ExecutorFragment(Types._Enumeration, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Enumeration__NamedElement = new ExecutorFragment(Types._Enumeration, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Enumeration__Namespace = new ExecutorFragment(Types._Enumeration, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Enumeration__OclAny = new ExecutorFragment(Types._Enumeration, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Enumeration__OclElement = new ExecutorFragment(Types._Enumeration, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Enumeration__OclType = new ExecutorFragment(Types._Enumeration, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _Enumeration__PackageableElement = new ExecutorFragment(Types._Enumeration, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _Enumeration__ParameterableElement = new ExecutorFragment(Types._Enumeration, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Enumeration__TemplateableElement = new ExecutorFragment(Types._Enumeration, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _Enumeration__Type = new ExecutorFragment(Types._Enumeration, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _Enumeration__Visitable = new ExecutorFragment(Types._Enumeration, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _EnumerationLiteral__Element = new ExecutorFragment(Types._EnumerationLiteral, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _EnumerationLiteral__EnumerationLiteral = new ExecutorFragment(Types._EnumerationLiteral, PivotTables.Types._EnumerationLiteral);
		public static final @NonNull ExecutorFragment _EnumerationLiteral__Nameable = new ExecutorFragment(Types._EnumerationLiteral, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _EnumerationLiteral__NamedElement = new ExecutorFragment(Types._EnumerationLiteral, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _EnumerationLiteral__OclAny = new ExecutorFragment(Types._EnumerationLiteral, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _EnumerationLiteral__OclElement = new ExecutorFragment(Types._EnumerationLiteral, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _EnumerationLiteral__PackageableElement = new ExecutorFragment(Types._EnumerationLiteral, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _EnumerationLiteral__ParameterableElement = new ExecutorFragment(Types._EnumerationLiteral, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _EnumerationLiteral__Visitable = new ExecutorFragment(Types._EnumerationLiteral, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _ExpressionInOCL__Element = new ExecutorFragment(Types._ExpressionInOCL, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _ExpressionInOCL__ExpressionInOCL = new ExecutorFragment(Types._ExpressionInOCL, PivotTables.Types._ExpressionInOCL);
		public static final @NonNull ExecutorFragment _ExpressionInOCL__Nameable = new ExecutorFragment(Types._ExpressionInOCL, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _ExpressionInOCL__NamedElement = new ExecutorFragment(Types._ExpressionInOCL, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _ExpressionInOCL__OclAny = new ExecutorFragment(Types._ExpressionInOCL, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _ExpressionInOCL__OclElement = new ExecutorFragment(Types._ExpressionInOCL, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _ExpressionInOCL__OpaqueExpression = new ExecutorFragment(Types._ExpressionInOCL, PivotTables.Types._OpaqueExpression);
		public static final @NonNull ExecutorFragment _ExpressionInOCL__PackageableElement = new ExecutorFragment(Types._ExpressionInOCL, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _ExpressionInOCL__ParameterableElement = new ExecutorFragment(Types._ExpressionInOCL, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _ExpressionInOCL__TypedElement = new ExecutorFragment(Types._ExpressionInOCL, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _ExpressionInOCL__ValueSpecification = new ExecutorFragment(Types._ExpressionInOCL, PivotTables.Types._ValueSpecification);
		public static final @NonNull ExecutorFragment _ExpressionInOCL__Visitable = new ExecutorFragment(Types._ExpressionInOCL, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Feature__Element = new ExecutorFragment(Types._Feature, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Feature__Feature = new ExecutorFragment(Types._Feature, PivotTables.Types._Feature);
		public static final @NonNull ExecutorFragment _Feature__Nameable = new ExecutorFragment(Types._Feature, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Feature__NamedElement = new ExecutorFragment(Types._Feature, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Feature__OclAny = new ExecutorFragment(Types._Feature, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Feature__OclElement = new ExecutorFragment(Types._Feature, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Feature__TypedElement = new ExecutorFragment(Types._Feature, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _Feature__TypedMultiplicityElement = new ExecutorFragment(Types._Feature, PivotTables.Types._TypedMultiplicityElement);
		public static final @NonNull ExecutorFragment _Feature__Visitable = new ExecutorFragment(Types._Feature, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _FeatureCallExp__CallExp = new ExecutorFragment(Types._FeatureCallExp, PivotTables.Types._CallExp);
		public static final @NonNull ExecutorFragment _FeatureCallExp__Element = new ExecutorFragment(Types._FeatureCallExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _FeatureCallExp__FeatureCallExp = new ExecutorFragment(Types._FeatureCallExp, PivotTables.Types._FeatureCallExp);
		public static final @NonNull ExecutorFragment _FeatureCallExp__Nameable = new ExecutorFragment(Types._FeatureCallExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _FeatureCallExp__NamedElement = new ExecutorFragment(Types._FeatureCallExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _FeatureCallExp__OCLExpression = new ExecutorFragment(Types._FeatureCallExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _FeatureCallExp__OclAny = new ExecutorFragment(Types._FeatureCallExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _FeatureCallExp__OclElement = new ExecutorFragment(Types._FeatureCallExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _FeatureCallExp__TypedElement = new ExecutorFragment(Types._FeatureCallExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _FeatureCallExp__Visitable = new ExecutorFragment(Types._FeatureCallExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _FinalState__Element = new ExecutorFragment(Types._FinalState, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _FinalState__FinalState = new ExecutorFragment(Types._FinalState, PivotTables.Types._FinalState);
		public static final @NonNull ExecutorFragment _FinalState__Nameable = new ExecutorFragment(Types._FinalState, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _FinalState__NamedElement = new ExecutorFragment(Types._FinalState, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _FinalState__Namespace = new ExecutorFragment(Types._FinalState, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _FinalState__OclAny = new ExecutorFragment(Types._FinalState, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _FinalState__OclElement = new ExecutorFragment(Types._FinalState, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _FinalState__OclState = new ExecutorFragment(Types._FinalState, OCLstdlibTables.Types._OclState);
		public static final @NonNull ExecutorFragment _FinalState__State = new ExecutorFragment(Types._FinalState, PivotTables.Types._State);
		public static final @NonNull ExecutorFragment _FinalState__Vertex = new ExecutorFragment(Types._FinalState, PivotTables.Types._Vertex);
		public static final @NonNull ExecutorFragment _FinalState__Visitable = new ExecutorFragment(Types._FinalState, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _IfExp__Element = new ExecutorFragment(Types._IfExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _IfExp__IfExp = new ExecutorFragment(Types._IfExp, PivotTables.Types._IfExp);
		public static final @NonNull ExecutorFragment _IfExp__Nameable = new ExecutorFragment(Types._IfExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _IfExp__NamedElement = new ExecutorFragment(Types._IfExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _IfExp__OCLExpression = new ExecutorFragment(Types._IfExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _IfExp__OclAny = new ExecutorFragment(Types._IfExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _IfExp__OclElement = new ExecutorFragment(Types._IfExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _IfExp__TypedElement = new ExecutorFragment(Types._IfExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _IfExp__Visitable = new ExecutorFragment(Types._IfExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Import__Element = new ExecutorFragment(Types._Import, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Import__Import = new ExecutorFragment(Types._Import, PivotTables.Types._Import);
		public static final @NonNull ExecutorFragment _Import__Nameable = new ExecutorFragment(Types._Import, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Import__NamedElement = new ExecutorFragment(Types._Import, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Import__OclAny = new ExecutorFragment(Types._Import, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Import__OclElement = new ExecutorFragment(Types._Import, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Import__Visitable = new ExecutorFragment(Types._Import, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _IntegerLiteralExp__Element = new ExecutorFragment(Types._IntegerLiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _IntegerLiteralExp__IntegerLiteralExp = new ExecutorFragment(Types._IntegerLiteralExp, PivotTables.Types._IntegerLiteralExp);
		public static final @NonNull ExecutorFragment _IntegerLiteralExp__LiteralExp = new ExecutorFragment(Types._IntegerLiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _IntegerLiteralExp__Nameable = new ExecutorFragment(Types._IntegerLiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _IntegerLiteralExp__NamedElement = new ExecutorFragment(Types._IntegerLiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _IntegerLiteralExp__NumericLiteralExp = new ExecutorFragment(Types._IntegerLiteralExp, PivotTables.Types._NumericLiteralExp);
		public static final @NonNull ExecutorFragment _IntegerLiteralExp__OCLExpression = new ExecutorFragment(Types._IntegerLiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _IntegerLiteralExp__OclAny = new ExecutorFragment(Types._IntegerLiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _IntegerLiteralExp__OclElement = new ExecutorFragment(Types._IntegerLiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _IntegerLiteralExp__PrimitiveLiteralExp = new ExecutorFragment(Types._IntegerLiteralExp, PivotTables.Types._PrimitiveLiteralExp);
		public static final @NonNull ExecutorFragment _IntegerLiteralExp__TypedElement = new ExecutorFragment(Types._IntegerLiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _IntegerLiteralExp__Visitable = new ExecutorFragment(Types._IntegerLiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _InvalidLiteralExp__Element = new ExecutorFragment(Types._InvalidLiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _InvalidLiteralExp__InvalidLiteralExp = new ExecutorFragment(Types._InvalidLiteralExp, PivotTables.Types._InvalidLiteralExp);
		public static final @NonNull ExecutorFragment _InvalidLiteralExp__LiteralExp = new ExecutorFragment(Types._InvalidLiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _InvalidLiteralExp__Nameable = new ExecutorFragment(Types._InvalidLiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _InvalidLiteralExp__NamedElement = new ExecutorFragment(Types._InvalidLiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _InvalidLiteralExp__OCLExpression = new ExecutorFragment(Types._InvalidLiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _InvalidLiteralExp__OclAny = new ExecutorFragment(Types._InvalidLiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _InvalidLiteralExp__OclElement = new ExecutorFragment(Types._InvalidLiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _InvalidLiteralExp__TypedElement = new ExecutorFragment(Types._InvalidLiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _InvalidLiteralExp__Visitable = new ExecutorFragment(Types._InvalidLiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _InvalidType__Class = new ExecutorFragment(Types._InvalidType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _InvalidType__Element = new ExecutorFragment(Types._InvalidType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _InvalidType__InvalidType = new ExecutorFragment(Types._InvalidType, PivotTables.Types._InvalidType);
		public static final @NonNull ExecutorFragment _InvalidType__Nameable = new ExecutorFragment(Types._InvalidType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _InvalidType__NamedElement = new ExecutorFragment(Types._InvalidType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _InvalidType__Namespace = new ExecutorFragment(Types._InvalidType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _InvalidType__OclAny = new ExecutorFragment(Types._InvalidType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _InvalidType__OclElement = new ExecutorFragment(Types._InvalidType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _InvalidType__OclType = new ExecutorFragment(Types._InvalidType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _InvalidType__PackageableElement = new ExecutorFragment(Types._InvalidType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _InvalidType__ParameterableElement = new ExecutorFragment(Types._InvalidType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _InvalidType__TemplateableElement = new ExecutorFragment(Types._InvalidType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _InvalidType__Type = new ExecutorFragment(Types._InvalidType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _InvalidType__Visitable = new ExecutorFragment(Types._InvalidType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _IterateExp__CallExp = new ExecutorFragment(Types._IterateExp, PivotTables.Types._CallExp);
		public static final @NonNull ExecutorFragment _IterateExp__Element = new ExecutorFragment(Types._IterateExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _IterateExp__IterateExp = new ExecutorFragment(Types._IterateExp, PivotTables.Types._IterateExp);
		public static final @NonNull ExecutorFragment _IterateExp__LoopExp = new ExecutorFragment(Types._IterateExp, PivotTables.Types._LoopExp);
		public static final @NonNull ExecutorFragment _IterateExp__Nameable = new ExecutorFragment(Types._IterateExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _IterateExp__NamedElement = new ExecutorFragment(Types._IterateExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _IterateExp__OCLExpression = new ExecutorFragment(Types._IterateExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _IterateExp__OclAny = new ExecutorFragment(Types._IterateExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _IterateExp__OclElement = new ExecutorFragment(Types._IterateExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _IterateExp__ReferringElement = new ExecutorFragment(Types._IterateExp, PivotTables.Types._ReferringElement);
		public static final @NonNull ExecutorFragment _IterateExp__TypedElement = new ExecutorFragment(Types._IterateExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _IterateExp__Visitable = new ExecutorFragment(Types._IterateExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Iteration__Element = new ExecutorFragment(Types._Iteration, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Iteration__Feature = new ExecutorFragment(Types._Iteration, PivotTables.Types._Feature);
		public static final @NonNull ExecutorFragment _Iteration__Iteration = new ExecutorFragment(Types._Iteration, PivotTables.Types._Iteration);
		public static final @NonNull ExecutorFragment _Iteration__Nameable = new ExecutorFragment(Types._Iteration, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Iteration__NamedElement = new ExecutorFragment(Types._Iteration, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Iteration__Namespace = new ExecutorFragment(Types._Iteration, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Iteration__OclAny = new ExecutorFragment(Types._Iteration, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Iteration__OclElement = new ExecutorFragment(Types._Iteration, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Iteration__Operation = new ExecutorFragment(Types._Iteration, PivotTables.Types._Operation);
		public static final @NonNull ExecutorFragment _Iteration__ParameterableElement = new ExecutorFragment(Types._Iteration, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Iteration__TemplateableElement = new ExecutorFragment(Types._Iteration, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _Iteration__TypedElement = new ExecutorFragment(Types._Iteration, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _Iteration__TypedMultiplicityElement = new ExecutorFragment(Types._Iteration, PivotTables.Types._TypedMultiplicityElement);
		public static final @NonNull ExecutorFragment _Iteration__Visitable = new ExecutorFragment(Types._Iteration, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _IteratorExp__CallExp = new ExecutorFragment(Types._IteratorExp, PivotTables.Types._CallExp);
		public static final @NonNull ExecutorFragment _IteratorExp__Element = new ExecutorFragment(Types._IteratorExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _IteratorExp__IteratorExp = new ExecutorFragment(Types._IteratorExp, PivotTables.Types._IteratorExp);
		public static final @NonNull ExecutorFragment _IteratorExp__LoopExp = new ExecutorFragment(Types._IteratorExp, PivotTables.Types._LoopExp);
		public static final @NonNull ExecutorFragment _IteratorExp__Nameable = new ExecutorFragment(Types._IteratorExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _IteratorExp__NamedElement = new ExecutorFragment(Types._IteratorExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _IteratorExp__OCLExpression = new ExecutorFragment(Types._IteratorExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _IteratorExp__OclAny = new ExecutorFragment(Types._IteratorExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _IteratorExp__OclElement = new ExecutorFragment(Types._IteratorExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _IteratorExp__ReferringElement = new ExecutorFragment(Types._IteratorExp, PivotTables.Types._ReferringElement);
		public static final @NonNull ExecutorFragment _IteratorExp__TypedElement = new ExecutorFragment(Types._IteratorExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _IteratorExp__Visitable = new ExecutorFragment(Types._IteratorExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _LambdaType__Class = new ExecutorFragment(Types._LambdaType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _LambdaType__DataType = new ExecutorFragment(Types._LambdaType, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _LambdaType__Element = new ExecutorFragment(Types._LambdaType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _LambdaType__LambdaType = new ExecutorFragment(Types._LambdaType, PivotTables.Types._LambdaType);
		public static final @NonNull ExecutorFragment _LambdaType__Nameable = new ExecutorFragment(Types._LambdaType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _LambdaType__NamedElement = new ExecutorFragment(Types._LambdaType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _LambdaType__Namespace = new ExecutorFragment(Types._LambdaType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _LambdaType__OclAny = new ExecutorFragment(Types._LambdaType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _LambdaType__OclElement = new ExecutorFragment(Types._LambdaType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _LambdaType__OclType = new ExecutorFragment(Types._LambdaType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _LambdaType__PackageableElement = new ExecutorFragment(Types._LambdaType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _LambdaType__ParameterableElement = new ExecutorFragment(Types._LambdaType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _LambdaType__TemplateableElement = new ExecutorFragment(Types._LambdaType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _LambdaType__Type = new ExecutorFragment(Types._LambdaType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _LambdaType__Visitable = new ExecutorFragment(Types._LambdaType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _LetExp__Element = new ExecutorFragment(Types._LetExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _LetExp__LetExp = new ExecutorFragment(Types._LetExp, PivotTables.Types._LetExp);
		public static final @NonNull ExecutorFragment _LetExp__Nameable = new ExecutorFragment(Types._LetExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _LetExp__NamedElement = new ExecutorFragment(Types._LetExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _LetExp__OCLExpression = new ExecutorFragment(Types._LetExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _LetExp__OclAny = new ExecutorFragment(Types._LetExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _LetExp__OclElement = new ExecutorFragment(Types._LetExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _LetExp__TypedElement = new ExecutorFragment(Types._LetExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _LetExp__Visitable = new ExecutorFragment(Types._LetExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Library__Element = new ExecutorFragment(Types._Library, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Library__Library = new ExecutorFragment(Types._Library, PivotTables.Types._Library);
		public static final @NonNull ExecutorFragment _Library__Nameable = new ExecutorFragment(Types._Library, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Library__NamedElement = new ExecutorFragment(Types._Library, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Library__Namespace = new ExecutorFragment(Types._Library, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Library__OclAny = new ExecutorFragment(Types._Library, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Library__OclElement = new ExecutorFragment(Types._Library, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Library__Package = new ExecutorFragment(Types._Library, PivotTables.Types._Package);
		public static final @NonNull ExecutorFragment _Library__PackageableElement = new ExecutorFragment(Types._Library, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _Library__ParameterableElement = new ExecutorFragment(Types._Library, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Library__TemplateableElement = new ExecutorFragment(Types._Library, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _Library__Visitable = new ExecutorFragment(Types._Library, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _LibraryFeature__LibraryFeature = new ExecutorFragment(Types._LibraryFeature, PivotTables.Types._LibraryFeature);
		public static final @NonNull ExecutorFragment _LibraryFeature__OclAny = new ExecutorFragment(Types._LibraryFeature, OCLstdlibTables.Types._OclAny);

		public static final @NonNull ExecutorFragment _LiteralExp__Element = new ExecutorFragment(Types._LiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _LiteralExp__LiteralExp = new ExecutorFragment(Types._LiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _LiteralExp__Nameable = new ExecutorFragment(Types._LiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _LiteralExp__NamedElement = new ExecutorFragment(Types._LiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _LiteralExp__OCLExpression = new ExecutorFragment(Types._LiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _LiteralExp__OclAny = new ExecutorFragment(Types._LiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _LiteralExp__OclElement = new ExecutorFragment(Types._LiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _LiteralExp__TypedElement = new ExecutorFragment(Types._LiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _LiteralExp__Visitable = new ExecutorFragment(Types._LiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _LoopExp__CallExp = new ExecutorFragment(Types._LoopExp, PivotTables.Types._CallExp);
		public static final @NonNull ExecutorFragment _LoopExp__Element = new ExecutorFragment(Types._LoopExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _LoopExp__LoopExp = new ExecutorFragment(Types._LoopExp, PivotTables.Types._LoopExp);
		public static final @NonNull ExecutorFragment _LoopExp__Nameable = new ExecutorFragment(Types._LoopExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _LoopExp__NamedElement = new ExecutorFragment(Types._LoopExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _LoopExp__OCLExpression = new ExecutorFragment(Types._LoopExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _LoopExp__OclAny = new ExecutorFragment(Types._LoopExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _LoopExp__OclElement = new ExecutorFragment(Types._LoopExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _LoopExp__TypedElement = new ExecutorFragment(Types._LoopExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _LoopExp__Visitable = new ExecutorFragment(Types._LoopExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _MessageExp__Element = new ExecutorFragment(Types._MessageExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _MessageExp__MessageExp = new ExecutorFragment(Types._MessageExp, PivotTables.Types._MessageExp);
		public static final @NonNull ExecutorFragment _MessageExp__Nameable = new ExecutorFragment(Types._MessageExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _MessageExp__NamedElement = new ExecutorFragment(Types._MessageExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _MessageExp__OCLExpression = new ExecutorFragment(Types._MessageExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _MessageExp__OclAny = new ExecutorFragment(Types._MessageExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _MessageExp__OclElement = new ExecutorFragment(Types._MessageExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _MessageExp__TypedElement = new ExecutorFragment(Types._MessageExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _MessageExp__Visitable = new ExecutorFragment(Types._MessageExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _MessageType__Element = new ExecutorFragment(Types._MessageType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _MessageType__MessageType = new ExecutorFragment(Types._MessageType, PivotTables.Types._MessageType);
		public static final @NonNull ExecutorFragment _MessageType__Nameable = new ExecutorFragment(Types._MessageType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _MessageType__NamedElement = new ExecutorFragment(Types._MessageType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _MessageType__OclAny = new ExecutorFragment(Types._MessageType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _MessageType__OclElement = new ExecutorFragment(Types._MessageType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _MessageType__OclType = new ExecutorFragment(Types._MessageType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _MessageType__PackageableElement = new ExecutorFragment(Types._MessageType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _MessageType__ParameterableElement = new ExecutorFragment(Types._MessageType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _MessageType__TemplateableElement = new ExecutorFragment(Types._MessageType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _MessageType__Type = new ExecutorFragment(Types._MessageType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _MessageType__Visitable = new ExecutorFragment(Types._MessageType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Metaclass__Class = new ExecutorFragment(Types._Metaclass, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _Metaclass__Element = new ExecutorFragment(Types._Metaclass, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Metaclass__Metaclass = new ExecutorFragment(Types._Metaclass, PivotTables.Types._Metaclass);
		public static final @NonNull ExecutorFragment _Metaclass__Nameable = new ExecutorFragment(Types._Metaclass, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Metaclass__NamedElement = new ExecutorFragment(Types._Metaclass, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Metaclass__Namespace = new ExecutorFragment(Types._Metaclass, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Metaclass__OclAny = new ExecutorFragment(Types._Metaclass, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Metaclass__OclElement = new ExecutorFragment(Types._Metaclass, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Metaclass__OclType = new ExecutorFragment(Types._Metaclass, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _Metaclass__PackageableElement = new ExecutorFragment(Types._Metaclass, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _Metaclass__ParameterableElement = new ExecutorFragment(Types._Metaclass, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Metaclass__TemplateableElement = new ExecutorFragment(Types._Metaclass, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _Metaclass__Type = new ExecutorFragment(Types._Metaclass, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _Metaclass__Visitable = new ExecutorFragment(Types._Metaclass, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _MorePivotable__MorePivotable = new ExecutorFragment(Types._MorePivotable, PivotTables.Types._MorePivotable);
		public static final @NonNull ExecutorFragment _MorePivotable__OclAny = new ExecutorFragment(Types._MorePivotable, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _MorePivotable__OclElement = new ExecutorFragment(Types._MorePivotable, OCLstdlibTables.Types._OclElement);

		public static final @NonNull ExecutorFragment _Nameable__Nameable = new ExecutorFragment(Types._Nameable, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Nameable__OclAny = new ExecutorFragment(Types._Nameable, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Nameable__OclElement = new ExecutorFragment(Types._Nameable, OCLstdlibTables.Types._OclElement);

		public static final @NonNull ExecutorFragment _NamedElement__Element = new ExecutorFragment(Types._NamedElement, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _NamedElement__Nameable = new ExecutorFragment(Types._NamedElement, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _NamedElement__NamedElement = new ExecutorFragment(Types._NamedElement, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _NamedElement__OclAny = new ExecutorFragment(Types._NamedElement, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _NamedElement__OclElement = new ExecutorFragment(Types._NamedElement, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _NamedElement__Visitable = new ExecutorFragment(Types._NamedElement, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Namespace__Element = new ExecutorFragment(Types._Namespace, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Namespace__Nameable = new ExecutorFragment(Types._Namespace, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Namespace__NamedElement = new ExecutorFragment(Types._Namespace, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Namespace__Namespace = new ExecutorFragment(Types._Namespace, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Namespace__OclAny = new ExecutorFragment(Types._Namespace, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Namespace__OclElement = new ExecutorFragment(Types._Namespace, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Namespace__Visitable = new ExecutorFragment(Types._Namespace, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _NavigationCallExp__CallExp = new ExecutorFragment(Types._NavigationCallExp, PivotTables.Types._CallExp);
		public static final @NonNull ExecutorFragment _NavigationCallExp__Element = new ExecutorFragment(Types._NavigationCallExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _NavigationCallExp__FeatureCallExp = new ExecutorFragment(Types._NavigationCallExp, PivotTables.Types._FeatureCallExp);
		public static final @NonNull ExecutorFragment _NavigationCallExp__Nameable = new ExecutorFragment(Types._NavigationCallExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _NavigationCallExp__NamedElement = new ExecutorFragment(Types._NavigationCallExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _NavigationCallExp__NavigationCallExp = new ExecutorFragment(Types._NavigationCallExp, PivotTables.Types._NavigationCallExp);
		public static final @NonNull ExecutorFragment _NavigationCallExp__OCLExpression = new ExecutorFragment(Types._NavigationCallExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _NavigationCallExp__OclAny = new ExecutorFragment(Types._NavigationCallExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _NavigationCallExp__OclElement = new ExecutorFragment(Types._NavigationCallExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _NavigationCallExp__TypedElement = new ExecutorFragment(Types._NavigationCallExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _NavigationCallExp__Visitable = new ExecutorFragment(Types._NavigationCallExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _NullLiteralExp__Element = new ExecutorFragment(Types._NullLiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _NullLiteralExp__LiteralExp = new ExecutorFragment(Types._NullLiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _NullLiteralExp__Nameable = new ExecutorFragment(Types._NullLiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _NullLiteralExp__NamedElement = new ExecutorFragment(Types._NullLiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _NullLiteralExp__NullLiteralExp = new ExecutorFragment(Types._NullLiteralExp, PivotTables.Types._NullLiteralExp);
		public static final @NonNull ExecutorFragment _NullLiteralExp__OCLExpression = new ExecutorFragment(Types._NullLiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _NullLiteralExp__OclAny = new ExecutorFragment(Types._NullLiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _NullLiteralExp__OclElement = new ExecutorFragment(Types._NullLiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _NullLiteralExp__PrimitiveLiteralExp = new ExecutorFragment(Types._NullLiteralExp, PivotTables.Types._PrimitiveLiteralExp);
		public static final @NonNull ExecutorFragment _NullLiteralExp__TypedElement = new ExecutorFragment(Types._NullLiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _NullLiteralExp__Visitable = new ExecutorFragment(Types._NullLiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _NumericLiteralExp__Element = new ExecutorFragment(Types._NumericLiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _NumericLiteralExp__LiteralExp = new ExecutorFragment(Types._NumericLiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _NumericLiteralExp__Nameable = new ExecutorFragment(Types._NumericLiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _NumericLiteralExp__NamedElement = new ExecutorFragment(Types._NumericLiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _NumericLiteralExp__NumericLiteralExp = new ExecutorFragment(Types._NumericLiteralExp, PivotTables.Types._NumericLiteralExp);
		public static final @NonNull ExecutorFragment _NumericLiteralExp__OCLExpression = new ExecutorFragment(Types._NumericLiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _NumericLiteralExp__OclAny = new ExecutorFragment(Types._NumericLiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _NumericLiteralExp__OclElement = new ExecutorFragment(Types._NumericLiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _NumericLiteralExp__PrimitiveLiteralExp = new ExecutorFragment(Types._NumericLiteralExp, PivotTables.Types._PrimitiveLiteralExp);
		public static final @NonNull ExecutorFragment _NumericLiteralExp__TypedElement = new ExecutorFragment(Types._NumericLiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _NumericLiteralExp__Visitable = new ExecutorFragment(Types._NumericLiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _OCLExpression__Element = new ExecutorFragment(Types._OCLExpression, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _OCLExpression__Nameable = new ExecutorFragment(Types._OCLExpression, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _OCLExpression__NamedElement = new ExecutorFragment(Types._OCLExpression, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _OCLExpression__OCLExpression = new ExecutorFragment(Types._OCLExpression, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _OCLExpression__OclAny = new ExecutorFragment(Types._OCLExpression, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _OCLExpression__OclElement = new ExecutorFragment(Types._OCLExpression, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _OCLExpression__TypedElement = new ExecutorFragment(Types._OCLExpression, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _OCLExpression__Visitable = new ExecutorFragment(Types._OCLExpression, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Object__Object = new ExecutorFragment(Types._Object, PivotTables.Types._Object);
		public static final @NonNull ExecutorFragment _Object__OclAny = new ExecutorFragment(Types._Object, OCLstdlibTables.Types._OclAny);

		public static final @NonNull ExecutorFragment _OpaqueExpression__Element = new ExecutorFragment(Types._OpaqueExpression, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _OpaqueExpression__Nameable = new ExecutorFragment(Types._OpaqueExpression, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _OpaqueExpression__NamedElement = new ExecutorFragment(Types._OpaqueExpression, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _OpaqueExpression__OclAny = new ExecutorFragment(Types._OpaqueExpression, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _OpaqueExpression__OclElement = new ExecutorFragment(Types._OpaqueExpression, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _OpaqueExpression__OpaqueExpression = new ExecutorFragment(Types._OpaqueExpression, PivotTables.Types._OpaqueExpression);
		public static final @NonNull ExecutorFragment _OpaqueExpression__PackageableElement = new ExecutorFragment(Types._OpaqueExpression, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _OpaqueExpression__ParameterableElement = new ExecutorFragment(Types._OpaqueExpression, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _OpaqueExpression__TypedElement = new ExecutorFragment(Types._OpaqueExpression, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _OpaqueExpression__ValueSpecification = new ExecutorFragment(Types._OpaqueExpression, PivotTables.Types._ValueSpecification);
		public static final @NonNull ExecutorFragment _OpaqueExpression__Visitable = new ExecutorFragment(Types._OpaqueExpression, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Operation__Element = new ExecutorFragment(Types._Operation, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Operation__Feature = new ExecutorFragment(Types._Operation, PivotTables.Types._Feature);
		public static final @NonNull ExecutorFragment _Operation__Nameable = new ExecutorFragment(Types._Operation, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Operation__NamedElement = new ExecutorFragment(Types._Operation, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Operation__Namespace = new ExecutorFragment(Types._Operation, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Operation__OclAny = new ExecutorFragment(Types._Operation, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Operation__OclElement = new ExecutorFragment(Types._Operation, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Operation__Operation = new ExecutorFragment(Types._Operation, PivotTables.Types._Operation);
		public static final @NonNull ExecutorFragment _Operation__ParameterableElement = new ExecutorFragment(Types._Operation, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Operation__TemplateableElement = new ExecutorFragment(Types._Operation, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _Operation__TypedElement = new ExecutorFragment(Types._Operation, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _Operation__TypedMultiplicityElement = new ExecutorFragment(Types._Operation, PivotTables.Types._TypedMultiplicityElement);
		public static final @NonNull ExecutorFragment _Operation__Visitable = new ExecutorFragment(Types._Operation, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _OperationCallExp__CallExp = new ExecutorFragment(Types._OperationCallExp, PivotTables.Types._CallExp);
		public static final @NonNull ExecutorFragment _OperationCallExp__Element = new ExecutorFragment(Types._OperationCallExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _OperationCallExp__FeatureCallExp = new ExecutorFragment(Types._OperationCallExp, PivotTables.Types._FeatureCallExp);
		public static final @NonNull ExecutorFragment _OperationCallExp__Nameable = new ExecutorFragment(Types._OperationCallExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _OperationCallExp__NamedElement = new ExecutorFragment(Types._OperationCallExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _OperationCallExp__OCLExpression = new ExecutorFragment(Types._OperationCallExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _OperationCallExp__OclAny = new ExecutorFragment(Types._OperationCallExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _OperationCallExp__OclElement = new ExecutorFragment(Types._OperationCallExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _OperationCallExp__OperationCallExp = new ExecutorFragment(Types._OperationCallExp, PivotTables.Types._OperationCallExp);
		public static final @NonNull ExecutorFragment _OperationCallExp__ReferringElement = new ExecutorFragment(Types._OperationCallExp, PivotTables.Types._ReferringElement);
		public static final @NonNull ExecutorFragment _OperationCallExp__TypedElement = new ExecutorFragment(Types._OperationCallExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _OperationCallExp__Visitable = new ExecutorFragment(Types._OperationCallExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _OperationTemplateParameter__Element = new ExecutorFragment(Types._OperationTemplateParameter, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _OperationTemplateParameter__OclAny = new ExecutorFragment(Types._OperationTemplateParameter, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _OperationTemplateParameter__OclElement = new ExecutorFragment(Types._OperationTemplateParameter, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _OperationTemplateParameter__OperationTemplateParameter = new ExecutorFragment(Types._OperationTemplateParameter, PivotTables.Types._OperationTemplateParameter);
		public static final @NonNull ExecutorFragment _OperationTemplateParameter__TemplateParameter = new ExecutorFragment(Types._OperationTemplateParameter, PivotTables.Types._TemplateParameter);
		public static final @NonNull ExecutorFragment _OperationTemplateParameter__Visitable = new ExecutorFragment(Types._OperationTemplateParameter, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _OrderedSetType__Class = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _OrderedSetType__CollectionType = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._CollectionType);
		public static final @NonNull ExecutorFragment _OrderedSetType__DataType = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _OrderedSetType__Element = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _OrderedSetType__Nameable = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _OrderedSetType__NamedElement = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _OrderedSetType__Namespace = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _OrderedSetType__OclAny = new ExecutorFragment(Types._OrderedSetType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _OrderedSetType__OclElement = new ExecutorFragment(Types._OrderedSetType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _OrderedSetType__OclType = new ExecutorFragment(Types._OrderedSetType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _OrderedSetType__OrderedSetType = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._OrderedSetType);
		public static final @NonNull ExecutorFragment _OrderedSetType__PackageableElement = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _OrderedSetType__ParameterableElement = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _OrderedSetType__TemplateableElement = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _OrderedSetType__Type = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _OrderedSetType__Visitable = new ExecutorFragment(Types._OrderedSetType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Package__Element = new ExecutorFragment(Types._Package, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Package__Nameable = new ExecutorFragment(Types._Package, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Package__NamedElement = new ExecutorFragment(Types._Package, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Package__Namespace = new ExecutorFragment(Types._Package, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Package__OclAny = new ExecutorFragment(Types._Package, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Package__OclElement = new ExecutorFragment(Types._Package, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Package__Package = new ExecutorFragment(Types._Package, PivotTables.Types._Package);
		public static final @NonNull ExecutorFragment _Package__PackageableElement = new ExecutorFragment(Types._Package, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _Package__ParameterableElement = new ExecutorFragment(Types._Package, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Package__TemplateableElement = new ExecutorFragment(Types._Package, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _Package__Visitable = new ExecutorFragment(Types._Package, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _PackageableElement__Element = new ExecutorFragment(Types._PackageableElement, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _PackageableElement__Nameable = new ExecutorFragment(Types._PackageableElement, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _PackageableElement__NamedElement = new ExecutorFragment(Types._PackageableElement, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _PackageableElement__OclAny = new ExecutorFragment(Types._PackageableElement, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _PackageableElement__OclElement = new ExecutorFragment(Types._PackageableElement, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _PackageableElement__PackageableElement = new ExecutorFragment(Types._PackageableElement, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _PackageableElement__ParameterableElement = new ExecutorFragment(Types._PackageableElement, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _PackageableElement__Visitable = new ExecutorFragment(Types._PackageableElement, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Parameter__Element = new ExecutorFragment(Types._Parameter, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Parameter__Nameable = new ExecutorFragment(Types._Parameter, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Parameter__NamedElement = new ExecutorFragment(Types._Parameter, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Parameter__OclAny = new ExecutorFragment(Types._Parameter, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Parameter__OclElement = new ExecutorFragment(Types._Parameter, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Parameter__PackageableElement = new ExecutorFragment(Types._Parameter, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _Parameter__Parameter = new ExecutorFragment(Types._Parameter, PivotTables.Types._Parameter);
		public static final @NonNull ExecutorFragment _Parameter__ParameterableElement = new ExecutorFragment(Types._Parameter, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Parameter__TypedElement = new ExecutorFragment(Types._Parameter, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _Parameter__TypedMultiplicityElement = new ExecutorFragment(Types._Parameter, PivotTables.Types._TypedMultiplicityElement);
		public static final @NonNull ExecutorFragment _Parameter__VariableDeclaration = new ExecutorFragment(Types._Parameter, PivotTables.Types._VariableDeclaration);
		public static final @NonNull ExecutorFragment _Parameter__Visitable = new ExecutorFragment(Types._Parameter, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _ParameterableElement__Element = new ExecutorFragment(Types._ParameterableElement, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _ParameterableElement__OclAny = new ExecutorFragment(Types._ParameterableElement, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _ParameterableElement__OclElement = new ExecutorFragment(Types._ParameterableElement, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _ParameterableElement__ParameterableElement = new ExecutorFragment(Types._ParameterableElement, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _ParameterableElement__Visitable = new ExecutorFragment(Types._ParameterableElement, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Pivotable__OclAny = new ExecutorFragment(Types._Pivotable, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Pivotable__OclElement = new ExecutorFragment(Types._Pivotable, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Pivotable__Pivotable = new ExecutorFragment(Types._Pivotable, PivotTables.Types._Pivotable);

		public static final @NonNull ExecutorFragment _Precedence__Element = new ExecutorFragment(Types._Precedence, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Precedence__Nameable = new ExecutorFragment(Types._Precedence, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Precedence__NamedElement = new ExecutorFragment(Types._Precedence, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Precedence__OclAny = new ExecutorFragment(Types._Precedence, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Precedence__OclElement = new ExecutorFragment(Types._Precedence, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Precedence__Precedence = new ExecutorFragment(Types._Precedence, PivotTables.Types._Precedence);
		public static final @NonNull ExecutorFragment _Precedence__Visitable = new ExecutorFragment(Types._Precedence, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _PrimitiveLiteralExp__Element = new ExecutorFragment(Types._PrimitiveLiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _PrimitiveLiteralExp__LiteralExp = new ExecutorFragment(Types._PrimitiveLiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _PrimitiveLiteralExp__Nameable = new ExecutorFragment(Types._PrimitiveLiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _PrimitiveLiteralExp__NamedElement = new ExecutorFragment(Types._PrimitiveLiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _PrimitiveLiteralExp__OCLExpression = new ExecutorFragment(Types._PrimitiveLiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _PrimitiveLiteralExp__OclAny = new ExecutorFragment(Types._PrimitiveLiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _PrimitiveLiteralExp__OclElement = new ExecutorFragment(Types._PrimitiveLiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _PrimitiveLiteralExp__PrimitiveLiteralExp = new ExecutorFragment(Types._PrimitiveLiteralExp, PivotTables.Types._PrimitiveLiteralExp);
		public static final @NonNull ExecutorFragment _PrimitiveLiteralExp__TypedElement = new ExecutorFragment(Types._PrimitiveLiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _PrimitiveLiteralExp__Visitable = new ExecutorFragment(Types._PrimitiveLiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _PrimitiveType__Class = new ExecutorFragment(Types._PrimitiveType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _PrimitiveType__DataType = new ExecutorFragment(Types._PrimitiveType, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _PrimitiveType__Element = new ExecutorFragment(Types._PrimitiveType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _PrimitiveType__Nameable = new ExecutorFragment(Types._PrimitiveType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _PrimitiveType__NamedElement = new ExecutorFragment(Types._PrimitiveType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _PrimitiveType__Namespace = new ExecutorFragment(Types._PrimitiveType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _PrimitiveType__OclAny = new ExecutorFragment(Types._PrimitiveType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _PrimitiveType__OclElement = new ExecutorFragment(Types._PrimitiveType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _PrimitiveType__OclType = new ExecutorFragment(Types._PrimitiveType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _PrimitiveType__PackageableElement = new ExecutorFragment(Types._PrimitiveType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _PrimitiveType__ParameterableElement = new ExecutorFragment(Types._PrimitiveType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _PrimitiveType__PrimitiveType = new ExecutorFragment(Types._PrimitiveType, PivotTables.Types._PrimitiveType);
		public static final @NonNull ExecutorFragment _PrimitiveType__TemplateableElement = new ExecutorFragment(Types._PrimitiveType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _PrimitiveType__Type = new ExecutorFragment(Types._PrimitiveType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _PrimitiveType__Visitable = new ExecutorFragment(Types._PrimitiveType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Profile__Element = new ExecutorFragment(Types._Profile, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Profile__Nameable = new ExecutorFragment(Types._Profile, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Profile__NamedElement = new ExecutorFragment(Types._Profile, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Profile__Namespace = new ExecutorFragment(Types._Profile, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Profile__OclAny = new ExecutorFragment(Types._Profile, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Profile__OclElement = new ExecutorFragment(Types._Profile, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Profile__Package = new ExecutorFragment(Types._Profile, PivotTables.Types._Package);
		public static final @NonNull ExecutorFragment _Profile__PackageableElement = new ExecutorFragment(Types._Profile, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _Profile__ParameterableElement = new ExecutorFragment(Types._Profile, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Profile__Profile = new ExecutorFragment(Types._Profile, PivotTables.Types._Profile);
		public static final @NonNull ExecutorFragment _Profile__TemplateableElement = new ExecutorFragment(Types._Profile, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _Profile__Visitable = new ExecutorFragment(Types._Profile, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Property__Element = new ExecutorFragment(Types._Property, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Property__Feature = new ExecutorFragment(Types._Property, PivotTables.Types._Feature);
		public static final @NonNull ExecutorFragment _Property__Nameable = new ExecutorFragment(Types._Property, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Property__NamedElement = new ExecutorFragment(Types._Property, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Property__OclAny = new ExecutorFragment(Types._Property, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Property__OclElement = new ExecutorFragment(Types._Property, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Property__ParameterableElement = new ExecutorFragment(Types._Property, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Property__Property = new ExecutorFragment(Types._Property, PivotTables.Types._Property);
		public static final @NonNull ExecutorFragment _Property__TypedElement = new ExecutorFragment(Types._Property, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _Property__TypedMultiplicityElement = new ExecutorFragment(Types._Property, PivotTables.Types._TypedMultiplicityElement);
		public static final @NonNull ExecutorFragment _Property__Visitable = new ExecutorFragment(Types._Property, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _PropertyCallExp__CallExp = new ExecutorFragment(Types._PropertyCallExp, PivotTables.Types._CallExp);
		public static final @NonNull ExecutorFragment _PropertyCallExp__Element = new ExecutorFragment(Types._PropertyCallExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _PropertyCallExp__FeatureCallExp = new ExecutorFragment(Types._PropertyCallExp, PivotTables.Types._FeatureCallExp);
		public static final @NonNull ExecutorFragment _PropertyCallExp__Nameable = new ExecutorFragment(Types._PropertyCallExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _PropertyCallExp__NamedElement = new ExecutorFragment(Types._PropertyCallExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _PropertyCallExp__NavigationCallExp = new ExecutorFragment(Types._PropertyCallExp, PivotTables.Types._NavigationCallExp);
		public static final @NonNull ExecutorFragment _PropertyCallExp__OCLExpression = new ExecutorFragment(Types._PropertyCallExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _PropertyCallExp__OclAny = new ExecutorFragment(Types._PropertyCallExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _PropertyCallExp__OclElement = new ExecutorFragment(Types._PropertyCallExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _PropertyCallExp__PropertyCallExp = new ExecutorFragment(Types._PropertyCallExp, PivotTables.Types._PropertyCallExp);
		public static final @NonNull ExecutorFragment _PropertyCallExp__ReferringElement = new ExecutorFragment(Types._PropertyCallExp, PivotTables.Types._ReferringElement);
		public static final @NonNull ExecutorFragment _PropertyCallExp__TypedElement = new ExecutorFragment(Types._PropertyCallExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _PropertyCallExp__Visitable = new ExecutorFragment(Types._PropertyCallExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Pseudostate__Element = new ExecutorFragment(Types._Pseudostate, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Pseudostate__Nameable = new ExecutorFragment(Types._Pseudostate, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Pseudostate__NamedElement = new ExecutorFragment(Types._Pseudostate, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Pseudostate__OclAny = new ExecutorFragment(Types._Pseudostate, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Pseudostate__OclElement = new ExecutorFragment(Types._Pseudostate, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Pseudostate__Pseudostate = new ExecutorFragment(Types._Pseudostate, PivotTables.Types._Pseudostate);
		public static final @NonNull ExecutorFragment _Pseudostate__Vertex = new ExecutorFragment(Types._Pseudostate, PivotTables.Types._Vertex);
		public static final @NonNull ExecutorFragment _Pseudostate__Visitable = new ExecutorFragment(Types._Pseudostate, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _PseudostateKind__Class = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _PseudostateKind__DataType = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _PseudostateKind__Element = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _PseudostateKind__Enumeration = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._Enumeration);
		public static final @NonNull ExecutorFragment _PseudostateKind__Nameable = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _PseudostateKind__NamedElement = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _PseudostateKind__Namespace = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _PseudostateKind__OclAny = new ExecutorFragment(Types._PseudostateKind, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _PseudostateKind__OclElement = new ExecutorFragment(Types._PseudostateKind, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _PseudostateKind__OclType = new ExecutorFragment(Types._PseudostateKind, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _PseudostateKind__PackageableElement = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _PseudostateKind__ParameterableElement = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _PseudostateKind__PseudostateKind = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._PseudostateKind);
		public static final @NonNull ExecutorFragment _PseudostateKind__TemplateableElement = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _PseudostateKind__Type = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _PseudostateKind__Visitable = new ExecutorFragment(Types._PseudostateKind, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _RealLiteralExp__Element = new ExecutorFragment(Types._RealLiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _RealLiteralExp__LiteralExp = new ExecutorFragment(Types._RealLiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _RealLiteralExp__Nameable = new ExecutorFragment(Types._RealLiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _RealLiteralExp__NamedElement = new ExecutorFragment(Types._RealLiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _RealLiteralExp__NumericLiteralExp = new ExecutorFragment(Types._RealLiteralExp, PivotTables.Types._NumericLiteralExp);
		public static final @NonNull ExecutorFragment _RealLiteralExp__OCLExpression = new ExecutorFragment(Types._RealLiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _RealLiteralExp__OclAny = new ExecutorFragment(Types._RealLiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _RealLiteralExp__OclElement = new ExecutorFragment(Types._RealLiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _RealLiteralExp__PrimitiveLiteralExp = new ExecutorFragment(Types._RealLiteralExp, PivotTables.Types._PrimitiveLiteralExp);
		public static final @NonNull ExecutorFragment _RealLiteralExp__RealLiteralExp = new ExecutorFragment(Types._RealLiteralExp, PivotTables.Types._RealLiteralExp);
		public static final @NonNull ExecutorFragment _RealLiteralExp__TypedElement = new ExecutorFragment(Types._RealLiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _RealLiteralExp__Visitable = new ExecutorFragment(Types._RealLiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _ReferringElement__OclAny = new ExecutorFragment(Types._ReferringElement, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _ReferringElement__OclElement = new ExecutorFragment(Types._ReferringElement, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _ReferringElement__ReferringElement = new ExecutorFragment(Types._ReferringElement, PivotTables.Types._ReferringElement);

		public static final @NonNull ExecutorFragment _Region__Element = new ExecutorFragment(Types._Region, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Region__Nameable = new ExecutorFragment(Types._Region, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Region__NamedElement = new ExecutorFragment(Types._Region, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Region__Namespace = new ExecutorFragment(Types._Region, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Region__OclAny = new ExecutorFragment(Types._Region, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Region__OclElement = new ExecutorFragment(Types._Region, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Region__Region = new ExecutorFragment(Types._Region, PivotTables.Types._Region);
		public static final @NonNull ExecutorFragment _Region__Visitable = new ExecutorFragment(Types._Region, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Root__Element = new ExecutorFragment(Types._Root, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Root__Nameable = new ExecutorFragment(Types._Root, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Root__NamedElement = new ExecutorFragment(Types._Root, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Root__Namespace = new ExecutorFragment(Types._Root, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Root__OclAny = new ExecutorFragment(Types._Root, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Root__OclElement = new ExecutorFragment(Types._Root, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Root__Root = new ExecutorFragment(Types._Root, PivotTables.Types._Root);
		public static final @NonNull ExecutorFragment _Root__Visitable = new ExecutorFragment(Types._Root, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _SelfType__Class = new ExecutorFragment(Types._SelfType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _SelfType__Element = new ExecutorFragment(Types._SelfType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _SelfType__Nameable = new ExecutorFragment(Types._SelfType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _SelfType__NamedElement = new ExecutorFragment(Types._SelfType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _SelfType__Namespace = new ExecutorFragment(Types._SelfType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _SelfType__OclAny = new ExecutorFragment(Types._SelfType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _SelfType__OclElement = new ExecutorFragment(Types._SelfType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _SelfType__OclType = new ExecutorFragment(Types._SelfType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _SelfType__PackageableElement = new ExecutorFragment(Types._SelfType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _SelfType__ParameterableElement = new ExecutorFragment(Types._SelfType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _SelfType__SelfType = new ExecutorFragment(Types._SelfType, PivotTables.Types._SelfType);
		public static final @NonNull ExecutorFragment _SelfType__TemplateableElement = new ExecutorFragment(Types._SelfType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _SelfType__Type = new ExecutorFragment(Types._SelfType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _SelfType__Visitable = new ExecutorFragment(Types._SelfType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _SendSignalAction__Element = new ExecutorFragment(Types._SendSignalAction, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _SendSignalAction__Nameable = new ExecutorFragment(Types._SendSignalAction, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _SendSignalAction__NamedElement = new ExecutorFragment(Types._SendSignalAction, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _SendSignalAction__OclAny = new ExecutorFragment(Types._SendSignalAction, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _SendSignalAction__OclElement = new ExecutorFragment(Types._SendSignalAction, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _SendSignalAction__SendSignalAction = new ExecutorFragment(Types._SendSignalAction, PivotTables.Types._SendSignalAction);
		public static final @NonNull ExecutorFragment _SendSignalAction__Visitable = new ExecutorFragment(Types._SendSignalAction, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _SequenceType__Class = new ExecutorFragment(Types._SequenceType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _SequenceType__CollectionType = new ExecutorFragment(Types._SequenceType, PivotTables.Types._CollectionType);
		public static final @NonNull ExecutorFragment _SequenceType__DataType = new ExecutorFragment(Types._SequenceType, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _SequenceType__Element = new ExecutorFragment(Types._SequenceType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _SequenceType__Nameable = new ExecutorFragment(Types._SequenceType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _SequenceType__NamedElement = new ExecutorFragment(Types._SequenceType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _SequenceType__Namespace = new ExecutorFragment(Types._SequenceType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _SequenceType__OclAny = new ExecutorFragment(Types._SequenceType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _SequenceType__OclElement = new ExecutorFragment(Types._SequenceType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _SequenceType__OclType = new ExecutorFragment(Types._SequenceType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _SequenceType__PackageableElement = new ExecutorFragment(Types._SequenceType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _SequenceType__ParameterableElement = new ExecutorFragment(Types._SequenceType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _SequenceType__SequenceType = new ExecutorFragment(Types._SequenceType, PivotTables.Types._SequenceType);
		public static final @NonNull ExecutorFragment _SequenceType__TemplateableElement = new ExecutorFragment(Types._SequenceType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _SequenceType__Type = new ExecutorFragment(Types._SequenceType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _SequenceType__Visitable = new ExecutorFragment(Types._SequenceType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _SetType__Class = new ExecutorFragment(Types._SetType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _SetType__CollectionType = new ExecutorFragment(Types._SetType, PivotTables.Types._CollectionType);
		public static final @NonNull ExecutorFragment _SetType__DataType = new ExecutorFragment(Types._SetType, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _SetType__Element = new ExecutorFragment(Types._SetType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _SetType__Nameable = new ExecutorFragment(Types._SetType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _SetType__NamedElement = new ExecutorFragment(Types._SetType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _SetType__Namespace = new ExecutorFragment(Types._SetType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _SetType__OclAny = new ExecutorFragment(Types._SetType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _SetType__OclElement = new ExecutorFragment(Types._SetType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _SetType__OclType = new ExecutorFragment(Types._SetType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _SetType__PackageableElement = new ExecutorFragment(Types._SetType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _SetType__ParameterableElement = new ExecutorFragment(Types._SetType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _SetType__SetType = new ExecutorFragment(Types._SetType, PivotTables.Types._SetType);
		public static final @NonNull ExecutorFragment _SetType__TemplateableElement = new ExecutorFragment(Types._SetType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _SetType__Type = new ExecutorFragment(Types._SetType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _SetType__Visitable = new ExecutorFragment(Types._SetType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Signal__Class = new ExecutorFragment(Types._Signal, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _Signal__Element = new ExecutorFragment(Types._Signal, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Signal__Nameable = new ExecutorFragment(Types._Signal, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Signal__NamedElement = new ExecutorFragment(Types._Signal, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Signal__Namespace = new ExecutorFragment(Types._Signal, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Signal__OclAny = new ExecutorFragment(Types._Signal, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Signal__OclElement = new ExecutorFragment(Types._Signal, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Signal__OclType = new ExecutorFragment(Types._Signal, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _Signal__PackageableElement = new ExecutorFragment(Types._Signal, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _Signal__ParameterableElement = new ExecutorFragment(Types._Signal, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Signal__Signal = new ExecutorFragment(Types._Signal, PivotTables.Types._Signal);
		public static final @NonNull ExecutorFragment _Signal__TemplateableElement = new ExecutorFragment(Types._Signal, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _Signal__Type = new ExecutorFragment(Types._Signal, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _Signal__Visitable = new ExecutorFragment(Types._Signal, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _State__Element = new ExecutorFragment(Types._State, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _State__Nameable = new ExecutorFragment(Types._State, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _State__NamedElement = new ExecutorFragment(Types._State, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _State__Namespace = new ExecutorFragment(Types._State, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _State__OclAny = new ExecutorFragment(Types._State, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _State__OclElement = new ExecutorFragment(Types._State, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _State__OclState = new ExecutorFragment(Types._State, OCLstdlibTables.Types._OclState);
		public static final @NonNull ExecutorFragment _State__State = new ExecutorFragment(Types._State, PivotTables.Types._State);
		public static final @NonNull ExecutorFragment _State__Vertex = new ExecutorFragment(Types._State, PivotTables.Types._Vertex);
		public static final @NonNull ExecutorFragment _State__Visitable = new ExecutorFragment(Types._State, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _StateExp__Element = new ExecutorFragment(Types._StateExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _StateExp__Nameable = new ExecutorFragment(Types._StateExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _StateExp__NamedElement = new ExecutorFragment(Types._StateExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _StateExp__OCLExpression = new ExecutorFragment(Types._StateExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _StateExp__OclAny = new ExecutorFragment(Types._StateExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _StateExp__OclElement = new ExecutorFragment(Types._StateExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _StateExp__StateExp = new ExecutorFragment(Types._StateExp, PivotTables.Types._StateExp);
		public static final @NonNull ExecutorFragment _StateExp__TypedElement = new ExecutorFragment(Types._StateExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _StateExp__Visitable = new ExecutorFragment(Types._StateExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _StateMachine__Behavior = new ExecutorFragment(Types._StateMachine, PivotTables.Types._Behavior);
		public static final @NonNull ExecutorFragment _StateMachine__Class = new ExecutorFragment(Types._StateMachine, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _StateMachine__Element = new ExecutorFragment(Types._StateMachine, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _StateMachine__Nameable = new ExecutorFragment(Types._StateMachine, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _StateMachine__NamedElement = new ExecutorFragment(Types._StateMachine, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _StateMachine__Namespace = new ExecutorFragment(Types._StateMachine, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _StateMachine__OclAny = new ExecutorFragment(Types._StateMachine, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _StateMachine__OclElement = new ExecutorFragment(Types._StateMachine, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _StateMachine__OclType = new ExecutorFragment(Types._StateMachine, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _StateMachine__PackageableElement = new ExecutorFragment(Types._StateMachine, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _StateMachine__ParameterableElement = new ExecutorFragment(Types._StateMachine, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _StateMachine__StateMachine = new ExecutorFragment(Types._StateMachine, PivotTables.Types._StateMachine);
		public static final @NonNull ExecutorFragment _StateMachine__TemplateableElement = new ExecutorFragment(Types._StateMachine, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _StateMachine__Type = new ExecutorFragment(Types._StateMachine, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _StateMachine__Visitable = new ExecutorFragment(Types._StateMachine, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Stereotype__Class = new ExecutorFragment(Types._Stereotype, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _Stereotype__Element = new ExecutorFragment(Types._Stereotype, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Stereotype__Nameable = new ExecutorFragment(Types._Stereotype, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Stereotype__NamedElement = new ExecutorFragment(Types._Stereotype, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Stereotype__Namespace = new ExecutorFragment(Types._Stereotype, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Stereotype__OclAny = new ExecutorFragment(Types._Stereotype, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Stereotype__OclElement = new ExecutorFragment(Types._Stereotype, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Stereotype__OclType = new ExecutorFragment(Types._Stereotype, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _Stereotype__PackageableElement = new ExecutorFragment(Types._Stereotype, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _Stereotype__ParameterableElement = new ExecutorFragment(Types._Stereotype, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Stereotype__Stereotype = new ExecutorFragment(Types._Stereotype, PivotTables.Types._Stereotype);
		public static final @NonNull ExecutorFragment _Stereotype__TemplateableElement = new ExecutorFragment(Types._Stereotype, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _Stereotype__Type = new ExecutorFragment(Types._Stereotype, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _Stereotype__Visitable = new ExecutorFragment(Types._Stereotype, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _StringLiteralExp__Element = new ExecutorFragment(Types._StringLiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _StringLiteralExp__LiteralExp = new ExecutorFragment(Types._StringLiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _StringLiteralExp__Nameable = new ExecutorFragment(Types._StringLiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _StringLiteralExp__NamedElement = new ExecutorFragment(Types._StringLiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _StringLiteralExp__OCLExpression = new ExecutorFragment(Types._StringLiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _StringLiteralExp__OclAny = new ExecutorFragment(Types._StringLiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _StringLiteralExp__OclElement = new ExecutorFragment(Types._StringLiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _StringLiteralExp__PrimitiveLiteralExp = new ExecutorFragment(Types._StringLiteralExp, PivotTables.Types._PrimitiveLiteralExp);
		public static final @NonNull ExecutorFragment _StringLiteralExp__StringLiteralExp = new ExecutorFragment(Types._StringLiteralExp, PivotTables.Types._StringLiteralExp);
		public static final @NonNull ExecutorFragment _StringLiteralExp__TypedElement = new ExecutorFragment(Types._StringLiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _StringLiteralExp__Visitable = new ExecutorFragment(Types._StringLiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TemplateBinding__Element = new ExecutorFragment(Types._TemplateBinding, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TemplateBinding__OclAny = new ExecutorFragment(Types._TemplateBinding, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TemplateBinding__OclElement = new ExecutorFragment(Types._TemplateBinding, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TemplateBinding__TemplateBinding = new ExecutorFragment(Types._TemplateBinding, PivotTables.Types._TemplateBinding);
		public static final @NonNull ExecutorFragment _TemplateBinding__Visitable = new ExecutorFragment(Types._TemplateBinding, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TemplateParameter__Element = new ExecutorFragment(Types._TemplateParameter, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TemplateParameter__OclAny = new ExecutorFragment(Types._TemplateParameter, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TemplateParameter__OclElement = new ExecutorFragment(Types._TemplateParameter, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TemplateParameter__TemplateParameter = new ExecutorFragment(Types._TemplateParameter, PivotTables.Types._TemplateParameter);
		public static final @NonNull ExecutorFragment _TemplateParameter__Visitable = new ExecutorFragment(Types._TemplateParameter, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TemplateParameterSubstitution__Element = new ExecutorFragment(Types._TemplateParameterSubstitution, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TemplateParameterSubstitution__OclAny = new ExecutorFragment(Types._TemplateParameterSubstitution, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TemplateParameterSubstitution__OclElement = new ExecutorFragment(Types._TemplateParameterSubstitution, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TemplateParameterSubstitution__TemplateParameterSubstitution = new ExecutorFragment(Types._TemplateParameterSubstitution, PivotTables.Types._TemplateParameterSubstitution);
		public static final @NonNull ExecutorFragment _TemplateParameterSubstitution__Visitable = new ExecutorFragment(Types._TemplateParameterSubstitution, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TemplateParameterType__Element = new ExecutorFragment(Types._TemplateParameterType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TemplateParameterType__Nameable = new ExecutorFragment(Types._TemplateParameterType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _TemplateParameterType__NamedElement = new ExecutorFragment(Types._TemplateParameterType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _TemplateParameterType__OclAny = new ExecutorFragment(Types._TemplateParameterType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TemplateParameterType__OclElement = new ExecutorFragment(Types._TemplateParameterType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TemplateParameterType__OclType = new ExecutorFragment(Types._TemplateParameterType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _TemplateParameterType__PackageableElement = new ExecutorFragment(Types._TemplateParameterType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _TemplateParameterType__ParameterableElement = new ExecutorFragment(Types._TemplateParameterType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _TemplateParameterType__TemplateParameterType = new ExecutorFragment(Types._TemplateParameterType, PivotTables.Types._TemplateParameterType);
		public static final @NonNull ExecutorFragment _TemplateParameterType__TemplateableElement = new ExecutorFragment(Types._TemplateParameterType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _TemplateParameterType__Type = new ExecutorFragment(Types._TemplateParameterType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _TemplateParameterType__Visitable = new ExecutorFragment(Types._TemplateParameterType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TemplateSignature__Element = new ExecutorFragment(Types._TemplateSignature, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TemplateSignature__OclAny = new ExecutorFragment(Types._TemplateSignature, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TemplateSignature__OclElement = new ExecutorFragment(Types._TemplateSignature, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TemplateSignature__TemplateSignature = new ExecutorFragment(Types._TemplateSignature, PivotTables.Types._TemplateSignature);
		public static final @NonNull ExecutorFragment _TemplateSignature__Visitable = new ExecutorFragment(Types._TemplateSignature, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TemplateableElement__Element = new ExecutorFragment(Types._TemplateableElement, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TemplateableElement__OclAny = new ExecutorFragment(Types._TemplateableElement, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TemplateableElement__OclElement = new ExecutorFragment(Types._TemplateableElement, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TemplateableElement__TemplateableElement = new ExecutorFragment(Types._TemplateableElement, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _TemplateableElement__Visitable = new ExecutorFragment(Types._TemplateableElement, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Throwable__OclAny = new ExecutorFragment(Types._Throwable, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Throwable__Throwable = new ExecutorFragment(Types._Throwable, PivotTables.Types._Throwable);

		public static final @NonNull ExecutorFragment _Transition__Element = new ExecutorFragment(Types._Transition, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Transition__Nameable = new ExecutorFragment(Types._Transition, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Transition__NamedElement = new ExecutorFragment(Types._Transition, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Transition__Namespace = new ExecutorFragment(Types._Transition, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _Transition__OclAny = new ExecutorFragment(Types._Transition, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Transition__OclElement = new ExecutorFragment(Types._Transition, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Transition__Transition = new ExecutorFragment(Types._Transition, PivotTables.Types._Transition);
		public static final @NonNull ExecutorFragment _Transition__Visitable = new ExecutorFragment(Types._Transition, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TransitionKind__Class = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _TransitionKind__DataType = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _TransitionKind__Element = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TransitionKind__Enumeration = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._Enumeration);
		public static final @NonNull ExecutorFragment _TransitionKind__Nameable = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _TransitionKind__NamedElement = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _TransitionKind__Namespace = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _TransitionKind__OclAny = new ExecutorFragment(Types._TransitionKind, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TransitionKind__OclElement = new ExecutorFragment(Types._TransitionKind, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TransitionKind__OclType = new ExecutorFragment(Types._TransitionKind, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _TransitionKind__PackageableElement = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _TransitionKind__ParameterableElement = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _TransitionKind__TemplateableElement = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _TransitionKind__TransitionKind = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._TransitionKind);
		public static final @NonNull ExecutorFragment _TransitionKind__Type = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _TransitionKind__Visitable = new ExecutorFragment(Types._TransitionKind, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Trigger__Element = new ExecutorFragment(Types._Trigger, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Trigger__Nameable = new ExecutorFragment(Types._Trigger, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Trigger__NamedElement = new ExecutorFragment(Types._Trigger, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Trigger__OclAny = new ExecutorFragment(Types._Trigger, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Trigger__OclElement = new ExecutorFragment(Types._Trigger, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Trigger__Trigger = new ExecutorFragment(Types._Trigger, PivotTables.Types._Trigger);
		public static final @NonNull ExecutorFragment _Trigger__Visitable = new ExecutorFragment(Types._Trigger, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TupleLiteralExp__Element = new ExecutorFragment(Types._TupleLiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TupleLiteralExp__LiteralExp = new ExecutorFragment(Types._TupleLiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _TupleLiteralExp__Nameable = new ExecutorFragment(Types._TupleLiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _TupleLiteralExp__NamedElement = new ExecutorFragment(Types._TupleLiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _TupleLiteralExp__OCLExpression = new ExecutorFragment(Types._TupleLiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _TupleLiteralExp__OclAny = new ExecutorFragment(Types._TupleLiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TupleLiteralExp__OclElement = new ExecutorFragment(Types._TupleLiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TupleLiteralExp__TupleLiteralExp = new ExecutorFragment(Types._TupleLiteralExp, PivotTables.Types._TupleLiteralExp);
		public static final @NonNull ExecutorFragment _TupleLiteralExp__TypedElement = new ExecutorFragment(Types._TupleLiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _TupleLiteralExp__Visitable = new ExecutorFragment(Types._TupleLiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TupleLiteralPart__Element = new ExecutorFragment(Types._TupleLiteralPart, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TupleLiteralPart__Nameable = new ExecutorFragment(Types._TupleLiteralPart, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _TupleLiteralPart__NamedElement = new ExecutorFragment(Types._TupleLiteralPart, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _TupleLiteralPart__OclAny = new ExecutorFragment(Types._TupleLiteralPart, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TupleLiteralPart__OclElement = new ExecutorFragment(Types._TupleLiteralPart, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TupleLiteralPart__TupleLiteralPart = new ExecutorFragment(Types._TupleLiteralPart, PivotTables.Types._TupleLiteralPart);
		public static final @NonNull ExecutorFragment _TupleLiteralPart__TypedElement = new ExecutorFragment(Types._TupleLiteralPart, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _TupleLiteralPart__VariableDeclaration = new ExecutorFragment(Types._TupleLiteralPart, PivotTables.Types._VariableDeclaration);
		public static final @NonNull ExecutorFragment _TupleLiteralPart__Visitable = new ExecutorFragment(Types._TupleLiteralPart, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TupleType__Class = new ExecutorFragment(Types._TupleType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _TupleType__DataType = new ExecutorFragment(Types._TupleType, PivotTables.Types._DataType);
		public static final @NonNull ExecutorFragment _TupleType__Element = new ExecutorFragment(Types._TupleType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TupleType__Nameable = new ExecutorFragment(Types._TupleType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _TupleType__NamedElement = new ExecutorFragment(Types._TupleType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _TupleType__Namespace = new ExecutorFragment(Types._TupleType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _TupleType__OclAny = new ExecutorFragment(Types._TupleType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TupleType__OclElement = new ExecutorFragment(Types._TupleType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TupleType__OclType = new ExecutorFragment(Types._TupleType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _TupleType__PackageableElement = new ExecutorFragment(Types._TupleType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _TupleType__ParameterableElement = new ExecutorFragment(Types._TupleType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _TupleType__TemplateableElement = new ExecutorFragment(Types._TupleType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _TupleType__TupleType = new ExecutorFragment(Types._TupleType, PivotTables.Types._TupleType);
		public static final @NonNull ExecutorFragment _TupleType__Type = new ExecutorFragment(Types._TupleType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _TupleType__Visitable = new ExecutorFragment(Types._TupleType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Type__Element = new ExecutorFragment(Types._Type, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Type__Nameable = new ExecutorFragment(Types._Type, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Type__NamedElement = new ExecutorFragment(Types._Type, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Type__OclAny = new ExecutorFragment(Types._Type, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Type__OclElement = new ExecutorFragment(Types._Type, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Type__OclType = new ExecutorFragment(Types._Type, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _Type__PackageableElement = new ExecutorFragment(Types._Type, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _Type__ParameterableElement = new ExecutorFragment(Types._Type, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Type__TemplateableElement = new ExecutorFragment(Types._Type, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _Type__Type = new ExecutorFragment(Types._Type, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _Type__Visitable = new ExecutorFragment(Types._Type, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TypeExp__Element = new ExecutorFragment(Types._TypeExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TypeExp__Nameable = new ExecutorFragment(Types._TypeExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _TypeExp__NamedElement = new ExecutorFragment(Types._TypeExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _TypeExp__OCLExpression = new ExecutorFragment(Types._TypeExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _TypeExp__OclAny = new ExecutorFragment(Types._TypeExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TypeExp__OclElement = new ExecutorFragment(Types._TypeExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TypeExp__ReferringElement = new ExecutorFragment(Types._TypeExp, PivotTables.Types._ReferringElement);
		public static final @NonNull ExecutorFragment _TypeExp__TypeExp = new ExecutorFragment(Types._TypeExp, PivotTables.Types._TypeExp);
		public static final @NonNull ExecutorFragment _TypeExp__TypedElement = new ExecutorFragment(Types._TypeExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _TypeExp__Visitable = new ExecutorFragment(Types._TypeExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TypeTemplateParameter__Element = new ExecutorFragment(Types._TypeTemplateParameter, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TypeTemplateParameter__OclAny = new ExecutorFragment(Types._TypeTemplateParameter, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TypeTemplateParameter__OclElement = new ExecutorFragment(Types._TypeTemplateParameter, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TypeTemplateParameter__TemplateParameter = new ExecutorFragment(Types._TypeTemplateParameter, PivotTables.Types._TemplateParameter);
		public static final @NonNull ExecutorFragment _TypeTemplateParameter__TypeTemplateParameter = new ExecutorFragment(Types._TypeTemplateParameter, PivotTables.Types._TypeTemplateParameter);
		public static final @NonNull ExecutorFragment _TypeTemplateParameter__Visitable = new ExecutorFragment(Types._TypeTemplateParameter, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TypedElement__Element = new ExecutorFragment(Types._TypedElement, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TypedElement__Nameable = new ExecutorFragment(Types._TypedElement, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _TypedElement__NamedElement = new ExecutorFragment(Types._TypedElement, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _TypedElement__OclAny = new ExecutorFragment(Types._TypedElement, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TypedElement__OclElement = new ExecutorFragment(Types._TypedElement, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TypedElement__TypedElement = new ExecutorFragment(Types._TypedElement, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _TypedElement__Visitable = new ExecutorFragment(Types._TypedElement, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _TypedMultiplicityElement__Element = new ExecutorFragment(Types._TypedMultiplicityElement, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _TypedMultiplicityElement__Nameable = new ExecutorFragment(Types._TypedMultiplicityElement, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _TypedMultiplicityElement__NamedElement = new ExecutorFragment(Types._TypedMultiplicityElement, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _TypedMultiplicityElement__OclAny = new ExecutorFragment(Types._TypedMultiplicityElement, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _TypedMultiplicityElement__OclElement = new ExecutorFragment(Types._TypedMultiplicityElement, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _TypedMultiplicityElement__TypedElement = new ExecutorFragment(Types._TypedMultiplicityElement, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _TypedMultiplicityElement__TypedMultiplicityElement = new ExecutorFragment(Types._TypedMultiplicityElement, PivotTables.Types._TypedMultiplicityElement);
		public static final @NonNull ExecutorFragment _TypedMultiplicityElement__Visitable = new ExecutorFragment(Types._TypedMultiplicityElement, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _UnlimitedNaturalLiteralExp__Element = new ExecutorFragment(Types._UnlimitedNaturalLiteralExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _UnlimitedNaturalLiteralExp__LiteralExp = new ExecutorFragment(Types._UnlimitedNaturalLiteralExp, PivotTables.Types._LiteralExp);
		public static final @NonNull ExecutorFragment _UnlimitedNaturalLiteralExp__Nameable = new ExecutorFragment(Types._UnlimitedNaturalLiteralExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _UnlimitedNaturalLiteralExp__NamedElement = new ExecutorFragment(Types._UnlimitedNaturalLiteralExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _UnlimitedNaturalLiteralExp__NumericLiteralExp = new ExecutorFragment(Types._UnlimitedNaturalLiteralExp, PivotTables.Types._NumericLiteralExp);
		public static final @NonNull ExecutorFragment _UnlimitedNaturalLiteralExp__OCLExpression = new ExecutorFragment(Types._UnlimitedNaturalLiteralExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _UnlimitedNaturalLiteralExp__OclAny = new ExecutorFragment(Types._UnlimitedNaturalLiteralExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _UnlimitedNaturalLiteralExp__OclElement = new ExecutorFragment(Types._UnlimitedNaturalLiteralExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _UnlimitedNaturalLiteralExp__PrimitiveLiteralExp = new ExecutorFragment(Types._UnlimitedNaturalLiteralExp, PivotTables.Types._PrimitiveLiteralExp);
		public static final @NonNull ExecutorFragment _UnlimitedNaturalLiteralExp__TypedElement = new ExecutorFragment(Types._UnlimitedNaturalLiteralExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _UnlimitedNaturalLiteralExp__UnlimitedNaturalLiteralExp = new ExecutorFragment(Types._UnlimitedNaturalLiteralExp, PivotTables.Types._UnlimitedNaturalLiteralExp);
		public static final @NonNull ExecutorFragment _UnlimitedNaturalLiteralExp__Visitable = new ExecutorFragment(Types._UnlimitedNaturalLiteralExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _UnspecifiedType__Class = new ExecutorFragment(Types._UnspecifiedType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _UnspecifiedType__Element = new ExecutorFragment(Types._UnspecifiedType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _UnspecifiedType__Nameable = new ExecutorFragment(Types._UnspecifiedType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _UnspecifiedType__NamedElement = new ExecutorFragment(Types._UnspecifiedType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _UnspecifiedType__Namespace = new ExecutorFragment(Types._UnspecifiedType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _UnspecifiedType__OclAny = new ExecutorFragment(Types._UnspecifiedType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _UnspecifiedType__OclElement = new ExecutorFragment(Types._UnspecifiedType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _UnspecifiedType__OclType = new ExecutorFragment(Types._UnspecifiedType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _UnspecifiedType__PackageableElement = new ExecutorFragment(Types._UnspecifiedType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _UnspecifiedType__ParameterableElement = new ExecutorFragment(Types._UnspecifiedType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _UnspecifiedType__TemplateableElement = new ExecutorFragment(Types._UnspecifiedType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _UnspecifiedType__Type = new ExecutorFragment(Types._UnspecifiedType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _UnspecifiedType__UnspecifiedType = new ExecutorFragment(Types._UnspecifiedType, PivotTables.Types._UnspecifiedType);
		public static final @NonNull ExecutorFragment _UnspecifiedType__Visitable = new ExecutorFragment(Types._UnspecifiedType, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _UnspecifiedValueExp__Element = new ExecutorFragment(Types._UnspecifiedValueExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _UnspecifiedValueExp__Nameable = new ExecutorFragment(Types._UnspecifiedValueExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _UnspecifiedValueExp__NamedElement = new ExecutorFragment(Types._UnspecifiedValueExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _UnspecifiedValueExp__OCLExpression = new ExecutorFragment(Types._UnspecifiedValueExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _UnspecifiedValueExp__OclAny = new ExecutorFragment(Types._UnspecifiedValueExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _UnspecifiedValueExp__OclElement = new ExecutorFragment(Types._UnspecifiedValueExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _UnspecifiedValueExp__TypedElement = new ExecutorFragment(Types._UnspecifiedValueExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _UnspecifiedValueExp__UnspecifiedValueExp = new ExecutorFragment(Types._UnspecifiedValueExp, PivotTables.Types._UnspecifiedValueExp);
		public static final @NonNull ExecutorFragment _UnspecifiedValueExp__Visitable = new ExecutorFragment(Types._UnspecifiedValueExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _ValueSpecification__Element = new ExecutorFragment(Types._ValueSpecification, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _ValueSpecification__Nameable = new ExecutorFragment(Types._ValueSpecification, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _ValueSpecification__NamedElement = new ExecutorFragment(Types._ValueSpecification, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _ValueSpecification__OclAny = new ExecutorFragment(Types._ValueSpecification, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _ValueSpecification__OclElement = new ExecutorFragment(Types._ValueSpecification, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _ValueSpecification__PackageableElement = new ExecutorFragment(Types._ValueSpecification, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _ValueSpecification__ParameterableElement = new ExecutorFragment(Types._ValueSpecification, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _ValueSpecification__TypedElement = new ExecutorFragment(Types._ValueSpecification, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _ValueSpecification__ValueSpecification = new ExecutorFragment(Types._ValueSpecification, PivotTables.Types._ValueSpecification);
		public static final @NonNull ExecutorFragment _ValueSpecification__Visitable = new ExecutorFragment(Types._ValueSpecification, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Variable__Element = new ExecutorFragment(Types._Variable, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Variable__Nameable = new ExecutorFragment(Types._Variable, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Variable__NamedElement = new ExecutorFragment(Types._Variable, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Variable__OclAny = new ExecutorFragment(Types._Variable, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Variable__OclElement = new ExecutorFragment(Types._Variable, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Variable__ParameterableElement = new ExecutorFragment(Types._Variable, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _Variable__TypedElement = new ExecutorFragment(Types._Variable, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _Variable__Variable = new ExecutorFragment(Types._Variable, PivotTables.Types._Variable);
		public static final @NonNull ExecutorFragment _Variable__VariableDeclaration = new ExecutorFragment(Types._Variable, PivotTables.Types._VariableDeclaration);
		public static final @NonNull ExecutorFragment _Variable__Visitable = new ExecutorFragment(Types._Variable, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _VariableDeclaration__Element = new ExecutorFragment(Types._VariableDeclaration, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _VariableDeclaration__Nameable = new ExecutorFragment(Types._VariableDeclaration, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _VariableDeclaration__NamedElement = new ExecutorFragment(Types._VariableDeclaration, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _VariableDeclaration__OclAny = new ExecutorFragment(Types._VariableDeclaration, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _VariableDeclaration__OclElement = new ExecutorFragment(Types._VariableDeclaration, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _VariableDeclaration__TypedElement = new ExecutorFragment(Types._VariableDeclaration, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _VariableDeclaration__VariableDeclaration = new ExecutorFragment(Types._VariableDeclaration, PivotTables.Types._VariableDeclaration);
		public static final @NonNull ExecutorFragment _VariableDeclaration__Visitable = new ExecutorFragment(Types._VariableDeclaration, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _VariableExp__Element = new ExecutorFragment(Types._VariableExp, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _VariableExp__Nameable = new ExecutorFragment(Types._VariableExp, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _VariableExp__NamedElement = new ExecutorFragment(Types._VariableExp, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _VariableExp__OCLExpression = new ExecutorFragment(Types._VariableExp, PivotTables.Types._OCLExpression);
		public static final @NonNull ExecutorFragment _VariableExp__OclAny = new ExecutorFragment(Types._VariableExp, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _VariableExp__OclElement = new ExecutorFragment(Types._VariableExp, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _VariableExp__ReferringElement = new ExecutorFragment(Types._VariableExp, PivotTables.Types._ReferringElement);
		public static final @NonNull ExecutorFragment _VariableExp__TypedElement = new ExecutorFragment(Types._VariableExp, PivotTables.Types._TypedElement);
		public static final @NonNull ExecutorFragment _VariableExp__VariableExp = new ExecutorFragment(Types._VariableExp, PivotTables.Types._VariableExp);
		public static final @NonNull ExecutorFragment _VariableExp__Visitable = new ExecutorFragment(Types._VariableExp, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Vertex__Element = new ExecutorFragment(Types._Vertex, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _Vertex__Nameable = new ExecutorFragment(Types._Vertex, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _Vertex__NamedElement = new ExecutorFragment(Types._Vertex, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _Vertex__OclAny = new ExecutorFragment(Types._Vertex, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Vertex__OclElement = new ExecutorFragment(Types._Vertex, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Vertex__Vertex = new ExecutorFragment(Types._Vertex, PivotTables.Types._Vertex);
		public static final @NonNull ExecutorFragment _Vertex__Visitable = new ExecutorFragment(Types._Vertex, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Visitable__OclAny = new ExecutorFragment(Types._Visitable, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Visitable__OclElement = new ExecutorFragment(Types._Visitable, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Visitable__Visitable = new ExecutorFragment(Types._Visitable, PivotTables.Types._Visitable);

		public static final @NonNull ExecutorFragment _Visitor__OclAny = new ExecutorFragment(Types._Visitor, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _Visitor__OclElement = new ExecutorFragment(Types._Visitor, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _Visitor__Visitor = new ExecutorFragment(Types._Visitor, PivotTables.Types._Visitor);

		public static final @NonNull ExecutorFragment _VoidType__Class = new ExecutorFragment(Types._VoidType, PivotTables.Types._Class);
		public static final @NonNull ExecutorFragment _VoidType__Element = new ExecutorFragment(Types._VoidType, PivotTables.Types._Element);
		public static final @NonNull ExecutorFragment _VoidType__Nameable = new ExecutorFragment(Types._VoidType, PivotTables.Types._Nameable);
		public static final @NonNull ExecutorFragment _VoidType__NamedElement = new ExecutorFragment(Types._VoidType, PivotTables.Types._NamedElement);
		public static final @NonNull ExecutorFragment _VoidType__Namespace = new ExecutorFragment(Types._VoidType, PivotTables.Types._Namespace);
		public static final @NonNull ExecutorFragment _VoidType__OclAny = new ExecutorFragment(Types._VoidType, OCLstdlibTables.Types._OclAny);
		public static final @NonNull ExecutorFragment _VoidType__OclElement = new ExecutorFragment(Types._VoidType, OCLstdlibTables.Types._OclElement);
		public static final @NonNull ExecutorFragment _VoidType__OclType = new ExecutorFragment(Types._VoidType, OCLstdlibTables.Types._OclType);
		public static final @NonNull ExecutorFragment _VoidType__PackageableElement = new ExecutorFragment(Types._VoidType, PivotTables.Types._PackageableElement);
		public static final @NonNull ExecutorFragment _VoidType__ParameterableElement = new ExecutorFragment(Types._VoidType, PivotTables.Types._ParameterableElement);
		public static final @NonNull ExecutorFragment _VoidType__TemplateableElement = new ExecutorFragment(Types._VoidType, PivotTables.Types._TemplateableElement);
		public static final @NonNull ExecutorFragment _VoidType__Type = new ExecutorFragment(Types._VoidType, PivotTables.Types._Type);
		public static final @NonNull ExecutorFragment _VoidType__Visitable = new ExecutorFragment(Types._VoidType, PivotTables.Types._Visitable);
		public static final @NonNull ExecutorFragment _VoidType__VoidType = new ExecutorFragment(Types._VoidType, PivotTables.Types._VoidType);
	}

	/**
	 *	The parameter lists shared by operations.
	 */
	public static class Parameters {
		public static final @NonNull DomainParameterTypes _ = new DomainParameterTypes();
		public static final @NonNull DomainParameterTypes _OCLExpression___Type = new DomainParameterTypes(PivotTables.Types._OCLExpression, PivotTables.Types._Type);
		public static final @NonNull DomainParameterTypes _ParameterableElement = new DomainParameterTypes(PivotTables.Types._ParameterableElement);
		public static final @NonNull DomainParameterTypes _Property = new DomainParameterTypes(PivotTables.Types._Property);
		public static final @NonNull DomainParameterTypes _Type___String = new DomainParameterTypes(PivotTables.Types._Type, OCLstdlibTables.Types._String);
		public static final @NonNull DomainParameterTypes _ValueSpecification = new DomainParameterTypes(PivotTables.Types._ValueSpecification);
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 */
	public static class Operations {
		public static final @NonNull ExecutorOperation _Element__allOwnedElements = new ExecutorOperation("allOwnedElements", Parameters._, Types._Element,
			0, DomainTypeParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _Element__getValue = new ExecutorOperation("getValue", Parameters._Type___String, Types._Element,
			1, DomainTypeParameters.EMPTY_LIST, null);

		public static final @NonNull ExecutorOperation _Enumeration__allInstances = new ExecutorOperation("allInstances", Parameters._, Types._Enumeration,
			0, DomainTypeParameters.EMPTY_LIST, org.eclipse.ocl.examples.library.enumeration.EnumerationAllInstancesOperation.INSTANCE);

		public static final @NonNull ExecutorOperation _ParameterableElement__isCompatibleWith = new ExecutorOperation("isCompatibleWith", Parameters._ParameterableElement, Types._ParameterableElement,
			0, DomainTypeParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _ParameterableElement__isTemplateParameter = new ExecutorOperation("isTemplateParameter", Parameters._, Types._ParameterableElement,
			1, DomainTypeParameters.EMPTY_LIST, null);

		public static final @NonNull ExecutorOperation _Property__isAttribute = new ExecutorOperation("isAttribute", Parameters._Property, Types._Property,
			0, DomainTypeParameters.EMPTY_LIST, null);

		public static final @NonNull ExecutorOperation _PropertyCallExp__getSpecializedReferredPropertyOwningType = new ExecutorOperation("getSpecializedReferredPropertyOwningType", Parameters._, Types._PropertyCallExp,
			0, DomainTypeParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _PropertyCallExp__getSpecializedReferredPropertyType = new ExecutorOperation("getSpecializedReferredPropertyType", Parameters._, Types._PropertyCallExp,
			1, DomainTypeParameters.EMPTY_LIST, null);

		public static final @NonNull ExecutorOperation _ReferringElement__getReferredElement = new ExecutorOperation("getReferredElement", Parameters._, Types._ReferringElement,
			0, DomainTypeParameters.EMPTY_LIST, null);

		public static final @NonNull ExecutorOperation _SelfType__specializeIn = new ExecutorOperation("specializeIn", Parameters._OCLExpression___Type, Types._SelfType,
			0, DomainTypeParameters.EMPTY_LIST, null);

		public static final @NonNull ExecutorOperation _TemplateableElement__isTemplate = new ExecutorOperation("isTemplate", Parameters._, Types._TemplateableElement,
			0, DomainTypeParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _TemplateableElement__parameterableElements = new ExecutorOperation("parameterableElements", Parameters._, Types._TemplateableElement,
			1, DomainTypeParameters.EMPTY_LIST, null);

		public static final @NonNull ExecutorOperation _Type__specializeIn = new ExecutorOperation("specializeIn", Parameters._OCLExpression___Type, Types._Type,
			0, DomainTypeParameters.EMPTY_LIST, null);

		public static final @NonNull ExecutorOperation _TypedMultiplicityElement__CompatibleBody = new ExecutorOperation("CompatibleBody", Parameters._ValueSpecification, Types._TypedMultiplicityElement,
			0, DomainTypeParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _TypedMultiplicityElement__makeParameter = new ExecutorOperation("makeParameter", Parameters._, Types._TypedMultiplicityElement,
			1, DomainTypeParameters.EMPTY_LIST, null);

		public static final @NonNull ExecutorOperation _ValueSpecification__booleanValue = new ExecutorOperation("booleanValue", Parameters._, Types._ValueSpecification,
			0, DomainTypeParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _ValueSpecification__integerValue = new ExecutorOperation("integerValue", Parameters._, Types._ValueSpecification,
			1, DomainTypeParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _ValueSpecification__isComputable = new ExecutorOperation("isComputable", Parameters._, Types._ValueSpecification,
			2, DomainTypeParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _ValueSpecification__isNull = new ExecutorOperation("isNull", Parameters._, Types._ValueSpecification,
			3, DomainTypeParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _ValueSpecification__stringValue = new ExecutorOperation("stringValue", Parameters._, Types._ValueSpecification,
			4, DomainTypeParameters.EMPTY_LIST, null);
		public static final @NonNull ExecutorOperation _ValueSpecification__unlimitedValue = new ExecutorOperation("unlimitedValue", Parameters._, Types._ValueSpecification,
			5, DomainTypeParameters.EMPTY_LIST, null);

	}

	/**
	 *	The property descriptors for each property of each type.
	 */
	public static class Properties {

		public static final @NonNull ExecutorProperty _Annotation__NamedElement = new ExecutorPropertyWithImplementation("NamedElement", Types._Annotation, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.NAMED_ELEMENT__OWNED_ANNOTATION));
		public static final @NonNull ExecutorProperty _Annotation__ownedContent = new EcoreExecutorProperty(PivotPackage.Literals.ANNOTATION__OWNED_CONTENT, Types._Annotation, 1);
		public static final @NonNull ExecutorProperty _Annotation__ownedDetail = new EcoreExecutorProperty(PivotPackage.Literals.ANNOTATION__OWNED_DETAIL, Types._Annotation, 2);
		public static final @NonNull ExecutorProperty _Annotation__reference = new EcoreExecutorProperty(PivotPackage.Literals.ANNOTATION__REFERENCE, Types._Annotation, 3);

		public static final @NonNull ExecutorProperty _AssociationClass__AssociationClassCallExp = new ExecutorPropertyWithImplementation("AssociationClassCallExp", Types._AssociationClass, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS));
		public static final @NonNull ExecutorProperty _AssociationClass__unownedAttribute = new EcoreExecutorProperty(PivotPackage.Literals.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE, Types._AssociationClass, 1);

		public static final @NonNull ExecutorProperty _AssociationClassCallExp__referredAssociationClass = new EcoreExecutorProperty(PivotPackage.Literals.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS, Types._AssociationClassCallExp, 0);

		public static final @NonNull ExecutorProperty _Behavior__Class = new ExecutorPropertyWithImplementation("Class", Types._Behavior, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.CLASS__OWNED_BEHAVIOR));
		public static final @NonNull ExecutorProperty _Behavior__Transition = new ExecutorPropertyWithImplementation("Transition", Types._Behavior, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TRANSITION__EFFECT));

		public static final @NonNull ExecutorProperty _BooleanLiteralExp__booleanSymbol = new EcoreExecutorProperty(PivotPackage.Literals.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL, Types._BooleanLiteralExp, 0);

		public static final @NonNull ExecutorProperty _CallExp__implicit = new EcoreExecutorProperty(PivotPackage.Literals.CALL_EXP__IMPLICIT, Types._CallExp, 0);
		public static final @NonNull ExecutorProperty _CallExp__source = new EcoreExecutorProperty(PivotPackage.Literals.CALL_EXP__SOURCE, Types._CallExp, 1);

		public static final @NonNull ExecutorProperty _CallOperationAction__MessageExp = new ExecutorPropertyWithImplementation("MessageExp", Types._CallOperationAction, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.MESSAGE_EXP__CALLED_OPERATION));
		public static final @NonNull ExecutorProperty _CallOperationAction__operation = new EcoreExecutorProperty(PivotPackage.Literals.CALL_OPERATION_ACTION__OPERATION, Types._CallOperationAction, 1);

		public static final @NonNull ExecutorProperty _Class__TypeTemplateParameter = new ExecutorPropertyWithImplementation("TypeTemplateParameter", Types._Class, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TYPE_TEMPLATE_PARAMETER__CONSTRAINING_CLASSIFIER));
		public static final @NonNull ExecutorProperty _Class__isAbstract = new EcoreExecutorProperty(PivotPackage.Literals.CLASS__IS_ABSTRACT, Types._Class, 1);
		public static final @NonNull ExecutorProperty _Class__isInterface = new EcoreExecutorProperty(PivotPackage.Literals.CLASS__IS_INTERFACE, Types._Class, 2);
		public static final @NonNull ExecutorProperty _Class__ownedBehavior = new EcoreExecutorProperty(PivotPackage.Literals.CLASS__OWNED_BEHAVIOR, Types._Class, 3);

		public static final @NonNull ExecutorProperty _CollectionItem__item = new EcoreExecutorProperty(PivotPackage.Literals.COLLECTION_ITEM__ITEM, Types._CollectionItem, 0);

		public static final @NonNull ExecutorProperty _CollectionLiteralExp__kind = new EcoreExecutorProperty(PivotPackage.Literals.COLLECTION_LITERAL_EXP__KIND, Types._CollectionLiteralExp, 0);
		public static final @NonNull ExecutorProperty _CollectionLiteralExp__part = new EcoreExecutorProperty(PivotPackage.Literals.COLLECTION_LITERAL_EXP__PART, Types._CollectionLiteralExp, 1);

		public static final @NonNull ExecutorProperty _CollectionLiteralPart__CollectionLiteralExp = new ExecutorPropertyWithImplementation("CollectionLiteralExp", Types._CollectionLiteralPart, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.COLLECTION_LITERAL_EXP__PART));

		public static final @NonNull ExecutorProperty _CollectionRange__first = new EcoreExecutorProperty(PivotPackage.Literals.COLLECTION_RANGE__FIRST, Types._CollectionRange, 0);
		public static final @NonNull ExecutorProperty _CollectionRange__last = new EcoreExecutorProperty(PivotPackage.Literals.COLLECTION_RANGE__LAST, Types._CollectionRange, 1);

		public static final @NonNull ExecutorProperty _CollectionType__elementType = new EcoreExecutorProperty(PivotPackage.Literals.COLLECTION_TYPE__ELEMENT_TYPE, Types._CollectionType, 0);
		public static final @NonNull ExecutorProperty _CollectionType__lower = new EcoreExecutorProperty(PivotPackage.Literals.COLLECTION_TYPE__LOWER, Types._CollectionType, 1);
		public static final @NonNull ExecutorProperty _CollectionType__upper = new EcoreExecutorProperty(PivotPackage.Literals.COLLECTION_TYPE__UPPER, Types._CollectionType, 2);

		public static final @NonNull ExecutorProperty _Comment__Element = new ExecutorPropertyWithImplementation("Element", Types._Comment, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.ELEMENT__OWNED_COMMENT));
		public static final @NonNull ExecutorProperty _Comment__annotatedElement = new EcoreExecutorProperty(PivotPackage.Literals.COMMENT__ANNOTATED_ELEMENT, Types._Comment, 1);
		public static final @NonNull ExecutorProperty _Comment__body = new EcoreExecutorProperty(PivotPackage.Literals.COMMENT__BODY, Types._Comment, 2);

		public static final @NonNull ExecutorProperty _ConnectionPointReference__entry = new EcoreExecutorProperty(PivotPackage.Literals.CONNECTION_POINT_REFERENCE__ENTRY, Types._ConnectionPointReference, 0);
		public static final @NonNull ExecutorProperty _ConnectionPointReference__exit = new EcoreExecutorProperty(PivotPackage.Literals.CONNECTION_POINT_REFERENCE__EXIT, Types._ConnectionPointReference, 1);
		public static final @NonNull ExecutorProperty _ConnectionPointReference__state = new EcoreExecutorProperty(PivotPackage.Literals.CONNECTION_POINT_REFERENCE__STATE, Types._ConnectionPointReference, 2);

		public static final @NonNull ExecutorProperty _Constraint__Namespace = new ExecutorPropertyWithImplementation("Namespace", Types._Constraint, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.NAMESPACE__OWNED_RULE));
		public static final @NonNull ExecutorProperty _Constraint__State = new ExecutorPropertyWithImplementation("State", Types._Constraint, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.STATE__STATE_INVARIANT));
		public static final @NonNull ExecutorProperty _Constraint__Transition = new ExecutorPropertyWithImplementation("Transition", Types._Constraint, 2, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TRANSITION__GUARD));
		public static final @NonNull ExecutorProperty _Constraint__Type = new ExecutorPropertyWithImplementation("Type", Types._Constraint, 3, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TYPE__OWNED_INVARIANT));
		public static final @NonNull ExecutorProperty _Constraint__constrainedElement = new EcoreExecutorProperty(PivotPackage.Literals.CONSTRAINT__CONSTRAINED_ELEMENT, Types._Constraint, 4);
		public static final @NonNull ExecutorProperty _Constraint__context = new EcoreExecutorProperty(PivotPackage.Literals.CONSTRAINT__CONTEXT, Types._Constraint, 5);
		public static final @NonNull ExecutorProperty _Constraint__isCallable = new EcoreExecutorProperty(PivotPackage.Literals.CONSTRAINT__IS_CALLABLE, Types._Constraint, 6);
		public static final @NonNull ExecutorProperty _Constraint__specification = new EcoreExecutorProperty(PivotPackage.Literals.CONSTRAINT__SPECIFICATION, Types._Constraint, 7);

		public static final @NonNull ExecutorProperty _ConstructorExp__part = new EcoreExecutorProperty(PivotPackage.Literals.CONSTRUCTOR_EXP__PART, Types._ConstructorExp, 0);
		public static final @NonNull ExecutorProperty _ConstructorExp__value = new EcoreExecutorProperty(PivotPackage.Literals.CONSTRUCTOR_EXP__VALUE, Types._ConstructorExp, 1);

		public static final @NonNull ExecutorProperty _ConstructorPart__ConstructorExp = new ExecutorPropertyWithImplementation("ConstructorExp", Types._ConstructorPart, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.CONSTRUCTOR_EXP__PART));
		public static final @NonNull ExecutorProperty _ConstructorPart__initExpression = new EcoreExecutorProperty(PivotPackage.Literals.CONSTRUCTOR_PART__INIT_EXPRESSION, Types._ConstructorPart, 1);
		public static final @NonNull ExecutorProperty _ConstructorPart__referredProperty = new EcoreExecutorProperty(PivotPackage.Literals.CONSTRUCTOR_PART__REFERRED_PROPERTY, Types._ConstructorPart, 2);

		public static final @NonNull ExecutorProperty _DataType__behavioralType = new EcoreExecutorProperty(PivotPackage.Literals.DATA_TYPE__BEHAVIORAL_TYPE, Types._DataType, 0);
		public static final @NonNull ExecutorProperty _DataType__isSerializable = new EcoreExecutorProperty(PivotPackage.Literals.DATA_TYPE__IS_SERIALIZABLE, Types._DataType, 1);

		public static final @NonNull ExecutorProperty _Detail__Annotation = new ExecutorPropertyWithImplementation("Annotation", Types._Detail, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.ANNOTATION__OWNED_DETAIL));
		public static final @NonNull ExecutorProperty _Detail__value = new EcoreExecutorProperty(PivotPackage.Literals.DETAIL__VALUE, Types._Detail, 1);

		public static final @NonNull ExecutorProperty _DynamicElement__metaType = new EcoreExecutorProperty(PivotPackage.Literals.DYNAMIC_ELEMENT__META_TYPE, Types._DynamicElement, 0);

		public static final @NonNull ExecutorProperty _DynamicProperty__DynamicType = new ExecutorPropertyWithImplementation("DynamicType", Types._DynamicProperty, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.DYNAMIC_TYPE__OWNED_PROPERTY));
		public static final @NonNull ExecutorProperty _DynamicProperty__default = new EcoreExecutorProperty(PivotPackage.Literals.DYNAMIC_PROPERTY__DEFAULT, Types._DynamicProperty, 1);
		public static final @NonNull ExecutorProperty _DynamicProperty__referredProperty = new EcoreExecutorProperty(PivotPackage.Literals.DYNAMIC_PROPERTY__REFERRED_PROPERTY, Types._DynamicProperty, 2);

		public static final @NonNull ExecutorProperty _DynamicType__ownedProperty = new EcoreExecutorProperty(PivotPackage.Literals.DYNAMIC_TYPE__OWNED_PROPERTY, Types._DynamicType, 0);

		public static final @NonNull ExecutorProperty _Element__Comment = new ExecutorPropertyWithImplementation("Comment", Types._Element, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.COMMENT__ANNOTATED_ELEMENT));
		public static final @NonNull ExecutorProperty _Element__Constraint = new ExecutorPropertyWithImplementation("Constraint", Types._Element, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.CONSTRAINT__CONSTRAINED_ELEMENT));
		public static final @NonNull ExecutorProperty _Element__extension = new EcoreExecutorProperty(PivotPackage.Literals.ELEMENT__EXTENSION, Types._Element, 2);
		public static final @NonNull ExecutorProperty _Element__ownedComment = new EcoreExecutorProperty(PivotPackage.Literals.ELEMENT__OWNED_COMMENT, Types._Element, 3);

		public static final @NonNull ExecutorProperty _ElementExtension__base = new EcoreExecutorProperty(PivotPackage.Literals.ELEMENT_EXTENSION__BASE, Types._ElementExtension, 0);
		public static final @NonNull ExecutorProperty _ElementExtension__stereotype = new EcoreExecutorProperty(PivotPackage.Literals.ELEMENT_EXTENSION__STEREOTYPE, Types._ElementExtension, 1);

		public static final @NonNull ExecutorProperty _EnumLiteralExp__referredEnumLiteral = new EcoreExecutorProperty(PivotPackage.Literals.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL, Types._EnumLiteralExp, 0);

		public static final @NonNull ExecutorProperty _Enumeration__ownedLiteral = new EcoreExecutorProperty(PivotPackage.Literals.ENUMERATION__OWNED_LITERAL, Types._Enumeration, 0);

		public static final @NonNull ExecutorProperty _EnumerationLiteral__EnumLiteralExp = new ExecutorPropertyWithImplementation("EnumLiteralExp", Types._EnumerationLiteral, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL));
		public static final @NonNull ExecutorProperty _EnumerationLiteral__enumeration = new EcoreExecutorProperty(PivotPackage.Literals.ENUMERATION_LITERAL__ENUMERATION, Types._EnumerationLiteral, 1);
		public static final @NonNull ExecutorProperty _EnumerationLiteral__value = new EcoreExecutorProperty(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE, Types._EnumerationLiteral, 2);

		public static final @NonNull ExecutorProperty _ExpressionInOCL__bodyExpression = new EcoreExecutorProperty(PivotPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION, Types._ExpressionInOCL, 0);
		public static final @NonNull ExecutorProperty _ExpressionInOCL__contextVariable = new EcoreExecutorProperty(PivotPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, Types._ExpressionInOCL, 1);
		public static final @NonNull ExecutorProperty _ExpressionInOCL__messageExpression = new EcoreExecutorProperty(PivotPackage.Literals.EXPRESSION_IN_OCL__MESSAGE_EXPRESSION, Types._ExpressionInOCL, 2);
		public static final @NonNull ExecutorProperty _ExpressionInOCL__parameterVariable = new EcoreExecutorProperty(PivotPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE, Types._ExpressionInOCL, 3);
		public static final @NonNull ExecutorProperty _ExpressionInOCL__resultVariable = new EcoreExecutorProperty(PivotPackage.Literals.EXPRESSION_IN_OCL__RESULT_VARIABLE, Types._ExpressionInOCL, 4);

		public static final @NonNull ExecutorProperty _Feature__implementation = new EcoreExecutorProperty(PivotPackage.Literals.FEATURE__IMPLEMENTATION, Types._Feature, 0);
		public static final @NonNull ExecutorProperty _Feature__implementationClass = new EcoreExecutorProperty(PivotPackage.Literals.FEATURE__IMPLEMENTATION_CLASS, Types._Feature, 1);
		public static final @NonNull ExecutorProperty _Feature__isStatic = new EcoreExecutorProperty(PivotPackage.Literals.FEATURE__IS_STATIC, Types._Feature, 2);

		public static final @NonNull ExecutorProperty _FeatureCallExp__isPre = new EcoreExecutorProperty(PivotPackage.Literals.FEATURE_CALL_EXP__IS_PRE, Types._FeatureCallExp, 0);

		public static final @NonNull ExecutorProperty _IfExp__condition = new EcoreExecutorProperty(PivotPackage.Literals.IF_EXP__CONDITION, Types._IfExp, 0);
		public static final @NonNull ExecutorProperty _IfExp__elseExpression = new EcoreExecutorProperty(PivotPackage.Literals.IF_EXP__ELSE_EXPRESSION, Types._IfExp, 1);
		public static final @NonNull ExecutorProperty _IfExp__thenExpression = new EcoreExecutorProperty(PivotPackage.Literals.IF_EXP__THEN_EXPRESSION, Types._IfExp, 2);

		public static final @NonNull ExecutorProperty _Import__Root = new ExecutorPropertyWithImplementation("Root", Types._Import, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.ROOT__IMPORTS));
		public static final @NonNull ExecutorProperty _Import__importedNamespace = new EcoreExecutorProperty(PivotPackage.Literals.IMPORT__IMPORTED_NAMESPACE, Types._Import, 1);

		public static final @NonNull ExecutorProperty _IntegerLiteralExp__integerSymbol = new EcoreExecutorProperty(PivotPackage.Literals.INTEGER_LITERAL_EXP__INTEGER_SYMBOL, Types._IntegerLiteralExp, 0);

		public static final @NonNull ExecutorProperty _IterateExp__result = new EcoreExecutorProperty(PivotPackage.Literals.ITERATE_EXP__RESULT, Types._IterateExp, 0);

		public static final @NonNull ExecutorProperty _Iteration__LoopExp = new ExecutorPropertyWithImplementation("LoopExp", Types._Iteration, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.LOOP_EXP__REFERRED_ITERATION));
		public static final @NonNull ExecutorProperty _Iteration__ownedAccumulator = new EcoreExecutorProperty(PivotPackage.Literals.ITERATION__OWNED_ACCUMULATOR, Types._Iteration, 1);
		public static final @NonNull ExecutorProperty _Iteration__ownedIterator = new EcoreExecutorProperty(PivotPackage.Literals.ITERATION__OWNED_ITERATOR, Types._Iteration, 2);

		public static final @NonNull ExecutorProperty _LambdaType__contextType = new EcoreExecutorProperty(PivotPackage.Literals.LAMBDA_TYPE__CONTEXT_TYPE, Types._LambdaType, 0);
		public static final @NonNull ExecutorProperty _LambdaType__parameterType = new EcoreExecutorProperty(PivotPackage.Literals.LAMBDA_TYPE__PARAMETER_TYPE, Types._LambdaType, 1);
		public static final @NonNull ExecutorProperty _LambdaType__resultType = new EcoreExecutorProperty(PivotPackage.Literals.LAMBDA_TYPE__RESULT_TYPE, Types._LambdaType, 2);

		public static final @NonNull ExecutorProperty _LetExp__in = new EcoreExecutorProperty(PivotPackage.Literals.LET_EXP__IN, Types._LetExp, 0);
		public static final @NonNull ExecutorProperty _LetExp__variable = new EcoreExecutorProperty(PivotPackage.Literals.LET_EXP__VARIABLE, Types._LetExp, 1);

		public static final @NonNull ExecutorProperty _Library__ownedPrecedence = new EcoreExecutorProperty(PivotPackage.Literals.LIBRARY__OWNED_PRECEDENCE, Types._Library, 0);

		public static final @NonNull ExecutorProperty _LoopExp__body = new EcoreExecutorProperty(PivotPackage.Literals.LOOP_EXP__BODY, Types._LoopExp, 0);
		public static final @NonNull ExecutorProperty _LoopExp__iterator = new EcoreExecutorProperty(PivotPackage.Literals.LOOP_EXP__ITERATOR, Types._LoopExp, 1);
		public static final @NonNull ExecutorProperty _LoopExp__referredIteration = new EcoreExecutorProperty(PivotPackage.Literals.LOOP_EXP__REFERRED_ITERATION, Types._LoopExp, 2);

		public static final @NonNull ExecutorProperty _MessageExp__argument = new EcoreExecutorProperty(PivotPackage.Literals.MESSAGE_EXP__ARGUMENT, Types._MessageExp, 0);
		public static final @NonNull ExecutorProperty _MessageExp__calledOperation = new EcoreExecutorProperty(PivotPackage.Literals.MESSAGE_EXP__CALLED_OPERATION, Types._MessageExp, 1);
		public static final @NonNull ExecutorProperty _MessageExp__sentSignal = new EcoreExecutorProperty(PivotPackage.Literals.MESSAGE_EXP__SENT_SIGNAL, Types._MessageExp, 2);
		public static final @NonNull ExecutorProperty _MessageExp__target = new EcoreExecutorProperty(PivotPackage.Literals.MESSAGE_EXP__TARGET, Types._MessageExp, 3);

		public static final @NonNull ExecutorProperty _MessageType__referredOperation = new EcoreExecutorProperty(PivotPackage.Literals.MESSAGE_TYPE__REFERRED_OPERATION, Types._MessageType, 0);
		public static final @NonNull ExecutorProperty _MessageType__referredSignal = new EcoreExecutorProperty(PivotPackage.Literals.MESSAGE_TYPE__REFERRED_SIGNAL, Types._MessageType, 1);

		public static final @NonNull ExecutorProperty _Metaclass__instanceType = new EcoreExecutorProperty(PivotPackage.Literals.METACLASS__INSTANCE_TYPE, Types._Metaclass, 0);

		public static final @NonNull ExecutorProperty _NamedElement__name = new EcoreExecutorProperty(PivotPackage.Literals.NAMED_ELEMENT__NAME, Types._NamedElement, 0);
		public static final @NonNull ExecutorProperty _NamedElement__ownedAnnotation = new EcoreExecutorProperty(PivotPackage.Literals.NAMED_ELEMENT__OWNED_ANNOTATION, Types._NamedElement, 1);

		public static final @NonNull ExecutorProperty _Namespace__Constraint = new ExecutorPropertyWithImplementation("Constraint", Types._Namespace, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.CONSTRAINT__CONTEXT));
		public static final @NonNull ExecutorProperty _Namespace__Import = new ExecutorPropertyWithImplementation("Import", Types._Namespace, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.IMPORT__IMPORTED_NAMESPACE));
		public static final @NonNull ExecutorProperty _Namespace__ownedRule = new EcoreExecutorProperty(PivotPackage.Literals.NAMESPACE__OWNED_RULE, Types._Namespace, 2);

		public static final @NonNull ExecutorProperty _NavigationCallExp__navigationSource = new EcoreExecutorProperty(PivotPackage.Literals.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE, Types._NavigationCallExp, 0);
		public static final @NonNull ExecutorProperty _NavigationCallExp__qualifier = new EcoreExecutorProperty(PivotPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER, Types._NavigationCallExp, 1);

		public static final @NonNull ExecutorProperty _OCLExpression__CallExp = new ExecutorPropertyWithImplementation("CallExp", Types._OCLExpression, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.CALL_EXP__SOURCE));
		public static final @NonNull ExecutorProperty _OCLExpression__CollectionItem = new ExecutorPropertyWithImplementation("CollectionItem", Types._OCLExpression, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.COLLECTION_ITEM__ITEM));
		public static final @NonNull ExecutorProperty _OCLExpression__ConstructorPart = new ExecutorPropertyWithImplementation("ConstructorPart", Types._OCLExpression, 2, new EcoreLibraryOppositeProperty(PivotPackage.Literals.CONSTRUCTOR_PART__INIT_EXPRESSION));
		public static final @NonNull ExecutorProperty _OCLExpression__LetExp = new ExecutorPropertyWithImplementation("LetExp", Types._OCLExpression, 3, new EcoreLibraryOppositeProperty(PivotPackage.Literals.LET_EXP__IN));
		public static final @NonNull ExecutorProperty _OCLExpression__LoopExp = new ExecutorPropertyWithImplementation("LoopExp", Types._OCLExpression, 4, new EcoreLibraryOppositeProperty(PivotPackage.Literals.LOOP_EXP__BODY));
		public static final @NonNull ExecutorProperty _OCLExpression__NavigationCallExp = new ExecutorPropertyWithImplementation("NavigationCallExp", Types._OCLExpression, 5, new EcoreLibraryOppositeProperty(PivotPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER));
		public static final @NonNull ExecutorProperty _OCLExpression__OperationCallExp = new ExecutorPropertyWithImplementation("OperationCallExp", Types._OCLExpression, 6, new EcoreLibraryOppositeProperty(PivotPackage.Literals.OPERATION_CALL_EXP__ARGUMENT));
		public static final @NonNull ExecutorProperty _OCLExpression__TupleLiteralPart = new ExecutorPropertyWithImplementation("TupleLiteralPart", Types._OCLExpression, 7, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TUPLE_LITERAL_PART__INIT_EXPRESSION));
		public static final @NonNull ExecutorProperty _OCLExpression__Variable = new ExecutorPropertyWithImplementation("Variable", Types._OCLExpression, 8, new EcoreLibraryOppositeProperty(PivotPackage.Literals.VARIABLE__INIT_EXPRESSION));

		public static final @NonNull ExecutorProperty _OpaqueExpression__Constraint = new ExecutorPropertyWithImplementation("Constraint", Types._OpaqueExpression, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.CONSTRAINT__SPECIFICATION));
		public static final @NonNull ExecutorProperty _OpaqueExpression__Operation = new ExecutorPropertyWithImplementation("Operation", Types._OpaqueExpression, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.OPERATION__BODY_EXPRESSION));
		public static final @NonNull ExecutorProperty _OpaqueExpression__Property = new ExecutorPropertyWithImplementation("Property", Types._OpaqueExpression, 2, new EcoreLibraryOppositeProperty(PivotPackage.Literals.PROPERTY__DEFAULT_EXPRESSION));
		public static final @NonNull ExecutorProperty _OpaqueExpression__body = new EcoreExecutorProperty(PivotPackage.Literals.OPAQUE_EXPRESSION__BODY, Types._OpaqueExpression, 3);
		public static final @NonNull ExecutorProperty _OpaqueExpression__language = new EcoreExecutorProperty(PivotPackage.Literals.OPAQUE_EXPRESSION__LANGUAGE, Types._OpaqueExpression, 4);
		public static final @NonNull ExecutorProperty _OpaqueExpression__message = new EcoreExecutorProperty(PivotPackage.Literals.OPAQUE_EXPRESSION__MESSAGE, Types._OpaqueExpression, 5);

		public static final @NonNull ExecutorProperty _Operation__CallOperationAction = new ExecutorPropertyWithImplementation("CallOperationAction", Types._Operation, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.CALL_OPERATION_ACTION__OPERATION));
		public static final @NonNull ExecutorProperty _Operation__MessageType = new ExecutorPropertyWithImplementation("MessageType", Types._Operation, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.MESSAGE_TYPE__REFERRED_OPERATION));
		public static final @NonNull ExecutorProperty _Operation__Operation = new ExecutorPropertyWithImplementation("Operation", Types._Operation, 2, new EcoreLibraryOppositeProperty(PivotPackage.Literals.OPERATION__REDEFINED_OPERATION));
		public static final @NonNull ExecutorProperty _Operation__OperationCallExp = new ExecutorPropertyWithImplementation("OperationCallExp", Types._Operation, 3, new EcoreLibraryOppositeProperty(PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION));
		public static final @NonNull ExecutorProperty _Operation__bodyExpression = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION__BODY_EXPRESSION, Types._Operation, 4);
		public static final @NonNull ExecutorProperty _Operation__class = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION__CLASS, Types._Operation, 5);
		public static final @NonNull ExecutorProperty _Operation__isInvalidating = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION__IS_INVALIDATING, Types._Operation, 6);
		public static final @NonNull ExecutorProperty _Operation__isValidating = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION__IS_VALIDATING, Types._Operation, 7);
		public static final @NonNull ExecutorProperty _Operation__ownedParameter = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION__OWNED_PARAMETER, Types._Operation, 8);
		public static final @NonNull ExecutorProperty _Operation__owningType = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION__OWNING_TYPE, Types._Operation, 9);
		public static final @NonNull ExecutorProperty _Operation__postcondition = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION__POSTCONDITION, Types._Operation, 10);
		public static final @NonNull ExecutorProperty _Operation__precedence = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION__PRECEDENCE, Types._Operation, 11);
		public static final @NonNull ExecutorProperty _Operation__precondition = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION__PRECONDITION, Types._Operation, 12);
		public static final @NonNull ExecutorProperty _Operation__raisedException = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION__RAISED_EXCEPTION, Types._Operation, 13);
		public static final @NonNull ExecutorProperty _Operation__redefinedOperation = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION__REDEFINED_OPERATION, Types._Operation, 14);

		public static final @NonNull ExecutorProperty _OperationCallExp__argument = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION_CALL_EXP__ARGUMENT, Types._OperationCallExp, 0);
		public static final @NonNull ExecutorProperty _OperationCallExp__referredOperation = new EcoreExecutorProperty(PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, Types._OperationCallExp, 1);

		public static final @NonNull ExecutorProperty _Package__Package = new ExecutorPropertyWithImplementation("Package", Types._Package, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.PACKAGE__IMPORTED_PACKAGE));
		public static final @NonNull ExecutorProperty _Package__Root = new ExecutorPropertyWithImplementation("Root", Types._Package, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.ROOT__NESTED_PACKAGE));
		public static final @NonNull ExecutorProperty _Package__importedPackage = new EcoreExecutorProperty(PivotPackage.Literals.PACKAGE__IMPORTED_PACKAGE, Types._Package, 2);
		public static final @NonNull ExecutorProperty _Package__nestedPackage = new EcoreExecutorProperty(PivotPackage.Literals.PACKAGE__NESTED_PACKAGE, Types._Package, 3);
		public static final @NonNull ExecutorProperty _Package__nestingPackage = new EcoreExecutorProperty(PivotPackage.Literals.PACKAGE__NESTING_PACKAGE, Types._Package, 4);
		public static final @NonNull ExecutorProperty _Package__nsPrefix = new EcoreExecutorProperty(PivotPackage.Literals.PACKAGE__NS_PREFIX, Types._Package, 5);
		public static final @NonNull ExecutorProperty _Package__nsURI = new EcoreExecutorProperty(PivotPackage.Literals.PACKAGE__NS_URI, Types._Package, 6);
		public static final @NonNull ExecutorProperty _Package__ownedType = new EcoreExecutorProperty(PivotPackage.Literals.PACKAGE__OWNED_TYPE, Types._Package, 7);

		public static final @NonNull ExecutorProperty _Parameter__Variable = new ExecutorPropertyWithImplementation("Variable", Types._Parameter, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.VARIABLE__REPRESENTED_PARAMETER));
		public static final @NonNull ExecutorProperty _Parameter__operation = new EcoreExecutorProperty(PivotPackage.Literals.PARAMETER__OPERATION, Types._Parameter, 1);

		public static final @NonNull ExecutorProperty _ParameterableElement__owningTemplateParameter = new EcoreExecutorProperty(PivotPackage.Literals.PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER, Types._ParameterableElement, 0);
		public static final @NonNull ExecutorProperty _ParameterableElement__templateParameter = new EcoreExecutorProperty(PivotPackage.Literals.PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER, Types._ParameterableElement, 1);

		public static final @NonNull ExecutorProperty _Precedence__Library = new ExecutorPropertyWithImplementation("Library", Types._Precedence, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.LIBRARY__OWNED_PRECEDENCE));
		public static final @NonNull ExecutorProperty _Precedence__Operation = new ExecutorPropertyWithImplementation("Operation", Types._Precedence, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.OPERATION__PRECEDENCE));
		public static final @NonNull ExecutorProperty _Precedence__associativity = new EcoreExecutorProperty(PivotPackage.Literals.PRECEDENCE__ASSOCIATIVITY, Types._Precedence, 2);
		public static final @NonNull ExecutorProperty _Precedence__order = new EcoreExecutorProperty(PivotPackage.Literals.PRECEDENCE__ORDER, Types._Precedence, 3);

		public static final @NonNull ExecutorProperty _Profile__Stereotype = new ExecutorPropertyWithImplementation("Stereotype", Types._Profile, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.STEREOTYPE__PROFILE));

		public static final @NonNull ExecutorProperty _Property__ConstructorPart = new ExecutorPropertyWithImplementation("ConstructorPart", Types._Property, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.CONSTRUCTOR_PART__REFERRED_PROPERTY));
		public static final @NonNull ExecutorProperty _Property__DynamicProperty = new ExecutorPropertyWithImplementation("DynamicProperty", Types._Property, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.DYNAMIC_PROPERTY__REFERRED_PROPERTY));
		public static final @NonNull ExecutorProperty _Property__NavigationCallExp = new ExecutorPropertyWithImplementation("NavigationCallExp", Types._Property, 2, new EcoreLibraryOppositeProperty(PivotPackage.Literals.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE));
		public static final @NonNull ExecutorProperty _Property__PropertyCallExp = new ExecutorPropertyWithImplementation("PropertyCallExp", Types._Property, 3, new EcoreLibraryOppositeProperty(PivotPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY));
		public static final @NonNull ExecutorProperty _Property__association = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__ASSOCIATION, Types._Property, 4);
		public static final @NonNull ExecutorProperty _Property__class = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__CLASS, Types._Property, 5);
		public static final @NonNull ExecutorProperty _Property__default = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__DEFAULT, Types._Property, 6);
		public static final @NonNull ExecutorProperty _Property__defaultExpression = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__DEFAULT_EXPRESSION, Types._Property, 7);
		public static final @NonNull ExecutorProperty _Property__implicit = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__IMPLICIT, Types._Property, 8);
		public static final @NonNull ExecutorProperty _Property__isComposite = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__IS_COMPOSITE, Types._Property, 9);
		public static final @NonNull ExecutorProperty _Property__isDerived = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__IS_DERIVED, Types._Property, 10);
		public static final @NonNull ExecutorProperty _Property__isID = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__IS_ID, Types._Property, 11);
		public static final @NonNull ExecutorProperty _Property__isReadOnly = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__IS_READ_ONLY, Types._Property, 12);
		public static final @NonNull ExecutorProperty _Property__isResolveProxies = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__IS_RESOLVE_PROXIES, Types._Property, 13);
		public static final @NonNull ExecutorProperty _Property__isTransient = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__IS_TRANSIENT, Types._Property, 14);
		public static final @NonNull ExecutorProperty _Property__isUnsettable = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__IS_UNSETTABLE, Types._Property, 15);
		public static final @NonNull ExecutorProperty _Property__isVolatile = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__IS_VOLATILE, Types._Property, 16);
		public static final @NonNull ExecutorProperty _Property__keys = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__KEYS, Types._Property, 17);
		public static final @NonNull ExecutorProperty _Property__opposite = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__OPPOSITE, Types._Property, 18);
		public static final @NonNull ExecutorProperty _Property__owningType = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__OWNING_TYPE, Types._Property, 19);
		public static final @NonNull ExecutorProperty _Property__redefinedProperty = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__REDEFINED_PROPERTY, Types._Property, 20);
		public static final @NonNull ExecutorProperty _Property__referredProperty = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__REFERRED_PROPERTY, Types._Property, 21);
		public static final @NonNull ExecutorProperty _Property__subsettedProperty = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY__SUBSETTED_PROPERTY, Types._Property, 22);

		public static final @NonNull ExecutorProperty _PropertyCallExp__referredProperty = new EcoreExecutorProperty(PivotPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, Types._PropertyCallExp, 0);

		public static final @NonNull ExecutorProperty _Pseudostate__kind = new EcoreExecutorProperty(PivotPackage.Literals.PSEUDOSTATE__KIND, Types._Pseudostate, 0);
		public static final @NonNull ExecutorProperty _Pseudostate__state = new EcoreExecutorProperty(PivotPackage.Literals.PSEUDOSTATE__STATE, Types._Pseudostate, 1);
		public static final @NonNull ExecutorProperty _Pseudostate__stateMachine = new EcoreExecutorProperty(PivotPackage.Literals.PSEUDOSTATE__STATE_MACHINE, Types._Pseudostate, 2);

		public static final @NonNull ExecutorProperty _RealLiteralExp__realSymbol = new EcoreExecutorProperty(PivotPackage.Literals.REAL_LITERAL_EXP__REAL_SYMBOL, Types._RealLiteralExp, 0);

		public static final @NonNull ExecutorProperty _Region__Region = new ExecutorPropertyWithImplementation("Region", Types._Region, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.REGION__EXTENDED_REGION));
		public static final @NonNull ExecutorProperty _Region__extendedRegion = new EcoreExecutorProperty(PivotPackage.Literals.REGION__EXTENDED_REGION, Types._Region, 1);
		public static final @NonNull ExecutorProperty _Region__state = new EcoreExecutorProperty(PivotPackage.Literals.REGION__STATE, Types._Region, 2);
		public static final @NonNull ExecutorProperty _Region__stateMachine = new EcoreExecutorProperty(PivotPackage.Literals.REGION__STATE_MACHINE, Types._Region, 3);
		public static final @NonNull ExecutorProperty _Region__subvertex = new EcoreExecutorProperty(PivotPackage.Literals.REGION__SUBVERTEX, Types._Region, 4);
		public static final @NonNull ExecutorProperty _Region__transition = new EcoreExecutorProperty(PivotPackage.Literals.REGION__TRANSITION, Types._Region, 5);

		public static final @NonNull ExecutorProperty _Root__externalURI = new EcoreExecutorProperty(PivotPackage.Literals.ROOT__EXTERNAL_URI, Types._Root, 0);
		public static final @NonNull ExecutorProperty _Root__imports = new EcoreExecutorProperty(PivotPackage.Literals.ROOT__IMPORTS, Types._Root, 1);
		public static final @NonNull ExecutorProperty _Root__nestedPackage = new EcoreExecutorProperty(PivotPackage.Literals.ROOT__NESTED_PACKAGE, Types._Root, 2);

		public static final @NonNull ExecutorProperty _SendSignalAction__MessageExp = new ExecutorPropertyWithImplementation("MessageExp", Types._SendSignalAction, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.MESSAGE_EXP__SENT_SIGNAL));
		public static final @NonNull ExecutorProperty _SendSignalAction__signal = new EcoreExecutorProperty(PivotPackage.Literals.SEND_SIGNAL_ACTION__SIGNAL, Types._SendSignalAction, 1);

		public static final @NonNull ExecutorProperty _Signal__MessageType = new ExecutorPropertyWithImplementation("MessageType", Types._Signal, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.MESSAGE_TYPE__REFERRED_SIGNAL));
		public static final @NonNull ExecutorProperty _Signal__SendSignalAction = new ExecutorPropertyWithImplementation("SendSignalAction", Types._Signal, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.SEND_SIGNAL_ACTION__SIGNAL));

		public static final @NonNull ExecutorProperty _State__State = new ExecutorPropertyWithImplementation("State", Types._State, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.STATE__REDEFINED_STATE));
		public static final @NonNull ExecutorProperty _State__StateExp = new ExecutorPropertyWithImplementation("StateExp", Types._State, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.STATE_EXP__REFERRED_STATE));
		public static final @NonNull ExecutorProperty _State__connection = new EcoreExecutorProperty(PivotPackage.Literals.STATE__CONNECTION, Types._State, 2);
		public static final @NonNull ExecutorProperty _State__connectionPoint = new EcoreExecutorProperty(PivotPackage.Literals.STATE__CONNECTION_POINT, Types._State, 3);
		public static final @NonNull ExecutorProperty _State__deferrableTrigger = new EcoreExecutorProperty(PivotPackage.Literals.STATE__DEFERRABLE_TRIGGER, Types._State, 4);
		public static final @NonNull ExecutorProperty _State__doActivity = new EcoreExecutorProperty(PivotPackage.Literals.STATE__DO_ACTIVITY, Types._State, 5);
		public static final @NonNull ExecutorProperty _State__entry = new EcoreExecutorProperty(PivotPackage.Literals.STATE__ENTRY, Types._State, 6);
		public static final @NonNull ExecutorProperty _State__exit = new EcoreExecutorProperty(PivotPackage.Literals.STATE__EXIT, Types._State, 7);
		public static final @NonNull ExecutorProperty _State__isComposite = new EcoreExecutorProperty(PivotPackage.Literals.STATE__IS_COMPOSITE, Types._State, 8);
		public static final @NonNull ExecutorProperty _State__isOrthogonal = new EcoreExecutorProperty(PivotPackage.Literals.STATE__IS_ORTHOGONAL, Types._State, 9);
		public static final @NonNull ExecutorProperty _State__isSimple = new EcoreExecutorProperty(PivotPackage.Literals.STATE__IS_SIMPLE, Types._State, 10);
		public static final @NonNull ExecutorProperty _State__isSubmachineState = new EcoreExecutorProperty(PivotPackage.Literals.STATE__IS_SUBMACHINE_STATE, Types._State, 11);
		public static final @NonNull ExecutorProperty _State__redefinedState = new EcoreExecutorProperty(PivotPackage.Literals.STATE__REDEFINED_STATE, Types._State, 12);
		public static final @NonNull ExecutorProperty _State__region = new EcoreExecutorProperty(PivotPackage.Literals.STATE__REGION, Types._State, 13);
		public static final @NonNull ExecutorProperty _State__stateInvariant = new EcoreExecutorProperty(PivotPackage.Literals.STATE__STATE_INVARIANT, Types._State, 14);
		public static final @NonNull ExecutorProperty _State__submachine = new EcoreExecutorProperty(PivotPackage.Literals.STATE__SUBMACHINE, Types._State, 15);

		public static final @NonNull ExecutorProperty _StateExp__referredState = new EcoreExecutorProperty(PivotPackage.Literals.STATE_EXP__REFERRED_STATE, Types._StateExp, 0);

		public static final @NonNull ExecutorProperty _StateMachine__StateMachine = new ExecutorPropertyWithImplementation("StateMachine", Types._StateMachine, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.STATE_MACHINE__EXTENDED_STATE_MACHINE));
		public static final @NonNull ExecutorProperty _StateMachine__connectionPoint = new EcoreExecutorProperty(PivotPackage.Literals.STATE_MACHINE__CONNECTION_POINT, Types._StateMachine, 1);
		public static final @NonNull ExecutorProperty _StateMachine__extendedStateMachine = new EcoreExecutorProperty(PivotPackage.Literals.STATE_MACHINE__EXTENDED_STATE_MACHINE, Types._StateMachine, 2);
		public static final @NonNull ExecutorProperty _StateMachine__region = new EcoreExecutorProperty(PivotPackage.Literals.STATE_MACHINE__REGION, Types._StateMachine, 3);
		public static final @NonNull ExecutorProperty _StateMachine__submachineState = new EcoreExecutorProperty(PivotPackage.Literals.STATE_MACHINE__SUBMACHINE_STATE, Types._StateMachine, 4);

		public static final @NonNull ExecutorProperty _Stereotype__profile = new EcoreExecutorProperty(PivotPackage.Literals.STEREOTYPE__PROFILE, Types._Stereotype, 0);

		public static final @NonNull ExecutorProperty _StringLiteralExp__stringSymbol = new EcoreExecutorProperty(PivotPackage.Literals.STRING_LITERAL_EXP__STRING_SYMBOL, Types._StringLiteralExp, 0);

		public static final @NonNull ExecutorProperty _TemplateBinding__boundElement = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_BINDING__BOUND_ELEMENT, Types._TemplateBinding, 0);
		public static final @NonNull ExecutorProperty _TemplateBinding__parameterSubstitution = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_BINDING__PARAMETER_SUBSTITUTION, Types._TemplateBinding, 1);
		public static final @NonNull ExecutorProperty _TemplateBinding__signature = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_BINDING__SIGNATURE, Types._TemplateBinding, 2);

		public static final @NonNull ExecutorProperty _TemplateParameter__TemplateParameterSubstitution = new ExecutorPropertyWithImplementation("TemplateParameterSubstitution", Types._TemplateParameter, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL));
		public static final @NonNull ExecutorProperty _TemplateParameter__TemplateSignature = new ExecutorPropertyWithImplementation("TemplateSignature", Types._TemplateParameter, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TEMPLATE_SIGNATURE__PARAMETER));
		public static final @NonNull ExecutorProperty _TemplateParameter__default = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_PARAMETER__DEFAULT, Types._TemplateParameter, 2);
		public static final @NonNull ExecutorProperty _TemplateParameter__ownedDefault = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_PARAMETER__OWNED_DEFAULT, Types._TemplateParameter, 3);
		public static final @NonNull ExecutorProperty _TemplateParameter__ownedParameteredElement = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT, Types._TemplateParameter, 4);
		public static final @NonNull ExecutorProperty _TemplateParameter__parameteredElement = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, Types._TemplateParameter, 5);
		public static final @NonNull ExecutorProperty _TemplateParameter__signature = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_PARAMETER__SIGNATURE, Types._TemplateParameter, 6);

		public static final @NonNull ExecutorProperty _TemplateParameterSubstitution__actual = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION__ACTUAL, Types._TemplateParameterSubstitution, 0);
		public static final @NonNull ExecutorProperty _TemplateParameterSubstitution__formal = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL, Types._TemplateParameterSubstitution, 1);
		public static final @NonNull ExecutorProperty _TemplateParameterSubstitution__ownedActual = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL, Types._TemplateParameterSubstitution, 2);
		public static final @NonNull ExecutorProperty _TemplateParameterSubstitution__templateBinding = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING, Types._TemplateParameterSubstitution, 3);

		public static final @NonNull ExecutorProperty _TemplateParameterType__specification = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_PARAMETER_TYPE__SPECIFICATION, Types._TemplateParameterType, 0);

		public static final @NonNull ExecutorProperty _TemplateSignature__TemplateBinding = new ExecutorPropertyWithImplementation("TemplateBinding", Types._TemplateSignature, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TEMPLATE_BINDING__SIGNATURE));
		public static final @NonNull ExecutorProperty _TemplateSignature__ownedParameter = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_SIGNATURE__OWNED_PARAMETER, Types._TemplateSignature, 1);
		public static final @NonNull ExecutorProperty _TemplateSignature__parameter = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_SIGNATURE__PARAMETER, Types._TemplateSignature, 2);
		public static final @NonNull ExecutorProperty _TemplateSignature__template = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATE_SIGNATURE__TEMPLATE, Types._TemplateSignature, 3);

		public static final @NonNull ExecutorProperty _TemplateableElement__ownedTemplateSignature = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE, Types._TemplateableElement, 0);
		public static final @NonNull ExecutorProperty _TemplateableElement__templateBinding = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATEABLE_ELEMENT__TEMPLATE_BINDING, Types._TemplateableElement, 1);
		public static final @NonNull ExecutorProperty _TemplateableElement__unspecializedElement = new EcoreExecutorProperty(PivotPackage.Literals.TEMPLATEABLE_ELEMENT__UNSPECIALIZED_ELEMENT, Types._TemplateableElement, 2);

		public static final @NonNull ExecutorProperty _Transition__container = new EcoreExecutorProperty(PivotPackage.Literals.TRANSITION__CONTAINER, Types._Transition, 0);
		public static final @NonNull ExecutorProperty _Transition__effect = new EcoreExecutorProperty(PivotPackage.Literals.TRANSITION__EFFECT, Types._Transition, 1);
		public static final @NonNull ExecutorProperty _Transition__guard = new EcoreExecutorProperty(PivotPackage.Literals.TRANSITION__GUARD, Types._Transition, 2);
		public static final @NonNull ExecutorProperty _Transition__kind = new EcoreExecutorProperty(PivotPackage.Literals.TRANSITION__KIND, Types._Transition, 3);
		public static final @NonNull ExecutorProperty _Transition__source = new EcoreExecutorProperty(PivotPackage.Literals.TRANSITION__SOURCE, Types._Transition, 4);
		public static final @NonNull ExecutorProperty _Transition__target = new EcoreExecutorProperty(PivotPackage.Literals.TRANSITION__TARGET, Types._Transition, 5);
		public static final @NonNull ExecutorProperty _Transition__trigger = new EcoreExecutorProperty(PivotPackage.Literals.TRANSITION__TRIGGER, Types._Transition, 6);

		public static final @NonNull ExecutorProperty _Trigger__State = new ExecutorPropertyWithImplementation("State", Types._Trigger, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.STATE__DEFERRABLE_TRIGGER));
		public static final @NonNull ExecutorProperty _Trigger__Transition = new ExecutorPropertyWithImplementation("Transition", Types._Trigger, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TRANSITION__TRIGGER));

		public static final @NonNull ExecutorProperty _TupleLiteralExp__part = new EcoreExecutorProperty(PivotPackage.Literals.TUPLE_LITERAL_EXP__PART, Types._TupleLiteralExp, 0);

		public static final @NonNull ExecutorProperty _TupleLiteralPart__TupleLiteralExp = new ExecutorPropertyWithImplementation("TupleLiteralExp", Types._TupleLiteralPart, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TUPLE_LITERAL_EXP__PART));
		public static final @NonNull ExecutorProperty _TupleLiteralPart__initExpression = new EcoreExecutorProperty(PivotPackage.Literals.TUPLE_LITERAL_PART__INIT_EXPRESSION, Types._TupleLiteralPart, 1);

		public static final @NonNull ExecutorProperty _Type__CollectionType = new ExecutorPropertyWithImplementation("CollectionType", Types._Type, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.COLLECTION_TYPE__ELEMENT_TYPE));
		public static final @NonNull ExecutorProperty _Type__DataType = new ExecutorPropertyWithImplementation("DataType", Types._Type, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.DATA_TYPE__BEHAVIORAL_TYPE));
		public static final @NonNull ExecutorProperty _Type__DynamicElement = new ExecutorPropertyWithImplementation("DynamicElement", Types._Type, 2, new EcoreLibraryOppositeProperty(PivotPackage.Literals.DYNAMIC_ELEMENT__META_TYPE));
		public static final @NonNull ExecutorProperty _Type__ElementExtension = new ExecutorPropertyWithImplementation("ElementExtension", Types._Type, 3, new EcoreLibraryOppositeProperty(PivotPackage.Literals.ELEMENT_EXTENSION__STEREOTYPE));
		public static final @NonNull ExecutorProperty _Type__Metaclass = new ExecutorPropertyWithImplementation("Metaclass", Types._Type, 4, new EcoreLibraryOppositeProperty(PivotPackage.Literals.METACLASS__INSTANCE_TYPE));
		public static final @NonNull ExecutorProperty _Type__Operation = new ExecutorPropertyWithImplementation("Operation", Types._Type, 5, new EcoreLibraryOppositeProperty(PivotPackage.Literals.OPERATION__RAISED_EXCEPTION));
		public static final @NonNull ExecutorProperty _Type__Type = new ExecutorPropertyWithImplementation("Type", Types._Type, 6, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TYPE__SUPER_CLASS));
		public static final @NonNull ExecutorProperty _Type__TypeExp = new ExecutorPropertyWithImplementation("TypeExp", Types._Type, 7, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TYPE_EXP__REFERRED_TYPE));
		public static final @NonNull ExecutorProperty _Type__TypedElement = new ExecutorPropertyWithImplementation("TypedElement", Types._Type, 8, new EcoreLibraryOppositeProperty(PivotPackage.Literals.TYPED_ELEMENT__TYPE));
		public static final @NonNull ExecutorProperty _Type__instanceClassName = new EcoreExecutorProperty(PivotPackage.Literals.TYPE__INSTANCE_CLASS_NAME, Types._Type, 9);
		public static final @NonNull ExecutorProperty _Type__ownedAttribute = new EcoreExecutorProperty(PivotPackage.Literals.TYPE__OWNED_ATTRIBUTE, Types._Type, 10);
		public static final @NonNull ExecutorProperty _Type__ownedInvariant = new EcoreExecutorProperty(PivotPackage.Literals.TYPE__OWNED_INVARIANT, Types._Type, 11);
		public static final @NonNull ExecutorProperty _Type__ownedOperation = new EcoreExecutorProperty(PivotPackage.Literals.TYPE__OWNED_OPERATION, Types._Type, 12);
		public static final @NonNull ExecutorProperty _Type__package = new EcoreExecutorProperty(PivotPackage.Literals.TYPE__PACKAGE, Types._Type, 13);
		public static final @NonNull ExecutorProperty _Type__superClass = new EcoreExecutorProperty(PivotPackage.Literals.TYPE__SUPER_CLASS, Types._Type, 14);

		public static final @NonNull ExecutorProperty _TypeExp__referredType = new EcoreExecutorProperty(PivotPackage.Literals.TYPE_EXP__REFERRED_TYPE, Types._TypeExp, 0);

		public static final @NonNull ExecutorProperty _TypeTemplateParameter__allowSubstitutable = new EcoreExecutorProperty(PivotPackage.Literals.TYPE_TEMPLATE_PARAMETER__ALLOW_SUBSTITUTABLE, Types._TypeTemplateParameter, 0);
		public static final @NonNull ExecutorProperty _TypeTemplateParameter__constrainingClassifier = new EcoreExecutorProperty(PivotPackage.Literals.TYPE_TEMPLATE_PARAMETER__CONSTRAINING_CLASSIFIER, Types._TypeTemplateParameter, 1);

		public static final @NonNull ExecutorProperty _TypedElement__isRequired = new EcoreExecutorProperty(PivotPackage.Literals.TYPED_ELEMENT__IS_REQUIRED, Types._TypedElement, 0);
		public static final @NonNull ExecutorProperty _TypedElement__type = new EcoreExecutorProperty(PivotPackage.Literals.TYPED_ELEMENT__TYPE, Types._TypedElement, 1);

		public static final @NonNull ExecutorProperty _UnlimitedNaturalLiteralExp__unlimitedNaturalSymbol = new EcoreExecutorProperty(PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED_NATURAL_SYMBOL, Types._UnlimitedNaturalLiteralExp, 0);

		public static final @NonNull ExecutorProperty _UnspecifiedType__lowerBound = new EcoreExecutorProperty(PivotPackage.Literals.UNSPECIFIED_TYPE__LOWER_BOUND, Types._UnspecifiedType, 0);
		public static final @NonNull ExecutorProperty _UnspecifiedType__upperBound = new EcoreExecutorProperty(PivotPackage.Literals.UNSPECIFIED_TYPE__UPPER_BOUND, Types._UnspecifiedType, 1);

		public static final @NonNull ExecutorProperty _Variable__IterateExp = new ExecutorPropertyWithImplementation("IterateExp", Types._Variable, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.ITERATE_EXP__RESULT));
		public static final @NonNull ExecutorProperty _Variable__LetExp = new ExecutorPropertyWithImplementation("LetExp", Types._Variable, 1, new EcoreLibraryOppositeProperty(PivotPackage.Literals.LET_EXP__VARIABLE));
		public static final @NonNull ExecutorProperty _Variable__LoopExp = new ExecutorPropertyWithImplementation("LoopExp", Types._Variable, 2, new EcoreLibraryOppositeProperty(PivotPackage.Literals.LOOP_EXP__ITERATOR));
		public static final @NonNull ExecutorProperty _Variable__implicit = new EcoreExecutorProperty(PivotPackage.Literals.VARIABLE__IMPLICIT, Types._Variable, 3);
		public static final @NonNull ExecutorProperty _Variable__initExpression = new EcoreExecutorProperty(PivotPackage.Literals.VARIABLE__INIT_EXPRESSION, Types._Variable, 4);
		public static final @NonNull ExecutorProperty _Variable__representedParameter = new EcoreExecutorProperty(PivotPackage.Literals.VARIABLE__REPRESENTED_PARAMETER, Types._Variable, 5);

		public static final @NonNull ExecutorProperty _VariableDeclaration__VariableExp = new ExecutorPropertyWithImplementation("VariableExp", Types._VariableDeclaration, 0, new EcoreLibraryOppositeProperty(PivotPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE));

		public static final @NonNull ExecutorProperty _VariableExp__implicit = new EcoreExecutorProperty(PivotPackage.Literals.VARIABLE_EXP__IMPLICIT, Types._VariableExp, 0);
		public static final @NonNull ExecutorProperty _VariableExp__referredVariable = new EcoreExecutorProperty(PivotPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE, Types._VariableExp, 1);

		public static final @NonNull ExecutorProperty _Vertex__container = new EcoreExecutorProperty(PivotPackage.Literals.VERTEX__CONTAINER, Types._Vertex, 0);
		public static final @NonNull ExecutorProperty _Vertex__incoming = new EcoreExecutorProperty(PivotPackage.Literals.VERTEX__INCOMING, Types._Vertex, 1);
		public static final @NonNull ExecutorProperty _Vertex__outgoing = new EcoreExecutorProperty(PivotPackage.Literals.VERTEX__OUTGOING, Types._Vertex, 2);
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		private static final @NonNull ExecutorFragment[] _Annotation =
		{
			Fragments._Annotation__OclAny /* 0 */,
			Fragments._Annotation__OclElement /* 1 */,
			Fragments._Annotation__Nameable /* 2 */,
			Fragments._Annotation__Visitable /* 2 */,
			Fragments._Annotation__Element /* 3 */,
			Fragments._Annotation__NamedElement /* 4 */,
			Fragments._Annotation__Annotation /* 5 */
		};
		private static final @NonNull int[] __Annotation = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _AnyType =
		{
			Fragments._AnyType__OclAny /* 0 */,
			Fragments._AnyType__OclElement /* 1 */,
			Fragments._AnyType__Nameable /* 2 */,
			Fragments._AnyType__OclType /* 2 */,
			Fragments._AnyType__Visitable /* 2 */,
			Fragments._AnyType__Element /* 3 */,
			Fragments._AnyType__NamedElement /* 4 */,
			Fragments._AnyType__ParameterableElement /* 4 */,
			Fragments._AnyType__TemplateableElement /* 4 */,
			Fragments._AnyType__Namespace /* 5 */,
			Fragments._AnyType__PackageableElement /* 5 */,
			Fragments._AnyType__Type /* 6 */,
			Fragments._AnyType__Class /* 7 */,
			Fragments._AnyType__AnyType /* 8 */
		};
		private static final @NonNull int[] __AnyType = { 1,1,3,1,3,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _AssociationClass =
		{
			Fragments._AssociationClass__OclAny /* 0 */,
			Fragments._AssociationClass__OclElement /* 1 */,
			Fragments._AssociationClass__Nameable /* 2 */,
			Fragments._AssociationClass__OclType /* 2 */,
			Fragments._AssociationClass__Visitable /* 2 */,
			Fragments._AssociationClass__Element /* 3 */,
			Fragments._AssociationClass__NamedElement /* 4 */,
			Fragments._AssociationClass__ParameterableElement /* 4 */,
			Fragments._AssociationClass__TemplateableElement /* 4 */,
			Fragments._AssociationClass__Namespace /* 5 */,
			Fragments._AssociationClass__PackageableElement /* 5 */,
			Fragments._AssociationClass__Type /* 6 */,
			Fragments._AssociationClass__Class /* 7 */,
			Fragments._AssociationClass__AssociationClass /* 8 */
		};
		private static final @NonNull int[] __AssociationClass = { 1,1,3,1,3,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _AssociationClassCallExp =
		{
			Fragments._AssociationClassCallExp__OclAny /* 0 */,
			Fragments._AssociationClassCallExp__OclElement /* 1 */,
			Fragments._AssociationClassCallExp__Nameable /* 2 */,
			Fragments._AssociationClassCallExp__Visitable /* 2 */,
			Fragments._AssociationClassCallExp__Element /* 3 */,
			Fragments._AssociationClassCallExp__NamedElement /* 4 */,
			Fragments._AssociationClassCallExp__TypedElement /* 5 */,
			Fragments._AssociationClassCallExp__OCLExpression /* 6 */,
			Fragments._AssociationClassCallExp__CallExp /* 7 */,
			Fragments._AssociationClassCallExp__FeatureCallExp /* 8 */,
			Fragments._AssociationClassCallExp__NavigationCallExp /* 9 */,
			Fragments._AssociationClassCallExp__AssociationClassCallExp /* 10 */
		};
		private static final @NonNull int[] __AssociationClassCallExp = { 1,1,2,1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _AssociativityKind =
		{
			Fragments._AssociativityKind__OclAny /* 0 */,
			Fragments._AssociativityKind__OclElement /* 1 */,
			Fragments._AssociativityKind__Nameable /* 2 */,
			Fragments._AssociativityKind__OclType /* 2 */,
			Fragments._AssociativityKind__Visitable /* 2 */,
			Fragments._AssociativityKind__Element /* 3 */,
			Fragments._AssociativityKind__NamedElement /* 4 */,
			Fragments._AssociativityKind__ParameterableElement /* 4 */,
			Fragments._AssociativityKind__TemplateableElement /* 4 */,
			Fragments._AssociativityKind__Namespace /* 5 */,
			Fragments._AssociativityKind__PackageableElement /* 5 */,
			Fragments._AssociativityKind__Type /* 6 */,
			Fragments._AssociativityKind__Class /* 7 */,
			Fragments._AssociativityKind__DataType /* 8 */,
			Fragments._AssociativityKind__Enumeration /* 9 */,
			Fragments._AssociativityKind__AssociativityKind /* 10 */
		};
		private static final @NonNull int[] __AssociativityKind = { 1,1,3,1,3,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _BagType =
		{
			Fragments._BagType__OclAny /* 0 */,
			Fragments._BagType__OclElement /* 1 */,
			Fragments._BagType__Nameable /* 2 */,
			Fragments._BagType__OclType /* 2 */,
			Fragments._BagType__Visitable /* 2 */,
			Fragments._BagType__Element /* 3 */,
			Fragments._BagType__NamedElement /* 4 */,
			Fragments._BagType__ParameterableElement /* 4 */,
			Fragments._BagType__TemplateableElement /* 4 */,
			Fragments._BagType__Namespace /* 5 */,
			Fragments._BagType__PackageableElement /* 5 */,
			Fragments._BagType__Type /* 6 */,
			Fragments._BagType__Class /* 7 */,
			Fragments._BagType__DataType /* 8 */,
			Fragments._BagType__CollectionType /* 9 */,
			Fragments._BagType__BagType /* 10 */
		};
		private static final @NonNull int[] __BagType = { 1,1,3,1,3,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Behavior =
		{
			Fragments._Behavior__OclAny /* 0 */,
			Fragments._Behavior__OclElement /* 1 */,
			Fragments._Behavior__Nameable /* 2 */,
			Fragments._Behavior__OclType /* 2 */,
			Fragments._Behavior__Visitable /* 2 */,
			Fragments._Behavior__Element /* 3 */,
			Fragments._Behavior__NamedElement /* 4 */,
			Fragments._Behavior__ParameterableElement /* 4 */,
			Fragments._Behavior__TemplateableElement /* 4 */,
			Fragments._Behavior__Namespace /* 5 */,
			Fragments._Behavior__PackageableElement /* 5 */,
			Fragments._Behavior__Type /* 6 */,
			Fragments._Behavior__Class /* 7 */,
			Fragments._Behavior__Behavior /* 8 */
		};
		private static final @NonNull int[] __Behavior = { 1,1,3,1,3,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _BooleanLiteralExp =
		{
			Fragments._BooleanLiteralExp__OclAny /* 0 */,
			Fragments._BooleanLiteralExp__OclElement /* 1 */,
			Fragments._BooleanLiteralExp__Nameable /* 2 */,
			Fragments._BooleanLiteralExp__Visitable /* 2 */,
			Fragments._BooleanLiteralExp__Element /* 3 */,
			Fragments._BooleanLiteralExp__NamedElement /* 4 */,
			Fragments._BooleanLiteralExp__TypedElement /* 5 */,
			Fragments._BooleanLiteralExp__OCLExpression /* 6 */,
			Fragments._BooleanLiteralExp__LiteralExp /* 7 */,
			Fragments._BooleanLiteralExp__PrimitiveLiteralExp /* 8 */,
			Fragments._BooleanLiteralExp__BooleanLiteralExp /* 9 */
		};
		private static final @NonNull int[] __BooleanLiteralExp = { 1,1,2,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _CallExp =
		{
			Fragments._CallExp__OclAny /* 0 */,
			Fragments._CallExp__OclElement /* 1 */,
			Fragments._CallExp__Nameable /* 2 */,
			Fragments._CallExp__Visitable /* 2 */,
			Fragments._CallExp__Element /* 3 */,
			Fragments._CallExp__NamedElement /* 4 */,
			Fragments._CallExp__TypedElement /* 5 */,
			Fragments._CallExp__OCLExpression /* 6 */,
			Fragments._CallExp__CallExp /* 7 */
		};
		private static final @NonNull int[] __CallExp = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _CallOperationAction =
		{
			Fragments._CallOperationAction__OclAny /* 0 */,
			Fragments._CallOperationAction__OclElement /* 1 */,
			Fragments._CallOperationAction__Nameable /* 2 */,
			Fragments._CallOperationAction__Visitable /* 2 */,
			Fragments._CallOperationAction__Element /* 3 */,
			Fragments._CallOperationAction__NamedElement /* 4 */,
			Fragments._CallOperationAction__CallOperationAction /* 5 */
		};
		private static final @NonNull int[] __CallOperationAction = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Class =
		{
			Fragments._Class__OclAny /* 0 */,
			Fragments._Class__OclElement /* 1 */,
			Fragments._Class__Nameable /* 2 */,
			Fragments._Class__OclType /* 2 */,
			Fragments._Class__Visitable /* 2 */,
			Fragments._Class__Element /* 3 */,
			Fragments._Class__NamedElement /* 4 */,
			Fragments._Class__ParameterableElement /* 4 */,
			Fragments._Class__TemplateableElement /* 4 */,
			Fragments._Class__Namespace /* 5 */,
			Fragments._Class__PackageableElement /* 5 */,
			Fragments._Class__Type /* 6 */,
			Fragments._Class__Class /* 7 */
		};
		private static final @NonNull int[] __Class = { 1,1,3,1,3,2,1,1 };

		private static final @NonNull ExecutorFragment[] _CollectionItem =
		{
			Fragments._CollectionItem__OclAny /* 0 */,
			Fragments._CollectionItem__OclElement /* 1 */,
			Fragments._CollectionItem__Nameable /* 2 */,
			Fragments._CollectionItem__Visitable /* 2 */,
			Fragments._CollectionItem__Element /* 3 */,
			Fragments._CollectionItem__NamedElement /* 4 */,
			Fragments._CollectionItem__TypedElement /* 5 */,
			Fragments._CollectionItem__CollectionLiteralPart /* 6 */,
			Fragments._CollectionItem__CollectionItem /* 7 */
		};
		private static final @NonNull int[] __CollectionItem = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _CollectionKind =
		{
			Fragments._CollectionKind__OclAny /* 0 */,
			Fragments._CollectionKind__OclElement /* 1 */,
			Fragments._CollectionKind__Nameable /* 2 */,
			Fragments._CollectionKind__OclType /* 2 */,
			Fragments._CollectionKind__Visitable /* 2 */,
			Fragments._CollectionKind__Element /* 3 */,
			Fragments._CollectionKind__NamedElement /* 4 */,
			Fragments._CollectionKind__ParameterableElement /* 4 */,
			Fragments._CollectionKind__TemplateableElement /* 4 */,
			Fragments._CollectionKind__Namespace /* 5 */,
			Fragments._CollectionKind__PackageableElement /* 5 */,
			Fragments._CollectionKind__Type /* 6 */,
			Fragments._CollectionKind__Class /* 7 */,
			Fragments._CollectionKind__DataType /* 8 */,
			Fragments._CollectionKind__Enumeration /* 9 */,
			Fragments._CollectionKind__CollectionKind /* 10 */
		};
		private static final @NonNull int[] __CollectionKind = { 1,1,3,1,3,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _CollectionLiteralExp =
		{
			Fragments._CollectionLiteralExp__OclAny /* 0 */,
			Fragments._CollectionLiteralExp__OclElement /* 1 */,
			Fragments._CollectionLiteralExp__Nameable /* 2 */,
			Fragments._CollectionLiteralExp__Visitable /* 2 */,
			Fragments._CollectionLiteralExp__Element /* 3 */,
			Fragments._CollectionLiteralExp__NamedElement /* 4 */,
			Fragments._CollectionLiteralExp__TypedElement /* 5 */,
			Fragments._CollectionLiteralExp__OCLExpression /* 6 */,
			Fragments._CollectionLiteralExp__LiteralExp /* 7 */,
			Fragments._CollectionLiteralExp__CollectionLiteralExp /* 8 */
		};
		private static final @NonNull int[] __CollectionLiteralExp = { 1,1,2,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _CollectionLiteralPart =
		{
			Fragments._CollectionLiteralPart__OclAny /* 0 */,
			Fragments._CollectionLiteralPart__OclElement /* 1 */,
			Fragments._CollectionLiteralPart__Nameable /* 2 */,
			Fragments._CollectionLiteralPart__Visitable /* 2 */,
			Fragments._CollectionLiteralPart__Element /* 3 */,
			Fragments._CollectionLiteralPart__NamedElement /* 4 */,
			Fragments._CollectionLiteralPart__TypedElement /* 5 */,
			Fragments._CollectionLiteralPart__CollectionLiteralPart /* 6 */
		};
		private static final @NonNull int[] __CollectionLiteralPart = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _CollectionRange =
		{
			Fragments._CollectionRange__OclAny /* 0 */,
			Fragments._CollectionRange__OclElement /* 1 */,
			Fragments._CollectionRange__Nameable /* 2 */,
			Fragments._CollectionRange__Visitable /* 2 */,
			Fragments._CollectionRange__Element /* 3 */,
			Fragments._CollectionRange__NamedElement /* 4 */,
			Fragments._CollectionRange__TypedElement /* 5 */,
			Fragments._CollectionRange__CollectionLiteralPart /* 6 */,
			Fragments._CollectionRange__CollectionRange /* 7 */
		};
		private static final @NonNull int[] __CollectionRange = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _CollectionType =
		{
			Fragments._CollectionType__OclAny /* 0 */,
			Fragments._CollectionType__OclElement /* 1 */,
			Fragments._CollectionType__Nameable /* 2 */,
			Fragments._CollectionType__OclType /* 2 */,
			Fragments._CollectionType__Visitable /* 2 */,
			Fragments._CollectionType__Element /* 3 */,
			Fragments._CollectionType__NamedElement /* 4 */,
			Fragments._CollectionType__ParameterableElement /* 4 */,
			Fragments._CollectionType__TemplateableElement /* 4 */,
			Fragments._CollectionType__Namespace /* 5 */,
			Fragments._CollectionType__PackageableElement /* 5 */,
			Fragments._CollectionType__Type /* 6 */,
			Fragments._CollectionType__Class /* 7 */,
			Fragments._CollectionType__DataType /* 8 */,
			Fragments._CollectionType__CollectionType /* 9 */
		};
		private static final @NonNull int[] __CollectionType = { 1,1,3,1,3,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Comment =
		{
			Fragments._Comment__OclAny /* 0 */,
			Fragments._Comment__OclElement /* 1 */,
			Fragments._Comment__Visitable /* 2 */,
			Fragments._Comment__Element /* 3 */,
			Fragments._Comment__Comment /* 4 */
		};
		private static final @NonNull int[] __Comment = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _ConnectionPointReference =
		{
			Fragments._ConnectionPointReference__OclAny /* 0 */,
			Fragments._ConnectionPointReference__OclElement /* 1 */,
			Fragments._ConnectionPointReference__Nameable /* 2 */,
			Fragments._ConnectionPointReference__Visitable /* 2 */,
			Fragments._ConnectionPointReference__Element /* 3 */,
			Fragments._ConnectionPointReference__NamedElement /* 4 */,
			Fragments._ConnectionPointReference__Vertex /* 5 */,
			Fragments._ConnectionPointReference__ConnectionPointReference /* 6 */
		};
		private static final @NonNull int[] __ConnectionPointReference = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Constraint =
		{
			Fragments._Constraint__OclAny /* 0 */,
			Fragments._Constraint__OclElement /* 1 */,
			Fragments._Constraint__Nameable /* 2 */,
			Fragments._Constraint__Visitable /* 2 */,
			Fragments._Constraint__Element /* 3 */,
			Fragments._Constraint__NamedElement /* 4 */,
			Fragments._Constraint__ParameterableElement /* 4 */,
			Fragments._Constraint__PackageableElement /* 5 */,
			Fragments._Constraint__Constraint /* 6 */
		};
		private static final @NonNull int[] __Constraint = { 1,1,2,1,2,1,1 };

		private static final @NonNull ExecutorFragment[] _ConstructorExp =
		{
			Fragments._ConstructorExp__OclAny /* 0 */,
			Fragments._ConstructorExp__OclElement /* 1 */,
			Fragments._ConstructorExp__Nameable /* 2 */,
			Fragments._ConstructorExp__Visitable /* 2 */,
			Fragments._ConstructorExp__Element /* 3 */,
			Fragments._ConstructorExp__NamedElement /* 4 */,
			Fragments._ConstructorExp__TypedElement /* 5 */,
			Fragments._ConstructorExp__OCLExpression /* 6 */,
			Fragments._ConstructorExp__ConstructorExp /* 7 */
		};
		private static final @NonNull int[] __ConstructorExp = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _ConstructorPart =
		{
			Fragments._ConstructorPart__OclAny /* 0 */,
			Fragments._ConstructorPart__OclElement /* 1 */,
			Fragments._ConstructorPart__Nameable /* 2 */,
			Fragments._ConstructorPart__Visitable /* 2 */,
			Fragments._ConstructorPart__Element /* 3 */,
			Fragments._ConstructorPart__NamedElement /* 4 */,
			Fragments._ConstructorPart__TypedElement /* 5 */,
			Fragments._ConstructorPart__ConstructorPart /* 6 */
		};
		private static final @NonNull int[] __ConstructorPart = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _DataType =
		{
			Fragments._DataType__OclAny /* 0 */,
			Fragments._DataType__OclElement /* 1 */,
			Fragments._DataType__Nameable /* 2 */,
			Fragments._DataType__OclType /* 2 */,
			Fragments._DataType__Visitable /* 2 */,
			Fragments._DataType__Element /* 3 */,
			Fragments._DataType__NamedElement /* 4 */,
			Fragments._DataType__ParameterableElement /* 4 */,
			Fragments._DataType__TemplateableElement /* 4 */,
			Fragments._DataType__Namespace /* 5 */,
			Fragments._DataType__PackageableElement /* 5 */,
			Fragments._DataType__Type /* 6 */,
			Fragments._DataType__Class /* 7 */,
			Fragments._DataType__DataType /* 8 */
		};
		private static final @NonNull int[] __DataType = { 1,1,3,1,3,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Detail =
		{
			Fragments._Detail__OclAny /* 0 */,
			Fragments._Detail__OclElement /* 1 */,
			Fragments._Detail__Nameable /* 2 */,
			Fragments._Detail__Visitable /* 2 */,
			Fragments._Detail__Element /* 3 */,
			Fragments._Detail__NamedElement /* 4 */,
			Fragments._Detail__Detail /* 5 */
		};
		private static final @NonNull int[] __Detail = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _DynamicElement =
		{
			Fragments._DynamicElement__OclAny /* 0 */,
			Fragments._DynamicElement__OclElement /* 1 */,
			Fragments._DynamicElement__Visitable /* 2 */,
			Fragments._DynamicElement__Element /* 3 */,
			Fragments._DynamicElement__DynamicElement /* 4 */
		};
		private static final @NonNull int[] __DynamicElement = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _DynamicProperty =
		{
			Fragments._DynamicProperty__OclAny /* 0 */,
			Fragments._DynamicProperty__OclElement /* 1 */,
			Fragments._DynamicProperty__Visitable /* 2 */,
			Fragments._DynamicProperty__Element /* 3 */,
			Fragments._DynamicProperty__DynamicProperty /* 4 */
		};
		private static final @NonNull int[] __DynamicProperty = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _DynamicType =
		{
			Fragments._DynamicType__OclAny /* 0 */,
			Fragments._DynamicType__OclElement /* 1 */,
			Fragments._DynamicType__Nameable /* 2 */,
			Fragments._DynamicType__OclType /* 2 */,
			Fragments._DynamicType__Visitable /* 2 */,
			Fragments._DynamicType__Element /* 3 */,
			Fragments._DynamicType__DynamicElement /* 4 */,
			Fragments._DynamicType__NamedElement /* 4 */,
			Fragments._DynamicType__ParameterableElement /* 4 */,
			Fragments._DynamicType__TemplateableElement /* 4 */,
			Fragments._DynamicType__PackageableElement /* 5 */,
			Fragments._DynamicType__Type /* 6 */,
			Fragments._DynamicType__DynamicType /* 7 */
		};
		private static final @NonNull int[] __DynamicType = { 1,1,3,1,4,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Element =
		{
			Fragments._Element__OclAny /* 0 */,
			Fragments._Element__OclElement /* 1 */,
			Fragments._Element__Visitable /* 2 */,
			Fragments._Element__Element /* 3 */
		};
		private static final @NonNull int[] __Element = { 1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _ElementExtension =
		{
			Fragments._ElementExtension__OclAny /* 0 */,
			Fragments._ElementExtension__OclElement /* 1 */,
			Fragments._ElementExtension__Nameable /* 2 */,
			Fragments._ElementExtension__OclType /* 2 */,
			Fragments._ElementExtension__Visitable /* 2 */,
			Fragments._ElementExtension__Element /* 3 */,
			Fragments._ElementExtension__NamedElement /* 4 */,
			Fragments._ElementExtension__ParameterableElement /* 4 */,
			Fragments._ElementExtension__TemplateableElement /* 4 */,
			Fragments._ElementExtension__PackageableElement /* 5 */,
			Fragments._ElementExtension__Type /* 6 */,
			Fragments._ElementExtension__ElementExtension /* 7 */
		};
		private static final @NonNull int[] __ElementExtension = { 1,1,3,1,3,1,1,1 };

		private static final @NonNull ExecutorFragment[] _EnumLiteralExp =
		{
			Fragments._EnumLiteralExp__OclAny /* 0 */,
			Fragments._EnumLiteralExp__OclElement /* 1 */,
			Fragments._EnumLiteralExp__Nameable /* 2 */,
			Fragments._EnumLiteralExp__Visitable /* 2 */,
			Fragments._EnumLiteralExp__Element /* 3 */,
			Fragments._EnumLiteralExp__NamedElement /* 4 */,
			Fragments._EnumLiteralExp__TypedElement /* 5 */,
			Fragments._EnumLiteralExp__OCLExpression /* 6 */,
			Fragments._EnumLiteralExp__LiteralExp /* 7 */,
			Fragments._EnumLiteralExp__EnumLiteralExp /* 8 */
		};
		private static final @NonNull int[] __EnumLiteralExp = { 1,1,2,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Enumeration =
		{
			Fragments._Enumeration__OclAny /* 0 */,
			Fragments._Enumeration__OclElement /* 1 */,
			Fragments._Enumeration__Nameable /* 2 */,
			Fragments._Enumeration__OclType /* 2 */,
			Fragments._Enumeration__Visitable /* 2 */,
			Fragments._Enumeration__Element /* 3 */,
			Fragments._Enumeration__NamedElement /* 4 */,
			Fragments._Enumeration__ParameterableElement /* 4 */,
			Fragments._Enumeration__TemplateableElement /* 4 */,
			Fragments._Enumeration__Namespace /* 5 */,
			Fragments._Enumeration__PackageableElement /* 5 */,
			Fragments._Enumeration__Type /* 6 */,
			Fragments._Enumeration__Class /* 7 */,
			Fragments._Enumeration__DataType /* 8 */,
			Fragments._Enumeration__Enumeration /* 9 */
		};
		private static final @NonNull int[] __Enumeration = { 1,1,3,1,3,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _EnumerationLiteral =
		{
			Fragments._EnumerationLiteral__OclAny /* 0 */,
			Fragments._EnumerationLiteral__OclElement /* 1 */,
			Fragments._EnumerationLiteral__Nameable /* 2 */,
			Fragments._EnumerationLiteral__Visitable /* 2 */,
			Fragments._EnumerationLiteral__Element /* 3 */,
			Fragments._EnumerationLiteral__NamedElement /* 4 */,
			Fragments._EnumerationLiteral__ParameterableElement /* 4 */,
			Fragments._EnumerationLiteral__PackageableElement /* 5 */,
			Fragments._EnumerationLiteral__EnumerationLiteral /* 6 */
		};
		private static final @NonNull int[] __EnumerationLiteral = { 1,1,2,1,2,1,1 };

		private static final @NonNull ExecutorFragment[] _ExpressionInOCL =
		{
			Fragments._ExpressionInOCL__OclAny /* 0 */,
			Fragments._ExpressionInOCL__OclElement /* 1 */,
			Fragments._ExpressionInOCL__Nameable /* 2 */,
			Fragments._ExpressionInOCL__Visitable /* 2 */,
			Fragments._ExpressionInOCL__Element /* 3 */,
			Fragments._ExpressionInOCL__NamedElement /* 4 */,
			Fragments._ExpressionInOCL__ParameterableElement /* 4 */,
			Fragments._ExpressionInOCL__PackageableElement /* 5 */,
			Fragments._ExpressionInOCL__TypedElement /* 5 */,
			Fragments._ExpressionInOCL__ValueSpecification /* 6 */,
			Fragments._ExpressionInOCL__OpaqueExpression /* 7 */,
			Fragments._ExpressionInOCL__ExpressionInOCL /* 8 */
		};
		private static final @NonNull int[] __ExpressionInOCL = { 1,1,2,1,2,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Feature =
		{
			Fragments._Feature__OclAny /* 0 */,
			Fragments._Feature__OclElement /* 1 */,
			Fragments._Feature__Nameable /* 2 */,
			Fragments._Feature__Visitable /* 2 */,
			Fragments._Feature__Element /* 3 */,
			Fragments._Feature__NamedElement /* 4 */,
			Fragments._Feature__TypedElement /* 5 */,
			Fragments._Feature__TypedMultiplicityElement /* 6 */,
			Fragments._Feature__Feature /* 7 */
		};
		private static final @NonNull int[] __Feature = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _FeatureCallExp =
		{
			Fragments._FeatureCallExp__OclAny /* 0 */,
			Fragments._FeatureCallExp__OclElement /* 1 */,
			Fragments._FeatureCallExp__Nameable /* 2 */,
			Fragments._FeatureCallExp__Visitable /* 2 */,
			Fragments._FeatureCallExp__Element /* 3 */,
			Fragments._FeatureCallExp__NamedElement /* 4 */,
			Fragments._FeatureCallExp__TypedElement /* 5 */,
			Fragments._FeatureCallExp__OCLExpression /* 6 */,
			Fragments._FeatureCallExp__CallExp /* 7 */,
			Fragments._FeatureCallExp__FeatureCallExp /* 8 */
		};
		private static final @NonNull int[] __FeatureCallExp = { 1,1,2,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _FinalState =
		{
			Fragments._FinalState__OclAny /* 0 */,
			Fragments._FinalState__OclElement /* 1 */,
			Fragments._FinalState__OclState /* 1 */,
			Fragments._FinalState__Nameable /* 2 */,
			Fragments._FinalState__Visitable /* 2 */,
			Fragments._FinalState__Element /* 3 */,
			Fragments._FinalState__NamedElement /* 4 */,
			Fragments._FinalState__Namespace /* 5 */,
			Fragments._FinalState__Vertex /* 5 */,
			Fragments._FinalState__State /* 6 */,
			Fragments._FinalState__FinalState /* 7 */
		};
		private static final @NonNull int[] __FinalState = { 1,2,2,1,1,2,1,1 };

		private static final @NonNull ExecutorFragment[] _IfExp =
		{
			Fragments._IfExp__OclAny /* 0 */,
			Fragments._IfExp__OclElement /* 1 */,
			Fragments._IfExp__Nameable /* 2 */,
			Fragments._IfExp__Visitable /* 2 */,
			Fragments._IfExp__Element /* 3 */,
			Fragments._IfExp__NamedElement /* 4 */,
			Fragments._IfExp__TypedElement /* 5 */,
			Fragments._IfExp__OCLExpression /* 6 */,
			Fragments._IfExp__IfExp /* 7 */
		};
		private static final @NonNull int[] __IfExp = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Import =
		{
			Fragments._Import__OclAny /* 0 */,
			Fragments._Import__OclElement /* 1 */,
			Fragments._Import__Nameable /* 2 */,
			Fragments._Import__Visitable /* 2 */,
			Fragments._Import__Element /* 3 */,
			Fragments._Import__NamedElement /* 4 */,
			Fragments._Import__Import /* 5 */
		};
		private static final @NonNull int[] __Import = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _IntegerLiteralExp =
		{
			Fragments._IntegerLiteralExp__OclAny /* 0 */,
			Fragments._IntegerLiteralExp__OclElement /* 1 */,
			Fragments._IntegerLiteralExp__Nameable /* 2 */,
			Fragments._IntegerLiteralExp__Visitable /* 2 */,
			Fragments._IntegerLiteralExp__Element /* 3 */,
			Fragments._IntegerLiteralExp__NamedElement /* 4 */,
			Fragments._IntegerLiteralExp__TypedElement /* 5 */,
			Fragments._IntegerLiteralExp__OCLExpression /* 6 */,
			Fragments._IntegerLiteralExp__LiteralExp /* 7 */,
			Fragments._IntegerLiteralExp__PrimitiveLiteralExp /* 8 */,
			Fragments._IntegerLiteralExp__NumericLiteralExp /* 9 */,
			Fragments._IntegerLiteralExp__IntegerLiteralExp /* 10 */
		};
		private static final @NonNull int[] __IntegerLiteralExp = { 1,1,2,1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _InvalidLiteralExp =
		{
			Fragments._InvalidLiteralExp__OclAny /* 0 */,
			Fragments._InvalidLiteralExp__OclElement /* 1 */,
			Fragments._InvalidLiteralExp__Nameable /* 2 */,
			Fragments._InvalidLiteralExp__Visitable /* 2 */,
			Fragments._InvalidLiteralExp__Element /* 3 */,
			Fragments._InvalidLiteralExp__NamedElement /* 4 */,
			Fragments._InvalidLiteralExp__TypedElement /* 5 */,
			Fragments._InvalidLiteralExp__OCLExpression /* 6 */,
			Fragments._InvalidLiteralExp__LiteralExp /* 7 */,
			Fragments._InvalidLiteralExp__InvalidLiteralExp /* 8 */
		};
		private static final @NonNull int[] __InvalidLiteralExp = { 1,1,2,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _InvalidType =
		{
			Fragments._InvalidType__OclAny /* 0 */,
			Fragments._InvalidType__OclElement /* 1 */,
			Fragments._InvalidType__Nameable /* 2 */,
			Fragments._InvalidType__OclType /* 2 */,
			Fragments._InvalidType__Visitable /* 2 */,
			Fragments._InvalidType__Element /* 3 */,
			Fragments._InvalidType__NamedElement /* 4 */,
			Fragments._InvalidType__ParameterableElement /* 4 */,
			Fragments._InvalidType__TemplateableElement /* 4 */,
			Fragments._InvalidType__Namespace /* 5 */,
			Fragments._InvalidType__PackageableElement /* 5 */,
			Fragments._InvalidType__Type /* 6 */,
			Fragments._InvalidType__Class /* 7 */,
			Fragments._InvalidType__InvalidType /* 8 */
		};
		private static final @NonNull int[] __InvalidType = { 1,1,3,1,3,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _IterateExp =
		{
			Fragments._IterateExp__OclAny /* 0 */,
			Fragments._IterateExp__OclElement /* 1 */,
			Fragments._IterateExp__Nameable /* 2 */,
			Fragments._IterateExp__ReferringElement /* 2 */,
			Fragments._IterateExp__Visitable /* 2 */,
			Fragments._IterateExp__Element /* 3 */,
			Fragments._IterateExp__NamedElement /* 4 */,
			Fragments._IterateExp__TypedElement /* 5 */,
			Fragments._IterateExp__OCLExpression /* 6 */,
			Fragments._IterateExp__CallExp /* 7 */,
			Fragments._IterateExp__LoopExp /* 8 */,
			Fragments._IterateExp__IterateExp /* 9 */
		};
		private static final @NonNull int[] __IterateExp = { 1,1,3,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Iteration =
		{
			Fragments._Iteration__OclAny /* 0 */,
			Fragments._Iteration__OclElement /* 1 */,
			Fragments._Iteration__Nameable /* 2 */,
			Fragments._Iteration__Visitable /* 2 */,
			Fragments._Iteration__Element /* 3 */,
			Fragments._Iteration__NamedElement /* 4 */,
			Fragments._Iteration__ParameterableElement /* 4 */,
			Fragments._Iteration__TemplateableElement /* 4 */,
			Fragments._Iteration__Namespace /* 5 */,
			Fragments._Iteration__TypedElement /* 5 */,
			Fragments._Iteration__TypedMultiplicityElement /* 6 */,
			Fragments._Iteration__Feature /* 7 */,
			Fragments._Iteration__Operation /* 8 */,
			Fragments._Iteration__Iteration /* 9 */
		};
		private static final @NonNull int[] __Iteration = { 1,1,2,1,3,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _IteratorExp =
		{
			Fragments._IteratorExp__OclAny /* 0 */,
			Fragments._IteratorExp__OclElement /* 1 */,
			Fragments._IteratorExp__Nameable /* 2 */,
			Fragments._IteratorExp__ReferringElement /* 2 */,
			Fragments._IteratorExp__Visitable /* 2 */,
			Fragments._IteratorExp__Element /* 3 */,
			Fragments._IteratorExp__NamedElement /* 4 */,
			Fragments._IteratorExp__TypedElement /* 5 */,
			Fragments._IteratorExp__OCLExpression /* 6 */,
			Fragments._IteratorExp__CallExp /* 7 */,
			Fragments._IteratorExp__LoopExp /* 8 */,
			Fragments._IteratorExp__IteratorExp /* 9 */
		};
		private static final @NonNull int[] __IteratorExp = { 1,1,3,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _LambdaType =
		{
			Fragments._LambdaType__OclAny /* 0 */,
			Fragments._LambdaType__OclElement /* 1 */,
			Fragments._LambdaType__Nameable /* 2 */,
			Fragments._LambdaType__OclType /* 2 */,
			Fragments._LambdaType__Visitable /* 2 */,
			Fragments._LambdaType__Element /* 3 */,
			Fragments._LambdaType__NamedElement /* 4 */,
			Fragments._LambdaType__ParameterableElement /* 4 */,
			Fragments._LambdaType__TemplateableElement /* 4 */,
			Fragments._LambdaType__Namespace /* 5 */,
			Fragments._LambdaType__PackageableElement /* 5 */,
			Fragments._LambdaType__Type /* 6 */,
			Fragments._LambdaType__Class /* 7 */,
			Fragments._LambdaType__DataType /* 8 */,
			Fragments._LambdaType__LambdaType /* 9 */
		};
		private static final @NonNull int[] __LambdaType = { 1,1,3,1,3,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _LetExp =
		{
			Fragments._LetExp__OclAny /* 0 */,
			Fragments._LetExp__OclElement /* 1 */,
			Fragments._LetExp__Nameable /* 2 */,
			Fragments._LetExp__Visitable /* 2 */,
			Fragments._LetExp__Element /* 3 */,
			Fragments._LetExp__NamedElement /* 4 */,
			Fragments._LetExp__TypedElement /* 5 */,
			Fragments._LetExp__OCLExpression /* 6 */,
			Fragments._LetExp__LetExp /* 7 */
		};
		private static final @NonNull int[] __LetExp = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Library =
		{
			Fragments._Library__OclAny /* 0 */,
			Fragments._Library__OclElement /* 1 */,
			Fragments._Library__Nameable /* 2 */,
			Fragments._Library__Visitable /* 2 */,
			Fragments._Library__Element /* 3 */,
			Fragments._Library__NamedElement /* 4 */,
			Fragments._Library__ParameterableElement /* 4 */,
			Fragments._Library__TemplateableElement /* 4 */,
			Fragments._Library__Namespace /* 5 */,
			Fragments._Library__PackageableElement /* 5 */,
			Fragments._Library__Package /* 6 */,
			Fragments._Library__Library /* 7 */
		};
		private static final @NonNull int[] __Library = { 1,1,2,1,3,2,1,1 };

		private static final @NonNull ExecutorFragment[] _LibraryFeature =
		{
			Fragments._LibraryFeature__OclAny /* 0 */,
			Fragments._LibraryFeature__LibraryFeature /* 1 */
		};
		private static final @NonNull int[] __LibraryFeature = { 1,1 };

		private static final @NonNull ExecutorFragment[] _LiteralExp =
		{
			Fragments._LiteralExp__OclAny /* 0 */,
			Fragments._LiteralExp__OclElement /* 1 */,
			Fragments._LiteralExp__Nameable /* 2 */,
			Fragments._LiteralExp__Visitable /* 2 */,
			Fragments._LiteralExp__Element /* 3 */,
			Fragments._LiteralExp__NamedElement /* 4 */,
			Fragments._LiteralExp__TypedElement /* 5 */,
			Fragments._LiteralExp__OCLExpression /* 6 */,
			Fragments._LiteralExp__LiteralExp /* 7 */
		};
		private static final @NonNull int[] __LiteralExp = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _LoopExp =
		{
			Fragments._LoopExp__OclAny /* 0 */,
			Fragments._LoopExp__OclElement /* 1 */,
			Fragments._LoopExp__Nameable /* 2 */,
			Fragments._LoopExp__Visitable /* 2 */,
			Fragments._LoopExp__Element /* 3 */,
			Fragments._LoopExp__NamedElement /* 4 */,
			Fragments._LoopExp__TypedElement /* 5 */,
			Fragments._LoopExp__OCLExpression /* 6 */,
			Fragments._LoopExp__CallExp /* 7 */,
			Fragments._LoopExp__LoopExp /* 8 */
		};
		private static final @NonNull int[] __LoopExp = { 1,1,2,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _MessageExp =
		{
			Fragments._MessageExp__OclAny /* 0 */,
			Fragments._MessageExp__OclElement /* 1 */,
			Fragments._MessageExp__Nameable /* 2 */,
			Fragments._MessageExp__Visitable /* 2 */,
			Fragments._MessageExp__Element /* 3 */,
			Fragments._MessageExp__NamedElement /* 4 */,
			Fragments._MessageExp__TypedElement /* 5 */,
			Fragments._MessageExp__OCLExpression /* 6 */,
			Fragments._MessageExp__MessageExp /* 7 */
		};
		private static final @NonNull int[] __MessageExp = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _MessageType =
		{
			Fragments._MessageType__OclAny /* 0 */,
			Fragments._MessageType__OclElement /* 1 */,
			Fragments._MessageType__Nameable /* 2 */,
			Fragments._MessageType__OclType /* 2 */,
			Fragments._MessageType__Visitable /* 2 */,
			Fragments._MessageType__Element /* 3 */,
			Fragments._MessageType__NamedElement /* 4 */,
			Fragments._MessageType__ParameterableElement /* 4 */,
			Fragments._MessageType__TemplateableElement /* 4 */,
			Fragments._MessageType__PackageableElement /* 5 */,
			Fragments._MessageType__Type /* 6 */,
			Fragments._MessageType__MessageType /* 7 */
		};
		private static final @NonNull int[] __MessageType = { 1,1,3,1,3,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Metaclass =
		{
			Fragments._Metaclass__OclAny /* 0 */,
			Fragments._Metaclass__OclElement /* 1 */,
			Fragments._Metaclass__Nameable /* 2 */,
			Fragments._Metaclass__OclType /* 2 */,
			Fragments._Metaclass__Visitable /* 2 */,
			Fragments._Metaclass__Element /* 3 */,
			Fragments._Metaclass__NamedElement /* 4 */,
			Fragments._Metaclass__ParameterableElement /* 4 */,
			Fragments._Metaclass__TemplateableElement /* 4 */,
			Fragments._Metaclass__Namespace /* 5 */,
			Fragments._Metaclass__PackageableElement /* 5 */,
			Fragments._Metaclass__Type /* 6 */,
			Fragments._Metaclass__Class /* 7 */,
			Fragments._Metaclass__Metaclass /* 8 */
		};
		private static final @NonNull int[] __Metaclass = { 1,1,3,1,3,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _MorePivotable =
		{
			Fragments._MorePivotable__OclAny /* 0 */,
			Fragments._MorePivotable__OclElement /* 1 */,
			Fragments._MorePivotable__MorePivotable /* 2 */
		};
		private static final @NonNull int[] __MorePivotable = { 1,1,1 };

		private static final @NonNull ExecutorFragment[] _Nameable =
		{
			Fragments._Nameable__OclAny /* 0 */,
			Fragments._Nameable__OclElement /* 1 */,
			Fragments._Nameable__Nameable /* 2 */
		};
		private static final @NonNull int[] __Nameable = { 1,1,1 };

		private static final @NonNull ExecutorFragment[] _NamedElement =
		{
			Fragments._NamedElement__OclAny /* 0 */,
			Fragments._NamedElement__OclElement /* 1 */,
			Fragments._NamedElement__Nameable /* 2 */,
			Fragments._NamedElement__Visitable /* 2 */,
			Fragments._NamedElement__Element /* 3 */,
			Fragments._NamedElement__NamedElement /* 4 */
		};
		private static final @NonNull int[] __NamedElement = { 1,1,2,1,1 };

		private static final @NonNull ExecutorFragment[] _Namespace =
		{
			Fragments._Namespace__OclAny /* 0 */,
			Fragments._Namespace__OclElement /* 1 */,
			Fragments._Namespace__Nameable /* 2 */,
			Fragments._Namespace__Visitable /* 2 */,
			Fragments._Namespace__Element /* 3 */,
			Fragments._Namespace__NamedElement /* 4 */,
			Fragments._Namespace__Namespace /* 5 */
		};
		private static final @NonNull int[] __Namespace = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _NavigationCallExp =
		{
			Fragments._NavigationCallExp__OclAny /* 0 */,
			Fragments._NavigationCallExp__OclElement /* 1 */,
			Fragments._NavigationCallExp__Nameable /* 2 */,
			Fragments._NavigationCallExp__Visitable /* 2 */,
			Fragments._NavigationCallExp__Element /* 3 */,
			Fragments._NavigationCallExp__NamedElement /* 4 */,
			Fragments._NavigationCallExp__TypedElement /* 5 */,
			Fragments._NavigationCallExp__OCLExpression /* 6 */,
			Fragments._NavigationCallExp__CallExp /* 7 */,
			Fragments._NavigationCallExp__FeatureCallExp /* 8 */,
			Fragments._NavigationCallExp__NavigationCallExp /* 9 */
		};
		private static final @NonNull int[] __NavigationCallExp = { 1,1,2,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _NullLiteralExp =
		{
			Fragments._NullLiteralExp__OclAny /* 0 */,
			Fragments._NullLiteralExp__OclElement /* 1 */,
			Fragments._NullLiteralExp__Nameable /* 2 */,
			Fragments._NullLiteralExp__Visitable /* 2 */,
			Fragments._NullLiteralExp__Element /* 3 */,
			Fragments._NullLiteralExp__NamedElement /* 4 */,
			Fragments._NullLiteralExp__TypedElement /* 5 */,
			Fragments._NullLiteralExp__OCLExpression /* 6 */,
			Fragments._NullLiteralExp__LiteralExp /* 7 */,
			Fragments._NullLiteralExp__PrimitiveLiteralExp /* 8 */,
			Fragments._NullLiteralExp__NullLiteralExp /* 9 */
		};
		private static final @NonNull int[] __NullLiteralExp = { 1,1,2,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _NumericLiteralExp =
		{
			Fragments._NumericLiteralExp__OclAny /* 0 */,
			Fragments._NumericLiteralExp__OclElement /* 1 */,
			Fragments._NumericLiteralExp__Nameable /* 2 */,
			Fragments._NumericLiteralExp__Visitable /* 2 */,
			Fragments._NumericLiteralExp__Element /* 3 */,
			Fragments._NumericLiteralExp__NamedElement /* 4 */,
			Fragments._NumericLiteralExp__TypedElement /* 5 */,
			Fragments._NumericLiteralExp__OCLExpression /* 6 */,
			Fragments._NumericLiteralExp__LiteralExp /* 7 */,
			Fragments._NumericLiteralExp__PrimitiveLiteralExp /* 8 */,
			Fragments._NumericLiteralExp__NumericLiteralExp /* 9 */
		};
		private static final @NonNull int[] __NumericLiteralExp = { 1,1,2,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _OCLExpression =
		{
			Fragments._OCLExpression__OclAny /* 0 */,
			Fragments._OCLExpression__OclElement /* 1 */,
			Fragments._OCLExpression__Nameable /* 2 */,
			Fragments._OCLExpression__Visitable /* 2 */,
			Fragments._OCLExpression__Element /* 3 */,
			Fragments._OCLExpression__NamedElement /* 4 */,
			Fragments._OCLExpression__TypedElement /* 5 */,
			Fragments._OCLExpression__OCLExpression /* 6 */
		};
		private static final @NonNull int[] __OCLExpression = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Object =
		{
			Fragments._Object__OclAny /* 0 */,
			Fragments._Object__Object /* 1 */
		};
		private static final @NonNull int[] __Object = { 1,1 };

		private static final @NonNull ExecutorFragment[] _OpaqueExpression =
		{
			Fragments._OpaqueExpression__OclAny /* 0 */,
			Fragments._OpaqueExpression__OclElement /* 1 */,
			Fragments._OpaqueExpression__Nameable /* 2 */,
			Fragments._OpaqueExpression__Visitable /* 2 */,
			Fragments._OpaqueExpression__Element /* 3 */,
			Fragments._OpaqueExpression__NamedElement /* 4 */,
			Fragments._OpaqueExpression__ParameterableElement /* 4 */,
			Fragments._OpaqueExpression__PackageableElement /* 5 */,
			Fragments._OpaqueExpression__TypedElement /* 5 */,
			Fragments._OpaqueExpression__ValueSpecification /* 6 */,
			Fragments._OpaqueExpression__OpaqueExpression /* 7 */
		};
		private static final @NonNull int[] __OpaqueExpression = { 1,1,2,1,2,2,1,1 };

		private static final @NonNull ExecutorFragment[] _Operation =
		{
			Fragments._Operation__OclAny /* 0 */,
			Fragments._Operation__OclElement /* 1 */,
			Fragments._Operation__Nameable /* 2 */,
			Fragments._Operation__Visitable /* 2 */,
			Fragments._Operation__Element /* 3 */,
			Fragments._Operation__NamedElement /* 4 */,
			Fragments._Operation__ParameterableElement /* 4 */,
			Fragments._Operation__TemplateableElement /* 4 */,
			Fragments._Operation__Namespace /* 5 */,
			Fragments._Operation__TypedElement /* 5 */,
			Fragments._Operation__TypedMultiplicityElement /* 6 */,
			Fragments._Operation__Feature /* 7 */,
			Fragments._Operation__Operation /* 8 */
		};
		private static final @NonNull int[] __Operation = { 1,1,2,1,3,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _OperationCallExp =
		{
			Fragments._OperationCallExp__OclAny /* 0 */,
			Fragments._OperationCallExp__OclElement /* 1 */,
			Fragments._OperationCallExp__Nameable /* 2 */,
			Fragments._OperationCallExp__ReferringElement /* 2 */,
			Fragments._OperationCallExp__Visitable /* 2 */,
			Fragments._OperationCallExp__Element /* 3 */,
			Fragments._OperationCallExp__NamedElement /* 4 */,
			Fragments._OperationCallExp__TypedElement /* 5 */,
			Fragments._OperationCallExp__OCLExpression /* 6 */,
			Fragments._OperationCallExp__CallExp /* 7 */,
			Fragments._OperationCallExp__FeatureCallExp /* 8 */,
			Fragments._OperationCallExp__OperationCallExp /* 9 */
		};
		private static final @NonNull int[] __OperationCallExp = { 1,1,3,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _OperationTemplateParameter =
		{
			Fragments._OperationTemplateParameter__OclAny /* 0 */,
			Fragments._OperationTemplateParameter__OclElement /* 1 */,
			Fragments._OperationTemplateParameter__Visitable /* 2 */,
			Fragments._OperationTemplateParameter__Element /* 3 */,
			Fragments._OperationTemplateParameter__TemplateParameter /* 4 */,
			Fragments._OperationTemplateParameter__OperationTemplateParameter /* 5 */
		};
		private static final @NonNull int[] __OperationTemplateParameter = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _OrderedSetType =
		{
			Fragments._OrderedSetType__OclAny /* 0 */,
			Fragments._OrderedSetType__OclElement /* 1 */,
			Fragments._OrderedSetType__Nameable /* 2 */,
			Fragments._OrderedSetType__OclType /* 2 */,
			Fragments._OrderedSetType__Visitable /* 2 */,
			Fragments._OrderedSetType__Element /* 3 */,
			Fragments._OrderedSetType__NamedElement /* 4 */,
			Fragments._OrderedSetType__ParameterableElement /* 4 */,
			Fragments._OrderedSetType__TemplateableElement /* 4 */,
			Fragments._OrderedSetType__Namespace /* 5 */,
			Fragments._OrderedSetType__PackageableElement /* 5 */,
			Fragments._OrderedSetType__Type /* 6 */,
			Fragments._OrderedSetType__Class /* 7 */,
			Fragments._OrderedSetType__DataType /* 8 */,
			Fragments._OrderedSetType__CollectionType /* 9 */,
			Fragments._OrderedSetType__OrderedSetType /* 10 */
		};
		private static final @NonNull int[] __OrderedSetType = { 1,1,3,1,3,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Package =
		{
			Fragments._Package__OclAny /* 0 */,
			Fragments._Package__OclElement /* 1 */,
			Fragments._Package__Nameable /* 2 */,
			Fragments._Package__Visitable /* 2 */,
			Fragments._Package__Element /* 3 */,
			Fragments._Package__NamedElement /* 4 */,
			Fragments._Package__ParameterableElement /* 4 */,
			Fragments._Package__TemplateableElement /* 4 */,
			Fragments._Package__Namespace /* 5 */,
			Fragments._Package__PackageableElement /* 5 */,
			Fragments._Package__Package /* 6 */
		};
		private static final @NonNull int[] __Package = { 1,1,2,1,3,2,1 };

		private static final @NonNull ExecutorFragment[] _PackageableElement =
		{
			Fragments._PackageableElement__OclAny /* 0 */,
			Fragments._PackageableElement__OclElement /* 1 */,
			Fragments._PackageableElement__Nameable /* 2 */,
			Fragments._PackageableElement__Visitable /* 2 */,
			Fragments._PackageableElement__Element /* 3 */,
			Fragments._PackageableElement__NamedElement /* 4 */,
			Fragments._PackageableElement__ParameterableElement /* 4 */,
			Fragments._PackageableElement__PackageableElement /* 5 */
		};
		private static final @NonNull int[] __PackageableElement = { 1,1,2,1,2,1 };

		private static final @NonNull ExecutorFragment[] _Parameter =
		{
			Fragments._Parameter__OclAny /* 0 */,
			Fragments._Parameter__OclElement /* 1 */,
			Fragments._Parameter__Nameable /* 2 */,
			Fragments._Parameter__Visitable /* 2 */,
			Fragments._Parameter__Element /* 3 */,
			Fragments._Parameter__NamedElement /* 4 */,
			Fragments._Parameter__ParameterableElement /* 4 */,
			Fragments._Parameter__PackageableElement /* 5 */,
			Fragments._Parameter__TypedElement /* 5 */,
			Fragments._Parameter__TypedMultiplicityElement /* 6 */,
			Fragments._Parameter__VariableDeclaration /* 6 */,
			Fragments._Parameter__Parameter /* 7 */
		};
		private static final @NonNull int[] __Parameter = { 1,1,2,1,2,2,2,1 };

		private static final @NonNull ExecutorFragment[] _ParameterableElement =
		{
			Fragments._ParameterableElement__OclAny /* 0 */,
			Fragments._ParameterableElement__OclElement /* 1 */,
			Fragments._ParameterableElement__Visitable /* 2 */,
			Fragments._ParameterableElement__Element /* 3 */,
			Fragments._ParameterableElement__ParameterableElement /* 4 */
		};
		private static final @NonNull int[] __ParameterableElement = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Pivotable =
		{
			Fragments._Pivotable__OclAny /* 0 */,
			Fragments._Pivotable__OclElement /* 1 */,
			Fragments._Pivotable__Pivotable /* 2 */
		};
		private static final @NonNull int[] __Pivotable = { 1,1,1 };

		private static final @NonNull ExecutorFragment[] _Precedence =
		{
			Fragments._Precedence__OclAny /* 0 */,
			Fragments._Precedence__OclElement /* 1 */,
			Fragments._Precedence__Nameable /* 2 */,
			Fragments._Precedence__Visitable /* 2 */,
			Fragments._Precedence__Element /* 3 */,
			Fragments._Precedence__NamedElement /* 4 */,
			Fragments._Precedence__Precedence /* 5 */
		};
		private static final @NonNull int[] __Precedence = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _PrimitiveLiteralExp =
		{
			Fragments._PrimitiveLiteralExp__OclAny /* 0 */,
			Fragments._PrimitiveLiteralExp__OclElement /* 1 */,
			Fragments._PrimitiveLiteralExp__Nameable /* 2 */,
			Fragments._PrimitiveLiteralExp__Visitable /* 2 */,
			Fragments._PrimitiveLiteralExp__Element /* 3 */,
			Fragments._PrimitiveLiteralExp__NamedElement /* 4 */,
			Fragments._PrimitiveLiteralExp__TypedElement /* 5 */,
			Fragments._PrimitiveLiteralExp__OCLExpression /* 6 */,
			Fragments._PrimitiveLiteralExp__LiteralExp /* 7 */,
			Fragments._PrimitiveLiteralExp__PrimitiveLiteralExp /* 8 */
		};
		private static final @NonNull int[] __PrimitiveLiteralExp = { 1,1,2,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _PrimitiveType =
		{
			Fragments._PrimitiveType__OclAny /* 0 */,
			Fragments._PrimitiveType__OclElement /* 1 */,
			Fragments._PrimitiveType__Nameable /* 2 */,
			Fragments._PrimitiveType__OclType /* 2 */,
			Fragments._PrimitiveType__Visitable /* 2 */,
			Fragments._PrimitiveType__Element /* 3 */,
			Fragments._PrimitiveType__NamedElement /* 4 */,
			Fragments._PrimitiveType__ParameterableElement /* 4 */,
			Fragments._PrimitiveType__TemplateableElement /* 4 */,
			Fragments._PrimitiveType__Namespace /* 5 */,
			Fragments._PrimitiveType__PackageableElement /* 5 */,
			Fragments._PrimitiveType__Type /* 6 */,
			Fragments._PrimitiveType__Class /* 7 */,
			Fragments._PrimitiveType__DataType /* 8 */,
			Fragments._PrimitiveType__PrimitiveType /* 9 */
		};
		private static final @NonNull int[] __PrimitiveType = { 1,1,3,1,3,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Profile =
		{
			Fragments._Profile__OclAny /* 0 */,
			Fragments._Profile__OclElement /* 1 */,
			Fragments._Profile__Nameable /* 2 */,
			Fragments._Profile__Visitable /* 2 */,
			Fragments._Profile__Element /* 3 */,
			Fragments._Profile__NamedElement /* 4 */,
			Fragments._Profile__ParameterableElement /* 4 */,
			Fragments._Profile__TemplateableElement /* 4 */,
			Fragments._Profile__Namespace /* 5 */,
			Fragments._Profile__PackageableElement /* 5 */,
			Fragments._Profile__Package /* 6 */,
			Fragments._Profile__Profile /* 7 */
		};
		private static final @NonNull int[] __Profile = { 1,1,2,1,3,2,1,1 };

		private static final @NonNull ExecutorFragment[] _Property =
		{
			Fragments._Property__OclAny /* 0 */,
			Fragments._Property__OclElement /* 1 */,
			Fragments._Property__Nameable /* 2 */,
			Fragments._Property__Visitable /* 2 */,
			Fragments._Property__Element /* 3 */,
			Fragments._Property__NamedElement /* 4 */,
			Fragments._Property__ParameterableElement /* 4 */,
			Fragments._Property__TypedElement /* 5 */,
			Fragments._Property__TypedMultiplicityElement /* 6 */,
			Fragments._Property__Feature /* 7 */,
			Fragments._Property__Property /* 8 */
		};
		private static final @NonNull int[] __Property = { 1,1,2,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _PropertyCallExp =
		{
			Fragments._PropertyCallExp__OclAny /* 0 */,
			Fragments._PropertyCallExp__OclElement /* 1 */,
			Fragments._PropertyCallExp__Nameable /* 2 */,
			Fragments._PropertyCallExp__ReferringElement /* 2 */,
			Fragments._PropertyCallExp__Visitable /* 2 */,
			Fragments._PropertyCallExp__Element /* 3 */,
			Fragments._PropertyCallExp__NamedElement /* 4 */,
			Fragments._PropertyCallExp__TypedElement /* 5 */,
			Fragments._PropertyCallExp__OCLExpression /* 6 */,
			Fragments._PropertyCallExp__CallExp /* 7 */,
			Fragments._PropertyCallExp__FeatureCallExp /* 8 */,
			Fragments._PropertyCallExp__NavigationCallExp /* 9 */,
			Fragments._PropertyCallExp__PropertyCallExp /* 10 */
		};
		private static final @NonNull int[] __PropertyCallExp = { 1,1,3,1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Pseudostate =
		{
			Fragments._Pseudostate__OclAny /* 0 */,
			Fragments._Pseudostate__OclElement /* 1 */,
			Fragments._Pseudostate__Nameable /* 2 */,
			Fragments._Pseudostate__Visitable /* 2 */,
			Fragments._Pseudostate__Element /* 3 */,
			Fragments._Pseudostate__NamedElement /* 4 */,
			Fragments._Pseudostate__Vertex /* 5 */,
			Fragments._Pseudostate__Pseudostate /* 6 */
		};
		private static final @NonNull int[] __Pseudostate = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _PseudostateKind =
		{
			Fragments._PseudostateKind__OclAny /* 0 */,
			Fragments._PseudostateKind__OclElement /* 1 */,
			Fragments._PseudostateKind__Nameable /* 2 */,
			Fragments._PseudostateKind__OclType /* 2 */,
			Fragments._PseudostateKind__Visitable /* 2 */,
			Fragments._PseudostateKind__Element /* 3 */,
			Fragments._PseudostateKind__NamedElement /* 4 */,
			Fragments._PseudostateKind__ParameterableElement /* 4 */,
			Fragments._PseudostateKind__TemplateableElement /* 4 */,
			Fragments._PseudostateKind__Namespace /* 5 */,
			Fragments._PseudostateKind__PackageableElement /* 5 */,
			Fragments._PseudostateKind__Type /* 6 */,
			Fragments._PseudostateKind__Class /* 7 */,
			Fragments._PseudostateKind__DataType /* 8 */,
			Fragments._PseudostateKind__Enumeration /* 9 */,
			Fragments._PseudostateKind__PseudostateKind /* 10 */
		};
		private static final @NonNull int[] __PseudostateKind = { 1,1,3,1,3,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _RealLiteralExp =
		{
			Fragments._RealLiteralExp__OclAny /* 0 */,
			Fragments._RealLiteralExp__OclElement /* 1 */,
			Fragments._RealLiteralExp__Nameable /* 2 */,
			Fragments._RealLiteralExp__Visitable /* 2 */,
			Fragments._RealLiteralExp__Element /* 3 */,
			Fragments._RealLiteralExp__NamedElement /* 4 */,
			Fragments._RealLiteralExp__TypedElement /* 5 */,
			Fragments._RealLiteralExp__OCLExpression /* 6 */,
			Fragments._RealLiteralExp__LiteralExp /* 7 */,
			Fragments._RealLiteralExp__PrimitiveLiteralExp /* 8 */,
			Fragments._RealLiteralExp__NumericLiteralExp /* 9 */,
			Fragments._RealLiteralExp__RealLiteralExp /* 10 */
		};
		private static final @NonNull int[] __RealLiteralExp = { 1,1,2,1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _ReferringElement =
		{
			Fragments._ReferringElement__OclAny /* 0 */,
			Fragments._ReferringElement__OclElement /* 1 */,
			Fragments._ReferringElement__ReferringElement /* 2 */
		};
		private static final @NonNull int[] __ReferringElement = { 1,1,1 };

		private static final @NonNull ExecutorFragment[] _Region =
		{
			Fragments._Region__OclAny /* 0 */,
			Fragments._Region__OclElement /* 1 */,
			Fragments._Region__Nameable /* 2 */,
			Fragments._Region__Visitable /* 2 */,
			Fragments._Region__Element /* 3 */,
			Fragments._Region__NamedElement /* 4 */,
			Fragments._Region__Namespace /* 5 */,
			Fragments._Region__Region /* 6 */
		};
		private static final @NonNull int[] __Region = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Root =
		{
			Fragments._Root__OclAny /* 0 */,
			Fragments._Root__OclElement /* 1 */,
			Fragments._Root__Nameable /* 2 */,
			Fragments._Root__Visitable /* 2 */,
			Fragments._Root__Element /* 3 */,
			Fragments._Root__NamedElement /* 4 */,
			Fragments._Root__Namespace /* 5 */,
			Fragments._Root__Root /* 6 */
		};
		private static final @NonNull int[] __Root = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _SelfType =
		{
			Fragments._SelfType__OclAny /* 0 */,
			Fragments._SelfType__OclElement /* 1 */,
			Fragments._SelfType__Nameable /* 2 */,
			Fragments._SelfType__OclType /* 2 */,
			Fragments._SelfType__Visitable /* 2 */,
			Fragments._SelfType__Element /* 3 */,
			Fragments._SelfType__NamedElement /* 4 */,
			Fragments._SelfType__ParameterableElement /* 4 */,
			Fragments._SelfType__TemplateableElement /* 4 */,
			Fragments._SelfType__Namespace /* 5 */,
			Fragments._SelfType__PackageableElement /* 5 */,
			Fragments._SelfType__Type /* 6 */,
			Fragments._SelfType__Class /* 7 */,
			Fragments._SelfType__SelfType /* 8 */
		};
		private static final @NonNull int[] __SelfType = { 1,1,3,1,3,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _SendSignalAction =
		{
			Fragments._SendSignalAction__OclAny /* 0 */,
			Fragments._SendSignalAction__OclElement /* 1 */,
			Fragments._SendSignalAction__Nameable /* 2 */,
			Fragments._SendSignalAction__Visitable /* 2 */,
			Fragments._SendSignalAction__Element /* 3 */,
			Fragments._SendSignalAction__NamedElement /* 4 */,
			Fragments._SendSignalAction__SendSignalAction /* 5 */
		};
		private static final @NonNull int[] __SendSignalAction = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _SequenceType =
		{
			Fragments._SequenceType__OclAny /* 0 */,
			Fragments._SequenceType__OclElement /* 1 */,
			Fragments._SequenceType__Nameable /* 2 */,
			Fragments._SequenceType__OclType /* 2 */,
			Fragments._SequenceType__Visitable /* 2 */,
			Fragments._SequenceType__Element /* 3 */,
			Fragments._SequenceType__NamedElement /* 4 */,
			Fragments._SequenceType__ParameterableElement /* 4 */,
			Fragments._SequenceType__TemplateableElement /* 4 */,
			Fragments._SequenceType__Namespace /* 5 */,
			Fragments._SequenceType__PackageableElement /* 5 */,
			Fragments._SequenceType__Type /* 6 */,
			Fragments._SequenceType__Class /* 7 */,
			Fragments._SequenceType__DataType /* 8 */,
			Fragments._SequenceType__CollectionType /* 9 */,
			Fragments._SequenceType__SequenceType /* 10 */
		};
		private static final @NonNull int[] __SequenceType = { 1,1,3,1,3,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _SetType =
		{
			Fragments._SetType__OclAny /* 0 */,
			Fragments._SetType__OclElement /* 1 */,
			Fragments._SetType__Nameable /* 2 */,
			Fragments._SetType__OclType /* 2 */,
			Fragments._SetType__Visitable /* 2 */,
			Fragments._SetType__Element /* 3 */,
			Fragments._SetType__NamedElement /* 4 */,
			Fragments._SetType__ParameterableElement /* 4 */,
			Fragments._SetType__TemplateableElement /* 4 */,
			Fragments._SetType__Namespace /* 5 */,
			Fragments._SetType__PackageableElement /* 5 */,
			Fragments._SetType__Type /* 6 */,
			Fragments._SetType__Class /* 7 */,
			Fragments._SetType__DataType /* 8 */,
			Fragments._SetType__CollectionType /* 9 */,
			Fragments._SetType__SetType /* 10 */
		};
		private static final @NonNull int[] __SetType = { 1,1,3,1,3,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Signal =
		{
			Fragments._Signal__OclAny /* 0 */,
			Fragments._Signal__OclElement /* 1 */,
			Fragments._Signal__Nameable /* 2 */,
			Fragments._Signal__OclType /* 2 */,
			Fragments._Signal__Visitable /* 2 */,
			Fragments._Signal__Element /* 3 */,
			Fragments._Signal__NamedElement /* 4 */,
			Fragments._Signal__ParameterableElement /* 4 */,
			Fragments._Signal__TemplateableElement /* 4 */,
			Fragments._Signal__Namespace /* 5 */,
			Fragments._Signal__PackageableElement /* 5 */,
			Fragments._Signal__Type /* 6 */,
			Fragments._Signal__Class /* 7 */,
			Fragments._Signal__Signal /* 8 */
		};
		private static final @NonNull int[] __Signal = { 1,1,3,1,3,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _State =
		{
			Fragments._State__OclAny /* 0 */,
			Fragments._State__OclElement /* 1 */,
			Fragments._State__OclState /* 1 */,
			Fragments._State__Nameable /* 2 */,
			Fragments._State__Visitable /* 2 */,
			Fragments._State__Element /* 3 */,
			Fragments._State__NamedElement /* 4 */,
			Fragments._State__Namespace /* 5 */,
			Fragments._State__Vertex /* 5 */,
			Fragments._State__State /* 6 */
		};
		private static final @NonNull int[] __State = { 1,2,2,1,1,2,1 };

		private static final @NonNull ExecutorFragment[] _StateExp =
		{
			Fragments._StateExp__OclAny /* 0 */,
			Fragments._StateExp__OclElement /* 1 */,
			Fragments._StateExp__Nameable /* 2 */,
			Fragments._StateExp__Visitable /* 2 */,
			Fragments._StateExp__Element /* 3 */,
			Fragments._StateExp__NamedElement /* 4 */,
			Fragments._StateExp__TypedElement /* 5 */,
			Fragments._StateExp__OCLExpression /* 6 */,
			Fragments._StateExp__StateExp /* 7 */
		};
		private static final @NonNull int[] __StateExp = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _StateMachine =
		{
			Fragments._StateMachine__OclAny /* 0 */,
			Fragments._StateMachine__OclElement /* 1 */,
			Fragments._StateMachine__Nameable /* 2 */,
			Fragments._StateMachine__OclType /* 2 */,
			Fragments._StateMachine__Visitable /* 2 */,
			Fragments._StateMachine__Element /* 3 */,
			Fragments._StateMachine__NamedElement /* 4 */,
			Fragments._StateMachine__ParameterableElement /* 4 */,
			Fragments._StateMachine__TemplateableElement /* 4 */,
			Fragments._StateMachine__Namespace /* 5 */,
			Fragments._StateMachine__PackageableElement /* 5 */,
			Fragments._StateMachine__Type /* 6 */,
			Fragments._StateMachine__Class /* 7 */,
			Fragments._StateMachine__Behavior /* 8 */,
			Fragments._StateMachine__StateMachine /* 9 */
		};
		private static final @NonNull int[] __StateMachine = { 1,1,3,1,3,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Stereotype =
		{
			Fragments._Stereotype__OclAny /* 0 */,
			Fragments._Stereotype__OclElement /* 1 */,
			Fragments._Stereotype__Nameable /* 2 */,
			Fragments._Stereotype__OclType /* 2 */,
			Fragments._Stereotype__Visitable /* 2 */,
			Fragments._Stereotype__Element /* 3 */,
			Fragments._Stereotype__NamedElement /* 4 */,
			Fragments._Stereotype__ParameterableElement /* 4 */,
			Fragments._Stereotype__TemplateableElement /* 4 */,
			Fragments._Stereotype__Namespace /* 5 */,
			Fragments._Stereotype__PackageableElement /* 5 */,
			Fragments._Stereotype__Type /* 6 */,
			Fragments._Stereotype__Class /* 7 */,
			Fragments._Stereotype__Stereotype /* 8 */
		};
		private static final @NonNull int[] __Stereotype = { 1,1,3,1,3,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _StringLiteralExp =
		{
			Fragments._StringLiteralExp__OclAny /* 0 */,
			Fragments._StringLiteralExp__OclElement /* 1 */,
			Fragments._StringLiteralExp__Nameable /* 2 */,
			Fragments._StringLiteralExp__Visitable /* 2 */,
			Fragments._StringLiteralExp__Element /* 3 */,
			Fragments._StringLiteralExp__NamedElement /* 4 */,
			Fragments._StringLiteralExp__TypedElement /* 5 */,
			Fragments._StringLiteralExp__OCLExpression /* 6 */,
			Fragments._StringLiteralExp__LiteralExp /* 7 */,
			Fragments._StringLiteralExp__PrimitiveLiteralExp /* 8 */,
			Fragments._StringLiteralExp__StringLiteralExp /* 9 */
		};
		private static final @NonNull int[] __StringLiteralExp = { 1,1,2,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TemplateBinding =
		{
			Fragments._TemplateBinding__OclAny /* 0 */,
			Fragments._TemplateBinding__OclElement /* 1 */,
			Fragments._TemplateBinding__Visitable /* 2 */,
			Fragments._TemplateBinding__Element /* 3 */,
			Fragments._TemplateBinding__TemplateBinding /* 4 */
		};
		private static final @NonNull int[] __TemplateBinding = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TemplateParameter =
		{
			Fragments._TemplateParameter__OclAny /* 0 */,
			Fragments._TemplateParameter__OclElement /* 1 */,
			Fragments._TemplateParameter__Visitable /* 2 */,
			Fragments._TemplateParameter__Element /* 3 */,
			Fragments._TemplateParameter__TemplateParameter /* 4 */
		};
		private static final @NonNull int[] __TemplateParameter = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TemplateParameterSubstitution =
		{
			Fragments._TemplateParameterSubstitution__OclAny /* 0 */,
			Fragments._TemplateParameterSubstitution__OclElement /* 1 */,
			Fragments._TemplateParameterSubstitution__Visitable /* 2 */,
			Fragments._TemplateParameterSubstitution__Element /* 3 */,
			Fragments._TemplateParameterSubstitution__TemplateParameterSubstitution /* 4 */
		};
		private static final @NonNull int[] __TemplateParameterSubstitution = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TemplateParameterType =
		{
			Fragments._TemplateParameterType__OclAny /* 0 */,
			Fragments._TemplateParameterType__OclElement /* 1 */,
			Fragments._TemplateParameterType__Nameable /* 2 */,
			Fragments._TemplateParameterType__OclType /* 2 */,
			Fragments._TemplateParameterType__Visitable /* 2 */,
			Fragments._TemplateParameterType__Element /* 3 */,
			Fragments._TemplateParameterType__NamedElement /* 4 */,
			Fragments._TemplateParameterType__ParameterableElement /* 4 */,
			Fragments._TemplateParameterType__TemplateableElement /* 4 */,
			Fragments._TemplateParameterType__PackageableElement /* 5 */,
			Fragments._TemplateParameterType__Type /* 6 */,
			Fragments._TemplateParameterType__TemplateParameterType /* 7 */
		};
		private static final @NonNull int[] __TemplateParameterType = { 1,1,3,1,3,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TemplateSignature =
		{
			Fragments._TemplateSignature__OclAny /* 0 */,
			Fragments._TemplateSignature__OclElement /* 1 */,
			Fragments._TemplateSignature__Visitable /* 2 */,
			Fragments._TemplateSignature__Element /* 3 */,
			Fragments._TemplateSignature__TemplateSignature /* 4 */
		};
		private static final @NonNull int[] __TemplateSignature = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TemplateableElement =
		{
			Fragments._TemplateableElement__OclAny /* 0 */,
			Fragments._TemplateableElement__OclElement /* 1 */,
			Fragments._TemplateableElement__Visitable /* 2 */,
			Fragments._TemplateableElement__Element /* 3 */,
			Fragments._TemplateableElement__TemplateableElement /* 4 */
		};
		private static final @NonNull int[] __TemplateableElement = { 1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Throwable =
		{
			Fragments._Throwable__OclAny /* 0 */,
			Fragments._Throwable__Throwable /* 1 */
		};
		private static final @NonNull int[] __Throwable = { 1,1 };

		private static final @NonNull ExecutorFragment[] _Transition =
		{
			Fragments._Transition__OclAny /* 0 */,
			Fragments._Transition__OclElement /* 1 */,
			Fragments._Transition__Nameable /* 2 */,
			Fragments._Transition__Visitable /* 2 */,
			Fragments._Transition__Element /* 3 */,
			Fragments._Transition__NamedElement /* 4 */,
			Fragments._Transition__Namespace /* 5 */,
			Fragments._Transition__Transition /* 6 */
		};
		private static final @NonNull int[] __Transition = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TransitionKind =
		{
			Fragments._TransitionKind__OclAny /* 0 */,
			Fragments._TransitionKind__OclElement /* 1 */,
			Fragments._TransitionKind__Nameable /* 2 */,
			Fragments._TransitionKind__OclType /* 2 */,
			Fragments._TransitionKind__Visitable /* 2 */,
			Fragments._TransitionKind__Element /* 3 */,
			Fragments._TransitionKind__NamedElement /* 4 */,
			Fragments._TransitionKind__ParameterableElement /* 4 */,
			Fragments._TransitionKind__TemplateableElement /* 4 */,
			Fragments._TransitionKind__Namespace /* 5 */,
			Fragments._TransitionKind__PackageableElement /* 5 */,
			Fragments._TransitionKind__Type /* 6 */,
			Fragments._TransitionKind__Class /* 7 */,
			Fragments._TransitionKind__DataType /* 8 */,
			Fragments._TransitionKind__Enumeration /* 9 */,
			Fragments._TransitionKind__TransitionKind /* 10 */
		};
		private static final @NonNull int[] __TransitionKind = { 1,1,3,1,3,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Trigger =
		{
			Fragments._Trigger__OclAny /* 0 */,
			Fragments._Trigger__OclElement /* 1 */,
			Fragments._Trigger__Nameable /* 2 */,
			Fragments._Trigger__Visitable /* 2 */,
			Fragments._Trigger__Element /* 3 */,
			Fragments._Trigger__NamedElement /* 4 */,
			Fragments._Trigger__Trigger /* 5 */
		};
		private static final @NonNull int[] __Trigger = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TupleLiteralExp =
		{
			Fragments._TupleLiteralExp__OclAny /* 0 */,
			Fragments._TupleLiteralExp__OclElement /* 1 */,
			Fragments._TupleLiteralExp__Nameable /* 2 */,
			Fragments._TupleLiteralExp__Visitable /* 2 */,
			Fragments._TupleLiteralExp__Element /* 3 */,
			Fragments._TupleLiteralExp__NamedElement /* 4 */,
			Fragments._TupleLiteralExp__TypedElement /* 5 */,
			Fragments._TupleLiteralExp__OCLExpression /* 6 */,
			Fragments._TupleLiteralExp__LiteralExp /* 7 */,
			Fragments._TupleLiteralExp__TupleLiteralExp /* 8 */
		};
		private static final @NonNull int[] __TupleLiteralExp = { 1,1,2,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TupleLiteralPart =
		{
			Fragments._TupleLiteralPart__OclAny /* 0 */,
			Fragments._TupleLiteralPart__OclElement /* 1 */,
			Fragments._TupleLiteralPart__Nameable /* 2 */,
			Fragments._TupleLiteralPart__Visitable /* 2 */,
			Fragments._TupleLiteralPart__Element /* 3 */,
			Fragments._TupleLiteralPart__NamedElement /* 4 */,
			Fragments._TupleLiteralPart__TypedElement /* 5 */,
			Fragments._TupleLiteralPart__VariableDeclaration /* 6 */,
			Fragments._TupleLiteralPart__TupleLiteralPart /* 7 */
		};
		private static final @NonNull int[] __TupleLiteralPart = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TupleType =
		{
			Fragments._TupleType__OclAny /* 0 */,
			Fragments._TupleType__OclElement /* 1 */,
			Fragments._TupleType__Nameable /* 2 */,
			Fragments._TupleType__OclType /* 2 */,
			Fragments._TupleType__Visitable /* 2 */,
			Fragments._TupleType__Element /* 3 */,
			Fragments._TupleType__NamedElement /* 4 */,
			Fragments._TupleType__ParameterableElement /* 4 */,
			Fragments._TupleType__TemplateableElement /* 4 */,
			Fragments._TupleType__Namespace /* 5 */,
			Fragments._TupleType__PackageableElement /* 5 */,
			Fragments._TupleType__Type /* 6 */,
			Fragments._TupleType__Class /* 7 */,
			Fragments._TupleType__DataType /* 8 */,
			Fragments._TupleType__TupleType /* 9 */
		};
		private static final @NonNull int[] __TupleType = { 1,1,3,1,3,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Type =
		{
			Fragments._Type__OclAny /* 0 */,
			Fragments._Type__OclElement /* 1 */,
			Fragments._Type__Nameable /* 2 */,
			Fragments._Type__OclType /* 2 */,
			Fragments._Type__Visitable /* 2 */,
			Fragments._Type__Element /* 3 */,
			Fragments._Type__NamedElement /* 4 */,
			Fragments._Type__ParameterableElement /* 4 */,
			Fragments._Type__TemplateableElement /* 4 */,
			Fragments._Type__PackageableElement /* 5 */,
			Fragments._Type__Type /* 6 */
		};
		private static final @NonNull int[] __Type = { 1,1,3,1,3,1,1 };

		private static final @NonNull ExecutorFragment[] _TypeExp =
		{
			Fragments._TypeExp__OclAny /* 0 */,
			Fragments._TypeExp__OclElement /* 1 */,
			Fragments._TypeExp__Nameable /* 2 */,
			Fragments._TypeExp__ReferringElement /* 2 */,
			Fragments._TypeExp__Visitable /* 2 */,
			Fragments._TypeExp__Element /* 3 */,
			Fragments._TypeExp__NamedElement /* 4 */,
			Fragments._TypeExp__TypedElement /* 5 */,
			Fragments._TypeExp__OCLExpression /* 6 */,
			Fragments._TypeExp__TypeExp /* 7 */
		};
		private static final @NonNull int[] __TypeExp = { 1,1,3,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TypeTemplateParameter =
		{
			Fragments._TypeTemplateParameter__OclAny /* 0 */,
			Fragments._TypeTemplateParameter__OclElement /* 1 */,
			Fragments._TypeTemplateParameter__Visitable /* 2 */,
			Fragments._TypeTemplateParameter__Element /* 3 */,
			Fragments._TypeTemplateParameter__TemplateParameter /* 4 */,
			Fragments._TypeTemplateParameter__TypeTemplateParameter /* 5 */
		};
		private static final @NonNull int[] __TypeTemplateParameter = { 1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TypedElement =
		{
			Fragments._TypedElement__OclAny /* 0 */,
			Fragments._TypedElement__OclElement /* 1 */,
			Fragments._TypedElement__Nameable /* 2 */,
			Fragments._TypedElement__Visitable /* 2 */,
			Fragments._TypedElement__Element /* 3 */,
			Fragments._TypedElement__NamedElement /* 4 */,
			Fragments._TypedElement__TypedElement /* 5 */
		};
		private static final @NonNull int[] __TypedElement = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _TypedMultiplicityElement =
		{
			Fragments._TypedMultiplicityElement__OclAny /* 0 */,
			Fragments._TypedMultiplicityElement__OclElement /* 1 */,
			Fragments._TypedMultiplicityElement__Nameable /* 2 */,
			Fragments._TypedMultiplicityElement__Visitable /* 2 */,
			Fragments._TypedMultiplicityElement__Element /* 3 */,
			Fragments._TypedMultiplicityElement__NamedElement /* 4 */,
			Fragments._TypedMultiplicityElement__TypedElement /* 5 */,
			Fragments._TypedMultiplicityElement__TypedMultiplicityElement /* 6 */
		};
		private static final @NonNull int[] __TypedMultiplicityElement = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _UnlimitedNaturalLiteralExp =
		{
			Fragments._UnlimitedNaturalLiteralExp__OclAny /* 0 */,
			Fragments._UnlimitedNaturalLiteralExp__OclElement /* 1 */,
			Fragments._UnlimitedNaturalLiteralExp__Nameable /* 2 */,
			Fragments._UnlimitedNaturalLiteralExp__Visitable /* 2 */,
			Fragments._UnlimitedNaturalLiteralExp__Element /* 3 */,
			Fragments._UnlimitedNaturalLiteralExp__NamedElement /* 4 */,
			Fragments._UnlimitedNaturalLiteralExp__TypedElement /* 5 */,
			Fragments._UnlimitedNaturalLiteralExp__OCLExpression /* 6 */,
			Fragments._UnlimitedNaturalLiteralExp__LiteralExp /* 7 */,
			Fragments._UnlimitedNaturalLiteralExp__PrimitiveLiteralExp /* 8 */,
			Fragments._UnlimitedNaturalLiteralExp__NumericLiteralExp /* 9 */,
			Fragments._UnlimitedNaturalLiteralExp__UnlimitedNaturalLiteralExp /* 10 */
		};
		private static final @NonNull int[] __UnlimitedNaturalLiteralExp = { 1,1,2,1,1,1,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _UnspecifiedType =
		{
			Fragments._UnspecifiedType__OclAny /* 0 */,
			Fragments._UnspecifiedType__OclElement /* 1 */,
			Fragments._UnspecifiedType__Nameable /* 2 */,
			Fragments._UnspecifiedType__OclType /* 2 */,
			Fragments._UnspecifiedType__Visitable /* 2 */,
			Fragments._UnspecifiedType__Element /* 3 */,
			Fragments._UnspecifiedType__NamedElement /* 4 */,
			Fragments._UnspecifiedType__ParameterableElement /* 4 */,
			Fragments._UnspecifiedType__TemplateableElement /* 4 */,
			Fragments._UnspecifiedType__Namespace /* 5 */,
			Fragments._UnspecifiedType__PackageableElement /* 5 */,
			Fragments._UnspecifiedType__Type /* 6 */,
			Fragments._UnspecifiedType__Class /* 7 */,
			Fragments._UnspecifiedType__UnspecifiedType /* 8 */
		};
		private static final @NonNull int[] __UnspecifiedType = { 1,1,3,1,3,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _UnspecifiedValueExp =
		{
			Fragments._UnspecifiedValueExp__OclAny /* 0 */,
			Fragments._UnspecifiedValueExp__OclElement /* 1 */,
			Fragments._UnspecifiedValueExp__Nameable /* 2 */,
			Fragments._UnspecifiedValueExp__Visitable /* 2 */,
			Fragments._UnspecifiedValueExp__Element /* 3 */,
			Fragments._UnspecifiedValueExp__NamedElement /* 4 */,
			Fragments._UnspecifiedValueExp__TypedElement /* 5 */,
			Fragments._UnspecifiedValueExp__OCLExpression /* 6 */,
			Fragments._UnspecifiedValueExp__UnspecifiedValueExp /* 7 */
		};
		private static final @NonNull int[] __UnspecifiedValueExp = { 1,1,2,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _ValueSpecification =
		{
			Fragments._ValueSpecification__OclAny /* 0 */,
			Fragments._ValueSpecification__OclElement /* 1 */,
			Fragments._ValueSpecification__Nameable /* 2 */,
			Fragments._ValueSpecification__Visitable /* 2 */,
			Fragments._ValueSpecification__Element /* 3 */,
			Fragments._ValueSpecification__NamedElement /* 4 */,
			Fragments._ValueSpecification__ParameterableElement /* 4 */,
			Fragments._ValueSpecification__PackageableElement /* 5 */,
			Fragments._ValueSpecification__TypedElement /* 5 */,
			Fragments._ValueSpecification__ValueSpecification /* 6 */
		};
		private static final @NonNull int[] __ValueSpecification = { 1,1,2,1,2,2,1 };

		private static final @NonNull ExecutorFragment[] _Variable =
		{
			Fragments._Variable__OclAny /* 0 */,
			Fragments._Variable__OclElement /* 1 */,
			Fragments._Variable__Nameable /* 2 */,
			Fragments._Variable__Visitable /* 2 */,
			Fragments._Variable__Element /* 3 */,
			Fragments._Variable__NamedElement /* 4 */,
			Fragments._Variable__ParameterableElement /* 4 */,
			Fragments._Variable__TypedElement /* 5 */,
			Fragments._Variable__VariableDeclaration /* 6 */,
			Fragments._Variable__Variable /* 7 */
		};
		private static final @NonNull int[] __Variable = { 1,1,2,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _VariableDeclaration =
		{
			Fragments._VariableDeclaration__OclAny /* 0 */,
			Fragments._VariableDeclaration__OclElement /* 1 */,
			Fragments._VariableDeclaration__Nameable /* 2 */,
			Fragments._VariableDeclaration__Visitable /* 2 */,
			Fragments._VariableDeclaration__Element /* 3 */,
			Fragments._VariableDeclaration__NamedElement /* 4 */,
			Fragments._VariableDeclaration__TypedElement /* 5 */,
			Fragments._VariableDeclaration__VariableDeclaration /* 6 */
		};
		private static final @NonNull int[] __VariableDeclaration = { 1,1,2,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _VariableExp =
		{
			Fragments._VariableExp__OclAny /* 0 */,
			Fragments._VariableExp__OclElement /* 1 */,
			Fragments._VariableExp__Nameable /* 2 */,
			Fragments._VariableExp__ReferringElement /* 2 */,
			Fragments._VariableExp__Visitable /* 2 */,
			Fragments._VariableExp__Element /* 3 */,
			Fragments._VariableExp__NamedElement /* 4 */,
			Fragments._VariableExp__TypedElement /* 5 */,
			Fragments._VariableExp__OCLExpression /* 6 */,
			Fragments._VariableExp__VariableExp /* 7 */
		};
		private static final @NonNull int[] __VariableExp = { 1,1,3,1,1,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Vertex =
		{
			Fragments._Vertex__OclAny /* 0 */,
			Fragments._Vertex__OclElement /* 1 */,
			Fragments._Vertex__Nameable /* 2 */,
			Fragments._Vertex__Visitable /* 2 */,
			Fragments._Vertex__Element /* 3 */,
			Fragments._Vertex__NamedElement /* 4 */,
			Fragments._Vertex__Vertex /* 5 */
		};
		private static final @NonNull int[] __Vertex = { 1,1,2,1,1,1 };

		private static final @NonNull ExecutorFragment[] _Visitable =
		{
			Fragments._Visitable__OclAny /* 0 */,
			Fragments._Visitable__OclElement /* 1 */,
			Fragments._Visitable__Visitable /* 2 */
		};
		private static final @NonNull int[] __Visitable = { 1,1,1 };

		private static final @NonNull ExecutorFragment[] _Visitor =
		{
			Fragments._Visitor__OclAny /* 0 */,
			Fragments._Visitor__OclElement /* 1 */,
			Fragments._Visitor__Visitor /* 2 */
		};
		private static final @NonNull int[] __Visitor = { 1,1,1 };

		private static final @NonNull ExecutorFragment[] _VoidType =
		{
			Fragments._VoidType__OclAny /* 0 */,
			Fragments._VoidType__OclElement /* 1 */,
			Fragments._VoidType__Nameable /* 2 */,
			Fragments._VoidType__OclType /* 2 */,
			Fragments._VoidType__Visitable /* 2 */,
			Fragments._VoidType__Element /* 3 */,
			Fragments._VoidType__NamedElement /* 4 */,
			Fragments._VoidType__ParameterableElement /* 4 */,
			Fragments._VoidType__TemplateableElement /* 4 */,
			Fragments._VoidType__Namespace /* 5 */,
			Fragments._VoidType__PackageableElement /* 5 */,
			Fragments._VoidType__Type /* 6 */,
			Fragments._VoidType__Class /* 7 */,
			Fragments._VoidType__VoidType /* 8 */
		};
		private static final @NonNull int[] __VoidType = { 1,1,3,1,3,2,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._Annotation.initFragments(_Annotation, __Annotation);
			Types._AnyType.initFragments(_AnyType, __AnyType);
			Types._AssociationClass.initFragments(_AssociationClass, __AssociationClass);
			Types._AssociationClassCallExp.initFragments(_AssociationClassCallExp, __AssociationClassCallExp);
			Types._AssociativityKind.initFragments(_AssociativityKind, __AssociativityKind);
			Types._BagType.initFragments(_BagType, __BagType);
			Types._Behavior.initFragments(_Behavior, __Behavior);
			Types._BooleanLiteralExp.initFragments(_BooleanLiteralExp, __BooleanLiteralExp);
			Types._CallExp.initFragments(_CallExp, __CallExp);
			Types._CallOperationAction.initFragments(_CallOperationAction, __CallOperationAction);
			Types._Class.initFragments(_Class, __Class);
			Types._CollectionItem.initFragments(_CollectionItem, __CollectionItem);
			Types._CollectionKind.initFragments(_CollectionKind, __CollectionKind);
			Types._CollectionLiteralExp.initFragments(_CollectionLiteralExp, __CollectionLiteralExp);
			Types._CollectionLiteralPart.initFragments(_CollectionLiteralPart, __CollectionLiteralPart);
			Types._CollectionRange.initFragments(_CollectionRange, __CollectionRange);
			Types._CollectionType.initFragments(_CollectionType, __CollectionType);
			Types._Comment.initFragments(_Comment, __Comment);
			Types._ConnectionPointReference.initFragments(_ConnectionPointReference, __ConnectionPointReference);
			Types._Constraint.initFragments(_Constraint, __Constraint);
			Types._ConstructorExp.initFragments(_ConstructorExp, __ConstructorExp);
			Types._ConstructorPart.initFragments(_ConstructorPart, __ConstructorPart);
			Types._DataType.initFragments(_DataType, __DataType);
			Types._Detail.initFragments(_Detail, __Detail);
			Types._DynamicElement.initFragments(_DynamicElement, __DynamicElement);
			Types._DynamicProperty.initFragments(_DynamicProperty, __DynamicProperty);
			Types._DynamicType.initFragments(_DynamicType, __DynamicType);
			Types._Element.initFragments(_Element, __Element);
			Types._ElementExtension.initFragments(_ElementExtension, __ElementExtension);
			Types._EnumLiteralExp.initFragments(_EnumLiteralExp, __EnumLiteralExp);
			Types._Enumeration.initFragments(_Enumeration, __Enumeration);
			Types._EnumerationLiteral.initFragments(_EnumerationLiteral, __EnumerationLiteral);
			Types._ExpressionInOCL.initFragments(_ExpressionInOCL, __ExpressionInOCL);
			Types._Feature.initFragments(_Feature, __Feature);
			Types._FeatureCallExp.initFragments(_FeatureCallExp, __FeatureCallExp);
			Types._FinalState.initFragments(_FinalState, __FinalState);
			Types._IfExp.initFragments(_IfExp, __IfExp);
			Types._Import.initFragments(_Import, __Import);
			Types._IntegerLiteralExp.initFragments(_IntegerLiteralExp, __IntegerLiteralExp);
			Types._InvalidLiteralExp.initFragments(_InvalidLiteralExp, __InvalidLiteralExp);
			Types._InvalidType.initFragments(_InvalidType, __InvalidType);
			Types._IterateExp.initFragments(_IterateExp, __IterateExp);
			Types._Iteration.initFragments(_Iteration, __Iteration);
			Types._IteratorExp.initFragments(_IteratorExp, __IteratorExp);
			Types._LambdaType.initFragments(_LambdaType, __LambdaType);
			Types._LetExp.initFragments(_LetExp, __LetExp);
			Types._Library.initFragments(_Library, __Library);
			Types._LibraryFeature.initFragments(_LibraryFeature, __LibraryFeature);
			Types._LiteralExp.initFragments(_LiteralExp, __LiteralExp);
			Types._LoopExp.initFragments(_LoopExp, __LoopExp);
			Types._MessageExp.initFragments(_MessageExp, __MessageExp);
			Types._MessageType.initFragments(_MessageType, __MessageType);
			Types._Metaclass.initFragments(_Metaclass, __Metaclass);
			Types._MorePivotable.initFragments(_MorePivotable, __MorePivotable);
			Types._Nameable.initFragments(_Nameable, __Nameable);
			Types._NamedElement.initFragments(_NamedElement, __NamedElement);
			Types._Namespace.initFragments(_Namespace, __Namespace);
			Types._NavigationCallExp.initFragments(_NavigationCallExp, __NavigationCallExp);
			Types._NullLiteralExp.initFragments(_NullLiteralExp, __NullLiteralExp);
			Types._NumericLiteralExp.initFragments(_NumericLiteralExp, __NumericLiteralExp);
			Types._OCLExpression.initFragments(_OCLExpression, __OCLExpression);
			Types._Object.initFragments(_Object, __Object);
			Types._OpaqueExpression.initFragments(_OpaqueExpression, __OpaqueExpression);
			Types._Operation.initFragments(_Operation, __Operation);
			Types._OperationCallExp.initFragments(_OperationCallExp, __OperationCallExp);
			Types._OperationTemplateParameter.initFragments(_OperationTemplateParameter, __OperationTemplateParameter);
			Types._OrderedSetType.initFragments(_OrderedSetType, __OrderedSetType);
			Types._Package.initFragments(_Package, __Package);
			Types._PackageableElement.initFragments(_PackageableElement, __PackageableElement);
			Types._Parameter.initFragments(_Parameter, __Parameter);
			Types._ParameterableElement.initFragments(_ParameterableElement, __ParameterableElement);
			Types._Pivotable.initFragments(_Pivotable, __Pivotable);
			Types._Precedence.initFragments(_Precedence, __Precedence);
			Types._PrimitiveLiteralExp.initFragments(_PrimitiveLiteralExp, __PrimitiveLiteralExp);
			Types._PrimitiveType.initFragments(_PrimitiveType, __PrimitiveType);
			Types._Profile.initFragments(_Profile, __Profile);
			Types._Property.initFragments(_Property, __Property);
			Types._PropertyCallExp.initFragments(_PropertyCallExp, __PropertyCallExp);
			Types._Pseudostate.initFragments(_Pseudostate, __Pseudostate);
			Types._PseudostateKind.initFragments(_PseudostateKind, __PseudostateKind);
			Types._RealLiteralExp.initFragments(_RealLiteralExp, __RealLiteralExp);
			Types._ReferringElement.initFragments(_ReferringElement, __ReferringElement);
			Types._Region.initFragments(_Region, __Region);
			Types._Root.initFragments(_Root, __Root);
			Types._SelfType.initFragments(_SelfType, __SelfType);
			Types._SendSignalAction.initFragments(_SendSignalAction, __SendSignalAction);
			Types._SequenceType.initFragments(_SequenceType, __SequenceType);
			Types._SetType.initFragments(_SetType, __SetType);
			Types._Signal.initFragments(_Signal, __Signal);
			Types._State.initFragments(_State, __State);
			Types._StateExp.initFragments(_StateExp, __StateExp);
			Types._StateMachine.initFragments(_StateMachine, __StateMachine);
			Types._Stereotype.initFragments(_Stereotype, __Stereotype);
			Types._StringLiteralExp.initFragments(_StringLiteralExp, __StringLiteralExp);
			Types._TemplateBinding.initFragments(_TemplateBinding, __TemplateBinding);
			Types._TemplateParameter.initFragments(_TemplateParameter, __TemplateParameter);
			Types._TemplateParameterSubstitution.initFragments(_TemplateParameterSubstitution, __TemplateParameterSubstitution);
			Types._TemplateParameterType.initFragments(_TemplateParameterType, __TemplateParameterType);
			Types._TemplateSignature.initFragments(_TemplateSignature, __TemplateSignature);
			Types._TemplateableElement.initFragments(_TemplateableElement, __TemplateableElement);
			Types._Throwable.initFragments(_Throwable, __Throwable);
			Types._Transition.initFragments(_Transition, __Transition);
			Types._TransitionKind.initFragments(_TransitionKind, __TransitionKind);
			Types._Trigger.initFragments(_Trigger, __Trigger);
			Types._TupleLiteralExp.initFragments(_TupleLiteralExp, __TupleLiteralExp);
			Types._TupleLiteralPart.initFragments(_TupleLiteralPart, __TupleLiteralPart);
			Types._TupleType.initFragments(_TupleType, __TupleType);
			Types._Type.initFragments(_Type, __Type);
			Types._TypeExp.initFragments(_TypeExp, __TypeExp);
			Types._TypeTemplateParameter.initFragments(_TypeTemplateParameter, __TypeTemplateParameter);
			Types._TypedElement.initFragments(_TypedElement, __TypedElement);
			Types._TypedMultiplicityElement.initFragments(_TypedMultiplicityElement, __TypedMultiplicityElement);
			Types._UnlimitedNaturalLiteralExp.initFragments(_UnlimitedNaturalLiteralExp, __UnlimitedNaturalLiteralExp);
			Types._UnspecifiedType.initFragments(_UnspecifiedType, __UnspecifiedType);
			Types._UnspecifiedValueExp.initFragments(_UnspecifiedValueExp, __UnspecifiedValueExp);
			Types._ValueSpecification.initFragments(_ValueSpecification, __ValueSpecification);
			Types._Variable.initFragments(_Variable, __Variable);
			Types._VariableDeclaration.initFragments(_VariableDeclaration, __VariableDeclaration);
			Types._VariableExp.initFragments(_VariableExp, __VariableExp);
			Types._Vertex.initFragments(_Vertex, __Vertex);
			Types._Visitable.initFragments(_Visitable, __Visitable);
			Types._Visitor.initFragments(_Visitor, __Visitor);
			Types._VoidType.initFragments(_VoidType, __VoidType);
		}

		public static void init() {}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		private static final @NonNull ExecutorOperation[] _Annotation__Annotation = {};
		private static final @NonNull ExecutorOperation[] _Annotation__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Annotation__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Annotation__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Annotation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Annotation__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Annotation__Visitable = {};

		private static final @NonNull ExecutorOperation[] _AnyType__AnyType = {};
		private static final @NonNull ExecutorOperation[] _AnyType__Class = {};
		private static final @NonNull ExecutorOperation[] _AnyType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _AnyType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _AnyType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _AnyType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _AnyType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _AnyType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _AnyType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _AnyType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _AnyType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _AnyType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _AnyType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _AnyType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _AssociationClass__AssociationClass = {};
		private static final @NonNull ExecutorOperation[] _AssociationClass__Class = {};
		private static final @NonNull ExecutorOperation[] _AssociationClass__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _AssociationClass__Nameable = {};
		private static final @NonNull ExecutorOperation[] _AssociationClass__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _AssociationClass__Namespace = {};
		private static final @NonNull ExecutorOperation[] _AssociationClass__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _AssociationClass__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _AssociationClass__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _AssociationClass__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _AssociationClass__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _AssociationClass__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _AssociationClass__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _AssociationClass__Visitable = {};

		private static final @NonNull ExecutorOperation[] _AssociationClassCallExp__AssociationClassCallExp = {};
		private static final @NonNull ExecutorOperation[] _AssociationClassCallExp__CallExp = {};
		private static final @NonNull ExecutorOperation[] _AssociationClassCallExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _AssociationClassCallExp__FeatureCallExp = {};
		private static final @NonNull ExecutorOperation[] _AssociationClassCallExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _AssociationClassCallExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _AssociationClassCallExp__NavigationCallExp = {};
		private static final @NonNull ExecutorOperation[] _AssociationClassCallExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _AssociationClassCallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _AssociationClassCallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _AssociationClassCallExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _AssociationClassCallExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _AssociativityKind__AssociativityKind = {};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__Class = {};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__DataType = {};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__Enumeration = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */
		};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__Nameable = {};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__Namespace = {};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__OclElement = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _AssociativityKind__Visitable = {};

		private static final @NonNull ExecutorOperation[] _BagType__BagType = {};
		private static final @NonNull ExecutorOperation[] _BagType__Class = {};
		private static final @NonNull ExecutorOperation[] _BagType__CollectionType = {};
		private static final @NonNull ExecutorOperation[] _BagType__DataType = {};
		private static final @NonNull ExecutorOperation[] _BagType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _BagType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _BagType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _BagType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _BagType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _BagType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _BagType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _BagType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _BagType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _BagType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _BagType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _BagType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Behavior__Behavior = {};
		private static final @NonNull ExecutorOperation[] _Behavior__Class = {};
		private static final @NonNull ExecutorOperation[] _Behavior__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Behavior__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Behavior__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Behavior__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Behavior__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Behavior__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Behavior__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _Behavior__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _Behavior__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Behavior__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _Behavior__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _Behavior__Visitable = {};

		private static final @NonNull ExecutorOperation[] _BooleanLiteralExp__BooleanLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _BooleanLiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _BooleanLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _BooleanLiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _BooleanLiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _BooleanLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _BooleanLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _BooleanLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _BooleanLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _BooleanLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _BooleanLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _CallExp__CallExp = {};
		private static final @NonNull ExecutorOperation[] _CallExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _CallExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _CallExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _CallExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _CallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _CallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _CallExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _CallExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _CallOperationAction__CallOperationAction = {};
		private static final @NonNull ExecutorOperation[] _CallOperationAction__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _CallOperationAction__Nameable = {};
		private static final @NonNull ExecutorOperation[] _CallOperationAction__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _CallOperationAction__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _CallOperationAction__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _CallOperationAction__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Class__Class = {};
		private static final @NonNull ExecutorOperation[] _Class__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Class__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Class__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Class__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Class__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Class__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Class__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _Class__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _Class__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Class__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _Class__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _Class__Visitable = {};

		private static final @NonNull ExecutorOperation[] _CollectionItem__CollectionItem = {};
		private static final @NonNull ExecutorOperation[] _CollectionItem__CollectionLiteralPart = {};
		private static final @NonNull ExecutorOperation[] _CollectionItem__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _CollectionItem__Nameable = {};
		private static final @NonNull ExecutorOperation[] _CollectionItem__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _CollectionItem__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionItem__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionItem__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _CollectionItem__Visitable = {};

		private static final @NonNull ExecutorOperation[] _CollectionKind__CollectionKind = {};
		private static final @NonNull ExecutorOperation[] _CollectionKind__Class = {};
		private static final @NonNull ExecutorOperation[] _CollectionKind__DataType = {};
		private static final @NonNull ExecutorOperation[] _CollectionKind__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _CollectionKind__Enumeration = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionKind__Nameable = {};
		private static final @NonNull ExecutorOperation[] _CollectionKind__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _CollectionKind__Namespace = {};
		private static final @NonNull ExecutorOperation[] _CollectionKind__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionKind__OclElement = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionKind__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _CollectionKind__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _CollectionKind__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionKind__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionKind__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _CollectionKind__Visitable = {};

		private static final @NonNull ExecutorOperation[] _CollectionLiteralExp__CollectionLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _CollectionLiteralPart__CollectionLiteralPart = {};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralPart__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralPart__Nameable = {};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralPart__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralPart__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralPart__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralPart__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _CollectionLiteralPart__Visitable = {};

		private static final @NonNull ExecutorOperation[] _CollectionRange__CollectionRange = {};
		private static final @NonNull ExecutorOperation[] _CollectionRange__CollectionLiteralPart = {};
		private static final @NonNull ExecutorOperation[] _CollectionRange__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _CollectionRange__Nameable = {};
		private static final @NonNull ExecutorOperation[] _CollectionRange__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _CollectionRange__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionRange__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionRange__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _CollectionRange__Visitable = {};

		private static final @NonNull ExecutorOperation[] _CollectionType__CollectionType = {};
		private static final @NonNull ExecutorOperation[] _CollectionType__Class = {};
		private static final @NonNull ExecutorOperation[] _CollectionType__DataType = {};
		private static final @NonNull ExecutorOperation[] _CollectionType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _CollectionType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _CollectionType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _CollectionType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _CollectionType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _CollectionType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _CollectionType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _CollectionType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _CollectionType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Comment__Comment = {};
		private static final @NonNull ExecutorOperation[] _Comment__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Comment__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Comment__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Comment__Visitable = {};

		private static final @NonNull ExecutorOperation[] _ConnectionPointReference__ConnectionPointReference = {};
		private static final @NonNull ExecutorOperation[] _ConnectionPointReference__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _ConnectionPointReference__Nameable = {};
		private static final @NonNull ExecutorOperation[] _ConnectionPointReference__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _ConnectionPointReference__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _ConnectionPointReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _ConnectionPointReference__Vertex = {};
		private static final @NonNull ExecutorOperation[] _ConnectionPointReference__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Constraint__Constraint = {};
		private static final @NonNull ExecutorOperation[] _Constraint__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Constraint__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Constraint__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Constraint__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Constraint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Constraint__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _Constraint__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Constraint__Visitable = {};

		private static final @NonNull ExecutorOperation[] _ConstructorExp__ConstructorExp = {};
		private static final @NonNull ExecutorOperation[] _ConstructorExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _ConstructorExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _ConstructorExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _ConstructorExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _ConstructorExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _ConstructorExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _ConstructorExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _ConstructorExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _ConstructorPart__ConstructorPart = {};
		private static final @NonNull ExecutorOperation[] _ConstructorPart__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _ConstructorPart__Nameable = {};
		private static final @NonNull ExecutorOperation[] _ConstructorPart__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _ConstructorPart__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _ConstructorPart__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _ConstructorPart__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _ConstructorPart__Visitable = {};

		private static final @NonNull ExecutorOperation[] _DataType__DataType = {};
		private static final @NonNull ExecutorOperation[] _DataType__Class = {};
		private static final @NonNull ExecutorOperation[] _DataType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _DataType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _DataType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _DataType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _DataType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _DataType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _DataType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _DataType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _DataType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _DataType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _DataType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _DataType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Detail__Detail = {};
		private static final @NonNull ExecutorOperation[] _Detail__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Detail__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Detail__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Detail__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Detail__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Detail__Visitable = {};

		private static final @NonNull ExecutorOperation[] _DynamicElement__DynamicElement = {};
		private static final @NonNull ExecutorOperation[] _DynamicElement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _DynamicElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _DynamicElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _DynamicElement__Visitable = {};

		private static final @NonNull ExecutorOperation[] _DynamicProperty__DynamicProperty = {};
		private static final @NonNull ExecutorOperation[] _DynamicProperty__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _DynamicProperty__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _DynamicProperty__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _DynamicProperty__Visitable = {};

		private static final @NonNull ExecutorOperation[] _DynamicType__DynamicType = {};
		private static final @NonNull ExecutorOperation[] _DynamicType__DynamicElement = {};
		private static final @NonNull ExecutorOperation[] _DynamicType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _DynamicType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _DynamicType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _DynamicType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _DynamicType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _DynamicType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _DynamicType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _DynamicType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _DynamicType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _DynamicType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _DynamicType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Element__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Element__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Element__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Element__Visitable = {};

		private static final @NonNull ExecutorOperation[] _ElementExtension__ElementExtension = {};
		private static final @NonNull ExecutorOperation[] _ElementExtension__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _ElementExtension__Nameable = {};
		private static final @NonNull ExecutorOperation[] _ElementExtension__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _ElementExtension__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _ElementExtension__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _ElementExtension__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _ElementExtension__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _ElementExtension__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _ElementExtension__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _ElementExtension__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _ElementExtension__Visitable = {};

		private static final @NonNull ExecutorOperation[] _EnumLiteralExp__EnumLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _EnumLiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _EnumLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _EnumLiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _EnumLiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _EnumLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _EnumLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _EnumLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _EnumLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _EnumLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Enumeration__Enumeration = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */
		};
		private static final @NonNull ExecutorOperation[] _Enumeration__Class = {};
		private static final @NonNull ExecutorOperation[] _Enumeration__DataType = {};
		private static final @NonNull ExecutorOperation[] _Enumeration__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Enumeration__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Enumeration__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Enumeration__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Enumeration__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Enumeration__OclElement = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Enumeration__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _Enumeration__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _Enumeration__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Enumeration__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _Enumeration__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _Enumeration__Visitable = {};

		private static final @NonNull ExecutorOperation[] _EnumerationLiteral__EnumerationLiteral = {};
		private static final @NonNull ExecutorOperation[] _EnumerationLiteral__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _EnumerationLiteral__Nameable = {};
		private static final @NonNull ExecutorOperation[] _EnumerationLiteral__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _EnumerationLiteral__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _EnumerationLiteral__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _EnumerationLiteral__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _EnumerationLiteral__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _EnumerationLiteral__Visitable = {};

		private static final @NonNull ExecutorOperation[] _ExpressionInOCL__ExpressionInOCL = {};
		private static final @NonNull ExecutorOperation[] _ExpressionInOCL__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _ExpressionInOCL__Nameable = {};
		private static final @NonNull ExecutorOperation[] _ExpressionInOCL__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _ExpressionInOCL__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _ExpressionInOCL__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _ExpressionInOCL__OpaqueExpression = {};
		private static final @NonNull ExecutorOperation[] _ExpressionInOCL__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _ExpressionInOCL__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _ExpressionInOCL__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _ExpressionInOCL__ValueSpecification = {
			PivotTables.Operations._ValueSpecification__booleanValue /* booleanValue() */,
			PivotTables.Operations._ValueSpecification__integerValue /* integerValue() */,
			PivotTables.Operations._ValueSpecification__isComputable /* isComputable() */,
			PivotTables.Operations._ValueSpecification__isNull /* isNull() */,
			PivotTables.Operations._ValueSpecification__stringValue /* stringValue() */,
			PivotTables.Operations._ValueSpecification__unlimitedValue /* unlimitedValue() */
		};
		private static final @NonNull ExecutorOperation[] _ExpressionInOCL__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Feature__Feature = {};
		private static final @NonNull ExecutorOperation[] _Feature__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Feature__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Feature__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Feature__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Feature__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Feature__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _Feature__TypedMultiplicityElement = {
			PivotTables.Operations._TypedMultiplicityElement__CompatibleBody /* CompatibleBody(ValueSpecification) */,
			PivotTables.Operations._TypedMultiplicityElement__makeParameter /* makeParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Feature__Visitable = {};

		private static final @NonNull ExecutorOperation[] _FeatureCallExp__FeatureCallExp = {};
		private static final @NonNull ExecutorOperation[] _FeatureCallExp__CallExp = {};
		private static final @NonNull ExecutorOperation[] _FeatureCallExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _FeatureCallExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _FeatureCallExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _FeatureCallExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _FeatureCallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _FeatureCallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _FeatureCallExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _FeatureCallExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _FinalState__FinalState = {};
		private static final @NonNull ExecutorOperation[] _FinalState__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _FinalState__Nameable = {};
		private static final @NonNull ExecutorOperation[] _FinalState__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _FinalState__Namespace = {};
		private static final @NonNull ExecutorOperation[] _FinalState__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _FinalState__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _FinalState__OclState = {};
		private static final @NonNull ExecutorOperation[] _FinalState__State = {};
		private static final @NonNull ExecutorOperation[] _FinalState__Vertex = {};
		private static final @NonNull ExecutorOperation[] _FinalState__Visitable = {};

		private static final @NonNull ExecutorOperation[] _IfExp__IfExp = {};
		private static final @NonNull ExecutorOperation[] _IfExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _IfExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _IfExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _IfExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _IfExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _IfExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _IfExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _IfExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Import__Import = {};
		private static final @NonNull ExecutorOperation[] _Import__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Import__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Import__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Import__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Import__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Import__Visitable = {};

		private static final @NonNull ExecutorOperation[] _IntegerLiteralExp__IntegerLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _IntegerLiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _IntegerLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _IntegerLiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _IntegerLiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _IntegerLiteralExp__NumericLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _IntegerLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _IntegerLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _IntegerLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _IntegerLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _IntegerLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _IntegerLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _InvalidLiteralExp__InvalidLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _InvalidLiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _InvalidLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _InvalidLiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _InvalidLiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _InvalidLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _InvalidLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _InvalidLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _InvalidLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _InvalidLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _InvalidType__InvalidType = {};
		private static final @NonNull ExecutorOperation[] _InvalidType__Class = {};
		private static final @NonNull ExecutorOperation[] _InvalidType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _InvalidType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _InvalidType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _InvalidType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _InvalidType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _InvalidType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _InvalidType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _InvalidType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _InvalidType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _InvalidType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _InvalidType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _InvalidType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _IterateExp__IterateExp = {};
		private static final @NonNull ExecutorOperation[] _IterateExp__CallExp = {};
		private static final @NonNull ExecutorOperation[] _IterateExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _IterateExp__LoopExp = {};
		private static final @NonNull ExecutorOperation[] _IterateExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _IterateExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _IterateExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _IterateExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _IterateExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _IterateExp__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};
		private static final @NonNull ExecutorOperation[] _IterateExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _IterateExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Iteration__Iteration = {};
		private static final @NonNull ExecutorOperation[] _Iteration__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Iteration__Feature = {};
		private static final @NonNull ExecutorOperation[] _Iteration__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Iteration__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Iteration__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Iteration__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Iteration__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Iteration__Operation = {};
		private static final @NonNull ExecutorOperation[] _Iteration__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Iteration__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _Iteration__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _Iteration__TypedMultiplicityElement = {
			PivotTables.Operations._TypedMultiplicityElement__CompatibleBody /* CompatibleBody(ValueSpecification) */,
			PivotTables.Operations._TypedMultiplicityElement__makeParameter /* makeParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Iteration__Visitable = {};

		private static final @NonNull ExecutorOperation[] _IteratorExp__IteratorExp = {};
		private static final @NonNull ExecutorOperation[] _IteratorExp__CallExp = {};
		private static final @NonNull ExecutorOperation[] _IteratorExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _IteratorExp__LoopExp = {};
		private static final @NonNull ExecutorOperation[] _IteratorExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _IteratorExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _IteratorExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _IteratorExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _IteratorExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _IteratorExp__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};
		private static final @NonNull ExecutorOperation[] _IteratorExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _IteratorExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _LambdaType__LambdaType = {};
		private static final @NonNull ExecutorOperation[] _LambdaType__Class = {};
		private static final @NonNull ExecutorOperation[] _LambdaType__DataType = {};
		private static final @NonNull ExecutorOperation[] _LambdaType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _LambdaType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _LambdaType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _LambdaType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _LambdaType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _LambdaType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _LambdaType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _LambdaType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _LambdaType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _LambdaType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _LambdaType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _LambdaType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _LetExp__LetExp = {};
		private static final @NonNull ExecutorOperation[] _LetExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _LetExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _LetExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _LetExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _LetExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _LetExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _LetExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _LetExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Library__Library = {};
		private static final @NonNull ExecutorOperation[] _Library__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Library__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Library__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Library__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Library__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Library__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Library__Package = {};
		private static final @NonNull ExecutorOperation[] _Library__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _Library__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Library__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _Library__Visitable = {};

		private static final @NonNull ExecutorOperation[] _LibraryFeature__LibraryFeature = {};
		private static final @NonNull ExecutorOperation[] _LibraryFeature__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _LiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _LiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _LiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _LiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _LiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _LiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _LiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _LiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _LiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _LoopExp__LoopExp = {};
		private static final @NonNull ExecutorOperation[] _LoopExp__CallExp = {};
		private static final @NonNull ExecutorOperation[] _LoopExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _LoopExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _LoopExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _LoopExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _LoopExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _LoopExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _LoopExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _LoopExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _MessageExp__MessageExp = {};
		private static final @NonNull ExecutorOperation[] _MessageExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _MessageExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _MessageExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _MessageExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _MessageExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _MessageExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _MessageExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _MessageExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _MessageType__MessageType = {};
		private static final @NonNull ExecutorOperation[] _MessageType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _MessageType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _MessageType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _MessageType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _MessageType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _MessageType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _MessageType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _MessageType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _MessageType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _MessageType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _MessageType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Metaclass__Metaclass = {};
		private static final @NonNull ExecutorOperation[] _Metaclass__Class = {};
		private static final @NonNull ExecutorOperation[] _Metaclass__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Metaclass__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Metaclass__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Metaclass__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Metaclass__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Metaclass__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Metaclass__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _Metaclass__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _Metaclass__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Metaclass__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _Metaclass__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _Metaclass__Visitable = {};

		private static final @NonNull ExecutorOperation[] _MorePivotable__MorePivotable = {};
		private static final @NonNull ExecutorOperation[] _MorePivotable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _MorePivotable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final @NonNull ExecutorOperation[] _Nameable__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Nameable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Nameable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final @NonNull ExecutorOperation[] _NamedElement__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _NamedElement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _NamedElement__Nameable = {};
		private static final @NonNull ExecutorOperation[] _NamedElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _NamedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _NamedElement__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Namespace__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Namespace__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Namespace__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Namespace__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Namespace__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Namespace__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Namespace__Visitable = {};

		private static final @NonNull ExecutorOperation[] _NavigationCallExp__NavigationCallExp = {};
		private static final @NonNull ExecutorOperation[] _NavigationCallExp__CallExp = {};
		private static final @NonNull ExecutorOperation[] _NavigationCallExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _NavigationCallExp__FeatureCallExp = {};
		private static final @NonNull ExecutorOperation[] _NavigationCallExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _NavigationCallExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _NavigationCallExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _NavigationCallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _NavigationCallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _NavigationCallExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _NavigationCallExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _NullLiteralExp__NullLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _NullLiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _NullLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _NullLiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _NullLiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _NullLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _NullLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _NullLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _NullLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _NullLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _NullLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _NumericLiteralExp__NumericLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _NumericLiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _NumericLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _NumericLiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _NumericLiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _NumericLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _NumericLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _NumericLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _NumericLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _NumericLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _NumericLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _OCLExpression__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _OCLExpression__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _OCLExpression__Nameable = {};
		private static final @NonNull ExecutorOperation[] _OCLExpression__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _OCLExpression__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _OCLExpression__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _OCLExpression__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _OCLExpression__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Object__Object = {};
		private static final @NonNull ExecutorOperation[] _Object__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _OpaqueExpression__OpaqueExpression = {};
		private static final @NonNull ExecutorOperation[] _OpaqueExpression__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _OpaqueExpression__Nameable = {};
		private static final @NonNull ExecutorOperation[] _OpaqueExpression__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _OpaqueExpression__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _OpaqueExpression__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _OpaqueExpression__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _OpaqueExpression__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _OpaqueExpression__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _OpaqueExpression__ValueSpecification = {
			PivotTables.Operations._ValueSpecification__booleanValue /* booleanValue() */,
			PivotTables.Operations._ValueSpecification__integerValue /* integerValue() */,
			PivotTables.Operations._ValueSpecification__isComputable /* isComputable() */,
			PivotTables.Operations._ValueSpecification__isNull /* isNull() */,
			PivotTables.Operations._ValueSpecification__stringValue /* stringValue() */,
			PivotTables.Operations._ValueSpecification__unlimitedValue /* unlimitedValue() */
		};
		private static final @NonNull ExecutorOperation[] _OpaqueExpression__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Operation__Operation = {};
		private static final @NonNull ExecutorOperation[] _Operation__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Operation__Feature = {};
		private static final @NonNull ExecutorOperation[] _Operation__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Operation__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Operation__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Operation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Operation__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Operation__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Operation__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _Operation__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _Operation__TypedMultiplicityElement = {
			PivotTables.Operations._TypedMultiplicityElement__CompatibleBody /* CompatibleBody(ValueSpecification) */,
			PivotTables.Operations._TypedMultiplicityElement__makeParameter /* makeParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Operation__Visitable = {};

		private static final @NonNull ExecutorOperation[] _OperationCallExp__OperationCallExp = {};
		private static final @NonNull ExecutorOperation[] _OperationCallExp__CallExp = {};
		private static final @NonNull ExecutorOperation[] _OperationCallExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _OperationCallExp__FeatureCallExp = {};
		private static final @NonNull ExecutorOperation[] _OperationCallExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _OperationCallExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _OperationCallExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _OperationCallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _OperationCallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _OperationCallExp__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};
		private static final @NonNull ExecutorOperation[] _OperationCallExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _OperationCallExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _OperationTemplateParameter__OperationTemplateParameter = {};
		private static final @NonNull ExecutorOperation[] _OperationTemplateParameter__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _OperationTemplateParameter__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _OperationTemplateParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _OperationTemplateParameter__TemplateParameter = {};
		private static final @NonNull ExecutorOperation[] _OperationTemplateParameter__Visitable = {};

		private static final @NonNull ExecutorOperation[] _OrderedSetType__OrderedSetType = {};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__Class = {};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__CollectionType = {};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__DataType = {};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _OrderedSetType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Package__Package = {};
		private static final @NonNull ExecutorOperation[] _Package__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Package__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Package__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Package__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Package__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Package__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Package__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _Package__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Package__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _Package__Visitable = {};

		private static final @NonNull ExecutorOperation[] _PackageableElement__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _PackageableElement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _PackageableElement__Nameable = {};
		private static final @NonNull ExecutorOperation[] _PackageableElement__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _PackageableElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _PackageableElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _PackageableElement__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _PackageableElement__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Parameter__Parameter = {};
		private static final @NonNull ExecutorOperation[] _Parameter__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Parameter__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Parameter__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Parameter__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Parameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Parameter__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _Parameter__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Parameter__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _Parameter__TypedMultiplicityElement = {
			PivotTables.Operations._TypedMultiplicityElement__CompatibleBody /* CompatibleBody(ValueSpecification) */,
			PivotTables.Operations._TypedMultiplicityElement__makeParameter /* makeParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Parameter__VariableDeclaration = {};
		private static final @NonNull ExecutorOperation[] _Parameter__Visitable = {};

		private static final @NonNull ExecutorOperation[] _ParameterableElement__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _ParameterableElement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _ParameterableElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _ParameterableElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _ParameterableElement__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Pivotable__Pivotable = {};
		private static final @NonNull ExecutorOperation[] _Pivotable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Pivotable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final @NonNull ExecutorOperation[] _Precedence__Precedence = {};
		private static final @NonNull ExecutorOperation[] _Precedence__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Precedence__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Precedence__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Precedence__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Precedence__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Precedence__Visitable = {};

		private static final @NonNull ExecutorOperation[] _PrimitiveLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveLiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _PrimitiveLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveLiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveLiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _PrimitiveLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _PrimitiveLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _PrimitiveType__PrimitiveType = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__Class = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__DataType = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _PrimitiveType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Profile__Profile = {};
		private static final @NonNull ExecutorOperation[] _Profile__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Profile__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Profile__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Profile__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Profile__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Profile__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Profile__Package = {};
		private static final @NonNull ExecutorOperation[] _Profile__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _Profile__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Profile__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _Profile__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Property__Property = {
			PivotTables.Operations._Property__isAttribute /* isAttribute(Property) */
		};
		private static final @NonNull ExecutorOperation[] _Property__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Property__Feature = {};
		private static final @NonNull ExecutorOperation[] _Property__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Property__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Property__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Property__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Property__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Property__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _Property__TypedMultiplicityElement = {
			PivotTables.Operations._TypedMultiplicityElement__CompatibleBody /* CompatibleBody(ValueSpecification) */,
			PivotTables.Operations._TypedMultiplicityElement__makeParameter /* makeParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Property__Visitable = {};

		private static final @NonNull ExecutorOperation[] _PropertyCallExp__PropertyCallExp = {
			PivotTables.Operations._PropertyCallExp__getSpecializedReferredPropertyOwningType /* getSpecializedReferredPropertyOwningType() */,
			PivotTables.Operations._PropertyCallExp__getSpecializedReferredPropertyType /* getSpecializedReferredPropertyType() */
		};
		private static final @NonNull ExecutorOperation[] _PropertyCallExp__CallExp = {};
		private static final @NonNull ExecutorOperation[] _PropertyCallExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _PropertyCallExp__FeatureCallExp = {};
		private static final @NonNull ExecutorOperation[] _PropertyCallExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _PropertyCallExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _PropertyCallExp__NavigationCallExp = {};
		private static final @NonNull ExecutorOperation[] _PropertyCallExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _PropertyCallExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _PropertyCallExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _PropertyCallExp__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};
		private static final @NonNull ExecutorOperation[] _PropertyCallExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _PropertyCallExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Pseudostate__Pseudostate = {};
		private static final @NonNull ExecutorOperation[] _Pseudostate__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Pseudostate__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Pseudostate__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Pseudostate__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Pseudostate__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Pseudostate__Vertex = {};
		private static final @NonNull ExecutorOperation[] _Pseudostate__Visitable = {};

		private static final @NonNull ExecutorOperation[] _PseudostateKind__PseudostateKind = {};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__Class = {};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__DataType = {};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__Enumeration = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */
		};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__Nameable = {};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__Namespace = {};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__OclElement = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _PseudostateKind__Visitable = {};

		private static final @NonNull ExecutorOperation[] _RealLiteralExp__RealLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _RealLiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _RealLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _RealLiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _RealLiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _RealLiteralExp__NumericLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _RealLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _RealLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _RealLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _RealLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _RealLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _RealLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _ReferringElement__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};
		private static final @NonNull ExecutorOperation[] _ReferringElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _ReferringElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final @NonNull ExecutorOperation[] _Region__Region = {};
		private static final @NonNull ExecutorOperation[] _Region__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Region__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Region__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Region__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Region__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Region__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Region__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Root__Root = {};
		private static final @NonNull ExecutorOperation[] _Root__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Root__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Root__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Root__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Root__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Root__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Root__Visitable = {};

		private static final @NonNull ExecutorOperation[] _SelfType__SelfType = {
			PivotTables.Operations._SelfType__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _SelfType__Class = {};
		private static final @NonNull ExecutorOperation[] _SelfType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _SelfType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _SelfType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _SelfType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _SelfType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _SelfType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _SelfType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _SelfType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _SelfType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _SelfType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _SelfType__Type = {
			PivotTables.Operations._SelfType__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _SelfType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _SendSignalAction__SendSignalAction = {};
		private static final @NonNull ExecutorOperation[] _SendSignalAction__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _SendSignalAction__Nameable = {};
		private static final @NonNull ExecutorOperation[] _SendSignalAction__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _SendSignalAction__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _SendSignalAction__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _SendSignalAction__Visitable = {};

		private static final @NonNull ExecutorOperation[] _SequenceType__SequenceType = {};
		private static final @NonNull ExecutorOperation[] _SequenceType__Class = {};
		private static final @NonNull ExecutorOperation[] _SequenceType__CollectionType = {};
		private static final @NonNull ExecutorOperation[] _SequenceType__DataType = {};
		private static final @NonNull ExecutorOperation[] _SequenceType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _SequenceType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _SequenceType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _SequenceType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _SequenceType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _SequenceType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _SequenceType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _SequenceType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _SequenceType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _SequenceType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _SequenceType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _SequenceType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _SetType__SetType = {};
		private static final @NonNull ExecutorOperation[] _SetType__Class = {};
		private static final @NonNull ExecutorOperation[] _SetType__CollectionType = {};
		private static final @NonNull ExecutorOperation[] _SetType__DataType = {};
		private static final @NonNull ExecutorOperation[] _SetType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _SetType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _SetType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _SetType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _SetType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _SetType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _SetType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _SetType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _SetType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _SetType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _SetType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _SetType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Signal__Signal = {};
		private static final @NonNull ExecutorOperation[] _Signal__Class = {};
		private static final @NonNull ExecutorOperation[] _Signal__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Signal__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Signal__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Signal__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Signal__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Signal__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Signal__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _Signal__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _Signal__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Signal__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _Signal__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _Signal__Visitable = {};

		private static final @NonNull ExecutorOperation[] _State__State = {};
		private static final @NonNull ExecutorOperation[] _State__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _State__Nameable = {};
		private static final @NonNull ExecutorOperation[] _State__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _State__Namespace = {};
		private static final @NonNull ExecutorOperation[] _State__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _State__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _State__OclState = {};
		private static final @NonNull ExecutorOperation[] _State__Vertex = {};
		private static final @NonNull ExecutorOperation[] _State__Visitable = {};

		private static final @NonNull ExecutorOperation[] _StateExp__StateExp = {};
		private static final @NonNull ExecutorOperation[] _StateExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _StateExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _StateExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _StateExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _StateExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _StateExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _StateExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _StateExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _StateMachine__StateMachine = {};
		private static final @NonNull ExecutorOperation[] _StateMachine__Behavior = {};
		private static final @NonNull ExecutorOperation[] _StateMachine__Class = {};
		private static final @NonNull ExecutorOperation[] _StateMachine__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _StateMachine__Nameable = {};
		private static final @NonNull ExecutorOperation[] _StateMachine__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _StateMachine__Namespace = {};
		private static final @NonNull ExecutorOperation[] _StateMachine__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _StateMachine__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _StateMachine__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _StateMachine__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _StateMachine__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _StateMachine__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _StateMachine__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _StateMachine__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Stereotype__Stereotype = {};
		private static final @NonNull ExecutorOperation[] _Stereotype__Class = {};
		private static final @NonNull ExecutorOperation[] _Stereotype__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Stereotype__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Stereotype__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Stereotype__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Stereotype__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Stereotype__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Stereotype__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _Stereotype__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _Stereotype__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Stereotype__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _Stereotype__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _Stereotype__Visitable = {};

		private static final @NonNull ExecutorOperation[] _StringLiteralExp__StringLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _StringLiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _StringLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _StringLiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _StringLiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _StringLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _StringLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _StringLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _StringLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _StringLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _StringLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TemplateBinding__TemplateBinding = {};
		private static final @NonNull ExecutorOperation[] _TemplateBinding__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TemplateBinding__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateBinding__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateBinding__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TemplateParameter__TemplateParameter = {};
		private static final @NonNull ExecutorOperation[] _TemplateParameter__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameter__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameter__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TemplateParameterSubstitution__TemplateParameterSubstitution = {};
		private static final @NonNull ExecutorOperation[] _TemplateParameterSubstitution__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameterSubstitution__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameterSubstitution__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameterSubstitution__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TemplateParameterType__TemplateParameterType = {};
		private static final @NonNull ExecutorOperation[] _TemplateParameterType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameterType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _TemplateParameterType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _TemplateParameterType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameterType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameterType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameterType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _TemplateParameterType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameterType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameterType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _TemplateParameterType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TemplateSignature__TemplateSignature = {};
		private static final @NonNull ExecutorOperation[] _TemplateSignature__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TemplateSignature__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateSignature__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateSignature__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TemplateableElement__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateableElement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TemplateableElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateableElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TemplateableElement__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Throwable__Throwable = {};
		private static final @NonNull ExecutorOperation[] _Throwable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};

		private static final @NonNull ExecutorOperation[] _Transition__Transition = {};
		private static final @NonNull ExecutorOperation[] _Transition__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Transition__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Transition__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Transition__Namespace = {};
		private static final @NonNull ExecutorOperation[] _Transition__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Transition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Transition__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TransitionKind__TransitionKind = {};
		private static final @NonNull ExecutorOperation[] _TransitionKind__Class = {};
		private static final @NonNull ExecutorOperation[] _TransitionKind__DataType = {};
		private static final @NonNull ExecutorOperation[] _TransitionKind__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TransitionKind__Enumeration = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */
		};
		private static final @NonNull ExecutorOperation[] _TransitionKind__Nameable = {};
		private static final @NonNull ExecutorOperation[] _TransitionKind__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _TransitionKind__Namespace = {};
		private static final @NonNull ExecutorOperation[] _TransitionKind__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TransitionKind__OclElement = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TransitionKind__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _TransitionKind__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _TransitionKind__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _TransitionKind__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _TransitionKind__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _TransitionKind__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Trigger__Trigger = {};
		private static final @NonNull ExecutorOperation[] _Trigger__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Trigger__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Trigger__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Trigger__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Trigger__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Trigger__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TupleLiteralExp__TupleLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _TupleLiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TupleLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _TupleLiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _TupleLiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _TupleLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _TupleLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TupleLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TupleLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _TupleLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TupleLiteralPart__TupleLiteralPart = {};
		private static final @NonNull ExecutorOperation[] _TupleLiteralPart__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TupleLiteralPart__Nameable = {};
		private static final @NonNull ExecutorOperation[] _TupleLiteralPart__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _TupleLiteralPart__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TupleLiteralPart__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TupleLiteralPart__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _TupleLiteralPart__VariableDeclaration = {};
		private static final @NonNull ExecutorOperation[] _TupleLiteralPart__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TupleType__TupleType = {};
		private static final @NonNull ExecutorOperation[] _TupleType__Class = {};
		private static final @NonNull ExecutorOperation[] _TupleType__DataType = {};
		private static final @NonNull ExecutorOperation[] _TupleType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TupleType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _TupleType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _TupleType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _TupleType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TupleType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TupleType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _TupleType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _TupleType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _TupleType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _TupleType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _TupleType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Type__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _Type__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Type__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Type__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Type__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Type__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Type__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _Type__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _Type__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Type__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _Type__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TypeExp__TypeExp = {};
		private static final @NonNull ExecutorOperation[] _TypeExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TypeExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _TypeExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _TypeExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _TypeExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TypeExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TypeExp__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};
		private static final @NonNull ExecutorOperation[] _TypeExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _TypeExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TypeTemplateParameter__TypeTemplateParameter = {};
		private static final @NonNull ExecutorOperation[] _TypeTemplateParameter__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TypeTemplateParameter__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TypeTemplateParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TypeTemplateParameter__TemplateParameter = {};
		private static final @NonNull ExecutorOperation[] _TypeTemplateParameter__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TypedElement__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _TypedElement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TypedElement__Nameable = {};
		private static final @NonNull ExecutorOperation[] _TypedElement__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _TypedElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TypedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TypedElement__Visitable = {};

		private static final @NonNull ExecutorOperation[] _TypedMultiplicityElement__TypedMultiplicityElement = {
			PivotTables.Operations._TypedMultiplicityElement__CompatibleBody /* CompatibleBody(ValueSpecification) */,
			PivotTables.Operations._TypedMultiplicityElement__makeParameter /* makeParameter() */
		};
		private static final @NonNull ExecutorOperation[] _TypedMultiplicityElement__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _TypedMultiplicityElement__Nameable = {};
		private static final @NonNull ExecutorOperation[] _TypedMultiplicityElement__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _TypedMultiplicityElement__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _TypedMultiplicityElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _TypedMultiplicityElement__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _TypedMultiplicityElement__Visitable = {};

		private static final @NonNull ExecutorOperation[] _UnlimitedNaturalLiteralExp__UnlimitedNaturalLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _UnlimitedNaturalLiteralExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _UnlimitedNaturalLiteralExp__LiteralExp = {};
		private static final @NonNull ExecutorOperation[] _UnlimitedNaturalLiteralExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _UnlimitedNaturalLiteralExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _UnlimitedNaturalLiteralExp__NumericLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _UnlimitedNaturalLiteralExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _UnlimitedNaturalLiteralExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _UnlimitedNaturalLiteralExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _UnlimitedNaturalLiteralExp__PrimitiveLiteralExp = {};
		private static final @NonNull ExecutorOperation[] _UnlimitedNaturalLiteralExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _UnlimitedNaturalLiteralExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _UnspecifiedType__UnspecifiedType = {};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__Class = {};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _UnspecifiedType__Visitable = {};

		private static final @NonNull ExecutorOperation[] _UnspecifiedValueExp__UnspecifiedValueExp = {};
		private static final @NonNull ExecutorOperation[] _UnspecifiedValueExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _UnspecifiedValueExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _UnspecifiedValueExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _UnspecifiedValueExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _UnspecifiedValueExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _UnspecifiedValueExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _UnspecifiedValueExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _UnspecifiedValueExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _ValueSpecification__ValueSpecification = {
			PivotTables.Operations._ValueSpecification__booleanValue /* booleanValue() */,
			PivotTables.Operations._ValueSpecification__integerValue /* integerValue() */,
			PivotTables.Operations._ValueSpecification__isComputable /* isComputable() */,
			PivotTables.Operations._ValueSpecification__isNull /* isNull() */,
			PivotTables.Operations._ValueSpecification__stringValue /* stringValue() */,
			PivotTables.Operations._ValueSpecification__unlimitedValue /* unlimitedValue() */
		};
		private static final @NonNull ExecutorOperation[] _ValueSpecification__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _ValueSpecification__Nameable = {};
		private static final @NonNull ExecutorOperation[] _ValueSpecification__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _ValueSpecification__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _ValueSpecification__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _ValueSpecification__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _ValueSpecification__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _ValueSpecification__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _ValueSpecification__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Variable__Variable = {};
		private static final @NonNull ExecutorOperation[] _Variable__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Variable__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Variable__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Variable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Variable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Variable__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _Variable__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _Variable__VariableDeclaration = {};
		private static final @NonNull ExecutorOperation[] _Variable__Visitable = {};

		private static final @NonNull ExecutorOperation[] _VariableDeclaration__VariableDeclaration = {};
		private static final @NonNull ExecutorOperation[] _VariableDeclaration__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _VariableDeclaration__Nameable = {};
		private static final @NonNull ExecutorOperation[] _VariableDeclaration__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _VariableDeclaration__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _VariableDeclaration__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _VariableDeclaration__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _VariableDeclaration__Visitable = {};

		private static final @NonNull ExecutorOperation[] _VariableExp__VariableExp = {};
		private static final @NonNull ExecutorOperation[] _VariableExp__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _VariableExp__Nameable = {};
		private static final @NonNull ExecutorOperation[] _VariableExp__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _VariableExp__OCLExpression = {};
		private static final @NonNull ExecutorOperation[] _VariableExp__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _VariableExp__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _VariableExp__ReferringElement = {
			PivotTables.Operations._ReferringElement__getReferredElement /* getReferredElement() */
		};
		private static final @NonNull ExecutorOperation[] _VariableExp__TypedElement = {};
		private static final @NonNull ExecutorOperation[] _VariableExp__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Vertex__Vertex = {};
		private static final @NonNull ExecutorOperation[] _Vertex__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _Vertex__Nameable = {};
		private static final @NonNull ExecutorOperation[] _Vertex__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _Vertex__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Vertex__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _Vertex__Visitable = {};

		private static final @NonNull ExecutorOperation[] _Visitable__Visitable = {};
		private static final @NonNull ExecutorOperation[] _Visitable__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Visitable__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final @NonNull ExecutorOperation[] _Visitor__Visitor = {};
		private static final @NonNull ExecutorOperation[] _Visitor__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _Visitor__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final @NonNull ExecutorOperation[] _VoidType__VoidType = {};
		private static final @NonNull ExecutorOperation[] _VoidType__Class = {};
		private static final @NonNull ExecutorOperation[] _VoidType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type,String) */
		};
		private static final @NonNull ExecutorOperation[] _VoidType__Nameable = {};
		private static final @NonNull ExecutorOperation[] _VoidType__NamedElement = {};
		private static final @NonNull ExecutorOperation[] _VoidType__Namespace = {};
		private static final @NonNull ExecutorOperation[] _VoidType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(Metaclass(TT)) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(T)(Metaclass(T)) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final @NonNull ExecutorOperation[] _VoidType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final @NonNull ExecutorOperation[] _VoidType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType) */
		};
		private static final @NonNull ExecutorOperation[] _VoidType__PackageableElement = {};
		private static final @NonNull ExecutorOperation[] _VoidType__ParameterableElement = {
			PivotTables.Operations._ParameterableElement__isCompatibleWith /* isCompatibleWith(ParameterableElement) */,
			PivotTables.Operations._ParameterableElement__isTemplateParameter /* isTemplateParameter() */
		};
		private static final @NonNull ExecutorOperation[] _VoidType__TemplateableElement = {
			PivotTables.Operations._TemplateableElement__isTemplate /* isTemplate() */,
			PivotTables.Operations._TemplateableElement__parameterableElements /* parameterableElements() */
		};
		private static final @NonNull ExecutorOperation[] _VoidType__Type = {
			PivotTables.Operations._Type__specializeIn /* specializeIn(OCLExpression,Type) */
		};
		private static final @NonNull ExecutorOperation[] _VoidType__Visitable = {};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Annotation__Annotation.initOperations(_Annotation__Annotation);
			Fragments._Annotation__Element.initOperations(_Annotation__Element);
			Fragments._Annotation__Nameable.initOperations(_Annotation__Nameable);
			Fragments._Annotation__NamedElement.initOperations(_Annotation__NamedElement);
			Fragments._Annotation__OclAny.initOperations(_Annotation__OclAny);
			Fragments._Annotation__OclElement.initOperations(_Annotation__OclElement);
			Fragments._Annotation__Visitable.initOperations(_Annotation__Visitable);

			Fragments._AnyType__AnyType.initOperations(_AnyType__AnyType);
			Fragments._AnyType__Class.initOperations(_AnyType__Class);
			Fragments._AnyType__Element.initOperations(_AnyType__Element);
			Fragments._AnyType__Nameable.initOperations(_AnyType__Nameable);
			Fragments._AnyType__NamedElement.initOperations(_AnyType__NamedElement);
			Fragments._AnyType__Namespace.initOperations(_AnyType__Namespace);
			Fragments._AnyType__OclAny.initOperations(_AnyType__OclAny);
			Fragments._AnyType__OclElement.initOperations(_AnyType__OclElement);
			Fragments._AnyType__OclType.initOperations(_AnyType__OclType);
			Fragments._AnyType__PackageableElement.initOperations(_AnyType__PackageableElement);
			Fragments._AnyType__ParameterableElement.initOperations(_AnyType__ParameterableElement);
			Fragments._AnyType__TemplateableElement.initOperations(_AnyType__TemplateableElement);
			Fragments._AnyType__Type.initOperations(_AnyType__Type);
			Fragments._AnyType__Visitable.initOperations(_AnyType__Visitable);

			Fragments._AssociationClass__AssociationClass.initOperations(_AssociationClass__AssociationClass);
			Fragments._AssociationClass__Class.initOperations(_AssociationClass__Class);
			Fragments._AssociationClass__Element.initOperations(_AssociationClass__Element);
			Fragments._AssociationClass__Nameable.initOperations(_AssociationClass__Nameable);
			Fragments._AssociationClass__NamedElement.initOperations(_AssociationClass__NamedElement);
			Fragments._AssociationClass__Namespace.initOperations(_AssociationClass__Namespace);
			Fragments._AssociationClass__OclAny.initOperations(_AssociationClass__OclAny);
			Fragments._AssociationClass__OclElement.initOperations(_AssociationClass__OclElement);
			Fragments._AssociationClass__OclType.initOperations(_AssociationClass__OclType);
			Fragments._AssociationClass__PackageableElement.initOperations(_AssociationClass__PackageableElement);
			Fragments._AssociationClass__ParameterableElement.initOperations(_AssociationClass__ParameterableElement);
			Fragments._AssociationClass__TemplateableElement.initOperations(_AssociationClass__TemplateableElement);
			Fragments._AssociationClass__Type.initOperations(_AssociationClass__Type);
			Fragments._AssociationClass__Visitable.initOperations(_AssociationClass__Visitable);

			Fragments._AssociationClassCallExp__AssociationClassCallExp.initOperations(_AssociationClassCallExp__AssociationClassCallExp);
			Fragments._AssociationClassCallExp__CallExp.initOperations(_AssociationClassCallExp__CallExp);
			Fragments._AssociationClassCallExp__Element.initOperations(_AssociationClassCallExp__Element);
			Fragments._AssociationClassCallExp__FeatureCallExp.initOperations(_AssociationClassCallExp__FeatureCallExp);
			Fragments._AssociationClassCallExp__Nameable.initOperations(_AssociationClassCallExp__Nameable);
			Fragments._AssociationClassCallExp__NamedElement.initOperations(_AssociationClassCallExp__NamedElement);
			Fragments._AssociationClassCallExp__NavigationCallExp.initOperations(_AssociationClassCallExp__NavigationCallExp);
			Fragments._AssociationClassCallExp__OCLExpression.initOperations(_AssociationClassCallExp__OCLExpression);
			Fragments._AssociationClassCallExp__OclAny.initOperations(_AssociationClassCallExp__OclAny);
			Fragments._AssociationClassCallExp__OclElement.initOperations(_AssociationClassCallExp__OclElement);
			Fragments._AssociationClassCallExp__TypedElement.initOperations(_AssociationClassCallExp__TypedElement);
			Fragments._AssociationClassCallExp__Visitable.initOperations(_AssociationClassCallExp__Visitable);

			Fragments._AssociativityKind__AssociativityKind.initOperations(_AssociativityKind__AssociativityKind);
			Fragments._AssociativityKind__Class.initOperations(_AssociativityKind__Class);
			Fragments._AssociativityKind__DataType.initOperations(_AssociativityKind__DataType);
			Fragments._AssociativityKind__Element.initOperations(_AssociativityKind__Element);
			Fragments._AssociativityKind__Enumeration.initOperations(_AssociativityKind__Enumeration);
			Fragments._AssociativityKind__Nameable.initOperations(_AssociativityKind__Nameable);
			Fragments._AssociativityKind__NamedElement.initOperations(_AssociativityKind__NamedElement);
			Fragments._AssociativityKind__Namespace.initOperations(_AssociativityKind__Namespace);
			Fragments._AssociativityKind__OclAny.initOperations(_AssociativityKind__OclAny);
			Fragments._AssociativityKind__OclElement.initOperations(_AssociativityKind__OclElement);
			Fragments._AssociativityKind__OclType.initOperations(_AssociativityKind__OclType);
			Fragments._AssociativityKind__PackageableElement.initOperations(_AssociativityKind__PackageableElement);
			Fragments._AssociativityKind__ParameterableElement.initOperations(_AssociativityKind__ParameterableElement);
			Fragments._AssociativityKind__TemplateableElement.initOperations(_AssociativityKind__TemplateableElement);
			Fragments._AssociativityKind__Type.initOperations(_AssociativityKind__Type);
			Fragments._AssociativityKind__Visitable.initOperations(_AssociativityKind__Visitable);

			Fragments._BagType__BagType.initOperations(_BagType__BagType);
			Fragments._BagType__Class.initOperations(_BagType__Class);
			Fragments._BagType__CollectionType.initOperations(_BagType__CollectionType);
			Fragments._BagType__DataType.initOperations(_BagType__DataType);
			Fragments._BagType__Element.initOperations(_BagType__Element);
			Fragments._BagType__Nameable.initOperations(_BagType__Nameable);
			Fragments._BagType__NamedElement.initOperations(_BagType__NamedElement);
			Fragments._BagType__Namespace.initOperations(_BagType__Namespace);
			Fragments._BagType__OclAny.initOperations(_BagType__OclAny);
			Fragments._BagType__OclElement.initOperations(_BagType__OclElement);
			Fragments._BagType__OclType.initOperations(_BagType__OclType);
			Fragments._BagType__PackageableElement.initOperations(_BagType__PackageableElement);
			Fragments._BagType__ParameterableElement.initOperations(_BagType__ParameterableElement);
			Fragments._BagType__TemplateableElement.initOperations(_BagType__TemplateableElement);
			Fragments._BagType__Type.initOperations(_BagType__Type);
			Fragments._BagType__Visitable.initOperations(_BagType__Visitable);

			Fragments._Behavior__Behavior.initOperations(_Behavior__Behavior);
			Fragments._Behavior__Class.initOperations(_Behavior__Class);
			Fragments._Behavior__Element.initOperations(_Behavior__Element);
			Fragments._Behavior__Nameable.initOperations(_Behavior__Nameable);
			Fragments._Behavior__NamedElement.initOperations(_Behavior__NamedElement);
			Fragments._Behavior__Namespace.initOperations(_Behavior__Namespace);
			Fragments._Behavior__OclAny.initOperations(_Behavior__OclAny);
			Fragments._Behavior__OclElement.initOperations(_Behavior__OclElement);
			Fragments._Behavior__OclType.initOperations(_Behavior__OclType);
			Fragments._Behavior__PackageableElement.initOperations(_Behavior__PackageableElement);
			Fragments._Behavior__ParameterableElement.initOperations(_Behavior__ParameterableElement);
			Fragments._Behavior__TemplateableElement.initOperations(_Behavior__TemplateableElement);
			Fragments._Behavior__Type.initOperations(_Behavior__Type);
			Fragments._Behavior__Visitable.initOperations(_Behavior__Visitable);

			Fragments._BooleanLiteralExp__BooleanLiteralExp.initOperations(_BooleanLiteralExp__BooleanLiteralExp);
			Fragments._BooleanLiteralExp__Element.initOperations(_BooleanLiteralExp__Element);
			Fragments._BooleanLiteralExp__LiteralExp.initOperations(_BooleanLiteralExp__LiteralExp);
			Fragments._BooleanLiteralExp__Nameable.initOperations(_BooleanLiteralExp__Nameable);
			Fragments._BooleanLiteralExp__NamedElement.initOperations(_BooleanLiteralExp__NamedElement);
			Fragments._BooleanLiteralExp__OCLExpression.initOperations(_BooleanLiteralExp__OCLExpression);
			Fragments._BooleanLiteralExp__OclAny.initOperations(_BooleanLiteralExp__OclAny);
			Fragments._BooleanLiteralExp__OclElement.initOperations(_BooleanLiteralExp__OclElement);
			Fragments._BooleanLiteralExp__PrimitiveLiteralExp.initOperations(_BooleanLiteralExp__PrimitiveLiteralExp);
			Fragments._BooleanLiteralExp__TypedElement.initOperations(_BooleanLiteralExp__TypedElement);
			Fragments._BooleanLiteralExp__Visitable.initOperations(_BooleanLiteralExp__Visitable);

			Fragments._CallExp__CallExp.initOperations(_CallExp__CallExp);
			Fragments._CallExp__Element.initOperations(_CallExp__Element);
			Fragments._CallExp__Nameable.initOperations(_CallExp__Nameable);
			Fragments._CallExp__NamedElement.initOperations(_CallExp__NamedElement);
			Fragments._CallExp__OCLExpression.initOperations(_CallExp__OCLExpression);
			Fragments._CallExp__OclAny.initOperations(_CallExp__OclAny);
			Fragments._CallExp__OclElement.initOperations(_CallExp__OclElement);
			Fragments._CallExp__TypedElement.initOperations(_CallExp__TypedElement);
			Fragments._CallExp__Visitable.initOperations(_CallExp__Visitable);

			Fragments._CallOperationAction__CallOperationAction.initOperations(_CallOperationAction__CallOperationAction);
			Fragments._CallOperationAction__Element.initOperations(_CallOperationAction__Element);
			Fragments._CallOperationAction__Nameable.initOperations(_CallOperationAction__Nameable);
			Fragments._CallOperationAction__NamedElement.initOperations(_CallOperationAction__NamedElement);
			Fragments._CallOperationAction__OclAny.initOperations(_CallOperationAction__OclAny);
			Fragments._CallOperationAction__OclElement.initOperations(_CallOperationAction__OclElement);
			Fragments._CallOperationAction__Visitable.initOperations(_CallOperationAction__Visitable);

			Fragments._Class__Class.initOperations(_Class__Class);
			Fragments._Class__Element.initOperations(_Class__Element);
			Fragments._Class__Nameable.initOperations(_Class__Nameable);
			Fragments._Class__NamedElement.initOperations(_Class__NamedElement);
			Fragments._Class__Namespace.initOperations(_Class__Namespace);
			Fragments._Class__OclAny.initOperations(_Class__OclAny);
			Fragments._Class__OclElement.initOperations(_Class__OclElement);
			Fragments._Class__OclType.initOperations(_Class__OclType);
			Fragments._Class__PackageableElement.initOperations(_Class__PackageableElement);
			Fragments._Class__ParameterableElement.initOperations(_Class__ParameterableElement);
			Fragments._Class__TemplateableElement.initOperations(_Class__TemplateableElement);
			Fragments._Class__Type.initOperations(_Class__Type);
			Fragments._Class__Visitable.initOperations(_Class__Visitable);

			Fragments._CollectionItem__CollectionItem.initOperations(_CollectionItem__CollectionItem);
			Fragments._CollectionItem__CollectionLiteralPart.initOperations(_CollectionItem__CollectionLiteralPart);
			Fragments._CollectionItem__Element.initOperations(_CollectionItem__Element);
			Fragments._CollectionItem__Nameable.initOperations(_CollectionItem__Nameable);
			Fragments._CollectionItem__NamedElement.initOperations(_CollectionItem__NamedElement);
			Fragments._CollectionItem__OclAny.initOperations(_CollectionItem__OclAny);
			Fragments._CollectionItem__OclElement.initOperations(_CollectionItem__OclElement);
			Fragments._CollectionItem__TypedElement.initOperations(_CollectionItem__TypedElement);
			Fragments._CollectionItem__Visitable.initOperations(_CollectionItem__Visitable);

			Fragments._CollectionKind__Class.initOperations(_CollectionKind__Class);
			Fragments._CollectionKind__CollectionKind.initOperations(_CollectionKind__CollectionKind);
			Fragments._CollectionKind__DataType.initOperations(_CollectionKind__DataType);
			Fragments._CollectionKind__Element.initOperations(_CollectionKind__Element);
			Fragments._CollectionKind__Enumeration.initOperations(_CollectionKind__Enumeration);
			Fragments._CollectionKind__Nameable.initOperations(_CollectionKind__Nameable);
			Fragments._CollectionKind__NamedElement.initOperations(_CollectionKind__NamedElement);
			Fragments._CollectionKind__Namespace.initOperations(_CollectionKind__Namespace);
			Fragments._CollectionKind__OclAny.initOperations(_CollectionKind__OclAny);
			Fragments._CollectionKind__OclElement.initOperations(_CollectionKind__OclElement);
			Fragments._CollectionKind__OclType.initOperations(_CollectionKind__OclType);
			Fragments._CollectionKind__PackageableElement.initOperations(_CollectionKind__PackageableElement);
			Fragments._CollectionKind__ParameterableElement.initOperations(_CollectionKind__ParameterableElement);
			Fragments._CollectionKind__TemplateableElement.initOperations(_CollectionKind__TemplateableElement);
			Fragments._CollectionKind__Type.initOperations(_CollectionKind__Type);
			Fragments._CollectionKind__Visitable.initOperations(_CollectionKind__Visitable);

			Fragments._CollectionLiteralExp__CollectionLiteralExp.initOperations(_CollectionLiteralExp__CollectionLiteralExp);
			Fragments._CollectionLiteralExp__Element.initOperations(_CollectionLiteralExp__Element);
			Fragments._CollectionLiteralExp__LiteralExp.initOperations(_CollectionLiteralExp__LiteralExp);
			Fragments._CollectionLiteralExp__Nameable.initOperations(_CollectionLiteralExp__Nameable);
			Fragments._CollectionLiteralExp__NamedElement.initOperations(_CollectionLiteralExp__NamedElement);
			Fragments._CollectionLiteralExp__OCLExpression.initOperations(_CollectionLiteralExp__OCLExpression);
			Fragments._CollectionLiteralExp__OclAny.initOperations(_CollectionLiteralExp__OclAny);
			Fragments._CollectionLiteralExp__OclElement.initOperations(_CollectionLiteralExp__OclElement);
			Fragments._CollectionLiteralExp__TypedElement.initOperations(_CollectionLiteralExp__TypedElement);
			Fragments._CollectionLiteralExp__Visitable.initOperations(_CollectionLiteralExp__Visitable);

			Fragments._CollectionLiteralPart__CollectionLiteralPart.initOperations(_CollectionLiteralPart__CollectionLiteralPart);
			Fragments._CollectionLiteralPart__Element.initOperations(_CollectionLiteralPart__Element);
			Fragments._CollectionLiteralPart__Nameable.initOperations(_CollectionLiteralPart__Nameable);
			Fragments._CollectionLiteralPart__NamedElement.initOperations(_CollectionLiteralPart__NamedElement);
			Fragments._CollectionLiteralPart__OclAny.initOperations(_CollectionLiteralPart__OclAny);
			Fragments._CollectionLiteralPart__OclElement.initOperations(_CollectionLiteralPart__OclElement);
			Fragments._CollectionLiteralPart__TypedElement.initOperations(_CollectionLiteralPart__TypedElement);
			Fragments._CollectionLiteralPart__Visitable.initOperations(_CollectionLiteralPart__Visitable);

			Fragments._CollectionRange__CollectionLiteralPart.initOperations(_CollectionRange__CollectionLiteralPart);
			Fragments._CollectionRange__CollectionRange.initOperations(_CollectionRange__CollectionRange);
			Fragments._CollectionRange__Element.initOperations(_CollectionRange__Element);
			Fragments._CollectionRange__Nameable.initOperations(_CollectionRange__Nameable);
			Fragments._CollectionRange__NamedElement.initOperations(_CollectionRange__NamedElement);
			Fragments._CollectionRange__OclAny.initOperations(_CollectionRange__OclAny);
			Fragments._CollectionRange__OclElement.initOperations(_CollectionRange__OclElement);
			Fragments._CollectionRange__TypedElement.initOperations(_CollectionRange__TypedElement);
			Fragments._CollectionRange__Visitable.initOperations(_CollectionRange__Visitable);

			Fragments._CollectionType__Class.initOperations(_CollectionType__Class);
			Fragments._CollectionType__CollectionType.initOperations(_CollectionType__CollectionType);
			Fragments._CollectionType__DataType.initOperations(_CollectionType__DataType);
			Fragments._CollectionType__Element.initOperations(_CollectionType__Element);
			Fragments._CollectionType__Nameable.initOperations(_CollectionType__Nameable);
			Fragments._CollectionType__NamedElement.initOperations(_CollectionType__NamedElement);
			Fragments._CollectionType__Namespace.initOperations(_CollectionType__Namespace);
			Fragments._CollectionType__OclAny.initOperations(_CollectionType__OclAny);
			Fragments._CollectionType__OclElement.initOperations(_CollectionType__OclElement);
			Fragments._CollectionType__OclType.initOperations(_CollectionType__OclType);
			Fragments._CollectionType__PackageableElement.initOperations(_CollectionType__PackageableElement);
			Fragments._CollectionType__ParameterableElement.initOperations(_CollectionType__ParameterableElement);
			Fragments._CollectionType__TemplateableElement.initOperations(_CollectionType__TemplateableElement);
			Fragments._CollectionType__Type.initOperations(_CollectionType__Type);
			Fragments._CollectionType__Visitable.initOperations(_CollectionType__Visitable);

			Fragments._Comment__Comment.initOperations(_Comment__Comment);
			Fragments._Comment__Element.initOperations(_Comment__Element);
			Fragments._Comment__OclAny.initOperations(_Comment__OclAny);
			Fragments._Comment__OclElement.initOperations(_Comment__OclElement);
			Fragments._Comment__Visitable.initOperations(_Comment__Visitable);

			Fragments._ConnectionPointReference__ConnectionPointReference.initOperations(_ConnectionPointReference__ConnectionPointReference);
			Fragments._ConnectionPointReference__Element.initOperations(_ConnectionPointReference__Element);
			Fragments._ConnectionPointReference__Nameable.initOperations(_ConnectionPointReference__Nameable);
			Fragments._ConnectionPointReference__NamedElement.initOperations(_ConnectionPointReference__NamedElement);
			Fragments._ConnectionPointReference__OclAny.initOperations(_ConnectionPointReference__OclAny);
			Fragments._ConnectionPointReference__OclElement.initOperations(_ConnectionPointReference__OclElement);
			Fragments._ConnectionPointReference__Vertex.initOperations(_ConnectionPointReference__Vertex);
			Fragments._ConnectionPointReference__Visitable.initOperations(_ConnectionPointReference__Visitable);

			Fragments._Constraint__Constraint.initOperations(_Constraint__Constraint);
			Fragments._Constraint__Element.initOperations(_Constraint__Element);
			Fragments._Constraint__Nameable.initOperations(_Constraint__Nameable);
			Fragments._Constraint__NamedElement.initOperations(_Constraint__NamedElement);
			Fragments._Constraint__OclAny.initOperations(_Constraint__OclAny);
			Fragments._Constraint__OclElement.initOperations(_Constraint__OclElement);
			Fragments._Constraint__PackageableElement.initOperations(_Constraint__PackageableElement);
			Fragments._Constraint__ParameterableElement.initOperations(_Constraint__ParameterableElement);
			Fragments._Constraint__Visitable.initOperations(_Constraint__Visitable);

			Fragments._ConstructorExp__ConstructorExp.initOperations(_ConstructorExp__ConstructorExp);
			Fragments._ConstructorExp__Element.initOperations(_ConstructorExp__Element);
			Fragments._ConstructorExp__Nameable.initOperations(_ConstructorExp__Nameable);
			Fragments._ConstructorExp__NamedElement.initOperations(_ConstructorExp__NamedElement);
			Fragments._ConstructorExp__OCLExpression.initOperations(_ConstructorExp__OCLExpression);
			Fragments._ConstructorExp__OclAny.initOperations(_ConstructorExp__OclAny);
			Fragments._ConstructorExp__OclElement.initOperations(_ConstructorExp__OclElement);
			Fragments._ConstructorExp__TypedElement.initOperations(_ConstructorExp__TypedElement);
			Fragments._ConstructorExp__Visitable.initOperations(_ConstructorExp__Visitable);

			Fragments._ConstructorPart__ConstructorPart.initOperations(_ConstructorPart__ConstructorPart);
			Fragments._ConstructorPart__Element.initOperations(_ConstructorPart__Element);
			Fragments._ConstructorPart__Nameable.initOperations(_ConstructorPart__Nameable);
			Fragments._ConstructorPart__NamedElement.initOperations(_ConstructorPart__NamedElement);
			Fragments._ConstructorPart__OclAny.initOperations(_ConstructorPart__OclAny);
			Fragments._ConstructorPart__OclElement.initOperations(_ConstructorPart__OclElement);
			Fragments._ConstructorPart__TypedElement.initOperations(_ConstructorPart__TypedElement);
			Fragments._ConstructorPart__Visitable.initOperations(_ConstructorPart__Visitable);

			Fragments._DataType__Class.initOperations(_DataType__Class);
			Fragments._DataType__DataType.initOperations(_DataType__DataType);
			Fragments._DataType__Element.initOperations(_DataType__Element);
			Fragments._DataType__Nameable.initOperations(_DataType__Nameable);
			Fragments._DataType__NamedElement.initOperations(_DataType__NamedElement);
			Fragments._DataType__Namespace.initOperations(_DataType__Namespace);
			Fragments._DataType__OclAny.initOperations(_DataType__OclAny);
			Fragments._DataType__OclElement.initOperations(_DataType__OclElement);
			Fragments._DataType__OclType.initOperations(_DataType__OclType);
			Fragments._DataType__PackageableElement.initOperations(_DataType__PackageableElement);
			Fragments._DataType__ParameterableElement.initOperations(_DataType__ParameterableElement);
			Fragments._DataType__TemplateableElement.initOperations(_DataType__TemplateableElement);
			Fragments._DataType__Type.initOperations(_DataType__Type);
			Fragments._DataType__Visitable.initOperations(_DataType__Visitable);

			Fragments._Detail__Detail.initOperations(_Detail__Detail);
			Fragments._Detail__Element.initOperations(_Detail__Element);
			Fragments._Detail__Nameable.initOperations(_Detail__Nameable);
			Fragments._Detail__NamedElement.initOperations(_Detail__NamedElement);
			Fragments._Detail__OclAny.initOperations(_Detail__OclAny);
			Fragments._Detail__OclElement.initOperations(_Detail__OclElement);
			Fragments._Detail__Visitable.initOperations(_Detail__Visitable);

			Fragments._DynamicElement__DynamicElement.initOperations(_DynamicElement__DynamicElement);
			Fragments._DynamicElement__Element.initOperations(_DynamicElement__Element);
			Fragments._DynamicElement__OclAny.initOperations(_DynamicElement__OclAny);
			Fragments._DynamicElement__OclElement.initOperations(_DynamicElement__OclElement);
			Fragments._DynamicElement__Visitable.initOperations(_DynamicElement__Visitable);

			Fragments._DynamicProperty__DynamicProperty.initOperations(_DynamicProperty__DynamicProperty);
			Fragments._DynamicProperty__Element.initOperations(_DynamicProperty__Element);
			Fragments._DynamicProperty__OclAny.initOperations(_DynamicProperty__OclAny);
			Fragments._DynamicProperty__OclElement.initOperations(_DynamicProperty__OclElement);
			Fragments._DynamicProperty__Visitable.initOperations(_DynamicProperty__Visitable);

			Fragments._DynamicType__DynamicElement.initOperations(_DynamicType__DynamicElement);
			Fragments._DynamicType__DynamicType.initOperations(_DynamicType__DynamicType);
			Fragments._DynamicType__Element.initOperations(_DynamicType__Element);
			Fragments._DynamicType__Nameable.initOperations(_DynamicType__Nameable);
			Fragments._DynamicType__NamedElement.initOperations(_DynamicType__NamedElement);
			Fragments._DynamicType__OclAny.initOperations(_DynamicType__OclAny);
			Fragments._DynamicType__OclElement.initOperations(_DynamicType__OclElement);
			Fragments._DynamicType__OclType.initOperations(_DynamicType__OclType);
			Fragments._DynamicType__PackageableElement.initOperations(_DynamicType__PackageableElement);
			Fragments._DynamicType__ParameterableElement.initOperations(_DynamicType__ParameterableElement);
			Fragments._DynamicType__TemplateableElement.initOperations(_DynamicType__TemplateableElement);
			Fragments._DynamicType__Type.initOperations(_DynamicType__Type);
			Fragments._DynamicType__Visitable.initOperations(_DynamicType__Visitable);

			Fragments._Element__Element.initOperations(_Element__Element);
			Fragments._Element__OclAny.initOperations(_Element__OclAny);
			Fragments._Element__OclElement.initOperations(_Element__OclElement);
			Fragments._Element__Visitable.initOperations(_Element__Visitable);

			Fragments._ElementExtension__Element.initOperations(_ElementExtension__Element);
			Fragments._ElementExtension__ElementExtension.initOperations(_ElementExtension__ElementExtension);
			Fragments._ElementExtension__Nameable.initOperations(_ElementExtension__Nameable);
			Fragments._ElementExtension__NamedElement.initOperations(_ElementExtension__NamedElement);
			Fragments._ElementExtension__OclAny.initOperations(_ElementExtension__OclAny);
			Fragments._ElementExtension__OclElement.initOperations(_ElementExtension__OclElement);
			Fragments._ElementExtension__OclType.initOperations(_ElementExtension__OclType);
			Fragments._ElementExtension__PackageableElement.initOperations(_ElementExtension__PackageableElement);
			Fragments._ElementExtension__ParameterableElement.initOperations(_ElementExtension__ParameterableElement);
			Fragments._ElementExtension__TemplateableElement.initOperations(_ElementExtension__TemplateableElement);
			Fragments._ElementExtension__Type.initOperations(_ElementExtension__Type);
			Fragments._ElementExtension__Visitable.initOperations(_ElementExtension__Visitable);

			Fragments._EnumLiteralExp__Element.initOperations(_EnumLiteralExp__Element);
			Fragments._EnumLiteralExp__EnumLiteralExp.initOperations(_EnumLiteralExp__EnumLiteralExp);
			Fragments._EnumLiteralExp__LiteralExp.initOperations(_EnumLiteralExp__LiteralExp);
			Fragments._EnumLiteralExp__Nameable.initOperations(_EnumLiteralExp__Nameable);
			Fragments._EnumLiteralExp__NamedElement.initOperations(_EnumLiteralExp__NamedElement);
			Fragments._EnumLiteralExp__OCLExpression.initOperations(_EnumLiteralExp__OCLExpression);
			Fragments._EnumLiteralExp__OclAny.initOperations(_EnumLiteralExp__OclAny);
			Fragments._EnumLiteralExp__OclElement.initOperations(_EnumLiteralExp__OclElement);
			Fragments._EnumLiteralExp__TypedElement.initOperations(_EnumLiteralExp__TypedElement);
			Fragments._EnumLiteralExp__Visitable.initOperations(_EnumLiteralExp__Visitable);

			Fragments._Enumeration__Class.initOperations(_Enumeration__Class);
			Fragments._Enumeration__DataType.initOperations(_Enumeration__DataType);
			Fragments._Enumeration__Element.initOperations(_Enumeration__Element);
			Fragments._Enumeration__Enumeration.initOperations(_Enumeration__Enumeration);
			Fragments._Enumeration__Nameable.initOperations(_Enumeration__Nameable);
			Fragments._Enumeration__NamedElement.initOperations(_Enumeration__NamedElement);
			Fragments._Enumeration__Namespace.initOperations(_Enumeration__Namespace);
			Fragments._Enumeration__OclAny.initOperations(_Enumeration__OclAny);
			Fragments._Enumeration__OclElement.initOperations(_Enumeration__OclElement);
			Fragments._Enumeration__OclType.initOperations(_Enumeration__OclType);
			Fragments._Enumeration__PackageableElement.initOperations(_Enumeration__PackageableElement);
			Fragments._Enumeration__ParameterableElement.initOperations(_Enumeration__ParameterableElement);
			Fragments._Enumeration__TemplateableElement.initOperations(_Enumeration__TemplateableElement);
			Fragments._Enumeration__Type.initOperations(_Enumeration__Type);
			Fragments._Enumeration__Visitable.initOperations(_Enumeration__Visitable);

			Fragments._EnumerationLiteral__Element.initOperations(_EnumerationLiteral__Element);
			Fragments._EnumerationLiteral__EnumerationLiteral.initOperations(_EnumerationLiteral__EnumerationLiteral);
			Fragments._EnumerationLiteral__Nameable.initOperations(_EnumerationLiteral__Nameable);
			Fragments._EnumerationLiteral__NamedElement.initOperations(_EnumerationLiteral__NamedElement);
			Fragments._EnumerationLiteral__OclAny.initOperations(_EnumerationLiteral__OclAny);
			Fragments._EnumerationLiteral__OclElement.initOperations(_EnumerationLiteral__OclElement);
			Fragments._EnumerationLiteral__PackageableElement.initOperations(_EnumerationLiteral__PackageableElement);
			Fragments._EnumerationLiteral__ParameterableElement.initOperations(_EnumerationLiteral__ParameterableElement);
			Fragments._EnumerationLiteral__Visitable.initOperations(_EnumerationLiteral__Visitable);

			Fragments._ExpressionInOCL__Element.initOperations(_ExpressionInOCL__Element);
			Fragments._ExpressionInOCL__ExpressionInOCL.initOperations(_ExpressionInOCL__ExpressionInOCL);
			Fragments._ExpressionInOCL__Nameable.initOperations(_ExpressionInOCL__Nameable);
			Fragments._ExpressionInOCL__NamedElement.initOperations(_ExpressionInOCL__NamedElement);
			Fragments._ExpressionInOCL__OclAny.initOperations(_ExpressionInOCL__OclAny);
			Fragments._ExpressionInOCL__OclElement.initOperations(_ExpressionInOCL__OclElement);
			Fragments._ExpressionInOCL__OpaqueExpression.initOperations(_ExpressionInOCL__OpaqueExpression);
			Fragments._ExpressionInOCL__PackageableElement.initOperations(_ExpressionInOCL__PackageableElement);
			Fragments._ExpressionInOCL__ParameterableElement.initOperations(_ExpressionInOCL__ParameterableElement);
			Fragments._ExpressionInOCL__TypedElement.initOperations(_ExpressionInOCL__TypedElement);
			Fragments._ExpressionInOCL__ValueSpecification.initOperations(_ExpressionInOCL__ValueSpecification);
			Fragments._ExpressionInOCL__Visitable.initOperations(_ExpressionInOCL__Visitable);

			Fragments._Feature__Element.initOperations(_Feature__Element);
			Fragments._Feature__Feature.initOperations(_Feature__Feature);
			Fragments._Feature__Nameable.initOperations(_Feature__Nameable);
			Fragments._Feature__NamedElement.initOperations(_Feature__NamedElement);
			Fragments._Feature__OclAny.initOperations(_Feature__OclAny);
			Fragments._Feature__OclElement.initOperations(_Feature__OclElement);
			Fragments._Feature__TypedElement.initOperations(_Feature__TypedElement);
			Fragments._Feature__TypedMultiplicityElement.initOperations(_Feature__TypedMultiplicityElement);
			Fragments._Feature__Visitable.initOperations(_Feature__Visitable);

			Fragments._FeatureCallExp__CallExp.initOperations(_FeatureCallExp__CallExp);
			Fragments._FeatureCallExp__Element.initOperations(_FeatureCallExp__Element);
			Fragments._FeatureCallExp__FeatureCallExp.initOperations(_FeatureCallExp__FeatureCallExp);
			Fragments._FeatureCallExp__Nameable.initOperations(_FeatureCallExp__Nameable);
			Fragments._FeatureCallExp__NamedElement.initOperations(_FeatureCallExp__NamedElement);
			Fragments._FeatureCallExp__OCLExpression.initOperations(_FeatureCallExp__OCLExpression);
			Fragments._FeatureCallExp__OclAny.initOperations(_FeatureCallExp__OclAny);
			Fragments._FeatureCallExp__OclElement.initOperations(_FeatureCallExp__OclElement);
			Fragments._FeatureCallExp__TypedElement.initOperations(_FeatureCallExp__TypedElement);
			Fragments._FeatureCallExp__Visitable.initOperations(_FeatureCallExp__Visitable);

			Fragments._FinalState__Element.initOperations(_FinalState__Element);
			Fragments._FinalState__FinalState.initOperations(_FinalState__FinalState);
			Fragments._FinalState__Nameable.initOperations(_FinalState__Nameable);
			Fragments._FinalState__NamedElement.initOperations(_FinalState__NamedElement);
			Fragments._FinalState__Namespace.initOperations(_FinalState__Namespace);
			Fragments._FinalState__OclAny.initOperations(_FinalState__OclAny);
			Fragments._FinalState__OclElement.initOperations(_FinalState__OclElement);
			Fragments._FinalState__OclState.initOperations(_FinalState__OclState);
			Fragments._FinalState__State.initOperations(_FinalState__State);
			Fragments._FinalState__Vertex.initOperations(_FinalState__Vertex);
			Fragments._FinalState__Visitable.initOperations(_FinalState__Visitable);

			Fragments._IfExp__Element.initOperations(_IfExp__Element);
			Fragments._IfExp__IfExp.initOperations(_IfExp__IfExp);
			Fragments._IfExp__Nameable.initOperations(_IfExp__Nameable);
			Fragments._IfExp__NamedElement.initOperations(_IfExp__NamedElement);
			Fragments._IfExp__OCLExpression.initOperations(_IfExp__OCLExpression);
			Fragments._IfExp__OclAny.initOperations(_IfExp__OclAny);
			Fragments._IfExp__OclElement.initOperations(_IfExp__OclElement);
			Fragments._IfExp__TypedElement.initOperations(_IfExp__TypedElement);
			Fragments._IfExp__Visitable.initOperations(_IfExp__Visitable);

			Fragments._Import__Element.initOperations(_Import__Element);
			Fragments._Import__Import.initOperations(_Import__Import);
			Fragments._Import__Nameable.initOperations(_Import__Nameable);
			Fragments._Import__NamedElement.initOperations(_Import__NamedElement);
			Fragments._Import__OclAny.initOperations(_Import__OclAny);
			Fragments._Import__OclElement.initOperations(_Import__OclElement);
			Fragments._Import__Visitable.initOperations(_Import__Visitable);

			Fragments._IntegerLiteralExp__Element.initOperations(_IntegerLiteralExp__Element);
			Fragments._IntegerLiteralExp__IntegerLiteralExp.initOperations(_IntegerLiteralExp__IntegerLiteralExp);
			Fragments._IntegerLiteralExp__LiteralExp.initOperations(_IntegerLiteralExp__LiteralExp);
			Fragments._IntegerLiteralExp__Nameable.initOperations(_IntegerLiteralExp__Nameable);
			Fragments._IntegerLiteralExp__NamedElement.initOperations(_IntegerLiteralExp__NamedElement);
			Fragments._IntegerLiteralExp__NumericLiteralExp.initOperations(_IntegerLiteralExp__NumericLiteralExp);
			Fragments._IntegerLiteralExp__OCLExpression.initOperations(_IntegerLiteralExp__OCLExpression);
			Fragments._IntegerLiteralExp__OclAny.initOperations(_IntegerLiteralExp__OclAny);
			Fragments._IntegerLiteralExp__OclElement.initOperations(_IntegerLiteralExp__OclElement);
			Fragments._IntegerLiteralExp__PrimitiveLiteralExp.initOperations(_IntegerLiteralExp__PrimitiveLiteralExp);
			Fragments._IntegerLiteralExp__TypedElement.initOperations(_IntegerLiteralExp__TypedElement);
			Fragments._IntegerLiteralExp__Visitable.initOperations(_IntegerLiteralExp__Visitable);

			Fragments._InvalidLiteralExp__Element.initOperations(_InvalidLiteralExp__Element);
			Fragments._InvalidLiteralExp__InvalidLiteralExp.initOperations(_InvalidLiteralExp__InvalidLiteralExp);
			Fragments._InvalidLiteralExp__LiteralExp.initOperations(_InvalidLiteralExp__LiteralExp);
			Fragments._InvalidLiteralExp__Nameable.initOperations(_InvalidLiteralExp__Nameable);
			Fragments._InvalidLiteralExp__NamedElement.initOperations(_InvalidLiteralExp__NamedElement);
			Fragments._InvalidLiteralExp__OCLExpression.initOperations(_InvalidLiteralExp__OCLExpression);
			Fragments._InvalidLiteralExp__OclAny.initOperations(_InvalidLiteralExp__OclAny);
			Fragments._InvalidLiteralExp__OclElement.initOperations(_InvalidLiteralExp__OclElement);
			Fragments._InvalidLiteralExp__TypedElement.initOperations(_InvalidLiteralExp__TypedElement);
			Fragments._InvalidLiteralExp__Visitable.initOperations(_InvalidLiteralExp__Visitable);

			Fragments._InvalidType__Class.initOperations(_InvalidType__Class);
			Fragments._InvalidType__Element.initOperations(_InvalidType__Element);
			Fragments._InvalidType__InvalidType.initOperations(_InvalidType__InvalidType);
			Fragments._InvalidType__Nameable.initOperations(_InvalidType__Nameable);
			Fragments._InvalidType__NamedElement.initOperations(_InvalidType__NamedElement);
			Fragments._InvalidType__Namespace.initOperations(_InvalidType__Namespace);
			Fragments._InvalidType__OclAny.initOperations(_InvalidType__OclAny);
			Fragments._InvalidType__OclElement.initOperations(_InvalidType__OclElement);
			Fragments._InvalidType__OclType.initOperations(_InvalidType__OclType);
			Fragments._InvalidType__PackageableElement.initOperations(_InvalidType__PackageableElement);
			Fragments._InvalidType__ParameterableElement.initOperations(_InvalidType__ParameterableElement);
			Fragments._InvalidType__TemplateableElement.initOperations(_InvalidType__TemplateableElement);
			Fragments._InvalidType__Type.initOperations(_InvalidType__Type);
			Fragments._InvalidType__Visitable.initOperations(_InvalidType__Visitable);

			Fragments._IterateExp__CallExp.initOperations(_IterateExp__CallExp);
			Fragments._IterateExp__Element.initOperations(_IterateExp__Element);
			Fragments._IterateExp__IterateExp.initOperations(_IterateExp__IterateExp);
			Fragments._IterateExp__LoopExp.initOperations(_IterateExp__LoopExp);
			Fragments._IterateExp__Nameable.initOperations(_IterateExp__Nameable);
			Fragments._IterateExp__NamedElement.initOperations(_IterateExp__NamedElement);
			Fragments._IterateExp__OCLExpression.initOperations(_IterateExp__OCLExpression);
			Fragments._IterateExp__OclAny.initOperations(_IterateExp__OclAny);
			Fragments._IterateExp__OclElement.initOperations(_IterateExp__OclElement);
			Fragments._IterateExp__ReferringElement.initOperations(_IterateExp__ReferringElement);
			Fragments._IterateExp__TypedElement.initOperations(_IterateExp__TypedElement);
			Fragments._IterateExp__Visitable.initOperations(_IterateExp__Visitable);

			Fragments._Iteration__Element.initOperations(_Iteration__Element);
			Fragments._Iteration__Feature.initOperations(_Iteration__Feature);
			Fragments._Iteration__Iteration.initOperations(_Iteration__Iteration);
			Fragments._Iteration__Nameable.initOperations(_Iteration__Nameable);
			Fragments._Iteration__NamedElement.initOperations(_Iteration__NamedElement);
			Fragments._Iteration__Namespace.initOperations(_Iteration__Namespace);
			Fragments._Iteration__OclAny.initOperations(_Iteration__OclAny);
			Fragments._Iteration__OclElement.initOperations(_Iteration__OclElement);
			Fragments._Iteration__Operation.initOperations(_Iteration__Operation);
			Fragments._Iteration__ParameterableElement.initOperations(_Iteration__ParameterableElement);
			Fragments._Iteration__TemplateableElement.initOperations(_Iteration__TemplateableElement);
			Fragments._Iteration__TypedElement.initOperations(_Iteration__TypedElement);
			Fragments._Iteration__TypedMultiplicityElement.initOperations(_Iteration__TypedMultiplicityElement);
			Fragments._Iteration__Visitable.initOperations(_Iteration__Visitable);

			Fragments._IteratorExp__CallExp.initOperations(_IteratorExp__CallExp);
			Fragments._IteratorExp__Element.initOperations(_IteratorExp__Element);
			Fragments._IteratorExp__IteratorExp.initOperations(_IteratorExp__IteratorExp);
			Fragments._IteratorExp__LoopExp.initOperations(_IteratorExp__LoopExp);
			Fragments._IteratorExp__Nameable.initOperations(_IteratorExp__Nameable);
			Fragments._IteratorExp__NamedElement.initOperations(_IteratorExp__NamedElement);
			Fragments._IteratorExp__OCLExpression.initOperations(_IteratorExp__OCLExpression);
			Fragments._IteratorExp__OclAny.initOperations(_IteratorExp__OclAny);
			Fragments._IteratorExp__OclElement.initOperations(_IteratorExp__OclElement);
			Fragments._IteratorExp__ReferringElement.initOperations(_IteratorExp__ReferringElement);
			Fragments._IteratorExp__TypedElement.initOperations(_IteratorExp__TypedElement);
			Fragments._IteratorExp__Visitable.initOperations(_IteratorExp__Visitable);

			Fragments._LambdaType__Class.initOperations(_LambdaType__Class);
			Fragments._LambdaType__DataType.initOperations(_LambdaType__DataType);
			Fragments._LambdaType__Element.initOperations(_LambdaType__Element);
			Fragments._LambdaType__LambdaType.initOperations(_LambdaType__LambdaType);
			Fragments._LambdaType__Nameable.initOperations(_LambdaType__Nameable);
			Fragments._LambdaType__NamedElement.initOperations(_LambdaType__NamedElement);
			Fragments._LambdaType__Namespace.initOperations(_LambdaType__Namespace);
			Fragments._LambdaType__OclAny.initOperations(_LambdaType__OclAny);
			Fragments._LambdaType__OclElement.initOperations(_LambdaType__OclElement);
			Fragments._LambdaType__OclType.initOperations(_LambdaType__OclType);
			Fragments._LambdaType__PackageableElement.initOperations(_LambdaType__PackageableElement);
			Fragments._LambdaType__ParameterableElement.initOperations(_LambdaType__ParameterableElement);
			Fragments._LambdaType__TemplateableElement.initOperations(_LambdaType__TemplateableElement);
			Fragments._LambdaType__Type.initOperations(_LambdaType__Type);
			Fragments._LambdaType__Visitable.initOperations(_LambdaType__Visitable);

			Fragments._LetExp__Element.initOperations(_LetExp__Element);
			Fragments._LetExp__LetExp.initOperations(_LetExp__LetExp);
			Fragments._LetExp__Nameable.initOperations(_LetExp__Nameable);
			Fragments._LetExp__NamedElement.initOperations(_LetExp__NamedElement);
			Fragments._LetExp__OCLExpression.initOperations(_LetExp__OCLExpression);
			Fragments._LetExp__OclAny.initOperations(_LetExp__OclAny);
			Fragments._LetExp__OclElement.initOperations(_LetExp__OclElement);
			Fragments._LetExp__TypedElement.initOperations(_LetExp__TypedElement);
			Fragments._LetExp__Visitable.initOperations(_LetExp__Visitable);

			Fragments._Library__Element.initOperations(_Library__Element);
			Fragments._Library__Library.initOperations(_Library__Library);
			Fragments._Library__Nameable.initOperations(_Library__Nameable);
			Fragments._Library__NamedElement.initOperations(_Library__NamedElement);
			Fragments._Library__Namespace.initOperations(_Library__Namespace);
			Fragments._Library__OclAny.initOperations(_Library__OclAny);
			Fragments._Library__OclElement.initOperations(_Library__OclElement);
			Fragments._Library__Package.initOperations(_Library__Package);
			Fragments._Library__PackageableElement.initOperations(_Library__PackageableElement);
			Fragments._Library__ParameterableElement.initOperations(_Library__ParameterableElement);
			Fragments._Library__TemplateableElement.initOperations(_Library__TemplateableElement);
			Fragments._Library__Visitable.initOperations(_Library__Visitable);

			Fragments._LibraryFeature__LibraryFeature.initOperations(_LibraryFeature__LibraryFeature);
			Fragments._LibraryFeature__OclAny.initOperations(_LibraryFeature__OclAny);

			Fragments._LiteralExp__Element.initOperations(_LiteralExp__Element);
			Fragments._LiteralExp__LiteralExp.initOperations(_LiteralExp__LiteralExp);
			Fragments._LiteralExp__Nameable.initOperations(_LiteralExp__Nameable);
			Fragments._LiteralExp__NamedElement.initOperations(_LiteralExp__NamedElement);
			Fragments._LiteralExp__OCLExpression.initOperations(_LiteralExp__OCLExpression);
			Fragments._LiteralExp__OclAny.initOperations(_LiteralExp__OclAny);
			Fragments._LiteralExp__OclElement.initOperations(_LiteralExp__OclElement);
			Fragments._LiteralExp__TypedElement.initOperations(_LiteralExp__TypedElement);
			Fragments._LiteralExp__Visitable.initOperations(_LiteralExp__Visitable);

			Fragments._LoopExp__CallExp.initOperations(_LoopExp__CallExp);
			Fragments._LoopExp__Element.initOperations(_LoopExp__Element);
			Fragments._LoopExp__LoopExp.initOperations(_LoopExp__LoopExp);
			Fragments._LoopExp__Nameable.initOperations(_LoopExp__Nameable);
			Fragments._LoopExp__NamedElement.initOperations(_LoopExp__NamedElement);
			Fragments._LoopExp__OCLExpression.initOperations(_LoopExp__OCLExpression);
			Fragments._LoopExp__OclAny.initOperations(_LoopExp__OclAny);
			Fragments._LoopExp__OclElement.initOperations(_LoopExp__OclElement);
			Fragments._LoopExp__TypedElement.initOperations(_LoopExp__TypedElement);
			Fragments._LoopExp__Visitable.initOperations(_LoopExp__Visitable);

			Fragments._MessageExp__Element.initOperations(_MessageExp__Element);
			Fragments._MessageExp__MessageExp.initOperations(_MessageExp__MessageExp);
			Fragments._MessageExp__Nameable.initOperations(_MessageExp__Nameable);
			Fragments._MessageExp__NamedElement.initOperations(_MessageExp__NamedElement);
			Fragments._MessageExp__OCLExpression.initOperations(_MessageExp__OCLExpression);
			Fragments._MessageExp__OclAny.initOperations(_MessageExp__OclAny);
			Fragments._MessageExp__OclElement.initOperations(_MessageExp__OclElement);
			Fragments._MessageExp__TypedElement.initOperations(_MessageExp__TypedElement);
			Fragments._MessageExp__Visitable.initOperations(_MessageExp__Visitable);

			Fragments._MessageType__Element.initOperations(_MessageType__Element);
			Fragments._MessageType__MessageType.initOperations(_MessageType__MessageType);
			Fragments._MessageType__Nameable.initOperations(_MessageType__Nameable);
			Fragments._MessageType__NamedElement.initOperations(_MessageType__NamedElement);
			Fragments._MessageType__OclAny.initOperations(_MessageType__OclAny);
			Fragments._MessageType__OclElement.initOperations(_MessageType__OclElement);
			Fragments._MessageType__OclType.initOperations(_MessageType__OclType);
			Fragments._MessageType__PackageableElement.initOperations(_MessageType__PackageableElement);
			Fragments._MessageType__ParameterableElement.initOperations(_MessageType__ParameterableElement);
			Fragments._MessageType__TemplateableElement.initOperations(_MessageType__TemplateableElement);
			Fragments._MessageType__Type.initOperations(_MessageType__Type);
			Fragments._MessageType__Visitable.initOperations(_MessageType__Visitable);

			Fragments._Metaclass__Class.initOperations(_Metaclass__Class);
			Fragments._Metaclass__Element.initOperations(_Metaclass__Element);
			Fragments._Metaclass__Metaclass.initOperations(_Metaclass__Metaclass);
			Fragments._Metaclass__Nameable.initOperations(_Metaclass__Nameable);
			Fragments._Metaclass__NamedElement.initOperations(_Metaclass__NamedElement);
			Fragments._Metaclass__Namespace.initOperations(_Metaclass__Namespace);
			Fragments._Metaclass__OclAny.initOperations(_Metaclass__OclAny);
			Fragments._Metaclass__OclElement.initOperations(_Metaclass__OclElement);
			Fragments._Metaclass__OclType.initOperations(_Metaclass__OclType);
			Fragments._Metaclass__PackageableElement.initOperations(_Metaclass__PackageableElement);
			Fragments._Metaclass__ParameterableElement.initOperations(_Metaclass__ParameterableElement);
			Fragments._Metaclass__TemplateableElement.initOperations(_Metaclass__TemplateableElement);
			Fragments._Metaclass__Type.initOperations(_Metaclass__Type);
			Fragments._Metaclass__Visitable.initOperations(_Metaclass__Visitable);

			Fragments._MorePivotable__MorePivotable.initOperations(_MorePivotable__MorePivotable);
			Fragments._MorePivotable__OclAny.initOperations(_MorePivotable__OclAny);
			Fragments._MorePivotable__OclElement.initOperations(_MorePivotable__OclElement);

			Fragments._Nameable__Nameable.initOperations(_Nameable__Nameable);
			Fragments._Nameable__OclAny.initOperations(_Nameable__OclAny);
			Fragments._Nameable__OclElement.initOperations(_Nameable__OclElement);

			Fragments._NamedElement__Element.initOperations(_NamedElement__Element);
			Fragments._NamedElement__Nameable.initOperations(_NamedElement__Nameable);
			Fragments._NamedElement__NamedElement.initOperations(_NamedElement__NamedElement);
			Fragments._NamedElement__OclAny.initOperations(_NamedElement__OclAny);
			Fragments._NamedElement__OclElement.initOperations(_NamedElement__OclElement);
			Fragments._NamedElement__Visitable.initOperations(_NamedElement__Visitable);

			Fragments._Namespace__Element.initOperations(_Namespace__Element);
			Fragments._Namespace__Nameable.initOperations(_Namespace__Nameable);
			Fragments._Namespace__NamedElement.initOperations(_Namespace__NamedElement);
			Fragments._Namespace__Namespace.initOperations(_Namespace__Namespace);
			Fragments._Namespace__OclAny.initOperations(_Namespace__OclAny);
			Fragments._Namespace__OclElement.initOperations(_Namespace__OclElement);
			Fragments._Namespace__Visitable.initOperations(_Namespace__Visitable);

			Fragments._NavigationCallExp__CallExp.initOperations(_NavigationCallExp__CallExp);
			Fragments._NavigationCallExp__Element.initOperations(_NavigationCallExp__Element);
			Fragments._NavigationCallExp__FeatureCallExp.initOperations(_NavigationCallExp__FeatureCallExp);
			Fragments._NavigationCallExp__Nameable.initOperations(_NavigationCallExp__Nameable);
			Fragments._NavigationCallExp__NamedElement.initOperations(_NavigationCallExp__NamedElement);
			Fragments._NavigationCallExp__NavigationCallExp.initOperations(_NavigationCallExp__NavigationCallExp);
			Fragments._NavigationCallExp__OCLExpression.initOperations(_NavigationCallExp__OCLExpression);
			Fragments._NavigationCallExp__OclAny.initOperations(_NavigationCallExp__OclAny);
			Fragments._NavigationCallExp__OclElement.initOperations(_NavigationCallExp__OclElement);
			Fragments._NavigationCallExp__TypedElement.initOperations(_NavigationCallExp__TypedElement);
			Fragments._NavigationCallExp__Visitable.initOperations(_NavigationCallExp__Visitable);

			Fragments._NullLiteralExp__Element.initOperations(_NullLiteralExp__Element);
			Fragments._NullLiteralExp__LiteralExp.initOperations(_NullLiteralExp__LiteralExp);
			Fragments._NullLiteralExp__Nameable.initOperations(_NullLiteralExp__Nameable);
			Fragments._NullLiteralExp__NamedElement.initOperations(_NullLiteralExp__NamedElement);
			Fragments._NullLiteralExp__NullLiteralExp.initOperations(_NullLiteralExp__NullLiteralExp);
			Fragments._NullLiteralExp__OCLExpression.initOperations(_NullLiteralExp__OCLExpression);
			Fragments._NullLiteralExp__OclAny.initOperations(_NullLiteralExp__OclAny);
			Fragments._NullLiteralExp__OclElement.initOperations(_NullLiteralExp__OclElement);
			Fragments._NullLiteralExp__PrimitiveLiteralExp.initOperations(_NullLiteralExp__PrimitiveLiteralExp);
			Fragments._NullLiteralExp__TypedElement.initOperations(_NullLiteralExp__TypedElement);
			Fragments._NullLiteralExp__Visitable.initOperations(_NullLiteralExp__Visitable);

			Fragments._NumericLiteralExp__Element.initOperations(_NumericLiteralExp__Element);
			Fragments._NumericLiteralExp__LiteralExp.initOperations(_NumericLiteralExp__LiteralExp);
			Fragments._NumericLiteralExp__Nameable.initOperations(_NumericLiteralExp__Nameable);
			Fragments._NumericLiteralExp__NamedElement.initOperations(_NumericLiteralExp__NamedElement);
			Fragments._NumericLiteralExp__NumericLiteralExp.initOperations(_NumericLiteralExp__NumericLiteralExp);
			Fragments._NumericLiteralExp__OCLExpression.initOperations(_NumericLiteralExp__OCLExpression);
			Fragments._NumericLiteralExp__OclAny.initOperations(_NumericLiteralExp__OclAny);
			Fragments._NumericLiteralExp__OclElement.initOperations(_NumericLiteralExp__OclElement);
			Fragments._NumericLiteralExp__PrimitiveLiteralExp.initOperations(_NumericLiteralExp__PrimitiveLiteralExp);
			Fragments._NumericLiteralExp__TypedElement.initOperations(_NumericLiteralExp__TypedElement);
			Fragments._NumericLiteralExp__Visitable.initOperations(_NumericLiteralExp__Visitable);

			Fragments._OCLExpression__Element.initOperations(_OCLExpression__Element);
			Fragments._OCLExpression__Nameable.initOperations(_OCLExpression__Nameable);
			Fragments._OCLExpression__NamedElement.initOperations(_OCLExpression__NamedElement);
			Fragments._OCLExpression__OCLExpression.initOperations(_OCLExpression__OCLExpression);
			Fragments._OCLExpression__OclAny.initOperations(_OCLExpression__OclAny);
			Fragments._OCLExpression__OclElement.initOperations(_OCLExpression__OclElement);
			Fragments._OCLExpression__TypedElement.initOperations(_OCLExpression__TypedElement);
			Fragments._OCLExpression__Visitable.initOperations(_OCLExpression__Visitable);

			Fragments._Object__Object.initOperations(_Object__Object);
			Fragments._Object__OclAny.initOperations(_Object__OclAny);

			Fragments._OpaqueExpression__Element.initOperations(_OpaqueExpression__Element);
			Fragments._OpaqueExpression__Nameable.initOperations(_OpaqueExpression__Nameable);
			Fragments._OpaqueExpression__NamedElement.initOperations(_OpaqueExpression__NamedElement);
			Fragments._OpaqueExpression__OclAny.initOperations(_OpaqueExpression__OclAny);
			Fragments._OpaqueExpression__OclElement.initOperations(_OpaqueExpression__OclElement);
			Fragments._OpaqueExpression__OpaqueExpression.initOperations(_OpaqueExpression__OpaqueExpression);
			Fragments._OpaqueExpression__PackageableElement.initOperations(_OpaqueExpression__PackageableElement);
			Fragments._OpaqueExpression__ParameterableElement.initOperations(_OpaqueExpression__ParameterableElement);
			Fragments._OpaqueExpression__TypedElement.initOperations(_OpaqueExpression__TypedElement);
			Fragments._OpaqueExpression__ValueSpecification.initOperations(_OpaqueExpression__ValueSpecification);
			Fragments._OpaqueExpression__Visitable.initOperations(_OpaqueExpression__Visitable);

			Fragments._Operation__Element.initOperations(_Operation__Element);
			Fragments._Operation__Feature.initOperations(_Operation__Feature);
			Fragments._Operation__Nameable.initOperations(_Operation__Nameable);
			Fragments._Operation__NamedElement.initOperations(_Operation__NamedElement);
			Fragments._Operation__Namespace.initOperations(_Operation__Namespace);
			Fragments._Operation__OclAny.initOperations(_Operation__OclAny);
			Fragments._Operation__OclElement.initOperations(_Operation__OclElement);
			Fragments._Operation__Operation.initOperations(_Operation__Operation);
			Fragments._Operation__ParameterableElement.initOperations(_Operation__ParameterableElement);
			Fragments._Operation__TemplateableElement.initOperations(_Operation__TemplateableElement);
			Fragments._Operation__TypedElement.initOperations(_Operation__TypedElement);
			Fragments._Operation__TypedMultiplicityElement.initOperations(_Operation__TypedMultiplicityElement);
			Fragments._Operation__Visitable.initOperations(_Operation__Visitable);

			Fragments._OperationCallExp__CallExp.initOperations(_OperationCallExp__CallExp);
			Fragments._OperationCallExp__Element.initOperations(_OperationCallExp__Element);
			Fragments._OperationCallExp__FeatureCallExp.initOperations(_OperationCallExp__FeatureCallExp);
			Fragments._OperationCallExp__Nameable.initOperations(_OperationCallExp__Nameable);
			Fragments._OperationCallExp__NamedElement.initOperations(_OperationCallExp__NamedElement);
			Fragments._OperationCallExp__OCLExpression.initOperations(_OperationCallExp__OCLExpression);
			Fragments._OperationCallExp__OclAny.initOperations(_OperationCallExp__OclAny);
			Fragments._OperationCallExp__OclElement.initOperations(_OperationCallExp__OclElement);
			Fragments._OperationCallExp__OperationCallExp.initOperations(_OperationCallExp__OperationCallExp);
			Fragments._OperationCallExp__ReferringElement.initOperations(_OperationCallExp__ReferringElement);
			Fragments._OperationCallExp__TypedElement.initOperations(_OperationCallExp__TypedElement);
			Fragments._OperationCallExp__Visitable.initOperations(_OperationCallExp__Visitable);

			Fragments._OperationTemplateParameter__Element.initOperations(_OperationTemplateParameter__Element);
			Fragments._OperationTemplateParameter__OclAny.initOperations(_OperationTemplateParameter__OclAny);
			Fragments._OperationTemplateParameter__OclElement.initOperations(_OperationTemplateParameter__OclElement);
			Fragments._OperationTemplateParameter__OperationTemplateParameter.initOperations(_OperationTemplateParameter__OperationTemplateParameter);
			Fragments._OperationTemplateParameter__TemplateParameter.initOperations(_OperationTemplateParameter__TemplateParameter);
			Fragments._OperationTemplateParameter__Visitable.initOperations(_OperationTemplateParameter__Visitable);

			Fragments._OrderedSetType__Class.initOperations(_OrderedSetType__Class);
			Fragments._OrderedSetType__CollectionType.initOperations(_OrderedSetType__CollectionType);
			Fragments._OrderedSetType__DataType.initOperations(_OrderedSetType__DataType);
			Fragments._OrderedSetType__Element.initOperations(_OrderedSetType__Element);
			Fragments._OrderedSetType__Nameable.initOperations(_OrderedSetType__Nameable);
			Fragments._OrderedSetType__NamedElement.initOperations(_OrderedSetType__NamedElement);
			Fragments._OrderedSetType__Namespace.initOperations(_OrderedSetType__Namespace);
			Fragments._OrderedSetType__OclAny.initOperations(_OrderedSetType__OclAny);
			Fragments._OrderedSetType__OclElement.initOperations(_OrderedSetType__OclElement);
			Fragments._OrderedSetType__OclType.initOperations(_OrderedSetType__OclType);
			Fragments._OrderedSetType__OrderedSetType.initOperations(_OrderedSetType__OrderedSetType);
			Fragments._OrderedSetType__PackageableElement.initOperations(_OrderedSetType__PackageableElement);
			Fragments._OrderedSetType__ParameterableElement.initOperations(_OrderedSetType__ParameterableElement);
			Fragments._OrderedSetType__TemplateableElement.initOperations(_OrderedSetType__TemplateableElement);
			Fragments._OrderedSetType__Type.initOperations(_OrderedSetType__Type);
			Fragments._OrderedSetType__Visitable.initOperations(_OrderedSetType__Visitable);

			Fragments._Package__Element.initOperations(_Package__Element);
			Fragments._Package__Nameable.initOperations(_Package__Nameable);
			Fragments._Package__NamedElement.initOperations(_Package__NamedElement);
			Fragments._Package__Namespace.initOperations(_Package__Namespace);
			Fragments._Package__OclAny.initOperations(_Package__OclAny);
			Fragments._Package__OclElement.initOperations(_Package__OclElement);
			Fragments._Package__Package.initOperations(_Package__Package);
			Fragments._Package__PackageableElement.initOperations(_Package__PackageableElement);
			Fragments._Package__ParameterableElement.initOperations(_Package__ParameterableElement);
			Fragments._Package__TemplateableElement.initOperations(_Package__TemplateableElement);
			Fragments._Package__Visitable.initOperations(_Package__Visitable);

			Fragments._PackageableElement__Element.initOperations(_PackageableElement__Element);
			Fragments._PackageableElement__Nameable.initOperations(_PackageableElement__Nameable);
			Fragments._PackageableElement__NamedElement.initOperations(_PackageableElement__NamedElement);
			Fragments._PackageableElement__OclAny.initOperations(_PackageableElement__OclAny);
			Fragments._PackageableElement__OclElement.initOperations(_PackageableElement__OclElement);
			Fragments._PackageableElement__PackageableElement.initOperations(_PackageableElement__PackageableElement);
			Fragments._PackageableElement__ParameterableElement.initOperations(_PackageableElement__ParameterableElement);
			Fragments._PackageableElement__Visitable.initOperations(_PackageableElement__Visitable);

			Fragments._Parameter__Element.initOperations(_Parameter__Element);
			Fragments._Parameter__Nameable.initOperations(_Parameter__Nameable);
			Fragments._Parameter__NamedElement.initOperations(_Parameter__NamedElement);
			Fragments._Parameter__OclAny.initOperations(_Parameter__OclAny);
			Fragments._Parameter__OclElement.initOperations(_Parameter__OclElement);
			Fragments._Parameter__PackageableElement.initOperations(_Parameter__PackageableElement);
			Fragments._Parameter__Parameter.initOperations(_Parameter__Parameter);
			Fragments._Parameter__ParameterableElement.initOperations(_Parameter__ParameterableElement);
			Fragments._Parameter__TypedElement.initOperations(_Parameter__TypedElement);
			Fragments._Parameter__TypedMultiplicityElement.initOperations(_Parameter__TypedMultiplicityElement);
			Fragments._Parameter__VariableDeclaration.initOperations(_Parameter__VariableDeclaration);
			Fragments._Parameter__Visitable.initOperations(_Parameter__Visitable);

			Fragments._ParameterableElement__Element.initOperations(_ParameterableElement__Element);
			Fragments._ParameterableElement__OclAny.initOperations(_ParameterableElement__OclAny);
			Fragments._ParameterableElement__OclElement.initOperations(_ParameterableElement__OclElement);
			Fragments._ParameterableElement__ParameterableElement.initOperations(_ParameterableElement__ParameterableElement);
			Fragments._ParameterableElement__Visitable.initOperations(_ParameterableElement__Visitable);

			Fragments._Pivotable__OclAny.initOperations(_Pivotable__OclAny);
			Fragments._Pivotable__OclElement.initOperations(_Pivotable__OclElement);
			Fragments._Pivotable__Pivotable.initOperations(_Pivotable__Pivotable);

			Fragments._Precedence__Element.initOperations(_Precedence__Element);
			Fragments._Precedence__Nameable.initOperations(_Precedence__Nameable);
			Fragments._Precedence__NamedElement.initOperations(_Precedence__NamedElement);
			Fragments._Precedence__OclAny.initOperations(_Precedence__OclAny);
			Fragments._Precedence__OclElement.initOperations(_Precedence__OclElement);
			Fragments._Precedence__Precedence.initOperations(_Precedence__Precedence);
			Fragments._Precedence__Visitable.initOperations(_Precedence__Visitable);

			Fragments._PrimitiveLiteralExp__Element.initOperations(_PrimitiveLiteralExp__Element);
			Fragments._PrimitiveLiteralExp__LiteralExp.initOperations(_PrimitiveLiteralExp__LiteralExp);
			Fragments._PrimitiveLiteralExp__Nameable.initOperations(_PrimitiveLiteralExp__Nameable);
			Fragments._PrimitiveLiteralExp__NamedElement.initOperations(_PrimitiveLiteralExp__NamedElement);
			Fragments._PrimitiveLiteralExp__OCLExpression.initOperations(_PrimitiveLiteralExp__OCLExpression);
			Fragments._PrimitiveLiteralExp__OclAny.initOperations(_PrimitiveLiteralExp__OclAny);
			Fragments._PrimitiveLiteralExp__OclElement.initOperations(_PrimitiveLiteralExp__OclElement);
			Fragments._PrimitiveLiteralExp__PrimitiveLiteralExp.initOperations(_PrimitiveLiteralExp__PrimitiveLiteralExp);
			Fragments._PrimitiveLiteralExp__TypedElement.initOperations(_PrimitiveLiteralExp__TypedElement);
			Fragments._PrimitiveLiteralExp__Visitable.initOperations(_PrimitiveLiteralExp__Visitable);

			Fragments._PrimitiveType__Class.initOperations(_PrimitiveType__Class);
			Fragments._PrimitiveType__DataType.initOperations(_PrimitiveType__DataType);
			Fragments._PrimitiveType__Element.initOperations(_PrimitiveType__Element);
			Fragments._PrimitiveType__Nameable.initOperations(_PrimitiveType__Nameable);
			Fragments._PrimitiveType__NamedElement.initOperations(_PrimitiveType__NamedElement);
			Fragments._PrimitiveType__Namespace.initOperations(_PrimitiveType__Namespace);
			Fragments._PrimitiveType__OclAny.initOperations(_PrimitiveType__OclAny);
			Fragments._PrimitiveType__OclElement.initOperations(_PrimitiveType__OclElement);
			Fragments._PrimitiveType__OclType.initOperations(_PrimitiveType__OclType);
			Fragments._PrimitiveType__PackageableElement.initOperations(_PrimitiveType__PackageableElement);
			Fragments._PrimitiveType__ParameterableElement.initOperations(_PrimitiveType__ParameterableElement);
			Fragments._PrimitiveType__PrimitiveType.initOperations(_PrimitiveType__PrimitiveType);
			Fragments._PrimitiveType__TemplateableElement.initOperations(_PrimitiveType__TemplateableElement);
			Fragments._PrimitiveType__Type.initOperations(_PrimitiveType__Type);
			Fragments._PrimitiveType__Visitable.initOperations(_PrimitiveType__Visitable);

			Fragments._Profile__Element.initOperations(_Profile__Element);
			Fragments._Profile__Nameable.initOperations(_Profile__Nameable);
			Fragments._Profile__NamedElement.initOperations(_Profile__NamedElement);
			Fragments._Profile__Namespace.initOperations(_Profile__Namespace);
			Fragments._Profile__OclAny.initOperations(_Profile__OclAny);
			Fragments._Profile__OclElement.initOperations(_Profile__OclElement);
			Fragments._Profile__Package.initOperations(_Profile__Package);
			Fragments._Profile__PackageableElement.initOperations(_Profile__PackageableElement);
			Fragments._Profile__ParameterableElement.initOperations(_Profile__ParameterableElement);
			Fragments._Profile__Profile.initOperations(_Profile__Profile);
			Fragments._Profile__TemplateableElement.initOperations(_Profile__TemplateableElement);
			Fragments._Profile__Visitable.initOperations(_Profile__Visitable);

			Fragments._Property__Element.initOperations(_Property__Element);
			Fragments._Property__Feature.initOperations(_Property__Feature);
			Fragments._Property__Nameable.initOperations(_Property__Nameable);
			Fragments._Property__NamedElement.initOperations(_Property__NamedElement);
			Fragments._Property__OclAny.initOperations(_Property__OclAny);
			Fragments._Property__OclElement.initOperations(_Property__OclElement);
			Fragments._Property__ParameterableElement.initOperations(_Property__ParameterableElement);
			Fragments._Property__Property.initOperations(_Property__Property);
			Fragments._Property__TypedElement.initOperations(_Property__TypedElement);
			Fragments._Property__TypedMultiplicityElement.initOperations(_Property__TypedMultiplicityElement);
			Fragments._Property__Visitable.initOperations(_Property__Visitable);

			Fragments._PropertyCallExp__CallExp.initOperations(_PropertyCallExp__CallExp);
			Fragments._PropertyCallExp__Element.initOperations(_PropertyCallExp__Element);
			Fragments._PropertyCallExp__FeatureCallExp.initOperations(_PropertyCallExp__FeatureCallExp);
			Fragments._PropertyCallExp__Nameable.initOperations(_PropertyCallExp__Nameable);
			Fragments._PropertyCallExp__NamedElement.initOperations(_PropertyCallExp__NamedElement);
			Fragments._PropertyCallExp__NavigationCallExp.initOperations(_PropertyCallExp__NavigationCallExp);
			Fragments._PropertyCallExp__OCLExpression.initOperations(_PropertyCallExp__OCLExpression);
			Fragments._PropertyCallExp__OclAny.initOperations(_PropertyCallExp__OclAny);
			Fragments._PropertyCallExp__OclElement.initOperations(_PropertyCallExp__OclElement);
			Fragments._PropertyCallExp__PropertyCallExp.initOperations(_PropertyCallExp__PropertyCallExp);
			Fragments._PropertyCallExp__ReferringElement.initOperations(_PropertyCallExp__ReferringElement);
			Fragments._PropertyCallExp__TypedElement.initOperations(_PropertyCallExp__TypedElement);
			Fragments._PropertyCallExp__Visitable.initOperations(_PropertyCallExp__Visitable);

			Fragments._Pseudostate__Element.initOperations(_Pseudostate__Element);
			Fragments._Pseudostate__Nameable.initOperations(_Pseudostate__Nameable);
			Fragments._Pseudostate__NamedElement.initOperations(_Pseudostate__NamedElement);
			Fragments._Pseudostate__OclAny.initOperations(_Pseudostate__OclAny);
			Fragments._Pseudostate__OclElement.initOperations(_Pseudostate__OclElement);
			Fragments._Pseudostate__Pseudostate.initOperations(_Pseudostate__Pseudostate);
			Fragments._Pseudostate__Vertex.initOperations(_Pseudostate__Vertex);
			Fragments._Pseudostate__Visitable.initOperations(_Pseudostate__Visitable);

			Fragments._PseudostateKind__Class.initOperations(_PseudostateKind__Class);
			Fragments._PseudostateKind__DataType.initOperations(_PseudostateKind__DataType);
			Fragments._PseudostateKind__Element.initOperations(_PseudostateKind__Element);
			Fragments._PseudostateKind__Enumeration.initOperations(_PseudostateKind__Enumeration);
			Fragments._PseudostateKind__Nameable.initOperations(_PseudostateKind__Nameable);
			Fragments._PseudostateKind__NamedElement.initOperations(_PseudostateKind__NamedElement);
			Fragments._PseudostateKind__Namespace.initOperations(_PseudostateKind__Namespace);
			Fragments._PseudostateKind__OclAny.initOperations(_PseudostateKind__OclAny);
			Fragments._PseudostateKind__OclElement.initOperations(_PseudostateKind__OclElement);
			Fragments._PseudostateKind__OclType.initOperations(_PseudostateKind__OclType);
			Fragments._PseudostateKind__PackageableElement.initOperations(_PseudostateKind__PackageableElement);
			Fragments._PseudostateKind__ParameterableElement.initOperations(_PseudostateKind__ParameterableElement);
			Fragments._PseudostateKind__PseudostateKind.initOperations(_PseudostateKind__PseudostateKind);
			Fragments._PseudostateKind__TemplateableElement.initOperations(_PseudostateKind__TemplateableElement);
			Fragments._PseudostateKind__Type.initOperations(_PseudostateKind__Type);
			Fragments._PseudostateKind__Visitable.initOperations(_PseudostateKind__Visitable);

			Fragments._RealLiteralExp__Element.initOperations(_RealLiteralExp__Element);
			Fragments._RealLiteralExp__LiteralExp.initOperations(_RealLiteralExp__LiteralExp);
			Fragments._RealLiteralExp__Nameable.initOperations(_RealLiteralExp__Nameable);
			Fragments._RealLiteralExp__NamedElement.initOperations(_RealLiteralExp__NamedElement);
			Fragments._RealLiteralExp__NumericLiteralExp.initOperations(_RealLiteralExp__NumericLiteralExp);
			Fragments._RealLiteralExp__OCLExpression.initOperations(_RealLiteralExp__OCLExpression);
			Fragments._RealLiteralExp__OclAny.initOperations(_RealLiteralExp__OclAny);
			Fragments._RealLiteralExp__OclElement.initOperations(_RealLiteralExp__OclElement);
			Fragments._RealLiteralExp__PrimitiveLiteralExp.initOperations(_RealLiteralExp__PrimitiveLiteralExp);
			Fragments._RealLiteralExp__RealLiteralExp.initOperations(_RealLiteralExp__RealLiteralExp);
			Fragments._RealLiteralExp__TypedElement.initOperations(_RealLiteralExp__TypedElement);
			Fragments._RealLiteralExp__Visitable.initOperations(_RealLiteralExp__Visitable);

			Fragments._ReferringElement__OclAny.initOperations(_ReferringElement__OclAny);
			Fragments._ReferringElement__OclElement.initOperations(_ReferringElement__OclElement);
			Fragments._ReferringElement__ReferringElement.initOperations(_ReferringElement__ReferringElement);

			Fragments._Region__Element.initOperations(_Region__Element);
			Fragments._Region__Nameable.initOperations(_Region__Nameable);
			Fragments._Region__NamedElement.initOperations(_Region__NamedElement);
			Fragments._Region__Namespace.initOperations(_Region__Namespace);
			Fragments._Region__OclAny.initOperations(_Region__OclAny);
			Fragments._Region__OclElement.initOperations(_Region__OclElement);
			Fragments._Region__Region.initOperations(_Region__Region);
			Fragments._Region__Visitable.initOperations(_Region__Visitable);

			Fragments._Root__Element.initOperations(_Root__Element);
			Fragments._Root__Nameable.initOperations(_Root__Nameable);
			Fragments._Root__NamedElement.initOperations(_Root__NamedElement);
			Fragments._Root__Namespace.initOperations(_Root__Namespace);
			Fragments._Root__OclAny.initOperations(_Root__OclAny);
			Fragments._Root__OclElement.initOperations(_Root__OclElement);
			Fragments._Root__Root.initOperations(_Root__Root);
			Fragments._Root__Visitable.initOperations(_Root__Visitable);

			Fragments._SelfType__Class.initOperations(_SelfType__Class);
			Fragments._SelfType__Element.initOperations(_SelfType__Element);
			Fragments._SelfType__Nameable.initOperations(_SelfType__Nameable);
			Fragments._SelfType__NamedElement.initOperations(_SelfType__NamedElement);
			Fragments._SelfType__Namespace.initOperations(_SelfType__Namespace);
			Fragments._SelfType__OclAny.initOperations(_SelfType__OclAny);
			Fragments._SelfType__OclElement.initOperations(_SelfType__OclElement);
			Fragments._SelfType__OclType.initOperations(_SelfType__OclType);
			Fragments._SelfType__PackageableElement.initOperations(_SelfType__PackageableElement);
			Fragments._SelfType__ParameterableElement.initOperations(_SelfType__ParameterableElement);
			Fragments._SelfType__SelfType.initOperations(_SelfType__SelfType);
			Fragments._SelfType__TemplateableElement.initOperations(_SelfType__TemplateableElement);
			Fragments._SelfType__Type.initOperations(_SelfType__Type);
			Fragments._SelfType__Visitable.initOperations(_SelfType__Visitable);

			Fragments._SendSignalAction__Element.initOperations(_SendSignalAction__Element);
			Fragments._SendSignalAction__Nameable.initOperations(_SendSignalAction__Nameable);
			Fragments._SendSignalAction__NamedElement.initOperations(_SendSignalAction__NamedElement);
			Fragments._SendSignalAction__OclAny.initOperations(_SendSignalAction__OclAny);
			Fragments._SendSignalAction__OclElement.initOperations(_SendSignalAction__OclElement);
			Fragments._SendSignalAction__SendSignalAction.initOperations(_SendSignalAction__SendSignalAction);
			Fragments._SendSignalAction__Visitable.initOperations(_SendSignalAction__Visitable);

			Fragments._SequenceType__Class.initOperations(_SequenceType__Class);
			Fragments._SequenceType__CollectionType.initOperations(_SequenceType__CollectionType);
			Fragments._SequenceType__DataType.initOperations(_SequenceType__DataType);
			Fragments._SequenceType__Element.initOperations(_SequenceType__Element);
			Fragments._SequenceType__Nameable.initOperations(_SequenceType__Nameable);
			Fragments._SequenceType__NamedElement.initOperations(_SequenceType__NamedElement);
			Fragments._SequenceType__Namespace.initOperations(_SequenceType__Namespace);
			Fragments._SequenceType__OclAny.initOperations(_SequenceType__OclAny);
			Fragments._SequenceType__OclElement.initOperations(_SequenceType__OclElement);
			Fragments._SequenceType__OclType.initOperations(_SequenceType__OclType);
			Fragments._SequenceType__PackageableElement.initOperations(_SequenceType__PackageableElement);
			Fragments._SequenceType__ParameterableElement.initOperations(_SequenceType__ParameterableElement);
			Fragments._SequenceType__SequenceType.initOperations(_SequenceType__SequenceType);
			Fragments._SequenceType__TemplateableElement.initOperations(_SequenceType__TemplateableElement);
			Fragments._SequenceType__Type.initOperations(_SequenceType__Type);
			Fragments._SequenceType__Visitable.initOperations(_SequenceType__Visitable);

			Fragments._SetType__Class.initOperations(_SetType__Class);
			Fragments._SetType__CollectionType.initOperations(_SetType__CollectionType);
			Fragments._SetType__DataType.initOperations(_SetType__DataType);
			Fragments._SetType__Element.initOperations(_SetType__Element);
			Fragments._SetType__Nameable.initOperations(_SetType__Nameable);
			Fragments._SetType__NamedElement.initOperations(_SetType__NamedElement);
			Fragments._SetType__Namespace.initOperations(_SetType__Namespace);
			Fragments._SetType__OclAny.initOperations(_SetType__OclAny);
			Fragments._SetType__OclElement.initOperations(_SetType__OclElement);
			Fragments._SetType__OclType.initOperations(_SetType__OclType);
			Fragments._SetType__PackageableElement.initOperations(_SetType__PackageableElement);
			Fragments._SetType__ParameterableElement.initOperations(_SetType__ParameterableElement);
			Fragments._SetType__SetType.initOperations(_SetType__SetType);
			Fragments._SetType__TemplateableElement.initOperations(_SetType__TemplateableElement);
			Fragments._SetType__Type.initOperations(_SetType__Type);
			Fragments._SetType__Visitable.initOperations(_SetType__Visitable);

			Fragments._Signal__Class.initOperations(_Signal__Class);
			Fragments._Signal__Element.initOperations(_Signal__Element);
			Fragments._Signal__Nameable.initOperations(_Signal__Nameable);
			Fragments._Signal__NamedElement.initOperations(_Signal__NamedElement);
			Fragments._Signal__Namespace.initOperations(_Signal__Namespace);
			Fragments._Signal__OclAny.initOperations(_Signal__OclAny);
			Fragments._Signal__OclElement.initOperations(_Signal__OclElement);
			Fragments._Signal__OclType.initOperations(_Signal__OclType);
			Fragments._Signal__PackageableElement.initOperations(_Signal__PackageableElement);
			Fragments._Signal__ParameterableElement.initOperations(_Signal__ParameterableElement);
			Fragments._Signal__Signal.initOperations(_Signal__Signal);
			Fragments._Signal__TemplateableElement.initOperations(_Signal__TemplateableElement);
			Fragments._Signal__Type.initOperations(_Signal__Type);
			Fragments._Signal__Visitable.initOperations(_Signal__Visitable);

			Fragments._State__Element.initOperations(_State__Element);
			Fragments._State__Nameable.initOperations(_State__Nameable);
			Fragments._State__NamedElement.initOperations(_State__NamedElement);
			Fragments._State__Namespace.initOperations(_State__Namespace);
			Fragments._State__OclAny.initOperations(_State__OclAny);
			Fragments._State__OclElement.initOperations(_State__OclElement);
			Fragments._State__OclState.initOperations(_State__OclState);
			Fragments._State__State.initOperations(_State__State);
			Fragments._State__Vertex.initOperations(_State__Vertex);
			Fragments._State__Visitable.initOperations(_State__Visitable);

			Fragments._StateExp__Element.initOperations(_StateExp__Element);
			Fragments._StateExp__Nameable.initOperations(_StateExp__Nameable);
			Fragments._StateExp__NamedElement.initOperations(_StateExp__NamedElement);
			Fragments._StateExp__OCLExpression.initOperations(_StateExp__OCLExpression);
			Fragments._StateExp__OclAny.initOperations(_StateExp__OclAny);
			Fragments._StateExp__OclElement.initOperations(_StateExp__OclElement);
			Fragments._StateExp__StateExp.initOperations(_StateExp__StateExp);
			Fragments._StateExp__TypedElement.initOperations(_StateExp__TypedElement);
			Fragments._StateExp__Visitable.initOperations(_StateExp__Visitable);

			Fragments._StateMachine__Behavior.initOperations(_StateMachine__Behavior);
			Fragments._StateMachine__Class.initOperations(_StateMachine__Class);
			Fragments._StateMachine__Element.initOperations(_StateMachine__Element);
			Fragments._StateMachine__Nameable.initOperations(_StateMachine__Nameable);
			Fragments._StateMachine__NamedElement.initOperations(_StateMachine__NamedElement);
			Fragments._StateMachine__Namespace.initOperations(_StateMachine__Namespace);
			Fragments._StateMachine__OclAny.initOperations(_StateMachine__OclAny);
			Fragments._StateMachine__OclElement.initOperations(_StateMachine__OclElement);
			Fragments._StateMachine__OclType.initOperations(_StateMachine__OclType);
			Fragments._StateMachine__PackageableElement.initOperations(_StateMachine__PackageableElement);
			Fragments._StateMachine__ParameterableElement.initOperations(_StateMachine__ParameterableElement);
			Fragments._StateMachine__StateMachine.initOperations(_StateMachine__StateMachine);
			Fragments._StateMachine__TemplateableElement.initOperations(_StateMachine__TemplateableElement);
			Fragments._StateMachine__Type.initOperations(_StateMachine__Type);
			Fragments._StateMachine__Visitable.initOperations(_StateMachine__Visitable);

			Fragments._Stereotype__Class.initOperations(_Stereotype__Class);
			Fragments._Stereotype__Element.initOperations(_Stereotype__Element);
			Fragments._Stereotype__Nameable.initOperations(_Stereotype__Nameable);
			Fragments._Stereotype__NamedElement.initOperations(_Stereotype__NamedElement);
			Fragments._Stereotype__Namespace.initOperations(_Stereotype__Namespace);
			Fragments._Stereotype__OclAny.initOperations(_Stereotype__OclAny);
			Fragments._Stereotype__OclElement.initOperations(_Stereotype__OclElement);
			Fragments._Stereotype__OclType.initOperations(_Stereotype__OclType);
			Fragments._Stereotype__PackageableElement.initOperations(_Stereotype__PackageableElement);
			Fragments._Stereotype__ParameterableElement.initOperations(_Stereotype__ParameterableElement);
			Fragments._Stereotype__Stereotype.initOperations(_Stereotype__Stereotype);
			Fragments._Stereotype__TemplateableElement.initOperations(_Stereotype__TemplateableElement);
			Fragments._Stereotype__Type.initOperations(_Stereotype__Type);
			Fragments._Stereotype__Visitable.initOperations(_Stereotype__Visitable);

			Fragments._StringLiteralExp__Element.initOperations(_StringLiteralExp__Element);
			Fragments._StringLiteralExp__LiteralExp.initOperations(_StringLiteralExp__LiteralExp);
			Fragments._StringLiteralExp__Nameable.initOperations(_StringLiteralExp__Nameable);
			Fragments._StringLiteralExp__NamedElement.initOperations(_StringLiteralExp__NamedElement);
			Fragments._StringLiteralExp__OCLExpression.initOperations(_StringLiteralExp__OCLExpression);
			Fragments._StringLiteralExp__OclAny.initOperations(_StringLiteralExp__OclAny);
			Fragments._StringLiteralExp__OclElement.initOperations(_StringLiteralExp__OclElement);
			Fragments._StringLiteralExp__PrimitiveLiteralExp.initOperations(_StringLiteralExp__PrimitiveLiteralExp);
			Fragments._StringLiteralExp__StringLiteralExp.initOperations(_StringLiteralExp__StringLiteralExp);
			Fragments._StringLiteralExp__TypedElement.initOperations(_StringLiteralExp__TypedElement);
			Fragments._StringLiteralExp__Visitable.initOperations(_StringLiteralExp__Visitable);

			Fragments._TemplateBinding__Element.initOperations(_TemplateBinding__Element);
			Fragments._TemplateBinding__OclAny.initOperations(_TemplateBinding__OclAny);
			Fragments._TemplateBinding__OclElement.initOperations(_TemplateBinding__OclElement);
			Fragments._TemplateBinding__TemplateBinding.initOperations(_TemplateBinding__TemplateBinding);
			Fragments._TemplateBinding__Visitable.initOperations(_TemplateBinding__Visitable);

			Fragments._TemplateParameter__Element.initOperations(_TemplateParameter__Element);
			Fragments._TemplateParameter__OclAny.initOperations(_TemplateParameter__OclAny);
			Fragments._TemplateParameter__OclElement.initOperations(_TemplateParameter__OclElement);
			Fragments._TemplateParameter__TemplateParameter.initOperations(_TemplateParameter__TemplateParameter);
			Fragments._TemplateParameter__Visitable.initOperations(_TemplateParameter__Visitable);

			Fragments._TemplateParameterSubstitution__Element.initOperations(_TemplateParameterSubstitution__Element);
			Fragments._TemplateParameterSubstitution__OclAny.initOperations(_TemplateParameterSubstitution__OclAny);
			Fragments._TemplateParameterSubstitution__OclElement.initOperations(_TemplateParameterSubstitution__OclElement);
			Fragments._TemplateParameterSubstitution__TemplateParameterSubstitution.initOperations(_TemplateParameterSubstitution__TemplateParameterSubstitution);
			Fragments._TemplateParameterSubstitution__Visitable.initOperations(_TemplateParameterSubstitution__Visitable);

			Fragments._TemplateParameterType__Element.initOperations(_TemplateParameterType__Element);
			Fragments._TemplateParameterType__Nameable.initOperations(_TemplateParameterType__Nameable);
			Fragments._TemplateParameterType__NamedElement.initOperations(_TemplateParameterType__NamedElement);
			Fragments._TemplateParameterType__OclAny.initOperations(_TemplateParameterType__OclAny);
			Fragments._TemplateParameterType__OclElement.initOperations(_TemplateParameterType__OclElement);
			Fragments._TemplateParameterType__OclType.initOperations(_TemplateParameterType__OclType);
			Fragments._TemplateParameterType__PackageableElement.initOperations(_TemplateParameterType__PackageableElement);
			Fragments._TemplateParameterType__ParameterableElement.initOperations(_TemplateParameterType__ParameterableElement);
			Fragments._TemplateParameterType__TemplateParameterType.initOperations(_TemplateParameterType__TemplateParameterType);
			Fragments._TemplateParameterType__TemplateableElement.initOperations(_TemplateParameterType__TemplateableElement);
			Fragments._TemplateParameterType__Type.initOperations(_TemplateParameterType__Type);
			Fragments._TemplateParameterType__Visitable.initOperations(_TemplateParameterType__Visitable);

			Fragments._TemplateSignature__Element.initOperations(_TemplateSignature__Element);
			Fragments._TemplateSignature__OclAny.initOperations(_TemplateSignature__OclAny);
			Fragments._TemplateSignature__OclElement.initOperations(_TemplateSignature__OclElement);
			Fragments._TemplateSignature__TemplateSignature.initOperations(_TemplateSignature__TemplateSignature);
			Fragments._TemplateSignature__Visitable.initOperations(_TemplateSignature__Visitable);

			Fragments._TemplateableElement__Element.initOperations(_TemplateableElement__Element);
			Fragments._TemplateableElement__OclAny.initOperations(_TemplateableElement__OclAny);
			Fragments._TemplateableElement__OclElement.initOperations(_TemplateableElement__OclElement);
			Fragments._TemplateableElement__TemplateableElement.initOperations(_TemplateableElement__TemplateableElement);
			Fragments._TemplateableElement__Visitable.initOperations(_TemplateableElement__Visitable);

			Fragments._Throwable__OclAny.initOperations(_Throwable__OclAny);
			Fragments._Throwable__Throwable.initOperations(_Throwable__Throwable);

			Fragments._Transition__Element.initOperations(_Transition__Element);
			Fragments._Transition__Nameable.initOperations(_Transition__Nameable);
			Fragments._Transition__NamedElement.initOperations(_Transition__NamedElement);
			Fragments._Transition__Namespace.initOperations(_Transition__Namespace);
			Fragments._Transition__OclAny.initOperations(_Transition__OclAny);
			Fragments._Transition__OclElement.initOperations(_Transition__OclElement);
			Fragments._Transition__Transition.initOperations(_Transition__Transition);
			Fragments._Transition__Visitable.initOperations(_Transition__Visitable);

			Fragments._TransitionKind__Class.initOperations(_TransitionKind__Class);
			Fragments._TransitionKind__DataType.initOperations(_TransitionKind__DataType);
			Fragments._TransitionKind__Element.initOperations(_TransitionKind__Element);
			Fragments._TransitionKind__Enumeration.initOperations(_TransitionKind__Enumeration);
			Fragments._TransitionKind__Nameable.initOperations(_TransitionKind__Nameable);
			Fragments._TransitionKind__NamedElement.initOperations(_TransitionKind__NamedElement);
			Fragments._TransitionKind__Namespace.initOperations(_TransitionKind__Namespace);
			Fragments._TransitionKind__OclAny.initOperations(_TransitionKind__OclAny);
			Fragments._TransitionKind__OclElement.initOperations(_TransitionKind__OclElement);
			Fragments._TransitionKind__OclType.initOperations(_TransitionKind__OclType);
			Fragments._TransitionKind__PackageableElement.initOperations(_TransitionKind__PackageableElement);
			Fragments._TransitionKind__ParameterableElement.initOperations(_TransitionKind__ParameterableElement);
			Fragments._TransitionKind__TemplateableElement.initOperations(_TransitionKind__TemplateableElement);
			Fragments._TransitionKind__TransitionKind.initOperations(_TransitionKind__TransitionKind);
			Fragments._TransitionKind__Type.initOperations(_TransitionKind__Type);
			Fragments._TransitionKind__Visitable.initOperations(_TransitionKind__Visitable);

			Fragments._Trigger__Element.initOperations(_Trigger__Element);
			Fragments._Trigger__Nameable.initOperations(_Trigger__Nameable);
			Fragments._Trigger__NamedElement.initOperations(_Trigger__NamedElement);
			Fragments._Trigger__OclAny.initOperations(_Trigger__OclAny);
			Fragments._Trigger__OclElement.initOperations(_Trigger__OclElement);
			Fragments._Trigger__Trigger.initOperations(_Trigger__Trigger);
			Fragments._Trigger__Visitable.initOperations(_Trigger__Visitable);

			Fragments._TupleLiteralExp__Element.initOperations(_TupleLiteralExp__Element);
			Fragments._TupleLiteralExp__LiteralExp.initOperations(_TupleLiteralExp__LiteralExp);
			Fragments._TupleLiteralExp__Nameable.initOperations(_TupleLiteralExp__Nameable);
			Fragments._TupleLiteralExp__NamedElement.initOperations(_TupleLiteralExp__NamedElement);
			Fragments._TupleLiteralExp__OCLExpression.initOperations(_TupleLiteralExp__OCLExpression);
			Fragments._TupleLiteralExp__OclAny.initOperations(_TupleLiteralExp__OclAny);
			Fragments._TupleLiteralExp__OclElement.initOperations(_TupleLiteralExp__OclElement);
			Fragments._TupleLiteralExp__TupleLiteralExp.initOperations(_TupleLiteralExp__TupleLiteralExp);
			Fragments._TupleLiteralExp__TypedElement.initOperations(_TupleLiteralExp__TypedElement);
			Fragments._TupleLiteralExp__Visitable.initOperations(_TupleLiteralExp__Visitable);

			Fragments._TupleLiteralPart__Element.initOperations(_TupleLiteralPart__Element);
			Fragments._TupleLiteralPart__Nameable.initOperations(_TupleLiteralPart__Nameable);
			Fragments._TupleLiteralPart__NamedElement.initOperations(_TupleLiteralPart__NamedElement);
			Fragments._TupleLiteralPart__OclAny.initOperations(_TupleLiteralPart__OclAny);
			Fragments._TupleLiteralPart__OclElement.initOperations(_TupleLiteralPart__OclElement);
			Fragments._TupleLiteralPart__TupleLiteralPart.initOperations(_TupleLiteralPart__TupleLiteralPart);
			Fragments._TupleLiteralPart__TypedElement.initOperations(_TupleLiteralPart__TypedElement);
			Fragments._TupleLiteralPart__VariableDeclaration.initOperations(_TupleLiteralPart__VariableDeclaration);
			Fragments._TupleLiteralPart__Visitable.initOperations(_TupleLiteralPart__Visitable);

			Fragments._TupleType__Class.initOperations(_TupleType__Class);
			Fragments._TupleType__DataType.initOperations(_TupleType__DataType);
			Fragments._TupleType__Element.initOperations(_TupleType__Element);
			Fragments._TupleType__Nameable.initOperations(_TupleType__Nameable);
			Fragments._TupleType__NamedElement.initOperations(_TupleType__NamedElement);
			Fragments._TupleType__Namespace.initOperations(_TupleType__Namespace);
			Fragments._TupleType__OclAny.initOperations(_TupleType__OclAny);
			Fragments._TupleType__OclElement.initOperations(_TupleType__OclElement);
			Fragments._TupleType__OclType.initOperations(_TupleType__OclType);
			Fragments._TupleType__PackageableElement.initOperations(_TupleType__PackageableElement);
			Fragments._TupleType__ParameterableElement.initOperations(_TupleType__ParameterableElement);
			Fragments._TupleType__TemplateableElement.initOperations(_TupleType__TemplateableElement);
			Fragments._TupleType__TupleType.initOperations(_TupleType__TupleType);
			Fragments._TupleType__Type.initOperations(_TupleType__Type);
			Fragments._TupleType__Visitable.initOperations(_TupleType__Visitable);

			Fragments._Type__Element.initOperations(_Type__Element);
			Fragments._Type__Nameable.initOperations(_Type__Nameable);
			Fragments._Type__NamedElement.initOperations(_Type__NamedElement);
			Fragments._Type__OclAny.initOperations(_Type__OclAny);
			Fragments._Type__OclElement.initOperations(_Type__OclElement);
			Fragments._Type__OclType.initOperations(_Type__OclType);
			Fragments._Type__PackageableElement.initOperations(_Type__PackageableElement);
			Fragments._Type__ParameterableElement.initOperations(_Type__ParameterableElement);
			Fragments._Type__TemplateableElement.initOperations(_Type__TemplateableElement);
			Fragments._Type__Type.initOperations(_Type__Type);
			Fragments._Type__Visitable.initOperations(_Type__Visitable);

			Fragments._TypeExp__Element.initOperations(_TypeExp__Element);
			Fragments._TypeExp__Nameable.initOperations(_TypeExp__Nameable);
			Fragments._TypeExp__NamedElement.initOperations(_TypeExp__NamedElement);
			Fragments._TypeExp__OCLExpression.initOperations(_TypeExp__OCLExpression);
			Fragments._TypeExp__OclAny.initOperations(_TypeExp__OclAny);
			Fragments._TypeExp__OclElement.initOperations(_TypeExp__OclElement);
			Fragments._TypeExp__ReferringElement.initOperations(_TypeExp__ReferringElement);
			Fragments._TypeExp__TypeExp.initOperations(_TypeExp__TypeExp);
			Fragments._TypeExp__TypedElement.initOperations(_TypeExp__TypedElement);
			Fragments._TypeExp__Visitable.initOperations(_TypeExp__Visitable);

			Fragments._TypeTemplateParameter__Element.initOperations(_TypeTemplateParameter__Element);
			Fragments._TypeTemplateParameter__OclAny.initOperations(_TypeTemplateParameter__OclAny);
			Fragments._TypeTemplateParameter__OclElement.initOperations(_TypeTemplateParameter__OclElement);
			Fragments._TypeTemplateParameter__TemplateParameter.initOperations(_TypeTemplateParameter__TemplateParameter);
			Fragments._TypeTemplateParameter__TypeTemplateParameter.initOperations(_TypeTemplateParameter__TypeTemplateParameter);
			Fragments._TypeTemplateParameter__Visitable.initOperations(_TypeTemplateParameter__Visitable);

			Fragments._TypedElement__Element.initOperations(_TypedElement__Element);
			Fragments._TypedElement__Nameable.initOperations(_TypedElement__Nameable);
			Fragments._TypedElement__NamedElement.initOperations(_TypedElement__NamedElement);
			Fragments._TypedElement__OclAny.initOperations(_TypedElement__OclAny);
			Fragments._TypedElement__OclElement.initOperations(_TypedElement__OclElement);
			Fragments._TypedElement__TypedElement.initOperations(_TypedElement__TypedElement);
			Fragments._TypedElement__Visitable.initOperations(_TypedElement__Visitable);

			Fragments._TypedMultiplicityElement__Element.initOperations(_TypedMultiplicityElement__Element);
			Fragments._TypedMultiplicityElement__Nameable.initOperations(_TypedMultiplicityElement__Nameable);
			Fragments._TypedMultiplicityElement__NamedElement.initOperations(_TypedMultiplicityElement__NamedElement);
			Fragments._TypedMultiplicityElement__OclAny.initOperations(_TypedMultiplicityElement__OclAny);
			Fragments._TypedMultiplicityElement__OclElement.initOperations(_TypedMultiplicityElement__OclElement);
			Fragments._TypedMultiplicityElement__TypedElement.initOperations(_TypedMultiplicityElement__TypedElement);
			Fragments._TypedMultiplicityElement__TypedMultiplicityElement.initOperations(_TypedMultiplicityElement__TypedMultiplicityElement);
			Fragments._TypedMultiplicityElement__Visitable.initOperations(_TypedMultiplicityElement__Visitable);

			Fragments._UnlimitedNaturalLiteralExp__Element.initOperations(_UnlimitedNaturalLiteralExp__Element);
			Fragments._UnlimitedNaturalLiteralExp__LiteralExp.initOperations(_UnlimitedNaturalLiteralExp__LiteralExp);
			Fragments._UnlimitedNaturalLiteralExp__Nameable.initOperations(_UnlimitedNaturalLiteralExp__Nameable);
			Fragments._UnlimitedNaturalLiteralExp__NamedElement.initOperations(_UnlimitedNaturalLiteralExp__NamedElement);
			Fragments._UnlimitedNaturalLiteralExp__NumericLiteralExp.initOperations(_UnlimitedNaturalLiteralExp__NumericLiteralExp);
			Fragments._UnlimitedNaturalLiteralExp__OCLExpression.initOperations(_UnlimitedNaturalLiteralExp__OCLExpression);
			Fragments._UnlimitedNaturalLiteralExp__OclAny.initOperations(_UnlimitedNaturalLiteralExp__OclAny);
			Fragments._UnlimitedNaturalLiteralExp__OclElement.initOperations(_UnlimitedNaturalLiteralExp__OclElement);
			Fragments._UnlimitedNaturalLiteralExp__PrimitiveLiteralExp.initOperations(_UnlimitedNaturalLiteralExp__PrimitiveLiteralExp);
			Fragments._UnlimitedNaturalLiteralExp__TypedElement.initOperations(_UnlimitedNaturalLiteralExp__TypedElement);
			Fragments._UnlimitedNaturalLiteralExp__UnlimitedNaturalLiteralExp.initOperations(_UnlimitedNaturalLiteralExp__UnlimitedNaturalLiteralExp);
			Fragments._UnlimitedNaturalLiteralExp__Visitable.initOperations(_UnlimitedNaturalLiteralExp__Visitable);

			Fragments._UnspecifiedType__Class.initOperations(_UnspecifiedType__Class);
			Fragments._UnspecifiedType__Element.initOperations(_UnspecifiedType__Element);
			Fragments._UnspecifiedType__Nameable.initOperations(_UnspecifiedType__Nameable);
			Fragments._UnspecifiedType__NamedElement.initOperations(_UnspecifiedType__NamedElement);
			Fragments._UnspecifiedType__Namespace.initOperations(_UnspecifiedType__Namespace);
			Fragments._UnspecifiedType__OclAny.initOperations(_UnspecifiedType__OclAny);
			Fragments._UnspecifiedType__OclElement.initOperations(_UnspecifiedType__OclElement);
			Fragments._UnspecifiedType__OclType.initOperations(_UnspecifiedType__OclType);
			Fragments._UnspecifiedType__PackageableElement.initOperations(_UnspecifiedType__PackageableElement);
			Fragments._UnspecifiedType__ParameterableElement.initOperations(_UnspecifiedType__ParameterableElement);
			Fragments._UnspecifiedType__TemplateableElement.initOperations(_UnspecifiedType__TemplateableElement);
			Fragments._UnspecifiedType__Type.initOperations(_UnspecifiedType__Type);
			Fragments._UnspecifiedType__UnspecifiedType.initOperations(_UnspecifiedType__UnspecifiedType);
			Fragments._UnspecifiedType__Visitable.initOperations(_UnspecifiedType__Visitable);

			Fragments._UnspecifiedValueExp__Element.initOperations(_UnspecifiedValueExp__Element);
			Fragments._UnspecifiedValueExp__Nameable.initOperations(_UnspecifiedValueExp__Nameable);
			Fragments._UnspecifiedValueExp__NamedElement.initOperations(_UnspecifiedValueExp__NamedElement);
			Fragments._UnspecifiedValueExp__OCLExpression.initOperations(_UnspecifiedValueExp__OCLExpression);
			Fragments._UnspecifiedValueExp__OclAny.initOperations(_UnspecifiedValueExp__OclAny);
			Fragments._UnspecifiedValueExp__OclElement.initOperations(_UnspecifiedValueExp__OclElement);
			Fragments._UnspecifiedValueExp__TypedElement.initOperations(_UnspecifiedValueExp__TypedElement);
			Fragments._UnspecifiedValueExp__UnspecifiedValueExp.initOperations(_UnspecifiedValueExp__UnspecifiedValueExp);
			Fragments._UnspecifiedValueExp__Visitable.initOperations(_UnspecifiedValueExp__Visitable);

			Fragments._ValueSpecification__Element.initOperations(_ValueSpecification__Element);
			Fragments._ValueSpecification__Nameable.initOperations(_ValueSpecification__Nameable);
			Fragments._ValueSpecification__NamedElement.initOperations(_ValueSpecification__NamedElement);
			Fragments._ValueSpecification__OclAny.initOperations(_ValueSpecification__OclAny);
			Fragments._ValueSpecification__OclElement.initOperations(_ValueSpecification__OclElement);
			Fragments._ValueSpecification__PackageableElement.initOperations(_ValueSpecification__PackageableElement);
			Fragments._ValueSpecification__ParameterableElement.initOperations(_ValueSpecification__ParameterableElement);
			Fragments._ValueSpecification__TypedElement.initOperations(_ValueSpecification__TypedElement);
			Fragments._ValueSpecification__ValueSpecification.initOperations(_ValueSpecification__ValueSpecification);
			Fragments._ValueSpecification__Visitable.initOperations(_ValueSpecification__Visitable);

			Fragments._Variable__Element.initOperations(_Variable__Element);
			Fragments._Variable__Nameable.initOperations(_Variable__Nameable);
			Fragments._Variable__NamedElement.initOperations(_Variable__NamedElement);
			Fragments._Variable__OclAny.initOperations(_Variable__OclAny);
			Fragments._Variable__OclElement.initOperations(_Variable__OclElement);
			Fragments._Variable__ParameterableElement.initOperations(_Variable__ParameterableElement);
			Fragments._Variable__TypedElement.initOperations(_Variable__TypedElement);
			Fragments._Variable__Variable.initOperations(_Variable__Variable);
			Fragments._Variable__VariableDeclaration.initOperations(_Variable__VariableDeclaration);
			Fragments._Variable__Visitable.initOperations(_Variable__Visitable);

			Fragments._VariableDeclaration__Element.initOperations(_VariableDeclaration__Element);
			Fragments._VariableDeclaration__Nameable.initOperations(_VariableDeclaration__Nameable);
			Fragments._VariableDeclaration__NamedElement.initOperations(_VariableDeclaration__NamedElement);
			Fragments._VariableDeclaration__OclAny.initOperations(_VariableDeclaration__OclAny);
			Fragments._VariableDeclaration__OclElement.initOperations(_VariableDeclaration__OclElement);
			Fragments._VariableDeclaration__TypedElement.initOperations(_VariableDeclaration__TypedElement);
			Fragments._VariableDeclaration__VariableDeclaration.initOperations(_VariableDeclaration__VariableDeclaration);
			Fragments._VariableDeclaration__Visitable.initOperations(_VariableDeclaration__Visitable);

			Fragments._VariableExp__Element.initOperations(_VariableExp__Element);
			Fragments._VariableExp__Nameable.initOperations(_VariableExp__Nameable);
			Fragments._VariableExp__NamedElement.initOperations(_VariableExp__NamedElement);
			Fragments._VariableExp__OCLExpression.initOperations(_VariableExp__OCLExpression);
			Fragments._VariableExp__OclAny.initOperations(_VariableExp__OclAny);
			Fragments._VariableExp__OclElement.initOperations(_VariableExp__OclElement);
			Fragments._VariableExp__ReferringElement.initOperations(_VariableExp__ReferringElement);
			Fragments._VariableExp__TypedElement.initOperations(_VariableExp__TypedElement);
			Fragments._VariableExp__VariableExp.initOperations(_VariableExp__VariableExp);
			Fragments._VariableExp__Visitable.initOperations(_VariableExp__Visitable);

			Fragments._Vertex__Element.initOperations(_Vertex__Element);
			Fragments._Vertex__Nameable.initOperations(_Vertex__Nameable);
			Fragments._Vertex__NamedElement.initOperations(_Vertex__NamedElement);
			Fragments._Vertex__OclAny.initOperations(_Vertex__OclAny);
			Fragments._Vertex__OclElement.initOperations(_Vertex__OclElement);
			Fragments._Vertex__Vertex.initOperations(_Vertex__Vertex);
			Fragments._Vertex__Visitable.initOperations(_Vertex__Visitable);

			Fragments._Visitable__OclAny.initOperations(_Visitable__OclAny);
			Fragments._Visitable__OclElement.initOperations(_Visitable__OclElement);
			Fragments._Visitable__Visitable.initOperations(_Visitable__Visitable);

			Fragments._Visitor__OclAny.initOperations(_Visitor__OclAny);
			Fragments._Visitor__OclElement.initOperations(_Visitor__OclElement);
			Fragments._Visitor__Visitor.initOperations(_Visitor__Visitor);

			Fragments._VoidType__Class.initOperations(_VoidType__Class);
			Fragments._VoidType__Element.initOperations(_VoidType__Element);
			Fragments._VoidType__Nameable.initOperations(_VoidType__Nameable);
			Fragments._VoidType__NamedElement.initOperations(_VoidType__NamedElement);
			Fragments._VoidType__Namespace.initOperations(_VoidType__Namespace);
			Fragments._VoidType__OclAny.initOperations(_VoidType__OclAny);
			Fragments._VoidType__OclElement.initOperations(_VoidType__OclElement);
			Fragments._VoidType__OclType.initOperations(_VoidType__OclType);
			Fragments._VoidType__PackageableElement.initOperations(_VoidType__PackageableElement);
			Fragments._VoidType__ParameterableElement.initOperations(_VoidType__ParameterableElement);
			Fragments._VoidType__TemplateableElement.initOperations(_VoidType__TemplateableElement);
			Fragments._VoidType__Type.initOperations(_VoidType__Type);
			Fragments._VoidType__Visitable.initOperations(_VoidType__Visitable);
			Fragments._VoidType__VoidType.initOperations(_VoidType__VoidType);
		}

		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		private static final @NonNull ExecutorProperty[] _Annotation = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Annotation__NamedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Annotation__ownedContent,
			PivotTables.Properties._Annotation__ownedDetail,
			PivotTables.Properties._Annotation__reference
		};

		private static final @NonNull ExecutorProperty[] _AnyType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _AssociationClass = {
			PivotTables.Properties._AssociationClass__AssociationClassCallExp,
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._AssociationClass__unownedAttribute,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _AssociationClassCallExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._CallExp__implicit,
			PivotTables.Properties._FeatureCallExp__isPre,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NavigationCallExp__navigationSource,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._NavigationCallExp__qualifier,
			PivotTables.Properties._AssociationClassCallExp__referredAssociationClass,
			PivotTables.Properties._CallExp__source,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _AssociativityKind = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Enumeration__ownedLiteral,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _BagType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._CollectionType__elementType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._CollectionType__lower,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement,
			PivotTables.Properties._CollectionType__upper
		};

		private static final @NonNull ExecutorProperty[] _Behavior = {
			PivotTables.Properties._Behavior__Class,
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Behavior__Transition,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _BooleanLiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._BooleanLiteralExp__booleanSymbol,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _CallExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._CallExp__implicit,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._CallExp__source,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _CallOperationAction = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._CallOperationAction__MessageExp,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._CallOperationAction__operation,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment
		};

		private static final @NonNull ExecutorProperty[] _Class = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _CollectionItem = {
			PivotTables.Properties._CollectionLiteralPart__CollectionLiteralExp,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._CollectionItem__item,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _CollectionKind = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Enumeration__ownedLiteral,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _CollectionLiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._CollectionLiteralExp__kind,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._CollectionLiteralExp__part,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _CollectionLiteralPart = {
			PivotTables.Properties._CollectionLiteralPart__CollectionLiteralExp,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _CollectionRange = {
			PivotTables.Properties._CollectionLiteralPart__CollectionLiteralExp,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._CollectionRange__first,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._CollectionRange__last,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _CollectionType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._CollectionType__elementType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._CollectionType__lower,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement,
			PivotTables.Properties._CollectionType__upper
		};

		private static final @NonNull ExecutorProperty[] _Comment = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Comment__Element,
			PivotTables.Properties._Comment__annotatedElement,
			PivotTables.Properties._Comment__body,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Element__ownedComment
		};

		private static final @NonNull ExecutorProperty[] _ConnectionPointReference = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Vertex__container,
			PivotTables.Properties._ConnectionPointReference__entry,
			PivotTables.Properties._ConnectionPointReference__exit,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Vertex__incoming,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Vertex__outgoing,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ConnectionPointReference__state
		};

		private static final @NonNull ExecutorProperty[] _Constraint = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Constraint__Namespace,
			PivotTables.Properties._Constraint__State,
			PivotTables.Properties._Constraint__Transition,
			PivotTables.Properties._Constraint__Type,
			PivotTables.Properties._Constraint__constrainedElement,
			PivotTables.Properties._Constraint__context,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Constraint__isCallable,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Constraint__specification,
			PivotTables.Properties._ParameterableElement__templateParameter
		};

		private static final @NonNull ExecutorProperty[] _ConstructorExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ConstructorExp__part,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._ConstructorExp__value
		};

		private static final @NonNull ExecutorProperty[] _ConstructorPart = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._ConstructorPart__ConstructorExp,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._ConstructorPart__initExpression,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ConstructorPart__referredProperty,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _DataType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _Detail = {
			PivotTables.Properties._Detail__Annotation,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Detail__value
		};

		private static final @NonNull ExecutorProperty[] _DynamicElement = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._DynamicElement__metaType,
			PivotTables.Properties._Element__ownedComment
		};

		private static final @NonNull ExecutorProperty[] _DynamicProperty = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._DynamicProperty__DynamicType,
			PivotTables.Properties._DynamicProperty__default,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._DynamicProperty__referredProperty
		};

		private static final @NonNull ExecutorProperty[] _DynamicType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._DynamicElement__metaType,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._DynamicType__ownedProperty,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _Element = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Element__ownedComment
		};

		private static final @NonNull ExecutorProperty[] _ElementExtension = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._ElementExtension__base,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._ElementExtension__stereotype,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _EnumLiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._EnumLiteralExp__referredEnumLiteral,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _Enumeration = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Enumeration__ownedLiteral,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _EnumerationLiteral = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._EnumerationLiteral__EnumLiteralExp,
			PivotTables.Properties._EnumerationLiteral__enumeration,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._EnumerationLiteral__value
		};

		private static final @NonNull ExecutorProperty[] _ExpressionInOCL = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OpaqueExpression__Constraint,
			PivotTables.Properties._OpaqueExpression__Operation,
			PivotTables.Properties._OpaqueExpression__Property,
			PivotTables.Properties._OpaqueExpression__body,
			PivotTables.Properties._ExpressionInOCL__bodyExpression,
			PivotTables.Properties._ExpressionInOCL__contextVariable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._OpaqueExpression__language,
			PivotTables.Properties._OpaqueExpression__message,
			PivotTables.Properties._ExpressionInOCL__messageExpression,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._ExpressionInOCL__parameterVariable,
			PivotTables.Properties._ExpressionInOCL__resultVariable,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _Feature = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Feature__implementation,
			PivotTables.Properties._Feature__implementationClass,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._Feature__isStatic,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _FeatureCallExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._CallExp__implicit,
			PivotTables.Properties._FeatureCallExp__isPre,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._CallExp__source,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _FinalState = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._State__State,
			PivotTables.Properties._State__StateExp,
			PivotTables.Properties._State__connection,
			PivotTables.Properties._State__connectionPoint,
			PivotTables.Properties._Vertex__container,
			PivotTables.Properties._State__deferrableTrigger,
			PivotTables.Properties._State__doActivity,
			PivotTables.Properties._State__entry,
			PivotTables.Properties._State__exit,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Vertex__incoming,
			PivotTables.Properties._State__isComposite,
			PivotTables.Properties._State__isOrthogonal,
			PivotTables.Properties._State__isSimple,
			PivotTables.Properties._State__isSubmachineState,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Vertex__outgoing,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._State__redefinedState,
			PivotTables.Properties._State__region,
			PivotTables.Properties._State__stateInvariant,
			PivotTables.Properties._State__submachine
		};

		private static final @NonNull ExecutorProperty[] _IfExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._IfExp__condition,
			PivotTables.Properties._IfExp__elseExpression,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._IfExp__thenExpression,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _Import = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Import__Root,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Import__importedNamespace,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment
		};

		private static final @NonNull ExecutorProperty[] _IntegerLiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._IntegerLiteralExp__integerSymbol,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _InvalidLiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _InvalidType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _IterateExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._LoopExp__body,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._CallExp__implicit,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._LoopExp__iterator,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._LoopExp__referredIteration,
			PivotTables.Properties._IterateExp__result,
			PivotTables.Properties._CallExp__source,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _Iteration = {
			PivotTables.Properties._Operation__CallOperationAction,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Iteration__LoopExp,
			PivotTables.Properties._Operation__MessageType,
			PivotTables.Properties._Operation__Operation,
			PivotTables.Properties._Operation__OperationCallExp,
			PivotTables.Properties._Operation__bodyExpression,
			PivotTables.Properties._Operation__class,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Feature__implementation,
			PivotTables.Properties._Feature__implementationClass,
			PivotTables.Properties._Operation__isInvalidating,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._Feature__isStatic,
			PivotTables.Properties._Operation__isValidating,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Iteration__ownedAccumulator,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Iteration__ownedIterator,
			PivotTables.Properties._Operation__ownedParameter,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Operation__owningType,
			PivotTables.Properties._Operation__postcondition,
			PivotTables.Properties._Operation__precedence,
			PivotTables.Properties._Operation__precondition,
			PivotTables.Properties._Operation__raisedException,
			PivotTables.Properties._Operation__redefinedOperation,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _IteratorExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._LoopExp__body,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._CallExp__implicit,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._LoopExp__iterator,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._LoopExp__referredIteration,
			PivotTables.Properties._CallExp__source,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _LambdaType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._LambdaType__contextType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._LambdaType__parameterType,
			PivotTables.Properties._LambdaType__resultType,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _LetExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._LetExp__in,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._LetExp__variable
		};

		private static final @NonNull ExecutorProperty[] _Library = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Package__Package,
			PivotTables.Properties._Package__Root,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Package__importedPackage,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Package__nestedPackage,
			PivotTables.Properties._Package__nestingPackage,
			PivotTables.Properties._Package__nsPrefix,
			PivotTables.Properties._Package__nsURI,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Library__ownedPrecedence,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._Package__ownedType,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _LibraryFeature = {};

		private static final @NonNull ExecutorProperty[] _LiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _LoopExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._LoopExp__body,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._CallExp__implicit,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._LoopExp__iterator,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._LoopExp__referredIteration,
			PivotTables.Properties._CallExp__source,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _MessageExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._MessageExp__argument,
			PivotTables.Properties._MessageExp__calledOperation,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._MessageExp__sentSignal,
			PivotTables.Properties._MessageExp__target,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _MessageType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._MessageType__referredOperation,
			PivotTables.Properties._MessageType__referredSignal,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _Metaclass = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Metaclass__instanceType,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _MorePivotable = {};

		private static final @NonNull ExecutorProperty[] _Nameable = {};

		private static final @NonNull ExecutorProperty[] _NamedElement = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment
		};

		private static final @NonNull ExecutorProperty[] _Namespace = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Namespace__ownedRule
		};

		private static final @NonNull ExecutorProperty[] _NavigationCallExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._CallExp__implicit,
			PivotTables.Properties._FeatureCallExp__isPre,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NavigationCallExp__navigationSource,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._NavigationCallExp__qualifier,
			PivotTables.Properties._CallExp__source,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _NullLiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _NumericLiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _OCLExpression = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _Object = {};

		private static final @NonNull ExecutorProperty[] _OpaqueExpression = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OpaqueExpression__Constraint,
			PivotTables.Properties._OpaqueExpression__Operation,
			PivotTables.Properties._OpaqueExpression__Property,
			PivotTables.Properties._OpaqueExpression__body,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._OpaqueExpression__language,
			PivotTables.Properties._OpaqueExpression__message,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _Operation = {
			PivotTables.Properties._Operation__CallOperationAction,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Operation__MessageType,
			PivotTables.Properties._Operation__Operation,
			PivotTables.Properties._Operation__OperationCallExp,
			PivotTables.Properties._Operation__bodyExpression,
			PivotTables.Properties._Operation__class,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Feature__implementation,
			PivotTables.Properties._Feature__implementationClass,
			PivotTables.Properties._Operation__isInvalidating,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._Feature__isStatic,
			PivotTables.Properties._Operation__isValidating,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Operation__ownedParameter,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Operation__owningType,
			PivotTables.Properties._Operation__postcondition,
			PivotTables.Properties._Operation__precedence,
			PivotTables.Properties._Operation__precondition,
			PivotTables.Properties._Operation__raisedException,
			PivotTables.Properties._Operation__redefinedOperation,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _OperationCallExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._OperationCallExp__argument,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._CallExp__implicit,
			PivotTables.Properties._FeatureCallExp__isPre,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._OperationCallExp__referredOperation,
			PivotTables.Properties._CallExp__source,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _OperationTemplateParameter = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._TemplateParameter__TemplateParameterSubstitution,
			PivotTables.Properties._TemplateParameter__TemplateSignature,
			PivotTables.Properties._TemplateParameter__default,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TemplateParameter__ownedDefault,
			PivotTables.Properties._TemplateParameter__ownedParameteredElement,
			PivotTables.Properties._TemplateParameter__parameteredElement,
			PivotTables.Properties._TemplateParameter__signature
		};

		private static final @NonNull ExecutorProperty[] _OrderedSetType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._CollectionType__elementType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._CollectionType__lower,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement,
			PivotTables.Properties._CollectionType__upper
		};

		private static final @NonNull ExecutorProperty[] _Package = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Package__Package,
			PivotTables.Properties._Package__Root,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Package__importedPackage,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Package__nestedPackage,
			PivotTables.Properties._Package__nestingPackage,
			PivotTables.Properties._Package__nsPrefix,
			PivotTables.Properties._Package__nsURI,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._Package__ownedType,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _PackageableElement = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._ParameterableElement__templateParameter
		};

		private static final @NonNull ExecutorProperty[] _Parameter = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Parameter__Variable,
			PivotTables.Properties._VariableDeclaration__VariableExp,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Parameter__operation,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _ParameterableElement = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._ParameterableElement__templateParameter
		};

		private static final @NonNull ExecutorProperty[] _Pivotable = {};

		private static final @NonNull ExecutorProperty[] _Precedence = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Precedence__Library,
			PivotTables.Properties._Precedence__Operation,
			PivotTables.Properties._Precedence__associativity,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Precedence__order,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment
		};

		private static final @NonNull ExecutorProperty[] _PrimitiveLiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _PrimitiveType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _Profile = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Package__Package,
			PivotTables.Properties._Package__Root,
			PivotTables.Properties._Profile__Stereotype,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Package__importedPackage,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Package__nestedPackage,
			PivotTables.Properties._Package__nestingPackage,
			PivotTables.Properties._Package__nsPrefix,
			PivotTables.Properties._Package__nsURI,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._Package__ownedType,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _Property = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Property__ConstructorPart,
			PivotTables.Properties._Property__DynamicProperty,
			PivotTables.Properties._Property__NavigationCallExp,
			PivotTables.Properties._Property__PropertyCallExp,
			PivotTables.Properties._Property__association,
			PivotTables.Properties._Property__class,
			PivotTables.Properties._Property__default,
			PivotTables.Properties._Property__defaultExpression,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Feature__implementation,
			PivotTables.Properties._Feature__implementationClass,
			PivotTables.Properties._Property__implicit,
			PivotTables.Properties._Property__isComposite,
			PivotTables.Properties._Property__isDerived,
			PivotTables.Properties._Property__isID,
			PivotTables.Properties._Property__isReadOnly,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._Property__isResolveProxies,
			PivotTables.Properties._Feature__isStatic,
			PivotTables.Properties._Property__isTransient,
			PivotTables.Properties._Property__isUnsettable,
			PivotTables.Properties._Property__isVolatile,
			PivotTables.Properties._Property__keys,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Property__opposite,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Property__owningType,
			PivotTables.Properties._Property__redefinedProperty,
			PivotTables.Properties._Property__referredProperty,
			PivotTables.Properties._Property__subsettedProperty,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _PropertyCallExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._CallExp__implicit,
			PivotTables.Properties._FeatureCallExp__isPre,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NavigationCallExp__navigationSource,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._NavigationCallExp__qualifier,
			PivotTables.Properties._PropertyCallExp__referredProperty,
			PivotTables.Properties._CallExp__source,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _Pseudostate = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Vertex__container,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Vertex__incoming,
			PivotTables.Properties._Pseudostate__kind,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Vertex__outgoing,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Pseudostate__state,
			PivotTables.Properties._Pseudostate__stateMachine
		};

		private static final @NonNull ExecutorProperty[] _PseudostateKind = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Enumeration__ownedLiteral,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _RealLiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._RealLiteralExp__realSymbol,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _ReferringElement = {};

		private static final @NonNull ExecutorProperty[] _Region = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Region__Region,
			PivotTables.Properties._Region__extendedRegion,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._Region__state,
			PivotTables.Properties._Region__stateMachine,
			PivotTables.Properties._Region__subvertex,
			PivotTables.Properties._Region__transition
		};

		private static final @NonNull ExecutorProperty[] _Root = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Root__externalURI,
			PivotTables.Properties._Root__imports,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Root__nestedPackage,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Namespace__ownedRule
		};

		private static final @NonNull ExecutorProperty[] _SelfType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _SendSignalAction = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._SendSignalAction__MessageExp,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._SendSignalAction__signal
		};

		private static final @NonNull ExecutorProperty[] _SequenceType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._CollectionType__elementType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._CollectionType__lower,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement,
			PivotTables.Properties._CollectionType__upper
		};

		private static final @NonNull ExecutorProperty[] _SetType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._CollectionType__elementType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._CollectionType__lower,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement,
			PivotTables.Properties._CollectionType__upper
		};

		private static final @NonNull ExecutorProperty[] _Signal = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Signal__MessageType,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Signal__SendSignalAction,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _State = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._State__State,
			PivotTables.Properties._State__StateExp,
			PivotTables.Properties._State__connection,
			PivotTables.Properties._State__connectionPoint,
			PivotTables.Properties._Vertex__container,
			PivotTables.Properties._State__deferrableTrigger,
			PivotTables.Properties._State__doActivity,
			PivotTables.Properties._State__entry,
			PivotTables.Properties._State__exit,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Vertex__incoming,
			PivotTables.Properties._State__isComposite,
			PivotTables.Properties._State__isOrthogonal,
			PivotTables.Properties._State__isSimple,
			PivotTables.Properties._State__isSubmachineState,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Vertex__outgoing,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._State__redefinedState,
			PivotTables.Properties._State__region,
			PivotTables.Properties._State__stateInvariant,
			PivotTables.Properties._State__submachine
		};

		private static final @NonNull ExecutorProperty[] _StateExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._StateExp__referredState,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _StateMachine = {
			PivotTables.Properties._Behavior__Class,
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._StateMachine__StateMachine,
			PivotTables.Properties._Behavior__Transition,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._StateMachine__connectionPoint,
			PivotTables.Properties._StateMachine__extendedStateMachine,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._StateMachine__region,
			PivotTables.Properties._StateMachine__submachineState,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _Stereotype = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Stereotype__profile,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _StringLiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._StringLiteralExp__stringSymbol,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _TemplateBinding = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._TemplateBinding__boundElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TemplateBinding__parameterSubstitution,
			PivotTables.Properties._TemplateBinding__signature
		};

		private static final @NonNull ExecutorProperty[] _TemplateParameter = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._TemplateParameter__TemplateParameterSubstitution,
			PivotTables.Properties._TemplateParameter__TemplateSignature,
			PivotTables.Properties._TemplateParameter__default,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TemplateParameter__ownedDefault,
			PivotTables.Properties._TemplateParameter__ownedParameteredElement,
			PivotTables.Properties._TemplateParameter__parameteredElement,
			PivotTables.Properties._TemplateParameter__signature
		};

		private static final @NonNull ExecutorProperty[] _TemplateParameterSubstitution = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._TemplateParameterSubstitution__actual,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TemplateParameterSubstitution__formal,
			PivotTables.Properties._TemplateParameterSubstitution__ownedActual,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TemplateParameterSubstitution__templateBinding
		};

		private static final @NonNull ExecutorProperty[] _TemplateParameterType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._TemplateParameterType__specification,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _TemplateSignature = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._TemplateSignature__TemplateBinding,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TemplateSignature__ownedParameter,
			PivotTables.Properties._TemplateSignature__parameter,
			PivotTables.Properties._TemplateSignature__template
		};

		private static final @NonNull ExecutorProperty[] _TemplateableElement = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _Throwable = {};

		private static final @NonNull ExecutorProperty[] _Transition = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Transition__container,
			PivotTables.Properties._Transition__effect,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Transition__guard,
			PivotTables.Properties._Transition__kind,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._Transition__source,
			PivotTables.Properties._Transition__target,
			PivotTables.Properties._Transition__trigger
		};

		private static final @NonNull ExecutorProperty[] _TransitionKind = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Enumeration__ownedLiteral,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _Trigger = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Trigger__State,
			PivotTables.Properties._Trigger__Transition,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment
		};

		private static final @NonNull ExecutorProperty[] _TupleLiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TupleLiteralExp__part,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _TupleLiteralPart = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._TupleLiteralPart__TupleLiteralExp,
			PivotTables.Properties._VariableDeclaration__VariableExp,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TupleLiteralPart__initExpression,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _TupleType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._DataType__behavioralType,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._DataType__isSerializable,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _Type = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		private static final @NonNull ExecutorProperty[] _TypeExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypeExp__referredType,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _TypeTemplateParameter = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._TemplateParameter__TemplateParameterSubstitution,
			PivotTables.Properties._TemplateParameter__TemplateSignature,
			PivotTables.Properties._TypeTemplateParameter__allowSubstitutable,
			PivotTables.Properties._TypeTemplateParameter__constrainingClassifier,
			PivotTables.Properties._TemplateParameter__default,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TemplateParameter__ownedDefault,
			PivotTables.Properties._TemplateParameter__ownedParameteredElement,
			PivotTables.Properties._TemplateParameter__parameteredElement,
			PivotTables.Properties._TemplateParameter__signature
		};

		private static final @NonNull ExecutorProperty[] _TypedElement = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _TypedMultiplicityElement = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _UnlimitedNaturalLiteralExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type,
			PivotTables.Properties._UnlimitedNaturalLiteralExp__unlimitedNaturalSymbol
		};

		private static final @NonNull ExecutorProperty[] _UnspecifiedType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._UnspecifiedType__lowerBound,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement,
			PivotTables.Properties._UnspecifiedType__upperBound
		};

		private static final @NonNull ExecutorProperty[] _UnspecifiedValueExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _ValueSpecification = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _Variable = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Variable__IterateExp,
			PivotTables.Properties._Variable__LetExp,
			PivotTables.Properties._Variable__LoopExp,
			PivotTables.Properties._VariableDeclaration__VariableExp,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Variable__implicit,
			PivotTables.Properties._Variable__initExpression,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Variable__representedParameter,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _VariableDeclaration = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._VariableDeclaration__VariableExp,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _VariableExp = {
			PivotTables.Properties._OCLExpression__CallExp,
			PivotTables.Properties._OCLExpression__CollectionItem,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._OCLExpression__ConstructorPart,
			PivotTables.Properties._OCLExpression__LetExp,
			PivotTables.Properties._OCLExpression__LoopExp,
			PivotTables.Properties._OCLExpression__NavigationCallExp,
			PivotTables.Properties._OCLExpression__OperationCallExp,
			PivotTables.Properties._OCLExpression__TupleLiteralPart,
			PivotTables.Properties._OCLExpression__Variable,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._VariableExp__implicit,
			PivotTables.Properties._TypedElement__isRequired,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._VariableExp__referredVariable,
			PivotTables.Properties._TypedElement__type
		};

		private static final @NonNull ExecutorProperty[] _Vertex = {
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Vertex__container,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Vertex__incoming,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._Vertex__outgoing,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Element__ownedComment
		};

		private static final @NonNull ExecutorProperty[] _Visitable = {};

		private static final @NonNull ExecutorProperty[] _Visitor = {};

		private static final @NonNull ExecutorProperty[] _VoidType = {
			PivotTables.Properties._Type__CollectionType,
			PivotTables.Properties._Element__Comment,
			PivotTables.Properties._Element__Constraint,
			PivotTables.Properties._Namespace__Constraint,
			PivotTables.Properties._Type__DataType,
			PivotTables.Properties._Type__DynamicElement,
			PivotTables.Properties._Type__ElementExtension,
			PivotTables.Properties._Namespace__Import,
			PivotTables.Properties._Type__Metaclass,
			PivotTables.Properties._Type__Operation,
			PivotTables.Properties._Type__Type,
			PivotTables.Properties._Type__TypeExp,
			PivotTables.Properties._Class__TypeTemplateParameter,
			PivotTables.Properties._Type__TypedElement,
			PivotTables.Properties._Element__extension,
			PivotTables.Properties._Type__instanceClassName,
			PivotTables.Properties._Class__isAbstract,
			PivotTables.Properties._Class__isInterface,
			PivotTables.Properties._NamedElement__name,
			PivotTables.Properties._NamedElement__ownedAnnotation,
			PivotTables.Properties._Type__ownedAttribute,
			PivotTables.Properties._Class__ownedBehavior,
			PivotTables.Properties._Element__ownedComment,
			PivotTables.Properties._Type__ownedInvariant,
			PivotTables.Properties._Type__ownedOperation,
			PivotTables.Properties._Namespace__ownedRule,
			PivotTables.Properties._TemplateableElement__ownedTemplateSignature,
			PivotTables.Properties._ParameterableElement__owningTemplateParameter,
			PivotTables.Properties._Type__package,
			PivotTables.Properties._Type__superClass,
			PivotTables.Properties._TemplateableElement__templateBinding,
			PivotTables.Properties._ParameterableElement__templateParameter,
			PivotTables.Properties._TemplateableElement__unspecializedElement
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Annotation__Annotation.initProperties(_Annotation);
			Fragments._AnyType__AnyType.initProperties(_AnyType);
			Fragments._AssociationClass__AssociationClass.initProperties(_AssociationClass);
			Fragments._AssociationClassCallExp__AssociationClassCallExp.initProperties(_AssociationClassCallExp);
			Fragments._AssociativityKind__AssociativityKind.initProperties(_AssociativityKind);
			Fragments._BagType__BagType.initProperties(_BagType);
			Fragments._Behavior__Behavior.initProperties(_Behavior);
			Fragments._BooleanLiteralExp__BooleanLiteralExp.initProperties(_BooleanLiteralExp);
			Fragments._CallExp__CallExp.initProperties(_CallExp);
			Fragments._CallOperationAction__CallOperationAction.initProperties(_CallOperationAction);
			Fragments._Class__Class.initProperties(_Class);
			Fragments._CollectionItem__CollectionItem.initProperties(_CollectionItem);
			Fragments._CollectionKind__CollectionKind.initProperties(_CollectionKind);
			Fragments._CollectionLiteralExp__CollectionLiteralExp.initProperties(_CollectionLiteralExp);
			Fragments._CollectionLiteralPart__CollectionLiteralPart.initProperties(_CollectionLiteralPart);
			Fragments._CollectionRange__CollectionRange.initProperties(_CollectionRange);
			Fragments._CollectionType__CollectionType.initProperties(_CollectionType);
			Fragments._Comment__Comment.initProperties(_Comment);
			Fragments._ConnectionPointReference__ConnectionPointReference.initProperties(_ConnectionPointReference);
			Fragments._Constraint__Constraint.initProperties(_Constraint);
			Fragments._ConstructorExp__ConstructorExp.initProperties(_ConstructorExp);
			Fragments._ConstructorPart__ConstructorPart.initProperties(_ConstructorPart);
			Fragments._DataType__DataType.initProperties(_DataType);
			Fragments._Detail__Detail.initProperties(_Detail);
			Fragments._DynamicElement__DynamicElement.initProperties(_DynamicElement);
			Fragments._DynamicProperty__DynamicProperty.initProperties(_DynamicProperty);
			Fragments._DynamicType__DynamicType.initProperties(_DynamicType);
			Fragments._Element__Element.initProperties(_Element);
			Fragments._ElementExtension__ElementExtension.initProperties(_ElementExtension);
			Fragments._EnumLiteralExp__EnumLiteralExp.initProperties(_EnumLiteralExp);
			Fragments._Enumeration__Enumeration.initProperties(_Enumeration);
			Fragments._EnumerationLiteral__EnumerationLiteral.initProperties(_EnumerationLiteral);
			Fragments._ExpressionInOCL__ExpressionInOCL.initProperties(_ExpressionInOCL);
			Fragments._Feature__Feature.initProperties(_Feature);
			Fragments._FeatureCallExp__FeatureCallExp.initProperties(_FeatureCallExp);
			Fragments._FinalState__FinalState.initProperties(_FinalState);
			Fragments._IfExp__IfExp.initProperties(_IfExp);
			Fragments._Import__Import.initProperties(_Import);
			Fragments._IntegerLiteralExp__IntegerLiteralExp.initProperties(_IntegerLiteralExp);
			Fragments._InvalidLiteralExp__InvalidLiteralExp.initProperties(_InvalidLiteralExp);
			Fragments._InvalidType__InvalidType.initProperties(_InvalidType);
			Fragments._IterateExp__IterateExp.initProperties(_IterateExp);
			Fragments._Iteration__Iteration.initProperties(_Iteration);
			Fragments._IteratorExp__IteratorExp.initProperties(_IteratorExp);
			Fragments._LambdaType__LambdaType.initProperties(_LambdaType);
			Fragments._LetExp__LetExp.initProperties(_LetExp);
			Fragments._Library__Library.initProperties(_Library);
			Fragments._LibraryFeature__LibraryFeature.initProperties(_LibraryFeature);
			Fragments._LiteralExp__LiteralExp.initProperties(_LiteralExp);
			Fragments._LoopExp__LoopExp.initProperties(_LoopExp);
			Fragments._MessageExp__MessageExp.initProperties(_MessageExp);
			Fragments._MessageType__MessageType.initProperties(_MessageType);
			Fragments._Metaclass__Metaclass.initProperties(_Metaclass);
			Fragments._MorePivotable__MorePivotable.initProperties(_MorePivotable);
			Fragments._Nameable__Nameable.initProperties(_Nameable);
			Fragments._NamedElement__NamedElement.initProperties(_NamedElement);
			Fragments._Namespace__Namespace.initProperties(_Namespace);
			Fragments._NavigationCallExp__NavigationCallExp.initProperties(_NavigationCallExp);
			Fragments._NullLiteralExp__NullLiteralExp.initProperties(_NullLiteralExp);
			Fragments._NumericLiteralExp__NumericLiteralExp.initProperties(_NumericLiteralExp);
			Fragments._OCLExpression__OCLExpression.initProperties(_OCLExpression);
			Fragments._Object__Object.initProperties(_Object);
			Fragments._OpaqueExpression__OpaqueExpression.initProperties(_OpaqueExpression);
			Fragments._Operation__Operation.initProperties(_Operation);
			Fragments._OperationCallExp__OperationCallExp.initProperties(_OperationCallExp);
			Fragments._OperationTemplateParameter__OperationTemplateParameter.initProperties(_OperationTemplateParameter);
			Fragments._OrderedSetType__OrderedSetType.initProperties(_OrderedSetType);
			Fragments._Package__Package.initProperties(_Package);
			Fragments._PackageableElement__PackageableElement.initProperties(_PackageableElement);
			Fragments._Parameter__Parameter.initProperties(_Parameter);
			Fragments._ParameterableElement__ParameterableElement.initProperties(_ParameterableElement);
			Fragments._Pivotable__Pivotable.initProperties(_Pivotable);
			Fragments._Precedence__Precedence.initProperties(_Precedence);
			Fragments._PrimitiveLiteralExp__PrimitiveLiteralExp.initProperties(_PrimitiveLiteralExp);
			Fragments._PrimitiveType__PrimitiveType.initProperties(_PrimitiveType);
			Fragments._Profile__Profile.initProperties(_Profile);
			Fragments._Property__Property.initProperties(_Property);
			Fragments._PropertyCallExp__PropertyCallExp.initProperties(_PropertyCallExp);
			Fragments._Pseudostate__Pseudostate.initProperties(_Pseudostate);
			Fragments._PseudostateKind__PseudostateKind.initProperties(_PseudostateKind);
			Fragments._RealLiteralExp__RealLiteralExp.initProperties(_RealLiteralExp);
			Fragments._ReferringElement__ReferringElement.initProperties(_ReferringElement);
			Fragments._Region__Region.initProperties(_Region);
			Fragments._Root__Root.initProperties(_Root);
			Fragments._SelfType__SelfType.initProperties(_SelfType);
			Fragments._SendSignalAction__SendSignalAction.initProperties(_SendSignalAction);
			Fragments._SequenceType__SequenceType.initProperties(_SequenceType);
			Fragments._SetType__SetType.initProperties(_SetType);
			Fragments._Signal__Signal.initProperties(_Signal);
			Fragments._State__State.initProperties(_State);
			Fragments._StateExp__StateExp.initProperties(_StateExp);
			Fragments._StateMachine__StateMachine.initProperties(_StateMachine);
			Fragments._Stereotype__Stereotype.initProperties(_Stereotype);
			Fragments._StringLiteralExp__StringLiteralExp.initProperties(_StringLiteralExp);
			Fragments._TemplateBinding__TemplateBinding.initProperties(_TemplateBinding);
			Fragments._TemplateParameter__TemplateParameter.initProperties(_TemplateParameter);
			Fragments._TemplateParameterSubstitution__TemplateParameterSubstitution.initProperties(_TemplateParameterSubstitution);
			Fragments._TemplateParameterType__TemplateParameterType.initProperties(_TemplateParameterType);
			Fragments._TemplateSignature__TemplateSignature.initProperties(_TemplateSignature);
			Fragments._TemplateableElement__TemplateableElement.initProperties(_TemplateableElement);
			Fragments._Throwable__Throwable.initProperties(_Throwable);
			Fragments._Transition__Transition.initProperties(_Transition);
			Fragments._TransitionKind__TransitionKind.initProperties(_TransitionKind);
			Fragments._Trigger__Trigger.initProperties(_Trigger);
			Fragments._TupleLiteralExp__TupleLiteralExp.initProperties(_TupleLiteralExp);
			Fragments._TupleLiteralPart__TupleLiteralPart.initProperties(_TupleLiteralPart);
			Fragments._TupleType__TupleType.initProperties(_TupleType);
			Fragments._Type__Type.initProperties(_Type);
			Fragments._TypeExp__TypeExp.initProperties(_TypeExp);
			Fragments._TypeTemplateParameter__TypeTemplateParameter.initProperties(_TypeTemplateParameter);
			Fragments._TypedElement__TypedElement.initProperties(_TypedElement);
			Fragments._TypedMultiplicityElement__TypedMultiplicityElement.initProperties(_TypedMultiplicityElement);
			Fragments._UnlimitedNaturalLiteralExp__UnlimitedNaturalLiteralExp.initProperties(_UnlimitedNaturalLiteralExp);
			Fragments._UnspecifiedType__UnspecifiedType.initProperties(_UnspecifiedType);
			Fragments._UnspecifiedValueExp__UnspecifiedValueExp.initProperties(_UnspecifiedValueExp);
			Fragments._ValueSpecification__ValueSpecification.initProperties(_ValueSpecification);
			Fragments._Variable__Variable.initProperties(_Variable);
			Fragments._VariableDeclaration__VariableDeclaration.initProperties(_VariableDeclaration);
			Fragments._VariableExp__VariableExp.initProperties(_VariableExp);
			Fragments._Vertex__Vertex.initProperties(_Vertex);
			Fragments._Visitable__Visitable.initProperties(_Visitable);
			Fragments._Visitor__Visitor.initProperties(_Visitor);
			Fragments._VoidType__VoidType.initProperties(_VoidType);
		}

		public static void init() {}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		public static final @NonNull EcoreExecutorEnumerationLiteral _AssociativityKind__Left = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.ASSOCIATIVITY_KIND.getEEnumLiteral("Left"), Types._AssociativityKind, 0);
		public static final @NonNull EcoreExecutorEnumerationLiteral _AssociativityKind__Right = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.ASSOCIATIVITY_KIND.getEEnumLiteral("Right"), Types._AssociativityKind, 1);
		private static final @NonNull EcoreExecutorEnumerationLiteral[] _AssociativityKind = {
			_AssociativityKind__Left,
			_AssociativityKind__Right
		};

		public static final @NonNull EcoreExecutorEnumerationLiteral _CollectionKind__Collection = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.COLLECTION_KIND.getEEnumLiteral("Collection"), Types._CollectionKind, 0);
		public static final @NonNull EcoreExecutorEnumerationLiteral _CollectionKind__Set = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.COLLECTION_KIND.getEEnumLiteral("Set"), Types._CollectionKind, 1);
		public static final @NonNull EcoreExecutorEnumerationLiteral _CollectionKind__OrderedSet = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.COLLECTION_KIND.getEEnumLiteral("OrderedSet"), Types._CollectionKind, 2);
		public static final @NonNull EcoreExecutorEnumerationLiteral _CollectionKind__Bag = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.COLLECTION_KIND.getEEnumLiteral("Bag"), Types._CollectionKind, 3);
		public static final @NonNull EcoreExecutorEnumerationLiteral _CollectionKind__Sequence = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.COLLECTION_KIND.getEEnumLiteral("Sequence"), Types._CollectionKind, 4);
		private static final @NonNull EcoreExecutorEnumerationLiteral[] _CollectionKind = {
			_CollectionKind__Collection,
			_CollectionKind__Set,
			_CollectionKind__OrderedSet,
			_CollectionKind__Bag,
			_CollectionKind__Sequence
		};

		public static final @NonNull EcoreExecutorEnumerationLiteral _PseudostateKind__choice = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.PSEUDOSTATE_KIND.getEEnumLiteral("choice"), Types._PseudostateKind, 0);
		public static final @NonNull EcoreExecutorEnumerationLiteral _PseudostateKind__deepHistory = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.PSEUDOSTATE_KIND.getEEnumLiteral("deepHistory"), Types._PseudostateKind, 1);
		public static final @NonNull EcoreExecutorEnumerationLiteral _PseudostateKind__entryPoint = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.PSEUDOSTATE_KIND.getEEnumLiteral("entryPoint"), Types._PseudostateKind, 2);
		public static final @NonNull EcoreExecutorEnumerationLiteral _PseudostateKind__exitPoint = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.PSEUDOSTATE_KIND.getEEnumLiteral("exitPoint"), Types._PseudostateKind, 3);
		public static final @NonNull EcoreExecutorEnumerationLiteral _PseudostateKind__fork = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.PSEUDOSTATE_KIND.getEEnumLiteral("fork"), Types._PseudostateKind, 4);
		public static final @NonNull EcoreExecutorEnumerationLiteral _PseudostateKind__initial = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.PSEUDOSTATE_KIND.getEEnumLiteral("initial"), Types._PseudostateKind, 5);
		public static final @NonNull EcoreExecutorEnumerationLiteral _PseudostateKind__join = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.PSEUDOSTATE_KIND.getEEnumLiteral("join"), Types._PseudostateKind, 6);
		public static final @NonNull EcoreExecutorEnumerationLiteral _PseudostateKind__junction = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.PSEUDOSTATE_KIND.getEEnumLiteral("junction"), Types._PseudostateKind, 7);
		public static final @NonNull EcoreExecutorEnumerationLiteral _PseudostateKind__shallowHistory = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.PSEUDOSTATE_KIND.getEEnumLiteral("shallowHistory"), Types._PseudostateKind, 8);
		public static final @NonNull EcoreExecutorEnumerationLiteral _PseudostateKind__terminate = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.PSEUDOSTATE_KIND.getEEnumLiteral("terminate"), Types._PseudostateKind, 9);
		private static final @NonNull EcoreExecutorEnumerationLiteral[] _PseudostateKind = {
			_PseudostateKind__choice,
			_PseudostateKind__deepHistory,
			_PseudostateKind__entryPoint,
			_PseudostateKind__exitPoint,
			_PseudostateKind__fork,
			_PseudostateKind__initial,
			_PseudostateKind__join,
			_PseudostateKind__junction,
			_PseudostateKind__shallowHistory,
			_PseudostateKind__terminate
		};

		public static final @NonNull EcoreExecutorEnumerationLiteral _TransitionKind__external = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.TRANSITION_KIND.getEEnumLiteral("external"), Types._TransitionKind, 0);
		public static final @NonNull EcoreExecutorEnumerationLiteral _TransitionKind__internal = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.TRANSITION_KIND.getEEnumLiteral("internal"), Types._TransitionKind, 1);
		public static final @NonNull EcoreExecutorEnumerationLiteral _TransitionKind__local = new EcoreExecutorEnumerationLiteral(PivotPackage.Literals.TRANSITION_KIND.getEEnumLiteral("local"), Types._TransitionKind, 2);
		private static final @NonNull EcoreExecutorEnumerationLiteral[] _TransitionKind = {
			_TransitionKind__external,
			_TransitionKind__internal,
			_TransitionKind__local
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			Types._AssociativityKind.initLiterals(_AssociativityKind);
			Types._CollectionKind.initLiterals(_CollectionKind);
			Types._PseudostateKind.initLiterals(_PseudostateKind);
			Types._TransitionKind.initLiterals(_TransitionKind);
		}

		public static void init() {}
	}

	static {
		Types.types[0].getClass();
	}
}
