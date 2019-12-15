package com.newtours.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.annotations.DataProvider;

/**
 * This Class is used to implement <b>Data Provider</b> using CSV files.
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class CsvDataProvider {

	/**
	 * This method is used to pass data from CSV files to Data provider object
	 * 
	 * @param method : Test method
	 * @return Data object iterator
	 */
	@DataProvider(name = "CsvDataProvider")
	public static Iterator<Object[]> provideData(Method method) {
		List<Object[]> list = new ArrayList<Object[]>();
		String pathName = "src" + File.separator + "test" + File.separator + "resources" + File.separator
				+ "dataproviders" + File.separator + method.getDeclaringClass().getSimpleName() + File.separator
				+ method.getName() + ".csv";
		try {
			String data = Files.lines(Paths.get(pathName)).collect(Collectors.joining("\n"));
			String[] dataParts = data.split("\n");
			String[] keys = dataParts[0].split(",");
			for (int i = 1; i < dataParts.length; i++) {
				Map<String, String> testData = new HashMap<String, String>();
				String values[] = dataParts[i].split(",");
				for (int j = 0; j < keys.length; j++)
					testData.put(keys[j], values[j]);
				list.add(new Object[] { testData });
			}
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + pathName + " file.\n" + e.getStackTrace().toString());
		}
		return list.iterator();
	}
}