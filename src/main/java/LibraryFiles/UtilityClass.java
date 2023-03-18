package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{
		
		//This method is used to fetch data from excel sheet.
		// User Have to pass two input 1st: Row Index. 2nd: Cell Index
		//Author: Saurav Kasture
		public static String getExcelData(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
		{
			FileInputStream file= new FileInputStream("D:\\eclipse\\Opensource-OrangeHRM\\TestData\\OpenHRM.xlsx");
			
			String TestData = WorkbookFactory.create(file).getSheet("Sheet1").getRow(rowIndex).getCell(cellIndex).getStringCellValue();
			
			return TestData;
		}
		
		
		//This Method is used to Fetch data from excel sheet.
		// User Have to Pass 3 Input 1st String Sheet Name, 2nd Row Index, 3rd Cell Index.
		//Author: Saurav kasture
		public static String getExcelData(String sheetName,int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
		{
			FileInputStream file= new FileInputStream("D:\\eclipse\\Opensource-OrangeHRM\\TestData\\OpenHRM.xlsx");
			String TestData = WorkbookFactory.create(file).getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
			return TestData;
		}
		
		//This method is used to fecth data from property file.
		//User Have to Pass String key As a input.
		//Author: Saurav Kasture 
		public static String getPropertyFileData(String key) throws IOException
		{
			FileInputStream file=new  FileInputStream("D:\\eclipse\\Opensource-OrangeHRM\\OrangeHRM.properties");
			Properties property= new Properties();
			property.load(file);
			String value = property.getProperty(key);
			return value;
		
		}
		
		//This method is used to take ScreenShot of webpage 
		//User Have to pass 2 inputs 1st. driver, 2nd TestCaseId.
		//Author: Saurav Kasture
		public static void getScrenshot(WebDriver driver,int TestCaseId) throws IOException
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			File des= new File("D:\\eclipse\\Opensource-OrangeHRM\\FailedTestCasesSS\\HRMTestCaseId"+TestCaseId+".png");
			FileHandler.copy(src, des);
		}
		
		//This method is used to take SceernShot of perticalur WebElement
		//User Have to pass two inputs 1st webElement 2nd String Element Name
		//Author: Saurav Kasture
	/*	public static void takeSSofElement( WebElement element, String ElementName) throws IOException
		{
			File src = element.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("D:\\eclipse\\LivingLiquidz\\SSofPerticularWebElemnt\\"+ElementName+".png"));
			
		}
		*/
		
		
		
	}


