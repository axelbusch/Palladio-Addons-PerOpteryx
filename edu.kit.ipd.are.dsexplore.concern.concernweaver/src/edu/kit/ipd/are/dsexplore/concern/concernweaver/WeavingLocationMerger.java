package edu.kit.ipd.are.dsexplore.concern.concernweaver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.palladiosimulator.pcm.repository.Signature;

import edu.kit.ipd.are.dsexplore.concern.util.ConcernWeaverUtil;

/**
 * This class is responsible for merging weaving locations.
 * @author scheerer
 *
 */
public class WeavingLocationMerger {

	private List<WeavingLocation> unmergedLocations;
	private List<WeavingLocation> alreadyMergedLocations;
	
	public WeavingLocationMerger(List<WeavingLocation> unmergedLocations) {
		
		this.unmergedLocations = unmergedLocations;
		this.alreadyMergedLocations = new ArrayList<WeavingLocation>();
		
	}
	
	/**
	 * Inspects the weaving locations and merges if necessary.
	 * @return the merged weaving locations. 
	 */
	public List<WeavingLocation> merge() {
		
		List<WeavingLocation> mergedLocations = new ArrayList<WeavingLocation>(this.unmergedLocations);
		for (WeavingLocation eachWeavingLocation : this.unmergedLocations) {
			
			if (needToBeMerged(eachWeavingLocation)) {
				
				merge(eachWeavingLocation, mergedLocations);
				
			}
			
		}
		
		return mergedLocations;
		
	}

	private boolean needToBeMerged(WeavingLocation weavingLocation) {
		
		List<WeavingLocation> result = getWeavingLocationsToMergeBy(searchCriteria(weavingLocation));
		result.remove(weavingLocation);
		
		return !result.isEmpty();
		
	}
	
	private void merge(WeavingLocation weavingLocation, List<WeavingLocation> mergedLocations) {
		
		if (isAlreadyMerged(weavingLocation)) {
			
			return;
			
		}
		
		List<WeavingLocation> locationsToMerge = getWeavingLocationsToMergeBy(searchCriteria(weavingLocation));
		WeavingLocation mergedWeavingLocation = merge(locationsToMerge);
		
		mergedLocations.removeAll(locationsToMerge);
		mergedLocations.add(mergedWeavingLocation);
		
		cacheMergedLocation(locationsToMerge);
		
	}

	private WeavingLocation merge(List<WeavingLocation> locationsToMerge) {
		
		return locationsToMerge.stream().reduce((w1,w2) -> new WeavingLocation(mergeSignaturesOf(w1,w2), w1.getLocation())).get();
		
	}
	
	private List<Signature> mergeSignaturesOf(WeavingLocation w1, WeavingLocation w2) {
		
		return Stream.concat(w1.getAffectedSignatures().stream(), w2.getAffectedSignatures().stream()).distinct().collect(Collectors.toList());
		
	}

	private List<WeavingLocation> getWeavingLocationsToMergeBy(Predicate<WeavingLocation> searchCriteria) {
		
		return this.unmergedLocations.stream().filter(searchCriteria).collect(Collectors.toList());
		
	}
	
	private Predicate<WeavingLocation> searchCriteria(WeavingLocation weavingLocation) {
		
		return containsTheSameConnector(weavingLocation).and(isSupersetOf(weavingLocation).or(shareSameInterface(weavingLocation)));
		
	}

	private Predicate<WeavingLocation> shareSameInterface(WeavingLocation givenWeavingLocation) {
		
		return weavingLocation -> ConcernWeaverUtil.areEqual(weavingLocation.getAffectedSignatures().get(0).eContainer(), 
															 givenWeavingLocation.getAffectedSignatures().get(0).eContainer());
		
	}

	private Predicate<WeavingLocation> isSupersetOf(WeavingLocation givenWeavingLocation) {
		
		return weavingLocation -> givenWeavingLocation.getAffectedSignatures().size() <= weavingLocation.getAffectedSignatures().size() &&
								  givenWeavingLocation.getAffectedSignatures().stream().allMatch(each -> weavingLocation.getAffectedSignatures().contains(each));
		
	}
	
	private Predicate<WeavingLocation> containsTheSameConnector(WeavingLocation givenWeavingLocation) {
		
		return weavingLocation -> ConcernWeaverUtil.areEqual(weavingLocation.getLocation(), givenWeavingLocation.getLocation());
		
	}
	
	private void cacheMergedLocation(List<WeavingLocation> locationsToMerge) {
		
		this.alreadyMergedLocations.addAll(locationsToMerge);
		
	}

	private boolean isAlreadyMerged(WeavingLocation weavingLocation) {
		
		return this.alreadyMergedLocations.contains(weavingLocation);
		
	}
	
}