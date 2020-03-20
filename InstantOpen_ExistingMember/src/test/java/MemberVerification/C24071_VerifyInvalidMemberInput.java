package MemberVerification;

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

public class C24071_VerifyInvalidMemberInput extends GenericKeywords{
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
  public void C24071_VerifyInvalidMemberInput() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String ccAmount= excl.getCellData(sheetName, 6, startIter);
					String errorMsg1= excl.getCellData(sheetName, 23, startIter);
					String errorMsg2= excl.getCellData(sheetName, 24, startIter);
					String errorMsg3= excl.getCellData(sheetName, 25, startIter);
					String errorMsg4= excl.getCellData(sheetName, 26, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String invalidMmbrNum= excl.getCellData(sheetName, 30, startIter);
					String invalidSSN= excl.getCellData(sheetName, 31, startIter);
					String invalidDOB= excl.getCellData(sheetName, 32, startIter);
					String otherSSN= excl.getCellData(sheetName, 33, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select credit card and enter amount
					getElement(ObjectRepository.creditCardExpand).click();
					getElement(ObjectRepository.platinumCheckBox).click();
					test.log(Status.INFO, "Platinum credit card selected");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(ccAmount);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Credit card amount entered");
					//Empty member verification fields
					getElement(ObjectRepository.mmbrVerifyNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg1);
					verifyText(ObjectRepository.errorMsg2,errorMsg2);
					verifyText(ObjectRepository.errorMsg3,errorMsg3);
					verifyText(ObjectRepository.errorMsg4,errorMsg4);
					test.log(Status.PASS, "Correct error messages displayed");
					//Invalid DOB
					
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg3);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(invalidDOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg4);
					test.log(Status.PASS, "Error message displayed for incorrect DOB");
					//Invalid SSN
					
					getElement(ObjectRepository.mmbrVerifyDOB).clear();
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifySSN).clear();
					getElement(ObjectRepository.mmbrVerifyNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg2);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(invalidSSN);		
					getElement(ObjectRepository.mmbrVerifyNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg4);
					test.log(Status.PASS, "Error message displayed for incorrect SSN");
					//Invalid member number
//					getElement(ObjectRepository.mmbrVerifySSN).clear();
//					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
//					getElement(ObjectRepository.mmbrVerifyDOB).clear();
//					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
//					getElement(ObjectRepository.mmbrVerifyNum).clear();
//					getElement(ObjectRepository.mmbrVerifyNext).click();
//					verifyText(ObjectRepository.errorMsg1,errorMsg1);
//					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(invalidMmbrNum);
//					getElement(ObjectRepository.mmbrVerifyNext).click();
//					verifyText(ObjectRepository.errorMsg1,errorMsg4);
//					test.log(Status.INFO, "Error message displayed for incorrect member number");
					//Different member's SSN
					
					getElement(ObjectRepository.mmbrVerifySSN).clear();
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(otherSSN);
					getElement(ObjectRepository.mmbrVerifyDOB).clear();
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg4);
					test.log(Status.PASS, "Error message displayed for other member's SSN");
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
			test.log(Status.PASS, "Verify invalid member verification input for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
