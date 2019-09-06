package com.TestCases;

import org.openqa.selenium.By;
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

public class TDB1233_VerifyAccountsInAccountDashboard extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
/*
 * TDB-1233
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
	public void TDB1233_VerifyAccountsInAccountDashboard() throws InterruptedException{
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					String frmAcnt=excl.getCellData("Data", 1, startIter);
					String[] allacnts=frmAcnt.split(",");
					for(int i=0;i<allacnts.length;i++){
						String acnt=allacnts[i];
						WebElement childelement=getElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acnt+"')]");
						scrollToElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acnt+"')]");
						test.log(Status.INFO, "Scroll to account number - "+acnt );
						verifyElementPresent("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acnt+"')]");
						test.log(Status.INFO, "Verified account number - "+acnt );
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
		test.log(Status.PASS, "Verify Accounts in Account Dashboard scenario working fine");
	}
}

	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
	}
	
	
}
