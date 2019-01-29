package com.ConvergeHub.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
	

	public void SetCellData(String sheetname,int rownum,int colnum,String val)
	{
		try
		{
		sheet=workbook.getSheet(sheetname);
		cell=sheet.getRow(rownum).getCell(colnum);
		fileout=new FileOutputStream(path);	
		cell.setCellValue(val);
		workbook.write(fileout);		
		fileout.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getCellDataUpd(String sheetName, String colName, int rowNum)
    {
		//Row and column starting with zero
        try
        {
            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }
 
            row = sheet.getRow(rowNum);
            cell = row.getCell(col_Num);
            
           return cell.getStringCellValue();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "row "+rowNum+" or column "+colName +" does not exist  in Excel";
        }
    }
	

}
