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

public class C24160_VerifyPersonalLoanInfo extends GenericKeywords{
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
  public void C24160_VerifyPersonalLoanInfo() throws InterruptedException, MessagingException, IOException {
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
					String stormDdown= excl.getCellData(sheetName, 9, startIter);
					String loanDesc= excl.getCellData(sheetName, 16, startIter);
					String typeLbl= excl.getCellData(sheetName, 17, startIter);
					String amountLbl = excl.getCellData(sheetName, 18, startIter);
					String backBtn= excl.getCellData(sheetName, 19, startIter);
					String continueBtn = excl.getCellData(sheetName, 20, startIter);
					String loanAmt= excl.getCellData(sheetName, 11, startIter);
					String loanAmtFormat= excl.getCellData(sheetName, 12, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//select loan
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.personalCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Personal loan selected");
					//Verify elements
					verifyElementPresent(ObjectRepository.psnlLoanInfTtl);
					verifyText(ObjectRepository.prodInfoMsg,loanDesc);
					verifyText(ObjectRepository.prodTypeLabel,typeLbl);
					verifyText(ObjectRepository.prodLimitLabel,amountLbl);
					verifyTxtFieldValue(ObjectRepository.prodInfoBackButton,backBtn);
					verifyTxtFieldValue(ObjectRepository.prodInfoNextButton,continueBtn);
					test.log(Status.INFO, "Labels verified");
					//verify dropdowns
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,stormDdown);
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
			test.log(Status.PASS, "Verify Personal Loan Info page for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
