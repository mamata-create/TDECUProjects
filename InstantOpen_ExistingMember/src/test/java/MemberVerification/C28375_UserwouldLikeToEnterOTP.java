package MemberVerification;

import java.io.IOException;

import javax.mail.MessagingException;

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

public class C28375_UserwouldLikeToEnterOTP extends GenericKeywords{
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
  public void C28375_UserwouldLikeToEnterOTP() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String loanAmt= excl.getCellData(sheetName, 6, startIter);
					String purchPrice= excl.getCellData(sheetName, 7, startIter);
					String VIN= excl.getCellData(sheetName, 8, startIter);
					
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					

					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.boatRefinCheckBox).click();
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					getElement(ObjectRepository.ccCourtesyPayCheckBox).click();					
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Vehicle loan and checking account selected");
					//Loan info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					getElement(ObjectRepository.carPurchPrice).sendKeys(purchPrice);
					getElement(ObjectRepository.carVIN).sendKeys(VIN);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Loan data entered");					
					//Member Verification
				//	getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					
					verifyText(ObjectRepository.delivery_method_page_header,"Select a Delivery Method");
					test.log(Status.INFO, "user on Delivery Method page");
					
					getElement(ObjectRepository.prodInfoBackButton).click();
					verifyElementPresent(ObjectRepository.mmbrVerifySSN);
					
					getElement(ObjectRepository.mmbrVerifyNext).click();
					verifyText(ObjectRepository.delivery_method_page_header,"Select a Delivery Method");
					
					//Select deleivery method as Email and click on Verify Code without putting OTP
					
					getElement(ObjectRepository.delivery_method_email_option("Email")).click();
					getElement(ObjectRepository.send_otp_button).click();
					getElement(ObjectRepository.btn_verify_code).click();
					verifyText(ObjectRepository.errorMsg,"Please enter a security code.");
					
					//Enter Invalid OTP and check
					getElement(ObjectRepository.security_code_textbox).sendKeys("OTP_8895");
					getElement(ObjectRepository.btn_verify_code).click();
					verifyText(ObjectRepository.errorMsg,"The security code is invalid. Please try again.");
					
					//Click on Resend Code button and Proceed
					getElement(ObjectRepository.resend_otp).click();
					
					
					enter_otp_to_the_field_and_procced();
					//Applicant Info
				
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
			test.log(Status.PASS, "Verify agreement and disclosures for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
