package org.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetHelper  {

public static String readData(String sheetName, int rowNo, int cellNo) throws IOException {
		
		File f = new File("C:\\Users\\sendo\\eclipse-workspace\\Framework1\\ExcelSheet\\Employee.xlsx");
		FileInputStream fin = new FileInputStream(f);
		
		Workbook bk = new XSSFWorkbook(fin);
		
		Sheet sh = bk.getSheet(sheetName);
		
		Row r = sh.getRow(rowNo);
		
		Cell c= r.getCell(cellNo);
	    
	    int type = c.getCellType();
	    
	    String data="";
	    if (type==1) {
			data= c.getStringCellValue();
		}
	 
	    else if (DateUtil.isCellDateFormatted(c)) {
			
	    	Date da = c.getDateCellValue();
	    	SimpleDateFormat sim = new SimpleDateFormat("dd-MMM-yyyy");
	    	data = sim.format(da);   	
	    	
		}
	    
	    else {
			
	    	double d = c.getNumericCellValue();
	    	long l = (long)d;
	    	data = String.valueOf(l);
		}
	    
	    return data;
	}

   public static String writeData(String sheetName, int rowNo ,int cellNo, String ele) throws IOException {

	   File f = new File("C:\\Users\\sendo\\eclipse-workspace\\Framework1\\ExcelSheet\\Employee.xlsx");
		FileInputStream fin = new FileInputStream(f);
		
		Workbook bk = new XSSFWorkbook(fin);
		
		Sheet sh = bk.getSheet(sheetName);
		
		Row r1 = sh.getRow(rowNo);
		
		Cell c1= r1.createCell(cellNo);
		
		 c1.setCellValue(ele);
	   
		FileOutputStream fout = new FileOutputStream(f);
		bk.write(fout);
		return ele;
	

}

}
