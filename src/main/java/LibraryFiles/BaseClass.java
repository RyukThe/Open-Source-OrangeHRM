package LibraryFiles;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; //use this 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseClass
{
	public ChromeOptions op;
	public Logger logger;
	public static WebDriver driver;
	
	public void openBrowser() throws IOException
	{
		op= new ChromeOptions();

		op.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPropertyFileData("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger=  LogManager.getLogger(this.getClass());
		logger.debug("debuggin.....");
	}


	public void openBrowser(String BrowserName) throws IOException
	{
		if(BrowserName.equals("chrome"))
		{
			op=  new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver= new ChromeDriver(op);
		}
		else if (BrowserName.equals("edge"))
		{
			driver= new EdgeDriver();
		}
		else if(BrowserName.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPropertyFileData("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public String takeScreenshot(String TestName,WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timesatmp= new SimpleDateFormat("yyyy.MM.HH.mm.ss").format(new Date());
		File des= new File("D:\\eclipse\\Opensource-OrangeHRM\\FailedTestCasesSS\\"+TestName+timesatmp+".png");
		FileHandler.copy(src, des);
		return des.getAbsolutePath();
	}



	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
	
		File source =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
