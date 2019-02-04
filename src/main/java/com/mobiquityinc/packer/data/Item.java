package com.mobiquityinc.packer.data;

/**
 * POJO that holds an item's properties: index, weight and cost. Implements
 * {@link java.lang.Comparable<Item>} because it's going to be used in an
 * ordered TreeSet.
 * 
 * @author Waddah
 *
 */
public class Item implements Comparable<Item> {

	private int index;
	private float weight;
	private int cost;

	public Item(int index, float weight, int cost) {
		super();
		this.index = index;
		this.weight = weight;
		this.cost = cost;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(Item o) {
		return Integer.compare(this.getIndex(), o.getIndex());
	}

}
