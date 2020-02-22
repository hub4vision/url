package com.hub4vision.urls;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRead {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	//Constructor
	public excelRead(String excelPath, String sheetName){
		
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public int getRowCount(){
		int rowCount = 0;
		
		try{
			rowCount = sheet.getPhysicalNumberOfRows();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int getColCount(){
		int colCount = 0;
		
		try{
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		}catch(Exception e){
			e.printStackTrace();
		}
		return colCount;
	}
	
	public double getCellDataNumber(int rowNum, int colnum){
		double cellData =0;
		try{
			cellData = sheet.getRow(rowNum).getCell(colnum).getNumericCellValue();
		}catch(Exception e){
			e.printStackTrace();
		}
		return cellData;
		
	}
	public String getCellDataString(int rowNum, int colNum){
		String cellData=null;

		try{
		cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return cellData;
	}
}
