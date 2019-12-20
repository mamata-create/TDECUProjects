package SaveProgress;

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

public class C24031_VerifyValidLoginToSave extends GenericKeywords{
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
  public void C24031_VerifyValidLoginToSave() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String cdSelection= excl.getCellData(sheetName, 1, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String email1= excl.getCellData(sheetName, 6, startIter);
					String email2= excl.getCellData(sheetName, 7, startIter);
					String email3= excl.getCellData(sheetName, 8, startIter);
					String password1= excl.getCellData(sheetName, 9, startIter);
					String password2= excl.getCellData(sheetName, 10, startIter);
					String password3= excl.getCellData(sheetName, 11, startIter);
					String password4= excl.getCellData(sheetName, 12, startIter);
					String password5= excl.getCellData(sheetName, 13, startIter);
					String password6= excl.getCellData(sheetName, 14, startIter);
					String password7= excl.getCellData(sheetName, 15, startIter);
					String error1= excl.getCellData(sheetName, 16, startIter);
					String error2= excl.getCellData(sheetName, 17, startIter);
					String error3= excl.getCellData(sheetName, 18, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					getElement(ObjectRepository.cdExpand).click();
					selectDropdownOpt(ObjectRepository.selectTermDropdown,cdSelection);
					getElement(ObjectRepository.visibleCD48).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Share Certificate selected");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					getElement(ObjectRepository.saveBtn).click();
					test.log(Status.INFO, "Save and Finish Later clicked");
					//Email validation
					getElement(ObjectRepository.emailAddr).clear();
					getElement(ObjectRepository.emailAddr).sendKeys(email1);
					getElement(ObjectRepository.confirmBtn).click();					
					verifyText(ObjectRepository.errorMsg,error1);
					getElement(ObjectRepository.emailAddr).clear();
					getElement(ObjectRepository.emailAddr).sendKeys(email2);
					getElement(ObjectRepository.LeaveBtn).click();					
					verifyText(ObjectRepository.errorMsg,error1);
					getElement(ObjectRepository.emailAddr).clear();
					getElement(ObjectRepository.emailAddr).sendKeys(email3);
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg1,error2);
					verifyElementPresent(ObjectRepository.errorPassword);
					verifyElementPresent(ObjectRepository.pwAsterisk);
					test.log(Status.INFO, "Email field verified");
					//Password Validation
					getElement(ObjectRepository.password).sendKeys(password1);
					getElement(ObjectRepository.LeaveBtn).click();
					verifyText(ObjectRepository.errorMsg1,error3);
					getElement(ObjectRepository.password).sendKeys(password2);
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg1,error3);
					getElement(ObjectRepository.password).sendKeys(password3);
					getElement(ObjectRepository.LeaveBtn).click();
					verifyText(ObjectRepository.errorMsg1,error3);
					getElement(ObjectRepository.password).sendKeys(password4);
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg1,error3);
					getElement(ObjectRepository.password).sendKeys(password5);
					getElement(ObjectRepository.LeaveBtn).click();
					verifyText(ObjectRepository.errorMsg1,error3);
					getElement(ObjectRepository.password).sendKeys(password6);
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg1,error3);
					getElement(ObjectRepository.password).sendKeys(password7);
					getElement(ObjectRepository.LeaveBtn).click();
					verifyText(ObjectRepository.errorMsg1,error3);
					test.log(Status.INFO, "Invalid passwords not accepted");
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
			test.log(Status.PASS, "Verify email and password requirements for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
