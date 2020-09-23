package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePage 
{
  public WebDriver driver;
  public HomePage(WebDriver driver)
  {
	  this.driver=driver;
  }
  
  By item=By.xpath("//*[@id='main-nav']/a[5]");
  
  @Test
  public WebElement deals() 
  {
	  return driver.findElement(item);
  }
}
