package PersonalLoanInfo;

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

public class C24189_VerifyAdditionalLoanInfo extends GenericKeywords{
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
  public void C24189_VerifyAdditionalLoanInfo() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String errorMsg1=excl.getCellData(sheetName, 23, startIter);
					String loanAmt=excl.getCellData(sheetName, 6, startIter);
					String mmbrNum=excl.getCellData(sheetName, 27, startIter);
					String SSN=excl.getCellData(sheetName, 28, startIter);
					String DOB=excl.getCellData(sheetName, 29, startIter);
					String appSection=excl.getCellData(sheetName, 1, startIter);
					String idSection=excl.getCellData(sheetName, 2, startIter);
					String loanSection=excl.getCellData(sheetName, 3, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg1);
					test.log(Status.INFO, "Select account error message displayed");
					//Select loan
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.homeAdvCheckBox).click();
					test.log(Status.INFO, "Personal loan selected");
					getElement(ObjectRepository.productPageNext).click();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					test.log(Status.INFO, "Loan amount entered");
					getElement(ObjectRepository.prodInfoNextButton).click();
					
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					test.log(Status.INFO, "Member verified");
					
					verifyText(ObjectRepository.delivery_method_page_header,"Select a Delivery Method");
					enter_otp_to_the_field_and_procced();
					test.log(Status.PASS, "OTP Verified Successfully");
					
					verifyText(ObjectRepository.applicantHdr,appSection);
					verifyText(ObjectRepository.identityHdr,idSection);
					scrollToElement(ObjectRepository.loanHdr);
					verifyText(ObjectRepository.loanHdr,loanSection);
					test.log(Status.INFO, "Loan Information section displayed");
					verifyTxtFieldValue(ObjectRepository.housePymt,"");
					verifyTxtFieldValue(ObjectRepository.addrYears,"");
					verifyTxtFieldValue(ObjectRepository.addrMonths,"");
					verifyTxtFieldValue(ObjectRepository.currentEmp,"");
					verifyTxtFieldValue(ObjectRepository.monIncome,"");
					verifyTxtFieldValue(ObjectRepository.empYears,"");
					verifyTxtFieldValue(ObjectRepository.empMonths,"");
					verifyTxtFieldValue(ObjectRepository.prevEmp,"");
					verifyTxtFieldValue(ObjectRepository.prevIncome,"");
					verifyTxtFieldValue(ObjectRepository.prevYears,"");
					verifyTxtFieldValue(ObjectRepository.prevMonths,"");
					test.log(Status.INFO, "Loan Information fields blank");
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
			test.log(Status.PASS, "Verify loan information section for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
