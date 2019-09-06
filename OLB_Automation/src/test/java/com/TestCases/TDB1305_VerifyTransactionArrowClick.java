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

public class TDB1305_VerifyTransactionArrowClick extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
/*
 * TDB-1305 - Verify transaction arrow click
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
	public void TDB1305_VerifyTransactionArrowClick() throws InterruptedException{
		if(continuetestcase==true)
		{
			sheetName = "AccountStatusCheck";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("AccountStatusCheck", 0, startIter)))
				 {
					String acntNumber=excl.getCellData("AccountStatusCheck", 3, startIter);
					String acntnmbr_lastfive="x"+acntNumber.substring(acntNumber.length()-5);
					
					WebElement childelement=getElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acntnmbr_lastfive+"')]");
					scrollToElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acntnmbr_lastfive+"')]");
					childelement.click();
					test.log(Status.INFO, "Account clicked to open account detail page");
					Thread.sleep(6000);
					verifyElementPresent(ObjectRepository.viewAccInfolink);
					
					scrollToElement("//div[@id='flxSegTransactionRowSavings_flxDropdown']");
					test.log(Status.INFO, "Scrolled to transaction arrow");
					
					getElement("//div[@id='flxSegTransactionRowSavings_flxDropdown']").click();
					test.log(Status.INFO, "Transaction arrow clicked");
					Thread.sleep(3000);
					
					verifyElementPresent("//div[@id='flxSegWithdrawTransactionSelected_lblTransactionTypeHeader' and text()='Reference Number']");
					test.log(Status.INFO, "Transaction detail appears on clicking transaction arrow");
//	
//		getElement("//div[contains(@class,'UnSelected')]/input[contains(@aria-label,'Posted')]").click();
//		Thread.sleep(8000);
//		WebElement ele=driver.findElement(By.xpath("//div[contains(text(),'3.00')]/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*"));
//		//WebElement ele=driver.findElement(By.xpath("//div[contains(text(),'787') and contains(@id,'AccountHolder')]"));
//		//WebElement ele =driver.findElement(By.xpath("//div[contains(text(),'446344-787')]/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*"));
//		System.out.println("Element index is-"+ele.getAttribute("index"));
//		String ind=ele.getAttribute("index");
//		driver.findElement(By.xpath("//li[@index='"+ind+"']//div[@id='flxExternalAccountsTransfersUnselected_flxDropdown']")).click();
//		Thread.sleep(8000);
		
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
		test.log(Status.PASS, "Onetime My TDECU account transfer scenario working fine");
	}
}

	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
	}
	
	
}
