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

public class TDB2053_VerifyFromAccountKeywordSearch  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB2053 - Verify From Account Keyword Search
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
	public void TDB2053_VerifyFromAccountKeywordSearch() throws InterruptedException
			{
					if(continuetestcase==true)
					{
						sheetName = "Data";
						int totalRowCount = excl.getRowCount(sheetName);
						for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
						 {	
							if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
							 {
								
								String frmAcnt=excl.getCellData("Data", 1, startIter);
								//Click Transfer Pay 				
								getElement(ObjectRepository.transferPay).click();
								test.log(Status.INFO, "Transfer tab clicked" );
							//Select Transfer Money 	
								getElement(ObjectRepository.transferMoney).click();
								test.log(Status.INFO, "Transfer money link clicked" );
								Thread.sleep(5000);
								verifyElementPresent(ObjectRepository.transferscreentitle);
								test.log(Status.INFO, "Transfer screen title is verified" );
							//Click Continue button for MYTDECU Accounts	
								getElement(ObjectRepository.continuebtn_MyTDECU).click();
								test.log(Status.INFO, "Continue button for MY TDECU account clicked" );
							//Select From Account	
								verifyElementPresent(ObjectRepository.fromacntdroparw);
								getElement(ObjectRepository.fromacntdroparw).click();
								test.log(Status.INFO, "From account dropdown opened" );
								getElement(ObjectRepository.frmsearchtxt).sendKeys(frmAcnt);
								getElement(ObjectRepository.frmsearchImg).click();
								test.log(Status.INFO, "Search icon clicked after entering account number" );
								Thread.sleep(3000);
								
								String searched=getElement(ObjectRepository.frmsearched).getText();
								System.out.println("Searched text-"+searched);
								Assert.assertTrue(searched.contains(".."+frmAcnt));
								test.log(Status.INFO, "From account searched correctly" );
								
								getElement(ObjectRepository.frmclearImg).click();
								test.log(Status.INFO, "Clear icon clicked" );
								String text=getElement(ObjectRepository.frmsearchtxt).getText();
								Assert.assertTrue(text.equals(""));
								test.log(Status.INFO, "Clicking clear icon clears the search text" );
								
								
							 }
						 }}
				}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify From Account Keyword Search scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
