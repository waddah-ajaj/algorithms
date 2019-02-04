package com.mobiquityinc.packer.engine;

import java.util.Set;

import com.mobiquityinc.packer.data.Item;
import com.mobiquityinc.packer.data.PackerItem;

/**
 * Engine which returns the optimal packaging (i.e. list of items to be included
 * in a package) for a list of items with a maximum weight. The implementation
 * details is dependant on the specific implementing class.
 * 
 * @author Waddah
 *
 */
public interface PackerEngine {

	public Set<Item> getOptimalPackaging(PackerItem packerItem);

}
