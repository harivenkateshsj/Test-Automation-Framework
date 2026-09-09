package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String readProperty(Env env,String propertyName) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		File propFile = new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");
		FileReader fileReader = null;
		Properties properties = new Properties();
		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader);
		} catch (FileNotFoundException e) { //this catch block is for FileReader
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) { //this catch block is for properties
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = properties.getProperty(propertyName.toUpperCase()); //toUpperCase() converts url to URL if url is declared instead of URL
		return value;
	}

}
