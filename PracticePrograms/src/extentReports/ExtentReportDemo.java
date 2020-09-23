package extentReports;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class ExtentReportDemo 
{
	static ExtentReports report;
	static ExtentTest test;
	public WebDriver driver;
	@BeforeClass
	public void startTest() 
	{
		report=new ExtentReports("C:\\Users\\Vatsa\\Desktop\\Java+Selenium classes\\Extent Reports\\Result_Report.html");
		test=report.startTest("ExtentReportDemo ");		
	}

	@Test
	public void ExtentDemo() throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		try {
			if(driver.getTitle().equals("Practice Page"))
			{
				System.out.println(driver.getTitle());
				test.log(LogStatus.PASS,"Test passed");
			}
			else
			{
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+"Test Failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private String capture(WebDriver driver) throws IOException
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Vatsa\\Desktop\\Java+Selenium classes\\screenshots\\error_screen.png");
		String errflpath=dest.getAbsolutePath();
		FileUtils.copyFile(srcFile,dest);
		return errflpath;
	}

	@AfterClass
	public void endTest() 
	{
		report.endTest(test);
		report.flush();		
	}
	
	@AfterTest
	public void quitBrowser() 
	{
		driver.close();	
	}

}
