package Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test_2 {
	public static void main(String[] args) {
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream("E:/test.xlsx"));
			XSSFSheet sheet=workbook.getSheet("员工通讯薄");
			int first = sheet.getFirstRowNum();//第一个有效的ROW行号
			int last = sheet.getLastRowNum();//最后一个有效的行号
			for(int i=first;i<=last;i++){
				XSSFRow row=sheet.getRow(i);
				XSSFCell c1=row.getCell(0);
				XSSFCell c2=row.getCell(1);
				System.out.println(c1+","+c2);
			}
		
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
