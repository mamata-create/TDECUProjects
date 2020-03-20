package JointOwnersBeneficiaries;

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

public class C24306_VerifyDeleteBeneficiary extends GenericKeywords{
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
  public void C24306_VerifyDeleteBeneficiary() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String beneFname= excl.getCellData(sheetName, 11, startIter);
					String beneLname= excl.getCellData(sheetName, 12, startIter);
					String beneDOB= excl.getCellData(sheetName, 13, startIter);
					String beneSSN= excl.getCellData(sheetName, 14, startIter);
					String benePhone= excl.getCellData(sheetName, 15, startIter);
					String benePhoneType= excl.getCellData(sheetName, 16, startIter);
					String beneEmail= excl.getCellData(sheetName, 17, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					getElement(ObjectRepository.mnyMrktCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Classic Checking and Money Market account selected");
					//Member Verification
					
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					
					verifyText(ObjectRepository.delivery_method_page_header,"Select a Delivery Method");
					test.log(Status.INFO, "user on Delivery Method page");
					enter_otp_to_the_field_and_procced();
					
					getElement(ObjectRepository.addBeneCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Add Beneficiaries checkbox selected");
					//Beneficiary
					getElement(ObjectRepository.addFname).sendKeys(beneFname);
					getElement(ObjectRepository.addLname).sendKeys(beneLname);
					getElement(ObjectRepository.sameAddrCbox).click();
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(beneDOB);
					getElement(ObjectRepository.addSSN).sendKeys(beneSSN);
					getElement(ObjectRepository.addPhone).sendKeys(benePhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,benePhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(beneEmail);
					test.log(Status.INFO, "Beneficiary information entered");
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.confirmRolesTtl);
					getElement(ObjectRepository.productPageBack).click();
					verifyElementPresent(ObjectRepository.yourInfoTtl);
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.addBeneTtl);
					test.log(Status.INFO, "Navigated back to Beneficiary Information Page");
					verifyElementPresent(ObjectRepository.beneAddTtl);
					String beneFullName = beneFname+" "+beneLname;
					verifyText(ObjectRepository.addOwnersLink,beneFullName);
					getElement(ObjectRepository.removeAddOwners).click();
					test.log(Status.INFO, "Joint Owner removed");
					Thread.sleep(1000);
					verifyElementPresent(ObjectRepository.addBeneTtl);
					verifyEmptyFieldValue(ObjectRepository.addFname);
					verifyEmptyFieldValue(ObjectRepository.addLname);
					verifyEmptyFieldValue(ObjectRepository.addStreet);
					verifyEmptyFieldValue(ObjectRepository.addZip);
					verifyEmptyFieldValue(ObjectRepository.mmbrVerifyDOB);
					verifyEmptyFieldValue(ObjectRepository.addSSN);
					verifyEmptyFieldValue(ObjectRepository.addPhone);
					verifyDropdownSelection(ObjectRepository.addPhoneType,"Phone Type");
					verifyEmptyFieldValue(ObjectRepository.addEmail);
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
			test.log(Status.PASS, "Verify beneficiary removed for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
