/**
 */
package genericdesigndecision;

import de.uka.ipd.sdq.dsexplore.helper.AResultsWriter;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.BinaryGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.FinalBinaryGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEDecoder;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEEvaluator;
import genericdesigndecision.genericDoF.ADegreeOfFreedom;
import genericdesigndecision.universalDoF.AMetamodelDescription;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.opt4j.core.Phenotype;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ADSE Problem</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link genericdesigndecision.ADSEProblem#getProblem <em>Problem</em>}</li>
 *   <li>{@link genericdesigndecision.ADSEProblem#getAssociatedMetamodel <em>Associated Metamodel</em>}</li>
 * </ul>
 *
 * @see genericdesigndecision.GenericdesigndecisionPackage#getADSEProblem()
 * @model abstract="true" superTypes="genericdesigndecision.DSEDecoder<genericdesigndecision.Phenotype>" PBounds="genericdesigndecision.Phenotype"
 * @generated NOT
 */
public interface ADSEProblem<P extends Phenotype> extends EObject, DSEDecoder<P> {
	/**
	 * Returns the value of the '<em><b>Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problem</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problem</em>' reference.
	 * @see #setProblem(DecisionSpace)
	 * @see genericdesigndecision.GenericdesigndecisionPackage#getADSEProblem_Problem()
	 * @model required="true"
	 * @generated
	 */
	DecisionSpace getProblem();

	/**
	 * Sets the value of the '{@link genericdesigndecision.ADSEProblem#getProblem <em>Problem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Problem</em>' reference.
	 * @see #getProblem()
	 * @generated
	 */
	void setProblem(DecisionSpace value);

	/**
	 * Returns the value of the '<em><b>Associated Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Metamodel</em>' reference.
	 * @see #setAssociatedMetamodel(AMetamodelDescription)
	 * @see genericdesigndecision.GenericdesigndecisionPackage#getADSEProblem_AssociatedMetamodel()
	 * @model required="true"
	 * @generated
	 */
	AMetamodelDescription getAssociatedMetamodel();

	/**
	 * Sets the value of the '{@link genericdesigndecision.ADSEProblem#getAssociatedMetamodel <em>Associated Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Metamodel</em>' reference.
	 * @see #getAssociatedMetamodel()
	 * @generated
	 */
	void setAssociatedMetamodel(AMetamodelDescription value);
	
	public List<ADegreeOfFreedom> getDesignDecisions();
    
    public DesignDecisionGenotype getGenotypeOfInitialInstance();

    public void saveProblem();

    @Override
    public String toString();

    public void setInitialPopulation(final List<DesignDecisionGenotype> population) throws CoreException;

	public List<DesignDecisionGenotype> getInitialGenotypeList();

	public ADegreeOfFreedom getDesignDecision(int index);
	
	public AResultsWriter getWriter(String filename);

	public DesignDecisionGenotype translateFinalBinaryGenotype(FinalBinaryGenotype FBGenotype);

	public List<BinaryGenotype> translateDesignDecisionGenotype(DesignDecisionGenotype DDGenotype);

	public List<DesignDecisionGenotype> loadGenotypesFromEMF(String filename);
	
	public Class<? extends DSEEvaluator> getDSEEvaluator();
	
	public String getDecisionString(final Choice choice);

} // ADSEProblem
