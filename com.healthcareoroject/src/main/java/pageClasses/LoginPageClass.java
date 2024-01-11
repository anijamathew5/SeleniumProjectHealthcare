package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class LoginPageClass {
	
	WebDriver driver;
	
	GeneralUtilities gl=new GeneralUtilities();
	
	public LoginPageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginButton")
	WebElement login;
	
	@FindBy(id="Registration Desk")
	WebElement registrationDesk;
	
	@FindBy(id="error-message")
	WebElement errorMessage;
	
	public void logIn(String uname,String pswd)
	{
		gl.typeElement(username,uname);
		gl.typeElement(password, pswd);
		gl.clickElement(registrationDesk);
		gl.clickElement(login);
	}
	
	public String readStringData(int row,int column) throws IOException
	{
		return ExcelReadClass.getStringdata(row, column);
	}
	
	public String readIntegerData(int row,int column) throws IOException
	{
		return ExcelReadClass.getIntegerdata(row, column);
	}
	
	public String getTextOfErrorMessage()
	{
		return gl.getTextOfElement(errorMessage);
	}
	
	public String getCurrentPageUrl()
	{
		return gl.getCurrentUrlOfPage(driver);
	}

}
