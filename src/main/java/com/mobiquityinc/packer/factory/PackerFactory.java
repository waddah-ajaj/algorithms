package com.mobiquityinc.packer.factory;

import com.mobiquityinc.packer.engine.PackerEngine;
import com.mobiquityinc.packer.engine.impl.PackerEngineImpl;
import com.mobiquityinc.packer.service.file.FileService;
import com.mobiquityinc.packer.service.file.impl.FileServiceImpl;

/**
 * Factory class that returns the appropriate implementing classes. We could
 * have used spring injection instead, but we don't need the extra dependency
 * 
 * @author Waddah
 *
 */
public class PackerFactory {

	/**
	 * Returns the FileService implementation
	 * @return
	 */
	public static FileService createFileService() {
		return new FileServiceImpl();
	}

	/**
	 * Returns the PackerEngine implementation
	 * @return
	 */
	public static PackerEngine createPackerEngine() {
		return new PackerEngineImpl();
	}

}
