package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass{
	
	PomLogin Log;
	
	public LoginTest() {
		super();
	}

  @BeforeMethod
  public void initsetup() {
	  initiation();
	  screenshots("Login");
	  Log = new PomLogin();
  }
  
 @Test(priority=1)
 public void Title() {
	String actual= Log.verify();
	System.out.println(actual);
	 Assert.assertEquals(actual, "OrangeHRM");
	
 }
 
 @DataProvider
 public Object[][] Details(){
	 Object result[][]=ExcelSheet.readdata("Sheet1");
	 return(result);
 }
 
 @Test(priority=2,dataProvider="Details")
 public void Login(String name,String Password) throws InterruptedException {
	 Thread.sleep(2000);
	 Log.typename("name");
	
	 Log.typepassword("Password");
	 //Log.clickbtn();
	 
 }
  
	
	  @AfterMethod
	  public void close()
	  {
		  driver.close(); }
	  
	 
   
}
