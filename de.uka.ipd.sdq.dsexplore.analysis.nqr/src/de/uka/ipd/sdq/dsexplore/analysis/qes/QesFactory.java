package de.uka.ipd.sdq.dsexplore.analysis.qes;

import static org.eclipse.core.runtime.IStatus.ERROR;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.palladiosimulator.qes.qualityEffectSpecification.NQA;
import org.palladiosimulator.qes.qualityEffectSpecification.QES;
import org.palladiosimulator.qes.qualityEffectSpecification.Reasoning;
import org.palladiosimulator.qes.qualityEffectSpecification.TransformationSpecification;
import org.palladiosimulator.qes.qualityEffectSpecification.TransformationType;
import org.palladiosimulator.solver.models.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.nqr.solver.NqrFactory;
import de.uka.ipd.sdq.dsexplore.analysis.nqr.solver.NqrProxy;
import de.uka.ipd.sdq.dsexplore.analysis.nqr.solver.NqrReductionProxy;
import de.uka.ipd.sdq.dsexplore.analysis.nqr.solver.ReasoningProxy;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Element;

public class QesFactory extends NqrFactory {

    private static final Logger LOG = Logger.getLogger("de.uka.ipd.sdq.dsexplore.analysis.qes");

    private static void debug(String name, TransformationSpecification transformation) {
        final StringBuilder message = new StringBuilder(name);
        message.append(": ");
        if (transformation instanceof NQA) {
            final NQA nqa = (NQA) transformation;
            message.append(nqa.getQuality()).append("=").append(nqa.getElement());
        } else if (transformation instanceof Reasoning) {
            final Reasoning reasoning = (Reasoning) transformation;
            message.append(reasoning.getQuality());
        }

        LOG.warn(message.toString());
    }


    private static QesParser loadParser(final String qualityEffectSpecificationUri) throws CoreException {
        try {
            return new QesParser(qualityEffectSpecificationUri);
        } catch (final Exception e) {
            throw new CoreException(new Status(ERROR, "de.uka.ipd.sdq.dsexplore.analysis.qes", 0,
                    "Qes Model " + String.valueOf(qualityEffectSpecificationUri) + " could not be loaded.", e));
        }
    }

    private final QesParser parser;
    private QesFinder finder;

    public QesFactory(final String reasoningComponentUri, final String reductionUri, final String dimensionTypeSetUri,
            final String qualityEffectSpecificationUri) throws CoreException {
        super(reasoningComponentUri, reductionUri, dimensionTypeSetUri);

        parser = loadParser(qualityEffectSpecificationUri);
        finder = null;
    }

    public void setInstance(PCMInstance instance) {
        finder = new QesFinder(instance);
    }

    @Override
    public List<NqrProxy> getNqrList(final String componentId) {
        if ((finder == null) || parser.getNqaSpecifications().isEmpty()) {
            return super.getNqrList(componentId);
        }

        final List<NqrProxy> originalNqrs = super.getNqrList(componentId);
        final NqrReductionProxy reduction = createNqrReductionProxy();
        for (final QES specification : parser.getNqaSpecifications()) {
            if (finder.getEffectedComponents(specification.getComponents()).contains(componentId) == false) {
                continue;
            }
            for (final TransformationSpecification transformation : specification.getTransformations()) {
                if ((transformation != null) && (transformation instanceof NQA)) {
                    debug(getComponentName(componentId), transformation); // TODO
                    reduction.add(createNqrProxy((NQA) transformation, originalNqrs));
                }
            }
        }

        final List<NqrProxy> nqrs = new ArrayList<>(reduction.get());
        for (final NqrProxy original : originalNqrs) {
            boolean contains = false;
            for (final NqrProxy transformation : nqrs) {
                if (transformation.getDimensionId().equals(original.getDimensionId())) {
                    contains = true;
                    break;
                }
            }
            if (contains == false) {
                nqrs.add(original);
            }
        }

        return Collections.unmodifiableList(nqrs);
    }

    private NqrProxy createNqrProxy(final NQA nqa, List<NqrProxy> originalNqrs) {
        if (nqa == null) {
            return null;
        }

        final String quality = nqa.getQuality();
        final String element = nqa.getElement();
        final TransformationType type = nqa.getType();
        if ((quality == null) || (element == null) || (type == null)) {
            return null;
        }

        if ((type != TransformationType.IS) && ((originalNqrs == null) || originalNqrs.isEmpty())) {
            return null;
        }

        // Dimension S
        Dimension nqrDimension = getDimensionByName(quality);
        if (nqrDimension == null) {
            nqrDimension = getDimensionById(quality);
        }
        if (nqrDimension == null) {
            return null;
        }

        // Element +
        Element nqrElement = null;
        if (type == TransformationType.IS) {
            nqrElement = getElementByName(element);
            if (nqrElement == null) {
                nqrElement = getElementById(element);
            }
            if (nqrElement == null) {
                try {
                    nqrElement = getElementById(getDimensionId(Double.valueOf(element).intValue()));
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            if (nqrElement == null) {
                return null;
            }
            return new NqrProxy(nqrDimension, nqrElement, dimensionsIdNameMap.get(nqrDimension.getId()));
        }

        Element originalElement = null;
        for (final NqrProxy nqrProxy : originalNqrs) {
            if ((nqrProxy != null) && nqrProxy.getDimensionId().equals(nqrDimension.getId())) {
                originalElement = nqrProxy.getElement();
                break;
            }
        }
        if (originalElement == null) {
            return null;
        }

        int order = getDimensionOrder(originalElement.getId());
        if (order == -1) {
            return null;
        }

        try {
            final double value = Double.valueOf(element);
            if (type == TransformationType.PLUS) {
                order += value;
            } else if (type == TransformationType.MINUS) {
                order -= value;
            } else if (type == TransformationType.MULTIPLICATION) {
                order *= value;
            } else if (type == TransformationType.DIVISION) {
                order /= value;
            }
        } catch (NumberFormatException | ArithmeticException e) {
            return null;
        }

        nqrElement = getElementById(getDimensionId(order));
        if (nqrElement == null) {
            return null;
        }

        return new NqrProxy(nqrDimension, nqrElement, dimensionsIdNameMap.get(nqrDimension.getId()));
    }

    @Override
    public List<ReasoningProxy> getReasoningList(final String componentId) {
        if ((finder == null) || parser.getReasoningSpecifications().isEmpty()) {
            return super.getReasoningList(componentId);
        }

        final List<ReasoningProxy> reasonings = new ArrayList<>();

        for (final QES specification : parser.getReasoningSpecifications()) {
            if (finder.getEffectedComponents(specification.getComponents()).contains(componentId) == false) {
                continue;
            }
            for (final TransformationSpecification transformation : specification.getTransformations()) {
                if ((transformation == null) || ((transformation instanceof Reasoning) == false)) {
                    continue;
                }
                final ReasoningProxy newReasoning = createReasoningProxy((Reasoning) transformation);
                if (newReasoning == null) {
                    continue;
                }
                boolean contains = false;
                for (final ReasoningProxy reasoning : reasonings) {
                    if (reasoning.getOutput().getId().equals(newReasoning.getOutput().getId())) {
                        contains = true;
                        break;
                    }
                }
                if (contains == false) {
                    debug(getComponentName(componentId), transformation); // TODO
                    reasonings.add(newReasoning);
                }
            }
        }

        for (final ReasoningProxy original : super.getReasoningList(componentId)) {
            boolean contains = false;
            for (final ReasoningProxy transformation : reasonings) {
                if (transformation.getOutput().getId().equals(original.getOutput().getId())) {
                    contains = true;
                    break;
                }
            }
            if (contains == false) {
                reasonings.add(original);
            }
        }

        return Collections.unmodifiableList(reasonings);
    }

    private ReasoningProxy createReasoningProxy(final Reasoning reasoning) {
        return null; // TODO
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("Model (").append(String.valueOf(parser)).append(") ]").append(System.lineSeparator());
        // if (model != null && model.getElements() != null && !model.getElements().isEmpty()) {
        // for (Object element : model.getElements()) {
        // builder.append("\t").append(String.valueOf(element)).append(System.lineSeparator());
        // }
        // }
        builder.append("]").append(System.lineSeparator());
        return builder.toString();

    }

}
