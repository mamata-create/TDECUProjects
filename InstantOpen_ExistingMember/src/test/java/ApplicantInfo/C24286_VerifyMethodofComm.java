package ApplicantInfo;

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

public class C24286_VerifyMethodofComm extends GenericKeywords{
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
  public void C24286_VerifyMethodofComm() throws InterruptedException, MessagingException, IOException {
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
					String selectEmail= excl.getCellData(sheetName, 6, startIter);
					String selectMobile= excl.getCellData(sheetName, 7, startIter);
					String selectHome= excl.getCellData(sheetName, 8, startIter);
					String selectWork= excl.getCellData(sheetName, 9, startIter);
					String promocode = excl.getCellData(sheetName, 44, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Checking account
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					test.log(Status.INFO, "Checking account selected");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Member Verification
					
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
					//Verify methods of communication
					selectDropdownOpt(ObjectRepository.commDdown,selectEmail);
					verifyDropdownSelection(ObjectRepository.commDdown,selectEmail);
					selectDropdownOpt(ObjectRepository.commDdown,selectMobile);
					verifyDropdownSelection(ObjectRepository.commDdown,selectMobile);
					selectDropdownOpt(ObjectRepository.commDdown,selectHome);
					verifyDropdownSelection(ObjectRepository.commDdown,selectHome);
					selectDropdownOpt(ObjectRepository.commDdown,selectWork);
					verifyDropdownSelection(ObjectRepository.commDdown,selectWork);
					test.log(Status.INFO, "Method of Communication options validated");
					selectDropdownOpt(ObjectRepository.commDdown,"");
					verifyDropdownSelection(ObjectRepository.commDdown,"");
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.confirmTtl);
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
			test.log(Status.PASS, "Verify Preferred Method of Communication field for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
