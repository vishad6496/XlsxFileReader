package com.canopi.utility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canopi.file.entity.XlsxFileFormat;

public class DataProcessor {
	
	private static final Logger logger = LoggerFactory.getLogger(DataProcessor.class);

	//Method to get unique elements from the file
	public HashSet<String> getUniqueElements(List<String> listWithDuplicates) {
		
		logger.debug("Getting Unique elements");
		LinkedHashSet<String> uniqueList = new LinkedHashSet<String>();
		listWithDuplicates.forEach(test -> uniqueList.add(test) );
		logger.debug("Unique Elements Aqcuired");
		return uniqueList;

	}

	//Method to extract unique routes from file
	public Set<String> getUniqueRoutes(XlsxFileFormat xlxsFileFormat) {
		logger.debug("Getting Unique Routes");
		Set< String> uniqueRoutes = new HashSet<>();		
		String route = "";
				
		for (int iterator = 0; iterator < xlxsFileFormat.getSkuList().size(); iterator++) {			
			route = getRouteAsString(xlxsFileFormat.getStartList().get(iterator), xlxsFileFormat.getHopList().get(iterator), xlxsFileFormat.getEndList().get(iterator));
			uniqueRoutes.add(route);
		}
		logger.debug("Unique Routes Acquired");
		return uniqueRoutes;
	}

	//Method to extract list of SKUs for each route
	public HashMap<String, Set<String>> getSkuForEachRoute(XlsxFileFormat xlxsFileFormat) {
		logger.debug("Getting SKUs for Each Route");
		Map<String, Set<String>> skuForEachRoute = new HashMap<>();
		
		for (int iterator = 0; iterator < xlxsFileFormat.getSkuList().size(); iterator++) {
			String route = getRouteAsString( xlxsFileFormat.getStartList().get(iterator), xlxsFileFormat.getHopList().get(iterator)
					, xlxsFileFormat.getEndList().get(iterator));
			
			if (skuForEachRoute.containsKey(route)) {
				skuForEachRoute.get(route).add(xlxsFileFormat.getSkuList().get(iterator));
			
			} else {
				Set<String> skuList = new HashSet<>();
				skuList.add(xlxsFileFormat.getSkuList().get(iterator));
				skuForEachRoute.put(route, skuList);
			}
		}
		logger.debug("SKUs for different Routes acquired");
		return (HashMap<String, Set<String>>) skuForEachRoute;
	}

	private String getRouteAsString(String start, String hop, String end) {
		return (start + "," + hop + "," + end);

	}
}
