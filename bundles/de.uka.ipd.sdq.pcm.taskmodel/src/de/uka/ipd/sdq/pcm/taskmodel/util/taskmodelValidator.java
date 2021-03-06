/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.taskmodel.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.pcm.taskmodel.Alternative;
import de.uka.ipd.sdq.pcm.taskmodel.AlternativeTask;
import de.uka.ipd.sdq.pcm.taskmodel.Edge;
import de.uka.ipd.sdq.pcm.taskmodel.Task;
import de.uka.ipd.sdq.pcm.taskmodel.TaskList;
import de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 *
 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage
 * @generated
 */
public class taskmodelValidator extends EObjectValidator {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final taskmodelValidator INSTANCE = new taskmodelValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
     * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.taskmodel";

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Sum Of
     * Probabilities Must Be One' of 'Task'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final int TASK__SUM_OF_PROBABILITIES_MUST_BE_ONE = 1;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written
     * constants. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written
     * constants in a derived class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public taskmodelValidator() {
        super();
    }

    /**
     * Returns the package of this validator switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EPackage getEPackage() {
        return taskmodelPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected boolean validate(final int classifierID, final Object value, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        switch (classifierID)
        {
        case taskmodelPackage.TASK:
            return this.validateTask((Task) value, diagnostics, context);
        case taskmodelPackage.EDGE:
            return this.validateEdge((Edge) value, diagnostics, context);
        case taskmodelPackage.TASK_LIST:
            return this.validateTaskList((TaskList) value, diagnostics, context);
        case taskmodelPackage.ALTERNATIVE:
            return this.validateAlternative((Alternative) value, diagnostics, context);
        case taskmodelPackage.ALTERNATIVE_TASK:
            return this.validateAlternativeTask((AlternativeTask) value, diagnostics, context);
        default:
            return true;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateTask(final Task task, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (!this.validate_NoCircularContainment(task, diagnostics, context)) {
            return false;
        }
        boolean result = this.validate_EveryMultiplicityConforms(task, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(task, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(task, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryBidirectionalReferenceIsPaired(task, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(task, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(task, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(task, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(task, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateTask_sumOfProbabilitiesMustBeOne(task, diagnostics, context);
        }
        return result;
    }

    /**
     * Validates the sumOfProbabilitiesMustBeOne constraint of '<em>Task</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateTask_sumOfProbabilitiesMustBeOne(final Task task, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return task.sumOfProbabilitiesMustBeOne(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateEdge(final Edge edge, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(edge, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateTaskList(final TaskList taskList, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(taskList, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateAlternative(final Alternative alternative, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        return this.validate_EveryDefaultConstraint(alternative, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateAlternativeTask(final AlternativeTask alternativeTask, final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (!this.validate_NoCircularContainment(alternativeTask, diagnostics, context)) {
            return false;
        }
        boolean result = this.validate_EveryMultiplicityConforms(alternativeTask, diagnostics, context);
        if (result || diagnostics != null) {
            result &= this.validate_EveryDataValueConforms(alternativeTask, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryReferenceIsContained(alternativeTask, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryBidirectionalReferenceIsPaired(alternativeTask, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryProxyResolves(alternativeTask, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_UniqueID(alternativeTask, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryKeyUnique(alternativeTask, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validate_EveryMapEntryUnique(alternativeTask, diagnostics, context);
        }
        if (result || diagnostics != null) {
            result &= this.validateTask_sumOfProbabilitiesMustBeOne(alternativeTask, diagnostics, context);
        }
        return result;
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's
     * diagnostics. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator();
    }

} // taskmodelValidator
