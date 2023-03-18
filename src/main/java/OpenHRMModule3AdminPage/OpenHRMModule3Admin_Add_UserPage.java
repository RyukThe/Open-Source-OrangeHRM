package OpenHRMModule3AdminPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenHRMModule3Admin_Add_UserPage
{
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']") private WebElement AdminTitle;
	@FindBy(xpath = "//h6[contains(@class,'oxd-text oxd-text--h6 or')]") private WebElement AddUserLabel;
	@FindBy(xpath ="//label[text()='User Role']") private  WebElement User_RoleLabel;
	@FindBy(xpath = "//div[text()='-- Select --']") private WebElement SelectUserRole;
	@FindBy(xpath = "//label[text()='Employee Name']") private WebElement Employee_NameLabel;

	
	
	
	
	public OpenHRMModule3Admin_Add_UserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void SelectOpenHRMModule3Admin_Add_UserPageUserRole()
	{
		SelectUserRole.click();
	}

}
