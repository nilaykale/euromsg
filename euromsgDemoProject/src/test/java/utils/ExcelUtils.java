package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static void main(String[] args) {
		//getRowCount();
		//getCellData(1, 1);
		//getCellData();
	}

	public ExcelUtils(String excelPath, String sheetName){
		try {
			
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}catch(Exception e) {		
			e.printStackTrace();
		}

	}
	
	public static int getRowCount() {
		int rowCount=0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows:"+rowCount);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}


	public static int getColCount() {
		int colCount=0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of cols:"+colCount);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}

	public static String getCellData(int rowNum, int colNum) {
		String cellData = null;
		try {	
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(cellData);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}
	
	public Object[][] testData() {
		//ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = getRowCount();
		int colCount = getColCount();

		Object data [][] = new Object[rowCount-1][colCount];

		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {

				String cellData = getCellData(i, j);
				//System.out.print(cellData+ " | ");
				data[i-1][j] = cellData;
			}
			System.out.println();		
		}
		return data;
	}
}
