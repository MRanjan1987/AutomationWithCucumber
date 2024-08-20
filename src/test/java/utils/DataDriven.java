package utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataDriven {

	@DataProvider(name = "loginData")
	public Object[][] loginData() throws IOException {
		ExcelUtils.setExcelFile("Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		int colCount = ExcelUtils.getColumnCount();

		Object[][] data = new Object[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i - 1][j] = ExcelUtils.getCellData(i, j);
			}
		}
		return data;
	}
}
