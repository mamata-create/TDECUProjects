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

public class VerifyUserEnroll extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify User Enroll
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
	public void VerifyUserEnroll() throws InterruptedException {
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
					getElement(ObjectRepository.highlightacnt_opt).click();
					test.log(Status.INFO, "Highlighted account selected");
					
					getElement(ObjectRepository.next_btn).click();
					test.log(Status.INFO, "Next button clicked");
					Thread.sleep(2000);
					
					scrollToElement(ObjectRepository.levelupchecking_tnc);
					getElement(ObjectRepository.levelupchecking_tnc).click();
					test.log(Status.INFO, "Level Up checking TnC clicked");
					
					getElement(ObjectRepository.electronic_tnc).click();
					test.log(Status.INFO,"Electronic Delivery TnC clicked");
					
					getElement(ObjectRepository.nextagree_btn).click();
					test.log(Status.INFO, "Next button clicked");
					Thread.sleep(2000);
					
					verifyElementPresent(ObjectRepository.summary_ttl);
					test.log(Status.INFO, "Levelup summary page appeared");
					
					getElement(ObjectRepository.submit_btn).click();
					test.log(Status.INFO, "Submit button clicked");
					Thread.sleep(2000);
					
					scrollToElement(ObjectRepository.congrat_msg);
					verifyElementPresent(ObjectRepository.congrat_msg);
					test.log(Status.INFO, "Congratulcations message appeared");
					
					getElement(ObjectRepository.clickhere_lnk).click();
					test.log(Status.INFO, "Click here button clicked");
					Thread.sleep(2000);
					//New code addded
					driver.get(url);
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
			test.log(Status.PASS, "Verify User Enroll scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}