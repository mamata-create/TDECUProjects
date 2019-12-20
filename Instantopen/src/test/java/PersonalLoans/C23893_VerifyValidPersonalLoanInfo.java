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

public class C23893_VerifyValidPersonalLoanInfo  extends GenericKeywords{
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
  public void C23893_VerifyValidPersonalLoanInfo() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String nullDdown=excl.getCellData(sheetName, 1, startIter);
					String errorMsg1=excl.getCellData(sheetName, 23, startIter);
					String errorMsg2=excl.getCellData(sheetName, 24, startIter);
					String cashDdown=excl.getCellData(sheetName, 2, startIter);
					String belowMin=excl.getCellData(sheetName, 6, startIter);
					String popupMsg=excl.getCellData(sheetName, 25, startIter);
					String aboveMax=excl.getCellData(sheetName, 7, startIter);
					
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
				
				
					
					//Select loan
					scrollToElement(ObjectRepository.personalLoanExpand);
					getElement(ObjectRepository.personalLoanExpand).click();
					Thread.sleep(2000);
					getElement(ObjectRepository.myWay6000CheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Personal Loan selected");
					//select blank dropdown
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,nullDdown);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg1);
					verifyText(ObjectRepository.errorMsg2,errorMsg2);
					verifyElementPresent(ObjectRepository.errorType);
					verifyElementPresent(ObjectRepository.typeAsterisk);
					verifyElementPresent(ObjectRepository.errorAmount);
					verifyElementPresent(ObjectRepository.psnlAmtAsterisk);
					test.log(Status.INFO, "Correct error messages displayed");
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,cashDdown);
					//Enter less than minimum
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(belowMin);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popupMsg);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					//Enter more than the maximum
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(aboveMax);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.BACK_SPACE);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popupMsg);
					test.log(Status.INFO, "Invalid amount not accepted");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.BACK_SPACE);
					verifyElementPresent(ObjectRepository.prodLimCorrect);
					test.log(Status.INFO, "Valid amount accepted");
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Continue button clicked");	
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
			test.log(Status.PASS, "Verify personal loan field data for non member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
