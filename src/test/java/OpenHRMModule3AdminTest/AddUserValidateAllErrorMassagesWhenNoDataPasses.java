package OpenHRMModule3AdminTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import OpenHRMModule1LoginPage.OpenHRMModule1LoginPage;
import OpenHRMModule2HomePage.OpenHRMModule2HomePage;
import OpenHRMModule3AdminPage.OpenHRMModule3AdminPage;
import OpenHRMModule3AdminPage.OpenHRMModule3Admin_Add_UserPage;

public class AddUserValidateAllErrorMassagesWhenNoDataPasses extends BaseClass
{
	int TestCaseId;
	OpenHRMModule1LoginPage login;
	OpenHRMModule2HomePage home;
	OpenHRMModule3AdminPage admin;
	OpenHRMModule3Admin_Add_UserPage adduser;
	SoftAssert soft;
	
	@BeforeClass
	public void openBroswer() throws IOException
	{
		
		openBrowser();
		login= new OpenHRMModule1LoginPage(driver);
		home= new OpenHRMModule2HomePage(driver);
		admin= new OpenHRMModule3AdminPage(driver);
		adduser = new OpenHRMModule3Admin_Add_UserPage(driver);
		soft= new SoftAssert();
		
	}
	
	@Test
	public void verifyAllErrorMessageWhenNoDataPassesByUser() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TestCaseId=7;

		Thread.sleep(2000);
		soft.assertTrue(home.verifyOpenHRMModule2HomePageOrangeHRMBanner());
		soft.assertEquals(UtilityClass.getExcelData(1, 1), home.verifyOpenHRMModule2HomePageDashboardTitle());
		soft.assertEquals(UtilityClass.getExcelData(2, 1), home.clickOpenHRMModule2HomePageAdminButton());
		Thread.sleep(2000);
		soft.assertEquals(UtilityClass.getExcelData(3, 1), admin.verifyOpenHRMModule3AdminPageTitleOfAdminPage());
		admin.clickOpenHRMModule3AdminPageAddButton();
		//click on save button
		soft.assertEquals(UtilityClass.getExcelData(17, 1), adduser.clickOpenHRMModule3Admin_Add_UserPageSaveButton());
		//verify label
		soft.assertEquals(UtilityClass.getExcelData(6, 1), adduser.verifyOpenHRMModule3Admin_Add_UserPageAddUserLabel());
		soft.assertEquals(UtilityClass.getExcelData(7, 1), adduser.VerifyOpenHRMModule3Admin_Add_UserPageUserRoleLabel());
		
		//verify all error messages generated 
		soft.assertEquals(UtilityClass.getExcelData("errorMsg", 0, 0), adduser.verifyErroMesageOpenHRMModule3Admin_Add_UserPageForNoDataPassesUserRole());
		soft.assertEquals(UtilityClass.getExcelData("errorMsg", 0, 1), adduser.verifyErroMesageOpenHRMModule3Admin_Add_UserPageForNoDataPassesempName());
		soft.assertEquals(UtilityClass.getExcelData("errorMsg", 0, 2), adduser.verifyErroMesageOpenHRMModule3Admin_Add_UserPageForNoDataPassesStatus());
		
		soft.assertEquals(UtilityClass.getExcelData("errorMsg", 0, 2), adduser.verifyErroMesageOpenHRMModule3Admin_Add_UserPageForNoDataPassesUserName());
		soft.assertEquals(UtilityClass.getExcelData("errorMsg", 0, 4), adduser.verifyErroMesageOpenHRMModule3Admin_Add_UserPageForNoDataPassesPassword());
		soft.assertEquals(UtilityClass.getExcelData("errorMsg", 0, 5), adduser.verifyErroMesageOpenHRMModule3Admin_Add_UserPageForNoDataPassesConfirmPassword());
		soft.assertAll();
		
		
		
	}
	
	@BeforeMethod
	public void loginIntoApp() throws IOException
	{
		login.inpOpenHRMModule1LoginPageUsername(UtilityClass.getPropertyFileData("username"));
		login.inpOpenHRMModule1LoginPagePassword(UtilityClass.getPropertyFileData("password"));
		login.clikOpenHRMModule1LoginPageLoginButton();
	}
	
	@AfterMethod
	public void catptureSSoffailedTestCase(ITestResult Result) throws IOException
	{
		
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.getScrenshot(driver, TestCaseId);
		}
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
