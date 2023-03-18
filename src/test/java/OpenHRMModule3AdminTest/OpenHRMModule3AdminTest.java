package OpenHRMModule3AdminTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import OpenHRMModule1LoginPage.OpenHRMModule1LoginPage;
import OpenHRMModule2HomePage.OpenHRMModule2HomePage;
import OpenHRMModule3AdminPage.OpenHRMModule3AdminPage;

public class OpenHRMModule3AdminTest extends BaseClass
{
	int TestCaseID;
	OpenHRMModule1LoginPage login;
	OpenHRMModule2HomePage home;
	OpenHRMModule3AdminPage admin;
	
	@BeforeClass
	public void openBroswer() throws IOException
	{
		
		openBrowser();
		login= new OpenHRMModule1LoginPage(driver);
		home= new OpenHRMModule2HomePage(driver);
		admin= new OpenHRMModule3AdminPage(driver);
		
	}
	
	@BeforeMethod
	public void loginIntoApp() throws IOException
	{
		login.inpOpenHRMModule1LoginPageUsername(UtilityClass.getPropertyFileData("username"));
		login.inpOpenHRMModule1LoginPagePassword(UtilityClass.getPropertyFileData("password"));
		login.clikOpenHRMModule1LoginPageLoginButton();
	}
	@Test
	public void verificationofloginmodule() throws InterruptedException, IOException
	{
		TestCaseID=3;
		Thread.sleep(2000);
		Assert.assertTrue(home.verifyOpenHRMModule2HomePageOrangeHRMBanner());
		Assert.assertEquals(UtilityClass.getExcelData(1, 1), home.verifyOpenHRMModule2HomePageDashboardTitle());
		Assert.assertEquals(UtilityClass.getExcelData(2, 1), home.clickOpenHRMModule2HomePageAdminButton());
		Thread.sleep(2000);
		Assert.assertEquals(UtilityClass.getExcelData(3, 1), admin.verifyOpenHRMModule3AdminPageTitleOfAdminPage());
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void catptureSSoffailedTestCase(ITestResult Result) throws IOException
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.getScrenshot(driver, TestCaseID);
		}
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
}
