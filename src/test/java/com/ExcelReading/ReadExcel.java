package com.ExcelReading;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Genericmethods.GenericMethods;

public class ReadExcel {
	
	
	
	public static XSSFWorkbook wrkbook;
	
		
	
	public static void loadExcel( String path ) throws IOException
	{
		System.out.println("Loading Excel File");
		
		File f=new File(path);
		
		FileInputStream fis=new FileInputStream(f);
		
		wrkbook=new XSSFWorkbook(fis);
				
	}
	
	public static int getRowCount(String sheetname)
	{
		
		XSSFSheet sheet=wrkbook.getSheet(sheetname);
		
		
		return sheet.getPhysicalNumberOfRows()-1;
	}
	
	
	public static int getColumnCount(String sheetname)
	{
		XSSFSheet sheet=wrkbook.getSheet(sheetname);
		return sheet.getRow(0).getPhysicalNumberOfCells()-1;
	}
	
	public static int searchTestCase(String sheetname,String Testcase)
	{
		int rowfound=0;
		int rowcount=getRowCount(sheetname);
		
		for(int i=0;i<=rowcount;i++)
		{
			String crnttestcase=wrkbook.getSheet(sheetname).getRow(i).getCell(0).getStringCellValue();
			
			if(crnttestcase.equals(Testcase))
			{
				rowfound=i;
				break;
			}
			
			
			
		}
		
		return rowfound;
		
	}
	
	public static int searchColumn(String sheetname,String columnname)
	{
		int colfound=0;
		int colcount=getColumnCount(sheetname);
		
		for(int i=0;i<=colcount;i++)
		{
			String crntcol=wrkbook.getSheet(sheetname).getRow(0).getCell(i).getStringCellValue();
			
			if(crntcol.equals(columnname))
			{
				colfound=i;
				break;
			}
			
			
			
		}
		
		return colfound;
		
	}
	
	
	public static String getData(String sheetname,String columnname)
	{
		String data="";
		int row=searchTestCase(sheetname, GenericMethods.currentClass);
		
		int col=searchColumn(sheetname, columnname);
		
		if(!(row==0 && col==0))
		{
			switch(wrkbook.getSheet(sheetname).getRow(row).getCell(col).getCellTypeEnum())
			{
			
			case STRING:
				data=wrkbook.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
				System.out.println(wrkbook.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue());
				
				break;
				
			case NUMERIC:
				
				data=Integer.toString((int)wrkbook.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue());
				
				
				System.out.println(wrkbook.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue());
				
				break;
				
				
			}
		}
		return data;
		
	}
	
	
	

}
