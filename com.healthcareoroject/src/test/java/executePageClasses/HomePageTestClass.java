package executePageClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class HomePageTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	
  @Test(dataProvider = "successfulllogin",dataProviderClass = DataProviderClass.class,groups = {"group1"})
  public void verifyAllTilesAreDisplayedInHomePage(String uname1,String passwd1) {
	  
	  lp=new LoginPageClass(driver);
	  lp.logIn(uname1,passwd1);
	  
	  hp=new HomePageClass(driver);
	   Boolean actualResult=hp.isAllTilesDisplayed();
	   Assert.assertTrue(actualResult);
 
}
  
  @Test(dataProvider = "successfulllogin",dataProviderClass = DataProviderClass.class,groups = {"group2"})
  public void verifyUserCanLogoutSuccessfully(String uname1,String passwd1) {
		
			lp=new LoginPageClass(driver);
			lp.logIn(uname1,passwd1);
			hp=new HomePageClass(driver);
				
			
			hp.clickLogout();
			
			String expectedUrl="https://demo.openmrs.org/openmrs/login.htm";
			String actualUrl=lp.getCurrentPageUrl();
			Assert.assertEquals(actualUrl, expectedUrl);
			System.out.println(actualUrl);
			
  }
}
