package com.mobiquityinc.packer.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.data.Item;
import com.mobiquityinc.packer.data.PackerItem;

/**
 * Helper class
 * 
 * @author Waddah
 *
 */
public class PackerUtils {

	private static final Pattern ITEM_FORMAT = Pattern.compile("\\((\\d+),([\\d|.]+),€([\\d|.]+)\\)");

	/**
	 * parses a line of data into a {@link PackerItem} object. Throws a
	 * {@link APIException} if the line is invalid
	 * 
	 * @param line
	 * @return
	 * @throws APIException
	 */
	public static PackerItem parsePackItem(String line) throws APIException {
		if (line == null || line.trim().length() == 0 || line.split(":").length != 2) {
			throw new APIException("Invalid format, " + line);
		}

		String[] parts = line.split(":");

		try {
			int maxWeight = Integer.parseInt(parts[0].trim());
			return new PackerItem(maxWeight, parseItems(parts[1]));
		} catch (NumberFormatException e) {
			throw new APIException("Invalid format, " + line);
		}
	}

	/**
	 * Formats a {@link Set<Items>} items and returns a comma-separated string of
	 * the item ids
	 * 
	 * @param items
	 * @return
	 */
	public static String formatItem(Set<Item> items) {
		return items == null ? "-"
				: items.stream().map(i -> Integer.toString(i.getIndex())).collect(Collectors.joining(","));
	}

	/**
	 * Parses a string into a {@link Set<Item>} objects
	 * 
	 * @param itemsLine
	 * @return
	 * @throws APIException
	 */
	private static Set<Item> parseItems(String itemsLine) throws APIException {
		Set<Item> items = new HashSet<>();
		for (String line : itemsLine.trim().split(" ")) {
			Matcher itemMatcher = ITEM_FORMAT.matcher(line);
			while (itemMatcher.find()) {
				// parses a string using Regex to extract the item's properties
				try {
					int id = Integer.parseInt(itemMatcher.group(1));
					float weight = Float.parseFloat(itemMatcher.group(2));
					int price = Integer.parseInt(itemMatcher.group(3));
					items.add(new Item(id, weight, price));
				} catch (NumberFormatException | NullPointerException e) {
					throw new APIException("Invalid format, " + itemsLine);
				}
			}
		}

		return items;
	}
}
