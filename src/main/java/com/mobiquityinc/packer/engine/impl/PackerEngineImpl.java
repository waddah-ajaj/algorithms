package com.mobiquityinc.packer.engine.impl;

import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.Sets;
import com.mobiquityinc.packer.data.Item;
import com.mobiquityinc.packer.data.PackerItem;
import com.mobiquityinc.packer.engine.PackerEngine;

/**
 * Implementing class that gets the optimal list of items to be included in a
 * package under a certain maximum weight. The problem is a classic 0/1
 * Knapsack, however, since the weight is a real number instead of an integer,
 * and the number of items in the subset is small, the algorithm implemented is
 * brute force, i.e. computing all possible subsets of the initial list, and
 * selecting the one with the best cost/weight ratio.
 * 
 * @author Waddah
 *
 */
public class PackerEngineImpl implements PackerEngine {

	/**
	 * Returns the optimal items to include in a package with weight limit in
	 * cost/weight ratio
	 */
	public Set<Item> getOptimalPackaging(PackerItem packerItem) {
		if (packerItem == null || packerItem.getItems() == null || packerItem.getItems() == null
				|| packerItem.getItems().isEmpty() || packerItem.getMaxWeight() <= 0) {
			return null;
		}

		Set<Item> optimalSubset = getOptimalSubset(packerItem.getItems(), packerItem.getMaxWeight());

		return optimalSubset;
	}

	/**
	 * Returns the optimal subset using brute force algorithm
	 * 
	 * @param items
	 * @param maxWeight
	 * @return
	 */
	private Set<Item> getOptimalSubset(Set<Item> items, int maxWeight) {
		int bestCost = 0;
		double bestWeight = 0;
		Set<Item> bestSubset = null;
		//generate all possible subsets from the original set using guava
		for (Set<Item> subset : Sets.powerSet(items)) {
			double weightSum = subset.stream().mapToDouble(i -> i.getWeight()).sum();
			//store the best subset so far in cost or weight when costs are the same
			if (weightSum <= maxWeight) {
				int costSum = subset.stream().mapToInt(i -> i.getCost()).sum();
				if (costSum > bestCost || (costSum == bestCost && weightSum < bestWeight)) {
					bestCost = costSum;
					bestSubset = subset;
					bestWeight = weightSum;
				}
			}
		}
		//return the subset with the items ordered by index
		return bestSubset != null ? new TreeSet<>(bestSubset) : null;
	}
}
