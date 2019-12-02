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

public class C24282_VerifyPreviousEmployerField extends GenericKeywords{
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
  public void C24284_VerifyPreviousEmployerField() throws InterruptedException, MessagingException, IOException {
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
					String months=excl.getCellData(sheetName, 9, startIter);
					String currentEmp=excl.getCellData(sheetName, 16, startIter);
					String income=excl.getCellData(sheetName, 17, startIter);
					String empMonths=excl.getCellData(sheetName, 18, startIter);
					String prevEmp=excl.getCellData(sheetName, 19, startIter);
					String oneChar=excl.getCellData(sheetName, 20, startIter);
					String errorMsg=excl.getCellData(sheetName, 23, startIter);
					
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
					getElement(ObjectRepository.shareSecuredCheckBox).click();
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
					//Enter identification information
					selectDropdownOpt(ObjectRepository.idType,idType);
					getElement(ObjectRepository.idNum).sendKeys(idNum);
					getElement(ObjectRepository.issueDate).sendKeys(issueDt);
					getElement(ObjectRepository.expDate).sendKeys(expDate);
					test.log(Status.INFO, "Identification information entered");
					scrollToElement(ObjectRepository.loanHdr);
					getElement(ObjectRepository.housePymt).sendKeys(payment);
					getElement(ObjectRepository.addrYears).sendKeys(years);
					getElement(ObjectRepository.addrMonths).sendKeys(months);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(income);				
					//verify previous employer field
					getElement(ObjectRepository.prevEmp).sendKeys(prevEmp);
					getElement(ObjectRepository.prevEmp).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.prevEmp,prevEmp);
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg);
					getElement(ObjectRepository.empMonths).sendKeys(empMonths);
					getElement(ObjectRepository.prevEmp).clear();
					getElement(ObjectRepository.prevEmp).sendKeys(oneChar);
					getElement(ObjectRepository.prevEmp).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.prevEmp,oneChar);
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.confirmTtl);
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
			test.log(Status.PASS, "Verify loan information, previous employer field for non member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
