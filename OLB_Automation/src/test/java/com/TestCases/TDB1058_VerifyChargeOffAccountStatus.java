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

public class TDB1058_VerifyChargeOffAccountStatus extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * TD1058 - Verify ChargeOff Account Status Available
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
	public void TDB1058_VerifyChargeOffAccountStatus() throws InterruptedException
			{
					if(continuetestcase==true)
					{
						sheetName = "AccountStatusCheck";
						int totalRowCount = excl.getRowCount(sheetName);
						for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
						 {	
							if(this.getClass().getSimpleName().equals(excl.getCellData("AccountStatusCheck", 0, startIter)))
							 {
								
								String last4digit=excl.getCellData("AccountStatusCheck", 2, startIter);
								
								WebElement childelement=getElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+last4digit+"')]");
								
								scrollToElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+last4digit+"')]");
								test.log(Status.INFO, "scrolled to chargeOff account");
								childelement.click();
								Thread.sleep(30000);
								test.log(Status.INFO, "ChargeOff Account clicked");
								//Click on View Account Information link
								getElement(ObjectRepository.viewAccInfolink1).click();
								test.log(Status.INFO, "View Account Information link clicked");
								//Check for Account status
								verifyText(ObjectRepository.checkAccountStatus,"Chargeoff");
								test.log(Status.INFO, "ChargeOff Account Status Available");
								
							 }
						 }}
				}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify ChargeOff Account Status scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
