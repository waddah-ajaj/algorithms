package com.mobiquityinc.packer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.data.PackerItem;
import com.mobiquityinc.packer.engine.PackerEngine;
import com.mobiquityinc.packer.factory.PackerFactory;
import com.mobiquityinc.packer.utils.PackerUtils;

/**
 * A class that reads a file identified by its absolute path, and returns a list
 * of optimal items to include in each bag, based on the maximum weight it can
 * hold. The items selected are the ones with the greatest cost/weight ratio,
 * i.e. we select items with less weight if they have the same cost. If the file
 * format is not valid, it throws a {@link APIException}
 * 
 * @author Waddah
 *
 */
public class Packer {

	/**
	 * Method that accepts the path to a well-formatted file as input, and returns
	 * the optimal list of items to include for each test case.
	 * 
	 * @param filePath
	 * @return
	 * @throws APIException
	 */
	public static String pack(String filePath) throws APIException {

		List<String> testCases = PackerFactory.createFileService().readFileContents(filePath);
		PackerEngine packerEngine = PackerFactory.createPackerEngine();
		List<String> result = new ArrayList<>();
		// for each test case string, calculate the items to include and add the
		// formatted result to the list
		for (String testCase : testCases) {
			PackerItem packerItem = PackerUtils.parsePackItem(testCase);
			result.add(PackerUtils.formatItem(packerEngine.getOptimalPackaging(packerItem)));
		}

		return result.stream().collect(Collectors.joining("\n"));
	}
}
