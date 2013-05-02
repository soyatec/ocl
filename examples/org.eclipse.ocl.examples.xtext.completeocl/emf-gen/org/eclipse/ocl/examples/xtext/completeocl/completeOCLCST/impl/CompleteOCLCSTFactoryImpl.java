/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompleteOCLCSTFactoryImpl.java,v 1.7 2011/05/20 15:26:50 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTFactory;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefOperationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefPropertyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.IncludeCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OCLMessageArgCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompleteOCLCSTFactoryImpl extends EFactoryImpl implements CompleteOCLCSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompleteOCLCSTFactory init() {
		try
		{
			CompleteOCLCSTFactory theCompleteOCLCSTFactory = (CompleteOCLCSTFactory)EPackage.Registry.INSTANCE.getEFactory(CompleteOCLCSTPackage.eNS_URI);
			if (theCompleteOCLCSTFactory != null)
			{
				return theCompleteOCLCSTFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CompleteOCLCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLCSTFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS: return createClassifierContextDeclCS();
			case CompleteOCLCSTPackage.COMPLETE_OCL_DOCUMENT_CS: return createCompleteOCLDocumentCS();
			case CompleteOCLCSTPackage.DEF_OPERATION_CS: return createDefOperationCS();
			case CompleteOCLCSTPackage.DEF_PROPERTY_CS: return createDefPropertyCS();
			case CompleteOCLCSTPackage.INCLUDE_CS: return createIncludeCS();
			case CompleteOCLCSTPackage.OCL_MESSAGE_ARG_CS: return createOCLMessageArgCS();
			case CompleteOCLCSTPackage.OPERATION_CONTEXT_DECL_CS: return createOperationContextDeclCS();
			case CompleteOCLCSTPackage.PACKAGE_DECLARATION_CS: return createPackageDeclarationCS();
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS: return createPropertyContextDeclCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageDeclarationCS createPackageDeclarationCS() {
		PackageDeclarationCSImpl packageDeclarationCS = new PackageDeclarationCSImpl();
		return packageDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyContextDeclCS createPropertyContextDeclCS() {
		PropertyContextDeclCSImpl propertyContextDeclCS = new PropertyContextDeclCSImpl();
		return propertyContextDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncludeCS createIncludeCS()
	{
		IncludeCSImpl includeCS = new IncludeCSImpl();
		return includeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierContextDeclCS createClassifierContextDeclCS() {
		ClassifierContextDeclCSImpl classifierContextDeclCS = new ClassifierContextDeclCSImpl();
		return classifierContextDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLDocumentCS createCompleteOCLDocumentCS() {
		CompleteOCLDocumentCSImpl completeOCLDocumentCS = new CompleteOCLDocumentCSImpl();
		return completeOCLDocumentCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLMessageArgCS createOCLMessageArgCS()
	{
		OCLMessageArgCSImpl oclMessageArgCS = new OCLMessageArgCSImpl();
		return oclMessageArgCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefOperationCS createDefOperationCS()
	{
		DefOperationCSImpl defOperationCS = new DefOperationCSImpl();
		return defOperationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefPropertyCS createDefPropertyCS()
	{
		DefPropertyCSImpl defPropertyCS = new DefPropertyCSImpl();
		return defPropertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationContextDeclCS createOperationContextDeclCS() {
		OperationContextDeclCSImpl operationContextDeclCS = new OperationContextDeclCSImpl();
		return operationContextDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLCSTPackage getCompleteOCLCSTPackage() {
		return (CompleteOCLCSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CompleteOCLCSTPackage getPackage() {
		return CompleteOCLCSTPackage.eINSTANCE;
	}

} //CompleteOCLCSTFactoryImpl
