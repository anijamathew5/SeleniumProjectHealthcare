package pageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ActiveVisitsClass {
	
	WebDriver driver;
	GeneralUtilities gl=new GeneralUtilities();
	ExplicitWaitClass ew=new ExplicitWaitClass();
	
	public ActiveVisitsClass(WebDriver driver)
	{
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
	
	@FindBy(xpath="//div[contains(text(), \"Start Visit\")]")
	WebElement startvisit;
	
	@FindBy(id="start-visit-with-visittype-confirm")
	WebElement confirm;
	
	@FindBy(css=".icon-home.small")
	WebElement homeicon;
	
	@FindBy(xpath="(//div[contains(text(),\"End Visit\")])[2]")
	WebElement endvisit;
	
	@FindBy(xpath="(//button[@class='confirm right'])[5]")
	WebElement confirmEndVisit;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	
	@FindBy(xpath="//table[@id='active-visits']//tr")
	List<WebElement> row;
	
	@FindBy(xpath="//table[@id='active-visits']//th")
	List<WebElement> column;
	
	public Boolean isPatientNameDisplayedInActiveVisit(String name)
	{
		
		int rowCount = row.size();   
		int colCount = column.size();	
		System.out.println(rowCount+"  "+colCount);   
		
		boolean flag = false;
		
		
		for(int row = 1;row<rowCount;row++) {
			for(int col = 1;col<colCount;col++) {
				
				String actValue = driver.findElement(By.xpath("//table[@id='active-visits']//tr["+row+"]//td["+col+"]")).getText();
				if (actValue.equalsIgnoreCase(name)) {
					
					flag = true;  
					System.out.println(row+" : "+col); 
					break;
					
				}
			}
}
		if (flag) {  
			return true;
		}
		return flag;
}
	
	public void enterPatientName(String patname)
	{
		gl.typeElement(givenpatientname,patname);
	}
	
	public void enterPatientFamilyName(String famname)
	{
		gl.typeElement(familyname,famname);
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
	public void patientBirthMonth(int index)
	{
		gl.toSelectElementIndex(birthmonth, index);
	}
	public void enterPatientBirthyear(String byear)
	{
		gl.typeElement(birthyear, byear);
	}
	public void enterPatientAddress(String addrs)
	{
		gl.typeElement(address1, addrs);
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
	public void clickStartVisit()
	{
		ew.elementToBeClickableWait(driver,startvisit);
		gl.clickElement(startvisit);
	}
	public void clickConfirm()
	{
		gl.clickElement(confirm);
	}
	public void clickHome()
	{
		gl.clickUsingJs(homeicon, driver);
	}
	public void searchPatientName(String searchname)
	{
		gl.typeElement(search, searchname);
	}
	public void clickEndVisit()
	{
		gl.clickElement(endvisit);
	}
	public void clickConfirmEndVisit()
	{
		gl.clickElement(confirmEndVisit);
	}
	public void checkEndVisitChangedToStartVisit()
	{
		gl.getTextOfElement(startvisit);
	}
	}

