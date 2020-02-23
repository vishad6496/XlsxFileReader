package com.canopi.main.application;

import java.util.LinkedHashMap;
import java.util.Map;
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
		LinkedHashMap<String,Object> dataToBeDisplayed = new LinkedHashMap<>();
		
		//Path to the Xlsx file 
		String path = "F:\\Spring Projects\\Workspace - 1\\AssignmentForCanopi\\sample_shipping_data.xlsx";

		//Getting all data from the file
		xlxsFileFormat = xlxsFileReader.getAllDataFromFile(path);
		
		//Getting all the unique values
		dataToBeDisplayed.put("Answer 1 : Unique SKUs ",fileUtility.getUniqueElements(xlxsFileFormat.getSkuList()));
		dataToBeDisplayed.put("Answer 2 : Unique Start Pin Code ",fileUtility.getUniqueElements(xlxsFileFormat.getStartList()));
		dataToBeDisplayed.put("Answer 2 : Unique Hop Pin Code ",fileUtility.getUniqueElements(xlxsFileFormat.getHopList()));
		dataToBeDisplayed.put("Answer 2 : Unique End Pin Code ",fileUtility.getUniqueElements(xlxsFileFormat.getEndList()));
		
		//Getting Unique Routes from the data acquired
		dataToBeDisplayed.put("Answer 3 : Unique Routes ",fileUtility.getUniqueRoutes(xlxsFileFormat));
		//Getting List of SKUs for Routes
		dataToBeDisplayed.put("Answer 4 : SKUs for different routes  ",fileUtility.getSkuForEachRoute(xlxsFileFormat));

		//Displaying Data
		displayingData(dataToBeDisplayed);
		
		long end = System.currentTimeMillis(); 
		logger.debug("Printing all data takes :" + 
                                    (end - start) + "ms"); 

	}
	
	public static void displayingData(Map<String,Object> dataToBeDisplayed) throws InterruptedException{
		for(Map.Entry<String, Object> j : dataToBeDisplayed.entrySet()){
			logger.debug(j.getKey() + j.getValue());
		
		}
	}

}
