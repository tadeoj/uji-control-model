/**
 */
package es.uji.control.sip.model.emf.sip.tests;

import es.uji.control.sip.model.emf.sip.Linkage;
import es.uji.control.sip.model.emf.sip.SipFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Linkage</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LinkageTest extends TestCase {

	/**
	 * The fixture for this Linkage test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Linkage fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LinkageTest.class);
	}

	/**
	 * Constructs a new Linkage test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkageTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Linkage test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Linkage fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Linkage test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Linkage getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SipFactory.eINSTANCE.createLinkage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //LinkageTest
