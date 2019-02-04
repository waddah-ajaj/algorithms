package com.mobiquityinc.packer.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mobiquityinc.exception.APIException;

import static com.mobiquityinc.packer.TestData.LINE_1;
import static com.mobiquityinc.packer.TestData.LINE_2;
import static com.mobiquityinc.packer.TestData.LINE_3;
import static com.mobiquityinc.packer.TestData.LINE_4;

public class PackerUtilsTest {

	@Test
	public void testParseValidItems() throws APIException
	{
		assertEquals(81, PackerUtils.parsePackItem(LINE_1).getMaxWeight());
		assertEquals(8, PackerUtils.parsePackItem(LINE_2).getMaxWeight());
		assertEquals(75, PackerUtils.parsePackItem(LINE_3).getMaxWeight());
		assertEquals(56, PackerUtils.parsePackItem(LINE_4).getMaxWeight());
		
		assertEquals(6, PackerUtils.parsePackItem(LINE_1).getItems().size());
		assertEquals(1, PackerUtils.parsePackItem(LINE_2).getItems().size());
		assertEquals(9, PackerUtils.parsePackItem(LINE_3).getItems().size());
		assertEquals(9, PackerUtils.parsePackItem(LINE_4).getItems().size());
	}
	
	@Test(expected = APIException.class)
	public void testInvalidInput() throws APIException
	{
		PackerUtils.parsePackItem("An Invalid Item");
	}
}
