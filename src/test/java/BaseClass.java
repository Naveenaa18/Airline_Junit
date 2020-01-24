import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
	public static void SVT(WebElement e, String a)
	{
		Select s = new Select (e);
		s.selectByVisibleText(a);
	}
	
	public static void SVT1(WebElement con,String str)
	
	{
		Select s = new Select(con);
		s.selectByVisibleText(str);
		
	}
	
	public static String excelData(int rNo, int cNo) throws Throwable
	{
		String input = null;
		File loc = new File("C:\\Users\\Naveenaa\\eclipse-workspace\\Airlines\\Excel\\Airline-data.xlsx");
		FileInputStream s = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(s);
		Sheet sh = w.getSheet("Test Data");
		Row r = sh.getRow(rNo);
		Cell c = r.getCell(cNo);
		int i = c.getCellType();
		
		if(i==1)
		{
		input = c.getStringCellValue();
		}
		else
		{
			double d = c.getNumericCellValue();
			long l = (long)d;
			input = String.valueOf(l);			
		}
		return input;
		
	}
	

}
