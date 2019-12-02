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

public class C24280_VerifyLengthofEmploymentFields  extends GenericKeywords{
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
  public void C24280_VerifyLengthofEmploymentFields() throws InterruptedException, MessagingException, IOException {
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
					String yearsMax=excl.getCellData(sheetName, 7, startIter);
					String popupMsg=excl.getCellData(sheetName, 23, startIter);
					String letters=excl.getCellData(sheetName, 8, startIter);
					String specialChar=excl.getCellData(sheetName, 9, startIter);
					String validYears=excl.getCellData(sheetName, 10, startIter);
					String monthsMax=excl.getCellData(sheetName, 11, startIter);
					String popupMsg2=excl.getCellData(sheetName, 24, startIter);
					String validMonths=excl.getCellData(sheetName, 12, startIter);
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Members Start Here button clicked");
				
					//Dont want to open a checking account option selected	
					scrollToElement(ObjectRepository.dontWantCheckingOption);
					getElement(ObjectRepository.dontWantCheckingOption).click();
					test.log(Status.INFO, "Dont want to open a checking account option selected");
				
					getElement(ObjectRepository.loancnfrm_yes).click();
					test.log(Status.INFO, "Yes option selected");
					
					//Select loan and enter amount
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.cash$tashCheckBox).click();
					test.log(Status.INFO, "Personal loan selected");
					getElement(ObjectRepository.productPageNext).click();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					test.log(Status.INFO, "Loan amount entered");
					getElement(ObjectRepository.prodInfoNextButton).click();
					//Enter member info
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					test.log(Status.INFO, "Member verified");
					scrollToElement(ObjectRepository.loanHdr);
					//verify current length of employment fields
					getElement(ObjectRepository.empYears).sendKeys(yearsMax);
					verifyText(ObjectRepository.appInfoPopup,popupMsg);
					getElement(ObjectRepository.empYears).clear();
					getElement(ObjectRepository.empYears).sendKeys(letters);
					verifyTxtFieldValue(ObjectRepository.empYears,"");
					getElement(ObjectRepository.empYears).sendKeys(specialChar);
					getElement(ObjectRepository.empYears).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.empYears,"");
					getElement(ObjectRepository.empYears).sendKeys(validYears);
					verifyTxtFieldValue(ObjectRepository.empYears,"99");
					test.log(Status.INFO, "Years field validated");
					getElement(ObjectRepository.empMonths).sendKeys(monthsMax);
					verifyText(ObjectRepository.appInfoPopup,popupMsg2);
					getElement(ObjectRepository.empMonths).clear();
					getElement(ObjectRepository.empMonths).sendKeys(letters);
					verifyTxtFieldValue(ObjectRepository.empMonths,"");
					getElement(ObjectRepository.empMonths).sendKeys(specialChar);
					getElement(ObjectRepository.empMonths).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.empMonths,"");
					getElement(ObjectRepository.empMonths).sendKeys(validMonths);
					verifyTxtFieldValue(ObjectRepository.empMonths,"9");
					test.log(Status.INFO, "Months field validated");
					
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
			test.log(Status.PASS, "Verify loan information, current length of employment fields for non member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
