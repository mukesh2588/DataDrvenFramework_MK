package library;

import java.io.FileInputStream;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{
	static String testCase;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public static LinkedHashMap<String,LinkedHashMap<String,String>> hm
	=new LinkedHashMap<String,LinkedHashMap<String,String>>();
	
	public static void ReadExcelData(String filePath,String workbookName,String sheetName)
	throws Exception
	{
		String excelPath=filePath+workbookName;
		
		FileInputStream fis=new FileInputStream(excelPath);
		
		workbook=new XSSFWorkbook(fis);
		
		sheet=workbook.getSheet(sheetName);
		
		Row HeaderRow=sheet.getRow(0);
		
		int rowCount=0;
		rowCount=sheet.getPhysicalNumberOfRows();
		
		for(int i=0;i<rowCount;i++)
		{
			Row currentRow=sheet.getRow(i);
			
			int colCount=0;
			colCount=currentRow.getPhysicalNumberOfCells();
			
			LinkedHashMap<String,String> currentHash=new LinkedHashMap<String,String>();
			
			for(int j=0;j<colCount;j++)
			{
				Cell currentCell1=currentRow.getCell(0);
				
				switch(currentCell1.getCellType())
				{
					case Cell.CELL_TYPE_BLANK:
						continue;
						
					case Cell.CELL_TYPE_STRING:
						testCase=currentCell1.getStringCellValue();
					//	System.out.println("testcase="+testCase);
						break;
						
					case Cell.CELL_TYPE_NUMERIC:
						testCase=String.valueOf(currentCell1.getNumericCellValue());
					//	System.out.println("testcase="+testCase);
						break;
				}
					
				Cell currentCell=currentRow.getCell(j);
				
				if(currentCell==null)
					continue;
				
				switch(currentCell.getCellType())
				{
					case Cell.CELL_TYPE_BLANK:
						continue;
						
					case Cell.CELL_TYPE_STRING:
						currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						break;
						
					case Cell.CELL_TYPE_NUMERIC:
						currentHash.put(HeaderRow.getCell(j).getStringCellValue(),String.valueOf(currentCell.getNumericCellValue()));
						break;
				}
			}
		//	System.out.println("testcase="+testCase+"\n"+"currentHash="+currentHash);
			hm.put(testCase,currentHash);
		//	System.out.println(hm.put(testCase,currentHash));
		}
		workbook.close();
	}

	public static String getData(String tc,String key)
	{
	//	System.out.println(hm.get(tc).get(key));
		String data= hm.get(tc).get(key);
		return data;	
		//sample
	}
}