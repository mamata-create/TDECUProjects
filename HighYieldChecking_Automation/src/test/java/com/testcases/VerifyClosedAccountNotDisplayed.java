package com.testcases;

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

import junit.framework.Assert;

public class VerifyClosedAccountNotDisplayed extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify closed account not displayed
	 */

	@BeforeTest
	public void setUp() throws InterruptedException {
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		Thread.sleep(4000);
	}

	@Test
	public void VerifyClosedAccountNotDisplayed() throws InterruptedException {
		if (continuetestcase == true) {
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for (startIter = 1; startIter <= totalRowCount; startIter++) 
			{
				if (this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter))) {

					String membernumber = excl.getCellData(sheetName, 1, startIter);
					String last4ssn=excl.getCellData(sheetName, 2, startIter);
					String fname=excl.getCellData(sheetName, 3, startIter);
					String lname=excl.getCellData(sheetName, 4, startIter);
					String zipcode=excl.getCellData(sheetName,5, startIter);
					String clsacnt=excl.getCellData(sheetName,6, startIter);
					String openacnt=excl.getCellData(sheetName,7, startIter);
				

					scrollToElement(ObjectRepository.mmbrnumb_txt);
					getElement(ObjectRepository.mmbrnumb_txt).sendKeys(membernumber);
					test.log(Status.INFO, "Member Number entered");
					
					
					getElement(ObjectRepository.last4ssn_txt).sendKeys(last4ssn);
					test.log(Status.INFO, "Last 4 SSN digits entered");
					
					
					getElement(ObjectRepository.last4cnfrm_txt).sendKeys(last4ssn);
					test.log(Status.INFO, "Last 4 confirm SSN digits entered");
					
					getElement(ObjectRepository.firstname_txt).sendKeys(fname);
					test.log(Status.INFO, "First Name entered");
					
					getElement(ObjectRepository.lastname_txt).sendKeys(lname);
					test.log(Status.INFO, "LastName entered");
					
					
					getElement(ObjectRepository.zipcode_txt).sendKeys(zipcode);
					test.log(Status.INFO, "Zipcode entered");
					
					Thread.sleep(2000);
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					
					Thread.sleep(2000);
				//Page2
					verifyElementPresent(ObjectRepository.highlight_msg);
					String text=getElement(ObjectRepository.highlightacnt_opt).getText();
					Assert.assertFalse(text.contains(clsacnt));
					Assert.assertTrue(text.contains(openacnt));
					test.log(Status.INFO, "Closed account not available & Open account available");
					
					//New code addded
					//driver.get(url);
					
					
										
					
					}
			}
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify closed account not displayed scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}