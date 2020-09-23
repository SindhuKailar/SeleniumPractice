package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginPage 
{
  public WebDriver driver;
  public LoginPage(WebDriver driver)
  {
	  this.driver=driver;
  }
  
  By loginBtn=By.xpath("//*[@class='rd-navbar-nav']/a");
  By email=By.name("email");
  By password=By.name("password");
  By submit=By.xpath("//*[@class='ui fluid large blue submit button']");
  
  @Test
  public WebElement login() 
  {
	  return driver.findElement(loginBtn);
  }
  @Test
  public WebElement email() 
  {
	  return driver.findElement(email);
  }
  @Test
  public WebElement password() 
  {
	  return driver.findElement(password);
  }
  @Test
  public WebElement submit() 
  {
	  return driver.findElement(submit);
  }
  
  
}
