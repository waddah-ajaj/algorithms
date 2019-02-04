package com.mobiquityinc.packer.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.factory.PackerFactory;
import com.mobiquityinc.packer.service.file.FileService;

public class FileServiceTest {
	
	private FileService fileService;
	
	@Before
	public void setup()
	{
		this.fileService = PackerFactory.createFileService();
		assertNotNull(this.fileService);
	}
	
	@Test
	public void checkFilServiceValid()
	{
		assertNotNull(this.fileService);
	}
	
	@Test(expected = APIException.class)
	public void testIfFilePathIsNull() throws Exception
	{
		fileService.readFileContents(null);
	}
	
	@Test(expected = APIException.class)
	public void testIfFilePathIsEmpty() throws Exception
	{
		fileService.readFileContents("    ");
	}
	
	@Test(expected = APIException.class)
	public void testIfFilePathIsInvalid() throws Exception
	{
		fileService.readFileContents("c:\\path\\to\\invalid\\file\\not_exist.txt");
	}
	
	@Test
	public void testReadFile() throws APIException
	{
		List<String> fileContents = fileService.readFileContents(new File(ClassLoader.getSystemClassLoader().getResource("packer.txt").getFile()).getAbsolutePath());
		assertNotNull(fileContents);
		assertTrue(!fileContents.isEmpty());
		assertTrue(fileContents.size() == 4);
	}

}
