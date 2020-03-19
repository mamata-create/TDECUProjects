package ConfirmAccounts;

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

public class C24026_VerifyRemoveAccountSelection extends GenericKeywords{
	ExtentReports extent;
	ExtentTest test;
	
  @BeforeTest
  public void setUp() throws InterruptedException, MessagingException, IOException {
	  extent = ExtentManager.GetExtent();
	  test = extent.createTest(this.getClass().getSimpleName());
      BaseClass iDriver = new BaseClass();
      iDriver.myTestCaseName = this.getClass().getSimpleName();
	  executeDriverScript();
	  test.log(Status.INFO, "Application url navigated");
  }
	
  @Test
  public void C24026_VerifyRemoveAccountSelection() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String confirmProd1= excl.getCellData(sheetName, 1, startIter);
					String confirmProd2= excl.getCellData(sheetName, 2, startIter);
					String SSNformat= excl.getCellData(sheetName, 30, startIter);
					String DOBformat= excl.getCellData(sheetName, 31, startIter);
					String confirmProd3= excl.getCellData(sheetName, 3, startIter);
					String promocode = excl.getCellData(sheetName, 44, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.highYieldCheckBox).click();
					getElement(ObjectRepository.savingsExpand).click();
					getElement(ObjectRepository.clubCheckBox).click();	
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Products selected");
					//Member Verification
				//	getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					verifyText(ObjectRepository.delivery_method_page_header,"Select a Delivery Method");
					test.log(Status.INFO, "user on Delivery Method page");
					//Enter OTP from Email
					enter_otp_to_the_field_and_procced();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Applicant Information entered");
					//Enter PromoCode
					enterPromocode(promocode);
//					getElement(ObjectRepository.productPageNext).click();
//					test.log(Status.INFO, "Continue button clicked");
					//Confirm Accounts
					verifyText(ObjectRepository.prodOne,confirmProd1);
					verifyText(ObjectRepository.prodWOptionsTwo,confirmProd2);
					getElement(ObjectRepository.changeBtn).click();
					test.log(Status.INFO, "Change button clicked");
					//Remove account
					verifyElementPresent(ObjectRepository.clubChecked);
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.highYieldChecked).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Product deselected");
					//Member verification
					verifyTxtFieldValue(ObjectRepository.mmbrVerifyNum,mmbrNum);
					verifyTxtFieldValue(ObjectRepository.mmbrVerifySSN,SSNformat);
					verifyTxtFieldValue(ObjectRepository.mmbrVerifyDOB,DOBformat);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member information retained");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Confirm Accounts
					verifyText(ObjectRepository.prodOne,confirmProd2);
					verifyText(ObjectRepository.prodTwo,confirmProd3);
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
			test.log(Status.PASS, "Verify product selection removed for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
