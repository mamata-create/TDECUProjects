package com.TestCases;

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

public class TDB1253_VerifyCreditCardNicknameLastFourDigit extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB1253 - Verify Credit Card Last Four Digit and nickname
	 */

	@BeforeTest
	public void setUp(){
		extent=ExtentManager.GetExtent();
		test=extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
	    iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated" );
		getElement(ObjectRepository.username_txt).sendKeys(username);
		getElement(ObjectRepository.password_txt).sendKeys(password);
		test.log(Status.INFO, "Username and Password entered" );
		getElement(ObjectRepository.login_btn).click();
		Assert.assertTrue(getElement(ObjectRepository.logout_lnk).isDisplayed());
		test.log(Status.INFO, "User logged in successfully" );
	}
	
	@Test
	public void TDB1253_VerifyCreditCardNicknameLastFourDigit() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "Beneficiary";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Beneficiary", 0, startIter)))
				 {
					String acntNumber=excl.getCellData("Beneficiary", 1, startIter);
					String nickname=excl.getCellData("Beneficiary", 3, startIter);
					
					
		Thread.sleep(4000);
	WebElement childelement=getElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acntNumber+"')]");
	scrollToElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acntNumber+"')]");
	String actText=childelement.getText();
	if(actText.contains("x"+acntNumber)){
		Assert.assertTrue(true);
		test.log(Status.INFO, "Credit Card last four digit appearing");
	}else{
		Assert.assertTrue(false);
	}
	
	String actnickname=getElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acntNumber+"')]/parent::*/parent::*").getText();
	System.out.println("Actual Nickname is ->"+actnickname);
	
	if(actnickname.contains(nickname)){
		Assert.assertTrue(true);
		test.log(Status.INFO, "Credit Card Nickname appearing");
	}else{
		Assert.assertTrue(false);
	}
	
				 }
			 }
		}
		
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());	
			takescreenshot(this.getClass().getSimpleName(),test);
		}else
		{
			test.log(Status.PASS, "Verify Credit Card Last four and nickname digit scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
		
	}
}
