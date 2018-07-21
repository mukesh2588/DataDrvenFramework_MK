package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility
{
	public static WebDriver driver;
	public static Properties properties;
	
	public static void loadPropertiesFile(String propertyFilePath)
	{
		properties=new Properties();
		
		File file=new File(propertyFilePath);
		
		try {
			FileInputStream fis=new FileInputStream(file);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String property)
	{
		return properties.getProperty(property);
	}

	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static void launchFireFox(String FirefoxProfilePath)
	{
		FirefoxProfile profile=new FirefoxProfile(new File(getProperty(FirefoxProfilePath)));
		driver=new FirefoxDriver(profile);
	}
	
	public static void launchChrome(String ChromePath)
	{
		System.setProperty("webdriver.chrome.driver", getProperty(ChromePath));
	}
	
	public static void launchURL(String URL)
	{
		driver.get(getProperty(URL));
	}
	
	public static WebDriverWait getExplicitWait(int timeInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeInSeconds);
		return wait;
	}
	
	public static By returnIdLocator(String locator)
	{
		By id=By.id(getProperty(locator));
		return id;
	}
	
	public static By returnNameLocator(String locator)
	{
		By name=By.name(getProperty(locator));
		return name;
	}
	
	public static By returnXPathLocator(String locator)
	{
		By xpath=By.xpath(getProperty(locator));
		return xpath;
	}
	
	public static void captureScreenshot(String ScreenshotFilePath)
	throws Exception
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
				
		String fileName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		File src=screenshot.getScreenshotAs(OutputType.FILE);
				
		String destFilePath=getProperty(ScreenshotFilePath)+fileName+".png";
				
		File destFile=new File(destFilePath);
				
		FileUtils.copyFile(src, destFile);
				
	//	return destFilePath;		
	}
	
	public static WebElement getElementById(String ID)
	{
		return driver.findElement(By.id(getProperty(ID)));
	}
	
	public static WebElement getElementByName(String Name)
	{
		return driver.findElement(By.name(getProperty(Name)));
	}
	
	public static WebElement getElementByXPath(String XPath)
	{
		return driver.findElement(By.xpath(getProperty(XPath)));
	}
	
	public static void closeBrowser()
	{
		driver.close();
	}
}
