package tests;

import library.ExcelReader;
import library.Utility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Setup
{
	@BeforeTest
	@Parameters({"browser","propertyFilePath"})
	public static void setup(String browser,String propertyFilePath)
	throws Exception
	{
		Utility.loadPropertiesFile(propertyFilePath);
		
		String excelFilePath=Utility.getProperty("EXCEL_FILE_PATH");
		String excelWorkbookName=Utility.getProperty("MW_DATA_FILE");
		String excelSheetName=Utility.getProperty("MW_LOGIN_SHEET");
		
		ExcelReader.ReadExcelData(excelFilePath, excelWorkbookName, excelSheetName);
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			Utility.launchFireFox("FIREFOX_PROFILE_PATH");
		}
		else if(browser.equalsIgnoreCase("chrome"));
		{
			Utility.launchChrome("CHROME_PATH");
		}
		
		Utility.launchURL("MW_URL");		
	}
}
