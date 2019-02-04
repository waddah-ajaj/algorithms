package com.mobiquityinc.packer.service.file.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.service.file.FileService;

public class FileServiceImpl implements FileService {

	public List<String> readFileContents(String filePath) throws APIException {
		if(filePath == null || filePath.trim().equals(""))
		{
			throw new APIException("The file path cannot be null or empty");
		};
		File file = new File(filePath);
		if(!file.exists() || !file.isFile())
		{
			throw new APIException("The file path is invalid");
		}
		
		try {
			return Files.readAllLines(Paths.get(filePath));
		} catch (IOException e) {
			throw new APIException("An error occured while parsing the document");
		}
	}
}
