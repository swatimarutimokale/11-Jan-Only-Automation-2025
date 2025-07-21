package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter SparkReporter;  
	public ExtentReports extent;
	public ExtentTest test;  
	String ReportName;
	
	public void onStart(ITestContext T1) 
	{
		//Create Current Date WithTimeStamp
		
		SimpleDateFormat SD=new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss");
		Date dt=new Date();
		String CurrentDateTimeStamp=SD.format(dt);               //"yyyy.mm.dd.HH.mm.ss"
		
		//Create Report Name using Current Date WithTimeStamp
		ReportName="Test-Report-"+CurrentDateTimeStamp+".html";	
		
        //Mention Location and Name of Report in the constructor of ExtentSparkReporter Class
		SparkReporter=new ExtentSparkReporter(".\\Reports\\"+ReportName);
		
		//declare Title of the Report
        SparkReporter.config().setDocumentTitle("Qafox Automation Testing Report");
		
		//declare Name of the Report
		SparkReporter.config().setReportName("Regression Testing");
		
		//declare Theme for the Report
		SparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(SparkReporter);
		
		//Declare name of Application
		extent.setSystemInfo("Application", "Qafox");
		
		//Declare name of Module
		extent.setSystemInfo("Module", "Account");
		
	    //Declare name of Environment
		extent.setSystemInfo("Environment", "QA");
		
       //Identify which Browser is executed
        String BN=T1.getCurrentXmlTest().getParameter("browserName");  //Chrome
		extent.setSystemInfo("Browser", BN);
	}
	public void onTestSuccess(ITestResult Result) //Pass
	{
		
      //Getting Name of the class whose Test case is Passed an Store into test object
		test=extent.createTest(Result.getTestClass().getName());  //Qafox_Test_Class
		test.log(Status.PASS, Result.getName()+"  "+" Test case is Passed");  //VerifyAccountTextonPPF()
	
	}
		
	public void onTestFailure(ITestResult Result) //Fail
	{
		
       //Getting Name of the class whose Test case is failed an Store into test object
		test=extent.createTest(Result.getTestClass().getName());  //Qafox_Test_Class
		test.log(Status.FAIL, Result.getName()+" "+ " Test case is Failed");  //VerifyTitle()
	
	}
	
	public void onTestSkipped(ITestResult Result) //Skip
	{
		
      //Getting Name of the class whose Test case is Skipped an Store into test object
		test=extent.createTest(Result.getTestClass().getName());
		test.log(Status.SKIP, Result.getName()+"Test case is Skipped");  
	
	}
	
	public void onFinish(ITestContext T2) 
	{
		extent.flush();
	}
}
