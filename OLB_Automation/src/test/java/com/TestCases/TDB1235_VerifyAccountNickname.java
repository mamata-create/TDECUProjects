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

public class TDB1235_VerifyAccountNickname extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB1235 - Verify Account Nickname for displayed accounts
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
		Assert.assertTrue(getElement(ObjectRepository.acnt_dshbrd).isDisplayed());
		test.log(Status.INFO, "User logged in successfully as account dashboard displayed" );
	}
		
		@Test
		public void TDB1235_VerifyAccountNickname() throws InterruptedException
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
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				WebElement parentElement1 = (WebElement)executor.executeScript("return arguments[0].parentNode;", childelement);
				WebElement parentElement2 = (WebElement)executor.executeScript("return arguments[0].parentNode;", parentElement1);
				test.log(Status.INFO, "Fetch actual nickname against the account on dashboard" );
				WebElement parentEle=parentElement2.findElement(By.xpath("//div[@id='flxAccountListItem_lblAccountName']"));
				String actNickname=parentEle.getText();
					Assert.assertTrue(actNickname.equals(nickname));
					test.log(Status.INFO, "Correct nickname appearing on the account dashboard as expected" );
				
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
							test.log(Status.PASS, "Verify Account Nickname scenario working fine");
						}
					}
	
						@AfterTest
						public void tearDown()
						{
							extent.flush();
							driver.quit();
						}
						
						
					}


