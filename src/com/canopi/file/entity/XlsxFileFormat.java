package com.canopi.file.entity;

import java.util.List;

public class XlsxFileFormat {
	
	private List<String> skuList ;
	private List<String> startList;
	private List<String> hopList;
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
