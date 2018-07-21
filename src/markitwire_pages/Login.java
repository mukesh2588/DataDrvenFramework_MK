package markitwire_pages;

import library.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login
{
	public static void putUsername(String userName)
	{
		Utility.getElementByName("username_name").sendKeys(userName);
	}
	
	public static void putPassword(String passWord)
	{
		Utility.getElementByName("password_name").sendKeys(passWord);
	}
	
	public static void clickSubmit()
	{
		By submit=Utility.returnXPathLocator("submit_btn_xpath");
		
		Utility.getExplicitWait(10).until(ExpectedConditions.elementToBeClickable(submit)).click();
	}
}
