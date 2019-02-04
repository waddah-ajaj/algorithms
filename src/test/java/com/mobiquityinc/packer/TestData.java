package com.mobiquityinc.packer;

import java.util.Arrays;
import java.util.HashSet;

import com.mobiquityinc.packer.data.Item;
import com.mobiquityinc.packer.data.PackerItem;

public class TestData {

	 	public static final String LINE_1 = " 81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
	    public static final String LINE_2 = " 8  :  (1,15.3,€34)";
	    public static final String LINE_3 = " 75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)";
	    public static final String LINE_4 = " 56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)";

	    public static final PackerItem TEST_DATA_1 = new PackerItem(81, new HashSet<Item>(Arrays.asList(
	            new Item(1, 53.38f, 45),
	            new Item(2, 88.62f, 98),
	            new Item(3, 78.48f, 3),
	            new Item(4, 72.30f, 76),
	            new Item(5, 30.18f, 9),
	            new Item(6, 46.34f, 48)
	    )));

	    public static final PackerItem TEST_DATA_2 = new PackerItem(8, new HashSet<Item>(Arrays.asList(
	            new Item(1, 15.3f, 34)
	    )));

	    public static final PackerItem TEST_DATA_3 = new PackerItem(75, new HashSet<Item>(Arrays.asList(
	            new Item(1, 85.31f, 29),
	            new Item(2, 14.55f, 74),
	            new Item(3, 3.98f, 16),
	            new Item(4, 26.24f, 55),
	            new Item(5, 63.69f, 52),
	            new Item(6, 76.25f, 75),
	            new Item(7, 60.02f, 74),
	            new Item(8, 93.18f, 35),
	            new Item(9, 89.95f, 78)
	    )));

	    public static final PackerItem TEST_DATA_4 = new PackerItem(56, new HashSet<Item>(Arrays.asList(
	            new Item(1, 90.72f, 13),
	            new Item(2, 33.80f, 40),
	            new Item(3, 43.15f, 10),
	            new Item(4, 37.97f, 16),
	            new Item(5, 46.81f, 36),
	            new Item(6, 48.77f, 79),
	            new Item(7, 81.80f, 45),
	            new Item(8, 19.36f, 79),
	            new Item(9, 6.76f, 64)
	    )));
}
