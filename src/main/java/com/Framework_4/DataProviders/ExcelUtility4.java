package com.Framework_4.DataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.compare.ObjectToStringComparator;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility4 {
	public static XSSFWorkbook wb;
	public static Object[][] getDataFromExcel(String SheetName) throws IOException
	{ Object[][] obj=null;
		try {
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+ ConfigUtility4.getDataFromConfigFile("TestData_File_Name"))));
			XSSFSheet sh=wb.getSheet(SheetName);
			int row=sh.getPhysicalNumberOfRows();
			int column=sh.getRow(0).getPhysicalNumberOfCells();
			obj=new Object[row][column];
			
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					obj[i][j]=getData(SheetName, i, j);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not found" +e.getMessage());
		} catch (IOException e) {
			System.out.println("File Not Loaded" +e.getMessage());
		}
		//wb.close();
		return obj;
				
	}
	public static String getData(String Sheet, int row, int column)
	{
		String data="";
		XSSFSheet sh=wb.getSheet(Sheet);
		XSSFCell cell=sh.getRow(row).getCell(column);
		if(cell.getCellType()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			double doubleData=cell.getNumericCellValue();
			data=String.valueOf(doubleData);
		}
		else if(cell.getCellType()==CellType.BLANK)
		{
			data="";
		}
		return data;
	}

}
