package com.TestCases;

import org.openqa.selenium.JavascriptExecutor;
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

public class TDB1256_VerifyCreditCardInformation  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * TD1256 - Verify credit card information
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
				public void TDB1256_VerifyCreditCardInformation() throws InterruptedException
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
								String acntnmbr=excl.getCellData("AccountStatusCheck", 3, startIter);
								WebElement childelement=getElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+last4digit+"')]");
								
//								//Click on Non Accrual account type
//								JavascriptExecutor jse = (JavascriptExecutor)driver;
//								jse.executeScript("window.scrollBy(0,250)", "");
//								getElement(ObjectRepository.accrualaccount).click();
								scrollToElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+last4digit+"')]");
								test.log(Status.INFO, "scrolled to credit card account");
								childelement.click();
								Thread.sleep(30000);
								test.log(Status.INFO, "Credit Card Account clicked");
								//Click on View Account Information link
								getElement(ObjectRepository.viewAccInfolink1).click();
								test.log(Status.INFO, "View Account Information link clicked");
								//Check for Account status
								verifyText(ObjectRepository.cardnmbr,"xx"+last4digit);
								test.log(Status.INFO, "Card number verified");
								
							 }
						 }}
				}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Credit Card Information scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
