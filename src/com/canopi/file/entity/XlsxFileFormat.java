package com.canopi.file.entity;

import java.util.List;

// Class to store data extracted from File
public class XlsxFileFormat {
	
	//List to store SKUs
	private List<String> skuList ;
	//List to store Start Pin Codes
	private List<String> startList;
	//List to store Hop Pin Codes
	private List<String> hopList;
	//List to store End Pin Codes
	private List<String> endList;
	
	public List<String> getSkuList() {
		return skuList;
	}
	public void setSkuList(List<String> skuList) {
		this.skuList = skuList;
	}
	public List<String> getStartList() {
		return startList;
	}
	public void setStartList(List<String> startList) {
		this.startList = startList;
	}
	public List<String> getHopList() {
		return hopList;
	}
	public void setHopList(List<String> hopList) {
		this.hopList = hopList;
	}
	public List<String> getEndList() {
		return endList;
	}
	public void setEndList(List<String> endList) {
		this.endList = endList;
	}
	
}
