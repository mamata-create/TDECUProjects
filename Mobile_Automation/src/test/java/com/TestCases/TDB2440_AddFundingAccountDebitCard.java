package com.TestCases;

import java.net.MalformedURLException;

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

public class TDB2440_AddFundingAccountDebitCard extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException{
		extent=ExtentManager.GetExtent();
		test=extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
	    iDriver.myTestCaseName = this.getClass().getSimpleName();
		startAppium();
		executeMobileDriver();
		test.log(Status.INFO, "Mobile application launched");
		getElement(ObjectRepository.username_txt).sendKeys(username);
		getElement(ObjectRepository.password_txt).sendKeys(password);
		getElement(ObjectRepository.login_btn).click();
		test.log(Status.INFO, "Login button clicked after entering username and password");
		getElement(ObjectRepository.continue_btn).click();
		test.log(Status.INFO, "Continue button clicked from device registration page");
	}
	
	/*
	 * Test Cases covered -- TDB-2440
	 */
	@Test
	public void TDB2440_AddFundingAccountDebitCard() throws InterruptedException{
		if(continuetestcase==true)
		{
			sheetName = "AddFundingAccount";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("AddFundingAccount", 0, startIter)))
				{
					String acntnickname=excl.getCellData("AddFundingAccount", 5, startIter);
					String state=excl.getCellData("AddFundingAccount", 6, startIter);
					String zip=excl.getCellData("AddFundingAccount", 7, startIter);
					String dbtcardnmbr=excl.getCellData("AddFundingAccount", 8, startIter);
					String nameoncard=excl.getCellData("AddFundingAccount", 9, startIter);
					String expmnth=excl.getCellData("AddFundingAccount", 10, startIter);
					String expyr=excl.getCellData("AddFundingAccount", 11, startIter);
					String cvv=excl.getCellData("AddFundingAccount", 12, startIter);
		
					//Verify My Account dashboard 				
					verifyElementPresent(ObjectRepository.myaccount_ttl);
					test.log(Status.INFO, "Accounts dashboard opened");
				//Click menu item option
					getElement(ObjectRepository.menuitem_lnk).click();
					test.log(Status.INFO, "Menu item clicked");
				//click Make a loan payment link	
					getElement(ObjectRepository.makeloanpaymnt_lnk).click();
					test.log(Status.INFO, "Make a loan payment clicked");
					
				//Click Add/Edit Accounts link
					getElement(ObjectRepository.addedtacnt_lnk).click();
					test.log(Status.INFO, "Add/Edit Accounts link clicked");

				//Click Add Funding Account link
					getElement(ObjectRepository.addfndgacnt_btn).click();
					test.log(Status.INFO, "Add Funding Account button clicked");
						
					verifyElementPresent(ObjectRepository.addfndgacnt_ttl);
					test.log(Status.INFO, "Add Funding Account page opened");
									
					verifyElementPresent(ObjectRepository.dbtcrd_opt);
					test.log(Status.INFO, "Add Funding Account- Debit Card option appearing");
					
				//Click Debit Card option
					getElement(ObjectRepository.dbtcrd_opt).click();
					test.log(Status.INFO, "Debit Card option clicked");
				//Enter Card number	
					verifyElementPresent(ObjectRepository.dbtcrdnmbr_ttl);
					test.log(Status.INFO, "Enter Debit card number page opened");
					
					enterAmount(dbtcardnmbr);
					test.log(Status.INFO, "Debit card number entered");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from debit card page");
				//Enter name on the card	
					verifyElementPresent(ObjectRepository.nameoncard_ttl);
					test.log(Status.INFO, "Enter Name on the card page opened");
					
					getElement(ObjectRepository.nameoncard_txt).sendKeys(nameoncard);
					test.log(Status.INFO, "Name on the card entered");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from name on the card page");
				
				//Enter account  nickname 	
					verifyElementPresent(ObjectRepository.acntnickname_ttl);
					test.log(Status.INFO, "Enter Account nickname page opened");
					
					getElement(ObjectRepository.acntnickname_txt).sendKeys(acntnickname);
					test.log(Status.INFO, "Nickname entered");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from Nickname page");
					
				//Enter Expiration date 	
					verifyElementPresent(ObjectRepository.expdate_ttl);
					test.log(Status.INFO, "Enter Expiration date page opened");
					
					enterDate(expmnth);
					test.log(Status.INFO, "Expiration month entered");
					Thread.sleep(2000);
					enterDate(expyr);
					test.log(Status.INFO, "Expiration year entered");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from expiration month/year page");
					
					verifyElementPresent(ObjectRepository.cvv_ttl);
					test.log(Status.INFO, "Enter CVV page opened");
					enterDate(cvv);
					test.log(Status.INFO, "CVV number entered");
					Thread.sleep(2000);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from CVV page");
					
				//Enter account details	
					verifyElementPresent(ObjectRepository.acntdtls_ttl);
					test.log(Status.INFO, "Enter account details page opened");	
					
					getElement(ObjectRepository.state_arrw).click();
					
					scrollToElement("//android.widget.CheckedTextView[@text='"+state+"']", 10);
					
					getElement("//android.widget.CheckedTextView[@text='"+state+"']").click();
					test.log(Status.INFO, "State selected");
					
					getElement(ObjectRepository.zip_txt).click();
					enterDate(zip);
					test.log(Status.INFO, "Zip code entered");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from zip page");
				
				//Confirm details
					verifyElementPresent(ObjectRepository.cnfmdtls_ttl);
					test.log(Status.INFO, "Confirm details page opened");
					
					getElement(ObjectRepository.confirm_btn).click();
					test.log(Status.INFO, "Confirm button clicked");
					
					Thread.sleep(3000);
					verifyElementPresent(ObjectRepository.addfndgacnt_btn);
					dbtcardnmbr=dbtcardnmbr.substring(dbtcardnmbr.length()-4);
					verifyElementPresent("//android.widget.TextView[contains(@text,'"+dbtcardnmbr+"')]");
					test.log(Status.INFO, "Funding Account-Debit Card successfully added");
					
					
				}
			 }
		}
	}


	

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());		
		}else
		{
			test.log(Status.PASS, "Verify Add Funding Account Debit Card scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
