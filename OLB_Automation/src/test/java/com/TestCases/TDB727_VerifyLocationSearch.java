package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class TDB727_VerifyLocationSearch  extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
/*
 * TDB-727
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
	public void TDB727_VerifyLocationSearch() throws InterruptedException{
		if(continuetestcase==true)
		{
			sheetName = "AccountStatusCheck";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("AccountStatusCheck", 0, startIter)))
				 {
					String loc=excl.getCellData("AccountStatusCheck", 4, startIter);
					
					scrollToElement(ObjectRepository.locateuslnk);
					test.log(Status.INFO, "Scrolled to locate us link" );
					
					getElement(ObjectRepository.locateuslnk).click();
					test.log(Status.INFO, "locate us link clicked" );
					
					Thread.sleep(2000);
					
					verifyElementPresent(ObjectRepository.locateusttl);
					test.log(Status.INFO, "locate us page displayed" );
					
					getElement(ObjectRepository.locfiltertxt).sendKeys(loc);
					test.log(Status.INFO, "Location entered" );
					
					getElement(ObjectRepository.locsearchimg).click();
					test.log(Status.INFO, "Search button clicked" );
					
					Thread.sleep(6000);
					
					String searchedloc=getElement(ObjectRepository.locsearched).getText();
					System.out.println("Searched location -"+searchedloc);
					Assert.assertTrue(searchedloc.contains(loc));
					
					getElement(ObjectRepository.locclrimg).click();
					test.log(Status.INFO, "Location clear image clicked" );
					
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
		test.log(Status.PASS, "Verify Location Search scenario working fine");
	}
}

	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
	}
	
	
}
