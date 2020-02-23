package com.canopi.main.application;


import java.util.List;
import java.util.Map;
import java.util.Set;

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
		BasicConfigurator.configure();
		XlsxFileReader xlxsFileReader = new XlsxFileReader();
		FileUtility fileUtility = new FileUtility();
		String path = "F:\\Spring Projects\\Workspace - 1\\AssignmentForCanopi\\sample_shipping_data2.xlsx";
		XlsxFileFormat xlxsFileFormat = new XlsxFileFormat();
		xlxsFileFormat = xlxsFileReader.getAllDataFromFile(path);
		
		Set<String> uniqueRoutes = fileUtility.getUniqueRoutes(xlxsFileFormat);
		Map<String,List<String>> allSkuForEachRoute = fileUtility.getSkuForEachRoute(xlxsFileFormat);
		System.out.println(fileUtility.getUniqueElements(xlxsFileFormat.getSkuList()).size());
//		logger.debug(fileUtility.getUniqueElements(xlxsFileFormat.getSkuList()).toString());
//		logger.debug(fileUtility.getUniqueElements(xlxsFileFormat.getStartList()).toString());
//		logger.debug( fileUtility.getUniqueElements(xlxsFileFormat.getHopList()).toString());
//		logger.debug(fileUtility.getUniqueElements(xlxsFileFormat.getEndList()).toString());
		
//		logger.debug("Unique Routes are : ");
//		for(Map.Entry<String,String> entry : uniqueRoutes.entrySet()){
//			logger.debug(entry.getValue());
//		}
		
//		for(Map.Entry<String,List<String>> entry : allSkuForEachRoute.entrySet()){
//			logger.debug("Sku for route : " + entry.getKey() + " are " + entry.getValue());
//		}
//		
		logger.debug("Number of Unique Routes : " + uniqueRoutes.size());
		long end = System.currentTimeMillis(); 
		logger.debug("Printing all data takes :" + 
                                    (end - start) + "ms"); 

	}

}
