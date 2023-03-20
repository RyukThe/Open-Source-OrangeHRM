package OpenHRMModule3AdminTest;

import java.io.IOException;

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

public class AddUserTest3 extends BaseClass
{
	int TestCaseID;
	OpenHRMModule1LoginPage login;
	OpenHRMModule2HomePage home;
	OpenHRMModule3AdminPage admin;
	OpenHRMModule3Admin_Add_UserPage addUser;
	SoftAssert soft;
	
	@BeforeClass
	public void openBroswer() throws IOException
	{
		
		openBrowser();
		login= new OpenHRMModule1LoginPage(driver);
		home= new OpenHRMModule2HomePage(driver);
		admin= new OpenHRMModule3AdminPage(driver);
		addUser = new OpenHRMModule3Admin_Add_UserPage(driver);
		soft= new SoftAssert();
		
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
		TestCaseID=6;
		Thread.sleep(2000);
		soft.assertTrue(home.verifyOpenHRMModule2HomePageOrangeHRMBanner());
		soft.assertEquals(UtilityClass.getExcelData(1, 1), home.verifyOpenHRMModule2HomePageDashboardTitle());
		soft.assertEquals(UtilityClass.getExcelData(2, 1), home.clickOpenHRMModule2HomePageAdminButton());
		
		Thread.sleep(2000);
		soft.assertEquals(UtilityClass.getExcelData(3, 1), admin.verifyOpenHRMModule3AdminPageTitleOfAdminPage());
		//click on Add button
		admin.clickOpenHRMModule3AdminPageAddButton();
		// verify Add user label
		soft.assertEquals(UtilityClass.getExcelData(6, 1), addUser.verifyOpenHRMModule3Admin_Add_UserPageAddUserLabel());
		// verify user role Label
		soft.assertEquals(UtilityClass.getExcelData(7, 1), addUser.VerifyOpenHRMModule3Admin_Add_UserPageUserRoleLabel());
		//click on User Role
		addUser.updatedclickonUserRole(); //
		Thread.sleep(2000);
		//select role as Admin
		addUser.updatedChooseRole(driver, UtilityClass.getExcelData(18, 1));
		
		// verify Employee Name Label
		soft.assertEquals(UtilityClass.getExcelData(8, 1), addUser.verifyOpenHRMModule3Admin_Add_UserPageEmplyoeeNameLabel());
		//enter user
		addUser.inpOpenHRMModule3Admin_Add_UserPageEmpName(UtilityClass.getExcelData(9, 1));
		Thread.sleep(2000);
		//select Employee name from list
		addUser.chooseOpenHRMModule3Admin_Add_UserPageEmpName(driver, UtilityClass.getExcelData(9, 1));
		//verify status label
		soft.assertEquals(UtilityClass.getExcelData(10, 1), addUser.verifyOpenHRMModule3Admin_Add_UserPageStatusLabel());
		// click on status
		addUser.UpdatedClickOnStatus();  
		Thread.sleep(2000);
		//select status
		addUser.updatedChooseStatus(driver, UtilityClass.getExcelData(19, 1));
		// verify user name label
		soft.assertEquals(UtilityClass.getExcelData(11, 1), addUser.verifyOpenHRMModule3Admin_Add_UserPageUsernameLabel());
		//enter user name
		addUser.inpOpenHRMModule3Admin_Add_UserPageUserName(UtilityClass.getExcelData(12, 1));
		// verify password label
		soft.assertEquals(UtilityClass.getExcelData(13, 1), addUser.verifyOpenHRMModule3Admin_Add_UserPagePasswordLabel());
		// enter password 
		addUser.inpOpenHRMModule3Admin_Add_UserPagePassword(UtilityClass.getExcelData(14, 1));
		
		Thread.sleep(500);
		// verify confirm password 
		soft.assertEquals(UtilityClass.getExcelData(15, 1), addUser.verifyOpenHRMModule3Admin_Add_UserPageConfirmPasswordLabel());
	
		// enter confirm password 
		addUser.inpOpenHRMModule3Admin_Add_UserPageConfirmPassword(UtilityClass.getExcelData(16, 1));
		Thread.sleep(500);
		
		//click on save button
		soft.assertEquals(UtilityClass.getExcelData(17, 1), addUser.clickOpenHRMModule3Admin_Add_UserPageSaveButton());
		
		Thread.sleep(5000);
		soft.assertAll();
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