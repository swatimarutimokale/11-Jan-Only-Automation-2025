package Module_I_Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qafox_MyAccount {
	
	//POM-III
	
//1. Instance variables/Data members should be declared  with access level private by using @Findby Annotation		

	@FindBy(xpath="//a[text()='Account']") private WebElement Acc;                  //driver.findElement(By.xpath("//a[text()='Account']"));
	
	@FindBy(xpath="(//a[text()='Logout'])[2]") private WebElement Logout;           //driver.findElement(By.xpath("(//a[text()='Logout'])[2]"));

//2. Initialize within a constructor with access level public using PageFactory Class	

	public Qafox_MyAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//3. Utilize within a method with access level public	
	
	public String getTextofPPF()
	{
		String AR=Acc.getText();
		return AR;
	}
	public void ClickLogoutLink() 
	{
		Logout.click();
	}
}
