package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.WebDriverHandler;
import org.testng.annotations.Test;

public class NewDealPage 
{
  public WebDriver driver;
  public NewDealPage(WebDriver driver)
  {
	  this.driver=driver;
  }
  
  By newDeal=By.xpath("(//*[@class='ui linkedin button'])[5]");
  
  @Test
  public WebElement newDeal() 
  {
	  return driver.findElement(newDeal);
  }
}
