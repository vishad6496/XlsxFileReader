package com.canopi.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canopi.file.entity.XlsxFileFormat;

public class FileUtility {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtility.class);

	public HashSet<String> getUniqueElements(List<String> listWithDuplicates) {
		
		logger.debug("Getting Unique elements");
		LinkedHashSet<String> uniqueList = new LinkedHashSet<String>();
		listWithDuplicates.forEach(test -> uniqueList.add(test) );
		return uniqueList;

	}

	public Set<String> getUniqueRoutes(XlsxFileFormat xlxsFileFormat) {
		logger.debug("Getting Unique Routes");
		Set< String> uniqueRoutes = new HashSet<>();		
		String route = "";
				
		for (int iterator = 0; iterator < xlxsFileFormat.getSkuList().size(); iterator++) {			
			route = getRouteAsString(xlxsFileFormat.getStartList().get(iterator), xlxsFileFormat.getHopList().get(iterator), xlxsFileFormat.getEndList().get(iterator));
			uniqueRoutes.add(route);
		}
		
		return uniqueRoutes;
	}

	public HashMap<String, List<String>> getSkuForEachRoute(XlsxFileFormat xlxsFileFormat) {
		logger.debug("Getting SKUs for Each Route");
		Map<String, List<String>> skuForEachRoute = new HashMap<>();
		
		for (int iterator = 0; iterator < xlxsFileFormat.getSkuList().size(); iterator++) {
			String route = getRouteAsString( xlxsFileFormat.getStartList().get(iterator), xlxsFileFormat.getHopList().get(iterator)
					, xlxsFileFormat.getEndList().get(iterator));
			
			if (skuForEachRoute.containsKey(route)) {
				skuForEachRoute.get(route).add(xlxsFileFormat.getSkuList().get(iterator));
			
			} else {
				List<String> skuList = new ArrayList<>();
				skuList.add(xlxsFileFormat.getSkuList().get(iterator));
				skuForEachRoute.put(route, skuList);
			}
		}

		return (HashMap<String, List<String>>) skuForEachRoute;
	}

	private String getRouteAsString(String start, String hop, String end) {
		return (start + "," + hop + "," + end);

	}
}
