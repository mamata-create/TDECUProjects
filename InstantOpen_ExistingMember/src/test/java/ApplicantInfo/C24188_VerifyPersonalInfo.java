package ApplicantInfo;

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

public class C24188_VerifyPersonalInfo extends GenericKeywords{
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
  public void C24188_VerifyPersonalInfo() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String jtOwnersLabel= excl.getCellData(sheetName, 6, startIter);
					String beneficiaryLbl= excl.getCellData(sheetName, 7, startIter);
					String backBtn= excl.getCellData(sheetName, 8, startIter);
					String continueBtn= excl.getCellData(sheetName, 9, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Checking account
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					test.log(Status.INFO, "Checking account selected");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					test.log(Status.INFO, "Member Verified");
					//Verify Applicant Info fields
					verifyElementPresent(ObjectRepository.fnameLabel);
					verifyElementPresent(ObjectRepository.mnameLabel);
					verifyElementPresent(ObjectRepository.lnameLabel);
					verifyElementPresent(ObjectRepository.nameSffxLabel);
					verifyElementPresent(ObjectRepository.stAddrLabel);
					verifyElementPresent(ObjectRepository.cityLabel);
					verifyElementPresent(ObjectRepository.commLabel);
					verifyElementPresent(ObjectRepository.commDdown);
					verifyElementPresent(ObjectRepository.jtOwnerCheckBox);
					verifyText(ObjectRepository.jtOwnerLbl,jtOwnersLabel);
					verifyElementPresent(ObjectRepository.addBeneCheckBox);
					verifyText(ObjectRepository.addBeneLbl,beneficiaryLbl);
					verifyTxtFieldValue(ObjectRepository.productPageBack,backBtn);
					verifyTxtFieldValue(ObjectRepository.productPageNext,continueBtn);
					test.log(Status.INFO, "Applicant Information fields displayed");
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.confirmTtl);					
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Confirm button clicked");
					verifyElementPresent(ObjectRepository.agreementTtl);
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back button clicked");
					verifyElementPresent(ObjectRepository.yourInfoTtl);
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
			test.log(Status.PASS, "Verify personal information fields for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
