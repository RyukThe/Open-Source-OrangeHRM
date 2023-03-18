package LibraryFiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass
{
	public ChromeOptions op;
	
	public WebDriver driver;
	
	public void openBrowser() throws IOException
	{
		op= new ChromeOptions();

		op.addArguments("--remote-allow-origins=*");
		driver=new  ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPropertyFileData("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
	
	
}
