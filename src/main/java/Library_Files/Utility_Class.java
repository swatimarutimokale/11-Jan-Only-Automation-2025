package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility_Class {
	
	     //@Automation Test Engineer=Swati
		//Date:09/06/2025 
		//Day: Monday
		//Objective: Fetch data from Property file
	
	public static String getDatafromPF(String key) throws IOException
	{
			//Reach upto Property file
	FileInputStream file=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\11_Jan_Only_Automation_2025\\PropertyFile.properties");
		
		//Create Object of Properties Class
			Properties Prop=new Properties();
		
			//To open Property File
			Prop.load(file);
			
			//To Fetch Value from Property file
	String value1=Prop.getProperty(key);  //EmailAddress    virajvelocity@gmail.com 	
			return value1; 
			
		}
		
		
            //@Automation Test Engineer=Swati
			//Date:08/06/2025 
			//Day: Sunday
			//Objective: Fetch data from Excelsheet

	public static String getDatafromExcelsheet(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException
	{
			
	FileInputStream file=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\11_Jan_Only_Automation_2025\\Test_Data\\11_Jan_Only_Automation.xlsx");	
		Sheet S1=WorkbookFactory.create(file).getSheet("Sheet11");                                            
	String Value2=S1.getRow(RowIndex).getCell(CellIndex).getStringCellValue();   //My Account
			return Value2;      //My Account
	}
		
		
				//@Automation Test Engineer=Swati
				//Date:08/06/2025 
				//Day: Sunday
				//Objective: Capture Screenshots of failed Test Cases 
	
	public static void CaptureScreenshot(WebDriver driver,String TestCaseID) throws IOException
	{
			//DownCasting/TypeCasting/Convert
		
	File  Source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
	File Destination=new File("C:\\Users\\DELL\\eclipse-workspace\\11_Jan_Only_Automation_2025\\Screenshot\\"+TestCaseID+".jpg");
			FileHandler.copy(Source,Destination);   
	}
}
	
	  
