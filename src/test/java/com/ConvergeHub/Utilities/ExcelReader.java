package com.ConvergeHub.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	public String path;
	public FileInputStream fis=null;
	public FileOutputStream fileout=null;
	/*
	private XSSFWorkbook workbook=null;
	private XSSFSheet sheet=null;
	private XSSFRow row=null;
	private XSSFCell cell=null;*/
	
	private HSSFWorkbook workbook=null;
	private HSSFSheet sheet=null;
	private HSSFRow row=null;
	private HSSFCell cell=null;
	
	public ExcelReader(String path)
	{
		this.path=path;
		try
		{
			fis=new FileInputStream(path);
			workbook=new HSSFWorkbook(fis);
			sheet=workbook.getSheetAt(0);
			fis.close();
		}
		catch(Exception e)
		{
			
			
			
			
		}
	}
	
	public int getRowCount(String sheetname)
	{
		sheet=workbook.getSheet(sheetname);
		System.out.println(sheet.getLastRowNum());
		return sheet.getLastRowNum();
	}
	
	public int getColumnCount(String sheetname)
	{
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(0);
		return row.getLastCellNum();
	}
	
	public String GetCellData(String sheetname,int rownum,int colnum)
	{
		sheet=workbook.getSheet(sheetname);
		cell=sheet.getRow(rownum).getCell(colnum);
		return cell.getStringCellValue();
		
	}


}
