package OpenHRMModule3AdminPage;

import java.util.List;

import org.openqa.selenium.By;
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
	@FindBy(xpath = "//input[@placeholder='Type for hints...']") private  WebElement enterEmployee_Name;
	@FindBy(xpath = "//div[@role='option']") private WebElement chooseEmp;
	@FindBy(xpath = "//label [text()='Status']") private WebElement statusLabel;
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]") private WebElement selectstatus;
	@FindBy(xpath = "//label[text()='Username']") private WebElement userNameLabel;
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]") private WebElement enterUserName;
	@FindBy(xpath = "//label[text()='Password']") private WebElement passwrodLabel;
	@FindBy(xpath = "(//input[@type='password'])[1]") private WebElement enterPassword;
	@FindBy(xpath = "//label[text()='Confirm Password']") private WebElement confirmPassLabel;
	@FindBy(xpath = "(//input[@type='password'])[2]") private WebElement enterconfirmPassword;
	@FindBy(xpath = "//button[text()=' Save ']") private WebElement saveButton;

	
	
	
	
	public OpenHRMModule3Admin_Add_UserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyOpenHRMModule3Admin_Add_UserPageAdminTitile()
	{
		String ActResult = AdminTitle.getText();
		return ActResult;
	}
	
	public String verifyOpenHRMModule3Admin_Add_UserPageAddUserLabel()
	{
		String actResult = AddUserLabel.getText();
		return actResult;
	}
	
	
	
	public WebElement SelectOpenHRMModule3Admin_Add_UserPageUserRole()
	{
		return SelectUserRole;
	}
	 
	public String verifyOpenHRMModule3Admin_Add_UserPageEmplyoeeNameLabel()
	{
		String actResult = Employee_NameLabel.getText();
	
		return actResult;
	}
	 
	public void inpOpenHRMModule3Admin_Add_UserPageEmpName(String empname)
	{
		enterEmployee_Name.sendKeys(empname);
	}
	
	public void chooseOpenHRMModule3Admin_Add_UserPageEmpName(WebDriver driver, String EmpName)
	{
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']"));
		
		for(WebElement option:options)
		{
			if( EmpName.equals(option.getText()))		
			{
				option.click();

			}
		}
	}

	public String verifyOpenHRMModule3Admin_Add_UserPageStatusLabel()
	{
		String actResult = statusLabel.getText();
		return actResult;
	}
	
	public WebElement selectHRMModule3Admin_Add_UserPageStatus()
	{
		return selectstatus;
	}
	
	public String verifyOpenHRMModule3Admin_Add_UserPageUsernameLabel()
	{
		String actResult = userNameLabel.getText();
		return actResult;
	}
	public void inpOpenHRMModule3Admin_Add_UserPageUserName(String UserName)
	{
		enterUserName.sendKeys(UserName);
	}
	
	public String verifyOpenHRMModule3Admin_Add_UserPagePasswordLabel()
	{
		String actResult = passwrodLabel.getText();
		return actResult;
	}
	public void inpOpenHRMModule3Admin_Add_UserPagePassword(String password)
	{
		enterPassword.sendKeys(password);
	}
	
	public String verifyOpenHRMModule3Admin_Add_UserPageConfirmPasswordLabel()
	{
		String actResult = confirmPassLabel.getText();
		return actResult;
	}
	public void inpOpenHRMModule3Admin_Add_UserPageConfirmPassword(String confirmPassword)
	{
		enterconfirmPassword.sendKeys(confirmPassword);
	}
	
	

	public String clickOpenHRMModule3Admin_Add_UserPageSaveButton()
	{
		String actResult = saveButton.getText();
		saveButton.click();
		return actResult;
	}
	
	
}
