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

public class C24274_VerifyHousingTypeField  extends GenericKeywords{
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
  public void C24274_VerifyHousingTypeField() throws InterruptedException, MessagingException, IOException {
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
					String nullDdown=excl.getCellData(sheetName, 7, startIter);
					String rentDdown=excl.getCellData(sheetName, 8, startIter);
					String ownDdown=excl.getCellData(sheetName, 9, startIter);
					String mortgageDdown=excl.getCellData(sheetName, 10, startIter);
					
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
					getElement(ObjectRepository.personalLoanExpand).click();
					Thread.sleep(2000);
					getElement(ObjectRepository.myWay4000CheckBox).click();
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
					
					scrollToElement(ObjectRepository.loaninfo_ttl);
					verifyDropdownSelection(ObjectRepository.houseType,ownDdown);
					selectDropdownOptContain(ObjectRepository.houseType,nullDdown);
					selectDropdownOptContain(ObjectRepository.houseType,rentDdown);
					selectDropdownOptContain(ObjectRepository.houseType,ownDdown);
					selectDropdownOptContain(ObjectRepository.houseType,mortgageDdown);
					selectDropdownOpt(ObjectRepository.houseType,rentDdown);
					verifyDropdownSelection(ObjectRepository.houseType,rentDdown);
					selectDropdownOpt(ObjectRepository.houseType,mortgageDdown);
					verifyDropdownSelection(ObjectRepository.houseType,mortgageDdown);
					selectDropdownOpt(ObjectRepository.houseType,nullDdown);
					verifyDropdownSelection(ObjectRepository.houseType,nullDdown);
					test.log(Status.INFO, "Dropdown values verified");
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
			test.log(Status.PASS, "Verify loan information housing type field for non member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
