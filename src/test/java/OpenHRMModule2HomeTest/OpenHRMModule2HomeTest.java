package OpenHRMModule2HomeTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import OpenHRMModule1LoginPage.OpenHRMModule1LoginPage;
import OpenHRMModule2HomePage.OpenHRMModule2HomePage;

public class OpenHRMModule2HomeTest extends BaseClass
{


	int TestCaseID;
	OpenHRMModule1LoginPage login;
	OpenHRMModule2HomePage home;
	
	@BeforeClass
	public void openBroswer() throws IOException
	{
		
		openBrowser();
		login= new OpenHRMModule1LoginPage(driver);
		home= new OpenHRMModule2HomePage(driver);
		
	}
	
	@Test
	public void verificationofloginmodule() throws InterruptedException, IOException
	{
		TestCaseID=2;
		login.inpOpenHRMModule1LoginPageUsername(UtilityClass.getPropertyFileData("username"));
		login.inpOpenHRMModule1LoginPagePassword(UtilityClass.getPropertyFileData("password"));
		login.clikOpenHRMModule1LoginPageLoginButton();
		
		Thread.sleep(2000);
		Assert.assertTrue(home.verifyOpenHRMModule2HomePageOrangeHRMBanner());
		Assert.assertEquals(UtilityClass.getExcelData(1, 1), home.verifyOpenHRMModule2HomePageDashboardTitle());
		Assert.assertEquals(UtilityClass.getExcelData(2, 1), home.clickOpenHRMModule2HomePageAdminButton());
		
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