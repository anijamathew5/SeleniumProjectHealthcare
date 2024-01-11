package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	public void clickElement(WebElement element)
	{
		element.click();
	}
	public void typeElement(WebElement element,String text)
	{
		element.sendKeys(text);
	}
	
	public void clearElement(WebElement element)
	{
		element.clear();
	}
	public String getTextOfElement(WebElement element)
	{
		return element.getText();
	}
	public Boolean elementIsDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	public String getCurrentUrlOfPage(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	public String getTitleOfPage(WebDriver driver)
	{
		return driver.getTitle();
	}
	public void clickUsingJs(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void scrollToElement(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollInToView();",element);
	}
	public void toAcceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void toDismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public String toGetTextOfAlert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	public void typeElementAlert(WebElement element,String text)
	{
		element.sendKeys(text);
	}
	public void toSelectElementIndex(WebElement element,int index)
	{
		element.click();
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	
	
	

}
