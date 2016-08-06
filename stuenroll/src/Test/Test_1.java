package Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test_1 {
	public static void main(String[] args) {
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("员工通讯薄");
		
		XSSFRow r1=sheet.createRow(0);
		XSSFCell c1=r1.createCell(0);
		c1.setCellValue("李强");
		
		
		XSSFCell c2=r1.createCell(1);
		c2.setCellValue("2013081517");
		
		
		XSSFRow r2=sheet.createRow(1);
		XSSFCell c3=r2.createCell(0);
		c3.setCellValue("刘倩");
		XSSFCell c4=r2.createCell(1);
		c4.setCellValue("12345678");
		
		
		try {
			workbook.write(new FileOutputStream("E:/test.xlsx"));
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
