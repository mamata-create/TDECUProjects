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

public class TDB1333_VerifyAdvanceTransactionSearchModify extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB1333 - Verify Modify advance transaction search
	 */

	@BeforeTest
	public void setUp() {
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		getElement(ObjectRepository.username_txt).sendKeys(username);
		getElement(ObjectRepository.password_txt).sendKeys(password);
		test.log(Status.INFO, "Username and Password entered");
		getElement(ObjectRepository.login_btn).click();
		Assert.assertTrue(getElement(ObjectRepository.acnt_dshbrd).isDisplayed());
		test.log(Status.INFO, "User logged in successfully as account dashboard displayed");
	}

	@Test
	public void TDB1333_VerifyAdvanceTransactionSearchModify() throws InterruptedException {
		if (continuetestcase == true) {
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for (startIter = 1; startIter <= totalRowCount; startIter++) 
			{
				if (this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter))) {

					String acntNumber=excl.getCellData("Data", 1, startIter);
					String keyword=excl.getCellData("Data", 4, startIter);
					
					String acntnmbr_lastfive="x"+acntNumber;
					
		Thread.sleep(4000);
	WebElement childelement=getElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acntnmbr_lastfive+"')]");
	scrollToElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acntnmbr_lastfive+"')]");
	childelement.click();
	test.log(Status.INFO, "Account clicked to open account detail page");
	Thread.sleep(30000);
	
	scrollToElement(ObjectRepository.advncsrch);
	
	
	getElement(ObjectRepository.advncsrch).click();
	test.log(Status.INFO, "Advance search link clicked");
	Thread.sleep(2000);
	
	getElement(ObjectRepository.kywrdsrch).sendKeys(keyword);
	test.log(Status.INFO, "Keyword entered for searhcing");
	
	scrollToElement(ObjectRepository.srchbtn);
	
	getElement(ObjectRepository.srchbtn).click();
	test.log(Status.INFO, "Search button clicked");
	Thread.sleep(2000);
	
	scrollToElement(ObjectRepository.mdfysrchbtn);
	verifyElementPresent(ObjectRepository.mdfysrchbtn);
	test.log(Status.INFO, "Modify Search link appears after search applied");
	
	getElement(ObjectRepository.mdfysrchbtn).click();
	test.log(Status.INFO, "Modify Search link clicked");
	Thread.sleep(2000);
	scrollToElement(ObjectRepository.kywrdsrch);
	verifyElementPresent(ObjectRepository.kywrdsrch);
	
	test.log(Status.INFO, "Keyword Search criteria appears on clicking Modify Search link");
	Thread.sleep(4000);
				
					
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
			test.log(Status.PASS, "Verify Modify Advance Transaction Search  scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
