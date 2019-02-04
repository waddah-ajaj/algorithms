package com.mobiquityinc.packer.engine;

import static com.mobiquityinc.packer.TestData.TEST_DATA_1;
import static com.mobiquityinc.packer.TestData.TEST_DATA_2;
import static com.mobiquityinc.packer.TestData.TEST_DATA_3;
import static com.mobiquityinc.packer.TestData.TEST_DATA_4;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.mobiquityinc.packer.data.Item;
import com.mobiquityinc.packer.data.PackerItem;
import com.mobiquityinc.packer.factory.PackerFactory;
import com.mobiquityinc.packer.utils.PackerUtils;

public class PackerEngineTest {

	private PackerEngine packerEngine;
	
	@Before
	public void setup()
	{
		this.packerEngine = PackerFactory.createPackerEngine();
		assertNotNull(this.packerEngine);
	}
	
	@Test
	public void checkNullIfInvalidInput() throws Exception
	{
		assertNull(this.packerEngine.getOptimalPackaging(null));
		assertNull(this.packerEngine.getOptimalPackaging(new PackerItem(10, null)));
		assertNull(this.packerEngine.getOptimalPackaging(new PackerItem(10, new HashSet<Item>())));
		assertNull(this.packerEngine.getOptimalPackaging(new PackerItem(-90, TEST_DATA_1.getItems())));
	}
	
	@Test
	public void testValidCases()
	{
		assertEquals("4", PackerUtils.formatItem(packerEngine.getOptimalPackaging(TEST_DATA_1)));
		assertEquals("-", PackerUtils.formatItem(packerEngine.getOptimalPackaging(TEST_DATA_2)));
		assertEquals("2,7", PackerUtils.formatItem(packerEngine.getOptimalPackaging(TEST_DATA_3)));
		assertEquals("8,9", PackerUtils.formatItem(packerEngine.getOptimalPackaging(TEST_DATA_4)));
		
	}
	
}
