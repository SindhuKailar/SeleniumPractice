package testCase;

import org.testng.annotations.Test;

import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.NewDealPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.testng.annotations.AfterTest;

public class PageNav extends TestBase
{
  @BeforeTest
  public void init() throws IOException 
  {
	  driver=initializeDriver();
  }
  
  @Test(dataProvider="getData")
  public void PageNavigation(String username,String password) 
  {
	  driver.get(prop.getProperty("url"));
	  
	  LoginPage lp=new LoginPage(driver);
	  lp.login().click();
	  lp.email().sendKeys(username);
	  lp.password().sendKeys(password);
	  lp.submit().click();
	  
	  HomePage hp=new HomePage(driver);
	  hp.deals().click();
	  
	  NewDealPage ndp=new NewDealPage(driver);
	  ndp.newDeal().click();
  }
    
  @DataProvider
  public Object[][] getData()
  {
	  Object[][] data=new Object[][]{{"sindhukailar1@gmail.com","Password@123"}};
	  return data;
  }
  
  /*@AfterTest
  public void QuitBrowser()
  {
	  driver.close();
  }*/

}
