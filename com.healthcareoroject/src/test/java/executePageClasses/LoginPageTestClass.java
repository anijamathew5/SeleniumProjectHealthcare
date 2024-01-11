package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class LoginPageTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	
  @Test(dataProvider = "unsuccessfulllogin",dataProviderClass = DataProviderClass.class,priority = 3,groups = {"group3"})
  public void verifyUnsuccessfullLogin(String uname,String passwd) throws IOException {
	  
	  lp=new LoginPageClass(driver);
	  lp.logIn(uname,passwd);
	  
	  String expectedMessage=lp.readStringData(3,2);
	  String actualMessage=lp.getTextOfErrorMessage();
	  Assert.assertEquals(actualMessage,expectedMessage);
	  
  }
  @Test(dataProvider = "successfulllogin",dataProviderClass = DataProviderClass.class,priority = 2,groups = {"group2"})
  public void verifySuccessfullLogin(String uname1,String passwd1) throws IOException
  {	
	  
	  lp=new LoginPageClass(driver);
	  lp.logIn(uname1,passwd1);
	  
	  hp=new HomePageClass(driver);
	  String expectedMessage=hp.readStringData(1,2);
	  String actualMessage=hp.getTextOfAdminMessage();
	  Assert.assertEquals(actualMessage, expectedMessage);
}
  @Test(priority = 1,groups = {"group1"})
  public void verifyCorrectPageIsLoadedWhileHittingTheUrl()
  {
	  lp=new LoginPageClass(driver);
	  String expectedUrl="https://demo.openmrs.org/openmrs/login.htm";
	  String actualUrl=lp.getCurrentPageUrl();
	  Assert.assertEquals(actualUrl, expectedUrl);
	  System.out.println(actualUrl);
  }
}
