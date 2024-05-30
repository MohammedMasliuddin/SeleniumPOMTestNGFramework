package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellUtils {
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	 
	 public ExcellUtils(String excelPath,String sheetName){
		 try {
		 workBook = new XSSFWorkbook(excelPath);
		 sheet = workBook.getSheet(sheetName);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	 
	 public String getCellDataString(int rowNum,int colNum) {
		 String cellData="";
		 try {
			 cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return cellData;
	 }
	 
	 public double getCellDataNumeric(int rowNum,int colNum) {
		 double cellData = 0;
		 try {
			 cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return cellData;
	 }
}
