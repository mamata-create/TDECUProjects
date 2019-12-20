package PersonalLoans;

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

public class C24273_VerifyAdditionalLoanInfo  extends GenericKeywords{
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
  public void C24273_VerifyAdditionalLoanInfo() throws InterruptedException, MessagingException, IOException {
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
				
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg1);
					test.log(Status.INFO, "Select account error message displayed");
					//Select loan
					getElement(ObjectRepository.personalLoanExpand).click();
					Thread.sleep(2000);
					getElement(ObjectRepository.homeAdvCheckBox).click();
					test.log(Status.INFO, "Personal loan selected");
					getElement(ObjectRepository.productPageNext).click();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					test.log(Status.INFO, "Loan amount entered");
					getElement(ObjectRepository.prodInfoNextButton).click();
					
					//Primary Applicant info page
					verifyElementPresent(ObjectRepository.primaryApplicantInfoPageTitle);
					verifyElementPresent(ObjectRepository.aplcntinfo_ttl);
					verifyElementPresent(ObjectRepository.idntfctninfo_ttl);
					verifyElementPresent(ObjectRepository.loaninfo_ttl);
					test.log(Status.INFO, "Primary Applicant Information page appeared with all sections");
				
					
					verifyText(ObjectRepository.housePymt,"");
					verifyText(ObjectRepository.addrYears,"");
					verifyText(ObjectRepository.addrMonths,"");
					verifyText(ObjectRepository.currentEmp,"");
					verifyText(ObjectRepository.monIncome,"");
					verifyText(ObjectRepository.empYears,"");
					verifyText(ObjectRepository.empMonths,"");
					verifyText(ObjectRepository.prevEmp,"");
					verifyText(ObjectRepository.prevIncome,"");
					verifyText(ObjectRepository.prevYears,"");
					verifyText(ObjectRepository.prevMonths,"");
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
			test.log(Status.PASS, "Verify loan information section for non member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
