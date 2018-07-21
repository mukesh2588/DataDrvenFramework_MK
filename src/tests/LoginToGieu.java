package tests;

import library.ExcelReader;
import library.Utility;
import markitwire_pages.Login;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginToGieu
{
	@Test
	public void loginToGieu()
	throws Exception
	{	
		String username=ExcelReader.getData("Gieu", "Username");
		String password=ExcelReader.getData("Gieu", "Password");
		
		Login.putUsername(username);
		Login.putPassword(password);
		
		Utility.captureScreenshot("MW_SCREENSHOT_PATH");
		
		Login.clickSubmit();
		
		Utility.captureScreenshot("MW_SCREENSHOT_PATH");
		
		Assert.assertEquals(false, true);
		
	//	String title="[gieu_ms_cc_trader69a]";
	
	//	Assert.assertEquals(Utility.getDriver().getTitle().contains("[gieu_ms_cc_trader69a]"), title);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		Utility.closeBrowser();
	}
}
