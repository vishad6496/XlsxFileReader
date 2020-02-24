package com.canopi.main.application;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.canopi.file.entity.XlsxFileFormat;
import com.canopi.file.reader.XlsxFileReader;
import com.canopi.utility.DataProcessor;

public class MainApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);
	
	public static void main(String[] args) throws Exception {
		// Configuring Logger for the program
		BasicConfigurator.configure();
		
		//Declaring Instances
		XlsxFileReader xlxsFileReader = new XlsxFileReader();
		DataProcessor dataProcessor = new DataProcessor();
		XlsxFileFormat xlxsFileFormat = new XlsxFileFormat();
		
		//Path to the Xlsx file 
		String path = "F:\\Spring Projects\\Workspace - 1\\AssignmentForCanopi\\sample_shipping_data2.xlsx";

		//Getting all data from the file
		xlxsFileFormat = xlxsFileReader.getAllDataFromFile(path);
		
		//Getting and displaying all the unique values 
		logger.info("Answer 1 : Unique SKUs " + dataProcessor.getUniqueElements(xlxsFileFormat.getSkuList()).toString());
		logger.info("Answer 2 : Unique Start Pin Code " + dataProcessor.getUniqueElements(xlxsFileFormat.getStartList()).toString());
		logger.info("Answer 2 : Unique Hop Pin Code " + dataProcessor.getUniqueElements(xlxsFileFormat.getHopList()).toString());
		logger.info("Answer 2 : Unique End Pin Code ",dataProcessor.getUniqueElements(xlxsFileFormat.getEndList()).toString());
		logger.info("Answer 3 : Unique Routes " + dataProcessor.getUniqueRoutes(xlxsFileFormat).toString());
		logger.info("Answer 4 : SKUs for different routes  " + dataProcessor.getSkuForEachRoute(xlxsFileFormat).toString());
		logger.info("Invalid Pincodes are : " + XlsxFileReader.invalidPincodes.toString());
		

	}

}
