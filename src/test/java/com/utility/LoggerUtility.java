package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
	
	private LoggerUtility() { //private constructor
		
	}
	
	public static Logger getLogger(Class<?> clazz) { //private method
		Logger logger=null;
		if(logger==null) {
			logger = LogManager.getLogger(clazz);
		}
		return logger;		
	}
	

}
