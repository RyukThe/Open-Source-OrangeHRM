package OpenHRMModule2HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenHRMModule2HomePage
{
	@FindBy(xpath = "//img[@alt='client brand banner']") private WebElement OrangeHRMBanner;
	@FindBy(xpath = "//h6[text()='Dashboard']") private WebElement DashboardTitle;
	@FindBy(xpath = "//span[text()='Admin']") private WebElement Admin;
	public OpenHRMModule2HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyOpenHRMModule2HomePageOrangeHRMBanner() 
	{
		boolean actualResult = OrangeHRMBanner.isDisplayed();
		return actualResult;
		
	}
	
	
	public String verifyOpenHRMModule2HomePageDashboardTitle()
	{
		String actualResult = DashboardTitle.getText();
		return actualResult;
	}
	
	public String clickOpenHRMModule2HomePageAdminButton()
	{
		String actualResult = Admin.getText();
		Admin.click();
		return actualResult;
	}
	
}
