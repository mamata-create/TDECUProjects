package com.TestCases;

import org.openqa.selenium.By;
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

public class TDB1260_VerifyAccountRoles extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB1260 - Verify Account Roles
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
	public void TDB1260_VerifyAccountRoles() throws InterruptedException {
		if (continuetestcase == true) {
			sheetName = "AccountStatusCheck";
			int totalRowCount = excl.getRowCount(sheetName);
			for (startIter = 1; startIter <= totalRowCount; startIter++) 
			{
				if (this.getClass().getSimpleName().equals(excl.getCellData("AccountStatusCheck", 0, startIter))) {

					String acntNumber=excl.getCellData("AccountStatusCheck", 3, startIter);
					String acntownr=excl.getCellData("AccountStatusCheck", 6, startIter);
					String jntownr1=excl.getCellData("AccountStatusCheck", 7, startIter);
					String jntownr2=excl.getCellData("AccountStatusCheck", 8, startIter);
					String acntnmbr_lastfive="x"+acntNumber.substring(acntNumber.length()-5);
					
		Thread.sleep(4000);
	WebElement childelement=getElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acntnmbr_lastfive+"')]");
	scrollToElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acntnmbr_lastfive+"')]");
	childelement.click();
	test.log(Status.INFO, "Account clicked to open account detail page");
	Thread.sleep(6000);
	verifyElementPresent(ObjectRepository.viewAccInfolink);
				// Click on View Account Information link
					getElement(ObjectRepository.viewAccInfolink).click();
					test.log(Status.INFO, "View Account info link cliked");
					Thread.sleep(4000);
				
					
					WebElement acntownrEle=getElement("//div[@id='flxRoles_lblRoleTitle' and text()='Account Owner']/parent::*/parent::*");
					String act_acntownr=acntownrEle.findElement(By.xpath("//div[@id='flxRoles_rchtxtRolesValue']")).getText();
					Assert.assertTrue(act_acntownr.contains(acntownr));
					
					WebElement jntownrEle=getElement("//div[@id='flxRoles_lblRoleTitle' and text()='Joint Owner']/parent::*/parent::*");
					String act_jntownr=acntownrEle.findElement(By.xpath("//div[@id='flxRoles_rchtxtRolesValue']")).getText();
					Assert.assertTrue(act_jntownr.contains(jntownr1));
					Assert.assertTrue(act_jntownr.contains(jntownr2));
					
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
			test.log(Status.PASS, "Verify Account Roles scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
