package PersonalLoans;

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

public class C23855_VerifyPersonalLoanInfo extends GenericKeywords{
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
  public void C23855_VerifyPersonalLoanInfo() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String myway4Ddown= excl.getCellData(sheetName, 1, startIter);
					String myway6Ddown= excl.getCellData(sheetName, 2, startIter);
					String myway7Ddown= excl.getCellData(sheetName, 3, startIter);
					String personalDdown= excl.getCellData(sheetName, 4, startIter);
					String homeAdvDdown= excl.getCellData(sheetName, 5, startIter);
					String cashDdown= excl.getCellData(sheetName, 6, startIter);
					String cdDdown= excl.getCellData(sheetName, 7, startIter);
					String shareDdown= excl.getCellData(sheetName, 8, startIter);
					String loanDesc= excl.getCellData(sheetName, 16, startIter);
					String typeLbl= excl.getCellData(sheetName, 17, startIter);
					String amountLbl = excl.getCellData(sheetName, 18, startIter);
					String backBtn= excl.getCellData(sheetName, 19, startIter);
					String continueBtn = excl.getCellData(sheetName, 20, startIter);
					String loanAmt= excl.getCellData(sheetName, 11, startIter);
					String loanAmtFormat= excl.getCellData(sheetName, 12, startIter);
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Members Start Here button clicked");
					Thread.sleep(4000);
					
				//Dont want to open a checking account option selected	
					scrollToElement(ObjectRepository.dontWantCheckingOption);
					getElement(ObjectRepository.dontWantCheckingOption).click();
					test.log(Status.INFO, "Dont want to open a checking account option selected");
				
					Thread.sleep(4000);
					
					getElement(ObjectRepository.loancnfrm_yes).click();
					test.log(Status.INFO, "Yes option selected");
					
					Thread.sleep(2000);
				
					
					//select loan
					getElement(ObjectRepository.personalLoanExpand).click();
					Thread.sleep(2000);
					getElement(ObjectRepository.personalCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Personal loan selected");
					//Verify elements
					verifyElementPresent(ObjectRepository.psnlLoanInfTtl);
					verifyText(ObjectRepository.prodInfoMsg,loanDesc);
					verifyText(ObjectRepository.prodTypeLabel,typeLbl);
					verifyText(ObjectRepository.prodLimitLabel,amountLbl);
					verifyTxtValue(ObjectRepository.prodInfoBackButton,backBtn);
					verifyTxtValue(ObjectRepository.prodInfoNextButton,continueBtn);
					test.log(Status.INFO, "Labels verified");
					//verify dropdowns
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,myway4Ddown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,myway6Ddown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,myway7Ddown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,personalDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,homeAdvDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,cashDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,cdDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,shareDdown);
					test.log(Status.INFO, "Dropdown values verified");
					//enter amount
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,loanAmtFormat);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Amount entered and Continue button clicked");
					
					verifyElementPresent(ObjectRepository.primaryApplicantInfoPageTitle);
					test.log(Status.INFO, "Primary Applicant Information page appeared");
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
			test.log(Status.PASS, "Verify Personal Loan Info page for non member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
