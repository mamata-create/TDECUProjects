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

public class TDB135_VerifyAccountInfoOnAccountDetail extends GenericKeywords {

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
	 * Test Cases covered -- TDB-135
	 */
	@Test
	public void TDB135_VerifyAccountInfoOnAccountDetail() throws InterruptedException{
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
					String rtngNumber=excl.getCellData("Beneficiary", 6, startIter);
					
		
				//Verify My Account dashboard 				
					verifyElementPresent(ObjectRepository.myaccount_ttl);
					test.log(Status.INFO, "Accounts dashboard opened");
					
					scrollToElement("//android.widget.TextView[contains(@text,'"+acntNumber+"')]", 5);
					
					WebElement parentElement=getElement("//android.widget.TextView[contains(@text,'"+acntNumber+"')]/parent::*/parent::*");
					parentElement.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']")).click();
					test.log(Status.INFO, "Accounts clicked to open account detail page");
					Thread.sleep(5000);
									
					getElement(ObjectRepository.info_btn).click();
					test.log(Status.INFO, "Account info icon clicked");
					Thread.sleep(3000);
					
					WebElement parentStatus=getElement("//android.widget.TextView[@text='Account Number']/parent::*");
					parentStatus.findElement(By.xpath("//android.view.ViewGroup[@index='2']/android.widget.Button[@text='Show']")).click();
					String actNumber=parentStatus.findElement(By.xpath("//android.widget.TextView[@index='1']")).getText();
					System.out.println("Actual Account Number is -"+actNumber);
					
					Assert.assertTrue(actNumber.contains(acntStatus));
					test.log(Status.INFO, "Account number verified successfully");
					
					WebElement parentStatus2=getElement("//android.widget.TextView[@text='Routing Number']/parent::*");
					parentStatus2.findElement(By.xpath("//android.view.ViewGroup[@index='2']/android.widget.Button[@text='Show']")).click();
					String actRoutingNumber=parentStatus2.findElement(By.xpath("//android.widget.TextView[@index='1']")).getText();
					
					Assert.assertTrue(actRoutingNumber.contains(rtngNumber));
					test.log(Status.INFO, "Routing number verified successfully");
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
			test.log(Status.PASS, "Verify Account Info on Account Detail scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
