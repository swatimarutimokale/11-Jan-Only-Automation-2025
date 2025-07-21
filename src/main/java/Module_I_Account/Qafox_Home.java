package Module_I_Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qafox_Home {
	
              //POM-I
	
//1. Instance variables/Data members should be declared  with access level private by using @Findby Annotation	

	@FindBy(xpath="//span[text()='My Account']")private WebElement MYAcc;             //driver.findElement(By.xpath("//span[text()='My Account']"));
	
	@FindBy(xpath="//a[text()='Login']")private WebElement LoginOpt;                  //driver.findElement(By.xpath("//a[text()='Login']"));
	
//2. Initialize within a constructor with access level public using PageFactory Class
	
	public Qafox_Home(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

//3. Utilize within a method with access level public	
	
	public void ClickMyAccountDropdown()
	{
		MYAcc.click();
	}
	public void ClickLoginOption()
	{
		LoginOpt.click();
	}
}
	
	
		
	
	
