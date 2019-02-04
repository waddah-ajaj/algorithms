package com.mobiquityinc.packer.service.file;

import java.util.List;

import com.mobiquityinc.exception.APIException;

/**
 * File service that handles reading the contents of a file
 * 
 * @author Waddah
 *
 */
public interface FileService {

	/**
	 * Reads a file identified by its path, and returns its contents line by line as
	 * a string
	 * 
	 * @param filePath
	 * @return
	 * @throws APIException
	 */
	public List<String> readFileContents(String filePath) throws APIException;

}
