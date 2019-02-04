package com.mobiquityinc.packer.data;

import java.util.Set;

/**
 * POJO that holds a test case, i.e. the max weight and a list of corresponding
 * items
 * 
 * @author Waddah
 *
 */
public class PackerItem {

	private int maxWeight;

	private Set<Item> items;

	public PackerItem(int maxWeight, Set<Item> items) {
		super();
		this.maxWeight = maxWeight;
		this.items = items;
	}

	/**
	 * @return the maxWeight
	 */
	public int getMaxWeight() {
		return maxWeight;
	}

	/**
	 * @return the items
	 */
	public Set<Item> getItems() {
		return items;
	}

}
