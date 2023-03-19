package OpenHRMModule3AdminPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenHRMModule3AdminPage
{
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']") private WebElement Admin_User_Management;
	@FindBy(xpath = "(//button[contains(@class,'oxd-button oxd-button--medium o')])[3]") private WebElement AddButton;
	public OpenHRMModule3AdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyOpenHRMModule3AdminPageTitleOfAdminPage()
	{
		String actResult = Admin_User_Management.getText();
		return actResult;
	}

	public String clickOpenHRMModule3AdminPageAddButton()
	{
		String actResult = AddButton.getText();
		AddButton.click();
		return actResult;
		
	}
}
