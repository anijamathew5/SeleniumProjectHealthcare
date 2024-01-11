package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.ActiveVisitsClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatientClass;
import retryAnalyzer.RetryAnalyzer;

public class ActiveVisitsTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientClass rp;
	ActiveVisitsClass av;
	@Test(dataProvider = "successfulllogin",dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class)
  public void verifyPatientIsActiveVisitPageWhileStartVisit(String uname1,String passwd1) throws IOException, InterruptedException {
		lp=new LoginPageClass(driver);
		  lp.logIn(uname1,passwd1);
		  hp=new HomePageClass(driver);
		  hp.clickRegAPatient();
		  rp=new RegisterAPatientClass(driver);
		  av=new ActiveVisitsClass(driver);
		  
		  av.enterPatientName(rp.readStringData(7,1));
		  av.enterPatientFamilyName(rp.readStringData(8,1));
		  av.clickNextButton();
		  av.patientGender(1);
		  av.clickNextButton();
		  av.enterPatientBirthday(rp.readIntegerData(9,1));
		  av.patientBirthMonth(2);
		  av.enterPatientBirthyear(rp.readIntegerData(10,1));
		  av.clickNextButton();
		  av.enterPatientAddress(rp.readStringData(11,1));
		  av.clickNextButton();
		  av.clickNextButton();
		  av.clickNextButton();
		  av.confirmPatientDetails();
		  av.clickStartVisit();
		  av.clickConfirm();
		  av.clickHome();
		  hp.clickActiveVisit();
		 
		  Boolean status=av.isPatientNameDisplayedInActiveVisit(av.readStringData(8,2));
		  Assert.assertTrue(status);
		  
		  av.searchPatientName(av.readStringData(8,2));
	}
	
	@Test(dataProvider = "successfulllogin",dataProviderClass = DataProviderClass.class,retryAnalyzer = RetryAnalyzer.class)
	  public void verifyPatientIsActiveVisitPageWhileEndVisit(String uname1,String passwd1) throws IOException, InterruptedException{
		lp=new LoginPageClass(driver);
		  lp.logIn(uname1,passwd1);
		  hp=new HomePageClass(driver);
		  hp.clickRegAPatient();
		  rp=new RegisterAPatientClass(driver);
		  av=new ActiveVisitsClass(driver);
		  
		  av.enterPatientName(rp.readStringData(7,1));
		  av.enterPatientFamilyName(rp.readStringData(8,1));
		  av.clickNextButton();
		  av.patientGender(1);
		  av.clickNextButton();
		  av.enterPatientBirthday(rp.readIntegerData(9,1));
		  av.patientBirthMonth(2);
		  av.enterPatientBirthyear(rp.readIntegerData(10,1));
		  av.clickNextButton();
		  av.enterPatientAddress(rp.readStringData(11,1));
		  av.clickNextButton();
		  av.clickNextButton();
		  av.clickNextButton();
		  av.confirmPatientDetails();
		  av.clickStartVisit();
		  av.clickConfirm();
		  av.clickHome();
		  hp.clickActiveVisit();
		  
		  Boolean status=av.isPatientNameDisplayedInActiveVisit(av.readStringData(8,2));
		  Assert.assertTrue(status);
		  av.searchPatientName(av.readStringData(8,2));
		  av.clickEndVisit();
		  av.clickConfirmEndVisit();
		  av.checkEndVisitChangedToStartVisit();
		  
			  
			  
		}
}
