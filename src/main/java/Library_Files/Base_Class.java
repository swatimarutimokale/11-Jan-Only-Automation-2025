package Library_Files;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Module_I_Account.Qafox_Home;
import Module_I_Account.Qafox_Login;
import Module_I_Account.Qafox_MyAccount;

public class Base_Class {
	
	//Parent Class/Base Class/Super Class
	
		public WebDriver driver;
		public Qafox_Home P1;
		public Qafox_Login P2;
		public Qafox_MyAccount P3;
		public String TestCaseID;
		
		
		public Logger logger;
		
		@Parameters("browserName")  //Chrome
		
		@BeforeClass                     //Chrome
		public void OpenBrowser(String browserName) 
		{
	logger=LogManager.getLogger(this.getClass()) ;                      //Qafox_Test_Class
			   //Chrome
			if(browserName.equals("Chrome")) //true
			{
				driver=new ChromeDriver();
			}
		
		else if(browserName.equals("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else if(browserName.equals("Edge"))
			{
				driver=new EdgeDriver();
			}	
	driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
			driver.manage().window().maximize();
		}
		
		
		@BeforeMethod
		public void Login() throws IOException
		{
			//Create Object of POM-I
			P1=new Qafox_Home(driver);
			P1.ClickMyAccountDropdown();
			P1.ClickLoginOption();
			
			//Create Object of POM-II
			P2=new Qafox_Login(driver);
	P2.EnterEmailAddress(Utility_Class.getDatafromPF("EmailAddress"));  
	P2.EnterPassword(Utility_Class.getDatafromPF("Password"));         //Velocity@1234
			P2.LoginButton();
			
		}
		
		
		@AfterMethod
		public void Logout(ITestResult Result) throws IOException
		{
				//fail              //fail
			if(Result.getStatus()==Result.FAILURE)                //true
			{                                                     //TC102
				Utility_Class.CaptureScreenshot(driver, TestCaseID);
			}
			
			P3.ClickLogoutLink();
		}
		
		@AfterClass
		public void CloseBrowser() 
		{
			driver.close();
		}
}






















