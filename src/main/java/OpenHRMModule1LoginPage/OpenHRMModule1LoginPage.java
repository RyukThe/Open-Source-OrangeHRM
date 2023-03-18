package OpenHRMModule1LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenHRMModule1LoginPage 
{
	@FindBy (xpath = "//input[@name='username']") private WebElement Username;
	@FindBy(xpath = "//input[@name='password']") private WebElement Password;
	@FindBy(xpath = "//button[@type='submit']") private WebElement Login;
	
	public OpenHRMModule1LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void inpOpenHRMModule1LoginPageUsername(String username)
	{
		Username.sendKeys(username);
	}
	
	public void inpOpenHRMModule1LoginPagePassword(String password)
	{
	
		Password.sendKeys(password);
	}

	public void clikOpenHRMModule1LoginPageLoginButton()
	{
		Login.click();
	}
}
