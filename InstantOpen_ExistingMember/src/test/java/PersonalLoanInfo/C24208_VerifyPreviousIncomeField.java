package PersonalLoanInfo;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.Keys;
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

public class C24208_VerifyPreviousIncomeField extends GenericKeywords{
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
  public void C24208_VerifyPreviousIncomeField() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String loanAmt=excl.getCellData(sheetName, 6, startIter);
					String mmbrNum=excl.getCellData(sheetName, 27, startIter);
					String SSN=excl.getCellData(sheetName, 28, startIter);
					String DOB=excl.getCellData(sheetName, 29, startIter);
					String idType=excl.getCellData(sheetName, 30, startIter);
					String idNum=excl.getCellData(sheetName, 31, startIter);
					String issueDt=excl.getCellData(sheetName, 32, startIter);
					String expDate=excl.getCellData(sheetName, 33, startIter);
					String payment=excl.getCellData(sheetName, 7, startIter);
					String years=excl.getCellData(sheetName, 8, startIter);
					String currentEmp=excl.getCellData(sheetName, 9, startIter);
					String income=excl.getCellData(sheetName, 10, startIter);
					String empYears=excl.getCellData(sheetName, 11, startIter);
					String belowZero=excl.getCellData(sheetName, 16, startIter);
					String overBill=excl.getCellData(sheetName, 17, startIter);
					String letters=excl.getCellData(sheetName, 18, startIter);
					String specialChar=excl.getCellData(sheetName, 19, startIter);
					String zero=excl.getCellData(sheetName, 20, startIter);
					String validIncome=excl.getCellData(sheetName, 21, startIter);
					String incomeFrmt=excl.getCellData(sheetName, 22, startIter);
					String popupMsg=excl.getCellData(sheetName, 23, startIter);
					String errorMsg=excl.getCellData(sheetName, 24, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					//Select loan and enter amount
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.stormCheckBox).click();
					test.log(Status.INFO, "Personal loan selected");
					getElement(ObjectRepository.productPageNext).click();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					test.log(Status.INFO, "Loan amount entered");
					getElement(ObjectRepository.prodInfoNextButton).click();
					//Enter member info
					
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					test.log(Status.INFO, "Member verified");
					
					verifyText(ObjectRepository.delivery_method_page_header,"Select a Delivery Method");
					enter_otp_to_the_field_and_procced();
					test.log(Status.PASS, "OTP Verified Successfully");
					
					//Enter identification information
					selectDropdownOpt(ObjectRepository.idType,idType);
					getElement(ObjectRepository.idNum).sendKeys(idNum);
					getElement(ObjectRepository.issueDate).sendKeys(issueDt);
					getElement(ObjectRepository.expDate).sendKeys(expDate);
					test.log(Status.INFO, "Identification information entered");
					scrollToElement(ObjectRepository.loanHdr);
					getElement(ObjectRepository.housePymt).sendKeys(payment);
					getElement(ObjectRepository.addrYears).sendKeys(years);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(income);			
					getElement(ObjectRepository.empYears).sendKeys(empYears);
					//verify previous monthly income field
					getElement(ObjectRepository.prevIncome).sendKeys(belowZero);
					verifyText(ObjectRepository.appInfoPopup,popupMsg);
					getElement(ObjectRepository.prevIncome).clear();
					getElement(ObjectRepository.prevIncome).sendKeys(letters);
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg);
					getElement(ObjectRepository.prevIncome).clear();
					getElement(ObjectRepository.prevIncome).sendKeys(overBill);
					verifyText(ObjectRepository.appInfoPopup,popupMsg);
					getElement(ObjectRepository.prevIncome).clear();
					getElement(ObjectRepository.prevIncome).sendKeys(specialChar);
					getElement(ObjectRepository.prevIncome).sendKeys(Keys.TAB);
					System.out.println(getElement(ObjectRepository.prevIncome).getAttribute("value"));
					verifyTxtFieldValue(ObjectRepository.prevIncome,zero);
					getElement(ObjectRepository.prevIncome).clear();
					getElement(ObjectRepository.prevIncome).sendKeys(validIncome);
					getElement(ObjectRepository.prevIncome).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.prevIncome,incomeFrmt);
					
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
			test.log(Status.PASS, "Verify loan information, previous  monthly income field for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
