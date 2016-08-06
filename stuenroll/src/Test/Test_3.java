package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test_3 {
	public static void main(String[] args) {
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(new FileInputStream("E:/培训专业名录.xlsx"));
			XSSFSheet sheet=workbook.getSheet("培训专业概况表");
			XSSFRow	row=sheet.getRow(4);
			XSSFCell c1=row.getCell(2);
			c1.setCellValue("软件");
			
			
			workbook.write(new FileOutputStream("E:/培训专业名录.xlsx"));
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
