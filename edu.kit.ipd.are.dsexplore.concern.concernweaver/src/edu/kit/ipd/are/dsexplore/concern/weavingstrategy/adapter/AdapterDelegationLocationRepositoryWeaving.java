package edu.kit.ipd.are.dsexplore.concern.weavingstrategy.adapter;

import org.palladiosimulator.pcm.core.composition.ProvidedDelegationConnector;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;

import edu.kit.ipd.are.dsexplore.concern.concernweaver.WeavingLocation;

/**
 * This class is responsible to weave the adapter in the repository depending on the connection of the components
 * the adapter is inserted in between.
 * @author scheerer
 *
 */
public class AdapterDelegationLocationRepositoryWeaving extends AdapterRepositoryWeaving {

	/**
	 * @see AdapterRepositoryWeaving#weaveAdapterIntoRepository(WeavingLocation)
	 */
	@Override
	protected void weaveAdapterIntoRepository(WeavingLocation weavingLocation) {
		
		ProvidedDelegationConnector location = (ProvidedDelegationConnector) weavingLocation.getLocation();
		
		OperationProvidedRole delegatedConnectionEnd = location.getOuterProvidedRole_ProvidedDelegationConnector();
		OperationProvidedRole providedConnectionEnd = location.getInnerProvidedRole_ProvidedDelegationConnector();
		
		adapter.getProvidedRoles_InterfaceProvidingEntity().add(concernRepositoryManager.createProvidedRoleBy(delegatedConnectionEnd, adapter.getEntityName()));
		adapter.getRequiredRoles_InterfaceRequiringEntity().add(concernRepositoryManager.createRequiredRoleBy(providedConnectionEnd));
		
	}

}