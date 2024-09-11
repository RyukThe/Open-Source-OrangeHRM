package OpenHRMModule3AdminTest;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.streaming.RowGeneratorFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.reporter.configuration.Theme;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import OpenHRMModule1LoginPage.OpenHRMModule1LoginPage;
import OpenHRMModule2HomePage.OpenHRMModule2HomePage;
import OpenHRMModule3AdminPage.OpenHRMModule3AdminPage;
import OpenHRMModule3AdminPage.OpenHRMModule3Admin_Add_UserPage;

public class ValidationOfNewUserCreated  extends BaseClass
{
	OpenHRMModule2HomePage home;
	OpenHRMModule1LoginPage login;
	OpenHRMModule3AdminPage admin;
	OpenHRMModule3Admin_Add_UserPage adduser;
	int testCaseID;
	SoftAssert soft;
	
	@BeforeClass
	public void intializeBrowser() throws IOException
	{
		openBrowser();
		logger.info("**************Browser Open***************");
		home= new OpenHRMModule2HomePage(driver);
		login = new OpenHRMModule1LoginPage(driver);
		admin= new OpenHRMModule3AdminPage(driver);
		adduser= new OpenHRMModule3Admin_Add_UserPage(driver);
		soft= new SoftAssert();
		
	}
	
	@BeforeMethod
	public void loginIntoApp() throws IOException
	{
		logger.info("**************Login into Application***************");
		login.inpOpenHRMModule1LoginPageUsername(UtilityClass.getPropertyFileData("username"));
		login.inpOpenHRMModule1LoginPagePassword( UtilityClass.getPropertyFileData("password"));
		login.clikOpenHRMModule1LoginPageLoginButton();
		soft.assertTrue(home.verifyOpenHRMModule2HomePageOrangeHRMBanner());
		soft.assertAll();
	
	}
	
	
	@Test
	public void Validation_Of_NewUser_Created() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger.info("**************Test Case Execution Started***************");
		home.clickOpenHRMModule2HomePageAdminButton();
	

		soft.assertEquals(UtilityClass.getExcelData(3, 1),admin.verifyOpenHRMModule3AdminPageTitleOfAdminPage());
		logger.info("************** Verify Title Admin/management  Page ***************");
		soft.assertEquals(UtilityClass.getExcelData(4, 1), admin.clickOpenHRMModule3AdminPageAddButton());
		logger.info("************** Verify  text  and click on add button  ***************");
		soft.assertEquals(UtilityClass.getExcelData(5, 1),adduser.verifyOpenHRMModule3Admin_Add_UserPageAdminTitile());
		logger.info("************** Verify Title of Amin title ***************");
		soft.assertEquals(UtilityClass.getExcelData(6, 1), adduser.verifyOpenHRMModule3Admin_Add_UserPageAddUserLabel());
		logger.info("************** Verify label of Add user ***************");
		adduser.updatedclickonUserRole();
		logger.info("************** click on User  Role ***************");
		adduser.updatedChooseRole(driver, UtilityClass.getExcelData(18, 2));
		logger.info("************** select  Role ***************");
		adduser.inpOpenHRMModule3Admin_Add_UserPageEmpName(UtilityClass.getExcelData(9, 1));
		logger.info("************** Employee Name entered ***************");
		Thread.sleep(2000);
		adduser.chooseOpenHRMModule3Admin_Add_UserPageEmpName(driver, UtilityClass.getExcelData(9, 1));
		logger.info("**************   Employee Name is Selected  ***************");
		adduser.UpdatedClickOnStatus();
		logger.info("************** Click on Status ***************");
		adduser.updatedChooseStatus(driver, UtilityClass.getExcelData(19, 1));
		logger.info("************** Status  Selected ***************");
		adduser.inpOpenHRMModule3Admin_Add_UserPageUserName(UtilityClass.getExcelData(12, 1));
		logger.info("************** User Name Entered ***************");
		adduser.inpOpenHRMModule3Admin_Add_UserPagePassword(UtilityClass.getExcelData(14, 1));
		Thread.sleep(2000);
		logger.info("************** Password Entered ***************");
		adduser.inpOpenHRMModule3Admin_Add_UserPageConfirmPassword(UtilityClass.getExcelData(16, 1));
		
		logger.info("************** Confirm  Password Entered ***************");
		Thread.sleep(2000);

		//click on save button
		soft.assertEquals(UtilityClass.getExcelData(17, 1), adduser.clickOpenHRMModule3Admin_Add_UserPageSaveButton());
		
		Thread.sleep(2000);

		logger.info("************** click on Save button ***************");
		Thread.sleep(2000);

	logger.info("************** verify success Message ***************");
	
	List<WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
		
	
	for(WebElement row:rows)
	{
		String str = row.getText();
		System.out.print(str);
	}
	
	soft.assertAll();
	}
	
	
	@AfterClass
	public void close ()
	{
		driver.close();
	}
	

}
