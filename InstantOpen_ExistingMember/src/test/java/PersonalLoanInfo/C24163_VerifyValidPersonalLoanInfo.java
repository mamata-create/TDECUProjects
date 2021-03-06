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

public class C24163_VerifyValidPersonalLoanInfo extends GenericKeywords{
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
  public void C24163_VerifyValidPersonalLoanInfo() throws InterruptedException, MessagingException, IOException {
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
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					//Select loan
					scrollToElement(ObjectRepository.personalLoanExpand);
					getElement(ObjectRepository.personalLoanExpand).click();
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
					verifyElementPresent(ObjectRepository.mmbrVerifyTile);
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
			test.log(Status.PASS, "Verify personal loan field data for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
