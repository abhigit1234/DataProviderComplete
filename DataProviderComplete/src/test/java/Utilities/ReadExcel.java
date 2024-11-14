package Utilities;

import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcel {

	/*
	 * @DataProvider(name = "a",parallel = true) public Object[][] rules()throws
	 * Exception{ FileInputStream fis = new
	 * FileInputStream("C:\\\\Users\\\\abhil\\\\OneDrive\\\\Desktop\\\\test.xlsx");
	 * XSSFWorkbook wb = new XSSFWorkbook(fis); XSSFSheet sheet =
	 * wb.getSheet("TestCase"); int row = sheet.getLastRowNum(); int cel =
	 * sheet.getRow(0).getLastCellNum(); Object[][] data = new Object[row][cel]; for
	 * (int i = 1; i <= row; i++) { for (int j = 0; j < cel; j++) { XSSFCell cell =
	 * sheet.getRow(i).getCell(j); DataFormatter df = new DataFormatter();
	 * data[i-1][j] = df.formatCellValue(cell);
	 * 
	 * }
	 * 
	 * } wb.close(); fis.close(); return data;
	 * 
	 * } }
	 */

	@DataProvider(name = "login", parallel = true)
	@Test
	public Object[][] getData() throws Exception {
		String path = "C:\\Users\\abhil\\OneDrive\\Desktop\\test.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		int totalRows = xl.getRowCount("TestCase");
		int totalCols = xl.getCellCount("TestCase", 1);
		Object[][] data = new Object[totalRows][totalCols];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				data[i - 1][j] = xl.getCellData("TEstCase", i, j);
			}

		}
		return data;

	}

}
