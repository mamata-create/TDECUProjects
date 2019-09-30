package com.TestCases;

import java.io.IOException;

import javax.mail.MessagingException;

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

public class C23731_VerifyMemberToMemberLinkingSameAccountValidation extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException{
		extent=ExtentManager.GetExtent();
		test=extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
	    iDriver.myTestCaseName = this.getClass().getSimpleName();
		startAppium();
		executeMobileDriver();
		test.log(Status.INFO, " Q2 Mobile application launched");
		getElement(ObjectRepository.username_txt).sendKeys(username);
		getElement(ObjectRepository.password_txt).sendKeys(password);
		getElement(ObjectRepository.login_btn).click();
		test.log(Status.INFO, "Login button clicked after entering username and password");
	
	}
	

	@Test
	public void C23731_VerifyMemberToMemberLinkingSameAccountValidation() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String toacnt=excl.getCellData(sheetName, 1, startIter);
					String lastname=excl.getCellData(sheetName, 6, startIter);
								
		Thread.sleep(20000);	
		verifyElementPresent(ObjectRepository.home_ttl);
		test.log(Status.INFO, "Home link appearing");
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
	
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.trnsctn_menu).click();
		test.log(Status.INFO, "Transaction menu clicked");
		Thread.sleep(2000);	
		
		getElement(ObjectRepository.mtm_menu).click();
		test.log(Status.INFO, "Member to Member Transfer menu clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.mtm_menu);
		test.log(Status.INFO, "Member to Member Transfer title appeared");
		
		verifyElementPresent(ObjectRepository.mtm_info);
		test.log(Status.INFO, "Member to Member Transfer Info message appeared");
		
		verifyElementPresent(ObjectRepository.lnkacnt_btn);
		test.log(Status.INFO, "Link Account option appeared");
		
		getElement(ObjectRepository.lnkacnt_btn).click();
		test.log(Status.INFO, "Link Account option clicked");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.mtm_toacnt).sendKeys(toacnt);
		test.log(Status.INFO, "To Account Number entered");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.mtm_lstthreechar).sendKeys(lastname);
		test.log(Status.INFO, "Last Name three characters entered");
		
		getElement(ObjectRepository.mtm_sbmtbtn).click();
		test.log(Status.INFO, "Submit button clicked");
		
		
		verifyElementPresent(ObjectRepository.lnkacnt_again);
		test.log(Status.INFO, "Linking same  Account validation Message appeared");
				 }
			 }
		}
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed - "+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify Member to Member Transfer Linking same account validation scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
