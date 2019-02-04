package com.mobiquityinc.packer;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.mobiquityinc.exception.APIException;

public class PackerTest {
	
	@Test(expected = APIException.class)
	public void testIfPathIsNull() throws APIException 
	{
		Packer.pack(null);
	}
	
	@Test(expected = APIException.class)
	public void testIfPathIsEmpty() throws APIException 
	{
		Packer.pack("    ");
	}
	
	@Test(expected = APIException.class)
	public void testIfPathIsInvalid() throws APIException 
	{
		Packer.pack("c:\\path\\to\\invalid\\file\\not_exist.txt");
	}

	@Test
	public void testAllCasesCorrectlyCovered() throws APIException
	{
		String testFilePath = new File(ClassLoader.getSystemClassLoader().getResource("packer.txt").getFile()).getAbsolutePath();
		assertEquals("4\n-\n2,7\n8,9", Packer.pack(testFilePath));
	}
}
