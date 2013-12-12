/**
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import org.eclipse.ocl.examples.xtext.base.basecs.impl.RootPackageCSImpl;

import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;

import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.TopLevelCS;

import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.util.OCLinEcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Level CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TopLevelCSImpl extends RootPackageCSImpl implements TopLevelCS
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopLevelCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return OCLinEcoreCSPackage.Literals.TOP_LEVEL_CS;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((OCLinEcoreCSVisitor<?>)visitor).visitTopLevelCS(this);
	}

} //TopLevelCSImpl
