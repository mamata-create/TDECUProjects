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

public class TDB2442_AddFundingAccountBankAccount extends GenericKeywords {

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
	 * Test Cases covered -- TDB-2442
	 */
	@Test
	public void TDB2442_AddFundingAccountBankAccount() throws InterruptedException{
		if(continuetestcase==true)
		{
			sheetName = "AddFundingAccount";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("AddFundingAccount", 0, startIter)))
				{
					String acnttype=excl.getCellData("AddFundingAccount", 1, startIter);
					String routingnmbr=excl.getCellData("AddFundingAccount", 2, startIter);
					String acntnmbr=excl.getCellData("AddFundingAccount", 3, startIter);
					String acntholder=excl.getCellData("AddFundingAccount", 4, startIter);
					String acntnickname=excl.getCellData("AddFundingAccount", 5, startIter);
					String state=excl.getCellData("AddFundingAccount", 6, startIter);
					String zip=excl.getCellData("AddFundingAccount", 7, startIter);
		
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
									
					verifyElementPresent(ObjectRepository.bnkacnt_opt);
					test.log(Status.INFO, "Add Funding Account- Bank Account option appearing");
					
					getElement(ObjectRepository.bnkacnt_opt).click();
					test.log(Status.INFO, "Bank Account option clicked");
					
			//Select account type							
					verifyElementPresent(ObjectRepository.acnttype_ttl);
					test.log(Status.INFO, "Add Account type page opened");
					
					getElement("//android.widget.TextView[@text='"+acnttype+"']").click();
					test.log(Status.INFO, "Account type selected");
			//Enter Account number		
					verifyElementPresent(ObjectRepository.acntnmbr_ttl);
					test.log(Status.INFO, "Enter account number page opened");
					
					enterAmount(acntnmbr);
					test.log(Status.INFO, "Account Number entered");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from Account number page");
			//Enter routing number	
					Thread.sleep(3000);
					verifyElementPresent(ObjectRepository.rtngnmbr_ttl);
					test.log(Status.INFO, "Enter routing number page opened");
					
					enterDate(routingnmbr);
					test.log(Status.INFO, "Routing Number entered");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from Routing number page");
			
			//Enter Account holder name		
					Thread.sleep(3000);
					//verifyElementPresent(ObjectRepository.acntholdername_ttl);
					//test.log(Status.INFO, "Enter Account holder name page opened");
					
					getElement(ObjectRepository.acntholdername_txt).sendKeys(acntholder);
					test.log(Status.INFO, "Account Holder name entered");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from Account holder name page");
						
			//Enter Account nickname	
					Thread.sleep(3000);
					verifyElementPresent(ObjectRepository.acntnickname_ttl);
					test.log(Status.INFO, "Enter Account nickname page opened");
					
					getElement(ObjectRepository.acntnickname_txt).sendKeys(acntnickname);
					test.log(Status.INFO, "Account nickname entered");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from Account nickname page");
			//Enter account details	
					Thread.sleep(3000);
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
					verifyElementPresent(ObjectRepository.cnfmacntdtls_ttl);
					test.log(Status.INFO, "Confirm details page opened");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.confirm_btn).click();
					test.log(Status.INFO, "Confirm button clicked");
					
					Thread.sleep(3000);
					verifyElementPresent(ObjectRepository.addfndgacnt_btn);
					acntnmbr=acntnmbr.substring(acntnmbr.length()-4);
					verifyElementPresent("//android.widget.TextView[contains(@text,'"+acntnmbr+"')]");
					test.log(Status.INFO, "Funding Account-Bank Account successfully added");
					
					
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
			test.log(Status.PASS, "Verify Add Funding Account-Bank Account scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
