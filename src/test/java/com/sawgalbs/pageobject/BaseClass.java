package com.sawgalbs.pageobject;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
	public static WebDriver driver;
	static ExtentReports extent=new ExtentReports();
	static ExtentSparkReporter spark=new ExtentSparkReporter("target/Spark.html");
	
	
	@BeforeTest
	
	public static void openBrowser()
	{   
		
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
    
		
		
		driver.manage().window().maximize();
		
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Login Test Report ");
		
		
		driver.get("https://www.saucedemo.com/");
	}
	@AfterTest
	public static void closeBrowser() throws IOException
	   
	{  
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File src = screenshot.getScreenshotAs(OutputType.FILE);
				
		File dest = new File("C:\\Users\\CX-Dweep\\eclipse-workspace\\Selenium_Framework\\Screenshots\\fullsPage.png");
		
			
		//step3: copy image file to destination
				
		extent.flush();
		driver.close();
	}

}
