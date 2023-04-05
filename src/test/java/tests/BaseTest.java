package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utilities.ReadPropertyClass;

public class BaseTest {

	public  static WebDriver driver;
	String url1;
	
	@BeforeSuite
	public void inialization() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 

		 String path=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
			
		Properties  prop=new Properties();
		 
		FileInputStream fis =new FileInputStream(path);
		 
		
			prop.load(fis);
			
	
		
		 
		
			driver.get(prop.getProperty("url"));
		
		 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			
		
			
			
	}

	
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
