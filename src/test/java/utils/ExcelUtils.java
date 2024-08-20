package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
	private static final String FILE_PATH = ".\\src\\test\\resources\\datasheet\\userdatasheet.xlsx";
	private static Workbook workbook;
	private static Sheet sheet;

	public static void setExcelFile(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(FILE_PATH);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
	}

	public static String getCellData(int rowNum, int colNum) {
		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		return cell.getStringCellValue();
	}

	public static int getRowCount() {
		return sheet.getLastRowNum();
	}

	public static int getColumnCount() {
		return sheet.getRow(0).getLastCellNum();
	}
}
