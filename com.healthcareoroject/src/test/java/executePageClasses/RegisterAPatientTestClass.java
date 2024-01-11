package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatientClass;

public class RegisterAPatientTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientClass rp;
	

	@Test(dataProvider = "successfulllogin",dataProviderClass = DataProviderClass.class)
  public void verifyPatientCanRegisterSuccessfully(String uname1,String passwd1) throws IOException {
	  lp=new LoginPageClass(driver);
	  lp.logIn(uname1,passwd1);
	  
	  hp=new HomePageClass(driver);
	  hp.clickRegAPatient();
	  
	  rp=new RegisterAPatientClass(driver);
	  rp.enterPatientName(rp.readPatientGivenName());
	  String familyName=rp.readPatientFamilyName();
	  rp.enterPatientFamilyName(familyName);
	  rp.clickNextButton();
	  rp.patientGender(1);
	  rp.clickNextButton();
	  rp.enterPatientBirthday(rp.readBirthday());
	  rp.patientBirthmonth(4);
	  rp.enterPatientBirthyear(rp.readBirthYear());
	  rp.clickNextButton();
	  rp.enterPatientAddress(rp.readPatientAddress());
	  rp.clickNextButton();
	  rp.clickNextButton();
	  rp.clickNextButton();
	  rp.confirmPatientDetails();
	  
	  String expectedText=familyName;
	  String actualText=rp.getTextOfPatientFamilyName();
	  Assert.assertEquals(actualText, expectedText);
	  
	  }
	@Test(dataProvider = "successfulllogin",dataProviderClass = DataProviderClass.class,priority=1)
	  public void verifyPatientCanEditDetailsSuccessfully(String uname1,String passwd1) throws IOException {
		lp=new LoginPageClass(driver);
		  lp.logIn(uname1,passwd1);
		  
		  hp=new HomePageClass(driver);
		  hp.clickRegAPatient();
		  
		  rp=new RegisterAPatientClass(driver);
		  rp.enterPatientName(rp.readPatientGivenName());
		  String familyName=rp.readPatientFamilyName();
		  rp.enterPatientFamilyName(familyName);
		  rp.clickNextButton();
		  rp.patientGender(1);
		  rp.clickNextButton();
		  rp.enterPatientBirthday(rp.readBirthday());
		  rp.patientBirthmonth(4);
		  rp.enterPatientBirthyear(rp.readBirthYear());
		  rp.clickNextButton();
		  rp.enterPatientAddress(rp.readPatientAddress());
		  rp.clickNextButton();
		  rp.clickNextButton();
		  rp.clickNextButton();
		  rp.confirmPatientDetails();
		  
		  rp.clickEditPatientDetails();
		  rp.clickEditPatientDetailsIcon();
		  rp.clearPatientDetailsForEdit();
		  rp.enterPatientFamilyName(familyName);
		  rp.clickEditPatientSaveFormButton();
		  rp.clickConfirmButtonAfterEdit();
		  String expectedText=familyName;
		  String actualText=rp.getTextOfPatientFamilyName();
		  Assert.assertEquals(actualText, expectedText);
		  
}
	
	@Test(dataProvider = "successfulllogin",dataProviderClass = DataProviderClass.class,priority=1)
	  public void verifyPatientCanDeleteSuccessfully(String uname1,String passwd1) throws IOException {
		lp=new LoginPageClass(driver);
		  lp.logIn(uname1,passwd1);
		  
		  hp=new HomePageClass(driver);
		  hp.clickRegAPatient();
		  
		  rp=new RegisterAPatientClass(driver);
		  rp.enterPatientName(rp.readPatientGivenName());
		  String familyName=rp.readPatientFamilyName();
		  rp.enterPatientFamilyName(familyName);
		  rp.clickNextButton();
		  rp.patientGender(1);
		  rp.clickNextButton();
		  rp.enterPatientBirthday(rp.readBirthday());
		  rp.patientBirthmonth(4);
		  rp.enterPatientBirthyear(rp.readBirthYear());
		  rp.clickNextButton();
		  rp.enterPatientAddress(rp.readPatientAddress());
		  rp.clickNextButton();
		  rp.clickNextButton();
		  rp.clickNextButton();
		  rp.confirmPatientDetails();
		  rp.clickDeleteAPatient();
		  rp.enterReasonForDelete(rp.readStringData(15,1));
		  rp.clickConfirmDeleteAPatient();
		  
		  
		  
		  }
	
	
		 
		 
		 
	}

