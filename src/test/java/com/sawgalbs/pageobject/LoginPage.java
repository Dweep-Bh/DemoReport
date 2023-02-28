package com.sawgalbs.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static WebDriver driver;
	
	
	LoginPage(WebDriver d)
	{
		driver=d;
	}
	
	static By username= By.id("user-name");
	static By password= By.id("password");
	static By loginBtn= By.id("login-button");
	
	public static void enterUsername(String Uname)
	{
		driver.findElement(username).sendKeys(Uname);
	}
	
	public static void enterPassword(String Pwd)
	{
		driver.findElement(password).sendKeys(Pwd);
	}
	
	public static void clickOnLoginButton()
	{
		driver.findElement(loginBtn).click();
	}
	
	
}
