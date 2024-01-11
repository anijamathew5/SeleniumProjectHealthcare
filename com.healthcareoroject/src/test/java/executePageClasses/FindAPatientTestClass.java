package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.FindAPatientRecordClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;

public class FindAPatientTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	FindAPatientRecordClass fp;
	
	
  @Test(dataProvider = "successfulllogin",dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class)
  public void verifyToFindAPatient(String uname1,String passwd1) throws IOException {
	  
	  lp=new LoginPageClass(driver);
	  lp.logIn(uname1,passwd1);
	  
	  hp=new HomePageClass(driver);
	  hp.clickFindPatient();
	  
	  fp=new FindAPatientRecordClass(driver);
	  Boolean check=fp.isPatientNameDisplayed(fp.readStringData(7,2));
	  Assert.assertTrue(check);
	  
  }
  
		
		
		 
}