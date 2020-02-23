package com.canopi.main.application;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.canopi.file.entity.XlsxFileFormat;
import com.canopi.file.reader.XlsxFileReader;
import com.canopi.utility.FileUtility;

public class MainApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);
	
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		// Configuring Logger for the program
		BasicConfigurator.configure();
		
		//Declaring Instances
		XlsxFileReader xlxsFileReader = new XlsxFileReader();
		FileUtility fileUtility = new FileUtility();
		XlsxFileFormat xlxsFileFormat = new XlsxFileFormat();
		
		//Path to the Xlsx file 
		String path = "F:\\Spring Projects\\Workspace - 1\\AssignmentForCanopi\\sample_shipping_data2.xlsx";

		//Getting all data from the file
		xlxsFileFormat = xlxsFileReader.getAllDataFromFile(path);
		
		//Getting and displaying all the unique values 
		logger.debug("Answer 1 : Unique SKUs " + fileUtility.getUniqueElements(xlxsFileFormat.getSkuList()).toString());
		logger.debug("Answer 2 : Unique Start Pin Code " + fileUtility.getUniqueElements(xlxsFileFormat.getStartList()).toString());
		logger.debug("Answer 2 : Unique Hop Pin Code " + fileUtility.getUniqueElements(xlxsFileFormat.getHopList()).toString());
		logger.debug("Answer 2 : Unique End Pin Code ",fileUtility.getUniqueElements(xlxsFileFormat.getEndList()).toString());
		logger.debug("Answer 3 : Unique Routes " + fileUtility.getUniqueRoutes(xlxsFileFormat).toString());
		logger.debug("Answer 4 : SKUs for different routes  " + fileUtility.getSkuForEachRoute(xlxsFileFormat).toString());
		
		long end = System.currentTimeMillis(); 
		//Calculating time of All Operations
		logger.debug("Printing all data takes :" + 
                                    (end - start) + "ms"); 

	}

}
