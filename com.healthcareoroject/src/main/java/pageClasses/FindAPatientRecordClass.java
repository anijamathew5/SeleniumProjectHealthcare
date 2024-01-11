package pageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class FindAPatientRecordClass {

	
		WebDriver driver;
		GeneralUtilities gl;
		
		public FindAPatientRecordClass(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements( driver,this);
		}
		
		@FindBy(xpath="//input[@class='form-control'])[1]")
		WebElement search;
		
		@FindBy(xpath="//table[@id='patient-search-results-table']//tr")
		List<WebElement> row;
		
		@FindBy(xpath="//table[@id='patient-search-results-table']//th")
		List<WebElement> column;
		
		public Boolean isPatientNameDisplayed(String name)
		{
			int rowCount = row.size();   
			int colCount = column.size();	
			System.out.println(rowCount+"  "+colCount);   
			
			boolean flag = false;
			
			for(int row = 1;row<rowCount;row++) {
				for(int col = 1;col<colCount;col++) {
					
					String actValue = driver.findElement(By.xpath("//table[@id='patient-search-results-table']//tr["+row+"]//td["+col+"]")).getText();
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
		public void clickSearchByPatient(String name)
		{
			gl.typeElement(search,name);
		}
		
		public String readStringData(int row,int column) throws IOException
		{
			return ExcelReadClass.getStringdata(row, column);
		}
		
		public String readIntegerData(int row,int column) throws IOException
		{
			return ExcelReadClass.getIntegerdata(row, column);
		}
		}

