package com.mindtree.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mindtree.exception.UtilityException;

public class ExcelSheetRead {
	
	
	static XSSFWorkbook work;
	static XSSFSheet sheet;

	public static void main(String[] args) {
		

	}
	
	public ExcelSheetRead(String excelPath,String Sheetname) throws Exception
	{
		try
		{	
			work=new XSSFWorkbook(excelPath);
			sheet=work.getSheet(Sheetname);
		}
		catch(Exception exp)
		{
			throw new UtilityException(exp.getMessage());
		}	
	}
	
	public Object getStringData(int rowNum,int colNum) throws UtilityException
	{
		String searchValue = "";
		try {
			searchValue=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		}
		catch(Exception ex)
		{
			throw new UtilityException(ex.getMessage());
		}
		return searchValue;	
	}
	
	public Object getNumericData(int rowNum,int colNum) throws UtilityException
	{
		double searchValue1;
		try {
			searchValue1=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		}
		catch(Exception ex)
		{
			throw new UtilityException(ex.getMessage());
		}
		return searchValue1;	
	}

}
