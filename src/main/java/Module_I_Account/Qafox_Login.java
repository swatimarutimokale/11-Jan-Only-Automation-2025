package Module_I_Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qafox_Login {
	
	       //POM-II
	
//1. Instance variables/Data members should be declared  with access level private by using @Findby Annotation	

	@FindBy(xpath="//input[@name='email']")private WebElement Email;
	
	@FindBy(xpath="//input[@name='password']")private WebElement Pass;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")private WebElement LoginButton;
	
//2. Initialize within a constructor with access level public using PageFactory Class

	public Qafox_Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
//3. Utilize within a method with access level public
	
	public void EnterEmailAddress(String EM)                    //virajvelocity@gmail.com
	{
      Email.sendKeys(EM);                                       //virajvelocity@gmail.com
	}
	public void EnterPassword(String Password)                      //Velocity@1234
	{
		Pass.sendKeys(Password);                                     //Velocity@1234
	}

	public void LoginButton()
	{
		LoginButton.click();
	}
}
		
		


