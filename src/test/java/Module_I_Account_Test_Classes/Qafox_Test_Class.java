package Module_I_Account_Test_Classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Library_Files.Base_Class;
import Library_Files.Utility_Class;
import Module_I_Account.Qafox_MyAccount;

public class Qafox_Test_Class extends Base_Class 
{
	//Child Class/SubClass

		//public WebDriver driver;
		//Qafox_Home P1;
		//Qafox_Login P2;
		//Qafox_MyAccount P3;
		
		//@BeforeClass
		//@BeforeMethod
		//@AfterMethod
		//@AfterClass

	@Test
	public void VerifyAccountTextonPPF() throws EncryptedDocumentException, IOException
	{
		logger.info("TC101 is started");
		TestCaseID="TC101";
		
		//Create Object of POM-III
		P3=new Qafox_MyAccount(driver);
	
	String ActualResult=P3.getTextofPPF();  //Account
		logger.info("Actual Result is featched from App");
		
    String ExpectedResult=Utility_Class.getDatafromExcelsheet(0, 0);  ///Account1
		logger.info("Expected Result is featched from Excelsheet");
		
		Assert.assertEquals(ActualResult, ExpectedResult);  //Pass
		logger.info("TC101 is Passed");
	}
	
	@Test
public void VerifyTitle() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("TC102 is started");
		TestCaseID="TC102";
		
		Thread.sleep(2000);
		P3=new Qafox_MyAccount(driver);
		
		String	ActualTitle=driver.getTitle();  //My Account
		logger.info("Actual Title is featched from App");
		
        String ExpectedTitle=Utility_Class.getDatafromExcelsheet(1, 0);  //My Account1
		logger.info("Expected Title is featched from Excelsheet");
		
		Assert.assertEquals(ActualTitle,ExpectedTitle);  //Pass
		logger.info("TC102 is Passed");
	}
	
	
}
































		




