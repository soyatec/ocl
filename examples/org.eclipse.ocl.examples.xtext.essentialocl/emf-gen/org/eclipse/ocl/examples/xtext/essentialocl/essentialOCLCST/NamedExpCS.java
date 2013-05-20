/**
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS#getNameExp <em>Name Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getNamedExpCS()
 * @model abstract="true"
 * @generated
 */
public interface NamedExpCS extends AbstractNameExpCS
{
	/**
	 * Returns the value of the '<em><b>Name Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Exp</em>' containment reference.
	 * @see #setNameExp(NameExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getNamedExpCS_NameExp()
	 * @model containment="true"
	 * @generated
	 */
	NameExpCS getNameExp();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS#getNameExp <em>Name Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Exp</em>' containment reference.
	 * @see #getNameExp()
	 * @generated
	 */
	void setNameExp(NameExpCS value);

} // NamedExpCS
