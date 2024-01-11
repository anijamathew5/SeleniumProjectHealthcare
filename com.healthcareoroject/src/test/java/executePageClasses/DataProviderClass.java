package executePageClasses;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelReadClass;

public class DataProviderClass {
  
  
  
  @DataProvider(name="unsuccessfulllogin")
  public Object[][] dp() throws IOException {
	    return new Object[][] {
	      new Object[] { ExcelReadClass.getStringdata(4,0),ExcelReadClass.getStringdata(3,1) },
	      new Object[] { ExcelReadClass.getStringdata(4,0),ExcelReadClass.getStringdata(4,1) },
	      new Object[] { ExcelReadClass.getStringdata(5,0),ExcelReadClass.getStringdata(5,1) }
	    };
  }
  
  @DataProvider(name="successfulllogin")
  public Object[][] dp1() throws IOException {
    return new Object[][] {
      new Object[] { ExcelReadClass.getStringdata(1,0),ExcelReadClass.getStringdata(1,1) }
    
      
    };
  }
  
  
  
  }

  
  
  

