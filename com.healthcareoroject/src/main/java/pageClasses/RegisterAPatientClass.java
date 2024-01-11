package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;
import utilities.RandomDataUtility;

public class RegisterAPatientClass {
	
	WebDriver driver;
	GeneralUtilities gl=new GeneralUtilities();
	ExplicitWaitClass ew=new ExplicitWaitClass();
	
	public RegisterAPatientClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="givenName")
	WebElement givenpatientname;
	
	@FindBy(name="familyName")
	WebElement familyname;
	
	@FindBy(id="next-button")
	WebElement nxtbutton;
	
	@FindBy(id="gender-field")
	WebElement gender;
	
	@FindBy(id="birthdateDay-field")
	WebElement birthday;
	
	@FindBy(id="birthdateMonth-field")
	WebElement birthmonth;
	
	@FindBy(name="birthdateYear")
	WebElement birthyear;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="submit")
	WebElement confirmbutton;
	
	@FindBy(xpath="//span[@class='PersonName-familyName']")
	WebElement editedFamilyName;
	
	@FindBy(xpath="(//div[@class='col-11 col-lg-10'])[7]")
	WebElement editPatient;
	
	@FindBy(id="demographics-edit-link")
	WebElement editclick;
	
	@FindBy(id="save-form")
	WebElement saveeditdetails;
	
	@FindBy(xpath="//button[@id='registration-submit']")
	WebElement confirmbuttonafteredit;
	
	@FindBy(xpath="(//div[@class='col-11 col-lg-10'])[8]")
	WebElement deletePatient;
	
	@FindBy(id="delete-reason")
	WebElement deleteReason;
	
	@FindBy(xpath="(//button[@class='confirm right'])[6]")
	WebElement confirmDelete;
	
	@FindBy(xpath="//input[@class='form-control'])[1]")
	WebElement search;
	
	public void enterPatientName(String patname)
	{
		gl.typeElement(givenpatientname,patname);
	}
	
	public String readPatientGivenName()
	{
		return RandomDataUtility.getfName();
	}
	
	public void enterPatientFamilyName(String famname)
	{
		gl.typeElement(familyname,famname);
	}
	
	public String readPatientFamilyName()
	{
		return RandomDataUtility.getfName();
	}
	
	public void clickNextButton()
	{
		gl.clickElement(nxtbutton);
	}
	public void patientGender(int index)
	{
		gl.toSelectElementIndex(gender, index);
	}
	public void enterPatientBirthday(String bday)
	{
		gl.typeElement(birthday, bday);
	}
	public String readBirthday()
	{
		return RandomDataUtility.getBirthDayDate();
	}
	public void patientBirthmonth(int value)
	{
		gl.toSelectElementIndex(birthmonth,value);
	}
	public void enterPatientBirthyear(String byear)
	{
		gl.typeElement(birthyear, byear);
	}
	
	public String readBirthYear()
	{
		return RandomDataUtility.getBirthDayYear();
	}
	
	public void enterPatientAddress(String addrs)
	{
		gl.typeElement(address1, addrs);
	}
	public String readPatientAddress()
	{
		return RandomDataUtility.getFullAddress();
	}
	
	public void confirmPatientDetails()
	{
		gl.clickElement(confirmbutton);
	}
	public String readStringData(int row,int column) throws IOException
	{
		return ExcelReadClass.getStringdata(row, column);
	}
	
	public String readIntegerData(int row,int column) throws IOException
	{
		return ExcelReadClass.getIntegerdata(row, column);
	}
	
	
	public void clickEditPatientDetails()
	{
		gl.clickElement(editPatient);
	}
	public void clearPatientDetailsForEdit()
	{
		gl.clearElement(familyname);
	}
	public void clickEditPatientDetailsIcon()
	{
		gl.clickElement(editclick);
	}
	public void clickEditPatientSaveFormButton()
	{
		gl.clickElement(saveeditdetails);
	}
	public void clickConfirmButtonAfterEdit()
	{
		gl.clickElement(confirmbuttonafteredit);
	}
	public void clickDeleteAPatient()
	{
		gl.clickElement(deletePatient);
	}
	public void enterReasonForDelete(String reason)
	{
		gl.typeElement(deleteReason,reason);
	}
	
	public void clickConfirmDeleteAPatient()
	{
		gl.clickElement(confirmDelete);
	}
	public String getTextOfPatientFamilyName()
	{
		return gl.getTextOfElement(editedFamilyName);
	}
	
	public void clickSearchFindAPatient()
	{
		gl.clickElement(search);
	}
	
	
		
}
