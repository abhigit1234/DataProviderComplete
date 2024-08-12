package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	 public String path;
	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public ExcelUtility(String path) {
		this.path=path;
	}
		
	
	public int getRowCount(String sheetName) throws Exception{
		
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
			sheet =	wb.getSheet(sheetName);
			int rowCount = 	sheet.getLastRowNum();
			wb.close();
			fis.close();	
			return rowCount;		
	}
	
	public int getCellCount(String SheetName,int rowNum) throws Exception{
			fis = new FileInputStream(path);
			wb=new XSSFWorkbook(fis);
			sheet = wb.getSheet(SheetName);
			row = sheet.getRow(rowNum);
			int cellCount = row.getLastCellNum();
			fis.close();
			wb.close();
			return cellCount;
	}
	
	
	public String getCellData(String SheetName,int rowNum,int colNum) throws Exception{
		fis = new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sheet = wb.getSheet(SheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		DataFormatter df = new DataFormatter();
		String data = df.formatCellValue(cell);
		fis.close();
		wb.close();
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
		
		
	

