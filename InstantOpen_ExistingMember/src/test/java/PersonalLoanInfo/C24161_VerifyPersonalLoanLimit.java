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

public class C24161_VerifyPersonalLoanLimit extends GenericKeywords{
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
  public void C24161_VerifyPersonalLoanLimit() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String cdLoan=excl.getCellData(sheetName, 1, startIter);
					String cdLoanMin=excl.getCellData(sheetName, 11, startIter);
					String loanAmount=excl.getCellData(sheetName, 12, startIter);
					String amountFormat=excl.getCellData(sheetName, 13, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//select loan
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.myWay7000CheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Personal loan selected");
					//select different loan
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,cdLoan);
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,cdLoan);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,cdLoanMin);
					test.log(Status.INFO, "Different loan selected");
					//verify amount format
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmount);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,amountFormat);
					test.log(Status.INFO, "Loan amount in correct format");
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
			test.log(Status.PASS, "Verify select different personal loan for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
