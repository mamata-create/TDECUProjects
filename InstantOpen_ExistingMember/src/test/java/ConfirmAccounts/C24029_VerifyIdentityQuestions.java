package ConfirmAccounts;

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

public class C24029_VerifyIdentityQuestions extends GenericKeywords{
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
  public void C24029_VerifyIdentityQuestions() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String selectCD= excl.getCellData(sheetName, 1, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String confirmProd= excl.getCellData(sheetName, 2, startIter);
					String errorMsg1= excl.getCellData(sheetName, 6, startIter);
					String errorMsg2= excl.getCellData(sheetName, 7, startIter);
					String errorMsg3= excl.getCellData(sheetName, 8, startIter);
					String errorMsg4= excl.getCellData(sheetName, 9, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.cdExpand).click();
					selectDropdownOpt(ObjectRepository.selectTermDropdown,selectCD);
					getElement(ObjectRepository.visibleCD36).click();					
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "36 Month CD selected");
					//Member Verification/Applicant Info
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Member and Applicant Info Verified");
					//Confirm Accounts
					String maturity = cdMaturityDate(36);					
					String concatProd = confirmProd+" "+maturity+")";
					verifyText(ObjectRepository.prodOne,concatProd);
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Account selection confirmed");
					//Agreements and Disclosures
					getElement(ObjectRepository.discCheckBox).click();
					getElement(ObjectRepository.agreeCheckBox).click();
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Agreements and Disclosures accepted");
					//Identity Questions
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg,errorMsg1);
					getElement(ObjectRepository.qstnOneOptnOne).click();
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg,errorMsg2);
					getElement(ObjectRepository.qstnTwoOptnTwo).click();
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg,errorMsg3);
					getElement(ObjectRepository.qstnThreeOptnThree).click();
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg,errorMsg4);
					getElement(ObjectRepository.qstnFourOptnFour).click();
					test.log(Status.INFO, "Identity answers selected");
					getElement(ObjectRepository.confirmBtn).click();
					verifyElementPresent(ObjectRepository.acctFundTitle);
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
			test.log(Status.PASS, "Verify identity questions for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
