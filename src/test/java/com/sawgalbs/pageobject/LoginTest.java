package com.sawgalbs.pageobject;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginTest extends BaseClass {
	ExtentTest test;
	@Test
	public void loginTest()
	
	{   
	
		 test=extent.createTest("Login Page test report").assignAuthor("Dweep Bhowmick")
		.assignCategory("Functional Test cases").assignDevice("Windows")
		.addScreenCaptureFromPath("target/Spark.html");
		test.pass("user successfully logged in");
		test.info("Login Test");
	
		LoginPage obj=new LoginPage(driver);
		LoginPage.enterUsername("standard_user");
		LoginPage.enterPassword("secret_sauce");
		LoginPage.clickOnLoginButton();
	}
	
	@AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getTestName());
        }
        else {
            test.log(Status.SKIP, result.getTestName());
        }
    }

}
