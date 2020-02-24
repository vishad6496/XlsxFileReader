package com.canopi.file.reader;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canopi.exception.handler.EmptyCellException;
import com.canopi.file.entity.XlsxFileFormat;

public class XlsxFileReader {
	
	public static List<String> invalidPincodes = new ArrayList<>();

	private static final Logger logger = LoggerFactory.getLogger(XlsxFileReader.class);

	@SuppressWarnings("resource")
	public XlsxFileFormat getAllDataFromFile(String path) throws Exception {

		logger.debug("Getting data from file");
		// Declaring Instances to store data from file
		XlsxFileFormat xlxsFileFormat = new XlsxFileFormat();
		List<String> skuList = new ArrayList<>();
		List<String> startList = new ArrayList<>();
		List<String> hopList = new ArrayList<>();
		List<String> endList = new ArrayList<>();

		// Creating workbook to get xlsx file
		FileInputStream fis = new FileInputStream(new File(path));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		logger.debug("Fetching data over iteration");
		// Row Iterator
		Iterator<Row> rowIterator = sheet.iterator();
		Row row = rowIterator.next();
		while (rowIterator.hasNext()) {

			row = rowIterator.next();

			if ( validateRowData(row)) {

				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();
					skuList.add(cell.getStringCellValue());

					cell = cellIterator.next();
					startList.add(cell.getStringCellValue());

					cell = cellIterator.next();
					hopList.add(cell.getStringCellValue());

					cell = cellIterator.next();
					endList.add(cell.getStringCellValue());
				}
			}
			xlxsFileFormat.setSkuList(skuList);
			xlxsFileFormat.setStartList(startList);
			xlxsFileFormat.setHopList(hopList);
			xlxsFileFormat.setEndList(endList);
		}
		logger.debug("Data Acquired");
		
		return xlxsFileFormat;

	}
	
	private boolean validateRowData(Row row) throws EmptyCellException{
		//Checking if row has empty cells
		if(checkIfRowIsEmpty(row) ){
			return false;
		}
		//Checking if pincodes are valid
		for (int cellNum = (row.getFirstCellNum() + 1); cellNum < row.getLastCellNum(); cellNum++){
		
			Cell cell = row.getCell(cellNum);
			if(!cell.getStringCellValue().matches("^\\d{6}$")){
				logger.warn("Row Number : " + row.getRowNum() + " Cell : " + cellNum + " has Invalid Pincode");
				logger.warn("Skipping this row");
				invalidPincodes.add(cell.getStringCellValue());
				return false;
				
			}
		}
		
		return true;
	}
	

	private boolean checkIfRowIsEmpty(Row row) throws EmptyCellException {
		// Checking if row is not null
		if (row == null) {
			return true;
		}
		if (row.getLastCellNum() <= 0) {
			return true;
		}
		for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
			Cell cell = row.getCell(cellNum);

			// Checking if any cell is null/blank/empty in a row
			if (cell == null || cell.getCellTypeEnum() == CellType.BLANK || StringUtils.isEmpty(cell.toString())) {
				logger.error("Empty Cell Found");
				throw new EmptyCellException("Empty Cell Found");
			}

		}
		return false;
	}
}
