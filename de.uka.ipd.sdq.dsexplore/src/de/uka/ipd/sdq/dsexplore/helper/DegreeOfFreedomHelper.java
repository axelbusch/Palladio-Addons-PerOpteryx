package de.uka.ipd.sdq.dsexplore.helper;

import org.palladiosimulator.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.specific.ProcessingResourceDegree;
import genericdesigndecision.genericDoF.ADegreeOfFreedom;

public class DegreeOfFreedomHelper {

    public static String getDegreeDescription(final ADegreeOfFreedom decision) {
        String suffix = "";
        if (decision instanceof ProcessingResourceDegree){
            suffix = ":"+((ProcessingResourceDegree)decision).getProcessingresourcetype().getEntityName();
        }

        String primaryChangeableName = decision.getPrimaryChanged().toString();
        if (decision.getPrimaryChanged() instanceof Entity){
            primaryChangeableName = ((Entity)decision.getPrimaryChanged()).getEntityName();
        }

        return decision.getClass().getSimpleName() + ":" + primaryChangeableName + suffix;
    }

}
