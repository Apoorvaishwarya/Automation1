package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XL {
	
	public static String getCellValue(String path,String sheet,int r,int c) {
		
		String v1=" ";
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			v1=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	   return v1;	
	}
	
	public static int getRowCount(String path,String sheet) {
		
		int r=0;
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			r=wb.getSheet(sheet).getLastRowNum();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	  return r;
	}

}
