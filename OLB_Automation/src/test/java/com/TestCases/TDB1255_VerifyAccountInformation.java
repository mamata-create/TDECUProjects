package com.TestCases;

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

public class TDB1255_VerifyAccountInformation extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB1255 -Verify Account Information
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
		// Assert.assertTrue(getElement(ObjectRepository.acnt_dshbrd).isDisplayed());
		test.log(Status.INFO, "User logged in successfully as account dashboard displayed");
	}

	@Test
	public void VerifyAccountInformation() throws InterruptedException {
		if (continuetestcase == true) {
			sheetName = "AccountStatusCheck";
			int totalRowCount = excl.getRowCount(sheetName);
			for (startIter = 1; startIter <= totalRowCount; startIter++) // It
																			// is
																			// mandatory
																			// to
																			// have
																			// this
																			// for
																			// loop
																			// in
																			// every
																			// test
																			// case
			{
				if (this.getClass().getSimpleName().equals(excl.getCellData("AccountStatusCheck", 0, startIter))) {

					String accstatus = excl.getCellData("AccountStatusCheck", 1, startIter);

					// Click on Dormant account type
					getElement(ObjectRepository.dormantaccount).click();
					// Click on View Account Information link
					getElement(ObjectRepository.viewAccInfolink).click();
					// Check for Account status
					verifyText(ObjectRepository.checkEncAccoutnNumber, accstatus);

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
			test.log(Status.PASS, "Äccount Information scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
