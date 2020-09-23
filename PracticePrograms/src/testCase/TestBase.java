package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase 
{
  public WebDriver driver;
  public Properties prop;
  @Test
  public WebDriver initializeDriver() throws IOException 
  {
	  prop=new Properties();
	  FileInputStream input=new FileInputStream("D:\\Selenium-Practice\\Java-Selenium\\PracticePrograms\\src\\TestData.properties");
	  prop.load(input);
	  String browserName=prop.getProperty("browser");
	  System.out.println(browserName);
	  if(browserName.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
	  }
	  else if(browserName.equals("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
	  }
	  else
	  {
		  System.setProperty("webdriver.ie.driver", "C:\\Drivers\\IEDriverServer.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
	  }
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	return driver;
  }

}
