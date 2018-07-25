/**
 * generated by Xtext 2.12.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Role Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getRoleType()
 * @model
 * @generated
 */
public enum RoleType implements Enumerator
{
  /**
   * The '<em><b>ANY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ANY_VALUE
   * @generated
   * @ordered
   */
  ANY(0, "ANY", "AnyRoleType"),

  /**
   * The '<em><b>COMPONENT REQUIRED PROVIDED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPONENT_REQUIRED_PROVIDED_VALUE
   * @generated
   * @ordered
   */
  COMPONENT_REQUIRED_PROVIDED(1, "COMPONENT_REQUIRED_PROVIDED", "ComponentRequiredProvided"),

  /**
   * The '<em><b>COMPONENT REQUIRED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPONENT_REQUIRED_VALUE
   * @generated
   * @ordered
   */
  COMPONENT_REQUIRED(2, "COMPONENT_REQUIRED", "ComponentRequired"),

  /**
   * The '<em><b>COMPONENT PROVIDED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPONENT_PROVIDED_VALUE
   * @generated
   * @ordered
   */
  COMPONENT_PROVIDED(3, "COMPONENT_PROVIDED", "ComponentProvided"),

  /**
   * The '<em><b>INFRASTRUCTURE REQUIRED PROVIDED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INFRASTRUCTURE_REQUIRED_PROVIDED_VALUE
   * @generated
   * @ordered
   */
  INFRASTRUCTURE_REQUIRED_PROVIDED(4, "INFRASTRUCTURE_REQUIRED_PROVIDED", "InfrastructureRequiredProvided"),

  /**
   * The '<em><b>INFRASTRUCTURE REQUIRED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INFRASTRUCTURE_REQUIRED_VALUE
   * @generated
   * @ordered
   */
  INFRASTRUCTURE_REQUIRED(5, "INFRASTRUCTURE_REQUIRED", "InfrastructureRequired"),

  /**
   * The '<em><b>INFRASTRUCTURE PROVIDED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INFRASTRUCTURE_PROVIDED_VALUE
   * @generated
   * @ordered
   */
  INFRASTRUCTURE_PROVIDED(6, "INFRASTRUCTURE_PROVIDED", "InfrastructureProvided");

  /**
   * The '<em><b>ANY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ANY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ANY
   * @model literal="AnyRoleType"
   * @generated
   * @ordered
   */
  public static final int ANY_VALUE = 0;

  /**
   * The '<em><b>COMPONENT REQUIRED PROVIDED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>COMPONENT REQUIRED PROVIDED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COMPONENT_REQUIRED_PROVIDED
   * @model literal="ComponentRequiredProvided"
   * @generated
   * @ordered
   */
  public static final int COMPONENT_REQUIRED_PROVIDED_VALUE = 1;

  /**
   * The '<em><b>COMPONENT REQUIRED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>COMPONENT REQUIRED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COMPONENT_REQUIRED
   * @model literal="ComponentRequired"
   * @generated
   * @ordered
   */
  public static final int COMPONENT_REQUIRED_VALUE = 2;

  /**
   * The '<em><b>COMPONENT PROVIDED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>COMPONENT PROVIDED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COMPONENT_PROVIDED
   * @model literal="ComponentProvided"
   * @generated
   * @ordered
   */
  public static final int COMPONENT_PROVIDED_VALUE = 3;

  /**
   * The '<em><b>INFRASTRUCTURE REQUIRED PROVIDED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INFRASTRUCTURE REQUIRED PROVIDED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INFRASTRUCTURE_REQUIRED_PROVIDED
   * @model literal="InfrastructureRequiredProvided"
   * @generated
   * @ordered
   */
  public static final int INFRASTRUCTURE_REQUIRED_PROVIDED_VALUE = 4;

  /**
   * The '<em><b>INFRASTRUCTURE REQUIRED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INFRASTRUCTURE REQUIRED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INFRASTRUCTURE_REQUIRED
   * @model literal="InfrastructureRequired"
   * @generated
   * @ordered
   */
  public static final int INFRASTRUCTURE_REQUIRED_VALUE = 5;

  /**
   * The '<em><b>INFRASTRUCTURE PROVIDED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INFRASTRUCTURE PROVIDED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INFRASTRUCTURE_PROVIDED
   * @model literal="InfrastructureProvided"
   * @generated
   * @ordered
   */
  public static final int INFRASTRUCTURE_PROVIDED_VALUE = 6;

  /**
   * An array of all the '<em><b>Role Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final RoleType[] VALUES_ARRAY =
    new RoleType[]
    {
      ANY,
      COMPONENT_REQUIRED_PROVIDED,
      COMPONENT_REQUIRED,
      COMPONENT_PROVIDED,
      INFRASTRUCTURE_REQUIRED_PROVIDED,
      INFRASTRUCTURE_REQUIRED,
      INFRASTRUCTURE_PROVIDED,
    };

  /**
   * A public read-only list of all the '<em><b>Role Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<RoleType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Role Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static RoleType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      RoleType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Role Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static RoleType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      RoleType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Role Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static RoleType get(int value)
  {
    switch (value)
    {
      case ANY_VALUE: return ANY;
      case COMPONENT_REQUIRED_PROVIDED_VALUE: return COMPONENT_REQUIRED_PROVIDED;
      case COMPONENT_REQUIRED_VALUE: return COMPONENT_REQUIRED;
      case COMPONENT_PROVIDED_VALUE: return COMPONENT_PROVIDED;
      case INFRASTRUCTURE_REQUIRED_PROVIDED_VALUE: return INFRASTRUCTURE_REQUIRED_PROVIDED;
      case INFRASTRUCTURE_REQUIRED_VALUE: return INFRASTRUCTURE_REQUIRED;
      case INFRASTRUCTURE_PROVIDED_VALUE: return INFRASTRUCTURE_PROVIDED;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private RoleType(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //RoleType
