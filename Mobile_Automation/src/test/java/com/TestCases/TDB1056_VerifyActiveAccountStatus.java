package com.TestCases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.FrameworkComponents.BaseClass;
import com.FrameworkComponents.ExtentManager;
import com.FrameworkComponents.GenericKeywords;
import com.FrameworkComponents.ObjectRepository;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TDB1056_VerifyActiveAccountStatus extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException{
		extent=ExtentManager.GetExtent();
		test=extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
	    iDriver.myTestCaseName = this.getClass().getSimpleName();
		startAppium();
		executeMobileDriver();
		test.log(Status.INFO, "Mobile application launched");
		getElement(ObjectRepository.username_txt).sendKeys(username);
		getElement(ObjectRepository.password_txt).sendKeys(password);
		getElement(ObjectRepository.login_btn).click();
		test.log(Status.INFO, "Login button clicked after entering username and password");
		getElement(ObjectRepository.continue_btn).click();
		test.log(Status.INFO, "Continue button clicked from device registration page");
	}
	
	/*
	 * Test Cases covered -- TDB-1056
	 */
	@Test
	public void TDB1056_VerifyActiveAccountStatus() throws InterruptedException{
		if(continuetestcase==true)
		{
			sheetName = "Beneficiary";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Beneficiary", 0, startIter)))
				{ 
					//read data from excel	
					String acntNumber=excl.getCellData("Beneficiary", 1, startIter);
					String nickname=excl.getCellData("Beneficiary", 3, startIter);
					String acntStatus=excl.getCellData("Beneficiary", 5, startIter);
		
				//Verify My Account dashboard 				
					verifyElementPresent(ObjectRepository.myaccount_ttl);
					test.log(Status.INFO, "Accounts dashboard opened");
					WebElement parentElement=getElement("//android.widget.TextView[contains(@text,'"+acntNumber+"')]/parent::*/parent::*");
					String actnickname=parentElement.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']")).getText();
				    System.out.println("Actual Nickname is-"+actnickname);
				
					Assert.assertTrue(actnickname.equals(nickname));
					
					parentElement.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']")).click();
					test.log(Status.INFO, "Accounts clicked to open account detail page");
					actnickname=getElement(ObjectRepository.nickname_ttl).getText();
					
					System.out.println("Account Detail screen nickname is -"+actnickname);
					
					getElement(ObjectRepository.info_btn).click();
					test.log(Status.INFO, "Account info icon clicked");
					Thread.sleep(3000);
					
					WebElement parentStatus=getElement("//android.widget.TextView[@text='Account Status']/parent::*");
					String actStatus=parentStatus.findElement(By.xpath("//android.widget.TextView[@index='1']")).getText();
					System.out.println("Actual Account Status is -"+actStatus);
					
					Assert.assertEquals(actStatus, acntStatus);
					test.log(Status.INFO, "Active Account Status verified successfully");
					
					
					
				}
			 }
		}
	}


	

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());		
		}else
		{
			test.log(Status.PASS, "Verify Active Account Status scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
