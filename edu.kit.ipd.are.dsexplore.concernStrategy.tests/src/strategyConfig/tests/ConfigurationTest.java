/**
 */
package strategyConfig.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import strategyConfig.ConcernconfigFactory;
import strategyConfig.Configuration;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationTest extends TestCase {

	/**
	 * The fixture for this Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Configuration fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ConfigurationTest.class);
	}

	/**
	 * Constructs a new Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Configuration fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Configuration getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(ConcernconfigFactory.eINSTANCE.createConfiguration());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ConfigurationTest
