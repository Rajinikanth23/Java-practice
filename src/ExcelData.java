
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelData {
	
	@DataProvider(name="test")
	public Object[][] print() throws IOException
	{
		File f=new File(System.getProperty("user.dir")+"\\src\\resources\\login.xlsx");
		FileInputStream fs = new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		
		int row = sheet.getLastRowNum();
		String[][] data = new String[row][2];
		
		int j=0;	
		for(int i=1;i<=row;i++,j++)
		{
			Row r = sheet.getRow(i);
			data[j][0] = r.getCell(0).toString();
			data[j][1] = r.getCell(1).toString();
		}
		return data;
	}
	
	@Test(dataProvider="test")
	public void read(String[] str)
	{
		for(int i=0;i<str.length;i++)
			System.out.print(str[i]+" ");
		System.out.println();
	}
}
