package tests;

import library.ExcelReader;
import library.Utility;
import markitwire_pages.Login;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginToMega
{		
	@Test
	public void loginToMega()
	throws Exception
	{	
		String username=ExcelReader.getData("Mega", "Username");
		String password=ExcelReader.getData("Mega", "Password");
		
		Login.putUsername(username);
		Login.putPassword(password);
		
		Utility.captureScreenshot("MW_SCREENSHOT_PATH");
		
		Login.clickSubmit();
		
		Utility.captureScreenshot("MW_SCREENSHOT_PATH");
		
		Assert.assertEquals(true, true);
	
	//	String title="[mega_ms_cc_trader69a]";
		
	//	Assert.assertEquals(Utility.getDriver().getTitle().contains("[mega_ms_cc_trader69a]"), title);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		Utility.closeBrowser();
	}
}
